// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.util.List;
import java.net.URI;
import net.minecraft.util.text.TextFormatting;
import org.apache.logging.log4j.LogManager;
import ru.rockstar.api.changelogs.ChangeLog;
import ru.rockstar.Main;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL11;
import net.minecraft.world.WorldServerDemo;
import optifine.Reflector;
import ru.rockstar.client.ui.altmanager.GuiAltManager;
import net.minecraft.realms.RealmsBridge;
import com.google.common.util.concurrent.Runnables;
import net.minecraft.util.StringUtils;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.util.glu.Project;
import java.io.IOException;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.renderer.BufferBuilder;
import optifine.CustomPanoramaProperties;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import optifine.CustomPanorama;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.utils.world.TimerHelper;
import org.apache.logging.log4j.Logger;
import ru.rockstar.client.ui.settings.button.ImageButton;
import java.util.ArrayList;
import ru.rockstar.api.utils.other.ParticleEngine;
import net.minecraft.client.renderer.texture.DynamicTexture;
import java.util.Random;
import ru.rockstar.api.utils.render.glsandbox.animbackground;
import net.minecraft.util.ResourceLocation;

public class GuiMainMenu extends GuiScreen
{
    private static final /* synthetic */ ResourceLocation[] TITLE_PANORAMA_PATHS;
    private /* synthetic */ float panoramaTimer;
    private /* synthetic */ int openGLWarning1Width;
    private final /* synthetic */ animbackground backgroundShader;
    private /* synthetic */ int openGLWarningY2;
    private /* synthetic */ int openGLWarningY1;
    private /* synthetic */ String openGLWarning2;
    private /* synthetic */ int field_193978_M;
    private /* synthetic */ DynamicTexture viewportTexture;
    private /* synthetic */ int openGLWarningX2;
    private /* synthetic */ int openGLWarning2Width;
    private /* synthetic */ String openGLWarning1;
    private /* synthetic */ GuiButton realmsButton;
    public static /* synthetic */ ParticleEngine engine;
    private /* synthetic */ boolean hasCheckedForRealmsNotification;
    protected /* synthetic */ ArrayList<ImageButton> imageButtons;
    private /* synthetic */ GuiButton buttonResetDemo;
    private /* synthetic */ GuiButton modButton;
    private /* synthetic */ int openGLWarningX1;
    private final /* synthetic */ long initTime;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ GuiScreen realmsNotification;
    private /* synthetic */ int field_193979_N;
    private /* synthetic */ ResourceLocation backgroundTexture;
    private /* synthetic */ GuiScreen modUpdateNotification;
    private final /* synthetic */ Object threadLock;
    private /* synthetic */ String openGLWarningLink;
    
    private void renderSkybox(final int llllllllllllIIIIIlIlIIIIIIlIllII, final int llllllllllllIIIIIlIlIIIIIIlIlIll, final float llllllllllllIIIIIlIlIIIIIIlIlIlI) {
        this.mc.getFramebuffer().unbindFramebuffer();
        GlStateManager.viewport(0, 0, 256, 256);
        this.drawPanorama(llllllllllllIIIIIlIlIIIIIIlIllII, llllllllllllIIIIIlIlIIIIIIlIlIll, llllllllllllIIIIIlIlIIIIIIlIlIlI);
        this.rotateAndBlurSkybox();
        int llllllllllllIIIIIlIlIIIIIIllIlll = 3;
        final CustomPanoramaProperties llllllllllllIIIIIlIlIIIIIIllIllI = CustomPanorama.getCustomPanoramaProperties();
        if (llllllllllllIIIIIlIlIIIIIIllIllI != null) {
            llllllllllllIIIIIlIlIIIIIIllIlll = llllllllllllIIIIIlIlIIIIIIllIllI.getBlur3();
        }
        for (int llllllllllllIIIIIlIlIIIIIIllIlIl = 0; llllllllllllIIIIIlIlIIIIIIllIlIl < llllllllllllIIIIIlIlIIIIIIllIlll; ++llllllllllllIIIIIlIlIIIIIIllIlIl) {
            this.rotateAndBlurSkybox();
            this.rotateAndBlurSkybox();
        }
        this.mc.getFramebuffer().bindFramebuffer(true);
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        final float llllllllllllIIIIIlIlIIIIIIllIlII = 120.0f / ((this.width > this.height) ? this.width : this.height);
        final float llllllllllllIIIIIlIlIIIIIIllIIll = this.height * llllllllllllIIIIIlIlIIIIIIllIlII / 256.0f;
        final float llllllllllllIIIIIlIlIIIIIIllIIlI = this.width * llllllllllllIIIIIlIlIIIIIIllIlII / 256.0f;
        final int llllllllllllIIIIIlIlIIIIIIllIIIl = this.width;
        final int llllllllllllIIIIIlIlIIIIIIllIIII = this.height;
        final Tessellator llllllllllllIIIIIlIlIIIIIIlIllll = Tessellator.getInstance();
        final BufferBuilder llllllllllllIIIIIlIlIIIIIIlIlllI = llllllllllllIIIIIlIlIIIIIIlIllll.getBuffer();
        llllllllllllIIIIIlIlIIIIIIlIlllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllIIIIIlIlIIIIIIlIlllI.pos(0.0, llllllllllllIIIIIlIlIIIIIIllIIII, this.zLevel).tex(0.5f - llllllllllllIIIIIlIlIIIIIIllIIll, 0.5f + llllllllllllIIIIIlIlIIIIIIllIIlI).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        llllllllllllIIIIIlIlIIIIIIlIlllI.pos(llllllllllllIIIIIlIlIIIIIIllIIIl, llllllllllllIIIIIlIlIIIIIIllIIII, this.zLevel).tex(0.5f - llllllllllllIIIIIlIlIIIIIIllIIll, 0.5f - llllllllllllIIIIIlIlIIIIIIllIIlI).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        llllllllllllIIIIIlIlIIIIIIlIlllI.pos(llllllllllllIIIIIlIlIIIIIIllIIIl, 0.0, this.zLevel).tex(0.5f + llllllllllllIIIIIlIlIIIIIIllIIll, 0.5f - llllllllllllIIIIIlIlIIIIIIllIIlI).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        llllllllllllIIIIIlIlIIIIIIlIlllI.pos(0.0, 0.0, this.zLevel).tex(0.5f + llllllllllllIIIIIlIlIIIIIIllIIll, 0.5f + llllllllllllIIIIIlIlIIIIIIllIIlI).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        llllllllllllIIIIIlIlIIIIIIlIllll.draw();
    }
    
    private void addDemoButtons(final int llllllllllllIIIIIlIlIIIIllIIIIlI, final int llllllllllllIIIIIlIlIIIIlIllllII) {
        this.buttonList.add(new GuiButton(11, this.width / 2 - 110, llllllllllllIIIIIlIlIIIIllIIIIlI, I18n.format("menu.playdemo", new Object[0])));
        this.buttonResetDemo = this.addButton(new GuiButton(12, this.width / 2 - 110, llllllllllllIIIIIlIlIIIIllIIIIlI + llllllllllllIIIIIlIlIIIIlIllllII * 1, I18n.format("menu.resetdemo", new Object[0])));
        final ISaveFormat llllllllllllIIIIIlIlIIIIllIIIIII = this.mc.getSaveLoader();
        final WorldInfo llllllllllllIIIIIlIlIIIIlIllllll = llllllllllllIIIIIlIlIIIIllIIIIII.getWorldInfo("Demo_World");
        if (llllllllllllIIIIIlIlIIIIlIllllll == null) {
            this.buttonResetDemo.enabled = false;
        }
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIIIIIlIlIIIIlllIlIII, final int llllllllllllIIIIIlIlIIIIlllIIlll) throws IOException {
    }
    
    private void drawPanorama(final int llllllllllllIIIIIlIlIIIIlIIIIlll, final int llllllllllllIIIIIlIlIIIIlIIIIllI, final float llllllllllllIIIIIlIlIIIIlIIIIlIl) {
        final Tessellator llllllllllllIIIIIlIlIIIIlIIIIlII = Tessellator.getInstance();
        final BufferBuilder llllllllllllIIIIIlIlIIIIlIIIIIll = llllllllllllIIIIIlIlIIIIlIIIIlII.getBuffer();
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        Project.gluPerspective(120.0f, 1.0f, 0.05f, 10.0f);
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableCull();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final int llllllllllllIIIIIlIlIIIIlIIIIIlI = 8;
        int llllllllllllIIIIIlIlIIIIlIIIIIIl = 64;
        final CustomPanoramaProperties llllllllllllIIIIIlIlIIIIlIIIIIII = CustomPanorama.getCustomPanoramaProperties();
        if (llllllllllllIIIIIlIlIIIIlIIIIIII != null) {
            llllllllllllIIIIIlIlIIIIlIIIIIIl = llllllllllllIIIIIlIlIIIIlIIIIIII.getBlur1();
        }
        for (int llllllllllllIIIIIlIlIIIIIlllllll = 0; llllllllllllIIIIIlIlIIIIIlllllll < llllllllllllIIIIIlIlIIIIlIIIIIIl; ++llllllllllllIIIIIlIlIIIIIlllllll) {
            GlStateManager.pushMatrix();
            final float llllllllllllIIIIIlIlIIIIIllllllI = (llllllllllllIIIIIlIlIIIIIlllllll % 8 / 8.0f - 0.5f) / 64.0f;
            final float llllllllllllIIIIIlIlIIIIIlllllIl = (llllllllllllIIIIIlIlIIIIIlllllll / 8 / 8.0f - 0.5f) / 64.0f;
            final float llllllllllllIIIIIlIlIIIIIlllllII = 0.0f;
            GlStateManager.translate(llllllllllllIIIIIlIlIIIIIllllllI, llllllllllllIIIIIlIlIIIIIlllllIl, 0.0f);
            GlStateManager.rotate(MathHelper.sin(this.panoramaTimer / 400.0f) * 25.0f + 20.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(-this.panoramaTimer * 0.1f, 0.0f, 1.0f, 0.0f);
            for (int llllllllllllIIIIIlIlIIIIIllllIll = 0; llllllllllllIIIIIlIlIIIIIllllIll < 6; ++llllllllllllIIIIIlIlIIIIIllllIll) {
                GlStateManager.pushMatrix();
                if (llllllllllllIIIIIlIlIIIIIllllIll == 1) {
                    GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
                }
                if (llllllllllllIIIIIlIlIIIIIllllIll == 2) {
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                }
                if (llllllllllllIIIIIlIlIIIIIllllIll == 3) {
                    GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
                }
                if (llllllllllllIIIIIlIlIIIIIllllIll == 4) {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (llllllllllllIIIIIlIlIIIIIllllIll == 5) {
                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                }
                ResourceLocation[] llllllllllllIIIIIlIlIIIIIllllIlI = GuiMainMenu.TITLE_PANORAMA_PATHS;
                if (llllllllllllIIIIIlIlIIIIlIIIIIII != null) {
                    llllllllllllIIIIIlIlIIIIIllllIlI = llllllllllllIIIIIlIlIIIIlIIIIIII.getPanoramaLocations();
                }
                this.mc.getTextureManager().bindTexture(llllllllllllIIIIIlIlIIIIIllllIlI[llllllllllllIIIIIlIlIIIIIllllIll]);
                llllllllllllIIIIIlIlIIIIlIIIIIll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                final int llllllllllllIIIIIlIlIIIIIllllIIl = 255 / (llllllllllllIIIIIlIlIIIIIlllllll + 1);
                final float llllllllllllIIIIIlIlIIIIIllllIII = 0.0f;
                llllllllllllIIIIIlIlIIIIlIIIIIll.pos(-1.0, -1.0, 1.0).tex(0.0, 0.0).color(255, 255, 255, llllllllllllIIIIIlIlIIIIIllllIIl).endVertex();
                llllllllllllIIIIIlIlIIIIlIIIIIll.pos(1.0, -1.0, 1.0).tex(1.0, 0.0).color(255, 255, 255, llllllllllllIIIIIlIlIIIIIllllIIl).endVertex();
                llllllllllllIIIIIlIlIIIIlIIIIIll.pos(1.0, 1.0, 1.0).tex(1.0, 1.0).color(255, 255, 255, llllllllllllIIIIIlIlIIIIIllllIIl).endVertex();
                llllllllllllIIIIIlIlIIIIlIIIIIll.pos(-1.0, 1.0, 1.0).tex(0.0, 1.0).color(255, 255, 255, llllllllllllIIIIIlIlIIIIIllllIIl).endVertex();
                llllllllllllIIIIIlIlIIIIlIIIIlII.draw();
                GlStateManager.popMatrix();
            }
            GlStateManager.popMatrix();
            GlStateManager.colorMask(true, true, true, false);
        }
        llllllllllllIIIIIlIlIIIIlIIIIIll.setTranslation(0.0, 0.0, 0.0);
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.matrixMode(5889);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.enableDepth();
    }
    
    private boolean areRealmsNotificationsEnabled() {
        return Minecraft.getMinecraft().gameSettings.getOptionOrdinalValue(GameSettings.Options.REALMS_NOTIFICATIONS) && this.realmsNotification != null;
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllIIIIIlIIlllllllllIlI, final int llllllllllllIIIIIlIIlllllllllIIl, final int llllllllllllIIIIIlIIllllllllllIl) throws IOException {
        super.mouseClicked(llllllllllllIIIIIlIIlllllllllIlI, llllllllllllIIIIIlIIlllllllllIIl, llllllllllllIIIIIlIIllllllllllIl);
        synchronized (this.threadLock) {
            if (!this.openGLWarning1.isEmpty() && !StringUtils.isNullOrEmpty(this.openGLWarningLink) && llllllllllllIIIIIlIIlllllllllIlI >= this.openGLWarningX1 && llllllllllllIIIIIlIIlllllllllIlI <= this.openGLWarningX2 && llllllllllllIIIIIlIIlllllllllIIl >= this.openGLWarningY1 && llllllllllllIIIIIlIIlllllllllIIl <= this.openGLWarningY2) {
                final GuiConfirmOpenLink llllllllllllIIIIIlIIllllllllllII = new GuiConfirmOpenLink(this, this.openGLWarningLink, 13, true);
                llllllllllllIIIIIlIIllllllllllII.disableSecurityWarning();
                this.mc.displayGuiScreen(llllllllllllIIIIIlIIllllllllllII);
            }
        }
        // monitorexit(this.threadLock)
        if (this.areRealmsNotificationsEnabled()) {
            this.realmsNotification.mouseClicked(llllllllllllIIIIIlIIlllllllllIlI, llllllllllllIIIIIlIIlllllllllIIl, llllllllllllIIIIIlIIllllllllllIl);
        }
        if (llllllllllllIIIIIlIIlllllllllIlI > this.field_193979_N && llllllllllllIIIIIlIIlllllllllIlI < this.field_193979_N + this.field_193978_M && llllllllllllIIIIIlIIlllllllllIIl > this.height - 10 && llllllllllllIIIIIlIIlllllllllIIl < this.height) {
            this.mc.displayGuiScreen(new GuiWinGame(false, Runnables.doNothing()));
        }
    }
    
    private void switchToRealms() {
        final RealmsBridge llllllllllllIIIIIlIlIIIIlIlIlIlI = new RealmsBridge();
        llllllllllllIIIIIlIlIIIIlIlIlIlI.switchToRealms(this);
    }
    
    @Override
    public void onGuiClosed() {
        if (this.realmsNotification != null) {
            this.realmsNotification.onGuiClosed();
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIIIIIlIlIIIIlIllIIII) throws IOException {
        if (llllllllllllIIIIIlIlIIIIlIllIIII.id == 0) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        if (llllllllllllIIIIIlIlIIIIlIllIIII.id == 1) {
            this.mc.displayGuiScreen(new GuiWorldSelection(this));
        }
        if (llllllllllllIIIIIlIlIIIIlIllIIII.id == 2) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if (llllllllllllIIIIIlIlIIIIlIllIIII.id == 14) {
            this.mc.displayGuiScreen(new GuiAltManager());
        }
        if (llllllllllllIIIIIlIlIIIIlIllIIII.id == 4) {
            this.mc.shutdown();
        }
        if (llllllllllllIIIIIlIlIIIIlIllIIII.id == 6 && Reflector.GuiModList_Constructor.exists()) {
            this.mc.displayGuiScreen((GuiScreen)Reflector.newInstance(Reflector.GuiModList_Constructor, new Object[] { this }));
        }
        if (llllllllllllIIIIIlIlIIIIlIllIIII.id == 11) {
            this.mc.launchIntegratedServer("Demo_World", "Demo_World", WorldServerDemo.DEMO_WORLD_SETTINGS);
        }
        if (llllllllllllIIIIIlIlIIIIlIllIIII.id == 12) {
            final ISaveFormat llllllllllllIIIIIlIlIIIIlIllIIll = this.mc.getSaveLoader();
            final WorldInfo llllllllllllIIIIIlIlIIIIlIllIIlI = llllllllllllIIIIIlIlIIIIlIllIIll.getWorldInfo("Demo_World");
            if (llllllllllllIIIIIlIlIIIIlIllIIlI != null) {
                this.mc.displayGuiScreen(new GuiYesNo(this, I18n.format("selectWorld.deleteQuestion", new Object[0]), "'" + llllllllllllIIIIIlIlIIIIlIllIIlI.getWorldName() + "' " + I18n.format("selectWorld.deleteWarning", new Object[0]), I18n.format("selectWorld.deleteButton", new Object[0]), I18n.format("gui.cancel", new Object[0]), 12));
            }
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    public void initGui() {
        final ScaledResolution llllllllllllIIIIIlIlIIIIllIlllll = new ScaledResolution(this.mc);
        this.viewportTexture = new DynamicTexture(256, 256);
        this.backgroundTexture = this.mc.getTextureManager().getDynamicTextureLocation("1", this.viewportTexture);
        this.field_193978_M = this.fontRendererObj.getStringWidth("1");
        this.field_193979_N = this.width - this.field_193978_M - 49;
        final int llllllllllllIIIIIlIlIIIIllIllllI = 24;
        final int llllllllllllIIIIIlIlIIIIllIlllIl = this.height / 4 + 48;
        if (this.mc.isDemo()) {
            this.addDemoButtons(llllllllllllIIIIIlIlIIIIllIlllIl, 24);
        }
        else {
            this.addSingleplayerMultiplayerButtons(llllllllllllIIIIIlIlIIIIllIlllIl, 24);
        }
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50, llllllllllllIIIIIlIlIIIIllIlllll.getScaledHeight() / 2 + 5, 100, 17, I18n.format("Options", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 50, llllllllllllIIIIIlIlIIIIllIlllll.getScaledHeight() / 2 + 23, 100, 17, "Quit"));
        synchronized (this.threadLock) {
            this.openGLWarning1Width = this.fontRendererObj.getStringWidth(this.openGLWarning1);
            this.openGLWarning2Width = this.fontRendererObj.getStringWidth(this.openGLWarning2);
            final int llllllllllllIIIIIlIlIIIIllIlllII = Math.max(this.openGLWarning1Width, this.openGLWarning2Width);
            this.openGLWarningX1 = (this.width - llllllllllllIIIIIlIlIIIIllIlllII) / 2;
            this.openGLWarningY1 = this.buttonList.get(0).yPosition - 24;
            this.openGLWarningX2 = this.openGLWarningX1 + llllllllllllIIIIIlIlIIIIllIlllII;
            this.openGLWarningY2 = this.openGLWarningY1 + 24;
        }
        // monitorexit(this.threadLock)
        this.mc.setConnectedToRealms(false);
        if (Minecraft.getMinecraft().gameSettings.getOptionOrdinalValue(GameSettings.Options.REALMS_NOTIFICATIONS) && !this.hasCheckedForRealmsNotification) {
            final RealmsBridge llllllllllllIIIIIlIlIIIIllIllIll = new RealmsBridge();
            this.realmsNotification = llllllllllllIIIIIlIlIIIIllIllIll.getNotificationScreen(this);
            this.hasCheckedForRealmsNotification = true;
        }
        if (this.areRealmsNotificationsEnabled()) {
            this.realmsNotification.setGuiSize(this.width, this.height);
            this.realmsNotification.initGui();
        }
        if (Reflector.NotificationModUpdateScreen_init.exists()) {
            this.modUpdateNotification = (GuiScreen)Reflector.call(Reflector.NotificationModUpdateScreen_init, new Object[] { this, this.modButton });
        }
        this.imageButtons.clear();
        this.imageButtons.add(new ImageButton(new ResourceLocation("logo.png"), this.width / 2 - 70, this.height / 2 - 160, 150, 100, "89", 13));
    }
    
    @Override
    public void drawScreen(final int llllllllllllIIIIIlIlIIIIIIIIlllI, final int llllllllllllIIIIIlIlIIIIIIIIllIl, final float llllllllllllIIIIIlIlIIIIIIIIllII) {
        GlStateManager.disableCull();
        final ScaledResolution llllllllllllIIIIIlIlIIIIIIIlIIll = new ScaledResolution(this.mc);
        this.backgroundShader.useShader(llllllllllllIIIIIlIlIIIIIIIlIIll.getScaledWidth() + 80000, llllllllllllIIIIIlIlIIIIIIIlIIll.getScaledHeight(), (float)llllllllllllIIIIIlIlIIIIIIIIlllI, (float)llllllllllllIIIIIlIlIIIIIIIIllIl, (System.currentTimeMillis() - this.initTime) / 5000.0f);
        GL11.glBegin(7);
        GL11.glVertex2f(-1.0f, -1.0f);
        GL11.glVertex2f(-1.0f, 1.0f);
        GL11.glVertex2f(1.0f, 1.0f);
        GL11.glVertex2f(1.0f, -1.0f);
        GL11.glEnd();
        GL20.glUseProgram(0);
        GlStateManager.disableCull();
        DrawHelper.drawRect(llllllllllllIIIIIlIlIIIIIIIlIIll.getScaledWidth() / 2 - 65, llllllllllllIIIIIlIlIIIIIIIlIIll.getScaledHeight() / 2 - 75, llllllllllllIIIIIlIlIIIIIIIlIIll.getScaledWidth() / 2 + 65, llllllllllllIIIIIlIlIIIIIIIlIIll.getScaledHeight() / 2 + 50, new Color(0, 60, 70, 100).getRGB());
        this.mc.mntsb_30.drawCenteredStringWithShadow("ROCKSTAR", (float)(llllllllllllIIIIIlIlIIIIIIIlIIll.getScaledWidth() / 2), (float)(llllllllllllIIIIIlIlIIIIIIIlIIll.getScaledHeight() / 2 - 65), -1);
        super.drawScreen(llllllllllllIIIIIlIlIIIIIIIIlllI, llllllllllllIIIIIlIlIIIIIIIIllIl, llllllllllllIIIIIlIlIIIIIIIIllII);
        int llllllllllllIIIIIlIlIIIIIIIlIIlI = 10;
        final int llllllllllllIIIIIlIlIIIIIIIlIIIl = 3;
        for (final ChangeLog llllllllllllIIIIIlIlIIIIIIIlIIII : Main.instance.changeManager.getChangeLogs()) {
            GlStateManager.pushMatrix();
            if (llllllllllllIIIIIlIlIIIIIIIlIIII != null) {
                DrawHelper.scissorRect(0.0f, 2.0f, (float)(this.width / 2 - 20), this.height - 10);
                this.mc.sfui16.drawStringWithOutline(llllllllllllIIIIIlIlIIIIIIIlIIII.getLogName(), 3.0, llllllllllllIIIIIlIlIIIIIIIlIIlI - 0.1f, -1);
            }
            llllllllllllIIIIIlIlIIIIIIIlIIlI += 9;
            GlStateManager.popMatrix();
        }
    }
    
    public GuiMainMenu() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   net/minecraft/client/gui/GuiScreen.<init>:()V
        //     4: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //     5: new             Lru/rockstar/api/utils/world/TimerHelper;
        //     8: dup            
        //     9: invokespecial   ru/rockstar/api/utils/world/TimerHelper.<init>:()V
        //    12: putfield        net/minecraft/client/gui/GuiMainMenu.timerHelper:Lru/rockstar/api/utils/world/TimerHelper;
        //    15: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: invokespecial   java/util/ArrayList.<init>:()V
        //    23: putfield        net/minecraft/client/gui/GuiMainMenu.imageButtons:Ljava/util/ArrayList;
        //    26: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //    27: new             Ljava/lang/Object;
        //    30: dup            
        //    31: invokespecial   java/lang/Object.<init>:()V
        //    34: putfield        net/minecraft/client/gui/GuiMainMenu.threadLock:Ljava/lang/Object;
        //    37: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //    38: invokestatic    java/lang/System.currentTimeMillis:()J
        //    41: putfield        net/minecraft/client/gui/GuiMainMenu.initTime:J
        //    44: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //    45: getstatic       net/minecraft/client/gui/GuiMainMenu.MORE_INFO_TEXT:Ljava/lang/String;
        //    48: putfield        net/minecraft/client/gui/GuiMainMenu.openGLWarning2:Ljava/lang/String;
        //    51: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //    52: ldc_w           "missingno"
        //    55: putfield        net/minecraft/client/gui/GuiMainMenu.splashText:Ljava/lang/String;
        //    58: aconst_null    
        //    59: astore_1        /* llllllllllllIIIIIlIlIIIIllllIlIl */
        //    60: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //    61: new             Lru/rockstar/api/utils/render/glsandbox/animbackground;
        //    64: dup            
        //    65: ldc_w           "/noise.fsh"
        //    68: invokespecial   ru/rockstar/api/utils/render/glsandbox/animbackground.<init>:(Ljava/lang/String;)V
        //    71: putfield        net/minecraft/client/gui/GuiMainMenu.backgroundShader:Lru/rockstar/api/utils/render/glsandbox/animbackground;
        //    74: goto            90
        //    77: astore_2        /* llllllllllllIIIIIlIlIIIIlllllIll */
        //    78: new             Ljava/lang/IllegalStateException;
        //    81: dup            
        //    82: ldc_w           "Failed to load backgound shader"
        //    85: aload_2         /* llllllllllllIIIIIlIlIIIIlllllIll */
        //    86: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    89: athrow         
        //    90: invokestatic    com/google/common/collect/Lists.newArrayList:()Ljava/util/ArrayList;
        //    93: astore_2        /* llllllllllllIIIIIlIlIIIIlllllIlI */
        //    94: invokestatic    net/minecraft/client/Minecraft.getMinecraft:()Lnet/minecraft/client/Minecraft;
        //    97: invokevirtual   net/minecraft/client/Minecraft.getResourceManager:()Lnet/minecraft/client/resources/IResourceManager;
        //   100: getstatic       net/minecraft/client/gui/GuiMainMenu.SPLASH_TEXTS:Lnet/minecraft/util/ResourceLocation;
        //   103: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //   108: astore_1        /* llllllllllllIIIIIlIlIIIIllllllII */
        //   109: new             Ljava/io/BufferedReader;
        //   112: dup            
        //   113: new             Ljava/io/InputStreamReader;
        //   116: dup            
        //   117: aload_1         /* llllllllllllIIIIIlIlIIIIllllllII */
        //   118: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //   123: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //   126: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //   129: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   132: astore_3        /* llllllllllllIIIIIlIlIIIIllllIIll */
        //   133: goto            160
        //   136: aload           llllllllllllIIIIIlIlIIIIlllllIII
        //   138: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //   141: astore          llllllllllllIIIIIlIlIIIIlllllIII
        //   143: aload           llllllllllllIIIIIlIlIIIIlllllIII
        //   145: invokevirtual   java/lang/String.isEmpty:()Z
        //   148: ifne            160
        //   151: aload_2         /* llllllllllllIIIIIlIlIIIIlllllIlI */
        //   152: aload           llllllllllllIIIIIlIlIIIIlllllIII
        //   154: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   159: pop            
        //   160: aload_3         /* llllllllllllIIIIIlIlIIIIlllllIIl */
        //   161: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   164: dup            
        //   165: astore          llllllllllllIIIIIlIlIIIIllllIlll
        //   167: ifnonnull       136
        //   170: aload_2         /* llllllllllllIIIIIlIlIIIIlllllIlI */
        //   171: invokeinterface java/util/List.isEmpty:()Z
        //   176: ifne            237
        //   179: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //   180: aload_2         /* llllllllllllIIIIIlIlIIIIlllllIlI */
        //   181: getstatic       net/minecraft/client/gui/GuiMainMenu.RANDOM:Ljava/util/Random;
        //   184: aload_2         /* llllllllllllIIIIIlIlIIIIlllllIlI */
        //   185: invokeinterface java/util/List.size:()I
        //   190: invokevirtual   java/util/Random.nextInt:(I)I
        //   193: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   198: checkcast       Ljava/lang/String;
        //   201: putfield        net/minecraft/client/gui/GuiMainMenu.splashText:Ljava/lang/String;
        //   204: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //   205: getfield        net/minecraft/client/gui/GuiMainMenu.splashText:Ljava/lang/String;
        //   208: invokevirtual   java/lang/String.hashCode:()I
        //   211: ldc_w           125780783
        //   214: if_icmpeq       179
        //   217: goto            237
        //   220: astore_2       
        //   221: aload_1         /* llllllllllllIIIIIlIlIIIIllllllII */
        //   222: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   225: goto            241
        //   228: astore          llllllllllllIIIIIlIlIIIIllllIIIl
        //   230: aload_1         /* llllllllllllIIIIIlIlIIIIllllllII */
        //   231: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   234: aload           llllllllllllIIIIIlIlIIIIllllIIIl
        //   236: athrow         
        //   237: aload_1         /* llllllllllllIIIIIlIlIIIIllllllII */
        //   238: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   241: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //   242: getstatic       net/minecraft/client/gui/GuiMainMenu.RANDOM:Ljava/util/Random;
        //   245: invokevirtual   java/util/Random.nextFloat:()F
        //   248: putfield        net/minecraft/client/gui/GuiMainMenu.updateCounter:F
        //   251: aload_0         /* llllllllllllIIIIIlIlIIIIllllIllI */
        //   252: ldc_w           ""
        //   255: putfield        net/minecraft/client/gui/GuiMainMenu.openGLWarning1:Ljava/lang/String;
        //   258: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  60     74     77     90     Ljava/io/IOException;
        //  90     217    220    228    Ljava/io/IOException;
        //  90     221    228    237    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void updateScreen() {
        if (this.areRealmsNotificationsEnabled()) {
            this.realmsNotification.updateScreen();
        }
    }
    
    private void rotateAndBlurSkybox() {
        this.mc.getTextureManager().bindTexture(this.backgroundTexture);
        GlStateManager.glTexParameteri(3553, 10241, 9729);
        GlStateManager.glTexParameteri(3553, 10240, 9729);
        GlStateManager.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.colorMask(true, true, true, false);
        final Tessellator llllllllllllIIIIIlIlIIIIIlIlllIl = Tessellator.getInstance();
        final BufferBuilder llllllllllllIIIIIlIlIIIIIlIlllII = llllllllllllIIIIIlIlIIIIIlIlllIl.getBuffer();
        llllllllllllIIIIIlIlIIIIIlIlllII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        GlStateManager.disableAlpha();
        final int llllllllllllIIIIIlIlIIIIIlIllIll = 3;
        int llllllllllllIIIIIlIlIIIIIlIllIlI = 3;
        final CustomPanoramaProperties llllllllllllIIIIIlIlIIIIIlIllIIl = CustomPanorama.getCustomPanoramaProperties();
        if (llllllllllllIIIIIlIlIIIIIlIllIIl != null) {
            llllllllllllIIIIIlIlIIIIIlIllIlI = llllllllllllIIIIIlIlIIIIIlIllIIl.getBlur2();
        }
        for (int llllllllllllIIIIIlIlIIIIIlIllIII = 0; llllllllllllIIIIIlIlIIIIIlIllIII < llllllllllllIIIIIlIlIIIIIlIllIlI; ++llllllllllllIIIIIlIlIIIIIlIllIII) {
            final float llllllllllllIIIIIlIlIIIIIlIlIlll = 1.0f / (llllllllllllIIIIIlIlIIIIIlIllIII + 1);
            final int llllllllllllIIIIIlIlIIIIIlIlIllI = this.width;
            final int llllllllllllIIIIIlIlIIIIIlIlIlIl = this.height;
            final float llllllllllllIIIIIlIlIIIIIlIlIlII = (llllllllllllIIIIIlIlIIIIIlIllIII - 1) / 256.0f;
            llllllllllllIIIIIlIlIIIIIlIlllII.pos(llllllllllllIIIIIlIlIIIIIlIlIllI, llllllllllllIIIIIlIlIIIIIlIlIlIl, this.zLevel).tex(0.0f + llllllllllllIIIIIlIlIIIIIlIlIlII, 1.0).color(1.0f, 1.0f, 1.0f, llllllllllllIIIIIlIlIIIIIlIlIlll).endVertex();
            llllllllllllIIIIIlIlIIIIIlIlllII.pos(llllllllllllIIIIIlIlIIIIIlIlIllI, 0.0, this.zLevel).tex(1.0f + llllllllllllIIIIIlIlIIIIIlIlIlII, 1.0).color(1.0f, 1.0f, 1.0f, llllllllllllIIIIIlIlIIIIIlIlIlll).endVertex();
            llllllllllllIIIIIlIlIIIIIlIlllII.pos(0.0, 0.0, this.zLevel).tex(1.0f + llllllllllllIIIIIlIlIIIIIlIlIlII, 0.0).color(1.0f, 1.0f, 1.0f, llllllllllllIIIIIlIlIIIIIlIlIlll).endVertex();
            llllllllllllIIIIIlIlIIIIIlIlllII.pos(0.0, llllllllllllIIIIIlIlIIIIIlIlIlIl, this.zLevel).tex(0.0f + llllllllllllIIIIIlIlIIIIIlIlIlII, 0.0).color(1.0f, 1.0f, 1.0f, llllllllllllIIIIIlIlIIIIIlIlIlll).endVertex();
        }
        llllllllllllIIIIIlIlIIIIIlIlllIl.draw();
        GlStateManager.enableAlpha();
        GlStateManager.colorMask(true, true, true, true);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        RANDOM = new Random();
        GuiMainMenu.engine = new ParticleEngine();
        MORE_INFO_TEXT = "Please click " + TextFormatting.UNDERLINE + "here" + TextFormatting.RESET + " for more information.";
        SPLASH_TEXTS = new ResourceLocation("texts/splashes.txt");
        MINECRAFT_TITLE_TEXTURES = new ResourceLocation("textures/gui/title/minecraft.png");
        field_194400_H = new ResourceLocation("textures/gui/title/edition.png");
        TITLE_PANORAMA_PATHS = new ResourceLocation[] { new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png") };
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllIIIIIlIlIIIIlIlIIIIl, final int llllllllllllIIIIIlIlIIIIlIlIIIII) {
        if (llllllllllllIIIIIlIlIIIIlIlIIIIl && llllllllllllIIIIIlIlIIIIlIlIIIII == 12) {
            final ISaveFormat llllllllllllIIIIIlIlIIIIlIIlllll = this.mc.getSaveLoader();
            llllllllllllIIIIIlIlIIIIlIIlllll.flushCache();
            llllllllllllIIIIIlIlIIIIlIIlllll.deleteWorldDirectory("Demo_World");
            this.mc.displayGuiScreen(this);
        }
        else if (llllllllllllIIIIIlIlIIIIlIlIIIII == 12) {
            this.mc.displayGuiScreen(this);
        }
        else if (llllllllllllIIIIIlIlIIIIlIlIIIII == 13) {
            if (llllllllllllIIIIIlIlIIIIlIlIIIIl) {
                try {
                    final Class<?> llllllllllllIIIIIlIlIIIIlIIllllI = Class.forName("java.awt.Desktop");
                    final Object llllllllllllIIIIIlIlIIIIlIIlllIl = llllllllllllIIIIIlIlIIIIlIIllllI.getMethod("getDesktop", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
                    llllllllllllIIIIIlIlIIIIlIIllllI.getMethod("browse", URI.class).invoke(llllllllllllIIIIIlIlIIIIlIIlllIl, new URI(this.openGLWarningLink));
                }
                catch (Throwable llllllllllllIIIIIlIlIIIIlIIlllII) {
                    GuiMainMenu.LOGGER.error("Couldn't open link", llllllllllllIIIIIlIlIIIIlIIlllII);
                }
            }
            this.mc.displayGuiScreen(this);
        }
    }
    
    private void addSingleplayerMultiplayerButtons(final int llllllllllllIIIIIlIlIIIIllIIlIll, final int llllllllllllIIIIIlIlIIIIllIIlllI) {
        final ScaledResolution llllllllllllIIIIIlIlIIIIllIIllIl = new ScaledResolution(this.mc);
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50, llllllllllllIIIIIlIlIIIIllIIllIl.getScaledHeight() / 2 - 49, 100, 17, I18n.format("Singleplayer", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 50, llllllllllllIIIIIlIlIIIIllIIllIl.getScaledHeight() / 2 - 31, 100, 17, I18n.format("Multiplayer", new Object[0])));
        if (Reflector.GuiModList_Constructor.exists()) {
            this.realmsButton = this.addButton(new GuiButton(14, this.width / 2, llllllllllllIIIIIlIlIIIIllIIlIll + llllllllllllIIIIIlIlIIIIllIIlllI * 2, 98, 20, I18n.format("menu.online", new Object[0]).replace("Minecraft", "").trim()));
            final List<GuiButton> buttonList = this.buttonList;
            final GuiButton modButton = new GuiButton(6, this.width / 2 - 110, llllllllllllIIIIIlIlIIIIllIIlIll + llllllllllllIIIIIlIlIIIIllIIlllI * 2, 98, 20, I18n.format("fml.menu.mods", new Object[0]));
            this.modButton = modButton;
            buttonList.add(modButton);
        }
        else {
            this.realmsButton = this.addButton(new GuiButton(14, this.width / 2 - 50, llllllllllllIIIIIlIlIIIIllIIllIl.getScaledHeight() / 2 - 13, 100, 17, I18n.format("Alt Manager", new Object[0])));
        }
    }
}
