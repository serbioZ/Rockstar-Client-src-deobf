// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import org.apache.logging.log4j.LogManager;
import java.net.UnknownHostException;
import net.minecraft.network.login.client.CPacketLoginStart;
import net.minecraft.network.Packet;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.client.Minecraft;
import java.net.InetAddress;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import org.apache.logging.log4j.Logger;
import net.minecraft.network.NetworkManager;

public class RealmsConnect
{
    private final /* synthetic */ RealmsScreen onlineScreen;
    private volatile /* synthetic */ boolean aborted;
    private /* synthetic */ NetworkManager connection;
    private static final /* synthetic */ Logger LOGGER;
    
    public void abort() {
        this.aborted = true;
        if (this.connection != null && this.connection.isChannelOpen()) {
            this.connection.closeChannel(new TextComponentTranslation("disconnect.genericReason", new Object[0]));
            this.connection.checkDisconnected();
        }
    }
    
    public void connect(final String lllllllllllllIlIllIlIIllllIIIIIl, final int lllllllllllllIlIllIlIIllllIIIIll) {
        Realms.setConnectedToRealms(true);
        new Thread("Realms-connect-task") {
            @Override
            public void run() {
                InetAddress lllllllllllIlIIIIlIlllIIlIlIIlIl = null;
                try {
                    lllllllllllIlIIIIlIlllIIlIlIIlIl = InetAddress.getByName(lllllllllllllIlIllIlIIllllIIIIIl);
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.access$1(RealmsConnect.this, NetworkManager.createNetworkManagerAndConnect(lllllllllllIlIIIIlIlllIIlIlIIlIl, lllllllllllllIlIllIlIIllllIIIIll, Minecraft.getMinecraft().gameSettings.isUsingNativeTransport()));
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.this.connection.setNetHandler(new NetHandlerLoginClient(RealmsConnect.this.connection, Minecraft.getMinecraft(), RealmsConnect.this.onlineScreen.getProxy()));
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.this.connection.sendPacket(new C00Handshake(lllllllllllllIlIllIlIIllllIIIIIl, lllllllllllllIlIllIlIIllllIIIIll, EnumConnectionState.LOGIN));
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.this.connection.sendPacket(new CPacketLoginStart(Minecraft.getMinecraft().getSession().getProfile()));
                }
                catch (UnknownHostException lllllllllllIlIIIIlIlllIIlIlIIlII) {
                    Realms.clearResourcePack();
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.LOGGER.error("Couldn't connect to world", (Throwable)lllllllllllIlIIIIlIlllIIlIlIIlII);
                    Realms.setScreen(new DisconnectedRealmsScreen(RealmsConnect.this.onlineScreen, "connect.failed", new TextComponentTranslation("disconnect.genericReason", new Object[] { "Unknown host '" + lllllllllllllIlIllIlIIllllIIIIIl + "'" })));
                }
                catch (Exception lllllllllllIlIIIIlIlllIIlIlIIIll) {
                    Realms.clearResourcePack();
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.LOGGER.error("Couldn't connect to world", (Throwable)lllllllllllIlIIIIlIlllIIlIlIIIll);
                    String lllllllllllIlIIIIlIlllIIlIlIIIlI = lllllllllllIlIIIIlIlllIIlIlIIIll.toString();
                    if (lllllllllllIlIIIIlIlllIIlIlIIlIl != null) {
                        final String lllllllllllIlIIIIlIlllIIlIlIIIIl = lllllllllllIlIIIIlIlllIIlIlIIlIl + ":" + lllllllllllllIlIllIlIIllllIIIIll;
                        lllllllllllIlIIIIlIlllIIlIlIIIlI = lllllllllllIlIIIIlIlllIIlIlIIIlI.replaceAll(lllllllllllIlIIIIlIlllIIlIlIIIIl, "");
                    }
                    Realms.setScreen(new DisconnectedRealmsScreen(RealmsConnect.this.onlineScreen, "connect.failed", new TextComponentTranslation("disconnect.genericReason", new Object[] { lllllllllllIlIIIIlIlllIIlIlIIIlI })));
                }
            }
        }.start();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void tick() {
        if (this.connection != null) {
            if (this.connection.isChannelOpen()) {
                this.connection.processReceivedPackets();
            }
            else {
                this.connection.checkDisconnected();
            }
        }
    }
    
    static /* synthetic */ void access$1(final RealmsConnect lllllllllllllIlIllIlIIlllIllIlIl, final NetworkManager lllllllllllllIlIllIlIIlllIllIlII) {
        lllllllllllllIlIllIlIIlllIllIlIl.connection = lllllllllllllIlIllIlIIlllIllIlII;
    }
    
    public RealmsConnect(final RealmsScreen lllllllllllllIlIllIlIIllllIIlIIl) {
        this.onlineScreen = lllllllllllllIlIllIlIIllllIIlIIl;
    }
}
