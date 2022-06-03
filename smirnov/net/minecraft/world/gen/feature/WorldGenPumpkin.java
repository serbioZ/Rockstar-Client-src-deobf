// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenPumpkin extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllIlllIIIllIlllIlIIIlll, final Random lllllllllllIlllIIIllIlllIlIIIllI, final BlockPos lllllllllllIlllIIIllIlllIlIIIIII) {
        for (int lllllllllllIlllIIIllIlllIlIIIlII = 0; lllllllllllIlllIIIllIlllIlIIIlII < 64; ++lllllllllllIlllIIIllIlllIlIIIlII) {
            final BlockPos lllllllllllIlllIIIllIlllIlIIIIll = lllllllllllIlllIIIllIlllIlIIIIII.add(lllllllllllIlllIIIllIlllIlIIIllI.nextInt(8) - lllllllllllIlllIIIllIlllIlIIIllI.nextInt(8), lllllllllllIlllIIIllIlllIlIIIllI.nextInt(4) - lllllllllllIlllIIIllIlllIlIIIllI.nextInt(4), lllllllllllIlllIIIllIlllIlIIIllI.nextInt(8) - lllllllllllIlllIIIllIlllIlIIIllI.nextInt(8));
            if (lllllllllllIlllIIIllIlllIlIIIlll.isAirBlock(lllllllllllIlllIIIllIlllIlIIIIll) && lllllllllllIlllIIIllIlllIlIIIlll.getBlockState(lllllllllllIlllIIIllIlllIlIIIIll.down()).getBlock() == Blocks.GRASS && Blocks.PUMPKIN.canPlaceBlockAt(lllllllllllIlllIIIllIlllIlIIIlll, lllllllllllIlllIIIllIlllIlIIIIll)) {
                lllllllllllIlllIIIllIlllIlIIIlll.setBlockState(lllllllllllIlllIIIllIlllIlIIIIll, Blocks.PUMPKIN.getDefaultState().withProperty((IProperty<Comparable>)BlockPumpkin.FACING, EnumFacing.Plane.HORIZONTAL.random(lllllllllllIlllIIIllIlllIlIIIllI)), 2);
            }
        }
        return true;
    }
}
