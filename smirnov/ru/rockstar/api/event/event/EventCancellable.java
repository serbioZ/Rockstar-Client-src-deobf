// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import ru.rockstar.api.event.Cancellable;

public abstract class EventCancellable implements Cancellable
{
    private /* synthetic */ boolean cancelled;
    
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    @Override
    public void setCancelled(final boolean lllllllllllIlIIlIIIlIlIllIIlIIII) {
        this.cancelled = lllllllllllIlIIlIIIlIlIllIIlIIII;
    }
}
