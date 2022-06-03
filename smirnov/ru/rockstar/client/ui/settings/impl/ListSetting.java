// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.impl;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.List;
import ru.rockstar.client.ui.settings.Setting;

public class ListSetting extends Setting
{
    public /* synthetic */ String currentMode;
    public /* synthetic */ int index;
    public final /* synthetic */ List<String> modes;
    
    public ListSetting(final String lllllllllllllIIIIIlIllIIlIIlIIll, final String lllllllllllllIIIIIlIllIIlIIIllIl, final Supplier<Boolean> lllllllllllllIIIIIlIllIIlIIlIIIl, final String... lllllllllllllIIIIIlIllIIlIIlIIII) {
        this.name = lllllllllllllIIIIIlIllIIlIIlIIll;
        this.modes = Arrays.asList(lllllllllllllIIIIIlIllIIlIIlIIII);
        this.index = this.modes.indexOf(lllllllllllllIIIIIlIllIIlIIIllIl);
        this.currentMode = this.modes.get(this.index);
        this.setVisible(lllllllllllllIIIIIlIllIIlIIlIIIl);
        this.addSettings(this);
    }
    
    public String getOptions() {
        return this.modes.get(this.index);
    }
    
    public String getCurrentMode() {
        return this.currentMode;
    }
    
    public List<String> getModes() {
        return this.modes;
    }
    
    public void setListMode(final String lllllllllllllIIIIIlIllIIlIIIIlII) {
        this.currentMode = lllllllllllllIIIIIlIllIIlIIIIlII;
        this.index = this.modes.indexOf(lllllllllllllIIIIIlIllIIlIIIIlII);
    }
}
