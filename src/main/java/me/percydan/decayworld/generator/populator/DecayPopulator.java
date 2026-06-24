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
        long k = (long) chunkX * chunkX + (long) chunkZ * chunkZ;
        int l = Math.min((int)Math.floor(Math.sqrt(k) / 3.0 + 1.0), 16);
        int m = random.nextInt((int)Math.min(k / 2 + 1, 32768));

        for (int n = 0; n < m; ++n) {
            int o = 16 * chunkX + random.nextInt(16);
            int p = 16 * chunkZ + random.nextInt(16);
            int q = limitedRegion.getHighestBlockYAt(o, p);

            int r = random.nextInt(q + 5);

            int x2 = o + random.nextInt(l);
            int y2 = r + random.nextInt(l);
            int z2 = p + random.nextInt(l);
            if (limitedRegion.isInRegion(o, r, p) && limitedRegion.isInRegion(x2, y2, z2)) {
                BlockData block1 = limitedRegion.getBlockData(o, r, p);
                BlockData block2 = limitedRegion.getBlockData(x2, y2, z2);
                limitedRegion.setBlockData(o, r, p, block2);
                limitedRegion.setBlockData(x2, y2, z2, block1);
            }
        }
    }
}
