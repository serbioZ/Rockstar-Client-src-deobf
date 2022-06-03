// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockSand extends BlockFalling
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public int getDustColor(final IBlockState lllllllllllllIIIllIlllIIlIIIllIl) {
        final EnumType lllllllllllllIIIllIlllIIlIIIllII = lllllllllllllIIIllIlllIIlIIIllIl.getValue(BlockSand.VARIANT);
        return lllllllllllllIIIllIlllIIlIIIllII.getDustColor();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIIIllIlllIIlIlIllII, final NonNullList<ItemStack> lllllllllllllIIIllIlllIIlIlIlIII) {
        final String lllllllllllllIIIllIlllIIlIlIIlII;
        final byte lllllllllllllIIIllIlllIIlIlIIlIl = (byte)((EnumType[])(Object)(lllllllllllllIIIllIlllIIlIlIIlII = (String)(Object)EnumType.values())).length;
        for (char lllllllllllllIIIllIlllIIlIlIIllI = '\0'; lllllllllllllIIIllIlllIIlIlIIllI < lllllllllllllIIIllIlllIIlIlIIlIl; ++lllllllllllllIIIllIlllIIlIlIIllI) {
            final EnumType lllllllllllllIIIllIlllIIlIlIlIlI = lllllllllllllIIIllIlllIIlIlIIlII[lllllllllllllIIIllIlllIIlIlIIllI];
            lllllllllllllIIIllIlllIIlIlIlIII.add(new ItemStack(this, 1, lllllllllllllIIIllIlllIIlIlIlIlI.getMetadata()));
        }
    }
    
    public BlockSand() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSand.VARIANT, EnumType.SAND));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIllIlllIIlIIllIII) {
        return this.getDefaultState().withProperty(BlockSand.VARIANT, EnumType.byMetadata(lllllllllllllIIIllIlllIIlIIllIII));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIIIllIlllIIlIlIIIIl, final IBlockAccess lllllllllllllIIIllIlllIIlIlIIIII, final BlockPos lllllllllllllIIIllIlllIIlIIlllll) {
        return lllllllllllllIIIllIlllIIlIlIIIIl.getValue(BlockSand.VARIANT).getMapColor();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSand.VARIANT });
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIllIlllIIlIIlIlII) {
        return lllllllllllllIIIllIlllIIlIIlIlII.getValue(BlockSand.VARIANT).getMetadata();
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIIIllIlllIIlIllIlIl) {
        return lllllllllllllIIIllIlllIIlIllIlIl.getValue(BlockSand.VARIANT).getMetadata();
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ int dustColor;
        private final /* synthetic */ MapColor mapColor;
        private final /* synthetic */ String unlocalizedName;
        
        RED_SAND("RED_SAND", 1, 1, "red_sand", "red", MapColor.ADOBE, -5679071);
        
        private final /* synthetic */ String name;
        
        SAND("SAND", 0, 0, "sand", "default", MapColor.SAND, -2370656);
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ int meta;
        
        public int getMetadata() {
            return this.meta;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public int getDustColor() {
            return this.dustColor;
        }
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        public static EnumType byMetadata(int lllllllllllIlIIIIIIllllIIIIIIlll) {
            if (lllllllllllIlIIIIIIllllIIIIIIlll < 0 || lllllllllllIlIIIIIIllllIIIIIIlll >= EnumType.META_LOOKUP.length) {
                lllllllllllIlIIIIIIllllIIIIIIlll = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllIlIIIIIIllllIIIIIIlll];
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final double lllllllllllIlIIIIIIllllIIIlIlIll;
            final int lllllllllllIlIIIIIIllllIIIlIllII = ((EnumType[])(Object)(lllllllllllIlIIIIIIllllIIIlIlIll = (double)(Object)values())).length;
            for (long lllllllllllIlIIIIIIllllIIIlIllIl = 0; lllllllllllIlIIIIIIllllIIIlIllIl < lllllllllllIlIIIIIIllllIIIlIllII; ++lllllllllllIlIIIIIIllllIIIlIllIl) {
                final EnumType lllllllllllIlIIIIIIllllIIIlIllll = lllllllllllIlIIIIIIllllIIIlIlIll[lllllllllllIlIIIIIIllllIIIlIllIl];
                EnumType.META_LOOKUP[lllllllllllIlIIIIIIllllIIIlIllll.getMetadata()] = lllllllllllIlIIIIIIllllIIIlIllll;
            }
        }
        
        private EnumType(final String lllllllllllIlIIIIIIllllIIIIllIll, final int lllllllllllIlIIIIIIllllIIIIllIlI, final int lllllllllllIlIIIIIIllllIIIlIIIIl, final String lllllllllllIlIIIIIIllllIIIIllIII, final String lllllllllllIlIIIIIIllllIIIIlIlll, final MapColor lllllllllllIlIIIIIIllllIIIIllllI, final int lllllllllllIlIIIIIIllllIIIIlllIl) {
            this.meta = lllllllllllIlIIIIIIllllIIIlIIIIl;
            this.name = lllllllllllIlIIIIIIllllIIIIllIII;
            this.mapColor = lllllllllllIlIIIIIIllllIIIIllllI;
            this.unlocalizedName = lllllllllllIlIIIIIIllllIIIIlIlll;
            this.dustColor = lllllllllllIlIIIIIIllllIIIIlllIl;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
