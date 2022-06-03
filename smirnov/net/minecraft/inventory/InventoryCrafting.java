// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.client.util.RecipeItemHelper;
import net.minecraft.entity.player.EntityPlayer;
import java.util.List;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class InventoryCrafting implements IInventory
{
    private final /* synthetic */ NonNullList<ItemStack> stackList;
    private final /* synthetic */ int inventoryHeight;
    private final /* synthetic */ Container eventHandler;
    private final /* synthetic */ int inventoryWidth;
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIIIIIIIIlIlIlIlIIIl, final int lllllllllllllIIIIIIIIlIlIlIIllII) {
        final ItemStack lllllllllllllIIIIIIIIlIlIlIIllll = ItemStackHelper.getAndSplit(this.stackList, lllllllllllllIIIIIIIIlIlIlIlIIIl, lllllllllllllIIIIIIIIlIlIlIIllII);
        if (!lllllllllllllIIIIIIIIlIlIlIIllll.func_190926_b()) {
            this.eventHandler.onCraftMatrixChanged(this);
        }
        return lllllllllllllIIIIIIIIlIlIlIIllll;
    }
    
    public int getHeight() {
        return this.inventoryHeight;
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllIIIIIIIIlIlIlIIIIll, final ItemStack lllllllllllllIIIIIIIIlIlIlIIIlIl) {
        this.stackList.set(lllllllllllllIIIIIIIIlIlIlIIIIll, lllllllllllllIIIIIIIIlIlIlIIIlIl);
        this.eventHandler.onCraftMatrixChanged(this);
    }
    
    @Override
    public int getField(final int lllllllllllllIIIIIIIIlIlIIllIlIl) {
        return 0;
    }
    
    @Override
    public String getName() {
        return "container.crafting";
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllllIIIIIIIIlIlIIlllllI) {
        return true;
    }
    
    @Override
    public void clear() {
        this.stackList.clear();
    }
    
    @Override
    public int getSizeInventory() {
        return this.stackList.size();
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllIIIIIIIIlIlIIllllII) {
    }
    
    public int getWidth() {
        return this.inventoryWidth;
    }
    
    @Override
    public void markDirty() {
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllIIIIIIIIlIlIIlllIII, final ItemStack lllllllllllllIIIIIIIIlIlIIllIlll) {
        return true;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllIIIIIIIIlIlIIlllIlI) {
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllIIIIIIIIlIlIllIlIll) {
        return (lllllllllllllIIIIIIIIlIlIllIlIll >= this.getSizeInventory()) ? ItemStack.field_190927_a : this.stackList.get(lllllllllllllIIIIIIIIlIlIllIlIll);
    }
    
    public InventoryCrafting(final Container lllllllllllllIIIIIIIIlIlIllllllI, final int lllllllllllllIIIIIIIIlIllIIIIIIl, final int lllllllllllllIIIIIIIIlIllIIIIIII) {
        this.stackList = NonNullList.func_191197_a(lllllllllllllIIIIIIIIlIllIIIIIIl * lllllllllllllIIIIIIIIlIllIIIIIII, ItemStack.field_190927_a);
        this.eventHandler = lllllllllllllIIIIIIIIlIlIllllllI;
        this.inventoryWidth = lllllllllllllIIIIIIIIlIllIIIIIIl;
        this.inventoryHeight = lllllllllllllIIIIIIIIlIllIIIIIII;
    }
    
    @Override
    public void setField(final int lllllllllllllIIIIIIIIlIlIIllIIll, final int lllllllllllllIIIIIIIIlIlIIllIIlI) {
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllllIIIIIIIIlIlIlIlIlll) {
        return ItemStackHelper.getAndRemove(this.stackList, lllllllllllllIIIIIIIIlIlIlIlIlll);
    }
    
    public void func_194018_a(final RecipeItemHelper lllllllllllllIIIIIIIIlIlIIIlllll) {
        for (final ItemStack lllllllllllllIIIIIIIIlIlIIlIIIIl : this.stackList) {
            lllllllllllllIIIIIIIIlIlIIIlllll.func_194112_a(lllllllllllllIIIIIIIIlIlIIlIIIIl);
        }
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllIIIIIIIIlIlIlllIlII : this.stackList) {
            if (!lllllllllllllIIIIIIIIlIlIlllIlII.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public ItemStack getStackInRowAndColumn(final int lllllllllllllIIIIIIIIlIlIllIIIll, final int lllllllllllllIIIIIIIIlIlIllIIIlI) {
        return (lllllllllllllIIIIIIIIlIlIllIIIll >= 0 && lllllllllllllIIIIIIIIlIlIllIIIll < this.inventoryWidth && lllllllllllllIIIIIIIIlIlIllIIIlI >= 0 && lllllllllllllIIIIIIIIlIlIllIIIlI <= this.inventoryHeight) ? this.getStackInSlot(lllllllllllllIIIIIIIIlIlIllIIIll + lllllllllllllIIIIIIIIlIlIllIIIlI * this.inventoryWidth) : ItemStack.field_190927_a;
    }
}
