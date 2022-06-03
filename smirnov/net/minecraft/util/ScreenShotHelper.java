// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import java.util.Date;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.TextComponentString;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import optifine.Reflector;
import optifine.Config;
import net.minecraft.util.text.ITextComponent;
import javax.annotation.Nullable;
import java.io.File;
import net.minecraft.client.gui.ScaledResolution;
import java.text.SimpleDateFormat;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.BufferUtils;
import net.minecraft.client.renderer.OpenGlHelper;
import java.awt.image.BufferedImage;
import net.minecraft.client.shader.Framebuffer;
import java.nio.IntBuffer;
import org.apache.logging.log4j.Logger;
import java.text.DateFormat;

public class ScreenShotHelper
{
    private static final /* synthetic */ DateFormat DATE_FORMAT;
    private static final /* synthetic */ Logger LOGGER;
    private static /* synthetic */ IntBuffer pixelBuffer;
    private static /* synthetic */ int[] pixelValues;
    
    public static BufferedImage createScreenshot(int llllllllllllIIIllIIllIlllIllIlll, int llllllllllllIIIllIIllIlllIllIllI, final Framebuffer llllllllllllIIIllIIllIlllIllIlIl) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            llllllllllllIIIllIIllIlllIllIlll = llllllllllllIIIllIIllIlllIllIlIl.framebufferTextureWidth;
            llllllllllllIIIllIIllIlllIllIllI = llllllllllllIIIllIIllIlllIllIlIl.framebufferTextureHeight;
        }
        final int llllllllllllIIIllIIllIlllIlllIIl = llllllllllllIIIllIIllIlllIllIlll * llllllllllllIIIllIIllIlllIllIllI;
        if (ScreenShotHelper.pixelBuffer == null || ScreenShotHelper.pixelBuffer.capacity() < llllllllllllIIIllIIllIlllIlllIIl) {
            ScreenShotHelper.pixelBuffer = BufferUtils.createIntBuffer(llllllllllllIIIllIIllIlllIlllIIl);
            ScreenShotHelper.pixelValues = new int[llllllllllllIIIllIIllIlllIlllIIl];
        }
        GlStateManager.glPixelStorei(3333, 1);
        GlStateManager.glPixelStorei(3317, 1);
        ScreenShotHelper.pixelBuffer.clear();
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.bindTexture(llllllllllllIIIllIIllIlllIllIlIl.framebufferTexture);
            GlStateManager.glGetTexImage(3553, 0, 32993, 33639, ScreenShotHelper.pixelBuffer);
        }
        else {
            GlStateManager.glReadPixels(0, 0, llllllllllllIIIllIIllIlllIllIlll, llllllllllllIIIllIIllIlllIllIllI, 32993, 33639, ScreenShotHelper.pixelBuffer);
        }
        ScreenShotHelper.pixelBuffer.get(ScreenShotHelper.pixelValues);
        TextureUtil.processPixelValues(ScreenShotHelper.pixelValues, llllllllllllIIIllIIllIlllIllIlll, llllllllllllIIIllIIllIlllIllIllI);
        final BufferedImage llllllllllllIIIllIIllIlllIlllIII = new BufferedImage(llllllllllllIIIllIIllIlllIllIlll, llllllllllllIIIllIIllIlllIllIllI, 1);
        llllllllllllIIIllIIllIlllIlllIII.setRGB(0, 0, llllllllllllIIIllIIllIlllIllIlll, llllllllllllIIIllIIllIlllIllIllI, ScreenShotHelper.pixelValues, 0, llllllllllllIIIllIIllIlllIllIlll);
        return llllllllllllIIIllIIllIlllIlllIII;
    }
    
    private static void updateFramebufferSize() {
        final Minecraft llllllllllllIIIllIIllIlllIIllIIl = Minecraft.getMinecraft();
        llllllllllllIIIllIIllIlllIIllIIl.getFramebuffer().createBindFramebuffer(llllllllllllIIIllIIllIlllIIllIIl.displayWidth, llllllllllllIIIllIIllIlllIIllIIl.displayHeight);
        if (llllllllllllIIIllIIllIlllIIllIIl.entityRenderer != null) {
            llllllllllllIIIllIIllIlllIIllIIl.entityRenderer.updateShaderGroupSize(llllllllllllIIIllIIllIlllIIllIIl.displayWidth, llllllllllllIIIllIIllIlllIIllIIl.displayHeight);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    }
    
    private static void resize(final int llllllllllllIIIllIIllIlllIIllllI, final int llllllllllllIIIllIIllIlllIIlllIl) {
        final Minecraft llllllllllllIIIllIIllIlllIlIIIII = Minecraft.getMinecraft();
        llllllllllllIIIllIIllIlllIlIIIII.displayWidth = Math.max(1, llllllllllllIIIllIIllIlllIIllllI);
        llllllllllllIIIllIIllIlllIlIIIII.displayHeight = Math.max(1, llllllllllllIIIllIIllIlllIIlllIl);
        if (llllllllllllIIIllIIllIlllIlIIIII.currentScreen != null) {
            final ScaledResolution llllllllllllIIIllIIllIlllIIlllll = new ScaledResolution(llllllllllllIIIllIIllIlllIlIIIII);
            llllllllllllIIIllIIllIlllIlIIIII.currentScreen.onResize(llllllllllllIIIllIIllIlllIlIIIII, llllllllllllIIIllIIllIlllIIlllll.getScaledWidth(), llllllllllllIIIllIIllIlllIIlllll.getScaledHeight());
        }
        updateFramebufferSize();
    }
    
    public static ITextComponent saveScreenshot(final File llllllllllllIIIllIIllIlllllIIlIl, @Nullable final String llllllllllllIIIllIIllIlllllIIlII, final int llllllllllllIIIllIIllIllllIlIIII, final int llllllllllllIIIllIIllIllllIIllll, final Framebuffer llllllllllllIIIllIIllIlllllIIIIl) {
        try {
            final File llllllllllllIIIllIIllIlllllIIIII = new File(llllllllllllIIIllIIllIlllllIIlIl, "screenshots");
            llllllllllllIIIllIIllIlllllIIIII.mkdir();
            final Minecraft llllllllllllIIIllIIllIllllIlllll = Minecraft.getMinecraft();
            final int llllllllllllIIIllIIllIllllIllllI = Config.getGameSettings().guiScale;
            final ScaledResolution llllllllllllIIIllIIllIllllIlllIl = new ScaledResolution(llllllllllllIIIllIIllIllllIlllll);
            final int llllllllllllIIIllIIllIllllIlllII = ScaledResolution.getScaleFactor();
            final int llllllllllllIIIllIIllIllllIllIll = Config.getScreenshotSize();
            final boolean llllllllllllIIIllIIllIllllIllIlI = OpenGlHelper.isFramebufferEnabled() && llllllllllllIIIllIIllIllllIllIll > 1;
            if (llllllllllllIIIllIIllIllllIllIlI) {
                Config.getGameSettings().guiScale = llllllllllllIIIllIIllIllllIlllII * llllllllllllIIIllIIllIllllIllIll;
                resize(llllllllllllIIIllIIllIllllIlIIII * llllllllllllIIIllIIllIllllIllIll, llllllllllllIIIllIIllIllllIIllll * llllllllllllIIIllIIllIllllIllIll);
                GlStateManager.pushMatrix();
                GlStateManager.clear(16640);
                llllllllllllIIIllIIllIllllIlllll.getFramebuffer().bindFramebuffer(true);
                llllllllllllIIIllIIllIllllIlllll.entityRenderer.updateCameraAndRender(llllllllllllIIIllIIllIllllIlllll.getRenderPartialTicks(), System.nanoTime());
            }
            final BufferedImage llllllllllllIIIllIIllIllllIllIIl = createScreenshot(llllllllllllIIIllIIllIllllIlIIII, llllllllllllIIIllIIllIllllIIllll, llllllllllllIIIllIIllIlllllIIIIl);
            if (llllllllllllIIIllIIllIllllIllIlI) {
                llllllllllllIIIllIIllIllllIlllll.getFramebuffer().unbindFramebuffer();
                GlStateManager.popMatrix();
                Config.getGameSettings().guiScale = llllllllllllIIIllIIllIllllIllllI;
                resize(llllllllllllIIIllIIllIllllIlIIII, llllllllllllIIIllIIllIllllIIllll);
            }
            File llllllllllllIIIllIIllIllllIlIlll = null;
            if (llllllllllllIIIllIIllIlllllIIlII == null) {
                final File llllllllllllIIIllIIllIllllIllIII = getTimestampedPNGFileForDirectory(llllllllllllIIIllIIllIlllllIIIII);
            }
            else {
                llllllllllllIIIllIIllIllllIlIlll = new File(llllllllllllIIIllIIllIlllllIIIII, llllllllllllIIIllIIllIlllllIIlII);
            }
            llllllllllllIIIllIIllIllllIlIlll = llllllllllllIIIllIIllIllllIlIlll.getCanonicalFile();
            Object llllllllllllIIIllIIllIllllIlIllI = null;
            if (Reflector.ForgeHooksClient_onScreenshot.exists()) {
                llllllllllllIIIllIIllIllllIlIllI = Reflector.call(Reflector.ForgeHooksClient_onScreenshot, new Object[] { llllllllllllIIIllIIllIllllIllIIl, llllllllllllIIIllIIllIllllIlIlll });
                if (Reflector.callBoolean(llllllllllllIIIllIIllIllllIlIllI, Reflector.Event_isCanceled, new Object[0])) {
                    return (ITextComponent)Reflector.call(llllllllllllIIIllIIllIllllIlIllI, Reflector.ScreenshotEvent_getCancelMessage, new Object[0]);
                }
                llllllllllllIIIllIIllIllllIlIlll = (File)Reflector.call(llllllllllllIIIllIIllIllllIlIllI, Reflector.ScreenshotEvent_getScreenshotFile, new Object[0]);
            }
            ImageIO.write(llllllllllllIIIllIIllIllllIllIIl, "png", llllllllllllIIIllIIllIllllIlIlll);
            final ITextComponent llllllllllllIIIllIIllIllllIlIlIl = new TextComponentString(llllllllllllIIIllIIllIllllIlIlll.getName());
            llllllllllllIIIllIIllIllllIlIlIl.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, llllllllllllIIIllIIllIllllIlIlll.getAbsolutePath()));
            llllllllllllIIIllIIllIllllIlIlIl.getStyle().setUnderlined(true);
            if (llllllllllllIIIllIIllIllllIlIllI != null) {
                final ITextComponent llllllllllllIIIllIIllIllllIlIlII = (ITextComponent)Reflector.call(llllllllllllIIIllIIllIllllIlIllI, Reflector.ScreenshotEvent_getResultMessage, new Object[0]);
                if (llllllllllllIIIllIIllIllllIlIlII != null) {
                    return llllllllllllIIIllIIllIllllIlIlII;
                }
            }
            return new TextComponentTranslation("screenshot.success", new Object[] { llllllllllllIIIllIIllIllllIlIlIl });
        }
        catch (Exception llllllllllllIIIllIIllIllllIlIIll) {
            ScreenShotHelper.LOGGER.warn("Couldn't save screenshot", (Throwable)llllllllllllIIIllIIllIllllIlIIll);
            return new TextComponentTranslation("screenshot.failure", new Object[] { llllllllllllIIIllIIllIllllIlIIll.getMessage() });
        }
    }
    
    private static File getTimestampedPNGFileForDirectory(final File llllllllllllIIIllIIllIlllIlIlllI) {
        final String llllllllllllIIIllIIllIlllIlIllIl = ScreenShotHelper.DATE_FORMAT.format(new Date()).toString();
        int llllllllllllIIIllIIllIlllIlIllII = 1;
        File llllllllllllIIIllIIllIlllIlIlIll;
        while (true) {
            llllllllllllIIIllIIllIlllIlIlIll = new File(llllllllllllIIIllIIllIlllIlIlllI, String.valueOf(llllllllllllIIIllIIllIlllIlIllIl) + ((llllllllllllIIIllIIllIlllIlIllII == 1) ? "" : ("_" + llllllllllllIIIllIIllIlllIlIllII)) + ".png");
            if (!llllllllllllIIIllIIllIlllIlIlIll.exists()) {
                break;
            }
            ++llllllllllllIIIllIIllIlllIlIllII;
        }
        return llllllllllllIIIllIIllIlllIlIlIll;
    }
    
    public static ITextComponent saveScreenshot(final File llllllllllllIIIllIIllIlllllllllI, final int llllllllllllIIIllIIllIlllllllIIl, final int llllllllllllIIIllIIllIlllllllIII, final Framebuffer llllllllllllIIIllIIllIllllllIlll) {
        return saveScreenshot(llllllllllllIIIllIIllIlllllllllI, null, llllllllllllIIIllIIllIlllllllIIl, llllllllllllIIIllIIllIlllllllIII, llllllllllllIIIllIIllIllllllIlll);
    }
}
