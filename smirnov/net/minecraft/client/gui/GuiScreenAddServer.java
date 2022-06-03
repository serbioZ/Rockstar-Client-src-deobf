// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import org.lwjgl.input.Keyboard;
import java.net.IDN;
import net.minecraft.util.StringUtils;
import javax.annotation.Nullable;
import java.io.IOException;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.multiplayer.ServerData;
import com.google.common.base.Predicate;

public class GuiScreenAddServer extends GuiScreen
{
    private /* synthetic */ GuiButton serverResourcePacks;
    private /* synthetic */ GuiTextField serverNameField;
    private final /* synthetic */ Predicate<String> addressFilter;
    private final /* synthetic */ ServerData serverData;
    private final /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ GuiTextField serverIPField;
    
    @Override
    public void drawScreen(final int lllllllllllIlIIlIlllIIIllIIlIlll, final int lllllllllllIlIIlIlllIIIllIIlIllI, final float lllllllllllIlIIlIlllIIIllIIlIIIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("addServer.title", new Object[0]), this.width / 2, 17, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("addServer.enterName", new Object[0]), this.width / 2 - 100, 53, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("addServer.enterIp", new Object[0]), this.width / 2 - 100, 94, 10526880);
        this.serverNameField.drawTextBox();
        this.serverIPField.drawTextBox();
        super.drawScreen(lllllllllllIlIIlIlllIIIllIIlIlll, lllllllllllIlIIlIlllIIIllIIlIllI, lllllllllllIlIIlIlllIIIllIIlIIIl);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlIIlIlllIIIllIllIlII) throws IOException {
        if (lllllllllllIlIIlIlllIIIllIllIlII.enabled) {
            if (lllllllllllIlIIlIlllIIIllIllIlII.id == 2) {
                this.serverData.setResourceMode(ServerData.ServerResourceMode.values()[(this.serverData.getResourceMode().ordinal() + 1) % ServerData.ServerResourceMode.values().length]);
                this.serverResourcePacks.displayString = String.valueOf(I18n.format("addServer.resourcePack", new Object[0])) + ": " + this.serverData.getResourceMode().getMotd().getFormattedText();
            }
            else if (lllllllllllIlIIlIlllIIIllIllIlII.id == 1) {
                this.parentScreen.confirmClicked(false, 0);
            }
            else if (lllllllllllIlIIlIlllIIIllIllIlII.id == 0) {
                this.serverData.serverName = this.serverNameField.getText();
                this.serverData.serverIP = this.serverIPField.getText();
                this.parentScreen.confirmClicked(true, 0);
            }
        }
    }
    
    public GuiScreenAddServer(final GuiScreen lllllllllllIlIIlIlllIIIlllIIIIII, final ServerData lllllllllllIlIIlIlllIIIlllIIIIlI) {
        this.addressFilter = (Predicate<String>)new Predicate<String>() {
            public boolean apply(@Nullable final String lllllllllllllIlIlIllIIllIllllIlI) {
                if (StringUtils.isNullOrEmpty(lllllllllllllIlIlIllIIllIllllIlI)) {
                    return true;
                }
                final String[] lllllllllllllIlIlIllIIllIlllllIl = lllllllllllllIlIlIllIIllIllllIlI.split(":");
                if (lllllllllllllIlIlIllIIllIlllllIl.length == 0) {
                    return true;
                }
                try {
                    final String lllllllllllllIlIlIllIIllIlllllII = IDN.toASCII(lllllllllllllIlIlIllIIllIlllllIl[0]);
                    return true;
                }
                catch (IllegalArgumentException lllllllllllllIlIlIllIIllIllllIll) {
                    return false;
                }
            }
        };
        this.parentScreen = lllllllllllIlIIlIlllIIIlllIIIIII;
        this.serverData = lllllllllllIlIIlIlllIIIlllIIIIlI;
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlIIlIlllIIIllIlIllIl, final int lllllllllllIlIIlIlllIIIllIlIlIIl) throws IOException {
        this.serverNameField.textboxKeyTyped(lllllllllllIlIIlIlllIIIllIlIllIl, lllllllllllIlIIlIlllIIIllIlIlIIl);
        this.serverIPField.textboxKeyTyped(lllllllllllIlIIlIlllIIIllIlIllIl, lllllllllllIlIIlIlllIIIllIlIlIIl);
        if (lllllllllllIlIIlIlllIIIllIlIlIIl == 15) {
            this.serverNameField.setFocused(!this.serverNameField.isFocused());
            this.serverIPField.setFocused(!this.serverIPField.isFocused());
        }
        if (lllllllllllIlIIlIlllIIIllIlIlIIl == 28 || lllllllllllIlIIlIlllIIIllIlIlIIl == 156) {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.buttonList.get(0).enabled = (!this.serverIPField.getText().isEmpty() && this.serverIPField.getText().split(":").length > 0 && !this.serverNameField.getText().isEmpty());
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 18, I18n.format("addServer.add", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 18, I18n.format("gui.cancel", new Object[0])));
        this.serverResourcePacks = this.addButton(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 72, String.valueOf(I18n.format("addServer.resourcePack", new Object[0])) + ": " + this.serverData.getResourceMode().getMotd().getFormattedText()));
        this.serverNameField = new GuiTextField(0, this.fontRendererObj, this.width / 2 - 100, 66, 200, 20);
        this.serverNameField.setFocused(true);
        this.serverNameField.setText(this.serverData.serverName);
        this.serverIPField = new GuiTextField(1, this.fontRendererObj, this.width / 2 - 100, 106, 200, 20);
        this.serverIPField.setMaxStringLength(128);
        this.serverIPField.setText(this.serverData.serverIP);
        this.serverIPField.setValidator(this.addressFilter);
        this.buttonList.get(0).enabled = (!this.serverIPField.getText().isEmpty() && this.serverIPField.getText().split(":").length > 0 && !this.serverNameField.getText().isEmpty());
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlIIlIlllIIIllIIlllll, final int lllllllllllIlIIlIlllIIIllIlIIIlI, final int lllllllllllIlIIlIlllIIIllIIlllIl) throws IOException {
        super.mouseClicked(lllllllllllIlIIlIlllIIIllIIlllll, lllllllllllIlIIlIlllIIIllIlIIIlI, lllllllllllIlIIlIlllIIIllIIlllIl);
        this.serverIPField.mouseClicked(lllllllllllIlIIlIlllIIIllIIlllll, lllllllllllIlIIlIlllIIIllIlIIIlI, lllllllllllIlIIlIlllIIIllIIlllIl);
        this.serverNameField.mouseClicked(lllllllllllIlIIlIlllIIIllIIlllll, lllllllllllIlIIlIlllIIIllIlIIIlI, lllllllllllIlIIlIlllIIIllIIlllIl);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void updateScreen() {
        this.serverNameField.updateCursorCounter();
        this.serverIPField.updateCursorCounter();
    }
}
