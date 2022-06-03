// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSpawnGlobalEntity implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ double y;
    private /* synthetic */ int type;
    private /* synthetic */ double x;
    private /* synthetic */ double z;
    
    public double getY() {
        return this.y;
    }
    
    public int getType() {
        return this.type;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIllIIIllIIllIIIIIllI) throws IOException {
        this.entityId = lllllllllllIIllIIIllIIllIIIIIllI.readVarIntFromBuffer();
        this.type = lllllllllllIIllIIIllIIllIIIIIllI.readByte();
        this.x = lllllllllllIIllIIIllIIllIIIIIllI.readDouble();
        this.y = lllllllllllIIllIIIllIIllIIIIIllI.readDouble();
        this.z = lllllllllllIIllIIIllIIllIIIIIllI.readDouble();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIllIIIllIIlIllllllII) {
        lllllllllllIIllIIIllIIlIllllllII.handleSpawnGlobalEntity(this);
    }
    
    public SPacketSpawnGlobalEntity() {
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public SPacketSpawnGlobalEntity(final Entity lllllllllllIIllIIIllIIllIIIIllII) {
        this.entityId = lllllllllllIIllIIIllIIllIIIIllII.getEntityId();
        this.x = lllllllllllIIllIIIllIIllIIIIllII.posX;
        this.y = lllllllllllIIllIIIllIIllIIIIllII.posY;
        this.z = lllllllllllIIllIIIllIIllIIIIllII.posZ;
        if (lllllllllllIIllIIIllIIllIIIIllII instanceof EntityLightningBolt) {
            this.type = 1;
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIllIIIllIIllIIIIIIII) throws IOException {
        lllllllllllIIllIIIllIIllIIIIIIII.writeVarIntToBuffer(this.entityId);
        lllllllllllIIllIIIllIIllIIIIIIII.writeByte(this.type);
        lllllllllllIIllIIIllIIllIIIIIIII.writeDouble(this.x);
        lllllllllllIIllIIIllIIllIIIIIIII.writeDouble(this.y);
        lllllllllllIIllIIIllIIllIIIIIIII.writeDouble(this.z);
    }
    
    public int getEntityId() {
        return this.entityId;
    }
}
