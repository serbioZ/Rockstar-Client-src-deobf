// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.impl;

import java.util.function.Supplier;
import ru.rockstar.client.ui.settings.Setting;

public class ColorSetting extends Setting
{
    private /* synthetic */ int color;
    
    public void setColorValue(final int lllllllllllIIIllIlIIlllIIlIllIlI) {
        this.color = lllllllllllIIIllIlIIlllIIlIllIlI;
    }
    
    public int getColorValue() {
        return this.color;
    }
    
    public ColorSetting(final String lllllllllllIIIllIlIIlllIIllIlIIl, final int lllllllllllIIIllIlIIlllIIllIlIII, final Supplier<Boolean> lllllllllllIIIllIlIIlllIIllIIIll) {
        this.name = lllllllllllIIIllIlIIlllIIllIlIIl;
        this.color = lllllllllllIIIllIlIIlllIIllIlIII;
        this.setVisible(lllllllllllIIIllIlIIlllIIllIIIll);
    }
}
