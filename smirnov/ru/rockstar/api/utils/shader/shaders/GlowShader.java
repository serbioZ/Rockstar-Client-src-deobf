// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.shader.shaders;

import org.lwjgl.opengl.GL20;
import ru.rockstar.api.utils.shader.FramebufferShader;

public class GlowShader extends FramebufferShader
{
    @Override
    public void setupUniforms() {
        this.setupUniform("texture");
        this.setupUniform("texelSize");
        this.setupUniform("color");
        this.setupUniform("radius");
        this.setupUniform("direction");
    }
    
    @Override
    public void updateUniforms() {
        GL20.glUniform1i(this.getUniform("texture"), 0);
        GL20.glUniform2f(this.getUniform("texelSize"), 1.0f / GlowShader.mc.displayWidth * (this.radius * this.quality), 1.0f / GlowShader.mc.displayHeight * (this.radius * this.quality));
        GL20.glUniform3f(this.getUniform("color"), this.red, this.green, this.blue);
        GL20.glUniform1f(this.getUniform("radius"), this.radius);
        GL20.glUniform2f(this.getUniform("direction"), 1.0f, 1.0f);
    }
    
    static {
        GLOW_SHADER = new GlowShader();
    }
    
    public GlowShader() {
        super("glow.frag");
    }
}
