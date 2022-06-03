// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.shader;

import java.nio.charset.StandardCharsets;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import java.io.IOException;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.resources.IResource;
import java.util.Iterator;
import net.minecraft.client.renderer.GlStateManager;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;
import java.io.FileNotFoundException;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonArray;
import net.minecraft.client.renderer.texture.TextureManager;
import com.google.gson.JsonObject;
import net.minecraft.client.util.JsonException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonElement;
import java.util.List;
import org.lwjgl.util.vector.Matrix4f;
import java.util.Map;
import net.minecraft.client.resources.IResourceManager;

public class ShaderGroup
{
    private /* synthetic */ float lastStamp;
    private final /* synthetic */ IResourceManager resourceManager;
    private final /* synthetic */ String shaderGroupName;
    private /* synthetic */ float time;
    public final /* synthetic */ Framebuffer mainFramebuffer;
    private final /* synthetic */ Map<String, Framebuffer> mapFramebuffers;
    private /* synthetic */ Matrix4f projectionMatrix;
    private /* synthetic */ int mainFramebufferHeight;
    private final /* synthetic */ List<Shader> listShaders;
    private /* synthetic */ int mainFramebufferWidth;
    private final /* synthetic */ List<Framebuffer> listFramebuffers;
    
    public void addFramebuffer(final String lllllllllllIlIlIIlIlIIllIIlIlllI, final int lllllllllllIlIlIIlIlIIllIIllIIlI, final int lllllllllllIlIlIIlIlIIllIIllIIIl) {
        final Framebuffer lllllllllllIlIlIIlIlIIllIIllIIII = new Framebuffer(lllllllllllIlIlIIlIlIIllIIllIIlI, lllllllllllIlIlIIlIlIIllIIllIIIl, true);
        lllllllllllIlIlIIlIlIIllIIllIIII.setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.mapFramebuffers.put(lllllllllllIlIlIIlIlIIllIIlIlllI, lllllllllllIlIlIIlIlIIllIIllIIII);
        if (lllllllllllIlIlIIlIlIIllIIllIIlI == this.mainFramebufferWidth && lllllllllllIlIlIIlIlIIllIIllIIIl == this.mainFramebufferHeight) {
            this.listFramebuffers.add(lllllllllllIlIlIIlIlIIllIIllIIII);
        }
    }
    
    private Framebuffer getFramebuffer(final String lllllllllllIlIlIIlIlIIlIlllIllll) {
        if (lllllllllllIlIlIIlIlIIlIlllIllll == null) {
            return null;
        }
        return lllllllllllIlIlIIlIlIIlIlllIllll.equals("minecraft:main") ? this.mainFramebuffer : this.mapFramebuffers.get(lllllllllllIlIlIIlIlIIlIlllIllll);
    }
    
    private void initUniform(final JsonElement lllllllllllIlIlIIlIlIIllIlIlIIll) throws JsonException {
        final JsonObject lllllllllllIlIlIIlIlIIllIlIlIIlI = JsonUtils.getJsonObject(lllllllllllIlIlIIlIlIIllIlIlIIll, "uniform");
        final String lllllllllllIlIlIIlIlIIllIlIlIIIl = JsonUtils.getString(lllllllllllIlIlIIlIlIIllIlIlIIlI, "name");
        final ShaderUniform lllllllllllIlIlIIlIlIIllIlIlIIII = this.listShaders.get(this.listShaders.size() - 1).getShaderManager().getShaderUniform(lllllllllllIlIlIIlIlIIllIlIlIIIl);
        if (lllllllllllIlIlIIlIlIIllIlIlIIII == null) {
            throw new JsonException("Uniform '" + lllllllllllIlIlIIlIlIIllIlIlIIIl + "' does not exist");
        }
        final float[] lllllllllllIlIlIIlIlIIllIlIIllll = new float[4];
        int lllllllllllIlIlIIlIlIIllIlIIlllI = 0;
        for (final JsonElement lllllllllllIlIlIIlIlIIllIlIIllIl : JsonUtils.getJsonArray(lllllllllllIlIlIIlIlIIllIlIlIIlI, "values")) {
            try {
                lllllllllllIlIlIIlIlIIllIlIIllll[lllllllllllIlIlIIlIlIIllIlIIlllI] = JsonUtils.getFloat(lllllllllllIlIlIIlIlIIllIlIIllIl, "value");
            }
            catch (Exception lllllllllllIlIlIIlIlIIllIlIIllII) {
                final JsonException lllllllllllIlIlIIlIlIIllIlIIlIll = JsonException.forException(lllllllllllIlIlIIlIlIIllIlIIllII);
                lllllllllllIlIlIIlIlIIllIlIIlIll.prependJsonKey("values[" + lllllllllllIlIlIIlIlIIllIlIIlllI + "]");
                throw lllllllllllIlIlIIlIlIIllIlIIlIll;
            }
            ++lllllllllllIlIlIIlIlIIllIlIIlllI;
        }
        switch (lllllllllllIlIlIIlIlIIllIlIIlllI) {
            case 1: {
                lllllllllllIlIlIIlIlIIllIlIlIIII.set(lllllllllllIlIlIIlIlIIllIlIIllll[0]);
                break;
            }
            case 2: {
                lllllllllllIlIlIIlIlIIllIlIlIIII.set(lllllllllllIlIlIIlIlIIllIlIIllll[0], lllllllllllIlIlIIlIlIIllIlIIllll[1]);
                break;
            }
            case 3: {
                lllllllllllIlIlIIlIlIIllIlIlIIII.set(lllllllllllIlIlIIlIlIIllIlIIllll[0], lllllllllllIlIlIIlIlIIllIlIIllll[1], lllllllllllIlIlIIlIlIIllIlIIllll[2]);
                break;
            }
            case 4: {
                lllllllllllIlIlIIlIlIIllIlIlIIII.set(lllllllllllIlIlIIlIlIIllIlIIllll[0], lllllllllllIlIlIIlIlIIllIlIIllll[1], lllllllllllIlIlIIlIlIIllIlIIllll[2], lllllllllllIlIlIIlIlIIllIlIIllll[3]);
                break;
            }
        }
    }
    
    public void loadShaderGroup(final float lllllllllllIlIlIIlIlIIlIlllllIII) {
        if (lllllllllllIlIlIIlIlIIlIlllllIII < this.lastStamp) {
            this.time += 1.0f - this.lastStamp;
            this.time += lllllllllllIlIlIIlIlIIlIlllllIII;
        }
        else {
            this.time += lllllllllllIlIlIIlIlIIlIlllllIII - this.lastStamp;
        }
        this.lastStamp = lllllllllllIlIlIIlIlIIlIlllllIII;
        while (this.time > 20.0f) {
            this.time -= 20.0f;
        }
        for (final Shader lllllllllllIlIlIIlIlIIlIlllllIlI : this.listShaders) {
            lllllllllllIlIlIIlIlIIlIlllllIlI.loadShader(this.time / 20.0f);
        }
    }
    
    private void initTarget(final JsonElement lllllllllllIlIlIIlIlIIlllIllIIll) throws JsonException {
        if (JsonUtils.isString(lllllllllllIlIlIIlIlIIlllIllIIll)) {
            this.addFramebuffer(lllllllllllIlIlIIlIlIIlllIllIIll.getAsString(), this.mainFramebufferWidth, this.mainFramebufferHeight);
        }
        else {
            final JsonObject lllllllllllIlIlIIlIlIIlllIlllIII = JsonUtils.getJsonObject(lllllllllllIlIlIIlIlIIlllIllIIll, "target");
            final String lllllllllllIlIlIIlIlIIlllIllIlll = JsonUtils.getString(lllllllllllIlIlIIlIlIIlllIlllIII, "name");
            final int lllllllllllIlIlIIlIlIIlllIllIllI = JsonUtils.getInt(lllllllllllIlIlIIlIlIIlllIlllIII, "width", this.mainFramebufferWidth);
            final int lllllllllllIlIlIIlIlIIlllIllIlIl = JsonUtils.getInt(lllllllllllIlIlIIlIlIIlllIlllIII, "height", this.mainFramebufferHeight);
            if (this.mapFramebuffers.containsKey(lllllllllllIlIlIIlIlIIlllIllIlll)) {
                throw new JsonException(String.valueOf(lllllllllllIlIlIIlIlIIlllIllIlll) + " is already defined");
            }
            this.addFramebuffer(lllllllllllIlIlIIlIlIIlllIllIlll, lllllllllllIlIlIIlIlIIlllIllIllI, lllllllllllIlIlIIlIlIIlllIllIlIl);
        }
    }
    
    private void parsePass(final TextureManager lllllllllllIlIlIIlIlIIlllIIlIlIl, final JsonElement lllllllllllIlIlIIlIlIIllIlllIlIl) throws IOException, JsonException {
        final JsonObject lllllllllllIlIlIIlIlIIlllIIlIIll = JsonUtils.getJsonObject(lllllllllllIlIlIIlIlIIllIlllIlIl, "pass");
        final String lllllllllllIlIlIIlIlIIlllIIlIIlI = JsonUtils.getString(lllllllllllIlIlIIlIlIIlllIIlIIll, "name");
        final String lllllllllllIlIlIIlIlIIlllIIlIIIl = JsonUtils.getString(lllllllllllIlIlIIlIlIIlllIIlIIll, "intarget");
        final String lllllllllllIlIlIIlIlIIlllIIlIIII = JsonUtils.getString(lllllllllllIlIlIIlIlIIlllIIlIIll, "outtarget");
        final Framebuffer lllllllllllIlIlIIlIlIIlllIIIllll = this.getFramebuffer(lllllllllllIlIlIIlIlIIlllIIlIIIl);
        final Framebuffer lllllllllllIlIlIIlIlIIlllIIIlllI = this.getFramebuffer(lllllllllllIlIlIIlIlIIlllIIlIIII);
        if (lllllllllllIlIlIIlIlIIlllIIIllll == null) {
            throw new JsonException("Input target '" + lllllllllllIlIlIIlIlIIlllIIlIIIl + "' does not exist");
        }
        if (lllllllllllIlIlIIlIlIIlllIIIlllI == null) {
            throw new JsonException("Output target '" + lllllllllllIlIlIIlIlIIlllIIlIIII + "' does not exist");
        }
        final Shader lllllllllllIlIlIIlIlIIlllIIIllIl = this.addShader(lllllllllllIlIlIIlIlIIlllIIlIIlI, lllllllllllIlIlIIlIlIIlllIIIllll, lllllllllllIlIlIIlIlIIlllIIIlllI);
        final JsonArray lllllllllllIlIlIIlIlIIlllIIIllII = JsonUtils.getJsonArray(lllllllllllIlIlIIlIlIIlllIIlIIll, "auxtargets", null);
        if (lllllllllllIlIlIIlIlIIlllIIIllII != null) {
            int lllllllllllIlIlIIlIlIIlllIIIlIll = 0;
            for (final JsonElement lllllllllllIlIlIIlIlIIlllIIIlIlI : lllllllllllIlIlIIlIlIIlllIIIllII) {
                try {
                    final JsonObject lllllllllllIlIlIIlIlIIlllIIIlIIl = JsonUtils.getJsonObject(lllllllllllIlIlIIlIlIIlllIIIlIlI, "auxtarget");
                    final String lllllllllllIlIlIIlIlIIlllIIIlIII = JsonUtils.getString(lllllllllllIlIlIIlIlIIlllIIIlIIl, "name");
                    final String lllllllllllIlIlIIlIlIIlllIIIIlll = JsonUtils.getString(lllllllllllIlIlIIlIlIIlllIIIlIIl, "id");
                    final Framebuffer lllllllllllIlIlIIlIlIIlllIIIIllI = this.getFramebuffer(lllllllllllIlIlIIlIlIIlllIIIIlll);
                    if (lllllllllllIlIlIIlIlIIlllIIIIllI == null) {
                        final ResourceLocation lllllllllllIlIlIIlIlIIlllIIIIlIl = new ResourceLocation("textures/effect/" + lllllllllllIlIlIIlIlIIlllIIIIlll + ".png");
                        IResource lllllllllllIlIlIIlIlIIlllIIIIlII = null;
                        try {
                            lllllllllllIlIlIIlIlIIlllIIIIlII = this.resourceManager.getResource(lllllllllllIlIlIIlIlIIlllIIIIlIl);
                        }
                        catch (FileNotFoundException lllllllllllIlIlIIlIlIIlllIIIIIll) {
                            throw new JsonException("Render target or texture '" + lllllllllllIlIlIIlIlIIlllIIIIlll + "' does not exist");
                        }
                        finally {
                            IOUtils.closeQuietly((Closeable)lllllllllllIlIlIIlIlIIlllIIIIlII);
                        }
                        IOUtils.closeQuietly((Closeable)lllllllllllIlIlIIlIlIIlllIIIIlII);
                        lllllllllllIlIlIIlIlIIlllIIlIlIl.bindTexture(lllllllllllIlIlIIlIlIIlllIIIIlIl);
                        final ITextureObject lllllllllllIlIlIIlIlIIlllIIIIIlI = lllllllllllIlIlIIlIlIIlllIIlIlIl.getTexture(lllllllllllIlIlIIlIlIIlllIIIIlIl);
                        final int lllllllllllIlIlIIlIlIIlllIIIIIIl = JsonUtils.getInt(lllllllllllIlIlIIlIlIIlllIIIlIIl, "width");
                        final int lllllllllllIlIlIIlIlIIlllIIIIIII = JsonUtils.getInt(lllllllllllIlIlIIlIlIIlllIIIlIIl, "height");
                        final boolean lllllllllllIlIlIIlIlIIllIlllllll = JsonUtils.getBoolean(lllllllllllIlIlIIlIlIIlllIIIlIIl, "bilinear");
                        if (lllllllllllIlIlIIlIlIIllIlllllll) {
                            GlStateManager.glTexParameteri(3553, 10241, 9729);
                            GlStateManager.glTexParameteri(3553, 10240, 9729);
                        }
                        else {
                            GlStateManager.glTexParameteri(3553, 10241, 9728);
                            GlStateManager.glTexParameteri(3553, 10240, 9728);
                        }
                        lllllllllllIlIlIIlIlIIlllIIIllIl.addAuxFramebuffer(lllllllllllIlIlIIlIlIIlllIIIlIII, lllllllllllIlIlIIlIlIIlllIIIIIlI.getGlTextureId(), lllllllllllIlIlIIlIlIIlllIIIIIIl, lllllllllllIlIlIIlIlIIlllIIIIIII);
                    }
                    else {
                        lllllllllllIlIlIIlIlIIlllIIIllIl.addAuxFramebuffer(lllllllllllIlIlIIlIlIIlllIIIlIII, lllllllllllIlIlIIlIlIIlllIIIIllI, lllllllllllIlIlIIlIlIIlllIIIIllI.framebufferTextureWidth, lllllllllllIlIlIIlIlIIlllIIIIllI.framebufferTextureHeight);
                    }
                }
                catch (Exception lllllllllllIlIlIIlIlIIllIllllllI) {
                    final JsonException lllllllllllIlIlIIlIlIIllIlllllIl = JsonException.forException(lllllllllllIlIlIIlIlIIllIllllllI);
                    lllllllllllIlIlIIlIlIIllIlllllIl.prependJsonKey("auxtargets[" + lllllllllllIlIlIIlIlIIlllIIIlIll + "]");
                    throw lllllllllllIlIlIIlIlIIllIlllllIl;
                }
                ++lllllllllllIlIlIIlIlIIlllIIIlIll;
            }
        }
        final JsonArray lllllllllllIlIlIIlIlIIllIlllllII = JsonUtils.getJsonArray(lllllllllllIlIlIIlIlIIlllIIlIIll, "uniforms", null);
        if (lllllllllllIlIlIIlIlIIllIlllllII != null) {
            int lllllllllllIlIlIIlIlIIllIllllIll = 0;
            for (final JsonElement lllllllllllIlIlIIlIlIIllIllllIlI : lllllllllllIlIlIIlIlIIllIlllllII) {
                try {
                    this.initUniform(lllllllllllIlIlIIlIlIIllIllllIlI);
                }
                catch (Exception lllllllllllIlIlIIlIlIIllIllllIIl) {
                    final JsonException lllllllllllIlIlIIlIlIIllIllllIII = JsonException.forException(lllllllllllIlIlIIlIlIIllIllllIIl);
                    lllllllllllIlIlIIlIlIIllIllllIII.prependJsonKey("uniforms[" + lllllllllllIlIlIIlIlIIllIllllIll + "]");
                    throw lllllllllllIlIlIIlIlIIllIllllIII;
                }
                ++lllllllllllIlIlIIlIlIIllIllllIll;
            }
        }
    }
    
    public List<Shader> getShaders() {
        return this.listShaders;
    }
    
    public ShaderGroup(final TextureManager lllllllllllIlIlIIlIlIIlllllllIII, final IResourceManager lllllllllllIlIlIIlIlIIllllllIIlI, final Framebuffer lllllllllllIlIlIIlIlIIllllllIIIl, final ResourceLocation lllllllllllIlIlIIlIlIIllllllIlIl) throws IOException, JsonSyntaxException, JsonException {
        this.listShaders = (List<Shader>)Lists.newArrayList();
        this.mapFramebuffers = (Map<String, Framebuffer>)Maps.newHashMap();
        this.listFramebuffers = (List<Framebuffer>)Lists.newArrayList();
        this.resourceManager = lllllllllllIlIlIIlIlIIllllllIIlI;
        this.mainFramebuffer = lllllllllllIlIlIIlIlIIllllllIIIl;
        this.time = 0.0f;
        this.lastStamp = 0.0f;
        this.mainFramebufferWidth = lllllllllllIlIlIIlIlIIllllllIIIl.framebufferWidth;
        this.mainFramebufferHeight = lllllllllllIlIlIIlIlIIllllllIIIl.framebufferHeight;
        this.shaderGroupName = lllllllllllIlIlIIlIlIIllllllIlIl.toString();
        this.resetProjectionMatrix();
        this.parseGroup(lllllllllllIlIlIIlIlIIlllllllIII, lllllllllllIlIlIIlIlIIllllllIlIl);
    }
    
    public void deleteShaderGroup() {
        for (final Framebuffer lllllllllllIlIlIIlIlIIllIIlIIllI : this.mapFramebuffers.values()) {
            lllllllllllIlIlIIlIlIIllIIlIIllI.deleteFramebuffer();
        }
        for (final Shader lllllllllllIlIlIIlIlIIllIIlIIlIl : this.listShaders) {
            lllllllllllIlIlIIlIlIIllIIlIIlIl.deleteShader();
        }
        this.listShaders.clear();
    }
    
    private void resetProjectionMatrix() {
        this.projectionMatrix = new Matrix4f();
        this.projectionMatrix.setIdentity();
        this.projectionMatrix.m00 = 2.0f / this.mainFramebuffer.framebufferTextureWidth;
        this.projectionMatrix.m11 = 2.0f / -this.mainFramebuffer.framebufferTextureHeight;
        this.projectionMatrix.m22 = -0.0020001999f;
        this.projectionMatrix.m33 = 1.0f;
        this.projectionMatrix.m03 = -1.0f;
        this.projectionMatrix.m13 = 1.0f;
        this.projectionMatrix.m23 = -1.0001999f;
    }
    
    public void createBindFramebuffers(final int lllllllllllIlIlIIlIlIIllIIIIlIIl, final int lllllllllllIlIlIIlIlIIllIIIIIIll) {
        this.mainFramebufferWidth = this.mainFramebuffer.framebufferTextureWidth;
        this.mainFramebufferHeight = this.mainFramebuffer.framebufferTextureHeight;
        this.resetProjectionMatrix();
        for (final Shader lllllllllllIlIlIIlIlIIllIIIIIlll : this.listShaders) {
            lllllllllllIlIlIIlIlIIllIIIIIlll.setProjectionMatrix(this.projectionMatrix);
        }
        for (final Framebuffer lllllllllllIlIlIIlIlIIllIIIIIllI : this.listFramebuffers) {
            lllllllllllIlIlIIlIlIIllIIIIIllI.createBindFramebuffer(lllllllllllIlIlIIlIlIIllIIIIlIIl, lllllllllllIlIlIIlIlIIllIIIIIIll);
        }
    }
    
    public Shader addShader(final String lllllllllllIlIlIIlIlIIllIIIlIllI, final Framebuffer lllllllllllIlIlIIlIlIIllIIIllIlI, final Framebuffer lllllllllllIlIlIIlIlIIllIIIlIlII) throws IOException, JsonException {
        final Shader lllllllllllIlIlIIlIlIIllIIIllIII = new Shader(this.resourceManager, lllllllllllIlIlIIlIlIIllIIIlIllI, lllllllllllIlIlIIlIlIIllIIIllIlI, lllllllllllIlIlIIlIlIIllIIIlIlII);
        this.listShaders.add(this.listShaders.size(), lllllllllllIlIlIIlIlIIllIIIllIII);
        return lllllllllllIlIlIIlIlIIllIIIllIII;
    }
    
    public final String getShaderGroupName() {
        return this.shaderGroupName;
    }
    
    public void parseGroup(final TextureManager lllllllllllIlIlIIlIlIIllllIllllI, final ResourceLocation lllllllllllIlIlIIlIlIIllllIIlIll) throws JsonException, IOException, JsonSyntaxException {
        final JsonParser lllllllllllIlIlIIlIlIIllllIlllII = new JsonParser();
        IResource lllllllllllIlIlIIlIlIIllllIllIll = null;
        try {
            lllllllllllIlIlIIlIlIIllllIllIll = this.resourceManager.getResource(lllllllllllIlIlIIlIlIIllllIIlIll);
            final JsonObject lllllllllllIlIlIIlIlIIllllIllIlI = lllllllllllIlIlIIlIlIIllllIlllII.parse(IOUtils.toString(lllllllllllIlIlIIlIlIIllllIllIll.getInputStream(), StandardCharsets.UTF_8)).getAsJsonObject();
            if (JsonUtils.isJsonArray(lllllllllllIlIlIIlIlIIllllIllIlI, "targets")) {
                final JsonArray lllllllllllIlIlIIlIlIIllllIllIIl = lllllllllllIlIlIIlIlIIllllIllIlI.getAsJsonArray("targets");
                int lllllllllllIlIlIIlIlIIllllIllIII = 0;
                for (final JsonElement lllllllllllIlIlIIlIlIIllllIlIlll : lllllllllllIlIlIIlIlIIllllIllIIl) {
                    try {
                        this.initTarget(lllllllllllIlIlIIlIlIIllllIlIlll);
                    }
                    catch (Exception lllllllllllIlIlIIlIlIIllllIlIllI) {
                        final JsonException lllllllllllIlIlIIlIlIIllllIlIlIl = JsonException.forException(lllllllllllIlIlIIlIlIIllllIlIllI);
                        lllllllllllIlIlIIlIlIIllllIlIlIl.prependJsonKey("targets[" + lllllllllllIlIlIIlIlIIllllIllIII + "]");
                        throw lllllllllllIlIlIIlIlIIllllIlIlIl;
                    }
                    ++lllllllllllIlIlIIlIlIIllllIllIII;
                }
            }
            if (JsonUtils.isJsonArray(lllllllllllIlIlIIlIlIIllllIllIlI, "passes")) {
                final JsonArray lllllllllllIlIlIIlIlIIllllIlIlII = lllllllllllIlIlIIlIlIIllllIllIlI.getAsJsonArray("passes");
                int lllllllllllIlIlIIlIlIIllllIlIIll = 0;
                for (final JsonElement lllllllllllIlIlIIlIlIIllllIlIIlI : lllllllllllIlIlIIlIlIIllllIlIlII) {
                    try {
                        this.parsePass(lllllllllllIlIlIIlIlIIllllIllllI, lllllllllllIlIlIIlIlIIllllIlIIlI);
                    }
                    catch (Exception lllllllllllIlIlIIlIlIIllllIlIIIl) {
                        final JsonException lllllllllllIlIlIIlIlIIllllIlIIII = JsonException.forException(lllllllllllIlIlIIlIlIIllllIlIIIl);
                        lllllllllllIlIlIIlIlIIllllIlIIII.prependJsonKey("passes[" + lllllllllllIlIlIIlIlIIllllIlIIll + "]");
                        throw lllllllllllIlIlIIlIlIIllllIlIIII;
                    }
                    ++lllllllllllIlIlIIlIlIIllllIlIIll;
                }
            }
        }
        catch (Exception lllllllllllIlIlIIlIlIIllllIIllll) {
            final JsonException lllllllllllIlIlIIlIlIIllllIIlllI = JsonException.forException(lllllllllllIlIlIIlIlIIllllIIllll);
            lllllllllllIlIlIIlIlIIllllIIlllI.setFilenameAndFlush(lllllllllllIlIlIIlIlIIllllIIlIll.getResourcePath());
            throw lllllllllllIlIlIIlIlIIllllIIlllI;
        }
        finally {
            IOUtils.closeQuietly((Closeable)lllllllllllIlIlIIlIlIIllllIllIll);
        }
        IOUtils.closeQuietly((Closeable)lllllllllllIlIlIIlIlIIllllIllIll);
    }
    
    public Framebuffer getFramebufferRaw(final String lllllllllllIlIlIIlIlIIllIIlllIlI) {
        return this.mapFramebuffers.get(lllllllllllIlIlIIlIlIIllIIlllIlI);
    }
}
