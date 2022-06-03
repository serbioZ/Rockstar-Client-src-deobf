// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import net.minecraft.entity.item.EntityXPOrb;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSpawnExperienceOrb implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ double posY;
    private /* synthetic */ double posZ;
    private /* synthetic */ int entityID;
    private /* synthetic */ double posX;
    private /* synthetic */ int xpValue;
    
    public SPacketSpawnExperienceOrb() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIllIIIIIIIIIlIIIlIlI) throws IOException {
        this.entityID = lllllllllllIIllIIIIIIIIIlIIIlIlI.readVarIntFromBuffer();
        this.posX = lllllllllllIIllIIIIIIIIIlIIIlIlI.readDouble();
        this.posY = lllllllllllIIllIIIIIIIIIlIIIlIlI.readDouble();
        this.posZ = lllllllllllIIllIIIIIIIIIlIIIlIlI.readDouble();
        this.xpValue = lllllllllllIIllIIIIIIIIIlIIIlIlI.readShort();
    }
    
    public SPacketSpawnExperienceOrb(final EntityXPOrb lllllllllllIIllIIIIIIIIIlIIlIIlI) {
        this.entityID = lllllllllllIIllIIIIIIIIIlIIlIIlI.getEntityId();
        this.posX = lllllllllllIIllIIIIIIIIIlIIlIIlI.posX;
        this.posY = lllllllllllIIllIIIIIIIIIlIIlIIlI.posY;
        this.posZ = lllllllllllIIllIIIIIIIIIlIIlIIlI.posZ;
        this.xpValue = lllllllllllIIllIIIIIIIIIlIIlIIlI.getXpValue();
    }
    
    public double getY() {
        return this.posY;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIllIIIIIIIIIlIIIIllI) throws IOException {
        lllllllllllIIllIIIIIIIIIlIIIIllI.writeVarIntToBuffer(this.entityID);
        lllllllllllIIllIIIIIIIIIlIIIIllI.writeDouble(this.posX);
        lllllllllllIIllIIIIIIIIIlIIIIllI.writeDouble(this.posY);
        lllllllllllIIllIIIIIIIIIlIIIIllI.writeDouble(this.posZ);
        lllllllllllIIllIIIIIIIIIlIIIIllI.writeShort(this.xpValue);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIllIIIIIIIIIlIIIIIII) {
        lllllllllllIIllIIIIIIIIIlIIIIIII.handleSpawnExperienceOrb(this);
    }
    
    public int getEntityID() {
        return this.entityID;
    }
    
    public int getXPValue() {
        return this.xpValue;
    }
    
    public double getX() {
        return this.posX;
    }
    
    public double getZ() {
        return this.posZ;
    }
}
