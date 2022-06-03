// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.render;

public final class Shifting
{
    private static /* synthetic */ double x;
    private static /* synthetic */ double y;
    
    public double getY() {
        return Shifting.y;
    }
    
    public double getX() {
        return Shifting.x;
    }
    
    public static final void interpolate(final double lllllllllllIIllIIlIIlllIIlIlIllI, final double lllllllllllIIllIIlIIlllIIlIlIlIl, final double lllllllllllIIllIIlIIlllIIlIlIIIl) {
        Shifting.x = AnimationHelper.animate(lllllllllllIIllIIlIIlllIIlIlIllI, Shifting.x, lllllllllllIIllIIlIIlllIIlIlIIIl);
        Shifting.y = AnimationHelper.animate(lllllllllllIIllIIlIIlllIIlIlIlIl, Shifting.y, lllllllllllIIllIIlIIlllIIlIlIIIl);
    }
    
    public void animate(final double lllllllllllIIllIIlIIlllIIlIIlIll, final double lllllllllllIIllIIlIIlllIIlIIllII) {
        Shifting.x = AnimationHelper.animate(Shifting.x, lllllllllllIIllIIlIIlllIIlIIlIll, 1.0);
        Shifting.y = AnimationHelper.animate(Shifting.y, lllllllllllIIllIIlIIlllIIlIIllII, 1.0);
    }
    
    public void setY(final double lllllllllllIIllIIlIIlllIIlIIIIIl) {
        Shifting.y = lllllllllllIIllIIlIIlllIIlIIIIIl;
    }
    
    public Shifting(final float lllllllllllIIllIIlIIlllIIlIllllI, final float lllllllllllIIllIIlIIlllIIlIlllIl) {
        Shifting.x = lllllllllllIIllIIlIIlllIIlIllllI;
        Shifting.y = lllllllllllIIllIIlIIlllIIlIlllIl;
    }
    
    public void setX(final double lllllllllllIIllIIlIIlllIIlIIIllI) {
        Shifting.x = lllllllllllIIllIIlIIlllIIlIIIllI;
    }
}
