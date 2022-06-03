// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.BlockFaceShape;
import java.util.List;
import net.minecraft.util.math.Vec3i;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.Rotation;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.math.AxisAlignedBB;

public abstract class BlockButton extends BlockDirectional
{
    protected static final /* synthetic */ AxisAlignedBB AABB_UP_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_SOUTH_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_EAST_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_WEST_OFF;
    protected static final /* synthetic */ AxisAlignedBB AABB_NORTH_OFF;
    protected static final /* synthetic */ AxisAlignedBB AABB_UP_OFF;
    protected static final /* synthetic */ AxisAlignedBB AABB_EAST_OFF;
    protected static final /* synthetic */ AxisAlignedBB AABB_DOWN_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_DOWN_OFF;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    protected static final /* synthetic */ AxisAlignedBB AABB_NORTH_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_WEST_ON;
    public static final /* synthetic */ PropertyBool POWERED;
    private final /* synthetic */ boolean wooden;
    protected static final /* synthetic */ AxisAlignedBB AABB_SOUTH_OFF;
    
    @Override
    public void breakBlock(final World lllllllllllIlllIIlIIlIlIllIIIlII, final BlockPos lllllllllllIlllIIlIIlIlIllIIIlll, final IBlockState lllllllllllIlllIIlIIlIlIllIIIIlI) {
        if (lllllllllllIlllIIlIIlIlIllIIIIlI.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            this.notifyNeighbors(lllllllllllIlllIIlIIlIlIllIIIlII, lllllllllllIlllIIlIIlIlIllIIIlll, lllllllllllIlllIIlIIlIlIllIIIIlI.getValue((IProperty<EnumFacing>)BlockButton.FACING));
        }
        super.breakBlock(lllllllllllIlllIIlIIlIlIllIIIlII, lllllllllllIlllIIlIIlIlIllIIIlll, lllllllllllIlllIIlIIlIlIllIIIIlI);
    }
    
    private boolean checkForDrop(final World lllllllllllIlllIIlIIlIlIllllIIII, final BlockPos lllllllllllIlllIIlIIlIlIllllIIll, final IBlockState lllllllllllIlllIIlIIlIlIlllIlllI) {
        if (this.canPlaceBlockAt(lllllllllllIlllIIlIIlIlIllllIIII, lllllllllllIlllIIlIIlIlIllllIIll)) {
            return true;
        }
        this.dropBlockAsItem(lllllllllllIlllIIlIIlIlIllllIIII, lllllllllllIlllIIlIIlIlIllllIIll, lllllllllllIlllIIlIIlIlIlllIlllI, 0);
        lllllllllllIlllIIlIIlIlIllllIIII.setBlockToAir(lllllllllllIlllIIlIIlIlIllllIIll);
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlllIIlIIlIlIIllIlIll) {
        final EnumFacing lllllllllllIlllIIlIIlIlIIllIIlIl;
        switch (lllllllllllIlllIIlIIlIlIIllIlIll & 0x7) {
            case 0: {
                final EnumFacing lllllllllllIlllIIlIIlIlIIllIlIlI = EnumFacing.DOWN;
                break;
            }
            case 1: {
                final EnumFacing lllllllllllIlllIIlIIlIlIIllIlIIl = EnumFacing.EAST;
                break;
            }
            case 2: {
                final EnumFacing lllllllllllIlllIIlIIlIlIIllIlIII = EnumFacing.WEST;
                break;
            }
            case 3: {
                final EnumFacing lllllllllllIlllIIlIIlIlIIllIIlll = EnumFacing.SOUTH;
                break;
            }
            case 4: {
                final EnumFacing lllllllllllIlllIIlIIlIlIIllIIllI = EnumFacing.NORTH;
                break;
            }
            default: {
                lllllllllllIlllIIlIIlIlIIllIIlIl = EnumFacing.UP;
                break;
            }
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, lllllllllllIlllIIlIIlIlIIllIIlIl).withProperty((IProperty<Comparable>)BlockButton.POWERED, (lllllllllllIlllIIlIIlIlIIllIlIll & 0x8) > 0);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockButton.FACING, BlockButton.POWERED });
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllIlllIIlIIlIlIlIllIIII) {
        return true;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIlllIIlIIlIllIlIlIIlI, final IBlockAccess lllllllllllIlllIIlIIlIllIlIlIIIl, final BlockPos lllllllllllIlllIIlIIlIllIlIlIIII) {
        return BlockButton.NULL_AABB;
    }
    
    @Override
    public void randomTick(final World lllllllllllIlllIIlIIlIlIlIlIlllI, final BlockPos lllllllllllIlllIIlIIlIlIlIlIllIl, final IBlockState lllllllllllIlllIIlIIlIlIlIlIllII, final Random lllllllllllIlllIIlIIlIlIlIlIlIll) {
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllIlllIIlIIlIlIlIllIlll, final IBlockAccess lllllllllllIlllIIlIIlIlIlIllIllI, final BlockPos lllllllllllIlllIIlIIlIlIlIllIlIl, final EnumFacing lllllllllllIlllIIlIIlIlIlIllIlII) {
        if (!lllllllllllIlllIIlIIlIlIlIllIlll.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            return 0;
        }
        return (lllllllllllIlllIIlIIlIlIlIllIlll.getValue((IProperty<Comparable>)BlockButton.FACING) == lllllllllllIlllIIlIIlIlIlIllIlII) ? 15 : 0;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIlllIIlIIlIlIIlIlIIlI, final Rotation lllllllllllIlllIIlIIlIlIIlIlIIIl) {
        return lllllllllllIlllIIlIIlIlIIlIlIIlI.withProperty((IProperty<Comparable>)BlockButton.FACING, lllllllllllIlllIIlIIlIlIIlIlIIIl.rotate(lllllllllllIlllIIlIIlIlIIlIlIIlI.getValue((IProperty<EnumFacing>)BlockButton.FACING)));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlllIIlIIlIlIlllIlIIl, final IBlockAccess lllllllllllIlllIIlIIlIlIlllIlIII, final BlockPos lllllllllllIlllIIlIIlIlIlllIIlll) {
        final EnumFacing lllllllllllIlllIIlIIlIlIlllIIllI = lllllllllllIlllIIlIIlIlIlllIlIIl.getValue((IProperty<EnumFacing>)BlockButton.FACING);
        final boolean lllllllllllIlllIIlIIlIlIlllIIlIl = lllllllllllIlllIIlIIlIlIlllIlIIl.getValue((IProperty<Boolean>)BlockButton.POWERED);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlllIIlIIlIlIlllIIllI.ordinal()]) {
            case 6: {
                return lllllllllllIlllIIlIIlIlIlllIIlIl ? BlockButton.AABB_EAST_ON : BlockButton.AABB_EAST_OFF;
            }
            case 5: {
                return lllllllllllIlllIIlIIlIlIlllIIlIl ? BlockButton.AABB_WEST_ON : BlockButton.AABB_WEST_OFF;
            }
            case 4: {
                return lllllllllllIlllIIlIIlIlIlllIIlIl ? BlockButton.AABB_SOUTH_ON : BlockButton.AABB_SOUTH_OFF;
            }
            default: {
                return lllllllllllIlllIIlIIlIlIlllIIlIl ? BlockButton.AABB_NORTH_ON : BlockButton.AABB_NORTH_OFF;
            }
            case 2: {
                return lllllllllllIlllIIlIIlIlIlllIIlIl ? BlockButton.AABB_UP_ON : BlockButton.AABB_UP_OFF;
            }
            case 1: {
                return lllllllllllIlllIIlIIlIlIlllIIlIl ? BlockButton.AABB_DOWN_ON : BlockButton.AABB_DOWN_OFF;
            }
        }
    }
    
    @Override
    public void updateTick(final World lllllllllllIlllIIlIIlIlIlIlIIlIl, final BlockPos lllllllllllIlllIIlIIlIlIlIlIIlII, final IBlockState lllllllllllIlllIIlIIlIlIlIlIIIll, final Random lllllllllllIlllIIlIIlIlIlIlIIIlI) {
        if (!lllllllllllIlllIIlIIlIlIlIlIIlIl.isRemote && lllllllllllIlllIIlIIlIlIlIlIIIll.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            if (this.wooden) {
                this.checkPressed(lllllllllllIlllIIlIIlIlIlIlIIIll, lllllllllllIlllIIlIIlIlIlIlIIlIl, lllllllllllIlllIIlIIlIlIlIlIIlII);
            }
            else {
                lllllllllllIlllIIlIIlIlIlIlIIlIl.setBlockState(lllllllllllIlllIIlIIlIlIlIlIIlII, lllllllllllIlllIIlIIlIlIlIlIIIll.withProperty((IProperty<Comparable>)BlockButton.POWERED, false));
                this.notifyNeighbors(lllllllllllIlllIIlIIlIlIlIlIIlIl, lllllllllllIlllIIlIIlIlIlIlIIlII, lllllllllllIlllIIlIIlIlIlIlIIIll.getValue((IProperty<EnumFacing>)BlockButton.FACING));
                this.playReleaseSound(lllllllllllIlllIIlIIlIlIlIlIIlIl, lllllllllllIlllIIlIIlIlIlIlIIlII);
                lllllllllllIlllIIlIIlIlIlIlIIlIl.markBlockRangeForRenderUpdate(lllllllllllIlllIIlIIlIlIlIlIIlII, lllllllllllIlllIIlIIlIlIlIlIIlII);
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllIlllIIlIIlIllIlIIIIll, final BlockPos lllllllllllIlllIIlIIlIllIlIIIIlI, final EnumFacing lllllllllllIlllIIlIIlIllIIlllllI) {
        return canPlaceBlock(lllllllllllIlllIIlIIlIllIlIIIIll, lllllllllllIlllIIlIIlIllIlIIIIlI, lllllllllllIlllIIlIIlIllIIlllllI);
    }
    
    private void checkPressed(final IBlockState lllllllllllIlllIIlIIlIlIlIIIIIIl, final World lllllllllllIlllIIlIIlIlIlIIIIIII, final BlockPos lllllllllllIlllIIlIIlIlIIlllllll) {
        final List<? extends Entity> lllllllllllIlllIIlIIlIlIlIIIIlIl = lllllllllllIlllIIlIIlIlIlIIIIIII.getEntitiesWithinAABB((Class<? extends Entity>)EntityArrow.class, lllllllllllIlllIIlIIlIlIlIIIIIIl.getBoundingBox(lllllllllllIlllIIlIIlIlIlIIIIIII, lllllllllllIlllIIlIIlIlIIlllllll).offset(lllllllllllIlllIIlIIlIlIIlllllll));
        final boolean lllllllllllIlllIIlIIlIlIlIIIIlII = !lllllllllllIlllIIlIIlIlIlIIIIlIl.isEmpty();
        final boolean lllllllllllIlllIIlIIlIlIlIIIIIll = lllllllllllIlllIIlIIlIlIlIIIIIIl.getValue((IProperty<Boolean>)BlockButton.POWERED);
        if (lllllllllllIlllIIlIIlIlIlIIIIlII && !lllllllllllIlllIIlIIlIlIlIIIIIll) {
            lllllllllllIlllIIlIIlIlIlIIIIIII.setBlockState(lllllllllllIlllIIlIIlIlIIlllllll, lllllllllllIlllIIlIIlIlIlIIIIIIl.withProperty((IProperty<Comparable>)BlockButton.POWERED, true));
            this.notifyNeighbors(lllllllllllIlllIIlIIlIlIlIIIIIII, lllllllllllIlllIIlIIlIlIIlllllll, lllllllllllIlllIIlIIlIlIlIIIIIIl.getValue((IProperty<EnumFacing>)BlockButton.FACING));
            lllllllllllIlllIIlIIlIlIlIIIIIII.markBlockRangeForRenderUpdate(lllllllllllIlllIIlIIlIlIIlllllll, lllllllllllIlllIIlIIlIlIIlllllll);
            this.playClickSound(null, lllllllllllIlllIIlIIlIlIlIIIIIII, lllllllllllIlllIIlIIlIlIIlllllll);
        }
        if (!lllllllllllIlllIIlIIlIlIlIIIIlII && lllllllllllIlllIIlIIlIlIlIIIIIll) {
            lllllllllllIlllIIlIIlIlIlIIIIIII.setBlockState(lllllllllllIlllIIlIIlIlIIlllllll, lllllllllllIlllIIlIIlIlIlIIIIIIl.withProperty((IProperty<Comparable>)BlockButton.POWERED, false));
            this.notifyNeighbors(lllllllllllIlllIIlIIlIlIlIIIIIII, lllllllllllIlllIIlIIlIlIIlllllll, lllllllllllIlllIIlIIlIlIlIIIIIIl.getValue((IProperty<EnumFacing>)BlockButton.FACING));
            lllllllllllIlllIIlIIlIlIlIIIIIII.markBlockRangeForRenderUpdate(lllllllllllIlllIIlIIlIlIIlllllll, lllllllllllIlllIIlIIlIlIIlllllll);
            this.playReleaseSound(lllllllllllIlllIIlIIlIlIlIIIIIII, lllllllllllIlllIIlIIlIlIIlllllll);
        }
        if (lllllllllllIlllIIlIIlIlIlIIIIlII) {
            lllllllllllIlllIIlIIlIlIlIIIIIII.scheduleUpdate(new BlockPos(lllllllllllIlllIIlIIlIlIIlllllll), this, this.tickRate(lllllllllllIlllIIlIIlIlIlIIIIIII));
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlllIIlIIlIlIIlIIIIll, final IBlockState lllllllllllIlllIIlIIlIlIIlIIIIlI, final BlockPos lllllllllllIlllIIlIIlIlIIlIIIIIl, final EnumFacing lllllllllllIlllIIlIIlIlIIlIIIIII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockButton.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final long lllllllllllIlllIIlIIlIlIIIlllllI = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlllIIlIIlIlIIIlllllI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllIIlIIlIlIIIlllllI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllIIlIIlIlIIIlllllI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlllIIlIIlIlIIIlllllI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlllIIlIIlIlIIIlllllI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlllIIlIIlIlIIIlllllI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockButton.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlllIIlIIlIlIIIlllllI;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIlllIIlIIlIllIIIIlIlI, final BlockPos lllllllllllIlllIIlIIlIllIIIlIIlI, final EnumFacing lllllllllllIlllIIlIIlIllIIIIlIII, final float lllllllllllIlllIIlIIlIllIIIlIIII, final float lllllllllllIlllIIlIIlIllIIIIllll, final float lllllllllllIlllIIlIIlIllIIIIlllI, final int lllllllllllIlllIIlIIlIllIIIIllIl, final EntityLivingBase lllllllllllIlllIIlIIlIllIIIIllII) {
        return canPlaceBlock(lllllllllllIlllIIlIIlIllIIIIlIlI, lllllllllllIlllIIlIIlIllIIIlIIlI, lllllllllllIlllIIlIIlIllIIIIlIII) ? this.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, lllllllllllIlllIIlIIlIllIIIIlIII).withProperty((IProperty<Comparable>)BlockButton.POWERED, false) : this.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, EnumFacing.DOWN).withProperty((IProperty<Comparable>)BlockButton.POWERED, false);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIlllIIlIIlIlIllIlIIIl, final BlockPos lllllllllllIlllIIlIIlIlIllIllIlI, final IBlockState lllllllllllIlllIIlIIlIlIllIllIIl, final EntityPlayer lllllllllllIlllIIlIIlIlIllIIlllI, final EnumHand lllllllllllIlllIIlIIlIlIllIlIlll, final EnumFacing lllllllllllIlllIIlIIlIlIllIlIllI, final float lllllllllllIlllIIlIIlIlIllIlIlIl, final float lllllllllllIlllIIlIIlIlIllIlIlII, final float lllllllllllIlllIIlIIlIlIllIlIIll) {
        if (lllllllllllIlllIIlIIlIlIllIllIIl.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            return true;
        }
        lllllllllllIlllIIlIIlIlIllIlIIIl.setBlockState(lllllllllllIlllIIlIIlIlIllIllIlI, lllllllllllIlllIIlIIlIlIllIllIIl.withProperty((IProperty<Comparable>)BlockButton.POWERED, true), 3);
        lllllllllllIlllIIlIIlIlIllIlIIIl.markBlockRangeForRenderUpdate(lllllllllllIlllIIlIIlIlIllIllIlI, lllllllllllIlllIIlIIlIlIllIllIlI);
        this.playClickSound(lllllllllllIlllIIlIIlIlIllIIlllI, lllllllllllIlllIIlIIlIlIllIlIIIl, lllllllllllIlllIIlIIlIlIllIllIlI);
        this.notifyNeighbors(lllllllllllIlllIIlIIlIlIllIlIIIl, lllllllllllIlllIIlIIlIlIllIllIlI, lllllllllllIlllIIlIIlIlIllIllIIl.getValue((IProperty<EnumFacing>)BlockButton.FACING));
        lllllllllllIlllIIlIIlIlIllIlIIIl.scheduleUpdate(lllllllllllIlllIIlIIlIlIllIllIlI, this, this.tickRate(lllllllllllIlllIIlIIlIlIllIlIIIl));
        return true;
    }
    
    protected abstract void playReleaseSound(final World p0, final BlockPos p1);
    
    protected BlockButton(final boolean lllllllllllIlllIIlIIlIllIlIlIlII) {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockButton.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockButton.POWERED, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.wooden = lllllllllllIlllIIlIIlIllIlIlIlII;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlllIIlIIlIlIIlIlIlll) {
        int lllllllllllIlllIIlIIlIlIIlIllIII = 0;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlllIIlIIlIlIIlIlIlll.getValue((IProperty<EnumFacing>)BlockButton.FACING).ordinal()]) {
            case 6: {
                final int lllllllllllIlllIIlIIlIlIIlIlllIl = 1;
                break;
            }
            case 5: {
                final int lllllllllllIlllIIlIIlIlIIlIlllII = 2;
                break;
            }
            case 4: {
                final int lllllllllllIlllIIlIIlIlIIlIllIll = 3;
                break;
            }
            case 3: {
                final int lllllllllllIlllIIlIIlIlIIlIllIlI = 4;
                break;
            }
            default: {
                final int lllllllllllIlllIIlIIlIlIIlIllIIl = 5;
                break;
            }
            case 1: {
                lllllllllllIlllIIlIIlIlIIlIllIII = 0;
                break;
            }
        }
        if (lllllllllllIlllIIlIIlIlIIlIlIlll.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            lllllllllllIlllIIlIIlIlIIlIllIII |= 0x8;
        }
        return lllllllllllIlllIIlIIlIlIIlIllIII;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllIlllIIlIIlIlIlIIllIII, final BlockPos lllllllllllIlllIIlIIlIlIlIIlIIlI, final IBlockState lllllllllllIlllIIlIIlIlIlIIlIIIl, final Entity lllllllllllIlllIIlIIlIlIlIIlIlIl) {
        if (!lllllllllllIlllIIlIIlIlIlIIllIII.isRemote && this.wooden && !lllllllllllIlllIIlIIlIlIlIIlIIIl.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            this.checkPressed(lllllllllllIlllIIlIIlIlIlIIlIIIl, lllllllllllIlllIIlIIlIlIlIIllIII, lllllllllllIlllIIlIIlIlIlIIlIIlI);
        }
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllIlllIIlIIlIlIlIllllll, final IBlockAccess lllllllllllIlllIIlIIlIlIlIlllllI, final BlockPos lllllllllllIlllIIlIIlIlIlIllllIl, final EnumFacing lllllllllllIlllIIlIIlIlIlIllllII) {
        return lllllllllllIlllIIlIIlIlIlIllllll.getValue((IProperty<Boolean>)BlockButton.POWERED) ? 15 : 0;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIlllIIlIIlIlIIlIIlIll, final Mirror lllllllllllIlllIIlIIlIlIIlIIlIlI) {
        return lllllllllllIlllIIlIIlIlIIlIIlIll.withRotation(lllllllllllIlllIIlIIlIlIIlIIlIlI.toRotation(lllllllllllIlllIIlIIlIlIIlIIlIll.getValue((IProperty<EnumFacing>)BlockButton.FACING)));
    }
    
    protected abstract void playClickSound(final EntityPlayer p0, final World p1, final BlockPos p2);
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlllIIlIIlIllIlIIlIII) {
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIlllIIlIIlIlIllllllII, final World lllllllllllIlllIIlIIlIlIlllllIll, final BlockPos lllllllllllIlllIIlIIlIlIlllllIlI, final Block lllllllllllIlllIIlIIlIlIllllllll, final BlockPos lllllllllllIlllIIlIIlIlIlllllllI) {
        if (this.checkForDrop(lllllllllllIlllIIlIIlIlIlllllIll, lllllllllllIlllIIlIIlIlIlllllIlI, lllllllllllIlllIIlIIlIlIllllllII) && !canPlaceBlock(lllllllllllIlllIIlIIlIlIlllllIll, lllllllllllIlllIIlIIlIlIlllllIlI, lllllllllllIlllIIlIIlIlIllllllII.getValue((IProperty<EnumFacing>)BlockButton.FACING))) {
            this.dropBlockAsItem(lllllllllllIlllIIlIIlIlIlllllIll, lllllllllllIlllIIlIIlIlIlllllIlI, lllllllllllIlllIIlIIlIlIllllllII, 0);
            lllllllllllIlllIIlIIlIlIlllllIll.setBlockToAir(lllllllllllIlllIIlIIlIlIlllllIlI);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlllIIlIIlIllIlIIlIlI) {
        return false;
    }
    
    static {
        POWERED = PropertyBool.create("powered");
        AABB_DOWN_OFF = new AxisAlignedBB(0.3125, 0.875, 0.375, 0.6875, 1.0, 0.625);
        AABB_UP_OFF = new AxisAlignedBB(0.3125, 0.0, 0.375, 0.6875, 0.125, 0.625);
        AABB_NORTH_OFF = new AxisAlignedBB(0.3125, 0.375, 0.875, 0.6875, 0.625, 1.0);
        AABB_SOUTH_OFF = new AxisAlignedBB(0.3125, 0.375, 0.0, 0.6875, 0.625, 0.125);
        AABB_WEST_OFF = new AxisAlignedBB(0.875, 0.375, 0.3125, 1.0, 0.625, 0.6875);
        AABB_EAST_OFF = new AxisAlignedBB(0.0, 0.375, 0.3125, 0.125, 0.625, 0.6875);
        AABB_DOWN_ON = new AxisAlignedBB(0.3125, 0.9375, 0.375, 0.6875, 1.0, 0.625);
        AABB_UP_ON = new AxisAlignedBB(0.3125, 0.0, 0.375, 0.6875, 0.0625, 0.625);
        AABB_NORTH_ON = new AxisAlignedBB(0.3125, 0.375, 0.9375, 0.6875, 0.625, 1.0);
        AABB_SOUTH_ON = new AxisAlignedBB(0.3125, 0.375, 0.0, 0.6875, 0.625, 0.0625);
        AABB_WEST_ON = new AxisAlignedBB(0.9375, 0.375, 0.3125, 1.0, 0.625, 0.6875);
        AABB_EAST_ON = new AxisAlignedBB(0.0, 0.375, 0.3125, 0.0625, 0.625, 0.6875);
    }
    
    private void notifyNeighbors(final World lllllllllllIlllIIlIIlIlIIlllIllI, final BlockPos lllllllllllIlllIIlIIlIlIIlllIIIl, final EnumFacing lllllllllllIlllIIlIIlIlIIlllIIII) {
        lllllllllllIlllIIlIIlIlIIlllIllI.notifyNeighborsOfStateChange(lllllllllllIlllIIlIIlIlIIlllIIIl, this, false);
        lllllllllllIlllIIlIIlIlIIlllIllI.notifyNeighborsOfStateChange(lllllllllllIlllIIlIIlIlIIlllIIIl.offset(lllllllllllIlllIIlIIlIlIIlllIIII.getOpposite()), this, false);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIlllIIlIIlIllIIllIllI, final BlockPos lllllllllllIlllIIlIIlIllIIllIIlI) {
        final boolean lllllllllllIlllIIlIIlIllIIlIlllI;
        final byte lllllllllllIlllIIlIIlIllIIlIllll = (byte)((EnumFacing[])(Object)(lllllllllllIlllIIlIIlIllIIlIlllI = (boolean)(Object)EnumFacing.values())).length;
        for (short lllllllllllIlllIIlIIlIllIIllIIII = 0; lllllllllllIlllIIlIIlIllIIllIIII < lllllllllllIlllIIlIIlIllIIlIllll; ++lllllllllllIlllIIlIIlIllIIllIIII) {
            final EnumFacing lllllllllllIlllIIlIIlIllIIllIlII = lllllllllllIlllIIlIIlIllIIlIlllI[lllllllllllIlllIIlIIlIllIIllIIII];
            if (canPlaceBlock(lllllllllllIlllIIlIIlIllIIllIllI, lllllllllllIlllIIlIIlIllIIllIIlI, lllllllllllIlllIIlIIlIllIIllIlII)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int tickRate(final World lllllllllllIlllIIlIIlIllIlIIllIl) {
        return this.wooden ? 30 : 20;
    }
    
    protected static boolean canPlaceBlock(final World lllllllllllIlllIIlIIlIllIIIlllll, final BlockPos lllllllllllIlllIIlIIlIllIIIllllI, final EnumFacing lllllllllllIlllIIlIIlIllIIlIIlII) {
        final BlockPos lllllllllllIlllIIlIIlIllIIlIIIll = lllllllllllIlllIIlIIlIllIIIllllI.offset(lllllllllllIlllIIlIIlIllIIlIIlII.getOpposite());
        final IBlockState lllllllllllIlllIIlIIlIllIIlIIIlI = lllllllllllIlllIIlIIlIllIIIlllll.getBlockState(lllllllllllIlllIIlIIlIllIIlIIIll);
        final boolean lllllllllllIlllIIlIIlIllIIlIIIIl = lllllllllllIlllIIlIIlIllIIlIIIlI.func_193401_d(lllllllllllIlllIIlIIlIllIIIlllll, lllllllllllIlllIIlIIlIllIIlIIIll, lllllllllllIlllIIlIIlIllIIlIIlII) == BlockFaceShape.SOLID;
        final Block lllllllllllIlllIIlIIlIllIIlIIIII = lllllllllllIlllIIlIIlIllIIlIIIlI.getBlock();
        if (lllllllllllIlllIIlIIlIllIIlIIlII == EnumFacing.UP) {
            return lllllllllllIlllIIlIIlIllIIlIIIII == Blocks.HOPPER || (!Block.func_193384_b(lllllllllllIlllIIlIIlIllIIlIIIII) && lllllllllllIlllIIlIIlIllIIlIIIIl);
        }
        return !Block.func_193382_c(lllllllllllIlllIIlIIlIllIIlIIIII) && lllllllllllIlllIIlIIlIllIIlIIIIl;
    }
}
