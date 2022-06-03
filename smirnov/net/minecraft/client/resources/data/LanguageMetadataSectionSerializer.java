// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

import java.util.Set;
import com.google.gson.JsonObject;
import java.util.Collection;
import net.minecraft.client.resources.Language;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonParseException;
import java.util.Map;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;

public class LanguageMetadataSectionSerializer extends BaseMetadataSectionSerializer<LanguageMetadataSection>
{
    public LanguageMetadataSection deserialize(final JsonElement llllllllllIlllIIIIllIIIlIIlIllll, final Type llllllllllIlllIIIIllIIIlIIlllIIl, final JsonDeserializationContext llllllllllIlllIIIIllIIIlIIlllIII) throws JsonParseException {
        final JsonObject llllllllllIlllIIIIllIIIlIIllIlll = llllllllllIlllIIIIllIIIlIIlIllll.getAsJsonObject();
        final Set<Language> llllllllllIlllIIIIllIIIlIIllIllI = (Set<Language>)Sets.newHashSet();
        for (final Map.Entry<String, JsonElement> llllllllllIlllIIIIllIIIlIIllIlIl : llllllllllIlllIIIIllIIIlIIllIlll.entrySet()) {
            final String llllllllllIlllIIIIllIIIlIIllIlII = llllllllllIlllIIIIllIIIlIIllIlIl.getKey();
            if (llllllllllIlllIIIIllIIIlIIllIlII.length() > 16) {
                throw new JsonParseException("Invalid language->'" + llllllllllIlllIIIIllIIIlIIllIlII + "': language code must not be more than " + 16 + " characters long");
            }
            final JsonObject llllllllllIlllIIIIllIIIlIIllIIll = JsonUtils.getJsonObject(llllllllllIlllIIIIllIIIlIIllIlIl.getValue(), "language");
            final String llllllllllIlllIIIIllIIIlIIllIIlI = JsonUtils.getString(llllllllllIlllIIIIllIIIlIIllIIll, "region");
            final String llllllllllIlllIIIIllIIIlIIllIIIl = JsonUtils.getString(llllllllllIlllIIIIllIIIlIIllIIll, "name");
            final boolean llllllllllIlllIIIIllIIIlIIllIIII = JsonUtils.getBoolean(llllllllllIlllIIIIllIIIlIIllIIll, "bidirectional", false);
            if (llllllllllIlllIIIIllIIIlIIllIIlI.isEmpty()) {
                throw new JsonParseException("Invalid language->'" + llllllllllIlllIIIIllIIIlIIllIlII + "'->region: empty value");
            }
            if (llllllllllIlllIIIIllIIIlIIllIIIl.isEmpty()) {
                throw new JsonParseException("Invalid language->'" + llllllllllIlllIIIIllIIIlIIllIlII + "'->name: empty value");
            }
            if (!llllllllllIlllIIIIllIIIlIIllIllI.add(new Language(llllllllllIlllIIIIllIIIlIIllIlII, llllllllllIlllIIIIllIIIlIIllIIlI, llllllllllIlllIIIIllIIIlIIllIIIl, llllllllllIlllIIIIllIIIlIIllIIII))) {
                throw new JsonParseException("Duplicate language->'" + llllllllllIlllIIIIllIIIlIIllIlII + "' defined");
            }
        }
        return new LanguageMetadataSection(llllllllllIlllIIIIllIIIlIIllIllI);
    }
    
    @Override
    public String getSectionName() {
        return "language";
    }
}
