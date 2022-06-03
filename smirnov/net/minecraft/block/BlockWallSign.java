// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.Rotation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyDirection;

public class BlockWallSign extends BlockSign
{
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB SIGN_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB SIGN_SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB SIGN_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB SIGN_WEST_AABB;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockWallSign.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final long lllllllllllIIIlIlllIllIlllllIlIl = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIIIlIlllIllIlllllIlIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIlIlllIllIlllllIlIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIlIlllIllIlllllIlIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIIlIlllIllIlllllIlIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIIlIlllIllIlllllIlIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIIlIlllIllIlllllIlIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockWallSign.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIIIlIlllIllIlllllIlIl;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIIlIlllIlllIIIlIIIIl, final World lllllllllllIIIlIlllIlllIIIlIIIII, final BlockPos lllllllllllIIIlIlllIlllIIIIllIII, final Block lllllllllllIIIlIlllIlllIIIIlIlll, final BlockPos lllllllllllIIIlIlllIlllIIIIlIllI) {
        final EnumFacing lllllllllllIIIlIlllIlllIIIIlllII = lllllllllllIIIlIlllIlllIIIlIIIIl.getValue((IProperty<EnumFacing>)BlockWallSign.FACING);
        if (!lllllllllllIIIlIlllIlllIIIlIIIII.getBlockState(lllllllllllIIIlIlllIlllIIIIllIII.offset(lllllllllllIIIlIlllIlllIIIIlllII.getOpposite())).getMaterial().isSolid()) {
            this.dropBlockAsItem(lllllllllllIIIlIlllIlllIIIlIIIII, lllllllllllIIIlIlllIlllIIIIllIII, lllllllllllIIIlIlllIlllIIIlIIIIl, 0);
            lllllllllllIIIlIlllIlllIIIlIIIII.setBlockToAir(lllllllllllIIIlIlllIlllIIIIllIII);
        }
        super.neighborChanged(lllllllllllIIIlIlllIlllIIIlIIIIl, lllllllllllIIIlIlllIlllIIIlIIIII, lllllllllllIIIlIlllIlllIIIIllIII, lllllllllllIIIlIlllIlllIIIIlIlll, lllllllllllIIIlIlllIlllIIIIlIllI);
    }
    
    public BlockWallSign() {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockWallSign.FACING, EnumFacing.NORTH));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIIlIlllIlllIIIlIllIl, final IBlockAccess lllllllllllIIIlIlllIlllIIIlIllII, final BlockPos lllllllllllIIIlIlllIlllIIIlIlIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIIIlIlllIlllIIIlIllIl.getValue((IProperty<EnumFacing>)BlockWallSign.FACING).ordinal()]) {
            default: {
                return BlockWallSign.SIGN_NORTH_AABB;
            }
            case 4: {
                return BlockWallSign.SIGN_SOUTH_AABB;
            }
            case 5: {
                return BlockWallSign.SIGN_WEST_AABB;
            }
            case 6: {
                return BlockWallSign.SIGN_EAST_AABB;
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIlIlllIlllIIIIlIIII) {
        EnumFacing lllllllllllIIIlIlllIlllIIIIIllll = EnumFacing.getFront(lllllllllllIIIlIlllIlllIIIIlIIII);
        if (lllllllllllIIIlIlllIlllIIIIIllll.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllIIIlIlllIlllIIIIIllll = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockWallSign.FACING, lllllllllllIIIlIlllIlllIIIIIllll);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIIlIlllIlllIIIIIIIlI, final Rotation lllllllllllIIIlIlllIlllIIIIIIIll) {
        return lllllllllllIIIlIlllIlllIIIIIIIlI.withProperty((IProperty<Comparable>)BlockWallSign.FACING, lllllllllllIIIlIlllIlllIIIIIIIll.rotate(lllllllllllIIIlIlllIlllIIIIIIIlI.getValue((IProperty<EnumFacing>)BlockWallSign.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIlIlllIlllIIIIIlIII) {
        return lllllllllllIIIlIlllIlllIIIIIlIII.getValue((IProperty<EnumFacing>)BlockWallSign.FACING).getIndex();
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        SIGN_EAST_AABB = new AxisAlignedBB(0.0, 0.28125, 0.0, 0.125, 0.78125, 1.0);
        SIGN_WEST_AABB = new AxisAlignedBB(0.875, 0.28125, 0.0, 1.0, 0.78125, 1.0);
        SIGN_SOUTH_AABB = new AxisAlignedBB(0.0, 0.28125, 0.0, 1.0, 0.78125, 0.125);
        SIGN_NORTH_AABB = new AxisAlignedBB(0.0, 0.28125, 0.875, 1.0, 0.78125, 1.0);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockWallSign.FACING });
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIIlIlllIllIllllllIll, final Mirror lllllllllllIIIlIlllIllIlllllllII) {
        return lllllllllllIIIlIlllIllIllllllIll.withRotation(lllllllllllIIIlIlllIllIlllllllII.toRotation(lllllllllllIIIlIlllIllIllllllIll.getValue((IProperty<EnumFacing>)BlockWallSign.FACING)));
    }
}
