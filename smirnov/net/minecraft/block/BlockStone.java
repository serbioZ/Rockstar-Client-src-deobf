// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockStone extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIIIlIlIIIlllIlII, final Random llllllllllllllIlIIIlIlIIIlllIllI, final int llllllllllllllIlIIIlIlIIIlllIlIl) {
        return (llllllllllllllIlIIIlIlIIIlllIlII.getValue(BlockStone.VARIANT) == EnumType.STONE) ? Item.getItemFromBlock(Blocks.COBBLESTONE) : Item.getItemFromBlock(Blocks.STONE);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlIIIlIlIIIlllIIII) {
        return llllllllllllllIlIIIlIlIIIlllIIII.getValue(BlockStone.VARIANT).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIIlIlIIIlIllIlI) {
        return this.getDefaultState().withProperty(BlockStone.VARIANT, EnumType.byMetadata(llllllllllllllIlIIIlIlIIIlIllIlI));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIlIIIlIlIIIllllIlI, final IBlockAccess llllllllllllllIlIIIlIlIIIlllllII, final BlockPos llllllllllllllIlIIIlIlIIIllllIll) {
        return llllllllllllllIlIIIlIlIIIllllIlI.getValue(BlockStone.VARIANT).getMapColor();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStone.VARIANT });
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllllIlIIIlIlIIIllIlIII, final NonNullList<ItemStack> llllllllllllllIlIIIlIlIIIllIIlII) {
        final char llllllllllllllIlIIIlIlIIIllIIIII;
        final String llllllllllllllIlIIIlIlIIIllIIIIl = (String)((EnumType[])(Object)(llllllllllllllIlIIIlIlIIIllIIIII = (char)(Object)EnumType.values())).length;
        for (long llllllllllllllIlIIIlIlIIIllIIIlI = 0; llllllllllllllIlIIIlIlIIIllIIIlI < llllllllllllllIlIIIlIlIIIllIIIIl; ++llllllllllllllIlIIIlIlIIIllIIIlI) {
            final EnumType llllllllllllllIlIIIlIlIIIllIIllI = llllllllllllllIlIIIlIlIIIllIIIII[llllllllllllllIlIIIlIlIIIllIIIlI];
            llllllllllllllIlIIIlIlIIIllIIlII.add(new ItemStack(this, 1, llllllllllllllIlIIIlIlIIIllIIllI.getMetadata()));
        }
    }
    
    public BlockStone() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStone.VARIANT, EnumType.STONE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(this.getUnlocalizedName()) + "." + EnumType.STONE.getUnlocalizedName() + ".name");
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIIlIlIIIlIlIllI) {
        return llllllllllllllIlIIIlIlIIIlIlIllI.getValue(BlockStone.VARIANT).getMetadata();
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ MapColor mapColor;
        
        DIORITE_SMOOTH("DIORITE_SMOOTH", 4, 4, MapColor.QUARTZ, "smooth_diorite", "dioriteSmooth", false);
        
        private final /* synthetic */ boolean field_190913_m;
        
        ANDESITE_SMOOTH("ANDESITE_SMOOTH", 6, 6, MapColor.STONE, "smooth_andesite", "andesiteSmooth", false);
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ String name;
        private final /* synthetic */ int meta;
        
        DIORITE("DIORITE", 3, 3, MapColor.QUARTZ, "diorite", true), 
        GRANITE("GRANITE", 1, 1, MapColor.DIRT, "granite", true), 
        ANDESITE("ANDESITE", 5, 5, MapColor.STONE, "andesite", true), 
        STONE("STONE", 0, 0, MapColor.STONE, "stone", true), 
        GRANITE_SMOOTH("GRANITE_SMOOTH", 2, 2, MapColor.DIRT, "smooth_granite", "graniteSmooth", false);
        
        private EnumType(final String lllllllllllllIIIlllIIlIIIIllIIIl, final int lllllllllllllIIIlllIIlIIIIllIIII, final int lllllllllllllIIIlllIIlIIIIllIllI, final MapColor lllllllllllllIIIlllIIlIIIIllIlIl, final String lllllllllllllIIIlllIIlIIIIlIllIl, final boolean lllllllllllllIIIlllIIlIIIIlIllII) {
            this(lllllllllllllIIIlllIIlIIIIllIIIl, lllllllllllllIIIlllIIlIIIIllIIII, lllllllllllllIIIlllIIlIIIIllIllI, lllllllllllllIIIlllIIlIIIIllIlIl, lllllllllllllIIIlllIIlIIIIlIllIl, lllllllllllllIIIlllIIlIIIIlIllIl, lllllllllllllIIIlllIIlIIIIlIllII);
        }
        
        public boolean func_190912_e() {
            return this.field_190913_m;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        private EnumType(final String lllllllllllllIIIlllIIlIIIIIlllII, final int lllllllllllllIIIlllIIlIIIIIllIll, final int lllllllllllllIIIlllIIlIIIIlIIIlI, final MapColor lllllllllllllIIIlllIIlIIIIIllIIl, final String lllllllllllllIIIlllIIlIIIIlIIIII, final String lllllllllllllIIIlllIIlIIIIIlllll, final boolean lllllllllllllIIIlllIIlIIIIIlIllI) {
            this.meta = lllllllllllllIIIlllIIlIIIIlIIIlI;
            this.name = lllllllllllllIIIlllIIlIIIIlIIIII;
            this.unlocalizedName = lllllllllllllIIIlllIIlIIIIIlllll;
            this.mapColor = lllllllllllllIIIlllIIlIIIIIllIIl;
            this.field_190913_m = lllllllllllllIIIlllIIlIIIIIlIllI;
        }
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public static EnumType byMetadata(int lllllllllllllIIIlllIIlIIIIIIlIlI) {
            if (lllllllllllllIIIlllIIlIIIIIIlIlI < 0 || lllllllllllllIIIlllIIlIIIIIIlIlI >= EnumType.META_LOOKUP.length) {
                lllllllllllllIIIlllIIlIIIIIIlIlI = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIIIlllIIlIIIIIIlIlI];
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final String lllllllllllllIIIlllIIlIIIIllllll;
            final double lllllllllllllIIIlllIIlIIIlIIIIII = ((EnumType[])(Object)(lllllllllllllIIIlllIIlIIIIllllll = (String)(Object)values())).length;
            for (long lllllllllllllIIIlllIIlIIIlIIIIIl = 0; lllllllllllllIIIlllIIlIIIlIIIIIl < lllllllllllllIIIlllIIlIIIlIIIIII; ++lllllllllllllIIIlllIIlIIIlIIIIIl) {
                final EnumType lllllllllllllIIIlllIIlIIIlIIIIll = lllllllllllllIIIlllIIlIIIIllllll[lllllllllllllIIIlllIIlIIIlIIIIIl];
                EnumType.META_LOOKUP[lllllllllllllIIIlllIIlIIIlIIIIll.getMetadata()] = lllllllllllllIIIlllIIlIIIlIIIIll;
            }
        }
    }
}
