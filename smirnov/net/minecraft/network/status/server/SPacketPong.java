// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.status.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.status.INetHandlerStatusClient;
import net.minecraft.network.Packet;

public class SPacketPong implements Packet<INetHandlerStatusClient>
{
    private /* synthetic */ long clientTime;
    
    @Override
    public void processPacket(final INetHandlerStatusClient lllIllIIllIllIl) {
        lllIllIIllIllIl.handlePong(this);
    }
    
    public SPacketPong(final long lllIllIIlllllll) {
        this.clientTime = lllIllIIlllllll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllIllIIlllIlIl) throws IOException {
        lllIllIIlllIlIl.writeLong(this.clientTime);
    }
    
    public SPacketPong() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllIllIIllllIIl) throws IOException {
        this.clientTime = lllIllIIllllIIl.readLong();
    }
}
