// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IWorldNameable;

public interface IInventory extends IWorldNameable
{
    ItemStack removeStackFromSlot(final int p0);
    
    void openInventory(final EntityPlayer p0);
    
    int getInventoryStackLimit();
    
    boolean func_191420_l();
    
    int getFieldCount();
    
    void markDirty();
    
    ItemStack getStackInSlot(final int p0);
    
    boolean isItemValidForSlot(final int p0, final ItemStack p1);
    
    void clear();
    
    boolean isUsableByPlayer(final EntityPlayer p0);
    
    int getSizeInventory();
    
    int getField(final int p0);
    
    void setInventorySlotContents(final int p0, final ItemStack p1);
    
    ItemStack decrStackSize(final int p0, final int p1);
    
    void closeInventory(final EntityPlayer p0);
    
    void setField(final int p0, final int p1);
}
