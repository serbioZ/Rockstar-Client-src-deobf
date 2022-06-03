// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;

public interface ISidedInventory extends IInventory
{
    boolean canInsertItem(final int p0, final ItemStack p1, final EnumFacing p2);
    
    int[] getSlotsForFace(final EnumFacing p0);
    
    boolean canExtractItem(final int p0, final ItemStack p1, final EnumFacing p2);
}
