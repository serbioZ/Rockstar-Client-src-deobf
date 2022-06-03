// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import java.util.Date;
import com.google.gson.JsonObject;

public class UserListIPBansEntry extends UserListEntryBan<String>
{
    private static String getIPFromJson(final JsonObject lllllllllllllllIIlIIIIIllIlIIlll) {
        return lllllllllllllllIIlIIIIIllIlIIlll.has("ip") ? lllllllllllllllIIlIIIIIllIlIIlll.get("ip").getAsString() : null;
    }
    
    public UserListIPBansEntry(final String lllllllllllllllIIlIIIIIllIlllIIl, final Date lllllllllllllllIIlIIIIIllIlllIII, final String lllllllllllllllIIlIIIIIllIllIIIl, final Date lllllllllllllllIIlIIIIIllIllIllI, final String lllllllllllllllIIlIIIIIllIllIlIl) {
        super(lllllllllllllllIIlIIIIIllIlllIIl, lllllllllllllllIIlIIIIIllIlllIII, lllllllllllllllIIlIIIIIllIllIIIl, lllllllllllllllIIlIIIIIllIllIllI, lllllllllllllllIIlIIIIIllIllIlIl);
    }
    
    @Override
    protected void onSerialization(final JsonObject lllllllllllllllIIlIIIIIllIlIIIlI) {
        if (this.getValue() != null) {
            lllllllllllllllIIlIIIIIllIlIIIlI.addProperty("ip", (String)this.getValue());
            super.onSerialization(lllllllllllllllIIlIIIIIllIlIIIlI);
        }
    }
    
    public UserListIPBansEntry(final String lllllllllllllllIIlIIIIIlllIIIIIl) {
        this(lllllllllllllllIIlIIIIIlllIIIIIl, null, null, null, null);
    }
    
    public UserListIPBansEntry(final JsonObject lllllllllllllllIIlIIIIIllIlIlIll) {
        super(getIPFromJson(lllllllllllllllIIlIIIIIllIlIlIll), lllllllllllllllIIlIIIIIllIlIlIll);
    }
}
