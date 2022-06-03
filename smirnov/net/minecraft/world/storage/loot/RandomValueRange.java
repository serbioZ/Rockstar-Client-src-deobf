// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import com.google.gson.JsonPrimitive;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import net.minecraft.util.math.MathHelper;
import java.util.Random;

public class RandomValueRange
{
    private final /* synthetic */ float max;
    private final /* synthetic */ float min;
    
    public boolean isInRange(final int llllllllllllllIllIlIIllllllllIII) {
        return llllllllllllllIllIlIIllllllllIII <= this.max && llllllllllllllIllIlIIllllllllIII >= this.min;
    }
    
    public float generateFloat(final Random llllllllllllllIllIlIIllllllllllI) {
        return MathHelper.nextFloat(llllllllllllllIllIlIIllllllllllI, this.min, this.max);
    }
    
    public float getMin() {
        return this.min;
    }
    
    public RandomValueRange(final float llllllllllllllIllIlIlIIIIIIlIlIl, final float llllllllllllllIllIlIlIIIIIIlIlII) {
        this.min = llllllllllllllIllIlIlIIIIIIlIlIl;
        this.max = llllllllllllllIllIlIlIIIIIIlIlII;
    }
    
    public RandomValueRange(final float llllllllllllllIllIlIlIIIIIIIlllI) {
        this.min = llllllllllllllIllIlIlIIIIIIIlllI;
        this.max = llllllllllllllIllIlIlIIIIIIIlllI;
    }
    
    public int generateInt(final Random llllllllllllllIllIlIlIIIIIIIIIlI) {
        return MathHelper.getInt(llllllllllllllIllIlIlIIIIIIIIIlI, MathHelper.floor(this.min), MathHelper.floor(this.max));
    }
    
    public float getMax() {
        return this.max;
    }
    
    public static class Serializer implements JsonDeserializer<RandomValueRange>, JsonSerializer<RandomValueRange>
    {
        public RandomValueRange deserialize(final JsonElement lllllllllllIIlIlllIIIIIIIlllIllI, final Type lllllllllllIIlIlllIIIIIIIllllIll, final JsonDeserializationContext lllllllllllIIlIlllIIIIIIIllllIlI) throws JsonParseException {
            if (JsonUtils.isNumber(lllllllllllIIlIlllIIIIIIIlllIllI)) {
                return new RandomValueRange(JsonUtils.getFloat(lllllllllllIIlIlllIIIIIIIlllIllI, "value"));
            }
            final JsonObject lllllllllllIIlIlllIIIIIIIllllIIl = JsonUtils.getJsonObject(lllllllllllIIlIlllIIIIIIIlllIllI, "value");
            final float lllllllllllIIlIlllIIIIIIIllllIII = JsonUtils.getFloat(lllllllllllIIlIlllIIIIIIIllllIIl, "min");
            final float lllllllllllIIlIlllIIIIIIIlllIlll = JsonUtils.getFloat(lllllllllllIIlIlllIIIIIIIllllIIl, "max");
            return new RandomValueRange(lllllllllllIIlIlllIIIIIIIllllIII, lllllllllllIIlIlllIIIIIIIlllIlll);
        }
        
        public JsonElement serialize(final RandomValueRange lllllllllllIIlIlllIIIIIIIllIllll, final Type lllllllllllIIlIlllIIIIIIIllIlllI, final JsonSerializationContext lllllllllllIIlIlllIIIIIIIllIllIl) {
            if (lllllllllllIIlIlllIIIIIIIllIllll.min == lllllllllllIIlIlllIIIIIIIllIllll.max) {
                return (JsonElement)new JsonPrimitive((Number)lllllllllllIIlIlllIIIIIIIllIllll.min);
            }
            final JsonObject lllllllllllIIlIlllIIIIIIIllIllII = new JsonObject();
            lllllllllllIIlIlllIIIIIIIllIllII.addProperty("min", (Number)lllllllllllIIlIlllIIIIIIIllIllll.min);
            lllllllllllIIlIlllIIIIIIIllIllII.addProperty("max", (Number)lllllllllllIIlIlllIIIIIIIllIllll.max);
            return (JsonElement)lllllllllllIIlIlllIIIIIIIllIllII;
        }
    }
}
