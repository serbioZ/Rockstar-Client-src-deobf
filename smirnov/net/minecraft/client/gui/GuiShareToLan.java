// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import java.io.IOException;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.GameType;

public class GuiShareToLan extends GuiScreen
{
    private /* synthetic */ boolean allowCheats;
    private /* synthetic */ String gameMode;
    private final /* synthetic */ GuiScreen lastScreen;
    private /* synthetic */ GuiButton allowCheatsButton;
    private /* synthetic */ GuiButton gameModeButton;
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIllIIlIllIIllIllll) throws IOException {
        if (llllllllllllllIllIIlIllIIllIllll.id == 102) {
            this.mc.displayGuiScreen(this.lastScreen);
        }
        else if (llllllllllllllIllIIlIllIIllIllll.id == 104) {
            if ("spectator".equals(this.gameMode)) {
                this.gameMode = "creative";
            }
            else if ("creative".equals(this.gameMode)) {
                this.gameMode = "adventure";
            }
            else if ("adventure".equals(this.gameMode)) {
                this.gameMode = "survival";
            }
            else {
                this.gameMode = "spectator";
            }
            this.updateDisplayNames();
        }
        else if (llllllllllllllIllIIlIllIIllIllll.id == 103) {
            this.allowCheats = !this.allowCheats;
            this.updateDisplayNames();
        }
        else if (llllllllllllllIllIIlIllIIllIllll.id == 101) {
            this.mc.displayGuiScreen(null);
            final String llllllllllllllIllIIlIllIIlllIIll = this.mc.getIntegratedServer().shareToLAN(GameType.getByName(this.gameMode), this.allowCheats);
            ITextComponent llllllllllllllIllIIlIllIIlllIIIl = null;
            if (llllllllllllllIllIIlIllIIlllIIll != null) {
                final ITextComponent llllllllllllllIllIIlIllIIlllIIlI = new TextComponentTranslation("commands.publish.started", new Object[] { llllllllllllllIllIIlIllIIlllIIll });
            }
            else {
                llllllllllllllIllIIlIllIIlllIIIl = new TextComponentString("commands.publish.failed");
            }
            this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllllIllIIlIllIIlllIIIl);
        }
    }
    
    private void updateDisplayNames() {
        this.gameModeButton.displayString = String.valueOf(I18n.format("selectWorld.gameMode", new Object[0])) + ": " + I18n.format("selectWorld.gameMode." + this.gameMode, new Object[0]);
        this.allowCheatsButton.displayString = String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0])) + " ";
        if (this.allowCheats) {
            this.allowCheatsButton.displayString = String.valueOf(this.allowCheatsButton.displayString) + I18n.format("options.on", new Object[0]);
        }
        else {
            this.allowCheatsButton.displayString = String.valueOf(this.allowCheatsButton.displayString) + I18n.format("options.off", new Object[0]);
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIllIIlIllIIllIIlll, final int llllllllllllllIllIIlIllIIllIIIlI, final float llllllllllllllIllIIlIllIIllIIIIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("lanServer.title", new Object[0]), this.width / 2, 50, 16777215);
        this.drawCenteredString(this.fontRendererObj, I18n.format("lanServer.otherPlayers", new Object[0]), this.width / 2, 82, 16777215);
        super.drawScreen(llllllllllllllIllIIlIllIIllIIlll, llllllllllllllIllIIlIllIIllIIIlI, llllllllllllllIllIIlIllIIllIIIIl);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(101, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("lanServer.start", new Object[0])));
        this.buttonList.add(new GuiButton(102, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.gameModeButton = this.addButton(new GuiButton(104, this.width / 2 - 155, 100, 150, 20, I18n.format("selectWorld.gameMode", new Object[0])));
        this.allowCheatsButton = this.addButton(new GuiButton(103, this.width / 2 + 5, 100, 150, 20, I18n.format("selectWorld.allowCommands", new Object[0])));
        this.updateDisplayNames();
    }
    
    public GuiShareToLan(final GuiScreen llllllllllllllIllIIlIllIlIIIIIlI) {
        this.gameMode = "survival";
        this.lastScreen = llllllllllllllIllIIlIllIlIIIIIlI;
    }
}
