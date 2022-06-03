// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.shader;

import org.lwjgl.opengl.ARBShaderObjects;

public class ShaderShell
{
    private /* synthetic */ int shaderID;
    public static /* synthetic */ ShaderShell ROUNDED_RECT;
    
    public void attach() {
        ARBShaderObjects.glUseProgramObjectARB(this.shaderID);
    }
    
    private void parseShaderFromString(final String llllllllllllIllllIIIlIlIlIllllII, final boolean llllllllllllIllllIIIlIlIlIlllllI) {
        this.localInit(llllllllllllIllllIIIlIlIlIllllII);
    }
    
    public void set4F(final String llllllllllllIllllIIIlIlIllIlIlll, final float llllllllllllIllllIIIlIlIllIlIllI, final float llllllllllllIllllIIIlIlIllIIllll, final float llllllllllllIllllIIIlIlIllIlIlII, final float llllllllllllIllllIIIlIlIllIlIIll) {
        ARBShaderObjects.glUniform4fARB(ARBShaderObjects.glGetUniformLocationARB(this.shaderID, (CharSequence)llllllllllllIllllIIIlIlIllIlIlll), llllllllllllIllllIIIlIlIllIlIllI, llllllllllllIllllIIIlIlIllIIllll, llllllllllllIllllIIIlIlIllIlIlII, llllllllllllIllllIIIlIlIllIlIIll);
    }
    
    public void set2F(final String llllllllllllIllllIIIlIlIllllIlII, final float llllllllllllIllllIIIlIlIllllIIll, final float llllllllllllIllllIIIlIlIlllIlllI) {
        ARBShaderObjects.glUniform2fARB(ARBShaderObjects.glGetUniformLocationARB(this.shaderID, (CharSequence)llllllllllllIllllIIIlIlIllllIlII), llllllllllllIllllIIIlIlIllllIIll, llllllllllllIllllIIIlIlIlllIlllI);
    }
    
    public void set3F(final String llllllllllllIllllIIIlIlIlllIIIlI, final float llllllllllllIllllIIIlIlIlllIIIIl, final float llllllllllllIllllIIIlIlIlllIIlIl, final float llllllllllllIllllIIIlIlIllIlllll) {
        ARBShaderObjects.glUniform3fARB(ARBShaderObjects.glGetUniformLocationARB(this.shaderID, (CharSequence)llllllllllllIllllIIIlIlIlllIIIlI), llllllllllllIllllIIIlIlIlllIIIIl, llllllllllllIllllIIIlIlIlllIIlIl, llllllllllllIllllIIIlIlIllIlllll);
    }
    
    public static void init() {
        ShaderShell.ROUNDED_RECT = new ShaderShell("roundedrect", false);
    }
    
    public void detach() {
        ARBShaderObjects.glUseProgramObjectARB(0);
    }
    
    public void set1F(final String llllllllllllIllllIIIlIlIlllllIll, final float llllllllllllIllllIIIlIlIlllllIlI) {
        ARBShaderObjects.glUniform1fARB(ARBShaderObjects.glGetUniformLocationARB(this.shaderID, (CharSequence)llllllllllllIllllIIIlIlIlllllIll), llllllllllllIllllIIIlIlIlllllIlI);
    }
    
    public ShaderShell(final String llllllllllllIllllIIIlIllIIIlIIll, final boolean llllllllllllIllllIIIlIllIIIIllll) {
        this.parseShaderFromFile(llllllllllllIllllIIIlIllIIIlIIll, llllllllllllIllllIIIlIllIIIIllll);
    }
    
    private void parseShaderFromFile(final String llllllllllllIllllIIIlIlIllIIIlll, final boolean llllllllllllIllllIIIlIlIllIIIIll) {
        if (llllllllllllIllllIIIlIlIllIIIlll.equalsIgnoreCase("roundedrect")) {
            this.parseShaderFromString("uniform vec4 color;\nuniform vec2 resolution;\nuniform vec2 center;\nuniform vec2 dst;\nuniform float radius;\nuniform float force;\n\nfloat rect(vec2 pos, vec2 center, vec2 size) {\n    return length(max(abs(center - pos) - (size / 2), 0)) - radius;\n}\n\nvoid main() {\n    vec2 pos = gl_FragCoord.xy;\n\tpos.y = resolution.y - pos.y;\n\tgl_FragColor = vec4(vec3(color), (-rect(pos, center, dst) / radius) * color.a / (radius / force));\n} \t", llllllllllllIllllIIIlIlIllIIIIll);
        }
    }
    
    void localInit(final String llllllllllllIllllIIIlIlIlIllIIlI) {
        final int llllllllllllIllllIIIlIlIlIllIlIl = ARBShaderObjects.glCreateProgramObjectARB();
        if (llllllllllllIllllIIIlIlIlIllIlIl == 0) {
            System.out.println("PC Issued");
            System.exit(0);
            return;
        }
        final int llllllllllllIllllIIIlIlIlIllIlII = ARBShaderObjects.glCreateShaderObjectARB(35632);
        ARBShaderObjects.glShaderSourceARB(llllllllllllIllllIIIlIlIlIllIlII, (CharSequence)llllllllllllIllllIIIlIlIlIllIIlI);
        ARBShaderObjects.glCompileShaderARB(llllllllllllIllllIIIlIlIlIllIlII);
        ARBShaderObjects.glAttachObjectARB(llllllllllllIllllIIIlIlIlIllIlIl, llllllllllllIllllIIIlIlIlIllIlII);
        ARBShaderObjects.glLinkProgramARB(llllllllllllIllllIIIlIlIlIllIlIl);
        this.shaderID = llllllllllllIllllIIIlIlIlIllIlIl;
    }
    
    public void set1I(final String llllllllllllIllllIIIlIllIIIIIlll, final int llllllllllllIllllIIIlIllIIIIIllI) {
        ARBShaderObjects.glUniform1iARB(ARBShaderObjects.glGetUniformLocationARB(this.shaderID, (CharSequence)llllllllllllIllllIIIlIllIIIIIlll), llllllllllllIllllIIIlIllIIIIIllI);
    }
}
