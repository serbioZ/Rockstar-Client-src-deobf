// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import com.google.gson.JsonObject;
import java.io.File;
import com.mojang.authlib.GameProfile;

public class UserListOps extends UserList<GameProfile, UserListOpsEntry>
{
    public boolean bypassesPlayerLimit(final GameProfile lllllllllllIIlllIllllIIIIlIlIIlI) {
        final UserListOpsEntry lllllllllllIIlllIllllIIIIlIlIIIl = this.getEntry(lllllllllllIIlllIllllIIIIlIlIIlI);
        return lllllllllllIIlllIllllIIIIlIlIIIl != null && lllllllllllIIlllIllllIIIIlIlIIIl.bypassesPlayerLimit();
    }
    
    @Override
    public String[] getKeys() {
        final String[] lllllllllllIIlllIllllIIIIllIIlll = new String[((UserList<K, UserListOpsEntry>)this).getValues().size()];
        int lllllllllllIIlllIllllIIIIllIIllI = 0;
        for (final UserListOpsEntry lllllllllllIIlllIllllIIIIllIIlIl : ((UserList<K, UserListOpsEntry>)this).getValues().values()) {
            lllllllllllIIlllIllllIIIIllIIlll[lllllllllllIIlllIllllIIIIllIIllI++] = lllllllllllIIlllIllllIIIIllIIlIl.getValue().getName();
        }
        return lllllllllllIIlllIllllIIIIllIIlll;
    }
    
    @Override
    protected String getObjectKey(final GameProfile lllllllllllIIlllIllllIIIIlIIlIlI) {
        return lllllllllllIIlllIllllIIIIlIIlIlI.getId().toString();
    }
    
    public UserListOps(final File lllllllllllIIlllIllllIIIIlllIlII) {
        super(lllllllllllIIlllIllllIIIIlllIlII);
    }
    
    public GameProfile getGameProfileFromName(final String lllllllllllIIlllIllllIIIIlIIIIIl) {
        for (final UserListOpsEntry lllllllllllIIlllIllllIIIIlIIIIll : ((UserList<K, UserListOpsEntry>)this).getValues().values()) {
            if (lllllllllllIIlllIllllIIIIlIIIIIl.equalsIgnoreCase(lllllllllllIIlllIllllIIIIlIIIIll.getValue().getName())) {
                return lllllllllllIIlllIllllIIIIlIIIIll.getValue();
            }
        }
        return null;
    }
    
    public int getPermissionLevel(final GameProfile lllllllllllIIlllIllllIIIIlIllIll) {
        final UserListOpsEntry lllllllllllIIlllIllllIIIIlIllIlI = this.getEntry(lllllllllllIIlllIllllIIIIlIllIll);
        return (lllllllllllIIlllIllllIIIIlIllIlI != null) ? lllllllllllIIlllIllllIIIIlIllIlI.getPermissionLevel() : 0;
    }
    
    @Override
    protected UserListEntry<GameProfile> createEntry(final JsonObject lllllllllllIIlllIllllIIIIllIllll) {
        return new UserListOpsEntry(lllllllllllIIlllIllllIIIIllIllll);
    }
}
