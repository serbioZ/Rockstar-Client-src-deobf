// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;

public class TextureMetadataSectionSerializer extends BaseMetadataSectionSerializer<TextureMetadataSection>
{
    @Override
    public String getSectionName() {
        return "texture";
    }
    
    public TextureMetadataSection deserialize(final JsonElement llllllllllllIIllIlIIlIIIlllIlIIl, final Type llllllllllllIIllIlIIlIIIlllIlIII, final JsonDeserializationContext llllllllllllIIllIlIIlIIIlllIIlll) throws JsonParseException {
        final JsonObject llllllllllllIIllIlIIlIIIlllIIllI = llllllllllllIIllIlIIlIIIlllIlIIl.getAsJsonObject();
        final boolean llllllllllllIIllIlIIlIIIlllIIlIl = JsonUtils.getBoolean(llllllllllllIIllIlIIlIIIlllIIllI, "blur", false);
        final boolean llllllllllllIIllIlIIlIIIlllIIlII = JsonUtils.getBoolean(llllllllllllIIllIlIIlIIIlllIIllI, "clamp", false);
        return new TextureMetadataSection(llllllllllllIIllIlIIlIIIlllIIlIl, llllllllllllIIllIlIIlIIIlllIIlII);
    }
}
