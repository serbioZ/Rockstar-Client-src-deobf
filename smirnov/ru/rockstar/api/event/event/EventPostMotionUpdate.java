// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import ru.rockstar.api.event.Event;

public class EventPostMotionUpdate extends Event
{
    public /* synthetic */ boolean ground;
    public /* synthetic */ float pitch;
    public /* synthetic */ double y;
    public /* synthetic */ float yaw;
    
    public void setGround(final boolean llllllllllllIlIlIIIIIlllllIlIlIl) {
        this.ground = llllllllllllIlIlIIIIIlllllIlIlIl;
    }
    
    public void setYaw(final float llllllllllllIlIlIIIIIllllllIIlll) {
        this.yaw = llllllllllllIlIlIIIIIllllllIIlll;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public EventPostMotionUpdate(final float llllllllllllIlIlIIIIIlllllllIIll, final float llllllllllllIlIlIIIIIlllllllIlll, final boolean llllllllllllIlIlIIIIIlllllllIIIl, final double llllllllllllIlIlIIIIIlllllllIlIl) {
        this.yaw = llllllllllllIlIlIIIIIlllllllIIll;
        this.pitch = llllllllllllIlIlIIIIIlllllllIlll;
        this.ground = llllllllllllIlIlIIIIIlllllllIIIl;
        this.y = llllllllllllIlIlIIIIIlllllllIlIl;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setPitch(final float llllllllllllIlIlIIIIIllllllIIIII) {
        this.pitch = llllllllllllIlIlIIIIIllllllIIIII;
    }
    
    public void setY(final double llllllllllllIlIlIIIIIlllllIIllII) {
        this.y = llllllllllllIlIlIIIIIlllllIIllII;
    }
    
    public boolean isGround() {
        return this.ground;
    }
    
    public double getY() {
        return this.y;
    }
}
