// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

public class ColorizerGrass
{
    private static /* synthetic */ int[] grassBuffer;
    
    public static int getGrassColor(final double lllllllllllIIIIIllllIlIllIIIIIII, double lllllllllllIIIIIllllIlIlIllllIlI) {
        lllllllllllIIIIIllllIlIlIllllIlI *= lllllllllllIIIIIllllIlIllIIIIIII;
        final int lllllllllllIIIIIllllIlIlIllllllI = (int)((1.0 - lllllllllllIIIIIllllIlIllIIIIIII) * 255.0);
        final int lllllllllllIIIIIllllIlIlIlllllIl = (int)((1.0 - lllllllllllIIIIIllllIlIlIllllIlI) * 255.0);
        final int lllllllllllIIIIIllllIlIlIlllllII = lllllllllllIIIIIllllIlIlIlllllIl << 8 | lllllllllllIIIIIllllIlIlIllllllI;
        return (lllllllllllIIIIIllllIlIlIlllllII > ColorizerGrass.grassBuffer.length) ? -65281 : ColorizerGrass.grassBuffer[lllllllllllIIIIIllllIlIlIlllllII];
    }
    
    public static void setGrassBiomeColorizer(final int[] lllllllllllIIIIIllllIlIllIIIIlll) {
        ColorizerGrass.grassBuffer = lllllllllllIIIIIllllIlIllIIIIlll;
    }
    
    static {
        ColorizerGrass.grassBuffer = new int[65536];
    }
}
