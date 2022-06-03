// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;

public class GenLayerAddMushroomIsland extends GenLayer
{
    public GenLayerAddMushroomIsland(final long lllllllllllIlIlllIIIlIIIIlIllllI, final GenLayer lllllllllllIlIlllIIIlIIIIlIllIlI) {
        super(lllllllllllIlIlllIIIlIIIIlIllllI);
        this.parent = lllllllllllIlIlllIIIlIIIIlIllIlI;
    }
    
    @Override
    public int[] getInts(final int lllllllllllIlIlllIIIlIIIIlIIIllI, final int lllllllllllIlIlllIIIlIIIIIllIIll, final int lllllllllllIlIlllIIIlIIIIlIIIlII, final int lllllllllllIlIlllIIIlIIIIlIIIIll) {
        final int lllllllllllIlIlllIIIlIIIIlIIIIlI = lllllllllllIlIlllIIIlIIIIlIIIllI - 1;
        final int lllllllllllIlIlllIIIlIIIIlIIIIIl = lllllllllllIlIlllIIIlIIIIIllIIll - 1;
        final int lllllllllllIlIlllIIIlIIIIlIIIIII = lllllllllllIlIlllIIIlIIIIlIIIlII + 2;
        final int lllllllllllIlIlllIIIlIIIIIllllll = lllllllllllIlIlllIIIlIIIIlIIIIll + 2;
        final int[] lllllllllllIlIlllIIIlIIIIIlllllI = this.parent.getInts(lllllllllllIlIlllIIIlIIIIlIIIIlI, lllllllllllIlIlllIIIlIIIIlIIIIIl, lllllllllllIlIlllIIIlIIIIlIIIIII, lllllllllllIlIlllIIIlIIIIIllllll);
        final int[] lllllllllllIlIlllIIIlIIIIIllllIl = IntCache.getIntCache(lllllllllllIlIlllIIIlIIIIlIIIlII * lllllllllllIlIlllIIIlIIIIlIIIIll);
        for (int lllllllllllIlIlllIIIlIIIIIllllII = 0; lllllllllllIlIlllIIIlIIIIIllllII < lllllllllllIlIlllIIIlIIIIlIIIIll; ++lllllllllllIlIlllIIIlIIIIIllllII) {
            for (int lllllllllllIlIlllIIIlIIIIIlllIll = 0; lllllllllllIlIlllIIIlIIIIIlllIll < lllllllllllIlIlllIIIlIIIIlIIIlII; ++lllllllllllIlIlllIIIlIIIIIlllIll) {
                final int lllllllllllIlIlllIIIlIIIIIlllIlI = lllllllllllIlIlllIIIlIIIIIlllllI[lllllllllllIlIlllIIIlIIIIIlllIll + 0 + (lllllllllllIlIlllIIIlIIIIIllllII + 0) * lllllllllllIlIlllIIIlIIIIlIIIIII];
                final int lllllllllllIlIlllIIIlIIIIIlllIIl = lllllllllllIlIlllIIIlIIIIIlllllI[lllllllllllIlIlllIIIlIIIIIlllIll + 2 + (lllllllllllIlIlllIIIlIIIIIllllII + 0) * lllllllllllIlIlllIIIlIIIIlIIIIII];
                final int lllllllllllIlIlllIIIlIIIIIlllIII = lllllllllllIlIlllIIIlIIIIIlllllI[lllllllllllIlIlllIIIlIIIIIlllIll + 0 + (lllllllllllIlIlllIIIlIIIIIllllII + 2) * lllllllllllIlIlllIIIlIIIIlIIIIII];
                final int lllllllllllIlIlllIIIlIIIIIllIlll = lllllllllllIlIlllIIIlIIIIIlllllI[lllllllllllIlIlllIIIlIIIIIlllIll + 2 + (lllllllllllIlIlllIIIlIIIIIllllII + 2) * lllllllllllIlIlllIIIlIIIIlIIIIII];
                final int lllllllllllIlIlllIIIlIIIIIllIllI = lllllllllllIlIlllIIIlIIIIIlllllI[lllllllllllIlIlllIIIlIIIIIlllIll + 1 + (lllllllllllIlIlllIIIlIIIIIllllII + 1) * lllllllllllIlIlllIIIlIIIIlIIIIII];
                this.initChunkSeed(lllllllllllIlIlllIIIlIIIIIlllIll + lllllllllllIlIlllIIIlIIIIlIIIllI, lllllllllllIlIlllIIIlIIIIIllllII + lllllllllllIlIlllIIIlIIIIIllIIll);
                if (lllllllllllIlIlllIIIlIIIIIllIllI == 0 && lllllllllllIlIlllIIIlIIIIIlllIlI == 0 && lllllllllllIlIlllIIIlIIIIIlllIIl == 0 && lllllllllllIlIlllIIIlIIIIIlllIII == 0 && lllllllllllIlIlllIIIlIIIIIllIlll == 0 && this.nextInt(100) == 0) {
                    lllllllllllIlIlllIIIlIIIIIllllIl[lllllllllllIlIlllIIIlIIIIIlllIll + lllllllllllIlIlllIIIlIIIIIllllII * lllllllllllIlIlllIIIlIIIIlIIIlII] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND);
                }
                else {
                    lllllllllllIlIlllIIIlIIIIIllllIl[lllllllllllIlIlllIIIlIIIIIlllIll + lllllllllllIlIlllIIIlIIIIIllllII * lllllllllllIlIlllIIIlIIIIlIIIlII] = lllllllllllIlIlllIIIlIIIIIllIllI;
                }
            }
        }
        return lllllllllllIlIlllIIIlIIIIIllllIl;
    }
}
