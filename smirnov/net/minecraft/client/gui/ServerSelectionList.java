// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.network.LanServerInfo;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerList;
import java.util.List;

public class ServerSelectionList extends GuiListExtended
{
    private final /* synthetic */ IGuiListEntry lanScanEntry;
    private final /* synthetic */ GuiMultiplayer owner;
    private /* synthetic */ int selectedSlotIndex;
    private final /* synthetic */ List<ServerListEntryLanDetected> serverListLan;
    private final /* synthetic */ List<ServerListEntryNormal> serverListInternet;
    
    public int getSelected() {
        return this.selectedSlotIndex;
    }
    
    public void updateOnlineServers(final ServerList lllllllllllIlIIllIlIllIlIlIlllIl) {
        this.serverListInternet.clear();
        for (int lllllllllllIlIIllIlIllIlIlIlllII = 0; lllllllllllIlIIllIlIllIlIlIlllII < lllllllllllIlIIllIlIllIlIlIlllIl.countServers(); ++lllllllllllIlIIllIlIllIlIlIlllII) {
            this.serverListInternet.add(new ServerListEntryNormal(this.owner, lllllllllllIlIIllIlIllIlIlIlllIl.getServerData(lllllllllllIlIIllIlIllIlIlIlllII)));
        }
    }
    
    @Override
    protected boolean isSelected(final int lllllllllllIlIIllIlIllIlIllIIlll) {
        return lllllllllllIlIIllIlIllIlIllIIlll == this.selectedSlotIndex;
    }
    
    public void setSelectedSlotIndex(final int lllllllllllIlIIllIlIllIlIllIllIl) {
        this.selectedSlotIndex = lllllllllllIlIIllIlIllIlIllIllIl;
    }
    
    @Override
    public int getListWidth() {
        return super.getListWidth() + 85;
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 30;
    }
    
    @Override
    public IGuiListEntry getListEntry(int lllllllllllIlIIllIlIllIlIlllIllI) {
        if (lllllllllllIlIIllIlIllIlIlllIllI < this.serverListInternet.size()) {
            return this.serverListInternet.get(lllllllllllIlIIllIlIllIlIlllIllI);
        }
        lllllllllllIlIIllIlIllIlIlllIllI -= this.serverListInternet.size();
        if (lllllllllllIlIIllIlIllIlIlllIllI == 0) {
            return this.lanScanEntry;
        }
        --lllllllllllIlIIllIlIllIlIlllIllI;
        return this.serverListLan.get(lllllllllllIlIIllIlIllIlIlllIllI);
    }
    
    public ServerSelectionList(final GuiMultiplayer lllllllllllIlIIllIlIllIllIIIIIII, final Minecraft lllllllllllIlIIllIlIllIlIlllllll, final int lllllllllllIlIIllIlIllIlIllllllI, final int lllllllllllIlIIllIlIllIlIlllllIl, final int lllllllllllIlIIllIlIllIllIIIIlII, final int lllllllllllIlIIllIlIllIlIllllIll, final int lllllllllllIlIIllIlIllIlIllllIlI) {
        super(lllllllllllIlIIllIlIllIlIlllllll, lllllllllllIlIIllIlIllIlIllllllI, lllllllllllIlIIllIlIllIlIlllllIl, lllllllllllIlIIllIlIllIllIIIIlII, lllllllllllIlIIllIlIllIlIllllIll, lllllllllllIlIIllIlIllIlIllllIlI);
        this.serverListInternet = (List<ServerListEntryNormal>)Lists.newArrayList();
        this.serverListLan = (List<ServerListEntryLanDetected>)Lists.newArrayList();
        this.lanScanEntry = new ServerListEntryLanScan();
        this.selectedSlotIndex = -1;
        this.owner = lllllllllllIlIIllIlIllIllIIIIIII;
    }
    
    @Override
    protected int getSize() {
        return this.serverListInternet.size() + 1 + this.serverListLan.size();
    }
    
    public void updateNetworkServers(final List<LanServerInfo> lllllllllllIlIIllIlIllIlIlIlIIll) {
        this.serverListLan.clear();
        for (final LanServerInfo lllllllllllIlIIllIlIllIlIlIlIIlI : lllllllllllIlIIllIlIllIlIlIlIIll) {
            this.serverListLan.add(new ServerListEntryLanDetected(this.owner, lllllllllllIlIIllIlIllIlIlIlIIlI));
        }
    }
}
