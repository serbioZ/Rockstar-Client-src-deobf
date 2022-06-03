// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.init.Biomes;
import net.minecraft.block.BlockFalling;
import net.minecraft.util.math.ChunkPos;
import javax.annotation.Nullable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.StructureOceanMonument;
import net.minecraft.world.gen.structure.WoodlandMansion;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.WorldType;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.MapGenMineshaft;

public class ChunkGeneratorOverworld implements IChunkGenerator
{
    private final /* synthetic */ float[] biomeWeights;
    private final /* synthetic */ double[] heightMap;
    private final /* synthetic */ MapGenMineshaft mineshaftGenerator;
    private final /* synthetic */ MapGenVillage villageGenerator;
    private final /* synthetic */ NoiseGeneratorOctaves minLimitPerlinNoise;
    private final /* synthetic */ MapGenStronghold strongholdGenerator;
    private final /* synthetic */ NoiseGeneratorPerlin surfaceNoise;
    private final /* synthetic */ NoiseGeneratorOctaves mainPerlinNoise;
    private final /* synthetic */ Random rand;
    private final /* synthetic */ NoiseGeneratorOctaves maxLimitPerlinNoise;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ WorldType terrainType;
    protected static final /* synthetic */ IBlockState STONE;
    private final /* synthetic */ WoodlandMansion field_191060_C;
    private final /* synthetic */ StructureOceanMonument oceanMonumentGenerator;
    /* synthetic */ double[] maxLimitRegion;
    private /* synthetic */ double[] depthBuffer;
    private /* synthetic */ IBlockState oceanBlock;
    public /* synthetic */ NoiseGeneratorOctaves forestNoise;
    public /* synthetic */ NoiseGeneratorOctaves scaleNoise;
    private /* synthetic */ ChunkGeneratorSettings settings;
    private final /* synthetic */ MapGenScatteredFeature scatteredFeatureGenerator;
    /* synthetic */ double[] mainNoiseRegion;
    private final /* synthetic */ boolean mapFeaturesEnabled;
    private final /* synthetic */ MapGenBase ravineGenerator;
    /* synthetic */ double[] minLimitRegion;
    /* synthetic */ double[] depthRegion;
    public /* synthetic */ NoiseGeneratorOctaves depthNoise;
    private final /* synthetic */ MapGenBase caveGenerator;
    private /* synthetic */ Biome[] biomesForGeneration;
    
    @Override
    public boolean func_193414_a(final World lllllllllllllIIIIlIIIlIIIlIlIIII, final String lllllllllllllIIIIlIIIlIIIlIIllII, final BlockPos lllllllllllllIIIIlIIIlIIIlIIlIll) {
        if (!this.mapFeaturesEnabled) {
            return false;
        }
        if ("Stronghold".equals(lllllllllllllIIIIlIIIlIIIlIIllII) && this.strongholdGenerator != null) {
            return this.strongholdGenerator.isInsideStructure(lllllllllllllIIIIlIIIlIIIlIIlIll);
        }
        if ("Mansion".equals(lllllllllllllIIIIlIIIlIIIlIIllII) && this.field_191060_C != null) {
            return this.field_191060_C.isInsideStructure(lllllllllllllIIIIlIIIlIIIlIIlIll);
        }
        if ("Monument".equals(lllllllllllllIIIIlIIIlIIIlIIllII) && this.oceanMonumentGenerator != null) {
            return this.oceanMonumentGenerator.isInsideStructure(lllllllllllllIIIIlIIIlIIIlIIlIll);
        }
        if ("Village".equals(lllllllllllllIIIIlIIIlIIIlIIllII) && this.villageGenerator != null) {
            return this.villageGenerator.isInsideStructure(lllllllllllllIIIIlIIIlIIIlIIlIll);
        }
        if ("Mineshaft".equals(lllllllllllllIIIIlIIIlIIIlIIllII) && this.mineshaftGenerator != null) {
            return this.mineshaftGenerator.isInsideStructure(lllllllllllllIIIIlIIIlIIIlIIlIll);
        }
        return "Temple".equals(lllllllllllllIIIIlIIIlIIIlIIllII) && this.scatteredFeatureGenerator != null && this.scatteredFeatureGenerator.isInsideStructure(lllllllllllllIIIIlIIIlIIIlIIlIll);
    }
    
    @Override
    public void recreateStructures(final Chunk lllllllllllllIIIIlIIIlIIIIllIlll, final int lllllllllllllIIIIlIIIlIIIIllIllI, final int lllllllllllllIIIIlIIIlIIIIllIIlI) {
        if (this.mapFeaturesEnabled) {
            if (this.settings.useMineShafts) {
                this.mineshaftGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIIIIllIllI, lllllllllllllIIIIlIIIlIIIIllIIlI, null);
            }
            if (this.settings.useVillages) {
                this.villageGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIIIIllIllI, lllllllllllllIIIIlIIIlIIIIllIIlI, null);
            }
            if (this.settings.useStrongholds) {
                this.strongholdGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIIIIllIllI, lllllllllllllIIIIlIIIlIIIIllIIlI, null);
            }
            if (this.settings.useTemples) {
                this.scatteredFeatureGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIIIIllIllI, lllllllllllllIIIIlIIIlIIIIllIIlI, null);
            }
            if (this.settings.useMonuments) {
                this.oceanMonumentGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIIIIllIllI, lllllllllllllIIIIlIIIlIIIIllIIlI, null);
            }
            if (this.settings.field_191077_z) {
                this.field_191060_C.generate(this.worldObj, lllllllllllllIIIIlIIIlIIIIllIllI, lllllllllllllIIIIlIIIlIIIIllIIlI, null);
            }
        }
    }
    
    public ChunkGeneratorOverworld(final World lllllllllllllIIIIlIIIlIllIIllIlI, final long lllllllllllllIIIIlIIIlIllIIllIIl, final boolean lllllllllllllIIIIlIIIlIllIlIIIII, final String lllllllllllllIIIIlIIIlIllIIlllll) {
        this.oceanBlock = Blocks.WATER.getDefaultState();
        this.depthBuffer = new double[256];
        this.caveGenerator = new MapGenCaves();
        this.strongholdGenerator = new MapGenStronghold();
        this.villageGenerator = new MapGenVillage();
        this.mineshaftGenerator = new MapGenMineshaft();
        this.scatteredFeatureGenerator = new MapGenScatteredFeature();
        this.ravineGenerator = new MapGenRavine();
        this.oceanMonumentGenerator = new StructureOceanMonument();
        this.field_191060_C = new WoodlandMansion(this);
        this.worldObj = lllllllllllllIIIIlIIIlIllIIllIlI;
        this.mapFeaturesEnabled = lllllllllllllIIIIlIIIlIllIlIIIII;
        this.terrainType = lllllllllllllIIIIlIIIlIllIIllIlI.getWorldInfo().getTerrainType();
        this.rand = new Random(lllllllllllllIIIIlIIIlIllIIllIIl);
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.surfaceNoise = new NoiseGeneratorPerlin(this.rand, 4);
        this.scaleNoise = new NoiseGeneratorOctaves(this.rand, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.forestNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.heightMap = new double[825];
        this.biomeWeights = new float[25];
        for (int lllllllllllllIIIIlIIIlIllIIllllI = -2; lllllllllllllIIIIlIIIlIllIIllllI <= 2; ++lllllllllllllIIIIlIIIlIllIIllllI) {
            for (int lllllllllllllIIIIlIIIlIllIIlllIl = -2; lllllllllllllIIIIlIIIlIllIIlllIl <= 2; ++lllllllllllllIIIIlIIIlIllIIlllIl) {
                final float lllllllllllllIIIIlIIIlIllIIlllII = 10.0f / MathHelper.sqrt(lllllllllllllIIIIlIIIlIllIIllllI * lllllllllllllIIIIlIIIlIllIIllllI + lllllllllllllIIIIlIIIlIllIIlllIl * lllllllllllllIIIIlIIIlIllIIlllIl + 0.2f);
                this.biomeWeights[lllllllllllllIIIIlIIIlIllIIllllI + 2 + (lllllllllllllIIIIlIIIlIllIIlllIl + 2) * 5] = lllllllllllllIIIIlIIIlIllIIlllII;
            }
        }
        if (lllllllllllllIIIIlIIIlIllIIlllll != null) {
            this.settings = ChunkGeneratorSettings.Factory.jsonToFactory(lllllllllllllIIIIlIIIlIllIIlllll).build();
            this.oceanBlock = (this.settings.useLavaOceans ? Blocks.LAVA.getDefaultState() : Blocks.WATER.getDefaultState());
            lllllllllllllIIIIlIIIlIllIIllIlI.setSeaLevel(this.settings.seaLevel);
        }
    }
    
    private void generateHeightmap(final int lllllllllllllIIIIlIIIlIIlllIIIlI, final int lllllllllllllIIIIlIIIlIIlllIIIIl, final int lllllllllllllIIIIlIIIlIIlllIIIII) {
        this.depthRegion = this.depthNoise.generateNoiseOctaves(this.depthRegion, lllllllllllllIIIIlIIIlIIlllIIIlI, lllllllllllllIIIIlIIIlIIlllIIIII, 5, 5, this.settings.depthNoiseScaleX, this.settings.depthNoiseScaleZ, this.settings.depthNoiseScaleExponent);
        final float lllllllllllllIIIIlIIIlIIllIlllll = this.settings.coordinateScale;
        final float lllllllllllllIIIIlIIIlIIllIllllI = this.settings.heightScale;
        this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, lllllllllllllIIIIlIIIlIIlllIIIlI, lllllllllllllIIIIlIIIlIIlllIIIIl, lllllllllllllIIIIlIIIlIIlllIIIII, 5, 33, 5, lllllllllllllIIIIlIIIlIIllIlllll / this.settings.mainNoiseScaleX, lllllllllllllIIIIlIIIlIIllIllllI / this.settings.mainNoiseScaleY, lllllllllllllIIIIlIIIlIIllIlllll / this.settings.mainNoiseScaleZ);
        this.minLimitRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, lllllllllllllIIIIlIIIlIIlllIIIlI, lllllllllllllIIIIlIIIlIIlllIIIIl, lllllllllllllIIIIlIIIlIIlllIIIII, 5, 33, 5, lllllllllllllIIIIlIIIlIIllIlllll, lllllllllllllIIIIlIIIlIIllIllllI, lllllllllllllIIIIlIIIlIIllIlllll);
        this.maxLimitRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, lllllllllllllIIIIlIIIlIIlllIIIlI, lllllllllllllIIIIlIIIlIIlllIIIIl, lllllllllllllIIIIlIIIlIIlllIIIII, 5, 33, 5, lllllllllllllIIIIlIIIlIIllIlllll, lllllllllllllIIIIlIIIlIIllIllllI, lllllllllllllIIIIlIIIlIIllIlllll);
        int lllllllllllllIIIIlIIIlIIllIlllIl = 0;
        int lllllllllllllIIIIlIIIlIIllIlllII = 0;
        for (int lllllllllllllIIIIlIIIlIIllIllIll = 0; lllllllllllllIIIIlIIIlIIllIllIll < 5; ++lllllllllllllIIIIlIIIlIIllIllIll) {
            for (int lllllllllllllIIIIlIIIlIIllIllIlI = 0; lllllllllllllIIIIlIIIlIIllIllIlI < 5; ++lllllllllllllIIIIlIIIlIIllIllIlI) {
                float lllllllllllllIIIIlIIIlIIllIllIIl = 0.0f;
                float lllllllllllllIIIIlIIIlIIllIllIII = 0.0f;
                float lllllllllllllIIIIlIIIlIIllIlIlll = 0.0f;
                final int lllllllllllllIIIIlIIIlIIllIlIllI = 2;
                final Biome lllllllllllllIIIIlIIIlIIllIlIlIl = this.biomesForGeneration[lllllllllllllIIIIlIIIlIIllIllIll + 2 + (lllllllllllllIIIIlIIIlIIllIllIlI + 2) * 10];
                for (int lllllllllllllIIIIlIIIlIIllIlIlII = -2; lllllllllllllIIIIlIIIlIIllIlIlII <= 2; ++lllllllllllllIIIIlIIIlIIllIlIlII) {
                    for (int lllllllllllllIIIIlIIIlIIllIlIIll = -2; lllllllllllllIIIIlIIIlIIllIlIIll <= 2; ++lllllllllllllIIIIlIIIlIIllIlIIll) {
                        final Biome lllllllllllllIIIIlIIIlIIllIlIIlI = this.biomesForGeneration[lllllllllllllIIIIlIIIlIIllIllIll + lllllllllllllIIIIlIIIlIIllIlIlII + 2 + (lllllllllllllIIIIlIIIlIIllIllIlI + lllllllllllllIIIIlIIIlIIllIlIIll + 2) * 10];
                        float lllllllllllllIIIIlIIIlIIllIlIIIl = this.settings.biomeDepthOffSet + lllllllllllllIIIIlIIIlIIllIlIIlI.getBaseHeight() * this.settings.biomeDepthWeight;
                        float lllllllllllllIIIIlIIIlIIllIlIIII = this.settings.biomeScaleOffset + lllllllllllllIIIIlIIIlIIllIlIIlI.getHeightVariation() * this.settings.biomeScaleWeight;
                        if (this.terrainType == WorldType.AMPLIFIED && lllllllllllllIIIIlIIIlIIllIlIIIl > 0.0f) {
                            lllllllllllllIIIIlIIIlIIllIlIIIl = 1.0f + lllllllllllllIIIIlIIIlIIllIlIIIl * 2.0f;
                            lllllllllllllIIIIlIIIlIIllIlIIII = 1.0f + lllllllllllllIIIIlIIIlIIllIlIIII * 4.0f;
                        }
                        float lllllllllllllIIIIlIIIlIIllIIllll = this.biomeWeights[lllllllllllllIIIIlIIIlIIllIlIlII + 2 + (lllllllllllllIIIIlIIIlIIllIlIIll + 2) * 5] / (lllllllllllllIIIIlIIIlIIllIlIIIl + 2.0f);
                        if (lllllllllllllIIIIlIIIlIIllIlIIlI.getBaseHeight() > lllllllllllllIIIIlIIIlIIllIlIlIl.getBaseHeight()) {
                            lllllllllllllIIIIlIIIlIIllIIllll /= 2.0f;
                        }
                        lllllllllllllIIIIlIIIlIIllIllIIl += lllllllllllllIIIIlIIIlIIllIlIIII * lllllllllllllIIIIlIIIlIIllIIllll;
                        lllllllllllllIIIIlIIIlIIllIllIII += lllllllllllllIIIIlIIIlIIllIlIIIl * lllllllllllllIIIIlIIIlIIllIIllll;
                        lllllllllllllIIIIlIIIlIIllIlIlll += lllllllllllllIIIIlIIIlIIllIIllll;
                    }
                }
                lllllllllllllIIIIlIIIlIIllIllIIl /= lllllllllllllIIIIlIIIlIIllIlIlll;
                lllllllllllllIIIIlIIIlIIllIllIII /= lllllllllllllIIIIlIIIlIIllIlIlll;
                lllllllllllllIIIIlIIIlIIllIllIIl = lllllllllllllIIIIlIIIlIIllIllIIl * 0.9f + 0.1f;
                lllllllllllllIIIIlIIIlIIllIllIII = (lllllllllllllIIIIlIIIlIIllIllIII * 4.0f - 1.0f) / 8.0f;
                double lllllllllllllIIIIlIIIlIIllIIlllI = this.depthRegion[lllllllllllllIIIIlIIIlIIllIlllII] / 8000.0;
                if (lllllllllllllIIIIlIIIlIIllIIlllI < 0.0) {
                    lllllllllllllIIIIlIIIlIIllIIlllI = -lllllllllllllIIIIlIIIlIIllIIlllI * 0.3;
                }
                lllllllllllllIIIIlIIIlIIllIIlllI = lllllllllllllIIIIlIIIlIIllIIlllI * 3.0 - 2.0;
                if (lllllllllllllIIIIlIIIlIIllIIlllI < 0.0) {
                    lllllllllllllIIIIlIIIlIIllIIlllI /= 2.0;
                    if (lllllllllllllIIIIlIIIlIIllIIlllI < -1.0) {
                        lllllllllllllIIIIlIIIlIIllIIlllI = -1.0;
                    }
                    lllllllllllllIIIIlIIIlIIllIIlllI /= 1.4;
                    lllllllllllllIIIIlIIIlIIllIIlllI /= 2.0;
                }
                else {
                    if (lllllllllllllIIIIlIIIlIIllIIlllI > 1.0) {
                        lllllllllllllIIIIlIIIlIIllIIlllI = 1.0;
                    }
                    lllllllllllllIIIIlIIIlIIllIIlllI /= 8.0;
                }
                ++lllllllllllllIIIIlIIIlIIllIlllII;
                double lllllllllllllIIIIlIIIlIIllIIllIl = lllllllllllllIIIIlIIIlIIllIllIII;
                final double lllllllllllllIIIIlIIIlIIllIIllII = lllllllllllllIIIIlIIIlIIllIllIIl;
                lllllllllllllIIIIlIIIlIIllIIllIl += lllllllllllllIIIIlIIIlIIllIIlllI * 0.2;
                lllllllllllllIIIIlIIIlIIllIIllIl = lllllllllllllIIIIlIIIlIIllIIllIl * this.settings.baseSize / 8.0;
                final double lllllllllllllIIIIlIIIlIIllIIlIll = this.settings.baseSize + lllllllllllllIIIIlIIIlIIllIIllIl * 4.0;
                for (int lllllllllllllIIIIlIIIlIIllIIlIlI = 0; lllllllllllllIIIIlIIIlIIllIIlIlI < 33; ++lllllllllllllIIIIlIIIlIIllIIlIlI) {
                    double lllllllllllllIIIIlIIIlIIllIIlIIl = (lllllllllllllIIIIlIIIlIIllIIlIlI - lllllllllllllIIIIlIIIlIIllIIlIll) * this.settings.stretchY * 128.0 / 256.0 / lllllllllllllIIIIlIIIlIIllIIllII;
                    if (lllllllllllllIIIIlIIIlIIllIIlIIl < 0.0) {
                        lllllllllllllIIIIlIIIlIIllIIlIIl *= 4.0;
                    }
                    final double lllllllllllllIIIIlIIIlIIllIIlIII = this.minLimitRegion[lllllllllllllIIIIlIIIlIIllIlllIl] / this.settings.lowerLimitScale;
                    final double lllllllllllllIIIIlIIIlIIllIIIlll = this.maxLimitRegion[lllllllllllllIIIIlIIIlIIllIlllIl] / this.settings.upperLimitScale;
                    final double lllllllllllllIIIIlIIIlIIllIIIllI = (this.mainNoiseRegion[lllllllllllllIIIIlIIIlIIllIlllIl] / 10.0 + 1.0) / 2.0;
                    double lllllllllllllIIIIlIIIlIIllIIIlIl = MathHelper.clampedLerp(lllllllllllllIIIIlIIIlIIllIIlIII, lllllllllllllIIIIlIIIlIIllIIIlll, lllllllllllllIIIIlIIIlIIllIIIllI) - lllllllllllllIIIIlIIIlIIllIIlIIl;
                    if (lllllllllllllIIIIlIIIlIIllIIlIlI > 29) {
                        final double lllllllllllllIIIIlIIIlIIllIIIlII = (lllllllllllllIIIIlIIIlIIllIIlIlI - 29) / 3.0f;
                        lllllllllllllIIIIlIIIlIIllIIIlIl = lllllllllllllIIIIlIIIlIIllIIIlIl * (1.0 - lllllllllllllIIIIlIIIlIIllIIIlII) + -10.0 * lllllllllllllIIIIlIIIlIIllIIIlII;
                    }
                    this.heightMap[lllllllllllllIIIIlIIIlIIllIlllIl] = lllllllllllllIIIIlIIIlIIllIIIlIl;
                    ++lllllllllllllIIIIlIIIlIIllIlllIl;
                }
            }
        }
    }
    
    public void setBlocksInChunk(final int lllllllllllllIIIIlIIIlIlIlIlIIII, final int lllllllllllllIIIIlIIIlIlIlllIIII, final ChunkPrimer lllllllllllllIIIIlIIIlIlIlIIlllI) {
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, lllllllllllllIIIIlIIIlIlIlIlIIII * 4 - 2, lllllllllllllIIIIlIIIlIlIlllIIII * 4 - 2, 10, 10);
        this.generateHeightmap(lllllllllllllIIIIlIIIlIlIlIlIIII * 4, 0, lllllllllllllIIIIlIIIlIlIlllIIII * 4);
        for (int lllllllllllllIIIIlIIIlIlIllIlllI = 0; lllllllllllllIIIIlIIIlIlIllIlllI < 4; ++lllllllllllllIIIIlIIIlIlIllIlllI) {
            final int lllllllllllllIIIIlIIIlIlIllIllIl = lllllllllllllIIIIlIIIlIlIllIlllI * 5;
            final int lllllllllllllIIIIlIIIlIlIllIllII = (lllllllllllllIIIIlIIIlIlIllIlllI + 1) * 5;
            for (int lllllllllllllIIIIlIIIlIlIllIlIll = 0; lllllllllllllIIIIlIIIlIlIllIlIll < 4; ++lllllllllllllIIIIlIIIlIlIllIlIll) {
                final int lllllllllllllIIIIlIIIlIlIllIlIlI = (lllllllllllllIIIIlIIIlIlIllIllIl + lllllllllllllIIIIlIIIlIlIllIlIll) * 33;
                final int lllllllllllllIIIIlIIIlIlIllIlIIl = (lllllllllllllIIIIlIIIlIlIllIllIl + lllllllllllllIIIIlIIIlIlIllIlIll + 1) * 33;
                final int lllllllllllllIIIIlIIIlIlIllIlIII = (lllllllllllllIIIIlIIIlIlIllIllII + lllllllllllllIIIIlIIIlIlIllIlIll) * 33;
                final int lllllllllllllIIIIlIIIlIlIllIIlll = (lllllllllllllIIIIlIIIlIlIllIllII + lllllllllllllIIIIlIIIlIlIllIlIll + 1) * 33;
                for (int lllllllllllllIIIIlIIIlIlIllIIllI = 0; lllllllllllllIIIIlIIIlIlIllIIllI < 32; ++lllllllllllllIIIIlIIIlIlIllIIllI) {
                    final double lllllllllllllIIIIlIIIlIlIllIIlIl = 0.125;
                    double lllllllllllllIIIIlIIIlIlIllIIlII = this.heightMap[lllllllllllllIIIIlIIIlIlIllIlIlI + lllllllllllllIIIIlIIIlIlIllIIllI];
                    double lllllllllllllIIIIlIIIlIlIllIIIll = this.heightMap[lllllllllllllIIIIlIIIlIlIllIlIIl + lllllllllllllIIIIlIIIlIlIllIIllI];
                    double lllllllllllllIIIIlIIIlIlIllIIIlI = this.heightMap[lllllllllllllIIIIlIIIlIlIllIlIII + lllllllllllllIIIIlIIIlIlIllIIllI];
                    double lllllllllllllIIIIlIIIlIlIllIIIIl = this.heightMap[lllllllllllllIIIIlIIIlIlIllIIlll + lllllllllllllIIIIlIIIlIlIllIIllI];
                    final double lllllllllllllIIIIlIIIlIlIllIIIII = (this.heightMap[lllllllllllllIIIIlIIIlIlIllIlIlI + lllllllllllllIIIIlIIIlIlIllIIllI + 1] - lllllllllllllIIIIlIIIlIlIllIIlII) * 0.125;
                    final double lllllllllllllIIIIlIIIlIlIlIlllll = (this.heightMap[lllllllllllllIIIIlIIIlIlIllIlIIl + lllllllllllllIIIIlIIIlIlIllIIllI + 1] - lllllllllllllIIIIlIIIlIlIllIIIll) * 0.125;
                    final double lllllllllllllIIIIlIIIlIlIlIllllI = (this.heightMap[lllllllllllllIIIIlIIIlIlIllIlIII + lllllllllllllIIIIlIIIlIlIllIIllI + 1] - lllllllllllllIIIIlIIIlIlIllIIIlI) * 0.125;
                    final double lllllllllllllIIIIlIIIlIlIlIlllIl = (this.heightMap[lllllllllllllIIIIlIIIlIlIllIIlll + lllllllllllllIIIIlIIIlIlIllIIllI + 1] - lllllllllllllIIIIlIIIlIlIllIIIIl) * 0.125;
                    for (int lllllllllllllIIIIlIIIlIlIlIlllII = 0; lllllllllllllIIIIlIIIlIlIlIlllII < 8; ++lllllllllllllIIIIlIIIlIlIlIlllII) {
                        final double lllllllllllllIIIIlIIIlIlIlIllIll = 0.25;
                        double lllllllllllllIIIIlIIIlIlIlIllIlI = lllllllllllllIIIIlIIIlIlIllIIlII;
                        double lllllllllllllIIIIlIIIlIlIlIllIIl = lllllllllllllIIIIlIIIlIlIllIIIll;
                        final double lllllllllllllIIIIlIIIlIlIlIllIII = (lllllllllllllIIIIlIIIlIlIllIIIlI - lllllllllllllIIIIlIIIlIlIllIIlII) * 0.25;
                        final double lllllllllllllIIIIlIIIlIlIlIlIlll = (lllllllllllllIIIIlIIIlIlIllIIIIl - lllllllllllllIIIIlIIIlIlIllIIIll) * 0.25;
                        for (int lllllllllllllIIIIlIIIlIlIlIlIllI = 0; lllllllllllllIIIIlIIIlIlIlIlIllI < 4; ++lllllllllllllIIIIlIIIlIlIlIlIllI) {
                            final double lllllllllllllIIIIlIIIlIlIlIlIlIl = 0.25;
                            final double lllllllllllllIIIIlIIIlIlIlIlIlII = (lllllllllllllIIIIlIIIlIlIlIllIIl - lllllllllllllIIIIlIIIlIlIlIllIlI) * 0.25;
                            double lllllllllllllIIIIlIIIlIlIlIlIIll = lllllllllllllIIIIlIIIlIlIlIllIlI - lllllllllllllIIIIlIIIlIlIlIlIlII;
                            for (int lllllllllllllIIIIlIIIlIlIlIlIIlI = 0; lllllllllllllIIIIlIIIlIlIlIlIIlI < 4; ++lllllllllllllIIIIlIIIlIlIlIlIIlI) {
                                if ((lllllllllllllIIIIlIIIlIlIlIlIIll += lllllllllllllIIIIlIIIlIlIlIlIlII) > 0.0) {
                                    lllllllllllllIIIIlIIIlIlIlIIlllI.setBlockState(lllllllllllllIIIIlIIIlIlIllIlllI * 4 + lllllllllllllIIIIlIIIlIlIlIlIllI, lllllllllllllIIIIlIIIlIlIllIIllI * 8 + lllllllllllllIIIIlIIIlIlIlIlllII, lllllllllllllIIIIlIIIlIlIllIlIll * 4 + lllllllllllllIIIIlIIIlIlIlIlIIlI, ChunkGeneratorOverworld.STONE);
                                }
                                else if (lllllllllllllIIIIlIIIlIlIllIIllI * 8 + lllllllllllllIIIIlIIIlIlIlIlllII < this.settings.seaLevel) {
                                    lllllllllllllIIIIlIIIlIlIlIIlllI.setBlockState(lllllllllllllIIIIlIIIlIlIllIlllI * 4 + lllllllllllllIIIIlIIIlIlIlIlIllI, lllllllllllllIIIIlIIIlIlIllIIllI * 8 + lllllllllllllIIIIlIIIlIlIlIlllII, lllllllllllllIIIIlIIIlIlIllIlIll * 4 + lllllllllllllIIIIlIIIlIlIlIlIIlI, this.oceanBlock);
                                }
                            }
                            lllllllllllllIIIIlIIIlIlIlIllIlI += lllllllllllllIIIIlIIIlIlIlIllIII;
                            lllllllllllllIIIIlIIIlIlIlIllIIl += lllllllllllllIIIIlIIIlIlIlIlIlll;
                        }
                        lllllllllllllIIIIlIIIlIlIllIIlII += lllllllllllllIIIIlIIIlIlIllIIIII;
                        lllllllllllllIIIIlIIIlIlIllIIIll += lllllllllllllIIIIlIIIlIlIlIlllll;
                        lllllllllllllIIIIlIIIlIlIllIIIlI += lllllllllllllIIIIlIIIlIlIlIllllI;
                        lllllllllllllIIIIlIIIlIlIllIIIIl += lllllllllllllIIIIlIIIlIlIlIlllIl;
                    }
                }
            }
        }
    }
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World lllllllllllllIIIIlIIIlIIIlIIIlII, final String lllllllllllllIIIIlIIIlIIIlIIIIll, final BlockPos lllllllllllllIIIIlIIIlIIIlIIIIlI, final boolean lllllllllllllIIIIlIIIlIIIIllllII) {
        if (!this.mapFeaturesEnabled) {
            return null;
        }
        if ("Stronghold".equals(lllllllllllllIIIIlIIIlIIIlIIIIll) && this.strongholdGenerator != null) {
            return this.strongholdGenerator.getClosestStrongholdPos(lllllllllllllIIIIlIIIlIIIlIIIlII, lllllllllllllIIIIlIIIlIIIlIIIIlI, lllllllllllllIIIIlIIIlIIIIllllII);
        }
        if ("Mansion".equals(lllllllllllllIIIIlIIIlIIIlIIIIll) && this.field_191060_C != null) {
            return this.field_191060_C.getClosestStrongholdPos(lllllllllllllIIIIlIIIlIIIlIIIlII, lllllllllllllIIIIlIIIlIIIlIIIIlI, lllllllllllllIIIIlIIIlIIIIllllII);
        }
        if ("Monument".equals(lllllllllllllIIIIlIIIlIIIlIIIIll) && this.oceanMonumentGenerator != null) {
            return this.oceanMonumentGenerator.getClosestStrongholdPos(lllllllllllllIIIIlIIIlIIIlIIIlII, lllllllllllllIIIIlIIIlIIIlIIIIlI, lllllllllllllIIIIlIIIlIIIIllllII);
        }
        if ("Village".equals(lllllllllllllIIIIlIIIlIIIlIIIIll) && this.villageGenerator != null) {
            return this.villageGenerator.getClosestStrongholdPos(lllllllllllllIIIIlIIIlIIIlIIIlII, lllllllllllllIIIIlIIIlIIIlIIIIlI, lllllllllllllIIIIlIIIlIIIIllllII);
        }
        if ("Mineshaft".equals(lllllllllllllIIIIlIIIlIIIlIIIIll) && this.mineshaftGenerator != null) {
            return this.mineshaftGenerator.getClosestStrongholdPos(lllllllllllllIIIIlIIIlIIIlIIIlII, lllllllllllllIIIIlIIIlIIIlIIIIlI, lllllllllllllIIIIlIIIlIIIIllllII);
        }
        return ("Temple".equals(lllllllllllllIIIIlIIIlIIIlIIIIll) && this.scatteredFeatureGenerator != null) ? this.scatteredFeatureGenerator.getClosestStrongholdPos(lllllllllllllIIIIlIIIlIIIlIIIlII, lllllllllllllIIIIlIIIlIIIlIIIIlI, lllllllllllllIIIIlIIIlIIIIllllII) : null;
    }
    
    @Override
    public boolean generateStructures(final Chunk lllllllllllllIIIIlIIIlIIIllIlIIl, final int lllllllllllllIIIIlIIIlIIIllIlIII, final int lllllllllllllIIIIlIIIlIIIllIIIlI) {
        boolean lllllllllllllIIIIlIIIlIIIllIIllI = false;
        if (this.settings.useMonuments && this.mapFeaturesEnabled && lllllllllllllIIIIlIIIlIIIllIlIIl.getInhabitedTime() < 3600L) {
            lllllllllllllIIIIlIIIlIIIllIIllI |= this.oceanMonumentGenerator.generateStructure(this.worldObj, this.rand, new ChunkPos(lllllllllllllIIIIlIIIlIIIllIlIII, lllllllllllllIIIIlIIIlIIIllIIIlI));
        }
        return lllllllllllllIIIIlIIIlIIIllIIllI;
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllIIIIlIIIlIlIIIIllIl, final int lllllllllllllIIIIlIIIlIlIIIIIlIl) {
        this.rand.setSeed(lllllllllllllIIIIlIIIlIlIIIIllIl * 341873128712L + lllllllllllllIIIIlIIIlIlIIIIIlIl * 132897987541L);
        final ChunkPrimer lllllllllllllIIIIlIIIlIlIIIIlIll = new ChunkPrimer();
        this.setBlocksInChunk(lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll);
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, lllllllllllllIIIIlIIIlIlIIIIllIl * 16, lllllllllllllIIIIlIIIlIlIIIIIlIl * 16, 16, 16);
        this.replaceBiomeBlocks(lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll, this.biomesForGeneration);
        if (this.settings.useCaves) {
            this.caveGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll);
        }
        if (this.settings.useRavines) {
            this.ravineGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll);
        }
        if (this.mapFeaturesEnabled) {
            if (this.settings.useMineShafts) {
                this.mineshaftGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll);
            }
            if (this.settings.useVillages) {
                this.villageGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll);
            }
            if (this.settings.useStrongholds) {
                this.strongholdGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll);
            }
            if (this.settings.useTemples) {
                this.scatteredFeatureGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll);
            }
            if (this.settings.useMonuments) {
                this.oceanMonumentGenerator.generate(this.worldObj, lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll);
            }
            if (this.settings.field_191077_z) {
                this.field_191060_C.generate(this.worldObj, lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl, lllllllllllllIIIIlIIIlIlIIIIlIll);
            }
        }
        final Chunk lllllllllllllIIIIlIIIlIlIIIIlIlI = new Chunk(this.worldObj, lllllllllllllIIIIlIIIlIlIIIIlIll, lllllllllllllIIIIlIIIlIlIIIIllIl, lllllllllllllIIIIlIIIlIlIIIIIlIl);
        final byte[] lllllllllllllIIIIlIIIlIlIIIIlIIl = lllllllllllllIIIIlIIIlIlIIIIlIlI.getBiomeArray();
        for (int lllllllllllllIIIIlIIIlIlIIIIlIII = 0; lllllllllllllIIIIlIIIlIlIIIIlIII < lllllllllllllIIIIlIIIlIlIIIIlIIl.length; ++lllllllllllllIIIIlIIIlIlIIIIlIII) {
            lllllllllllllIIIIlIIIlIlIIIIlIIl[lllllllllllllIIIIlIIIlIlIIIIlIII] = (byte)Biome.getIdForBiome(this.biomesForGeneration[lllllllllllllIIIIlIIIlIlIIIIlIII]);
        }
        lllllllllllllIIIIlIIIlIlIIIIlIlI.generateSkylightMap();
        return lllllllllllllIIIIlIIIlIlIIIIlIlI;
    }
    
    @Override
    public void populate(final int lllllllllllllIIIIlIIIlIIlIIlIllI, final int lllllllllllllIIIIlIIIlIIlIIlIlIl) {
        BlockFalling.fallInstantly = true;
        final int lllllllllllllIIIIlIIIlIIlIIlIlII = lllllllllllllIIIIlIIIlIIlIIlIllI * 16;
        final int lllllllllllllIIIIlIIIlIIlIIlIIll = lllllllllllllIIIIlIIIlIIlIIlIlIl * 16;
        BlockPos lllllllllllllIIIIlIIIlIIlIIlIIlI = new BlockPos(lllllllllllllIIIIlIIIlIIlIIlIlII, 0, lllllllllllllIIIIlIIIlIIlIIlIIll);
        final Biome lllllllllllllIIIIlIIIlIIlIIlIIIl = this.worldObj.getBiome(lllllllllllllIIIIlIIIlIIlIIlIIlI.add(16, 0, 16));
        this.rand.setSeed(this.worldObj.getSeed());
        final long lllllllllllllIIIIlIIIlIIlIIlIIII = this.rand.nextLong() / 2L * 2L + 1L;
        final long lllllllllllllIIIIlIIIlIIlIIIllll = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(lllllllllllllIIIIlIIIlIIlIIlIllI * lllllllllllllIIIIlIIIlIIlIIlIIII + lllllllllllllIIIIlIIIlIIlIIlIlIl * lllllllllllllIIIIlIIIlIIlIIIllll ^ this.worldObj.getSeed());
        boolean lllllllllllllIIIIlIIIlIIlIIIlllI = false;
        final ChunkPos lllllllllllllIIIIlIIIlIIlIIIllIl = new ChunkPos(lllllllllllllIIIIlIIIlIIlIIlIllI, lllllllllllllIIIIlIIIlIIlIIlIlIl);
        if (this.mapFeaturesEnabled) {
            if (this.settings.useMineShafts) {
                this.mineshaftGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIIlIIIllIl);
            }
            if (this.settings.useVillages) {
                lllllllllllllIIIIlIIIlIIlIIIlllI = this.villageGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIIlIIIllIl);
            }
            if (this.settings.useStrongholds) {
                this.strongholdGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIIlIIIllIl);
            }
            if (this.settings.useTemples) {
                this.scatteredFeatureGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIIlIIIllIl);
            }
            if (this.settings.useMonuments) {
                this.oceanMonumentGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIIlIIIllIl);
            }
            if (this.settings.field_191077_z) {
                this.field_191060_C.generateStructure(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIIlIIIllIl);
            }
        }
        if (lllllllllllllIIIIlIIIlIIlIIlIIIl != Biomes.DESERT && lllllllllllllIIIIlIIIlIIlIIlIIIl != Biomes.DESERT_HILLS && this.settings.useWaterLakes && !lllllllllllllIIIIlIIIlIIlIIIlllI && this.rand.nextInt(this.settings.waterLakeChance) == 0) {
            final int lllllllllllllIIIIlIIIlIIlIIIllII = this.rand.nextInt(16) + 8;
            final int lllllllllllllIIIIlIIIlIIlIIIlIll = this.rand.nextInt(256);
            final int lllllllllllllIIIIlIIIlIIlIIIlIlI = this.rand.nextInt(16) + 8;
            new WorldGenLakes(Blocks.WATER).generate(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIIlIIlIIlI.add(lllllllllllllIIIIlIIIlIIlIIIllII, lllllllllllllIIIIlIIIlIIlIIIlIll, lllllllllllllIIIIlIIIlIIlIIIlIlI));
        }
        if (!lllllllllllllIIIIlIIIlIIlIIIlllI && this.rand.nextInt(this.settings.lavaLakeChance / 10) == 0 && this.settings.useLavaLakes) {
            final int lllllllllllllIIIIlIIIlIIlIIIlIIl = this.rand.nextInt(16) + 8;
            final int lllllllllllllIIIIlIIIlIIlIIIlIII = this.rand.nextInt(this.rand.nextInt(248) + 8);
            final int lllllllllllllIIIIlIIIlIIlIIIIlll = this.rand.nextInt(16) + 8;
            if (lllllllllllllIIIIlIIIlIIlIIIlIII < this.worldObj.getSeaLevel() || this.rand.nextInt(this.settings.lavaLakeChance / 8) == 0) {
                new WorldGenLakes(Blocks.LAVA).generate(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIIlIIlIIlI.add(lllllllllllllIIIIlIIIlIIlIIIlIIl, lllllllllllllIIIIlIIIlIIlIIIlIII, lllllllllllllIIIIlIIIlIIlIIIIlll));
            }
        }
        if (this.settings.useDungeons) {
            for (int lllllllllllllIIIIlIIIlIIlIIIIllI = 0; lllllllllllllIIIIlIIIlIIlIIIIllI < this.settings.dungeonChance; ++lllllllllllllIIIIlIIIlIIlIIIIllI) {
                final int lllllllllllllIIIIlIIIlIIlIIIIlIl = this.rand.nextInt(16) + 8;
                final int lllllllllllllIIIIlIIIlIIlIIIIlII = this.rand.nextInt(256);
                final int lllllllllllllIIIIlIIIlIIlIIIIIll = this.rand.nextInt(16) + 8;
                new WorldGenDungeons().generate(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIIlIIlIIlI.add(lllllllllllllIIIIlIIIlIIlIIIIlIl, lllllllllllllIIIIlIIIlIIlIIIIlII, lllllllllllllIIIIlIIIlIIlIIIIIll));
            }
        }
        lllllllllllllIIIIlIIIlIIlIIlIIIl.decorate(this.worldObj, this.rand, new BlockPos(lllllllllllllIIIIlIIIlIIlIIlIlII, 0, lllllllllllllIIIIlIIIlIIlIIlIIll));
        WorldEntitySpawner.performWorldGenSpawning(this.worldObj, lllllllllllllIIIIlIIIlIIlIIlIIIl, lllllllllllllIIIIlIIIlIIlIIlIlII + 8, lllllllllllllIIIIlIIIlIIlIIlIIll + 8, 16, 16, this.rand);
        lllllllllllllIIIIlIIIlIIlIIlIIlI = lllllllllllllIIIIlIIIlIIlIIlIIlI.add(8, 0, 8);
        for (int lllllllllllllIIIIlIIIlIIlIIIIIlI = 0; lllllllllllllIIIIlIIIlIIlIIIIIlI < 16; ++lllllllllllllIIIIlIIIlIIlIIIIIlI) {
            for (int lllllllllllllIIIIlIIIlIIlIIIIIIl = 0; lllllllllllllIIIIlIIIlIIlIIIIIIl < 16; ++lllllllllllllIIIIlIIIlIIlIIIIIIl) {
                final BlockPos lllllllllllllIIIIlIIIlIIlIIIIIII = this.worldObj.getPrecipitationHeight(lllllllllllllIIIIlIIIlIIlIIlIIlI.add(lllllllllllllIIIIlIIIlIIlIIIIIlI, 0, lllllllllllllIIIIlIIIlIIlIIIIIIl));
                final BlockPos lllllllllllllIIIIlIIIlIIIlllllll = lllllllllllllIIIIlIIIlIIlIIIIIII.down();
                if (this.worldObj.canBlockFreezeWater(lllllllllllllIIIIlIIIlIIIlllllll)) {
                    this.worldObj.setBlockState(lllllllllllllIIIIlIIIlIIIlllllll, Blocks.ICE.getDefaultState(), 2);
                }
                if (this.worldObj.canSnowAt(lllllllllllllIIIIlIIIlIIlIIIIIII, true)) {
                    this.worldObj.setBlockState(lllllllllllllIIIIlIIIlIIlIIIIIII, Blocks.SNOW_LAYER.getDefaultState(), 2);
                }
            }
        }
        BlockFalling.fallInstantly = false;
    }
    
    static {
        STONE = Blocks.STONE.getDefaultState();
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType lllllllllllllIIIIlIIIlIIIlIlIlll, final BlockPos lllllllllllllIIIIlIIIlIIIlIlIllI) {
        final Biome lllllllllllllIIIIlIIIlIIIlIllIIl = this.worldObj.getBiome(lllllllllllllIIIIlIIIlIIIlIlIllI);
        if (this.mapFeaturesEnabled) {
            if (lllllllllllllIIIIlIIIlIIIlIlIlll == EnumCreatureType.MONSTER && this.scatteredFeatureGenerator.isSwampHut(lllllllllllllIIIIlIIIlIIIlIlIllI)) {
                return this.scatteredFeatureGenerator.getScatteredFeatureSpawnList();
            }
            if (lllllllllllllIIIIlIIIlIIIlIlIlll == EnumCreatureType.MONSTER && this.settings.useMonuments && this.oceanMonumentGenerator.isPositionInStructure(this.worldObj, lllllllllllllIIIIlIIIlIIIlIlIllI)) {
                return this.oceanMonumentGenerator.getScatteredFeatureSpawnList();
            }
        }
        return lllllllllllllIIIIlIIIlIIIlIllIIl.getSpawnableList(lllllllllllllIIIIlIIIlIIIlIlIlll);
    }
    
    public void replaceBiomeBlocks(final int lllllllllllllIIIIlIIIlIlIIIlllIl, final int lllllllllllllIIIIlIIIlIlIIIlllII, final ChunkPrimer lllllllllllllIIIIlIIIlIlIIlIIlII, final Biome[] lllllllllllllIIIIlIIIlIlIIIllIlI) {
        final double lllllllllllllIIIIlIIIlIlIIlIIIlI = 0.03125;
        this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, lllllllllllllIIIIlIIIlIlIIIlllIl * 16, lllllllllllllIIIIlIIIlIlIIIlllII * 16, 16, 16, 0.0625, 0.0625, 1.0);
        for (int lllllllllllllIIIIlIIIlIlIIlIIIIl = 0; lllllllllllllIIIIlIIIlIlIIlIIIIl < 16; ++lllllllllllllIIIIlIIIlIlIIlIIIIl) {
            for (int lllllllllllllIIIIlIIIlIlIIlIIIII = 0; lllllllllllllIIIIlIIIlIlIIlIIIII < 16; ++lllllllllllllIIIIlIIIlIlIIlIIIII) {
                final Biome lllllllllllllIIIIlIIIlIlIIIlllll = lllllllllllllIIIIlIIIlIlIIIllIlI[lllllllllllllIIIIlIIIlIlIIlIIIII + lllllllllllllIIIIlIIIlIlIIlIIIIl * 16];
                lllllllllllllIIIIlIIIlIlIIIlllll.genTerrainBlocks(this.worldObj, this.rand, lllllllllllllIIIIlIIIlIlIIlIIlII, lllllllllllllIIIIlIIIlIlIIIlllIl * 16 + lllllllllllllIIIIlIIIlIlIIlIIIIl, lllllllllllllIIIIlIIIlIlIIIlllII * 16 + lllllllllllllIIIIlIIIlIlIIlIIIII, this.depthBuffer[lllllllllllllIIIIlIIIlIlIIlIIIII + lllllllllllllIIIIlIIIlIlIIlIIIIl * 16]);
            }
        }
    }
}
