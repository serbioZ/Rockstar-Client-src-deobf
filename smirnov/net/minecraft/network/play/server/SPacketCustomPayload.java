// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.INetHandler;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketCustomPayload implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String channel;
    private /* synthetic */ PacketBuffer data;
    
    public PacketBuffer getBufferData() {
        return this.data;
    }
    
    public String getChannelName() {
        return this.channel;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlIllIIIllIlIIlIIlIlI) {
        lllllllllllIlIllIIIllIlIIlIIlIlI.handleCustomPayload(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIllIIIllIlIIlIlIIII) throws IOException {
        lllllllllllIlIllIIIllIlIIlIlIIII.writeString(this.channel);
        lllllllllllIlIllIIIllIlIIlIlIIII.writeBytes(this.data);
    }
    
    public SPacketCustomPayload() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIllIIIllIlIIlIllIlI) throws IOException {
        this.channel = lllllllllllIlIllIIIllIlIIlIllIlI.readStringFromBuffer(20);
        final int lllllllllllIlIllIIIllIlIIlIllIIl = lllllllllllIlIllIIIllIlIIlIllIlI.readableBytes();
        if (lllllllllllIlIllIIIllIlIIlIllIIl >= 0 && lllllllllllIlIllIIIllIlIIlIllIIl <= 1048576) {
            this.data = new PacketBuffer(lllllllllllIlIllIIIllIlIIlIllIlI.readBytes(lllllllllllIlIllIIIllIlIIlIllIIl));
            return;
        }
        throw new IOException("Payload may not be larger than 1048576 bytes");
    }
    
    public SPacketCustomPayload(final String lllllllllllIlIllIIIllIlIIllIIIII, final PacketBuffer lllllllllllIlIllIIIllIlIIllIIIlI) {
        this.channel = lllllllllllIlIllIIIllIlIIllIIIII;
        this.data = lllllllllllIlIllIIIllIlIIllIIIlI;
        if (lllllllllllIlIllIIIllIlIIllIIIlI.writerIndex() > 1048576) {
            throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
        }
    }
}
