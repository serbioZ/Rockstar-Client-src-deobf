// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class Gui
{
    public /* synthetic */ float zLevel;
    
    public void drawCenteredString(final FontRenderer llllllllllIlllIlllIIIIllIIIIlIll, final String llllllllllIlllIlllIIIIllIIIIIlIl, final int llllllllllIlllIlllIIIIllIIIIIlII, final int llllllllllIlllIlllIIIIllIIIIlIII, final int llllllllllIlllIlllIIIIllIIIIIIlI) {
        llllllllllIlllIlllIIIIllIIIIlIll.drawStringWithShadow(llllllllllIlllIlllIIIIllIIIIIlIl, (float)(llllllllllIlllIlllIIIIllIIIIIlII - llllllllllIlllIlllIIIIllIIIIlIll.getStringWidth(llllllllllIlllIlllIIIIllIIIIIlIl) / 2), (float)llllllllllIlllIlllIIIIllIIIIlIII, llllllllllIlllIlllIIIIllIIIIIIlI);
    }
    
    protected void drawGradientRect(final int llllllllllIlllIlllIIIIllIIllIIlI, final int llllllllllIlllIlllIIIIllIIllIIIl, final int llllllllllIlllIlllIIIIllIIIlllll, final int llllllllllIlllIlllIIIIllIIlIllll, final int llllllllllIlllIlllIIIIllIIlIlllI, final int llllllllllIlllIlllIIIIllIIIlllII) {
        final float llllllllllIlllIlllIIIIllIIlIllII = (llllllllllIlllIlllIIIIllIIlIlllI >> 24 & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIIlIlIll = (llllllllllIlllIlllIIIIllIIlIlllI >> 16 & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIIlIlIlI = (llllllllllIlllIlllIIIIllIIlIlllI >> 8 & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIIlIlIIl = (llllllllllIlllIlllIIIIllIIlIlllI & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIIlIlIII = (llllllllllIlllIlllIIIIllIIIlllII >> 24 & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIIlIIlll = (llllllllllIlllIlllIIIIllIIIlllII >> 16 & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIIlIIllI = (llllllllllIlllIlllIIIIllIIIlllII >> 8 & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIIlIIlIl = (llllllllllIlllIlllIIIIllIIIlllII & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        final Tessellator llllllllllIlllIlllIIIIllIIlIIlII = Tessellator.getInstance();
        final BufferBuilder llllllllllIlllIlllIIIIllIIlIIIll = llllllllllIlllIlllIIIIllIIlIIlII.getBuffer();
        llllllllllIlllIlllIIIIllIIlIIIll.begin(7, DefaultVertexFormats.POSITION_COLOR);
        llllllllllIlllIlllIIIIllIIlIIIll.pos(llllllllllIlllIlllIIIIllIIIlllll, llllllllllIlllIlllIIIIllIIllIIIl, this.zLevel).color(llllllllllIlllIlllIIIIllIIlIlIll, llllllllllIlllIlllIIIIllIIlIlIlI, llllllllllIlllIlllIIIIllIIlIlIIl, llllllllllIlllIlllIIIIllIIlIllII).endVertex();
        llllllllllIlllIlllIIIIllIIlIIIll.pos(llllllllllIlllIlllIIIIllIIllIIlI, llllllllllIlllIlllIIIIllIIllIIIl, this.zLevel).color(llllllllllIlllIlllIIIIllIIlIlIll, llllllllllIlllIlllIIIIllIIlIlIlI, llllllllllIlllIlllIIIIllIIlIlIIl, llllllllllIlllIlllIIIIllIIlIllII).endVertex();
        llllllllllIlllIlllIIIIllIIlIIIll.pos(llllllllllIlllIlllIIIIllIIllIIlI, llllllllllIlllIlllIIIIllIIlIllll, this.zLevel).color(llllllllllIlllIlllIIIIllIIlIIlll, llllllllllIlllIlllIIIIllIIlIIllI, llllllllllIlllIlllIIIIllIIlIIlIl, llllllllllIlllIlllIIIIllIIlIlIII).endVertex();
        llllllllllIlllIlllIIIIllIIlIIIll.pos(llllllllllIlllIlllIIIIllIIIlllll, llllllllllIlllIlllIIIIllIIlIllll, this.zLevel).color(llllllllllIlllIlllIIIIllIIlIIlll, llllllllllIlllIlllIIIIllIIlIIllI, llllllllllIlllIlllIIIIllIIlIIlIl, llllllllllIlllIlllIIIIllIIlIlIII).endVertex();
        llllllllllIlllIlllIIIIllIIlIIlII.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public static void drawScaledCustomSizeModalRect(final int llllllllllIlllIlllIIIIlIIllIIlIl, final int llllllllllIlllIlllIIIIlIIllIIlII, final float llllllllllIlllIlllIIIIlIIllIIIll, final float llllllllllIlllIlllIIIIlIIllIIIlI, final int llllllllllIlllIlllIIIIlIIllIIIIl, final int llllllllllIlllIlllIIIIlIIlIlIIlI, final int llllllllllIlllIlllIIIIlIIlIlIIIl, final int llllllllllIlllIlllIIIIlIIlIlIIII, final float llllllllllIlllIlllIIIIlIIlIIllll, final float llllllllllIlllIlllIIIIlIIlIIlllI) {
        final float llllllllllIlllIlllIIIIlIIlIllIll = 1.0f / llllllllllIlllIlllIIIIlIIlIIllll;
        final float llllllllllIlllIlllIIIIlIIlIllIlI = 1.0f / llllllllllIlllIlllIIIIlIIlIIlllI;
        final Tessellator llllllllllIlllIlllIIIIlIIlIllIIl = Tessellator.getInstance();
        final BufferBuilder llllllllllIlllIlllIIIIlIIlIllIII = llllllllllIlllIlllIIIIlIIlIllIIl.getBuffer();
        llllllllllIlllIlllIIIIlIIlIllIII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllIlllIlllIIIIlIIlIllIII.pos(llllllllllIlllIlllIIIIlIIllIIlIl, llllllllllIlllIlllIIIIlIIllIIlII + llllllllllIlllIlllIIIIlIIlIlIIII, 0.0).tex(llllllllllIlllIlllIIIIlIIllIIIll * llllllllllIlllIlllIIIIlIIlIllIll, (llllllllllIlllIlllIIIIlIIllIIIlI + llllllllllIlllIlllIIIIlIIlIlIIlI) * llllllllllIlllIlllIIIIlIIlIllIlI).endVertex();
        llllllllllIlllIlllIIIIlIIlIllIII.pos(llllllllllIlllIlllIIIIlIIllIIlIl + llllllllllIlllIlllIIIIlIIlIlIIIl, llllllllllIlllIlllIIIIlIIllIIlII + llllllllllIlllIlllIIIIlIIlIlIIII, 0.0).tex((llllllllllIlllIlllIIIIlIIllIIIll + llllllllllIlllIlllIIIIlIIllIIIIl) * llllllllllIlllIlllIIIIlIIlIllIll, (llllllllllIlllIlllIIIIlIIllIIIlI + llllllllllIlllIlllIIIIlIIlIlIIlI) * llllllllllIlllIlllIIIIlIIlIllIlI).endVertex();
        llllllllllIlllIlllIIIIlIIlIllIII.pos(llllllllllIlllIlllIIIIlIIllIIlIl + llllllllllIlllIlllIIIIlIIlIlIIIl, llllllllllIlllIlllIIIIlIIllIIlII, 0.0).tex((llllllllllIlllIlllIIIIlIIllIIIll + llllllllllIlllIlllIIIIlIIllIIIIl) * llllllllllIlllIlllIIIIlIIlIllIll, llllllllllIlllIlllIIIIlIIllIIIlI * llllllllllIlllIlllIIIIlIIlIllIlI).endVertex();
        llllllllllIlllIlllIIIIlIIlIllIII.pos(llllllllllIlllIlllIIIIlIIllIIlIl, llllllllllIlllIlllIIIIlIIllIIlII, 0.0).tex(llllllllllIlllIlllIIIIlIIllIIIll * llllllllllIlllIlllIIIIlIIlIllIll, llllllllllIlllIlllIIIIlIIllIIIlI * llllllllllIlllIlllIIIIlIIlIllIlI).endVertex();
        llllllllllIlllIlllIIIIlIIlIllIIl.draw();
    }
    
    protected void drawHorizontalLine(int llllllllllIlllIlllIIIIllIlllllII, int llllllllllIlllIlllIIIIllIllllIll, final int llllllllllIlllIlllIIIIllIlllllll, final int llllllllllIlllIlllIIIIllIllllllI) {
        if (llllllllllIlllIlllIIIIllIllllIll < llllllllllIlllIlllIIIIllIlllllII) {
            final int llllllllllIlllIlllIIIIllIlllllIl = (int)llllllllllIlllIlllIIIIllIlllllII;
            llllllllllIlllIlllIIIIllIlllllII = llllllllllIlllIlllIIIIllIllllIll;
            llllllllllIlllIlllIIIIllIllllIll = llllllllllIlllIlllIIIIllIlllllIl;
        }
        drawRect((double)llllllllllIlllIlllIIIIllIlllllII, llllllllllIlllIlllIIIIllIlllllll, llllllllllIlllIlllIIIIllIllllIll + 1, llllllllllIlllIlllIIIIllIlllllll + 1, llllllllllIlllIlllIIIIllIllllllI);
    }
    
    static {
        OPTIONS_BACKGROUND = new ResourceLocation("textures/gui/options_background.png");
        STAT_ICONS = new ResourceLocation("textures/gui/container/stats_icons.png");
        ICONS = new ResourceLocation("textures/gui/icons.png");
    }
    
    public void drawString(final FontRenderer llllllllllIlllIlllIIIIlIllllIllI, final String llllllllllIlllIlllIIIIlIllllIlIl, final int llllllllllIlllIlllIIIIlIllllIlII, final int llllllllllIlllIlllIIIIlIlllllIII, final int llllllllllIlllIlllIIIIlIllllIlll) {
        llllllllllIlllIlllIIIIlIllllIllI.drawStringWithShadow(llllllllllIlllIlllIIIIlIllllIlIl, (float)llllllllllIlllIlllIIIIlIllllIlII, (float)llllllllllIlllIlllIIIIlIlllllIII, llllllllllIlllIlllIIIIlIllllIlll);
    }
    
    public static void drawModalRectWithCustomSizedTexture(final float llllllllllIlllIlllIIIIlIlIIIlIll, final float llllllllllIlllIlllIIIIlIlIIIlIlI, final float llllllllllIlllIlllIIIIlIlIIIlIIl, final float llllllllllIlllIlllIIIIlIlIIIlIII, final float llllllllllIlllIlllIIIIlIlIIIIlll, final float llllllllllIlllIlllIIIIlIlIIIIllI, final float llllllllllIlllIlllIIIIlIlIIIIlIl, final float llllllllllIlllIlllIIIIlIlIIIIlII) {
        final float llllllllllIlllIlllIIIIlIlIIIIIll = 1.0f / llllllllllIlllIlllIIIIlIlIIIIlIl;
        final float llllllllllIlllIlllIIIIlIlIIIIIlI = 1.0f / llllllllllIlllIlllIIIIlIlIIIIlII;
        final Tessellator llllllllllIlllIlllIIIIlIlIIIIIIl = Tessellator.getInstance();
        final BufferBuilder llllllllllIlllIlllIIIIlIlIIIIIII = llllllllllIlllIlllIIIIlIlIIIIIIl.getBuffer();
        llllllllllIlllIlllIIIIlIlIIIIIII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllIlllIlllIIIIlIlIIIIIII.pos(llllllllllIlllIlllIIIIlIlIIIlIll, llllllllllIlllIlllIIIIlIlIIIlIlI + llllllllllIlllIlllIIIIlIlIIIIllI, 0.0).tex(llllllllllIlllIlllIIIIlIlIIIlIIl * llllllllllIlllIlllIIIIlIlIIIIIll, (llllllllllIlllIlllIIIIlIlIIIlIII + llllllllllIlllIlllIIIIlIlIIIIllI) * llllllllllIlllIlllIIIIlIlIIIIIlI).endVertex();
        llllllllllIlllIlllIIIIlIlIIIIIII.pos(llllllllllIlllIlllIIIIlIlIIIlIll + llllllllllIlllIlllIIIIlIlIIIIlll, llllllllllIlllIlllIIIIlIlIIIlIlI + llllllllllIlllIlllIIIIlIlIIIIllI, 0.0).tex((llllllllllIlllIlllIIIIlIlIIIlIIl + llllllllllIlllIlllIIIIlIlIIIIlll) * llllllllllIlllIlllIIIIlIlIIIIIll, (llllllllllIlllIlllIIIIlIlIIIlIII + llllllllllIlllIlllIIIIlIlIIIIllI) * llllllllllIlllIlllIIIIlIlIIIIIlI).endVertex();
        llllllllllIlllIlllIIIIlIlIIIIIII.pos(llllllllllIlllIlllIIIIlIlIIIlIll + llllllllllIlllIlllIIIIlIlIIIIlll, llllllllllIlllIlllIIIIlIlIIIlIlI, 0.0).tex((llllllllllIlllIlllIIIIlIlIIIlIIl + llllllllllIlllIlllIIIIlIlIIIIlll) * llllllllllIlllIlllIIIIlIlIIIIIll, llllllllllIlllIlllIIIIlIlIIIlIII * llllllllllIlllIlllIIIIlIlIIIIIlI).endVertex();
        llllllllllIlllIlllIIIIlIlIIIIIII.pos(llllllllllIlllIlllIIIIlIlIIIlIll, llllllllllIlllIlllIIIIlIlIIIlIlI, 0.0).tex(llllllllllIlllIlllIIIIlIlIIIlIIl * llllllllllIlllIlllIIIIlIlIIIIIll, llllllllllIlllIlllIIIIlIlIIIlIII * llllllllllIlllIlllIIIIlIlIIIIIlI).endVertex();
        llllllllllIlllIlllIIIIlIlIIIIIIl.draw();
    }
    
    public static void drawRect(double llllllllllIlllIlllIIIIllIlIIllll, double llllllllllIlllIlllIIIIllIlIIlllI, double llllllllllIlllIlllIIIIllIlIIllIl, double llllllllllIlllIlllIIIIllIlIIllII, final int llllllllllIlllIlllIIIIllIlIIlIll) {
        if (llllllllllIlllIlllIIIIllIlIIllll < llllllllllIlllIlllIIIIllIlIIllIl) {
            final double llllllllllIlllIlllIIIIllIlIlIlll = llllllllllIlllIlllIIIIllIlIIllll;
            llllllllllIlllIlllIIIIllIlIIllll = llllllllllIlllIlllIIIIllIlIIllIl;
            llllllllllIlllIlllIIIIllIlIIllIl = llllllllllIlllIlllIIIIllIlIlIlll;
        }
        if (llllllllllIlllIlllIIIIllIlIIlllI < llllllllllIlllIlllIIIIllIlIIllII) {
            final double llllllllllIlllIlllIIIIllIlIlIllI = llllllllllIlllIlllIIIIllIlIIlllI;
            llllllllllIlllIlllIIIIllIlIIlllI = llllllllllIlllIlllIIIIllIlIIllII;
            llllllllllIlllIlllIIIIllIlIIllII = llllllllllIlllIlllIIIIllIlIlIllI;
        }
        final float llllllllllIlllIlllIIIIllIlIlIlIl = (llllllllllIlllIlllIIIIllIlIIlIll >> 24 & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIlIlIlII = (llllllllllIlllIlllIIIIllIlIIlIll >> 16 & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIlIlIIll = (llllllllllIlllIlllIIIIllIlIIlIll >> 8 & 0xFF) / 255.0f;
        final float llllllllllIlllIlllIIIIllIlIlIIlI = (llllllllllIlllIlllIIIIllIlIIlIll & 0xFF) / 255.0f;
        final Tessellator llllllllllIlllIlllIIIIllIlIlIIIl = Tessellator.getInstance();
        final BufferBuilder llllllllllIlllIlllIIIIllIlIlIIII = llllllllllIlllIlllIIIIllIlIlIIIl.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(llllllllllIlllIlllIIIIllIlIlIlII, llllllllllIlllIlllIIIIllIlIlIIll, llllllllllIlllIlllIIIIllIlIlIIlI, llllllllllIlllIlllIIIIllIlIlIlIl);
        llllllllllIlllIlllIIIIllIlIlIIII.begin(7, DefaultVertexFormats.POSITION);
        llllllllllIlllIlllIIIIllIlIlIIII.pos(llllllllllIlllIlllIIIIllIlIIllll, llllllllllIlllIlllIIIIllIlIIllII, 0.0).endVertex();
        llllllllllIlllIlllIIIIllIlIlIIII.pos(llllllllllIlllIlllIIIIllIlIIllIl, llllllllllIlllIlllIIIIllIlIIllII, 0.0).endVertex();
        llllllllllIlllIlllIIIIllIlIlIIII.pos(llllllllllIlllIlllIIIIllIlIIllIl, llllllllllIlllIlllIIIIllIlIIlllI, 0.0).endVertex();
        llllllllllIlllIlllIIIIllIlIlIIII.pos(llllllllllIlllIlllIIIIllIlIIllll, llllllllllIlllIlllIIIIllIlIIlllI, 0.0).endVertex();
        llllllllllIlllIlllIIIIllIlIlIIIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public void drawTexturedModalRect(final float llllllllllIlllIlllIIIIlIllIIIlII, final float llllllllllIlllIlllIIIIlIllIIIIll, final int llllllllllIlllIlllIIIIlIllIIIIlI, final int llllllllllIlllIlllIIIIlIllIIIIIl, final int llllllllllIlllIlllIIIIlIlIllIlIl, final int llllllllllIlllIlllIIIIlIlIllIlII) {
        final float llllllllllIlllIlllIIIIlIlIlllllI = 0.00390625f;
        final float llllllllllIlllIlllIIIIlIlIllllIl = 0.00390625f;
        final Tessellator llllllllllIlllIlllIIIIlIlIllllII = Tessellator.getInstance();
        final BufferBuilder llllllllllIlllIlllIIIIlIlIlllIll = llllllllllIlllIlllIIIIlIlIllllII.getBuffer();
        llllllllllIlllIlllIIIIlIlIlllIll.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllIlllIlllIIIIlIlIlllIll.pos(llllllllllIlllIlllIIIIlIllIIIlII + 0.0f, llllllllllIlllIlllIIIIlIllIIIIll + llllllllllIlllIlllIIIIlIlIllIlII, this.zLevel).tex((llllllllllIlllIlllIIIIlIllIIIIlI + 0) * 0.00390625f, (llllllllllIlllIlllIIIIlIllIIIIIl + llllllllllIlllIlllIIIIlIlIllIlII) * 0.00390625f).endVertex();
        llllllllllIlllIlllIIIIlIlIlllIll.pos(llllllllllIlllIlllIIIIlIllIIIlII + llllllllllIlllIlllIIIIlIlIllIlIl, llllllllllIlllIlllIIIIlIllIIIIll + llllllllllIlllIlllIIIIlIlIllIlII, this.zLevel).tex((llllllllllIlllIlllIIIIlIllIIIIlI + llllllllllIlllIlllIIIIlIlIllIlIl) * 0.00390625f, (llllllllllIlllIlllIIIIlIllIIIIIl + llllllllllIlllIlllIIIIlIlIllIlII) * 0.00390625f).endVertex();
        llllllllllIlllIlllIIIIlIlIlllIll.pos(llllllllllIlllIlllIIIIlIllIIIlII + llllllllllIlllIlllIIIIlIlIllIlIl, llllllllllIlllIlllIIIIlIllIIIIll + 0.0f, this.zLevel).tex((llllllllllIlllIlllIIIIlIllIIIIlI + llllllllllIlllIlllIIIIlIlIllIlIl) * 0.00390625f, (llllllllllIlllIlllIIIIlIllIIIIIl + 0) * 0.00390625f).endVertex();
        llllllllllIlllIlllIIIIlIlIlllIll.pos(llllllllllIlllIlllIIIIlIllIIIlII + 0.0f, llllllllllIlllIlllIIIIlIllIIIIll + 0.0f, this.zLevel).tex((llllllllllIlllIlllIIIIlIllIIIIlI + 0) * 0.00390625f, (llllllllllIlllIlllIIIIlIllIIIIIl + 0) * 0.00390625f).endVertex();
        llllllllllIlllIlllIIIIlIlIllllII.draw();
    }
    
    public void drawTexturedModalRect(final int llllllllllIlllIlllIIIIlIlIIllllI, final int llllllllllIlllIlllIIIIlIlIlIIlIl, final TextureAtlasSprite llllllllllIlllIlllIIIIlIlIIlllII, final int llllllllllIlllIlllIIIIlIlIlIIIll, final int llllllllllIlllIlllIIIIlIlIlIIIlI) {
        final Tessellator llllllllllIlllIlllIIIIlIlIlIIIIl = Tessellator.getInstance();
        final BufferBuilder llllllllllIlllIlllIIIIlIlIlIIIII = llllllllllIlllIlllIIIIlIlIlIIIIl.getBuffer();
        llllllllllIlllIlllIIIIlIlIlIIIII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllIlllIlllIIIIlIlIlIIIII.pos(llllllllllIlllIlllIIIIlIlIIllllI + 0, llllllllllIlllIlllIIIIlIlIlIIlIl + llllllllllIlllIlllIIIIlIlIlIIIlI, this.zLevel).tex(llllllllllIlllIlllIIIIlIlIIlllII.getMinU(), llllllllllIlllIlllIIIIlIlIIlllII.getMaxV()).endVertex();
        llllllllllIlllIlllIIIIlIlIlIIIII.pos(llllllllllIlllIlllIIIIlIlIIllllI + llllllllllIlllIlllIIIIlIlIlIIIll, llllllllllIlllIlllIIIIlIlIlIIlIl + llllllllllIlllIlllIIIIlIlIlIIIlI, this.zLevel).tex(llllllllllIlllIlllIIIIlIlIIlllII.getMaxU(), llllllllllIlllIlllIIIIlIlIIlllII.getMaxV()).endVertex();
        llllllllllIlllIlllIIIIlIlIlIIIII.pos(llllllllllIlllIlllIIIIlIlIIllllI + llllllllllIlllIlllIIIIlIlIlIIIll, llllllllllIlllIlllIIIIlIlIlIIlIl + 0, this.zLevel).tex(llllllllllIlllIlllIIIIlIlIIlllII.getMaxU(), llllllllllIlllIlllIIIIlIlIIlllII.getMinV()).endVertex();
        llllllllllIlllIlllIIIIlIlIlIIIII.pos(llllllllllIlllIlllIIIIlIlIIllllI + 0, llllllllllIlllIlllIIIIlIlIlIIlIl + 0, this.zLevel).tex(llllllllllIlllIlllIIIIlIlIIlllII.getMinU(), llllllllllIlllIlllIIIIlIlIIlllII.getMinV()).endVertex();
        llllllllllIlllIlllIIIIlIlIlIIIIl.draw();
    }
    
    protected void drawVerticalLine(final int llllllllllIlllIlllIIIIllIllIllII, int llllllllllIlllIlllIIIIllIllIlIll, int llllllllllIlllIlllIIIIllIllIlIlI, final int llllllllllIlllIlllIIIIllIllIlIIl) {
        if (llllllllllIlllIlllIIIIllIllIlIlI < llllllllllIlllIlllIIIIllIllIlIll) {
            final int llllllllllIlllIlllIIIIllIllIllIl = llllllllllIlllIlllIIIIllIllIlIll;
            llllllllllIlllIlllIIIIllIllIlIll = (int)llllllllllIlllIlllIIIIllIllIlIlI;
            llllllllllIlllIlllIIIIllIllIlIlI = llllllllllIlllIlllIIIIllIllIllIl;
        }
        drawRect(llllllllllIlllIlllIIIIllIllIllII, llllllllllIlllIlllIIIIllIllIlIll + 1, llllllllllIlllIlllIIIIllIllIllII + 1, (double)llllllllllIlllIlllIIIIllIllIlIlI, llllllllllIlllIlllIIIIllIllIlIIl);
    }
    
    public void drawTexturedModalRect(final int llllllllllIlllIlllIIIIlIlllIIlIl, final int llllllllllIlllIlllIIIIlIllIllIIl, final int llllllllllIlllIlllIIIIlIllIllIII, final int llllllllllIlllIlllIIIIlIlllIIIlI, final int llllllllllIlllIlllIIIIlIlllIIIIl, final int llllllllllIlllIlllIIIIlIlllIIIII) {
        final float llllllllllIlllIlllIIIIlIllIlllll = 0.00390625f;
        final float llllllllllIlllIlllIIIIlIllIllllI = 0.00390625f;
        final Tessellator llllllllllIlllIlllIIIIlIllIlllIl = Tessellator.getInstance();
        final BufferBuilder llllllllllIlllIlllIIIIlIllIlllII = llllllllllIlllIlllIIIIlIllIlllIl.getBuffer();
        llllllllllIlllIlllIIIIlIllIlllII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllIlllIlllIIIIlIllIlllII.pos(llllllllllIlllIlllIIIIlIlllIIlIl + 0, llllllllllIlllIlllIIIIlIllIllIIl + llllllllllIlllIlllIIIIlIlllIIIII, this.zLevel).tex((llllllllllIlllIlllIIIIlIllIllIII + 0) * 0.00390625f, (llllllllllIlllIlllIIIIlIlllIIIlI + llllllllllIlllIlllIIIIlIlllIIIII) * 0.00390625f).endVertex();
        llllllllllIlllIlllIIIIlIllIlllII.pos(llllllllllIlllIlllIIIIlIlllIIlIl + llllllllllIlllIlllIIIIlIlllIIIIl, llllllllllIlllIlllIIIIlIllIllIIl + llllllllllIlllIlllIIIIlIlllIIIII, this.zLevel).tex((llllllllllIlllIlllIIIIlIllIllIII + llllllllllIlllIlllIIIIlIlllIIIIl) * 0.00390625f, (llllllllllIlllIlllIIIIlIlllIIIlI + llllllllllIlllIlllIIIIlIlllIIIII) * 0.00390625f).endVertex();
        llllllllllIlllIlllIIIIlIllIlllII.pos(llllllllllIlllIlllIIIIlIlllIIlIl + llllllllllIlllIlllIIIIlIlllIIIIl, llllllllllIlllIlllIIIIlIllIllIIl + 0, this.zLevel).tex((llllllllllIlllIlllIIIIlIllIllIII + llllllllllIlllIlllIIIIlIlllIIIIl) * 0.00390625f, (llllllllllIlllIlllIIIIlIlllIIIlI + 0) * 0.00390625f).endVertex();
        llllllllllIlllIlllIIIIlIllIlllII.pos(llllllllllIlllIlllIIIIlIlllIIlIl + 0, llllllllllIlllIlllIIIIlIllIllIIl + 0, this.zLevel).tex((llllllllllIlllIlllIIIIlIllIllIII + 0) * 0.00390625f, (llllllllllIlllIlllIIIIlIlllIIIlI + 0) * 0.00390625f).endVertex();
        llllllllllIlllIlllIIIIlIllIlllIl.draw();
    }
}
