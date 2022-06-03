// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import java.io.IOException;
import net.minecraft.client.resources.IResourceManager;
import shadersmod.client.MultiTexID;

public interface ITextureObject
{
    void setBlurMipmap(final boolean p0, final boolean p1);
    
    int getGlTextureId();
    
    void restoreLastBlurMipmap();
    
    MultiTexID getMultiTexID();
    
    void loadTexture(final IResourceManager p0) throws IOException;
}
