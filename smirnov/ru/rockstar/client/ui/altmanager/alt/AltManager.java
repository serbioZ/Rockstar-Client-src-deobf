// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager.alt;

import java.util.ArrayList;

public class AltManager
{
    public static /* synthetic */ ArrayList<Alt> registry;
    public static /* synthetic */ Alt lastAlt;
    
    public void setLastAlt(final Alt lllllllllllllIIIlllIIIIlIlllllII) {
        AltManager.lastAlt = lllllllllllllIIIlllIIIIlIlllllII;
    }
    
    public ArrayList<Alt> getRegistry() {
        return AltManager.registry;
    }
    
    static {
        AltManager.registry = new ArrayList<Alt>();
    }
}
