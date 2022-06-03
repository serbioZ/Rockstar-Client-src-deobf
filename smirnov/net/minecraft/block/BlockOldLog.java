// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockStateContainer;
import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockOldLog extends BlockLog
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis;
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllIlIIIlIIIIlllIlIllII, final IBlockAccess llllllllllllIlIIIlIIIIlllIlIllll, final BlockPos llllllllllllIlIIIlIIIIlllIlIlllI) {
        final BlockPlanks.EnumType llllllllllllIlIIIlIIIIlllIlIllIl = llllllllllllIlIIIlIIIIlllIlIllII.getValue(BlockOldLog.VARIANT);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[llllllllllllIlIIIlIIIIlllIlIllII.getValue(BlockOldLog.LOG_AXIS).ordinal()]) {
            default: {
                switch ($SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType()[llllllllllllIlIIIlIIIIlllIlIllIl.ordinal()]) {
                    default: {
                        return BlockPlanks.EnumType.SPRUCE.getMapColor();
                    }
                    case 2: {
                        return BlockPlanks.EnumType.DARK_OAK.getMapColor();
                    }
                    case 3: {
                        return MapColor.QUARTZ;
                    }
                    case 4: {
                        return BlockPlanks.EnumType.SPRUCE.getMapColor();
                    }
                }
                break;
            }
            case 2: {
                return llllllllllllIlIIIlIIIIlllIlIllIl.getMapColor();
            }
        }
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllIlIIIlIIIIlllIlIIlll, final NonNullList<ItemStack> llllllllllllIlIIIlIIIIlllIlIIlII) {
        llllllllllllIlIIIlIIIIlllIlIIlII.add(new ItemStack(this, 1, BlockPlanks.EnumType.OAK.getMetadata()));
        llllllllllllIlIIIlIIIIlllIlIIlII.add(new ItemStack(this, 1, BlockPlanks.EnumType.SPRUCE.getMetadata()));
        llllllllllllIlIIIlIIIIlllIlIIlII.add(new ItemStack(this, 1, BlockPlanks.EnumType.BIRCH.getMetadata()));
        llllllllllllIlIIIlIIIIlllIlIIlII.add(new ItemStack(this, 1, BlockPlanks.EnumType.JUNGLE.getMetadata()));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIIIlIIIIlllIIlIlIl) {
        int llllllllllllIlIIIlIIIIlllIIlIllI = 0;
        llllllllllllIlIIIlIIIIlllIIlIllI |= llllllllllllIlIIIlIIIIlllIIlIlIl.getValue(BlockOldLog.VARIANT).getMetadata();
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[llllllllllllIlIIIlIIIIlllIIlIlIl.getValue(BlockOldLog.LOG_AXIS).ordinal()]) {
            case 1: {
                llllllllllllIlIIIlIIIIlllIIlIllI |= 0x4;
                break;
            }
            case 3: {
                llllllllllllIlIIIlIIIIlllIIlIllI |= 0x8;
                break;
            }
            case 4: {
                llllllllllllIlIIIlIIIIlllIIlIllI |= 0xC;
                break;
            }
        }
        return llllllllllllIlIIIlIIIIlllIIlIllI;
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llllllllllllIlIIIlIIIIlllIIIllIl) {
        return new ItemStack(Item.getItemFromBlock(this), 1, llllllllllllIlIIIlIIIIlllIIIllIl.getValue(BlockOldLog.VARIANT).getMetadata());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIIIlIIIIlllIIlllII) {
        IBlockState llllllllllllIlIIIlIIIIlllIIllllI = this.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.byMetadata((llllllllllllIlIIIlIIIIlllIIlllII & 0x3) % 4));
        switch (llllllllllllIlIIIlIIIIlllIIlllII & 0xC) {
            case 0: {
                llllllllllllIlIIIlIIIIlllIIllllI = llllllllllllIlIIIlIIIIlllIIllllI.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Y);
                break;
            }
            case 4: {
                llllllllllllIlIIIlIIIIlllIIllllI = llllllllllllIlIIIlIIIIlllIIllllI.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.X);
                break;
            }
            case 8: {
                llllllllllllIlIIIlIIIIlllIIllllI = llllllllllllIlIIIlIIIIlllIIllllI.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Z);
                break;
            }
            default: {
                llllllllllllIlIIIlIIIIlllIIllllI = llllllllllllIlIIIlIIIIlllIIllllI.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.NONE);
                break;
            }
        }
        return llllllllllllIlIIIlIIIIlllIIllllI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis() {
        final int[] $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis = BlockOldLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        if ($switch_TABLE$net$minecraft$block$BlockLog$EnumAxis != null) {
            return $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        }
        final Exception llllllllllllIlIIIlIIIIlllIIIIIll = (Object)new int[EnumAxis.values().length];
        try {
            llllllllllllIlIIIlIIIIlllIIIIIll[EnumAxis.NONE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIIIlIIIIlllIIIIIll[EnumAxis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIlIIIlIIIIlllIIIIIll[EnumAxis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIlIIIlIIIIlllIIIIIll[EnumAxis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockOldLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis = (int[])(Object)llllllllllllIlIIIlIIIIlllIIIIIll;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType = BlockOldLog.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockPlanks$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        }
        final String llllllllllllIlIIIlIIIIlllIIIIlIl = (Object)new int[BlockPlanks.EnumType.values().length];
        try {
            llllllllllllIlIIIlIIIIlllIIIIlIl[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIIIlIIIIlllIIIIlIl[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIlIIIlIIIIlllIIIIlIl[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIlIIIlIIIIlllIIIIlIl[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIlIIIlIIIIlllIIIIlIl[BlockPlanks.EnumType.OAK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIlIIIlIIIIlllIIIIlIl[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockOldLog.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType = (int[])(Object)llllllllllllIlIIIlIIIIlllIIIIlIl;
    }
    
    public BlockOldLog() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Y));
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllIlIIIlIIIIlllIIIIlll) {
        return llllllllllllIlIIIlIIIIlllIIIIlll.getValue(BlockOldLog.VARIANT).getMetadata();
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (com.google.common.base.Predicate<BlockPlanks.EnumType>)new Predicate<BlockPlanks.EnumType>() {
            public boolean apply(@Nullable final BlockPlanks.EnumType llllllllllllIllIIlIlIIllIlIIIlIl) {
                return llllllllllllIllIIlIlIIllIlIIIlIl.getMetadata() < 4;
            }
        });
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockOldLog.VARIANT, BlockOldLog.LOG_AXIS });
    }
}
