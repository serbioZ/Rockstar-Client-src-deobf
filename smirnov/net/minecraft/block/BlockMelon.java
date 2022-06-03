// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;
import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockMelon extends Block
{
    protected BlockMelon() {
        super(Material.GOURD, MapColor.LIME);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllIlllllllllllIIIIIllIll) {
        return 3 + llllllllllIlllllllllllIIIIIllIll.nextInt(5);
    }
    
    @Override
    public int quantityDroppedWithBonus(final int llllllllllIlllllllllllIIIIIlIIlI, final Random llllllllllIlllllllllllIIIIIlIIIl) {
        return Math.min(9, this.quantityDropped(llllllllllIlllllllllllIIIIIlIIIl) + llllllllllIlllllllllllIIIIIlIIIl.nextInt(1 + llllllllllIlllllllllllIIIIIlIIlI));
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllIlllllllllllIIIIlIIIII, final Random llllllllllIlllllllllllIIIIIlllll, final int llllllllllIlllllllllllIIIIIllllI) {
        return Items.MELON;
    }
}
