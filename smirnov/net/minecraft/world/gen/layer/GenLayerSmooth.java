// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerSmooth extends GenLayer
{
    @Override
    public int[] getInts(final int llllllllllllIllIlIlIllIIlIIllIll, final int llllllllllllIllIlIlIllIIlIIllIlI, final int llllllllllllIllIlIlIllIIlIIIIlll, final int llllllllllllIllIlIlIllIIlIIllIII) {
        final int llllllllllllIllIlIlIllIIlIIlIlll = llllllllllllIllIlIlIllIIlIIllIll - 1;
        final int llllllllllllIllIlIlIllIIlIIlIllI = llllllllllllIllIlIlIllIIlIIllIlI - 1;
        final int llllllllllllIllIlIlIllIIlIIlIlIl = llllllllllllIllIlIlIllIIlIIIIlll + 2;
        final int llllllllllllIllIlIlIllIIlIIlIlII = llllllllllllIllIlIlIllIIlIIllIII + 2;
        final int[] llllllllllllIllIlIlIllIIlIIlIIll = this.parent.getInts(llllllllllllIllIlIlIllIIlIIlIlll, llllllllllllIllIlIlIllIIlIIlIllI, llllllllllllIllIlIlIllIIlIIlIlIl, llllllllllllIllIlIlIllIIlIIlIlII);
        final int[] llllllllllllIllIlIlIllIIlIIlIIlI = IntCache.getIntCache(llllllllllllIllIlIlIllIIlIIIIlll * llllllllllllIllIlIlIllIIlIIllIII);
        for (int llllllllllllIllIlIlIllIIlIIlIIIl = 0; llllllllllllIllIlIlIllIIlIIlIIIl < llllllllllllIllIlIlIllIIlIIllIII; ++llllllllllllIllIlIlIllIIlIIlIIIl) {
            for (int llllllllllllIllIlIlIllIIlIIlIIII = 0; llllllllllllIllIlIlIllIIlIIlIIII < llllllllllllIllIlIlIllIIlIIIIlll; ++llllllllllllIllIlIlIllIIlIIlIIII) {
                final int llllllllllllIllIlIlIllIIlIIIllll = llllllllllllIllIlIlIllIIlIIlIIll[llllllllllllIllIlIlIllIIlIIlIIII + 0 + (llllllllllllIllIlIlIllIIlIIlIIIl + 1) * llllllllllllIllIlIlIllIIlIIlIlIl];
                final int llllllllllllIllIlIlIllIIlIIIlllI = llllllllllllIllIlIlIllIIlIIlIIll[llllllllllllIllIlIlIllIIlIIlIIII + 2 + (llllllllllllIllIlIlIllIIlIIlIIIl + 1) * llllllllllllIllIlIlIllIIlIIlIlIl];
                final int llllllllllllIllIlIlIllIIlIIIllIl = llllllllllllIllIlIlIllIIlIIlIIll[llllllllllllIllIlIlIllIIlIIlIIII + 1 + (llllllllllllIllIlIlIllIIlIIlIIIl + 0) * llllllllllllIllIlIlIllIIlIIlIlIl];
                final int llllllllllllIllIlIlIllIIlIIIllII = llllllllllllIllIlIlIllIIlIIlIIll[llllllllllllIllIlIlIllIIlIIlIIII + 1 + (llllllllllllIllIlIlIllIIlIIlIIIl + 2) * llllllllllllIllIlIlIllIIlIIlIlIl];
                int llllllllllllIllIlIlIllIIlIIIlIll = llllllllllllIllIlIlIllIIlIIlIIll[llllllllllllIllIlIlIllIIlIIlIIII + 1 + (llllllllllllIllIlIlIllIIlIIlIIIl + 1) * llllllllllllIllIlIlIllIIlIIlIlIl];
                if (llllllllllllIllIlIlIllIIlIIIllll == llllllllllllIllIlIlIllIIlIIIlllI && llllllllllllIllIlIlIllIIlIIIllIl == llllllllllllIllIlIlIllIIlIIIllII) {
                    this.initChunkSeed(llllllllllllIllIlIlIllIIlIIlIIII + llllllllllllIllIlIlIllIIlIIllIll, llllllllllllIllIlIlIllIIlIIlIIIl + llllllllllllIllIlIlIllIIlIIllIlI);
                    if (this.nextInt(2) == 0) {
                        llllllllllllIllIlIlIllIIlIIIlIll = llllllllllllIllIlIlIllIIlIIIllll;
                    }
                    else {
                        llllllllllllIllIlIlIllIIlIIIlIll = llllllllllllIllIlIlIllIIlIIIllIl;
                    }
                }
                else {
                    if (llllllllllllIllIlIlIllIIlIIIllll == llllllllllllIllIlIlIllIIlIIIlllI) {
                        llllllllllllIllIlIlIllIIlIIIlIll = llllllllllllIllIlIlIllIIlIIIllll;
                    }
                    if (llllllllllllIllIlIlIllIIlIIIllIl == llllllllllllIllIlIlIllIIlIIIllII) {
                        llllllllllllIllIlIlIllIIlIIIlIll = llllllllllllIllIlIlIllIIlIIIllIl;
                    }
                }
                llllllllllllIllIlIlIllIIlIIlIIlI[llllllllllllIllIlIlIllIIlIIlIIII + llllllllllllIllIlIlIllIIlIIlIIIl * llllllllllllIllIlIlIllIIlIIIIlll] = llllllllllllIllIlIlIllIIlIIIlIll;
            }
        }
        return llllllllllllIllIlIlIllIIlIIlIIlI;
    }
    
    public GenLayerSmooth(final long llllllllllllIllIlIlIllIIlIllIIll, final GenLayer llllllllllllIllIlIlIllIIlIlIllll) {
        super(llllllllllllIllIlIlIllIIlIllIIll);
        super.parent = llllllllllllIllIlIlIllIIlIlIllll;
    }
}
