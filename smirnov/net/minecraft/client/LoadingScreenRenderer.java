// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client;

import net.minecraft.client.renderer.BufferBuilder;
import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.api.utils.render.ClientHelper;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MinecraftError;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.IProgressUpdate;

public class LoadingScreenRenderer implements IProgressUpdate
{
    private /* synthetic */ boolean loadingSuccess;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ String currentlyDisplayedText;
    private /* synthetic */ String message;
    private final /* synthetic */ ScaledResolution scaledResolution;
    private /* synthetic */ long systemTime;
    private final /* synthetic */ Framebuffer framebuffer;
    
    private void displayString(final String lllllllllllIlIIIlIIlIllllIlIIlll) {
        this.currentlyDisplayedText = lllllllllllIlIIIlIIlIllllIlIIlll;
        if (!this.mc.running) {
            if (!this.loadingSuccess) {
                throw new MinecraftError();
            }
        }
        else {
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            if (OpenGlHelper.isFramebufferEnabled()) {
                final int lllllllllllIlIIIlIIlIllllIlIIllI = ScaledResolution.getScaleFactor();
                GlStateManager.ortho(0.0, this.scaledResolution.getScaledWidth() * lllllllllllIlIIIlIIlIllllIlIIllI, this.scaledResolution.getScaledHeight() * lllllllllllIlIIIlIIlIllllIlIIllI, 0.0, 100.0, 300.0);
            }
            else {
                final ScaledResolution lllllllllllIlIIIlIIlIllllIlIIlIl = new ScaledResolution(this.mc);
                GlStateManager.ortho(0.0, lllllllllllIlIIIlIIlIllllIlIIlIl.getScaledWidth_double(), lllllllllllIlIIIlIIlIllllIlIIlIl.getScaledHeight_double(), 0.0, 100.0, 300.0);
            }
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -200.0f);
        }
    }
    
    @Override
    public void displaySavingString(final String lllllllllllIlIIIlIIlIllllIlIlllI) {
        this.loadingSuccess = true;
        this.displayString(lllllllllllIlIIIlIIlIllllIlIlllI);
    }
    
    @Override
    public void displayLoadingString(final String lllllllllllIlIIIlIIlIllllIIllllI) {
        if (!this.mc.running) {
            if (!this.loadingSuccess) {
                throw new MinecraftError();
            }
        }
        else {
            this.systemTime = 0L;
            this.message = lllllllllllIlIIIlIIlIllllIIllllI;
            this.setLoadingProgress(-1);
            this.systemTime = 0L;
        }
    }
    
    @Override
    public void setDoneWorking() {
    }
    
    @Override
    public void resetProgressAndMessage(final String lllllllllllIlIIIlIIlIllllIllIlII) {
        this.loadingSuccess = false;
        this.displayString(lllllllllllIlIIIlIIlIllllIllIlII);
    }
    
    @Override
    public void setLoadingProgress(final int lllllllllllIlIIIlIIlIllllIIIllII) {
        if (!this.mc.running) {
            if (!this.loadingSuccess) {
                throw new MinecraftError();
            }
        }
        else {
            final long lllllllllllIlIIIlIIlIllllIIIlIll = Minecraft.getSystemTime();
            if (lllllllllllIlIIIlIIlIllllIIIlIll - this.systemTime >= 100L) {
                this.systemTime = lllllllllllIlIIIlIIlIllllIIIlIll;
                final ScaledResolution lllllllllllIlIIIlIIlIllllIIIlIlI = new ScaledResolution(this.mc);
                final int lllllllllllIlIIIlIIlIllllIIIlIIl = ScaledResolution.getScaleFactor();
                final int lllllllllllIlIIIlIIlIllllIIIlIII = lllllllllllIlIIIlIIlIllllIIIlIlI.getScaledWidth();
                final int lllllllllllIlIIIlIIlIllllIIIIlll = lllllllllllIlIIIlIIlIllllIIIlIlI.getScaledHeight();
                if (OpenGlHelper.isFramebufferEnabled()) {
                    this.framebuffer.framebufferClear();
                }
                else {
                    GlStateManager.clear(256);
                }
                this.framebuffer.bindFramebuffer(false);
                GlStateManager.matrixMode(5889);
                GlStateManager.loadIdentity();
                GlStateManager.ortho(0.0, lllllllllllIlIIIlIIlIllllIIIlIlI.getScaledWidth_double(), lllllllllllIlIIIlIIlIllllIIIlIlI.getScaledHeight_double(), 0.0, 100.0, 300.0);
                GlStateManager.matrixMode(5888);
                GlStateManager.loadIdentity();
                GlStateManager.translate(0.0f, 0.0f, -200.0f);
                if (!OpenGlHelper.isFramebufferEnabled()) {
                    GlStateManager.clear(16640);
                }
                final Tessellator lllllllllllIlIIIlIIlIllllIIIIllI = Tessellator.getInstance();
                final BufferBuilder lllllllllllIlIIIlIIlIllllIIIIlIl = lllllllllllIlIIIlIIlIllllIIIIllI.getBuffer();
                this.mc.getTextureManager().bindTexture(Gui.OPTIONS_BACKGROUND);
                final float lllllllllllIlIIIlIIlIllllIIIIlII = 32.0f;
                lllllllllllIlIIIlIIlIllllIIIIlIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                lllllllllllIlIIIlIIlIllllIIIIlIl.pos(0.0, lllllllllllIlIIIlIIlIllllIIIIlll, 0.0).tex(0.0, lllllllllllIlIIIlIIlIllllIIIIlll / 32.0f).color(64, 64, 64, 255).endVertex();
                lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIlIII, lllllllllllIlIIIlIIlIllllIIIIlll, 0.0).tex(lllllllllllIlIIIlIIlIllllIIIlIII / 32.0f, lllllllllllIlIIIlIIlIllllIIIIlll / 32.0f).color(64, 64, 64, 255).endVertex();
                lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIlIII, 0.0, 0.0).tex(lllllllllllIlIIIlIIlIllllIIIlIII / 32.0f, 0.0).color(64, 64, 64, 255).endVertex();
                lllllllllllIlIIIlIIlIllllIIIIlIl.pos(0.0, 0.0, 0.0).tex(0.0, 0.0).color(64, 64, 64, 255).endVertex();
                lllllllllllIlIIIlIIlIllllIIIIllI.draw();
                if (lllllllllllIlIIIlIIlIllllIIIllII >= 0) {
                    final int lllllllllllIlIIIlIIlIllllIIIIIll = 100;
                    final int lllllllllllIlIIIlIIlIllllIIIIIlI = 2;
                    final int lllllllllllIlIIIlIIlIllllIIIIIIl = lllllllllllIlIIIlIIlIllllIIIlIII / 2 - 50;
                    final int lllllllllllIlIIIlIIlIllllIIIIIII = lllllllllllIlIIIlIIlIllllIIIIlll / 2 + 16;
                    GlStateManager.disableTexture2D();
                    lllllllllllIlIIIlIIlIllllIIIIlIl.begin(7, DefaultVertexFormats.POSITION_COLOR);
                    lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIIIIl, lllllllllllIlIIIlIIlIllllIIIIIII, 0.0).color(128, 128, 128, 255).endVertex();
                    lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIIIIl, lllllllllllIlIIIlIIlIllllIIIIIII + 2, 0.0).color(128, 128, 128, 255).endVertex();
                    lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIIIIl + 100, lllllllllllIlIIIlIIlIllllIIIIIII + 2, 0.0).color(128, 128, 128, 255).endVertex();
                    lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIIIIl + 100, lllllllllllIlIIIlIIlIllllIIIIIII, 0.0).color(128, 128, 128, 255).endVertex();
                    lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIIIIl, lllllllllllIlIIIlIIlIllllIIIIIII, 0.0).color(128, 255, 128, 255).endVertex();
                    lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIIIIl, lllllllllllIlIIIlIIlIllllIIIIIII + 2, 0.0).color(128, 255, 128, 255).endVertex();
                    lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIIIIl + lllllllllllIlIIIlIIlIllllIIIllII, lllllllllllIlIIIlIIlIllllIIIIIII + 2, 0.0).color(128, 255, 128, 255).endVertex();
                    lllllllllllIlIIIlIIlIllllIIIIlIl.pos(lllllllllllIlIIIlIIlIllllIIIIIIl + lllllllllllIlIIIlIIlIllllIIIllII, lllllllllllIlIIIlIIlIllllIIIIIII, 0.0).color(128, 255, 128, 255).endVertex();
                    lllllllllllIlIIIlIIlIllllIIIIllI.draw();
                    GlStateManager.enableTexture2D();
                }
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                Minecraft.fontRendererObj.drawStringWithShadow(this.currentlyDisplayedText, (float)((lllllllllllIlIIIlIIlIllllIIIlIII - Minecraft.fontRendererObj.getStringWidth(this.currentlyDisplayedText)) / 2), (float)(lllllllllllIlIIIlIIlIllllIIIIlll / 2 - 4 - 16), 16777215);
                Minecraft.fontRendererObj.drawStringWithShadow(this.message, (float)((lllllllllllIlIIIlIIlIllllIIIlIII - Minecraft.fontRendererObj.getStringWidth(this.message)) / 2), (float)(lllllllllllIlIIIlIIlIllllIIIIlll / 2 - 4 + 8), 16777215);
                this.framebuffer.unbindFramebuffer();
                if (OpenGlHelper.isFramebufferEnabled()) {
                    this.framebuffer.framebufferRender(lllllllllllIlIIIlIIlIllllIIIlIII * lllllllllllIlIIIlIIlIllllIIIlIIl, lllllllllllIlIIIlIIlIllllIIIIlll * lllllllllllIlIIIlIIlIllllIIIlIIl);
                }
                this.mc.updateDisplay();
                try {
                    Thread.yield();
                }
                catch (Exception ex) {}
                for (int lllllllllllIlIIIlIIlIlllIlllllll = 0; lllllllllllIlIIIlIIlIlllIlllllll <= 360; lllllllllllIlIIIlIIlIlllIlllllll += 5) {
                    DrawHelper.drawCircle((float)(lllllllllllIlIIIlIIlIllllIIIlIlI.getScaledWidth() / 2), (float)(lllllllllllIlIIIlIIlIllllIIIlIlI.getScaledHeight() / 2), (float)(0 + lllllllllllIlIIIlIIlIlllIlllllll), 360.0f, 50.0f, 2.0f, false, ClientHelper.getClientColor(5.0f, (float)lllllllllllIlIIIlIIlIlllIlllllll, 5));
                }
            }
        }
    }
    
    public LoadingScreenRenderer(final Minecraft lllllllllllIlIIIlIIlIllllIlllIII) {
        this.message = "";
        this.currentlyDisplayedText = "";
        this.systemTime = Minecraft.getSystemTime();
        this.mc = lllllllllllIlIIIlIIlIllllIlllIII;
        this.scaledResolution = new ScaledResolution(lllllllllllIlIIIlIIlIllllIlllIII);
        this.framebuffer = new Framebuffer(lllllllllllIlIIIlIIlIllllIlllIII.displayWidth, lllllllllllIlIIIlIIlIllllIlllIII.displayHeight, false);
        this.framebuffer.setFramebufferFilter(9728);
    }
}
