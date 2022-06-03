// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractChestHorse;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.AbstractHorse;

public class ContainerHorseInventory extends Container
{
    private final /* synthetic */ IInventory horseInventory;
    private final /* synthetic */ AbstractHorse theHorse;
    
    public ContainerHorseInventory(final IInventory llllllllllllllIllIlIllIIllIIIlIl, final IInventory llllllllllllllIllIlIllIIllIIIlII, final AbstractHorse llllllllllllllIllIlIllIIlIllIlll, final EntityPlayer llllllllllllllIllIlIllIIlIllIllI) {
        this.horseInventory = llllllllllllllIllIlIllIIllIIIlII;
        this.theHorse = llllllllllllllIllIlIllIIlIllIlll;
        final int llllllllllllllIllIlIllIIllIIIIIl = 3;
        llllllllllllllIllIlIllIIllIIIlII.openInventory(llllllllllllllIllIlIllIIlIllIllI);
        final int llllllllllllllIllIlIllIIllIIIIII = -18;
        this.addSlotToContainer(new Slot(llllllllllllllIllIlIllIIllIIIlII, 0, 8, 18) {
            @Override
            public boolean canBeHovered() {
                return llllllllllllllIllIlIllIIlIllIlll.func_190685_dA();
            }
            
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllIIIIlIllIllIIllIlII) {
                return lllllllllllllIIIIlIllIllIIllIlII.getItem() == Items.SADDLE && !this.getHasStack() && llllllllllllllIllIlIllIIlIllIlll.func_190685_dA();
            }
        });
        this.addSlotToContainer(new Slot(llllllllllllllIllIlIllIIllIIIlII, 1, 8, 36) {
            @Override
            public int getSlotStackLimit() {
                return 1;
            }
            
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllIllIIIIIIIIllIlllll) {
                return llllllllllllllIllIlIllIIlIllIlll.func_190682_f(lllllllllllllIllIIIIIIIIllIlllll);
            }
            
            @Override
            public boolean canBeHovered() {
                return llllllllllllllIllIlIllIIlIllIlll.func_190677_dK();
            }
        });
        if (llllllllllllllIllIlIllIIlIllIlll instanceof AbstractChestHorse && ((AbstractChestHorse)llllllllllllllIllIlIllIIlIllIlll).func_190695_dh()) {
            for (int llllllllllllllIllIlIllIIlIllllll = 0; llllllllllllllIllIlIllIIlIllllll < 3; ++llllllllllllllIllIlIllIIlIllllll) {
                for (int llllllllllllllIllIlIllIIlIlllllI = 0; llllllllllllllIllIlIllIIlIlllllI < ((AbstractChestHorse)llllllllllllllIllIlIllIIlIllIlll).func_190696_dl(); ++llllllllllllllIllIlIllIIlIlllllI) {
                    this.addSlotToContainer(new Slot(llllllllllllllIllIlIllIIllIIIlII, 2 + llllllllllllllIllIlIllIIlIlllllI + llllllllllllllIllIlIllIIlIllllll * ((AbstractChestHorse)llllllllllllllIllIlIllIIlIllIlll).func_190696_dl(), 80 + llllllllllllllIllIlIllIIlIlllllI * 18, 18 + llllllllllllllIllIlIllIIlIllllll * 18));
                }
            }
        }
        for (int llllllllllllllIllIlIllIIlIllllIl = 0; llllllllllllllIllIlIllIIlIllllIl < 3; ++llllllllllllllIllIlIllIIlIllllIl) {
            for (int llllllllllllllIllIlIllIIlIllllII = 0; llllllllllllllIllIlIllIIlIllllII < 9; ++llllllllllllllIllIlIllIIlIllllII) {
                this.addSlotToContainer(new Slot(llllllllllllllIllIlIllIIllIIIlIl, llllllllllllllIllIlIllIIlIllllII + llllllllllllllIllIlIllIIlIllllIl * 9 + 9, 8 + llllllllllllllIllIlIllIIlIllllII * 18, 102 + llllllllllllllIllIlIllIIlIllllIl * 18 - 18));
            }
        }
        for (int llllllllllllllIllIlIllIIlIlllIll = 0; llllllllllllllIllIlIllIIlIlllIll < 9; ++llllllllllllllIllIlIllIIlIlllIll) {
            this.addSlotToContainer(new Slot(llllllllllllllIllIlIllIIllIIIlIl, llllllllllllllIllIlIllIIlIlllIll, 8 + llllllllllllllIllIlIllIIlIlllIll * 18, 142));
        }
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllIllIlIllIIlIlIllII) {
        return this.horseInventory.isUsableByPlayer(llllllllllllllIllIlIllIIlIlIllII) && this.theHorse.isEntityAlive() && this.theHorse.getDistanceToEntity(llllllllllllllIllIlIllIIlIlIllII) < 8.0f;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllIllIlIllIIlIIllIII) {
        super.onContainerClosed(llllllllllllllIllIlIllIIlIIllIII);
        this.horseInventory.closeInventory(llllllllllllllIllIlIllIIlIIllIII);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllIllIlIllIIlIlIIlIl, final int llllllllllllllIllIlIllIIlIlIIlII) {
        ItemStack llllllllllllllIllIlIllIIlIlIIIll = ItemStack.field_190927_a;
        final Slot llllllllllllllIllIlIllIIlIlIIIlI = this.inventorySlots.get(llllllllllllllIllIlIllIIlIlIIlII);
        if (llllllllllllllIllIlIllIIlIlIIIlI != null && llllllllllllllIllIlIllIIlIlIIIlI.getHasStack()) {
            final ItemStack llllllllllllllIllIlIllIIlIlIIIIl = llllllllllllllIllIlIllIIlIlIIIlI.getStack();
            llllllllllllllIllIlIllIIlIlIIIll = llllllllllllllIllIlIllIIlIlIIIIl.copy();
            if (llllllllllllllIllIlIllIIlIlIIlII < this.horseInventory.getSizeInventory()) {
                if (!this.mergeItemStack(llllllllllllllIllIlIllIIlIlIIIIl, this.horseInventory.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (this.getSlot(1).isItemValid(llllllllllllllIllIlIllIIlIlIIIIl) && !this.getSlot(1).getHasStack()) {
                if (!this.mergeItemStack(llllllllllllllIllIlIllIIlIlIIIIl, 1, 2, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (this.getSlot(0).isItemValid(llllllllllllllIllIlIllIIlIlIIIIl)) {
                if (!this.mergeItemStack(llllllllllllllIllIlIllIIlIlIIIIl, 0, 1, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (this.horseInventory.getSizeInventory() <= 2 || !this.mergeItemStack(llllllllllllllIllIlIllIIlIlIIIIl, 2, this.horseInventory.getSizeInventory(), false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllllllIllIlIllIIlIlIIIIl.func_190926_b()) {
                llllllllllllllIllIlIllIIlIlIIIlI.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllllIllIlIllIIlIlIIIlI.onSlotChanged();
            }
        }
        return llllllllllllllIllIlIllIIlIlIIIll;
    }
}
