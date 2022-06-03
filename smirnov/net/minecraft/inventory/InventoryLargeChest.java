// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.LockCode;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.ILockableContainer;

public class InventoryLargeChest implements ILockableContainer
{
    private final /* synthetic */ String name;
    private final /* synthetic */ ILockableContainer lowerChest;
    private final /* synthetic */ ILockableContainer upperChest;
    
    @Override
    public int getInventoryStackLimit() {
        return this.upperChest.getInventoryStackLimit();
    }
    
    @Override
    public int getField(final int llllllllllllIlIIIllIlIlIIlIIllII) {
        return 0;
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public boolean isLocked() {
        return this.upperChest.isLocked() || this.lowerChest.isLocked();
    }
    
    @Override
    public boolean hasCustomName() {
        return this.upperChest.hasCustomName() || this.lowerChest.hasCustomName();
    }
    
    @Override
    public void clear() {
        this.upperChest.clear();
        this.lowerChest.clear();
    }
    
    public InventoryLargeChest(final String llllllllllllIlIIIllIlIlIlIIllllI, ILockableContainer llllllllllllIlIIIllIlIlIlIIlllIl, ILockableContainer llllllllllllIlIIIllIlIlIlIIlllII) {
        this.name = llllllllllllIlIIIllIlIlIlIIllllI;
        if (llllllllllllIlIIIllIlIlIlIIlllIl == null) {
            llllllllllllIlIIIllIlIlIlIIlllIl = llllllllllllIlIIIllIlIlIlIIlllII;
        }
        if (llllllllllllIlIIIllIlIlIlIIlllII == null) {
            llllllllllllIlIIIllIlIlIlIIlllII = llllllllllllIlIIIllIlIlIlIIlllIl;
        }
        this.upperChest = llllllllllllIlIIIllIlIlIlIIlllIl;
        this.lowerChest = llllllllllllIlIIIllIlIlIlIIlllII;
        if (llllllllllllIlIIIllIlIlIlIIlllIl.isLocked()) {
            llllllllllllIlIIIllIlIlIlIIlllII.setLockCode(llllllllllllIlIIIllIlIlIlIIlllIl.getLockCode());
        }
        else if (llllllllllllIlIIIllIlIlIlIIlllII.isLocked()) {
            llllllllllllIlIIIllIlIlIlIIlllIl.setLockCode(llllllllllllIlIIIllIlIlIlIIlllII.getLockCode());
        }
    }
    
    @Override
    public void setLockCode(final LockCode llllllllllllIlIIIllIlIlIIlIIIIIl) {
        this.upperChest.setLockCode(llllllllllllIlIIIllIlIlIIlIIIIIl);
        this.lowerChest.setLockCode(llllllllllllIlIIIllIlIlIIlIIIIIl);
    }
    
    @Override
    public LockCode getLockCode() {
        return this.upperChest.getLockCode();
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer llllllllllllIlIIIllIlIlIIlIlllll) {
        return this.upperChest.isUsableByPlayer(llllllllllllIlIIIllIlIlIIlIlllll) && this.lowerChest.isUsableByPlayer(llllllllllllIlIIIllIlIlIIlIlllll);
    }
    
    @Override
    public boolean func_191420_l() {
        return this.upperChest.func_191420_l() && this.lowerChest.func_191420_l();
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllIlIIIllIlIlIIlIlIIll) {
        this.upperChest.closeInventory(llllllllllllIlIIIllIlIlIIlIlIIll);
        this.lowerChest.closeInventory(llllllllllllIlIIIllIlIlIIlIlIIll);
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllIlIIIllIlIlIIIllIIIl, final EntityPlayer llllllllllllIlIIIllIlIlIIIllIIll) {
        return new ContainerChest(llllllllllllIlIIIllIlIlIIIllIIIl, this, llllllllllllIlIIIllIlIlIIIllIIll);
    }
    
    public boolean isPartOfLargeChest(final IInventory llllllllllllIlIIIllIlIlIlIIlIIlI) {
        return this.upperChest == llllllllllllIlIIIllIlIlIlIIlIIlI || this.lowerChest == llllllllllllIlIIIllIlIlIlIIlIIlI;
    }
    
    @Override
    public String getGuiID() {
        return this.upperChest.getGuiID();
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllIlIIIllIlIlIIllIllIl, final ItemStack llllllllllllIlIIIllIlIlIIllIllII) {
        if (llllllllllllIlIIIllIlIlIIllIllIl >= this.upperChest.getSizeInventory()) {
            this.lowerChest.setInventorySlotContents(llllllllllllIlIIIllIlIlIIllIllIl - this.upperChest.getSizeInventory(), llllllllllllIlIIIllIlIlIIllIllII);
        }
        else {
            this.upperChest.setInventorySlotContents(llllllllllllIlIIIllIlIlIIllIllIl, llllllllllllIlIIIllIlIlIIllIllII);
        }
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int llllllllllllIlIIIllIlIlIIlllIIlI) {
        return (llllllllllllIlIIIllIlIlIIlllIIlI >= this.upperChest.getSizeInventory()) ? this.lowerChest.removeStackFromSlot(llllllllllllIlIIIllIlIlIIlllIIlI - this.upperChest.getSizeInventory()) : this.upperChest.removeStackFromSlot(llllllllllllIlIIIllIlIlIIlllIIlI);
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllIlIIIllIlIlIIlIlIlll) {
        this.upperChest.openInventory(llllllllllllIlIIIllIlIlIIlIlIlll);
        this.lowerChest.openInventory(llllllllllllIlIIIllIlIlIIlIlIlll);
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllIlIIIllIlIlIIlIIllll, final ItemStack llllllllllllIlIIIllIlIlIIlIIlllI) {
        return true;
    }
    
    @Override
    public void markDirty() {
        this.upperChest.markDirty();
        this.lowerChest.markDirty();
    }
    
    @Override
    public int getSizeInventory() {
        return this.upperChest.getSizeInventory() + this.lowerChest.getSizeInventory();
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllIlIIIllIlIlIlIIIIIll) {
        return (llllllllllllIlIIIllIlIlIlIIIIIll >= this.upperChest.getSizeInventory()) ? this.lowerChest.getStackInSlot(llllllllllllIlIIIllIlIlIlIIIIIll - this.upperChest.getSizeInventory()) : this.upperChest.getStackInSlot(llllllllllllIlIIIllIlIlIlIIIIIll);
    }
    
    @Override
    public String getName() {
        if (this.upperChest.hasCustomName()) {
            return this.upperChest.getName();
        }
        return this.lowerChest.hasCustomName() ? this.lowerChest.getName() : this.name;
    }
    
    @Override
    public void setField(final int llllllllllllIlIIIllIlIlIIlIIlIlI, final int llllllllllllIlIIIllIlIlIIlIIlIIl) {
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllIlIIIllIlIlIIlllllII, final int llllllllllllIlIIIllIlIlIIllllIll) {
        return (llllllllllllIlIIIllIlIlIIlllllII >= this.upperChest.getSizeInventory()) ? this.lowerChest.decrStackSize(llllllllllllIlIIIllIlIlIIlllllII - this.upperChest.getSizeInventory(), llllllllllllIlIIIllIlIlIIllllIll) : this.upperChest.decrStackSize(llllllllllllIlIIIllIlIlIIlllllII, llllllllllllIlIIIllIlIlIIllllIll);
    }
}
