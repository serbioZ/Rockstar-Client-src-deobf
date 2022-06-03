// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.font;

import org.lwjgl.opengl.GL11;
import java.awt.geom.Rectangle2D;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Font;
import net.minecraft.client.renderer.texture.DynamicTexture;

public class CFont
{
    protected /* synthetic */ int fontHeight;
    protected /* synthetic */ boolean antiAlias;
    protected /* synthetic */ int charOffset;
    protected /* synthetic */ DynamicTexture tex;
    protected /* synthetic */ CharData[] charData;
    protected /* synthetic */ Font font;
    protected /* synthetic */ boolean fractionalMetrics;
    
    public void drawChar(final CharData[] lllllllllllIIlllIIlllllllIlIIllI, final char lllllllllllIIlllIIlllllllIIlllll, final float lllllllllllIIlllIIlllllllIIllllI, final float lllllllllllIIlllIIlllllllIIlllIl) throws ArrayIndexOutOfBoundsException {
        try {
            this.drawQuad(lllllllllllIIlllIIlllllllIIllllI, lllllllllllIIlllIIlllllllIIlllIl, (float)lllllllllllIIlllIIlllllllIlIIllI[lllllllllllIIlllIIlllllllIIlllll].width, (float)lllllllllllIIlllIIlllllllIlIIllI[lllllllllllIIlllIIlllllllIIlllll].height, (float)lllllllllllIIlllIIlllllllIlIIllI[lllllllllllIIlllIIlllllllIIlllll].storedX, (float)lllllllllllIIlllIIlllllllIlIIllI[lllllllllllIIlllIIlllllllIIlllll].storedY, (float)lllllllllllIIlllIIlllllllIlIIllI[lllllllllllIIlllIIlllllllIIlllll].width, (float)lllllllllllIIlllIIlllllllIlIIllI[lllllllllllIIlllIIlllllllIIlllll].height);
        }
        catch (Exception lllllllllllIIlllIIlllllllIlIIIlI) {
            lllllllllllIIlllIIlllllllIlIIIlI.printStackTrace();
        }
    }
    
    public boolean isAntiAlias() {
        return this.antiAlias;
    }
    
    public Font getFont() {
        return this.font;
    }
    
    public void setAntiAlias(final boolean lllllllllllIIlllIIllllllIlIlIlIl) {
        if (this.antiAlias != lllllllllllIIlllIIllllllIlIlIlIl) {
            this.antiAlias = lllllllllllIIlllIIllllllIlIlIlIl;
            this.tex = this.setupTexture(this.font, lllllllllllIIlllIIllllllIlIlIlIl, this.fractionalMetrics, this.charData);
        }
    }
    
    public int getStringHeight(final String lllllllllllIIlllIIllllllIlllIlII) {
        return this.getFontHeight();
    }
    
    public void setFractionalMetrics(final boolean lllllllllllIIlllIIllllllIlIIlllI) {
        if (this.fractionalMetrics != lllllllllllIIlllIIllllllIlIIlllI) {
            this.fractionalMetrics = lllllllllllIIlllIIllllllIlIIlllI;
            this.tex = this.setupTexture(this.font, this.antiAlias, lllllllllllIIlllIIllllllIlIIlllI, this.charData);
        }
    }
    
    public int getStringWidth(final String lllllllllllIIlllIIllllllIllIIIll) {
        int lllllllllllIIlllIIllllllIllIIllI = 0;
        final boolean lllllllllllIIlllIIllllllIlIllllI;
        final byte lllllllllllIIlllIIllllllIlIlllll = (byte)((char[])(Object)(lllllllllllIIlllIIllllllIlIllllI = (boolean)(Object)lllllllllllIIlllIIllllllIllIIIll.toCharArray())).length;
        for (char lllllllllllIIlllIIllllllIllIIIII = '\0'; lllllllllllIIlllIIllllllIllIIIII < lllllllllllIIlllIIllllllIlIlllll; ++lllllllllllIIlllIIllllllIllIIIII) {
            final char lllllllllllIIlllIIllllllIllIIlIl = lllllllllllIIlllIIllllllIlIllllI[lllllllllllIIlllIIllllllIllIIIII];
            if (lllllllllllIIlllIIllllllIllIIlIl < this.charData.length) {
                lllllllllllIIlllIIllllllIllIIllI += this.charData[lllllllllllIIlllIIllllllIllIIlIl].width - 8 + this.charOffset;
            }
        }
        return lllllllllllIIlllIIllllllIllIIllI / 2;
    }
    
    protected BufferedImage generateFontImage(final Font lllllllllllIIlllIIlllllllIllllII, final boolean lllllllllllIIlllIIllllllllIIlIll, final boolean lllllllllllIIlllIIlllllllIlllIlI, final CharData[] lllllllllllIIlllIIllllllllIIlIIl) {
        final int lllllllllllIIlllIIllllllllIIlIII = 512;
        final BufferedImage lllllllllllIIlllIIllllllllIIIlll = new BufferedImage(lllllllllllIIlllIIllllllllIIlIII, lllllllllllIIlllIIllllllllIIlIII, 2);
        final Graphics2D lllllllllllIIlllIIllllllllIIIllI = (Graphics2D)lllllllllllIIlllIIllllllllIIIlll.getGraphics();
        lllllllllllIIlllIIllllllllIIIllI.setFont(lllllllllllIIlllIIlllllllIllllII);
        lllllllllllIIlllIIllllllllIIIllI.setColor(new Color(255, 255, 255, 0));
        lllllllllllIIlllIIllllllllIIIllI.fillRect(0, 0, lllllllllllIIlllIIllllllllIIlIII, lllllllllllIIlllIIllllllllIIlIII);
        lllllllllllIIlllIIllllllllIIIllI.setColor(Color.WHITE);
        lllllllllllIIlllIIllllllllIIIllI.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, lllllllllllIIlllIIlllllllIlllIlI ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        lllllllllllIIlllIIllllllllIIIllI.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, lllllllllllIIlllIIllllllllIIlIll ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        lllllllllllIIlllIIllllllllIIIllI.setRenderingHint(RenderingHints.KEY_ANTIALIASING, lllllllllllIIlllIIllllllllIIlIll ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        final FontMetrics lllllllllllIIlllIIllllllllIIIlIl = lllllllllllIIlllIIllllllllIIIllI.getFontMetrics();
        int lllllllllllIIlllIIllllllllIIIlII = 0;
        int lllllllllllIIlllIIllllllllIIIIll = 0;
        int lllllllllllIIlllIIllllllllIIIIlI = 1;
        for (int lllllllllllIIlllIIllllllllIIIIIl = 0; lllllllllllIIlllIIllllllllIIIIIl < lllllllllllIIlllIIllllllllIIlIIl.length; ++lllllllllllIIlllIIllllllllIIIIIl) {
            final char lllllllllllIIlllIIllllllllIIIIII = (char)lllllllllllIIlllIIllllllllIIIIIl;
            final CharData lllllllllllIIlllIIlllllllIllllll = new CharData();
            final Rectangle2D lllllllllllIIlllIIlllllllIlllllI = lllllllllllIIlllIIllllllllIIIlIl.getStringBounds(String.valueOf(lllllllllllIIlllIIllllllllIIIIII), lllllllllllIIlllIIllllllllIIIllI);
            lllllllllllIIlllIIlllllllIllllll.width = lllllllllllIIlllIIlllllllIlllllI.getBounds().width + 8;
            lllllllllllIIlllIIlllllllIllllll.height = lllllllllllIIlllIIlllllllIlllllI.getBounds().height;
            if (lllllllllllIIlllIIllllllllIIIIll + lllllllllllIIlllIIlllllllIllllll.width >= lllllllllllIIlllIIllllllllIIlIII) {
                lllllllllllIIlllIIllllllllIIIIll = 0;
                lllllllllllIIlllIIllllllllIIIIlI += lllllllllllIIlllIIllllllllIIIlII;
                lllllllllllIIlllIIllllllllIIIlII = 0;
            }
            if (lllllllllllIIlllIIlllllllIllllll.height > lllllllllllIIlllIIllllllllIIIlII) {
                lllllllllllIIlllIIllllllllIIIlII = lllllllllllIIlllIIlllllllIllllll.height;
            }
            lllllllllllIIlllIIlllllllIllllll.storedX = lllllllllllIIlllIIllllllllIIIIll;
            lllllllllllIIlllIIlllllllIllllll.storedY = lllllllllllIIlllIIllllllllIIIIlI;
            if (lllllllllllIIlllIIlllllllIllllll.height > this.fontHeight) {
                this.fontHeight = lllllllllllIIlllIIlllllllIllllll.height;
            }
            lllllllllllIIlllIIllllllllIIlIIl[lllllllllllIIlllIIllllllllIIIIIl] = lllllllllllIIlllIIlllllllIllllll;
            lllllllllllIIlllIIllllllllIIIllI.drawString(String.valueOf(lllllllllllIIlllIIllllllllIIIIII), lllllllllllIIlllIIllllllllIIIIll + 2, lllllllllllIIlllIIllllllllIIIIlI + lllllllllllIIlllIIllllllllIIIlIl.getAscent());
            lllllllllllIIlllIIllllllllIIIIll += lllllllllllIIlllIIlllllllIllllll.width;
        }
        return lllllllllllIIlllIIllllllllIIIlll;
    }
    
    protected DynamicTexture setupTexture(final Font lllllllllllIIlllIIlllllllllIlIlI, final boolean lllllllllllIIlllIIlllllllllIlIIl, final boolean lllllllllllIIlllIIlllllllllIIIIl, final CharData[] lllllllllllIIlllIIlllllllllIIIII) {
        final BufferedImage lllllllllllIIlllIIlllllllllIIllI = this.generateFontImage(lllllllllllIIlllIIlllllllllIlIlI, lllllllllllIIlllIIlllllllllIlIIl, lllllllllllIIlllIIlllllllllIIIIl, lllllllllllIIlllIIlllllllllIIIII);
        try {
            return new DynamicTexture(lllllllllllIIlllIIlllllllllIIllI);
        }
        catch (Exception lllllllllllIIlllIIlllllllllIIlIl) {
            lllllllllllIIlllIIlllllllllIIlIl.printStackTrace();
            return null;
        }
    }
    
    public CFont(final Font lllllllllllIIlllIIlllllllllllIIl, final boolean lllllllllllIIlllIIllllllllllIlII, final boolean lllllllllllIIlllIIllllllllllIIll) {
        this.charData = new CharData[256];
        this.fontHeight = -1;
        this.charOffset = 0;
        this.font = lllllllllllIIlllIIlllllllllllIIl;
        this.antiAlias = lllllllllllIIlllIIllllllllllIlII;
        this.fractionalMetrics = lllllllllllIIlllIIllllllllllIIll;
        this.tex = this.setupTexture(lllllllllllIIlllIIlllllllllllIIl, lllllllllllIIlllIIllllllllllIlII, lllllllllllIIlllIIllllllllllIIll, this.charData);
    }
    
    public boolean isFractionalMetrics() {
        return this.fractionalMetrics;
    }
    
    public int getFontHeight() {
        return (this.fontHeight - 8) / 2;
    }
    
    protected void drawQuad(final float lllllllllllIIlllIIlllllllIIIIIlI, final float lllllllllllIIlllIIlllllllIIIllIl, final float lllllllllllIIlllIIlllllllIIIIIII, final float lllllllllllIIlllIIllllllIlllllll, final float lllllllllllIIlllIIlllllllIIIlIlI, final float lllllllllllIIlllIIllllllIlllllIl, final float lllllllllllIIlllIIllllllIlllllII, final float lllllllllllIIlllIIlllllllIIIIlll) {
        final float lllllllllllIIlllIIlllllllIIIIllI = lllllllllllIIlllIIlllllllIIIlIlI / 512.0f;
        final float lllllllllllIIlllIIlllllllIIIIlIl = lllllllllllIIlllIIllllllIlllllIl / 512.0f;
        final float lllllllllllIIlllIIlllllllIIIIlII = lllllllllllIIlllIIllllllIlllllII / 512.0f;
        final float lllllllllllIIlllIIlllllllIIIIIll = lllllllllllIIlllIIlllllllIIIIlll / 512.0f;
        GL11.glTexCoord2f(lllllllllllIIlllIIlllllllIIIIllI + lllllllllllIIlllIIlllllllIIIIlII, lllllllllllIIlllIIlllllllIIIIlIl);
        GL11.glVertex2d((double)(lllllllllllIIlllIIlllllllIIIIIlI + lllllllllllIIlllIIlllllllIIIIIII), (double)lllllllllllIIlllIIlllllllIIIllIl);
        GL11.glTexCoord2f(lllllllllllIIlllIIlllllllIIIIllI, lllllllllllIIlllIIlllllllIIIIlIl);
        GL11.glVertex2d((double)lllllllllllIIlllIIlllllllIIIIIlI, (double)lllllllllllIIlllIIlllllllIIIllIl);
        GL11.glTexCoord2f(lllllllllllIIlllIIlllllllIIIIllI, lllllllllllIIlllIIlllllllIIIIlIl + lllllllllllIIlllIIlllllllIIIIIll);
        GL11.glVertex2d((double)lllllllllllIIlllIIlllllllIIIIIlI, (double)(lllllllllllIIlllIIlllllllIIIllIl + lllllllllllIIlllIIllllllIlllllll));
        GL11.glTexCoord2f(lllllllllllIIlllIIlllllllIIIIllI, lllllllllllIIlllIIlllllllIIIIlIl + lllllllllllIIlllIIlllllllIIIIIll);
        GL11.glVertex2d((double)lllllllllllIIlllIIlllllllIIIIIlI, (double)(lllllllllllIIlllIIlllllllIIIllIl + lllllllllllIIlllIIllllllIlllllll));
        GL11.glTexCoord2f(lllllllllllIIlllIIlllllllIIIIllI + lllllllllllIIlllIIlllllllIIIIlII, lllllllllllIIlllIIlllllllIIIIlIl + lllllllllllIIlllIIlllllllIIIIIll);
        GL11.glVertex2d((double)(lllllllllllIIlllIIlllllllIIIIIlI + lllllllllllIIlllIIlllllllIIIIIII), (double)(lllllllllllIIlllIIlllllllIIIllIl + lllllllllllIIlllIIllllllIlllllll));
        GL11.glTexCoord2f(lllllllllllIIlllIIlllllllIIIIllI + lllllllllllIIlllIIlllllllIIIIlII, lllllllllllIIlllIIlllllllIIIIlIl);
        GL11.glVertex2d((double)(lllllllllllIIlllIIlllllllIIIIIlI + lllllllllllIIlllIIlllllllIIIIIII), (double)lllllllllllIIlllIIlllllllIIIllIl);
    }
    
    public void setFont(final Font lllllllllllIIlllIIllllllIlIIIIll) {
        this.font = lllllllllllIIlllIIllllllIlIIIIll;
        this.tex = this.setupTexture(lllllllllllIIlllIIllllllIlIIIIll, this.antiAlias, this.fractionalMetrics, this.charData);
    }
    
    protected static class CharData
    {
        public /* synthetic */ int width;
        public /* synthetic */ int storedX;
        public /* synthetic */ int height;
        public /* synthetic */ int storedY;
    }
}
