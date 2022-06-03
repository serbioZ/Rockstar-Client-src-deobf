// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.util.math.MathHelper;
import java.util.Map;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityWitch;
import com.google.common.collect.Lists;
import java.util.Random;
import java.util.Arrays;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import java.util.List;

public class MapGenScatteredFeature extends MapGenStructure
{
    private final /* synthetic */ int minDistanceBetweenScatteredFeatures;
    private static final /* synthetic */ List<Biome> BIOMELIST;
    private final /* synthetic */ List<Biome.SpawnListEntry> scatteredFeatureSpawnList;
    private /* synthetic */ int maxDistanceBetweenScatteredFeatures;
    
    @Override
    public BlockPos getClosestStrongholdPos(final World llIIIlIlIlIlIl, final BlockPos llIIIlIlIlIIII, final boolean llIIIlIlIlIIll) {
        this.worldObj = llIIIlIlIlIlIl;
        return MapGenStructure.func_191069_a(llIIIlIlIlIlIl, this, llIIIlIlIlIIII, this.maxDistanceBetweenScatteredFeatures, 8, 14357617, false, 100, llIIIlIlIlIIll);
    }
    
    @Override
    public String getStructureName() {
        return "Temple";
    }
    
    public boolean isSwampHut(final BlockPos llIIIlIIllllII) {
        final StructureStart llIIIlIIllllll = this.getStructureAt(llIIIlIIllllII);
        if (llIIIlIIllllll != null && llIIIlIIllllll instanceof Start && !llIIIlIIllllll.components.isEmpty()) {
            final StructureComponent llIIIlIIlllllI = llIIIlIIllllll.components.get(0);
            return llIIIlIIlllllI instanceof ComponentScatteredFeaturePieces.SwampHut;
        }
        return false;
    }
    
    static {
        BIOMELIST = Arrays.asList(Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.JUNGLE, Biomes.JUNGLE_HILLS, Biomes.SWAMPLAND, Biomes.ICE_PLAINS, Biomes.COLD_TAIGA);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int llIIIlIllIIlII, int llIIIlIllIIIll) {
        final int llIIIlIllIllII = llIIIlIllIIlII;
        final int llIIIlIllIlIll = llIIIlIllIIIll;
        if (llIIIlIllIIlII < 0) {
            llIIIlIllIIlII -= this.maxDistanceBetweenScatteredFeatures - 1;
        }
        if (llIIIlIllIIIll < 0) {
            llIIIlIllIIIll -= this.maxDistanceBetweenScatteredFeatures - 1;
        }
        int llIIIlIllIlIlI = llIIIlIllIIlII / this.maxDistanceBetweenScatteredFeatures;
        int llIIIlIllIlIIl = llIIIlIllIIIll / this.maxDistanceBetweenScatteredFeatures;
        final Random llIIIlIllIlIII = this.worldObj.setRandomSeed(llIIIlIllIlIlI, llIIIlIllIlIIl, 14357617);
        llIIIlIllIlIlI *= this.maxDistanceBetweenScatteredFeatures;
        llIIIlIllIlIIl *= this.maxDistanceBetweenScatteredFeatures;
        llIIIlIllIlIlI += llIIIlIllIlIII.nextInt(this.maxDistanceBetweenScatteredFeatures - 8);
        llIIIlIllIlIIl += llIIIlIllIlIII.nextInt(this.maxDistanceBetweenScatteredFeatures - 8);
        if (llIIIlIllIllII == llIIIlIllIlIlI && llIIIlIllIlIll == llIIIlIllIlIIl) {
            final Biome llIIIlIllIIlll = this.worldObj.getBiomeProvider().getBiome(new BlockPos(llIIIlIllIllII * 16 + 8, 0, llIIIlIllIlIll * 16 + 8));
            if (llIIIlIllIIlll == null) {
                return false;
            }
            for (final Biome llIIIlIllIIllI : MapGenScatteredFeature.BIOMELIST) {
                if (llIIIlIllIIlll == llIIIlIllIIllI) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public List<Biome.SpawnListEntry> getScatteredFeatureSpawnList() {
        return this.scatteredFeatureSpawnList;
    }
    
    public MapGenScatteredFeature() {
        this.scatteredFeatureSpawnList = (List<Biome.SpawnListEntry>)Lists.newArrayList();
        this.maxDistanceBetweenScatteredFeatures = 32;
        this.minDistanceBetweenScatteredFeatures = 8;
        this.scatteredFeatureSpawnList.add(new Biome.SpawnListEntry(EntityWitch.class, 1, 1, 1));
    }
    
    @Override
    protected StructureStart getStructureStart(final int llIIIlIlIIIlll, final int llIIIlIlIIIllI) {
        return new Start(this.worldObj, this.rand, llIIIlIlIIIlll, llIIIlIlIIIllI);
    }
    
    public MapGenScatteredFeature(final Map<String, String> llIIIllIIIIIIl) {
        this();
        for (final Map.Entry<String, String> llIIIllIIIIIII : llIIIllIIIIIIl.entrySet()) {
            if (llIIIllIIIIIII.getKey().equals("distance")) {
                this.maxDistanceBetweenScatteredFeatures = MathHelper.getInt(llIIIllIIIIIII.getValue(), this.maxDistanceBetweenScatteredFeatures, 9);
            }
        }
    }
    
    public static class Start extends StructureStart
    {
        public Start(final World lllllllllllIIlIIlIIIlIllIllIIIlI, final Random lllllllllllIIlIIlIIIlIllIlIlllII, final int lllllllllllIIlIIlIIIlIllIllIIIII, final int lllllllllllIIlIIlIIIlIllIlIllIlI) {
            this(lllllllllllIIlIIlIIIlIllIllIIIlI, lllllllllllIIlIIlIIIlIllIlIlllII, lllllllllllIIlIIlIIIlIllIllIIIII, lllllllllllIIlIIlIIIlIllIlIllIlI, lllllllllllIIlIIlIIIlIllIllIIIlI.getBiome(new BlockPos(lllllllllllIIlIIlIIIlIllIllIIIII * 16 + 8, 0, lllllllllllIIlIIlIIIlIllIlIllIlI * 16 + 8)));
        }
        
        public Start() {
        }
        
        public Start(final World lllllllllllIIlIIlIIIlIllIlIlIIlI, final Random lllllllllllIIlIIlIIIlIllIlIIlIII, final int lllllllllllIIlIIlIIIlIllIlIIIlll, final int lllllllllllIIlIIlIIIlIllIlIIllll, final Biome lllllllllllIIlIIlIIIlIllIlIIIlIl) {
            super(lllllllllllIIlIIlIIIlIllIlIIIlll, lllllllllllIIlIIlIIIlIllIlIIllll);
            if (lllllllllllIIlIIlIIIlIllIlIIIlIl != Biomes.JUNGLE && lllllllllllIIlIIlIIIlIllIlIIIlIl != Biomes.JUNGLE_HILLS) {
                if (lllllllllllIIlIIlIIIlIllIlIIIlIl == Biomes.SWAMPLAND) {
                    final ComponentScatteredFeaturePieces.SwampHut lllllllllllIIlIIlIIIlIllIlIIllIl = new ComponentScatteredFeaturePieces.SwampHut(lllllllllllIIlIIlIIIlIllIlIIlIII, lllllllllllIIlIIlIIIlIllIlIIIlll * 16, lllllllllllIIlIIlIIIlIllIlIIllll * 16);
                    this.components.add(lllllllllllIIlIIlIIIlIllIlIIllIl);
                }
                else if (lllllllllllIIlIIlIIIlIllIlIIIlIl != Biomes.DESERT && lllllllllllIIlIIlIIIlIllIlIIIlIl != Biomes.DESERT_HILLS) {
                    if (lllllllllllIIlIIlIIIlIllIlIIIlIl == Biomes.ICE_PLAINS || lllllllllllIIlIIlIIIlIllIlIIIlIl == Biomes.COLD_TAIGA) {
                        final ComponentScatteredFeaturePieces.Igloo lllllllllllIIlIIlIIIlIllIlIIllII = new ComponentScatteredFeaturePieces.Igloo(lllllllllllIIlIIlIIIlIllIlIIlIII, lllllllllllIIlIIlIIIlIllIlIIIlll * 16, lllllllllllIIlIIlIIIlIllIlIIllll * 16);
                        this.components.add(lllllllllllIIlIIlIIIlIllIlIIllII);
                    }
                }
                else {
                    final ComponentScatteredFeaturePieces.DesertPyramid lllllllllllIIlIIlIIIlIllIlIIlIll = new ComponentScatteredFeaturePieces.DesertPyramid(lllllllllllIIlIIlIIIlIllIlIIlIII, lllllllllllIIlIIlIIIlIllIlIIIlll * 16, lllllllllllIIlIIlIIIlIllIlIIllll * 16);
                    this.components.add(lllllllllllIIlIIlIIIlIllIlIIlIll);
                }
            }
            else {
                final ComponentScatteredFeaturePieces.JunglePyramid lllllllllllIIlIIlIIIlIllIlIIlIlI = new ComponentScatteredFeaturePieces.JunglePyramid(lllllllllllIIlIIlIIIlIllIlIIlIII, lllllllllllIIlIIlIIIlIllIlIIIlll * 16, lllllllllllIIlIIlIIIlIllIlIIllll * 16);
                this.components.add(lllllllllllIIlIIlIIIlIllIlIIlIlI);
            }
            this.updateBoundingBox();
        }
    }
}
