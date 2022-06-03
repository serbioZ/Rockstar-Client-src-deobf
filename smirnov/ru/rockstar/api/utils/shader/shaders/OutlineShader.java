// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.shader.shaders;

import org.lwjgl.opengl.GL20;
import ru.rockstar.api.utils.shader.FramebufferShader;

public class OutlineShader extends FramebufferShader
{
    public /* synthetic */ float customSaturation;
    public /* synthetic */ float rainbowStrength;
    public /* synthetic */ float rainbowSpeed;
    
    @Override
    public void updateUniforms() {
        GL20.glUniform1i(this.getUniform("texture"), 0);
        GL20.glUniform2f(this.getUniform("texelSize"), 1.0f / OutlineShader.mc.displayWidth * (this.radius * this.quality), 1.0f / OutlineShader.mc.displayHeight * (this.radius * this.quality));
        GL20.glUniform4f(this.getUniform("color"), this.red, this.green, this.blue, this.alpha);
        GL20.glUniform1f(this.getUniform("radius"), this.radius);
        final float llllllllllllllIIIIlIlIlIIIIlIIII = 1.0f / -(1000.0f * this.rainbowStrength);
        GL20.glUniform2f(this.getUniform("rainbowStrength"), llllllllllllllIIIIlIlIlIIIIlIIII, llllllllllllllIIIIlIlIlIIIIlIIII);
        GL20.glUniform1f(this.getUniform("rainbowSpeed"), this.rainbowSpeed);
        GL20.glUniform1f(this.getUniform("saturation"), this.customSaturation);
    }
    
    static {
        INSTANCE = new OutlineShader("outline.frag");
    }
    
    @Override
    public void setupUniforms() {
        this.setupUniform("texture");
        this.setupUniform("texelSize");
        this.setupUniform("color");
        this.setupUniform("radius");
        this.setupUniform("rainbowStrength");
        this.setupUniform("rainbowSpeed");
        this.setupUniform("saturation");
    }
    
    public OutlineShader(final String llllllllllllllIIIIlIlIlIIIlIIlIl) {
        super(llllllllllllllIIIIlIlIlIIIlIIlIl);
        this.rainbowSpeed = 0.5f;
        this.rainbowStrength = 0.25f;
        this.customSaturation = 0.5f;
    }
    
    public void setCustomValues(final float llllllllllllllIIIIlIlIlIIIIllIIl, final float llllllllllllllIIIIlIlIlIIIIllIII, final float llllllllllllllIIIIlIlIlIIIIlIlll) {
        this.rainbowSpeed = llllllllllllllIIIIlIlIlIIIIllIIl;
        this.rainbowStrength = llllllllllllllIIIIlIlIlIIIIllIII;
        this.customSaturation = llllllllllllllIIIIlIlIlIIIIlIlll;
    }
}
