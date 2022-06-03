// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import java.io.IOException;

public class GuiErrorScreen extends GuiScreen
{
    private final /* synthetic */ String message;
    private final /* synthetic */ String title;
    
    public GuiErrorScreen(final String llllllllllllIIlIlIIlIIIlIlllllIl, final String llllllllllllIIlIlIIlIIIlIllllIIl) {
        this.title = llllllllllllIIlIlIIlIIIlIlllllIl;
        this.message = llllllllllllIIlIlIIlIIIlIllllIIl;
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIIlIlIIlIIIlIllIlIII, final int llllllllllllIIlIlIIlIIIlIllIIlll) throws IOException {
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, 140, I18n.format("gui.cancel", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIIlIlIIlIIIlIllIIlII) throws IOException {
        this.mc.displayGuiScreen(null);
    }
    
    @Override
    public void drawScreen(final int llllllllllllIIlIlIIlIIIlIlllIIII, final int llllllllllllIIlIlIIlIIIlIllIllll, final float llllllllllllIIlIlIIlIIIlIllIlllI) {
        this.drawGradientRect(0, 0, this.width, this.height, -12574688, -11530224);
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 90, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.message, this.width / 2, 110, 16777215);
        super.drawScreen(llllllllllllIIlIlIIlIIIlIlllIIII, llllllllllllIIlIlIIlIIIlIllIllll, llllllllllllIIlIlIIlIIIlIllIlllI);
    }
}
