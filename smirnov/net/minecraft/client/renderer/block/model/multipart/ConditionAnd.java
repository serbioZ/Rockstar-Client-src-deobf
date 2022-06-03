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

public class ConditionAnd implements ICondition
{
    private final /* synthetic */ Iterable<ICondition> conditions;
    
    public ConditionAnd(final Iterable<ICondition> lllllllllllIIllIIIllIlIIlIIIIlll) {
        this.conditions = lllllllllllIIllIIIllIlIIlIIIIlll;
    }
    
    @Override
    public Predicate<IBlockState> getPredicate(final BlockStateContainer lllllllllllIIllIIIllIlIIIlllllll) {
        return (Predicate<IBlockState>)Predicates.and(Iterables.transform((Iterable)this.conditions, (Function)new Function<ICondition, Predicate<IBlockState>>() {
            @Nullable
            public Predicate<IBlockState> apply(@Nullable final ICondition lllllllllllIIIIlIlIIlIIllIIIllII) {
                return (lllllllllllIIIIlIlIIlIIllIIIllII == null) ? null : lllllllllllIIIIlIlIIlIIllIIIllII.getPredicate(lllllllllllIIllIIIllIlIIIlllllll);
            }
        }));
    }
}
