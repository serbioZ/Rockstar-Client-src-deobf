// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import net.minecraft.entity.Entity;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketVehicleMove implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ float yaw;
    private /* synthetic */ float pitch;
    private /* synthetic */ double z;
    private /* synthetic */ double x;
    private /* synthetic */ double y;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIllIIIlIlllIllllllII) throws IOException {
        lllllllllllIIllIIIlIlllIllllllII.writeDouble(this.x);
        lllllllllllIIllIIIlIlllIllllllII.writeDouble(this.y);
        lllllllllllIIllIIIlIlllIllllllII.writeDouble(this.z);
        lllllllllllIIllIIIlIlllIllllllII.writeFloat(this.yaw);
        lllllllllllIIllIIIlIlllIllllllII.writeFloat(this.pitch);
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getZ() {
        return this.z;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIllIIIlIllllIIIIIlII) throws IOException {
        this.x = lllllllllllIIllIIIlIllllIIIIIlII.readDouble();
        this.y = lllllllllllIIllIIIlIllllIIIIIlII.readDouble();
        this.z = lllllllllllIIllIIIlIllllIIIIIlII.readDouble();
        this.yaw = lllllllllllIIllIIIlIllllIIIIIlII.readFloat();
        this.pitch = lllllllllllIIllIIIlIllllIIIIIlII.readFloat();
    }
    
    public CPacketVehicleMove(final Entity lllllllllllIIllIIIlIllllIIIIlIII) {
        this.x = lllllllllllIIllIIIlIllllIIIIlIII.posX;
        this.y = lllllllllllIIllIIIlIllllIIIIlIII.posY;
        this.z = lllllllllllIIllIIIlIllllIIIIlIII.posZ;
        this.yaw = lllllllllllIIllIIIlIllllIIIIlIII.rotationYaw;
        this.pitch = lllllllllllIIllIIIlIllllIIIIlIII.rotationPitch;
    }
    
    public double getX() {
        return this.x;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllIIllIIIlIlllIllllIllI) {
        lllllllllllIIllIIIlIlllIllllIllI.processVehicleMove(this);
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public CPacketVehicleMove() {
    }
}
