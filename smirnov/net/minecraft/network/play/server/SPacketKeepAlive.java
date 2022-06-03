// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketKeepAlive implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ long id;
    
    public SPacketKeepAlive(final long llllllllllllllIIllllIllllIIIllll) {
        this.id = llllllllllllllIIllllIllllIIIllll;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIllllIllllIIIIIIl) throws IOException {
        this.id = llllllllllllllIIllllIllllIIIIIIl.readLong();
    }
    
    public long getId() {
        return this.id;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIllllIlllIllllIll) throws IOException {
        llllllllllllllIIllllIlllIllllIll.writeLong(this.id);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIllllIllllIIIIlll) {
        llllllllllllllIIllllIllllIIIIlll.handleKeepAlive(this);
    }
    
    public SPacketKeepAlive() {
    }
}
