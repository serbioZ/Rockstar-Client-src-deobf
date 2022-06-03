// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.conditions;

import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;

public interface LootCondition
{
    boolean testCondition(final Random p0, final LootContext p1);
    
    public abstract static class Serializer<T extends LootCondition>
    {
        private final /* synthetic */ Class<T> conditionClass;
        private final /* synthetic */ ResourceLocation lootTableLocation;
        
        public Class<T> getConditionClass() {
            return this.conditionClass;
        }
        
        public ResourceLocation getLootTableLocation() {
            return this.lootTableLocation;
        }
        
        protected Serializer(final ResourceLocation lllllllllllllIIllIllIIIIllllllIl, final Class<T> lllllllllllllIIllIllIIIIllllllII) {
            this.lootTableLocation = lllllllllllllIIllIllIIIIllllllIl;
            this.conditionClass = lllllllllllllIIllIllIIIIllllllII;
        }
        
        public abstract T deserialize(final JsonObject p0, final JsonDeserializationContext p1);
        
        public abstract void serialize(final JsonObject p0, final T p1, final JsonSerializationContext p2);
    }
}
