// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model.multipart;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import javax.annotation.Nullable;
import com.google.common.base.Function;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;
import net.minecraft.block.state.BlockStateContainer;

public class ConditionOr implements ICondition
{
    final /* synthetic */ Iterable<ICondition> conditions;
    
    @Override
    public Predicate<IBlockState> getPredicate(final BlockStateContainer llllllllllllIIIIllIIIlIlllllIlIl) {
        return (Predicate<IBlockState>)Predicates.or(Iterables.transform((Iterable)this.conditions, (Function)new Function<ICondition, Predicate<IBlockState>>() {
            @Nullable
            public Predicate<IBlockState> apply(@Nullable final ICondition lllllllllllllIlIIIIIllllIIIIIlIl) {
                return (lllllllllllllIlIIIIIllllIIIIIlIl == null) ? null : lllllllllllllIlIIIIIllllIIIIIlIl.getPredicate(llllllllllllIIIIllIIIlIlllllIlIl);
            }
        }));
    }
    
    public ConditionOr(final Iterable<ICondition> llllllllllllIIIIllIIIlIllllllIIl) {
        this.conditions = llllllllllllIIIIllIIIlIllllllIIl;
    }
}
