// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyBool;

public abstract class BlockStoneSlab extends BlockSlab
{
    public static final /* synthetic */ PropertyBool SEAMLESS;
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    @Override
    public IProperty<?> getVariantProperty() {
        return BlockStoneSlab.VARIANT;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIIIllllIllIllIIII) {
        int lllllllllllllIlIIIllllIllIllIIlI = 0;
        lllllllllllllIlIIIllllIllIllIIlI |= lllllllllllllIlIIIllllIllIllIIII.getValue(BlockStoneSlab.VARIANT).getMetadata();
        if (this.isDouble()) {
            if (lllllllllllllIlIIIllllIllIllIIII.getValue((IProperty<Boolean>)BlockStoneSlab.SEAMLESS)) {
                lllllllllllllIlIIIllllIllIllIIlI |= 0x8;
            }
        }
        else if (lllllllllllllIlIIIllllIllIllIIII.getValue(BlockStoneSlab.HALF) == EnumBlockHalf.TOP) {
            lllllllllllllIlIIIllllIllIllIIlI |= 0x8;
        }
        return lllllllllllllIlIIIllllIllIllIIlI;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlIIIllllIllllIIlII, final Random lllllllllllllIlIIIllllIllllIIIll, final int lllllllllllllIlIIIllllIllllIIIlI) {
        return Item.getItemFromBlock(Blocks.STONE_SLAB);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIIIllllIllIlllIIl) {
        IBlockState lllllllllllllIlIIIllllIllIlllIll = this.getDefaultState().withProperty(BlockStoneSlab.VARIANT, EnumType.byMetadata(lllllllllllllIlIIIllllIllIlllIIl & 0x7));
        if (this.isDouble()) {
            lllllllllllllIlIIIllllIllIlllIll = lllllllllllllIlIIIllllIllIlllIll.withProperty((IProperty<Comparable>)BlockStoneSlab.SEAMLESS, (lllllllllllllIlIIIllllIllIlllIIl & 0x8) != 0x0);
        }
        else {
            lllllllllllllIlIIIllllIllIlllIll = lllllllllllllIlIIIllllIllIlllIll.withProperty(BlockStoneSlab.HALF, ((lllllllllllllIlIIIllllIllIlllIIl & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return lllllllllllllIlIIIllllIllIlllIll;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIlIIIllllIllIlIIlIl, final IBlockAccess lllllllllllllIlIIIllllIllIlIIlII, final BlockPos lllllllllllllIlIIIllllIllIlIIIll) {
        return lllllllllllllIlIIIllllIllIlIIlIl.getValue(BlockStoneSlab.VARIANT).getMapColor();
    }
    
    static {
        SEAMLESS = PropertyBool.create("seamless");
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneSlab.SEAMLESS, BlockStoneSlab.VARIANT }) : new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneSlab.HALF, BlockStoneSlab.VARIANT });
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIlIIIllllIllIlIlIII) {
        return lllllllllllllIlIIIllllIllIlIlIII.getValue(BlockStoneSlab.VARIANT).getMetadata();
    }
    
    public BlockStoneSlab() {
        super(Material.ROCK);
        IBlockState lllllllllllllIlIIIllllIllllIlIII = this.blockState.getBaseState();
        if (this.isDouble()) {
            lllllllllllllIlIIIllllIllllIlIII = lllllllllllllIlIIIllllIllllIlIII.withProperty((IProperty<Comparable>)BlockStoneSlab.SEAMLESS, false);
        }
        else {
            lllllllllllllIlIIIllllIllllIlIII = lllllllllllllIlIIIllllIllllIlIII.withProperty(BlockStoneSlab.HALF, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(lllllllllllllIlIIIllllIllllIlIII.withProperty(BlockStoneSlab.VARIANT, EnumType.STONE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public Comparable<?> getTypeForItem(final ItemStack lllllllllllllIlIIIllllIlllIlIIlI) {
        return EnumType.byMetadata(lllllllllllllIlIIIllllIlllIlIIlI.getMetadata() & 0x7);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIlIIIllllIlllIIlIIl, final NonNullList<ItemStack> lllllllllllllIlIIIllllIlllIIIlIl) {
        final double lllllllllllllIlIIIllllIlllIIIIIl;
        final int lllllllllllllIlIIIllllIlllIIIIlI = ((EnumType[])(Object)(lllllllllllllIlIIIllllIlllIIIIIl = (double)(Object)EnumType.values())).length;
        for (String lllllllllllllIlIIIllllIlllIIIIll = (String)0; lllllllllllllIlIIIllllIlllIIIIll < lllllllllllllIlIIIllllIlllIIIIlI; ++lllllllllllllIlIIIllllIlllIIIIll) {
            final EnumType lllllllllllllIlIIIllllIlllIIIlll = lllllllllllllIlIIIllllIlllIIIIIl[lllllllllllllIlIIIllllIlllIIIIll];
            if (lllllllllllllIlIIIllllIlllIIIlll != EnumType.WOOD) {
                lllllllllllllIlIIIllllIlllIIIlIl.add(new ItemStack(this, 1, lllllllllllllIlIIIllllIlllIIIlll.getMetadata()));
            }
        }
    }
    
    @Override
    public String getUnlocalizedName(final int lllllllllllllIlIIIllllIlllIlIllI) {
        return String.valueOf(super.getUnlocalizedName()) + "." + EnumType.byMetadata(lllllllllllllIlIIIllllIlllIlIllI).getUnlocalizedName();
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlIIIllllIlllIlllll, final BlockPos lllllllllllllIlIIIllllIlllIllllI, final IBlockState lllllllllllllIlIIIllllIlllIlllII) {
        return new ItemStack(Blocks.STONE_SLAB, 1, lllllllllllllIlIIIllllIlllIlllII.getValue(BlockStoneSlab.VARIANT).getMetadata());
    }
    
    public enum EnumType implements IStringSerializable
    {
        NETHERBRICK("NETHERBRICK", 6, 6, MapColor.NETHERRACK, "nether_brick", "netherBrick"), 
        STONE("STONE", 0, 0, MapColor.STONE, "stone"), 
        QUARTZ("QUARTZ", 7, 7, MapColor.QUARTZ, "quartz"), 
        COBBLESTONE("COBBLESTONE", 3, 3, MapColor.STONE, "cobblestone", "cobble");
        
        private final /* synthetic */ int meta;
        
        SMOOTHBRICK("SMOOTHBRICK", 5, 5, MapColor.STONE, "stone_brick", "smoothStoneBrick");
        
        private final /* synthetic */ String name;
        
        WOOD("WOOD", 2, 2, MapColor.WOOD, "wood_old", "wood");
        
        private final /* synthetic */ MapColor mapColor;
        
        BRICK("BRICK", 4, 4, MapColor.RED, "brick");
        
        private final /* synthetic */ String unlocalizedName;
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        SAND("SAND", 1, 1, MapColor.SAND, "sandstone", "sand");
        
        private EnumType(final String lllllllllllIIllllIIIlllIIIlIlIIl, final int lllllllllllIIllllIIIlllIIIlIlIII, final int lllllllllllIIllllIIIlllIIIlIIlll, final MapColor lllllllllllIIllllIIIlllIIIlIIllI, final String lllllllllllIIllllIIIlllIIIlIIlIl) {
            this(lllllllllllIIllllIIIlllIIIlIlIIl, lllllllllllIIllllIIIlllIIIlIlIII, lllllllllllIIllllIIIlllIIIlIIlll, lllllllllllIIllllIIIlllIIIlIIllI, lllllllllllIIllllIIIlllIIIlIIlIl, lllllllllllIIllllIIIlllIIIlIIlIl);
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        private EnumType(final String lllllllllllIIllllIIIlllIIIIlIlll, final int lllllllllllIIllllIIIlllIIIIlIllI, final int lllllllllllIIllllIIIlllIIIIlIlIl, final MapColor lllllllllllIIllllIIIlllIIIIlIlII, final String lllllllllllIIllllIIIlllIIIIllIlI, final String lllllllllllIIllllIIIlllIIIIllIIl) {
            this.meta = lllllllllllIIllllIIIlllIIIIlIlIl;
            this.mapColor = lllllllllllIIllllIIIlllIIIIlIlII;
            this.name = lllllllllllIIllllIIIlllIIIIllIlI;
            this.unlocalizedName = lllllllllllIIllllIIIlllIIIIllIIl;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final int lllllllllllIIllllIIIlllIIIllIlIl;
            final byte lllllllllllIIllllIIIlllIIIllIllI = (byte)((EnumType[])(Object)(lllllllllllIIllllIIIlllIIIllIlIl = (int)(Object)values())).length;
            for (float lllllllllllIIllllIIIlllIIIllIlll = 0; lllllllllllIIllllIIIlllIIIllIlll < lllllllllllIIllllIIIlllIIIllIllI; ++lllllllllllIIllllIIIlllIIIllIlll) {
                final EnumType lllllllllllIIllllIIIlllIIIlllIIl = lllllllllllIIllllIIIlllIIIllIlIl[lllllllllllIIllllIIIlllIIIllIlll];
                EnumType.META_LOOKUP[lllllllllllIIllllIIIlllIIIlllIIl.getMetadata()] = lllllllllllIIllllIIIlllIIIlllIIl;
            }
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        public static EnumType byMetadata(int lllllllllllIIllllIIIlllIIIIIIllI) {
            if (lllllllllllIIllllIIIlllIIIIIIllI < 0 || lllllllllllIIllllIIIlllIIIIIIllI >= EnumType.META_LOOKUP.length) {
                lllllllllllIIllllIIIlllIIIIIIllI = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllIIllllIIIlllIIIIIIllI];
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
