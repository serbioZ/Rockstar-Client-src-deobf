// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model.multipart;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializer;
import com.google.common.collect.Sets;
import net.minecraft.client.renderer.block.model.VariantList;
import java.util.Set;
import java.util.List;
import net.minecraft.block.state.BlockStateContainer;

public class Multipart
{
    private /* synthetic */ BlockStateContainer stateContainer;
    private final /* synthetic */ List<Selector> selectors;
    
    public BlockStateContainer getStateContainer() {
        return this.stateContainer;
    }
    
    @Override
    public boolean equals(final Object lllllllllllIlllIIlllIllIIlllIIII) {
        if (this == lllllllllllIlllIIlllIllIIlllIIII) {
            return true;
        }
        if (lllllllllllIlllIIlllIllIIlllIIII instanceof Multipart) {
            final Multipart lllllllllllIlllIIlllIllIIllIllll = (Multipart)lllllllllllIlllIIlllIllIIlllIIII;
            if (this.selectors.equals(lllllllllllIlllIIlllIllIIllIllll.selectors)) {
                if (this.stateContainer == null) {
                    return lllllllllllIlllIIlllIllIIllIllll.stateContainer == null;
                }
                return this.stateContainer.equals(lllllllllllIlllIIlllIllIIllIllll.stateContainer);
            }
        }
        return false;
    }
    
    public void setStateContainer(final BlockStateContainer lllllllllllIlllIIlllIllIIllllIII) {
        this.stateContainer = lllllllllllIlllIIlllIllIIllllIII;
    }
    
    public List<Selector> getSelectors() {
        return this.selectors;
    }
    
    public Multipart(final List<Selector> lllllllllllIlllIIlllIllIlIIIllII) {
        this.selectors = lllllllllllIlllIIlllIllIlIIIllII;
    }
    
    public Set<VariantList> getVariants() {
        final Set<VariantList> lllllllllllIlllIIlllIllIlIIIIIll = (Set<VariantList>)Sets.newHashSet();
        for (final Selector lllllllllllIlllIIlllIllIlIIIIIlI : this.selectors) {
            lllllllllllIlllIIlllIllIlIIIIIll.add(lllllllllllIlllIIlllIllIlIIIIIlI.getVariantList());
        }
        return lllllllllllIlllIIlllIllIlIIIIIll;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.selectors.hashCode() + ((this.stateContainer == null) ? 0 : this.stateContainer.hashCode());
    }
    
    public static class Deserializer implements JsonDeserializer<Multipart>
    {
        public Multipart deserialize(final JsonElement lllllllllllllIIIlIIlllIlIIlIIIll, final Type lllllllllllllIIIlIIlllIlIIlIIIlI, final JsonDeserializationContext lllllllllllllIIIlIIlllIlIIlIIIIl) throws JsonParseException {
            return new Multipart(this.getSelectors(lllllllllllllIIIlIIlllIlIIlIIIIl, lllllllllllllIIIlIIlllIlIIlIIIll.getAsJsonArray()));
        }
        
        private List<Selector> getSelectors(final JsonDeserializationContext lllllllllllllIIIlIIlllIlIIIlIIll, final JsonArray lllllllllllllIIIlIIlllIlIIIlIIlI) {
            final List<Selector> lllllllllllllIIIlIIlllIlIIIlIlIl = (List<Selector>)Lists.newArrayList();
            for (final JsonElement lllllllllllllIIIlIIlllIlIIIlIlII : lllllllllllllIIIlIIlllIlIIIlIIlI) {
                lllllllllllllIIIlIIlllIlIIIlIlIl.add((Selector)lllllllllllllIIIlIIlllIlIIIlIIll.deserialize(lllllllllllllIIIlIIlllIlIIIlIlII, (Type)Selector.class));
            }
            return lllllllllllllIIIlIIlllIlIIIlIlIl;
        }
    }
}
