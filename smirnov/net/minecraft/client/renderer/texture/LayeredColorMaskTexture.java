// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import java.io.IOException;
import net.minecraft.client.resources.IResourceManager;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;
import net.minecraft.item.EnumDyeColor;
import java.util.List;

public class LayeredColorMaskTexture extends AbstractTexture
{
    private final /* synthetic */ List<EnumDyeColor> listDyeColors;
    private final /* synthetic */ List<String> listTextures;
    private final /* synthetic */ ResourceLocation textureLocation;
    
    static {
        LOG = LogManager.getLogger();
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllIIllllllIlIIIlIlllIlI) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/texture/LayeredColorMaskTexture.deleteGlTexture:()V
        //     4: aconst_null    
        //     5: astore_2        /* lllllllllllIIllllllIlIIIllIIllIl */
        //     6: aload_1         /* lllllllllllIIllllllIlIIIllIIlllI */
        //     7: aload_0         /* lllllllllllIIllllllIlIIIlIlllIll */
        //     8: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.textureLocation:Lnet/minecraft/util/ResourceLocation;
        //    11: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //    16: astore_2        /* lllllllllllIIllllllIlIIIllIIllIl */
        //    17: aload_2         /* lllllllllllIIllllllIlIIIllIIllIl */
        //    18: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    23: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    26: astore          lllllllllllIIllllllIlIIIllIIlIlI
        //    28: aload           lllllllllllIIllllllIlIIIllIIlIlI
        //    30: invokevirtual   java/awt/image/BufferedImage.getType:()I
        //    33: istore          lllllllllllIIllllllIlIIIllIIlIIl
        //    35: iload           lllllllllllIIllllllIlIIIllIIlIIl
        //    37: ifne            44
        //    40: bipush          6
        //    42: istore          lllllllllllIIllllllIlIIIllIIlIIl
        //    44: new             Ljava/awt/image/BufferedImage;
        //    47: dup            
        //    48: aload           lllllllllllIIllllllIlIIIllIIlIlI
        //    50: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    53: aload           lllllllllllIIllllllIlIIIllIIlIlI
        //    55: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    58: iload           lllllllllllIIllllllIlIIIllIIlIIl
        //    60: invokespecial   java/awt/image/BufferedImage.<init>:(III)V
        //    63: astore_3        /* lllllllllllIIllllllIlIIIllIIllII */
        //    64: aload_3         /* lllllllllllIIllllllIlIIIllIIllII */
        //    65: invokevirtual   java/awt/image/BufferedImage.getGraphics:()Ljava/awt/Graphics;
        //    68: astore          lllllllllllIIllllllIlIIIllIIlIII
        //    70: aload           lllllllllllIIllllllIlIIIllIIlIII
        //    72: aload           lllllllllllIIllllllIlIIIllIIlIlI
        //    74: iconst_0       
        //    75: iconst_0       
        //    76: aconst_null    
        //    77: invokevirtual   java/awt/Graphics.drawImage:(Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
        //    80: pop            
        //    81: iconst_0       
        //    82: istore          lllllllllllIIllllllIlIIIllIIIlll
        //    84: iload           lllllllllllIIllllllIlIIIllIIIlll
        //    86: bipush          17
        //    88: if_icmpge       119
        //    91: iload           lllllllllllIIllllllIlIIIllIIIlll
        //    93: aload_0         /* lllllllllllIIllllllIlIIIlIlllIll */
        //    94: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.listTextures:Ljava/util/List;
        //    97: invokeinterface java/util/List.size:()I
        //   102: if_icmpge       119
        //   105: iload           lllllllllllIIllllllIlIIIllIIIlll
        //   107: aload_0         /* lllllllllllIIllllllIlIIIlIlllIll */
        //   108: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.listDyeColors:Ljava/util/List;
        //   111: invokeinterface java/util/List.size:()I
        //   116: if_icmplt       126
        //   119: aload_2         /* lllllllllllIIllllllIlIIIllIIllIl */
        //   120: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   123: goto            407
        //   126: aconst_null    
        //   127: astore          lllllllllllIIllllllIlIIIllIIIllI
        //   129: aload_0         /* lllllllllllIIllllllIlIIIlIlllIll */
        //   130: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.listTextures:Ljava/util/List;
        //   133: iload           lllllllllllIIllllllIlIIIllIIIlll
        //   135: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   140: checkcast       Ljava/lang/String;
        //   143: astore          lllllllllllIIllllllIlIIIllIIIlIl
        //   145: aload_0         /* lllllllllllIIllllllIlIIIlIlllIll */
        //   146: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.listDyeColors:Ljava/util/List;
        //   149: iload           lllllllllllIIllllllIlIIIllIIIlll
        //   151: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   156: checkcast       Lnet/minecraft/item/EnumDyeColor;
        //   159: invokevirtual   net/minecraft/item/EnumDyeColor.func_193350_e:()I
        //   162: istore          lllllllllllIIllllllIlIIIllIIIlII
        //   164: aload           lllllllllllIIllllllIlIIIllIIIlIl
        //   166: ifnull          365
        //   169: aload_1         /* lllllllllllIIllllllIlIIIllIIlllI */
        //   170: new             Lnet/minecraft/util/ResourceLocation;
        //   173: dup            
        //   174: aload           lllllllllllIIllllllIlIIIllIIIlIl
        //   176: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
        //   179: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //   184: astore          lllllllllllIIllllllIlIIIllIIIllI
        //   186: aload           lllllllllllIIllllllIlIIIllIIIllI
        //   188: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //   193: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //   196: astore          lllllllllllIIllllllIlIIIllIIIIll
        //   198: aload           lllllllllllIIllllllIlIIIllIIIIll
        //   200: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   203: aload_3         /* lllllllllllIIllllllIlIIIllIIllII */
        //   204: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   207: if_icmpne       365
        //   210: aload           lllllllllllIIllllllIlIIIllIIIIll
        //   212: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   215: aload_3         /* lllllllllllIIllllllIlIIIllIIllII */
        //   216: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   219: if_icmpne       365
        //   222: aload           lllllllllllIIllllllIlIIIllIIIIll
        //   224: invokevirtual   java/awt/image/BufferedImage.getType:()I
        //   227: bipush          6
        //   229: if_icmpne       365
        //   232: iconst_0       
        //   233: istore          lllllllllllIIllllllIlIIIllIIIIlI
        //   235: goto            329
        //   238: iconst_0       
        //   239: istore          lllllllllllIIllllllIlIIIllIIIIIl
        //   241: goto            316
        //   244: aload           lllllllllllIIllllllIlIIIllIIIIll
        //   246: iload           lllllllllllIIllllllIlIIIllIIIIIl
        //   248: iload           lllllllllllIIllllllIlIIIllIIIIlI
        //   250: invokevirtual   java/awt/image/BufferedImage.getRGB:(II)I
        //   253: istore          lllllllllllIIllllllIlIIIllIIIIII
        //   255: iload           lllllllllllIIllllllIlIIIllIIIIII
        //   257: ldc             -16777216
        //   259: iand           
        //   260: ifeq            313
        //   263: iload           lllllllllllIIllllllIlIIIllIIIIII
        //   265: ldc             16711680
        //   267: iand           
        //   268: bipush          8
        //   270: ishl           
        //   271: ldc             -16777216
        //   273: iand           
        //   274: istore          lllllllllllIIllllllIlIIIlIllllll
        //   276: aload           lllllllllllIIllllllIlIIIllIIlIlI
        //   278: iload           lllllllllllIIllllllIlIIIllIIIIIl
        //   280: iload           lllllllllllIIllllllIlIIIllIIIIlI
        //   282: invokevirtual   java/awt/image/BufferedImage.getRGB:(II)I
        //   285: istore          lllllllllllIIllllllIlIIIlIlllllI
        //   287: iload           lllllllllllIIllllllIlIIIlIlllllI
        //   289: iload           lllllllllllIIllllllIlIIIllIIIlII
        //   291: invokestatic    net/minecraft/util/math/MathHelper.multiplyColor:(II)I
        //   294: ldc             16777215
        //   296: iand           
        //   297: istore          lllllllllllIIllllllIlIIIlIllllIl
        //   299: aload           lllllllllllIIllllllIlIIIllIIIIll
        //   301: iload           lllllllllllIIllllllIlIIIllIIIIIl
        //   303: iload           lllllllllllIIllllllIlIIIllIIIIlI
        //   305: iload           lllllllllllIIllllllIlIIIlIllllll
        //   307: iload           lllllllllllIIllllllIlIIIlIllllIl
        //   309: ior            
        //   310: invokevirtual   java/awt/image/BufferedImage.setRGB:(III)V
        //   313: iinc            lllllllllllIIllllllIlIIIllIIIIIl, 1
        //   316: iload           lllllllllllIIllllllIlIIIllIIIIIl
        //   318: aload           lllllllllllIIllllllIlIIIllIIIIll
        //   320: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   323: if_icmplt       244
        //   326: iinc            lllllllllllIIllllllIlIIIllIIIIlI, 1
        //   329: iload           lllllllllllIIllllllIlIIIllIIIIlI
        //   331: aload           lllllllllllIIllllllIlIIIllIIIIll
        //   333: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   336: if_icmplt       238
        //   339: aload_3         /* lllllllllllIIllllllIlIIIllIIllII */
        //   340: invokevirtual   java/awt/image/BufferedImage.getGraphics:()Ljava/awt/Graphics;
        //   343: aload           lllllllllllIIllllllIlIIIllIIIIll
        //   345: iconst_0       
        //   346: iconst_0       
        //   347: aconst_null    
        //   348: invokevirtual   java/awt/Graphics.drawImage:(Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
        //   351: pop            
        //   352: goto            365
        //   355: astore          lllllllllllIIllllllIlIIIlIlIlIIl
        //   357: aload           lllllllllllIIllllllIlIIIllIIIllI
        //   359: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   362: aload           lllllllllllIIllllllIlIIIlIlIlIIl
        //   364: athrow         
        //   365: aload           lllllllllllIIllllllIlIIIllIIIllI
        //   367: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   370: iinc            lllllllllllIIllllllIlIIIllIIIlll, 1
        //   373: goto            84
        //   376: astore          lllllllllllIIllllllIlIIIlIllllII
        //   378: getstatic       net/minecraft/client/renderer/texture/LayeredColorMaskTexture.LOG:Lorg/apache/logging/log4j/Logger;
        //   381: ldc             "Couldn't load layered image"
        //   383: aload           lllllllllllIIllllllIlIIIlIllllII
        //   385: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   390: aload_2         /* lllllllllllIIllllllIlIIIllIIllIl */
        //   391: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   394: goto            406
        //   397: astore          lllllllllllIIllllllIlIIIlIlIlIII
        //   399: aload_2         /* lllllllllllIIllllllIlIIIllIIllIl */
        //   400: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   403: aload           lllllllllllIIllllllIlIIIlIlIlIII
        //   405: athrow         
        //   406: return         
        //   407: aload_0         /* lllllllllllIIllllllIlIIIlIlllIll */
        //   408: invokevirtual   net/minecraft/client/renderer/texture/LayeredColorMaskTexture.getGlTextureId:()I
        //   411: aload_3         /* lllllllllllIIllllllIlIIIllIIlIll */
        //   412: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.uploadTextureImage:(ILjava/awt/image/BufferedImage;)I
        //   415: pop            
        //   416: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 0F FF 00 2C 00 06 07 00 02 07 00 22 07 00 28 00 07 00 34 01 00 00 FF 00 27 00 08 07 00 02 07 00 22 07 00 28 07 00 34 07 00 34 01 07 00 48 01 00 00 22 06 FF 00 6F 00 0D 07 00 02 07 00 22 07 00 28 07 00 34 07 00 34 01 07 00 48 01 07 00 28 07 00 61 01 07 00 34 01 00 00 FC 00 05 01 FC 00 44 01 FA 00 02 FA 00 0C FF 00 19 00 09 07 00 02 07 00 22 07 00 28 07 00 34 07 00 34 01 07 00 48 01 07 00 28 00 01 07 00 C3 FD 00 09 07 00 61 01 FF 00 0A 00 03 07 00 02 07 00 22 07 00 28 00 01 07 00 1B 54 07 00 C3 FD 00 08 00 07 00 1B FF 00 00 00 08 07 00 02 07 00 22 07 00 28 07 00 34 07 00 34 01 07 00 48 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  129    355    355    365    Any
        //  6      119    376    397    Ljava/io/IOException;
        //  126    376    376    397    Ljava/io/IOException;
        //  6      119    397    406    Any
        //  126    390    397    406    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public LayeredColorMaskTexture(final ResourceLocation lllllllllllIIllllllIlIIIlllIIllI, final List<String> lllllllllllIIllllllIlIIIlllIIlIl, final List<EnumDyeColor> lllllllllllIIllllllIlIIIlllIIlII) {
        this.textureLocation = lllllllllllIIllllllIlIIIlllIIllI;
        this.listTextures = lllllllllllIIllllllIlIIIlllIIlIl;
        this.listDyeColors = lllllllllllIIllllllIlIIIlllIIlII;
    }
}
