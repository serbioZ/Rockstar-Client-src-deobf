// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import net.minecraft.util.math.MathHelper;
import javax.annotation.Nullable;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.Arrays;

public class IntIdentityHashBiMap<K> implements IObjectIntIterable<K>
{
    private static final /* synthetic */ Object EMPTY;
    private /* synthetic */ int nextFreeIndex;
    private /* synthetic */ K[] byId;
    private /* synthetic */ K[] values;
    private /* synthetic */ int mapSize;
    private /* synthetic */ int[] intKeys;
    
    public void clear() {
        Arrays.fill(this.values, null);
        Arrays.fill(this.byId, null);
        this.nextFreeIndex = 0;
        this.mapSize = 0;
    }
    
    public void put(final K llllllllllllllIlIlIIlIlIllIIIIll, final int llllllllllllllIlIlIIlIlIllIIlIII) {
        final int llllllllllllllIlIlIIlIlIllIIIlll = Math.max(llllllllllllllIlIlIIlIlIllIIlIII, this.mapSize + 1);
        if (llllllllllllllIlIlIIlIlIllIIIlll >= this.values.length * 0.8f) {
            int llllllllllllllIlIlIIlIlIllIIIllI;
            for (llllllllllllllIlIlIIlIlIllIIIllI = this.values.length << 1; llllllllllllllIlIlIIlIlIllIIIllI < llllllllllllllIlIlIIlIlIllIIlIII; llllllllllllllIlIlIIlIlIllIIIllI <<= 1) {}
            this.grow(llllllllllllllIlIlIIlIlIllIIIllI);
        }
        final int llllllllllllllIlIlIIlIlIllIIIlIl = this.findEmpty(this.hashObject(llllllllllllllIlIlIIlIlIllIIIIll));
        this.values[llllllllllllllIlIlIIlIlIllIIIlIl] = llllllllllllllIlIlIIlIlIllIIIIll;
        this.intKeys[llllllllllllllIlIlIIlIlIllIIIlIl] = llllllllllllllIlIlIIlIlIllIIlIII;
        this.byId[llllllllllllllIlIlIIlIlIllIIlIII] = llllllllllllllIlIlIIlIlIllIIIIll;
        ++this.mapSize;
        if (llllllllllllllIlIlIIlIlIllIIlIII == this.nextFreeIndex) {
            ++this.nextFreeIndex;
        }
    }
    
    public IntIdentityHashBiMap(int llllllllllllllIlIlIIlIlIllllllIl) {
        llllllllllllllIlIlIIlIlIllllllIl /= (int)0.8f;
        this.values = (K[])new Object[llllllllllllllIlIlIIlIlIllllllIl];
        this.intKeys = new int[llllllllllllllIlIlIIlIlIllllllIl];
        this.byId = (K[])new Object[llllllllllllllIlIlIIlIlIllllllIl];
    }
    
    private int findEmpty(final int llllllllllllllIlIlIIlIlIlIlIIlII) {
        for (int llllllllllllllIlIlIIlIlIlIlIIlll = llllllllllllllIlIlIIlIlIlIlIIlII; llllllllllllllIlIlIIlIlIlIlIIlll < this.values.length; ++llllllllllllllIlIlIIlIlIlIlIIlll) {
            if (this.values[llllllllllllllIlIlIIlIlIlIlIIlll] == IntIdentityHashBiMap.EMPTY) {
                return llllllllllllllIlIlIIlIlIlIlIIlll;
            }
        }
        for (int llllllllllllllIlIlIIlIlIlIlIIllI = 0; llllllllllllllIlIlIIlIlIlIlIIllI < llllllllllllllIlIlIIlIlIlIlIIlII; ++llllllllllllllIlIlIIlIlIlIlIIllI) {
            if (this.values[llllllllllllllIlIlIIlIlIlIlIIllI] == IntIdentityHashBiMap.EMPTY) {
                return llllllllllllllIlIlIIlIlIlIlIIllI;
            }
        }
        throw new RuntimeException("Overflowed :(");
    }
    
    public int add(final K llllllllllllllIlIlIIlIlIlllIIIll) {
        final int llllllllllllllIlIlIIlIlIlllIIlIl = this.nextId();
        this.put(llllllllllllllIlIlIIlIlIlllIIIll, llllllllllllllIlIlIIlIlIlllIIlIl);
        return llllllllllllllIlIlIIlIlIlllIIlIl;
    }
    
    static {
        EMPTY = null;
    }
    
    @Override
    public Iterator<K> iterator() {
        return (Iterator<K>)Iterators.filter((Iterator)Iterators.forArray((Object[])this.byId), Predicates.notNull());
    }
    
    private int nextId() {
        while (this.nextFreeIndex < this.byId.length && this.byId[this.nextFreeIndex] != null) {
            ++this.nextFreeIndex;
        }
        return this.nextFreeIndex;
    }
    
    private int getValue(final int llllllllllllllIlIlIIlIlIlllIlIll) {
        return (llllllllllllllIlIlIIlIlIlllIlIll == -1) ? -1 : this.intKeys[llllllllllllllIlIlIIlIlIlllIlIll];
    }
    
    private void grow(final int llllllllllllllIlIlIIlIlIllIllIII) {
        final Object[] llllllllllllllIlIlIIlIlIllIlIlll = this.values;
        final int[] llllllllllllllIlIlIIlIlIllIlIllI = this.intKeys;
        this.values = (K[])new Object[llllllllllllllIlIlIIlIlIllIllIII];
        this.intKeys = new int[llllllllllllllIlIlIIlIlIllIllIII];
        this.byId = (K[])new Object[llllllllllllllIlIlIIlIlIllIllIII];
        this.nextFreeIndex = 0;
        this.mapSize = 0;
        for (int llllllllllllllIlIlIIlIlIllIlIlIl = 0; llllllllllllllIlIlIIlIlIllIlIlIl < llllllllllllllIlIlIIlIlIllIlIlll.length; ++llllllllllllllIlIlIIlIlIllIlIlIl) {
            if (llllllllllllllIlIlIIlIlIllIlIlll[llllllllllllllIlIlIIlIlIllIlIlIl] != null) {
                this.put(llllllllllllllIlIlIIlIlIllIlIlll[llllllllllllllIlIlIIlIlIllIlIlIl], llllllllllllllIlIlIIlIlIllIlIllI[llllllllllllllIlIlIIlIlIllIlIlIl]);
            }
        }
    }
    
    @Nullable
    public K get(final int llllllllllllllIlIlIIlIlIllllIIIl) {
        return (llllllllllllllIlIlIIlIlIllllIIIl >= 0 && llllllllllllllIlIlIIlIlIllllIIIl < this.byId.length) ? this.byId[llllllllllllllIlIlIIlIlIllllIIIl] : null;
    }
    
    public int getId(@Nullable final K llllllllllllllIlIlIIlIlIllllIlll) {
        return this.getValue(this.getIndex(llllllllllllllIlIlIIlIlIllllIlll, this.hashObject(llllllllllllllIlIlIIlIlIllllIlll)));
    }
    
    private int getIndex(@Nullable final K llllllllllllllIlIlIIlIlIlIlIllll, final int llllllllllllllIlIlIIlIlIlIlIlllI) {
        for (int llllllllllllllIlIlIIlIlIlIllIIlI = llllllllllllllIlIlIIlIlIlIlIlllI; llllllllllllllIlIlIIlIlIlIllIIlI < this.values.length; ++llllllllllllllIlIlIIlIlIlIllIIlI) {
            if (this.values[llllllllllllllIlIlIIlIlIlIllIIlI] == llllllllllllllIlIlIIlIlIlIlIllll) {
                return llllllllllllllIlIlIIlIlIlIllIIlI;
            }
            if (this.values[llllllllllllllIlIlIIlIlIlIllIIlI] == IntIdentityHashBiMap.EMPTY) {
                return -1;
            }
        }
        for (int llllllllllllllIlIlIIlIlIlIllIIIl = 0; llllllllllllllIlIlIIlIlIlIllIIIl < llllllllllllllIlIlIIlIlIlIlIlllI; ++llllllllllllllIlIlIIlIlIlIllIIIl) {
            if (this.values[llllllllllllllIlIlIIlIlIlIllIIIl] == llllllllllllllIlIlIIlIlIlIlIllll) {
                return llllllllllllllIlIlIIlIlIlIllIIIl;
            }
            if (this.values[llllllllllllllIlIlIIlIlIlIllIIIl] == IntIdentityHashBiMap.EMPTY) {
                return -1;
            }
        }
        return -1;
    }
    
    public int size() {
        return this.mapSize;
    }
    
    private int hashObject(@Nullable final K llllllllllllllIlIlIIlIlIlIllllII) {
        return (MathHelper.hash(System.identityHashCode(llllllllllllllIlIlIIlIlIlIllllII)) & Integer.MAX_VALUE) % this.values.length;
    }
}
