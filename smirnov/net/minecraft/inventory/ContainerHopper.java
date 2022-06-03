// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerHopper extends Container
{
    private final /* synthetic */ IInventory hopperInventory;
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllIIlIIIllIlIIIIIlIllII) {
        return this.hopperInventory.isUsableByPlayer(lllllllllllIIlIIIllIlIIIIIlIllII);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllIIlIIIllIlIIIIIlIIIll, final int lllllllllllIIlIIIllIlIIIIIlIIIlI) {
        ItemStack lllllllllllIIlIIIllIlIIIIIlIIIIl = ItemStack.field_190927_a;
        final Slot lllllllllllIIlIIIllIlIIIIIlIIIII = this.inventorySlots.get(lllllllllllIIlIIIllIlIIIIIlIIIlI);
        if (lllllllllllIIlIIIllIlIIIIIlIIIII != null && lllllllllllIIlIIIllIlIIIIIlIIIII.getHasStack()) {
            final ItemStack lllllllllllIIlIIIllIlIIIIIIlllll = lllllllllllIIlIIIllIlIIIIIlIIIII.getStack();
            lllllllllllIIlIIIllIlIIIIIlIIIIl = lllllllllllIIlIIIllIlIIIIIIlllll.copy();
            if (lllllllllllIIlIIIllIlIIIIIlIIIlI < this.hopperInventory.getSizeInventory()) {
                if (!this.mergeItemStack(lllllllllllIIlIIIllIlIIIIIIlllll, this.hopperInventory.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllIIlIIIllIlIIIIIIlllll, 0, this.hopperInventory.getSizeInventory(), false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllIIlIIIllIlIIIIIIlllll.func_190926_b()) {
                lllllllllllIIlIIIllIlIIIIIlIIIII.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllIIlIIIllIlIIIIIlIIIII.onSlotChanged();
            }
        }
        return lllllllllllIIlIIIllIlIIIIIlIIIIl;
    }
    
    public ContainerHopper(final InventoryPlayer lllllllllllIIlIIIllIlIIIIIlllllI, final IInventory lllllllllllIIlIIIllIlIIIIIllllIl, final EntityPlayer lllllllllllIIlIIIllIlIIIIIllIIll) {
        this.hopperInventory = lllllllllllIIlIIIllIlIIIIIllllIl;
        lllllllllllIIlIIIllIlIIIIIllllIl.openInventory(lllllllllllIIlIIIllIlIIIIIllIIll);
        final int lllllllllllIIlIIIllIlIIIIIlllIll = 51;
        for (int lllllllllllIIlIIIllIlIIIIIlllIlI = 0; lllllllllllIIlIIIllIlIIIIIlllIlI < lllllllllllIIlIIIllIlIIIIIllllIl.getSizeInventory(); ++lllllllllllIIlIIIllIlIIIIIlllIlI) {
            this.addSlotToContainer(new Slot(lllllllllllIIlIIIllIlIIIIIllllIl, lllllllllllIIlIIIllIlIIIIIlllIlI, 44 + lllllllllllIIlIIIllIlIIIIIlllIlI * 18, 20));
        }
        for (int lllllllllllIIlIIIllIlIIIIIlllIIl = 0; lllllllllllIIlIIIllIlIIIIIlllIIl < 3; ++lllllllllllIIlIIIllIlIIIIIlllIIl) {
            for (int lllllllllllIIlIIIllIlIIIIIlllIII = 0; lllllllllllIIlIIIllIlIIIIIlllIII < 9; ++lllllllllllIIlIIIllIlIIIIIlllIII) {
                this.addSlotToContainer(new Slot(lllllllllllIIlIIIllIlIIIIIlllllI, lllllllllllIIlIIIllIlIIIIIlllIII + lllllllllllIIlIIIllIlIIIIIlllIIl * 9 + 9, 8 + lllllllllllIIlIIIllIlIIIIIlllIII * 18, lllllllllllIIlIIIllIlIIIIIlllIIl * 18 + 51));
            }
        }
        for (int lllllllllllIIlIIIllIlIIIIIllIlll = 0; lllllllllllIIlIIIllIlIIIIIllIlll < 9; ++lllllllllllIIlIIIllIlIIIIIllIlll) {
            this.addSlotToContainer(new Slot(lllllllllllIIlIIIllIlIIIIIlllllI, lllllllllllIIlIIIllIlIIIIIllIlll, 8 + lllllllllllIIlIIIllIlIIIIIllIlll * 18, 109));
        }
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllIIlIIIllIlIIIIIIlIllI) {
        super.onContainerClosed(lllllllllllIIlIIIllIlIIIIIIlIllI);
        this.hopperInventory.closeInventory(lllllllllllIIlIIIllIlIIIIIIlIllI);
    }
}
