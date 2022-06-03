// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.IMerchant;
import net.minecraft.world.World;

public class ContainerMerchant extends Container
{
    private final /* synthetic */ InventoryMerchant merchantInventory;
    private final /* synthetic */ World theWorld;
    private final /* synthetic */ IMerchant theMerchant;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllIIIlIIIlIIIlllIIllIlI, final int lllllllllllIIIlIIIlIIIlllIIllIIl) {
        ItemStack lllllllllllIIIlIIIlIIIlllIIllllI = ItemStack.field_190927_a;
        final Slot lllllllllllIIIlIIIlIIIlllIIlllIl = this.inventorySlots.get(lllllllllllIIIlIIIlIIIlllIIllIIl);
        if (lllllllllllIIIlIIIlIIIlllIIlllIl != null && lllllllllllIIIlIIIlIIIlllIIlllIl.getHasStack()) {
            final ItemStack lllllllllllIIIlIIIlIIIlllIIlllII = lllllllllllIIIlIIIlIIIlllIIlllIl.getStack();
            lllllllllllIIIlIIIlIIIlllIIllllI = lllllllllllIIIlIIIlIIIlllIIlllII.copy();
            if (lllllllllllIIIlIIIlIIIlllIIllIIl == 2) {
                if (!this.mergeItemStack(lllllllllllIIIlIIIlIIIlllIIlllII, 3, 39, true)) {
                    return ItemStack.field_190927_a;
                }
                lllllllllllIIIlIIIlIIIlllIIlllIl.onSlotChange(lllllllllllIIIlIIIlIIIlllIIlllII, lllllllllllIIIlIIIlIIIlllIIllllI);
            }
            else if (lllllllllllIIIlIIIlIIIlllIIllIIl != 0 && lllllllllllIIIlIIIlIIIlllIIllIIl != 1) {
                if (lllllllllllIIIlIIIlIIIlllIIllIIl >= 3 && lllllllllllIIIlIIIlIIIlllIIllIIl < 30) {
                    if (!this.mergeItemStack(lllllllllllIIIlIIIlIIIlllIIlllII, 30, 39, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (lllllllllllIIIlIIIlIIIlllIIllIIl >= 30 && lllllllllllIIIlIIIlIIIlllIIllIIl < 39 && !this.mergeItemStack(lllllllllllIIIlIIIlIIIlllIIlllII, 3, 30, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllIIIlIIIlIIIlllIIlllII, 3, 39, false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllIIIlIIIlIIIlllIIlllII.func_190926_b()) {
                lllllllllllIIIlIIIlIIIlllIIlllIl.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllIIIlIIIlIIIlllIIlllIl.onSlotChanged();
            }
            if (lllllllllllIIIlIIIlIIIlllIIlllII.func_190916_E() == lllllllllllIIIlIIIlIIIlllIIllllI.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            lllllllllllIIIlIIIlIIIlllIIlllIl.func_190901_a(lllllllllllIIIlIIIlIIIlllIIllIlI, lllllllllllIIIlIIIlIIIlllIIlllII);
        }
        return lllllllllllIIIlIIIlIIIlllIIllllI;
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory lllllllllllIIIlIIIlIIIlllIllIlII) {
        this.merchantInventory.resetRecipeAndSlots();
        super.onCraftMatrixChanged(lllllllllllIIIlIIIlIIIlllIllIlII);
    }
    
    public void setCurrentRecipeIndex(final int lllllllllllIIIlIIIlIIIlllIlIlllI) {
        this.merchantInventory.setCurrentRecipeIndex(lllllllllllIIIlIIIlIIIlllIlIlllI);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllIIIlIIIlIIIlllIlIlIII) {
        return this.theMerchant.getCustomer() == lllllllllllIIIlIIIlIIIlllIlIlIII;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllIIIlIIIlIIIlllIIIlllI) {
        super.onContainerClosed(lllllllllllIIIlIIIlIIIlllIIIlllI);
        this.theMerchant.setCustomer(null);
        super.onContainerClosed(lllllllllllIIIlIIIlIIIlllIIIlllI);
        if (!this.theWorld.isRemote) {
            ItemStack lllllllllllIIIlIIIlIIIlllIIlIIII = this.merchantInventory.removeStackFromSlot(0);
            if (!lllllllllllIIIlIIIlIIIlllIIlIIII.func_190926_b()) {
                lllllllllllIIIlIIIlIIIlllIIIlllI.dropItem(lllllllllllIIIlIIIlIIIlllIIlIIII, false);
            }
            lllllllllllIIIlIIIlIIIlllIIlIIII = this.merchantInventory.removeStackFromSlot(1);
            if (!lllllllllllIIIlIIIlIIIlllIIlIIII.func_190926_b()) {
                lllllllllllIIIlIIIlIIIlllIIIlllI.dropItem(lllllllllllIIIlIIIlIIIlllIIlIIII, false);
            }
        }
    }
    
    public ContainerMerchant(final InventoryPlayer lllllllllllIIIlIIIlIIIllllIIlIII, final IMerchant lllllllllllIIIlIIIlIIIllllIIIlll, final World lllllllllllIIIlIIIlIIIlllIllllll) {
        this.theMerchant = lllllllllllIIIlIIIlIIIllllIIIlll;
        this.theWorld = lllllllllllIIIlIIIlIIIlllIllllll;
        this.merchantInventory = new InventoryMerchant(lllllllllllIIIlIIIlIIIllllIIlIII.player, lllllllllllIIIlIIIlIIIllllIIIlll);
        this.addSlotToContainer(new Slot(this.merchantInventory, 0, 36, 53));
        this.addSlotToContainer(new Slot(this.merchantInventory, 1, 62, 53));
        this.addSlotToContainer(new SlotMerchantResult(lllllllllllIIIlIIIlIIIllllIIlIII.player, lllllllllllIIIlIIIlIIIllllIIIlll, this.merchantInventory, 2, 120, 53));
        for (int lllllllllllIIIlIIIlIIIllllIIIlIl = 0; lllllllllllIIIlIIIlIIIllllIIIlIl < 3; ++lllllllllllIIIlIIIlIIIllllIIIlIl) {
            for (int lllllllllllIIIlIIIlIIIllllIIIlII = 0; lllllllllllIIIlIIIlIIIllllIIIlII < 9; ++lllllllllllIIIlIIIlIIIllllIIIlII) {
                this.addSlotToContainer(new Slot(lllllllllllIIIlIIIlIIIllllIIlIII, lllllllllllIIIlIIIlIIIllllIIIlII + lllllllllllIIIlIIIlIIIllllIIIlIl * 9 + 9, 8 + lllllllllllIIIlIIIlIIIllllIIIlII * 18, 84 + lllllllllllIIIlIIIlIIIllllIIIlIl * 18));
            }
        }
        for (int lllllllllllIIIlIIIlIIIllllIIIIll = 0; lllllllllllIIIlIIIlIIIllllIIIIll < 9; ++lllllllllllIIIlIIIlIIIllllIIIIll) {
            this.addSlotToContainer(new Slot(lllllllllllIIIlIIIlIIIllllIIlIII, lllllllllllIIIlIIIlIIIllllIIIIll, 8 + lllllllllllIIIlIIIlIIIllllIIIIll * 18, 142));
        }
    }
    
    public InventoryMerchant getMerchantInventory() {
        return this.merchantInventory;
    }
}
