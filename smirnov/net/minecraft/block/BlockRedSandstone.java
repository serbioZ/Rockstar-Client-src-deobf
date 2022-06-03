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
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockRedSandstone extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> TYPE;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlllllIIlllIlIlIlIll) {
        return lllllllllllIIlllllIIlllIlIlIlIll.getValue(BlockRedSandstone.TYPE).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIlllllIIlllIlIllIIIl) {
        return this.getDefaultState().withProperty(BlockRedSandstone.TYPE, EnumType.byMetadata(lllllllllllIIlllllIIlllIlIllIIIl));
    }
    
    public BlockRedSandstone() {
        super(Material.ROCK, BlockSand.EnumType.RED_SAND.getMapColor());
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRedSandstone.TYPE, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRedSandstone.TYPE });
    }
    
    static {
        TYPE = PropertyEnum.create("type", EnumType.class);
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllIIlllllIIlllIllIIIlIl) {
        return lllllllllllIIlllllIIlllIllIIIlIl.getValue(BlockRedSandstone.TYPE).getMetadata();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllIIlllllIIlllIlIllllIl, final NonNullList<ItemStack> lllllllllllIIlllllIIlllIlIllllII) {
        byte lllllllllllIIlllllIIlllIlIllIlIl;
        for (short lllllllllllIIlllllIIlllIlIllIllI = (short)((EnumType[])(Object)(lllllllllllIIlllllIIlllIlIllIlIl = (byte)(Object)EnumType.values())).length, lllllllllllIIlllllIIlllIlIllIlll = 0; lllllllllllIIlllllIIlllIlIllIlll < lllllllllllIIlllllIIlllIlIllIllI; ++lllllllllllIIlllllIIlllIlIllIlll) {
            final EnumType lllllllllllIIlllllIIlllIlIlllIll = lllllllllllIIlllllIIlllIlIllIlIl[lllllllllllIIlllllIIlllIlIllIlll];
            lllllllllllIIlllllIIlllIlIllllII.add(new ItemStack(this, 1, lllllllllllIIlllllIIlllIlIlllIll.getMetadata()));
        }
    }
    
    public enum EnumType implements IStringSerializable
    {
        CHISELED("CHISELED", 1, 1, "chiseled_red_sandstone", "chiseled");
        
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ String name;
        
        SMOOTH("SMOOTH", 2, 2, "smooth_red_sandstone", "smooth"), 
        DEFAULT("DEFAULT", 0, 0, "red_sandstone", "default");
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ int meta;
        
        public static EnumType byMetadata(int llllllllllllIIllIIllIIllIIlIIIll) {
            if (llllllllllllIIllIIllIIllIIlIIIll < 0 || llllllllllllIIllIIllIIllIIlIIIll >= EnumType.META_LOOKUP.length) {
                llllllllllllIIllIIllIIllIIlIIIll = 0;
            }
            return EnumType.META_LOOKUP[llllllllllllIIllIIllIIllIIlIIIll];
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            String llllllllllllIIllIIllIIllIIllllII;
            for (Exception llllllllllllIIllIIllIIllIIllllIl = (Exception)((EnumType[])(Object)(llllllllllllIIllIIllIIllIIllllII = (String)(Object)values())).length, llllllllllllIIllIIllIIllIIlllllI = (Exception)0; llllllllllllIIllIIllIIllIIlllllI < llllllllllllIIllIIllIIllIIllllIl; ++llllllllllllIIllIIllIIllIIlllllI) {
                final EnumType llllllllllllIIllIIllIIllIlIIIIII = llllllllllllIIllIIllIIllIIllllII[llllllllllllIIllIIllIIllIIlllllI];
                EnumType.META_LOOKUP[llllllllllllIIllIIllIIllIlIIIIII.getMetadata()] = llllllllllllIIllIIllIIllIlIIIIII;
            }
        }
        
        private EnumType(final String llllllllllllIIllIIllIIllIIllIIII, final int llllllllllllIIllIIllIIllIIlIllll, final int llllllllllllIIllIIllIIllIIlIlllI, final String llllllllllllIIllIIllIIllIIlIllIl, final String llllllllllllIIllIIllIIllIIlIllII) {
            this.meta = llllllllllllIIllIIllIIllIIlIlllI;
            this.name = llllllllllllIIllIIllIIllIIlIllIl;
            this.unlocalizedName = llllllllllllIIllIIllIIllIIlIllII;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
    }
}
