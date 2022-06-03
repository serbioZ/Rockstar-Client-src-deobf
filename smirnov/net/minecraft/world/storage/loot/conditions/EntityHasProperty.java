// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.conditions;

import com.google.gson.JsonSerializationContext;
import java.util.Set;
import net.minecraft.world.storage.loot.properties.EntityPropertyManager;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonElement;
import java.util.Map;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.entity.Entity;
import java.util.Random;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.properties.EntityProperty;

public class EntityHasProperty implements LootCondition
{
    private final /* synthetic */ EntityProperty[] properties;
    private final /* synthetic */ LootContext.EntityTarget target;
    
    public EntityHasProperty(final EntityProperty[] llllllllllllIllIlIlIlIIlllIIlIll, final LootContext.EntityTarget llllllllllllIllIlIlIlIIlllIIlIlI) {
        this.properties = llllllllllllIllIlIlIlIIlllIIlIll;
        this.target = llllllllllllIllIlIlIlIIlllIIlIlI;
    }
    
    @Override
    public boolean testCondition(final Random llllllllllllIllIlIlIlIIllIlllIll, final LootContext llllllllllllIllIlIlIlIIllIllllll) {
        final Entity llllllllllllIllIlIlIlIIllIlllllI = llllllllllllIllIlIlIlIIllIllllll.getEntity(this.target);
        if (llllllllllllIllIlIlIlIIllIlllllI == null) {
            return false;
        }
        final boolean llllllllllllIllIlIlIlIIllIllIlIl;
        final Exception llllllllllllIllIlIlIlIIllIllIllI = (Exception)((EntityProperty[])(Object)(llllllllllllIllIlIlIlIIllIllIlIl = (boolean)(Object)this.properties)).length;
        for (final EntityProperty llllllllllllIllIlIlIlIIllIllllIl : llllllllllllIllIlIlIlIIllIllIlIl) {
            if (!llllllllllllIllIlIlIlIIllIllllIl.testProperty(llllllllllllIllIlIlIlIIllIlllIll, llllllllllllIllIlIlIlIIllIlllllI)) {
                return false;
            }
        }
        return true;
    }
    
    public static class Serializer extends LootCondition.Serializer<EntityHasProperty>
    {
        @Override
        public EntityHasProperty deserialize(final JsonObject lllllllllllIIlIIlIIIIlIIlllIlIll, final JsonDeserializationContext lllllllllllIIlIIlIIIIlIIlllIIlII) {
            final Set<Map.Entry<String, JsonElement>> lllllllllllIIlIIlIIIIlIIlllIlIIl = (Set<Map.Entry<String, JsonElement>>)JsonUtils.getJsonObject(lllllllllllIIlIIlIIIIlIIlllIlIll, "properties").entrySet();
            final EntityProperty[] lllllllllllIIlIIlIIIIlIIlllIlIII = new EntityProperty[lllllllllllIIlIIlIIIIlIIlllIlIIl.size()];
            int lllllllllllIIlIIlIIIIlIIlllIIlll = 0;
            for (final Map.Entry<String, JsonElement> lllllllllllIIlIIlIIIIlIIlllIIllI : lllllllllllIIlIIlIIIIlIIlllIlIIl) {
                lllllllllllIIlIIlIIIIlIIlllIlIII[lllllllllllIIlIIlIIIIlIIlllIIlll++] = (EntityProperty)EntityPropertyManager.getSerializerForName(new ResourceLocation(lllllllllllIIlIIlIIIIlIIlllIIllI.getKey())).deserialize(lllllllllllIIlIIlIIIIlIIlllIIllI.getValue(), lllllllllllIIlIIlIIIIlIIlllIIlII);
            }
            return new EntityHasProperty(lllllllllllIIlIIlIIIIlIIlllIlIII, JsonUtils.deserializeClass(lllllllllllIIlIIlIIIIlIIlllIlIll, "entity", lllllllllllIIlIIlIIIIlIIlllIIlII, (Class<? extends LootContext.EntityTarget>)LootContext.EntityTarget.class));
        }
        
        protected Serializer() {
            super(new ResourceLocation("entity_properties"), EntityHasProperty.class);
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllIIlIIlIIIIlIIllllllII, final EntityHasProperty lllllllllllIIlIIlIIIIlIlIIIIIIIl, final JsonSerializationContext lllllllllllIIlIIlIIIIlIlIIIIIIII) {
            final JsonObject lllllllllllIIlIIlIIIIlIIllllllll = new JsonObject();
            final float lllllllllllIIlIIlIIIIlIIllllIlIl;
            final byte lllllllllllIIlIIlIIIIlIIllllIllI = (byte)((EntityProperty[])(Object)(lllllllllllIIlIIlIIIIlIIllllIlIl = (float)(Object)lllllllllllIIlIIlIIIIlIlIIIIIIIl.properties)).length;
            for (final EntityProperty lllllllllllIIlIIlIIIIlIIlllllllI : lllllllllllIIlIIlIIIIlIIllllIlIl) {
                final EntityProperty.Serializer<EntityProperty> lllllllllllIIlIIlIIIIlIIllllllIl = EntityPropertyManager.getSerializerFor(lllllllllllIIlIIlIIIIlIIlllllllI);
                lllllllllllIIlIIlIIIIlIIllllllll.add(lllllllllllIIlIIlIIIIlIIllllllIl.getName().toString(), lllllllllllIIlIIlIIIIlIIllllllIl.serialize(lllllllllllIIlIIlIIIIlIIlllllllI, lllllllllllIIlIIlIIIIlIlIIIIIIII));
            }
            lllllllllllIIlIIlIIIIlIIllllllII.add("properties", (JsonElement)lllllllllllIIlIIlIIIIlIIllllllll);
            lllllllllllIIlIIlIIIIlIIllllllII.add("entity", lllllllllllIIlIIlIIIIlIlIIIIIIII.serialize((Object)lllllllllllIIlIIlIIIIlIlIIIIIIIl.target));
        }
    }
}
