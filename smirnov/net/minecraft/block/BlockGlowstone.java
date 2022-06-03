// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.math.MathHelper;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;

public class BlockGlowstone extends Block
{
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIlllIIlIIIlllllIllII, final Random llllllllllllIlllIIlIIIlllllIlIll, final int llllllllllllIlllIIlIIIlllllIlIlI) {
        return Items.GLOWSTONE_DUST;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllIlllIIlIIIlllllIllll) {
        return 2 + llllllllllllIlllIIlIIIlllllIllll.nextInt(3);
    }
    
    public BlockGlowstone(final Material llllllllllllIlllIIlIIIlllllllIll) {
        super(llllllllllllIlllIIlIIIlllllllIll);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllIlllIIlIIIlllllIlIII, final IBlockAccess llllllllllllIlllIIlIIIlllllIIlll, final BlockPos llllllllllllIlllIIlIIIlllllIIllI) {
        return MapColor.SAND;
    }
    
    @Override
    public int quantityDroppedWithBonus(final int llllllllllllIlllIIlIIIllllllIllI, final Random llllllllllllIlllIIlIIIllllllIIlI) {
        return MathHelper.clamp(this.quantityDropped(llllllllllllIlllIIlIIIllllllIIlI) + llllllllllllIlllIIlIIIllllllIIlI.nextInt(llllllllllllIlllIIlIIIllllllIllI + 1), 1, 4);
    }
}
