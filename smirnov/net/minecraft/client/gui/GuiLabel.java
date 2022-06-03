// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import java.util.List;

public class GuiLabel extends Gui
{
    protected /* synthetic */ int width;
    private final /* synthetic */ int textColor;
    private /* synthetic */ int brColor;
    private final /* synthetic */ List<String> labels;
    private /* synthetic */ boolean centered;
    public /* synthetic */ int id;
    private final /* synthetic */ FontRenderer fontRenderer;
    public /* synthetic */ int y;
    private /* synthetic */ int ulColor;
    protected /* synthetic */ int height;
    public /* synthetic */ int x;
    private /* synthetic */ boolean labelBgEnabled;
    public /* synthetic */ boolean visible;
    private /* synthetic */ int backColor;
    private /* synthetic */ int border;
    
    public GuiLabel setCentered() {
        this.centered = true;
        return this;
    }
    
    public void drawLabel(final Minecraft llllllllllIlllIIIIlIlllllllIllIl, final int llllllllllIlllIIIIlIlllllllIllII, final int llllllllllIlllIIIIlIlllllllIlIll) {
        if (this.visible) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            this.drawLabelBackground(llllllllllIlllIIIIlIlllllllIllIl, llllllllllIlllIIIIlIlllllllIllII, llllllllllIlllIIIIlIlllllllIlIll);
            final int llllllllllIlllIIIIlIlllllllIlIlI = this.y + this.height / 2 + this.border / 2;
            final int llllllllllIlllIIIIlIlllllllIlIIl = llllllllllIlllIIIIlIlllllllIlIlI - this.labels.size() * 10 / 2;
            for (int llllllllllIlllIIIIlIlllllllIlIII = 0; llllllllllIlllIIIIlIlllllllIlIII < this.labels.size(); ++llllllllllIlllIIIIlIlllllllIlIII) {
                if (this.centered) {
                    this.drawCenteredString(this.fontRenderer, this.labels.get(llllllllllIlllIIIIlIlllllllIlIII), this.x + this.width / 2, llllllllllIlllIIIIlIlllllllIlIIl + llllllllllIlllIIIIlIlllllllIlIII * 10, this.textColor);
                }
                else {
                    this.drawString(this.fontRenderer, this.labels.get(llllllllllIlllIIIIlIlllllllIlIII), this.x, llllllllllIlllIIIIlIlllllllIlIIl + llllllllllIlllIIIIlIlllllllIlIII * 10, this.textColor);
                }
            }
        }
    }
    
    public void addLine(final String llllllllllIlllIIIIlIlllllllllIIl) {
        this.labels.add(I18n.format(llllllllllIlllIIIIlIlllllllllIIl, new Object[0]));
    }
    
    protected void drawLabelBackground(final Minecraft llllllllllIlllIIIIlIllllllIllIlI, final int llllllllllIlllIIIIlIllllllIllIIl, final int llllllllllIlllIIIIlIllllllIllIII) {
        if (this.labelBgEnabled) {
            final int llllllllllIlllIIIIlIllllllIlIlll = this.width + this.border * 2;
            final int llllllllllIlllIIIIlIllllllIlIllI = this.height + this.border * 2;
            final int llllllllllIlllIIIIlIllllllIlIlIl = this.x - this.border;
            final int llllllllllIlllIIIIlIllllllIlIlII = this.y - this.border;
            Gui.drawRect(llllllllllIlllIIIIlIllllllIlIlIl, llllllllllIlllIIIIlIllllllIlIlII, llllllllllIlllIIIIlIllllllIlIlIl + llllllllllIlllIIIIlIllllllIlIlll, llllllllllIlllIIIIlIllllllIlIlII + llllllllllIlllIIIIlIllllllIlIllI, this.backColor);
            this.drawHorizontalLine(llllllllllIlllIIIIlIllllllIlIlIl, llllllllllIlllIIIIlIllllllIlIlIl + llllllllllIlllIIIIlIllllllIlIlll, llllllllllIlllIIIIlIllllllIlIlII, this.ulColor);
            this.drawHorizontalLine(llllllllllIlllIIIIlIllllllIlIlIl, llllllllllIlllIIIIlIllllllIlIlIl + llllllllllIlllIIIIlIllllllIlIlll, llllllllllIlllIIIIlIllllllIlIlII + llllllllllIlllIIIIlIllllllIlIllI, this.brColor);
            this.drawVerticalLine(llllllllllIlllIIIIlIllllllIlIlIl, llllllllllIlllIIIIlIllllllIlIlII, llllllllllIlllIIIIlIllllllIlIlII + llllllllllIlllIIIIlIllllllIlIllI, this.ulColor);
            this.drawVerticalLine(llllllllllIlllIIIIlIllllllIlIlIl + llllllllllIlllIIIIlIllllllIlIlll, llllllllllIlllIIIIlIllllllIlIlII, llllllllllIlllIIIIlIllllllIlIlII + llllllllllIlllIIIIlIllllllIlIllI, this.brColor);
        }
    }
    
    public GuiLabel(final FontRenderer llllllllllIlllIIIIllIIIIIIIIllIl, final int llllllllllIlllIIIIllIIIIIIIIIlII, final int llllllllllIlllIIIIllIIIIIIIIlIll, final int llllllllllIlllIIIIllIIIIIIIIlIlI, final int llllllllllIlllIIIIllIIIIIIIIIIIl, final int llllllllllIlllIIIIllIIIIIIIIIIII, final int llllllllllIlllIIIIlIllllllllllll) {
        this.width = 200;
        this.height = 20;
        this.visible = true;
        this.fontRenderer = llllllllllIlllIIIIllIIIIIIIIllIl;
        this.id = llllllllllIlllIIIIllIIIIIIIIIlII;
        this.x = llllllllllIlllIIIIllIIIIIIIIlIll;
        this.y = llllllllllIlllIIIIllIIIIIIIIlIlI;
        this.width = llllllllllIlllIIIIllIIIIIIIIIIIl;
        this.height = llllllllllIlllIIIIllIIIIIIIIIIII;
        this.labels = (List<String>)Lists.newArrayList();
        this.centered = false;
        this.labelBgEnabled = false;
        this.textColor = llllllllllIlllIIIIlIllllllllllll;
        this.backColor = -1;
        this.ulColor = -1;
        this.brColor = -1;
        this.border = 0;
    }
}
