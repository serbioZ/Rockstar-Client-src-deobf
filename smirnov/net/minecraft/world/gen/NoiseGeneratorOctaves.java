// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.util.math.MathHelper;
import java.util.Random;

public class NoiseGeneratorOctaves extends NoiseGenerator
{
    private final /* synthetic */ NoiseGeneratorImproved[] generatorCollection;
    private final /* synthetic */ int octaves;
    
    public NoiseGeneratorOctaves(final Random llllllllllllIIlllllIlllIIIllIlII, final int llllllllllllIIlllllIlllIIIllIIll) {
        this.octaves = llllllllllllIIlllllIlllIIIllIIll;
        this.generatorCollection = new NoiseGeneratorImproved[llllllllllllIIlllllIlllIIIllIIll];
        for (int llllllllllllIIlllllIlllIIIllIllI = 0; llllllllllllIIlllllIlllIIIllIllI < llllllllllllIIlllllIlllIIIllIIll; ++llllllllllllIIlllllIlllIIIllIllI) {
            this.generatorCollection[llllllllllllIIlllllIlllIIIllIllI] = new NoiseGeneratorImproved(llllllllllllIIlllllIlllIIIllIlII);
        }
    }
    
    public double[] generateNoiseOctaves(final double[] llllllllllllIIlllllIllIlllllIIIl, final int llllllllllllIIlllllIllIlllllIIII, final int llllllllllllIIlllllIllIllllIIllI, final int llllllllllllIIlllllIllIllllIIlIl, final int llllllllllllIIlllllIllIllllIIlII, final double llllllllllllIIlllllIllIllllIIIll, final double llllllllllllIIlllllIllIllllIIIlI, final double llllllllllllIIlllllIllIllllIlIlI) {
        return this.generateNoiseOctaves(llllllllllllIIlllllIllIlllllIIIl, llllllllllllIIlllllIllIlllllIIII, 10, llllllllllllIIlllllIllIllllIIllI, llllllllllllIIlllllIllIllllIIlIl, 1, llllllllllllIIlllllIllIllllIIlII, llllllllllllIIlllllIllIllllIIIll, 1.0, llllllllllllIIlllllIllIllllIIIlI);
    }
    
    public double[] generateNoiseOctaves(double[] llllllllllllIIlllllIlllIIIIIlIll, final int llllllllllllIIlllllIlllIIIIlllIl, final int llllllllllllIIlllllIlllIIIIlllII, final int llllllllllllIIlllllIlllIIIIIlIII, final int llllllllllllIIlllllIlllIIIIllIlI, final int llllllllllllIIlllllIlllIIIIIIllI, final int llllllllllllIIlllllIlllIIIIIIlIl, final double llllllllllllIIlllllIlllIIIIIIlII, final double llllllllllllIIlllllIlllIIIIIIIll, final double llllllllllllIIlllllIlllIIIIIIIlI) {
        if (llllllllllllIIlllllIlllIIIIIlIll == null) {
            llllllllllllIIlllllIlllIIIIIlIll = new double[llllllllllllIIlllllIlllIIIIllIlI * llllllllllllIIlllllIlllIIIIIIllI * llllllllllllIIlllllIlllIIIIIIlIl];
        }
        else {
            for (int llllllllllllIIlllllIlllIIIIlIlII = 0; llllllllllllIIlllllIlllIIIIlIlII < llllllllllllIIlllllIlllIIIIIlIll.length; ++llllllllllllIIlllllIlllIIIIlIlII) {
                llllllllllllIIlllllIlllIIIIIlIll[llllllllllllIIlllllIlllIIIIlIlII] = 0.0;
            }
        }
        double llllllllllllIIlllllIlllIIIIlIIll = 1.0;
        for (int llllllllllllIIlllllIlllIIIIlIIlI = 0; llllllllllllIIlllllIlllIIIIlIIlI < this.octaves; ++llllllllllllIIlllllIlllIIIIlIIlI) {
            double llllllllllllIIlllllIlllIIIIlIIIl = llllllllllllIIlllllIlllIIIIlllIl * llllllllllllIIlllllIlllIIIIlIIll * llllllllllllIIlllllIlllIIIIIIlII;
            final double llllllllllllIIlllllIlllIIIIlIIII = llllllllllllIIlllllIlllIIIIlllII * llllllllllllIIlllllIlllIIIIlIIll * llllllllllllIIlllllIlllIIIIIIIll;
            double llllllllllllIIlllllIlllIIIIIllll = llllllllllllIIlllllIlllIIIIIlIII * llllllllllllIIlllllIlllIIIIlIIll * llllllllllllIIlllllIlllIIIIIIIlI;
            long llllllllllllIIlllllIlllIIIIIlllI = MathHelper.lFloor(llllllllllllIIlllllIlllIIIIlIIIl);
            long llllllllllllIIlllllIlllIIIIIllIl = MathHelper.lFloor(llllllllllllIIlllllIlllIIIIIllll);
            llllllllllllIIlllllIlllIIIIlIIIl -= llllllllllllIIlllllIlllIIIIIlllI;
            llllllllllllIIlllllIlllIIIIIllll -= llllllllllllIIlllllIlllIIIIIllIl;
            llllllllllllIIlllllIlllIIIIIlllI %= 16777216L;
            llllllllllllIIlllllIlllIIIIIllIl %= 16777216L;
            llllllllllllIIlllllIlllIIIIlIIIl += llllllllllllIIlllllIlllIIIIIlllI;
            llllllllllllIIlllllIlllIIIIIllll += llllllllllllIIlllllIlllIIIIIllIl;
            this.generatorCollection[llllllllllllIIlllllIlllIIIIlIIlI].populateNoiseArray((double[])llllllllllllIIlllllIlllIIIIIlIll, llllllllllllIIlllllIlllIIIIlIIIl, llllllllllllIIlllllIlllIIIIlIIII, llllllllllllIIlllllIlllIIIIIllll, llllllllllllIIlllllIlllIIIIllIlI, llllllllllllIIlllllIlllIIIIIIllI, llllllllllllIIlllllIlllIIIIIIlIl, llllllllllllIIlllllIlllIIIIIIlII * llllllllllllIIlllllIlllIIIIlIIll, llllllllllllIIlllllIlllIIIIIIIll * llllllllllllIIlllllIlllIIIIlIIll, llllllllllllIIlllllIlllIIIIIIIlI * llllllllllllIIlllllIlllIIIIlIIll, llllllllllllIIlllllIlllIIIIlIIll);
            llllllllllllIIlllllIlllIIIIlIIll /= 2.0;
        }
        return (double[])llllllllllllIIlllllIlllIIIIIlIll;
    }
}
