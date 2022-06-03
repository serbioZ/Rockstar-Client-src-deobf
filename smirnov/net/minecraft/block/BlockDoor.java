// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.IBlockProperties;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumHand;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.ItemStack;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;

public class BlockDoor extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumDoorHalf> HALF;
    public static final /* synthetic */ PropertyBool POWERED;
    protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    public static final /* synthetic */ PropertyEnum<EnumHingePosition> HINGE;
    public static final /* synthetic */ PropertyBool OPEN;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllllIIIlIllIlIlIlllll, final IBlockAccess lllllllllllllllIIIlIllIlIlIllllI, final BlockPos lllllllllllllllIIIlIllIlIlIlllIl) {
        if (((IBlockState)lllllllllllllllIIIlIllIlIlIlllll).getValue(BlockDoor.HALF) == EnumDoorHalf.LOWER) {
            final IBlockState lllllllllllllllIIIlIllIlIllIIIlI = lllllllllllllllIIIlIllIlIlIllllI.getBlockState(lllllllllllllllIIIlIllIlIlIlllIl.up());
            if (lllllllllllllllIIIlIllIlIllIIIlI.getBlock() == this) {
                lllllllllllllllIIIlIllIlIlIlllll = ((IBlockState)lllllllllllllllIIIlIllIlIlIlllll).withProperty(BlockDoor.HINGE, (EnumHingePosition)lllllllllllllllIIIlIllIlIllIIIlI.getValue((IProperty<V>)BlockDoor.HINGE)).withProperty((IProperty<Comparable>)BlockDoor.POWERED, (Boolean)lllllllllllllllIIIlIllIlIllIIIlI.getValue((IProperty<V>)BlockDoor.POWERED));
            }
        }
        else {
            final IBlockState lllllllllllllllIIIlIllIlIllIIIIl = lllllllllllllllIIIlIllIlIlIllllI.getBlockState(lllllllllllllllIIIlIllIlIlIlllIl.down());
            if (lllllllllllllllIIIlIllIlIllIIIIl.getBlock() == this) {
                lllllllllllllllIIIlIllIlIlIlllll = ((IBlockState)lllllllllllllllIIIlIllIlIlIlllll).withProperty((IProperty<Comparable>)BlockDoor.FACING, (EnumFacing)lllllllllllllllIIIlIllIlIllIIIIl.getValue((IProperty<V>)BlockDoor.FACING)).withProperty((IProperty<Comparable>)BlockDoor.OPEN, (Boolean)lllllllllllllllIIIlIllIlIllIIIIl.getValue((IProperty<V>)BlockDoor.OPEN));
            }
        }
        return (IBlockState)lllllllllllllllIIIlIllIlIlIlllll;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIlIllIlIlIIIIlI) {
        int lllllllllllllllIIIlIllIlIlIIIIll = 0;
        if (lllllllllllllllIIIlIllIlIlIIIIlI.getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) {
            lllllllllllllllIIIlIllIlIlIIIIll |= 0x8;
            if (lllllllllllllllIIIlIllIlIlIIIIlI.getValue(BlockDoor.HINGE) == EnumHingePosition.RIGHT) {
                lllllllllllllllIIIlIllIlIlIIIIll |= 0x1;
            }
            if (lllllllllllllllIIIlIllIlIlIIIIlI.getValue((IProperty<Boolean>)BlockDoor.POWERED)) {
                lllllllllllllllIIIlIllIlIlIIIIll |= 0x2;
            }
        }
        else {
            lllllllllllllllIIIlIllIlIlIIIIll |= lllllllllllllllIIIlIllIlIlIIIIlI.getValue((IProperty<EnumFacing>)BlockDoor.FACING).rotateY().getHorizontalIndex();
            if (lllllllllllllllIIIlIllIlIlIIIIlI.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
                lllllllllllllllIIIlIllIlIlIIIIll |= 0x4;
            }
        }
        return lllllllllllllllIIIlIllIlIlIIIIll;
    }
    
    public void toggleDoor(final World lllllllllllllllIIIlIllIllllIlIlI, final BlockPos lllllllllllllllIIIlIllIlllllIIII, final boolean lllllllllllllllIIIlIllIllllIllll) {
        final IBlockState lllllllllllllllIIIlIllIllllIlllI = lllllllllllllllIIIlIllIllllIlIlI.getBlockState(lllllllllllllllIIIlIllIlllllIIII);
        if (lllllllllllllllIIIlIllIllllIlllI.getBlock() == this) {
            final BlockPos lllllllllllllllIIIlIllIllllIllIl = (lllllllllllllllIIIlIllIllllIlllI.getValue(BlockDoor.HALF) == EnumDoorHalf.LOWER) ? lllllllllllllllIIIlIllIlllllIIII : lllllllllllllllIIIlIllIlllllIIII.down();
            final IBlockState lllllllllllllllIIIlIllIllllIllII = (lllllllllllllllIIIlIllIlllllIIII == lllllllllllllllIIIlIllIllllIllIl) ? lllllllllllllllIIIlIllIllllIlllI : lllllllllllllllIIIlIllIllllIlIlI.getBlockState(lllllllllllllllIIIlIllIllllIllIl);
            if (lllllllllllllllIIIlIllIllllIllII.getBlock() == this && lllllllllllllllIIIlIllIllllIllII.getValue((IProperty<Boolean>)BlockDoor.OPEN) != lllllllllllllllIIIlIllIllllIllll) {
                lllllllllllllllIIIlIllIllllIlIlI.setBlockState(lllllllllllllllIIIlIllIllllIllIl, lllllllllllllllIIIlIllIllllIllII.withProperty((IProperty<Comparable>)BlockDoor.OPEN, lllllllllllllllIIIlIllIllllIllll), 10);
                lllllllllllllllIIIlIllIllllIlIlI.markBlockRangeForRenderUpdate(lllllllllllllllIIIlIllIllllIllIl, lllllllllllllllIIIlIllIlllllIIII);
                lllllllllllllllIIIlIllIllllIlIlI.playEvent(null, lllllllllllllllIIIlIllIllllIllll ? this.getOpenSound() : this.getCloseSound(), lllllllllllllllIIIlIllIlllllIIII, 0);
            }
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllIIIlIllIlllIIllIl, final World lllllllllllllllIIIlIllIlllIllIII, final BlockPos lllllllllllllllIIIlIllIlllIlIlll, final Block lllllllllllllllIIIlIllIlllIlIllI, final BlockPos lllllllllllllllIIIlIllIlllIlIlIl) {
        if (lllllllllllllllIIIlIllIlllIIllIl.getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) {
            final BlockPos lllllllllllllllIIIlIllIlllIlIlII = lllllllllllllllIIIlIllIlllIlIlll.down();
            final IBlockState lllllllllllllllIIIlIllIlllIlIIll = lllllllllllllllIIIlIllIlllIllIII.getBlockState(lllllllllllllllIIIlIllIlllIlIlII);
            if (lllllllllllllllIIIlIllIlllIlIIll.getBlock() != this) {
                lllllllllllllllIIIlIllIlllIllIII.setBlockToAir(lllllllllllllllIIIlIllIlllIlIlll);
            }
            else if (lllllllllllllllIIIlIllIlllIlIllI != this) {
                lllllllllllllllIIIlIllIlllIlIIll.neighborChanged(lllllllllllllllIIIlIllIlllIllIII, lllllllllllllllIIIlIllIlllIlIlII, lllllllllllllllIIIlIllIlllIlIllI, lllllllllllllllIIIlIllIlllIlIlIl);
            }
        }
        else {
            boolean lllllllllllllllIIIlIllIlllIlIIlI = false;
            final BlockPos lllllllllllllllIIIlIllIlllIlIIIl = lllllllllllllllIIIlIllIlllIlIlll.up();
            final IBlockState lllllllllllllllIIIlIllIlllIlIIII = lllllllllllllllIIIlIllIlllIllIII.getBlockState(lllllllllllllllIIIlIllIlllIlIIIl);
            if (lllllllllllllllIIIlIllIlllIlIIII.getBlock() != this) {
                lllllllllllllllIIIlIllIlllIllIII.setBlockToAir(lllllllllllllllIIIlIllIlllIlIlll);
                lllllllllllllllIIIlIllIlllIlIIlI = true;
            }
            if (!lllllllllllllllIIIlIllIlllIllIII.getBlockState(lllllllllllllllIIIlIllIlllIlIlll.down()).isFullyOpaque()) {
                lllllllllllllllIIIlIllIlllIllIII.setBlockToAir(lllllllllllllllIIIlIllIlllIlIlll);
                lllllllllllllllIIIlIllIlllIlIIlI = true;
                if (lllllllllllllllIIIlIllIlllIlIIII.getBlock() == this) {
                    lllllllllllllllIIIlIllIlllIllIII.setBlockToAir(lllllllllllllllIIIlIllIlllIlIIIl);
                }
            }
            if (lllllllllllllllIIIlIllIlllIlIIlI) {
                if (!lllllllllllllllIIIlIllIlllIllIII.isRemote) {
                    this.dropBlockAsItem(lllllllllllllllIIIlIllIlllIllIII, lllllllllllllllIIIlIllIlllIlIlll, lllllllllllllllIIIlIllIlllIIllIl, 0);
                }
            }
            else {
                final boolean lllllllllllllllIIIlIllIlllIIllll = lllllllllllllllIIIlIllIlllIllIII.isBlockPowered(lllllllllllllllIIIlIllIlllIlIlll) || lllllllllllllllIIIlIllIlllIllIII.isBlockPowered(lllllllllllllllIIIlIllIlllIlIIIl);
                if (lllllllllllllllIIIlIllIlllIlIllI != this && (lllllllllllllllIIIlIllIlllIIllll || lllllllllllllllIIIlIllIlllIlIllI.getDefaultState().canProvidePower()) && lllllllllllllllIIIlIllIlllIIllll != lllllllllllllllIIIlIllIlllIlIIII.getValue((IProperty<Boolean>)BlockDoor.POWERED)) {
                    lllllllllllllllIIIlIllIlllIllIII.setBlockState(lllllllllllllllIIIlIllIlllIlIIIl, lllllllllllllllIIIlIllIlllIlIIII.withProperty((IProperty<Comparable>)BlockDoor.POWERED, lllllllllllllllIIIlIllIlllIIllll), 2);
                    if (lllllllllllllllIIIlIllIlllIIllll != lllllllllllllllIIIlIllIlllIIllIl.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
                        lllllllllllllllIIIlIllIlllIllIII.setBlockState(lllllllllllllllIIIlIllIlllIlIlll, lllllllllllllllIIIlIllIlllIIllIl.withProperty((IProperty<Comparable>)BlockDoor.OPEN, lllllllllllllllIIIlIllIlllIIllll), 2);
                        lllllllllllllllIIIlIllIlllIllIII.markBlockRangeForRenderUpdate(lllllllllllllllIIIlIllIlllIlIlll, lllllllllllllllIIIlIllIlllIlIlll);
                        lllllllllllllllIIIlIllIlllIllIII.playEvent(null, lllllllllllllllIIIlIllIlllIIllll ? this.getOpenSound() : this.getCloseSound(), lllllllllllllllIIIlIllIlllIlIlll, 0);
                    }
                }
            }
        }
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal((String.valueOf(this.getUnlocalizedName()) + ".name").replaceAll("tile", "item"));
    }
    
    private Item getItem() {
        if (this == Blocks.IRON_DOOR) {
            return Items.IRON_DOOR;
        }
        if (this == Blocks.SPRUCE_DOOR) {
            return Items.SPRUCE_DOOR;
        }
        if (this == Blocks.BIRCH_DOOR) {
            return Items.BIRCH_DOOR;
        }
        if (this == Blocks.JUNGLE_DOOR) {
            return Items.JUNGLE_DOOR;
        }
        if (this == Blocks.ACACIA_DOOR) {
            return Items.ACACIA_DOOR;
        }
        return (this == Blocks.DARK_OAK_DOOR) ? Items.DARK_OAK_DOOR : Items.OAK_DOOR;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIIIlIllIllIllIlIl, final BlockPos lllllllllllllllIIIlIllIllIllIlll) {
        return lllllllllllllllIIIlIllIllIllIlll.getY() < 255 && (lllllllllllllllIIIlIllIllIllIlIl.getBlockState(lllllllllllllllIIIlIllIllIllIlll.down()).isFullyOpaque() && super.canPlaceBlockAt(lllllllllllllllIIIlIllIllIllIlIl, lllllllllllllllIIIlIllIllIllIlll) && super.canPlaceBlockAt(lllllllllllllllIIIlIllIllIllIlIl, lllllllllllllllIIIlIllIllIllIlll.up()));
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIIIlIllIllIllllIl, final Random lllllllllllllllIIIlIllIlllIIIIII, final int lllllllllllllllIIIlIllIllIllllll) {
        return (lllllllllllllllIIIlIllIllIllllIl.getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) ? Items.field_190931_a : this.getItem();
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIIIlIllIllIIIlIII, final BlockPos lllllllllllllllIIIlIllIllIIIIlll, final IBlockState lllllllllllllllIIIlIllIllIIIIllI) {
        return new ItemStack(this.getItem());
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDoor.HALF, BlockDoor.FACING, BlockDoor.OPEN, BlockDoor.HINGE, BlockDoor.POWERED });
    }
    
    protected static int removeHalfBit(final int lllllllllllllllIIIlIllIlIIlllllI) {
        return lllllllllllllllIIIlIllIlIIlllllI & 0x7;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIIIlIlllIIIlIllll) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIIIlIllIlllllllll, final BlockPos lllllllllllllllIIIlIllIllllllllI, IBlockState lllllllllllllllIIIlIllIlllllllIl, final EntityPlayer lllllllllllllllIIIlIlllIIIIIlIII, final EnumHand lllllllllllllllIIIlIlllIIIIIIlll, final EnumFacing lllllllllllllllIIIlIlllIIIIIIllI, final float lllllllllllllllIIIlIlllIIIIIIlIl, final float lllllllllllllllIIIlIlllIIIIIIlII, final float lllllllllllllllIIIlIlllIIIIIIIll) {
        if (this.blockMaterial == Material.IRON) {
            return false;
        }
        final BlockPos lllllllllllllllIIIlIlllIIIIIIIlI = (lllllllllllllllIIIlIllIlllllllIl.getValue(BlockDoor.HALF) == EnumDoorHalf.LOWER) ? lllllllllllllllIIIlIllIllllllllI : lllllllllllllllIIIlIllIllllllllI.down();
        final IBlockState lllllllllllllllIIIlIlllIIIIIIIIl = lllllllllllllllIIIlIllIllllllllI.equals(lllllllllllllllIIIlIlllIIIIIIIlI) ? lllllllllllllllIIIlIllIlllllllIl : lllllllllllllllIIIlIllIlllllllll.getBlockState(lllllllllllllllIIIlIlllIIIIIIIlI);
        if (lllllllllllllllIIIlIlllIIIIIIIIl.getBlock() != this) {
            return false;
        }
        lllllllllllllllIIIlIllIlllllllIl = lllllllllllllllIIIlIlllIIIIIIIIl.cycleProperty((IProperty<Comparable>)BlockDoor.OPEN);
        lllllllllllllllIIIlIllIlllllllll.setBlockState(lllllllllllllllIIIlIlllIIIIIIIlI, lllllllllllllllIIIlIllIlllllllIl, 10);
        lllllllllllllllIIIlIllIlllllllll.markBlockRangeForRenderUpdate(lllllllllllllllIIIlIlllIIIIIIIlI, lllllllllllllllIIIlIllIllllllllI);
        lllllllllllllllIIIlIllIlllllllll.playEvent(lllllllllllllllIIIlIlllIIIIIlIII, ((boolean)lllllllllllllllIIIlIllIlllllllIl.getValue((IProperty<Boolean>)BlockDoor.OPEN)) ? this.getOpenSound() : this.getCloseSound(), lllllllllllllllIIIlIllIllllllllI, 0);
        return true;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIIIlIlllIIIIllIlI, final IBlockAccess lllllllllllllllIIIlIlllIIIIlIlIl, final BlockPos lllllllllllllllIIIlIlllIIIIlIlII) {
        if (lllllllllllllllIIIlIlllIIIIllIlI.getBlock() == Blocks.IRON_DOOR) {
            return MapColor.IRON;
        }
        if (lllllllllllllllIIIlIlllIIIIllIlI.getBlock() == Blocks.OAK_DOOR) {
            return BlockPlanks.EnumType.OAK.getMapColor();
        }
        if (lllllllllllllllIIIlIlllIIIIllIlI.getBlock() == Blocks.SPRUCE_DOOR) {
            return BlockPlanks.EnumType.SPRUCE.getMapColor();
        }
        if (lllllllllllllllIIIlIlllIIIIllIlI.getBlock() == Blocks.BIRCH_DOOR) {
            return BlockPlanks.EnumType.BIRCH.getMapColor();
        }
        if (lllllllllllllllIIIlIlllIIIIllIlI.getBlock() == Blocks.JUNGLE_DOOR) {
            return BlockPlanks.EnumType.JUNGLE.getMapColor();
        }
        if (lllllllllllllllIIIlIlllIIIIllIlI.getBlock() == Blocks.ACACIA_DOOR) {
            return BlockPlanks.EnumType.ACACIA.getMapColor();
        }
        return (lllllllllllllllIIIlIlllIIIIllIlI.getBlock() == Blocks.DARK_OAK_DOOR) ? BlockPlanks.EnumType.DARK_OAK.getMapColor() : super.getMapColor(lllllllllllllllIIIlIlllIIIIllIlI, lllllllllllllllIIIlIlllIIIIlIlIl, lllllllllllllllIIIlIlllIIIIlIlII);
    }
    
    public static EnumFacing getFacing(final IBlockAccess lllllllllllllllIIIlIllIlIIllIlIl, final BlockPos lllllllllllllllIIIlIllIlIIllIIlI) {
        return getFacing(combineMetadata(lllllllllllllllIIIlIllIlIIllIlIl, lllllllllllllllIIIlIllIlIIllIIlI));
    }
    
    protected BlockDoor(final Material lllllllllllllllIIIlIlllIIlIIlIIl) {
        super(lllllllllllllllIIIlIlllIIlIIlIIl);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockDoor.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockDoor.OPEN, false).withProperty(BlockDoor.HINGE, EnumHingePosition.LEFT).withProperty((IProperty<Comparable>)BlockDoor.POWERED, false).withProperty(BlockDoor.HALF, EnumDoorHalf.LOWER));
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        OPEN = PropertyBool.create("open");
        HINGE = PropertyEnum.create("hinge", EnumHingePosition.class);
        POWERED = PropertyBool.create("powered");
        HALF = PropertyEnum.create("half", EnumDoorHalf.class);
        SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.1875);
        NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.8125, 1.0, 1.0, 1.0);
        WEST_AABB = new AxisAlignedBB(0.8125, 0.0, 0.0, 1.0, 1.0, 1.0);
        EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.1875, 1.0, 1.0);
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllllIIIlIllIlIllllIIl, final BlockPos lllllllllllllllIIIlIllIlIllllIII, final IBlockState lllllllllllllllIIIlIllIlIlllIIII, final EntityPlayer lllllllllllllllIIIlIllIlIllIllll) {
        final BlockPos lllllllllllllllIIIlIllIlIlllIlIl = lllllllllllllllIIIlIllIlIllllIII.down();
        final BlockPos lllllllllllllllIIIlIllIlIlllIlII = lllllllllllllllIIIlIllIlIllllIII.up();
        if (lllllllllllllllIIIlIllIlIllIllll.capabilities.isCreativeMode && lllllllllllllllIIIlIllIlIlllIIII.getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER && lllllllllllllllIIIlIllIlIllllIIl.getBlockState(lllllllllllllllIIIlIllIlIlllIlIl).getBlock() == this) {
            lllllllllllllllIIIlIllIlIllllIIl.setBlockToAir(lllllllllllllllIIIlIllIlIlllIlIl);
        }
        if (lllllllllllllllIIIlIllIlIlllIIII.getValue(BlockDoor.HALF) == EnumDoorHalf.LOWER && lllllllllllllllIIIlIllIlIllllIIl.getBlockState(lllllllllllllllIIIlIllIlIlllIlII).getBlock() == this) {
            if (lllllllllllllllIIIlIllIlIllIllll.capabilities.isCreativeMode) {
                lllllllllllllllIIIlIllIlIllllIIl.setBlockToAir(lllllllllllllllIIIlIllIlIllllIII);
            }
            lllllllllllllllIIIlIllIlIllllIIl.setBlockToAir(lllllllllllllllIIIlIllIlIlllIlII);
        }
    }
    
    protected static boolean isTop(final int lllllllllllllllIIIlIllIlIIlIlIIl) {
        return (lllllllllllllllIIIlIllIlIIlIlIIl & 0x8) != 0x0;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIIIlIlllIIIlIIllI) {
        return false;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllllllIIIlIllIllIllIIlI) {
        return EnumPushReaction.DESTROY;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIIlIllIlIlIIlIII) {
        return ((lllllllllllllllIIIlIllIlIlIIlIII & 0x8) > 0) ? this.getDefaultState().withProperty(BlockDoor.HALF, EnumDoorHalf.UPPER).withProperty(BlockDoor.HINGE, ((lllllllllllllllIIIlIllIlIlIIlIII & 0x1) > 0) ? EnumHingePosition.RIGHT : EnumHingePosition.LEFT).withProperty((IProperty<Comparable>)BlockDoor.POWERED, (lllllllllllllllIIIlIllIlIlIIlIII & 0x2) > 0) : this.getDefaultState().withProperty(BlockDoor.HALF, EnumDoorHalf.LOWER).withProperty((IProperty<Comparable>)BlockDoor.FACING, EnumFacing.getHorizontal(lllllllllllllllIIIlIllIlIlIIlIII & 0x3).rotateYCCW()).withProperty((IProperty<Comparable>)BlockDoor.OPEN, (lllllllllllllllIIIlIllIlIlIIlIII & 0x4) > 0);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllllIIIlIlllIIIlIlIll, final BlockPos lllllllllllllllIIIlIlllIIIlIlIlI) {
        return isOpen(combineMetadata(lllllllllllllllIIIlIlllIIIlIlIll, lllllllllllllllIIIlIlllIIIlIlIlI));
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIIIlIllIlIIlIIlII, final IBlockState lllllllllllllllIIIlIllIlIIlIIIll, final BlockPos lllllllllllllllIIIlIllIlIIlIIIlI, final EnumFacing lllllllllllllllIIIlIllIlIIlIIIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    private int getOpenSound() {
        return (this.blockMaterial == Material.IRON) ? 1005 : 1006;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllIIIlIllIlIlIllIII, final Rotation lllllllllllllllIIIlIllIlIlIlIlll) {
        return (lllllllllllllllIIIlIllIlIlIllIII.getValue(BlockDoor.HALF) != EnumDoorHalf.LOWER) ? lllllllllllllllIIIlIllIlIlIllIII : lllllllllllllllIIIlIllIlIlIllIII.withProperty((IProperty<Comparable>)BlockDoor.FACING, lllllllllllllllIIIlIllIlIlIlIlll.rotate(lllllllllllllllIIIlIllIlIlIllIII.getValue((IProperty<EnumFacing>)BlockDoor.FACING)));
    }
    
    protected static boolean isOpen(final int lllllllllllllllIIIlIllIlIIlIllIl) {
        return (lllllllllllllllIIIlIllIlIIlIllIl & 0x4) != 0x0;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllllIIIlIllIlIlIIllll, final Mirror lllllllllllllllIIIlIllIlIlIlIIII) {
        return (lllllllllllllllIIIlIllIlIlIlIIII == Mirror.NONE) ? lllllllllllllllIIIlIllIlIlIIllll : lllllllllllllllIIIlIllIlIlIIllll.withRotation(lllllllllllllllIIIlIllIlIlIlIIII.toRotation(lllllllllllllllIIIlIllIlIlIIllll.getValue((IProperty<EnumFacing>)BlockDoor.FACING))).cycleProperty(BlockDoor.HINGE);
    }
    
    private int getCloseSound() {
        return (this.blockMaterial == Material.IRON) ? 1011 : 1012;
    }
    
    public static boolean isOpen(final IBlockAccess lllllllllllllllIIIlIllIlIIlllIIl, final BlockPos lllllllllllllllIIIlIllIlIIlllIII) {
        return isOpen(combineMetadata(lllllllllllllllIIIlIllIlIIlllIIl, lllllllllllllllIIIlIllIlIIlllIII));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState lllllllllllllllIIIlIlllIIIlllIIl, final IBlockAccess lllllllllllllllIIIlIlllIIIlllIII, final BlockPos lllllllllllllllIIIlIlllIIIllllIl) {
        lllllllllllllllIIIlIlllIIIlllIIl = (boolean)((IBlockProperties)lllllllllllllllIIIlIlllIIIlllIIl).getActualState(lllllllllllllllIIIlIlllIIIlllIII, lllllllllllllllIIIlIlllIIIllllIl);
        final EnumFacing lllllllllllllllIIIlIlllIIIllllII = ((IBlockState)lllllllllllllllIIIlIlllIIIlllIIl).getValue((IProperty<EnumFacing>)BlockDoor.FACING);
        final boolean lllllllllllllllIIIlIlllIIIlllIll = !((IBlockState)lllllllllllllllIIIlIlllIIIlllIIl).getValue((IProperty<Boolean>)BlockDoor.OPEN);
        final boolean lllllllllllllllIIIlIlllIIIlllIlI = ((IBlockState)lllllllllllllllIIIlIlllIIIlllIIl).getValue(BlockDoor.HINGE) == EnumHingePosition.RIGHT;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllllIIIlIlllIIIllllII.ordinal()]) {
            default: {
                return lllllllllllllllIIIlIlllIIIlllIll ? BlockDoor.EAST_AABB : (lllllllllllllllIIIlIlllIIIlllIlI ? BlockDoor.NORTH_AABB : BlockDoor.SOUTH_AABB);
            }
            case 4: {
                return lllllllllllllllIIIlIlllIIIlllIll ? BlockDoor.SOUTH_AABB : (lllllllllllllllIIIlIlllIIIlllIlI ? BlockDoor.EAST_AABB : BlockDoor.WEST_AABB);
            }
            case 5: {
                return lllllllllllllllIIIlIlllIIIlllIll ? BlockDoor.WEST_AABB : (lllllllllllllllIIIlIlllIIIlllIlI ? BlockDoor.SOUTH_AABB : BlockDoor.NORTH_AABB);
            }
            case 3: {
                return lllllllllllllllIIIlIlllIIIlllIll ? BlockDoor.NORTH_AABB : (lllllllllllllllIIIlIlllIIIlllIlI ? BlockDoor.WEST_AABB : BlockDoor.EAST_AABB);
            }
        }
    }
    
    public static int combineMetadata(final IBlockAccess lllllllllllllllIIIlIllIllIIlIlll, final BlockPos lllllllllllllllIIIlIllIllIIlIllI) {
        final IBlockState lllllllllllllllIIIlIllIllIlIIIlI = lllllllllllllllIIIlIllIllIIlIlll.getBlockState(lllllllllllllllIIIlIllIllIIlIllI);
        final int lllllllllllllllIIIlIllIllIlIIIIl = lllllllllllllllIIIlIllIllIlIIIlI.getBlock().getMetaFromState(lllllllllllllllIIIlIllIllIlIIIlI);
        final boolean lllllllllllllllIIIlIllIllIlIIIII = isTop(lllllllllllllllIIIlIllIllIlIIIIl);
        final IBlockState lllllllllllllllIIIlIllIllIIlllll = lllllllllllllllIIIlIllIllIIlIlll.getBlockState(lllllllllllllllIIIlIllIllIIlIllI.down());
        final int lllllllllllllllIIIlIllIllIIllllI = lllllllllllllllIIIlIllIllIIlllll.getBlock().getMetaFromState(lllllllllllllllIIIlIllIllIIlllll);
        final int lllllllllllllllIIIlIllIllIIlllIl = lllllllllllllllIIIlIllIllIlIIIII ? lllllllllllllllIIIlIllIllIIllllI : lllllllllllllllIIIlIllIllIlIIIIl;
        final IBlockState lllllllllllllllIIIlIllIllIIlllII = lllllllllllllllIIIlIllIllIIlIlll.getBlockState(lllllllllllllllIIIlIllIllIIlIllI.up());
        final int lllllllllllllllIIIlIllIllIIllIll = lllllllllllllllIIIlIllIllIIlllII.getBlock().getMetaFromState(lllllllllllllllIIIlIllIllIIlllII);
        final int lllllllllllllllIIIlIllIllIIllIlI = lllllllllllllllIIIlIllIllIlIIIII ? lllllllllllllllIIIlIllIllIlIIIIl : lllllllllllllllIIIlIllIllIIllIll;
        final boolean lllllllllllllllIIIlIllIllIIllIIl = (lllllllllllllllIIIlIllIllIIllIlI & 0x1) != 0x0;
        final boolean lllllllllllllllIIIlIllIllIIllIII = (lllllllllllllllIIIlIllIllIIllIlI & 0x2) != 0x0;
        return removeHalfBit(lllllllllllllllIIIlIllIllIIlllIl) | (lllllllllllllllIIIlIllIllIlIIIII ? 8 : 0) | (lllllllllllllllIIIlIllIllIIllIIl ? 16 : 0) | (lllllllllllllllIIIlIllIllIIllIII ? 32 : 0);
    }
    
    public static EnumFacing getFacing(final int lllllllllllllllIIIlIllIlIIllIIII) {
        return EnumFacing.getHorizontal(lllllllllllllllIIIlIllIlIIllIIII & 0x3).rotateYCCW();
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockDoor.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final long lllllllllllllllIIIlIllIlIIIlllll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllllIIIlIllIlIIIlllll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIIIlIllIlIIIlllll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIIIlIllIlIIIlllll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIIIlIllIlIIIlllll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIIIlIllIlIIIlllll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIIIlIllIlIIIlllll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockDoor.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllllIIIlIllIlIIIlllll;
    }
    
    public enum EnumDoorHalf implements IStringSerializable
    {
        UPPER("UPPER", 0), 
        LOWER("LOWER", 1);
        
        @Override
        public String getName() {
            return (this == EnumDoorHalf.UPPER) ? "upper" : "lower";
        }
        
        @Override
        public String toString() {
            return this.getName();
        }
        
        private EnumDoorHalf(final String lllllllllllIlIlIIlIIIIlIlIIlllII, final int lllllllllllIlIlIIlIIIIlIlIIllIll) {
        }
    }
    
    public enum EnumHingePosition implements IStringSerializable
    {
        LEFT("LEFT", 0), 
        RIGHT("RIGHT", 1);
        
        private EnumHingePosition(final String lllllllllllIIIIIlIllIlIllllIIlII, final int lllllllllllIIIIIlIllIlIllllIIIll) {
        }
        
        @Override
        public String getName() {
            return (this == EnumHingePosition.LEFT) ? "left" : "right";
        }
        
        @Override
        public String toString() {
            return this.getName();
        }
    }
}
