// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.resources.IResource;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.image.BufferedImage;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class LayeredTexture extends AbstractTexture
{
    public final /* synthetic */ List<String> layeredTextureNames;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public void loadTexture(final IResourceManager llllllllllllIIIIIIIllIlIllIlllIl) throws IOException {
        this.deleteGlTexture();
        BufferedImage llllllllllllIIIIIIIllIlIllIlllII = null;
        for (final String llllllllllllIIIIIIIllIlIllIllIll : this.layeredTextureNames) {
            IResource llllllllllllIIIIIIIllIlIllIllIlI = null;
            try {
                if (llllllllllllIIIIIIIllIlIllIllIll == null) {
                    continue;
                }
                llllllllllllIIIIIIIllIlIllIllIlI = llllllllllllIIIIIIIllIlIllIlllIl.getResource(new ResourceLocation(llllllllllllIIIIIIIllIlIllIllIll));
                final BufferedImage llllllllllllIIIIIIIllIlIllIllIIl = TextureUtil.readBufferedImage(llllllllllllIIIIIIIllIlIllIllIlI.getInputStream());
                if (llllllllllllIIIIIIIllIlIllIlllII == null) {
                    llllllllllllIIIIIIIllIlIllIlllII = new BufferedImage(llllllllllllIIIIIIIllIlIllIllIIl.getWidth(), llllllllllllIIIIIIIllIlIllIllIIl.getHeight(), 2);
                }
                llllllllllllIIIIIIIllIlIllIlllII.getGraphics().drawImage(llllllllllllIIIIIIIllIlIllIllIIl, 0, 0, null);
                continue;
            }
            catch (IOException llllllllllllIIIIIIIllIlIllIllIII) {
                LayeredTexture.LOGGER.error("Couldn't load layered image", (Throwable)llllllllllllIIIIIIIllIlIllIllIII);
            }
            finally {
                IOUtils.closeQuietly((Closeable)llllllllllllIIIIIIIllIlIllIllIlI);
            }
            return;
        }
        TextureUtil.uploadTextureImage(this.getGlTextureId(), llllllllllllIIIIIIIllIlIllIlllII);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public LayeredTexture(final String... llllllllllllIIIIIIIllIlIlllIIlll) {
        this.layeredTextureNames = (List<String>)Lists.newArrayList((Object[])llllllllllllIIIIIIIllIlIlllIIlll);
    }
}
