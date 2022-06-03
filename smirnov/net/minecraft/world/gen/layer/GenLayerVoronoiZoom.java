// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerVoronoiZoom extends GenLayer
{
    @Override
    public int[] getInts(int llllllllllllIIIlIlIlIIlIIIIIlIll, int llllllllllllIIIlIlIlIIlIIIIIlIlI, final int llllllllllllIIIlIlIlIIlIIIIIlIIl, final int llllllllllllIIIlIlIlIIlIIIIIlIII) {
        llllllllllllIIIlIlIlIIlIIIIIlIll -= 2;
        llllllllllllIIIlIlIlIIlIIIIIlIlI -= 2;
        final int llllllllllllIIIlIlIlIIlIIIIIIlll = llllllllllllIIIlIlIlIIlIIIIIlIll >> 2;
        final int llllllllllllIIIlIlIlIIlIIIIIIllI = llllllllllllIIIlIlIlIIlIIIIIlIlI >> 2;
        final int llllllllllllIIIlIlIlIIlIIIIIIlIl = (llllllllllllIIIlIlIlIIlIIIIIlIIl >> 2) + 2;
        final int llllllllllllIIIlIlIlIIlIIIIIIlII = (llllllllllllIIIlIlIlIIlIIIIIlIII >> 2) + 2;
        final int[] llllllllllllIIIlIlIlIIlIIIIIIIll = this.parent.getInts(llllllllllllIIIlIlIlIIlIIIIIIlll, llllllllllllIIIlIlIlIIlIIIIIIllI, llllllllllllIIIlIlIlIIlIIIIIIlIl, llllllllllllIIIlIlIlIIlIIIIIIlII);
        final int llllllllllllIIIlIlIlIIlIIIIIIIlI = llllllllllllIIIlIlIlIIlIIIIIIlIl - 1 << 2;
        final int llllllllllllIIIlIlIlIIlIIIIIIIIl = llllllllllllIIIlIlIlIIlIIIIIIlII - 1 << 2;
        final int[] llllllllllllIIIlIlIlIIlIIIIIIIII = IntCache.getIntCache(llllllllllllIIIlIlIlIIlIIIIIIIlI * llllllllllllIIIlIlIlIIlIIIIIIIIl);
        for (int llllllllllllIIIlIlIlIIIlllllllll = 0; llllllllllllIIIlIlIlIIIlllllllll < llllllllllllIIIlIlIlIIlIIIIIIlII - 1; ++llllllllllllIIIlIlIlIIIlllllllll) {
            int llllllllllllIIIlIlIlIIIllllllllI = 0;
            int llllllllllllIIIlIlIlIIIlllllllIl = llllllllllllIIIlIlIlIIlIIIIIIIll[llllllllllllIIIlIlIlIIIllllllllI + 0 + (llllllllllllIIIlIlIlIIIlllllllll + 0) * llllllllllllIIIlIlIlIIlIIIIIIlIl];
            int llllllllllllIIIlIlIlIIIlllllllII = llllllllllllIIIlIlIlIIlIIIIIIIll[llllllllllllIIIlIlIlIIIllllllllI + 0 + (llllllllllllIIIlIlIlIIIlllllllll + 1) * llllllllllllIIIlIlIlIIlIIIIIIlIl];
            while (llllllllllllIIIlIlIlIIIllllllllI < llllllllllllIIIlIlIlIIlIIIIIIlIl - 1) {
                final double llllllllllllIIIlIlIlIIIllllllIll = 3.6;
                this.initChunkSeed(llllllllllllIIIlIlIlIIIllllllllI + llllllllllllIIIlIlIlIIlIIIIIIlll << 2, llllllllllllIIIlIlIlIIIlllllllll + llllllllllllIIIlIlIlIIlIIIIIIllI << 2);
                final double llllllllllllIIIlIlIlIIIllllllIlI = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                final double llllllllllllIIIlIlIlIIIllllllIIl = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                this.initChunkSeed(llllllllllllIIIlIlIlIIIllllllllI + llllllllllllIIIlIlIlIIlIIIIIIlll + 1 << 2, llllllllllllIIIlIlIlIIIlllllllll + llllllllllllIIIlIlIlIIlIIIIIIllI << 2);
                final double llllllllllllIIIlIlIlIIIllllllIII = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final double llllllllllllIIIlIlIlIIIlllllIlll = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                this.initChunkSeed(llllllllllllIIIlIlIlIIIllllllllI + llllllllllllIIIlIlIlIIlIIIIIIlll << 2, llllllllllllIIIlIlIlIIIlllllllll + llllllllllllIIIlIlIlIIlIIIIIIllI + 1 << 2);
                final double llllllllllllIIIlIlIlIIIlllllIllI = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                final double llllllllllllIIIlIlIlIIIlllllIlIl = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                this.initChunkSeed(llllllllllllIIIlIlIlIIIllllllllI + llllllllllllIIIlIlIlIIlIIIIIIlll + 1 << 2, llllllllllllIIIlIlIlIIIlllllllll + llllllllllllIIIlIlIlIIlIIIIIIllI + 1 << 2);
                final double llllllllllllIIIlIlIlIIIlllllIlII = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final double llllllllllllIIIlIlIlIIIlllllIIll = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final int llllllllllllIIIlIlIlIIIlllllIIlI = llllllllllllIIIlIlIlIIlIIIIIIIll[llllllllllllIIIlIlIlIIIllllllllI + 1 + (llllllllllllIIIlIlIlIIIlllllllll + 0) * llllllllllllIIIlIlIlIIlIIIIIIlIl] & 0xFF;
                final int llllllllllllIIIlIlIlIIIlllllIIIl = llllllllllllIIIlIlIlIIlIIIIIIIll[llllllllllllIIIlIlIlIIIllllllllI + 1 + (llllllllllllIIIlIlIlIIIlllllllll + 1) * llllllllllllIIIlIlIlIIlIIIIIIlIl] & 0xFF;
                for (int llllllllllllIIIlIlIlIIIlllllIIII = 0; llllllllllllIIIlIlIlIIIlllllIIII < 4; ++llllllllllllIIIlIlIlIIIlllllIIII) {
                    int llllllllllllIIIlIlIlIIIllllIllll = ((llllllllllllIIIlIlIlIIIlllllllll << 2) + llllllllllllIIIlIlIlIIIlllllIIII) * llllllllllllIIIlIlIlIIlIIIIIIIlI + (llllllllllllIIIlIlIlIIIllllllllI << 2);
                    for (int llllllllllllIIIlIlIlIIIllllIlllI = 0; llllllllllllIIIlIlIlIIIllllIlllI < 4; ++llllllllllllIIIlIlIlIIIllllIlllI) {
                        final double llllllllllllIIIlIlIlIIIllllIllIl = (llllllllllllIIIlIlIlIIIlllllIIII - llllllllllllIIIlIlIlIIIllllllIIl) * (llllllllllllIIIlIlIlIIIlllllIIII - llllllllllllIIIlIlIlIIIllllllIIl) + (llllllllllllIIIlIlIlIIIllllIlllI - llllllllllllIIIlIlIlIIIllllllIlI) * (llllllllllllIIIlIlIlIIIllllIlllI - llllllllllllIIIlIlIlIIIllllllIlI);
                        final double llllllllllllIIIlIlIlIIIllllIllII = (llllllllllllIIIlIlIlIIIlllllIIII - llllllllllllIIIlIlIlIIIlllllIlll) * (llllllllllllIIIlIlIlIIIlllllIIII - llllllllllllIIIlIlIlIIIlllllIlll) + (llllllllllllIIIlIlIlIIIllllIlllI - llllllllllllIIIlIlIlIIIllllllIII) * (llllllllllllIIIlIlIlIIIllllIlllI - llllllllllllIIIlIlIlIIIllllllIII);
                        final double llllllllllllIIIlIlIlIIIllllIlIll = (llllllllllllIIIlIlIlIIIlllllIIII - llllllllllllIIIlIlIlIIIlllllIlIl) * (llllllllllllIIIlIlIlIIIlllllIIII - llllllllllllIIIlIlIlIIIlllllIlIl) + (llllllllllllIIIlIlIlIIIllllIlllI - llllllllllllIIIlIlIlIIIlllllIllI) * (llllllllllllIIIlIlIlIIIllllIlllI - llllllllllllIIIlIlIlIIIlllllIllI);
                        final double llllllllllllIIIlIlIlIIIllllIlIlI = (llllllllllllIIIlIlIlIIIlllllIIII - llllllllllllIIIlIlIlIIIlllllIIll) * (llllllllllllIIIlIlIlIIIlllllIIII - llllllllllllIIIlIlIlIIIlllllIIll) + (llllllllllllIIIlIlIlIIIllllIlllI - llllllllllllIIIlIlIlIIIlllllIlII) * (llllllllllllIIIlIlIlIIIllllIlllI - llllllllllllIIIlIlIlIIIlllllIlII);
                        if (llllllllllllIIIlIlIlIIIllllIllIl < llllllllllllIIIlIlIlIIIllllIllII && llllllllllllIIIlIlIlIIIllllIllIl < llllllllllllIIIlIlIlIIIllllIlIll && llllllllllllIIIlIlIlIIIllllIllIl < llllllllllllIIIlIlIlIIIllllIlIlI) {
                            llllllllllllIIIlIlIlIIlIIIIIIIII[llllllllllllIIIlIlIlIIIllllIllll++] = llllllllllllIIIlIlIlIIIlllllllIl;
                        }
                        else if (llllllllllllIIIlIlIlIIIllllIllII < llllllllllllIIIlIlIlIIIllllIllIl && llllllllllllIIIlIlIlIIIllllIllII < llllllllllllIIIlIlIlIIIllllIlIll && llllllllllllIIIlIlIlIIIllllIllII < llllllllllllIIIlIlIlIIIllllIlIlI) {
                            llllllllllllIIIlIlIlIIlIIIIIIIII[llllllllllllIIIlIlIlIIIllllIllll++] = llllllllllllIIIlIlIlIIIlllllIIlI;
                        }
                        else if (llllllllllllIIIlIlIlIIIllllIlIll < llllllllllllIIIlIlIlIIIllllIllIl && llllllllllllIIIlIlIlIIIllllIlIll < llllllllllllIIIlIlIlIIIllllIllII && llllllllllllIIIlIlIlIIIllllIlIll < llllllllllllIIIlIlIlIIIllllIlIlI) {
                            llllllllllllIIIlIlIlIIlIIIIIIIII[llllllllllllIIIlIlIlIIIllllIllll++] = llllllllllllIIIlIlIlIIIlllllllII;
                        }
                        else {
                            llllllllllllIIIlIlIlIIlIIIIIIIII[llllllllllllIIIlIlIlIIIllllIllll++] = llllllllllllIIIlIlIlIIIlllllIIIl;
                        }
                    }
                }
                llllllllllllIIIlIlIlIIIlllllllIl = llllllllllllIIIlIlIlIIIlllllIIlI;
                llllllllllllIIIlIlIlIIIlllllllII = llllllllllllIIIlIlIlIIIlllllIIIl;
                ++llllllllllllIIIlIlIlIIIllllllllI;
            }
        }
        final int[] llllllllllllIIIlIlIlIIIllllIlIIl = IntCache.getIntCache(llllllllllllIIIlIlIlIIlIIIIIlIIl * llllllllllllIIIlIlIlIIlIIIIIlIII);
        for (int llllllllllllIIIlIlIlIIIllllIlIII = 0; llllllllllllIIIlIlIlIIIllllIlIII < llllllllllllIIIlIlIlIIlIIIIIlIII; ++llllllllllllIIIlIlIlIIIllllIlIII) {
            System.arraycopy(llllllllllllIIIlIlIlIIlIIIIIIIII, (llllllllllllIIIlIlIlIIIllllIlIII + (llllllllllllIIIlIlIlIIlIIIIIlIlI & 0x3)) * llllllllllllIIIlIlIlIIlIIIIIIIlI + (llllllllllllIIIlIlIlIIlIIIIIlIll & 0x3), llllllllllllIIIlIlIlIIIllllIlIIl, llllllllllllIIIlIlIlIIIllllIlIII * llllllllllllIIIlIlIlIIlIIIIIlIIl, llllllllllllIIIlIlIlIIlIIIIIlIIl);
        }
        return llllllllllllIIIlIlIlIIIllllIlIIl;
    }
    
    public GenLayerVoronoiZoom(final long llllllllllllIIIlIlIlIIlIIIllIlII, final GenLayer llllllllllllIIIlIlIlIIlIIIllIIII) {
        super(llllllllllllIIIlIlIlIIlIIIllIlII);
        super.parent = llllllllllllIIIlIlIlIIlIIIllIIII;
    }
}
