// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.shader.shaders;

import org.lwjgl.opengl.GL20;
import ru.rockstar.api.utils.shader.FramebufferShader;

public class EntityGlowShader extends FramebufferShader
{
    public static /* synthetic */ EntityGlowShader GLOW_SHADER;
    
    public EntityGlowShader() {
        super("entityGlow.frag");
    }
    
    @Override
    public void updateUniforms() {
        GL20.glUniform1i(this.getUniform("texture"), 0);
        GL20.glUniform2f(this.getUniform("texelSize"), 1.0f / EntityGlowShader.mc.displayWidth * (this.radius * this.quality), 1.0f / EntityGlowShader.mc.displayHeight * (this.radius * this.quality));
        GL20.glUniform3f(this.getUniform("color"), this.red, this.green, this.blue);
        GL20.glUniform1f(this.getUniform("divider"), 140.0f);
        GL20.glUniform1f(this.getUniform("radius"), this.radius);
        GL20.glUniform1f(this.getUniform("maxSample"), 10.0f);
    }
    
    static {
        EntityGlowShader.GLOW_SHADER = new EntityGlowShader();
    }
    
    @Override
    public void setupUniforms() {
        this.setupUniform("texture");
        this.setupUniform("texelSize");
        this.setupUniform("color");
        this.setupUniform("divider");
        this.setupUniform("radius");
        this.setupUniform("maxSample");
    }
}
