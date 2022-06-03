// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage.loot;

import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunctionManager;
import net.minecraft.world.storage.loot.functions.LootFunction;
import java.lang.reflect.Type;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheBuilder;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import com.google.common.cache.LoadingCache;
import java.io.File;
import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;

public class LootTableManager
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ File baseFolder;
    private final /* synthetic */ LoadingCache<ResourceLocation, LootTable> registeredLootTables;
    
    public LootTableManager(@Nullable final File lllllllllllllIlIIIlIllllIIlIllIl) {
        this.registeredLootTables = (LoadingCache<ResourceLocation, LootTable>)CacheBuilder.newBuilder().build((CacheLoader)new Loader((Loader)null));
        this.baseFolder = lllllllllllllIlIIIlIllllIIlIllIl;
        this.reloadLootTables();
    }
    
    public void reloadLootTables() {
        this.registeredLootTables.invalidateAll();
        for (final ResourceLocation lllllllllllllIlIIIlIllllIIlIIIlI : LootTableList.getAll()) {
            this.getLootTableFromLocation(lllllllllllllIlIIIlIllllIIlIIIlI);
        }
    }
    
    public LootTable getLootTableFromLocation(final ResourceLocation lllllllllllllIlIIIlIllllIIlIIlll) {
        return (LootTable)this.registeredLootTables.getUnchecked((Object)lllllllllllllIlIIIlIllllIIlIIlll);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        GSON_INSTANCE = new GsonBuilder().registerTypeAdapter((Type)RandomValueRange.class, (Object)new RandomValueRange.Serializer()).registerTypeAdapter((Type)LootPool.class, (Object)new LootPool.Serializer()).registerTypeAdapter((Type)LootTable.class, (Object)new LootTable.Serializer()).registerTypeHierarchyAdapter((Class)LootEntry.class, (Object)new LootEntry.Serializer()).registerTypeHierarchyAdapter((Class)LootFunction.class, (Object)new LootFunctionManager.Serializer()).registerTypeHierarchyAdapter((Class)LootCondition.class, (Object)new LootConditionManager.Serializer()).registerTypeHierarchyAdapter((Class)LootContext.EntityTarget.class, (Object)new LootContext.EntityTarget.Serializer()).create();
    }
    
    class Loader extends CacheLoader<ResourceLocation, LootTable>
    {
        @Nullable
        private LootTable loadLootTable(final ResourceLocation lllllllllllIIlIIIIlIIIllIIlIIllI) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        net/minecraft/world/storage/loot/LootTableManager$Loader.this$0:Lnet/minecraft/world/storage/loot/LootTableManager;
            //     4: invokestatic    net/minecraft/world/storage/loot/LootTableManager.access$1:(Lnet/minecraft/world/storage/loot/LootTableManager;)Ljava/io/File;
            //     7: ifnonnull       12
            //    10: aconst_null    
            //    11: areturn        
            //    12: new             Ljava/io/File;
            //    15: dup            
            //    16: new             Ljava/io/File;
            //    19: dup            
            //    20: aload_0         /* lllllllllllIIlIIIIlIIIllIIlIlllI */
            //    21: getfield        net/minecraft/world/storage/loot/LootTableManager$Loader.this$0:Lnet/minecraft/world/storage/loot/LootTableManager;
            //    24: invokestatic    net/minecraft/world/storage/loot/LootTableManager.access$1:(Lnet/minecraft/world/storage/loot/LootTableManager;)Ljava/io/File;
            //    27: aload_1         /* lllllllllllIIlIIIIlIIIllIIlIllIl */
            //    28: invokevirtual   net/minecraft/util/ResourceLocation.getResourceDomain:()Ljava/lang/String;
            //    31: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
            //    34: new             Ljava/lang/StringBuilder;
            //    37: dup            
            //    38: aload_1         /* lllllllllllIIlIIIIlIIIllIIlIllIl */
            //    39: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
            //    42: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //    45: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
            //    48: ldc             ".json"
            //    50: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    53: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    56: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
            //    59: astore_2        /* lllllllllllIIlIIIIlIIIllIIlIIlIl */
            //    60: aload_2         /* lllllllllllIIlIIIIlIIIllIIlIllII */
            //    61: invokevirtual   java/io/File.exists:()Z
            //    64: ifeq            154
            //    67: aload_2         /* lllllllllllIIlIIIIlIIIllIIlIllII */
            //    68: invokevirtual   java/io/File.isFile:()Z
            //    71: ifeq            138
            //    74: aload_2         /* lllllllllllIIlIIIIlIIIllIIlIllII */
            //    75: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
            //    78: invokestatic    com/google/common/io/Files.toString:(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/lang/String;
            //    81: astore_3        /* lllllllllllIIlIIIIlIIIllIIlIlIll */
            //    82: goto            105
            //    85: astore          lllllllllllIIlIIIIlIIIllIIlIlIIl
            //    87: invokestatic    net/minecraft/world/storage/loot/LootTableManager.access$0:()Lorg/apache/logging/log4j/Logger;
            //    90: ldc             "Couldn't load loot table {} from {}"
            //    92: aload_1         /* lllllllllllIIlIIIIlIIIllIIlIllIl */
            //    93: aload_2         /* lllllllllllIIlIIIIlIIIllIIlIllII */
            //    94: aload           lllllllllllIIlIIIIlIIIllIIlIlIIl
            //    96: invokeinterface org/apache/logging/log4j/Logger.warn:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
            //   101: getstatic       net/minecraft/world/storage/loot/LootTable.EMPTY_LOOT_TABLE:Lnet/minecraft/world/storage/loot/LootTable;
            //   104: areturn        
            //   105: invokestatic    net/minecraft/world/storage/loot/LootTableManager.access$2:()Lcom/google/gson/Gson;
            //   108: aload_3         /* lllllllllllIIlIIIIlIIIllIIlIlIlI */
            //   109: ldc             Lnet/minecraft/world/storage/loot/LootTable;.class
            //   111: invokestatic    net/minecraft/util/JsonUtils.gsonDeserialize:(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
            //   114: checkcast       Lnet/minecraft/world/storage/loot/LootTable;
            //   117: areturn        
            //   118: astore          lllllllllllIIlIIIIlIIIllIIlIlIII
            //   120: invokestatic    net/minecraft/world/storage/loot/LootTableManager.access$0:()Lorg/apache/logging/log4j/Logger;
            //   123: ldc             "Couldn't load loot table {} from {}"
            //   125: aload_1         /* lllllllllllIIlIIIIlIIIllIIlIllIl */
            //   126: aload_2         /* lllllllllllIIlIIIIlIIIllIIlIllII */
            //   127: aload           lllllllllllIIlIIIIlIIIllIIlIlIII
            //   129: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
            //   134: getstatic       net/minecraft/world/storage/loot/LootTable.EMPTY_LOOT_TABLE:Lnet/minecraft/world/storage/loot/LootTable;
            //   137: areturn        
            //   138: invokestatic    net/minecraft/world/storage/loot/LootTableManager.access$0:()Lorg/apache/logging/log4j/Logger;
            //   141: ldc             "Expected to find loot table {} at {} but it was a folder."
            //   143: aload_1         /* lllllllllllIIlIIIIlIIIllIIlIllIl */
            //   144: aload_2         /* lllllllllllIIlIIIIlIIIllIIlIllII */
            //   145: invokeinterface org/apache/logging/log4j/Logger.warn:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
            //   150: getstatic       net/minecraft/world/storage/loot/LootTable.EMPTY_LOOT_TABLE:Lnet/minecraft/world/storage/loot/LootTable;
            //   153: areturn        
            //   154: aconst_null    
            //   155: areturn        
            //    RuntimeVisibleTypeAnnotations: 00 01 14 00 00 0D 00 00
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                
            //  -----  -----  -----  -----  ------------------------------------
            //  74     82     85     105    Ljava/io/IOException;
            //  105    117    118    138    Ljava/lang/IllegalArgumentException;
            //  105    117    118    138    Lcom/google/gson/JsonParseException;
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        public LootTable load(final ResourceLocation lllllllllllIIlIIIIlIIIllIIllIlIl) throws Exception {
            if (lllllllllllIIlIIIIlIIIllIIllIlIl.getResourcePath().contains(".")) {
                LootTableManager.LOGGER.debug("Invalid loot table name '{}' (can't contain periods)", (Object)lllllllllllIIlIIIIlIIIllIIllIlIl);
                return LootTable.EMPTY_LOOT_TABLE;
            }
            LootTable lllllllllllIIlIIIIlIIIllIIllIlll = this.loadLootTable(lllllllllllIIlIIIIlIIIllIIllIlIl);
            if (lllllllllllIIlIIIIlIIIllIIllIlll == null) {
                lllllllllllIIlIIIIlIIIllIIllIlll = this.loadBuiltinLootTable(lllllllllllIIlIIIIlIIIllIIllIlIl);
            }
            if (lllllllllllIIlIIIIlIIIllIIllIlll == null) {
                lllllllllllIIlIIIIlIIIllIIllIlll = LootTable.EMPTY_LOOT_TABLE;
                LootTableManager.LOGGER.warn("Couldn't find resource table {}", (Object)lllllllllllIIlIIIIlIIIllIIllIlIl);
            }
            return lllllllllllIIlIIIIlIIIllIIllIlll;
        }
        
        private Loader() {
        }
        
        @Nullable
        private LootTable loadBuiltinLootTable(final ResourceLocation lllllllllllIIlIIIIlIIIllIIIlllIl) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     2: new             Ljava/lang/StringBuilder;
            //     5: dup            
            //     6: ldc             "/assets/"
            //     8: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
            //    11: aload_1         /* lllllllllllIIlIIIIlIIIllIIIlIlll */
            //    12: invokevirtual   net/minecraft/util/ResourceLocation.getResourceDomain:()Ljava/lang/String;
            //    15: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    18: ldc             "/loot_tables/"
            //    20: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    23: aload_1         /* lllllllllllIIlIIIIlIIIllIIIlIlll */
            //    24: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
            //    27: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    30: ldc             ".json"
            //    32: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    35: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    38: invokevirtual   java/lang/Class.getResource:(Ljava/lang/String;)Ljava/net/URL;
            //    41: astore_2        /* lllllllllllIIlIIIIlIIIllIIIlIllI */
            //    42: aload_2         /* lllllllllllIIlIIIIlIIIllIIIlllII */
            //    43: ifnull          110
            //    46: aload_2         /* lllllllllllIIlIIIIlIIIllIIIlllII */
            //    47: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
            //    50: invokestatic    com/google/common/io/Resources.toString:(Ljava/net/URL;Ljava/nio/charset/Charset;)Ljava/lang/String;
            //    53: astore_3        /* lllllllllllIIlIIIIlIIIllIIIllIll */
            //    54: goto            77
            //    57: astore          lllllllllllIIlIIIIlIIIllIIIllIIl
            //    59: invokestatic    net/minecraft/world/storage/loot/LootTableManager.access$0:()Lorg/apache/logging/log4j/Logger;
            //    62: ldc             "Couldn't load loot table {} from {}"
            //    64: aload_1         /* lllllllllllIIlIIIIlIIIllIIIlIlll */
            //    65: aload_2         /* lllllllllllIIlIIIIlIIIllIIIlllII */
            //    66: aload           lllllllllllIIlIIIIlIIIllIIIllIIl
            //    68: invokeinterface org/apache/logging/log4j/Logger.warn:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
            //    73: getstatic       net/minecraft/world/storage/loot/LootTable.EMPTY_LOOT_TABLE:Lnet/minecraft/world/storage/loot/LootTable;
            //    76: areturn        
            //    77: invokestatic    net/minecraft/world/storage/loot/LootTableManager.access$2:()Lcom/google/gson/Gson;
            //    80: aload_3         /* lllllllllllIIlIIIIlIIIllIIIllIlI */
            //    81: ldc             Lnet/minecraft/world/storage/loot/LootTable;.class
            //    83: invokestatic    net/minecraft/util/JsonUtils.gsonDeserialize:(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
            //    86: checkcast       Lnet/minecraft/world/storage/loot/LootTable;
            //    89: areturn        
            //    90: astore          lllllllllllIIlIIIIlIIIllIIIllIII
            //    92: invokestatic    net/minecraft/world/storage/loot/LootTableManager.access$0:()Lorg/apache/logging/log4j/Logger;
            //    95: ldc             "Couldn't load loot table {} from {}"
            //    97: aload_1         /* lllllllllllIIlIIIIlIIIllIIIlIlll */
            //    98: aload_2         /* lllllllllllIIlIIIIlIIIllIIIlllII */
            //    99: aload           lllllllllllIIlIIIIlIIIllIIIllIII
            //   101: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
            //   106: getstatic       net/minecraft/world/storage/loot/LootTable.EMPTY_LOOT_TABLE:Lnet/minecraft/world/storage/loot/LootTable;
            //   109: areturn        
            //   110: aconst_null    
            //   111: areturn        
            //    RuntimeVisibleTypeAnnotations: 00 01 14 00 00 0D 00 00
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                
            //  -----  -----  -----  -----  ------------------------------------
            //  46     54     57     77     Ljava/io/IOException;
            //  77     89     90     110    Lcom/google/gson/JsonParseException;
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
    }
}
