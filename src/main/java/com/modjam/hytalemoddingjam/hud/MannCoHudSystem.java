package com.modjam.hytalemoddingjam.hud;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.tick.EntityTickingSystem;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.entities.player.hud.CustomUIHud;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.modjam.hytalemoddingjam.gameLogic.GameLogic;

import javax.annotation.Nonnull;

public class MannCoHudSystem extends EntityTickingSystem<EntityStore> {

    private static final long ANNOUNCEMENT_LENGTH_MILLIS = 2000;
    private final GameLogic gameLogic;

    public MannCoHudSystem(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @Nonnull
    @Override
    public Query<EntityStore> getQuery() {
        // TODO need a component to determine if player in game or not
        return Player.getComponentType();
    }

    @Override
    public void tick(float dt, int index, @Nonnull ArchetypeChunk<EntityStore> archetypeChunk, @Nonnull Store<EntityStore> store, @Nonnull CommandBuffer<EntityStore> commandBuffer) {
        Player player = archetypeChunk.getComponent(index, Player.getComponentType());

        if (player.getWorld().getName().equals("default")) return;

        UICommandBuilder builder = new UICommandBuilder();
        if (System.currentTimeMillis() - gameLogic.getWaveHelper().getWaveStartTime() < ANNOUNCEMENT_LENGTH_MILLIS) {
            if (gameLogic.getWaveHelper().isIntermission()) {
                builder.set("#BannerTitle", "Wave " + (gameLogic.getWaveHelper().getWaveIndex() + 1) + " Over!");
            } else {
                builder.set("#BannerTitle", "Wave " + (gameLogic.getWaveHelper().getWaveIndex() + 1) + " Incoming!");
            }
        }

        CustomUIHud customHud = player.getHudManager().getCustomHud();
        if (customHud != null) {
            customHud.update(true, builder);
        }
    }

}
