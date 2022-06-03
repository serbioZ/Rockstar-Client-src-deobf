// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state.pattern;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import com.google.common.collect.Maps;
import net.minecraft.block.properties.IProperty;
import java.util.Map;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;

public class BlockStateMatcher implements Predicate<IBlockState>
{
    private final /* synthetic */ BlockStateContainer blockstate;
    private final /* synthetic */ Map<IProperty<?>, Predicate<?>> propertyPredicates;
    
    protected <T extends Comparable<T>> boolean matches(final IBlockState llllllllllllIIIIIIIIIIIIIlllIlIl, final IProperty<T> llllllllllllIIIIIIIIIIIIIlllIIIl, final Predicate<T> llllllllllllIIIIIIIIIIIIIlllIIll) {
        return llllllllllllIIIIIIIIIIIIIlllIIll.apply((Object)llllllllllllIIIIIIIIIIIIIlllIlIl.getValue(llllllllllllIIIIIIIIIIIIIlllIIIl));
    }
    
    private BlockStateMatcher(final BlockStateContainer llllllllllllIIIIIIIIIIIIlIIIlIII) {
        this.propertyPredicates = (Map<IProperty<?>, Predicate<?>>)Maps.newHashMap();
        this.blockstate = llllllllllllIIIIIIIIIIIIlIIIlIII;
    }
    
    public static BlockStateMatcher forBlock(final Block llllllllllllIIIIIIIIIIIIlIIIIllI) {
        return new BlockStateMatcher(llllllllllllIIIIIIIIIIIIlIIIIllI.getBlockState());
    }
    
    static {
        ANY = (Predicate)new Predicate<IBlockState>() {
            public boolean apply(@Nullable final IBlockState llllllllllIlllIIIIlIIlIllIlllIIl) {
                return true;
            }
        };
    }
    
    public boolean apply(@Nullable final IBlockState llllllllllllIIIIIIIIIIIIIlllllll) {
        if (llllllllllllIIIIIIIIIIIIIlllllll == null || !llllllllllllIIIIIIIIIIIIIlllllll.getBlock().equals(this.blockstate.getBlock())) {
            return false;
        }
        if (this.propertyPredicates.isEmpty()) {
            return true;
        }
        for (final Map.Entry<IProperty<?>, Predicate<?>> llllllllllllIIIIIIIIIIIIIllllllI : this.propertyPredicates.entrySet()) {
            if (!this.matches(llllllllllllIIIIIIIIIIIIIlllllll, llllllllllllIIIIIIIIIIIIIllllllI.getKey(), llllllllllllIIIIIIIIIIIIIllllllI.getValue())) {
                return false;
            }
        }
        return true;
    }
    
    public <V extends Comparable<V>> BlockStateMatcher where(final IProperty<V> llllllllllllIIIIIIIIIIIIIllIlIll, final Predicate<? extends V> llllllllllllIIIIIIIIIIIIIllIlIlI) {
        if (!this.blockstate.getProperties().contains(llllllllllllIIIIIIIIIIIIIllIlIll)) {
            throw new IllegalArgumentException(this.blockstate + " cannot support property " + llllllllllllIIIIIIIIIIIIIllIlIll);
        }
        this.propertyPredicates.put(llllllllllllIIIIIIIIIIIIIllIlIll, llllllllllllIIIIIIIIIIIIIllIlIlI);
        return this;
    }
}
