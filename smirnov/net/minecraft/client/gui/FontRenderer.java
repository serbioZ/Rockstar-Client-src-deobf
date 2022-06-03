// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import java.awt.Color;
import com.ibm.icu.text.ArabicShapingException;
import com.ibm.icu.text.Bidi;
import com.ibm.icu.text.ArabicShaping;
import org.apache.commons.io.IOUtils;
import java.util.Arrays;
import java.util.List;
import net.minecraft.util.text.TextFormatting;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.NameProtect;
import ru.rockstar.Main;
import java.io.IOException;
import java.io.InputStream;
import optifine.CustomColors;
import optifine.Config;
import optifine.FontUtils;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.renderer.GlStateManager;
import java.util.Random;
import optifine.GlBlendState;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class FontRenderer implements IResourceManagerReloadListener
{
    public /* synthetic */ float blue;
    private /* synthetic */ boolean italicStyle;
    private final /* synthetic */ TextureManager renderEngine;
    private /* synthetic */ boolean randomStyle;
    private final /* synthetic */ int[] colorCode;
    public /* synthetic */ boolean enabled;
    private /* synthetic */ boolean blend;
    private /* synthetic */ ResourceLocation locationFontTexture;
    public /* synthetic */ float offsetBold;
    private /* synthetic */ boolean underlineStyle;
    private /* synthetic */ int textColor;
    public /* synthetic */ int FONT_HEIGHT;
    public /* synthetic */ float alpha;
    public /* synthetic */ float red;
    private static final /* synthetic */ ResourceLocation[] unicodePageLocations;
    public /* synthetic */ boolean bidiFlag;
    public /* synthetic */ ResourceLocation locationFontTextureBase;
    private final /* synthetic */ float[] charWidth;
    public /* synthetic */ GameSettings gameSettings;
    public /* synthetic */ float posY;
    public /* synthetic */ float posX;
    public /* synthetic */ float green;
    private /* synthetic */ boolean unicodeFlag;
    private /* synthetic */ boolean strikethroughStyle;
    private final /* synthetic */ float[] charWidthFloat;
    private final /* synthetic */ GlBlendState oldBlendState;
    public /* synthetic */ Random fontRandom;
    private /* synthetic */ boolean boldStyle;
    private final /* synthetic */ byte[] glyphWidth;
    
    protected void setColor(final float llllllllllIllllIIlIIIlIlIllIIIll, final float llllllllllIllllIIlIIIlIlIlIllllI, final float llllllllllIllllIIlIIIlIlIlIlllIl, final float llllllllllIllllIIlIIIlIlIlIlllII) {
        GlStateManager.color(llllllllllIllllIIlIIIlIlIllIIIll, llllllllllIllllIIlIIIlIlIlIllllI, llllllllllIllllIIlIIIlIlIlIlllIl, llllllllllIllllIIlIIIlIlIlIlllII);
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllIllllIIlIIIlllllIIIIll) {
        this.locationFontTexture = FontUtils.getHdFontLocation(this.locationFontTextureBase);
        for (int llllllllllIllllIIlIIIlllllIIIIlI = 0; llllllllllIllllIIlIIIlllllIIIIlI < FontRenderer.unicodePageLocations.length; ++llllllllllIllllIIlIIIlllllIIIIlI) {
            FontRenderer.unicodePageLocations[llllllllllIllllIIlIIIlllllIIIIlI] = null;
        }
        this.readFontTexture();
        this.readGlyphSizes();
    }
    
    private void renderSplitString(final String llllllllllIllllIIlIIIlIllllllIIl, final int llllllllllIllllIIlIIIlIllllllIII, int llllllllllIllllIIlIIIlIlllllIlll, final int llllllllllIllllIIlIIIlIlllllllIl, final boolean llllllllllIllllIIlIIIlIlllllIlIl) {
        for (final String llllllllllIllllIIlIIIlIllllllIll : this.listFormattedStringToWidth(llllllllllIllllIIlIIIlIllllllIIl, llllllllllIllllIIlIIIlIlllllllIl)) {
            this.renderStringAligned(llllllllllIllllIIlIIIlIllllllIll, llllllllllIllllIIlIIIlIllllllIII, llllllllllIllllIIlIIIlIlllllIlll, llllllllllIllllIIlIIIlIlllllllIl, this.textColor, llllllllllIllllIIlIIIlIlllllIlIl);
            llllllllllIllllIIlIIIlIlllllIlll += this.FONT_HEIGHT;
        }
    }
    
    public String trimStringToWidth(final String llllllllllIllllIIlIIIllIIIlllIII, final int llllllllllIllllIIlIIIllIIIllIlll, final boolean llllllllllIllllIIlIIIllIIIlIlIIl) {
        final StringBuilder llllllllllIllllIIlIIIllIIIllIlIl = new StringBuilder();
        float llllllllllIllllIIlIIIllIIIllIlII = 0.0f;
        final int llllllllllIllllIIlIIIllIIIllIIll = llllllllllIllllIIlIIIllIIIlIlIIl ? (llllllllllIllllIIlIIIllIIIlllIII.length() - 1) : 0;
        final int llllllllllIllllIIlIIIllIIIllIIlI = llllllllllIllllIIlIIIllIIIlIlIIl ? -1 : 1;
        boolean llllllllllIllllIIlIIIllIIIllIIIl = false;
        boolean llllllllllIllllIIlIIIllIIIllIIII = false;
        for (int llllllllllIllllIIlIIIllIIIlIllll = llllllllllIllllIIlIIIllIIIllIIll; llllllllllIllllIIlIIIllIIIlIllll >= 0 && llllllllllIllllIIlIIIllIIIlIllll < llllllllllIllllIIlIIIllIIIlllIII.length() && llllllllllIllllIIlIIIllIIIllIlII < llllllllllIllllIIlIIIllIIIllIlll; llllllllllIllllIIlIIIllIIIlIllll += llllllllllIllllIIlIIIllIIIllIIlI) {
            final char llllllllllIllllIIlIIIllIIIlIlllI = llllllllllIllllIIlIIIllIIIlllIII.charAt(llllllllllIllllIIlIIIllIIIlIllll);
            final float llllllllllIllllIIlIIIllIIIlIllIl = this.getCharWidthFloat(llllllllllIllllIIlIIIllIIIlIlllI);
            if (llllllllllIllllIIlIIIllIIIllIIIl) {
                llllllllllIllllIIlIIIllIIIllIIIl = false;
                if (llllllllllIllllIIlIIIllIIIlIlllI != 'l' && llllllllllIllllIIlIIIllIIIlIlllI != 'L') {
                    if (llllllllllIllllIIlIIIllIIIlIlllI == 'r' || llllllllllIllllIIlIIIllIIIlIlllI == 'R') {
                        llllllllllIllllIIlIIIllIIIllIIII = false;
                    }
                }
                else {
                    llllllllllIllllIIlIIIllIIIllIIII = true;
                }
            }
            else if (llllllllllIllllIIlIIIllIIIlIllIl < 0.0f) {
                llllllllllIllllIIlIIIllIIIllIIIl = true;
            }
            else {
                llllllllllIllllIIlIIIllIIIllIlII += llllllllllIllllIIlIIIllIIIlIllIl;
                if (llllllllllIllllIIlIIIllIIIllIIII) {
                    ++llllllllllIllllIIlIIIllIIIllIlII;
                }
            }
            if (llllllllllIllllIIlIIIllIIIllIlII > llllllllllIllllIIlIIIllIIIllIlll) {
                break;
            }
            if (llllllllllIllllIIlIIIllIIIlIlIIl) {
                llllllllllIllllIIlIIIllIIIllIlIl.insert(0, llllllllllIllllIIlIIIllIIIlIlllI);
            }
            else {
                llllllllllIllllIIlIIIllIIIllIlIl.append(llllllllllIllllIIlIIIllIIIlIlllI);
            }
        }
        return llllllllllIllllIIlIIIllIIIllIlIl.toString();
    }
    
    private static boolean isFormatSpecial(final char llllllllllIllllIIlIIIlIllIIIlIII) {
        return (llllllllllIllllIIlIIIlIllIIIlIII >= 'k' && llllllllllIllllIIlIIIlIllIIIlIII <= 'o') || (llllllllllIllllIIlIIIlIllIIIlIII >= 'K' && llllllllllIllllIIlIIIlIllIIIlIII <= 'O') || llllllllllIllllIIlIIIlIllIIIlIII == 'r' || llllllllllIllllIIlIIIlIllIIIlIII == 'R';
    }
    
    private void resetStyles() {
        this.randomStyle = false;
        this.boldStyle = false;
        this.italicStyle = false;
        this.underlineStyle = false;
        this.strikethroughStyle = false;
    }
    
    protected void enableAlpha() {
        GlStateManager.enableAlpha();
    }
    
    private String trimStringNewline(String llllllllllIllllIIlIIIllIIIIlllII) {
        while (llllllllllIllllIIlIIIllIIIIlllII != null && ((String)llllllllllIllllIIlIIIllIIIIlllII).endsWith("\n")) {
            llllllllllIllllIIlIIIllIIIIlllII = ((String)llllllllllIllllIIlIIIllIIIIlllII).substring(0, ((String)llllllllllIllllIIlIIIllIIIIlllII).length() - 1);
        }
        return (String)llllllllllIllllIIlIIIllIIIIlllII;
    }
    
    private float renderChar(final char llllllllllIllllIIlIIIlllIllIlIlI, final boolean llllllllllIllllIIlIIIlllIllIlIIl) {
        if (llllllllllIllllIIlIIIlllIllIlIlI == ' ') {
            return this.unicodeFlag ? 4.0f : this.charWidth[llllllllllIllllIIlIIIlllIllIlIlI];
        }
        final int llllllllllIllllIIlIIIlllIllIllII = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8£\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1ªº¿®¬½¼¡«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f²\u25a0\u0000".indexOf(llllllllllIllllIIlIIIlllIllIlIlI);
        return (llllllllllIllllIIlIIIlllIllIllII != -1 && !this.unicodeFlag) ? this.renderDefaultChar(llllllllllIllllIIlIIIlllIllIllII, llllllllllIllllIIlIIIlllIllIlIIl) : this.renderUnicodeChar(llllllllllIllllIIlIIIlllIllIlIlI, llllllllllIllllIIlIIIlllIllIlIIl);
    }
    
    private int renderStringAligned(final String llllllllllIllllIIlIIIllIlIIlIIlI, int llllllllllIllllIIlIIIllIlIIlIIIl, final int llllllllllIllllIIlIIIllIlIIlIIII, final int llllllllllIllllIIlIIIllIlIIIllll, final int llllllllllIllllIIlIIIllIlIIIlllI, final boolean llllllllllIllllIIlIIIllIlIIlIlIl) {
        if (this.bidiFlag) {
            final int llllllllllIllllIIlIIIllIlIIlIlII = this.getStringWidth(this.bidiReorder(llllllllllIllllIIlIIIllIlIIlIIlI));
            llllllllllIllllIIlIIIllIlIIlIIIl = llllllllllIllllIIlIIIllIlIIlIIIl + llllllllllIllllIIlIIIllIlIIIllll - llllllllllIllllIIlIIIllIlIIlIlII;
        }
        return this.renderString(llllllllllIllllIIlIIIllIlIIlIIlI, (float)llllllllllIllllIIlIIIllIlIIlIIIl, (float)llllllllllIllllIIlIIIllIlIIlIIII, llllllllllIllllIIlIIIllIlIIIlllI, llllllllllIllllIIlIIIllIlIIlIlIl);
    }
    
    public int getColorCode(final char llllllllllIllllIIlIIIlIlIllIllll) {
        final int llllllllllIllllIIlIIIlIlIllIlllI = "0123456789abcdef".indexOf(llllllllllIllllIIlIIIlIlIllIllll);
        if (llllllllllIllllIIlIIIlIlIllIlllI >= 0 && llllllllllIllllIIlIIIlIlIllIlllI < this.colorCode.length) {
            int llllllllllIllllIIlIIIlIlIllIllIl = this.colorCode[llllllllllIllllIIlIIIlIlIllIlllI];
            if (Config.isCustomColors()) {
                llllllllllIllllIIlIIIlIlIllIllIl = CustomColors.getTextColor(llllllllllIllllIIlIIIlIlIllIlllI, llllllllllIllllIIlIIIlIlIllIllIl);
            }
            return llllllllllIllllIIlIIIlIlIllIllIl;
        }
        return 16777215;
    }
    
    private int sizeStringToWidth(final String llllllllllIllllIIlIIIlIllIIlIlIl, final int llllllllllIllllIIlIIIlIllIIllllI) {
        final int llllllllllIllllIIlIIIlIllIIlllIl = llllllllllIllllIIlIIIlIllIIlIlIl.length();
        float llllllllllIllllIIlIIIlIllIIlllII = 0.0f;
        int llllllllllIllllIIlIIIlIllIIllIll = 0;
        int llllllllllIllllIIlIIIlIllIIllIlI = -1;
        boolean llllllllllIllllIIlIIIlIllIIllIIl = false;
        while (llllllllllIllllIIlIIIlIllIIllIll < llllllllllIllllIIlIIIlIllIIlllIl) {
            final char llllllllllIllllIIlIIIlIllIIllIII = llllllllllIllllIIlIIIlIllIIlIlIl.charAt(llllllllllIllllIIlIIIlIllIIllIll);
            Label_0163: {
                switch (llllllllllIllllIIlIIIlIllIIllIII) {
                    case '\n': {
                        --llllllllllIllllIIlIIIlIllIIllIll;
                        break Label_0163;
                    }
                    case ' ': {
                        llllllllllIllllIIlIIIlIllIIllIlI = llllllllllIllllIIlIIIlIllIIllIll;
                        break;
                    }
                    case '§': {
                        if (llllllllllIllllIIlIIIlIllIIllIll >= llllllllllIllllIIlIIIlIllIIlllIl - 1) {
                            break Label_0163;
                        }
                        ++llllllllllIllllIIlIIIlIllIIllIll;
                        final char llllllllllIllllIIlIIIlIllIIlIlll = llllllllllIllllIIlIIIlIllIIlIlIl.charAt(llllllllllIllllIIlIIIlIllIIllIll);
                        if (llllllllllIllllIIlIIIlIllIIlIlll == 'l' || llllllllllIllllIIlIIIlIllIIlIlll == 'L') {
                            llllllllllIllllIIlIIIlIllIIllIIl = true;
                            break Label_0163;
                        }
                        if (llllllllllIllllIIlIIIlIllIIlIlll == 'r' || llllllllllIllllIIlIIIlIllIIlIlll == 'R' || isFormatColor(llllllllllIllllIIlIIIlIllIIlIlll)) {
                            llllllllllIllllIIlIIIlIllIIllIIl = false;
                        }
                        break Label_0163;
                    }
                }
                llllllllllIllllIIlIIIlIllIIlllII += this.getCharWidthFloat(llllllllllIllllIIlIIIlIllIIllIII);
                if (llllllllllIllllIIlIIIlIllIIllIIl) {
                    ++llllllllllIllllIIlIIIlIllIIlllII;
                }
            }
            if (llllllllllIllllIIlIIIlIllIIllIII == '\n') {
                llllllllllIllllIIlIIIlIllIIllIlI = ++llllllllllIllllIIlIIIlIllIIllIll;
                break;
            }
            if (Math.round(llllllllllIllllIIlIIIlIllIIlllII) > llllllllllIllllIIlIIIlIllIIllllI) {
                break;
            }
            ++llllllllllIllllIIlIIIlIllIIllIll;
        }
        return (llllllllllIllllIIlIIIlIllIIllIll != llllllllllIllllIIlIIIlIllIIlllIl && llllllllllIllllIIlIIIlIllIIllIlI != -1 && llllllllllIllllIIlIIIlIllIIllIlI < llllllllllIllllIIlIIIlIllIIllIll) ? llllllllllIllllIIlIIIlIllIIllIlI : llllllllllIllllIIlIIIlIllIIllIll;
    }
    
    public void drawSplitString(String llllllllllIllllIIlIIIllIIIIIlllI, final int llllllllllIllllIIlIIIllIIIIlIIll, final int llllllllllIllllIIlIIIllIIIIIllII, final int llllllllllIllllIIlIIIllIIIIIlIll, final int llllllllllIllllIIlIIIllIIIIlIIII) {
        if (this.blend) {
            GlStateManager.getBlendState(this.oldBlendState);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
        }
        this.resetStyles();
        this.textColor = llllllllllIllllIIlIIIllIIIIlIIII;
        llllllllllIllllIIlIIIllIIIIIlllI = this.trimStringNewline(llllllllllIllllIIlIIIllIIIIIlllI);
        this.renderSplitString(llllllllllIllllIIlIIIllIIIIIlllI, llllllllllIllllIIlIIIllIIIIlIIll, llllllllllIllllIIlIIIllIIIIIllII, llllllllllIllllIIlIIIllIIIIIlIll, false);
        if (this.blend) {
            GlStateManager.setBlendState(this.oldBlendState);
        }
    }
    
    protected InputStream getResourceInputStream(final ResourceLocation llllllllllIllllIIlIIIlIlIlIlIIlI) throws IOException {
        return Minecraft.getMinecraft().getResourceManager().getResource(llllllllllIllllIIlIIIlIlIlIlIIlI).getInputStream();
    }
    
    public void drawCenteredString(final String llllllllllIllllIIlIIIlIllllIIlll, float llllllllllIllllIIlIIIlIllllIIllI, final float llllllllllIllllIIlIIIlIllllIlIlI, final int llllllllllIllllIIlIIIlIllllIIlII) {
        llllllllllIllllIIlIIIlIllllIIllI -= (byte)(this.getStringWidth(llllllllllIllllIIlIIIlIllllIIlll) / 2.0f);
        this.drawStringWithShadow(llllllllllIllllIIlIIIlIllllIIlll, llllllllllIllllIIlIIIlIllllIIllI, llllllllllIllllIIlIIIlIllllIlIlI, llllllllllIllllIIlIIIlIllllIIlII);
    }
    
    protected void bindTexture(final ResourceLocation llllllllllIllllIIlIIIlIlIlIlIlll) {
        this.renderEngine.bindTexture(llllllllllIllllIIlIIIlIlIlIlIlll);
    }
    
    String wrapFormattedStringToWidth(final String llllllllllIllllIIlIIIlIllIllIIIl, final int llllllllllIllllIIlIIIlIllIllIIII) {
        if (llllllllllIllllIIlIIIlIllIllIIIl.length() <= 1) {
            return llllllllllIllllIIlIIIlIllIllIIIl;
        }
        final int llllllllllIllllIIlIIIlIllIllIlll = this.sizeStringToWidth(llllllllllIllllIIlIIIlIllIllIIIl, llllllllllIllllIIlIIIlIllIllIIII);
        if (llllllllllIllllIIlIIIlIllIllIIIl.length() <= llllllllllIllllIIlIIIlIllIllIlll) {
            return llllllllllIllllIIlIIIlIllIllIIIl;
        }
        final String llllllllllIllllIIlIIIlIllIllIllI = llllllllllIllllIIlIIIlIllIllIIIl.substring(0, llllllllllIllllIIlIIIlIllIllIlll);
        final char llllllllllIllllIIlIIIlIllIllIlIl = llllllllllIllllIIlIIIlIllIllIIIl.charAt(llllllllllIllllIIlIIIlIllIllIlll);
        final boolean llllllllllIllllIIlIIIlIllIllIlII = llllllllllIllllIIlIIIlIllIllIlIl == ' ' || llllllllllIllllIIlIIIlIllIllIlIl == '\n';
        final String llllllllllIllllIIlIIIlIllIllIIll = String.valueOf(getFormatFromString(llllllllllIllllIIlIIIlIllIllIllI)) + llllllllllIllllIIlIIIlIllIllIIIl.substring(llllllllllIllllIIlIIIlIllIllIlll + (llllllllllIllllIIlIIIlIllIllIlII ? 1 : 0));
        return String.valueOf(llllllllllIllllIIlIIIlIllIllIllI) + "\n" + this.wrapFormattedStringToWidth(llllllllllIllllIIlIIIlIllIllIIll, llllllllllIllllIIlIIIlIllIllIIII);
    }
    
    public int splitStringWidth(final String llllllllllIllllIIlIIIlIlllIlllII, final int llllllllllIllllIIlIIIlIlllIllIll) {
        return this.FONT_HEIGHT * this.listFormattedStringToWidth(llllllllllIllllIIlIIIlIlllIlllII, llllllllllIllllIIlIIIlIlllIllIll).size();
    }
    
    protected int renderString(String llllllllllIllllIIlIIIllIIllllllI, final float llllllllllIllllIIlIIIllIIlllllIl, final float llllllllllIllllIIlIIIllIIlllllII, int llllllllllIllllIIlIIIllIIllllIll, final boolean llllllllllIllllIIlIIIllIIllllIlI) {
        if (llllllllllIllllIIlIIIllIIllllllI == null) {
            return 0;
        }
        if (this.bidiFlag) {
            llllllllllIllllIIlIIIllIIllllllI = this.bidiReorder((String)llllllllllIllllIIlIIIllIIllllllI);
        }
        if ((llllllllllIllllIIlIIIllIIllllIll & 0xFC000000) == 0x0) {
            llllllllllIllllIIlIIIllIIllllIll |= 0xFF000000;
        }
        if (llllllllllIllllIIlIIIllIIllllIlI) {
            llllllllllIllllIIlIIIllIIllllIll = ((llllllllllIllllIIlIIIllIIllllIll & 0xFCFCFC) >> 2 | (llllllllllIllllIIlIIIllIIllllIll & 0xFF000000));
        }
        this.red = (llllllllllIllllIIlIIIllIIllllIll >> 16 & 0xFF) / 255.0f;
        this.blue = (llllllllllIllllIIlIIIllIIllllIll >> 8 & 0xFF) / 255.0f;
        this.green = (llllllllllIllllIIlIIIllIIllllIll & 0xFF) / 255.0f;
        this.alpha = (llllllllllIllllIIlIIIllIIllllIll >> 24 & 0xFF) / 255.0f;
        GlStateManager.color(this.red, this.blue, this.green, this.alpha);
        this.posX = llllllllllIllllIIlIIIllIIlllllIl;
        this.posY = llllllllllIllllIIlIIIllIIlllllII;
        if (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled()) {
            llllllllllIllllIIlIIIllIIllllllI = ((String)llllllllllIllllIIlIIIllIIllllllI).replaceAll(Minecraft.getMinecraft().session.getUsername(), new StringBuilder().append(ChatFormatting.LIGHT_PURPLE).append(TextFormatting.ITALIC).append("ROCKSTAR USER").append(ChatFormatting.RESET).toString());
        }
        this.renderStringAtPos((String)llllllllllIllllIIlIIIllIIllllllI, llllllllllIllllIIlIIIllIIllllIlI);
        return (int)this.posX;
    }
    
    public List<String> listFormattedStringToWidth(final String llllllllllIllllIIlIIIlIlllIIIlII, final int llllllllllIllllIIlIIIlIlllIIIIll) {
        return Arrays.asList(this.wrapFormattedStringToWidth(llllllllllIllllIIlIIIlIlllIIIlII, llllllllllIllllIIlIIIlIlllIIIIll).split("\n"));
    }
    
    public static String getFormatFromString(final String llllllllllIllllIIlIIIlIlIlllllII) {
        String llllllllllIllllIIlIIIlIllIIIIIII = "";
        int llllllllllIllllIIlIIIlIlIlllllll = -1;
        final int llllllllllIllllIIlIIIlIlIllllllI = llllllllllIllllIIlIIIlIlIlllllII.length();
        while ((llllllllllIllllIIlIIIlIlIlllllll = llllllllllIllllIIlIIIlIlIlllllII.indexOf(167, llllllllllIllllIIlIIIlIlIlllllll + 1)) != -1) {
            if (llllllllllIllllIIlIIIlIlIlllllll < llllllllllIllllIIlIIIlIlIllllllI - 1) {
                final char llllllllllIllllIIlIIIlIlIlllllIl = llllllllllIllllIIlIIIlIlIlllllII.charAt(llllllllllIllllIIlIIIlIlIlllllll + 1);
                if (isFormatColor(llllllllllIllllIIlIIIlIlIlllllIl)) {
                    llllllllllIllllIIlIIIlIllIIIIIII = "§" + llllllllllIllllIIlIIIlIlIlllllIl;
                }
                else {
                    if (!isFormatSpecial(llllllllllIllllIIlIIIlIlIlllllIl)) {
                        continue;
                    }
                    llllllllllIllllIIlIIIlIllIIIIIII = String.valueOf(llllllllllIllllIIlIIIlIllIIIIIII) + "§" + llllllllllIllllIIlIIIlIlIlllllIl;
                }
            }
        }
        return llllllllllIllllIIlIIIlIllIIIIIII;
    }
    
    private void readGlyphSizes() {
        InputStream llllllllllIllllIIlIIIlllIllllIIl = null;
        try {
            llllllllllIllllIIlIIIlllIllllIIl = this.getResourceInputStream(new ResourceLocation("font/glyph_sizes.bin"));
            llllllllllIllllIIlIIIlllIllllIIl.read(this.glyphWidth);
        }
        catch (IOException llllllllllIllllIIlIIIlllIllllIII) {
            throw new RuntimeException(llllllllllIllllIIlIIIlllIllllIII);
        }
        finally {
            IOUtils.closeQuietly(llllllllllIllllIIlIIIlllIllllIIl);
        }
        IOUtils.closeQuietly(llllllllllIllllIIlIIIlllIllllIIl);
    }
    
    public int drawString(final String llllllllllIllllIIlIIIllIllllllIl, final float llllllllllIllllIIlIIIllIllllllII, final float llllllllllIllllIIlIIIllIllllIllI, final int llllllllllIllllIIlIIIllIllllIlIl) {
        return this.enabled ? this.drawString(llllllllllIllllIIlIIIllIllllllIl, llllllllllIllllIIlIIIllIllllllII, llllllllllIllllIIlIIIllIllllIllI, llllllllllIllllIIlIIIllIllllIlIl, false) : 0;
    }
    
    static {
        __OBFID = "CL_00000660";
        unicodePageLocations = new ResourceLocation[256];
        mc = Minecraft.getMinecraft();
    }
    
    public FontRenderer(final GameSettings llllllllllIllllIIlIIIlllllllIIlI, final ResourceLocation llllllllllIllllIIlIIIlllllllIIIl, final TextureManager llllllllllIllllIIlIIIlllllllIIII, final boolean llllllllllIllllIIlIIIllllllIIIlI) {
        this.charWidth = new float[256];
        this.FONT_HEIGHT = 9;
        this.fontRandom = new Random();
        this.glyphWidth = new byte[65536];
        this.colorCode = new int[32];
        this.enabled = true;
        this.offsetBold = 1.0f;
        this.charWidthFloat = new float[256];
        this.blend = false;
        this.oldBlendState = new GlBlendState();
        this.gameSettings = llllllllllIllllIIlIIIlllllllIIlI;
        this.locationFontTextureBase = llllllllllIllllIIlIIIlllllllIIIl;
        this.locationFontTexture = llllllllllIllllIIlIIIlllllllIIIl;
        this.renderEngine = llllllllllIllllIIlIIIlllllllIIII;
        this.unicodeFlag = llllllllllIllllIIlIIIllllllIIIlI;
        this.locationFontTexture = FontUtils.getHdFontLocation(this.locationFontTextureBase);
        this.bindTexture(this.locationFontTexture);
        for (int llllllllllIllllIIlIIIllllllIlllI = 0; llllllllllIllllIIlIIIllllllIlllI < 32; ++llllllllllIllllIIlIIIllllllIlllI) {
            final int llllllllllIllllIIlIIIllllllIllIl = (llllllllllIllllIIlIIIllllllIlllI >> 3 & 0x1) * 85;
            int llllllllllIllllIIlIIIllllllIllII = (llllllllllIllllIIlIIIllllllIlllI >> 2 & 0x1) * 170 + llllllllllIllllIIlIIIllllllIllIl;
            int llllllllllIllllIIlIIIllllllIlIll = (llllllllllIllllIIlIIIllllllIlllI >> 1 & 0x1) * 170 + llllllllllIllllIIlIIIllllllIllIl;
            int llllllllllIllllIIlIIIllllllIlIlI = (llllllllllIllllIIlIIIllllllIlllI >> 0 & 0x1) * 170 + llllllllllIllllIIlIIIllllllIllIl;
            if (llllllllllIllllIIlIIIllllllIlllI == 6) {
                llllllllllIllllIIlIIIllllllIllII += 85;
            }
            if (llllllllllIllllIIlIIIlllllllIIlI.anaglyph) {
                final int llllllllllIllllIIlIIIllllllIlIIl = (llllllllllIllllIIlIIIllllllIllII * 30 + llllllllllIllllIIlIIIllllllIlIll * 59 + llllllllllIllllIIlIIIllllllIlIlI * 11) / 100;
                final int llllllllllIllllIIlIIIllllllIlIII = (llllllllllIllllIIlIIIllllllIllII * 30 + llllllllllIllllIIlIIIllllllIlIll * 70) / 100;
                final int llllllllllIllllIIlIIIllllllIIlll = (llllllllllIllllIIlIIIllllllIllII * 30 + llllllllllIllllIIlIIIllllllIlIlI * 70) / 100;
                llllllllllIllllIIlIIIllllllIllII = llllllllllIllllIIlIIIllllllIlIIl;
                llllllllllIllllIIlIIIllllllIlIll = llllllllllIllllIIlIIIllllllIlIII;
                llllllllllIllllIIlIIIllllllIlIlI = llllllllllIllllIIlIIIllllllIIlll;
            }
            if (llllllllllIllllIIlIIIllllllIlllI >= 16) {
                llllllllllIllllIIlIIIllllllIllII /= 4;
                llllllllllIllllIIlIIIllllllIlIll /= 4;
                llllllllllIllllIIlIIIllllllIlIlI /= 4;
            }
            this.colorCode[llllllllllIllllIIlIIIllllllIlllI] = ((llllllllllIllllIIlIIIllllllIllII & 0xFF) << 16 | (llllllllllIllllIIlIIIllllllIlIll & 0xFF) << 8 | (llllllllllIllllIIlIIIllllllIlIlI & 0xFF));
        }
        this.readGlyphSizes();
    }
    
    private void readFontTexture() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* llllllllllIllllIIlIIIllllIIlIIll */
        //     2: getfield        net/minecraft/client/gui/FontRenderer.locationFontTexture:Lnet/minecraft/util/ResourceLocation;
        //     5: invokevirtual   net/minecraft/client/gui/FontRenderer.getResourceInputStream:(Lnet/minecraft/util/ResourceLocation;)Ljava/io/InputStream;
        //     8: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    11: astore_1        /* llllllllllIllllIIlIIIllllIIlIIlI */
        //    12: goto            25
        //    15: astore_2        /* llllllllllIllllIIlIIIllllIIlIIIl */
        //    16: new             Ljava/lang/RuntimeException;
        //    19: dup            
        //    20: aload_2         /* llllllllllIllllIIlIIIllllIlIIlll */
        //    21: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    24: athrow         
        //    25: aload_0         /* llllllllllIllllIIlIIIllllIIlIIll */
        //    26: getfield        net/minecraft/client/gui/FontRenderer.locationFontTexture:Lnet/minecraft/util/ResourceLocation;
        //    29: invokestatic    optifine/FontUtils.readFontProperties:(Lnet/minecraft/util/ResourceLocation;)Ljava/util/Properties;
        //    32: astore_2        /* llllllllllIllllIIlIIIllllIIlIIIl */
        //    33: aload_0         /* llllllllllIllllIIlIIIllllIIlIIll */
        //    34: aload_2         /* llllllllllIllllIIlIIIllllIlIIllI */
        //    35: ldc_w           "blend"
        //    38: iconst_0       
        //    39: invokestatic    optifine/FontUtils.readBoolean:(Ljava/util/Properties;Ljava/lang/String;Z)Z
        //    42: putfield        net/minecraft/client/gui/FontRenderer.blend:Z
        //    45: aload_1         /* llllllllllIllllIIlIIIllllIlIlIII */
        //    46: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    49: istore_3        /* llllllllllIllllIIlIIIllllIlIIlIl */
        //    50: aload_1         /* llllllllllIllllIIlIIIllllIlIlIII */
        //    51: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    54: istore          llllllllllIllllIIlIIIllllIlIIlII
        //    56: iload_3         /* llllllllllIllllIIlIIIllllIlIIlIl */
        //    57: bipush          16
        //    59: idiv           
        //    60: istore          llllllllllIllllIIlIIIllllIlIIIll
        //    62: iload           llllllllllIllllIIlIIIllllIlIIlII
        //    64: bipush          16
        //    66: idiv           
        //    67: istore          llllllllllIllllIIlIIIllllIlIIIlI
        //    69: iload_3         /* llllllllllIllllIIlIIIllllIlIIlIl */
        //    70: i2f            
        //    71: ldc_w           128.0
        //    74: fdiv           
        //    75: fstore          llllllllllIllllIIlIIIllllIlIIIIl
        //    77: fload           llllllllllIllllIIlIIIllllIlIIIIl
        //    79: fconst_1       
        //    80: fconst_2       
        //    81: invokestatic    optifine/Config.limit:(FFF)F
        //    84: fstore          llllllllllIllllIIlIIIllllIlIIIII
        //    86: aload_0         /* llllllllllIllllIIlIIIllllIIlIIll */
        //    87: fconst_1       
        //    88: fload           llllllllllIllllIIlIIIllllIlIIIII
        //    90: fdiv           
        //    91: putfield        net/minecraft/client/gui/FontRenderer.offsetBold:F
        //    94: aload_2         /* llllllllllIllllIIlIIIllllIlIIllI */
        //    95: ldc_w           "offsetBold"
        //    98: ldc_w           -1.0
        //   101: invokestatic    optifine/FontUtils.readFloat:(Ljava/util/Properties;Ljava/lang/String;F)F
        //   104: fstore          llllllllllIllllIIlIIIllllIIlllll
        //   106: fload           llllllllllIllllIIlIIIllllIIlllll
        //   108: fconst_0       
        //   109: fcmpl          
        //   110: iflt            119
        //   113: aload_0         /* llllllllllIllllIIlIIIllllIIlIIll */
        //   114: fload           llllllllllIllllIIlIIIllllIIlllll
        //   116: putfield        net/minecraft/client/gui/FontRenderer.offsetBold:F
        //   119: iload_3         /* llllllllllIllllIIlIIIllllIlIIlIl */
        //   120: iload           llllllllllIllllIIlIIIllllIlIIlII
        //   122: imul           
        //   123: newarray        I
        //   125: astore          llllllllllIllllIIlIIIllllIIllllI
        //   127: aload_1         /* llllllllllIllllIIlIIIllllIlIlIII */
        //   128: iconst_0       
        //   129: iconst_0       
        //   130: iload_3         /* llllllllllIllllIIlIIIllllIlIIlIl */
        //   131: iload           llllllllllIllllIIlIIIllllIlIIlII
        //   133: aload           llllllllllIllllIIlIIIllllIIllllI
        //   135: iconst_0       
        //   136: iload_3         /* llllllllllIllllIIlIIIllllIlIIlIl */
        //   137: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //   140: pop            
        //   141: iconst_0       
        //   142: istore          llllllllllIllllIIlIIIllllIIlllIl
        //   144: goto            330
        //   147: iload           llllllllllIllllIIlIIIllllIIlllIl
        //   149: bipush          16
        //   151: irem           
        //   152: istore          llllllllllIllllIIlIIIllllIIlllII
        //   154: iload           llllllllllIllllIIlIIIllllIIlllIl
        //   156: bipush          16
        //   158: idiv           
        //   159: istore          llllllllllIllllIIlIIIllllIIllIll
        //   161: iconst_0       
        //   162: istore          llllllllllIllllIIlIIIllllIIllIlI
        //   164: iload           llllllllllIllllIIlIIIllllIlIIIll
        //   166: iconst_1       
        //   167: isub           
        //   168: istore          llllllllllIllllIIlIIIllllIIllIlI
        //   170: goto            261
        //   173: iload           llllllllllIllllIIlIIIllllIIlllII
        //   175: iload           llllllllllIllllIIlIIIllllIlIIIll
        //   177: imul           
        //   178: iload           llllllllllIllllIIlIIIllllIIllIlI
        //   180: iadd           
        //   181: istore          llllllllllIllllIIlIIIllllIIllIIl
        //   183: iconst_1       
        //   184: istore          llllllllllIllllIIlIIIllllIIllIII
        //   186: iconst_0       
        //   187: istore          llllllllllIllllIIlIIIllllIIlIlll
        //   189: goto            238
        //   192: iload           llllllllllIllllIIlIIIllllIIllIll
        //   194: iload           llllllllllIllllIIlIIIllllIlIIIlI
        //   196: imul           
        //   197: iload           llllllllllIllllIIlIIIllllIIlIlll
        //   199: iadd           
        //   200: iload_3         /* llllllllllIllllIIlIIIllllIlIIlIl */
        //   201: imul           
        //   202: istore          llllllllllIllllIIlIIIllllIIlIllI
        //   204: aload           llllllllllIllllIIlIIIllllIIllllI
        //   206: iload           llllllllllIllllIIlIIIllllIIllIIl
        //   208: iload           llllllllllIllllIIlIIIllllIIlIllI
        //   210: iadd           
        //   211: iaload         
        //   212: istore          llllllllllIllllIIlIIIllllIIlIlIl
        //   214: iload           llllllllllIllllIIlIIIllllIIlIlIl
        //   216: bipush          24
        //   218: ishr           
        //   219: sipush          255
        //   222: iand           
        //   223: istore          llllllllllIllllIIlIIIllllIIlIlII
        //   225: iload           llllllllllIllllIIlIIIllllIIlIlII
        //   227: bipush          16
        //   229: if_icmple       235
        //   232: iconst_0       
        //   233: istore          llllllllllIllllIIlIIIllllIIllIII
        //   235: iinc            llllllllllIllllIIlIIIllllIIlIlll, 1
        //   238: iload           llllllllllIllllIIlIIIllllIIlIlll
        //   240: iload           llllllllllIllllIIlIIIllllIlIIIlI
        //   242: if_icmpge       250
        //   245: iload           llllllllllIllllIIlIIIllllIIllIII
        //   247: ifne            192
        //   250: iload           llllllllllIllllIIlIIIllllIIllIII
        //   252: ifne            258
        //   255: goto            266
        //   258: iinc            llllllllllIllllIIlIIIllllIIllIlI, -1
        //   261: iload           llllllllllIllllIIlIIIllllIIllIlI
        //   263: ifge            173
        //   266: iload           llllllllllIllllIIlIIIllllIIlllIl
        //   268: bipush          65
        //   270: if_icmpne       277
        //   273: iload           llllllllllIllllIIlIIIllllIIlllIl
        //   275: istore          llllllllllIllllIIlIIIllllIIlllIl
        //   277: iload           llllllllllIllllIIlIIIllllIIlllIl
        //   279: bipush          32
        //   281: if_icmpne       310
        //   284: iload           llllllllllIllllIIlIIIllllIlIIIll
        //   286: bipush          8
        //   288: if_icmpgt       301
        //   291: fconst_2       
        //   292: fload           llllllllllIllllIIlIIIllllIlIIIIl
        //   294: fmul           
        //   295: f2i            
        //   296: istore          llllllllllIllllIIlIIIllllIIllIlI
        //   298: goto            310
        //   301: ldc_w           1.5
        //   304: fload           llllllllllIllllIIlIIIllllIlIIIIl
        //   306: fmul           
        //   307: f2i            
        //   308: istore          llllllllllIllllIIlIIIllllIIllIlI
        //   310: aload_0         /* llllllllllIllllIIlIIIllllIIlIIll */
        //   311: getfield        net/minecraft/client/gui/FontRenderer.charWidth:[F
        //   314: iload           llllllllllIllllIIlIIIllllIIlllIl
        //   316: iload           llllllllllIllllIIlIIIllllIIllIlI
        //   318: iconst_1       
        //   319: iadd           
        //   320: i2f            
        //   321: fload           llllllllllIllllIIlIIIllllIlIIIIl
        //   323: fdiv           
        //   324: fconst_1       
        //   325: fadd           
        //   326: fastore        
        //   327: iinc            llllllllllIllllIIlIIIllllIIlllIl, 1
        //   330: iload           llllllllllIllllIIlIIIllllIIlllIl
        //   332: sipush          256
        //   335: if_icmplt       147
        //   338: aload_2         /* llllllllllIllllIIlIIIllllIlIIllI */
        //   339: aload_0         /* llllllllllIllllIIlIIIllllIIlIIll */
        //   340: getfield        net/minecraft/client/gui/FontRenderer.charWidth:[F
        //   343: invokestatic    optifine/FontUtils.readCustomCharWidths:(Ljava/util/Properties;[F)V
        //   346: return         
        //    StackMapTable: 00 10 4F 07 01 8E FC 00 09 07 02 E7 FF 00 5D 00 0A 07 00 02 07 02 E7 07 03 31 01 01 01 01 02 02 02 00 00 FD 00 1B 07 03 32 01 FE 00 19 01 01 01 FE 00 12 01 01 01 FE 00 2A 01 01 01 F8 00 02 0B 07 F8 00 02 04 0A 17 08 F8 00 13
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      12     15     25     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public String bidiReorder(final String llllllllllIllllIIlIIIllIllIllIll) {
        try {
            final Bidi llllllllllIllllIIlIIIllIllIllIlI = new Bidi(new ArabicShaping(8).shape(llllllllllIllllIIlIIIllIllIllIll), 127);
            llllllllllIllllIIlIIIllIllIllIlI.setReorderingMode(0);
            return llllllllllIllllIIlIIIllIllIllIlI.writeReordered(2);
        }
        catch (ArabicShapingException llllllllllIllllIIlIIIllIllIllIIl) {
            return llllllllllIllllIIlIIIllIllIllIll;
        }
    }
    
    private float getCharWidthFloat(final char llllllllllIllllIIlIIIllIIlIlIIll) {
        if (llllllllllIllllIIlIIIllIIlIlIIll == '§') {
            return -1.0f;
        }
        if (llllllllllIllllIIlIIIllIIlIlIIll == ' ') {
            return this.charWidth[32];
        }
        final int llllllllllIllllIIlIIIllIIlIlIlll = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8£\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1ªº¿®¬½¼¡«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f²\u25a0\u0000".indexOf(llllllllllIllllIIlIIIllIIlIlIIll);
        if (llllllllllIllllIIlIIIllIIlIlIIll > '\0' && llllllllllIllllIIlIIIllIIlIlIlll != -1 && !this.unicodeFlag) {
            return this.charWidth[llllllllllIllllIIlIIIllIIlIlIlll];
        }
        if (this.glyphWidth[llllllllllIllllIIlIIIllIIlIlIIll] != 0) {
            int llllllllllIllllIIlIIIllIIlIlIllI = this.glyphWidth[llllllllllIllllIIlIIIllIIlIlIIll] >>> 4;
            int llllllllllIllllIIlIIIllIIlIlIlIl = this.glyphWidth[llllllllllIllllIIlIIIllIIlIlIIll] & 0xF;
            llllllllllIllllIIlIIIllIIlIlIllI &= 0xF;
            return (float)((++llllllllllIllllIIlIIIllIIlIlIlIl - llllllllllIllllIIlIIIllIIlIlIllI) / 2 + 1);
        }
        return 0.0f;
    }
    
    private void renderStringAtPos(final String llllllllllIllllIIlIIIllIllIIlIIl, final boolean llllllllllIllllIIlIIIllIlIlllIll) {
        for (int llllllllllIllllIIlIIIllIllIIIlll = 0; llllllllllIllllIIlIIIllIllIIIlll < llllllllllIllllIIlIIIllIllIIlIIl.length(); ++llllllllllIllllIIlIIIllIllIIIlll) {
            char llllllllllIllllIIlIIIllIllIIIllI = llllllllllIllllIIlIIIllIllIIlIIl.charAt(llllllllllIllllIIlIIIllIllIIIlll);
            if (llllllllllIllllIIlIIIllIllIIIllI == '§' && llllllllllIllllIIlIIIllIllIIIlll + 1 < llllllllllIllllIIlIIIllIllIIlIIl.length()) {
                int llllllllllIllllIIlIIIllIllIIIlIl = "0123456789abcdefklmnor".indexOf(llllllllllIllllIIlIIIllIllIIlIIl.toLowerCase().charAt(llllllllllIllllIIlIIIllIllIIIlll + 1));
                if (llllllllllIllllIIlIIIllIllIIIlIl < 16) {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    if (llllllllllIllllIIlIIIllIllIIIlIl < 0 || llllllllllIllllIIlIIIllIllIIIlIl > 15) {
                        llllllllllIllllIIlIIIllIllIIIlIl = 15;
                    }
                    if (llllllllllIllllIIlIIIllIlIlllIll) {
                        llllllllllIllllIIlIIIllIllIIIlIl += 16;
                    }
                    int llllllllllIllllIIlIIIllIllIIIlII = this.colorCode[llllllllllIllllIIlIIIllIllIIIlIl];
                    if (Config.isCustomColors()) {
                        llllllllllIllllIIlIIIllIllIIIlII = CustomColors.getTextColor(llllllllllIllllIIlIIIllIllIIIlIl, llllllllllIllllIIlIIIllIllIIIlII);
                    }
                    this.textColor = llllllllllIllllIIlIIIllIllIIIlII;
                    this.setColor((llllllllllIllllIIlIIIllIllIIIlII >> 16) / 255.0f, (llllllllllIllllIIlIIIllIllIIIlII >> 8 & 0xFF) / 255.0f, (llllllllllIllllIIlIIIllIllIIIlII & 0xFF) / 255.0f, this.alpha);
                }
                else if (llllllllllIllllIIlIIIllIllIIIlIl == 16) {
                    this.randomStyle = true;
                }
                else if (llllllllllIllllIIlIIIllIllIIIlIl == 17) {
                    this.boldStyle = true;
                }
                else if (llllllllllIllllIIlIIIllIllIIIlIl == 18) {
                    this.strikethroughStyle = true;
                }
                else if (llllllllllIllllIIlIIIllIllIIIlIl == 19) {
                    this.underlineStyle = true;
                }
                else if (llllllllllIllllIIlIIIllIllIIIlIl == 20) {
                    this.italicStyle = true;
                }
                else if (llllllllllIllllIIlIIIllIllIIIlIl == 21) {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    this.setColor(this.red, this.blue, this.green, this.alpha);
                }
                ++llllllllllIllllIIlIIIllIllIIIlll;
            }
            else {
                int llllllllllIllllIIlIIIllIllIIIIll = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8£\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1ªº¿®¬½¼¡«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f²\u25a0\u0000".indexOf(llllllllllIllllIIlIIIllIllIIIllI);
                if (this.randomStyle && llllllllllIllllIIlIIIllIllIIIIll != -1) {
                    final int llllllllllIllllIIlIIIllIllIIIIlI = this.getCharWidth(llllllllllIllllIIlIIIllIllIIIllI);
                    char llllllllllIllllIIlIIIllIllIIIIIl;
                    do {
                        llllllllllIllllIIlIIIllIllIIIIll = this.fontRandom.nextInt("\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8£\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1ªº¿®¬½¼¡«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f²\u25a0\u0000".length());
                        llllllllllIllllIIlIIIllIllIIIIIl = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8£\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1ªº¿®¬½¼¡«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f²\u25a0\u0000".charAt(llllllllllIllllIIlIIIllIllIIIIll);
                    } while (llllllllllIllllIIlIIIllIllIIIIlI != this.getCharWidth(llllllllllIllllIIlIIIllIllIIIIIl));
                    llllllllllIllllIIlIIIllIllIIIllI = llllllllllIllllIIlIIIllIllIIIIIl;
                }
                final float llllllllllIllllIIlIIIllIllIIIIII = (llllllllllIllllIIlIIIllIllIIIIll != -1 && !this.unicodeFlag) ? this.offsetBold : 0.5f;
                final boolean llllllllllIllllIIlIIIllIlIllllll = (llllllllllIllllIIlIIIllIllIIIllI == '\0' || llllllllllIllllIIlIIIllIllIIIIll == -1 || this.unicodeFlag) && llllllllllIllllIIlIIIllIlIlllIll;
                if (llllllllllIllllIIlIIIllIlIllllll) {
                    this.posX -= llllllllllIllllIIlIIIllIllIIIIII;
                    this.posY -= llllllllllIllllIIlIIIllIllIIIIII;
                }
                float llllllllllIllllIIlIIIllIlIlllllI = this.renderChar(llllllllllIllllIIlIIIllIllIIIllI, this.italicStyle);
                if (llllllllllIllllIIlIIIllIlIllllll) {
                    this.posX += llllllllllIllllIIlIIIllIllIIIIII;
                    this.posY += llllllllllIllllIIlIIIllIllIIIIII;
                }
                if (this.boldStyle) {
                    this.posX += llllllllllIllllIIlIIIllIllIIIIII;
                    if (llllllllllIllllIIlIIIllIlIllllll) {
                        this.posX -= llllllllllIllllIIlIIIllIllIIIIII;
                        this.posY -= llllllllllIllllIIlIIIllIllIIIIII;
                    }
                    this.renderChar(llllllllllIllllIIlIIIllIllIIIllI, this.italicStyle);
                    this.posX -= llllllllllIllllIIlIIIllIllIIIIII;
                    if (llllllllllIllllIIlIIIllIlIllllll) {
                        this.posX += llllllllllIllllIIlIIIllIllIIIIII;
                        this.posY += llllllllllIllllIIlIIIllIllIIIIII;
                    }
                    llllllllllIllllIIlIIIllIlIlllllI += llllllllllIllllIIlIIIllIllIIIIII;
                }
                this.doDraw(llllllllllIllllIIlIIIllIlIlllllI);
            }
        }
    }
    
    public void setUnicodeFlag(final boolean llllllllllIllllIIlIIIlIlllIlIlll) {
        this.unicodeFlag = llllllllllIllllIIlIIIlIlllIlIlll;
    }
    
    public int getStringWidth(final String llllllllllIllllIIlIIIllIIlllIIIl) {
        if (llllllllllIllllIIlIIIllIIlllIIIl == null) {
            return 0;
        }
        float llllllllllIllllIIlIIIllIIlllIIII = 0.0f;
        boolean llllllllllIllllIIlIIIllIIllIllll = false;
        for (int llllllllllIllllIIlIIIllIIllIlllI = 0; llllllllllIllllIIlIIIllIIllIlllI < llllllllllIllllIIlIIIllIIlllIIIl.length(); ++llllllllllIllllIIlIIIllIIllIlllI) {
            char llllllllllIllllIIlIIIllIIllIllIl = llllllllllIllllIIlIIIllIIlllIIIl.charAt(llllllllllIllllIIlIIIllIIllIlllI);
            float llllllllllIllllIIlIIIllIIllIllII = this.getCharWidthFloat(llllllllllIllllIIlIIIllIIllIllIl);
            if (llllllllllIllllIIlIIIllIIllIllII < 0.0f && llllllllllIllllIIlIIIllIIllIlllI < llllllllllIllllIIlIIIllIIlllIIIl.length() - 1) {
                ++llllllllllIllllIIlIIIllIIllIlllI;
                llllllllllIllllIIlIIIllIIllIllIl = llllllllllIllllIIlIIIllIIlllIIIl.charAt(llllllllllIllllIIlIIIllIIllIlllI);
                if (llllllllllIllllIIlIIIllIIllIllIl != 'l' && llllllllllIllllIIlIIIllIIllIllIl != 'L') {
                    if (llllllllllIllllIIlIIIllIIllIllIl == 'r' || llllllllllIllllIIlIIIllIIllIllIl == 'R') {
                        llllllllllIllllIIlIIIllIIllIllll = false;
                    }
                }
                else {
                    llllllllllIllllIIlIIIllIIllIllll = true;
                }
                llllllllllIllllIIlIIIllIIllIllII = 0.0f;
            }
            llllllllllIllllIIlIIIllIIlllIIII += llllllllllIllllIIlIIIllIIllIllII;
            if (llllllllllIllllIIlIIIllIIllIllll && llllllllllIllllIIlIIIllIIllIllII > 0.0f) {
                llllllllllIllllIIlIIIllIIlllIIII += (this.unicodeFlag ? 1.0f : this.offsetBold);
            }
        }
        return Math.round(llllllllllIllllIIlIIIllIIlllIIII);
    }
    
    public void drawStringWithOutline(final String llllllllllIllllIIlIIIlllIIIIIlll, final float llllllllllIllllIIlIIIlllIIIIlIll, final float llllllllllIllllIIlIIIlllIIIIlIlI, final int llllllllllIllllIIlIIIlllIIIIIlII) {
        this.drawString(llllllllllIllllIIlIIIlllIIIIIlll, llllllllllIllllIIlIIIlllIIIIlIll - 0.5f, llllllllllIllllIIlIIIlllIIIIlIlI, Color.BLACK.getRGB());
        this.drawString(llllllllllIllllIIlIIIlllIIIIIlll, llllllllllIllllIIlIIIlllIIIIlIll + 0.5f, llllllllllIllllIIlIIIlllIIIIlIlI, Color.BLACK.getRGB());
        this.drawString(llllllllllIllllIIlIIIlllIIIIIlll, llllllllllIllllIIlIIIlllIIIIlIll, llllllllllIllllIIlIIIlllIIIIlIlI - 0.5f, Color.BLACK.getRGB());
        this.drawString(llllllllllIllllIIlIIIlllIIIIIlll, llllllllllIllllIIlIIIlllIIIIlIll, llllllllllIllllIIlIIIlllIIIIlIlI + 0.5f, Color.BLACK.getRGB());
        this.drawString(llllllllllIllllIIlIIIlllIIIIIlll, llllllllllIllllIIlIIIlllIIIIlIll, llllllllllIllllIIlIIIlllIIIIlIlI, llllllllllIllllIIlIIIlllIIIIIlII);
    }
    
    public float drawCenteredStringWithShadow(final String llllllllllIllllIIlIIIlllllIIlIlI, final float llllllllllIllllIIlIIIlllllIIlllI, final float llllllllllIllllIIlIIIlllllIIlIII, final int llllllllllIllllIIlIIIlllllIIIlll) {
        this.drawString(llllllllllIllllIIlIIIlllllIIlIlI, llllllllllIllllIIlIIIlllllIIlllI - this.getStringWidth(llllllllllIllllIIlIIIlllllIIlIlI) / 2.0f + 0.45f, llllllllllIllllIIlIIIlllllIIlIII + 0.5f, llllllllllIllllIIlIIIlllllIIIlll, true);
        return (float)this.drawString(llllllllllIllllIIlIIIlllllIIlIlI, llllllllllIllllIIlIIIlllllIIlllI - this.getStringWidth(llllllllllIllllIIlIIIlllllIIlIlI) / 2.0f, llllllllllIllllIIlIIIlllllIIlIII, llllllllllIllllIIlIIIlllllIIIlll);
    }
    
    public int getStringHeight(final String llllllllllIllllIIlIIIlllllIlIlll) {
        return this.FONT_HEIGHT;
    }
    
    public void setBidiFlag(final boolean llllllllllIllllIIlIIIlIlllIIlllI) {
        this.bidiFlag = llllllllllIllllIIlIIIlIlllIIlllI;
    }
    
    public boolean getBidiFlag() {
        return this.bidiFlag;
    }
    
    public int drawStringWithShadow(final String llllllllllIllllIIlIIIlllIIIlIllI, final float llllllllllIllllIIlIIIlllIIIlIlIl, final float llllllllllIllllIIlIIIlllIIIlIlII, final int llllllllllIllllIIlIIIlllIIIllIII) {
        return this.drawString(llllllllllIllllIIlIIIlllIIIlIllI, llllllllllIllllIIlIIIlllIIIlIlIl, llllllllllIllllIIlIIIlllIIIlIlII, llllllllllIllllIIlIIIlllIIIllIII, true);
    }
    
    protected void doDraw(final float llllllllllIllllIIlIIIllIlIlIlllI) {
        if (this.strikethroughStyle) {
            final Tessellator llllllllllIllllIIlIIIllIlIlIllIl = Tessellator.getInstance();
            final BufferBuilder llllllllllIllllIIlIIIllIlIlIllII = llllllllllIllllIIlIIIllIlIlIllIl.getBuffer();
            GlStateManager.disableTexture2D();
            llllllllllIllllIIlIIIllIlIlIllII.begin(7, DefaultVertexFormats.POSITION);
            llllllllllIllllIIlIIIllIlIlIllII.pos(this.posX, this.posY + this.FONT_HEIGHT / 2, 0.0).endVertex();
            llllllllllIllllIIlIIIllIlIlIllII.pos(this.posX + llllllllllIllllIIlIIIllIlIlIlllI, this.posY + this.FONT_HEIGHT / 2, 0.0).endVertex();
            llllllllllIllllIIlIIIllIlIlIllII.pos(this.posX + llllllllllIllllIIlIIIllIlIlIlllI, this.posY + this.FONT_HEIGHT / 2 - 1.0f, 0.0).endVertex();
            llllllllllIllllIIlIIIllIlIlIllII.pos(this.posX, this.posY + this.FONT_HEIGHT / 2 - 1.0f, 0.0).endVertex();
            llllllllllIllllIIlIIIllIlIlIllIl.draw();
            GlStateManager.enableTexture2D();
        }
        if (this.underlineStyle) {
            final Tessellator llllllllllIllllIIlIIIllIlIlIlIll = Tessellator.getInstance();
            final BufferBuilder llllllllllIllllIIlIIIllIlIlIlIlI = llllllllllIllllIIlIIIllIlIlIlIll.getBuffer();
            GlStateManager.disableTexture2D();
            llllllllllIllllIIlIIIllIlIlIlIlI.begin(7, DefaultVertexFormats.POSITION);
            final int llllllllllIllllIIlIIIllIlIlIlIIl = this.underlineStyle ? -1 : 0;
            llllllllllIllllIIlIIIllIlIlIlIlI.pos(this.posX + llllllllllIllllIIlIIIllIlIlIlIIl, this.posY + this.FONT_HEIGHT, 0.0).endVertex();
            llllllllllIllllIIlIIIllIlIlIlIlI.pos(this.posX + llllllllllIllllIIlIIIllIlIlIlllI, this.posY + this.FONT_HEIGHT, 0.0).endVertex();
            llllllllllIllllIIlIIIllIlIlIlIlI.pos(this.posX + llllllllllIllllIIlIIIllIlIlIlllI, this.posY + this.FONT_HEIGHT - 1.0f, 0.0).endVertex();
            llllllllllIllllIIlIIIllIlIlIlIlI.pos(this.posX + llllllllllIllllIIlIIIllIlIlIlIIl, this.posY + this.FONT_HEIGHT - 1.0f, 0.0).endVertex();
            llllllllllIllllIIlIIIllIlIlIlIll.draw();
            GlStateManager.enableTexture2D();
        }
        this.posX += llllllllllIllllIIlIIIllIlIlIlllI;
    }
    
    public int getCharWidth(final char llllllllllIllllIIlIIIllIIllIIIIl) {
        return Math.round(this.getCharWidthFloat(llllllllllIllllIIlIIIllIIllIIIIl));
    }
    
    private static boolean isFormatColor(final char llllllllllIllllIIlIIIlIllIIIlIll) {
        return (llllllllllIllllIIlIIIlIllIIIlIll >= '0' && llllllllllIllllIIlIIIlIllIIIlIll <= '9') || (llllllllllIllllIIlIIIlIllIIIlIll >= 'a' && llllllllllIllllIIlIIIlIllIIIlIll <= 'f') || (llllllllllIllllIIlIIIlIllIIIlIll >= 'A' && llllllllllIllllIIlIIIlIllIIIlIll <= 'F');
    }
    
    private void loadGlyphTexture(final int llllllllllIllllIIlIIIlllIlIIIllI) {
        this.bindTexture(this.getUnicodePageLocation(llllllllllIllllIIlIIIlllIlIIIllI));
    }
    
    public int drawString(final String llllllllllIllllIIlIIIllIlllIIlII, final float llllllllllIllllIIlIIIllIlllIIIll, final float llllllllllIllllIIlIIIllIlllIlIlI, final int llllllllllIllllIIlIIIllIlllIlIIl, final boolean llllllllllIllllIIlIIIllIlllIlIII) {
        this.enableAlpha();
        if (this.blend) {
            GlStateManager.getBlendState(this.oldBlendState);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
        }
        this.resetStyles();
        int llllllllllIllllIIlIIIllIlllIIllI = 0;
        if (llllllllllIllllIIlIIIllIlllIlIII) {
            int llllllllllIllllIIlIIIllIlllIIlll = this.renderString(llllllllllIllllIIlIIIllIlllIIlII, llllllllllIllllIIlIIIllIlllIIIll + 1.0f, llllllllllIllllIIlIIIllIlllIlIlI + 1.0f, llllllllllIllllIIlIIIllIlllIlIIl, true);
            llllllllllIllllIIlIIIllIlllIIlll = Math.max(llllllllllIllllIIlIIIllIlllIIlll, this.renderString(llllllllllIllllIIlIIIllIlllIIlII, llllllllllIllllIIlIIIllIlllIIIll, llllllllllIllllIIlIIIllIlllIlIlI, llllllllllIllllIIlIIIllIlllIlIIl, false));
        }
        else {
            llllllllllIllllIIlIIIllIlllIIllI = this.renderString(llllllllllIllllIIlIIIllIlllIIlII, llllllllllIllllIIlIIIllIlllIIIll, llllllllllIllllIIlIIIllIlllIlIlI, llllllllllIllllIIlIIIllIlllIlIIl, false);
        }
        if (this.blend) {
            GlStateManager.setBlendState(this.oldBlendState);
        }
        return llllllllllIllllIIlIIIllIlllIIllI;
    }
    
    private ResourceLocation getUnicodePageLocation(final int llllllllllIllllIIlIIIlllIlIIllIl) {
        if (FontRenderer.unicodePageLocations[llllllllllIllllIIlIIIlllIlIIllIl] == null) {
            FontRenderer.unicodePageLocations[llllllllllIllllIIlIIIlllIlIIllIl] = new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", llllllllllIllllIIlIIIlllIlIIllIl));
            FontRenderer.unicodePageLocations[llllllllllIllllIIlIIIlllIlIIllIl] = FontUtils.getHdFontLocation(FontRenderer.unicodePageLocations[llllllllllIllllIIlIIIlllIlIIllIl]);
        }
        return FontRenderer.unicodePageLocations[llllllllllIllllIIlIIIlllIlIIllIl];
    }
    
    private float renderDefaultChar(final int llllllllllIllllIIlIIIlllIlIlIllI, final boolean llllllllllIllllIIlIIIlllIlIlllIl) {
        final int llllllllllIllllIIlIIIlllIlIlllII = llllllllllIllllIIlIIIlllIlIlIllI % 16 * 8;
        final int llllllllllIllllIIlIIIlllIlIllIll = llllllllllIllllIIlIIIlllIlIlIllI / 16 * 8;
        final int llllllllllIllllIIlIIIlllIlIllIlI = llllllllllIllllIIlIIIlllIlIlllIl ? 1 : 0;
        this.bindTexture(this.locationFontTexture);
        final float llllllllllIllllIIlIIIlllIlIllIIl = this.charWidth[llllllllllIllllIIlIIIlllIlIlIllI];
        final float llllllllllIllllIIlIIIlllIlIllIII = 7.99f;
        GL11.glBegin(5);
        GL11.glTexCoord2f(llllllllllIllllIIlIIIlllIlIlllII / 128.0f, llllllllllIllllIIlIIIlllIlIllIll / 128.0f);
        GL11.glVertex3f(this.posX + llllllllllIllllIIlIIIlllIlIllIlI, this.posY, 0.0f);
        GL11.glTexCoord2f(llllllllllIllllIIlIIIlllIlIlllII / 128.0f, (llllllllllIllllIIlIIIlllIlIllIll + 7.99f) / 128.0f);
        GL11.glVertex3f(this.posX - llllllllllIllllIIlIIIlllIlIllIlI, this.posY + 7.99f, 0.0f);
        GL11.glTexCoord2f((llllllllllIllllIIlIIIlllIlIlllII + llllllllllIllllIIlIIIlllIlIllIII - 1.0f) / 128.0f, llllllllllIllllIIlIIIlllIlIllIll / 128.0f);
        GL11.glVertex3f(this.posX + llllllllllIllllIIlIIIlllIlIllIII - 1.0f + llllllllllIllllIIlIIIlllIlIllIlI, this.posY, 0.0f);
        GL11.glTexCoord2f((llllllllllIllllIIlIIIlllIlIlllII + llllllllllIllllIIlIIIlllIlIllIII - 1.0f) / 128.0f, (llllllllllIllllIIlIIIlllIlIllIll + 7.99f) / 128.0f);
        GL11.glVertex3f(this.posX + llllllllllIllllIIlIIIlllIlIllIII - 1.0f - llllllllllIllllIIlIIIlllIlIllIlI, this.posY + 7.99f, 0.0f);
        GL11.glEnd();
        return llllllllllIllllIIlIIIlllIlIllIIl;
    }
    
    private float renderUnicodeChar(final char llllllllllIllllIIlIIIlllIIlllIII, final boolean llllllllllIllllIIlIIIlllIIlIlIll) {
        if (this.glyphWidth[llllllllllIllllIIlIIIlllIIlllIII] == 0) {
            return 0.0f;
        }
        final int llllllllllIllllIIlIIIlllIIllIllI = llllllllllIllllIIlIIIlllIIlllIII / '\u0100';
        this.loadGlyphTexture(llllllllllIllllIIlIIIlllIIllIllI);
        int llllllllllIllllIIlIIIlllIIllIlIl = this.glyphWidth[llllllllllIllllIIlIIIlllIIlllIII] >>> 4;
        final int llllllllllIllllIIlIIIlllIIllIlII = this.glyphWidth[llllllllllIllllIIlIIIlllIIlllIII] & 0xF;
        llllllllllIllllIIlIIIlllIIllIlIl &= 0xF;
        final float llllllllllIllllIIlIIIlllIIllIIll = (float)llllllllllIllllIIlIIIlllIIllIlIl;
        final float llllllllllIllllIIlIIIlllIIllIIlI = (float)(llllllllllIllllIIlIIIlllIIllIlII + 1);
        final float llllllllllIllllIIlIIIlllIIllIIIl = llllllllllIllllIIlIIIlllIIlllIII % '\u0010' * 16 + llllllllllIllllIIlIIIlllIIllIIll;
        final float llllllllllIllllIIlIIIlllIIllIIII = (float)((llllllllllIllllIIlIIIlllIIlllIII & '\u00ff') / 16 * 16);
        final float llllllllllIllllIIlIIIlllIIlIllll = llllllllllIllllIIlIIIlllIIllIIlI - llllllllllIllllIIlIIIlllIIllIIll - 0.02f;
        final float llllllllllIllllIIlIIIlllIIlIlllI = llllllllllIllllIIlIIIlllIIlIlIll ? 1.0f : 0.0f;
        GL11.glBegin(5);
        GL11.glTexCoord2f(llllllllllIllllIIlIIIlllIIllIIIl / 256.0f, llllllllllIllllIIlIIIlllIIllIIII / 256.0f);
        GL11.glVertex3f(this.posX + llllllllllIllllIIlIIIlllIIlIlllI, this.posY, 0.0f);
        GL11.glTexCoord2f(llllllllllIllllIIlIIIlllIIllIIIl / 256.0f, (llllllllllIllllIIlIIIlllIIllIIII + 15.98f) / 256.0f);
        GL11.glVertex3f(this.posX - llllllllllIllllIIlIIIlllIIlIlllI, this.posY + 7.99f, 0.0f);
        GL11.glTexCoord2f((llllllllllIllllIIlIIIlllIIllIIIl + llllllllllIllllIIlIIIlllIIlIllll) / 256.0f, llllllllllIllllIIlIIIlllIIllIIII / 256.0f);
        GL11.glVertex3f(this.posX + llllllllllIllllIIlIIIlllIIlIllll / 2.0f + llllllllllIllllIIlIIIlllIIlIlllI, this.posY, 0.0f);
        GL11.glTexCoord2f((llllllllllIllllIIlIIIlllIIllIIIl + llllllllllIllllIIlIIIlllIIlIllll) / 256.0f, (llllllllllIllllIIlIIIlllIIllIIII + 15.98f) / 256.0f);
        GL11.glVertex3f(this.posX + llllllllllIllllIIlIIIlllIIlIllll / 2.0f - llllllllllIllllIIlIIIlllIIlIlllI, this.posY + 7.99f, 0.0f);
        GL11.glEnd();
        return (llllllllllIllllIIlIIIlllIIllIIlI - llllllllllIllllIIlIIIlllIIllIIll) / 2.0f + 1.0f;
    }
    
    public String trimStringToWidth(final String llllllllllIllllIIlIIIllIIlIIlIll, final int llllllllllIllllIIlIIIllIIlIIlIlI) {
        return this.trimStringToWidth(llllllllllIllllIIlIIIllIIlIIlIll, llllllllllIllllIIlIIIllIIlIIlIlI, false);
    }
    
    public boolean getUnicodeFlag() {
        return this.unicodeFlag;
    }
}
