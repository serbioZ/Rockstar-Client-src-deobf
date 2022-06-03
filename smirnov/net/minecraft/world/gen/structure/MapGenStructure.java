// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import java.util.Iterator;
import net.minecraft.util.math.Vec3i;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldSavedData;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.World;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.world.gen.MapGenBase;

public abstract class MapGenStructure extends MapGenBase
{
    protected /* synthetic */ Long2ObjectMap<StructureStart> structureMap;
    private /* synthetic */ MapGenStructureData structureData;
    
    @Override
    protected final synchronized void recursiveGenerate(final World lllllllllllIIllllIIIIlIIllllIlIl, final int lllllllllllIIllllIIIIlIIllllIlII, final int lllllllllllIIllllIIIIlIIllllIIll, final int lllllllllllIIllllIIIIlIIllllllIl, final int lllllllllllIIllllIIIIlIIllllllII, final ChunkPrimer lllllllllllIIllllIIIIlIIlllllIll) {
        this.initializeStructureData(lllllllllllIIllllIIIIlIIllllIlIl);
        if (!this.structureMap.containsKey(ChunkPos.asLong(lllllllllllIIllllIIIIlIIllllIlII, lllllllllllIIllllIIIIlIIllllIIll))) {
            this.rand.nextInt();
            try {
                if (this.canSpawnStructureAtCoords(lllllllllllIIllllIIIIlIIllllIlII, lllllllllllIIllllIIIIlIIllllIIll)) {
                    final StructureStart lllllllllllIIllllIIIIlIIlllllIlI = this.getStructureStart(lllllllllllIIllllIIIIlIIllllIlII, lllllllllllIIllllIIIIlIIllllIIll);
                    this.structureMap.put(ChunkPos.asLong(lllllllllllIIllllIIIIlIIllllIlII, lllllllllllIIllllIIIIlIIllllIIll), (Object)lllllllllllIIllllIIIIlIIlllllIlI);
                    if (lllllllllllIIllllIIIIlIIlllllIlI.isSizeableStructure()) {
                        this.setStructureStart(lllllllllllIIllllIIIIlIIllllIlII, lllllllllllIIllllIIIIlIIllllIIll, lllllllllllIIllllIIIIlIIlllllIlI);
                    }
                }
            }
            catch (Throwable lllllllllllIIllllIIIIlIIlllllIIl) {
                final CrashReport lllllllllllIIllllIIIIlIIlllllIII = CrashReport.makeCrashReport(lllllllllllIIllllIIIIlIIlllllIIl, "Exception preparing structure feature");
                final CrashReportCategory lllllllllllIIllllIIIIlIIllllIlll = lllllllllllIIllllIIIIlIIlllllIII.makeCategory("Feature being prepared");
                lllllllllllIIllllIIIIlIIllllIlll.setDetail("Is feature chunk", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return MapGenStructure.this.canSpawnStructureAtCoords(lllllllllllIIllllIIIIlIIllllIlII, lllllllllllIIllllIIIIlIIllllIIll) ? "True" : "False";
                    }
                });
                lllllllllllIIllllIIIIlIIllllIlll.addCrashSection("Chunk location", String.format("%d,%d", lllllllllllIIllllIIIIlIIllllIlII, lllllllllllIIllllIIIIlIIllllIIll));
                lllllllllllIIllllIIIIlIIllllIlll.setDetail("Chunk pos hash", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return String.valueOf(ChunkPos.asLong(lllllllllllIIllllIIIIlIIllllIlII, lllllllllllIIllllIIIIlIIllllIIll));
                    }
                });
                lllllllllllIIllllIIIIlIIllllIlll.setDetail("Structure type", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return MapGenStructure.this.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(lllllllllllIIllllIIIIlIIlllllIII);
            }
        }
    }
    
    protected static BlockPos func_191069_a(final World lllllllllllIIllllIIIIlIIIllIlllI, final MapGenStructure lllllllllllIIllllIIIIlIIIlIlIlll, final BlockPos lllllllllllIIllllIIIIlIIIlIlIllI, final int lllllllllllIIllllIIIIlIIIllIlIll, final int lllllllllllIIllllIIIIlIIIlIlIlII, final int lllllllllllIIllllIIIIlIIIlIlIIll, final boolean lllllllllllIIllllIIIIlIIIllIlIII, final int lllllllllllIIllllIIIIlIIIllIIlll, final boolean lllllllllllIIllllIIIIlIIIllIIllI) {
        final int lllllllllllIIllllIIIIlIIIllIIlIl = lllllllllllIIllllIIIIlIIIlIlIllI.getX() >> 4;
        final int lllllllllllIIllllIIIIlIIIllIIlII = lllllllllllIIllllIIIIlIIIlIlIllI.getZ() >> 4;
        int lllllllllllIIllllIIIIlIIIllIIIll = 0;
        final Random lllllllllllIIllllIIIIlIIIllIIIlI = new Random();
        while (lllllllllllIIllllIIIIlIIIllIIIll <= lllllllllllIIllllIIIIlIIIllIIlll) {
            for (int lllllllllllIIllllIIIIlIIIllIIIIl = -lllllllllllIIllllIIIIlIIIllIIIll; lllllllllllIIllllIIIIlIIIllIIIIl <= lllllllllllIIllllIIIIlIIIllIIIll; ++lllllllllllIIllllIIIIlIIIllIIIIl) {
                final boolean lllllllllllIIllllIIIIlIIIllIIIII = lllllllllllIIllllIIIIlIIIllIIIIl == -lllllllllllIIllllIIIIlIIIllIIIll || lllllllllllIIllllIIIIlIIIllIIIIl == lllllllllllIIllllIIIIlIIIllIIIll;
                for (int lllllllllllIIllllIIIIlIIIlIlllll = -lllllllllllIIllllIIIIlIIIllIIIll; lllllllllllIIllllIIIIlIIIlIlllll <= lllllllllllIIllllIIIIlIIIllIIIll; ++lllllllllllIIllllIIIIlIIIlIlllll) {
                    final boolean lllllllllllIIllllIIIIlIIIlIllllI = lllllllllllIIllllIIIIlIIIlIlllll == -lllllllllllIIllllIIIIlIIIllIIIll || lllllllllllIIllllIIIIlIIIlIlllll == lllllllllllIIllllIIIIlIIIllIIIll;
                    if (lllllllllllIIllllIIIIlIIIllIIIII || lllllllllllIIllllIIIIlIIIlIllllI) {
                        int lllllllllllIIllllIIIIlIIIlIlllIl = lllllllllllIIllllIIIIlIIIllIIlIl + lllllllllllIIllllIIIIlIIIllIlIll * lllllllllllIIllllIIIIlIIIllIIIIl;
                        int lllllllllllIIllllIIIIlIIIlIlllII = lllllllllllIIllllIIIIlIIIllIIlII + lllllllllllIIllllIIIIlIIIllIlIll * lllllllllllIIllllIIIIlIIIlIlllll;
                        if (lllllllllllIIllllIIIIlIIIlIlllIl < 0) {
                            lllllllllllIIllllIIIIlIIIlIlllIl -= lllllllllllIIllllIIIIlIIIllIlIll - 1;
                        }
                        if (lllllllllllIIllllIIIIlIIIlIlllII < 0) {
                            lllllllllllIIllllIIIIlIIIlIlllII -= lllllllllllIIllllIIIIlIIIllIlIll - 1;
                        }
                        int lllllllllllIIllllIIIIlIIIlIllIll = lllllllllllIIllllIIIIlIIIlIlllIl / lllllllllllIIllllIIIIlIIIllIlIll;
                        int lllllllllllIIllllIIIIlIIIlIllIlI = lllllllllllIIllllIIIIlIIIlIlllII / lllllllllllIIllllIIIIlIIIllIlIll;
                        final Random lllllllllllIIllllIIIIlIIIlIllIIl = lllllllllllIIllllIIIIlIIIllIlllI.setRandomSeed(lllllllllllIIllllIIIIlIIIlIllIll, lllllllllllIIllllIIIIlIIIlIllIlI, lllllllllllIIllllIIIIlIIIlIlIIll);
                        lllllllllllIIllllIIIIlIIIlIllIll *= lllllllllllIIllllIIIIlIIIllIlIll;
                        lllllllllllIIllllIIIIlIIIlIllIlI *= lllllllllllIIllllIIIIlIIIllIlIll;
                        if (lllllllllllIIllllIIIIlIIIllIlIII) {
                            lllllllllllIIllllIIIIlIIIlIllIll += (lllllllllllIIllllIIIIlIIIlIllIIl.nextInt(lllllllllllIIllllIIIIlIIIllIlIll - lllllllllllIIllllIIIIlIIIlIlIlII) + lllllllllllIIllllIIIIlIIIlIllIIl.nextInt(lllllllllllIIllllIIIIlIIIllIlIll - lllllllllllIIllllIIIIlIIIlIlIlII)) / 2;
                            lllllllllllIIllllIIIIlIIIlIllIlI += (lllllllllllIIllllIIIIlIIIlIllIIl.nextInt(lllllllllllIIllllIIIIlIIIllIlIll - lllllllllllIIllllIIIIlIIIlIlIlII) + lllllllllllIIllllIIIIlIIIlIllIIl.nextInt(lllllllllllIIllllIIIIlIIIllIlIll - lllllllllllIIllllIIIIlIIIlIlIlII)) / 2;
                        }
                        else {
                            lllllllllllIIllllIIIIlIIIlIllIll += lllllllllllIIllllIIIIlIIIlIllIIl.nextInt(lllllllllllIIllllIIIIlIIIllIlIll - lllllllllllIIllllIIIIlIIIlIlIlII);
                            lllllllllllIIllllIIIIlIIIlIllIlI += lllllllllllIIllllIIIIlIIIlIllIIl.nextInt(lllllllllllIIllllIIIIlIIIllIlIll - lllllllllllIIllllIIIIlIIIlIlIlII);
                        }
                        MapGenBase.func_191068_a(lllllllllllIIllllIIIIlIIIllIlllI.getSeed(), lllllllllllIIllllIIIIlIIIllIIIlI, lllllllllllIIllllIIIIlIIIlIllIll, lllllllllllIIllllIIIIlIIIlIllIlI);
                        lllllllllllIIllllIIIIlIIIllIIIlI.nextInt();
                        if (lllllllllllIIllllIIIIlIIIlIlIlll.canSpawnStructureAtCoords(lllllllllllIIllllIIIIlIIIlIllIll, lllllllllllIIllllIIIIlIIIlIllIlI)) {
                            if (!lllllllllllIIllllIIIIlIIIllIIllI || !lllllllllllIIllllIIIIlIIIllIlllI.func_190526_b(lllllllllllIIllllIIIIlIIIlIllIll, lllllllllllIIllllIIIIlIIIlIllIlI)) {
                                return new BlockPos((lllllllllllIIllllIIIIlIIIlIllIll << 4) + 8, 64, (lllllllllllIIllllIIIIlIIIlIllIlI << 4) + 8);
                            }
                        }
                        else if (lllllllllllIIllllIIIIlIIIllIIIll == 0) {
                            break;
                        }
                    }
                }
                if (lllllllllllIIllllIIIIlIIIllIIIll == 0) {
                    break;
                }
            }
            ++lllllllllllIIllllIIIIlIIIllIIIll;
        }
        return null;
    }
    
    public synchronized boolean generateStructure(final World lllllllllllIIllllIIIIlIIlllIIlIl, final Random lllllllllllIIllllIIIIlIIllIllIll, final ChunkPos lllllllllllIIllllIIIIlIIllIllIlI) {
        this.initializeStructureData(lllllllllllIIllllIIIIlIIlllIIlIl);
        final int lllllllllllIIllllIIIIlIIlllIIIlI = (lllllllllllIIllllIIIIlIIllIllIlI.chunkXPos << 4) + 8;
        final int lllllllllllIIllllIIIIlIIlllIIIIl = (lllllllllllIIllllIIIIlIIllIllIlI.chunkZPos << 4) + 8;
        boolean lllllllllllIIllllIIIIlIIlllIIIII = false;
        for (final StructureStart lllllllllllIIllllIIIIlIIllIllllI : this.structureMap.values()) {
            if (lllllllllllIIllllIIIIlIIllIllllI.isSizeableStructure() && lllllllllllIIllllIIIIlIIllIllllI.isValidForPostProcess(lllllllllllIIllllIIIIlIIllIllIlI) && lllllllllllIIllllIIIIlIIllIllllI.getBoundingBox().intersectsWith(lllllllllllIIllllIIIIlIIlllIIIlI, lllllllllllIIllllIIIIlIIlllIIIIl, lllllllllllIIllllIIIIlIIlllIIIlI + 15, lllllllllllIIllllIIIIlIIlllIIIIl + 15)) {
                lllllllllllIIllllIIIIlIIllIllllI.generateStructure(lllllllllllIIllllIIIIlIIlllIIlIl, lllllllllllIIllllIIIIlIIllIllIll, new StructureBoundingBox(lllllllllllIIllllIIIIlIIlllIIIlI, lllllllllllIIllllIIIIlIIlllIIIIl, lllllllllllIIllllIIIIlIIlllIIIlI + 15, lllllllllllIIllllIIIIlIIlllIIIIl + 15));
                lllllllllllIIllllIIIIlIIllIllllI.notifyPostProcessAt(lllllllllllIIllllIIIIlIIllIllIlI);
                lllllllllllIIllllIIIIlIIlllIIIII = true;
                this.setStructureStart(lllllllllllIIllllIIIIlIIllIllllI.getChunkPosX(), lllllllllllIIllllIIIIlIIllIllllI.getChunkPosZ(), lllllllllllIIllllIIIIlIIllIllllI);
            }
        }
        return lllllllllllIIllllIIIIlIIlllIIIII;
    }
    
    public abstract String getStructureName();
    
    protected void initializeStructureData(final World lllllllllllIIllllIIIIlIIlIlIIIlI) {
        if (this.structureData == null && lllllllllllIIllllIIIIlIIlIlIIIlI != null) {
            this.structureData = (MapGenStructureData)lllllllllllIIllllIIIIlIIlIlIIIlI.loadItemData(MapGenStructureData.class, this.getStructureName());
            if (this.structureData == null) {
                this.structureData = new MapGenStructureData(this.getStructureName());
                lllllllllllIIllllIIIIlIIlIlIIIlI.setItemData(this.getStructureName(), this.structureData);
            }
            else {
                final NBTTagCompound lllllllllllIIllllIIIIlIIlIlIIIIl = this.structureData.getTagCompound();
                for (final String lllllllllllIIllllIIIIlIIlIlIIIII : lllllllllllIIllllIIIIlIIlIlIIIIl.getKeySet()) {
                    final NBTBase lllllllllllIIllllIIIIlIIlIIlllll = lllllllllllIIllllIIIIlIIlIlIIIIl.getTag(lllllllllllIIllllIIIIlIIlIlIIIII);
                    if (lllllllllllIIllllIIIIlIIlIIlllll.getId() == 10) {
                        final NBTTagCompound lllllllllllIIllllIIIIlIIlIIllllI = (NBTTagCompound)lllllllllllIIllllIIIIlIIlIIlllll;
                        if (!lllllllllllIIllllIIIIlIIlIIllllI.hasKey("ChunkX") || !lllllllllllIIllllIIIIlIIlIIllllI.hasKey("ChunkZ")) {
                            continue;
                        }
                        final int lllllllllllIIllllIIIIlIIlIIlllIl = lllllllllllIIllllIIIIlIIlIIllllI.getInteger("ChunkX");
                        final int lllllllllllIIllllIIIIlIIlIIlllII = lllllllllllIIllllIIIIlIIlIIllllI.getInteger("ChunkZ");
                        final StructureStart lllllllllllIIllllIIIIlIIlIIllIll = MapGenStructureIO.getStructureStart(lllllllllllIIllllIIIIlIIlIIllllI, lllllllllllIIllllIIIIlIIlIlIIIlI);
                        if (lllllllllllIIllllIIIIlIIlIIllIll == null) {
                            continue;
                        }
                        this.structureMap.put(ChunkPos.asLong(lllllllllllIIllllIIIIlIIlIIlllIl, lllllllllllIIllllIIIIlIIlIIlllII), (Object)lllllllllllIIllllIIIIlIIlIIllIll);
                    }
                }
            }
        }
    }
    
    private void setStructureStart(final int lllllllllllIIllllIIIIlIIlIIIIlll, final int lllllllllllIIllllIIIIlIIlIIIIllI, final StructureStart lllllllllllIIllllIIIIlIIlIIIlIIl) {
        this.structureData.writeInstance(lllllllllllIIllllIIIIlIIlIIIlIIl.writeStructureComponentsToNBT(lllllllllllIIllllIIIIlIIlIIIIlll, lllllllllllIIllllIIIIlIIlIIIIllI), lllllllllllIIllllIIIIlIIlIIIIlll, lllllllllllIIllllIIIIlIIlIIIIllI);
        this.structureData.markDirty();
    }
    
    protected abstract boolean canSpawnStructureAtCoords(final int p0, final int p1);
    
    @Nullable
    public abstract BlockPos getClosestStrongholdPos(final World p0, final BlockPos p1, final boolean p2);
    
    public MapGenStructure() {
        this.structureMap = (Long2ObjectMap<StructureStart>)new Long2ObjectOpenHashMap(1024);
    }
    
    public boolean isInsideStructure(final BlockPos lllllllllllIIllllIIIIlIIllIIllll) {
        if (this.worldObj == null) {
            return false;
        }
        this.initializeStructureData(this.worldObj);
        return this.getStructureAt(lllllllllllIIllllIIIIlIIllIIllll) != null;
    }
    
    @Nullable
    protected StructureStart getStructureAt(final BlockPos lllllllllllIIllllIIIIlIIllIIIIIl) {
        for (final StructureStart lllllllllllIIllllIIIIlIIllIIIlIl : this.structureMap.values()) {
            if (lllllllllllIIllllIIIIlIIllIIIlIl.isSizeableStructure() && lllllllllllIIllllIIIIlIIllIIIlIl.getBoundingBox().isVecInside(lllllllllllIIllllIIIIlIIllIIIIIl)) {
                for (final StructureComponent lllllllllllIIllllIIIIlIIllIIIIll : lllllllllllIIllllIIIIlIIllIIIlIl.getComponents()) {
                    if (lllllllllllIIllllIIIIlIIllIIIIll.getBoundingBox().isVecInside(lllllllllllIIllllIIIIlIIllIIIIIl)) {
                        return lllllllllllIIllllIIIIlIIllIIIlIl;
                    }
                }
            }
        }
        return null;
    }
    
    protected abstract StructureStart getStructureStart(final int p0, final int p1);
    
    public boolean isPositionInStructure(final World lllllllllllIIllllIIIIlIIlIllIIIl, final BlockPos lllllllllllIIllllIIIIlIIlIllIlIl) {
        this.initializeStructureData(lllllllllllIIllllIIIIlIIlIllIIIl);
        for (final StructureStart lllllllllllIIllllIIIIlIIlIllIIll : this.structureMap.values()) {
            if (lllllllllllIIllllIIIIlIIlIllIIll.isSizeableStructure() && lllllllllllIIllllIIIIlIIlIllIIll.getBoundingBox().isVecInside(lllllllllllIIllllIIIIlIIlIllIlIl)) {
                return true;
            }
        }
        return false;
    }
}
