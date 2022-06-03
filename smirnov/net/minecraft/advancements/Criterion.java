// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import javax.annotation.Nullable;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.network.PacketBuffer;

public class Criterion
{
    private final /* synthetic */ ICriterionInstance field_192147_a;
    
    public static Map<String, Criterion> func_192142_c(final PacketBuffer lllllllllllIIIlIllIllllIIIlIlIlI) {
        final Map<String, Criterion> lllllllllllIIIlIllIllllIIIlIlIIl = (Map<String, Criterion>)Maps.newHashMap();
        for (int lllllllllllIIIlIllIllllIIIlIlIII = lllllllllllIIIlIllIllllIIIlIlIlI.readVarIntFromBuffer(), lllllllllllIIIlIllIllllIIIlIIlll = 0; lllllllllllIIIlIllIllllIIIlIIlll < lllllllllllIIIlIllIllllIIIlIlIII; ++lllllllllllIIIlIllIllllIIIlIIlll) {
            lllllllllllIIIlIllIllllIIIlIlIIl.put(lllllllllllIIIlIllIllllIIIlIlIlI.readStringFromBuffer(32767), func_192146_b(lllllllllllIIIlIllIllllIIIlIlIlI));
        }
        return lllllllllllIIIlIllIllllIIIlIlIIl;
    }
    
    public static Map<String, Criterion> func_192144_b(final JsonObject lllllllllllIIIlIllIllllIIIllIIll, final JsonDeserializationContext lllllllllllIIIlIllIllllIIIllIllI) {
        final Map<String, Criterion> lllllllllllIIIlIllIllllIIIllIlIl = (Map<String, Criterion>)Maps.newHashMap();
        for (final Map.Entry<String, JsonElement> lllllllllllIIIlIllIllllIIIllIlII : lllllllllllIIIlIllIllllIIIllIIll.entrySet()) {
            lllllllllllIIIlIllIllllIIIllIlIl.put(lllllllllllIIIlIllIllllIIIllIlII.getKey(), func_192145_a(JsonUtils.getJsonObject(lllllllllllIIIlIllIllllIIIllIlII.getValue(), "criterion"), lllllllllllIIIlIllIllllIIIllIllI));
        }
        return lllllllllllIIIlIllIllllIIIllIlIl;
    }
    
    public static Criterion func_192145_a(final JsonObject lllllllllllIIIlIllIllllIIlIIIIlI, final JsonDeserializationContext lllllllllllIIIlIllIllllIIlIIIllI) {
        final ResourceLocation lllllllllllIIIlIllIllllIIlIIIlIl = new ResourceLocation(JsonUtils.getString(lllllllllllIIIlIllIllllIIlIIIIlI, "trigger"));
        final ICriterionTrigger<?> lllllllllllIIIlIllIllllIIlIIIlII = CriteriaTriggers.func_192119_a(lllllllllllIIIlIllIllllIIlIIIlIl);
        if (lllllllllllIIIlIllIllllIIlIIIlII == null) {
            throw new JsonSyntaxException("Invalid criterion trigger: " + lllllllllllIIIlIllIllllIIlIIIlIl);
        }
        final ICriterionInstance lllllllllllIIIlIllIllllIIlIIIIll = (ICriterionInstance)lllllllllllIIIlIllIllllIIlIIIlII.func_192166_a(JsonUtils.getJsonObject(lllllllllllIIIlIllIllllIIlIIIIlI, "conditions", new JsonObject()), lllllllllllIIIlIllIllllIIlIIIllI);
        return new Criterion(lllllllllllIIIlIllIllllIIlIIIIll);
    }
    
    public Criterion(final ICriterionInstance lllllllllllIIIlIllIllllIIlIlIIlI) {
        this.field_192147_a = lllllllllllIIIlIllIllllIIlIlIIlI;
    }
    
    public static Criterion func_192146_b(final PacketBuffer lllllllllllIIIlIllIllllIIIllllIl) {
        return new Criterion();
    }
    
    public Criterion() {
        this.field_192147_a = null;
    }
    
    public static void func_192141_a(final Map<String, Criterion> lllllllllllIIIlIllIllllIIIIllllI, final PacketBuffer lllllllllllIIIlIllIllllIIIIlllIl) {
        lllllllllllIIIlIllIllllIIIIlllIl.writeVarIntToBuffer(lllllllllllIIIlIllIllllIIIIllllI.size());
        for (final Map.Entry<String, Criterion> lllllllllllIIIlIllIllllIIIIlllII : lllllllllllIIIlIllIllllIIIIllllI.entrySet()) {
            lllllllllllIIIlIllIllllIIIIlllIl.writeString(lllllllllllIIIlIllIllllIIIIlllII.getKey());
            lllllllllllIIIlIllIllllIIIIlllII.getValue().func_192140_a(lllllllllllIIIlIllIllllIIIIlllIl);
        }
    }
    
    public void func_192140_a(final PacketBuffer lllllllllllIIIlIllIllllIIlIIllIl) {
    }
    
    @Nullable
    public ICriterionInstance func_192143_a() {
        return this.field_192147_a;
    }
}
