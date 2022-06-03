// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.properties;

import com.google.common.collect.Maps;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class EntityPropertyManager
{
    private static final /* synthetic */ Map<ResourceLocation, EntityProperty.Serializer<?>> NAME_TO_SERIALIZER_MAP;
    private static final /* synthetic */ Map<Class<? extends EntityProperty>, EntityProperty.Serializer<?>> CLASS_TO_SERIALIZER_MAP;
    
    public static <T extends EntityProperty> EntityProperty.Serializer<T> getSerializerFor(final T lllllllllllllIlIlIlIIlllllIlIlll) {
        final EntityProperty.Serializer<?> lllllllllllllIlIlIlIIlllllIllIII = EntityPropertyManager.CLASS_TO_SERIALIZER_MAP.get(lllllllllllllIlIlIlIIlllllIlIlll.getClass());
        if (lllllllllllllIlIlIlIIlllllIllIII == null) {
            throw new IllegalArgumentException("Unknown loot entity property " + lllllllllllllIlIlIlIIlllllIlIlll);
        }
        return (EntityProperty.Serializer<T>)lllllllllllllIlIlIlIIlllllIllIII;
    }
    
    public static EntityProperty.Serializer<?> getSerializerForName(final ResourceLocation lllllllllllllIlIlIlIIlllllIlllIl) {
        final EntityProperty.Serializer<?> lllllllllllllIlIlIlIIlllllIllllI = EntityPropertyManager.NAME_TO_SERIALIZER_MAP.get(lllllllllllllIlIlIlIIlllllIlllIl);
        if (lllllllllllllIlIlIlIIlllllIllllI == null) {
            throw new IllegalArgumentException("Unknown loot entity property '" + lllllllllllllIlIlIlIIlllllIlllIl + "'");
        }
        return lllllllllllllIlIlIlIIlllllIllllI;
    }
    
    public static <T extends EntityProperty> void registerProperty(final EntityProperty.Serializer<? extends T> lllllllllllllIlIlIlIIllllllIIlII) {
        final ResourceLocation lllllllllllllIlIlIlIIllllllIIllI = lllllllllllllIlIlIlIIllllllIIlII.getName();
        final Class<T> lllllllllllllIlIlIlIIllllllIIlIl = (Class<T>)lllllllllllllIlIlIlIIllllllIIlII.getPropertyClass();
        if (EntityPropertyManager.NAME_TO_SERIALIZER_MAP.containsKey(lllllllllllllIlIlIlIIllllllIIllI)) {
            throw new IllegalArgumentException("Can't re-register entity property name " + lllllllllllllIlIlIlIIllllllIIllI);
        }
        if (EntityPropertyManager.CLASS_TO_SERIALIZER_MAP.containsKey(lllllllllllllIlIlIlIIllllllIIlIl)) {
            throw new IllegalArgumentException("Can't re-register entity property class " + lllllllllllllIlIlIlIIllllllIIlIl.getName());
        }
        EntityPropertyManager.NAME_TO_SERIALIZER_MAP.put(lllllllllllllIlIlIlIIllllllIIllI, lllllllllllllIlIlIlIIllllllIIlII);
        EntityPropertyManager.CLASS_TO_SERIALIZER_MAP.put(lllllllllllllIlIlIlIIllllllIIlIl, lllllllllllllIlIlIlIIllllllIIlII);
    }
    
    static {
        NAME_TO_SERIALIZER_MAP = Maps.newHashMap();
        CLASS_TO_SERIALIZER_MAP = Maps.newHashMap();
        registerProperty((EntityProperty.Serializer<? extends EntityProperty>)new EntityOnFire.Serializer());
    }
}
