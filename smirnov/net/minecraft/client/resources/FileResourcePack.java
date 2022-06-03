// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import java.io.File;
import java.util.Set;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.io.InputStream;
import java.util.zip.ZipFile;
import com.google.common.base.Splitter;
import java.io.Closeable;

public class FileResourcePack extends AbstractResourcePack implements Closeable
{
    private /* synthetic */ ZipFile resourcePackZipFile;
    
    @Override
    protected InputStream getInputStreamByName(final String lllllllllllllllllIlIIIllIllIlIll) throws IOException {
        final ZipFile lllllllllllllllllIlIIIllIllIlIlI = this.getResourcePackZipFile();
        final ZipEntry lllllllllllllllllIlIIIllIllIlIIl = lllllllllllllllllIlIIIllIllIlIlI.getEntry(lllllllllllllllllIlIIIllIllIlIll);
        if (lllllllllllllllllIlIIIllIllIlIIl == null) {
            throw new ResourcePackFileNotFoundException(this.resourcePackFile, lllllllllllllllllIlIIIllIllIlIll);
        }
        return lllllllllllllllllIlIIIllIllIlIlI.getInputStream(lllllllllllllllllIlIIIllIllIlIIl);
    }
    
    private ZipFile getResourcePackZipFile() throws IOException {
        if (this.resourcePackZipFile == null) {
            this.resourcePackZipFile = new ZipFile(this.resourcePackFile);
        }
        return this.resourcePackZipFile;
    }
    
    public boolean hasResourceName(final String lllllllllllllllllIlIIIllIlIlllIl) {
        try {
            return this.getResourcePackZipFile().getEntry(lllllllllllllllllIlIIIllIlIlllIl) != null;
        }
        catch (IOException lllllllllllllllllIlIIIllIlIlllll) {
            return false;
        }
    }
    
    @Override
    public Set<String> getResourceDomains() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   net/minecraft/client/resources/FileResourcePack.getResourcePackZipFile:()Ljava/util/zip/ZipFile;
        //     4: astore_1        /* lllllllllllllllllIlIIIllIlIlIIlI */
        //     5: goto            13
        //     8: astore_2        /* lllllllllllllllllIlIIIllIlIlIIII */
        //     9: invokestatic    java/util/Collections.emptySet:()Ljava/util/Set;
        //    12: areturn        
        //    13: aload_1         /* lllllllllllllllllIlIIIllIlIlIIIl */
        //    14: invokevirtual   java/util/zip/ZipFile.entries:()Ljava/util/Enumeration;
        //    17: astore_2        /* lllllllllllllllllIlIIIllIlIIllll */
        //    18: invokestatic    com/google/common/collect/Sets.newHashSet:()Ljava/util/HashSet;
        //    21: astore_3        /* lllllllllllllllllIlIIIllIlIIlllI */
        //    22: goto            124
        //    25: aload_2         /* lllllllllllllllllIlIIIllIlIIllll */
        //    26: invokeinterface java/util/Enumeration.nextElement:()Ljava/lang/Object;
        //    31: checkcast       Ljava/util/zip/ZipEntry;
        //    34: astore          lllllllllllllllllIlIIIllIlIIllIl
        //    36: aload           lllllllllllllllllIlIIIllIlIIllIl
        //    38: invokevirtual   java/util/zip/ZipEntry.getName:()Ljava/lang/String;
        //    41: astore          lllllllllllllllllIlIIIllIlIIllII
        //    43: aload           lllllllllllllllllIlIIIllIlIIllII
        //    45: ldc             "assets/"
        //    47: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    50: ifeq            124
        //    53: getstatic       net/minecraft/client/resources/FileResourcePack.ENTRY_NAME_SPLITTER:Lcom/google/common/base/Splitter;
        //    56: aload           lllllllllllllllllIlIIIllIlIIllII
        //    58: invokevirtual   com/google/common/base/Splitter.split:(Ljava/lang/CharSequence;)Ljava/lang/Iterable;
        //    61: invokestatic    com/google/common/collect/Lists.newArrayList:(Ljava/lang/Iterable;)Ljava/util/ArrayList;
        //    64: astore          lllllllllllllllllIlIIIllIlIIlIll
        //    66: aload           lllllllllllllllllIlIIIllIlIIlIll
        //    68: invokeinterface java/util/List.size:()I
        //    73: iconst_1       
        //    74: if_icmple       124
        //    77: aload           lllllllllllllllllIlIIIllIlIIlIll
        //    79: iconst_1       
        //    80: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    85: checkcast       Ljava/lang/String;
        //    88: astore          lllllllllllllllllIlIIIllIlIIlIlI
        //    90: aload           lllllllllllllllllIlIIIllIlIIlIlI
        //    92: aload           lllllllllllllllllIlIIIllIlIIlIlI
        //    94: getstatic       java/util/Locale.ROOT:Ljava/util/Locale;
        //    97: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
        //   100: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   103: ifeq            118
        //   106: aload_3         /* lllllllllllllllllIlIIIllIlIIlllI */
        //   107: aload           lllllllllllllllllIlIIIllIlIIlIlI
        //   109: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   114: pop            
        //   115: goto            124
        //   118: aload_0         /* lllllllllllllllllIlIIIllIlIIlIIl */
        //   119: aload           lllllllllllllllllIlIIIllIlIIlIlI
        //   121: invokevirtual   net/minecraft/client/resources/FileResourcePack.logNameNotLowercase:(Ljava/lang/String;)V
        //   124: aload_2         /* lllllllllllllllllIlIIIllIlIIllll */
        //   125: invokeinterface java/util/Enumeration.hasMoreElements:()Z
        //   130: ifne            25
        //   133: aload_3         /* lllllllllllllllllIlIIIllIlIIlllI */
        //   134: areturn        
        //    Signature:
        //  ()Ljava/util/Set<Ljava/lang/String;>;
        //    StackMapTable: 00 05 48 07 00 0E FC 00 04 07 00 14 FD 00 0B 07 00 5C 07 00 BA FF 00 5C 00 08 07 00 02 07 00 14 07 00 5C 07 00 BA 07 00 36 07 00 68 07 00 BC 07 00 68 00 00 FF 00 05 00 04 07 00 02 07 00 14 07 00 5C 07 00 BA 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      5      8      13     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public FileResourcePack(final File lllllllllllllllllIlIIIllIlllIllI) {
        super(lllllllllllllllllIlIIIllIlllIllI);
    }
    
    static {
        ENTRY_NAME_SPLITTER = Splitter.on('/').omitEmptyStrings().limit(3);
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.close();
        super.finalize();
    }
    
    @Override
    public void close() throws IOException {
        if (this.resourcePackZipFile != null) {
            this.resourcePackZipFile.close();
            this.resourcePackZipFile = null;
        }
    }
}
