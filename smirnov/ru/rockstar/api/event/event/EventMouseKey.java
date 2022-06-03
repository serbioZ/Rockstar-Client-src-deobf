// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import ru.rockstar.api.event.Event;

public class EventMouseKey extends Event
{
    private /* synthetic */ int key;
    
    public void setKey(final int llllllllllIlllIllIIIlIllIlIlIlIl) {
        this.key = llllllllllIlllIllIIIlIllIlIlIlIl;
    }
    
    public EventMouseKey(final int llllllllllIlllIllIIIlIllIlIllllI) {
        this.key = llllllllllIlllIllIIIlIllIlIllllI;
    }
    
    public int getKey() {
        return this.key;
    }
}
