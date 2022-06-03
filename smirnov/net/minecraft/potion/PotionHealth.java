// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.potion;

public class PotionHealth extends Potion
{
    @Override
    public boolean isReady(final int lllllllllllIIIllIIlIlIIIIlllIlIl, final int lllllllllllIIIllIIlIlIIIIlllIlII) {
        return lllllllllllIIIllIIlIlIIIIlllIlIl >= 1;
    }
    
    @Override
    public boolean isInstant() {
        return true;
    }
    
    public PotionHealth(final boolean lllllllllllIIIllIIlIlIIIIlllllIl, final int lllllllllllIIIllIIlIlIIIIllllIIl) {
        super(lllllllllllIIIllIIlIlIIIIlllllIl, lllllllllllIIIllIIlIlIIIIllllIIl);
    }
}
