// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import java.util.Random;
import javax.annotation.Nullable;
import com.google.common.collect.Lists;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldType;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReport;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import java.util.List;
import net.minecraft.world.gen.layer.GenLayer;

public class BiomeProvider
{
    private /* synthetic */ GenLayer genBiomes;
    private final /* synthetic */ List<Biome> biomesToSpawnIn;
    private final /* synthetic */ BiomeCache biomeCache;
    private /* synthetic */ ChunkGeneratorSettings field_190945_a;
    private /* synthetic */ GenLayer biomeIndexLayer;
    
    public BiomeProvider(final WorldInfo lllllllllllllllIIIlIlIIlIIlIlIIl) {
        this(lllllllllllllllIIIlIlIIlIIlIlIIl.getSeed(), lllllllllllllllIIIlIlIIlIIlIlIIl.getTerrainType(), lllllllllllllllIIIlIlIIlIIlIlIIl.getGeneratorOptions());
    }
    
    public boolean areBiomesViable(final int lllllllllllllllIIIlIlIIIlIlIIIll, final int lllllllllllllllIIIlIlIIIlIllIIll, final int lllllllllllllllIIIlIlIIIlIlIIIIl, final List<Biome> lllllllllllllllIIIlIlIIIlIllIIIl) {
        IntCache.resetIntCache();
        final int lllllllllllllllIIIlIlIIIlIllIIII = lllllllllllllllIIIlIlIIIlIlIIIll - lllllllllllllllIIIlIlIIIlIlIIIIl >> 2;
        final int lllllllllllllllIIIlIlIIIlIlIllll = lllllllllllllllIIIlIlIIIlIllIIll - lllllllllllllllIIIlIlIIIlIlIIIIl >> 2;
        final int lllllllllllllllIIIlIlIIIlIlIlllI = lllllllllllllllIIIlIlIIIlIlIIIll + lllllllllllllllIIIlIlIIIlIlIIIIl >> 2;
        final int lllllllllllllllIIIlIlIIIlIlIllIl = lllllllllllllllIIIlIlIIIlIllIIll + lllllllllllllllIIIlIlIIIlIlIIIIl >> 2;
        final int lllllllllllllllIIIlIlIIIlIlIllII = lllllllllllllllIIIlIlIIIlIlIlllI - lllllllllllllllIIIlIlIIIlIllIIII + 1;
        final int lllllllllllllllIIIlIlIIIlIlIlIll = lllllllllllllllIIIlIlIIIlIlIllIl - lllllllllllllllIIIlIlIIIlIlIllll + 1;
        final int[] lllllllllllllllIIIlIlIIIlIlIlIlI = this.genBiomes.getInts(lllllllllllllllIIIlIlIIIlIllIIII, lllllllllllllllIIIlIlIIIlIlIllll, lllllllllllllllIIIlIlIIIlIlIllII, lllllllllllllllIIIlIlIIIlIlIlIll);
        try {
            for (int lllllllllllllllIIIlIlIIIlIlIlIIl = 0; lllllllllllllllIIIlIlIIIlIlIlIIl < lllllllllllllllIIIlIlIIIlIlIllII * lllllllllllllllIIIlIlIIIlIlIlIll; ++lllllllllllllllIIIlIlIIIlIlIlIIl) {
                final Biome lllllllllllllllIIIlIlIIIlIlIlIII = Biome.getBiome(lllllllllllllllIIIlIlIIIlIlIlIlI[lllllllllllllllIIIlIlIIIlIlIlIIl]);
                if (!lllllllllllllllIIIlIlIIIlIllIIIl.contains(lllllllllllllllIIIlIlIIIlIlIlIII)) {
                    return false;
                }
            }
            return true;
        }
        catch (Throwable lllllllllllllllIIIlIlIIIlIlIIlll) {
            final CrashReport lllllllllllllllIIIlIlIIIlIlIIllI = CrashReport.makeCrashReport(lllllllllllllllIIIlIlIIIlIlIIlll, "Invalid Biome id");
            final CrashReportCategory lllllllllllllllIIIlIlIIIlIlIIlIl = lllllllllllllllIIIlIlIIIlIlIIllI.makeCategory("Layer");
            lllllllllllllllIIIlIlIIIlIlIIlIl.addCrashSection("Layer", this.genBiomes.toString());
            lllllllllllllllIIIlIlIIIlIlIIlIl.addCrashSection("x", lllllllllllllllIIIlIlIIIlIlIIIll);
            lllllllllllllllIIIlIlIIIlIlIIlIl.addCrashSection("z", lllllllllllllllIIIlIlIIIlIllIIll);
            lllllllllllllllIIIlIlIIIlIlIIlIl.addCrashSection("radius", lllllllllllllllIIIlIlIIIlIlIIIIl);
            lllllllllllllllIIIlIlIIIlIlIIlIl.addCrashSection("allowed", lllllllllllllllIIIlIlIIIlIllIIIl);
            throw new ReportedException(lllllllllllllllIIIlIlIIIlIlIIllI);
        }
    }
    
    public Biome func_190943_d() {
        return (this.field_190945_a != null && this.field_190945_a.fixedBiome >= 0) ? Biome.getBiomeForId(this.field_190945_a.fixedBiome) : null;
    }
    
    private BiomeProvider(final long lllllllllllllllIIIlIlIIlIIllIIlI, final WorldType lllllllllllllllIIIlIlIIlIIllIllI, final String lllllllllllllllIIIlIlIIlIIllIIII) {
        this();
        if (lllllllllllllllIIIlIlIIlIIllIllI == WorldType.CUSTOMIZED && !lllllllllllllllIIIlIlIIlIIllIIII.isEmpty()) {
            this.field_190945_a = ChunkGeneratorSettings.Factory.jsonToFactory(lllllllllllllllIIIlIlIIlIIllIIII).build();
        }
        final GenLayer[] lllllllllllllllIIIlIlIIlIIllIlII = GenLayer.initializeAllBiomeGenerators(lllllllllllllllIIIlIlIIlIIllIIlI, lllllllllllllllIIIlIlIIlIIllIllI, this.field_190945_a);
        this.genBiomes = lllllllllllllllIIIlIlIIlIIllIlII[0];
        this.biomeIndexLayer = lllllllllllllllIIIlIlIIlIIllIlII[1];
    }
    
    public Biome getBiome(final BlockPos lllllllllllllllIIIlIlIIlIIIllIll, final Biome lllllllllllllllIIIlIlIIlIIIlIlll) {
        return this.biomeCache.getBiome(lllllllllllllllIIIlIlIIlIIIllIll.getX(), lllllllllllllllIIIlIlIIlIIIllIll.getZ(), lllllllllllllllIIIlIlIIlIIIlIlll);
    }
    
    protected BiomeProvider() {
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = (List<Biome>)Lists.newArrayList((Object[])new Biome[] { Biomes.FOREST, Biomes.PLAINS, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.FOREST_HILLS, Biomes.JUNGLE, Biomes.JUNGLE_HILLS });
    }
    
    public float getTemperatureAtHeight(final float lllllllllllllllIIIlIlIIlIIIlIlII, final int lllllllllllllllIIIlIlIIlIIIlIIll) {
        return lllllllllllllllIIIlIlIIlIIIlIlII;
    }
    
    public Biome[] getBiomesForGeneration(Biome[] lllllllllllllllIIIlIlIIIlllllIll, final int lllllllllllllllIIIlIlIIlIIIIIlIl, final int lllllllllllllllIIIlIlIIlIIIIIlII, final int lllllllllllllllIIIlIlIIIlllllIII, final int lllllllllllllllIIIlIlIIIllllIlll) {
        IntCache.resetIntCache();
        if (lllllllllllllllIIIlIlIIIlllllIll == null || lllllllllllllllIIIlIlIIIlllllIll.length < lllllllllllllllIIIlIlIIIlllllIII * lllllllllllllllIIIlIlIIIllllIlll) {
            lllllllllllllllIIIlIlIIIlllllIll = new Biome[lllllllllllllllIIIlIlIIIlllllIII * lllllllllllllllIIIlIlIIIllllIlll];
        }
        final int[] lllllllllllllllIIIlIlIIlIIIIIIIl = this.genBiomes.getInts(lllllllllllllllIIIlIlIIlIIIIIlIl, lllllllllllllllIIIlIlIIlIIIIIlII, lllllllllllllllIIIlIlIIIlllllIII, lllllllllllllllIIIlIlIIIllllIlll);
        try {
            for (int lllllllllllllllIIIlIlIIlIIIIIIII = 0; lllllllllllllllIIIlIlIIlIIIIIIII < lllllllllllllllIIIlIlIIIlllllIII * lllllllllllllllIIIlIlIIIllllIlll; ++lllllllllllllllIIIlIlIIlIIIIIIII) {
                lllllllllllllllIIIlIlIIIlllllIll[lllllllllllllllIIIlIlIIlIIIIIIII] = Biome.getBiome(lllllllllllllllIIIlIlIIlIIIIIIIl[lllllllllllllllIIIlIlIIlIIIIIIII], Biomes.DEFAULT);
            }
            return (Biome[])lllllllllllllllIIIlIlIIIlllllIll;
        }
        catch (Throwable lllllllllllllllIIIlIlIIIllllllll) {
            final CrashReport lllllllllllllllIIIlIlIIIlllllllI = CrashReport.makeCrashReport(lllllllllllllllIIIlIlIIIllllllll, "Invalid Biome id");
            final CrashReportCategory lllllllllllllllIIIlIlIIIllllllIl = lllllllllllllllIIIlIlIIIlllllllI.makeCategory("RawBiomeBlock");
            lllllllllllllllIIIlIlIIIllllllIl.addCrashSection("biomes[] size", lllllllllllllllIIIlIlIIIlllllIll.length);
            lllllllllllllllIIIlIlIIIllllllIl.addCrashSection("x", lllllllllllllllIIIlIlIIlIIIIIlIl);
            lllllllllllllllIIIlIlIIIllllllIl.addCrashSection("z", lllllllllllllllIIIlIlIIlIIIIIlII);
            lllllllllllllllIIIlIlIIIllllllIl.addCrashSection("w", lllllllllllllllIIIlIlIIIlllllIII);
            lllllllllllllllIIIlIlIIIllllllIl.addCrashSection("h", lllllllllllllllIIIlIlIIIllllIlll);
            throw new ReportedException(lllllllllllllllIIIlIlIIIlllllllI);
        }
    }
    
    public List<Biome> getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }
    
    public boolean func_190944_c() {
        return this.field_190945_a != null && this.field_190945_a.fixedBiome >= 0;
    }
    
    public Biome getBiome(final BlockPos lllllllllllllllIIIlIlIIlIIlIIIII) {
        return this.getBiome(lllllllllllllllIIIlIlIIlIIlIIIII, null);
    }
    
    public Biome[] getBiomes(@Nullable final Biome[] lllllllllllllllIIIlIlIIIlllIlIll, final int lllllllllllllllIIIlIlIIIlllIlIlI, final int lllllllllllllllIIIlIlIIIlllIlIIl, final int lllllllllllllllIIIlIlIIIlllIIIlI, final int lllllllllllllllIIIlIlIIIlllIIIIl) {
        return this.getBiomes(lllllllllllllllIIIlIlIIIlllIlIll, lllllllllllllllIIIlIlIIIlllIlIlI, lllllllllllllllIIIlIlIIIlllIlIIl, lllllllllllllllIIIlIlIIIlllIIIlI, lllllllllllllllIIIlIlIIIlllIIIIl, true);
    }
    
    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
    
    @Nullable
    public BlockPos findBiomePosition(final int lllllllllllllllIIIlIlIIIIllIlllI, final int lllllllllllllllIIIlIlIIIlIIIIIII, final int lllllllllllllllIIIlIlIIIIllIllII, final List<Biome> lllllllllllllllIIIlIlIIIIllllllI, final Random lllllllllllllllIIIlIlIIIIllIlIlI) {
        IntCache.resetIntCache();
        final int lllllllllllllllIIIlIlIIIIlllllII = lllllllllllllllIIIlIlIIIIllIlllI - lllllllllllllllIIIlIlIIIIllIllII >> 2;
        final int lllllllllllllllIIIlIlIIIIllllIll = lllllllllllllllIIIlIlIIIlIIIIIII - lllllllllllllllIIIlIlIIIIllIllII >> 2;
        final int lllllllllllllllIIIlIlIIIIllllIlI = lllllllllllllllIIIlIlIIIIllIlllI + lllllllllllllllIIIlIlIIIIllIllII >> 2;
        final int lllllllllllllllIIIlIlIIIIllllIIl = lllllllllllllllIIIlIlIIIlIIIIIII + lllllllllllllllIIIlIlIIIIllIllII >> 2;
        final int lllllllllllllllIIIlIlIIIIllllIII = lllllllllllllllIIIlIlIIIIllllIlI - lllllllllllllllIIIlIlIIIIlllllII + 1;
        final int lllllllllllllllIIIlIlIIIIlllIlll = lllllllllllllllIIIlIlIIIIllllIIl - lllllllllllllllIIIlIlIIIIllllIll + 1;
        final int[] lllllllllllllllIIIlIlIIIIlllIllI = this.genBiomes.getInts(lllllllllllllllIIIlIlIIIIlllllII, lllllllllllllllIIIlIlIIIIllllIll, lllllllllllllllIIIlIlIIIIllllIII, lllllllllllllllIIIlIlIIIIlllIlll);
        BlockPos lllllllllllllllIIIlIlIIIIlllIlIl = null;
        int lllllllllllllllIIIlIlIIIIlllIlII = 0;
        for (int lllllllllllllllIIIlIlIIIIlllIIll = 0; lllllllllllllllIIIlIlIIIIlllIIll < lllllllllllllllIIIlIlIIIIllllIII * lllllllllllllllIIIlIlIIIIlllIlll; ++lllllllllllllllIIIlIlIIIIlllIIll) {
            final int lllllllllllllllIIIlIlIIIIlllIIlI = lllllllllllllllIIIlIlIIIIlllllII + lllllllllllllllIIIlIlIIIIlllIIll % lllllllllllllllIIIlIlIIIIllllIII << 2;
            final int lllllllllllllllIIIlIlIIIIlllIIIl = lllllllllllllllIIIlIlIIIIllllIll + lllllllllllllllIIIlIlIIIIlllIIll / lllllllllllllllIIIlIlIIIIllllIII << 2;
            final Biome lllllllllllllllIIIlIlIIIIlllIIII = Biome.getBiome(lllllllllllllllIIIlIlIIIIlllIllI[lllllllllllllllIIIlIlIIIIlllIIll]);
            if (lllllllllllllllIIIlIlIIIIllllllI.contains(lllllllllllllllIIIlIlIIIIlllIIII) && (lllllllllllllllIIIlIlIIIIlllIlIl == null || lllllllllllllllIIIlIlIIIIllIlIlI.nextInt(lllllllllllllllIIIlIlIIIIlllIlII + 1) == 0)) {
                lllllllllllllllIIIlIlIIIIlllIlIl = new BlockPos(lllllllllllllllIIIlIlIIIIlllIIlI, 0, lllllllllllllllIIIlIlIIIIlllIIIl);
                ++lllllllllllllllIIIlIlIIIIlllIlII;
            }
        }
        return lllllllllllllllIIIlIlIIIIlllIlIl;
    }
    
    public Biome[] getBiomes(@Nullable Biome[] lllllllllllllllIIIlIlIIIllIIllII, final int lllllllllllllllIIIlIlIIIllIlIlIl, final int lllllllllllllllIIIlIlIIIllIlIlII, final int lllllllllllllllIIIlIlIIIllIlIIll, final int lllllllllllllllIIIlIlIIIllIIlIII, final boolean lllllllllllllllIIIlIlIIIllIlIIIl) {
        IntCache.resetIntCache();
        if (lllllllllllllllIIIlIlIIIllIIllII == null || lllllllllllllllIIIlIlIIIllIIllII.length < lllllllllllllllIIIlIlIIIllIlIIll * lllllllllllllllIIIlIlIIIllIIlIII) {
            lllllllllllllllIIIlIlIIIllIIllII = new Biome[lllllllllllllllIIIlIlIIIllIlIIll * lllllllllllllllIIIlIlIIIllIIlIII];
        }
        if (lllllllllllllllIIIlIlIIIllIlIIIl && lllllllllllllllIIIlIlIIIllIlIIll == 16 && lllllllllllllllIIIlIlIIIllIIlIII == 16 && (lllllllllllllllIIIlIlIIIllIlIlIl & 0xF) == 0x0 && (lllllllllllllllIIIlIlIIIllIlIlII & 0xF) == 0x0) {
            final Biome[] lllllllllllllllIIIlIlIIIllIlIIII = this.biomeCache.getCachedBiomes(lllllllllllllllIIIlIlIIIllIlIlIl, lllllllllllllllIIIlIlIIIllIlIlII);
            System.arraycopy(lllllllllllllllIIIlIlIIIllIlIIII, 0, lllllllllllllllIIIlIlIIIllIIllII, 0, lllllllllllllllIIIlIlIIIllIlIIll * lllllllllllllllIIIlIlIIIllIIlIII);
            return (Biome[])lllllllllllllllIIIlIlIIIllIIllII;
        }
        final int[] lllllllllllllllIIIlIlIIIllIIllll = this.biomeIndexLayer.getInts(lllllllllllllllIIIlIlIIIllIlIlIl, lllllllllllllllIIIlIlIIIllIlIlII, lllllllllllllllIIIlIlIIIllIlIIll, lllllllllllllllIIIlIlIIIllIIlIII);
        for (int lllllllllllllllIIIlIlIIIllIIlllI = 0; lllllllllllllllIIIlIlIIIllIIlllI < lllllllllllllllIIIlIlIIIllIlIIll * lllllllllllllllIIIlIlIIIllIIlIII; ++lllllllllllllllIIIlIlIIIllIIlllI) {
            lllllllllllllllIIIlIlIIIllIIllII[lllllllllllllllIIIlIlIIIllIIlllI] = Biome.getBiome(lllllllllllllllIIIlIlIIIllIIllll[lllllllllllllllIIIlIlIIIllIIlllI], Biomes.DEFAULT);
        }
        return (Biome[])lllllllllllllllIIIlIlIIIllIIllII;
    }
}
