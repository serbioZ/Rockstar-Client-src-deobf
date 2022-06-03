// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import com.google.common.collect.Queues;
import java.security.Key;
import net.minecraft.util.CryptManager;
import javax.crypto.SecretKey;
import io.netty.channel.local.LocalServerChannel;
import org.apache.commons.lang3.ArrayUtils;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.LogManager;
import io.netty.handler.timeout.TimeoutException;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.ChannelHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.epoll.Epoll;
import java.net.InetAddress;
import ru.rockstar.api.event.event.EventReceivePacket;
import io.netty.channel.ChannelHandlerContext;
import ru.rockstar.api.event.event.EventSendPacket;
import org.apache.commons.lang3.Validate;
import net.minecraft.util.text.TextComponentTranslation;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import javax.annotation.Nullable;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.util.ITickable;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import io.netty.util.AttributeKey;
import net.minecraft.util.text.ITextComponent;
import io.netty.channel.Channel;
import io.netty.channel.local.LocalEventLoopGroup;
import org.apache.logging.log4j.Logger;
import java.net.SocketAddress;
import org.apache.logging.log4j.Marker;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import net.minecraft.util.LazyLoadBase;
import java.util.Queue;
import io.netty.channel.SimpleChannelInboundHandler;

public class NetworkManager extends SimpleChannelInboundHandler<Packet<?>>
{
    private final /* synthetic */ Queue<InboundHandlerTuplePacketListener> outboundPacketsQueue;
    public static final /* synthetic */ LazyLoadBase<EpollEventLoopGroup> CLIENT_EPOLL_EVENTLOOP;
    public static final /* synthetic */ LazyLoadBase<NioEventLoopGroup> CLIENT_NIO_EVENTLOOP;
    private /* synthetic */ boolean disconnected;
    private /* synthetic */ SocketAddress socketAddress;
    public static final /* synthetic */ Marker NETWORK_MARKER;
    private static final /* synthetic */ Logger LOGGER;
    public static final /* synthetic */ LazyLoadBase<LocalEventLoopGroup> CLIENT_LOCAL_EVENTLOOP;
    private /* synthetic */ boolean isEncrypted;
    private final /* synthetic */ EnumPacketDirection direction;
    private /* synthetic */ Channel channel;
    private /* synthetic */ ITextComponent terminationReason;
    public static final /* synthetic */ AttributeKey<EnumConnectionState> PROTOCOL_ATTRIBUTE_KEY;
    private final /* synthetic */ ReentrantReadWriteLock readWriteLock;
    private /* synthetic */ INetHandler packetListener;
    
    public boolean isChannelOpen() {
        return this.channel != null && this.channel.isOpen();
    }
    
    public void processReceivedPackets() {
        this.flushOutboundQueue();
        if (this.packetListener instanceof ITickable) {
            ((ITickable)this.packetListener).update();
        }
        if (this.channel != null) {
            this.channel.flush();
        }
    }
    
    private void dispatchPacket(final Packet<?> llllllllllllIIllIlIIIIllIlIllIII, @Nullable final GenericFutureListener<? extends Future<? super Void>>[] llllllllllllIIllIlIIIIllIlIlIlll) {
        final EnumConnectionState llllllllllllIIllIlIIIIllIlIlllII = EnumConnectionState.getFromPacket(llllllllllllIIllIlIIIIllIlIllIII);
        final EnumConnectionState llllllllllllIIllIlIIIIllIlIllIll = (EnumConnectionState)this.channel.attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get();
        if (llllllllllllIIllIlIIIIllIlIllIll != llllllllllllIIllIlIIIIllIlIlllII) {
            NetworkManager.LOGGER.debug("Disabled auto read");
            this.channel.config().setAutoRead(false);
        }
        if (this.channel.eventLoop().inEventLoop()) {
            if (llllllllllllIIllIlIIIIllIlIlllII != llllllllllllIIllIlIIIIllIlIllIll) {
                this.setConnectionState(llllllllllllIIllIlIIIIllIlIlllII);
            }
            final ChannelFuture llllllllllllIIllIlIIIIllIlIllIlI = this.channel.writeAndFlush((Object)llllllllllllIIllIlIIIIllIlIllIII);
            if (llllllllllllIIllIlIIIIllIlIlIlll != null) {
                llllllllllllIIllIlIIIIllIlIllIlI.addListeners((GenericFutureListener[])llllllllllllIIllIlIIIIllIlIlIlll);
            }
            llllllllllllIIllIlIIIIllIlIllIlI.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        }
        else {
            this.channel.eventLoop().execute((Runnable)new Runnable() {
                @Override
                public void run() {
                    if (llllllllllllIIllIlIIIIllIlIlllII != llllllllllllIIllIlIIIIllIlIllIll) {
                        NetworkManager.this.setConnectionState(llllllllllllIIllIlIIIIllIlIlllII);
                    }
                    final ChannelFuture lllllllllllIlIIlIIllIIIllIIIlIll = NetworkManager.this.channel.writeAndFlush((Object)llllllllllllIIllIlIIIIllIlIllIII);
                    if (llllllllllllIIllIlIIIIllIlIlIlll != null) {
                        lllllllllllIlIIlIIllIIIllIIIlIll.addListeners(llllllllllllIIllIlIIIIllIlIlIlll);
                    }
                    lllllllllllIlIIlIIllIIIllIIIlIll.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
                }
            });
        }
    }
    
    public SocketAddress getRemoteAddress() {
        return this.socketAddress;
    }
    
    public ITextComponent getExitMessage() {
        return this.terminationReason;
    }
    
    public boolean isEncrypted() {
        return this.isEncrypted;
    }
    
    public void checkDisconnected() {
        if (this.channel != null && !this.channel.isOpen()) {
            if (this.disconnected) {
                NetworkManager.LOGGER.warn("handleDisconnection() called twice");
            }
            else {
                this.disconnected = true;
                if (this.getExitMessage() != null) {
                    this.getNetHandler().onDisconnect(this.getExitMessage());
                }
                else if (this.getNetHandler() != null) {
                    this.getNetHandler().onDisconnect(new TextComponentTranslation("multiplayer.disconnect.generic", new Object[0]));
                }
            }
        }
    }
    
    public void setNetHandler(final INetHandler llllllllllllIIllIlIIIIllIlllllIl) {
        Validate.notNull((Object)llllllllllllIIllIlIIIIllIlllllIl, "packetListener", new Object[0]);
        NetworkManager.LOGGER.debug("Set listener of {} to {}", (Object)this, (Object)llllllllllllIIllIlIIIIllIlllllIl);
        this.packetListener = llllllllllllIIllIlIIIIllIlllllIl;
    }
    
    public boolean hasNoChannel() {
        return this.channel == null;
    }
    
    public void sendPacket(final Packet<?> llllllllllllIIllIlIIIIllIlllIlIl) {
        if (this.isChannelOpen()) {
            final EventSendPacket llllllllllllIIllIlIIIIllIlllIlll = new EventSendPacket(llllllllllllIIllIlIIIIllIlllIlIl, true);
            llllllllllllIIllIlIIIIllIlllIlll.call();
            if (!llllllllllllIIllIlIIIIllIlllIlll.isCancelled()) {
                this.flushOutboundQueue();
                this.dispatchPacket(llllllllllllIIllIlIIIIllIlllIlll.getPacket(), null);
            }
        }
        else {
            this.readWriteLock.writeLock().lock();
            try {
                this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(llllllllllllIIllIlIIIIllIlllIlIl, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]));
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            this.readWriteLock.writeLock().unlock();
        }
    }
    
    public void channelActive(final ChannelHandlerContext llllllllllllIIllIlIIIIlllIlIlIII) throws Exception {
        super.channelActive(llllllllllllIIllIlIIIIlllIlIlIII);
        this.channel = llllllllllllIIllIlIIIIlllIlIlIII.channel();
        this.socketAddress = this.channel.remoteAddress();
        try {
            this.setConnectionState(EnumConnectionState.HANDSHAKING);
        }
        catch (Throwable llllllllllllIIllIlIIIIlllIlIIlll) {
            NetworkManager.LOGGER.fatal((Object)llllllllllllIIllIlIIIIlllIlIIlll);
        }
    }
    
    public void closeChannel(final ITextComponent llllllllllllIIllIlIIIIllIlIIIIII) {
        if (this.channel.isOpen()) {
            this.channel.close().awaitUninterruptibly();
            this.terminationReason = llllllllllllIIllIlIIIIllIlIIIIII;
        }
    }
    
    public INetHandler getNetHandler() {
        return this.packetListener;
    }
    
    protected void channelRead0(final ChannelHandlerContext llllllllllllIIllIlIIIIlllIIIlIIl, final Packet<?> llllllllllllIIllIlIIIIlllIIIIlIl) throws Exception {
        final EventReceivePacket llllllllllllIIllIlIIIIlllIIIIlll = new EventReceivePacket(llllllllllllIIllIlIIIIlllIIIIlIl);
        llllllllllllIIllIlIIIIlllIIIIlll.call();
        if (llllllllllllIIllIlIIIIlllIIIIlll.isCancelled()) {
            return;
        }
        if (this.channel.isOpen()) {
            try {
                llllllllllllIIllIlIIIIlllIIIIlIl.processPacket(this.packetListener);
            }
            catch (ThreadQuickExitException ex) {}
        }
    }
    
    public void setConnectionState(final EnumConnectionState llllllllllllIIllIlIIIIlllIIllllI) {
        this.channel.attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).set((Object)llllllllllllIIllIlIIIIlllIIllllI);
        this.channel.config().setAutoRead(true);
        NetworkManager.LOGGER.debug("Enabled auto read");
    }
    
    public static NetworkManager createNetworkManagerAndConnect(final InetAddress llllllllllllIIllIlIIIIllIIlIlllI, final int llllllllllllIIllIlIIIIllIIlIllIl, final boolean llllllllllllIIllIlIIIIllIIlIllII) {
        final NetworkManager llllllllllllIIllIlIIIIllIIllIIll = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
        Class<? extends SocketChannel> llllllllllllIIllIlIIIIllIIllIIIl = null;
        LazyLoadBase<? extends EventLoopGroup> llllllllllllIIllIlIIIIllIIlIllll = null;
        if (Epoll.isAvailable() && llllllllllllIIllIlIIIIllIIlIllII) {
            final Class<? extends SocketChannel> llllllllllllIIllIlIIIIllIIllIIlI = (Class<? extends SocketChannel>)EpollSocketChannel.class;
            final LazyLoadBase<? extends EventLoopGroup> llllllllllllIIllIlIIIIllIIllIIII = (LazyLoadBase<? extends EventLoopGroup>)NetworkManager.CLIENT_EPOLL_EVENTLOOP;
        }
        else {
            llllllllllllIIllIlIIIIllIIllIIIl = (Class<? extends SocketChannel>)NioSocketChannel.class;
            llllllllllllIIllIlIIIIllIIlIllll = (LazyLoadBase<? extends EventLoopGroup>)NetworkManager.CLIENT_NIO_EVENTLOOP;
        }
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)llllllllllllIIllIlIIIIllIIlIllll.getValue())).handler((ChannelHandler)new ChannelInitializer<Channel>() {
            protected void initChannel(final Channel llllllllllIlllllIIlIlIIIIIllllll) throws Exception {
                try {
                    llllllllllIlllllIIlIlIIIIIllllll.config().setOption(ChannelOption.TCP_NODELAY, (Object)true);
                }
                catch (ChannelException ex) {}
                llllllllllIlllllIIlIlIIIIIllllll.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(30)).addLast("splitter", (ChannelHandler)new NettyVarint21FrameDecoder()).addLast("decoder", (ChannelHandler)new NettyPacketDecoder(EnumPacketDirection.CLIENTBOUND)).addLast("prepender", (ChannelHandler)new NettyVarint21FrameEncoder()).addLast("encoder", (ChannelHandler)new NettyPacketEncoder(EnumPacketDirection.SERVERBOUND)).addLast("packet_handler", (ChannelHandler)llllllllllllIIllIlIIIIllIIllIIll);
            }
        })).channel((Class)llllllllllllIIllIlIIIIllIIllIIIl)).connect(llllllllllllIIllIlIIIIllIIlIlllI, llllllllllllIIllIlIIIIllIIlIllIl).syncUninterruptibly();
        return llllllllllllIIllIlIIIIllIIllIIll;
    }
    
    public static NetworkManager provideLocalClient(final SocketAddress llllllllllllIIllIlIIIIllIIlIIlII) {
        final NetworkManager llllllllllllIIllIlIIIIllIIlIIlIl = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)NetworkManager.CLIENT_LOCAL_EVENTLOOP.getValue())).handler((ChannelHandler)new ChannelInitializer<Channel>() {
            protected void initChannel(final Channel lllllllllllIllllllIIlIllIlIIlIll) throws Exception {
                lllllllllllIllllllIIlIllIlIIlIll.pipeline().addLast("packet_handler", (ChannelHandler)llllllllllllIIllIlIIIIllIIlIIlIl);
            }
        })).channel((Class)LocalChannel.class)).connect(llllllllllllIIllIlIIIIllIIlIIlII).syncUninterruptibly();
        return llllllllllllIIllIlIIIIllIIlIIlIl;
    }
    
    public void channelInactive(final ChannelHandlerContext llllllllllllIIllIlIIIIlllIIllIll) throws Exception {
        this.closeChannel(new TextComponentTranslation("disconnect.endOfStream", new Object[0]));
    }
    
    private void flushOutboundQueue() {
        if (this.channel != null && this.channel.isOpen()) {
            this.readWriteLock.readLock().lock();
            try {
                while (!this.outboundPacketsQueue.isEmpty()) {
                    final InboundHandlerTuplePacketListener llllllllllllIIllIlIIIIllIlIIllll = this.outboundPacketsQueue.poll();
                    this.dispatchPacket(llllllllllllIIllIlIIIIllIlIIllll.packet, llllllllllllIIllIlIIIIllIlIIllll.futureListeners);
                }
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
            this.readWriteLock.readLock().unlock();
        }
    }
    
    public void exceptionCaught(final ChannelHandlerContext llllllllllllIIllIlIIIIlllIIlIlIl, final Throwable llllllllllllIIllIlIIIIlllIIlIlII) throws Exception {
        TextComponentTranslation llllllllllllIIllIlIIIIlllIIlIIlI = null;
        if (llllllllllllIIllIlIIIIlllIIlIlII instanceof TimeoutException) {
            final TextComponentTranslation llllllllllllIIllIlIIIIlllIIlIIll = new TextComponentTranslation("disconnect.timeout", new Object[0]);
        }
        else {
            llllllllllllIIllIlIIIIlllIIlIIlI = new TextComponentTranslation("disconnect.genericReason", new Object[] { "Internal Exception: " + llllllllllllIIllIlIIIIlllIIlIlII });
        }
        NetworkManager.LOGGER.debug(llllllllllllIIllIlIIIIlllIIlIIlI.getUnformattedText(), llllllllllllIIllIlIIIIlllIIlIlII);
        this.closeChannel(llllllllllllIIllIlIIIIlllIIlIIlI);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        NETWORK_MARKER = MarkerManager.getMarker("NETWORK");
        NETWORK_PACKETS_MARKER = MarkerManager.getMarker("NETWORK_PACKETS", NetworkManager.NETWORK_MARKER);
        PROTOCOL_ATTRIBUTE_KEY = AttributeKey.valueOf("protocol");
        CLIENT_NIO_EVENTLOOP = new LazyLoadBase<NioEventLoopGroup>() {
            @Override
            protected NioEventLoopGroup load() {
                return new NioEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Client IO #%d").setDaemon(true).build());
            }
        };
        CLIENT_EPOLL_EVENTLOOP = new LazyLoadBase<EpollEventLoopGroup>() {
            @Override
            protected EpollEventLoopGroup load() {
                return new EpollEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Epoll Client IO #%d").setDaemon(true).build());
            }
        };
        CLIENT_LOCAL_EVENTLOOP = new LazyLoadBase<LocalEventLoopGroup>() {
            @Override
            protected LocalEventLoopGroup load() {
                return new LocalEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
            }
        };
    }
    
    public void setCompressionThreshold(final int llllllllllllIIllIlIIIIllIIIIIlll) {
        if (llllllllllllIIllIlIIIIllIIIIIlll >= 0) {
            if (this.channel.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                ((NettyCompressionDecoder)this.channel.pipeline().get("decompress")).setCompressionThreshold(llllllllllllIIllIlIIIIllIIIIIlll);
            }
            else {
                this.channel.pipeline().addBefore("decoder", "decompress", (ChannelHandler)new NettyCompressionDecoder(llllllllllllIIllIlIIIIllIIIIIlll));
            }
            if (this.channel.pipeline().get("compress") instanceof NettyCompressionEncoder) {
                ((NettyCompressionEncoder)this.channel.pipeline().get("compress")).setCompressionThreshold(llllllllllllIIllIlIIIIllIIIIIlll);
            }
            else {
                this.channel.pipeline().addBefore("encoder", "compress", (ChannelHandler)new NettyCompressionEncoder(llllllllllllIIllIlIIIIllIIIIIlll));
            }
        }
        else {
            if (this.channel.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                this.channel.pipeline().remove("decompress");
            }
            if (this.channel.pipeline().get("compress") instanceof NettyCompressionEncoder) {
                this.channel.pipeline().remove("compress");
            }
        }
    }
    
    @SafeVarargs
    public final void sendPacket(final Packet<?> llllllllllllIIllIlIIIIllIllIllIl, final GenericFutureListener<? extends Future<? super Void>> llllllllllllIIllIlIIIIllIllIlIII, final GenericFutureListener<? extends Future<? super Void>>... llllllllllllIIllIlIIIIllIllIIlll) {
        if (this.isChannelOpen()) {
            this.flushOutboundQueue();
            this.dispatchPacket(llllllllllllIIllIlIIIIllIllIllIl, (GenericFutureListener<? extends Future<? super Void>>[])ArrayUtils.add((Object[])llllllllllllIIllIlIIIIllIllIIlll, 0, (Object)llllllllllllIIllIlIIIIllIllIlIII));
        }
        else {
            this.readWriteLock.writeLock().lock();
            try {
                this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(llllllllllllIIllIlIIIIllIllIllIl, (GenericFutureListener<? extends Future<? super Void>>[])ArrayUtils.add((Object[])llllllllllllIIllIlIIIIllIllIIlll, 0, (Object)llllllllllllIIllIlIIIIllIllIlIII)));
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            this.readWriteLock.writeLock().unlock();
        }
    }
    
    public boolean isLocalChannel() {
        return this.channel instanceof LocalChannel || this.channel instanceof LocalServerChannel;
    }
    
    public void disableAutoRead() {
        this.channel.config().setAutoRead(false);
    }
    
    public void enableEncryption(final SecretKey llllllllllllIIllIlIIIIllIIIlllll) {
        this.isEncrypted = true;
        this.channel.pipeline().addBefore("splitter", "decrypt", (ChannelHandler)new NettyEncryptingDecoder(CryptManager.createNetCipherInstance(2, llllllllllllIIllIlIIIIllIIIlllll)));
        this.channel.pipeline().addBefore("prepender", "encrypt", (ChannelHandler)new NettyEncryptingEncoder(CryptManager.createNetCipherInstance(1, llllllllllllIIllIlIIIIllIIIlllll)));
    }
    
    public NetworkManager(final EnumPacketDirection llllllllllllIIllIlIIIIlllIlIllll) {
        this.outboundPacketsQueue = (Queue<InboundHandlerTuplePacketListener>)Queues.newConcurrentLinkedQueue();
        this.readWriteLock = new ReentrantReadWriteLock();
        this.direction = llllllllllllIIllIlIIIIlllIlIllll;
    }
    
    static class InboundHandlerTuplePacketListener
    {
        private final /* synthetic */ GenericFutureListener<? extends Future<? super Void>>[] futureListeners;
        private final /* synthetic */ Packet<?> packet;
        
        public InboundHandlerTuplePacketListener(final Packet<?> lllllllllllIlIllIIIllllllIllIIlI, final GenericFutureListener<? extends Future<? super Void>>... lllllllllllIlIllIIIllllllIlIlllI) {
            this.packet = lllllllllllIlIllIIIllllllIllIIlI;
            this.futureListeners = lllllllllllIlIllIIIllllllIlIlllI;
        }
    }
}
