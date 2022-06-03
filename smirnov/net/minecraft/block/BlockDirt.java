// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.MapColor;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyBool;

public class BlockDirt extends Block
{
    public static final /* synthetic */ PropertyBool SNOWY;
    public static final /* synthetic */ PropertyEnum<DirtType> VARIANT;
    
    static {
        VARIANT = PropertyEnum.create("variant", DirtType.class);
        SNOWY = PropertyBool.create("snowy");
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIlIIlllIlllllIllI) {
        return this.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.byMetadata(lllllllllllllIIIlIIlllIlllllIllI));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIlIIlllIlllllIIll) {
        return lllllllllllllIIIlIIlllIlllllIIll.getValue(BlockDirt.VARIANT).getMetadata();
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIIIlIIllllIIIIIIIII, final BlockPos lllllllllllllIIIlIIlllIlllllllll, final IBlockState lllllllllllllIIIlIIlllIllllllllI) {
        return new ItemStack(this, 1, lllllllllllllIIIlIIlllIllllllllI.getValue(BlockDirt.VARIANT).getMetadata());
    }
    
    protected BlockDirt() {
        super(Material.GROUND);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockDirt.VARIANT, DirtType.DIRT).withProperty((IProperty<Comparable>)BlockDirt.SNOWY, false));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIIIlIIllllIIIIIIlll, final NonNullList<ItemStack> lllllllllllllIIIlIIllllIIIIIIllI) {
        lllllllllllllIIIlIIllllIIIIIIllI.add(new ItemStack(this, 1, DirtType.DIRT.getMetadata()));
        lllllllllllllIIIlIIllllIIIIIIllI.add(new ItemStack(this, 1, DirtType.COARSE_DIRT.getMetadata()));
        lllllllllllllIIIlIIllllIIIIIIllI.add(new ItemStack(this, 1, DirtType.PODZOL.getMetadata()));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIIIlIIllllIIIIllIll, final IBlockAccess lllllllllllllIIIlIIllllIIIIllIlI, final BlockPos lllllllllllllIIIlIIllllIIIIllIIl) {
        return lllllllllllllIIIlIIllllIIIIllIll.getValue(BlockDirt.VARIANT).getColor();
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIIIlIIlllIllllIlIIl) {
        DirtType lllllllllllllIIIlIIlllIllllIlIlI = lllllllllllllIIIlIIlllIllllIlIIl.getValue(BlockDirt.VARIANT);
        if (lllllllllllllIIIlIIlllIllllIlIlI == DirtType.PODZOL) {
            lllllllllllllIIIlIIlllIllllIlIlI = DirtType.DIRT;
        }
        return lllllllllllllIIIlIIlllIllllIlIlI.getMetadata();
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllIIIlIIllllIIIIIlllI, final IBlockAccess lllllllllllllIIIlIIllllIIIIIllIl, final BlockPos lllllllllllllIIIlIIllllIIIIlIIII) {
        if (((IBlockState)lllllllllllllIIIlIIllllIIIIIlllI).getValue(BlockDirt.VARIANT) == DirtType.PODZOL) {
            final Block lllllllllllllIIIlIIllllIIIIIllll = lllllllllllllIIIlIIllllIIIIIllIl.getBlockState(lllllllllllllIIIlIIllllIIIIlIIII.up()).getBlock();
            lllllllllllllIIIlIIllllIIIIIlllI = ((IBlockState)lllllllllllllIIIlIIllllIIIIIlllI).withProperty((IProperty<Comparable>)BlockDirt.SNOWY, Boolean.valueOf(lllllllllllllIIIlIIllllIIIIIllll == Blocks.SNOW || lllllllllllllIIIlIIllllIIIIIllll == Blocks.SNOW_LAYER));
        }
        return (IBlockState)lllllllllllllIIIlIIllllIIIIIlllI;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDirt.VARIANT, BlockDirt.SNOWY });
    }
    
    public enum DirtType implements IStringSerializable
    {
        private static final /* synthetic */ DirtType[] METADATA_LOOKUP;
        
        PODZOL("PODZOL", 2, 2, "podzol", MapColor.OBSIDIAN);
        
        private final /* synthetic */ String name;
        
        DIRT("DIRT", 0, 0, "dirt", "default", MapColor.DIRT), 
        COARSE_DIRT("COARSE_DIRT", 1, 1, "coarse_dirt", "coarse", MapColor.DIRT);
        
        private final /* synthetic */ MapColor color;
        private final /* synthetic */ int metadata;
        private final /* synthetic */ String unlocalizedName;
        
        private DirtType(final String lllllllllllllIIIIlllIIlIIIlIlIlI, final int lllllllllllllIIIIlllIIlIIIlIlIIl, final int lllllllllllllIIIIlllIIlIIIlIllll, final String lllllllllllllIIIIlllIIlIIIlIlllI, final String lllllllllllllIIIIlllIIlIIIlIIllI, final MapColor lllllllllllllIIIIlllIIlIIIlIIlIl) {
            this.metadata = lllllllllllllIIIIlllIIlIIIlIllll;
            this.name = lllllllllllllIIIIlllIIlIIIlIlllI;
            this.unlocalizedName = lllllllllllllIIIIlllIIlIIIlIIllI;
            this.color = lllllllllllllIIIIlllIIlIIIlIIlIl;
        }
        
        static {
            METADATA_LOOKUP = new DirtType[values().length];
            final short lllllllllllllIIIIlllIIlIIlIIlIII;
            final Exception lllllllllllllIIIIlllIIlIIlIIlIIl = (Exception)((DirtType[])(Object)(lllllllllllllIIIIlllIIlIIlIIlIII = (short)(Object)values())).length;
            for (float lllllllllllllIIIIlllIIlIIlIIlIlI = 0; lllllllllllllIIIIlllIIlIIlIIlIlI < lllllllllllllIIIIlllIIlIIlIIlIIl; ++lllllllllllllIIIIlllIIlIIlIIlIlI) {
                final DirtType lllllllllllllIIIIlllIIlIIlIIllII = lllllllllllllIIIIlllIIlIIlIIlIII[lllllllllllllIIIIlllIIlIIlIIlIlI];
                DirtType.METADATA_LOOKUP[lllllllllllllIIIIlllIIlIIlIIllII.getMetadata()] = lllllllllllllIIIIlllIIlIIlIIllII;
            }
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        private DirtType(final String lllllllllllllIIIIlllIIlIIIllllII, final int lllllllllllllIIIIlllIIlIIIlllIll, final int lllllllllllllIIIIlllIIlIIlIIIIII, final String lllllllllllllIIIIlllIIlIIIlllIIl, final MapColor lllllllllllllIIIIlllIIlIIIlllIII) {
            this(lllllllllllllIIIIlllIIlIIIllllII, lllllllllllllIIIIlllIIlIIIlllIll, lllllllllllllIIIIlllIIlIIlIIIIII, lllllllllllllIIIIlllIIlIIIlllIIl, lllllllllllllIIIIlllIIlIIIlllIIl, lllllllllllllIIIIlllIIlIIIlllIII);
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public MapColor getColor() {
            return this.color;
        }
        
        public int getMetadata() {
            return this.metadata;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public static DirtType byMetadata(int lllllllllllllIIIIlllIIlIIIIlIllI) {
            if (lllllllllllllIIIIlllIIlIIIIlIllI < 0 || lllllllllllllIIIIlllIIlIIIIlIllI >= DirtType.METADATA_LOOKUP.length) {
                lllllllllllllIIIIlllIIlIIIIlIllI = 0;
            }
            return DirtType.METADATA_LOOKUP[lllllllllllllIIIIlllIIlIIIIlIllI];
        }
    }
}
