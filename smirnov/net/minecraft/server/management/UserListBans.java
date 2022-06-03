// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import java.io.File;
import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;

public class UserListBans extends UserList<GameProfile, UserListBansEntry>
{
    @Override
    protected String getObjectKey(final GameProfile lllllllllllllIIlIlIlIlIIIlIIIIIl) {
        return lllllllllllllIIlIlIlIlIIIlIIIIIl.getId().toString();
    }
    
    public boolean isBanned(final GameProfile lllllllllllllIIlIlIlIlIIIlIlIlII) {
        return ((UserList<GameProfile, V>)this).hasEntry(lllllllllllllIIlIlIlIlIIIlIlIlII);
    }
    
    public GameProfile getBannedProfile(final String lllllllllllllIIlIlIlIlIIIIlllIlI) {
        for (final UserListBansEntry lllllllllllllIIlIlIlIlIIIIlllIIl : ((UserList<K, UserListBansEntry>)this).getValues().values()) {
            if (lllllllllllllIIlIlIlIlIIIIlllIlI.equalsIgnoreCase(lllllllllllllIIlIlIlIlIIIIlllIIl.getValue().getName())) {
                return lllllllllllllIIlIlIlIlIIIIlllIIl.getValue();
            }
        }
        return null;
    }
    
    @Override
    protected UserListEntry<GameProfile> createEntry(final JsonObject lllllllllllllIIlIlIlIlIIIlIllIII) {
        return new UserListBansEntry(lllllllllllllIIlIlIlIlIIIlIllIII);
    }
    
    public UserListBans(final File lllllllllllllIIlIlIlIlIIIlIlllII) {
        super(lllllllllllllIIlIlIlIlIIIlIlllII);
    }
    
    @Override
    public String[] getKeys() {
        final String[] lllllllllllllIIlIlIlIlIIIlIIlIll = new String[((UserList<K, UserListBansEntry>)this).getValues().size()];
        int lllllllllllllIIlIlIlIlIIIlIIlIlI = 0;
        for (final UserListBansEntry lllllllllllllIIlIlIlIlIIIlIIlIIl : ((UserList<K, UserListBansEntry>)this).getValues().values()) {
            lllllllllllllIIlIlIlIlIIIlIIlIll[lllllllllllllIIlIlIlIlIIIlIIlIlI++] = lllllllllllllIIlIlIlIlIIIlIIlIIl.getValue().getName();
        }
        return lllllllllllllIIlIlIlIlIIIlIIlIll;
    }
}
