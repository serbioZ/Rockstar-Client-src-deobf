// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerRiverInit extends GenLayer
{
    @Override
    public int[] getInts(final int llllllllllllIllllllIlllIIIIIllll, final int llllllllllllIllllllIlllIIIIIIlIl, final int llllllllllllIllllllIlllIIIIIllIl, final int llllllllllllIllllllIlllIIIIIllII) {
        final int[] llllllllllllIllllllIlllIIIIIlIll = this.parent.getInts(llllllllllllIllllllIlllIIIIIllll, llllllllllllIllllllIlllIIIIIIlIl, llllllllllllIllllllIlllIIIIIllIl, llllllllllllIllllllIlllIIIIIllII);
        final int[] llllllllllllIllllllIlllIIIIIlIlI = IntCache.getIntCache(llllllllllllIllllllIlllIIIIIllIl * llllllllllllIllllllIlllIIIIIllII);
        for (int llllllllllllIllllllIlllIIIIIlIIl = 0; llllllllllllIllllllIlllIIIIIlIIl < llllllllllllIllllllIlllIIIIIllII; ++llllllllllllIllllllIlllIIIIIlIIl) {
            for (int llllllllllllIllllllIlllIIIIIlIII = 0; llllllllllllIllllllIlllIIIIIlIII < llllllllllllIllllllIlllIIIIIllIl; ++llllllllllllIllllllIlllIIIIIlIII) {
                this.initChunkSeed(llllllllllllIllllllIlllIIIIIlIII + llllllllllllIllllllIlllIIIIIllll, llllllllllllIllllllIlllIIIIIlIIl + llllllllllllIllllllIlllIIIIIIlIl);
                llllllllllllIllllllIlllIIIIIlIlI[llllllllllllIllllllIlllIIIIIlIII + llllllllllllIllllllIlllIIIIIlIIl * llllllllllllIllllllIlllIIIIIllIl] = ((llllllllllllIllllllIlllIIIIIlIll[llllllllllllIllllllIlllIIIIIlIII + llllllllllllIllllllIlllIIIIIlIIl * llllllllllllIllllllIlllIIIIIllIl] > 0) ? (this.nextInt(299999) + 2) : 0);
            }
        }
        return llllllllllllIllllllIlllIIIIIlIlI;
    }
    
    public GenLayerRiverInit(final long llllllllllllIllllllIlllIIIIllllI, final GenLayer llllllllllllIllllllIlllIIIIlllIl) {
        super(llllllllllllIllllllIlllIIIIllllI);
        this.parent = llllllllllllIllllllIlllIIIIlllIl;
    }
}
