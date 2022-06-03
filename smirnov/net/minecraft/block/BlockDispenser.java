// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.inventory.Container;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Rotation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Mirror;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.IBlockSource;
import java.util.Random;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.RegistryDefaulted;
import net.minecraft.block.properties.PropertyDirection;

public class BlockDispenser extends BlockContainer
{
    public static final /* synthetic */ PropertyDirection FACING;
    public static final /* synthetic */ RegistryDefaulted<Item, IBehaviorDispenseItem> DISPENSE_BEHAVIOR_REGISTRY;
    public static final /* synthetic */ PropertyBool TRIGGERED;
    protected /* synthetic */ Random rand;
    
    public static IPosition getDispensePosition(final IBlockSource llllllllllllIIlllIIlIlIIIlIIlIlI) {
        final EnumFacing llllllllllllIIlllIIlIlIIIlIIlIIl = llllllllllllIIlllIIlIlIIIlIIlIlI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
        final double llllllllllllIIlllIIlIlIIIlIIlIII = llllllllllllIIlllIIlIlIIIlIIlIlI.getX() + 0.7 * llllllllllllIIlllIIlIlIIIlIIlIIl.getFrontOffsetX();
        final double llllllllllllIIlllIIlIlIIIlIIIlll = llllllllllllIIlllIIlIlIIIlIIlIlI.getY() + 0.7 * llllllllllllIIlllIIlIlIIIlIIlIIl.getFrontOffsetY();
        final double llllllllllllIIlllIIlIlIIIlIIIllI = llllllllllllIIlllIIlIlIIIlIIlIlI.getZ() + 0.7 * llllllllllllIIlllIIlIlIIIlIIlIIl.getFrontOffsetZ();
        return new PositionImpl(llllllllllllIIlllIIlIlIIIlIIlIII, llllllllllllIIlllIIlIlIIIlIIIlll, llllllllllllIIlllIIlIlIIIlIIIllI);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIIlllIIlIlIIlIIllIll, final World llllllllllllIIlllIIlIlIIlIIllIlI, final BlockPos llllllllllllIIlllIIlIlIIlIIllIIl, final Block llllllllllllIIlllIIlIlIIlIIllIII, final BlockPos llllllllllllIIlllIIlIlIIlIIlIlll) {
        final boolean llllllllllllIIlllIIlIlIIlIIlIllI = llllllllllllIIlllIIlIlIIlIIllIlI.isBlockPowered(llllllllllllIIlllIIlIlIIlIIllIIl) || llllllllllllIIlllIIlIlIIlIIllIlI.isBlockPowered(llllllllllllIIlllIIlIlIIlIIllIIl.up());
        final boolean llllllllllllIIlllIIlIlIIlIIlIlIl = llllllllllllIIlllIIlIlIIlIIllIll.getValue((IProperty<Boolean>)BlockDispenser.TRIGGERED);
        if (llllllllllllIIlllIIlIlIIlIIlIllI && !llllllllllllIIlllIIlIlIIlIIlIlIl) {
            llllllllllllIIlllIIlIlIIlIIllIlI.scheduleUpdate(llllllllllllIIlllIIlIlIIlIIllIIl, this, this.tickRate(llllllllllllIIlllIIlIlIIlIIllIlI));
            llllllllllllIIlllIIlIlIIlIIllIlI.setBlockState(llllllllllllIIlllIIlIlIIlIIllIIl, llllllllllllIIlllIIlIlIIlIIllIll.withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, true), 4);
        }
        else if (!llllllllllllIIlllIIlIlIIlIIlIllI && llllllllllllIIlllIIlIlIIlIIlIlIl) {
            llllllllllllIIlllIIlIlIIlIIllIlI.setBlockState(llllllllllllIIlllIIlIlIIlIIllIIl, llllllllllllIIlllIIlIlIIlIIllIll.withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, false), 4);
        }
    }
    
    @Override
    public void breakBlock(final World llllllllllllIIlllIIlIlIIIlIllIII, final BlockPos llllllllllllIIlllIIlIlIIIlIlIlll, final IBlockState llllllllllllIIlllIIlIlIIIlIlIllI) {
        final TileEntity llllllllllllIIlllIIlIlIIIlIlIlIl = llllllllllllIIlllIIlIlIIIlIllIII.getTileEntity(llllllllllllIIlllIIlIlIIIlIlIlll);
        if (llllllllllllIIlllIIlIlIIIlIlIlIl instanceof TileEntityDispenser) {
            InventoryHelper.dropInventoryItems(llllllllllllIIlllIIlIlIIIlIllIII, llllllllllllIIlllIIlIlIIIlIlIlll, (IInventory)llllllllllllIIlllIIlIlIIIlIlIlIl);
            llllllllllllIIlllIIlIlIIIlIllIII.updateComparatorOutputLevel(llllllllllllIIlllIIlIlIIIlIlIlll, this);
        }
        super.breakBlock(llllllllllllIIlllIIlIlIIIlIllIII, llllllllllllIIlllIIlIlIIIlIlIlll, llllllllllllIIlllIIlIlIIIlIlIllI);
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllIIlllIIlIlIIlllIllIl, final BlockPos llllllllllllIIlllIIlIlIIlllIllII, final IBlockState llllllllllllIIlllIIlIlIIlllIlIll) {
        super.onBlockAdded(llllllllllllIIlllIIlIlIIlllIllIl, llllllllllllIIlllIIlIlIIlllIllII, llllllllllllIIlllIIlIlIIlllIlIll);
        this.setDefaultDirection(llllllllllllIIlllIIlIlIIlllIllIl, llllllllllllIIlllIIlIlIIlllIllII, llllllllllllIIlllIIlIlIIlllIlIll);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIIlllIIlIlIIIIIlllIl, final Mirror llllllllllllIIlllIIlIlIIIIIllIlI) {
        return llllllllllllIIlllIIlIlIIIIIlllIl.withRotation(llllllllllllIIlllIIlIlIIIIIllIlI.toRotation(llllllllllllIIlllIIlIlIIIIIlllIl.getValue((IProperty<EnumFacing>)BlockDispenser.FACING)));
    }
    
    @Override
    public void updateTick(final World llllllllllllIIlllIIlIlIIlIIIlIlI, final BlockPos llllllllllllIIlllIIlIlIIlIIIlIIl, final IBlockState llllllllllllIIlllIIlIlIIlIIIlIII, final Random llllllllllllIIlllIIlIlIIlIIIIlll) {
        if (!llllllllllllIIlllIIlIlIIlIIIlIlI.isRemote) {
            this.dispense(llllllllllllIIlllIIlIlIIlIIIlIlI, llllllllllllIIlllIIlIlIIlIIIlIIl);
        }
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState llllllllllllIIlllIIlIlIIIIllllll) {
        return true;
    }
    
    protected IBehaviorDispenseItem getBehavior(final ItemStack llllllllllllIIlllIIlIlIIlIlIIIll) {
        return BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.getObject(llllllllllllIIlllIIlIlIIlIlIIIll.getItem());
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllIIlllIIlIlIIIlllllII, final BlockPos llllllllllllIIlllIIlIlIIIlllIIll, final EnumFacing llllllllllllIIlllIIlIlIIIllllIlI, final float llllllllllllIIlllIIlIlIIIllllIIl, final float llllllllllllIIlllIIlIlIIIllllIII, final float llllllllllllIIlllIIlIlIIIlllIlll, final int llllllllllllIIlllIIlIlIIIlllIllI, final EntityLivingBase llllllllllllIIlllIIlIlIIIlllIlIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockDispenser.FACING, EnumFacing.func_190914_a(llllllllllllIIlllIIlIlIIIlllIIll, llllllllllllIIlllIIlIlIIIlllIlIl)).withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, false);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIIlllIIlIlIIIIlIIlII, final Rotation llllllllllllIIlllIIlIlIIIIlIIIll) {
        return llllllllllllIIlllIIlIlIIIIlIIlII.withProperty((IProperty<Comparable>)BlockDispenser.FACING, llllllllllllIIlllIIlIlIIIIlIIIll.rotate(llllllllllllIIlllIIlIlIIIIlIIlII.getValue((IProperty<EnumFacing>)BlockDispenser.FACING)));
    }
    
    private void setDefaultDirection(final World llllllllllllIIlllIIlIlIIllIllIIl, final BlockPos llllllllllllIIlllIIlIlIIlllIIIII, final IBlockState llllllllllllIIlllIIlIlIIllIlllll) {
        if (!llllllllllllIIlllIIlIlIIllIllIIl.isRemote) {
            EnumFacing llllllllllllIIlllIIlIlIIllIllllI = llllllllllllIIlllIIlIlIIllIlllll.getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
            final boolean llllllllllllIIlllIIlIlIIllIlllIl = llllllllllllIIlllIIlIlIIllIllIIl.getBlockState(llllllllllllIIlllIIlIlIIlllIIIII.north()).isFullBlock();
            final boolean llllllllllllIIlllIIlIlIIllIlllII = llllllllllllIIlllIIlIlIIllIllIIl.getBlockState(llllllllllllIIlllIIlIlIIlllIIIII.south()).isFullBlock();
            if (llllllllllllIIlllIIlIlIIllIllllI == EnumFacing.NORTH && llllllllllllIIlllIIlIlIIllIlllIl && !llllllllllllIIlllIIlIlIIllIlllII) {
                llllllllllllIIlllIIlIlIIllIllllI = EnumFacing.SOUTH;
            }
            else if (llllllllllllIIlllIIlIlIIllIllllI == EnumFacing.SOUTH && llllllllllllIIlllIIlIlIIllIlllII && !llllllllllllIIlllIIlIlIIllIlllIl) {
                llllllllllllIIlllIIlIlIIllIllllI = EnumFacing.NORTH;
            }
            else {
                final boolean llllllllllllIIlllIIlIlIIllIllIll = llllllllllllIIlllIIlIlIIllIllIIl.getBlockState(llllllllllllIIlllIIlIlIIlllIIIII.west()).isFullBlock();
                final boolean llllllllllllIIlllIIlIlIIllIllIlI = llllllllllllIIlllIIlIlIIllIllIIl.getBlockState(llllllllllllIIlllIIlIlIIlllIIIII.east()).isFullBlock();
                if (llllllllllllIIlllIIlIlIIllIllllI == EnumFacing.WEST && llllllllllllIIlllIIlIlIIllIllIll && !llllllllllllIIlllIIlIlIIllIllIlI) {
                    llllllllllllIIlllIIlIlIIllIllllI = EnumFacing.EAST;
                }
                else if (llllllllllllIIlllIIlIlIIllIllllI == EnumFacing.EAST && llllllllllllIIlllIIlIlIIllIllIlI && !llllllllllllIIlllIIlIlIIllIllIll) {
                    llllllllllllIIlllIIlIlIIllIllllI = EnumFacing.WEST;
                }
            }
            llllllllllllIIlllIIlIlIIllIllIIl.setBlockState(llllllllllllIIlllIIlIlIIlllIIIII, llllllllllllIIlllIIlIlIIllIlllll.withProperty((IProperty<Comparable>)BlockDispenser.FACING, llllllllllllIIlllIIlIlIIllIllllI).withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, false), 2);
        }
    }
    
    @Override
    public int tickRate(final World llllllllllllIIlllIIlIlIIllllIlll) {
        return 4;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIlllIIlIlIIIIlIllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockDispenser.FACING, EnumFacing.getFront(llllllllllllIIlllIIlIlIIIIlIllll & 0x7)).withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, (llllllllllllIIlllIIlIlIIIIlIllll & 0x8) > 0);
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIIlllIIlIlIIllIIIIlI, final BlockPos llllllllllllIIlllIIlIlIIllIIIIIl, final IBlockState llllllllllllIIlllIIlIlIIllIIlIlI, final EntityPlayer llllllllllllIIlllIIlIlIIllIIlIIl, final EnumHand llllllllllllIIlllIIlIlIIllIIlIII, final EnumFacing llllllllllllIIlllIIlIlIIllIIIlll, final float llllllllllllIIlllIIlIlIIllIIIllI, final float llllllllllllIIlllIIlIlIIllIIIlIl, final float llllllllllllIIlllIIlIlIIllIIIlII) {
        if (llllllllllllIIlllIIlIlIIllIIIIlI.isRemote) {
            return true;
        }
        final TileEntity llllllllllllIIlllIIlIlIIllIIIIll = llllllllllllIIlllIIlIlIIllIIIIlI.getTileEntity(llllllllllllIIlllIIlIlIIllIIIIIl);
        if (llllllllllllIIlllIIlIlIIllIIIIll instanceof TileEntityDispenser) {
            llllllllllllIIlllIIlIlIIllIIlIIl.displayGUIChest((IInventory)llllllllllllIIlllIIlIlIIllIIIIll);
            if (llllllllllllIIlllIIlIlIIllIIIIll instanceof TileEntityDropper) {
                llllllllllllIIlllIIlIlIIllIIlIIl.addStat(StatList.DROPPER_INSPECTED);
            }
            else {
                llllllllllllIIlllIIlIlIIllIIlIIl.addStat(StatList.DISPENSER_INSPECTED);
            }
        }
        return true;
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllIIlllIIlIlIIIllIIlII, final BlockPos llllllllllllIIlllIIlIlIIIllIIIll, final IBlockState llllllllllllIIlllIIlIlIIIllIIIlI, final EntityLivingBase llllllllllllIIlllIIlIlIIIllIIIIl, final ItemStack llllllllllllIIlllIIlIlIIIllIIIII) {
        llllllllllllIIlllIIlIlIIIllIIlII.setBlockState(llllllllllllIIlllIIlIlIIIllIIIll, llllllllllllIIlllIIlIlIIIllIIIlI.withProperty((IProperty<Comparable>)BlockDispenser.FACING, EnumFacing.func_190914_a(llllllllllllIIlllIIlIlIIIllIIIll, llllllllllllIIlllIIlIlIIIllIIIIl)), 2);
        if (llllllllllllIIlllIIlIlIIIllIIIII.hasDisplayName()) {
            final TileEntity llllllllllllIIlllIIlIlIIIllIIlIl = llllllllllllIIlllIIlIlIIIllIIlII.getTileEntity(llllllllllllIIlllIIlIlIIIllIIIll);
            if (llllllllllllIIlllIIlIlIIIllIIlIl instanceof TileEntityDispenser) {
                ((TileEntityDispenser)llllllllllllIIlllIIlIlIIIllIIlIl).func_190575_a(llllllllllllIIlllIIlIlIIIllIIIII.getDisplayName());
            }
        }
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllIIlllIIlIlIIIIllIlIl) {
        return EnumBlockRenderType.MODEL;
    }
    
    protected void dispense(final World llllllllllllIIlllIIlIlIIlIlIllIl, final BlockPos llllllllllllIIlllIIlIlIIlIlIllII) {
        final BlockSourceImpl llllllllllllIIlllIIlIlIIlIllIIll = new BlockSourceImpl(llllllllllllIIlllIIlIlIIlIlIllIl, llllllllllllIIlllIIlIlIIlIlIllII);
        final TileEntityDispenser llllllllllllIIlllIIlIlIIlIllIIlI = llllllllllllIIlllIIlIlIIlIllIIll.getBlockTileEntity();
        if (llllllllllllIIlllIIlIlIIlIllIIlI != null) {
            final int llllllllllllIIlllIIlIlIIlIllIIIl = llllllllllllIIlllIIlIlIIlIllIIlI.getDispenseSlot();
            if (llllllllllllIIlllIIlIlIIlIllIIIl < 0) {
                llllllllllllIIlllIIlIlIIlIlIllIl.playEvent(1001, llllllllllllIIlllIIlIlIIlIlIllII, 0);
            }
            else {
                final ItemStack llllllllllllIIlllIIlIlIIlIllIIII = llllllllllllIIlllIIlIlIIlIllIIlI.getStackInSlot(llllllllllllIIlllIIlIlIIlIllIIIl);
                final IBehaviorDispenseItem llllllllllllIIlllIIlIlIIlIlIllll = this.getBehavior(llllllllllllIIlllIIlIlIIlIllIIII);
                if (llllllllllllIIlllIIlIlIIlIlIllll != IBehaviorDispenseItem.DEFAULT_BEHAVIOR) {
                    llllllllllllIIlllIIlIlIIlIllIIlI.setInventorySlotContents(llllllllllllIIlllIIlIlIIlIllIIIl, llllllllllllIIlllIIlIlIIlIlIllll.dispense(llllllllllllIIlllIIlIlIIlIllIIll, llllllllllllIIlllIIlIlIIlIllIIII));
                }
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDispenser.FACING, BlockDispenser.TRIGGERED });
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIlllIIlIlIIIIlIlIll) {
        int llllllllllllIIlllIIlIlIIIIlIlIlI = 0;
        llllllllllllIIlllIIlIlIIIIlIlIlI |= llllllllllllIIlllIIlIlIIIIlIlIll.getValue((IProperty<EnumFacing>)BlockDispenser.FACING).getIndex();
        if (llllllllllllIIlllIIlIlIIIIlIlIll.getValue((IProperty<Boolean>)BlockDispenser.TRIGGERED)) {
            llllllllllllIIlllIIlIlIIIIlIlIlI |= 0x8;
        }
        return llllllllllllIIlllIIlIlIIIIlIlIlI;
    }
    
    protected BlockDispenser() {
        super(Material.ROCK);
        this.rand = new Random();
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockDispenser.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllIIlllIIlIlIIlIIIIIlI, final int llllllllllllIIlllIIlIlIIlIIIIIIl) {
        return new TileEntityDispenser();
    }
    
    static {
        FACING = BlockDirectional.FACING;
        TRIGGERED = PropertyBool.create("triggered");
        DISPENSE_BEHAVIOR_REGISTRY = new RegistryDefaulted<Item, IBehaviorDispenseItem>(new BehaviorDefaultDispenseItem());
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState llllllllllllIIlllIIlIlIIIIlllIll, final World llllllllllllIIlllIIlIlIIIIlllIlI, final BlockPos llllllllllllIIlllIIlIlIIIIllIlll) {
        return Container.calcRedstone(llllllllllllIIlllIIlIlIIIIlllIlI.getTileEntity(llllllllllllIIlllIIlIlIIIIllIlll));
    }
}
