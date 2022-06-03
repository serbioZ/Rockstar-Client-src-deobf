// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class Slot
{
    public final /* synthetic */ IInventory inventory;
    public /* synthetic */ int xDisplayPosition;
    private final /* synthetic */ int slotIndex;
    public /* synthetic */ int yDisplayPosition;
    
    public boolean canBeHovered() {
        return true;
    }
    
    protected void func_190900_b(final int lllllllllllIIlIllIIlllIlIlIlIIll) {
    }
    
    public boolean isHere(final IInventory lllllllllllIIlIllIIlllIlIIlIIllI, final int lllllllllllIIlIllIIlllIlIIlIIlIl) {
        return lllllllllllIIlIllIIlllIlIIlIIllI == this.inventory && lllllllllllIIlIllIIlllIlIIlIIlIl == this.slotIndex;
    }
    
    public ItemStack getStack() {
        return this.inventory.getStackInSlot(this.slotIndex);
    }
    
    public Slot(final IInventory lllllllllllIIlIllIIlllIlIllIIlll, final int lllllllllllIIlIllIIlllIlIllIlIll, final int lllllllllllIIlIllIIlllIlIllIlIlI, final int lllllllllllIIlIllIIlllIlIllIIlII) {
        this.inventory = lllllllllllIIlIllIIlllIlIllIIlll;
        this.slotIndex = lllllllllllIIlIllIIlllIlIllIlIll;
        this.xDisplayPosition = lllllllllllIIlIllIIlllIlIllIlIlI;
        this.yDisplayPosition = lllllllllllIIlIllIIlllIlIllIIlII;
    }
    
    protected void onCrafting(final ItemStack lllllllllllIIlIllIIlllIlIlIlIllI, final int lllllllllllIIlIllIIlllIlIlIlIlIl) {
    }
    
    public ItemStack decrStackSize(final int lllllllllllIIlIllIIlllIlIIlIllIl) {
        return this.inventory.decrStackSize(this.slotIndex, lllllllllllIIlIllIIlllIlIIlIllIl);
    }
    
    public void putStack(final ItemStack lllllllllllIIlIllIIlllIlIIlllllI) {
        this.inventory.setInventorySlotContents(this.slotIndex, lllllllllllIIlIllIIlllIlIIlllllI);
        this.onSlotChanged();
    }
    
    public boolean canTakeStack(final EntityPlayer lllllllllllIIlIllIIlllIlIIlIIIII) {
        return true;
    }
    
    @Nullable
    public String getSlotTexture() {
        return null;
    }
    
    public void onSlotChange(final ItemStack lllllllllllIIlIllIIlllIlIlIllIlI, final ItemStack lllllllllllIIlIllIIlllIlIlIllIIl) {
        final int lllllllllllIIlIllIIlllIlIlIlllII = lllllllllllIIlIllIIlllIlIlIllIIl.func_190916_E() - lllllllllllIIlIllIIlllIlIlIllIlI.func_190916_E();
        if (lllllllllllIIlIllIIlllIlIlIlllII > 0) {
            this.onCrafting(lllllllllllIIlIllIIlllIlIlIllIIl, lllllllllllIIlIllIIlllIlIlIlllII);
        }
    }
    
    public boolean getHasStack() {
        return !this.getStack().func_190926_b();
    }
    
    public int getSlotStackLimit() {
        return this.inventory.getInventoryStackLimit();
    }
    
    public ItemStack func_190901_a(final EntityPlayer lllllllllllIIlIllIIlllIlIlIIllIl, final ItemStack lllllllllllIIlIllIIlllIlIlIIllII) {
        this.onSlotChanged();
        return lllllllllllIIlIllIIlllIlIlIIllII;
    }
    
    public void onSlotChanged() {
        this.inventory.markDirty();
    }
    
    public int getItemStackLimit(final ItemStack lllllllllllIIlIllIIlllIlIIllIIll) {
        return this.getSlotStackLimit();
    }
    
    protected void onCrafting(final ItemStack lllllllllllIIlIllIIlllIlIlIlIIIl) {
    }
    
    public boolean isItemValid(final ItemStack lllllllllllIIlIllIIlllIlIlIIlIII) {
        return true;
    }
}
