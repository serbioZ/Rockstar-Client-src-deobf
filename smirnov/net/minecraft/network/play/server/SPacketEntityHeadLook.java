// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntityHeadLook implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ byte yaw;
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIlllllIIlllIlIllllII) {
        llllllllllllIlllllIIlllIlIllllII.handleEntityHeadLook(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlllllIIlllIllIIIlII) throws IOException {
        llllllllllllIlllllIIlllIllIIIlII.writeVarIntToBuffer(this.entityId);
        llllllllllllIlllllIIlllIllIIIlII.writeByte(this.yaw);
    }
    
    public byte getYaw() {
        return this.yaw;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlllllIIlllIllIIlIlI) throws IOException {
        this.entityId = llllllllllllIlllllIIlllIllIIlIlI.readVarIntFromBuffer();
        this.yaw = llllllllllllIlllllIIlllIllIIlIlI.readByte();
    }
    
    public SPacketEntityHeadLook() {
    }
    
    public SPacketEntityHeadLook(final Entity llllllllllllIlllllIIlllIllIIllll, final byte llllllllllllIlllllIIlllIllIIlllI) {
        this.entityId = llllllllllllIlllllIIlllIllIIllll.getEntityId();
        this.yaw = llllllllllllIlllllIIlllIllIIlllI;
    }
    
    public Entity getEntity(final World llllllllllllIlllllIIlllIlIllIllI) {
        return llllllllllllIlllllIIlllIlIllIllI.getEntityByID(this.entityId);
    }
}
