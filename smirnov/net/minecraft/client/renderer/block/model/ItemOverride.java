// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import net.minecraft.util.JsonUtils;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import java.util.Map;
import net.minecraft.util.ResourceLocation;

public class ItemOverride
{
    private final /* synthetic */ ResourceLocation location;
    private final /* synthetic */ Map<ResourceLocation, Float> mapResourceValues;
    
    public ResourceLocation getLocation() {
        return this.location;
    }
    
    boolean matchesItemStack(final ItemStack llllllllllllIllIlIIIlIlllIlIIlII, @Nullable final World llllllllllllIllIlIIIlIlllIlIIIll, @Nullable final EntityLivingBase llllllllllllIllIlIIIlIlllIIllIll) {
        final Item llllllllllllIllIlIIIlIlllIlIIIIl = llllllllllllIllIlIIIlIlllIlIIlII.getItem();
        for (final Map.Entry<ResourceLocation, Float> llllllllllllIllIlIIIlIlllIlIIIII : this.mapResourceValues.entrySet()) {
            final IItemPropertyGetter llllllllllllIllIlIIIlIlllIIlllll = llllllllllllIllIlIIIlIlllIlIIIIl.getPropertyGetter(llllllllllllIllIlIIIlIlllIlIIIII.getKey());
            if (llllllllllllIllIlIIIlIlllIIlllll == null || llllllllllllIllIlIIIlIlllIIlllll.apply(llllllllllllIllIlIIIlIlllIlIIlII, llllllllllllIllIlIIIlIlllIlIIIll, llllllllllllIllIlIIIlIlllIIllIll) < llllllllllllIllIlIIIlIlllIlIIIII.getValue()) {
                return false;
            }
        }
        return true;
    }
    
    public ItemOverride(final ResourceLocation llllllllllllIllIlIIIlIlllIllIlIl, final Map<ResourceLocation, Float> llllllllllllIllIlIIIlIlllIllIIIl) {
        this.location = llllllllllllIllIlIIIlIlllIllIlIl;
        this.mapResourceValues = llllllllllllIllIlIIIlIlllIllIIIl;
    }
    
    static class Deserializer implements JsonDeserializer<ItemOverride>
    {
        protected Map<ResourceLocation, Float> makeMapResourceValues(final JsonObject llllllllllIlllIIllIIlllIIIIIlIlI) {
            final Map<ResourceLocation, Float> llllllllllIlllIIllIIlllIIIIIllIl = (Map<ResourceLocation, Float>)Maps.newLinkedHashMap();
            final JsonObject llllllllllIlllIIllIIlllIIIIIllII = JsonUtils.getJsonObject(llllllllllIlllIIllIIlllIIIIIlIlI, "predicate");
            for (final Map.Entry<String, JsonElement> llllllllllIlllIIllIIlllIIIIIlIll : llllllllllIlllIIllIIlllIIIIIllII.entrySet()) {
                llllllllllIlllIIllIIlllIIIIIllIl.put(new ResourceLocation(llllllllllIlllIIllIIlllIIIIIlIll.getKey()), JsonUtils.getFloat(llllllllllIlllIIllIIlllIIIIIlIll.getValue(), llllllllllIlllIIllIIlllIIIIIlIll.getKey()));
            }
            return llllllllllIlllIIllIIlllIIIIIllIl;
        }
        
        public ItemOverride deserialize(final JsonElement llllllllllIlllIIllIIlllIIIIlllll, final Type llllllllllIlllIIllIIlllIIIIllllI, final JsonDeserializationContext llllllllllIlllIIllIIlllIIIIlllIl) throws JsonParseException {
            final JsonObject llllllllllIlllIIllIIlllIIIIlllII = llllllllllIlllIIllIIlllIIIIlllll.getAsJsonObject();
            final ResourceLocation llllllllllIlllIIllIIlllIIIIllIll = new ResourceLocation(JsonUtils.getString(llllllllllIlllIIllIIlllIIIIlllII, "model"));
            final Map<ResourceLocation, Float> llllllllllIlllIIllIIlllIIIIllIlI = this.makeMapResourceValues(llllllllllIlllIIllIIlllIIIIlllII);
            return new ItemOverride(llllllllllIlllIIllIIlllIIIIllIll, llllllllllIlllIIllIIlllIIIIllIlI);
        }
    }
}
