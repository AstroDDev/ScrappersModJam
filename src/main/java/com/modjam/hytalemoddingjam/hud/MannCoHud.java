package com.modjam.hytalemoddingjam.hud;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.entities.player.hud.CustomUIHud;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;

class MannCoHud extends CustomUIHud {

    public static void giveHud(PlayerRef playerRef) {
        MannCoHud mannCoHud = new MannCoHud(playerRef);
        Ref<EntityStore> ref = playerRef.getReference();
        Player player = ref.getStore().getComponent(ref, Player.getComponentType());
        player.getHudManager().setCustomHud(playerRef, mannCoHud);
    }

    private MannCoHud(@Nonnull PlayerRef playerRef) {
        super(playerRef);
    }

    @Override
    protected void build(@Nonnull UICommandBuilder builder) {
        builder.append("Hud.ui");
    }
}
