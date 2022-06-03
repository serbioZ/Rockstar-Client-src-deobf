// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import java.io.IOException;
import io.netty.util.AttributeKey;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.Logger;
import io.netty.handler.codec.MessageToByteEncoder;

public class NettyPacketEncoder extends MessageToByteEncoder<Packet<?>>
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ EnumPacketDirection direction;
    private static final /* synthetic */ Marker RECEIVED_PACKET_MARKER;
    
    static {
        LOGGER = LogManager.getLogger();
        RECEIVED_PACKET_MARKER = MarkerManager.getMarker("PACKET_SENT", NetworkManager.NETWORK_PACKETS_MARKER);
    }
    
    protected void encode(final ChannelHandlerContext llllllllllllIlIIIIIIIIllIllIlllI, final Packet<?> llllllllllllIlIIIIIIIIllIlllIlIl, final ByteBuf llllllllllllIlIIIIIIIIllIlllIlII) throws Exception, IOException {
        final EnumConnectionState llllllllllllIlIIIIIIIIllIlllIIll = (EnumConnectionState)llllllllllllIlIIIIIIIIllIllIlllI.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get();
        if (llllllllllllIlIIIIIIIIllIlllIIll == null) {
            throw new RuntimeException("ConnectionProtocol unknown: " + llllllllllllIlIIIIIIIIllIlllIlIl.toString());
        }
        final Integer llllllllllllIlIIIIIIIIllIlllIIlI = llllllllllllIlIIIIIIIIllIlllIIll.getPacketId(this.direction, llllllllllllIlIIIIIIIIllIlllIlIl);
        if (NettyPacketEncoder.LOGGER.isDebugEnabled()) {
            NettyPacketEncoder.LOGGER.debug(NettyPacketEncoder.RECEIVED_PACKET_MARKER, "OUT: [{}:{}] {}", llllllllllllIlIIIIIIIIllIllIlllI.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get(), (Object)llllllllllllIlIIIIIIIIllIlllIIlI, (Object)llllllllllllIlIIIIIIIIllIlllIlIl.getClass().getName());
        }
        if (llllllllllllIlIIIIIIIIllIlllIIlI == null) {
            throw new IOException("Can't serialize unregistered packet");
        }
        final PacketBuffer llllllllllllIlIIIIIIIIllIlllIIIl = new PacketBuffer(llllllllllllIlIIIIIIIIllIlllIlII);
        llllllllllllIlIIIIIIIIllIlllIIIl.writeVarIntToBuffer(llllllllllllIlIIIIIIIIllIlllIIlI);
        try {
            llllllllllllIlIIIIIIIIllIlllIlIl.writePacketData(llllllllllllIlIIIIIIIIllIlllIIIl);
        }
        catch (Throwable llllllllllllIlIIIIIIIIllIlllIIII) {
            NettyPacketEncoder.LOGGER.error((Object)llllllllllllIlIIIIIIIIllIlllIIII);
        }
    }
    
    public NettyPacketEncoder(final EnumPacketDirection llllllllllllIlIIIIIIIIlllIIIIIII) {
        this.direction = llllllllllllIlIIIIIIIIlllIIIIIII;
    }
}
