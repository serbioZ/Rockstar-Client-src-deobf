// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import com.google.common.collect.Sets;
import net.minecraft.util.EnumFacing;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.ChunkPos;
import java.util.Set;
import net.minecraft.util.math.MathHelper;
import java.util.Map;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityGuardian;
import com.google.common.collect.Lists;
import java.util.Arrays;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.biome.Biome;
import java.util.List;

public class StructureOceanMonument extends MapGenStructure
{
    public static final /* synthetic */ List<Biome> WATER_BIOMES;
    private /* synthetic */ int spacing;
    public static final /* synthetic */ List<Biome> SPAWN_BIOMES;
    private static final /* synthetic */ List<Biome.SpawnListEntry> MONUMENT_ENEMIES;
    private /* synthetic */ int separation;
    
    @Override
    protected boolean canSpawnStructureAtCoords(int lllllllllllllIIllIIllIlIIIllIlII, int lllllllllllllIIllIIllIlIIIllIIll) {
        final int lllllllllllllIIllIIllIlIIIlllIll = lllllllllllllIIllIIllIlIIIllIlII;
        final int lllllllllllllIIllIIllIlIIIlllIlI = lllllllllllllIIllIIllIlIIIllIIll;
        if (lllllllllllllIIllIIllIlIIIllIlII < 0) {
            lllllllllllllIIllIIllIlIIIllIlII -= this.spacing - 1;
        }
        if (lllllllllllllIIllIIllIlIIIllIIll < 0) {
            lllllllllllllIIllIIllIlIIIllIIll -= this.spacing - 1;
        }
        int lllllllllllllIIllIIllIlIIIlllIIl = lllllllllllllIIllIIllIlIIIllIlII / this.spacing;
        int lllllllllllllIIllIIllIlIIIlllIII = lllllllllllllIIllIIllIlIIIllIIll / this.spacing;
        final Random lllllllllllllIIllIIllIlIIIllIlll = this.worldObj.setRandomSeed(lllllllllllllIIllIIllIlIIIlllIIl, lllllllllllllIIllIIllIlIIIlllIII, 10387313);
        lllllllllllllIIllIIllIlIIIlllIIl *= this.spacing;
        lllllllllllllIIllIIllIlIIIlllIII *= this.spacing;
        lllllllllllllIIllIIllIlIIIlllIIl += (lllllllllllllIIllIIllIlIIIllIlll.nextInt(this.spacing - this.separation) + lllllllllllllIIllIIllIlIIIllIlll.nextInt(this.spacing - this.separation)) / 2;
        lllllllllllllIIllIIllIlIIIlllIII += (lllllllllllllIIllIIllIlIIIllIlll.nextInt(this.spacing - this.separation) + lllllllllllllIIllIIllIlIIIllIlll.nextInt(this.spacing - this.separation)) / 2;
        if (lllllllllllllIIllIIllIlIIIlllIll == lllllllllllllIIllIIllIlIIIlllIIl && lllllllllllllIIllIIllIlIIIlllIlI == lllllllllllllIIllIIllIlIIIlllIII) {
            if (!this.worldObj.getBiomeProvider().areBiomesViable(lllllllllllllIIllIIllIlIIIlllIll * 16 + 8, lllllllllllllIIllIIllIlIIIlllIlI * 16 + 8, 16, StructureOceanMonument.SPAWN_BIOMES)) {
                return false;
            }
            final boolean lllllllllllllIIllIIllIlIIIllIllI = this.worldObj.getBiomeProvider().areBiomesViable(lllllllllllllIIllIIllIlIIIlllIll * 16 + 8, lllllllllllllIIllIIllIlIIIlllIlI * 16 + 8, 29, StructureOceanMonument.WATER_BIOMES);
            if (lllllllllllllIIllIIllIlIIIllIllI) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lllllllllllllIIllIIllIlIIIlIIlll, final BlockPos lllllllllllllIIllIIllIlIIIlIIllI, final boolean lllllllllllllIIllIIllIlIIIlIIIIl) {
        this.worldObj = lllllllllllllIIllIIllIlIIIlIIlll;
        return MapGenStructure.func_191069_a(lllllllllllllIIllIIllIlIIIlIIlll, this, lllllllllllllIIllIIllIlIIIlIIllI, this.spacing, this.separation, 10387313, true, 100, lllllllllllllIIllIIllIlIIIlIIIIl);
    }
    
    public StructureOceanMonument() {
        this.spacing = 32;
        this.separation = 5;
    }
    
    public List<Biome.SpawnListEntry> getScatteredFeatureSpawnList() {
        return StructureOceanMonument.MONUMENT_ENEMIES;
    }
    
    @Override
    public String getStructureName() {
        return "Monument";
    }
    
    static {
        WATER_BIOMES = Arrays.asList(Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.RIVER, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER);
        SPAWN_BIOMES = Arrays.asList(Biomes.DEEP_OCEAN);
        (MONUMENT_ENEMIES = Lists.newArrayList()).add(new Biome.SpawnListEntry(EntityGuardian.class, 1, 2, 4));
    }
    
    public StructureOceanMonument(final Map<String, String> lllllllllllllIIllIIllIlIIlIIlIll) {
        this();
        for (final Map.Entry<String, String> lllllllllllllIIllIIllIlIIlIIllIl : lllllllllllllIIllIIllIlIIlIIlIll.entrySet()) {
            if (lllllllllllllIIllIIllIlIIlIIllIl.getKey().equals("spacing")) {
                this.spacing = MathHelper.getInt(lllllllllllllIIllIIllIlIIlIIllIl.getValue(), this.spacing, 1);
            }
            else {
                if (!lllllllllllllIIllIIllIlIIlIIllIl.getKey().equals("separation")) {
                    continue;
                }
                this.separation = MathHelper.getInt(lllllllllllllIIllIIllIlIIlIIllIl.getValue(), this.separation, 1);
            }
        }
    }
    
    @Override
    protected StructureStart getStructureStart(final int lllllllllllllIIllIIllIlIIIIlllII, final int lllllllllllllIIllIIllIlIIIIllIII) {
        return new StartMonument(this.worldObj, this.rand, lllllllllllllIIllIIllIlIIIIlllII, lllllllllllllIIllIIllIlIIIIllIII);
    }
    
    public static class StartMonument extends StructureStart
    {
        private /* synthetic */ boolean wasCreated;
        private final /* synthetic */ Set<ChunkPos> processed;
        
        @Override
        public void writeToNBT(final NBTTagCompound llllllllllllllIIIIIlIllllIIllIll) {
            super.writeToNBT(llllllllllllllIIIIIlIllllIIllIll);
            final NBTTagList llllllllllllllIIIIIlIllllIIllIlI = new NBTTagList();
            for (final ChunkPos llllllllllllllIIIIIlIllllIIllIIl : this.processed) {
                final NBTTagCompound llllllllllllllIIIIIlIllllIIllIII = new NBTTagCompound();
                llllllllllllllIIIIIlIllllIIllIII.setInteger("X", llllllllllllllIIIIIlIllllIIllIIl.chunkXPos);
                llllllllllllllIIIIIlIllllIIllIII.setInteger("Z", llllllllllllllIIIIIlIllllIIllIIl.chunkZPos);
                llllllllllllllIIIIIlIllllIIllIlI.appendTag(llllllllllllllIIIIIlIllllIIllIII);
            }
            llllllllllllllIIIIIlIllllIIllIll.setTag("Processed", llllllllllllllIIIIIlIllllIIllIlI);
        }
        
        private void create(final World llllllllllllllIIIIIlIlllllIIIlIl, final Random llllllllllllllIIIIIlIlllllIlIIII, final int llllllllllllllIIIIIlIlllllIIIIll, final int llllllllllllllIIIIIlIlllllIIlllI) {
            llllllllllllllIIIIIlIlllllIlIIII.setSeed(llllllllllllllIIIIIlIlllllIIIlIl.getSeed());
            final long llllllllllllllIIIIIlIlllllIIllIl = llllllllllllllIIIIIlIlllllIlIIII.nextLong();
            final long llllllllllllllIIIIIlIlllllIIllII = llllllllllllllIIIIIlIlllllIlIIII.nextLong();
            final long llllllllllllllIIIIIlIlllllIIlIll = llllllllllllllIIIIIlIlllllIIIIll * llllllllllllllIIIIIlIlllllIIllIl;
            final long llllllllllllllIIIIIlIlllllIIlIlI = llllllllllllllIIIIIlIlllllIIlllI * llllllllllllllIIIIIlIlllllIIllII;
            llllllllllllllIIIIIlIlllllIlIIII.setSeed(llllllllllllllIIIIIlIlllllIIlIll ^ llllllllllllllIIIIIlIlllllIIlIlI ^ llllllllllllllIIIIIlIlllllIIIlIl.getSeed());
            final int llllllllllllllIIIIIlIlllllIIlIIl = llllllllllllllIIIIIlIlllllIIIIll * 16 + 8 - 29;
            final int llllllllllllllIIIIIlIlllllIIlIII = llllllllllllllIIIIIlIlllllIIlllI * 16 + 8 - 29;
            final EnumFacing llllllllllllllIIIIIlIlllllIIIlll = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIIIIIlIlllllIlIIII);
            this.components.add(new StructureOceanMonumentPieces.MonumentBuilding(llllllllllllllIIIIIlIlllllIlIIII, llllllllllllllIIIIIlIlllllIIlIIl, llllllllllllllIIIIIlIlllllIIlIII, llllllllllllllIIIIIlIlllllIIIlll));
            this.updateBoundingBox();
            this.wasCreated = true;
        }
        
        @Override
        public void notifyPostProcessAt(final ChunkPos llllllllllllllIIIIIlIllllIlIIlIl) {
            super.notifyPostProcessAt(llllllllllllllIIIIIlIllllIlIIlIl);
            this.processed.add(llllllllllllllIIIIIlIllllIlIIlIl);
        }
        
        @Override
        public boolean isValidForPostProcess(final ChunkPos llllllllllllllIIIIIlIllllIlIlIIl) {
            return !this.processed.contains(llllllllllllllIIIIIlIllllIlIlIIl) && super.isValidForPostProcess(llllllllllllllIIIIIlIllllIlIlIIl);
        }
        
        @Override
        public void readFromNBT(final NBTTagCompound llllllllllllllIIIIIlIllllIIIIllI) {
            super.readFromNBT(llllllllllllllIIIIIlIllllIIIIllI);
            if (llllllllllllllIIIIIlIllllIIIIllI.hasKey("Processed", 9)) {
                final NBTTagList llllllllllllllIIIIIlIllllIIIlIlI = llllllllllllllIIIIIlIllllIIIIllI.getTagList("Processed", 10);
                for (int llllllllllllllIIIIIlIllllIIIlIIl = 0; llllllllllllllIIIIIlIllllIIIlIIl < llllllllllllllIIIIIlIllllIIIlIlI.tagCount(); ++llllllllllllllIIIIIlIllllIIIlIIl) {
                    final NBTTagCompound llllllllllllllIIIIIlIllllIIIlIII = llllllllllllllIIIIIlIllllIIIlIlI.getCompoundTagAt(llllllllllllllIIIIIlIllllIIIlIIl);
                    this.processed.add(new ChunkPos(llllllllllllllIIIIIlIllllIIIlIII.getInteger("X"), llllllllllllllIIIIIlIllllIIIlIII.getInteger("Z")));
                }
            }
        }
        
        public StartMonument(final World llllllllllllllIIIIIlIllllllIIIlI, final Random llllllllllllllIIIIIlIllllllIIIIl, final int llllllllllllllIIIIIlIllllllIIlIl, final int llllllllllllllIIIIIlIllllllIIlII) {
            super(llllllllllllllIIIIIlIllllllIIlIl, llllllllllllllIIIIIlIllllllIIlII);
            this.processed = (Set<ChunkPos>)Sets.newHashSet();
            this.create(llllllllllllllIIIIIlIllllllIIIlI, llllllllllllllIIIIIlIllllllIIIIl, llllllllllllllIIIIIlIllllllIIlIl, llllllllllllllIIIIIlIllllllIIlII);
        }
        
        @Override
        public void generateStructure(final World llllllllllllllIIIIIlIllllIllIlIl, final Random llllllllllllllIIIIIlIllllIllIlII, final StructureBoundingBox llllllllllllllIIIIIlIllllIlIllll) {
            if (!this.wasCreated) {
                this.components.clear();
                this.create(llllllllllllllIIIIIlIllllIllIlIl, llllllllllllllIIIIIlIllllIllIlII, this.getChunkPosX(), this.getChunkPosZ());
            }
            super.generateStructure(llllllllllllllIIIIIlIllllIllIlIl, llllllllllllllIIIIIlIllllIllIlII, llllllllllllllIIIIIlIllllIlIllll);
        }
        
        public StartMonument() {
            this.processed = (Set<ChunkPos>)Sets.newHashSet();
        }
    }
}
