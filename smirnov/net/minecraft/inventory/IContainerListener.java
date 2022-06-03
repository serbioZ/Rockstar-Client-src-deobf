// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;

public interface IContainerListener
{
    void sendAllWindowProperties(final Container p0, final IInventory p1);
    
    void sendSlotContents(final Container p0, final int p1, final ItemStack p2);
    
    void updateCraftingInventory(final Container p0, final NonNullList<ItemStack> p1);
    
    void sendProgressBarUpdate(final Container p0, final int p1, final int p2);
}
