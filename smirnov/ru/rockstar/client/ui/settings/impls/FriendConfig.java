// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.impls;

import ru.rockstar.api.utils.friend.Friend;
import ru.rockstar.Main;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import ru.rockstar.client.ui.settings.FileManager;

public class FriendConfig extends FileManager.CustomFile
{
    @Override
    public void loadFile() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: new             Ljava/io/FileReader;
        //     7: dup            
        //     8: aload_0         /* lllllllllllIllIIIlIllIIIlIIlIIll */
        //     9: invokevirtual   ru/rockstar/client/ui/settings/impls/FriendConfig.getFile:()Ljava/io/File;
        //    12: invokespecial   java/io/FileReader.<init>:(Ljava/io/File;)V
        //    15: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    18: astore_1        /* lllllllllllIllIIIlIllIIIlIIIllII */
        //    19: goto            48
        //    22: aload_2         /* lllllllllllIllIIIlIllIIIlIIlIIIl */
        //    23: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //    26: astore_3        /* lllllllllllIllIIIlIllIIIlIIIllll */
        //    27: aload_3         /* lllllllllllIllIIIlIllIIIlIIIllll */
        //    28: ldc             ":"
        //    30: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    33: iconst_0       
        //    34: aaload         
        //    35: astore          lllllllllllIllIIIlIllIIIlIIIlllI
        //    37: getstatic       ru/rockstar/Main.instance:Lru/rockstar/Main;
        //    40: getfield        ru/rockstar/Main.friendManager:Lru/rockstar/api/utils/friend/FriendManager;
        //    43: aload           lllllllllllIllIIIlIllIIIlIIIlllI
        //    45: invokevirtual   ru/rockstar/api/utils/friend/FriendManager.addFriend:(Ljava/lang/String;)V
        //    48: aload_1         /* lllllllllllIllIIIlIllIIIlIIlIIlI */
        //    49: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    52: dup            
        //    53: astore_2        /* lllllllllllIllIIIlIllIIIlIIlIIII */
        //    54: ifnonnull       22
        //    57: aload_1         /* lllllllllllIllIIIlIllIIIlIIlIIlI */
        //    58: invokevirtual   java/io/BufferedReader.close:()V
        //    61: goto            65
        //    64: astore_1        /* lllllllllllIllIIIlIllIIIlIIIllII */
        //    65: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      61     64     65     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void saveFile() {
        try {
            final BufferedWriter lllllllllllIllIIIlIllIIIlIIIIIll = new BufferedWriter(new FileWriter(this.getFile()));
            for (final Friend lllllllllllIllIIIlIllIIIlIIIIIlI : Main.instance.friendManager.getFriends()) {
                lllllllllllIllIIIlIllIIIlIIIIIll.write(lllllllllllIllIIIlIllIIIlIIIIIlI.getName().replace(" ", ""));
                lllllllllllIllIIIlIllIIIlIIIIIll.write("\r\n");
            }
            lllllllllllIllIIIlIllIIIlIIIIIll.close();
        }
        catch (Exception ex) {}
    }
    
    public FriendConfig(final String lllllllllllIllIIIlIllIIIlIIllIlI, final boolean lllllllllllIllIIIlIllIIIlIIllIIl) {
        super(lllllllllllIllIIIlIllIIIlIIllIlI, lllllllllllIllIIIlIllIIIlIIllIIl);
    }
}
