// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.api.utils.math.MathematicHelper;
import java.awt.Color;
import java.util.regex.Pattern;

public class PalatteHelper implements Helper
{
    public static /* synthetic */ Pattern COLOR_PATTERN;
    
    public static Color TwoColorEffect(final Color lllllllllllIIIlIlIllIlllllllllII, final Color lllllllllllIIIlIlIllIllllllllIll, final double lllllllllllIIIlIlIllIllllllllIlI) {
        final double lllllllllllIIIlIlIllIllllllllllI = lllllllllllIIIlIlIllIllllllllIlI / 4.0 % 1.0;
        final float lllllllllllIIIlIlIllIlllllllllIl = MathematicHelper.clamp((float)(Math.sin(18.84955592153876 * lllllllllllIIIlIlIllIllllllllllI) / 2.0 + 0.5), 0.0f, 1.0f);
        return new Color(MathematicHelper.lerp(lllllllllllIIIlIlIllIlllllllllII.getRed() / 255.0f, lllllllllllIIIlIlIllIllllllllIll.getRed() / 255.0f, lllllllllllIIIlIlIllIlllllllllIl), MathematicHelper.lerp(lllllllllllIIIlIlIllIlllllllllII.getGreen() / 255.0f, lllllllllllIIIlIlIllIllllllllIll.getGreen() / 255.0f, lllllllllllIIIlIlIllIlllllllllIl), MathematicHelper.lerp(lllllllllllIIIlIlIllIlllllllllII.getBlue() / 255.0f, lllllllllllIIIlIlIllIllllllllIll.getBlue() / 255.0f, lllllllllllIIIlIlIllIlllllllllIl));
    }
    
    public static Color rainbow(final int lllllllllllIIIlIlIlllIIIIIIllIlI, final float lllllllllllIIIlIlIlllIIIIIIlIlIl, final float lllllllllllIIIlIlIlllIIIIIIlIlII) {
        double lllllllllllIIIlIlIlllIIIIIIlIlll = Math.ceil((double)((System.currentTimeMillis() + lllllllllllIIIlIlIlllIIIIIIllIlI) / 16L));
        lllllllllllIIIlIlIlllIIIIIIlIlll %= 360.0;
        return Color.getHSBColor((float)(lllllllllllIIIlIlIlllIIIIIIlIlll / 360.0), lllllllllllIIIlIlIlllIIIIIIlIlIl, lllllllllllIIIlIlIlllIIIIIIlIlII);
    }
    
    public static Color astolfo(final float lllllllllllIIIlIlIllIlllllllIlII, final int lllllllllllIIIlIlIllIlllllllIIII) {
        float lllllllllllIIIlIlIllIlllllllIIlI;
        for (lllllllllllIIIlIlIllIlllllllIIlI = (float)(System.currentTimeMillis() % (int)lllllllllllIIIlIlIllIlllllllIlII + lllllllllllIIIlIlIllIlllllllIIII); lllllllllllIIIlIlIllIlllllllIIlI > lllllllllllIIIlIlIllIlllllllIlII; lllllllllllIIIlIlIllIlllllllIIlI -= lllllllllllIIIlIlIllIlllllllIlII) {}
        lllllllllllIIIlIlIllIlllllllIIlI /= lllllllllllIIIlIlIllIlllllllIlII;
        if (lllllllllllIIIlIlIllIlllllllIIlI > 0.5) {
            lllllllllllIIIlIlIllIlllllllIIlI = 0.5f - (lllllllllllIIIlIlIllIlllllllIIlI - 0.5f);
        }
        lllllllllllIIIlIlIllIlllllllIIlI += 0.5f;
        return Color.getHSBColor(lllllllllllIIIlIlIllIlllllllIIlI, 0.4f, 1.0f);
    }
    
    public static Color getColorWithOpacity(final Color lllllllllllIIIlIlIlllIIIIlIIIIII, final int lllllllllllIIIlIlIlllIIIIIllllll) {
        return new Color(lllllllllllIIIlIlIlllIIIIlIIIIII.getRed(), lllllllllllIIIlIlIlllIIIIlIIIIII.getGreen(), lllllllllllIIIlIlIlllIIIIlIIIIII.getBlue(), lllllllllllIIIlIlIlllIIIIIllllll);
    }
    
    public static int getColor(final int lllllllllllIIIlIlIlllIIIIIlllIIl, final int lllllllllllIIIlIlIlllIIIIIllIlIl, final int lllllllllllIIIlIlIlllIIIIIllIlII) {
        return getColor(lllllllllllIIIlIlIlllIIIIIlllIIl, lllllllllllIIIlIlIlllIIIIIllIlIl, lllllllllllIIIlIlIlllIIIIIllIlII, 255);
    }
    
    private int getHealthColor(final EntityLivingBase lllllllllllIIIlIlIlllIIIlIIlIlll) {
        final float lllllllllllIIIlIlIlllIIIlIIllIlI = lllllllllllIIIlIlIlllIIIlIIlIlll.getHealth();
        final float lllllllllllIIIlIlIlllIIIlIIllIIl = lllllllllllIIIlIlIlllIIIlIIlIlll.getMaxHealth();
        final float lllllllllllIIIlIlIlllIIIlIIllIII = Math.max(0.0f, Math.min(lllllllllllIIIlIlIlllIIIlIIllIlI, lllllllllllIIIlIlIlllIIIlIIllIIl) / lllllllllllIIIlIlIlllIIIlIIllIIl);
        return Color.HSBtoRGB(lllllllllllIIIlIlIlllIIIlIIllIII / 3.0f, 1.0f, 1.0f) | 0xFF000000;
    }
    
    public static Color blend(final Color lllllllllllIIIlIlIlllIIIIlIlIIll, final Color lllllllllllIIIlIlIlllIIIIlIlIIlI, final double lllllllllllIIIlIlIlllIIIIlIlIIIl) {
        final float lllllllllllIIIlIlIlllIIIIlIllIll = (float)lllllllllllIIIlIlIlllIIIIlIlIIIl;
        final float lllllllllllIIIlIlIlllIIIIlIllIlI = 1.0f - lllllllllllIIIlIlIlllIIIIlIllIll;
        final float[] lllllllllllIIIlIlIlllIIIIlIllIIl = new float[3];
        final float[] lllllllllllIIIlIlIlllIIIIlIllIII = new float[3];
        lllllllllllIIIlIlIlllIIIIlIlIIll.getColorComponents(lllllllllllIIIlIlIlllIIIIlIllIIl);
        lllllllllllIIIlIlIlllIIIIlIlIIlI.getColorComponents(lllllllllllIIIlIlIlllIIIIlIllIII);
        float lllllllllllIIIlIlIlllIIIIlIlIlll = lllllllllllIIIlIlIlllIIIIlIllIIl[0] * lllllllllllIIIlIlIlllIIIIlIllIll + lllllllllllIIIlIlIlllIIIIlIllIII[0] * lllllllllllIIIlIlIlllIIIIlIllIlI;
        float lllllllllllIIIlIlIlllIIIIlIlIllI = lllllllllllIIIlIlIlllIIIIlIllIIl[1] * lllllllllllIIIlIlIlllIIIIlIllIll + lllllllllllIIIlIlIlllIIIIlIllIII[1] * lllllllllllIIIlIlIlllIIIIlIllIlI;
        float lllllllllllIIIlIlIlllIIIIlIlIlIl = lllllllllllIIIlIlIlllIIIIlIllIIl[2] * lllllllllllIIIlIlIlllIIIIlIllIll + lllllllllllIIIlIlIlllIIIIlIllIII[2] * lllllllllllIIIlIlIlllIIIIlIllIlI;
        if (lllllllllllIIIlIlIlllIIIIlIlIlll < 0.0f) {
            lllllllllllIIIlIlIlllIIIIlIlIlll = 0.0f;
        }
        else if (lllllllllllIIIlIlIlllIIIIlIlIlll > 255.0f) {
            lllllllllllIIIlIlIlllIIIIlIlIlll = 255.0f;
        }
        if (lllllllllllIIIlIlIlllIIIIlIlIllI < 0.0f) {
            lllllllllllIIIlIlIlllIIIIlIlIllI = 0.0f;
        }
        else if (lllllllllllIIIlIlIlllIIIIlIlIllI > 255.0f) {
            lllllllllllIIIlIlIlllIIIIlIlIllI = 255.0f;
        }
        if (lllllllllllIIIlIlIlllIIIIlIlIlIl < 0.0f) {
            lllllllllllIIIlIlIlllIIIIlIlIlIl = 0.0f;
        }
        else if (lllllllllllIIIlIlIlllIIIIlIlIlIl > 255.0f) {
            lllllllllllIIIlIlIlllIIIIlIlIlIl = 255.0f;
        }
        final Color lllllllllllIIIlIlIlllIIIIlIlIlII = new Color(lllllllllllIIIlIlIlllIIIIlIlIlll, lllllllllllIIIlIlIlllIIIIlIlIllI, lllllllllllIIIlIlIlllIIIIlIlIlIl);
        return lllllllllllIIIlIlIlllIIIIlIlIlII;
    }
    
    public static Color getHealthColor(final float lllllllllllIIIlIlIlllIIIllIlIIlI, final float lllllllllllIIIlIlIlllIIIllIlIIIl) {
        GlStateManager.pushMatrix();
        final float[] lllllllllllIIIlIlIlllIIIllIlIlIl = { 0.0f, 0.5f, 1.0f };
        final Color[] lllllllllllIIIlIlIlllIIIllIlIlII = { new Color(108, 0, 0), new Color(255, 51, 0), Color.GREEN };
        final float lllllllllllIIIlIlIlllIIIllIlIIll = lllllllllllIIIlIlIlllIIIllIlIIlI / lllllllllllIIIlIlIlllIIIllIlIIIl;
        GlStateManager.popMatrix();
        return blendColors(lllllllllllIIIlIlIlllIIIllIlIlIl, lllllllllllIIIlIlIlllIIIllIlIlII, lllllllllllIIIlIlIlllIIIllIlIIll).brighter();
    }
    
    public static int getColor(final int lllllllllllIIIlIlIlllIIIIIlIlIIl, final int lllllllllllIIIlIlIlllIIIIIlIllIl, final int lllllllllllIIIlIlIlllIIIIIlIIlll, final int lllllllllllIIIlIlIlllIIIIIlIIllI) {
        int lllllllllllIIIlIlIlllIIIIIlIlIlI = 0;
        lllllllllllIIIlIlIlllIIIIIlIlIlI |= lllllllllllIIIlIlIlllIIIIIlIIllI << 24;
        lllllllllllIIIlIlIlllIIIIIlIlIlI |= lllllllllllIIIlIlIlllIIIIIlIlIIl << 16;
        lllllllllllIIIlIlIlllIIIIIlIlIlI |= lllllllllllIIIlIlIlllIIIIIlIllIl << 8;
        lllllllllllIIIlIlIlllIIIIIlIlIlI |= lllllllllllIIIlIlIlllIIIIIlIIlll;
        return lllllllllllIIIlIlIlllIIIIIlIlIlI;
    }
    
    static {
        PalatteHelper.COLOR_PATTERN = Pattern.compile("(?i)&[0-9A-FK-OR]");
    }
    
    public static Color rainbow2(final int lllllllllllIIIlIlIlllIIIIIIIlIlI, final float lllllllllllIIIlIlIlllIIIIIIIlIIl, final float lllllllllllIIIlIlIlllIIIIIIIlIII) {
        double lllllllllllIIIlIlIlllIIIIIIIlIll = Math.ceil((double)(System.currentTimeMillis() / lllllllllllIIIlIlIlllIIIIIIIlIlI));
        lllllllllllIIIlIlIlllIIIIIIIlIll %= 360.0;
        return Color.getHSBColor((float)(lllllllllllIIIlIlIlllIIIIIIIlIll / 360.0), lllllllllllIIIlIlIlllIIIIIIIlIIl, lllllllllllIIIlIlIlllIIIIIIIlIII);
    }
    
    public static int[] getFractionIndicies(final float[] lllllllllllIIIlIlIlllIIIlIIIllll, final float lllllllllllIIIlIlIlllIIIlIIIlIlI) {
        final int[] lllllllllllIIIlIlIlllIIIlIIIllIl = new int[2];
        int lllllllllllIIIlIlIlllIIIlIIIllII;
        for (lllllllllllIIIlIlIlllIIIlIIIllII = 0; lllllllllllIIIlIlIlllIIIlIIIllII < lllllllllllIIIlIlIlllIIIlIIIllll.length && lllllllllllIIIlIlIlllIIIlIIIllll[lllllllllllIIIlIlIlllIIIlIIIllII] <= lllllllllllIIIlIlIlllIIIlIIIlIlI; ++lllllllllllIIIlIlIlllIIIlIIIllII) {}
        if (lllllllllllIIIlIlIlllIIIlIIIllII >= lllllllllllIIIlIlIlllIIIlIIIllll.length) {
            lllllllllllIIIlIlIlllIIIlIIIllII = lllllllllllIIIlIlIlllIIIlIIIllll.length - 1;
        }
        lllllllllllIIIlIlIlllIIIlIIIllIl[0] = lllllllllllIIIlIlIlllIIIlIIIllII - 1;
        lllllllllllIIIlIlIlllIIIlIIIllIl[1] = lllllllllllIIIlIlIlllIIIlIIIllII;
        return lllllllllllIIIlIlIlllIIIlIIIllIl;
    }
    
    public static Color blendColors(final float[] lllllllllllIIIlIlIlllIIIIlllIIll, final Color[] lllllllllllIIIlIlIlllIIIIlllllII, final float lllllllllllIIIlIlIlllIIIIllllIll) {
        Color lllllllllllIIIlIlIlllIIIIllllIlI = null;
        if (lllllllllllIIIlIlIlllIIIIlllIIll != null && lllllllllllIIIlIlIlllIIIIlllllII != null && lllllllllllIIIlIlIlllIIIIlllIIll.length == lllllllllllIIIlIlIlllIIIIlllllII.length) {
            final int[] lllllllllllIIIlIlIlllIIIIllllIIl = getFractionIndicies(lllllllllllIIIlIlIlllIIIIlllIIll, lllllllllllIIIlIlIlllIIIIllllIll);
            if (lllllllllllIIIlIlIlllIIIIllllIIl[0] < 0 || lllllllllllIIIlIlIlllIIIIllllIIl[0] >= lllllllllllIIIlIlIlllIIIIlllIIll.length || lllllllllllIIIlIlIlllIIIIllllIIl[1] < 0 || lllllllllllIIIlIlIlllIIIIllllIIl[1] >= lllllllllllIIIlIlIlllIIIIlllIIll.length) {
                return lllllllllllIIIlIlIlllIIIIlllllII[0];
            }
            final float[] lllllllllllIIIlIlIlllIIIIllllIII = { lllllllllllIIIlIlIlllIIIIlllIIll[lllllllllllIIIlIlIlllIIIIllllIIl[0]], lllllllllllIIIlIlIlllIIIIlllIIll[lllllllllllIIIlIlIlllIIIIllllIIl[1]] };
            final Color[] lllllllllllIIIlIlIlllIIIIlllIlll = { lllllllllllIIIlIlIlllIIIIlllllII[lllllllllllIIIlIlIlllIIIIllllIIl[0]], lllllllllllIIIlIlIlllIIIIlllllII[lllllllllllIIIlIlIlllIIIIllllIIl[1]] };
            final float lllllllllllIIIlIlIlllIIIIlllIllI = lllllllllllIIIlIlIlllIIIIllllIII[1] - lllllllllllIIIlIlIlllIIIIllllIII[0];
            final float lllllllllllIIIlIlIlllIIIIlllIlIl = lllllllllllIIIlIlIlllIIIIllllIll - lllllllllllIIIlIlIlllIIIIllllIII[0];
            final float lllllllllllIIIlIlIlllIIIIlllIlII = lllllllllllIIIlIlIlllIIIIlllIlIl / lllllllllllIIIlIlIlllIIIIlllIllI;
            lllllllllllIIIlIlIlllIIIIllllIlI = blend(lllllllllllIIIlIlIlllIIIIlllIlll[0], lllllllllllIIIlIlIlllIIIIlllIlll[1], 1.0f - lllllllllllIIIlIlIlllIIIIlllIlII);
        }
        return lllllllllllIIIlIlIlllIIIIllllIlI;
    }
    
    public static String stripColor(final String lllllllllllIIIlIlIllIllllllIIIlI) {
        return PalatteHelper.COLOR_PATTERN.matcher(lllllllllllIIIlIlIllIllllllIIIlI).replaceAll("");
    }
    
    public static int getColor(final Color lllllllllllIIIlIlIlllIIIIlIIIllI) {
        return getColor(lllllllllllIIIlIlIlllIIIIlIIIllI.getRed(), lllllllllllIIIlIlIlllIIIIlIIIllI.getGreen(), lllllllllllIIIlIlIlllIIIIlIIIllI.getBlue(), lllllllllllIIIlIlIlllIIIIlIIIllI.getAlpha());
    }
    
    public static int getColor(final int lllllllllllIIIlIlIlllIIIIlIIIIll) {
        return getColor(lllllllllllIIIlIlIlllIIIIlIIIIll, lllllllllllIIIlIlIlllIIIIlIIIIll, lllllllllllIIIlIlIlllIIIIlIIIIll, 255);
    }
    
    public static int getColor(final int lllllllllllIIIlIlIlllIIIIIlIIIlI, final int lllllllllllIIIlIlIlllIIIIIIlllll) {
        return getColor(lllllllllllIIIlIlIlllIIIIIlIIIlI, lllllllllllIIIlIlIlllIIIIIlIIIlI, lllllllllllIIIlIlIlllIIIIIlIIIlI, lllllllllllIIIlIlIlllIIIIIIlllll);
    }
    
    public static int reAlpha(final int lllllllllllIIIlIlIlllIIIllIIIIIl, final float lllllllllllIIIlIlIlllIIIllIIIllI) {
        final Color lllllllllllIIIlIlIlllIIIllIIIlIl = new Color(lllllllllllIIIlIlIlllIIIllIIIIIl);
        final float lllllllllllIIIlIlIlllIIIllIIIlII = 0.003921569f * lllllllllllIIIlIlIlllIIIllIIIlIl.getRed();
        final float lllllllllllIIIlIlIlllIIIllIIIIll = 0.003921569f * lllllllllllIIIlIlIlllIIIllIIIlIl.getGreen();
        final float lllllllllllIIIlIlIlllIIIllIIIIlI = 0.003921569f * lllllllllllIIIlIlIlllIIIllIIIlIl.getBlue();
        return new Color(lllllllllllIIIlIlIlllIIIllIIIlII, lllllllllllIIIlIlIlllIIIllIIIIll, lllllllllllIIIlIlIlllIIIllIIIIlI, lllllllllllIIIlIlIlllIIIllIIIllI).getRGB();
    }
    
    public static int astolfoColors(final int lllllllllllIIIlIlIlllIIIlIlIlIII, final int lllllllllllIIIlIlIlllIIIlIlIIIll) {
        float lllllllllllIIIlIlIlllIIIlIlIIllI;
        float lllllllllllIIIlIlIlllIIIlIlIIlIl;
        for (lllllllllllIIIlIlIlllIIIlIlIIllI = 2900.0f, lllllllllllIIIlIlIlllIIIlIlIIlIl = System.currentTimeMillis() % (int)lllllllllllIIIlIlIlllIIIlIlIIllI + (float)((lllllllllllIIIlIlIlllIIIlIlIIIll - lllllllllllIIIlIlIlllIIIlIlIlIII) * 9); lllllllllllIIIlIlIlllIIIlIlIIlIl > lllllllllllIIIlIlIlllIIIlIlIIllI; lllllllllllIIIlIlIlllIIIlIlIIlIl -= lllllllllllIIIlIlIlllIIIlIlIIllI) {}
        lllllllllllIIIlIlIlllIIIlIlIIlIl /= lllllllllllIIIlIlIlllIIIlIlIIllI;
        if (lllllllllllIIIlIlIlllIIIlIlIIlIl > 0.5) {
            lllllllllllIIIlIlIlllIIIlIlIIlIl = 0.5f - (lllllllllllIIIlIlIlllIIIlIlIIlIl - 0.5f);
        }
        lllllllllllIIIlIlIlllIIIlIlIIlIl += 0.5f;
        return Color.HSBtoRGB(lllllllllllIIIlIlIlllIIIlIlIIlIl, 0.5f, 1.0f);
    }
    
    public static String removeColorCode(final String lllllllllllIIIlIlIlllIIIlIllIllI) {
        String lllllllllllIIIlIlIlllIIIlIllIlIl = lllllllllllIIIlIlIlllIIIlIllIllI;
        if (lllllllllllIIIlIlIlllIIIlIllIllI.contains("¡\u00ec")) {
            for (int lllllllllllIIIlIlIlllIIIlIllIlII = 0; lllllllllllIIIlIlIlllIIIlIllIlII < lllllllllllIIIlIlIlllIIIlIllIlIl.length(); ++lllllllllllIIIlIlIlllIIIlIllIlII) {
                if (Character.toString(lllllllllllIIIlIlIlllIIIlIllIlIl.charAt(lllllllllllIIIlIlIlllIIIlIllIlII)).equals("¡\u00ec")) {
                    try {
                        final String lllllllllllIIIlIlIlllIIIlIllIIll = lllllllllllIIIlIlIlllIIIlIllIlIl.substring(0, lllllllllllIIIlIlIlllIIIlIllIlII);
                        final String lllllllllllIIIlIlIlllIIIlIllIIlI = lllllllllllIIIlIlIlllIIIlIllIlIl.substring(Math.min(lllllllllllIIIlIlIlllIIIlIllIlII + 2, lllllllllllIIIlIlIlllIIIlIllIlIl.length()));
                        lllllllllllIIIlIlIlllIIIlIllIlIl = String.valueOf(lllllllllllIIIlIlIlllIIIlIllIIll) + lllllllllllIIIlIlIlllIIIlIllIIlI;
                    }
                    catch (Exception ex) {}
                }
            }
        }
        return lllllllllllIIIlIlIlllIIIlIllIlIl;
    }
    
    public static Color astolfo(final boolean lllllllllllIIIlIlIllIllllllIlIll, final int lllllllllllIIIlIlIllIllllllIIlll) {
        float lllllllllllIIIlIlIllIllllllIlIIl;
        float lllllllllllIIIlIlIllIllllllIlIII;
        for (lllllllllllIIIlIlIllIllllllIlIIl = 2000.0f, lllllllllllIIIlIlIllIllllllIlIII = (float)(System.currentTimeMillis() % (int)lllllllllllIIIlIlIllIllllllIlIIl + lllllllllllIIIlIlIllIllllllIIlll); lllllllllllIIIlIlIllIllllllIlIII > lllllllllllIIIlIlIllIllllllIlIIl; lllllllllllIIIlIlIllIllllllIlIII -= lllllllllllIIIlIlIllIllllllIlIIl) {}
        lllllllllllIIIlIlIllIllllllIlIII /= lllllllllllIIIlIlIllIllllllIlIIl;
        if (lllllllllllIIIlIlIllIllllllIlIII > 0.5) {
            lllllllllllIIIlIlIllIllllllIlIII = 0.5f - (lllllllllllIIIlIlIllIllllllIlIII - 0.5f);
        }
        lllllllllllIIIlIlIllIllllllIlIII += 0.5f;
        return Color.getHSBColor(lllllllllllIIIlIlIllIllllllIlIII, 0.4f, 1.0f);
    }
}
