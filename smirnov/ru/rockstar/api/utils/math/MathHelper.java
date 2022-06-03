// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.math;

import java.math.RoundingMode;
import java.math.MathContext;
import java.math.BigDecimal;
import java.util.Random;

public class MathHelper
{
    private static final /* synthetic */ Random random;
    
    public static float clamp(float lllllllllllllllIlIlIlIlIIllIllIl, final float lllllllllllllllIlIlIlIlIIllIllII, final float lllllllllllllllIlIlIlIlIIllIlIll) {
        if (lllllllllllllllIlIlIlIlIIllIllIl <= lllllllllllllllIlIlIlIlIIllIllII) {
            lllllllllllllllIlIlIlIlIIllIllIl = lllllllllllllllIlIlIlIlIIllIllII;
        }
        if (lllllllllllllllIlIlIlIlIIllIllIl >= lllllllllllllllIlIlIlIlIIllIlIll) {
            lllllllllllllllIlIlIlIlIIllIllIl = lllllllllllllllIlIlIlIlIIllIlIll;
        }
        return lllllllllllllllIlIlIlIlIIllIllIl;
    }
    
    public static float lerp(final float lllllllllllllllIlIlIlIlIIllllIIl, final float lllllllllllllllIlIlIlIlIIlllIlIl, final float lllllllllllllllIlIlIlIlIIlllIlII) {
        return lllllllllllllllIlIlIlIlIIllllIIl + lllllllllllllllIlIlIlIlIIlllIlII * (lllllllllllllllIlIlIlIlIIlllIlIl - lllllllllllllllIlIlIlIlIIllllIIl);
    }
    
    public static double randomize(final double lllllllllllllllIlIlIlIlIlIIIlllI, final double lllllllllllllllIlIlIlIlIlIIIllIl) {
        final Random lllllllllllllllIlIlIlIlIlIIlIIlI = new Random();
        final double lllllllllllllllIlIlIlIlIlIIlIIIl = lllllllllllllllIlIlIlIlIlIIIllIl - lllllllllllllllIlIlIlIlIlIIIlllI;
        double lllllllllllllllIlIlIlIlIlIIlIIII = lllllllllllllllIlIlIlIlIlIIlIIlI.nextDouble() * lllllllllllllllIlIlIlIlIlIIlIIIl;
        if (lllllllllllllllIlIlIlIlIlIIlIIII > lllllllllllllllIlIlIlIlIlIIIllIl) {
            lllllllllllllllIlIlIlIlIlIIlIIII = lllllllllllllllIlIlIlIlIlIIIllIl;
        }
        double lllllllllllllllIlIlIlIlIlIIIllll = lllllllllllllllIlIlIlIlIlIIlIIII + lllllllllllllllIlIlIlIlIlIIIlllI;
        if (lllllllllllllllIlIlIlIlIlIIIllll > lllllllllllllllIlIlIlIlIlIIIllIl) {
            lllllllllllllllIlIlIlIlIlIIIllll = lllllllllllllllIlIlIlIlIlIIIllIl;
        }
        return lllllllllllllllIlIlIlIlIlIIIllll;
    }
    
    public static double getIncremental(final double lllllllllllllllIlIlIlIlIlIlIIllI, final double lllllllllllllllIlIlIlIlIlIlIIlIl) {
        final double lllllllllllllllIlIlIlIlIlIlIIlII = 1.0 / lllllllllllllllIlIlIlIlIlIlIIlIl;
        return Math.round(lllllllllllllllIlIlIlIlIlIlIIllI * lllllllllllllllIlIlIlIlIlIlIIlII) / lllllllllllllllIlIlIlIlIlIlIIlII;
    }
    
    public static BigDecimal round(final float lllllllllllllllIlIlIlIlIllIlIIll, final int lllllllllllllllIlIlIlIlIllIlIIlI) {
        BigDecimal lllllllllllllllIlIlIlIlIllIlIlII = new BigDecimal(Float.toString(lllllllllllllllIlIlIlIlIllIlIIll));
        lllllllllllllllIlIlIlIlIllIlIlII = lllllllllllllllIlIlIlIlIllIlIlII.setScale(lllllllllllllllIlIlIlIlIllIlIIlI, 4);
        return lllllllllllllllIlIlIlIlIllIlIlII;
    }
    
    public static double getRandomInRange(final double lllllllllllllllIlIlIlIlIllIlllIl, final double lllllllllllllllIlIlIlIlIllIlllII) {
        return lllllllllllllllIlIlIlIlIllIlllII + (lllllllllllllllIlIlIlIlIllIlllIl - lllllllllllllllIlIlIlIlIllIlllII) * MathHelper.random.nextDouble();
    }
    
    public static int getRandomInRange(final int lllllllllllllllIlIlIlIlIllIIllII, final int lllllllllllllllIlIlIlIlIllIIllIl) {
        return (int)(lllllllllllllllIlIlIlIlIllIIllIl + (lllllllllllllllIlIlIlIlIllIIllII - lllllllllllllllIlIlIlIlIllIIllIl) * MathHelper.random.nextDouble());
    }
    
    public static double randomNumber(final double lllllllllllllllIlIlIlIlIlIllIIll, final double lllllllllllllllIlIlIlIlIlIllIIII) {
        return Math.random() * (lllllllllllllllIlIlIlIlIlIllIIll - lllllllllllllllIlIlIlIlIlIllIIII) + lllllllllllllllIlIlIlIlIlIllIIII;
    }
    
    public static double roundToDecimalPlace(final double lllllllllllllllIlIlIlIlIlIIIIIII, final double lllllllllllllllIlIlIlIlIlIIIIIll) {
        final double lllllllllllllllIlIlIlIlIlIIIIIlI = lllllllllllllllIlIlIlIlIlIIIIIll / 2.0;
        final double lllllllllllllllIlIlIlIlIlIIIIIIl = Math.floor(lllllllllllllllIlIlIlIlIlIIIIIII / lllllllllllllllIlIlIlIlIlIIIIIll) * lllllllllllllllIlIlIlIlIlIIIIIll;
        if (lllllllllllllllIlIlIlIlIlIIIIIII >= lllllllllllllllIlIlIlIlIlIIIIIIl + lllllllllllllllIlIlIlIlIlIIIIIlI) {
            return new BigDecimal(Math.ceil(lllllllllllllllIlIlIlIlIlIIIIIII / lllllllllllllllIlIlIlIlIlIIIIIll) * lllllllllllllllIlIlIlIlIlIIIIIll, MathContext.DECIMAL64).stripTrailingZeros().doubleValue();
        }
        return new BigDecimal(lllllllllllllllIlIlIlIlIlIIIIIIl, MathContext.DECIMAL64).stripTrailingZeros().doubleValue();
    }
    
    public static double preciseRound(final double lllllllllllllllIlIlIlIlIlIlllIII, final double lllllllllllllllIlIlIlIlIlIlllIlI) {
        final double lllllllllllllllIlIlIlIlIlIlllIIl = Math.pow(10.0, lllllllllllllllIlIlIlIlIlIlllIlI);
        return Math.round(lllllllllllllllIlIlIlIlIlIlllIII * lllllllllllllllIlIlIlIlIlIlllIIl) / lllllllllllllllIlIlIlIlIlIlllIIl;
    }
    
    public static boolean isEven(final int lllllllllllllllIlIlIlIlIllIIlIII) {
        return lllllllllllllllIlIlIlIlIllIIlIII % 2 == 0;
    }
    
    public static float[] constrainAngle(final float[] lllllllllllllllIlIlIlIlIlIIlllII) {
        lllllllllllllllIlIlIlIlIlIIlllII[0] %= 360.0f;
        lllllllllllllllIlIlIlIlIlIIlllII[1] %= 360.0f;
        while (lllllllllllllllIlIlIlIlIlIIlllII[0] <= -180.0f) {
            lllllllllllllllIlIlIlIlIlIIlllII[0] += 360.0f;
        }
        while (lllllllllllllllIlIlIlIlIlIIlllII[1] <= -180.0f) {
            lllllllllllllllIlIlIlIlIlIIlllII[1] += 360.0f;
        }
        while (lllllllllllllllIlIlIlIlIlIIlllII[0] > 180.0f) {
            lllllllllllllllIlIlIlIlIlIIlllII[0] -= 360.0f;
        }
        while (lllllllllllllllIlIlIlIlIlIIlllII[1] > 180.0f) {
            lllllllllllllllIlIlIlIlIlIIlllII[1] -= 360.0f;
        }
        return lllllllllllllllIlIlIlIlIlIIlllII;
    }
    
    public static boolean isInteger(final Double lllllllllllllllIlIlIlIlIlIIllllI) {
        return lllllllllllllllIlIlIlIlIlIIllllI == Math.floor(lllllllllllllllIlIlIlIlIlIIllllI) && !Double.isInfinite(lllllllllllllllIlIlIlIlIlIIllllI);
    }
    
    public static double roundToPlace(final double lllllllllllllllIlIlIlIlIllIIIlII, final int lllllllllllllllIlIlIlIlIllIIIIll) {
        if (lllllllllllllllIlIlIlIlIllIIIIll < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lllllllllllllllIlIlIlIlIllIIIIlI = new BigDecimal(lllllllllllllllIlIlIlIlIllIIIlII);
        lllllllllllllllIlIlIlIlIllIIIIlI = lllllllllllllllIlIlIlIlIllIIIIlI.setScale(lllllllllllllllIlIlIlIlIllIIIIll, RoundingMode.HALF_UP);
        return lllllllllllllllIlIlIlIlIllIIIIlI.doubleValue();
    }
    
    public static int randomize(final int lllllllllllllllIlIlIlIlIlIlIlIll, final int lllllllllllllllIlIlIlIlIlIlIllII) {
        return -lllllllllllllllIlIlIlIlIlIlIllII + (int)(Math.random() * (lllllllllllllllIlIlIlIlIlIlIlIll + lllllllllllllllIlIlIlIlIlIlIllII + 1));
    }
    
    static {
        random = new Random();
    }
}
