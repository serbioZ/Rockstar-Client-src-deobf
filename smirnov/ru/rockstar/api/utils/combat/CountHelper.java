// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.combat;

import java.util.Random;

public final class CountHelper
{
    public static float nextFloat(final float lllllllllllllllIIIllIIIIIlIllllI, final float lllllllllllllllIIIllIIIIIlIlllll) {
        if (lllllllllllllllIIIllIIIIIlIllllI == lllllllllllllllIIIllIIIIIlIlllll || lllllllllllllllIIIllIIIIIlIlllll - lllllllllllllllIIIllIIIIIlIllllI <= 0.0f) {
            return lllllllllllllllIIIllIIIIIlIllllI;
        }
        return (float)(lllllllllllllllIIIllIIIIIlIllllI + (lllllllllllllllIIIllIIIIIlIlllll - lllllllllllllllIIIllIIIIIlIllllI) * Math.random());
    }
    
    public static double nextDouble(final double lllllllllllllllIIIllIIIIIllIIlII, final double lllllllllllllllIIIllIIIIIllIIlIl) {
        if (lllllllllllllllIIIllIIIIIllIIlII == lllllllllllllllIIIllIIIIIllIIlIl || lllllllllllllllIIIllIIIIIllIIlIl - lllllllllllllllIIIllIIIIIllIIlII <= 0.0) {
            return lllllllllllllllIIIllIIIIIllIIlII;
        }
        return lllllllllllllllIIIllIIIIIllIIlII + (lllllllllllllllIIIllIIIIIllIIlIl - lllllllllllllllIIIllIIIIIllIIlII) * Math.random();
    }
    
    public static Random getRandom() {
        return new Random();
    }
    
    public static String random(final int lllllllllllllllIIIllIIIIIlIllIII, final String lllllllllllllllIIIllIIIIIlIlIlll) {
        return random(lllllllllllllllIIIllIIIIIlIllIII, lllllllllllllllIIIllIIIIIlIlIlll.toCharArray());
    }
    
    public static String random(final int lllllllllllllllIIIllIIIIIlIIlllI, final char[] lllllllllllllllIIIllIIIIIlIIllIl) {
        final StringBuilder lllllllllllllllIIIllIIIIIlIlIIII = new StringBuilder();
        for (int lllllllllllllllIIIllIIIIIlIIllll = 0; lllllllllllllllIIIllIIIIIlIIllll < lllllllllllllllIIIllIIIIIlIIlllI; ++lllllllllllllllIIIllIIIIIlIIllll) {
            lllllllllllllllIIIllIIIIIlIlIIII.append(lllllllllllllllIIIllIIIIIlIIllIl[getRandom().nextInt(lllllllllllllllIIIllIIIIIlIIllIl.length)]);
        }
        return lllllllllllllllIIIllIIIIIlIlIIII.toString();
    }
    
    public static int nextInt(final int lllllllllllllllIIIllIIIIIllIlIlI, final int lllllllllllllllIIIllIIIIIllIlIIl) {
        if (lllllllllllllllIIIllIIIIIllIlIlI == lllllllllllllllIIIllIIIIIllIlIIl || lllllllllllllllIIIllIIIIIllIlIIl - lllllllllllllllIIIllIIIIIllIlIlI <= 0) {
            return lllllllllllllllIIIllIIIIIllIlIlI;
        }
        return lllllllllllllllIIIllIIIIIllIlIlI + getRandom().nextInt(lllllllllllllllIIIllIIIIIllIlIIl - lllllllllllllllIIIllIIIIIllIlIlI);
    }
}
