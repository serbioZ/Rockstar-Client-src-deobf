// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.PropertyEnum;

public class BlockStoneBrick extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllllIIIIIllllIllIllIl, final NonNullList<ItemStack> lllllllllllllllIIIIIllllIllIllII) {
        final long lllllllllllllllIIIIIllllIllIIlIl;
        final double lllllllllllllllIIIIIllllIllIIllI = ((EnumType[])(Object)(lllllllllllllllIIIIIllllIllIIlIl = (long)(Object)EnumType.values())).length;
        for (byte lllllllllllllllIIIIIllllIllIIlll = 0; lllllllllllllllIIIIIllllIllIIlll < lllllllllllllllIIIIIllllIllIIllI; ++lllllllllllllllIIIIIllllIllIIlll) {
            final EnumType lllllllllllllllIIIIIllllIllIlIll = lllllllllllllllIIIIIllllIllIIlIl[lllllllllllllllIIIIIllllIllIIlll];
            lllllllllllllllIIIIIllllIllIllII.add(new ItemStack(this, 1, lllllllllllllllIIIIIllllIllIlIll.getMetadata()));
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIIIIllllIllIIIIl) {
        return this.getDefaultState().withProperty(BlockStoneBrick.VARIANT, EnumType.byMetadata(lllllllllllllllIIIIIllllIllIIIIl));
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
        DEFAULT_META = EnumType.DEFAULT.getMetadata();
        MOSSY_META = EnumType.MOSSY.getMetadata();
        CRACKED_META = EnumType.CRACKED.getMetadata();
        CHISELED_META = EnumType.CHISELED.getMetadata();
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIIIllllIlIlllII) {
        return lllllllllllllllIIIIIllllIlIlllII.getValue(BlockStoneBrick.VARIANT).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneBrick.VARIANT });
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIIIIIllllIlllIllI) {
        return lllllllllllllllIIIIIllllIlllIllI.getValue(BlockStoneBrick.VARIANT).getMetadata();
    }
    
    public BlockStoneBrick() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStoneBrick.VARIANT, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    public enum EnumType implements IStringSerializable
    {
        CHISELED("CHISELED", 3, 3, "chiseled_stonebrick", "chiseled"), 
        CRACKED("CRACKED", 2, 2, "cracked_stonebrick", "cracked");
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        DEFAULT("DEFAULT", 0, 0, "stonebrick", "default");
        
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ int meta;
        private final /* synthetic */ String name;
        
        MOSSY("MOSSY", 1, 1, "mossy_stonebrick", "mossy");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final byte lllllllllllIlIIlllIIlIlIlIllIlII;
            final char lllllllllllIlIIlllIIlIlIlIllIlIl = (char)((EnumType[])(Object)(lllllllllllIlIIlllIIlIlIlIllIlII = (byte)(Object)values())).length;
            for (String lllllllllllIlIIlllIIlIlIlIllIllI = (String)0; lllllllllllIlIIlllIIlIlIlIllIllI < lllllllllllIlIIlllIIlIlIlIllIlIl; ++lllllllllllIlIIlllIIlIlIlIllIllI) {
                final EnumType lllllllllllIlIIlllIIlIlIlIlllIII = lllllllllllIlIIlllIIlIlIlIllIlII[lllllllllllIlIIlllIIlIlIlIllIllI];
                EnumType.META_LOOKUP[lllllllllllIlIIlllIIlIlIlIlllIII.getMetadata()] = lllllllllllIlIIlllIIlIlIlIlllIII;
            }
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        private EnumType(final String lllllllllllIlIIlllIIlIlIlIlIlIII, final int lllllllllllIlIIlllIIlIlIlIlIIlll, final int lllllllllllIlIIlllIIlIlIlIlIllII, final String lllllllllllIlIIlllIIlIlIlIlIIlIl, final String lllllllllllIlIIlllIIlIlIlIlIIlII) {
            this.meta = lllllllllllIlIIlllIIlIlIlIlIllII;
            this.name = lllllllllllIlIIlllIIlIlIlIlIIlIl;
            this.unlocalizedName = lllllllllllIlIIlllIIlIlIlIlIIlII;
        }
        
        public static EnumType byMetadata(int lllllllllllIlIIlllIIlIlIlIIllIll) {
            if (lllllllllllIlIIlllIIlIlIlIIllIll < 0 || lllllllllllIlIIlllIIlIlIlIIllIll >= EnumType.META_LOOKUP.length) {
                lllllllllllIlIIlllIIlIlIlIIllIll = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllIlIIlllIIlIlIlIIllIll];
        }
    }
}
