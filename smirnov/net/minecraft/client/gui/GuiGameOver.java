// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import java.io.IOException;
import net.minecraft.client.resources.I18n;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;

public class GuiGameOver extends GuiScreen
{
    private /* synthetic */ int enableButtonsTimer;
    private final /* synthetic */ ITextComponent causeOfDeath;
    
    public GuiGameOver(@Nullable final ITextComponent lllllllllllIIIlIIIIlIIlIllIIIIlI) {
        this.causeOfDeath = lllllllllllIIIlIIIIlIIlIllIIIIlI;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIIlIIIIlIIlIlIlIllll) throws IOException {
        switch (lllllllllllIIIlIIIIlIIlIlIlIllll.id) {
            case 0: {
                this.mc.player.respawnPlayer();
                this.mc.displayGuiScreen(null);
                break;
            }
            case 1: {
                if (this.mc.world.getWorldInfo().isHardcoreModeEnabled()) {
                    this.mc.displayGuiScreen(new GuiMainMenu());
                    break;
                }
                final GuiYesNo lllllllllllIIIlIIIIlIIlIlIllIIIl = new GuiYesNo(this, I18n.format("deathScreen.quit.confirm", new Object[0]), "", I18n.format("deathScreen.titleScreen", new Object[0]), I18n.format("deathScreen.respawn", new Object[0]), 0);
                this.mc.displayGuiScreen(lllllllllllIIIlIIIIlIIlIlIllIIIl);
                lllllllllllIIIlIIIIlIIlIlIllIIIl.setButtonDelay(20);
                break;
            }
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Nullable
    public ITextComponent getClickedComponentAt(final int lllllllllllIIIlIIIIlIIlIlIIIIlII) {
        if (this.causeOfDeath == null) {
            return null;
        }
        final int lllllllllllIIIlIIIIlIIlIlIIIlIlI = Minecraft.fontRendererObj.getStringWidth(this.causeOfDeath.getFormattedText());
        final int lllllllllllIIIlIIIIlIIlIlIIIlIIl = this.width / 2 - lllllllllllIIIlIIIIlIIlIlIIIlIlI / 2;
        final int lllllllllllIIIlIIIIlIIlIlIIIlIII = this.width / 2 + lllllllllllIIIlIIIIlIIlIlIIIlIlI / 2;
        int lllllllllllIIIlIIIIlIIlIlIIIIlll = lllllllllllIIIlIIIIlIIlIlIIIlIIl;
        if (lllllllllllIIIlIIIIlIIlIlIIIIlII >= lllllllllllIIIlIIIIlIIlIlIIIlIIl && lllllllllllIIIlIIIIlIIlIlIIIIlII <= lllllllllllIIIlIIIIlIIlIlIIIlIII) {
            for (final ITextComponent lllllllllllIIIlIIIIlIIlIlIIIIllI : this.causeOfDeath) {
                lllllllllllIIIlIIIIlIIlIlIIIIlll += Minecraft.fontRendererObj.getStringWidth(GuiUtilRenderComponents.removeTextColorsIfConfigured(lllllllllllIIIlIIIIlIIlIlIIIIllI.getUnformattedComponentText(), false));
                if (lllllllllllIIIlIIIIlIIlIlIIIIlll > lllllllllllIIIlIIIIlIIlIlIIIIlII) {
                    return lllllllllllIIIlIIIIlIIlIlIIIIllI;
                }
            }
            return null;
        }
        return null;
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.enableButtonsTimer;
        if (this.enableButtonsTimer == 20) {
            for (final GuiButton lllllllllllIIIlIIIIlIIlIIllllIII : this.buttonList) {
                lllllllllllIIIlIIIIlIIlIIllllIII.enabled = true;
            }
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.enableButtonsTimer = 0;
        if (this.mc.world.getWorldInfo().isHardcoreModeEnabled()) {
            this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 72, I18n.format("deathScreen.spectate", new Object[0])));
            this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, I18n.format("deathScreen." + (this.mc.isIntegratedServerRunning() ? "deleteWorld" : "leaveServer"), new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 72, I18n.format("deathScreen.respawn", new Object[0])));
            this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, I18n.format("deathScreen.titleScreen", new Object[0])));
            if (this.mc.getSession() == null) {
                this.buttonList.get(1).enabled = false;
            }
        }
        for (final GuiButton lllllllllllIIIlIIIIlIIlIlIllllIl : this.buttonList) {
            lllllllllllIIIlIIIIlIIlIlIllllIl.enabled = false;
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIIlIIIIlIIlIlIIllIIl, final int lllllllllllIIIlIIIIlIIlIlIIllIII, final float lllllllllllIIIlIIIIlIIlIlIIlIlll) {
        final boolean lllllllllllIIIlIIIIlIIlIlIIlllII = this.mc.world.getWorldInfo().isHardcoreModeEnabled();
        this.drawGradientRect(0, 0, this.width, this.height, 1615855616, -1602211792);
        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        this.drawCenteredString(this.fontRendererObj, I18n.format(lllllllllllIIIlIIIIlIIlIlIIlllII ? "deathScreen.title.hardcore" : "deathScreen.title", new Object[0]), this.width / 2 / 2, 30, 16777215);
        GlStateManager.popMatrix();
        if (this.causeOfDeath != null) {
            this.drawCenteredString(this.fontRendererObj, this.causeOfDeath.getFormattedText(), this.width / 2, 85, 16777215);
        }
        this.drawCenteredString(this.fontRendererObj, String.valueOf(I18n.format("deathScreen.score", new Object[0])) + ": " + TextFormatting.YELLOW + this.mc.player.getScore(), this.width / 2, 100, 16777215);
        if (this.causeOfDeath != null && lllllllllllIIIlIIIIlIIlIlIIllIII > 85 && lllllllllllIIIlIIIIlIIlIlIIllIII < 85 + this.fontRendererObj.FONT_HEIGHT) {
            final ITextComponent lllllllllllIIIlIIIIlIIlIlIIllIll = this.getClickedComponentAt(lllllllllllIIIlIIIIlIIlIlIIllIIl);
            if (lllllllllllIIIlIIIIlIIlIlIIllIll != null && lllllllllllIIIlIIIIlIIlIlIIllIll.getStyle().getHoverEvent() != null) {
                this.handleComponentHover(lllllllllllIIIlIIIIlIIlIlIIllIll, lllllllllllIIIlIIIIlIIlIlIIllIIl, lllllllllllIIIlIIIIlIIlIlIIllIII);
            }
        }
        super.drawScreen(lllllllllllIIIlIIIIlIIlIlIIllIIl, lllllllllllIIIlIIIIlIIlIlIIllIII, lllllllllllIIIlIIIIlIIlIlIIlIlll);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIIlIIIIlIIlIlIlllIII, final int lllllllllllIIIlIIIIlIIlIlIllIlll) throws IOException {
    }
    
    @Override
    public void confirmClicked(final boolean lllllllllllIIIlIIIIlIIlIlIlIIlll, final int lllllllllllIIIlIIIIlIIlIlIlIlIIl) {
        if (lllllllllllIIIlIIIIlIIlIlIlIIlll) {
            if (this.mc.world != null) {
                this.mc.world.sendQuittingDisconnectingPacket();
            }
            this.mc.loadWorld(null);
            this.mc.displayGuiScreen(new GuiMainMenu());
        }
        else {
            this.mc.player.respawnPlayer();
            this.mc.displayGuiScreen(null);
        }
    }
}
