// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketHeldItemChange implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int heldItemHotbarIndex;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIlIIIlIlIIllIIIIIII) throws IOException {
        this.heldItemHotbarIndex = lllllllllllIlIlIIIlIlIIllIIIIIII.readByte();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlIlIIIlIlIIlIlllIIlI) {
        lllllllllllIlIlIIIlIlIIlIlllIIlI.handleHeldItemChange(this);
    }
    
    public int getHeldItemHotbarIndex() {
        return this.heldItemHotbarIndex;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIlIIIlIlIIlIllllIlI) throws IOException {
        lllllllllllIlIlIIIlIlIIlIllllIlI.writeByte(this.heldItemHotbarIndex);
    }
    
    public SPacketHeldItemChange() {
    }
    
    public SPacketHeldItemChange(final int lllllllllllIlIlIIIlIlIIllIIIIllI) {
        this.heldItemHotbarIndex = lllllllllllIlIlIIIlIlIIllIIIIllI;
    }
}
