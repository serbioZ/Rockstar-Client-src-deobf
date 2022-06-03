// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerFurnace extends Container
{
    private /* synthetic */ int furnaceBurnTime;
    private /* synthetic */ int totalCookTime;
    private /* synthetic */ int cookTime;
    private final /* synthetic */ IInventory tileFurnace;
    private /* synthetic */ int currentItemBurnTime;
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllIllIlIIIllIlllIllII) {
        return this.tileFurnace.isUsableByPlayer(lllllllllllllIllIlIIIllIlllIllII);
    }
    
    @Override
    public void addListener(final IContainerListener lllllllllllllIllIlIIIlllIIIIIllI) {
        super.addListener(lllllllllllllIllIlIIIlllIIIIIllI);
        lllllllllllllIllIlIIIlllIIIIIllI.sendAllWindowProperties(this, this.tileFurnace);
    }
    
    @Override
    public void updateProgressBar(final int lllllllllllllIllIlIIIllIllllIllI, final int lllllllllllllIllIlIIIllIllllIlIl) {
        this.tileFurnace.setField(lllllllllllllIllIlIIIllIllllIllI, lllllllllllllIllIlIIIllIllllIlIl);
    }
    
    public ContainerFurnace(final InventoryPlayer lllllllllllllIllIlIIIlllIIIlIIll, final IInventory lllllllllllllIllIlIIIlllIIIlIIlI) {
        this.tileFurnace = lllllllllllllIllIlIIIlllIIIlIIlI;
        this.addSlotToContainer(new Slot(lllllllllllllIllIlIIIlllIIIlIIlI, 0, 56, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(lllllllllllllIllIlIIIlllIIIlIIlI, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(lllllllllllllIllIlIIIlllIIIlIIll.player, lllllllllllllIllIlIIIlllIIIlIIlI, 2, 116, 35));
        for (int lllllllllllllIllIlIIIlllIIIlIIIl = 0; lllllllllllllIllIlIIIlllIIIlIIIl < 3; ++lllllllllllllIllIlIIIlllIIIlIIIl) {
            for (int lllllllllllllIllIlIIIlllIIIlIIII = 0; lllllllllllllIllIlIIIlllIIIlIIII < 9; ++lllllllllllllIllIlIIIlllIIIlIIII) {
                this.addSlotToContainer(new Slot(lllllllllllllIllIlIIIlllIIIlIIll, lllllllllllllIllIlIIIlllIIIlIIII + lllllllllllllIllIlIIIlllIIIlIIIl * 9 + 9, 8 + lllllllllllllIllIlIIIlllIIIlIIII * 18, 84 + lllllllllllllIllIlIIIlllIIIlIIIl * 18));
            }
        }
        for (int lllllllllllllIllIlIIIlllIIIIllll = 0; lllllllllllllIllIlIIIlllIIIIllll < 9; ++lllllllllllllIllIlIIIlllIIIIllll) {
            this.addSlotToContainer(new Slot(lllllllllllllIllIlIIIlllIIIlIIll, lllllllllllllIllIlIIIlllIIIIllll, 8 + lllllllllllllIllIlIIIlllIIIIllll * 18, 142));
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllIllIlIIIllIlllIIlII, final int lllllllllllllIllIlIIIllIllIlllIl) {
        ItemStack lllllllllllllIllIlIIIllIlllIIIlI = ItemStack.field_190927_a;
        final Slot lllllllllllllIllIlIIIllIlllIIIIl = this.inventorySlots.get(lllllllllllllIllIlIIIllIllIlllIl);
        if (lllllllllllllIllIlIIIllIlllIIIIl != null && lllllllllllllIllIlIIIllIlllIIIIl.getHasStack()) {
            final ItemStack lllllllllllllIllIlIIIllIlllIIIII = lllllllllllllIllIlIIIllIlllIIIIl.getStack();
            lllllllllllllIllIlIIIllIlllIIIlI = lllllllllllllIllIlIIIllIlllIIIII.copy();
            if (lllllllllllllIllIlIIIllIllIlllIl == 2) {
                if (!this.mergeItemStack(lllllllllllllIllIlIIIllIlllIIIII, 3, 39, true)) {
                    return ItemStack.field_190927_a;
                }
                lllllllllllllIllIlIIIllIlllIIIIl.onSlotChange(lllllllllllllIllIlIIIllIlllIIIII, lllllllllllllIllIlIIIllIlllIIIlI);
            }
            else if (lllllllllllllIllIlIIIllIllIlllIl != 1 && lllllllllllllIllIlIIIllIllIlllIl != 0) {
                if (!FurnaceRecipes.instance().getSmeltingResult(lllllllllllllIllIlIIIllIlllIIIII).func_190926_b()) {
                    if (!this.mergeItemStack(lllllllllllllIllIlIIIllIlllIIIII, 0, 1, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(lllllllllllllIllIlIIIllIlllIIIII)) {
                    if (!this.mergeItemStack(lllllllllllllIllIlIIIllIlllIIIII, 1, 2, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (lllllllllllllIllIlIIIllIllIlllIl >= 3 && lllllllllllllIllIlIIIllIllIlllIl < 30) {
                    if (!this.mergeItemStack(lllllllllllllIllIlIIIllIlllIIIII, 30, 39, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (lllllllllllllIllIlIIIllIllIlllIl >= 30 && lllllllllllllIllIlIIIllIllIlllIl < 39 && !this.mergeItemStack(lllllllllllllIllIlIIIllIlllIIIII, 3, 30, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllllIllIlIIIllIlllIIIII, 3, 39, false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllllIllIlIIIllIlllIIIII.func_190926_b()) {
                lllllllllllllIllIlIIIllIlllIIIIl.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllllIllIlIIIllIlllIIIIl.onSlotChanged();
            }
            if (lllllllllllllIllIlIIIllIlllIIIII.func_190916_E() == lllllllllllllIllIlIIIllIlllIIIlI.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            lllllllllllllIllIlIIIllIlllIIIIl.func_190901_a(lllllllllllllIllIlIIIllIlllIIlII, lllllllllllllIllIlIIIllIlllIIIII);
        }
        return lllllllllllllIllIlIIIllIlllIIIlI;
    }
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int lllllllllllllIllIlIIIllIllllllll = 0; lllllllllllllIllIlIIIllIllllllll < this.listeners.size(); ++lllllllllllllIllIlIIIllIllllllll) {
            final IContainerListener lllllllllllllIllIlIIIllIlllllllI = this.listeners.get(lllllllllllllIllIlIIIllIllllllll);
            if (this.cookTime != this.tileFurnace.getField(2)) {
                lllllllllllllIllIlIIIllIlllllllI.sendProgressBarUpdate(this, 2, this.tileFurnace.getField(2));
            }
            if (this.furnaceBurnTime != this.tileFurnace.getField(0)) {
                lllllllllllllIllIlIIIllIlllllllI.sendProgressBarUpdate(this, 0, this.tileFurnace.getField(0));
            }
            if (this.currentItemBurnTime != this.tileFurnace.getField(1)) {
                lllllllllllllIllIlIIIllIlllllllI.sendProgressBarUpdate(this, 1, this.tileFurnace.getField(1));
            }
            if (this.totalCookTime != this.tileFurnace.getField(3)) {
                lllllllllllllIllIlIIIllIlllllllI.sendProgressBarUpdate(this, 3, this.tileFurnace.getField(3));
            }
        }
        this.cookTime = this.tileFurnace.getField(2);
        this.furnaceBurnTime = this.tileFurnace.getField(0);
        this.currentItemBurnTime = this.tileFurnace.getField(1);
        this.totalCookTime = this.tileFurnace.getField(3);
    }
}
