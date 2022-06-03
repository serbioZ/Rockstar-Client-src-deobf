// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.math;

import ru.rockstar.api.utils.Helper;

public class GCDCalcHelper implements Helper
{
    public static float getGCD() {
        final float llllllllllIlllllIlllIlIIlIlIIIlI;
        return (llllllllllIlllllIlllIlIIlIlIIIlI = (float)(GCDCalcHelper.mc.gameSettings.mouseSensitivity * 0.6 + 0.2)) * llllllllllIlllllIlllIlIIlIlIIIlI * llllllllllIlllllIlllIlIIlIlIIIlI * 8.0f;
    }
    
    public static float getGCDValue() {
        return (float)(getGCD() * 0.15);
    }
    
    public static float getDeltaMouse(final float llllllllllIlllllIlllIlIIlIIllllI) {
        return (float)Math.round(llllllllllIlllllIlllIlIIlIIllllI / getGCDValue());
    }
    
    public static float getFixedRotation(final float llllllllllIlllllIlllIlIIlIlIIlIl) {
        return getDeltaMouse(llllllllllIlllllIlllIlIIlIlIIlIl) * getGCDValue();
    }
}
