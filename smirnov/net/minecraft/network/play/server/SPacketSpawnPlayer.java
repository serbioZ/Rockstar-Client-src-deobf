// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.entity.player.EntityPlayer;
import javax.annotation.Nullable;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import java.util.List;
import java.util.UUID;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSpawnPlayer implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ double x;
    private /* synthetic */ double z;
    private /* synthetic */ EntityDataManager watcher;
    private /* synthetic */ UUID uniqueId;
    private /* synthetic */ double y;
    private /* synthetic */ List<EntityDataManager.DataEntry<?>> dataManagerEntries;
    private /* synthetic */ byte yaw;
    private /* synthetic */ byte pitch;
    private /* synthetic */ int entityId;
    
    public double getZ() {
        return this.z;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIlIlllIIIlllIIlIIlI) throws IOException {
        llllllllllllIIlIlllIIIlllIIlIIlI.writeVarIntToBuffer(this.entityId);
        llllllllllllIIlIlllIIIlllIIlIIlI.writeUuid(this.uniqueId);
        llllllllllllIIlIlllIIIlllIIlIIlI.writeDouble(this.x);
        llllllllllllIIlIlllIIIlllIIlIIlI.writeDouble(this.y);
        llllllllllllIIlIlllIIIlllIIlIIlI.writeDouble(this.z);
        llllllllllllIIlIlllIIIlllIIlIIlI.writeByte(this.yaw);
        llllllllllllIIlIlllIIIlllIIlIIlI.writeByte(this.pitch);
        this.watcher.writeEntries(llllllllllllIIlIlllIIIlllIIlIIlI);
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIlIlllIIIlllIIIllII) {
        llllllllllllIIlIlllIIIlllIIIllII.handleSpawnPlayer(this);
    }
    
    public byte getYaw() {
        return this.yaw;
    }
    
    public byte getPitch() {
        return this.pitch;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIlIlllIIIlllIIllIII) throws IOException {
        this.entityId = llllllllllllIIlIlllIIIlllIIllIII.readVarIntFromBuffer();
        this.uniqueId = llllllllllllIIlIlllIIIlllIIllIII.readUuid();
        this.x = llllllllllllIIlIlllIIIlllIIllIII.readDouble();
        this.y = llllllllllllIIlIlllIIIlllIIllIII.readDouble();
        this.z = llllllllllllIIlIlllIIIlllIIllIII.readDouble();
        this.yaw = llllllllllllIIlIlllIIIlllIIllIII.readByte();
        this.pitch = llllllllllllIIlIlllIIIlllIIllIII.readByte();
        this.dataManagerEntries = EntityDataManager.readEntries(llllllllllllIIlIlllIIIlllIIllIII);
    }
    
    public double getX() {
        return this.x;
    }
    
    @Nullable
    public List<EntityDataManager.DataEntry<?>> getDataManagerEntries() {
        return this.dataManagerEntries;
    }
    
    public int getEntityID() {
        return this.entityId;
    }
    
    public SPacketSpawnPlayer() {
    }
    
    public SPacketSpawnPlayer(final EntityPlayer llllllllllllIIlIlllIIIlllIIllllI) {
        this.entityId = llllllllllllIIlIlllIIIlllIIllllI.getEntityId();
        this.uniqueId = llllllllllllIIlIlllIIIlllIIllllI.getGameProfile().getId();
        this.x = llllllllllllIIlIlllIIIlllIIllllI.posX;
        this.y = llllllllllllIIlIlllIIIlllIIllllI.posY;
        this.z = llllllllllllIIlIlllIIIlllIIllllI.posZ;
        this.yaw = (byte)(llllllllllllIIlIlllIIIlllIIllllI.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(llllllllllllIIlIlllIIIlllIIllllI.rotationPitch * 256.0f / 360.0f);
        this.watcher = llllllllllllIIlIlllIIIlllIIllllI.getDataManager();
    }
    
    public double getY() {
        return this.y;
    }
}
