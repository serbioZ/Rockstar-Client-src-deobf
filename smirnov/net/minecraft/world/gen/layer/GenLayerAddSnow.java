// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerAddSnow extends GenLayer
{
    public GenLayerAddSnow(final long llllllllllIlllllIlIIIIIlIlIIIlIl, final GenLayer llllllllllIlllllIlIIIIIlIlIIIlII) {
        super(llllllllllIlllllIlIIIIIlIlIIIlIl);
        this.parent = llllllllllIlllllIlIIIIIlIlIIIlII;
    }
    
    @Override
    public int[] getInts(final int llllllllllIlllllIlIIIIIlIIllIIll, final int llllllllllIlllllIlIIIIIlIIllIIlI, final int llllllllllIlllllIlIIIIIlIIllIIIl, final int llllllllllIlllllIlIIIIIlIIlIIIIl) {
        final int llllllllllIlllllIlIIIIIlIIlIllll = llllllllllIlllllIlIIIIIlIIllIIll - 1;
        final int llllllllllIlllllIlIIIIIlIIlIlllI = llllllllllIlllllIlIIIIIlIIllIIlI - 1;
        final int llllllllllIlllllIlIIIIIlIIlIllIl = llllllllllIlllllIlIIIIIlIIllIIIl + 2;
        final int llllllllllIlllllIlIIIIIlIIlIllII = llllllllllIlllllIlIIIIIlIIlIIIIl + 2;
        final int[] llllllllllIlllllIlIIIIIlIIlIlIll = this.parent.getInts(llllllllllIlllllIlIIIIIlIIlIllll, llllllllllIlllllIlIIIIIlIIlIlllI, llllllllllIlllllIlIIIIIlIIlIllIl, llllllllllIlllllIlIIIIIlIIlIllII);
        final int[] llllllllllIlllllIlIIIIIlIIlIlIlI = IntCache.getIntCache(llllllllllIlllllIlIIIIIlIIllIIIl * llllllllllIlllllIlIIIIIlIIlIIIIl);
        for (int llllllllllIlllllIlIIIIIlIIlIlIIl = 0; llllllllllIlllllIlIIIIIlIIlIlIIl < llllllllllIlllllIlIIIIIlIIlIIIIl; ++llllllllllIlllllIlIIIIIlIIlIlIIl) {
            for (int llllllllllIlllllIlIIIIIlIIlIlIII = 0; llllllllllIlllllIlIIIIIlIIlIlIII < llllllllllIlllllIlIIIIIlIIllIIIl; ++llllllllllIlllllIlIIIIIlIIlIlIII) {
                final int llllllllllIlllllIlIIIIIlIIlIIlll = llllllllllIlllllIlIIIIIlIIlIlIll[llllllllllIlllllIlIIIIIlIIlIlIII + 1 + (llllllllllIlllllIlIIIIIlIIlIlIIl + 1) * llllllllllIlllllIlIIIIIlIIlIllIl];
                this.initChunkSeed(llllllllllIlllllIlIIIIIlIIlIlIII + llllllllllIlllllIlIIIIIlIIllIIll, llllllllllIlllllIlIIIIIlIIlIlIIl + llllllllllIlllllIlIIIIIlIIllIIlI);
                if (llllllllllIlllllIlIIIIIlIIlIIlll == 0) {
                    llllllllllIlllllIlIIIIIlIIlIlIlI[llllllllllIlllllIlIIIIIlIIlIlIII + llllllllllIlllllIlIIIIIlIIlIlIIl * llllllllllIlllllIlIIIIIlIIllIIIl] = 0;
                }
                else {
                    int llllllllllIlllllIlIIIIIlIIlIIllI = this.nextInt(6);
                    if (llllllllllIlllllIlIIIIIlIIlIIllI == 0) {
                        llllllllllIlllllIlIIIIIlIIlIIllI = 4;
                    }
                    else if (llllllllllIlllllIlIIIIIlIIlIIllI <= 1) {
                        llllllllllIlllllIlIIIIIlIIlIIllI = 3;
                    }
                    else {
                        llllllllllIlllllIlIIIIIlIIlIIllI = 1;
                    }
                    llllllllllIlllllIlIIIIIlIIlIlIlI[llllllllllIlllllIlIIIIIlIIlIlIII + llllllllllIlllllIlIIIIIlIIlIlIIl * llllllllllIlllllIlIIIIIlIIllIIIl] = llllllllllIlllllIlIIIIIlIIlIIllI;
                }
            }
        }
        return llllllllllIlllllIlIIIIIlIIlIlIlI;
    }
}
