// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import org.apache.commons.lang3.Validate;
import com.google.gson.JsonArray;
import net.minecraft.util.JsonUtils;
import com.google.common.collect.Lists;
import java.util.List;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializer;

public class SoundListSerializer implements JsonDeserializer<SoundList>
{
    private List<Sound> deserializeSounds(final JsonObject lllllllllllllllIlIllIlIlllIIIIlI) {
        final List<Sound> lllllllllllllllIlIllIlIlllIIlIII = (List<Sound>)Lists.newArrayList();
        if (lllllllllllllllIlIllIlIlllIIIIlI.has("sounds")) {
            final JsonArray lllllllllllllllIlIllIlIlllIIIlll = JsonUtils.getJsonArray(lllllllllllllllIlIllIlIlllIIIIlI, "sounds");
            for (int lllllllllllllllIlIllIlIlllIIIllI = 0; lllllllllllllllIlIllIlIlllIIIllI < lllllllllllllllIlIllIlIlllIIIlll.size(); ++lllllllllllllllIlIllIlIlllIIIllI) {
                final JsonElement lllllllllllllllIlIllIlIlllIIIlIl = lllllllllllllllIlIllIlIlllIIIlll.get(lllllllllllllllIlIllIlIlllIIIllI);
                if (JsonUtils.isString(lllllllllllllllIlIllIlIlllIIIlIl)) {
                    final String lllllllllllllllIlIllIlIlllIIIlII = JsonUtils.getString(lllllllllllllllIlIllIlIlllIIIlIl, "sound");
                    lllllllllllllllIlIllIlIlllIIlIII.add(new Sound(lllllllllllllllIlIllIlIlllIIIlII, 1.0f, 1.0f, 1, Sound.Type.FILE, false));
                }
                else {
                    lllllllllllllllIlIllIlIlllIIlIII.add(this.deserializeSound(JsonUtils.getJsonObject(lllllllllllllllIlIllIlIlllIIIlIl, "sound")));
                }
            }
        }
        return lllllllllllllllIlIllIlIlllIIlIII;
    }
    
    private Sound.Type deserializeType(final JsonObject lllllllllllllllIlIllIlIllIlIIIII, final Sound.Type lllllllllllllllIlIllIlIllIIlllll) {
        Sound.Type lllllllllllllllIlIllIlIllIIllllI = lllllllllllllllIlIllIlIllIIlllll;
        if (lllllllllllllllIlIllIlIllIlIIIII.has("type")) {
            lllllllllllllllIlIllIlIllIIllllI = Sound.Type.getByName(JsonUtils.getString(lllllllllllllllIlIllIlIllIlIIIII, "type"));
            Validate.notNull((Object)lllllllllllllllIlIllIlIllIIllllI, "Invalid type", new Object[0]);
        }
        return lllllllllllllllIlIllIlIllIIllllI;
    }
    
    private Sound deserializeSound(final JsonObject lllllllllllllllIlIllIlIllIlIlIll) {
        final String lllllllllllllllIlIllIlIllIllIIlI = JsonUtils.getString(lllllllllllllllIlIllIlIllIlIlIll, "name");
        final Sound.Type lllllllllllllllIlIllIlIllIllIIIl = this.deserializeType(lllllllllllllllIlIllIlIllIlIlIll, Sound.Type.FILE);
        final float lllllllllllllllIlIllIlIllIllIIII = JsonUtils.getFloat(lllllllllllllllIlIllIlIllIlIlIll, "volume", 1.0f);
        Validate.isTrue(lllllllllllllllIlIllIlIllIllIIII > 0.0f, "Invalid volume", new Object[0]);
        final float lllllllllllllllIlIllIlIllIlIllll = JsonUtils.getFloat(lllllllllllllllIlIllIlIllIlIlIll, "pitch", 1.0f);
        Validate.isTrue(lllllllllllllllIlIllIlIllIlIllll > 0.0f, "Invalid pitch", new Object[0]);
        final int lllllllllllllllIlIllIlIllIlIlllI = JsonUtils.getInt(lllllllllllllllIlIllIlIllIlIlIll, "weight", 1);
        Validate.isTrue(lllllllllllllllIlIllIlIllIlIlllI > 0, "Invalid weight", new Object[0]);
        final boolean lllllllllllllllIlIllIlIllIlIllIl = JsonUtils.getBoolean(lllllllllllllllIlIllIlIllIlIlIll, "stream", false);
        return new Sound(lllllllllllllllIlIllIlIllIllIIlI, lllllllllllllllIlIllIlIllIllIIII, lllllllllllllllIlIllIlIllIlIllll, lllllllllllllllIlIllIlIllIlIlllI, lllllllllllllllIlIllIlIllIllIIIl, lllllllllllllllIlIllIlIllIlIllIl);
    }
    
    public SoundList deserialize(final JsonElement lllllllllllllllIlIllIlIlllIllllI, final Type lllllllllllllllIlIllIlIlllIlllIl, final JsonDeserializationContext lllllllllllllllIlIllIlIlllIlllII) throws JsonParseException {
        final JsonObject lllllllllllllllIlIllIlIlllIllIll = JsonUtils.getJsonObject(lllllllllllllllIlIllIlIlllIllllI, "entry");
        final boolean lllllllllllllllIlIllIlIlllIllIlI = JsonUtils.getBoolean(lllllllllllllllIlIllIlIlllIllIll, "replace", false);
        final String lllllllllllllllIlIllIlIlllIllIIl = JsonUtils.getString(lllllllllllllllIlIllIlIlllIllIll, "subtitle", null);
        final List<Sound> lllllllllllllllIlIllIlIlllIllIII = this.deserializeSounds(lllllllllllllllIlIllIlIlllIllIll);
        return new SoundList(lllllllllllllllIlIllIlIlllIllIII, lllllllllllllllIlIllIlIlllIllIlI, lllllllllllllllIlIllIlIlllIllIIl);
    }
}
