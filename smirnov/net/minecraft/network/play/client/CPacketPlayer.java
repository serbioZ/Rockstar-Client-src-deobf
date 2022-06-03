// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketPlayer implements Packet<INetHandlerPlayServer>
{
    protected /* synthetic */ boolean onGround;
    protected /* synthetic */ double y;
    protected /* synthetic */ float yaw;
    protected /* synthetic */ boolean rotating;
    protected /* synthetic */ float pitch;
    protected /* synthetic */ double x;
    protected /* synthetic */ boolean moving;
    protected /* synthetic */ double z;
    
    public double getX(final double llllllllllllIlIIlllllllIIIIIlIlI) {
        return this.moving ? this.x : llllllllllllIlIIlllllllIIIIIlIlI;
    }
    
    public boolean setOnGround(final boolean llllllllllllIlIIllllllIllllIlIIl) {
        this.onGround = llllllllllllIlIIllllllIllllIlIIl;
        return llllllllllllIlIIllllllIllllIlIIl;
    }
    
    public CPacketPlayer(final boolean llllllllllllIlIIlllllllIIIlIIlII) {
        this.onGround = llllllllllllIlIIlllllllIIIlIIlII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIlIIlllllllIIIIllllI) {
        llllllllllllIlIIlllllllIIIIllllI.processPlayer(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlIIlllllllIIIIllIII) throws IOException {
        this.onGround = (llllllllllllIlIIlllllllIIIIllIII.readUnsignedByte() != 0);
    }
    
    public double getZ(final double llllllllllllIlIIlllllllIIIIIIIII) {
        return this.moving ? this.z : llllllllllllIlIIlllllllIIIIIIIII;
    }
    
    public float getPitch(final float llllllllllllIlIIllllllIlllllIlII) {
        return this.rotating ? this.pitch : llllllllllllIlIIllllllIlllllIlII;
    }
    
    public boolean isOnGround() {
        return this.onGround;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlIIlllllllIIIIlIIII) throws IOException {
        llllllllllllIlIIlllllllIIIIlIIII.writeByte(this.onGround ? 1 : 0);
    }
    
    public float getYaw(final float llllllllllllIlIIllllllIllllllIlI) {
        return this.rotating ? this.yaw : llllllllllllIlIIllllllIllllllIlI;
    }
    
    public double getY(final double llllllllllllIlIIlllllllIIIIIIlII) {
        return this.moving ? this.y : llllllllllllIlIIlllllllIIIIIIlII;
    }
    
    public CPacketPlayer() {
    }
    
    public static class Position extends CPacketPlayer
    {
        public Position(final double llllllllllllllllIllIIlIIlIlIIlIl, final double llllllllllllllllIllIIlIIlIlIlIIl, final double llllllllllllllllIllIIlIIlIlIIIll, final boolean llllllllllllllllIllIIlIIlIlIIIlI) {
            this.x = llllllllllllllllIllIIlIIlIlIIlIl;
            this.y = llllllllllllllllIllIIlIIlIlIlIIl;
            this.z = llllllllllllllllIllIIlIIlIlIIIll;
            this.onGround = llllllllllllllllIllIIlIIlIlIIIlI;
            this.moving = true;
        }
        
        @Override
        public void readPacketData(final PacketBuffer llllllllllllllllIllIIlIIlIIllllI) throws IOException {
            this.x = llllllllllllllllIllIIlIIlIIllllI.readDouble();
            this.y = llllllllllllllllIllIIlIIlIIllllI.readDouble();
            this.z = llllllllllllllllIllIIlIIlIIllllI.readDouble();
            super.readPacketData(llllllllllllllllIllIIlIIlIIllllI);
        }
        
        public Position() {
            this.moving = true;
        }
        
        @Override
        public void writePacketData(final PacketBuffer llllllllllllllllIllIIlIIlIIllIII) throws IOException {
            llllllllllllllllIllIIlIIlIIllIII.writeDouble(this.x);
            llllllllllllllllIllIIlIIlIIllIII.writeDouble(this.y);
            llllllllllllllllIllIIlIIlIIllIII.writeDouble(this.z);
            super.writePacketData(llllllllllllllllIllIIlIIlIIllIII);
        }
    }
    
    public static class PositionRotation extends CPacketPlayer
    {
        public PositionRotation(final double llllllllllllIlllIIIlIIlllllllIII, final double llllllllllllIlllIIIlIIllllllIlll, final double llllllllllllIlllIIIlIIllllllIllI, final float llllllllllllIlllIIIlIIllllllIlIl, final float llllllllllllIlllIIIlIIlllllllIll, final boolean llllllllllllIlllIIIlIIlllllllIlI) {
            this.x = llllllllllllIlllIIIlIIlllllllIII;
            this.y = llllllllllllIlllIIIlIIllllllIlll;
            this.z = llllllllllllIlllIIIlIIllllllIllI;
            this.yaw = llllllllllllIlllIIIlIIllllllIlIl;
            this.pitch = llllllllllllIlllIIIlIIlllllllIll;
            this.onGround = llllllllllllIlllIIIlIIlllllllIlI;
            this.rotating = true;
            this.moving = true;
        }
        
        public PositionRotation() {
            this.moving = true;
            this.rotating = true;
        }
        
        @Override
        public void readPacketData(final PacketBuffer llllllllllllIlllIIIlIIlllllIllIl) throws IOException {
            this.x = llllllllllllIlllIIIlIIlllllIllIl.readDouble();
            this.y = llllllllllllIlllIIIlIIlllllIllIl.readDouble();
            this.z = llllllllllllIlllIIIlIIlllllIllIl.readDouble();
            this.yaw = llllllllllllIlllIIIlIIlllllIllIl.readFloat();
            this.pitch = llllllllllllIlllIIIlIIlllllIllIl.readFloat();
            super.readPacketData(llllllllllllIlllIIIlIIlllllIllIl);
        }
        
        @Override
        public void writePacketData(final PacketBuffer llllllllllllIlllIIIlIIlllllIlIIl) throws IOException {
            llllllllllllIlllIIIlIIlllllIlIIl.writeDouble(this.x);
            llllllllllllIlllIIIlIIlllllIlIIl.writeDouble(this.y);
            llllllllllllIlllIIIlIIlllllIlIIl.writeDouble(this.z);
            llllllllllllIlllIIIlIIlllllIlIIl.writeFloat(this.yaw);
            llllllllllllIlllIIIlIIlllllIlIIl.writeFloat(this.pitch);
            super.writePacketData(llllllllllllIlllIIIlIIlllllIlIIl);
        }
    }
    
    public static class Rotation extends CPacketPlayer
    {
        public Rotation() {
            this.rotating = true;
        }
        
        public Rotation(final float lllllllllllIlIIlllIlIIIlIIIlIlll, final float lllllllllllIlIIlllIlIIIlIIIlIIlI, final boolean lllllllllllIlIIlllIlIIIlIIIlIlIl) {
            this.yaw = lllllllllllIlIIlllIlIIIlIIIlIlll;
            this.pitch = lllllllllllIlIIlllIlIIIlIIIlIIlI;
            this.onGround = lllllllllllIlIIlllIlIIIlIIIlIlIl;
            this.rotating = true;
        }
        
        @Override
        public void writePacketData(final PacketBuffer lllllllllllIlIIlllIlIIIlIIIIIlll) throws IOException {
            lllllllllllIlIIlllIlIIIlIIIIIlll.writeFloat(this.yaw);
            lllllllllllIlIIlllIlIIIlIIIIIlll.writeFloat(this.pitch);
            super.writePacketData(lllllllllllIlIIlllIlIIIlIIIIIlll);
        }
        
        @Override
        public void readPacketData(final PacketBuffer lllllllllllIlIIlllIlIIIlIIIIlIll) throws IOException {
            this.yaw = lllllllllllIlIIlllIlIIIlIIIIlIll.readFloat();
            this.pitch = lllllllllllIlIIlllIlIIIlIIIIlIll.readFloat();
            super.readPacketData(lllllllllllIlIIlllIlIIIlIIIIlIll);
        }
    }
}
