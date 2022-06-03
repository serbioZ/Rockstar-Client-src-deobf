// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.network;

import org.apache.logging.log4j.LogManager;
import java.util.Collections;
import com.google.common.collect.Lists;
import java.net.UnknownHostException;
import net.minecraft.network.status.client.CPacketServerQuery;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.network.status.server.SPacketPong;
import com.mojang.authlib.GameProfile;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.Packet;
import net.minecraft.network.status.client.CPacketPing;
import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.network.status.server.SPacketServerInfo;
import net.minecraft.network.status.INetHandlerStatusClient;
import net.minecraft.client.resources.I18n;
import java.net.InetAddress;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.channel.ChannelFutureListener;
import io.netty.buffer.Unpooled;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.Iterables;
import java.nio.charset.StandardCharsets;
import io.netty.channel.ChannelHandlerContext;
import io.netty.buffer.ByteBuf;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.bootstrap.Bootstrap;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;
import java.util.Iterator;
import net.minecraft.network.NetworkManager;
import java.util.List;
import com.google.common.base.Splitter;
import org.apache.logging.log4j.Logger;

public class ServerPinger
{
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ Splitter PING_RESPONSE_SPLITTER;
    private final /* synthetic */ List<NetworkManager> pingDestinations;
    
    public void pingPendingNetworks() {
        synchronized (this.pingDestinations) {
            final Iterator<NetworkManager> llllllllllIllllIIlIllIlIllIlllII = this.pingDestinations.iterator();
            while (llllllllllIllllIIlIllIlIllIlllII.hasNext()) {
                final NetworkManager llllllllllIllllIIlIllIlIllIllIll = llllllllllIllllIIlIllIlIllIlllII.next();
                if (llllllllllIllllIIlIllIlIllIllIll.isChannelOpen()) {
                    llllllllllIllllIIlIllIlIllIllIll.processReceivedPackets();
                }
                else {
                    llllllllllIllllIIlIllIlIllIlllII.remove();
                    llllllllllIllllIIlIllIlIllIllIll.checkDisconnected();
                }
            }
        }
        // monitorexit(this.pingDestinations)
    }
    
    private void tryCompatibilityPing(final ServerData llllllllllIllllIIlIllIlIlllIIllI) {
        final ServerAddress llllllllllIllllIIlIllIlIlllIIlIl = ServerAddress.fromString(llllllllllIllllIIlIllIlIlllIIllI.serverIP);
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)NetworkManager.CLIENT_NIO_EVENTLOOP.getValue())).handler((ChannelHandler)new ChannelInitializer<Channel>() {
            protected void initChannel(final Channel llIlIlllIIlIIIl) throws Exception {
                try {
                    llIlIlllIIlIIIl.config().setOption(ChannelOption.TCP_NODELAY, (Object)true);
                }
                catch (ChannelException ex) {}
                llIlIlllIIlIIIl.pipeline().addLast(new ChannelHandler[] { (ChannelHandler)new SimpleChannelInboundHandler<ByteBuf>() {
                        public void exceptionCaught(final ChannelHandlerContext llllllllllllIlIlllllIIlllIlIIIII, final Throwable llllllllllllIlIlllllIIlllIIlllll) throws Exception {
                            llllllllllllIlIlllllIIlllIlIIIII.close();
                        }
                        
                        protected void channelRead0(final ChannelHandlerContext llllllllllllIlIlllllIIlllIlIllII, final ByteBuf llllllllllllIlIlllllIIlllIlIlIll) throws Exception {
                            final short llllllllllllIlIlllllIIlllIllIlIl = llllllllllllIlIlllllIIlllIlIlIll.readUnsignedByte();
                            if (llllllllllllIlIlllllIIlllIllIlIl == 255) {
                                final String llllllllllllIlIlllllIIlllIllIlII = new String(llllllllllllIlIlllllIIlllIlIlIll.readBytes(llllllllllllIlIlllllIIlllIlIlIll.readShort() * 2).array(), StandardCharsets.UTF_16BE);
                                final String[] llllllllllllIlIlllllIIlllIllIIll = (String[])Iterables.toArray(ServerPinger.PING_RESPONSE_SPLITTER.split((CharSequence)llllllllllllIlIlllllIIlllIllIlII), (Class)String.class);
                                if ("§1".equals(llllllllllllIlIlllllIIlllIllIIll[0])) {
                                    final int llllllllllllIlIlllllIIlllIllIIlI = MathHelper.getInt(llllllllllllIlIlllllIIlllIllIIll[1], 0);
                                    final String llllllllllllIlIlllllIIlllIllIIIl = llllllllllllIlIlllllIIlllIllIIll[2];
                                    final String llllllllllllIlIlllllIIlllIllIIII = llllllllllllIlIlllllIIlllIllIIll[3];
                                    final int llllllllllllIlIlllllIIlllIlIllll = MathHelper.getInt(llllllllllllIlIlllllIIlllIllIIll[4], -1);
                                    final int llllllllllllIlIlllllIIlllIlIlllI = MathHelper.getInt(llllllllllllIlIlllllIIlllIllIIll[5], -1);
                                    llllllllllIllllIIlIllIlIlllIIllI.version = -1;
                                    llllllllllIllllIIlIllIlIlllIIllI.gameVersion = llllllllllllIlIlllllIIlllIllIIIl;
                                    llllllllllIllllIIlIllIlIlllIIllI.serverMOTD = llllllllllllIlIlllllIIlllIllIIII;
                                    llllllllllIllllIIlIllIlIlllIIllI.populationInfo = new StringBuilder().append(TextFormatting.GRAY).append(llllllllllllIlIlllllIIlllIlIllll).append(TextFormatting.DARK_GRAY).append("/").append(TextFormatting.GRAY).append(llllllllllllIlIlllllIIlllIlIlllI).toString();
                                }
                            }
                            llllllllllllIlIlllllIIlllIlIllII.close();
                        }
                        
                        public void channelActive(final ChannelHandlerContext llllllllllllIlIlllllIIllllIlIIIl) throws Exception {
                            super.channelActive(llllllllllllIlIlllllIIllllIlIIIl);
                            final ByteBuf llllllllllllIlIlllllIIllllIlIIII = Unpooled.buffer();
                            try {
                                llllllllllllIlIlllllIIllllIlIIII.writeByte(254);
                                llllllllllllIlIlllllIIllllIlIIII.writeByte(1);
                                llllllllllllIlIlllllIIllllIlIIII.writeByte(250);
                                char[] llllllllllllIlIlllllIIllllIIllll = "MC|PingHost".toCharArray();
                                llllllllllllIlIlllllIIllllIlIIII.writeShort(llllllllllllIlIlllllIIllllIIllll.length);
                                String llllllllllllIlIlllllIIllllIIIlIl;
                                long llllllllllllIlIlllllIIllllIIIllI = ((char[])(Object)(llllllllllllIlIlllllIIllllIIIlIl = (String)(Object)llllllllllllIlIlllllIIllllIIllll)).length;
                                for (char llllllllllllIlIlllllIIllllIIIlll = '\0'; llllllllllllIlIlllllIIllllIIIlll < llllllllllllIlIlllllIIllllIIIllI; ++llllllllllllIlIlllllIIllllIIIlll) {
                                    final char llllllllllllIlIlllllIIllllIIlllI = llllllllllllIlIlllllIIllllIIIlIl[llllllllllllIlIlllllIIllllIIIlll];
                                    llllllllllllIlIlllllIIllllIlIIII.writeChar((int)llllllllllllIlIlllllIIllllIIlllI);
                                }
                                llllllllllllIlIlllllIIllllIlIIII.writeShort(7 + 2 * llllllllllIllllIIlIllIlIlllIIlIl.getIP().length());
                                llllllllllllIlIlllllIIllllIlIIII.writeByte(127);
                                llllllllllllIlIlllllIIllllIIllll = llllllllllIllllIIlIllIlIlllIIlIl.getIP().toCharArray();
                                llllllllllllIlIlllllIIllllIlIIII.writeShort(llllllllllllIlIlllllIIllllIIllll.length);
                                llllllllllllIlIlllllIIllllIIIllI = ((char[])(Object)(llllllllllllIlIlllllIIllllIIIlIl = (String)(Object)llllllllllllIlIlllllIIllllIIllll)).length;
                                for (char llllllllllllIlIlllllIIllllIIIlll = '\0'; llllllllllllIlIlllllIIllllIIIlll < llllllllllllIlIlllllIIllllIIIllI; ++llllllllllllIlIlllllIIllllIIIlll) {
                                    final char llllllllllllIlIlllllIIllllIIllIl = llllllllllllIlIlllllIIllllIIIlIl[llllllllllllIlIlllllIIllllIIIlll];
                                    llllllllllllIlIlllllIIllllIlIIII.writeChar((int)llllllllllllIlIlllllIIllllIIllIl);
                                }
                                llllllllllllIlIlllllIIllllIlIIII.writeInt(llllllllllIllllIIlIllIlIlllIIlIl.getPort());
                                llllllllllllIlIlllllIIllllIlIIIl.channel().writeAndFlush((Object)llllllllllllIlIlllllIIllllIlIIII).addListener((GenericFutureListener)ChannelFutureListener.CLOSE_ON_FAILURE);
                            }
                            finally {
                                llllllllllllIlIlllllIIllllIlIIII.release();
                            }
                            llllllllllllIlIlllllIIllllIlIIII.release();
                        }
                    } });
            }
        })).channel((Class)NioSocketChannel.class)).connect(llllllllllIllllIIlIllIlIlllIIlIl.getIP(), llllllllllIllllIIlIllIlIlllIIlIl.getPort());
    }
    
    public void ping(final ServerData llllllllllIllllIIlIllIlIllllIIll) throws UnknownHostException {
        final ServerAddress llllllllllIllllIIlIllIlIllllIIlI = ServerAddress.fromString(llllllllllIllllIIlIllIlIllllIIll.serverIP);
        final NetworkManager llllllllllIllllIIlIllIlIllllIIIl = NetworkManager.createNetworkManagerAndConnect(InetAddress.getByName(llllllllllIllllIIlIllIlIllllIIlI.getIP()), llllllllllIllllIIlIllIlIllllIIlI.getPort(), false);
        this.pingDestinations.add(llllllllllIllllIIlIllIlIllllIIIl);
        llllllllllIllllIIlIllIlIllllIIll.serverMOTD = I18n.format("multiplayer.status.pinging", new Object[0]);
        llllllllllIllllIIlIllIlIllllIIll.pingToServer = -1L;
        llllllllllIllllIIlIllIlIllllIIll.playerList = null;
        llllllllllIllllIIlIllIlIllllIIIl.setNetHandler(new INetHandlerStatusClient() {
            private /* synthetic */ long pingSentAt;
            private /* synthetic */ boolean successful;
            private /* synthetic */ boolean receivedStatus;
            
            @Override
            public void handleServerInfo(final SPacketServerInfo llllllllllIlllIIllIIIIIIllIlIIII) {
                if (this.receivedStatus) {
                    llllllllllIllllIIlIllIlIllllIIIl.closeChannel(new TextComponentTranslation("multiplayer.status.unrequested", new Object[0]));
                }
                else {
                    this.receivedStatus = true;
                    final ServerStatusResponse llllllllllIlllIIllIIIIIIllIIllll = llllllllllIlllIIllIIIIIIllIlIIII.getResponse();
                    if (llllllllllIlllIIllIIIIIIllIIllll.getServerDescription() != null) {
                        llllllllllIllllIIlIllIlIllllIIll.serverMOTD = llllllllllIlllIIllIIIIIIllIIllll.getServerDescription().getFormattedText();
                    }
                    else {
                        llllllllllIllllIIlIllIlIllllIIll.serverMOTD = "";
                    }
                    if (llllllllllIlllIIllIIIIIIllIIllll.getVersion() != null) {
                        llllllllllIllllIIlIllIlIllllIIll.gameVersion = llllllllllIlllIIllIIIIIIllIIllll.getVersion().getName();
                        llllllllllIllllIIlIllIlIllllIIll.version = llllllllllIlllIIllIIIIIIllIIllll.getVersion().getProtocol();
                    }
                    else {
                        llllllllllIllllIIlIllIlIllllIIll.gameVersion = I18n.format("multiplayer.status.old", new Object[0]);
                        llllllllllIllllIIlIllIlIllllIIll.version = 0;
                    }
                    if (llllllllllIlllIIllIIIIIIllIIllll.getPlayers() != null) {
                        llllllllllIllllIIlIllIlIllllIIll.populationInfo = new StringBuilder().append(TextFormatting.GRAY).append(llllllllllIlllIIllIIIIIIllIIllll.getPlayers().getOnlinePlayerCount()).append(TextFormatting.DARK_GRAY).append("/").append(TextFormatting.GRAY).append(llllllllllIlllIIllIIIIIIllIIllll.getPlayers().getMaxPlayers()).toString();
                        if (ArrayUtils.isNotEmpty((Object[])llllllllllIlllIIllIIIIIIllIIllll.getPlayers().getPlayers())) {
                            final StringBuilder llllllllllIlllIIllIIIIIIllIIlllI = new StringBuilder();
                            final String llllllllllIlllIIllIIIIIIllIIIlII;
                            final short llllllllllIlllIIllIIIIIIllIIIlIl = (short)((GameProfile[])(Object)(llllllllllIlllIIllIIIIIIllIIIlII = (String)(Object)llllllllllIlllIIllIIIIIIllIIllll.getPlayers().getPlayers())).length;
                            for (String llllllllllIlllIIllIIIIIIllIIIllI = (String)0; llllllllllIlllIIllIIIIIIllIIIllI < llllllllllIlllIIllIIIIIIllIIIlIl; ++llllllllllIlllIIllIIIIIIllIIIllI) {
                                final GameProfile llllllllllIlllIIllIIIIIIllIIllIl = llllllllllIlllIIllIIIIIIllIIIlII[llllllllllIlllIIllIIIIIIllIIIllI];
                                if (llllllllllIlllIIllIIIIIIllIIlllI.length() > 0) {
                                    llllllllllIlllIIllIIIIIIllIIlllI.append("\n");
                                }
                                llllllllllIlllIIllIIIIIIllIIlllI.append(llllllllllIlllIIllIIIIIIllIIllIl.getName());
                            }
                            if (llllllllllIlllIIllIIIIIIllIIllll.getPlayers().getPlayers().length < llllllllllIlllIIllIIIIIIllIIllll.getPlayers().getOnlinePlayerCount()) {
                                if (llllllllllIlllIIllIIIIIIllIIlllI.length() > 0) {
                                    llllllllllIlllIIllIIIIIIllIIlllI.append("\n");
                                }
                                llllllllllIlllIIllIIIIIIllIIlllI.append(I18n.format("multiplayer.status.and_more", llllllllllIlllIIllIIIIIIllIIllll.getPlayers().getOnlinePlayerCount() - llllllllllIlllIIllIIIIIIllIIllll.getPlayers().getPlayers().length));
                            }
                            llllllllllIllllIIlIllIlIllllIIll.playerList = llllllllllIlllIIllIIIIIIllIIlllI.toString();
                        }
                    }
                    else {
                        llllllllllIllllIIlIllIlIllllIIll.populationInfo = TextFormatting.DARK_GRAY + I18n.format("multiplayer.status.unknown", new Object[0]);
                    }
                    if (llllllllllIlllIIllIIIIIIllIIllll.getFavicon() != null) {
                        final String llllllllllIlllIIllIIIIIIllIIllII = llllllllllIlllIIllIIIIIIllIIllll.getFavicon();
                        if (llllllllllIlllIIllIIIIIIllIIllII.startsWith("data:image/png;base64,")) {
                            llllllllllIllllIIlIllIlIllllIIll.setBase64EncodedIconData(llllllllllIlllIIllIIIIIIllIIllII.substring("data:image/png;base64,".length()));
                        }
                        else {
                            ServerPinger.LOGGER.error("Invalid server icon (unknown format)");
                        }
                    }
                    else {
                        llllllllllIllllIIlIllIlIllllIIll.setBase64EncodedIconData(null);
                    }
                    this.pingSentAt = Minecraft.getSystemTime();
                    llllllllllIllllIIlIllIlIllllIIIl.sendPacket(new CPacketPing(this.pingSentAt));
                    this.successful = true;
                }
            }
            
            @Override
            public void handlePong(final SPacketPong llllllllllIlllIIllIIIIIIlIllllll) {
                final long llllllllllIlllIIllIIIIIIlIlllllI = this.pingSentAt;
                final long llllllllllIlllIIllIIIIIIlIllllIl = Minecraft.getSystemTime();
                llllllllllIllllIIlIllIlIllllIIll.pingToServer = llllllllllIlllIIllIIIIIIlIllllIl - llllllllllIlllIIllIIIIIIlIlllllI;
                llllllllllIllllIIlIllIlIllllIIIl.closeChannel(new TextComponentString("Finished"));
            }
            
            @Override
            public void onDisconnect(final ITextComponent llllllllllIlllIIllIIIIIIlIllIlII) {
                if (!this.successful) {
                    ServerPinger.LOGGER.error("Can't ping {}: {}", (Object)llllllllllIllllIIlIllIlIllllIIll.serverIP, (Object)llllllllllIlllIIllIIIIIIlIllIlII.getUnformattedText());
                    llllllllllIllllIIlIllIlIllllIIll.serverMOTD = TextFormatting.DARK_RED + I18n.format("multiplayer.status.cannot_connect", new Object[0]);
                    llllllllllIllllIIlIllIlIllllIIll.populationInfo = "";
                    ServerPinger.this.tryCompatibilityPing(llllllllllIllllIIlIllIlIllllIIll);
                }
            }
        });
        try {
            llllllllllIllllIIlIllIlIllllIIIl.sendPacket(new C00Handshake(llllllllllIllllIIlIllIlIllllIIlI.getIP(), llllllllllIllllIIlIllIlIllllIIlI.getPort(), EnumConnectionState.STATUS));
            llllllllllIllllIIlIllIlIllllIIIl.sendPacket(new CPacketServerQuery());
        }
        catch (Throwable llllllllllIllllIIlIllIlIllllIIII) {
            ServerPinger.LOGGER.error((Object)llllllllllIllllIIlIllIlIllllIIII);
        }
    }
    
    public void clearPendingNetworks() {
        synchronized (this.pingDestinations) {
            final Iterator<NetworkManager> llllllllllIllllIIlIllIlIllIlIIIl = this.pingDestinations.iterator();
            while (llllllllllIllllIIlIllIlIllIlIIIl.hasNext()) {
                final NetworkManager llllllllllIllllIIlIllIlIllIlIIII = llllllllllIllllIIlIllIlIllIlIIIl.next();
                if (llllllllllIllllIIlIllIlIllIlIIII.isChannelOpen()) {
                    llllllllllIllllIIlIllIlIllIlIIIl.remove();
                    llllllllllIllllIIlIllIlIllIlIIII.closeChannel(new TextComponentTranslation("multiplayer.status.cancelled", new Object[0]));
                }
            }
        }
        // monitorexit(this.pingDestinations)
    }
    
    public ServerPinger() {
        this.pingDestinations = Collections.synchronizedList((List<NetworkManager>)Lists.newArrayList());
    }
    
    static {
        PING_RESPONSE_SPLITTER = Splitter.on('\0').limit(6);
        LOGGER = LogManager.getLogger();
    }
}
