// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketConfirmTeleport implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ int telportId;
    
    public CPacketConfirmTeleport(final int llllllllllllIlllIlIlIlIllIIlIIII) {
        this.telportId = llllllllllllIlllIlIlIlIllIIlIIII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIlllIlIlIlIlIllllllI) {
        llllllllllllIlllIlIlIlIlIllllllI.processConfirmTeleport(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlllIlIlIlIllIIIlIlI) throws IOException {
        this.telportId = llllllllllllIlllIlIlIlIllIIIlIlI.readVarIntFromBuffer();
    }
    
    public int getTeleportId() {
        return this.telportId;
    }
    
    public CPacketConfirmTeleport() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlllIlIlIlIllIIIIlII) throws IOException {
        llllllllllllIlllIlIlIlIllIIIIlII.writeVarIntToBuffer(this.telportId);
    }
}
