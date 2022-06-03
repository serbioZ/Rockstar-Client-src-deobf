// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerBeacon extends Container
{
    private final /* synthetic */ BeaconSlot beaconSlot;
    private final /* synthetic */ IInventory tileBeacon;
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllIlIlIIIIIIlIIIllllllI) {
        super.onContainerClosed(lllllllllllIlIlIIIIIIlIIIllllllI);
        if (!lllllllllllIlIlIIIIIIlIIIllllllI.world.isRemote) {
            final ItemStack lllllllllllIlIlIIIIIIlIIIlllllIl = this.beaconSlot.decrStackSize(this.beaconSlot.getSlotStackLimit());
            if (!lllllllllllIlIlIIIIIIlIIIlllllIl.func_190926_b()) {
                lllllllllllIlIlIIIIIIlIIIllllllI.dropItem(lllllllllllIlIlIIIIIIlIIIlllllIl, false);
            }
        }
    }
    
    public IInventory getTileEntity() {
        return this.tileBeacon;
    }
    
    @Override
    public void updateProgressBar(final int lllllllllllIlIlIIIIIIlIIlIIIlIlI, final int lllllllllllIlIlIIIIIIlIIlIIIlIIl) {
        this.tileBeacon.setField(lllllllllllIlIlIIIIIIlIIlIIIlIlI, lllllllllllIlIlIIIIIIlIIlIIIlIIl);
    }
    
    public ContainerBeacon(final IInventory lllllllllllIlIlIIIIIIlIIlIlIIIlI, final IInventory lllllllllllIlIlIIIIIIlIIlIlIIIIl) {
        this.tileBeacon = lllllllllllIlIlIIIIIIlIIlIlIIIIl;
        this.beaconSlot = new BeaconSlot(lllllllllllIlIlIIIIIIlIIlIlIIIIl, 0, 136, 110);
        this.addSlotToContainer(this.beaconSlot);
        final int lllllllllllIlIlIIIIIIlIIlIlIIIII = 36;
        final int lllllllllllIlIlIIIIIIlIIlIIlllll = 137;
        for (int lllllllllllIlIlIIIIIIlIIlIIllllI = 0; lllllllllllIlIlIIIIIIlIIlIIllllI < 3; ++lllllllllllIlIlIIIIIIlIIlIIllllI) {
            for (int lllllllllllIlIlIIIIIIlIIlIIlllIl = 0; lllllllllllIlIlIIIIIIlIIlIIlllIl < 9; ++lllllllllllIlIlIIIIIIlIIlIIlllIl) {
                this.addSlotToContainer(new Slot(lllllllllllIlIlIIIIIIlIIlIlIIIlI, lllllllllllIlIlIIIIIIlIIlIIlllIl + lllllllllllIlIlIIIIIIlIIlIIllllI * 9 + 9, 36 + lllllllllllIlIlIIIIIIlIIlIIlllIl * 18, 137 + lllllllllllIlIlIIIIIIlIIlIIllllI * 18));
            }
        }
        for (int lllllllllllIlIlIIIIIIlIIlIIlllII = 0; lllllllllllIlIlIIIIIIlIIlIIlllII < 9; ++lllllllllllIlIlIIIIIIlIIlIIlllII) {
            this.addSlotToContainer(new Slot(lllllllllllIlIlIIIIIIlIIlIlIIIlI, lllllllllllIlIlIIIIIIlIIlIIlllII, 36 + lllllllllllIlIlIIIIIIlIIlIIlllII * 18, 195));
        }
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllIlIlIIIIIIlIIIlllIllI) {
        return this.tileBeacon.isUsableByPlayer(lllllllllllIlIlIIIIIIlIIIlllIllI);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllIlIlIIIIIIlIIIllIllII, final int lllllllllllIlIlIIIIIIlIIIllIlIll) {
        ItemStack lllllllllllIlIlIIIIIIlIIIllIlIlI = ItemStack.field_190927_a;
        final Slot lllllllllllIlIlIIIIIIlIIIllIlIIl = this.inventorySlots.get(lllllllllllIlIlIIIIIIlIIIllIlIll);
        if (lllllllllllIlIlIIIIIIlIIIllIlIIl != null && lllllllllllIlIlIIIIIIlIIIllIlIIl.getHasStack()) {
            final ItemStack lllllllllllIlIlIIIIIIlIIIllIlIII = lllllllllllIlIlIIIIIIlIIIllIlIIl.getStack();
            lllllllllllIlIlIIIIIIlIIIllIlIlI = lllllllllllIlIlIIIIIIlIIIllIlIII.copy();
            if (lllllllllllIlIlIIIIIIlIIIllIlIll == 0) {
                if (!this.mergeItemStack(lllllllllllIlIlIIIIIIlIIIllIlIII, 1, 37, true)) {
                    return ItemStack.field_190927_a;
                }
                lllllllllllIlIlIIIIIIlIIIllIlIIl.onSlotChange(lllllllllllIlIlIIIIIIlIIIllIlIII, lllllllllllIlIlIIIIIIlIIIllIlIlI);
            }
            else if (!this.beaconSlot.getHasStack() && this.beaconSlot.isItemValid(lllllllllllIlIlIIIIIIlIIIllIlIII) && lllllllllllIlIlIIIIIIlIIIllIlIII.func_190916_E() == 1) {
                if (!this.mergeItemStack(lllllllllllIlIlIIIIIIlIIIllIlIII, 0, 1, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllIlIlIIIIIIlIIIllIlIll >= 1 && lllllllllllIlIlIIIIIIlIIIllIlIll < 28) {
                if (!this.mergeItemStack(lllllllllllIlIlIIIIIIlIIIllIlIII, 28, 37, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllIlIlIIIIIIlIIIllIlIll >= 28 && lllllllllllIlIlIIIIIIlIIIllIlIll < 37) {
                if (!this.mergeItemStack(lllllllllllIlIlIIIIIIlIIIllIlIII, 1, 28, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllIlIlIIIIIIlIIIllIlIII, 1, 37, false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllIlIlIIIIIIlIIIllIlIII.func_190926_b()) {
                lllllllllllIlIlIIIIIIlIIIllIlIIl.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllIlIlIIIIIIlIIIllIlIIl.onSlotChanged();
            }
            if (lllllllllllIlIlIIIIIIlIIIllIlIII.func_190916_E() == lllllllllllIlIlIIIIIIlIIIllIlIlI.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            lllllllllllIlIlIIIIIIlIIIllIlIIl.func_190901_a(lllllllllllIlIlIIIIIIlIIIllIllII, lllllllllllIlIlIIIIIIlIIIllIlIII);
        }
        return lllllllllllIlIlIIIIIIlIIIllIlIlI;
    }
    
    @Override
    public void addListener(final IContainerListener lllllllllllIlIlIIIIIIlIIlIIlIIIl) {
        super.addListener(lllllllllllIlIlIIIIIIlIIlIIlIIIl);
        lllllllllllIlIlIIIIIIlIIlIIlIIIl.sendAllWindowProperties(this, this.tileBeacon);
    }
    
    class BeaconSlot extends Slot
    {
        @Override
        public boolean isItemValid(final ItemStack llllllllllllIIIIlIllIlIlIlIlllII) {
            final Item llllllllllllIIIIlIllIlIlIlIllIll = llllllllllllIIIIlIllIlIlIlIlllII.getItem();
            return llllllllllllIIIIlIllIlIlIlIllIll == Items.EMERALD || llllllllllllIIIIlIllIlIlIlIllIll == Items.DIAMOND || llllllllllllIIIIlIllIlIlIlIllIll == Items.GOLD_INGOT || llllllllllllIIIIlIllIlIlIlIllIll == Items.IRON_INGOT;
        }
        
        public BeaconSlot(final IInventory llllllllllllIIIIlIllIlIlIllIIIll, final int llllllllllllIIIIlIllIlIlIllIlIII, final int llllllllllllIIIIlIllIlIlIllIIlll, final int llllllllllllIIIIlIllIlIlIllIIllI) {
            super(llllllllllllIIIIlIllIlIlIllIIIll, llllllllllllIIIIlIllIlIlIllIlIII, llllllllllllIIIIlIllIlIlIllIIlll, llllllllllllIIIIlIllIlIlIllIIllI);
        }
        
        @Override
        public int getSlotStackLimit() {
            return 1;
        }
    }
}
