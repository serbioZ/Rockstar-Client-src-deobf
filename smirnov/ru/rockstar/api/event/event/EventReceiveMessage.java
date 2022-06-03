// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import ru.rockstar.api.event.Event;

public class EventReceiveMessage extends Event
{
    public /* synthetic */ String message;
    public /* synthetic */ boolean cancelled;
    
    public EventReceiveMessage(final String lllllllllllIlllIIIIIlIIlIlIlIIII) {
        this.message = lllllllllllIlllIIIIIlIIlIlIlIIII;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public void setCancelled(final boolean lllllllllllIlllIIIIIlIIlIlIIIlIl) {
        this.cancelled = lllllllllllIlllIIIIIlIIlIlIIIlIl;
    }
}
