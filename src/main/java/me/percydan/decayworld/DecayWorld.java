package me.percydan.decayworld;

import me.percydan.decayworld.generator.DecayGenerator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Logger;

public final class DecayWorld extends JavaPlugin {
    private final Logger LOGGER = Logger.getLogger(getName());

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
        return new DecayGenerator();
    }
}
