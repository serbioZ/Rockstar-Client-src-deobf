// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntityTeleport implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ byte pitch;
    private /* synthetic */ double posX;
    private /* synthetic */ boolean onGround;
    private /* synthetic */ int entityId;
    private /* synthetic */ byte yaw;
    private /* synthetic */ double posZ;
    private /* synthetic */ double posY;
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public SPacketEntityTeleport(final Entity lllllllllllllllIIlIIllIlllllllIl) {
        this.entityId = lllllllllllllllIIlIIllIlllllllIl.getEntityId();
        this.posX = lllllllllllllllIIlIIllIlllllllIl.posX;
        this.posY = lllllllllllllllIIlIIllIlllllllIl.posY;
        this.posZ = lllllllllllllllIIlIIllIlllllllIl.posZ;
        this.yaw = (byte)(lllllllllllllllIIlIIllIlllllllIl.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(lllllllllllllllIIlIIllIlllllllIl.rotationPitch * 256.0f / 360.0f);
        this.onGround = lllllllllllllllIIlIIllIlllllllIl.onGround;
    }
    
    public double getZ() {
        return this.posZ;
    }
    
    public double getY() {
        return this.posY;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIlIIllIllllIlIIl) {
        lllllllllllllllIIlIIllIllllIlIIl.handleEntityTeleport(this);
    }
    
    public boolean getOnGround() {
        return this.onGround;
    }
    
    public SPacketEntityTeleport() {
    }
    
    public byte getPitch() {
        return this.pitch;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlIIllIlllllIIIl) throws IOException {
        lllllllllllllllIIlIIllIlllllIIIl.writeVarIntToBuffer(this.entityId);
        lllllllllllllllIIlIIllIlllllIIIl.writeDouble(this.posX);
        lllllllllllllllIIlIIllIlllllIIIl.writeDouble(this.posY);
        lllllllllllllllIIlIIllIlllllIIIl.writeDouble(this.posZ);
        lllllllllllllllIIlIIllIlllllIIIl.writeByte(this.yaw);
        lllllllllllllllIIlIIllIlllllIIIl.writeByte(this.pitch);
        lllllllllllllllIIlIIllIlllllIIIl.writeBoolean(this.onGround);
    }
    
    public double getX() {
        return this.posX;
    }
    
    public byte getYaw() {
        return this.yaw;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlIIllIlllllIlll) throws IOException {
        this.entityId = lllllllllllllllIIlIIllIlllllIlll.readVarIntFromBuffer();
        this.posX = lllllllllllllllIIlIIllIlllllIlll.readDouble();
        this.posY = lllllllllllllllIIlIIllIlllllIlll.readDouble();
        this.posZ = lllllllllllllllIIlIIllIlllllIlll.readDouble();
        this.yaw = lllllllllllllllIIlIIllIlllllIlll.readByte();
        this.pitch = lllllllllllllllIIlIIllIlllllIlll.readByte();
        this.onGround = lllllllllllllllIIlIIllIlllllIlll.readBoolean();
    }
}
