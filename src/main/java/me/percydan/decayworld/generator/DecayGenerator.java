package me.percydan.decayworld.generator;

import org.bukkit.block.data.BlockData;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class DecayGenerator extends ChunkGenerator {
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
    public void generateCaves(@NotNull WorldInfo worldInfo, @NotNull Random chunkRandom, int i, int j, @NotNull ChunkGenerator.ChunkData chunkData) {
        long k = (long) i * i + (long) j * j;
        int l = Math.min((int)Math.floor(Math.sqrt(k) / 3.0 + 1.0), 16);
        int m = chunkRandom.nextInt((int)Math.min(k / 2 + 1, 32768));
        int minHeight = chunkData.getMinHeight();
        int maxHeight = chunkData.getMaxHeight();
        for (int n = 0; n < m; ++n) {
            int o = chunkRandom.nextInt(16);
            int p = chunkRandom.nextInt(16);
            int q = minHeight;

            for (int y = maxHeight - 1; y >= minHeight; y--) {
                if (!chunkData.getType(o, y, p).isAir()) {
                    q = y;
                    break;
                }
            }

            int r = chunkRandom.nextInt(q + 5);

            int x2 = chunkRandom.nextInt(l);
            int y2 = chunkRandom.nextInt(l);
            int z2 = chunkRandom.nextInt(l);
            BlockData block1 = chunkData.getBlockData(o, r, p);
            BlockData block2 = chunkData.getBlockData(x2, y2, z2);
            chunkData.setBlock(o, r, p, block2);
            chunkData.setBlock(x2, y2, z2, block1);
        }
    }
}
