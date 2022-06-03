// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.PropertyEnum;

public class BlockPlanks extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllIlIlIIlllIIlllIlIllI, final NonNullList<ItemStack> llllllllllllIlIlIIlllIIlllIlIIlI) {
        boolean llllllllllllIlIlIIlllIIlllIIlllI;
        for (double llllllllllllIlIlIIlllIIlllIIllll = ((EnumType[])(Object)(llllllllllllIlIlIIlllIIlllIIlllI = (boolean)(Object)EnumType.values())).length, llllllllllllIlIlIIlllIIlllIlIIII = 0; llllllllllllIlIlIIlllIIlllIlIIII < llllllllllllIlIlIIlllIIlllIIllll; ++llllllllllllIlIlIIlllIIlllIlIIII) {
            final EnumType llllllllllllIlIlIIlllIIlllIlIlII = llllllllllllIlIlIIlllIIlllIIlllI[llllllllllllIlIlIIlllIIlllIlIIII];
            llllllllllllIlIlIIlllIIlllIlIIlI.add(new ItemStack(this, 1, llllllllllllIlIlIIlllIIlllIlIlII.getMetadata()));
        }
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllIlIlIIlllIIlllIIIlIl, final IBlockAccess llllllllllllIlIlIIlllIIlllIIIlII, final BlockPos llllllllllllIlIlIIlllIIlllIIIIll) {
        return llllllllllllIlIlIIlllIIlllIIIlIl.getValue(BlockPlanks.VARIANT).getMapColor();
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllIlIlIIlllIIlllIllllI) {
        return llllllllllllIlIlIIlllIIlllIllllI.getValue(BlockPlanks.VARIANT).getMetadata();
    }
    
    public BlockPlanks() {
        super(Material.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPlanks.VARIANT, EnumType.OAK));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIlIIlllIIlllIIlIlI) {
        return this.getDefaultState().withProperty(BlockPlanks.VARIANT, EnumType.byMetadata(llllllllllllIlIlIIlllIIlllIIlIlI));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPlanks.VARIANT });
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIlIIlllIIllIllllll) {
        return llllllllllllIlIlIIlllIIllIllllll.getValue(BlockPlanks.VARIANT).getMetadata();
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ int meta;
        private final /* synthetic */ String unlocalizedName;
        
        SPRUCE("SPRUCE", 1, 1, "spruce", MapColor.OBSIDIAN), 
        ACACIA("ACACIA", 4, 4, "acacia", MapColor.ADOBE), 
        OAK("OAK", 0, 0, "oak", MapColor.WOOD);
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        BIRCH("BIRCH", 2, 2, "birch", MapColor.SAND);
        
        private final /* synthetic */ MapColor mapColor;
        private final /* synthetic */ String name;
        
        DARK_OAK("DARK_OAK", 5, 5, "dark_oak", "big_oak", MapColor.BROWN), 
        JUNGLE("JUNGLE", 3, 3, "jungle", MapColor.DIRT);
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final String lllllllllllllIIIIllIIIIlIlIIlllI;
            final long lllllllllllllIIIIllIIIIlIlIIllll = ((EnumType[])(Object)(lllllllllllllIIIIllIIIIlIlIIlllI = (String)(Object)values())).length;
            for (Exception lllllllllllllIIIIllIIIIlIlIlIIII = (Exception)0; lllllllllllllIIIIllIIIIlIlIlIIII < lllllllllllllIIIIllIIIIlIlIIllll; ++lllllllllllllIIIIllIIIIlIlIlIIII) {
                final EnumType lllllllllllllIIIIllIIIIlIlIlIIlI = lllllllllllllIIIIllIIIIlIlIIlllI[lllllllllllllIIIIllIIIIlIlIlIIII];
                EnumType.META_LOOKUP[lllllllllllllIIIIllIIIIlIlIlIIlI.getMetadata()] = lllllllllllllIIIIllIIIIlIlIlIIlI;
            }
        }
        
        private EnumType(final String lllllllllllllIIIIllIIIIlIlIIIIlI, final int lllllllllllllIIIIllIIIIlIlIIIIIl, final int lllllllllllllIIIIllIIIIlIlIIIIII, final String lllllllllllllIIIIllIIIIlIIllllll, final MapColor lllllllllllllIIIIllIIIIlIIlllllI) {
            this(lllllllllllllIIIIllIIIIlIlIIIIlI, lllllllllllllIIIIllIIIIlIlIIIIIl, lllllllllllllIIIIllIIIIlIlIIIIII, lllllllllllllIIIIllIIIIlIIllllll, lllllllllllllIIIIllIIIIlIIllllll, lllllllllllllIIIIllIIIIlIIlllllI);
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public static EnumType byMetadata(int lllllllllllllIIIIllIIIIlIIIlllll) {
            if (lllllllllllllIIIIllIIIIlIIIlllll < 0 || lllllllllllllIIIIllIIIIlIIIlllll >= EnumType.META_LOOKUP.length) {
                lllllllllllllIIIIllIIIIlIIIlllll = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIIIIllIIIIlIIIlllll];
        }
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        private EnumType(final String lllllllllllllIIIIllIIIIlIIllIIII, final int lllllllllllllIIIIllIIIIlIIlIllll, final int lllllllllllllIIIIllIIIIlIIlIlllI, final String lllllllllllllIIIIllIIIIlIIllIlII, final String lllllllllllllIIIIllIIIIlIIlIllII, final MapColor lllllllllllllIIIIllIIIIlIIlIlIll) {
            this.meta = lllllllllllllIIIIllIIIIlIIlIlllI;
            this.name = lllllllllllllIIIIllIIIIlIIllIlII;
            this.unlocalizedName = lllllllllllllIIIIllIIIIlIIlIllII;
            this.mapColor = lllllllllllllIIIIllIIIIlIIlIlIll;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
    }
}
