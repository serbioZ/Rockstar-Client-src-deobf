// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;

public class BlockHardenedClay extends Block
{
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllIlIlIIllIIlllllIlIlIl, final IBlockAccess lllllllllllIlIlIIllIIlllllIlIlII, final BlockPos lllllllllllIlIlIIllIIlllllIlIIll) {
        return MapColor.ADOBE;
    }
    
    public BlockHardenedClay() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
