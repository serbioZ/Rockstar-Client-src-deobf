// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntity implements Packet<INetHandlerPlayClient>
{
    protected /* synthetic */ int entityId;
    protected /* synthetic */ int posY;
    protected /* synthetic */ int posZ;
    protected /* synthetic */ boolean onGround;
    protected /* synthetic */ byte pitch;
    protected /* synthetic */ byte yaw;
    protected /* synthetic */ boolean rotating;
    protected /* synthetic */ int posX;
    
    public int getX() {
        return this.posX;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIllIIlllIlIlIlllll) throws IOException {
        lllllllllllllIIllIIlllIlIlIlllll.writeVarIntToBuffer(this.entityId);
    }
    
    @Override
    public String toString() {
        return "Entity_" + super.toString();
    }
    
    public int getY() {
        return this.posY;
    }
    
    public SPacketEntity(final int lllllllllllllIIllIIlllIlIllIllIl) {
        this.entityId = lllllllllllllIIllIIlllIlIllIllIl;
    }
    
    public byte getPitch() {
        return this.pitch;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIllIIlllIlIllIIlIl) throws IOException {
        this.entityId = lllllllllllllIIllIIlllIlIllIIlIl.readVarIntFromBuffer();
    }
    
    public Entity getEntity(final World lllllllllllllIIllIIlllIlIlIlIIII) {
        return lllllllllllllIIllIIlllIlIlIlIIII.getEntityByID(this.entityId);
    }
    
    public boolean getOnGround() {
        return this.onGround;
    }
    
    public int getZ() {
        return this.posZ;
    }
    
    public boolean isRotating() {
        return this.rotating;
    }
    
    public SPacketEntity() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIllIIlllIlIlIllIll) {
        lllllllllllllIIllIIlllIlIlIllIll.handleEntityMovement(this);
    }
    
    public byte getYaw() {
        return this.yaw;
    }
    
    public static class S15PacketEntityRelMove extends SPacketEntity
    {
        public S15PacketEntityRelMove() {
        }
        
        @Override
        public void readPacketData(final PacketBuffer lllllllllllIIIIlllIllIlIIIllIlII) throws IOException {
            super.readPacketData(lllllllllllIIIIlllIllIlIIIllIlII);
            this.posX = lllllllllllIIIIlllIllIlIIIllIlII.readShort();
            this.posY = lllllllllllIIIIlllIllIlIIIllIlII.readShort();
            this.posZ = lllllllllllIIIIlllIllIlIIIllIlII.readShort();
            this.onGround = lllllllllllIIIIlllIllIlIIIllIlII.readBoolean();
        }
        
        public S15PacketEntityRelMove(final int lllllllllllIIIIlllIllIlIIlIIIIlI, final long lllllllllllIIIIlllIllIlIIIlllIll, final long lllllllllllIIIIlllIllIlIIIlllIlI, final long lllllllllllIIIIlllIllIlIIIllllll, final boolean lllllllllllIIIIlllIllIlIIIlllIII) {
            super(lllllllllllIIIIlllIllIlIIlIIIIlI);
            this.posX = (int)lllllllllllIIIIlllIllIlIIIlllIll;
            this.posY = (int)lllllllllllIIIIlllIllIlIIIlllIlI;
            this.posZ = (int)lllllllllllIIIIlllIllIlIIIllllll;
            this.onGround = lllllllllllIIIIlllIllIlIIIlllIII;
        }
        
        @Override
        public void writePacketData(final PacketBuffer lllllllllllIIIIlllIllIlIIIlIlllI) throws IOException {
            super.writePacketData(lllllllllllIIIIlllIllIlIIIlIlllI);
            lllllllllllIIIIlllIllIlIIIlIlllI.writeShort(this.posX);
            lllllllllllIIIIlllIllIlIIIlIlllI.writeShort(this.posY);
            lllllllllllIIIIlllIllIlIIIlIlllI.writeShort(this.posZ);
            lllllllllllIIIIlllIllIlIIIlIlllI.writeBoolean(this.onGround);
        }
    }
    
    public static class S17PacketEntityLookMove extends SPacketEntity
    {
        @Override
        public void readPacketData(final PacketBuffer llllllllllIlllIlIIIIllIIIIIllIlI) throws IOException {
            super.readPacketData(llllllllllIlllIlIIIIllIIIIIllIlI);
            this.posX = llllllllllIlllIlIIIIllIIIIIllIlI.readShort();
            this.posY = llllllllllIlllIlIIIIllIIIIIllIlI.readShort();
            this.posZ = llllllllllIlllIlIIIIllIIIIIllIlI.readShort();
            this.yaw = llllllllllIlllIlIIIIllIIIIIllIlI.readByte();
            this.pitch = llllllllllIlllIlIIIIllIIIIIllIlI.readByte();
            this.onGround = llllllllllIlllIlIIIIllIIIIIllIlI.readBoolean();
        }
        
        @Override
        public void writePacketData(final PacketBuffer llllllllllIlllIlIIIIllIIIIIlIlII) throws IOException {
            super.writePacketData(llllllllllIlllIlIIIIllIIIIIlIlII);
            llllllllllIlllIlIIIIllIIIIIlIlII.writeShort(this.posX);
            llllllllllIlllIlIIIIllIIIIIlIlII.writeShort(this.posY);
            llllllllllIlllIlIIIIllIIIIIlIlII.writeShort(this.posZ);
            llllllllllIlllIlIIIIllIIIIIlIlII.writeByte(this.yaw);
            llllllllllIlllIlIIIIllIIIIIlIlII.writeByte(this.pitch);
            llllllllllIlllIlIIIIllIIIIIlIlII.writeBoolean(this.onGround);
        }
        
        public S17PacketEntityLookMove(final int llllllllllIlllIlIIIIllIIIIlIllII, final long llllllllllIlllIlIIIIllIIIIlIlIll, final long llllllllllIlllIlIIIIllIIIIlIIIlI, final long llllllllllIlllIlIIIIllIIIIlIIIIl, final byte llllllllllIlllIlIIIIllIIIIlIlIII, final byte llllllllllIlllIlIIIIllIIIIIlllll, final boolean llllllllllIlllIlIIIIllIIIIlIIllI) {
            super(llllllllllIlllIlIIIIllIIIIlIllII);
            this.posX = (int)llllllllllIlllIlIIIIllIIIIlIlIll;
            this.posY = (int)llllllllllIlllIlIIIIllIIIIlIIIlI;
            this.posZ = (int)llllllllllIlllIlIIIIllIIIIlIIIIl;
            this.yaw = llllllllllIlllIlIIIIllIIIIlIlIII;
            this.pitch = llllllllllIlllIlIIIIllIIIIIlllll;
            this.onGround = llllllllllIlllIlIIIIllIIIIlIIllI;
            this.rotating = true;
        }
        
        public S17PacketEntityLookMove() {
            this.rotating = true;
        }
    }
    
    public static class S16PacketEntityLook extends SPacketEntity
    {
        public S16PacketEntityLook() {
            this.rotating = true;
        }
        
        @Override
        public void readPacketData(final PacketBuffer lllllllllllIIllIIlIIllllIllllllI) throws IOException {
            super.readPacketData(lllllllllllIIllIIlIIllllIllllllI);
            this.yaw = lllllllllllIIllIIlIIllllIllllllI.readByte();
            this.pitch = lllllllllllIIllIIlIIllllIllllllI.readByte();
            this.onGround = lllllllllllIIllIIlIIllllIllllllI.readBoolean();
        }
        
        public S16PacketEntityLook(final int lllllllllllIIllIIlIIlllllIIIIlIl, final byte lllllllllllIIllIIlIIlllllIIIIlII, final byte lllllllllllIIllIIlIIlllllIIIlIII, final boolean lllllllllllIIllIIlIIlllllIIIIlll) {
            super(lllllllllllIIllIIlIIlllllIIIIlIl);
            this.yaw = lllllllllllIIllIIlIIlllllIIIIlII;
            this.pitch = lllllllllllIIllIIlIIlllllIIIlIII;
            this.rotating = true;
            this.onGround = lllllllllllIIllIIlIIlllllIIIIlll;
        }
        
        @Override
        public void writePacketData(final PacketBuffer lllllllllllIIllIIlIIllllIlllIllI) throws IOException {
            super.writePacketData(lllllllllllIIllIIlIIllllIlllIllI);
            lllllllllllIIllIIlIIllllIlllIllI.writeByte(this.yaw);
            lllllllllllIIllIIlIIllllIlllIllI.writeByte(this.pitch);
            lllllllllllIIllIIlIIllllIlllIllI.writeBoolean(this.onGround);
        }
    }
}
