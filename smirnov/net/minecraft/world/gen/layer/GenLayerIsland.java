// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerIsland extends GenLayer
{
    public GenLayerIsland(final long lllllllllllllIlIIlIlllIlIIllllll) {
        super(lllllllllllllIlIIlIlllIlIIllllll);
    }
    
    @Override
    public int[] getInts(final int lllllllllllllIlIIlIlllIlIIlIllIl, final int lllllllllllllIlIIlIlllIlIIllIlII, final int lllllllllllllIlIIlIlllIlIIllIIll, final int lllllllllllllIlIIlIlllIlIIllIIlI) {
        final int[] lllllllllllllIlIIlIlllIlIIllIIIl = IntCache.getIntCache(lllllllllllllIlIIlIlllIlIIllIIll * lllllllllllllIlIIlIlllIlIIllIIlI);
        for (int lllllllllllllIlIIlIlllIlIIllIIII = 0; lllllllllllllIlIIlIlllIlIIllIIII < lllllllllllllIlIIlIlllIlIIllIIlI; ++lllllllllllllIlIIlIlllIlIIllIIII) {
            for (int lllllllllllllIlIIlIlllIlIIlIllll = 0; lllllllllllllIlIIlIlllIlIIlIllll < lllllllllllllIlIIlIlllIlIIllIIll; ++lllllllllllllIlIIlIlllIlIIlIllll) {
                this.initChunkSeed(lllllllllllllIlIIlIlllIlIIlIllIl + lllllllllllllIlIIlIlllIlIIlIllll, lllllllllllllIlIIlIlllIlIIllIlII + lllllllllllllIlIIlIlllIlIIllIIII);
                lllllllllllllIlIIlIlllIlIIllIIIl[lllllllllllllIlIIlIlllIlIIlIllll + lllllllllllllIlIIlIlllIlIIllIIII * lllllllllllllIlIIlIlllIlIIllIIll] = ((this.nextInt(10) == 0) ? 1 : 0);
            }
        }
        if (lllllllllllllIlIIlIlllIlIIlIllIl > -lllllllllllllIlIIlIlllIlIIllIIll && lllllllllllllIlIIlIlllIlIIlIllIl <= 0 && lllllllllllllIlIIlIlllIlIIllIlII > -lllllllllllllIlIIlIlllIlIIllIIlI && lllllllllllllIlIIlIlllIlIIllIlII <= 0) {
            lllllllllllllIlIIlIlllIlIIllIIIl[-lllllllllllllIlIIlIlllIlIIlIllIl + -lllllllllllllIlIIlIlllIlIIllIlII * lllllllllllllIlIIlIlllIlIIllIIll] = 1;
        }
        return lllllllllllllIlIIlIlllIlIIllIIIl;
    }
}
