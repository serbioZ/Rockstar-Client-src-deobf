// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings;

import java.util.List;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;

public class Configurable
{
    private final /* synthetic */ ArrayList<Setting> settingList;
    
    public final void addSettings(final Setting... llllllllllllIlIIlllIIllllIIIIIII) {
        this.settingList.addAll(Arrays.asList(llllllllllllIlIIlllIIllllIIIIIII));
    }
    
    public final List<Setting> getSettings() {
        return this.settingList;
    }
    
    public Configurable() {
        this.settingList = new ArrayList<Setting>();
    }
}
