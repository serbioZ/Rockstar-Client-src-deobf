// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.util.List;
import java.net.UnknownHostException;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.renderer.GlStateManager;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import java.util.concurrent.ThreadPoolExecutor;
import net.minecraft.client.multiplayer.ServerData;

public class ServerListEntryNormal implements GuiListExtended.IGuiListEntry
{
    private final /* synthetic */ ServerData server;
    private static final /* synthetic */ ThreadPoolExecutor EXECUTOR;
    private /* synthetic */ String lastIconB64;
    private static final /* synthetic */ ResourceLocation SERVER_SELECTION_BUTTONS;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ DynamicTexture icon;
    private /* synthetic */ long lastClickTime;
    private final /* synthetic */ GuiMultiplayer owner;
    private final /* synthetic */ ResourceLocation serverIcon;
    private static final /* synthetic */ ResourceLocation UNKNOWN_SERVER;
    
    static {
        LOGGER = LogManager.getLogger();
        EXECUTOR = new ScheduledThreadPoolExecutor(5, new ThreadFactoryBuilder().setNameFormat("Server Pinger #%d").setDaemon(true).build());
        UNKNOWN_SERVER = new ResourceLocation("textures/misc/unknown_server.png");
        SERVER_SELECTION_BUTTONS = new ResourceLocation("textures/gui/server_selection.png");
    }
    
    protected ServerListEntryNormal(final GuiMultiplayer lllllllllllIllllllIIIIlIllIIlIIl, final ServerData lllllllllllIllllllIIIIlIllIIlIII) {
        this.owner = lllllllllllIllllllIIIIlIllIIlIIl;
        this.server = lllllllllllIllllllIIIIlIllIIlIII;
        this.mc = Minecraft.getMinecraft();
        this.serverIcon = new ResourceLocation("servers/" + lllllllllllIllllllIIIIlIllIIlIII.serverIP + "/icon");
        this.icon = (DynamicTexture)this.mc.getTextureManager().getTexture(this.serverIcon);
    }
    
    protected void drawTextureAt(final int lllllllllllIllllllIIIIlIIlllIIll, final int lllllllllllIllllllIIIIlIIlllIIlI, final ResourceLocation lllllllllllIllllllIIIIlIIllIllIl) {
        this.mc.getTextureManager().bindTexture(lllllllllllIllllllIIIIlIIllIllIl);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIllllllIIIIlIIlllIIll, (float)lllllllllllIllllllIIIIlIIlllIIlI, 0.0f, 0.0f, 32.0f, 32.0f, 32.0f, 32.0f);
        GlStateManager.disableBlend();
    }
    
    @Override
    public void func_192634_a(final int lllllllllllIllllllIIIIlIlIIIllIl, final int lllllllllllIllllllIIIIlIlIIIllII, final int lllllllllllIllllllIIIIlIlIlIlllI, final int lllllllllllIllllllIIIIlIlIIIlIlI, final int lllllllllllIllllllIIIIlIlIlIllII, final int lllllllllllIllllllIIIIlIlIIIlIIl, final int lllllllllllIllllllIIIIlIlIlIlIlI, final boolean lllllllllllIllllllIIIIlIlIlIlIIl, final float lllllllllllIllllllIIIIlIlIlIlIII) {
        if (!this.server.pinged) {
            this.server.pinged = true;
            this.server.pingToServer = -2L;
            this.server.serverMOTD = "";
            this.server.populationInfo = "";
            ServerListEntryNormal.EXECUTOR.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        ServerListEntryNormal.this.owner.getOldServerPinger().ping(ServerListEntryNormal.this.server);
                    }
                    catch (UnknownHostException lllllllllllIIIIIllIlIllIlIIIIlII) {
                        ServerListEntryNormal.this.server.pingToServer = -1L;
                        ServerListEntryNormal.this.server.serverMOTD = TextFormatting.DARK_RED + I18n.format("multiplayer.status.cannot_resolve", new Object[0]);
                    }
                    catch (Exception lllllllllllIIIIIllIlIllIlIIIIIll) {
                        ServerListEntryNormal.this.server.pingToServer = -1L;
                        ServerListEntryNormal.this.server.serverMOTD = TextFormatting.DARK_RED + I18n.format("multiplayer.status.cannot_connect", new Object[0]);
                    }
                }
            });
        }
        final boolean lllllllllllIllllllIIIIlIlIlIIlll = this.server.version > 340;
        final boolean lllllllllllIllllllIIIIlIlIlIIllI = this.server.version < 340;
        final boolean lllllllllllIllllllIIIIlIlIlIIlIl = lllllllllllIllllllIIIIlIlIlIIlll || lllllllllllIllllllIIIIlIlIlIIllI;
        Minecraft.fontRendererObj.drawString(this.server.serverName, (float)(lllllllllllIllllllIIIIlIlIIIllII + 32 + 3), (float)(lllllllllllIllllllIIIIlIlIlIlllI + 1), 16777215);
        final List<String> lllllllllllIllllllIIIIlIlIlIIlII = Minecraft.fontRendererObj.listFormattedStringToWidth(this.server.serverMOTD, lllllllllllIllllllIIIIlIlIIIlIlI - 32 - 2);
        for (int lllllllllllIllllllIIIIlIlIlIIIll = 0; lllllllllllIllllllIIIIlIlIlIIIll < Math.min(lllllllllllIllllllIIIIlIlIlIIlII.size(), 2); ++lllllllllllIllllllIIIIlIlIlIIIll) {
            Minecraft.fontRendererObj.drawString(lllllllllllIllllllIIIIlIlIlIIlII.get(lllllllllllIllllllIIIIlIlIlIIIll), (float)(lllllllllllIllllllIIIIlIlIIIllII + 32 + 3), (float)(lllllllllllIllllllIIIIlIlIlIlllI + 12 + Minecraft.fontRendererObj.FONT_HEIGHT * lllllllllllIllllllIIIIlIlIlIIIll), 8421504);
        }
        final String lllllllllllIllllllIIIIlIlIlIIIlI = lllllllllllIllllllIIIIlIlIlIIlIl ? (TextFormatting.DARK_RED + this.server.gameVersion) : this.server.populationInfo;
        final int lllllllllllIllllllIIIIlIlIlIIIIl = Minecraft.fontRendererObj.getStringWidth(lllllllllllIllllllIIIIlIlIlIIIlI);
        Minecraft.fontRendererObj.drawString(lllllllllllIllllllIIIIlIlIlIIIlI, (float)(lllllllllllIllllllIIIIlIlIIIllII + lllllllllllIllllllIIIIlIlIIIlIlI - lllllllllllIllllllIIIIlIlIlIIIIl - 15 - 2), (float)(lllllllllllIllllllIIIIlIlIlIlllI + 1), 8421504);
        int lllllllllllIllllllIIIIlIlIlIIIII = 0;
        String lllllllllllIllllllIIIIlIlIIlllll = null;
        int lllllllllllIllllllIIIIlIlIIlIlll = 0;
        String lllllllllllIllllllIIIIlIlIIlIIll = null;
        if (lllllllllllIllllllIIIIlIlIlIIlIl) {
            final int lllllllllllIllllllIIIIlIlIIllllI = 5;
            final String lllllllllllIllllllIIIIlIlIIlIllI = I18n.format(lllllllllllIllllllIIIIlIlIlIIlll ? "multiplayer.status.client_out_of_date" : "multiplayer.status.server_out_of_date", new Object[0]);
            lllllllllllIllllllIIIIlIlIIlllll = this.server.playerList;
        }
        else if (this.server.pinged && this.server.pingToServer != -2L) {
            if (this.server.pingToServer < 0L) {
                final int lllllllllllIllllllIIIIlIlIIlllIl = 5;
            }
            else if (this.server.pingToServer < 150L) {
                final int lllllllllllIllllllIIIIlIlIIlllII = 0;
            }
            else if (this.server.pingToServer < 300L) {
                final int lllllllllllIllllllIIIIlIlIIllIll = 1;
            }
            else if (this.server.pingToServer < 600L) {
                final int lllllllllllIllllllIIIIlIlIIllIlI = 2;
            }
            else if (this.server.pingToServer < 1000L) {
                final int lllllllllllIllllllIIIIlIlIIllIIl = 3;
            }
            else {
                final int lllllllllllIllllllIIIIlIlIIllIII = 4;
            }
            if (this.server.pingToServer < 0L) {
                final String lllllllllllIllllllIIIIlIlIIlIlIl = I18n.format("multiplayer.status.no_connection", new Object[0]);
            }
            else {
                final String lllllllllllIllllllIIIIlIlIIlIlII = String.valueOf(this.server.pingToServer) + "ms";
                lllllllllllIllllllIIIIlIlIIlllll = this.server.playerList;
            }
        }
        else {
            lllllllllllIllllllIIIIlIlIlIIIII = 1;
            lllllllllllIllllllIIIIlIlIIlIlll = (int)(Minecraft.getSystemTime() / 100L + lllllllllllIllllllIIIIlIlIIIllIl * 2 & 0x7L);
            if (lllllllllllIllllllIIIIlIlIIlIlll > 4) {
                lllllllllllIllllllIIIIlIlIIlIlll = 8 - lllllllllllIllllllIIIIlIlIIlIlll;
            }
            lllllllllllIllllllIIIIlIlIIlIIll = I18n.format("multiplayer.status.pinging", new Object[0]);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(Gui.ICONS);
        Gui.drawModalRectWithCustomSizedTexture((float)(lllllllllllIllllllIIIIlIlIIIllII + lllllllllllIllllllIIIIlIlIIIlIlI - 15), (float)lllllllllllIllllllIIIIlIlIlIlllI, (float)(lllllllllllIllllllIIIIlIlIlIIIII * 10), (float)(176 + lllllllllllIllllllIIIIlIlIIlIlll * 8), 10.0f, 8.0f, 256.0f, 256.0f);
        if (this.server.getBase64EncodedIconData() != null && !this.server.getBase64EncodedIconData().equals(this.lastIconB64)) {
            this.lastIconB64 = this.server.getBase64EncodedIconData();
            this.prepareServerIcon();
            this.owner.getServerList().saveServerList();
        }
        if (this.icon != null) {
            this.drawTextureAt(lllllllllllIllllllIIIIlIlIIIllII, lllllllllllIllllllIIIIlIlIlIlllI, this.serverIcon);
        }
        else {
            this.drawTextureAt(lllllllllllIllllllIIIIlIlIIIllII, lllllllllllIllllllIIIIlIlIlIlllI, ServerListEntryNormal.UNKNOWN_SERVER);
        }
        final int lllllllllllIllllllIIIIlIlIIlIIlI = lllllllllllIllllllIIIIlIlIIIlIIl - lllllllllllIllllllIIIIlIlIIIllII;
        final int lllllllllllIllllllIIIIlIlIIlIIIl = lllllllllllIllllllIIIIlIlIlIlIlI - lllllllllllIllllllIIIIlIlIlIlllI;
        if (lllllllllllIllllllIIIIlIlIIlIIlI >= lllllllllllIllllllIIIIlIlIIIlIlI - 15 && lllllllllllIllllllIIIIlIlIIlIIlI <= lllllllllllIllllllIIIIlIlIIIlIlI - 5 && lllllllllllIllllllIIIIlIlIIlIIIl >= 0 && lllllllllllIllllllIIIIlIlIIlIIIl <= 8) {
            this.owner.setHoveringText(lllllllllllIllllllIIIIlIlIIlIIll);
        }
        else if (lllllllllllIllllllIIIIlIlIIlIIlI >= lllllllllllIllllllIIIIlIlIIIlIlI - lllllllllllIllllllIIIIlIlIlIIIIl - 15 - 2 && lllllllllllIllllllIIIIlIlIIlIIlI <= lllllllllllIllllllIIIIlIlIIIlIlI - 15 - 2 && lllllllllllIllllllIIIIlIlIIlIIIl >= 0 && lllllllllllIllllllIIIIlIlIIlIIIl <= 8) {
            this.owner.setHoveringText(lllllllllllIllllllIIIIlIlIIlllll);
        }
        if (this.mc.gameSettings.touchscreen || lllllllllllIllllllIIIIlIlIlIlIIl) {
            this.mc.getTextureManager().bindTexture(ServerListEntryNormal.SERVER_SELECTION_BUTTONS);
            Gui.drawRect(lllllllllllIllllllIIIIlIlIIIllII, lllllllllllIllllllIIIIlIlIlIlllI, lllllllllllIllllllIIIIlIlIIIllII + 32, lllllllllllIllllllIIIIlIlIlIlllI + 32, -1601138544);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int lllllllllllIllllllIIIIlIlIIlIIII = lllllllllllIllllllIIIIlIlIIIlIIl - lllllllllllIllllllIIIIlIlIIIllII;
            final int lllllllllllIllllllIIIIlIlIIIllll = lllllllllllIllllllIIIIlIlIlIlIlI - lllllllllllIllllllIIIIlIlIlIlllI;
            if (this.canJoin()) {
                if (lllllllllllIllllllIIIIlIlIIlIIII < 32 && lllllllllllIllllllIIIIlIlIIlIIII > 16) {
                    Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIllllllIIIIlIlIIIllII, (float)lllllllllllIllllllIIIIlIlIlIlllI, 0.0f, 32.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIllllllIIIIlIlIIIllII, (float)lllllllllllIllllllIIIIlIlIlIlllI, 0.0f, 0.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                }
            }
            if (this.owner.canMoveUp(this, lllllllllllIllllllIIIIlIlIIIllIl)) {
                if (lllllllllllIllllllIIIIlIlIIlIIII < 16 && lllllllllllIllllllIIIIlIlIIIllll < 16) {
                    Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIllllllIIIIlIlIIIllII, (float)lllllllllllIllllllIIIIlIlIlIlllI, 96.0f, 32.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIllllllIIIIlIlIIIllII, (float)lllllllllllIllllllIIIIlIlIlIlllI, 96.0f, 0.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                }
            }
            if (this.owner.canMoveDown(this, lllllllllllIllllllIIIIlIlIIIllIl)) {
                if (lllllllllllIllllllIIIIlIlIIlIIII < 16 && lllllllllllIllllllIIIIlIlIIIllll > 16) {
                    Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIllllllIIIIlIlIIIllII, (float)lllllllllllIllllllIIIIlIlIlIlllI, 64.0f, 32.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIllllllIIIIlIlIIIllII, (float)lllllllllllIllllllIIIIlIlIlIlllI, 64.0f, 0.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                }
            }
        }
    }
    
    @Override
    public void func_192633_a(final int lllllllllllIllllllIIIIlIIlIIlIIl, final int lllllllllllIllllllIIIIlIIlIIlIII, final int lllllllllllIllllllIIIIlIIlIIIlll, final float lllllllllllIllllllIIIIlIIlIIIllI) {
    }
    
    private void prepareServerIcon() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //     4: invokevirtual   net/minecraft/client/multiplayer/ServerData.getBase64EncodedIconData:()Ljava/lang/String;
        //     7: ifnonnull       32
        //    10: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //    11: getfield        net/minecraft/client/gui/ServerListEntryNormal.mc:Lnet/minecraft/client/Minecraft;
        //    14: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //    17: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //    18: getfield        net/minecraft/client/gui/ServerListEntryNormal.serverIcon:Lnet/minecraft/util/ResourceLocation;
        //    21: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.deleteTexture:(Lnet/minecraft/util/ResourceLocation;)V
        //    24: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //    25: aconst_null    
        //    26: putfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //    29: goto            283
        //    32: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //    33: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //    36: invokevirtual   net/minecraft/client/multiplayer/ServerData.getBase64EncodedIconData:()Ljava/lang/String;
        //    39: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    42: invokestatic    io/netty/buffer/Unpooled.copiedBuffer:(Ljava/lang/CharSequence;Ljava/nio/charset/Charset;)Lio/netty/buffer/ByteBuf;
        //    45: astore_1        /* lllllllllllIllllllIIIIlIIllIIlII */
        //    46: aconst_null    
        //    47: astore_2        /* lllllllllllIllllllIIIIlIIlIlllIl */
        //    48: aload_1         /* lllllllllllIllllllIIIIlIIllIIlII */
        //    49: invokestatic    io/netty/handler/codec/base64/Base64.decode:(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
        //    52: astore_2        /* lllllllllllIllllllIIIIlIIllIIIll */
        //    53: new             Lio/netty/buffer/ByteBufInputStream;
        //    56: dup            
        //    57: aload_2         /* lllllllllllIllllllIIIIlIIllIIIll */
        //    58: invokespecial   io/netty/buffer/ByteBufInputStream.<init>:(Lio/netty/buffer/ByteBuf;)V
        //    61: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    64: astore_3        /* lllllllllllIllllllIIIIlIIllIIIlI */
        //    65: aload_3         /* lllllllllllIllllllIIIIlIIllIIIlI */
        //    66: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    69: bipush          64
        //    71: if_icmpne       78
        //    74: iconst_1       
        //    75: goto            79
        //    78: iconst_0       
        //    79: ldc_w           "Must be 64 pixels wide"
        //    82: iconst_0       
        //    83: anewarray       Ljava/lang/Object;
        //    86: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //    89: aload_3         /* lllllllllllIllllllIIIIlIIllIIIlI */
        //    90: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    93: bipush          64
        //    95: if_icmpne       102
        //    98: iconst_1       
        //    99: goto            103
        //   102: iconst_0       
        //   103: ldc_w           "Must be 64 pixels high"
        //   106: iconst_0       
        //   107: anewarray       Ljava/lang/Object;
        //   110: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //   113: aload_1         /* lllllllllllIllllllIIIIlIIllIIlII */
        //   114: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   117: pop            
        //   118: aload_2         /* lllllllllllIllllllIIIIlIIllIIIll */
        //   119: ifnull          204
        //   122: aload_2         /* lllllllllllIllllllIIIIlIIllIIIll */
        //   123: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   126: pop            
        //   127: goto            204
        //   130: astore          lllllllllllIllllllIIIIlIIllIIIII
        //   132: getstatic       net/minecraft/client/gui/ServerListEntryNormal.LOGGER:Lorg/apache/logging/log4j/Logger;
        //   135: ldc_w           "Invalid icon for server {} ({})"
        //   138: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   139: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //   142: getfield        net/minecraft/client/multiplayer/ServerData.serverName:Ljava/lang/String;
        //   145: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   146: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //   149: getfield        net/minecraft/client/multiplayer/ServerData.serverIP:Ljava/lang/String;
        //   152: aload           lllllllllllIllllllIIIIlIIllIIIII
        //   154: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   159: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   160: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //   163: aconst_null    
        //   164: invokevirtual   net/minecraft/client/multiplayer/ServerData.setBase64EncodedIconData:(Ljava/lang/String;)V
        //   167: aload_1         /* lllllllllllIllllllIIIIlIIllIIlII */
        //   168: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   171: pop            
        //   172: aload_2         /* lllllllllllIllllllIIIIlIIllIIIll */
        //   173: ifnull          203
        //   176: aload_2         /* lllllllllllIllllllIIIIlIIllIIIll */
        //   177: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   180: pop            
        //   181: goto            203
        //   184: astore          lllllllllllIllllllIIIIlIIlIllIlI
        //   186: aload_1         /* lllllllllllIllllllIIIIlIIllIIlII */
        //   187: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   190: pop            
        //   191: aload_2         /* lllllllllllIllllllIIIIlIIllIIIll */
        //   192: ifnull          200
        //   195: aload_2         /* lllllllllllIllllllIIIIlIIllIIIll */
        //   196: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   199: pop            
        //   200: aload           lllllllllllIllllllIIIIlIIlIllIlI
        //   202: athrow         
        //   203: return         
        //   204: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   205: getfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   208: ifnonnull       249
        //   211: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   212: new             Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   215: dup            
        //   216: aload_3         /* lllllllllllIllllllIIIIlIIllIIIIl */
        //   217: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   220: aload_3         /* lllllllllllIllllllIIIIlIIllIIIIl */
        //   221: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   224: invokespecial   net/minecraft/client/renderer/texture/DynamicTexture.<init>:(II)V
        //   227: putfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   230: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   231: getfield        net/minecraft/client/gui/ServerListEntryNormal.mc:Lnet/minecraft/client/Minecraft;
        //   234: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //   237: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   238: getfield        net/minecraft/client/gui/ServerListEntryNormal.serverIcon:Lnet/minecraft/util/ResourceLocation;
        //   241: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   242: getfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   245: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.loadTexture:(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/client/renderer/texture/ITextureObject;)Z
        //   248: pop            
        //   249: aload_3         /* lllllllllllIllllllIIIIlIIllIIIIl */
        //   250: iconst_0       
        //   251: iconst_0       
        //   252: aload_3         /* lllllllllllIllllllIIIIlIIllIIIIl */
        //   253: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   256: aload_3         /* lllllllllllIllllllIIIIlIIllIIIIl */
        //   257: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   260: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   261: getfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   264: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.getTextureData:()[I
        //   267: iconst_0       
        //   268: aload_3         /* lllllllllllIllllllIIIIlIIllIIIIl */
        //   269: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   272: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //   275: pop            
        //   276: aload_0         /* lllllllllllIllllllIIIIlIIlIlllll */
        //   277: getfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   280: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.updateDynamicTexture:()V
        //   283: return         
        //    StackMapTable: 00 0C 20 FE 00 2D 07 01 E7 07 01 E7 07 01 D5 40 01 16 40 01 FF 00 1A 00 03 07 00 02 07 01 E7 07 01 E7 00 01 07 01 B3 75 07 01 B3 FE 00 0F 00 00 07 01 B3 FF 00 02 00 05 07 00 02 07 01 E7 07 01 E7 00 07 01 B3 00 00 FF 00 00 00 04 07 00 02 07 01 E7 07 01 E7 07 01 D5 00 00 2C F8 00 21
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  48     113    130    184    Ljava/lang/Throwable;
        //  48     113    184    203    Any
        //  130    167    184    203    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void mouseReleased(final int lllllllllllIllllllIIIIlIIlIIIlII, final int lllllllllllIllllllIIIIlIIlIIIIll, final int lllllllllllIllllllIIIIlIIlIIIIlI, final int lllllllllllIllllllIIIIlIIlIIIIIl, final int lllllllllllIllllllIIIIlIIlIIIIII, final int lllllllllllIllllllIIIIlIIIllllll) {
    }
    
    public ServerData getServerData() {
        return this.server;
    }
    
    private boolean canJoin() {
        return true;
    }
    
    @Override
    public boolean mousePressed(final int lllllllllllIllllllIIIIlIIlIIllIl, final int lllllllllllIllllllIIIIlIIlIlIIll, final int lllllllllllIllllllIIIIlIIlIlIIlI, final int lllllllllllIllllllIIIIlIIlIlIIIl, final int lllllllllllIllllllIIIIlIIlIIllII, final int lllllllllllIllllllIIIIlIIlIIllll) {
        if (lllllllllllIllllllIIIIlIIlIIllII <= 32) {
            if (lllllllllllIllllllIIIIlIIlIIllII < 32 && lllllllllllIllllllIIIIlIIlIIllII > 16 && this.canJoin()) {
                this.owner.selectServer(lllllllllllIllllllIIIIlIIlIIllIl);
                this.owner.connectToSelected();
                return true;
            }
            if (lllllllllllIllllllIIIIlIIlIIllII < 16 && lllllllllllIllllllIIIIlIIlIIllll < 16 && this.owner.canMoveUp(this, lllllllllllIllllllIIIIlIIlIIllIl)) {
                this.owner.moveServerUp(this, lllllllllllIllllllIIIIlIIlIIllIl, GuiScreen.isShiftKeyDown());
                return true;
            }
            if (lllllllllllIllllllIIIIlIIlIIllII < 16 && lllllllllllIllllllIIIIlIIlIIllll > 16 && this.owner.canMoveDown(this, lllllllllllIllllllIIIIlIIlIIllIl)) {
                this.owner.moveServerDown(this, lllllllllllIllllllIIIIlIIlIIllIl, GuiScreen.isShiftKeyDown());
                return true;
            }
        }
        this.owner.selectServer(lllllllllllIllllllIIIIlIIlIIllIl);
        if (Minecraft.getSystemTime() - this.lastClickTime < 250L) {
            this.owner.connectToSelected();
        }
        this.lastClickTime = Minecraft.getSystemTime();
        return false;
    }
}
