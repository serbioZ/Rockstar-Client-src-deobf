// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import ru.rockstar.api.event.Event;

public class EventStrafe extends Event
{
    private /* synthetic */ float yaw;
    private /* synthetic */ float friction;
    private /* synthetic */ float strafe;
    private /* synthetic */ float forward;
    
    public void setFriction(final float llllllllllllllIlIIllIIIlllllIlIl) {
        this.friction = llllllllllllllIlIIllIIIlllllIlIl;
    }
    
    public void setStrafe(final float llllllllllllllIlIIllIIlIIIIIIlll) {
        this.strafe = llllllllllllllIlIIllIIlIIIIIIlll;
    }
    
    public void setForward(final float llllllllllllllIlIIllIIlIIIIIIIII) {
        this.forward = llllllllllllllIlIIllIIlIIIIIIIII;
    }
    
    public EventStrafe(final float llllllllllllllIlIIllIIlIIIIlIIll, final float llllllllllllllIlIIllIIlIIIIlIlll, final float llllllllllllllIlIIllIIlIIIIlIIIl, final float llllllllllllllIlIIllIIlIIIIlIlIl) {
        this.yaw = llllllllllllllIlIIllIIlIIIIlIIll;
        this.strafe = llllllllllllllIlIIllIIlIIIIlIlll;
        this.forward = llllllllllllllIlIIllIIlIIIIlIIIl;
        this.friction = llllllllllllllIlIIllIIlIIIIlIlIl;
    }
    
    public float getForward() {
        return this.forward;
    }
    
    public float getStrafe() {
        return this.strafe;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setYaw(final float llllllllllllllIlIIllIIIllllIllII) {
        this.yaw = llllllllllllllIlIIllIIIllllIllII;
    }
    
    public float getFriction() {
        return this.friction;
    }
}
