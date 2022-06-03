// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import java.util.UUID;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSpawnObject implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int speedX;
    private /* synthetic */ int speedZ;
    private /* synthetic */ UUID uniqueId;
    private /* synthetic */ int entityId;
    private /* synthetic */ int data;
    private /* synthetic */ int pitch;
    private /* synthetic */ int yaw;
    private /* synthetic */ double y;
    private /* synthetic */ double x;
    private /* synthetic */ int speedY;
    private /* synthetic */ int type;
    private /* synthetic */ double z;
    
    public double getZ() {
        return this.z;
    }
    
    public int getSpeedX() {
        return this.speedX;
    }
    
    public int getData() {
        return this.data;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIIlIIlIIlIllIllllIlI) {
        lllllllllllIIIlIIlIIlIllIllllIlI.handleSpawnObject(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIlIIlIIlIlllIIIIllI) throws IOException {
        this.entityId = lllllllllllIIIlIIlIIlIlllIIIIllI.readVarIntFromBuffer();
        this.uniqueId = lllllllllllIIIlIIlIIlIlllIIIIllI.readUuid();
        this.type = lllllllllllIIIlIIlIIlIlllIIIIllI.readByte();
        this.x = lllllllllllIIIlIIlIIlIlllIIIIllI.readDouble();
        this.y = lllllllllllIIIlIIlIIlIlllIIIIllI.readDouble();
        this.z = lllllllllllIIIlIIlIIlIlllIIIIllI.readDouble();
        this.pitch = lllllllllllIIIlIIlIIlIlllIIIIllI.readByte();
        this.yaw = lllllllllllIIIlIIlIIlIlllIIIIllI.readByte();
        this.data = lllllllllllIIIlIIlIIlIlllIIIIllI.readInt();
        this.speedX = lllllllllllIIIlIIlIIlIlllIIIIllI.readShort();
        this.speedY = lllllllllllIIIlIIlIIlIlllIIIIllI.readShort();
        this.speedZ = lllllllllllIIIlIIlIIlIlllIIIIllI.readShort();
    }
    
    public double getX() {
        return this.x;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIlIIlIIlIllIllllllI) throws IOException {
        lllllllllllIIIlIIlIIlIllIllllllI.writeVarIntToBuffer(this.entityId);
        lllllllllllIIIlIIlIIlIllIllllllI.writeUuid(this.uniqueId);
        lllllllllllIIIlIIlIIlIllIllllllI.writeByte(this.type);
        lllllllllllIIIlIIlIIlIllIllllllI.writeDouble(this.x);
        lllllllllllIIIlIIlIIlIllIllllllI.writeDouble(this.y);
        lllllllllllIIIlIIlIIlIllIllllllI.writeDouble(this.z);
        lllllllllllIIIlIIlIIlIllIllllllI.writeByte(this.pitch);
        lllllllllllIIIlIIlIIlIllIllllllI.writeByte(this.yaw);
        lllllllllllIIIlIIlIIlIllIllllllI.writeInt(this.data);
        lllllllllllIIIlIIlIIlIllIllllllI.writeShort(this.speedX);
        lllllllllllIIIlIIlIIlIllIllllllI.writeShort(this.speedY);
        lllllllllllIIIlIIlIIlIllIllllllI.writeShort(this.speedZ);
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    public void setSpeedZ(final int lllllllllllIIIlIIlIIlIllIlIIIlII) {
        this.speedZ = lllllllllllIIIlIIlIIlIllIlIIIlII;
    }
    
    public void setSpeedX(final int lllllllllllIIIlIIlIIlIllIlIIlllI) {
        this.speedX = lllllllllllIIIlIIlIIlIllIlIIlllI;
    }
    
    public SPacketSpawnObject(final Entity lllllllllllIIIlIIlIIlIlllIlIlIIl, final int lllllllllllIIIlIIlIIlIlllIlIlIII) {
        this(lllllllllllIIIlIIlIIlIlllIlIlIIl, lllllllllllIIIlIIlIIlIlllIlIlIII, 0);
    }
    
    public int getSpeedY() {
        return this.speedY;
    }
    
    public double getY() {
        return this.y;
    }
    
    public SPacketSpawnObject() {
    }
    
    public int getPitch() {
        return this.pitch;
    }
    
    public int getType() {
        return this.type;
    }
    
    public void setData(final int lllllllllllIIIlIIlIIlIllIIllllII) {
        this.data = lllllllllllIIIlIIlIIlIllIIllllII;
    }
    
    public SPacketSpawnObject(final Entity lllllllllllIIIlIIlIIlIlllIIlllII, final int lllllllllllIIIlIIlIIlIlllIlIIIII, final int lllllllllllIIIlIIlIIlIlllIIllIlI) {
        this.entityId = lllllllllllIIIlIIlIIlIlllIIlllII.getEntityId();
        this.uniqueId = lllllllllllIIIlIIlIIlIlllIIlllII.getUniqueID();
        this.x = lllllllllllIIIlIIlIIlIlllIIlllII.posX;
        this.y = lllllllllllIIIlIIlIIlIlllIIlllII.posY;
        this.z = lllllllllllIIIlIIlIIlIlllIIlllII.posZ;
        this.pitch = MathHelper.floor(lllllllllllIIIlIIlIIlIlllIIlllII.rotationPitch * 256.0f / 360.0f);
        this.yaw = MathHelper.floor(lllllllllllIIIlIIlIIlIlllIIlllII.rotationYaw * 256.0f / 360.0f);
        this.type = lllllllllllIIIlIIlIIlIlllIlIIIII;
        this.data = lllllllllllIIIlIIlIIlIlllIIllIlI;
        final double lllllllllllIIIlIIlIIlIlllIIllllI = 3.9;
        this.speedX = (int)(MathHelper.clamp(lllllllllllIIIlIIlIIlIlllIIlllII.motionX, -3.9, 3.9) * 8000.0);
        this.speedY = (int)(MathHelper.clamp(lllllllllllIIIlIIlIIlIlllIIlllII.motionY, -3.9, 3.9) * 8000.0);
        this.speedZ = (int)(MathHelper.clamp(lllllllllllIIIlIIlIIlIlllIIlllII.motionZ, -3.9, 3.9) * 8000.0);
    }
    
    public int getSpeedZ() {
        return this.speedZ;
    }
    
    public int getYaw() {
        return this.yaw;
    }
    
    public int getEntityID() {
        return this.entityId;
    }
    
    public SPacketSpawnObject(final Entity lllllllllllIIIlIIlIIlIlllIIIllIl, final int lllllllllllIIIlIIlIIlIlllIIIllII, final int lllllllllllIIIlIIlIIlIlllIIIlIll, final BlockPos lllllllllllIIIlIIlIIlIlllIIIllll) {
        this(lllllllllllIIIlIIlIIlIlllIIIllIl, lllllllllllIIIlIIlIIlIlllIIIllII, lllllllllllIIIlIIlIIlIlllIIIlIll);
        this.x = lllllllllllIIIlIIlIIlIlllIIIllll.getX();
        this.y = lllllllllllIIIlIIlIIlIlllIIIllll.getY();
        this.z = lllllllllllIIIlIIlIIlIlllIIIllll.getZ();
    }
    
    public void setSpeedY(final int lllllllllllIIIlIIlIIlIllIlIIlIII) {
        this.speedY = lllllllllllIIIlIIlIIlIllIlIIlIII;
    }
}
