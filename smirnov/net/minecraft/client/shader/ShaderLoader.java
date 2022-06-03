// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.shader;

import com.google.common.collect.Maps;
import java.util.Map;
import java.io.IOException;
import java.nio.ByteBuffer;
import net.minecraft.client.resources.IResource;
import java.io.Closeable;
import net.minecraft.client.util.JsonException;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.BufferUtils;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import java.io.BufferedInputStream;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.renderer.OpenGlHelper;

public class ShaderLoader
{
    private /* synthetic */ int shaderAttachCount;
    private final /* synthetic */ int shader;
    private final /* synthetic */ ShaderType shaderType;
    private final /* synthetic */ String shaderFilename;
    
    private ShaderLoader(final ShaderType llllllllllllllIIIIIllllllIllIIll, final int llllllllllllllIIIIIllllllIllIIlI, final String llllllllllllllIIIIIllllllIlIllIl) {
        this.shaderType = llllllllllllllIIIIIllllllIllIIll;
        this.shader = llllllllllllllIIIIIllllllIllIIlI;
        this.shaderFilename = llllllllllllllIIIIIllllllIlIllIl;
    }
    
    public void attachShader(final ShaderManager llllllllllllllIIIIIllllllIlIIlll) {
        ++this.shaderAttachCount;
        OpenGlHelper.glAttachShader(llllllllllllllIIIIIllllllIlIIlll.getProgram(), this.shader);
    }
    
    public String getShaderFilename() {
        return this.shaderFilename;
    }
    
    public static ShaderLoader loadShader(final IResourceManager llllllllllllllIIIIIllllllIIlIIll, final ShaderType llllllllllllllIIIIIllllllIIlIIlI, final String llllllllllllllIIIIIllllllIIIIllI) throws IOException {
        ShaderLoader llllllllllllllIIIIIllllllIIlIIII = llllllllllllllIIIIIllllllIIlIIlI.getLoadedShaders().get(llllllllllllllIIIIIllllllIIIIllI);
        if (llllllllllllllIIIIIllllllIIlIIII == null) {
            final ResourceLocation llllllllllllllIIIIIllllllIIIllll = new ResourceLocation("shaders/program/" + llllllllllllllIIIIIllllllIIIIllI + llllllllllllllIIIIIllllllIIlIIlI.getShaderExtension());
            final IResource llllllllllllllIIIIIllllllIIIlllI = llllllllllllllIIIIIllllllIIlIIll.getResource(llllllllllllllIIIIIllllllIIIllll);
            try {
                final byte[] llllllllllllllIIIIIllllllIIIllIl = IOUtils.toByteArray((InputStream)new BufferedInputStream(llllllllllllllIIIIIllllllIIIlllI.getInputStream()));
                final ByteBuffer llllllllllllllIIIIIllllllIIIllII = BufferUtils.createByteBuffer(llllllllllllllIIIIIllllllIIIllIl.length);
                llllllllllllllIIIIIllllllIIIllII.put(llllllllllllllIIIIIllllllIIIllIl);
                llllllllllllllIIIIIllllllIIIllII.position(0);
                final int llllllllllllllIIIIIllllllIIIlIll = OpenGlHelper.glCreateShader(llllllllllllllIIIIIllllllIIlIIlI.getShaderMode());
                OpenGlHelper.glShaderSource(llllllllllllllIIIIIllllllIIIlIll, llllllllllllllIIIIIllllllIIIllII);
                OpenGlHelper.glCompileShader(llllllllllllllIIIIIllllllIIIlIll);
                if (OpenGlHelper.glGetShaderi(llllllllllllllIIIIIllllllIIIlIll, OpenGlHelper.GL_COMPILE_STATUS) == 0) {
                    final String llllllllllllllIIIIIllllllIIIlIlI = StringUtils.trim(OpenGlHelper.glGetShaderInfoLog(llllllllllllllIIIIIllllllIIIlIll, 32768));
                    final JsonException llllllllllllllIIIIIllllllIIIlIIl = new JsonException("Couldn't compile " + llllllllllllllIIIIIllllllIIlIIlI.getShaderName() + " program: " + llllllllllllllIIIIIllllllIIIlIlI);
                    llllllllllllllIIIIIllllllIIIlIIl.setFilenameAndFlush(llllllllllllllIIIIIllllllIIIllll.getResourcePath());
                    throw llllllllllllllIIIIIllllllIIIlIIl;
                }
                llllllllllllllIIIIIllllllIIlIIII = new ShaderLoader(llllllllllllllIIIIIllllllIIlIIlI, llllllllllllllIIIIIllllllIIIlIll, llllllllllllllIIIIIllllllIIIIllI);
                llllllllllllllIIIIIllllllIIlIIlI.getLoadedShaders().put(llllllllllllllIIIIIllllllIIIIllI, llllllllllllllIIIIIllllllIIlIIII);
            }
            finally {
                IOUtils.closeQuietly((Closeable)llllllllllllllIIIIIllllllIIIlllI);
            }
            IOUtils.closeQuietly((Closeable)llllllllllllllIIIIIllllllIIIlllI);
        }
        return llllllllllllllIIIIIllllllIIlIIII;
    }
    
    public void deleteShader(final ShaderManager llllllllllllllIIIIIllllllIlIIlII) {
        --this.shaderAttachCount;
        if (this.shaderAttachCount <= 0) {
            OpenGlHelper.glDeleteShader(this.shader);
            this.shaderType.getLoadedShaders().remove(this.shaderFilename);
        }
    }
    
    public enum ShaderType
    {
        private final /* synthetic */ String shaderExtension;
        private final /* synthetic */ Map<String, ShaderLoader> loadedShaders;
        
        FRAGMENT("FRAGMENT", 1, "fragment", ".fsh", OpenGlHelper.GL_FRAGMENT_SHADER);
        
        private final /* synthetic */ int shaderMode;
        private final /* synthetic */ String shaderName;
        
        VERTEX("VERTEX", 0, "vertex", ".vsh", OpenGlHelper.GL_VERTEX_SHADER);
        
        private int getShaderMode() {
            return this.shaderMode;
        }
        
        private ShaderType(final String lllllllllllIIIlIlllIlllIlllIllII, final int lllllllllllIIIlIlllIlllIlllIlIll, final String lllllllllllIIIlIlllIlllIlllIlIlI, final String lllllllllllIIIlIlllIlllIlllIllll, final int lllllllllllIIIlIlllIlllIlllIlllI) {
            this.loadedShaders = (Map<String, ShaderLoader>)Maps.newHashMap();
            this.shaderName = lllllllllllIIIlIlllIlllIlllIlIlI;
            this.shaderExtension = lllllllllllIIIlIlllIlllIlllIllll;
            this.shaderMode = lllllllllllIIIlIlllIlllIlllIlllI;
        }
        
        private String getShaderExtension() {
            return this.shaderExtension;
        }
        
        public String getShaderName() {
            return this.shaderName;
        }
        
        private Map<String, ShaderLoader> getLoadedShaders() {
            return this.loadedShaders;
        }
    }
}
