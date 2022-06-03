// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings;

import java.util.function.Supplier;

public class Setting extends Configurable
{
    protected /* synthetic */ Supplier<Boolean> visible;
    protected /* synthetic */ String name;
    
    public boolean isVisible() {
        return this.visible.get();
    }
    
    public void setVisible(final Supplier<Boolean> llllllllllllllIIIIIllllIlIlllIlI) {
        this.visible = llllllllllllllIIIIIllllIlIlllIlI;
    }
    
    public String getName() {
        return this.name;
    }
}
