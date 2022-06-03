// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.properties;

import com.google.common.base.Predicates;
import java.util.Collection;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.base.Predicate;
import net.minecraft.util.EnumFacing;

public class PropertyDirection extends PropertyEnum<EnumFacing>
{
    public static PropertyDirection create(final String llllllllllIlllllIlllIlIIlIIIllIl, final Predicate<EnumFacing> llllllllllIlllllIlllIlIIlIIIllII) {
        return create(llllllllllIlllllIlllIlIIlIIIllIl, Collections2.filter((Collection)Lists.newArrayList((Object[])EnumFacing.values()), (Predicate)llllllllllIlllllIlllIlIIlIIIllII));
    }
    
    protected PropertyDirection(final String llllllllllIlllllIlllIlIIlIIllIIl, final Collection<EnumFacing> llllllllllIlllllIlllIlIIlIIlIlIl) {
        super(llllllllllIlllllIlllIlIIlIIllIIl, EnumFacing.class, llllllllllIlllllIlllIlIIlIIlIlIl);
    }
    
    public static PropertyDirection create(final String llllllllllIlllllIlllIlIIlIIIIlll, final Collection<EnumFacing> llllllllllIlllllIlllIlIIlIIIIllI) {
        return new PropertyDirection(llllllllllIlllllIlllIlIIlIIIIlll, llllllllllIlllllIlllIlIIlIIIIllI);
    }
    
    public static PropertyDirection create(final String llllllllllIlllllIlllIlIIlIIlIIll) {
        return create(llllllllllIlllllIlllIlIIlIIlIIll, (Predicate<EnumFacing>)Predicates.alwaysTrue());
    }
}
