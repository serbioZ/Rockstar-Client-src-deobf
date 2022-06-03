// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.entity.Entity;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.EntityDataManager;
import java.util.List;
import java.util.UUID;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSpawnMob implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ byte yaw;
    private /* synthetic */ int velocityY;
    private /* synthetic */ UUID uniqueId;
    private /* synthetic */ int velocityZ;
    private /* synthetic */ int type;
    private /* synthetic */ int entityId;
    private /* synthetic */ int velocityX;
    private /* synthetic */ double z;
    private /* synthetic */ List<EntityDataManager.DataEntry<?>> dataManagerEntries;
    private /* synthetic */ byte headPitch;
    private /* synthetic */ byte pitch;
    private /* synthetic */ double y;
    private /* synthetic */ EntityDataManager dataManager;
    private /* synthetic */ double x;
    
    public double getY() {
        return this.y;
    }
    
    public int getEntityType() {
        return this.type;
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    public SPacketSpawnMob() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIllllIlllIIlIIlIllIII) throws IOException {
        lllllllllllIllllIlllIIlIIlIllIII.writeVarIntToBuffer(this.entityId);
        lllllllllllIllllIlllIIlIIlIllIII.writeUuid(this.uniqueId);
        lllllllllllIllllIlllIIlIIlIllIII.writeVarIntToBuffer(this.type);
        lllllllllllIllllIlllIIlIIlIllIII.writeDouble(this.x);
        lllllllllllIllllIlllIIlIIlIllIII.writeDouble(this.y);
        lllllllllllIllllIlllIIlIIlIllIII.writeDouble(this.z);
        lllllllllllIllllIlllIIlIIlIllIII.writeByte(this.yaw);
        lllllllllllIllllIlllIIlIIlIllIII.writeByte(this.pitch);
        lllllllllllIllllIlllIIlIIlIllIII.writeByte(this.headPitch);
        lllllllllllIllllIlllIIlIIlIllIII.writeShort(this.velocityX);
        lllllllllllIllllIlllIIlIIlIllIII.writeShort(this.velocityY);
        lllllllllllIllllIlllIIlIIlIllIII.writeShort(this.velocityZ);
        this.dataManager.writeEntries(lllllllllllIllllIlllIIlIIlIllIII);
    }
    
    public int getVelocityZ() {
        return this.velocityZ;
    }
    
    public int getVelocityY() {
        return this.velocityY;
    }
    
    public byte getYaw() {
        return this.yaw;
    }
    
    public SPacketSpawnMob(final EntityLivingBase lllllllllllIllllIlllIIlIIllIlllI) {
        this.entityId = lllllllllllIllllIlllIIlIIllIlllI.getEntityId();
        this.uniqueId = lllllllllllIllllIlllIIlIIllIlllI.getUniqueID();
        this.type = EntityList.field_191308_b.getIDForObject(lllllllllllIllllIlllIIlIIllIlllI.getClass());
        this.x = lllllllllllIllllIlllIIlIIllIlllI.posX;
        this.y = lllllllllllIllllIlllIIlIIllIlllI.posY;
        this.z = lllllllllllIllllIlllIIlIIllIlllI.posZ;
        this.yaw = (byte)(lllllllllllIllllIlllIIlIIllIlllI.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(lllllllllllIllllIlllIIlIIllIlllI.rotationPitch * 256.0f / 360.0f);
        this.headPitch = (byte)(lllllllllllIllllIlllIIlIIllIlllI.rotationYawHead * 256.0f / 360.0f);
        final double lllllllllllIllllIlllIIlIIllIllIl = 3.9;
        double lllllllllllIllllIlllIIlIIllIllII = lllllllllllIllllIlllIIlIIllIlllI.motionX;
        double lllllllllllIllllIlllIIlIIllIlIll = lllllllllllIllllIlllIIlIIllIlllI.motionY;
        double lllllllllllIllllIlllIIlIIllIlIlI = lllllllllllIllllIlllIIlIIllIlllI.motionZ;
        if (lllllllllllIllllIlllIIlIIllIllII < -3.9) {
            lllllllllllIllllIlllIIlIIllIllII = -3.9;
        }
        if (lllllllllllIllllIlllIIlIIllIlIll < -3.9) {
            lllllllllllIllllIlllIIlIIllIlIll = -3.9;
        }
        if (lllllllllllIllllIlllIIlIIllIlIlI < -3.9) {
            lllllllllllIllllIlllIIlIIllIlIlI = -3.9;
        }
        if (lllllllllllIllllIlllIIlIIllIllII > 3.9) {
            lllllllllllIllllIlllIIlIIllIllII = 3.9;
        }
        if (lllllllllllIllllIlllIIlIIllIlIll > 3.9) {
            lllllllllllIllllIlllIIlIIllIlIll = 3.9;
        }
        if (lllllllllllIllllIlllIIlIIllIlIlI > 3.9) {
            lllllllllllIllllIlllIIlIIllIlIlI = 3.9;
        }
        this.velocityX = (int)(lllllllllllIllllIlllIIlIIllIllII * 8000.0);
        this.velocityY = (int)(lllllllllllIllllIlllIIlIIllIlIll * 8000.0);
        this.velocityZ = (int)(lllllllllllIllllIlllIIlIIllIlIlI * 8000.0);
        this.dataManager = lllllllllllIllllIlllIIlIIllIlllI.getDataManager();
    }
    
    public int getVelocityX() {
        return this.velocityX;
    }
    
    public byte getPitch() {
        return this.pitch;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public byte getHeadPitch() {
        return this.headPitch;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIllllIlllIIlIIllIIIII) throws IOException {
        this.entityId = lllllllllllIllllIlllIIlIIllIIIII.readVarIntFromBuffer();
        this.uniqueId = lllllllllllIllllIlllIIlIIllIIIII.readUuid();
        this.type = lllllllllllIllllIlllIIlIIllIIIII.readVarIntFromBuffer();
        this.x = lllllllllllIllllIlllIIlIIllIIIII.readDouble();
        this.y = lllllllllllIllllIlllIIlIIllIIIII.readDouble();
        this.z = lllllllllllIllllIlllIIlIIllIIIII.readDouble();
        this.yaw = lllllllllllIllllIlllIIlIIllIIIII.readByte();
        this.pitch = lllllllllllIllllIlllIIlIIllIIIII.readByte();
        this.headPitch = lllllllllllIllllIlllIIlIIllIIIII.readByte();
        this.velocityX = lllllllllllIllllIlllIIlIIllIIIII.readShort();
        this.velocityY = lllllllllllIllllIlllIIlIIllIIIII.readShort();
        this.velocityZ = lllllllllllIllllIlllIIlIIllIIIII.readShort();
        this.dataManagerEntries = EntityDataManager.readEntries(lllllllllllIllllIlllIIlIIllIIIII);
    }
    
    public int getEntityID() {
        return this.entityId;
    }
    
    @Nullable
    public List<EntityDataManager.DataEntry<?>> getDataManagerEntries() {
        return this.dataManagerEntries;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIllllIlllIIlIIlIlIIlI) {
        lllllllllllIllllIlllIIlIIlIlIIlI.handleSpawnMob(this);
    }
}
