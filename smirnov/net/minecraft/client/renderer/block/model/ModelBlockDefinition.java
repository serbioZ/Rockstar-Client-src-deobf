// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import javax.annotation.Nullable;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializer;
import net.minecraft.client.renderer.block.model.multipart.Selector;
import java.lang.reflect.Type;
import com.google.gson.GsonBuilder;
import net.minecraft.util.JsonUtils;
import java.io.Reader;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Collection;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.client.renderer.block.model.multipart.Multipart;
import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;
import java.util.Map;

public class ModelBlockDefinition
{
    private final /* synthetic */ Map<String, VariantList> mapVariants;
    @VisibleForTesting
    static final /* synthetic */ Gson GSON;
    private /* synthetic */ Multipart multipart;
    
    public Set<VariantList> getMultipartVariants() {
        final Set<VariantList> lllllllllllIllIlIIlllIIlIIlIIlII = (Set<VariantList>)Sets.newHashSet((Iterable)this.mapVariants.values());
        if (this.hasMultipartData()) {
            lllllllllllIllIlIIlllIIlIIlIIlII.addAll(this.multipart.getVariants());
        }
        return lllllllllllIllIlIIlllIIlIIlIIlII;
    }
    
    public VariantList getVariant(final String lllllllllllIllIlIIlllIIlIIllIlIl) {
        final VariantList lllllllllllIllIlIIlllIIlIIllIlll = this.mapVariants.get(lllllllllllIllIlIIlllIIlIIllIlIl);
        if (lllllllllllIllIlIIlllIIlIIllIlll == null) {
            throw new MissingVariantException();
        }
        return lllllllllllIllIlIIlllIIlIIllIlll;
    }
    
    public ModelBlockDefinition(final List<ModelBlockDefinition> lllllllllllIllIlIIlllIIlIlIIlIlI) {
        this.mapVariants = (Map<String, VariantList>)Maps.newHashMap();
        ModelBlockDefinition lllllllllllIllIlIIlllIIlIlIIlIIl = null;
        for (final ModelBlockDefinition lllllllllllIllIlIIlllIIlIlIIlIII : lllllllllllIllIlIIlllIIlIlIIlIlI) {
            if (lllllllllllIllIlIIlllIIlIlIIlIII.hasMultipartData()) {
                this.mapVariants.clear();
                lllllllllllIllIlIIlllIIlIlIIlIIl = lllllllllllIllIlIIlllIIlIlIIlIII;
            }
            this.mapVariants.putAll(lllllllllllIllIlIIlllIIlIlIIlIII.mapVariants);
        }
        if (lllllllllllIllIlIIlllIIlIlIIlIIl != null) {
            this.multipart = lllllllllllIllIlIIlllIIlIlIIlIIl.multipart;
        }
    }
    
    public boolean hasVariant(final String lllllllllllIllIlIIlllIIlIIllllIl) {
        return this.mapVariants.get(lllllllllllIllIlIIlllIIlIIllllIl) != null;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.mapVariants.hashCode() + (this.hasMultipartData() ? this.multipart.hashCode() : 0);
    }
    
    public Multipart getMultipartData() {
        return this.multipart;
    }
    
    public static ModelBlockDefinition parseFromReader(final Reader lllllllllllIllIlIIlllIIlIlIllIlI) {
        return JsonUtils.func_193839_a(ModelBlockDefinition.GSON, lllllllllllIllIlIIlllIIlIlIllIlI, ModelBlockDefinition.class);
    }
    
    public ModelBlockDefinition(final Map<String, VariantList> lllllllllllIllIlIIlllIIlIlIlIlIl, final Multipart lllllllllllIllIlIIlllIIlIlIlIlII) {
        this.mapVariants = (Map<String, VariantList>)Maps.newHashMap();
        this.multipart = lllllllllllIllIlIIlllIIlIlIlIlII;
        this.mapVariants.putAll(lllllllllllIllIlIIlllIIlIlIlIlIl);
    }
    
    public boolean hasMultipartData() {
        return this.multipart != null;
    }
    
    static {
        GSON = new GsonBuilder().registerTypeAdapter((Type)ModelBlockDefinition.class, (Object)new Deserializer()).registerTypeAdapter((Type)Variant.class, (Object)new Variant.Deserializer()).registerTypeAdapter((Type)VariantList.class, (Object)new VariantList.Deserializer()).registerTypeAdapter((Type)Multipart.class, (Object)new Multipart.Deserializer()).registerTypeAdapter((Type)Selector.class, (Object)new Selector.Deserializer()).create();
    }
    
    @Override
    public boolean equals(final Object lllllllllllIllIlIIlllIIlIIlIllII) {
        if (this == lllllllllllIllIlIIlllIIlIIlIllII) {
            return true;
        }
        if (lllllllllllIllIlIIlllIIlIIlIllII instanceof ModelBlockDefinition) {
            final ModelBlockDefinition lllllllllllIllIlIIlllIIlIIlIlllI = (ModelBlockDefinition)lllllllllllIllIlIIlllIIlIIlIllII;
            if (this.mapVariants.equals(lllllllllllIllIlIIlllIIlIIlIlllI.mapVariants)) {
                return this.hasMultipartData() ? this.multipart.equals(lllllllllllIllIlIIlllIIlIIlIlllI.multipart) : (!lllllllllllIllIlIIlllIIlIIlIlllI.hasMultipartData());
            }
        }
        return false;
    }
    
    public class MissingVariantException extends RuntimeException
    {
    }
    
    public static class Deserializer implements JsonDeserializer<ModelBlockDefinition>
    {
        public ModelBlockDefinition deserialize(final JsonElement llllllllllllIIlIlIIIlIIllIlllIll, final Type llllllllllllIIlIlIIIlIIlllIIIIIl, final JsonDeserializationContext llllllllllllIIlIlIIIlIIllIlllIlI) throws JsonParseException {
            final JsonObject llllllllllllIIlIlIIIlIIllIllllll = llllllllllllIIlIlIIIlIIllIlllIll.getAsJsonObject();
            final Map<String, VariantList> llllllllllllIIlIlIIIlIIllIlllllI = this.parseMapVariants(llllllllllllIIlIlIIIlIIllIlllIlI, llllllllllllIIlIlIIIlIIllIllllll);
            final Multipart llllllllllllIIlIlIIIlIIllIllllIl = this.parseMultipart(llllllllllllIIlIlIIIlIIllIlllIlI, llllllllllllIIlIlIIIlIIllIllllll);
            if (!llllllllllllIIlIlIIIlIIllIlllllI.isEmpty() || (llllllllllllIIlIlIIIlIIllIllllIl != null && !llllllllllllIIlIlIIIlIIllIllllIl.getVariants().isEmpty())) {
                return new ModelBlockDefinition(llllllllllllIIlIlIIIlIIllIlllllI, llllllllllllIIlIlIIIlIIllIllllIl);
            }
            throw new JsonParseException("Neither 'variants' nor 'multipart' found");
        }
        
        protected Map<String, VariantList> parseMapVariants(final JsonDeserializationContext llllllllllllIIlIlIIIlIIllIlIllll, final JsonObject llllllllllllIIlIlIIIlIIllIlIlIIl) {
            final Map<String, VariantList> llllllllllllIIlIlIIIlIIllIlIllIl = (Map<String, VariantList>)Maps.newHashMap();
            if (llllllllllllIIlIlIIIlIIllIlIlIIl.has("variants")) {
                final JsonObject llllllllllllIIlIlIIIlIIllIlIllII = JsonUtils.getJsonObject(llllllllllllIIlIlIIIlIIllIlIlIIl, "variants");
                for (final Map.Entry<String, JsonElement> llllllllllllIIlIlIIIlIIllIlIlIll : llllllllllllIIlIlIIIlIIllIlIllII.entrySet()) {
                    llllllllllllIIlIlIIIlIIllIlIllIl.put(llllllllllllIIlIlIIIlIIllIlIlIll.getKey(), (VariantList)llllllllllllIIlIlIIIlIIllIlIllll.deserialize((JsonElement)llllllllllllIIlIlIIIlIIllIlIlIll.getValue(), (Type)VariantList.class));
                }
            }
            return llllllllllllIIlIlIIIlIIllIlIllIl;
        }
        
        @Nullable
        protected Multipart parseMultipart(final JsonDeserializationContext llllllllllllIIlIlIIIlIIllIlIIIII, final JsonObject llllllllllllIIlIlIIIlIIllIIlllII) {
            if (!llllllllllllIIlIlIIIlIIllIIlllII.has("multipart")) {
                return null;
            }
            final JsonArray llllllllllllIIlIlIIIlIIllIIllllI = JsonUtils.getJsonArray(llllllllllllIIlIlIIIlIIllIIlllII, "multipart");
            return (Multipart)llllllllllllIIlIlIIIlIIllIlIIIII.deserialize((JsonElement)llllllllllllIIlIlIIIlIIllIIllllI, (Type)Multipart.class);
        }
    }
}
