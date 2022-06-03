// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import com.google.gson.JsonArray;
import com.google.common.collect.Lists;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializer;
import java.util.List;

public class VariantList
{
    private final /* synthetic */ List<Variant> variantList;
    
    @Override
    public int hashCode() {
        return this.variantList.hashCode();
    }
    
    public VariantList(final List<Variant> lIIIlllIlIlIlI) {
        this.variantList = lIIIlllIlIlIlI;
    }
    
    public List<Variant> getVariantList() {
        return this.variantList;
    }
    
    @Override
    public boolean equals(final Object lIIIlllIlIIIII) {
        if (this == lIIIlllIlIIIII) {
            return true;
        }
        if (lIIIlllIlIIIII instanceof VariantList) {
            final VariantList lIIIlllIIlllll = (VariantList)lIIIlllIlIIIII;
            return this.variantList.equals(lIIIlllIIlllll.variantList);
        }
        return false;
    }
    
    public static class Deserializer implements JsonDeserializer<VariantList>
    {
        public VariantList deserialize(final JsonElement llllllllllllIlIIIIIllIIIIllIllll, final Type llllllllllllIlIIIIIllIIIIllIlllI, final JsonDeserializationContext llllllllllllIlIIIIIllIIIIllIllIl) throws JsonParseException {
            final List<Variant> llllllllllllIlIIIIIllIIIIllIllII = (List<Variant>)Lists.newArrayList();
            if (llllllllllllIlIIIIIllIIIIllIllll.isJsonArray()) {
                final JsonArray llllllllllllIlIIIIIllIIIIllIlIll = llllllllllllIlIIIIIllIIIIllIllll.getAsJsonArray();
                if (llllllllllllIlIIIIIllIIIIllIlIll.size() == 0) {
                    throw new JsonParseException("Empty variant array");
                }
                for (final JsonElement llllllllllllIlIIIIIllIIIIllIlIlI : llllllllllllIlIIIIIllIIIIllIlIll) {
                    llllllllllllIlIIIIIllIIIIllIllII.add((Variant)llllllllllllIlIIIIIllIIIIllIllIl.deserialize(llllllllllllIlIIIIIllIIIIllIlIlI, (Type)Variant.class));
                }
            }
            else {
                llllllllllllIlIIIIIllIIIIllIllII.add((Variant)llllllllllllIlIIIIIllIIIIllIllIl.deserialize(llllllllllllIlIIIIIllIIIIllIllll, (Type)Variant.class));
            }
            return new VariantList(llllllllllllIlIIIIIllIIIIllIllII);
        }
    }
}
