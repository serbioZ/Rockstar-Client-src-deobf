// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import java.util.Iterator;
import java.util.Collection;
import com.google.common.collect.Lists;
import net.minecraft.world.MinecraftException;
import java.io.IOException;
import net.minecraft.world.biome.Biome;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EnumCreatureType;
import org.apache.logging.log4j.LogManager;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.math.ChunkPos;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import org.apache.logging.log4j.Logger;
import java.util.Set;
import net.minecraft.world.chunk.Chunk;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderServer implements IChunkProvider
{
    private final /* synthetic */ IChunkGenerator chunkGenerator;
    private final /* synthetic */ IChunkLoader chunkLoader;
    private final /* synthetic */ WorldServer worldObj;
    private final /* synthetic */ Long2ObjectMap<Chunk> id2ChunkMap;
    private final /* synthetic */ Set<Long> droppedChunksSet;
    private static final /* synthetic */ Logger LOGGER;
    
    public boolean canSave() {
        return !this.worldObj.disableLevelSaving;
    }
    
    @Nullable
    private Chunk loadChunkFromFile(final int lllllllllllIlIlIllIlIIlllIIIlIlI, final int lllllllllllIlIlIllIlIIlllIIIlIIl) {
        try {
            final Chunk lllllllllllIlIlIllIlIIlllIIIllIl = this.chunkLoader.loadChunk(this.worldObj, lllllllllllIlIlIllIlIIlllIIIlIlI, lllllllllllIlIlIllIlIIlllIIIlIIl);
            if (lllllllllllIlIlIllIlIIlllIIIllIl != null) {
                lllllllllllIlIlIllIlIIlllIIIllIl.setLastSaveTime(this.worldObj.getTotalWorldTime());
                this.chunkGenerator.recreateStructures(lllllllllllIlIlIllIlIIlllIIIllIl, lllllllllllIlIlIllIlIIlllIIIlIlI, lllllllllllIlIlIllIlIIlllIIIlIIl);
            }
            return lllllllllllIlIlIllIlIIlllIIIllIl;
        }
        catch (Exception lllllllllllIlIlIllIlIIlllIIIllII) {
            ChunkProviderServer.LOGGER.error("Couldn't load chunk", (Throwable)lllllllllllIlIlIllIlIIlllIIIllII);
            return null;
        }
    }
    
    @Override
    public String makeString() {
        return "ServerChunkCache: " + this.id2ChunkMap.size() + " Drop: " + this.droppedChunksSet.size();
    }
    
    public void saveExtraData() {
        this.chunkLoader.saveExtraData();
    }
    
    private void saveChunkExtraData(final Chunk lllllllllllIlIlIllIlIIlllIIIIIII) {
        try {
            this.chunkLoader.saveExtraChunkData(this.worldObj, lllllllllllIlIlIllIlIIlllIIIIIII);
        }
        catch (Exception lllllllllllIlIlIllIlIIlllIIIIIlI) {
            ChunkProviderServer.LOGGER.error("Couldn't save entities", (Throwable)lllllllllllIlIlIllIlIIlllIIIIIlI);
        }
    }
    
    public void unloadAllChunks() {
        for (final Chunk lllllllllllIlIlIllIlIIllllIIlIll : this.id2ChunkMap.values()) {
            this.unload(lllllllllllIlIlIllIlIIllllIIlIll);
        }
    }
    
    public ChunkProviderServer(final WorldServer lllllllllllIlIlIllIlIIllllIlllII, final IChunkLoader lllllllllllIlIlIllIlIIllllIlllll, final IChunkGenerator lllllllllllIlIlIllIlIIllllIllIlI) {
        this.droppedChunksSet = (Set<Long>)Sets.newHashSet();
        this.id2ChunkMap = (Long2ObjectMap<Chunk>)new Long2ObjectOpenHashMap(8192);
        this.worldObj = lllllllllllIlIlIllIlIIllllIlllII;
        this.chunkLoader = lllllllllllIlIlIllIlIIllllIlllll;
        this.chunkGenerator = lllllllllllIlIlIllIlIIllllIllIlI;
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllIlIlIllIlIIlllIlIIIll, final int lllllllllllIlIlIllIlIIlllIIllIlI) {
        Chunk lllllllllllIlIlIllIlIIlllIlIIIIl = this.loadChunk(lllllllllllIlIlIllIlIIlllIlIIIll, lllllllllllIlIlIllIlIIlllIIllIlI);
        if (lllllllllllIlIlIllIlIIlllIlIIIIl == null) {
            final long lllllllllllIlIlIllIlIIlllIlIIIII = ChunkPos.asLong(lllllllllllIlIlIllIlIIlllIlIIIll, lllllllllllIlIlIllIlIIlllIIllIlI);
            try {
                lllllllllllIlIlIllIlIIlllIlIIIIl = this.chunkGenerator.provideChunk(lllllllllllIlIlIllIlIIlllIlIIIll, lllllllllllIlIlIllIlIIlllIIllIlI);
            }
            catch (Throwable lllllllllllIlIlIllIlIIlllIIlllll) {
                final CrashReport lllllllllllIlIlIllIlIIlllIIllllI = CrashReport.makeCrashReport(lllllllllllIlIlIllIlIIlllIIlllll, "Exception generating new chunk");
                final CrashReportCategory lllllllllllIlIlIllIlIIlllIIlllIl = lllllllllllIlIlIllIlIIlllIIllllI.makeCategory("Chunk to be generated");
                lllllllllllIlIlIllIlIIlllIIlllIl.addCrashSection("Location", String.format("%d,%d", lllllllllllIlIlIllIlIIlllIlIIIll, lllllllllllIlIlIllIlIIlllIIllIlI));
                lllllllllllIlIlIllIlIIlllIIlllIl.addCrashSection("Position hash", lllllllllllIlIlIllIlIIlllIlIIIII);
                lllllllllllIlIlIllIlIIlllIIlllIl.addCrashSection("Generator", this.chunkGenerator);
                throw new ReportedException(lllllllllllIlIlIllIlIIlllIIllllI);
            }
            this.id2ChunkMap.put(lllllllllllIlIlIllIlIIlllIlIIIII, (Object)lllllllllllIlIlIllIlIIlllIlIIIIl);
            lllllllllllIlIlIllIlIIlllIlIIIIl.onChunkLoad();
            lllllllllllIlIlIllIlIIlllIlIIIIl.populateChunk(this, this.chunkGenerator);
        }
        return lllllllllllIlIlIllIlIIlllIlIIIIl;
    }
    
    @Nullable
    @Override
    public Chunk getLoadedChunk(final int lllllllllllIlIlIllIlIIllllIIIIIl, final int lllllllllllIlIlIllIlIIllllIIIIII) {
        final long lllllllllllIlIlIllIlIIlllIllllll = ChunkPos.asLong(lllllllllllIlIlIllIlIIllllIIIIIl, lllllllllllIlIlIllIlIIllllIIIIII);
        final Chunk lllllllllllIlIlIllIlIIlllIlllllI = (Chunk)this.id2ChunkMap.get(lllllllllllIlIlIllIlIIlllIllllll);
        if (lllllllllllIlIlIllIlIIlllIlllllI != null) {
            lllllllllllIlIlIllIlIIlllIlllllI.unloaded = false;
        }
        return lllllllllllIlIlIllIlIIlllIlllllI;
    }
    
    public boolean chunkExists(final int lllllllllllIlIlIllIlIIllIIIlllII, final int lllllllllllIlIlIllIlIIllIIIllIll) {
        return this.id2ChunkMap.containsKey(ChunkPos.asLong(lllllllllllIlIlIllIlIIllIIIlllII, lllllllllllIlIlIllIlIIllIIIllIll));
    }
    
    public void unload(final Chunk lllllllllllIlIlIllIlIIllllIlIIll) {
        if (this.worldObj.provider.canDropChunk(lllllllllllIlIlIllIlIIllllIlIIll.xPosition, lllllllllllIlIlIllIlIIllllIlIIll.zPosition)) {
            this.droppedChunksSet.add(ChunkPos.asLong(lllllllllllIlIlIllIlIIllllIlIIll.xPosition, lllllllllllIlIlIllIlIIllllIlIIll.zPosition));
            lllllllllllIlIlIllIlIIllllIlIIll.unloaded = true;
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Nullable
    public Chunk loadChunk(final int lllllllllllIlIlIllIlIIlllIllIIll, final int lllllllllllIlIlIllIlIIlllIlIlllI) {
        Chunk lllllllllllIlIlIllIlIIlllIllIIIl = this.getLoadedChunk(lllllllllllIlIlIllIlIIlllIllIIll, lllllllllllIlIlIllIlIIlllIlIlllI);
        if (lllllllllllIlIlIllIlIIlllIllIIIl == null) {
            lllllllllllIlIlIllIlIIlllIllIIIl = this.loadChunkFromFile(lllllllllllIlIlIllIlIIlllIllIIll, lllllllllllIlIlIllIlIIlllIlIlllI);
            if (lllllllllllIlIlIllIlIIlllIllIIIl != null) {
                this.id2ChunkMap.put(ChunkPos.asLong(lllllllllllIlIlIllIlIIlllIllIIll, lllllllllllIlIlIllIlIIlllIlIlllI), (Object)lllllllllllIlIlIllIlIIlllIllIIIl);
                lllllllllllIlIlIllIlIIlllIllIIIl.onChunkLoad();
                lllllllllllIlIlIllIlIIlllIllIIIl.populateChunk(this, this.chunkGenerator);
            }
        }
        return lllllllllllIlIlIllIlIIlllIllIIIl;
    }
    
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType lllllllllllIlIlIllIlIIllIlIIIIll, final BlockPos lllllllllllIlIlIllIlIIllIlIIIlIl) {
        return this.chunkGenerator.getPossibleCreatures(lllllllllllIlIlIllIlIIllIlIIIIll, lllllllllllIlIlIllIlIIllIlIIIlIl);
    }
    
    @Nullable
    public BlockPos getStrongholdGen(final World lllllllllllIlIlIllIlIIllIIllIllI, final String lllllllllllIlIlIllIlIIllIIlllIlI, final BlockPos lllllllllllIlIlIllIlIIllIIllIlII, final boolean lllllllllllIlIlIllIlIIllIIllIIll) {
        return this.chunkGenerator.getStrongholdGen(lllllllllllIlIlIllIlIIllIIllIllI, lllllllllllIlIlIllIlIIllIIlllIlI, lllllllllllIlIlIllIlIIllIIllIlII, lllllllllllIlIlIllIlIIllIIllIIll);
    }
    
    public boolean func_193413_a(final World lllllllllllIlIlIllIlIIllIIlIlIIl, final String lllllllllllIlIlIllIlIIllIIlIllII, final BlockPos lllllllllllIlIlIllIlIIllIIlIlIll) {
        return this.chunkGenerator.func_193414_a(lllllllllllIlIlIllIlIIllIIlIlIIl, lllllllllllIlIlIllIlIIllIIlIllII, lllllllllllIlIlIllIlIIllIIlIlIll);
    }
    
    @Override
    public boolean func_191062_e(final int lllllllllllIlIlIllIlIIllIIIlIllI, final int lllllllllllIlIlIllIlIIllIIIlIlIl) {
        return this.id2ChunkMap.containsKey(ChunkPos.asLong(lllllllllllIlIlIllIlIIllIIIlIllI, lllllllllllIlIlIllIlIIllIIIlIlIl)) || this.chunkLoader.func_191063_a(lllllllllllIlIlIllIlIIllIIIlIllI, lllllllllllIlIlIllIlIIllIIIlIlIl);
    }
    
    private void saveChunkData(final Chunk lllllllllllIlIlIllIlIIllIllllIlI) {
        try {
            lllllllllllIlIlIllIlIIllIllllIlI.setLastSaveTime(this.worldObj.getTotalWorldTime());
            this.chunkLoader.saveChunk(this.worldObj, lllllllllllIlIlIllIlIIllIllllIlI);
        }
        catch (IOException lllllllllllIlIlIllIlIIllIllllIIl) {
            ChunkProviderServer.LOGGER.error("Couldn't save chunk", (Throwable)lllllllllllIlIlIllIlIIllIllllIIl);
        }
        catch (MinecraftException lllllllllllIlIlIllIlIIllIllllIII) {
            ChunkProviderServer.LOGGER.error("Couldn't save chunk; already in use by another instance of Minecraft?", (Throwable)lllllllllllIlIlIllIlIIllIllllIII);
        }
    }
    
    public boolean saveChunks(final boolean lllllllllllIlIlIllIlIIllIllIllIl) {
        int lllllllllllIlIlIllIlIIllIllIllII = 0;
        final List<Chunk> lllllllllllIlIlIllIlIIllIllIlIll = (List<Chunk>)Lists.newArrayList((Iterable)this.id2ChunkMap.values());
        for (int lllllllllllIlIlIllIlIIllIllIlIlI = 0; lllllllllllIlIlIllIlIIllIllIlIlI < lllllllllllIlIlIllIlIIllIllIlIll.size(); ++lllllllllllIlIlIllIlIIllIllIlIlI) {
            final Chunk lllllllllllIlIlIllIlIIllIllIlIIl = lllllllllllIlIlIllIlIIllIllIlIll.get(lllllllllllIlIlIllIlIIllIllIlIlI);
            if (lllllllllllIlIlIllIlIIllIllIllIl) {
                this.saveChunkExtraData(lllllllllllIlIlIllIlIIllIllIlIIl);
            }
            if (lllllllllllIlIlIllIlIIllIllIlIIl.needsSaving(lllllllllllIlIlIllIlIIllIllIllIl)) {
                this.saveChunkData(lllllllllllIlIlIllIlIIllIllIlIIl);
                lllllllllllIlIlIllIlIIllIllIlIIl.setModified(false);
                if (++lllllllllllIlIlIllIlIIllIllIllII == 24 && !lllllllllllIlIlIllIlIIllIllIllIl) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Collection<Chunk> getLoadedChunks() {
        return (Collection<Chunk>)this.id2ChunkMap.values();
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        if (!this.worldObj.disableLevelSaving) {
            if (!this.droppedChunksSet.isEmpty()) {
                final Iterator<Long> lllllllllllIlIlIllIlIIllIlIllIIl = this.droppedChunksSet.iterator();
                int lllllllllllIlIlIllIlIIllIlIllIII = 0;
                while (lllllllllllIlIlIllIlIIllIlIllIII < 100 && lllllllllllIlIlIllIlIIllIlIllIIl.hasNext()) {
                    final Long lllllllllllIlIlIllIlIIllIlIlIlll = lllllllllllIlIlIllIlIIllIlIllIIl.next();
                    final Chunk lllllllllllIlIlIllIlIIllIlIlIllI = (Chunk)this.id2ChunkMap.get((Object)lllllllllllIlIlIllIlIIllIlIlIlll);
                    if (lllllllllllIlIlIllIlIIllIlIlIllI != null && lllllllllllIlIlIllIlIIllIlIlIllI.unloaded) {
                        lllllllllllIlIlIllIlIIllIlIlIllI.onChunkUnload();
                        this.saveChunkData(lllllllllllIlIlIllIlIIllIlIlIllI);
                        this.saveChunkExtraData(lllllllllllIlIlIllIlIIllIlIlIllI);
                        this.id2ChunkMap.remove((Object)lllllllllllIlIlIllIlIIllIlIlIlll);
                        ++lllllllllllIlIlIllIlIIllIlIllIII;
                    }
                    lllllllllllIlIlIllIlIIllIlIllIIl.remove();
                }
            }
            this.chunkLoader.chunkTick();
        }
        return false;
    }
    
    public int getLoadedChunkCount() {
        return this.id2ChunkMap.size();
    }
}
