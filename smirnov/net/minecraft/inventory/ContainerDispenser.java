// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerDispenser extends Container
{
    private final /* synthetic */ IInventory dispenserInventory;
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllIllllIIlIIlIlIIIIlIIIl) {
        return this.dispenserInventory.isUsableByPlayer(llllllllllIllllIIlIIlIlIIIIlIIIl);
    }
    
    public ContainerDispenser(final IInventory llllllllllIllllIIlIIlIlIIIIllIlI, final IInventory llllllllllIllllIIlIIlIlIIIlIIIIl) {
        this.dispenserInventory = llllllllllIllllIIlIIlIlIIIlIIIIl;
        for (int llllllllllIllllIIlIIlIlIIIlIIIII = 0; llllllllllIllllIIlIIlIlIIIlIIIII < 3; ++llllllllllIllllIIlIIlIlIIIlIIIII) {
            for (int llllllllllIllllIIlIIlIlIIIIlllll = 0; llllllllllIllllIIlIIlIlIIIIlllll < 3; ++llllllllllIllllIIlIIlIlIIIIlllll) {
                this.addSlotToContainer(new Slot(llllllllllIllllIIlIIlIlIIIlIIIIl, llllllllllIllllIIlIIlIlIIIIlllll + llllllllllIllllIIlIIlIlIIIlIIIII * 3, 62 + llllllllllIllllIIlIIlIlIIIIlllll * 18, 17 + llllllllllIllllIIlIIlIlIIIlIIIII * 18));
            }
        }
        for (int llllllllllIllllIIlIIlIlIIIIllllI = 0; llllllllllIllllIIlIIlIlIIIIllllI < 3; ++llllllllllIllllIIlIIlIlIIIIllllI) {
            for (int llllllllllIllllIIlIIlIlIIIIlllIl = 0; llllllllllIllllIIlIIlIlIIIIlllIl < 9; ++llllllllllIllllIIlIIlIlIIIIlllIl) {
                this.addSlotToContainer(new Slot(llllllllllIllllIIlIIlIlIIIIllIlI, llllllllllIllllIIlIIlIlIIIIlllIl + llllllllllIllllIIlIIlIlIIIIllllI * 9 + 9, 8 + llllllllllIllllIIlIIlIlIIIIlllIl * 18, 84 + llllllllllIllllIIlIIlIlIIIIllllI * 18));
            }
        }
        for (int llllllllllIllllIIlIIlIlIIIIlllII = 0; llllllllllIllllIIlIIlIlIIIIlllII < 9; ++llllllllllIllllIIlIIlIlIIIIlllII) {
            this.addSlotToContainer(new Slot(llllllllllIllllIIlIIlIlIIIIllIlI, llllllllllIllllIIlIIlIlIIIIlllII, 8 + llllllllllIllllIIlIIlIlIIIIlllII * 18, 142));
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllIllllIIlIIlIlIIIIIIIll, final int llllllllllIllllIIlIIlIlIIIIIlIII) {
        ItemStack llllllllllIllllIIlIIlIlIIIIIIlll = ItemStack.field_190927_a;
        final Slot llllllllllIllllIIlIIlIlIIIIIIllI = this.inventorySlots.get(llllllllllIllllIIlIIlIlIIIIIlIII);
        if (llllllllllIllllIIlIIlIlIIIIIIllI != null && llllllllllIllllIIlIIlIlIIIIIIllI.getHasStack()) {
            final ItemStack llllllllllIllllIIlIIlIlIIIIIIlIl = llllllllllIllllIIlIIlIlIIIIIIllI.getStack();
            llllllllllIllllIIlIIlIlIIIIIIlll = llllllllllIllllIIlIIlIlIIIIIIlIl.copy();
            if (llllllllllIllllIIlIIlIlIIIIIlIII < 9) {
                if (!this.mergeItemStack(llllllllllIllllIIlIIlIlIIIIIIlIl, 9, 45, true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(llllllllllIllllIIlIIlIlIIIIIIlIl, 0, 9, false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllIllllIIlIIlIlIIIIIIlIl.func_190926_b()) {
                llllllllllIllllIIlIIlIlIIIIIIllI.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllIllllIIlIIlIlIIIIIIllI.onSlotChanged();
            }
            if (llllllllllIllllIIlIIlIlIIIIIIlIl.func_190916_E() == llllllllllIllllIIlIIlIlIIIIIIlll.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            llllllllllIllllIIlIIlIlIIIIIIllI.func_190901_a(llllllllllIllllIIlIIlIlIIIIIIIll, llllllllllIllllIIlIIlIlIIIIIIlIl);
        }
        return llllllllllIllllIIlIIlIlIIIIIIlll;
    }
}
