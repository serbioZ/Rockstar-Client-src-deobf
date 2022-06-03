// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.LanServerInfo;

public class ServerListEntryLanDetected implements GuiListExtended.IGuiListEntry
{
    protected final /* synthetic */ LanServerInfo serverData;
    protected final /* synthetic */ Minecraft mc;
    private final /* synthetic */ GuiMultiplayer screen;
    private /* synthetic */ long lastClickTime;
    
    public LanServerInfo getServerData() {
        return this.serverData;
    }
    
    @Override
    public void func_192633_a(final int lllllllllllIIllIlIIIlIllIlIlIIII, final int lllllllllllIIllIlIIIlIllIlIIllll, final int lllllllllllIIllIlIIIlIllIlIIlllI, final float lllllllllllIIllIlIIIlIllIlIIllIl) {
    }
    
    protected ServerListEntryLanDetected(final GuiMultiplayer lllllllllllIIllIlIIIlIllIlllIIIl, final LanServerInfo lllllllllllIIllIlIIIlIllIlllIIII) {
        this.screen = lllllllllllIIllIlIIIlIllIlllIIIl;
        this.serverData = lllllllllllIIllIlIIIlIllIlllIIII;
        this.mc = Minecraft.getMinecraft();
    }
    
    @Override
    public boolean mousePressed(final int lllllllllllIIllIlIIIlIllIlIlIIlI, final int lllllllllllIIllIlIIIlIllIlIllIII, final int lllllllllllIIllIlIIIlIllIlIlIlll, final int lllllllllllIIllIlIIIlIllIlIlIllI, final int lllllllllllIIllIlIIIlIllIlIlIlIl, final int lllllllllllIIllIlIIIlIllIlIlIlII) {
        this.screen.selectServer(lllllllllllIIllIlIIIlIllIlIlIIlI);
        if (Minecraft.getSystemTime() - this.lastClickTime < 250L) {
            this.screen.connectToSelected();
        }
        this.lastClickTime = Minecraft.getSystemTime();
        return false;
    }
    
    @Override
    public void func_192634_a(final int lllllllllllIIllIlIIIlIllIllIlIII, final int lllllllllllIIllIlIIIlIllIlIllllI, final int lllllllllllIIllIlIIIlIllIllIIllI, final int lllllllllllIIllIlIIIlIllIllIIlIl, final int lllllllllllIIllIlIIIlIllIllIIlII, final int lllllllllllIIllIlIIIlIllIllIIIll, final int lllllllllllIIllIlIIIlIllIllIIIlI, final boolean lllllllllllIIllIlIIIlIllIllIIIIl, final float lllllllllllIIllIlIIIlIllIllIIIII) {
        Minecraft.fontRendererObj.drawString(I18n.format("lanServer.title", new Object[0]), (float)(lllllllllllIIllIlIIIlIllIlIllllI + 32 + 3), (float)(lllllllllllIIllIlIIIlIllIllIIllI + 1), 16777215);
        Minecraft.fontRendererObj.drawString(this.serverData.getServerMotd(), (float)(lllllllllllIIllIlIIIlIllIlIllllI + 32 + 3), (float)(lllllllllllIIllIlIIIlIllIllIIllI + 12), 8421504);
        if (this.mc.gameSettings.hideServerAddress) {
            Minecraft.fontRendererObj.drawString(I18n.format("selectServer.hiddenAddress", new Object[0]), (float)(lllllllllllIIllIlIIIlIllIlIllllI + 32 + 3), (float)(lllllllllllIIllIlIIIlIllIllIIllI + 12 + 11), 3158064);
        }
        else {
            Minecraft.fontRendererObj.drawString(this.serverData.getServerIpPort(), (float)(lllllllllllIIllIlIIIlIllIlIllllI + 32 + 3), (float)(lllllllllllIIllIlIIIlIllIllIIllI + 12 + 11), 3158064);
        }
    }
    
    @Override
    public void mouseReleased(final int lllllllllllIIllIlIIIlIllIlIIlIll, final int lllllllllllIIllIlIIIlIllIlIIlIlI, final int lllllllllllIIllIlIIIlIllIlIIlIIl, final int lllllllllllIIllIlIIIlIllIlIIlIII, final int lllllllllllIIllIlIIIlIllIlIIIlll, final int lllllllllllIIllIlIIIlIllIlIIIllI) {
    }
}
