// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.RandomValueRange;

public class EnchantWithLevels extends LootFunction
{
    private final /* synthetic */ boolean isTreasure;
    private final /* synthetic */ RandomValueRange randomLevel;
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllIlIIIlIlIlIIIIIIIlllI, final Random lllllllllllIlIIIlIlIlIIIIIIIllIl, final LootContext lllllllllllIlIIIlIlIlIIIIIIlIIII) {
        return EnchantmentHelper.addRandomEnchantment(lllllllllllIlIIIlIlIlIIIIIIIllIl, lllllllllllIlIIIlIlIlIIIIIIIlllI, this.randomLevel.generateInt(lllllllllllIlIIIlIlIlIIIIIIIllIl), this.isTreasure);
    }
    
    public EnchantWithLevels(final LootCondition[] lllllllllllIlIIIlIlIlIIIIIIllIIl, final RandomValueRange lllllllllllIlIIIlIlIlIIIIIIlllII, final boolean lllllllllllIlIIIlIlIlIIIIIIlIlll) {
        super(lllllllllllIlIIIlIlIlIIIIIIllIIl);
        this.randomLevel = lllllllllllIlIIIlIlIlIIIIIIlllII;
        this.isTreasure = lllllllllllIlIIIlIlIlIIIIIIlIlll;
    }
    
    public static class Serializer extends LootFunction.Serializer<EnchantWithLevels>
    {
        @Override
        public EnchantWithLevels deserialize(final JsonObject llllllllllllIIIllIlIIIllIIllllII, final JsonDeserializationContext llllllllllllIIIllIlIIIllIIlllIll, final LootCondition[] llllllllllllIIIllIlIIIllIIllIlIl) {
            final RandomValueRange llllllllllllIIIllIlIIIllIIlllIIl = JsonUtils.deserializeClass(llllllllllllIIIllIlIIIllIIllllII, "levels", llllllllllllIIIllIlIIIllIIlllIll, (Class<? extends RandomValueRange>)RandomValueRange.class);
            final boolean llllllllllllIIIllIlIIIllIIlllIII = JsonUtils.getBoolean(llllllllllllIIIllIlIIIllIIllllII, "treasure", false);
            return new EnchantWithLevels(llllllllllllIIIllIlIIIllIIllIlIl, llllllllllllIIIllIlIIIllIIlllIIl, llllllllllllIIIllIlIIIllIIlllIII);
        }
        
        @Override
        public void serialize(final JsonObject llllllllllllIIIllIlIIIllIlIIlIII, final EnchantWithLevels llllllllllllIIIllIlIIIllIlIIIlll, final JsonSerializationContext llllllllllllIIIllIlIIIllIlIIIllI) {
            llllllllllllIIIllIlIIIllIlIIlIII.add("levels", llllllllllllIIIllIlIIIllIlIIIllI.serialize((Object)llllllllllllIIIllIlIIIllIlIIIlll.randomLevel));
            llllllllllllIIIllIlIIIllIlIIlIII.addProperty("treasure", Boolean.valueOf(llllllllllllIIIllIlIIIllIlIIIlll.isTreasure));
        }
        
        public Serializer() {
            super(new ResourceLocation("enchant_with_levels"), EnchantWithLevels.class);
        }
    }
}
