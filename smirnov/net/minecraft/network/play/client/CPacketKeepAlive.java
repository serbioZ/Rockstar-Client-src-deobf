// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketKeepAlive implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ long key;
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllllllIIlIIllIlIlIIl) {
        llllllllllllllllllIIlIIllIlIlIIl.processKeepAlive(this);
    }
    
    public long getKey() {
        return this.key;
    }
    
    public CPacketKeepAlive(final long llllllllllllllllllIIlIIllIlIllIl) {
        this.key = llllllllllllllllllIIlIIllIlIllIl;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllllIIlIIllIlIIIll) throws IOException {
        this.key = llllllllllllllllllIIlIIllIlIIIll.readLong();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllllIIlIIllIIlllIl) throws IOException {
        llllllllllllllllllIIlIIllIIlllIl.writeLong(this.key);
    }
    
    public CPacketKeepAlive() {
    }
}
