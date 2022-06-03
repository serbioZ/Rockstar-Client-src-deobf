// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;

public class GenLayerDeepOcean extends GenLayer
{
    @Override
    public int[] getInts(final int llllllllllllIIlllIlIlIIIlllllIlI, final int llllllllllllIIlllIlIlIIIlllIIllI, final int llllllllllllIIlllIlIlIIIlllIIlIl, final int llllllllllllIIlllIlIlIIIllllIlll) {
        final int llllllllllllIIlllIlIlIIIllllIllI = llllllllllllIIlllIlIlIIIlllllIlI - 1;
        final int llllllllllllIIlllIlIlIIIllllIlIl = llllllllllllIIlllIlIlIIIlllIIllI - 1;
        final int llllllllllllIIlllIlIlIIIllllIlII = llllllllllllIIlllIlIlIIIlllIIlIl + 2;
        final int llllllllllllIIlllIlIlIIIllllIIll = llllllllllllIIlllIlIlIIIllllIlll + 2;
        final int[] llllllllllllIIlllIlIlIIIllllIIlI = this.parent.getInts(llllllllllllIIlllIlIlIIIllllIllI, llllllllllllIIlllIlIlIIIllllIlIl, llllllllllllIIlllIlIlIIIllllIlII, llllllllllllIIlllIlIlIIIllllIIll);
        final int[] llllllllllllIIlllIlIlIIIllllIIIl = IntCache.getIntCache(llllllllllllIIlllIlIlIIIlllIIlIl * llllllllllllIIlllIlIlIIIllllIlll);
        for (int llllllllllllIIlllIlIlIIIllllIIII = 0; llllllllllllIIlllIlIlIIIllllIIII < llllllllllllIIlllIlIlIIIllllIlll; ++llllllllllllIIlllIlIlIIIllllIIII) {
            for (int llllllllllllIIlllIlIlIIIlllIllll = 0; llllllllllllIIlllIlIlIIIlllIllll < llllllllllllIIlllIlIlIIIlllIIlIl; ++llllllllllllIIlllIlIlIIIlllIllll) {
                final int llllllllllllIIlllIlIlIIIlllIlllI = llllllllllllIIlllIlIlIIIllllIIlI[llllllllllllIIlllIlIlIIIlllIllll + 1 + (llllllllllllIIlllIlIlIIIllllIIII + 1 - 1) * (llllllllllllIIlllIlIlIIIlllIIlIl + 2)];
                final int llllllllllllIIlllIlIlIIIlllIllIl = llllllllllllIIlllIlIlIIIllllIIlI[llllllllllllIIlllIlIlIIIlllIllll + 1 + 1 + (llllllllllllIIlllIlIlIIIllllIIII + 1) * (llllllllllllIIlllIlIlIIIlllIIlIl + 2)];
                final int llllllllllllIIlllIlIlIIIlllIllII = llllllllllllIIlllIlIlIIIllllIIlI[llllllllllllIIlllIlIlIIIlllIllll + 1 - 1 + (llllllllllllIIlllIlIlIIIllllIIII + 1) * (llllllllllllIIlllIlIlIIIlllIIlIl + 2)];
                final int llllllllllllIIlllIlIlIIIlllIlIll = llllllllllllIIlllIlIlIIIllllIIlI[llllllllllllIIlllIlIlIIIlllIllll + 1 + (llllllllllllIIlllIlIlIIIllllIIII + 1 + 1) * (llllllllllllIIlllIlIlIIIlllIIlIl + 2)];
                final int llllllllllllIIlllIlIlIIIlllIlIlI = llllllllllllIIlllIlIlIIIllllIIlI[llllllllllllIIlllIlIlIIIlllIllll + 1 + (llllllllllllIIlllIlIlIIIllllIIII + 1) * llllllllllllIIlllIlIlIIIllllIlII];
                int llllllllllllIIlllIlIlIIIlllIlIIl = 0;
                if (llllllllllllIIlllIlIlIIIlllIlllI == 0) {
                    ++llllllllllllIIlllIlIlIIIlllIlIIl;
                }
                if (llllllllllllIIlllIlIlIIIlllIllIl == 0) {
                    ++llllllllllllIIlllIlIlIIIlllIlIIl;
                }
                if (llllllllllllIIlllIlIlIIIlllIllII == 0) {
                    ++llllllllllllIIlllIlIlIIIlllIlIIl;
                }
                if (llllllllllllIIlllIlIlIIIlllIlIll == 0) {
                    ++llllllllllllIIlllIlIlIIIlllIlIIl;
                }
                if (llllllllllllIIlllIlIlIIIlllIlIlI == 0 && llllllllllllIIlllIlIlIIIlllIlIIl > 3) {
                    llllllllllllIIlllIlIlIIIllllIIIl[llllllllllllIIlllIlIlIIIlllIllll + llllllllllllIIlllIlIlIIIllllIIII * llllllllllllIIlllIlIlIIIlllIIlIl] = Biome.getIdForBiome(Biomes.DEEP_OCEAN);
                }
                else {
                    llllllllllllIIlllIlIlIIIllllIIIl[llllllllllllIIlllIlIlIIIlllIllll + llllllllllllIIlllIlIlIIIllllIIII * llllllllllllIIlllIlIlIIIlllIIlIl] = llllllllllllIIlllIlIlIIIlllIlIlI;
                }
            }
        }
        return llllllllllllIIlllIlIlIIIllllIIIl;
    }
    
    public GenLayerDeepOcean(final long llllllllllllIIlllIlIlIIlIIIlIIll, final GenLayer llllllllllllIIlllIlIlIIlIIIIllll) {
        super(llllllllllllIIlllIlIlIIlIIIlIIll);
        this.parent = llllllllllllIIlllIlIlIIlIIIIllll;
    }
}
