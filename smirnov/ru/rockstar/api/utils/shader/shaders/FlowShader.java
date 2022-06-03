// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.shader.shaders;

import org.lwjgl.opengl.GL20;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.api.utils.shader.FramebufferShader;

public class FlowShader extends FramebufferShader
{
    @Override
    public void setupUniforms() {
        this.setupUniform("resolution");
        this.setupUniform("time");
    }
    
    static {
        INSTANCE = new FlowShader();
    }
    
    public FlowShader() {
        super("space.frag");
    }
    
    @Override
    public void updateUniforms() {
        GL20.glUniform2f(this.getUniform("resolution"), (float)new ScaledResolution(FlowShader.mc).getScaledWidth(), (float)new ScaledResolution(FlowShader.mc).getScaledHeight());
        GL20.glUniform1f(this.getUniform("time"), 1.0f);
    }
}
