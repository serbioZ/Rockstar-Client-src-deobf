// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockLadder extends Block
{
    protected static final /* synthetic */ AxisAlignedBB LADDER_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB LADDER_NORTH_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB LADDER_WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB LADDER_SOUTH_AABB;
    
    static {
        FACING = BlockHorizontal.FACING;
        LADDER_EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.1875, 1.0, 1.0);
        LADDER_WEST_AABB = new AxisAlignedBB(0.8125, 0.0, 0.0, 1.0, 1.0, 1.0);
        LADDER_SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.1875);
        LADDER_NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.8125, 1.0, 1.0, 1.0);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIlIIllIlIlIIIlllIlIl, final IBlockState lllllllllllIIlIIllIlIlIIIlllIlII, final BlockPos lllllllllllIIlIIllIlIlIIIlllIIll, final EnumFacing lllllllllllIIlIIllIlIlIIIlllIIlI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllIIlIIllIlIlIIllIlIIll, final BlockPos lllllllllllIIlIIllIlIlIIllIlIIlI, final EnumFacing lllllllllllIIlIIllIlIlIIllIlIIIl) {
        return this.func_193392_c(lllllllllllIIlIIllIlIlIIllIlIIll, lllllllllllIIlIIllIlIlIIllIlIIlI.west(), lllllllllllIIlIIllIlIlIIllIlIIIl) || this.func_193392_c(lllllllllllIIlIIllIlIlIIllIlIIll, lllllllllllIIlIIllIlIlIIllIlIIlI.east(), lllllllllllIIlIIllIlIlIIllIlIIIl) || this.func_193392_c(lllllllllllIIlIIllIlIlIIllIlIIll, lllllllllllIIlIIllIlIlIIllIlIIlI.north(), lllllllllllIIlIIllIlIlIIllIlIIIl) || this.func_193392_c(lllllllllllIIlIIllIlIlIIllIlIIll, lllllllllllIIlIIllIlIlIIllIlIIlI.south(), lllllllllllIIlIIllIlIlIIllIlIIIl);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIlIIllIlIlIIllIlllIl) {
        return false;
    }
    
    private boolean func_193392_c(final World lllllllllllIIlIIllIlIlIIllIIlIlI, final BlockPos lllllllllllIIlIIllIlIlIIllIIIlII, final EnumFacing lllllllllllIIlIIllIlIlIIllIIlIII) {
        final IBlockState lllllllllllIIlIIllIlIlIIllIIIlll = lllllllllllIIlIIllIlIlIIllIIlIlI.getBlockState(lllllllllllIIlIIllIlIlIIllIIIlII);
        final boolean lllllllllllIIlIIllIlIlIIllIIIllI = Block.func_193382_c(lllllllllllIIlIIllIlIlIIllIIIlll.getBlock());
        return !lllllllllllIIlIIllIlIlIIllIIIllI && lllllllllllIIlIIllIlIlIIllIIIlll.func_193401_d(lllllllllllIIlIIllIlIlIIllIIlIlI, lllllllllllIIlIIllIlIlIIllIIIlII, lllllllllllIIlIIllIlIlIIllIIlIII) == BlockFaceShape.SOLID && !lllllllllllIIlIIllIlIlIIllIIIlll.canProvidePower();
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIIlIIllIlIlIIlIlIllll, final BlockPos lllllllllllIIlIIllIlIlIIlIlIlllI, final EnumFacing lllllllllllIIlIIllIlIlIIlIllIlll, final float lllllllllllIIlIIllIlIlIIlIllIllI, final float lllllllllllIIlIIllIlIlIIlIllIlIl, final float lllllllllllIIlIIllIlIlIIlIllIlII, final int lllllllllllIIlIIllIlIlIIlIllIIll, final EntityLivingBase lllllllllllIIlIIllIlIlIIlIllIIlI) {
        if (lllllllllllIIlIIllIlIlIIlIllIlll.getAxis().isHorizontal() && this.func_193392_c(lllllllllllIIlIIllIlIlIIlIlIllll, lllllllllllIIlIIllIlIlIIlIlIlllI.offset(lllllllllllIIlIIllIlIlIIlIllIlll.getOpposite()), lllllllllllIIlIIllIlIlIIlIllIlll)) {
            return this.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, lllllllllllIIlIIllIlIlIIlIllIlll);
        }
        for (final EnumFacing lllllllllllIIlIIllIlIlIIlIllIIIl : EnumFacing.Plane.HORIZONTAL) {
            if (this.func_193392_c(lllllllllllIIlIIllIlIlIIlIlIllll, lllllllllllIIlIIllIlIlIIlIlIlllI.offset(lllllllllllIIlIIllIlIlIIlIllIIIl.getOpposite()), lllllllllllIIlIIllIlIlIIlIllIIIl)) {
                return this.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, lllllllllllIIlIIllIlIlIIlIllIIIl);
            }
        }
        return this.getDefaultState();
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockLadder.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short lllllllllllIIlIIllIlIlIIIlllIIII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIIlIIllIlIlIIIlllIIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlIIllIlIlIIIlllIIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlIIllIlIlIIIlllIIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIlIIllIlIlIIIlllIIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIlIIllIlIlIIIlllIIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIlIIllIlIlIIIlllIIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockLadder.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIIlIIllIlIlIIIlllIIII;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIlIIllIlIlIIlllIIlII, final IBlockAccess lllllllllllIIlIIllIlIlIIlllIIIll, final BlockPos lllllllllllIIlIIllIlIlIIlllIIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIIlIIllIlIlIIlllIIlII.getValue((IProperty<EnumFacing>)BlockLadder.FACING).ordinal()]) {
            case 3: {
                return BlockLadder.LADDER_NORTH_AABB;
            }
            case 4: {
                return BlockLadder.LADDER_SOUTH_AABB;
            }
            case 5: {
                return BlockLadder.LADDER_WEST_AABB;
            }
            default: {
                return BlockLadder.LADDER_EAST_AABB;
            }
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIlIIllIlIlIIlIlIIIlI, final World lllllllllllIIlIIllIlIlIIlIlIIIIl, final BlockPos lllllllllllIIlIIllIlIlIIlIIllIIl, final Block lllllllllllIIlIIllIlIlIIlIIllIII, final BlockPos lllllllllllIIlIIllIlIlIIlIIlIlll) {
        final EnumFacing lllllllllllIIlIIllIlIlIIlIIlllIl = lllllllllllIIlIIllIlIlIIlIlIIIlI.getValue((IProperty<EnumFacing>)BlockLadder.FACING);
        if (!this.func_193392_c(lllllllllllIIlIIllIlIlIIlIlIIIIl, lllllllllllIIlIIllIlIlIIlIIllIIl.offset(lllllllllllIIlIIllIlIlIIlIIlllIl.getOpposite()), lllllllllllIIlIIllIlIlIIlIIlllIl)) {
            this.dropBlockAsItem(lllllllllllIIlIIllIlIlIIlIlIIIIl, lllllllllllIIlIIllIlIlIIlIIllIIl, lllllllllllIIlIIllIlIlIIlIlIIIlI, 0);
            lllllllllllIIlIIllIlIlIIlIlIIIIl.setBlockToAir(lllllllllllIIlIIllIlIlIIlIIllIIl);
        }
        super.neighborChanged(lllllllllllIIlIIllIlIlIIlIlIIIlI, lllllllllllIIlIIllIlIlIIlIlIIIIl, lllllllllllIIlIIllIlIlIIlIIllIIl, lllllllllllIIlIIllIlIlIIlIIllIII, lllllllllllIIlIIllIlIlIIlIIlIlll);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIlIIllIlIlIIlIIlIIII) {
        EnumFacing lllllllllllIIlIIllIlIlIIlIIIllll = EnumFacing.getFront(lllllllllllIIlIIllIlIlIIlIIlIIII);
        if (lllllllllllIIlIIllIlIlIIlIIIllll.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllIIlIIllIlIlIIlIIIllll = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, lllllllllllIIlIIllIlIlIIlIIIllll);
    }
    
    protected BlockLadder() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.NORTH));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockLadder.FACING });
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIlIIllIlIlIIllIlllll) {
        return false;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIlIIllIlIlIIIllllIll, final Mirror lllllllllllIIlIIllIlIlIIIllllIlI) {
        return lllllllllllIIlIIllIlIlIIIllllIll.withRotation(lllllllllllIIlIIllIlIlIIIllllIlI.toRotation(lllllllllllIIlIIllIlIlIIIllllIll.getValue((IProperty<EnumFacing>)BlockLadder.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlIIllIlIlIIlIIIlIII) {
        return lllllllllllIIlIIllIlIlIIlIIIlIII.getValue((IProperty<EnumFacing>)BlockLadder.FACING).getIndex();
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIlIIllIlIlIIlIIIIlII, final Rotation lllllllllllIIlIIllIlIlIIlIIIIIIl) {
        return lllllllllllIIlIIllIlIlIIlIIIIlII.withProperty((IProperty<Comparable>)BlockLadder.FACING, lllllllllllIIlIIllIlIlIIlIIIIIIl.rotate(lllllllllllIIlIIllIlIlIIlIIIIlII.getValue((IProperty<EnumFacing>)BlockLadder.FACING)));
    }
}
