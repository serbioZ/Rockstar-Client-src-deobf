// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.block.material.Material;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.Rotation;
import net.minecraft.item.Item;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockQuartz extends Block
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockQuartz$EnumType = BlockQuartz.$SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockQuartz$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockQuartz$EnumType;
        }
        final char llllllllllIlllIIlIIlllllllllllIl = (Object)new int[EnumType.values().length];
        try {
            llllllllllIlllIIlIIlllllllllllIl[EnumType.CHISELED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIIlIIlllllllllllIl[EnumType.DEFAULT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIIlIIlllllllllllIl[EnumType.LINES_X.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllIlllIIlIIlllllllllllIl[EnumType.LINES_Y.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllIlllIIlIIlllllllllllIl[EnumType.LINES_Z.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return BlockQuartz.$SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType = (int[])(Object)llllllllllIlllIIlIIlllllllllllIl;
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llllllllllIlllIIlIlIIIIIIIlIIIIl) {
        final EnumType llllllllllIlllIIlIlIIIIIIIlIIIll = llllllllllIlllIIlIlIIIIIIIlIIIIl.getValue(BlockQuartz.VARIANT);
        return (llllllllllIlllIIlIlIIIIIIIlIIIll != EnumType.LINES_X && llllllllllIlllIIlIlIIIIIIIlIIIll != EnumType.LINES_Z) ? super.getSilkTouchDrop(llllllllllIlllIIlIlIIIIIIIlIIIIl) : new ItemStack(Item.getItemFromBlock(this), 1, EnumType.LINES_Y.getMetadata());
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllIlllIIlIlIIIIIIIIIIlll, final Rotation llllllllllIlllIIlIlIIIIIIIIIIlII) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllIlllIIlIlIIIIIIIIIIlII.ordinal()]) {
            case 2:
            case 4: {
                switch ($SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType()[llllllllllIlllIIlIlIIIIIIIIIIlll.getValue(BlockQuartz.VARIANT).ordinal()]) {
                    case 4: {
                        return llllllllllIlllIIlIlIIIIIIIIIIlll.withProperty(BlockQuartz.VARIANT, EnumType.LINES_Z);
                    }
                    case 5: {
                        return llllllllllIlllIIlIlIIIIIIIIIIlll.withProperty(BlockQuartz.VARIANT, EnumType.LINES_X);
                    }
                    default: {
                        return llllllllllIlllIIlIlIIIIIIIIIIlll;
                    }
                }
                break;
            }
            default: {
                return llllllllllIlllIIlIlIIIIIIIIIIlll;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockQuartz.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final short llllllllllIlllIIlIIllllllllllIll = (Object)new int[Rotation.values().length];
        try {
            llllllllllIlllIIlIIllllllllllIll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIIlIIllllllllllIll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIIlIIllllllllllIll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllIlllIIlIIllllllllllIll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockQuartz.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllIlllIIlIIllllllllllIll;
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockQuartz.VARIANT });
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllIlllIIlIlIIIIIIIIlIlll, final IBlockAccess llllllllllIlllIIlIlIIIIIIIIlIllI, final BlockPos llllllllllIlllIIlIlIIIIIIIIlIlIl) {
        return MapColor.QUARTZ;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllIlllIIlIlIIIIIIIlllIlI, final BlockPos llllllllllIlllIIlIlIIIIIIIlllIIl, final EnumFacing llllllllllIlllIIlIlIIIIIIIllIIIl, final float llllllllllIlllIIlIlIIIIIIIllIlll, final float llllllllllIlllIIlIlIIIIIIIllIllI, final float llllllllllIlllIIlIlIIIIIIIllIlIl, final int llllllllllIlllIIlIlIIIIIIIllIIII, final EntityLivingBase llllllllllIlllIIlIlIIIIIIIllIIll) {
        if (llllllllllIlllIIlIlIIIIIIIllIIII == EnumType.LINES_Y.getMetadata()) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[llllllllllIlllIIlIlIIIIIIIllIIIl.getAxis().ordinal()]) {
                case 3: {
                    return this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.LINES_Z);
                }
                case 1: {
                    return this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.LINES_X);
                }
                case 2: {
                    return this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.LINES_Y);
                }
            }
        }
        return (llllllllllIlllIIlIlIIIIIIIllIIII == EnumType.CHISELED.getMetadata()) ? this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.CHISELED) : this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.DEFAULT);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllIlllIIlIlIIIIIIIlIllII) {
        final EnumType llllllllllIlllIIlIlIIIIIIIlIlIll = llllllllllIlllIIlIlIIIIIIIlIllII.getValue(BlockQuartz.VARIANT);
        return (llllllllllIlllIIlIlIIIIIIIlIlIll != EnumType.LINES_X && llllllllllIlllIIlIlIIIIIIIlIlIll != EnumType.LINES_Z) ? llllllllllIlllIIlIlIIIIIIIlIlIll.getMetadata() : EnumType.LINES_Y.getMetadata();
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllIlllIIlIlIIIIIIIIIllII) {
        return llllllllllIlllIIlIlIIIIIIIIIllII.getValue(BlockQuartz.VARIANT).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllIlllIIlIlIIIIIIIIIllll) {
        return this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.byMetadata(llllllllllIlllIIlIlIIIIIIIIIllll));
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllIlllIIlIlIIIIIIIIlllII, final NonNullList<ItemStack> llllllllllIlllIIlIlIIIIIIIIllIIl) {
        llllllllllIlllIIlIlIIIIIIIIllIIl.add(new ItemStack(this, 1, EnumType.DEFAULT.getMetadata()));
        llllllllllIlllIIlIlIIIIIIIIllIIl.add(new ItemStack(this, 1, EnumType.CHISELED.getMetadata()));
        llllllllllIlllIIlIlIIIIIIIIllIIl.add(new ItemStack(this, 1, EnumType.LINES_Y.getMetadata()));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = BlockQuartz.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final char llllllllllIlllIIlIIlllllllllllll = (Object)new int[EnumFacing.Axis.values().length];
        try {
            llllllllllIlllIIlIIlllllllllllll[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIIlIIlllllllllllll[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIIlIIlllllllllllll[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockQuartz.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)llllllllllIlllIIlIIlllllllllllll;
    }
    
    public BlockQuartz() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockQuartz.VARIANT, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    public enum EnumType implements IStringSerializable
    {
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        LINES_Y("LINES_Y", 2, 2, "lines_y", "lines");
        
        private final /* synthetic */ String unlocalizedName;
        
        DEFAULT("DEFAULT", 0, 0, "default", "default"), 
        LINES_Z("LINES_Z", 4, 4, "lines_z", "lines"), 
        LINES_X("LINES_X", 3, 3, "lines_x", "lines");
        
        private final /* synthetic */ String serializedName;
        private final /* synthetic */ int meta;
        
        CHISELED("CHISELED", 1, 1, "chiseled", "chiseled");
        
        private EnumType(final String llllllllllllIIIlIIlIIIIlllllIIIl, final int llllllllllllIIIlIIlIIIIlllllIIII, final int llllllllllllIIIlIIlIIIIllllIllll, final String llllllllllllIIIlIIlIIIIllllIlllI, final String llllllllllllIIIlIIlIIIIlllllIIll) {
            this.meta = llllllllllllIIIlIIlIIIIllllIllll;
            this.serializedName = llllllllllllIIIlIIlIIIIllllIlllI;
            this.unlocalizedName = llllllllllllIIIlIIlIIIIlllllIIll;
        }
        
        @Override
        public String toString() {
            return this.unlocalizedName;
        }
        
        public static EnumType byMetadata(int llllllllllllIIIlIIlIIIIllllIIlIl) {
            if (llllllllllllIIIlIIlIIIIllllIIlIl < 0 || llllllllllllIIIlIIlIIIIllllIIlIl >= EnumType.META_LOOKUP.length) {
                llllllllllllIIIlIIlIIIIllllIIlIl = 0;
            }
            return EnumType.META_LOOKUP[llllllllllllIIIlIIlIIIIllllIIlIl];
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final double llllllllllllIIIlIIlIIIIlllllllIl;
            final char llllllllllllIIIlIIlIIIIllllllllI = (char)((EnumType[])(Object)(llllllllllllIIIlIIlIIIIlllllllIl = (double)(Object)values())).length;
            for (long llllllllllllIIIlIIlIIIIlllllllll = 0; llllllllllllIIIlIIlIIIIlllllllll < llllllllllllIIIlIIlIIIIllllllllI; ++llllllllllllIIIlIIlIIIIlllllllll) {
                final EnumType llllllllllllIIIlIIlIIIlIIIIIIIIl = llllllllllllIIIlIIlIIIIlllllllIl[llllllllllllIIIlIIlIIIIlllllllll];
                EnumType.META_LOOKUP[llllllllllllIIIlIIlIIIlIIIIIIIIl.getMetadata()] = llllllllllllIIIlIIlIIIlIIIIIIIIl;
            }
        }
        
        @Override
        public String getName() {
            return this.serializedName;
        }
    }
}
