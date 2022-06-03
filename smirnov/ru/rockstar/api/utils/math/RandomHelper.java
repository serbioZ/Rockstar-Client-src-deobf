// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.math;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class RandomHelper
{
    private static /* synthetic */ Random random;
    
    public static int randomNumber(final int llllllllllllIIIIIllIIlIlllIllllI, final int llllllllllllIIIIIllIIlIlllIlllIl) {
        return Math.round(llllllllllllIIIIIllIIlIlllIlllIl + (float)Math.random() * (llllllllllllIIIIIllIIlIlllIllllI - llllllllllllIIIIIllIIlIlllIlllIl));
    }
    
    public static float randomFloat(final float llllllllllllIIIIIllIIlIlllIIlllI, final float llllllllllllIIIIIllIIlIlllIIllIl) {
        return llllllllllllIIIIIllIIlIlllIIlllI + RandomHelper.random.nextFloat() * (llllllllllllIIIIIllIIlIlllIIllIl - llllllllllllIIIIIllIIlIlllIIlllI);
    }
    
    public static float nextFloat(final float llllllllllllIIIIIllIIlIlllIllIlI, final float llllllllllllIIIIIllIIlIlllIlIlll) {
        if (llllllllllllIIIIIllIIlIlllIllIlI == llllllllllllIIIIIllIIlIlllIlIlll || llllllllllllIIIIIllIIlIlllIlIlll - llllllllllllIIIIIllIIlIlllIllIlI <= 0.0f) {
            return llllllllllllIIIIIllIIlIlllIllIlI;
        }
        return (float)(llllllllllllIIIIIllIIlIlllIllIlI + (llllllllllllIIIIIllIIlIlllIlIlll - llllllllllllIIIIIllIIlIlllIllIlI) * Math.random());
    }
    
    public static double getRandomDouble(final double llllllllllllIIIIIllIIlIlllIlIlII, final double llllllllllllIIIIIllIIlIlllIlIIIl) {
        return ThreadLocalRandom.current().nextDouble(llllllllllllIIIIIllIIlIlllIlIlII, llllllllllllIIIIIllIIlIlllIlIIIl + 1.0);
    }
}
