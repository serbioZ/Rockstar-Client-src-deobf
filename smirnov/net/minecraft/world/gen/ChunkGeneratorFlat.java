// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureOceanMonument;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenVillage;
import java.util.HashMap;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenStructure;
import java.util.Map;

public class ChunkGeneratorFlat implements IChunkGenerator
{
    private final /* synthetic */ boolean hasDungeons;
    private final /* synthetic */ Map<String, MapGenStructure> structureGenerators;
    private /* synthetic */ WorldGenLakes lavaLakeGenerator;
    private final /* synthetic */ IBlockState[] cachedBlockIDs;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ FlatGeneratorInfo flatWorldGenInfo;
    private /* synthetic */ WorldGenLakes waterLakeGenerator;
    private final /* synthetic */ Random random;
    private final /* synthetic */ boolean hasDecoration;
    
    public ChunkGeneratorFlat(final World llllllllllllIllIIIIIlllIIllIlIll, final long llllllllllllIllIIIIIlllIIllIlIlI, final boolean llllllllllllIllIIIIIlllIIlIlllII, final String llllllllllllIllIIIIIlllIIlIllIll) {
        this.cachedBlockIDs = new IBlockState[256];
        this.structureGenerators = new HashMap<String, MapGenStructure>();
        this.worldObj = llllllllllllIllIIIIIlllIIllIlIll;
        this.random = new Random(llllllllllllIllIIIIIlllIIllIlIlI);
        this.flatWorldGenInfo = FlatGeneratorInfo.createFlatGeneratorFromString(llllllllllllIllIIIIIlllIIlIllIll);
        if (llllllllllllIllIIIIIlllIIlIlllII) {
            final Map<String, Map<String, String>> llllllllllllIllIIIIIlllIIllIIlll = this.flatWorldGenInfo.getWorldFeatures();
            if (llllllllllllIllIIIIIlllIIllIIlll.containsKey("village")) {
                final Map<String, String> llllllllllllIllIIIIIlllIIllIIllI = llllllllllllIllIIIIIlllIIllIIlll.get("village");
                if (!llllllllllllIllIIIIIlllIIllIIllI.containsKey("size")) {
                    llllllllllllIllIIIIIlllIIllIIllI.put("size", "1");
                }
                this.structureGenerators.put("Village", new MapGenVillage(llllllllllllIllIIIIIlllIIllIIllI));
            }
            if (llllllllllllIllIIIIIlllIIllIIlll.containsKey("biome_1")) {
                this.structureGenerators.put("Temple", new MapGenScatteredFeature(llllllllllllIllIIIIIlllIIllIIlll.get("biome_1")));
            }
            if (llllllllllllIllIIIIIlllIIllIIlll.containsKey("mineshaft")) {
                this.structureGenerators.put("Mineshaft", new MapGenMineshaft(llllllllllllIllIIIIIlllIIllIIlll.get("mineshaft")));
            }
            if (llllllllllllIllIIIIIlllIIllIIlll.containsKey("stronghold")) {
                this.structureGenerators.put("Stronghold", new MapGenStronghold(llllllllllllIllIIIIIlllIIllIIlll.get("stronghold")));
            }
            if (llllllllllllIllIIIIIlllIIllIIlll.containsKey("oceanmonument")) {
                this.structureGenerators.put("Monument", new StructureOceanMonument(llllllllllllIllIIIIIlllIIllIIlll.get("oceanmonument")));
            }
        }
        if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lake")) {
            this.waterLakeGenerator = new WorldGenLakes(Blocks.WATER);
        }
        if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lava_lake")) {
            this.lavaLakeGenerator = new WorldGenLakes(Blocks.LAVA);
        }
        this.hasDungeons = this.flatWorldGenInfo.getWorldFeatures().containsKey("dungeon");
        int llllllllllllIllIIIIIlllIIllIIlIl = 0;
        int llllllllllllIllIIIIIlllIIllIIlII = 0;
        boolean llllllllllllIllIIIIIlllIIllIIIll = true;
        for (final FlatLayerInfo llllllllllllIllIIIIIlllIIllIIIlI : this.flatWorldGenInfo.getFlatLayers()) {
            for (int llllllllllllIllIIIIIlllIIllIIIIl = llllllllllllIllIIIIIlllIIllIIIlI.getMinY(); llllllllllllIllIIIIIlllIIllIIIIl < llllllllllllIllIIIIIlllIIllIIIlI.getMinY() + llllllllllllIllIIIIIlllIIllIIIlI.getLayerCount(); ++llllllllllllIllIIIIIlllIIllIIIIl) {
                final IBlockState llllllllllllIllIIIIIlllIIllIIIII = llllllllllllIllIIIIIlllIIllIIIlI.getLayerMaterial();
                if (llllllllllllIllIIIIIlllIIllIIIII.getBlock() != Blocks.AIR) {
                    llllllllllllIllIIIIIlllIIllIIIll = false;
                    this.cachedBlockIDs[llllllllllllIllIIIIIlllIIllIIIIl] = llllllllllllIllIIIIIlllIIllIIIII;
                }
            }
            if (llllllllllllIllIIIIIlllIIllIIIlI.getLayerMaterial().getBlock() == Blocks.AIR) {
                llllllllllllIllIIIIIlllIIllIIlII += llllllllllllIllIIIIIlllIIllIIIlI.getLayerCount();
            }
            else {
                llllllllllllIllIIIIIlllIIllIIlIl += llllllllllllIllIIIIIlllIIllIIIlI.getLayerCount() + llllllllllllIllIIIIIlllIIllIIlII;
                llllllllllllIllIIIIIlllIIllIIlII = 0;
            }
        }
        llllllllllllIllIIIIIlllIIllIlIll.setSeaLevel(llllllllllllIllIIIIIlllIIllIIlIl);
        this.hasDecoration = ((!llllllllllllIllIIIIIlllIIllIIIll || this.flatWorldGenInfo.getBiome() == Biome.getIdForBiome(Biomes.VOID)) && this.flatWorldGenInfo.getWorldFeatures().containsKey("decoration"));
    }
    
    @Override
    public void recreateStructures(final Chunk llllllllllllIllIIIIIllIlllIlIllI, final int llllllllllllIllIIIIIllIlllIlIlIl, final int llllllllllllIllIIIIIllIlllIlIIII) {
        for (final MapGenStructure llllllllllllIllIIIIIllIlllIlIIll : this.structureGenerators.values()) {
            llllllllllllIllIIIIIllIlllIlIIll.generate(this.worldObj, llllllllllllIllIIIIIllIlllIlIlIl, llllllllllllIllIIIIIllIlllIlIIII, null);
        }
    }
    
    @Override
    public void populate(final int llllllllllllIllIIIIIlllIIIIllIII, final int llllllllllllIllIIIIIlllIIIIlIlll) {
        final int llllllllllllIllIIIIIlllIIIlIIlIl = llllllllllllIllIIIIIlllIIIIllIII * 16;
        final int llllllllllllIllIIIIIlllIIIlIIlII = llllllllllllIllIIIIIlllIIIIlIlll * 16;
        final BlockPos llllllllllllIllIIIIIlllIIIlIIIll = new BlockPos(llllllllllllIllIIIIIlllIIIlIIlIl, 0, llllllllllllIllIIIIIlllIIIlIIlII);
        final Biome llllllllllllIllIIIIIlllIIIlIIIlI = this.worldObj.getBiome(new BlockPos(llllllllllllIllIIIIIlllIIIlIIlIl + 16, 0, llllllllllllIllIIIIIlllIIIlIIlII + 16));
        boolean llllllllllllIllIIIIIlllIIIlIIIIl = false;
        this.random.setSeed(this.worldObj.getSeed());
        final long llllllllllllIllIIIIIlllIIIlIIIII = this.random.nextLong() / 2L * 2L + 1L;
        final long llllllllllllIllIIIIIlllIIIIlllll = this.random.nextLong() / 2L * 2L + 1L;
        this.random.setSeed(llllllllllllIllIIIIIlllIIIIllIII * llllllllllllIllIIIIIlllIIIlIIIII + llllllllllllIllIIIIIlllIIIIlIlll * llllllllllllIllIIIIIlllIIIIlllll ^ this.worldObj.getSeed());
        final ChunkPos llllllllllllIllIIIIIlllIIIIllllI = new ChunkPos(llllllllllllIllIIIIIlllIIIIllIII, llllllllllllIllIIIIIlllIIIIlIlll);
        for (final MapGenStructure llllllllllllIllIIIIIlllIIIIlllIl : this.structureGenerators.values()) {
            final boolean llllllllllllIllIIIIIlllIIIIlllII = llllllllllllIllIIIIIlllIIIIlllIl.generateStructure(this.worldObj, this.random, llllllllllllIllIIIIIlllIIIIllllI);
            if (llllllllllllIllIIIIIlllIIIIlllIl instanceof MapGenVillage) {
                llllllllllllIllIIIIIlllIIIlIIIIl |= llllllllllllIllIIIIIlllIIIIlllII;
            }
        }
        if (this.waterLakeGenerator != null && !llllllllllllIllIIIIIlllIIIlIIIIl && this.random.nextInt(4) == 0) {
            this.waterLakeGenerator.generate(this.worldObj, this.random, llllllllllllIllIIIIIlllIIIlIIIll.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
        }
        if (this.lavaLakeGenerator != null && !llllllllllllIllIIIIIlllIIIlIIIIl && this.random.nextInt(8) == 0) {
            final BlockPos llllllllllllIllIIIIIlllIIIIllIll = llllllllllllIllIIIIIlllIIIlIIIll.add(this.random.nextInt(16) + 8, this.random.nextInt(this.random.nextInt(248) + 8), this.random.nextInt(16) + 8);
            if (llllllllllllIllIIIIIlllIIIIllIll.getY() < this.worldObj.getSeaLevel() || this.random.nextInt(10) == 0) {
                this.lavaLakeGenerator.generate(this.worldObj, this.random, llllllllllllIllIIIIIlllIIIIllIll);
            }
        }
        if (this.hasDungeons) {
            for (int llllllllllllIllIIIIIlllIIIIllIlI = 0; llllllllllllIllIIIIIlllIIIIllIlI < 8; ++llllllllllllIllIIIIIlllIIIIllIlI) {
                new WorldGenDungeons().generate(this.worldObj, this.random, llllllllllllIllIIIIIlllIIIlIIIll.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
            }
        }
        if (this.hasDecoration) {
            llllllllllllIllIIIIIlllIIIlIIIlI.decorate(this.worldObj, this.random, llllllllllllIllIIIIIlllIIIlIIIll);
        }
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType llllllllllllIllIIIIIllIllllllllI, final BlockPos llllllllllllIllIIIIIlllIIIIIIIIl) {
        final Biome llllllllllllIllIIIIIlllIIIIIIIII = this.worldObj.getBiome(llllllllllllIllIIIIIlllIIIIIIIIl);
        return llllllllllllIllIIIIIlllIIIIIIIII.getSpawnableList(llllllllllllIllIIIIIllIllllllllI);
    }
    
    @Override
    public boolean func_193414_a(final World llllllllllllIllIIIIIllIllllIIlII, final String llllllllllllIllIIIIIllIlllIlllll, final BlockPos llllllllllllIllIIIIIllIlllIllllI) {
        final MapGenStructure llllllllllllIllIIIIIllIllllIIIIl = this.structureGenerators.get(llllllllllllIllIIIIIllIlllIlllll);
        return llllllllllllIllIIIIIllIllllIIIIl != null && llllllllllllIllIIIIIllIllllIIIIl.isInsideStructure(llllllllllllIllIIIIIllIlllIllllI);
    }
    
    @Override
    public boolean generateStructures(final Chunk llllllllllllIllIIIIIlllIIIIIlIlI, final int llllllllllllIllIIIIIlllIIIIIlIIl, final int llllllllllllIllIIIIIlllIIIIIlIII) {
        return false;
    }
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World llllllllllllIllIIIIIllIlllllIlII, final String llllllllllllIllIIIIIllIllllIllIl, final BlockPos llllllllllllIllIIIIIllIlllllIIlI, final boolean llllllllllllIllIIIIIllIlllllIIIl) {
        final MapGenStructure llllllllllllIllIIIIIllIlllllIIII = this.structureGenerators.get(llllllllllllIllIIIIIllIllllIllIl);
        return (llllllllllllIllIIIIIllIlllllIIII != null) ? llllllllllllIllIIIIIllIlllllIIII.getClosestStrongholdPos(llllllllllllIllIIIIIllIlllllIlII, llllllllllllIllIIIIIllIlllllIIlI, llllllllllllIllIIIIIllIlllllIIIl) : null;
    }
    
    @Override
    public Chunk provideChunk(final int llllllllllllIllIIIIIlllIIIllllIl, final int llllllllllllIllIIIIIlllIIlIIlIIl) {
        final ChunkPrimer llllllllllllIllIIIIIlllIIlIIlIII = new ChunkPrimer();
        for (int llllllllllllIllIIIIIlllIIlIIIlll = 0; llllllllllllIllIIIIIlllIIlIIIlll < this.cachedBlockIDs.length; ++llllllllllllIllIIIIIlllIIlIIIlll) {
            final IBlockState llllllllllllIllIIIIIlllIIlIIIllI = this.cachedBlockIDs[llllllllllllIllIIIIIlllIIlIIIlll];
            if (llllllllllllIllIIIIIlllIIlIIIllI != null) {
                for (int llllllllllllIllIIIIIlllIIlIIIlIl = 0; llllllllllllIllIIIIIlllIIlIIIlIl < 16; ++llllllllllllIllIIIIIlllIIlIIIlIl) {
                    for (int llllllllllllIllIIIIIlllIIlIIIlII = 0; llllllllllllIllIIIIIlllIIlIIIlII < 16; ++llllllllllllIllIIIIIlllIIlIIIlII) {
                        llllllllllllIllIIIIIlllIIlIIlIII.setBlockState(llllllllllllIllIIIIIlllIIlIIIlIl, llllllllllllIllIIIIIlllIIlIIIlll, llllllllllllIllIIIIIlllIIlIIIlII, llllllllllllIllIIIIIlllIIlIIIllI);
                    }
                }
            }
        }
        for (final MapGenBase llllllllllllIllIIIIIlllIIlIIIIll : this.structureGenerators.values()) {
            llllllllllllIllIIIIIlllIIlIIIIll.generate(this.worldObj, llllllllllllIllIIIIIlllIIIllllIl, llllllllllllIllIIIIIlllIIlIIlIIl, llllllllllllIllIIIIIlllIIlIIlIII);
        }
        final Chunk llllllllllllIllIIIIIlllIIlIIIIlI = new Chunk(this.worldObj, llllllllllllIllIIIIIlllIIlIIlIII, llllllllllllIllIIIIIlllIIIllllIl, llllllllllllIllIIIIIlllIIlIIlIIl);
        final Biome[] llllllllllllIllIIIIIlllIIlIIIIIl = this.worldObj.getBiomeProvider().getBiomes(null, llllllllllllIllIIIIIlllIIIllllIl * 16, llllllllllllIllIIIIIlllIIlIIlIIl * 16, 16, 16);
        final byte[] llllllllllllIllIIIIIlllIIlIIIIII = llllllllllllIllIIIIIlllIIlIIIIlI.getBiomeArray();
        for (int llllllllllllIllIIIIIlllIIIllllll = 0; llllllllllllIllIIIIIlllIIIllllll < llllllllllllIllIIIIIlllIIlIIIIII.length; ++llllllllllllIllIIIIIlllIIIllllll) {
            llllllllllllIllIIIIIlllIIlIIIIII[llllllllllllIllIIIIIlllIIIllllll] = (byte)Biome.getIdForBiome(llllllllllllIllIIIIIlllIIlIIIIIl[llllllllllllIllIIIIIlllIIIllllll]);
        }
        llllllllllllIllIIIIIlllIIlIIIIlI.generateSkylightMap();
        return llllllllllllIllIIIIIlllIIlIIIIlI;
    }
}
