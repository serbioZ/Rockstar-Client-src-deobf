// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.render;

public class StopWatch
{
    private /* synthetic */ long ms;
    
    public final long getElapsedTime() {
        return this.getCurrentMS() - this.ms;
    }
    
    public final boolean elapsed(final long lllllllllllIIlIIlllIIIllllIIIIlI) {
        return this.getCurrentMS() - this.ms > lllllllllllIIlIIlllIIIllllIIIIlI;
    }
    
    public StopWatch() {
        this.ms = this.getCurrentMS();
    }
    
    public final void reset() {
        this.ms = this.getCurrentMS();
    }
    
    private long getCurrentMS() {
        return System.currentTimeMillis();
    }
}
