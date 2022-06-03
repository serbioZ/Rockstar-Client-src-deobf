// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.Rotation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.Mirror;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.IInventory;
import javax.annotation.Nullable;
import net.minecraft.world.ILockableContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.IBlockAccess;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockChest extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB NORTH_CHEST_AABB;
    public final /* synthetic */ Type chestType;
    protected static final /* synthetic */ AxisAlignedBB EAST_CHEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB WEST_CHEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB NOT_CONNECTED_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_CHEST_AABB;
    
    public IBlockState correctFacing(final World lllllllllllllIIIIIllIlIlllIllIll, final BlockPos lllllllllllllIIIIIllIlIllllIIIlI, final IBlockState lllllllllllllIIIIIllIlIllllIIIIl) {
        EnumFacing lllllllllllllIIIIIllIlIllllIIIII = null;
        for (final EnumFacing lllllllllllllIIIIIllIlIlllIlllll : EnumFacing.Plane.HORIZONTAL) {
            final IBlockState lllllllllllllIIIIIllIlIlllIllllI = lllllllllllllIIIIIllIlIlllIllIll.getBlockState(lllllllllllllIIIIIllIlIllllIIIlI.offset(lllllllllllllIIIIIllIlIlllIlllll));
            if (lllllllllllllIIIIIllIlIlllIllllI.getBlock() == this) {
                return lllllllllllllIIIIIllIlIllllIIIIl;
            }
            if (!lllllllllllllIIIIIllIlIlllIllllI.isFullBlock()) {
                continue;
            }
            if (lllllllllllllIIIIIllIlIllllIIIII != null) {
                lllllllllllllIIIIIllIlIllllIIIII = null;
                break;
            }
            lllllllllllllIIIIIllIlIllllIIIII = lllllllllllllIIIIIllIlIlllIlllll;
        }
        if (lllllllllllllIIIIIllIlIllllIIIII != null) {
            return lllllllllllllIIIIIllIlIllllIIIIl.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIIIllIlIllllIIIII.getOpposite());
        }
        EnumFacing lllllllllllllIIIIIllIlIlllIlllIl = lllllllllllllIIIIIllIlIllllIIIIl.getValue((IProperty<EnumFacing>)BlockChest.FACING);
        if (lllllllllllllIIIIIllIlIlllIllIll.getBlockState(lllllllllllllIIIIIllIlIllllIIIlI.offset(lllllllllllllIIIIIllIlIlllIlllIl)).isFullBlock()) {
            lllllllllllllIIIIIllIlIlllIlllIl = lllllllllllllIIIIIllIlIlllIlllIl.getOpposite();
        }
        if (lllllllllllllIIIIIllIlIlllIllIll.getBlockState(lllllllllllllIIIIIllIlIllllIIIlI.offset(lllllllllllllIIIIIllIlIlllIlllIl)).isFullBlock()) {
            lllllllllllllIIIIIllIlIlllIlllIl = lllllllllllllIIIIIllIlIlllIlllIl.rotateY();
        }
        if (lllllllllllllIIIIIllIlIlllIllIll.getBlockState(lllllllllllllIIIIIllIlIllllIIIlI.offset(lllllllllllllIIIIIllIlIlllIlllIl)).isFullBlock()) {
            lllllllllllllIIIIIllIlIlllIlllIl = lllllllllllllIIIIIllIlIlllIlllIl.getOpposite();
        }
        return lllllllllllllIIIIIllIlIllllIIIIl.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIIIllIlIlllIlllIl);
    }
    
    public IBlockState checkForSurroundingChests(final World lllllllllllllIIIIIllIlIllllllIlI, final BlockPos lllllllllllllIIIIIllIlIllllllIIl, IBlockState lllllllllllllIIIIIllIlIllllllIII) {
        if (lllllllllllllIIIIIllIlIllllllIlI.isRemote) {
            return lllllllllllllIIIIIllIlIllllllIII;
        }
        final IBlockState lllllllllllllIIIIIllIllIIIIIllII = lllllllllllllIIIIIllIlIllllllIlI.getBlockState(lllllllllllllIIIIIllIlIllllllIIl.north());
        final IBlockState lllllllllllllIIIIIllIllIIIIIlIll = lllllllllllllIIIIIllIlIllllllIlI.getBlockState(lllllllllllllIIIIIllIlIllllllIIl.south());
        final IBlockState lllllllllllllIIIIIllIllIIIIIlIlI = lllllllllllllIIIIIllIlIllllllIlI.getBlockState(lllllllllllllIIIIIllIlIllllllIIl.west());
        final IBlockState lllllllllllllIIIIIllIllIIIIIlIIl = lllllllllllllIIIIIllIlIllllllIlI.getBlockState(lllllllllllllIIIIIllIlIllllllIIl.east());
        EnumFacing lllllllllllllIIIIIllIllIIIIIlIII = lllllllllllllIIIIIllIlIllllllIII.getValue((IProperty<EnumFacing>)BlockChest.FACING);
        if (lllllllllllllIIIIIllIllIIIIIllII.getBlock() != this && lllllllllllllIIIIIllIllIIIIIlIll.getBlock() != this) {
            final boolean lllllllllllllIIIIIllIllIIIIIIlll = lllllllllllllIIIIIllIllIIIIIllII.isFullBlock();
            final boolean lllllllllllllIIIIIllIllIIIIIIllI = lllllllllllllIIIIIllIllIIIIIlIll.isFullBlock();
            if (lllllllllllllIIIIIllIllIIIIIlIlI.getBlock() == this || lllllllllllllIIIIIllIllIIIIIlIIl.getBlock() == this) {
                final BlockPos lllllllllllllIIIIIllIllIIIIIIlIl = (lllllllllllllIIIIIllIllIIIIIlIlI.getBlock() == this) ? lllllllllllllIIIIIllIlIllllllIIl.west() : lllllllllllllIIIIIllIlIllllllIIl.east();
                final IBlockState lllllllllllllIIIIIllIllIIIIIIlII = lllllllllllllIIIIIllIlIllllllIlI.getBlockState(lllllllllllllIIIIIllIllIIIIIIlIl.north());
                final IBlockState lllllllllllllIIIIIllIllIIIIIIIll = lllllllllllllIIIIIllIlIllllllIlI.getBlockState(lllllllllllllIIIIIllIllIIIIIIlIl.south());
                lllllllllllllIIIIIllIllIIIIIlIII = EnumFacing.SOUTH;
                EnumFacing lllllllllllllIIIIIllIllIIIIIIIIl = null;
                if (lllllllllllllIIIIIllIllIIIIIlIlI.getBlock() == this) {
                    final EnumFacing lllllllllllllIIIIIllIllIIIIIIIlI = lllllllllllllIIIIIllIllIIIIIlIlI.getValue((IProperty<EnumFacing>)BlockChest.FACING);
                }
                else {
                    lllllllllllllIIIIIllIllIIIIIIIIl = lllllllllllllIIIIIllIllIIIIIlIIl.getValue((IProperty<EnumFacing>)BlockChest.FACING);
                }
                if (lllllllllllllIIIIIllIllIIIIIIIIl == EnumFacing.NORTH) {
                    lllllllllllllIIIIIllIllIIIIIlIII = EnumFacing.NORTH;
                }
                if ((lllllllllllllIIIIIllIllIIIIIIlll || lllllllllllllIIIIIllIllIIIIIIlII.isFullBlock()) && !lllllllllllllIIIIIllIllIIIIIIllI && !lllllllllllllIIIIIllIllIIIIIIIll.isFullBlock()) {
                    lllllllllllllIIIIIllIllIIIIIlIII = EnumFacing.SOUTH;
                }
                if ((lllllllllllllIIIIIllIllIIIIIIllI || lllllllllllllIIIIIllIllIIIIIIIll.isFullBlock()) && !lllllllllllllIIIIIllIllIIIIIIlll && !lllllllllllllIIIIIllIllIIIIIIlII.isFullBlock()) {
                    lllllllllllllIIIIIllIllIIIIIlIII = EnumFacing.NORTH;
                }
            }
        }
        else {
            final BlockPos lllllllllllllIIIIIllIllIIIIIIIII = (lllllllllllllIIIIIllIllIIIIIllII.getBlock() == this) ? lllllllllllllIIIIIllIlIllllllIIl.north() : lllllllllllllIIIIIllIlIllllllIIl.south();
            final IBlockState lllllllllllllIIIIIllIlIlllllllll = lllllllllllllIIIIIllIlIllllllIlI.getBlockState(lllllllllllllIIIIIllIllIIIIIIIII.west());
            final IBlockState lllllllllllllIIIIIllIlIllllllllI = lllllllllllllIIIIIllIlIllllllIlI.getBlockState(lllllllllllllIIIIIllIllIIIIIIIII.east());
            lllllllllllllIIIIIllIllIIIIIlIII = EnumFacing.EAST;
            EnumFacing lllllllllllllIIIIIllIlIlllllllII = null;
            if (lllllllllllllIIIIIllIllIIIIIllII.getBlock() == this) {
                final EnumFacing lllllllllllllIIIIIllIlIlllllllIl = lllllllllllllIIIIIllIllIIIIIllII.getValue((IProperty<EnumFacing>)BlockChest.FACING);
            }
            else {
                lllllllllllllIIIIIllIlIlllllllII = lllllllllllllIIIIIllIllIIIIIlIll.getValue((IProperty<EnumFacing>)BlockChest.FACING);
            }
            if (lllllllllllllIIIIIllIlIlllllllII == EnumFacing.WEST) {
                lllllllllllllIIIIIllIllIIIIIlIII = EnumFacing.WEST;
            }
            if ((lllllllllllllIIIIIllIllIIIIIlIlI.isFullBlock() || lllllllllllllIIIIIllIlIlllllllll.isFullBlock()) && !lllllllllllllIIIIIllIllIIIIIlIIl.isFullBlock() && !lllllllllllllIIIIIllIlIllllllllI.isFullBlock()) {
                lllllllllllllIIIIIllIllIIIIIlIII = EnumFacing.EAST;
            }
            if ((lllllllllllllIIIIIllIllIIIIIlIIl.isFullBlock() || lllllllllllllIIIIIllIlIllllllllI.isFullBlock()) && !lllllllllllllIIIIIllIllIIIIIlIlI.isFullBlock() && !lllllllllllllIIIIIllIlIlllllllll.isFullBlock()) {
                lllllllllllllIIIIIllIllIIIIIlIII = EnumFacing.WEST;
            }
        }
        lllllllllllllIIIIIllIlIllllllIII = lllllllllllllIIIIIllIlIllllllIII.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIIIllIllIIIIIlIII);
        lllllllllllllIIIIIllIlIllllllIlI.setBlockState(lllllllllllllIIIIIllIlIllllllIIl, lllllllllllllIIIIIllIlIllllllIII, 3);
        return lllllllllllllIIIIIllIlIllllllIII;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIIIIIllIllIIlIllIIl, final BlockPos lllllllllllllIIIIIllIllIIlIllIII, final EnumFacing lllllllllllllIIIIIllIllIIlIlIlll, final float lllllllllllllIIIIIllIllIIlIlIllI, final float lllllllllllllIIIIIllIllIIlIlIlIl, final float lllllllllllllIIIIIllIllIIlIlIlII, final int lllllllllllllIIIIIllIllIIlIlIIll, final EntityLivingBase lllllllllllllIIIIIllIllIIlIlIIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIIIllIllIIlIlIIlI.getHorizontalFacing());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIIIllIlIIllllIlIl) {
        EnumFacing lllllllllllllIIIIIllIlIIllllIlll = EnumFacing.getFront(lllllllllllllIIIIIllIlIIllllIlIl);
        if (lllllllllllllIIIIIllIlIIllllIlll.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllllIIIIIllIlIIllllIlll = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIIIllIlIIllllIlll);
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllIIIIIllIlIlIIllllll, final IBlockAccess lllllllllllllIIIIIllIlIlIIlllllI, final BlockPos lllllllllllllIIIIIllIlIlIIllIlll, final EnumFacing lllllllllllllIIIIIllIlIlIIllllII) {
        if (!lllllllllllllIIIIIllIlIlIIllllll.canProvidePower()) {
            return 0;
        }
        int lllllllllllllIIIIIllIlIlIIlllIll = 0;
        final TileEntity lllllllllllllIIIIIllIlIlIIlllIlI = lllllllllllllIIIIIllIlIlIIlllllI.getTileEntity(lllllllllllllIIIIIllIlIlIIllIlll);
        if (lllllllllllllIIIIIllIlIlIIlllIlI instanceof TileEntityChest) {
            lllllllllllllIIIIIllIlIlIIlllIll = ((TileEntityChest)lllllllllllllIIIIIllIlIlIIlllIlI).numPlayersUsing;
        }
        return MathHelper.clamp(lllllllllllllIIIIIllIlIlIIlllIll, 0, 15);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIIIIllIlIllIlIIllI, final World lllllllllllllIIIIIllIlIllIIllllI, final BlockPos lllllllllllllIIIIIllIlIllIIlllIl, final Block lllllllllllllIIIIIllIlIllIIlllII, final BlockPos lllllllllllllIIIIIllIlIllIIllIll) {
        super.neighborChanged(lllllllllllllIIIIIllIlIllIlIIllI, lllllllllllllIIIIIllIlIllIIllllI, lllllllllllllIIIIIllIlIllIIlllIl, lllllllllllllIIIIIllIlIllIIlllII, lllllllllllllIIIIIllIlIllIIllIll);
        final TileEntity lllllllllllllIIIIIllIlIllIlIIIIl = lllllllllllllIIIIIllIlIllIIllllI.getTileEntity(lllllllllllllIIIIIllIlIllIIlllIl);
        if (lllllllllllllIIIIIllIlIllIlIIIIl instanceof TileEntityChest) {
            lllllllllllllIIIIIllIlIllIlIIIIl.updateContainingBlockInfo();
        }
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllIIIIIllIlIlIlIIIlll) {
        return this.chestType == Type.TRAP;
    }
    
    @Nullable
    public ILockableContainer getLockableContainer(final World lllllllllllllIIIIIllIlIlIlllIIIl, final BlockPos lllllllllllllIIIIIllIlIlIllIllIl) {
        return this.getContainer(lllllllllllllIIIIIllIlIlIlllIIIl, lllllllllllllIIIIIllIlIlIllIllIl, false);
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIIIIIllIlIllIIlIIll, final BlockPos lllllllllllllIIIIIllIlIllIIlIIlI, final IBlockState lllllllllllllIIIIIllIlIllIIIllII) {
        final TileEntity lllllllllllllIIIIIllIlIllIIlIIII = lllllllllllllIIIIIllIlIllIIlIIll.getTileEntity(lllllllllllllIIIIIllIlIllIIlIIlI);
        if (lllllllllllllIIIIIllIlIllIIlIIII instanceof IInventory) {
            InventoryHelper.dropInventoryItems(lllllllllllllIIIIIllIlIllIIlIIll, lllllllllllllIIIIIllIlIllIIlIIlI, (IInventory)lllllllllllllIIIIIllIlIllIIlIIII);
            lllllllllllllIIIIIllIlIllIIlIIll.updateComparatorOutputLevel(lllllllllllllIIIIIllIlIllIIlIIlI, this);
        }
        super.breakBlock(lllllllllllllIIIIIllIlIllIIlIIll, lllllllllllllIIIIIllIlIllIIlIIlI, lllllllllllllIIIIIllIlIllIIIllII);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIIIIllIllIIllllIIl, final IBlockAccess lllllllllllllIIIIIllIllIIllllIII, final BlockPos lllllllllllllIIIIIllIllIIlllIlll) {
        if (lllllllllllllIIIIIllIllIIllllIII.getBlockState(lllllllllllllIIIIIllIllIIlllIlll.north()).getBlock() == this) {
            return BlockChest.NORTH_CHEST_AABB;
        }
        if (lllllllllllllIIIIIllIllIIllllIII.getBlockState(lllllllllllllIIIIIllIllIIlllIlll.south()).getBlock() == this) {
            return BlockChest.SOUTH_CHEST_AABB;
        }
        if (lllllllllllllIIIIIllIllIIllllIII.getBlockState(lllllllllllllIIIIIllIllIIlllIlll.west()).getBlock() == this) {
            return BlockChest.WEST_CHEST_AABB;
        }
        return (lllllllllllllIIIIIllIllIIllllIII.getBlockState(lllllllllllllIIIIIllIllIIlllIlll.east()).getBlock() == this) ? BlockChest.EAST_CHEST_AABB : BlockChest.NOT_CONNECTED_AABB;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIIIllIlIIllllIIIl) {
        return lllllllllllllIIIIIllIlIIllllIIIl.getValue((IProperty<EnumFacing>)BlockChest.FACING).getIndex();
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        NORTH_CHEST_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0, 0.9375, 0.875, 0.9375);
        SOUTH_CHEST_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.875, 1.0);
        WEST_CHEST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0625, 0.9375, 0.875, 0.9375);
        EAST_CHEST_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 1.0, 0.875, 0.9375);
        NOT_CONNECTED_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.875, 0.9375);
    }
    
    private boolean isBlocked(final World lllllllllllllIIIIIllIlIlIIlIIIII, final BlockPos lllllllllllllIIIIIllIlIlIIIlllll) {
        return this.isBelowSolidBlock(lllllllllllllIIIIIllIlIlIIlIIIII, lllllllllllllIIIIIllIlIlIIIlllll) || this.isOcelotSittingOnChest(lllllllllllllIIIIIllIlIlIIlIIIII, lllllllllllllIIIIIllIlIlIIIlllll);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIIIIIllIllIIllIIIll, final BlockPos lllllllllllllIIIIIllIllIIllIlIIl, final IBlockState lllllllllllllIIIIIllIllIIllIlIII) {
        this.checkForSurroundingChests(lllllllllllllIIIIIllIllIIllIIIll, lllllllllllllIIIIIllIllIIllIlIIl, lllllllllllllIIIIIllIllIIllIlIII);
        for (final EnumFacing lllllllllllllIIIIIllIllIIllIIlll : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos lllllllllllllIIIIIllIllIIllIIllI = lllllllllllllIIIIIllIllIIllIlIIl.offset(lllllllllllllIIIIIllIllIIllIIlll);
            final IBlockState lllllllllllllIIIIIllIllIIllIIlIl = lllllllllllllIIIIIllIllIIllIIIll.getBlockState(lllllllllllllIIIIIllIllIIllIIllI);
            if (lllllllllllllIIIIIllIllIIllIIlIl.getBlock() == this) {
                this.checkForSurroundingChests(lllllllllllllIIIIIllIllIIllIIIll, lllllllllllllIIIIIllIllIIllIIllI, lllllllllllllIIIIIllIllIIllIIlIl);
            }
        }
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllIIIIIllIllIIllllllI) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllIIIIIllIlIlIIlIllll, final IBlockAccess lllllllllllllIIIIIllIlIlIIlIlIlI, final BlockPos lllllllllllllIIIIIllIlIlIIlIlIIl, final EnumFacing lllllllllllllIIIIIllIlIlIIlIlIII) {
        return (lllllllllllllIIIIIllIlIlIIlIlIII == EnumFacing.UP) ? lllllllllllllIIIIIllIlIlIIlIllll.getWeakPower(lllllllllllllIIIIIllIlIlIIlIlIlI, lllllllllllllIIIIIllIlIlIIlIlIIl, lllllllllllllIIIIIllIlIlIIlIlIII) : 0;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIIIIllIllIlIIIIIlI) {
        return false;
    }
    
    @Nullable
    public ILockableContainer getContainer(final World lllllllllllllIIIIIllIlIlIllIIIII, final BlockPos lllllllllllllIIIIIllIlIlIlIlIlIl, final boolean lllllllllllllIIIIIllIlIlIlIllllI) {
        final TileEntity lllllllllllllIIIIIllIlIlIlIlllIl = lllllllllllllIIIIIllIlIlIllIIIII.getTileEntity(lllllllllllllIIIIIllIlIlIlIlIlIl);
        if (!(lllllllllllllIIIIIllIlIlIlIlllIl instanceof TileEntityChest)) {
            return null;
        }
        ILockableContainer lllllllllllllIIIIIllIlIlIlIlllII = (TileEntityChest)lllllllllllllIIIIIllIlIlIlIlllIl;
        if (!lllllllllllllIIIIIllIlIlIlIllllI && this.isBlocked(lllllllllllllIIIIIllIlIlIllIIIII, lllllllllllllIIIIIllIlIlIlIlIlIl)) {
            return null;
        }
        for (final EnumFacing lllllllllllllIIIIIllIlIlIlIllIll : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos lllllllllllllIIIIIllIlIlIlIllIlI = lllllllllllllIIIIIllIlIlIlIlIlIl.offset(lllllllllllllIIIIIllIlIlIlIllIll);
            final Block lllllllllllllIIIIIllIlIlIlIllIIl = lllllllllllllIIIIIllIlIlIllIIIII.getBlockState(lllllllllllllIIIIIllIlIlIlIllIlI).getBlock();
            if (lllllllllllllIIIIIllIlIlIlIllIIl == this) {
                if (this.isBlocked(lllllllllllllIIIIIllIlIlIllIIIII, lllllllllllllIIIIIllIlIlIlIllIlI)) {
                    return null;
                }
                final TileEntity lllllllllllllIIIIIllIlIlIlIllIII = lllllllllllllIIIIIllIlIlIllIIIII.getTileEntity(lllllllllllllIIIIIllIlIlIlIllIlI);
                if (!(lllllllllllllIIIIIllIlIlIlIllIII instanceof TileEntityChest)) {
                    continue;
                }
                if (lllllllllllllIIIIIllIlIlIlIllIll != EnumFacing.WEST && lllllllllllllIIIIIllIlIlIlIllIll != EnumFacing.NORTH) {
                    lllllllllllllIIIIIllIlIlIlIlllII = new InventoryLargeChest("container.chestDouble", lllllllllllllIIIIIllIlIlIlIlllII, (ILockableContainer)lllllllllllllIIIIIllIlIlIlIllIII);
                }
                else {
                    lllllllllllllIIIIIllIlIlIlIlllII = new InventoryLargeChest("container.chestDouble", (ILockableContainer)lllllllllllllIIIIIllIlIlIlIllIII, lllllllllllllIIIIIllIlIlIlIlllII);
                }
            }
        }
        return lllllllllllllIIIIIllIlIlIlIlllII;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllIIIIIllIlIlIIIIIlll) {
        return true;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIIIIllIlIIlllIIlIl, final Mirror lllllllllllllIIIIIllIlIIlllIIlII) {
        return lllllllllllllIIIIIllIlIIlllIIlIl.withRotation(lllllllllllllIIIIIllIlIIlllIIlII.toRotation(lllllllllllllIIIIIllIlIIlllIIlIl.getValue((IProperty<EnumFacing>)BlockChest.FACING)));
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIIIIIllIlIlIlIIlIll, final int lllllllllllllIIIIIllIlIlIlIIlIlI) {
        return new TileEntityChest();
    }
    
    @Override
    public boolean func_190946_v(final IBlockState lllllllllllllIIIIIllIllIlIIIIIII) {
        return true;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllIIIIIllIlIlIIIIIIlI, final World lllllllllllllIIIIIllIlIlIIIIIIIl, final BlockPos lllllllllllllIIIIIllIlIIllllllIl) {
        return Container.calcRedstoneFromInventory(this.getLockableContainer(lllllllllllllIIIIIllIlIlIIIIIIIl, lllllllllllllIIIIIllIlIIllllllIl));
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIIIIIllIlIllIIIIlII, final BlockPos lllllllllllllIIIIIllIlIllIIIIIll, final IBlockState lllllllllllllIIIIIllIlIllIIIIIlI, final EntityPlayer lllllllllllllIIIIIllIlIllIIIIIIl, final EnumHand lllllllllllllIIIIIllIlIllIIIIIII, final EnumFacing lllllllllllllIIIIIllIlIlIlllllll, final float lllllllllllllIIIIIllIlIlIllllllI, final float lllllllllllllIIIIIllIlIlIlllllIl, final float lllllllllllllIIIIIllIlIlIlllllII) {
        if (lllllllllllllIIIIIllIlIllIIIIlII.isRemote) {
            return true;
        }
        final ILockableContainer lllllllllllllIIIIIllIlIlIllllIll = this.getLockableContainer(lllllllllllllIIIIIllIlIllIIIIlII, lllllllllllllIIIIIllIlIllIIIIIll);
        if (lllllllllllllIIIIIllIlIlIllllIll != null) {
            lllllllllllllIIIIIllIlIllIIIIIIl.displayGUIChest(lllllllllllllIIIIIllIlIlIllllIll);
            if (this.chestType == Type.BASIC) {
                lllllllllllllIIIIIllIlIllIIIIIIl.addStat(StatList.CHEST_OPENED);
            }
            else if (this.chestType == Type.TRAP) {
                lllllllllllllIIIIIllIlIllIIIIIIl.addStat(StatList.TRAPPED_CHEST_TRIGGERED);
            }
        }
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIIIIllIlIIllIlllIl, final IBlockState lllllllllllllIIIIIllIlIIllIlllII, final BlockPos lllllllllllllIIIIIllIlIIllIllIll, final EnumFacing lllllllllllllIIIIIllIlIIllIllIlI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    private boolean isDoubleChest(final World lllllllllllllIIIIIllIlIllIllIllI, final BlockPos lllllllllllllIIIIIllIlIllIllIIIl) {
        if (lllllllllllllIIIIIllIlIllIllIllI.getBlockState(lllllllllllllIIIIIllIlIllIllIIIl).getBlock() != this) {
            return false;
        }
        for (final EnumFacing lllllllllllllIIIIIllIlIllIllIlII : EnumFacing.Plane.HORIZONTAL) {
            if (lllllllllllllIIIIIllIlIllIllIllI.getBlockState(lllllllllllllIIIIIllIlIllIllIIIl.offset(lllllllllllllIIIIIllIlIllIllIlII)).getBlock() == this) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIIIllIllIlIIIIlII) {
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockChest.FACING });
    }
    
    private boolean isBelowSolidBlock(final World lllllllllllllIIIIIllIlIlIIIllIIl, final BlockPos lllllllllllllIIIIIllIlIlIIIllIII) {
        return lllllllllllllIIIIIllIlIlIIIllIIl.getBlockState(lllllllllllllIIIIIllIlIlIIIllIII.up()).isNormalCube();
    }
    
    private boolean isOcelotSittingOnChest(final World lllllllllllllIIIIIllIlIlIIIlIIIl, final BlockPos lllllllllllllIIIIIllIlIlIIIlIIII) {
        for (final Entity lllllllllllllIIIIIllIlIlIIIIllll : lllllllllllllIIIIIllIlIlIIIlIIIl.getEntitiesWithinAABB((Class<? extends Entity>)EntityOcelot.class, new AxisAlignedBB(lllllllllllllIIIIIllIlIlIIIlIIII.getX(), lllllllllllllIIIIIllIlIlIIIlIIII.getY() + 1, lllllllllllllIIIIIllIlIlIIIlIIII.getZ(), lllllllllllllIIIIIllIlIlIIIlIIII.getX() + 1, lllllllllllllIIIIIllIlIlIIIlIIII.getY() + 2, lllllllllllllIIIIIllIlIlIIIlIIII.getZ() + 1))) {
            final EntityOcelot lllllllllllllIIIIIllIlIlIIIIlllI = (EntityOcelot)lllllllllllllIIIIIllIlIlIIIIllll;
            if (lllllllllllllIIIIIllIlIlIIIIlllI.isSitting()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIIIIIllIlIlllIIIIll, final BlockPos lllllllllllllIIIIIllIlIlllIIlIlI) {
        int lllllllllllllIIIIIllIlIlllIIlIIl = 0;
        final BlockPos lllllllllllllIIIIIllIlIlllIIlIII = lllllllllllllIIIIIllIlIlllIIlIlI.west();
        final BlockPos lllllllllllllIIIIIllIlIlllIIIlll = lllllllllllllIIIIIllIlIlllIIlIlI.east();
        final BlockPos lllllllllllllIIIIIllIlIlllIIIllI = lllllllllllllIIIIIllIlIlllIIlIlI.north();
        final BlockPos lllllllllllllIIIIIllIlIlllIIIlIl = lllllllllllllIIIIIllIlIlllIIlIlI.south();
        if (lllllllllllllIIIIIllIlIlllIIIIll.getBlockState(lllllllllllllIIIIIllIlIlllIIlIII).getBlock() == this) {
            if (this.isDoubleChest(lllllllllllllIIIIIllIlIlllIIIIll, lllllllllllllIIIIIllIlIlllIIlIII)) {
                return false;
            }
            ++lllllllllllllIIIIIllIlIlllIIlIIl;
        }
        if (lllllllllllllIIIIIllIlIlllIIIIll.getBlockState(lllllllllllllIIIIIllIlIlllIIIlll).getBlock() == this) {
            if (this.isDoubleChest(lllllllllllllIIIIIllIlIlllIIIIll, lllllllllllllIIIIIllIlIlllIIIlll)) {
                return false;
            }
            ++lllllllllllllIIIIIllIlIlllIIlIIl;
        }
        if (lllllllllllllIIIIIllIlIlllIIIIll.getBlockState(lllllllllllllIIIIIllIlIlllIIIllI).getBlock() == this) {
            if (this.isDoubleChest(lllllllllllllIIIIIllIlIlllIIIIll, lllllllllllllIIIIIllIlIlllIIIllI)) {
                return false;
            }
            ++lllllllllllllIIIIIllIlIlllIIlIIl;
        }
        if (lllllllllllllIIIIIllIlIlllIIIIll.getBlockState(lllllllllllllIIIIIllIlIlllIIIlIl).getBlock() == this) {
            if (this.isDoubleChest(lllllllllllllIIIIIllIlIlllIIIIll, lllllllllllllIIIIIllIlIlllIIIlIl)) {
                return false;
            }
            ++lllllllllllllIIIIIllIlIlllIIlIIl;
        }
        return lllllllllllllIIIIIllIlIlllIIlIIl <= 1;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllIIIIIllIllIIIlllllI, final BlockPos lllllllllllllIIIIIllIllIIIllllIl, IBlockState lllllllllllllIIIIIllIllIIIlIllII, final EntityLivingBase lllllllllllllIIIIIllIllIIIlIlIll, final ItemStack lllllllllllllIIIIIllIllIIIlIlIlI) {
        final EnumFacing lllllllllllllIIIIIllIllIIIlllIIl = EnumFacing.getHorizontal(MathHelper.floor(lllllllllllllIIIIIllIllIIIlIlIll.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3).getOpposite();
        lllllllllllllIIIIIllIllIIIlIllII = lllllllllllllIIIIIllIllIIIlIllII.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIIIllIllIIIlllIIl);
        final BlockPos lllllllllllllIIIIIllIllIIIlllIII = lllllllllllllIIIIIllIllIIIllllIl.north();
        final BlockPos lllllllllllllIIIIIllIllIIIllIlll = lllllllllllllIIIIIllIllIIIllllIl.south();
        final BlockPos lllllllllllllIIIIIllIllIIIllIllI = lllllllllllllIIIIIllIllIIIllllIl.west();
        final BlockPos lllllllllllllIIIIIllIllIIIllIlIl = lllllllllllllIIIIIllIllIIIllllIl.east();
        final boolean lllllllllllllIIIIIllIllIIIllIlII = this == lllllllllllllIIIIIllIllIIIlllllI.getBlockState(lllllllllllllIIIIIllIllIIIlllIII).getBlock();
        final boolean lllllllllllllIIIIIllIllIIIllIIll = this == lllllllllllllIIIIIllIllIIIlllllI.getBlockState(lllllllllllllIIIIIllIllIIIllIlll).getBlock();
        final boolean lllllllllllllIIIIIllIllIIIllIIlI = this == lllllllllllllIIIIIllIllIIIlllllI.getBlockState(lllllllllllllIIIIIllIllIIIllIllI).getBlock();
        final boolean lllllllllllllIIIIIllIllIIIllIIIl = this == lllllllllllllIIIIIllIllIIIlllllI.getBlockState(lllllllllllllIIIIIllIllIIIllIlIl).getBlock();
        if (!lllllllllllllIIIIIllIllIIIllIlII && !lllllllllllllIIIIIllIllIIIllIIll && !lllllllllllllIIIIIllIllIIIllIIlI && !lllllllllllllIIIIIllIllIIIllIIIl) {
            lllllllllllllIIIIIllIllIIIlllllI.setBlockState(lllllllllllllIIIIIllIllIIIllllIl, lllllllllllllIIIIIllIllIIIlIllII, 3);
        }
        else if (lllllllllllllIIIIIllIllIIIlllIIl.getAxis() != EnumFacing.Axis.X || (!lllllllllllllIIIIIllIllIIIllIlII && !lllllllllllllIIIIIllIllIIIllIIll)) {
            if (lllllllllllllIIIIIllIllIIIlllIIl.getAxis() == EnumFacing.Axis.Z && (lllllllllllllIIIIIllIllIIIllIIlI || lllllllllllllIIIIIllIllIIIllIIIl)) {
                if (lllllllllllllIIIIIllIllIIIllIIlI) {
                    lllllllllllllIIIIIllIllIIIlllllI.setBlockState(lllllllllllllIIIIIllIllIIIllIllI, lllllllllllllIIIIIllIllIIIlIllII, 3);
                }
                else {
                    lllllllllllllIIIIIllIllIIIlllllI.setBlockState(lllllllllllllIIIIIllIllIIIllIlIl, lllllllllllllIIIIIllIllIIIlIllII, 3);
                }
                lllllllllllllIIIIIllIllIIIlllllI.setBlockState(lllllllllllllIIIIIllIllIIIllllIl, lllllllllllllIIIIIllIllIIIlIllII, 3);
            }
        }
        else {
            if (lllllllllllllIIIIIllIllIIIllIlII) {
                lllllllllllllIIIIIllIllIIIlllllI.setBlockState(lllllllllllllIIIIIllIllIIIlllIII, lllllllllllllIIIIIllIllIIIlIllII, 3);
            }
            else {
                lllllllllllllIIIIIllIllIIIlllllI.setBlockState(lllllllllllllIIIIIllIllIIIllIlll, lllllllllllllIIIIIllIllIIIlIllII, 3);
            }
            lllllllllllllIIIIIllIllIIIlllllI.setBlockState(lllllllllllllIIIIIllIllIIIllllIl, lllllllllllllIIIIIllIllIIIlIllII, 3);
        }
        if (lllllllllllllIIIIIllIllIIIlIlIlI.hasDisplayName()) {
            final TileEntity lllllllllllllIIIIIllIllIIIllIIII = lllllllllllllIIIIIllIllIIIlllllI.getTileEntity(lllllllllllllIIIIIllIllIIIllllIl);
            if (lllllllllllllIIIIIllIllIIIllIIII instanceof TileEntityChest) {
                ((TileEntityChest)lllllllllllllIIIIIllIllIIIllIIII).func_190575_a(lllllllllllllIIIIIllIllIIIlIlIlI.getDisplayName());
            }
        }
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIIIIllIlIIlllIllII, final Rotation lllllllllllllIIIIIllIlIIlllIlIIl) {
        return lllllllllllllIIIIIllIlIIlllIllII.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIIIllIlIIlllIlIIl.rotate(lllllllllllllIIIIIllIlIIlllIllII.getValue((IProperty<EnumFacing>)BlockChest.FACING)));
    }
    
    protected BlockChest(final Type lllllllllllllIIIIIllIllIlIIIlIII) {
        super(Material.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockChest.FACING, EnumFacing.NORTH));
        this.chestType = lllllllllllllIIIIIllIllIlIIIlIII;
        this.setCreativeTab((lllllllllllllIIIIIllIllIlIIIlIII == Type.TRAP) ? CreativeTabs.REDSTONE : CreativeTabs.DECORATIONS);
    }
    
    public enum Type
    {
        TRAP("TRAP", 1), 
        BASIC("BASIC", 0);
        
        private Type(final String llllllllllIlllIIIIlIllIlllIIIlll, final int llllllllllIlllIIIIlIllIlllIIIllI) {
        }
    }
}
