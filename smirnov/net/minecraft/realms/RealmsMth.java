// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import org.apache.commons.lang3.StringUtils;
import java.util.Random;
import net.minecraft.util.math.MathHelper;

public class RealmsMth
{
    public static double wrapDegrees(final double llllllllllllllIllIIllIlllIlllIIl) {
        return MathHelper.wrapDegrees(llllllllllllllIllIIllIlllIlllIIl);
    }
    
    public static double average(final long[] llllllllllllllIllIIllIlllIIllIll) {
        return MathHelper.average(llllllllllllllIllIIllIlllIIllIll);
    }
    
    public static float sqrt(final float llllllllllllllIllIIllIllllIllIll) {
        return MathHelper.sqrt(llllllllllllllIllIIllIllllIllIll);
    }
    
    public static int abs(final int llllllllllllllIllIIllIlllIIlIlIl) {
        return MathHelper.abs(llllllllllllllIllIIllIlllIIlIlIl);
    }
    
    public static double nextDouble(final Random llllllllllllllIllIIlllIIIIlIlIlI, final double llllllllllllllIllIIlllIIIIlIlIIl, final double llllllllllllllIllIIlllIIIIlIlIll) {
        return MathHelper.nextDouble(llllllllllllllIllIIlllIIIIlIlIlI, llllllllllllllIllIIlllIIIIlIlIIl, llllllllllllllIllIIlllIIIIlIlIll);
    }
    
    public static int ceil(final float llllllllllllllIllIIlllIIIIlIIlIl) {
        return MathHelper.ceil(llllllllllllllIllIIlllIIIIlIIlIl);
    }
    
    public static double absMax(final double llllllllllllllIllIIllIllllIIlIII, final double llllllllllllllIllIIllIllllIIIlIl) {
        return MathHelper.absMax(llllllllllllllIllIIllIllllIIlIII, llllllllllllllIllIIllIllllIIIlIl);
    }
    
    public static int fastFloor(final double llllllllllllllIllIIllIllllIIlIll) {
        return MathHelper.fastFloor(llllllllllllllIllIIllIllllIIlIll);
    }
    
    public static double clamp(final double llllllllllllllIllIIllIllllllIlll, final double llllllllllllllIllIIllIllllllIllI, final double llllllllllllllIllIIllIllllllIlIl) {
        return MathHelper.clamp(llllllllllllllIllIIllIllllllIlll, llllllllllllllIllIIllIllllllIllI, llllllllllllllIllIIllIllllllIlIl);
    }
    
    public static boolean isEmpty(final String llllllllllllllIllIIlllIIIIIIIIIl) {
        return StringUtils.isEmpty((CharSequence)llllllllllllllIllIIlllIIIIIIIIIl);
    }
    
    public static int getInt(final String llllllllllllllIllIIllIlllllIllll, final int llllllllllllllIllIIllIlllllIlllI) {
        return MathHelper.getInt(llllllllllllllIllIIllIlllllIllll, llllllllllllllIllIIllIlllllIlllI);
    }
    
    public static float sin(final float llllllllllllllIllIIlllIIIIllIIlI) {
        return MathHelper.sin(llllllllllllllIllIIlllIIIIllIIlI);
    }
    
    public static int floor(final double llllllllllllllIllIIlllIIIIlIIIll) {
        return MathHelper.floor(llllllllllllllIllIIlllIIIIlIIIll);
    }
    
    public static int intFloorDiv(final int llllllllllllllIllIIlllIIIIIlllIl, final int llllllllllllllIllIIlllIIIIIllllI) {
        return MathHelper.intFloorDiv(llllllllllllllIllIIlllIIIIIlllIl, llllllllllllllIllIIlllIIIIIllllI);
    }
    
    public static double getDouble(final String llllllllllllllIllIIllIlllllIIlll, final double llllllllllllllIllIIllIlllllIIllI) {
        return MathHelper.getDouble(llllllllllllllIllIIllIlllllIIlll, llllllllllllllIllIIllIlllllIIllI);
    }
    
    public static int smallestEncompassingPowerOfTwo(final int llllllllllllllIllIIllIllllIllllI) {
        return MathHelper.smallestEncompassingPowerOfTwo(llllllllllllllIllIIllIllllIllllI);
    }
    
    public static float wrapDegrees(final float llllllllllllllIllIIllIlllIllIllI) {
        return MathHelper.wrapDegrees(llllllllllllllIllIIllIlllIllIllI);
    }
    
    public static int floor(final float llllllllllllllIllIIllIlllIIllIIl) {
        return MathHelper.floor(llllllllllllllIllIIllIlllIIllIIl);
    }
    
    public static int log2(final int llllllllllllllIllIIllIlllllIIlII) {
        return MathHelper.log2(llllllllllllllIllIIllIlllllIIlII);
    }
    
    public static float cos(final float llllllllllllllIllIIllIllllIlIlll) {
        return MathHelper.cos(llllllllllllllIllIIllIllllIlIlll);
    }
    
    public static int absFloor(final double llllllllllllllIllIIllIlllllIIIII) {
        return MathHelper.absFloor(llllllllllllllIllIIllIlllllIIIII);
    }
    
    public static double getDouble(final String llllllllllllllIllIIllIlllIlIIllI, final double llllllllllllllIllIIllIlllIlIIlIl, final double llllllllllllllIllIIllIlllIlIIlII) {
        return MathHelper.getDouble(llllllllllllllIllIIllIlllIlIIllI, llllllllllllllIllIIllIlllIlIIlIl, llllllllllllllIllIIllIlllIlIIlII);
    }
    
    public static float clamp(final float llllllllllllllIllIIllIlllIlIllll, final float llllllllllllllIllIIllIlllIlIlllI, final float llllllllllllllIllIIllIlllIllIIII) {
        return MathHelper.clamp(llllllllllllllIllIIllIlllIlIllll, llllllllllllllIllIIllIlllIlIlllI, llllllllllllllIllIIllIlllIllIIII);
    }
    
    public static double clampedLerp(final double llllllllllllllIllIIlllIIIIIIlIIl, final double llllllllllllllIllIIlllIIIIIIlIII, final double llllllllllllllIllIIlllIIIIIIIlll) {
        return MathHelper.clampedLerp(llllllllllllllIllIIlllIIIIIIlIIl, llllllllllllllIllIIlllIIIIIIlIII, llllllllllllllIllIIlllIIIIIIIlll);
    }
    
    public static float nextFloat(final Random llllllllllllllIllIIllIlllIlllllI, final float llllllllllllllIllIIllIllllIIIIII, final float llllllllllllllIllIIllIlllIllllII) {
        return MathHelper.nextFloat(llllllllllllllIllIIllIlllIlllllI, llllllllllllllIllIIllIllllIIIIII, llllllllllllllIllIIllIlllIllllII);
    }
    
    public static int ceil(final double llllllllllllllIllIIlllIIIIIIIlII) {
        return MathHelper.ceil(llllllllllllllIllIIlllIIIIIIIlII);
    }
    
    public static int roundUp(final int llllllllllllllIllIIllIlllIlIIIIl, final int llllllllllllllIllIIllIlllIIllllI) {
        return MathHelper.roundUp(llllllllllllllIllIIllIlllIlIIIIl, llllllllllllllIllIIllIlllIIllllI);
    }
    
    public static int nextInt(final Random llllllllllllllIllIIllIlllIIIlllI, final int llllllllllllllIllIIllIlllIIlIIII, final int llllllllllllllIllIIllIlllIIIllII) {
        return MathHelper.getInt(llllllllllllllIllIIllIlllIIIlllI, llllllllllllllIllIIllIlllIIlIIII, llllllllllllllIllIIllIlllIIIllII);
    }
    
    public static int getInt(final String llllllllllllllIllIIllIllllIlIIll, final int llllllllllllllIllIIllIllllIIllll, final int llllllllllllllIllIIllIllllIIlllI) {
        return MathHelper.getInt(llllllllllllllIllIIllIllllIlIIll, llllllllllllllIllIIllIllllIIllll, llllllllllllllIllIIllIllllIIlllI);
    }
    
    public static float sqrt(final double llllllllllllllIllIIllIllllllllII) {
        return MathHelper.sqrt(llllllllllllllIllIIllIllllllllII);
    }
    
    public static int clamp(final int llllllllllllllIllIIlllIIIIIlIIlI, final int llllllllllllllIllIIlllIIIIIlIIIl, final int llllllllllllllIllIIlllIIIIIlIIll) {
        return MathHelper.clamp(llllllllllllllIllIIlllIIIIIlIIlI, llllllllllllllIllIIlllIIIIIlIIIl, llllllllllllllIllIIlllIIIIIlIIll);
    }
    
    public static float abs(final float llllllllllllllIllIIlllIIIIIllIlI) {
        return MathHelper.abs(llllllllllllllIllIIlllIIIIIllIlI);
    }
    
    public static long lfloor(final double llllllllllllllIllIIllIllllllllll) {
        return MathHelper.lFloor(llllllllllllllIllIIllIllllllllll);
    }
}
