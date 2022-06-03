// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.WorldType;

public abstract class GenLayer
{
    private /* synthetic */ long worldGenSeed;
    protected /* synthetic */ long baseSeed;
    private /* synthetic */ long chunkSeed;
    protected /* synthetic */ GenLayer parent;
    
    public void initWorldGenSeed(final long lllllllllllllIIllIlIIIlIlllIllIl) {
        this.worldGenSeed = lllllllllllllIIllIlIIIlIlllIllIl;
        if (this.parent != null) {
            this.parent.initWorldGenSeed(lllllllllllllIIllIlIIIlIlllIllIl);
        }
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
    }
    
    public static GenLayer[] initializeAllBiomeGenerators(final long lllllllllllllIIllIlIIIllIIllIlIl, final WorldType lllllllllllllIIllIlIIIllIIllIlII, final ChunkGeneratorSettings lllllllllllllIIllIlIIIllIIIlIIll) {
        GenLayer lllllllllllllIIllIlIIIllIIllIIlI = new GenLayerIsland(1L);
        lllllllllllllIIllIlIIIllIIllIIlI = new GenLayerFuzzyZoom(2000L, lllllllllllllIIllIlIIIllIIllIIlI);
        final GenLayer lllllllllllllIIllIlIIIllIIllIIIl = new GenLayerAddIsland(1L, lllllllllllllIIllIlIIIllIIllIIlI);
        final GenLayer lllllllllllllIIllIlIIIllIIllIIII = new GenLayerZoom(2001L, lllllllllllllIIllIlIIIllIIllIIIl);
        GenLayer lllllllllllllIIllIlIIIllIIlIllll = new GenLayerAddIsland(2L, lllllllllllllIIllIlIIIllIIllIIII);
        lllllllllllllIIllIlIIIllIIlIllll = new GenLayerAddIsland(50L, lllllllllllllIIllIlIIIllIIlIllll);
        lllllllllllllIIllIlIIIllIIlIllll = new GenLayerAddIsland(70L, lllllllllllllIIllIlIIIllIIlIllll);
        final GenLayer lllllllllllllIIllIlIIIllIIlIlllI = new GenLayerRemoveTooMuchOcean(2L, lllllllllllllIIllIlIIIllIIlIllll);
        final GenLayer lllllllllllllIIllIlIIIllIIlIllIl = new GenLayerAddSnow(2L, lllllllllllllIIllIlIIIllIIlIlllI);
        final GenLayer lllllllllllllIIllIlIIIllIIlIllII = new GenLayerAddIsland(3L, lllllllllllllIIllIlIIIllIIlIllIl);
        GenLayer lllllllllllllIIllIlIIIllIIlIlIll = new GenLayerEdge(2L, lllllllllllllIIllIlIIIllIIlIllII, GenLayerEdge.Mode.COOL_WARM);
        lllllllllllllIIllIlIIIllIIlIlIll = new GenLayerEdge(2L, lllllllllllllIIllIlIIIllIIlIlIll, GenLayerEdge.Mode.HEAT_ICE);
        lllllllllllllIIllIlIIIllIIlIlIll = new GenLayerEdge(3L, lllllllllllllIIllIlIIIllIIlIlIll, GenLayerEdge.Mode.SPECIAL);
        GenLayer lllllllllllllIIllIlIIIllIIlIlIlI = new GenLayerZoom(2002L, lllllllllllllIIllIlIIIllIIlIlIll);
        lllllllllllllIIllIlIIIllIIlIlIlI = new GenLayerZoom(2003L, lllllllllllllIIllIlIIIllIIlIlIlI);
        final GenLayer lllllllllllllIIllIlIIIllIIlIlIIl = new GenLayerAddIsland(4L, lllllllllllllIIllIlIIIllIIlIlIlI);
        final GenLayer lllllllllllllIIllIlIIIllIIlIlIII = new GenLayerAddMushroomIsland(5L, lllllllllllllIIllIlIIIllIIlIlIIl);
        final GenLayer lllllllllllllIIllIlIIIllIIlIIlll = new GenLayerDeepOcean(4L, lllllllllllllIIllIlIIIllIIlIlIII);
        final GenLayer lllllllllllllIIllIlIIIllIIlIIllI = GenLayerZoom.magnify(1000L, lllllllllllllIIllIlIIIllIIlIIlll, 0);
        int lllllllllllllIIllIlIIIllIIlIIlII;
        int lllllllllllllIIllIlIIIllIIlIIlIl = lllllllllllllIIllIlIIIllIIlIIlII = 4;
        if (lllllllllllllIIllIlIIIllIIIlIIll != null) {
            lllllllllllllIIllIlIIIllIIlIIlIl = lllllllllllllIIllIlIIIllIIIlIIll.biomeSize;
            lllllllllllllIIllIlIIIllIIlIIlII = lllllllllllllIIllIlIIIllIIIlIIll.riverSize;
        }
        if (lllllllllllllIIllIlIIIllIIllIlII == WorldType.LARGE_BIOMES) {
            lllllllllllllIIllIlIIIllIIlIIlIl = 6;
        }
        final GenLayer lllllllllllllIIllIlIIIllIIlIIIll = GenLayerZoom.magnify(1000L, lllllllllllllIIllIlIIIllIIlIIllI, 0);
        final GenLayer lllllllllllllIIllIlIIIllIIlIIIlI = new GenLayerRiverInit(100L, lllllllllllllIIllIlIIIllIIlIIIll);
        final GenLayer lllllllllllllIIllIlIIIllIIlIIIIl = new GenLayerBiome(200L, lllllllllllllIIllIlIIIllIIlIIllI, lllllllllllllIIllIlIIIllIIllIlII, lllllllllllllIIllIlIIIllIIIlIIll);
        final GenLayer lllllllllllllIIllIlIIIllIIlIIIII = GenLayerZoom.magnify(1000L, lllllllllllllIIllIlIIIllIIlIIIIl, 2);
        final GenLayer lllllllllllllIIllIlIIIllIIIlllll = new GenLayerBiomeEdge(1000L, lllllllllllllIIllIlIIIllIIlIIIII);
        final GenLayer lllllllllllllIIllIlIIIllIIIllllI = GenLayerZoom.magnify(1000L, lllllllllllllIIllIlIIIllIIlIIIlI, 2);
        GenLayer lllllllllllllIIllIlIIIllIIIlllIl = new GenLayerHills(1000L, lllllllllllllIIllIlIIIllIIIlllll, lllllllllllllIIllIlIIIllIIIllllI);
        GenLayer lllllllllllllIIllIlIIIllIIIlllII = GenLayerZoom.magnify(1000L, lllllllllllllIIllIlIIIllIIlIIIlI, 2);
        lllllllllllllIIllIlIIIllIIIlllII = GenLayerZoom.magnify(1000L, lllllllllllllIIllIlIIIllIIIlllII, lllllllllllllIIllIlIIIllIIlIIlII);
        final GenLayer lllllllllllllIIllIlIIIllIIIllIll = new GenLayerRiver(1L, lllllllllllllIIllIlIIIllIIIlllII);
        final GenLayer lllllllllllllIIllIlIIIllIIIllIlI = new GenLayerSmooth(1000L, lllllllllllllIIllIlIIIllIIIllIll);
        lllllllllllllIIllIlIIIllIIIlllIl = new GenLayerRareBiome(1001L, lllllllllllllIIllIlIIIllIIIlllIl);
        for (int lllllllllllllIIllIlIIIllIIIllIIl = 0; lllllllllllllIIllIlIIIllIIIllIIl < lllllllllllllIIllIlIIIllIIlIIlIl; ++lllllllllllllIIllIlIIIllIIIllIIl) {
            lllllllllllllIIllIlIIIllIIIlllIl = new GenLayerZoom(1000 + lllllllllllllIIllIlIIIllIIIllIIl, lllllllllllllIIllIlIIIllIIIlllIl);
            if (lllllllllllllIIllIlIIIllIIIllIIl == 0) {
                lllllllllllllIIllIlIIIllIIIlllIl = new GenLayerAddIsland(3L, lllllllllllllIIllIlIIIllIIIlllIl);
            }
            if (lllllllllllllIIllIlIIIllIIIllIIl == 1 || lllllllllllllIIllIlIIIllIIlIIlIl == 1) {
                lllllllllllllIIllIlIIIllIIIlllIl = new GenLayerShore(1000L, lllllllllllllIIllIlIIIllIIIlllIl);
            }
        }
        final GenLayer lllllllllllllIIllIlIIIllIIIllIII = new GenLayerSmooth(1000L, lllllllllllllIIllIlIIIllIIIlllIl);
        final GenLayer lllllllllllllIIllIlIIIllIIIlIlll = new GenLayerRiverMix(100L, lllllllllllllIIllIlIIIllIIIllIII, lllllllllllllIIllIlIIIllIIIllIlI);
        final GenLayer lllllllllllllIIllIlIIIllIIIlIllI = new GenLayerVoronoiZoom(10L, lllllllllllllIIllIlIIIllIIIlIlll);
        lllllllllllllIIllIlIIIllIIIlIlll.initWorldGenSeed(lllllllllllllIIllIlIIIllIIllIlIl);
        lllllllllllllIIllIlIIIllIIIlIllI.initWorldGenSeed(lllllllllllllIIllIlIIIllIIllIlIl);
        return new GenLayer[] { lllllllllllllIIllIlIIIllIIIlIlll, lllllllllllllIIllIlIIIllIIIlIllI, lllllllllllllIIllIlIIIllIIIlIlll };
    }
    
    protected int selectRandom(final int... lllllllllllllIIllIlIIIlIllIIIIll) {
        return lllllllllllllIIllIlIIIlIllIIIIll[this.nextInt(lllllllllllllIIllIlIIIlIllIIIIll.length)];
    }
    
    protected static boolean biomesEqualOrMesaPlateau(final int lllllllllllllIIllIlIIIlIllIlIIII, final int lllllllllllllIIllIlIIIlIllIIllll) {
        if (lllllllllllllIIllIlIIIlIllIlIIII == lllllllllllllIIllIlIIIlIllIIllll) {
            return true;
        }
        final Biome lllllllllllllIIllIlIIIlIllIlIIlI = Biome.getBiome(lllllllllllllIIllIlIIIlIllIlIIII);
        final Biome lllllllllllllIIllIlIIIlIllIlIIIl = Biome.getBiome(lllllllllllllIIllIlIIIlIllIIllll);
        if (lllllllllllllIIllIlIIIlIllIlIIlI == null || lllllllllllllIIllIlIIIlIllIlIIIl == null) {
            return false;
        }
        if (lllllllllllllIIllIlIIIlIllIlIIlI != Biomes.MESA_ROCK && lllllllllllllIIllIlIIIlIllIlIIlI != Biomes.MESA_CLEAR_ROCK) {
            return lllllllllllllIIllIlIIIlIllIlIIlI == lllllllllllllIIllIlIIIlIllIlIIIl || lllllllllllllIIllIlIIIlIllIlIIlI.getBiomeClass() == lllllllllllllIIllIlIIIlIllIlIIIl.getBiomeClass();
        }
        return lllllllllllllIIllIlIIIlIllIlIIIl == Biomes.MESA_ROCK || lllllllllllllIIllIlIIIlIllIlIIIl == Biomes.MESA_CLEAR_ROCK;
    }
    
    protected static boolean isBiomeOceanic(final int lllllllllllllIIllIlIIIlIllIIlIlI) {
        final Biome lllllllllllllIIllIlIIIlIllIIlIIl = Biome.getBiome(lllllllllllllIIllIlIIIlIllIIlIlI);
        return lllllllllllllIIllIlIIIlIllIIlIIl == Biomes.OCEAN || lllllllllllllIIllIlIIIlIllIIlIIl == Biomes.DEEP_OCEAN || lllllllllllllIIllIlIIIlIllIIlIIl == Biomes.FROZEN_OCEAN;
    }
    
    public abstract int[] getInts(final int p0, final int p1, final int p2, final int p3);
    
    protected int nextInt(final int lllllllllllllIIllIlIIIlIllIllIlI) {
        int lllllllllllllIIllIlIIIlIllIlllII = (int)((this.chunkSeed >> 24) % lllllllllllllIIllIlIIIlIllIllIlI);
        if (lllllllllllllIIllIlIIIlIllIlllII < 0) {
            lllllllllllllIIllIlIIIlIllIlllII += lllllllllllllIIllIlIIIlIllIllIlI;
        }
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += this.worldGenSeed;
        return lllllllllllllIIllIlIIIlIllIlllII;
    }
    
    protected int selectModeOrRandom(final int lllllllllllllIIllIlIIIlIlIlllIlI, final int lllllllllllllIIllIlIIIlIlIllIlII, final int lllllllllllllIIllIlIIIlIlIlllIII, final int lllllllllllllIIllIlIIIlIlIllIlll) {
        if (lllllllllllllIIllIlIIIlIlIllIlII == lllllllllllllIIllIlIIIlIlIlllIII && lllllllllllllIIllIlIIIlIlIlllIII == lllllllllllllIIllIlIIIlIlIllIlll) {
            return lllllllllllllIIllIlIIIlIlIllIlII;
        }
        if (lllllllllllllIIllIlIIIlIlIlllIlI == lllllllllllllIIllIlIIIlIlIllIlII && lllllllllllllIIllIlIIIlIlIlllIlI == lllllllllllllIIllIlIIIlIlIlllIII) {
            return lllllllllllllIIllIlIIIlIlIlllIlI;
        }
        if (lllllllllllllIIllIlIIIlIlIlllIlI == lllllllllllllIIllIlIIIlIlIllIlII && lllllllllllllIIllIlIIIlIlIlllIlI == lllllllllllllIIllIlIIIlIlIllIlll) {
            return lllllllllllllIIllIlIIIlIlIlllIlI;
        }
        if (lllllllllllllIIllIlIIIlIlIlllIlI == lllllllllllllIIllIlIIIlIlIlllIII && lllllllllllllIIllIlIIIlIlIlllIlI == lllllllllllllIIllIlIIIlIlIllIlll) {
            return lllllllllllllIIllIlIIIlIlIlllIlI;
        }
        if (lllllllllllllIIllIlIIIlIlIlllIlI == lllllllllllllIIllIlIIIlIlIllIlII && lllllllllllllIIllIlIIIlIlIlllIII != lllllllllllllIIllIlIIIlIlIllIlll) {
            return lllllllllllllIIllIlIIIlIlIlllIlI;
        }
        if (lllllllllllllIIllIlIIIlIlIlllIlI == lllllllllllllIIllIlIIIlIlIlllIII && lllllllllllllIIllIlIIIlIlIllIlII != lllllllllllllIIllIlIIIlIlIllIlll) {
            return lllllllllllllIIllIlIIIlIlIlllIlI;
        }
        if (lllllllllllllIIllIlIIIlIlIlllIlI == lllllllllllllIIllIlIIIlIlIllIlll && lllllllllllllIIllIlIIIlIlIllIlII != lllllllllllllIIllIlIIIlIlIlllIII) {
            return lllllllllllllIIllIlIIIlIlIlllIlI;
        }
        if (lllllllllllllIIllIlIIIlIlIllIlII == lllllllllllllIIllIlIIIlIlIlllIII && lllllllllllllIIllIlIIIlIlIlllIlI != lllllllllllllIIllIlIIIlIlIllIlll) {
            return lllllllllllllIIllIlIIIlIlIllIlII;
        }
        if (lllllllllllllIIllIlIIIlIlIllIlII == lllllllllllllIIllIlIIIlIlIllIlll && lllllllllllllIIllIlIIIlIlIlllIlI != lllllllllllllIIllIlIIIlIlIlllIII) {
            return lllllllllllllIIllIlIIIlIlIllIlII;
        }
        return (lllllllllllllIIllIlIIIlIlIlllIII == lllllllllllllIIllIlIIIlIlIllIlll && lllllllllllllIIllIlIIIlIlIlllIlI != lllllllllllllIIllIlIIIlIlIllIlII) ? lllllllllllllIIllIlIIIlIlIlllIII : this.selectRandom(lllllllllllllIIllIlIIIlIlIlllIlI, lllllllllllllIIllIlIIIlIlIllIlII, lllllllllllllIIllIlIIIlIlIlllIII, lllllllllllllIIllIlIIIlIlIllIlll);
    }
    
    public void initChunkSeed(final long lllllllllllllIIllIlIIIlIlllIIIll, final long lllllllllllllIIllIlIIIlIlllIIlIl) {
        this.chunkSeed = this.worldGenSeed;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllllllllllllIIllIlIIIlIlllIIIll;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllllllllllllIIllIlIIIlIlllIIlIl;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllllllllllllIIllIlIIIlIlllIIIll;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllllllllllllIIllIlIIIlIlllIIlIl;
    }
    
    public GenLayer(final long lllllllllllllIIllIlIIIlIllllIIIl) {
        this.baseSeed = lllllllllllllIIllIlIIIlIllllIIIl;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += lllllllllllllIIllIlIIIlIllllIIIl;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += lllllllllllllIIllIlIIIlIllllIIIl;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += lllllllllllllIIllIlIIIlIllllIIIl;
    }
}
