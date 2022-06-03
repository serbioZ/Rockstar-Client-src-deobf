// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import com.google.gson.JsonObject;

public class UserListEntry<T>
{
    private final /* synthetic */ T value;
    
    protected void onSerialization(final JsonObject lllllllllllIlIIIllIlIIllIIIllllI) {
    }
    
    protected UserListEntry(final T lllllllllllIlIIIllIlIIllIIlIIlll, final JsonObject lllllllllllIlIIIllIlIIllIIlIIllI) {
        this.value = lllllllllllIlIIIllIlIIllIIlIIlll;
    }
    
    public UserListEntry(final T lllllllllllIlIIIllIlIIllIIlIlIll) {
        this.value = lllllllllllIlIIIllIlIIllIIlIlIll;
    }
    
    T getValue() {
        return this.value;
    }
    
    boolean hasBanExpired() {
        return false;
    }
}
