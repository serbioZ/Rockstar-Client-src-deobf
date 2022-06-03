// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.font;

import java.awt.Font;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import java.awt.Color;
import net.minecraft.client.renderer.texture.DynamicTexture;

public class FontRenderer extends CFont
{
    protected /* synthetic */ CharData[] boldItalicChars;
    private final /* synthetic */ int[] colorCode;
    protected /* synthetic */ CharData[] italicChars;
    protected /* synthetic */ CharData[] boldChars;
    protected /* synthetic */ DynamicTexture texBold;
    protected /* synthetic */ DynamicTexture texItalicBold;
    protected /* synthetic */ DynamicTexture texItalic;
    
    @Override
    public void setAntiAlias(final boolean lllllllllllllIIIlIlllIIIIIllIlll) {
        super.setAntiAlias(lllllllllllllIIIlIlllIIIIIllIlll);
        this.setupBoldItalicIDs();
    }
    
    public float drawCenteredStringWithShadow(final String lllllllllllllIIIlIlllIIIlIIlllIl, final float lllllllllllllIIIlIlllIIIlIIlllII, final float lllllllllllllIIIlIlllIIIlIIlIllI, final int lllllllllllllIIIlIlllIIIlIIllIlI) {
        return this.drawString(lllllllllllllIIIlIlllIIIlIIlllIl, lllllllllllllIIIlIlllIIIlIIlllII - this.getStringWidth(lllllllllllllIIIlIlllIIIlIIlllIl) / 2, lllllllllllllIIIlIlllIIIlIIlIllI, lllllllllllllIIIlIlllIIIlIIllIlI);
    }
    
    public static float drawCenteredStringWithShadow(final net.minecraft.client.gui.FontRenderer lllllllllllllIIIlIlllIIIlllIllIl, final String lllllllllllllIIIlIlllIIIlllIIlll, final float lllllllllllllIIIlIlllIIIlllIIllI, final float lllllllllllllIIIlIlllIIIlllIIlIl, final int lllllllllllllIIIlIlllIIIlllIIlII) {
        return (float)lllllllllllllIIIlIlllIIIlllIllIl.drawString(lllllllllllllIIIlIlllIIIlllIIlll, lllllllllllllIIIlIlllIIIlllIIllI - lllllllllllllIIIlIlllIIIlllIllIl.getStringWidth(lllllllllllllIIIlIlllIIIlllIIlll) / 2, lllllllllllllIIIlIlllIIIlllIIlIl, lllllllllllllIIIlIlllIIIlllIIlII);
    }
    
    private void setupBoldItalicIDs() {
        this.texBold = this.setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
        this.texItalic = this.setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
        this.texItalicBold = this.setupTexture(this.font.deriveFont(3), this.antiAlias, this.fractionalMetrics, this.boldItalicChars);
    }
    
    @Override
    public void setFractionalMetrics(final boolean lllllllllllllIIIlIlllIIIIIllIIIl) {
        super.setFractionalMetrics(lllllllllllllIIIlIlllIIIIIllIIIl);
        this.setupBoldItalicIDs();
    }
    
    public float drawString(final String lllllllllllllIIIlIlllIIIlIlllIll, final float lllllllllllllIIIlIlllIIIlIllIlIl, final float lllllllllllllIIIlIlllIIIlIllIlII, final int lllllllllllllIIIlIlllIIIlIlllIII) {
        return this.drawString(lllllllllllllIIIlIlllIIIlIlllIll, lllllllllllllIIIlIlllIIIlIllIlIl, lllllllllllllIIIlIlllIIIlIllIlII, lllllllllllllIIIlIlllIIIlIlllIII, false);
    }
    
    public float drawString(final String lllllllllllllIIIlIlllIIIlIIIIIlI, double lllllllllllllIIIlIlllIIIIllIllll, double lllllllllllllIIIlIlllIIIIllIlllI, int lllllllllllllIIIlIlllIIIIllIllIl, final boolean lllllllllllllIIIlIlllIIIIllllllI) {
        --lllllllllllllIIIlIlllIIIIllIllll;
        if (lllllllllllllIIIlIlllIIIIllIllIl == 553648127) {
            lllllllllllllIIIlIlllIIIIllIllIl = 16777215;
        }
        if ((lllllllllllllIIIlIlllIIIIllIllIl & 0xFC000000) == 0x0) {
            lllllllllllllIIIlIlllIIIIllIllIl |= 0xFF000000;
        }
        if (lllllllllllllIIIlIlllIIIIllllllI) {
            lllllllllllllIIIlIlllIIIIllIllIl = ((lllllllllllllIIIlIlllIIIIllIllIl & 0xFCFCFC) >> 2 | (lllllllllllllIIIlIlllIIIIllIllIl & new Color(20, 20, 20, 200).getRGB()));
        }
        CharData[] lllllllllllllIIIlIlllIIIIlllllIl = this.charData;
        final float lllllllllllllIIIlIlllIIIIlllllII = (lllllllllllllIIIlIlllIIIIllIllIl >> 24 & 0xFF) / 255.0f;
        boolean lllllllllllllIIIlIlllIIIIllllIll = false;
        boolean lllllllllllllIIIlIlllIIIIllllIlI = false;
        boolean lllllllllllllIIIlIlllIIIIllllIIl = false;
        boolean lllllllllllllIIIlIlllIIIIllllIII = false;
        lllllllllllllIIIlIlllIIIIllIllll *= 2.0;
        lllllllllllllIIIlIlllIIIIllIlllI = (lllllllllllllIIIlIlllIIIIllIlllI - 3.0) * 2.0;
        GL11.glPushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.color((lllllllllllllIIIlIlllIIIIllIllIl >> 16 & 0xFF) / 255.0f, (lllllllllllllIIIlIlllIIIIllIllIl >> 8 & 0xFF) / 255.0f, (lllllllllllllIIIlIlllIIIIllIllIl & 0xFF) / 255.0f, lllllllllllllIIIlIlllIIIIlllllII);
        final int lllllllllllllIIIlIlllIIIIlllIlll = lllllllllllllIIIlIlllIIIlIIIIIlI.length();
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(this.tex.getGlTextureId());
        GL11.glBindTexture(3553, this.tex.getGlTextureId());
        for (int lllllllllllllIIIlIlllIIIIlllIllI = 0; lllllllllllllIIIlIlllIIIIlllIllI < lllllllllllllIIIlIlllIIIIlllIlll; ++lllllllllllllIIIlIlllIIIIlllIllI) {
            final char lllllllllllllIIIlIlllIIIIlllIlIl = lllllllllllllIIIlIlllIIIlIIIIIlI.charAt(lllllllllllllIIIlIlllIIIIlllIllI);
            if (String.valueOf(lllllllllllllIIIlIlllIIIIlllIlIl).equals("§")) {
                int lllllllllllllIIIlIlllIIIIlllIlII = 21;
                try {
                    lllllllllllllIIIlIlllIIIIlllIlII = "0123456789abcdefklmnor".indexOf(lllllllllllllIIIlIlllIIIlIIIIIlI.charAt(lllllllllllllIIIlIlllIIIIlllIllI + 1));
                }
                catch (Exception lllllllllllllIIIlIlllIIIIlllIIll) {
                    lllllllllllllIIIlIlllIIIIlllIIll.printStackTrace();
                }
                if (lllllllllllllIIIlIlllIIIIlllIlII < 16) {
                    lllllllllllllIIIlIlllIIIIllllIll = false;
                    lllllllllllllIIIlIlllIIIIllllIlI = false;
                    lllllllllllllIIIlIlllIIIIllllIII = false;
                    lllllllllllllIIIlIlllIIIIllllIIl = false;
                    GlStateManager.bindTexture(this.tex.getGlTextureId());
                    lllllllllllllIIIlIlllIIIIlllllIl = this.charData;
                    if (lllllllllllllIIIlIlllIIIIlllIlII < 0) {
                        lllllllllllllIIIlIlllIIIIlllIlII = 15;
                    }
                    if (lllllllllllllIIIlIlllIIIIllllllI) {
                        lllllllllllllIIIlIlllIIIIlllIlII += 16;
                    }
                    final int lllllllllllllIIIlIlllIIIIlllIIlI = this.colorCode[lllllllllllllIIIlIlllIIIIlllIlII];
                    GlStateManager.color((lllllllllllllIIIlIlllIIIIlllIIlI >> 16 & 0xFF) / 255.0f, (lllllllllllllIIIlIlllIIIIlllIIlI >> 8 & 0xFF) / 255.0f, (lllllllllllllIIIlIlllIIIIlllIIlI & 0xFF) / 255.0f, lllllllllllllIIIlIlllIIIIlllllII);
                }
                else if (lllllllllllllIIIlIlllIIIIlllIlII == 17) {
                    lllllllllllllIIIlIlllIIIIllllIll = true;
                    if (lllllllllllllIIIlIlllIIIIllllIlI) {
                        GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                        lllllllllllllIIIlIlllIIIIlllllIl = this.boldItalicChars;
                    }
                    else {
                        GlStateManager.bindTexture(this.texBold.getGlTextureId());
                        lllllllllllllIIIlIlllIIIIlllllIl = this.boldChars;
                    }
                }
                else if (lllllllllllllIIIlIlllIIIIlllIlII == 18) {
                    lllllllllllllIIIlIlllIIIIllllIIl = true;
                }
                else if (lllllllllllllIIIlIlllIIIIlllIlII == 19) {
                    lllllllllllllIIIlIlllIIIIllllIII = true;
                }
                else if (lllllllllllllIIIlIlllIIIIlllIlII == 20) {
                    lllllllllllllIIIlIlllIIIIllllIlI = true;
                    if (lllllllllllllIIIlIlllIIIIllllIll) {
                        GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                        lllllllllllllIIIlIlllIIIIlllllIl = this.boldItalicChars;
                    }
                    else {
                        GlStateManager.bindTexture(this.texItalic.getGlTextureId());
                        lllllllllllllIIIlIlllIIIIlllllIl = this.italicChars;
                    }
                }
                else if (lllllllllllllIIIlIlllIIIIlllIlII == 21) {
                    lllllllllllllIIIlIlllIIIIllllIll = false;
                    lllllllllllllIIIlIlllIIIIllllIlI = false;
                    lllllllllllllIIIlIlllIIIIllllIII = false;
                    lllllllllllllIIIlIlllIIIIllllIIl = false;
                    GlStateManager.color((lllllllllllllIIIlIlllIIIIllIllIl >> 16 & 0xFF) / 255.0f, (lllllllllllllIIIlIlllIIIIllIllIl >> 8 & 0xFF) / 255.0f, (lllllllllllllIIIlIlllIIIIllIllIl & 0xFF) / 255.0f, lllllllllllllIIIlIlllIIIIlllllII);
                    GlStateManager.bindTexture(this.tex.getGlTextureId());
                    lllllllllllllIIIlIlllIIIIlllllIl = this.charData;
                }
                ++lllllllllllllIIIlIlllIIIIlllIllI;
            }
            else if (lllllllllllllIIIlIlllIIIIlllIlIl < lllllllllllllIIIlIlllIIIIlllllIl.length) {
                GL11.glBegin(4);
                this.drawChar(lllllllllllllIIIlIlllIIIIlllllIl, lllllllllllllIIIlIlllIIIIlllIlIl, (float)lllllllllllllIIIlIlllIIIIllIllll, (float)lllllllllllllIIIlIlllIIIIllIlllI);
                GL11.glEnd();
                if (lllllllllllllIIIlIlllIIIIllllIIl) {
                    this.drawLine(lllllllllllllIIIlIlllIIIIllIllll, lllllllllllllIIIlIlllIIIIllIlllI + lllllllllllllIIIlIlllIIIIlllllIl[lllllllllllllIIIlIlllIIIIlllIlIl].height / 2.0f, lllllllllllllIIIlIlllIIIIllIllll + lllllllllllllIIIlIlllIIIIlllllIl[lllllllllllllIIIlIlllIIIIlllIlIl].width - 8.0, lllllllllllllIIIlIlllIIIIllIlllI + lllllllllllllIIIlIlllIIIIlllllIl[lllllllllllllIIIlIlllIIIIlllIlIl].height / 2.0f, 1.0f);
                }
                if (lllllllllllllIIIlIlllIIIIllllIII) {
                    this.drawLine(lllllllllllllIIIlIlllIIIIllIllll, lllllllllllllIIIlIlllIIIIllIlllI + lllllllllllllIIIlIlllIIIIlllllIl[lllllllllllllIIIlIlllIIIIlllIlIl].height - 2.0, lllllllllllllIIIlIlllIIIIllIllll + lllllllllllllIIIlIlllIIIIlllllIl[lllllllllllllIIIlIlllIIIIlllIlIl].width - 8.0, lllllllllllllIIIlIlllIIIIllIlllI + lllllllllllllIIIlIlllIIIIlllllIl[lllllllllllllIIIlIlllIIIIlllIlIl].height - 2.0, 1.0f);
                }
                lllllllllllllIIIlIlllIIIIllIllll += lllllllllllllIIIlIlllIIIIlllllIl[lllllllllllllIIIlIlllIIIIlllIlIl].width - 8 + this.charOffset;
            }
        }
        GL11.glPopMatrix();
        return (float)(lllllllllllllIIIlIlllIIIIllIllll / 2.0);
    }
    
    public void drawCenteredStringWithOutline(final FontRenderer lllllllllllllIIIlIlllIIIllIlllIl, final String lllllllllllllIIIlIlllIIIllIlllII, final float lllllllllllllIIIlIlllIIIllIlIllI, final float lllllllllllllIIIlIlllIIIllIlIlIl, final int lllllllllllllIIIlIlllIIIllIlIlII) {
        this.drawCenteredString(lllllllllllllIIIlIlllIIIllIlllII, lllllllllllllIIIlIlllIIIllIlIllI - 1.0f, lllllllllllllIIIlIlllIIIllIlIlIl, Color.BLACK.getRGB());
        this.drawCenteredString(lllllllllllllIIIlIlllIIIllIlllII, lllllllllllllIIIlIlllIIIllIlIllI + 1.0f, lllllllllllllIIIlIlllIIIllIlIlIl, Color.BLACK.getRGB());
        this.drawCenteredString(lllllllllllllIIIlIlllIIIllIlllII, lllllllllllllIIIlIlllIIIllIlIllI, lllllllllllllIIIlIlllIIIllIlIlIl - 1.0f, Color.BLACK.getRGB());
        this.drawCenteredString(lllllllllllllIIIlIlllIIIllIlllII, lllllllllllllIIIlIlllIIIllIlIllI, lllllllllllllIIIlIlllIIIllIlIlIl + 1.0f, Color.BLACK.getRGB());
        this.drawCenteredString(lllllllllllllIIIlIlllIIIllIlllII, lllllllllllllIIIlIlllIIIllIlIllI, lllllllllllllIIIlIlllIIIllIlIlIl, lllllllllllllIIIlIlllIIIllIlIlII);
    }
    
    public void drawCenteredStringWithOutline(final String lllllllllllllIIIlIlllIIIIIIIIIll, final float lllllllllllllIIIlIlllIIIIIIIIlll, final float lllllllllllllIIIlIlllIIIIIIIIIIl, final int lllllllllllllIIIlIlllIIIIIIIIlIl) {
        this.drawCenteredString(lllllllllllllIIIlIlllIIIIIIIIIll, lllllllllllllIIIlIlllIIIIIIIIlll - 0.5f, lllllllllllllIIIlIlllIIIIIIIIIIl, Color.BLACK.getRGB());
        this.drawCenteredString(lllllllllllllIIIlIlllIIIIIIIIIll, lllllllllllllIIIlIlllIIIIIIIIlll + 0.5f, lllllllllllllIIIlIlllIIIIIIIIIIl, Color.BLACK.getRGB());
        this.drawCenteredString(lllllllllllllIIIlIlllIIIIIIIIIll, lllllllllllllIIIlIlllIIIIIIIIlll, lllllllllllllIIIlIlllIIIIIIIIIIl - 0.5f, Color.BLACK.getRGB());
        this.drawCenteredString(lllllllllllllIIIlIlllIIIIIIIIIll, lllllllllllllIIIlIlllIIIIIIIIlll, lllllllllllllIIIlIlllIIIIIIIIIIl + 0.5f, Color.BLACK.getRGB());
        this.drawCenteredString(lllllllllllllIIIlIlllIIIIIIIIIll, lllllllllllllIIIlIlllIIIIIIIIlll, lllllllllllllIIIlIlllIIIIIIIIIIl, lllllllllllllIIIlIlllIIIIIIIIlIl);
    }
    
    public void drawStringWithOutline(final String lllllllllllllIIIlIlllIIIIIIlIIlI, final double lllllllllllllIIIlIlllIIIIIIlIllI, final double lllllllllllllIIIlIlllIIIIIIlIlIl, final int lllllllllllllIIIlIlllIIIIIIlIlII) {
        this.drawString(lllllllllllllIIIlIlllIIIIIIlIIlI, lllllllllllllIIIlIlllIIIIIIlIllI - 0.5, lllllllllllllIIIlIlllIIIIIIlIlIl, Color.BLACK.getRGB(), false);
        this.drawString(lllllllllllllIIIlIlllIIIIIIlIIlI, lllllllllllllIIIlIlllIIIIIIlIllI + 0.5, lllllllllllllIIIlIlllIIIIIIlIlIl, Color.BLACK.getRGB(), false);
        this.drawString(lllllllllllllIIIlIlllIIIIIIlIIlI, lllllllllllllIIIlIlllIIIIIIlIllI, lllllllllllllIIIlIlllIIIIIIlIlIl - 0.5, Color.BLACK.getRGB(), false);
        this.drawString(lllllllllllllIIIlIlllIIIIIIlIIlI, lllllllllllllIIIlIlllIIIIIIlIllI, lllllllllllllIIIlIlllIIIIIIlIlIl + 0.5, Color.BLACK.getRGB(), false);
        this.drawString(lllllllllllllIIIlIlllIIIIIIlIIlI, lllllllllllllIIIlIlllIIIIIIlIllI, lllllllllllllIIIlIlllIIIIIIlIlIl, lllllllllllllIIIlIlllIIIIIIlIlII, false);
    }
    
    public static void drawCenteredStringWithOutline(final net.minecraft.client.gui.FontRenderer lllllllllllllIIIlIlllIIIllllIlll, final String lllllllllllllIIIlIlllIIIllllIllI, final float lllllllllllllIIIlIlllIIIllllIlIl, final float lllllllllllllIIIlIlllIIIlllllIIl, final int lllllllllllllIIIlIlllIIIllllIIll) {
        lllllllllllllIIIlIlllIIIllllIlll.drawCenteredString(lllllllllllllIIIlIlllIIIllllIllI, lllllllllllllIIIlIlllIIIllllIlIl - 1.0f, lllllllllllllIIIlIlllIIIlllllIIl, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIIllllIlll.drawCenteredString(lllllllllllllIIIlIlllIIIllllIllI, lllllllllllllIIIlIlllIIIllllIlIl + 1.0f, lllllllllllllIIIlIlllIIIlllllIIl, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIIllllIlll.drawCenteredString(lllllllllllllIIIlIlllIIIllllIllI, lllllllllllllIIIlIlllIIIllllIlIl, lllllllllllllIIIlIlllIIIlllllIIl - 1.0f, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIIllllIlll.drawCenteredString(lllllllllllllIIIlIlllIIIllllIllI, lllllllllllllIIIlIlllIIIllllIlIl, lllllllllllllIIIlIlllIIIlllllIIl + 1.0f, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIIllllIlll.drawCenteredString(lllllllllllllIIIlIlllIIIllllIllI, lllllllllllllIIIlIlllIIIllllIlIl, lllllllllllllIIIlIlllIIIlllllIIl, lllllllllllllIIIlIlllIIIllllIIll);
    }
    
    @Override
    public int getStringWidth(final String lllllllllllllIIIlIlllIIIIlIlIlIl) {
        int lllllllllllllIIIlIlllIIIIlIlIlII = 0;
        CharData[] lllllllllllllIIIlIlllIIIIlIlIIll = this.charData;
        boolean lllllllllllllIIIlIlllIIIIlIlIIlI = false;
        boolean lllllllllllllIIIlIlllIIIIlIlIIIl = false;
        for (int lllllllllllllIIIlIlllIIIIlIlIIII = lllllllllllllIIIlIlllIIIIlIlIlIl.length(), lllllllllllllIIIlIlllIIIIlIIllll = 0; lllllllllllllIIIlIlllIIIIlIIllll < lllllllllllllIIIlIlllIIIIlIlIIII; ++lllllllllllllIIIlIlllIIIIlIIllll) {
            final char lllllllllllllIIIlIlllIIIIlIIlllI = lllllllllllllIIIlIlllIIIIlIlIlIl.charAt(lllllllllllllIIIlIlllIIIIlIIllll);
            if (String.valueOf(lllllllllllllIIIlIlllIIIIlIIlllI).equals("§")) {
                final int lllllllllllllIIIlIlllIIIIlIIllIl = "0123456789abcdefklmnor".indexOf(lllllllllllllIIIlIlllIIIIlIIlllI);
                if (lllllllllllllIIIlIlllIIIIlIIllIl < 16) {
                    lllllllllllllIIIlIlllIIIIlIlIIlI = false;
                    lllllllllllllIIIlIlllIIIIlIlIIIl = false;
                }
                else if (lllllllllllllIIIlIlllIIIIlIIllIl == 17) {
                    lllllllllllllIIIlIlllIIIIlIlIIlI = true;
                    lllllllllllllIIIlIlllIIIIlIlIIll = (lllllllllllllIIIlIlllIIIIlIlIIIl ? this.boldItalicChars : this.boldChars);
                }
                else if (lllllllllllllIIIlIlllIIIIlIIllIl == 20) {
                    lllllllllllllIIIlIlllIIIIlIlIIIl = true;
                    lllllllllllllIIIlIlllIIIIlIlIIll = (lllllllllllllIIIlIlllIIIIlIlIIlI ? this.boldItalicChars : this.italicChars);
                }
                else if (lllllllllllllIIIlIlllIIIIlIIllIl == 21) {
                    lllllllllllllIIIlIlllIIIIlIlIIlI = false;
                    lllllllllllllIIIlIlllIIIIlIlIIIl = false;
                    lllllllllllllIIIlIlllIIIIlIlIIll = this.charData;
                }
                ++lllllllllllllIIIlIlllIIIIlIIllll;
            }
            else if (lllllllllllllIIIlIlllIIIIlIIlllI < lllllllllllllIIIlIlllIIIIlIlIIll.length) {
                lllllllllllllIIIlIlllIIIIlIlIlII += lllllllllllllIIIlIlllIIIIlIlIIll[lllllllllllllIIIlIlllIIIIlIIlllI].width - 8 + this.charOffset;
            }
        }
        return lllllllllllllIIIlIlllIIIIlIlIlII / 2;
    }
    
    public static void drawStringWithOutline(final FontRenderer lllllllllllllIIIlIlllIIlIIIlIlIl, final String lllllllllllllIIIlIlllIIlIIIllIIl, final float lllllllllllllIIIlIlllIIlIIIllIII, final float lllllllllllllIIIlIlllIIlIIIlIlll, final int lllllllllllllIIIlIlllIIlIIIlIllI) {
        lllllllllllllIIIlIlllIIlIIIlIlIl.drawString(lllllllllllllIIIlIlllIIlIIIllIIl, lllllllllllllIIIlIlllIIlIIIllIII - 0.8f, lllllllllllllIIIlIlllIIlIIIlIlll, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIlIIIlIlIl.drawString(lllllllllllllIIIlIlllIIlIIIllIIl, lllllllllllllIIIlIlllIIlIIIllIII + 0.8f, lllllllllllllIIIlIlllIIlIIIlIlll, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIlIIIlIlIl.drawString(lllllllllllllIIIlIlllIIlIIIllIIl, lllllllllllllIIIlIlllIIlIIIllIII, lllllllllllllIIIlIlllIIlIIIlIlll - 0.8f, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIlIIIlIlIl.drawString(lllllllllllllIIIlIlllIIlIIIllIIl, lllllllllllllIIIlIlllIIlIIIllIII, lllllllllllllIIIlIlllIIlIIIlIlll + 0.8f, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIlIIIlIlIl.drawString(lllllllllllllIIIlIlllIIlIIIllIIl, lllllllllllllIIIlIlllIIlIIIllIII, lllllllllllllIIIlIlllIIlIIIlIlll, lllllllllllllIIIlIlllIIlIIIlIllI);
    }
    
    public float drawStringWithShadow(final String lllllllllllllIIIlIlllIIIllIIIllI, final double lllllllllllllIIIlIlllIIIllIIIlIl, final double lllllllllllllIIIlIlllIIIllIIIlII, final int lllllllllllllIIIlIlllIIIllIIlIIl) {
        final float lllllllllllllIIIlIlllIIIllIIlIII = this.drawString(lllllllllllllIIIlIlllIIIllIIIllI, lllllllllllllIIIlIlllIIIllIIIlIl + 0.9, lllllllllllllIIIlIlllIIIllIIIlII + 0.7, lllllllllllllIIIlIlllIIIllIIlIIl, true);
        return Math.max(lllllllllllllIIIlIlllIIIllIIlIII, this.drawString(lllllllllllllIIIlIlllIIIllIIIllI, lllllllllllllIIIlIlllIIIllIIIlIl, lllllllllllllIIIlIlllIIIllIIIlII, lllllllllllllIIIlIlllIIIllIIlIIl, false));
    }
    
    public static void drawStringWithOutline(final net.minecraft.client.gui.FontRenderer lllllllllllllIIIlIlllIIlIIIIlIll, final String lllllllllllllIIIlIlllIIlIIIIlIlI, final float lllllllllllllIIIlIlllIIlIIIIlIIl, final float lllllllllllllIIIlIlllIIlIIIIlIII, final int lllllllllllllIIIlIlllIIlIIIIIlll) {
        lllllllllllllIIIlIlllIIlIIIIlIll.drawString(lllllllllllllIIIlIlllIIlIIIIlIlI, lllllllllllllIIIlIlllIIlIIIIlIIl - 1.0f, lllllllllllllIIIlIlllIIlIIIIlIII, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIlIIIIlIll.drawString(lllllllllllllIIIlIlllIIlIIIIlIlI, lllllllllllllIIIlIlllIIlIIIIlIIl + 1.0f, lllllllllllllIIIlIlllIIlIIIIlIII, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIlIIIIlIll.drawString(lllllllllllllIIIlIlllIIlIIIIlIlI, lllllllllllllIIIlIlllIIlIIIIlIIl, lllllllllllllIIIlIlllIIlIIIIlIII - 1.0f, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIlIIIIlIll.drawString(lllllllllllllIIIlIlllIIlIIIIlIlI, lllllllllllllIIIlIlllIIlIIIIlIIl, lllllllllllllIIIlIlllIIlIIIIlIII + 1.0f, Color.BLACK.getRGB());
        lllllllllllllIIIlIlllIIlIIIIlIll.drawString(lllllllllllllIIIlIlllIIlIIIIlIlI, lllllllllllllIIIlIlllIIlIIIIlIIl, lllllllllllllIIIlIlllIIlIIIIlIII, lllllllllllllIIIlIlllIIlIIIIIlll);
    }
    
    @Override
    public void setFont(final Font lllllllllllllIIIlIlllIIIIIllllll) {
        super.setFont(lllllllllllllIIIlIlllIIIIIllllll);
        this.setupBoldItalicIDs();
    }
    
    private void drawLine(final double lllllllllllllIIIlIlllIIIIIlIIIlI, final double lllllllllllllIIIlIlllIIIIIlIIllI, final double lllllllllllllIIIlIlllIIIIIlIIlIl, final double lllllllllllllIIIlIlllIIIIIIlllll, final float lllllllllllllIIIlIlllIIIIIIllllI) {
        GL11.glDisable(3553);
        GL11.glLineWidth(lllllllllllllIIIlIlllIIIIIIllllI);
        GL11.glBegin(1);
        GL11.glVertex2d(lllllllllllllIIIlIlllIIIIIlIIIlI, lllllllllllllIIIlIlllIIIIIlIIllI);
        GL11.glVertex2d(lllllllllllllIIIlIlllIIIIIlIIlIl, lllllllllllllIIIlIlllIIIIIIlllll);
        GL11.glEnd();
        GL11.glEnable(3553);
    }
    
    public float drawCenteredString(final String lllllllllllllIIIlIlllIIIlIlIllII, final float lllllllllllllIIIlIlllIIIlIlIIllI, final float lllllllllllllIIIlIlllIIIlIlIIlIl, final int lllllllllllllIIIlIlllIIIlIlIIlII) {
        return this.drawString(lllllllllllllIIIlIlllIIIlIlIllII, lllllllllllllIIIlIlllIIIlIlIIllI - this.getStringWidth(lllllllllllllIIIlIlllIIIlIlIllII) / 2.0f, lllllllllllllIIIlIlllIIIlIlIIlIl, lllllllllllllIIIlIlllIIIlIlIIlII);
    }
    
    public FontRenderer(final Font lllllllllllllIIIlIlllIIlIIlIIlll, final boolean lllllllllllllIIIlIlllIIlIIlIllll, final boolean lllllllllllllIIIlIlllIIlIIlIIlIl) {
        super(lllllllllllllIIIlIlllIIlIIlIIlll, lllllllllllllIIIlIlllIIlIIlIllll, lllllllllllllIIIlIlllIIlIIlIIlIl);
        this.colorCode = new int[32];
        this.boldChars = new CharData[256];
        this.italicChars = new CharData[256];
        this.boldItalicChars = new CharData[256];
        this.setupBoldItalicIDs();
        for (int lllllllllllllIIIlIlllIIlIIlIllIl = 0; lllllllllllllIIIlIlllIIlIIlIllIl < 32; ++lllllllllllllIIIlIlllIIlIIlIllIl) {
            final int lllllllllllllIIIlIlllIIlIIlIllII = (lllllllllllllIIIlIlllIIlIIlIllIl >> 3 & 0x1) * 85;
            int lllllllllllllIIIlIlllIIlIIlIlIll = (lllllllllllllIIIlIlllIIlIIlIllIl >> 2 & 0x1) * 170 + lllllllllllllIIIlIlllIIlIIlIllII;
            int lllllllllllllIIIlIlllIIlIIlIlIlI = (lllllllllllllIIIlIlllIIlIIlIllIl >> 1 & 0x1) * 170 + lllllllllllllIIIlIlllIIlIIlIllII;
            int lllllllllllllIIIlIlllIIlIIlIlIIl = (lllllllllllllIIIlIlllIIlIIlIllIl & 0x1) * 170 + lllllllllllllIIIlIlllIIlIIlIllII;
            if (lllllllllllllIIIlIlllIIlIIlIllIl == 6) {
                lllllllllllllIIIlIlllIIlIIlIlIll += 85;
            }
            if (lllllllllllllIIIlIlllIIlIIlIllIl >= 16) {
                lllllllllllllIIIlIlllIIlIIlIlIll /= 4;
                lllllllllllllIIIlIlllIIlIIlIlIlI /= 4;
                lllllllllllllIIIlIlllIIlIIlIlIIl /= 4;
            }
            this.colorCode[lllllllllllllIIIlIlllIIlIIlIllIl] = ((lllllllllllllIIIlIlllIIlIIlIlIll & 0xFF) << 16 | (lllllllllllllIIIlIlllIIlIIlIlIlI & 0xFF) << 8 | (lllllllllllllIIIlIlllIIlIIlIlIIl & 0xFF));
        }
    }
}
