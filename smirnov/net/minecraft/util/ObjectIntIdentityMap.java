// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import com.google.common.collect.Iterators;
import com.google.common.base.Predicates;
import java.util.Iterator;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import java.util.List;
import java.util.IdentityHashMap;

public class ObjectIntIdentityMap<T> implements IObjectIntIterable<T>
{
    private final /* synthetic */ IdentityHashMap<T, Integer> identityMap;
    private final /* synthetic */ List<T> objectList;
    
    public int size() {
        return this.identityMap.size();
    }
    
    @Nullable
    public final T getByValue(final int lllllllllllIlIIIlIlIIIIIllIlIlll) {
        return (lllllllllllIlIIIlIlIIIIIllIlIlll >= 0 && lllllllllllIlIIIlIlIIIIIllIlIlll < this.objectList.size()) ? this.objectList.get(lllllllllllIlIIIlIlIIIIIllIlIlll) : null;
    }
    
    public ObjectIntIdentityMap() {
        this(512);
    }
    
    public ObjectIntIdentityMap(final int lllllllllllIlIIIlIlIIIIIlllIllll) {
        this.objectList = (List<T>)Lists.newArrayListWithExpectedSize(lllllllllllIlIIIlIlIIIIIlllIllll);
        this.identityMap = new IdentityHashMap<T, Integer>(lllllllllllIlIIIlIlIIIIIlllIllll);
    }
    
    public void put(final T lllllllllllIlIIIlIlIIIIIlllIlIII, final int lllllllllllIlIIIlIlIIIIIlllIIlll) {
        this.identityMap.put(lllllllllllIlIIIlIlIIIIIlllIlIII, lllllllllllIlIIIlIlIIIIIlllIIlll);
        while (this.objectList.size() <= lllllllllllIlIIIlIlIIIIIlllIIlll) {
            this.objectList.add(null);
        }
        this.objectList.set(lllllllllllIlIIIlIlIIIIIlllIIlll, lllllllllllIlIIIlIlIIIIIlllIlIII);
    }
    
    public int get(final T lllllllllllIlIIIlIlIIIIIllIlllll) {
        final Integer lllllllllllIlIIIlIlIIIIIllIllllI = this.identityMap.get(lllllllllllIlIIIlIlIIIIIllIlllll);
        return (lllllllllllIlIIIlIlIIIIIllIllllI == null) ? -1 : lllllllllllIlIIIlIlIIIIIllIllllI;
    }
    
    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>)Iterators.filter((Iterator)this.objectList.iterator(), Predicates.notNull());
    }
}
