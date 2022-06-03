// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;

public class WorldGenTallGrass extends WorldGenerator
{
    private final /* synthetic */ IBlockState tallGrassState;
    
    public WorldGenTallGrass(final BlockTallGrass.EnumType lllllllllllIIllIIIIIIlIIllIlIIII) {
        this.tallGrassState = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, lllllllllllIIllIIIIIIlIIllIlIIII);
    }
    
    @Override
    public boolean generate(final World lllllllllllIIllIIIIIIlIIllIIIllI, final Random lllllllllllIIllIIIIIIlIIlIlllllI, BlockPos lllllllllllIIllIIIIIIlIIlIllllIl) {
        for (IBlockState lllllllllllIIllIIIIIIlIIllIIIIll = lllllllllllIIllIIIIIIlIIllIIIllI.getBlockState(lllllllllllIIllIIIIIIlIIlIllllIl); (lllllllllllIIllIIIIIIlIIllIIIIll.getMaterial() == Material.AIR || lllllllllllIIllIIIIIIlIIllIIIIll.getMaterial() == Material.LEAVES) && lllllllllllIIllIIIIIIlIIlIllllIl.getY() > 0; lllllllllllIIllIIIIIIlIIlIllllIl = lllllllllllIIllIIIIIIlIIlIllllIl.down(), lllllllllllIIllIIIIIIlIIllIIIIll = lllllllllllIIllIIIIIIlIIllIIIllI.getBlockState(lllllllllllIIllIIIIIIlIIlIllllIl)) {}
        for (int lllllllllllIIllIIIIIIlIIllIIIIlI = 0; lllllllllllIIllIIIIIIlIIllIIIIlI < 128; ++lllllllllllIIllIIIIIIlIIllIIIIlI) {
            final BlockPos lllllllllllIIllIIIIIIlIIllIIIIIl = lllllllllllIIllIIIIIIlIIlIllllIl.add(lllllllllllIIllIIIIIIlIIlIlllllI.nextInt(8) - lllllllllllIIllIIIIIIlIIlIlllllI.nextInt(8), lllllllllllIIllIIIIIIlIIlIlllllI.nextInt(4) - lllllllllllIIllIIIIIIlIIlIlllllI.nextInt(4), lllllllllllIIllIIIIIIlIIlIlllllI.nextInt(8) - lllllllllllIIllIIIIIIlIIlIlllllI.nextInt(8));
            if (lllllllllllIIllIIIIIIlIIllIIIllI.isAirBlock(lllllllllllIIllIIIIIIlIIllIIIIIl) && Blocks.TALLGRASS.canBlockStay(lllllllllllIIllIIIIIIlIIllIIIllI, lllllllllllIIllIIIIIIlIIllIIIIIl, this.tallGrassState)) {
                lllllllllllIIllIIIIIIlIIllIIIllI.setBlockState(lllllllllllIIllIIIIIIlIIllIIIIIl, this.tallGrassState, 2);
            }
        }
        return true;
    }
}
