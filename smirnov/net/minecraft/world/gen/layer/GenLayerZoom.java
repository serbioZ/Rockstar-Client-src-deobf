// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerZoom extends GenLayer
{
    public GenLayerZoom(final long lllllllllllIlIllIIIllllIlIIIlIIl, final GenLayer lllllllllllIlIllIIIllllIlIIIlIII) {
        super(lllllllllllIlIllIIIllllIlIIIlIIl);
        super.parent = lllllllllllIlIllIIIllllIlIIIlIII;
    }
    
    @Override
    public int[] getInts(final int lllllllllllIlIllIIIllllIIlIllIIl, final int lllllllllllIlIllIIIllllIIllIlllI, final int lllllllllllIlIllIIIllllIIllIllIl, final int lllllllllllIlIllIIIllllIIllIllII) {
        final int lllllllllllIlIllIIIllllIIllIlIll = lllllllllllIlIllIIIllllIIlIllIIl >> 1;
        final int lllllllllllIlIllIIIllllIIllIlIlI = lllllllllllIlIllIIIllllIIllIlllI >> 1;
        final int lllllllllllIlIllIIIllllIIllIlIIl = (lllllllllllIlIllIIIllllIIllIllIl >> 1) + 2;
        final int lllllllllllIlIllIIIllllIIllIlIII = (lllllllllllIlIllIIIllllIIllIllII >> 1) + 2;
        final int[] lllllllllllIlIllIIIllllIIllIIlll = this.parent.getInts(lllllllllllIlIllIIIllllIIllIlIll, lllllllllllIlIllIIIllllIIllIlIlI, lllllllllllIlIllIIIllllIIllIlIIl, lllllllllllIlIllIIIllllIIllIlIII);
        final int lllllllllllIlIllIIIllllIIllIIllI = lllllllllllIlIllIIIllllIIllIlIIl - 1 << 1;
        final int lllllllllllIlIllIIIllllIIllIIlIl = lllllllllllIlIllIIIllllIIllIlIII - 1 << 1;
        final int[] lllllllllllIlIllIIIllllIIllIIlII = IntCache.getIntCache(lllllllllllIlIllIIIllllIIllIIllI * lllllllllllIlIllIIIllllIIllIIlIl);
        for (int lllllllllllIlIllIIIllllIIllIIIll = 0; lllllllllllIlIllIIIllllIIllIIIll < lllllllllllIlIllIIIllllIIllIlIII - 1; ++lllllllllllIlIllIIIllllIIllIIIll) {
            int lllllllllllIlIllIIIllllIIllIIIlI = (lllllllllllIlIllIIIllllIIllIIIll << 1) * lllllllllllIlIllIIIllllIIllIIllI;
            int lllllllllllIlIllIIIllllIIllIIIIl = 0;
            int lllllllllllIlIllIIIllllIIllIIIII = lllllllllllIlIllIIIllllIIllIIlll[lllllllllllIlIllIIIllllIIllIIIIl + 0 + (lllllllllllIlIllIIIllllIIllIIIll + 0) * lllllllllllIlIllIIIllllIIllIlIIl];
            int lllllllllllIlIllIIIllllIIlIlllll = lllllllllllIlIllIIIllllIIllIIlll[lllllllllllIlIllIIIllllIIllIIIIl + 0 + (lllllllllllIlIllIIIllllIIllIIIll + 1) * lllllllllllIlIllIIIllllIIllIlIIl];
            while (lllllllllllIlIllIIIllllIIllIIIIl < lllllllllllIlIllIIIllllIIllIlIIl - 1) {
                this.initChunkSeed(lllllllllllIlIllIIIllllIIllIIIIl + lllllllllllIlIllIIIllllIIllIlIll << 1, lllllllllllIlIllIIIllllIIllIIIll + lllllllllllIlIllIIIllllIIllIlIlI << 1);
                final int lllllllllllIlIllIIIllllIIlIllllI = lllllllllllIlIllIIIllllIIllIIlll[lllllllllllIlIllIIIllllIIllIIIIl + 1 + (lllllllllllIlIllIIIllllIIllIIIll + 0) * lllllllllllIlIllIIIllllIIllIlIIl];
                final int lllllllllllIlIllIIIllllIIlIlllIl = lllllllllllIlIllIIIllllIIllIIlll[lllllllllllIlIllIIIllllIIllIIIIl + 1 + (lllllllllllIlIllIIIllllIIllIIIll + 1) * lllllllllllIlIllIIIllllIIllIlIIl];
                lllllllllllIlIllIIIllllIIllIIlII[lllllllllllIlIllIIIllllIIllIIIlI] = lllllllllllIlIllIIIllllIIllIIIII;
                lllllllllllIlIllIIIllllIIllIIlII[lllllllllllIlIllIIIllllIIllIIIlI++ + lllllllllllIlIllIIIllllIIllIIllI] = this.selectRandom(lllllllllllIlIllIIIllllIIllIIIII, lllllllllllIlIllIIIllllIIlIlllll);
                lllllllllllIlIllIIIllllIIllIIlII[lllllllllllIlIllIIIllllIIllIIIlI] = this.selectRandom(lllllllllllIlIllIIIllllIIllIIIII, lllllllllllIlIllIIIllllIIlIllllI);
                lllllllllllIlIllIIIllllIIllIIlII[lllllllllllIlIllIIIllllIIllIIIlI++ + lllllllllllIlIllIIIllllIIllIIllI] = this.selectModeOrRandom(lllllllllllIlIllIIIllllIIllIIIII, lllllllllllIlIllIIIllllIIlIllllI, lllllllllllIlIllIIIllllIIlIlllll, lllllllllllIlIllIIIllllIIlIlllIl);
                lllllllllllIlIllIIIllllIIllIIIII = lllllllllllIlIllIIIllllIIlIllllI;
                lllllllllllIlIllIIIllllIIlIlllll = lllllllllllIlIllIIIllllIIlIlllIl;
                ++lllllllllllIlIllIIIllllIIllIIIIl;
            }
        }
        final int[] lllllllllllIlIllIIIllllIIlIlllII = IntCache.getIntCache(lllllllllllIlIllIIIllllIIllIllIl * lllllllllllIlIllIIIllllIIllIllII);
        for (int lllllllllllIlIllIIIllllIIlIllIll = 0; lllllllllllIlIllIIIllllIIlIllIll < lllllllllllIlIllIIIllllIIllIllII; ++lllllllllllIlIllIIIllllIIlIllIll) {
            System.arraycopy(lllllllllllIlIllIIIllllIIllIIlII, (lllllllllllIlIllIIIllllIIlIllIll + (lllllllllllIlIllIIIllllIIllIlllI & 0x1)) * lllllllllllIlIllIIIllllIIllIIllI + (lllllllllllIlIllIIIllllIIlIllIIl & 0x1), lllllllllllIlIllIIIllllIIlIlllII, lllllllllllIlIllIIIllllIIlIllIll * lllllllllllIlIllIIIllllIIllIllIl, lllllllllllIlIllIIIllllIIllIllIl);
        }
        return lllllllllllIlIllIIIllllIIlIlllII;
    }
    
    public static GenLayer magnify(final long lllllllllllIlIllIIIllllIIlIIIIIl, final GenLayer lllllllllllIlIllIIIllllIIlIIIIII, final int lllllllllllIlIllIIIllllIIIllllll) {
        GenLayer lllllllllllIlIllIIIllllIIIlllllI = lllllllllllIlIllIIIllllIIlIIIIII;
        for (int lllllllllllIlIllIIIllllIIIllllIl = 0; lllllllllllIlIllIIIllllIIIllllIl < lllllllllllIlIllIIIllllIIIllllll; ++lllllllllllIlIllIIIllllIIIllllIl) {
            lllllllllllIlIllIIIllllIIIlllllI = new GenLayerZoom(lllllllllllIlIllIIIllllIIlIIIIIl + lllllllllllIlIllIIIllllIIIllllIl, lllllllllllIlIllIIIllllIIIlllllI);
        }
        return lllllllllllIlIllIIIllllIIIlllllI;
    }
}
