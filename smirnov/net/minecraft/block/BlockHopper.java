// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.state.BlockStateContainer;
import com.google.common.base.Predicate;
import net.minecraft.inventory.Container;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Mirror;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.Rotation;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.block.properties.IProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockHopper extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    public static final /* synthetic */ PropertyBool ENABLED;
    protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB BASE_AABB;
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIllIIlllIIIIIlIlIIllI, final IBlockState lllllllllllIllIIlllIIIIIlIlIIlIl, final BlockPos lllllllllllIllIIlllIIIIIlIlIIlII, final EnumFacing lllllllllllIllIIlllIIIIIlIlIIIlI) {
        return (lllllllllllIllIIlllIIIIIlIlIIIlI == EnumFacing.UP) ? BlockFaceShape.BOWL : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllIllIIlllIIIIlIIlIllII) {
        return true;
    }
    
    @Override
    public void breakBlock(final World lllllllllllIllIIlllIIIIIlllIlIll, final BlockPos lllllllllllIllIIlllIIIIIlllIIlIl, final IBlockState lllllllllllIllIIlllIIIIIlllIIlII) {
        final TileEntity lllllllllllIllIIlllIIIIIlllIlIII = lllllllllllIllIIlllIIIIIlllIlIll.getTileEntity(lllllllllllIllIIlllIIIIIlllIIlIl);
        if (lllllllllllIllIIlllIIIIIlllIlIII instanceof TileEntityHopper) {
            InventoryHelper.dropInventoryItems(lllllllllllIllIIlllIIIIIlllIlIll, lllllllllllIllIIlllIIIIIlllIIlIl, (IInventory)lllllllllllIllIIlllIIIIIlllIlIII);
            lllllllllllIllIIlllIIIIIlllIlIll.updateComparatorOutputLevel(lllllllllllIllIIlllIIIIIlllIIlIl, this);
        }
        super.breakBlock(lllllllllllIllIIlllIIIIIlllIlIll, lllllllllllIllIIlllIIIIIlllIIlIl, lllllllllllIllIIlllIIIIIlllIIlII);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIllIIlllIIIIIllIIIIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockHopper.FACING, getFacing(lllllllllllIllIIlllIIIIIllIIIIll)).withProperty((IProperty<Comparable>)BlockHopper.ENABLED, isEnabled(lllllllllllIllIIlllIIIIIllIIIIll));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIllIIlllIIIIlIllIIllI, final IBlockAccess lllllllllllIllIIlllIIIIlIllIIlIl, final BlockPos lllllllllllIllIIlllIIIIlIllIIlII) {
        return BlockHopper.FULL_BLOCK_AABB;
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllIllIIlllIIIIlIlIlllll, final World lllllllllllIllIIlllIIIIlIlIllllI, final BlockPos lllllllllllIllIIlllIIIIlIlIlllIl, final AxisAlignedBB lllllllllllIllIIlllIIIIlIlIlllII, final List<AxisAlignedBB> lllllllllllIllIIlllIIIIlIlIllIll, @Nullable final Entity lllllllllllIllIIlllIIIIlIlIllIlI, final boolean lllllllllllIllIIlllIIIIlIlIllIIl) {
        Block.addCollisionBoxToList(lllllllllllIllIIlllIIIIlIlIlllIl, lllllllllllIllIIlllIIIIlIlIlllII, lllllllllllIllIIlllIIIIlIlIllIll, BlockHopper.BASE_AABB);
        Block.addCollisionBoxToList(lllllllllllIllIIlllIIIIlIlIlllIl, lllllllllllIllIIlllIIIIlIlIlllII, lllllllllllIllIIlllIIIIlIlIllIll, BlockHopper.EAST_AABB);
        Block.addCollisionBoxToList(lllllllllllIllIIlllIIIIlIlIlllIl, lllllllllllIllIIlllIIIIlIlIlllII, lllllllllllIllIIlllIIIIlIlIllIll, BlockHopper.WEST_AABB);
        Block.addCollisionBoxToList(lllllllllllIllIIlllIIIIlIlIlllIl, lllllllllllIllIIlllIIIIlIlIlllII, lllllllllllIllIIlllIIIIlIlIllIll, BlockHopper.SOUTH_AABB);
        Block.addCollisionBoxToList(lllllllllllIllIIlllIIIIlIlIlllIl, lllllllllllIllIIlllIIIIlIlIlllII, lllllllllllIllIIlllIIIIlIlIllIll, BlockHopper.NORTH_AABB);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIllIIlllIIIIIlIllIlII, final Rotation lllllllllllIllIIlllIIIIIlIllIlIl) {
        return lllllllllllIllIIlllIIIIIlIllIlII.withProperty((IProperty<Comparable>)BlockHopper.FACING, lllllllllllIllIIlllIIIIIlIllIlIl.rotate(lllllllllllIllIIlllIIIIIlIllIlII.getValue((IProperty<EnumFacing>)BlockHopper.FACING)));
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllIllIIlllIIIIIllIlIIII) {
        return true;
    }
    
    public BlockHopper() {
        super(Material.IRON, MapColor.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockHopper.FACING, EnumFacing.DOWN).withProperty((IProperty<Comparable>)BlockHopper.ENABLED, true));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIllIIlllIIIIlIlIlIIIl, final BlockPos lllllllllllIllIIlllIIIIlIlIlIIII, final EnumFacing lllllllllllIllIIlllIIIIlIlIIllll, final float lllllllllllIllIIlllIIIIlIlIIlllI, final float lllllllllllIllIIlllIIIIlIlIIllIl, final float lllllllllllIllIIlllIIIIlIlIIllII, final int lllllllllllIllIIlllIIIIlIlIIlIll, final EntityLivingBase lllllllllllIllIIlllIIIIlIlIIlIlI) {
        EnumFacing lllllllllllIllIIlllIIIIlIlIIlIIl = lllllllllllIllIIlllIIIIlIlIIllll.getOpposite();
        if (lllllllllllIllIIlllIIIIlIlIIlIIl == EnumFacing.UP) {
            lllllllllllIllIIlllIIIIlIlIIlIIl = EnumFacing.DOWN;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockHopper.FACING, lllllllllllIllIIlllIIIIlIlIIlIIl).withProperty((IProperty<Comparable>)BlockHopper.ENABLED, true);
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllIllIIlllIIIIlIIllIIll, final BlockPos lllllllllllIllIIlllIIIIlIIllIIlI, final IBlockState lllllllllllIllIIlllIIIIlIIlllIII, final EntityLivingBase lllllllllllIllIIlllIIIIlIIllIIII, final ItemStack lllllllllllIllIIlllIIIIlIIllIllI) {
        super.onBlockPlacedBy(lllllllllllIllIIlllIIIIlIIllIIll, lllllllllllIllIIlllIIIIlIIllIIlI, lllllllllllIllIIlllIIIIlIIlllIII, lllllllllllIllIIlllIIIIlIIllIIII, lllllllllllIllIIlllIIIIlIIllIllI);
        if (lllllllllllIllIIlllIIIIlIIllIllI.hasDisplayName()) {
            final TileEntity lllllllllllIllIIlllIIIIlIIllIlIl = lllllllllllIllIIlllIIIIlIIllIIll.getTileEntity(lllllllllllIllIIlllIIIIlIIllIIlI);
            if (lllllllllllIllIIlllIIIIlIIllIlIl instanceof TileEntityHopper) {
                ((TileEntityHopper)lllllllllllIllIIlllIIIIlIIllIlIl).func_190575_a(lllllllllllIllIIlllIIIIlIIllIllI.getDisplayName());
            }
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIllIIlllIIIIIlIlIllIl, final Mirror lllllllllllIllIIlllIIIIIlIlIlllI) {
        return lllllllllllIllIIlllIIIIIlIlIllIl.withRotation(lllllllllllIllIIlllIIIIIlIlIlllI.toRotation(lllllllllllIllIIlllIIIIIlIlIllIl.getValue((IProperty<EnumFacing>)BlockHopper.FACING)));
    }
    
    public static EnumFacing getFacing(final int lllllllllllIllIIlllIIIIIllIlIllI) {
        return EnumFacing.getFront(lllllllllllIllIIlllIIIIIllIlIllI & 0x7);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    
    public static boolean isEnabled(final int lllllllllllIllIIlllIIIIIllIlIIlI) {
        return (lllllllllllIllIIlllIIIIIllIlIIlI & 0x8) != 0x8;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIllIIlllIIIIIllIlllIl) {
        return false;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllIllIIlllIIIIIllIIllII, final World lllllllllllIllIIlllIIIIIllIIlIll, final BlockPos lllllllllllIllIIlllIIIIIllIIlIII) {
        return Container.calcRedstone(lllllllllllIllIIlllIIIIIllIIlIll.getTileEntity(lllllllllllIllIIlllIIIIIllIIlIII));
    }
    
    static {
        FACING = PropertyDirection.create("facing", (Predicate<EnumFacing>)new Predicate<EnumFacing>() {
            public boolean apply(@Nullable final EnumFacing lllllllllllIIIlIIlIIlllIlIIlIlIl) {
                return lllllllllllIIIlIIlIIlllIlIIlIlIl != EnumFacing.UP;
            }
        });
        ENABLED = PropertyBool.create("enabled");
        BASE_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.625, 1.0);
        SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.125);
        NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.875, 1.0, 1.0, 1.0);
        WEST_AABB = new AxisAlignedBB(0.875, 0.0, 0.0, 1.0, 1.0, 1.0);
        EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.125, 1.0, 1.0);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockHopper.FACING, BlockHopper.ENABLED });
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIllIIlllIIIIIlIlllIll) {
        int lllllllllllIllIIlllIIIIIlIllllII = 0;
        lllllllllllIllIIlllIIIIIlIllllII |= lllllllllllIllIIlllIIIIIlIlllIll.getValue((IProperty<EnumFacing>)BlockHopper.FACING).getIndex();
        if (!lllllllllllIllIIlllIIIIIlIlllIll.getValue((IProperty<Boolean>)BlockHopper.ENABLED)) {
            lllllllllllIllIIlllIIIIIlIllllII |= 0x8;
        }
        return lllllllllllIllIIlllIIIIIlIllllII;
    }
    
    private void updateState(final World lllllllllllIllIIlllIIIIIlllllIIl, final BlockPos lllllllllllIllIIlllIIIIIllllIlII, final IBlockState lllllllllllIllIIlllIIIIIllllIIll) {
        final boolean lllllllllllIllIIlllIIIIIllllIllI = !lllllllllllIllIIlllIIIIIlllllIIl.isBlockPowered(lllllllllllIllIIlllIIIIIllllIlII);
        if (lllllllllllIllIIlllIIIIIllllIllI != lllllllllllIllIIlllIIIIIllllIIll.getValue((IProperty<Boolean>)BlockHopper.ENABLED)) {
            lllllllllllIllIIlllIIIIIlllllIIl.setBlockState(lllllllllllIllIIlllIIIIIllllIlII, lllllllllllIllIIlllIIIIIllllIIll.withProperty((IProperty<Comparable>)BlockHopper.ENABLED, lllllllllllIllIIlllIIIIIllllIllI), 4);
        }
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIllIIlllIIIIIlllIIIIl) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIllIIlllIIIIlIIIIIIIl, final World lllllllllllIllIIlllIIIIlIIIIIllI, final BlockPos lllllllllllIllIIlllIIIIlIIIIIlIl, final Block lllllllllllIllIIlllIIIIlIIIIIlII, final BlockPos lllllllllllIllIIlllIIIIlIIIIIIll) {
        this.updateState(lllllllllllIllIIlllIIIIlIIIIIllI, lllllllllllIllIIlllIIIIlIIIIIlIl, lllllllllllIllIIlllIIIIlIIIIIIIl);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIllIIlllIIIIlIlIIIlII, final int lllllllllllIllIIlllIIIIlIlIIIIll) {
        return new TileEntityHopper();
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIllIIlllIIIIIllIllIll, final IBlockAccess lllllllllllIllIIlllIIIIIllIllIlI, final BlockPos lllllllllllIllIIlllIIIIIllIllIIl, final EnumFacing lllllllllllIllIIlllIIIIIllIllIII) {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIllIIlllIIIIlIIIllIlI, final BlockPos lllllllllllIllIIlllIIIIlIIIllIIl, final IBlockState lllllllllllIllIIlllIIIIlIIIllIII, final EntityPlayer lllllllllllIllIIlllIIIIlIIIIlllI, final EnumHand lllllllllllIllIIlllIIIIlIIIlIllI, final EnumFacing lllllllllllIllIIlllIIIIlIIIlIlIl, final float lllllllllllIllIIlllIIIIlIIIlIlII, final float lllllllllllIllIIlllIIIIlIIIlIIll, final float lllllllllllIllIIlllIIIIlIIIlIIlI) {
        if (lllllllllllIllIIlllIIIIlIIIllIlI.isRemote) {
            return true;
        }
        final TileEntity lllllllllllIllIIlllIIIIlIIIlIIIl = lllllllllllIllIIlllIIIIlIIIllIlI.getTileEntity(lllllllllllIllIIlllIIIIlIIIllIIl);
        if (lllllllllllIllIIlllIIIIlIIIlIIIl instanceof TileEntityHopper) {
            lllllllllllIllIIlllIIIIlIIIIlllI.displayGUIChest((IInventory)lllllllllllIllIIlllIIIIlIIIlIIIl);
            lllllllllllIllIIlllIIIIlIIIIlllI.addStat(StatList.HOPPER_INSPECTED);
        }
        return true;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIllIIlllIIIIlIIlIIIlI, final BlockPos lllllllllllIllIIlllIIIIlIIlIIIIl, final IBlockState lllllllllllIllIIlllIIIIlIIlIIlII) {
        this.updateState(lllllllllllIllIIlllIIIIlIIlIIIlI, lllllllllllIllIIlllIIIIlIIlIIIIl, lllllllllllIllIIlllIIIIlIIlIIlII);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIllIIlllIIIIIllIlllll) {
        return false;
    }
}
