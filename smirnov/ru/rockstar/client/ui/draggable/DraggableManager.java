// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable;

import ru.rockstar.client.ui.draggable.impl.TargetHudComponent;
import ru.rockstar.client.ui.draggable.impl.InvPreviewComponent;
import ru.rockstar.client.ui.draggable.impl.DmgflyComponent;
import ru.rockstar.client.ui.draggable.impl.TimerComponent;
import ru.rockstar.client.ui.draggable.impl.KeystrokesComponent;
import java.util.ArrayList;

public class DraggableManager
{
    public /* synthetic */ ArrayList<DraggableModule> mods;
    
    public ArrayList<DraggableModule> getMods() {
        return this.mods;
    }
    
    public void setMods(final ArrayList<DraggableModule> lllllllllllllIIIIIIIlIllIllIlIlI) {
        this.mods = lllllllllllllIIIIIIIlIllIllIlIlI;
    }
    
    public DraggableManager() {
        this.mods = new ArrayList<DraggableModule>();
        this.mods.add(new KeystrokesComponent());
        this.mods.add(new TimerComponent());
        this.mods.add(new DmgflyComponent());
        this.mods.add(new InvPreviewComponent());
        this.mods.add(new TargetHudComponent());
    }
}
