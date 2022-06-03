// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import org.apache.commons.io.IOUtils;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.IOException;
import net.minecraft.client.resources.IResource;

public class PngSizeInfo
{
    public final /* synthetic */ int pngWidth;
    public final /* synthetic */ int pngHeight;
    
    public static PngSizeInfo makeFromResource(final IResource llllllllllIllllllllllIIIIlIIIlII) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* llllllllllIllllllllllIIIIlIIIIIl */
        //     5: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    10: invokespecial   net/minecraft/client/renderer/texture/PngSizeInfo.<init>:(Ljava/io/InputStream;)V
        //    13: astore_1        /* llllllllllIllllllllllIIIIlIIIIll */
        //    14: goto            24
        //    17: astore_2        /* llllllllllIllllllllllIIIIIllllll */
        //    18: aload_0         /* llllllllllIllllllllllIIIIlIIIIIl */
        //    19: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    22: aload_2         /* llllllllllIllllllllllIIIIIllllll */
        //    23: athrow         
        //    24: aload_0         /* llllllllllIllllllllllIIIIlIIIIIl */
        //    25: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    28: aload_1         /* llllllllllIllllllllllIIIIlIIIIlI */
        //    29: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 51 07 00 29 FC 00 06 07 00 02
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      17     17     24     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public PngSizeInfo(final InputStream llllllllllIllllllllllIIIIlIIlIIl) throws IOException {
        final DataInputStream llllllllllIllllllllllIIIIlIIlIll = new DataInputStream(llllllllllIllllllllllIIIIlIIlIIl);
        if (llllllllllIllllllllllIIIIlIIlIll.readLong() != -8552249625308161526L) {
            throw new IOException("Bad PNG Signature");
        }
        if (llllllllllIllllllllllIIIIlIIlIll.readInt() != 13) {
            throw new IOException("Bad length for IHDR chunk!");
        }
        if (llllllllllIllllllllllIIIIlIIlIll.readInt() != 1229472850) {
            throw new IOException("Bad type for IHDR chunk!");
        }
        this.pngWidth = llllllllllIllllllllllIIIIlIIlIll.readInt();
        this.pngHeight = llllllllllIllllllllllIIIIlIIlIll.readInt();
        IOUtils.closeQuietly((InputStream)llllllllllIllllllllllIIIIlIIlIll);
    }
}
