// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;

public class GenLayerRareBiome extends GenLayer
{
    public GenLayerRareBiome(final long llllllllllllllllIIIIlllIIIIIIlll, final GenLayer llllllllllllllllIIIIlllIIIIIIIll) {
        super(llllllllllllllllIIIIlllIIIIIIlll);
        this.parent = llllllllllllllllIIIIlllIIIIIIIll;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllllIIIIllIllllIllIl, final int llllllllllllllllIIIIllIllllIllII, final int llllllllllllllllIIIIllIlllllIlIl, final int llllllllllllllllIIIIllIllllIlIlI) {
        final int[] llllllllllllllllIIIIllIlllllIIll = this.parent.getInts(llllllllllllllllIIIIllIllllIllIl - 1, llllllllllllllllIIIIllIllllIllII - 1, llllllllllllllllIIIIllIlllllIlIl + 2, llllllllllllllllIIIIllIllllIlIlI + 2);
        final int[] llllllllllllllllIIIIllIlllllIIlI = IntCache.getIntCache(llllllllllllllllIIIIllIlllllIlIl * llllllllllllllllIIIIllIllllIlIlI);
        for (int llllllllllllllllIIIIllIlllllIIIl = 0; llllllllllllllllIIIIllIlllllIIIl < llllllllllllllllIIIIllIllllIlIlI; ++llllllllllllllllIIIIllIlllllIIIl) {
            for (int llllllllllllllllIIIIllIlllllIIII = 0; llllllllllllllllIIIIllIlllllIIII < llllllllllllllllIIIIllIlllllIlIl; ++llllllllllllllllIIIIllIlllllIIII) {
                this.initChunkSeed(llllllllllllllllIIIIllIlllllIIII + llllllllllllllllIIIIllIllllIllIl, llllllllllllllllIIIIllIlllllIIIl + llllllllllllllllIIIIllIllllIllII);
                final int llllllllllllllllIIIIllIllllIllll = llllllllllllllllIIIIllIlllllIIll[llllllllllllllllIIIIllIlllllIIII + 1 + (llllllllllllllllIIIIllIlllllIIIl + 1) * (llllllllllllllllIIIIllIlllllIlIl + 2)];
                if (this.nextInt(57) == 0) {
                    if (llllllllllllllllIIIIllIllllIllll == Biome.getIdForBiome(Biomes.PLAINS)) {
                        llllllllllllllllIIIIllIlllllIIlI[llllllllllllllllIIIIllIlllllIIII + llllllllllllllllIIIIllIlllllIIIl * llllllllllllllllIIIIllIlllllIlIl] = Biome.getIdForBiome(Biomes.MUTATED_PLAINS);
                    }
                    else {
                        llllllllllllllllIIIIllIlllllIIlI[llllllllllllllllIIIIllIlllllIIII + llllllllllllllllIIIIllIlllllIIIl * llllllllllllllllIIIIllIlllllIlIl] = llllllllllllllllIIIIllIllllIllll;
                    }
                }
                else {
                    llllllllllllllllIIIIllIlllllIIlI[llllllllllllllllIIIIllIlllllIIII + llllllllllllllllIIIIllIlllllIIIl * llllllllllllllllIIIIllIlllllIlIl] = llllllllllllllllIIIIllIllllIllll;
                }
            }
        }
        return llllllllllllllllIIIIllIlllllIIlI;
    }
}
