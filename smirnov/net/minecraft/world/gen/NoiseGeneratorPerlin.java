// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import java.util.Random;

public class NoiseGeneratorPerlin extends NoiseGenerator
{
    private final /* synthetic */ int levels;
    private final /* synthetic */ NoiseGeneratorSimplex[] noiseLevels;
    
    public double[] getRegion(final double[] llllllllllllIIllllIIIIllIllIIlIl, final double llllllllllllIIllllIIIIllIllIllIl, final double llllllllllllIIllllIIIIllIllIllII, final int llllllllllllIIllllIIIIllIllIIIlI, final int llllllllllllIIllllIIIIllIllIIIIl, final double llllllllllllIIllllIIIIllIllIlIIl, final double llllllllllllIIllllIIIIllIlIlllll, final double llllllllllllIIllllIIIIllIlIllllI) {
        return this.getRegion(llllllllllllIIllllIIIIllIllIIlIl, llllllllllllIIllllIIIIllIllIllIl, llllllllllllIIllllIIIIllIllIllII, llllllllllllIIllllIIIIllIllIIIlI, llllllllllllIIllllIIIIllIllIIIIl, llllllllllllIIllllIIIIllIllIlIIl, llllllllllllIIllllIIIIllIlIlllll, llllllllllllIIllllIIIIllIlIllllI, 0.5);
    }
    
    public double[] getRegion(double[] llllllllllllIIllllIIIIllIlIIIIIl, final double llllllllllllIIllllIIIIllIlIIlllI, final double llllllllllllIIllllIIIIllIIllllll, final int llllllllllllIIllllIIIIllIlIIllII, final int llllllllllllIIllllIIIIllIIllllIl, final double llllllllllllIIllllIIIIllIIllllII, final double llllllllllllIIllllIIIIllIIlllIll, final double llllllllllllIIllllIIIIllIlIIlIII, final double llllllllllllIIllllIIIIllIIlllIIl) {
        if (llllllllllllIIllllIIIIllIlIIIIIl != null && llllllllllllIIllllIIIIllIlIIIIIl.length >= llllllllllllIIllllIIIIllIlIIllII * llllllllllllIIllllIIIIllIIllllIl) {
            for (int llllllllllllIIllllIIIIllIlIIIllI = 0; llllllllllllIIllllIIIIllIlIIIllI < llllllllllllIIllllIIIIllIlIIIIIl.length; ++llllllllllllIIllllIIIIllIlIIIllI) {
                llllllllllllIIllllIIIIllIlIIIIIl[llllllllllllIIllllIIIIllIlIIIllI] = 0.0;
            }
        }
        else {
            llllllllllllIIllllIIIIllIlIIIIIl = new double[llllllllllllIIllllIIIIllIlIIllII * llllllllllllIIllllIIIIllIIllllIl];
        }
        double llllllllllllIIllllIIIIllIlIIIlIl = 1.0;
        double llllllllllllIIllllIIIIllIlIIIlII = 1.0;
        for (int llllllllllllIIllllIIIIllIlIIIIll = 0; llllllllllllIIllllIIIIllIlIIIIll < this.levels; ++llllllllllllIIllllIIIIllIlIIIIll) {
            this.noiseLevels[llllllllllllIIllllIIIIllIlIIIIll].add(llllllllllllIIllllIIIIllIlIIIIIl, llllllllllllIIllllIIIIllIlIIlllI, llllllllllllIIllllIIIIllIIllllll, llllllllllllIIllllIIIIllIlIIllII, llllllllllllIIllllIIIIllIIllllIl, llllllllllllIIllllIIIIllIIllllII * llllllllllllIIllllIIIIllIlIIIlII * llllllllllllIIllllIIIIllIlIIIlIl, llllllllllllIIllllIIIIllIIlllIll * llllllllllllIIllllIIIIllIlIIIlII * llllllllllllIIllllIIIIllIlIIIlIl, 0.55 / llllllllllllIIllllIIIIllIlIIIlIl);
            llllllllllllIIllllIIIIllIlIIIlII *= llllllllllllIIllllIIIIllIlIIlIII;
            llllllllllllIIllllIIIIllIlIIIlIl *= llllllllllllIIllllIIIIllIIlllIIl;
        }
        return llllllllllllIIllllIIIIllIlIIIIIl;
    }
    
    public double getValue(final double llllllllllllIIllllIIIIlllIIIIIll, final double llllllllllllIIllllIIIIlllIIIIIlI) {
        double llllllllllllIIllllIIIIlllIIIIIIl = 0.0;
        double llllllllllllIIllllIIIIlllIIIIIII = 1.0;
        for (int llllllllllllIIllllIIIIllIlllllll = 0; llllllllllllIIllllIIIIllIlllllll < this.levels; ++llllllllllllIIllllIIIIllIlllllll) {
            llllllllllllIIllllIIIIlllIIIIIIl += this.noiseLevels[llllllllllllIIllllIIIIllIlllllll].getValue(llllllllllllIIllllIIIIlllIIIIIll * llllllllllllIIllllIIIIlllIIIIIII, llllllllllllIIllllIIIIlllIIIIIlI * llllllllllllIIllllIIIIlllIIIIIII) / llllllllllllIIllllIIIIlllIIIIIII;
            llllllllllllIIllllIIIIlllIIIIIII /= 2.0;
        }
        return llllllllllllIIllllIIIIlllIIIIIIl;
    }
    
    public NoiseGeneratorPerlin(final Random llllllllllllIIllllIIIIlllIIlIIIl, final int llllllllllllIIllllIIIIlllIIlIIII) {
        this.levels = llllllllllllIIllllIIIIlllIIlIIII;
        this.noiseLevels = new NoiseGeneratorSimplex[llllllllllllIIllllIIIIlllIIlIIII];
        for (int llllllllllllIIllllIIIIlllIIIllll = 0; llllllllllllIIllllIIIIlllIIIllll < llllllllllllIIllllIIIIlllIIlIIII; ++llllllllllllIIllllIIIIlllIIIllll) {
            this.noiseLevels[llllllllllllIIllllIIIIlllIIIllll] = new NoiseGeneratorSimplex(llllllllllllIIllllIIIIlllIIlIIIl);
        }
    }
}
