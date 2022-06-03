// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import org.lwjgl.opengl.ARBVertexShader;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.Sys;
import java.net.URI;
import java.io.IOException;
import net.minecraft.util.Util;
import java.io.File;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.ARBVertexBufferObject;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.EXTBlendFuncSeparate;
import oshi.hardware.Processor;
import org.lwjgl.opengl.ContextCapabilities;
import oshi.SystemInfo;
import net.minecraft.client.settings.GameSettings;
import java.util.Locale;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.ARBFramebufferObject;
import org.lwjgl.opengl.GL30;
import net.minecraft.client.Minecraft;
import optifine.Config;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.ARBMultitexture;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.ARBShaderObjects;
import org.apache.logging.log4j.Logger;

public class OpenGlHelper
{
    public static /* synthetic */ int GL_SOURCE0_RGB;
    public static /* synthetic */ int GL_LINK_STATUS;
    public static /* synthetic */ int GL_DEPTH_ATTACHMENT;
    private static /* synthetic */ boolean arbShaders;
    public static /* synthetic */ boolean nvidia;
    public static /* synthetic */ float lastBrightnessX;
    public static /* synthetic */ int GL_COLOR_ATTACHMENT0;
    public static /* synthetic */ int GL_FB_INCOMPLETE_DRAW_BUFFER;
    public static /* synthetic */ boolean framebufferSupported;
    public static /* synthetic */ int GL_OPERAND0_RGB;
    public static /* synthetic */ boolean openGL21;
    private static final /* synthetic */ Logger LOGGER;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode;
    public static /* synthetic */ int GL_VERTEX_SHADER;
    public static /* synthetic */ int lightmapTexUnit;
    private static /* synthetic */ String logText;
    public static /* synthetic */ int GL_OPERAND0_ALPHA;
    public static /* synthetic */ float lastBrightnessY;
    public static /* synthetic */ int GL_CONSTANT;
    public static /* synthetic */ boolean vboSupportedAti;
    public static /* synthetic */ int GL_SOURCE1_RGB;
    public static /* synthetic */ boolean extBlendFuncSeparate;
    public static /* synthetic */ int GL_SOURCE2_RGB;
    public static /* synthetic */ int GL_PRIMARY_COLOR;
    private static /* synthetic */ boolean arbTextureEnvCombine;
    public static /* synthetic */ int GL_ARRAY_BUFFER;
    private static /* synthetic */ String cpu;
    public static /* synthetic */ int GL_OPERAND1_RGB;
    public static /* synthetic */ int GL_FRAGMENT_SHADER;
    private static /* synthetic */ boolean openGL14;
    private static /* synthetic */ boolean arbVbo;
    private static /* synthetic */ boolean shadersAvailable;
    private static /* synthetic */ FboMode framebufferType;
    public static /* synthetic */ int GL_COMBINE;
    public static /* synthetic */ boolean ati;
    public static /* synthetic */ int GL_RENDERBUFFER;
    public static /* synthetic */ int GL_INTERPOLATE;
    public static /* synthetic */ int GL_SOURCE2_ALPHA;
    public static /* synthetic */ int GL_FB_INCOMPLETE_ATTACHMENT;
    public static /* synthetic */ int GL_FRAMEBUFFER;
    public static /* synthetic */ int GL_SOURCE0_ALPHA;
    public static /* synthetic */ int GL_COMBINE_ALPHA;
    public static /* synthetic */ boolean shadersSupported;
    public static /* synthetic */ int GL_TEXTURE2;
    public static /* synthetic */ int GL_STATIC_DRAW;
    public static /* synthetic */ int GL_SOURCE1_ALPHA;
    public static /* synthetic */ int GL_COMPILE_STATUS;
    public static /* synthetic */ int GL_FRAMEBUFFER_COMPLETE;
    public static /* synthetic */ int GL_COMBINE_RGB;
    public static /* synthetic */ int GL_FB_INCOMPLETE_MISS_ATTACH;
    public static /* synthetic */ int GL_OPERAND2_RGB;
    public static /* synthetic */ int GL_FB_INCOMPLETE_READ_BUFFER;
    public static /* synthetic */ int GL_PREVIOUS;
    public static /* synthetic */ int GL_OPERAND1_ALPHA;
    private static /* synthetic */ boolean arbMultitexture;
    public static /* synthetic */ boolean vboSupported;
    public static /* synthetic */ int defaultTexUnit;
    public static /* synthetic */ int GL_OPERAND2_ALPHA;
    
    public static int glGetShaderi(final int llllllllllllllIIlIIllIIlllllIllI, final int llllllllllllllIIlIIllIIlllllIlIl) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetObjectParameteriARB(llllllllllllllIIlIIllIIlllllIllI, llllllllllllllIIlIIllIIlllllIlIl) : GL20.glGetShaderi(llllllllllllllIIlIIllIIlllllIllI, llllllllllllllIIlIIllIIlllllIlIl);
    }
    
    public static void setClientActiveTexture(final int llllllllllllllIIlIIllIIlIIlIllll) {
        if (OpenGlHelper.arbMultitexture) {
            ARBMultitexture.glClientActiveTextureARB(llllllllllllllIIlIIllIIlIIlIllll);
        }
        else {
            GL13.glClientActiveTexture(llllllllllllllIIlIIllIIlIIlIllll);
        }
    }
    
    public static int glGetProgrami(final int llllllllllllllIIlIIllIlIIIIlIIll, final int llllllllllllllIIlIIllIlIIIIlIIII) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetObjectParameteriARB(llllllllllllllIIlIIllIlIIIIlIIll, llllllllllllllIIlIIllIlIIIIlIIII) : GL20.glGetProgrami(llllllllllllllIIlIIllIlIIIIlIIll, llllllllllllllIIlIIllIlIIIIlIIII);
    }
    
    public static void glAttachShader(final int llllllllllllllIIlIIllIlIIIIIllIl, final int llllllllllllllIIlIIllIlIIIIIlIlI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glAttachObjectARB(llllllllllllllIIlIIllIlIIIIIllIl, llllllllllllllIIlIIllIlIIIIIlIlI);
        }
        else {
            GL20.glAttachShader(llllllllllllllIIlIIllIlIIIIIllIl, llllllllllllllIIlIIllIlIIIIIlIlI);
        }
    }
    
    public static void glUniform1(final int llllllllllllllIIlIIllIIlllIIlIIl, final FloatBuffer llllllllllllllIIlIIllIIlllIIlIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform1ARB(llllllllllllllIIlIIllIIlllIIlIIl, llllllllllllllIIlIIllIIlllIIlIII);
        }
        else {
            GL20.glUniform1(llllllllllllllIIlIIllIIlllIIlIIl, llllllllllllllIIlIIllIIlllIIlIII);
        }
    }
    
    public static void setLightmapTextureCoords(final int llllllllllllllIIlIIllIIlIIlIlIII, final float llllllllllllllIIlIIllIIlIIlIlIlI, final float llllllllllllllIIlIIllIIlIIlIIllI) {
        if (OpenGlHelper.arbMultitexture) {
            ARBMultitexture.glMultiTexCoord2fARB(llllllllllllllIIlIIllIIlIIlIlIII, llllllllllllllIIlIIllIIlIIlIlIlI, llllllllllllllIIlIIllIIlIIlIIllI);
        }
        else {
            GL13.glMultiTexCoord2f(llllllllllllllIIlIIllIIlIIlIlIII, llllllllllllllIIlIIllIIlIIlIlIlI, llllllllllllllIIlIIllIIlIIlIIllI);
        }
        if (llllllllllllllIIlIIllIIlIIlIlIII == OpenGlHelper.lightmapTexUnit) {
            OpenGlHelper.lastBrightnessX = llllllllllllllIIlIIllIIlIIlIlIlI;
            OpenGlHelper.lastBrightnessY = llllllllllllllIIlIIllIIlIIlIIllI;
        }
    }
    
    public static boolean useVbo() {
        return !Config.isMultiTexture() && (OpenGlHelper.vboSupported && Minecraft.getMinecraft().gameSettings.useVbo);
    }
    
    public static int glCheckFramebufferStatus(final int llllllllllllllIIlIIllIIlIlIIIlII) {
        if (!OpenGlHelper.framebufferSupported) {
            return -1;
        }
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
            case 1: {
                return GL30.glCheckFramebufferStatus(llllllllllllllIIlIIllIIlIlIIIlII);
            }
            case 2: {
                return ARBFramebufferObject.glCheckFramebufferStatus(llllllllllllllIIlIIllIIlIlIIIlII);
            }
            case 3: {
                return EXTFramebufferObject.glCheckFramebufferStatusEXT(llllllllllllllIIlIIllIIlIlIIIlII);
            }
            default: {
                return -1;
            }
        }
    }
    
    public static void glCompileShader(final int llllllllllllllIIlIIllIIlllllllII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glCompileShaderARB(llllllllllllllIIlIIllIIlllllllII);
        }
        else {
            GL20.glCompileShader(llllllllllllllIIlIIllIIlllllllII);
        }
    }
    
    public static void initializeTextures() {
        Config.initDisplay();
        final ContextCapabilities llllllllllllllIIlIIllIlIIIIllIll = GLContext.getCapabilities();
        OpenGlHelper.arbMultitexture = (llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_multitexture && !llllllllllllllIIlIIllIlIIIIllIll.OpenGL13);
        OpenGlHelper.arbTextureEnvCombine = (llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_texture_env_combine && !llllllllllllllIIlIIllIlIIIIllIll.OpenGL13);
        if (OpenGlHelper.arbMultitexture) {
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "Using ARB_multitexture.\n";
            OpenGlHelper.defaultTexUnit = 33984;
            OpenGlHelper.lightmapTexUnit = 33985;
            OpenGlHelper.GL_TEXTURE2 = 33986;
        }
        else {
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "Using GL 1.3 multitexturing.\n";
            OpenGlHelper.defaultTexUnit = 33984;
            OpenGlHelper.lightmapTexUnit = 33985;
            OpenGlHelper.GL_TEXTURE2 = 33986;
        }
        if (OpenGlHelper.arbTextureEnvCombine) {
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "Using ARB_texture_env_combine.\n";
            OpenGlHelper.GL_COMBINE = 34160;
            OpenGlHelper.GL_INTERPOLATE = 34165;
            OpenGlHelper.GL_PRIMARY_COLOR = 34167;
            OpenGlHelper.GL_CONSTANT = 34166;
            OpenGlHelper.GL_PREVIOUS = 34168;
            OpenGlHelper.GL_COMBINE_RGB = 34161;
            OpenGlHelper.GL_SOURCE0_RGB = 34176;
            OpenGlHelper.GL_SOURCE1_RGB = 34177;
            OpenGlHelper.GL_SOURCE2_RGB = 34178;
            OpenGlHelper.GL_OPERAND0_RGB = 34192;
            OpenGlHelper.GL_OPERAND1_RGB = 34193;
            OpenGlHelper.GL_OPERAND2_RGB = 34194;
            OpenGlHelper.GL_COMBINE_ALPHA = 34162;
            OpenGlHelper.GL_SOURCE0_ALPHA = 34184;
            OpenGlHelper.GL_SOURCE1_ALPHA = 34185;
            OpenGlHelper.GL_SOURCE2_ALPHA = 34186;
            OpenGlHelper.GL_OPERAND0_ALPHA = 34200;
            OpenGlHelper.GL_OPERAND1_ALPHA = 34201;
            OpenGlHelper.GL_OPERAND2_ALPHA = 34202;
        }
        else {
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "Using GL 1.3 texture combiners.\n";
            OpenGlHelper.GL_COMBINE = 34160;
            OpenGlHelper.GL_INTERPOLATE = 34165;
            OpenGlHelper.GL_PRIMARY_COLOR = 34167;
            OpenGlHelper.GL_CONSTANT = 34166;
            OpenGlHelper.GL_PREVIOUS = 34168;
            OpenGlHelper.GL_COMBINE_RGB = 34161;
            OpenGlHelper.GL_SOURCE0_RGB = 34176;
            OpenGlHelper.GL_SOURCE1_RGB = 34177;
            OpenGlHelper.GL_SOURCE2_RGB = 34178;
            OpenGlHelper.GL_OPERAND0_RGB = 34192;
            OpenGlHelper.GL_OPERAND1_RGB = 34193;
            OpenGlHelper.GL_OPERAND2_RGB = 34194;
            OpenGlHelper.GL_COMBINE_ALPHA = 34162;
            OpenGlHelper.GL_SOURCE0_ALPHA = 34184;
            OpenGlHelper.GL_SOURCE1_ALPHA = 34185;
            OpenGlHelper.GL_SOURCE2_ALPHA = 34186;
            OpenGlHelper.GL_OPERAND0_ALPHA = 34200;
            OpenGlHelper.GL_OPERAND1_ALPHA = 34201;
            OpenGlHelper.GL_OPERAND2_ALPHA = 34202;
        }
        OpenGlHelper.extBlendFuncSeparate = (llllllllllllllIIlIIllIlIIIIllIll.GL_EXT_blend_func_separate && !llllllllllllllIIlIIllIlIIIIllIll.OpenGL14);
        OpenGlHelper.openGL14 = (llllllllllllllIIlIIllIlIIIIllIll.OpenGL14 || llllllllllllllIIlIIllIlIIIIllIll.GL_EXT_blend_func_separate);
        OpenGlHelper.framebufferSupported = (OpenGlHelper.openGL14 && (llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_framebuffer_object || llllllllllllllIIlIIllIlIIIIllIll.GL_EXT_framebuffer_object || llllllllllllllIIlIIllIlIIIIllIll.OpenGL30));
        if (OpenGlHelper.framebufferSupported) {
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "Using framebuffer objects because ";
            if (llllllllllllllIIlIIllIlIIIIllIll.OpenGL30) {
                OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "OpenGL 3.0 is supported and separate blending is supported.\n";
                OpenGlHelper.framebufferType = FboMode.BASE;
                OpenGlHelper.GL_FRAMEBUFFER = 36160;
                OpenGlHelper.GL_RENDERBUFFER = 36161;
                OpenGlHelper.GL_COLOR_ATTACHMENT0 = 36064;
                OpenGlHelper.GL_DEPTH_ATTACHMENT = 36096;
                OpenGlHelper.GL_FRAMEBUFFER_COMPLETE = 36053;
                OpenGlHelper.GL_FB_INCOMPLETE_ATTACHMENT = 36054;
                OpenGlHelper.GL_FB_INCOMPLETE_MISS_ATTACH = 36055;
                OpenGlHelper.GL_FB_INCOMPLETE_DRAW_BUFFER = 36059;
                OpenGlHelper.GL_FB_INCOMPLETE_READ_BUFFER = 36060;
            }
            else if (llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_framebuffer_object) {
                OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "ARB_framebuffer_object is supported and separate blending is supported.\n";
                OpenGlHelper.framebufferType = FboMode.ARB;
                OpenGlHelper.GL_FRAMEBUFFER = 36160;
                OpenGlHelper.GL_RENDERBUFFER = 36161;
                OpenGlHelper.GL_COLOR_ATTACHMENT0 = 36064;
                OpenGlHelper.GL_DEPTH_ATTACHMENT = 36096;
                OpenGlHelper.GL_FRAMEBUFFER_COMPLETE = 36053;
                OpenGlHelper.GL_FB_INCOMPLETE_MISS_ATTACH = 36055;
                OpenGlHelper.GL_FB_INCOMPLETE_ATTACHMENT = 36054;
                OpenGlHelper.GL_FB_INCOMPLETE_DRAW_BUFFER = 36059;
                OpenGlHelper.GL_FB_INCOMPLETE_READ_BUFFER = 36060;
            }
            else if (llllllllllllllIIlIIllIlIIIIllIll.GL_EXT_framebuffer_object) {
                OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "EXT_framebuffer_object is supported.\n";
                OpenGlHelper.framebufferType = FboMode.EXT;
                OpenGlHelper.GL_FRAMEBUFFER = 36160;
                OpenGlHelper.GL_RENDERBUFFER = 36161;
                OpenGlHelper.GL_COLOR_ATTACHMENT0 = 36064;
                OpenGlHelper.GL_DEPTH_ATTACHMENT = 36096;
                OpenGlHelper.GL_FRAMEBUFFER_COMPLETE = 36053;
                OpenGlHelper.GL_FB_INCOMPLETE_MISS_ATTACH = 36055;
                OpenGlHelper.GL_FB_INCOMPLETE_ATTACHMENT = 36054;
                OpenGlHelper.GL_FB_INCOMPLETE_DRAW_BUFFER = 36059;
                OpenGlHelper.GL_FB_INCOMPLETE_READ_BUFFER = 36060;
            }
        }
        else {
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "Not using framebuffer objects because ";
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "OpenGL 1.4 is " + (llllllllllllllIIlIIllIlIIIIllIll.OpenGL14 ? "" : "not ") + "supported, ";
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "EXT_blend_func_separate is " + (llllllllllllllIIlIIllIlIIIIllIll.GL_EXT_blend_func_separate ? "" : "not ") + "supported, ";
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "OpenGL 3.0 is " + (llllllllllllllIIlIIllIlIIIIllIll.OpenGL30 ? "" : "not ") + "supported, ";
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "ARB_framebuffer_object is " + (llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_framebuffer_object ? "" : "not ") + "supported, and ";
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "EXT_framebuffer_object is " + (llllllllllllllIIlIIllIlIIIIllIll.GL_EXT_framebuffer_object ? "" : "not ") + "supported.\n";
        }
        OpenGlHelper.openGL21 = llllllllllllllIIlIIllIlIIIIllIll.OpenGL21;
        OpenGlHelper.shadersAvailable = (OpenGlHelper.openGL21 || (llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_vertex_shader && llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_fragment_shader && llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_shader_objects));
        OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "Shaders are " + (OpenGlHelper.shadersAvailable ? "" : "not ") + "available because ";
        if (OpenGlHelper.shadersAvailable) {
            if (llllllllllllllIIlIIllIlIIIIllIll.OpenGL21) {
                OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "OpenGL 2.1 is supported.\n";
                OpenGlHelper.arbShaders = false;
                OpenGlHelper.GL_LINK_STATUS = 35714;
                OpenGlHelper.GL_COMPILE_STATUS = 35713;
                OpenGlHelper.GL_VERTEX_SHADER = 35633;
                OpenGlHelper.GL_FRAGMENT_SHADER = 35632;
            }
            else {
                OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "ARB_shader_objects, ARB_vertex_shader, and ARB_fragment_shader are supported.\n";
                OpenGlHelper.arbShaders = true;
                OpenGlHelper.GL_LINK_STATUS = 35714;
                OpenGlHelper.GL_COMPILE_STATUS = 35713;
                OpenGlHelper.GL_VERTEX_SHADER = 35633;
                OpenGlHelper.GL_FRAGMENT_SHADER = 35632;
            }
        }
        else {
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "OpenGL 2.1 is " + (llllllllllllllIIlIIllIlIIIIllIll.OpenGL21 ? "" : "not ") + "supported, ";
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "ARB_shader_objects is " + (llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_shader_objects ? "" : "not ") + "supported, ";
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "ARB_vertex_shader is " + (llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_vertex_shader ? "" : "not ") + "supported, and ";
            OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "ARB_fragment_shader is " + (llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_fragment_shader ? "" : "not ") + "supported.\n";
        }
        OpenGlHelper.shadersSupported = (OpenGlHelper.framebufferSupported && OpenGlHelper.shadersAvailable);
        final String llllllllllllllIIlIIllIlIIIIllIlI = GL11.glGetString(7936).toLowerCase(Locale.ROOT);
        OpenGlHelper.nvidia = llllllllllllllIIlIIllIlIIIIllIlI.contains("nvidia");
        OpenGlHelper.arbVbo = (!llllllllllllllIIlIIllIlIIIIllIll.OpenGL15 && llllllllllllllIIlIIllIlIIIIllIll.GL_ARB_vertex_buffer_object);
        OpenGlHelper.vboSupported = (llllllllllllllIIlIIllIlIIIIllIll.OpenGL15 || OpenGlHelper.arbVbo);
        OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "VBOs are " + (OpenGlHelper.vboSupported ? "" : "not ") + "available because ";
        if (OpenGlHelper.vboSupported) {
            if (OpenGlHelper.arbVbo) {
                OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "ARB_vertex_buffer_object is supported.\n";
                OpenGlHelper.GL_STATIC_DRAW = 35044;
                OpenGlHelper.GL_ARRAY_BUFFER = 34962;
            }
            else {
                OpenGlHelper.logText = String.valueOf(OpenGlHelper.logText) + "OpenGL 1.5 is supported.\n";
                OpenGlHelper.GL_STATIC_DRAW = 35044;
                OpenGlHelper.GL_ARRAY_BUFFER = 34962;
            }
        }
        OpenGlHelper.ati = llllllllllllllIIlIIllIlIIIIllIlI.contains("ati");
        if (OpenGlHelper.ati) {
            if (OpenGlHelper.vboSupported) {
                OpenGlHelper.vboSupportedAti = true;
            }
            else {
                GameSettings.Options.RENDER_DISTANCE.setValueMax(16.0f);
            }
        }
        try {
            final Processor[] llllllllllllllIIlIIllIlIIIIllIIl = new SystemInfo().getHardware().getProcessors();
            OpenGlHelper.cpu = String.format("%dx %s", llllllllllllllIIlIIllIlIIIIllIIl.length, llllllllllllllIIlIIllIlIIIIllIIl[0]).replaceAll("\\s+", " ");
        }
        catch (Throwable t) {}
    }
    
    public static void glUniform4(final int llllllllllllllIIlIIllIIllIlIIlIl, final FloatBuffer llllllllllllllIIlIIllIIllIlIIllI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform4ARB(llllllllllllllIIlIIllIIllIlIIlIl, llllllllllllllIIlIIllIIllIlIIllI);
        }
        else {
            GL20.glUniform4(llllllllllllllIIlIIllIIllIlIIlIl, llllllllllllllIIlIIllIIllIlIIllI);
        }
    }
    
    public static void glBlendFunc(final int llllllllllllllIIlIIllIIlIIIlllIl, final int llllllllllllllIIlIIllIIlIIIlllII, final int llllllllllllllIIlIIllIIlIIIlllll, final int llllllllllllllIIlIIllIIlIIIllllI) {
        if (OpenGlHelper.openGL14) {
            if (OpenGlHelper.extBlendFuncSeparate) {
                EXTBlendFuncSeparate.glBlendFuncSeparateEXT(llllllllllllllIIlIIllIIlIIIlllIl, llllllllllllllIIlIIllIIlIIIlllII, llllllllllllllIIlIIllIIlIIIlllll, llllllllllllllIIlIIllIIlIIIllllI);
            }
            else {
                GL14.glBlendFuncSeparate(llllllllllllllIIlIIllIIlIIIlllIl, llllllllllllllIIlIIllIIlIIIlllII, llllllllllllllIIlIIllIIlIIIlllll, llllllllllllllIIlIIllIIlIIIllllI);
            }
        }
        else {
            GL11.glBlendFunc(llllllllllllllIIlIIllIIlIIIlllIl, llllllllllllllIIlIIllIIlIIIlllII);
        }
    }
    
    public static void glUniform4(final int llllllllllllllIIlIIllIIllIlIlIll, final IntBuffer llllllllllllllIIlIIllIIllIlIlIlI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform4ARB(llllllllllllllIIlIIllIIllIlIlIll, llllllllllllllIIlIIllIIllIlIlIlI);
        }
        else {
            GL20.glUniform4(llllllllllllllIIlIIllIIllIlIlIll, llllllllllllllIIlIIllIIllIlIlIlI);
        }
    }
    
    public static void glBindRenderbuffer(final int llllllllllllllIIlIIllIIlIllIlIII, final int llllllllllllllIIlIIllIIlIllIIlIl) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glBindRenderbuffer(llllllllllllllIIlIIllIIlIllIlIII, llllllllllllllIIlIIllIIlIllIIlIl);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glBindRenderbuffer(llllllllllllllIIlIIllIIlIllIlIII, llllllllllllllIIlIIllIIlIllIIlIl);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glBindRenderbufferEXT(llllllllllllllIIlIIllIIlIllIlIII, llllllllllllllIIlIIllIIlIllIIlIl);
                    break;
                }
            }
        }
    }
    
    public static void glUniformMatrix4(final int llllllllllllllIIlIIllIIllIIIlllI, final boolean llllllllllllllIIlIIllIIllIIIllIl, final FloatBuffer llllllllllllllIIlIIllIIllIIIlIIl) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniformMatrix4ARB(llllllllllllllIIlIIllIIllIIIlllI, llllllllllllllIIlIIllIIllIIIllIl, llllllllllllllIIlIIllIIllIIIlIIl);
        }
        else {
            GL20.glUniformMatrix4(llllllllllllllIIlIIllIIllIIIlllI, llllllllllllllIIlIIllIIllIIIllIl, llllllllllllllIIlIIllIIllIIIlIIl);
        }
    }
    
    public static void glFramebufferRenderbuffer(final int llllllllllllllIIlIIllIIlIlIIlIlI, final int llllllllllllllIIlIIllIIlIlIIllIl, final int llllllllllllllIIlIIllIIlIlIIllII, final int llllllllllllllIIlIIllIIlIlIIIlll) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glFramebufferRenderbuffer(llllllllllllllIIlIIllIIlIlIIlIlI, llllllllllllllIIlIIllIIlIlIIllIl, llllllllllllllIIlIIllIIlIlIIllII, llllllllllllllIIlIIllIIlIlIIIlll);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glFramebufferRenderbuffer(llllllllllllllIIlIIllIIlIlIIlIlI, llllllllllllllIIlIIllIIlIlIIllIl, llllllllllllllIIlIIllIIlIlIIllII, llllllllllllllIIlIIllIIlIlIIIlll);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glFramebufferRenderbufferEXT(llllllllllllllIIlIIllIIlIlIIlIlI, llllllllllllllIIlIIllIIlIlIIllIl, llllllllllllllIIlIIllIIlIlIIllII, llllllllllllllIIlIIllIIlIlIIIlll);
                    break;
                }
            }
        }
    }
    
    public static String glGetShaderInfoLog(final int llllllllllllllIIlIIllIIlllllIIlI, final int llllllllllllllIIlIIllIIlllllIIIl) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetInfoLogARB(llllllllllllllIIlIIllIIlllllIIlI, llllllllllllllIIlIIllIIlllllIIIl) : GL20.glGetShaderInfoLog(llllllllllllllIIlIIllIIlllllIIlI, llllllllllllllIIlIIllIIlllllIIIl);
    }
    
    public static void glFramebufferTexture2D(final int llllllllllllllIIlIIllIIlIIlllllI, final int llllllllllllllIIlIIllIIlIIllllIl, final int llllllllllllllIIlIIllIIlIIllllII, final int llllllllllllllIIlIIllIIlIIllIllI, final int llllllllllllllIIlIIllIIlIIllIlIl) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glFramebufferTexture2D(llllllllllllllIIlIIllIIlIIlllllI, llllllllllllllIIlIIllIIlIIllllIl, llllllllllllllIIlIIllIIlIIllllII, llllllllllllllIIlIIllIIlIIllIllI, llllllllllllllIIlIIllIIlIIllIlIl);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glFramebufferTexture2D(llllllllllllllIIlIIllIIlIIlllllI, llllllllllllllIIlIIllIIlIIllllIl, llllllllllllllIIlIIllIIlIIllllII, llllllllllllllIIlIIllIIlIIllIllI, llllllllllllllIIlIIllIIlIIllIlIl);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glFramebufferTexture2DEXT(llllllllllllllIIlIIllIIlIIlllllI, llllllllllllllIIlIIllIIlIIllllIl, llllllllllllllIIlIIllIIlIIllllII, llllllllllllllIIlIIllIIlIIllIllI, llllllllllllllIIlIIllIIlIIllIlIl);
                    break;
                }
            }
        }
    }
    
    public static void glUniform1(final int llllllllllllllIIlIIllIIlllIlIlll, final IntBuffer llllllllllllllIIlIIllIIlllIlIlII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform1ARB(llllllllllllllIIlIIllIIlllIlIlll, llllllllllllllIIlIIllIIlllIlIlII);
        }
        else {
            GL20.glUniform1(llllllllllllllIIlIIllIIlllIlIlll, llllllllllllllIIlIIllIIlllIlIlII);
        }
    }
    
    public static void glBufferData(final int llllllllllllllIIlIIllIIlIlllIllI, final ByteBuffer llllllllllllllIIlIIllIIlIlllIlIl, final int llllllllllllllIIlIIllIIlIlllIlll) {
        if (OpenGlHelper.arbVbo) {
            ARBVertexBufferObject.glBufferDataARB(llllllllllllllIIlIIllIIlIlllIllI, llllllllllllllIIlIIllIIlIlllIlIl, llllllllllllllIIlIIllIIlIlllIlll);
        }
        else {
            GL15.glBufferData(llllllllllllllIIlIIllIIlIlllIllI, llllllllllllllIIlIIllIIlIlllIlIl, llllllllllllllIIlIIllIIlIlllIlll);
        }
    }
    
    public static boolean areShadersSupported() {
        return OpenGlHelper.shadersSupported;
    }
    
    public static boolean isFramebufferEnabled() {
        return !Config.isFastRender() && !Config.isAntialiasing() && (OpenGlHelper.framebufferSupported && Minecraft.getMinecraft().gameSettings.fboEnable);
    }
    
    public static void glDeleteShader(final int llllllllllllllIIlIIllIlIIIIIIlll) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glDeleteObjectARB(llllllllllllllIIlIIllIlIIIIIIlll);
        }
        else {
            GL20.glDeleteShader(llllllllllllllIIlIIllIlIIIIIIlll);
        }
    }
    
    public static int glCreateProgram() {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glCreateProgramObjectARB() : GL20.glCreateProgram();
    }
    
    public static void glUniformMatrix3(final int llllllllllllllIIlIIllIIllIIlIlII, final boolean llllllllllllllIIlIIllIIllIIlIIll, final FloatBuffer llllllllllllllIIlIIllIIllIIlIIlI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniformMatrix3ARB(llllllllllllllIIlIIllIIllIIlIlII, llllllllllllllIIlIIllIIllIIlIIll, llllllllllllllIIlIIllIIllIIlIIlI);
        }
        else {
            GL20.glUniformMatrix3(llllllllllllllIIlIIllIIllIIlIlII, llllllllllllllIIlIIllIIllIIlIIll, llllllllllllllIIlIIllIIllIIlIIlI);
        }
    }
    
    public static void glDeleteBuffers(final int llllllllllllllIIlIIllIIlIlllIIIl) {
        if (OpenGlHelper.arbVbo) {
            ARBVertexBufferObject.glDeleteBuffersARB(llllllllllllllIIlIIllIIlIlllIIIl);
        }
        else {
            GL15.glDeleteBuffers(llllllllllllllIIlIIllIIlIlllIIIl);
        }
    }
    
    public static int glGetUniformLocation(final int llllllllllllllIIlIIllIIlllIllIll, final CharSequence llllllllllllllIIlIIllIIlllIllIlI) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetUniformLocationARB(llllllllllllllIIlIIllIIlllIllIll, llllllllllllllIIlIIllIIlllIllIlI) : GL20.glGetUniformLocation(llllllllllllllIIlIIllIIlllIllIll, llllllllllllllIIlIIllIIlllIllIlI);
    }
    
    public static void glDeleteFramebuffers(final int llllllllllllllIIlIIllIIlIlIlllll) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glDeleteFramebuffers(llllllllllllllIIlIIllIIlIlIlllll);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glDeleteFramebuffers(llllllllllllllIIlIIllIIlIlIlllll);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glDeleteFramebuffersEXT(llllllllllllllIIlIIllIIlIlIlllll);
                    break;
                }
            }
        }
    }
    
    public static void glRenderbufferStorage(final int llllllllllllllIIlIIllIIlIlIlIllI, final int llllllllllllllIIlIIllIIlIlIlIlIl, final int llllllllllllllIIlIIllIIlIlIlIlII, final int llllllllllllllIIlIIllIIlIlIlIlll) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glRenderbufferStorage(llllllllllllllIIlIIllIIlIlIlIllI, llllllllllllllIIlIIllIIlIlIlIlIl, llllllllllllllIIlIIllIIlIlIlIlII, llllllllllllllIIlIIllIIlIlIlIlll);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glRenderbufferStorage(llllllllllllllIIlIIllIIlIlIlIllI, llllllllllllllIIlIIllIIlIlIlIlIl, llllllllllllllIIlIIllIIlIlIlIlII, llllllllllllllIIlIIllIIlIlIlIlll);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glRenderbufferStorageEXT(llllllllllllllIIlIIllIIlIlIlIllI, llllllllllllllIIlIIllIIlIlIlIlIl, llllllllllllllIIlIIllIIlIlIlIlII, llllllllllllllIIlIIllIIlIlIlIlll);
                    break;
                }
            }
        }
    }
    
    public static void openFile(final File llllllllllllllIIlIIllIIlIIIIlIll) {
        final String llllllllllllllIIlIIllIIlIIIIlIlI = llllllllllllllIIlIIllIIlIIIIlIll.getAbsolutePath();
        Label_0107: {
            if (Util.getOSType() == Util.EnumOS.OSX) {
                try {
                    OpenGlHelper.LOGGER.info(llllllllllllllIIlIIllIIlIIIIlIlI);
                    Runtime.getRuntime().exec(new String[] { "/usr/bin/open", llllllllllllllIIlIIllIIlIIIIlIlI });
                    return;
                }
                catch (IOException llllllllllllllIIlIIllIIlIIIIlIIl) {
                    OpenGlHelper.LOGGER.error("Couldn't open file", (Throwable)llllllllllllllIIlIIllIIlIIIIlIIl);
                    break Label_0107;
                }
            }
            if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                final String llllllllllllllIIlIIllIIlIIIIlIII = String.format("cmd.exe /C start \"Open file\" \"%s\"", llllllllllllllIIlIIllIIlIIIIlIlI);
                try {
                    Runtime.getRuntime().exec(llllllllllllllIIlIIllIIlIIIIlIII);
                    return;
                }
                catch (IOException llllllllllllllIIlIIllIIlIIIIIlll) {
                    OpenGlHelper.LOGGER.error("Couldn't open file", (Throwable)llllllllllllllIIlIIllIIlIIIIIlll);
                }
            }
        }
        boolean llllllllllllllIIlIIllIIlIIIIIllI = false;
        try {
            final Class<?> llllllllllllllIIlIIllIIlIIIIIlIl = Class.forName("java.awt.Desktop");
            final Object llllllllllllllIIlIIllIIlIIIIIlII = llllllllllllllIIlIIllIIlIIIIIlIl.getMethod("getDesktop", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
            llllllllllllllIIlIIllIIlIIIIIlIl.getMethod("browse", URI.class).invoke(llllllllllllllIIlIIllIIlIIIIIlII, llllllllllllllIIlIIllIIlIIIIlIll.toURI());
        }
        catch (Throwable llllllllllllllIIlIIllIIlIIIIIIll) {
            OpenGlHelper.LOGGER.error("Couldn't open link", llllllllllllllIIlIIllIIlIIIIIIll);
            llllllllllllllIIlIIllIIlIIIIIllI = true;
        }
        if (llllllllllllllIIlIIllIIlIIIIIllI) {
            OpenGlHelper.LOGGER.info("Opening via system class!");
            Sys.openURL("file://" + llllllllllllllIIlIIllIIlIIIIlIlI);
        }
    }
    
    public static void glUniform2(final int llllllllllllllIIlIIllIIllIllllll, final FloatBuffer llllllllllllllIIlIIllIIllIlllllI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform2ARB(llllllllllllllIIlIIllIIllIllllll, llllllllllllllIIlIIllIIllIlllllI);
        }
        else {
            GL20.glUniform2(llllllllllllllIIlIIllIIllIllllll, llllllllllllllIIlIIllIIllIlllllI);
        }
    }
    
    public static String getLogText() {
        return OpenGlHelper.logText;
    }
    
    public static void renderDirections(final int llllllllllllllIIlIIllIIlIIIlIllI) {
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        final Tessellator llllllllllllllIIlIIllIIlIIIlIlIl = Tessellator.getInstance();
        final BufferBuilder llllllllllllllIIlIIllIIlIIIlIlII = llllllllllllllIIlIIllIIlIIIlIlIl.getBuffer();
        GL11.glLineWidth(4.0f);
        llllllllllllllIIlIIllIIlIIIlIlII.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, 0.0, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(llllllllllllllIIlIIllIIlIIIlIllI, 0.0, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, 0.0, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, llllllllllllllIIlIIllIIlIIIlIllI, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, 0.0, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, 0.0, llllllllllllllIIlIIllIIlIIIlIllI).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlIl.draw();
        GL11.glLineWidth(2.0f);
        llllllllllllllIIlIIllIIlIIIlIlII.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, 0.0, 0.0).color(255, 0, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(llllllllllllllIIlIIllIIlIIIlIllI, 0.0, 0.0).color(255, 0, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, 0.0, 0.0).color(0, 255, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, llllllllllllllIIlIIllIIlIIIlIllI, 0.0).color(0, 255, 0, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, 0.0, 0.0).color(127, 127, 255, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlII.pos(0.0, 0.0, llllllllllllllIIlIIllIIlIIIlIllI).color(127, 127, 255, 255).endVertex();
        llllllllllllllIIlIIllIIlIIIlIlIl.draw();
        GL11.glLineWidth(1.0f);
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
    }
    
    public static int glGenBuffers() {
        return OpenGlHelper.arbVbo ? ARBVertexBufferObject.glGenBuffersARB() : GL15.glGenBuffers();
    }
    
    public static void glDeleteProgram(final int llllllllllllllIIlIIllIIllllIIlII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glDeleteObjectARB(llllllllllllllIIlIIllIIllllIIlII);
        }
        else {
            GL20.glDeleteProgram(llllllllllllllIIlIIllIIllllIIlII);
        }
    }
    
    public static void glBindFramebuffer(final int llllllllllllllIIlIIllIIlIllIllII, final int llllllllllllllIIlIIllIIlIllIllIl) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glBindFramebuffer(llllllllllllllIIlIIllIIlIllIllII, llllllllllllllIIlIIllIIlIllIllIl);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glBindFramebuffer(llllllllllllllIIlIIllIIlIllIllII, llllllllllllllIIlIIllIIlIllIllIl);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glBindFramebufferEXT(llllllllllllllIIlIIllIIlIllIllII, llllllllllllllIIlIIllIIlIllIllIl);
                    break;
                }
            }
        }
    }
    
    public static void setActiveTexture(final int llllllllllllllIIlIIllIIlIIllIIll) {
        if (OpenGlHelper.arbMultitexture) {
            ARBMultitexture.glActiveTextureARB(llllllllllllllIIlIIllIIlIIllIIll);
        }
        else {
            GL13.glActiveTexture(llllllllllllllIIlIIllIIlIIllIIll);
        }
    }
    
    public static void glShaderSource(final int llllllllllllllIIlIIllIlIIIIIIIIl, final ByteBuffer llllllllllllllIIlIIllIlIIIIIIIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glShaderSourceARB(llllllllllllllIIlIIllIlIIIIIIIIl, llllllllllllllIIlIIllIlIIIIIIIII);
        }
        else {
            GL20.glShaderSource(llllllllllllllIIlIIllIlIIIIIIIIl, llllllllllllllIIlIIllIlIIIIIIIII);
        }
    }
    
    public static void glDeleteRenderbuffers(final int llllllllllllllIIlIIllIIlIllIIIll) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glDeleteRenderbuffers(llllllllllllllIIlIIllIIlIllIIIll);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glDeleteRenderbuffers(llllllllllllllIIlIIllIIlIllIIIll);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glDeleteRenderbuffersEXT(llllllllllllllIIlIIllIIlIllIIIll);
                    break;
                }
            }
        }
    }
    
    public static void glUniformMatrix2(final int llllllllllllllIIlIIllIIllIlIIIII, final boolean llllllllllllllIIlIIllIIllIIlllll, final FloatBuffer llllllllllllllIIlIIllIIllIIllIll) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniformMatrix2ARB(llllllllllllllIIlIIllIIllIlIIIII, llllllllllllllIIlIIllIIllIIlllll, llllllllllllllIIlIIllIIllIIllIll);
        }
        else {
            GL20.glUniformMatrix2(llllllllllllllIIlIIllIIllIlIIIII, llllllllllllllIIlIIllIIllIIlllll, llllllllllllllIIlIIllIIllIIllIll);
        }
    }
    
    public static int glGenRenderbuffers() {
        if (!OpenGlHelper.framebufferSupported) {
            return -1;
        }
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
            case 1: {
                return GL30.glGenRenderbuffers();
            }
            case 2: {
                return ARBFramebufferObject.glGenRenderbuffers();
            }
            case 3: {
                return EXTFramebufferObject.glGenRenderbuffersEXT();
            }
            default: {
                return -1;
            }
        }
    }
    
    public static String getCpu() {
        return (OpenGlHelper.cpu == null) ? "<unknown>" : OpenGlHelper.cpu;
    }
    
    public static int glCreateShader(final int llllllllllllllIIlIIllIlIIIIIIlIl) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glCreateShaderObjectARB(llllllllllllllIIlIIllIlIIIIIIlIl) : GL20.glCreateShader(llllllllllllllIIlIIllIlIIIIIIlIl);
    }
    
    public static void glLinkProgram(final int llllllllllllllIIlIIllIIllllIIIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glLinkProgramARB(llllllllllllllIIlIIllIIllllIIIII);
        }
        else {
            GL20.glLinkProgram(llllllllllllllIIlIIllIIllllIIIII);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        OpenGlHelper.logText = "";
        OpenGlHelper.lastBrightnessX = 0.0f;
        OpenGlHelper.lastBrightnessY = 0.0f;
    }
    
    public static void glUniform3(final int llllllllllllllIIlIIllIIllIllIIIl, final FloatBuffer llllllllllllllIIlIIllIIllIllIIlI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform3ARB(llllllllllllllIIlIIllIIllIllIIIl, llllllllllllllIIlIIllIIllIllIIlI);
        }
        else {
            GL20.glUniform3(llllllllllllllIIlIIllIIllIllIIIl, llllllllllllllIIlIIllIIllIllIIlI);
        }
    }
    
    public static void glUniform2(final int llllllllllllllIIlIIllIIlllIIIlIl, final IntBuffer llllllllllllllIIlIIllIIlllIIIIlI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform2ARB(llllllllllllllIIlIIllIIlllIIIlIl, llllllllllllllIIlIIllIIlllIIIIlI);
        }
        else {
            GL20.glUniform2(llllllllllllllIIlIIllIIlllIIIlIl, llllllllllllllIIlIIllIIlllIIIIlI);
        }
    }
    
    public static String glGetProgramInfoLog(final int llllllllllllllIIlIIllIIllllIllII, final int llllllllllllllIIlIIllIIllllIlIIl) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetInfoLogARB(llllllllllllllIIlIIllIIllllIllII, llllllllllllllIIlIIllIIllllIlIIl) : GL20.glGetProgramInfoLog(llllllllllllllIIlIIllIIllllIllII, llllllllllllllIIlIIllIIllllIlIIl);
    }
    
    public static void glUniform1i(final int llllllllllllllIIlIIllIIlllIlIIIl, final int llllllllllllllIIlIIllIIlllIIlllI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform1iARB(llllllllllllllIIlIIllIIlllIlIIIl, llllllllllllllIIlIIllIIlllIIlllI);
        }
        else {
            GL20.glUniform1i(llllllllllllllIIlIIllIIlllIlIIIl, llllllllllllllIIlIIllIIlllIIlllI);
        }
    }
    
    public static int glGetAttribLocation(final int llllllllllllllIIlIIllIIllIIIIllI, final CharSequence llllllllllllllIIlIIllIIllIIIIlIl) {
        return OpenGlHelper.arbShaders ? ARBVertexShader.glGetAttribLocationARB(llllllllllllllIIlIIllIIllIIIIllI, llllllllllllllIIlIIllIIllIIIIlIl) : GL20.glGetAttribLocation(llllllllllllllIIlIIllIIllIIIIllI, llllllllllllllIIlIIllIIllIIIIlIl);
    }
    
    public static int glGenFramebuffers() {
        if (!OpenGlHelper.framebufferSupported) {
            return -1;
        }
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
            case 1: {
                return GL30.glGenFramebuffers();
            }
            case 2: {
                return ARBFramebufferObject.glGenFramebuffers();
            }
            case 3: {
                return EXTFramebufferObject.glGenFramebuffersEXT();
            }
            default: {
                return -1;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode = OpenGlHelper.$SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode;
        if ($switch_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode != null) {
            return $switch_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode;
        }
        final float llllllllllllllIIlIIllIIIllllllII = (Object)new int[FboMode.values().length];
        try {
            llllllllllllllIIlIIllIIIllllllII[FboMode.ARB.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIIllIIIllllllII[FboMode.BASE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIIllIIIllllllII[FboMode.EXT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return OpenGlHelper.$SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode = (int[])(Object)llllllllllllllIIlIIllIIIllllllII;
    }
    
    public static void glBindBuffer(final int llllllllllllllIIlIIllIIlIllllllI, final int llllllllllllllIIlIIllIIlIlllllIl) {
        if (OpenGlHelper.arbVbo) {
            ARBVertexBufferObject.glBindBufferARB(llllllllllllllIIlIIllIIlIllllllI, llllllllllllllIIlIIllIIlIlllllIl);
        }
        else {
            GL15.glBindBuffer(llllllllllllllIIlIIllIIlIllllllI, llllllllllllllIIlIIllIIlIlllllIl);
        }
    }
    
    public static void glUseProgram(final int llllllllllllllIIlIIllIIllllIIllI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUseProgramObjectARB(llllllllllllllIIlIIllIIllllIIllI);
        }
        else {
            GL20.glUseProgram(llllllllllllllIIlIIllIIllllIIllI);
        }
    }
    
    public static void glUniform3(final int llllllllllllllIIlIIllIIllIllIlll, final IntBuffer llllllllllllllIIlIIllIIllIlllIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform3ARB(llllllllllllllIIlIIllIIllIllIlll, llllllllllllllIIlIIllIIllIlllIII);
        }
        else {
            GL20.glUniform3(llllllllllllllIIlIIllIIllIllIlll, llllllllllllllIIlIIllIIllIlllIII);
        }
    }
    
    enum FboMode
    {
        EXT("EXT", 2), 
        BASE("BASE", 0), 
        ARB("ARB", 1);
        
        private FboMode(final String lllllllllllIIllIllIllIIIIlIlIllI, final int lllllllllllIIllIllIllIIIIlIlIlIl) {
        }
    }
}
