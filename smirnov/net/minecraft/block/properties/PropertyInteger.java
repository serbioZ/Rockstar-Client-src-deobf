// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.properties;

import java.util.Set;
import java.util.Collection;
import com.google.common.collect.Sets;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

public class PropertyInteger extends PropertyHelper<Integer>
{
    private final /* synthetic */ ImmutableSet<Integer> allowedValues;
    
    @Override
    public Optional<Integer> parseValue(final String lllllllllllIllIIIllIlllIllIIlIlI) {
        try {
            final Integer lllllllllllIllIIIllIlllIllIIllIl = Integer.valueOf(lllllllllllIllIIIllIlllIllIIlIlI);
            return (Optional<Integer>)(this.allowedValues.contains((Object)lllllllllllIllIIIllIlllIllIIllIl) ? Optional.of((Object)lllllllllllIllIIIllIlllIllIIllIl) : Optional.absent());
        }
        catch (NumberFormatException lllllllllllIllIIIllIlllIllIIllII) {
            return (Optional<Integer>)Optional.absent();
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllIllIIIllIlllIlllIIIll) {
        if (this == lllllllllllIllIIIllIlllIlllIIIll) {
            return true;
        }
        if (lllllllllllIllIIIllIlllIlllIIIll instanceof PropertyInteger && super.equals(lllllllllllIllIIIllIlllIlllIIIll)) {
            final PropertyInteger lllllllllllIllIIIllIlllIlllIIIlI = (PropertyInteger)lllllllllllIllIIIllIlllIlllIIIll;
            return this.allowedValues.equals((Object)lllllllllllIllIIIllIlllIlllIIIlI.allowedValues);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + this.allowedValues.hashCode();
    }
    
    @Override
    public String getName(final Integer lllllllllllIllIIIllIlllIllIIIllI) {
        return lllllllllllIllIIIllIlllIllIIIllI.toString();
    }
    
    public static PropertyInteger create(final String lllllllllllIllIIIllIlllIllIllIII, final int lllllllllllIllIIIllIlllIllIlIlII, final int lllllllllllIllIIIllIlllIllIlIIll) {
        return new PropertyInteger(lllllllllllIllIIIllIlllIllIllIII, lllllllllllIllIIIllIlllIllIlIlII, lllllllllllIllIIIllIlllIllIlIIll);
    }
    
    protected PropertyInteger(final String lllllllllllIllIIIllIlllIlllIllll, final int lllllllllllIllIIIllIlllIllllIlII, final int lllllllllllIllIIIllIlllIllllIIll) {
        super(lllllllllllIllIIIllIlllIlllIllll, Integer.class);
        if (lllllllllllIllIIIllIlllIllllIlII < 0) {
            throw new IllegalArgumentException("Min value of " + lllllllllllIllIIIllIlllIlllIllll + " must be 0 or greater");
        }
        if (lllllllllllIllIIIllIlllIllllIIll <= lllllllllllIllIIIllIlllIllllIlII) {
            throw new IllegalArgumentException("Max value of " + lllllllllllIllIIIllIlllIlllIllll + " must be greater than min (" + lllllllllllIllIIIllIlllIllllIlII + ")");
        }
        final Set<Integer> lllllllllllIllIIIllIlllIllllIIlI = (Set<Integer>)Sets.newHashSet();
        for (int lllllllllllIllIIIllIlllIllllIIIl = lllllllllllIllIIIllIlllIllllIlII; lllllllllllIllIIIllIlllIllllIIIl <= lllllllllllIllIIIllIlllIllllIIll; ++lllllllllllIllIIIllIlllIllllIIIl) {
            lllllllllllIllIIIllIlllIllllIIlI.add(lllllllllllIllIIIllIlllIllllIIIl);
        }
        this.allowedValues = (ImmutableSet<Integer>)ImmutableSet.copyOf((Collection)lllllllllllIllIIIllIlllIllllIIlI);
    }
    
    @Override
    public Collection<Integer> getAllowedValues() {
        return (Collection<Integer>)this.allowedValues;
    }
}
