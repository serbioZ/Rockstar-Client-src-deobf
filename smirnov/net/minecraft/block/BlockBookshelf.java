// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;
import java.util.Random;

public class BlockBookshelf extends Block
{
    @Override
    public int quantityDropped(final Random llllllllllIllllllIIIIIIIlIIlllll) {
        return 3;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllIllllllIIIIIIIlIIlllIl, final Random llllllllllIllllllIIIIIIIlIIlllII, final int llllllllllIllllllIIIIIIIlIIllIll) {
        return Items.BOOK;
    }
    
    public BlockBookshelf() {
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
