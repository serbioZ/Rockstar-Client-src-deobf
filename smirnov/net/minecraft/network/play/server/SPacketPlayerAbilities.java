// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketPlayerAbilities implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ boolean invulnerable;
    private /* synthetic */ boolean allowFlying;
    private /* synthetic */ float walkSpeed;
    private /* synthetic */ boolean flying;
    private /* synthetic */ boolean creativeMode;
    private /* synthetic */ float flySpeed;
    
    public void setFlySpeed(final float llllllllllllIllIlllIllIIIIIIlIII) {
        this.flySpeed = llllllllllllIllIlllIllIIIIIIlIII;
    }
    
    public float getFlySpeed() {
        return this.flySpeed;
    }
    
    public float getWalkSpeed() {
        return this.walkSpeed;
    }
    
    public boolean isAllowFlying() {
        return this.allowFlying;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIllIlllIllIIIlIIlIII) throws IOException {
        final byte llllllllllllIllIlllIllIIIlIIIlll = llllllllllllIllIlllIllIIIlIIlIII.readByte();
        this.setInvulnerable((llllllllllllIllIlllIllIIIlIIIlll & 0x1) > 0);
        this.setFlying((llllllllllllIllIlllIllIIIlIIIlll & 0x2) > 0);
        this.setAllowFlying((llllllllllllIllIlllIllIIIlIIIlll & 0x4) > 0);
        this.setCreativeMode((llllllllllllIllIlllIllIIIlIIIlll & 0x8) > 0);
        this.setFlySpeed(llllllllllllIllIlllIllIIIlIIlIII.readFloat());
        this.setWalkSpeed(llllllllllllIllIlllIllIIIlIIlIII.readFloat());
    }
    
    public void setInvulnerable(final boolean llllllllllllIllIlllIllIIIIlIllII) {
        this.invulnerable = llllllllllllIllIlllIllIIIIlIllII;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIllIlllIllIIIIllllll) throws IOException {
        byte llllllllllllIllIlllIllIIIIlllllI = 0;
        if (this.isInvulnerable()) {
            llllllllllllIllIlllIllIIIIlllllI |= 0x1;
        }
        if (this.isFlying()) {
            llllllllllllIllIlllIllIIIIlllllI |= 0x2;
        }
        if (this.isAllowFlying()) {
            llllllllllllIllIlllIllIIIIlllllI |= 0x4;
        }
        if (this.isCreativeMode()) {
            llllllllllllIllIlllIllIIIIlllllI |= 0x8;
        }
        llllllllllllIllIlllIllIIIIllllll.writeByte(llllllllllllIllIlllIllIIIIlllllI);
        llllllllllllIllIlllIllIIIIllllll.writeFloat(this.flySpeed);
        llllllllllllIllIlllIllIIIIllllll.writeFloat(this.walkSpeed);
    }
    
    public void setCreativeMode(final boolean llllllllllllIllIlllIllIIIIIlIIIl) {
        this.creativeMode = llllllllllllIllIlllIllIIIIIlIIIl;
    }
    
    public void setWalkSpeed(final float llllllllllllIllIlllIlIllllllllll) {
        this.walkSpeed = llllllllllllIllIlllIlIllllllllll;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIllIlllIllIIIIllIlll) {
        llllllllllllIllIlllIllIIIIllIlll.handlePlayerAbilities(this);
    }
    
    public boolean isInvulnerable() {
        return this.invulnerable;
    }
    
    public SPacketPlayerAbilities(final PlayerCapabilities llllllllllllIllIlllIllIIIlIIllIl) {
        this.setInvulnerable(llllllllllllIllIlllIllIIIlIIllIl.disableDamage);
        this.setFlying(llllllllllllIllIlllIllIIIlIIllIl.isFlying);
        this.setAllowFlying(llllllllllllIllIlllIllIIIlIIllIl.allowFlying);
        this.setCreativeMode(llllllllllllIllIlllIllIIIlIIllIl.isCreativeMode);
        this.setFlySpeed(llllllllllllIllIlllIllIIIlIIllIl.getFlySpeed());
        this.setWalkSpeed(llllllllllllIllIlllIllIIIlIIllIl.getWalkSpeed());
    }
    
    public void setAllowFlying(final boolean llllllllllllIllIlllIllIIIIIllIlI) {
        this.allowFlying = llllllllllllIllIlllIllIIIIIllIlI;
    }
    
    public boolean isFlying() {
        return this.flying;
    }
    
    public void setFlying(final boolean llllllllllllIllIlllIllIIIIlIIlIl) {
        this.flying = llllllllllllIllIlllIllIIIIlIIlIl;
    }
    
    public SPacketPlayerAbilities() {
    }
    
    public boolean isCreativeMode() {
        return this.creativeMode;
    }
}
