// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.util.WeightedRandom;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntitySheep;
import com.google.common.collect.Lists;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.block.BlockFlower;
import java.util.Collections;
import net.minecraft.init.Blocks;
import org.apache.logging.log4j.LogManager;
import net.minecraft.world.World;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenSwamp;
import net.minecraft.world.gen.feature.WorldGenDoublePlant;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import javax.annotation.Nullable;
import java.util.List;

public abstract class Biome
{
    private final /* synthetic */ float temperature;
    protected /* synthetic */ List<SpawnListEntry> spawnableMonsterList;
    private final /* synthetic */ String biomeName;
    @Nullable
    private final /* synthetic */ String baseBiomeRegName;
    protected static final /* synthetic */ NoiseGeneratorPerlin TEMPERATURE_NOISE;
    private final /* synthetic */ float baseHeight;
    private final /* synthetic */ float heightVariation;
    private final /* synthetic */ int waterColor;
    protected static final /* synthetic */ IBlockState GRAVEL;
    private final /* synthetic */ boolean enableSnow;
    protected static final /* synthetic */ IBlockState ICE;
    public /* synthetic */ BiomeDecorator theBiomeDecorator;
    protected /* synthetic */ List<SpawnListEntry> spawnableWaterCreatureList;
    public static final /* synthetic */ ObjectIntIdentityMap<Biome> MUTATION_TO_BASE_ID_MAP;
    protected static final /* synthetic */ IBlockState BEDROCK;
    private final /* synthetic */ float rainfall;
    public static final /* synthetic */ RegistryNamespaced<ResourceLocation, Biome> REGISTRY;
    private final /* synthetic */ boolean enableRain;
    protected static final /* synthetic */ IBlockState STONE;
    protected static final /* synthetic */ IBlockState RED_SANDSTONE;
    public /* synthetic */ IBlockState fillerBlock;
    public /* synthetic */ IBlockState topBlock;
    protected /* synthetic */ List<SpawnListEntry> spawnableCaveCreatureList;
    protected static final /* synthetic */ WorldGenBigTree BIG_TREE_FEATURE;
    protected static final /* synthetic */ IBlockState SANDSTONE;
    protected /* synthetic */ List<SpawnListEntry> spawnableCreatureList;
    protected static final /* synthetic */ IBlockState WATER;
    protected static final /* synthetic */ WorldGenTrees TREE_FEATURE;
    protected static final /* synthetic */ IBlockState AIR;
    
    public final String getBiomeName() {
        return this.biomeName;
    }
    
    public final float getHeightVariation() {
        return this.heightVariation;
    }
    
    public WorldGenerator getRandomWorldGenForGrass(final Random llllllllllIlllIlIllIIIlllIIIIIlI) {
        return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    public Class<? extends Biome> getBiomeClass() {
        return this.getClass();
    }
    
    public final float getBaseHeight() {
        return this.baseHeight;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$entity$EnumCreatureType() {
        final int[] $switch_TABLE$net$minecraft$entity$EnumCreatureType = Biome.$SWITCH_TABLE$net$minecraft$entity$EnumCreatureType;
        if ($switch_TABLE$net$minecraft$entity$EnumCreatureType != null) {
            return $switch_TABLE$net$minecraft$entity$EnumCreatureType;
        }
        final Exception llllllllllIlllIlIllIIIlIllIIIIIl = (Object)new int[EnumCreatureType.values().length];
        try {
            llllllllllIlllIlIllIIIlIllIIIIIl[EnumCreatureType.AMBIENT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIlIllIIIlIllIIIIIl[EnumCreatureType.CREATURE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIlIllIIIlIllIIIIIl[EnumCreatureType.MONSTER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllIlllIlIllIIIlIllIIIIIl[EnumCreatureType.WATER_CREATURE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return Biome.$SWITCH_TABLE$net$minecraft$entity$EnumCreatureType = (int[])(Object)llllllllllIlllIlIllIIIlIllIIIIIl;
    }
    
    public int getFoliageColorAtPos(final BlockPos llllllllllIlllIlIllIIIllIlIIIIlI) {
        final double llllllllllIlllIlIllIIIllIlIIIIIl = MathHelper.clamp(this.getFloatTemperature(llllllllllIlllIlIllIIIllIlIIIIlI), 0.0f, 1.0f);
        final double llllllllllIlllIlIllIIIllIlIIIIII = MathHelper.clamp(this.getRainfall(), 0.0f, 1.0f);
        return ColorizerFoliage.getFoliageColor(llllllllllIlllIlIllIIIllIlIIIIIl, llllllllllIlllIlIllIIIllIlIIIIII);
    }
    
    public boolean getEnableSnow() {
        return this.isSnowyBiome();
    }
    
    public boolean isHighHumidity() {
        return this.getRainfall() > 0.85f;
    }
    
    public static int getIdForBiome(final Biome llllllllllIlllIlIllIIIlllIIllIIl) {
        return Biome.REGISTRY.getIDForObject(llllllllllIlllIlIllIIIlllIIllIIl);
    }
    
    public int getSkyColorByTemp(float llllllllllIlllIlIllIIIllIllllIIl) {
        llllllllllIlllIlIllIIIllIllllIIl /= 3.0f;
        llllllllllIlllIlIllIIIllIllllIIl = MathHelper.clamp(llllllllllIlllIlIllIIIllIllllIIl, -1.0f, 1.0f);
        return MathHelper.hsvToRGB(0.62222224f - llllllllllIlllIlIllIIIllIllllIIl * 0.05f, 0.5f + llllllllllIlllIlIllIIIllIllllIIl * 0.1f, 1.0f);
    }
    
    public float getSpawningChance() {
        return 0.1f;
    }
    
    public TempCategory getTempCategory() {
        if (this.getTemperature() < 0.2) {
            return TempCategory.COLD;
        }
        return (this.getTemperature() < 1.0) ? TempCategory.MEDIUM : TempCategory.WARM;
    }
    
    public final float getRainfall() {
        return this.rainfall;
    }
    
    public final float getFloatTemperature(final BlockPos llllllllllIlllIlIllIIIllIllIIlII) {
        if (llllllllllIlllIlIllIIIllIllIIlII.getY() > 64) {
            final float llllllllllIlllIlIllIIIllIllIIIll = (float)(Biome.TEMPERATURE_NOISE.getValue(llllllllllIlllIlIllIIIllIllIIlII.getX() / 8.0f, llllllllllIlllIlIllIIIllIllIIlII.getZ() / 8.0f) * 4.0);
            return this.getTemperature() - (llllllllllIlllIlIllIIIllIllIIIll + llllllllllIlllIlIllIIIllIllIIlII.getY() - 64.0f) * 0.05f / 30.0f;
        }
        return this.getTemperature();
    }
    
    @Nullable
    public static Biome getBiomeForId(final int llllllllllIlllIlIllIIIlllIIlIlIl) {
        return Biome.REGISTRY.getObjectById(llllllllllIlllIlIllIIIlllIIlIlIl);
    }
    
    public void decorate(final World llllllllllIlllIlIllIIIllIlIllIlI, final Random llllllllllIlllIlIllIIIllIlIllIIl, final BlockPos llllllllllIlllIlIllIIIllIlIllIII) {
        this.theBiomeDecorator.decorate(llllllllllIlllIlIllIIIllIlIllIlI, llllllllllIlllIlIllIIIllIlIllIIl, this, llllllllllIlllIlIllIIIllIlIllIII);
    }
    
    public final float getTemperature() {
        return this.temperature;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        STONE = Blocks.STONE.getDefaultState();
        AIR = Blocks.AIR.getDefaultState();
        BEDROCK = Blocks.BEDROCK.getDefaultState();
        GRAVEL = Blocks.GRAVEL.getDefaultState();
        RED_SANDSTONE = Blocks.RED_SANDSTONE.getDefaultState();
        SANDSTONE = Blocks.SANDSTONE.getDefaultState();
        ICE = Blocks.ICE.getDefaultState();
        WATER = Blocks.WATER.getDefaultState();
        MUTATION_TO_BASE_ID_MAP = new ObjectIntIdentityMap<Biome>();
        TEMPERATURE_NOISE = new NoiseGeneratorPerlin(new Random(1234L), 1);
        GRASS_COLOR_NOISE = new NoiseGeneratorPerlin(new Random(2345L), 1);
        DOUBLE_PLANT_GENERATOR = new WorldGenDoublePlant();
        TREE_FEATURE = new WorldGenTrees(false);
        BIG_TREE_FEATURE = new WorldGenBigTree(false);
        SWAMP_FEATURE = new WorldGenSwamp();
        REGISTRY = new RegistryNamespaced<ResourceLocation, Biome>();
    }
    
    public boolean isMutation() {
        return this.baseBiomeRegName != null;
    }
    
    public List<SpawnListEntry> getSpawnableList(final EnumCreatureType llllllllllIlllIlIllIIIllIlllIIll) {
        switch ($SWITCH_TABLE$net$minecraft$entity$EnumCreatureType()[llllllllllIlllIlIllIIIllIlllIIll.ordinal()]) {
            case 1: {
                return this.spawnableMonsterList;
            }
            case 2: {
                return this.spawnableCreatureList;
            }
            case 4: {
                return this.spawnableWaterCreatureList;
            }
            case 3: {
                return this.spawnableCaveCreatureList;
            }
            default: {
                return Collections.emptyList();
            }
        }
    }
    
    public final boolean isSnowyBiome() {
        return this.enableSnow;
    }
    
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random llllllllllIlllIlIllIIIllIlllllll, final BlockPos llllllllllIlllIlIllIIIllIllllllI) {
        return (llllllllllIlllIlIllIIIllIlllllll.nextInt(3) > 0) ? BlockFlower.EnumFlowerType.DANDELION : BlockFlower.EnumFlowerType.POPPY;
    }
    
    public final int getWaterColor() {
        return this.waterColor;
    }
    
    private static void registerBiome(final int llllllllllIlllIlIllIIIlIllIIIlIl, final String llllllllllIlllIlIllIIIlIllIIIlII, final Biome llllllllllIlllIlIllIIIlIllIIIIll) {
        Biome.REGISTRY.register(llllllllllIlllIlIllIIIlIllIIIlIl, new ResourceLocation(llllllllllIlllIlIllIIIlIllIIIlII), llllllllllIlllIlIllIIIlIllIIIIll);
        if (llllllllllIlllIlIllIIIlIllIIIIll.isMutation()) {
            Biome.MUTATION_TO_BASE_ID_MAP.put(llllllllllIlllIlIllIIIlIllIIIIll, getIdForBiome(Biome.REGISTRY.getObject(new ResourceLocation(llllllllllIlllIlIllIIIlIllIIIIll.baseBiomeRegName))));
        }
    }
    
    public final void generateBiomeTerrain(final World llllllllllIlllIlIllIIIllIIIIIIll, final Random llllllllllIlllIlIllIIIllIIIIIIlI, final ChunkPrimer llllllllllIlllIlIllIIIllIIIIIIIl, final int llllllllllIlllIlIllIIIllIIIlIIIl, final int llllllllllIlllIlIllIIIllIIIlIIII, final double llllllllllIlllIlIllIIIlIlllllllI) {
        final int llllllllllIlllIlIllIIIllIIIIlllI = llllllllllIlllIlIllIIIllIIIIIIll.getSeaLevel();
        IBlockState llllllllllIlllIlIllIIIllIIIIllIl = this.topBlock;
        IBlockState llllllllllIlllIlIllIIIllIIIIllII = this.fillerBlock;
        int llllllllllIlllIlIllIIIllIIIIlIll = -1;
        final int llllllllllIlllIlIllIIIllIIIIlIlI = (int)(llllllllllIlllIlIllIIIlIlllllllI / 3.0 + 3.0 + llllllllllIlllIlIllIIIllIIIIIIlI.nextDouble() * 0.25);
        final int llllllllllIlllIlIllIIIllIIIIlIIl = llllllllllIlllIlIllIIIllIIIlIIIl & 0xF;
        final int llllllllllIlllIlIllIIIllIIIIlIII = llllllllllIlllIlIllIIIllIIIlIIII & 0xF;
        final BlockPos.MutableBlockPos llllllllllIlllIlIllIIIllIIIIIlll = new BlockPos.MutableBlockPos();
        for (int llllllllllIlllIlIllIIIllIIIIIllI = 255; llllllllllIlllIlIllIIIllIIIIIllI >= 0; --llllllllllIlllIlIllIIIllIIIIIllI) {
            if (llllllllllIlllIlIllIIIllIIIIIllI <= llllllllllIlllIlIllIIIllIIIIIIlI.nextInt(5)) {
                llllllllllIlllIlIllIIIllIIIIIIIl.setBlockState(llllllllllIlllIlIllIIIllIIIIlIII, llllllllllIlllIlIllIIIllIIIIIllI, llllllllllIlllIlIllIIIllIIIIlIIl, Biome.BEDROCK);
            }
            else {
                final IBlockState llllllllllIlllIlIllIIIllIIIIIlIl = llllllllllIlllIlIllIIIllIIIIIIIl.getBlockState(llllllllllIlllIlIllIIIllIIIIlIII, llllllllllIlllIlIllIIIllIIIIIllI, llllllllllIlllIlIllIIIllIIIIlIIl);
                if (llllllllllIlllIlIllIIIllIIIIIlIl.getMaterial() == Material.AIR) {
                    llllllllllIlllIlIllIIIllIIIIlIll = -1;
                }
                else if (llllllllllIlllIlIllIIIllIIIIIlIl.getBlock() == Blocks.STONE) {
                    if (llllllllllIlllIlIllIIIllIIIIlIll == -1) {
                        if (llllllllllIlllIlIllIIIllIIIIlIlI <= 0) {
                            llllllllllIlllIlIllIIIllIIIIllIl = Biome.AIR;
                            llllllllllIlllIlIllIIIllIIIIllII = Biome.STONE;
                        }
                        else if (llllllllllIlllIlIllIIIllIIIIIllI >= llllllllllIlllIlIllIIIllIIIIlllI - 4 && llllllllllIlllIlIllIIIllIIIIIllI <= llllllllllIlllIlIllIIIllIIIIlllI + 1) {
                            llllllllllIlllIlIllIIIllIIIIllIl = this.topBlock;
                            llllllllllIlllIlIllIIIllIIIIllII = this.fillerBlock;
                        }
                        if (llllllllllIlllIlIllIIIllIIIIIllI < llllllllllIlllIlIllIIIllIIIIlllI && (llllllllllIlllIlIllIIIllIIIIllIl == null || llllllllllIlllIlIllIIIllIIIIllIl.getMaterial() == Material.AIR)) {
                            if (this.getFloatTemperature(llllllllllIlllIlIllIIIllIIIIIlll.setPos(llllllllllIlllIlIllIIIllIIIlIIIl, llllllllllIlllIlIllIIIllIIIIIllI, llllllllllIlllIlIllIIIllIIIlIIII)) < 0.15f) {
                                llllllllllIlllIlIllIIIllIIIIllIl = Biome.ICE;
                            }
                            else {
                                llllllllllIlllIlIllIIIllIIIIllIl = Biome.WATER;
                            }
                        }
                        llllllllllIlllIlIllIIIllIIIIlIll = llllllllllIlllIlIllIIIllIIIIlIlI;
                        if (llllllllllIlllIlIllIIIllIIIIIllI >= llllllllllIlllIlIllIIIllIIIIlllI - 1) {
                            llllllllllIlllIlIllIIIllIIIIIIIl.setBlockState(llllllllllIlllIlIllIIIllIIIIlIII, llllllllllIlllIlIllIIIllIIIIIllI, llllllllllIlllIlIllIIIllIIIIlIIl, llllllllllIlllIlIllIIIllIIIIllIl);
                        }
                        else if (llllllllllIlllIlIllIIIllIIIIIllI < llllllllllIlllIlIllIIIllIIIIlllI - 7 - llllllllllIlllIlIllIIIllIIIIlIlI) {
                            llllllllllIlllIlIllIIIllIIIIllIl = Biome.AIR;
                            llllllllllIlllIlIllIIIllIIIIllII = Biome.STONE;
                            llllllllllIlllIlIllIIIllIIIIIIIl.setBlockState(llllllllllIlllIlIllIIIllIIIIlIII, llllllllllIlllIlIllIIIllIIIIIllI, llllllllllIlllIlIllIIIllIIIIlIIl, Biome.GRAVEL);
                        }
                        else {
                            llllllllllIlllIlIllIIIllIIIIIIIl.setBlockState(llllllllllIlllIlIllIIIllIIIIlIII, llllllllllIlllIlIllIIIllIIIIIllI, llllllllllIlllIlIllIIIllIIIIlIIl, llllllllllIlllIlIllIIIllIIIIllII);
                        }
                    }
                    else if (llllllllllIlllIlIllIIIllIIIIlIll > 0) {
                        --llllllllllIlllIlIllIIIllIIIIlIll;
                        llllllllllIlllIlIllIIIllIIIIIIIl.setBlockState(llllllllllIlllIlIllIIIllIIIIlIII, llllllllllIlllIlIllIIIllIIIIIllI, llllllllllIlllIlIllIIIllIIIIlIIl, llllllllllIlllIlIllIIIllIIIIllII);
                        if (llllllllllIlllIlIllIIIllIIIIlIll == 0 && llllllllllIlllIlIllIIIllIIIIllII.getBlock() == Blocks.SAND && llllllllllIlllIlIllIIIllIIIIlIlI > 1) {
                            llllllllllIlllIlIllIIIllIIIIlIll = llllllllllIlllIlIllIIIllIIIIIIlI.nextInt(4) + Math.max(0, llllllllllIlllIlIllIIIllIIIIIllI - 63);
                            llllllllllIlllIlIllIIIllIIIIllII = ((llllllllllIlllIlIllIIIllIIIIllII.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND) ? Biome.RED_SANDSTONE : Biome.SANDSTONE);
                        }
                    }
                }
            }
        }
    }
    
    @Nullable
    public static Biome getMutationForBiome(final Biome llllllllllIlllIlIllIIIlllIIlIIlI) {
        return Biome.MUTATION_TO_BASE_ID_MAP.getByValue(getIdForBiome(llllllllllIlllIlIllIIIlllIIlIIlI));
    }
    
    public boolean ignorePlayerSpawnSuitability() {
        return false;
    }
    
    public void genTerrainBlocks(final World llllllllllIlllIlIllIIIllIIllIIll, final Random llllllllllIlllIlIllIIIllIIllIIlI, final ChunkPrimer llllllllllIlllIlIllIIIllIIlIlIlI, final int llllllllllIlllIlIllIIIllIIllIIII, final int llllllllllIlllIlIllIIIllIIlIlIII, final double llllllllllIlllIlIllIIIllIIlIIlll) {
        this.generateBiomeTerrain(llllllllllIlllIlIllIIIllIIllIIll, llllllllllIlllIlIllIIIllIIllIIlI, llllllllllIlllIlIllIIIllIIlIlIlI, llllllllllIlllIlIllIIIllIIllIIII, llllllllllIlllIlIllIIIllIIlIlIII, llllllllllIlllIlIllIIIllIIlIIlll);
    }
    
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllIlllIlIllIIIlllIIIIlII) {
        return (llllllllllIlllIlIllIIIlllIIIIlII.nextInt(10) == 0) ? Biome.BIG_TREE_FEATURE : Biome.TREE_FEATURE;
    }
    
    protected Biome(final BiomeProperties llllllllllIlllIlIllIIIlllIIIllII) {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        this.spawnableMonsterList = (List<SpawnListEntry>)Lists.newArrayList();
        this.spawnableCreatureList = (List<SpawnListEntry>)Lists.newArrayList();
        this.spawnableWaterCreatureList = (List<SpawnListEntry>)Lists.newArrayList();
        this.spawnableCaveCreatureList = (List<SpawnListEntry>)Lists.newArrayList();
        this.biomeName = llllllllllIlllIlIllIIIlllIIIllII.biomeName;
        this.baseHeight = llllllllllIlllIlIllIIIlllIIIllII.baseHeight;
        this.heightVariation = llllllllllIlllIlIllIIIlllIIIllII.heightVariation;
        this.temperature = llllllllllIlllIlIllIIIlllIIIllII.temperature;
        this.rainfall = llllllllllIlllIlIllIIIlllIIIllII.rainfall;
        this.waterColor = llllllllllIlllIlIllIIIlllIIIllII.waterColor;
        this.enableSnow = llllllllllIlllIlIllIIIlllIIIllII.enableSnow;
        this.enableRain = llllllllllIlllIlIllIIIlllIIIllII.enableRain;
        this.baseBiomeRegName = llllllllllIlllIlIllIIIlllIIIllII.baseBiomeRegName;
        this.theBiomeDecorator = this.createBiomeDecorator();
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 95, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombieVillager.class, 5, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
    }
    
    public static void registerBiomes() {
        registerBiome(0, "ocean", new BiomeOcean(new BiomeProperties("Ocean").setBaseHeight(-1.0f).setHeightVariation(0.1f)));
        registerBiome(1, "plains", new BiomePlains(false, new BiomeProperties("Plains").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(0.8f).setRainfall(0.4f)));
        registerBiome(2, "desert", new BiomeDesert(new BiomeProperties("Desert").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(3, "extreme_hills", new BiomeHills(BiomeHills.Type.NORMAL, new BiomeProperties("Extreme Hills").setBaseHeight(1.0f).setHeightVariation(0.5f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(4, "forest", new BiomeForest(BiomeForest.Type.NORMAL, new BiomeProperties("Forest").setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(5, "taiga", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Taiga").setBaseHeight(0.2f).setHeightVariation(0.2f).setTemperature(0.25f).setRainfall(0.8f)));
        registerBiome(6, "swampland", new BiomeSwamp(new BiomeProperties("Swampland").setBaseHeight(-0.2f).setHeightVariation(0.1f).setTemperature(0.8f).setRainfall(0.9f).setWaterColor(14745518)));
        registerBiome(7, "river", new BiomeRiver(new BiomeProperties("River").setBaseHeight(-0.5f).setHeightVariation(0.0f)));
        registerBiome(8, "hell", new BiomeHell(new BiomeProperties("Hell").setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(9, "sky", new BiomeEnd(new BiomeProperties("The End").setRainDisabled()));
        registerBiome(10, "frozen_ocean", new BiomeOcean(new BiomeProperties("FrozenOcean").setBaseHeight(-1.0f).setHeightVariation(0.1f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(11, "frozen_river", new BiomeRiver(new BiomeProperties("FrozenRiver").setBaseHeight(-0.5f).setHeightVariation(0.0f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(12, "ice_flats", new BiomeSnow(false, new BiomeProperties("Ice Plains").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(13, "ice_mountains", new BiomeSnow(false, new BiomeProperties("Ice Mountains").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(14, "mushroom_island", new BiomeMushroomIsland(new BiomeProperties("MushroomIsland").setBaseHeight(0.2f).setHeightVariation(0.3f).setTemperature(0.9f).setRainfall(1.0f)));
        registerBiome(15, "mushroom_island_shore", new BiomeMushroomIsland(new BiomeProperties("MushroomIslandShore").setBaseHeight(0.0f).setHeightVariation(0.025f).setTemperature(0.9f).setRainfall(1.0f)));
        registerBiome(16, "beaches", new BiomeBeach(new BiomeProperties("Beach").setBaseHeight(0.0f).setHeightVariation(0.025f).setTemperature(0.8f).setRainfall(0.4f)));
        registerBiome(17, "desert_hills", new BiomeDesert(new BiomeProperties("DesertHills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(18, "forest_hills", new BiomeForest(BiomeForest.Type.NORMAL, new BiomeProperties("ForestHills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(19, "taiga_hills", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("TaigaHills").setTemperature(0.25f).setRainfall(0.8f).setBaseHeight(0.45f).setHeightVariation(0.3f)));
        registerBiome(20, "smaller_extreme_hills", new BiomeHills(BiomeHills.Type.EXTRA_TREES, new BiomeProperties("Extreme Hills Edge").setBaseHeight(0.8f).setHeightVariation(0.3f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(21, "jungle", new BiomeJungle(false, new BiomeProperties("Jungle").setTemperature(0.95f).setRainfall(0.9f)));
        registerBiome(22, "jungle_hills", new BiomeJungle(false, new BiomeProperties("JungleHills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.95f).setRainfall(0.9f)));
        registerBiome(23, "jungle_edge", new BiomeJungle(true, new BiomeProperties("JungleEdge").setTemperature(0.95f).setRainfall(0.8f)));
        registerBiome(24, "deep_ocean", new BiomeOcean(new BiomeProperties("Deep Ocean").setBaseHeight(-1.8f).setHeightVariation(0.1f)));
        registerBiome(25, "stone_beach", new BiomeStoneBeach(new BiomeProperties("Stone Beach").setBaseHeight(0.1f).setHeightVariation(0.8f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(26, "cold_beach", new BiomeBeach(new BiomeProperties("Cold Beach").setBaseHeight(0.0f).setHeightVariation(0.025f).setTemperature(0.05f).setRainfall(0.3f).setSnowEnabled()));
        registerBiome(27, "birch_forest", new BiomeForest(BiomeForest.Type.BIRCH, new BiomeProperties("Birch Forest").setTemperature(0.6f).setRainfall(0.6f)));
        registerBiome(28, "birch_forest_hills", new BiomeForest(BiomeForest.Type.BIRCH, new BiomeProperties("Birch Forest Hills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.6f).setRainfall(0.6f)));
        registerBiome(29, "roofed_forest", new BiomeForest(BiomeForest.Type.ROOFED, new BiomeProperties("Roofed Forest").setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(30, "taiga_cold", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Cold Taiga").setBaseHeight(0.2f).setHeightVariation(0.2f).setTemperature(-0.5f).setRainfall(0.4f).setSnowEnabled()));
        registerBiome(31, "taiga_cold_hills", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Cold Taiga Hills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(-0.5f).setRainfall(0.4f).setSnowEnabled()));
        registerBiome(32, "redwood_taiga", new BiomeTaiga(BiomeTaiga.Type.MEGA, new BiomeProperties("Mega Taiga").setTemperature(0.3f).setRainfall(0.8f).setBaseHeight(0.2f).setHeightVariation(0.2f)));
        registerBiome(33, "redwood_taiga_hills", new BiomeTaiga(BiomeTaiga.Type.MEGA, new BiomeProperties("Mega Taiga Hills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.3f).setRainfall(0.8f)));
        registerBiome(34, "extreme_hills_with_trees", new BiomeHills(BiomeHills.Type.EXTRA_TREES, new BiomeProperties("Extreme Hills+").setBaseHeight(1.0f).setHeightVariation(0.5f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(35, "savanna", new BiomeSavanna(new BiomeProperties("Savanna").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(1.2f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(36, "savanna_rock", new BiomeSavanna(new BiomeProperties("Savanna Plateau").setBaseHeight(1.5f).setHeightVariation(0.025f).setTemperature(1.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(37, "mesa", new BiomeMesa(false, false, new BiomeProperties("Mesa").setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(38, "mesa_rock", new BiomeMesa(false, true, new BiomeProperties("Mesa Plateau F").setBaseHeight(1.5f).setHeightVariation(0.025f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(39, "mesa_clear_rock", new BiomeMesa(false, false, new BiomeProperties("Mesa Plateau").setBaseHeight(1.5f).setHeightVariation(0.025f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(127, "void", new BiomeVoid(new BiomeProperties("The Void").setRainDisabled()));
        registerBiome(129, "mutated_plains", new BiomePlains(true, new BiomeProperties("Sunflower Plains").setBaseBiome("plains").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(0.8f).setRainfall(0.4f)));
        registerBiome(130, "mutated_desert", new BiomeDesert(new BiomeProperties("Desert M").setBaseBiome("desert").setBaseHeight(0.225f).setHeightVariation(0.25f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(131, "mutated_extreme_hills", new BiomeHills(BiomeHills.Type.MUTATED, new BiomeProperties("Extreme Hills M").setBaseBiome("extreme_hills").setBaseHeight(1.0f).setHeightVariation(0.5f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(132, "mutated_forest", new BiomeForest(BiomeForest.Type.FLOWER, new BiomeProperties("Flower Forest").setBaseBiome("forest").setHeightVariation(0.4f).setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(133, "mutated_taiga", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Taiga M").setBaseBiome("taiga").setBaseHeight(0.3f).setHeightVariation(0.4f).setTemperature(0.25f).setRainfall(0.8f)));
        registerBiome(134, "mutated_swampland", new BiomeSwamp(new BiomeProperties("Swampland M").setBaseBiome("swampland").setBaseHeight(-0.1f).setHeightVariation(0.3f).setTemperature(0.8f).setRainfall(0.9f).setWaterColor(14745518)));
        registerBiome(140, "mutated_ice_flats", new BiomeSnow(true, new BiomeProperties("Ice Plains Spikes").setBaseBiome("ice_flats").setBaseHeight(0.425f).setHeightVariation(0.45000002f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(149, "mutated_jungle", new BiomeJungle(false, new BiomeProperties("Jungle M").setBaseBiome("jungle").setBaseHeight(0.2f).setHeightVariation(0.4f).setTemperature(0.95f).setRainfall(0.9f)));
        registerBiome(151, "mutated_jungle_edge", new BiomeJungle(true, new BiomeProperties("JungleEdge M").setBaseBiome("jungle_edge").setBaseHeight(0.2f).setHeightVariation(0.4f).setTemperature(0.95f).setRainfall(0.8f)));
        registerBiome(155, "mutated_birch_forest", new BiomeForestMutated(new BiomeProperties("Birch Forest M").setBaseBiome("birch_forest").setBaseHeight(0.2f).setHeightVariation(0.4f).setTemperature(0.6f).setRainfall(0.6f)));
        registerBiome(156, "mutated_birch_forest_hills", new BiomeForestMutated(new BiomeProperties("Birch Forest Hills M").setBaseBiome("birch_forest_hills").setBaseHeight(0.55f).setHeightVariation(0.5f).setTemperature(0.6f).setRainfall(0.6f)));
        registerBiome(157, "mutated_roofed_forest", new BiomeForest(BiomeForest.Type.ROOFED, new BiomeProperties("Roofed Forest M").setBaseBiome("roofed_forest").setBaseHeight(0.2f).setHeightVariation(0.4f).setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(158, "mutated_taiga_cold", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Cold Taiga M").setBaseBiome("taiga_cold").setBaseHeight(0.3f).setHeightVariation(0.4f).setTemperature(-0.5f).setRainfall(0.4f).setSnowEnabled()));
        registerBiome(160, "mutated_redwood_taiga", new BiomeTaiga(BiomeTaiga.Type.MEGA_SPRUCE, new BiomeProperties("Mega Spruce Taiga").setBaseBiome("redwood_taiga").setBaseHeight(0.2f).setHeightVariation(0.2f).setTemperature(0.25f).setRainfall(0.8f)));
        registerBiome(161, "mutated_redwood_taiga_hills", new BiomeTaiga(BiomeTaiga.Type.MEGA_SPRUCE, new BiomeProperties("Redwood Taiga Hills M").setBaseBiome("redwood_taiga_hills").setBaseHeight(0.2f).setHeightVariation(0.2f).setTemperature(0.25f).setRainfall(0.8f)));
        registerBiome(162, "mutated_extreme_hills_with_trees", new BiomeHills(BiomeHills.Type.MUTATED, new BiomeProperties("Extreme Hills+ M").setBaseBiome("extreme_hills_with_trees").setBaseHeight(1.0f).setHeightVariation(0.5f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(163, "mutated_savanna", new BiomeSavannaMutated(new BiomeProperties("Savanna M").setBaseBiome("savanna").setBaseHeight(0.3625f).setHeightVariation(1.225f).setTemperature(1.1f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(164, "mutated_savanna_rock", new BiomeSavannaMutated(new BiomeProperties("Savanna Plateau M").setBaseBiome("savanna_rock").setBaseHeight(1.05f).setHeightVariation(1.2125001f).setTemperature(1.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(165, "mutated_mesa", new BiomeMesa(true, false, new BiomeProperties("Mesa (Bryce)").setBaseBiome("mesa").setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(166, "mutated_mesa_rock", new BiomeMesa(false, true, new BiomeProperties("Mesa Plateau F M").setBaseBiome("mesa_rock").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(167, "mutated_mesa_clear_rock", new BiomeMesa(false, false, new BiomeProperties("Mesa Plateau M").setBaseBiome("mesa_clear_rock").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
    }
    
    public boolean canRain() {
        return !this.isSnowyBiome() && this.enableRain;
    }
    
    public int getGrassColorAtPos(final BlockPos llllllllllIlllIlIllIIIllIlIIlllI) {
        final double llllllllllIlllIlIllIIIllIlIIllIl = MathHelper.clamp(this.getFloatTemperature(llllllllllIlllIlIllIIIllIlIIlllI), 0.0f, 1.0f);
        final double llllllllllIlllIlIllIIIllIlIIllII = MathHelper.clamp(this.getRainfall(), 0.0f, 1.0f);
        return ColorizerGrass.getGrassColor(llllllllllIlllIlIllIIIllIlIIllIl, llllllllllIlllIlIllIIIllIlIIllII);
    }
    
    public static Biome getBiome(final int llllllllllIlllIlIllIIIlIlllIIlll, final Biome llllllllllIlllIlIllIIIlIlllIIllI) {
        final Biome llllllllllIlllIlIllIIIlIlllIIlIl = getBiomeForId(llllllllllIlllIlIllIIIlIlllIIlll);
        return (llllllllllIlllIlIllIIIlIlllIIlIl == null) ? llllllllllIlllIlIllIIIlIlllIIllI : llllllllllIlllIlIllIIIlIlllIIlIl;
    }
    
    protected BiomeDecorator createBiomeDecorator() {
        return new BiomeDecorator();
    }
    
    @Nullable
    public static Biome getBiome(final int llllllllllIlllIlIllIIIlIlllIllII) {
        return getBiome(llllllllllIlllIlIllIIIlIlllIllII, null);
    }
    
    public static class SpawnListEntry extends WeightedRandom.Item
    {
        public /* synthetic */ int maxGroupCount;
        public /* synthetic */ int minGroupCount;
        public /* synthetic */ Class<? extends EntityLiving> entityClass;
        
        public SpawnListEntry(final Class<? extends EntityLiving> llllllllllllllIIIllIIIIIIllIIlll, final int llllllllllllllIIIllIIIIIIllIIllI, final int llllllllllllllIIIllIIIIIIllIIIII, final int llllllllllllllIIIllIIIIIIlIlllll) {
            super(llllllllllllllIIIllIIIIIIllIIllI);
            this.entityClass = llllllllllllllIIIllIIIIIIllIIlll;
            this.minGroupCount = llllllllllllllIIIllIIIIIIllIIIII;
            this.maxGroupCount = llllllllllllllIIIllIIIIIIlIlllll;
        }
        
        @Override
        public String toString() {
            return String.valueOf(this.entityClass.getSimpleName()) + "*(" + this.minGroupCount + "-" + this.maxGroupCount + "):" + this.itemWeight;
        }
    }
    
    public static class BiomeProperties
    {
        private /* synthetic */ boolean enableSnow;
        private /* synthetic */ boolean enableRain;
        private /* synthetic */ float rainfall;
        private /* synthetic */ float heightVariation;
        private final /* synthetic */ String biomeName;
        private /* synthetic */ int waterColor;
        private /* synthetic */ float temperature;
        private /* synthetic */ float baseHeight;
        @Nullable
        private /* synthetic */ String baseBiomeRegName;
        
        public BiomeProperties(final String lllllllllllllIIIIIllIIlllllIIIIl) {
            this.baseHeight = 0.1f;
            this.heightVariation = 0.2f;
            this.temperature = 0.5f;
            this.rainfall = 0.5f;
            this.waterColor = 16777215;
            this.enableRain = true;
            this.biomeName = lllllllllllllIIIIIllIIlllllIIIIl;
        }
        
        protected BiomeProperties setTemperature(final float lllllllllllllIIIIIllIIllllIlllIl) {
            if (lllllllllllllIIIIIllIIllllIlllIl > 0.1f && lllllllllllllIIIIIllIIllllIlllIl < 0.2f) {
                throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
            }
            this.temperature = lllllllllllllIIIIIllIIllllIlllIl;
            return this;
        }
        
        protected BiomeProperties setBaseHeight(final float lllllllllllllIIIIIllIIllllIlIIIl) {
            this.baseHeight = lllllllllllllIIIIIllIIllllIlIIIl;
            return this;
        }
        
        protected BiomeProperties setBaseBiome(final String lllllllllllllIIIIIllIIlllIllIlll) {
            this.baseBiomeRegName = lllllllllllllIIIIIllIIlllIllIlll;
            return this;
        }
        
        protected BiomeProperties setWaterColor(final int lllllllllllllIIIIIllIIlllIllllll) {
            this.waterColor = lllllllllllllIIIIIllIIlllIllllll;
            return this;
        }
        
        protected BiomeProperties setSnowEnabled() {
            this.enableSnow = true;
            return this;
        }
        
        protected BiomeProperties setHeightVariation(final float lllllllllllllIIIIIllIIllllIIlIIl) {
            this.heightVariation = lllllllllllllIIIIIllIIllllIIlIIl;
            return this;
        }
        
        protected BiomeProperties setRainDisabled() {
            this.enableRain = false;
            return this;
        }
        
        protected BiomeProperties setRainfall(final float lllllllllllllIIIIIllIIllllIlIlIl) {
            this.rainfall = lllllllllllllIIIIIllIIllllIlIlIl;
            return this;
        }
    }
    
    public enum TempCategory
    {
        COLD("COLD", 1), 
        WARM("WARM", 3), 
        OCEAN("OCEAN", 0), 
        MEDIUM("MEDIUM", 2);
        
        private TempCategory(final String llllllllllllllIlIIIllIlllIIIllll, final int llllllllllllllIlIIIllIlllIIIlllI) {
        }
    }
}
