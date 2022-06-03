// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.properties;

import com.google.common.collect.Maps;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.base.Predicate;
import com.google.common.base.Optional;
import java.util.Collection;
import net.minecraft.util.IStringSerializable;
import java.util.Map;
import com.google.common.collect.ImmutableSet;

public class PropertyEnum<T extends Enum> extends PropertyHelper<T>
{
    private final /* synthetic */ ImmutableSet<T> allowedValues;
    private final /* synthetic */ Map<String, T> nameToValue;
    
    @Override
    public String getName(final T llllllllllllIIIlIllIlIlIlIlIIIll) {
        return ((IStringSerializable)llllllllllllIIIlIllIlIlIlIlIIIll).getName();
    }
    
    @Override
    public boolean equals(final Object llllllllllllIIIlIllIlIlIlIIllIll) {
        if (this == llllllllllllIIIlIllIlIlIlIIllIll) {
            return true;
        }
        if (llllllllllllIIIlIllIlIlIlIIllIll instanceof PropertyEnum && super.equals(llllllllllllIIIlIllIlIlIlIIllIll)) {
            final PropertyEnum<?> llllllllllllIIIlIllIlIlIlIIlllIl = (PropertyEnum<?>)llllllllllllIIIlIllIlIlIlIIllIll;
            return this.allowedValues.equals((Object)llllllllllllIIIlIllIlIlIlIIlllIl.allowedValues) && this.nameToValue.equals(llllllllllllIIIlIllIlIlIlIIlllIl.nameToValue);
        }
        return false;
    }
    
    public static <T extends java.lang.Enum> PropertyEnum<T> create(final String llllllllllllIIIlIllIlIlIIlllIlIl, final Class<T> llllllllllllIIIlIllIlIlIIlllIlll, final Collection<T> llllllllllllIIIlIllIlIlIIlllIllI) {
        return new PropertyEnum<T>(llllllllllllIIIlIllIlIlIIlllIlIl, llllllllllllIIIlIllIlIlIIlllIlll, llllllllllllIIIlIllIlIlIIlllIllI);
    }
    
    @Override
    public int hashCode() {
        int llllllllllllIIIlIllIlIlIlIIlIllI = super.hashCode();
        llllllllllllIIIlIllIlIlIlIIlIllI = 31 * llllllllllllIIIlIllIlIlIlIIlIllI + this.allowedValues.hashCode();
        llllllllllllIIIlIllIlIlIlIIlIllI = 31 * llllllllllllIIIlIllIlIlIlIIlIllI + this.nameToValue.hashCode();
        return llllllllllllIIIlIllIlIlIlIIlIllI;
    }
    
    @Override
    public Optional<T> parseValue(final String llllllllllllIIIlIllIlIlIlIlIIlll) {
        return (Optional<T>)Optional.fromNullable((Object)this.nameToValue.get(llllllllllllIIIlIllIlIlIlIlIIlll));
    }
    
    public static <T extends java.lang.Enum> PropertyEnum<T> create(final String llllllllllllIIIlIllIlIlIlIIIIlll, final Class<T> llllllllllllIIIlIllIlIlIlIIIlIIl, final Predicate<T> llllllllllllIIIlIllIlIlIlIIIIlIl) {
        return create(llllllllllllIIIlIllIlIlIlIIIIlll, llllllllllllIIIlIllIlIlIlIIIlIIl, Collections2.filter((Collection)Lists.newArrayList((Object[])llllllllllllIIIlIllIlIlIlIIIlIIl.getEnumConstants()), (Predicate)llllllllllllIIIlIllIlIlIlIIIIlIl));
    }
    
    public static <T extends java.lang.Enum> PropertyEnum<T> create(final String llllllllllllIIIlIllIlIlIlIIIllll, final Class<T> llllllllllllIIIlIllIlIlIlIIlIIII) {
        return create(llllllllllllIIIlIllIlIlIlIIIllll, llllllllllllIIIlIllIlIlIlIIlIIII, (com.google.common.base.Predicate<T>)Predicates.alwaysTrue());
    }
    
    public static <T extends java.lang.Enum> PropertyEnum<T> create(final String llllllllllllIIIlIllIlIlIlIIIIIIl, final Class<T> llllllllllllIIIlIllIlIlIIlllllIl, final T... llllllllllllIIIlIllIlIlIIlllllll) {
        return create(llllllllllllIIIlIllIlIlIlIIIIIIl, llllllllllllIIIlIllIlIlIIlllllIl, Lists.newArrayList((Object[])llllllllllllIIIlIllIlIlIIlllllll));
    }
    
    @Override
    public Collection<T> getAllowedValues() {
        return (Collection<T>)this.allowedValues;
    }
    
    protected PropertyEnum(final String llllllllllllIIIlIllIlIlIlIllIlIl, final Class<T> llllllllllllIIIlIllIlIlIlIllIlII, final Collection<T> llllllllllllIIIlIllIlIlIlIlllIIl) {
        super(llllllllllllIIIlIllIlIlIlIllIlIl, llllllllllllIIIlIllIlIlIlIllIlII);
        this.nameToValue = (Map<String, T>)Maps.newHashMap();
        this.allowedValues = (ImmutableSet<T>)ImmutableSet.copyOf((Collection)llllllllllllIIIlIllIlIlIlIlllIIl);
        for (final T llllllllllllIIIlIllIlIlIlIlllIII : llllllllllllIIIlIllIlIlIlIlllIIl) {
            final String llllllllllllIIIlIllIlIlIlIllIlll = ((IStringSerializable)llllllllllllIIIlIllIlIlIlIlllIII).getName();
            if (this.nameToValue.containsKey(llllllllllllIIIlIllIlIlIlIllIlll)) {
                throw new IllegalArgumentException("Multiple values have the same name '" + llllllllllllIIIlIllIlIlIlIllIlll + "'");
            }
            this.nameToValue.put(llllllllllllIIIlIllIlIlIlIllIlll, llllllllllllIIIlIllIlIlIlIlllIII);
        }
    }
}
