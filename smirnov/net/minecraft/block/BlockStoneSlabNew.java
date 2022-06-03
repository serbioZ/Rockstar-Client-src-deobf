// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;

public abstract class BlockStoneSlabNew extends BlockSlab
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    public static final /* synthetic */ PropertyBool SEAMLESS;
    
    public BlockStoneSlabNew() {
        super(Material.ROCK);
        IBlockState llllllllllllIlIlIllIllIllllIIIIl = this.blockState.getBaseState();
        if (this.isDouble()) {
            llllllllllllIlIlIllIllIllllIIIIl = llllllllllllIlIlIllIllIllllIIIIl.withProperty((IProperty<Comparable>)BlockStoneSlabNew.SEAMLESS, false);
        }
        else {
            llllllllllllIlIlIllIllIllllIIIIl = llllllllllllIlIlIllIllIllllIIIIl.withProperty(BlockStoneSlabNew.HALF, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(llllllllllllIlIlIllIllIllllIIIIl.withProperty(BlockStoneSlabNew.VARIANT, EnumType.RED_SANDSTONE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public String getUnlocalizedName(final int llllllllllllIlIlIllIllIlllIIlllI) {
        return String.valueOf(super.getUnlocalizedName()) + "." + EnumType.byMetadata(llllllllllllIlIlIllIllIlllIIlllI).getUnlocalizedName();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllIlIlIllIllIllIllllll, final NonNullList<ItemStack> llllllllllllIlIlIllIllIllIlllIll) {
        final long llllllllllllIlIlIllIllIllIllIlll;
        final long llllllllllllIlIlIllIllIllIlllIII = ((EnumType[])(Object)(llllllllllllIlIlIllIllIllIllIlll = (long)(Object)EnumType.values())).length;
        for (float llllllllllllIlIlIllIllIllIlllIIl = 0; llllllllllllIlIlIllIllIllIlllIIl < llllllllllllIlIlIllIllIllIlllIII; ++llllllllllllIlIlIllIllIllIlllIIl) {
            final EnumType llllllllllllIlIlIllIllIllIllllIl = llllllllllllIlIlIllIllIllIllIlll[llllllllllllIlIlIllIllIllIlllIIl];
            llllllllllllIlIlIllIllIllIlllIll.add(new ItemStack(this, 1, llllllllllllIlIlIllIllIllIllllIl.getMetadata()));
        }
    }
    
    @Override
    public Comparable<?> getTypeForItem(final ItemStack llllllllllllIlIlIllIllIlllIIIlll) {
        return EnumType.byMetadata(llllllllllllIlIlIllIllIlllIIIlll.getMetadata() & 0x7);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIlIlIllIllIlllIllIlI, final Random llllllllllllIlIlIllIllIlllIllIIl, final int llllllllllllIlIlIllIllIlllIllIII) {
        return Item.getItemFromBlock(Blocks.STONE_SLAB2);
    }
    
    static {
        SEAMLESS = PropertyBool.create("seamless");
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIlIlIllIllIlllIlIlIl, final BlockPos llllllllllllIlIlIllIllIlllIlIlII, final IBlockState llllllllllllIlIlIllIllIlllIlIIlI) {
        return new ItemStack(Blocks.STONE_SLAB2, 1, llllllllllllIlIlIllIllIlllIlIIlI.getValue(BlockStoneSlabNew.VARIANT).getMetadata());
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllIlIlIllIllIllIIllIII) {
        return llllllllllllIlIlIllIllIllIIllIII.getValue(BlockStoneSlabNew.VARIANT).getMetadata();
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(this.getUnlocalizedName()) + ".red_sandstone.name");
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIlIllIllIllIlIIllI) {
        int llllllllllllIlIlIllIllIllIlIlIII = 0;
        llllllllllllIlIlIllIllIllIlIlIII |= llllllllllllIlIlIllIllIllIlIIllI.getValue(BlockStoneSlabNew.VARIANT).getMetadata();
        if (this.isDouble()) {
            if (llllllllllllIlIlIllIllIllIlIIllI.getValue((IProperty<Boolean>)BlockStoneSlabNew.SEAMLESS)) {
                llllllllllllIlIlIllIllIllIlIlIII |= 0x8;
            }
        }
        else if (llllllllllllIlIlIllIllIllIlIIllI.getValue(BlockStoneSlabNew.HALF) == EnumBlockHalf.TOP) {
            llllllllllllIlIlIllIllIllIlIlIII |= 0x8;
        }
        return llllllllllllIlIlIllIllIllIlIlIII;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIlIllIllIllIlIllll) {
        IBlockState llllllllllllIlIlIllIllIllIllIIIl = this.getDefaultState().withProperty(BlockStoneSlabNew.VARIANT, EnumType.byMetadata(llllllllllllIlIlIllIllIllIlIllll & 0x7));
        if (this.isDouble()) {
            llllllllllllIlIlIllIllIllIllIIIl = llllllllllllIlIlIllIllIllIllIIIl.withProperty((IProperty<Comparable>)BlockStoneSlabNew.SEAMLESS, (llllllllllllIlIlIllIllIllIlIllll & 0x8) != 0x0);
        }
        else {
            llllllllllllIlIlIllIllIllIllIIIl = llllllllllllIlIlIllIllIllIllIIIl.withProperty(BlockStoneSlabNew.HALF, ((llllllllllllIlIlIllIllIllIlIllll & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return llllllllllllIlIlIllIllIllIllIIIl;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllIlIlIllIllIllIIlllII, final IBlockAccess llllllllllllIlIlIllIllIllIIllllI, final BlockPos llllllllllllIlIlIllIllIllIIlllIl) {
        return llllllllllllIlIlIllIllIllIIlllII.getValue(BlockStoneSlabNew.VARIANT).getMapColor();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneSlabNew.SEAMLESS, BlockStoneSlabNew.VARIANT }) : new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneSlabNew.HALF, BlockStoneSlabNew.VARIANT });
    }
    
    @Override
    public IProperty<?> getVariantProperty() {
        return BlockStoneSlabNew.VARIANT;
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ MapColor mapColor;
        
        RED_SANDSTONE("RED_SANDSTONE", 0, 0, "red_sandstone", BlockSand.EnumType.RED_SAND.getMapColor());
        
        private final /* synthetic */ String name;
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ int meta;
        
        public int getMetadata() {
            return this.meta;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        public static EnumType byMetadata(int lllllllllllllIllIIIIlllIlIlIllII) {
            if (lllllllllllllIllIIIIlllIlIlIllII < 0 || lllllllllllllIllIIIIlllIlIlIllII >= EnumType.META_LOOKUP.length) {
                lllllllllllllIllIIIIlllIlIlIllII = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIllIIIIlllIlIlIllII];
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumType(final String lllllllllllllIllIIIIlllIlIllllII, final int lllllllllllllIllIIIIlllIlIlllIll, final int lllllllllllllIllIIIIlllIlIlllIlI, final String lllllllllllllIllIIIIlllIlIllllll, final MapColor lllllllllllllIllIIIIlllIlIlllIII) {
            this.meta = lllllllllllllIllIIIIlllIlIlllIlI;
            this.name = lllllllllllllIllIIIIlllIlIllllll;
            this.mapColor = lllllllllllllIllIIIIlllIlIlllIII;
        }
        
        public String getUnlocalizedName() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final byte lllllllllllllIllIIIIlllIllIIlIII;
            final Exception lllllllllllllIllIIIIlllIllIIlIIl = (Exception)((EnumType[])(Object)(lllllllllllllIllIIIIlllIllIIlIII = (byte)(Object)values())).length;
            for (double lllllllllllllIllIIIIlllIllIIlIlI = 0; lllllllllllllIllIIIIlllIllIIlIlI < lllllllllllllIllIIIIlllIllIIlIIl; ++lllllllllllllIllIIIIlllIllIIlIlI) {
                final EnumType lllllllllllllIllIIIIlllIllIIllII = lllllllllllllIllIIIIlllIllIIlIII[lllllllllllllIllIIIIlllIllIIlIlI];
                EnumType.META_LOOKUP[lllllllllllllIllIIIIlllIllIIllII.getMetadata()] = lllllllllllllIllIIIIlllIllIIllII;
            }
        }
    }
}
