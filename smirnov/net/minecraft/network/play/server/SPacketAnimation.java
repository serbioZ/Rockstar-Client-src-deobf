// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.entity.Entity;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketAnimation implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ int type;
    
    public int getAnimationType() {
        return this.type;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIllIIIIIIIlIlIIlIIll) throws IOException {
        this.entityId = lllllllllllIIllIIIIIIIlIlIIlIIll.readVarIntFromBuffer();
        this.type = lllllllllllIIllIIIIIIIlIlIIlIIll.readUnsignedByte();
    }
    
    public SPacketAnimation() {
    }
    
    public int getEntityID() {
        return this.entityId;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIllIIIIIIIlIlIIIlIll) throws IOException {
        lllllllllllIIllIIIIIIIlIlIIIlIll.writeVarIntToBuffer(this.entityId);
        lllllllllllIIllIIIIIIIlIlIIIlIll.writeByte(this.type);
    }
    
    public SPacketAnimation(final Entity lllllllllllIIllIIIIIIIlIlIIllIII, final int lllllllllllIIllIIIIIIIlIlIIllIlI) {
        this.entityId = lllllllllllIIllIIIIIIIlIlIIllIII.getEntityId();
        this.type = lllllllllllIIllIIIIIIIlIlIIllIlI;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIllIIIIIIIlIlIIIIlll) {
        lllllllllllIIllIIIIIIIlIlIIIIlll.handleAnimation(this);
    }
}
