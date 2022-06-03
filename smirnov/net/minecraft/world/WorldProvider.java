// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.ChunkGeneratorDebug;
import net.minecraft.world.gen.ChunkGeneratorFlat;
import net.minecraft.world.gen.IChunkGenerator;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.biome.BiomeProvider;

public abstract class WorldProvider
{
    protected final /* synthetic */ float[] lightBrightnessTable;
    protected /* synthetic */ boolean isHellWorld;
    protected /* synthetic */ boolean hasNoSky;
    protected /* synthetic */ boolean field_191067_f;
    private final /* synthetic */ float[] colorsSunriseSunset;
    private /* synthetic */ String generatorSettings;
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ BiomeProvider biomeProvider;
    private /* synthetic */ WorldType terrainType;
    
    public void onPlayerRemoved(final EntityPlayerMP lllllllllllIIIIlIllllllIIlllIlIl) {
    }
    
    public boolean doesXZShowFog(final int lllllllllllIIIIlIllllllIlIIIlIlI, final int lllllllllllIIIIlIllllllIlIIIlIIl) {
        return false;
    }
    
    public void onWorldSave() {
    }
    
    public final void registerWorld(final World lllllllllllIIIIlIllllllIllllIllI) {
        this.worldObj = lllllllllllIIIIlIllllllIllllIllI;
        this.terrainType = lllllllllllIIIIlIllllllIllllIllI.getWorldInfo().getTerrainType();
        this.generatorSettings = lllllllllllIIIIlIllllllIllllIllI.getWorldInfo().getGeneratorOptions();
        this.createBiomeProvider();
        this.generateLightBrightnessTable();
    }
    
    public float calculateCelestialAngle(final long lllllllllllIIIIlIllllllIllIIlIll, final float lllllllllllIIIIlIllllllIllIIlIlI) {
        final int lllllllllllIIIIlIllllllIllIIlIIl = (int)(lllllllllllIIIIlIllllllIllIIlIll % 24000L);
        float lllllllllllIIIIlIllllllIllIIlIII = (lllllllllllIIIIlIllllllIllIIlIIl + lllllllllllIIIIlIllllllIllIIlIlI) / 24000.0f - 0.25f;
        if (lllllllllllIIIIlIllllllIllIIlIII < 0.0f) {
            ++lllllllllllIIIIlIllllllIllIIlIII;
        }
        if (lllllllllllIIIIlIllllllIllIIlIII > 1.0f) {
            --lllllllllllIIIIlIllllllIllIIlIII;
        }
        final float lllllllllllIIIIlIllllllIllIIIlll = 1.0f - (float)((Math.cos(lllllllllllIIIIlIllllllIllIIlIII * 3.141592653589793) + 1.0) / 2.0);
        lllllllllllIIIIlIllllllIllIIlIII += (lllllllllllIIIIlIllllllIllIIIlll - lllllllllllIIIIlIllllllIllIIlIII) / 3.0f;
        return lllllllllllIIIIlIllllllIllIIlIII;
    }
    
    public abstract DimensionType getDimensionType();
    
    public WorldBorder createWorldBorder() {
        return new WorldBorder();
    }
    
    public float[] getLightBrightnessTable() {
        return this.lightBrightnessTable;
    }
    
    public int getAverageGroundLevel() {
        return (this.terrainType == WorldType.FLAT) ? 4 : (this.worldObj.getSeaLevel() + 1);
    }
    
    @Nullable
    public BlockPos getSpawnCoordinate() {
        return null;
    }
    
    public boolean getHasNoSky() {
        return this.hasNoSky;
    }
    
    public int getMoonPhase(final long lllllllllllIIIIlIllllllIlIllllll) {
        return (int)(lllllllllllIIIIlIllllllIlIllllll / 24000L % 8L + 8L) % 8;
    }
    
    static {
        MOON_PHASE_FACTORS = new float[] { 1.0f, 0.75f, 0.5f, 0.25f, 0.0f, 0.25f, 0.5f, 0.75f };
    }
    
    public IChunkGenerator createChunkGenerator() {
        if (this.terrainType == WorldType.FLAT) {
            return new ChunkGeneratorFlat(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.generatorSettings);
        }
        if (this.terrainType == WorldType.DEBUG_WORLD) {
            return new ChunkGeneratorDebug(this.worldObj);
        }
        return (this.terrainType == WorldType.CUSTOMIZED) ? new ChunkGeneratorOverworld(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.generatorSettings) : new ChunkGeneratorOverworld(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.generatorSettings);
    }
    
    public boolean canRespawnHere() {
        return true;
    }
    
    public Vec3d getFogColor(final float lllllllllllIIIIlIllllllIlIlIIIII, final float lllllllllllIIIIlIllllllIlIIlllll) {
        float lllllllllllIIIIlIllllllIlIIllllI = MathHelper.cos(lllllllllllIIIIlIllllllIlIlIIIII * 6.2831855f) * 2.0f + 0.5f;
        lllllllllllIIIIlIllllllIlIIllllI = MathHelper.clamp(lllllllllllIIIIlIllllllIlIIllllI, 0.0f, 1.0f);
        float lllllllllllIIIIlIllllllIlIIlllIl = 0.7529412f;
        float lllllllllllIIIIlIllllllIlIIlllII = 0.84705883f;
        float lllllllllllIIIIlIllllllIlIIllIll = 1.0f;
        lllllllllllIIIIlIllllllIlIIlllIl *= lllllllllllIIIIlIllllllIlIIllllI * 0.94f + 0.06f;
        lllllllllllIIIIlIllllllIlIIlllII *= lllllllllllIIIIlIllllllIlIIllllI * 0.94f + 0.06f;
        lllllllllllIIIIlIllllllIlIIllIll *= lllllllllllIIIIlIllllllIlIIllllI * 0.91f + 0.09f;
        return new Vec3d(lllllllllllIIIIlIllllllIlIIlllIl, lllllllllllIIIIlIllllllIlIIlllII, lllllllllllIIIIlIllllllIlIIllIll);
    }
    
    protected void generateLightBrightnessTable() {
        final float lllllllllllIIIIlIllllllIllllIIII = 0.0f;
        for (int lllllllllllIIIIlIllllllIlllIllll = 0; lllllllllllIIIIlIllllllIlllIllll <= 15; ++lllllllllllIIIIlIllllllIlllIllll) {
            final float lllllllllllIIIIlIllllllIlllIlllI = 1.0f - lllllllllllIIIIlIllllllIlllIllll / 15.0f;
            this.lightBrightnessTable[lllllllllllIIIIlIllllllIlllIllll] = (1.0f - lllllllllllIIIIlIllllllIlllIlllI) / (lllllllllllIIIIlIllllllIlllIlllI * 3.0f + 1.0f) * 1.0f + 0.0f;
        }
    }
    
    @Nullable
    public float[] calcSunriseSunsetColors(final float lllllllllllIIIIlIllllllIlIlIllII, final float lllllllllllIIIIlIllllllIlIllIIll) {
        final float lllllllllllIIIIlIllllllIlIllIIlI = 0.4f;
        final float lllllllllllIIIIlIllllllIlIllIIIl = MathHelper.cos(lllllllllllIIIIlIllllllIlIlIllII * 6.2831855f) - 0.0f;
        final float lllllllllllIIIIlIllllllIlIllIIII = -0.0f;
        if (lllllllllllIIIIlIllllllIlIllIIIl >= -0.4f && lllllllllllIIIIlIllllllIlIllIIIl <= 0.4f) {
            final float lllllllllllIIIIlIllllllIlIlIllll = (lllllllllllIIIIlIllllllIlIllIIIl + 0.0f) / 0.4f * 0.5f + 0.5f;
            float lllllllllllIIIIlIllllllIlIlIlllI = 1.0f - (1.0f - MathHelper.sin(lllllllllllIIIIlIllllllIlIlIllll * 3.1415927f)) * 0.99f;
            lllllllllllIIIIlIllllllIlIlIlllI *= lllllllllllIIIIlIllllllIlIlIlllI;
            this.colorsSunriseSunset[0] = lllllllllllIIIIlIllllllIlIlIllll * 0.3f + 0.7f;
            this.colorsSunriseSunset[1] = lllllllllllIIIIlIllllllIlIlIllll * lllllllllllIIIIlIllllllIlIlIllll * 0.7f + 0.2f;
            this.colorsSunriseSunset[2] = lllllllllllIIIIlIllllllIlIlIllll * lllllllllllIIIIlIllllllIlIlIllll * 0.0f + 0.2f;
            this.colorsSunriseSunset[3] = lllllllllllIIIIlIllllllIlIlIlllI;
            return this.colorsSunriseSunset;
        }
        return null;
    }
    
    public boolean func_191066_m() {
        return this.field_191067_f;
    }
    
    public boolean doesWaterVaporize() {
        return this.isHellWorld;
    }
    
    public boolean isSurfaceWorld() {
        return true;
    }
    
    protected void createBiomeProvider() {
        this.field_191067_f = true;
        final WorldType lllllllllllIIIIlIllllllIlllIIlIl = this.worldObj.getWorldInfo().getTerrainType();
        if (lllllllllllIIIIlIllllllIlllIIlIl == WorldType.FLAT) {
            final FlatGeneratorInfo lllllllllllIIIIlIllllllIlllIIlII = FlatGeneratorInfo.createFlatGeneratorFromString(this.worldObj.getWorldInfo().getGeneratorOptions());
            this.biomeProvider = new BiomeProviderSingle(Biome.getBiome(lllllllllllIIIIlIllllllIlllIIlII.getBiome(), Biomes.DEFAULT));
        }
        else if (lllllllllllIIIIlIllllllIlllIIlIl == WorldType.DEBUG_WORLD) {
            this.biomeProvider = new BiomeProviderSingle(Biomes.PLAINS);
        }
        else {
            this.biomeProvider = new BiomeProvider(this.worldObj.getWorldInfo());
        }
    }
    
    public BiomeProvider getBiomeProvider() {
        return this.biomeProvider;
    }
    
    public boolean canCoordinateBeSpawn(final int lllllllllllIIIIlIllllllIllIlIlII, final int lllllllllllIIIIlIllllllIllIlIIll) {
        final BlockPos lllllllllllIIIIlIllllllIllIlIllI = new BlockPos(lllllllllllIIIIlIllllllIllIlIlII, 0, lllllllllllIIIIlIllllllIllIlIIll);
        return this.worldObj.getBiome(lllllllllllIIIIlIllllllIllIlIllI).ignorePlayerSpawnSuitability() || this.worldObj.getGroundAboveSeaLevel(lllllllllllIIIIlIllllllIllIlIllI).getBlock() == Blocks.GRASS;
    }
    
    public boolean canDropChunk(final int lllllllllllIIIIlIllllllIIlllIIIl, final int lllllllllllIIIIlIllllllIIlllIIII) {
        return true;
    }
    
    public boolean isSkyColored() {
        return true;
    }
    
    public void onPlayerAdded(final EntityPlayerMP lllllllllllIIIIlIllllllIIlllIlll) {
    }
    
    public double getVoidFogYFactor() {
        return (this.terrainType == WorldType.FLAT) ? 1.0 : 0.03125;
    }
    
    public void onWorldUpdateEntities() {
    }
    
    public WorldProvider() {
        this.lightBrightnessTable = new float[16];
        this.colorsSunriseSunset = new float[4];
    }
    
    public float getCloudHeight() {
        return 128.0f;
    }
}
