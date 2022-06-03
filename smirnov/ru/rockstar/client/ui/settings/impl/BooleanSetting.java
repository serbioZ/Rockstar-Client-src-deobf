// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.impl;

import java.util.function.Supplier;
import ru.rockstar.client.ui.settings.Setting;

public class BooleanSetting extends Setting
{
    private /* synthetic */ boolean state;
    private /* synthetic */ String desc;
    
    public BooleanSetting(final String lllllllllllIIIlllllIlIlIIllIIIlI, final String lllllllllllIIIlllllIlIlIIllIIIIl, final boolean lllllllllllIIIlllllIlIlIIllIIlIl, final Supplier<Boolean> lllllllllllIIIlllllIlIlIIllIIlII) {
        this.name = lllllllllllIIIlllllIlIlIIllIIIlI;
        this.desc = lllllllllllIIIlllllIlIlIIllIIIIl;
        this.state = lllllllllllIIIlllllIlIlIIllIIlIl;
        this.setVisible(lllllllllllIIIlllllIlIlIIllIIlII);
    }
    
    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(final String lllllllllllIIIlllllIlIlIIlIIlIlI) {
        this.desc = lllllllllllIIIlllllIlIlIIlIIlIlI;
    }
    
    public void setBoolValue(final boolean lllllllllllIIIlllllIlIlIIlIIIIIl) {
        this.state = lllllllllllIIIlllllIlIlIIlIIIIIl;
    }
    
    public boolean getBoolValue() {
        return this.state;
    }
    
    public BooleanSetting(final String lllllllllllIIIlllllIlIlIIlIllIIl, final boolean lllllllllllIIIlllllIlIlIIlIllIII, final Supplier<Boolean> lllllllllllIIIlllllIlIlIIlIlIlll) {
        this.name = lllllllllllIIIlllllIlIlIIlIllIIl;
        this.state = lllllllllllIIIlllllIlIlIIlIllIII;
        this.setVisible(lllllllllllIIIlllllIlIlIIlIlIlll);
    }
}
