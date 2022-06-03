// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.RandomValueRange;

public class LootingEnchantBonus extends LootFunction
{
    private final /* synthetic */ RandomValueRange count;
    private final /* synthetic */ int limit;
    
    public LootingEnchantBonus(final LootCondition[] lllllllllllIllIIlIIIIIlIIIllIIlI, final RandomValueRange lllllllllllIllIIlIIIIIlIIIllIIIl, final int lllllllllllIllIIlIIIIIlIIIllIIII) {
        super(lllllllllllIllIIlIIIIIlIIIllIIlI);
        this.count = lllllllllllIllIIlIIIIIlIIIllIIIl;
        this.limit = lllllllllllIllIIlIIIIIlIIIllIIII;
    }
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllIllIIlIIIIIlIIIIlllII, final Random lllllllllllIllIIlIIIIIlIIIIllIll, final LootContext lllllllllllIllIIlIIIIIlIIIlIIIIl) {
        final Entity lllllllllllIllIIlIIIIIlIIIlIIIII = lllllllllllIllIIlIIIIIlIIIlIIIIl.getKiller();
        if (lllllllllllIllIIlIIIIIlIIIlIIIII instanceof EntityLivingBase) {
            final int lllllllllllIllIIlIIIIIlIIIIlllll = EnchantmentHelper.getLootingModifier((EntityLivingBase)lllllllllllIllIIlIIIIIlIIIlIIIII);
            if (lllllllllllIllIIlIIIIIlIIIIlllll == 0) {
                return lllllllllllIllIIlIIIIIlIIIIlllII;
            }
            final float lllllllllllIllIIlIIIIIlIIIIllllI = lllllllllllIllIIlIIIIIlIIIIlllll * this.count.generateFloat(lllllllllllIllIIlIIIIIlIIIIllIll);
            lllllllllllIllIIlIIIIIlIIIIlllII.func_190917_f(Math.round(lllllllllllIllIIlIIIIIlIIIIllllI));
            if (this.limit != 0 && lllllllllllIllIIlIIIIIlIIIIlllII.func_190916_E() > this.limit) {
                lllllllllllIllIIlIIIIIlIIIIlllII.func_190920_e(this.limit);
            }
        }
        return lllllllllllIllIIlIIIIIlIIIIlllII;
    }
    
    public static class Serializer extends LootFunction.Serializer<LootingEnchantBonus>
    {
        @Override
        public void serialize(final JsonObject lllllllllllIlIIllllIlIlIllIlllIl, final LootingEnchantBonus lllllllllllIlIIllllIlIlIllIlllll, final JsonSerializationContext lllllllllllIlIIllllIlIlIllIllIll) {
            lllllllllllIlIIllllIlIlIllIlllIl.add("count", lllllllllllIlIIllllIlIlIllIllIll.serialize((Object)lllllllllllIlIIllllIlIlIllIlllll.count));
            if (lllllllllllIlIIllllIlIlIllIlllll.limit > 0) {
                lllllllllllIlIIllllIlIlIllIlllIl.add("limit", lllllllllllIlIIllllIlIlIllIllIll.serialize((Object)lllllllllllIlIIllllIlIlIllIlllll.limit));
            }
        }
        
        protected Serializer() {
            super(new ResourceLocation("looting_enchant"), LootingEnchantBonus.class);
        }
        
        @Override
        public LootingEnchantBonus deserialize(final JsonObject lllllllllllIlIIllllIlIlIllIlIlIl, final JsonDeserializationContext lllllllllllIlIIllllIlIlIllIlIIII, final LootCondition[] lllllllllllIlIIllllIlIlIllIlIIll) {
            final int lllllllllllIlIIllllIlIlIllIlIIlI = JsonUtils.getInt(lllllllllllIlIIllllIlIlIllIlIlIl, "limit", 0);
            return new LootingEnchantBonus(lllllllllllIlIIllllIlIlIllIlIIll, JsonUtils.deserializeClass(lllllllllllIlIIllllIlIlIllIlIlIl, "count", lllllllllllIlIIllllIlIlIllIlIIII, (Class<? extends RandomValueRange>)RandomValueRange.class), lllllllllllIlIIllllIlIlIllIlIIlI);
        }
    }
}
