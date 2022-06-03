// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.statemap;

import java.util.Collection;
import java.util.Collections;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import javax.annotation.Nullable;
import java.util.Map;
import net.minecraft.block.properties.IProperty;
import java.util.List;

public class StateMap extends StateMapperBase
{
    private final /* synthetic */ String suffix;
    private final /* synthetic */ List<IProperty<?>> ignored;
    private final /* synthetic */ IProperty<?> name;
    
    private <T extends Comparable<T>> String removeName(final IProperty<T> lllllllllllllIIIIllIIlllIIllllll, final Map<IProperty<?>, Comparable<?>> lllllllllllllIIIIllIIlllIlIIIIIl) {
        return lllllllllllllIIIIllIIlllIIllllll.getName((T)lllllllllllllIIIIllIIlllIlIIIIIl.remove(this.name));
    }
    
    private StateMap(@Nullable final IProperty<?> lllllllllllllIIIIllIIlllIlIllIll, @Nullable final String lllllllllllllIIIIllIIlllIlIllllI, final List<IProperty<?>> lllllllllllllIIIIllIIlllIlIllIIl) {
        this.name = lllllllllllllIIIIllIIlllIlIllIll;
        this.suffix = lllllllllllllIIIIllIIlllIlIllllI;
        this.ignored = lllllllllllllIIIIllIIlllIlIllIIl;
    }
    
    @Override
    protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllllIIIIllIIlllIlIIlIll) {
        final Map<IProperty<?>, Comparable<?>> lllllllllllllIIIIllIIlllIlIlIIII = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)lllllllllllllIIIIllIIlllIlIIlIll.getProperties());
        String lllllllllllllIIIIllIIlllIlIIlllI = null;
        if (this.name == null) {
            final String lllllllllllllIIIIllIIlllIlIIllll = Block.REGISTRY.getNameForObject(lllllllllllllIIIIllIIlllIlIIlIll.getBlock()).toString();
        }
        else {
            lllllllllllllIIIIllIIlllIlIIlllI = this.removeName(this.name, lllllllllllllIIIIllIIlllIlIlIIII);
        }
        if (this.suffix != null) {
            lllllllllllllIIIIllIIlllIlIIlllI = String.valueOf(lllllllllllllIIIIllIIlllIlIIlllI) + this.suffix;
        }
        for (final IProperty<?> lllllllllllllIIIIllIIlllIlIIllIl : this.ignored) {
            lllllllllllllIIIIllIIlllIlIlIIII.remove(lllllllllllllIIIIllIIlllIlIIllIl);
        }
        return new ModelResourceLocation(lllllllllllllIIIIllIIlllIlIIlllI, this.getPropertyString(lllllllllllllIIIIllIIlllIlIlIIII));
    }
    
    public static class Builder
    {
        private /* synthetic */ IProperty<?> name;
        private /* synthetic */ String suffix;
        private final /* synthetic */ List<IProperty<?>> ignored;
        
        public Builder() {
            this.ignored = (List<IProperty<?>>)Lists.newArrayList();
        }
        
        public Builder ignore(final IProperty<?>... lllllllllllIIllIIllIlllIllIIIIlI) {
            Collections.addAll(this.ignored, lllllllllllIIllIIllIlllIllIIIIlI);
            return this;
        }
        
        public Builder withSuffix(final String lllllllllllIIllIIllIlllIllIIlIlI) {
            this.suffix = lllllllllllIIllIIllIlllIllIIlIlI;
            return this;
        }
        
        public Builder withName(final IProperty<?> lllllllllllIIllIIllIlllIllIIlllI) {
            this.name = lllllllllllIIllIIllIlllIllIIlllI;
            return this;
        }
        
        public StateMap build() {
            return new StateMap(this.name, this.suffix, this.ignored, null);
        }
    }
}
