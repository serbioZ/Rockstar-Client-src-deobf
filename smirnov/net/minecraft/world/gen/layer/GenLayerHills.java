// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import org.apache.logging.log4j.LogManager;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import org.apache.logging.log4j.Logger;

public class GenLayerHills extends GenLayer
{
    private final /* synthetic */ GenLayer riverLayer;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public int[] getInts(final int lllllllllllIlIIllllllIlIIIIllIIl, final int lllllllllllIlIIllllllIlIIIllIIIl, final int lllllllllllIlIIllllllIlIIIIlIlll, final int lllllllllllIlIIllllllIlIIIlIllll) {
        final int[] lllllllllllIlIIllllllIlIIIlIlllI = this.parent.getInts(lllllllllllIlIIllllllIlIIIIllIIl - 1, lllllllllllIlIIllllllIlIIIllIIIl - 1, lllllllllllIlIIllllllIlIIIIlIlll + 2, lllllllllllIlIIllllllIlIIIlIllll + 2);
        final int[] lllllllllllIlIIllllllIlIIIlIllIl = this.riverLayer.getInts(lllllllllllIlIIllllllIlIIIIllIIl - 1, lllllllllllIlIIllllllIlIIIllIIIl - 1, lllllllllllIlIIllllllIlIIIIlIlll + 2, lllllllllllIlIIllllllIlIIIlIllll + 2);
        final int[] lllllllllllIlIIllllllIlIIIlIllII = IntCache.getIntCache(lllllllllllIlIIllllllIlIIIIlIlll * lllllllllllIlIIllllllIlIIIlIllll);
        for (int lllllllllllIlIIllllllIlIIIlIlIll = 0; lllllllllllIlIIllllllIlIIIlIlIll < lllllllllllIlIIllllllIlIIIlIllll; ++lllllllllllIlIIllllllIlIIIlIlIll) {
            for (int lllllllllllIlIIllllllIlIIIlIlIlI = 0; lllllllllllIlIIllllllIlIIIlIlIlI < lllllllllllIlIIllllllIlIIIIlIlll; ++lllllllllllIlIIllllllIlIIIlIlIlI) {
                this.initChunkSeed(lllllllllllIlIIllllllIlIIIlIlIlI + lllllllllllIlIIllllllIlIIIIllIIl, lllllllllllIlIIllllllIlIIIlIlIll + lllllllllllIlIIllllllIlIIIllIIIl);
                final int lllllllllllIlIIllllllIlIIIlIlIIl = lllllllllllIlIIllllllIlIIIlIlllI[lllllllllllIlIIllllllIlIIIlIlIlI + 1 + (lllllllllllIlIIllllllIlIIIlIlIll + 1) * (lllllllllllIlIIllllllIlIIIIlIlll + 2)];
                final int lllllllllllIlIIllllllIlIIIlIlIII = lllllllllllIlIIllllllIlIIIlIllIl[lllllllllllIlIIllllllIlIIIlIlIlI + 1 + (lllllllllllIlIIllllllIlIIIlIlIll + 1) * (lllllllllllIlIIllllllIlIIIIlIlll + 2)];
                final boolean lllllllllllIlIIllllllIlIIIlIIlll = (lllllllllllIlIIllllllIlIIIlIlIII - 2) % 29 == 0;
                if (lllllllllllIlIIllllllIlIIIlIlIIl > 255) {
                    GenLayerHills.LOGGER.debug("old! {}", (Object)lllllllllllIlIIllllllIlIIIlIlIIl);
                }
                final Biome lllllllllllIlIIllllllIlIIIlIIllI = Biome.getBiomeForId(lllllllllllIlIIllllllIlIIIlIlIIl);
                final boolean lllllllllllIlIIllllllIlIIIlIIlIl = lllllllllllIlIIllllllIlIIIlIIllI != null && lllllllllllIlIIllllllIlIIIlIIllI.isMutation();
                if (lllllllllllIlIIllllllIlIIIlIlIIl != 0 && lllllllllllIlIIllllllIlIIIlIlIII >= 2 && (lllllllllllIlIIllllllIlIIIlIlIII - 2) % 29 == 1 && !lllllllllllIlIIllllllIlIIIlIIlIl) {
                    final Biome lllllllllllIlIIllllllIlIIIlIIlII = Biome.getMutationForBiome(lllllllllllIlIIllllllIlIIIlIIllI);
                    lllllllllllIlIIllllllIlIIIlIllII[lllllllllllIlIIllllllIlIIIlIlIlI + lllllllllllIlIIllllllIlIIIlIlIll * lllllllllllIlIIllllllIlIIIIlIlll] = ((lllllllllllIlIIllllllIlIIIlIIlII == null) ? lllllllllllIlIIllllllIlIIIlIlIIl : Biome.getIdForBiome(lllllllllllIlIIllllllIlIIIlIIlII));
                }
                else if (this.nextInt(3) != 0 && !lllllllllllIlIIllllllIlIIIlIIlll) {
                    lllllllllllIlIIllllllIlIIIlIllII[lllllllllllIlIIllllllIlIIIlIlIlI + lllllllllllIlIIllllllIlIIIlIlIll * lllllllllllIlIIllllllIlIIIIlIlll] = lllllllllllIlIIllllllIlIIIlIlIIl;
                }
                else {
                    Biome lllllllllllIlIIllllllIlIIIlIIIll;
                    if ((lllllllllllIlIIllllllIlIIIlIIIll = lllllllllllIlIIllllllIlIIIlIIllI) == Biomes.DESERT) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.DESERT_HILLS;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.FOREST) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.FOREST_HILLS;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.BIRCH_FOREST) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.BIRCH_FOREST_HILLS;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.ROOFED_FOREST) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.PLAINS;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.TAIGA) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.TAIGA_HILLS;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.REDWOOD_TAIGA) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.REDWOOD_TAIGA_HILLS;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.COLD_TAIGA) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.COLD_TAIGA_HILLS;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.PLAINS) {
                        if (this.nextInt(3) == 0) {
                            lllllllllllIlIIllllllIlIIIlIIIll = Biomes.FOREST_HILLS;
                        }
                        else {
                            lllllllllllIlIIllllllIlIIIlIIIll = Biomes.FOREST;
                        }
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.ICE_PLAINS) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.ICE_MOUNTAINS;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.JUNGLE) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.JUNGLE_HILLS;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.OCEAN) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.DEEP_OCEAN;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.EXTREME_HILLS) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.EXTREME_HILLS_WITH_TREES;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.SAVANNA) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.SAVANNA_PLATEAU;
                    }
                    else if (GenLayer.biomesEqualOrMesaPlateau(lllllllllllIlIIllllllIlIIIlIlIIl, Biome.getIdForBiome(Biomes.MESA_ROCK))) {
                        lllllllllllIlIIllllllIlIIIlIIIll = Biomes.MESA;
                    }
                    else if (lllllllllllIlIIllllllIlIIIlIIllI == Biomes.DEEP_OCEAN && this.nextInt(3) == 0) {
                        final int lllllllllllIlIIllllllIlIIIlIIIlI = this.nextInt(2);
                        if (lllllllllllIlIIllllllIlIIIlIIIlI == 0) {
                            lllllllllllIlIIllllllIlIIIlIIIll = Biomes.PLAINS;
                        }
                        else {
                            lllllllllllIlIIllllllIlIIIlIIIll = Biomes.FOREST;
                        }
                    }
                    int lllllllllllIlIIllllllIlIIIlIIIIl = Biome.getIdForBiome(lllllllllllIlIIllllllIlIIIlIIIll);
                    if (lllllllllllIlIIllllllIlIIIlIIlll && lllllllllllIlIIllllllIlIIIlIIIIl != lllllllllllIlIIllllllIlIIIlIlIIl) {
                        final Biome lllllllllllIlIIllllllIlIIIlIIIII = Biome.getMutationForBiome(lllllllllllIlIIllllllIlIIIlIIIll);
                        lllllllllllIlIIllllllIlIIIlIIIIl = ((lllllllllllIlIIllllllIlIIIlIIIII == null) ? lllllllllllIlIIllllllIlIIIlIlIIl : Biome.getIdForBiome(lllllllllllIlIIllllllIlIIIlIIIII));
                    }
                    if (lllllllllllIlIIllllllIlIIIlIIIIl == lllllllllllIlIIllllllIlIIIlIlIIl) {
                        lllllllllllIlIIllllllIlIIIlIllII[lllllllllllIlIIllllllIlIIIlIlIlI + lllllllllllIlIIllllllIlIIIlIlIll * lllllllllllIlIIllllllIlIIIIlIlll] = lllllllllllIlIIllllllIlIIIlIlIIl;
                    }
                    else {
                        final int lllllllllllIlIIllllllIlIIIIlllll = lllllllllllIlIIllllllIlIIIlIlllI[lllllllllllIlIIllllllIlIIIlIlIlI + 1 + (lllllllllllIlIIllllllIlIIIlIlIll + 0) * (lllllllllllIlIIllllllIlIIIIlIlll + 2)];
                        final int lllllllllllIlIIllllllIlIIIIllllI = lllllllllllIlIIllllllIlIIIlIlllI[lllllllllllIlIIllllllIlIIIlIlIlI + 2 + (lllllllllllIlIIllllllIlIIIlIlIll + 1) * (lllllllllllIlIIllllllIlIIIIlIlll + 2)];
                        final int lllllllllllIlIIllllllIlIIIIlllIl = lllllllllllIlIIllllllIlIIIlIlllI[lllllllllllIlIIllllllIlIIIlIlIlI + 0 + (lllllllllllIlIIllllllIlIIIlIlIll + 1) * (lllllllllllIlIIllllllIlIIIIlIlll + 2)];
                        final int lllllllllllIlIIllllllIlIIIIlllII = lllllllllllIlIIllllllIlIIIlIlllI[lllllllllllIlIIllllllIlIIIlIlIlI + 1 + (lllllllllllIlIIllllllIlIIIlIlIll + 2) * (lllllllllllIlIIllllllIlIIIIlIlll + 2)];
                        int lllllllllllIlIIllllllIlIIIIllIll = 0;
                        if (GenLayer.biomesEqualOrMesaPlateau(lllllllllllIlIIllllllIlIIIIlllll, lllllllllllIlIIllllllIlIIIlIlIIl)) {
                            ++lllllllllllIlIIllllllIlIIIIllIll;
                        }
                        if (GenLayer.biomesEqualOrMesaPlateau(lllllllllllIlIIllllllIlIIIIllllI, lllllllllllIlIIllllllIlIIIlIlIIl)) {
                            ++lllllllllllIlIIllllllIlIIIIllIll;
                        }
                        if (GenLayer.biomesEqualOrMesaPlateau(lllllllllllIlIIllllllIlIIIIlllIl, lllllllllllIlIIllllllIlIIIlIlIIl)) {
                            ++lllllllllllIlIIllllllIlIIIIllIll;
                        }
                        if (GenLayer.biomesEqualOrMesaPlateau(lllllllllllIlIIllllllIlIIIIlllII, lllllllllllIlIIllllllIlIIIlIlIIl)) {
                            ++lllllllllllIlIIllllllIlIIIIllIll;
                        }
                        if (lllllllllllIlIIllllllIlIIIIllIll >= 3) {
                            lllllllllllIlIIllllllIlIIIlIllII[lllllllllllIlIIllllllIlIIIlIlIlI + lllllllllllIlIIllllllIlIIIlIlIll * lllllllllllIlIIllllllIlIIIIlIlll] = lllllllllllIlIIllllllIlIIIlIIIIl;
                        }
                        else {
                            lllllllllllIlIIllllllIlIIIlIllII[lllllllllllIlIIllllllIlIIIlIlIlI + lllllllllllIlIIllllllIlIIIlIlIll * lllllllllllIlIIllllllIlIIIIlIlll] = lllllllllllIlIIllllllIlIIIlIlIIl;
                        }
                    }
                }
            }
        }
        return lllllllllllIlIIllllllIlIIIlIllII;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public GenLayerHills(final long lllllllllllIlIIllllllIlIIlIIllII, final GenLayer lllllllllllIlIIllllllIlIIlIIllll, final GenLayer lllllllllllIlIIllllllIlIIlIIlllI) {
        super(lllllllllllIlIIllllllIlIIlIIllII);
        this.parent = lllllllllllIlIIllllllIlIIlIIllll;
        this.riverLayer = lllllllllllIlIIllllllIlIIlIIlllI;
    }
}
