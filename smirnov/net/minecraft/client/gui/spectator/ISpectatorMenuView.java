// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.spectator;

import java.util.List;
import net.minecraft.util.text.ITextComponent;

public interface ISpectatorMenuView
{
    ITextComponent getPrompt();
    
    List<ISpectatorMenuObject> getItems();
}
