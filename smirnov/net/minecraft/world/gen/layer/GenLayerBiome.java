// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import net.minecraft.init.Biomes;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;

public class GenLayerBiome extends GenLayer
{
    private final /* synthetic */ ChunkGeneratorSettings settings;
    private final /* synthetic */ Biome[] mediumBiomes;
    private /* synthetic */ Biome[] warmBiomes;
    private final /* synthetic */ Biome[] coldBiomes;
    private final /* synthetic */ Biome[] iceBiomes;
    
    public GenLayerBiome(final long llllllllllIllllIIllIIIlIlIIllIII, final GenLayer llllllllllIllllIIllIIIlIlIIlllII, final WorldType llllllllllIllllIIllIIIlIlIIlIllI, final ChunkGeneratorSettings llllllllllIllllIIllIIIlIlIIllIlI) {
        super(llllllllllIllllIIllIIIlIlIIllIII);
        this.warmBiomes = new Biome[] { Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.SAVANNA, Biomes.SAVANNA, Biomes.PLAINS };
        this.mediumBiomes = new Biome[] { Biomes.FOREST, Biomes.ROOFED_FOREST, Biomes.EXTREME_HILLS, Biomes.PLAINS, Biomes.BIRCH_FOREST, Biomes.SWAMPLAND };
        this.coldBiomes = new Biome[] { Biomes.FOREST, Biomes.EXTREME_HILLS, Biomes.TAIGA, Biomes.PLAINS };
        this.iceBiomes = new Biome[] { Biomes.ICE_PLAINS, Biomes.ICE_PLAINS, Biomes.ICE_PLAINS, Biomes.COLD_TAIGA };
        this.parent = llllllllllIllllIIllIIIlIlIIlllII;
        if (llllllllllIllllIIllIIIlIlIIlIllI == WorldType.DEFAULT_1_1) {
            this.warmBiomes = new Biome[] { Biomes.DESERT, Biomes.FOREST, Biomes.EXTREME_HILLS, Biomes.SWAMPLAND, Biomes.PLAINS, Biomes.TAIGA };
            this.settings = null;
        }
        else {
            this.settings = llllllllllIllllIIllIIIlIlIIllIlI;
        }
    }
    
    @Override
    public int[] getInts(final int llllllllllIllllIIllIIIlIIlllllIl, final int llllllllllIllllIIllIIIlIIlllllII, final int llllllllllIllllIIllIIIlIIllllIll, final int llllllllllIllllIIllIIIlIlIIIIlIl) {
        final int[] llllllllllIllllIIllIIIlIlIIIIlII = this.parent.getInts(llllllllllIllllIIllIIIlIIlllllIl, llllllllllIllllIIllIIIlIIlllllII, llllllllllIllllIIllIIIlIIllllIll, llllllllllIllllIIllIIIlIlIIIIlIl);
        final int[] llllllllllIllllIIllIIIlIlIIIIIll = IntCache.getIntCache(llllllllllIllllIIllIIIlIIllllIll * llllllllllIllllIIllIIIlIlIIIIlIl);
        for (int llllllllllIllllIIllIIIlIlIIIIIlI = 0; llllllllllIllllIIllIIIlIlIIIIIlI < llllllllllIllllIIllIIIlIlIIIIlIl; ++llllllllllIllllIIllIIIlIlIIIIIlI) {
            for (int llllllllllIllllIIllIIIlIlIIIIIIl = 0; llllllllllIllllIIllIIIlIlIIIIIIl < llllllllllIllllIIllIIIlIIllllIll; ++llllllllllIllllIIllIIIlIlIIIIIIl) {
                this.initChunkSeed(llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIIlllllIl, llllllllllIllllIIllIIIlIlIIIIIlI + llllllllllIllllIIllIIIlIIlllllII);
                int llllllllllIllllIIllIIIlIlIIIIIII = llllllllllIllllIIllIIIlIlIIIIlII[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll];
                final int llllllllllIllllIIllIIIlIIlllllll = (llllllllllIllllIIllIIIlIlIIIIIII & 0xF00) >> 8;
                llllllllllIllllIIllIIIlIlIIIIIII &= 0xFFFFF0FF;
                if (this.settings != null && this.settings.fixedBiome >= 0) {
                    llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = this.settings.fixedBiome;
                }
                else if (GenLayer.isBiomeOceanic(llllllllllIllllIIllIIIlIlIIIIIII)) {
                    llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = llllllllllIllllIIllIIIlIlIIIIIII;
                }
                else if (llllllllllIllllIIllIIIlIlIIIIIII == Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND)) {
                    llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = llllllllllIllllIIllIIIlIlIIIIIII;
                }
                else if (llllllllllIllllIIllIIIlIlIIIIIII == 1) {
                    if (llllllllllIllllIIllIIIlIIlllllll > 0) {
                        if (this.nextInt(3) == 0) {
                            llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = Biome.getIdForBiome(Biomes.MESA_CLEAR_ROCK);
                        }
                        else {
                            llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = Biome.getIdForBiome(Biomes.MESA_ROCK);
                        }
                    }
                    else {
                        llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = Biome.getIdForBiome(this.warmBiomes[this.nextInt(this.warmBiomes.length)]);
                    }
                }
                else if (llllllllllIllllIIllIIIlIlIIIIIII == 2) {
                    if (llllllllllIllllIIllIIIlIIlllllll > 0) {
                        llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = Biome.getIdForBiome(Biomes.JUNGLE);
                    }
                    else {
                        llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = Biome.getIdForBiome(this.mediumBiomes[this.nextInt(this.mediumBiomes.length)]);
                    }
                }
                else if (llllllllllIllllIIllIIIlIlIIIIIII == 3) {
                    if (llllllllllIllllIIllIIIlIIlllllll > 0) {
                        llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = Biome.getIdForBiome(Biomes.REDWOOD_TAIGA);
                    }
                    else {
                        llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = Biome.getIdForBiome(this.coldBiomes[this.nextInt(this.coldBiomes.length)]);
                    }
                }
                else if (llllllllllIllllIIllIIIlIlIIIIIII == 4) {
                    llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = Biome.getIdForBiome(this.iceBiomes[this.nextInt(this.iceBiomes.length)]);
                }
                else {
                    llllllllllIllllIIllIIIlIlIIIIIll[llllllllllIllllIIllIIIlIlIIIIIIl + llllllllllIllllIIllIIIlIlIIIIIlI * llllllllllIllllIIllIIIlIIllllIll] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND);
                }
            }
        }
        return llllllllllIllllIIllIIIlIlIIIIIll;
    }
}
