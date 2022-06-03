// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.MathHelper;
import java.util.Random;

public class BlockSeaLantern extends Block
{
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllIllllIlIIllIlIlIIIlIIl) {
        return 2 + llllllllllIllllIlIIllIlIlIIIlIIl.nextInt(2);
    }
    
    @Override
    public int quantityDroppedWithBonus(final int llllllllllIllllIlIIllIlIlIIIIlII, final Random llllllllllIllllIlIIllIlIlIIIIIll) {
        return MathHelper.clamp(this.quantityDropped(llllllllllIllllIlIIllIlIlIIIIIll) + llllllllllIllllIlIIllIlIlIIIIIll.nextInt(llllllllllIllllIlIIllIlIlIIIIlII + 1), 1, 5);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllIllllIlIIllIlIIllllllI, final Random llllllllllIllllIlIIllIlIIlllllIl, final int llllllllllIllllIlIIllIlIIlllllII) {
        return Items.PRISMARINE_CRYSTALS;
    }
    
    public BlockSeaLantern(final Material llllllllllIllllIlIIllIlIlIIIllIl) {
        super(llllllllllIllllIlIIllIlIlIIIllIl);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllIllllIlIIllIlIIllllIlI, final IBlockAccess llllllllllIllllIlIIllIlIIllllIIl, final BlockPos llllllllllIllllIlIIllIlIIllllIII) {
        return MapColor.QUARTZ;
    }
}
