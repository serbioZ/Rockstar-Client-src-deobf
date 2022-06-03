// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event;

import java.util.Iterator;

public class ArrayHelper<T> implements Iterable<T>
{
    private /* synthetic */ T[] elements;
    
    public void set(final T[] llllllllllllIllllIlIIlIIIIIlIIlI) {
        this.elements = llllllllllllIllllIlIIlIIIIIlIIlI;
    }
    
    public ArrayHelper(final T[] llllllllllllIllllIlIIlIIIlIlIIII) {
        this.elements = llllllllllllIllllIlIIlIIIlIlIIII;
    }
    
    public ArrayHelper() {
        this.elements = (T[])new Object[0];
    }
    
    public void clear() {
        this.elements = (T[])new Object[0];
    }
    
    public T[] array() {
        return this.elements;
    }
    
    public int size() {
        return this.array().length;
    }
    
    public T get(final int llllllllllllIllllIlIIlIIIIIIlllI) {
        return this.array()[llllllllllllIllllIlIIlIIIIIIlllI];
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public boolean contains(final T llllllllllllIllllIlIIlIIIIllIlll) {
        Object[] llllllllllllIllllIlIIlIIIIllIllI;
        for (int llllllllllllIllllIlIIlIIIIllIlIl = (llllllllllllIllllIlIIlIIIIllIllI = this.array()).length, llllllllllllIllllIlIIlIIIIllIlII = 0; llllllllllllIllllIlIIlIIIIllIlII < llllllllllllIllllIlIIlIIIIllIlIl; ++llllllllllllIllllIlIIlIIIIllIlII) {
            final T llllllllllllIllllIlIIlIIIIllIIll = (T)llllllllllllIllllIlIIlIIIIllIllI[llllllllllllIllllIlIIlIIIIllIlII];
            if (llllllllllllIllllIlIIlIIIIllIIll.equals(llllllllllllIllllIlIIlIIIIllIlll)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private /* synthetic */ int index = 0;
            
            @Override
            public boolean hasNext() {
                return this.index < ArrayHelper.this.size() && ArrayHelper.this.get(this.index) != null;
            }
            
            @Override
            public T next() {
                return ArrayHelper.this.get(this.index++);
            }
            
            @Override
            public void remove() {
                ArrayHelper.this.remove(ArrayHelper.this.get(this.index));
            }
        };
    }
    
    public void add(final T llllllllllllIllllIlIIlIIIlIIIIIl) {
        if (llllllllllllIllllIlIIlIIIlIIIIIl != null) {
            final Object[] llllllllllllIllllIlIIlIIIlIIIlII = new Object[this.size() + 1];
            for (int llllllllllllIllllIlIIlIIIlIIIIll = 0; llllllllllllIllllIlIIlIIIlIIIIll < llllllllllllIllllIlIIlIIIlIIIlII.length; ++llllllllllllIllllIlIIlIIIlIIIIll) {
                if (llllllllllllIllllIlIIlIIIlIIIIll < this.size()) {
                    llllllllllllIllllIlIIlIIIlIIIlII[llllllllllllIllllIlIIlIIIlIIIIll] = this.get(llllllllllllIllllIlIIlIIIlIIIIll);
                }
                else {
                    llllllllllllIllllIlIIlIIIlIIIlII[llllllllllllIllllIlIIlIIIlIIIIll] = llllllllllllIllllIlIIlIIIlIIIIIl;
                }
            }
            this.set(llllllllllllIllllIlIIlIIIlIIIlII);
        }
    }
    
    public void remove(final T llllllllllllIllllIlIIlIIIIlIIIIl) {
        if (this.contains(llllllllllllIllllIlIIlIIIIlIIIIl)) {
            final Object[] llllllllllllIllllIlIIlIIIIlIIlIl = new Object[this.size() - 1];
            boolean llllllllllllIllllIlIIlIIIIlIIlII = true;
            for (int llllllllllllIllllIlIIlIIIIlIIIll = 0; llllllllllllIllllIlIIlIIIIlIIIll < this.size(); ++llllllllllllIllllIlIIlIIIIlIIIll) {
                if (llllllllllllIllllIlIIlIIIIlIIlII && this.get(llllllllllllIllllIlIIlIIIIlIIIll).equals(llllllllllllIllllIlIIlIIIIlIIIIl)) {
                    llllllllllllIllllIlIIlIIIIlIIlII = false;
                }
                else {
                    llllllllllllIllllIlIIlIIIIlIIlIl[llllllllllllIllllIlIIlIIIIlIIlII ? llllllllllllIllllIlIIlIIIIlIIIll : (llllllllllllIllllIlIIlIIIIlIIIll - 1)] = this.get(llllllllllllIllllIlIIlIIIIlIIIll);
                }
            }
            this.set(llllllllllllIllllIlIIlIIIIlIIlIl);
        }
    }
}
