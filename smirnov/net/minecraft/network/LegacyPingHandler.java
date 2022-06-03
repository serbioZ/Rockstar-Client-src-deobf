// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import io.netty.buffer.Unpooled;
import org.apache.logging.log4j.LogManager;
import net.minecraft.server.MinecraftServer;
import java.nio.charset.StandardCharsets;
import java.net.InetSocketAddress;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.channel.ChannelFutureListener;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.Logger;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class LegacyPingHandler extends ChannelInboundHandlerAdapter
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ NetworkSystem networkSystem;
    
    private void writeAndFlush(final ChannelHandlerContext lllllllllllllllllIllIllIllIIIlll, final ByteBuf lllllllllllllllllIllIllIllIIIllI) {
        lllllllllllllllllIllIllIllIIIlll.pipeline().firstContext().writeAndFlush((Object)lllllllllllllllllIllIllIllIIIllI).addListener((GenericFutureListener)ChannelFutureListener.CLOSE);
    }
    
    public void channelRead(final ChannelHandlerContext lllllllllllllllllIllIllIlllIlIlI, final Object lllllllllllllllllIllIllIllIllIlI) throws Exception {
        final ByteBuf lllllllllllllllllIllIllIlllIlIII = (ByteBuf)lllllllllllllllllIllIllIllIllIlI;
        lllllllllllllllllIllIllIlllIlIII.markReaderIndex();
        boolean lllllllllllllllllIllIllIlllIIlll = true;
        try {
            if (lllllllllllllllllIllIllIlllIlIII.readUnsignedByte() == 254) {
                final InetSocketAddress lllllllllllllllllIllIllIlllIIllI = (InetSocketAddress)lllllllllllllllllIllIllIlllIlIlI.channel().remoteAddress();
                final MinecraftServer lllllllllllllllllIllIllIlllIIlIl = this.networkSystem.getServer();
                final int lllllllllllllllllIllIllIlllIIlII = lllllllllllllllllIllIllIlllIlIII.readableBytes();
                switch (lllllllllllllllllIllIllIlllIIlII) {
                    case 0: {
                        LegacyPingHandler.LOGGER.debug("Ping: (<1.3.x) from {}:{}", (Object)lllllllllllllllllIllIllIlllIIllI.getAddress(), (Object)lllllllllllllllllIllIllIlllIIllI.getPort());
                        final String lllllllllllllllllIllIllIlllIIIll = String.format("%s§%d§%d", lllllllllllllllllIllIllIlllIIlIl.getMOTD(), lllllllllllllllllIllIllIlllIIlIl.getCurrentPlayerCount(), lllllllllllllllllIllIllIlllIIlIl.getMaxPlayers());
                        this.writeAndFlush(lllllllllllllllllIllIllIlllIlIlI, this.getStringBuffer(lllllllllllllllllIllIllIlllIIIll));
                        break;
                    }
                    case 1: {
                        if (lllllllllllllllllIllIllIlllIlIII.readUnsignedByte() != 1) {
                            return;
                        }
                        LegacyPingHandler.LOGGER.debug("Ping: (1.4-1.5.x) from {}:{}", (Object)lllllllllllllllllIllIllIlllIIllI.getAddress(), (Object)lllllllllllllllllIllIllIlllIIllI.getPort());
                        final String lllllllllllllllllIllIllIlllIIIlI = String.format("§1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, lllllllllllllllllIllIllIlllIIlIl.getMinecraftVersion(), lllllllllllllllllIllIllIlllIIlIl.getMOTD(), lllllllllllllllllIllIllIlllIIlIl.getCurrentPlayerCount(), lllllllllllllllllIllIllIlllIIlIl.getMaxPlayers());
                        this.writeAndFlush(lllllllllllllllllIllIllIlllIlIlI, this.getStringBuffer(lllllllllllllllllIllIllIlllIIIlI));
                        break;
                    }
                    default: {
                        boolean lllllllllllllllllIllIllIlllIIIIl = lllllllllllllllllIllIllIlllIlIII.readUnsignedByte() == 1;
                        lllllllllllllllllIllIllIlllIIIIl &= (lllllllllllllllllIllIllIlllIlIII.readUnsignedByte() == 250);
                        lllllllllllllllllIllIllIlllIIIIl &= "MC|PingHost".equals(new String(lllllllllllllllllIllIllIlllIlIII.readBytes(lllllllllllllllllIllIllIlllIlIII.readShort() * 2).array(), StandardCharsets.UTF_16BE));
                        final int lllllllllllllllllIllIllIlllIIIII = lllllllllllllllllIllIllIlllIlIII.readUnsignedShort();
                        lllllllllllllllllIllIllIlllIIIIl &= (lllllllllllllllllIllIllIlllIlIII.readUnsignedByte() >= 73);
                        lllllllllllllllllIllIllIlllIIIIl &= (3 + lllllllllllllllllIllIllIlllIlIII.readBytes(lllllllllllllllllIllIllIlllIlIII.readShort() * 2).array().length + 4 == lllllllllllllllllIllIllIlllIIIII);
                        lllllllllllllllllIllIllIlllIIIIl &= (lllllllllllllllllIllIllIlllIlIII.readInt() <= 65535);
                        lllllllllllllllllIllIllIlllIIIIl &= (lllllllllllllllllIllIllIlllIlIII.readableBytes() == 0);
                        if (!lllllllllllllllllIllIllIlllIIIIl) {
                            return;
                        }
                        LegacyPingHandler.LOGGER.debug("Ping: (1.6) from {}:{}", (Object)lllllllllllllllllIllIllIlllIIllI.getAddress(), (Object)lllllllllllllllllIllIllIlllIIllI.getPort());
                        final String lllllllllllllllllIllIllIllIlllll = String.format("§1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, lllllllllllllllllIllIllIlllIIlIl.getMinecraftVersion(), lllllllllllllllllIllIllIlllIIlIl.getMOTD(), lllllllllllllllllIllIllIlllIIlIl.getCurrentPlayerCount(), lllllllllllllllllIllIllIlllIIlIl.getMaxPlayers());
                        final ByteBuf lllllllllllllllllIllIllIllIllllI = this.getStringBuffer(lllllllllllllllllIllIllIllIlllll);
                        try {
                            this.writeAndFlush(lllllllllllllllllIllIllIlllIlIlI, lllllllllllllllllIllIllIllIllllI);
                        }
                        finally {
                            lllllllllllllllllIllIllIllIllllI.release();
                        }
                        lllllllllllllllllIllIllIllIllllI.release();
                        break;
                    }
                }
                lllllllllllllllllIllIllIlllIlIII.release();
                lllllllllllllllllIllIllIlllIIlll = false;
                return;
            }
        }
        catch (RuntimeException lllllllllllllllllIllIllIllIlllIl) {
            return;
        }
        finally {
            if (lllllllllllllllllIllIllIlllIIlll) {
                lllllllllllllllllIllIllIlllIlIII.resetReaderIndex();
                lllllllllllllllllIllIllIlllIlIlI.channel().pipeline().remove("legacy_query");
                lllllllllllllllllIllIllIlllIlIlI.fireChannelRead(lllllllllllllllllIllIllIllIllIlI);
            }
        }
        if (lllllllllllllllllIllIllIlllIIlll) {
            lllllllllllllllllIllIllIlllIlIII.resetReaderIndex();
            lllllllllllllllllIllIllIlllIlIlI.channel().pipeline().remove("legacy_query");
            lllllllllllllllllIllIllIlllIlIlI.fireChannelRead(lllllllllllllllllIllIllIllIllIlI);
        }
    }
    
    public LegacyPingHandler(final NetworkSystem lllllllllllllllllIllIllIlllllllI) {
        this.networkSystem = lllllllllllllllllIllIllIlllllllI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    private ByteBuf getStringBuffer(final String lllllllllllllllllIllIllIlIllllIl) {
        final ByteBuf lllllllllllllllllIllIllIlIllllII = Unpooled.buffer();
        lllllllllllllllllIllIllIlIllllII.writeByte(255);
        final char[] lllllllllllllllllIllIllIlIlllIll = lllllllllllllllllIllIllIlIllllIl.toCharArray();
        lllllllllllllllllIllIllIlIllllII.writeShort(lllllllllllllllllIllIllIlIlllIll.length);
        final double lllllllllllllllllIllIllIlIllIIll;
        final Exception lllllllllllllllllIllIllIlIllIlII = (Exception)((char[])(Object)(lllllllllllllllllIllIllIlIllIIll = (double)(Object)lllllllllllllllllIllIllIlIlllIll)).length;
        for (byte lllllllllllllllllIllIllIlIllIlIl = 0; lllllllllllllllllIllIllIlIllIlIl < lllllllllllllllllIllIllIlIllIlII; ++lllllllllllllllllIllIllIlIllIlIl) {
            final char lllllllllllllllllIllIllIlIlllIlI = lllllllllllllllllIllIllIlIllIIll[lllllllllllllllllIllIllIlIllIlIl];
            lllllllllllllllllIllIllIlIllllII.writeChar((int)lllllllllllllllllIllIllIlIlllIlI);
        }
        return lllllllllllllllllIllIllIlIllllII;
    }
}
