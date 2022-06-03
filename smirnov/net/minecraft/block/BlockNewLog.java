// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockNewLog extends BlockLog
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    
    @Override
    public int damageDropped(final IBlockState llllllllllllIIIllllllIIlIlIIIIIl) {
        return llllllllllllIIIllllllIIlIlIIIIIl.getValue(BlockNewLog.VARIANT).getMetadata() - 4;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType = BlockNewLog.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockPlanks$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        }
        final byte llllllllllllIIIllllllIIlIIlllllI = (Object)new int[BlockPlanks.EnumType.values().length];
        try {
            llllllllllllIIIllllllIIlIIlllllI[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIIllllllIIlIIlllllI[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIIllllllIIlIIlllllI[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIIllllllIIlIIlllllI[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIIIllllllIIlIIlllllI[BlockPlanks.EnumType.OAK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIIIllllllIIlIIlllllI[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockNewLog.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType = (int[])(Object)llllllllllllIIIllllllIIlIIlllllI;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIIllllllIIlIlIllIII) {
        IBlockState llllllllllllIIIllllllIIlIlIlIlll = this.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.byMetadata((llllllllllllIIIllllllIIlIlIllIII & 0x3) + 4));
        switch (llllllllllllIIIllllllIIlIlIllIII & 0xC) {
            case 0: {
                llllllllllllIIIllllllIIlIlIlIlll = llllllllllllIIIllllllIIlIlIlIlll.withProperty(BlockNewLog.LOG_AXIS, EnumAxis.Y);
                break;
            }
            case 4: {
                llllllllllllIIIllllllIIlIlIlIlll = llllllllllllIIIllllllIIlIlIlIlll.withProperty(BlockNewLog.LOG_AXIS, EnumAxis.X);
                break;
            }
            case 8: {
                llllllllllllIIIllllllIIlIlIlIlll = llllllllllllIIIllllllIIlIlIlIlll.withProperty(BlockNewLog.LOG_AXIS, EnumAxis.Z);
                break;
            }
            default: {
                llllllllllllIIIllllllIIlIlIlIlll = llllllllllllIIIllllllIIlIlIlIlll.withProperty(BlockNewLog.LOG_AXIS, EnumAxis.NONE);
                break;
            }
        }
        return llllllllllllIIIllllllIIlIlIlIlll;
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llllllllllllIIIllllllIIlIlIIIllI) {
        return new ItemStack(Item.getItemFromBlock(this), 1, llllllllllllIIIllllllIIlIlIIIllI.getValue(BlockNewLog.VARIANT).getMetadata() - 4);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis() {
        final int[] $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis = BlockNewLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        if ($switch_TABLE$net$minecraft$block$BlockLog$EnumAxis != null) {
            return $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        }
        final short llllllllllllIIIllllllIIlIIllllII = (Object)new int[EnumAxis.values().length];
        try {
            llllllllllllIIIllllllIIlIIllllII[EnumAxis.NONE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIIllllllIIlIIllllII[EnumAxis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIIllllllIIlIIllllII[EnumAxis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIIllllllIIlIIllllII[EnumAxis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockNewLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis = (int[])(Object)llllllllllllIIIllllllIIlIIllllII;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllIIIllllllIIlIllIIIII, final NonNullList<ItemStack> llllllllllllIIIllllllIIlIlIlllll) {
        llllllllllllIIIllllllIIlIlIlllll.add(new ItemStack(this, 1, BlockPlanks.EnumType.ACACIA.getMetadata() - 4));
        llllllllllllIIIllllllIIlIlIlllll.add(new ItemStack(this, 1, BlockPlanks.EnumType.DARK_OAK.getMetadata() - 4));
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (com.google.common.base.Predicate<BlockPlanks.EnumType>)new Predicate<BlockPlanks.EnumType>() {
            public boolean apply(@Nullable final BlockPlanks.EnumType llllllllllllIlllllIIIIIlIllIIllI) {
                return llllllllllllIlllllIIIIIlIllIIllI.getMetadata() >= 4;
            }
        });
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIIllllllIIlIlIlIIII) {
        int llllllllllllIIIllllllIIlIlIIllll = 0;
        llllllllllllIIIllllllIIlIlIIllll |= llllllllllllIIIllllllIIlIlIlIIII.getValue(BlockNewLog.VARIANT).getMetadata() - 4;
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[llllllllllllIIIllllllIIlIlIlIIII.getValue(BlockNewLog.LOG_AXIS).ordinal()]) {
            case 1: {
                llllllllllllIIIllllllIIlIlIIllll |= 0x4;
                break;
            }
            case 3: {
                llllllllllllIIIllllllIIlIlIIllll |= 0x8;
                break;
            }
            case 4: {
                llllllllllllIIIllllllIIlIlIIllll |= 0xC;
                break;
            }
        }
        return llllllllllllIIIllllllIIlIlIIllll;
    }
    
    public BlockNewLog() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockNewLog.LOG_AXIS, EnumAxis.Y));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllIIIllllllIIlIllIlIIl, final IBlockAccess llllllllllllIIIllllllIIlIllIlIII, final BlockPos llllllllllllIIIllllllIIlIllIIlll) {
        final BlockPlanks.EnumType llllllllllllIIIllllllIIlIllIIllI = llllllllllllIIIllllllIIlIllIlIIl.getValue(BlockNewLog.VARIANT);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[llllllllllllIIIllllllIIlIllIlIIl.getValue(BlockNewLog.LOG_AXIS).ordinal()]) {
            default: {
                switch ($SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType()[llllllllllllIIIllllllIIlIllIIllI.ordinal()]) {
                    default: {
                        return MapColor.STONE;
                    }
                    case 6: {
                        return BlockPlanks.EnumType.DARK_OAK.getMapColor();
                    }
                }
                break;
            }
            case 2: {
                return llllllllllllIIIllllllIIlIllIIllI.getMapColor();
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockNewLog.VARIANT, BlockNewLog.LOG_AXIS });
    }
}
