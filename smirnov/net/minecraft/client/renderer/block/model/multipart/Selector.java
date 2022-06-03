// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model.multipart;

import com.google.common.annotations.VisibleForTesting;
import java.util.Set;
import net.minecraft.util.JsonUtils;
import com.google.common.collect.Iterables;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import java.util.Map;
import com.google.gson.JsonElement;
import com.google.common.base.Function;
import com.google.gson.JsonDeserializer;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.client.renderer.block.model.VariantList;

public class Selector
{
    private final /* synthetic */ VariantList variantList;
    private final /* synthetic */ ICondition condition;
    
    @Override
    public int hashCode() {
        return 31 * this.condition.hashCode() + this.variantList.hashCode();
    }
    
    public Selector(final ICondition lllllllllllIlIIIIIIlllIIlIlIIlII, final VariantList lllllllllllIlIIIIIIlllIIlIlIIIll) {
        if (lllllllllllIlIIIIIIlllIIlIlIIlII == null) {
            throw new IllegalArgumentException("Missing condition for selector");
        }
        if (lllllllllllIlIIIIIIlllIIlIlIIIll == null) {
            throw new IllegalArgumentException("Missing variant for selector");
        }
        this.condition = lllllllllllIlIIIIIIlllIIlIlIIlII;
        this.variantList = lllllllllllIlIIIIIIlllIIlIlIIIll;
    }
    
    public Predicate<IBlockState> getPredicate(final BlockStateContainer lllllllllllIlIIIIIIlllIIlIIlllII) {
        return this.condition.getPredicate(lllllllllllIlIIIIIIlllIIlIIlllII);
    }
    
    @Override
    public boolean equals(final Object lllllllllllIlIIIIIIlllIIlIIlIIlI) {
        if (this == lllllllllllIlIIIIIIlllIIlIIlIIlI) {
            return true;
        }
        if (lllllllllllIlIIIIIIlllIIlIIlIIlI instanceof Selector) {
            final Selector lllllllllllIlIIIIIIlllIIlIIlIlII = (Selector)lllllllllllIlIIIIIIlllIIlIIlIIlI;
            if (this.condition.equals(lllllllllllIlIIIIIIlllIIlIIlIlII.condition)) {
                return this.variantList.equals(lllllllllllIlIIIIIIlllIIlIIlIlII.variantList);
            }
        }
        return false;
    }
    
    public VariantList getVariantList() {
        return this.variantList;
    }
    
    public static class Deserializer implements JsonDeserializer<Selector>
    {
        private static final /* synthetic */ Function<JsonElement, ICondition> FUNCTION_OR_AND;
        private static final /* synthetic */ Function<Map.Entry<String, JsonElement>, ICondition> FUNCTION_PROPERTY_VALUE;
        
        static {
            FUNCTION_OR_AND = (Function)new Function<JsonElement, ICondition>() {
                @Nullable
                public ICondition apply(@Nullable final JsonElement lllllllllllIIIIlIIIIIIIIIlIIIIll) {
                    return (lllllllllllIIIIlIIIIIIIIIlIIIIll == null) ? null : Deserializer.getOrAndCondition(lllllllllllIIIIlIIIIIIIIIlIIIIll.getAsJsonObject());
                }
            };
            FUNCTION_PROPERTY_VALUE = (Function)new Function<Map.Entry<String, JsonElement>, ICondition>() {
                @Nullable
                public ICondition apply(@Nullable final Map.Entry<String, JsonElement> llllllllllllIllIllIllIIllIIlIIIl) {
                    return (llllllllllllIllIllIllIIllIIlIIIl == null) ? null : makePropertyValue(llllllllllllIllIllIllIIllIIlIIIl);
                }
            };
        }
        
        public Selector deserialize(final JsonElement lllllllllllllllIIIIlllIIIllIllll, final Type lllllllllllllllIIIIlllIIIllIlllI, final JsonDeserializationContext lllllllllllllllIIIIlllIIIllIllIl) throws JsonParseException {
            final JsonObject lllllllllllllllIIIIlllIIIllIllII = lllllllllllllllIIIIlllIIIllIllll.getAsJsonObject();
            return new Selector(this.getWhenCondition(lllllllllllllllIIIIlllIIIllIllII), (VariantList)lllllllllllllllIIIIlllIIIllIllIl.deserialize(lllllllllllllllIIIIlllIIIllIllII.get("apply"), (Type)VariantList.class));
        }
        
        @VisibleForTesting
        static ICondition getOrAndCondition(final JsonObject lllllllllllllllIIIIlllIIIllIIIIl) {
            final Set<Map.Entry<String, JsonElement>> lllllllllllllllIIIIlllIIIllIIIII = (Set<Map.Entry<String, JsonElement>>)lllllllllllllllIIIIlllIIIllIIIIl.entrySet();
            if (lllllllllllllllIIIIlllIIIllIIIII.isEmpty()) {
                throw new JsonParseException("No elements found in selector");
            }
            if (lllllllllllllllIIIIlllIIIllIIIII.size() != 1) {
                return new ConditionAnd(Iterables.transform((Iterable)lllllllllllllllIIIIlllIIIllIIIII, (Function)Deserializer.FUNCTION_PROPERTY_VALUE));
            }
            if (lllllllllllllllIIIIlllIIIllIIIIl.has("OR")) {
                return new ConditionOr(Iterables.transform((Iterable)JsonUtils.getJsonArray(lllllllllllllllIIIIlllIIIllIIIIl, "OR"), (Function)Deserializer.FUNCTION_OR_AND));
            }
            return lllllllllllllllIIIIlllIIIllIIIIl.has("AND") ? new ConditionAnd(Iterables.transform((Iterable)JsonUtils.getJsonArray(lllllllllllllllIIIIlllIIIllIIIIl, "AND"), (Function)Deserializer.FUNCTION_OR_AND)) : makePropertyValue(lllllllllllllllIIIIlllIIIllIIIII.iterator().next());
        }
        
        private ICondition getWhenCondition(final JsonObject lllllllllllllllIIIIlllIIIllIIlII) {
            return lllllllllllllllIIIIlllIIIllIIlII.has("when") ? getOrAndCondition(JsonUtils.getJsonObject(lllllllllllllllIIIIlllIIIllIIlII, "when")) : ICondition.TRUE;
        }
        
        private static ConditionPropertyValue makePropertyValue(final Map.Entry<String, JsonElement> lllllllllllllllIIIIlllIIIlIllIll) {
            return new ConditionPropertyValue(lllllllllllllllIIIIlllIIIlIllIll.getKey(), lllllllllllllllIIIIlllIIIlIllIll.getValue().getAsString());
        }
    }
}
