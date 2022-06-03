// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import com.google.common.collect.Lists;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import java.util.List;

public class InventoryBasic implements IInventory
{
    private /* synthetic */ List<IInventoryChangedListener> changeListeners;
    private final /* synthetic */ NonNullList<ItemStack> inventoryContents;
    private final /* synthetic */ int slotsCount;
    private /* synthetic */ String inventoryTitle;
    private /* synthetic */ boolean hasCustomName;
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllIIIlllIlIlllIIllIlllI : this.inventoryContents) {
            if (!lllllllllllIIIlllIlIlllIIllIlllI.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllIIIlllIlIlllIIlIIllll) {
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllIIIlllIlIlllIlIlIlIll) {
        return (lllllllllllIIIlllIlIlllIlIlIlIll >= 0 && lllllllllllIIIlllIlIlllIlIlIlIll < this.inventoryContents.size()) ? this.inventoryContents.get(lllllllllllIIIlllIlIlllIlIlIlIll) : ItemStack.field_190927_a;
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public int getSizeInventory() {
        return this.slotsCount;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public void clear() {
        this.inventoryContents.clear();
    }
    
    public void setCustomName(final String lllllllllllIIIlllIlIlllIIllIIIIl) {
        this.hasCustomName = true;
        this.inventoryTitle = lllllllllllIIIlllIlIlllIIllIIIIl;
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllIIIlllIlIlllIIlIlIIll) {
        return true;
    }
    
    @Override
    public void markDirty() {
        if (this.changeListeners != null) {
            for (int lllllllllllIIIlllIlIlllIIlIlIlll = 0; lllllllllllIIIlllIlIlllIIlIlIlll < this.changeListeners.size(); ++lllllllllllIIIlllIlIlllIIlIlIlll) {
                this.changeListeners.get(lllllllllllIIIlllIlIlllIIlIlIlll).onInventoryChanged(this);
            }
        }
    }
    
    @Override
    public String getName() {
        return this.inventoryTitle;
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllIIIlllIlIlllIIllllIlI, final ItemStack lllllllllllIIIlllIlIlllIIllllIIl) {
        this.inventoryContents.set(lllllllllllIIIlllIlIlllIIllllIlI, lllllllllllIIIlllIlIlllIIllllIIl);
        if (!lllllllllllIIIlllIlIlllIIllllIIl.func_190926_b() && lllllllllllIIIlllIlIlllIIllllIIl.func_190916_E() > this.getInventoryStackLimit()) {
            lllllllllllIIIlllIlIlllIIllllIIl.func_190920_e(this.getInventoryStackLimit());
        }
        this.markDirty();
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllIIIlllIlIlllIlIlIIIll, final int lllllllllllIIIlllIlIlllIlIIllllI) {
        final ItemStack lllllllllllIIIlllIlIlllIlIlIIIIl = ItemStackHelper.getAndSplit(this.inventoryContents, lllllllllllIIIlllIlIlllIlIlIIIll, lllllllllllIIIlllIlIlllIlIIllllI);
        if (!lllllllllllIIIlllIlIlllIlIlIIIIl.func_190926_b()) {
            this.markDirty();
        }
        return lllllllllllIIIlllIlIlllIlIlIIIIl;
    }
    
    public ItemStack addItem(final ItemStack lllllllllllIIIlllIlIlllIlIIIllIl) {
        final ItemStack lllllllllllIIIlllIlIlllIlIIlIIll = lllllllllllIIIlllIlIlllIlIIIllIl.copy();
        for (int lllllllllllIIIlllIlIlllIlIIlIIlI = 0; lllllllllllIIIlllIlIlllIlIIlIIlI < this.slotsCount; ++lllllllllllIIIlllIlIlllIlIIlIIlI) {
            final ItemStack lllllllllllIIIlllIlIlllIlIIlIIIl = this.getStackInSlot(lllllllllllIIIlllIlIlllIlIIlIIlI);
            if (lllllllllllIIIlllIlIlllIlIIlIIIl.func_190926_b()) {
                this.setInventorySlotContents(lllllllllllIIIlllIlIlllIlIIlIIlI, lllllllllllIIIlllIlIlllIlIIlIIll);
                this.markDirty();
                return ItemStack.field_190927_a;
            }
            if (ItemStack.areItemsEqual(lllllllllllIIIlllIlIlllIlIIlIIIl, lllllllllllIIIlllIlIlllIlIIlIIll)) {
                final int lllllllllllIIIlllIlIlllIlIIlIIII = Math.min(this.getInventoryStackLimit(), lllllllllllIIIlllIlIlllIlIIlIIIl.getMaxStackSize());
                final int lllllllllllIIIlllIlIlllIlIIIllll = Math.min(lllllllllllIIIlllIlIlllIlIIlIIll.func_190916_E(), lllllllllllIIIlllIlIlllIlIIlIIII - lllllllllllIIIlllIlIlllIlIIlIIIl.func_190916_E());
                if (lllllllllllIIIlllIlIlllIlIIIllll > 0) {
                    lllllllllllIIIlllIlIlllIlIIlIIIl.func_190917_f(lllllllllllIIIlllIlIlllIlIIIllll);
                    lllllllllllIIIlllIlIlllIlIIlIIll.func_190918_g(lllllllllllIIIlllIlIlllIlIIIllll);
                    if (lllllllllllIIIlllIlIlllIlIIlIIll.func_190926_b()) {
                        this.markDirty();
                        return ItemStack.field_190927_a;
                    }
                }
            }
        }
        if (lllllllllllIIIlllIlIlllIlIIlIIll.func_190916_E() != lllllllllllIIIlllIlIlllIlIIIllIl.func_190916_E()) {
            this.markDirty();
        }
        return lllllllllllIIIlllIlIlllIlIIlIIll;
    }
    
    public void addInventoryChangeListener(final IInventoryChangedListener lllllllllllIIIlllIlIlllIlIllIlIl) {
        if (this.changeListeners == null) {
            this.changeListeners = (List<IInventoryChangedListener>)Lists.newArrayList();
        }
        this.changeListeners.add(lllllllllllIIIlllIlIlllIlIllIlIl);
    }
    
    @Override
    public void setField(final int lllllllllllIIIlllIlIlllIIlIIlIII, final int lllllllllllIIIlllIlIlllIIlIIIlll) {
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    public InventoryBasic(final String lllllllllllIIIlllIlIlllIllIIlIlI, final boolean lllllllllllIIIlllIlIlllIllIIlIIl, final int lllllllllllIIIlllIlIlllIllIIlIII) {
        this.inventoryTitle = lllllllllllIIIlllIlIlllIllIIlIlI;
        this.hasCustomName = lllllllllllIIIlllIlIlllIllIIlIIl;
        this.slotsCount = lllllllllllIIIlllIlIlllIllIIlIII;
        this.inventoryContents = NonNullList.func_191197_a(lllllllllllIIIlllIlIlllIllIIlIII, ItemStack.field_190927_a);
    }
    
    @Override
    public boolean hasCustomName() {
        return this.hasCustomName;
    }
    
    public void removeInventoryChangeListener(final IInventoryChangedListener lllllllllllIIIlllIlIlllIlIlIllll) {
        this.changeListeners.remove(lllllllllllIIIlllIlIlllIlIlIllll);
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllIIIlllIlIlllIlIIIIIll) {
        final ItemStack lllllllllllIIIlllIlIlllIlIIIIIlI = this.inventoryContents.get(lllllllllllIIIlllIlIlllIlIIIIIll);
        if (lllllllllllIIIlllIlIlllIlIIIIIlI.func_190926_b()) {
            return ItemStack.field_190927_a;
        }
        this.inventoryContents.set(lllllllllllIIIlllIlIlllIlIIIIIll, ItemStack.field_190927_a);
        return lllllllllllIIIlllIlIlllIlIIIIIlI;
    }
    
    public InventoryBasic(final ITextComponent lllllllllllIIIlllIlIlllIlIllllII, final int lllllllllllIIIlllIlIlllIlIlllllI) {
        this(lllllllllllIIIlllIlIlllIlIllllII.getUnformattedText(), true, lllllllllllIIIlllIlIlllIlIlllllI);
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllIIIlllIlIlllIIlIIllIl, final ItemStack lllllllllllIIIlllIlIlllIIlIIllII) {
        return true;
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllIIIlllIlIlllIIlIlIIIl) {
    }
    
    @Override
    public int getField(final int lllllllllllIIIlllIlIlllIIlIIlIlI) {
        return 0;
    }
}
