// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.shader;

import org.lwjgl.BufferUtils;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.util.vector.Matrix4f;
import org.apache.logging.log4j.LogManager;
import java.nio.IntBuffer;
import java.nio.FloatBuffer;
import org.apache.logging.log4j.Logger;

public class ShaderUniform
{
    private final /* synthetic */ int uniformType;
    private /* synthetic */ boolean dirty;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ String shaderName;
    private final /* synthetic */ int uniformCount;
    private final /* synthetic */ FloatBuffer uniformFloatBuffer;
    private /* synthetic */ int uniformLocation;
    private final /* synthetic */ IntBuffer uniformIntBuffer;
    private final /* synthetic */ ShaderManager shaderManager;
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void setSafe(final float lllllllllllllllIIlIlllIIIIllIlll, final float lllllllllllllllIIlIlllIIIIlllIll, final float lllllllllllllllIIlIlllIIIIllIlIl, final float lllllllllllllllIIlIlllIIIIllIlII) {
        this.uniformFloatBuffer.position(0);
        if (this.uniformType >= 4) {
            this.uniformFloatBuffer.put(0, lllllllllllllllIIlIlllIIIIllIlll);
        }
        if (this.uniformType >= 5) {
            this.uniformFloatBuffer.put(1, lllllllllllllllIIlIlllIIIIlllIll);
        }
        if (this.uniformType >= 6) {
            this.uniformFloatBuffer.put(2, lllllllllllllllIIlIlllIIIIllIlIl);
        }
        if (this.uniformType >= 7) {
            this.uniformFloatBuffer.put(3, lllllllllllllllIIlIlllIIIIllIlII);
        }
        this.markDirty();
    }
    
    public static int parseType(final String lllllllllllllllIIlIlllIIIllllIIl) {
        int lllllllllllllllIIlIlllIIIllllIII = -1;
        if ("int".equals(lllllllllllllllIIlIlllIIIllllIIl)) {
            lllllllllllllllIIlIlllIIIllllIII = 0;
        }
        else if ("float".equals(lllllllllllllllIIlIlllIIIllllIIl)) {
            lllllllllllllllIIlIlllIIIllllIII = 4;
        }
        else if (lllllllllllllllIIlIlllIIIllllIIl.startsWith("matrix")) {
            if (lllllllllllllllIIlIlllIIIllllIIl.endsWith("2x2")) {
                lllllllllllllllIIlIlllIIIllllIII = 8;
            }
            else if (lllllllllllllllIIlIlllIIIllllIIl.endsWith("3x3")) {
                lllllllllllllllIIlIlllIIIllllIII = 9;
            }
            else if (lllllllllllllllIIlIlllIIIllllIIl.endsWith("4x4")) {
                lllllllllllllllIIlIlllIIIllllIII = 10;
            }
        }
        return lllllllllllllllIIlIlllIIIllllIII;
    }
    
    public String getShaderName() {
        return this.shaderName;
    }
    
    public void setUniformLocation(final int lllllllllllllllIIlIlllIIIlllIIlI) {
        this.uniformLocation = lllllllllllllllIIlIlllIIIlllIIlI;
    }
    
    public void set(final int lllllllllllllllIIlIlllIIIIlIlIII, final int lllllllllllllllIIlIlllIIIIlIIlll, final int lllllllllllllllIIlIlllIIIIlIIllI, final int lllllllllllllllIIlIlllIIIIlIIlIl) {
        this.uniformIntBuffer.position(0);
        if (this.uniformType >= 0) {
            this.uniformIntBuffer.put(0, lllllllllllllllIIlIlllIIIIlIlIII);
        }
        if (this.uniformType >= 1) {
            this.uniformIntBuffer.put(1, lllllllllllllllIIlIlllIIIIlIIlll);
        }
        if (this.uniformType >= 2) {
            this.uniformIntBuffer.put(2, lllllllllllllllIIlIlllIIIIlIIllI);
        }
        if (this.uniformType >= 3) {
            this.uniformIntBuffer.put(3, lllllllllllllllIIlIlllIIIIlIIlIl);
        }
        this.markDirty();
    }
    
    public void set(final Matrix4f lllllllllllllllIIlIllIlllllIIllI) {
        this.set(lllllllllllllllIIlIllIlllllIIllI.m00, lllllllllllllllIIlIllIlllllIIllI.m01, lllllllllllllllIIlIllIlllllIIllI.m02, lllllllllllllllIIlIllIlllllIIllI.m03, lllllllllllllllIIlIllIlllllIIllI.m10, lllllllllllllllIIlIllIlllllIIllI.m11, lllllllllllllllIIlIllIlllllIIllI.m12, lllllllllllllllIIlIllIlllllIIllI.m13, lllllllllllllllIIlIllIlllllIIllI.m20, lllllllllllllllIIlIllIlllllIIllI.m21, lllllllllllllllIIlIllIlllllIIllI.m22, lllllllllllllllIIlIllIlllllIIllI.m23, lllllllllllllllIIlIllIlllllIIllI.m30, lllllllllllllllIIlIllIlllllIIllI.m31, lllllllllllllllIIlIllIlllllIIllI.m32, lllllllllllllllIIlIllIlllllIIllI.m33);
    }
    
    private void uploadInt() {
        switch (this.uniformType) {
            case 0: {
                OpenGlHelper.glUniform1(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            case 1: {
                OpenGlHelper.glUniform2(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            case 2: {
                OpenGlHelper.glUniform3(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            case 3: {
                OpenGlHelper.glUniform4(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            default: {
                ShaderUniform.LOGGER.warn("Uniform.upload called, but count value ({}) is  not in the range of 1 to 4. Ignoring.", (Object)this.uniformCount);
                break;
            }
        }
    }
    
    public void set(final float lllllllllllllllIIlIlllIIIlIIlIll, final float lllllllllllllllIIlIlllIIIlIIlIlI, final float lllllllllllllllIIlIlllIIIlIIIlII, final float lllllllllllllllIIlIlllIIIlIIlIII) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(lllllllllllllllIIlIlllIIIlIIlIll);
        this.uniformFloatBuffer.put(lllllllllllllllIIlIlllIIIlIIlIlI);
        this.uniformFloatBuffer.put(lllllllllllllllIIlIlllIIIlIIIlII);
        this.uniformFloatBuffer.put(lllllllllllllllIIlIlllIIIlIIlIII);
        this.uniformFloatBuffer.flip();
        this.markDirty();
    }
    
    private void uploadFloatMatrix() {
        switch (this.uniformType) {
            case 8: {
                OpenGlHelper.glUniformMatrix2(this.uniformLocation, true, this.uniformFloatBuffer);
                break;
            }
            case 9: {
                OpenGlHelper.glUniformMatrix3(this.uniformLocation, true, this.uniformFloatBuffer);
                break;
            }
            case 10: {
                OpenGlHelper.glUniformMatrix4(this.uniformLocation, true, this.uniformFloatBuffer);
                break;
            }
        }
    }
    
    public void upload() {
        if (!this.dirty) {}
        this.dirty = false;
        if (this.uniformType <= 3) {
            this.uploadInt();
        }
        else if (this.uniformType <= 7) {
            this.uploadFloat();
        }
        else {
            if (this.uniformType > 10) {
                ShaderUniform.LOGGER.warn("Uniform.upload called, but type value ({}) is not a valid type. Ignoring.", (Object)this.uniformType);
                return;
            }
            this.uploadFloatMatrix();
        }
    }
    
    private void uploadFloat() {
        switch (this.uniformType) {
            case 4: {
                OpenGlHelper.glUniform1(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            case 5: {
                OpenGlHelper.glUniform2(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            case 6: {
                OpenGlHelper.glUniform3(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            case 7: {
                OpenGlHelper.glUniform4(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            default: {
                ShaderUniform.LOGGER.warn("Uniform.upload called, but count value ({}) is not in the range of 1 to 4. Ignoring.", (Object)this.uniformCount);
                break;
            }
        }
    }
    
    public void set(final float lllllllllllllllIIlIlllIIIllIIIlI, final float lllllllllllllllIIlIlllIIIllIIIIl) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, lllllllllllllllIIlIlllIIIllIIIlI);
        this.uniformFloatBuffer.put(1, lllllllllllllllIIlIlllIIIllIIIIl);
        this.markDirty();
    }
    
    public void set(final float lllllllllllllllIIlIllIlllllllIll, final float lllllllllllllllIIlIlllIIIIIIlIll, final float lllllllllllllllIIlIllIlllllllIIl, final float lllllllllllllllIIlIlllIIIIIIlIIl, final float lllllllllllllllIIlIllIllllllIlll, final float lllllllllllllllIIlIllIllllllIllI, final float lllllllllllllllIIlIlllIIIIIIIllI, final float lllllllllllllllIIlIlllIIIIIIIlIl, final float lllllllllllllllIIlIllIllllllIIll, final float lllllllllllllllIIlIllIllllllIIlI, final float lllllllllllllllIIlIlllIIIIIIIIlI, final float lllllllllllllllIIlIllIllllllIIII, final float lllllllllllllllIIlIlllIIIIIIIIII, final float lllllllllllllllIIlIllIlllllIlllI, final float lllllllllllllllIIlIllIlllllIllIl, final float lllllllllllllllIIlIllIllllllllIl) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, lllllllllllllllIIlIllIlllllllIll);
        this.uniformFloatBuffer.put(1, lllllllllllllllIIlIlllIIIIIIlIll);
        this.uniformFloatBuffer.put(2, lllllllllllllllIIlIllIlllllllIIl);
        this.uniformFloatBuffer.put(3, lllllllllllllllIIlIlllIIIIIIlIIl);
        this.uniformFloatBuffer.put(4, lllllllllllllllIIlIllIllllllIlll);
        this.uniformFloatBuffer.put(5, lllllllllllllllIIlIllIllllllIllI);
        this.uniformFloatBuffer.put(6, lllllllllllllllIIlIlllIIIIIIIllI);
        this.uniformFloatBuffer.put(7, lllllllllllllllIIlIlllIIIIIIIlIl);
        this.uniformFloatBuffer.put(8, lllllllllllllllIIlIllIllllllIIll);
        this.uniformFloatBuffer.put(9, lllllllllllllllIIlIllIllllllIIlI);
        this.uniformFloatBuffer.put(10, lllllllllllllllIIlIlllIIIIIIIIlI);
        this.uniformFloatBuffer.put(11, lllllllllllllllIIlIllIllllllIIII);
        this.uniformFloatBuffer.put(12, lllllllllllllllIIlIlllIIIIIIIIII);
        this.uniformFloatBuffer.put(13, lllllllllllllllIIlIllIlllllIlllI);
        this.uniformFloatBuffer.put(14, lllllllllllllllIIlIllIlllllIllIl);
        this.uniformFloatBuffer.put(15, lllllllllllllllIIlIllIllllllllIl);
        this.markDirty();
    }
    
    private void markDirty() {
        this.dirty = true;
        if (this.shaderManager != null) {
            this.shaderManager.markDirty();
        }
    }
    
    public void set(final float lllllllllllllllIIlIlllIIIlIlIlII, final float lllllllllllllllIIlIlllIIIlIlIIll, final float lllllllllllllllIIlIlllIIIlIlIllI) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, lllllllllllllllIIlIlllIIIlIlIlII);
        this.uniformFloatBuffer.put(1, lllllllllllllllIIlIlllIIIlIlIIll);
        this.uniformFloatBuffer.put(2, lllllllllllllllIIlIlllIIIlIlIllI);
        this.markDirty();
    }
    
    public ShaderUniform(final String lllllllllllllllIIlIlllIIlIIIIIlI, final int lllllllllllllllIIlIlllIIlIIIIllI, final int lllllllllllllllIIlIlllIIlIIIIIII, final ShaderManager lllllllllllllllIIlIlllIIlIIIIlII) {
        this.shaderName = lllllllllllllllIIlIlllIIlIIIIIlI;
        this.uniformCount = lllllllllllllllIIlIlllIIlIIIIIII;
        this.uniformType = lllllllllllllllIIlIlllIIlIIIIllI;
        this.shaderManager = lllllllllllllllIIlIlllIIlIIIIlII;
        if (lllllllllllllllIIlIlllIIlIIIIllI <= 3) {
            this.uniformIntBuffer = BufferUtils.createIntBuffer(lllllllllllllllIIlIlllIIlIIIIIII);
            this.uniformFloatBuffer = null;
        }
        else {
            this.uniformIntBuffer = null;
            this.uniformFloatBuffer = BufferUtils.createFloatBuffer(lllllllllllllllIIlIlllIIlIIIIIII);
        }
        this.uniformLocation = -1;
        this.markDirty();
    }
    
    public void set(final float[] lllllllllllllllIIlIlllIIIIlIIIIl) {
        if (lllllllllllllllIIlIlllIIIIlIIIIl.length < this.uniformCount) {
            ShaderUniform.LOGGER.warn("Uniform.set called with a too-small value array (expected {}, got {}). Ignoring.", (Object)this.uniformCount, (Object)lllllllllllllllIIlIlllIIIIlIIIIl.length);
        }
        else {
            this.uniformFloatBuffer.position(0);
            this.uniformFloatBuffer.put(lllllllllllllllIIlIlllIIIIlIIIIl);
            this.uniformFloatBuffer.position(0);
            this.markDirty();
        }
    }
    
    public void set(final float lllllllllllllllIIlIlllIIIllIIlll) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, lllllllllllllllIIlIlllIIIllIIlll);
        this.markDirty();
    }
}
