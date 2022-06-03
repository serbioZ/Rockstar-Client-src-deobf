// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.IBlockState;
import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;

public class BlockGlass extends BlockBreakable
{
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    public BlockGlass(final Material llllllllllllIIlIIlIlIlIIlIlIlllI, final boolean llllllllllllIIlIIlIlIlIIlIllIIII) {
        super(llllllllllllIIlIIlIlIlIIlIlIlllI, llllllllllllIIlIIlIlIlIIlIllIIII);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllIIlIIlIlIlIIlIlIlIll) {
        return 0;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIIlIIlIlIlIIlIlIlIII) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}
