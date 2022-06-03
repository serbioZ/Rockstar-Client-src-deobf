// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.Material;
import com.google.common.base.MoreObjects;
import net.minecraft.init.Blocks;
import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.Mirror;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Rotation;
import net.minecraft.world.IBlockAccess;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockTripWireHook extends Block
{
    protected static final /* synthetic */ AxisAlignedBB HOOK_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB HOOK_WEST_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    public static final /* synthetic */ PropertyBool ATTACHED;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB HOOK_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB HOOK_SOUTH_AABB;
    public static final /* synthetic */ PropertyBool POWERED;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIllIllIllIIIIIlllIIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.getHorizontal(lllllllllllIllIllIllIIIIIlllIIIl & 0x3)).withProperty((IProperty<Comparable>)BlockTripWireHook.POWERED, (lllllllllllIllIllIllIIIIIlllIIIl & 0x8) > 0).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, (lllllllllllIllIllIllIIIIIlllIIIl & 0x4) > 0);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIllIllIllIIIlIlIlIIIl, final BlockPos lllllllllllIllIllIllIIIlIlIlIIII) {
        for (final EnumFacing lllllllllllIllIllIllIIIlIlIIllll : EnumFacing.Plane.HORIZONTAL) {
            if (this.canPlaceBlockOnSide(lllllllllllIllIllIllIIIlIlIlIIIl, lllllllllllIllIllIllIIIlIlIlIIII, lllllllllllIllIllIllIIIlIlIIllll)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIllIllIllIIIlIIlIIlII, final World lllllllllllIllIllIllIIIlIIIlllII, final BlockPos lllllllllllIllIllIllIIIlIIlIIIlI, final Block lllllllllllIllIllIllIIIlIIlIIIIl, final BlockPos lllllllllllIllIllIllIIIlIIlIIIII) {
        if (lllllllllllIllIllIllIIIlIIlIIIIl != this && this.checkForDrop(lllllllllllIllIllIllIIIlIIIlllII, lllllllllllIllIllIllIIIlIIlIIIlI, lllllllllllIllIllIllIIIlIIlIIlII)) {
            final EnumFacing lllllllllllIllIllIllIIIlIIIlllll = lllllllllllIllIllIllIIIlIIlIIlII.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING);
            if (!this.canPlaceBlockOnSide(lllllllllllIllIllIllIIIlIIIlllII, lllllllllllIllIllIllIIIlIIlIIIlI, lllllllllllIllIllIllIIIlIIIlllll)) {
                this.dropBlockAsItem(lllllllllllIllIllIllIIIlIIIlllII, lllllllllllIllIllIllIIIlIIlIIIlI, lllllllllllIllIllIllIIIlIIlIIlII, 0);
                lllllllllllIllIllIllIIIlIIIlllII.setBlockToAir(lllllllllllIllIllIllIIIlIIlIIIlI);
            }
        }
    }
    
    @Override
    public void randomTick(final World lllllllllllIllIllIllIIIIllIlIlIl, final BlockPos lllllllllllIllIllIllIIIIllIlIlII, final IBlockState lllllllllllIllIllIllIIIIllIlIIll, final Random lllllllllllIllIllIllIIIIllIlIIlI) {
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllIllIllIllIIIIIllllIIl, final IBlockAccess lllllllllllIllIllIllIIIIIlllllII, final BlockPos lllllllllllIllIllIllIIIIIllllIll, final EnumFacing lllllllllllIllIllIllIIIIIllllIlI) {
        if (!lllllllllllIllIllIllIIIIIllllIIl.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED)) {
            return 0;
        }
        return (lllllllllllIllIllIllIIIIIllllIIl.getValue((IProperty<Comparable>)BlockTripWireHook.FACING) == lllllllllllIllIllIllIIIIIllllIlI) ? 15 : 0;
    }
    
    private void notifyNeighbors(final World lllllllllllIllIllIllIIIIlIlIllII, final BlockPos lllllllllllIllIllIllIIIIlIlIlIll, final EnumFacing lllllllllllIllIllIllIIIIlIlIIllI) {
        lllllllllllIllIllIllIIIIlIlIllII.notifyNeighborsOfStateChange(lllllllllllIllIllIllIIIIlIlIlIll, this, false);
        lllllllllllIllIllIllIIIIlIlIllII.notifyNeighborsOfStateChange(lllllllllllIllIllIllIIIIlIlIlIll.offset(lllllllllllIllIllIllIIIIlIlIIllI.getOpposite()), this, false);
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        POWERED = PropertyBool.create("powered");
        ATTACHED = PropertyBool.create("attached");
        HOOK_NORTH_AABB = new AxisAlignedBB(0.3125, 0.0, 0.625, 0.6875, 0.625, 1.0);
        HOOK_SOUTH_AABB = new AxisAlignedBB(0.3125, 0.0, 0.0, 0.6875, 0.625, 0.375);
        HOOK_WEST_AABB = new AxisAlignedBB(0.625, 0.0, 0.3125, 1.0, 0.625, 0.6875);
        HOOK_EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.3125, 0.375, 0.625, 0.6875);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIllIllIllIIIIIllIIlII, final Rotation lllllllllllIllIllIllIIIIIllIIIIl) {
        return lllllllllllIllIllIllIIIIIllIIlII.withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, lllllllllllIllIllIllIIIIIllIIIIl.rotate(lllllllllllIllIllIllIIIIIllIIlII.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING)));
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIllIllIllIIIlIlIIIlIl, final BlockPos lllllllllllIllIllIllIIIlIlIIIlII, final EnumFacing lllllllllllIllIllIllIIIlIlIIIIll, final float lllllllllllIllIllIllIIIlIlIIIIlI, final float lllllllllllIllIllIllIIIlIlIIIIIl, final float lllllllllllIllIllIllIIIlIlIIIIII, final int lllllllllllIllIllIllIIIlIIllllll, final EntityLivingBase lllllllllllIllIllIllIIIlIIlllllI) {
        IBlockState lllllllllllIllIllIllIIIlIIllllIl = this.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.POWERED, false).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, false);
        if (lllllllllllIllIllIllIIIlIlIIIIll.getAxis().isHorizontal()) {
            lllllllllllIllIllIllIIIlIIllllIl = lllllllllllIllIllIllIIIlIIllllIl.withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, lllllllllllIllIllIllIIIlIlIIIIll);
        }
        return lllllllllllIllIllIllIIIlIIllllIl;
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllIllIllIllIIIIIlllIllI) {
        return true;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIllIllIllIIIlIlllIIII) {
        return false;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIllIllIllIIIIIlIlllIl, final Mirror lllllllllllIllIllIllIIIIIlIllIlI) {
        return lllllllllllIllIllIllIIIIIlIlllIl.withRotation(lllllllllllIllIllIllIIIIIlIllIlI.toRotation(lllllllllllIllIllIllIIIIIlIlllIl.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING)));
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllIllIllIllIIIlIllIIlIl, final BlockPos lllllllllllIllIllIllIIIlIllIIlII, final EnumFacing lllllllllllIllIllIllIIIlIlIlllII) {
        final EnumFacing lllllllllllIllIllIllIIIlIllIIIlI = lllllllllllIllIllIllIIIlIlIlllII.getOpposite();
        final BlockPos lllllllllllIllIllIllIIIlIllIIIIl = lllllllllllIllIllIllIIIlIllIIlII.offset(lllllllllllIllIllIllIIIlIllIIIlI);
        final IBlockState lllllllllllIllIllIllIIIlIllIIIII = lllllllllllIllIllIllIIIlIllIIlIl.getBlockState(lllllllllllIllIllIllIIIlIllIIIIl);
        final boolean lllllllllllIllIllIllIIIlIlIlllll = Block.func_193382_c(lllllllllllIllIllIllIIIlIllIIIII.getBlock());
        return !lllllllllllIllIllIllIIIlIlIlllll && lllllllllllIllIllIllIIIlIlIlllII.getAxis().isHorizontal() && lllllllllllIllIllIllIIIlIllIIIII.func_193401_d(lllllllllllIllIllIllIIIlIllIIlIl, lllllllllllIllIllIllIIIlIllIIIIl, lllllllllllIllIllIllIIIlIlIlllII) == BlockFaceShape.SOLID && !lllllllllllIllIllIllIIIlIllIIIII.canProvidePower();
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    
    @Override
    public void updateTick(final World lllllllllllIllIllIllIIIIllIIIlll, final BlockPos lllllllllllIllIllIllIIIIllIIlIll, final IBlockState lllllllllllIllIllIllIIIIllIIlIlI, final Random lllllllllllIllIllIllIIIIllIIlIIl) {
        this.calculateState(lllllllllllIllIllIllIIIIllIIIlll, lllllllllllIllIllIllIIIIllIIlIll, lllllllllllIllIllIllIIIIllIIlIlI, false, true, -1, null);
    }
    
    private void playSound(final World lllllllllllIllIllIllIIIIlIllllIl, final BlockPos lllllllllllIllIllIllIIIIlIllIllI, final boolean lllllllllllIllIllIllIIIIlIlllIll, final boolean lllllllllllIllIllIllIIIIlIlllIlI, final boolean lllllllllllIllIllIllIIIIlIllIIll, final boolean lllllllllllIllIllIllIIIIlIlllIII) {
        if (lllllllllllIllIllIllIIIIlIlllIlI && !lllllllllllIllIllIllIIIIlIlllIII) {
            lllllllllllIllIllIllIIIIlIllllIl.playSound(null, lllllllllllIllIllIllIIIIlIllIllI, SoundEvents.BLOCK_TRIPWIRE_CLICK_ON, SoundCategory.BLOCKS, 0.4f, 0.6f);
        }
        else if (!lllllllllllIllIllIllIIIIlIlllIlI && lllllllllllIllIllIllIIIIlIlllIII) {
            lllllllllllIllIllIllIIIIlIllllIl.playSound(null, lllllllllllIllIllIllIIIIlIllIllI, SoundEvents.BLOCK_TRIPWIRE_CLICK_OFF, SoundCategory.BLOCKS, 0.4f, 0.5f);
        }
        else if (lllllllllllIllIllIllIIIIlIlllIll && !lllllllllllIllIllIllIIIIlIllIIll) {
            lllllllllllIllIllIllIIIIlIllllIl.playSound(null, lllllllllllIllIllIllIIIIlIllIllI, SoundEvents.BLOCK_TRIPWIRE_ATTACH, SoundCategory.BLOCKS, 0.4f, 0.7f);
        }
        else if (!lllllllllllIllIllIllIIIIlIlllIll && lllllllllllIllIllIllIIIIlIllIIll) {
            lllllllllllIllIllIllIIIIlIllllIl.playSound(null, lllllllllllIllIllIllIIIIlIllIllI, SoundEvents.BLOCK_TRIPWIRE_DETACH, SoundCategory.BLOCKS, 0.4f, 1.2f / (lllllllllllIllIllIllIIIIlIllllIl.rand.nextFloat() * 0.2f + 0.9f));
        }
    }
    
    private boolean checkForDrop(final World lllllllllllIllIllIllIIIIlIlIIIII, final BlockPos lllllllllllIllIllIllIIIIlIIllIll, final IBlockState lllllllllllIllIllIllIIIIlIIllllI) {
        if (!this.canPlaceBlockAt(lllllllllllIllIllIllIIIIlIlIIIII, lllllllllllIllIllIllIIIIlIIllIll)) {
            this.dropBlockAsItem(lllllllllllIllIllIllIIIIlIlIIIII, lllllllllllIllIllIllIIIIlIIllIll, lllllllllllIllIllIllIIIIlIIllllI, 0);
            lllllllllllIllIllIllIIIIlIlIIIII.setBlockToAir(lllllllllllIllIllIllIIIIlIIllIll);
            return false;
        }
        return true;
    }
    
    @Override
    public void breakBlock(final World lllllllllllIllIllIllIIIIlIIlIIlI, final BlockPos lllllllllllIllIllIllIIIIlIIIlIll, final IBlockState lllllllllllIllIllIllIIIIlIIIlIlI) {
        final boolean lllllllllllIllIllIllIIIIlIIIllll = lllllllllllIllIllIllIIIIlIIIlIlI.getValue((IProperty<Boolean>)BlockTripWireHook.ATTACHED);
        final boolean lllllllllllIllIllIllIIIIlIIIlllI = lllllllllllIllIllIllIIIIlIIIlIlI.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED);
        if (lllllllllllIllIllIllIIIIlIIIllll || lllllllllllIllIllIllIIIIlIIIlllI) {
            this.calculateState(lllllllllllIllIllIllIIIIlIIlIIlI, lllllllllllIllIllIllIIIIlIIIlIll, lllllllllllIllIllIllIIIIlIIIlIlI, true, false, -1, null);
        }
        if (lllllllllllIllIllIllIIIIlIIIlllI) {
            lllllllllllIllIllIllIIIIlIIlIIlI.notifyNeighborsOfStateChange(lllllllllllIllIllIllIIIIlIIIlIll, this, false);
            lllllllllllIllIllIllIIIIlIIlIIlI.notifyNeighborsOfStateChange(lllllllllllIllIllIllIIIIlIIIlIll.offset(lllllllllllIllIllIllIIIIlIIIlIlI.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING).getOpposite()), this, false);
        }
        super.breakBlock(lllllllllllIllIllIllIIIIlIIlIIlI, lllllllllllIllIllIllIIIIlIIIlIll, lllllllllllIllIllIllIIIIlIIIlIlI);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIllIllIllIIIlIllIlllI) {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIllIllIllIIIlIlllIlII, final IBlockAccess lllllllllllIllIllIllIIIlIlllIIll, final BlockPos lllllllllllIllIllIllIIIlIlllIIlI) {
        return BlockTripWireHook.NULL_AABB;
    }
    
    public void calculateState(final World lllllllllllIllIllIllIIIIlllIlIIl, final BlockPos lllllllllllIllIllIllIIIIlllIlIII, final IBlockState lllllllllllIllIllIllIIIlIIIIIIIl, final boolean lllllllllllIllIllIllIIIlIIIIIIII, final boolean lllllllllllIllIllIllIIIIlllIIlIl, final int lllllllllllIllIllIllIIIIlllIIlII, @Nullable final IBlockState lllllllllllIllIllIllIIIIlllIIIll) {
        final EnumFacing lllllllllllIllIllIllIIIIllllllII = lllllllllllIllIllIllIIIlIIIIIIIl.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING);
        final boolean lllllllllllIllIllIllIIIIlllllIll = lllllllllllIllIllIllIIIlIIIIIIIl.getValue((IProperty<Boolean>)BlockTripWireHook.ATTACHED);
        final boolean lllllllllllIllIllIllIIIIlllllIlI = lllllllllllIllIllIllIIIlIIIIIIIl.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED);
        boolean lllllllllllIllIllIllIIIIlllllIIl = !lllllllllllIllIllIllIIIlIIIIIIII;
        boolean lllllllllllIllIllIllIIIIlllllIII = false;
        int lllllllllllIllIllIllIIIIllllIlll = 0;
        final IBlockState[] lllllllllllIllIllIllIIIIllllIllI = new IBlockState[42];
        int lllllllllllIllIllIllIIIIllllIlIl = 1;
        while (lllllllllllIllIllIllIIIIllllIlIl < 42) {
            final BlockPos lllllllllllIllIllIllIIIIllllIlII = lllllllllllIllIllIllIIIIlllIlIII.offset(lllllllllllIllIllIllIIIIllllllII, lllllllllllIllIllIllIIIIllllIlIl);
            IBlockState lllllllllllIllIllIllIIIIllllIIll = lllllllllllIllIllIllIIIIlllIlIIl.getBlockState(lllllllllllIllIllIllIIIIllllIlII);
            if (lllllllllllIllIllIllIIIIllllIIll.getBlock() == Blocks.TRIPWIRE_HOOK) {
                if (lllllllllllIllIllIllIIIIllllIIll.getValue((IProperty<Comparable>)BlockTripWireHook.FACING) == lllllllllllIllIllIllIIIIllllllII.getOpposite()) {
                    lllllllllllIllIllIllIIIIllllIlll = lllllllllllIllIllIllIIIIllllIlIl;
                    break;
                }
                break;
            }
            else {
                if (lllllllllllIllIllIllIIIIllllIIll.getBlock() != Blocks.TRIPWIRE && lllllllllllIllIllIllIIIIllllIlIl != lllllllllllIllIllIllIIIIlllIIlII) {
                    lllllllllllIllIllIllIIIIllllIllI[lllllllllllIllIllIllIIIIllllIlIl] = null;
                    lllllllllllIllIllIllIIIIlllllIIl = false;
                }
                else {
                    if (lllllllllllIllIllIllIIIIllllIlIl == lllllllllllIllIllIllIIIIlllIIlII) {
                        lllllllllllIllIllIllIIIIllllIIll = (IBlockState)MoreObjects.firstNonNull((Object)lllllllllllIllIllIllIIIIlllIIIll, (Object)lllllllllllIllIllIllIIIIllllIIll);
                    }
                    final boolean lllllllllllIllIllIllIIIIllllIIlI = !lllllllllllIllIllIllIIIIllllIIll.getValue((IProperty<Boolean>)BlockTripWire.DISARMED);
                    final boolean lllllllllllIllIllIllIIIIllllIIIl = lllllllllllIllIllIllIIIIllllIIll.getValue((IProperty<Boolean>)BlockTripWire.POWERED);
                    lllllllllllIllIllIllIIIIlllllIII |= (lllllllllllIllIllIllIIIIllllIIlI && lllllllllllIllIllIllIIIIllllIIIl);
                    lllllllllllIllIllIllIIIIllllIllI[lllllllllllIllIllIllIIIIllllIlIl] = lllllllllllIllIllIllIIIIllllIIll;
                    if (lllllllllllIllIllIllIIIIllllIlIl == lllllllllllIllIllIllIIIIlllIIlII) {
                        lllllllllllIllIllIllIIIIlllIlIIl.scheduleUpdate(lllllllllllIllIllIllIIIIlllIlIII, this, this.tickRate(lllllllllllIllIllIllIIIIlllIlIIl));
                        lllllllllllIllIllIllIIIIlllllIIl &= lllllllllllIllIllIllIIIIllllIIlI;
                    }
                }
                ++lllllllllllIllIllIllIIIIllllIlIl;
            }
        }
        lllllllllllIllIllIllIIIIlllllIIl &= (lllllllllllIllIllIllIIIIllllIlll > 1);
        lllllllllllIllIllIllIIIIlllllIII &= lllllllllllIllIllIllIIIIlllllIIl;
        final IBlockState lllllllllllIllIllIllIIIIllllIIII = this.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, lllllllllllIllIllIllIIIIlllllIIl).withProperty((IProperty<Comparable>)BlockTripWireHook.POWERED, lllllllllllIllIllIllIIIIlllllIII);
        if (lllllllllllIllIllIllIIIIllllIlll > 0) {
            final BlockPos lllllllllllIllIllIllIIIIlllIllll = lllllllllllIllIllIllIIIIlllIlIII.offset(lllllllllllIllIllIllIIIIllllllII, lllllllllllIllIllIllIIIIllllIlll);
            final EnumFacing lllllllllllIllIllIllIIIIlllIlllI = lllllllllllIllIllIllIIIIllllllII.getOpposite();
            lllllllllllIllIllIllIIIIlllIlIIl.setBlockState(lllllllllllIllIllIllIIIIlllIllll, lllllllllllIllIllIllIIIIllllIIII.withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, lllllllllllIllIllIllIIIIlllIlllI), 3);
            this.notifyNeighbors(lllllllllllIllIllIllIIIIlllIlIIl, lllllllllllIllIllIllIIIIlllIllll, lllllllllllIllIllIllIIIIlllIlllI);
            this.playSound(lllllllllllIllIllIllIIIIlllIlIIl, lllllllllllIllIllIllIIIIlllIllll, lllllllllllIllIllIllIIIIlllllIIl, lllllllllllIllIllIllIIIIlllllIII, lllllllllllIllIllIllIIIIlllllIll, lllllllllllIllIllIllIIIIlllllIlI);
        }
        this.playSound(lllllllllllIllIllIllIIIIlllIlIIl, lllllllllllIllIllIllIIIIlllIlIII, lllllllllllIllIllIllIIIIlllllIIl, lllllllllllIllIllIllIIIIlllllIII, lllllllllllIllIllIllIIIIlllllIll, lllllllllllIllIllIllIIIIlllllIlI);
        if (!lllllllllllIllIllIllIIIlIIIIIIII) {
            lllllllllllIllIllIllIIIIlllIlIIl.setBlockState(lllllllllllIllIllIllIIIIlllIlIII, lllllllllllIllIllIllIIIIllllIIII.withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, lllllllllllIllIllIllIIIIllllllII), 3);
            if (lllllllllllIllIllIllIIIIlllIIlIl) {
                this.notifyNeighbors(lllllllllllIllIllIllIIIIlllIlIIl, lllllllllllIllIllIllIIIIlllIlIII, lllllllllllIllIllIllIIIIllllllII);
            }
        }
        if (lllllllllllIllIllIllIIIIlllllIll != lllllllllllIllIllIllIIIIlllllIIl) {
            for (int lllllllllllIllIllIllIIIIlllIllIl = 1; lllllllllllIllIllIllIIIIlllIllIl < lllllllllllIllIllIllIIIIllllIlll; ++lllllllllllIllIllIllIIIIlllIllIl) {
                final BlockPos lllllllllllIllIllIllIIIIlllIllII = lllllllllllIllIllIllIIIIlllIlIII.offset(lllllllllllIllIllIllIIIIllllllII, lllllllllllIllIllIllIIIIlllIllIl);
                final IBlockState lllllllllllIllIllIllIIIIlllIlIll = lllllllllllIllIllIllIIIIllllIllI[lllllllllllIllIllIllIIIIlllIllIl];
                if (lllllllllllIllIllIllIIIIlllIlIll != null && lllllllllllIllIllIllIIIIlllIlIIl.getBlockState(lllllllllllIllIllIllIIIIlllIllII).getMaterial() != Material.AIR) {
                    lllllllllllIllIllIllIIIIlllIlIIl.setBlockState(lllllllllllIllIllIllIIIIlllIllII, lllllllllllIllIllIllIIIIlllIlIll.withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, lllllllllllIllIllIllIIIIlllllIIl), 3);
                }
            }
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIllIllIllIIIlIllllIIl, final IBlockAccess lllllllllllIllIllIllIIIlIllllIII, final BlockPos lllllllllllIllIllIllIIIlIlllIlll) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIllIllIllIIIlIllllIIl.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING).ordinal()]) {
            default: {
                return BlockTripWireHook.HOOK_EAST_AABB;
            }
            case 5: {
                return BlockTripWireHook.HOOK_WEST_AABB;
            }
            case 4: {
                return BlockTripWireHook.HOOK_SOUTH_AABB;
            }
            case 3: {
                return BlockTripWireHook.HOOK_NORTH_AABB;
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTripWireHook.FACING, BlockTripWireHook.POWERED, BlockTripWireHook.ATTACHED });
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllIllIllIllIIIlIIllIlII, final BlockPos lllllllllllIllIllIllIIIlIIllIIll, final IBlockState lllllllllllIllIllIllIIIlIIlIllII, final EntityLivingBase lllllllllllIllIllIllIIIlIIllIIIl, final ItemStack lllllllllllIllIllIllIIIlIIllIIII) {
        this.calculateState(lllllllllllIllIllIllIIIlIIllIlII, lllllllllllIllIllIllIIIlIIllIIll, lllllllllllIllIllIllIIIlIIlIllII, false, false, -1, null);
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllIllIllIllIIIIlIIIIlIl, final IBlockAccess lllllllllllIllIllIllIIIIlIIIIlII, final BlockPos lllllllllllIllIllIllIIIIlIIIIIll, final EnumFacing lllllllllllIllIllIllIIIIlIIIIIlI) {
        return lllllllllllIllIllIllIIIIlIIIIlIl.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED) ? 15 : 0;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIllIllIllIIIIIllIlIIl) {
        int lllllllllllIllIllIllIIIIIllIlIlI = 0;
        lllllllllllIllIllIllIIIIIllIlIlI |= lllllllllllIllIllIllIIIIIllIlIIl.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING).getHorizontalIndex();
        if (lllllllllllIllIllIllIIIIIllIlIIl.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED)) {
            lllllllllllIllIllIllIIIIIllIlIlI |= 0x8;
        }
        if (lllllllllllIllIllIllIIIIIllIlIIl.getValue((IProperty<Boolean>)BlockTripWireHook.ATTACHED)) {
            lllllllllllIllIllIllIIIIIllIlIlI |= 0x4;
        }
        return lllllllllllIllIllIllIIIIIllIlIlI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockTripWireHook.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final float lllllllllllIllIllIllIIIIIlIlIIII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIllIllIllIIIIIlIlIIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIllIllIllIIIIIlIlIIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIllIllIllIIIIIlIlIIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIllIllIllIIIIIlIlIIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIllIllIllIIIIIlIlIIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIllIllIllIIIIIlIlIIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockTripWireHook.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIllIllIllIIIIIlIlIIII;
    }
    
    public BlockTripWireHook() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockTripWireHook.POWERED, false).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setTickRandomly(true);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIllIllIllIIIIIlIlIlIl, final IBlockState lllllllllllIllIllIllIIIIIlIlIlII, final BlockPos lllllllllllIllIllIllIIIIIlIlIIll, final EnumFacing lllllllllllIllIllIllIIIIIlIlIIlI) {
        return BlockFaceShape.UNDEFINED;
    }
}
