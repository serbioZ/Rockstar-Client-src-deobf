// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import java.util.List;
import net.minecraft.util.text.ITextComponent;

public class DisconnectedRealmsScreen extends RealmsScreen
{
    private final /* synthetic */ String title;
    private final /* synthetic */ ITextComponent reason;
    private /* synthetic */ int textHeight;
    private final /* synthetic */ RealmsScreen parent;
    private /* synthetic */ List<String> lines;
    
    @Override
    public void buttonClicked(final RealmsButton lllllllllllIIIIlllllllIIllIIIIll) {
        if (lllllllllllIIIIlllllllIIllIIIIll.id() == 0) {
            Realms.setScreen(this.parent);
        }
    }
    
    @Override
    public void keyPressed(final char lllllllllllIIIIlllllllIIllIIllII, final int lllllllllllIIIIlllllllIIllIIlIll) {
        if (lllllllllllIIIIlllllllIIllIIlIll == 1) {
            Realms.setScreen(this.parent);
        }
    }
    
    public DisconnectedRealmsScreen(final RealmsScreen lllllllllllIIIIlllllllIIllIlIlIl, final String lllllllllllIIIIlllllllIIllIllIII, final ITextComponent lllllllllllIIIIlllllllIIllIlIIll) {
        this.parent = lllllllllllIIIIlllllllIIllIlIlIl;
        this.title = RealmsScreen.getLocalizedString(lllllllllllIIIIlllllllIIllIllIII);
        this.reason = lllllllllllIIIIlllllllIIllIlIIll;
    }
    
    @Override
    public void render(final int lllllllllllIIIIlllllllIIlIllIlII, final int lllllllllllIIIIlllllllIIlIlllIIl, final float lllllllllllIIIIlllllllIIlIlllIII) {
        this.renderBackground();
        this.drawCenteredString(this.title, this.width() / 2, this.height() / 2 - this.textHeight / 2 - this.fontLineHeight() * 2, 11184810);
        int lllllllllllIIIIlllllllIIlIllIlll = this.height() / 2 - this.textHeight / 2;
        if (this.lines != null) {
            for (final String lllllllllllIIIIlllllllIIlIllIllI : this.lines) {
                this.drawCenteredString(lllllllllllIIIIlllllllIIlIllIllI, this.width() / 2, lllllllllllIIIIlllllllIIlIllIlll, 16777215);
                lllllllllllIIIIlllllllIIlIllIlll += this.fontLineHeight();
            }
        }
        super.render(lllllllllllIIIIlllllllIIlIllIlII, lllllllllllIIIIlllllllIIlIlllIIl, lllllllllllIIIIlllllllIIlIlllIII);
    }
    
    @Override
    public void init() {
        Realms.setConnectedToRealms(false);
        Realms.clearResourcePack();
        this.buttonsClear();
        this.lines = this.fontSplit(this.reason.getFormattedText(), this.width() - 50);
        this.textHeight = this.lines.size() * this.fontLineHeight();
        this.buttonsAdd(RealmsScreen.newButton(0, this.width() / 2 - 100, this.height() / 2 + this.textHeight / 2 + this.fontLineHeight(), RealmsScreen.getLocalizedString("gui.back")));
    }
}
