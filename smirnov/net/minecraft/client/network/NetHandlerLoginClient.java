// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.network;

import java.security.PublicKey;
import net.minecraft.network.Packet;
import javax.crypto.SecretKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.login.client.CPacketEncryptionResponse;
import com.mojang.authlib.exceptions.InvalidCredentialsException;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import net.minecraft.util.text.TextComponentTranslation;
import com.mojang.authlib.exceptions.AuthenticationException;
import java.math.BigInteger;
import net.minecraft.util.CryptManager;
import net.minecraft.network.login.server.SPacketEncryptionRequest;
import org.apache.logging.log4j.LogManager;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.realms.DisconnectedRealmsScreen;
import net.minecraft.client.gui.GuiScreenRealmsProxy;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.login.server.SPacketEnableCompression;
import net.minecraft.network.INetHandler;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.login.server.SPacketLoginSuccess;
import net.minecraft.network.login.server.SPacketDisconnect;
import com.mojang.authlib.GameProfile;
import net.minecraft.network.NetworkManager;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Logger;
import javax.annotation.Nullable;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.login.INetHandlerLoginClient;

public class NetHandlerLoginClient implements INetHandlerLoginClient
{
    @Nullable
    private final /* synthetic */ GuiScreen previousGuiScreen;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ NetworkManager networkManager;
    private /* synthetic */ GameProfile gameProfile;
    
    public NetHandlerLoginClient(final NetworkManager lllllllllllIIIlIIIIlIlIlIlIllIlI, final Minecraft lllllllllllIIIlIIIIlIlIlIlIllIIl, @Nullable final GuiScreen lllllllllllIIIlIIIIlIlIlIlIlIlII) {
        this.networkManager = lllllllllllIIIlIIIIlIlIlIlIllIlI;
        this.mc = lllllllllllIIIlIIIIlIlIlIlIllIIl;
        this.previousGuiScreen = lllllllllllIIIlIIIIlIlIlIlIlIlII;
    }
    
    @Override
    public void handleDisconnect(final SPacketDisconnect lllllllllllIIIlIIIIlIlIlIIlIIlll) {
        this.networkManager.closeChannel(lllllllllllIIIlIIIIlIlIlIIlIIlll.getReason());
    }
    
    @Override
    public void handleLoginSuccess(final SPacketLoginSuccess lllllllllllIIIlIIIIlIlIlIIllIlIl) {
        this.gameProfile = lllllllllllIIIlIIIIlIlIlIIllIlIl.getProfile();
        this.networkManager.setConnectionState(EnumConnectionState.PLAY);
        this.networkManager.setNetHandler(new NetHandlerPlayClient(this.mc, this.previousGuiScreen, this.networkManager, this.gameProfile));
    }
    
    @Override
    public void handleEnableCompression(final SPacketEnableCompression lllllllllllIIIlIIIIlIlIlIIlIIIIl) {
        if (!this.networkManager.isLocalChannel()) {
            this.networkManager.setCompressionThreshold(lllllllllllIIIlIIIIlIlIlIIlIIIIl.getCompressionThreshold());
        }
    }
    
    @Override
    public void onDisconnect(final ITextComponent lllllllllllIIIlIIIIlIlIlIIlIllIl) {
        if (this.previousGuiScreen != null && this.previousGuiScreen instanceof GuiScreenRealmsProxy) {
            this.mc.displayGuiScreen(new DisconnectedRealmsScreen(((GuiScreenRealmsProxy)this.previousGuiScreen).getProxy(), "connect.failed", lllllllllllIIIlIIIIlIlIlIIlIllIl).getProxy());
        }
        else {
            this.mc.displayGuiScreen(new GuiDisconnected(this.previousGuiScreen, "connect.failed", lllllllllllIIIlIIIIlIlIlIIlIllIl));
        }
    }
    
    private MinecraftSessionService getSessionService() {
        return this.mc.getSessionService();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void handleEncryptionRequest(final SPacketEncryptionRequest lllllllllllIIIlIIIIlIlIlIlIIIIIl) {
        final SecretKey lllllllllllIIIlIIIIlIlIlIlIIlIlI = CryptManager.createNewSharedKey();
        final String lllllllllllIIIlIIIIlIlIlIlIIlIIl = lllllllllllIIIlIIIIlIlIlIlIIIIIl.getServerId();
        final PublicKey lllllllllllIIIlIIIIlIlIlIlIIlIII = lllllllllllIIIlIIIIlIlIlIlIIIIIl.getPublicKey();
        final String lllllllllllIIIlIIIIlIlIlIlIIIlll = new BigInteger(CryptManager.getServerIdHash(lllllllllllIIIlIIIIlIlIlIlIIlIIl, lllllllllllIIIlIIIIlIlIlIlIIlIII, lllllllllllIIIlIIIIlIlIlIlIIlIlI)).toString(16);
        if (this.mc.getCurrentServerData() != null && this.mc.getCurrentServerData().isOnLAN()) {
            try {
                this.getSessionService().joinServer(this.mc.getSession().getProfile(), this.mc.getSession().getToken(), lllllllllllIIIlIIIIlIlIlIlIIIlll);
            }
            catch (AuthenticationException lllllllllllIIIlIIIIlIlIlIlIIIllI) {
                NetHandlerLoginClient.LOGGER.warn("Couldn't connect to auth servers but will continue to join LAN");
            }
        }
        else {
            try {
                this.getSessionService().joinServer(this.mc.getSession().getProfile(), this.mc.getSession().getToken(), lllllllllllIIIlIIIIlIlIlIlIIIlll);
            }
            catch (AuthenticationUnavailableException lllllllllllIIIlIIIIlIlIlIlIIIlIl) {
                this.networkManager.closeChannel(new TextComponentTranslation("disconnect.loginFailedInfo", new Object[] { new TextComponentTranslation("disconnect.loginFailedInfo.serversUnavailable", new Object[0]) }));
                return;
            }
            catch (InvalidCredentialsException lllllllllllIIIlIIIIlIlIlIlIIIlII) {
                this.networkManager.closeChannel(new TextComponentTranslation("disconnect.loginFailedInfo", new Object[] { new TextComponentTranslation("disconnect.loginFailedInfo.invalidSession", new Object[0]) }));
                return;
            }
            catch (AuthenticationException lllllllllllIIIlIIIIlIlIlIlIIIIll) {
                this.networkManager.closeChannel(new TextComponentTranslation("disconnect.loginFailedInfo", new Object[] { lllllllllllIIIlIIIIlIlIlIlIIIIll.getMessage() }));
                return;
            }
        }
        this.networkManager.sendPacket(new CPacketEncryptionResponse(lllllllllllIIIlIIIIlIlIlIlIIlIlI, lllllllllllIIIlIIIIlIlIlIlIIlIII, lllllllllllIIIlIIIIlIlIlIlIIIIIl.getVerifyToken()), (GenericFutureListener<? extends Future<? super Void>>)new GenericFutureListener<Future<? super Void>>() {
            public void operationComplete(final Future<? super Void> llllllllllllllIllllIlIIlIIIIIIII) throws Exception {
                NetHandlerLoginClient.this.networkManager.enableEncryption(lllllllllllIIIlIIIIlIlIlIlIIlIlI);
            }
        }, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]);
    }
}
