// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketCustomPayload implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ PacketBuffer data;
    private /* synthetic */ String channel;
    
    public CPacketCustomPayload(final String lllllllllllIlIIIlIllIllIlIlllIII, final PacketBuffer lllllllllllIlIIIlIllIllIlIllIlll) {
        this.channel = lllllllllllIlIIIlIllIllIlIlllIII;
        this.data = lllllllllllIlIIIlIllIllIlIllIlll;
        if (lllllllllllIlIIIlIllIllIlIllIlll.writerIndex() > 32767) {
            throw new IllegalArgumentException("Payload may not be larger than 32767 bytes");
        }
    }
    
    public PacketBuffer getBufferData() {
        return this.data;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIIIlIllIllIlIlIIlll) throws IOException {
        lllllllllllIlIIIlIllIllIlIlIIlll.writeString(this.channel);
        lllllllllllIlIIIlIllIllIlIlIIlll.writeBytes(this.data);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIIIlIllIllIlIlIllII) throws IOException {
        this.channel = lllllllllllIlIIIlIllIllIlIlIllII.readStringFromBuffer(20);
        final int lllllllllllIlIIIlIllIllIlIlIlllI = lllllllllllIlIIIlIllIllIlIlIllII.readableBytes();
        if (lllllllllllIlIIIlIllIllIlIlIlllI >= 0 && lllllllllllIlIIIlIllIllIlIlIlllI <= 32767) {
            this.data = new PacketBuffer(lllllllllllIlIIIlIllIllIlIlIllII.readBytes(lllllllllllIlIIIlIllIllIlIlIlllI));
            return;
        }
        throw new IOException("Payload may not be larger than 32767 bytes");
    }
    
    public String getChannelName() {
        return this.channel;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllIlIIIlIllIllIlIIlllll) {
        lllllllllllIlIIIlIllIllIlIIlllll.processCustomPayload(this);
        if (this.data != null) {
            this.data.release();
        }
    }
    
    public CPacketCustomPayload() {
    }
}
