// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.shader;

import org.lwjgl.opengl.GL20;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;

public abstract class FramebufferShader extends Shader
{
    protected /* synthetic */ float red;
    private /* synthetic */ Framebuffer framebuffer;
    protected /* synthetic */ float saturation;
    protected /* synthetic */ float y;
    protected /* synthetic */ float alpha;
    protected /* synthetic */ float quality;
    protected /* synthetic */ float radius;
    public static /* synthetic */ Minecraft mc;
    protected /* synthetic */ float speed;
    protected /* synthetic */ float green;
    protected /* synthetic */ float x;
    protected /* synthetic */ float blue;
    private /* synthetic */ boolean entityShadows;
    
    public Framebuffer getFramebuffer() {
        return this.framebuffer;
    }
    
    public void stopDraw(final Color lllllllllllllIIIIllIlIlIIllIIIIl, final float lllllllllllllIIIIllIlIlIIllIIIII, final float lllllllllllllIIIIllIlIlIIlIlllll, final float lllllllllllllIIIIllIlIlIIlIllllI, final float lllllllllllllIIIIllIlIlIIllIIlIl, final float lllllllllllllIIIIllIlIlIIlIlllII, final float lllllllllllllIIIIllIlIlIIlIllIll) {
        FramebufferShader.mc.gameSettings.entityShadows = this.entityShadows;
        this.framebuffer.unbindFramebuffer();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        FramebufferShader.mc.getFramebuffer().bindFramebuffer(true);
        this.saturation = lllllllllllllIIIIllIlIlIIlIllllI;
        this.speed = lllllllllllllIIIIllIlIlIIllIIlIl;
        this.x = lllllllllllllIIIIllIlIlIIlIlllII;
        this.y = lllllllllllllIIIIllIlIlIIlIllIll;
        this.red = lllllllllllllIIIIllIlIlIIllIIIIl.getRed() / 255.0f;
        this.green = lllllllllllllIIIIllIlIlIIllIIIIl.getGreen() / 255.0f;
        this.blue = lllllllllllllIIIIllIlIlIIllIIIIl.getBlue() / 255.0f;
        this.alpha = lllllllllllllIIIIllIlIlIIllIIIIl.getAlpha() / 255.0f;
        this.radius = lllllllllllllIIIIllIlIlIIllIIIII;
        this.quality = lllllllllllllIIIIllIlIlIIlIlllll;
        FramebufferShader.mc.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        this.startShader();
        FramebufferShader.mc.entityRenderer.setupOverlayRendering();
        this.drawFramebuffer(this.framebuffer);
        this.stopShader();
        FramebufferShader.mc.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }
    
    public void drawFramebuffer(final Framebuffer lllllllllllllIIIIllIlIlIIlIlIIIl) {
        final ScaledResolution lllllllllllllIIIIllIlIlIIlIlIIlI = new ScaledResolution(FramebufferShader.mc);
        GL11.glBindTexture(3553, lllllllllllllIIIIllIlIlIIlIlIIIl.framebufferTexture);
        GL11.glBegin(7);
        GL11.glTexCoord2d(0.0, 1.0);
        GL11.glVertex2d(0.0, 0.0);
        GL11.glTexCoord2d(0.0, 0.0);
        GL11.glVertex2d(0.0, (double)lllllllllllllIIIIllIlIlIIlIlIIlI.getScaledHeight());
        GL11.glTexCoord2d(1.0, 0.0);
        GL11.glVertex2d((double)lllllllllllllIIIIllIlIlIIlIlIIlI.getScaledWidth(), (double)lllllllllllllIIIIllIlIlIIlIlIIlI.getScaledHeight());
        GL11.glTexCoord2d(1.0, 1.0);
        GL11.glVertex2d((double)lllllllllllllIIIIllIlIlIIlIlIIlI.getScaledWidth(), 0.0);
        GL11.glEnd();
        GL20.glUseProgram(0);
    }
    
    public Framebuffer setupFrameBuffer(Framebuffer lllllllllllllIIIIllIlIlIIlIlIlll) {
        if (lllllllllllllIIIIllIlIlIIlIlIlll == null) {
            return new Framebuffer(FramebufferShader.mc.displayWidth, FramebufferShader.mc.displayHeight, true);
        }
        if (((Framebuffer)lllllllllllllIIIIllIlIlIIlIlIlll).framebufferWidth != FramebufferShader.mc.displayWidth || ((Framebuffer)lllllllllllllIIIIllIlIlIIlIlIlll).framebufferHeight != FramebufferShader.mc.displayHeight) {
            ((Framebuffer)lllllllllllllIIIIllIlIlIIlIlIlll).deleteFramebuffer();
            lllllllllllllIIIIllIlIlIIlIlIlll = new Framebuffer(FramebufferShader.mc.displayWidth, FramebufferShader.mc.displayHeight, true);
        }
        return (Framebuffer)lllllllllllllIIIIllIlIlIIlIlIlll;
    }
    
    public FramebufferShader(final String lllllllllllllIIIIllIlIlIIllllIll) {
        super(lllllllllllllIIIIllIlIlIIllllIll);
        this.alpha = 1.0f;
        this.radius = 2.0f;
        this.quality = 1.0f;
    }
    
    public void startDraw(final float lllllllllllllIIIIllIlIlIIlllIlIl) {
        GlStateManager.enableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        final Framebuffer setupFrameBuffer = this.setupFrameBuffer(this.framebuffer);
        this.framebuffer = setupFrameBuffer;
        setupFrameBuffer.framebufferClear();
        this.framebuffer.bindFramebuffer(true);
        this.entityShadows = FramebufferShader.mc.gameSettings.entityShadows;
        FramebufferShader.mc.gameSettings.entityShadows = false;
        FramebufferShader.mc.entityRenderer.setupCameraTransform(lllllllllllllIIIIllIlIlIIlllIlIl, 0);
    }
    
    static {
        FramebufferShader.mc = Minecraft.getMinecraft();
    }
}
