// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.multiplayer;

import org.apache.logging.log4j.LogManager;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import javax.annotation.Nullable;
import com.google.common.base.MoreObjects;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.EmptyChunk;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.world.World;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderClient implements IChunkProvider
{
    private final /* synthetic */ Chunk blankChunk;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Long2ObjectMap<Chunk> chunkMapping;
    private final /* synthetic */ World worldObj;
    
    public ChunkProviderClient(final World lllllllllllIIIlIllIlIlllIIllIllI) {
        this.chunkMapping = (Long2ObjectMap<Chunk>)new Long2ObjectOpenHashMap<Chunk>(8192) {
            protected void rehash(final int llllllllllIlllIlllllIllIIIIlIlII) {
                if (llllllllllIlllIlllllIllIIIIlIlII > this.key.length) {
                    super.rehash(llllllllllIlllIlllllIllIIIIlIlII);
                }
            }
        };
        this.blankChunk = new EmptyChunk(lllllllllllIIIlIllIlIlllIIllIllI, 0, 0);
        this.worldObj = lllllllllllIIIlIllIlIlllIIllIllI;
    }
    
    public Chunk loadChunk(final int lllllllllllIIIlIllIlIlllIIIlIlll, final int lllllllllllIIIlIllIlIlllIIIllIlI) {
        final Chunk lllllllllllIIIlIllIlIlllIIIllIIl = new Chunk(this.worldObj, lllllllllllIIIlIllIlIlllIIIlIlll, lllllllllllIIIlIllIlIlllIIIllIlI);
        this.chunkMapping.put(ChunkPos.asLong(lllllllllllIIIlIllIlIlllIIIlIlll, lllllllllllIIIlIllIlIlllIIIllIlI), (Object)lllllllllllIIIlIllIlIlllIIIllIIl);
        lllllllllllIIIlIllIlIlllIIIllIIl.setChunkLoaded(true);
        return lllllllllllIIIlIllIlIlllIIIllIIl;
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllIIIlIllIlIlllIIIlIIII, final int lllllllllllIIIlIllIlIlllIIIIllII) {
        return (Chunk)MoreObjects.firstNonNull((Object)this.getLoadedChunk(lllllllllllIIIlIllIlIlllIIIlIIII, lllllllllllIIIlIllIlIlllIIIIllII), (Object)this.blankChunk);
    }
    
    public void unloadChunk(final int lllllllllllIIIlIllIlIlllIIlIllII, final int lllllllllllIIIlIllIlIlllIIlIlIll) {
        final Chunk lllllllllllIIIlIllIlIlllIIlIlllI = this.provideChunk(lllllllllllIIIlIllIlIlllIIlIllII, lllllllllllIIIlIllIlIlllIIlIlIll);
        if (!lllllllllllIIIlIllIlIlllIIlIlllI.isEmpty()) {
            lllllllllllIIIlIllIlIlllIIlIlllI.onChunkUnload();
        }
        this.chunkMapping.remove(ChunkPos.asLong(lllllllllllIIIlIllIlIlllIIlIllII, lllllllllllIIIlIllIlIlllIIlIlIll));
    }
    
    @Nullable
    @Override
    public Chunk getLoadedChunk(final int lllllllllllIIIlIllIlIlllIIlIIlIl, final int lllllllllllIIIlIllIlIlllIIlIIIIl) {
        return (Chunk)this.chunkMapping.get(ChunkPos.asLong(lllllllllllIIIlIllIlIlllIIlIIlIl, lllllllllllIIIlIllIlIlllIIlIIIIl));
    }
    
    @Override
    public String makeString() {
        return "MultiplayerChunkCache: " + this.chunkMapping.size() + ", " + this.chunkMapping.size();
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        final long lllllllllllIIIlIllIlIlllIIIIIllI = System.currentTimeMillis();
        for (final Chunk lllllllllllIIIlIllIlIlllIIIIIlII : this.chunkMapping.values()) {
            lllllllllllIIIlIllIlIlllIIIIIlII.onTick(System.currentTimeMillis() - lllllllllllIIIlIllIlIlllIIIIIllI > 5L);
        }
        if (System.currentTimeMillis() - lllllllllllIIIlIllIlIlllIIIIIllI > 100L) {
            ChunkProviderClient.LOGGER.info("Warning: Clientside chunk ticking took {} ms", (Object)(System.currentTimeMillis() - lllllllllllIIIlIllIlIlllIIIIIllI));
        }
        return false;
    }
    
    @Override
    public boolean func_191062_e(final int lllllllllllIIIlIllIlIllIlllllIII, final int lllllllllllIIIlIllIlIllIllllIlII) {
        return this.chunkMapping.containsKey(ChunkPos.asLong(lllllllllllIIIlIllIlIllIlllllIII, lllllllllllIIIlIllIlIllIllllIlII));
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
