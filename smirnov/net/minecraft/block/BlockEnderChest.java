// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.stats.StatList;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumParticleTypes;
import java.util.Random;
import net.minecraft.util.Mirror;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockEnderChest extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB ENDER_CHEST_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlIllIlIlIIlIIllIllII) {
        return lllllllllllIlIllIlIlIIlIIllIllII.getValue((IProperty<EnumFacing>)BlockEnderChest.FACING).getIndex();
    }
    
    protected BlockEnderChest() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockEnderChest.FACING, EnumFacing.NORTH));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlIllIlIlIIlIlllIIIII) {
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIlIllIlIlIIlIllIllIlI) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    
    @Override
    public boolean func_190946_v(final IBlockState lllllllllllIlIllIlIlIIlIllIlllII) {
        return true;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIlIllIlIlIIlIIllIlIII, final Rotation lllllllllllIlIllIlIlIIlIIllIIlll) {
        return lllllllllllIlIllIlIlIIlIIllIlIII.withProperty((IProperty<Comparable>)BlockEnderChest.FACING, lllllllllllIlIllIlIlIIlIIllIIlll.rotate(lllllllllllIlIllIlIlIIlIIllIlIII.getValue((IProperty<EnumFacing>)BlockEnderChest.FACING)));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlIllIlIlIIlIlllIIlII, final IBlockAccess lllllllllllIlIllIlIlIIlIlllIIIll, final BlockPos lllllllllllIlIllIlIlIIlIlllIIIlI) {
        return BlockEnderChest.ENDER_CHEST_AABB;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllIlIllIlIlIIlIlIlllIll, final BlockPos lllllllllllIlIllIlIlIIlIlIlllIlI, final IBlockState lllllllllllIlIllIlIlIIlIlIlllIIl, final EntityLivingBase lllllllllllIlIllIlIlIIlIlIllllIl, final ItemStack lllllllllllIlIllIlIlIIlIlIllllII) {
        lllllllllllIlIllIlIlIIlIlIlllIll.setBlockState(lllllllllllIlIllIlIlIIlIlIlllIlI, lllllllllllIlIllIlIlIIlIlIlllIIl.withProperty((IProperty<Comparable>)BlockEnderChest.FACING, lllllllllllIlIllIlIlIIlIlIllllIl.getHorizontalFacing().getOpposite()), 2);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIlIllIlIlIIlIIlIlllll, final Mirror lllllllllllIlIllIlIlIIlIIllIIIII) {
        return lllllllllllIlIllIlIlIIlIIlIlllll.withRotation(lllllllllllIlIllIlIlIIlIIllIIIII.toRotation(lllllllllllIlIllIlIlIIlIIlIlllll.getValue((IProperty<EnumFacing>)BlockEnderChest.FACING)));
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        ENDER_CHEST_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.875, 0.9375);
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlIllIlIlIIlIlIIlIIIl, final World lllllllllllIlIllIlIlIIlIlIIlIIII, final BlockPos lllllllllllIlIllIlIlIIlIlIIIIIIl, final Random lllllllllllIlIllIlIlIIlIlIIIIIII) {
        for (int lllllllllllIlIllIlIlIIlIlIIIllIl = 0; lllllllllllIlIllIlIlIIlIlIIIllIl < 3; ++lllllllllllIlIllIlIlIIlIlIIIllIl) {
            final int lllllllllllIlIllIlIlIIlIlIIIllII = lllllllllllIlIllIlIlIIlIlIIIIIII.nextInt(2) * 2 - 1;
            final int lllllllllllIlIllIlIlIIlIlIIIlIll = lllllllllllIlIllIlIlIIlIlIIIIIII.nextInt(2) * 2 - 1;
            final double lllllllllllIlIllIlIlIIlIlIIIlIlI = lllllllllllIlIllIlIlIIlIlIIIIIIl.getX() + 0.5 + 0.25 * lllllllllllIlIllIlIlIIlIlIIIllII;
            final double lllllllllllIlIllIlIlIIlIlIIIlIIl = lllllllllllIlIllIlIlIIlIlIIIIIIl.getY() + lllllllllllIlIllIlIlIIlIlIIIIIII.nextFloat();
            final double lllllllllllIlIllIlIlIIlIlIIIlIII = lllllllllllIlIllIlIlIIlIlIIIIIIl.getZ() + 0.5 + 0.25 * lllllllllllIlIllIlIlIIlIlIIIlIll;
            final double lllllllllllIlIllIlIlIIlIlIIIIlll = lllllllllllIlIllIlIlIIlIlIIIIIII.nextFloat() * lllllllllllIlIllIlIlIIlIlIIIllII;
            final double lllllllllllIlIllIlIlIIlIlIIIIllI = (lllllllllllIlIllIlIlIIlIlIIIIIII.nextFloat() - 0.5) * 0.125;
            final double lllllllllllIlIllIlIlIIlIlIIIIlIl = lllllllllllIlIllIlIlIIlIlIIIIIII.nextFloat() * lllllllllllIlIllIlIlIIlIlIIIlIll;
            lllllllllllIlIllIlIlIIlIlIIlIIII.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllIlIllIlIlIIlIlIIIlIlI, lllllllllllIlIllIlIlIIlIlIIIlIIl, lllllllllllIlIllIlIlIIlIlIIIlIII, lllllllllllIlIllIlIlIIlIlIIIIlll, lllllllllllIlIllIlIlIIlIlIIIIllI, lllllllllllIlIllIlIlIIlIlIIIIlIl, new int[0]);
        }
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlIllIlIlIIlIIlllIIIl) {
        EnumFacing lllllllllllIlIllIlIlIIlIIlllIIll = EnumFacing.getFront(lllllllllllIlIllIlIlIIlIIlllIIIl);
        if (lllllllllllIlIllIlIlIIlIIlllIIll.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllIlIllIlIlIIlIIlllIIll = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEnderChest.FACING, lllllllllllIlIllIlIlIIlIIlllIIll);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIlIllIlIlIIlIllIIllll, final BlockPos lllllllllllIlIllIlIlIIlIllIIlllI, final EnumFacing lllllllllllIlIllIlIlIIlIllIIllIl, final float lllllllllllIlIllIlIlIIlIllIIllII, final float lllllllllllIlIllIlIlIIlIllIIlIll, final float lllllllllllIlIllIlIlIIlIllIIlIlI, final int lllllllllllIlIllIlIlIIlIllIIlIIl, final EntityLivingBase lllllllllllIlIllIlIlIIlIllIIIllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEnderChest.FACING, lllllllllllIlIllIlIlIIlIllIIIllI.getHorizontalFacing().getOpposite());
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockEnderChest.FACING });
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIllIlIlIIlIllIllllI) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIllIlIlIIlIIlIllIIl, final IBlockState lllllllllllIlIllIlIlIIlIIlIllIII, final BlockPos lllllllllllIlIllIlIlIIlIIlIlIlll, final EnumFacing lllllllllllIlIllIlIlIIlIIlIlIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIlIllIlIlIIlIlIlIIIII, final int lllllllllllIlIllIlIlIIlIlIIlllll) {
        return new TileEntityEnderChest();
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIlIllIlIlIIlIllIlIlII) {
        return 8;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIlIllIlIlIIlIlIllIIIl, final BlockPos lllllllllllIlIllIlIlIIlIlIlIIlIl, final IBlockState lllllllllllIlIllIlIlIIlIlIlIllll, final EntityPlayer lllllllllllIlIllIlIlIIlIlIlIlllI, final EnumHand lllllllllllIlIllIlIlIIlIlIlIllIl, final EnumFacing lllllllllllIlIllIlIlIIlIlIlIllII, final float lllllllllllIlIllIlIlIIlIlIlIlIll, final float lllllllllllIlIllIlIlIIlIlIlIlIlI, final float lllllllllllIlIllIlIlIIlIlIlIlIIl) {
        final InventoryEnderChest lllllllllllIlIllIlIlIIlIlIlIlIII = lllllllllllIlIllIlIlIIlIlIlIlllI.getInventoryEnderChest();
        final TileEntity lllllllllllIlIllIlIlIIlIlIlIIlll = lllllllllllIlIllIlIlIIlIlIllIIIl.getTileEntity(lllllllllllIlIllIlIlIIlIlIlIIlIl);
        if (lllllllllllIlIllIlIlIIlIlIlIlIII == null || !(lllllllllllIlIllIlIlIIlIlIlIIlll instanceof TileEntityEnderChest)) {
            return true;
        }
        if (lllllllllllIlIllIlIlIIlIlIllIIIl.getBlockState(lllllllllllIlIllIlIlIIlIlIlIIlIl.up()).isNormalCube()) {
            return true;
        }
        if (lllllllllllIlIllIlIlIIlIlIllIIIl.isRemote) {
            return true;
        }
        lllllllllllIlIllIlIlIIlIlIlIlIII.setChestTileEntity((TileEntityEnderChest)lllllllllllIlIllIlIlIIlIlIlIIlll);
        lllllllllllIlIllIlIlIIlIlIlIlllI.displayGUIChest(lllllllllllIlIllIlIlIIlIlIlIlIII);
        lllllllllllIlIllIlIlIIlIlIlIlllI.addStat(StatList.ENDERCHEST_OPENED);
        return true;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIlIllIlIlIIlIllIllIII, final Random lllllllllllIlIllIlIlIIlIllIlIlll, final int lllllllllllIlIllIlIlIIlIllIlIllI) {
        return Item.getItemFromBlock(Blocks.OBSIDIAN);
    }
}
