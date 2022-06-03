// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.shader;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.util.JsonException;
import java.io.IOException;
import com.google.common.collect.Lists;
import net.minecraft.client.resources.IResourceManager;
import org.lwjgl.util.vector.Matrix4f;
import java.util.List;

public class Shader
{
    private final /* synthetic */ List<Integer> listAuxWidths;
    private final /* synthetic */ List<Integer> listAuxHeights;
    private final /* synthetic */ ShaderManager manager;
    public final /* synthetic */ Framebuffer framebufferIn;
    private final /* synthetic */ List<String> listAuxNames;
    public final /* synthetic */ Framebuffer framebufferOut;
    private /* synthetic */ Matrix4f projectionMatrix;
    private final /* synthetic */ List<Object> listAuxFramebuffers;
    
    public void setProjectionMatrix(final Matrix4f llllllllllIlllIIlIIllIIIIIIIlllI) {
        this.projectionMatrix = llllllllllIlllIIlIIllIIIIIIIlllI;
    }
    
    public void deleteShader() {
        this.manager.deleteShader();
    }
    
    public ShaderManager getShaderManager() {
        return this.manager;
    }
    
    public Shader(final IResourceManager llllllllllIlllIIlIIllIIIIIlIlIII, final String llllllllllIlllIIlIIllIIIIIlIllII, final Framebuffer llllllllllIlllIIlIIllIIIIIlIlIll, final Framebuffer llllllllllIlllIIlIIllIIIIIlIIlIl) throws IOException, JsonException {
        this.listAuxFramebuffers = (List<Object>)Lists.newArrayList();
        this.listAuxNames = (List<String>)Lists.newArrayList();
        this.listAuxWidths = (List<Integer>)Lists.newArrayList();
        this.listAuxHeights = (List<Integer>)Lists.newArrayList();
        this.manager = new ShaderManager(llllllllllIlllIIlIIllIIIIIlIlIII, llllllllllIlllIIlIIllIIIIIlIllII);
        this.framebufferIn = llllllllllIlllIIlIIllIIIIIlIlIll;
        this.framebufferOut = llllllllllIlllIIlIIllIIIIIlIIlIl;
    }
    
    public void addAuxFramebuffer(final String llllllllllIlllIIlIIllIIIIIIlIllI, final Object llllllllllIlllIIlIIllIIIIIIlIlIl, final int llllllllllIlllIIlIIllIIIIIIllIIl, final int llllllllllIlllIIlIIllIIIIIIlIIll) {
        this.listAuxNames.add(this.listAuxNames.size(), llllllllllIlllIIlIIllIIIIIIlIllI);
        this.listAuxFramebuffers.add(this.listAuxFramebuffers.size(), llllllllllIlllIIlIIllIIIIIIlIlIl);
        this.listAuxWidths.add(this.listAuxWidths.size(), llllllllllIlllIIlIIllIIIIIIllIIl);
        this.listAuxHeights.add(this.listAuxHeights.size(), llllllllllIlllIIlIIllIIIIIIlIIll);
    }
    
    public void loadShader(final float llllllllllIlllIIlIIlIllllllllIII) {
        this.preLoadShader();
        this.framebufferIn.unbindFramebuffer();
        final float llllllllllIlllIIlIIllIIIIIIIIIII = (float)this.framebufferOut.framebufferTextureWidth;
        final float llllllllllIlllIIlIIlIlllllllllll = (float)this.framebufferOut.framebufferTextureHeight;
        GlStateManager.viewport(0, 0, (int)llllllllllIlllIIlIIllIIIIIIIIIII, (int)llllllllllIlllIIlIIlIlllllllllll);
        this.manager.addSamplerTexture("DiffuseSampler", this.framebufferIn);
        for (int llllllllllIlllIIlIIlIllllllllllI = 0; llllllllllIlllIIlIIlIllllllllllI < this.listAuxFramebuffers.size(); ++llllllllllIlllIIlIIlIllllllllllI) {
            this.manager.addSamplerTexture(this.listAuxNames.get(llllllllllIlllIIlIIlIllllllllllI), this.listAuxFramebuffers.get(llllllllllIlllIIlIIlIllllllllllI));
            this.manager.getShaderUniformOrDefault("AuxSize" + llllllllllIlllIIlIIlIllllllllllI).set(this.listAuxWidths.get(llllllllllIlllIIlIIlIllllllllllI), this.listAuxHeights.get(llllllllllIlllIIlIIlIllllllllllI));
        }
        this.manager.getShaderUniformOrDefault("ProjMat").set(this.projectionMatrix);
        this.manager.getShaderUniformOrDefault("InSize").set((float)this.framebufferIn.framebufferTextureWidth, (float)this.framebufferIn.framebufferTextureHeight);
        this.manager.getShaderUniformOrDefault("OutSize").set(llllllllllIlllIIlIIllIIIIIIIIIII, llllllllllIlllIIlIIlIlllllllllll);
        this.manager.getShaderUniformOrDefault("Time").set(llllllllllIlllIIlIIlIllllllllIII);
        final Minecraft llllllllllIlllIIlIIlIlllllllllIl = Minecraft.getMinecraft();
        this.manager.getShaderUniformOrDefault("ScreenSize").set((float)llllllllllIlllIIlIIlIlllllllllIl.displayWidth, (float)llllllllllIlllIIlIIlIlllllllllIl.displayHeight);
        this.manager.useShader();
        this.framebufferOut.framebufferClear();
        this.framebufferOut.bindFramebuffer(false);
        GlStateManager.depthMask(false);
        GlStateManager.colorMask(true, true, true, true);
        final Tessellator llllllllllIlllIIlIIlIlllllllllII = Tessellator.getInstance();
        final BufferBuilder llllllllllIlllIIlIIlIllllllllIll = llllllllllIlllIIlIIlIlllllllllII.getBuffer();
        llllllllllIlllIIlIIlIllllllllIll.begin(7, DefaultVertexFormats.POSITION_COLOR);
        llllllllllIlllIIlIIlIllllllllIll.pos(0.0, llllllllllIlllIIlIIlIlllllllllll, 500.0).color(255, 255, 255, 255).endVertex();
        llllllllllIlllIIlIIlIllllllllIll.pos(llllllllllIlllIIlIIllIIIIIIIIIII, llllllllllIlllIIlIIlIlllllllllll, 500.0).color(255, 255, 255, 255).endVertex();
        llllllllllIlllIIlIIlIllllllllIll.pos(llllllllllIlllIIlIIllIIIIIIIIIII, 0.0, 500.0).color(255, 255, 255, 255).endVertex();
        llllllllllIlllIIlIIlIllllllllIll.pos(0.0, 0.0, 500.0).color(255, 255, 255, 255).endVertex();
        llllllllllIlllIIlIIlIlllllllllII.draw();
        GlStateManager.depthMask(true);
        GlStateManager.colorMask(true, true, true, true);
        this.manager.endShader();
        this.framebufferOut.unbindFramebuffer();
        this.framebufferIn.unbindFramebufferTexture();
        for (final Object llllllllllIlllIIlIIlIllllllllIlI : this.listAuxFramebuffers) {
            if (llllllllllIlllIIlIIlIllllllllIlI instanceof Framebuffer) {
                ((Framebuffer)llllllllllIlllIIlIIlIllllllllIlI).unbindFramebufferTexture();
            }
        }
    }
    
    private void preLoadShader() {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableAlpha();
        GlStateManager.disableFog();
        GlStateManager.disableLighting();
        GlStateManager.disableColorMaterial();
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(0);
    }
}
