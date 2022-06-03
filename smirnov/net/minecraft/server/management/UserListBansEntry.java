// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import com.google.gson.JsonObject;
import java.util.Date;
import com.mojang.authlib.GameProfile;

public class UserListBansEntry extends UserListEntryBan<GameProfile>
{
    public UserListBansEntry(final GameProfile llllllllllIlllIlllIlllIlIlIlllIl) {
        this(llllllllllIlllIlllIlllIlIlIlllIl, null, null, null, null);
    }
    
    public UserListBansEntry(final JsonObject llllllllllIlllIlllIlllIlIlIIIlIl) {
        super(toGameProfile(llllllllllIlllIlllIlllIlIlIIIlIl), llllllllllIlllIlllIlllIlIlIIIlIl);
    }
    
    @Override
    protected void onSerialization(final JsonObject llllllllllIlllIlllIlllIlIlIIIIIl) {
        if (this.getValue() != null) {
            llllllllllIlllIlllIlllIlIlIIIIIl.addProperty("uuid", (this.getValue().getId() == null) ? "" : this.getValue().getId().toString());
            llllllllllIlllIlllIlllIlIlIIIIIl.addProperty("name", this.getValue().getName());
            super.onSerialization(llllllllllIlllIlllIlllIlIlIIIIIl);
        }
    }
    
    public UserListBansEntry(final GameProfile llllllllllIlllIlllIlllIlIlIlIlII, final Date llllllllllIlllIlllIlllIlIlIlIIll, final String llllllllllIlllIlllIlllIlIlIlIIlI, final Date llllllllllIlllIlllIlllIlIlIIllII, final String llllllllllIlllIlllIlllIlIlIlIIII) {
        super(llllllllllIlllIlllIlllIlIlIlIlII, llllllllllIlllIlllIlllIlIlIIllII, llllllllllIlllIlllIlllIlIlIlIIlI, llllllllllIlllIlllIlllIlIlIIllII, llllllllllIlllIlllIlllIlIlIlIIII);
    }
    
    private static GameProfile toGameProfile(final JsonObject llllllllllIlllIlllIlllIlIIllIlIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "uuid"
        //     3: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //     6: ifeq            57
        //     9: aload_0         /* llllllllllIlllIlllIlllIlIIlllIlI */
        //    10: ldc             "name"
        //    12: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //    15: ifeq            57
        //    18: aload_0         /* llllllllllIlllIlllIlllIlIIlllIlI */
        //    19: ldc             "uuid"
        //    21: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    24: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    27: astore_1        /* llllllllllIlllIlllIlllIlIIllIlII */
        //    28: aload_1         /* llllllllllIlllIlllIlllIlIIlllIIl */
        //    29: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
        //    32: astore_2        /* llllllllllIlllIlllIlllIlIIlllIII */
        //    33: goto            39
        //    36: astore_3        /* llllllllllIlllIlllIlllIlIIllIllI */
        //    37: aconst_null    
        //    38: areturn        
        //    39: new             Lcom/mojang/authlib/GameProfile;
        //    42: dup            
        //    43: aload_2         /* llllllllllIlllIlllIlllIlIIllIlll */
        //    44: aload_0         /* llllllllllIlllIlllIlllIlIIlllIlI */
        //    45: ldc             "name"
        //    47: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    50: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    53: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
        //    56: areturn        
        //    57: aconst_null    
        //    58: areturn        
        //    StackMapTable: 00 03 FF 00 24 00 02 07 00 38 07 00 4A 00 01 07 00 5F FC 00 02 07 00 32 F9 00 11
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
}
