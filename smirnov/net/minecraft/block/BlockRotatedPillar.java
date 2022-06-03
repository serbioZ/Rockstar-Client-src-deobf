// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rotation;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.PropertyEnum;

public class BlockRotatedPillar extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumFacing.Axis> AXIS;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllllIlIllIllllIllII, final BlockPos lllllllllllllllllIlIllIllllIlIll, final EnumFacing lllllllllllllllllIlIllIlllllIIll, final float lllllllllllllllllIlIllIlllllIIlI, final float lllllllllllllllllIlIllIllllIlIII, final float lllllllllllllllllIlIllIllllIIlll, final int lllllllllllllllllIlIllIllllIllll, final EntityLivingBase lllllllllllllllllIlIllIllllIlllI) {
        return super.onBlockPlaced(lllllllllllllllllIlIllIllllIllII, lllllllllllllllllIlIllIllllIlIll, lllllllllllllllllIlIllIlllllIIll, lllllllllllllllllIlIllIlllllIIlI, lllllllllllllllllIlIllIllllIlIII, lllllllllllllllllIlIllIllllIIlll, lllllllllllllllllIlIllIllllIllll, lllllllllllllllllIlIllIllllIlllI).withProperty(BlockRotatedPillar.AXIS, lllllllllllllllllIlIllIlllllIIll.getAxis());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIlIlllIIIIlIlll) {
        EnumFacing.Axis lllllllllllllllllIlIlllIIIIlIllI = EnumFacing.Axis.Y;
        final int lllllllllllllllllIlIlllIIIIlIlIl = lllllllllllllllllIlIlllIIIIlIlll & 0xC;
        if (lllllllllllllllllIlIlllIIIIlIlIl == 4) {
            lllllllllllllllllIlIlllIIIIlIllI = EnumFacing.Axis.X;
        }
        else if (lllllllllllllllllIlIlllIIIIlIlIl == 8) {
            lllllllllllllllllIlIlllIIIIlIllI = EnumFacing.Axis.Z;
        }
        return this.getDefaultState().withProperty(BlockRotatedPillar.AXIS, lllllllllllllllllIlIlllIIIIlIllI);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllllIlIlllIIIlIIIII, final Rotation lllllllllllllllllIlIlllIIIIlllll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllllllIlIlllIIIIlllll.ordinal()]) {
            case 2:
            case 4: {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllllllIlIlllIIIlIIIII.getValue(BlockRotatedPillar.AXIS).ordinal()]) {
                    case 1: {
                        return lllllllllllllllllIlIlllIIIlIIIII.withProperty(BlockRotatedPillar.AXIS, EnumFacing.Axis.Z);
                    }
                    case 3: {
                        return lllllllllllllllllIlIlllIIIlIIIII.withProperty(BlockRotatedPillar.AXIS, EnumFacing.Axis.X);
                    }
                    default: {
                        return lllllllllllllllllIlIlllIIIlIIIII;
                    }
                }
                break;
            }
            default: {
                return lllllllllllllllllIlIlllIIIlIIIII;
            }
        }
    }
    
    static {
        AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = BlockRotatedPillar.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final double lllllllllllllllllIlIllIllllIIIll = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllllllllIlIllIllllIIIll[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlIllIllllIIIll[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlIllIllllIIIll[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRotatedPillar.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllllllllIlIllIllllIIIll;
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState lllllllllllllllllIlIlllIIIIIIIIl) {
        return new ItemStack(Item.getItemFromBlock(this));
    }
    
    protected BlockRotatedPillar(final Material lllllllllllllllllIlIlllIIIlIllll) {
        super(lllllllllllllllllIlIlllIIIlIllll, lllllllllllllllllIlIlllIIIlIllll.getMaterialMapColor());
    }
    
    protected BlockRotatedPillar(final Material lllllllllllllllllIlIlllIIIlIIlIl, final MapColor lllllllllllllllllIlIlllIIIlIIlII) {
        super(lllllllllllllllllIlIlllIIIlIIlIl, lllllllllllllllllIlIlllIIIlIIlII);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRotatedPillar.AXIS });
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRotatedPillar.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final Exception lllllllllllllllllIlIllIllllIIIIl = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllllllIlIllIllllIIIIl[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlIllIllllIIIIl[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlIllIllllIIIIl[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllIlIllIllllIIIIl[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRotatedPillar.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllllllIlIllIllllIIIIl;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIlIlllIIIIIllII) {
        int lllllllllllllllllIlIlllIIIIIlIll = 0;
        final EnumFacing.Axis lllllllllllllllllIlIlllIIIIIlIlI = lllllllllllllllllIlIlllIIIIIllII.getValue(BlockRotatedPillar.AXIS);
        if (lllllllllllllllllIlIlllIIIIIlIlI == EnumFacing.Axis.X) {
            lllllllllllllllllIlIlllIIIIIlIll |= 0x4;
        }
        else if (lllllllllllllllllIlIlllIIIIIlIlI == EnumFacing.Axis.Z) {
            lllllllllllllllllIlIlllIIIIIlIll |= 0x8;
        }
        return lllllllllllllllllIlIlllIIIIIlIll;
    }
}
