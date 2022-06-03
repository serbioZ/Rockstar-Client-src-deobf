// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketCollectItem implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int field_191209_c;
    private /* synthetic */ int entityId;
    private /* synthetic */ int collectedItemEntityId;
    
    public int getEntityID() {
        return this.entityId;
    }
    
    public int getCollectedItemEntityID() {
        return this.collectedItemEntityId;
    }
    
    public SPacketCollectItem() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIllllIIllIIllIIIllIII) throws IOException {
        lllllllllllIllllIIllIIllIIIllIII.writeVarIntToBuffer(this.collectedItemEntityId);
        lllllllllllIllllIIllIIllIIIllIII.writeVarIntToBuffer(this.entityId);
        lllllllllllIllllIIllIIllIIIllIII.writeVarIntToBuffer(this.field_191209_c);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIllllIIllIIllIIlIIIII) throws IOException {
        this.collectedItemEntityId = lllllllllllIllllIIllIIllIIlIIIII.readVarIntFromBuffer();
        this.entityId = lllllllllllIllllIIllIIllIIlIIIII.readVarIntFromBuffer();
        this.field_191209_c = lllllllllllIllllIIllIIllIIlIIIII.readVarIntFromBuffer();
    }
    
    public SPacketCollectItem(final int lllllllllllIllllIIllIIllIIlIlIlI, final int lllllllllllIllllIIllIIllIIlIlIIl, final int lllllllllllIllllIIllIIllIIlIlIII) {
        this.collectedItemEntityId = lllllllllllIllllIIllIIllIIlIlIlI;
        this.entityId = lllllllllllIllllIIllIIllIIlIlIIl;
        this.field_191209_c = lllllllllllIllllIIllIIllIIlIlIII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIllllIIllIIllIIIlIlII) {
        lllllllllllIllllIIllIIllIIIlIlII.handleCollectItem(this);
    }
    
    public int func_191208_c() {
        return this.field_191209_c;
    }
}
