// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.network;

import net.minecraft.network.login.server.SPacketLoginSuccess;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Future;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import net.minecraft.network.login.server.SPacketEnableCompression;
import java.security.PrivateKey;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import net.minecraft.util.text.TextComponentTranslation;
import java.math.BigInteger;
import net.minecraft.util.CryptManager;
import javax.annotation.Nullable;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.util.Arrays;
import net.minecraft.network.login.client.CPacketEncryptionResponse;
import java.util.UUID;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import net.minecraft.network.login.server.SPacketDisconnect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.Packet;
import net.minecraft.network.login.server.SPacketEncryptionRequest;
import org.apache.commons.lang3.Validate;
import net.minecraft.network.login.client.CPacketLoginStart;
import com.mojang.authlib.GameProfile;
import javax.crypto.SecretKey;
import net.minecraft.network.NetworkManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;
import net.minecraft.server.MinecraftServer;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.login.INetHandlerLoginServer;
import net.minecraft.util.ITickable;

public class NetHandlerLoginServer implements ITickable, INetHandlerLoginServer
{
    private /* synthetic */ EntityPlayerMP player;
    private static final /* synthetic */ AtomicInteger AUTHENTICATOR_THREAD_ID;
    private /* synthetic */ int connectionTimer;
    private /* synthetic */ LoginState currentLoginState;
    private final /* synthetic */ MinecraftServer server;
    private static final /* synthetic */ Random RANDOM;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ byte[] verifyToken;
    public final /* synthetic */ NetworkManager networkManager;
    private /* synthetic */ SecretKey secretKey;
    private /* synthetic */ GameProfile loginGameProfile;
    
    @Override
    public void processLoginStart(final CPacketLoginStart lllllllllllIIIlllIIIllllIIIIIIlI) {
        Validate.validState(this.currentLoginState == LoginState.HELLO, "Unexpected hello packet", new Object[0]);
        this.loginGameProfile = lllllllllllIIIlllIIIllllIIIIIIlI.getProfile();
        if (this.server.isServerInOnlineMode() && !this.networkManager.isLocalChannel()) {
            this.currentLoginState = LoginState.KEY;
            this.networkManager.sendPacket(new SPacketEncryptionRequest("", this.server.getKeyPair().getPublic(), this.verifyToken));
        }
        else {
            this.currentLoginState = LoginState.READY_TO_ACCEPT;
        }
    }
    
    static /* synthetic */ void access$5(final NetHandlerLoginServer lllllllllllIIIlllIIIlllIlllIIIll, final LoginState lllllllllllIIIlllIIIlllIlllIIIlI) {
        lllllllllllIIIlllIIIlllIlllIIIll.currentLoginState = lllllllllllIIIlllIIIlllIlllIIIlI;
    }
    
    public void func_194026_b(final ITextComponent lllllllllllIIIlllIIIllllIIIllIIl) {
        try {
            NetHandlerLoginServer.LOGGER.info("Disconnecting {}: {}", (Object)this.getConnectionInfo(), (Object)lllllllllllIIIlllIIIllllIIIllIIl.getUnformattedText());
            this.networkManager.sendPacket(new SPacketDisconnect(lllllllllllIIIlllIIIllllIIIllIIl));
            this.networkManager.closeChannel(lllllllllllIIIlllIIIllllIIIllIIl);
        }
        catch (Exception lllllllllllIIIlllIIIllllIIIllIll) {
            NetHandlerLoginServer.LOGGER.error("Error whilst disconnecting player", (Throwable)lllllllllllIIIlllIIIllllIIIllIll);
        }
    }
    
    @Override
    public void onDisconnect(final ITextComponent lllllllllllIIIlllIIIllllIIIIlIIl) {
        NetHandlerLoginServer.LOGGER.info("{} lost connection: {}", (Object)this.getConnectionInfo(), (Object)lllllllllllIIIlllIIIllllIIIIlIIl.getUnformattedText());
    }
    
    static {
        AUTHENTICATOR_THREAD_ID = new AtomicInteger(0);
        LOGGER = LogManager.getLogger();
        RANDOM = new Random();
    }
    
    protected GameProfile getOfflineProfile(final GameProfile lllllllllllIIIlllIIIlllIllllIIll) {
        final UUID lllllllllllIIIlllIIIlllIllllIIlI = UUID.nameUUIDFromBytes(("OfflinePlayer:" + lllllllllllIIIlllIIIlllIllllIIll.getName()).getBytes(StandardCharsets.UTF_8));
        return new GameProfile(lllllllllllIIIlllIIIlllIllllIIlI, lllllllllllIIIlllIIIlllIllllIIll.getName());
    }
    
    @Override
    public void processEncryptionResponse(final CPacketEncryptionResponse lllllllllllIIIlllIIIlllIlllllIII) {
        Validate.validState(this.currentLoginState == LoginState.KEY, "Unexpected key packet", new Object[0]);
        final PrivateKey lllllllllllIIIlllIIIlllIlllllIlI = this.server.getKeyPair().getPrivate();
        if (!Arrays.equals(this.verifyToken, lllllllllllIIIlllIIIlllIlllllIII.getVerifyToken(lllllllllllIIIlllIIIlllIlllllIlI))) {
            throw new IllegalStateException("Invalid nonce!");
        }
        this.secretKey = lllllllllllIIIlllIIIlllIlllllIII.getSecretKey(lllllllllllIIIlllIIIlllIlllllIlI);
        this.currentLoginState = LoginState.AUTHENTICATING;
        this.networkManager.enableEncryption(this.secretKey);
        new Thread("User Authenticator #" + NetHandlerLoginServer.AUTHENTICATOR_THREAD_ID.incrementAndGet()) {
            @Nullable
            private InetAddress func_191235_a() {
                final SocketAddress lllllllllllIIIlllIIlllIlIIlIlIlI = NetHandlerLoginServer.this.networkManager.getRemoteAddress();
                return (NetHandlerLoginServer.this.server.func_190518_ac() && lllllllllllIIIlllIIlllIlIIlIlIlI instanceof InetSocketAddress) ? ((InetSocketAddress)lllllllllllIIIlllIIlllIlIIlIlIlI).getAddress() : null;
            }
            
            @Override
            public void run() {
                final GameProfile lllllllllllIIIlllIIlllIlIIllIIll = NetHandlerLoginServer.this.loginGameProfile;
                try {
                    final String lllllllllllIIIlllIIlllIlIIllIIlI = new BigInteger(CryptManager.getServerIdHash("", NetHandlerLoginServer.this.server.getKeyPair().getPublic(), NetHandlerLoginServer.this.secretKey)).toString(16);
                    NetHandlerLoginServer.access$3(NetHandlerLoginServer.this, NetHandlerLoginServer.this.server.getMinecraftSessionService().hasJoinedServer(new GameProfile((UUID)null, lllllllllllIIIlllIIlllIlIIllIIll.getName()), lllllllllllIIIlllIIlllIlIIllIIlI, this.func_191235_a()));
                    if (NetHandlerLoginServer.this.loginGameProfile != null) {
                        NetHandlerLoginServer.LOGGER.info("UUID of player {} is {}", (Object)NetHandlerLoginServer.this.loginGameProfile.getName(), (Object)NetHandlerLoginServer.this.loginGameProfile.getId());
                        NetHandlerLoginServer.access$5(NetHandlerLoginServer.this, LoginState.READY_TO_ACCEPT);
                    }
                    else if (NetHandlerLoginServer.this.server.isSinglePlayer()) {
                        NetHandlerLoginServer.LOGGER.warn("Failed to verify username but will let them in anyway!");
                        NetHandlerLoginServer.access$3(NetHandlerLoginServer.this, NetHandlerLoginServer.this.getOfflineProfile(lllllllllllIIIlllIIlllIlIIllIIll));
                        NetHandlerLoginServer.access$5(NetHandlerLoginServer.this, LoginState.READY_TO_ACCEPT);
                    }
                    else {
                        NetHandlerLoginServer.this.func_194026_b(new TextComponentTranslation("multiplayer.disconnect.unverified_username", new Object[0]));
                        NetHandlerLoginServer.LOGGER.error("Username '{}' tried to join with an invalid session", (Object)lllllllllllIIIlllIIlllIlIIllIIll.getName());
                    }
                }
                catch (AuthenticationUnavailableException lllllllllllIIIlllIIlllIlIIllIIIl) {
                    if (NetHandlerLoginServer.this.server.isSinglePlayer()) {
                        NetHandlerLoginServer.LOGGER.warn("Authentication servers are down but will let them in anyway!");
                        NetHandlerLoginServer.access$3(NetHandlerLoginServer.this, NetHandlerLoginServer.this.getOfflineProfile(lllllllllllIIIlllIIlllIlIIllIIll));
                        NetHandlerLoginServer.access$5(NetHandlerLoginServer.this, LoginState.READY_TO_ACCEPT);
                    }
                    else {
                        NetHandlerLoginServer.this.func_194026_b(new TextComponentTranslation("multiplayer.disconnect.authservers_down", new Object[0]));
                        NetHandlerLoginServer.LOGGER.error("Couldn't verify username because servers are unavailable");
                    }
                }
            }
        }.start();
    }
    
    public NetHandlerLoginServer(final MinecraftServer lllllllllllIIIlllIIIllllIIlIlIll, final NetworkManager lllllllllllIIIlllIIIllllIIlIIlll) {
        this.verifyToken = new byte[4];
        this.currentLoginState = LoginState.HELLO;
        this.server = lllllllllllIIIlllIIIllllIIlIlIll;
        this.networkManager = lllllllllllIIIlllIIIllllIIlIIlll;
        NetHandlerLoginServer.RANDOM.nextBytes(this.verifyToken);
    }
    
    static /* synthetic */ void access$3(final NetHandlerLoginServer lllllllllllIIIlllIIIlllIlllIIlll, final GameProfile lllllllllllIIIlllIIIlllIlllIIllI) {
        lllllllllllIIIlllIIIlllIlllIIlll.loginGameProfile = lllllllllllIIIlllIIIlllIlllIIllI;
    }
    
    @Override
    public void update() {
        if (this.currentLoginState == LoginState.READY_TO_ACCEPT) {
            this.tryAcceptPlayer();
        }
        else if (this.currentLoginState == LoginState.DELAY_ACCEPT) {
            final EntityPlayerMP lllllllllllIIIlllIIIllllIIlIIIll = this.server.getPlayerList().getPlayerByUUID(this.loginGameProfile.getId());
            if (lllllllllllIIIlllIIIllllIIlIIIll == null) {
                this.currentLoginState = LoginState.READY_TO_ACCEPT;
                this.server.getPlayerList().initializeConnectionToPlayer(this.networkManager, this.player);
                this.player = null;
            }
        }
        if (this.connectionTimer++ == 600) {
            this.func_194026_b(new TextComponentTranslation("multiplayer.disconnect.slow_login", new Object[0]));
        }
    }
    
    public void tryAcceptPlayer() {
        if (!this.loginGameProfile.isComplete()) {
            this.loginGameProfile = this.getOfflineProfile(this.loginGameProfile);
        }
        final String lllllllllllIIIlllIIIllllIIIlIIll = this.server.getPlayerList().allowUserToConnect(this.networkManager.getRemoteAddress(), this.loginGameProfile);
        if (lllllllllllIIIlllIIIllllIIIlIIll != null) {
            this.func_194026_b(new TextComponentTranslation(lllllllllllIIIlllIIIllllIIIlIIll, new Object[0]));
        }
        else {
            this.currentLoginState = LoginState.ACCEPTED;
            if (this.server.getNetworkCompressionThreshold() >= 0 && !this.networkManager.isLocalChannel()) {
                this.networkManager.sendPacket(new SPacketEnableCompression(this.server.getNetworkCompressionThreshold()), (GenericFutureListener<? extends Future<? super Void>>)new ChannelFutureListener() {
                    public void operationComplete(final ChannelFuture llllllllllllIlIIIlIllIlIIlIIlllI) throws Exception {
                        NetHandlerLoginServer.this.networkManager.setCompressionThreshold(NetHandlerLoginServer.this.server.getNetworkCompressionThreshold());
                    }
                }, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]);
            }
            this.networkManager.sendPacket(new SPacketLoginSuccess(this.loginGameProfile));
            final EntityPlayerMP lllllllllllIIIlllIIIllllIIIlIIlI = this.server.getPlayerList().getPlayerByUUID(this.loginGameProfile.getId());
            if (lllllllllllIIIlllIIIllllIIIlIIlI != null) {
                this.currentLoginState = LoginState.DELAY_ACCEPT;
                this.player = this.server.getPlayerList().createPlayerForUser(this.loginGameProfile);
            }
            else {
                this.server.getPlayerList().initializeConnectionToPlayer(this.networkManager, this.server.getPlayerList().createPlayerForUser(this.loginGameProfile));
            }
        }
    }
    
    public String getConnectionInfo() {
        return (this.loginGameProfile != null) ? (this.loginGameProfile + " (" + this.networkManager.getRemoteAddress() + ")") : String.valueOf(this.networkManager.getRemoteAddress());
    }
    
    enum LoginState
    {
        HELLO("HELLO", 0), 
        ACCEPTED("ACCEPTED", 5), 
        READY_TO_ACCEPT("READY_TO_ACCEPT", 3), 
        KEY("KEY", 1), 
        AUTHENTICATING("AUTHENTICATING", 2), 
        DELAY_ACCEPT("DELAY_ACCEPT", 4);
        
        private LoginState(final String llllllllllllIlIllIIllIllIlIlIllI, final int llllllllllllIlIllIIllIllIlIlIlIl) {
        }
    }
}
