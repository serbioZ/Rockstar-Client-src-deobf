// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.multiplayer;

import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import java.net.UnknownHostException;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.network.login.client.CPacketLoginStart;
import net.minecraft.network.Packet;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.client.network.NetHandlerLoginClient;
import java.net.InetAddress;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.network.NetworkManager;
import net.minecraft.client.gui.GuiScreen;

public class GuiConnecting extends GuiScreen
{
    private /* synthetic */ NetworkManager networkManager;
    private final /* synthetic */ GuiScreen previousGuiScreen;
    private /* synthetic */ boolean cancel;
    private static final /* synthetic */ AtomicInteger CONNECTION_ID;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public void updateScreen() {
        if (this.networkManager != null) {
            if (this.networkManager.isChannelOpen()) {
                this.networkManager.processReceivedPackets();
            }
            else {
                this.networkManager.checkDisconnected();
            }
        }
    }
    
    static /* synthetic */ void access$2(final GuiConnecting lllllllllllIlIllIllIIlIllIlIIlII, final NetworkManager lllllllllllIlIllIllIIlIllIlIIIll) {
        lllllllllllIlIllIllIIlIllIlIIlII.networkManager = lllllllllllIlIllIllIIlIllIlIIIll;
    }
    
    public GuiConnecting(final GuiScreen lllllllllllIlIllIllIIlIlllIlIIlI, final Minecraft lllllllllllIlIllIllIIlIlllIlIIIl, final String lllllllllllIlIllIllIIlIlllIlIlIl, final int lllllllllllIlIllIllIIlIlllIlIlII) {
        this.mc = lllllllllllIlIllIllIIlIlllIlIIIl;
        this.previousGuiScreen = lllllllllllIlIllIllIIlIlllIlIIlI;
        lllllllllllIlIllIllIIlIlllIlIIIl.loadWorld(null);
        this.connect(lllllllllllIlIllIllIIlIlllIlIlIl, lllllllllllIlIllIllIIlIlllIlIlII);
    }
    
    private void connect(final String lllllllllllIlIllIllIIlIlllIIIlll, final int lllllllllllIlIllIllIIlIlllIIIllI) {
        GuiConnecting.LOGGER.info("Connecting to {}, {}", (Object)lllllllllllIlIllIllIIlIlllIIIlll, (Object)lllllllllllIlIllIllIIlIlllIIIllI);
        new Thread("Server Connector #" + GuiConnecting.CONNECTION_ID.incrementAndGet()) {
            @Override
            public void run() {
                InetAddress llllllllllllIlIIllIIlIlllIlIlIll = null;
                try {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    llllllllllllIlIIllIIlIlllIlIlIll = InetAddress.getByName(lllllllllllIlIllIllIIlIlllIIIlll);
                    GuiConnecting.access$2(GuiConnecting.this, NetworkManager.createNetworkManagerAndConnect(llllllllllllIlIIllIIlIlllIlIlIll, lllllllllllIlIllIllIIlIlllIIIllI, GuiConnecting.this.mc.gameSettings.isUsingNativeTransport()));
                    GuiConnecting.this.networkManager.setNetHandler(new NetHandlerLoginClient(GuiConnecting.this.networkManager, GuiConnecting.this.mc, GuiConnecting.this.previousGuiScreen));
                    GuiConnecting.this.networkManager.sendPacket(new C00Handshake(lllllllllllIlIllIllIIlIlllIIIlll, lllllllllllIlIllIllIIlIlllIIIllI, EnumConnectionState.LOGIN));
                    GuiConnecting.this.networkManager.sendPacket(new CPacketLoginStart(GuiConnecting.this.mc.getSession().getProfile()));
                }
                catch (UnknownHostException llllllllllllIlIIllIIlIlllIlIlIlI) {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    GuiConnecting.LOGGER.error("Couldn't connect to server", (Throwable)llllllllllllIlIIllIIlIlllIlIlIlI);
                    GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new TextComponentTranslation("disconnect.genericReason", new Object[] { "Unknown host" })));
                }
                catch (Exception llllllllllllIlIIllIIlIlllIlIlIIl) {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    GuiConnecting.LOGGER.error("Couldn't connect to server", (Throwable)llllllllllllIlIIllIIlIlllIlIlIIl);
                    String llllllllllllIlIIllIIlIlllIlIlIII = llllllllllllIlIIllIIlIlllIlIlIIl.toString();
                    if (llllllllllllIlIIllIIlIlllIlIlIll != null) {
                        final String llllllllllllIlIIllIIlIlllIlIIlll = llllllllllllIlIIllIIlIlllIlIlIll + ":" + lllllllllllIlIllIllIIlIlllIIIllI;
                        llllllllllllIlIIllIIlIlllIlIlIII = llllllllllllIlIIllIIlIlllIlIlIII.replaceAll(llllllllllllIlIIllIIlIlllIlIIlll, "");
                    }
                    GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new TextComponentTranslation("disconnect.genericReason", new Object[] { llllllllllllIlIIllIIlIlllIlIlIII })));
                }
            }
        }.start();
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIllIllIIlIllIlIllIl, final int lllllllllllIlIllIllIIlIllIlIllII, final float lllllllllllIlIllIllIIlIllIlIllll) {
        this.drawDefaultBackground();
        if (this.networkManager == null) {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.connecting", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        }
        else {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.authorizing", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        }
        super.drawScreen(lllllllllllIlIllIllIIlIllIlIllIl, lllllllllllIlIllIllIIlIllIlIllII, lllllllllllIlIllIllIIlIllIlIllll);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlIllIllIIlIllIlllIIl) throws IOException {
        if (lllllllllllIlIllIllIIlIllIlllIIl.id == 0) {
            this.cancel = true;
            if (this.networkManager != null) {
                this.networkManager.closeChannel(new TextComponentString("Aborted"));
            }
            this.mc.displayGuiScreen(this.previousGuiScreen);
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
    }
    
    static {
        CONNECTION_ID = new AtomicInteger(0);
        LOGGER = LogManager.getLogger();
    }
    
    public GuiConnecting(final GuiScreen lllllllllllIlIllIllIIlIllllIIIIl, final Minecraft lllllllllllIlIllIllIIlIllllIIIII, final ServerData lllllllllllIlIllIllIIlIllllIIlII) {
        this.mc = lllllllllllIlIllIllIIlIllllIIIII;
        this.previousGuiScreen = lllllllllllIlIllIllIIlIllllIIIIl;
        final ServerAddress lllllllllllIlIllIllIIlIllllIIIll = ServerAddress.fromString(lllllllllllIlIllIllIIlIllllIIlII.serverIP);
        lllllllllllIlIllIllIIlIllllIIIII.loadWorld(null);
        lllllllllllIlIllIllIIlIllllIIIII.setServerData(lllllllllllIlIllIllIIlIllllIIlII);
        this.connect(lllllllllllIlIllIllIIlIllllIIIll.getIP(), lllllllllllIlIllIllIIlIllllIIIll.getPort());
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlIllIllIIlIlllIIIIIl, final int lllllllllllIlIllIllIIlIlllIIIIII) throws IOException {
    }
}
