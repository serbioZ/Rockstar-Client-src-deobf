// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import org.w3c.dom.events.Event;

public abstract class EventPreMotion implements Event
{
    private /* synthetic */ double posY;
    private /* synthetic */ double posX;
    private /* synthetic */ boolean onGround;
    private /* synthetic */ float yaw;
    private /* synthetic */ double posZ;
    private /* synthetic */ float pitch;
    
    public EventPreMotion(final float llllllllllllIIIllIIlIllIIlIIIllI, final float llllllllllllIIIllIIlIllIIlIIIlIl, final double llllllllllllIIIllIIlIllIIIllllIl, final double llllllllllllIIIllIIlIllIIlIIIIll, final double llllllllllllIIIllIIlIllIIlIIIIlI, final boolean llllllllllllIIIllIIlIllIIlIIIIIl) {
        this.yaw = llllllllllllIIIllIIlIllIIlIIIllI;
        this.pitch = llllllllllllIIIllIIlIllIIlIIIlIl;
        this.posX = llllllllllllIIIllIIlIllIIIllllIl;
        this.posY = llllllllllllIIIllIIlIllIIlIIIIll;
        this.posZ = llllllllllllIIIllIIlIllIIlIIIIlI;
        this.onGround = llllllllllllIIIllIIlIllIIlIIIIIl;
    }
    
    public void setPosX(final double llllllllllllIIIllIIlIllIIIlIIIIl) {
        this.posX = llllllllllllIIIllIIlIllIIIlIIIIl;
    }
    
    public boolean isOnGround() {
        return this.onGround;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public double getPosY() {
        return this.posY;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public double getPosZ() {
        return this.posZ;
    }
    
    public void setPitch(final float llllllllllllIIIllIIlIllIIIlIlIII) {
        this.pitch = llllllllllllIIIllIIlIllIIIlIlIII;
    }
    
    public double getPosX() {
        return this.posX;
    }
    
    public void setPosY(final double llllllllllllIIIllIIlIllIIIIllIII) {
        this.posY = llllllllllllIIIllIIlIllIIIIllIII;
    }
    
    public void setPosZ(final double llllllllllllIIIllIIlIllIIIIIllll) {
        this.posZ = llllllllllllIIIllIIlIllIIIIIllll;
    }
    
    public void setYaw(final float llllllllllllIIIllIIlIllIIIllIIll) {
        this.yaw = llllllllllllIIIllIIlIllIIIllIIll;
    }
    
    public void setOnGround(final boolean llllllllllllIIIllIIlIllIIIIIIlII) {
        this.onGround = llllllllllllIIIllIIlIllIIIIIIlII;
    }
}
