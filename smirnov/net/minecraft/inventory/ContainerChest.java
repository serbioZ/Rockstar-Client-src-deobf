// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerChest extends Container
{
    private final /* synthetic */ IInventory lowerChestInventory;
    private final /* synthetic */ int numRows;
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllIlIlIIllllIIIllIIIlI) {
        return this.lowerChestInventory.isUsableByPlayer(llllllllllllIlIlIIllllIIIllIIIlI);
    }
    
    public IInventory getLowerChestInventory() {
        return this.lowerChestInventory;
    }
    
    public ContainerChest(final IInventory llllllllllllIlIlIIllllIIIlllIlll, final IInventory llllllllllllIlIlIIllllIIIllIllII, final EntityPlayer llllllllllllIlIlIIllllIIIlllIlIl) {
        this.lowerChestInventory = llllllllllllIlIlIIllllIIIllIllII;
        this.numRows = llllllllllllIlIlIIllllIIIllIllII.getSizeInventory() / 9;
        llllllllllllIlIlIIllllIIIllIllII.openInventory(llllllllllllIlIlIIllllIIIlllIlIl);
        final int llllllllllllIlIlIIllllIIIlllIlII = (this.numRows - 4) * 18;
        for (int llllllllllllIlIlIIllllIIIlllIIll = 0; llllllllllllIlIlIIllllIIIlllIIll < this.numRows; ++llllllllllllIlIlIIllllIIIlllIIll) {
            for (int llllllllllllIlIlIIllllIIIlllIIlI = 0; llllllllllllIlIlIIllllIIIlllIIlI < 9; ++llllllllllllIlIlIIllllIIIlllIIlI) {
                this.addSlotToContainer(new Slot(llllllllllllIlIlIIllllIIIllIllII, llllllllllllIlIlIIllllIIIlllIIlI + llllllllllllIlIlIIllllIIIlllIIll * 9, 8 + llllllllllllIlIlIIllllIIIlllIIlI * 18, 18 + llllllllllllIlIlIIllllIIIlllIIll * 18));
            }
        }
        for (int llllllllllllIlIlIIllllIIIlllIIIl = 0; llllllllllllIlIlIIllllIIIlllIIIl < 3; ++llllllllllllIlIlIIllllIIIlllIIIl) {
            for (int llllllllllllIlIlIIllllIIIlllIIII = 0; llllllllllllIlIlIIllllIIIlllIIII < 9; ++llllllllllllIlIlIIllllIIIlllIIII) {
                this.addSlotToContainer(new Slot(llllllllllllIlIlIIllllIIIlllIlll, llllllllllllIlIlIIllllIIIlllIIII + llllllllllllIlIlIIllllIIIlllIIIl * 9 + 9, 8 + llllllllllllIlIlIIllllIIIlllIIII * 18, 103 + llllllllllllIlIlIIllllIIIlllIIIl * 18 + llllllllllllIlIlIIllllIIIlllIlII));
            }
        }
        for (int llllllllllllIlIlIIllllIIIllIllll = 0; llllllllllllIlIlIIllllIIIllIllll < 9; ++llllllllllllIlIlIIllllIIIllIllll) {
            this.addSlotToContainer(new Slot(llllllllllllIlIlIIllllIIIlllIlll, llllllllllllIlIlIIllllIIIllIllll, 8 + llllllllllllIlIlIIllllIIIllIllll * 18, 161 + llllllllllllIlIlIIllllIIIlllIlII));
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllIlIlIIllllIIIlIllIll, final int llllllllllllIlIlIIllllIIIlIlIlIl) {
        ItemStack llllllllllllIlIlIIllllIIIlIllIIl = ItemStack.field_190927_a;
        final Slot llllllllllllIlIlIIllllIIIlIllIII = this.inventorySlots.get(llllllllllllIlIlIIllllIIIlIlIlIl);
        if (llllllllllllIlIlIIllllIIIlIllIII != null && llllllllllllIlIlIIllllIIIlIllIII.getHasStack()) {
            final ItemStack llllllllllllIlIlIIllllIIIlIlIlll = llllllllllllIlIlIIllllIIIlIllIII.getStack();
            llllllllllllIlIlIIllllIIIlIllIIl = llllllllllllIlIlIIllllIIIlIlIlll.copy();
            if (llllllllllllIlIlIIllllIIIlIlIlIl < this.numRows * 9) {
                if (!this.mergeItemStack(llllllllllllIlIlIIllllIIIlIlIlll, this.numRows * 9, this.inventorySlots.size(), true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(llllllllllllIlIlIIllllIIIlIlIlll, 0, this.numRows * 9, false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllllIlIlIIllllIIIlIlIlll.func_190926_b()) {
                llllllllllllIlIlIIllllIIIlIllIII.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllIlIlIIllllIIIlIllIII.onSlotChanged();
            }
        }
        return llllllllllllIlIlIIllllIIIlIllIIl;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllIlIlIIllllIIIlIIlllI) {
        super.onContainerClosed(llllllllllllIlIlIIllllIIIlIIlllI);
        this.lowerChestInventory.closeInventory(llllllllllllIlIlIIllllIIIlIIlllI);
    }
}
