// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.datasync;

public class DataParameter<T>
{
    private final /* synthetic */ DataSerializer<T> serializer;
    private final /* synthetic */ int id;
    
    public DataParameter(final int lllllllllllIIIllIIIllIIlIlllIlll, final DataSerializer<T> lllllllllllIIIllIIIllIIlIllllIIl) {
        this.id = lllllllllllIIIllIIIllIIlIlllIlll;
        this.serializer = lllllllllllIIIllIIIllIIlIllllIIl;
    }
    
    @Override
    public boolean equals(final Object lllllllllllIIIllIIIllIIlIllIlIII) {
        if (this == lllllllllllIIIllIIIllIIlIllIlIII) {
            return true;
        }
        if (lllllllllllIIIllIIIllIIlIllIlIII != null && this.getClass() == lllllllllllIIIllIIIllIIlIllIlIII.getClass()) {
            final DataParameter<?> lllllllllllIIIllIIIllIIlIllIlIlI = (DataParameter<?>)lllllllllllIIIllIIIllIIlIllIlIII;
            return this.id == lllllllllllIIIllIIIllIIlIllIlIlI.id;
        }
        return false;
    }
    
    public int getId() {
        return this.id;
    }
    
    public DataSerializer<T> getSerializer() {
        return this.serializer;
    }
    
    @Override
    public int hashCode() {
        return this.id;
    }
}
