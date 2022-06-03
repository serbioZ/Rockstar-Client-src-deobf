// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.shader;

import net.minecraft.client.util.JsonException;
import java.io.IOException;
import net.minecraft.client.renderer.OpenGlHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShaderLinkHelper
{
    private static final /* synthetic */ Logger LOGGER;
    private static /* synthetic */ ShaderLinkHelper staticShaderLinkHelper;
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public static void setNewStaticShaderLinkHelper() {
        ShaderLinkHelper.staticShaderLinkHelper = new ShaderLinkHelper();
    }
    
    public void linkProgram(final ShaderManager lllllllllllllIlIlIlIIIIIllllIIlI) throws IOException {
        lllllllllllllIlIlIlIIIIIllllIIlI.getFragmentShaderLoader().attachShader(lllllllllllllIlIlIlIIIIIllllIIlI);
        lllllllllllllIlIlIlIIIIIllllIIlI.getVertexShaderLoader().attachShader(lllllllllllllIlIlIlIIIIIllllIIlI);
        OpenGlHelper.glLinkProgram(lllllllllllllIlIlIlIIIIIllllIIlI.getProgram());
        final int lllllllllllllIlIlIlIIIIIllllIIll = OpenGlHelper.glGetProgrami(lllllllllllllIlIlIlIIIIIllllIIlI.getProgram(), OpenGlHelper.GL_LINK_STATUS);
        if (lllllllllllllIlIlIlIIIIIllllIIll == 0) {
            ShaderLinkHelper.LOGGER.warn("Error encountered when linking program containing VS {} and FS {}. Log output:", (Object)lllllllllllllIlIlIlIIIIIllllIIlI.getVertexShaderLoader().getShaderFilename(), (Object)lllllllllllllIlIlIlIIIIIllllIIlI.getFragmentShaderLoader().getShaderFilename());
            ShaderLinkHelper.LOGGER.warn(OpenGlHelper.glGetProgramInfoLog(lllllllllllllIlIlIlIIIIIllllIIlI.getProgram(), 32768));
        }
    }
    
    public static ShaderLinkHelper getStaticShaderLinkHelper() {
        return ShaderLinkHelper.staticShaderLinkHelper;
    }
    
    public void deleteShader(final ShaderManager lllllllllllllIlIlIlIIIIIllllllIl) {
        lllllllllllllIlIlIlIIIIIllllllIl.getFragmentShaderLoader().deleteShader(lllllllllllllIlIlIlIIIIIllllllIl);
        lllllllllllllIlIlIlIIIIIllllllIl.getVertexShaderLoader().deleteShader(lllllllllllllIlIlIlIIIIIllllllIl);
        OpenGlHelper.glDeleteProgram(lllllllllllllIlIlIlIIIIIllllllIl.getProgram());
    }
    
    public int createProgram() throws JsonException {
        final int lllllllllllllIlIlIlIIIIIlllllIIl = OpenGlHelper.glCreateProgram();
        if (lllllllllllllIlIlIlIIIIIlllllIIl <= 0) {
            throw new JsonException("Could not create shader program (returned program ID " + lllllllllllllIlIlIlIIIIIlllllIIl + ")");
        }
        return lllllllllllllIlIlIlIIIIIlllllIIl;
    }
}
