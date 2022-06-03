// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

public class ColorizerFoliage
{
    private static /* synthetic */ int[] foliageBuffer;
    
    public static int getFoliageColorBirch() {
        return 8431445;
    }
    
    public static int getFoliageColor(final double lllllllllllIIIlIllIllIlIlIlIlIIl, double lllllllllllIIIlIllIllIlIlIlIlIII) {
        lllllllllllIIIlIllIllIlIlIlIlIII *= lllllllllllIIIlIllIllIlIlIlIlIIl;
        final int lllllllllllIIIlIllIllIlIlIlIlIll = (int)((1.0 - lllllllllllIIIlIllIllIlIlIlIlIIl) * 255.0);
        final int lllllllllllIIIlIllIllIlIlIlIlIlI = (int)((1.0 - lllllllllllIIIlIllIllIlIlIlIlIII) * 255.0);
        return ColorizerFoliage.foliageBuffer[lllllllllllIIIlIllIllIlIlIlIlIlI << 8 | lllllllllllIIIlIllIllIlIlIlIlIll];
    }
    
    public static void setFoliageBiomeColorizer(final int[] lllllllllllIIIlIllIllIlIlIllIIll) {
        ColorizerFoliage.foliageBuffer = lllllllllllIIIlIllIllIlIlIllIIll;
    }
    
    public static int getFoliageColorBasic() {
        return 4764952;
    }
    
    public static int getFoliageColorPine() {
        return 6396257;
    }
    
    static {
        ColorizerFoliage.foliageBuffer = new int[65536];
    }
}
