// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui;

import ru.rockstar.client.ui.draggable.DraggableModule;
import ru.rockstar.Main;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import ru.rockstar.client.ui.settings.FileManager;

public class HudConfig extends FileManager.CustomFile
{
    @Override
    public void loadFile() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* lllllllllllllIlIIllIlIIllIlllIlI */
        //     5: invokevirtual   ru/rockstar/client/ui/HudConfig.getFile:()Ljava/io/File;
        //     8: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    11: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //    14: astore_1        /* lllllllllllllIlIIllIlIIllIlIllll */
        //    15: new             Ljava/io/DataInputStream;
        //    18: dup            
        //    19: aload_1         /* lllllllllllllIlIIllIlIIllIlllIIl */
        //    20: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    23: astore_2        /* lllllllllllllIlIIllIlIIllIlIlllI */
        //    24: new             Ljava/io/BufferedReader;
        //    27: dup            
        //    28: new             Ljava/io/InputStreamReader;
        //    31: dup            
        //    32: aload_2         /* lllllllllllllIlIIllIlIIllIlllIII */
        //    33: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    36: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    39: astore_3        /* lllllllllllllIlIIllIlIIllIlIllIl */
        //    40: goto            157
        //    43: aload           lllllllllllllIlIIllIlIIllIllIllI
        //    45: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //    48: astore          lllllllllllllIlIIllIlIIllIllIlII
        //    50: aload           lllllllllllllIlIIllIlIIllIllIlII
        //    52: ldc             ":"
        //    54: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    57: iconst_1       
        //    58: aaload         
        //    59: astore          lllllllllllllIlIIllIlIIllIllIIll
        //    61: aload           lllllllllllllIlIIllIlIIllIllIlII
        //    63: ldc             ":"
        //    65: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    68: iconst_2       
        //    69: aaload         
        //    70: astore          lllllllllllllIlIIllIlIIllIllIIlI
        //    72: getstatic       ru/rockstar/Main.instance:Lru/rockstar/Main;
        //    75: getfield        ru/rockstar/Main.draggableManager:Lru/rockstar/client/ui/draggable/DraggableManager;
        //    78: invokevirtual   ru/rockstar/client/ui/draggable/DraggableManager.getMods:()Ljava/util/ArrayList;
        //    81: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    84: astore          lllllllllllllIlIIllIlIIllIlIIlll
        //    86: goto            147
        //    89: aload           lllllllllllllIlIIllIlIIllIlIIlll
        //    91: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    96: checkcast       Lru/rockstar/client/ui/draggable/DraggableModule;
        //    99: astore          lllllllllllllIlIIllIlIIllIllIIIl
        //   101: aload           lllllllllllllIlIIllIlIIllIllIIIl
        //   103: invokevirtual   ru/rockstar/client/ui/draggable/DraggableModule.getName:()Ljava/lang/String;
        //   106: aload           lllllllllllllIlIIllIlIIllIllIlII
        //   108: ldc             ":"
        //   110: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   113: iconst_0       
        //   114: aaload         
        //   115: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   118: ifeq            147
        //   121: aload           lllllllllllllIlIIllIlIIllIllIIIl
        //   123: getfield        ru/rockstar/client/ui/draggable/DraggableModule.drag:Lru/rockstar/client/ui/draggable/DraggableComponent;
        //   126: aload           lllllllllllllIlIIllIlIIllIllIIll
        //   128: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   131: invokevirtual   ru/rockstar/client/ui/draggable/DraggableComponent.setXPosition:(I)V
        //   134: aload           lllllllllllllIlIIllIlIIllIllIIIl
        //   136: getfield        ru/rockstar/client/ui/draggable/DraggableModule.drag:Lru/rockstar/client/ui/draggable/DraggableComponent;
        //   139: aload           lllllllllllllIlIIllIlIIllIllIIlI
        //   141: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   144: invokevirtual   ru/rockstar/client/ui/draggable/DraggableComponent.setYPosition:(I)V
        //   147: aload           lllllllllllllIlIIllIlIIllIlIIlll
        //   149: invokeinterface java/util/Iterator.hasNext:()Z
        //   154: ifne            89
        //   157: aload_3         /* lllllllllllllIlIIllIlIIllIllIlll */
        //   158: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   161: dup            
        //   162: astore          lllllllllllllIlIIllIlIIllIllIlIl
        //   164: ifnonnull       43
        //   167: aload_3         /* lllllllllllllIlIIllIlIIllIllIlll */
        //   168: invokevirtual   java/io/BufferedReader.close:()V
        //   171: goto            175
        //   174: astore_1        /* lllllllllllllIlIIllIlIIllIlIllll */
        //   175: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      171    174    175    Ljava/lang/Exception;
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
            final BufferedWriter lllllllllllllIlIIllIlIIllIlIIIIl = new BufferedWriter(new FileWriter(this.getFile()));
            for (final DraggableModule lllllllllllllIlIIllIlIIllIlIIIII : Main.instance.draggableManager.getMods()) {
                lllllllllllllIlIIllIlIIllIlIIIIl.write(String.valueOf(lllllllllllllIlIIllIlIIllIlIIIII.getName()) + ":" + lllllllllllllIlIIllIlIIllIlIIIII.drag.getXPosition() + ":" + lllllllllllllIlIIllIlIIllIlIIIII.drag.getYPosition());
                lllllllllllllIlIIllIlIIllIlIIIIl.write("\r\n");
            }
            lllllllllllllIlIIllIlIIllIlIIIIl.close();
        }
        catch (Exception ex) {}
    }
    
    public HudConfig(final String lllllllllllllIlIIllIlIIlllIIIllI, final boolean lllllllllllllIlIIllIlIIlllIIIlIl) {
        super(lllllllllllllIlIIllIlIIlllIIIllI, lllllllllllllIlIIllIlIIlllIIIlIl);
    }
}
