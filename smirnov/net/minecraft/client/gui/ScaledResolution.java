// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;

public class ScaledResolution
{
    private final /* synthetic */ double scaledHeightD;
    private final /* synthetic */ double scaledWidthD;
    private /* synthetic */ int scaledHeight;
    private /* synthetic */ int scaledWidth;
    private static /* synthetic */ int scaleFactor;
    
    public static int getScaleFactor() {
        return ScaledResolution.scaleFactor;
    }
    
    public double getScaledWidth_double() {
        return this.scaledWidthD;
    }
    
    public int getScaledWidth() {
        return this.scaledWidth;
    }
    
    public ScaledResolution(final Minecraft lllllllllllllIllIIIllllIlIIlllII) {
        this.scaledWidth = lllllllllllllIllIIIllllIlIIlllII.displayWidth;
        this.scaledHeight = lllllllllllllIllIIIllllIlIIlllII.displayHeight;
        ScaledResolution.scaleFactor = 1;
        final boolean lllllllllllllIllIIIllllIlIIlllll = lllllllllllllIllIIIllllIlIIlllII.isUnicode();
        int lllllllllllllIllIIIllllIlIIllllI = lllllllllllllIllIIIllllIlIIlllII.gameSettings.guiScale;
        if (lllllllllllllIllIIIllllIlIIllllI == 0) {
            lllllllllllllIllIIIllllIlIIllllI = 1000;
        }
        while (ScaledResolution.scaleFactor < lllllllllllllIllIIIllllIlIIllllI && this.scaledWidth / (ScaledResolution.scaleFactor + 1) >= 320 && this.scaledHeight / (ScaledResolution.scaleFactor + 1) >= 240) {
            ++ScaledResolution.scaleFactor;
        }
        if (lllllllllllllIllIIIllllIlIIlllll && ScaledResolution.scaleFactor % 2 != 0 && ScaledResolution.scaleFactor != 1) {
            --ScaledResolution.scaleFactor;
        }
        this.scaledWidthD = this.scaledWidth / (double)ScaledResolution.scaleFactor;
        this.scaledHeightD = this.scaledHeight / (double)ScaledResolution.scaleFactor;
        this.scaledWidth = MathHelper.ceil(this.scaledWidthD);
        this.scaledHeight = MathHelper.ceil(this.scaledHeightD);
    }
    
    public double getScaledHeight_double() {
        return this.scaledHeightD;
    }
    
    public int getScaledHeight() {
        return this.scaledHeight;
    }
}
