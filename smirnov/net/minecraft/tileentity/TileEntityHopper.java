// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import javax.annotation.Nullable;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.block.BlockHopper;
import java.util.List;
import net.minecraft.block.Block;
import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.BlockChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.inventory.ContainerHopper;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ITickable;

public class TileEntityHopper extends TileEntityLockableLoot implements ITickable, IHopper
{
    private /* synthetic */ int transferCooldown;
    private /* synthetic */ long field_190578_g;
    private /* synthetic */ NonNullList<ItemStack> inventory;
    
    private static ItemStack insertStack(final IInventory lllllllllllIIIlIlIIIIlIlllIllIIl, final IInventory lllllllllllIIIlIlIIIIlIlllIIlIll, ItemStack lllllllllllIIIlIlIIIIlIlllIIlIlI, final int lllllllllllIIIlIlIIIIlIlllIIlIIl, final EnumFacing lllllllllllIIIlIlIIIIlIlllIIlIII) {
        final ItemStack lllllllllllIIIlIlIIIIlIlllIlIlII = lllllllllllIIIlIlIIIIlIlllIIlIll.getStackInSlot(lllllllllllIIIlIlIIIIlIlllIIlIIl);
        if (canInsertItemInSlot(lllllllllllIIIlIlIIIIlIlllIIlIll, lllllllllllIIIlIlIIIIlIlllIIlIlI, lllllllllllIIIlIlIIIIlIlllIIlIIl, lllllllllllIIIlIlIIIIlIlllIIlIII)) {
            boolean lllllllllllIIIlIlIIIIlIlllIlIIll = false;
            final boolean lllllllllllIIIlIlIIIIlIlllIlIIlI = lllllllllllIIIlIlIIIIlIlllIIlIll.func_191420_l();
            if (lllllllllllIIIlIlIIIIlIlllIlIlII.func_190926_b()) {
                lllllllllllIIIlIlIIIIlIlllIIlIll.setInventorySlotContents(lllllllllllIIIlIlIIIIlIlllIIlIIl, lllllllllllIIIlIlIIIIlIlllIIlIlI);
                lllllllllllIIIlIlIIIIlIlllIIlIlI = ItemStack.field_190927_a;
                lllllllllllIIIlIlIIIIlIlllIlIIll = true;
            }
            else if (canCombine(lllllllllllIIIlIlIIIIlIlllIlIlII, lllllllllllIIIlIlIIIIlIlllIIlIlI)) {
                final int lllllllllllIIIlIlIIIIlIlllIlIIIl = lllllllllllIIIlIlIIIIlIlllIIlIlI.getMaxStackSize() - lllllllllllIIIlIlIIIIlIlllIlIlII.func_190916_E();
                final int lllllllllllIIIlIlIIIIlIlllIlIIII = Math.min(lllllllllllIIIlIlIIIIlIlllIIlIlI.func_190916_E(), lllllllllllIIIlIlIIIIlIlllIlIIIl);
                lllllllllllIIIlIlIIIIlIlllIIlIlI.func_190918_g(lllllllllllIIIlIlIIIIlIlllIlIIII);
                lllllllllllIIIlIlIIIIlIlllIlIlII.func_190917_f(lllllllllllIIIlIlIIIIlIlllIlIIII);
                lllllllllllIIIlIlIIIIlIlllIlIIll = (lllllllllllIIIlIlIIIIlIlllIlIIII > 0);
            }
            if (lllllllllllIIIlIlIIIIlIlllIlIIll) {
                if (lllllllllllIIIlIlIIIIlIlllIlIIlI && lllllllllllIIIlIlIIIIlIlllIIlIll instanceof TileEntityHopper) {
                    final TileEntityHopper lllllllllllIIIlIlIIIIlIlllIIllll = (TileEntityHopper)lllllllllllIIIlIlIIIIlIlllIIlIll;
                    if (!lllllllllllIIIlIlIIIIlIlllIIllll.mayTransfer()) {
                        int lllllllllllIIIlIlIIIIlIlllIIlllI = 0;
                        if (lllllllllllIIIlIlIIIIlIlllIllIIl != null && lllllllllllIIIlIlIIIIlIlllIllIIl instanceof TileEntityHopper) {
                            final TileEntityHopper lllllllllllIIIlIlIIIIlIlllIIllIl = (TileEntityHopper)lllllllllllIIIlIlIIIIlIlllIllIIl;
                            if (lllllllllllIIIlIlIIIIlIlllIIllll.field_190578_g >= lllllllllllIIIlIlIIIIlIlllIIllIl.field_190578_g) {
                                lllllllllllIIIlIlIIIIlIlllIIlllI = 1;
                            }
                        }
                        lllllllllllIIIlIlIIIIlIlllIIllll.setTransferCooldown(8 - lllllllllllIIIlIlIIIIlIlllIIlllI);
                    }
                }
                lllllllllllIIIlIlIIIIlIlllIIlIll.markDirty();
            }
        }
        return lllllllllllIIIlIlIIIIlIlllIIlIlI;
    }
    
    @Override
    public double getXPos() {
        return this.pos.getX() + 0.5;
    }
    
    @Override
    public double getZPos() {
        return this.pos.getZ() + 0.5;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIIIlIlIIIIllIllIlIlIl) {
        super.writeToNBT(lllllllllllIIIlIlIIIIllIllIlIlIl);
        if (!this.checkLootAndWrite(lllllllllllIIIlIlIIIIllIllIlIlIl)) {
            ItemStackHelper.func_191282_a(lllllllllllIIIlIlIIIIllIllIlIlIl, this.inventory);
        }
        lllllllllllIIIlIlIIIIllIllIlIlIl.setInteger("TransferCooldown", this.transferCooldown);
        if (this.hasCustomName()) {
            lllllllllllIIIlIlIIIIllIllIlIlIl.setString("CustomName", this.field_190577_o);
        }
        return lllllllllllIIIlIlIIIIllIllIlIlIl;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllIIIlIlIIIIlIlIllIIlll, final EntityPlayer lllllllllllIIIlIlIIIIlIlIllIlIIl) {
        this.fillWithLoot(lllllllllllIIIlIlIIIIlIlIllIlIIl);
        return new ContainerHopper(lllllllllllIIIlIlIIIIlIlIllIIlll, this, lllllllllllIIIlIlIIIIlIlIllIlIIl);
    }
    
    public static IInventory getInventoryAtPosition(final World lllllllllllIIIlIlIIIIlIllIlIIIIl, final double lllllllllllIIIlIlIIIIlIllIIlIlII, final double lllllllllllIIIlIlIIIIlIllIIlIIll, final double lllllllllllIIIlIlIIIIlIllIIlIIlI) {
        IInventory lllllllllllIIIlIlIIIIlIllIIlllIl = null;
        final int lllllllllllIIIlIlIIIIlIllIIlllII = MathHelper.floor(lllllllllllIIIlIlIIIIlIllIIlIlII);
        final int lllllllllllIIIlIlIIIIlIllIIllIll = MathHelper.floor(lllllllllllIIIlIlIIIIlIllIIlIIll);
        final int lllllllllllIIIlIlIIIIlIllIIllIlI = MathHelper.floor(lllllllllllIIIlIlIIIIlIllIIlIIlI);
        final BlockPos lllllllllllIIIlIlIIIIlIllIIllIIl = new BlockPos(lllllllllllIIIlIlIIIIlIllIIlllII, lllllllllllIIIlIlIIIIlIllIIllIll, lllllllllllIIIlIlIIIIlIllIIllIlI);
        final Block lllllllllllIIIlIlIIIIlIllIIllIII = lllllllllllIIIlIlIIIIlIllIlIIIIl.getBlockState(lllllllllllIIIlIlIIIIlIllIIllIIl).getBlock();
        if (lllllllllllIIIlIlIIIIlIllIIllIII.hasTileEntity()) {
            final TileEntity lllllllllllIIIlIlIIIIlIllIIlIlll = lllllllllllIIIlIlIIIIlIllIlIIIIl.getTileEntity(lllllllllllIIIlIlIIIIlIllIIllIIl);
            if (lllllllllllIIIlIlIIIIlIllIIlIlll instanceof IInventory) {
                lllllllllllIIIlIlIIIIlIllIIlllIl = (IInventory)lllllllllllIIIlIlIIIIlIllIIlIlll;
                if (lllllllllllIIIlIlIIIIlIllIIlllIl instanceof TileEntityChest && lllllllllllIIIlIlIIIIlIllIIllIII instanceof BlockChest) {
                    lllllllllllIIIlIlIIIIlIllIIlllIl = ((BlockChest)lllllllllllIIIlIlIIIIlIllIIllIII).getContainer(lllllllllllIIIlIlIIIIlIllIlIIIIl, lllllllllllIIIlIlIIIIlIllIIllIIl, true);
                }
            }
        }
        if (lllllllllllIIIlIlIIIIlIllIIlllIl == null) {
            final List<Entity> lllllllllllIIIlIlIIIIlIllIIlIllI = lllllllllllIIIlIlIIIIlIllIlIIIIl.getEntitiesInAABBexcluding(null, new AxisAlignedBB(lllllllllllIIIlIlIIIIlIllIIlIlII - 0.5, lllllllllllIIIlIlIIIIlIllIIlIIll - 0.5, lllllllllllIIIlIlIIIIlIllIIlIIlI - 0.5, lllllllllllIIIlIlIIIIlIllIIlIlII + 0.5, lllllllllllIIIlIlIIIIlIllIIlIIll + 0.5, lllllllllllIIIlIlIIIIlIllIIlIIlI + 0.5), EntitySelectors.HAS_INVENTORY);
            if (!lllllllllllIIIlIlIIIIlIllIIlIllI.isEmpty()) {
                lllllllllllIIIlIlIIIIlIllIIlllIl = (IInventory)lllllllllllIIIlIlIIIIlIllIIlIllI.get(lllllllllllIIIlIlIIIIlIllIlIIIIl.rand.nextInt(lllllllllllIIIlIlIIIIlIllIIlIllI.size()));
            }
        }
        return lllllllllllIIIlIlIIIIlIllIIlllIl;
    }
    
    @Override
    public boolean func_191420_l() {
        return this.isEmpty();
    }
    
    private IInventory getInventoryForHopperTransfer() {
        final EnumFacing lllllllllllIIIlIlIIIIlIllIlllllI = BlockHopper.getFacing(this.getBlockMetadata());
        return getInventoryAtPosition(this.getWorld(), this.getXPos() + lllllllllllIIIlIlIIIIlIllIlllllI.getFrontOffsetX(), this.getYPos() + lllllllllllIIIlIlIIIIlIllIlllllI.getFrontOffsetY(), this.getZPos() + lllllllllllIIIlIlIIIIlIllIlllllI.getFrontOffsetZ());
    }
    
    private boolean mayTransfer() {
        return this.transferCooldown > 8;
    }
    
    private boolean updateHopper() {
        if (this.world != null && !this.world.isRemote) {
            if (!this.isOnTransferCooldown() && BlockHopper.isEnabled(this.getBlockMetadata())) {
                boolean lllllllllllIIIlIlIIIIllIlIllIIII = false;
                if (!this.isEmpty()) {
                    lllllllllllIIIlIlIIIIllIlIllIIII = this.transferItemsOut();
                }
                if (!this.isFull()) {
                    lllllllllllIIIlIlIIIIllIlIllIIII = (captureDroppedItems(this) || lllllllllllIIIlIlIIIIllIlIllIIII);
                }
                if (lllllllllllIIIlIlIIIIllIlIllIIII) {
                    this.setTransferCooldown(8);
                    this.markDirty();
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    public static IInventory getHopperInventory(final IHopper lllllllllllIIIlIlIIIIlIllIlllIIl) {
        return getInventoryAtPosition(lllllllllllIIIlIlIIIIlIllIlllIIl.getWorld(), lllllllllllIIIlIlIIIIlIllIlllIIl.getXPos(), lllllllllllIIIlIlIIIIlIllIlllIIl.getYPos() + 1.0, lllllllllllIIIlIlIIIIlIllIlllIIl.getZPos());
    }
    
    @Override
    public double getYPos() {
        return this.pos.getY() + 0.5;
    }
    
    public static boolean putDropInInventoryAllSlots(final IInventory lllllllllllIIIlIlIIIIllIIIIllIIl, final IInventory lllllllllllIIIlIlIIIIllIIIIllIII, final EntityItem lllllllllllIIIlIlIIIIllIIIIlllIl) {
        boolean lllllllllllIIIlIlIIIIllIIIIlllII = false;
        if (lllllllllllIIIlIlIIIIllIIIIlllIl == null) {
            return false;
        }
        final ItemStack lllllllllllIIIlIlIIIIllIIIIllIll = lllllllllllIIIlIlIIIIllIIIIlllIl.getEntityItem().copy();
        final ItemStack lllllllllllIIIlIlIIIIllIIIIllIlI = putStackInInventoryAllSlots(lllllllllllIIIlIlIIIIllIIIIllIIl, lllllllllllIIIlIlIIIIllIIIIllIII, lllllllllllIIIlIlIIIIllIIIIllIll, null);
        if (lllllllllllIIIlIlIIIIllIIIIllIlI.func_190926_b()) {
            lllllllllllIIIlIlIIIIllIIIIlllII = true;
            lllllllllllIIIlIlIIIIllIIIIlllIl.setDead();
        }
        else {
            lllllllllllIIIlIlIIIIllIIIIlllIl.setEntityItemStack(lllllllllllIIIlIlIIIIllIIIIllIlI);
        }
        return lllllllllllIIIlIlIIIIllIIIIlllII;
    }
    
    @Override
    protected NonNullList<ItemStack> func_190576_q() {
        return this.inventory;
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllIIIlIlIIIIllIlIllllll, final ItemStack lllllllllllIIIlIlIIIIllIlIlllIll) {
        this.fillWithLoot(null);
        this.func_190576_q().set(lllllllllllIIIlIlIIIIllIlIllllll, lllllllllllIIIlIlIIIIllIlIlllIll);
        if (lllllllllllIIIlIlIIIIllIlIlllIll.func_190916_E() > this.getInventoryStackLimit()) {
            lllllllllllIIIlIlIIIIllIlIlllIll.func_190920_e(this.getInventoryStackLimit());
        }
    }
    
    public static boolean captureDroppedItems(final IHopper lllllllllllIIIlIlIIIIllIIlIIIIll) {
        final IInventory lllllllllllIIIlIlIIIIllIIlIIlIll = getHopperInventory(lllllllllllIIIlIlIIIIllIIlIIIIll);
        if (lllllllllllIIIlIlIIIIllIIlIIlIll != null) {
            final EnumFacing lllllllllllIIIlIlIIIIllIIlIIlIlI = EnumFacing.DOWN;
            if (isInventoryEmpty(lllllllllllIIIlIlIIIIllIIlIIlIll, lllllllllllIIIlIlIIIIllIIlIIlIlI)) {
                return false;
            }
            if (lllllllllllIIIlIlIIIIllIIlIIlIll instanceof ISidedInventory) {
                final ISidedInventory lllllllllllIIIlIlIIIIllIIlIIlIIl = (ISidedInventory)lllllllllllIIIlIlIIIIllIIlIIlIll;
                final int[] lllllllllllIIIlIlIIIIllIIlIIlIII = lllllllllllIIIlIlIIIIllIIlIIlIIl.getSlotsForFace(lllllllllllIIIlIlIIIIllIIlIIlIlI);
                final byte lllllllllllIIIlIlIIIIllIIIlllIll;
                final double lllllllllllIIIlIlIIIIllIIIllllII = ((int[])(Object)(lllllllllllIIIlIlIIIIllIIIlllIll = (byte)(Object)lllllllllllIIIlIlIIIIllIIlIIlIII)).length;
                for (byte lllllllllllIIIlIlIIIIllIIIllllIl = 0; lllllllllllIIIlIlIIIIllIIIllllIl < lllllllllllIIIlIlIIIIllIIIllllII; ++lllllllllllIIIlIlIIIIllIIIllllIl) {
                    final int lllllllllllIIIlIlIIIIllIIlIIIlll = lllllllllllIIIlIlIIIIllIIIlllIll[lllllllllllIIIlIlIIIIllIIIllllIl];
                    if (pullItemFromSlot(lllllllllllIIIlIlIIIIllIIlIIIIll, lllllllllllIIIlIlIIIIllIIlIIlIll, lllllllllllIIIlIlIIIIllIIlIIIlll, lllllllllllIIIlIlIIIIllIIlIIlIlI)) {
                        return true;
                    }
                }
            }
            else {
                for (int lllllllllllIIIlIlIIIIllIIlIIIllI = lllllllllllIIIlIlIIIIllIIlIIlIll.getSizeInventory(), lllllllllllIIIlIlIIIIllIIlIIIlIl = 0; lllllllllllIIIlIlIIIIllIIlIIIlIl < lllllllllllIIIlIlIIIIllIIlIIIllI; ++lllllllllllIIIlIlIIIIllIIlIIIlIl) {
                    if (pullItemFromSlot(lllllllllllIIIlIlIIIIllIIlIIIIll, lllllllllllIIIlIlIIIIllIIlIIlIll, lllllllllllIIIlIlIIIIllIIlIIIlIl, lllllllllllIIIlIlIIIIllIIlIIlIlI)) {
                        return true;
                    }
                }
            }
        }
        else {
            for (final EntityItem lllllllllllIIIlIlIIIIllIIlIIIlII : getCaptureItems(lllllllllllIIIlIlIIIIllIIlIIIIll.getWorld(), lllllllllllIIIlIlIIIIllIIlIIIIll.getXPos(), lllllllllllIIIlIlIIIIllIIlIIIIll.getYPos(), lllllllllllIIIlIlIIIIllIIlIIIIll.getZPos())) {
                if (putDropInInventoryAllSlots(null, lllllllllllIIIlIlIIIIllIIlIIIIll, lllllllllllIIIlIlIIIIllIIlIIIlII)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void setTransferCooldown(final int lllllllllllIIIlIlIIIIlIlIlllIllI) {
        this.transferCooldown = lllllllllllIIIlIlIIIIlIlIlllIllI;
    }
    
    private boolean transferItemsOut() {
        final IInventory lllllllllllIIIlIlIIIIllIlIIlIIll = this.getInventoryForHopperTransfer();
        if (lllllllllllIIIlIlIIIIllIlIIlIIll == null) {
            return false;
        }
        final EnumFacing lllllllllllIIIlIlIIIIllIlIIlIIlI = BlockHopper.getFacing(this.getBlockMetadata()).getOpposite();
        if (this.isInventoryFull(lllllllllllIIIlIlIIIIllIlIIlIIll, lllllllllllIIIlIlIIIIllIlIIlIIlI)) {
            return false;
        }
        for (int lllllllllllIIIlIlIIIIllIlIIlIIIl = 0; lllllllllllIIIlIlIIIIllIlIIlIIIl < this.getSizeInventory(); ++lllllllllllIIIlIlIIIIllIlIIlIIIl) {
            if (!this.getStackInSlot(lllllllllllIIIlIlIIIIllIlIIlIIIl).func_190926_b()) {
                final ItemStack lllllllllllIIIlIlIIIIllIlIIlIIII = this.getStackInSlot(lllllllllllIIIlIlIIIIllIlIIlIIIl).copy();
                final ItemStack lllllllllllIIIlIlIIIIllIlIIIllll = putStackInInventoryAllSlots(this, lllllllllllIIIlIlIIIIllIlIIlIIll, this.decrStackSize(lllllllllllIIIlIlIIIIllIlIIlIIIl, 1), lllllllllllIIIlIlIIIIllIlIIlIIlI);
                if (lllllllllllIIIlIlIIIIllIlIIIllll.func_190926_b()) {
                    lllllllllllIIIlIlIIIIllIlIIlIIll.markDirty();
                    return true;
                }
                this.setInventorySlotContents(lllllllllllIIIlIlIIIIllIlIIlIIIl, lllllllllllIIIlIlIIIIllIlIIlIIII);
            }
        }
        return false;
    }
    
    @Override
    public int getSizeInventory() {
        return this.inventory.size();
    }
    
    private static boolean canCombine(final ItemStack lllllllllllIIIlIlIIIIlIllIIIlIII, final ItemStack lllllllllllIIIlIlIIIIlIllIIIIlIl) {
        return lllllllllllIIIlIlIIIIlIllIIIlIII.getItem() == lllllllllllIIIlIlIIIIlIllIIIIlIl.getItem() && lllllllllllIIIlIlIIIIlIllIIIlIII.getMetadata() == lllllllllllIIIlIlIIIIlIllIIIIlIl.getMetadata() && lllllllllllIIIlIlIIIIlIllIIIlIII.func_190916_E() <= lllllllllllIIIlIlIIIIlIllIIIlIII.getMaxStackSize() && ItemStack.areItemStackTagsEqual(lllllllllllIIIlIlIIIIlIllIIIlIII, lllllllllllIIIlIlIIIIlIllIIIIlIl);
    }
    
    @Override
    public void update() {
        if (this.world != null && !this.world.isRemote) {
            --this.transferCooldown;
            this.field_190578_g = this.world.getTotalWorldTime();
            if (!this.isOnTransferCooldown()) {
                this.setTransferCooldown(0);
                this.updateHopper();
            }
        }
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIIIlIlIIIIllIllIllIll) {
        super.readFromNBT(lllllllllllIIIlIlIIIIllIllIllIll);
        this.inventory = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        if (!this.checkLootAndRead(lllllllllllIIIlIlIIIIllIllIllIll)) {
            ItemStackHelper.func_191283_b(lllllllllllIIIlIlIIIIllIllIllIll, this.inventory);
        }
        if (lllllllllllIIIlIlIIIIllIllIllIll.hasKey("CustomName", 8)) {
            this.field_190577_o = lllllllllllIIIlIlIIIIllIllIllIll.getString("CustomName");
        }
        this.transferCooldown = lllllllllllIIIlIlIIIIllIllIllIll.getInteger("TransferCooldown");
    }
    
    private static boolean isInventoryEmpty(final IInventory lllllllllllIIIlIlIIIIllIIllIIlII, final EnumFacing lllllllllllIIIlIlIIIIllIIlIlllII) {
        if (lllllllllllIIIlIlIIIIllIIllIIlII instanceof ISidedInventory) {
            final ISidedInventory lllllllllllIIIlIlIIIIllIIllIIIlI = (ISidedInventory)lllllllllllIIIlIlIIIIllIIllIIlII;
            final int[] lllllllllllIIIlIlIIIIllIIllIIIIl = lllllllllllIIIlIlIIIIllIIllIIIlI.getSlotsForFace(lllllllllllIIIlIlIIIIllIIlIlllII);
            final boolean lllllllllllIIIlIlIIIIllIIlIlIllI;
            final float lllllllllllIIIlIlIIIIllIIlIlIlll = ((int[])(Object)(lllllllllllIIIlIlIIIIllIIlIlIllI = (boolean)(Object)lllllllllllIIIlIlIIIIllIIllIIIIl)).length;
            for (Exception lllllllllllIIIlIlIIIIllIIlIllIII = (Exception)0; lllllllllllIIIlIlIIIIllIIlIllIII < lllllllllllIIIlIlIIIIllIIlIlIlll; ++lllllllllllIIIlIlIIIIllIIlIllIII) {
                final int lllllllllllIIIlIlIIIIllIIllIIIII = lllllllllllIIIlIlIIIIllIIlIlIllI[lllllllllllIIIlIlIIIIllIIlIllIII];
                if (!lllllllllllIIIlIlIIIIllIIllIIIlI.getStackInSlot(lllllllllllIIIlIlIIIIllIIllIIIII).func_190926_b()) {
                    return false;
                }
            }
        }
        else {
            for (int lllllllllllIIIlIlIIIIllIIlIlllll = lllllllllllIIIlIlIIIIllIIllIIlII.getSizeInventory(), lllllllllllIIIlIlIIIIllIIlIllllI = 0; lllllllllllIIIlIlIIIIllIIlIllllI < lllllllllllIIIlIlIIIIllIIlIlllll; ++lllllllllllIIIlIlIIIIllIIlIllllI) {
                if (!lllllllllllIIIlIlIIIIllIIllIIlII.getStackInSlot(lllllllllllIIIlIlIIIIllIIlIllllI).func_190926_b()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static ItemStack putStackInInventoryAllSlots(final IInventory lllllllllllIIIlIlIIIIllIIIIIIIll, final IInventory lllllllllllIIIlIlIIIIllIIIIIlIll, ItemStack lllllllllllIIIlIlIIIIllIIIIIIIIl, @Nullable final EnumFacing lllllllllllIIIlIlIIIIllIIIIIlIIl) {
        if (lllllllllllIIIlIlIIIIllIIIIIlIll instanceof ISidedInventory && lllllllllllIIIlIlIIIIllIIIIIlIIl != null) {
            final ISidedInventory lllllllllllIIIlIlIIIIllIIIIIlIII = (ISidedInventory)lllllllllllIIIlIlIIIIllIIIIIlIll;
            final int[] lllllllllllIIIlIlIIIIllIIIIIIlll = lllllllllllIIIlIlIIIIllIIIIIlIII.getSlotsForFace(lllllllllllIIIlIlIIIIllIIIIIlIIl);
            for (int lllllllllllIIIlIlIIIIllIIIIIIllI = 0; lllllllllllIIIlIlIIIIllIIIIIIllI < lllllllllllIIIlIlIIIIllIIIIIIlll.length; ++lllllllllllIIIlIlIIIIllIIIIIIllI) {
                if (lllllllllllIIIlIlIIIIllIIIIIIIIl.func_190926_b()) {
                    break;
                }
                lllllllllllIIIlIlIIIIllIIIIIIIIl = insertStack(lllllllllllIIIlIlIIIIllIIIIIIIll, lllllllllllIIIlIlIIIIllIIIIIlIll, lllllllllllIIIlIlIIIIllIIIIIIIIl, lllllllllllIIIlIlIIIIllIIIIIIlll[lllllllllllIIIlIlIIIIllIIIIIIllI], lllllllllllIIIlIlIIIIllIIIIIlIIl);
            }
        }
        else {
            for (int lllllllllllIIIlIlIIIIllIIIIIIlIl = lllllllllllIIIlIlIIIIllIIIIIlIll.getSizeInventory(), lllllllllllIIIlIlIIIIllIIIIIIlII = 0; lllllllllllIIIlIlIIIIllIIIIIIlII < lllllllllllIIIlIlIIIIllIIIIIIlIl && !lllllllllllIIIlIlIIIIllIIIIIIIIl.func_190926_b(); lllllllllllIIIlIlIIIIllIIIIIIIIl = insertStack(lllllllllllIIIlIlIIIIllIIIIIIIll, lllllllllllIIIlIlIIIIllIIIIIlIll, lllllllllllIIIlIlIIIIllIIIIIIIIl, lllllllllllIIIlIlIIIIllIIIIIIlII, lllllllllllIIIlIlIIIIllIIIIIlIIl), ++lllllllllllIIIlIlIIIIllIIIIIIlII) {}
        }
        return lllllllllllIIIlIlIIIIllIIIIIIIIl;
    }
    
    private boolean isEmpty() {
        for (final ItemStack lllllllllllIIIlIlIIIIllIlIlIlIIl : this.inventory) {
            if (!lllllllllllIIIlIlIIIIllIlIlIlIIl.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean canInsertItemInSlot(final IInventory lllllllllllIIIlIlIIIIlIlllllIlII, final ItemStack lllllllllllIIIlIlIIIIlIlllllIlll, final int lllllllllllIIIlIlIIIIlIlllllIIlI, final EnumFacing lllllllllllIIIlIlIIIIlIlllllIlIl) {
        return lllllllllllIIIlIlIIIIlIlllllIlII.isItemValidForSlot(lllllllllllIIIlIlIIIIlIlllllIIlI, lllllllllllIIIlIlIIIIlIlllllIlll) && (!(lllllllllllIIIlIlIIIIlIlllllIlII instanceof ISidedInventory) || ((ISidedInventory)lllllllllllIIIlIlIIIIlIlllllIlII).canInsertItem(lllllllllllIIIlIlIIIIlIlllllIIlI, lllllllllllIIIlIlIIIIlIlllllIlll, lllllllllllIIIlIlIIIIlIlllllIlIl));
    }
    
    private boolean isOnTransferCooldown() {
        return this.transferCooldown > 0;
    }
    
    private boolean isFull() {
        for (final ItemStack lllllllllllIIIlIlIIIIllIlIIllllI : this.inventory) {
            if (lllllllllllIIIlIlIIIIllIlIIllllI.func_190926_b() || lllllllllllIIIlIlIIIIllIlIIllllI.func_190916_E() != lllllllllllIIIlIlIIIIllIlIIllllI.getMaxStackSize()) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isInventoryFull(final IInventory lllllllllllIIIlIlIIIIllIIlllIlIl, final EnumFacing lllllllllllIIIlIlIIIIllIIlllllIl) {
        if (lllllllllllIIIlIlIIIIllIIlllIlIl instanceof ISidedInventory) {
            final ISidedInventory lllllllllllIIIlIlIIIIllIIlllllII = (ISidedInventory)lllllllllllIIIlIlIIIIllIIlllIlIl;
            final int[] lllllllllllIIIlIlIIIIllIIllllIll = lllllllllllIIIlIlIIIIllIIlllllII.getSlotsForFace(lllllllllllIIIlIlIIIIllIIlllllIl);
            byte lllllllllllIIIlIlIIIIllIIllIlllI;
            for (float lllllllllllIIIlIlIIIIllIIllIllll = ((int[])(Object)(lllllllllllIIIlIlIIIIllIIllIlllI = (byte)(Object)lllllllllllIIIlIlIIIIllIIllllIll)).length, lllllllllllIIIlIlIIIIllIIlllIIII = 0; lllllllllllIIIlIlIIIIllIIlllIIII < lllllllllllIIIlIlIIIIllIIllIllll; ++lllllllllllIIIlIlIIIIllIIlllIIII) {
                final int lllllllllllIIIlIlIIIIllIIllllIlI = lllllllllllIIIlIlIIIIllIIllIlllI[lllllllllllIIIlIlIIIIllIIlllIIII];
                final ItemStack lllllllllllIIIlIlIIIIllIIllllIIl = lllllllllllIIIlIlIIIIllIIlllllII.getStackInSlot(lllllllllllIIIlIlIIIIllIIllllIlI);
                if (lllllllllllIIIlIlIIIIllIIllllIIl.func_190926_b() || lllllllllllIIIlIlIIIIllIIllllIIl.func_190916_E() != lllllllllllIIIlIlIIIIllIIllllIIl.getMaxStackSize()) {
                    return false;
                }
            }
        }
        else {
            for (int lllllllllllIIIlIlIIIIllIIllllIII = lllllllllllIIIlIlIIIIllIIlllIlIl.getSizeInventory(), lllllllllllIIIlIlIIIIllIIlllIlll = 0; lllllllllllIIIlIlIIIIllIIlllIlll < lllllllllllIIIlIlIIIIllIIllllIII; ++lllllllllllIIIlIlIIIIllIIlllIlll) {
                final ItemStack lllllllllllIIIlIlIIIIllIIlllIllI = lllllllllllIIIlIlIIIIllIIlllIlIl.getStackInSlot(lllllllllllIIIlIlIIIIllIIlllIlll);
                if (lllllllllllIIIlIlIIIIllIIlllIllI.func_190926_b() || lllllllllllIIIlIlIIIIllIIlllIllI.func_190916_E() != lllllllllllIIIlIlIIIIllIIlllIllI.getMaxStackSize()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.hopper";
    }
    
    public TileEntityHopper() {
        this.inventory = NonNullList.func_191197_a(5, ItemStack.field_190927_a);
        this.transferCooldown = -1;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:hopper";
    }
    
    public static void registerFixesHopper(final DataFixer lllllllllllIIIlIlIIIIllIllIlllll) {
        lllllllllllIIIlIlIIIIllIllIlllll.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityHopper.class, new String[] { "Items" }));
    }
    
    public static List<EntityItem> getCaptureItems(final World lllllllllllIIIlIlIIIIlIllIllIIII, final double lllllllllllIIIlIlIIIIlIllIllIIll, final double lllllllllllIIIlIlIIIIlIllIllIIlI, final double lllllllllllIIIlIlIIIIlIllIlIllIl) {
        return lllllllllllIIIlIlIIIIlIllIllIIII.getEntitiesWithinAABB((Class<? extends EntityItem>)EntityItem.class, new AxisAlignedBB(lllllllllllIIIlIlIIIIlIllIllIIll - 0.5, lllllllllllIIIlIlIIIIlIllIllIIlI, lllllllllllIIIlIlIIIIlIllIlIllIl - 0.5, lllllllllllIIIlIlIIIIlIllIllIIll + 0.5, lllllllllllIIIlIlIIIIlIllIllIIlI + 1.5, lllllllllllIIIlIlIIIIlIllIlIllIl + 0.5), (com.google.common.base.Predicate<? super EntityItem>)EntitySelectors.IS_ALIVE);
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllIIIlIlIIIIllIllIIlIlI, final int lllllllllllIIIlIlIIIIllIllIIIlIl) {
        this.fillWithLoot(null);
        final ItemStack lllllllllllIIIlIlIIIIllIllIIlIII = ItemStackHelper.getAndSplit(this.func_190576_q(), lllllllllllIIIlIlIIIIllIllIIlIlI, lllllllllllIIIlIlIIIIllIllIIIlIl);
        return lllllllllllIIIlIlIIIIllIllIIlIII;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    private static boolean canExtractItemFromSlot(final IInventory lllllllllllIIIlIlIIIIlIllllIllII, final ItemStack lllllllllllIIIlIlIIIIlIllllIlIll, final int lllllllllllIIIlIlIIIIlIllllIlIlI, final EnumFacing lllllllllllIIIlIlIIIIlIllllIlIIl) {
        return !(lllllllllllIIIlIlIIIIlIllllIllII instanceof ISidedInventory) || ((ISidedInventory)lllllllllllIIIlIlIIIIlIllllIllII).canExtractItem(lllllllllllIIIlIlIIIIlIllllIlIlI, lllllllllllIIIlIlIIIIlIllllIlIll, lllllllllllIIIlIlIIIIlIllllIlIIl);
    }
    
    private static boolean pullItemFromSlot(final IHopper lllllllllllIIIlIlIIIIllIIIlIllII, final IInventory lllllllllllIIIlIlIIIIllIIIllIIlI, final int lllllllllllIIIlIlIIIIllIIIllIIIl, final EnumFacing lllllllllllIIIlIlIIIIllIIIlIlIIl) {
        final ItemStack lllllllllllIIIlIlIIIIllIIIlIllll = lllllllllllIIIlIlIIIIllIIIllIIlI.getStackInSlot(lllllllllllIIIlIlIIIIllIIIllIIIl);
        if (!lllllllllllIIIlIlIIIIllIIIlIllll.func_190926_b() && canExtractItemFromSlot(lllllllllllIIIlIlIIIIllIIIllIIlI, lllllllllllIIIlIlIIIIllIIIlIllll, lllllllllllIIIlIlIIIIllIIIllIIIl, lllllllllllIIIlIlIIIIllIIIlIlIIl)) {
            final ItemStack lllllllllllIIIlIlIIIIllIIIlIlllI = lllllllllllIIIlIlIIIIllIIIlIllll.copy();
            final ItemStack lllllllllllIIIlIlIIIIllIIIlIllIl = putStackInInventoryAllSlots(lllllllllllIIIlIlIIIIllIIIllIIlI, lllllllllllIIIlIlIIIIllIIIlIllII, lllllllllllIIIlIlIIIIllIIIllIIlI.decrStackSize(lllllllllllIIIlIlIIIIllIIIllIIIl, 1), null);
            if (lllllllllllIIIlIlIIIIllIIIlIllIl.func_190926_b()) {
                lllllllllllIIIlIlIIIIllIIIllIIlI.markDirty();
                return true;
            }
            lllllllllllIIIlIlIIIIllIIIllIIlI.setInventorySlotContents(lllllllllllIIIlIlIIIIllIIIllIIIl, lllllllllllIIIlIlIIIIllIIIlIlllI);
        }
        return false;
    }
}
