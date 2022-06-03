// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;

public class BlockObsidian extends Block
{
    public BlockObsidian() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIIllIIIllIIllIIIIlIl, final Random lllllllllllIIIllIIIllIIllIIIIlII, final int lllllllllllIIIllIIIllIIllIIIIIll) {
        return Item.getItemFromBlock(Blocks.OBSIDIAN);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllIIIllIIIllIIllIIIIIIl, final IBlockAccess lllllllllllIIIllIIIllIIllIIIIIII, final BlockPos lllllllllllIIIllIIIllIIlIlllllll) {
        return MapColor.BLACK;
    }
}
