// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.client.entity.EntityPlayerSP;
import java.util.function.Consumer;
import ru.rockstar.api.event.Event;

public class EventPlayerMotionUpdate extends Event
{
    protected /* synthetic */ double z;
    protected /* synthetic */ float _pitch;
    protected /* synthetic */ boolean onGround;
    protected /* synthetic */ float _yaw;
    private /* synthetic */ Consumer<EntityPlayerSP> _funcToCall;
    protected /* synthetic */ double y;
    protected /* synthetic */ double x;
    private /* synthetic */ boolean _isForceCancelled;
    
    public boolean isForceCancelled() {
        return this._isForceCancelled;
    }
    
    public Consumer<EntityPlayerSP> getFunc() {
        return this._funcToCall;
    }
    
    public void setX(final double llllllllllIlllIIlIIlllIIIIlIllII) {
        this.x = llllllllllIlllIIlIIlllIIIIlIllII;
    }
    
    public float getYaw() {
        return this._yaw;
    }
    
    public void forceCancel() {
        this._isForceCancelled = true;
    }
    
    public void setOnGround(final boolean llllllllllIlllIIlIIlllIIIIIllIlI) {
        this.onGround = llllllllllIlllIIlIIlllIIIIIllIlI;
    }
    
    public EventPlayerMotionUpdate(final double llllllllllIlllIIlIIlllIIIllIIIlI, final double llllllllllIlllIIlIIlllIIIllIIIIl, final double llllllllllIlllIIlIIlllIIIllIIIII, final boolean llllllllllIlllIIlIIlllIIIlIlllll) {
        this._funcToCall = null;
        this.x = llllllllllIlllIIlIIlllIIIllIIIlI;
        this.y = llllllllllIlllIIlIIlllIIIllIIIIl;
        this.z = llllllllllIlllIIlIIlllIIIllIIIII;
        this.onGround = llllllllllIlllIIlIIlllIIIlIlllll;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void setYaw(final float llllllllllIlllIIlIIlllIIIlIIllll) {
        this._yaw = llllllllllIlllIIlIIlllIIIlIIllll;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setY(final double llllllllllIlllIIlIIlllIIIIlIIllI) {
        this.y = llllllllllIlllIIlIIlllIIIIlIIllI;
    }
    
    public float getPitch() {
        return this._pitch;
    }
    
    public void setZ(final double llllllllllIlllIIlIIlllIIIIlIIIlI) {
        this.z = llllllllllIlllIIlIIlllIIIIlIIIlI;
    }
    
    public boolean getOnGround() {
        return this.onGround;
    }
    
    public void setPitch(final float llllllllllIlllIIlIIlllIIIlIIIlII) {
        this._pitch = llllllllllIlllIIlIIlllIIIlIIIlII;
    }
    
    public void setPitch(final double llllllllllIlllIIlIIlllIIIIlllIlI) {
        this._pitch = (float)llllllllllIlllIIlIIlllIIIIlllIlI;
    }
    
    public void setFunct(final Consumer<EntityPlayerSP> llllllllllIlllIIlIIlllIIIlIllIII) {
        this._funcToCall = llllllllllIlllIIlIIlllIIIlIllIII;
    }
    
    public void setYaw(final double llllllllllIlllIIlIIlllIIIlIIIIII) {
        this._yaw = (float)llllllllllIlllIIlIIlllIIIlIIIIII;
    }
}
