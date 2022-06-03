// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockPrismarine extends Block
{
    public static final /* synthetic */ int ROUGH_META;
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    public static final /* synthetic */ int BRICKS_META;
    public static final /* synthetic */ int DARK_META;
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
        ROUGH_META = EnumType.ROUGH.getMetadata();
        BRICKS_META = EnumType.BRICKS.getMetadata();
        DARK_META = EnumType.DARK.getMetadata();
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllIlllllllllIIlIIlIIIIIl) {
        return llllllllllIlllllllllIIlIIlIIIIIl.getValue(BlockPrismarine.VARIANT).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPrismarine.VARIANT });
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllIlllllllllIIlIIlIIlIII, final IBlockAccess llllllllllIlllllllllIIlIIlIIIlll, final BlockPos llllllllllIlllllllllIIlIIlIIIllI) {
        return (llllllllllIlllllllllIIlIIlIIlIII.getValue(BlockPrismarine.VARIANT) == EnumType.ROUGH) ? MapColor.CYAN : MapColor.DIAMOND;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllIlllllllllIIlIIIllIlII) {
        return this.getDefaultState().withProperty(BlockPrismarine.VARIANT, EnumType.byMetadata(llllllllllIlllllllllIIlIIIllIlII));
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(this.getUnlocalizedName()) + "." + EnumType.ROUGH.getUnlocalizedName() + ".name");
    }
    
    public BlockPrismarine() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPrismarine.VARIANT, EnumType.ROUGH));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllIlllllllllIIlIIIllIIII, final NonNullList<ItemStack> llllllllllIlllllllllIIlIIIlIllIl) {
        llllllllllIlllllllllIIlIIIlIllIl.add(new ItemStack(this, 1, BlockPrismarine.ROUGH_META));
        llllllllllIlllllllllIIlIIIlIllIl.add(new ItemStack(this, 1, BlockPrismarine.BRICKS_META));
        llllllllllIlllllllllIIlIIIlIllIl.add(new ItemStack(this, 1, BlockPrismarine.DARK_META));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllIlllllllllIIlIIIllllIl) {
        return llllllllllIlllllllllIIlIIIllllIl.getValue(BlockPrismarine.VARIANT).getMetadata();
    }
    
    public enum EnumType implements IStringSerializable
    {
        DARK("DARK", 2, 2, "dark_prismarine", "dark");
        
        private final /* synthetic */ int meta;
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ String name;
        
        BRICKS("BRICKS", 1, 1, "prismarine_bricks", "bricks");
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        ROUGH("ROUGH", 0, 0, "prismarine", "rough");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final float lllllllllllIlIIllllIllIIlIIIIlIl;
            final char lllllllllllIlIIllllIllIIlIIIIllI = (char)((EnumType[])(Object)(lllllllllllIlIIllllIllIIlIIIIlIl = (float)(Object)values())).length;
            for (final EnumType lllllllllllIlIIllllIllIIlIIIlIIl : lllllllllllIlIIllllIllIIlIIIIlIl) {
                EnumType.META_LOOKUP[lllllllllllIlIIllllIllIIlIIIlIIl.getMetadata()] = lllllllllllIlIIllllIllIIlIIIlIIl;
            }
        }
        
        public static EnumType byMetadata(int lllllllllllIlIIllllIllIIIllIllII) {
            if (lllllllllllIlIIllllIllIIIllIllII < 0 || lllllllllllIlIIllllIllIIIllIllII >= EnumType.META_LOOKUP.length) {
                lllllllllllIlIIllllIllIIIllIllII = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllIlIIllllIllIIIllIllII];
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        private EnumType(final String lllllllllllIlIIllllIllIIIllllIIl, final int lllllllllllIlIIllllIllIIIllllIII, final int lllllllllllIlIIllllIllIIIlllllIl, final String lllllllllllIlIIllllIllIIIlllIllI, final String lllllllllllIlIIllllIllIIIlllIlIl) {
            this.meta = lllllllllllIlIIllllIllIIIlllllIl;
            this.name = lllllllllllIlIIllllIllIIIlllIllI;
            this.unlocalizedName = lllllllllllIlIIllllIllIIIlllIlIl;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
    }
}
