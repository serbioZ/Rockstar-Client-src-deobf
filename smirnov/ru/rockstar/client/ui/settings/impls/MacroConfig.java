// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.impls;

import org.lwjgl.input.Keyboard;
import ru.rockstar.api.command.macro.Macro;
import ru.rockstar.Main;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import ru.rockstar.client.ui.settings.FileManager;

public class MacroConfig extends FileManager.CustomFile
{
    @Override
    public void saveFile() {
        try {
            final BufferedWriter llllllllllIlllIIIIlIllIIllIlIIIl = new BufferedWriter(new FileWriter(this.getFile()));
            for (final Macro llllllllllIlllIIIIlIllIIllIlIIII : Main.instance.macroManager.getMacros()) {
                if (llllllllllIlllIIIIlIllIIllIlIIII != null) {
                    llllllllllIlllIIIIlIllIIllIlIIIl.write(String.valueOf(Keyboard.getKeyName(llllllllllIlllIIIIlIllIIllIlIIII.getKey())) + ":" + llllllllllIlllIIIIlIllIIllIlIIII.getValue());
                    llllllllllIlllIIIIlIllIIllIlIIIl.write("\r\n");
                }
            }
            llllllllllIlllIIIIlIllIIllIlIIIl.close();
        }
        catch (Exception ex) {}
    }
    
    public MacroConfig(final String llllllllllIlllIIIIlIllIIllllIIIl, final boolean llllllllllIlllIIIIlIllIIllllIIll) {
        super(llllllllllIlllIIIIlIllIIllllIIIl, llllllllllIlllIIIIlIllIIllllIIll);
    }
    
    @Override
    public void loadFile() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* llllllllllIlllIIIIlIllIIllIllllI */
        //     5: invokevirtual   ru/rockstar/client/ui/settings/impls/MacroConfig.getFile:()Ljava/io/File;
        //     8: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    11: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //    14: astore_1        /* llllllllllIlllIIIIlIllIIlllIIllI */
        //    15: new             Ljava/io/DataInputStream;
        //    18: dup            
        //    19: aload_1         /* llllllllllIlllIIIIlIllIIlllIIllI */
        //    20: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    23: astore_2        /* llllllllllIlllIIIIlIllIIlllIIlIl */
        //    24: new             Ljava/io/BufferedReader;
        //    27: dup            
        //    28: new             Ljava/io/InputStreamReader;
        //    31: dup            
        //    32: aload_2         /* llllllllllIlllIIIIlIllIIlllIIlIl */
        //    33: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    36: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    39: astore_3        /* llllllllllIlllIIIIlIllIIllIllIll */
        //    40: goto            104
        //    43: aload           llllllllllIlllIIIIlIllIIlllIIIll
        //    45: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //    48: astore          llllllllllIlllIIIIlIllIIlllIIIIl
        //    50: aload           llllllllllIlllIIIIlIllIIlllIIIIl
        //    52: ldc             ":"
        //    54: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    57: iconst_0       
        //    58: aaload         
        //    59: astore          llllllllllIlllIIIIlIllIIlllIIIII
        //    61: aload           llllllllllIlllIIIIlIllIIlllIIIIl
        //    63: ldc             ":"
        //    65: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    68: iconst_1       
        //    69: aaload         
        //    70: astore          llllllllllIlllIIIIlIllIIllIlllll
        //    72: getstatic       ru/rockstar/Main.instance:Lru/rockstar/Main;
        //    75: getfield        ru/rockstar/Main.macroManager:Lru/rockstar/api/command/macro/MacroManager;
        //    78: ifnull          104
        //    81: getstatic       ru/rockstar/Main.instance:Lru/rockstar/Main;
        //    84: getfield        ru/rockstar/Main.macroManager:Lru/rockstar/api/command/macro/MacroManager;
        //    87: new             Lru/rockstar/api/command/macro/Macro;
        //    90: dup            
        //    91: aload           llllllllllIlllIIIIlIllIIlllIIIII
        //    93: invokestatic    org/lwjgl/input/Keyboard.getKeyIndex:(Ljava/lang/String;)I
        //    96: aload           llllllllllIlllIIIIlIllIIllIlllll
        //    98: invokespecial   ru/rockstar/api/command/macro/Macro.<init>:(ILjava/lang/String;)V
        //   101: invokevirtual   ru/rockstar/api/command/macro/MacroManager.addMacro:(Lru/rockstar/api/command/macro/Macro;)V
        //   104: aload_3         /* llllllllllIlllIIIIlIllIIlllIIlII */
        //   105: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   108: dup            
        //   109: astore          llllllllllIlllIIIIlIllIIlllIIIlI
        //   111: ifnonnull       43
        //   114: aload_3         /* llllllllllIlllIIIIlIllIIlllIIlII */
        //   115: invokevirtual   java/io/BufferedReader.close:()V
        //   118: goto            122
        //   121: astore_1       
        //   122: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      118    121    122    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
