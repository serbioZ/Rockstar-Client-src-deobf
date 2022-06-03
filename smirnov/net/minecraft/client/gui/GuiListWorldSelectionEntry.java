// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.world.WorldSettings;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.world.storage.ISaveFormat;
import java.text.SimpleDateFormat;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.text.TextFormatting;
import org.apache.commons.lang3.StringUtils;
import java.util.Date;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.Minecraft;
import java.text.DateFormat;
import net.minecraft.world.storage.WorldSummary;
import java.io.File;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.ResourceLocation;

public class GuiListWorldSelectionEntry implements GuiListExtended.IGuiListEntry
{
    private final /* synthetic */ ResourceLocation iconLocation;
    private final /* synthetic */ GuiListWorldSelection containingListSel;
    private final /* synthetic */ GuiWorldSelection worldSelScreen;
    private /* synthetic */ File iconFile;
    private final /* synthetic */ WorldSummary worldSummary;
    private static final /* synthetic */ DateFormat DATE_FORMAT;
    private static final /* synthetic */ ResourceLocation ICON_MISSING;
    private /* synthetic */ long lastClickTime;
    private static final /* synthetic */ ResourceLocation ICON_OVERLAY_LOCATION;
    private final /* synthetic */ Minecraft client;
    private /* synthetic */ DynamicTexture icon;
    
    @Override
    public boolean mousePressed(final int lllllllllllIIllIIIllIIlIlIIIIIII, final int lllllllllllIIllIIIllIIlIlIIIIllI, final int lllllllllllIIllIIIllIIlIlIIIIlIl, final int lllllllllllIIllIIIllIIlIlIIIIlII, final int lllllllllllIIllIIIllIIlIlIIIIIll, final int lllllllllllIIllIIIllIIlIlIIIIIlI) {
        this.containingListSel.selectWorld(lllllllllllIIllIIIllIIlIlIIIIIII);
        if (lllllllllllIIllIIIllIIlIlIIIIIll <= 32 && lllllllllllIIllIIIllIIlIlIIIIIll < 32) {
            this.joinWorld();
            return true;
        }
        if (Minecraft.getSystemTime() - this.lastClickTime < 250L) {
            this.joinWorld();
            return true;
        }
        this.lastClickTime = Minecraft.getSystemTime();
        return false;
    }
    
    public void recreateWorld() {
        this.client.displayGuiScreen(new GuiScreenWorking());
        final GuiCreateWorld lllllllllllIIllIIIllIIlIIlllIIII = new GuiCreateWorld(this.worldSelScreen);
        final ISaveHandler lllllllllllIIllIIIllIIlIIllIllll = this.client.getSaveLoader().getSaveLoader(this.worldSummary.getFileName(), false);
        final WorldInfo lllllllllllIIllIIIllIIlIIllIlllI = lllllllllllIIllIIIllIIlIIllIllll.loadWorldInfo();
        lllllllllllIIllIIIllIIlIIllIllll.flush();
        if (lllllllllllIIllIIIllIIlIIllIlllI != null) {
            lllllllllllIIllIIIllIIlIIlllIIII.recreateFromExistingWorld(lllllllllllIIllIIIllIIlIIllIlllI);
            this.client.displayGuiScreen(lllllllllllIIllIIIllIIlIIlllIIII);
        }
    }
    
    @Override
    public void func_192633_a(final int lllllllllllIIllIIIllIIlIIlIlIIIl, final int lllllllllllIIllIIIllIIlIIlIlIIII, final int lllllllllllIIllIIIllIIlIIlIIllll, final float lllllllllllIIllIIIllIIlIIlIIlllI) {
    }
    
    @Override
    public void mouseReleased(final int lllllllllllIIllIIIllIIlIIlIllIII, final int lllllllllllIIllIIIllIIlIIlIlIlll, final int lllllllllllIIllIIIllIIlIIlIlIllI, final int lllllllllllIIllIIIllIIlIIlIlIlIl, final int lllllllllllIIllIIIllIIlIIlIlIlII, final int lllllllllllIIllIIIllIIlIIlIlIIll) {
    }
    
    public void editWorld() {
        this.client.displayGuiScreen(new GuiWorldEdit(this.worldSelScreen, this.worldSummary.getFileName()));
    }
    
    public void joinWorld() {
        if (this.worldSummary.askToOpenWorld()) {
            this.client.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
                @Override
                public void confirmClicked(final boolean llllllllllIlllllllIlIlIIlllllIII, final int llllllllllIlllllllIlIlIIllllIlll) {
                    if (llllllllllIlllllllIlIlIIlllllIII) {
                        GuiListWorldSelectionEntry.this.loadWorld();
                    }
                    else {
                        GuiListWorldSelectionEntry.this.client.displayGuiScreen(GuiListWorldSelectionEntry.this.worldSelScreen);
                    }
                }
            }, I18n.format("selectWorld.versionQuestion", new Object[0]), I18n.format("selectWorld.versionWarning", this.worldSummary.getVersionName()), I18n.format("selectWorld.versionJoinButton", new Object[0]), I18n.format("gui.cancel", new Object[0]), 0));
        }
        else {
            this.loadWorld();
        }
    }
    
    @Override
    public void func_192634_a(final int lllllllllllIIllIIIllIIlIlIlIIlIl, final int lllllllllllIIllIIIllIIlIlIlIIlII, final int lllllllllllIIllIIIllIIlIlIlIIIll, final int lllllllllllIIllIIIllIIlIlIlIIIlI, final int lllllllllllIIllIIIllIIlIlIlIIIIl, final int lllllllllllIIllIIIllIIlIlIlIIIII, final int lllllllllllIIllIIIllIIlIlIIlllll, final boolean lllllllllllIIllIIIllIIlIlIIllllI, final float lllllllllllIIllIIIllIIlIlIIlllIl) {
        String lllllllllllIIllIIIllIIlIlIIlllII = this.worldSummary.getDisplayName();
        final String lllllllllllIIllIIIllIIlIlIIllIll = String.valueOf(this.worldSummary.getFileName()) + " (" + GuiListWorldSelectionEntry.DATE_FORMAT.format(new Date(this.worldSummary.getLastTimePlayed())) + ")";
        String lllllllllllIIllIIIllIIlIlIIllIlI = "";
        if (StringUtils.isEmpty((CharSequence)lllllllllllIIllIIIllIIlIlIIlllII)) {
            lllllllllllIIllIIIllIIlIlIIlllII = String.valueOf(I18n.format("selectWorld.world", new Object[0])) + " " + (lllllllllllIIllIIIllIIlIlIlIIlIl + 1);
        }
        if (this.worldSummary.requiresConversion()) {
            lllllllllllIIllIIIllIIlIlIIllIlI = String.valueOf(I18n.format("selectWorld.conversion", new Object[0])) + " " + lllllllllllIIllIIIllIIlIlIIllIlI;
        }
        else {
            lllllllllllIIllIIIllIIlIlIIllIlI = I18n.format("gameMode." + this.worldSummary.getEnumGameType().getName(), new Object[0]);
            if (this.worldSummary.isHardcoreModeEnabled()) {
                lllllllllllIIllIIIllIIlIlIIllIlI = TextFormatting.DARK_RED + I18n.format("gameMode.hardcore", new Object[0]) + TextFormatting.RESET;
            }
            if (this.worldSummary.getCheatsEnabled()) {
                lllllllllllIIllIIIllIIlIlIIllIlI = String.valueOf(lllllllllllIIllIIIllIIlIlIIllIlI) + ", " + I18n.format("selectWorld.cheats", new Object[0]);
            }
            final String lllllllllllIIllIIIllIIlIlIIllIIl = this.worldSummary.getVersionName();
            if (this.worldSummary.markVersionInList()) {
                if (this.worldSummary.askToOpenWorld()) {
                    lllllllllllIIllIIIllIIlIlIIllIlI = String.valueOf(lllllllllllIIllIIIllIIlIlIIllIlI) + ", " + I18n.format("selectWorld.version", new Object[0]) + " " + TextFormatting.RED + lllllllllllIIllIIIllIIlIlIIllIIl + TextFormatting.RESET;
                }
                else {
                    lllllllllllIIllIIIllIIlIlIIllIlI = String.valueOf(lllllllllllIIllIIIllIIlIlIIllIlI) + ", " + I18n.format("selectWorld.version", new Object[0]) + " " + TextFormatting.ITALIC + lllllllllllIIllIIIllIIlIlIIllIIl + TextFormatting.RESET;
                }
            }
            else {
                lllllllllllIIllIIIllIIlIlIIllIlI = String.valueOf(lllllllllllIIllIIIllIIlIlIIllIlI) + ", " + I18n.format("selectWorld.version", new Object[0]) + " " + lllllllllllIIllIIIllIIlIlIIllIIl;
            }
        }
        Minecraft.fontRendererObj.drawString(lllllllllllIIllIIIllIIlIlIIlllII, (float)(lllllllllllIIllIIIllIIlIlIlIIlII + 32 + 3), (float)(lllllllllllIIllIIIllIIlIlIlIIIll + 1), 16777215);
        Minecraft.fontRendererObj.drawString(lllllllllllIIllIIIllIIlIlIIllIll, (float)(lllllllllllIIllIIIllIIlIlIlIIlII + 32 + 3), (float)(lllllllllllIIllIIIllIIlIlIlIIIll + Minecraft.fontRendererObj.FONT_HEIGHT + 3), 8421504);
        Minecraft.fontRendererObj.drawString(lllllllllllIIllIIIllIIlIlIIllIlI, (float)(lllllllllllIIllIIIllIIlIlIlIIlII + 32 + 3), (float)(lllllllllllIIllIIIllIIlIlIlIIIll + Minecraft.fontRendererObj.FONT_HEIGHT + Minecraft.fontRendererObj.FONT_HEIGHT + 3), 8421504);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.client.getTextureManager().bindTexture((this.icon != null) ? this.iconLocation : GuiListWorldSelectionEntry.ICON_MISSING);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIIllIIIllIIlIlIlIIlII, (float)lllllllllllIIllIIIllIIlIlIlIIIll, 0.0f, 0.0f, 32.0f, 32.0f, 32.0f, 32.0f);
        GlStateManager.disableBlend();
        if (this.client.gameSettings.touchscreen || lllllllllllIIllIIIllIIlIlIIllllI) {
            this.client.getTextureManager().bindTexture(GuiListWorldSelectionEntry.ICON_OVERLAY_LOCATION);
            Gui.drawRect(lllllllllllIIllIIIllIIlIlIlIIlII, lllllllllllIIllIIIllIIlIlIlIIIll, lllllllllllIIllIIIllIIlIlIlIIlII + 32, lllllllllllIIllIIIllIIlIlIlIIIll + 32, -1601138544);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int lllllllllllIIllIIIllIIlIlIIllIII = lllllllllllIIllIIIllIIlIlIlIIIII - lllllllllllIIllIIIllIIlIlIlIIlII;
            final int lllllllllllIIllIIIllIIlIlIIlIlll = (lllllllllllIIllIIIllIIlIlIIllIII < 32) ? 32 : 0;
            if (this.worldSummary.markVersionInList()) {
                Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIIllIIIllIIlIlIlIIlII, (float)lllllllllllIIllIIIllIIlIlIlIIIll, 32.0f, (float)lllllllllllIIllIIIllIIlIlIIlIlll, 32.0f, 32.0f, 256.0f, 256.0f);
                if (this.worldSummary.askToOpenWorld()) {
                    Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIIllIIIllIIlIlIlIIlII, (float)lllllllllllIIllIIIllIIlIlIlIIIll, 96.0f, (float)lllllllllllIIllIIIllIIlIlIIlIlll, 32.0f, 32.0f, 256.0f, 256.0f);
                    if (lllllllllllIIllIIIllIIlIlIIllIII < 32) {
                        this.worldSelScreen.setVersionTooltip(TextFormatting.RED + I18n.format("selectWorld.tooltip.fromNewerVersion1", new Object[0]) + "\n" + TextFormatting.RED + I18n.format("selectWorld.tooltip.fromNewerVersion2", new Object[0]));
                    }
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIIllIIIllIIlIlIlIIlII, (float)lllllllllllIIllIIIllIIlIlIlIIIll, 64.0f, (float)lllllllllllIIllIIIllIIlIlIIlIlll, 32.0f, 32.0f, 256.0f, 256.0f);
                    if (lllllllllllIIllIIIllIIlIlIIllIII < 32) {
                        this.worldSelScreen.setVersionTooltip(TextFormatting.GOLD + I18n.format("selectWorld.tooltip.snapshot1", new Object[0]) + "\n" + TextFormatting.GOLD + I18n.format("selectWorld.tooltip.snapshot2", new Object[0]));
                    }
                }
            }
            else {
                Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllIIllIIIllIIlIlIlIIlII, (float)lllllllllllIIllIIIllIIlIlIlIIIll, 0.0f, (float)lllllllllllIIllIIIllIIlIlIIlIlll, 32.0f, 32.0f, 256.0f, 256.0f);
            }
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DATE_FORMAT = new SimpleDateFormat();
        ICON_MISSING = new ResourceLocation("textures/misc/unknown_server.png");
        ICON_OVERLAY_LOCATION = new ResourceLocation("textures/gui/world_selection.png");
    }
    
    public GuiListWorldSelectionEntry(final GuiListWorldSelection lllllllllllIIllIIIllIIlIlIllIlII, final WorldSummary lllllllllllIIllIIIllIIlIlIllIlll, final ISaveFormat lllllllllllIIllIIIllIIlIlIllIllI) {
        this.containingListSel = lllllllllllIIllIIIllIIlIlIllIlII;
        this.worldSelScreen = lllllllllllIIllIIIllIIlIlIllIlII.getGuiWorldSelection();
        this.worldSummary = lllllllllllIIllIIIllIIlIlIllIlll;
        this.client = Minecraft.getMinecraft();
        this.iconLocation = new ResourceLocation("worlds/" + lllllllllllIIllIIIllIIlIlIllIlll.getFileName() + "/icon");
        this.iconFile = lllllllllllIIllIIIllIIlIlIllIllI.getFile(lllllllllllIIllIIIllIIlIlIllIlll.getFileName(), "icon.png");
        if (!this.iconFile.isFile()) {
            this.iconFile = null;
        }
        this.loadServerIcon();
    }
    
    public void deleteWorld() {
        this.client.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
            @Override
            public void confirmClicked(final boolean llllllllllllIIIlIIIlllIIIlIIllIl, final int llllllllllllIIIlIIIlllIIIlIlIIII) {
                if (llllllllllllIIIlIIIlllIIIlIIllIl) {
                    GuiListWorldSelectionEntry.this.client.displayGuiScreen(new GuiScreenWorking());
                    final ISaveFormat llllllllllllIIIlIIIlllIIIlIIllll = GuiListWorldSelectionEntry.this.client.getSaveLoader();
                    llllllllllllIIIlIIIlllIIIlIIllll.flushCache();
                    llllllllllllIIIlIIIlllIIIlIIllll.deleteWorldDirectory(GuiListWorldSelectionEntry.this.worldSummary.getFileName());
                    GuiListWorldSelectionEntry.this.containingListSel.refreshList();
                }
                GuiListWorldSelectionEntry.this.client.displayGuiScreen(GuiListWorldSelectionEntry.this.worldSelScreen);
            }
        }, I18n.format("selectWorld.deleteQuestion", new Object[0]), "'" + this.worldSummary.getDisplayName() + "' " + I18n.format("selectWorld.deleteWarning", new Object[0]), I18n.format("selectWorld.deleteButton", new Object[0]), I18n.format("gui.cancel", new Object[0]), 0));
    }
    
    private void loadServerIcon() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconFile:Ljava/io/File;
        //     4: ifnull          21
        //     7: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //     8: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconFile:Ljava/io/File;
        //    11: invokevirtual   java/io/File.isFile:()Z
        //    14: ifeq            21
        //    17: iconst_1       
        //    18: goto            22
        //    21: iconst_0       
        //    22: istore_1        /* lllllllllllIIllIIIllIIlIIlIlllII */
        //    23: iload_1         /* lllllllllllIIllIIIllIIlIIllIIIIl */
        //    24: ifeq            194
        //    27: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //    28: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconFile:Ljava/io/File;
        //    31: invokestatic    javax/imageio/ImageIO.read:(Ljava/io/File;)Ljava/awt/image/BufferedImage;
        //    34: astore_2        /* lllllllllllIIllIIIllIIlIIllIIIII */
        //    35: aload_2         /* lllllllllllIIllIIIllIIlIIllIIIII */
        //    36: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    39: bipush          64
        //    41: if_icmpne       48
        //    44: iconst_1       
        //    45: goto            49
        //    48: iconst_0       
        //    49: ldc_w           "Must be 64 pixels wide"
        //    52: iconst_0       
        //    53: anewarray       Ljava/lang/Object;
        //    56: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //    59: aload_2         /* lllllllllllIIllIIIllIIlIIllIIIII */
        //    60: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    63: bipush          64
        //    65: if_icmpne       72
        //    68: iconst_1       
        //    69: goto            73
        //    72: iconst_0       
        //    73: ldc_w           "Must be 64 pixels high"
        //    76: iconst_0       
        //    77: anewarray       Ljava/lang/Object;
        //    80: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //    83: goto            112
        //    86: astore_3        /* lllllllllllIIllIIIllIIlIIlIllIlI */
        //    87: getstatic       net/minecraft/client/gui/GuiListWorldSelectionEntry.LOGGER:Lorg/apache/logging/log4j/Logger;
        //    90: ldc_w           "Invalid icon for world {}"
        //    93: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //    94: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.worldSummary:Lnet/minecraft/world/storage/WorldSummary;
        //    97: invokevirtual   net/minecraft/world/storage/WorldSummary.getFileName:()Ljava/lang/String;
        //   100: aload_3         /* lllllllllllIIllIIIllIIlIIlIllllI */
        //   101: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   106: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   107: aconst_null    
        //   108: putfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconFile:Ljava/io/File;
        //   111: return         
        //   112: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   113: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   116: ifnonnull       157
        //   119: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   120: new             Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   123: dup            
        //   124: aload_2         /* lllllllllllIIllIIIllIIlIIlIlllll */
        //   125: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   128: aload_2         /* lllllllllllIIllIIIllIIlIIlIlllll */
        //   129: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   132: invokespecial   net/minecraft/client/renderer/texture/DynamicTexture.<init>:(II)V
        //   135: putfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   138: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   139: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.client:Lnet/minecraft/client/Minecraft;
        //   142: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //   145: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   146: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconLocation:Lnet/minecraft/util/ResourceLocation;
        //   149: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   150: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   153: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.loadTexture:(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/client/renderer/texture/ITextureObject;)Z
        //   156: pop            
        //   157: aload_2         /* lllllllllllIIllIIIllIIlIIlIlllll */
        //   158: iconst_0       
        //   159: iconst_0       
        //   160: aload_2         /* lllllllllllIIllIIIllIIlIIlIlllll */
        //   161: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   164: aload_2         /* lllllllllllIIllIIIllIIlIIlIlllll */
        //   165: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   168: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   169: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   172: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.getTextureData:()[I
        //   175: iconst_0       
        //   176: aload_2         /* lllllllllllIIllIIIllIIlIIlIlllll */
        //   177: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   180: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //   183: pop            
        //   184: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   185: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   188: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.updateDynamicTexture:()V
        //   191: goto            217
        //   194: iload_1         /* lllllllllllIIllIIIllIIlIIllIIIIl */
        //   195: ifne            217
        //   198: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   199: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.client:Lnet/minecraft/client/Minecraft;
        //   202: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //   205: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   206: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconLocation:Lnet/minecraft/util/ResourceLocation;
        //   209: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.deleteTexture:(Lnet/minecraft/util/ResourceLocation;)V
        //   212: aload_0         /* lllllllllllIIllIIIllIIlIIllIIIlI */
        //   213: aconst_null    
        //   214: putfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   217: return         
        //    StackMapTable: 00 0B 15 40 01 FD 00 19 01 07 02 05 40 01 16 40 01 FF 00 0C 00 02 07 00 02 01 00 01 07 01 FD FC 00 19 07 02 05 2C FA 00 24 16
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  27     83     86     112    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void loadWorld() {
        this.client.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
        if (this.client.getSaveLoader().canLoadWorld(this.worldSummary.getFileName())) {
            this.client.launchIntegratedServer(this.worldSummary.getFileName(), this.worldSummary.getDisplayName(), null);
        }
    }
}
