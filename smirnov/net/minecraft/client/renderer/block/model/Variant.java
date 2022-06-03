// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializer;
import net.minecraft.util.ResourceLocation;

public class Variant
{
    private final /* synthetic */ ModelRotation rotation;
    private final /* synthetic */ boolean uvLock;
    private final /* synthetic */ int weight;
    private final /* synthetic */ ResourceLocation modelLocation;
    
    @Override
    public String toString() {
        return "Variant{modelLocation=" + this.modelLocation + ", rotation=" + this.rotation + ", uvLock=" + this.uvLock + ", weight=" + this.weight + '}';
    }
    
    public ResourceLocation getModelLocation() {
        return this.modelLocation;
    }
    
    public Variant(final ResourceLocation lllllllllllllllllIlIlllIllllIIII, final ModelRotation lllllllllllllllllIlIlllIlllIlIlI, final boolean lllllllllllllllllIlIlllIlllIlIIl, final int lllllllllllllllllIlIlllIlllIllIl) {
        this.modelLocation = lllllllllllllllllIlIlllIllllIIII;
        this.rotation = lllllllllllllllllIlIlllIlllIlIlI;
        this.uvLock = lllllllllllllllllIlIlllIlllIlIIl;
        this.weight = lllllllllllllllllIlIlllIlllIllIl;
    }
    
    public ModelRotation getRotation() {
        return this.rotation;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllIlIlllIllIlIlII) {
        if (this == lllllllllllllllllIlIlllIllIlIlII) {
            return true;
        }
        if (!(lllllllllllllllllIlIlllIllIlIlII instanceof Variant)) {
            return false;
        }
        final Variant lllllllllllllllllIlIlllIllIlIIll = (Variant)lllllllllllllllllIlIlllIllIlIlII;
        return this.modelLocation.equals(lllllllllllllllllIlIlllIllIlIIll.modelLocation) && this.rotation == lllllllllllllllllIlIlllIllIlIIll.rotation && this.uvLock == lllllllllllllllllIlIlllIllIlIIll.uvLock && this.weight == lllllllllllllllllIlIlllIllIlIIll.weight;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllllIlIlllIllIIllII = this.modelLocation.hashCode();
        lllllllllllllllllIlIlllIllIIllII = 31 * lllllllllllllllllIlIlllIllIIllII + this.rotation.hashCode();
        lllllllllllllllllIlIlllIllIIllII = 31 * lllllllllllllllllIlIlllIllIIllII + Boolean.valueOf(this.uvLock).hashCode();
        lllllllllllllllllIlIlllIllIIllII = 31 * lllllllllllllllllIlIlllIllIIllII + this.weight;
        return lllllllllllllllllIlIlllIllIIllII;
    }
    
    public boolean isUvLock() {
        return this.uvLock;
    }
    
    public static class Deserializer implements JsonDeserializer<Variant>
    {
        protected int parseWeight(final JsonObject llllllllllllIlIIIIIlIlllIlIIIIlI) {
            final int llllllllllllIlIIIIIlIlllIlIIIIIl = JsonUtils.getInt(llllllllllllIlIIIIIlIlllIlIIIIlI, "weight", 1);
            if (llllllllllllIlIIIIIlIlllIlIIIIIl < 1) {
                throw new JsonParseException("Invalid weight " + llllllllllllIlIIIIIlIlllIlIIIIIl + " found, expected integer >= 1");
            }
            return llllllllllllIlIIIIIlIlllIlIIIIIl;
        }
        
        protected String getStringModel(final JsonObject llllllllllllIlIIIIIlIlllIlIIIllI) {
            return JsonUtils.getString(llllllllllllIlIIIIIlIlllIlIIIllI, "model");
        }
        
        private ResourceLocation getResourceLocationBlock(final String llllllllllllIlIIIIIlIlllIlIllllI) {
            ResourceLocation llllllllllllIlIIIIIlIlllIlIlllIl = new ResourceLocation(llllllllllllIlIIIIIlIlllIlIllllI);
            llllllllllllIlIIIIIlIlllIlIlllIl = new ResourceLocation(llllllllllllIlIIIIIlIlllIlIlllIl.getResourceDomain(), "block/" + llllllllllllIlIIIIIlIlllIlIlllIl.getResourcePath());
            return llllllllllllIlIIIIIlIlllIlIlllIl;
        }
        
        public Variant deserialize(final JsonElement llllllllllllIlIIIIIlIlllIlllIIII, final Type llllllllllllIlIIIIIlIlllIllIllll, final JsonDeserializationContext llllllllllllIlIIIIIlIlllIllIlllI) throws JsonParseException {
            final JsonObject llllllllllllIlIIIIIlIlllIllIllIl = llllllllllllIlIIIIIlIlllIlllIIII.getAsJsonObject();
            final String llllllllllllIlIIIIIlIlllIllIllII = this.getStringModel(llllllllllllIlIIIIIlIlllIllIllIl);
            final ModelRotation llllllllllllIlIIIIIlIlllIllIlIll = this.parseModelRotation(llllllllllllIlIIIIIlIlllIllIllIl);
            final boolean llllllllllllIlIIIIIlIlllIllIlIlI = this.parseUvLock(llllllllllllIlIIIIIlIlllIllIllIl);
            final int llllllllllllIlIIIIIlIlllIllIlIIl = this.parseWeight(llllllllllllIlIIIIIlIlllIllIllIl);
            return new Variant(this.getResourceLocationBlock(llllllllllllIlIIIIIlIlllIllIllII), llllllllllllIlIIIIIlIlllIllIlIll, llllllllllllIlIIIIIlIlllIllIlIlI, llllllllllllIlIIIIIlIlllIllIlIIl);
        }
        
        private boolean parseUvLock(final JsonObject llllllllllllIlIIIIIlIlllIlIllIII) {
            return JsonUtils.getBoolean(llllllllllllIlIIIIIlIlllIlIllIII, "uvlock", false);
        }
        
        protected ModelRotation parseModelRotation(final JsonObject llllllllllllIlIIIIIlIlllIlIlIIIl) {
            final int llllllllllllIlIIIIIlIlllIlIlIIII = JsonUtils.getInt(llllllllllllIlIIIIIlIlllIlIlIIIl, "x", 0);
            final int llllllllllllIlIIIIIlIlllIlIIllll = JsonUtils.getInt(llllllllllllIlIIIIIlIlllIlIlIIIl, "y", 0);
            final ModelRotation llllllllllllIlIIIIIlIlllIlIIlllI = ModelRotation.getModelRotation(llllllllllllIlIIIIIlIlllIlIlIIII, llllllllllllIlIIIIIlIlllIlIIllll);
            if (llllllllllllIlIIIIIlIlllIlIIlllI == null) {
                throw new JsonParseException("Invalid BlockModelRotation x: " + llllllllllllIlIIIIIlIlllIlIlIIII + ", y: " + llllllllllllIlIIIIIlIlllIlIIllll);
            }
            return llllllllllllIlIIIIIlIlllIlIIlllI;
        }
    }
}
