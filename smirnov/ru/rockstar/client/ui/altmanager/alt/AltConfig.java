// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager.alt;

import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.FileWriter;
import ru.rockstar.client.ui.settings.FileManager;

public class AltConfig extends FileManager.CustomFile
{
    public AltConfig(final String llllllllllllIIlIllllIIIlIIlIIlII, final boolean llllllllllllIIlIllllIIIlIIlIIIll) {
        super(llllllllllllIIlIllllIIIlIIlIIlII, llllllllllllIIlIllllIIIlIIlIIIll);
    }
    
    @Override
    public void saveFile() throws IOException {
        final PrintWriter llllllllllllIIlIllllIIIlIIIlIIII = new PrintWriter(new FileWriter(this.getFile()));
        for (final Alt llllllllllllIIlIllllIIIlIIIIllll : AltManager.registry) {
            if (llllllllllllIIlIllllIIIlIIIIllll.getMask().equals("")) {
                llllllllllllIIlIllllIIIlIIIlIIII.println(String.valueOf(llllllllllllIIlIllllIIIlIIIIllll.getUsername()) + ":" + llllllllllllIIlIllllIIIlIIIIllll.getPassword() + ":" + llllllllllllIIlIllllIIIlIIIIllll.getUsername() + ":" + llllllllllllIIlIllllIIIlIIIIllll.getStatus());
            }
            else {
                llllllllllllIIlIllllIIIlIIIlIIII.println(String.valueOf(llllllllllllIIlIllllIIIlIIIIllll.getUsername()) + ":" + llllllllllllIIlIllllIIIlIIIIllll.getPassword() + ":" + llllllllllllIIlIllllIIIlIIIIllll.getMask() + ":" + llllllllllllIIlIllllIIIlIIIIllll.getStatus());
            }
        }
        llllllllllllIIlIllllIIIlIIIlIIII.close();
    }
    
    @Override
    public void loadFile() throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: new             Ljava/io/FileReader;
        //     7: dup            
        //     8: aload_0         /* llllllllllllIIlIllllIIIlIIIllllI */
        //     9: invokevirtual   ru/rockstar/client/ui/altmanager/alt/AltConfig.getFile:()Ljava/io/File;
        //    12: invokespecial   java/io/FileReader.<init>:(Ljava/io/File;)V
        //    15: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    18: astore_1        /* llllllllllllIIlIllllIIIlIIIllIII */
        //    19: goto            99
        //    22: aload_2         /* llllllllllllIIlIllllIIIlIIIlllII */
        //    23: ldc             ":"
        //    25: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    28: astore_3        /* llllllllllllIIlIllllIIIlIIIllIlI */
        //    29: aload_3         /* llllllllllllIIlIllllIIIlIIIllIlI */
        //    30: arraylength    
        //    31: iconst_2       
        //    32: if_icmple       79
        //    35: getstatic       ru/rockstar/client/ui/altmanager/alt/AltManager.registry:Ljava/util/ArrayList;
        //    38: new             Lru/rockstar/client/ui/altmanager/alt/Alt;
        //    41: dup            
        //    42: aload_3         /* llllllllllllIIlIllllIIIlIIIllIlI */
        //    43: iconst_0       
        //    44: aaload         
        //    45: aload_3         /* llllllllllllIIlIllllIIIlIIIllIlI */
        //    46: iconst_1       
        //    47: aaload         
        //    48: aload_3         /* llllllllllllIIlIllllIIIlIIIllIlI */
        //    49: iconst_2       
        //    50: aaload         
        //    51: aload_3         /* llllllllllllIIlIllllIIIlIIIllIlI */
        //    52: arraylength    
        //    53: iconst_3       
        //    54: if_icmple       66
        //    57: aload_3         /* llllllllllllIIlIllllIIIlIIIllIlI */
        //    58: iconst_3       
        //    59: aaload         
        //    60: invokestatic    ru/rockstar/client/ui/altmanager/alt/Alt$Status.valueOf:(Ljava/lang/String;)Lru/rockstar/client/ui/altmanager/alt/Alt$Status;
        //    63: goto            69
        //    66: getstatic       ru/rockstar/client/ui/altmanager/alt/Alt$Status.Unchecked:Lru/rockstar/client/ui/altmanager/alt/Alt$Status;
        //    69: invokespecial   ru/rockstar/client/ui/altmanager/alt/Alt.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/rockstar/client/ui/altmanager/alt/Alt$Status;)V
        //    72: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //    75: pop            
        //    76: goto            99
        //    79: getstatic       ru/rockstar/client/ui/altmanager/alt/AltManager.registry:Ljava/util/ArrayList;
        //    82: new             Lru/rockstar/client/ui/altmanager/alt/Alt;
        //    85: dup            
        //    86: aload_3         /* llllllllllllIIlIllllIIIlIIIllIlI */
        //    87: iconst_0       
        //    88: aaload         
        //    89: aload_3         /* llllllllllllIIlIllllIIIlIIIllIlI */
        //    90: iconst_1       
        //    91: aaload         
        //    92: invokespecial   ru/rockstar/client/ui/altmanager/alt/Alt.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    95: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //    98: pop            
        //    99: aload_1         /* llllllllllllIIlIllllIIIlIIIlllIl */
        //   100: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   103: dup            
        //   104: astore_2        /* llllllllllllIIlIllllIIIlIIIllIll */
        //   105: ifnonnull       22
        //   108: aload_1         /* llllllllllllIIlIllllIIIlIIIlllIl */
        //   109: invokevirtual   java/io/BufferedReader.close:()V
        //   112: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 05 FD 00 16 07 00 82 07 00 47 FF 00 2B 00 04 07 00 02 07 00 82 07 00 47 07 00 AD 00 06 07 00 35 08 00 26 08 00 26 07 00 47 07 00 47 07 00 47 FF 00 02 00 04 07 00 02 07 00 82 07 00 47 07 00 AD 00 07 07 00 35 08 00 26 08 00 26 07 00 47 07 00 47 07 00 47 07 00 06 09 F9 00 13
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
