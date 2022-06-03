// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import net.minecraft.client.resources.IResourceManager;
import shadersmod.client.ShadersTex;
import optifine.Config;

public class DynamicTexture extends AbstractTexture
{
    private final /* synthetic */ int height;
    private /* synthetic */ boolean shadersInitialized;
    private final /* synthetic */ int[] dynamicTextureData;
    private final /* synthetic */ int width;
    
    public DynamicTexture(final int lllllllllllIIIlIlIllIIlIIIIllIIl, final int lllllllllllIIIlIlIllIIlIIIIlIlIl) {
        this.shadersInitialized = false;
        this.width = lllllllllllIIIlIlIllIIlIIIIllIIl;
        this.height = lllllllllllIIIlIlIllIIlIIIIlIlIl;
        this.dynamicTextureData = new int[lllllllllllIIIlIlIllIIlIIIIllIIl * lllllllllllIIIlIlIllIIlIIIIlIlIl * 3];
        if (Config.isShaders()) {
            ShadersTex.initDynamicTexture(this.getGlTextureId(), lllllllllllIIIlIlIllIIlIIIIllIIl, lllllllllllIIIlIlIllIIlIIIIlIlIl, this);
            this.shadersInitialized = true;
        }
        else {
            TextureUtil.allocateTexture(this.getGlTextureId(), lllllllllllIIIlIlIllIIlIIIIllIIl, lllllllllllIIIlIlIllIIlIIIIlIlIl);
        }
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllIIIlIlIllIIlIIIIlIIll) throws IOException {
    }
    
    public int[] getTextureData() {
        return this.dynamicTextureData;
    }
    
    public DynamicTexture(final BufferedImage lllllllllllIIIlIlIllIIlIIIlIIIII) {
        this(lllllllllllIIIlIlIllIIlIIIlIIIII.getWidth(), lllllllllllIIIlIlIllIIlIIIlIIIII.getHeight());
        lllllllllllIIIlIlIllIIlIIIlIIIII.getRGB(0, 0, lllllllllllIIIlIlIllIIlIIIlIIIII.getWidth(), lllllllllllIIIlIlIllIIlIIIlIIIII.getHeight(), this.dynamicTextureData, 0, lllllllllllIIIlIlIllIIlIIIlIIIII.getWidth());
        this.updateDynamicTexture();
    }
    
    public void updateDynamicTexture() {
        if (Config.isShaders()) {
            if (!this.shadersInitialized) {
                ShadersTex.initDynamicTexture(this.getGlTextureId(), this.width, this.height, this);
                this.shadersInitialized = true;
            }
            ShadersTex.updateDynamicTexture(this.getGlTextureId(), this.dynamicTextureData, this.width, this.height, this);
        }
        else {
            TextureUtil.uploadTexture(this.getGlTextureId(), this.dynamicTextureData, this.width, this.height);
        }
    }
}
