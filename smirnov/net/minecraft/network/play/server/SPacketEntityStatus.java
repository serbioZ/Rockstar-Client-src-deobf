// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntityStatus implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ byte logicOpcode;
    private /* synthetic */ int entityId;
    
    public SPacketEntityStatus() {
    }
    
    public SPacketEntityStatus(final Entity llllllllllllIlIllllIIlIIlIllllIl, final byte llllllllllllIlIllllIIlIIlIllllll) {
        this.entityId = llllllllllllIlIllllIIlIIlIllllIl.getEntityId();
        this.logicOpcode = llllllllllllIlIllllIIlIIlIllllll;
    }
    
    public byte getOpCode() {
        return this.logicOpcode;
    }
    
    public Entity getEntity(final World llllllllllllIlIllllIIlIIlIlIIllI) {
        return llllllllllllIlIllllIIlIIlIlIIllI.getEntityByID(this.entityId);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlIllllIIlIIlIllIIlI) throws IOException {
        llllllllllllIlIllllIIlIIlIllIIlI.writeInt(this.entityId);
        llllllllllllIlIllllIIlIIlIllIIlI.writeByte(this.logicOpcode);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlIllllIIlIIlIllIllI) throws IOException {
        this.entityId = llllllllllllIlIllllIIlIIlIllIllI.readInt();
        this.logicOpcode = llllllllllllIlIllllIIlIIlIllIllI.readByte();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIlIllllIIlIIlIlIllII) {
        llllllllllllIlIllllIIlIIlIlIllII.handleEntityStatus(this);
    }
}
