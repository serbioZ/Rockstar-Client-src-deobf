// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.shader;

import java.nio.IntBuffer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;

public class Framebuffer
{
    public /* synthetic */ int framebufferTextureHeight;
    public /* synthetic */ int framebufferWidth;
    public /* synthetic */ float[] framebufferColor;
    public /* synthetic */ boolean useDepth;
    public /* synthetic */ int framebufferFilter;
    public /* synthetic */ int framebufferObject;
    public /* synthetic */ int framebufferTextureWidth;
    public /* synthetic */ int depthBuffer;
    public /* synthetic */ int framebufferTexture;
    public /* synthetic */ int framebufferHeight;
    
    public void bindFramebuffer(final boolean lIlllllIlIIll) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, this.framebufferObject);
            if (lIlllllIlIIll) {
                GlStateManager.viewport(0, 0, this.framebufferWidth, this.framebufferHeight);
            }
        }
    }
    
    public void createBindFramebuffer(final int lIlllllllIlll, final int lIlllllllIllI) {
        if (!OpenGlHelper.isFramebufferEnabled()) {
            this.framebufferWidth = lIlllllllIlll;
            this.framebufferHeight = lIlllllllIllI;
        }
        else {
            GlStateManager.enableDepth();
            if (this.framebufferObject >= 0) {
                this.deleteFramebuffer();
            }
            this.createFramebuffer(lIlllllllIlll, lIlllllllIllI);
            this.checkFramebufferComplete();
            OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
        }
    }
    
    public void setFramebufferFilter(final int lIllllllIIIIl) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            this.framebufferFilter = lIllllllIIIIl;
            GlStateManager.bindTexture(this.framebufferTexture);
            GlStateManager.glTexParameteri(3553, 10241, lIllllllIIIIl);
            GlStateManager.glTexParameteri(3553, 10240, lIllllllIIIIl);
            GlStateManager.glTexParameteri(3553, 10242, 10496);
            GlStateManager.glTexParameteri(3553, 10243, 10496);
            GlStateManager.bindTexture(0);
        }
    }
    
    public void unbindFramebufferTexture() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.bindTexture(0);
        }
    }
    
    public Framebuffer(final int lIllllllllllI, final int lIlllllllllIl, final boolean lIlllllllllII) {
        this.useDepth = lIlllllllllII;
        this.framebufferObject = -1;
        this.framebufferTexture = -1;
        this.depthBuffer = -1;
        this.framebufferColor = new float[4];
        this.framebufferColor[0] = 1.0f;
        this.framebufferColor[1] = 1.0f;
        this.framebufferColor[2] = 1.0f;
        this.framebufferColor[3] = 0.0f;
        this.createBindFramebuffer(lIllllllllllI, lIlllllllllIl);
    }
    
    public void framebufferClear() {
        this.bindFramebuffer(true);
        GlStateManager.clearColor(this.framebufferColor[0], this.framebufferColor[1], this.framebufferColor[2], this.framebufferColor[3]);
        int lIllllIIllIII = 16384;
        if (this.useDepth) {
            GlStateManager.clearDepth(1.0);
            lIllllIIllIII |= 0x100;
        }
        GlStateManager.clear(lIllllIIllIII);
        this.unbindFramebuffer();
    }
    
    public void setFramebufferColor(final float lIlllllIIIllI, final float lIlllllIIIlIl, final float lIlllllIIlIIl, final float lIlllllIIIIll) {
        this.framebufferColor[0] = lIlllllIIIllI;
        this.framebufferColor[1] = lIlllllIIIlIl;
        this.framebufferColor[2] = lIlllllIIlIIl;
        this.framebufferColor[3] = lIlllllIIIIll;
    }
    
    public void framebufferRender(final int lIllllIlllllI, final int lIllllIllllIl) {
        this.framebufferRenderExt(lIllllIlllllI, lIllllIllllIl, true);
    }
    
    public void framebufferRenderExt(final int lIllllIlIIlII, final int lIllllIlIllIl, final boolean lIllllIlIllII) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.colorMask(true, true, true, false);
            GlStateManager.disableDepth();
            GlStateManager.depthMask(false);
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, lIllllIlIIlII, lIllllIlIllIl, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GlStateManager.viewport(0, 0, lIllllIlIIlII, lIllllIlIllIl);
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableAlpha();
            if (lIllllIlIllII) {
                GlStateManager.disableBlend();
                GlStateManager.enableColorMaterial();
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.bindFramebufferTexture();
            final float lIllllIlIlIll = (float)lIllllIlIIlII;
            final float lIllllIlIlIlI = (float)lIllllIlIllIl;
            final float lIllllIlIlIIl = this.framebufferWidth / (float)this.framebufferTextureWidth;
            final float lIllllIlIlIII = this.framebufferHeight / (float)this.framebufferTextureHeight;
            final Tessellator lIllllIlIIlll = Tessellator.getInstance();
            final BufferBuilder lIllllIlIIllI = lIllllIlIIlll.getBuffer();
            lIllllIlIIllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            lIllllIlIIllI.pos(0.0, lIllllIlIlIlI, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
            lIllllIlIIllI.pos(lIllllIlIlIll, lIllllIlIlIlI, 0.0).tex(lIllllIlIlIIl, 0.0).color(255, 255, 255, 255).endVertex();
            lIllllIlIIllI.pos(lIllllIlIlIll, 0.0, 0.0).tex(lIllllIlIlIIl, lIllllIlIlIII).color(255, 255, 255, 255).endVertex();
            lIllllIlIIllI.pos(0.0, 0.0, 0.0).tex(0.0, lIllllIlIlIII).color(255, 255, 255, 255).endVertex();
            lIllllIlIIlll.draw();
            this.unbindFramebufferTexture();
            GlStateManager.depthMask(true);
            GlStateManager.colorMask(true, true, true, true);
        }
    }
    
    public void bindFramebufferTexture() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.bindTexture(this.framebufferTexture);
        }
    }
    
    public void deleteFramebuffer() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            this.unbindFramebufferTexture();
            this.unbindFramebuffer();
            if (this.depthBuffer > -1) {
                OpenGlHelper.glDeleteRenderbuffers(this.depthBuffer);
                this.depthBuffer = -1;
            }
            if (this.framebufferTexture > -1) {
                TextureUtil.deleteTexture(this.framebufferTexture);
                this.framebufferTexture = -1;
            }
            if (this.framebufferObject > -1) {
                OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
                OpenGlHelper.glDeleteFramebuffers(this.framebufferObject);
                this.framebufferObject = -1;
            }
        }
    }
    
    public void unbindFramebuffer() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
        }
    }
    
    public void createFramebuffer(final int lIllllllIlIII, final int lIllllllIlIlI) {
        this.framebufferWidth = lIllllllIlIII;
        this.framebufferHeight = lIllllllIlIlI;
        this.framebufferTextureWidth = lIllllllIlIII;
        this.framebufferTextureHeight = lIllllllIlIlI;
        if (!OpenGlHelper.isFramebufferEnabled()) {
            this.framebufferClear();
        }
        else {
            this.framebufferObject = OpenGlHelper.glGenFramebuffers();
            this.framebufferTexture = TextureUtil.glGenTextures();
            if (this.useDepth) {
                this.depthBuffer = OpenGlHelper.glGenRenderbuffers();
            }
            this.setFramebufferFilter(9728);
            GlStateManager.bindTexture(this.framebufferTexture);
            GlStateManager.glTexImage2D(3553, 0, 32856, this.framebufferTextureWidth, this.framebufferTextureHeight, 0, 6408, 5121, null);
            OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, this.framebufferObject);
            OpenGlHelper.glFramebufferTexture2D(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_COLOR_ATTACHMENT0, 3553, this.framebufferTexture, 0);
            if (this.useDepth) {
                OpenGlHelper.glBindRenderbuffer(OpenGlHelper.GL_RENDERBUFFER, this.depthBuffer);
                OpenGlHelper.glRenderbufferStorage(OpenGlHelper.GL_RENDERBUFFER, 33190, this.framebufferTextureWidth, this.framebufferTextureHeight);
                OpenGlHelper.glFramebufferRenderbuffer(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_DEPTH_ATTACHMENT, OpenGlHelper.GL_RENDERBUFFER, this.depthBuffer);
            }
            this.framebufferClear();
            this.unbindFramebufferTexture();
        }
    }
    
    public void checkFramebufferComplete() {
        final int lIlllllIllllI = OpenGlHelper.glCheckFramebufferStatus(OpenGlHelper.GL_FRAMEBUFFER);
        if (lIlllllIllllI == OpenGlHelper.GL_FRAMEBUFFER_COMPLETE) {
            return;
        }
        if (lIlllllIllllI == OpenGlHelper.GL_FB_INCOMPLETE_ATTACHMENT) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
        }
        if (lIlllllIllllI == OpenGlHelper.GL_FB_INCOMPLETE_MISS_ATTACH) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT");
        }
        if (lIlllllIllllI == OpenGlHelper.GL_FB_INCOMPLETE_DRAW_BUFFER) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER");
        }
        if (lIlllllIllllI == OpenGlHelper.GL_FB_INCOMPLETE_READ_BUFFER) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER");
        }
        throw new RuntimeException("glCheckFramebufferStatus returned unknown status:" + lIlllllIllllI);
    }
}
