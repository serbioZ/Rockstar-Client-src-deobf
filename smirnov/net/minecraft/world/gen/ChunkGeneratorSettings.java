// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import com.google.gson.GsonBuilder;
import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;

public class ChunkGeneratorSettings
{
    public final /* synthetic */ boolean useRavines;
    public final /* synthetic */ int waterLakeChance;
    public final /* synthetic */ float stretchY;
    public final /* synthetic */ int fixedBiome;
    public final /* synthetic */ boolean useStrongholds;
    public final /* synthetic */ int redstoneSize;
    public final /* synthetic */ boolean useLavaOceans;
    public final /* synthetic */ int ironMaxHeight;
    public final /* synthetic */ int dirtMinHeight;
    public final /* synthetic */ int lapisCount;
    public final /* synthetic */ int lavaLakeChance;
    public final /* synthetic */ int gravelCount;
    public final /* synthetic */ boolean useLavaLakes;
    public final /* synthetic */ float biomeScaleOffset;
    public final /* synthetic */ int ironSize;
    public final /* synthetic */ int redstoneMaxHeight;
    public final /* synthetic */ int goldCount;
    public final /* synthetic */ float upperLimitScale;
    public final /* synthetic */ int diamondMinHeight;
    public final /* synthetic */ int goldSize;
    public final /* synthetic */ int dirtSize;
    public final /* synthetic */ int andesiteMaxHeight;
    public final /* synthetic */ int coalSize;
    public final /* synthetic */ float depthNoiseScaleX;
    public final /* synthetic */ float mainNoiseScaleY;
    public final /* synthetic */ int lapisSpread;
    public final /* synthetic */ boolean field_191077_z;
    public final /* synthetic */ int andesiteCount;
    public final /* synthetic */ int gravelMaxHeight;
    public final /* synthetic */ boolean useVillages;
    public final /* synthetic */ float heightScale;
    public final /* synthetic */ int goldMinHeight;
    public final /* synthetic */ int andesiteMinHeight;
    public final /* synthetic */ int graniteMinHeight;
    public final /* synthetic */ int ironCount;
    public final /* synthetic */ int coalMaxHeight;
    public final /* synthetic */ float biomeDepthOffSet;
    public final /* synthetic */ int dioriteMinHeight;
    public final /* synthetic */ int goldMaxHeight;
    public final /* synthetic */ boolean useDungeons;
    public final /* synthetic */ boolean useTemples;
    public final /* synthetic */ int lapisCenterHeight;
    public final /* synthetic */ int dioriteMaxHeight;
    public final /* synthetic */ float biomeDepthWeight;
    public final /* synthetic */ boolean useWaterLakes;
    public final /* synthetic */ int redstoneMinHeight;
    public final /* synthetic */ int coalMinHeight;
    public final /* synthetic */ float mainNoiseScaleX;
    public final /* synthetic */ boolean useMineShafts;
    public final /* synthetic */ int diamondCount;
    public final /* synthetic */ int graniteSize;
    public final /* synthetic */ int biomeSize;
    public final /* synthetic */ int ironMinHeight;
    public final /* synthetic */ float depthNoiseScaleZ;
    public final /* synthetic */ int redstoneCount;
    public final /* synthetic */ float lowerLimitScale;
    public final /* synthetic */ int seaLevel;
    public final /* synthetic */ int dirtMaxHeight;
    public final /* synthetic */ int diamondMaxHeight;
    public final /* synthetic */ float coordinateScale;
    public final /* synthetic */ float biomeScaleWeight;
    public final /* synthetic */ float mainNoiseScaleZ;
    public final /* synthetic */ boolean useCaves;
    public final /* synthetic */ int graniteCount;
    public final /* synthetic */ float baseSize;
    public final /* synthetic */ int andesiteSize;
    public final /* synthetic */ int coalCount;
    public final /* synthetic */ int dungeonChance;
    public final /* synthetic */ int gravelMinHeight;
    public final /* synthetic */ int diamondSize;
    public final /* synthetic */ int lapisSize;
    public final /* synthetic */ int graniteMaxHeight;
    public final /* synthetic */ int dioriteCount;
    public final /* synthetic */ int riverSize;
    public final /* synthetic */ int dioriteSize;
    public final /* synthetic */ int gravelSize;
    public final /* synthetic */ float depthNoiseScaleExponent;
    public final /* synthetic */ int dirtCount;
    public final /* synthetic */ boolean useMonuments;
    
    private ChunkGeneratorSettings(final Factory llllllllllIlllIIIlIIlIlllIlllllI) {
        this.coordinateScale = llllllllllIlllIIIlIIlIlllIlllllI.coordinateScale;
        this.heightScale = llllllllllIlllIIIlIIlIlllIlllllI.heightScale;
        this.upperLimitScale = llllllllllIlllIIIlIIlIlllIlllllI.upperLimitScale;
        this.lowerLimitScale = llllllllllIlllIIIlIIlIlllIlllllI.lowerLimitScale;
        this.depthNoiseScaleX = llllllllllIlllIIIlIIlIlllIlllllI.depthNoiseScaleX;
        this.depthNoiseScaleZ = llllllllllIlllIIIlIIlIlllIlllllI.depthNoiseScaleZ;
        this.depthNoiseScaleExponent = llllllllllIlllIIIlIIlIlllIlllllI.depthNoiseScaleExponent;
        this.mainNoiseScaleX = llllllllllIlllIIIlIIlIlllIlllllI.mainNoiseScaleX;
        this.mainNoiseScaleY = llllllllllIlllIIIlIIlIlllIlllllI.mainNoiseScaleY;
        this.mainNoiseScaleZ = llllllllllIlllIIIlIIlIlllIlllllI.mainNoiseScaleZ;
        this.baseSize = llllllllllIlllIIIlIIlIlllIlllllI.baseSize;
        this.stretchY = llllllllllIlllIIIlIIlIlllIlllllI.stretchY;
        this.biomeDepthWeight = llllllllllIlllIIIlIIlIlllIlllllI.biomeDepthWeight;
        this.biomeDepthOffSet = llllllllllIlllIIIlIIlIlllIlllllI.biomeDepthOffset;
        this.biomeScaleWeight = llllllllllIlllIIIlIIlIlllIlllllI.biomeScaleWeight;
        this.biomeScaleOffset = llllllllllIlllIIIlIIlIlllIlllllI.biomeScaleOffset;
        this.seaLevel = llllllllllIlllIIIlIIlIlllIlllllI.seaLevel;
        this.useCaves = llllllllllIlllIIIlIIlIlllIlllllI.useCaves;
        this.useDungeons = llllllllllIlllIIIlIIlIlllIlllllI.useDungeons;
        this.dungeonChance = llllllllllIlllIIIlIIlIlllIlllllI.dungeonChance;
        this.useStrongholds = llllllllllIlllIIIlIIlIlllIlllllI.useStrongholds;
        this.useVillages = llllllllllIlllIIIlIIlIlllIlllllI.useVillages;
        this.useMineShafts = llllllllllIlllIIIlIIlIlllIlllllI.useMineShafts;
        this.useTemples = llllllllllIlllIIIlIIlIlllIlllllI.useTemples;
        this.useMonuments = llllllllllIlllIIIlIIlIlllIlllllI.useMonuments;
        this.field_191077_z = llllllllllIlllIIIlIIlIlllIlllllI.field_191076_A;
        this.useRavines = llllllllllIlllIIIlIIlIlllIlllllI.useRavines;
        this.useWaterLakes = llllllllllIlllIIIlIIlIlllIlllllI.useWaterLakes;
        this.waterLakeChance = llllllllllIlllIIIlIIlIlllIlllllI.waterLakeChance;
        this.useLavaLakes = llllllllllIlllIIIlIIlIlllIlllllI.useLavaLakes;
        this.lavaLakeChance = llllllllllIlllIIIlIIlIlllIlllllI.lavaLakeChance;
        this.useLavaOceans = llllllllllIlllIIIlIIlIlllIlllllI.useLavaOceans;
        this.fixedBiome = llllllllllIlllIIIlIIlIlllIlllllI.fixedBiome;
        this.biomeSize = llllllllllIlllIIIlIIlIlllIlllllI.biomeSize;
        this.riverSize = llllllllllIlllIIIlIIlIlllIlllllI.riverSize;
        this.dirtSize = llllllllllIlllIIIlIIlIlllIlllllI.dirtSize;
        this.dirtCount = llllllllllIlllIIIlIIlIlllIlllllI.dirtCount;
        this.dirtMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.dirtMinHeight;
        this.dirtMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.dirtMaxHeight;
        this.gravelSize = llllllllllIlllIIIlIIlIlllIlllllI.gravelSize;
        this.gravelCount = llllllllllIlllIIIlIIlIlllIlllllI.gravelCount;
        this.gravelMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.gravelMinHeight;
        this.gravelMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.gravelMaxHeight;
        this.graniteSize = llllllllllIlllIIIlIIlIlllIlllllI.graniteSize;
        this.graniteCount = llllllllllIlllIIIlIIlIlllIlllllI.graniteCount;
        this.graniteMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.graniteMinHeight;
        this.graniteMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.graniteMaxHeight;
        this.dioriteSize = llllllllllIlllIIIlIIlIlllIlllllI.dioriteSize;
        this.dioriteCount = llllllllllIlllIIIlIIlIlllIlllllI.dioriteCount;
        this.dioriteMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.dioriteMinHeight;
        this.dioriteMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.dioriteMaxHeight;
        this.andesiteSize = llllllllllIlllIIIlIIlIlllIlllllI.andesiteSize;
        this.andesiteCount = llllllllllIlllIIIlIIlIlllIlllllI.andesiteCount;
        this.andesiteMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.andesiteMinHeight;
        this.andesiteMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.andesiteMaxHeight;
        this.coalSize = llllllllllIlllIIIlIIlIlllIlllllI.coalSize;
        this.coalCount = llllllllllIlllIIIlIIlIlllIlllllI.coalCount;
        this.coalMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.coalMinHeight;
        this.coalMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.coalMaxHeight;
        this.ironSize = llllllllllIlllIIIlIIlIlllIlllllI.ironSize;
        this.ironCount = llllllllllIlllIIIlIIlIlllIlllllI.ironCount;
        this.ironMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.ironMinHeight;
        this.ironMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.ironMaxHeight;
        this.goldSize = llllllllllIlllIIIlIIlIlllIlllllI.goldSize;
        this.goldCount = llllllllllIlllIIIlIIlIlllIlllllI.goldCount;
        this.goldMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.goldMinHeight;
        this.goldMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.goldMaxHeight;
        this.redstoneSize = llllllllllIlllIIIlIIlIlllIlllllI.redstoneSize;
        this.redstoneCount = llllllllllIlllIIIlIIlIlllIlllllI.redstoneCount;
        this.redstoneMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.redstoneMinHeight;
        this.redstoneMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.redstoneMaxHeight;
        this.diamondSize = llllllllllIlllIIIlIIlIlllIlllllI.diamondSize;
        this.diamondCount = llllllllllIlllIIIlIIlIlllIlllllI.diamondCount;
        this.diamondMinHeight = llllllllllIlllIIIlIIlIlllIlllllI.diamondMinHeight;
        this.diamondMaxHeight = llllllllllIlllIIIlIIlIlllIlllllI.diamondMaxHeight;
        this.lapisSize = llllllllllIlllIIIlIIlIlllIlllllI.lapisSize;
        this.lapisCount = llllllllllIlllIIIlIIlIlllIlllllI.lapisCount;
        this.lapisCenterHeight = llllllllllIlllIIIlIIlIlllIlllllI.lapisCenterHeight;
        this.lapisSpread = llllllllllIlllIIIlIIlIlllIlllllI.lapisSpread;
    }
    
    public static class Serializer implements JsonDeserializer<Factory>, JsonSerializer<Factory>
    {
        public Factory deserialize(final JsonElement llllllllllllIIlIlIIlIIlIIIIIIlll, final Type llllllllllllIIlIlIIlIIlIIIIIlIll, final JsonDeserializationContext llllllllllllIIlIlIIlIIlIIIIIlIlI) throws JsonParseException {
            final JsonObject llllllllllllIIlIlIIlIIlIIIIIlIIl = llllllllllllIIlIlIIlIIlIIIIIIlll.getAsJsonObject();
            final Factory llllllllllllIIlIlIIlIIlIIIIIlIII = new Factory();
            try {
                llllllllllllIIlIlIIlIIlIIIIIlIII.coordinateScale = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "coordinateScale", llllllllllllIIlIlIIlIIlIIIIIlIII.coordinateScale);
                llllllllllllIIlIlIIlIIlIIIIIlIII.heightScale = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "heightScale", llllllllllllIIlIlIIlIIlIIIIIlIII.heightScale);
                llllllllllllIIlIlIIlIIlIIIIIlIII.lowerLimitScale = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "lowerLimitScale", llllllllllllIIlIlIIlIIlIIIIIlIII.lowerLimitScale);
                llllllllllllIIlIlIIlIIlIIIIIlIII.upperLimitScale = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "upperLimitScale", llllllllllllIIlIlIIlIIlIIIIIlIII.upperLimitScale);
                llllllllllllIIlIlIIlIIlIIIIIlIII.depthNoiseScaleX = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "depthNoiseScaleX", llllllllllllIIlIlIIlIIlIIIIIlIII.depthNoiseScaleX);
                llllllllllllIIlIlIIlIIlIIIIIlIII.depthNoiseScaleZ = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "depthNoiseScaleZ", llllllllllllIIlIlIIlIIlIIIIIlIII.depthNoiseScaleZ);
                llllllllllllIIlIlIIlIIlIIIIIlIII.depthNoiseScaleExponent = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "depthNoiseScaleExponent", llllllllllllIIlIlIIlIIlIIIIIlIII.depthNoiseScaleExponent);
                llllllllllllIIlIlIIlIIlIIIIIlIII.mainNoiseScaleX = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "mainNoiseScaleX", llllllllllllIIlIlIIlIIlIIIIIlIII.mainNoiseScaleX);
                llllllllllllIIlIlIIlIIlIIIIIlIII.mainNoiseScaleY = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "mainNoiseScaleY", llllllllllllIIlIlIIlIIlIIIIIlIII.mainNoiseScaleY);
                llllllllllllIIlIlIIlIIlIIIIIlIII.mainNoiseScaleZ = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "mainNoiseScaleZ", llllllllllllIIlIlIIlIIlIIIIIlIII.mainNoiseScaleZ);
                llllllllllllIIlIlIIlIIlIIIIIlIII.baseSize = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "baseSize", llllllllllllIIlIlIIlIIlIIIIIlIII.baseSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.stretchY = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "stretchY", llllllllllllIIlIlIIlIIlIIIIIlIII.stretchY);
                llllllllllllIIlIlIIlIIlIIIIIlIII.biomeDepthWeight = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "biomeDepthWeight", llllllllllllIIlIlIIlIIlIIIIIlIII.biomeDepthWeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.biomeDepthOffset = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "biomeDepthOffset", llllllllllllIIlIlIIlIIlIIIIIlIII.biomeDepthOffset);
                llllllllllllIIlIlIIlIIlIIIIIlIII.biomeScaleWeight = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "biomeScaleWeight", llllllllllllIIlIlIIlIIlIIIIIlIII.biomeScaleWeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.biomeScaleOffset = JsonUtils.getFloat(llllllllllllIIlIlIIlIIlIIIIIlIIl, "biomeScaleOffset", llllllllllllIIlIlIIlIIlIIIIIlIII.biomeScaleOffset);
                llllllllllllIIlIlIIlIIlIIIIIlIII.seaLevel = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "seaLevel", llllllllllllIIlIlIIlIIlIIIIIlIII.seaLevel);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useCaves = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useCaves", llllllllllllIIlIlIIlIIlIIIIIlIII.useCaves);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useDungeons = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useDungeons", llllllllllllIIlIlIIlIIlIIIIIlIII.useDungeons);
                llllllllllllIIlIlIIlIIlIIIIIlIII.dungeonChance = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "dungeonChance", llllllllllllIIlIlIIlIIlIIIIIlIII.dungeonChance);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useStrongholds = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useStrongholds", llllllllllllIIlIlIIlIIlIIIIIlIII.useStrongholds);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useVillages = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useVillages", llllllllllllIIlIlIIlIIlIIIIIlIII.useVillages);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useMineShafts = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useMineShafts", llllllllllllIIlIlIIlIIlIIIIIlIII.useMineShafts);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useTemples = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useTemples", llllllllllllIIlIlIIlIIlIIIIIlIII.useTemples);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useMonuments = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useMonuments", llllllllllllIIlIlIIlIIlIIIIIlIII.useMonuments);
                llllllllllllIIlIlIIlIIlIIIIIlIII.field_191076_A = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useMansions", llllllllllllIIlIlIIlIIlIIIIIlIII.field_191076_A);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useRavines = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useRavines", llllllllllllIIlIlIIlIIlIIIIIlIII.useRavines);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useWaterLakes = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useWaterLakes", llllllllllllIIlIlIIlIIlIIIIIlIII.useWaterLakes);
                llllllllllllIIlIlIIlIIlIIIIIlIII.waterLakeChance = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "waterLakeChance", llllllllllllIIlIlIIlIIlIIIIIlIII.waterLakeChance);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useLavaLakes = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useLavaLakes", llllllllllllIIlIlIIlIIlIIIIIlIII.useLavaLakes);
                llllllllllllIIlIlIIlIIlIIIIIlIII.lavaLakeChance = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "lavaLakeChance", llllllllllllIIlIlIIlIIlIIIIIlIII.lavaLakeChance);
                llllllllllllIIlIlIIlIIlIIIIIlIII.useLavaOceans = JsonUtils.getBoolean(llllllllllllIIlIlIIlIIlIIIIIlIIl, "useLavaOceans", llllllllllllIIlIlIIlIIlIIIIIlIII.useLavaOceans);
                llllllllllllIIlIlIIlIIlIIIIIlIII.fixedBiome = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "fixedBiome", llllllllllllIIlIlIIlIIlIIIIIlIII.fixedBiome);
                if (llllllllllllIIlIlIIlIIlIIIIIlIII.fixedBiome < 38 && llllllllllllIIlIlIIlIIlIIIIIlIII.fixedBiome >= -1) {
                    if (llllllllllllIIlIlIIlIIlIIIIIlIII.fixedBiome >= Biome.getIdForBiome(Biomes.HELL)) {
                        final Factory factory = llllllllllllIIlIlIIlIIlIIIIIlIII;
                        factory.fixedBiome += 2;
                    }
                }
                else {
                    llllllllllllIIlIlIIlIIlIIIIIlIII.fixedBiome = -1;
                }
                llllllllllllIIlIlIIlIIlIIIIIlIII.biomeSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "biomeSize", llllllllllllIIlIlIIlIIlIIIIIlIII.biomeSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.riverSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "riverSize", llllllllllllIIlIlIIlIIlIIIIIlIII.riverSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.dirtSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "dirtSize", llllllllllllIIlIlIIlIIlIIIIIlIII.dirtSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.dirtCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "dirtCount", llllllllllllIIlIlIIlIIlIIIIIlIII.dirtCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.dirtMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "dirtMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.dirtMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.dirtMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "dirtMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.dirtMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.gravelSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "gravelSize", llllllllllllIIlIlIIlIIlIIIIIlIII.gravelSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.gravelCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "gravelCount", llllllllllllIIlIlIIlIIlIIIIIlIII.gravelCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.gravelMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "gravelMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.gravelMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.gravelMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "gravelMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.gravelMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.graniteSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "graniteSize", llllllllllllIIlIlIIlIIlIIIIIlIII.graniteSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.graniteCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "graniteCount", llllllllllllIIlIlIIlIIlIIIIIlIII.graniteCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.graniteMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "graniteMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.graniteMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.graniteMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "graniteMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.graniteMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.dioriteSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "dioriteSize", llllllllllllIIlIlIIlIIlIIIIIlIII.dioriteSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.dioriteCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "dioriteCount", llllllllllllIIlIlIIlIIlIIIIIlIII.dioriteCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.dioriteMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "dioriteMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.dioriteMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.dioriteMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "dioriteMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.dioriteMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.andesiteSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "andesiteSize", llllllllllllIIlIlIIlIIlIIIIIlIII.andesiteSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.andesiteCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "andesiteCount", llllllllllllIIlIlIIlIIlIIIIIlIII.andesiteCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.andesiteMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "andesiteMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.andesiteMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.andesiteMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "andesiteMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.andesiteMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.coalSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "coalSize", llllllllllllIIlIlIIlIIlIIIIIlIII.coalSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.coalCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "coalCount", llllllllllllIIlIlIIlIIlIIIIIlIII.coalCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.coalMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "coalMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.coalMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.coalMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "coalMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.coalMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.ironSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "ironSize", llllllllllllIIlIlIIlIIlIIIIIlIII.ironSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.ironCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "ironCount", llllllllllllIIlIlIIlIIlIIIIIlIII.ironCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.ironMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "ironMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.ironMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.ironMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "ironMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.ironMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.goldSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "goldSize", llllllllllllIIlIlIIlIIlIIIIIlIII.goldSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.goldCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "goldCount", llllllllllllIIlIlIIlIIlIIIIIlIII.goldCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.goldMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "goldMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.goldMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.goldMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "goldMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.goldMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.redstoneSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "redstoneSize", llllllllllllIIlIlIIlIIlIIIIIlIII.redstoneSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.redstoneCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "redstoneCount", llllllllllllIIlIlIIlIIlIIIIIlIII.redstoneCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.redstoneMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "redstoneMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.redstoneMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.redstoneMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "redstoneMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.redstoneMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.diamondSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "diamondSize", llllllllllllIIlIlIIlIIlIIIIIlIII.diamondSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.diamondCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "diamondCount", llllllllllllIIlIlIIlIIlIIIIIlIII.diamondCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.diamondMinHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "diamondMinHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.diamondMinHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.diamondMaxHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "diamondMaxHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.diamondMaxHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.lapisSize = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "lapisSize", llllllllllllIIlIlIIlIIlIIIIIlIII.lapisSize);
                llllllllllllIIlIlIIlIIlIIIIIlIII.lapisCount = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "lapisCount", llllllllllllIIlIlIIlIIlIIIIIlIII.lapisCount);
                llllllllllllIIlIlIIlIIlIIIIIlIII.lapisCenterHeight = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "lapisCenterHeight", llllllllllllIIlIlIIlIIlIIIIIlIII.lapisCenterHeight);
                llllllllllllIIlIlIIlIIlIIIIIlIII.lapisSpread = JsonUtils.getInt(llllllllllllIIlIlIIlIIlIIIIIlIIl, "lapisSpread", llllllllllllIIlIlIIlIIlIIIIIlIII.lapisSpread);
            }
            catch (Exception ex) {}
            return llllllllllllIIlIlIIlIIlIIIIIlIII;
        }
        
        public JsonElement serialize(final Factory llllllllllllIIlIlIIlIIIlllllllII, final Type llllllllllllIIlIlIIlIIIlllllllll, final JsonSerializationContext llllllllllllIIlIlIIlIIIllllllllI) {
            final JsonObject llllllllllllIIlIlIIlIIIlllllllIl = new JsonObject();
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("coordinateScale", (Number)llllllllllllIIlIlIIlIIIlllllllII.coordinateScale);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("heightScale", (Number)llllllllllllIIlIlIIlIIIlllllllII.heightScale);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("lowerLimitScale", (Number)llllllllllllIIlIlIIlIIIlllllllII.lowerLimitScale);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("upperLimitScale", (Number)llllllllllllIIlIlIIlIIIlllllllII.upperLimitScale);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("depthNoiseScaleX", (Number)llllllllllllIIlIlIIlIIIlllllllII.depthNoiseScaleX);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("depthNoiseScaleZ", (Number)llllllllllllIIlIlIIlIIIlllllllII.depthNoiseScaleZ);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("depthNoiseScaleExponent", (Number)llllllllllllIIlIlIIlIIIlllllllII.depthNoiseScaleExponent);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("mainNoiseScaleX", (Number)llllllllllllIIlIlIIlIIIlllllllII.mainNoiseScaleX);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("mainNoiseScaleY", (Number)llllllllllllIIlIlIIlIIIlllllllII.mainNoiseScaleY);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("mainNoiseScaleZ", (Number)llllllllllllIIlIlIIlIIIlllllllII.mainNoiseScaleZ);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("baseSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.baseSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("stretchY", (Number)llllllllllllIIlIlIIlIIIlllllllII.stretchY);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("biomeDepthWeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.biomeDepthWeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("biomeDepthOffset", (Number)llllllllllllIIlIlIIlIIIlllllllII.biomeDepthOffset);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("biomeScaleWeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.biomeScaleWeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("biomeScaleOffset", (Number)llllllllllllIIlIlIIlIIIlllllllII.biomeScaleOffset);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("seaLevel", (Number)llllllllllllIIlIlIIlIIIlllllllII.seaLevel);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useCaves", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useCaves));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useDungeons", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useDungeons));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("dungeonChance", (Number)llllllllllllIIlIlIIlIIIlllllllII.dungeonChance);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useStrongholds", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useStrongholds));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useVillages", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useVillages));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useMineShafts", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useMineShafts));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useTemples", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useTemples));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useMonuments", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useMonuments));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useMansions", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.field_191076_A));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useRavines", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useRavines));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useWaterLakes", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useWaterLakes));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("waterLakeChance", (Number)llllllllllllIIlIlIIlIIIlllllllII.waterLakeChance);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useLavaLakes", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useLavaLakes));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("lavaLakeChance", (Number)llllllllllllIIlIlIIlIIIlllllllII.lavaLakeChance);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("useLavaOceans", Boolean.valueOf(llllllllllllIIlIlIIlIIIlllllllII.useLavaOceans));
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("fixedBiome", (Number)llllllllllllIIlIlIIlIIIlllllllII.fixedBiome);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("biomeSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.biomeSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("riverSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.riverSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("dirtSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.dirtSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("dirtCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.dirtCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("dirtMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.dirtMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("dirtMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.dirtMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("gravelSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.gravelSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("gravelCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.gravelCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("gravelMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.gravelMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("gravelMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.gravelMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("graniteSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.graniteSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("graniteCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.graniteCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("graniteMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.graniteMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("graniteMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.graniteMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("dioriteSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.dioriteSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("dioriteCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.dioriteCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("dioriteMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.dioriteMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("dioriteMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.dioriteMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("andesiteSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.andesiteSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("andesiteCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.andesiteCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("andesiteMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.andesiteMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("andesiteMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.andesiteMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("coalSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.coalSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("coalCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.coalCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("coalMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.coalMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("coalMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.coalMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("ironSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.ironSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("ironCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.ironCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("ironMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.ironMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("ironMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.ironMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("goldSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.goldSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("goldCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.goldCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("goldMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.goldMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("goldMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.goldMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("redstoneSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.redstoneSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("redstoneCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.redstoneCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("redstoneMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.redstoneMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("redstoneMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.redstoneMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("diamondSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.diamondSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("diamondCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.diamondCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("diamondMinHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.diamondMinHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("diamondMaxHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.diamondMaxHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("lapisSize", (Number)llllllllllllIIlIlIIlIIIlllllllII.lapisSize);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("lapisCount", (Number)llllllllllllIIlIlIIlIIIlllllllII.lapisCount);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("lapisCenterHeight", (Number)llllllllllllIIlIlIIlIIIlllllllII.lapisCenterHeight);
            llllllllllllIIlIlIIlIIIlllllllIl.addProperty("lapisSpread", (Number)llllllllllllIIlIlIIlIIIlllllllII.lapisSpread);
            return (JsonElement)llllllllllllIIlIlIIlIIIlllllllIl;
        }
    }
    
    public static class Factory
    {
        public /* synthetic */ int ironMaxHeight;
        public /* synthetic */ int fixedBiome;
        public /* synthetic */ int coalMaxHeight;
        public /* synthetic */ int dirtSize;
        public /* synthetic */ int gravelSize;
        public /* synthetic */ int biomeSize;
        public /* synthetic */ float depthNoiseScaleExponent;
        public /* synthetic */ int gravelMaxHeight;
        public /* synthetic */ int redstoneMaxHeight;
        @VisibleForTesting
        static final /* synthetic */ Gson JSON_ADAPTER;
        public /* synthetic */ int lapisSize;
        public /* synthetic */ float baseSize;
        public /* synthetic */ boolean useTemples;
        public /* synthetic */ int goldMinHeight;
        public /* synthetic */ int lavaLakeChance;
        public /* synthetic */ int graniteMinHeight;
        public /* synthetic */ int graniteSize;
        public /* synthetic */ int gravelCount;
        public /* synthetic */ float heightScale;
        public /* synthetic */ int lapisSpread;
        public /* synthetic */ int graniteCount;
        public /* synthetic */ int dirtCount;
        public /* synthetic */ int riverSize;
        public /* synthetic */ int dungeonChance;
        public /* synthetic */ int gravelMinHeight;
        public /* synthetic */ int redstoneSize;
        public /* synthetic */ int andesiteMinHeight;
        public /* synthetic */ int dirtMinHeight;
        public /* synthetic */ float stretchY;
        public /* synthetic */ float biomeDepthOffset;
        public /* synthetic */ boolean useCaves;
        public /* synthetic */ int andesiteMaxHeight;
        public /* synthetic */ int coalSize;
        public /* synthetic */ int diamondMinHeight;
        public /* synthetic */ float coordinateScale;
        public /* synthetic */ int dioriteSize;
        public /* synthetic */ int coalMinHeight;
        public /* synthetic */ int ironMinHeight;
        public /* synthetic */ int seaLevel;
        public /* synthetic */ int coalCount;
        public /* synthetic */ boolean useRavines;
        public /* synthetic */ float biomeDepthWeight;
        public /* synthetic */ boolean useLavaLakes;
        public /* synthetic */ float mainNoiseScaleZ;
        public /* synthetic */ int goldMaxHeight;
        public /* synthetic */ boolean field_191076_A;
        public /* synthetic */ int diamondMaxHeight;
        public /* synthetic */ boolean useMonuments;
        public /* synthetic */ int goldCount;
        public /* synthetic */ float mainNoiseScaleX;
        public /* synthetic */ boolean useLavaOceans;
        public /* synthetic */ int dirtMaxHeight;
        public /* synthetic */ boolean useMineShafts;
        public /* synthetic */ int ironSize;
        public /* synthetic */ int redstoneCount;
        public /* synthetic */ int lapisCount;
        public /* synthetic */ boolean useWaterLakes;
        public /* synthetic */ boolean useDungeons;
        public /* synthetic */ float biomeScaleWeight;
        public /* synthetic */ int waterLakeChance;
        public /* synthetic */ int redstoneMinHeight;
        public /* synthetic */ int diamondCount;
        public /* synthetic */ int ironCount;
        public /* synthetic */ boolean useVillages;
        public /* synthetic */ int dioriteCount;
        public /* synthetic */ float upperLimitScale;
        public /* synthetic */ int diamondSize;
        public /* synthetic */ int lapisCenterHeight;
        public /* synthetic */ float depthNoiseScaleX;
        public /* synthetic */ float mainNoiseScaleY;
        public /* synthetic */ boolean useStrongholds;
        public /* synthetic */ float biomeScaleOffset;
        public /* synthetic */ int dioriteMinHeight;
        public /* synthetic */ int goldSize;
        public /* synthetic */ int andesiteSize;
        public /* synthetic */ float lowerLimitScale;
        public /* synthetic */ int dioriteMaxHeight;
        public /* synthetic */ int andesiteCount;
        public /* synthetic */ float depthNoiseScaleZ;
        public /* synthetic */ int graniteMaxHeight;
        
        static {
            JSON_ADAPTER = new GsonBuilder().registerTypeAdapter((Type)Factory.class, (Object)new Serializer()).create();
        }
        
        public ChunkGeneratorSettings build() {
            return new ChunkGeneratorSettings(this, null);
        }
        
        public Factory() {
            this.coordinateScale = 684.412f;
            this.heightScale = 684.412f;
            this.upperLimitScale = 512.0f;
            this.lowerLimitScale = 512.0f;
            this.depthNoiseScaleX = 200.0f;
            this.depthNoiseScaleZ = 200.0f;
            this.depthNoiseScaleExponent = 0.5f;
            this.mainNoiseScaleX = 80.0f;
            this.mainNoiseScaleY = 160.0f;
            this.mainNoiseScaleZ = 80.0f;
            this.baseSize = 8.5f;
            this.stretchY = 12.0f;
            this.biomeDepthWeight = 1.0f;
            this.biomeScaleWeight = 1.0f;
            this.seaLevel = 63;
            this.useCaves = true;
            this.useDungeons = true;
            this.dungeonChance = 8;
            this.useStrongholds = true;
            this.useVillages = true;
            this.useMineShafts = true;
            this.useTemples = true;
            this.useMonuments = true;
            this.field_191076_A = true;
            this.useRavines = true;
            this.useWaterLakes = true;
            this.waterLakeChance = 4;
            this.useLavaLakes = true;
            this.lavaLakeChance = 80;
            this.fixedBiome = -1;
            this.biomeSize = 4;
            this.riverSize = 4;
            this.dirtSize = 33;
            this.dirtCount = 10;
            this.dirtMaxHeight = 256;
            this.gravelSize = 33;
            this.gravelCount = 8;
            this.gravelMaxHeight = 256;
            this.graniteSize = 33;
            this.graniteCount = 10;
            this.graniteMaxHeight = 80;
            this.dioriteSize = 33;
            this.dioriteCount = 10;
            this.dioriteMaxHeight = 80;
            this.andesiteSize = 33;
            this.andesiteCount = 10;
            this.andesiteMaxHeight = 80;
            this.coalSize = 17;
            this.coalCount = 20;
            this.coalMaxHeight = 128;
            this.ironSize = 9;
            this.ironCount = 20;
            this.ironMaxHeight = 64;
            this.goldSize = 9;
            this.goldCount = 2;
            this.goldMaxHeight = 32;
            this.redstoneSize = 8;
            this.redstoneCount = 8;
            this.redstoneMaxHeight = 16;
            this.diamondSize = 8;
            this.diamondCount = 1;
            this.diamondMaxHeight = 16;
            this.lapisSize = 7;
            this.lapisCount = 1;
            this.lapisCenterHeight = 16;
            this.lapisSpread = 16;
            this.setDefaults();
        }
        
        public static Factory jsonToFactory(final String lllllllllllIlllIIlIllllIIlIlllII) {
            if (lllllllllllIlllIIlIllllIIlIlllII.isEmpty()) {
                return new Factory();
            }
            try {
                return JsonUtils.gsonDeserialize(Factory.JSON_ADAPTER, lllllllllllIlllIIlIllllIIlIlllII, Factory.class);
            }
            catch (Exception lllllllllllIlllIIlIllllIIlIlllIl) {
                return new Factory();
            }
        }
        
        @Override
        public boolean equals(final Object lllllllllllIlllIIlIllllIIlIIlIlI) {
            if (this == lllllllllllIlllIIlIllllIIlIIlIlI) {
                return true;
            }
            if (lllllllllllIlllIIlIllllIIlIIlIlI != null && this.getClass() == lllllllllllIlllIIlIllllIIlIIlIlI.getClass()) {
                final Factory lllllllllllIlllIIlIllllIIlIIllII = (Factory)lllllllllllIlllIIlIllllIIlIIlIlI;
                return this.andesiteCount == lllllllllllIlllIIlIllllIIlIIllII.andesiteCount && this.andesiteMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.andesiteMaxHeight && this.andesiteMinHeight == lllllllllllIlllIIlIllllIIlIIllII.andesiteMinHeight && this.andesiteSize == lllllllllllIlllIIlIllllIIlIIllII.andesiteSize && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.baseSize, this.baseSize) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.biomeDepthOffset, this.biomeDepthOffset) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.biomeDepthWeight, this.biomeDepthWeight) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.biomeScaleOffset, this.biomeScaleOffset) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.biomeScaleWeight, this.biomeScaleWeight) == 0 && this.biomeSize == lllllllllllIlllIIlIllllIIlIIllII.biomeSize && this.coalCount == lllllllllllIlllIIlIllllIIlIIllII.coalCount && this.coalMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.coalMaxHeight && this.coalMinHeight == lllllllllllIlllIIlIllllIIlIIllII.coalMinHeight && this.coalSize == lllllllllllIlllIIlIllllIIlIIllII.coalSize && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.coordinateScale, this.coordinateScale) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.depthNoiseScaleExponent, this.depthNoiseScaleExponent) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.depthNoiseScaleX, this.depthNoiseScaleX) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.depthNoiseScaleZ, this.depthNoiseScaleZ) == 0 && this.diamondCount == lllllllllllIlllIIlIllllIIlIIllII.diamondCount && this.diamondMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.diamondMaxHeight && this.diamondMinHeight == lllllllllllIlllIIlIllllIIlIIllII.diamondMinHeight && this.diamondSize == lllllllllllIlllIIlIllllIIlIIllII.diamondSize && this.dioriteCount == lllllllllllIlllIIlIllllIIlIIllII.dioriteCount && this.dioriteMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.dioriteMaxHeight && this.dioriteMinHeight == lllllllllllIlllIIlIllllIIlIIllII.dioriteMinHeight && this.dioriteSize == lllllllllllIlllIIlIllllIIlIIllII.dioriteSize && this.dirtCount == lllllllllllIlllIIlIllllIIlIIllII.dirtCount && this.dirtMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.dirtMaxHeight && this.dirtMinHeight == lllllllllllIlllIIlIllllIIlIIllII.dirtMinHeight && this.dirtSize == lllllllllllIlllIIlIllllIIlIIllII.dirtSize && this.dungeonChance == lllllllllllIlllIIlIllllIIlIIllII.dungeonChance && this.fixedBiome == lllllllllllIlllIIlIllllIIlIIllII.fixedBiome && this.goldCount == lllllllllllIlllIIlIllllIIlIIllII.goldCount && this.goldMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.goldMaxHeight && this.goldMinHeight == lllllllllllIlllIIlIllllIIlIIllII.goldMinHeight && this.goldSize == lllllllllllIlllIIlIllllIIlIIllII.goldSize && this.graniteCount == lllllllllllIlllIIlIllllIIlIIllII.graniteCount && this.graniteMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.graniteMaxHeight && this.graniteMinHeight == lllllllllllIlllIIlIllllIIlIIllII.graniteMinHeight && this.graniteSize == lllllllllllIlllIIlIllllIIlIIllII.graniteSize && this.gravelCount == lllllllllllIlllIIlIllllIIlIIllII.gravelCount && this.gravelMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.gravelMaxHeight && this.gravelMinHeight == lllllllllllIlllIIlIllllIIlIIllII.gravelMinHeight && this.gravelSize == lllllllllllIlllIIlIllllIIlIIllII.gravelSize && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.heightScale, this.heightScale) == 0 && this.ironCount == lllllllllllIlllIIlIllllIIlIIllII.ironCount && this.ironMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.ironMaxHeight && this.ironMinHeight == lllllllllllIlllIIlIllllIIlIIllII.ironMinHeight && this.ironSize == lllllllllllIlllIIlIllllIIlIIllII.ironSize && this.lapisCenterHeight == lllllllllllIlllIIlIllllIIlIIllII.lapisCenterHeight && this.lapisCount == lllllllllllIlllIIlIllllIIlIIllII.lapisCount && this.lapisSize == lllllllllllIlllIIlIllllIIlIIllII.lapisSize && this.lapisSpread == lllllllllllIlllIIlIllllIIlIIllII.lapisSpread && this.lavaLakeChance == lllllllllllIlllIIlIllllIIlIIllII.lavaLakeChance && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.lowerLimitScale, this.lowerLimitScale) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.mainNoiseScaleX, this.mainNoiseScaleX) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.mainNoiseScaleY, this.mainNoiseScaleY) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.mainNoiseScaleZ, this.mainNoiseScaleZ) == 0 && this.redstoneCount == lllllllllllIlllIIlIllllIIlIIllII.redstoneCount && this.redstoneMaxHeight == lllllllllllIlllIIlIllllIIlIIllII.redstoneMaxHeight && this.redstoneMinHeight == lllllllllllIlllIIlIllllIIlIIllII.redstoneMinHeight && this.redstoneSize == lllllllllllIlllIIlIllllIIlIIllII.redstoneSize && this.riverSize == lllllllllllIlllIIlIllllIIlIIllII.riverSize && this.seaLevel == lllllllllllIlllIIlIllllIIlIIllII.seaLevel && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.stretchY, this.stretchY) == 0 && Float.compare(lllllllllllIlllIIlIllllIIlIIllII.upperLimitScale, this.upperLimitScale) == 0 && this.useCaves == lllllllllllIlllIIlIllllIIlIIllII.useCaves && this.useDungeons == lllllllllllIlllIIlIllllIIlIIllII.useDungeons && this.useLavaLakes == lllllllllllIlllIIlIllllIIlIIllII.useLavaLakes && this.useLavaOceans == lllllllllllIlllIIlIllllIIlIIllII.useLavaOceans && this.useMineShafts == lllllllllllIlllIIlIllllIIlIIllII.useMineShafts && this.useRavines == lllllllllllIlllIIlIllllIIlIIllII.useRavines && this.useStrongholds == lllllllllllIlllIIlIllllIIlIIllII.useStrongholds && this.useTemples == lllllllllllIlllIIlIllllIIlIIllII.useTemples && this.useMonuments == lllllllllllIlllIIlIllllIIlIIllII.useMonuments && this.field_191076_A == lllllllllllIlllIIlIllllIIlIIllII.field_191076_A && this.useVillages == lllllllllllIlllIIlIllllIIlIIllII.useVillages && this.useWaterLakes == lllllllllllIlllIIlIllllIIlIIllII.useWaterLakes && this.waterLakeChance == lllllllllllIlllIIlIllllIIlIIllII.waterLakeChance;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            int lllllllllllIlllIIlIllllIIlIIIlIl = (this.coordinateScale == 0.0f) ? 0 : Float.floatToIntBits(this.coordinateScale);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.heightScale == 0.0f) ? 0 : Float.floatToIntBits(this.heightScale));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.upperLimitScale == 0.0f) ? 0 : Float.floatToIntBits(this.upperLimitScale));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.lowerLimitScale == 0.0f) ? 0 : Float.floatToIntBits(this.lowerLimitScale));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.depthNoiseScaleX == 0.0f) ? 0 : Float.floatToIntBits(this.depthNoiseScaleX));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.depthNoiseScaleZ == 0.0f) ? 0 : Float.floatToIntBits(this.depthNoiseScaleZ));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.depthNoiseScaleExponent == 0.0f) ? 0 : Float.floatToIntBits(this.depthNoiseScaleExponent));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.mainNoiseScaleX == 0.0f) ? 0 : Float.floatToIntBits(this.mainNoiseScaleX));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.mainNoiseScaleY == 0.0f) ? 0 : Float.floatToIntBits(this.mainNoiseScaleY));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.mainNoiseScaleZ == 0.0f) ? 0 : Float.floatToIntBits(this.mainNoiseScaleZ));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.baseSize == 0.0f) ? 0 : Float.floatToIntBits(this.baseSize));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.stretchY == 0.0f) ? 0 : Float.floatToIntBits(this.stretchY));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.biomeDepthWeight == 0.0f) ? 0 : Float.floatToIntBits(this.biomeDepthWeight));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.biomeDepthOffset == 0.0f) ? 0 : Float.floatToIntBits(this.biomeDepthOffset));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.biomeScaleWeight == 0.0f) ? 0 : Float.floatToIntBits(this.biomeScaleWeight));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + ((this.biomeScaleOffset == 0.0f) ? 0 : Float.floatToIntBits(this.biomeScaleOffset));
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.seaLevel;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useCaves ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useDungeons ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.dungeonChance;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useStrongholds ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useVillages ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useMineShafts ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useTemples ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useMonuments ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.field_191076_A ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useRavines ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useWaterLakes ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.waterLakeChance;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useLavaLakes ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.lavaLakeChance;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + (this.useLavaOceans ? 1 : 0);
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.fixedBiome;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.biomeSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.riverSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.dirtSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.dirtCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.dirtMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.dirtMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.gravelSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.gravelCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.gravelMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.gravelMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.graniteSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.graniteCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.graniteMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.graniteMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.dioriteSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.dioriteCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.dioriteMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.dioriteMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.andesiteSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.andesiteCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.andesiteMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.andesiteMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.coalSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.coalCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.coalMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.coalMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.ironSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.ironCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.ironMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.ironMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.goldSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.goldCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.goldMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.goldMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.redstoneSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.redstoneCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.redstoneMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.redstoneMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.diamondSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.diamondCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.diamondMinHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.diamondMaxHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.lapisSize;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.lapisCount;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.lapisCenterHeight;
            lllllllllllIlllIIlIllllIIlIIIlIl = 31 * lllllllllllIlllIIlIllllIIlIIIlIl + this.lapisSpread;
            return lllllllllllIlllIIlIllllIIlIIIlIl;
        }
        
        public void setDefaults() {
            this.coordinateScale = 684.412f;
            this.heightScale = 684.412f;
            this.upperLimitScale = 512.0f;
            this.lowerLimitScale = 512.0f;
            this.depthNoiseScaleX = 200.0f;
            this.depthNoiseScaleZ = 200.0f;
            this.depthNoiseScaleExponent = 0.5f;
            this.mainNoiseScaleX = 80.0f;
            this.mainNoiseScaleY = 160.0f;
            this.mainNoiseScaleZ = 80.0f;
            this.baseSize = 8.5f;
            this.stretchY = 12.0f;
            this.biomeDepthWeight = 1.0f;
            this.biomeDepthOffset = 0.0f;
            this.biomeScaleWeight = 1.0f;
            this.biomeScaleOffset = 0.0f;
            this.seaLevel = 63;
            this.useCaves = true;
            this.useDungeons = true;
            this.dungeonChance = 8;
            this.useStrongholds = true;
            this.useVillages = true;
            this.useMineShafts = true;
            this.useTemples = true;
            this.useMonuments = true;
            this.field_191076_A = true;
            this.useRavines = true;
            this.useWaterLakes = true;
            this.waterLakeChance = 4;
            this.useLavaLakes = true;
            this.lavaLakeChance = 80;
            this.useLavaOceans = false;
            this.fixedBiome = -1;
            this.biomeSize = 4;
            this.riverSize = 4;
            this.dirtSize = 33;
            this.dirtCount = 10;
            this.dirtMinHeight = 0;
            this.dirtMaxHeight = 256;
            this.gravelSize = 33;
            this.gravelCount = 8;
            this.gravelMinHeight = 0;
            this.gravelMaxHeight = 256;
            this.graniteSize = 33;
            this.graniteCount = 10;
            this.graniteMinHeight = 0;
            this.graniteMaxHeight = 80;
            this.dioriteSize = 33;
            this.dioriteCount = 10;
            this.dioriteMinHeight = 0;
            this.dioriteMaxHeight = 80;
            this.andesiteSize = 33;
            this.andesiteCount = 10;
            this.andesiteMinHeight = 0;
            this.andesiteMaxHeight = 80;
            this.coalSize = 17;
            this.coalCount = 20;
            this.coalMinHeight = 0;
            this.coalMaxHeight = 128;
            this.ironSize = 9;
            this.ironCount = 20;
            this.ironMinHeight = 0;
            this.ironMaxHeight = 64;
            this.goldSize = 9;
            this.goldCount = 2;
            this.goldMinHeight = 0;
            this.goldMaxHeight = 32;
            this.redstoneSize = 8;
            this.redstoneCount = 8;
            this.redstoneMinHeight = 0;
            this.redstoneMaxHeight = 16;
            this.diamondSize = 8;
            this.diamondCount = 1;
            this.diamondMinHeight = 0;
            this.diamondMaxHeight = 16;
            this.lapisSize = 7;
            this.lapisCount = 1;
            this.lapisCenterHeight = 16;
            this.lapisSpread = 16;
        }
        
        @Override
        public String toString() {
            return Factory.JSON_ADAPTER.toJson((Object)this);
        }
    }
}
