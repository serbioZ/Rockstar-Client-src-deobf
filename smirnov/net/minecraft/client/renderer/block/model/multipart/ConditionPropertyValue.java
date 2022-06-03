// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model.multipart;

import java.util.List;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.base.Function;
import net.minecraft.block.state.BlockStateContainer;
import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;
import com.google.common.base.Optional;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;
import net.minecraft.block.properties.IProperty;
import com.google.common.base.Splitter;

public class ConditionPropertyValue implements ICondition
{
    private static final /* synthetic */ Splitter SPLITTER;
    private final /* synthetic */ String value;
    private final /* synthetic */ String key;
    
    private Predicate<IBlockState> makePredicate(final IProperty<?> llllllllllllIlIIlllIlIIIIIlIlIII, final String llllllllllllIlIIlllIlIIIIIlIIlll) {
        final Optional<?> llllllllllllIlIIlllIlIIIIIlIIllI = llllllllllllIlIIlllIlIIIIIlIlIII.parseValue(llllllllllllIlIIlllIlIIIIIlIIlll);
        if (!llllllllllllIlIIlllIlIIIIIlIIllI.isPresent()) {
            throw new RuntimeException(String.valueOf(this.toString()) + ": has an unknown value: " + this.value);
        }
        return (Predicate<IBlockState>)new Predicate<IBlockState>() {
            public boolean apply(@Nullable final IBlockState lllllllllllllllIlllllllIllllIIII) {
                return lllllllllllllllIlllllllIllllIIII != null && lllllllllllllllIlllllllIllllIIII.getValue(llllllllllllIlIIlllIlIIIIIlIlIII).equals(llllllllllllIlIIlllIlIIIIIlIIllI.get());
            }
        };
    }
    
    static {
        SPLITTER = Splitter.on('|').omitEmptyStrings();
    }
    
    public ConditionPropertyValue(final String llllllllllllIlIIlllIlIIIIlIIIlIl, final String llllllllllllIlIIlllIlIIIIlIIIlII) {
        this.key = llllllllllllIlIIlllIlIIIIlIIIlIl;
        this.value = llllllllllllIlIIlllIlIIIIlIIIlII;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("key", (Object)this.key).add("value", (Object)this.value).toString();
    }
    
    @Override
    public Predicate<IBlockState> getPredicate(final BlockStateContainer llllllllllllIlIIlllIlIIIIIlllIll) {
        final IProperty<?> llllllllllllIlIIlllIlIIIIIlllIlI = llllllllllllIlIIlllIlIIIIIlllIll.getProperty(this.key);
        if (llllllllllllIlIIlllIlIIIIIlllIlI == null) {
            throw new RuntimeException(String.valueOf(this.toString()) + ": Definition: " + llllllllllllIlIIlllIlIIIIIlllIll + " has no property: " + this.key);
        }
        String llllllllllllIlIIlllIlIIIIIlllIIl = this.value;
        final boolean llllllllllllIlIIlllIlIIIIIlllIII = !llllllllllllIlIIlllIlIIIIIlllIIl.isEmpty() && llllllllllllIlIIlllIlIIIIIlllIIl.charAt(0) == '!';
        if (llllllllllllIlIIlllIlIIIIIlllIII) {
            llllllllllllIlIIlllIlIIIIIlllIIl = llllllllllllIlIIlllIlIIIIIlllIIl.substring(1);
        }
        final List<String> llllllllllllIlIIlllIlIIIIIllIlll = (List<String>)ConditionPropertyValue.SPLITTER.splitToList((CharSequence)llllllllllllIlIIlllIlIIIIIlllIIl);
        if (llllllllllllIlIIlllIlIIIIIllIlll.isEmpty()) {
            throw new RuntimeException(String.valueOf(this.toString()) + ": has an empty value: " + this.value);
        }
        Predicate<IBlockState> llllllllllllIlIIlllIlIIIIIllIlIl = null;
        if (llllllllllllIlIIlllIlIIIIIllIlll.size() == 1) {
            final Predicate<IBlockState> llllllllllllIlIIlllIlIIIIIllIllI = this.makePredicate(llllllllllllIlIIlllIlIIIIIlllIlI, llllllllllllIlIIlllIlIIIIIlllIIl);
        }
        else {
            llllllllllllIlIIlllIlIIIIIllIlIl = (Predicate<IBlockState>)Predicates.or(Iterables.transform((Iterable)llllllllllllIlIIlllIlIIIIIllIlll, (Function)new Function<String, Predicate<IBlockState>>() {
                @Nullable
                public Predicate<IBlockState> apply(@Nullable final String lllllllllllllllllllIIlIllllllIII) {
                    return ConditionPropertyValue.this.makePredicate(llllllllllllIlIIlllIlIIIIIlllIlI, lllllllllllllllllllIIlIllllllIII);
                }
            }));
        }
        return (Predicate<IBlockState>)(llllllllllllIlIIlllIlIIIIIlllIII ? Predicates.not((Predicate)llllllllllllIlIIlllIlIIIIIllIlIl) : llllllllllllIlIIlllIlIIIIIllIlIl);
    }
}
