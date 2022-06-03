// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.combat.LPositionHelper;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.rockstar.api.event.Event;

public class EventPreMotionUpdate extends Event
{
    public /* synthetic */ double x;
    public /* synthetic */ double z;
    private /* synthetic */ boolean cancel;
    private /* synthetic */ CPacketPlayer.Rotation rotation;
    public /* synthetic */ boolean ground;
    public /* synthetic */ double y;
    public /* synthetic */ float pitch;
    public /* synthetic */ float yaw;
    private /* synthetic */ LPositionHelper location;
    
    public boolean isCancel() {
        return this.cancel;
    }
    
    public void setGround(final boolean lllllllllllIlllIIlIlIIIllllIIlll) {
        this.ground = lllllllllllIlllIIlIlIIIllllIIlll;
    }
    
    public boolean onGround() {
        return this.ground;
    }
    
    public EventPlayerMotionUpdate getLocation() {
        return null;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public EventPreMotionUpdate(final float lllllllllllIlllIIlIlIIlIIIlIIllI, final float lllllllllllIlllIIlIlIIlIIIlIIlIl, final double lllllllllllIlllIIlIlIIlIIIIlllll, final LPositionHelper lllllllllllIlllIIlIlIIlIIIlIIIll) {
        this.yaw = lllllllllllIlllIIlIlIIlIIIlIIllI;
        this.pitch = lllllllllllIlllIIlIlIIlIIIlIIlIl;
        this.y = lllllllllllIlllIIlIlIIlIIIIlllll;
        this.z = this.z;
        this.x = this.x;
        this.location = lllllllllllIlllIIlIlIIlIIIlIIIll;
    }
    
    public void setY(final double lllllllllllIlllIIlIlIIIlllllIIIl) {
        this.y = lllllllllllIlllIIlIlIIIlllllIIIl;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setPitch(final float lllllllllllIlllIIlIlIIlIIIIIIIlI) {
        Minecraft.getMinecraft().player.rotationPitchHead = lllllllllllIlllIIlIlIIlIIIIIIIlI;
        this.pitch = lllllllllllIlllIIlIlIIlIIIIIIIlI;
    }
    
    public CPacketPlayer.Rotation getRotation() {
        return this.rotation;
    }
    
    public void setCancel(final boolean lllllllllllIlllIIlIlIIlIIIIlIlll) {
        this.cancel = lllllllllllIlllIIlIlIIlIIIIlIlll;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setYaw(final float lllllllllllIlllIIlIlIIlIIIIIlIIl) {
        Minecraft.getMinecraft().player.renderYawOffset = lllllllllllIlllIIlIlIIlIIIIIlIIl;
        Minecraft.getMinecraft().player.rotationYawHead = lllllllllllIlllIIlIlIIlIIIIIlIIl;
        this.yaw = lllllllllllIlllIIlIlIIlIIIIIlIIl;
    }
}
