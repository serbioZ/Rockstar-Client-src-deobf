// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenGlowStone2 extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllllIIIIIlIllllIlIllIIl, final Random lllllllllllllIIIIIlIllllIlIllIII, final BlockPos lllllllllllllIIIIIlIllllIlIlIlll) {
        if (!lllllllllllllIIIIIlIllllIlIllIIl.isAirBlock(lllllllllllllIIIIIlIllllIlIlIlll)) {
            return false;
        }
        if (lllllllllllllIIIIIlIllllIlIllIIl.getBlockState(lllllllllllllIIIIIlIllllIlIlIlll.up()).getBlock() != Blocks.NETHERRACK) {
            return false;
        }
        lllllllllllllIIIIIlIllllIlIllIIl.setBlockState(lllllllllllllIIIIIlIllllIlIlIlll, Blocks.GLOWSTONE.getDefaultState(), 2);
        for (int lllllllllllllIIIIIlIllllIlIlllIl = 0; lllllllllllllIIIIIlIllllIlIlllIl < 1500; ++lllllllllllllIIIIIlIllllIlIlllIl) {
            final BlockPos lllllllllllllIIIIIlIllllIlIlllII = lllllllllllllIIIIIlIllllIlIlIlll.add(lllllllllllllIIIIIlIllllIlIllIII.nextInt(8) - lllllllllllllIIIIIlIllllIlIllIII.nextInt(8), -lllllllllllllIIIIIlIllllIlIllIII.nextInt(12), lllllllllllllIIIIIlIllllIlIllIII.nextInt(8) - lllllllllllllIIIIIlIllllIlIllIII.nextInt(8));
            if (lllllllllllllIIIIIlIllllIlIllIIl.getBlockState(lllllllllllllIIIIIlIllllIlIlllII).getMaterial() == Material.AIR) {
                int lllllllllllllIIIIIlIllllIlIllIll = 0;
                long lllllllllllllIIIIIlIllllIlIlIIII;
                for (Exception lllllllllllllIIIIIlIllllIlIlIIIl = (Exception)((EnumFacing[])(Object)(lllllllllllllIIIIIlIllllIlIlIIII = (long)(Object)EnumFacing.values())).length, lllllllllllllIIIIIlIllllIlIlIIlI = (Exception)0; lllllllllllllIIIIIlIllllIlIlIIlI < lllllllllllllIIIIIlIllllIlIlIIIl; ++lllllllllllllIIIIIlIllllIlIlIIlI) {
                    final EnumFacing lllllllllllllIIIIIlIllllIlIllIlI = lllllllllllllIIIIIlIllllIlIlIIII[lllllllllllllIIIIIlIllllIlIlIIlI];
                    if (lllllllllllllIIIIIlIllllIlIllIIl.getBlockState(lllllllllllllIIIIIlIllllIlIlllII.offset(lllllllllllllIIIIIlIllllIlIllIlI)).getBlock() == Blocks.GLOWSTONE) {
                        ++lllllllllllllIIIIIlIllllIlIllIll;
                    }
                    if (lllllllllllllIIIIIlIllllIlIllIll > 1) {
                        break;
                    }
                }
                if (lllllllllllllIIIIIlIllllIlIllIll == 1) {
                    lllllllllllllIIIIIlIllllIlIllIIl.setBlockState(lllllllllllllIIIIIlIllllIlIlllII, Blocks.GLOWSTONE.getDefaultState(), 2);
                }
            }
        }
        return true;
    }
}
