// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import net.minecraft.util.ResourceLocation;

public class GuiWinGame extends GuiScreen
{
    private /* synthetic */ float time;
    private static final /* synthetic */ ResourceLocation VIGNETTE_TEXTURE;
    private /* synthetic */ float scrollSpeed;
    private /* synthetic */ List<String> lines;
    private final /* synthetic */ boolean field_193980_h;
    private static final /* synthetic */ ResourceLocation MINECRAFT_LOGO;
    private /* synthetic */ int totalScrollLength;
    private final /* synthetic */ Runnable field_193981_i;
    private static final /* synthetic */ ResourceLocation field_194401_g;
    
    public GuiWinGame(final boolean lllllllllllIIlllIllIIllIIlIlIIll, final Runnable lllllllllllIIlllIllIIllIIlIIllll) {
        this.scrollSpeed = 0.5f;
        this.field_193980_h = lllllllllllIIlllIllIIllIIlIlIIll;
        this.field_193981_i = lllllllllllIIlllIllIIllIIlIIllll;
        if (!lllllllllllIIlllIllIIllIIlIlIIll) {
            this.scrollSpeed = 0.75f;
        }
    }
    
    @Override
    public void updateScreen() {
        this.mc.getMusicTicker().update();
        this.mc.getSoundHandler().update();
        final float lllllllllllIIlllIllIIllIIlIIlIll = (this.totalScrollLength + this.height + this.height + 24) / this.scrollSpeed;
        if (this.time > lllllllllllIIlllIllIIllIIlIIlIll) {
            this.sendRespawnPacket();
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }
    
    @Override
    public void initGui() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //     4: ifnonnull       505
        //     7: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //     8: invokestatic    com/google/common/collect/Lists.newArrayList:()Ljava/util/ArrayList;
        //    11: putfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //    14: aconst_null    
        //    15: astore_1        /* lllllllllllIIlllIllIIllIIIIllllI */
        //    16: new             Ljava/lang/StringBuilder;
        //    19: dup            
        //    20: invokespecial   java/lang/StringBuilder.<init>:()V
        //    23: getstatic       net/minecraft/util/text/TextFormatting.WHITE:Lnet/minecraft/util/text/TextFormatting;
        //    26: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    29: getstatic       net/minecraft/util/text/TextFormatting.OBFUSCATED:Lnet/minecraft/util/text/TextFormatting;
        //    32: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    35: getstatic       net/minecraft/util/text/TextFormatting.GREEN:Lnet/minecraft/util/text/TextFormatting;
        //    38: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    41: getstatic       net/minecraft/util/text/TextFormatting.AQUA:Lnet/minecraft/util/text/TextFormatting;
        //    44: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    47: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    50: astore_2        /* lllllllllllIIlllIllIIllIIIlIllll */
        //    51: sipush          274
        //    54: istore_3        /* lllllllllllIIlllIllIIllIIIIlllII */
        //    55: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //    56: getfield        net/minecraft/client/gui/GuiWinGame.field_193980_h:Z
        //    59: ifeq            319
        //    62: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //    63: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //    66: invokevirtual   net/minecraft/client/Minecraft.getResourceManager:()Lnet/minecraft/client/resources/IResourceManager;
        //    69: new             Lnet/minecraft/util/ResourceLocation;
        //    72: dup            
        //    73: ldc             "texts/end.txt"
        //    75: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
        //    78: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //    83: astore_1        /* lllllllllllIIlllIllIIllIIIllIIII */
        //    84: aload_1         /* lllllllllllIIlllIllIIllIIIllIIII */
        //    85: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    90: astore          lllllllllllIIlllIllIIllIIIlIllIl
        //    92: new             Ljava/io/BufferedReader;
        //    95: dup            
        //    96: new             Ljava/io/InputStreamReader;
        //    99: dup            
        //   100: aload           lllllllllllIIlllIllIIllIIIlIllIl
        //   102: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //   105: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //   108: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   111: astore          lllllllllllIIlllIllIIllIIIlIllII
        //   113: new             Ljava/util/Random;
        //   116: dup            
        //   117: ldc2_w          8124371
        //   120: invokespecial   java/util/Random.<init>:(J)V
        //   123: astore          lllllllllllIIlllIllIIllIIIlIlIll
        //   125: goto            275
        //   128: aload           lllllllllllIIlllIllIIllIIIlIlIlI
        //   130: ldc             "PLAYERNAME"
        //   132: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   133: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //   136: invokevirtual   net/minecraft/client/Minecraft.getSession:()Lnet/minecraft/util/Session;
        //   139: invokevirtual   net/minecraft/util/Session.getUsername:()Ljava/lang/String;
        //   142: invokevirtual   java/lang/String.replaceAll:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   145: astore          lllllllllllIIlllIllIIllIIIlIlIlI
        //   147: goto            233
        //   150: aload           lllllllllllIIlllIllIIllIIIlIlIlI
        //   152: aload_2         /* lllllllllllIIlllIllIIllIIIlIllll */
        //   153: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   156: istore          lllllllllllIIlllIllIIllIIIlIIllI
        //   158: aload           lllllllllllIIlllIllIIllIIIlIlIlI
        //   160: iconst_0       
        //   161: iload           lllllllllllIIlllIllIIllIIIlIIllI
        //   163: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   166: astore          lllllllllllIIlllIllIIllIIIlIlIII
        //   168: aload           lllllllllllIIlllIllIIllIIIlIlIlI
        //   170: iload           lllllllllllIIlllIllIIllIIIlIIllI
        //   172: aload_2         /* lllllllllllIIlllIllIIllIIIlIllll */
        //   173: invokevirtual   java/lang/String.length:()I
        //   176: iadd           
        //   177: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   180: astore          lllllllllllIIlllIllIIllIIIlIIlll
        //   182: new             Ljava/lang/StringBuilder;
        //   185: dup            
        //   186: aload           lllllllllllIIlllIllIIllIIIlIlIII
        //   188: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   191: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   194: getstatic       net/minecraft/util/text/TextFormatting.WHITE:Lnet/minecraft/util/text/TextFormatting;
        //   197: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   200: getstatic       net/minecraft/util/text/TextFormatting.OBFUSCATED:Lnet/minecraft/util/text/TextFormatting;
        //   203: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   206: ldc             "XXXXXXXX"
        //   208: iconst_0       
        //   209: aload           lllllllllllIIlllIllIIllIIIlIlIll
        //   211: iconst_4       
        //   212: invokevirtual   java/util/Random.nextInt:(I)I
        //   215: iconst_3       
        //   216: iadd           
        //   217: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   220: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   223: aload           lllllllllllIIlllIllIIllIIIlIIlll
        //   225: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   228: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   231: astore          lllllllllllIIlllIllIIllIIIlIlIlI
        //   233: aload           lllllllllllIIlllIllIIllIIIlIlIlI
        //   235: aload_2         /* lllllllllllIIlllIllIIllIIIlIllll */
        //   236: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   239: ifne            150
        //   242: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   243: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   246: getstatic       net/minecraft/client/Minecraft.fontRendererObj:Lnet/minecraft/client/gui/FontRenderer;
        //   249: aload           lllllllllllIIlllIllIIllIIIlIlIlI
        //   251: sipush          274
        //   254: invokevirtual   net/minecraft/client/gui/FontRenderer.listFormattedStringToWidth:(Ljava/lang/String;I)Ljava/util/List;
        //   257: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   262: pop            
        //   263: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   264: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   267: ldc             ""
        //   269: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   274: pop            
        //   275: aload           lllllllllllIIlllIllIIllIIIlIllII
        //   277: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   280: dup            
        //   281: astore          lllllllllllIIlllIllIIllIIIlIlIIl
        //   283: ifnonnull       128
        //   286: aload           lllllllllllIIlllIllIIllIIIlIllIl
        //   288: invokevirtual   java/io/InputStream.close:()V
        //   291: iconst_0       
        //   292: istore          lllllllllllIIlllIllIIllIIIlIIlIl
        //   294: goto            312
        //   297: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   298: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   301: ldc             ""
        //   303: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   308: pop            
        //   309: iinc            lllllllllllIIlllIllIIllIIIlIIlIl, 1
        //   312: iload           lllllllllllIIlllIllIIllIIIlIIlIl
        //   314: bipush          8
        //   316: if_icmplt       297
        //   319: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   320: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //   323: invokevirtual   net/minecraft/client/Minecraft.getResourceManager:()Lnet/minecraft/client/resources/IResourceManager;
        //   326: new             Lnet/minecraft/util/ResourceLocation;
        //   329: dup            
        //   330: ldc_w           "texts/credits.txt"
        //   333: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
        //   336: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //   341: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //   346: astore          lllllllllllIIlllIllIIllIIIlIIlII
        //   348: new             Ljava/io/BufferedReader;
        //   351: dup            
        //   352: new             Ljava/io/InputStreamReader;
        //   355: dup            
        //   356: aload           lllllllllllIIlllIllIIllIIIlIIlII
        //   358: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //   361: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //   364: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   367: astore          lllllllllllIIlllIllIIllIIIlIIIll
        //   369: goto            437
        //   372: aload           lllllllllllIIlllIllIIllIIIlIIIlI
        //   374: ldc             "PLAYERNAME"
        //   376: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   377: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //   380: invokevirtual   net/minecraft/client/Minecraft.getSession:()Lnet/minecraft/util/Session;
        //   383: invokevirtual   net/minecraft/util/Session.getUsername:()Ljava/lang/String;
        //   386: invokevirtual   java/lang/String.replaceAll:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   389: astore          lllllllllllIIlllIllIIllIIIlIIIlI
        //   391: aload           lllllllllllIIlllIllIIllIIIlIIIlI
        //   393: ldc_w           "\t"
        //   396: ldc_w           "    "
        //   399: invokevirtual   java/lang/String.replaceAll:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   402: astore          lllllllllllIIlllIllIIllIIIlIIIlI
        //   404: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   405: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   408: getstatic       net/minecraft/client/Minecraft.fontRendererObj:Lnet/minecraft/client/gui/FontRenderer;
        //   411: aload           lllllllllllIIlllIllIIllIIIlIIIlI
        //   413: sipush          274
        //   416: invokevirtual   net/minecraft/client/gui/FontRenderer.listFormattedStringToWidth:(Ljava/lang/String;I)Ljava/util/List;
        //   419: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   424: pop            
        //   425: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   426: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   429: ldc             ""
        //   431: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   436: pop            
        //   437: aload           lllllllllllIIlllIllIIllIIIlIIIll
        //   439: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   442: dup            
        //   443: astore          lllllllllllIIlllIllIIllIIIlIIIIl
        //   445: ifnonnull       372
        //   448: aload           lllllllllllIIlllIllIIllIIIlIIlII
        //   450: invokevirtual   java/io/InputStream.close:()V
        //   453: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   454: aload_0         /* lllllllllllIIlllIllIIllIIIIlllll */
        //   455: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   458: invokeinterface java/util/List.size:()I
        //   463: bipush          12
        //   465: imul           
        //   466: putfield        net/minecraft/client/gui/GuiWinGame.totalScrollLength:I
        //   469: goto            501
        //   472: astore_2        /* lllllllllllIIlllIllIIllIIIlIIIII */
        //   473: getstatic       net/minecraft/client/gui/GuiWinGame.LOGGER:Lorg/apache/logging/log4j/Logger;
        //   476: ldc_w           "Couldn't load credits"
        //   479: aload_2         /* lllllllllllIIlllIllIIllIIIlIIIII */
        //   480: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   485: aload_1         /* lllllllllllIIlllIllIIllIIIllIIII */
        //   486: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   489: goto            505
        //   492: astore          lllllllllllIIlllIllIIllIIIIlIlII
        //   494: aload_1         /* lllllllllllIIlllIllIIllIIIllIIII */
        //   495: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   498: aload           lllllllllllIIlllIllIIllIIIIlIlII
        //   500: athrow         
        //   501: aload_1         /* lllllllllllIIlllIllIIllIIIllIIII */
        //   502: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   505: return         
        //    StackMapTable: 00 0D FF 00 80 00 08 07 00 02 07 00 96 07 00 BE 01 07 00 FE 07 00 9C 07 00 AC 07 00 BE 00 00 15 FB 00 52 FA 00 29 FD 00 15 07 00 BE 01 0E FF 00 06 00 04 07 00 02 07 00 96 07 00 BE 01 00 00 FE 00 34 07 00 FE 07 00 9C 07 00 BE FA 00 40 FF 00 22 00 02 07 00 02 07 00 96 00 01 07 00 61 53 07 01 42 FF 00 08 00 07 07 00 02 07 00 96 07 00 BE 01 07 00 FE 07 00 9C 07 00 BE 00 00 FF 00 03 00 01 07 00 02 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  16     469    472    492    Ljava/lang/Exception;
        //  16     485    492    501    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        LOGGER = LogManager.getLogger();
        MINECRAFT_LOGO = new ResourceLocation("textures/gui/title/minecraft.png");
        field_194401_g = new ResourceLocation("textures/gui/title/edition.png");
        VIGNETTE_TEXTURE = new ResourceLocation("textures/misc/vignette.png");
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIlllIllIIlIllllIIlII, final int lllllllllllIIlllIllIIlIllllIIIll, final float lllllllllllIIlllIllIIlIlllIlIIlI) {
        this.drawWinGameScreen(lllllllllllIIlllIllIIlIllllIIlII, lllllllllllIIlllIllIIlIllllIIIll, lllllllllllIIlllIllIIlIlllIlIIlI);
        final Tessellator lllllllllllIIlllIllIIlIllllIIIIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIlllIllIIlIllllIIIII = lllllllllllIIlllIllIIlIllllIIIIl.getBuffer();
        final int lllllllllllIIlllIllIIlIlllIlllll = 274;
        final int lllllllllllIIlllIllIIlIlllIllllI = this.width / 2 - 137;
        final int lllllllllllIIlllIllIIlIlllIlllIl = this.height + 50;
        this.time += lllllllllllIIlllIllIIlIlllIlIIlI;
        final float lllllllllllIIlllIllIIlIlllIlllII = -this.time * this.scrollSpeed;
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, lllllllllllIIlllIllIIlIlllIlllII, 0.0f);
        this.mc.getTextureManager().bindTexture(GuiWinGame.MINECRAFT_LOGO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableAlpha();
        this.drawTexturedModalRect(lllllllllllIIlllIllIIlIlllIllllI, lllllllllllIIlllIllIIlIlllIlllIl, 0, 0, 155, 44);
        this.drawTexturedModalRect(lllllllllllIIlllIllIIlIlllIllllI + 155, lllllllllllIIlllIllIIlIlllIlllIl, 0, 45, 155, 44);
        this.mc.getTextureManager().bindTexture(GuiWinGame.field_194401_g);
        Gui.drawModalRectWithCustomSizedTexture((float)(lllllllllllIIlllIllIIlIlllIllllI + 88), (float)(lllllllllllIIlllIllIIlIlllIlllIl + 37), 0.0f, 0.0f, 98.0f, 14.0f, 128.0f, 16.0f);
        GlStateManager.disableAlpha();
        int lllllllllllIIlllIllIIlIlllIllIll = lllllllllllIIlllIllIIlIlllIlllIl + 100;
        for (int lllllllllllIIlllIllIIlIlllIllIlI = 0; lllllllllllIIlllIllIIlIlllIllIlI < this.lines.size(); ++lllllllllllIIlllIllIIlIlllIllIlI) {
            if (lllllllllllIIlllIllIIlIlllIllIlI == this.lines.size() - 1) {
                final float lllllllllllIIlllIllIIlIlllIllIIl = lllllllllllIIlllIllIIlIlllIllIll + lllllllllllIIlllIllIIlIlllIlllII - (this.height / 2 - 6);
                if (lllllllllllIIlllIllIIlIlllIllIIl < 0.0f) {
                    GlStateManager.translate(0.0f, -lllllllllllIIlllIllIIlIlllIllIIl, 0.0f);
                }
            }
            if (lllllllllllIIlllIllIIlIlllIllIll + lllllllllllIIlllIllIIlIlllIlllII + 12.0f + 8.0f > 0.0f && lllllllllllIIlllIllIIlIlllIllIll + lllllllllllIIlllIllIIlIlllIlllII < this.height) {
                final String lllllllllllIIlllIllIIlIlllIllIII = this.lines.get(lllllllllllIIlllIllIIlIlllIllIlI);
                if (lllllllllllIIlllIllIIlIlllIllIII.startsWith("[C]")) {
                    this.fontRendererObj.drawStringWithShadow(lllllllllllIIlllIllIIlIlllIllIII.substring(3), (float)(lllllllllllIIlllIllIIlIlllIllllI + (274 - this.fontRendererObj.getStringWidth(lllllllllllIIlllIllIIlIlllIllIII.substring(3))) / 2), (float)lllllllllllIIlllIllIIlIlllIllIll, 16777215);
                }
                else {
                    this.fontRendererObj.fontRandom.setSeed((long)(lllllllllllIIlllIllIIlIlllIllIlI * 4238972211L + this.time / 4.0f));
                    this.fontRendererObj.drawStringWithShadow(lllllllllllIIlllIllIIlIlllIllIII, (float)lllllllllllIIlllIllIIlIlllIllllI, (float)lllllllllllIIlllIllIIlIlllIllIll, 16777215);
                }
            }
            lllllllllllIIlllIllIIlIlllIllIll += 12;
        }
        GlStateManager.popMatrix();
        this.mc.getTextureManager().bindTexture(GuiWinGame.VIGNETTE_TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);
        final int lllllllllllIIlllIllIIlIlllIlIlll = this.width;
        final int lllllllllllIIlllIllIIlIlllIlIllI = this.height;
        lllllllllllIIlllIllIIlIllllIIIII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        lllllllllllIIlllIllIIlIllllIIIII.pos(0.0, lllllllllllIIlllIllIIlIlllIlIllI, this.zLevel).tex(0.0, 1.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllIIlllIllIIlIllllIIIII.pos(lllllllllllIIlllIllIIlIlllIlIlll, lllllllllllIIlllIllIIlIlllIlIllI, this.zLevel).tex(1.0, 1.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllIIlllIllIIlIllllIIIII.pos(lllllllllllIIlllIllIIlIlllIlIlll, 0.0, this.zLevel).tex(1.0, 0.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllIIlllIllIIlIllllIIIII.pos(0.0, 0.0, this.zLevel).tex(0.0, 0.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllIIlllIllIIlIllllIIIIl.draw();
        GlStateManager.disableBlend();
        super.drawScreen(lllllllllllIIlllIllIIlIllllIIlII, lllllllllllIIlllIllIIlIllllIIIll, lllllllllllIIlllIllIIlIlllIlIIlI);
    }
    
    private void drawWinGameScreen(final int lllllllllllIIlllIllIIllIIIIIlIII, final int lllllllllllIIlllIllIIllIIIIIIlll, final float lllllllllllIIlllIllIIllIIIIIIllI) {
        final Tessellator lllllllllllIIlllIllIIllIIIIIIlIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIlllIllIIllIIIIIIlII = lllllllllllIIlllIllIIllIIIIIIlIl.getBuffer();
        this.mc.getTextureManager().bindTexture(Gui.OPTIONS_BACKGROUND);
        lllllllllllIIlllIllIIllIIIIIIlII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        final int lllllllllllIIlllIllIIllIIIIIIIll = this.width;
        final float lllllllllllIIlllIllIIllIIIIIIIlI = -this.time * 0.5f * this.scrollSpeed;
        final float lllllllllllIIlllIllIIllIIIIIIIIl = this.height - this.time * 0.5f * this.scrollSpeed;
        final float lllllllllllIIlllIllIIllIIIIIIIII = 0.015625f;
        float lllllllllllIIlllIllIIlIlllllllll = this.time * 0.02f;
        final float lllllllllllIIlllIllIIlIllllllllI = (this.totalScrollLength + this.height + this.height + 24) / this.scrollSpeed;
        final float lllllllllllIIlllIllIIlIlllllllIl = (lllllllllllIIlllIllIIlIllllllllI - 20.0f - this.time) * 0.005f;
        if (lllllllllllIIlllIllIIlIlllllllIl < lllllllllllIIlllIllIIlIlllllllll) {
            lllllllllllIIlllIllIIlIlllllllll = lllllllllllIIlllIllIIlIlllllllIl;
        }
        if (lllllllllllIIlllIllIIlIlllllllll > 1.0f) {
            lllllllllllIIlllIllIIlIlllllllll = 1.0f;
        }
        lllllllllllIIlllIllIIlIlllllllll *= lllllllllllIIlllIllIIlIlllllllll;
        lllllllllllIIlllIllIIlIlllllllll = lllllllllllIIlllIllIIlIlllllllll * 96.0f / 255.0f;
        lllllllllllIIlllIllIIllIIIIIIlII.pos(0.0, this.height, this.zLevel).tex(0.0, lllllllllllIIlllIllIIllIIIIIIIlI * 0.015625f).color(lllllllllllIIlllIllIIlIlllllllll, lllllllllllIIlllIllIIlIlllllllll, lllllllllllIIlllIllIIlIlllllllll, 1.0f).endVertex();
        lllllllllllIIlllIllIIllIIIIIIlII.pos(lllllllllllIIlllIllIIllIIIIIIIll, this.height, this.zLevel).tex(lllllllllllIIlllIllIIllIIIIIIIll * 0.015625f, lllllllllllIIlllIllIIllIIIIIIIlI * 0.015625f).color(lllllllllllIIlllIllIIlIlllllllll, lllllllllllIIlllIllIIlIlllllllll, lllllllllllIIlllIllIIlIlllllllll, 1.0f).endVertex();
        lllllllllllIIlllIllIIllIIIIIIlII.pos(lllllllllllIIlllIllIIllIIIIIIIll, 0.0, this.zLevel).tex(lllllllllllIIlllIllIIllIIIIIIIll * 0.015625f, lllllllllllIIlllIllIIllIIIIIIIIl * 0.015625f).color(lllllllllllIIlllIllIIlIlllllllll, lllllllllllIIlllIllIIlIlllllllll, lllllllllllIIlllIllIIlIlllllllll, 1.0f).endVertex();
        lllllllllllIIlllIllIIllIIIIIIlII.pos(0.0, 0.0, this.zLevel).tex(0.0, lllllllllllIIlllIllIIllIIIIIIIIl * 0.015625f).color(lllllllllllIIlllIllIIlIlllllllll, lllllllllllIIlllIllIIlIlllllllll, lllllllllllIIlllIllIIlIlllllllll, 1.0f).endVertex();
        lllllllllllIIlllIllIIllIIIIIIlIl.draw();
    }
    
    private void sendRespawnPacket() {
        this.field_193981_i.run();
        this.mc.displayGuiScreen(null);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIlllIllIIllIIlIIIlIl, final int lllllllllllIIlllIllIIllIIlIIIIlI) throws IOException {
        if (lllllllllllIIlllIllIIllIIlIIIIlI == 1) {
            this.sendRespawnPacket();
        }
    }
}
