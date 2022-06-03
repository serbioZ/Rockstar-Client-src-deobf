// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot.functions;

import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import com.google.common.collect.Maps;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class LootFunctionManager
{
    private static final /* synthetic */ Map<ResourceLocation, LootFunction.Serializer<?>> NAME_TO_SERIALIZER_MAP;
    private static final /* synthetic */ Map<Class<? extends LootFunction>, LootFunction.Serializer<?>> CLASS_TO_SERIALIZER_MAP;
    
    public static LootFunction.Serializer<?> getSerializerForName(final ResourceLocation llllllllllIlllIlllIllIlIIlllllIl) {
        final LootFunction.Serializer<?> llllllllllIlllIlllIllIlIIlllllII = LootFunctionManager.NAME_TO_SERIALIZER_MAP.get(llllllllllIlllIlllIllIlIIlllllIl);
        if (llllllllllIlllIlllIllIlIIlllllII == null) {
            throw new IllegalArgumentException("Unknown loot item function '" + llllllllllIlllIlllIllIlIIlllllIl + "'");
        }
        return llllllllllIlllIlllIllIlIIlllllII;
    }
    
    static {
        NAME_TO_SERIALIZER_MAP = Maps.newHashMap();
        CLASS_TO_SERIALIZER_MAP = Maps.newHashMap();
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetCount.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetMetadata.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new EnchantWithLevels.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new EnchantRandomly.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetNBT.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new Smelt.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new LootingEnchantBonus.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetDamage.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetAttributes.Serializer());
    }
    
    public static <T extends LootFunction> LootFunction.Serializer<T> getSerializerFor(final T llllllllllIlllIlllIllIlIIlllIlIl) {
        final LootFunction.Serializer<T> llllllllllIlllIlllIllIlIIlllIllI = (LootFunction.Serializer<T>)LootFunctionManager.CLASS_TO_SERIALIZER_MAP.get(llllllllllIlllIlllIllIlIIlllIlIl.getClass());
        if (llllllllllIlllIlllIllIlIIlllIllI == null) {
            throw new IllegalArgumentException("Unknown loot item function " + llllllllllIlllIlllIllIlIIlllIlIl);
        }
        return llllllllllIlllIlllIllIlIIlllIllI;
    }
    
    public static <T extends LootFunction> void registerFunction(final LootFunction.Serializer<? extends T> llllllllllIlllIlllIllIlIlIIIIlIl) {
        final ResourceLocation llllllllllIlllIlllIllIlIlIIIIlII = llllllllllIlllIlllIllIlIlIIIIlIl.getFunctionName();
        final Class<T> llllllllllIlllIlllIllIlIlIIIIIll = (Class<T>)llllllllllIlllIlllIllIlIlIIIIlIl.getFunctionClass();
        if (LootFunctionManager.NAME_TO_SERIALIZER_MAP.containsKey(llllllllllIlllIlllIllIlIlIIIIlII)) {
            throw new IllegalArgumentException("Can't re-register item function name " + llllllllllIlllIlllIllIlIlIIIIlII);
        }
        if (LootFunctionManager.CLASS_TO_SERIALIZER_MAP.containsKey(llllllllllIlllIlllIllIlIlIIIIIll)) {
            throw new IllegalArgumentException("Can't re-register item function class " + llllllllllIlllIlllIllIlIlIIIIIll.getName());
        }
        LootFunctionManager.NAME_TO_SERIALIZER_MAP.put(llllllllllIlllIlllIllIlIlIIIIlII, llllllllllIlllIlllIllIlIlIIIIlIl);
        LootFunctionManager.CLASS_TO_SERIALIZER_MAP.put(llllllllllIlllIlllIllIlIlIIIIIll, llllllllllIlllIlllIllIlIlIIIIlIl);
    }
    
    public static class Serializer implements JsonDeserializer<LootFunction>, JsonSerializer<LootFunction>
    {
        public JsonElement serialize(final LootFunction lllllllllllIlIlIIllIIllIIllIIIIl, final Type lllllllllllIlIlIIllIIllIIllIIlIl, final JsonSerializationContext lllllllllllIlIlIIllIIllIIllIIlII) {
            final LootFunction.Serializer<LootFunction> lllllllllllIlIlIIllIIllIIllIIIll = LootFunctionManager.getSerializerFor(lllllllllllIlIlIIllIIllIIllIIIIl);
            final JsonObject lllllllllllIlIlIIllIIllIIllIIIlI = new JsonObject();
            lllllllllllIlIlIIllIIllIIllIIIll.serialize(lllllllllllIlIlIIllIIllIIllIIIlI, lllllllllllIlIlIIllIIllIIllIIIIl, lllllllllllIlIlIIllIIllIIllIIlII);
            lllllllllllIlIlIIllIIllIIllIIIlI.addProperty("function", lllllllllllIlIlIIllIIllIIllIIIll.getFunctionName().toString());
            if (lllllllllllIlIlIIllIIllIIllIIIIl.getConditions() != null && lllllllllllIlIlIIllIIllIIllIIIIl.getConditions().length > 0) {
                lllllllllllIlIlIIllIIllIIllIIIlI.add("conditions", lllllllllllIlIlIIllIIllIIllIIlII.serialize((Object)lllllllllllIlIlIIllIIllIIllIIIIl.getConditions()));
            }
            return (JsonElement)lllllllllllIlIlIIllIIllIIllIIIlI;
        }
        
        public LootFunction deserialize(final JsonElement lllllllllllIlIlIIllIIllIIllllIIl, final Type lllllllllllIlIlIIllIIllIIllllIII, final JsonDeserializationContext lllllllllllIlIlIIllIIllIIlllIIII) throws JsonParseException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             "function"
            //     3: invokestatic    net/minecraft/util/JsonUtils.getJsonObject:(Lcom/google/gson/JsonElement;Ljava/lang/String;)Lcom/google/gson/JsonObject;
            //     6: astore          lllllllllllIlIlIIllIIllIIlllIllI
            //     8: new             Lnet/minecraft/util/ResourceLocation;
            //    11: dup            
            //    12: aload           lllllllllllIlIlIIllIIllIIlllIllI
            //    14: ldc             "function"
            //    16: invokestatic    net/minecraft/util/JsonUtils.getString:(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
            //    19: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
            //    22: astore          lllllllllllIlIlIIllIIllIIlllIlIl
            //    24: aload           lllllllllllIlIlIIllIIllIIlllIlIl
            //    26: invokestatic    net/minecraft/world/storage/loot/functions/LootFunctionManager.getSerializerForName:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/world/storage/loot/functions/LootFunction$Serializer;
            //    29: astore          lllllllllllIlIlIIllIIllIIlllIlII
            //    31: goto            66
            //    34: astore          lllllllllllIlIlIIllIIllIIlllIIlI
            //    36: new             Lcom/google/gson/JsonSyntaxException;
            //    39: dup            
            //    40: new             Ljava/lang/StringBuilder;
            //    43: dup            
            //    44: ldc             "Unknown function '"
            //    46: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
            //    49: aload           lllllllllllIlIlIIllIIllIIlllIlIl
            //    51: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //    54: ldc             "'"
            //    56: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    59: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    62: invokespecial   com/google/gson/JsonSyntaxException.<init>:(Ljava/lang/String;)V
            //    65: athrow         
            //    66: aload           lllllllllllIlIlIIllIIllIIlllIIll
            //    68: aload           lllllllllllIlIlIIllIIllIIlllIllI
            //    70: aload_3         /* lllllllllllIlIlIIllIIllIIlllIlll */
            //    71: aload           lllllllllllIlIlIIllIIllIIlllIllI
            //    73: ldc             "conditions"
            //    75: iconst_0       
            //    76: anewarray       Lnet/minecraft/world/storage/loot/conditions/LootCondition;
            //    79: aload_3         /* lllllllllllIlIlIIllIIllIIlllIlll */
            //    80: ldc             [Lnet/minecraft/world/storage/loot/conditions/LootCondition;.class
            //    82: invokestatic    net/minecraft/util/JsonUtils.deserializeClass:(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Object;Lcom/google/gson/JsonDeserializationContext;Ljava/lang/Class;)Ljava/lang/Object;
            //    85: checkcast       [Lnet/minecraft/world/storage/loot/conditions/LootCondition;
            //    88: invokevirtual   net/minecraft/world/storage/loot/functions/LootFunction$Serializer.deserialize:(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;[Lnet/minecraft/world/storage/loot/conditions/LootCondition;)Lnet/minecraft/world/storage/loot/functions/LootFunction;
            //    91: areturn        
            //    Exceptions:
            //  throws com.google.gson.JsonParseException
            //    StackMapTable: 00 02 FF 00 22 00 06 07 00 02 07 00 B3 07 00 B5 07 00 B7 07 00 37 07 00 43 00 01 07 00 6E FC 00 1F 07 00 0E
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
