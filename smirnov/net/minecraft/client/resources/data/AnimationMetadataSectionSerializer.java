// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

import com.google.gson.JsonPrimitive;
import com.google.gson.JsonArray;
import java.util.List;
import com.google.gson.JsonParseException;
import com.google.common.collect.Lists;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.Validate;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonSerializer;

public class AnimationMetadataSectionSerializer extends BaseMetadataSectionSerializer<AnimationMetadataSection> implements JsonSerializer<AnimationMetadataSection>
{
    private AnimationFrame parseAnimationFrame(final int llllllllllllIIIIlIlIIllIIIllIlll, final JsonElement llllllllllllIIIIlIlIIllIIIllIllI) {
        if (llllllllllllIIIIlIlIIllIIIllIllI.isJsonPrimitive()) {
            return new AnimationFrame(JsonUtils.getInt(llllllllllllIIIIlIlIIllIIIllIllI, "frames[" + llllllllllllIIIIlIlIIllIIIllIlll + "]"));
        }
        if (llllllllllllIIIIlIlIIllIIIllIllI.isJsonObject()) {
            final JsonObject llllllllllllIIIIlIlIIllIIIllIlIl = JsonUtils.getJsonObject(llllllllllllIIIIlIlIIllIIIllIllI, "frames[" + llllllllllllIIIIlIlIIllIIIllIlll + "]");
            final int llllllllllllIIIIlIlIIllIIIllIlII = JsonUtils.getInt(llllllllllllIIIIlIlIIllIIIllIlIl, "time", -1);
            if (llllllllllllIIIIlIlIIllIIIllIlIl.has("time")) {
                Validate.inclusiveBetween(1L, 2147483647L, (long)llllllllllllIIIIlIlIIllIIIllIlII, "Invalid frame time");
            }
            final int llllllllllllIIIIlIlIIllIIIllIIll = JsonUtils.getInt(llllllllllllIIIIlIlIIllIIIllIlIl, "index");
            Validate.inclusiveBetween(0L, 2147483647L, (long)llllllllllllIIIIlIlIIllIIIllIIll, "Invalid frame index");
            return new AnimationFrame(llllllllllllIIIIlIlIIllIIIllIIll, llllllllllllIIIIlIlIIllIIIllIlII);
        }
        return null;
    }
    
    public AnimationMetadataSection deserialize(final JsonElement llllllllllllIIIIlIlIIllIIlIlIlII, final Type llllllllllllIIIIlIlIIllIIlIlIIll, final JsonDeserializationContext llllllllllllIIIIlIlIIllIIlIlIIlI) throws JsonParseException {
        final List<AnimationFrame> llllllllllllIIIIlIlIIllIIlIlIIIl = (List<AnimationFrame>)Lists.newArrayList();
        final JsonObject llllllllllllIIIIlIlIIllIIlIlIIII = JsonUtils.getJsonObject(llllllllllllIIIIlIlIIllIIlIlIlII, "metadata section");
        final int llllllllllllIIIIlIlIIllIIlIIllll = JsonUtils.getInt(llllllllllllIIIIlIlIIllIIlIlIIII, "frametime", 1);
        if (llllllllllllIIIIlIlIIllIIlIIllll != 1) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)llllllllllllIIIIlIlIIllIIlIIllll, "Invalid default frame time");
        }
        if (llllllllllllIIIIlIlIIllIIlIlIIII.has("frames")) {
            try {
                final JsonArray llllllllllllIIIIlIlIIllIIlIIlllI = JsonUtils.getJsonArray(llllllllllllIIIIlIlIIllIIlIlIIII, "frames");
                for (int llllllllllllIIIIlIlIIllIIlIIllIl = 0; llllllllllllIIIIlIlIIllIIlIIllIl < llllllllllllIIIIlIlIIllIIlIIlllI.size(); ++llllllllllllIIIIlIlIIllIIlIIllIl) {
                    final JsonElement llllllllllllIIIIlIlIIllIIlIIllII = llllllllllllIIIIlIlIIllIIlIIlllI.get(llllllllllllIIIIlIlIIllIIlIIllIl);
                    final AnimationFrame llllllllllllIIIIlIlIIllIIlIIlIll = this.parseAnimationFrame(llllllllllllIIIIlIlIIllIIlIIllIl, llllllllllllIIIIlIlIIllIIlIIllII);
                    if (llllllllllllIIIIlIlIIllIIlIIlIll != null) {
                        llllllllllllIIIIlIlIIllIIlIlIIIl.add(llllllllllllIIIIlIlIIllIIlIIlIll);
                    }
                }
            }
            catch (ClassCastException llllllllllllIIIIlIlIIllIIlIIlIlI) {
                throw new JsonParseException("Invalid animation->frames: expected array, was " + llllllllllllIIIIlIlIIllIIlIlIIII.get("frames"), (Throwable)llllllllllllIIIIlIlIIllIIlIIlIlI);
            }
        }
        final int llllllllllllIIIIlIlIIllIIlIIlIIl = JsonUtils.getInt(llllllllllllIIIIlIlIIllIIlIlIIII, "width", -1);
        final int llllllllllllIIIIlIlIIllIIlIIlIII = JsonUtils.getInt(llllllllllllIIIIlIlIIllIIlIlIIII, "height", -1);
        if (llllllllllllIIIIlIlIIllIIlIIlIIl != -1) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)llllllllllllIIIIlIlIIllIIlIIlIIl, "Invalid width");
        }
        if (llllllllllllIIIIlIlIIllIIlIIlIII != -1) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)llllllllllllIIIIlIlIIllIIlIIlIII, "Invalid height");
        }
        final boolean llllllllllllIIIIlIlIIllIIlIIIlll = JsonUtils.getBoolean(llllllllllllIIIIlIlIIllIIlIlIIII, "interpolate", false);
        return new AnimationMetadataSection(llllllllllllIIIIlIlIIllIIlIlIIIl, llllllllllllIIIIlIlIIllIIlIIlIIl, llllllllllllIIIIlIlIIllIIlIIlIII, llllllllllllIIIIlIlIIllIIlIIllll, llllllllllllIIIIlIlIIllIIlIIIlll);
    }
    
    public JsonElement serialize(final AnimationMetadataSection llllllllllllIIIIlIlIIllIIIlIIlll, final Type llllllllllllIIIIlIlIIllIIIlIIllI, final JsonSerializationContext llllllllllllIIIIlIlIIllIIIlIIlIl) {
        final JsonObject llllllllllllIIIIlIlIIllIIIlIIlII = new JsonObject();
        llllllllllllIIIIlIlIIllIIIlIIlII.addProperty("frametime", (Number)llllllllllllIIIIlIlIIllIIIlIIlll.getFrameTime());
        if (llllllllllllIIIIlIlIIllIIIlIIlll.getFrameWidth() != -1) {
            llllllllllllIIIIlIlIIllIIIlIIlII.addProperty("width", (Number)llllllllllllIIIIlIlIIllIIIlIIlll.getFrameWidth());
        }
        if (llllllllllllIIIIlIlIIllIIIlIIlll.getFrameHeight() != -1) {
            llllllllllllIIIIlIlIIllIIIlIIlII.addProperty("height", (Number)llllllllllllIIIIlIlIIllIIIlIIlll.getFrameHeight());
        }
        if (llllllllllllIIIIlIlIIllIIIlIIlll.getFrameCount() > 0) {
            final JsonArray llllllllllllIIIIlIlIIllIIIlIIIll = new JsonArray();
            for (int llllllllllllIIIIlIlIIllIIIlIIIlI = 0; llllllllllllIIIIlIlIIllIIIlIIIlI < llllllllllllIIIIlIlIIllIIIlIIlll.getFrameCount(); ++llllllllllllIIIIlIlIIllIIIlIIIlI) {
                if (llllllllllllIIIIlIlIIllIIIlIIlll.frameHasTime(llllllllllllIIIIlIlIIllIIIlIIIlI)) {
                    final JsonObject llllllllllllIIIIlIlIIllIIIlIIIIl = new JsonObject();
                    llllllllllllIIIIlIlIIllIIIlIIIIl.addProperty("index", (Number)llllllllllllIIIIlIlIIllIIIlIIlll.getFrameIndex(llllllllllllIIIIlIlIIllIIIlIIIlI));
                    llllllllllllIIIIlIlIIllIIIlIIIIl.addProperty("time", (Number)llllllllllllIIIIlIlIIllIIIlIIlll.getFrameTimeSingle(llllllllllllIIIIlIlIIllIIIlIIIlI));
                    llllllllllllIIIIlIlIIllIIIlIIIll.add((JsonElement)llllllllllllIIIIlIlIIllIIIlIIIIl);
                }
                else {
                    llllllllllllIIIIlIlIIllIIIlIIIll.add((JsonElement)new JsonPrimitive((Number)llllllllllllIIIIlIlIIllIIIlIIlll.getFrameIndex(llllllllllllIIIIlIlIIllIIIlIIIlI)));
                }
            }
            llllllllllllIIIIlIlIIllIIIlIIlII.add("frames", (JsonElement)llllllllllllIIIIlIlIIllIIIlIIIll);
        }
        return (JsonElement)llllllllllllIIIIlIlIIllIIIlIIlII;
    }
    
    public String getSectionName() {
        return "animation";
    }
}
