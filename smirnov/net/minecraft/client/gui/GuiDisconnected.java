// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.ITextComponent;
import java.util.List;

public class GuiDisconnected extends GuiScreen
{
    private final /* synthetic */ String reason;
    private /* synthetic */ int textHeight;
    private /* synthetic */ List<String> multilineMessage;
    private final /* synthetic */ GuiScreen parentScreen;
    private final /* synthetic */ ITextComponent message;
    
    @Override
    public void drawScreen(final int llllllllllllIllllIlIIIllllIIlllI, final int llllllllllllIllllIlIIIllllIlIIll, final float llllllllllllIllllIlIIIllllIIllII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.reason, this.width / 2, this.height / 2 - this.textHeight / 2 - this.fontRendererObj.FONT_HEIGHT * 2, 11184810);
        int llllllllllllIllllIlIIIllllIlIIIl = this.height / 2 - this.textHeight / 2;
        if (this.multilineMessage != null) {
            for (final String llllllllllllIllllIlIIIllllIlIIII : this.multilineMessage) {
                this.drawCenteredString(this.fontRendererObj, llllllllllllIllllIlIIIllllIlIIII, this.width / 2, llllllllllllIllllIlIIIllllIlIIIl, 16777215);
                llllllllllllIllllIlIIIllllIlIIIl += this.fontRendererObj.FONT_HEIGHT;
            }
        }
        super.drawScreen(llllllllllllIllllIlIIIllllIIlllI, llllllllllllIllllIlIIIllllIlIIll, llllllllllllIllllIlIIIllllIIllII);
    }
    
    public GuiDisconnected(final GuiScreen llllllllllllIllllIlIIIlllllIllll, final String llllllllllllIllllIlIIIlllllIlIlI, final ITextComponent llllllllllllIllllIlIIIlllllIlIIl) {
        this.parentScreen = llllllllllllIllllIlIIIlllllIllll;
        this.reason = I18n.format(llllllllllllIllllIlIIIlllllIlIlI, new Object[0]);
        this.message = llllllllllllIllllIlIIIlllllIlIIl;
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIllllIlIIIlllllIIlll, final int llllllllllllIllllIlIIIlllllIIllI) throws IOException {
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIllllIlIIIllllIlllIl) throws IOException {
        if (llllllllllllIllllIlIIIllllIlllIl.id == 0) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.multilineMessage = this.fontRendererObj.listFormattedStringToWidth(this.message.getFormattedText(), this.width - 50);
        this.textHeight = this.multilineMessage.size() * this.fontRendererObj.FONT_HEIGHT;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, Math.min(this.height / 2 + this.textHeight / 2 + this.fontRendererObj.FONT_HEIGHT, this.height - 30), I18n.format("gui.toMenu", new Object[0])));
    }
}
