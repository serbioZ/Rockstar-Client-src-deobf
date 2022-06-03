// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.conditions;

import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;

public class RandomChance implements LootCondition
{
    private final /* synthetic */ float chance;
    
    @Override
    public boolean testCondition(final Random lllllllllllIlIllIIIllIIlIIIIIlII, final LootContext lllllllllllIlIllIIIllIIlIIIIIIll) {
        return lllllllllllIlIllIIIllIIlIIIIIlII.nextFloat() < this.chance;
    }
    
    public RandomChance(final float lllllllllllIlIllIIIllIIlIIIIlIII) {
        this.chance = lllllllllllIlIllIIIllIIlIIIIlIII;
    }
    
    public static class Serializer extends LootCondition.Serializer<RandomChance>
    {
        protected Serializer() {
            super(new ResourceLocation("random_chance"), RandomChance.class);
        }
        
        @Override
        public RandomChance deserialize(final JsonObject llllllllllIlllllIIIIIIllIllIIlll, final JsonDeserializationContext llllllllllIlllllIIIIIIllIllIlIII) {
            return new RandomChance(JsonUtils.getFloat(llllllllllIlllllIIIIIIllIllIIlll, "chance"));
        }
        
        @Override
        public void serialize(final JsonObject llllllllllIlllllIIIIIIllIlllIIII, final RandomChance llllllllllIlllllIIIIIIllIllIllII, final JsonSerializationContext llllllllllIlllllIIIIIIllIllIlllI) {
            llllllllllIlllllIIIIIIllIlllIIII.addProperty("chance", (Number)llllllllllIlllllIIIIIIllIllIllII.chance);
        }
    }
}
