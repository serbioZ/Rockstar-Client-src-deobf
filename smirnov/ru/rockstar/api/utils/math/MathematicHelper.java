// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.math;

import net.minecraft.util.math.MathHelper;
import java.math.RoundingMode;
import java.math.BigDecimal;

public class MathematicHelper
{
    public static int getMiddle(final int llllllllllllIlllIllllIIlIllIllIl, final int llllllllllllIlllIllllIIlIllIllII) {
        return (llllllllllllIlllIllllIIlIllIllIl + llllllllllllIlllIllllIIlIllIllII) / 2;
    }
    
    public static double round(final double llllllllllllIlllIllllIIlIllIIlll, final double llllllllllllIlllIllllIIlIllIIllI) {
        final double llllllllllllIlllIllllIIlIllIIlIl = Math.round(llllllllllllIlllIllllIIlIllIIlll / llllllllllllIlllIllllIIlIllIIllI) * llllllllllllIlllIllllIIlIllIIllI;
        BigDecimal llllllllllllIlllIllllIIlIllIIlII = new BigDecimal(llllllllllllIlllIllllIIlIllIIlIl);
        llllllllllllIlllIllllIIlIllIIlII = llllllllllllIlllIllllIIlIllIIlII.setScale(2, RoundingMode.HALF_UP);
        return llllllllllllIlllIllllIIlIllIIlII.doubleValue();
    }
    
    public static float checkAngle(final float llllllllllllIlllIllllIIlIlIllIll, final float llllllllllllIlllIllllIIlIlIlIllI, final float llllllllllllIlllIllllIIlIlIllIIl) {
        float llllllllllllIlllIllllIIlIlIllIII = MathHelper.wrapDegrees(llllllllllllIlllIllllIIlIlIllIll - llllllllllllIlllIllllIIlIlIlIllI);
        if (llllllllllllIlllIllllIIlIlIllIII < -llllllllllllIlllIllllIIlIlIllIIl) {
            llllllllllllIlllIllllIIlIlIllIII = -llllllllllllIlllIllllIIlIlIllIIl;
        }
        if (llllllllllllIlllIllllIIlIlIllIII >= llllllllllllIlllIllllIIlIlIllIIl) {
            llllllllllllIlllIllllIIlIlIllIII = llllllllllllIlllIllllIIlIlIllIIl;
        }
        return llllllllllllIlllIllllIIlIlIllIll - llllllllllllIlllIllllIIlIlIllIII;
    }
    
    public static float randomizeFloat(final float llllllllllllIlllIllllIIlIIllllIl, final float llllllllllllIlllIllllIIlIIllllII) {
        return (float)(llllllllllllIlllIllllIIlIIllllIl + (llllllllllllIlllIllllIIlIIllllII - llllllllllllIlllIllllIIlIIllllIl) * Math.random());
    }
    
    public static float clamp(float llllllllllllIlllIllllIIlIlIIIlII, final float llllllllllllIlllIllllIIlIlIIIllI, final float llllllllllllIlllIllllIIlIlIIIIlI) {
        if (llllllllllllIlllIllllIIlIlIIIlII <= llllllllllllIlllIllllIIlIlIIIllI) {
            llllllllllllIlllIllllIIlIlIIIlII = llllllllllllIlllIllllIIlIlIIIllI;
        }
        if (llllllllllllIlllIllllIIlIlIIIlII >= llllllllllllIlllIllllIIlIlIIIIlI) {
            llllllllllllIlllIllllIIlIlIIIlII = llllllllllllIlllIllllIIlIlIIIIlI;
        }
        return llllllllllllIlllIllllIIlIlIIIlII;
    }
    
    public static float lerp(final float llllllllllllIlllIllllIIlIlIlIIII, final float llllllllllllIlllIllllIIlIlIIllll, final float llllllllllllIlllIllllIIlIlIIlllI) {
        return llllllllllllIlllIllllIIlIlIlIIII + llllllllllllIlllIllllIIlIlIIlllI * (llllllllllllIlllIllllIIlIlIIllll - llllllllllllIlllIllllIIlIlIlIIII);
    }
    
    public static BigDecimal round(final float llllllllllllIlllIllllIIlIlllIlII, final int llllllllllllIlllIllllIIlIlllIIll) {
        BigDecimal llllllllllllIlllIllllIIlIlllIlIl = new BigDecimal(Float.toString(llllllllllllIlllIllllIIlIlllIlII));
        llllllllllllIlllIllllIIlIlllIlIl = llllllllllllIlllIllllIIlIlllIlIl.setScale(llllllllllllIlllIllllIIlIlllIIll, RoundingMode.HALF_UP);
        return llllllllllllIlllIllllIIlIlllIlIl;
    }
}
