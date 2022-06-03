// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.village.MerchantRecipeList;
import java.util.List;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class InventoryMerchant implements IInventory
{
    private final /* synthetic */ NonNullList<ItemStack> theInventory;
    private final /* synthetic */ EntityPlayer thePlayer;
    private final /* synthetic */ IMerchant theMerchant;
    private /* synthetic */ int currentRecipeIndex;
    private /* synthetic */ MerchantRecipe currentRecipe;
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllIIIIIIIIlIIIllIlIlIII) {
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllIIIIIIIIlIIIllIlllIlI, final ItemStack lllllllllllIIIIIIIIlIIIllIlllIIl) {
        this.theInventory.set(lllllllllllIIIIIIIIlIIIllIlllIlI, lllllllllllIIIIIIIIlIIIllIlllIIl);
        if (!lllllllllllIIIIIIIIlIIIllIlllIIl.func_190926_b() && lllllllllllIIIIIIIIlIIIllIlllIIl.func_190916_E() > this.getInventoryStackLimit()) {
            lllllllllllIIIIIIIIlIIIllIlllIIl.func_190920_e(this.getInventoryStackLimit());
        }
        if (this.inventoryResetNeededOnSlotChange(lllllllllllIIIIIIIIlIIIllIlllIlI)) {
            this.resetRecipeAndSlots();
        }
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllIIIIIIIIlIIIllIllllll) {
        return ItemStackHelper.getAndRemove(this.theInventory, lllllllllllIIIIIIIIlIIIllIllllll);
    }
    
    public void resetRecipeAndSlots() {
        this.currentRecipe = null;
        ItemStack lllllllllllIIIIIIIIlIIIllIIllIIl = this.theInventory.get(0);
        ItemStack lllllllllllIIIIIIIIlIIIllIIllIII = this.theInventory.get(1);
        if (lllllllllllIIIIIIIIlIIIllIIllIIl.func_190926_b()) {
            lllllllllllIIIIIIIIlIIIllIIllIIl = lllllllllllIIIIIIIIlIIIllIIllIII;
            lllllllllllIIIIIIIIlIIIllIIllIII = ItemStack.field_190927_a;
        }
        if (lllllllllllIIIIIIIIlIIIllIIllIIl.func_190926_b()) {
            this.setInventorySlotContents(2, ItemStack.field_190927_a);
        }
        else {
            final MerchantRecipeList lllllllllllIIIIIIIIlIIIllIIlIlll = this.theMerchant.getRecipes(this.thePlayer);
            if (lllllllllllIIIIIIIIlIIIllIIlIlll != null) {
                MerchantRecipe lllllllllllIIIIIIIIlIIIllIIlIllI = lllllllllllIIIIIIIIlIIIllIIlIlll.canRecipeBeUsed(lllllllllllIIIIIIIIlIIIllIIllIIl, lllllllllllIIIIIIIIlIIIllIIllIII, this.currentRecipeIndex);
                if (lllllllllllIIIIIIIIlIIIllIIlIllI != null && !lllllllllllIIIIIIIIlIIIllIIlIllI.isRecipeDisabled()) {
                    this.currentRecipe = lllllllllllIIIIIIIIlIIIllIIlIllI;
                    this.setInventorySlotContents(2, lllllllllllIIIIIIIIlIIIllIIlIllI.getItemToSell().copy());
                }
                else if (!lllllllllllIIIIIIIIlIIIllIIllIII.func_190926_b()) {
                    lllllllllllIIIIIIIIlIIIllIIlIllI = lllllllllllIIIIIIIIlIIIllIIlIlll.canRecipeBeUsed(lllllllllllIIIIIIIIlIIIllIIllIII, lllllllllllIIIIIIIIlIIIllIIllIIl, this.currentRecipeIndex);
                    if (lllllllllllIIIIIIIIlIIIllIIlIllI != null && !lllllllllllIIIIIIIIlIIIllIIlIllI.isRecipeDisabled()) {
                        this.currentRecipe = lllllllllllIIIIIIIIlIIIllIIlIllI;
                        this.setInventorySlotContents(2, lllllllllllIIIIIIIIlIIIllIIlIllI.getItemToSell().copy());
                    }
                    else {
                        this.setInventorySlotContents(2, ItemStack.field_190927_a);
                    }
                }
                else {
                    this.setInventorySlotContents(2, ItemStack.field_190927_a);
                }
            }
            this.theMerchant.verifySellingItem(this.getStackInSlot(2));
        }
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllIIIIIIIIlIIIllIlIIlII, final ItemStack lllllllllllIIIIIIIIlIIIllIlIIIll) {
        return true;
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllIIIIIIIIlIIIllllIIIIl : this.theInventory) {
            if (!lllllllllllIIIIIIIIlIIIllllIIIIl.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void clear() {
        this.theInventory.clear();
    }
    
    @Override
    public String getName() {
        return "mob.villager";
    }
    
    private boolean inventoryResetNeededOnSlotChange(final int lllllllllllIIIIIIIIlIIIlllIIIllI) {
        return lllllllllllIIIIIIIIlIIIlllIIIllI == 0 || lllllllllllIIIIIIIIlIIIlllIIIllI == 1;
    }
    
    @Override
    public int getSizeInventory() {
        return this.theInventory.size();
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllIIIIIIIIlIIIlllIIllII, final int lllllllllllIIIIIIIIlIIIlllIlIIII) {
        final ItemStack lllllllllllIIIIIIIIlIIIlllIIllll = this.theInventory.get(lllllllllllIIIIIIIIlIIIlllIIllII);
        if (lllllllllllIIIIIIIIlIIIlllIIllII == 2 && !lllllllllllIIIIIIIIlIIIlllIIllll.func_190926_b()) {
            return ItemStackHelper.getAndSplit(this.theInventory, lllllllllllIIIIIIIIlIIIlllIIllII, lllllllllllIIIIIIIIlIIIlllIIllll.func_190916_E());
        }
        final ItemStack lllllllllllIIIIIIIIlIIIlllIIlllI = ItemStackHelper.getAndSplit(this.theInventory, lllllllllllIIIIIIIIlIIIlllIIllII, lllllllllllIIIIIIIIlIIIlllIlIIII);
        if (!lllllllllllIIIIIIIIlIIIlllIIlllI.func_190926_b() && this.inventoryResetNeededOnSlotChange(lllllllllllIIIIIIIIlIIIlllIIllII)) {
            this.resetRecipeAndSlots();
        }
        return lllllllllllIIIIIIIIlIIIlllIIlllI;
    }
    
    public MerchantRecipe getCurrentRecipe() {
        return this.currentRecipe;
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    public void setCurrentRecipeIndex(final int lllllllllllIIIIIIIIlIIIllIIIlIII) {
        this.currentRecipeIndex = lllllllllllIIIIIIIIlIIIllIIIlIII;
        this.resetRecipeAndSlots();
    }
    
    @Override
    public void markDirty() {
        this.resetRecipeAndSlots();
    }
    
    public InventoryMerchant(final EntityPlayer lllllllllllIIIIIIIIlIIIllllIllIl, final IMerchant lllllllllllIIIIIIIIlIIIllllIlIIl) {
        this.theInventory = NonNullList.func_191197_a(3, ItemStack.field_190927_a);
        this.thePlayer = lllllllllllIIIIIIIIlIIIllllIllIl;
        this.theMerchant = lllllllllllIIIIIIIIlIIIllllIlIIl;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllIIIIIIIIlIIIllIlIIllI) {
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllIIIIIIIIlIIIllIlIlIlI) {
        return this.theMerchant.getCustomer() == lllllllllllIIIIIIIIlIIIllIlIlIlI;
    }
    
    @Override
    public int getField(final int lllllllllllIIIIIIIIlIIIllIIIIllI) {
        return 0;
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllIIIIIIIIlIIIlllIllIII) {
        return this.theInventory.get(lllllllllllIIIIIIIIlIIIlllIllIII);
    }
    
    @Override
    public void setField(final int lllllllllllIIIIIIIIlIIIllIIIIlII, final int lllllllllllIIIIIIIIlIIIllIIIIIll) {
    }
}
