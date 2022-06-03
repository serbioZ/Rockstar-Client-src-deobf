// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenDeadBush extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllIIIllIIIIIIIllIlllIlI, final Random lllllllllllIIIllIIIIIIIllIlllIIl, BlockPos lllllllllllIIIllIIIIIIIllIlllIII) {
        for (IBlockState lllllllllllIIIllIIIIIIIllIllllIl = lllllllllllIIIllIIIIIIIllIlllIlI.getBlockState(lllllllllllIIIllIIIIIIIllIlllIII); (lllllllllllIIIllIIIIIIIllIllllIl.getMaterial() == Material.AIR || lllllllllllIIIllIIIIIIIllIllllIl.getMaterial() == Material.LEAVES) && lllllllllllIIIllIIIIIIIllIlllIII.getY() > 0; lllllllllllIIIllIIIIIIIllIlllIII = lllllllllllIIIllIIIIIIIllIlllIII.down(), lllllllllllIIIllIIIIIIIllIllllIl = lllllllllllIIIllIIIIIIIllIlllIlI.getBlockState(lllllllllllIIIllIIIIIIIllIlllIII)) {}
        for (int lllllllllllIIIllIIIIIIIllIllllII = 0; lllllllllllIIIllIIIIIIIllIllllII < 4; ++lllllllllllIIIllIIIIIIIllIllllII) {
            final BlockPos lllllllllllIIIllIIIIIIIllIlllIll = lllllllllllIIIllIIIIIIIllIlllIII.add(lllllllllllIIIllIIIIIIIllIlllIIl.nextInt(8) - lllllllllllIIIllIIIIIIIllIlllIIl.nextInt(8), lllllllllllIIIllIIIIIIIllIlllIIl.nextInt(4) - lllllllllllIIIllIIIIIIIllIlllIIl.nextInt(4), lllllllllllIIIllIIIIIIIllIlllIIl.nextInt(8) - lllllllllllIIIllIIIIIIIllIlllIIl.nextInt(8));
            if (lllllllllllIIIllIIIIIIIllIlllIlI.isAirBlock(lllllllllllIIIllIIIIIIIllIlllIll) && Blocks.DEADBUSH.canBlockStay(lllllllllllIIIllIIIIIIIllIlllIlI, lllllllllllIIIllIIIIIIIllIlllIll, Blocks.DEADBUSH.getDefaultState())) {
                lllllllllllIIIllIIIIIIIllIlllIlI.setBlockState(lllllllllllIIIllIIIIIIIllIlllIll, Blocks.DEADBUSH.getDefaultState(), 2);
            }
        }
        return true;
    }
}
