// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import java.util.Random;

public class NoiseGeneratorSimplex
{
    private static final /* synthetic */ int[][] grad3;
    private static final /* synthetic */ double F2;
    private final /* synthetic */ int[] p;
    public static final /* synthetic */ double SQRT_3;
    private static final /* synthetic */ double G2;
    public /* synthetic */ double zo;
    public /* synthetic */ double yo;
    public /* synthetic */ double xo;
    
    public void add(final double[] lllllllllllllIllIIIlIIlllIllIlll, final double lllllllllllllIllIIIlIIlllllIIIll, final double lllllllllllllIllIIIlIIlllIllIlIl, final int lllllllllllllIllIIIlIIlllllIIIIl, final int lllllllllllllIllIIIlIIlllIllIIll, final double lllllllllllllIllIIIlIIlllIllIIlI, final double lllllllllllllIllIIIlIIlllIllIIIl, final double lllllllllllllIllIIIlIIlllIllIIII) {
        int lllllllllllllIllIIIlIIllllIlllII = 0;
        for (int lllllllllllllIllIIIlIIllllIllIll = 0; lllllllllllllIllIIIlIIllllIllIll < lllllllllllllIllIIIlIIlllIllIIll; ++lllllllllllllIllIIIlIIllllIllIll) {
            final double lllllllllllllIllIIIlIIllllIllIlI = (lllllllllllllIllIIIlIIlllIllIlIl + lllllllllllllIllIIIlIIllllIllIll) * lllllllllllllIllIIIlIIlllIllIIIl + this.yo;
            for (int lllllllllllllIllIIIlIIllllIllIIl = 0; lllllllllllllIllIIIlIIllllIllIIl < lllllllllllllIllIIIlIIlllllIIIIl; ++lllllllllllllIllIIIlIIllllIllIIl) {
                final double lllllllllllllIllIIIlIIllllIllIII = (lllllllllllllIllIIIlIIlllllIIIll + lllllllllllllIllIIIlIIllllIllIIl) * lllllllllllllIllIIIlIIlllIllIIlI + this.xo;
                final double lllllllllllllIllIIIlIIllllIlIlll = (lllllllllllllIllIIIlIIllllIllIII + lllllllllllllIllIIIlIIllllIllIlI) * NoiseGeneratorSimplex.F2;
                final int lllllllllllllIllIIIlIIllllIlIllI = fastFloor(lllllllllllllIllIIIlIIllllIllIII + lllllllllllllIllIIIlIIllllIlIlll);
                final int lllllllllllllIllIIIlIIllllIlIlIl = fastFloor(lllllllllllllIllIIIlIIllllIllIlI + lllllllllllllIllIIIlIIllllIlIlll);
                final double lllllllllllllIllIIIlIIllllIlIlII = (lllllllllllllIllIIIlIIllllIlIllI + lllllllllllllIllIIIlIIllllIlIlIl) * NoiseGeneratorSimplex.G2;
                final double lllllllllllllIllIIIlIIllllIlIIll = lllllllllllllIllIIIlIIllllIlIllI - lllllllllllllIllIIIlIIllllIlIlII;
                final double lllllllllllllIllIIIlIIllllIlIIlI = lllllllllllllIllIIIlIIllllIlIlIl - lllllllllllllIllIIIlIIllllIlIlII;
                final double lllllllllllllIllIIIlIIllllIlIIIl = lllllllllllllIllIIIlIIllllIllIII - lllllllllllllIllIIIlIIllllIlIIll;
                final double lllllllllllllIllIIIlIIllllIlIIII = lllllllllllllIllIIIlIIllllIllIlI - lllllllllllllIllIIIlIIllllIlIIlI;
                int lllllllllllllIllIIIlIIllllIIlllI = 0;
                int lllllllllllllIllIIIlIIllllIIllII = 0;
                if (lllllllllllllIllIIIlIIllllIlIIIl > lllllllllllllIllIIIlIIllllIlIIII) {
                    final int lllllllllllllIllIIIlIIllllIIllll = 1;
                    final int lllllllllllllIllIIIlIIllllIIllIl = 0;
                }
                else {
                    lllllllllllllIllIIIlIIllllIIlllI = 0;
                    lllllllllllllIllIIIlIIllllIIllII = 1;
                }
                final double lllllllllllllIllIIIlIIllllIIlIll = lllllllllllllIllIIIlIIllllIlIIIl - lllllllllllllIllIIIlIIllllIIlllI + NoiseGeneratorSimplex.G2;
                final double lllllllllllllIllIIIlIIllllIIlIlI = lllllllllllllIllIIIlIIllllIlIIII - lllllllllllllIllIIIlIIllllIIllII + NoiseGeneratorSimplex.G2;
                final double lllllllllllllIllIIIlIIllllIIlIIl = lllllllllllllIllIIIlIIllllIlIIIl - 1.0 + 2.0 * NoiseGeneratorSimplex.G2;
                final double lllllllllllllIllIIIlIIllllIIlIII = lllllllllllllIllIIIlIIllllIlIIII - 1.0 + 2.0 * NoiseGeneratorSimplex.G2;
                final int lllllllllllllIllIIIlIIllllIIIlll = lllllllllllllIllIIIlIIllllIlIllI & 0xFF;
                final int lllllllllllllIllIIIlIIllllIIIllI = lllllllllllllIllIIIlIIllllIlIlIl & 0xFF;
                final int lllllllllllllIllIIIlIIllllIIIlIl = this.p[lllllllllllllIllIIIlIIllllIIIlll + this.p[lllllllllllllIllIIIlIIllllIIIllI]] % 12;
                final int lllllllllllllIllIIIlIIllllIIIlII = this.p[lllllllllllllIllIIIlIIllllIIIlll + lllllllllllllIllIIIlIIllllIIlllI + this.p[lllllllllllllIllIIIlIIllllIIIllI + lllllllllllllIllIIIlIIllllIIllII]] % 12;
                final int lllllllllllllIllIIIlIIllllIIIIll = this.p[lllllllllllllIllIIIlIIllllIIIlll + 1 + this.p[lllllllllllllIllIIIlIIllllIIIllI + 1]] % 12;
                double lllllllllllllIllIIIlIIllllIIIIlI = 0.5 - lllllllllllllIllIIIlIIllllIlIIIl * lllllllllllllIllIIIlIIllllIlIIIl - lllllllllllllIllIIIlIIllllIlIIII * lllllllllllllIllIIIlIIllllIlIIII;
                double lllllllllllllIllIIIlIIllllIIIIII = 0.0;
                if (lllllllllllllIllIIIlIIllllIIIIlI < 0.0) {
                    final double lllllllllllllIllIIIlIIllllIIIIIl = 0.0;
                }
                else {
                    lllllllllllllIllIIIlIIllllIIIIlI *= lllllllllllllIllIIIlIIllllIIIIlI;
                    lllllllllllllIllIIIlIIllllIIIIII = lllllllllllllIllIIIlIIllllIIIIlI * lllllllllllllIllIIIlIIllllIIIIlI * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIllIIIlIIllllIIIlIl], lllllllllllllIllIIIlIIllllIlIIIl, lllllllllllllIllIIIlIIllllIlIIII);
                }
                double lllllllllllllIllIIIlIIlllIllllll = 0.5 - lllllllllllllIllIIIlIIllllIIlIll * lllllllllllllIllIIIlIIllllIIlIll - lllllllllllllIllIIIlIIllllIIlIlI * lllllllllllllIllIIIlIIllllIIlIlI;
                double lllllllllllllIllIIIlIIlllIllllIl = 0.0;
                if (lllllllllllllIllIIIlIIlllIllllll < 0.0) {
                    final double lllllllllllllIllIIIlIIlllIlllllI = 0.0;
                }
                else {
                    lllllllllllllIllIIIlIIlllIllllll *= lllllllllllllIllIIIlIIlllIllllll;
                    lllllllllllllIllIIIlIIlllIllllIl = lllllllllllllIllIIIlIIlllIllllll * lllllllllllllIllIIIlIIlllIllllll * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIllIIIlIIllllIIIlII], lllllllllllllIllIIIlIIllllIIlIll, lllllllllllllIllIIIlIIllllIIlIlI);
                }
                double lllllllllllllIllIIIlIIlllIllllII = 0.5 - lllllllllllllIllIIIlIIllllIIlIIl * lllllllllllllIllIIIlIIllllIIlIIl - lllllllllllllIllIIIlIIllllIIlIII * lllllllllllllIllIIIlIIllllIIlIII;
                double lllllllllllllIllIIIlIIlllIlllIlI = 0.0;
                if (lllllllllllllIllIIIlIIlllIllllII < 0.0) {
                    final double lllllllllllllIllIIIlIIlllIlllIll = 0.0;
                }
                else {
                    lllllllllllllIllIIIlIIlllIllllII *= lllllllllllllIllIIIlIIlllIllllII;
                    lllllllllllllIllIIIlIIlllIlllIlI = lllllllllllllIllIIIlIIlllIllllII * lllllllllllllIllIIIlIIlllIllllII * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIllIIIlIIllllIIIIll], lllllllllllllIllIIIlIIllllIIlIIl, lllllllllllllIllIIIlIIllllIIlIII);
                }
                final int n;
                final int lllllllllllllIllIIIlIIlllIlllIIl = n = lllllllllllllIllIIIlIIllllIlllII++;
                lllllllllllllIllIIIlIIlllIllIlll[n] += 70.0 * (lllllllllllllIllIIIlIIllllIIIIII + lllllllllllllIllIIIlIIlllIllllIl + lllllllllllllIllIIIlIIlllIlllIlI) * lllllllllllllIllIIIlIIlllIllIIII;
            }
        }
    }
    
    private static double dot(final int[] lllllllllllllIllIIIlIlIIIlllIIlI, final double lllllllllllllIllIIIlIlIIIlllIIIl, final double lllllllllllllIllIIIlIlIIIllIllIl) {
        return lllllllllllllIllIIIlIlIIIlllIIlI[0] * lllllllllllllIllIIIlIlIIIlllIIIl + lllllllllllllIllIIIlIlIIIlllIIlI[1] * lllllllllllllIllIIIlIlIIIllIllIl;
    }
    
    public NoiseGeneratorSimplex(final Random lllllllllllllIllIIIlIlIIIlllllII) {
        this.p = new int[512];
        this.xo = lllllllllllllIllIIIlIlIIIlllllII.nextDouble() * 256.0;
        this.yo = lllllllllllllIllIIIlIlIIIlllllII.nextDouble() * 256.0;
        this.zo = lllllllllllllIllIIIlIlIIIlllllII.nextDouble() * 256.0;
        for (int lllllllllllllIllIIIlIlIIlIIIIIIl = 0; lllllllllllllIllIIIlIlIIlIIIIIIl < 256; this.p[lllllllllllllIllIIIlIlIIlIIIIIIl] = lllllllllllllIllIIIlIlIIlIIIIIIl++) {}
        for (int lllllllllllllIllIIIlIlIIlIIIIIII = 0; lllllllllllllIllIIIlIlIIlIIIIIII < 256; ++lllllllllllllIllIIIlIlIIlIIIIIII) {
            final int lllllllllllllIllIIIlIlIIIlllllll = lllllllllllllIllIIIlIlIIIlllllII.nextInt(256 - lllllllllllllIllIIIlIlIIlIIIIIII) + lllllllllllllIllIIIlIlIIlIIIIIII;
            final int lllllllllllllIllIIIlIlIIIllllllI = this.p[lllllllllllllIllIIIlIlIIlIIIIIII];
            this.p[lllllllllllllIllIIIlIlIIlIIIIIII] = this.p[lllllllllllllIllIIIlIlIIIlllllll];
            this.p[lllllllllllllIllIIIlIlIIIlllllll] = lllllllllllllIllIIIlIlIIIllllllI;
            this.p[lllllllllllllIllIIIlIlIIlIIIIIII + 256] = this.p[lllllllllllllIllIIIlIlIIlIIIIIII];
        }
    }
    
    static {
        grad3 = new int[][] { { 1, 1, 0 }, { -1, 1, 0 }, { 1, -1, 0 }, { -1, -1, 0 }, { 1, 0, 1 }, { -1, 0, 1 }, { 1, 0, -1 }, { -1, 0, -1 }, { 0, 1, 1 }, { 0, -1, 1 }, { 0, 1, -1 }, { 0, -1, -1 } };
        SQRT_3 = Math.sqrt(3.0);
        F2 = 0.5 * (NoiseGeneratorSimplex.SQRT_3 - 1.0);
        G2 = (3.0 - NoiseGeneratorSimplex.SQRT_3) / 6.0;
    }
    
    public double getValue(final double lllllllllllllIllIIIlIlIIIlIIllIl, final double lllllllllllllIllIIIlIlIIIIlIlIIl) {
        final double lllllllllllllIllIIIlIlIIIlIIlIll = 0.5 * (NoiseGeneratorSimplex.SQRT_3 - 1.0);
        final double lllllllllllllIllIIIlIlIIIlIIlIlI = (lllllllllllllIllIIIlIlIIIlIIllIl + lllllllllllllIllIIIlIlIIIIlIlIIl) * lllllllllllllIllIIIlIlIIIlIIlIll;
        final int lllllllllllllIllIIIlIlIIIlIIlIIl = fastFloor(lllllllllllllIllIIIlIlIIIlIIllIl + lllllllllllllIllIIIlIlIIIlIIlIlI);
        final int lllllllllllllIllIIIlIlIIIlIIlIII = fastFloor(lllllllllllllIllIIIlIlIIIIlIlIIl + lllllllllllllIllIIIlIlIIIlIIlIlI);
        final double lllllllllllllIllIIIlIlIIIlIIIlll = (3.0 - NoiseGeneratorSimplex.SQRT_3) / 6.0;
        final double lllllllllllllIllIIIlIlIIIlIIIllI = (lllllllllllllIllIIIlIlIIIlIIlIIl + lllllllllllllIllIIIlIlIIIlIIlIII) * lllllllllllllIllIIIlIlIIIlIIIlll;
        final double lllllllllllllIllIIIlIlIIIlIIIlIl = lllllllllllllIllIIIlIlIIIlIIlIIl - lllllllllllllIllIIIlIlIIIlIIIllI;
        final double lllllllllllllIllIIIlIlIIIlIIIlII = lllllllllllllIllIIIlIlIIIlIIlIII - lllllllllllllIllIIIlIlIIIlIIIllI;
        final double lllllllllllllIllIIIlIlIIIlIIIIll = lllllllllllllIllIIIlIlIIIlIIllIl - lllllllllllllIllIIIlIlIIIlIIIlIl;
        final double lllllllllllllIllIIIlIlIIIlIIIIlI = lllllllllllllIllIIIlIlIIIIlIlIIl - lllllllllllllIllIIIlIlIIIlIIIlII;
        int lllllllllllllIllIIIlIlIIIlIIIIII = 0;
        int lllllllllllllIllIIIlIlIIIIlllllI = 0;
        if (lllllllllllllIllIIIlIlIIIlIIIIll > lllllllllllllIllIIIlIlIIIlIIIIlI) {
            final int lllllllllllllIllIIIlIlIIIlIIIIIl = 1;
            final int lllllllllllllIllIIIlIlIIIIllllll = 0;
        }
        else {
            lllllllllllllIllIIIlIlIIIlIIIIII = 0;
            lllllllllllllIllIIIlIlIIIIlllllI = 1;
        }
        final double lllllllllllllIllIIIlIlIIIIllllIl = lllllllllllllIllIIIlIlIIIlIIIIll - lllllllllllllIllIIIlIlIIIlIIIIII + lllllllllllllIllIIIlIlIIIlIIIlll;
        final double lllllllllllllIllIIIlIlIIIIllllII = lllllllllllllIllIIIlIlIIIlIIIIlI - lllllllllllllIllIIIlIlIIIIlllllI + lllllllllllllIllIIIlIlIIIlIIIlll;
        final double lllllllllllllIllIIIlIlIIIIlllIll = lllllllllllllIllIIIlIlIIIlIIIIll - 1.0 + 2.0 * lllllllllllllIllIIIlIlIIIlIIIlll;
        final double lllllllllllllIllIIIlIlIIIIlllIlI = lllllllllllllIllIIIlIlIIIlIIIIlI - 1.0 + 2.0 * lllllllllllllIllIIIlIlIIIlIIIlll;
        final int lllllllllllllIllIIIlIlIIIIlllIIl = lllllllllllllIllIIIlIlIIIlIIlIIl & 0xFF;
        final int lllllllllllllIllIIIlIlIIIIlllIII = lllllllllllllIllIIIlIlIIIlIIlIII & 0xFF;
        final int lllllllllllllIllIIIlIlIIIIllIlll = this.p[lllllllllllllIllIIIlIlIIIIlllIIl + this.p[lllllllllllllIllIIIlIlIIIIlllIII]] % 12;
        final int lllllllllllllIllIIIlIlIIIIllIllI = this.p[lllllllllllllIllIIIlIlIIIIlllIIl + lllllllllllllIllIIIlIlIIIlIIIIII + this.p[lllllllllllllIllIIIlIlIIIIlllIII + lllllllllllllIllIIIlIlIIIIlllllI]] % 12;
        final int lllllllllllllIllIIIlIlIIIIllIlIl = this.p[lllllllllllllIllIIIlIlIIIIlllIIl + 1 + this.p[lllllllllllllIllIIIlIlIIIIlllIII + 1]] % 12;
        double lllllllllllllIllIIIlIlIIIIllIlII = 0.5 - lllllllllllllIllIIIlIlIIIlIIIIll * lllllllllllllIllIIIlIlIIIlIIIIll - lllllllllllllIllIIIlIlIIIlIIIIlI * lllllllllllllIllIIIlIlIIIlIIIIlI;
        double lllllllllllllIllIIIlIlIIIIllIIlI = 0.0;
        if (lllllllllllllIllIIIlIlIIIIllIlII < 0.0) {
            final double lllllllllllllIllIIIlIlIIIIllIIll = 0.0;
        }
        else {
            lllllllllllllIllIIIlIlIIIIllIlII *= lllllllllllllIllIIIlIlIIIIllIlII;
            lllllllllllllIllIIIlIlIIIIllIIlI = lllllllllllllIllIIIlIlIIIIllIlII * lllllllllllllIllIIIlIlIIIIllIlII * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIllIIIlIlIIIIllIlll], lllllllllllllIllIIIlIlIIIlIIIIll, lllllllllllllIllIIIlIlIIIlIIIIlI);
        }
        double lllllllllllllIllIIIlIlIIIIllIIIl = 0.5 - lllllllllllllIllIIIlIlIIIIllllIl * lllllllllllllIllIIIlIlIIIIllllIl - lllllllllllllIllIIIlIlIIIIllllII * lllllllllllllIllIIIlIlIIIIllllII;
        double lllllllllllllIllIIIlIlIIIIlIllll = 0.0;
        if (lllllllllllllIllIIIlIlIIIIllIIIl < 0.0) {
            final double lllllllllllllIllIIIlIlIIIIllIIII = 0.0;
        }
        else {
            lllllllllllllIllIIIlIlIIIIllIIIl *= lllllllllllllIllIIIlIlIIIIllIIIl;
            lllllllllllllIllIIIlIlIIIIlIllll = lllllllllllllIllIIIlIlIIIIllIIIl * lllllllllllllIllIIIlIlIIIIllIIIl * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIllIIIlIlIIIIllIllI], lllllllllllllIllIIIlIlIIIIllllIl, lllllllllllllIllIIIlIlIIIIllllII);
        }
        double lllllllllllllIllIIIlIlIIIIlIlllI = 0.5 - lllllllllllllIllIIIlIlIIIIlllIll * lllllllllllllIllIIIlIlIIIIlllIll - lllllllllllllIllIIIlIlIIIIlllIlI * lllllllllllllIllIIIlIlIIIIlllIlI;
        double lllllllllllllIllIIIlIlIIIIlIllII = 0.0;
        if (lllllllllllllIllIIIlIlIIIIlIlllI < 0.0) {
            final double lllllllllllllIllIIIlIlIIIIlIllIl = 0.0;
        }
        else {
            lllllllllllllIllIIIlIlIIIIlIlllI *= lllllllllllllIllIIIlIlIIIIlIlllI;
            lllllllllllllIllIIIlIlIIIIlIllII = lllllllllllllIllIIIlIlIIIIlIlllI * lllllllllllllIllIIIlIlIIIIlIlllI * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIllIIIlIlIIIIllIlIl], lllllllllllllIllIIIlIlIIIIlllIll, lllllllllllllIllIIIlIlIIIIlllIlI);
        }
        return 70.0 * (lllllllllllllIllIIIlIlIIIIllIIlI + lllllllllllllIllIIIlIlIIIIlIllll + lllllllllllllIllIIIlIlIIIIlIllII);
    }
    
    private static int fastFloor(final double lllllllllllllIllIIIlIlIIIlllIllI) {
        return (lllllllllllllIllIIIlIlIIIlllIllI > 0.0) ? ((int)lllllllllllllIllIIIlIlIIIlllIllI) : ((int)lllllllllllllIllIIIlIlIIIlllIllI - 1);
    }
    
    public NoiseGeneratorSimplex() {
        this(new Random());
    }
}
