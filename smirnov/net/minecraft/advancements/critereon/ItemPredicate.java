// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonElement;
import net.minecraft.enchantment.Enchantment;
import java.util.Map;
import net.minecraft.potion.PotionUtils;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.potion.PotionType;
import net.minecraft.item.Item;

public class ItemPredicate
{
    public static final /* synthetic */ ItemPredicate field_192495_a;
    private final /* synthetic */ Item field_192496_b;
    private final /* synthetic */ EnchantmentPredicate[] field_192499_e;
    private final /* synthetic */ MinMaxBounds field_193444_e;
    private final /* synthetic */ Integer field_192497_c;
    private final /* synthetic */ NBTPredicate field_193445_h;
    private final /* synthetic */ MinMaxBounds field_192498_d;
    private final /* synthetic */ PotionType field_192500_f;
    
    public ItemPredicate(@Nullable final Item lllllllllllIlllIlIIIIlIIlIIIllll, @Nullable final Integer lllllllllllIlllIlIIIIlIIlIIIIllI, final MinMaxBounds lllllllllllIlllIlIIIIlIIlIIIIlIl, final MinMaxBounds lllllllllllIlllIlIIIIlIIlIIIIlII, final EnchantmentPredicate[] lllllllllllIlllIlIIIIlIIlIIIlIll, @Nullable final PotionType lllllllllllIlllIlIIIIlIIlIIIIIlI, final NBTPredicate lllllllllllIlllIlIIIIlIIlIIIlIIl) {
        this.field_192496_b = lllllllllllIlllIlIIIIlIIlIIIllll;
        this.field_192497_c = lllllllllllIlllIlIIIIlIIlIIIIllI;
        this.field_192498_d = lllllllllllIlllIlIIIIlIIlIIIIlIl;
        this.field_193444_e = lllllllllllIlllIlIIIIlIIlIIIIlII;
        this.field_192499_e = lllllllllllIlllIlIIIIlIIlIIIlIll;
        this.field_192500_f = lllllllllllIlllIlIIIIlIIlIIIIIlI;
        this.field_193445_h = lllllllllllIlllIlIIIIlIIlIIIlIIl;
    }
    
    public boolean func_192493_a(final ItemStack lllllllllllIlllIlIIIIlIIIlllIllI) {
        if (this.field_192496_b != null && lllllllllllIlllIlIIIIlIIIlllIllI.getItem() != this.field_192496_b) {
            return false;
        }
        if (this.field_192497_c != null && lllllllllllIlllIlIIIIlIIIlllIllI.getMetadata() != this.field_192497_c) {
            return false;
        }
        if (!this.field_192498_d.func_192514_a((float)lllllllllllIlllIlIIIIlIIIlllIllI.func_190916_E())) {
            return false;
        }
        if (this.field_193444_e != MinMaxBounds.field_192516_a && !lllllllllllIlllIlIIIIlIIIlllIllI.isItemStackDamageable()) {
            return false;
        }
        if (!this.field_193444_e.func_192514_a((float)(lllllllllllIlllIlIIIIlIIIlllIllI.getMaxDamage() - lllllllllllIlllIlIIIIlIIIlllIllI.getItemDamage()))) {
            return false;
        }
        if (!this.field_193445_h.func_193478_a(lllllllllllIlllIlIIIIlIIIlllIllI)) {
            return false;
        }
        final Map<Enchantment, Integer> lllllllllllIlllIlIIIIlIIIllllIlI = EnchantmentHelper.getEnchantments(lllllllllllIlllIlIIIIlIIIlllIllI);
        for (int lllllllllllIlllIlIIIIlIIIllllIIl = 0; lllllllllllIlllIlIIIIlIIIllllIIl < this.field_192499_e.length; ++lllllllllllIlllIlIIIIlIIIllllIIl) {
            if (!this.field_192499_e[lllllllllllIlllIlIIIIlIIIllllIIl].func_192463_a(lllllllllllIlllIlIIIIlIIIllllIlI)) {
                return false;
            }
        }
        final PotionType lllllllllllIlllIlIIIIlIIIllllIII = PotionUtils.getPotionFromItem(lllllllllllIlllIlIIIIlIIIlllIllI);
        return this.field_192500_f == null || this.field_192500_f == lllllllllllIlllIlIIIIlIIIllllIII;
    }
    
    public ItemPredicate() {
        this.field_192496_b = null;
        this.field_192497_c = null;
        this.field_192500_f = null;
        this.field_192498_d = MinMaxBounds.field_192516_a;
        this.field_193444_e = MinMaxBounds.field_192516_a;
        this.field_192499_e = new EnchantmentPredicate[0];
        this.field_193445_h = NBTPredicate.field_193479_a;
    }
    
    public static ItemPredicate func_192492_a(@Nullable final JsonElement lllllllllllIlllIlIIIIlIIIlIllllI) {
        if (lllllllllllIlllIlIIIIlIIIlIllllI != null && !lllllllllllIlllIlIIIIlIIIlIllllI.isJsonNull()) {
            final JsonObject lllllllllllIlllIlIIIIlIIIllIlIII = JsonUtils.getJsonObject(lllllllllllIlllIlIIIIlIIIlIllllI, "item");
            final MinMaxBounds lllllllllllIlllIlIIIIlIIIllIIlll = MinMaxBounds.func_192515_a(lllllllllllIlllIlIIIIlIIIllIlIII.get("count"));
            final MinMaxBounds lllllllllllIlllIlIIIIlIIIllIIllI = MinMaxBounds.func_192515_a(lllllllllllIlllIlIIIIlIIIllIlIII.get("durability"));
            final Integer lllllllllllIlllIlIIIIlIIIllIIlIl = lllllllllllIlllIlIIIIlIIIllIlIII.has("data") ? Integer.valueOf(JsonUtils.getInt(lllllllllllIlllIlIIIIlIIIllIlIII, "data")) : null;
            final NBTPredicate lllllllllllIlllIlIIIIlIIIllIIlII = NBTPredicate.func_193476_a(lllllllllllIlllIlIIIIlIIIllIlIII.get("nbt"));
            Item lllllllllllIlllIlIIIIlIIIllIIIll = null;
            if (lllllllllllIlllIlIIIIlIIIllIlIII.has("item")) {
                final ResourceLocation lllllllllllIlllIlIIIIlIIIllIIIlI = new ResourceLocation(JsonUtils.getString(lllllllllllIlllIlIIIIlIIIllIlIII, "item"));
                lllllllllllIlllIlIIIIlIIIllIIIll = Item.REGISTRY.getObject(lllllllllllIlllIlIIIIlIIIllIIIlI);
                if (lllllllllllIlllIlIIIIlIIIllIIIll == null) {
                    throw new JsonSyntaxException("Unknown item id '" + lllllllllllIlllIlIIIIlIIIllIIIlI + "'");
                }
            }
            final EnchantmentPredicate[] lllllllllllIlllIlIIIIlIIIllIIIIl = EnchantmentPredicate.func_192465_b(lllllllllllIlllIlIIIIlIIIllIlIII.get("enchantments"));
            PotionType lllllllllllIlllIlIIIIlIIIllIIIII = null;
            if (lllllllllllIlllIlIIIIlIIIllIlIII.has("potion")) {
                final ResourceLocation lllllllllllIlllIlIIIIlIIIlIlllll = new ResourceLocation(JsonUtils.getString(lllllllllllIlllIlIIIIlIIIllIlIII, "potion"));
                if (!PotionType.REGISTRY.containsKey(lllllllllllIlllIlIIIIlIIIlIlllll)) {
                    throw new JsonSyntaxException("Unknown potion '" + lllllllllllIlllIlIIIIlIIIlIlllll + "'");
                }
                lllllllllllIlllIlIIIIlIIIllIIIII = PotionType.REGISTRY.getObject(lllllllllllIlllIlIIIIlIIIlIlllll);
            }
            return new ItemPredicate(lllllllllllIlllIlIIIIlIIIllIIIll, lllllllllllIlllIlIIIIlIIIllIIlIl, lllllllllllIlllIlIIIIlIIIllIIlll, lllllllllllIlllIlIIIIlIIIllIIllI, lllllllllllIlllIlIIIIlIIIllIIIIl, lllllllllllIlllIlIIIIlIIIllIIIII, lllllllllllIlllIlIIIIlIIIllIIlII);
        }
        return ItemPredicate.field_192495_a;
    }
    
    static {
        field_192495_a = new ItemPredicate();
    }
    
    public static ItemPredicate[] func_192494_b(@Nullable final JsonElement lllllllllllIlllIlIIIIlIIIlIIllII) {
        if (lllllllllllIlllIlIIIIlIIIlIIllII != null && !lllllllllllIlllIlIIIIlIIIlIIllII.isJsonNull()) {
            final JsonArray lllllllllllIlllIlIIIIlIIIlIIllll = JsonUtils.getJsonArray(lllllllllllIlllIlIIIIlIIIlIIllII, "items");
            final ItemPredicate[] lllllllllllIlllIlIIIIlIIIlIIlllI = new ItemPredicate[lllllllllllIlllIlIIIIlIIIlIIllll.size()];
            for (int lllllllllllIlllIlIIIIlIIIlIIllIl = 0; lllllllllllIlllIlIIIIlIIIlIIllIl < lllllllllllIlllIlIIIIlIIIlIIlllI.length; ++lllllllllllIlllIlIIIIlIIIlIIllIl) {
                lllllllllllIlllIlIIIIlIIIlIIlllI[lllllllllllIlllIlIIIIlIIIlIIllIl] = func_192492_a(lllllllllllIlllIlIIIIlIIIlIIllll.get(lllllllllllIlllIlIIIIlIIIlIIllIl));
            }
            return lllllllllllIlllIlIIIIlIIIlIIlllI;
        }
        return new ItemPredicate[0];
    }
}
