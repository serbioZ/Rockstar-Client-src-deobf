// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.resources.I18n;

public class GuiConfirmOpenLink extends GuiYesNo
{
    private /* synthetic */ boolean showSecurityWarning;
    private final /* synthetic */ String openLinkWarning;
    private final /* synthetic */ String copyLinkButtonText;
    private final /* synthetic */ String linkText;
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50 - 105, this.height / 6 + 96, 100, 20, this.confirmButtonText));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 50, this.height / 6 + 96, 100, 20, this.copyLinkButtonText));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50 + 105, this.height / 6 + 96, 100, 20, this.cancelButtonText));
    }
    
    @Override
    public void drawScreen(final int llllllllllllIIIIlIlIIlllllIIIlIl, final int llllllllllllIIIIlIlIIlllllIIIlII, final float llllllllllllIIIIlIlIIllllIllllll) {
        super.drawScreen(llllllllllllIIIIlIlIIlllllIIIlIl, llllllllllllIIIIlIlIIlllllIIIlII, llllllllllllIIIIlIlIIllllIllllll);
        if (this.showSecurityWarning) {
            this.drawCenteredString(this.fontRendererObj, this.openLinkWarning, this.width / 2, 110, 16764108);
        }
    }
    
    public GuiConfirmOpenLink(final GuiYesNoCallback llllllllllllIIIIlIlIIlllllIllIlI, final String llllllllllllIIIIlIlIIlllllIllllI, final int llllllllllllIIIIlIlIIlllllIlllIl, final boolean llllllllllllIIIIlIlIIlllllIlIlll) {
        super(llllllllllllIIIIlIlIIlllllIllIlI, I18n.format(llllllllllllIIIIlIlIIlllllIlIlll ? "chat.link.confirmTrusted" : "chat.link.confirm", new Object[0]), llllllllllllIIIIlIlIIlllllIllllI, llllllllllllIIIIlIlIIlllllIlllIl);
        this.showSecurityWarning = true;
        this.confirmButtonText = I18n.format(llllllllllllIIIIlIlIIlllllIlIlll ? "chat.link.open" : "gui.yes", new Object[0]);
        this.cancelButtonText = I18n.format(llllllllllllIIIIlIlIIlllllIlIlll ? "gui.cancel" : "gui.no", new Object[0]);
        this.copyLinkButtonText = I18n.format("chat.copy", new Object[0]);
        this.openLinkWarning = I18n.format("chat.link.warning", new Object[0]);
        this.linkText = llllllllllllIIIIlIlIIlllllIllllI;
    }
    
    public void copyLinkToClipboard() {
        GuiScreen.setClipboardString(this.linkText);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIIIIlIlIIlllllIIlllI) throws IOException {
        if (llllllllllllIIIIlIlIIlllllIIlllI.id == 2) {
            this.copyLinkToClipboard();
        }
        this.parentScreen.confirmClicked(llllllllllllIIIIlIlIIlllllIIlllI.id == 0, this.parentButtonClickedId);
    }
    
    public void disableSecurityWarning() {
        this.showSecurityWarning = false;
    }
}
