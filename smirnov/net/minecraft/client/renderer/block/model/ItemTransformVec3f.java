// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import net.minecraft.util.math.MathHelper;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializer;
import org.lwjgl.util.vector.ReadableVector3f;
import org.lwjgl.util.vector.Vector3f;

public class ItemTransformVec3f
{
    public final /* synthetic */ Vector3f translation;
    public final /* synthetic */ Vector3f rotation;
    public final /* synthetic */ Vector3f scale;
    
    public ItemTransformVec3f(final Vector3f llllllllllllIIlllIllllIIIlIIlllI, final Vector3f llllllllllllIIlllIllllIIIlIIllIl, final Vector3f llllllllllllIIlllIllllIIIlIIllII) {
        this.rotation = new Vector3f((ReadableVector3f)llllllllllllIIlllIllllIIIlIIlllI);
        this.translation = new Vector3f((ReadableVector3f)llllllllllllIIlllIllllIIIlIIllIl);
        this.scale = new Vector3f((ReadableVector3f)llllllllllllIIlllIllllIIIlIIllII);
    }
    
    @Override
    public boolean equals(final Object llllllllllllIIlllIllllIIIlIIIIII) {
        if (this == llllllllllllIIlllIllllIIIlIIIIII) {
            return true;
        }
        if (this.getClass() != llllllllllllIIlllIllllIIIlIIIIII.getClass()) {
            return false;
        }
        final ItemTransformVec3f llllllllllllIIlllIllllIIIlIIIIlI = (ItemTransformVec3f)llllllllllllIIlllIllllIIIlIIIIII;
        return this.rotation.equals((Object)llllllllllllIIlllIllllIIIlIIIIlI.rotation) && this.scale.equals((Object)llllllllllllIIlllIllllIIIlIIIIlI.scale) && this.translation.equals((Object)llllllllllllIIlllIllllIIIlIIIIlI.translation);
    }
    
    @Override
    public int hashCode() {
        int llllllllllllIIlllIllllIIIIlllIll = this.rotation.hashCode();
        llllllllllllIIlllIllllIIIIlllIll = 31 * llllllllllllIIlllIllllIIIIlllIll + this.translation.hashCode();
        llllllllllllIIlllIllllIIIIlllIll = 31 * llllllllllllIIlllIllllIIIIlllIll + this.scale.hashCode();
        return llllllllllllIIlllIllllIIIIlllIll;
    }
    
    static {
        DEFAULT = new ItemTransformVec3f(new Vector3f(), new Vector3f(), new Vector3f(1.0f, 1.0f, 1.0f));
    }
    
    static class Deserializer implements JsonDeserializer<ItemTransformVec3f>
    {
        private static final /* synthetic */ Vector3f TRANSLATION_DEFAULT;
        private static final /* synthetic */ Vector3f SCALE_DEFAULT;
        private static final /* synthetic */ Vector3f ROTATION_DEFAULT;
        
        private Vector3f parseVector3f(final JsonObject lllllllllllIIIIlIIIIllllIllIlIlI, final String lllllllllllIIIIlIIIIllllIllIlIIl, final Vector3f lllllllllllIIIIlIIIIllllIllIlIII) {
            if (!lllllllllllIIIIlIIIIllllIllIlIlI.has(lllllllllllIIIIlIIIIllllIllIlIIl)) {
                return lllllllllllIIIIlIIIIllllIllIlIII;
            }
            final JsonArray lllllllllllIIIIlIIIIllllIllIllIl = JsonUtils.getJsonArray(lllllllllllIIIIlIIIIllllIllIlIlI, lllllllllllIIIIlIIIIllllIllIlIIl);
            if (lllllllllllIIIIlIIIIllllIllIllIl.size() != 3) {
                throw new JsonParseException("Expected 3 " + lllllllllllIIIIlIIIIllllIllIlIIl + " values, found: " + lllllllllllIIIIlIIIIllllIllIllIl.size());
            }
            final float[] lllllllllllIIIIlIIIIllllIllIllII = new float[3];
            for (int lllllllllllIIIIlIIIIllllIllIlIll = 0; lllllllllllIIIIlIIIIllllIllIlIll < lllllllllllIIIIlIIIIllllIllIllII.length; ++lllllllllllIIIIlIIIIllllIllIlIll) {
                lllllllllllIIIIlIIIIllllIllIllII[lllllllllllIIIIlIIIIllllIllIlIll] = JsonUtils.getFloat(lllllllllllIIIIlIIIIllllIllIllIl.get(lllllllllllIIIIlIIIIllllIllIlIll), String.valueOf(lllllllllllIIIIlIIIIllllIllIlIIl) + "[" + lllllllllllIIIIlIIIIllllIllIlIll + "]");
            }
            return new Vector3f(lllllllllllIIIIlIIIIllllIllIllII[0], lllllllllllIIIIlIIIIllllIllIllII[1], lllllllllllIIIIlIIIIllllIllIllII[2]);
        }
        
        static {
            ROTATION_DEFAULT = new Vector3f(0.0f, 0.0f, 0.0f);
            TRANSLATION_DEFAULT = new Vector3f(0.0f, 0.0f, 0.0f);
            SCALE_DEFAULT = new Vector3f(1.0f, 1.0f, 1.0f);
        }
        
        public ItemTransformVec3f deserialize(final JsonElement lllllllllllIIIIlIIIIlllllIIIIlII, final Type lllllllllllIIIIlIIIIlllllIIIIIll, final JsonDeserializationContext lllllllllllIIIIlIIIIlllllIIIIIlI) throws JsonParseException {
            final JsonObject lllllllllllIIIIlIIIIlllllIIIIIIl = lllllllllllIIIIlIIIIlllllIIIIlII.getAsJsonObject();
            final Vector3f lllllllllllIIIIlIIIIlllllIIIIIII = this.parseVector3f(lllllllllllIIIIlIIIIlllllIIIIIIl, "rotation", Deserializer.ROTATION_DEFAULT);
            final Vector3f lllllllllllIIIIlIIIIllllIlllllll = this.parseVector3f(lllllllllllIIIIlIIIIlllllIIIIIIl, "translation", Deserializer.TRANSLATION_DEFAULT);
            lllllllllllIIIIlIIIIllllIlllllll.scale(0.0625f);
            lllllllllllIIIIlIIIIllllIlllllll.x = MathHelper.clamp(lllllllllllIIIIlIIIIllllIlllllll.x, -5.0f, 5.0f);
            lllllllllllIIIIlIIIIllllIlllllll.y = MathHelper.clamp(lllllllllllIIIIlIIIIllllIlllllll.y, -5.0f, 5.0f);
            lllllllllllIIIIlIIIIllllIlllllll.z = MathHelper.clamp(lllllllllllIIIIlIIIIllllIlllllll.z, -5.0f, 5.0f);
            final Vector3f lllllllllllIIIIlIIIIllllIllllllI = this.parseVector3f(lllllllllllIIIIlIIIIlllllIIIIIIl, "scale", Deserializer.SCALE_DEFAULT);
            lllllllllllIIIIlIIIIllllIllllllI.x = MathHelper.clamp(lllllllllllIIIIlIIIIllllIllllllI.x, -4.0f, 4.0f);
            lllllllllllIIIIlIIIIllllIllllllI.y = MathHelper.clamp(lllllllllllIIIIlIIIIllllIllllllI.y, -4.0f, 4.0f);
            lllllllllllIIIIlIIIIllllIllllllI.z = MathHelper.clamp(lllllllllllIIIIlIIIIllllIllllllI.z, -4.0f, 4.0f);
            return new ItemTransformVec3f(lllllllllllIIIIlIIIIlllllIIIIIII, lllllllllllIIIIlIIIIllllIlllllll, lllllllllllIIIIlIIIIllllIllllllI);
        }
    }
}
