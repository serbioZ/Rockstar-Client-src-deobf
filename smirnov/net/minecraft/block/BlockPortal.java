// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.math.Vec3i;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityPigZombie;
import javax.annotation.Nullable;
import net.minecraft.util.Rotation;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.BlockWorldState;
import com.google.common.cache.LoadingCache;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.PropertyEnum;

public class BlockPortal extends BlockBreakable
{
    public static final /* synthetic */ PropertyEnum<EnumFacing.Axis> AXIS;
    protected static final /* synthetic */ AxisAlignedBB Z_AABB;
    protected static final /* synthetic */ AxisAlignedBB X_AABB;
    protected static final /* synthetic */ AxisAlignedBB Y_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlIIlIlllIIllllIlllIl) {
        return this.getDefaultState().withProperty(BlockPortal.AXIS, ((lllllllllllIlIIlIlllIIllllIlllIl & 0x3) == 0x2) ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIIlIlllIlIIIlIlllII) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIIlIlllIIlllIIlllIl, final IBlockState lllllllllllIlIIlIlllIIlllIIlllII, final BlockPos lllllllllllIlIIlIlllIIlllIIllIll, final EnumFacing lllllllllllIlIIlIlllIIlllIIllIlI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    public BlockPattern.PatternHelper createPatternHelper(final World lllllllllllIlIIlIlllIIlllIlIlllI, final BlockPos lllllllllllIlIIlIlllIIlllIllllII) {
        EnumFacing.Axis lllllllllllIlIIlIlllIIlllIlllIll = EnumFacing.Axis.Z;
        Size lllllllllllIlIIlIlllIIlllIlllIlI = new Size(lllllllllllIlIIlIlllIIlllIlIlllI, lllllllllllIlIIlIlllIIlllIllllII, EnumFacing.Axis.X);
        final LoadingCache<BlockPos, BlockWorldState> lllllllllllIlIIlIlllIIlllIlllIIl = BlockPattern.createLoadingCache(lllllllllllIlIIlIlllIIlllIlIlllI, true);
        if (!lllllllllllIlIIlIlllIIlllIlllIlI.isValid()) {
            lllllllllllIlIIlIlllIIlllIlllIll = EnumFacing.Axis.X;
            lllllllllllIlIIlIlllIIlllIlllIlI = new Size(lllllllllllIlIIlIlllIIlllIlIlllI, lllllllllllIlIIlIlllIIlllIllllII, EnumFacing.Axis.Z);
        }
        if (!lllllllllllIlIIlIlllIIlllIlllIlI.isValid()) {
            return new BlockPattern.PatternHelper(lllllllllllIlIIlIlllIIlllIllllII, EnumFacing.NORTH, EnumFacing.UP, lllllllllllIlIIlIlllIIlllIlllIIl, 1, 1, 1);
        }
        final int[] lllllllllllIlIIlIlllIIlllIlllIII = new int[EnumFacing.AxisDirection.values().length];
        final EnumFacing lllllllllllIlIIlIlllIIlllIllIlll = lllllllllllIlIIlIlllIIlllIlllIlI.rightDir.rotateYCCW();
        final BlockPos lllllllllllIlIIlIlllIIlllIllIllI = lllllllllllIlIIlIlllIIlllIlllIlI.bottomLeft.up(lllllllllllIlIIlIlllIIlllIlllIlI.getHeight() - 1);
        short lllllllllllIlIIlIlllIIlllIlIIIll;
        for (byte lllllllllllIlIIlIlllIIlllIlIIlII = (byte)((EnumFacing.AxisDirection[])(Object)(lllllllllllIlIIlIlllIIlllIlIIIll = (short)(Object)EnumFacing.AxisDirection.values())).length, b = 0; b < lllllllllllIlIIlIlllIIlllIlIIlII; ++b) {
            final EnumFacing.AxisDirection lllllllllllIlIIlIlllIIlllIllIlIl = lllllllllllIlIIlIlllIIlllIlIIIll[b];
            final BlockPattern.PatternHelper lllllllllllIlIIlIlllIIlllIllIlII = new BlockPattern.PatternHelper((lllllllllllIlIIlIlllIIlllIllIlll.getAxisDirection() == lllllllllllIlIIlIlllIIlllIllIlIl) ? lllllllllllIlIIlIlllIIlllIllIllI : lllllllllllIlIIlIlllIIlllIllIllI.offset(lllllllllllIlIIlIlllIIlllIlllIlI.rightDir, lllllllllllIlIIlIlllIIlllIlllIlI.getWidth() - 1), EnumFacing.getFacingFromAxis(lllllllllllIlIIlIlllIIlllIllIlIl, lllllllllllIlIIlIlllIIlllIlllIll), EnumFacing.UP, lllllllllllIlIIlIlllIIlllIlllIIl, lllllllllllIlIIlIlllIIlllIlllIlI.getWidth(), lllllllllllIlIIlIlllIIlllIlllIlI.getHeight(), 1);
            for (int lllllllllllIlIIlIlllIIlllIllIIll = 0; lllllllllllIlIIlIlllIIlllIllIIll < lllllllllllIlIIlIlllIIlllIlllIlI.getWidth(); ++lllllllllllIlIIlIlllIIlllIllIIll) {
                for (int lllllllllllIlIIlIlllIIlllIllIIlI = 0; lllllllllllIlIIlIlllIIlllIllIIlI < lllllllllllIlIIlIlllIIlllIlllIlI.getHeight(); ++lllllllllllIlIIlIlllIIlllIllIIlI) {
                    final BlockWorldState lllllllllllIlIIlIlllIIlllIllIIIl = lllllllllllIlIIlIlllIIlllIllIlII.translateOffset(lllllllllllIlIIlIlllIIlllIllIIll, lllllllllllIlIIlIlllIIlllIllIIlI, 1);
                    if (lllllllllllIlIIlIlllIIlllIllIIIl.getBlockState() != null && lllllllllllIlIIlIlllIIlllIllIIIl.getBlockState().getMaterial() != Material.AIR) {
                        final int[] array = lllllllllllIlIIlIlllIIlllIlllIII;
                        final int ordinal = lllllllllllIlIIlIlllIIlllIllIlIl.ordinal();
                        ++array[ordinal];
                    }
                }
            }
        }
        EnumFacing.AxisDirection lllllllllllIlIIlIlllIIlllIllIIII = EnumFacing.AxisDirection.POSITIVE;
        final EnumFacing.AxisDirection[] values;
        lllllllllllIlIIlIlllIIlllIlIIIll = (short)(values = EnumFacing.AxisDirection.values()).length;
        for (byte lllllllllllIlIIlIlllIIlllIlIIlII = 0; lllllllllllIlIIlIlllIIlllIlIIlII < lllllllllllIlIIlIlllIIlllIlIIIll; ++lllllllllllIlIIlIlllIIlllIlIIlII) {
            final EnumFacing.AxisDirection lllllllllllIlIIlIlllIIlllIlIllll = values[lllllllllllIlIIlIlllIIlllIlIIlII];
            if (lllllllllllIlIIlIlllIIlllIlllIII[lllllllllllIlIIlIlllIIlllIlIllll.ordinal()] < lllllllllllIlIIlIlllIIlllIlllIII[lllllllllllIlIIlIlllIIlllIllIIII.ordinal()]) {
                lllllllllllIlIIlIlllIIlllIllIIII = lllllllllllIlIIlIlllIIlllIlIllll;
            }
        }
        return new BlockPattern.PatternHelper((lllllllllllIlIIlIlllIIlllIllIlll.getAxisDirection() == lllllllllllIlIIlIlllIIlllIllIIII) ? lllllllllllIlIIlIlllIIlllIllIllI : lllllllllllIlIIlIlllIIlllIllIllI.offset(lllllllllllIlIIlIlllIIlllIlllIlI.rightDir, lllllllllllIlIIlIlllIIlllIlllIlI.getWidth() - 1), EnumFacing.getFacingFromAxis(lllllllllllIlIIlIlllIIlllIllIIII, lllllllllllIlIIlIlllIIlllIlllIll), EnumFacing.UP, lllllllllllIlIIlIlllIIlllIlllIIl, lllllllllllIlIIlIlllIIlllIlllIlI.getWidth(), lllllllllllIlIIlIlllIIlllIlllIlI.getHeight(), 1);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIlIIlIlllIlIIIlIIlIII, final World lllllllllllIlIIlIlllIlIIIlIIIlll, final BlockPos lllllllllllIlIIlIlllIlIIIlIIIllI, final Block lllllllllllIlIIlIlllIlIIIlIIIlIl, final BlockPos lllllllllllIlIIlIlllIlIIIlIIIlII) {
        final EnumFacing.Axis lllllllllllIlIIlIlllIlIIIlIIIIll = lllllllllllIlIIlIlllIlIIIlIIlIII.getValue(BlockPortal.AXIS);
        if (lllllllllllIlIIlIlllIlIIIlIIIIll == EnumFacing.Axis.X) {
            final Size lllllllllllIlIIlIlllIlIIIlIIIIlI = new Size(lllllllllllIlIIlIlllIlIIIlIIIlll, lllllllllllIlIIlIlllIlIIIlIIIllI, EnumFacing.Axis.X);
            if (!lllllllllllIlIIlIlllIlIIIlIIIIlI.isValid() || lllllllllllIlIIlIlllIlIIIlIIIIlI.portalBlockCount < lllllllllllIlIIlIlllIlIIIlIIIIlI.width * lllllllllllIlIIlIlllIlIIIlIIIIlI.height) {
                lllllllllllIlIIlIlllIlIIIlIIIlll.setBlockState(lllllllllllIlIIlIlllIlIIIlIIIllI, Blocks.AIR.getDefaultState());
            }
        }
        else if (lllllllllllIlIIlIlllIlIIIlIIIIll == EnumFacing.Axis.Z) {
            final Size lllllllllllIlIIlIlllIlIIIlIIIIIl = new Size(lllllllllllIlIIlIlllIlIIIlIIIlll, lllllllllllIlIIlIlllIlIIIlIIIllI, EnumFacing.Axis.Z);
            if (!lllllllllllIlIIlIlllIlIIIlIIIIIl.isValid() || lllllllllllIlIIlIlllIlIIIlIIIIIl.portalBlockCount < lllllllllllIlIIlIlllIlIIIlIIIIIl.width * lllllllllllIlIIlIlllIlIIIlIIIIIl.height) {
                lllllllllllIlIIlIlllIlIIIlIIIlll.setBlockState(lllllllllllIlIIlIlllIlIIIlIIIllI, Blocks.AIR.getDefaultState());
            }
        }
    }
    
    public BlockPortal() {
        super(Material.PORTAL, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPortal.AXIS, EnumFacing.Axis.X));
        this.setTickRandomly(true);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIlIIlIlllIlIIIIlIlllI, final IBlockAccess lllllllllllIlIIlIlllIlIIIIlIIIIl, BlockPos lllllllllllIlIIlIlllIlIIIIlIIIII, final EnumFacing lllllllllllIlIIlIlllIlIIIIIlllll) {
        lllllllllllIlIIlIlllIlIIIIlIIIII = lllllllllllIlIIlIlllIlIIIIlIIIII.offset(lllllllllllIlIIlIlllIlIIIIIlllll);
        EnumFacing.Axis lllllllllllIlIIlIlllIlIIIIlIlIlI = null;
        if (lllllllllllIlIIlIlllIlIIIIlIlllI.getBlock() == this) {
            lllllllllllIlIIlIlllIlIIIIlIlIlI = lllllllllllIlIIlIlllIlIIIIlIlllI.getValue(BlockPortal.AXIS);
            if (lllllllllllIlIIlIlllIlIIIIlIlIlI == null) {
                return false;
            }
            if (lllllllllllIlIIlIlllIlIIIIlIlIlI == EnumFacing.Axis.Z && lllllllllllIlIIlIlllIlIIIIIlllll != EnumFacing.EAST && lllllllllllIlIIlIlllIlIIIIIlllll != EnumFacing.WEST) {
                return false;
            }
            if (lllllllllllIlIIlIlllIlIIIIlIlIlI == EnumFacing.Axis.X && lllllllllllIlIIlIlllIlIIIIIlllll != EnumFacing.SOUTH && lllllllllllIlIIlIlllIlIIIIIlllll != EnumFacing.NORTH) {
                return false;
            }
        }
        final boolean lllllllllllIlIIlIlllIlIIIIlIlIIl = lllllllllllIlIIlIlllIlIIIIlIIIIl.getBlockState(lllllllllllIlIIlIlllIlIIIIlIIIII.west()).getBlock() == this && lllllllllllIlIIlIlllIlIIIIlIIIIl.getBlockState(lllllllllllIlIIlIlllIlIIIIlIIIII.west(2)).getBlock() != this;
        final boolean lllllllllllIlIIlIlllIlIIIIlIlIII = lllllllllllIlIIlIlllIlIIIIlIIIIl.getBlockState(lllllllllllIlIIlIlllIlIIIIlIIIII.east()).getBlock() == this && lllllllllllIlIIlIlllIlIIIIlIIIIl.getBlockState(lllllllllllIlIIlIlllIlIIIIlIIIII.east(2)).getBlock() != this;
        final boolean lllllllllllIlIIlIlllIlIIIIlIIlll = lllllllllllIlIIlIlllIlIIIIlIIIIl.getBlockState(lllllllllllIlIIlIlllIlIIIIlIIIII.north()).getBlock() == this && lllllllllllIlIIlIlllIlIIIIlIIIIl.getBlockState(lllllllllllIlIIlIlllIlIIIIlIIIII.north(2)).getBlock() != this;
        final boolean lllllllllllIlIIlIlllIlIIIIlIIllI = lllllllllllIlIIlIlllIlIIIIlIIIIl.getBlockState(lllllllllllIlIIlIlllIlIIIIlIIIII.south()).getBlock() == this && lllllllllllIlIIlIlllIlIIIIlIIIIl.getBlockState(lllllllllllIlIIlIlllIlIIIIlIIIII.south(2)).getBlock() != this;
        final boolean lllllllllllIlIIlIlllIlIIIIlIIlIl = lllllllllllIlIIlIlllIlIIIIlIlIIl || lllllllllllIlIIlIlllIlIIIIlIlIII || lllllllllllIlIIlIlllIlIIIIlIlIlI == EnumFacing.Axis.X;
        final boolean lllllllllllIlIIlIlllIlIIIIlIIlII = lllllllllllIlIIlIlllIlIIIIlIIlll || lllllllllllIlIIlIlllIlIIIIlIIllI || lllllllllllIlIIlIlllIlIIIIlIlIlI == EnumFacing.Axis.Z;
        return (lllllllllllIlIIlIlllIlIIIIlIIlIl && lllllllllllIlIIlIlllIlIIIIIlllll == EnumFacing.WEST) || (lllllllllllIlIIlIlllIlIIIIlIIlIl && lllllllllllIlIIlIlllIlIIIIIlllll == EnumFacing.EAST) || (lllllllllllIlIIlIlllIlIIIIlIIlII && lllllllllllIlIIlIlllIlIIIIIlllll == EnumFacing.NORTH) || (lllllllllllIlIIlIlllIlIIIIlIIlII && lllllllllllIlIIlIlllIlIIIIIlllll == EnumFacing.SOUTH);
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlIIlIlllIIlllllllllI, final World lllllllllllIlIIlIlllIIllllllllIl, final BlockPos lllllllllllIlIIlIlllIIllllllllII, final Random lllllllllllIlIIlIlllIIlllllllIll) {
        if (lllllllllllIlIIlIlllIIlllllllIll.nextInt(100) == 0) {
            lllllllllllIlIIlIlllIIllllllllIl.playSound(lllllllllllIlIIlIlllIIllllllllII.getX() + 0.5, lllllllllllIlIIlIlllIIllllllllII.getY() + 0.5, lllllllllllIlIIlIlllIIllllllllII.getZ() + 0.5, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5f, lllllllllllIlIIlIlllIIlllllllIll.nextFloat() * 0.4f + 0.8f, false);
        }
        for (int lllllllllllIlIIlIlllIIlllllllIlI = 0; lllllllllllIlIIlIlllIIlllllllIlI < 4; ++lllllllllllIlIIlIlllIIlllllllIlI) {
            double lllllllllllIlIIlIlllIIlllllllIIl = lllllllllllIlIIlIlllIIllllllllII.getX() + lllllllllllIlIIlIlllIIlllllllIll.nextFloat();
            final double lllllllllllIlIIlIlllIIlllllllIII = lllllllllllIlIIlIlllIIllllllllII.getY() + lllllllllllIlIIlIlllIIlllllllIll.nextFloat();
            double lllllllllllIlIIlIlllIIllllllIlll = lllllllllllIlIIlIlllIIllllllllII.getZ() + lllllllllllIlIIlIlllIIlllllllIll.nextFloat();
            double lllllllllllIlIIlIlllIIllllllIllI = (lllllllllllIlIIlIlllIIlllllllIll.nextFloat() - 0.5) * 0.5;
            final double lllllllllllIlIIlIlllIIllllllIlIl = (lllllllllllIlIIlIlllIIlllllllIll.nextFloat() - 0.5) * 0.5;
            double lllllllllllIlIIlIlllIIllllllIlII = (lllllllllllIlIIlIlllIIlllllllIll.nextFloat() - 0.5) * 0.5;
            final int lllllllllllIlIIlIlllIIllllllIIll = lllllllllllIlIIlIlllIIlllllllIll.nextInt(2) * 2 - 1;
            if (lllllllllllIlIIlIlllIIllllllllIl.getBlockState(lllllllllllIlIIlIlllIIllllllllII.west()).getBlock() != this && lllllllllllIlIIlIlllIIllllllllIl.getBlockState(lllllllllllIlIIlIlllIIllllllllII.east()).getBlock() != this) {
                lllllllllllIlIIlIlllIIlllllllIIl = lllllllllllIlIIlIlllIIllllllllII.getX() + 0.5 + 0.25 * lllllllllllIlIIlIlllIIllllllIIll;
                lllllllllllIlIIlIlllIIllllllIllI = lllllllllllIlIIlIlllIIlllllllIll.nextFloat() * 2.0f * lllllllllllIlIIlIlllIIllllllIIll;
            }
            else {
                lllllllllllIlIIlIlllIIllllllIlll = lllllllllllIlIIlIlllIIllllllllII.getZ() + 0.5 + 0.25 * lllllllllllIlIIlIlllIIllllllIIll;
                lllllllllllIlIIlIlllIIllllllIlII = lllllllllllIlIIlIlllIIlllllllIll.nextFloat() * 2.0f * lllllllllllIlIIlIlllIIllllllIIll;
            }
            lllllllllllIlIIlIlllIIllllllllIl.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllIlIIlIlllIIlllllllIIl, lllllllllllIlIIlIlllIIlllllllIII, lllllllllllIlIIlIlllIIllllllIlll, lllllllllllIlIIlIlllIIllllllIllI, lllllllllllIlIIlIlllIIllllllIlIl, lllllllllllIlIIlIlllIIllllllIlII, new int[0]);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlIIlIlllIIllllIllIIl) {
        return getMetaForAxis(lllllllllllIlIIlIlllIIllllIllIIl.getValue(BlockPortal.AXIS));
    }
    
    public boolean trySpawnPortal(final World lllllllllllIlIIlIlllIlIIIlIlIIlI, final BlockPos lllllllllllIlIIlIlllIlIIIlIlIlIl) {
        final Size lllllllllllIlIIlIlllIlIIIlIlIlII = new Size(lllllllllllIlIIlIlllIlIIIlIlIIlI, lllllllllllIlIIlIlllIlIIIlIlIlIl, EnumFacing.Axis.X);
        if (lllllllllllIlIIlIlllIlIIIlIlIlII.isValid() && lllllllllllIlIIlIlllIlIIIlIlIlII.portalBlockCount == 0) {
            lllllllllllIlIIlIlllIlIIIlIlIlII.placePortalBlocks();
            return true;
        }
        final Size lllllllllllIlIIlIlllIlIIIlIlIIll = new Size(lllllllllllIlIIlIlllIlIIIlIlIIlI, lllllllllllIlIIlIlllIlIIIlIlIlIl, EnumFacing.Axis.Z);
        if (lllllllllllIlIIlIlllIlIIIlIlIIll.isValid() && lllllllllllIlIIlIlllIlIIIlIlIIll.portalBlockCount == 0) {
            lllllllllllIlIIlIlllIlIIIlIlIIll.placePortalBlocks();
            return true;
        }
        return false;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIlIIlIlllIIlllllIIlIl, final BlockPos lllllllllllIlIIlIlllIIlllllIIlII, final IBlockState lllllllllllIlIIlIlllIIlllllIIIll) {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlIIlIlllIlIIlIIIIIII, final IBlockAccess lllllllllllIlIIlIlllIlIIIlllllll, final BlockPos lllllllllllIlIIlIlllIlIIIllllllI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllIlIIlIlllIlIIlIIIIIII.getValue(BlockPortal.AXIS).ordinal()]) {
            case 1: {
                return BlockPortal.X_AABB;
            }
            default: {
                return BlockPortal.Y_AABB;
            }
            case 3: {
                return BlockPortal.Z_AABB;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockPortal.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final float lllllllllllIlIIlIlllIIlllIIlIllI = (Object)new int[Rotation.values().length];
        try {
            lllllllllllIlIIlIlllIIlllIIlIllI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIlIlllIIlllIIlIllI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIlIlllIIlllIIlIllI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIlIlllIIlllIIlIllI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockPortal.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllIlIIlIlllIIlllIIlIllI;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIlIIlIlllIlIIIllIIIll, final IBlockAccess lllllllllllIlIIlIlllIlIIIllIIIlI, final BlockPos lllllllllllIlIIlIlllIlIIIllIIIIl) {
        return BlockPortal.NULL_AABB;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIlIIlIlllIlIIIIIlIllI) {
        return 0;
    }
    
    static {
        AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);
        X_AABB = new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.0, 0.625);
        Z_AABB = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.0, 1.0);
        Y_AABB = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625);
    }
    
    public static int getMetaForAxis(final EnumFacing.Axis lllllllllllIlIIlIlllIlIIIlIllllI) {
        if (lllllllllllIlIIlIlllIlIIIlIllllI == EnumFacing.Axis.X) {
            return 1;
        }
        return (lllllllllllIlIIlIlllIlIIIlIllllI == EnumFacing.Axis.Z) ? 2 : 0;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIlIIlIlllIIllllIlIlIl, final Rotation lllllllllllIlIIlIlllIIllllIlIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllIlIIlIlllIIllllIlIIlI.ordinal()]) {
            case 2:
            case 4: {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllIlIIlIlllIIllllIlIlIl.getValue(BlockPortal.AXIS).ordinal()]) {
                    case 1: {
                        return lllllllllllIlIIlIlllIIllllIlIlIl.withProperty(BlockPortal.AXIS, EnumFacing.Axis.Z);
                    }
                    case 3: {
                        return lllllllllllIlIIlIlllIIllllIlIlIl.withProperty(BlockPortal.AXIS, EnumFacing.Axis.X);
                    }
                    default: {
                        return lllllllllllIlIIlIlllIIllllIlIlIl;
                    }
                }
                break;
            }
            default: {
                return lllllllllllIlIIlIlllIIllllIlIlIl;
            }
        }
    }
    
    @Override
    public void updateTick(final World lllllllllllIlIIlIlllIlIIIlllIIll, final BlockPos lllllllllllIlIIlIlllIlIIIllIlIlI, final IBlockState lllllllllllIlIIlIlllIlIIIlllIIIl, final Random lllllllllllIlIIlIlllIlIIIlllIIII) {
        super.updateTick(lllllllllllIlIIlIlllIlIIIlllIIll, lllllllllllIlIIlIlllIlIIIllIlIlI, lllllllllllIlIIlIlllIlIIIlllIIIl, lllllllllllIlIIlIlllIlIIIlllIIII);
        if (lllllllllllIlIIlIlllIlIIIlllIIll.provider.isSurfaceWorld() && lllllllllllIlIIlIlllIlIIIlllIIll.getGameRules().getBoolean("doMobSpawning") && lllllllllllIlIIlIlllIlIIIlllIIII.nextInt(2000) < lllllllllllIlIIlIlllIlIIIlllIIll.getDifficulty().getDifficultyId()) {
            final int lllllllllllIlIIlIlllIlIIIllIllll = lllllllllllIlIIlIlllIlIIIllIlIlI.getY();
            BlockPos lllllllllllIlIIlIlllIlIIIllIlllI;
            for (lllllllllllIlIIlIlllIlIIIllIlllI = lllllllllllIlIIlIlllIlIIIllIlIlI; !lllllllllllIlIIlIlllIlIIIlllIIll.getBlockState(lllllllllllIlIIlIlllIlIIIllIlllI).isFullyOpaque() && lllllllllllIlIIlIlllIlIIIllIlllI.getY() > 0; lllllllllllIlIIlIlllIlIIIllIlllI = lllllllllllIlIIlIlllIlIIIllIlllI.down()) {}
            if (lllllllllllIlIIlIlllIlIIIllIllll > 0 && !lllllllllllIlIIlIlllIlIIIlllIIll.getBlockState(lllllllllllIlIIlIlllIlIIIllIlllI.up()).isNormalCube()) {
                final Entity lllllllllllIlIIlIlllIlIIIllIllIl = ItemMonsterPlacer.spawnCreature(lllllllllllIlIIlIlllIlIIIlllIIll, EntityList.func_191306_a(EntityPigZombie.class), lllllllllllIlIIlIlllIlIIIllIlllI.getX() + 0.5, lllllllllllIlIIlIlllIlIIIllIlllI.getY() + 1.1, lllllllllllIlIIlIlllIlIIIllIlllI.getZ() + 0.5);
                if (lllllllllllIlIIlIlllIlIIIllIllIl != null) {
                    lllllllllllIlIIlIlllIlIIIllIllIl.timeUntilPortal = lllllllllllIlIIlIlllIlIIIllIllIl.getPortalCooldown();
                }
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPortal.AXIS });
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = BlockPortal.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final short lllllllllllIlIIlIlllIIlllIIllIII = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllIlIIlIlllIIlllIIllIII[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIlIlllIIlllIIllIII[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIlIlllIIlllIIllIII[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockPortal.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllIlIIlIlllIIlllIIllIII;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllIlIIlIlllIlIIIIIlIIIl, final BlockPos lllllllllllIlIIlIlllIlIIIIIIllIl, final IBlockState lllllllllllIlIIlIlllIlIIIIIIllll, final Entity lllllllllllIlIIlIlllIlIIIIIIllII) {
        if (!lllllllllllIlIIlIlllIlIIIIIIllII.isRiding() && !lllllllllllIlIIlIlllIlIIIIIIllII.isBeingRidden() && lllllllllllIlIIlIlllIlIIIIIIllII.isNonBoss()) {
            lllllllllllIlIIlIlllIlIIIIIIllII.setPortal(lllllllllllIlIIlIlllIlIIIIIIllIl);
        }
    }
    
    public static class Size
    {
        private final /* synthetic */ EnumFacing leftDir;
        private /* synthetic */ BlockPos bottomLeft;
        private /* synthetic */ int height;
        private final /* synthetic */ World world;
        private /* synthetic */ int width;
        private /* synthetic */ int portalBlockCount;
        private final /* synthetic */ EnumFacing rightDir;
        private final /* synthetic */ EnumFacing.Axis axis;
        
        public Size(final World lllllllllllllllIlIIIlIllllllIIll, BlockPos lllllllllllllllIlIIIlIlllllIllII, final EnumFacing.Axis lllllllllllllllIlIIIlIlllllIlIll) {
            this.world = lllllllllllllllIlIIIlIllllllIIll;
            this.axis = lllllllllllllllIlIIIlIlllllIlIll;
            if (lllllllllllllllIlIIIlIlllllIlIll == EnumFacing.Axis.X) {
                this.leftDir = EnumFacing.EAST;
                this.rightDir = EnumFacing.WEST;
            }
            else {
                this.leftDir = EnumFacing.NORTH;
                this.rightDir = EnumFacing.SOUTH;
            }
            for (BlockPos lllllllllllllllIlIIIlIllllllIIII = (BlockPos)lllllllllllllllIlIIIlIlllllIllII; ((Vec3i)lllllllllllllllIlIIIlIlllllIllII).getY() > lllllllllllllllIlIIIlIllllllIIII.getY() - 21 && ((Vec3i)lllllllllllllllIlIIIlIlllllIllII).getY() > 0 && this.isEmptyBlock(lllllllllllllllIlIIIlIllllllIIll.getBlockState(((BlockPos)lllllllllllllllIlIIIlIlllllIllII).down()).getBlock()); lllllllllllllllIlIIIlIlllllIllII = ((BlockPos)lllllllllllllllIlIIIlIlllllIllII).down()) {}
            final int lllllllllllllllIlIIIlIlllllIllll = this.getDistanceUntilEdge((BlockPos)lllllllllllllllIlIIIlIlllllIllII, this.leftDir) - 1;
            if (lllllllllllllllIlIIIlIlllllIllll >= 0) {
                this.bottomLeft = ((BlockPos)lllllllllllllllIlIIIlIlllllIllII).offset(this.leftDir, lllllllllllllllIlIIIlIlllllIllll);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
                if (this.width < 2 || this.width > 21) {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }
            if (this.bottomLeft != null) {
                this.height = this.calculatePortalHeight();
            }
        }
        
        protected boolean isEmptyBlock(final Block lllllllllllllllIlIIIlIllllIIIlII) {
            return lllllllllllllllIlIIIlIllllIIIlII.blockMaterial == Material.AIR || lllllllllllllllIlIIIlIllllIIIlII == Blocks.FIRE || lllllllllllllllIlIIIlIllllIIIlII == Blocks.PORTAL;
        }
        
        public void placePortalBlocks() {
            for (int lllllllllllllllIlIIIlIlllIlllIlI = 0; lllllllllllllllIlIIIlIlllIlllIlI < this.width; ++lllllllllllllllIlIIIlIlllIlllIlI) {
                final BlockPos lllllllllllllllIlIIIlIlllIlllIIl = this.bottomLeft.offset(this.rightDir, lllllllllllllllIlIIIlIlllIlllIlI);
                for (int lllllllllllllllIlIIIlIlllIlllIII = 0; lllllllllllllllIlIIIlIlllIlllIII < this.height; ++lllllllllllllllIlIIIlIlllIlllIII) {
                    this.world.setBlockState(lllllllllllllllIlIIIlIlllIlllIIl.up(lllllllllllllllIlIIIlIlllIlllIII), Blocks.PORTAL.getDefaultState().withProperty(BlockPortal.AXIS, this.axis), 2);
                }
            }
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }
        
        public int getWidth() {
            return this.width;
        }
        
        protected int calculatePortalHeight() {
            this.height = 0;
        Label_0181:
            while (this.height < 21) {
                for (int lllllllllllllllIlIIIlIllllIIlllI = 0; lllllllllllllllIlIIIlIllllIIlllI < this.width; ++lllllllllllllllIlIIIlIllllIIlllI) {
                    final BlockPos lllllllllllllllIlIIIlIllllIIllIl = this.bottomLeft.offset(this.rightDir, lllllllllllllllIlIIIlIllllIIlllI).up(this.height);
                    Block lllllllllllllllIlIIIlIllllIIllII = this.world.getBlockState(lllllllllllllllIlIIIlIllllIIllIl).getBlock();
                    if (!this.isEmptyBlock(lllllllllllllllIlIIIlIllllIIllII)) {
                        break Label_0181;
                    }
                    if (lllllllllllllllIlIIIlIllllIIllII == Blocks.PORTAL) {
                        ++this.portalBlockCount;
                    }
                    if (lllllllllllllllIlIIIlIllllIIlllI == 0) {
                        lllllllllllllllIlIIIlIllllIIllII = this.world.getBlockState(lllllllllllllllIlIIIlIllllIIllIl.offset(this.leftDir)).getBlock();
                        if (lllllllllllllllIlIIIlIllllIIllII != Blocks.OBSIDIAN) {
                            break Label_0181;
                        }
                    }
                    else if (lllllllllllllllIlIIIlIllllIIlllI == this.width - 1) {
                        lllllllllllllllIlIIIlIllllIIllII = this.world.getBlockState(lllllllllllllllIlIIIlIllllIIllIl.offset(this.rightDir)).getBlock();
                        if (lllllllllllllllIlIIIlIllllIIllII != Blocks.OBSIDIAN) {
                            break Label_0181;
                        }
                    }
                }
                ++this.height;
            }
            for (int lllllllllllllllIlIIIlIllllIIlIll = 0; lllllllllllllllIlIIIlIllllIIlIll < this.width; ++lllllllllllllllIlIIIlIllllIIlIll) {
                if (this.world.getBlockState(this.bottomLeft.offset(this.rightDir, lllllllllllllllIlIIIlIllllIIlIll).up(this.height)).getBlock() != Blocks.OBSIDIAN) {
                    this.height = 0;
                    break;
                }
            }
            if (this.height <= 21 && this.height >= 3) {
                return this.height;
            }
            this.bottomLeft = null;
            this.width = 0;
            this.height = 0;
            return 0;
        }
        
        protected int getDistanceUntilEdge(final BlockPos lllllllllllllllIlIIIlIlllllIIIll, final EnumFacing lllllllllllllllIlIIIlIlllllIIIlI) {
            int lllllllllllllllIlIIIlIlllllIIIIl;
            for (lllllllllllllllIlIIIlIlllllIIIIl = 0; lllllllllllllllIlIIIlIlllllIIIIl < 22; ++lllllllllllllllIlIIIlIlllllIIIIl) {
                final BlockPos lllllllllllllllIlIIIlIlllllIIIII = lllllllllllllllIlIIIlIlllllIIIll.offset(lllllllllllllllIlIIIlIlllllIIIlI, lllllllllllllllIlIIIlIlllllIIIIl);
                if (!this.isEmptyBlock(this.world.getBlockState(lllllllllllllllIlIIIlIlllllIIIII).getBlock())) {
                    break;
                }
                if (this.world.getBlockState(lllllllllllllllIlIIIlIlllllIIIII.down()).getBlock() != Blocks.OBSIDIAN) {
                    break;
                }
            }
            final Block lllllllllllllllIlIIIlIllllIlllll = this.world.getBlockState(lllllllllllllllIlIIIlIlllllIIIll.offset(lllllllllllllllIlIIIlIlllllIIIlI, lllllllllllllllIlIIIlIlllllIIIIl)).getBlock();
            return (lllllllllllllllIlIIIlIllllIlllll == Blocks.OBSIDIAN) ? lllllllllllllllIlIIIlIlllllIIIIl : 0;
        }
    }
}
