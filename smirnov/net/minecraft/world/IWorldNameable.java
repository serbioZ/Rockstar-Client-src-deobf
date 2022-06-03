// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.util.text.ITextComponent;

public interface IWorldNameable
{
    ITextComponent getDisplayName();
    
    boolean hasCustomName();
    
    String getName();
}
