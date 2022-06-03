// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.block.properties.PropertyEnum;

public abstract class BlockPurpurSlab extends BlockSlab
{
    public static final /* synthetic */ PropertyEnum<Variant> VARIANT;
    
    @Override
    public Comparable<?> getTypeForItem(final ItemStack llllllllllllIlIlIllIIIIlllIlIlII) {
        return Variant.DEFAULT;
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", Variant.class);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIlIllIIIIlllIlllll) {
        int llllllllllllIlIlIllIIIIllllIIIIl = 0;
        if (!this.isDouble() && llllllllllllIlIlIllIIIIlllIlllll.getValue(BlockPurpurSlab.HALF) == EnumBlockHalf.TOP) {
            llllllllllllIlIlIllIIIIllllIIIIl |= 0x8;
        }
        return llllllllllllIlIlIllIIIIllllIIIIl;
    }
    
    @Override
    public String getUnlocalizedName(final int llllllllllllIlIlIllIIIIlllIllIII) {
        return super.getUnlocalizedName();
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIlIlIllIIIIlllllIllI, final Random llllllllllllIlIlIllIIIIlllllIlIl, final int llllllllllllIlIlIllIIIIlllllIlII) {
        return Item.getItemFromBlock(Blocks.PURPUR_SLAB);
    }
    
    public BlockPurpurSlab() {
        super(Material.ROCK, MapColor.MAGENTA);
        IBlockState llllllllllllIlIlIllIIIIllllllIlI = this.blockState.getBaseState();
        if (!this.isDouble()) {
            llllllllllllIlIlIllIIIIllllllIlI = llllllllllllIlIlIllIIIIllllllIlI.withProperty(BlockPurpurSlab.HALF, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(llllllllllllIlIlIllIIIIllllllIlI.withProperty(BlockPurpurSlab.VARIANT, Variant.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPurpurSlab.VARIANT }) : new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPurpurSlab.HALF, BlockPurpurSlab.VARIANT });
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIlIlIllIIIIlllllIIlI, final BlockPos llllllllllllIlIlIllIIIIlllllIIIl, final IBlockState llllllllllllIlIlIllIIIIlllllIIII) {
        return new ItemStack(Blocks.PURPUR_SLAB);
    }
    
    @Override
    public IProperty<?> getVariantProperty() {
        return BlockPurpurSlab.VARIANT;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIlIllIIIIllllIlIll) {
        IBlockState llllllllllllIlIlIllIIIIllllIlIlI = this.getDefaultState().withProperty(BlockPurpurSlab.VARIANT, Variant.DEFAULT);
        if (!this.isDouble()) {
            llllllllllllIlIlIllIIIIllllIlIlI = llllllllllllIlIlIllIIIIllllIlIlI.withProperty(BlockPurpurSlab.HALF, ((llllllllllllIlIlIllIIIIllllIlIll & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return llllllllllllIlIlIllIIIIllllIlIlI;
    }
    
    public enum Variant implements IStringSerializable
    {
        DEFAULT("DEFAULT", 0);
        
        private Variant(final String llllllllllIllllIlllllIIIlIlIllll, final int llllllllllIllllIlllllIIIlIlIlllI) {
        }
        
        @Override
        public String getName() {
            return "default";
        }
    }
    
    public static class Double extends BlockPurpurSlab
    {
        @Override
        public boolean isDouble() {
            return true;
        }
    }
    
    public static class Half extends BlockPurpurSlab
    {
        @Override
        public boolean isDouble() {
            return false;
        }
    }
}
