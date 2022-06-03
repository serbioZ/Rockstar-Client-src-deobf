// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.conditions;

import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;

public class RandomChanceWithLooting implements LootCondition
{
    private final /* synthetic */ float lootingMultiplier;
    private final /* synthetic */ float chance;
    
    public RandomChanceWithLooting(final float llllllllllllIIIIllllllIlIIlIllII, final float llllllllllllIIIIllllllIlIIlIlllI) {
        this.chance = llllllllllllIIIIllllllIlIIlIllII;
        this.lootingMultiplier = llllllllllllIIIIllllllIlIIlIlllI;
    }
    
    @Override
    public boolean testCondition(final Random llllllllllllIIIIllllllIlIIlIIlIl, final LootContext llllllllllllIIIIllllllIlIIlIIlII) {
        int llllllllllllIIIIllllllIlIIlIIIll = 0;
        if (llllllllllllIIIIllllllIlIIlIIlII.getKiller() instanceof EntityLivingBase) {
            llllllllllllIIIIllllllIlIIlIIIll = EnchantmentHelper.getLootingModifier((EntityLivingBase)llllllllllllIIIIllllllIlIIlIIlII.getKiller());
        }
        return llllllllllllIIIIllllllIlIIlIIlIl.nextFloat() < this.chance + llllllllllllIIIIllllllIlIIlIIIll * this.lootingMultiplier;
    }
    
    public static class Serializer extends LootCondition.Serializer<RandomChanceWithLooting>
    {
        @Override
        public void serialize(final JsonObject lllllllllllIllllllllllIIlllllIll, final RandomChanceWithLooting lllllllllllIllllllllllIIlllllIlI, final JsonSerializationContext lllllllllllIllllllllllIIllllllII) {
            lllllllllllIllllllllllIIlllllIll.addProperty("chance", (Number)lllllllllllIllllllllllIIlllllIlI.chance);
            lllllllllllIllllllllllIIlllllIll.addProperty("looting_multiplier", (Number)lllllllllllIllllllllllIIlllllIlI.lootingMultiplier);
        }
        
        protected Serializer() {
            super(new ResourceLocation("random_chance_with_looting"), RandomChanceWithLooting.class);
        }
        
        @Override
        public RandomChanceWithLooting deserialize(final JsonObject lllllllllllIllllllllllIIllllIlll, final JsonDeserializationContext lllllllllllIllllllllllIIllllIllI) {
            return new RandomChanceWithLooting(JsonUtils.getFloat(lllllllllllIllllllllllIIllllIlll, "chance"), JsonUtils.getFloat(lllllllllllIllllllllllIIllllIlll, "looting_multiplier"));
        }
    }
}
