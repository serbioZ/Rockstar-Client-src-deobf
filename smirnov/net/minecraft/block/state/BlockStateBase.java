// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.Collection;
import com.google.common.collect.Iterables;
import net.minecraft.block.Block;
import com.google.common.collect.ImmutableTable;
import net.minecraft.block.properties.IProperty;
import java.util.Map;
import com.google.common.base.Function;
import net.minecraft.util.ResourceLocation;
import com.google.common.base.Joiner;

public abstract class BlockStateBase implements IBlockState
{
    private /* synthetic */ int blockStateId;
    private static final /* synthetic */ Joiner COMMA_JOINER;
    private /* synthetic */ ResourceLocation blockLocation;
    private static final /* synthetic */ Function<Map.Entry<IProperty<?>, Comparable<?>>, String> MAP_ENTRY_TO_STRING;
    private /* synthetic */ int metadata;
    private /* synthetic */ int blockId;
    
    public int getMetadata() {
        if (this.metadata < 0) {
            this.metadata = this.getBlock().getMetaFromState(this);
        }
        return this.metadata;
    }
    
    public BlockStateBase() {
        this.blockId = -1;
        this.blockStateId = -1;
        this.metadata = -1;
        this.blockLocation = null;
    }
    
    public ImmutableTable<IProperty<?>, Comparable<?>, IBlockState> getPropertyValueTable() {
        return null;
    }
    
    public ResourceLocation getBlockLocation() {
        if (this.blockLocation == null) {
            this.blockLocation = Block.REGISTRY.getNameForObject(this.getBlock());
        }
        return this.blockLocation;
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllIIllIlIIIIIIIlllIlIII = new StringBuilder();
        lllllllllllIIllIlIIIIIIIlllIlIII.append(Block.REGISTRY.getNameForObject(this.getBlock()));
        if (!this.getProperties().isEmpty()) {
            lllllllllllIIllIlIIIIIIIlllIlIII.append("[");
            BlockStateBase.COMMA_JOINER.appendTo(lllllllllllIIllIlIIIIIIIlllIlIII, Iterables.transform((Iterable)this.getProperties().entrySet(), (Function)BlockStateBase.MAP_ENTRY_TO_STRING));
            lllllllllllIIllIlIIIIIIIlllIlIII.append("]");
        }
        return lllllllllllIIllIlIIIIIIIlllIlIII.toString();
    }
    
    public int getBlockStateId() {
        if (this.blockStateId < 0) {
            this.blockStateId = Block.getStateId(this);
        }
        return this.blockStateId;
    }
    
    protected static <T> T cyclePropertyValue(final Collection<T> lllllllllllIIllIlIIIIIIIllllIIIl, final T lllllllllllIIllIlIIIIIIIllllIIII) {
        final Iterator<T> lllllllllllIIllIlIIIIIIIlllIllll = lllllllllllIIllIlIIIIIIIllllIIIl.iterator();
        while (lllllllllllIIllIlIIIIIIIlllIllll.hasNext()) {
            if (lllllllllllIIllIlIIIIIIIlllIllll.next().equals(lllllllllllIIllIlIIIIIIIllllIIII)) {
                if (lllllllllllIIllIlIIIIIIIlllIllll.hasNext()) {
                    return lllllllllllIIllIlIIIIIIIlllIllll.next();
                }
                return lllllllllllIIllIlIIIIIIIllllIIIl.iterator().next();
            }
        }
        return lllllllllllIIllIlIIIIIIIlllIllll.next();
    }
    
    static {
        COMMA_JOINER = Joiner.on(',');
        MAP_ENTRY_TO_STRING = (Function)new Function<Map.Entry<IProperty<?>, Comparable<?>>, String>() {
            @Nullable
            public String apply(@Nullable final Map.Entry<IProperty<?>, Comparable<?>> lllllllllllIlIIlIllllIIllIllIIIl) {
                if (lllllllllllIlIIlIllllIIllIllIIIl == null) {
                    return "<NULL>";
                }
                final IProperty<?> lllllllllllIlIIlIllllIIllIllIIll = lllllllllllIlIIlIllllIIllIllIIIl.getKey();
                return String.valueOf(lllllllllllIlIIlIllllIIllIllIIll.getName()) + "=" + this.getPropertyName(lllllllllllIlIIlIllllIIllIllIIll, lllllllllllIlIIlIllllIIllIllIIIl.getValue());
            }
            
            private <T extends Comparable<T>> String getPropertyName(final IProperty<T> lllllllllllIlIIlIllllIIllIlIllII, final Comparable<?> lllllllllllIlIIlIllllIIllIlIlIll) {
                return lllllllllllIlIIlIllllIIllIlIllII.getName((T)lllllllllllIlIIlIllllIIllIlIlIll);
            }
        };
    }
    
    @Override
    public <T extends Comparable<T>> IBlockState cycleProperty(final IProperty<T> lllllllllllIIllIlIIIIIIIllllIlIl) {
        return this.withProperty(lllllllllllIIllIlIIIIIIIllllIlIl, (Comparable)cyclePropertyValue((Collection<V>)lllllllllllIIllIlIIIIIIIllllIlIl.getAllowedValues(), (V)this.getValue((IProperty<T>)lllllllllllIIllIlIIIIIIIllllIlIl)));
    }
    
    public int getBlockId() {
        if (this.blockId < 0) {
            this.blockId = Block.getIdFromBlock(this.getBlock());
        }
        return this.blockId;
    }
}
