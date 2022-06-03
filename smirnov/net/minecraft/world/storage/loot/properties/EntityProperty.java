// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.properties;

import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import java.util.Random;

public interface EntityProperty
{
    boolean testProperty(final Random p0, final Entity p1);
    
    public abstract static class Serializer<T extends EntityProperty>
    {
        private final /* synthetic */ ResourceLocation name;
        private final /* synthetic */ Class<T> propertyClass;
        
        protected Serializer(final ResourceLocation lllllllllllIlllIIllIlIlllllIllII, final Class<T> lllllllllllIlllIIllIlIlllllIlIll) {
            this.name = lllllllllllIlllIIllIlIlllllIllII;
            this.propertyClass = lllllllllllIlllIIllIlIlllllIlIll;
        }
        
        public Class<T> getPropertyClass() {
            return this.propertyClass;
        }
        
        public abstract T deserialize(final JsonElement p0, final JsonDeserializationContext p1);
        
        public ResourceLocation getName() {
            return this.name;
        }
        
        public abstract JsonElement serialize(final T p0, final JsonSerializationContext p1);
    }
}
