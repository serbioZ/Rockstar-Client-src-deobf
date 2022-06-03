// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.realms.RealmsSimpleScrolledSelectionList;

public class GuiSimpleScrolledSelectionListProxy extends GuiSlot
{
    private final /* synthetic */ RealmsSimpleScrolledSelectionList realmsScrolledSelectionList;
    
    @Override
    protected void elementClicked(final int lllllllllllllIllIllIllllIIIIIllI, final boolean lllllllllllllIllIllIllllIIIIlIlI, final int lllllllllllllIllIllIllllIIIIlIIl, final int lllllllllllllIllIllIllllIIIIlIII) {
        this.realmsScrolledSelectionList.selectItem(lllllllllllllIllIllIllllIIIIIllI, lllllllllllllIllIllIllllIIIIlIlI, lllllllllllllIllIllIllllIIIIlIIl, lllllllllllllIllIllIllllIIIIlIII);
    }
    
    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
    }
    
    @Override
    protected int getScrollBarX() {
        return this.realmsScrolledSelectionList.getScrollbarPosition();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIllIllIlllIlIllIllI, final int lllllllllllllIllIllIlllIlIllIlIl, final float lllllllllllllIllIllIlllIllIIIIIl) {
        if (this.visible) {
            this.mouseX = lllllllllllllIllIllIlllIlIllIllI;
            this.mouseY = lllllllllllllIllIllIlllIlIllIlIl;
            this.drawBackground();
            final int lllllllllllllIllIllIlllIllIIIIII = this.getScrollBarX();
            final int lllllllllllllIllIllIlllIlIllllll = lllllllllllllIllIllIlllIllIIIIII + 6;
            this.bindAmountScrolled();
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            final Tessellator lllllllllllllIllIllIlllIlIlllllI = Tessellator.getInstance();
            final BufferBuilder lllllllllllllIllIllIlllIlIllllIl = lllllllllllllIllIllIlllIlIlllllI.getBuffer();
            final int lllllllllllllIllIllIlllIlIllllII = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            final int lllllllllllllIllIllIlllIlIlllIll = this.top + 4 - (int)this.amountScrolled;
            if (this.hasListHeader) {
                this.drawListHeader(lllllllllllllIllIllIlllIlIllllII, lllllllllllllIllIllIlllIlIlllIll, lllllllllllllIllIllIlllIlIlllllI);
            }
            this.func_192638_a(lllllllllllllIllIllIlllIlIllllII, lllllllllllllIllIllIlllIlIlllIll, lllllllllllllIllIllIlllIlIllIllI, lllllllllllllIllIllIlllIlIllIlIl, lllllllllllllIllIllIlllIllIIIIIl);
            GlStateManager.disableDepth();
            this.overlayBackground(0, this.top, 255, 255);
            this.overlayBackground(this.bottom, this.height, 255, 255);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
            GlStateManager.disableAlpha();
            GlStateManager.shadeModel(7425);
            GlStateManager.disableTexture2D();
            final int lllllllllllllIllIllIlllIlIlllIlI = this.getMaxScroll();
            if (lllllllllllllIllIllIlllIlIlllIlI > 0) {
                int lllllllllllllIllIllIlllIlIlllIIl = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
                lllllllllllllIllIllIlllIlIlllIIl = MathHelper.clamp(lllllllllllllIllIllIlllIlIlllIIl, 32, this.bottom - this.top - 8);
                int lllllllllllllIllIllIlllIlIlllIII = (int)this.amountScrolled * (this.bottom - this.top - lllllllllllllIllIllIlllIlIlllIIl) / lllllllllllllIllIllIlllIlIlllIlI + this.top;
                if (lllllllllllllIllIllIlllIlIlllIII < this.top) {
                    lllllllllllllIllIllIlllIlIlllIII = this.top;
                }
                lllllllllllllIllIllIlllIlIllllIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIllIIIIII, this.bottom, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIlIllllll, this.bottom, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIlIllllll, this.top, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIllIIIIII, this.top, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllIllIllIlllIlIlllllI.draw();
                lllllllllllllIllIllIlllIlIllllIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIllIIIIII, lllllllllllllIllIllIlllIlIlllIII + lllllllllllllIllIllIlllIlIlllIIl, 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIlIllllll, lllllllllllllIllIllIlllIlIlllIII + lllllllllllllIllIllIlllIlIlllIIl, 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIlIllllll, lllllllllllllIllIllIlllIlIlllIII, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIllIIIIII, lllllllllllllIllIllIlllIlIlllIII, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
                lllllllllllllIllIllIlllIlIlllllI.draw();
                lllllllllllllIllIllIlllIlIllllIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIllIIIIII, lllllllllllllIllIllIlllIlIlllIII + lllllllllllllIllIllIlllIlIlllIIl - 1, 0.0).tex(0.0, 1.0).color(192, 192, 192, 255).endVertex();
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIlIllllll - 1, lllllllllllllIllIllIlllIlIlllIII + lllllllllllllIllIllIlllIlIlllIIl - 1, 0.0).tex(1.0, 1.0).color(192, 192, 192, 255).endVertex();
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIlIllllll - 1, lllllllllllllIllIllIlllIlIlllIII, 0.0).tex(1.0, 0.0).color(192, 192, 192, 255).endVertex();
                lllllllllllllIllIllIlllIlIllllIl.pos(lllllllllllllIllIllIlllIllIIIIII, lllllllllllllIllIllIlllIlIlllIII, 0.0).tex(0.0, 0.0).color(192, 192, 192, 255).endVertex();
                lllllllllllllIllIllIlllIlIlllllI.draw();
            }
            this.renderDecorations(lllllllllllllIllIllIlllIlIllIllI, lllllllllllllIllIllIlllIlIllIlIl);
            GlStateManager.enableTexture2D();
            GlStateManager.shadeModel(7424);
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
        }
    }
    
    public int getMouseY() {
        return this.mouseY;
    }
    
    @Override
    protected int getContentHeight() {
        return this.realmsScrolledSelectionList.getMaxPosition();
    }
    
    public int getMouseX() {
        return this.mouseX;
    }
    
    @Override
    protected void func_192637_a(final int lllllllllllllIllIllIlllIllllIIIl, final int lllllllllllllIllIllIlllIlllIlIII, final int lllllllllllllIllIllIlllIlllIllll, final int lllllllllllllIllIllIlllIlllIlllI, final int lllllllllllllIllIllIlllIlllIIlIl, final int lllllllllllllIllIllIlllIlllIIlII, final float lllllllllllllIllIllIlllIlllIlIll) {
        this.realmsScrolledSelectionList.renderItem(lllllllllllllIllIllIlllIllllIIIl, lllllllllllllIllIllIlllIlllIlIII, lllllllllllllIllIllIlllIlllIllll, lllllllllllllIllIllIlllIlllIlllI, lllllllllllllIllIllIlllIlllIIlIl, lllllllllllllIllIllIlllIlllIIlII);
    }
    
    @Override
    protected void drawBackground() {
        this.realmsScrolledSelectionList.renderBackground();
    }
    
    @Override
    protected boolean isSelected(final int lllllllllllllIllIllIlllIllllllIl) {
        return this.realmsScrolledSelectionList.isSelectedItem(lllllllllllllIllIllIlllIllllllIl);
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public GuiSimpleScrolledSelectionListProxy(final RealmsSimpleScrolledSelectionList lllllllllllllIllIllIllllIIlIIIIl, final int lllllllllllllIllIllIllllIIIllIIl, final int lllllllllllllIllIllIllllIIIlllll, final int lllllllllllllIllIllIllllIIIlIlll, final int lllllllllllllIllIllIllllIIIlIllI, final int lllllllllllllIllIllIllllIIIlllII) {
        super(Minecraft.getMinecraft(), lllllllllllllIllIllIllllIIIllIIl, lllllllllllllIllIllIllllIIIlllll, lllllllllllllIllIllIllllIIIlIlll, lllllllllllllIllIllIllllIIIlIllI, lllllllllllllIllIllIllllIIIlllII);
        this.realmsScrolledSelectionList = lllllllllllllIllIllIllllIIlIIIIl;
    }
    
    @Override
    protected int getSize() {
        return this.realmsScrolledSelectionList.getItemCount();
    }
}
