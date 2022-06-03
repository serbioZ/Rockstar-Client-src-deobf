// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenReed extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllIlIIlIIIIlIllllIIlIl, final Random llllllllllllIlIIlIIIIlIllllIllII, final BlockPos llllllllllllIlIIlIIIIlIllllIIIll) {
        for (int llllllllllllIlIIlIIIIlIllllIlIlI = 0; llllllllllllIlIIlIIIIlIllllIlIlI < 20; ++llllllllllllIlIIlIIIIlIllllIlIlI) {
            final BlockPos llllllllllllIlIIlIIIIlIllllIlIIl = llllllllllllIlIIlIIIIlIllllIIIll.add(llllllllllllIlIIlIIIIlIllllIllII.nextInt(4) - llllllllllllIlIIlIIIIlIllllIllII.nextInt(4), 0, llllllllllllIlIIlIIIIlIllllIllII.nextInt(4) - llllllllllllIlIIlIIIIlIllllIllII.nextInt(4));
            if (llllllllllllIlIIlIIIIlIllllIIlIl.isAirBlock(llllllllllllIlIIlIIIIlIllllIlIIl)) {
                final BlockPos llllllllllllIlIIlIIIIlIllllIlIII = llllllllllllIlIIlIIIIlIllllIlIIl.down();
                if (llllllllllllIlIIlIIIIlIllllIIlIl.getBlockState(llllllllllllIlIIlIIIIlIllllIlIII.west()).getMaterial() == Material.WATER || llllllllllllIlIIlIIIIlIllllIIlIl.getBlockState(llllllllllllIlIIlIIIIlIllllIlIII.east()).getMaterial() == Material.WATER || llllllllllllIlIIlIIIIlIllllIIlIl.getBlockState(llllllllllllIlIIlIIIIlIllllIlIII.north()).getMaterial() == Material.WATER || llllllllllllIlIIlIIIIlIllllIIlIl.getBlockState(llllllllllllIlIIlIIIIlIllllIlIII.south()).getMaterial() == Material.WATER) {
                    for (int llllllllllllIlIIlIIIIlIllllIIlll = 2 + llllllllllllIlIIlIIIIlIllllIllII.nextInt(llllllllllllIlIIlIIIIlIllllIllII.nextInt(3) + 1), llllllllllllIlIIlIIIIlIllllIIllI = 0; llllllllllllIlIIlIIIIlIllllIIllI < llllllllllllIlIIlIIIIlIllllIIlll; ++llllllllllllIlIIlIIIIlIllllIIllI) {
                        if (Blocks.REEDS.canBlockStay(llllllllllllIlIIlIIIIlIllllIIlIl, llllllllllllIlIIlIIIIlIllllIlIIl)) {
                            llllllllllllIlIIlIIIIlIllllIIlIl.setBlockState(llllllllllllIlIIlIIIIlIllllIlIIl.up(llllllllllllIlIIlIIIIlIllllIIllI), Blocks.REEDS.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
