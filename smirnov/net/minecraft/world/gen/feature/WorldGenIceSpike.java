// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenIceSpike extends WorldGenerator
{
    @Override
    public boolean generate(final World lIIIllIllIlI, final Random lIIIlllIllll, BlockPos lIIIllIllIII) {
        while (lIIIllIllIlI.isAirBlock(lIIIllIllIII) && lIIIllIllIII.getY() > 2) {
            lIIIllIllIII = lIIIllIllIII.down();
        }
        if (lIIIllIllIlI.getBlockState(lIIIllIllIII).getBlock() != Blocks.SNOW) {
            return false;
        }
        lIIIllIllIII = lIIIllIllIII.up(lIIIlllIllll.nextInt(4));
        final int lIIIlllIllIl = lIIIlllIllll.nextInt(4) + 7;
        final int lIIIlllIllII = lIIIlllIllIl / 4 + lIIIlllIllll.nextInt(2);
        if (lIIIlllIllII > 1 && lIIIlllIllll.nextInt(60) == 0) {
            lIIIllIllIII = lIIIllIllIII.up(10 + lIIIlllIllll.nextInt(30));
        }
        for (int lIIIlllIlIll = 0; lIIIlllIlIll < lIIIlllIllIl; ++lIIIlllIlIll) {
            final float lIIIlllIlIlI = (1.0f - lIIIlllIlIll / (float)lIIIlllIllIl) * lIIIlllIllII;
            for (int lIIIlllIlIIl = MathHelper.ceil(lIIIlllIlIlI), lIIIlllIlIII = -lIIIlllIlIIl; lIIIlllIlIII <= lIIIlllIlIIl; ++lIIIlllIlIII) {
                final float lIIIlllIIlll = MathHelper.abs(lIIIlllIlIII) - 0.25f;
                for (int lIIIlllIIllI = -lIIIlllIlIIl; lIIIlllIIllI <= lIIIlllIlIIl; ++lIIIlllIIllI) {
                    final float lIIIlllIIlIl = MathHelper.abs(lIIIlllIIllI) - 0.25f;
                    if (((lIIIlllIlIII == 0 && lIIIlllIIllI == 0) || lIIIlllIIlll * lIIIlllIIlll + lIIIlllIIlIl * lIIIlllIIlIl <= lIIIlllIlIlI * lIIIlllIlIlI) && ((lIIIlllIlIII != -lIIIlllIlIIl && lIIIlllIlIII != lIIIlllIlIIl && lIIIlllIIllI != -lIIIlllIlIIl && lIIIlllIIllI != lIIIlllIlIIl) || lIIIlllIllll.nextFloat() <= 0.75f)) {
                        IBlockState lIIIlllIIlII = lIIIllIllIlI.getBlockState(lIIIllIllIII.add(lIIIlllIlIII, lIIIlllIlIll, lIIIlllIIllI));
                        Block lIIIlllIIIll = lIIIlllIIlII.getBlock();
                        if (lIIIlllIIlII.getMaterial() == Material.AIR || lIIIlllIIIll == Blocks.DIRT || lIIIlllIIIll == Blocks.SNOW || lIIIlllIIIll == Blocks.ICE) {
                            this.setBlockAndNotifyAdequately(lIIIllIllIlI, lIIIllIllIII.add(lIIIlllIlIII, lIIIlllIlIll, lIIIlllIIllI), Blocks.PACKED_ICE.getDefaultState());
                        }
                        if (lIIIlllIlIll != 0 && lIIIlllIlIIl > 1) {
                            lIIIlllIIlII = lIIIllIllIlI.getBlockState(lIIIllIllIII.add(lIIIlllIlIII, -lIIIlllIlIll, lIIIlllIIllI));
                            lIIIlllIIIll = lIIIlllIIlII.getBlock();
                            if (lIIIlllIIlII.getMaterial() == Material.AIR || lIIIlllIIIll == Blocks.DIRT || lIIIlllIIIll == Blocks.SNOW || lIIIlllIIIll == Blocks.ICE) {
                                this.setBlockAndNotifyAdequately(lIIIllIllIlI, lIIIllIllIII.add(lIIIlllIlIII, -lIIIlllIlIll, lIIIlllIIllI), Blocks.PACKED_ICE.getDefaultState());
                            }
                        }
                    }
                }
            }
        }
        int lIIIlllIIIlI = lIIIlllIllII - 1;
        if (lIIIlllIIIlI < 0) {
            lIIIlllIIIlI = 0;
        }
        else if (lIIIlllIIIlI > 1) {
            lIIIlllIIIlI = 1;
        }
        for (int lIIIlllIIIIl = -lIIIlllIIIlI; lIIIlllIIIIl <= lIIIlllIIIlI; ++lIIIlllIIIIl) {
            for (int lIIIlllIIIII = -lIIIlllIIIlI; lIIIlllIIIII <= lIIIlllIIIlI; ++lIIIlllIIIII) {
                BlockPos lIIIllIlllll = lIIIllIllIII.add(lIIIlllIIIIl, -1, lIIIlllIIIII);
                int lIIIllIllllI = 50;
                if (Math.abs(lIIIlllIIIIl) == 1 && Math.abs(lIIIlllIIIII) == 1) {
                    lIIIllIllllI = lIIIlllIllll.nextInt(5);
                }
                while (lIIIllIlllll.getY() > 50) {
                    final IBlockState lIIIllIlllIl = lIIIllIllIlI.getBlockState(lIIIllIlllll);
                    final Block lIIIllIlllII = lIIIllIlllIl.getBlock();
                    if (lIIIllIlllIl.getMaterial() != Material.AIR && lIIIllIlllII != Blocks.DIRT && lIIIllIlllII != Blocks.SNOW && lIIIllIlllII != Blocks.ICE && lIIIllIlllII != Blocks.PACKED_ICE) {
                        break;
                    }
                    this.setBlockAndNotifyAdequately(lIIIllIllIlI, lIIIllIlllll, Blocks.PACKED_ICE.getDefaultState());
                    lIIIllIlllll = lIIIllIlllll.down();
                    if (--lIIIllIllllI > 0) {
                        continue;
                    }
                    lIIIllIlllll = lIIIllIlllll.down(lIIIlllIllll.nextInt(5) + 1);
                    lIIIllIllllI = lIIIlllIllll.nextInt(5);
                }
            }
        }
        return true;
    }
}
