// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockVine;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenVines extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllIIIIIIlIllIlIlllIIlII, final Random lllllllllllIIIIIIlIllIlIlllIIIll, BlockPos lllllllllllIIIIIIlIllIlIlllIIIlI) {
        while (lllllllllllIIIIIIlIllIlIlllIIIlI.getY() < 128) {
            if (lllllllllllIIIIIIlIllIlIlllIIlII.isAirBlock(lllllllllllIIIIIIlIllIlIlllIIIlI)) {
                final long lllllllllllIIIIIIlIllIlIllIllllI;
                final int lllllllllllIIIIIIlIllIlIllIlllll = ((EnumFacing[])(Object)(lllllllllllIIIIIIlIllIlIllIllllI = (long)(Object)EnumFacing.Plane.HORIZONTAL.facings())).length;
                for (byte lllllllllllIIIIIIlIllIlIlllIIIII = 0; lllllllllllIIIIIIlIllIlIlllIIIII < lllllllllllIIIIIIlIllIlIllIlllll; ++lllllllllllIIIIIIlIllIlIlllIIIII) {
                    final EnumFacing lllllllllllIIIIIIlIllIlIlllIIllI = lllllllllllIIIIIIlIllIlIllIllllI[lllllllllllIIIIIIlIllIlIlllIIIII];
                    if (Blocks.VINE.canPlaceBlockOnSide(lllllllllllIIIIIIlIllIlIlllIIlII, lllllllllllIIIIIIlIllIlIlllIIIlI, lllllllllllIIIIIIlIllIlIlllIIllI)) {
                        final IBlockState lllllllllllIIIIIIlIllIlIlllIIlIl = Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.NORTH, lllllllllllIIIIIIlIllIlIlllIIllI == EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockVine.EAST, lllllllllllIIIIIIlIllIlIlllIIllI == EnumFacing.EAST).withProperty((IProperty<Comparable>)BlockVine.SOUTH, lllllllllllIIIIIIlIllIlIlllIIllI == EnumFacing.SOUTH).withProperty((IProperty<Comparable>)BlockVine.WEST, lllllllllllIIIIIIlIllIlIlllIIllI == EnumFacing.WEST);
                        lllllllllllIIIIIIlIllIlIlllIIlII.setBlockState(lllllllllllIIIIIIlIllIlIlllIIIlI, lllllllllllIIIIIIlIllIlIlllIIlIl, 2);
                        break;
                    }
                }
            }
            else {
                lllllllllllIIIIIIlIllIlIlllIIIlI = lllllllllllIIIIIIlIllIlIlllIIIlI.add(lllllllllllIIIIIIlIllIlIlllIIIll.nextInt(4) - lllllllllllIIIIIIlIllIlIlllIIIll.nextInt(4), 0, lllllllllllIIIIIIlIllIlIlllIIIll.nextInt(4) - lllllllllllIIIIIIlIllIlIlllIIIll.nextInt(4));
            }
            lllllllllllIIIIIIlIllIlIlllIIIlI = lllllllllllIIIIIIlIllIlIlllIIIlI.up();
        }
        return true;
    }
}
