// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.friend;

import java.util.ArrayList;
import java.util.List;

public class FriendManager
{
    private static final /* synthetic */ List<Friend> friends;
    
    public void addFriend(final Friend lllllllllllIlllIllIlIIIIlIIIIIll) {
        FriendManager.friends.add(lllllllllllIlllIllIlIIIIlIIIIIll);
    }
    
    public List<Friend> getFriends() {
        return FriendManager.friends;
    }
    
    public void addFriend(final String lllllllllllIlllIllIlIIIIIlllllll) {
        FriendManager.friends.add(new Friend(lllllllllllIlllIllIlIIIIIlllllll));
    }
    
    static {
        friends = new ArrayList<Friend>();
    }
    
    public Friend getFriend(final String lllllllllllIlllIllIlIIIIIlllIIll) {
        return FriendManager.friends.stream().filter(lllllllllllIlllIllIlIIIIIllIIlII -> lllllllllllIlllIllIlIIIIIllIIlII.getName().equals(lllllllllllIlllIllIlIIIIIlllIIll)).findFirst().get();
    }
    
    public void removeFriend(final String lllllllllllIlllIllIlIIIIIllllIIl) {
        FriendManager.friends.removeIf(lllllllllllIlllIllIlIIIIIllIlIIl -> lllllllllllIlllIllIlIIIIIllIlIIl.getName().equalsIgnoreCase(lllllllllllIlllIllIlIIIIIllllIIl));
    }
    
    public static boolean isFriend(final String lllllllllllIlllIllIlIIIIIlllllII) {
        return FriendManager.friends.stream().anyMatch(lllllllllllIlllIllIlIIIIIllIlllI -> lllllllllllIlllIllIlIIIIIllIlllI.getName().equals(lllllllllllIlllIllIlIIIIIlllllII));
    }
}
