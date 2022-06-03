// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;

public class GenLayerRiverMix extends GenLayer
{
    private final /* synthetic */ GenLayer biomePatternGeneratorChain;
    private final /* synthetic */ GenLayer riverPatternGeneratorChain;
    
    @Override
    public int[] getInts(final int lllllllllllIlIIIIlllIIlIlIIIIllI, final int lllllllllllIlIIIIlllIIlIIlllllII, final int lllllllllllIlIIIIlllIIlIlIIIIlII, final int lllllllllllIlIIIIlllIIlIlIIIIIll) {
        final int[] lllllllllllIlIIIIlllIIlIlIIIIIlI = this.biomePatternGeneratorChain.getInts(lllllllllllIlIIIIlllIIlIlIIIIllI, lllllllllllIlIIIIlllIIlIIlllllII, lllllllllllIlIIIIlllIIlIlIIIIlII, lllllllllllIlIIIIlllIIlIlIIIIIll);
        final int[] lllllllllllIlIIIIlllIIlIlIIIIIIl = this.riverPatternGeneratorChain.getInts(lllllllllllIlIIIIlllIIlIlIIIIllI, lllllllllllIlIIIIlllIIlIIlllllII, lllllllllllIlIIIIlllIIlIlIIIIlII, lllllllllllIlIIIIlllIIlIlIIIIIll);
        final int[] lllllllllllIlIIIIlllIIlIlIIIIIII = IntCache.getIntCache(lllllllllllIlIIIIlllIIlIlIIIIlII * lllllllllllIlIIIIlllIIlIlIIIIIll);
        for (int lllllllllllIlIIIIlllIIlIIlllllll = 0; lllllllllllIlIIIIlllIIlIIlllllll < lllllllllllIlIIIIlllIIlIlIIIIlII * lllllllllllIlIIIIlllIIlIlIIIIIll; ++lllllllllllIlIIIIlllIIlIIlllllll) {
            if (lllllllllllIlIIIIlllIIlIlIIIIIlI[lllllllllllIlIIIIlllIIlIIlllllll] != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllIlIIIIlllIIlIlIIIIIlI[lllllllllllIlIIIIlllIIlIIlllllll] != Biome.getIdForBiome(Biomes.DEEP_OCEAN)) {
                if (lllllllllllIlIIIIlllIIlIlIIIIIIl[lllllllllllIlIIIIlllIIlIIlllllll] == Biome.getIdForBiome(Biomes.RIVER)) {
                    if (lllllllllllIlIIIIlllIIlIlIIIIIlI[lllllllllllIlIIIIlllIIlIIlllllll] == Biome.getIdForBiome(Biomes.ICE_PLAINS)) {
                        lllllllllllIlIIIIlllIIlIlIIIIIII[lllllllllllIlIIIIlllIIlIIlllllll] = Biome.getIdForBiome(Biomes.FROZEN_RIVER);
                    }
                    else if (lllllllllllIlIIIIlllIIlIlIIIIIlI[lllllllllllIlIIIIlllIIlIIlllllll] != Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND) && lllllllllllIlIIIIlllIIlIlIIIIIlI[lllllllllllIlIIIIlllIIlIIlllllll] != Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND_SHORE)) {
                        lllllllllllIlIIIIlllIIlIlIIIIIII[lllllllllllIlIIIIlllIIlIIlllllll] = (lllllllllllIlIIIIlllIIlIlIIIIIIl[lllllllllllIlIIIIlllIIlIIlllllll] & 0xFF);
                    }
                    else {
                        lllllllllllIlIIIIlllIIlIlIIIIIII[lllllllllllIlIIIIlllIIlIIlllllll] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND_SHORE);
                    }
                }
                else {
                    lllllllllllIlIIIIlllIIlIlIIIIIII[lllllllllllIlIIIIlllIIlIIlllllll] = lllllllllllIlIIIIlllIIlIlIIIIIlI[lllllllllllIlIIIIlllIIlIIlllllll];
                }
            }
            else {
                lllllllllllIlIIIIlllIIlIlIIIIIII[lllllllllllIlIIIIlllIIlIIlllllll] = lllllllllllIlIIIIlllIIlIlIIIIIlI[lllllllllllIlIIIIlllIIlIIlllllll];
            }
        }
        return lllllllllllIlIIIIlllIIlIlIIIIIII;
    }
    
    public GenLayerRiverMix(final long lllllllllllIlIIIIlllIIlIlIIlllIl, final GenLayer lllllllllllIlIIIIlllIIlIlIIllIII, final GenLayer lllllllllllIlIIIIlllIIlIlIIlIlll) {
        super(lllllllllllIlIIIIlllIIlIlIIlllIl);
        this.biomePatternGeneratorChain = lllllllllllIlIIIIlllIIlIlIIllIII;
        this.riverPatternGeneratorChain = lllllllllllIlIIIIlllIIlIlIIlIlll;
    }
    
    @Override
    public void initWorldGenSeed(final long lllllllllllIlIIIIlllIIlIlIIlIIll) {
        this.biomePatternGeneratorChain.initWorldGenSeed(lllllllllllIlIIIIlllIIlIlIIlIIll);
        this.riverPatternGeneratorChain.initWorldGenSeed(lllllllllllIlIIIIlllIIlIlIIlIIll);
        super.initWorldGenSeed(lllllllllllIlIIIIlllIIlIlIIlIIll);
    }
}
