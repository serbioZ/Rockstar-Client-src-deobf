// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.spectator;

import net.minecraft.util.text.ITextComponent;

public interface ISpectatorMenuObject
{
    boolean isEnabled();
    
    void renderIcon(final float p0, final int p1);
    
    ITextComponent getSpectatorName();
    
    void selectItem(final SpectatorMenu p0);
}
