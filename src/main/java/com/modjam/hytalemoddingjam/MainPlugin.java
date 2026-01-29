package com.modjam.hytalemoddingjam;

import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.plugin.PluginBase;
import com.hypixel.hytale.server.core.plugin.PluginType;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class MainPlugin extends PluginBase {
    public MainPlugin(@NonNullDecl JavaPluginInit init) { super(init); }

    @Override
    protected void setup(){

    }

    @NonNullDecl
    @Override
    public PluginType getType() {
        return PluginType.PLUGIN;
    }
}
