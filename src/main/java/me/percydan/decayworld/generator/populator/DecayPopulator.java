package me.percydan.decayworld.generator.populator;

import org.bukkit.block.data.BlockData;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.LimitedRegion;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class DecayPopulator extends BlockPopulator {
    @Override
    public void populate(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull LimitedRegion limitedRegion) {
        int startX = chunkX << 4;
        int startZ = chunkZ << 4;
        long k = (long) chunkX * chunkX + (long) chunkZ * chunkZ;
        int l = Math.min((int)Math.floor(Math.sqrt(k) / 3.0 + 1.0), 16);
        int m = random.nextInt((int)Math.min(k / 2 + 1, 32768));
        int minY = worldInfo.getMinHeight();
        int maxY = worldInfo.getMaxHeight() - 1;

        for (int n = 0; n < m; ++n) {
            int x1 = startX + random.nextInt(16);
            int z1 = startZ + random.nextInt(16);
            int topY = limitedRegion.getHighestBlockYAt(x1, z1);

            int yBound = (topY - minY) + 5;
            int y1 = Math.min(minY + (yBound > 0 ? random.nextInt(yBound) : 0), maxY);

            int x2 = startX + ((x1 + random.nextInt(l)) & 15);
            int y2 = Math.min(y1 + random.nextInt(l), maxY);
            int z2 = startZ + ((z1 + random.nextInt(l)) & 15);

            BlockData block1 = limitedRegion.getBlockData(x1, y1, z1);
            BlockData block2 = limitedRegion.getBlockData(x2, y2, z2);
            limitedRegion.setBlockData(x1, y1, z1, block2);
            limitedRegion.setBlockData(x2, y2, z2, block1);
        }
    }
}
