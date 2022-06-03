// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenMelon extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllIIllIlIlIIIIlIIIlIII, final Random llllllllllllIIllIlIlIIIIlIIIIlll, final BlockPos llllllllllllIIllIlIlIIIIlIIIlIll) {
        for (int llllllllllllIIllIlIlIIIIlIIIlIlI = 0; llllllllllllIIllIlIlIIIIlIIIlIlI < 64; ++llllllllllllIIllIlIlIIIIlIIIlIlI) {
            final BlockPos llllllllllllIIllIlIlIIIIlIIIlIIl = llllllllllllIIllIlIlIIIIlIIIlIll.add(llllllllllllIIllIlIlIIIIlIIIIlll.nextInt(8) - llllllllllllIIllIlIlIIIIlIIIIlll.nextInt(8), llllllllllllIIllIlIlIIIIlIIIIlll.nextInt(4) - llllllllllllIIllIlIlIIIIlIIIIlll.nextInt(4), llllllllllllIIllIlIlIIIIlIIIIlll.nextInt(8) - llllllllllllIIllIlIlIIIIlIIIIlll.nextInt(8));
            if (Blocks.MELON_BLOCK.canPlaceBlockAt(llllllllllllIIllIlIlIIIIlIIIlIII, llllllllllllIIllIlIlIIIIlIIIlIIl) && llllllllllllIIllIlIlIIIIlIIIlIII.getBlockState(llllllllllllIIllIlIlIIIIlIIIlIIl.down()).getBlock() == Blocks.GRASS) {
                llllllllllllIIllIlIlIIIIlIIIlIII.setBlockState(llllllllllllIIllIlIlIIIIlIIIlIIl, Blocks.MELON_BLOCK.getDefaultState(), 2);
            }
        }
        return true;
    }
}
