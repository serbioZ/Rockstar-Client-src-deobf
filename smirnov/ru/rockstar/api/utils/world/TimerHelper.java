// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.world;

public class TimerHelper
{
    private /* synthetic */ long tick;
    public static /* synthetic */ long previousTime;
    public static /* synthetic */ float timerSpeed;
    private /* synthetic */ long lastMS;
    private /* synthetic */ long prevMS;
    
    public boolean delay(final float lllllllllllllIlIlIIlIllIIlIlIIII) {
        return this.getTime() - this.prevMS >= lllllllllllllIlIlIIlIllIIlIlIIII;
    }
    
    public void setTime(final long lllllllllllllIlIlIIlIllIIlIIlIII) {
        this.lastMS = lllllllllllllIlIlIIlIllIIlIIlIII;
    }
    
    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }
    
    public TimerHelper() {
        this.tick = 0L;
        this.prevMS = 0L;
    }
    
    public boolean check(final float lllllllllllllIlIlIIlIllIIllllIII) {
        return getCurrentTime() - TimerHelper.previousTime >= lllllllllllllIlIlIIlIllIIllllIII;
    }
    
    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }
    
    public void setDifference(final long lllllllllllllIlIlIIlIllIIllIIlII) {
        this.prevMS = this.getTime() - lllllllllllllIlIlIIlIllIIllIIlII;
    }
    
    public long getTime() {
        return this.getCurrentMS() - this.lastMS;
    }
    
    public boolean hasTimePassed(final float lllllllllllllIlIlIIlIllIIlIllIlI) {
        return this.tick >= lllllllllllllIlIlIIlIllIIlIllIlI;
    }
    
    public long getDifference() {
        return this.getTime() - this.prevMS;
    }
    
    public boolean hasTimeElapsed(final long lllllllllllllIlIlIIlIllIIlllIIIl, final boolean lllllllllllllIlIlIIlIllIIllIllIl) {
        if (System.currentTimeMillis() - this.lastMS > lllllllllllllIlIlIIlIllIIlllIIIl) {
            if (lllllllllllllIlIlIIlIllIIllIllIl) {
                this.reset();
            }
            return true;
        }
        return false;
    }
    
    static {
        TimerHelper.previousTime = -1L;
        TimerHelper.timerSpeed = 1.0f;
    }
    
    public boolean hasReached(final double lllllllllllllIlIlIIlIllIIllIIIII) {
        return this.getCurrentMS() - this.lastMS >= lllllllllllllIlIlIIlIllIIllIIIII;
    }
    
    public void resetwatermark() {
        TimerHelper.previousTime = getCurrentTime();
    }
    
    public void reset() {
        this.lastMS = this.getCurrentMS();
    }
}
