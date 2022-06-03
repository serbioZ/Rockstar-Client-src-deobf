// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.entity.Entity;
import java.util.Random;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import javax.annotation.Nullable;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.AxisAlignedBB;

public abstract class BlockBasePressurePlate extends Block
{
    protected static final /* synthetic */ AxisAlignedBB PRESSED_AABB;
    protected static final /* synthetic */ AxisAlignedBB UNPRESSED_AABB;
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIIlIIlIlIllIlIIIlllII, final BlockPos lllllllllllIIlIIlIlIllIlIIIllIll) {
        return this.canBePlacedOn(lllllllllllIIlIIlIlIllIlIIIlllII, lllllllllllIIlIIlIlIllIlIIIllIll.down());
    }
    
    protected abstract int getRedstoneStrength(final IBlockState p0);
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIlIIlIlIllIlIIlIIlIl) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIlIIlIlIllIIlIIlIlll, final IBlockState lllllllllllIIlIIlIlIllIIlIIlIllI, final BlockPos lllllllllllIIlIIlIlIllIIlIIlIlIl, final EnumFacing lllllllllllIIlIIlIlIllIIlIIlIlII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllIIlIIlIlIllIIlIlIlIII, final IBlockAccess lllllllllllIIlIIlIlIllIIlIlIllII, final BlockPos lllllllllllIIlIIlIlIllIIlIlIlIll, final EnumFacing lllllllllllIIlIIlIlIllIIlIlIlIlI) {
        return this.getRedstoneStrength(lllllllllllIIlIIlIlIllIIlIlIlIII);
    }
    
    protected void updateState(final World lllllllllllIIlIIlIlIllIIllIIllII, final BlockPos lllllllllllIIlIIlIlIllIIllIlIIll, IBlockState lllllllllllIIlIIlIlIllIIllIIlIlI, final int lllllllllllIIlIIlIlIllIIllIlIIIl) {
        final int lllllllllllIIlIIlIlIllIIllIlIIII = this.computeRedstoneStrength(lllllllllllIIlIIlIlIllIIllIIllII, lllllllllllIIlIIlIlIllIIllIlIIll);
        final boolean lllllllllllIIlIIlIlIllIIllIIllll = lllllllllllIIlIIlIlIllIIllIlIIIl > 0;
        final boolean lllllllllllIIlIIlIlIllIIllIIlllI = lllllllllllIIlIIlIlIllIIllIlIIII > 0;
        if (lllllllllllIIlIIlIlIllIIllIlIIIl != lllllllllllIIlIIlIlIllIIllIlIIII) {
            lllllllllllIIlIIlIlIllIIllIIlIlI = (int)this.setRedstoneStrength((IBlockState)lllllllllllIIlIIlIlIllIIllIIlIlI, lllllllllllIIlIIlIlIllIIllIlIIII);
            lllllllllllIIlIIlIlIllIIllIIllII.setBlockState(lllllllllllIIlIIlIlIllIIllIlIIll, (IBlockState)lllllllllllIIlIIlIlIllIIllIIlIlI, 2);
            this.updateNeighbors(lllllllllllIIlIIlIlIllIIllIIllII, lllllllllllIIlIIlIlIllIIllIlIIll);
            lllllllllllIIlIIlIlIllIIllIIllII.markBlockRangeForRenderUpdate(lllllllllllIIlIIlIlIllIIllIlIIll, lllllllllllIIlIIlIlIllIIllIlIIll);
        }
        if (!lllllllllllIIlIIlIlIllIIllIIlllI && lllllllllllIIlIIlIlIllIIllIIllll) {
            this.playClickOffSound(lllllllllllIIlIIlIlIllIIllIIllII, lllllllllllIIlIIlIlIllIIllIlIIll);
        }
        else if (lllllllllllIIlIIlIlIllIIllIIlllI && !lllllllllllIIlIIlIlIllIIllIIllll) {
            this.playClickOnSound(lllllllllllIIlIIlIlIllIIllIIllII, lllllllllllIIlIIlIlIllIIllIlIIll);
        }
        if (lllllllllllIIlIIlIlIllIIllIIlllI) {
            lllllllllllIIlIIlIlIllIIllIIllII.scheduleUpdate(new BlockPos(lllllllllllIIlIIlIlIllIIllIlIIll), this, this.tickRate(lllllllllllIIlIIlIlIllIIllIIllII));
        }
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIIlIIlIlIllIlIIlIlIll, final IBlockAccess lllllllllllIIlIIlIlIllIlIIlIlIlI, final BlockPos lllllllllllIIlIIlIlIllIlIIlIlIIl) {
        return BlockBasePressurePlate.NULL_AABB;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllIIlIIlIlIllIlIIlIIIll, final BlockPos lllllllllllIIlIIlIlIllIlIIlIIIlI) {
        return true;
    }
    
    static {
        PRESSED_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.03125, 0.9375);
        UNPRESSED_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.0625, 0.9375);
        PRESSURE_AABB = new AxisAlignedBB(0.125, 0.0, 0.125, 0.875, 0.25, 0.875);
    }
    
    protected abstract void playClickOnSound(final World p0, final BlockPos p1);
    
    @Override
    public void breakBlock(final World lllllllllllIIlIIlIlIllIIllIIIIII, final BlockPos lllllllllllIIlIIlIlIllIIlIllllll, final IBlockState lllllllllllIIlIIlIlIllIIlIlllIlI) {
        if (this.getRedstoneStrength(lllllllllllIIlIIlIlIllIIlIlllIlI) > 0) {
            this.updateNeighbors(lllllllllllIIlIIlIlIllIIllIIIIII, lllllllllllIIlIIlIlIllIIlIllllll);
        }
        super.breakBlock(lllllllllllIIlIIlIlIllIIllIIIIII, lllllllllllIIlIIlIlIllIIlIllllll, lllllllllllIIlIIlIlIllIIlIlllIlI);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIlIIlIlIllIlIIlIIlll) {
        return false;
    }
    
    protected BlockBasePressurePlate(final Material lllllllllllIIlIIlIlIllIlIIlllIll, final MapColor lllllllllllIIlIIlIlIllIlIIllllIl) {
        super(lllllllllllIIlIIlIlIllIlIIlllIll, lllllllllllIIlIIlIlIllIlIIllllIl);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setTickRandomly(true);
    }
    
    protected void updateNeighbors(final World lllllllllllIIlIIlIlIllIIlIllIIlI, final BlockPos lllllllllllIIlIIlIlIllIIlIllIIIl) {
        lllllllllllIIlIIlIlIllIIlIllIIlI.notifyNeighborsOfStateChange(lllllllllllIIlIIlIlIllIIlIllIIIl, this, false);
        lllllllllllIIlIIlIlIllIIlIllIIlI.notifyNeighborsOfStateChange(lllllllllllIIlIIlIlIllIIlIllIIIl.down(), this, false);
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllIIlIIlIlIllIIlIlIIIll, final IBlockAccess lllllllllllIIlIIlIlIllIIlIlIIIlI, final BlockPos lllllllllllIIlIIlIlIllIIlIlIIIIl, final EnumFacing lllllllllllIIlIIlIlIllIIlIlIIIII) {
        return (lllllllllllIIlIIlIlIllIIlIlIIIII == EnumFacing.UP) ? this.getRedstoneStrength(lllllllllllIIlIIlIlIllIIlIlIIIll) : 0;
    }
    
    protected abstract int computeRedstoneStrength(final World p0, final BlockPos p1);
    
    @Override
    public boolean canSpawnInBlock() {
        return true;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllIIlIIlIlIllIIlIIllIIl) {
        return EnumPushReaction.DESTROY;
    }
    
    private boolean canBePlacedOn(final World lllllllllllIIlIIlIlIllIlIIIIIlII, final BlockPos lllllllllllIIlIIlIlIllIlIIIIIIll) {
        return lllllllllllIIlIIlIlIllIlIIIIIlII.getBlockState(lllllllllllIIlIIlIlIllIlIIIIIIll).isFullyOpaque() || lllllllllllIIlIIlIlIllIlIIIIIlII.getBlockState(lllllllllllIIlIIlIlIllIlIIIIIIll).getBlock() instanceof BlockFence;
    }
    
    protected abstract IBlockState setRedstoneStrength(final IBlockState p0, final int p1);
    
    @Override
    public int tickRate(final World lllllllllllIIlIIlIlIllIlIIlIllIl) {
        return 20;
    }
    
    protected BlockBasePressurePlate(final Material lllllllllllIIlIIlIlIllIlIlIIIIll) {
        this(lllllllllllIIlIIlIlIllIlIlIIIIll, lllllllllllIIlIIlIlIllIlIlIIIIll.getMaterialMapColor());
    }
    
    protected abstract void playClickOffSound(final World p0, final BlockPos p1);
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllIIlIIlIlIllIIlIIllIll) {
        return true;
    }
    
    @Override
    public void randomTick(final World lllllllllllIIlIIlIlIllIlIIIIIIIl, final BlockPos lllllllllllIIlIIlIlIllIlIIIIIIII, final IBlockState lllllllllllIIlIIlIlIllIIllllllll, final Random lllllllllllIIlIIlIlIllIIlllllllI) {
    }
    
    @Override
    public void updateTick(final World lllllllllllIIlIIlIlIllIIllllIlll, final BlockPos lllllllllllIIlIIlIlIllIIllllIIII, final IBlockState lllllllllllIIlIIlIlIllIIllllIlIl, final Random lllllllllllIIlIIlIlIllIIllllIlII) {
        if (!lllllllllllIIlIIlIlIllIIllllIlll.isRemote) {
            final int lllllllllllIIlIIlIlIllIIllllIIll = this.getRedstoneStrength(lllllllllllIIlIIlIlIllIIllllIlIl);
            if (lllllllllllIIlIIlIlIllIIllllIIll > 0) {
                this.updateState(lllllllllllIIlIIlIlIllIIllllIlll, lllllllllllIIlIIlIlIllIIllllIIII, lllllllllllIIlIIlIlIllIIllllIlIl, lllllllllllIIlIIlIlIllIIllllIIll);
            }
        }
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllIIlIIlIlIllIIlllIIIIl, final BlockPos lllllllllllIIlIIlIlIllIIlllIIIII, final IBlockState lllllllllllIIlIIlIlIllIIlllIIlIl, final Entity lllllllllllIIlIIlIlIllIIlllIIlII) {
        if (!lllllllllllIIlIIlIlIllIIlllIIIIl.isRemote) {
            final int lllllllllllIIlIIlIlIllIIlllIIIll = this.getRedstoneStrength(lllllllllllIIlIIlIlIllIIlllIIlIl);
            if (lllllllllllIIlIIlIlIllIIlllIIIll == 0) {
                this.updateState(lllllllllllIIlIIlIlIllIIlllIIIIl, lllllllllllIIlIIlIlIllIIlllIIIII, lllllllllllIIlIIlIlIllIIlllIIlIl, lllllllllllIIlIIlIlIllIIlllIIIll);
            }
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIlIIlIlIllIlIIllIlIl, final IBlockAccess lllllllllllIIlIIlIlIllIlIIllIlII, final BlockPos lllllllllllIIlIIlIlIllIlIIllIIll) {
        final boolean lllllllllllIIlIIlIlIllIlIIllIIlI = this.getRedstoneStrength(lllllllllllIIlIIlIlIllIlIIllIlIl) > 0;
        return lllllllllllIIlIIlIlIllIlIIllIIlI ? BlockBasePressurePlate.PRESSED_AABB : BlockBasePressurePlate.UNPRESSED_AABB;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIlIIlIlIllIlIIIlIIlI, final World lllllllllllIIlIIlIlIllIlIIIIlIll, final BlockPos lllllllllllIIlIIlIlIllIlIIIIlIlI, final Block lllllllllllIIlIIlIlIllIlIIIIllll, final BlockPos lllllllllllIIlIIlIlIllIlIIIIlllI) {
        if (!this.canBePlacedOn(lllllllllllIIlIIlIlIllIlIIIIlIll, lllllllllllIIlIIlIlIllIlIIIIlIlI.down())) {
            this.dropBlockAsItem(lllllllllllIIlIIlIlIllIlIIIIlIll, lllllllllllIIlIIlIlIllIlIIIIlIlI, lllllllllllIIlIIlIlIllIlIIIlIIlI, 0);
            lllllllllllIIlIIlIlIllIlIIIIlIll.setBlockToAir(lllllllllllIIlIIlIlIllIlIIIIlIlI);
        }
    }
}
