// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketMoveVehicle implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float yaw;
    private /* synthetic */ float pitch;
    private /* synthetic */ double z;
    private /* synthetic */ double x;
    private /* synthetic */ double y;
    
    public SPacketMoveVehicle(final Entity llllllllllIllllIlIIIlIlIIllllIlI) {
        this.x = llllllllllIllllIlIIIlIlIIllllIlI.posX;
        this.y = llllllllllIllllIlIIIlIlIIllllIlI.posY;
        this.z = llllllllllIllllIlIIIlIlIIllllIlI.posZ;
        this.yaw = llllllllllIllllIlIIIlIlIIllllIlI.rotationYaw;
        this.pitch = llllllllllIllllIlIIIlIlIIllllIlI.rotationPitch;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIllllIlIIIlIlIIlllIlII) throws IOException {
        this.x = llllllllllIllllIlIIIlIlIIlllIlII.readDouble();
        this.y = llllllllllIllllIlIIIlIlIIlllIlII.readDouble();
        this.z = llllllllllIllllIlIIIlIlIIlllIlII.readDouble();
        this.yaw = llllllllllIllllIlIIIlIlIIlllIlII.readFloat();
        this.pitch = llllllllllIllllIlIIIlIlIIlllIlII.readFloat();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIllllIlIIIlIlIIllIIllI) {
        llllllllllIllllIlIIIlIlIIllIIllI.handleMoveVehicle(this);
    }
    
    public double getZ() {
        return this.z;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIllllIlIIIlIlIIllIlllI) throws IOException {
        llllllllllIllllIlIIIlIlIIllIlllI.writeDouble(this.x);
        llllllllllIllllIlIIIlIlIIllIlllI.writeDouble(this.y);
        llllllllllIllllIlIIIlIlIIllIlllI.writeDouble(this.z);
        llllllllllIllllIlIIIlIlIIllIlllI.writeFloat(this.yaw);
        llllllllllIllllIlIIIlIlIIllIlllI.writeFloat(this.pitch);
    }
    
    public double getY() {
        return this.y;
    }
    
    public SPacketMoveVehicle() {
    }
    
    public double getX() {
        return this.x;
    }
}
