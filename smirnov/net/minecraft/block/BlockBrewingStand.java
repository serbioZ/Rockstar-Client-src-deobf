// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.inventory.InventoryHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.stats.StatList;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.inventory.Container;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockBrewingStand extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB STICK_AABB;
    public static final /* synthetic */ PropertyBool[] HAS_BOTTLE;
    protected static final /* synthetic */ AxisAlignedBB BASE_AABB;
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBrewingStand.HAS_BOTTLE[0], BlockBrewingStand.HAS_BOTTLE[1], BlockBrewingStand.HAS_BOTTLE[2] });
    }
    
    public BlockBrewingStand() {
        super(Material.IRON);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[0], false).withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[1], false).withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[2], false));
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllIlIIIIIIlIlIIllIIIlIl, final World lllllllllllIlIIIIIIlIlIIllIIIlII, final BlockPos lllllllllllIlIIIIIIlIlIIlIlllllI, final AxisAlignedBB lllllllllllIlIIIIIIlIlIIllIIIIlI, final List<AxisAlignedBB> lllllllllllIlIIIIIIlIlIIlIllllII, @Nullable final Entity lllllllllllIlIIIIIIlIlIIllIIIIII, final boolean lllllllllllIlIIIIIIlIlIIlIllllll) {
        Block.addCollisionBoxToList(lllllllllllIlIIIIIIlIlIIlIlllllI, lllllllllllIlIIIIIIlIlIIllIIIIlI, lllllllllllIlIIIIIIlIlIIlIllllII, BlockBrewingStand.STICK_AABB);
        Block.addCollisionBoxToList(lllllllllllIlIIIIIIlIlIIlIlllllI, lllllllllllIlIIIIIIlIlIIllIIIIlI, lllllllllllIlIIIIIIlIlIIlIllllII, BlockBrewingStand.BASE_AABB);
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllIlIIIIIIlIlIIIllIIlIl, final World lllllllllllIlIIIIIIlIlIIIllIIlII, final BlockPos lllllllllllIlIIIIIIlIlIIIllIIIIl) {
        return Container.calcRedstone(lllllllllllIlIIIIIIlIlIIIllIIlII.getTileEntity(lllllllllllIlIIIIIIlIlIIIllIIIIl));
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.brewingStand.name");
    }
    
    static {
        HAS_BOTTLE = new PropertyBool[] { PropertyBool.create("has_bottle_0"), PropertyBool.create("has_bottle_1"), PropertyBool.create("has_bottle_2") };
        BASE_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
        STICK_AABB = new AxisAlignedBB(0.4375, 0.0, 0.4375, 0.5625, 0.875, 0.5625);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIlIIIIIIlIlIIIllIllIl, final BlockPos lllllllllllIlIIIIIIlIlIIIllIllII, final IBlockState lllllllllllIlIIIIIIlIlIIIllIlIll) {
        return new ItemStack(Items.BREWING_STAND);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIIIIIIlIlIIIlIIIlIl, final IBlockState lllllllllllIlIIIIIIlIlIIIlIIIlII, final BlockPos lllllllllllIlIIIIIIlIlIIIlIIIIll, final EnumFacing lllllllllllIlIIIIIIlIlIIIlIIIIlI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllIlIIIIIIlIlIIIllIlIIl) {
        return true;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlIIIIIIlIlIIIlIllIlI) {
        IBlockState lllllllllllIlIIIIIIlIlIIIlIllIIl = this.getDefaultState();
        for (int lllllllllllIlIIIIIIlIlIIIlIllIII = 0; lllllllllllIlIIIIIIlIlIIIlIllIII < 3; ++lllllllllllIlIIIIIIlIlIIIlIllIII) {
            lllllllllllIlIIIIIIlIlIIIlIllIIl = lllllllllllIlIIIIIIlIlIIIlIllIIl.withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[lllllllllllIlIIIIIIlIlIIIlIllIII], (lllllllllllIlIIIIIIlIlIIIlIllIlI & 1 << lllllllllllIlIIIIIIlIlIIIlIllIII) > 0);
        }
        return lllllllllllIlIIIIIIlIlIIIlIllIIl;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIlIIIIIIlIlIIIlllIIIl, final Random lllllllllllIlIIIIIIlIlIIIlllIIII, final int lllllllllllIlIIIIIIlIlIIIllIllll) {
        return Items.BREWING_STAND;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIlIIIIIIlIlIIllIIllll) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIIIIIIlIlIIllIIlIlI) {
        return false;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlIIIIIIlIlIIlIIIlllI, final World lllllllllllIlIIIIIIlIlIIlIIIllIl, final BlockPos lllllllllllIlIIIIIIlIlIIlIIIIllI, final Random lllllllllllIlIIIIIIlIlIIlIIIlIll) {
        final double lllllllllllIlIIIIIIlIlIIlIIIlIlI = lllllllllllIlIIIIIIlIlIIlIIIIllI.getX() + 0.4f + lllllllllllIlIIIIIIlIlIIlIIIlIll.nextFloat() * 0.2f;
        final double lllllllllllIlIIIIIIlIlIIlIIIlIIl = lllllllllllIlIIIIIIlIlIIlIIIIllI.getY() + 0.7f + lllllllllllIlIIIIIIlIlIIlIIIlIll.nextFloat() * 0.3f;
        final double lllllllllllIlIIIIIIlIlIIlIIIlIII = lllllllllllIlIIIIIIlIlIIlIIIIllI.getZ() + 0.4f + lllllllllllIlIIIIIIlIlIIlIIIlIll.nextFloat() * 0.2f;
        lllllllllllIlIIIIIIlIlIIlIIIllIl.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllIlIIIIIIlIlIIlIIIlIlI, lllllllllllIlIIIIIIlIlIIlIIIlIIl, lllllllllllIlIIIIIIlIlIIlIIIlIII, 0.0, 0.0, 0.0, new int[0]);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIlIIIIIIlIlIIllIIllIl, final int lllllllllllIlIIIIIIlIlIIllIIllII) {
        return new TileEntityBrewingStand();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlIIIIIIlIlIIlIlllIlI, final IBlockAccess lllllllllllIlIIIIIIlIlIIlIlllIIl, final BlockPos lllllllllllIlIIIIIIlIlIIlIlllIII) {
        return BlockBrewingStand.BASE_AABB;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlIIIIIIlIlIIllIlIIIl) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIlIIIIIIlIlIIlIlIlIII, final BlockPos lllllllllllIlIIIIIIlIlIIlIlIIlll, final IBlockState lllllllllllIlIIIIIIlIlIIlIllIIII, final EntityPlayer lllllllllllIlIIIIIIlIlIIlIlIIllI, final EnumHand lllllllllllIlIIIIIIlIlIIlIlIlllI, final EnumFacing lllllllllllIlIIIIIIlIlIIlIlIllIl, final float lllllllllllIlIIIIIIlIlIIlIlIllII, final float lllllllllllIlIIIIIIlIlIIlIlIlIll, final float lllllllllllIlIIIIIIlIlIIlIlIlIlI) {
        if (lllllllllllIlIIIIIIlIlIIlIlIlIII.isRemote) {
            return true;
        }
        final TileEntity lllllllllllIlIIIIIIlIlIIlIlIlIIl = lllllllllllIlIIIIIIlIlIIlIlIlIII.getTileEntity(lllllllllllIlIIIIIIlIlIIlIlIIlll);
        if (lllllllllllIlIIIIIIlIlIIlIlIlIIl instanceof TileEntityBrewingStand) {
            lllllllllllIlIIIIIIlIlIIlIlIIllI.displayGUIChest((IInventory)lllllllllllIlIIIIIIlIlIIlIlIlIIl);
            lllllllllllIlIIIIIIlIlIIlIlIIllI.addStat(StatList.BREWINGSTAND_INTERACTION);
        }
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlIIIIIIlIlIIIlIIllll) {
        int lllllllllllIlIIIIIIlIlIIIlIIlllI = 0;
        for (int lllllllllllIlIIIIIIlIlIIIlIIllIl = 0; lllllllllllIlIIIIIIlIlIIIlIIllIl < 3; ++lllllllllllIlIIIIIIlIlIIIlIIllIl) {
            if (lllllllllllIlIIIIIIlIlIIIlIIllll.getValue((IProperty<Boolean>)BlockBrewingStand.HAS_BOTTLE[lllllllllllIlIIIIIIlIlIIIlIIllIl])) {
                lllllllllllIlIIIIIIlIlIIIlIIlllI |= 1 << lllllllllllIlIIIIIIlIlIIIlIIllIl;
            }
        }
        return lllllllllllIlIIIIIIlIlIIIlIIlllI;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllIlIIIIIIlIlIIlIIlllll, final BlockPos lllllllllllIlIIIIIIlIlIIlIIllllI, final IBlockState lllllllllllIlIIIIIIlIlIIlIIlllIl, final EntityLivingBase lllllllllllIlIIIIIIlIlIIlIIlllII, final ItemStack lllllllllllIlIIIIIIlIlIIlIIlIlll) {
        if (lllllllllllIlIIIIIIlIlIIlIIlIlll.hasDisplayName()) {
            final TileEntity lllllllllllIlIIIIIIlIlIIlIIllIlI = lllllllllllIlIIIIIIlIlIIlIIlllll.getTileEntity(lllllllllllIlIIIIIIlIlIIlIIllllI);
            if (lllllllllllIlIIIIIIlIlIIlIIllIlI instanceof TileEntityBrewingStand) {
                ((TileEntityBrewingStand)lllllllllllIlIIIIIIlIlIIlIIllIlI).setName(lllllllllllIlIIIIIIlIlIIlIIlIlll.getDisplayName());
            }
        }
    }
    
    @Override
    public void breakBlock(final World lllllllllllIlIIIIIIlIlIIIlllIllI, final BlockPos lllllllllllIlIIIIIIlIlIIIllllIlI, final IBlockState lllllllllllIlIIIIIIlIlIIIlllIlII) {
        final TileEntity lllllllllllIlIIIIIIlIlIIIllllIII = lllllllllllIlIIIIIIlIlIIIlllIllI.getTileEntity(lllllllllllIlIIIIIIlIlIIIllllIlI);
        if (lllllllllllIlIIIIIIlIlIIIllllIII instanceof TileEntityBrewingStand) {
            InventoryHelper.dropInventoryItems(lllllllllllIlIIIIIIlIlIIIlllIllI, lllllllllllIlIIIIIIlIlIIIllllIlI, (IInventory)lllllllllllIlIIIIIIlIlIIIllllIII);
        }
        super.breakBlock(lllllllllllIlIIIIIIlIlIIIlllIllI, lllllllllllIlIIIIIIlIlIIIllllIlI, lllllllllllIlIIIIIIlIlIIIlllIlII);
    }
}
