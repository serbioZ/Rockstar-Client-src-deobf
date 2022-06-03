// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import net.minecraft.entity.player.PlayerCapabilities;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketPlayerAbilities implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ float flySpeed;
    private /* synthetic */ boolean invulnerable;
    private /* synthetic */ float walkSpeed;
    private /* synthetic */ boolean flying;
    private /* synthetic */ boolean creativeMode;
    private /* synthetic */ boolean allowFlying;
    
    public boolean isAllowFlying() {
        return this.allowFlying;
    }
    
    public void setInvulnerable(final boolean llllllllllllIllIlIIlIlllIIllIIIl) {
        this.invulnerable = llllllllllllIllIlIIlIlllIIllIIIl;
    }
    
    public boolean isInvulnerable() {
        return this.invulnerable;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIllIlIIlIlllIIlllIII) {
        llllllllllllIllIlIIlIlllIIlllIII.processPlayerAbilities(this);
    }
    
    public boolean isFlying() {
        return this.flying;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIllIlIIlIlllIlIIlIII) throws IOException {
        final byte llllllllllllIllIlIIlIlllIlIIlIlI = llllllllllllIllIlIIlIlllIlIIlIII.readByte();
        this.setInvulnerable((llllllllllllIllIlIIlIlllIlIIlIlI & 0x1) > 0);
        this.setFlying((llllllllllllIllIlIIlIlllIlIIlIlI & 0x2) > 0);
        this.setAllowFlying((llllllllllllIllIlIIlIlllIlIIlIlI & 0x4) > 0);
        this.setCreativeMode((llllllllllllIllIlIIlIlllIlIIlIlI & 0x8) > 0);
        this.setFlySpeed(llllllllllllIllIlIIlIlllIlIIlIII.readFloat());
        this.setWalkSpeed(llllllllllllIllIlIIlIlllIlIIlIII.readFloat());
    }
    
    public void setWalkSpeed(final float llllllllllllIllIlIIlIlllIIIIlIII) {
        this.walkSpeed = llllllllllllIllIlIIlIlllIIIIlIII;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIllIlIIlIlllIIllllll) throws IOException {
        byte llllllllllllIllIlIIlIlllIlIIIIIl = 0;
        if (this.isInvulnerable()) {
            llllllllllllIllIlIIlIlllIlIIIIIl |= 0x1;
        }
        if (this.isFlying()) {
            llllllllllllIllIlIIlIlllIlIIIIIl |= 0x2;
        }
        if (this.isAllowFlying()) {
            llllllllllllIllIlIIlIlllIlIIIIIl |= 0x4;
        }
        if (this.isCreativeMode()) {
            llllllllllllIllIlIIlIlllIlIIIIIl |= 0x8;
        }
        llllllllllllIllIlIIlIlllIIllllll.writeByte(llllllllllllIllIlIIlIlllIlIIIIIl);
        llllllllllllIllIlIIlIlllIIllllll.writeFloat(this.flySpeed);
        llllllllllllIllIlIIlIlllIIllllll.writeFloat(this.walkSpeed);
    }
    
    public void setFlySpeed(final float llllllllllllIllIlIIlIlllIIIIlllI) {
        this.flySpeed = llllllllllllIllIlIIlIlllIIIIlllI;
    }
    
    public void setCreativeMode(final boolean llllllllllllIllIlIIlIlllIIIlIllI) {
        this.creativeMode = llllllllllllIllIlIIlIlllIIIlIllI;
    }
    
    public boolean isCreativeMode() {
        return this.creativeMode;
    }
    
    public void setFlying(final boolean llllllllllllIllIlIIlIlllIIlIIllI) {
        this.flying = llllllllllllIllIlIIlIlllIIlIIllI;
    }
    
    public CPacketPlayerAbilities(final PlayerCapabilities llllllllllllIllIlIIlIlllIlIlIIII) {
        this.setInvulnerable(llllllllllllIllIlIIlIlllIlIlIIII.disableDamage);
        this.setFlying(llllllllllllIllIlIIlIlllIlIlIIII.isFlying);
        this.setAllowFlying(llllllllllllIllIlIIlIlllIlIlIIII.allowFlying);
        this.setCreativeMode(llllllllllllIllIlIIlIlllIlIlIIII.isCreativeMode);
        this.setFlySpeed(llllllllllllIllIlIIlIlllIlIlIIII.getFlySpeed());
        this.setWalkSpeed(llllllllllllIllIlIIlIlllIlIlIIII.getWalkSpeed());
    }
    
    public CPacketPlayerAbilities() {
    }
    
    public void setAllowFlying(final boolean llllllllllllIllIlIIlIlllIIIlllIl) {
        this.allowFlying = llllllllllllIllIlIIlIlllIIIlllIl;
    }
}
