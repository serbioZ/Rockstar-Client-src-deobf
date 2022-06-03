// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStone;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecorator
{
    protected /* synthetic */ WorldGenerator sandGen;
    protected /* synthetic */ WorldGenerator gravelAsSandGen;
    protected /* synthetic */ int grassPerChunk;
    protected /* synthetic */ WorldGenerator diamondGen;
    protected /* synthetic */ int bigMushroomsPerChunk;
    protected /* synthetic */ WorldGenerator waterlilyGen;
    protected /* synthetic */ int flowersPerChunk;
    protected /* synthetic */ boolean decorating;
    protected /* synthetic */ int sandPerChunk2;
    protected /* synthetic */ WorldGenerator andesiteGen;
    protected /* synthetic */ WorldGenerator dirtGen;
    protected /* synthetic */ WorldGenFlowers yellowFlowerGen;
    protected /* synthetic */ WorldGenerator redstoneGen;
    protected /* synthetic */ int deadBushPerChunk;
    protected /* synthetic */ int waterlilyPerChunk;
    protected /* synthetic */ WorldGenerator mushroomRedGen;
    protected /* synthetic */ WorldGenerator mushroomBrownGen;
    protected /* synthetic */ WorldGenerator goldGen;
    protected /* synthetic */ int cactiPerChunk;
    protected /* synthetic */ WorldGenerator gravelGen;
    protected /* synthetic */ BlockPos chunkPos;
    public /* synthetic */ boolean generateLakes;
    protected /* synthetic */ WorldGenerator clayGen;
    protected /* synthetic */ float extraTreeChance;
    protected /* synthetic */ WorldGenerator coalGen;
    protected /* synthetic */ WorldGenerator ironGen;
    protected /* synthetic */ WorldGenerator lapisGen;
    protected /* synthetic */ WorldGenerator reedGen;
    protected /* synthetic */ WorldGenerator dioriteGen;
    protected /* synthetic */ WorldGenerator bigMushroomGen;
    protected /* synthetic */ int treesPerChunk;
    protected /* synthetic */ WorldGenerator cactusGen;
    protected /* synthetic */ ChunkGeneratorSettings chunkProviderSettings;
    protected /* synthetic */ int reedsPerChunk;
    protected /* synthetic */ int sandPerChunk;
    protected /* synthetic */ WorldGenerator graniteGen;
    protected /* synthetic */ int clayPerChunk;
    protected /* synthetic */ int mushroomsPerChunk;
    
    protected void generateOres(final World llllllllllIllllIIIIIIlllllllIlll, final Random llllllllllIllllIIIIIIlllllllIllI) {
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.dirtCount, this.dirtGen, this.chunkProviderSettings.dirtMinHeight, this.chunkProviderSettings.dirtMaxHeight);
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.gravelCount, this.gravelGen, this.chunkProviderSettings.gravelMinHeight, this.chunkProviderSettings.gravelMaxHeight);
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.dioriteCount, this.dioriteGen, this.chunkProviderSettings.dioriteMinHeight, this.chunkProviderSettings.dioriteMaxHeight);
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.graniteCount, this.graniteGen, this.chunkProviderSettings.graniteMinHeight, this.chunkProviderSettings.graniteMaxHeight);
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.andesiteCount, this.andesiteGen, this.chunkProviderSettings.andesiteMinHeight, this.chunkProviderSettings.andesiteMaxHeight);
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.coalCount, this.coalGen, this.chunkProviderSettings.coalMinHeight, this.chunkProviderSettings.coalMaxHeight);
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.ironCount, this.ironGen, this.chunkProviderSettings.ironMinHeight, this.chunkProviderSettings.ironMaxHeight);
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.goldCount, this.goldGen, this.chunkProviderSettings.goldMinHeight, this.chunkProviderSettings.goldMaxHeight);
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.redstoneCount, this.redstoneGen, this.chunkProviderSettings.redstoneMinHeight, this.chunkProviderSettings.redstoneMaxHeight);
        this.genStandardOre1(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.diamondCount, this.diamondGen, this.chunkProviderSettings.diamondMinHeight, this.chunkProviderSettings.diamondMaxHeight);
        this.genStandardOre2(llllllllllIllllIIIIIIlllllllIlll, llllllllllIllllIIIIIIlllllllIllI, this.chunkProviderSettings.lapisCount, this.lapisGen, this.chunkProviderSettings.lapisCenterHeight, this.chunkProviderSettings.lapisSpread);
    }
    
    protected void genDecorations(final Biome llllllllllIllllIIIIIlIIIIIIIIlll, final World llllllllllIllllIIIIIlIIIIIIIIllI, final Random llllllllllIllllIIIIIlIIIIIIIIlIl) {
        this.generateOres(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl);
        for (int llllllllllIllllIIIIIlIIIIllIIIlI = 0; llllllllllIllllIIIIIlIIIIllIIIlI < this.sandPerChunk2; ++llllllllllIllllIIIIIlIIIIllIIIlI) {
            final int llllllllllIllllIIIIIlIIIIllIIIIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIllIIIII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            this.sandGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIIIIIllI.getTopSolidOrLiquidBlock(this.chunkPos.add(llllllllllIllllIIIIIlIIIIllIIIIl, 0, llllllllllIllllIIIIIlIIIIllIIIII)));
        }
        for (int llllllllllIllllIIIIIlIIIIlIlllll = 0; llllllllllIllllIIIIIlIIIIlIlllll < this.clayPerChunk; ++llllllllllIllllIIIIIlIIIIlIlllll) {
            final int llllllllllIllllIIIIIlIIIIlIllllI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIlllIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            this.clayGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIIIIIllI.getTopSolidOrLiquidBlock(this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIllllI, 0, llllllllllIllllIIIIIlIIIIlIlllIl)));
        }
        for (int llllllllllIllllIIIIIlIIIIlIlllII = 0; llllllllllIllllIIIIIlIIIIlIlllII < this.sandPerChunk; ++llllllllllIllllIIIIIlIIIIlIlllII) {
            final int llllllllllIllllIIIIIlIIIIlIllIll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIllIlI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            this.gravelAsSandGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIIIIIllI.getTopSolidOrLiquidBlock(this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIllIll, 0, llllllllllIllllIIIIIlIIIIlIllIlI)));
        }
        int llllllllllIllllIIIIIlIIIIlIllIIl = this.treesPerChunk;
        if (llllllllllIllllIIIIIlIIIIIIIIlIl.nextFloat() < this.extraTreeChance) {
            ++llllllllllIllllIIIIIlIIIIlIllIIl;
        }
        for (int llllllllllIllllIIIIIlIIIIlIllIII = 0; llllllllllIllllIIIIIlIIIIlIllIII < llllllllllIllllIIIIIlIIIIlIllIIl; ++llllllllllIllllIIIIIlIIIIlIllIII) {
            final int llllllllllIllllIIIIIlIIIIlIlIlll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIlIllI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final WorldGenAbstractTree llllllllllIllllIIIIIlIIIIlIlIlIl = llllllllllIllllIIIIIlIIIIIIIIlll.genBigTreeChance(llllllllllIllllIIIIIlIIIIIIIIlIl);
            llllllllllIllllIIIIIlIIIIlIlIlIl.setDecorationDefaults();
            final BlockPos llllllllllIllllIIIIIlIIIIlIlIlII = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIlIlll, 0, llllllllllIllllIIIIIlIIIIlIlIllI));
            if (llllllllllIllllIIIIIlIIIIlIlIlIl.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIlIlIlII)) {
                llllllllllIllllIIIIIlIIIIlIlIlIl.generateSaplings(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIlIlIlII);
            }
        }
        for (int llllllllllIllllIIIIIlIIIIlIlIIll = 0; llllllllllIllllIIIIIlIIIIlIlIIll < this.bigMushroomsPerChunk; ++llllllllllIllllIIIIIlIIIIlIlIIll) {
            final int llllllllllIllllIIIIIlIIIIlIlIIlI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIlIIIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            this.bigMushroomGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIlIIlI, 0, llllllllllIllllIIIIIlIIIIlIlIIIl)));
        }
        for (int llllllllllIllllIIIIIlIIIIlIlIIII = 0; llllllllllIllllIIIIIlIIIIlIlIIII < this.flowersPerChunk; ++llllllllllIllllIIIIIlIIIIlIlIIII) {
            final int llllllllllIllllIIIIIlIIIIlIIllll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIIlllI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIIllIl = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIIllll, 0, llllllllllIllllIIIIIlIIIIlIIlllI)).getY() + 32;
            if (llllllllllIllllIIIIIlIIIIlIIllIl > 0) {
                final int llllllllllIllllIIIIIlIIIIlIIllII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIlIIllIl);
                final BlockPos llllllllllIllllIIIIIlIIIIlIIlIll = this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIIllll, llllllllllIllllIIIIIlIIIIlIIllII, llllllllllIllllIIIIIlIIIIlIIlllI);
                final BlockFlower.EnumFlowerType llllllllllIllllIIIIIlIIIIlIIlIlI = llllllllllIllllIIIIIlIIIIIIIIlll.pickRandomFlower(llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIlIIlIll);
                final BlockFlower llllllllllIllllIIIIIlIIIIlIIlIIl = llllllllllIllllIIIIIlIIIIlIIlIlI.getBlockType().getBlock();
                if (llllllllllIllllIIIIIlIIIIlIIlIIl.getDefaultState().getMaterial() != Material.AIR) {
                    this.yellowFlowerGen.setGeneratedBlock(llllllllllIllllIIIIIlIIIIlIIlIIl, llllllllllIllllIIIIIlIIIIlIIlIlI);
                    this.yellowFlowerGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIlIIlIll);
                }
            }
        }
        for (int llllllllllIllllIIIIIlIIIIlIIlIII = 0; llllllllllIllllIIIIIlIIIIlIIlIII < this.grassPerChunk; ++llllllllllIllllIIIIIlIIIIlIIlIII) {
            final int llllllllllIllllIIIIIlIIIIlIIIlll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIIIllI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIIIlIl = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIIIlll, 0, llllllllllIllllIIIIIlIIIIlIIIllI)).getY() * 2;
            if (llllllllllIllllIIIIIlIIIIlIIIlIl > 0) {
                final int llllllllllIllllIIIIIlIIIIlIIIlII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIlIIIlIl);
                llllllllllIllllIIIIIlIIIIIIIIlll.getRandomWorldGenForGrass(llllllllllIllllIIIIIlIIIIIIIIlIl).generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIIIlll, llllllllllIllllIIIIIlIIIIlIIIlII, llllllllllIllllIIIIIlIIIIlIIIllI));
            }
        }
        for (int llllllllllIllllIIIIIlIIIIlIIIIll = 0; llllllllllIllllIIIIIlIIIIlIIIIll < this.deadBushPerChunk; ++llllllllllIllllIIIIIlIIIIlIIIIll) {
            final int llllllllllIllllIIIIIlIIIIlIIIIlI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIIIIIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIlIIIIII = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIIIIlI, 0, llllllllllIllllIIIIIlIIIIlIIIIIl)).getY() * 2;
            if (llllllllllIllllIIIIIlIIIIlIIIIII > 0) {
                final int llllllllllIllllIIIIIlIIIIIllllll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIlIIIIII);
                new WorldGenDeadBush().generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, this.chunkPos.add(llllllllllIllllIIIIIlIIIIlIIIIlI, llllllllllIllllIIIIIlIIIIIllllll, llllllllllIllllIIIIIlIIIIlIIIIIl));
            }
        }
        for (int llllllllllIllllIIIIIlIIIIIlllllI = 0; llllllllllIllllIIIIIlIIIIIlllllI < this.waterlilyPerChunk; ++llllllllllIllllIIIIIlIIIIIlllllI) {
            final int llllllllllIllllIIIIIlIIIIIllllIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIllllII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIlllIll = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIIllllIl, 0, llllllllllIllllIIIIIlIIIIIllllII)).getY() * 2;
            if (llllllllllIllllIIIIIlIIIIIlllIll > 0) {
                final int llllllllllIllllIIIIIlIIIIIlllIlI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIlllIll);
                BlockPos llllllllllIllllIIIIIlIIIIIlllIIl;
                BlockPos llllllllllIllllIIIIIlIIIIIlllIII;
                for (llllllllllIllllIIIIIlIIIIIlllIIl = this.chunkPos.add(llllllllllIllllIIIIIlIIIIIllllIl, llllllllllIllllIIIIIlIIIIIlllIlI, llllllllllIllllIIIIIlIIIIIllllII); llllllllllIllllIIIIIlIIIIIlllIIl.getY() > 0; llllllllllIllllIIIIIlIIIIIlllIIl = llllllllllIllllIIIIIlIIIIIlllIII) {
                    llllllllllIllllIIIIIlIIIIIlllIII = llllllllllIllllIIIIIlIIIIIlllIIl.down();
                    if (!llllllllllIllllIIIIIlIIIIIIIIllI.isAirBlock(llllllllllIllllIIIIIlIIIIIlllIII)) {
                        break;
                    }
                }
                this.waterlilyGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIIlllIIl);
            }
        }
        for (int llllllllllIllllIIIIIlIIIIIllIlll = 0; llllllllllIllllIIIIIlIIIIIllIlll < this.mushroomsPerChunk; ++llllllllllIllllIIIIIlIIIIIllIlll) {
            if (llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(4) == 0) {
                final int llllllllllIllllIIIIIlIIIIIllIllI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
                final int llllllllllIllllIIIIIlIIIIIllIlIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
                final BlockPos llllllllllIllllIIIIIlIIIIIllIlII = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIIllIllI, 0, llllllllllIllllIIIIIlIIIIIllIlIl));
                this.mushroomBrownGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIIllIlII);
            }
            if (llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(8) == 0) {
                final int llllllllllIllllIIIIIlIIIIIllIIll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
                final int llllllllllIllllIIIIIlIIIIIllIIlI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
                final int llllllllllIllllIIIIIlIIIIIllIIIl = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIIllIIll, 0, llllllllllIllllIIIIIlIIIIIllIIlI)).getY() * 2;
                if (llllllllllIllllIIIIIlIIIIIllIIIl > 0) {
                    final int llllllllllIllllIIIIIlIIIIIllIIII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIllIIIl);
                    final BlockPos llllllllllIllllIIIIIlIIIIIlIllll = this.chunkPos.add(llllllllllIllllIIIIIlIIIIIllIIll, llllllllllIllllIIIIIlIIIIIllIIII, llllllllllIllllIIIIIlIIIIIllIIlI);
                    this.mushroomRedGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIIlIllll);
                }
            }
        }
        if (llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(4) == 0) {
            final int llllllllllIllllIIIIIlIIIIIlIlllI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIlIllIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIlIllII = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIIlIlllI, 0, llllllllllIllllIIIIIlIIIIIlIllIl)).getY() * 2;
            if (llllllllllIllllIIIIIlIIIIIlIllII > 0) {
                final int llllllllllIllllIIIIIlIIIIIlIlIll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIlIllII);
                this.mushroomBrownGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, this.chunkPos.add(llllllllllIllllIIIIIlIIIIIlIlllI, llllllllllIllllIIIIIlIIIIIlIlIll, llllllllllIllllIIIIIlIIIIIlIllIl));
            }
        }
        if (llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(8) == 0) {
            final int llllllllllIllllIIIIIlIIIIIlIlIlI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIlIlIIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIlIlIII = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIIlIlIlI, 0, llllllllllIllllIIIIIlIIIIIlIlIIl)).getY() * 2;
            if (llllllllllIllllIIIIIlIIIIIlIlIII > 0) {
                final int llllllllllIllllIIIIIlIIIIIlIIlll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIlIlIII);
                this.mushroomRedGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, this.chunkPos.add(llllllllllIllllIIIIIlIIIIIlIlIlI, llllllllllIllllIIIIIlIIIIIlIIlll, llllllllllIllllIIIIIlIIIIIlIlIIl));
            }
        }
        for (int llllllllllIllllIIIIIlIIIIIlIIllI = 0; llllllllllIllllIIIIIlIIIIIlIIllI < this.reedsPerChunk; ++llllllllllIllllIIIIIlIIIIIlIIllI) {
            final int llllllllllIllllIIIIIlIIIIIlIIlIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIlIIlII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIlIIIll = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIIlIIlIl, 0, llllllllllIllllIIIIIlIIIIIlIIlII)).getY() * 2;
            if (llllllllllIllllIIIIIlIIIIIlIIIll > 0) {
                final int llllllllllIllllIIIIIlIIIIIlIIIlI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIlIIIll);
                this.reedGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, this.chunkPos.add(llllllllllIllllIIIIIlIIIIIlIIlIl, llllllllllIllllIIIIIlIIIIIlIIIlI, llllllllllIllllIIIIIlIIIIIlIIlII));
            }
        }
        for (int llllllllllIllllIIIIIlIIIIIlIIIIl = 0; llllllllllIllllIIIIIlIIIIIlIIIIl < 10; ++llllllllllIllllIIIIIlIIIIIlIIIIl) {
            final int llllllllllIllllIIIIIlIIIIIlIIIII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIIlllll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIIllllI = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIIlIIIII, 0, llllllllllIllllIIIIIlIIIIIIlllll)).getY() * 2;
            if (llllllllllIllllIIIIIlIIIIIIllllI > 0) {
                final int llllllllllIllllIIIIIlIIIIIIlllIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIIllllI);
                this.reedGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, this.chunkPos.add(llllllllllIllllIIIIIlIIIIIlIIIII, llllllllllIllllIIIIIlIIIIIIlllIl, llllllllllIllllIIIIIlIIIIIIlllll));
            }
        }
        if (llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(32) == 0) {
            final int llllllllllIllllIIIIIlIIIIIIlllII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIIllIll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIIllIlI = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIIIlllII, 0, llllllllllIllllIIIIIlIIIIIIllIll)).getY() * 2;
            if (llllllllllIllllIIIIIlIIIIIIllIlI > 0) {
                final int llllllllllIllllIIIIIlIIIIIIllIIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIIllIlI);
                new WorldGenPumpkin().generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, this.chunkPos.add(llllllllllIllllIIIIIlIIIIIIlllII, llllllllllIllllIIIIIlIIIIIIllIIl, llllllllllIllllIIIIIlIIIIIIllIll));
            }
        }
        for (int llllllllllIllllIIIIIlIIIIIIllIII = 0; llllllllllIllllIIIIIlIIIIIIllIII < this.cactiPerChunk; ++llllllllllIllllIIIIIlIIIIIIllIII) {
            final int llllllllllIllllIIIIIlIIIIIIlIlll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIIlIllI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
            final int llllllllllIllllIIIIIlIIIIIIlIlIl = llllllllllIllllIIIIIlIIIIIIIIllI.getHeight(this.chunkPos.add(llllllllllIllllIIIIIlIIIIIIlIlll, 0, llllllllllIllllIIIIIlIIIIIIlIllI)).getY() * 2;
            if (llllllllllIllllIIIIIlIIIIIIlIlIl > 0) {
                final int llllllllllIllllIIIIIlIIIIIIlIlII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIIlIlIl);
                this.cactusGen.generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, this.chunkPos.add(llllllllllIllllIIIIIlIIIIIIlIlll, llllllllllIllllIIIIIlIIIIIIlIlII, llllllllllIllllIIIIIlIIIIIIlIllI));
            }
        }
        if (this.generateLakes) {
            for (int llllllllllIllllIIIIIlIIIIIIlIIll = 0; llllllllllIllllIIIIIlIIIIIIlIIll < 50; ++llllllllllIllllIIIIIlIIIIIIlIIll) {
                final int llllllllllIllllIIIIIlIIIIIIlIIlI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
                final int llllllllllIllllIIIIIlIIIIIIlIIIl = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
                final int llllllllllIllllIIIIIlIIIIIIlIIII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(248) + 8;
                if (llllllllllIllllIIIIIlIIIIIIlIIII > 0) {
                    final int llllllllllIllllIIIIIlIIIIIIIllll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIIlIIII);
                    final BlockPos llllllllllIllllIIIIIlIIIIIIIlllI = this.chunkPos.add(llllllllllIllllIIIIIlIIIIIIlIIlI, llllllllllIllllIIIIIlIIIIIIIllll, llllllllllIllllIIIIIlIIIIIIlIIIl);
                    new WorldGenLiquids(Blocks.FLOWING_WATER).generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIIIIlllI);
                }
            }
            for (int llllllllllIllllIIIIIlIIIIIIIllIl = 0; llllllllllIllllIIIIIlIIIIIIIllIl < 20; ++llllllllllIllllIIIIIlIIIIIIIllIl) {
                final int llllllllllIllllIIIIIlIIIIIIIllII = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
                final int llllllllllIllllIIIIIlIIIIIIIlIll = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(16) + 8;
                final int llllllllllIllllIIIIIlIIIIIIIlIlI = llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(llllllllllIllllIIIIIlIIIIIIIIlIl.nextInt(240) + 8) + 8);
                final BlockPos llllllllllIllllIIIIIlIIIIIIIlIIl = this.chunkPos.add(llllllllllIllllIIIIIlIIIIIIIllII, llllllllllIllllIIIIIlIIIIIIIlIlI, llllllllllIllllIIIIIlIIIIIIIlIll);
                new WorldGenLiquids(Blocks.FLOWING_LAVA).generate(llllllllllIllllIIIIIlIIIIIIIIllI, llllllllllIllllIIIIIlIIIIIIIIlIl, llllllllllIllllIIIIIlIIIIIIIlIIl);
            }
        }
    }
    
    public void decorate(final World llllllllllIllllIIIIIlIIIIlllllII, final Random llllllllllIllllIIIIIlIIIIlllIllI, final Biome llllllllllIllllIIIIIlIIIIllllIlI, final BlockPos llllllllllIllllIIIIIlIIIIllllIIl) {
        if (this.decorating) {
            throw new RuntimeException("Already decorating");
        }
        this.chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(llllllllllIllllIIIIIlIIIIlllllII.getWorldInfo().getGeneratorOptions()).build();
        this.chunkPos = llllllllllIllllIIIIIlIIIIllllIIl;
        this.dirtGen = new WorldGenMinable(Blocks.DIRT.getDefaultState(), this.chunkProviderSettings.dirtSize);
        this.gravelGen = new WorldGenMinable(Blocks.GRAVEL.getDefaultState(), this.chunkProviderSettings.gravelSize);
        this.graniteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), this.chunkProviderSettings.graniteSize);
        this.dioriteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), this.chunkProviderSettings.dioriteSize);
        this.andesiteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), this.chunkProviderSettings.andesiteSize);
        this.coalGen = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), this.chunkProviderSettings.coalSize);
        this.ironGen = new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), this.chunkProviderSettings.ironSize);
        this.goldGen = new WorldGenMinable(Blocks.GOLD_ORE.getDefaultState(), this.chunkProviderSettings.goldSize);
        this.redstoneGen = new WorldGenMinable(Blocks.REDSTONE_ORE.getDefaultState(), this.chunkProviderSettings.redstoneSize);
        this.diamondGen = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), this.chunkProviderSettings.diamondSize);
        this.lapisGen = new WorldGenMinable(Blocks.LAPIS_ORE.getDefaultState(), this.chunkProviderSettings.lapisSize);
        this.genDecorations(llllllllllIllllIIIIIlIIIIllllIlI, llllllllllIllllIIIIIlIIIIlllllII, llllllllllIllllIIIIIlIIIIlllIllI);
        this.decorating = false;
    }
    
    protected void genStandardOre2(final World llllllllllIllllIIIIIIlllllIIIIll, final Random llllllllllIllllIIIIIIlllllIIlIll, final int llllllllllIllllIIIIIIlllllIIlIlI, final WorldGenerator llllllllllIllllIIIIIIlllllIIIIII, final int llllllllllIllllIIIIIIlllllIIlIII, final int llllllllllIllllIIIIIIllllIlllllI) {
        for (int llllllllllIllllIIIIIIlllllIIIllI = 0; llllllllllIllllIIIIIIlllllIIIllI < llllllllllIllllIIIIIIlllllIIlIlI; ++llllllllllIllllIIIIIIlllllIIIllI) {
            final BlockPos llllllllllIllllIIIIIIlllllIIIlIl = this.chunkPos.add(llllllllllIllllIIIIIIlllllIIlIll.nextInt(16), llllllllllIllllIIIIIIlllllIIlIll.nextInt(llllllllllIllllIIIIIIllllIlllllI) + llllllllllIllllIIIIIIlllllIIlIll.nextInt(llllllllllIllllIIIIIIllllIlllllI) + llllllllllIllllIIIIIIlllllIIlIII - llllllllllIllllIIIIIIllllIlllllI, llllllllllIllllIIIIIIlllllIIlIll.nextInt(16));
            llllllllllIllllIIIIIIlllllIIIIII.generate(llllllllllIllllIIIIIIlllllIIIIll, llllllllllIllllIIIIIIlllllIIlIll, llllllllllIllllIIIIIIlllllIIIlIl);
        }
    }
    
    public BiomeDecorator() {
        this.clayGen = new WorldGenClay(4);
        this.sandGen = new WorldGenSand(Blocks.SAND, 7);
        this.gravelAsSandGen = new WorldGenSand(Blocks.GRAVEL, 6);
        this.yellowFlowerGen = new WorldGenFlowers(Blocks.YELLOW_FLOWER, BlockFlower.EnumFlowerType.DANDELION);
        this.mushroomBrownGen = new WorldGenBush(Blocks.BROWN_MUSHROOM);
        this.mushroomRedGen = new WorldGenBush(Blocks.RED_MUSHROOM);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.reedGen = new WorldGenReed();
        this.cactusGen = new WorldGenCactus();
        this.waterlilyGen = new WorldGenWaterlily();
        this.extraTreeChance = 0.1f;
        this.flowersPerChunk = 2;
        this.grassPerChunk = 1;
        this.sandPerChunk = 1;
        this.sandPerChunk2 = 3;
        this.clayPerChunk = 1;
        this.generateLakes = true;
    }
    
    protected void genStandardOre1(final World llllllllllIllllIIIIIIllllllIlIII, final Random llllllllllIllllIIIIIIllllllIIlll, final int llllllllllIllllIIIIIIllllllIIllI, final WorldGenerator llllllllllIllllIIIIIIlllllIllIll, int llllllllllIllllIIIIIIlllllIllIlI, int llllllllllIllllIIIIIIlllllIllIIl) {
        if (llllllllllIllllIIIIIIlllllIllIIl < llllllllllIllllIIIIIIlllllIllIlI) {
            final int llllllllllIllllIIIIIIllllllIIIlI = llllllllllIllllIIIIIIlllllIllIlI;
            llllllllllIllllIIIIIIlllllIllIlI = llllllllllIllllIIIIIIlllllIllIIl;
            llllllllllIllllIIIIIIlllllIllIIl = llllllllllIllllIIIIIIllllllIIIlI;
        }
        else if (llllllllllIllllIIIIIIlllllIllIIl == llllllllllIllllIIIIIIlllllIllIlI) {
            if (llllllllllIllllIIIIIIlllllIllIlI < 255) {
                ++llllllllllIllllIIIIIIlllllIllIIl;
            }
            else {
                --llllllllllIllllIIIIIIlllllIllIlI;
            }
        }
        for (int llllllllllIllllIIIIIIllllllIIIIl = 0; llllllllllIllllIIIIIIllllllIIIIl < llllllllllIllllIIIIIIllllllIIllI; ++llllllllllIllllIIIIIIllllllIIIIl) {
            final BlockPos llllllllllIllllIIIIIIllllllIIIII = this.chunkPos.add(llllllllllIllllIIIIIIllllllIIlll.nextInt(16), llllllllllIllllIIIIIIllllllIIlll.nextInt(llllllllllIllllIIIIIIlllllIllIIl - llllllllllIllllIIIIIIlllllIllIlI) + llllllllllIllllIIIIIIlllllIllIlI, llllllllllIllllIIIIIIllllllIIlll.nextInt(16));
            llllllllllIllllIIIIIIlllllIllIll.generate(llllllllllIllllIIIIIIllllllIlIII, llllllllllIllllIIIIIIllllllIIlll, llllllllllIllllIIIIIIllllllIIIII);
        }
    }
}
