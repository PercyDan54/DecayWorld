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
        int offsetX = 0;
        int offsetZ = 0;

        if (id != null && !id.isBlank()) {
            String[] parts = id.split(",");

            if (parts.length >= 1) {
                try {
                    offsetX = offsetZ = Integer.parseInt(parts[0]);
                }
                catch (NumberFormatException ignored) { }

                if (parts.length >= 2) {
                    try {
                        offsetZ = Integer.parseInt(parts[1]);
                    }
                    catch (NumberFormatException ignored) { }
                }
            }
        }
        return new DecayGenerator(offsetX, offsetZ);
    }
}
