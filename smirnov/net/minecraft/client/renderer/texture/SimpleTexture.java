// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import java.awt.image.BufferedImage;
import net.minecraft.client.resources.IResource;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;
import shadersmod.client.ShadersTex;
import optifine.Config;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.client.resources.IResourceManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.ResourceLocation;

public class SimpleTexture extends AbstractTexture
{
    protected final /* synthetic */ ResourceLocation textureLocation;
    private static final /* synthetic */ Logger LOG;
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllllllIIIIIlIllllIIll) throws IOException {
        this.deleteGlTexture();
        IResource lllllllllllllllllIIIIIlIllllIIlI = null;
        try {
            lllllllllllllllllIIIIIlIllllIIlI = lllllllllllllllllIIIIIlIllllIIll.getResource(this.textureLocation);
            final BufferedImage lllllllllllllllllIIIIIlIllllIIIl = TextureUtil.readBufferedImage(lllllllllllllllllIIIIIlIllllIIlI.getInputStream());
            boolean lllllllllllllllllIIIIIlIllllIIII = false;
            boolean lllllllllllllllllIIIIIlIlllIllll = false;
            if (lllllllllllllllllIIIIIlIllllIIlI.hasMetadata()) {
                try {
                    final TextureMetadataSection lllllllllllllllllIIIIIlIlllIlllI = lllllllllllllllllIIIIIlIllllIIlI.getMetadata("texture");
                    if (lllllllllllllllllIIIIIlIlllIlllI != null) {
                        lllllllllllllllllIIIIIlIllllIIII = lllllllllllllllllIIIIIlIlllIlllI.getTextureBlur();
                        lllllllllllllllllIIIIIlIlllIllll = lllllllllllllllllIIIIIlIlllIlllI.getTextureClamp();
                    }
                }
                catch (RuntimeException lllllllllllllllllIIIIIlIlllIllIl) {
                    SimpleTexture.LOG.warn("Failed reading metadata of: {}", (Object)this.textureLocation, (Object)lllllllllllllllllIIIIIlIlllIllIl);
                }
            }
            if (Config.isShaders()) {
                ShadersTex.loadSimpleTexture(this.getGlTextureId(), lllllllllllllllllIIIIIlIllllIIIl, lllllllllllllllllIIIIIlIllllIIII, lllllllllllllllllIIIIIlIlllIllll, lllllllllllllllllIIIIIlIllllIIll, this.textureLocation, this.getMultiTexID());
            }
            else {
                TextureUtil.uploadTextureImageAllocate(this.getGlTextureId(), lllllllllllllllllIIIIIlIllllIIIl, lllllllllllllllllIIIIIlIllllIIII, lllllllllllllllllIIIIIlIlllIllll);
            }
        }
        finally {
            IOUtils.closeQuietly((Closeable)lllllllllllllllllIIIIIlIllllIIlI);
        }
        IOUtils.closeQuietly((Closeable)lllllllllllllllllIIIIIlIllllIIlI);
    }
    
    public SimpleTexture(final ResourceLocation lllllllllllllllllIIIIIlIllllllIl) {
        this.textureLocation = lllllllllllllllllIIIIIlIllllllIl;
    }
    
    static {
        LOG = LogManager.getLogger();
    }
}
