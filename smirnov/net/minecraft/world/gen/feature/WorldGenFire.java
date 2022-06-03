// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenFire extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllIIllIlIlIIllIIIIIIll, final Random llllllllllllIIllIlIlIIllIIIIIIlI, final BlockPos llllllllllllIIllIlIlIIllIIIIIIIl) {
        for (int llllllllllllIIllIlIlIIllIIIIIIII = 0; llllllllllllIIllIlIlIIllIIIIIIII < 64; ++llllllllllllIIllIlIlIIllIIIIIIII) {
            final BlockPos llllllllllllIIllIlIlIIlIllllllll = llllllllllllIIllIlIlIIllIIIIIIIl.add(llllllllllllIIllIlIlIIllIIIIIIlI.nextInt(8) - llllllllllllIIllIlIlIIllIIIIIIlI.nextInt(8), llllllllllllIIllIlIlIIllIIIIIIlI.nextInt(4) - llllllllllllIIllIlIlIIllIIIIIIlI.nextInt(4), llllllllllllIIllIlIlIIllIIIIIIlI.nextInt(8) - llllllllllllIIllIlIlIIllIIIIIIlI.nextInt(8));
            if (llllllllllllIIllIlIlIIllIIIIIIll.isAirBlock(llllllllllllIIllIlIlIIlIllllllll) && llllllllllllIIllIlIlIIllIIIIIIll.getBlockState(llllllllllllIIllIlIlIIlIllllllll.down()).getBlock() == Blocks.NETHERRACK) {
                llllllllllllIIllIlIlIIllIIIIIIll.setBlockState(llllllllllllIIllIlIlIIlIllllllll, Blocks.FIRE.getDefaultState(), 2);
            }
        }
        return true;
    }
}
