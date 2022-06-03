// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.conditions;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import com.google.common.collect.Maps;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class LootConditionManager
{
    private static final /* synthetic */ Map<ResourceLocation, LootCondition.Serializer<?>> NAME_TO_SERIALIZER_MAP;
    private static final /* synthetic */ Map<Class<? extends LootCondition>, LootCondition.Serializer<?>> CLASS_TO_SERIALIZER_MAP;
    
    public static boolean testAllConditions(@Nullable final LootCondition[] llllllllllIlllllIIlIIIIIIlllIlll, final Random llllllllllIlllllIIlIIIIIIllllIlI, final LootContext llllllllllIlllllIIlIIIIIIlllIlIl) {
        if (llllllllllIlllllIIlIIIIIIlllIlll == null) {
            return true;
        }
        final char llllllllllIlllllIIlIIIIIIlllIIIl = (Object)llllllllllIlllllIIlIIIIIIlllIlll;
        final int llllllllllIlllllIIlIIIIIIlllIIlI = llllllllllIlllllIIlIIIIIIlllIlll.length;
        for (long llllllllllIlllllIIlIIIIIIlllIIll = 0; llllllllllIlllllIIlIIIIIIlllIIll < llllllllllIlllllIIlIIIIIIlllIIlI; ++llllllllllIlllllIIlIIIIIIlllIIll) {
            final LootCondition llllllllllIlllllIIlIIIIIIllllIII = llllllllllIlllllIIlIIIIIIlllIIIl[llllllllllIlllllIIlIIIIIIlllIIll];
            if (!llllllllllIlllllIIlIIIIIIllllIII.testCondition(llllllllllIlllllIIlIIIIIIllllIlI, llllllllllIlllllIIlIIIIIIlllIlIl)) {
                return false;
            }
        }
        return true;
    }
    
    public static <T extends LootCondition> void registerCondition(final LootCondition.Serializer<? extends T> llllllllllIlllllIIlIIIIIlIIIlIII) {
        final ResourceLocation llllllllllIlllllIIlIIIIIlIIIIlll = llllllllllIlllllIIlIIIIIlIIIlIII.getLootTableLocation();
        final Class<T> llllllllllIlllllIIlIIIIIlIIIIllI = (Class<T>)llllllllllIlllllIIlIIIIIlIIIlIII.getConditionClass();
        if (LootConditionManager.NAME_TO_SERIALIZER_MAP.containsKey(llllllllllIlllllIIlIIIIIlIIIIlll)) {
            throw new IllegalArgumentException("Can't re-register item condition name " + llllllllllIlllllIIlIIIIIlIIIIlll);
        }
        if (LootConditionManager.CLASS_TO_SERIALIZER_MAP.containsKey(llllllllllIlllllIIlIIIIIlIIIIllI)) {
            throw new IllegalArgumentException("Can't re-register item condition class " + llllllllllIlllllIIlIIIIIlIIIIllI.getName());
        }
        LootConditionManager.NAME_TO_SERIALIZER_MAP.put(llllllllllIlllllIIlIIIIIlIIIIlll, llllllllllIlllllIIlIIIIIlIIIlIII);
        LootConditionManager.CLASS_TO_SERIALIZER_MAP.put(llllllllllIlllllIIlIIIIIlIIIIllI, llllllllllIlllllIIlIIIIIlIIIlIII);
    }
    
    public static LootCondition.Serializer<?> getSerializerForName(final ResourceLocation llllllllllIlllllIIlIIIIIIllIllII) {
        final LootCondition.Serializer<?> llllllllllIlllllIIlIIIIIIllIllIl = LootConditionManager.NAME_TO_SERIALIZER_MAP.get(llllllllllIlllllIIlIIIIIIllIllII);
        if (llllllllllIlllllIIlIIIIIIllIllIl == null) {
            throw new IllegalArgumentException("Unknown loot item condition '" + llllllllllIlllllIIlIIIIIIllIllII + "'");
        }
        return llllllllllIlllllIIlIIIIIIllIllIl;
    }
    
    static {
        NAME_TO_SERIALIZER_MAP = Maps.newHashMap();
        CLASS_TO_SERIALIZER_MAP = Maps.newHashMap();
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new RandomChance.Serializer());
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new RandomChanceWithLooting.Serializer());
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new EntityHasProperty.Serializer());
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new KilledByPlayer.Serializer());
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new EntityHasScore.Serializer());
    }
    
    public static <T extends LootCondition> LootCondition.Serializer<T> getSerializerFor(final T llllllllllIlllllIIlIIIIIIllIIllI) {
        final LootCondition.Serializer<T> llllllllllIlllllIIlIIIIIIllIIlll = (LootCondition.Serializer<T>)LootConditionManager.CLASS_TO_SERIALIZER_MAP.get(llllllllllIlllllIIlIIIIIIllIIllI.getClass());
        if (llllllllllIlllllIIlIIIIIIllIIlll == null) {
            throw new IllegalArgumentException("Unknown loot item condition " + llllllllllIlllllIIlIIIIIIllIIllI);
        }
        return llllllllllIlllllIIlIIIIIIllIIlll;
    }
    
    public static class Serializer implements JsonDeserializer<LootCondition>, JsonSerializer<LootCondition>
    {
        public JsonElement serialize(final LootCondition lllllllllllIIIIIlIllllIlIlIIlIll, final Type lllllllllllIIIIIlIllllIlIlIIllll, final JsonSerializationContext lllllllllllIIIIIlIllllIlIlIIlllI) {
            final LootCondition.Serializer<LootCondition> lllllllllllIIIIIlIllllIlIlIIllIl = LootConditionManager.getSerializerFor(lllllllllllIIIIIlIllllIlIlIIlIll);
            final JsonObject lllllllllllIIIIIlIllllIlIlIIllII = new JsonObject();
            lllllllllllIIIIIlIllllIlIlIIllIl.serialize(lllllllllllIIIIIlIllllIlIlIIllII, lllllllllllIIIIIlIllllIlIlIIlIll, lllllllllllIIIIIlIllllIlIlIIlllI);
            lllllllllllIIIIIlIllllIlIlIIllII.addProperty("condition", lllllllllllIIIIIlIllllIlIlIIllIl.getLootTableLocation().toString());
            return (JsonElement)lllllllllllIIIIIlIllllIlIlIIllII;
        }
        
        public LootCondition deserialize(final JsonElement lllllllllllIIIIIlIllllIlIllIIIll, final Type lllllllllllIIIIIlIllllIlIllIIIlI, final JsonDeserializationContext lllllllllllIIIIIlIllllIlIllIIIIl) throws JsonParseException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             "condition"
            //     3: invokestatic    net/minecraft/util/JsonUtils.getJsonObject:(Lcom/google/gson/JsonElement;Ljava/lang/String;)Lcom/google/gson/JsonObject;
            //     6: astore          lllllllllllIIIIIlIllllIlIllIIIII
            //     8: new             Lnet/minecraft/util/ResourceLocation;
            //    11: dup            
            //    12: aload           lllllllllllIIIIIlIllllIlIllIIIII
            //    14: ldc             "condition"
            //    16: invokestatic    net/minecraft/util/JsonUtils.getString:(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
            //    19: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
            //    22: astore          lllllllllllIIIIIlIllllIlIlIlllll
            //    24: aload           lllllllllllIIIIIlIllllIlIlIlllll
            //    26: invokestatic    net/minecraft/world/storage/loot/conditions/LootConditionManager.getSerializerForName:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/world/storage/loot/conditions/LootCondition$Serializer;
            //    29: astore          lllllllllllIIIIIlIllllIlIlIllllI
            //    31: goto            66
            //    34: astore          lllllllllllIIIIIlIllllIlIlIlllII
            //    36: new             Lcom/google/gson/JsonSyntaxException;
            //    39: dup            
            //    40: new             Ljava/lang/StringBuilder;
            //    43: dup            
            //    44: ldc             "Unknown condition '"
            //    46: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
            //    49: aload           lllllllllllIIIIIlIllllIlIlIlllll
            //    51: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //    54: ldc             "'"
            //    56: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    59: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    62: invokespecial   com/google/gson/JsonSyntaxException.<init>:(Ljava/lang/String;)V
            //    65: athrow         
            //    66: aload           lllllllllllIIIIIlIllllIlIlIlllIl
            //    68: aload           lllllllllllIIIIIlIllllIlIllIIIII
            //    70: aload_3         /* lllllllllllIIIIIlIllllIlIlIllIlI */
            //    71: invokevirtual   net/minecraft/world/storage/loot/conditions/LootCondition$Serializer.deserialize:(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/world/storage/loot/conditions/LootCondition;
            //    74: areturn        
            //    Exceptions:
            //  throws com.google.gson.JsonParseException
            //    StackMapTable: 00 02 FF 00 22 00 06 07 00 02 07 00 9B 07 00 9D 07 00 9F 07 00 30 07 00 3F 00 01 07 00 5F FC 00 1F 07 00 0B
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                
            //  -----  -----  -----  -----  ------------------------------------
            //  24     31     34     66     Ljava/lang/IllegalArgumentException;
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
    }
}
