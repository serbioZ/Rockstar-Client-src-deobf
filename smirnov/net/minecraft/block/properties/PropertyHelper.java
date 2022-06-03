// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.properties;

import com.google.common.base.MoreObjects;

public abstract class PropertyHelper<T extends Comparable<T>> implements IProperty<T>
{
    private final /* synthetic */ String name;
    private final /* synthetic */ Class<T> valueClass;
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("name", (Object)this.name).add("clazz", (Object)this.valueClass).add("values", (Object)this.getAllowedValues()).toString();
    }
    
    @Override
    public boolean equals(final Object lllllllllllIllIlIIIIIlllIIlIlIIl) {
        if (this == lllllllllllIllIlIIIIIlllIIlIlIIl) {
            return true;
        }
        if (!(lllllllllllIllIlIIIIIlllIIlIlIIl instanceof PropertyHelper)) {
            return false;
        }
        final PropertyHelper<?> lllllllllllIllIlIIIIIlllIIlIlIII = (PropertyHelper<?>)lllllllllllIllIlIIIIIlllIIlIlIIl;
        return this.valueClass.equals(lllllllllllIllIlIIIIIlllIIlIlIII.valueClass) && this.name.equals(lllllllllllIllIlIIIIIlllIIlIlIII.name);
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.valueClass.hashCode() + this.name.hashCode();
    }
    
    @Override
    public Class<T> getValueClass() {
        return this.valueClass;
    }
    
    protected PropertyHelper(final String lllllllllllIllIlIIIIIlllIIlllIll, final Class<T> lllllllllllIllIlIIIIIlllIIlllIlI) {
        this.valueClass = lllllllllllIllIlIIIIIlllIIlllIlI;
        this.name = lllllllllllIllIlIIIIIlllIIlllIll;
    }
}
