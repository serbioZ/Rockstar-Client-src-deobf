// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonArray;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonElement;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.enchantment.Enchantment;

public class EnchantmentPredicate
{
    private final /* synthetic */ Enchantment field_192467_b;
    private final /* synthetic */ MinMaxBounds field_192468_c;
    public static final /* synthetic */ EnchantmentPredicate field_192466_a;
    
    public EnchantmentPredicate(@Nullable final Enchantment llllllllllllllIIIllllIllllIlIlIl, final MinMaxBounds llllllllllllllIIIllllIllllIlIIIl) {
        this.field_192467_b = llllllllllllllIIIllllIllllIlIlIl;
        this.field_192468_c = llllllllllllllIIIllllIllllIlIIIl;
    }
    
    public EnchantmentPredicate() {
        this.field_192467_b = null;
        this.field_192468_c = MinMaxBounds.field_192516_a;
    }
    
    public boolean func_192463_a(final Map<Enchantment, Integer> llllllllllllllIIIllllIllllIIlIll) {
        if (this.field_192467_b != null) {
            if (!llllllllllllllIIIllllIllllIIlIll.containsKey(this.field_192467_b)) {
                return false;
            }
            final int llllllllllllllIIIllllIllllIIlIlI = llllllllllllllIIIllllIllllIIlIll.get(this.field_192467_b);
            if (this.field_192468_c != null && !this.field_192468_c.func_192514_a((float)llllllllllllllIIIllllIllllIIlIlI)) {
                return false;
            }
        }
        else if (this.field_192468_c != null) {
            for (final Integer llllllllllllllIIIllllIllllIIlIIl : llllllllllllllIIIllllIllllIIlIll.values()) {
                if (this.field_192468_c.func_192514_a(llllllllllllllIIIllllIllllIIlIIl)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public static EnchantmentPredicate[] func_192465_b(@Nullable final JsonElement llllllllllllllIIIllllIlllIlIllll) {
        if (llllllllllllllIIIllllIlllIlIllll != null && !llllllllllllllIIIllllIlllIlIllll.isJsonNull()) {
            final JsonArray llllllllllllllIIIllllIlllIllIIlI = JsonUtils.getJsonArray(llllllllllllllIIIllllIlllIlIllll, "enchantments");
            final EnchantmentPredicate[] llllllllllllllIIIllllIlllIllIIIl = new EnchantmentPredicate[llllllllllllllIIIllllIlllIllIIlI.size()];
            for (int llllllllllllllIIIllllIlllIllIIII = 0; llllllllllllllIIIllllIlllIllIIII < llllllllllllllIIIllllIlllIllIIIl.length; ++llllllllllllllIIIllllIlllIllIIII) {
                llllllllllllllIIIllllIlllIllIIIl[llllllllllllllIIIllllIlllIllIIII] = func_192464_a(llllllllllllllIIIllllIlllIllIIlI.get(llllllllllllllIIIllllIlllIllIIII));
            }
            return llllllllllllllIIIllllIlllIllIIIl;
        }
        return new EnchantmentPredicate[0];
    }
    
    public static EnchantmentPredicate func_192464_a(@Nullable final JsonElement llllllllllllllIIIllllIllllIIIIII) {
        if (llllllllllllllIIIllllIllllIIIIII != null && !llllllllllllllIIIllllIllllIIIIII.isJsonNull()) {
            final JsonObject llllllllllllllIIIllllIlllIllllll = JsonUtils.getJsonObject(llllllllllllllIIIllllIllllIIIIII, "enchantment");
            Enchantment llllllllllllllIIIllllIlllIlllllI = null;
            if (llllllllllllllIIIllllIlllIllllll.has("enchantment")) {
                final ResourceLocation llllllllllllllIIIllllIlllIllllIl = new ResourceLocation(JsonUtils.getString(llllllllllllllIIIllllIlllIllllll, "enchantment"));
                llllllllllllllIIIllllIlllIlllllI = Enchantment.REGISTRY.getObject(llllllllllllllIIIllllIlllIllllIl);
                if (llllllllllllllIIIllllIlllIlllllI == null) {
                    throw new JsonSyntaxException("Unknown enchantment '" + llllllllllllllIIIllllIlllIllllIl + "'");
                }
            }
            final MinMaxBounds llllllllllllllIIIllllIlllIllllII = MinMaxBounds.func_192515_a(llllllllllllllIIIllllIlllIllllll.get("levels"));
            return new EnchantmentPredicate(llllllllllllllIIIllllIlllIlllllI, llllllllllllllIIIllllIlllIllllII);
        }
        return EnchantmentPredicate.field_192466_a;
    }
    
    static {
        field_192466_a = new EnchantmentPredicate();
    }
}
