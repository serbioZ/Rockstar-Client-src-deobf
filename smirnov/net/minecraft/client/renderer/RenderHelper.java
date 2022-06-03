// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import java.awt.Color;
import net.minecraft.util.math.Vec3d;
import java.nio.FloatBuffer;

public class RenderHelper
{
    private static final /* synthetic */ FloatBuffer COLOR_BUFFER;
    private static final /* synthetic */ Vec3d LIGHT1_POS;
    private static final /* synthetic */ Vec3d LIGHT0_POS;
    
    public static void color(final int lllllllllllIIlllIIllIIIlIlIIIIlI) {
        final float lllllllllllIIlllIIllIIIlIlIIIllI = (lllllllllllIIlllIIllIIIlIlIIIIlI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIlllIIllIIIlIlIIIlIl = (lllllllllllIIlllIIllIIIlIlIIIIlI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIlllIIllIIIlIlIIIlII = (lllllllllllIIlllIIllIIIlIlIIIIlI & 0xFF) / 255.0f;
        final float lllllllllllIIlllIIllIIIlIlIIIIll = (lllllllllllIIlllIIllIIIlIlIIIIlI >> 24 & 0xFF) / 255.0f;
        GlStateManager.color(lllllllllllIIlllIIllIIIlIlIIIllI, lllllllllllIIlllIIllIIIlIlIIIlIl, lllllllllllIIlllIIllIIIlIlIIIlII, lllllllllllIIlllIIllIIIlIlIIIIll);
    }
    
    private static FloatBuffer setColorBuffer(final double lllllllllllIIlllIIllIIIlIIIlIlIl, final double lllllllllllIIlllIIllIIIlIIIlIlII, final double lllllllllllIIlllIIllIIIlIIIlIIll, final double lllllllllllIIlllIIllIIIlIIIlIllI) {
        return setColorBuffer((float)lllllllllllIIlllIIllIIIlIIIlIlIl, (float)lllllllllllIIlllIIllIIIlIIIlIlII, (float)lllllllllllIIlllIIllIIIlIIIlIIll, (float)lllllllllllIIlllIIllIIIlIIIlIllI);
    }
    
    public static void disableStandardItemLighting() {
        GlStateManager.disableLighting();
        GlStateManager.disableLight(0);
        GlStateManager.disableLight(1);
        GlStateManager.disableColorMaterial();
    }
    
    public static FloatBuffer setColorBuffer(final float lllllllllllIIlllIIllIIIlIIIIllIl, final float lllllllllllIIlllIIllIIIlIIIIlIII, final float lllllllllllIIlllIIllIIIlIIIIIlll, final float lllllllllllIIlllIIllIIIlIIIIlIlI) {
        RenderHelper.COLOR_BUFFER.clear();
        RenderHelper.COLOR_BUFFER.put(lllllllllllIIlllIIllIIIlIIIIllIl).put(lllllllllllIIlllIIllIIIlIIIIlIII).put(lllllllllllIIlllIIllIIIlIIIIIlll).put(lllllllllllIIlllIIllIIIlIIIIlIlI);
        RenderHelper.COLOR_BUFFER.flip();
        return RenderHelper.COLOR_BUFFER;
    }
    
    public static void enableGUIStandardItemLighting() {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-30.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(165.0f, 1.0f, 0.0f, 0.0f);
        enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    public static void enableStandardItemLighting() {
        GlStateManager.enableLighting();
        GlStateManager.enableLight(0);
        GlStateManager.enableLight(1);
        GlStateManager.enableColorMaterial();
        GlStateManager.colorMaterial(1032, 5634);
        GlStateManager.glLight(16384, 4611, setColorBuffer(RenderHelper.LIGHT0_POS.xCoord, RenderHelper.LIGHT0_POS.yCoord, RenderHelper.LIGHT0_POS.zCoord, 0.0));
        final float lllllllllllIIlllIIllIIIlIIlIIIIl = 0.6f;
        GlStateManager.glLight(16384, 4609, setColorBuffer(0.6f, 0.6f, 0.6f, 1.0f));
        GlStateManager.glLight(16384, 4608, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GlStateManager.glLight(16384, 4610, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GlStateManager.glLight(16385, 4611, setColorBuffer(RenderHelper.LIGHT1_POS.xCoord, RenderHelper.LIGHT1_POS.yCoord, RenderHelper.LIGHT1_POS.zCoord, 0.0));
        GlStateManager.glLight(16385, 4609, setColorBuffer(0.6f, 0.6f, 0.6f, 1.0f));
        GlStateManager.glLight(16385, 4608, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GlStateManager.glLight(16385, 4610, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GlStateManager.shadeModel(7424);
        final float lllllllllllIIlllIIllIIIlIIlIIIII = 0.4f;
        GlStateManager.glLightModel(2899, setColorBuffer(0.4f, 0.4f, 0.4f, 1.0f));
    }
    
    public static void color(final float lllllllllllIIlllIIllIIIlIlIlIIlI, final float lllllllllllIIlllIIllIIIlIlIlIIIl, final float lllllllllllIIlllIIllIIIlIlIlIIII) {
        color(lllllllllllIIlllIIllIIIlIlIlIIlI, lllllllllllIIlllIIllIIIlIlIlIIIl, lllllllllllIIlllIIllIIIlIlIlIIII, 1.0f);
    }
    
    public static void color(Color lllllllllllIIlllIIllIIIlIlIIllIl) {
        if (lllllllllllIIlllIIllIIIlIlIIllIl == null) {
            lllllllllllIIlllIIllIIIlIlIIllIl = Color.white;
        }
        color(((Color)lllllllllllIIlllIIllIIIlIlIIllIl).getRed() / 255.0f, ((Color)lllllllllllIIlllIIllIIIlIlIIllIl).getGreen() / 255.0f, ((Color)lllllllllllIIlllIIllIIIlIlIIllIl).getBlue() / 255.0f, ((Color)lllllllllllIIlllIIllIIIlIlIIllIl).getAlpha() / 255.0f);
    }
    
    public static void color(final float lllllllllllIIlllIIllIIIlIlIlllII, final float lllllllllllIIlllIIllIIIlIlIllIll, final float lllllllllllIIlllIIllIIIlIlIllllI, final float lllllllllllIIlllIIllIIIlIlIllIIl) {
        GlStateManager.color(lllllllllllIIlllIIllIIIlIlIlllII, lllllllllllIIlllIIllIIIlIlIllIll, lllllllllllIIlllIIllIIIlIlIllllI, lllllllllllIIlllIIllIIIlIlIllIIl);
    }
    
    static {
        COLOR_BUFFER = GLAllocation.createDirectFloatBuffer(4);
        LIGHT0_POS = new Vec3d(0.20000000298023224, 1.0, -0.699999988079071).normalize();
        LIGHT1_POS = new Vec3d(-0.20000000298023224, 1.0, 0.699999988079071).normalize();
    }
    
    public static Color getGradientOffset(final Color lllllllllllIIlllIIllIIIlIIllIlIl, final Color lllllllllllIIlllIIllIIIlIIllIlII, double lllllllllllIIlllIIllIIIlIIlIlIIl, final int lllllllllllIIlllIIllIIIlIIlIlIII) {
        if (lllllllllllIIlllIIllIIIlIIlIlIIl > 1.0) {
            final double lllllllllllIIlllIIllIIIlIIllIIIl = lllllllllllIIlllIIllIIIlIIlIlIIl % 1.0;
            final int lllllllllllIIlllIIllIIIlIIllIIII = (int)lllllllllllIIlllIIllIIIlIIlIlIIl;
            lllllllllllIIlllIIllIIIlIIlIlIIl = ((lllllllllllIIlllIIllIIIlIIllIIII % 2 == 0) ? lllllllllllIIlllIIllIIIlIIllIIIl : (1.0 - lllllllllllIIlllIIllIIIlIIllIIIl));
        }
        final double lllllllllllIIlllIIllIIIlIIlIllll = 1.0 - lllllllllllIIlllIIllIIIlIIlIlIIl;
        final int lllllllllllIIlllIIllIIIlIIlIlllI = (int)(lllllllllllIIlllIIllIIIlIIllIlIl.getRed() * lllllllllllIIlllIIllIIIlIIlIllll + lllllllllllIIlllIIllIIIlIIllIlII.getRed() * lllllllllllIIlllIIllIIIlIIlIlIIl);
        final int lllllllllllIIlllIIllIIIlIIlIllIl = (int)(lllllllllllIIlllIIllIIIlIIllIlIl.getGreen() * lllllllllllIIlllIIllIIIlIIlIllll + lllllllllllIIlllIIllIIIlIIllIlII.getGreen() * lllllllllllIIlllIIllIIIlIIlIlIIl);
        final int lllllllllllIIlllIIllIIIlIIlIllII = (int)(lllllllllllIIlllIIllIIIlIIllIlIl.getBlue() * lllllllllllIIlllIIllIIIlIIlIllll + lllllllllllIIlllIIllIIIlIIllIlII.getBlue() * lllllllllllIIlllIIllIIIlIIlIlIIl);
        return new Color(lllllllllllIIlllIIllIIIlIIlIlllI, lllllllllllIIlllIIllIIIlIIlIllIl, lllllllllllIIlllIIllIIIlIIlIllII, lllllllllllIIlllIIllIIIlIIlIlIII);
    }
}
