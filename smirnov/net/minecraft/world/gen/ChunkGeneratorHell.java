// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.world.biome.Biome;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.block.Block;
import com.google.common.base.Predicate;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenFire;
import net.minecraft.world.gen.feature.WorldGenGlowStone2;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.block.state.IBlockState;

public class ChunkGeneratorHell implements IChunkGenerator
{
    public final /* synthetic */ NoiseGeneratorOctaves scaleNoise;
    protected static final /* synthetic */ IBlockState NETHERRACK;
    public final /* synthetic */ NoiseGeneratorOctaves depthNoise;
    private final /* synthetic */ WorldGenerator magmaGen;
    private /* synthetic */ double[] depthBuffer;
    private final /* synthetic */ WorldGenBush redMushroomFeature;
    /* synthetic */ double[] br;
    private final /* synthetic */ WorldGenBush brownMushroomFeature;
    protected static final /* synthetic */ IBlockState AIR;
    /* synthetic */ double[] dr;
    protected static final /* synthetic */ IBlockState SOUL_SAND;
    private final /* synthetic */ NoiseGeneratorOctaves perlinNoise1;
    private final /* synthetic */ Random rand;
    /* synthetic */ double[] pnr;
    private final /* synthetic */ NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
    protected static final /* synthetic */ IBlockState GRAVEL;
    private final /* synthetic */ MapGenNetherBridge genNetherBridge;
    private /* synthetic */ double[] buffer;
    private final /* synthetic */ NoiseGeneratorOctaves lperlinNoise1;
    private /* synthetic */ double[] slowsandNoise;
    private final /* synthetic */ boolean generateStructures;
    private final /* synthetic */ WorldGenHellLava hellSpringGen;
    protected static final /* synthetic */ IBlockState LAVA;
    private final /* synthetic */ World world;
    private final /* synthetic */ WorldGenGlowStone2 hellPortalGen;
    /* synthetic */ double[] noiseData4;
    private final /* synthetic */ WorldGenFire fireFeature;
    private final /* synthetic */ NoiseGeneratorOctaves lperlinNoise2;
    private final /* synthetic */ WorldGenGlowStone1 lightGemGen;
    protected static final /* synthetic */ IBlockState BEDROCK;
    private final /* synthetic */ WorldGenerator quartzGen;
    private final /* synthetic */ WorldGenHellLava lavaTrapGen;
    private final /* synthetic */ NoiseGeneratorOctaves slowsandGravelNoiseGen;
    private /* synthetic */ double[] gravelNoise;
    private final /* synthetic */ MapGenBase genNetherCaves;
    /* synthetic */ double[] ar;
    
    @Override
    public boolean generateStructures(final Chunk lllllllllllllllllIlIlIlIIIIlllIl, final int lllllllllllllllllIlIlIlIIIIlllII, final int lllllllllllllllllIlIlIlIIIIllIll) {
        return false;
    }
    
    @Override
    public boolean func_193414_a(final World lllllllllllllllllIlIlIIllllllIll, final String lllllllllllllllllIlIlIIlllllIlll, final BlockPos lllllllllllllllllIlIlIIlllllIllI) {
        return "Fortress".equals(lllllllllllllllllIlIlIIlllllIlll) && this.genNetherBridge != null && this.genNetherBridge.isInsideStructure(lllllllllllllllllIlIlIIlllllIllI);
    }
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World lllllllllllllllllIlIlIlIIIIIlIII, final String lllllllllllllllllIlIlIlIIIIIIlll, final BlockPos lllllllllllllllllIlIlIlIIIIIIIIl, final boolean lllllllllllllllllIlIlIlIIIIIIIII) {
        return ("Fortress".equals(lllllllllllllllllIlIlIlIIIIIIlll) && this.genNetherBridge != null) ? this.genNetherBridge.getClosestStrongholdPos(lllllllllllllllllIlIlIlIIIIIlIII, lllllllllllllllllIlIlIlIIIIIIIIl, lllllllllllllllllIlIlIlIIIIIIIII) : null;
    }
    
    private double[] getHeights(double[] lllllllllllllllllIlIlIlIIlIlIlll, final int lllllllllllllllllIlIlIlIIlllIIIl, final int lllllllllllllllllIlIlIlIIlIlIlIl, final int lllllllllllllllllIlIlIlIIlIlIlII, final int lllllllllllllllllIlIlIlIIllIlllI, final int lllllllllllllllllIlIlIlIIllIllIl, final int lllllllllllllllllIlIlIlIIllIllII) {
        if (lllllllllllllllllIlIlIlIIlIlIlll == null) {
            lllllllllllllllllIlIlIlIIlIlIlll = new double[lllllllllllllllllIlIlIlIIllIlllI * lllllllllllllllllIlIlIlIIllIllIl * lllllllllllllllllIlIlIlIIllIllII];
        }
        final double lllllllllllllllllIlIlIlIIllIlIll = 684.412;
        final double lllllllllllllllllIlIlIlIIllIlIlI = 2053.236;
        this.noiseData4 = this.scaleNoise.generateNoiseOctaves(this.noiseData4, lllllllllllllllllIlIlIlIIlllIIIl, lllllllllllllllllIlIlIlIIlIlIlIl, lllllllllllllllllIlIlIlIIlIlIlII, lllllllllllllllllIlIlIlIIllIlllI, 1, lllllllllllllllllIlIlIlIIllIllII, 1.0, 0.0, 1.0);
        this.dr = this.depthNoise.generateNoiseOctaves(this.dr, lllllllllllllllllIlIlIlIIlllIIIl, lllllllllllllllllIlIlIlIIlIlIlIl, lllllllllllllllllIlIlIlIIlIlIlII, lllllllllllllllllIlIlIlIIllIlllI, 1, lllllllllllllllllIlIlIlIIllIllII, 100.0, 0.0, 100.0);
        this.pnr = this.perlinNoise1.generateNoiseOctaves(this.pnr, lllllllllllllllllIlIlIlIIlllIIIl, lllllllllllllllllIlIlIlIIlIlIlIl, lllllllllllllllllIlIlIlIIlIlIlII, lllllllllllllllllIlIlIlIIllIlllI, lllllllllllllllllIlIlIlIIllIllIl, lllllllllllllllllIlIlIlIIllIllII, 8.555150000000001, 34.2206, 8.555150000000001);
        this.ar = this.lperlinNoise1.generateNoiseOctaves(this.ar, lllllllllllllllllIlIlIlIIlllIIIl, lllllllllllllllllIlIlIlIIlIlIlIl, lllllllllllllllllIlIlIlIIlIlIlII, lllllllllllllllllIlIlIlIIllIlllI, lllllllllllllllllIlIlIlIIllIllIl, lllllllllllllllllIlIlIlIIllIllII, 684.412, 2053.236, 684.412);
        this.br = this.lperlinNoise2.generateNoiseOctaves(this.br, lllllllllllllllllIlIlIlIIlllIIIl, lllllllllllllllllIlIlIlIIlIlIlIl, lllllllllllllllllIlIlIlIIlIlIlII, lllllllllllllllllIlIlIlIIllIlllI, lllllllllllllllllIlIlIlIIllIllIl, lllllllllllllllllIlIlIlIIllIllII, 684.412, 2053.236, 684.412);
        int lllllllllllllllllIlIlIlIIllIlIIl = 0;
        final double[] lllllllllllllllllIlIlIlIIllIlIII = new double[lllllllllllllllllIlIlIlIIllIllIl];
        for (int lllllllllllllllllIlIlIlIIllIIlll = 0; lllllllllllllllllIlIlIlIIllIIlll < lllllllllllllllllIlIlIlIIllIllIl; ++lllllllllllllllllIlIlIlIIllIIlll) {
            lllllllllllllllllIlIlIlIIllIlIII[lllllllllllllllllIlIlIlIIllIIlll] = Math.cos(lllllllllllllllllIlIlIlIIllIIlll * 3.141592653589793 * 6.0 / lllllllllllllllllIlIlIlIIllIllIl) * 2.0;
            double lllllllllllllllllIlIlIlIIllIIllI = lllllllllllllllllIlIlIlIIllIIlll;
            if (lllllllllllllllllIlIlIlIIllIIlll > lllllllllllllllllIlIlIlIIllIllIl / 2) {
                lllllllllllllllllIlIlIlIIllIIllI = lllllllllllllllllIlIlIlIIllIllIl - 1 - lllllllllllllllllIlIlIlIIllIIlll;
            }
            if (lllllllllllllllllIlIlIlIIllIIllI < 4.0) {
                lllllllllllllllllIlIlIlIIllIIllI = 4.0 - lllllllllllllllllIlIlIlIIllIIllI;
                final double[] array = lllllllllllllllllIlIlIlIIllIlIII;
                final int n = lllllllllllllllllIlIlIlIIllIIlll;
                array[n] -= lllllllllllllllllIlIlIlIIllIIllI * lllllllllllllllllIlIlIlIIllIIllI * lllllllllllllllllIlIlIlIIllIIllI * 10.0;
            }
        }
        for (int lllllllllllllllllIlIlIlIIllIIlIl = 0; lllllllllllllllllIlIlIlIIllIIlIl < lllllllllllllllllIlIlIlIIllIlllI; ++lllllllllllllllllIlIlIlIIllIIlIl) {
            for (int lllllllllllllllllIlIlIlIIllIIlII = 0; lllllllllllllllllIlIlIlIIllIIlII < lllllllllllllllllIlIlIlIIllIllII; ++lllllllllllllllllIlIlIlIIllIIlII) {
                final double lllllllllllllllllIlIlIlIIllIIIll = 0.0;
                for (int lllllllllllllllllIlIlIlIIllIIIlI = 0; lllllllllllllllllIlIlIlIIllIIIlI < lllllllllllllllllIlIlIlIIllIllIl; ++lllllllllllllllllIlIlIlIIllIIIlI) {
                    final double lllllllllllllllllIlIlIlIIllIIIIl = lllllllllllllllllIlIlIlIIllIlIII[lllllllllllllllllIlIlIlIIllIIIlI];
                    final double lllllllllllllllllIlIlIlIIllIIIII = this.ar[lllllllllllllllllIlIlIlIIllIlIIl] / 512.0;
                    final double lllllllllllllllllIlIlIlIIlIlllll = this.br[lllllllllllllllllIlIlIlIIllIlIIl] / 512.0;
                    final double lllllllllllllllllIlIlIlIIlIllllI = (this.pnr[lllllllllllllllllIlIlIlIIllIlIIl] / 10.0 + 1.0) / 2.0;
                    double lllllllllllllllllIlIlIlIIlIllIll = 0.0;
                    if (lllllllllllllllllIlIlIlIIlIllllI < 0.0) {
                        final double lllllllllllllllllIlIlIlIIlIlllIl = lllllllllllllllllIlIlIlIIllIIIII;
                    }
                    else if (lllllllllllllllllIlIlIlIIlIllllI > 1.0) {
                        final double lllllllllllllllllIlIlIlIIlIlllII = lllllllllllllllllIlIlIlIIlIlllll;
                    }
                    else {
                        lllllllllllllllllIlIlIlIIlIllIll = lllllllllllllllllIlIlIlIIllIIIII + (lllllllllllllllllIlIlIlIIlIlllll - lllllllllllllllllIlIlIlIIllIIIII) * lllllllllllllllllIlIlIlIIlIllllI;
                    }
                    lllllllllllllllllIlIlIlIIlIllIll -= lllllllllllllllllIlIlIlIIllIIIIl;
                    if (lllllllllllllllllIlIlIlIIllIIIlI > lllllllllllllllllIlIlIlIIllIllIl - 4) {
                        final double lllllllllllllllllIlIlIlIIlIllIlI = (lllllllllllllllllIlIlIlIIllIIIlI - (lllllllllllllllllIlIlIlIIllIllIl - 4)) / 3.0f;
                        lllllllllllllllllIlIlIlIIlIllIll = lllllllllllllllllIlIlIlIIlIllIll * (1.0 - lllllllllllllllllIlIlIlIIlIllIlI) + -10.0 * lllllllllllllllllIlIlIlIIlIllIlI;
                    }
                    if (lllllllllllllllllIlIlIlIIllIIIlI < 0.0) {
                        double lllllllllllllllllIlIlIlIIlIllIIl = (0.0 - lllllllllllllllllIlIlIlIIllIIIlI) / 4.0;
                        lllllllllllllllllIlIlIlIIlIllIIl = MathHelper.clamp(lllllllllllllllllIlIlIlIIlIllIIl, 0.0, 1.0);
                        lllllllllllllllllIlIlIlIIlIllIll = lllllllllllllllllIlIlIlIIlIllIll * (1.0 - lllllllllllllllllIlIlIlIIlIllIIl) + -10.0 * lllllllllllllllllIlIlIlIIlIllIIl;
                    }
                    lllllllllllllllllIlIlIlIIlIlIlll[lllllllllllllllllIlIlIlIIllIlIIl] = lllllllllllllllllIlIlIlIIlIllIll;
                    ++lllllllllllllllllIlIlIlIIllIlIIl;
                }
            }
        }
        return lllllllllllllllllIlIlIlIIlIlIlll;
    }
    
    public ChunkGeneratorHell(final World lllllllllllllllllIlIlIllIlIIIlII, final boolean lllllllllllllllllIlIlIllIlIIIIll, final long lllllllllllllllllIlIlIllIIlllllI) {
        this.slowsandNoise = new double[256];
        this.gravelNoise = new double[256];
        this.depthBuffer = new double[256];
        this.fireFeature = new WorldGenFire();
        this.lightGemGen = new WorldGenGlowStone1();
        this.hellPortalGen = new WorldGenGlowStone2();
        this.quartzGen = new WorldGenMinable(Blocks.QUARTZ_ORE.getDefaultState(), 14, (Predicate<IBlockState>)BlockMatcher.forBlock(Blocks.NETHERRACK));
        this.magmaGen = new WorldGenMinable(Blocks.MAGMA.getDefaultState(), 33, (Predicate<IBlockState>)BlockMatcher.forBlock(Blocks.NETHERRACK));
        this.lavaTrapGen = new WorldGenHellLava(Blocks.FLOWING_LAVA, true);
        this.hellSpringGen = new WorldGenHellLava(Blocks.FLOWING_LAVA, false);
        this.brownMushroomFeature = new WorldGenBush(Blocks.BROWN_MUSHROOM);
        this.redMushroomFeature = new WorldGenBush(Blocks.RED_MUSHROOM);
        this.genNetherBridge = new MapGenNetherBridge();
        this.genNetherCaves = new MapGenCavesHell();
        this.world = lllllllllllllllllIlIlIllIlIIIlII;
        this.generateStructures = lllllllllllllllllIlIlIllIlIIIIll;
        this.rand = new Random(lllllllllllllllllIlIlIllIIlllllI);
        this.lperlinNoise1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.lperlinNoise2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.perlinNoise1 = new NoiseGeneratorOctaves(this.rand, 8);
        this.slowsandGravelNoiseGen = new NoiseGeneratorOctaves(this.rand, 4);
        this.netherrackExculsivityNoiseGen = new NoiseGeneratorOctaves(this.rand, 4);
        this.scaleNoise = new NoiseGeneratorOctaves(this.rand, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
        lllllllllllllllllIlIlIllIlIIIlII.setSeaLevel(63);
    }
    
    public void prepareHeights(final int lllllllllllllllllIlIlIllIIIllIII, final int lllllllllllllllllIlIlIllIIIlIlll, final ChunkPrimer lllllllllllllllllIlIlIlIllllIIlI) {
        final int lllllllllllllllllIlIlIllIIIlIlIl = 4;
        final int lllllllllllllllllIlIlIllIIIlIlII = this.world.getSeaLevel() / 2 + 1;
        final int lllllllllllllllllIlIlIllIIIlIIll = 5;
        final int lllllllllllllllllIlIlIllIIIlIIlI = 17;
        final int lllllllllllllllllIlIlIllIIIlIIIl = 5;
        this.buffer = this.getHeights(this.buffer, lllllllllllllllllIlIlIllIIIllIII * 4, 0, lllllllllllllllllIlIlIllIIIlIlll * 4, 5, 17, 5);
        for (int lllllllllllllllllIlIlIllIIIlIIII = 0; lllllllllllllllllIlIlIllIIIlIIII < 4; ++lllllllllllllllllIlIlIllIIIlIIII) {
            for (int lllllllllllllllllIlIlIllIIIIllll = 0; lllllllllllllllllIlIlIllIIIIllll < 4; ++lllllllllllllllllIlIlIllIIIIllll) {
                for (int lllllllllllllllllIlIlIllIIIIlllI = 0; lllllllllllllllllIlIlIllIIIIlllI < 16; ++lllllllllllllllllIlIlIllIIIIlllI) {
                    final double lllllllllllllllllIlIlIllIIIIllIl = 0.125;
                    double lllllllllllllllllIlIlIllIIIIllII = this.buffer[((lllllllllllllllllIlIlIllIIIlIIII + 0) * 5 + lllllllllllllllllIlIlIllIIIIllll + 0) * 17 + lllllllllllllllllIlIlIllIIIIlllI + 0];
                    double lllllllllllllllllIlIlIllIIIIlIll = this.buffer[((lllllllllllllllllIlIlIllIIIlIIII + 0) * 5 + lllllllllllllllllIlIlIllIIIIllll + 1) * 17 + lllllllllllllllllIlIlIllIIIIlllI + 0];
                    double lllllllllllllllllIlIlIllIIIIlIlI = this.buffer[((lllllllllllllllllIlIlIllIIIlIIII + 1) * 5 + lllllllllllllllllIlIlIllIIIIllll + 0) * 17 + lllllllllllllllllIlIlIllIIIIlllI + 0];
                    double lllllllllllllllllIlIlIllIIIIlIIl = this.buffer[((lllllllllllllllllIlIlIllIIIlIIII + 1) * 5 + lllllllllllllllllIlIlIllIIIIllll + 1) * 17 + lllllllllllllllllIlIlIllIIIIlllI + 0];
                    final double lllllllllllllllllIlIlIllIIIIlIII = (this.buffer[((lllllllllllllllllIlIlIllIIIlIIII + 0) * 5 + lllllllllllllllllIlIlIllIIIIllll + 0) * 17 + lllllllllllllllllIlIlIllIIIIlllI + 1] - lllllllllllllllllIlIlIllIIIIllII) * 0.125;
                    final double lllllllllllllllllIlIlIllIIIIIlll = (this.buffer[((lllllllllllllllllIlIlIllIIIlIIII + 0) * 5 + lllllllllllllllllIlIlIllIIIIllll + 1) * 17 + lllllllllllllllllIlIlIllIIIIlllI + 1] - lllllllllllllllllIlIlIllIIIIlIll) * 0.125;
                    final double lllllllllllllllllIlIlIllIIIIIllI = (this.buffer[((lllllllllllllllllIlIlIllIIIlIIII + 1) * 5 + lllllllllllllllllIlIlIllIIIIllll + 0) * 17 + lllllllllllllllllIlIlIllIIIIlllI + 1] - lllllllllllllllllIlIlIllIIIIlIlI) * 0.125;
                    final double lllllllllllllllllIlIlIllIIIIIlIl = (this.buffer[((lllllllllllllllllIlIlIllIIIlIIII + 1) * 5 + lllllllllllllllllIlIlIllIIIIllll + 1) * 17 + lllllllllllllllllIlIlIllIIIIlllI + 1] - lllllllllllllllllIlIlIllIIIIlIIl) * 0.125;
                    for (int lllllllllllllllllIlIlIllIIIIIlII = 0; lllllllllllllllllIlIlIllIIIIIlII < 8; ++lllllllllllllllllIlIlIllIIIIIlII) {
                        final double lllllllllllllllllIlIlIllIIIIIIll = 0.25;
                        double lllllllllllllllllIlIlIllIIIIIIlI = lllllllllllllllllIlIlIllIIIIllII;
                        double lllllllllllllllllIlIlIllIIIIIIIl = lllllllllllllllllIlIlIllIIIIlIll;
                        final double lllllllllllllllllIlIlIllIIIIIIII = (lllllllllllllllllIlIlIllIIIIlIlI - lllllllllllllllllIlIlIllIIIIllII) * 0.25;
                        final double lllllllllllllllllIlIlIlIllllllll = (lllllllllllllllllIlIlIllIIIIlIIl - lllllllllllllllllIlIlIllIIIIlIll) * 0.25;
                        for (int lllllllllllllllllIlIlIlIlllllllI = 0; lllllllllllllllllIlIlIlIlllllllI < 4; ++lllllllllllllllllIlIlIlIlllllllI) {
                            final double lllllllllllllllllIlIlIlIllllllIl = 0.25;
                            double lllllllllllllllllIlIlIlIllllllII = lllllllllllllllllIlIlIllIIIIIIlI;
                            final double lllllllllllllllllIlIlIlIlllllIll = (lllllllllllllllllIlIlIllIIIIIIIl - lllllllllllllllllIlIlIllIIIIIIlI) * 0.25;
                            for (int lllllllllllllllllIlIlIlIlllllIlI = 0; lllllllllllllllllIlIlIlIlllllIlI < 4; ++lllllllllllllllllIlIlIlIlllllIlI) {
                                IBlockState lllllllllllllllllIlIlIlIlllllIIl = null;
                                if (lllllllllllllllllIlIlIllIIIIlllI * 8 + lllllllllllllllllIlIlIllIIIIIlII < lllllllllllllllllIlIlIllIIIlIlII) {
                                    lllllllllllllllllIlIlIlIlllllIIl = ChunkGeneratorHell.LAVA;
                                }
                                if (lllllllllllllllllIlIlIlIllllllII > 0.0) {
                                    lllllllllllllllllIlIlIlIlllllIIl = ChunkGeneratorHell.NETHERRACK;
                                }
                                final int lllllllllllllllllIlIlIlIlllllIII = lllllllllllllllllIlIlIlIlllllllI + lllllllllllllllllIlIlIllIIIlIIII * 4;
                                final int lllllllllllllllllIlIlIlIllllIlll = lllllllllllllllllIlIlIllIIIIIlII + lllllllllllllllllIlIlIllIIIIlllI * 8;
                                final int lllllllllllllllllIlIlIlIllllIllI = lllllllllllllllllIlIlIlIlllllIlI + lllllllllllllllllIlIlIllIIIIllll * 4;
                                lllllllllllllllllIlIlIlIllllIIlI.setBlockState(lllllllllllllllllIlIlIlIlllllIII, lllllllllllllllllIlIlIlIllllIlll, lllllllllllllllllIlIlIlIllllIllI, lllllllllllllllllIlIlIlIlllllIIl);
                                lllllllllllllllllIlIlIlIllllllII += lllllllllllllllllIlIlIlIlllllIll;
                            }
                            lllllllllllllllllIlIlIllIIIIIIlI += lllllllllllllllllIlIlIllIIIIIIII;
                            lllllllllllllllllIlIlIllIIIIIIIl += lllllllllllllllllIlIlIlIllllllll;
                        }
                        lllllllllllllllllIlIlIllIIIIllII += lllllllllllllllllIlIlIllIIIIlIII;
                        lllllllllllllllllIlIlIllIIIIlIll += lllllllllllllllllIlIlIllIIIIIlll;
                        lllllllllllllllllIlIlIllIIIIlIlI += lllllllllllllllllIlIlIllIIIIIllI;
                        lllllllllllllllllIlIlIllIIIIlIIl += lllllllllllllllllIlIlIllIIIIIlIl;
                    }
                }
            }
        }
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType lllllllllllllllllIlIlIlIIIIlIIIl, final BlockPos lllllllllllllllllIlIlIlIIIIlIIII) {
        if (lllllllllllllllllIlIlIlIIIIlIIIl == EnumCreatureType.MONSTER) {
            if (this.genNetherBridge.isInsideStructure(lllllllllllllllllIlIlIlIIIIlIIII)) {
                return this.genNetherBridge.getSpawnList();
            }
            if (this.genNetherBridge.isPositionInStructure(this.world, lllllllllllllllllIlIlIlIIIIlIIII) && this.world.getBlockState(lllllllllllllllllIlIlIlIIIIlIIII.down()).getBlock() == Blocks.NETHER_BRICK) {
                return this.genNetherBridge.getSpawnList();
            }
        }
        final Biome lllllllllllllllllIlIlIlIIIIlIIll = this.world.getBiome(lllllllllllllllllIlIlIlIIIIlIIII);
        return lllllllllllllllllIlIlIlIIIIlIIll.getSpawnableList(lllllllllllllllllIlIlIlIIIIlIIIl);
    }
    
    @Override
    public void recreateStructures(final Chunk lllllllllllllllllIlIlIIlllllIIIl, final int lllllllllllllllllIlIlIIlllllIIII, final int lllllllllllllllllIlIlIIllllIllII) {
        this.genNetherBridge.generate(this.world, lllllllllllllllllIlIlIIlllllIIII, lllllllllllllllllIlIlIIllllIllII, null);
    }
    
    public void buildSurfaces(final int lllllllllllllllllIlIlIlIllIIIIII, final int lllllllllllllllllIlIlIlIlIllllll, final ChunkPrimer lllllllllllllllllIlIlIlIlIlIlllI) {
        final int lllllllllllllllllIlIlIlIlIllllIl = this.world.getSeaLevel() + 1;
        final double lllllllllllllllllIlIlIlIlIllllII = 0.03125;
        this.slowsandNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.slowsandNoise, lllllllllllllllllIlIlIlIllIIIIII * 16, lllllllllllllllllIlIlIlIlIllllll * 16, 0, 16, 16, 1, 0.03125, 0.03125, 1.0);
        this.gravelNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.gravelNoise, lllllllllllllllllIlIlIlIllIIIIII * 16, 109, lllllllllllllllllIlIlIlIlIllllll * 16, 16, 1, 16, 0.03125, 1.0, 0.03125);
        this.depthBuffer = this.netherrackExculsivityNoiseGen.generateNoiseOctaves(this.depthBuffer, lllllllllllllllllIlIlIlIllIIIIII * 16, lllllllllllllllllIlIlIlIlIllllll * 16, 0, 16, 16, 1, 0.0625, 0.0625, 0.0625);
        for (int lllllllllllllllllIlIlIlIlIlllIll = 0; lllllllllllllllllIlIlIlIlIlllIll < 16; ++lllllllllllllllllIlIlIlIlIlllIll) {
            for (int lllllllllllllllllIlIlIlIlIlllIlI = 0; lllllllllllllllllIlIlIlIlIlllIlI < 16; ++lllllllllllllllllIlIlIlIlIlllIlI) {
                final boolean lllllllllllllllllIlIlIlIlIlllIIl = this.slowsandNoise[lllllllllllllllllIlIlIlIlIlllIll + lllllllllllllllllIlIlIlIlIlllIlI * 16] + this.rand.nextDouble() * 0.2 > 0.0;
                final boolean lllllllllllllllllIlIlIlIlIlllIII = this.gravelNoise[lllllllllllllllllIlIlIlIlIlllIll + lllllllllllllllllIlIlIlIlIlllIlI * 16] + this.rand.nextDouble() * 0.2 > 0.0;
                final int lllllllllllllllllIlIlIlIlIllIlll = (int)(this.depthBuffer[lllllllllllllllllIlIlIlIlIlllIll + lllllllllllllllllIlIlIlIlIlllIlI * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int lllllllllllllllllIlIlIlIlIllIllI = -1;
                IBlockState lllllllllllllllllIlIlIlIlIllIlIl = ChunkGeneratorHell.NETHERRACK;
                IBlockState lllllllllllllllllIlIlIlIlIllIlII = ChunkGeneratorHell.NETHERRACK;
                for (int lllllllllllllllllIlIlIlIlIllIIll = 127; lllllllllllllllllIlIlIlIlIllIIll >= 0; --lllllllllllllllllIlIlIlIlIllIIll) {
                    if (lllllllllllllllllIlIlIlIlIllIIll < 127 - this.rand.nextInt(5) && lllllllllllllllllIlIlIlIlIllIIll > this.rand.nextInt(5)) {
                        final IBlockState lllllllllllllllllIlIlIlIlIllIIlI = lllllllllllllllllIlIlIlIlIlIlllI.getBlockState(lllllllllllllllllIlIlIlIlIlllIlI, lllllllllllllllllIlIlIlIlIllIIll, lllllllllllllllllIlIlIlIlIlllIll);
                        if (lllllllllllllllllIlIlIlIlIllIIlI.getBlock() != null && lllllllllllllllllIlIlIlIlIllIIlI.getMaterial() != Material.AIR) {
                            if (lllllllllllllllllIlIlIlIlIllIIlI.getBlock() == Blocks.NETHERRACK) {
                                if (lllllllllllllllllIlIlIlIlIllIllI == -1) {
                                    if (lllllllllllllllllIlIlIlIlIllIlll <= 0) {
                                        lllllllllllllllllIlIlIlIlIllIlIl = ChunkGeneratorHell.AIR;
                                        lllllllllllllllllIlIlIlIlIllIlII = ChunkGeneratorHell.NETHERRACK;
                                    }
                                    else if (lllllllllllllllllIlIlIlIlIllIIll >= lllllllllllllllllIlIlIlIlIllllIl - 4 && lllllllllllllllllIlIlIlIlIllIIll <= lllllllllllllllllIlIlIlIlIllllIl + 1) {
                                        lllllllllllllllllIlIlIlIlIllIlIl = ChunkGeneratorHell.NETHERRACK;
                                        lllllllllllllllllIlIlIlIlIllIlII = ChunkGeneratorHell.NETHERRACK;
                                        if (lllllllllllllllllIlIlIlIlIlllIII) {
                                            lllllllllllllllllIlIlIlIlIllIlIl = ChunkGeneratorHell.GRAVEL;
                                            lllllllllllllllllIlIlIlIlIllIlII = ChunkGeneratorHell.NETHERRACK;
                                        }
                                        if (lllllllllllllllllIlIlIlIlIlllIIl) {
                                            lllllllllllllllllIlIlIlIlIllIlIl = ChunkGeneratorHell.SOUL_SAND;
                                            lllllllllllllllllIlIlIlIlIllIlII = ChunkGeneratorHell.SOUL_SAND;
                                        }
                                    }
                                    if (lllllllllllllllllIlIlIlIlIllIIll < lllllllllllllllllIlIlIlIlIllllIl && (lllllllllllllllllIlIlIlIlIllIlIl == null || lllllllllllllllllIlIlIlIlIllIlIl.getMaterial() == Material.AIR)) {
                                        lllllllllllllllllIlIlIlIlIllIlIl = ChunkGeneratorHell.LAVA;
                                    }
                                    lllllllllllllllllIlIlIlIlIllIllI = lllllllllllllllllIlIlIlIlIllIlll;
                                    if (lllllllllllllllllIlIlIlIlIllIIll >= lllllllllllllllllIlIlIlIlIllllIl - 1) {
                                        lllllllllllllllllIlIlIlIlIlIlllI.setBlockState(lllllllllllllllllIlIlIlIlIlllIlI, lllllllllllllllllIlIlIlIlIllIIll, lllllllllllllllllIlIlIlIlIlllIll, lllllllllllllllllIlIlIlIlIllIlIl);
                                    }
                                    else {
                                        lllllllllllllllllIlIlIlIlIlIlllI.setBlockState(lllllllllllllllllIlIlIlIlIlllIlI, lllllllllllllllllIlIlIlIlIllIIll, lllllllllllllllllIlIlIlIlIlllIll, lllllllllllllllllIlIlIlIlIllIlII);
                                    }
                                }
                                else if (lllllllllllllllllIlIlIlIlIllIllI > 0) {
                                    --lllllllllllllllllIlIlIlIlIllIllI;
                                    lllllllllllllllllIlIlIlIlIlIlllI.setBlockState(lllllllllllllllllIlIlIlIlIlllIlI, lllllllllllllllllIlIlIlIlIllIIll, lllllllllllllllllIlIlIlIlIlllIll, lllllllllllllllllIlIlIlIlIllIlII);
                                }
                            }
                        }
                        else {
                            lllllllllllllllllIlIlIlIlIllIllI = -1;
                        }
                    }
                    else {
                        lllllllllllllllllIlIlIlIlIlIlllI.setBlockState(lllllllllllllllllIlIlIlIlIlllIlI, lllllllllllllllllIlIlIlIlIllIIll, lllllllllllllllllIlIlIlIlIlllIll, ChunkGeneratorHell.BEDROCK);
                    }
                }
            }
        }
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllllllIlIlIlIlIIlIIII, final int lllllllllllllllllIlIlIlIlIIIllll) {
        this.rand.setSeed(lllllllllllllllllIlIlIlIlIIlIIII * 341873128712L + lllllllllllllllllIlIlIlIlIIIllll * 132897987541L);
        final ChunkPrimer lllllllllllllllllIlIlIlIlIIlIllI = new ChunkPrimer();
        this.prepareHeights(lllllllllllllllllIlIlIlIlIIlIIII, lllllllllllllllllIlIlIlIlIIIllll, lllllllllllllllllIlIlIlIlIIlIllI);
        this.buildSurfaces(lllllllllllllllllIlIlIlIlIIlIIII, lllllllllllllllllIlIlIlIlIIIllll, lllllllllllllllllIlIlIlIlIIlIllI);
        this.genNetherCaves.generate(this.world, lllllllllllllllllIlIlIlIlIIlIIII, lllllllllllllllllIlIlIlIlIIIllll, lllllllllllllllllIlIlIlIlIIlIllI);
        if (this.generateStructures) {
            this.genNetherBridge.generate(this.world, lllllllllllllllllIlIlIlIlIIlIIII, lllllllllllllllllIlIlIlIlIIIllll, lllllllllllllllllIlIlIlIlIIlIllI);
        }
        final Chunk lllllllllllllllllIlIlIlIlIIlIlIl = new Chunk(this.world, lllllllllllllllllIlIlIlIlIIlIllI, lllllllllllllllllIlIlIlIlIIlIIII, lllllllllllllllllIlIlIlIlIIIllll);
        final Biome[] lllllllllllllllllIlIlIlIlIIlIlII = this.world.getBiomeProvider().getBiomes(null, lllllllllllllllllIlIlIlIlIIlIIII * 16, lllllllllllllllllIlIlIlIlIIIllll * 16, 16, 16);
        final byte[] lllllllllllllllllIlIlIlIlIIlIIll = lllllllllllllllllIlIlIlIlIIlIlIl.getBiomeArray();
        for (int lllllllllllllllllIlIlIlIlIIlIIlI = 0; lllllllllllllllllIlIlIlIlIIlIIlI < lllllllllllllllllIlIlIlIlIIlIIll.length; ++lllllllllllllllllIlIlIlIlIIlIIlI) {
            lllllllllllllllllIlIlIlIlIIlIIll[lllllllllllllllllIlIlIlIlIIlIIlI] = (byte)Biome.getIdForBiome(lllllllllllllllllIlIlIlIlIIlIlII[lllllllllllllllllIlIlIlIlIIlIIlI]);
        }
        lllllllllllllllllIlIlIlIlIIlIlIl.resetRelightChecks();
        return lllllllllllllllllIlIlIlIlIIlIlIl;
    }
    
    static {
        AIR = Blocks.AIR.getDefaultState();
        NETHERRACK = Blocks.NETHERRACK.getDefaultState();
        BEDROCK = Blocks.BEDROCK.getDefaultState();
        LAVA = Blocks.LAVA.getDefaultState();
        GRAVEL = Blocks.GRAVEL.getDefaultState();
        SOUL_SAND = Blocks.SOUL_SAND.getDefaultState();
    }
    
    @Override
    public void populate(final int lllllllllllllllllIlIlIlIIIllIlll, final int lllllllllllllllllIlIlIlIIIllIllI) {
        BlockFalling.fallInstantly = true;
        final int lllllllllllllllllIlIlIlIIIllIlIl = lllllllllllllllllIlIlIlIIIllIlll * 16;
        final int lllllllllllllllllIlIlIlIIIllIlII = lllllllllllllllllIlIlIlIIIllIllI * 16;
        final BlockPos lllllllllllllllllIlIlIlIIIllIIll = new BlockPos(lllllllllllllllllIlIlIlIIIllIlIl, 0, lllllllllllllllllIlIlIlIIIllIlII);
        final Biome lllllllllllllllllIlIlIlIIIllIIlI = this.world.getBiome(lllllllllllllllllIlIlIlIIIllIIll.add(16, 0, 16));
        final ChunkPos lllllllllllllllllIlIlIlIIIllIIIl = new ChunkPos(lllllllllllllllllIlIlIlIIIllIlll, lllllllllllllllllIlIlIlIIIllIllI);
        this.genNetherBridge.generateStructure(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIIl);
        for (int lllllllllllllllllIlIlIlIIIllIIII = 0; lllllllllllllllllIlIlIlIIIllIIII < 8; ++lllllllllllllllllIlIlIlIIIllIIII) {
            this.hellSpringGen.generate(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
        }
        for (int lllllllllllllllllIlIlIlIIIlIllll = 0; lllllllllllllllllIlIlIlIIIlIllll < this.rand.nextInt(this.rand.nextInt(10) + 1) + 1; ++lllllllllllllllllIlIlIlIIIlIllll) {
            this.fireFeature.generate(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
        }
        for (int lllllllllllllllllIlIlIlIIIlIlllI = 0; lllllllllllllllllIlIlIlIIIlIlllI < this.rand.nextInt(this.rand.nextInt(10) + 1); ++lllllllllllllllllIlIlIlIIIlIlllI) {
            this.lightGemGen.generate(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
        }
        for (int lllllllllllllllllIlIlIlIIIlIllIl = 0; lllllllllllllllllIlIlIlIIIlIllIl < 10; ++lllllllllllllllllIlIlIlIIIlIllIl) {
            this.hellPortalGen.generate(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128), this.rand.nextInt(16) + 8));
        }
        if (this.rand.nextBoolean()) {
            this.brownMushroomFeature.generate(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128), this.rand.nextInt(16) + 8));
        }
        if (this.rand.nextBoolean()) {
            this.redMushroomFeature.generate(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128), this.rand.nextInt(16) + 8));
        }
        for (int lllllllllllllllllIlIlIlIIIlIllII = 0; lllllllllllllllllIlIlIlIIIlIllII < 16; ++lllllllllllllllllIlIlIlIIIlIllII) {
            this.quartzGen.generate(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIll.add(this.rand.nextInt(16), this.rand.nextInt(108) + 10, this.rand.nextInt(16)));
        }
        final int lllllllllllllllllIlIlIlIIIlIlIll = this.world.getSeaLevel() / 2 + 1;
        for (int lllllllllllllllllIlIlIlIIIlIlIlI = 0; lllllllllllllllllIlIlIlIIIlIlIlI < 4; ++lllllllllllllllllIlIlIlIIIlIlIlI) {
            this.magmaGen.generate(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIll.add(this.rand.nextInt(16), lllllllllllllllllIlIlIlIIIlIlIll - 5 + this.rand.nextInt(10), this.rand.nextInt(16)));
        }
        for (int lllllllllllllllllIlIlIlIIIlIlIIl = 0; lllllllllllllllllIlIlIlIIIlIlIIl < 16; ++lllllllllllllllllIlIlIlIIIlIlIIl) {
            this.lavaTrapGen.generate(this.world, this.rand, lllllllllllllllllIlIlIlIIIllIIll.add(this.rand.nextInt(16), this.rand.nextInt(108) + 10, this.rand.nextInt(16)));
        }
        lllllllllllllllllIlIlIlIIIllIIlI.decorate(this.world, this.rand, new BlockPos(lllllllllllllllllIlIlIlIIIllIlIl, 0, lllllllllllllllllIlIlIlIIIllIlII));
        BlockFalling.fallInstantly = false;
    }
}
