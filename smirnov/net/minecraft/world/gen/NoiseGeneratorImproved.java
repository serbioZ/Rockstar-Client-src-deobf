// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import java.util.Random;

public class NoiseGeneratorImproved extends NoiseGenerator
{
    private static final /* synthetic */ double[] GRAD_2Z;
    private static final /* synthetic */ double[] GRAD_X;
    private final /* synthetic */ int[] permutations;
    private static final /* synthetic */ double[] GRAD_Y;
    public /* synthetic */ double yCoord;
    public /* synthetic */ double zCoord;
    private static final /* synthetic */ double[] GRAD_2X;
    public /* synthetic */ double xCoord;
    private static final /* synthetic */ double[] GRAD_Z;
    
    public final double grad(final int lllllllllllIIIIIIIlllIlIlIlllIlI, final double lllllllllllIIIIIIIlllIlIlIllIlII, final double lllllllllllIIIIIIIlllIlIlIllIIll, final double lllllllllllIIIIIIIlllIlIlIllIlll) {
        final int lllllllllllIIIIIIIlllIlIlIllIllI = lllllllllllIIIIIIIlllIlIlIlllIlI & 0xF;
        return NoiseGeneratorImproved.GRAD_X[lllllllllllIIIIIIIlllIlIlIllIllI] * lllllllllllIIIIIIIlllIlIlIllIlII + NoiseGeneratorImproved.GRAD_Y[lllllllllllIIIIIIIlllIlIlIllIllI] * lllllllllllIIIIIIIlllIlIlIllIIll + NoiseGeneratorImproved.GRAD_Z[lllllllllllIIIIIIIlllIlIlIllIllI] * lllllllllllIIIIIIIlllIlIlIllIlll;
    }
    
    public final double lerp(final double lllllllllllIIIIIIIlllIlIllIlIIII, final double lllllllllllIIIIIIIlllIlIllIlIIlI, final double lllllllllllIIIIIIIlllIlIllIlIIIl) {
        return lllllllllllIIIIIIIlllIlIllIlIIlI + lllllllllllIIIIIIIlllIlIllIlIIII * (lllllllllllIIIIIIIlllIlIllIlIIIl - lllllllllllIIIIIIIlllIlIllIlIIlI);
    }
    
    public void populateNoiseArray(final double[] lllllllllllIIIIIIIlllIlIIIlllllI, final double lllllllllllIIIIIIIlllIlIIIllllIl, final double lllllllllllIIIIIIIlllIlIIlllllIl, final double lllllllllllIIIIIIIlllIlIIIlllIll, final int lllllllllllIIIIIIIlllIlIIIlllIlI, final int lllllllllllIIIIIIIlllIlIIIlllIIl, final int lllllllllllIIIIIIIlllIlIIIlllIII, final double lllllllllllIIIIIIIlllIlIIIllIlll, final double lllllllllllIIIIIIIlllIlIIIllIllI, final double lllllllllllIIIIIIIlllIlIIIllIlIl, final double lllllllllllIIIIIIIlllIlIIIllIlII) {
        if (lllllllllllIIIIIIIlllIlIIIlllIIl == 1) {
            int lllllllllllIIIIIIIlllIlIIlllIlII = 0;
            int lllllllllllIIIIIIIlllIlIIlllIIll = 0;
            int lllllllllllIIIIIIIlllIlIIlllIIlI = 0;
            int lllllllllllIIIIIIIlllIlIIlllIIIl = 0;
            double lllllllllllIIIIIIIlllIlIIlllIIII = 0.0;
            double lllllllllllIIIIIIIlllIlIIllIllll = 0.0;
            int lllllllllllIIIIIIIlllIlIIllIlllI = 0;
            final double lllllllllllIIIIIIIlllIlIIllIllIl = 1.0 / lllllllllllIIIIIIIlllIlIIIllIlII;
            for (int lllllllllllIIIIIIIlllIlIIllIllII = 0; lllllllllllIIIIIIIlllIlIIllIllII < lllllllllllIIIIIIIlllIlIIIlllIlI; ++lllllllllllIIIIIIIlllIlIIllIllII) {
                double lllllllllllIIIIIIIlllIlIIllIlIll = lllllllllllIIIIIIIlllIlIIIllllIl + lllllllllllIIIIIIIlllIlIIllIllII * lllllllllllIIIIIIIlllIlIIIllIlll + this.xCoord;
                int lllllllllllIIIIIIIlllIlIIllIlIlI = (int)lllllllllllIIIIIIIlllIlIIllIlIll;
                if (lllllllllllIIIIIIIlllIlIIllIlIll < lllllllllllIIIIIIIlllIlIIllIlIlI) {
                    --lllllllllllIIIIIIIlllIlIIllIlIlI;
                }
                final int lllllllllllIIIIIIIlllIlIIllIlIIl = lllllllllllIIIIIIIlllIlIIllIlIlI & 0xFF;
                lllllllllllIIIIIIIlllIlIIllIlIll -= lllllllllllIIIIIIIlllIlIIllIlIlI;
                final double lllllllllllIIIIIIIlllIlIIllIlIII = lllllllllllIIIIIIIlllIlIIllIlIll * lllllllllllIIIIIIIlllIlIIllIlIll * lllllllllllIIIIIIIlllIlIIllIlIll * (lllllllllllIIIIIIIlllIlIIllIlIll * (lllllllllllIIIIIIIlllIlIIllIlIll * 6.0 - 15.0) + 10.0);
                for (int lllllllllllIIIIIIIlllIlIIllIIlll = 0; lllllllllllIIIIIIIlllIlIIllIIlll < lllllllllllIIIIIIIlllIlIIIlllIII; ++lllllllllllIIIIIIIlllIlIIllIIlll) {
                    double lllllllllllIIIIIIIlllIlIIllIIllI = lllllllllllIIIIIIIlllIlIIIlllIll + lllllllllllIIIIIIIlllIlIIllIIlll * lllllllllllIIIIIIIlllIlIIIllIlIl + this.zCoord;
                    int lllllllllllIIIIIIIlllIlIIllIIlIl = (int)lllllllllllIIIIIIIlllIlIIllIIllI;
                    if (lllllllllllIIIIIIIlllIlIIllIIllI < lllllllllllIIIIIIIlllIlIIllIIlIl) {
                        --lllllllllllIIIIIIIlllIlIIllIIlIl;
                    }
                    final int lllllllllllIIIIIIIlllIlIIllIIlII = lllllllllllIIIIIIIlllIlIIllIIlIl & 0xFF;
                    lllllllllllIIIIIIIlllIlIIllIIllI -= lllllllllllIIIIIIIlllIlIIllIIlIl;
                    final double lllllllllllIIIIIIIlllIlIIllIIIll = lllllllllllIIIIIIIlllIlIIllIIllI * lllllllllllIIIIIIIlllIlIIllIIllI * lllllllllllIIIIIIIlllIlIIllIIllI * (lllllllllllIIIIIIIlllIlIIllIIllI * (lllllllllllIIIIIIIlllIlIIllIIllI * 6.0 - 15.0) + 10.0);
                    lllllllllllIIIIIIIlllIlIIlllIlII = this.permutations[lllllllllllIIIIIIIlllIlIIllIlIIl] + 0;
                    lllllllllllIIIIIIIlllIlIIlllIIll = this.permutations[lllllllllllIIIIIIIlllIlIIlllIlII] + lllllllllllIIIIIIIlllIlIIllIIlII;
                    lllllllllllIIIIIIIlllIlIIlllIIlI = this.permutations[lllllllllllIIIIIIIlllIlIIllIlIIl + 1] + 0;
                    lllllllllllIIIIIIIlllIlIIlllIIIl = this.permutations[lllllllllllIIIIIIIlllIlIIlllIIlI] + lllllllllllIIIIIIIlllIlIIllIIlII;
                    lllllllllllIIIIIIIlllIlIIlllIIII = this.lerp(lllllllllllIIIIIIIlllIlIIllIlIII, this.grad2(this.permutations[lllllllllllIIIIIIIlllIlIIlllIIll], lllllllllllIIIIIIIlllIlIIllIlIll, lllllllllllIIIIIIIlllIlIIllIIllI), this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlllIIIl], lllllllllllIIIIIIIlllIlIIllIlIll - 1.0, 0.0, lllllllllllIIIIIIIlllIlIIllIIllI));
                    lllllllllllIIIIIIIlllIlIIllIllll = this.lerp(lllllllllllIIIIIIIlllIlIIllIlIII, this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlllIIll + 1], lllllllllllIIIIIIIlllIlIIllIlIll, 0.0, lllllllllllIIIIIIIlllIlIIllIIllI - 1.0), this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlllIIIl + 1], lllllllllllIIIIIIIlllIlIIllIlIll - 1.0, 0.0, lllllllllllIIIIIIIlllIlIIllIIllI - 1.0));
                    final double lllllllllllIIIIIIIlllIlIIllIIIlI = this.lerp(lllllllllllIIIIIIIlllIlIIllIIIll, lllllllllllIIIIIIIlllIlIIlllIIII, lllllllllllIIIIIIIlllIlIIllIllll);
                    final int n;
                    final int lllllllllllIIIIIIIlllIlIIllIIIIl = n = lllllllllllIIIIIIIlllIlIIllIlllI++;
                    lllllllllllIIIIIIIlllIlIIIlllllI[n] += lllllllllllIIIIIIIlllIlIIllIIIlI * lllllllllllIIIIIIIlllIlIIllIllIl;
                }
            }
        }
        else {
            int lllllllllllIIIIIIIlllIlIIllIIIII = 0;
            final double lllllllllllIIIIIIIlllIlIIlIlllll = 1.0 / lllllllllllIIIIIIIlllIlIIIllIlII;
            int lllllllllllIIIIIIIlllIlIIlIllllI = -1;
            int lllllllllllIIIIIIIlllIlIIlIlllIl = 0;
            int lllllllllllIIIIIIIlllIlIIlIlllII = 0;
            int lllllllllllIIIIIIIlllIlIIlIllIll = 0;
            int lllllllllllIIIIIIIlllIlIIlIllIlI = 0;
            int lllllllllllIIIIIIIlllIlIIlIllIIl = 0;
            int lllllllllllIIIIIIIlllIlIIlIllIII = 0;
            double lllllllllllIIIIIIIlllIlIIlIlIlll = 0.0;
            double lllllllllllIIIIIIIlllIlIIlIlIllI = 0.0;
            double lllllllllllIIIIIIIlllIlIIlIlIlIl = 0.0;
            double lllllllllllIIIIIIIlllIlIIlIlIlII = 0.0;
            for (int lllllllllllIIIIIIIlllIlIIlIlIIll = 0; lllllllllllIIIIIIIlllIlIIlIlIIll < lllllllllllIIIIIIIlllIlIIIlllIlI; ++lllllllllllIIIIIIIlllIlIIlIlIIll) {
                double lllllllllllIIIIIIIlllIlIIlIlIIlI = lllllllllllIIIIIIIlllIlIIIllllIl + lllllllllllIIIIIIIlllIlIIlIlIIll * lllllllllllIIIIIIIlllIlIIIllIlll + this.xCoord;
                int lllllllllllIIIIIIIlllIlIIlIlIIIl = (int)lllllllllllIIIIIIIlllIlIIlIlIIlI;
                if (lllllllllllIIIIIIIlllIlIIlIlIIlI < lllllllllllIIIIIIIlllIlIIlIlIIIl) {
                    --lllllllllllIIIIIIIlllIlIIlIlIIIl;
                }
                final int lllllllllllIIIIIIIlllIlIIlIlIIII = lllllllllllIIIIIIIlllIlIIlIlIIIl & 0xFF;
                lllllllllllIIIIIIIlllIlIIlIlIIlI -= lllllllllllIIIIIIIlllIlIIlIlIIIl;
                final double lllllllllllIIIIIIIlllIlIIlIIllll = lllllllllllIIIIIIIlllIlIIlIlIIlI * lllllllllllIIIIIIIlllIlIIlIlIIlI * lllllllllllIIIIIIIlllIlIIlIlIIlI * (lllllllllllIIIIIIIlllIlIIlIlIIlI * (lllllllllllIIIIIIIlllIlIIlIlIIlI * 6.0 - 15.0) + 10.0);
                for (int lllllllllllIIIIIIIlllIlIIlIIlllI = 0; lllllllllllIIIIIIIlllIlIIlIIlllI < lllllllllllIIIIIIIlllIlIIIlllIII; ++lllllllllllIIIIIIIlllIlIIlIIlllI) {
                    double lllllllllllIIIIIIIlllIlIIlIIllIl = lllllllllllIIIIIIIlllIlIIIlllIll + lllllllllllIIIIIIIlllIlIIlIIlllI * lllllllllllIIIIIIIlllIlIIIllIlIl + this.zCoord;
                    int lllllllllllIIIIIIIlllIlIIlIIllII = (int)lllllllllllIIIIIIIlllIlIIlIIllIl;
                    if (lllllllllllIIIIIIIlllIlIIlIIllIl < lllllllllllIIIIIIIlllIlIIlIIllII) {
                        --lllllllllllIIIIIIIlllIlIIlIIllII;
                    }
                    final int lllllllllllIIIIIIIlllIlIIlIIlIll = lllllllllllIIIIIIIlllIlIIlIIllII & 0xFF;
                    lllllllllllIIIIIIIlllIlIIlIIllIl -= lllllllllllIIIIIIIlllIlIIlIIllII;
                    final double lllllllllllIIIIIIIlllIlIIlIIlIlI = lllllllllllIIIIIIIlllIlIIlIIllIl * lllllllllllIIIIIIIlllIlIIlIIllIl * lllllllllllIIIIIIIlllIlIIlIIllIl * (lllllllllllIIIIIIIlllIlIIlIIllIl * (lllllllllllIIIIIIIlllIlIIlIIllIl * 6.0 - 15.0) + 10.0);
                    for (int lllllllllllIIIIIIIlllIlIIlIIlIIl = 0; lllllllllllIIIIIIIlllIlIIlIIlIIl < lllllllllllIIIIIIIlllIlIIIlllIIl; ++lllllllllllIIIIIIIlllIlIIlIIlIIl) {
                        double lllllllllllIIIIIIIlllIlIIlIIlIII = lllllllllllIIIIIIIlllIlIIlllllIl + lllllllllllIIIIIIIlllIlIIlIIlIIl * lllllllllllIIIIIIIlllIlIIIllIllI + this.yCoord;
                        int lllllllllllIIIIIIIlllIlIIlIIIlll = (int)lllllllllllIIIIIIIlllIlIIlIIlIII;
                        if (lllllllllllIIIIIIIlllIlIIlIIlIII < lllllllllllIIIIIIIlllIlIIlIIIlll) {
                            --lllllllllllIIIIIIIlllIlIIlIIIlll;
                        }
                        final int lllllllllllIIIIIIIlllIlIIlIIIllI = lllllllllllIIIIIIIlllIlIIlIIIlll & 0xFF;
                        lllllllllllIIIIIIIlllIlIIlIIlIII -= lllllllllllIIIIIIIlllIlIIlIIIlll;
                        final double lllllllllllIIIIIIIlllIlIIlIIIlIl = lllllllllllIIIIIIIlllIlIIlIIlIII * lllllllllllIIIIIIIlllIlIIlIIlIII * lllllllllllIIIIIIIlllIlIIlIIlIII * (lllllllllllIIIIIIIlllIlIIlIIlIII * (lllllllllllIIIIIIIlllIlIIlIIlIII * 6.0 - 15.0) + 10.0);
                        if (lllllllllllIIIIIIIlllIlIIlIIlIIl == 0 || lllllllllllIIIIIIIlllIlIIlIIIllI != lllllllllllIIIIIIIlllIlIIlIllllI) {
                            lllllllllllIIIIIIIlllIlIIlIllllI = lllllllllllIIIIIIIlllIlIIlIIIllI;
                            lllllllllllIIIIIIIlllIlIIlIlllIl = this.permutations[lllllllllllIIIIIIIlllIlIIlIlIIII] + lllllllllllIIIIIIIlllIlIIlIIIllI;
                            lllllllllllIIIIIIIlllIlIIlIlllII = this.permutations[lllllllllllIIIIIIIlllIlIIlIlllIl] + lllllllllllIIIIIIIlllIlIIlIIlIll;
                            lllllllllllIIIIIIIlllIlIIlIllIll = this.permutations[lllllllllllIIIIIIIlllIlIIlIlllIl + 1] + lllllllllllIIIIIIIlllIlIIlIIlIll;
                            lllllllllllIIIIIIIlllIlIIlIllIlI = this.permutations[lllllllllllIIIIIIIlllIlIIlIlIIII + 1] + lllllllllllIIIIIIIlllIlIIlIIIllI;
                            lllllllllllIIIIIIIlllIlIIlIllIIl = this.permutations[lllllllllllIIIIIIIlllIlIIlIllIlI] + lllllllllllIIIIIIIlllIlIIlIIlIll;
                            lllllllllllIIIIIIIlllIlIIlIllIII = this.permutations[lllllllllllIIIIIIIlllIlIIlIllIlI + 1] + lllllllllllIIIIIIIlllIlIIlIIlIll;
                            lllllllllllIIIIIIIlllIlIIlIlIlll = this.lerp(lllllllllllIIIIIIIlllIlIIlIIllll, this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlIlllII], lllllllllllIIIIIIIlllIlIIlIlIIlI, lllllllllllIIIIIIIlllIlIIlIIlIII, lllllllllllIIIIIIIlllIlIIlIIllIl), this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlIllIIl], lllllllllllIIIIIIIlllIlIIlIlIIlI - 1.0, lllllllllllIIIIIIIlllIlIIlIIlIII, lllllllllllIIIIIIIlllIlIIlIIllIl));
                            lllllllllllIIIIIIIlllIlIIlIlIllI = this.lerp(lllllllllllIIIIIIIlllIlIIlIIllll, this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlIllIll], lllllllllllIIIIIIIlllIlIIlIlIIlI, lllllllllllIIIIIIIlllIlIIlIIlIII - 1.0, lllllllllllIIIIIIIlllIlIIlIIllIl), this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlIllIII], lllllllllllIIIIIIIlllIlIIlIlIIlI - 1.0, lllllllllllIIIIIIIlllIlIIlIIlIII - 1.0, lllllllllllIIIIIIIlllIlIIlIIllIl));
                            lllllllllllIIIIIIIlllIlIIlIlIlIl = this.lerp(lllllllllllIIIIIIIlllIlIIlIIllll, this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlIlllII + 1], lllllllllllIIIIIIIlllIlIIlIlIIlI, lllllllllllIIIIIIIlllIlIIlIIlIII, lllllllllllIIIIIIIlllIlIIlIIllIl - 1.0), this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlIllIIl + 1], lllllllllllIIIIIIIlllIlIIlIlIIlI - 1.0, lllllllllllIIIIIIIlllIlIIlIIlIII, lllllllllllIIIIIIIlllIlIIlIIllIl - 1.0));
                            lllllllllllIIIIIIIlllIlIIlIlIlII = this.lerp(lllllllllllIIIIIIIlllIlIIlIIllll, this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlIllIll + 1], lllllllllllIIIIIIIlllIlIIlIlIIlI, lllllllllllIIIIIIIlllIlIIlIIlIII - 1.0, lllllllllllIIIIIIIlllIlIIlIIllIl - 1.0), this.grad(this.permutations[lllllllllllIIIIIIIlllIlIIlIllIII + 1], lllllllllllIIIIIIIlllIlIIlIlIIlI - 1.0, lllllllllllIIIIIIIlllIlIIlIIlIII - 1.0, lllllllllllIIIIIIIlllIlIIlIIllIl - 1.0));
                        }
                        final double lllllllllllIIIIIIIlllIlIIlIIIlII = this.lerp(lllllllllllIIIIIIIlllIlIIlIIIlIl, lllllllllllIIIIIIIlllIlIIlIlIlll, lllllllllllIIIIIIIlllIlIIlIlIllI);
                        final double lllllllllllIIIIIIIlllIlIIlIIIIll = this.lerp(lllllllllllIIIIIIIlllIlIIlIIIlIl, lllllllllllIIIIIIIlllIlIIlIlIlIl, lllllllllllIIIIIIIlllIlIIlIlIlII);
                        final double lllllllllllIIIIIIIlllIlIIlIIIIlI = this.lerp(lllllllllllIIIIIIIlllIlIIlIIlIlI, lllllllllllIIIIIIIlllIlIIlIIIlII, lllllllllllIIIIIIIlllIlIIlIIIIll);
                        final int n2;
                        final int lllllllllllIIIIIIIlllIlIIlIIIIIl = n2 = lllllllllllIIIIIIIlllIlIIllIIIII++;
                        lllllllllllIIIIIIIlllIlIIIlllllI[n2] += lllllllllllIIIIIIIlllIlIIlIIIIlI * lllllllllllIIIIIIIlllIlIIlIlllll;
                    }
                }
            }
        }
    }
    
    public final double grad2(final int lllllllllllIIIIIIIlllIlIllIIIlII, final double lllllllllllIIIIIIIlllIlIllIIIlll, final double lllllllllllIIIIIIIlllIlIllIIIIlI) {
        final int lllllllllllIIIIIIIlllIlIllIIIlIl = lllllllllllIIIIIIIlllIlIllIIIlII & 0xF;
        return NoiseGeneratorImproved.GRAD_2X[lllllllllllIIIIIIIlllIlIllIIIlIl] * lllllllllllIIIIIIIlllIlIllIIIlll + NoiseGeneratorImproved.GRAD_2Z[lllllllllllIIIIIIIlllIlIllIIIlIl] * lllllllllllIIIIIIIlllIlIllIIIIlI;
    }
    
    static {
        GRAD_X = new double[] { 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0 };
        GRAD_Y = new double[] { 1.0, 1.0, -1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0 };
        GRAD_Z = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0 };
        GRAD_2X = new double[] { 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0 };
        GRAD_2Z = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0 };
    }
    
    public NoiseGeneratorImproved() {
        this(new Random());
    }
    
    public NoiseGeneratorImproved(final Random lllllllllllIIIIIIIlllIlIlllIIIIl) {
        this.permutations = new int[512];
        this.xCoord = lllllllllllIIIIIIIlllIlIlllIIIIl.nextDouble() * 256.0;
        this.yCoord = lllllllllllIIIIIIIlllIlIlllIIIIl.nextDouble() * 256.0;
        this.zCoord = lllllllllllIIIIIIIlllIlIlllIIIIl.nextDouble() * 256.0;
        for (int lllllllllllIIIIIIIlllIlIlllIIIII = 0; lllllllllllIIIIIIIlllIlIlllIIIII < 256; this.permutations[lllllllllllIIIIIIIlllIlIlllIIIII] = lllllllllllIIIIIIIlllIlIlllIIIII++) {}
        for (int lllllllllllIIIIIIIlllIlIllIlllll = 0; lllllllllllIIIIIIIlllIlIllIlllll < 256; ++lllllllllllIIIIIIIlllIlIllIlllll) {
            final int lllllllllllIIIIIIIlllIlIllIllllI = lllllllllllIIIIIIIlllIlIlllIIIIl.nextInt(256 - lllllllllllIIIIIIIlllIlIllIlllll) + lllllllllllIIIIIIIlllIlIllIlllll;
            final int lllllllllllIIIIIIIlllIlIllIlllIl = this.permutations[lllllllllllIIIIIIIlllIlIllIlllll];
            this.permutations[lllllllllllIIIIIIIlllIlIllIlllll] = this.permutations[lllllllllllIIIIIIIlllIlIllIllllI];
            this.permutations[lllllllllllIIIIIIIlllIlIllIllllI] = lllllllllllIIIIIIIlllIlIllIlllIl;
            this.permutations[lllllllllllIIIIIIIlllIlIllIlllll + 256] = this.permutations[lllllllllllIIIIIIIlllIlIllIlllll];
        }
    }
}
