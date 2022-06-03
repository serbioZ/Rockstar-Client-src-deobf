// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import java.util.List;
import java.util.Collections;
import com.google.common.collect.Lists;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import com.google.common.cache.CacheLoader;
import java.util.concurrent.TimeUnit;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import net.minecraft.world.gen.feature.WorldGenSpikes;

public class BiomeEndDecorator extends BiomeDecorator
{
    private final /* synthetic */ WorldGenSpikes spikeGen;
    private static final /* synthetic */ LoadingCache<Long, WorldGenSpikes.EndSpike[]> SPIKE_CACHE;
    
    static {
        SPIKE_CACHE = CacheBuilder.newBuilder().expireAfterWrite(5L, TimeUnit.MINUTES).build((CacheLoader)new SpikeCacheLoader(null));
    }
    
    @Override
    protected void genDecorations(final Biome llllllllllIlllIIllllIlIIlllIIlIl, final World llllllllllIlllIIllllIlIIllIlllll, final Random llllllllllIlllIIllllIlIIllIllllI) {
        this.generateOres(llllllllllIlllIIllllIlIIllIlllll, llllllllllIlllIIllllIlIIllIllllI);
        final WorldGenSpikes.EndSpike[] llllllllllIlllIIllllIlIIlllIIIlI = getSpikesForWorld(llllllllllIlllIIllllIlIIllIlllll);
        final byte llllllllllIlllIIllllIlIIllIllIIl;
        final double llllllllllIlllIIllllIlIIllIllIlI = ((WorldGenSpikes.EndSpike[])(Object)(llllllllllIlllIIllllIlIIllIllIIl = (byte)(Object)llllllllllIlllIIllllIlIIlllIIIlI)).length;
        for (Exception llllllllllIlllIIllllIlIIllIllIll = (Exception)0; llllllllllIlllIIllllIlIIllIllIll < llllllllllIlllIIllllIlIIllIllIlI; ++llllllllllIlllIIllllIlIIllIllIll) {
            final WorldGenSpikes.EndSpike llllllllllIlllIIllllIlIIlllIIIIl = llllllllllIlllIIllllIlIIllIllIIl[llllllllllIlllIIllllIlIIllIllIll];
            if (llllllllllIlllIIllllIlIIlllIIIIl.doesStartInChunk(this.chunkPos)) {
                this.spikeGen.setSpike(llllllllllIlllIIllllIlIIlllIIIIl);
                this.spikeGen.generate(llllllllllIlllIIllllIlIIllIlllll, llllllllllIlllIIllllIlIIllIllllI, new BlockPos(llllllllllIlllIIllllIlIIlllIIIIl.getCenterX(), 45, llllllllllIlllIIllllIlIIlllIIIIl.getCenterZ()));
            }
        }
    }
    
    public static WorldGenSpikes.EndSpike[] getSpikesForWorld(final World llllllllllIlllIIllllIlIIllIlIIlI) {
        final Random llllllllllIlllIIllllIlIIllIlIlII = new Random(llllllllllIlllIIllllIlIIllIlIIlI.getSeed());
        final long llllllllllIlllIIllllIlIIllIlIIll = llllllllllIlllIIllllIlIIllIlIlII.nextLong() & 0xFFFFL;
        return (WorldGenSpikes.EndSpike[])BiomeEndDecorator.SPIKE_CACHE.getUnchecked((Object)llllllllllIlllIIllllIlIIllIlIIll);
    }
    
    public BiomeEndDecorator() {
        this.spikeGen = new WorldGenSpikes();
    }
    
    static class SpikeCacheLoader extends CacheLoader<Long, WorldGenSpikes.EndSpike[]>
    {
        private SpikeCacheLoader() {
        }
        
        public WorldGenSpikes.EndSpike[] load(final Long lllllllllllIllIIIlllllllIIllIlII) throws Exception {
            final List<Integer> lllllllllllIllIIIlllllllIIllllIl = (List<Integer>)Lists.newArrayList((Iterable)ContiguousSet.create(Range.closedOpen((Comparable)0, (Comparable)10), DiscreteDomain.integers()));
            Collections.shuffle(lllllllllllIllIIIlllllllIIllllIl, new Random(lllllllllllIllIIIlllllllIIllIlII));
            final WorldGenSpikes.EndSpike[] lllllllllllIllIIIlllllllIIllllII = new WorldGenSpikes.EndSpike[10];
            for (int lllllllllllIllIIIlllllllIIlllIll = 0; lllllllllllIllIIIlllllllIIlllIll < 10; ++lllllllllllIllIIIlllllllIIlllIll) {
                final int lllllllllllIllIIIlllllllIIlllIlI = (int)(42.0 * Math.cos(2.0 * (-3.141592653589793 + 0.3141592653589793 * lllllllllllIllIIIlllllllIIlllIll)));
                final int lllllllllllIllIIIlllllllIIlllIIl = (int)(42.0 * Math.sin(2.0 * (-3.141592653589793 + 0.3141592653589793 * lllllllllllIllIIIlllllllIIlllIll)));
                final int lllllllllllIllIIIlllllllIIlllIII = lllllllllllIllIIIlllllllIIllllIl.get(lllllllllllIllIIIlllllllIIlllIll);
                final int lllllllllllIllIIIlllllllIIllIlll = 2 + lllllllllllIllIIIlllllllIIlllIII / 3;
                final int lllllllllllIllIIIlllllllIIllIllI = 76 + lllllllllllIllIIIlllllllIIlllIII * 3;
                final boolean lllllllllllIllIIIlllllllIIllIlIl = lllllllllllIllIIIlllllllIIlllIII == 1 || lllllllllllIllIIIlllllllIIlllIII == 2;
                lllllllllllIllIIIlllllllIIllllII[lllllllllllIllIIIlllllllIIlllIll] = new WorldGenSpikes.EndSpike(lllllllllllIllIIIlllllllIIlllIlI, lllllllllllIllIIIlllllllIIlllIIl, lllllllllllIllIIIlllllllIIllIlll, lllllllllllIllIIIlllllllIIllIllI, lllllllllllIllIIIlllllllIIllIlIl);
            }
            return lllllllllllIllIIIlllllllIIllllII;
        }
    }
}
