// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenWaterlily extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllllIIIllllIIlIlIlIIIlI, final Random lllllllllllllIIIllllIIlIlIIllIlI, final BlockPos lllllllllllllIIIllllIIlIlIlIIIII) {
        for (int lllllllllllllIIIllllIIlIlIIlllll = 0; lllllllllllllIIIllllIIlIlIIlllll < 10; ++lllllllllllllIIIllllIIlIlIIlllll) {
            final int lllllllllllllIIIllllIIlIlIIllllI = lllllllllllllIIIllllIIlIlIlIIIII.getX() + lllllllllllllIIIllllIIlIlIIllIlI.nextInt(8) - lllllllllllllIIIllllIIlIlIIllIlI.nextInt(8);
            final int lllllllllllllIIIllllIIlIlIIlllIl = lllllllllllllIIIllllIIlIlIlIIIII.getY() + lllllllllllllIIIllllIIlIlIIllIlI.nextInt(4) - lllllllllllllIIIllllIIlIlIIllIlI.nextInt(4);
            final int lllllllllllllIIIllllIIlIlIIlllII = lllllllllllllIIIllllIIlIlIlIIIII.getZ() + lllllllllllllIIIllllIIlIlIIllIlI.nextInt(8) - lllllllllllllIIIllllIIlIlIIllIlI.nextInt(8);
            if (lllllllllllllIIIllllIIlIlIlIIIlI.isAirBlock(new BlockPos(lllllllllllllIIIllllIIlIlIIllllI, lllllllllllllIIIllllIIlIlIIlllIl, lllllllllllllIIIllllIIlIlIIlllII)) && Blocks.WATERLILY.canPlaceBlockAt(lllllllllllllIIIllllIIlIlIlIIIlI, new BlockPos(lllllllllllllIIIllllIIlIlIIllllI, lllllllllllllIIIllllIIlIlIIlllIl, lllllllllllllIIIllllIIlIlIIlllII))) {
                lllllllllllllIIIllllIIlIlIlIIIlI.setBlockState(new BlockPos(lllllllllllllIIIllllIIlIlIIllllI, lllllllllllllIIIllllIIlIlIIlllIl, lllllllllllllIIIllllIIlIlIIlllII), Blocks.WATERLILY.getDefaultState(), 2);
            }
        }
        return true;
    }
}
