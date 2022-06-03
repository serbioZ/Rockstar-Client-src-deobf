// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import org.apache.logging.log4j.LogManager;
import net.minecraft.client.network.LanServerInfo;
import org.lwjgl.input.Keyboard;
import java.io.IOException;
import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.base.Splitter;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.network.LanServerDetector;
import net.minecraft.client.network.ServerPinger;

public class GuiMultiplayer extends GuiScreen
{
    private /* synthetic */ boolean addingServer;
    private final /* synthetic */ ServerPinger oldServerPinger;
    private final /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ String hoveringText;
    private /* synthetic */ GuiButton btnEditServer;
    private /* synthetic */ LanServerDetector.ThreadLanServerFind lanServerDetector;
    private /* synthetic */ ServerList savedServerList;
    private /* synthetic */ GuiButton btnDeleteServer;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ boolean initialized;
    private /* synthetic */ LanServerDetector.LanServerList lanServerList;
    private /* synthetic */ boolean deletingServer;
    private /* synthetic */ ServerSelectionList serverListSelector;
    private /* synthetic */ boolean editingServer;
    private /* synthetic */ GuiButton btnSelectServer;
    private /* synthetic */ ServerData selectedServer;
    private /* synthetic */ boolean directConnect;
    
    private void connectToServer(final ServerData lllllllllllIlIlIIIIIIIlllIllllll) {
        this.mc.displayGuiScreen(new GuiConnecting(this, this.mc, lllllllllllIlIlIIIIIIIlllIllllll));
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIlIIIIIIIllllIIlllI, final int lllllllllllIlIlIIIIIIIllllIIllIl, final float lllllllllllIlIlIIIIIIIllllIlIIII) {
        this.hoveringText = null;
        this.drawDefaultBackground();
        this.serverListSelector.drawScreen(lllllllllllIlIlIIIIIIIllllIIlllI, lllllllllllIlIlIIIIIIIllllIIllIl, lllllllllllIlIlIIIIIIIllllIlIIII);
        this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.title", new Object[0]), this.width / 2, 20, 16777215);
        super.drawScreen(lllllllllllIlIlIIIIIIIllllIIlllI, lllllllllllIlIlIIIIIIIllllIIllIl, lllllllllllIlIlIIIIIIIllllIlIIII);
        if (this.hoveringText != null) {
            this.drawHoveringText(Lists.newArrayList(Splitter.on("\n").split((CharSequence)this.hoveringText)), lllllllllllIlIlIIIIIIIllllIIlllI, lllllllllllIlIlIIIIIIIllllIIllIl);
        }
    }
    
    public ServerPinger getOldServerPinger() {
        return this.oldServerPinger;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.serverListSelector.handleMouseInput();
    }
    
    @Override
    public void confirmClicked(final boolean lllllllllllIlIlIIIIIIIlllllIlllI, final int lllllllllllIlIlIIIIIIIlllllIllIl) {
        final GuiListExtended.IGuiListEntry lllllllllllIlIlIIIIIIIlllllIllII = (this.serverListSelector.getSelected() < 0) ? null : this.serverListSelector.getListEntry(this.serverListSelector.getSelected());
        if (this.deletingServer) {
            this.deletingServer = false;
            if (lllllllllllIlIlIIIIIIIlllllIlllI && lllllllllllIlIlIIIIIIIlllllIllII instanceof ServerListEntryNormal) {
                this.savedServerList.removeServerData(this.serverListSelector.getSelected());
                this.savedServerList.saveServerList();
                this.serverListSelector.setSelectedSlotIndex(-1);
                this.serverListSelector.updateOnlineServers(this.savedServerList);
            }
            this.mc.displayGuiScreen(this);
        }
        else if (this.directConnect) {
            this.directConnect = false;
            if (lllllllllllIlIlIIIIIIIlllllIlllI) {
                this.connectToServer(this.selectedServer);
            }
            else {
                this.mc.displayGuiScreen(this);
            }
        }
        else if (this.addingServer) {
            this.addingServer = false;
            if (lllllllllllIlIlIIIIIIIlllllIlllI) {
                this.savedServerList.addServerData(this.selectedServer);
                this.savedServerList.saveServerList();
                this.serverListSelector.setSelectedSlotIndex(-1);
                this.serverListSelector.updateOnlineServers(this.savedServerList);
            }
            this.mc.displayGuiScreen(this);
        }
        else if (this.editingServer) {
            this.editingServer = false;
            if (lllllllllllIlIlIIIIIIIlllllIlllI && lllllllllllIlIlIIIIIIIlllllIllII instanceof ServerListEntryNormal) {
                final ServerData lllllllllllIlIlIIIIIIIlllllIlIll = ((ServerListEntryNormal)lllllllllllIlIlIIIIIIIlllllIllII).getServerData();
                lllllllllllIlIlIIIIIIIlllllIlIll.serverName = this.selectedServer.serverName;
                lllllllllllIlIlIIIIIIIlllllIlIll.serverIP = this.selectedServer.serverIP;
                lllllllllllIlIlIIIIIIIlllllIlIll.copyFrom(this.selectedServer);
                this.savedServerList.saveServerList();
                this.serverListSelector.updateOnlineServers(this.savedServerList);
            }
            this.mc.displayGuiScreen(this);
        }
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        if (this.initialized) {
            this.serverListSelector.setDimensions(this.width, this.height, 32, this.height - 64);
        }
        else {
            this.initialized = true;
            this.savedServerList = new ServerList(this.mc);
            this.savedServerList.loadServerList();
            this.lanServerList = new LanServerDetector.LanServerList();
            try {
                this.lanServerDetector = new LanServerDetector.ThreadLanServerFind(this.lanServerList);
                this.lanServerDetector.start();
            }
            catch (Exception lllllllllllIlIlIIIIIIlIIIIlIIlII) {
                GuiMultiplayer.LOGGER.warn("Unable to start LAN server detection: {}", (Object)lllllllllllIlIlIIIIIIlIIIIlIIlII.getMessage());
            }
            this.serverListSelector = new ServerSelectionList(this, this.mc, this.width, this.height, 32, this.height - 64, 36);
            this.serverListSelector.updateOnlineServers(this.savedServerList);
        }
        this.createButtons();
    }
    
    public void moveServerUp(final ServerListEntryNormal lllllllllllIlIlIIIIIIIllIllllllI, final int lllllllllllIlIlIIIIIIIllIlllllIl, final boolean lllllllllllIlIlIIIIIIIllIlllllII) {
        final int lllllllllllIlIlIIIIIIIllIllllIll = lllllllllllIlIlIIIIIIIllIlllllII ? 0 : (lllllllllllIlIlIIIIIIIllIlllllIl - 1);
        this.savedServerList.swapServers(lllllllllllIlIlIIIIIIIllIlllllIl, lllllllllllIlIlIIIIIIIllIllllIll);
        if (this.serverListSelector.getSelected() == lllllllllllIlIlIIIIIIIllIlllllIl) {
            this.selectServer(lllllllllllIlIlIIIIIIIllIllllIll);
        }
        this.serverListSelector.updateOnlineServers(this.savedServerList);
    }
    
    public void moveServerDown(final ServerListEntryNormal lllllllllllIlIlIIIIIIIllIlllIIIl, final int lllllllllllIlIlIIIIIIIllIlllIIII, final boolean lllllllllllIlIlIIIIIIIllIllIllll) {
        final int lllllllllllIlIlIIIIIIIllIllIlllI = lllllllllllIlIlIIIIIIIllIllIllll ? (this.savedServerList.countServers() - 1) : (lllllllllllIlIlIIIIIIIllIlllIIII + 1);
        this.savedServerList.swapServers(lllllllllllIlIlIIIIIIIllIlllIIII, lllllllllllIlIlIIIIIIIllIllIlllI);
        if (this.serverListSelector.getSelected() == lllllllllllIlIlIIIIIIIllIlllIIII) {
            this.selectServer(lllllllllllIlIlIIIIIIIllIllIlllI);
        }
        this.serverListSelector.updateOnlineServers(this.savedServerList);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlIlIIIIIIIlllllIIIII, final int lllllllllllIlIlIIIIIIIllllIllIlI) throws IOException {
        final int lllllllllllIlIlIIIIIIIllllIllllI = this.serverListSelector.getSelected();
        final GuiListExtended.IGuiListEntry lllllllllllIlIlIIIIIIIllllIlllIl = (lllllllllllIlIlIIIIIIIllllIllllI < 0) ? null : this.serverListSelector.getListEntry(lllllllllllIlIlIIIIIIIllllIllllI);
        if (lllllllllllIlIlIIIIIIIllllIllIlI == 63) {
            this.refreshServerList();
        }
        else if (lllllllllllIlIlIIIIIIIllllIllllI >= 0) {
            if (lllllllllllIlIlIIIIIIIllllIllIlI == 200) {
                if (isShiftKeyDown()) {
                    if (lllllllllllIlIlIIIIIIIllllIllllI > 0 && lllllllllllIlIlIIIIIIIllllIlllIl instanceof ServerListEntryNormal) {
                        this.savedServerList.swapServers(lllllllllllIlIlIIIIIIIllllIllllI, lllllllllllIlIlIIIIIIIllllIllllI - 1);
                        this.selectServer(this.serverListSelector.getSelected() - 1);
                        this.serverListSelector.scrollBy(-this.serverListSelector.getSlotHeight());
                        this.serverListSelector.updateOnlineServers(this.savedServerList);
                    }
                }
                else if (lllllllllllIlIlIIIIIIIllllIllllI > 0) {
                    this.selectServer(this.serverListSelector.getSelected() - 1);
                    this.serverListSelector.scrollBy(-this.serverListSelector.getSlotHeight());
                    if (this.serverListSelector.getListEntry(this.serverListSelector.getSelected()) instanceof ServerListEntryLanScan) {
                        if (this.serverListSelector.getSelected() > 0) {
                            this.selectServer(this.serverListSelector.getSize() - 1);
                            this.serverListSelector.scrollBy(-this.serverListSelector.getSlotHeight());
                        }
                        else {
                            this.selectServer(-1);
                        }
                    }
                }
                else {
                    this.selectServer(-1);
                }
            }
            else if (lllllllllllIlIlIIIIIIIllllIllIlI == 208) {
                if (isShiftKeyDown()) {
                    if (lllllllllllIlIlIIIIIIIllllIllllI < this.savedServerList.countServers() - 1) {
                        this.savedServerList.swapServers(lllllllllllIlIlIIIIIIIllllIllllI, lllllllllllIlIlIIIIIIIllllIllllI + 1);
                        this.selectServer(lllllllllllIlIlIIIIIIIllllIllllI + 1);
                        this.serverListSelector.scrollBy(this.serverListSelector.getSlotHeight());
                        this.serverListSelector.updateOnlineServers(this.savedServerList);
                    }
                }
                else if (lllllllllllIlIlIIIIIIIllllIllllI < this.serverListSelector.getSize()) {
                    this.selectServer(this.serverListSelector.getSelected() + 1);
                    this.serverListSelector.scrollBy(this.serverListSelector.getSlotHeight());
                    if (this.serverListSelector.getListEntry(this.serverListSelector.getSelected()) instanceof ServerListEntryLanScan) {
                        if (this.serverListSelector.getSelected() < this.serverListSelector.getSize() - 1) {
                            this.selectServer(this.serverListSelector.getSize() + 1);
                            this.serverListSelector.scrollBy(this.serverListSelector.getSlotHeight());
                        }
                        else {
                            this.selectServer(-1);
                        }
                    }
                }
                else {
                    this.selectServer(-1);
                }
            }
            else if (lllllllllllIlIlIIIIIIIllllIllIlI != 28 && lllllllllllIlIlIIIIIIIllllIllIlI != 156) {
                super.keyTyped(lllllllllllIlIlIIIIIIIlllllIIIII, lllllllllllIlIlIIIIIIIllllIllIlI);
            }
            else {
                this.actionPerformed(this.buttonList.get(2));
            }
        }
        else {
            super.keyTyped(lllllllllllIlIlIIIIIIIlllllIIIII, lllllllllllIlIlIIIIIIIllllIllIlI);
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlIlIIIIIIlIIIIIIlIII) throws IOException {
        if (lllllllllllIlIlIIIIIIlIIIIIIlIII.enabled) {
            final GuiListExtended.IGuiListEntry lllllllllllIlIlIIIIIIlIIIIIIIlll = (this.serverListSelector.getSelected() < 0) ? null : this.serverListSelector.getListEntry(this.serverListSelector.getSelected());
            if (lllllllllllIlIlIIIIIIlIIIIIIlIII.id == 2 && lllllllllllIlIlIIIIIIlIIIIIIIlll instanceof ServerListEntryNormal) {
                final String lllllllllllIlIlIIIIIIlIIIIIIIllI = ((ServerListEntryNormal)lllllllllllIlIlIIIIIIlIIIIIIIlll).getServerData().serverName;
                if (lllllllllllIlIlIIIIIIlIIIIIIIllI != null) {
                    this.deletingServer = true;
                    final String lllllllllllIlIlIIIIIIlIIIIIIIlIl = I18n.format("selectServer.deleteQuestion", new Object[0]);
                    final String lllllllllllIlIlIIIIIIlIIIIIIIlII = "'" + lllllllllllIlIlIIIIIIlIIIIIIIllI + "' " + I18n.format("selectServer.deleteWarning", new Object[0]);
                    final String lllllllllllIlIlIIIIIIlIIIIIIIIll = I18n.format("selectServer.deleteButton", new Object[0]);
                    final String lllllllllllIlIlIIIIIIlIIIIIIIIlI = I18n.format("gui.cancel", new Object[0]);
                    final GuiYesNo lllllllllllIlIlIIIIIIlIIIIIIIIIl = new GuiYesNo(this, lllllllllllIlIlIIIIIIlIIIIIIIlIl, lllllllllllIlIlIIIIIIlIIIIIIIlII, lllllllllllIlIlIIIIIIlIIIIIIIIll, lllllllllllIlIlIIIIIIlIIIIIIIIlI, this.serverListSelector.getSelected());
                    this.mc.displayGuiScreen(lllllllllllIlIlIIIIIIlIIIIIIIIIl);
                }
            }
            else if (lllllllllllIlIlIIIIIIlIIIIIIlIII.id == 1) {
                this.connectToSelected();
            }
            else if (lllllllllllIlIlIIIIIIlIIIIIIlIII.id == 4) {
                this.directConnect = true;
                this.selectedServer = new ServerData(I18n.format("selectServer.defaultName", new Object[0]), "", false);
                this.mc.displayGuiScreen(new GuiScreenServerList(this, this.selectedServer));
            }
            else if (lllllllllllIlIlIIIIIIlIIIIIIlIII.id == 3) {
                this.addingServer = true;
                this.selectedServer = new ServerData(I18n.format("selectServer.defaultName", new Object[0]), "", false);
                this.mc.displayGuiScreen(new GuiScreenAddServer(this, this.selectedServer));
            }
            else if (lllllllllllIlIlIIIIIIlIIIIIIlIII.id == 7 && lllllllllllIlIlIIIIIIlIIIIIIIlll instanceof ServerListEntryNormal) {
                this.editingServer = true;
                final ServerData lllllllllllIlIlIIIIIIlIIIIIIIIII = ((ServerListEntryNormal)lllllllllllIlIlIIIIIIlIIIIIIIlll).getServerData();
                this.selectedServer = new ServerData(lllllllllllIlIlIIIIIIlIIIIIIIIII.serverName, lllllllllllIlIlIIIIIIlIIIIIIIIII.serverIP, false);
                this.selectedServer.copyFrom(lllllllllllIlIlIIIIIIlIIIIIIIIII);
                this.mc.displayGuiScreen(new GuiScreenAddServer(this, this.selectedServer));
            }
            else if (lllllllllllIlIlIIIIIIlIIIIIIlIII.id == 0) {
                this.mc.displayGuiScreen(this.parentScreen);
            }
            else if (lllllllllllIlIlIIIIIIlIIIIIIlIII.id == 8) {
                this.refreshServerList();
            }
        }
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlIlIIIIIIIlllIlIIlIl, final int lllllllllllIlIlIIIIIIIlllIlIIIII, final int lllllllllllIlIlIIIIIIIlllIlIIIll) throws IOException {
        super.mouseClicked(lllllllllllIlIlIIIIIIIlllIlIIlIl, lllllllllllIlIlIIIIIIIlllIlIIIII, lllllllllllIlIlIIIIIIIlllIlIIIll);
        this.serverListSelector.mouseClicked(lllllllllllIlIlIIIIIIIlllIlIIlIl, lllllllllllIlIlIIIIIIIlllIlIIIII, lllllllllllIlIlIIIIIIIlllIlIIIll);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        if (this.lanServerDetector != null) {
            this.lanServerDetector.interrupt();
            this.lanServerDetector = null;
        }
        this.oldServerPinger.clearPendingNetworks();
    }
    
    public ServerList getServerList() {
        return this.savedServerList;
    }
    
    private void refreshServerList() {
        this.mc.displayGuiScreen(new GuiMultiplayer(this.parentScreen));
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllIlIlIIIIIIIlllIIlIlIl, final int lllllllllllIlIlIIIIIIIlllIIlIlII, final int lllllllllllIlIlIIIIIIIlllIIlIlll) {
        super.mouseReleased(lllllllllllIlIlIIIIIIIlllIIlIlIl, lllllllllllIlIlIIIIIIIlllIIlIlII, lllllllllllIlIlIIIIIIIlllIIlIlll);
        this.serverListSelector.mouseReleased(lllllllllllIlIlIIIIIIIlllIIlIlIl, lllllllllllIlIlIIIIIIIlllIIlIlII, lllllllllllIlIlIIIIIIIlllIIlIlll);
    }
    
    public void selectServer(final int lllllllllllIlIlIIIIIIIlllIllIlIl) {
        this.serverListSelector.setSelectedSlotIndex(lllllllllllIlIlIIIIIIIlllIllIlIl);
        final GuiListExtended.IGuiListEntry lllllllllllIlIlIIIIIIIlllIllIlll = (lllllllllllIlIlIIIIIIIlllIllIlIl < 0) ? null : this.serverListSelector.getListEntry(lllllllllllIlIlIIIIIIIlllIllIlIl);
        this.btnSelectServer.enabled = false;
        this.btnEditServer.enabled = false;
        this.btnDeleteServer.enabled = false;
        if (lllllllllllIlIlIIIIIIIlllIllIlll != null && !(lllllllllllIlIlIIIIIIIlllIllIlll instanceof ServerListEntryLanScan)) {
            this.btnSelectServer.enabled = true;
            if (lllllllllllIlIlIIIIIIIlllIllIlll instanceof ServerListEntryNormal) {
                this.btnEditServer.enabled = true;
                this.btnDeleteServer.enabled = true;
            }
        }
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.lanServerList.getWasUpdated()) {
            final List<LanServerInfo> lllllllllllIlIlIIIIIIlIIIIIllIII = this.lanServerList.getLanServers();
            this.lanServerList.setWasNotUpdated();
            this.serverListSelector.updateNetworkServers(lllllllllllIlIlIIIIIIlIIIIIllIII);
        }
        this.oldServerPinger.pingPendingNetworks();
    }
    
    public void setHoveringText(final String lllllllllllIlIlIIIIIIIlllIlIllIl) {
        this.hoveringText = lllllllllllIlIlIIIIIIIlllIlIllIl;
    }
    
    public boolean canMoveDown(final ServerListEntryNormal lllllllllllIlIlIIIIIIIlllIIIIlll, final int lllllllllllIlIlIIIIIIIlllIIIIlII) {
        return lllllllllllIlIlIIIIIIIlllIIIIlII < this.savedServerList.countServers() - 1;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public GuiMultiplayer(final GuiScreen lllllllllllIlIlIIIIIIlIIIIlIlIlI) {
        this.oldServerPinger = new ServerPinger();
        this.parentScreen = lllllllllllIlIlIIIIIIlIIIIlIlIlI;
    }
    
    public void connectToSelected() {
        final GuiListExtended.IGuiListEntry lllllllllllIlIlIIIIIIIllllIIIlll = (this.serverListSelector.getSelected() < 0) ? null : this.serverListSelector.getListEntry(this.serverListSelector.getSelected());
        if (lllllllllllIlIlIIIIIIIllllIIIlll instanceof ServerListEntryNormal) {
            this.connectToServer(((ServerListEntryNormal)lllllllllllIlIlIIIIIIIllllIIIlll).getServerData());
        }
        else if (lllllllllllIlIlIIIIIIIllllIIIlll instanceof ServerListEntryLanDetected) {
            final LanServerInfo lllllllllllIlIlIIIIIIIllllIIIllI = ((ServerListEntryLanDetected)lllllllllllIlIlIIIIIIIllllIIIlll).getServerData();
            this.connectToServer(new ServerData(lllllllllllIlIlIIIIIIIllllIIIllI.getServerMotd(), lllllllllllIlIlIIIIIIIllllIIIllI.getServerIpPort(), true));
        }
    }
    
    public boolean canMoveUp(final ServerListEntryNormal lllllllllllIlIlIIIIIIIlllIIIllIl, final int lllllllllllIlIlIIIIIIIlllIIIllII) {
        return lllllllllllIlIlIIIIIIIlllIIIllII > 0;
    }
    
    public void createButtons() {
        this.btnEditServer = this.addButton(new GuiButton(7, this.width / 2 - 154, this.height - 28, 70, 20, I18n.format("selectServer.edit", new Object[0])));
        this.btnDeleteServer = this.addButton(new GuiButton(2, this.width / 2 - 74, this.height - 28, 70, 20, I18n.format("selectServer.delete", new Object[0])));
        this.btnSelectServer = this.addButton(new GuiButton(1, this.width / 2 - 154, this.height - 52, 100, 20, I18n.format("selectServer.select", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 50, this.height - 52, 100, 20, I18n.format("selectServer.direct", new Object[0])));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 4 + 50, this.height - 52, 100, 20, I18n.format("selectServer.add", new Object[0])));
        this.buttonList.add(new GuiButton(8, this.width / 2 + 4, this.height - 28, 70, 20, I18n.format("selectServer.refresh", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 + 4 + 76, this.height - 28, 75, 20, I18n.format("gui.cancel", new Object[0])));
        this.selectServer(this.serverListSelector.getSelected());
    }
}
