// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui;

import ru.rockstar.api.utils.math.MathematicHelper;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.render.AnimationHelper;

public class ScreenHelper
{
    private /* synthetic */ float y;
    private /* synthetic */ float x;
    private /* synthetic */ long lastMS;
    
    public static double animate(final double lllllllllllIlIIIllIllllIIIlllIlI, double lllllllllllIlIIIllIllllIIIlllIIl, double lllllllllllIlIIIllIllllIIIlllIII) {
        final boolean lllllllllllIlIIIllIllllIIIllllIl = lllllllllllIlIIIllIllllIIIlllIlI > lllllllllllIlIIIllIllllIIIlllIIl;
        if (lllllllllllIlIIIllIllllIIIlllIII < 0.0) {
            lllllllllllIlIIIllIllllIIIlllIII = 0.0;
        }
        else if (lllllllllllIlIIIllIllllIIIlllIII > 1.0) {
            lllllllllllIlIIIllIllllIIIlllIII = 1.0;
        }
        final double lllllllllllIlIIIllIllllIIIllllII = Math.max(lllllllllllIlIIIllIllllIIIlllIlI, lllllllllllIlIIIllIllllIIIlllIIl) - Math.min(lllllllllllIlIIIllIllllIIIlllIlI, lllllllllllIlIIIllIllllIIIlllIIl);
        double lllllllllllIlIIIllIllllIIIlllIll = lllllllllllIlIIIllIllllIIIllllII * lllllllllllIlIIIllIllllIIIlllIII;
        if (lllllllllllIlIIIllIllllIIIlllIll < 0.1) {
            lllllllllllIlIIIllIllllIIIlllIll = 0.1;
        }
        if (lllllllllllIlIIIllIllllIIIllllIl) {
            lllllllllllIlIIIllIllllIIIlllIIl += lllllllllllIlIIIllIllllIIIlllIll;
        }
        else {
            lllllllllllIlIIIllIllllIIIlllIIl -= lllllllllllIlIIIllIllllIIIlllIll;
        }
        return lllllllllllIlIIIllIllllIIIlllIIl;
    }
    
    public void setX(final float lllllllllllIlIIIllIlllIlllllIIII) {
        this.x = lllllllllllIlIIIllIlllIlllllIIII;
    }
    
    public void interpolate(final float lllllllllllIlIIIllIllllIIIIIIlll, final float lllllllllllIlIIIllIllllIIIIIIllI, final double lllllllllllIlIIIllIlllIlllllllIl) {
        final long lllllllllllIlIIIllIllllIIIIIIlII = System.currentTimeMillis();
        final long lllllllllllIlIIIllIllllIIIIIIIll = lllllllllllIlIIIllIllllIIIIIIlII - this.lastMS;
        this.lastMS = lllllllllllIlIIIllIllllIIIIIIlII;
        double lllllllllllIlIIIllIllllIIIIIIIlI = 0.0;
        double lllllllllllIlIIIllIllllIIIIIIIIl = 0.0;
        if (lllllllllllIlIIIllIlllIlllllllIl != 0.0) {
            lllllllllllIlIIIllIllllIIIIIIIlI = Math.abs(lllllllllllIlIIIllIllllIIIIIIlll - this.x) * 0.35f / (10.0 / lllllllllllIlIIIllIlllIlllllllIl);
            lllllllllllIlIIIllIllllIIIIIIIIl = Math.abs(lllllllllllIlIIIllIllllIIIIIIllI - this.y) * 0.35f / (10.0 / lllllllllllIlIIIllIlllIlllllllIl);
        }
        this.x = AnimationHelper.calculateCompensation(lllllllllllIlIIIllIllllIIIIIIlll, this.x, lllllllllllIlIIIllIllllIIIIIIIll, lllllllllllIlIIIllIllllIIIIIIIlI);
        this.y = AnimationHelper.calculateCompensation(lllllllllllIlIIIllIllllIIIIIIllI, this.y, lllllllllllIlIIIllIllllIIIIIIIll, lllllllllllIlIIIllIllllIIIIIIIIl);
    }
    
    public float getX() {
        return this.x;
    }
    
    public float getY() {
        return this.y;
    }
    
    public static double linearAnimation(final double lllllllllllIlIIIllIllllIIIIlllII, final double lllllllllllIlIIIllIllllIIIIlIlIl, final double lllllllllllIlIIIllIllllIIIIllIlI) {
        final double lllllllllllIlIIIllIllllIIIIllIIl = Math.abs(lllllllllllIlIIIllIllllIIIIlllII - lllllllllllIlIIIllIllllIIIIlIlIl);
        final int lllllllllllIlIIIllIllllIIIIllIII = Minecraft.getDebugFPS();
        if (lllllllllllIlIIIllIllllIIIIllIIl > 0.0) {
            double lllllllllllIlIIIllIllllIIIIlIlll = MathematicHelper.round(Math.min(10.0, Math.max(0.005, 144.0 / lllllllllllIlIIIllIllllIIIIllIII * lllllllllllIlIIIllIllllIIIIllIlI)), 0.005);
            if (lllllllllllIlIIIllIllllIIIIllIIl != 0.0 && lllllllllllIlIIIllIllllIIIIllIIl < lllllllllllIlIIIllIllllIIIIlIlll) {
                lllllllllllIlIIIllIllllIIIIlIlll = lllllllllllIlIIIllIllllIIIIllIIl;
            }
            if (lllllllllllIlIIIllIllllIIIIlllII < lllllllllllIlIIIllIllllIIIIlIlIl) {
                return lllllllllllIlIIIllIllllIIIIlllII + lllllllllllIlIIIllIllllIIIIlIlll;
            }
            if (lllllllllllIlIIIllIllllIIIIlllII > lllllllllllIlIIIllIllllIIIIlIlIl) {
                return lllllllllllIlIIIllIllllIIIIlllII - lllllllllllIlIIIllIllllIIIIlIlll;
            }
        }
        return lllllllllllIlIIIllIllllIIIIlllII;
    }
    
    public float bebra(final float lllllllllllIlIIIllIllllIIlIIllII, final float lllllllllllIlIIIllIllllIIlIIlIII, final float lllllllllllIlIIIllIllllIIlIIlIlI) {
        return lllllllllllIlIIIllIllllIIlIIllII + lllllllllllIlIIIllIllllIIlIIlIlI * (lllllllllllIlIIIllIllllIIlIIlIII - lllllllllllIlIIIllIllllIIlIIllII);
    }
    
    public ScreenHelper(final float lllllllllllIlIIIllIllllIIlIlIIlI, final float lllllllllllIlIIIllIllllIIlIlIIIl) {
        this.x = lllllllllllIlIIIllIllllIIlIlIIlI;
        this.y = lllllllllllIlIIIllIllllIIlIlIIIl;
        this.lastMS = System.currentTimeMillis();
    }
    
    public static double progressiveAnimation(final double lllllllllllIlIIIllIllllIIIlIlllI, final double lllllllllllIlIIIllIllllIIIlIllIl, final double lllllllllllIlIIIllIllllIIIlIllII) {
        final double lllllllllllIlIIIllIllllIIIlIlIll = Math.abs(lllllllllllIlIIIllIllllIIIlIlllI - lllllllllllIlIIIllIllllIIIlIllIl);
        final int lllllllllllIlIIIllIllllIIIlIlIlI = Minecraft.getDebugFPS();
        if (lllllllllllIlIIIllIllllIIIlIlIll > 0.0) {
            double lllllllllllIlIIIllIllllIIIlIlIIl = MathematicHelper.round(Math.min(10.0, Math.max(0.05, 144.0 / lllllllllllIlIIIllIllllIIIlIlIlI * (lllllllllllIlIIIllIllllIIIlIlIll / 10.0) * lllllllllllIlIIIllIllllIIIlIllII)), 0.05);
            if (lllllllllllIlIIIllIllllIIIlIlIll < lllllllllllIlIIIllIllllIIIlIlIIl) {
                lllllllllllIlIIIllIllllIIIlIlIIl = lllllllllllIlIIIllIllllIIIlIlIll;
            }
            if (lllllllllllIlIIIllIllllIIIlIlllI < lllllllllllIlIIIllIllllIIIlIllIl) {
                return lllllllllllIlIIIllIllllIIIlIlllI + lllllllllllIlIIIllIllllIIIlIlIIl;
            }
            if (lllllllllllIlIIIllIllllIIIlIlllI > lllllllllllIlIIIllIllllIIIlIllIl) {
                return lllllllllllIlIIIllIllllIIIlIlllI - lllllllllllIlIIIllIllllIIIlIlIIl;
            }
        }
        return lllllllllllIlIIIllIllllIIIlIlllI;
    }
    
    public void setY(final float lllllllllllIlIIIllIlllIllllIIlll) {
        this.y = lllllllllllIlIIIllIlllIllllIIlll;
    }
}
