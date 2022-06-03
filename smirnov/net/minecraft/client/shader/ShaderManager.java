// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.shader;

import org.apache.logging.log4j.LogManager;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.GlStateManager;
import java.io.IOException;
import java.util.Iterator;
import net.minecraft.client.resources.IResource;
import java.io.Closeable;
import net.minecraft.client.renderer.OpenGlHelper;
import com.google.gson.JsonObject;
import net.minecraft.client.util.JsonException;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import net.minecraft.util.JsonUtils;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonParser;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.client.resources.IResourceManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import net.minecraft.client.util.JsonBlendingMode;
import java.util.List;

public class ShaderManager
{
    private final /* synthetic */ List<Integer> attribLocations;
    private final /* synthetic */ ShaderLoader vertexShaderLoader;
    private static /* synthetic */ ShaderManager staticShaderManager;
    private final /* synthetic */ List<String> samplerNames;
    private final /* synthetic */ boolean useFaceCulling;
    private final /* synthetic */ String programFilename;
    private final /* synthetic */ int program;
    private final /* synthetic */ List<Integer> shaderUniformLocations;
    private /* synthetic */ boolean isDirty;
    private static /* synthetic */ boolean lastCull;
    private final /* synthetic */ List<ShaderUniform> shaderUniforms;
    private final /* synthetic */ JsonBlendingMode blendingMode;
    private final /* synthetic */ ShaderLoader fragmentShaderLoader;
    private final /* synthetic */ List<Integer> shaderSamplerLocations;
    private final /* synthetic */ Map<String, ShaderUniform> mappedShaderUniforms;
    private static /* synthetic */ int currentProgram;
    private final /* synthetic */ List<String> attributes;
    private static final /* synthetic */ ShaderDefault DEFAULT_SHADER_UNIFORM;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Map<String, Object> shaderSamplers;
    
    public ShaderLoader getFragmentShaderLoader() {
        return this.fragmentShaderLoader;
    }
    
    public ShaderManager(final IResourceManager llllllllllIllllIlIlIIIlllllIlIII, final String llllllllllIllllIlIlIIIlllllIIlll) throws IOException, JsonException {
        this.shaderSamplers = (Map<String, Object>)Maps.newHashMap();
        this.samplerNames = (List<String>)Lists.newArrayList();
        this.shaderSamplerLocations = (List<Integer>)Lists.newArrayList();
        this.shaderUniforms = (List<ShaderUniform>)Lists.newArrayList();
        this.shaderUniformLocations = (List<Integer>)Lists.newArrayList();
        this.mappedShaderUniforms = (Map<String, ShaderUniform>)Maps.newHashMap();
        final JsonParser llllllllllIllllIlIlIIlIIIIIIIIlI = new JsonParser();
        final ResourceLocation llllllllllIllllIlIlIIlIIIIIIIIIl = new ResourceLocation("shaders/program/" + llllllllllIllllIlIlIIIlllllIIlll + ".json");
        this.programFilename = llllllllllIllllIlIlIIIlllllIIlll;
        IResource llllllllllIllllIlIlIIlIIIIIIIIII = null;
        try {
            llllllllllIllllIlIlIIlIIIIIIIIII = llllllllllIllllIlIlIIIlllllIlIII.getResource(llllllllllIllllIlIlIIlIIIIIIIIIl);
            final JsonObject llllllllllIllllIlIlIIIllllllllll = llllllllllIllllIlIlIIlIIIIIIIIlI.parse(IOUtils.toString(llllllllllIllllIlIlIIlIIIIIIIIII.getInputStream(), StandardCharsets.UTF_8)).getAsJsonObject();
            final String llllllllllIllllIlIlIIIlllllllllI = JsonUtils.getString(llllllllllIllllIlIlIIIllllllllll, "vertex");
            final String llllllllllIllllIlIlIIIllllllllIl = JsonUtils.getString(llllllllllIllllIlIlIIIllllllllll, "fragment");
            final JsonArray llllllllllIllllIlIlIIIllllllllII = JsonUtils.getJsonArray(llllllllllIllllIlIlIIIllllllllll, "samplers", null);
            if (llllllllllIllllIlIlIIIllllllllII != null) {
                int llllllllllIllllIlIlIIIlllllllIll = 0;
                for (final JsonElement llllllllllIllllIlIlIIIlllllllIlI : llllllllllIllllIlIlIIIllllllllII) {
                    try {
                        this.parseSampler(llllllllllIllllIlIlIIIlllllllIlI);
                    }
                    catch (Exception llllllllllIllllIlIlIIIlllllllIIl) {
                        final JsonException llllllllllIllllIlIlIIIlllllllIII = JsonException.forException(llllllllllIllllIlIlIIIlllllllIIl);
                        llllllllllIllllIlIlIIIlllllllIII.prependJsonKey("samplers[" + llllllllllIllllIlIlIIIlllllllIll + "]");
                        throw llllllllllIllllIlIlIIIlllllllIII;
                    }
                    ++llllllllllIllllIlIlIIIlllllllIll;
                }
            }
            final JsonArray llllllllllIllllIlIlIIIllllllIlll = JsonUtils.getJsonArray(llllllllllIllllIlIlIIIllllllllll, "attributes", null);
            if (llllllllllIllllIlIlIIIllllllIlll != null) {
                int llllllllllIllllIlIlIIIllllllIllI = 0;
                this.attribLocations = (List<Integer>)Lists.newArrayListWithCapacity(llllllllllIllllIlIlIIIllllllIlll.size());
                this.attributes = (List<String>)Lists.newArrayListWithCapacity(llllllllllIllllIlIlIIIllllllIlll.size());
                for (final JsonElement llllllllllIllllIlIlIIIllllllIlIl : llllllllllIllllIlIlIIIllllllIlll) {
                    try {
                        this.attributes.add(JsonUtils.getString(llllllllllIllllIlIlIIIllllllIlIl, "attribute"));
                    }
                    catch (Exception llllllllllIllllIlIlIIIllllllIlII) {
                        final JsonException llllllllllIllllIlIlIIIllllllIIll = JsonException.forException(llllllllllIllllIlIlIIIllllllIlII);
                        llllllllllIllllIlIlIIIllllllIIll.prependJsonKey("attributes[" + llllllllllIllllIlIlIIIllllllIllI + "]");
                        throw llllllllllIllllIlIlIIIllllllIIll;
                    }
                    ++llllllllllIllllIlIlIIIllllllIllI;
                }
            }
            else {
                this.attribLocations = null;
                this.attributes = null;
            }
            final JsonArray llllllllllIllllIlIlIIIllllllIIlI = JsonUtils.getJsonArray(llllllllllIllllIlIlIIIllllllllll, "uniforms", null);
            if (llllllllllIllllIlIlIIIllllllIIlI != null) {
                int llllllllllIllllIlIlIIIllllllIIIl = 0;
                for (final JsonElement llllllllllIllllIlIlIIIllllllIIII : llllllllllIllllIlIlIIIllllllIIlI) {
                    try {
                        this.parseUniform(llllllllllIllllIlIlIIIllllllIIII);
                    }
                    catch (Exception llllllllllIllllIlIlIIIlllllIllll) {
                        final JsonException llllllllllIllllIlIlIIIlllllIlllI = JsonException.forException(llllllllllIllllIlIlIIIlllllIllll);
                        llllllllllIllllIlIlIIIlllllIlllI.prependJsonKey("uniforms[" + llllllllllIllllIlIlIIIllllllIIIl + "]");
                        throw llllllllllIllllIlIlIIIlllllIlllI;
                    }
                    ++llllllllllIllllIlIlIIIllllllIIIl;
                }
            }
            this.blendingMode = JsonBlendingMode.parseBlendNode(JsonUtils.getJsonObject(llllllllllIllllIlIlIIIllllllllll, "blend", null));
            this.useFaceCulling = JsonUtils.getBoolean(llllllllllIllllIlIlIIIllllllllll, "cull", true);
            this.vertexShaderLoader = ShaderLoader.loadShader(llllllllllIllllIlIlIIIlllllIlIII, ShaderLoader.ShaderType.VERTEX, llllllllllIllllIlIlIIIlllllllllI);
            this.fragmentShaderLoader = ShaderLoader.loadShader(llllllllllIllllIlIlIIIlllllIlIII, ShaderLoader.ShaderType.FRAGMENT, llllllllllIllllIlIlIIIllllllllIl);
            this.program = ShaderLinkHelper.getStaticShaderLinkHelper().createProgram();
            ShaderLinkHelper.getStaticShaderLinkHelper().linkProgram(this);
            this.setupUniforms();
            if (this.attributes != null) {
                for (final String llllllllllIllllIlIlIIIlllllIllIl : this.attributes) {
                    final int llllllllllIllllIlIlIIIlllllIllII = OpenGlHelper.glGetAttribLocation(this.program, llllllllllIllllIlIlIIIlllllIllIl);
                    this.attribLocations.add(llllllllllIllllIlIlIIIlllllIllII);
                }
            }
        }
        catch (Exception llllllllllIllllIlIlIIIlllllIlIll) {
            final JsonException llllllllllIllllIlIlIIIlllllIlIlI = JsonException.forException(llllllllllIllllIlIlIIIlllllIlIll);
            llllllllllIllllIlIlIIIlllllIlIlI.setFilenameAndFlush(llllllllllIllllIlIlIIlIIIIIIIIIl.getResourcePath());
            throw llllllllllIllllIlIlIIIlllllIlIlI;
        }
        finally {
            IOUtils.closeQuietly((Closeable)llllllllllIllllIlIlIIlIIIIIIIIII);
        }
        IOUtils.closeQuietly((Closeable)llllllllllIllllIlIlIIlIIIIIIIIII);
        this.markDirty();
    }
    
    public void useShader() {
        this.isDirty = false;
        ShaderManager.staticShaderManager = this;
        this.blendingMode.apply();
        if (this.program != ShaderManager.currentProgram) {
            OpenGlHelper.glUseProgram(this.program);
            ShaderManager.currentProgram = this.program;
        }
        if (this.useFaceCulling) {
            GlStateManager.enableCull();
        }
        else {
            GlStateManager.disableCull();
        }
        for (int llllllllllIllllIlIlIIIllllIIlIIl = 0; llllllllllIllllIlIlIIIllllIIlIIl < this.shaderSamplerLocations.size(); ++llllllllllIllllIlIlIIIllllIIlIIl) {
            if (this.shaderSamplers.get(this.samplerNames.get(llllllllllIllllIlIlIIIllllIIlIIl)) != null) {
                GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllIllllIlIlIIIllllIIlIIl);
                GlStateManager.enableTexture2D();
                final Object llllllllllIllllIlIlIIIllllIIlIII = this.shaderSamplers.get(this.samplerNames.get(llllllllllIllllIlIlIIIllllIIlIIl));
                int llllllllllIllllIlIlIIIllllIIIlll = -1;
                if (llllllllllIllllIlIlIIIllllIIlIII instanceof Framebuffer) {
                    llllllllllIllllIlIlIIIllllIIIlll = ((Framebuffer)llllllllllIllllIlIlIIIllllIIlIII).framebufferTexture;
                }
                else if (llllllllllIllllIlIlIIIllllIIlIII instanceof ITextureObject) {
                    llllllllllIllllIlIlIIIllllIIIlll = ((ITextureObject)llllllllllIllllIlIlIIIllllIIlIII).getGlTextureId();
                }
                else if (llllllllllIllllIlIlIIIllllIIlIII instanceof Integer) {
                    llllllllllIllllIlIlIIIllllIIIlll = (int)llllllllllIllllIlIlIIIllllIIlIII;
                }
                if (llllllllllIllllIlIlIIIllllIIIlll != -1) {
                    GlStateManager.bindTexture(llllllllllIllllIlIlIIIllllIIIlll);
                    OpenGlHelper.glUniform1i(OpenGlHelper.glGetUniformLocation(this.program, this.samplerNames.get(llllllllllIllllIlIlIIIllllIIlIIl)), llllllllllIllllIlIlIIIllllIIlIIl);
                }
            }
        }
        for (final ShaderUniform llllllllllIllllIlIlIIIllllIIIllI : this.shaderUniforms) {
            llllllllllIllllIlIlIIIllllIIIllI.upload();
        }
    }
    
    @Nullable
    public ShaderUniform getShaderUniform(final String llllllllllIllllIlIlIIIlllIlllIll) {
        return this.mappedShaderUniforms.get(llllllllllIllllIlIlIIIlllIlllIll);
    }
    
    public int getProgram() {
        return this.program;
    }
    
    public void deleteShader() {
        ShaderLinkHelper.getStaticShaderLinkHelper().deleteShader(this);
    }
    
    private void parseUniform(final JsonElement llllllllllIllllIlIlIIIllIllIlIlI) throws JsonException {
        final JsonObject llllllllllIllllIlIlIIIllIlllIlll = JsonUtils.getJsonObject(llllllllllIllllIlIlIIIllIllIlIlI, "uniform");
        final String llllllllllIllllIlIlIIIllIlllIllI = JsonUtils.getString(llllllllllIllllIlIlIIIllIlllIlll, "name");
        final int llllllllllIllllIlIlIIIllIlllIlIl = ShaderUniform.parseType(JsonUtils.getString(llllllllllIllllIlIlIIIllIlllIlll, "type"));
        final int llllllllllIllllIlIlIIIllIlllIlII = JsonUtils.getInt(llllllllllIllllIlIlIIIllIlllIlll, "count");
        final float[] llllllllllIllllIlIlIIIllIlllIIll = new float[Math.max(llllllllllIllllIlIlIIIllIlllIlII, 16)];
        final JsonArray llllllllllIllllIlIlIIIllIlllIIlI = JsonUtils.getJsonArray(llllllllllIllllIlIlIIIllIlllIlll, "values");
        if (llllllllllIllllIlIlIIIllIlllIIlI.size() != llllllllllIllllIlIlIIIllIlllIlII && llllllllllIllllIlIlIIIllIlllIIlI.size() > 1) {
            throw new JsonException("Invalid amount of values specified (expected " + llllllllllIllllIlIlIIIllIlllIlII + ", found " + llllllllllIllllIlIlIIIllIlllIIlI.size() + ")");
        }
        int llllllllllIllllIlIlIIIllIlllIIIl = 0;
        for (final JsonElement llllllllllIllllIlIlIIIllIlllIIII : llllllllllIllllIlIlIIIllIlllIIlI) {
            try {
                llllllllllIllllIlIlIIIllIlllIIll[llllllllllIllllIlIlIIIllIlllIIIl] = JsonUtils.getFloat(llllllllllIllllIlIlIIIllIlllIIII, "value");
            }
            catch (Exception llllllllllIllllIlIlIIIllIllIllll) {
                final JsonException llllllllllIllllIlIlIIIllIllIlllI = JsonException.forException(llllllllllIllllIlIlIIIllIllIllll);
                llllllllllIllllIlIlIIIllIllIlllI.prependJsonKey("values[" + llllllllllIllllIlIlIIIllIlllIIIl + "]");
                throw llllllllllIllllIlIlIIIllIllIlllI;
            }
            ++llllllllllIllllIlIlIIIllIlllIIIl;
        }
        if (llllllllllIllllIlIlIIIllIlllIlII > 1 && llllllllllIllllIlIlIIIllIlllIIlI.size() == 1) {
            while (llllllllllIllllIlIlIIIllIlllIIIl < llllllllllIllllIlIlIIIllIlllIlII) {
                llllllllllIllllIlIlIIIllIlllIIll[llllllllllIllllIlIlIIIllIlllIIIl] = llllllllllIllllIlIlIIIllIlllIIll[0];
                ++llllllllllIllllIlIlIIIllIlllIIIl;
            }
        }
        final int llllllllllIllllIlIlIIIllIllIllIl = (llllllllllIllllIlIlIIIllIlllIlII > 1 && llllllllllIllllIlIlIIIllIlllIlII <= 4 && llllllllllIllllIlIlIIIllIlllIlIl < 8) ? (llllllllllIllllIlIlIIIllIlllIlII - 1) : 0;
        final ShaderUniform llllllllllIllllIlIlIIIllIllIllII = new ShaderUniform(llllllllllIllllIlIlIIIllIlllIllI, llllllllllIllllIlIlIIIllIlllIlIl + llllllllllIllllIlIlIIIllIllIllIl, llllllllllIllllIlIlIIIllIlllIlII, this);
        if (llllllllllIllllIlIlIIIllIlllIlIl <= 3) {
            llllllllllIllllIlIlIIIllIllIllII.set((int)llllllllllIllllIlIlIIIllIlllIIll[0], (int)llllllllllIllllIlIlIIIllIlllIIll[1], (int)llllllllllIllllIlIlIIIllIlllIIll[2], (int)llllllllllIllllIlIlIIIllIlllIIll[3]);
        }
        else if (llllllllllIllllIlIlIIIllIlllIlIl <= 7) {
            llllllllllIllllIlIlIIIllIllIllII.setSafe(llllllllllIllllIlIlIIIllIlllIIll[0], llllllllllIllllIlIlIIIllIlllIIll[1], llllllllllIllllIlIlIIIllIlllIIll[2], llllllllllIllllIlIlIIIllIlllIIll[3]);
        }
        else {
            llllllllllIllllIlIlIIIllIllIllII.set(llllllllllIllllIlIlIIIllIlllIIll);
        }
        this.shaderUniforms.add(llllllllllIllllIlIlIIIllIllIllII);
    }
    
    public ShaderLoader getVertexShaderLoader() {
        return this.vertexShaderLoader;
    }
    
    private void setupUniforms() {
        for (int llllllllllIllllIlIlIIIlllIlIlIII = 0, llllllllllIllllIlIlIIIlllIlIIlll = 0; llllllllllIllllIlIlIIIlllIlIlIII < this.samplerNames.size(); ++llllllllllIllllIlIlIIIlllIlIlIII, ++llllllllllIllllIlIlIIIlllIlIIlll) {
            final String llllllllllIllllIlIlIIIlllIlIIllI = this.samplerNames.get(llllllllllIllllIlIlIIIlllIlIlIII);
            final int llllllllllIllllIlIlIIIlllIlIIlIl = OpenGlHelper.glGetUniformLocation(this.program, llllllllllIllllIlIlIIIlllIlIIllI);
            if (llllllllllIllllIlIlIIIlllIlIIlIl == -1) {
                ShaderManager.LOGGER.warn("Shader {}could not find sampler named {} in the specified shader program.", (Object)this.programFilename, (Object)llllllllllIllllIlIlIIIlllIlIIllI);
                this.shaderSamplers.remove(llllllllllIllllIlIlIIIlllIlIIllI);
                this.samplerNames.remove(llllllllllIllllIlIlIIIlllIlIIlll);
                --llllllllllIllllIlIlIIIlllIlIIlll;
            }
            else {
                this.shaderSamplerLocations.add(llllllllllIllllIlIlIIIlllIlIIlIl);
            }
        }
        for (final ShaderUniform llllllllllIllllIlIlIIIlllIlIIlII : this.shaderUniforms) {
            final String llllllllllIllllIlIlIIIlllIlIIIll = llllllllllIllllIlIlIIIlllIlIIlII.getShaderName();
            final int llllllllllIllllIlIlIIIlllIlIIIlI = OpenGlHelper.glGetUniformLocation(this.program, llllllllllIllllIlIlIIIlllIlIIIll);
            if (llllllllllIllllIlIlIIIlllIlIIIlI == -1) {
                ShaderManager.LOGGER.warn("Could not find uniform named {} in the specified shader program.", (Object)llllllllllIllllIlIlIIIlllIlIIIll);
            }
            else {
                this.shaderUniformLocations.add(llllllllllIllllIlIlIIIlllIlIIIlI);
                llllllllllIllllIlIlIIIlllIlIIlII.setUniformLocation(llllllllllIllllIlIlIIIlllIlIIIlI);
                this.mappedShaderUniforms.put(llllllllllIllllIlIlIIIlllIlIIIll, llllllllllIllllIlIlIIIlllIlIIlII);
            }
        }
    }
    
    public void addSamplerTexture(final String llllllllllIllllIlIlIIIlllIIIlIII, final Object llllllllllIllllIlIlIIIlllIIIlIlI) {
        if (this.shaderSamplers.containsKey(llllllllllIllllIlIlIIIlllIIIlIII)) {
            this.shaderSamplers.remove(llllllllllIllllIlIlIIIlllIIIlIII);
        }
        this.shaderSamplers.put(llllllllllIllllIlIlIIIlllIIIlIII, llllllllllIllllIlIlIIIlllIIIlIlI);
        this.markDirty();
    }
    
    public ShaderUniform getShaderUniformOrDefault(final String llllllllllIllllIlIlIIIlllIllIIIl) {
        final ShaderUniform llllllllllIllllIlIlIIIlllIllIIll = this.getShaderUniform(llllllllllIllllIlIlIIIlllIllIIIl);
        return (llllllllllIllllIlIlIIIlllIllIIll == null) ? ShaderManager.DEFAULT_SHADER_UNIFORM : llllllllllIllllIlIlIIIlllIllIIll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DEFAULT_SHADER_UNIFORM = new ShaderDefault();
        ShaderManager.currentProgram = -1;
        ShaderManager.lastCull = true;
    }
    
    public void endShader() {
        OpenGlHelper.glUseProgram(0);
        ShaderManager.currentProgram = -1;
        ShaderManager.staticShaderManager = null;
        ShaderManager.lastCull = true;
        for (int llllllllllIllllIlIlIIIllllIlIIIl = 0; llllllllllIllllIlIlIIIllllIlIIIl < this.shaderSamplerLocations.size(); ++llllllllllIllllIlIlIIIllllIlIIIl) {
            if (this.shaderSamplers.get(this.samplerNames.get(llllllllllIllllIlIlIIIllllIlIIIl)) != null) {
                GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllIllllIlIlIIIllllIlIIIl);
                GlStateManager.bindTexture(0);
            }
        }
    }
    
    public void markDirty() {
        this.isDirty = true;
    }
    
    private void parseSampler(final JsonElement llllllllllIllllIlIlIIIlllIIlIIlI) throws JsonException {
        final JsonObject llllllllllIllllIlIlIIIlllIIlIlIl = JsonUtils.getJsonObject(llllllllllIllllIlIlIIIlllIIlIIlI, "sampler");
        final String llllllllllIllllIlIlIIIlllIIlIlII = JsonUtils.getString(llllllllllIllllIlIlIIIlllIIlIlIl, "name");
        if (!JsonUtils.isString(llllllllllIllllIlIlIIIlllIIlIlIl, "file")) {
            this.shaderSamplers.put(llllllllllIllllIlIlIIIlllIIlIlII, null);
            this.samplerNames.add(llllllllllIllllIlIlIIIlllIIlIlII);
        }
        else {
            this.samplerNames.add(llllllllllIllllIlIlIIIlllIIlIlII);
        }
    }
}
