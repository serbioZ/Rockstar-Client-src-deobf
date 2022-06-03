// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.properties;

import java.util.Collection;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

public class PropertyBool extends PropertyHelper<Boolean>
{
    private final /* synthetic */ ImmutableSet<Boolean> allowedValues;
    
    @Override
    public boolean equals(final Object lllllllllllllIlIIIlIlIlllIlllIIl) {
        if (this == lllllllllllllIlIIIlIlIlllIlllIIl) {
            return true;
        }
        if (lllllllllllllIlIIIlIlIlllIlllIIl instanceof PropertyBool && super.equals(lllllllllllllIlIIIlIlIlllIlllIIl)) {
            final PropertyBool lllllllllllllIlIIIlIlIlllIlllIII = (PropertyBool)lllllllllllllIlIIIlIlIlllIlllIIl;
            return this.allowedValues.equals((Object)lllllllllllllIlIIIlIlIlllIlllIII.allowedValues);
        }
        return false;
    }
    
    @Override
    public Optional<Boolean> parseValue(final String lllllllllllllIlIIIlIlIllllIIIIll) {
        return (Optional<Boolean>)((!"true".equals(lllllllllllllIlIIIlIlIllllIIIIll) && !"false".equals(lllllllllllllIlIIIlIlIllllIIIIll)) ? Optional.absent() : Optional.of((Object)Boolean.valueOf(lllllllllllllIlIIIlIlIllllIIIIll)));
    }
    
    protected PropertyBool(final String lllllllllllllIlIIIlIlIllllIIllII) {
        super(lllllllllllllIlIIIlIlIllllIIllII, Boolean.class);
        this.allowedValues = (ImmutableSet<Boolean>)ImmutableSet.of((Object)true, (Object)false);
    }
    
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + this.allowedValues.hashCode();
    }
    
    @Override
    public String getName(final Boolean lllllllllllllIlIIIlIlIlllIlllllI) {
        return lllllllllllllIlIIIlIlIlllIlllllI.toString();
    }
    
    public static PropertyBool create(final String lllllllllllllIlIIIlIlIllllIIIllI) {
        return new PropertyBool(lllllllllllllIlIIIlIlIllllIIIllI);
    }
    
    @Override
    public Collection<Boolean> getAllowedValues() {
        return (Collection<Boolean>)this.allowedValues;
    }
}
