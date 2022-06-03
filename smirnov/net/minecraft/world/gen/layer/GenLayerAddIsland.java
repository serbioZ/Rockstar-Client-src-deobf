// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerAddIsland extends GenLayer
{
    public GenLayerAddIsland(final long lIIIlIlllIllI, final GenLayer lIIIlIllllIII) {
        super(lIIIlIlllIllI);
        this.parent = lIIIlIllllIII;
    }
    
    @Override
    public int[] getInts(final int lIIIlIlIlllll, final int lIIIlIlIllllI, final int lIIIlIlIIlIIl, final int lIIIlIlIlllII) {
        final int lIIIlIlIllIll = lIIIlIlIlllll - 1;
        final int lIIIlIlIllIlI = lIIIlIlIllllI - 1;
        final int lIIIlIlIllIIl = lIIIlIlIIlIIl + 2;
        final int lIIIlIlIllIII = lIIIlIlIlllII + 2;
        final int[] lIIIlIlIlIlll = this.parent.getInts(lIIIlIlIllIll, lIIIlIlIllIlI, lIIIlIlIllIIl, lIIIlIlIllIII);
        final int[] lIIIlIlIlIllI = IntCache.getIntCache(lIIIlIlIIlIIl * lIIIlIlIlllII);
        for (int lIIIlIlIlIlIl = 0; lIIIlIlIlIlIl < lIIIlIlIlllII; ++lIIIlIlIlIlIl) {
            for (int lIIIlIlIlIlII = 0; lIIIlIlIlIlII < lIIIlIlIIlIIl; ++lIIIlIlIlIlII) {
                final int lIIIlIlIlIIll = lIIIlIlIlIlll[lIIIlIlIlIlII + 0 + (lIIIlIlIlIlIl + 0) * lIIIlIlIllIIl];
                final int lIIIlIlIlIIlI = lIIIlIlIlIlll[lIIIlIlIlIlII + 2 + (lIIIlIlIlIlIl + 0) * lIIIlIlIllIIl];
                final int lIIIlIlIlIIIl = lIIIlIlIlIlll[lIIIlIlIlIlII + 0 + (lIIIlIlIlIlIl + 2) * lIIIlIlIllIIl];
                final int lIIIlIlIlIIII = lIIIlIlIlIlll[lIIIlIlIlIlII + 2 + (lIIIlIlIlIlIl + 2) * lIIIlIlIllIIl];
                final int lIIIlIlIIllll = lIIIlIlIlIlll[lIIIlIlIlIlII + 1 + (lIIIlIlIlIlIl + 1) * lIIIlIlIllIIl];
                this.initChunkSeed(lIIIlIlIlIlII + lIIIlIlIlllll, lIIIlIlIlIlIl + lIIIlIlIllllI);
                if (lIIIlIlIIllll != 0 || (lIIIlIlIlIIll == 0 && lIIIlIlIlIIlI == 0 && lIIIlIlIlIIIl == 0 && lIIIlIlIlIIII == 0)) {
                    if (lIIIlIlIIllll > 0 && (lIIIlIlIlIIll == 0 || lIIIlIlIlIIlI == 0 || lIIIlIlIlIIIl == 0 || lIIIlIlIlIIII == 0)) {
                        if (this.nextInt(5) == 0) {
                            if (lIIIlIlIIllll == 4) {
                                lIIIlIlIlIllI[lIIIlIlIlIlII + lIIIlIlIlIlIl * lIIIlIlIIlIIl] = 4;
                            }
                            else {
                                lIIIlIlIlIllI[lIIIlIlIlIlII + lIIIlIlIlIlIl * lIIIlIlIIlIIl] = 0;
                            }
                        }
                        else {
                            lIIIlIlIlIllI[lIIIlIlIlIlII + lIIIlIlIlIlIl * lIIIlIlIIlIIl] = lIIIlIlIIllll;
                        }
                    }
                    else {
                        lIIIlIlIlIllI[lIIIlIlIlIlII + lIIIlIlIlIlIl * lIIIlIlIIlIIl] = lIIIlIlIIllll;
                    }
                }
                else {
                    int lIIIlIlIIlllI = 1;
                    int lIIIlIlIIllIl = 1;
                    if (lIIIlIlIlIIll != 0 && this.nextInt(lIIIlIlIIlllI++) == 0) {
                        lIIIlIlIIllIl = lIIIlIlIlIIll;
                    }
                    if (lIIIlIlIlIIlI != 0 && this.nextInt(lIIIlIlIIlllI++) == 0) {
                        lIIIlIlIIllIl = lIIIlIlIlIIlI;
                    }
                    if (lIIIlIlIlIIIl != 0 && this.nextInt(lIIIlIlIIlllI++) == 0) {
                        lIIIlIlIIllIl = lIIIlIlIlIIIl;
                    }
                    if (lIIIlIlIlIIII != 0 && this.nextInt(lIIIlIlIIlllI++) == 0) {
                        lIIIlIlIIllIl = lIIIlIlIlIIII;
                    }
                    if (this.nextInt(3) == 0) {
                        lIIIlIlIlIllI[lIIIlIlIlIlII + lIIIlIlIlIlIl * lIIIlIlIIlIIl] = lIIIlIlIIllIl;
                    }
                    else if (lIIIlIlIIllIl == 4) {
                        lIIIlIlIlIllI[lIIIlIlIlIlII + lIIIlIlIlIlIl * lIIIlIlIIlIIl] = 4;
                    }
                    else {
                        lIIIlIlIlIllI[lIIIlIlIlIlII + lIIIlIlIlIlIl * lIIIlIlIIlIIl] = 0;
                    }
                }
            }
        }
        return lIIIlIlIlIllI;
    }
}
