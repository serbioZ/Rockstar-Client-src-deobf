// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import com.google.gson.JsonObject;
import java.net.SocketAddress;
import java.io.File;

public class UserListIPBans extends UserList<String, UserListIPBansEntry>
{
    public UserListIPBans(final File llllllllllllIlIIlIllIlIIIIllllIl) {
        super(llllllllllllIlIIlIllIlIIIIllllIl);
    }
    
    public boolean isBanned(final SocketAddress llllllllllllIlIIlIllIlIIIIlIllll) {
        final String llllllllllllIlIIlIllIlIIIIllIIIl = this.addressToString(llllllllllllIlIIlIllIlIIIIlIllll);
        return ((UserList<String, V>)this).hasEntry(llllllllllllIlIIlIllIlIIIIllIIIl);
    }
    
    @Override
    protected UserListEntry<String> createEntry(final JsonObject llllllllllllIlIIlIllIlIIIIlllIII) {
        return new UserListIPBansEntry(llllllllllllIlIIlIllIlIIIIlllIII);
    }
    
    public UserListIPBansEntry getBanEntry(final SocketAddress llllllllllllIlIIlIllIlIIIIlIIllI) {
        final String llllllllllllIlIIlIllIlIIIIlIlIII = this.addressToString(llllllllllllIlIIlIllIlIIIIlIIllI);
        return this.getEntry(llllllllllllIlIIlIllIlIIIIlIlIII);
    }
    
    private String addressToString(final SocketAddress llllllllllllIlIIlIllIlIIIIlIIIIl) {
        String llllllllllllIlIIlIllIlIIIIlIIIII = llllllllllllIlIIlIllIlIIIIlIIIIl.toString();
        if (llllllllllllIlIIlIllIlIIIIlIIIII.contains("/")) {
            llllllllllllIlIIlIllIlIIIIlIIIII = llllllllllllIlIIlIllIlIIIIlIIIII.substring(llllllllllllIlIIlIllIlIIIIlIIIII.indexOf(47) + 1);
        }
        if (llllllllllllIlIIlIllIlIIIIlIIIII.contains(":")) {
            llllllllllllIlIIlIllIlIIIIlIIIII = llllllllllllIlIIlIllIlIIIIlIIIII.substring(0, llllllllllllIlIIlIllIlIIIIlIIIII.indexOf(58));
        }
        return llllllllllllIlIIlIllIlIIIIlIIIII;
    }
}
