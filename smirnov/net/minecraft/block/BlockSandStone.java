// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockSandStone extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> TYPE;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlllIllllIlIllIII) {
        return this.getDefaultState().withProperty(BlockSandStone.TYPE, EnumType.byMetadata(lllllllllllllllIlllIllllIlIllIII));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIlllIllllIlIllllI, final IBlockAccess lllllllllllllllIlllIllllIlIlllIl, final BlockPos lllllllllllllllIlllIllllIlIlllII) {
        return MapColor.SAND;
    }
    
    public BlockSandStone() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSandStone.TYPE, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlllIllllIlIlIIll) {
        return lllllllllllllllIlllIllllIlIlIIll.getValue(BlockSandStone.TYPE).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSandStone.TYPE });
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllllIlllIllllIllIlIII, final NonNullList<ItemStack> lllllllllllllllIlllIllllIllIIlII) {
        final char lllllllllllllllIlllIllllIllIIIII;
        final byte lllllllllllllllIlllIllllIllIIIIl = (byte)((EnumType[])(Object)(lllllllllllllllIlllIllllIllIIIII = (char)(Object)EnumType.values())).length;
        for (double lllllllllllllllIlllIllllIllIIIlI = 0; lllllllllllllllIlllIllllIllIIIlI < lllllllllllllllIlllIllllIllIIIIl; ++lllllllllllllllIlllIllllIllIIIlI) {
            final EnumType lllllllllllllllIlllIllllIllIIllI = lllllllllllllllIlllIllllIllIIIII[lllllllllllllllIlllIllllIllIIIlI];
            lllllllllllllllIlllIllllIllIIlII.add(new ItemStack(this, 1, lllllllllllllllIlllIllllIllIIllI.getMetadata()));
        }
    }
    
    static {
        TYPE = PropertyEnum.create("type", EnumType.class);
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIlllIllllIlllIIII) {
        return lllllllllllllllIlllIllllIlllIIII.getValue(BlockSandStone.TYPE).getMetadata();
    }
    
    public enum EnumType implements IStringSerializable
    {
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ int metadata;
        
        SMOOTH("SMOOTH", 2, 2, "smooth_sandstone", "smooth"), 
        DEFAULT("DEFAULT", 0, 0, "sandstone", "default"), 
        CHISELED("CHISELED", 1, 1, "chiseled_sandstone", "chiseled");
        
        private final /* synthetic */ String name;
        private final /* synthetic */ String unlocalizedName;
        
        public int getMetadata() {
            return this.metadata;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final short lllllllllllIIIllIllIIIlIllIIIlII;
            final Exception lllllllllllIIIllIllIIIlIllIIIlIl = (Exception)((EnumType[])(Object)(lllllllllllIIIllIllIIIlIllIIIlII = (short)(Object)values())).length;
            for (char lllllllllllIIIllIllIIIlIllIIIllI = '\0'; lllllllllllIIIllIllIIIlIllIIIllI < lllllllllllIIIllIllIIIlIllIIIlIl; ++lllllllllllIIIllIllIIIlIllIIIllI) {
                final EnumType lllllllllllIIIllIllIIIlIllIIlIII = lllllllllllIIIllIllIIIlIllIIIlII[lllllllllllIIIllIllIIIlIllIIIllI];
                EnumType.META_LOOKUP[lllllllllllIIIllIllIIIlIllIIlIII.getMetadata()] = lllllllllllIIIllIllIIIlIllIIlIII;
            }
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        private EnumType(final String lllllllllllIIIllIllIIIlIlIlllIII, final int lllllllllllIIIllIllIIIlIlIllIlll, final int lllllllllllIIIllIllIIIlIlIllIllI, final String lllllllllllIIIllIllIIIlIlIlllIll, final String lllllllllllIIIllIllIIIlIlIllIlII) {
            this.metadata = lllllllllllIIIllIllIIIlIlIllIllI;
            this.name = lllllllllllIIIllIllIIIlIlIlllIll;
            this.unlocalizedName = lllllllllllIIIllIllIIIlIlIllIlII;
        }
        
        public static EnumType byMetadata(int lllllllllllIIIllIllIIIlIlIlIlIll) {
            if (lllllllllllIIIllIllIIIlIlIlIlIll < 0 || lllllllllllIIIllIllIIIlIlIlIlIll >= EnumType.META_LOOKUP.length) {
                lllllllllllIIIllIllIIIlIlIlIlIll = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllIIIllIllIIIlIlIlIlIll];
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
