// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import java.util.Random;

public class BlockClay extends Block
{
    @Override
    public int quantityDropped(final Random llllllllllllIlIlllIlllIIlllllIll) {
        return 4;
    }
    
    public BlockClay() {
        super(Material.CLAY);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIlIlllIlllIIllllllll, final Random llllllllllllIlIlllIlllIIlllllllI, final int llllllllllllIlIlllIlllIIllllllIl) {
        return Items.CLAY_BALL;
    }
}
