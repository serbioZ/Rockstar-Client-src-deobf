// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerShulkerBox extends Container
{
    private final /* synthetic */ IInventory field_190899_a;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllIlIllIIlIIIIllIllIIl, final int llllllllllllIlIllIIlIIIIllIllIII) {
        ItemStack llllllllllllIlIllIIlIIIIllIlIlll = ItemStack.field_190927_a;
        final Slot llllllllllllIlIllIIlIIIIllIlIllI = this.inventorySlots.get(llllllllllllIlIllIIlIIIIllIllIII);
        if (llllllllllllIlIllIIlIIIIllIlIllI != null && llllllllllllIlIllIIlIIIIllIlIllI.getHasStack()) {
            final ItemStack llllllllllllIlIllIIlIIIIllIlIlIl = llllllllllllIlIllIIlIIIIllIlIllI.getStack();
            llllllllllllIlIllIIlIIIIllIlIlll = llllllllllllIlIllIIlIIIIllIlIlIl.copy();
            if (llllllllllllIlIllIIlIIIIllIllIII < this.field_190899_a.getSizeInventory()) {
                if (!this.mergeItemStack(llllllllllllIlIllIIlIIIIllIlIlIl, this.field_190899_a.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(llllllllllllIlIllIIlIIIIllIlIlIl, 0, this.field_190899_a.getSizeInventory(), false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllllIlIllIIlIIIIllIlIlIl.func_190926_b()) {
                llllllllllllIlIllIIlIIIIllIlIllI.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllIlIllIIlIIIIllIlIllI.onSlotChanged();
            }
        }
        return llllllllllllIlIllIIlIIIIllIlIlll;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllIlIllIIlIIIIllIIllII) {
        super.onContainerClosed(llllllllllllIlIllIIlIIIIllIIllII);
        this.field_190899_a.closeInventory(llllllllllllIlIllIIlIIIIllIIllII);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllIlIllIIlIIIIlllIIIII) {
        return this.field_190899_a.isUsableByPlayer(llllllllllllIlIllIIlIIIIlllIIIII);
    }
    
    public ContainerShulkerBox(final InventoryPlayer llllllllllllIlIllIIlIIIIllllIlll, final IInventory llllllllllllIlIllIIlIIIIllllIllI, final EntityPlayer llllllllllllIlIllIIlIIIIllllIlIl) {
        this.field_190899_a = llllllllllllIlIllIIlIIIIllllIllI;
        llllllllllllIlIllIIlIIIIllllIllI.openInventory(llllllllllllIlIllIIlIIIIllllIlIl);
        final int llllllllllllIlIllIIlIIIIllllIlII = 3;
        final int llllllllllllIlIllIIlIIIIllllIIll = 9;
        for (int llllllllllllIlIllIIlIIIIllllIIlI = 0; llllllllllllIlIllIIlIIIIllllIIlI < 3; ++llllllllllllIlIllIIlIIIIllllIIlI) {
            for (int llllllllllllIlIllIIlIIIIllllIIIl = 0; llllllllllllIlIllIIlIIIIllllIIIl < 9; ++llllllllllllIlIllIIlIIIIllllIIIl) {
                this.addSlotToContainer(new SlotShulkerBox(llllllllllllIlIllIIlIIIIllllIllI, llllllllllllIlIllIIlIIIIllllIIIl + llllllllllllIlIllIIlIIIIllllIIlI * 9, 8 + llllllllllllIlIllIIlIIIIllllIIIl * 18, 18 + llllllllllllIlIllIIlIIIIllllIIlI * 18));
            }
        }
        for (int llllllllllllIlIllIIlIIIIllllIIII = 0; llllllllllllIlIllIIlIIIIllllIIII < 3; ++llllllllllllIlIllIIlIIIIllllIIII) {
            for (int llllllllllllIlIllIIlIIIIlllIllll = 0; llllllllllllIlIllIIlIIIIlllIllll < 9; ++llllllllllllIlIllIIlIIIIlllIllll) {
                this.addSlotToContainer(new Slot(llllllllllllIlIllIIlIIIIllllIlll, llllllllllllIlIllIIlIIIIlllIllll + llllllllllllIlIllIIlIIIIllllIIII * 9 + 9, 8 + llllllllllllIlIllIIlIIIIlllIllll * 18, 84 + llllllllllllIlIllIIlIIIIllllIIII * 18));
            }
        }
        for (int llllllllllllIlIllIIlIIIIlllIlllI = 0; llllllllllllIlIllIIlIIIIlllIlllI < 9; ++llllllllllllIlIllIIlIIIIlllIlllI) {
            this.addSlotToContainer(new Slot(llllllllllllIlIllIIlIIIIllllIlll, llllllllllllIlIllIIlIIIIlllIlllI, 8 + llllllllllllIlIllIIlIIIIlllIlllI * 18, 142));
        }
    }
}
