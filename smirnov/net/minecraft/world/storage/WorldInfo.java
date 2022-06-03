// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.world.WorldSettings;
import net.minecraft.util.datafix.IFixType;
import net.minecraft.util.datafix.IDataFixer;
import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import com.google.common.collect.Maps;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.world.GameRules;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.DimensionType;
import java.util.Map;
import net.minecraft.world.GameType;

public class WorldInfo
{
    private /* synthetic */ boolean mapFeaturesEnabled;
    private /* synthetic */ long worldTime;
    private /* synthetic */ GameType theGameType;
    private final /* synthetic */ Map<DimensionType, NBTTagCompound> dimensionData;
    private /* synthetic */ WorldType terrainType;
    private /* synthetic */ String generatorOptions;
    private /* synthetic */ int cleanWeatherTime;
    private /* synthetic */ long borderSizeLerpTime;
    private /* synthetic */ boolean difficultyLocked;
    private /* synthetic */ int rainTime;
    private /* synthetic */ long sizeOnDisk;
    private /* synthetic */ double borderCenterZ;
    private /* synthetic */ double borderDamagePerBlock;
    private /* synthetic */ double borderSafeZone;
    private /* synthetic */ boolean allowCommands;
    private /* synthetic */ boolean versionSnapshot;
    private /* synthetic */ EnumDifficulty difficulty;
    private /* synthetic */ int borderWarningDistance;
    private /* synthetic */ int spawnZ;
    private /* synthetic */ boolean hardcore;
    public static final /* synthetic */ EnumDifficulty DEFAULT_DIFFICULTY;
    private /* synthetic */ long randomSeed;
    private /* synthetic */ long lastTimePlayed;
    private /* synthetic */ double borderSizeLerpTarget;
    private /* synthetic */ int dimension;
    private /* synthetic */ long totalTime;
    private /* synthetic */ double borderCenterX;
    private /* synthetic */ boolean thundering;
    private /* synthetic */ int spawnX;
    private /* synthetic */ int versionId;
    private /* synthetic */ GameRules theGameRules;
    private /* synthetic */ boolean raining;
    private /* synthetic */ int thunderTime;
    private /* synthetic */ int saveVersion;
    private /* synthetic */ NBTTagCompound playerTag;
    private /* synthetic */ boolean initialized;
    private /* synthetic */ int spawnY;
    private /* synthetic */ String levelName;
    private /* synthetic */ String versionName;
    private /* synthetic */ int borderWarningTime;
    private /* synthetic */ double borderSize;
    
    public double getBorderCenterX() {
        return this.borderCenterX;
    }
    
    public void setDifficultyLocked(final boolean lllllllllllIIIlIlllIIIIlIlIlIIlI) {
        this.difficultyLocked = lllllllllllIIIlIlllIIIIlIlIlIIlI;
    }
    
    private void updateTagCompound(final NBTTagCompound lllllllllllIIIlIlllIIIlIIlllIIlI, final NBTTagCompound lllllllllllIIIlIlllIIIlIIlllIIIl) {
        final NBTTagCompound lllllllllllIIIlIlllIIIlIIlllIllI = new NBTTagCompound();
        lllllllllllIIIlIlllIIIlIIlllIllI.setString("Name", "1.12.2");
        lllllllllllIIIlIlllIIIlIIlllIllI.setInteger("Id", 1343);
        lllllllllllIIIlIlllIIIlIIlllIllI.setBoolean("Snapshot", false);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setTag("Version", lllllllllllIIIlIlllIIIlIIlllIllI);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("DataVersion", 1343);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setLong("RandomSeed", this.randomSeed);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setString("generatorName", this.terrainType.getWorldTypeName());
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("generatorVersion", this.terrainType.getGeneratorVersion());
        lllllllllllIIIlIlllIIIlIIlllIIlI.setString("generatorOptions", this.generatorOptions);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("GameType", this.theGameType.getID());
        lllllllllllIIIlIlllIIIlIIlllIIlI.setBoolean("MapFeatures", this.mapFeaturesEnabled);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("SpawnX", this.spawnX);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("SpawnY", this.spawnY);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("SpawnZ", this.spawnZ);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setLong("Time", this.totalTime);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setLong("DayTime", this.worldTime);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setLong("SizeOnDisk", this.sizeOnDisk);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setLong("LastPlayed", MinecraftServer.getCurrentTimeMillis());
        lllllllllllIIIlIlllIIIlIIlllIIlI.setString("LevelName", this.levelName);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("version", this.saveVersion);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("clearWeatherTime", this.cleanWeatherTime);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("rainTime", this.rainTime);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setBoolean("raining", this.raining);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setInteger("thunderTime", this.thunderTime);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setBoolean("thundering", this.thundering);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setBoolean("hardcore", this.hardcore);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setBoolean("allowCommands", this.allowCommands);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setBoolean("initialized", this.initialized);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setDouble("BorderCenterX", this.borderCenterX);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setDouble("BorderCenterZ", this.borderCenterZ);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setDouble("BorderSize", this.borderSize);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setLong("BorderSizeLerpTime", this.borderSizeLerpTime);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setDouble("BorderSafeZone", this.borderSafeZone);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setDouble("BorderDamagePerBlock", this.borderDamagePerBlock);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setDouble("BorderSizeLerpTarget", this.borderSizeLerpTarget);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setDouble("BorderWarningBlocks", this.borderWarningDistance);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setDouble("BorderWarningTime", this.borderWarningTime);
        if (this.difficulty != null) {
            lllllllllllIIIlIlllIIIlIIlllIIlI.setByte("Difficulty", (byte)this.difficulty.getDifficultyId());
        }
        lllllllllllIIIlIlllIIIlIIlllIIlI.setBoolean("DifficultyLocked", this.difficultyLocked);
        lllllllllllIIIlIlllIIIlIIlllIIlI.setTag("GameRules", this.theGameRules.writeToNBT());
        final NBTTagCompound lllllllllllIIIlIlllIIIlIIlllIlIl = new NBTTagCompound();
        for (final Map.Entry<DimensionType, NBTTagCompound> lllllllllllIIIlIlllIIIlIIlllIlII : this.dimensionData.entrySet()) {
            lllllllllllIIIlIlllIIIlIIlllIlIl.setTag(String.valueOf(lllllllllllIIIlIlllIIIlIIlllIlII.getKey().getId()), lllllllllllIIIlIlllIIIlIIlllIlII.getValue());
        }
        lllllllllllIIIlIlllIIIlIIlllIIlI.setTag("DimensionData", lllllllllllIIIlIlllIIIlIIlllIlIl);
        if (lllllllllllIIIlIlllIIIlIIlllIIIl != null) {
            lllllllllllIIIlIlllIIIlIIlllIIlI.setTag("Player", lllllllllllIIIlIlllIIIlIIlllIIIl);
        }
    }
    
    public int getRainTime() {
        return this.rainTime;
    }
    
    public void setMapFeaturesEnabled(final boolean lllllllllllIIIlIlllIIIIllllIIIll) {
        this.mapFeaturesEnabled = lllllllllllIIIlIlllIIIIllllIIIll;
    }
    
    static {
        DEFAULT_DIFFICULTY = EnumDifficulty.NORMAL;
    }
    
    public void setWorldTime(final long lllllllllllIIIlIlllIIIlIIIllIlll) {
        this.worldTime = lllllllllllIIIlIlllIIIlIIIllIlll;
    }
    
    public void setServerInitialized(final boolean lllllllllllIIIlIlllIIIIllIllIllI) {
        this.initialized = lllllllllllIIIlIlllIIIIllIllIllI;
    }
    
    public void setThundering(final boolean lllllllllllIIIlIlllIIIlIIIIIllII) {
        this.thundering = lllllllllllIIIlIlllIIIlIIIIIllII;
    }
    
    public long getSeed() {
        return this.randomSeed;
    }
    
    public boolean isInitialized() {
        return this.initialized;
    }
    
    public double getBorderSafeZone() {
        return this.borderSafeZone;
    }
    
    public void setBorderSize(final double lllllllllllIIIlIlllIIIIllIlIIllI) {
        this.borderSize = lllllllllllIIIlIlllIIIIllIlIIllI;
    }
    
    public double getBorderDamagePerBlock() {
        return this.borderDamagePerBlock;
    }
    
    public NBTTagCompound getPlayerNBTTagCompound() {
        return this.playerTag;
    }
    
    public void setSpawn(final BlockPos lllllllllllIIIlIlllIIIlIIIllIIIl) {
        this.spawnX = lllllllllllIIIlIlllIIIlIIIllIIIl.getX();
        this.spawnY = lllllllllllIIIlIlllIIIlIIIllIIIl.getY();
        this.spawnZ = lllllllllllIIIlIlllIIIlIIIllIIIl.getZ();
    }
    
    public String getWorldName() {
        return this.levelName;
    }
    
    public boolean areCommandsAllowed() {
        return this.allowCommands;
    }
    
    public long getBorderLerpTime() {
        return this.borderSizeLerpTime;
    }
    
    public void setAllowCommands(final boolean lllllllllllIIIlIlllIIIIlllIIIIIl) {
        this.allowCommands = lllllllllllIIIlIlllIIIIlllIIIIIl;
    }
    
    public boolean isThundering() {
        return this.thundering;
    }
    
    public NBTTagCompound cloneNBTCompound(@Nullable NBTTagCompound lllllllllllIIIlIlllIIIlIlIIIIIlI) {
        if (lllllllllllIIIlIlllIIIlIlIIIIIlI == null) {
            lllllllllllIIIlIlllIIIlIlIIIIIlI = this.playerTag;
        }
        final NBTTagCompound lllllllllllIIIlIlllIIIlIlIIIIlII = new NBTTagCompound();
        this.updateTagCompound(lllllllllllIIIlIlllIIIlIlIIIIlII, lllllllllllIIIlIlllIIIlIlIIIIIlI);
        return lllllllllllIIIlIlllIIIlIlIIIIlII;
    }
    
    public void getBorderCenterZ(final double lllllllllllIIIlIlllIIIIllIIIlllI) {
        this.borderCenterZ = lllllllllllIIIlIlllIIIIllIIIlllI;
    }
    
    public GameRules getGameRulesInstance() {
        return this.theGameRules;
    }
    
    public WorldInfo(final NBTTagCompound lllllllllllIIIlIlllIIIlIlIlIlIIl) {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderSize = 6.0E7;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.dimensionData = (Map<DimensionType, NBTTagCompound>)Maps.newEnumMap((Class)DimensionType.class);
        this.theGameRules = new GameRules();
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("Version", 10)) {
            final NBTTagCompound lllllllllllIIIlIlllIIIlIlIlIlIII = lllllllllllIIIlIlllIIIlIlIlIlIIl.getCompoundTag("Version");
            this.versionName = lllllllllllIIIlIlllIIIlIlIlIlIII.getString("Name");
            this.versionId = lllllllllllIIIlIlllIIIlIlIlIlIII.getInteger("Id");
            this.versionSnapshot = lllllllllllIIIlIlllIIIlIlIlIlIII.getBoolean("Snapshot");
        }
        this.randomSeed = lllllllllllIIIlIlllIIIlIlIlIlIIl.getLong("RandomSeed");
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("generatorName", 8)) {
            final String lllllllllllIIIlIlllIIIlIlIlIIlll = lllllllllllIIIlIlllIIIlIlIlIlIIl.getString("generatorName");
            this.terrainType = WorldType.parseWorldType(lllllllllllIIIlIlllIIIlIlIlIIlll);
            if (this.terrainType == null) {
                this.terrainType = WorldType.DEFAULT;
            }
            else if (this.terrainType.isVersioned()) {
                int lllllllllllIIIlIlllIIIlIlIlIIllI = 0;
                if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("generatorVersion", 99)) {
                    lllllllllllIIIlIlllIIIlIlIlIIllI = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("generatorVersion");
                }
                this.terrainType = this.terrainType.getWorldTypeForGeneratorVersion(lllllllllllIIIlIlllIIIlIlIlIIllI);
            }
            if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("generatorOptions", 8)) {
                this.generatorOptions = lllllllllllIIIlIlllIIIlIlIlIlIIl.getString("generatorOptions");
            }
        }
        this.theGameType = GameType.getByID(lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("GameType"));
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("MapFeatures", 99)) {
            this.mapFeaturesEnabled = lllllllllllIIIlIlllIIIlIlIlIlIIl.getBoolean("MapFeatures");
        }
        else {
            this.mapFeaturesEnabled = true;
        }
        this.spawnX = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("SpawnX");
        this.spawnY = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("SpawnY");
        this.spawnZ = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("SpawnZ");
        this.totalTime = lllllllllllIIIlIlllIIIlIlIlIlIIl.getLong("Time");
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("DayTime", 99)) {
            this.worldTime = lllllllllllIIIlIlllIIIlIlIlIlIIl.getLong("DayTime");
        }
        else {
            this.worldTime = this.totalTime;
        }
        this.lastTimePlayed = lllllllllllIIIlIlllIIIlIlIlIlIIl.getLong("LastPlayed");
        this.sizeOnDisk = lllllllllllIIIlIlllIIIlIlIlIlIIl.getLong("SizeOnDisk");
        this.levelName = lllllllllllIIIlIlllIIIlIlIlIlIIl.getString("LevelName");
        this.saveVersion = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("version");
        this.cleanWeatherTime = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("clearWeatherTime");
        this.rainTime = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("rainTime");
        this.raining = lllllllllllIIIlIlllIIIlIlIlIlIIl.getBoolean("raining");
        this.thunderTime = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("thunderTime");
        this.thundering = lllllllllllIIIlIlllIIIlIlIlIlIIl.getBoolean("thundering");
        this.hardcore = lllllllllllIIIlIlllIIIlIlIlIlIIl.getBoolean("hardcore");
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("initialized", 99)) {
            this.initialized = lllllllllllIIIlIlllIIIlIlIlIlIIl.getBoolean("initialized");
        }
        else {
            this.initialized = true;
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("allowCommands", 99)) {
            this.allowCommands = lllllllllllIIIlIlllIIIlIlIlIlIIl.getBoolean("allowCommands");
        }
        else {
            this.allowCommands = (this.theGameType == GameType.CREATIVE);
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("Player", 10)) {
            this.playerTag = lllllllllllIIIlIlllIIIlIlIlIlIIl.getCompoundTag("Player");
            this.dimension = this.playerTag.getInteger("Dimension");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("GameRules", 10)) {
            this.theGameRules.readFromNBT(lllllllllllIIIlIlllIIIlIlIlIlIIl.getCompoundTag("GameRules"));
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("Difficulty", 99)) {
            this.difficulty = EnumDifficulty.getDifficultyEnum(lllllllllllIIIlIlllIIIlIlIlIlIIl.getByte("Difficulty"));
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("DifficultyLocked", 1)) {
            this.difficultyLocked = lllllllllllIIIlIlllIIIlIlIlIlIIl.getBoolean("DifficultyLocked");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("BorderCenterX", 99)) {
            this.borderCenterX = lllllllllllIIIlIlllIIIlIlIlIlIIl.getDouble("BorderCenterX");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("BorderCenterZ", 99)) {
            this.borderCenterZ = lllllllllllIIIlIlllIIIlIlIlIlIIl.getDouble("BorderCenterZ");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("BorderSize", 99)) {
            this.borderSize = lllllllllllIIIlIlllIIIlIlIlIlIIl.getDouble("BorderSize");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("BorderSizeLerpTime", 99)) {
            this.borderSizeLerpTime = lllllllllllIIIlIlllIIIlIlIlIlIIl.getLong("BorderSizeLerpTime");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("BorderSizeLerpTarget", 99)) {
            this.borderSizeLerpTarget = lllllllllllIIIlIlllIIIlIlIlIlIIl.getDouble("BorderSizeLerpTarget");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("BorderSafeZone", 99)) {
            this.borderSafeZone = lllllllllllIIIlIlllIIIlIlIlIlIIl.getDouble("BorderSafeZone");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("BorderDamagePerBlock", 99)) {
            this.borderDamagePerBlock = lllllllllllIIIlIlllIIIlIlIlIlIIl.getDouble("BorderDamagePerBlock");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("BorderWarningBlocks", 99)) {
            this.borderWarningDistance = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("BorderWarningBlocks");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("BorderWarningTime", 99)) {
            this.borderWarningTime = lllllllllllIIIlIlllIIIlIlIlIlIIl.getInteger("BorderWarningTime");
        }
        if (lllllllllllIIIlIlllIIIlIlIlIlIIl.hasKey("DimensionData", 10)) {
            final NBTTagCompound lllllllllllIIIlIlllIIIlIlIlIIlIl = lllllllllllIIIlIlllIIIlIlIlIlIIl.getCompoundTag("DimensionData");
            for (final String lllllllllllIIIlIlllIIIlIlIlIIlII : lllllllllllIIIlIlllIIIlIlIlIIlIl.getKeySet()) {
                this.dimensionData.put(DimensionType.getById(Integer.parseInt(lllllllllllIIIlIlllIIIlIlIlIIlII)), lllllllllllIIIlIlllIIIlIlIlIIlIl.getCompoundTag(lllllllllllIIIlIlllIIIlIlIlIIlII));
            }
        }
    }
    
    protected WorldInfo() {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderSize = 6.0E7;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.dimensionData = (Map<DimensionType, NBTTagCompound>)Maps.newEnumMap((Class)DimensionType.class);
        this.theGameRules = new GameRules();
    }
    
    public void setDifficulty(final EnumDifficulty lllllllllllIIIlIlllIIIIlIlIllIll) {
        this.difficulty = lllllllllllIIIlIlllIIIIlIlIllIll;
    }
    
    public boolean isMapFeaturesEnabled() {
        return this.mapFeaturesEnabled;
    }
    
    public int getCleanWeatherTime() {
        return this.cleanWeatherTime;
    }
    
    public void setBorderLerpTime(final long lllllllllllIIIlIlllIIIIllIIlllIl) {
        this.borderSizeLerpTime = lllllllllllIIIlIlllIIIIllIIlllIl;
    }
    
    public int getSaveVersion() {
        return this.saveVersion;
    }
    
    public double getBorderCenterZ() {
        return this.borderCenterZ;
    }
    
    public void setWorldName(final String lllllllllllIIIlIlllIIIlIIIlIlIlI) {
        this.levelName = lllllllllllIIIlIlllIIIlIIIlIlIlI;
    }
    
    public void setRainTime(final int lllllllllllIIIlIlllIIIIllllIllll) {
        this.rainTime = lllllllllllIIIlIlllIIIIllllIllll;
    }
    
    public NBTTagCompound getDimensionData(final DimensionType lllllllllllIIIlIlllIIIIlIlIIIlIl) {
        final NBTTagCompound lllllllllllIIIlIlllIIIIlIlIIIlII = this.dimensionData.get(lllllllllllIIIlIlllIIIIlIlIIIlIl);
        return (lllllllllllIIIlIlllIIIIlIlIIIlII == null) ? new NBTTagCompound() : lllllllllllIIIlIlllIIIIlIlIIIlII;
    }
    
    public String getGeneratorOptions() {
        return (this.generatorOptions == null) ? "" : this.generatorOptions;
    }
    
    public static void registerFixes(final DataFixer lllllllllllIIIlIlllIIIlIlIllIIIl) {
        lllllllllllIIIlIlllIIIlIlIllIIIl.registerWalker(FixTypes.LEVEL, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer llllllllllIlllIIIllIIIIllIIlIllI, final NBTTagCompound llllllllllIlllIIIllIIIIllIIlIIlI, final int llllllllllIlllIIIllIIIIllIIlIlII) {
                if (llllllllllIlllIIIllIIIIllIIlIIlI.hasKey("Player", 10)) {
                    llllllllllIlllIIIllIIIIllIIlIIlI.setTag("Player", llllllllllIlllIIIllIIIIllIIlIllI.process(FixTypes.PLAYER, llllllllllIlllIIIllIIIIllIIlIIlI.getCompoundTag("Player"), llllllllllIlllIIIllIIIIllIIlIlII));
                }
                return llllllllllIlllIIIllIIIIllIIlIIlI;
            }
        });
    }
    
    public boolean isVersionSnapshot() {
        return this.versionSnapshot;
    }
    
    public double getBorderSize() {
        return this.borderSize;
    }
    
    public void getBorderCenterX(final double lllllllllllIIIlIlllIIIIllIIIlIII) {
        this.borderCenterX = lllllllllllIIIlIlllIIIIllIIIlIII;
    }
    
    public void setHardcore(final boolean lllllllllllIIIlIlllIIIIlllIlIllI) {
        this.hardcore = lllllllllllIIIlIlllIIIIlllIlIllI;
    }
    
    public void setSpawnZ(final int lllllllllllIIIlIlllIIIlIIlIIIlIl) {
        this.spawnZ = lllllllllllIIIlIlllIIIlIIlIIIlIl;
    }
    
    public GameType getGameType() {
        return this.theGameType;
    }
    
    public void populateFromWorldSettings(final WorldSettings lllllllllllIIIlIlllIIIlIlIIlIIlI) {
        this.randomSeed = lllllllllllIIIlIlllIIIlIlIIlIIlI.getSeed();
        this.theGameType = lllllllllllIIIlIlllIIIlIlIIlIIlI.getGameType();
        this.mapFeaturesEnabled = lllllllllllIIIlIlllIIIlIlIIlIIlI.isMapFeaturesEnabled();
        this.hardcore = lllllllllllIIIlIlllIIIlIlIIlIIlI.getHardcoreEnabled();
        this.terrainType = lllllllllllIIIlIlllIIIlIlIIlIIlI.getTerrainType();
        this.generatorOptions = lllllllllllIIIlIlllIIIlIlIIlIIlI.getGeneratorOptions();
        this.allowCommands = lllllllllllIIIlIlllIIIlIlIIlIIlI.areCommandsAllowed();
    }
    
    public int getSpawnY() {
        return this.spawnY;
    }
    
    public int getBorderWarningTime() {
        return this.borderWarningTime;
    }
    
    public void setBorderWarningTime(final int lllllllllllIIIlIlllIIIIlIllIIIlI) {
        this.borderWarningTime = lllllllllllIIIlIlllIIIIlIllIIIlI;
    }
    
    public long getWorldTime() {
        return this.worldTime;
    }
    
    public int getSpawnZ() {
        return this.spawnZ;
    }
    
    public int getBorderWarningDistance() {
        return this.borderWarningDistance;
    }
    
    public void setBorderLerpTarget(final double lllllllllllIIIlIlllIIIIllIIlIIlI) {
        this.borderSizeLerpTarget = lllllllllllIIIlIlllIIIIllIIlIIlI;
    }
    
    public void setGameType(final GameType lllllllllllIIIlIlllIIIIlllIlllll) {
        this.theGameType = lllllllllllIIIlIlllIIIIlllIlllll;
    }
    
    public long getSizeOnDisk() {
        return this.sizeOnDisk;
    }
    
    public void setSpawnX(final int lllllllllllIIIlIlllIIIlIIlIIllll) {
        this.spawnX = lllllllllllIIIlIlllIIIlIIlIIllll;
    }
    
    public int getThunderTime() {
        return this.thunderTime;
    }
    
    public WorldInfo(final WorldInfo lllllllllllIIIlIlllIIIlIlIIIlIlI) {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderSize = 6.0E7;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.dimensionData = (Map<DimensionType, NBTTagCompound>)Maps.newEnumMap((Class)DimensionType.class);
        this.theGameRules = new GameRules();
        this.randomSeed = lllllllllllIIIlIlllIIIlIlIIIlIlI.randomSeed;
        this.terrainType = lllllllllllIIIlIlllIIIlIlIIIlIlI.terrainType;
        this.generatorOptions = lllllllllllIIIlIlllIIIlIlIIIlIlI.generatorOptions;
        this.theGameType = lllllllllllIIIlIlllIIIlIlIIIlIlI.theGameType;
        this.mapFeaturesEnabled = lllllllllllIIIlIlllIIIlIlIIIlIlI.mapFeaturesEnabled;
        this.spawnX = lllllllllllIIIlIlllIIIlIlIIIlIlI.spawnX;
        this.spawnY = lllllllllllIIIlIlllIIIlIlIIIlIlI.spawnY;
        this.spawnZ = lllllllllllIIIlIlllIIIlIlIIIlIlI.spawnZ;
        this.totalTime = lllllllllllIIIlIlllIIIlIlIIIlIlI.totalTime;
        this.worldTime = lllllllllllIIIlIlllIIIlIlIIIlIlI.worldTime;
        this.lastTimePlayed = lllllllllllIIIlIlllIIIlIlIIIlIlI.lastTimePlayed;
        this.sizeOnDisk = lllllllllllIIIlIlllIIIlIlIIIlIlI.sizeOnDisk;
        this.playerTag = lllllllllllIIIlIlllIIIlIlIIIlIlI.playerTag;
        this.dimension = lllllllllllIIIlIlllIIIlIlIIIlIlI.dimension;
        this.levelName = lllllllllllIIIlIlllIIIlIlIIIlIlI.levelName;
        this.saveVersion = lllllllllllIIIlIlllIIIlIlIIIlIlI.saveVersion;
        this.rainTime = lllllllllllIIIlIlllIIIlIlIIIlIlI.rainTime;
        this.raining = lllllllllllIIIlIlllIIIlIlIIIlIlI.raining;
        this.thunderTime = lllllllllllIIIlIlllIIIlIlIIIlIlI.thunderTime;
        this.thundering = lllllllllllIIIlIlllIIIlIlIIIlIlI.thundering;
        this.hardcore = lllllllllllIIIlIlllIIIlIlIIIlIlI.hardcore;
        this.allowCommands = lllllllllllIIIlIlllIIIlIlIIIlIlI.allowCommands;
        this.initialized = lllllllllllIIIlIlllIIIlIlIIIlIlI.initialized;
        this.theGameRules = lllllllllllIIIlIlllIIIlIlIIIlIlI.theGameRules;
        this.difficulty = lllllllllllIIIlIlllIIIlIlIIIlIlI.difficulty;
        this.difficultyLocked = lllllllllllIIIlIlllIIIlIlIIIlIlI.difficultyLocked;
        this.borderCenterX = lllllllllllIIIlIlllIIIlIlIIIlIlI.borderCenterX;
        this.borderCenterZ = lllllllllllIIIlIlllIIIlIlIIIlIlI.borderCenterZ;
        this.borderSize = lllllllllllIIIlIlllIIIlIlIIIlIlI.borderSize;
        this.borderSizeLerpTime = lllllllllllIIIlIlllIIIlIlIIIlIlI.borderSizeLerpTime;
        this.borderSizeLerpTarget = lllllllllllIIIlIlllIIIlIlIIIlIlI.borderSizeLerpTarget;
        this.borderSafeZone = lllllllllllIIIlIlllIIIlIlIIIlIlI.borderSafeZone;
        this.borderDamagePerBlock = lllllllllllIIIlIlllIIIlIlIIIlIlI.borderDamagePerBlock;
        this.borderWarningTime = lllllllllllIIIlIlllIIIlIlIIIlIlI.borderWarningTime;
        this.borderWarningDistance = lllllllllllIIIlIlllIIIlIlIIIlIlI.borderWarningDistance;
    }
    
    public double getBorderLerpTarget() {
        return this.borderSizeLerpTarget;
    }
    
    public int getVersionId() {
        return this.versionId;
    }
    
    public void setDimensionData(final DimensionType lllllllllllIIIlIlllIIIIlIIllllII, final NBTTagCompound lllllllllllIIIlIlllIIIIlIIlllIll) {
        this.dimensionData.put(lllllllllllIIIlIlllIIIIlIIllllII, lllllllllllIIIlIlllIIIIlIIlllIll);
    }
    
    public void setBorderSafeZone(final double lllllllllllIIIlIlllIIIIlIlllllIl) {
        this.borderSafeZone = lllllllllllIIIlIlllIIIIlIlllllIl;
    }
    
    public WorldInfo(final WorldSettings lllllllllllIIIlIlllIIIlIlIIllIlI, final String lllllllllllIIIlIlllIIIlIlIIllIIl) {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderSize = 6.0E7;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.dimensionData = (Map<DimensionType, NBTTagCompound>)Maps.newEnumMap((Class)DimensionType.class);
        this.theGameRules = new GameRules();
        this.populateFromWorldSettings(lllllllllllIIIlIlllIIIlIlIIllIlI);
        this.levelName = lllllllllllIIIlIlllIIIlIlIIllIIl;
        this.difficulty = WorldInfo.DEFAULT_DIFFICULTY;
        this.initialized = false;
    }
    
    public void setSpawnY(final int lllllllllllIIIlIlllIIIlIIlIIlIIl) {
        this.spawnY = lllllllllllIIIlIlllIIIlIIlIIlIIl;
    }
    
    public void setRaining(final boolean lllllllllllIIIlIlllIIIIllllllIlI) {
        this.raining = lllllllllllIIIlIlllIIIIllllllIlI;
    }
    
    public boolean isDifficultyLocked() {
        return this.difficultyLocked;
    }
    
    public String getVersionName() {
        return this.versionName;
    }
    
    public long getWorldTotalTime() {
        return this.totalTime;
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    public boolean isHardcoreModeEnabled() {
        return this.hardcore;
    }
    
    public long getLastTimePlayed() {
        return this.lastTimePlayed;
    }
    
    public void addToCrashReport(final CrashReportCategory lllllllllllIIIlIlllIIIIlIlIIllII) {
        lllllllllllIIIlIlllIIIIlIlIIllII.setDetail("Level seed", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.valueOf(WorldInfo.this.getSeed());
            }
        });
        lllllllllllIIIlIlllIIIIlIlIIllII.setDetail("Level generator", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.format("ID %02d - %s, ver %d. Features enabled: %b", WorldInfo.this.terrainType.getWorldTypeID(), WorldInfo.this.terrainType.getWorldTypeName(), WorldInfo.this.terrainType.getGeneratorVersion(), WorldInfo.this.mapFeaturesEnabled);
            }
        });
        lllllllllllIIIlIlllIIIIlIlIIllII.setDetail("Level generator options", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return WorldInfo.this.generatorOptions;
            }
        });
        lllllllllllIIIlIlllIIIIlIlIIllII.setDetail("Level spawn location", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return CrashReportCategory.getCoordinateInfo(WorldInfo.this.spawnX, WorldInfo.this.spawnY, WorldInfo.this.spawnZ);
            }
        });
        lllllllllllIIIlIlllIIIIlIlIIllII.setDetail("Level time", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.format("%d game time, %d day time", WorldInfo.this.totalTime, WorldInfo.this.worldTime);
            }
        });
        lllllllllllIIIlIlllIIIIlIlIIllII.setDetail("Level dimension", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.valueOf(WorldInfo.this.dimension);
            }
        });
        lllllllllllIIIlIlllIIIIlIlIIllII.setDetail("Level storage version", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                String llllllllllIlllllIlIIllIIlIlIlllI = "Unknown?";
                try {
                    switch (WorldInfo.this.saveVersion) {
                        case 19132: {
                            llllllllllIlllllIlIIllIIlIlIlllI = "McRegion";
                            break;
                        }
                        case 19133: {
                            llllllllllIlllllIlIIllIIlIlIlllI = "Anvil";
                            break;
                        }
                    }
                }
                catch (Throwable t) {}
                return String.format("0x%05X - %s", WorldInfo.this.saveVersion, llllllllllIlllllIlIIllIIlIlIlllI);
            }
        });
        lllllllllllIIIlIlllIIIIlIlIIllII.setDetail("Level weather", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", WorldInfo.this.rainTime, WorldInfo.this.raining, WorldInfo.this.thunderTime, WorldInfo.this.thundering);
            }
        });
        lllllllllllIIIlIlllIIIIlIlIIllII.setDetail("Level game mode", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", WorldInfo.this.theGameType.getName(), WorldInfo.this.theGameType.getID(), WorldInfo.this.hardcore, WorldInfo.this.allowCommands);
            }
        });
    }
    
    public WorldType getTerrainType() {
        return this.terrainType;
    }
    
    public void setTerrainType(final WorldType lllllllllllIIIlIlllIIIIlllIIllIl) {
        this.terrainType = lllllllllllIIIlIlllIIIIlllIIllIl;
    }
    
    public void setCleanWeatherTime(final int lllllllllllIIIlIlllIIIlIIIIlIIll) {
        this.cleanWeatherTime = lllllllllllIIIlIlllIIIlIIIIlIIll;
    }
    
    public void setBorderWarningDistance(final int lllllllllllIIIlIlllIIIIlIllIlIlI) {
        this.borderWarningDistance = lllllllllllIIIlIlllIIIIlIllIlIlI;
    }
    
    public void setThunderTime(final int lllllllllllIIIlIlllIIIlIIIIIIIll) {
        this.thunderTime = lllllllllllIIIlIlllIIIlIIIIIIIll;
    }
    
    public int getSpawnX() {
        return this.spawnX;
    }
    
    public void setSaveVersion(final int lllllllllllIIIlIlllIIIlIIIlIIIIl) {
        this.saveVersion = lllllllllllIIIlIlllIIIlIIIlIIIIl;
    }
    
    public boolean isRaining() {
        return this.raining;
    }
    
    public void setBorderDamagePerBlock(final double lllllllllllIIIlIlllIIIIlIlllIllI) {
        this.borderDamagePerBlock = lllllllllllIIIlIlllIIIIlIlllIllI;
    }
    
    public void setWorldTotalTime(final long lllllllllllIIIlIlllIIIlIIIllllll) {
        this.totalTime = lllllllllllIIIlIlllIIIlIIIllllll;
    }
}
