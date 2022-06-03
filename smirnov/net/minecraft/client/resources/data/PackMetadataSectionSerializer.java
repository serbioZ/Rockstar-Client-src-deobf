// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

import net.minecraft.util.JsonUtils;
import net.minecraft.util.text.ITextComponent;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;

public class PackMetadataSectionSerializer extends BaseMetadataSectionSerializer<PackMetadataSection> implements JsonSerializer<PackMetadataSection>
{
    public String getSectionName() {
        return "pack";
    }
    
    public JsonElement serialize(final PackMetadataSection lllllllllllllllIIIlIIllIIIllllIl, final Type lllllllllllllllIIIlIIllIIlIIIIII, final JsonSerializationContext lllllllllllllllIIIlIIllIIIllllII) {
        final JsonObject lllllllllllllllIIIlIIllIIIlllllI = new JsonObject();
        lllllllllllllllIIIlIIllIIIlllllI.addProperty("pack_format", (Number)lllllllllllllllIIIlIIllIIIllllIl.getPackFormat());
        lllllllllllllllIIIlIIllIIIlllllI.add("description", lllllllllllllllIIIlIIllIIIllllII.serialize((Object)lllllllllllllllIIIlIIllIIIllllIl.getPackDescription()));
        return (JsonElement)lllllllllllllllIIIlIIllIIIlllllI;
    }
    
    public PackMetadataSection deserialize(final JsonElement lllllllllllllllIIIlIIllIIlIIlIlI, final Type lllllllllllllllIIIlIIllIIlIIllll, final JsonDeserializationContext lllllllllllllllIIIlIIllIIlIIlllI) throws JsonParseException {
        final JsonObject lllllllllllllllIIIlIIllIIlIIllIl = lllllllllllllllIIIlIIllIIlIIlIlI.getAsJsonObject();
        final ITextComponent lllllllllllllllIIIlIIllIIlIIllII = (ITextComponent)lllllllllllllllIIIlIIllIIlIIlllI.deserialize(lllllllllllllllIIIlIIllIIlIIllIl.get("description"), (Type)ITextComponent.class);
        if (lllllllllllllllIIIlIIllIIlIIllII == null) {
            throw new JsonParseException("Invalid/missing description!");
        }
        final int lllllllllllllllIIIlIIllIIlIIlIll = JsonUtils.getInt(lllllllllllllllIIIlIIllIIlIIllIl, "pack_format");
        return new PackMetadataSection(lllllllllllllllIIIlIIllIIlIIllII, lllllllllllllllIIIlIIllIIlIIlIll);
    }
}
