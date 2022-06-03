// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;

public class IntCache
{
    private static final /* synthetic */ List<int[]> freeLargeArrays;
    private static /* synthetic */ int intCacheSize;
    private static final /* synthetic */ List<int[]> inUseSmallArrays;
    private static final /* synthetic */ List<int[]> inUseLargeArrays;
    private static final /* synthetic */ List<int[]> freeSmallArrays;
    
    public static synchronized void resetIntCache() {
        if (!IntCache.freeLargeArrays.isEmpty()) {
            IntCache.freeLargeArrays.remove(IntCache.freeLargeArrays.size() - 1);
        }
        if (!IntCache.freeSmallArrays.isEmpty()) {
            IntCache.freeSmallArrays.remove(IntCache.freeSmallArrays.size() - 1);
        }
        IntCache.freeLargeArrays.addAll(IntCache.inUseLargeArrays);
        IntCache.freeSmallArrays.addAll(IntCache.inUseSmallArrays);
        IntCache.inUseLargeArrays.clear();
        IntCache.inUseSmallArrays.clear();
    }
    
    public static synchronized String getCacheSizes() {
        return "cache: " + IntCache.freeLargeArrays.size() + ", tcache: " + IntCache.freeSmallArrays.size() + ", allocated: " + IntCache.inUseLargeArrays.size() + ", tallocated: " + IntCache.inUseSmallArrays.size();
    }
    
    static {
        IntCache.intCacheSize = 256;
        freeSmallArrays = Lists.newArrayList();
        inUseSmallArrays = Lists.newArrayList();
        freeLargeArrays = Lists.newArrayList();
        inUseLargeArrays = Lists.newArrayList();
    }
    
    public static synchronized int[] getIntCache(final int lllllllllllIlllIlIllIlIlIlIlIIll) {
        if (lllllllllllIlllIlIllIlIlIlIlIIll <= 256) {
            if (IntCache.freeSmallArrays.isEmpty()) {
                final int[] lllllllllllIlllIlIllIlIlIlIlIIlI = new int[256];
                IntCache.inUseSmallArrays.add(lllllllllllIlllIlIllIlIlIlIlIIlI);
                return lllllllllllIlllIlIllIlIlIlIlIIlI;
            }
            final int[] lllllllllllIlllIlIllIlIlIlIlIIIl = IntCache.freeSmallArrays.remove(IntCache.freeSmallArrays.size() - 1);
            IntCache.inUseSmallArrays.add(lllllllllllIlllIlIllIlIlIlIlIIIl);
            return lllllllllllIlllIlIllIlIlIlIlIIIl;
        }
        else {
            if (lllllllllllIlllIlIllIlIlIlIlIIll > IntCache.intCacheSize) {
                IntCache.intCacheSize = lllllllllllIlllIlIllIlIlIlIlIIll;
                IntCache.freeLargeArrays.clear();
                IntCache.inUseLargeArrays.clear();
                final int[] lllllllllllIlllIlIllIlIlIlIlIIII = new int[IntCache.intCacheSize];
                IntCache.inUseLargeArrays.add(lllllllllllIlllIlIllIlIlIlIlIIII);
                return lllllllllllIlllIlIllIlIlIlIlIIII;
            }
            if (IntCache.freeLargeArrays.isEmpty()) {
                final int[] lllllllllllIlllIlIllIlIlIlIIllll = new int[IntCache.intCacheSize];
                IntCache.inUseLargeArrays.add(lllllllllllIlllIlIllIlIlIlIIllll);
                return lllllllllllIlllIlIllIlIlIlIIllll;
            }
            final int[] lllllllllllIlllIlIllIlIlIlIIlllI = IntCache.freeLargeArrays.remove(IntCache.freeLargeArrays.size() - 1);
            IntCache.inUseLargeArrays.add(lllllllllllIlllIlIllIlIlIlIIlllI);
            return lllllllllllIlllIlIllIlIlIlIIlllI;
        }
    }
}
