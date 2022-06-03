// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import net.minecraft.crash.CrashReportCategory;
import java.util.Iterator;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import java.net.SocketAddress;
import java.util.Collections;
import com.google.common.collect.Lists;
import java.io.IOException;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.EventLoopGroup;
import net.minecraft.server.network.NetHandlerHandshakeTCP;
import io.netty.channel.ChannelHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.epoll.Epoll;
import java.net.InetAddress;
import io.netty.channel.ChannelFuture;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import net.minecraft.server.MinecraftServer;
import java.util.List;
import org.apache.logging.log4j.Logger;
import io.netty.channel.local.LocalEventLoopGroup;
import net.minecraft.util.LazyLoadBase;

public class NetworkSystem
{
    public volatile /* synthetic */ boolean isAlive;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<NetworkManager> networkManagers;
    private final /* synthetic */ MinecraftServer mcServer;
    public static final /* synthetic */ LazyLoadBase<NioEventLoopGroup> SERVER_NIO_EVENTLOOP;
    public static final /* synthetic */ LazyLoadBase<EpollEventLoopGroup> SERVER_EPOLL_EVENTLOOP;
    private final /* synthetic */ List<ChannelFuture> endpoints;
    
    public void addLanEndpoint(final InetAddress lllllllllllllIllllllIIIIIIIlIlll, final int lllllllllllllIllllllIIIIIIIlIllI) throws IOException {
        synchronized (this.endpoints) {
            Class<? extends ServerSocketChannel> lllllllllllllIllllllIIIIIIIllIll = null;
            LazyLoadBase<? extends EventLoopGroup> lllllllllllllIllllllIIIIIIIllIIl = null;
            if (Epoll.isAvailable() && this.mcServer.shouldUseNativeTransport()) {
                final Class<? extends ServerSocketChannel> lllllllllllllIllllllIIIIIIIlllII = (Class<? extends ServerSocketChannel>)EpollServerSocketChannel.class;
                final LazyLoadBase<? extends EventLoopGroup> lllllllllllllIllllllIIIIIIIllIlI = (LazyLoadBase<? extends EventLoopGroup>)NetworkSystem.SERVER_EPOLL_EVENTLOOP;
                NetworkSystem.LOGGER.info("Using epoll channel type");
            }
            else {
                lllllllllllllIllllllIIIIIIIllIll = (Class<? extends ServerSocketChannel>)NioServerSocketChannel.class;
                lllllllllllllIllllllIIIIIIIllIIl = (LazyLoadBase<? extends EventLoopGroup>)NetworkSystem.SERVER_NIO_EVENTLOOP;
                NetworkSystem.LOGGER.info("Using default channel type");
            }
            this.endpoints.add(((ServerBootstrap)((ServerBootstrap)new ServerBootstrap().channel((Class)lllllllllllllIllllllIIIIIIIllIll)).childHandler((ChannelHandler)new ChannelInitializer<Channel>() {
                protected void initChannel(final Channel llllllllllIllllIllIllIIIIlllIIlI) throws Exception {
                    try {
                        llllllllllIllllIllIllIIIIlllIIlI.config().setOption(ChannelOption.TCP_NODELAY, (Object)true);
                    }
                    catch (ChannelException ex) {}
                    llllllllllIllllIllIllIIIIlllIIlI.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(30)).addLast("legacy_query", (ChannelHandler)new LegacyPingHandler(NetworkSystem.this)).addLast("splitter", (ChannelHandler)new NettyVarint21FrameDecoder()).addLast("decoder", (ChannelHandler)new NettyPacketDecoder(EnumPacketDirection.SERVERBOUND)).addLast("prepender", (ChannelHandler)new NettyVarint21FrameEncoder()).addLast("encoder", (ChannelHandler)new NettyPacketEncoder(EnumPacketDirection.CLIENTBOUND));
                    final NetworkManager llllllllllIllllIllIllIIIIlllIIIl = new NetworkManager(EnumPacketDirection.SERVERBOUND);
                    NetworkSystem.this.networkManagers.add(llllllllllIllllIllIllIIIIlllIIIl);
                    llllllllllIllllIllIllIIIIlllIIlI.pipeline().addLast("packet_handler", (ChannelHandler)llllllllllIllllIllIllIIIIlllIIIl);
                    llllllllllIllllIllIllIIIIlllIIIl.setNetHandler(new NetHandlerHandshakeTCP(NetworkSystem.this.mcServer, llllllllllIllllIllIllIIIIlllIIIl));
                }
            }).group((EventLoopGroup)lllllllllllllIllllllIIIIIIIllIIl.getValue()).localAddress(lllllllllllllIllllllIIIIIIIlIlll, lllllllllllllIllllllIIIIIIIlIllI)).bind().syncUninterruptibly());
        }
        // monitorexit(this.endpoints)
    }
    
    public NetworkSystem(final MinecraftServer lllllllllllllIllllllIIIIIIlIlIII) {
        this.endpoints = Collections.synchronizedList((List<ChannelFuture>)Lists.newArrayList());
        this.networkManagers = Collections.synchronizedList((List<NetworkManager>)Lists.newArrayList());
        this.mcServer = lllllllllllllIllllllIIIIIIlIlIII;
        this.isAlive = true;
    }
    
    public void terminateEndpoints() {
        this.isAlive = false;
        for (final ChannelFuture lllllllllllllIllllllIIIIIIIIIlII : this.endpoints) {
            try {
                lllllllllllllIllllllIIIIIIIIIlII.channel().close().sync();
            }
            catch (InterruptedException lllllllllllllIllllllIIIIIIIIIIll) {
                NetworkSystem.LOGGER.error("Interrupted whilst closing channel");
            }
        }
    }
    
    public SocketAddress addLocalEndpoint() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/network/NetworkSystem.endpoints:Ljava/util/List;
        //     4: dup            
        //     5: astore_2        /* lllllllllllllIllllllIIIIIIIIlIlI */
        //     6: monitorenter   
        //     7: new             Lio/netty/bootstrap/ServerBootstrap;
        //    10: dup            
        //    11: invokespecial   io/netty/bootstrap/ServerBootstrap.<init>:()V
        //    14: ldc             Lio/netty/channel/local/LocalServerChannel;.class
        //    16: invokevirtual   io/netty/bootstrap/ServerBootstrap.channel:(Ljava/lang/Class;)Lio/netty/bootstrap/AbstractBootstrap;
        //    19: checkcast       Lio/netty/bootstrap/ServerBootstrap;
        //    22: new             Lnet/minecraft/network/NetworkSystem$5;
        //    25: dup            
        //    26: aload_0         /* lllllllllllllIllllllIIIIIIIIllII */
        //    27: invokespecial   net/minecraft/network/NetworkSystem$5.<init>:(Lnet/minecraft/network/NetworkSystem;)V
        //    30: invokevirtual   io/netty/bootstrap/ServerBootstrap.childHandler:(Lio/netty/channel/ChannelHandler;)Lio/netty/bootstrap/ServerBootstrap;
        //    33: getstatic       net/minecraft/network/NetworkSystem.SERVER_NIO_EVENTLOOP:Lnet/minecraft/util/LazyLoadBase;
        //    36: invokevirtual   net/minecraft/util/LazyLoadBase.getValue:()Ljava/lang/Object;
        //    39: checkcast       Lio/netty/channel/EventLoopGroup;
        //    42: invokevirtual   io/netty/bootstrap/ServerBootstrap.group:(Lio/netty/channel/EventLoopGroup;)Lio/netty/bootstrap/ServerBootstrap;
        //    45: getstatic       io/netty/channel/local/LocalAddress.ANY:Lio/netty/channel/local/LocalAddress;
        //    48: invokevirtual   io/netty/bootstrap/ServerBootstrap.localAddress:(Ljava/net/SocketAddress;)Lio/netty/bootstrap/AbstractBootstrap;
        //    51: checkcast       Lio/netty/bootstrap/ServerBootstrap;
        //    54: invokevirtual   io/netty/bootstrap/ServerBootstrap.bind:()Lio/netty/channel/ChannelFuture;
        //    57: invokeinterface io/netty/channel/ChannelFuture.syncUninterruptibly:()Lio/netty/channel/ChannelFuture;
        //    62: astore_1        /* lllllllllllllIllllllIIIIIIIIlllI */
        //    63: aload_0         /* lllllllllllllIllllllIIIIIIIIllII */
        //    64: getfield        net/minecraft/network/NetworkSystem.endpoints:Ljava/util/List;
        //    67: aload_1         /* lllllllllllllIllllllIIIIIIIIlllI */
        //    68: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    73: pop            
        //    74: aload_2         /* lllllllllllllIllllllIIIIIIIIlIlI */
        //    75: monitorexit    
        //    76: goto            82
        //    79: aload_2         /* lllllllllllllIllllllIIIIIIIIlIlI */
        //    80: monitorexit    
        //    81: athrow         
        //    82: aload_1         /* lllllllllllllIllllllIIIIIIIIllIl */
        //    83: invokeinterface io/netty/channel/ChannelFuture.channel:()Lio/netty/channel/Channel;
        //    88: invokeinterface io/netty/channel/Channel.localAddress:()Ljava/net/SocketAddress;
        //    93: areturn        
        //    StackMapTable: 00 02 FF 00 4F 00 03 07 00 02 00 07 00 80 00 01 07 00 A1 FF 00 02 00 03 07 00 02 07 00 7B 07 00 80 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      76     79     82     Any
        //  79     81     79     82     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public MinecraftServer getServer() {
        return this.mcServer;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        SERVER_NIO_EVENTLOOP = new LazyLoadBase<NioEventLoopGroup>() {
            @Override
            protected NioEventLoopGroup load() {
                return new NioEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Server IO #%d").setDaemon(true).build());
            }
        };
        SERVER_EPOLL_EVENTLOOP = new LazyLoadBase<EpollEventLoopGroup>() {
            @Override
            protected EpollEventLoopGroup load() {
                return new EpollEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Epoll Server IO #%d").setDaemon(true).build());
            }
        };
        SERVER_LOCAL_EVENTLOOP = new LazyLoadBase<LocalEventLoopGroup>() {
            @Override
            protected LocalEventLoopGroup load() {
                return new LocalEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Local Server IO #%d").setDaemon(true).build());
            }
        };
    }
    
    public void networkTick() {
        synchronized (this.networkManagers) {
            final Iterator<NetworkManager> lllllllllllllIlllllIllllllllIllI = this.networkManagers.iterator();
            while (lllllllllllllIlllllIllllllllIllI.hasNext()) {
                final NetworkManager lllllllllllllIlllllIllllllllIlIl = lllllllllllllIlllllIllllllllIllI.next();
                if (!lllllllllllllIlllllIllllllllIlIl.hasNoChannel()) {
                    if (lllllllllllllIlllllIllllllllIlIl.isChannelOpen()) {
                        try {
                            lllllllllllllIlllllIllllllllIlIl.processReceivedPackets();
                        }
                        catch (Exception lllllllllllllIlllllIllllllllIlII) {
                            if (lllllllllllllIlllllIllllllllIlIl.isLocalChannel()) {
                                final CrashReport lllllllllllllIlllllIllllllllIIll = CrashReport.makeCrashReport(lllllllllllllIlllllIllllllllIlII, "Ticking memory connection");
                                final CrashReportCategory lllllllllllllIlllllIllllllllIIlI = lllllllllllllIlllllIllllllllIIll.makeCategory("Ticking connection");
                                lllllllllllllIlllllIllllllllIIlI.setDetail("Connection", new ICrashReportDetail<String>() {
                                    @Override
                                    public String call() throws Exception {
                                        return lllllllllllllIlllllIllllllllIlIl.toString();
                                    }
                                });
                                throw new ReportedException(lllllllllllllIlllllIllllllllIIll);
                            }
                            NetworkSystem.LOGGER.warn("Failed to handle packet for {}", (Object)lllllllllllllIlllllIllllllllIlIl.getRemoteAddress(), (Object)lllllllllllllIlllllIllllllllIlII);
                            final TextComponentString lllllllllllllIlllllIllllllllIIIl = new TextComponentString("Internal server error");
                            lllllllllllllIlllllIllllllllIlIl.sendPacket(new SPacketDisconnect(lllllllllllllIlllllIllllllllIIIl), (GenericFutureListener<? extends Future<? super Void>>)new GenericFutureListener<Future<? super Void>>() {
                                public void operationComplete(final Future<? super Void> lllllllllllIIllIllIIlIlIlIIlIIlI) throws Exception {
                                    lllllllllllllIlllllIllllllllIlIl.closeChannel(lllllllllllllIlllllIllllllllIIIl);
                                }
                            }, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]);
                            lllllllllllllIlllllIllllllllIlIl.disableAutoRead();
                        }
                    }
                    else {
                        lllllllllllllIlllllIllllllllIllI.remove();
                        lllllllllllllIlllllIllllllllIlIl.checkDisconnected();
                    }
                }
            }
        }
        // monitorexit(this.networkManagers)
    }
}
