// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import java.util.Random;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemArmor;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.PotionUtils;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.MathHelper;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockCauldron extends Block
{
    protected static final /* synthetic */ AxisAlignedBB AABB_LEGS;
    protected static final /* synthetic */ AxisAlignedBB AABB_WALL_EAST;
    protected static final /* synthetic */ AxisAlignedBB AABB_WALL_SOUTH;
    public static final /* synthetic */ PropertyInteger LEVEL;
    protected static final /* synthetic */ AxisAlignedBB AABB_WALL_NORTH;
    protected static final /* synthetic */ AxisAlignedBB AABB_WALL_WEST;
    
    @Override
    public ItemStack getItem(final World lllllllllllIIlIlIlIIlllIlllllIII, final BlockPos lllllllllllIIlIlIlIIlllIllllIlll, final IBlockState lllllllllllIIlIlIlIIlllIllllIllI) {
        return new ItemStack(Items.CAULDRON);
    }
    
    @Override
    public void fillWithRain(final World lllllllllllIIlIlIlIIllllIIIIIIIl, final BlockPos lllllllllllIIlIlIlIIllllIIIIIlII) {
        if (lllllllllllIIlIlIlIIllllIIIIIIIl.rand.nextInt(20) == 1) {
            final float lllllllllllIIlIlIlIIllllIIIIIIll = lllllllllllIIlIlIlIIllllIIIIIIIl.getBiome(lllllllllllIIlIlIlIIllllIIIIIlII).getFloatTemperature(lllllllllllIIlIlIlIIllllIIIIIlII);
            if (lllllllllllIIlIlIlIIllllIIIIIIIl.getBiomeProvider().getTemperatureAtHeight(lllllllllllIIlIlIlIIllllIIIIIIll, lllllllllllIIlIlIlIIllllIIIIIlII.getY()) >= 0.15f) {
                final IBlockState lllllllllllIIlIlIlIIllllIIIIIIlI = lllllllllllIIlIlIlIIllllIIIIIIIl.getBlockState(lllllllllllIIlIlIlIIllllIIIIIlII);
                if (lllllllllllIIlIlIlIIllllIIIIIIlI.getValue((IProperty<Integer>)BlockCauldron.LEVEL) < 3) {
                    lllllllllllIIlIlIlIIllllIIIIIIIl.setBlockState(lllllllllllIIlIlIlIIllllIIIIIlII, lllllllllllIIlIlIlIIllllIIIIIIlI.cycleProperty((IProperty<Comparable>)BlockCauldron.LEVEL), 2);
                }
            }
        }
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllIIlIlIlIIllllIllIIlIl, final World lllllllllllIIlIlIlIIllllIllIIlII, final BlockPos lllllllllllIIlIlIlIIllllIllIIIll, final AxisAlignedBB lllllllllllIIlIlIlIIllllIlIlllIl, final List<AxisAlignedBB> lllllllllllIIlIlIlIIllllIllIIIIl, @Nullable final Entity lllllllllllIIlIlIlIIllllIllIIIII, final boolean lllllllllllIIlIlIlIIllllIlIlllll) {
        Block.addCollisionBoxToList(lllllllllllIIlIlIlIIllllIllIIIll, lllllllllllIIlIlIlIIllllIlIlllIl, lllllllllllIIlIlIlIIllllIllIIIIl, BlockCauldron.AABB_LEGS);
        Block.addCollisionBoxToList(lllllllllllIIlIlIlIIllllIllIIIll, lllllllllllIIlIlIlIIllllIlIlllIl, lllllllllllIIlIlIlIIllllIllIIIIl, BlockCauldron.AABB_WALL_WEST);
        Block.addCollisionBoxToList(lllllllllllIIlIlIlIIllllIllIIIll, lllllllllllIIlIlIlIIllllIlIlllIl, lllllllllllIIlIlIlIIllllIllIIIIl, BlockCauldron.AABB_WALL_NORTH);
        Block.addCollisionBoxToList(lllllllllllIIlIlIlIIllllIllIIIll, lllllllllllIIlIlIlIIllllIlIlllIl, lllllllllllIIlIlIlIIllllIllIIIIl, BlockCauldron.AABB_WALL_EAST);
        Block.addCollisionBoxToList(lllllllllllIIlIlIlIIllllIllIIIll, lllllllllllIIlIlIlIIllllIlIlllIl, lllllllllllIIlIlIlIIllllIllIIIIl, BlockCauldron.AABB_WALL_SOUTH);
    }
    
    public void setWaterLevel(final World lllllllllllIIlIlIlIIllllIIIIlllI, final BlockPos lllllllllllIIlIlIlIIllllIIIIllIl, final IBlockState lllllllllllIIlIlIlIIllllIIIIllII, final int lllllllllllIIlIlIlIIllllIIIIlIll) {
        lllllllllllIIlIlIlIIllllIIIIlllI.setBlockState(lllllllllllIIlIlIlIIllllIIIIllIl, lllllllllllIIlIlIlIIllllIIIIllII.withProperty((IProperty<Comparable>)BlockCauldron.LEVEL, MathHelper.clamp(lllllllllllIIlIlIlIIllllIIIIlIll, 0, 3)), 2);
        lllllllllllIIlIlIlIIllllIIIIlllI.updateComparatorOutputLevel(lllllllllllIIlIlIlIIllllIIIIllIl, this);
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllIIlIlIlIIlllIllllIlII) {
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIlIlIlIIlllIllIllIll, final IBlockState lllllllllllIIlIlIlIIlllIllIllIlI, final BlockPos lllllllllllIIlIlIlIIlllIllIllIIl, final EnumFacing lllllllllllIIlIlIlIIlllIllIlIlll) {
        if (lllllllllllIIlIlIlIIlllIllIlIlll == EnumFacing.UP) {
            return BlockFaceShape.BOWL;
        }
        return (lllllllllllIIlIlIlIIlllIllIlIlll == EnumFacing.DOWN) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
    }
    
    static {
        LEVEL = PropertyInteger.create("level", 0, 3);
        AABB_LEGS = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0);
        AABB_WALL_NORTH = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.125);
        AABB_WALL_SOUTH = new AxisAlignedBB(0.0, 0.0, 0.875, 1.0, 1.0, 1.0);
        AABB_WALL_EAST = new AxisAlignedBB(0.875, 0.0, 0.0, 1.0, 1.0, 1.0);
        AABB_WALL_WEST = new AxisAlignedBB(0.0, 0.0, 0.0, 0.125, 1.0, 1.0);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCauldron.LEVEL });
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIlIlIlIIllllIlIlIllI) {
        return false;
    }
    
    public BlockCauldron() {
        super(Material.IRON, MapColor.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCauldron.LEVEL, 0));
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIIlIlIlIIllllIIllIIll, final BlockPos lllllllllllIIlIlIlIIllllIIlIIIIl, final IBlockState lllllllllllIIlIlIlIIllllIIllIIIl, final EntityPlayer lllllllllllIIlIlIlIIllllIIllIIII, final EnumHand lllllllllllIIlIlIlIIllllIIIllllI, final EnumFacing lllllllllllIIlIlIlIIllllIIlIlllI, final float lllllllllllIIlIlIlIIllllIIlIllIl, final float lllllllllllIIlIlIlIIllllIIlIllII, final float lllllllllllIIlIlIlIIllllIIlIlIll) {
        final ItemStack lllllllllllIIlIlIlIIllllIIlIlIlI = lllllllllllIIlIlIlIIllllIIllIIII.getHeldItem(lllllllllllIIlIlIlIIllllIIIllllI);
        if (lllllllllllIIlIlIlIIllllIIlIlIlI.func_190926_b()) {
            return true;
        }
        final int lllllllllllIIlIlIlIIllllIIlIlIIl = lllllllllllIIlIlIlIIllllIIllIIIl.getValue((IProperty<Integer>)BlockCauldron.LEVEL);
        final Item lllllllllllIIlIlIlIIllllIIlIlIII = lllllllllllIIlIlIlIIllllIIlIlIlI.getItem();
        if (lllllllllllIIlIlIlIIllllIIlIlIII == Items.WATER_BUCKET) {
            if (lllllllllllIIlIlIlIIllllIIlIlIIl < 3 && !lllllllllllIIlIlIlIIllllIIllIIll.isRemote) {
                if (!lllllllllllIIlIlIlIIllllIIllIIII.capabilities.isCreativeMode) {
                    lllllllllllIIlIlIlIIllllIIllIIII.setHeldItem(lllllllllllIIlIlIlIIllllIIIllllI, new ItemStack(Items.BUCKET));
                }
                lllllllllllIIlIlIlIIllllIIllIIII.addStat(StatList.CAULDRON_FILLED);
                this.setWaterLevel(lllllllllllIIlIlIlIIllllIIllIIll, lllllllllllIIlIlIlIIllllIIlIIIIl, lllllllllllIIlIlIlIIllllIIllIIIl, 3);
                lllllllllllIIlIlIlIIllllIIllIIll.playSound(null, lllllllllllIIlIlIlIIllllIIlIIIIl, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
            return true;
        }
        if (lllllllllllIIlIlIlIIllllIIlIlIII == Items.BUCKET) {
            if (lllllllllllIIlIlIlIIllllIIlIlIIl == 3 && !lllllllllllIIlIlIlIIllllIIllIIll.isRemote) {
                if (!lllllllllllIIlIlIlIIllllIIllIIII.capabilities.isCreativeMode) {
                    lllllllllllIIlIlIlIIllllIIlIlIlI.func_190918_g(1);
                    if (lllllllllllIIlIlIlIIllllIIlIlIlI.func_190926_b()) {
                        lllllllllllIIlIlIlIIllllIIllIIII.setHeldItem(lllllllllllIIlIlIlIIllllIIIllllI, new ItemStack(Items.WATER_BUCKET));
                    }
                    else if (!lllllllllllIIlIlIlIIllllIIllIIII.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
                        lllllllllllIIlIlIlIIllllIIllIIII.dropItem(new ItemStack(Items.WATER_BUCKET), false);
                    }
                }
                lllllllllllIIlIlIlIIllllIIllIIII.addStat(StatList.CAULDRON_USED);
                this.setWaterLevel(lllllllllllIIlIlIlIIllllIIllIIll, lllllllllllIIlIlIlIIllllIIlIIIIl, lllllllllllIIlIlIlIIllllIIllIIIl, 0);
                lllllllllllIIlIlIlIIllllIIllIIll.playSound(null, lllllllllllIIlIlIlIIllllIIlIIIIl, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
            return true;
        }
        if (lllllllllllIIlIlIlIIllllIIlIlIII == Items.GLASS_BOTTLE) {
            if (lllllllllllIIlIlIlIIllllIIlIlIIl > 0 && !lllllllllllIIlIlIlIIllllIIllIIll.isRemote) {
                if (!lllllllllllIIlIlIlIIllllIIllIIII.capabilities.isCreativeMode) {
                    final ItemStack lllllllllllIIlIlIlIIllllIIlIIlll = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
                    lllllllllllIIlIlIlIIllllIIllIIII.addStat(StatList.CAULDRON_USED);
                    lllllllllllIIlIlIlIIllllIIlIlIlI.func_190918_g(1);
                    if (lllllllllllIIlIlIlIIllllIIlIlIlI.func_190926_b()) {
                        lllllllllllIIlIlIlIIllllIIllIIII.setHeldItem(lllllllllllIIlIlIlIIllllIIIllllI, lllllllllllIIlIlIlIIllllIIlIIlll);
                    }
                    else if (!lllllllllllIIlIlIlIIllllIIllIIII.inventory.addItemStackToInventory(lllllllllllIIlIlIlIIllllIIlIIlll)) {
                        lllllllllllIIlIlIlIIllllIIllIIII.dropItem(lllllllllllIIlIlIlIIllllIIlIIlll, false);
                    }
                    else if (lllllllllllIIlIlIlIIllllIIllIIII instanceof EntityPlayerMP) {
                        ((EntityPlayerMP)lllllllllllIIlIlIlIIllllIIllIIII).sendContainerToPlayer(lllllllllllIIlIlIlIIllllIIllIIII.inventoryContainer);
                    }
                }
                lllllllllllIIlIlIlIIllllIIllIIll.playSound(null, lllllllllllIIlIlIlIIllllIIlIIIIl, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                this.setWaterLevel(lllllllllllIIlIlIlIIllllIIllIIll, lllllllllllIIlIlIlIIllllIIlIIIIl, lllllllllllIIlIlIlIIllllIIllIIIl, lllllllllllIIlIlIlIIllllIIlIlIIl - 1);
            }
            return true;
        }
        if (lllllllllllIIlIlIlIIllllIIlIlIII == Items.POTIONITEM && PotionUtils.getPotionFromItem(lllllllllllIIlIlIlIIllllIIlIlIlI) == PotionTypes.WATER) {
            if (lllllllllllIIlIlIlIIllllIIlIlIIl < 3 && !lllllllllllIIlIlIlIIllllIIllIIll.isRemote) {
                if (!lllllllllllIIlIlIlIIllllIIllIIII.capabilities.isCreativeMode) {
                    final ItemStack lllllllllllIIlIlIlIIllllIIlIIllI = new ItemStack(Items.GLASS_BOTTLE);
                    lllllllllllIIlIlIlIIllllIIllIIII.addStat(StatList.CAULDRON_USED);
                    lllllllllllIIlIlIlIIllllIIllIIII.setHeldItem(lllllllllllIIlIlIlIIllllIIIllllI, lllllllllllIIlIlIlIIllllIIlIIllI);
                    if (lllllllllllIIlIlIlIIllllIIllIIII instanceof EntityPlayerMP) {
                        ((EntityPlayerMP)lllllllllllIIlIlIlIIllllIIllIIII).sendContainerToPlayer(lllllllllllIIlIlIlIIllllIIllIIII.inventoryContainer);
                    }
                }
                lllllllllllIIlIlIlIIllllIIllIIll.playSound(null, lllllllllllIIlIlIlIIllllIIlIIIIl, SoundEvents.field_191241_J, SoundCategory.BLOCKS, 1.0f, 1.0f);
                this.setWaterLevel(lllllllllllIIlIlIlIIllllIIllIIll, lllllllllllIIlIlIlIIllllIIlIIIIl, lllllllllllIIlIlIlIIllllIIllIIIl, lllllllllllIIlIlIlIIllllIIlIlIIl + 1);
            }
            return true;
        }
        if (lllllllllllIIlIlIlIIllllIIlIlIIl > 0 && lllllllllllIIlIlIlIIllllIIlIlIII instanceof ItemArmor) {
            final ItemArmor lllllllllllIIlIlIlIIllllIIlIIlIl = (ItemArmor)lllllllllllIIlIlIlIIllllIIlIlIII;
            if (lllllllllllIIlIlIlIIllllIIlIIlIl.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER && lllllllllllIIlIlIlIIllllIIlIIlIl.hasColor(lllllllllllIIlIlIlIIllllIIlIlIlI) && !lllllllllllIIlIlIlIIllllIIllIIll.isRemote) {
                lllllllllllIIlIlIlIIllllIIlIIlIl.removeColor(lllllllllllIIlIlIlIIllllIIlIlIlI);
                this.setWaterLevel(lllllllllllIIlIlIlIIllllIIllIIll, lllllllllllIIlIlIlIIllllIIlIIIIl, lllllllllllIIlIlIlIIllllIIllIIIl, lllllllllllIIlIlIlIIllllIIlIlIIl - 1);
                lllllllllllIIlIlIlIIllllIIllIIII.addStat(StatList.ARMOR_CLEANED);
                return true;
            }
        }
        if (lllllllllllIIlIlIlIIllllIIlIlIIl > 0 && lllllllllllIIlIlIlIIllllIIlIlIII instanceof ItemBanner) {
            if (TileEntityBanner.getPatterns(lllllllllllIIlIlIlIIllllIIlIlIlI) > 0 && !lllllllllllIIlIlIlIIllllIIllIIll.isRemote) {
                final ItemStack lllllllllllIIlIlIlIIllllIIlIIlII = lllllllllllIIlIlIlIIllllIIlIlIlI.copy();
                lllllllllllIIlIlIlIIllllIIlIIlII.func_190920_e(1);
                TileEntityBanner.removeBannerData(lllllllllllIIlIlIlIIllllIIlIIlII);
                lllllllllllIIlIlIlIIllllIIllIIII.addStat(StatList.BANNER_CLEANED);
                if (!lllllllllllIIlIlIlIIllllIIllIIII.capabilities.isCreativeMode) {
                    lllllllllllIIlIlIlIIllllIIlIlIlI.func_190918_g(1);
                    this.setWaterLevel(lllllllllllIIlIlIlIIllllIIllIIll, lllllllllllIIlIlIlIIllllIIlIIIIl, lllllllllllIIlIlIlIIllllIIllIIIl, lllllllllllIIlIlIlIIllllIIlIlIIl - 1);
                }
                if (lllllllllllIIlIlIlIIllllIIlIlIlI.func_190926_b()) {
                    lllllllllllIIlIlIlIIllllIIllIIII.setHeldItem(lllllllllllIIlIlIlIIllllIIIllllI, lllllllllllIIlIlIlIIllllIIlIIlII);
                }
                else if (!lllllllllllIIlIlIlIIllllIIllIIII.inventory.addItemStackToInventory(lllllllllllIIlIlIlIIllllIIlIIlII)) {
                    lllllllllllIIlIlIlIIllllIIllIIII.dropItem(lllllllllllIIlIlIlIIllllIIlIIlII, false);
                }
                else if (lllllllllllIIlIlIlIIllllIIllIIII instanceof EntityPlayerMP) {
                    ((EntityPlayerMP)lllllllllllIIlIlIlIIllllIIllIIII).sendContainerToPlayer(lllllllllllIIlIlIlIIllllIIllIIII.inventoryContainer);
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIlIlIlIIllllIlIllIlI, final IBlockAccess lllllllllllIIlIlIlIIllllIlIllIIl, final BlockPos lllllllllllIIlIlIlIIllllIlIllIII) {
        return BlockCauldron.FULL_BLOCK_AABB;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIlIlIlIIlllIlllIlIII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCauldron.LEVEL, lllllllllllIIlIlIlIIlllIlllIlIII);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIlIlIlIIllllIlIlIlII) {
        return false;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllIIlIlIlIIlllIllIlllll, final BlockPos lllllllllllIIlIlIlIIlllIllIllllI) {
        return true;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllIIlIlIlIIlllIllllIIIl, final World lllllllllllIIlIlIlIIlllIllllIIII, final BlockPos lllllllllllIIlIlIlIIlllIlllIllll) {
        return lllllllllllIIlIlIlIIlllIllllIIIl.getValue((IProperty<Integer>)BlockCauldron.LEVEL);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllIIlIlIlIIllllIlIIIlII, final BlockPos lllllllllllIIlIlIlIIllllIlIIlIlI, final IBlockState lllllllllllIIlIlIlIIllllIlIIlIIl, final Entity lllllllllllIIlIlIlIIllllIlIIIIIl) {
        final int lllllllllllIIlIlIlIIllllIlIIIlll = lllllllllllIIlIlIlIIllllIlIIlIIl.getValue((IProperty<Integer>)BlockCauldron.LEVEL);
        final float lllllllllllIIlIlIlIIllllIlIIIllI = lllllllllllIIlIlIlIIllllIlIIlIlI.getY() + (6.0f + 3 * lllllllllllIIlIlIlIIllllIlIIIlll) / 16.0f;
        if (!lllllllllllIIlIlIlIIllllIlIIIlII.isRemote && lllllllllllIIlIlIlIIllllIlIIIIIl.isBurning() && lllllllllllIIlIlIlIIllllIlIIIlll > 0 && lllllllllllIIlIlIlIIllllIlIIIIIl.getEntityBoundingBox().minY <= lllllllllllIIlIlIlIIllllIlIIIllI) {
            lllllllllllIIlIlIlIIllllIlIIIIIl.extinguish();
            this.setWaterLevel(lllllllllllIIlIlIlIIllllIlIIIlII, lllllllllllIIlIlIlIIllllIlIIlIlI, lllllllllllIIlIlIlIIllllIlIIlIIl, lllllllllllIIlIlIlIIllllIlIIIlll - 1);
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIlIlIlIIlllIllllllII, final Random lllllllllllIIlIlIlIIlllIlllllIll, final int lllllllllllIIlIlIlIIlllIlllllIlI) {
        return Items.CAULDRON;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlIlIlIIlllIlllIIlII) {
        return lllllllllllIIlIlIlIIlllIlllIIlII.getValue((IProperty<Integer>)BlockCauldron.LEVEL);
    }
}
