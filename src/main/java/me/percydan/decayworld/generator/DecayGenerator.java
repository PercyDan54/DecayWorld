package me.percydan.decayworld.generator;

import me.percydan.decayworld.generator.populator.DecayPopulator;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DecayGenerator extends ChunkGenerator {
    private final int offsetX;
    private final int offsetZ;

    public DecayGenerator() {
        this(0,0);
    }

    public DecayGenerator(int offsetX, int offsetZ) {
        this.offsetX = offsetX;
        this.offsetZ = offsetZ;
    }

    @Override
    public boolean shouldGenerateNoise() {
        return true;
    }

    @Override
    public boolean shouldGenerateSurface() {
        return true;
    }

    @Override
    public boolean shouldGenerateCaves() {
        return true;
    }

    @Override
    public boolean shouldGenerateDecorations() {
        return true;
    }

    @Override
    public boolean shouldGenerateStructures() {
        return true;
    }

    @Override
    public boolean shouldGenerateMobs() {
        return true;
    }

    @Override
    @NotNull
    public List<BlockPopulator> getDefaultPopulators(@NotNull World world) {
        return List.of(new DecayPopulator(offsetX, offsetZ));
    }
}
