// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.render.glsandbox;

import org.lwjgl.opengl.GL20;
import java.io.IOException;
import java.io.InputStream;

public class animbackground
{
    private final /* synthetic */ int timeUniform;
    private final /* synthetic */ int programId;
    private final /* synthetic */ int mouseUniform;
    private final /* synthetic */ int resolutionUniform;
    
    public String readStreamToString(final InputStream lllllllllllIlIIIlIlIIlIllIlIIlII) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //     7: astore_2        /* lllllllllllIlIIIlIlIIlIllIlIIIll */
        //     8: sipush          512
        //    11: newarray        B
        //    13: astore_3        /* lllllllllllIlIIIlIlIIlIllIIlllIl */
        //    14: goto            25
        //    17: aload_2         /* lllllllllllIlIIIlIlIIlIllIlIIIll */
        //    18: aload_3         /* lllllllllllIlIIIlIlIIlIllIlIIIlI */
        //    19: iconst_0       
        //    20: iload           lllllllllllIlIIIlIlIIlIllIlIIIIl
        //    22: invokevirtual   java/io/ByteArrayOutputStream.write:([BII)V
        //    25: aload_1         /* lllllllllllIlIIIlIlIIlIllIIlllll */
        //    26: aload_3         /* lllllllllllIlIIIlIlIIlIllIlIIIlI */
        //    27: iconst_0       
        //    28: aload_3         /* lllllllllllIlIIIlIlIIlIllIlIIIlI */
        //    29: arraylength    
        //    30: invokevirtual   java/io/InputStream.read:([BII)I
        //    33: dup            
        //    34: istore          lllllllllllIlIIIlIlIIlIllIlIIIII
        //    36: iconst_m1      
        //    37: if_icmpne       17
        //    40: new             Ljava/lang/String;
        //    43: dup            
        //    44: aload_2         /* lllllllllllIlIIIlIlIIlIllIlIIIll */
        //    45: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    48: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    51: invokespecial   java/lang/String.<init>:([BLjava/nio/charset/Charset;)V
        //    54: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 FE 00 11 07 00 0F 07 00 3D 01 FA 00 07
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void useShader(final int lllllllllllIlIIIlIlIIlIllIllllIl, final int lllllllllllIlIIIlIlIIlIllIllllII, final float lllllllllllIlIIIlIlIIlIlllIIIIIl, final float lllllllllllIlIIIlIlIIlIlllIIIIII, final float lllllllllllIlIIIlIlIIlIllIlllIIl) {
        GL20.glUseProgram(this.programId);
        GL20.glUniform2f(this.resolutionUniform, (float)lllllllllllIlIIIlIlIIlIllIllllIl, (float)lllllllllllIlIIIlIlIIlIllIllllII);
        GL20.glUniform2f(this.mouseUniform, lllllllllllIlIIIlIlIIlIlllIIIIIl / lllllllllllIlIIIlIlIIlIllIllllIl, 1.0f - lllllllllllIlIIIlIlIIlIlllIIIIII / lllllllllllIlIIIlIlIIlIllIllllII);
        GL20.glUniform1f(this.timeUniform, lllllllllllIlIIIlIlIIlIllIlllIIl);
    }
    
    public int createShader(final InputStream lllllllllllIlIIIlIlIIlIllIllIIlI, final int lllllllllllIlIIIlIlIIlIllIlIllII) throws IOException {
        final int lllllllllllIlIIIlIlIIlIllIllIIII = GL20.glCreateShader(lllllllllllIlIIIlIlIIlIllIlIllII);
        GL20.glShaderSource(lllllllllllIlIIIlIlIIlIllIllIIII, (CharSequence)this.readStreamToString(lllllllllllIlIIIlIlIIlIllIllIIlI));
        GL20.glCompileShader(lllllllllllIlIIIlIlIIlIllIllIIII);
        final int lllllllllllIlIIIlIlIIlIllIlIllll = GL20.glGetShaderi(lllllllllllIlIIIlIlIIlIllIllIIII, 35713);
        if (lllllllllllIlIIIlIlIIlIllIlIllll == 0) {
            System.err.println(GL20.glGetShaderInfoLog(lllllllllllIlIIIlIlIIlIllIllIIII, GL20.glGetShaderi(lllllllllllIlIIIlIlIIlIllIllIIII, 35716)));
            throw new IllegalStateException("Failed to compile shader");
        }
        return lllllllllllIlIIIlIlIIlIllIllIIII;
    }
    
    public animbackground(final String lllllllllllIlIIIlIlIIlIlllIlIIIl) throws IOException {
        final int lllllllllllIlIIIlIlIIlIlllIlIIII = GL20.glCreateProgram();
        GL20.glAttachShader(lllllllllllIlIIIlIlIIlIlllIlIIII, this.createShader(animbackground.class.getResourceAsStream("/passthrough.vsh"), 35633));
        GL20.glAttachShader(lllllllllllIlIIIlIlIIlIlllIlIIII, this.createShader(animbackground.class.getResourceAsStream(lllllllllllIlIIIlIlIIlIlllIlIIIl), 35632));
        GL20.glLinkProgram(lllllllllllIlIIIlIlIIlIlllIlIIII);
        final int lllllllllllIlIIIlIlIIlIlllIIllll = GL20.glGetProgrami(lllllllllllIlIIIlIlIIlIlllIlIIII, 35714);
        if (lllllllllllIlIIIlIlIIlIlllIIllll == 0) {
            System.err.println(GL20.glGetProgramInfoLog(lllllllllllIlIIIlIlIIlIlllIlIIII, GL20.glGetProgrami(lllllllllllIlIIIlIlIIlIlllIlIIII, 35716)));
            throw new IllegalStateException("Shader failed to link");
        }
        final int programId = lllllllllllIlIIIlIlIIlIlllIlIIII;
        this.programId = programId;
        GL20.glUseProgram(programId);
        this.timeUniform = GL20.glGetUniformLocation(lllllllllllIlIIIlIlIIlIlllIlIIII, (CharSequence)"time");
        this.mouseUniform = GL20.glGetUniformLocation(lllllllllllIlIIIlIlIIlIlllIlIIII, (CharSequence)"mouse");
        this.resolutionUniform = GL20.glGetUniformLocation(lllllllllllIlIIIlIlIIlIlllIlIIII, (CharSequence)"resolution");
        GL20.glUseProgram(0);
    }
}
