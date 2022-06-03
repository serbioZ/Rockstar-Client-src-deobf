// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.status.client;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.status.INetHandlerStatusServer;
import net.minecraft.network.Packet;

public class CPacketPing implements Packet<INetHandlerStatusServer>
{
    private /* synthetic */ long clientTime;
    
    @Override
    public void processPacket(final INetHandlerStatusServer llllllllllllIllIlIIIIlIIllIlIlll) {
        llllllllllllIllIlIIIIlIIllIlIlll.processPing(this);
    }
    
    public CPacketPing() {
    }
    
    public CPacketPing(final long llllllllllllIllIlIIIIlIIlllIlIll) {
        this.clientTime = llllllllllllIllIlIIIIlIIlllIlIll;
    }
    
    public long getClientTime() {
        return this.clientTime;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIllIlIIIIlIIllIlllll) throws IOException {
        llllllllllllIllIlIIIIlIIllIlllll.writeLong(this.clientTime);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIllIlIIIIlIIlllIIlIl) throws IOException {
        this.clientTime = llllllllllllIllIlIIIIlIIlllIIlIl.readLong();
    }
}
