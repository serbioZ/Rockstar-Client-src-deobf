// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.util;

import com.google.common.collect.AbstractIterator;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.Locale;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.util.ResourceLocation;
import java.util.function.Function;

public class SearchTree<T> implements ISearchTree<T>
{
    protected /* synthetic */ SuffixArray<T> field_194044_a;
    private final /* synthetic */ Function<T, Iterable<ResourceLocation>> field_194047_d;
    private /* synthetic */ Object2IntMap<T> field_194049_f;
    private final /* synthetic */ Function<T, Iterable<String>> field_194046_c;
    protected /* synthetic */ SuffixArray<T> field_194045_b;
    private final /* synthetic */ List<T> field_194048_e;
    
    @Override
    public List<T> func_194038_a(final String lllllllllllIllIIllIIIIIIlllIIIll) {
        final List<T> lllllllllllIllIIllIIIIIIlllIIllI = this.field_194044_a.func_194055_a(lllllllllllIllIIllIIIIIIlllIIIll);
        if (lllllllllllIllIIllIIIIIIlllIIIll.indexOf(58) < 0) {
            return lllllllllllIllIIllIIIIIIlllIIllI;
        }
        final List<T> lllllllllllIllIIllIIIIIIlllIIlIl = this.field_194045_b.func_194055_a(lllllllllllIllIIllIIIIIIlllIIIll);
        return lllllllllllIllIIllIIIIIIlllIIlIl.isEmpty() ? lllllllllllIllIIllIIIIIIlllIIllI : Lists.newArrayList((Iterator)new MergingIterator((Iterator<Object>)lllllllllllIllIIllIIIIIIlllIIllI.iterator(), (Iterator<Object>)lllllllllllIllIIllIIIIIIlllIIlIl.iterator(), (it.unimi.dsi.fastutil.objects.Object2IntMap<Object>)this.field_194049_f));
    }
    
    public void func_194043_a(final T lllllllllllIllIIllIIIIIIllllIlIl) {
        this.field_194049_f.put((Object)lllllllllllIllIIllIIIIIIllllIlIl, this.field_194048_e.size());
        this.field_194048_e.add(lllllllllllIllIIllIIIIIIllllIlIl);
        this.func_194042_b(lllllllllllIllIIllIIIIIIllllIlIl);
    }
    
    private void func_194042_b(final T lllllllllllIllIIllIIIIIIlllIllll) {
        this.field_194047_d.apply(lllllllllllIllIIllIIIIIIlllIllll).forEach(lllllllllllIllIIllIIIIIIllIlllII -> this.field_194045_b.func_194057_a(lllllllllllIllIIllIIIIIIlllIllll, lllllllllllIllIIllIIIIIIllIlllII.toString().toLowerCase(Locale.ROOT)));
        this.field_194046_c.apply(lllllllllllIllIIllIIIIIIlllIllll).forEach(lllllllllllIllIIllIIIIIIllIlIIIl -> this.field_194044_a.func_194057_a(lllllllllllIllIIllIIIIIIlllIllll, lllllllllllIllIIllIIIIIIllIlIIIl.toLowerCase(Locale.ROOT)));
    }
    
    public SearchTree(final Function<T, Iterable<String>> lllllllllllIllIIllIIIIIlIIIIIlIl, final Function<T, Iterable<ResourceLocation>> lllllllllllIllIIllIIIIIlIIIIIIIl) {
        this.field_194044_a = new SuffixArray<T>();
        this.field_194045_b = new SuffixArray<T>();
        this.field_194048_e = (List<T>)Lists.newArrayList();
        this.field_194049_f = (Object2IntMap<T>)new Object2IntOpenHashMap();
        this.field_194046_c = lllllllllllIllIIllIIIIIlIIIIIlIl;
        this.field_194047_d = lllllllllllIllIIllIIIIIlIIIIIIIl;
    }
    
    public void func_194040_a() {
        this.field_194044_a = new SuffixArray<T>();
        this.field_194045_b = new SuffixArray<T>();
        for (final T lllllllllllIllIIllIIIIIIllllllII : this.field_194048_e) {
            this.func_194042_b(lllllllllllIllIIllIIIIIIllllllII);
        }
        this.field_194044_a.func_194058_a();
        this.field_194045_b.func_194058_a();
    }
    
    static class MergingIterator<T> extends AbstractIterator<T>
    {
        private /* synthetic */ T field_194036_d;
        private /* synthetic */ T field_194037_e;
        private final /* synthetic */ Object2IntMap<T> field_194035_c;
        private final /* synthetic */ Iterator<T> field_194034_b;
        private final /* synthetic */ Iterator<T> field_194033_a;
        
        public MergingIterator(final Iterator<T> lllllllllllllIIlIIIlIlIIIllIIlII, final Iterator<T> lllllllllllllIIlIIIlIlIIIlIlllll, final Object2IntMap<T> lllllllllllllIIlIIIlIlIIIlIllllI) {
            this.field_194033_a = lllllllllllllIIlIIIlIlIIIllIIlII;
            this.field_194034_b = lllllllllllllIIlIIIlIlIIIlIlllll;
            this.field_194035_c = lllllllllllllIIlIIIlIlIIIlIllllI;
            this.field_194036_d = (lllllllllllllIIlIIIlIlIIIllIIlII.hasNext() ? lllllllllllllIIlIIIlIlIIIllIIlII.next() : null);
            this.field_194037_e = (lllllllllllllIIlIIIlIlIIIlIlllll.hasNext() ? lllllllllllllIIlIIIlIlIIIlIlllll.next() : null);
        }
        
        protected T computeNext() {
            if (this.field_194036_d == null && this.field_194037_e == null) {
                return (T)this.endOfData();
            }
            int lllllllllllllIIlIIIlIlIIIlIlIllI = 0;
            if (this.field_194036_d == this.field_194037_e) {
                final int lllllllllllllIIlIIIlIlIIIlIllIIl = 0;
            }
            else if (this.field_194036_d == null) {
                final int lllllllllllllIIlIIIlIlIIIlIllIII = 1;
            }
            else if (this.field_194037_e == null) {
                final int lllllllllllllIIlIIIlIlIIIlIlIlll = -1;
            }
            else {
                lllllllllllllIIlIIIlIlIIIlIlIllI = Integer.compare(this.field_194035_c.getInt((Object)this.field_194036_d), this.field_194035_c.getInt((Object)this.field_194037_e));
            }
            final T lllllllllllllIIlIIIlIlIIIlIlIlIl = (lllllllllllllIIlIIIlIlIIIlIlIllI <= 0) ? this.field_194036_d : this.field_194037_e;
            if (lllllllllllllIIlIIIlIlIIIlIlIllI <= 0) {
                this.field_194036_d = (this.field_194033_a.hasNext() ? this.field_194033_a.next() : null);
            }
            if (lllllllllllllIIlIIIlIlIIIlIlIllI >= 0) {
                this.field_194037_e = (this.field_194034_b.hasNext() ? this.field_194034_b.next() : null);
            }
            return lllllllllllllIIlIIIlIlIIIlIlIlIl;
        }
    }
}
