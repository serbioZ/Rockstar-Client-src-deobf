// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.renderer.texture.TextureManager;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import ru.rockstar.api.utils.Helper;

public class SplashProgress implements Helper
{
    public static /* synthetic */ int Progress;
    public static /* synthetic */ ResourceLocation resourceLocation;
    public static /* synthetic */ FontRenderer fontRenderer;
    public static /* synthetic */ int maxProgress;
    
    private static void drawProgress() {
        if (SplashProgress.mc.gameSettings == null) {
            return;
        }
        final float lllllllllllIlIlllIllIlIllIIllIll = SplashProgress.Progress / 7.0f * SplashProgress.sr.getScaledWidth() * 0.595f;
        GlStateManager.resetColor();
        GlStateManager.TextureState.textureName = -1;
        DrawHelper.drawCircle(10.0f, (float)(SplashProgress.sr.getScaledHeight() - 10), 0.0f, 360.0f, 4.5f, 1.0f, false, new Color(100, 100, 100));
        DrawHelper.drawCircle(10.0f, (float)(SplashProgress.sr.getScaledHeight() - 10), -60.0f, 300.0f, 5.5f, 1.0f, false, new Color(100, 100, 100));
        DrawHelper.drawCircle(10.0f, (float)(SplashProgress.sr.getScaledHeight() - 10), (float)(SplashProgress.sr.getScaledHeight() - 97), 86.0f + lllllllllllIlIlllIllIlIllIIllIll, 5.0f, 1.0f, false, new Color(0, 255, 255));
    }
    
    public static void drawSplash(final TextureManager lllllllllllIlIlllIllIlIllIIlllll) {
        SplashProgress.fontRenderer = new FontRenderer(SplashProgress.mc.gameSettings, new ResourceLocation("textures/font/ascii.png"), SplashProgress.mc.getTextureManager(), false);
        if (SplashProgress.mc.gameSettings.language != null) {
            SplashProgress.fontRenderer.setUnicodeFlag(SplashProgress.mc.isUnicode());
            SplashProgress.fontRenderer.setBidiFlag(SplashProgress.mc.mcLanguageManager.isCurrentLanguageBidirectional());
        }
        SplashProgress.mc.mcResourceManager.registerReloadListener(SplashProgress.fontRenderer);
        final int lllllllllllIlIlllIllIlIllIlIIIIl = ScaledResolution.getScaleFactor();
        final Framebuffer lllllllllllIlIlllIllIlIllIlIIIII = new Framebuffer(SplashProgress.sr.getScaledWidth() * lllllllllllIlIlllIllIlIllIlIIIIl, SplashProgress.sr.getScaledHeight() * lllllllllllIlIlllIllIlIllIlIIIIl, true);
        lllllllllllIlIlllIllIlIllIlIIIII.bindFramebuffer(false);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, SplashProgress.sr.getScaledWidth(), SplashProgress.sr.getScaledHeight(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        lllllllllllIlIlllIllIlIllIIlllll.bindTexture(SplashProgress.resourceLocation);
        GlStateManager.resetColor();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Gui.drawScaledCustomSizeModalRect(0, 0, 0.0f, 0.0f, SplashProgress.sr.getScaledWidth(), SplashProgress.sr.getScaledHeight(), SplashProgress.sr.getScaledWidth(), SplashProgress.sr.getScaledHeight(), (float)SplashProgress.sr.getScaledWidth(), (float)SplashProgress.sr.getScaledHeight());
        drawProgress();
        lllllllllllIlIlllIllIlIllIlIIIII.unbindFramebuffer();
        lllllllllllIlIlllIllIlIllIlIIIII.framebufferRender(SplashProgress.sr.getScaledWidth() * lllllllllllIlIlllIllIlIllIlIIIIl, SplashProgress.sr.getScaledHeight() * lllllllllllIlIlllIllIlIllIlIIIIl);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        SplashProgress.mc.updateDisplay();
    }
    
    public static void setProgress(final int lllllllllllIlIlllIllIlIllIlIIlll) {
        SplashProgress.Progress = lllllllllllIlIlllIllIlIllIlIIlll;
        update();
    }
    
    static {
        SplashProgress.resourceLocation = new ResourceLocation("rockstar/launch.png");
        SplashProgress.maxProgress = 7;
    }
    
    public static void update() {
        drawSplash(SplashProgress.mc.getTextureManager());
    }
}
