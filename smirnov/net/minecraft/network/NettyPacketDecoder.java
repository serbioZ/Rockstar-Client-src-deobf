// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import java.io.IOException;
import io.netty.util.AttributeKey;
import java.util.List;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.Logger;
import io.netty.handler.codec.ByteToMessageDecoder;

public class NettyPacketDecoder extends ByteToMessageDecoder
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ EnumPacketDirection direction;
    private static final /* synthetic */ Marker RECEIVED_PACKET_MARKER;
    
    static {
        LOGGER = LogManager.getLogger();
        RECEIVED_PACKET_MARKER = MarkerManager.getMarker("PACKET_RECEIVED", NetworkManager.NETWORK_PACKETS_MARKER);
    }
    
    public NettyPacketDecoder(final EnumPacketDirection llllllllllllIlIlIllIIIIIIlIllIII) {
        this.direction = llllllllllllIlIlIllIIIIIIlIllIII;
    }
    
    protected void decode(final ChannelHandlerContext llllllllllllIlIlIllIIIIIIlIIllll, final ByteBuf llllllllllllIlIlIllIIIIIIlIIlllI, final List<Object> llllllllllllIlIlIllIIIIIIlIIIllI) throws Exception, IllegalAccessException, IOException, InstantiationException {
        if (llllllllllllIlIlIllIIIIIIlIIlllI.readableBytes() != 0) {
            final PacketBuffer llllllllllllIlIlIllIIIIIIlIIllII = new PacketBuffer(llllllllllllIlIlIllIIIIIIlIIlllI);
            final int llllllllllllIlIlIllIIIIIIlIIlIll = llllllllllllIlIlIllIIIIIIlIIllII.readVarIntFromBuffer();
            final Packet<?> llllllllllllIlIlIllIIIIIIlIIlIlI = ((EnumConnectionState)llllllllllllIlIlIllIIIIIIlIIllll.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get()).getPacket(this.direction, llllllllllllIlIlIllIIIIIIlIIlIll);
            if (llllllllllllIlIlIllIIIIIIlIIlIlI == null) {
                throw new IOException("Bad packet id " + llllllllllllIlIlIllIIIIIIlIIlIll);
            }
            llllllllllllIlIlIllIIIIIIlIIlIlI.readPacketData(llllllllllllIlIlIllIIIIIIlIIllII);
            if (llllllllllllIlIlIllIIIIIIlIIllII.readableBytes() > 0) {
                throw new IOException("Packet " + ((EnumConnectionState)llllllllllllIlIlIllIIIIIIlIIllll.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get()).getId() + "/" + llllllllllllIlIlIllIIIIIIlIIlIll + " (" + llllllllllllIlIlIllIIIIIIlIIlIlI.getClass().getSimpleName() + ") was larger than I expected, found " + llllllllllllIlIlIllIIIIIIlIIllII.readableBytes() + " bytes extra whilst reading packet " + llllllllllllIlIlIllIIIIIIlIIlIll);
            }
            llllllllllllIlIlIllIIIIIIlIIIllI.add(llllllllllllIlIlIllIIIIIIlIIlIlI);
            if (NettyPacketDecoder.LOGGER.isDebugEnabled()) {
                NettyPacketDecoder.LOGGER.debug(NettyPacketDecoder.RECEIVED_PACKET_MARKER, " IN: [{}:{}] {}", llllllllllllIlIlIllIIIIIIlIIllll.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get(), (Object)llllllllllllIlIlIllIIIIIIlIIlIll, (Object)llllllllllllIlIlIllIIIIIIlIIlIlI.getClass().getName());
            }
        }
    }
}
