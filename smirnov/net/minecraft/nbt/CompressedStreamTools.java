// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import javax.annotation.Nullable;
import java.io.InputStream;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReport;
import java.io.DataInputStream;
import java.io.DataInput;
import java.io.BufferedOutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.DataOutput;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class CompressedStreamTools
{
    public static void safeWrite(final NBTTagCompound lllllllllllIIIllIIlIllIlIIllIIll, final File lllllllllllIIIllIIlIllIlIIlIllll) throws IOException {
        final File lllllllllllIIIllIIlIllIlIIllIIIl = new File(String.valueOf(lllllllllllIIIllIIlIllIlIIlIllll.getAbsolutePath()) + "_tmp");
        if (lllllllllllIIIllIIlIllIlIIllIIIl.exists()) {
            lllllllllllIIIllIIlIllIlIIllIIIl.delete();
        }
        write(lllllllllllIIIllIIlIllIlIIllIIll, lllllllllllIIIllIIlIllIlIIllIIIl);
        if (lllllllllllIIIllIIlIllIlIIlIllll.exists()) {
            lllllllllllIIIllIIlIllIlIIlIllll.delete();
        }
        if (lllllllllllIIIllIIlIllIlIIlIllll.exists()) {
            throw new IOException("Failed to delete " + lllllllllllIIIllIIlIllIlIIlIllll);
        }
        lllllllllllIIIllIIlIllIlIIllIIIl.renameTo(lllllllllllIIIllIIlIllIlIIlIllll);
    }
    
    public static void write(final NBTTagCompound lllllllllllIIIllIIlIllIlIIlIlIIl, final File lllllllllllIIIllIIlIllIlIIlIlIII) throws IOException {
        final DataOutputStream lllllllllllIIIllIIlIllIlIIlIIlll = new DataOutputStream(new FileOutputStream(lllllllllllIIIllIIlIllIlIIlIlIII));
        try {
            write(lllllllllllIIIllIIlIllIlIIlIlIIl, lllllllllllIIIllIIlIllIlIIlIIlll);
        }
        finally {
            lllllllllllIIIllIIlIllIlIIlIIlll.close();
        }
        lllllllllllIIIllIIlIllIlIIlIIlll.close();
    }
    
    public static void writeCompressed(final NBTTagCompound lllllllllllIIIllIIlIllIlIIlllIlI, final OutputStream lllllllllllIIIllIIlIllIlIIllllII) throws IOException {
        final DataOutputStream lllllllllllIIIllIIlIllIlIIlllIll = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(lllllllllllIIIllIIlIllIlIIllllII)));
        try {
            write(lllllllllllIIIllIIlIllIlIIlllIlI, lllllllllllIIIllIIlIllIlIIlllIll);
        }
        finally {
            lllllllllllIIIllIIlIllIlIIlllIll.close();
        }
        lllllllllllIIIllIIlIllIlIIlllIll.close();
    }
    
    public static void write(final NBTTagCompound lllllllllllIIIllIIlIllIlIIIIIllI, final DataOutput lllllllllllIIIllIIlIllIlIIIIIlIl) throws IOException {
        writeTag(lllllllllllIIIllIIlIllIlIIIIIllI, lllllllllllIIIllIIlIllIlIIIIIlIl);
    }
    
    public static NBTTagCompound read(final DataInput lllllllllllIIIllIIlIllIlIIIIllIl, final NBTSizeTracker lllllllllllIIIllIIlIllIlIIIIllII) throws IOException {
        final NBTBase lllllllllllIIIllIIlIllIlIIIIlllI = read(lllllllllllIIIllIIlIllIlIIIIllIl, 0, lllllllllllIIIllIIlIllIlIIIIllII);
        if (lllllllllllIIIllIIlIllIlIIIIlllI instanceof NBTTagCompound) {
            return (NBTTagCompound)lllllllllllIIIllIIlIllIlIIIIlllI;
        }
        throw new IOException("Root tag must be a named compound tag");
    }
    
    private static void writeTag(final NBTBase lllllllllllIIIllIIlIllIlIIIIIIII, final DataOutput lllllllllllIIIllIIlIllIIllllllll) throws IOException {
        lllllllllllIIIllIIlIllIIllllllll.writeByte(lllllllllllIIIllIIlIllIlIIIIIIII.getId());
        if (lllllllllllIIIllIIlIllIlIIIIIIII.getId() != 0) {
            lllllllllllIIIllIIlIllIIllllllll.writeUTF("");
            lllllllllllIIIllIIlIllIlIIIIIIII.write(lllllllllllIIIllIIlIllIIllllllll);
        }
    }
    
    public static NBTTagCompound read(final DataInputStream lllllllllllIIIllIIlIllIlIIIlIlII) throws IOException {
        return read(lllllllllllIIIllIIlIllIlIIIlIlII, NBTSizeTracker.INFINITE);
    }
    
    private static NBTBase read(final DataInput lllllllllllIIIllIIlIllIIllllIllI, final int lllllllllllIIIllIIlIllIIllllIlIl, final NBTSizeTracker lllllllllllIIIllIIlIllIIlllIllII) throws IOException {
        final byte lllllllllllIIIllIIlIllIIllllIIll = lllllllllllIIIllIIlIllIIllllIllI.readByte();
        if (lllllllllllIIIllIIlIllIIllllIIll == 0) {
            return new NBTTagEnd();
        }
        lllllllllllIIIllIIlIllIIllllIllI.readUTF();
        final NBTBase lllllllllllIIIllIIlIllIIllllIIlI = NBTBase.createNewByType(lllllllllllIIIllIIlIllIIllllIIll);
        try {
            lllllllllllIIIllIIlIllIIllllIIlI.read(lllllllllllIIIllIIlIllIIllllIllI, lllllllllllIIIllIIlIllIIllllIlIl, lllllllllllIIIllIIlIllIIlllIllII);
            return lllllllllllIIIllIIlIllIIllllIIlI;
        }
        catch (IOException lllllllllllIIIllIIlIllIIllllIIIl) {
            final CrashReport lllllllllllIIIllIIlIllIIllllIIII = CrashReport.makeCrashReport(lllllllllllIIIllIIlIllIIllllIIIl, "Loading NBT data");
            final CrashReportCategory lllllllllllIIIllIIlIllIIlllIllll = lllllllllllIIIllIIlIllIIllllIIII.makeCategory("NBT Tag");
            lllllllllllIIIllIIlIllIIlllIllll.addCrashSection("Tag type", lllllllllllIIIllIIlIllIIllllIIll);
            throw new ReportedException(lllllllllllIIIllIIlIllIIllllIIII);
        }
    }
    
    public static NBTTagCompound readCompressed(final InputStream lllllllllllIIIllIIlIllIlIlIIlIIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: new             Ljava/io/BufferedInputStream;
        //     7: dup            
        //     8: new             Ljava/util/zip/GZIPInputStream;
        //    11: dup            
        //    12: aload_0         /* lllllllllllIIIllIIlIllIlIlIIIlIl */
        //    13: invokespecial   java/util/zip/GZIPInputStream.<init>:(Ljava/io/InputStream;)V
        //    16: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    19: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    22: astore_1        /* lllllllllllIIIllIIlIllIlIlIIlIII */
        //    23: aload_1         /* lllllllllllIIIllIIlIllIlIlIIlIII */
        //    24: getstatic       net/minecraft/nbt/NBTSizeTracker.INFINITE:Lnet/minecraft/nbt/NBTSizeTracker;
        //    27: invokestatic    net/minecraft/nbt/CompressedStreamTools.read:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)Lnet/minecraft/nbt/NBTTagCompound;
        //    30: astore_2        /* lllllllllllIIIllIIlIllIlIlIIIlll */
        //    31: goto            41
        //    34: astore_3        /* lllllllllllIIIllIIlIllIlIlIIIIlI */
        //    35: aload_1         /* lllllllllllIIIllIIlIllIlIlIIlIII */
        //    36: invokevirtual   java/io/DataInputStream.close:()V
        //    39: aload_3         /* lllllllllllIIIllIIlIllIlIlIIIIlI */
        //    40: athrow         
        //    41: aload_1         /* lllllllllllIIIllIIlIllIlIlIIlIII */
        //    42: invokevirtual   java/io/DataInputStream.close:()V
        //    45: aload_2         /* lllllllllllIIIllIIlIllIlIlIIIllI */
        //    46: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 FF 00 22 00 02 07 01 19 07 01 04 00 01 07 00 62 FC 00 06 07 00 60
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  23     34     34     41     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Nullable
    public static NBTTagCompound read(final File lllllllllllIIIllIIlIllIlIIIllIlI) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/io/File.exists:()Z
        //     4: ifne            9
        //     7: aconst_null    
        //     8: areturn        
        //     9: new             Ljava/io/DataInputStream;
        //    12: dup            
        //    13: new             Ljava/io/FileInputStream;
        //    16: dup            
        //    17: aload_0         /* lllllllllllIIIllIIlIllIlIIIllllI */
        //    18: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    21: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    24: astore_1        /* lllllllllllIIIllIIlIllIlIIIllIIl */
        //    25: aload_1         /* lllllllllllIIIllIIlIllIlIIIlllIl */
        //    26: getstatic       net/minecraft/nbt/NBTSizeTracker.INFINITE:Lnet/minecraft/nbt/NBTSizeTracker;
        //    29: invokestatic    net/minecraft/nbt/CompressedStreamTools.read:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)Lnet/minecraft/nbt/NBTTagCompound;
        //    32: astore_2        /* lllllllllllIIIllIIlIllIlIIIllIII */
        //    33: goto            43
        //    36: astore_3        /* lllllllllllIIIllIIlIllIlIIIlIlll */
        //    37: aload_1         /* lllllllllllIIIllIIlIllIlIIIlllIl */
        //    38: invokevirtual   java/io/DataInputStream.close:()V
        //    41: aload_3         /* lllllllllllIIIllIIlIllIlIIIlIlll */
        //    42: athrow         
        //    43: aload_1         /* lllllllllllIIIllIIlIllIlIIIlllIl */
        //    44: invokevirtual   java/io/DataInputStream.close:()V
        //    47: aload_2         /* lllllllllllIIIllIIlIllIlIIIllIll */
        //    48: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 01 1B 00 00
        //    StackMapTable: 00 03 09 FF 00 1A 00 02 07 00 0A 07 01 04 00 01 07 00 62 FC 00 06 07 00 60
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  25     36     36     43     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
