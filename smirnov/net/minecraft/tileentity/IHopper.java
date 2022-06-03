// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.world.World;
import net.minecraft.inventory.IInventory;

public interface IHopper extends IInventory
{
    double getZPos();
    
    double getXPos();
    
    double getYPos();
    
    World getWorld();
}
