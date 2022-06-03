// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketHeldItemChange implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ int slotId;
    
    public int getSlotId() {
        return this.slotId;
    }
    
    public CPacketHeldItemChange() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIIllllllIllIIIlIIlI) throws IOException {
        llllllllllllIIIllllllIllIIIlIIlI.writeShort(this.slotId);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIIIllllllIllIIIIllII) {
        llllllllllllIIIllllllIllIIIIllII.processHeldItemChange(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIIllllllIllIIIllIlI) throws IOException {
        this.slotId = llllllllllllIIIllllllIllIIIllIlI.readShort();
    }
    
    public CPacketHeldItemChange(final int llllllllllllIIIllllllIllIIlIIIII) {
        this.slotId = llllllllllllIIIllllllIllIIlIIIII;
    }
}
