// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import ru.rockstar.api.event.Event;

public class EventStep extends Event
{
    private /* synthetic */ double stepHeight;
    private /* synthetic */ boolean active;
    private /* synthetic */ double realHeight;
    private /* synthetic */ boolean pre;
    
    public double getStepHeight() {
        return this.stepHeight;
    }
    
    public EventStep(final boolean lllllllllllIlllIllIIIIIIllIIIlIl, final double lllllllllllIlllIllIIIIIIllIIIlII, final double lllllllllllIlllIllIIIIIIllIIIIll) {
        this.pre = lllllllllllIlllIllIIIIIIllIIIlIl;
        this.stepHeight = lllllllllllIlllIllIIIIIIllIIIlII;
        this.realHeight = lllllllllllIlllIllIIIIIIllIIIIll;
    }
    
    public void setRealHeight(final double lllllllllllIlllIllIIIIIIlIIllIIl) {
        this.realHeight = lllllllllllIlllIllIIIIIIlIIllIIl;
    }
    
    public EventStep() {
    }
    
    public void setStepHeight(final double lllllllllllIlllIllIIIIIIlIlIlIlI) {
        this.stepHeight = lllllllllllIlllIllIIIIIIlIlIlIlI;
    }
    
    public boolean isPre() {
        return this.pre;
    }
    
    public EventStep(final boolean lllllllllllIlllIllIIIIIIlIlllIll, final double lllllllllllIlllIllIIIIIIlIlllIlI) {
        this.pre = lllllllllllIlllIllIIIIIIlIlllIll;
        this.realHeight = lllllllllllIlllIllIIIIIIlIlllIlI;
        this.stepHeight = lllllllllllIlllIllIIIIIIlIlllIlI;
    }
    
    public void setActive(final boolean lllllllllllIlllIllIIIIIIlIlIIlII) {
        this.active = lllllllllllIlllIllIIIIIIlIlIIlII;
    }
    
    public double getRealHeight() {
        return this.realHeight;
    }
    
    public boolean isActive() {
        return this.active;
    }
}
