// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.properties;

import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import net.minecraft.entity.Entity;
import java.util.Random;

public class EntityOnFire implements EntityProperty
{
    private final /* synthetic */ boolean onFire;
    
    @Override
    public boolean testProperty(final Random lllllllllllIlIlIlIlIlllllIIIllIl, final Entity lllllllllllIlIlIlIlIlllllIIIllII) {
        return lllllllllllIlIlIlIlIlllllIIIllII.isBurning() == this.onFire;
    }
    
    public EntityOnFire(final boolean lllllllllllIlIlIlIlIlllllIIlIIIl) {
        this.onFire = lllllllllllIlIlIlIlIlllllIIlIIIl;
    }
    
    public static class Serializer extends EntityProperty.Serializer<EntityOnFire>
    {
        @Override
        public EntityOnFire deserialize(final JsonElement lllllllllllIIlIlIlIlllllllllllll, final JsonDeserializationContext lllllllllllIIlIlIlIllllllllllllI) {
            return new EntityOnFire(JsonUtils.getBoolean(lllllllllllIIlIlIlIlllllllllllll, "on_fire"));
        }
        
        @Override
        public JsonElement serialize(final EntityOnFire lllllllllllIIlIlIllIIIIIIIIIIlII, final JsonSerializationContext lllllllllllIIlIlIllIIIIIIIIIIIll) {
            return (JsonElement)new JsonPrimitive(Boolean.valueOf(lllllllllllIIlIlIllIIIIIIIIIIlII.onFire));
        }
        
        protected Serializer() {
            super(new ResourceLocation("on_fire"), EntityOnFire.class);
        }
    }
}
