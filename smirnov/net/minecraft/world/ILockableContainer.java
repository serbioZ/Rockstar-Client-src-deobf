// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.inventory.IInventory;

public interface ILockableContainer extends IInteractionObject, IInventory
{
    boolean isLocked();
    
    LockCode getLockCode();
    
    void setLockCode(final LockCode p0);
}
