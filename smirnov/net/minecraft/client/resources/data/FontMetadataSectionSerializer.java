// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

import com.google.gson.JsonObject;
import org.apache.commons.lang3.Validate;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;

public class FontMetadataSectionSerializer extends BaseMetadataSectionSerializer<FontMetadataSection>
{
    public FontMetadataSection deserialize(final JsonElement llllllllllIllllIIlIllIlllIIIlIII, final Type llllllllllIllllIIlIllIlllIIllIIl, final JsonDeserializationContext llllllllllIllllIIlIllIlllIIllIII) throws JsonParseException {
        final JsonObject llllllllllIllllIIlIllIlllIIlIlll = llllllllllIllllIIlIllIlllIIIlIII.getAsJsonObject();
        final float[] llllllllllIllllIIlIllIlllIIlIllI = new float[256];
        final float[] llllllllllIllllIIlIllIlllIIlIlIl = new float[256];
        final float[] llllllllllIllllIIlIllIlllIIlIlII = new float[256];
        float llllllllllIllllIIlIllIlllIIlIIll = 1.0f;
        float llllllllllIllllIIlIllIlllIIlIIlI = 0.0f;
        float llllllllllIllllIIlIllIlllIIlIIIl = 0.0f;
        if (llllllllllIllllIIlIllIlllIIlIlll.has("characters")) {
            if (!llllllllllIllllIIlIllIlllIIlIlll.get("characters").isJsonObject()) {
                throw new JsonParseException("Invalid font->characters: expected object, was " + llllllllllIllllIIlIllIlllIIlIlll.get("characters"));
            }
            final JsonObject llllllllllIllllIIlIllIlllIIlIIII = llllllllllIllllIIlIllIlllIIlIlll.getAsJsonObject("characters");
            if (llllllllllIllllIIlIllIlllIIlIIII.has("default")) {
                if (!llllllllllIllllIIlIllIlllIIlIIII.get("default").isJsonObject()) {
                    throw new JsonParseException("Invalid font->characters->default: expected object, was " + llllllllllIllllIIlIllIlllIIlIIII.get("default"));
                }
                final JsonObject llllllllllIllllIIlIllIlllIIIllll = llllllllllIllllIIlIllIlllIIlIIII.getAsJsonObject("default");
                llllllllllIllllIIlIllIlllIIlIIll = JsonUtils.getFloat(llllllllllIllllIIlIllIlllIIIllll, "width", llllllllllIllllIIlIllIlllIIlIIll);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllIllllIIlIllIlllIIlIIll, "Invalid default width");
                llllllllllIllllIIlIllIlllIIlIIlI = JsonUtils.getFloat(llllllllllIllllIIlIllIlllIIIllll, "spacing", llllllllllIllllIIlIllIlllIIlIIlI);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllIllllIIlIllIlllIIlIIlI, "Invalid default spacing");
                llllllllllIllllIIlIllIlllIIlIIIl = JsonUtils.getFloat(llllllllllIllllIIlIllIlllIIIllll, "left", llllllllllIllllIIlIllIlllIIlIIlI);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllIllllIIlIllIlllIIlIIIl, "Invalid default left");
            }
            for (int llllllllllIllllIIlIllIlllIIIlllI = 0; llllllllllIllllIIlIllIlllIIIlllI < 256; ++llllllllllIllllIIlIllIlllIIIlllI) {
                final JsonElement llllllllllIllllIIlIllIlllIIIllIl = llllllllllIllllIIlIllIlllIIlIIII.get(Integer.toString(llllllllllIllllIIlIllIlllIIIlllI));
                float llllllllllIllllIIlIllIlllIIIllII = llllllllllIllllIIlIllIlllIIlIIll;
                float llllllllllIllllIIlIllIlllIIIlIll = llllllllllIllllIIlIllIlllIIlIIlI;
                float llllllllllIllllIIlIllIlllIIIlIlI = llllllllllIllllIIlIllIlllIIlIIIl;
                if (llllllllllIllllIIlIllIlllIIIllIl != null) {
                    final JsonObject llllllllllIllllIIlIllIlllIIIlIIl = JsonUtils.getJsonObject(llllllllllIllllIIlIllIlllIIIllIl, "characters[" + llllllllllIllllIIlIllIlllIIIlllI + "]");
                    llllllllllIllllIIlIllIlllIIIllII = JsonUtils.getFloat(llllllllllIllllIIlIllIlllIIIlIIl, "width", llllllllllIllllIIlIllIlllIIlIIll);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllIllllIIlIllIlllIIIllII, "Invalid width");
                    llllllllllIllllIIlIllIlllIIIlIll = JsonUtils.getFloat(llllllllllIllllIIlIllIlllIIIlIIl, "spacing", llllllllllIllllIIlIllIlllIIlIIlI);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllIllllIIlIllIlllIIIlIll, "Invalid spacing");
                    llllllllllIllllIIlIllIlllIIIlIlI = JsonUtils.getFloat(llllllllllIllllIIlIllIlllIIIlIIl, "left", llllllllllIllllIIlIllIlllIIlIIIl);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllIllllIIlIllIlllIIIlIlI, "Invalid left");
                }
                llllllllllIllllIIlIllIlllIIlIllI[llllllllllIllllIIlIllIlllIIIlllI] = llllllllllIllllIIlIllIlllIIIllII;
                llllllllllIllllIIlIllIlllIIlIlIl[llllllllllIllllIIlIllIlllIIIlllI] = llllllllllIllllIIlIllIlllIIIlIll;
                llllllllllIllllIIlIllIlllIIlIlII[llllllllllIllllIIlIllIlllIIIlllI] = llllllllllIllllIIlIllIlllIIIlIlI;
            }
        }
        return new FontMetadataSection(llllllllllIllllIIlIllIlllIIlIllI, llllllllllIllllIIlIllIlllIIlIlII, llllllllllIllllIIlIllIlllIIlIlIl);
    }
    
    @Override
    public String getSectionName() {
        return "font";
    }
}
