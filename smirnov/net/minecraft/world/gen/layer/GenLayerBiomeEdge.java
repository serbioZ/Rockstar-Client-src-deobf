// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

public class GenLayerBiomeEdge extends GenLayer
{
    private boolean replaceBiomeEdgeIfNecessary(final int[] lllllllllllIIIIlIIlIlIIllIIlIIlI, final int[] lllllllllllIIIIlIIlIlIIllIIlIIIl, final int lllllllllllIIIIlIIlIlIIllIIlIIII, final int lllllllllllIIIIlIIlIlIIllIIIIIlI, final int lllllllllllIIIIlIIlIlIIllIIIIIIl, final int lllllllllllIIIIlIIlIlIIllIIIIIII, final int lllllllllllIIIIlIIlIlIIlIlllllll, final int lllllllllllIIIIlIIlIlIIlIllllllI) {
        if (!GenLayer.biomesEqualOrMesaPlateau(lllllllllllIIIIlIIlIlIIllIIIIIII, lllllllllllIIIIlIIlIlIIlIlllllll)) {
            return false;
        }
        final int lllllllllllIIIIlIIlIlIIllIIIlIlI = lllllllllllIIIIlIIlIlIIllIIlIIlI[lllllllllllIIIIlIIlIlIIllIIlIIII + 1 + (lllllllllllIIIIlIIlIlIIllIIIIIlI + 1 - 1) * (lllllllllllIIIIlIIlIlIIllIIIIIIl + 2)];
        final int lllllllllllIIIIlIIlIlIIllIIIlIIl = lllllllllllIIIIlIIlIlIIllIIlIIlI[lllllllllllIIIIlIIlIlIIllIIlIIII + 1 + 1 + (lllllllllllIIIIlIIlIlIIllIIIIIlI + 1) * (lllllllllllIIIIlIIlIlIIllIIIIIIl + 2)];
        final int lllllllllllIIIIlIIlIlIIllIIIlIII = lllllllllllIIIIlIIlIlIIllIIlIIlI[lllllllllllIIIIlIIlIlIIllIIlIIII + 1 - 1 + (lllllllllllIIIIlIIlIlIIllIIIIIlI + 1) * (lllllllllllIIIIlIIlIlIIllIIIIIIl + 2)];
        final int lllllllllllIIIIlIIlIlIIllIIIIlll = lllllllllllIIIIlIIlIlIIllIIlIIlI[lllllllllllIIIIlIIlIlIIllIIlIIII + 1 + (lllllllllllIIIIlIIlIlIIllIIIIIlI + 1 + 1) * (lllllllllllIIIIlIIlIlIIllIIIIIIl + 2)];
        if (this.canBiomesBeNeighbors(lllllllllllIIIIlIIlIlIIllIIIlIlI, lllllllllllIIIIlIIlIlIIlIlllllll) && this.canBiomesBeNeighbors(lllllllllllIIIIlIIlIlIIllIIIlIIl, lllllllllllIIIIlIIlIlIIlIlllllll) && this.canBiomesBeNeighbors(lllllllllllIIIIlIIlIlIIllIIIlIII, lllllllllllIIIIlIIlIlIIlIlllllll) && this.canBiomesBeNeighbors(lllllllllllIIIIlIIlIlIIllIIIIlll, lllllllllllIIIIlIIlIlIIlIlllllll)) {
            lllllllllllIIIIlIIlIlIIllIIlIIIl[lllllllllllIIIIlIIlIlIIllIIlIIII + lllllllllllIIIIlIIlIlIIllIIIIIlI * lllllllllllIIIIlIIlIlIIllIIIIIIl] = lllllllllllIIIIlIIlIlIIllIIIIIII;
        }
        else {
            lllllllllllIIIIlIIlIlIIllIIlIIIl[lllllllllllIIIIlIIlIlIIllIIlIIII + lllllllllllIIIIlIIlIlIIllIIIIIlI * lllllllllllIIIIlIIlIlIIllIIIIIIl] = lllllllllllIIIIlIIlIlIIlIllllllI;
        }
        return true;
    }
    
    private boolean replaceBiomeEdge(final int[] lllllllllllIIIIlIIlIlIIlIllIIIII, final int[] lllllllllllIIIIlIIlIlIIlIllIlIll, final int lllllllllllIIIIlIIlIlIIlIllIlIlI, final int lllllllllllIIIIlIIlIlIIlIlIlllIl, final int lllllllllllIIIIlIIlIlIIlIllIlIII, final int lllllllllllIIIIlIIlIlIIlIlIllIll, final int lllllllllllIIIIlIIlIlIIlIlIllIlI, final int lllllllllllIIIIlIIlIlIIlIlIllIIl) {
        if (lllllllllllIIIIlIIlIlIIlIlIllIll != lllllllllllIIIIlIIlIlIIlIlIllIlI) {
            return false;
        }
        final int lllllllllllIIIIlIIlIlIIlIllIIlII = lllllllllllIIIIlIIlIlIIlIllIIIII[lllllllllllIIIIlIIlIlIIlIllIlIlI + 1 + (lllllllllllIIIIlIIlIlIIlIlIlllIl + 1 - 1) * (lllllllllllIIIIlIIlIlIIlIllIlIII + 2)];
        final int lllllllllllIIIIlIIlIlIIlIllIIIll = lllllllllllIIIIlIIlIlIIlIllIIIII[lllllllllllIIIIlIIlIlIIlIllIlIlI + 1 + 1 + (lllllllllllIIIIlIIlIlIIlIlIlllIl + 1) * (lllllllllllIIIIlIIlIlIIlIllIlIII + 2)];
        final int lllllllllllIIIIlIIlIlIIlIllIIIlI = lllllllllllIIIIlIIlIlIIlIllIIIII[lllllllllllIIIIlIIlIlIIlIllIlIlI + 1 - 1 + (lllllllllllIIIIlIIlIlIIlIlIlllIl + 1) * (lllllllllllIIIIlIIlIlIIlIllIlIII + 2)];
        final int lllllllllllIIIIlIIlIlIIlIllIIIIl = lllllllllllIIIIlIIlIlIIlIllIIIII[lllllllllllIIIIlIIlIlIIlIllIlIlI + 1 + (lllllllllllIIIIlIIlIlIIlIlIlllIl + 1 + 1) * (lllllllllllIIIIlIIlIlIIlIllIlIII + 2)];
        if (GenLayer.biomesEqualOrMesaPlateau(lllllllllllIIIIlIIlIlIIlIllIIlII, lllllllllllIIIIlIIlIlIIlIlIllIlI) && GenLayer.biomesEqualOrMesaPlateau(lllllllllllIIIIlIIlIlIIlIllIIIll, lllllllllllIIIIlIIlIlIIlIlIllIlI) && GenLayer.biomesEqualOrMesaPlateau(lllllllllllIIIIlIIlIlIIlIllIIIlI, lllllllllllIIIIlIIlIlIIlIlIllIlI) && GenLayer.biomesEqualOrMesaPlateau(lllllllllllIIIIlIIlIlIIlIllIIIIl, lllllllllllIIIIlIIlIlIIlIlIllIlI)) {
            lllllllllllIIIIlIIlIlIIlIllIlIll[lllllllllllIIIIlIIlIlIIlIllIlIlI + lllllllllllIIIIlIIlIlIIlIlIlllIl * lllllllllllIIIIlIIlIlIIlIllIlIII] = lllllllllllIIIIlIIlIlIIlIlIllIll;
        }
        else {
            lllllllllllIIIIlIIlIlIIlIllIlIll[lllllllllllIIIIlIIlIlIIlIllIlIlI + lllllllllllIIIIlIIlIlIIlIlIlllIl * lllllllllllIIIIlIIlIlIIlIllIlIII] = lllllllllllIIIIlIIlIlIIlIlIllIIl;
        }
        return true;
    }
    
    private boolean canBiomesBeNeighbors(final int lllllllllllIIIIlIIlIlIIlIlIIllIl, final int lllllllllllIIIIlIIlIlIIlIlIIllII) {
        if (GenLayer.biomesEqualOrMesaPlateau(lllllllllllIIIIlIIlIlIIlIlIIllIl, lllllllllllIIIIlIIlIlIIlIlIIllII)) {
            return true;
        }
        final Biome lllllllllllIIIIlIIlIlIIlIlIIlIll = Biome.getBiome(lllllllllllIIIIlIIlIlIIlIlIIllIl);
        final Biome lllllllllllIIIIlIIlIlIIlIlIIlIlI = Biome.getBiome(lllllllllllIIIIlIIlIlIIlIlIIllII);
        if (lllllllllllIIIIlIIlIlIIlIlIIlIll != null && lllllllllllIIIIlIIlIlIIlIlIIlIlI != null) {
            final Biome.TempCategory lllllllllllIIIIlIIlIlIIlIlIIlIIl = lllllllllllIIIIlIIlIlIIlIlIIlIll.getTempCategory();
            final Biome.TempCategory lllllllllllIIIIlIIlIlIIlIlIIlIII = lllllllllllIIIIlIIlIlIIlIlIIlIlI.getTempCategory();
            return lllllllllllIIIIlIIlIlIIlIlIIlIIl == lllllllllllIIIIlIIlIlIIlIlIIlIII || lllllllllllIIIIlIIlIlIIlIlIIlIIl == Biome.TempCategory.MEDIUM || lllllllllllIIIIlIIlIlIIlIlIIlIII == Biome.TempCategory.MEDIUM;
        }
        return false;
    }
    
    public GenLayerBiomeEdge(final long lllllllllllIIIIlIIlIlIIlllIlIIII, final GenLayer lllllllllllIIIIlIIlIlIIlllIIllll) {
        super(lllllllllllIIIIlIIlIlIIlllIlIIII);
        this.parent = lllllllllllIIIIlIIlIlIIlllIIllll;
    }
    
    @Override
    public int[] getInts(final int lllllllllllIIIIlIIlIlIIllIlIllIl, final int lllllllllllIIIIlIIlIlIIllIlIllII, final int lllllllllllIIIIlIIlIlIIllIllllIl, final int lllllllllllIIIIlIIlIlIIllIllllII) {
        final int[] lllllllllllIIIIlIIlIlIIllIlllIll = this.parent.getInts(lllllllllllIIIIlIIlIlIIllIlIllIl - 1, lllllllllllIIIIlIIlIlIIllIlIllII - 1, lllllllllllIIIIlIIlIlIIllIllllIl + 2, lllllllllllIIIIlIIlIlIIllIllllII + 2);
        final int[] lllllllllllIIIIlIIlIlIIllIlllIlI = IntCache.getIntCache(lllllllllllIIIIlIIlIlIIllIllllIl * lllllllllllIIIIlIIlIlIIllIllllII);
        for (int lllllllllllIIIIlIIlIlIIllIlllIIl = 0; lllllllllllIIIIlIIlIlIIllIlllIIl < lllllllllllIIIIlIIlIlIIllIllllII; ++lllllllllllIIIIlIIlIlIIllIlllIIl) {
            for (int lllllllllllIIIIlIIlIlIIllIlllIII = 0; lllllllllllIIIIlIIlIlIIllIlllIII < lllllllllllIIIIlIIlIlIIllIllllIl; ++lllllllllllIIIIlIIlIlIIllIlllIII) {
                this.initChunkSeed(lllllllllllIIIIlIIlIlIIllIlllIII + lllllllllllIIIIlIIlIlIIllIlIllIl, lllllllllllIIIIlIIlIlIIllIlllIIl + lllllllllllIIIIlIIlIlIIllIlIllII);
                final int lllllllllllIIIIlIIlIlIIllIllIlll = lllllllllllIIIIlIIlIlIIllIlllIll[lllllllllllIIIIlIIlIlIIllIlllIII + 1 + (lllllllllllIIIIlIIlIlIIllIlllIIl + 1) * (lllllllllllIIIIlIIlIlIIllIllllIl + 2)];
                if (!this.replaceBiomeEdgeIfNecessary(lllllllllllIIIIlIIlIlIIllIlllIll, lllllllllllIIIIlIIlIlIIllIlllIlI, lllllllllllIIIIlIIlIlIIllIlllIII, lllllllllllIIIIlIIlIlIIllIlllIIl, lllllllllllIIIIlIIlIlIIllIllllIl, lllllllllllIIIIlIIlIlIIllIllIlll, Biome.getIdForBiome(Biomes.EXTREME_HILLS), Biome.getIdForBiome(Biomes.EXTREME_HILLS_EDGE)) && !this.replaceBiomeEdge(lllllllllllIIIIlIIlIlIIllIlllIll, lllllllllllIIIIlIIlIlIIllIlllIlI, lllllllllllIIIIlIIlIlIIllIlllIII, lllllllllllIIIIlIIlIlIIllIlllIIl, lllllllllllIIIIlIIlIlIIllIllllIl, lllllllllllIIIIlIIlIlIIllIllIlll, Biome.getIdForBiome(Biomes.MESA_ROCK), Biome.getIdForBiome(Biomes.MESA)) && !this.replaceBiomeEdge(lllllllllllIIIIlIIlIlIIllIlllIll, lllllllllllIIIIlIIlIlIIllIlllIlI, lllllllllllIIIIlIIlIlIIllIlllIII, lllllllllllIIIIlIIlIlIIllIlllIIl, lllllllllllIIIIlIIlIlIIllIllllIl, lllllllllllIIIIlIIlIlIIllIllIlll, Biome.getIdForBiome(Biomes.MESA_CLEAR_ROCK), Biome.getIdForBiome(Biomes.MESA)) && !this.replaceBiomeEdge(lllllllllllIIIIlIIlIlIIllIlllIll, lllllllllllIIIIlIIlIlIIllIlllIlI, lllllllllllIIIIlIIlIlIIllIlllIII, lllllllllllIIIIlIIlIlIIllIlllIIl, lllllllllllIIIIlIIlIlIIllIllllIl, lllllllllllIIIIlIIlIlIIllIllIlll, Biome.getIdForBiome(Biomes.REDWOOD_TAIGA), Biome.getIdForBiome(Biomes.TAIGA))) {
                    if (lllllllllllIIIIlIIlIlIIllIllIlll == Biome.getIdForBiome(Biomes.DESERT)) {
                        final int lllllllllllIIIIlIIlIlIIllIllIllI = lllllllllllIIIIlIIlIlIIllIlllIll[lllllllllllIIIIlIIlIlIIllIlllIII + 1 + (lllllllllllIIIIlIIlIlIIllIlllIIl + 1 - 1) * (lllllllllllIIIIlIIlIlIIllIllllIl + 2)];
                        final int lllllllllllIIIIlIIlIlIIllIllIlIl = lllllllllllIIIIlIIlIlIIllIlllIll[lllllllllllIIIIlIIlIlIIllIlllIII + 1 + 1 + (lllllllllllIIIIlIIlIlIIllIlllIIl + 1) * (lllllllllllIIIIlIIlIlIIllIllllIl + 2)];
                        final int lllllllllllIIIIlIIlIlIIllIllIlII = lllllllllllIIIIlIIlIlIIllIlllIll[lllllllllllIIIIlIIlIlIIllIlllIII + 1 - 1 + (lllllllllllIIIIlIIlIlIIllIlllIIl + 1) * (lllllllllllIIIIlIIlIlIIllIllllIl + 2)];
                        final int lllllllllllIIIIlIIlIlIIllIllIIll = lllllllllllIIIIlIIlIlIIllIlllIll[lllllllllllIIIIlIIlIlIIllIlllIII + 1 + (lllllllllllIIIIlIIlIlIIllIlllIIl + 1 + 1) * (lllllllllllIIIIlIIlIlIIllIllllIl + 2)];
                        if (lllllllllllIIIIlIIlIlIIllIllIllI != Biome.getIdForBiome(Biomes.ICE_PLAINS) && lllllllllllIIIIlIIlIlIIllIllIlIl != Biome.getIdForBiome(Biomes.ICE_PLAINS) && lllllllllllIIIIlIIlIlIIllIllIlII != Biome.getIdForBiome(Biomes.ICE_PLAINS) && lllllllllllIIIIlIIlIlIIllIllIIll != Biome.getIdForBiome(Biomes.ICE_PLAINS)) {
                            lllllllllllIIIIlIIlIlIIllIlllIlI[lllllllllllIIIIlIIlIlIIllIlllIII + lllllllllllIIIIlIIlIlIIllIlllIIl * lllllllllllIIIIlIIlIlIIllIllllIl] = lllllllllllIIIIlIIlIlIIllIllIlll;
                        }
                        else {
                            lllllllllllIIIIlIIlIlIIllIlllIlI[lllllllllllIIIIlIIlIlIIllIlllIII + lllllllllllIIIIlIIlIlIIllIlllIIl * lllllllllllIIIIlIIlIlIIllIllllIl] = Biome.getIdForBiome(Biomes.EXTREME_HILLS_WITH_TREES);
                        }
                    }
                    else if (lllllllllllIIIIlIIlIlIIllIllIlll == Biome.getIdForBiome(Biomes.SWAMPLAND)) {
                        final int lllllllllllIIIIlIIlIlIIllIllIIlI = lllllllllllIIIIlIIlIlIIllIlllIll[lllllllllllIIIIlIIlIlIIllIlllIII + 1 + (lllllllllllIIIIlIIlIlIIllIlllIIl + 1 - 1) * (lllllllllllIIIIlIIlIlIIllIllllIl + 2)];
                        final int lllllllllllIIIIlIIlIlIIllIllIIIl = lllllllllllIIIIlIIlIlIIllIlllIll[lllllllllllIIIIlIIlIlIIllIlllIII + 1 + 1 + (lllllllllllIIIIlIIlIlIIllIlllIIl + 1) * (lllllllllllIIIIlIIlIlIIllIllllIl + 2)];
                        final int lllllllllllIIIIlIIlIlIIllIllIIII = lllllllllllIIIIlIIlIlIIllIlllIll[lllllllllllIIIIlIIlIlIIllIlllIII + 1 - 1 + (lllllllllllIIIIlIIlIlIIllIlllIIl + 1) * (lllllllllllIIIIlIIlIlIIllIllllIl + 2)];
                        final int lllllllllllIIIIlIIlIlIIllIlIllll = lllllllllllIIIIlIIlIlIIllIlllIll[lllllllllllIIIIlIIlIlIIllIlllIII + 1 + (lllllllllllIIIIlIIlIlIIllIlllIIl + 1 + 1) * (lllllllllllIIIIlIIlIlIIllIllllIl + 2)];
                        if (lllllllllllIIIIlIIlIlIIllIllIIlI != Biome.getIdForBiome(Biomes.DESERT) && lllllllllllIIIIlIIlIlIIllIllIIIl != Biome.getIdForBiome(Biomes.DESERT) && lllllllllllIIIIlIIlIlIIllIllIIII != Biome.getIdForBiome(Biomes.DESERT) && lllllllllllIIIIlIIlIlIIllIlIllll != Biome.getIdForBiome(Biomes.DESERT) && lllllllllllIIIIlIIlIlIIllIllIIlI != Biome.getIdForBiome(Biomes.COLD_TAIGA) && lllllllllllIIIIlIIlIlIIllIllIIIl != Biome.getIdForBiome(Biomes.COLD_TAIGA) && lllllllllllIIIIlIIlIlIIllIllIIII != Biome.getIdForBiome(Biomes.COLD_TAIGA) && lllllllllllIIIIlIIlIlIIllIlIllll != Biome.getIdForBiome(Biomes.COLD_TAIGA) && lllllllllllIIIIlIIlIlIIllIllIIlI != Biome.getIdForBiome(Biomes.ICE_PLAINS) && lllllllllllIIIIlIIlIlIIllIllIIIl != Biome.getIdForBiome(Biomes.ICE_PLAINS) && lllllllllllIIIIlIIlIlIIllIllIIII != Biome.getIdForBiome(Biomes.ICE_PLAINS) && lllllllllllIIIIlIIlIlIIllIlIllll != Biome.getIdForBiome(Biomes.ICE_PLAINS)) {
                            if (lllllllllllIIIIlIIlIlIIllIllIIlI != Biome.getIdForBiome(Biomes.JUNGLE) && lllllllllllIIIIlIIlIlIIllIlIllll != Biome.getIdForBiome(Biomes.JUNGLE) && lllllllllllIIIIlIIlIlIIllIllIIIl != Biome.getIdForBiome(Biomes.JUNGLE) && lllllllllllIIIIlIIlIlIIllIllIIII != Biome.getIdForBiome(Biomes.JUNGLE)) {
                                lllllllllllIIIIlIIlIlIIllIlllIlI[lllllllllllIIIIlIIlIlIIllIlllIII + lllllllllllIIIIlIIlIlIIllIlllIIl * lllllllllllIIIIlIIlIlIIllIllllIl] = lllllllllllIIIIlIIlIlIIllIllIlll;
                            }
                            else {
                                lllllllllllIIIIlIIlIlIIllIlllIlI[lllllllllllIIIIlIIlIlIIllIlllIII + lllllllllllIIIIlIIlIlIIllIlllIIl * lllllllllllIIIIlIIlIlIIllIllllIl] = Biome.getIdForBiome(Biomes.JUNGLE_EDGE);
                            }
                        }
                        else {
                            lllllllllllIIIIlIIlIlIIllIlllIlI[lllllllllllIIIIlIIlIlIIllIlllIII + lllllllllllIIIIlIIlIlIIllIlllIIl * lllllllllllIIIIlIIlIlIIllIllllIl] = Biome.getIdForBiome(Biomes.PLAINS);
                        }
                    }
                    else {
                        lllllllllllIIIIlIIlIlIIllIlllIlI[lllllllllllIIIIlIIlIlIIllIlllIII + lllllllllllIIIIlIIlIlIIllIlllIIl * lllllllllllIIIIlIIlIlIIllIllllIl] = lllllllllllIIIIlIIlIlIIllIllIlll;
                    }
                }
            }
        }
        return lllllllllllIIIIlIIlIlIIllIlllIlI;
    }
}
