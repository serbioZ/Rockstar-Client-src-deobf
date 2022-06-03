// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import java.io.InputStream;
import optifine.Mipmaps;
import optifine.Reflector;
import java.io.IOException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.Minecraft;
import optifine.Config;
import net.minecraft.client.renderer.GLAllocation;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.renderer.GlStateManager;
import java.awt.image.BufferedImage;
import java.nio.IntBuffer;
import org.apache.logging.log4j.Logger;

public class TextureUtil
{
    private static final /* synthetic */ float[] COLOR_GAMMAS;
    public static final /* synthetic */ DynamicTexture MISSING_TEXTURE;
    public static final /* synthetic */ int[] MISSING_TEXTURE_DATA;
    private static final /* synthetic */ IntBuffer DATA_BUFFER;
    
    public static int[] updateAnaglyph(final int[] lllllllllllIlIlIIlllIllIIlIIIIIl) {
        final int[] lllllllllllIlIlIIlllIllIIlIIIIll = new int[lllllllllllIlIlIIlllIllIIlIIIIIl.length];
        for (int lllllllllllIlIlIIlllIllIIlIIIIlI = 0; lllllllllllIlIlIIlllIllIIlIIIIlI < lllllllllllIlIlIIlllIllIIlIIIIIl.length; ++lllllllllllIlIlIIlllIllIIlIIIIlI) {
            lllllllllllIlIlIIlllIllIIlIIIIll[lllllllllllIlIlIIlllIllIIlIIIIlI] = anaglyphColor(lllllllllllIlIlIIlllIllIIlIIIIIl[lllllllllllIlIlIIlllIllIIlIIIIlI]);
        }
        return lllllllllllIlIlIIlllIllIIlIIIIll;
    }
    
    private static int blendColorComponent(final int lllllllllllIlIlIIlllIlllIlIIllIl, final int lllllllllllIlIlIIlllIlllIlIIllII, final int lllllllllllIlIlIIlllIlllIlIIIIIl, final int lllllllllllIlIlIIlllIlllIlIIIIII, final int lllllllllllIlIlIIlllIlllIlIIlIIl) {
        final float lllllllllllIlIlIIlllIlllIlIIlIII = getColorGamma(lllllllllllIlIlIIlllIlllIlIIllIl >> lllllllllllIlIlIIlllIlllIlIIlIIl);
        final float lllllllllllIlIlIIlllIlllIlIIIlll = getColorGamma(lllllllllllIlIlIIlllIlllIlIIllII >> lllllllllllIlIlIIlllIlllIlIIlIIl);
        final float lllllllllllIlIlIIlllIlllIlIIIllI = getColorGamma(lllllllllllIlIlIIlllIlllIlIIIIIl >> lllllllllllIlIlIIlllIlllIlIIlIIl);
        final float lllllllllllIlIlIIlllIlllIlIIIlIl = getColorGamma(lllllllllllIlIlIIlllIlllIlIIIIII >> lllllllllllIlIlIIlllIlllIlIIlIIl);
        final float lllllllllllIlIlIIlllIlllIlIIIlII = (float)Math.pow((lllllllllllIlIlIIlllIlllIlIIlIII + lllllllllllIlIlIIlllIlllIlIIIlll + lllllllllllIlIlIIlllIlllIlIIIllI + lllllllllllIlIlIIlllIlllIlIIIlIl) * 0.25, 0.45454545454545453);
        return (int)(lllllllllllIlIlIIlllIlllIlIIIlII * 255.0);
    }
    
    private static void copyToBuffer(final int[] lllllllllllIlIlIIlllIllIlIIIIIll, final int lllllllllllIlIlIIlllIllIlIIIIIII) {
        copyToBufferPos(lllllllllllIlIlIIlllIllIlIIIIIll, 0, lllllllllllIlIlIIlllIllIlIIIIIII);
    }
    
    public static int uploadTextureImage(final int lllllllllllIlIlIIlllIllllIIlllIl, final BufferedImage lllllllllllIlIlIIlllIllllIIllllI) {
        return uploadTextureImageAllocate(lllllllllllIlIlIIlllIllllIIlllIl, lllllllllllIlIlIIlllIllllIIllllI, false, false);
    }
    
    public static void uploadTexture(final int lllllllllllIlIlIIlllIllllIIlIlll, final int[] lllllllllllIlIlIIlllIllllIIlIIlI, final int lllllllllllIlIlIIlllIllllIIlIlIl, final int lllllllllllIlIlIIlllIllllIIlIlII) {
        bindTexture(lllllllllllIlIlIIlllIllllIIlIlll);
        uploadTextureSub(0, lllllllllllIlIlIIlllIllllIIlIIlI, lllllllllllIlIlIIlllIllllIIlIlIl, lllllllllllIlIlIIlllIllllIIlIlII, 0, 0, false, false, false);
    }
    
    public static int uploadTextureImageAllocate(final int lllllllllllIlIlIIlllIllIllllIIII, final BufferedImage lllllllllllIlIlIIlllIllIlllIlIll, final boolean lllllllllllIlIlIIlllIllIlllIlIlI, final boolean lllllllllllIlIlIIlllIllIlllIllIl) {
        allocateTexture(lllllllllllIlIlIIlllIllIllllIIII, lllllllllllIlIlIIlllIllIlllIlIll.getWidth(), lllllllllllIlIlIIlllIllIlllIlIll.getHeight());
        return uploadTextureImageSub(lllllllllllIlIlIIlllIllIllllIIII, lllllllllllIlIlIIlllIllIlllIlIll, 0, 0, lllllllllllIlIlIIlllIllIlllIlIlI, lllllllllllIlIlIIlllIllIlllIllIl);
    }
    
    public static void setTextureClamped(final boolean lllllllllllIlIlIIlllIllIlIIlIIlI) {
        if (lllllllllllIlIlIIlllIllIlIIlIIlI) {
            GlStateManager.glTexParameteri(3553, 10242, 33071);
            GlStateManager.glTexParameteri(3553, 10243, 33071);
        }
        else {
            GlStateManager.glTexParameteri(3553, 10242, 10497);
            GlStateManager.glTexParameteri(3553, 10243, 10497);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DATA_BUFFER = GLAllocation.createDirectIntBuffer(4194304);
        MISSING_TEXTURE = new DynamicTexture(16, 16);
        MISSING_TEXTURE_DATA = TextureUtil.MISSING_TEXTURE.getTextureData();
        final int lllllllllllIlIlIIlllIllllIllIlll = -16777216;
        final int lllllllllllIlIlIIlllIllllIllIllI = -524040;
        final int[] lllllllllllIlIlIIlllIllllIllIlIl = { -524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040 };
        final int[] lllllllllllIlIlIIlllIllllIllIlII = { -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216 };
        final int lllllllllllIlIlIIlllIllllIllIIll = lllllllllllIlIlIIlllIllllIllIlIl.length;
        for (int lllllllllllIlIlIIlllIllllIllIIlI = 0; lllllllllllIlIlIIlllIllllIllIIlI < 16; ++lllllllllllIlIlIIlllIllllIllIIlI) {
            System.arraycopy((lllllllllllIlIlIIlllIllllIllIIlI < lllllllllllIlIlIIlllIllllIllIIll) ? lllllllllllIlIlIIlllIllllIllIlIl : lllllllllllIlIlIIlllIllllIllIlII, 0, TextureUtil.MISSING_TEXTURE_DATA, 16 * lllllllllllIlIlIIlllIllllIllIIlI, lllllllllllIlIlIIlllIllllIllIIll);
            System.arraycopy((lllllllllllIlIlIIlllIllllIllIIlI < lllllllllllIlIlIIlllIllllIllIIll) ? lllllllllllIlIlIIlllIllllIllIlII : lllllllllllIlIlIIlllIllllIllIlIl, 0, TextureUtil.MISSING_TEXTURE_DATA, 16 * lllllllllllIlIlIIlllIllllIllIIlI + lllllllllllIlIlIIlllIllllIllIIll, lllllllllllIlIlIIlllIllllIllIIll);
        }
        TextureUtil.MISSING_TEXTURE.updateDynamicTexture();
        COLOR_GAMMAS = new float[256];
        for (int lllllllllllIlIlIIlllIllllIllIIIl = 0; lllllllllllIlIlIIlllIllllIllIIIl < TextureUtil.COLOR_GAMMAS.length; ++lllllllllllIlIlIIlllIllllIllIIIl) {
            TextureUtil.COLOR_GAMMAS[lllllllllllIlIlIIlllIllllIllIIIl] = (float)Math.pow(lllllllllllIlIlIIlllIllllIllIIIl / 255.0f, 2.2);
        }
        MIPMAP_BUFFER = new int[4];
    }
    
    public static void deleteTexture(final int lllllllllllIlIlIIlllIllllIlIIIll) {
        GlStateManager.deleteTexture(lllllllllllIlIlIIlllIllllIlIIIll);
    }
    
    public static void setTextureBlurMipmap(final boolean lllllllllllIlIlIIlllIllIlIIIlIll, final boolean lllllllllllIlIlIIlllIllIlIIIlIlI) {
        if (lllllllllllIlIlIIlllIllIlIIIlIll) {
            GlStateManager.glTexParameteri(3553, 10241, lllllllllllIlIlIIlllIllIlIIIlIlI ? 9987 : 9729);
            GlStateManager.glTexParameteri(3553, 10240, 9729);
        }
        else {
            final int lllllllllllIlIlIIlllIllIlIIIlIIl = Config.getMipmapType();
            GlStateManager.glTexParameteri(3553, 10241, lllllllllllIlIlIIlllIllIlIIIlIlI ? lllllllllllIlIlIIlllIllIlIIIlIIl : 9728);
            GlStateManager.glTexParameteri(3553, 10240, 9728);
        }
    }
    
    private static void uploadTextureSub(final int lllllllllllIlIlIIlllIlllIIIIIIlI, final int[] lllllllllllIlIlIIlllIlllIIIIIIIl, final int lllllllllllIlIlIIlllIlllIIIIIIII, final int lllllllllllIlIlIIlllIllIllllllll, final int lllllllllllIlIlIIlllIllIlllllllI, final int lllllllllllIlIlIIlllIlllIIIIlIll, final boolean lllllllllllIlIlIIlllIllIllllllII, final boolean lllllllllllIlIlIIlllIllIlllllIll, final boolean lllllllllllIlIlIIlllIllIlllllIlI) {
        final int lllllllllllIlIlIIlllIlllIIIIIlll = 4194304 / lllllllllllIlIlIIlllIlllIIIIIIII;
        setTextureBlurMipmap(lllllllllllIlIlIIlllIllIllllllII, lllllllllllIlIlIIlllIllIlllllIlI);
        setTextureClamped(lllllllllllIlIlIIlllIllIlllllIll);
        int lllllllllllIlIlIIlllIlllIIIIIllI;
        for (int lllllllllllIlIlIIlllIlllIIIIIlIl = 0; lllllllllllIlIlIIlllIlllIIIIIlIl < lllllllllllIlIlIIlllIlllIIIIIIII * lllllllllllIlIlIIlllIllIllllllll; lllllllllllIlIlIIlllIlllIIIIIlIl += lllllllllllIlIlIIlllIlllIIIIIIII * lllllllllllIlIlIIlllIlllIIIIIllI) {
            final int lllllllllllIlIlIIlllIlllIIIIIlII = lllllllllllIlIlIIlllIlllIIIIIlIl / lllllllllllIlIlIIlllIlllIIIIIIII;
            lllllllllllIlIlIIlllIlllIIIIIllI = Math.min(lllllllllllIlIlIIlllIlllIIIIIlll, lllllllllllIlIlIIlllIllIllllllll - lllllllllllIlIlIIlllIlllIIIIIlII);
            final int lllllllllllIlIlIIlllIlllIIIIIIll = lllllllllllIlIlIIlllIlllIIIIIIII * lllllllllllIlIlIIlllIlllIIIIIllI;
            copyToBufferPos(lllllllllllIlIlIIlllIlllIIIIIIIl, lllllllllllIlIlIIlllIlllIIIIIlIl, lllllllllllIlIlIIlllIlllIIIIIIll);
            GlStateManager.glTexSubImage2D(3553, lllllllllllIlIlIIlllIlllIIIIIIlI, lllllllllllIlIlIIlllIllIlllllllI, lllllllllllIlIlIIlllIlllIIIIlIll + lllllllllllIlIlIIlllIlllIIIIIlII, lllllllllllIlIlIIlllIlllIIIIIIII, lllllllllllIlIlIIlllIlllIIIIIllI, 32993, 33639, TextureUtil.DATA_BUFFER);
        }
    }
    
    public static int anaglyphColor(final int lllllllllllIlIlIIlllIllIIIlIlllI) {
        final int lllllllllllIlIlIIlllIllIIIllIlIl = lllllllllllIlIlIIlllIllIIIlIlllI >> 24 & 0xFF;
        final int lllllllllllIlIlIIlllIllIIIllIlII = lllllllllllIlIlIIlllIllIIIlIlllI >> 16 & 0xFF;
        final int lllllllllllIlIlIIlllIllIIIllIIll = lllllllllllIlIlIIlllIllIIIlIlllI >> 8 & 0xFF;
        final int lllllllllllIlIlIIlllIllIIIllIIlI = lllllllllllIlIlIIlllIllIIIlIlllI & 0xFF;
        final int lllllllllllIlIlIIlllIllIIIllIIIl = (lllllllllllIlIlIIlllIllIIIllIlII * 30 + lllllllllllIlIlIIlllIllIIIllIIll * 59 + lllllllllllIlIlIIlllIllIIIllIIlI * 11) / 100;
        final int lllllllllllIlIlIIlllIllIIIllIIII = (lllllllllllIlIlIIlllIllIIIllIlII * 30 + lllllllllllIlIlIIlllIllIIIllIIll * 70) / 100;
        final int lllllllllllIlIlIIlllIllIIIlIllll = (lllllllllllIlIlIIlllIllIIIllIlII * 30 + lllllllllllIlIlIIlllIllIIIllIIlI * 70) / 100;
        return lllllllllllIlIlIIlllIllIIIllIlIl << 24 | lllllllllllIlIlIIlllIllIIIllIIIl << 16 | lllllllllllIlIlIIlllIllIIIllIIII << 8 | lllllllllllIlIlIIlllIllIIIlIllll;
    }
    
    private static void copyToBufferPos(final int[] lllllllllllIlIlIIlllIllIIllllIll, final int lllllllllllIlIlIIlllIllIIlllIllI, final int lllllllllllIlIlIIlllIllIIllllIIl) {
        int[] lllllllllllIlIlIIlllIllIIllllIII = lllllllllllIlIlIIlllIllIIllllIll;
        if (Minecraft.getMinecraft().gameSettings.anaglyph) {
            lllllllllllIlIlIIlllIllIIllllIII = updateAnaglyph(lllllllllllIlIlIIlllIllIIllllIll);
        }
        TextureUtil.DATA_BUFFER.clear();
        TextureUtil.DATA_BUFFER.put(lllllllllllIlIlIIlllIllIIllllIII, lllllllllllIlIlIIlllIllIIlllIllI, lllllllllllIlIlIIlllIllIIllllIIl);
        TextureUtil.DATA_BUFFER.position(0).limit(lllllllllllIlIlIIlllIllIIllllIIl);
    }
    
    private static void setTextureBlurred(final boolean lllllllllllIlIlIIlllIllIlIIIllll) {
        setTextureBlurMipmap(lllllllllllIlIlIIlllIllIlIIIllll, false);
    }
    
    public static int[] readImageData(final IResourceManager lllllllllllIlIlIIlllIllIIlIllIll, final ResourceLocation lllllllllllIlIlIIlllIllIIlIllIlI) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* lllllllllllIlIlIIlllIllIIlIllIIl */
        //     2: aload_0         /* lllllllllllIlIlIIlllIllIIllIIlIl */
        //     3: aload_1         /* lllllllllllIlIlIIlllIllIIllIIlII */
        //     4: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //     9: astore_2        /* lllllllllllIlIlIIlllIllIIllIIIll */
        //    10: aload_2         /* lllllllllllIlIlIIlllIllIIllIIIll */
        //    11: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    16: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    19: astore          lllllllllllIlIlIIlllIllIIllIIIII
        //    21: aload           lllllllllllIlIlIIlllIllIIllIIIII
        //    23: ifnull          81
        //    26: aload           lllllllllllIlIlIIlllIllIIllIIIII
        //    28: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    31: istore          lllllllllllIlIlIIlllIllIIlIlllll
        //    33: aload           lllllllllllIlIlIIlllIllIIllIIIII
        //    35: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    38: istore          lllllllllllIlIlIIlllIllIIlIllllI
        //    40: iload           lllllllllllIlIlIIlllIllIIlIlllll
        //    42: iload           lllllllllllIlIlIIlllIllIIlIllllI
        //    44: imul           
        //    45: newarray        I
        //    47: astore          lllllllllllIlIlIIlllIllIIlIlllIl
        //    49: aload           lllllllllllIlIlIIlllIllIIllIIIII
        //    51: iconst_0       
        //    52: iconst_0       
        //    53: iload           lllllllllllIlIlIIlllIllIIlIlllll
        //    55: iload           lllllllllllIlIlIIlllIllIIlIllllI
        //    57: aload           lllllllllllIlIlIIlllIllIIlIlllIl
        //    59: iconst_0       
        //    60: iload           lllllllllllIlIlIIlllIllIIlIlllll
        //    62: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //    65: pop            
        //    66: aload           lllllllllllIlIlIIlllIllIIlIlllIl
        //    68: astore          lllllllllllIlIlIIlllIllIIlIlllII
        //    70: aload           lllllllllllIlIlIIlllIllIIlIlllII
        //    72: astore          lllllllllllIlIlIIlllIllIIlIlIIIl
        //    74: aload_2         /* lllllllllllIlIlIIlllIllIIllIIIll */
        //    75: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    78: aload           lllllllllllIlIlIIlllIllIIlIlIIIl
        //    80: areturn        
        //    81: aconst_null    
        //    82: astore_3        /* lllllllllllIlIlIIlllIllIIllIIIlI */
        //    83: goto            95
        //    86: astore          lllllllllllIlIlIIlllIllIIlIlIIlI
        //    88: aload_2         /* lllllllllllIlIlIIlllIllIIllIIIll */
        //    89: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    92: aload           lllllllllllIlIlIIlllIllIIlIlIIlI
        //    94: athrow         
        //    95: aload_2         /* lllllllllllIlIlIIlllIllIIllIIIll */
        //    96: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    99: aload_3         /* lllllllllllIlIlIIlllIllIIllIIIIl */
        //   100: checkcast       [I
        //   103: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 03 FE 00 51 07 01 62 00 07 00 74 FF 00 04 00 03 07 01 5C 07 01 8F 07 01 62 00 01 07 01 91 FD 00 08 05 07 00 74
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  2      74     86     95     Any
        //  81     86     86     95     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void allocateTextureImpl(final int lllllllllllIlIlIIlllIllIllIllIIl, final int lllllllllllIlIlIIlllIllIllIllIII, final int lllllllllllIlIlIIlllIllIllIlIlll, final int lllllllllllIlIlIIlllIllIllIlIllI) {
        Object lllllllllllIlIlIIlllIllIllIlIlIl = TextureUtil.class;
        if (Reflector.SplashScreen.exists()) {
            lllllllllllIlIlIIlllIllIllIlIlIl = Reflector.SplashScreen.getTargetClass();
        }
        synchronized (lllllllllllIlIlIIlllIllIllIlIlIl) {
            deleteTexture(lllllllllllIlIlIIlllIllIllIllIIl);
            bindTexture(lllllllllllIlIlIIlllIllIllIllIIl);
        }
        if (lllllllllllIlIlIIlllIllIllIllIII >= 0) {
            GlStateManager.glTexParameteri(3553, 33085, lllllllllllIlIlIIlllIllIllIllIII);
            GlStateManager.glTexParameteri(3553, 33082, 0);
            GlStateManager.glTexParameteri(3553, 33083, lllllllllllIlIlIIlllIllIllIllIII);
            GlStateManager.glTexParameterf(3553, 34049, 0.0f);
        }
        for (int lllllllllllIlIlIIlllIllIllIlIlII = 0; lllllllllllIlIlIIlllIllIllIlIlII <= lllllllllllIlIlIIlllIllIllIllIII; ++lllllllllllIlIlIIlllIllIllIlIlII) {
            GlStateManager.glTexImage2D(3553, lllllllllllIlIlIIlllIllIllIlIlII, 6408, lllllllllllIlIlIIlllIllIllIlIlll >> lllllllllllIlIlIIlllIllIllIlIlII, lllllllllllIlIlIIlllIllIllIlIllI >> lllllllllllIlIlIIlllIllIllIlIlII, 0, 32993, 33639, null);
        }
    }
    
    public static int glGenTextures() {
        return GlStateManager.generateTexture();
    }
    
    private static int blendColors(final int lllllllllllIlIlIIlllIlllIlIllIll, final int lllllllllllIlIlIIlllIlllIlIlllll, final int lllllllllllIlIlIIlllIlllIlIllllI, final int lllllllllllIlIlIIlllIlllIlIllIII, final boolean lllllllllllIlIlIIlllIlllIlIlllII) {
        return Mipmaps.alphaBlend(lllllllllllIlIlIIlllIlllIlIllIll, lllllllllllIlIlIIlllIlllIlIlllll, lllllllllllIlIlIIlllIlllIlIllllI, lllllllllllIlIlIIlllIlllIlIllIII);
    }
    
    public static void allocateTexture(final int lllllllllllIlIlIIlllIllIlllIIIlI, final int lllllllllllIlIlIIlllIllIlllIIIIl, final int lllllllllllIlIlIIlllIllIlllIIIll) {
        allocateTextureImpl(lllllllllllIlIlIIlllIllIlllIIIlI, 0, lllllllllllIlIlIIlllIllIlllIIIIl, lllllllllllIlIlIIlllIllIlllIIIll);
    }
    
    private static float getColorGamma(final int lllllllllllIlIlIIlllIllllIlIIlIl) {
        return TextureUtil.COLOR_GAMMAS[lllllllllllIlIlIIlllIllllIlIIlIl & 0xFF];
    }
    
    public static void processPixelValues(final int[] lllllllllllIlIlIIlllIllIIIlIIIII, final int lllllllllllIlIlIIlllIllIIIIllIIl, final int lllllllllllIlIlIIlllIllIIIIllIII) {
        final int[] lllllllllllIlIlIIlllIllIIIIlllIl = new int[lllllllllllIlIlIIlllIllIIIIllIIl];
        for (int lllllllllllIlIlIIlllIllIIIIlllII = lllllllllllIlIlIIlllIllIIIIllIII / 2, lllllllllllIlIlIIlllIllIIIIllIll = 0; lllllllllllIlIlIIlllIllIIIIllIll < lllllllllllIlIlIIlllIllIIIIlllII; ++lllllllllllIlIlIIlllIllIIIIllIll) {
            System.arraycopy(lllllllllllIlIlIIlllIllIIIlIIIII, lllllllllllIlIlIIlllIllIIIIllIll * lllllllllllIlIlIIlllIllIIIIllIIl, lllllllllllIlIlIIlllIllIIIIlllIl, 0, lllllllllllIlIlIIlllIllIIIIllIIl);
            System.arraycopy(lllllllllllIlIlIIlllIllIIIlIIIII, (lllllllllllIlIlIIlllIllIIIIllIII - 1 - lllllllllllIlIlIIlllIllIIIIllIll) * lllllllllllIlIlIIlllIllIIIIllIIl, lllllllllllIlIlIIlllIllIIIlIIIII, lllllllllllIlIlIIlllIllIIIIllIll * lllllllllllIlIlIIlllIllIIIIllIIl, lllllllllllIlIlIIlllIllIIIIllIIl);
            System.arraycopy(lllllllllllIlIlIIlllIllIIIIlllIl, 0, lllllllllllIlIlIIlllIllIIIlIIIII, (lllllllllllIlIlIIlllIllIIIIllIII - 1 - lllllllllllIlIlIIlllIllIIIIllIll) * lllllllllllIlIlIIlllIllIIIIllIIl, lllllllllllIlIlIIlllIllIIIIllIIl);
        }
    }
    
    static void bindTexture(final int lllllllllllIlIlIIlllIllIIlllIIIl) {
        GlStateManager.bindTexture(lllllllllllIlIlIIlllIllIIlllIIIl);
    }
    
    public static void uploadTextureMipmap(final int[][] lllllllllllIlIlIIlllIlllIIlIIlll, final int lllllllllllIlIlIIlllIlllIIlIllll, final int lllllllllllIlIlIIlllIlllIIlIIlIl, final int lllllllllllIlIlIIlllIlllIIlIllIl, final int lllllllllllIlIlIIlllIlllIIlIIIll, final boolean lllllllllllIlIlIIlllIlllIIlIlIll, final boolean lllllllllllIlIlIIlllIlllIIlIIIIl) {
        for (int lllllllllllIlIlIIlllIlllIIlIlIIl = 0; lllllllllllIlIlIIlllIlllIIlIlIIl < lllllllllllIlIlIIlllIlllIIlIIlll.length; ++lllllllllllIlIlIIlllIlllIIlIlIIl) {
            final int[] lllllllllllIlIlIIlllIlllIIlIlIII = lllllllllllIlIlIIlllIlllIIlIIlll[lllllllllllIlIlIIlllIlllIIlIlIIl];
            uploadTextureSub(lllllllllllIlIlIIlllIlllIIlIlIIl, lllllllllllIlIlIIlllIlllIIlIlIII, lllllllllllIlIlIIlllIlllIIlIllll >> lllllllllllIlIlIIlllIlllIIlIlIIl, lllllllllllIlIlIIlllIlllIIlIIlIl >> lllllllllllIlIlIIlllIlllIIlIlIIl, lllllllllllIlIlIIlllIlllIIlIllIl >> lllllllllllIlIlIIlllIlllIIlIlIIl, lllllllllllIlIlIIlllIlllIIlIIIll >> lllllllllllIlIlIIlllIlllIIlIlIIl, lllllllllllIlIlIIlllIlllIIlIlIll, lllllllllllIlIlIIlllIlllIIlIIIIl, lllllllllllIlIlIIlllIlllIIlIIlll.length > 1);
        }
    }
    
    private static void uploadTextureImageSubImpl(final BufferedImage lllllllllllIlIlIIlllIllIlIlIlllI, final int lllllllllllIlIlIIlllIllIlIlIIIII, final int lllllllllllIlIlIIlllIllIlIlIllII, final boolean lllllllllllIlIlIIlllIllIlIIllllI, final boolean lllllllllllIlIlIIlllIllIlIlIlIlI) {
        final int lllllllllllIlIlIIlllIllIlIlIlIIl = lllllllllllIlIlIIlllIllIlIlIlllI.getWidth();
        final int lllllllllllIlIlIIlllIllIlIlIlIII = lllllllllllIlIlIIlllIllIlIlIlllI.getHeight();
        final int lllllllllllIlIlIIlllIllIlIlIIlll = 4194304 / lllllllllllIlIlIIlllIllIlIlIlIIl;
        final int[] lllllllllllIlIlIIlllIllIlIlIIllI = new int[lllllllllllIlIlIIlllIllIlIlIIlll * lllllllllllIlIlIIlllIllIlIlIlIIl];
        setTextureBlurred(lllllllllllIlIlIIlllIllIlIIllllI);
        setTextureClamped(lllllllllllIlIlIIlllIllIlIlIlIlI);
        for (int lllllllllllIlIlIIlllIllIlIlIIlIl = 0; lllllllllllIlIlIIlllIllIlIlIIlIl < lllllllllllIlIlIIlllIllIlIlIlIIl * lllllllllllIlIlIIlllIllIlIlIlIII; lllllllllllIlIlIIlllIllIlIlIIlIl += lllllllllllIlIlIIlllIllIlIlIlIIl * lllllllllllIlIlIIlllIllIlIlIIlll) {
            final int lllllllllllIlIlIIlllIllIlIlIIlII = lllllllllllIlIlIIlllIllIlIlIIlIl / lllllllllllIlIlIIlllIllIlIlIlIIl;
            final int lllllllllllIlIlIIlllIllIlIlIIIll = Math.min(lllllllllllIlIlIIlllIllIlIlIIlll, lllllllllllIlIlIIlllIllIlIlIlIII - lllllllllllIlIlIIlllIllIlIlIIlII);
            final int lllllllllllIlIlIIlllIllIlIlIIIlI = lllllllllllIlIlIIlllIllIlIlIlIIl * lllllllllllIlIlIIlllIllIlIlIIIll;
            lllllllllllIlIlIIlllIllIlIlIlllI.getRGB(0, lllllllllllIlIlIIlllIllIlIlIIlII, lllllllllllIlIlIIlllIllIlIlIlIIl, lllllllllllIlIlIIlllIllIlIlIIIll, lllllllllllIlIlIIlllIllIlIlIIllI, 0, lllllllllllIlIlIIlllIllIlIlIlIIl);
            copyToBuffer(lllllllllllIlIlIIlllIllIlIlIIllI, lllllllllllIlIlIIlllIllIlIlIIIlI);
            GlStateManager.glTexSubImage2D(3553, 0, lllllllllllIlIlIIlllIllIlIlIIIII, lllllllllllIlIlIIlllIllIlIlIllII + lllllllllllIlIlIIlllIllIlIlIIlII, lllllllllllIlIlIIlllIllIlIlIlIIl, lllllllllllIlIlIIlllIllIlIlIIIll, 32993, 33639, TextureUtil.DATA_BUFFER);
        }
    }
    
    public static int uploadTextureImageSub(final int lllllllllllIlIlIIlllIllIllIIIlll, final BufferedImage lllllllllllIlIlIIlllIllIllIIIllI, final int lllllllllllIlIlIIlllIllIlIllllll, final int lllllllllllIlIlIIlllIllIlIlllllI, final boolean lllllllllllIlIlIIlllIllIlIllllIl, final boolean lllllllllllIlIlIIlllIllIlIllllII) {
        bindTexture(lllllllllllIlIlIIlllIllIllIIIlll);
        uploadTextureImageSubImpl(lllllllllllIlIlIIlllIllIllIIIllI, lllllllllllIlIlIIlllIllIlIllllll, lllllllllllIlIlIIlllIllIlIlllllI, lllllllllllIlIlIIlllIllIlIllllIl, lllllllllllIlIlIIlllIllIlIllllII);
        return lllllllllllIlIlIIlllIllIllIIIlll;
    }
    
    public static BufferedImage readBufferedImage(final InputStream lllllllllllIlIlIIlllIllIIlIIlIlI) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnonnull       6
        //     4: aconst_null    
        //     5: areturn        
        //     6: aload_0         /* lllllllllllIlIlIIlllIllIIlIIllIl */
        //     7: invokestatic    javax/imageio/ImageIO.read:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    10: astore_1        /* lllllllllllIlIlIIlllIllIIlIIllII */
        //    11: goto            21
        //    14: astore_2        /* lllllllllllIlIlIIlllIllIIlIIlIII */
        //    15: aload_0         /* lllllllllllIlIlIIlllIllIIlIIllIl */
        //    16: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    19: aload_2         /* lllllllllllIlIlIIlllIllIIlIIlIII */
        //    20: athrow         
        //    21: aload_0         /* lllllllllllIlIlIIlllIllIIlIIllIl */
        //    22: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    25: aload_1         /* lllllllllllIlIlIIlllIllIIlIIlIll */
        //    26: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 03 06 47 07 01 91 FC 00 06 07 00 74
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  6      14     14     21     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static int[][] generateMipmapData(final int lllllllllllIlIlIIlllIlllIlllIIlI, final int lllllllllllIlIlIIlllIllllIIIIIII, final int[][] lllllllllllIlIlIIlllIlllIlllllll) {
        final int[][] lllllllllllIlIlIIlllIlllIllllllI = new int[lllllllllllIlIlIIlllIlllIlllIIlI + 1][];
        lllllllllllIlIlIIlllIlllIllllllI[0] = lllllllllllIlIlIIlllIlllIlllllll[0];
        if (lllllllllllIlIlIIlllIlllIlllIIlI > 0) {
            boolean lllllllllllIlIlIIlllIlllIlllllIl = false;
            for (int lllllllllllIlIlIIlllIlllIlllllII = 0; lllllllllllIlIlIIlllIlllIlllllII < lllllllllllIlIlIIlllIlllIlllllll.length; ++lllllllllllIlIlIIlllIlllIlllllII) {
                if (lllllllllllIlIlIIlllIlllIlllllll[0][lllllllllllIlIlIIlllIlllIlllllII] >> 24 == 0) {
                    lllllllllllIlIlIIlllIlllIlllllIl = true;
                    break;
                }
            }
            for (int lllllllllllIlIlIIlllIlllIllllIll = 1; lllllllllllIlIlIIlllIlllIllllIll <= lllllllllllIlIlIIlllIlllIlllIIlI; ++lllllllllllIlIlIIlllIlllIllllIll) {
                if (lllllllllllIlIlIIlllIlllIlllllll[lllllllllllIlIlIIlllIlllIllllIll] != null) {
                    lllllllllllIlIlIIlllIlllIllllllI[lllllllllllIlIlIIlllIlllIllllIll] = lllllllllllIlIlIIlllIlllIlllllll[lllllllllllIlIlIIlllIlllIllllIll];
                }
                else {
                    final int[] lllllllllllIlIlIIlllIlllIllllIlI = lllllllllllIlIlIIlllIlllIllllllI[lllllllllllIlIlIIlllIlllIllllIll - 1];
                    final int[] lllllllllllIlIlIIlllIlllIllllIIl = new int[lllllllllllIlIlIIlllIlllIllllIlI.length >> 2];
                    final int lllllllllllIlIlIIlllIlllIllllIII = lllllllllllIlIlIIlllIllllIIIIIII >> lllllllllllIlIlIIlllIlllIllllIll;
                    final int lllllllllllIlIlIIlllIlllIlllIlll = lllllllllllIlIlIIlllIlllIllllIIl.length / lllllllllllIlIlIIlllIlllIllllIII;
                    final int lllllllllllIlIlIIlllIlllIlllIllI = lllllllllllIlIlIIlllIlllIllllIII << 1;
                    for (int lllllllllllIlIlIIlllIlllIlllIlIl = 0; lllllllllllIlIlIIlllIlllIlllIlIl < lllllllllllIlIlIIlllIlllIllllIII; ++lllllllllllIlIlIIlllIlllIlllIlIl) {
                        for (int lllllllllllIlIlIIlllIlllIlllIlII = 0; lllllllllllIlIlIIlllIlllIlllIlII < lllllllllllIlIlIIlllIlllIlllIlll; ++lllllllllllIlIlIIlllIlllIlllIlII) {
                            final int lllllllllllIlIlIIlllIlllIlllIIll = 2 * (lllllllllllIlIlIIlllIlllIlllIlIl + lllllllllllIlIlIIlllIlllIlllIlII * lllllllllllIlIlIIlllIlllIlllIllI);
                            lllllllllllIlIlIIlllIlllIllllIIl[lllllllllllIlIlIIlllIlllIlllIlIl + lllllllllllIlIlIIlllIlllIlllIlII * lllllllllllIlIlIIlllIlllIllllIII] = blendColors(lllllllllllIlIlIIlllIlllIllllIlI[lllllllllllIlIlIIlllIlllIlllIIll + 0], lllllllllllIlIlIIlllIlllIllllIlI[lllllllllllIlIlIIlllIlllIlllIIll + 1], lllllllllllIlIlIIlllIlllIllllIlI[lllllllllllIlIlIIlllIlllIlllIIll + 0 + lllllllllllIlIlIIlllIlllIlllIllI], lllllllllllIlIlIIlllIlllIllllIlI[lllllllllllIlIlIIlllIlllIlllIIll + 1 + lllllllllllIlIlIIlllIlllIlllIllI], lllllllllllIlIlIIlllIlllIlllllIl);
                        }
                    }
                    lllllllllllIlIlIIlllIlllIllllllI[lllllllllllIlIlIIlllIlllIllllIll] = lllllllllllIlIlIIlllIlllIllllIIl;
                }
            }
        }
        return lllllllllllIlIlIIlllIlllIllllllI;
    }
}
