// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;

public class UserListWhitelistEntry extends UserListEntry<GameProfile>
{
    public UserListWhitelistEntry(final GameProfile llllllllllIlllllllIlIllIIIlIllIl) {
        super(llllllllllIlllllllIlIllIIIlIllIl);
    }
    
    private static GameProfile gameProfileFromJsonObject(final JsonObject llllllllllIlllllllIlIllIIIIlIlIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "uuid"
        //     3: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //     6: ifeq            57
        //     9: aload_0         /* llllllllllIlllllllIlIllIIIIllIlI */
        //    10: ldc             "name"
        //    12: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //    15: ifeq            57
        //    18: aload_0         /* llllllllllIlllllllIlIllIIIIllIlI */
        //    19: ldc             "uuid"
        //    21: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    24: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    27: astore_1        /* llllllllllIlllllllIlIllIIIIlIlII */
        //    28: aload_1         /* llllllllllIlllllllIlIllIIIIllIIl */
        //    29: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
        //    32: astore_2        /* llllllllllIlllllllIlIllIIIIllIII */
        //    33: goto            39
        //    36: astore_3        /* llllllllllIlllllllIlIllIIIIlIllI */
        //    37: aconst_null    
        //    38: areturn        
        //    39: new             Lcom/mojang/authlib/GameProfile;
        //    42: dup            
        //    43: aload_2         /* llllllllllIlllllllIlIllIIIIlIlll */
        //    44: aload_0         /* llllllllllIlllllllIlIllIIIIllIlI */
        //    45: ldc             "name"
        //    47: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    50: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    53: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
        //    56: areturn        
        //    57: aconst_null    
        //    58: areturn        
        //    StackMapTable: 00 03 FF 00 24 00 02 07 00 1A 07 00 46 00 01 07 00 16 FC 00 02 07 00 2C F9 00 11
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  28     33     36     39     Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    protected void onSerialization(final JsonObject llllllllllIlllllllIlIllIIIIlllll) {
        if (this.getValue() != null) {
            llllllllllIlllllllIlIllIIIIlllll.addProperty("uuid", (this.getValue().getId() == null) ? "" : this.getValue().getId().toString());
            llllllllllIlllllllIlIllIIIIlllll.addProperty("name", this.getValue().getName());
            super.onSerialization(llllllllllIlllllllIlIllIIIIlllll);
        }
    }
    
    public UserListWhitelistEntry(final JsonObject llllllllllIlllllllIlIllIIIlIIlll) {
        super(gameProfileFromJsonObject(llllllllllIlllllllIlIllIIIlIIlll), llllllllllIlllllllIlIllIIIlIIlll);
    }
}
