// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.server.MinecraftServer;
import java.util.List;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;

public class BiomeCache
{
    private final /* synthetic */ Long2ObjectMap<Block> cacheMap;
    private final /* synthetic */ BiomeProvider chunkManager;
    private /* synthetic */ long lastCleanupTime;
    private final /* synthetic */ List<Block> cache;
    
    public Block getBiomeCacheBlock(int llllllllllllIIlIIlIllIlIlllIlIlI, int llllllllllllIIlIIlIllIlIlllIIlII) {
        llllllllllllIIlIIlIllIlIlllIlIlI >>= 4;
        llllllllllllIIlIIlIllIlIlllIIlII >>= (4 != 0);
        final long llllllllllllIIlIIlIllIlIlllIlIII = ((long)llllllllllllIIlIIlIllIlIlllIlIlI & 0xFFFFFFFFL) | ((long)(llllllllllllIIlIIlIllIlIlllIIlII ? 1 : 0) & 0xFFFFFFFFL) << 32;
        Block llllllllllllIIlIIlIllIlIlllIIlll = (Block)this.cacheMap.get(llllllllllllIIlIIlIllIlIlllIlIII);
        if (llllllllllllIIlIIlIllIlIlllIIlll == null) {
            llllllllllllIIlIIlIllIlIlllIIlll = new Block(llllllllllllIIlIIlIllIlIlllIlIlI, (int)(llllllllllllIIlIIlIllIlIlllIIlII ? 1 : 0));
            this.cacheMap.put(llllllllllllIIlIIlIllIlIlllIlIII, (Object)llllllllllllIIlIIlIllIlIlllIIlll);
            this.cache.add(llllllllllllIIlIIlIllIlIlllIIlll);
        }
        llllllllllllIIlIIlIllIlIlllIIlll.lastAccessTime = MinecraftServer.getCurrentTimeMillis();
        return llllllllllllIIlIIlIllIlIlllIIlll;
    }
    
    public void cleanupCache() {
        final long llllllllllllIIlIIlIllIlIllIIlIlI = MinecraftServer.getCurrentTimeMillis();
        final long llllllllllllIIlIIlIllIlIllIIlIIl = llllllllllllIIlIIlIllIlIllIIlIlI - this.lastCleanupTime;
        if (llllllllllllIIlIIlIllIlIllIIlIIl > 7500L || llllllllllllIIlIIlIllIlIllIIlIIl < 0L) {
            this.lastCleanupTime = llllllllllllIIlIIlIllIlIllIIlIlI;
            for (int llllllllllllIIlIIlIllIlIllIIlIII = 0; llllllllllllIIlIIlIllIlIllIIlIII < this.cache.size(); ++llllllllllllIIlIIlIllIlIllIIlIII) {
                final Block llllllllllllIIlIIlIllIlIllIIIlll = this.cache.get(llllllllllllIIlIIlIllIlIllIIlIII);
                final long llllllllllllIIlIIlIllIlIllIIIllI = llllllllllllIIlIIlIllIlIllIIlIlI - llllllllllllIIlIIlIllIlIllIIIlll.lastAccessTime;
                if (llllllllllllIIlIIlIllIlIllIIIllI > 30000L || llllllllllllIIlIIlIllIlIllIIIllI < 0L) {
                    this.cache.remove(llllllllllllIIlIIlIllIlIllIIlIII--);
                    final long llllllllllllIIlIIlIllIlIllIIIlIl = ((long)llllllllllllIIlIIlIllIlIllIIIlll.xPosition & 0xFFFFFFFFL) | ((long)llllllllllllIIlIIlIllIlIllIIIlll.zPosition & 0xFFFFFFFFL) << 32;
                    this.cacheMap.remove(llllllllllllIIlIIlIllIlIllIIIlIl);
                }
            }
        }
    }
    
    public Biome getBiome(final int llllllllllllIIlIIlIllIlIllIlIllI, final int llllllllllllIIlIIlIllIlIllIllIlI, final Biome llllllllllllIIlIIlIllIlIllIllIIl) {
        final Biome llllllllllllIIlIIlIllIlIllIllIII = this.getBiomeCacheBlock(llllllllllllIIlIIlIllIlIllIlIllI, llllllllllllIIlIIlIllIlIllIllIlI).getBiome(llllllllllllIIlIIlIllIlIllIlIllI, llllllllllllIIlIIlIllIlIllIllIlI);
        return (llllllllllllIIlIIlIllIlIllIllIII == null) ? llllllllllllIIlIIlIllIlIllIllIIl : llllllllllllIIlIIlIllIlIllIllIII;
    }
    
    public Biome[] getCachedBiomes(final int llllllllllllIIlIIlIllIlIlIllIllI, final int llllllllllllIIlIIlIllIlIlIlllIII) {
        return this.getBiomeCacheBlock(llllllllllllIIlIIlIllIlIlIllIllI, llllllllllllIIlIIlIllIlIlIlllIII).biomes;
    }
    
    public BiomeCache(final BiomeProvider llllllllllllIIlIIlIllIlIllllIIIl) {
        this.cacheMap = (Long2ObjectMap<Block>)new Long2ObjectOpenHashMap(4096);
        this.cache = (List<Block>)Lists.newArrayList();
        this.chunkManager = llllllllllllIIlIIlIllIlIllllIIIl;
    }
    
    public class Block
    {
        public /* synthetic */ int xPosition;
        public /* synthetic */ long lastAccessTime;
        public /* synthetic */ Biome[] biomes;
        public /* synthetic */ int zPosition;
        
        public Biome getBiome(final int llllllllllIllllIIIIllIlIIlIIIlII, final int llllllllllIllllIIIIllIlIIlIIIllI) {
            return this.biomes[(llllllllllIllllIIIIllIlIIlIIIlII & 0xF) | (llllllllllIllllIIIIllIlIIlIIIllI & 0xF) << 4];
        }
        
        public Block(final int llllllllllIllllIIIIllIlIIlIIllIl, final int llllllllllIllllIIIIllIlIIlIIllII) {
            this.biomes = new Biome[256];
            this.xPosition = llllllllllIllllIIIIllIlIIlIIllIl;
            this.zPosition = llllllllllIllllIIIIllIlIIlIIllII;
            BiomeCache.this.chunkManager.getBiomes(this.biomes, llllllllllIllllIIIIllIlIIlIIllIl << 4, llllllllllIllllIIIIllIlIIlIIllII << 4, 16, 16, false);
        }
    }
}
