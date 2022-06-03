// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import org.lwjgl.input.Keyboard;
import java.io.IOException;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.multiplayer.ServerData;

public class GuiScreenServerList extends GuiScreen
{
    private /* synthetic */ GuiTextField ipEdit;
    private final /* synthetic */ ServerData serverData;
    private final /* synthetic */ GuiScreen lastScreen;
    
    @Override
    public void drawScreen(final int lllllllllllllllIIlIIllllllIIlIlI, final int lllllllllllllllIIlIIllllllIIIlIl, final float lllllllllllllllIIlIIllllllIIIlII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("selectServer.direct", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("addServer.enterIp", new Object[0]), this.width / 2 - 100, 100, 10526880);
        this.ipEdit.drawTextBox();
        super.drawScreen(lllllllllllllllIIlIIllllllIIlIlI, lllllllllllllllIIlIIllllllIIIlIl, lllllllllllllllIIlIIllllllIIIlII);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIlIIlllllllIIlIl) throws IOException {
        if (lllllllllllllllIIlIIlllllllIIlIl.enabled) {
            if (lllllllllllllllIIlIIlllllllIIlIl.id == 1) {
                this.lastScreen.confirmClicked(false, 0);
            }
            else if (lllllllllllllllIIlIIlllllllIIlIl.id == 0) {
                this.serverData.serverIP = this.ipEdit.getText();
                this.lastScreen.confirmClicked(true, 0);
            }
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllllIIlIIllllllIlllIl, final int lllllllllllllllIIlIIllllllIlllll) throws IOException {
        if (this.ipEdit.textboxKeyTyped(lllllllllllllllIIlIIllllllIlllIl, lllllllllllllllIIlIIllllllIlllll)) {
            this.buttonList.get(0).enabled = (!this.ipEdit.getText().isEmpty() && this.ipEdit.getText().split(":").length > 0);
        }
        else if (lllllllllllllllIIlIIllllllIlllll == 28 || lllllllllllllllIIlIIllllllIlllll == 156) {
            this.actionPerformed(this.buttonList.get(0));
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.mc.gameSettings.lastServer = this.ipEdit.getText();
        this.mc.gameSettings.saveOptions();
    }
    
    @Override
    public void updateScreen() {
        this.ipEdit.updateCursorCounter();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllIIlIIllllllIlIllI, final int lllllllllllllllIIlIIllllllIlIlIl, final int lllllllllllllllIIlIIllllllIlIlII) throws IOException {
        super.mouseClicked(lllllllllllllllIIlIIllllllIlIllI, lllllllllllllllIIlIIllllllIlIlIl, lllllllllllllllIIlIIllllllIlIlII);
        this.ipEdit.mouseClicked(lllllllllllllllIIlIIllllllIlIllI, lllllllllllllllIIlIIllllllIlIlIl, lllllllllllllllIIlIIllllllIlIlII);
    }
    
    public GuiScreenServerList(final GuiScreen lllllllllllllllIIlIIlllllllllIII, final ServerData lllllllllllllllIIlIIllllllllIlll) {
        this.lastScreen = lllllllllllllllIIlIIlllllllllIII;
        this.serverData = lllllllllllllllIIlIIllllllllIlll;
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, I18n.format("selectServer.select", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
        this.ipEdit = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 116, 200, 20);
        this.ipEdit.setMaxStringLength(128);
        this.ipEdit.setFocused(true);
        this.ipEdit.setText(this.mc.gameSettings.lastServer);
        this.buttonList.get(0).enabled = (!this.ipEdit.getText().isEmpty() && this.ipEdit.getText().split(":").length > 0);
    }
}
