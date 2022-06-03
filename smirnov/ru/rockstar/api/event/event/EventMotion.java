// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import ru.rockstar.api.event.Event;

public class EventMotion extends Event
{
    private /* synthetic */ double y;
    public static /* synthetic */ float PITCH;
    private final /* synthetic */ boolean isPre;
    public static /* synthetic */ float PREVYAW;
    private /* synthetic */ boolean onground;
    public static /* synthetic */ float PREVPITCH;
    public static /* synthetic */ boolean SNEAKING;
    public static /* synthetic */ float YAW;
    private /* synthetic */ boolean sneaking;
    private /* synthetic */ double x;
    private /* synthetic */ double z;
    private /* synthetic */ float pitch;
    private /* synthetic */ float yaw;
    private /* synthetic */ boolean alwaysSend;
    
    public double getY() {
        return this.y;
    }
    
    public void setX(final double llllllllllllIlIllIlIIllIIIlllIlI) {
        this.x = llllllllllllIlIllIlIIllIIIlllIlI;
    }
    
    public void setPitch(final float llllllllllllIlIllIlIIllIIlIIIIIl) {
        this.pitch = llllllllllllIlIllIlIIllIIlIIIIIl;
    }
    
    public boolean isPre() {
        return this.isPre;
    }
    
    public boolean shouldAlwaysSend() {
        return this.alwaysSend;
    }
    
    public void setOnGround(final boolean llllllllllllIlIllIlIIllIIIIIIlll) {
        this.onground = llllllllllllIlIllIlIIllIIIIIIlll;
    }
    
    public double getX() {
        return this.x;
    }
    
    public EventMotion(final double llllllllllllIlIllIlIIllIIllIlIlI, final double llllllllllllIlIllIlIIllIIllIlIIl, final double llllllllllllIlIllIlIIllIIllIIIII, final float llllllllllllIlIllIlIIllIIllIIlll, final float llllllllllllIlIllIlIIllIIlIllllI, final boolean llllllllllllIlIllIlIIllIIlIlllIl, final boolean llllllllllllIlIllIlIIllIIlIlllII) {
        this.y = llllllllllllIlIllIlIIllIIllIlIIl;
        this.x = llllllllllllIlIllIlIIllIIllIlIlI;
        this.z = llllllllllllIlIllIlIIllIIllIIIII;
        this.isPre = true;
        this.yaw = llllllllllllIlIllIlIIllIIllIIlll;
        this.pitch = llllllllllllIlIllIlIIllIIlIllllI;
        this.onground = llllllllllllIlIllIlIIllIIlIlllII;
        this.sneaking = llllllllllllIlIllIlIIllIIlIlllIl;
    }
    
    public boolean isSneaking() {
        return this.sneaking;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void setYaw(final float llllllllllllIlIllIlIIllIIlIIlIlI) {
        this.yaw = llllllllllllIlIllIlIIllIIlIIlIlI;
    }
    
    public void setAlwaysSend(final boolean llllllllllllIlIllIlIIllIIIIIllIl) {
        this.alwaysSend = llllllllllllIlIllIlIIllIIIIIllIl;
    }
    
    public EventMotion() {
        EventMotion.PREVYAW = EventMotion.YAW;
        EventMotion.PREVPITCH = EventMotion.PITCH;
        EventMotion.YAW = this.yaw;
        EventMotion.PITCH = this.pitch;
        EventMotion.SNEAKING = this.sneaking;
        this.isPre = false;
    }
    
    public void setSneaking(final boolean llllllllllllIlIllIlIIllIIIIlllll) {
        this.sneaking = llllllllllllIlIllIlIIllIIIIlllll;
    }
    
    public boolean isOnground() {
        return this.onground;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public boolean isPost() {
        return !this.isPre;
    }
    
    public void setGround(final boolean llllllllllllIlIllIlIIllIIIIlIIll) {
        this.onground = llllllllllllIlIllIlIIllIIIIlIIll;
    }
    
    public void setZ(final double llllllllllllIlIllIlIIllIIIlIIllI) {
        this.z = llllllllllllIlIllIlIIllIIIlIIllI;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setY(final double llllllllllllIlIllIlIIllIIIllIIIl) {
        this.y = llllllllllllIlIllIlIIllIIIllIIIl;
    }
    
    public boolean isRotating() {
        final double llllllllllllIlIllIlIIllIIIIIIIII = this.yaw - this.yaw;
        final double llllllllllllIlIllIlIIlIlllllllll = this.pitch - this.pitch;
        return Math.abs(llllllllllllIlIllIlIIllIIIIIIIII) != 0.0 || Math.abs(llllllllllllIlIllIlIIlIlllllllll) != 0.0;
    }
}
