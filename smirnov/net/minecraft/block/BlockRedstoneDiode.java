// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.entity.EntityLivingBase;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public abstract class BlockRedstoneDiode extends BlockHorizontal
{
    protected final /* synthetic */ boolean isRepeaterPowered;
    protected static final /* synthetic */ AxisAlignedBB REDSTONE_DIODE_AABB;
    
    protected abstract IBlockState getPoweredState(final IBlockState p0);
    
    protected int getPowerOnSides(final IBlockAccess lllllllllllIllIIIllIIlIIIIllIlIl, final BlockPos lllllllllllIllIIIllIIlIIIIllIlII, final IBlockState lllllllllllIllIIIllIIlIIIIllIIll) {
        final EnumFacing lllllllllllIllIIIllIIlIIIIllIIlI = lllllllllllIllIIIllIIlIIIIllIIll.getValue((IProperty<EnumFacing>)BlockRedstoneDiode.FACING);
        final EnumFacing lllllllllllIllIIIllIIlIIIIllIIIl = lllllllllllIllIIIllIIlIIIIllIIlI.rotateY();
        final EnumFacing lllllllllllIllIIIllIIlIIIIllIIII = lllllllllllIllIIIllIIlIIIIllIIlI.rotateYCCW();
        return Math.max(this.getPowerOnSide(lllllllllllIllIIIllIIlIIIIllIlIl, lllllllllllIllIIIllIIlIIIIllIlII.offset(lllllllllllIllIIIllIIlIIIIllIIIl), lllllllllllIllIIIllIIlIIIIllIIIl), this.getPowerOnSide(lllllllllllIllIIIllIIlIIIIllIlIl, lllllllllllIllIIIllIIlIIIIllIlII.offset(lllllllllllIllIIIllIIlIIIIllIIII), lllllllllllIllIIIllIIlIIIIllIIII));
    }
    
    @Override
    public boolean isAssociatedBlock(final Block lllllllllllIllIIIllIIIlllIIlIlll) {
        return this.isSameDiode(lllllllllllIllIIIllIIIlllIIlIlll.getDefaultState());
    }
    
    protected int getPowerOnSide(final IBlockAccess lllllllllllIllIIIllIIlIIIIlIIIIl, final BlockPos lllllllllllIllIIIllIIlIIIIIllIlI, final EnumFacing lllllllllllIllIIIllIIlIIIIIllIIl) {
        final IBlockState lllllllllllIllIIIllIIlIIIIIllllI = lllllllllllIllIIIllIIlIIIIlIIIIl.getBlockState(lllllllllllIllIIIllIIlIIIIIllIlI);
        final Block lllllllllllIllIIIllIIlIIIIIlllIl = lllllllllllIllIIIllIIlIIIIIllllI.getBlock();
        if (!this.isAlternateInput(lllllllllllIllIIIllIIlIIIIIllllI)) {
            return 0;
        }
        if (lllllllllllIllIIIllIIlIIIIIlllIl == Blocks.REDSTONE_BLOCK) {
            return 15;
        }
        return (lllllllllllIllIIIllIIlIIIIIlllIl == Blocks.REDSTONE_WIRE) ? lllllllllllIllIIIllIIlIIIIIllllI.getValue((IProperty<Integer>)BlockRedstoneWire.POWER) : lllllllllllIllIIIllIIlIIIIlIIIIl.getStrongPower(lllllllllllIllIIIllIIlIIIIIllIlI, lllllllllllIllIIIllIIlIIIIIllIIl);
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllIllIIIllIIlIIIIIlIlIl) {
        return true;
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World lllllllllllIllIIIllIIIllllIlIIlI, final BlockPos lllllllllllIllIIIllIIIllllIlIIIl, final IBlockState lllllllllllIllIIIllIIIllllIlIIII) {
        if (this.isRepeaterPowered) {
            final boolean lllllllllllIllIIIllIIIllllIIIlll;
            final byte lllllllllllIllIIIllIIIllllIIlIII = (byte)((EnumFacing[])(Object)(lllllllllllIllIIIllIIIllllIIIlll = (boolean)(Object)EnumFacing.values())).length;
            for (float lllllllllllIllIIIllIIIllllIIlIIl = 0; lllllllllllIllIIIllIIIllllIIlIIl < lllllllllllIllIIIllIIIllllIIlIII; ++lllllllllllIllIIIllIIIllllIIlIIl) {
                final EnumFacing lllllllllllIllIIIllIIIllllIIllll = lllllllllllIllIIIllIIIllllIIIlll[lllllllllllIllIIIllIIIllllIIlIIl];
                lllllllllllIllIIIllIIIllllIlIIlI.notifyNeighborsOfStateChange(lllllllllllIllIIIllIIIllllIlIIIl.offset(lllllllllllIllIIIllIIIllllIIllll), this, false);
            }
        }
        super.onBlockDestroyedByPlayer(lllllllllllIllIIIllIIIllllIlIIlI, lllllllllllIllIIIllIIIllllIlIIIl, lllllllllllIllIIIllIIIllllIlIIII);
    }
    
    @Override
    public void updateTick(final World lllllllllllIllIIIllIIlIIlIllIlll, final BlockPos lllllllllllIllIIIllIIlIIlIllllII, final IBlockState lllllllllllIllIIIllIIlIIlIllIlIl, final Random lllllllllllIllIIIllIIlIIlIlllIlI) {
        if (!this.isLocked(lllllllllllIllIIIllIIlIIlIllIlll, lllllllllllIllIIIllIIlIIlIllllII, lllllllllllIllIIIllIIlIIlIllIlIl)) {
            final boolean lllllllllllIllIIIllIIlIIlIlllIIl = this.shouldBePowered(lllllllllllIllIIIllIIlIIlIllIlll, lllllllllllIllIIIllIIlIIlIllllII, lllllllllllIllIIIllIIlIIlIllIlIl);
            if (this.isRepeaterPowered && !lllllllllllIllIIIllIIlIIlIlllIIl) {
                lllllllllllIllIIIllIIlIIlIllIlll.setBlockState(lllllllllllIllIIIllIIlIIlIllllII, this.getUnpoweredState(lllllllllllIllIIIllIIlIIlIllIlIl), 2);
            }
            else if (!this.isRepeaterPowered) {
                lllllllllllIllIIIllIIlIIlIllIlll.setBlockState(lllllllllllIllIIIllIIlIIlIllllII, this.getPoweredState(lllllllllllIllIIIllIIlIIlIllIlIl), 2);
                if (!lllllllllllIllIIIllIIlIIlIlllIIl) {
                    lllllllllllIllIIIllIIlIIlIllIlll.updateBlockTick(lllllllllllIllIIIllIIlIIlIllllII, this.getPoweredState(lllllllllllIllIIIllIIlIIlIllIlIl).getBlock(), this.getTickDelay(lllllllllllIllIIIllIIlIIlIllIlIl), -1);
                }
            }
        }
    }
    
    protected abstract int getDelay(final IBlockState p0);
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllIllIIIllIIlIIlIlIIIll, final IBlockAccess lllllllllllIllIIIllIIlIIlIlIIIlI, final BlockPos lllllllllllIllIIIllIIlIIlIIlllIl, final EnumFacing lllllllllllIllIIIllIIlIIlIIlllII) {
        return lllllllllllIllIIIllIIlIIlIlIIIll.getWeakPower(lllllllllllIllIIIllIIlIIlIlIIIlI, lllllllllllIllIIIllIIlIIlIIlllIl, lllllllllllIllIIIllIIlIIlIIlllII);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIllIIIllIIIllllllIIII, final BlockPos lllllllllllIllIIIllIIIlllllIllll, final IBlockState lllllllllllIllIIIllIIIllllllIIlI) {
        this.notifyNeighbors(lllllllllllIllIIIllIIIllllllIIII, lllllllllllIllIIIllIIIlllllIllll, lllllllllllIllIIIllIIIllllllIIlI);
    }
    
    public boolean isFacingTowardsRepeater(final World lllllllllllIllIIIllIIIlllIlIlIlI, final BlockPos lllllllllllIllIIIllIIIlllIlIlIIl, final IBlockState lllllllllllIllIIIllIIIlllIlIlIII) {
        final EnumFacing lllllllllllIllIIIllIIIlllIlIIlll = lllllllllllIllIIIllIIIlllIlIlIII.getValue((IProperty<EnumFacing>)BlockRedstoneDiode.FACING).getOpposite();
        final BlockPos lllllllllllIllIIIllIIIlllIlIIllI = lllllllllllIllIIIllIIIlllIlIlIIl.offset(lllllllllllIllIIIllIIIlllIlIIlll);
        return isDiode(lllllllllllIllIIIllIIIlllIlIlIlI.getBlockState(lllllllllllIllIIIllIIIlllIlIIllI)) && lllllllllllIllIIIllIIIlllIlIlIlI.getBlockState(lllllllllllIllIIIllIIIlllIlIIllI).getValue((IProperty<Comparable>)BlockRedstoneDiode.FACING) != lllllllllllIllIIIllIIIlllIlIIlll;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIllIIIllIIlIIIlllllII, final World lllllllllllIllIIIllIIlIIIllllIll, final BlockPos lllllllllllIllIIIllIIlIIlIIIIIIl, final Block lllllllllllIllIIIllIIlIIlIIIIIII, final BlockPos lllllllllllIllIIIllIIlIIIlllllll) {
        if (this.canBlockStay(lllllllllllIllIIIllIIlIIIllllIll, lllllllllllIllIIIllIIlIIlIIIIIIl)) {
            this.updateState(lllllllllllIllIIIllIIlIIIllllIll, lllllllllllIllIIIllIIlIIlIIIIIIl, lllllllllllIllIIIllIIlIIIlllllII);
        }
        else {
            this.dropBlockAsItem(lllllllllllIllIIIllIIlIIIllllIll, lllllllllllIllIIIllIIlIIlIIIIIIl, lllllllllllIllIIIllIIlIIIlllllII, 0);
            lllllllllllIllIIIllIIlIIIllllIll.setBlockToAir(lllllllllllIllIIIllIIlIIlIIIIIIl);
            final long lllllllllllIllIIIllIIlIIIlllIllI;
            final Exception lllllllllllIllIIIllIIlIIIlllIlll = (Exception)((EnumFacing[])(Object)(lllllllllllIllIIIllIIlIIIlllIllI = (long)(Object)EnumFacing.values())).length;
            for (String lllllllllllIllIIIllIIlIIIllllIII = (String)0; lllllllllllIllIIIllIIlIIIllllIII < lllllllllllIllIIIllIIlIIIlllIlll; ++lllllllllllIllIIIllIIlIIIllllIII) {
                final EnumFacing lllllllllllIllIIIllIIlIIIllllllI = lllllllllllIllIIIllIIlIIIlllIllI[lllllllllllIllIIIllIIlIIIllllIII];
                lllllllllllIllIIIllIIlIIIllllIll.notifyNeighborsOfStateChange(lllllllllllIllIIIllIIlIIlIIIIIIl.offset(lllllllllllIllIIIllIIlIIIllllllI), this, false);
            }
        }
    }
    
    protected boolean isPowered(final IBlockState lllllllllllIllIIIllIIlIIlIlIlIlI) {
        return this.isRepeaterPowered;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIllIIIllIIlIIlIllIIIl, final IBlockAccess lllllllllllIllIIIllIIlIIlIllIIII, final BlockPos lllllllllllIllIIIllIIlIIlIlIllll, final EnumFacing lllllllllllIllIIIllIIlIIlIlIllIl) {
        return lllllllllllIllIIIllIIlIIlIlIllIl.getAxis() != EnumFacing.Axis.Y;
    }
    
    protected boolean shouldBePowered(final World lllllllllllIllIIIllIIlIIIlIlIllI, final BlockPos lllllllllllIllIIIllIIlIIIlIlIlIl, final IBlockState lllllllllllIllIIIllIIlIIIlIllIII) {
        return this.calculateInputStrength(lllllllllllIllIIIllIIlIIIlIlIllI, lllllllllllIllIIIllIIlIIIlIlIlIl, lllllllllllIllIIIllIIlIIIlIllIII) > 0;
    }
    
    static {
        REDSTONE_DIODE_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
    }
    
    public static boolean isDiode(final IBlockState lllllllllllIllIIIllIIIlllIlllIlI) {
        return Blocks.UNPOWERED_REPEATER.isSameDiode(lllllllllllIllIIIllIIIlllIlllIlI) || Blocks.UNPOWERED_COMPARATOR.isSameDiode(lllllllllllIllIIIllIIIlllIlllIlI);
    }
    
    protected int getActiveSignal(final IBlockAccess lllllllllllIllIIIllIIIlllIllllll, final BlockPos lllllllllllIllIIIllIIIlllIlllllI, final IBlockState lllllllllllIllIIIllIIIlllIllllIl) {
        return 15;
    }
    
    @Override
    public void randomTick(final World lllllllllllIllIIIllIIlIIllIIIlll, final BlockPos lllllllllllIllIIIllIIlIIllIIIllI, final IBlockState lllllllllllIllIIIllIIlIIllIIIlIl, final Random lllllllllllIllIIIllIIlIIllIIIlII) {
    }
    
    protected void notifyNeighbors(final World lllllllllllIllIIIllIIIlllllIIllI, final BlockPos lllllllllllIllIIIllIIIllllIlllll, final IBlockState lllllllllllIllIIIllIIIllllIllllI) {
        final EnumFacing lllllllllllIllIIIllIIIlllllIIIll = lllllllllllIllIIIllIIIllllIllllI.getValue((IProperty<EnumFacing>)BlockRedstoneDiode.FACING);
        final BlockPos lllllllllllIllIIIllIIIlllllIIIlI = lllllllllllIllIIIllIIIllllIlllll.offset(lllllllllllIllIIIllIIIlllllIIIll.getOpposite());
        lllllllllllIllIIIllIIIlllllIIllI.func_190524_a(lllllllllllIllIIIllIIIlllllIIIlI, this, lllllllllllIllIIIllIIIllllIlllll);
        lllllllllllIllIIIllIIIlllllIIllI.notifyNeighborsOfStateExcept(lllllllllllIllIIIllIIIlllllIIIlI, this, lllllllllllIllIIIllIIIlllllIIIll);
    }
    
    protected int getTickDelay(final IBlockState lllllllllllIllIIIllIIIlllIIllIll) {
        return this.getDelay(lllllllllllIllIIIllIIIlllIIllIll);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIllIIIllIIIllllIIIlIl) {
        return false;
    }
    
    protected abstract IBlockState getUnpoweredState(final IBlockState p0);
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIllIIIllIIlIIllIlIlII, final BlockPos lllllllllllIllIIIllIIlIIllIlIIll) {
        return lllllllllllIllIIIllIIlIIllIlIlII.getBlockState(lllllllllllIllIIIllIIlIIllIlIIll.down()).isFullyOpaque() && super.canPlaceBlockAt(lllllllllllIllIIIllIIlIIllIlIlII, lllllllllllIllIIIllIIlIIllIlIIll);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIllIIIllIIlIIIIIlIIIl, final BlockPos lllllllllllIllIIIllIIlIIIIIlIIII, final EnumFacing lllllllllllIllIIIllIIlIIIIIIllll, final float lllllllllllIllIIIllIIlIIIIIIlllI, final float lllllllllllIllIIIllIIlIIIIIIllIl, final float lllllllllllIllIIIllIIlIIIIIIllII, final int lllllllllllIllIIIllIIlIIIIIIlIll, final EntityLivingBase lllllllllllIllIIIllIIlIIIIIIlIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneDiode.FACING, lllllllllllIllIIIllIIlIIIIIIlIlI.getHorizontalFacing().getOpposite());
    }
    
    public boolean canBlockStay(final World lllllllllllIllIIIllIIlIIllIIllII, final BlockPos lllllllllllIllIIIllIIlIIllIIlIll) {
        return lllllllllllIllIIIllIIlIIllIIllII.getBlockState(lllllllllllIllIIIllIIlIIllIIlIll.down()).isFullyOpaque();
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllIllIIIllIIlIIlIIlIIII, final IBlockAccess lllllllllllIllIIIllIIlIIlIIlIlII, final BlockPos lllllllllllIllIIIllIIlIIlIIlIIll, final EnumFacing lllllllllllIllIIIllIIlIIlIIIllIl) {
        if (!this.isPowered(lllllllllllIllIIIllIIlIIlIIlIIII)) {
            return 0;
        }
        return (lllllllllllIllIIIllIIlIIlIIlIIII.getValue((IProperty<Comparable>)BlockRedstoneDiode.FACING) == lllllllllllIllIIIllIIlIIlIIIllIl) ? this.getActiveSignal(lllllllllllIllIIIllIIlIIlIIlIlII, lllllllllllIllIIIllIIlIIlIIlIIll, lllllllllllIllIIIllIIlIIlIIlIIII) : 0;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIllIIIllIIIlllIIlIIIl, final IBlockState lllllllllllIllIIIllIIIlllIIlIIII, final BlockPos lllllllllllIllIIIllIIIlllIIIllll, final EnumFacing lllllllllllIllIIIllIIIlllIIIlllI) {
        return (lllllllllllIllIIIllIIIlllIIIlllI == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    public boolean isSameDiode(final IBlockState lllllllllllIllIIIllIIIlllIllIlIl) {
        final Block lllllllllllIllIIIllIIIlllIllIlII = lllllllllllIllIIIllIIIlllIllIlIl.getBlock();
        return lllllllllllIllIIIllIIIlllIllIlII == this.getPoweredState(this.getDefaultState()).getBlock() || lllllllllllIllIIIllIIIlllIllIlII == this.getUnpoweredState(this.getDefaultState()).getBlock();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIllIIIllIIlIIllIlllIl, final IBlockAccess lllllllllllIllIIIllIIlIIllIlllII, final BlockPos lllllllllllIllIIIllIIlIIllIllIll) {
        return BlockRedstoneDiode.REDSTONE_DIODE_AABB;
    }
    
    public boolean isLocked(final IBlockAccess lllllllllllIllIIIllIIlIIIllIIIlI, final BlockPos lllllllllllIllIIIllIIlIIIllIIIIl, final IBlockState lllllllllllIllIIIllIIlIIIllIIIII) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    protected void updateState(final World lllllllllllIllIIIllIIlIIIllIlllI, final BlockPos lllllllllllIllIIIllIIlIIIllIIlll, final IBlockState lllllllllllIllIIIllIIlIIIllIIllI) {
        if (!this.isLocked(lllllllllllIllIIIllIIlIIIllIlllI, lllllllllllIllIIIllIIlIIIllIIlll, lllllllllllIllIIIllIIlIIIllIIllI)) {
            final boolean lllllllllllIllIIIllIIlIIIllIlIll = this.shouldBePowered(lllllllllllIllIIIllIIlIIIllIlllI, lllllllllllIllIIIllIIlIIIllIIlll, lllllllllllIllIIIllIIlIIIllIIllI);
            if (this.isRepeaterPowered != lllllllllllIllIIIllIIlIIIllIlIll && !lllllllllllIllIIIllIIlIIIllIlllI.isBlockTickPending(lllllllllllIllIIIllIIlIIIllIIlll, this)) {
                int lllllllllllIllIIIllIIlIIIllIlIlI = -1;
                if (this.isFacingTowardsRepeater(lllllllllllIllIIIllIIlIIIllIlllI, lllllllllllIllIIIllIIlIIIllIIlll, lllllllllllIllIIIllIIlIIIllIIllI)) {
                    lllllllllllIllIIIllIIlIIIllIlIlI = -3;
                }
                else if (this.isRepeaterPowered) {
                    lllllllllllIllIIIllIIlIIIllIlIlI = -2;
                }
                lllllllllllIllIIIllIIlIIIllIlllI.updateBlockTick(lllllllllllIllIIIllIIlIIIllIIlll, this, this.getDelay(lllllllllllIllIIIllIIlIIIllIIllI), lllllllllllIllIIIllIIlIIIllIlIlI);
            }
        }
    }
    
    protected BlockRedstoneDiode(final boolean lllllllllllIllIIIllIIlIIlllIIIIl) {
        super(Material.CIRCUITS);
        this.isRepeaterPowered = lllllllllllIllIIIllIIlIIlllIIIIl;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIllIIIllIIlIIllIllIIl) {
        return false;
    }
    
    protected boolean isAlternateInput(final IBlockState lllllllllllIllIIIllIIIllllIIIIIl) {
        return lllllllllllIllIIIllIIIllllIIIIIl.canProvidePower();
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllIllIIIllIIlIIIIIIIIlI, final BlockPos lllllllllllIllIIIllIIIlllllllIll, final IBlockState lllllllllllIllIIIllIIIlllllllIlI, final EntityLivingBase lllllllllllIllIIIllIIIllllllllll, final ItemStack lllllllllllIllIIIllIIIlllllllllI) {
        if (this.shouldBePowered(lllllllllllIllIIIllIIlIIIIIIIIlI, lllllllllllIllIIIllIIIlllllllIll, lllllllllllIllIIIllIIIlllllllIlI)) {
            lllllllllllIllIIIllIIlIIIIIIIIlI.scheduleUpdate(lllllllllllIllIIIllIIIlllllllIll, this, 1);
        }
    }
    
    protected int calculateInputStrength(final World lllllllllllIllIIIllIIlIIIlIIlIll, final BlockPos lllllllllllIllIIIllIIlIIIlIIlIlI, final IBlockState lllllllllllIllIIIllIIlIIIlIIlIIl) {
        final EnumFacing lllllllllllIllIIIllIIlIIIlIIlIII = lllllllllllIllIIIllIIlIIIlIIlIIl.getValue((IProperty<EnumFacing>)BlockRedstoneDiode.FACING);
        final BlockPos lllllllllllIllIIIllIIlIIIlIIIlll = lllllllllllIllIIIllIIlIIIlIIlIlI.offset(lllllllllllIllIIIllIIlIIIlIIlIII);
        final int lllllllllllIllIIIllIIlIIIlIIIllI = lllllllllllIllIIIllIIlIIIlIIlIll.getRedstonePower(lllllllllllIllIIIllIIlIIIlIIIlll, lllllllllllIllIIIllIIlIIIlIIlIII);
        if (lllllllllllIllIIIllIIlIIIlIIIllI >= 15) {
            return lllllllllllIllIIIllIIlIIIlIIIllI;
        }
        final IBlockState lllllllllllIllIIIllIIlIIIlIIIlIl = lllllllllllIllIIIllIIlIIIlIIlIll.getBlockState(lllllllllllIllIIIllIIlIIIlIIIlll);
        return Math.max(lllllllllllIllIIIllIIlIIIlIIIllI, (lllllllllllIllIIIllIIlIIIlIIIlIl.getBlock() == Blocks.REDSTONE_WIRE) ? ((int)lllllllllllIllIIIllIIlIIIlIIIlIl.getValue((IProperty<Integer>)BlockRedstoneWire.POWER)) : 0);
    }
}
