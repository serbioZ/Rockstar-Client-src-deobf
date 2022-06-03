// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import net.minecraft.client.renderer.GlStateManager;
import shadersmod.client.ShadersTex;
import shadersmod.client.MultiTexID;

public abstract class AbstractTexture implements ITextureObject
{
    protected /* synthetic */ boolean mipmapLast;
    protected /* synthetic */ boolean mipmap;
    protected /* synthetic */ boolean blur;
    protected /* synthetic */ boolean blurLast;
    protected /* synthetic */ int glTextureId;
    
    public void deleteGlTexture() {
        ShadersTex.deleteTextures(this, this.glTextureId);
        if (this.glTextureId != -1) {
            TextureUtil.deleteTexture(this.glTextureId);
            this.glTextureId = -1;
        }
    }
    
    @Override
    public int getGlTextureId() {
        if (this.glTextureId == -1) {
            this.glTextureId = TextureUtil.glGenTextures();
        }
        return this.glTextureId;
    }
    
    @Override
    public void setBlurMipmap(final boolean lllllllllllIIlIllIlIIIIIIlllIIIl, final boolean lllllllllllIIlIllIlIIIIIIllIllIl) {
        this.blurLast = this.blur;
        this.mipmapLast = this.mipmap;
        this.setBlurMipmapDirect(lllllllllllIIlIllIlIIIIIIlllIIIl, lllllllllllIIlIllIlIIIIIIllIllIl);
    }
    
    @Override
    public MultiTexID getMultiTexID() {
        return ShadersTex.getMultiTexID(this);
    }
    
    @Override
    public void restoreLastBlurMipmap() {
        this.setBlurMipmapDirect(this.blurLast, this.mipmapLast);
    }
    
    public void setBlurMipmapDirect(final boolean lllllllllllIIlIllIlIIIIIlIIIIIII, final boolean lllllllllllIIlIllIlIIIIIIlllllll) {
        this.blur = lllllllllllIIlIllIlIIIIIlIIIIIII;
        this.mipmap = lllllllllllIIlIllIlIIIIIIlllllll;
        int lllllllllllIIlIllIlIIIIIIlllllIl = 0;
        int lllllllllllIIlIllIlIIIIIIllllIll = 0;
        if (lllllllllllIIlIllIlIIIIIlIIIIIII) {
            final int lllllllllllIIlIllIlIIIIIIllllllI = lllllllllllIIlIllIlIIIIIIlllllll ? 9987 : 9729;
            final int lllllllllllIIlIllIlIIIIIIlllllII = 9729;
        }
        else {
            lllllllllllIIlIllIlIIIIIIlllllIl = (lllllllllllIIlIllIlIIIIIIlllllll ? 9986 : 9728);
            lllllllllllIIlIllIlIIIIIIllllIll = 9728;
        }
        GlStateManager.bindTexture(this.getGlTextureId());
        GlStateManager.glTexParameteri(3553, 10241, lllllllllllIIlIllIlIIIIIIlllllIl);
        GlStateManager.glTexParameteri(3553, 10240, lllllllllllIIlIllIlIIIIIIllllIll);
    }
    
    public AbstractTexture() {
        this.glTextureId = -1;
    }
}
