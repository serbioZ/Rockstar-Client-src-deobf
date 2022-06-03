// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeMesa;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.BiomeJungle;
import net.minecraft.world.biome.Biome;

public class GenLayerShore extends GenLayer
{
    public GenLayerShore(final long lllllllllllIIIllIllIIIIIlllllIIl, final GenLayer lllllllllllIIIllIllIIIIIllllIlIl) {
        super(lllllllllllIIIllIllIIIIIlllllIIl);
        this.parent = lllllllllllIIIllIllIIIIIllllIlIl;
    }
    
    private boolean isJungleCompatible(final int lllllllllllIIIllIllIIIIIlIIlIlll) {
        return (Biome.getBiome(lllllllllllIIIllIllIIIIIlIIlIlll) != null && Biome.getBiome(lllllllllllIIIllIllIIIIIlIIlIlll).getBiomeClass() == BiomeJungle.class) || lllllllllllIIIllIllIIIIIlIIlIlll == Biome.getIdForBiome(Biomes.JUNGLE_EDGE) || lllllllllllIIIllIllIIIIIlIIlIlll == Biome.getIdForBiome(Biomes.JUNGLE) || lllllllllllIIIllIllIIIIIlIIlIlll == Biome.getIdForBiome(Biomes.JUNGLE_HILLS) || lllllllllllIIIllIllIIIIIlIIlIlll == Biome.getIdForBiome(Biomes.FOREST) || lllllllllllIIIllIllIIIIIlIIlIlll == Biome.getIdForBiome(Biomes.TAIGA) || GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIlIIlIlll);
    }
    
    private void replaceIfNeighborOcean(final int[] lllllllllllIIIllIllIIIIIlIlIllll, final int[] lllllllllllIIIllIllIIIIIlIlIlllI, final int lllllllllllIIIllIllIIIIIlIlIllIl, final int lllllllllllIIIllIllIIIIIlIlIllII, final int lllllllllllIIIllIllIIIIIlIlIIIII, final int lllllllllllIIIllIllIIIIIlIlIlIlI, final int lllllllllllIIIllIllIIIIIlIlIlIIl) {
        if (GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIlIlIlIlI)) {
            lllllllllllIIIllIllIIIIIlIlIlllI[lllllllllllIIIllIllIIIIIlIlIllIl + lllllllllllIIIllIllIIIIIlIlIllII * lllllllllllIIIllIllIIIIIlIlIIIII] = lllllllllllIIIllIllIIIIIlIlIlIlI;
        }
        else {
            final int lllllllllllIIIllIllIIIIIlIlIlIII = lllllllllllIIIllIllIIIIIlIlIllll[lllllllllllIIIllIllIIIIIlIlIllIl + 1 + (lllllllllllIIIllIllIIIIIlIlIllII + 1 - 1) * (lllllllllllIIIllIllIIIIIlIlIIIII + 2)];
            final int lllllllllllIIIllIllIIIIIlIlIIlll = lllllllllllIIIllIllIIIIIlIlIllll[lllllllllllIIIllIllIIIIIlIlIllIl + 1 + 1 + (lllllllllllIIIllIllIIIIIlIlIllII + 1) * (lllllllllllIIIllIllIIIIIlIlIIIII + 2)];
            final int lllllllllllIIIllIllIIIIIlIlIIllI = lllllllllllIIIllIllIIIIIlIlIllll[lllllllllllIIIllIllIIIIIlIlIllIl + 1 - 1 + (lllllllllllIIIllIllIIIIIlIlIllII + 1) * (lllllllllllIIIllIllIIIIIlIlIIIII + 2)];
            final int lllllllllllIIIllIllIIIIIlIlIIlIl = lllllllllllIIIllIllIIIIIlIlIllll[lllllllllllIIIllIllIIIIIlIlIllIl + 1 + (lllllllllllIIIllIllIIIIIlIlIllII + 1 + 1) * (lllllllllllIIIllIllIIIIIlIlIIIII + 2)];
            if (!GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIlIlIlIII) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIlIlIIlll) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIlIlIIllI) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIlIlIIlIl)) {
                lllllllllllIIIllIllIIIIIlIlIlllI[lllllllllllIIIllIllIIIIIlIlIllIl + lllllllllllIIIllIllIIIIIlIlIllII * lllllllllllIIIllIllIIIIIlIlIIIII] = lllllllllllIIIllIllIIIIIlIlIlIlI;
            }
            else {
                lllllllllllIIIllIllIIIIIlIlIlllI[lllllllllllIIIllIllIIIIIlIlIllIl + lllllllllllIIIllIllIIIIIlIlIllII * lllllllllllIIIllIllIIIIIlIlIIIII] = lllllllllllIIIllIllIIIIIlIlIlIIl;
            }
        }
    }
    
    private boolean isMesa(final int lllllllllllIIIllIllIIIIIlIIlIIll) {
        return Biome.getBiome(lllllllllllIIIllIllIIIIIlIIlIIll) instanceof BiomeMesa;
    }
    
    @Override
    public int[] getInts(final int lllllllllllIIIllIllIIIIIlllIIlII, final int lllllllllllIIIllIllIIIIIllIIlIII, final int lllllllllllIIIllIllIIIIIlllIIIlI, final int lllllllllllIIIllIllIIIIIllIIIllI) {
        final int[] lllllllllllIIIllIllIIIIIlllIIIII = this.parent.getInts(lllllllllllIIIllIllIIIIIlllIIlII - 1, lllllllllllIIIllIllIIIIIllIIlIII - 1, lllllllllllIIIllIllIIIIIlllIIIlI + 2, lllllllllllIIIllIllIIIIIllIIIllI + 2);
        final int[] lllllllllllIIIllIllIIIIIllIlllll = IntCache.getIntCache(lllllllllllIIIllIllIIIIIlllIIIlI * lllllllllllIIIllIllIIIIIllIIIllI);
        for (int lllllllllllIIIllIllIIIIIllIllllI = 0; lllllllllllIIIllIllIIIIIllIllllI < lllllllllllIIIllIllIIIIIllIIIllI; ++lllllllllllIIIllIllIIIIIllIllllI) {
            for (int lllllllllllIIIllIllIIIIIllIlllIl = 0; lllllllllllIIIllIllIIIIIllIlllIl < lllllllllllIIIllIllIIIIIlllIIIlI; ++lllllllllllIIIllIllIIIIIllIlllIl) {
                this.initChunkSeed(lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIlllIIlII, lllllllllllIIIllIllIIIIIllIllllI + lllllllllllIIIllIllIIIIIllIIlIII);
                final int lllllllllllIIIllIllIIIIIllIlllII = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                final Biome lllllllllllIIIllIllIIIIIllIllIll = Biome.getBiome(lllllllllllIIIllIllIIIIIllIlllII);
                if (lllllllllllIIIllIllIIIIIllIlllII == Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND)) {
                    final int lllllllllllIIIllIllIIIIIllIllIlI = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1 - 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                    final int lllllllllllIIIllIllIIIIIllIllIIl = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                    final int lllllllllllIIIllIllIIIIIllIllIII = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 - 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                    final int lllllllllllIIIllIllIIIIIllIlIlll = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1 + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                    if (lllllllllllIIIllIllIIIIIllIllIlI != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllIIIllIllIIIIIllIllIIl != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllIIIllIllIIIIIllIllIII != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllIIIllIllIIIIIllIlIlll != Biome.getIdForBiome(Biomes.OCEAN)) {
                        lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = lllllllllllIIIllIllIIIIIllIlllII;
                    }
                    else {
                        lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND_SHORE);
                    }
                }
                else if (lllllllllllIIIllIllIIIIIllIllIll != null && lllllllllllIIIllIllIIIIIllIllIll.getBiomeClass() == BiomeJungle.class) {
                    final int lllllllllllIIIllIllIIIIIllIlIllI = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1 - 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                    final int lllllllllllIIIllIllIIIIIllIlIlIl = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                    final int lllllllllllIIIllIllIIIIIllIlIlII = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 - 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                    final int lllllllllllIIIllIllIIIIIllIlIIll = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1 + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                    if (this.isJungleCompatible(lllllllllllIIIllIllIIIIIllIlIllI) && this.isJungleCompatible(lllllllllllIIIllIllIIIIIllIlIlIl) && this.isJungleCompatible(lllllllllllIIIllIllIIIIIllIlIlII) && this.isJungleCompatible(lllllllllllIIIllIllIIIIIllIlIIll)) {
                        if (!GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIlIllI) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIlIlIl) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIlIlII) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIlIIll)) {
                            lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = lllllllllllIIIllIllIIIIIllIlllII;
                        }
                        else {
                            lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = Biome.getIdForBiome(Biomes.BEACH);
                        }
                    }
                    else {
                        lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = Biome.getIdForBiome(Biomes.JUNGLE_EDGE);
                    }
                }
                else if (lllllllllllIIIllIllIIIIIllIlllII != Biome.getIdForBiome(Biomes.EXTREME_HILLS) && lllllllllllIIIllIllIIIIIllIlllII != Biome.getIdForBiome(Biomes.EXTREME_HILLS_WITH_TREES) && lllllllllllIIIllIllIIIIIllIlllII != Biome.getIdForBiome(Biomes.EXTREME_HILLS_EDGE)) {
                    if (lllllllllllIIIllIllIIIIIllIllIll != null && lllllllllllIIIllIllIIIIIllIllIll.isSnowyBiome()) {
                        this.replaceIfNeighborOcean(lllllllllllIIIllIllIIIIIlllIIIII, lllllllllllIIIllIllIIIIIllIlllll, lllllllllllIIIllIllIIIIIllIlllIl, lllllllllllIIIllIllIIIIIllIllllI, lllllllllllIIIllIllIIIIIlllIIIlI, lllllllllllIIIllIllIIIIIllIlllII, Biome.getIdForBiome(Biomes.COLD_BEACH));
                    }
                    else if (lllllllllllIIIllIllIIIIIllIlllII != Biome.getIdForBiome(Biomes.MESA) && lllllllllllIIIllIllIIIIIllIlllII != Biome.getIdForBiome(Biomes.MESA_ROCK)) {
                        if (lllllllllllIIIllIllIIIIIllIlllII != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllIIIllIllIIIIIllIlllII != Biome.getIdForBiome(Biomes.DEEP_OCEAN) && lllllllllllIIIllIllIIIIIllIlllII != Biome.getIdForBiome(Biomes.RIVER) && lllllllllllIIIllIllIIIIIllIlllII != Biome.getIdForBiome(Biomes.SWAMPLAND)) {
                            final int lllllllllllIIIllIllIIIIIllIlIIlI = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1 - 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                            final int lllllllllllIIIllIllIIIIIllIlIIIl = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                            final int lllllllllllIIIllIllIIIIIllIlIIII = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 - 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                            final int lllllllllllIIIllIllIIIIIllIIllll = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1 + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                            if (!GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIlIIlI) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIlIIIl) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIlIIII) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIIllll)) {
                                lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = lllllllllllIIIllIllIIIIIllIlllII;
                            }
                            else {
                                lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = Biome.getIdForBiome(Biomes.BEACH);
                            }
                        }
                        else {
                            lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = lllllllllllIIIllIllIIIIIllIlllII;
                        }
                    }
                    else {
                        final int lllllllllllIIIllIllIIIIIllIIlllI = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1 - 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                        final int lllllllllllIIIllIllIIIIIllIIllIl = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                        final int lllllllllllIIIllIllIIIIIllIIllII = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 - 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                        final int lllllllllllIIIllIllIIIIIllIIlIll = lllllllllllIIIllIllIIIIIlllIIIII[lllllllllllIIIllIllIIIIIllIlllIl + 1 + (lllllllllllIIIllIllIIIIIllIllllI + 1 + 1) * (lllllllllllIIIllIllIIIIIlllIIIlI + 2)];
                        if (!GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIIlllI) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIIllIl) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIIllII) && !GenLayer.isBiomeOceanic(lllllllllllIIIllIllIIIIIllIIlIll)) {
                            if (this.isMesa(lllllllllllIIIllIllIIIIIllIIlllI) && this.isMesa(lllllllllllIIIllIllIIIIIllIIllIl) && this.isMesa(lllllllllllIIIllIllIIIIIllIIllII) && this.isMesa(lllllllllllIIIllIllIIIIIllIIlIll)) {
                                lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = lllllllllllIIIllIllIIIIIllIlllII;
                            }
                            else {
                                lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = Biome.getIdForBiome(Biomes.DESERT);
                            }
                        }
                        else {
                            lllllllllllIIIllIllIIIIIllIlllll[lllllllllllIIIllIllIIIIIllIlllIl + lllllllllllIIIllIllIIIIIllIllllI * lllllllllllIIIllIllIIIIIlllIIIlI] = lllllllllllIIIllIllIIIIIllIlllII;
                        }
                    }
                }
                else {
                    this.replaceIfNeighborOcean(lllllllllllIIIllIllIIIIIlllIIIII, lllllllllllIIIllIllIIIIIllIlllll, lllllllllllIIIllIllIIIIIllIlllIl, lllllllllllIIIllIllIIIIIllIllllI, lllllllllllIIIllIllIIIIIlllIIIlI, lllllllllllIIIllIllIIIIIllIlllII, Biome.getIdForBiome(Biomes.STONE_BEACH));
                }
            }
        }
        return lllllllllllIIIllIllIIIIIllIlllll;
    }
}
