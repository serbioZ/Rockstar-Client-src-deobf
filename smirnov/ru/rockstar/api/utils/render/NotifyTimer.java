// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.render;

public class NotifyTimer
{
    private /* synthetic */ long ms;
    
    private long getCurrentMS() {
        return System.currentTimeMillis();
    }
    
    public NotifyTimer() {
        this.ms = this.getCurrentMS();
    }
    
    public final long getElapsedTime() {
        return this.getCurrentMS() - this.ms;
    }
    
    public final boolean elapsed(final long lllllllllllIlIlIIIlIlIIlIIIIIIIl) {
        return this.getCurrentMS() - this.ms > lllllllllllIlIlIIIlIlIIlIIIIIIIl;
    }
    
    public final void reset() {
        this.ms = this.getCurrentMS();
    }
}
