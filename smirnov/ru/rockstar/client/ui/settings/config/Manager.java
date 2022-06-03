// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.config;

import java.util.ArrayList;
import java.util.List;

public abstract class Manager<T>
{
    private /* synthetic */ List<T> contents;
    
    public void setContents(final ArrayList<T> lllllllllllIlIllllIlIlIIllIllllI) {
        this.contents = lllllllllllIlIllllIlIlIIllIllllI;
    }
    
    public List<T> getContents() {
        return this.contents;
    }
    
    public Manager() {
        this.contents = new ArrayList<T>();
    }
}
