// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerRemoveTooMuchOcean extends GenLayer
{
    public GenLayerRemoveTooMuchOcean(final long lllllllllllIIIlllllIlIlIIIllllII, final GenLayer lllllllllllIIIlllllIlIlIIIlllIII) {
        super(lllllllllllIIIlllllIlIlIIIllllII);
        this.parent = lllllllllllIIIlllllIlIlIIIlllIII;
    }
    
    @Override
    public int[] getInts(final int lllllllllllIIIlllllIlIlIIIlIIlII, final int lllllllllllIIIlllllIlIlIIIIlIIIl, final int lllllllllllIIIlllllIlIlIIIlIIIlI, final int lllllllllllIIIlllllIlIlIIIIIllll) {
        final int lllllllllllIIIlllllIlIlIIIlIIIII = lllllllllllIIIlllllIlIlIIIlIIlII - 1;
        final int lllllllllllIIIlllllIlIlIIIIlllll = lllllllllllIIIlllllIlIlIIIIlIIIl - 1;
        final int lllllllllllIIIlllllIlIlIIIIllllI = lllllllllllIIIlllllIlIlIIIlIIIlI + 2;
        final int lllllllllllIIIlllllIlIlIIIIlllIl = lllllllllllIIIlllllIlIlIIIIIllll + 2;
        final int[] lllllllllllIIIlllllIlIlIIIIlllII = this.parent.getInts(lllllllllllIIIlllllIlIlIIIlIIIII, lllllllllllIIIlllllIlIlIIIIlllll, lllllllllllIIIlllllIlIlIIIIllllI, lllllllllllIIIlllllIlIlIIIIlllIl);
        final int[] lllllllllllIIIlllllIlIlIIIIllIll = IntCache.getIntCache(lllllllllllIIIlllllIlIlIIIlIIIlI * lllllllllllIIIlllllIlIlIIIIIllll);
        for (int lllllllllllIIIlllllIlIlIIIIllIlI = 0; lllllllllllIIIlllllIlIlIIIIllIlI < lllllllllllIIIlllllIlIlIIIIIllll; ++lllllllllllIIIlllllIlIlIIIIllIlI) {
            for (int lllllllllllIIIlllllIlIlIIIIllIIl = 0; lllllllllllIIIlllllIlIlIIIIllIIl < lllllllllllIIIlllllIlIlIIIlIIIlI; ++lllllllllllIIIlllllIlIlIIIIllIIl) {
                final int lllllllllllIIIlllllIlIlIIIIllIII = lllllllllllIIIlllllIlIlIIIIlllII[lllllllllllIIIlllllIlIlIIIIllIIl + 1 + (lllllllllllIIIlllllIlIlIIIIllIlI + 1 - 1) * (lllllllllllIIIlllllIlIlIIIlIIIlI + 2)];
                final int lllllllllllIIIlllllIlIlIIIIlIlll = lllllllllllIIIlllllIlIlIIIIlllII[lllllllllllIIIlllllIlIlIIIIllIIl + 1 + 1 + (lllllllllllIIIlllllIlIlIIIIllIlI + 1) * (lllllllllllIIIlllllIlIlIIIlIIIlI + 2)];
                final int lllllllllllIIIlllllIlIlIIIIlIllI = lllllllllllIIIlllllIlIlIIIIlllII[lllllllllllIIIlllllIlIlIIIIllIIl + 1 - 1 + (lllllllllllIIIlllllIlIlIIIIllIlI + 1) * (lllllllllllIIIlllllIlIlIIIlIIIlI + 2)];
                final int lllllllllllIIIlllllIlIlIIIIlIlIl = lllllllllllIIIlllllIlIlIIIIlllII[lllllllllllIIIlllllIlIlIIIIllIIl + 1 + (lllllllllllIIIlllllIlIlIIIIllIlI + 1 + 1) * (lllllllllllIIIlllllIlIlIIIlIIIlI + 2)];
                final int lllllllllllIIIlllllIlIlIIIIlIlII = lllllllllllIIIlllllIlIlIIIIlllII[lllllllllllIIIlllllIlIlIIIIllIIl + 1 + (lllllllllllIIIlllllIlIlIIIIllIlI + 1) * lllllllllllIIIlllllIlIlIIIIllllI];
                lllllllllllIIIlllllIlIlIIIIllIll[lllllllllllIIIlllllIlIlIIIIllIIl + lllllllllllIIIlllllIlIlIIIIllIlI * lllllllllllIIIlllllIlIlIIIlIIIlI] = lllllllllllIIIlllllIlIlIIIIlIlII;
                this.initChunkSeed(lllllllllllIIIlllllIlIlIIIIllIIl + lllllllllllIIIlllllIlIlIIIlIIlII, lllllllllllIIIlllllIlIlIIIIllIlI + lllllllllllIIIlllllIlIlIIIIlIIIl);
                if (lllllllllllIIIlllllIlIlIIIIlIlII == 0 && lllllllllllIIIlllllIlIlIIIIllIII == 0 && lllllllllllIIIlllllIlIlIIIIlIlll == 0 && lllllllllllIIIlllllIlIlIIIIlIllI == 0 && lllllllllllIIIlllllIlIlIIIIlIlIl == 0 && this.nextInt(2) == 0) {
                    lllllllllllIIIlllllIlIlIIIIllIll[lllllllllllIIIlllllIlIlIIIIllIIl + lllllllllllIIIlllllIlIlIIIIllIlI * lllllllllllIIIlllllIlIlIIIlIIIlI] = 1;
                }
            }
        }
        return lllllllllllIIIlllllIlIlIIIIllIll;
    }
}
