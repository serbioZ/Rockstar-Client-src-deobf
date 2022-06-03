// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.shader;

import org.lwjgl.opengl.ARBShaderObjects;
import java.util.HashMap;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import java.util.Map;

public abstract class Shader
{
    private /* synthetic */ int program;
    private /* synthetic */ Map<String, Integer> uniformsMap;
    
    public void stopShader() {
        GL20.glUseProgram(0);
        GL11.glPopMatrix();
    }
    
    public void startShader() {
        GL11.glPushMatrix();
        GL20.glUseProgram(this.program);
        if (this.uniformsMap == null) {
            this.uniformsMap = new HashMap<String, Integer>();
            this.setupUniforms();
        }
        this.updateUniforms();
    }
    
    public abstract void updateUniforms();
    
    private int createShader(final String lllllllllllIllllIllIllIllIIIIIll, final int lllllllllllIllllIllIllIllIIIIIlI) {
        int lllllllllllIllllIllIllIllIIIIIIl = 0;
        try {
            lllllllllllIllllIllIllIllIIIIIIl = ARBShaderObjects.glCreateShaderObjectARB(lllllllllllIllllIllIllIllIIIIIlI);
            if (lllllllllllIllllIllIllIllIIIIIIl == 0) {
                return 0;
            }
            ARBShaderObjects.glShaderSourceARB(lllllllllllIllllIllIllIllIIIIIIl, (CharSequence)lllllllllllIllllIllIllIllIIIIIll);
            ARBShaderObjects.glCompileShaderARB(lllllllllllIllllIllIllIllIIIIIIl);
            return lllllllllllIllllIllIllIllIIIIIIl;
        }
        catch (Exception lllllllllllIllllIllIllIllIIIIIII) {
            ARBShaderObjects.glDeleteObjectARB(lllllllllllIllllIllIllIllIIIIIIl);
            throw lllllllllllIllllIllIllIllIIIIIII;
        }
    }
    
    public Shader(final String lllllllllllIllllIllIllIllIIllIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.<init>:()V
        //     4: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //     5: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //     8: ldc             "/assets/minecraft/rockstar/shaders/vertex.vert"
        //    10: invokevirtual   java/lang/Class.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    13: astore          lllllllllllIllllIllIllIllIIlIlIl
        //    15: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //    16: aload           lllllllllllIllllIllIllIllIIlIlIl
        //    18: invokestatic    org/apache/commons/io/IOUtils.toString:(Ljava/io/InputStream;)Ljava/lang/String;
        //    21: ldc             35633
        //    23: invokespecial   ru/rockstar/api/utils/shader/Shader.createShader:(Ljava/lang/String;I)I
        //    26: istore_2        /* lllllllllllIllllIllIllIllIIllIIl */
        //    27: aload           lllllllllllIllllIllIllIllIIlIlIl
        //    29: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    32: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //    33: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    36: new             Ljava/lang/StringBuilder;
        //    39: dup            
        //    40: ldc             "/assets/minecraft/rockstar/shaders/fragment/"
        //    42: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    45: aload_1         /* lllllllllllIllllIllIllIllIIlIIIl */
        //    46: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    49: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    52: invokevirtual   java/lang/Class.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    55: astore          lllllllllllIllllIllIllIllIIlIlII
        //    57: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //    58: aload           lllllllllllIllllIllIllIllIIlIlII
        //    60: invokestatic    org/apache/commons/io/IOUtils.toString:(Ljava/io/InputStream;)Ljava/lang/String;
        //    63: ldc             35632
        //    65: invokespecial   ru/rockstar/api/utils/shader/Shader.createShader:(Ljava/lang/String;I)I
        //    68: istore_3        /* lllllllllllIllllIllIllIllIIlIlll */
        //    69: aload           lllllllllllIllllIllIllIllIIlIlII
        //    71: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    74: goto            80
        //    77: astore          lllllllllllIllllIllIllIllIIlIIll
        //    79: return         
        //    80: iload_2         /* lllllllllllIllllIllIllIllIIllIII */
        //    81: ifeq            88
        //    84: iload_3         /* lllllllllllIllllIllIllIllIIlIllI */
        //    85: ifne            89
        //    88: return         
        //    89: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //    90: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glCreateProgramObjectARB:()I
        //    93: putfield        ru/rockstar/api/utils/shader/Shader.program:I
        //    96: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //    97: getfield        ru/rockstar/api/utils/shader/Shader.program:I
        //   100: ifne            104
        //   103: return         
        //   104: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //   105: getfield        ru/rockstar/api/utils/shader/Shader.program:I
        //   108: iload_2         /* lllllllllllIllllIllIllIllIIllIII */
        //   109: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glAttachObjectARB:(II)V
        //   112: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //   113: getfield        ru/rockstar/api/utils/shader/Shader.program:I
        //   116: iload_3         /* lllllllllllIllllIllIllIllIIlIllI */
        //   117: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glAttachObjectARB:(II)V
        //   120: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //   121: getfield        ru/rockstar/api/utils/shader/Shader.program:I
        //   124: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glLinkProgramARB:(I)V
        //   127: aload_0         /* lllllllllllIllllIllIllIllIIllIll */
        //   128: getfield        ru/rockstar/api/utils/shader/Shader.program:I
        //   131: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glValidateProgramARB:(I)V
        //   134: return         
        //    StackMapTable: 00 05 FF 00 4D 00 02 07 00 02 07 00 9B 00 01 07 00 32 FF 00 02 00 06 07 00 02 07 00 9B 01 01 07 00 9D 07 00 9D 00 00 07 00 0E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      74     77     80     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public int getUniform(final String lllllllllllIllllIllIllIlIllIlIIl) {
        return this.uniformsMap.get(lllllllllllIllllIllIllIlIllIlIIl);
    }
    
    public void setupUniform(final String lllllllllllIllllIllIllIlIllIllll) {
        this.setUniform(lllllllllllIllllIllIllIlIllIllll, GL20.glGetUniformLocation(this.program, (CharSequence)lllllllllllIllllIllIllIlIllIllll));
    }
    
    public abstract void setupUniforms();
    
    public void setUniform(final String lllllllllllIllllIllIllIlIlllIlll, final int lllllllllllIllllIllIllIlIlllIIll) {
        this.uniformsMap.put(lllllllllllIllllIllIllIlIlllIlll, lllllllllllIllllIllIllIlIlllIIll);
    }
}
