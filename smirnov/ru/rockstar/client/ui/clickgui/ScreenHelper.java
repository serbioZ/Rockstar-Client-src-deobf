// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui;

import ru.rockstar.api.utils.render.AnimationHelper;
import ru.rockstar.api.utils.math.MathematicHelper;
import net.minecraft.client.Minecraft;

public class ScreenHelper
{
    private /* synthetic */ float x;
    private /* synthetic */ long lastMS;
    private /* synthetic */ float y;
    
    public float bebra(final float lllllllllllIlIllIIlllIIIIIIllllI, final float lllllllllllIlIllIIlllIIIIIlIIIII, final float lllllllllllIlIllIIlllIIIIIIlllII) {
        return lllllllllllIlIllIIlllIIIIIIllllI + lllllllllllIlIllIIlllIIIIIIlllII * (lllllllllllIlIllIIlllIIIIIlIIIII - lllllllllllIlIllIIlllIIIIIIllllI);
    }
    
    public static double progressiveAnimation(final double lllllllllllIlIllIIlllIIIIIIIIIll, final double lllllllllllIlIllIIllIlllllllllII, final double lllllllllllIlIllIIllIllllllllIll) {
        final double lllllllllllIlIllIIlllIIIIIIIIIII = Math.abs(lllllllllllIlIllIIlllIIIIIIIIIll - lllllllllllIlIllIIllIlllllllllII);
        final int lllllllllllIlIllIIllIlllllllllll = Minecraft.getDebugFPS();
        if (lllllllllllIlIllIIlllIIIIIIIIIII > 0.0) {
            double lllllllllllIlIllIIllIllllllllllI = MathematicHelper.round(Math.min(10.0, Math.max(0.05, 144.0 / lllllllllllIlIllIIllIlllllllllll * (lllllllllllIlIllIIlllIIIIIIIIIII / 10.0) * lllllllllllIlIllIIllIllllllllIll)), 0.05);
            if (lllllllllllIlIllIIlllIIIIIIIIIII < lllllllllllIlIllIIllIllllllllllI) {
                lllllllllllIlIllIIllIllllllllllI = lllllllllllIlIllIIlllIIIIIIIIIII;
            }
            if (lllllllllllIlIllIIlllIIIIIIIIIll < lllllllllllIlIllIIllIlllllllllII) {
                return lllllllllllIlIllIIlllIIIIIIIIIll + lllllllllllIlIllIIllIllllllllllI;
            }
            if (lllllllllllIlIllIIlllIIIIIIIIIll > lllllllllllIlIllIIllIlllllllllII) {
                return lllllllllllIlIllIIlllIIIIIIIIIll - lllllllllllIlIllIIllIllllllllllI;
            }
        }
        return lllllllllllIlIllIIlllIIIIIIIIIll;
    }
    
    public void setX(final float lllllllllllIlIllIIllIlllllIIIlIl) {
        this.x = lllllllllllIlIllIIllIlllllIIIlIl;
    }
    
    public float getY() {
        return this.y;
    }
    
    public ScreenHelper(final float lllllllllllIlIllIIlllIIIIIlIlIlI, final float lllllllllllIlIllIIlllIIIIIlIIllI) {
        this.x = lllllllllllIlIllIIlllIIIIIlIlIlI;
        this.y = lllllllllllIlIllIIlllIIIIIlIIllI;
        this.lastMS = System.currentTimeMillis();
    }
    
    public float getX() {
        return this.x;
    }
    
    public void setY(final float lllllllllllIlIllIIllIllllIllllII) {
        this.y = lllllllllllIlIllIIllIllllIllllII;
    }
    
    public static double animate(final double lllllllllllIlIllIIlllIIIIIIIllll, double lllllllllllIlIllIIlllIIIIIIIlllI, double lllllllllllIlIllIIlllIIIIIIIllIl) {
        final boolean lllllllllllIlIllIIlllIIIIIIlIIlI = lllllllllllIlIllIIlllIIIIIIIllll > lllllllllllIlIllIIlllIIIIIIIlllI;
        if (lllllllllllIlIllIIlllIIIIIIIllIl < 0.0) {
            lllllllllllIlIllIIlllIIIIIIIllIl = 0.0;
        }
        else if (lllllllllllIlIllIIlllIIIIIIIllIl > 1.0) {
            lllllllllllIlIllIIlllIIIIIIIllIl = 1.0;
        }
        final double lllllllllllIlIllIIlllIIIIIIlIIIl = Math.max(lllllllllllIlIllIIlllIIIIIIIllll, lllllllllllIlIllIIlllIIIIIIIlllI) - Math.min(lllllllllllIlIllIIlllIIIIIIIllll, lllllllllllIlIllIIlllIIIIIIIlllI);
        double lllllllllllIlIllIIlllIIIIIIlIIII = lllllllllllIlIllIIlllIIIIIIlIIIl * lllllllllllIlIllIIlllIIIIIIIllIl;
        if (lllllllllllIlIllIIlllIIIIIIlIIII < 0.1) {
            lllllllllllIlIllIIlllIIIIIIlIIII = 0.1;
        }
        if (lllllllllllIlIllIIlllIIIIIIlIIlI) {
            lllllllllllIlIllIIlllIIIIIIIlllI += lllllllllllIlIllIIlllIIIIIIlIIII;
        }
        else {
            lllllllllllIlIllIIlllIIIIIIIlllI -= lllllllllllIlIllIIlllIIIIIIlIIII;
        }
        return lllllllllllIlIllIIlllIIIIIIIlllI;
    }
    
    public void interpolate(final float lllllllllllIlIllIIllIlllllIlIlII, final float lllllllllllIlIllIIllIlllllIllIll, final double lllllllllllIlIllIIllIlllllIllIlI) {
        final long lllllllllllIlIllIIllIlllllIllIIl = System.currentTimeMillis();
        final long lllllllllllIlIllIIllIlllllIllIII = lllllllllllIlIllIIllIlllllIllIIl - this.lastMS;
        this.lastMS = lllllllllllIlIllIIllIlllllIllIIl;
        double lllllllllllIlIllIIllIlllllIlIlll = 0.0;
        double lllllllllllIlIllIIllIlllllIlIllI = 0.0;
        if (lllllllllllIlIllIIllIlllllIllIlI != 0.0) {
            lllllllllllIlIllIIllIlllllIlIlll = Math.abs(lllllllllllIlIllIIllIlllllIlIlII - this.x) * 0.35f / (10.0 / lllllllllllIlIllIIllIlllllIllIlI);
            lllllllllllIlIllIIllIlllllIlIllI = Math.abs(lllllllllllIlIllIIllIlllllIllIll - this.y) * 0.35f / (10.0 / lllllllllllIlIllIIllIlllllIllIlI);
        }
        this.x = AnimationHelper.calculateCompensation(lllllllllllIlIllIIllIlllllIlIlII, this.x, lllllllllllIlIllIIllIlllllIllIII, lllllllllllIlIllIIllIlllllIlIlll);
        this.y = AnimationHelper.calculateCompensation(lllllllllllIlIllIIllIlllllIllIll, this.y, lllllllllllIlIllIIllIlllllIllIII, lllllllllllIlIllIIllIlllllIlIllI);
    }
    
    public static double linearAnimation(final double lllllllllllIlIllIIllIllllllIlIll, final double lllllllllllIlIllIIllIlllllllIIII, final double lllllllllllIlIllIIllIllllllIlIIl) {
        final double lllllllllllIlIllIIllIllllllIlllI = Math.abs(lllllllllllIlIllIIllIllllllIlIll - lllllllllllIlIllIIllIlllllllIIII);
        final int lllllllllllIlIllIIllIllllllIllIl = Minecraft.getDebugFPS();
        if (lllllllllllIlIllIIllIllllllIlllI > 0.0) {
            double lllllllllllIlIllIIllIllllllIllII = MathematicHelper.round(Math.min(10.0, Math.max(0.005, 144.0 / lllllllllllIlIllIIllIllllllIllIl * lllllllllllIlIllIIllIllllllIlIIl)), 0.005);
            if (lllllllllllIlIllIIllIllllllIlllI != 0.0 && lllllllllllIlIllIIllIllllllIlllI < lllllllllllIlIllIIllIllllllIllII) {
                lllllllllllIlIllIIllIllllllIllII = lllllllllllIlIllIIllIllllllIlllI;
            }
            if (lllllllllllIlIllIIllIllllllIlIll < lllllllllllIlIllIIllIlllllllIIII) {
                return lllllllllllIlIllIIllIllllllIlIll + lllllllllllIlIllIIllIllllllIllII;
            }
            if (lllllllllllIlIllIIllIllllllIlIll > lllllllllllIlIllIIllIlllllllIIII) {
                return lllllllllllIlIllIIllIllllllIlIll - lllllllllllIlIllIIllIllllllIllII;
            }
        }
        return lllllllllllIlIllIIllIllllllIlIll;
    }
}
