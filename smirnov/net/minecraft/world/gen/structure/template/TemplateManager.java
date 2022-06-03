// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure.template;

import java.io.IOException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixType;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.nbt.CompressedStreamTools;
import java.io.InputStream;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import com.google.common.collect.Maps;
import net.minecraft.util.datafix.DataFixer;
import java.util.Map;

public class TemplateManager
{
    private final /* synthetic */ String baseFolder;
    private final /* synthetic */ Map<String, Template> templates;
    private final /* synthetic */ DataFixer field_191154_c;
    
    public TemplateManager(final String llllllllllllIIIIllIIlIllIllIIlIl, final DataFixer llllllllllllIIIIllIIlIllIllIIIIl) {
        this.templates = (Map<String, Template>)Maps.newHashMap();
        this.baseFolder = llllllllllllIIIIllIIlIllIllIIlIl;
        this.field_191154_c = llllllllllllIIIIllIIlIllIllIIIIl;
    }
    
    public void remove(final ResourceLocation llllllllllllIIIIllIIlIlIlllIIlII) {
        this.templates.remove(llllllllllllIIIIllIIlIlIlllIIlII.getResourcePath());
    }
    
    @Nullable
    public Template get(@Nullable final MinecraftServer llllllllllllIIIIllIIlIllIlIIlIll, final ResourceLocation llllllllllllIIIIllIIlIllIlIIlllI) {
        final String llllllllllllIIIIllIIlIllIlIIllIl = llllllllllllIIIIllIIlIllIlIIlllI.getResourcePath();
        if (this.templates.containsKey(llllllllllllIIIIllIIlIllIlIIllIl)) {
            return this.templates.get(llllllllllllIIIIllIIlIllIlIIllIl);
        }
        if (llllllllllllIIIIllIIlIllIlIIlIll == null) {
            this.readTemplateFromJar(llllllllllllIIIIllIIlIllIlIIlllI);
        }
        else {
            this.readTemplate(llllllllllllIIIIllIIlIllIlIIlllI);
        }
        return this.templates.containsKey(llllllllllllIIIIllIIlIllIlIIllIl) ? this.templates.get(llllllllllllIIIIllIIlIllIlIIllIl) : null;
    }
    
    public boolean writeTemplate(@Nullable final MinecraftServer llllllllllllIIIIllIIlIlIllllIIIl, final ResourceLocation llllllllllllIIIIllIIlIlIllllIIII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //     4: astore_3        /* llllllllllllIIIIllIIlIlIlllIllll */
        //     5: aload_1         /* llllllllllllIIIIllIIlIlIllllllIl */
        //     6: ifnull          176
        //     9: aload_0         /* llllllllllllIIIIllIIlIlIlllllllI */
        //    10: getfield        net/minecraft/world/gen/structure/template/TemplateManager.templates:Ljava/util/Map;
        //    13: aload_3         /* llllllllllllIIIIllIIlIlIlllllIll */
        //    14: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //    19: ifeq            176
        //    22: new             Ljava/io/File;
        //    25: dup            
        //    26: aload_0         /* llllllllllllIIIIllIIlIlIlllllllI */
        //    27: getfield        net/minecraft/world/gen/structure/template/TemplateManager.baseFolder:Ljava/lang/String;
        //    30: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    33: astore          llllllllllllIIIIllIIlIlIlllllIlI
        //    35: aload           llllllllllllIIIIllIIlIlIlllllIlI
        //    37: invokevirtual   java/io/File.exists:()Z
        //    40: ifne            53
        //    43: aload           llllllllllllIIIIllIIlIlIlllllIlI
        //    45: invokevirtual   java/io/File.mkdirs:()Z
        //    48: ifne            63
        //    51: iconst_0       
        //    52: ireturn        
        //    53: aload           llllllllllllIIIIllIIlIlIlllllIlI
        //    55: invokevirtual   java/io/File.isDirectory:()Z
        //    58: ifne            63
        //    61: iconst_0       
        //    62: ireturn        
        //    63: new             Ljava/io/File;
        //    66: dup            
        //    67: aload           llllllllllllIIIIllIIlIlIlllllIlI
        //    69: new             Ljava/lang/StringBuilder;
        //    72: dup            
        //    73: aload_3         /* llllllllllllIIIIllIIlIlIlllllIll */
        //    74: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    77: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    80: ldc             ".nbt"
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    85: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    88: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    91: astore          llllllllllllIIIIllIIlIlIlllllIIl
        //    93: aload_0         /* llllllllllllIIIIllIIlIlIlllllllI */
        //    94: getfield        net/minecraft/world/gen/structure/template/TemplateManager.templates:Ljava/util/Map;
        //    97: aload_3         /* llllllllllllIIIIllIIlIlIlllllIll */
        //    98: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   103: checkcast       Lnet/minecraft/world/gen/structure/template/Template;
        //   106: astore          llllllllllllIIIIllIIlIlIlllllIII
        //   108: aconst_null    
        //   109: astore          llllllllllllIIIIllIIlIlIllllIlll
        //   111: aload           llllllllllllIIIIllIIlIlIlllllIII
        //   113: new             Lnet/minecraft/nbt/NBTTagCompound;
        //   116: dup            
        //   117: invokespecial   net/minecraft/nbt/NBTTagCompound.<init>:()V
        //   120: invokevirtual   net/minecraft/world/gen/structure/template/Template.writeToNBT:(Lnet/minecraft/nbt/NBTTagCompound;)Lnet/minecraft/nbt/NBTTagCompound;
        //   123: astore          llllllllllllIIIIllIIlIlIllllIlII
        //   125: new             Ljava/io/FileOutputStream;
        //   128: dup            
        //   129: aload           llllllllllllIIIIllIIlIlIlllllIIl
        //   131: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   134: astore          llllllllllllIIIIllIIlIlIllllIlll
        //   136: aload           llllllllllllIIIIllIIlIlIllllIlII
        //   138: aload           llllllllllllIIIIllIIlIlIllllIlll
        //   140: invokestatic    net/minecraft/nbt/CompressedStreamTools.writeCompressed:(Lnet/minecraft/nbt/NBTTagCompound;Ljava/io/OutputStream;)V
        //   143: aload           llllllllllllIIIIllIIlIlIllllIlll
        //   145: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
        //   148: iconst_1       
        //   149: ireturn        
        //   150: astore          llllllllllllIIIIllIIlIlIllllIIll
        //   152: iconst_0       
        //   153: istore          llllllllllllIIIIllIIlIlIllllIllI
        //   155: aload           llllllllllllIIIIllIIlIlIllllIlll
        //   157: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
        //   160: goto            173
        //   163: astore          llllllllllllIIIIllIIlIlIlllIlIII
        //   165: aload           llllllllllllIIIIllIIlIlIllllIlll
        //   167: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
        //   170: aload           llllllllllllIIIIllIIlIlIlllIlIII
        //   172: athrow         
        //   173: iload           llllllllllllIIIIllIIlIlIllllIlIl
        //   175: ireturn        
        //   176: iconst_0       
        //   177: ireturn        
        //    RuntimeVisibleTypeAnnotations: 00 01 16 00 00 00 3B 00 00
        //    StackMapTable: 00 06 FD 00 35 07 00 57 07 00 5D 09 FF 00 56 00 08 07 00 02 07 00 B7 07 00 29 07 00 57 07 00 5D 07 00 5D 07 00 43 07 00 86 00 01 07 00 5B 4C 07 00 5B FD 00 09 01 07 00 5B FF 00 02 00 04 07 00 02 07 00 B7 07 00 29 07 00 57 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  111    143    150    163    Ljava/lang/Throwable;
        //  111    143    163    173    Any
        //  150    155    163    173    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void readTemplateFromStream(final String llllllllllllIIIIllIIlIllIIIlIIlI, final InputStream llllllllllllIIIIllIIlIllIIIIllII) throws IOException {
        final NBTTagCompound llllllllllllIIIIllIIlIllIIIlIIII = CompressedStreamTools.readCompressed(llllllllllllIIIIllIIlIllIIIIllII);
        if (!llllllllllllIIIIllIIlIllIIIlIIII.hasKey("DataVersion", 99)) {
            llllllllllllIIIIllIIlIllIIIlIIII.setInteger("DataVersion", 500);
        }
        final Template llllllllllllIIIIllIIlIllIIIIllll = new Template();
        llllllllllllIIIIllIIlIllIIIIllll.read(this.field_191154_c.process(FixTypes.STRUCTURE, llllllllllllIIIIllIIlIllIIIlIIII));
        this.templates.put(llllllllllllIIIIllIIlIllIIIlIIlI, llllllllllllIIIIllIIlIllIIIIllll);
    }
    
    private boolean readTemplateFromJar(final ResourceLocation llllllllllllIIIIllIIlIllIIIlllll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/util/ResourceLocation.getResourceDomain:()Ljava/lang/String;
        //     4: astore_2        /* llllllllllllIIIIllIIlIllIIIllllI */
        //     5: aload_1         /* llllllllllllIIIIllIIlIllIIlIIlll */
        //     6: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //     9: astore_3        /* llllllllllllIIIIllIIlIllIIIlllIl */
        //    10: aconst_null    
        //    11: astore          llllllllllllIIIIllIIlIllIIlIIlII
        //    13: ldc             Lnet/minecraft/server/MinecraftServer;.class
        //    15: new             Ljava/lang/StringBuilder;
        //    18: dup            
        //    19: ldc             "/assets/"
        //    21: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    24: aload_2         /* llllllllllllIIIIllIIlIllIIlIIllI */
        //    25: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    28: ldc             "/structures/"
        //    30: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    33: aload_3         /* llllllllllllIIIIllIIlIllIIlIIlIl */
        //    34: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    37: ldc             ".nbt"
        //    39: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    42: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    45: invokevirtual   java/lang/Class.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    48: astore          llllllllllllIIIIllIIlIllIIlIIlII
        //    50: aload_0         /* llllllllllllIIIIllIIlIllIIlIlIII */
        //    51: aload_3         /* llllllllllllIIIIllIIlIllIIlIIlIl */
        //    52: aload           llllllllllllIIIIllIIlIllIIlIIlII
        //    54: invokespecial   net/minecraft/world/gen/structure/template/TemplateManager.readTemplateFromStream:(Ljava/lang/String;Ljava/io/InputStream;)V
        //    57: aload           llllllllllllIIIIllIIlIllIIlIIlII
        //    59: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    62: iconst_1       
        //    63: ireturn        
        //    64: astore          llllllllllllIIIIllIIlIllIIlIIIIl
        //    66: iconst_0       
        //    67: istore          llllllllllllIIIIllIIlIllIIlIIIll
        //    69: aload           llllllllllllIIIIllIIlIllIIlIIlII
        //    71: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    74: goto            87
        //    77: astore          llllllllllllIIIIllIIlIllIIIllIIl
        //    79: aload           llllllllllllIIIIllIIlIllIIlIIlII
        //    81: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    84: aload           llllllllllllIIIIllIIlIllIIIllIIl
        //    86: athrow         
        //    87: iload           llllllllllllIIIIllIIlIllIIlIIIlI
        //    89: ireturn        
        //    StackMapTable: 00 03 FF 00 40 00 05 07 00 02 07 00 29 07 00 57 07 00 57 07 01 0E 00 01 07 00 5B 4C 07 00 5B FD 00 09 01 07 00 5B
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  13     57     64     77     Ljava/lang/Throwable;
        //  13     57     77     87     Any
        //  64     69     77     87     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public Template getTemplate(@Nullable final MinecraftServer llllllllllllIIIIllIIlIllIlIlIlll, final ResourceLocation llllllllllllIIIIllIIlIllIlIllIlI) {
        Template llllllllllllIIIIllIIlIllIlIllIIl = this.get(llllllllllllIIIIllIIlIllIlIlIlll, llllllllllllIIIIllIIlIllIlIllIlI);
        if (llllllllllllIIIIllIIlIllIlIllIIl == null) {
            llllllllllllIIIIllIIlIllIlIllIIl = new Template();
            this.templates.put(llllllllllllIIIIllIIlIllIlIllIlI.getResourcePath(), llllllllllllIIIIllIIlIllIlIllIIl);
        }
        return llllllllllllIIIIllIIlIllIlIllIIl;
    }
    
    public boolean readTemplate(final ResourceLocation llllllllllllIIIIllIIlIllIIllIlll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //     4: astore_2        /* llllllllllllIIIIllIIlIllIIlllllI */
        //     5: new             Ljava/io/File;
        //     8: dup            
        //     9: aload_0         /* llllllllllllIIIIllIIlIllIlIIIIII */
        //    10: getfield        net/minecraft/world/gen/structure/template/TemplateManager.baseFolder:Ljava/lang/String;
        //    13: new             Ljava/lang/StringBuilder;
        //    16: dup            
        //    17: aload_2         /* llllllllllllIIIIllIIlIllIIlllllI */
        //    18: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    21: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    24: ldc             ".nbt"
        //    26: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    29: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    32: invokespecial   java/io/File.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    35: astore_3        /* llllllllllllIIIIllIIlIllIIllIlIl */
        //    36: aload_3         /* llllllllllllIIIIllIIlIllIIllllIl */
        //    37: invokevirtual   java/io/File.exists:()Z
        //    40: ifne            49
        //    43: aload_0         /* llllllllllllIIIIllIIlIllIlIIIIII */
        //    44: aload_1         /* llllllllllllIIIIllIIlIllIIllllll */
        //    45: invokespecial   net/minecraft/world/gen/structure/template/TemplateManager.readTemplateFromJar:(Lnet/minecraft/util/ResourceLocation;)Z
        //    48: ireturn        
        //    49: aconst_null    
        //    50: astore          llllllllllllIIIIllIIlIllIIllllII
        //    52: new             Ljava/io/FileInputStream;
        //    55: dup            
        //    56: aload_3         /* llllllllllllIIIIllIIlIllIIllllIl */
        //    57: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    60: astore          llllllllllllIIIIllIIlIllIIllllII
        //    62: aload_0         /* llllllllllllIIIIllIIlIllIlIIIIII */
        //    63: aload_2         /* llllllllllllIIIIllIIlIllIIlllllI */
        //    64: aload           llllllllllllIIIIllIIlIllIIllllII
        //    66: invokespecial   net/minecraft/world/gen/structure/template/TemplateManager.readTemplateFromStream:(Ljava/lang/String;Ljava/io/InputStream;)V
        //    69: aload           llllllllllllIIIIllIIlIllIIllllII
        //    71: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    74: iconst_1       
        //    75: ireturn        
        //    76: astore          llllllllllllIIIIllIIlIllIIlllIIl
        //    78: iconst_0       
        //    79: istore          llllllllllllIIIIllIIlIllIIlllIll
        //    81: aload           llllllllllllIIIIllIIlIllIIllllII
        //    83: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    86: goto            99
        //    89: astore          llllllllllllIIIIllIIlIllIIllIIIl
        //    91: aload           llllllllllllIIIIllIIlIllIIllllII
        //    93: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    96: aload           llllllllllllIIIIllIIlIllIIllIIIl
        //    98: athrow         
        //    99: iload           llllllllllllIIIIllIIlIllIIlllIlI
        //   101: ireturn        
        //    StackMapTable: 00 04 FD 00 31 07 00 57 07 00 5D FF 00 1A 00 05 07 00 02 07 00 29 07 00 57 07 00 5D 07 01 1E 00 01 07 00 5B 4C 07 00 5B FD 00 09 01 07 00 5B
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  52     69     76     89     Ljava/lang/Throwable;
        //  52     69     89     99     Any
        //  76     81     89     99     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
