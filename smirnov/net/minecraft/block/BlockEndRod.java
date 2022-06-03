// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.BlockRenderLayer;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumParticleTypes;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockEndRod extends BlockDirectional
{
    protected static final /* synthetic */ AxisAlignedBB END_ROD_VERTICAL_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
    protected static final /* synthetic */ AxisAlignedBB END_ROD_NS_AABB;
    protected static final /* synthetic */ AxisAlignedBB END_ROD_EW_AABB;
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllIlIllIIIIllIlIIlIlIll) {
        return EnumPushReaction.NORMAL;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIllIIIIllIlIIlIlIIl, final IBlockState lllllllllllIlIllIIIIllIlIIlIlIII, final BlockPos lllllllllllIlIllIIIIllIlIIlIIlll, final EnumFacing lllllllllllIlIllIIIIllIlIIlIIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    protected BlockEndRod() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockEndRod.FACING, EnumFacing.UP));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIlIllIIIIllIllIIIlIII, final Rotation lllllllllllIlIllIIIIllIllIIIIlIl) {
        return lllllllllllIlIllIIIIllIllIIIlIII.withProperty((IProperty<Comparable>)BlockEndRod.FACING, lllllllllllIlIllIIIIllIllIIIIlIl.rotate(lllllllllllIlIllIIIIllIllIIIlIII.getValue((IProperty<EnumFacing>)BlockEndRod.FACING)));
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlIllIIIIllIlIlIIllll, final World lllllllllllIlIllIIIIllIlIlIIIlIl, final BlockPos lllllllllllIlIllIIIIllIlIlIIllIl, final Random lllllllllllIlIllIIIIllIlIlIIllII) {
        final EnumFacing lllllllllllIlIllIIIIllIlIlIIlIll = lllllllllllIlIllIIIIllIlIlIIllll.getValue((IProperty<EnumFacing>)BlockEndRod.FACING);
        final double lllllllllllIlIllIIIIllIlIlIIlIlI = lllllllllllIlIllIIIIllIlIlIIllIl.getX() + 0.55 - lllllllllllIlIllIIIIllIlIlIIllII.nextFloat() * 0.1f;
        final double lllllllllllIlIllIIIIllIlIlIIlIIl = lllllllllllIlIllIIIIllIlIlIIllIl.getY() + 0.55 - lllllllllllIlIllIIIIllIlIlIIllII.nextFloat() * 0.1f;
        final double lllllllllllIlIllIIIIllIlIlIIlIII = lllllllllllIlIllIIIIllIlIlIIllIl.getZ() + 0.55 - lllllllllllIlIllIIIIllIlIlIIllII.nextFloat() * 0.1f;
        final double lllllllllllIlIllIIIIllIlIlIIIlll = 0.4f - (lllllllllllIlIllIIIIllIlIlIIllII.nextFloat() + lllllllllllIlIllIIIIllIlIlIIllII.nextFloat()) * 0.4f;
        if (lllllllllllIlIllIIIIllIlIlIIllII.nextInt(5) == 0) {
            lllllllllllIlIllIIIIllIlIlIIIlIl.spawnParticle(EnumParticleTypes.END_ROD, lllllllllllIlIllIIIIllIlIlIIlIlI + lllllllllllIlIllIIIIllIlIlIIlIll.getFrontOffsetX() * lllllllllllIlIllIIIIllIlIlIIIlll, lllllllllllIlIllIIIIllIlIlIIlIIl + lllllllllllIlIllIIIIllIlIlIIlIll.getFrontOffsetY() * lllllllllllIlIllIIIIllIlIlIIIlll, lllllllllllIlIllIIIIllIlIlIIlIII + lllllllllllIlIllIIIIllIlIlIIlIll.getFrontOffsetZ() * lllllllllllIlIllIIIIllIlIlIIIlll, lllllllllllIlIllIIIIllIlIlIIllII.nextGaussian() * 0.005, lllllllllllIlIllIIIIllIlIlIIllII.nextGaussian() * 0.005, lllllllllllIlIllIIIIllIlIlIIllII.nextGaussian() * 0.005, new int[0]);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlIllIIIIllIlIIllIIII) {
        return lllllllllllIlIllIIIIllIlIIllIIII.getValue((IProperty<EnumFacing>)BlockEndRod.FACING).getIndex();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlIllIIIIllIlIllllIll, final IBlockAccess lllllllllllIlIllIIIIllIlIllllIlI, final BlockPos lllllllllllIlIllIIIIllIlIllllIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllIlIllIIIIllIlIllllIll.getValue((IProperty<EnumFacing>)BlockEndRod.FACING).getAxis().ordinal()]) {
            default: {
                return BlockEndRod.END_ROD_EW_AABB;
            }
            case 3: {
                return BlockEndRod.END_ROD_NS_AABB;
            }
            case 2: {
                return BlockEndRod.END_ROD_VERTICAL_AABB;
            }
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIllIIIIllIlIlllIlII) {
        return false;
    }
    
    static {
        END_ROD_VERTICAL_AABB = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625);
        END_ROD_NS_AABB = new AxisAlignedBB(0.375, 0.375, 0.0, 0.625, 0.625, 1.0);
        END_ROD_EW_AABB = new AxisAlignedBB(0.0, 0.375, 0.375, 1.0, 0.625, 0.625);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIlIllIIIIllIlIlllIIlI, final BlockPos lllllllllllIlIllIIIIllIlIlllIIIl) {
        return true;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockEndRod.FACING });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlIllIIIIllIlIIllIlIl) {
        IBlockState lllllllllllIlIllIIIIllIlIIllIlll = this.getDefaultState();
        lllllllllllIlIllIIIIllIlIIllIlll = lllllllllllIlIllIIIIllIlIIllIlll.withProperty((IProperty<Comparable>)BlockEndRod.FACING, EnumFacing.getFront(lllllllllllIlIllIIIIllIlIIllIlIl));
        return lllllllllllIlIllIIIIllIlIIllIlll;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIlIllIIIIllIlIlllllll, final Mirror lllllllllllIlIllIIIIllIllIIIIIII) {
        return lllllllllllIlIllIIIIllIlIlllllll.withProperty((IProperty<Comparable>)BlockEndRod.FACING, lllllllllllIlIllIIIIllIllIIIIIII.mirror(lllllllllllIlIllIIIIllIlIlllllll.getValue((IProperty<EnumFacing>)BlockEndRod.FACING)));
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIlIllIIIIllIlIlIllllI, final BlockPos lllllllllllIlIllIIIIllIlIllIlIII, final EnumFacing lllllllllllIlIllIIIIllIlIlIlllII, final float lllllllllllIlIllIIIIllIlIllIIllI, final float lllllllllllIlIllIIIIllIlIllIIlIl, final float lllllllllllIlIllIIIIllIlIllIIlII, final int lllllllllllIlIllIIIIllIlIllIIIll, final EntityLivingBase lllllllllllIlIllIIIIllIlIllIIIlI) {
        final IBlockState lllllllllllIlIllIIIIllIlIllIIIIl = lllllllllllIlIllIIIIllIlIlIllllI.getBlockState(lllllllllllIlIllIIIIllIlIllIlIII.offset(lllllllllllIlIllIIIIllIlIlIlllII.getOpposite()));
        if (lllllllllllIlIllIIIIllIlIllIIIIl.getBlock() == Blocks.END_ROD) {
            final EnumFacing lllllllllllIlIllIIIIllIlIllIIIII = lllllllllllIlIllIIIIllIlIllIIIIl.getValue((IProperty<EnumFacing>)BlockEndRod.FACING);
            if (lllllllllllIlIllIIIIllIlIllIIIII == lllllllllllIlIllIIIIllIlIlIlllII) {
                return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEndRod.FACING, lllllllllllIlIllIIIIllIlIlIlllII.getOpposite());
            }
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEndRod.FACING, lllllllllllIlIllIIIIllIlIlIlllII);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlIllIIIIllIlIlllIllI) {
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = BlockEndRod.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final int lllllllllllIlIllIIIIllIlIIlIIlII = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllIlIllIIIIllIlIIlIIlII[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIllIIIIllIlIIlIIlII[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIllIIIIllIlIIlIIlII[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockEndRod.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllIlIllIIIIllIlIIlIIlII;
    }
}
