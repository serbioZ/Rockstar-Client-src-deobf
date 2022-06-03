// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.util.math.BlockPos;
import java.util.Arrays;
import net.minecraft.block.material.Material;
import net.minecraft.world.chunk.ChunkPrimer;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockSand;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.BlockColored;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.block.state.IBlockState;

public class BiomeMesa extends Biome
{
    private final /* synthetic */ boolean brycePillars;
    protected static final /* synthetic */ IBlockState ORANGE_STAINED_HARDENED_CLAY;
    protected static final /* synthetic */ IBlockState STAINED_HARDENED_CLAY;
    protected static final /* synthetic */ IBlockState HARDENED_CLAY;
    protected static final /* synthetic */ IBlockState RED_SAND;
    private /* synthetic */ NoiseGeneratorPerlin pillarRoofNoise;
    private /* synthetic */ NoiseGeneratorPerlin clayBandsOffsetNoise;
    protected static final /* synthetic */ IBlockState COARSE_DIRT;
    private /* synthetic */ IBlockState[] clayBands;
    private /* synthetic */ long worldSeed;
    private /* synthetic */ NoiseGeneratorPerlin pillarNoise;
    private final /* synthetic */ boolean hasForest;
    protected static final /* synthetic */ IBlockState GRASS;
    
    static {
        COARSE_DIRT = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
        GRASS = Blocks.GRASS.getDefaultState();
        HARDENED_CLAY = Blocks.HARDENED_CLAY.getDefaultState();
        STAINED_HARDENED_CLAY = Blocks.STAINED_HARDENED_CLAY.getDefaultState();
        ORANGE_STAINED_HARDENED_CLAY = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE);
        RED_SAND = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);
    }
    
    private IBlockState getBand(final int lllllllllllIIIIllIIllIIIIlIIllIl, final int lllllllllllIIIIllIIllIIIIlIIIlll, final int lllllllllllIIIIllIIllIIIIlIIlIll) {
        final int lllllllllllIIIIllIIllIIIIlIIlIlI = (int)Math.round(this.clayBandsOffsetNoise.getValue(lllllllllllIIIIllIIllIIIIlIIllIl / 512.0, lllllllllllIIIIllIIllIIIIlIIllIl / 512.0) * 2.0);
        return this.clayBands[(lllllllllllIIIIllIIllIIIIlIIIlll + lllllllllllIIIIllIIllIIIIlIIlIlI + 64) % 64];
    }
    
    @Override
    public void genTerrainBlocks(final World lllllllllllIIIIllIIllIIIlIIlIlII, final Random lllllllllllIIIIllIIllIIIlIIlIIll, final ChunkPrimer lllllllllllIIIIllIIllIIIlIIlIIlI, final int lllllllllllIIIIllIIllIIIlIlIllll, final int lllllllllllIIIIllIIllIIIlIlIlllI, final double lllllllllllIIIIllIIllIIIlIIIllll) {
        if (this.clayBands == null || this.worldSeed != lllllllllllIIIIllIIllIIIlIIlIlII.getSeed()) {
            this.generateBands(lllllllllllIIIIllIIllIIIlIIlIlII.getSeed());
        }
        if (this.pillarNoise == null || this.pillarRoofNoise == null || this.worldSeed != lllllllllllIIIIllIIllIIIlIIlIlII.getSeed()) {
            final Random lllllllllllIIIIllIIllIIIlIlIllII = new Random(this.worldSeed);
            this.pillarNoise = new NoiseGeneratorPerlin(lllllllllllIIIIllIIllIIIlIlIllII, 4);
            this.pillarRoofNoise = new NoiseGeneratorPerlin(lllllllllllIIIIllIIllIIIlIlIllII, 1);
        }
        this.worldSeed = lllllllllllIIIIllIIllIIIlIIlIlII.getSeed();
        double lllllllllllIIIIllIIllIIIlIlIlIll = 0.0;
        if (this.brycePillars) {
            final int lllllllllllIIIIllIIllIIIlIlIlIlI = (lllllllllllIIIIllIIllIIIlIlIllll & 0xFFFFFFF0) + (lllllllllllIIIIllIIllIIIlIlIlllI & 0xF);
            final int lllllllllllIIIIllIIllIIIlIlIlIIl = (lllllllllllIIIIllIIllIIIlIlIlllI & 0xFFFFFFF0) + (lllllllllllIIIIllIIllIIIlIlIllll & 0xF);
            final double lllllllllllIIIIllIIllIIIlIlIlIII = Math.min(Math.abs(lllllllllllIIIIllIIllIIIlIIIllll), this.pillarNoise.getValue(lllllllllllIIIIllIIllIIIlIlIlIlI * 0.25, lllllllllllIIIIllIIllIIIlIlIlIIl * 0.25));
            if (lllllllllllIIIIllIIllIIIlIlIlIII > 0.0) {
                final double lllllllllllIIIIllIIllIIIlIlIIlll = 0.001953125;
                final double lllllllllllIIIIllIIllIIIlIlIIllI = Math.abs(this.pillarRoofNoise.getValue(lllllllllllIIIIllIIllIIIlIlIlIlI * 0.001953125, lllllllllllIIIIllIIllIIIlIlIlIIl * 0.001953125));
                lllllllllllIIIIllIIllIIIlIlIlIll = lllllllllllIIIIllIIllIIIlIlIlIII * lllllllllllIIIIllIIllIIIlIlIlIII * 2.5;
                final double lllllllllllIIIIllIIllIIIlIlIIlIl = Math.ceil(lllllllllllIIIIllIIllIIIlIlIIllI * 50.0) + 14.0;
                if (lllllllllllIIIIllIIllIIIlIlIlIll > lllllllllllIIIIllIIllIIIlIlIIlIl) {
                    lllllllllllIIIIllIIllIIIlIlIlIll = lllllllllllIIIIllIIllIIIlIlIIlIl;
                }
                lllllllllllIIIIllIIllIIIlIlIlIll += 64.0;
            }
        }
        final int lllllllllllIIIIllIIllIIIlIlIIlII = lllllllllllIIIIllIIllIIIlIlIllll & 0xF;
        final int lllllllllllIIIIllIIllIIIlIlIIIll = lllllllllllIIIIllIIllIIIlIlIlllI & 0xF;
        final int lllllllllllIIIIllIIllIIIlIlIIIlI = lllllllllllIIIIllIIllIIIlIIlIlII.getSeaLevel();
        IBlockState lllllllllllIIIIllIIllIIIlIlIIIIl = BiomeMesa.STAINED_HARDENED_CLAY;
        IBlockState lllllllllllIIIIllIIllIIIlIlIIIII = this.fillerBlock;
        final int lllllllllllIIIIllIIllIIIlIIlllll = (int)(lllllllllllIIIIllIIllIIIlIIIllll / 3.0 + 3.0 + lllllllllllIIIIllIIllIIIlIIlIIll.nextDouble() * 0.25);
        final boolean lllllllllllIIIIllIIllIIIlIIllllI = Math.cos(lllllllllllIIIIllIIllIIIlIIIllll / 3.0 * 3.141592653589793) > 0.0;
        int lllllllllllIIIIllIIllIIIlIIlllIl = -1;
        boolean lllllllllllIIIIllIIllIIIlIIlllII = false;
        int lllllllllllIIIIllIIllIIIlIIllIll = 0;
        for (int lllllllllllIIIIllIIllIIIlIIllIlI = 255; lllllllllllIIIIllIIllIIIlIIllIlI >= 0; --lllllllllllIIIIllIIllIIIlIIllIlI) {
            if (lllllllllllIIIIllIIllIIIlIIlIIlI.getBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII).getMaterial() == Material.AIR && lllllllllllIIIIllIIllIIIlIIllIlI < (int)lllllllllllIIIIllIIllIIIlIlIlIll) {
                lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, BiomeMesa.STONE);
            }
            if (lllllllllllIIIIllIIllIIIlIIllIlI <= lllllllllllIIIIllIIllIIIlIIlIIll.nextInt(5)) {
                lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, BiomeMesa.BEDROCK);
            }
            else if (lllllllllllIIIIllIIllIIIlIIllIll < 15 || this.brycePillars) {
                final IBlockState lllllllllllIIIIllIIllIIIlIIllIIl = lllllllllllIIIIllIIllIIIlIIlIIlI.getBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII);
                if (lllllllllllIIIIllIIllIIIlIIllIIl.getMaterial() == Material.AIR) {
                    lllllllllllIIIIllIIllIIIlIIlllIl = -1;
                }
                else if (lllllllllllIIIIllIIllIIIlIIllIIl.getBlock() == Blocks.STONE) {
                    if (lllllllllllIIIIllIIllIIIlIIlllIl == -1) {
                        lllllllllllIIIIllIIllIIIlIIlllII = false;
                        if (lllllllllllIIIIllIIllIIIlIIlllll <= 0) {
                            lllllllllllIIIIllIIllIIIlIlIIIIl = BiomeMesa.AIR;
                            lllllllllllIIIIllIIllIIIlIlIIIII = BiomeMesa.STONE;
                        }
                        else if (lllllllllllIIIIllIIllIIIlIIllIlI >= lllllllllllIIIIllIIllIIIlIlIIIlI - 4 && lllllllllllIIIIllIIllIIIlIIllIlI <= lllllllllllIIIIllIIllIIIlIlIIIlI + 1) {
                            lllllllllllIIIIllIIllIIIlIlIIIIl = BiomeMesa.STAINED_HARDENED_CLAY;
                            lllllllllllIIIIllIIllIIIlIlIIIII = this.fillerBlock;
                        }
                        if (lllllllllllIIIIllIIllIIIlIIllIlI < lllllllllllIIIIllIIllIIIlIlIIIlI && (lllllllllllIIIIllIIllIIIlIlIIIIl == null || lllllllllllIIIIllIIllIIIlIlIIIIl.getMaterial() == Material.AIR)) {
                            lllllllllllIIIIllIIllIIIlIlIIIIl = BiomeMesa.WATER;
                        }
                        lllllllllllIIIIllIIllIIIlIIlllIl = lllllllllllIIIIllIIllIIIlIIlllll + Math.max(0, lllllllllllIIIIllIIllIIIlIIllIlI - lllllllllllIIIIllIIllIIIlIlIIIlI);
                        if (lllllllllllIIIIllIIllIIIlIIllIlI >= lllllllllllIIIIllIIllIIIlIlIIIlI - 1) {
                            if (this.hasForest && lllllllllllIIIIllIIllIIIlIIllIlI > 86 + lllllllllllIIIIllIIllIIIlIIlllll * 2) {
                                if (lllllllllllIIIIllIIllIIIlIIllllI) {
                                    lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, BiomeMesa.COARSE_DIRT);
                                }
                                else {
                                    lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, BiomeMesa.GRASS);
                                }
                            }
                            else if (lllllllllllIIIIllIIllIIIlIIllIlI > lllllllllllIIIIllIIllIIIlIlIIIlI + 3 + lllllllllllIIIIllIIllIIIlIIlllll) {
                                IBlockState lllllllllllIIIIllIIllIIIlIIlIllI = null;
                                if (lllllllllllIIIIllIIllIIIlIIllIlI >= 64 && lllllllllllIIIIllIIllIIIlIIllIlI <= 127) {
                                    if (lllllllllllIIIIllIIllIIIlIIllllI) {
                                        final IBlockState lllllllllllIIIIllIIllIIIlIIllIII = BiomeMesa.HARDENED_CLAY;
                                    }
                                    else {
                                        final IBlockState lllllllllllIIIIllIIllIIIlIIlIlll = this.getBand(lllllllllllIIIIllIIllIIIlIlIllll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIlllI);
                                    }
                                }
                                else {
                                    lllllllllllIIIIllIIllIIIlIIlIllI = BiomeMesa.ORANGE_STAINED_HARDENED_CLAY;
                                }
                                lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, lllllllllllIIIIllIIllIIIlIIlIllI);
                            }
                            else {
                                lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, this.topBlock);
                                lllllllllllIIIIllIIllIIIlIIlllII = true;
                            }
                        }
                        else {
                            lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, lllllllllllIIIIllIIllIIIlIlIIIII);
                            if (lllllllllllIIIIllIIllIIIlIlIIIII.getBlock() == Blocks.STAINED_HARDENED_CLAY) {
                                lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, BiomeMesa.ORANGE_STAINED_HARDENED_CLAY);
                            }
                        }
                    }
                    else if (lllllllllllIIIIllIIllIIIlIIlllIl > 0) {
                        --lllllllllllIIIIllIIllIIIlIIlllIl;
                        if (lllllllllllIIIIllIIllIIIlIIlllII) {
                            lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, BiomeMesa.ORANGE_STAINED_HARDENED_CLAY);
                        }
                        else {
                            lllllllllllIIIIllIIllIIIlIIlIIlI.setBlockState(lllllllllllIIIIllIIllIIIlIlIIIll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIIlII, this.getBand(lllllllllllIIIIllIIllIIIlIlIllll, lllllllllllIIIIllIIllIIIlIIllIlI, lllllllllllIIIIllIIllIIIlIlIlllI));
                        }
                    }
                    ++lllllllllllIIIIllIIllIIIlIIllIll;
                }
            }
        }
    }
    
    private void generateBands(final long lllllllllllIIIIllIIllIIIIlIlllII) {
        this.clayBands = new IBlockState[64];
        Arrays.fill(this.clayBands, BiomeMesa.HARDENED_CLAY);
        final Random lllllllllllIIIIllIIllIIIIlllIIll = new Random(lllllllllllIIIIllIIllIIIIlIlllII);
        this.clayBandsOffsetNoise = new NoiseGeneratorPerlin(lllllllllllIIIIllIIllIIIIlllIIll, 1);
        for (int lllllllllllIIIIllIIllIIIIlllIIlI = 0; lllllllllllIIIIllIIllIIIIlllIIlI < 64; ++lllllllllllIIIIllIIllIIIIlllIIlI) {
            lllllllllllIIIIllIIllIIIIlllIIlI += lllllllllllIIIIllIIllIIIIlllIIll.nextInt(5) + 1;
            if (lllllllllllIIIIllIIllIIIIlllIIlI < 64) {
                this.clayBands[lllllllllllIIIIllIIllIIIIlllIIlI] = BiomeMesa.ORANGE_STAINED_HARDENED_CLAY;
            }
        }
        for (int lllllllllllIIIIllIIllIIIIlllIIIl = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(4) + 2, lllllllllllIIIIllIIllIIIIlllIIII = 0; lllllllllllIIIIllIIllIIIIlllIIII < lllllllllllIIIIllIIllIIIIlllIIIl; ++lllllllllllIIIIllIIllIIIIlllIIII) {
            for (int lllllllllllIIIIllIIllIIIIllIllll = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(3) + 1, lllllllllllIIIIllIIllIIIIllIlllI = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(64), lllllllllllIIIIllIIllIIIIllIllIl = 0; lllllllllllIIIIllIIllIIIIllIlllI + lllllllllllIIIIllIIllIIIIllIllIl < 64 && lllllllllllIIIIllIIllIIIIllIllIl < lllllllllllIIIIllIIllIIIIllIllll; ++lllllllllllIIIIllIIllIIIIllIllIl) {
                this.clayBands[lllllllllllIIIIllIIllIIIIllIlllI + lllllllllllIIIIllIIllIIIIllIllIl] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW);
            }
        }
        for (int lllllllllllIIIIllIIllIIIIllIllII = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(4) + 2, lllllllllllIIIIllIIllIIIIllIlIll = 0; lllllllllllIIIIllIIllIIIIllIlIll < lllllllllllIIIIllIIllIIIIllIllII; ++lllllllllllIIIIllIIllIIIIllIlIll) {
            for (int lllllllllllIIIIllIIllIIIIllIlIlI = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(3) + 2, lllllllllllIIIIllIIllIIIIllIlIIl = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(64), lllllllllllIIIIllIIllIIIIllIlIII = 0; lllllllllllIIIIllIIllIIIIllIlIIl + lllllllllllIIIIllIIllIIIIllIlIII < 64 && lllllllllllIIIIllIIllIIIIllIlIII < lllllllllllIIIIllIIllIIIIllIlIlI; ++lllllllllllIIIIllIIllIIIIllIlIII) {
                this.clayBands[lllllllllllIIIIllIIllIIIIllIlIIl + lllllllllllIIIIllIIllIIIIllIlIII] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
            }
        }
        for (int lllllllllllIIIIllIIllIIIIllIIlll = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(4) + 2, lllllllllllIIIIllIIllIIIIllIIllI = 0; lllllllllllIIIIllIIllIIIIllIIllI < lllllllllllIIIIllIIllIIIIllIIlll; ++lllllllllllIIIIllIIllIIIIllIIllI) {
            for (int lllllllllllIIIIllIIllIIIIllIIlIl = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(3) + 1, lllllllllllIIIIllIIllIIIIllIIlII = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(64), lllllllllllIIIIllIIllIIIIllIIIll = 0; lllllllllllIIIIllIIllIIIIllIIlII + lllllllllllIIIIllIIllIIIIllIIIll < 64 && lllllllllllIIIIllIIllIIIIllIIIll < lllllllllllIIIIllIIllIIIIllIIlIl; ++lllllllllllIIIIllIIllIIIIllIIIll) {
                this.clayBands[lllllllllllIIIIllIIllIIIIllIIlII + lllllllllllIIIIllIIllIIIIllIIIll] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.RED);
            }
        }
        final int lllllllllllIIIIllIIllIIIIllIIIlI = lllllllllllIIIIllIIllIIIIlllIIll.nextInt(3) + 3;
        int lllllllllllIIIIllIIllIIIIllIIIIl = 0;
        for (int lllllllllllIIIIllIIllIIIIllIIIII = 0; lllllllllllIIIIllIIllIIIIllIIIII < lllllllllllIIIIllIIllIIIIllIIIlI; ++lllllllllllIIIIllIIllIIIIllIIIII) {
            final int lllllllllllIIIIllIIllIIIIlIlllll = 1;
            lllllllllllIIIIllIIllIIIIllIIIIl += lllllllllllIIIIllIIllIIIIlllIIll.nextInt(16) + 4;
            for (int lllllllllllIIIIllIIllIIIIlIllllI = 0; lllllllllllIIIIllIIllIIIIllIIIIl + lllllllllllIIIIllIIllIIIIlIllllI < 64 && lllllllllllIIIIllIIllIIIIlIllllI < 1; ++lllllllllllIIIIllIIllIIIIlIllllI) {
                this.clayBands[lllllllllllIIIIllIIllIIIIllIIIIl + lllllllllllIIIIllIIllIIIIlIllllI] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
                if (lllllllllllIIIIllIIllIIIIllIIIIl + lllllllllllIIIIllIIllIIIIlIllllI > 1 && lllllllllllIIIIllIIllIIIIlllIIll.nextBoolean()) {
                    this.clayBands[lllllllllllIIIIllIIllIIIIllIIIIl + lllllllllllIIIIllIIllIIIIlIllllI - 1] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
                }
                if (lllllllllllIIIIllIIllIIIIllIIIIl + lllllllllllIIIIllIIllIIIIlIllllI < 63 && lllllllllllIIIIllIIllIIIIlllIIll.nextBoolean()) {
                    this.clayBands[lllllllllllIIIIllIIllIIIIllIIIIl + lllllllllllIIIIllIIllIIIIlIllllI + 1] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
                }
            }
        }
    }
    
    @Override
    protected BiomeDecorator createBiomeDecorator() {
        return new Decorator((Decorator)null);
    }
    
    @Override
    public int getFoliageColorAtPos(final BlockPos lllllllllllIIIIllIIllIIIllIIlIll) {
        return 10387789;
    }
    
    @Override
    public int getGrassColorAtPos(final BlockPos lllllllllllIIIIllIIllIIIllIIlIIl) {
        return 9470285;
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllIIIIllIIllIIIllIIllIl) {
        return BiomeMesa.TREE_FEATURE;
    }
    
    public BiomeMesa(final boolean lllllllllllIIIIllIIllIIIllIlIlII, final boolean lllllllllllIIIIllIIllIIIllIlIlll, final BiomeProperties lllllllllllIIIIllIIllIIIllIlIllI) {
        super(lllllllllllIIIIllIIllIIIllIlIllI);
        this.brycePillars = lllllllllllIIIIllIIllIIIllIlIlII;
        this.hasForest = lllllllllllIIIIllIIllIIIllIlIlll;
        this.spawnableCreatureList.clear();
        this.topBlock = BiomeMesa.RED_SAND;
        this.fillerBlock = BiomeMesa.STAINED_HARDENED_CLAY;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 20;
        this.theBiomeDecorator.reedsPerChunk = 3;
        this.theBiomeDecorator.cactiPerChunk = 5;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.spawnableCreatureList.clear();
        if (lllllllllllIIIIllIIllIIIllIlIlll) {
            this.theBiomeDecorator.treesPerChunk = 5;
        }
    }
    
    class Decorator extends BiomeDecorator
    {
        @Override
        protected void generateOres(final World lllllllllllIIllIlIlIlllllIIlllII, final Random lllllllllllIIllIlIlIlllllIIllIll) {
            super.generateOres(lllllllllllIIllIlIlIlllllIIlllII, lllllllllllIIllIlIlIlllllIIllIll);
            this.genStandardOre1(lllllllllllIIllIlIlIlllllIIlllII, lllllllllllIIllIlIlIlllllIIllIll, 20, this.goldGen, 32, 80);
        }
        
        private Decorator() {
        }
    }
}
