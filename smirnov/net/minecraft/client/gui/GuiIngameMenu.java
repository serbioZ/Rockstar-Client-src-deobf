// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import java.io.IOException;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.advancements.GuiScreenAdvancements;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.client.multiplayer.WorldClient;

public class GuiIngameMenu extends GuiScreen
{
    private /* synthetic */ int visibleTime;
    private /* synthetic */ int saveStep;
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIIlIIllIlIIlIIIIllll) throws IOException {
        switch (lllllllllllIIIlIIllIlIIlIIIIllll.id) {
            case 0: {
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;
            }
            case 1: {
                final boolean lllllllllllIIIlIIllIlIIlIIIIlllI = this.mc.isIntegratedServerRunning();
                final boolean lllllllllllIIIlIIllIlIIlIIIIllIl = this.mc.isConnectedToRealms();
                lllllllllllIIIlIIllIlIIlIIIIllll.enabled = false;
                this.mc.world.sendQuittingDisconnectingPacket();
                this.mc.loadWorld(null);
                if (lllllllllllIIIlIIllIlIIlIIIIlllI) {
                    this.mc.displayGuiScreen(new GuiMainMenu());
                    break;
                }
                if (lllllllllllIIIlIIllIlIIlIIIIllIl) {
                    final RealmsBridge lllllllllllIIIlIIllIlIIlIIIIllII = new RealmsBridge();
                    lllllllllllIIIlIIllIlIIlIIIIllII.switchToRealms(new GuiMainMenu());
                    break;
                }
                this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
                break;
            }
            case 4: {
                this.mc.displayGuiScreen(null);
                this.mc.setIngameFocus();
                break;
            }
            case 5: {
                this.mc.displayGuiScreen(new GuiScreenAdvancements(this.mc.player.connection.func_191982_f()));
                break;
            }
            case 6: {
                this.mc.displayGuiScreen(new GuiStats(this, this.mc.player.getStatFileWriter()));
                break;
            }
            case 7: {
                this.mc.displayGuiScreen(new GuiShareToLan(this));
                break;
            }
        }
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.visibleTime;
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIIlIIllIlIIIlllllIlI, final int lllllllllllIIIlIIllIlIIIlllllIIl, final float lllllllllllIIIlIIllIlIIIlllllIII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("menu.game", new Object[0]), this.width / 2, 40, 16777215);
        super.drawScreen(lllllllllllIIIlIIllIlIIIlllllIlI, lllllllllllIIIlIIllIlIIIlllllIIl, lllllllllllIIIlIIllIlIIIlllllIII);
    }
    
    @Override
    public void initGui() {
        this.saveStep = 0;
        this.buttonList.clear();
        final int lllllllllllIIIlIIllIlIIlIIIlllII = -16;
        final int lllllllllllIIIlIIllIlIIlIIIllIll = 98;
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 - 16, I18n.format("menu.returnToMenu", new Object[0])));
        if (!this.mc.isIntegratedServerRunning()) {
            this.buttonList.get(0).displayString = I18n.format("menu.disconnect", new Object[0]);
        }
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 24 - 16, I18n.format("menu.returnToGame", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 - 16, 98, 20, I18n.format("menu.options", new Object[0])));
        final GuiButton lllllllllllIIIlIIllIlIIlIIIllIlI = this.addButton(new GuiButton(7, this.width / 2 + 2, this.height / 4 + 96 - 16, 98, 20, I18n.format("menu.shareToLan", new Object[0])));
        lllllllllllIIIlIIllIlIIlIIIllIlI.enabled = (this.mc.isSingleplayer() && !this.mc.getIntegratedServer().getPublic());
        this.buttonList.add(new GuiButton(5, this.width / 2 - 100, this.height / 4 + 48 - 16, 98, 20, I18n.format("gui.advancements", new Object[0])));
        this.buttonList.add(new GuiButton(6, this.width / 2 + 2, this.height / 4 + 48 - 16, 98, 20, I18n.format("gui.stats", new Object[0])));
    }
}
