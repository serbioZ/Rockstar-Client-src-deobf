// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import java.util.Collection;
import com.google.common.collect.Maps;
import java.util.Locale;
import java.util.Set;
import java.util.Map;

public class LowerStringMap<V> implements Map<String, V>
{
    private final /* synthetic */ Map<String, V> internalMap;
    
    @Override
    public Set<String> keySet() {
        return this.internalMap.keySet();
    }
    
    @Override
    public boolean containsKey(final Object llllllllllllIlIIlIlIIIlIIIIIIllI) {
        return this.internalMap.containsKey(llllllllllllIlIIlIlIIIlIIIIIIllI.toString().toLowerCase(Locale.ROOT));
    }
    
    @Override
    public V put(final String llllllllllllIlIIlIlIIIIlllllIIlI, final V llllllllllllIlIIlIlIIIIlllllIIIl) {
        return this.internalMap.put(llllllllllllIlIIlIlIIIIlllllIIlI.toLowerCase(Locale.ROOT), llllllllllllIlIIlIlIIIIlllllIIIl);
    }
    
    @Override
    public void clear() {
        this.internalMap.clear();
    }
    
    @Override
    public int size() {
        return this.internalMap.size();
    }
    
    public LowerStringMap() {
        this.internalMap = (Map<String, V>)Maps.newLinkedHashMap();
    }
    
    @Override
    public void putAll(final Map<? extends String, ? extends V> llllllllllllIlIIlIlIIIIllllIIlIl) {
        for (final Entry<? extends String, ? extends V> llllllllllllIlIIlIlIIIIllllIIlII : llllllllllllIlIIlIlIIIIllllIIlIl.entrySet()) {
            this.put((String)llllllllllllIlIIlIlIIIIllllIIlII.getKey(), llllllllllllIlIIlIlIIIIllllIIlII.getValue());
        }
    }
    
    @Override
    public Collection<V> values() {
        return this.internalMap.values();
    }
    
    @Override
    public V get(final Object llllllllllllIlIIlIlIIIIllllllIlI) {
        return this.internalMap.get(llllllllllllIlIIlIlIIIIllllllIlI.toString().toLowerCase(Locale.ROOT));
    }
    
    @Override
    public Set<Entry<String, V>> entrySet() {
        return this.internalMap.entrySet();
    }
    
    @Override
    public boolean isEmpty() {
        return this.internalMap.isEmpty();
    }
    
    @Override
    public V remove(final Object llllllllllllIlIIlIlIIIIllllIlIll) {
        return this.internalMap.remove(llllllllllllIlIIlIlIIIIllllIlIll.toString().toLowerCase(Locale.ROOT));
    }
    
    @Override
    public boolean containsValue(final Object llllllllllllIlIIlIlIIIlIIIIIIIII) {
        return this.internalMap.containsKey(llllllllllllIlIIlIlIIIlIIIIIIIII);
    }
}
