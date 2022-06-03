// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.EntityPlayer;
import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class InventoryCraftResult implements IInventory
{
    private final /* synthetic */ NonNullList<ItemStack> stackResult;
    private /* synthetic */ IRecipe field_193057_b;
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllIIllllIlIIIlIlIIlIl) {
        return this.stackResult.get(0);
    }
    
    @Override
    public int getSizeInventory() {
        return 1;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllIIllllIlIIIlIIIIlIl, final ItemStack lllllllllllllIIllllIlIIIlIIIIlII) {
        return true;
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllIIllllIlIIIlIIlIIlI, final ItemStack lllllllllllllIIllllIlIIIlIIIllll) {
        this.stackResult.set(0, lllllllllllllIIllllIlIIIlIIIllll);
    }
    
    @Override
    public int getField(final int lllllllllllllIIllllIlIIIlIIIIIlI) {
        return 0;
    }
    
    @Override
    public void setField(final int lllllllllllllIIllllIlIIIlIIIIIII, final int lllllllllllllIIllllIlIIIIlllllll) {
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIIllllIlIIIlIIlllII, final int lllllllllllllIIllllIlIIIlIIllIll) {
        return ItemStackHelper.getAndRemove(this.stackResult, 0);
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public void func_193056_a(@Nullable final IRecipe lllllllllllllIIllllIlIIIIlllIlll) {
        this.field_193057_b = lllllllllllllIIllllIlIIIIlllIlll;
    }
    
    @Nullable
    public IRecipe func_193055_i() {
        return this.field_193057_b;
    }
    
    public InventoryCraftResult() {
        this.stackResult = NonNullList.func_191197_a(1, ItemStack.field_190927_a);
    }
    
    @Override
    public String getName() {
        return "Result";
    }
    
    @Override
    public void markDirty() {
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllIIllllIlIIIlIIIlIIl) {
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllllIIllllIlIIIlIIlIlll) {
        return ItemStackHelper.getAndRemove(this.stackResult, 0);
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllIIllllIlIIIlIlIlIll : this.stackResult) {
            if (!lllllllllllllIIllllIlIIIlIlIlIll.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllllIIllllIlIIIlIIIlIll) {
        return true;
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllIIllllIlIIIlIIIIlll) {
    }
    
    @Override
    public void clear() {
        this.stackResult.clear();
    }
}
