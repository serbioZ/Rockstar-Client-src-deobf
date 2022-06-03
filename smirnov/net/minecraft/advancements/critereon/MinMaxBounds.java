// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import javax.annotation.Nullable;
import com.google.gson.JsonElement;

public class MinMaxBounds
{
    public static final /* synthetic */ MinMaxBounds field_192516_a;
    private final /* synthetic */ Float field_192517_b;
    private final /* synthetic */ Float field_192518_c;
    
    public boolean func_192514_a(final float lllllllllllllIIlIIlIlIlIIlIlllIl) {
        return (this.field_192517_b == null || this.field_192517_b <= lllllllllllllIIlIIlIlIlIIlIlllIl) && (this.field_192518_c == null || this.field_192518_c >= lllllllllllllIIlIIlIlIlIIlIlllIl);
    }
    
    public boolean func_192513_a(final double lllllllllllllIIlIIlIlIlIIlIllIIl) {
        return (this.field_192517_b == null || this.field_192517_b * this.field_192517_b <= lllllllllllllIIlIIlIlIlIIlIllIIl) && (this.field_192518_c == null || this.field_192518_c * this.field_192518_c >= lllllllllllllIIlIIlIlIlIIlIllIIl);
    }
    
    static {
        field_192516_a = new MinMaxBounds(null, null);
    }
    
    public static MinMaxBounds func_192515_a(@Nullable final JsonElement lllllllllllllIIlIIlIlIlIIlIIllIl) {
        if (lllllllllllllIIlIIlIlIlIIlIIllIl == null || lllllllllllllIIlIIlIlIlIIlIIllIl.isJsonNull()) {
            return MinMaxBounds.field_192516_a;
        }
        if (JsonUtils.isNumber(lllllllllllllIIlIIlIlIlIIlIIllIl)) {
            final float lllllllllllllIIlIIlIlIlIIlIlIIIl = JsonUtils.getFloat(lllllllllllllIIlIIlIlIlIIlIIllIl, "value");
            return new MinMaxBounds(lllllllllllllIIlIIlIlIlIIlIlIIIl, lllllllllllllIIlIIlIlIlIIlIlIIIl);
        }
        final JsonObject lllllllllllllIIlIIlIlIlIIlIlIIII = JsonUtils.getJsonObject(lllllllllllllIIlIIlIlIlIIlIIllIl, "value");
        final Float lllllllllllllIIlIIlIlIlIIlIIllll = lllllllllllllIIlIIlIlIlIIlIlIIII.has("min") ? Float.valueOf(JsonUtils.getFloat(lllllllllllllIIlIIlIlIlIIlIlIIII, "min")) : null;
        final Float lllllllllllllIIlIIlIlIlIIlIIlllI = lllllllllllllIIlIIlIlIlIIlIlIIII.has("max") ? Float.valueOf(JsonUtils.getFloat(lllllllllllllIIlIIlIlIlIIlIlIIII, "max")) : null;
        return new MinMaxBounds(lllllllllllllIIlIIlIlIlIIlIIllll, lllllllllllllIIlIIlIlIlIIlIIlllI);
    }
    
    public MinMaxBounds(@Nullable final Float lllllllllllllIIlIIlIlIlIIllIIlll, @Nullable final Float lllllllllllllIIlIIlIlIlIIllIIllI) {
        this.field_192517_b = lllllllllllllIIlIIlIlIlIIllIIlll;
        this.field_192518_c = lllllllllllllIIlIIlIlIlIIllIIllI;
    }
}
