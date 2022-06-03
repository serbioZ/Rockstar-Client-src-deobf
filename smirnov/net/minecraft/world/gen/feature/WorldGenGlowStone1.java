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

public class WorldGenGlowStone1 extends WorldGenerator
{
    @Override
    public boolean generate(final World llIlllIlIllIllI, final Random llIlllIlIllllII, final BlockPos llIlllIlIllIlII) {
        if (!llIlllIlIllIllI.isAirBlock(llIlllIlIllIlII)) {
            return false;
        }
        if (llIlllIlIllIllI.getBlockState(llIlllIlIllIlII.up()).getBlock() != Blocks.NETHERRACK) {
            return false;
        }
        llIlllIlIllIllI.setBlockState(llIlllIlIllIlII, Blocks.GLOWSTONE.getDefaultState(), 2);
        for (int llIlllIlIlllIlI = 0; llIlllIlIlllIlI < 1500; ++llIlllIlIlllIlI) {
            final BlockPos llIlllIlIlllIIl = llIlllIlIllIlII.add(llIlllIlIllllII.nextInt(8) - llIlllIlIllllII.nextInt(8), -llIlllIlIllllII.nextInt(12), llIlllIlIllllII.nextInt(8) - llIlllIlIllllII.nextInt(8));
            if (llIlllIlIllIllI.getBlockState(llIlllIlIlllIIl).getMaterial() == Material.AIR) {
                int llIlllIlIlllIII = 0;
                char llIlllIlIlIllIl;
                for (double llIlllIlIlIlllI = ((EnumFacing[])(Object)(llIlllIlIlIllIl = (char)(Object)EnumFacing.values())).length, llIlllIlIlIllll = 0; llIlllIlIlIllll < llIlllIlIlIlllI; ++llIlllIlIlIllll) {
                    final EnumFacing llIlllIlIllIlll = llIlllIlIlIllIl[llIlllIlIlIllll];
                    if (llIlllIlIllIllI.getBlockState(llIlllIlIlllIIl.offset(llIlllIlIllIlll)).getBlock() == Blocks.GLOWSTONE) {
                        ++llIlllIlIlllIII;
                    }
                    if (llIlllIlIlllIII > 1) {
                        break;
                    }
                }
                if (llIlllIlIlllIII == 1) {
                    llIlllIlIllIllI.setBlockState(llIlllIlIlllIIl, Blocks.GLOWSTONE.getDefaultState(), 2);
                }
            }
        }
        return true;
    }
}
