// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.impl;

import java.util.function.Supplier;
import ru.rockstar.client.ui.settings.Setting;

public class StringSetting extends Setting
{
    public /* synthetic */ String currentText;
    public /* synthetic */ String defaultText;
    
    public void setCurrentText(final String llllllllllllIlllIIlIIIlIIIIllIII) {
        this.currentText = llllllllllllIlllIIlIIIlIIIIllIII;
    }
    
    public StringSetting(final String llllllllllllIlllIIlIIIlIIIllIIlI, final String llllllllllllIlllIIlIIIlIIIllIIIl, final String llllllllllllIlllIIlIIIlIIIllIIII, final Supplier<Boolean> llllllllllllIlllIIlIIIlIIIlIlIlI) {
        this.name = llllllllllllIlllIIlIIIlIIIllIIlI;
        this.defaultText = llllllllllllIlllIIlIIIlIIIllIIIl;
        this.currentText = llllllllllllIlllIIlIIIlIIIllIIII;
        this.setVisible(llllllllllllIlllIIlIIIlIIIlIlIlI);
    }
    
    public String getDefaultText() {
        return this.defaultText;
    }
    
    public String getCurrentText() {
        return this.currentText;
    }
    
    public void setDefaultText(final String llllllllllllIlllIIlIIIlIIIlIIIIl) {
        this.defaultText = llllllllllllIlllIIlIIIlIIIlIIIIl;
    }
}
