// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;

public class GuiDownloadTerrain extends GuiScreen
{
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlIIIIlIllIIIIlIlII, final int lllllllllllllIlIIIIlIllIIIIlIlll, final float lllllllllllllIlIIIIlIllIIIIlIllI) {
        this.drawBackground(0);
        this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingTerrain", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        super.drawScreen(lllllllllllllIlIIIIlIllIIIIlIlII, lllllllllllllIlIIIIlIllIIIIlIlll, lllllllllllllIlIIIIlIllIIIIlIllI);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
    }
}
