// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import java.io.File;
import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;

public class UserListWhitelist extends UserList<GameProfile, UserListWhitelistEntry>
{
    @Override
    protected UserListEntry<GameProfile> createEntry(final JsonObject llllllllllIlllllIllIllIllllIIllI) {
        return new UserListWhitelistEntry(llllllllllIlllllIllIllIllllIIllI);
    }
    
    @Override
    protected String getObjectKey(final GameProfile llllllllllIlllllIllIllIlllIlIlII) {
        return llllllllllIlllllIllIllIlllIlIlII.getId().toString();
    }
    
    public GameProfile getByName(final String llllllllllIlllllIllIllIlllIIlIlI) {
        for (final UserListWhitelistEntry llllllllllIlllllIllIllIlllIIllII : ((UserList<K, UserListWhitelistEntry>)this).getValues().values()) {
            if (llllllllllIlllllIllIllIlllIIlIlI.equalsIgnoreCase(llllllllllIlllllIllIllIlllIIllII.getValue().getName())) {
                return llllllllllIlllllIllIllIlllIIllII.getValue();
            }
        }
        return null;
    }
    
    public UserListWhitelist(final File llllllllllIlllllIllIllIllllIlIll) {
        super(llllllllllIlllllIllIllIllllIlIll);
    }
    
    @Override
    public String[] getKeys() {
        final String[] llllllllllIlllllIllIllIlllIllllI = new String[((UserList<K, UserListWhitelistEntry>)this).getValues().size()];
        int llllllllllIlllllIllIllIlllIlllIl = 0;
        for (final UserListWhitelistEntry llllllllllIlllllIllIllIlllIlllII : ((UserList<K, UserListWhitelistEntry>)this).getValues().values()) {
            llllllllllIlllllIllIllIlllIllllI[llllllllllIlllllIllIllIlllIlllIl++] = llllllllllIlllllIllIllIlllIlllII.getValue().getName();
        }
        return llllllllllIlllllIllIllIlllIllllI;
    }
}
