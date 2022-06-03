// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.block.material.Material;
import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.world.gen.feature.WorldGenEndGateway;
import net.minecraft.block.BlockChorusFlower;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.block.BlockFalling;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenEndIsland;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.structure.MapGenEndCity;

public class ChunkGeneratorEnd implements IChunkGenerator
{
    private final /* synthetic */ NoiseGeneratorOctaves perlinNoise1;
    private final /* synthetic */ NoiseGeneratorOctaves lperlinNoise2;
    public /* synthetic */ NoiseGeneratorOctaves noiseGen5;
    private final /* synthetic */ NoiseGeneratorOctaves lperlinNoise1;
    /* synthetic */ double[] ar;
    private /* synthetic */ double[] buffer;
    /* synthetic */ double[] pnr;
    private final /* synthetic */ NoiseGeneratorSimplex islandNoise;
    private final /* synthetic */ MapGenEndCity endCityGen;
    private final /* synthetic */ boolean mapFeaturesEnabled;
    /* synthetic */ double[] br;
    protected static final /* synthetic */ IBlockState AIR;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ Random rand;
    private final /* synthetic */ WorldGenEndIsland endIslands;
    private final /* synthetic */ BlockPos field_191061_n;
    protected static final /* synthetic */ IBlockState END_STONE;
    public /* synthetic */ NoiseGeneratorOctaves noiseGen6;
    private /* synthetic */ Biome[] biomesForGeneration;
    
    @Override
    public boolean func_193414_a(final World lllllllllllIIlIlIlIIIIllIlIllllI, final String lllllllllllIIlIlIlIIIIllIlIlllIl, final BlockPos lllllllllllIIlIlIlIIIIllIlIlllII) {
        return "EndCity".equals(lllllllllllIIlIlIlIIIIllIlIlllIl) && this.endCityGen != null && this.endCityGen.isInsideStructure(lllllllllllIIlIlIlIIIIllIlIlllII);
    }
    
    public boolean isIslandChunk(final int lllllllllllIIlIlIlIIIIllllllIlll, final int lllllllllllIIlIlIlIIIIlllllllIIl) {
        return lllllllllllIIlIlIlIIIIllllllIlll * (long)lllllllllllIIlIlIlIIIIllllllIlll + lllllllllllIIlIlIlIIIIlllllllIIl * (long)lllllllllllIIlIlIlIIIIlllllllIIl > 4096L && this.getIslandHeightValue(lllllllllllIIlIlIlIIIIllllllIlll, lllllllllllIIlIlIlIIIIlllllllIIl, 1, 1) >= 0.0f;
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllIIlIlIlIIIlIIIIllIlIl, final int lllllllllllIIlIlIlIIIlIIIIllIlII) {
        this.rand.setSeed(lllllllllllIIlIlIlIIIlIIIIllIlIl * 341873128712L + lllllllllllIIlIlIlIIIlIIIIllIlII * 132897987541L);
        final ChunkPrimer lllllllllllIIlIlIlIIIlIIIIllIIll = new ChunkPrimer();
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, lllllllllllIIlIlIlIIIlIIIIllIlIl * 16, lllllllllllIIlIlIlIIIlIIIIllIlII * 16, 16, 16);
        this.setBlocksInChunk(lllllllllllIIlIlIlIIIlIIIIllIlIl, lllllllllllIIlIlIlIIIlIIIIllIlII, lllllllllllIIlIlIlIIIlIIIIllIIll);
        this.buildSurfaces(lllllllllllIIlIlIlIIIlIIIIllIIll);
        if (this.mapFeaturesEnabled) {
            this.endCityGen.generate(this.worldObj, lllllllllllIIlIlIlIIIlIIIIllIlIl, lllllllllllIIlIlIlIIIlIIIIllIlII, lllllllllllIIlIlIlIIIlIIIIllIIll);
        }
        final Chunk lllllllllllIIlIlIlIIIlIIIIllIIlI = new Chunk(this.worldObj, lllllllllllIIlIlIlIIIlIIIIllIIll, lllllllllllIIlIlIlIIIlIIIIllIlIl, lllllllllllIIlIlIlIIIlIIIIllIlII);
        final byte[] lllllllllllIIlIlIlIIIlIIIIllIIIl = lllllllllllIIlIlIlIIIlIIIIllIIlI.getBiomeArray();
        for (int lllllllllllIIlIlIlIIIlIIIIllIIII = 0; lllllllllllIIlIlIlIIIlIIIIllIIII < lllllllllllIIlIlIlIIIlIIIIllIIIl.length; ++lllllllllllIIlIlIlIIIlIIIIllIIII) {
            lllllllllllIIlIlIlIIIlIIIIllIIIl[lllllllllllIIlIlIlIIIlIIIIllIIII] = (byte)Biome.getIdForBiome(this.biomesForGeneration[lllllllllllIIlIlIlIIIlIIIIllIIII]);
        }
        lllllllllllIIlIlIlIIIlIIIIllIIlI.generateSkylightMap();
        return lllllllllllIIlIlIlIIIlIIIIllIIlI;
    }
    
    public void setBlocksInChunk(final int lllllllllllIIlIlIlIIIlIIIllllIll, final int lllllllllllIIlIlIlIIIlIIIllllIlI, final ChunkPrimer lllllllllllIIlIlIlIIIlIIlIIlllII) {
        final int lllllllllllIIlIlIlIIIlIIlIIllIll = 2;
        final int lllllllllllIIlIlIlIIIlIIlIIllIlI = 3;
        final int lllllllllllIIlIlIlIIIlIIlIIllIIl = 33;
        final int lllllllllllIIlIlIlIIIlIIlIIllIII = 3;
        this.buffer = this.getHeights(this.buffer, lllllllllllIIlIlIlIIIlIIIllllIll * 2, 0, lllllllllllIIlIlIlIIIlIIIllllIlI * 2, 3, 33, 3);
        for (int lllllllllllIIlIlIlIIIlIIlIIlIlll = 0; lllllllllllIIlIlIlIIIlIIlIIlIlll < 2; ++lllllllllllIIlIlIlIIIlIIlIIlIlll) {
            for (int lllllllllllIIlIlIlIIIlIIlIIlIllI = 0; lllllllllllIIlIlIlIIIlIIlIIlIllI < 2; ++lllllllllllIIlIlIlIIIlIIlIIlIllI) {
                for (int lllllllllllIIlIlIlIIIlIIlIIlIlIl = 0; lllllllllllIIlIlIlIIIlIIlIIlIlIl < 32; ++lllllllllllIIlIlIlIIIlIIlIIlIlIl) {
                    final double lllllllllllIIlIlIlIIIlIIlIIlIlII = 0.25;
                    double lllllllllllIIlIlIlIIIlIIlIIlIIll = this.buffer[((lllllllllllIIlIlIlIIIlIIlIIlIlll + 0) * 3 + lllllllllllIIlIlIlIIIlIIlIIlIllI + 0) * 33 + lllllllllllIIlIlIlIIIlIIlIIlIlIl + 0];
                    double lllllllllllIIlIlIlIIIlIIlIIlIIlI = this.buffer[((lllllllllllIIlIlIlIIIlIIlIIlIlll + 0) * 3 + lllllllllllIIlIlIlIIIlIIlIIlIllI + 1) * 33 + lllllllllllIIlIlIlIIIlIIlIIlIlIl + 0];
                    double lllllllllllIIlIlIlIIIlIIlIIlIIIl = this.buffer[((lllllllllllIIlIlIlIIIlIIlIIlIlll + 1) * 3 + lllllllllllIIlIlIlIIIlIIlIIlIllI + 0) * 33 + lllllllllllIIlIlIlIIIlIIlIIlIlIl + 0];
                    double lllllllllllIIlIlIlIIIlIIlIIlIIII = this.buffer[((lllllllllllIIlIlIlIIIlIIlIIlIlll + 1) * 3 + lllllllllllIIlIlIlIIIlIIlIIlIllI + 1) * 33 + lllllllllllIIlIlIlIIIlIIlIIlIlIl + 0];
                    final double lllllllllllIIlIlIlIIIlIIlIIIllll = (this.buffer[((lllllllllllIIlIlIlIIIlIIlIIlIlll + 0) * 3 + lllllllllllIIlIlIlIIIlIIlIIlIllI + 0) * 33 + lllllllllllIIlIlIlIIIlIIlIIlIlIl + 1] - lllllllllllIIlIlIlIIIlIIlIIlIIll) * 0.25;
                    final double lllllllllllIIlIlIlIIIlIIlIIIlllI = (this.buffer[((lllllllllllIIlIlIlIIIlIIlIIlIlll + 0) * 3 + lllllllllllIIlIlIlIIIlIIlIIlIllI + 1) * 33 + lllllllllllIIlIlIlIIIlIIlIIlIlIl + 1] - lllllllllllIIlIlIlIIIlIIlIIlIIlI) * 0.25;
                    final double lllllllllllIIlIlIlIIIlIIlIIIllIl = (this.buffer[((lllllllllllIIlIlIlIIIlIIlIIlIlll + 1) * 3 + lllllllllllIIlIlIlIIIlIIlIIlIllI + 0) * 33 + lllllllllllIIlIlIlIIIlIIlIIlIlIl + 1] - lllllllllllIIlIlIlIIIlIIlIIlIIIl) * 0.25;
                    final double lllllllllllIIlIlIlIIIlIIlIIIllII = (this.buffer[((lllllllllllIIlIlIlIIIlIIlIIlIlll + 1) * 3 + lllllllllllIIlIlIlIIIlIIlIIlIllI + 1) * 33 + lllllllllllIIlIlIlIIIlIIlIIlIlIl + 1] - lllllllllllIIlIlIlIIIlIIlIIlIIII) * 0.25;
                    for (int lllllllllllIIlIlIlIIIlIIlIIIlIll = 0; lllllllllllIIlIlIlIIIlIIlIIIlIll < 4; ++lllllllllllIIlIlIlIIIlIIlIIIlIll) {
                        final double lllllllllllIIlIlIlIIIlIIlIIIlIlI = 0.125;
                        double lllllllllllIIlIlIlIIIlIIlIIIlIIl = lllllllllllIIlIlIlIIIlIIlIIlIIll;
                        double lllllllllllIIlIlIlIIIlIIlIIIlIII = lllllllllllIIlIlIlIIIlIIlIIlIIlI;
                        final double lllllllllllIIlIlIlIIIlIIlIIIIlll = (lllllllllllIIlIlIlIIIlIIlIIlIIIl - lllllllllllIIlIlIlIIIlIIlIIlIIll) * 0.125;
                        final double lllllllllllIIlIlIlIIIlIIlIIIIllI = (lllllllllllIIlIlIlIIIlIIlIIlIIII - lllllllllllIIlIlIlIIIlIIlIIlIIlI) * 0.125;
                        for (int lllllllllllIIlIlIlIIIlIIlIIIIlIl = 0; lllllllllllIIlIlIlIIIlIIlIIIIlIl < 8; ++lllllllllllIIlIlIlIIIlIIlIIIIlIl) {
                            final double lllllllllllIIlIlIlIIIlIIlIIIIlII = 0.125;
                            double lllllllllllIIlIlIlIIIlIIlIIIIIll = lllllllllllIIlIlIlIIIlIIlIIIlIIl;
                            final double lllllllllllIIlIlIlIIIlIIlIIIIIlI = (lllllllllllIIlIlIlIIIlIIlIIIlIII - lllllllllllIIlIlIlIIIlIIlIIIlIIl) * 0.125;
                            for (int lllllllllllIIlIlIlIIIlIIlIIIIIIl = 0; lllllllllllIIlIlIlIIIlIIlIIIIIIl < 8; ++lllllllllllIIlIlIlIIIlIIlIIIIIIl) {
                                IBlockState lllllllllllIIlIlIlIIIlIIlIIIIIII = ChunkGeneratorEnd.AIR;
                                if (lllllllllllIIlIlIlIIIlIIlIIIIIll > 0.0) {
                                    lllllllllllIIlIlIlIIIlIIlIIIIIII = ChunkGeneratorEnd.END_STONE;
                                }
                                final int lllllllllllIIlIlIlIIIlIIIlllllll = lllllllllllIIlIlIlIIIlIIlIIIIlIl + lllllllllllIIlIlIlIIIlIIlIIlIlll * 8;
                                final int lllllllllllIIlIlIlIIIlIIIllllllI = lllllllllllIIlIlIlIIIlIIlIIIlIll + lllllllllllIIlIlIlIIIlIIlIIlIlIl * 4;
                                final int lllllllllllIIlIlIlIIIlIIIlllllIl = lllllllllllIIlIlIlIIIlIIlIIIIIIl + lllllllllllIIlIlIlIIIlIIlIIlIllI * 8;
                                lllllllllllIIlIlIlIIIlIIlIIlllII.setBlockState(lllllllllllIIlIlIlIIIlIIIlllllll, lllllllllllIIlIlIlIIIlIIIllllllI, lllllllllllIIlIlIlIIIlIIIlllllIl, lllllllllllIIlIlIlIIIlIIlIIIIIII);
                                lllllllllllIIlIlIlIIIlIIlIIIIIll += lllllllllllIIlIlIlIIIlIIlIIIIIlI;
                            }
                            lllllllllllIIlIlIlIIIlIIlIIIlIIl += lllllllllllIIlIlIlIIIlIIlIIIIlll;
                            lllllllllllIIlIlIlIIIlIIlIIIlIII += lllllllllllIIlIlIlIIIlIIlIIIIllI;
                        }
                        lllllllllllIIlIlIlIIIlIIlIIlIIll += lllllllllllIIlIlIlIIIlIIlIIIllll;
                        lllllllllllIIlIlIlIIIlIIlIIlIIlI += lllllllllllIIlIlIlIIIlIIlIIIlllI;
                        lllllllllllIIlIlIlIIIlIIlIIlIIIl += lllllllllllIIlIlIlIIIlIIlIIIllIl;
                        lllllllllllIIlIlIlIIIlIIlIIlIIII += lllllllllllIIlIlIlIIIlIIlIIIllII;
                    }
                }
            }
        }
    }
    
    @Override
    public void populate(final int lllllllllllIIlIlIlIIIIlllIIllllI, final int lllllllllllIIlIlIlIIIIlllIIIlIlI) {
        BlockFalling.fallInstantly = true;
        final BlockPos lllllllllllIIlIlIlIIIIlllIIlllII = new BlockPos(lllllllllllIIlIlIlIIIIlllIIllllI * 16, 0, lllllllllllIIlIlIlIIIIlllIIIlIlI * 16);
        if (this.mapFeaturesEnabled) {
            this.endCityGen.generateStructure(this.worldObj, this.rand, new ChunkPos(lllllllllllIIlIlIlIIIIlllIIllllI, lllllllllllIIlIlIlIIIIlllIIIlIlI));
        }
        this.worldObj.getBiome(lllllllllllIIlIlIlIIIIlllIIlllII.add(16, 0, 16)).decorate(this.worldObj, this.worldObj.rand, lllllllllllIIlIlIlIIIIlllIIlllII);
        final long lllllllllllIIlIlIlIIIIlllIIllIll = lllllllllllIIlIlIlIIIIlllIIllllI * (long)lllllllllllIIlIlIlIIIIlllIIllllI + lllllllllllIIlIlIlIIIIlllIIIlIlI * (long)lllllllllllIIlIlIlIIIIlllIIIlIlI;
        if (lllllllllllIIlIlIlIIIIlllIIllIll > 4096L) {
            final float lllllllllllIIlIlIlIIIIlllIIllIlI = this.getIslandHeightValue(lllllllllllIIlIlIlIIIIlllIIllllI, lllllllllllIIlIlIlIIIIlllIIIlIlI, 1, 1);
            if (lllllllllllIIlIlIlIIIIlllIIllIlI < -20.0f && this.rand.nextInt(14) == 0) {
                this.endIslands.generate(this.worldObj, this.rand, lllllllllllIIlIlIlIIIIlllIIlllII.add(this.rand.nextInt(16) + 8, 55 + this.rand.nextInt(16), this.rand.nextInt(16) + 8));
                if (this.rand.nextInt(4) == 0) {
                    this.endIslands.generate(this.worldObj, this.rand, lllllllllllIIlIlIlIIIIlllIIlllII.add(this.rand.nextInt(16) + 8, 55 + this.rand.nextInt(16), this.rand.nextInt(16) + 8));
                }
            }
            if (this.getIslandHeightValue(lllllllllllIIlIlIlIIIIlllIIllllI, lllllllllllIIlIlIlIIIIlllIIIlIlI, 1, 1) > 40.0f) {
                for (int lllllllllllIIlIlIlIIIIlllIIllIIl = this.rand.nextInt(5), lllllllllllIIlIlIlIIIIlllIIllIII = 0; lllllllllllIIlIlIlIIIIlllIIllIII < lllllllllllIIlIlIlIIIIlllIIllIIl; ++lllllllllllIIlIlIlIIIIlllIIllIII) {
                    final int lllllllllllIIlIlIlIIIIlllIIlIlll = this.rand.nextInt(16) + 8;
                    final int lllllllllllIIlIlIlIIIIlllIIlIllI = this.rand.nextInt(16) + 8;
                    final int lllllllllllIIlIlIlIIIIlllIIlIlIl = this.worldObj.getHeight(lllllllllllIIlIlIlIIIIlllIIlllII.add(lllllllllllIIlIlIlIIIIlllIIlIlll, 0, lllllllllllIIlIlIlIIIIlllIIlIllI)).getY();
                    if (lllllllllllIIlIlIlIIIIlllIIlIlIl > 0) {
                        final int lllllllllllIIlIlIlIIIIlllIIlIlII = lllllllllllIIlIlIlIIIIlllIIlIlIl - 1;
                        if (this.worldObj.isAirBlock(lllllllllllIIlIlIlIIIIlllIIlllII.add(lllllllllllIIlIlIlIIIIlllIIlIlll, lllllllllllIIlIlIlIIIIlllIIlIlII + 1, lllllllllllIIlIlIlIIIIlllIIlIllI)) && this.worldObj.getBlockState(lllllllllllIIlIlIlIIIIlllIIlllII.add(lllllllllllIIlIlIlIIIIlllIIlIlll, lllllllllllIIlIlIlIIIIlllIIlIlII, lllllllllllIIlIlIlIIIIlllIIlIllI)).getBlock() == Blocks.END_STONE) {
                            BlockChorusFlower.generatePlant(this.worldObj, lllllllllllIIlIlIlIIIIlllIIlllII.add(lllllllllllIIlIlIlIIIIlllIIlIlll, lllllllllllIIlIlIlIIIIlllIIlIlII + 1, lllllllllllIIlIlIlIIIIlllIIlIllI), this.rand, 8);
                        }
                    }
                }
                if (this.rand.nextInt(700) == 0) {
                    final int lllllllllllIIlIlIlIIIIlllIIlIIll = this.rand.nextInt(16) + 8;
                    final int lllllllllllIIlIlIlIIIIlllIIlIIlI = this.rand.nextInt(16) + 8;
                    final int lllllllllllIIlIlIlIIIIlllIIlIIIl = this.worldObj.getHeight(lllllllllllIIlIlIlIIIIlllIIlllII.add(lllllllllllIIlIlIlIIIIlllIIlIIll, 0, lllllllllllIIlIlIlIIIIlllIIlIIlI)).getY();
                    if (lllllllllllIIlIlIlIIIIlllIIlIIIl > 0) {
                        final int lllllllllllIIlIlIlIIIIlllIIlIIII = lllllllllllIIlIlIlIIIIlllIIlIIIl + 3 + this.rand.nextInt(7);
                        final BlockPos lllllllllllIIlIlIlIIIIlllIIIllll = lllllllllllIIlIlIlIIIIlllIIlllII.add(lllllllllllIIlIlIlIIIIlllIIlIIll, lllllllllllIIlIlIlIIIIlllIIlIIII, lllllllllllIIlIlIlIIIIlllIIlIIlI);
                        new WorldGenEndGateway().generate(this.worldObj, this.rand, lllllllllllIIlIlIlIIIIlllIIIllll);
                        final TileEntity lllllllllllIIlIlIlIIIIlllIIIlllI = this.worldObj.getTileEntity(lllllllllllIIlIlIlIIIIlllIIIllll);
                        if (lllllllllllIIlIlIlIIIIlllIIIlllI instanceof TileEntityEndGateway) {
                            final TileEntityEndGateway lllllllllllIIlIlIlIIIIlllIIIllIl = (TileEntityEndGateway)lllllllllllIIlIlIlIIIIlllIIIlllI;
                            lllllllllllIIlIlIlIIIIlllIIIllIl.func_190603_b(this.field_191061_n);
                        }
                    }
                }
            }
        }
        BlockFalling.fallInstantly = false;
    }
    
    private double[] getHeights(double[] lllllllllllIIlIlIlIIIIllllIIIIll, final int lllllllllllIIlIlIlIIIIllllIIIIlI, final int lllllllllllIIlIlIlIIIIllllIllIll, final int lllllllllllIIlIlIlIIIIllllIllIlI, final int lllllllllllIIlIlIlIIIIlllIllllll, final int lllllllllllIIlIlIlIIIIllllIllIII, final int lllllllllllIIlIlIlIIIIlllIllllIl) {
        if (lllllllllllIIlIlIlIIIIllllIIIIll == null) {
            lllllllllllIIlIlIlIIIIllllIIIIll = new double[lllllllllllIIlIlIlIIIIlllIllllll * lllllllllllIIlIlIlIIIIllllIllIII * lllllllllllIIlIlIlIIIIlllIllllIl];
        }
        double lllllllllllIIlIlIlIIIIllllIlIllI = 684.412;
        final double lllllllllllIIlIlIlIIIIllllIlIlIl = 684.412;
        lllllllllllIIlIlIlIIIIllllIlIllI *= 2.0;
        this.pnr = this.perlinNoise1.generateNoiseOctaves(this.pnr, lllllllllllIIlIlIlIIIIllllIIIIlI, lllllllllllIIlIlIlIIIIllllIllIll, lllllllllllIIlIlIlIIIIllllIllIlI, lllllllllllIIlIlIlIIIIlllIllllll, lllllllllllIIlIlIlIIIIllllIllIII, lllllllllllIIlIlIlIIIIlllIllllIl, lllllllllllIIlIlIlIIIIllllIlIllI / 80.0, 4.277575000000001, lllllllllllIIlIlIlIIIIllllIlIllI / 80.0);
        this.ar = this.lperlinNoise1.generateNoiseOctaves(this.ar, lllllllllllIIlIlIlIIIIllllIIIIlI, lllllllllllIIlIlIlIIIIllllIllIll, lllllllllllIIlIlIlIIIIllllIllIlI, lllllllllllIIlIlIlIIIIlllIllllll, lllllllllllIIlIlIlIIIIllllIllIII, lllllllllllIIlIlIlIIIIlllIllllIl, lllllllllllIIlIlIlIIIIllllIlIllI, 684.412, lllllllllllIIlIlIlIIIIllllIlIllI);
        this.br = this.lperlinNoise2.generateNoiseOctaves(this.br, lllllllllllIIlIlIlIIIIllllIIIIlI, lllllllllllIIlIlIlIIIIllllIllIll, lllllllllllIIlIlIlIIIIllllIllIlI, lllllllllllIIlIlIlIIIIlllIllllll, lllllllllllIIlIlIlIIIIllllIllIII, lllllllllllIIlIlIlIIIIlllIllllIl, lllllllllllIIlIlIlIIIIllllIlIllI, 684.412, lllllllllllIIlIlIlIIIIllllIlIllI);
        final int lllllllllllIIlIlIlIIIIllllIlIlII = lllllllllllIIlIlIlIIIIllllIIIIlI / 2;
        final int lllllllllllIIlIlIlIIIIllllIlIIll = lllllllllllIIlIlIlIIIIllllIllIlI / 2;
        int lllllllllllIIlIlIlIIIIllllIlIIlI = 0;
        for (int lllllllllllIIlIlIlIIIIllllIlIIIl = 0; lllllllllllIIlIlIlIIIIllllIlIIIl < lllllllllllIIlIlIlIIIIlllIllllll; ++lllllllllllIIlIlIlIIIIllllIlIIIl) {
            for (int lllllllllllIIlIlIlIIIIllllIlIIII = 0; lllllllllllIIlIlIlIIIIllllIlIIII < lllllllllllIIlIlIlIIIIlllIllllIl; ++lllllllllllIIlIlIlIIIIllllIlIIII) {
                final float lllllllllllIIlIlIlIIIIllllIIllll = this.getIslandHeightValue(lllllllllllIIlIlIlIIIIllllIlIlII, lllllllllllIIlIlIlIIIIllllIlIIll, lllllllllllIIlIlIlIIIIllllIlIIIl, lllllllllllIIlIlIlIIIIllllIlIIII);
                for (int lllllllllllIIlIlIlIIIIllllIIlllI = 0; lllllllllllIIlIlIlIIIIllllIIlllI < lllllllllllIIlIlIlIIIIllllIllIII; ++lllllllllllIIlIlIlIIIIllllIIlllI) {
                    final double lllllllllllIIlIlIlIIIIllllIIllIl = this.ar[lllllllllllIIlIlIlIIIIllllIlIIlI] / 512.0;
                    final double lllllllllllIIlIlIlIIIIllllIIllII = this.br[lllllllllllIIlIlIlIIIIllllIlIIlI] / 512.0;
                    final double lllllllllllIIlIlIlIIIIllllIIlIll = (this.pnr[lllllllllllIIlIlIlIIIIllllIlIIlI] / 10.0 + 1.0) / 2.0;
                    double lllllllllllIIlIlIlIIIIllllIIlIII = 0.0;
                    if (lllllllllllIIlIlIlIIIIllllIIlIll < 0.0) {
                        final double lllllllllllIIlIlIlIIIIllllIIlIlI = lllllllllllIIlIlIlIIIIllllIIllIl;
                    }
                    else if (lllllllllllIIlIlIlIIIIllllIIlIll > 1.0) {
                        final double lllllllllllIIlIlIlIIIIllllIIlIIl = lllllllllllIIlIlIlIIIIllllIIllII;
                    }
                    else {
                        lllllllllllIIlIlIlIIIIllllIIlIII = lllllllllllIIlIlIlIIIIllllIIllIl + (lllllllllllIIlIlIlIIIIllllIIllII - lllllllllllIIlIlIlIIIIllllIIllIl) * lllllllllllIIlIlIlIIIIllllIIlIll;
                    }
                    lllllllllllIIlIlIlIIIIllllIIlIII -= 8.0;
                    lllllllllllIIlIlIlIIIIllllIIlIII += lllllllllllIIlIlIlIIIIllllIIllll;
                    int lllllllllllIIlIlIlIIIIllllIIIlll = 2;
                    if (lllllllllllIIlIlIlIIIIllllIIlllI > lllllllllllIIlIlIlIIIIllllIllIII / 2 - lllllllllllIIlIlIlIIIIllllIIIlll) {
                        double lllllllllllIIlIlIlIIIIllllIIIllI = (lllllllllllIIlIlIlIIIIllllIIlllI - (lllllllllllIIlIlIlIIIIllllIllIII / 2 - lllllllllllIIlIlIlIIIIllllIIIlll)) / 64.0f;
                        lllllllllllIIlIlIlIIIIllllIIIllI = MathHelper.clamp(lllllllllllIIlIlIlIIIIllllIIIllI, 0.0, 1.0);
                        lllllllllllIIlIlIlIIIIllllIIlIII = lllllllllllIIlIlIlIIIIllllIIlIII * (1.0 - lllllllllllIIlIlIlIIIIllllIIIllI) + -3000.0 * lllllllllllIIlIlIlIIIIllllIIIllI;
                    }
                    lllllllllllIIlIlIlIIIIllllIIIlll = 8;
                    if (lllllllllllIIlIlIlIIIIllllIIlllI < lllllllllllIIlIlIlIIIIllllIIIlll) {
                        final double lllllllllllIIlIlIlIIIIllllIIIlIl = (lllllllllllIIlIlIlIIIIllllIIIlll - lllllllllllIIlIlIlIIIIllllIIlllI) / (lllllllllllIIlIlIlIIIIllllIIIlll - 1.0f);
                        lllllllllllIIlIlIlIIIIllllIIlIII = lllllllllllIIlIlIlIIIIllllIIlIII * (1.0 - lllllllllllIIlIlIlIIIIllllIIIlIl) + -30.0 * lllllllllllIIlIlIlIIIIllllIIIlIl;
                    }
                    lllllllllllIIlIlIlIIIIllllIIIIll[lllllllllllIIlIlIlIIIIllllIlIIlI] = lllllllllllIIlIlIlIIIIllllIIlIII;
                    ++lllllllllllIIlIlIlIIIIllllIlIIlI;
                }
            }
        }
        return (double[])lllllllllllIIlIlIlIIIIllllIIIIll;
    }
    
    @Override
    public void recreateStructures(final Chunk lllllllllllIIlIlIlIIIIllIlIlIlll, final int lllllllllllIIlIlIlIIIIllIlIlIllI, final int lllllllllllIIlIlIlIIIIllIlIlIlIl) {
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType lllllllllllIIlIlIlIIIIllIlllIIll, final BlockPos lllllllllllIIlIlIlIIIIllIlllIIlI) {
        return this.worldObj.getBiome(lllllllllllIIlIlIlIIIIllIlllIIlI).getSpawnableList(lllllllllllIIlIlIlIIIIllIlllIIll);
    }
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World lllllllllllIIlIlIlIIIIllIllIlIll, final String lllllllllllIIlIlIlIIIIllIllIIlIl, final BlockPos lllllllllllIIlIlIlIIIIllIllIlIIl, final boolean lllllllllllIIlIlIlIIIIllIllIIIll) {
        return ("EndCity".equals(lllllllllllIIlIlIlIIIIllIllIIlIl) && this.endCityGen != null) ? this.endCityGen.getClosestStrongholdPos(lllllllllllIIlIlIlIIIIllIllIlIll, lllllllllllIIlIlIlIIIIllIllIlIIl, lllllllllllIIlIlIlIIIIllIllIIIll) : null;
    }
    
    @Override
    public boolean generateStructures(final Chunk lllllllllllIIlIlIlIIIIllIlllllIl, final int lllllllllllIIlIlIlIIIIllIlllllII, final int lllllllllllIIlIlIlIIIIllIllllIll) {
        return false;
    }
    
    public ChunkGeneratorEnd(final World lllllllllllIIlIlIlIIIlIIllIIlIll, final boolean lllllllllllIIlIlIlIIIlIIllIIlIlI, final long lllllllllllIIlIlIlIIIlIIllIIIlII, final BlockPos lllllllllllIIlIlIlIIIlIIllIIIIll) {
        this.endCityGen = new MapGenEndCity(this);
        this.endIslands = new WorldGenEndIsland();
        this.worldObj = lllllllllllIIlIlIlIIIlIIllIIlIll;
        this.mapFeaturesEnabled = lllllllllllIIlIlIlIIIlIIllIIlIlI;
        this.field_191061_n = lllllllllllIIlIlIlIIIlIIllIIIIll;
        this.rand = new Random(lllllllllllIIlIlIlIIIlIIllIIIlII);
        this.lperlinNoise1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.lperlinNoise2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.perlinNoise1 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.islandNoise = new NoiseGeneratorSimplex(this.rand);
    }
    
    static {
        END_STONE = Blocks.END_STONE.getDefaultState();
        AIR = Blocks.AIR.getDefaultState();
    }
    
    public void buildSurfaces(final ChunkPrimer lllllllllllIIlIlIlIIIlIIIlIIllll) {
        for (int lllllllllllIIlIlIlIIIlIIIlIIlllI = 0; lllllllllllIIlIlIlIIIlIIIlIIlllI < 16; ++lllllllllllIIlIlIlIIIlIIIlIIlllI) {
            for (int lllllllllllIIlIlIlIIIlIIIlIIllIl = 0; lllllllllllIIlIlIlIIIlIIIlIIllIl < 16; ++lllllllllllIIlIlIlIIIlIIIlIIllIl) {
                final int lllllllllllIIlIlIlIIIlIIIlIIllII = 1;
                int lllllllllllIIlIlIlIIIlIIIlIIlIll = -1;
                final IBlockState lllllllllllIIlIlIlIIIlIIIlIIlIlI = ChunkGeneratorEnd.END_STONE;
                final IBlockState lllllllllllIIlIlIlIIIlIIIlIIlIIl = ChunkGeneratorEnd.END_STONE;
                for (int lllllllllllIIlIlIlIIIlIIIlIIlIII = 127; lllllllllllIIlIlIlIIIlIIIlIIlIII >= 0; --lllllllllllIIlIlIlIIIlIIIlIIlIII) {
                    final IBlockState lllllllllllIIlIlIlIIIlIIIlIIIlll = lllllllllllIIlIlIlIIIlIIIlIIllll.getBlockState(lllllllllllIIlIlIlIIIlIIIlIIlllI, lllllllllllIIlIlIlIIIlIIIlIIlIII, lllllllllllIIlIlIlIIIlIIIlIIllIl);
                    if (lllllllllllIIlIlIlIIIlIIIlIIIlll.getMaterial() == Material.AIR) {
                        lllllllllllIIlIlIlIIIlIIIlIIlIll = -1;
                    }
                    else if (lllllllllllIIlIlIlIIIlIIIlIIIlll.getBlock() == Blocks.STONE) {
                        if (lllllllllllIIlIlIlIIIlIIIlIIlIll == -1) {
                            lllllllllllIIlIlIlIIIlIIIlIIlIll = 1;
                            if (lllllllllllIIlIlIlIIIlIIIlIIlIII >= 0) {
                                lllllllllllIIlIlIlIIIlIIIlIIllll.setBlockState(lllllllllllIIlIlIlIIIlIIIlIIlllI, lllllllllllIIlIlIlIIIlIIIlIIlIII, lllllllllllIIlIlIlIIIlIIIlIIllIl, lllllllllllIIlIlIlIIIlIIIlIIlIlI);
                            }
                            else {
                                lllllllllllIIlIlIlIIIlIIIlIIllll.setBlockState(lllllllllllIIlIlIlIIIlIIIlIIlllI, lllllllllllIIlIlIlIIIlIIIlIIlIII, lllllllllllIIlIlIlIIIlIIIlIIllIl, lllllllllllIIlIlIlIIIlIIIlIIlIIl);
                            }
                        }
                        else if (lllllllllllIIlIlIlIIIlIIIlIIlIll > 0) {
                            --lllllllllllIIlIlIlIIIlIIIlIIlIll;
                            lllllllllllIIlIlIlIIIlIIIlIIllll.setBlockState(lllllllllllIIlIlIlIIIlIIIlIIlllI, lllllllllllIIlIlIlIIIlIIIlIIlIII, lllllllllllIIlIlIlIIIlIIIlIIllIl, lllllllllllIIlIlIlIIIlIIIlIIlIIl);
                        }
                    }
                }
            }
        }
    }
    
    private float getIslandHeightValue(final int lllllllllllIIlIlIlIIIlIIIIIllIIl, final int lllllllllllIIlIlIlIIIlIIIIIIlIlI, final int lllllllllllIIlIlIlIIIlIIIIIlIlll, final int lllllllllllIIlIlIlIIIlIIIIIlIllI) {
        float lllllllllllIIlIlIlIIIlIIIIIlIlIl = (float)(lllllllllllIIlIlIlIIIlIIIIIllIIl * 2 + lllllllllllIIlIlIlIIIlIIIIIlIlll);
        float lllllllllllIIlIlIlIIIlIIIIIlIlII = (float)(lllllllllllIIlIlIlIIIlIIIIIIlIlI * 2 + lllllllllllIIlIlIlIIIlIIIIIlIllI);
        float lllllllllllIIlIlIlIIIlIIIIIlIIll = 100.0f - MathHelper.sqrt(lllllllllllIIlIlIlIIIlIIIIIlIlIl * lllllllllllIIlIlIlIIIlIIIIIlIlIl + lllllllllllIIlIlIlIIIlIIIIIlIlII * lllllllllllIIlIlIlIIIlIIIIIlIlII) * 8.0f;
        if (lllllllllllIIlIlIlIIIlIIIIIlIIll > 80.0f) {
            lllllllllllIIlIlIlIIIlIIIIIlIIll = 80.0f;
        }
        if (lllllllllllIIlIlIlIIIlIIIIIlIIll < -100.0f) {
            lllllllllllIIlIlIlIIIlIIIIIlIIll = -100.0f;
        }
        for (int lllllllllllIIlIlIlIIIlIIIIIlIIlI = -12; lllllllllllIIlIlIlIIIlIIIIIlIIlI <= 12; ++lllllllllllIIlIlIlIIIlIIIIIlIIlI) {
            for (int lllllllllllIIlIlIlIIIlIIIIIlIIIl = -12; lllllllllllIIlIlIlIIIlIIIIIlIIIl <= 12; ++lllllllllllIIlIlIlIIIlIIIIIlIIIl) {
                final long lllllllllllIIlIlIlIIIlIIIIIlIIII = lllllllllllIIlIlIlIIIlIIIIIllIIl + lllllllllllIIlIlIlIIIlIIIIIlIIlI;
                final long lllllllllllIIlIlIlIIIlIIIIIIllll = lllllllllllIIlIlIlIIIlIIIIIIlIlI + lllllllllllIIlIlIlIIIlIIIIIlIIIl;
                if (lllllllllllIIlIlIlIIIlIIIIIlIIII * lllllllllllIIlIlIlIIIlIIIIIlIIII + lllllllllllIIlIlIlIIIlIIIIIIllll * lllllllllllIIlIlIlIIIlIIIIIIllll > 4096L && this.islandNoise.getValue((double)lllllllllllIIlIlIlIIIlIIIIIlIIII, (double)lllllllllllIIlIlIlIIIlIIIIIIllll) < -0.8999999761581421) {
                    final float lllllllllllIIlIlIlIIIlIIIIIIlllI = (MathHelper.abs((float)lllllllllllIIlIlIlIIIlIIIIIlIIII) * 3439.0f + MathHelper.abs((float)lllllllllllIIlIlIlIIIlIIIIIIllll) * 147.0f) % 13.0f + 9.0f;
                    lllllllllllIIlIlIlIIIlIIIIIlIlIl = (float)(lllllllllllIIlIlIlIIIlIIIIIlIlll - lllllllllllIIlIlIlIIIlIIIIIlIIlI * 2);
                    lllllllllllIIlIlIlIIIlIIIIIlIlII = (float)(lllllllllllIIlIlIlIIIlIIIIIlIllI - lllllllllllIIlIlIlIIIlIIIIIlIIIl * 2);
                    float lllllllllllIIlIlIlIIIlIIIIIIllIl = 100.0f - MathHelper.sqrt(lllllllllllIIlIlIlIIIlIIIIIlIlIl * lllllllllllIIlIlIlIIIlIIIIIlIlIl + lllllllllllIIlIlIlIIIlIIIIIlIlII * lllllllllllIIlIlIlIIIlIIIIIlIlII) * lllllllllllIIlIlIlIIIlIIIIIIlllI;
                    if (lllllllllllIIlIlIlIIIlIIIIIIllIl > 80.0f) {
                        lllllllllllIIlIlIlIIIlIIIIIIllIl = 80.0f;
                    }
                    if (lllllllllllIIlIlIlIIIlIIIIIIllIl < -100.0f) {
                        lllllllllllIIlIlIlIIIlIIIIIIllIl = -100.0f;
                    }
                    if (lllllllllllIIlIlIlIIIlIIIIIIllIl > lllllllllllIIlIlIlIIIlIIIIIlIIll) {
                        lllllllllllIIlIlIlIIIlIIIIIlIIll = lllllllllllIIlIlIlIIIlIIIIIIllIl;
                    }
                }
            }
        }
        return lllllllllllIIlIlIlIIIlIIIIIlIIll;
    }
}
