// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import java.io.IOException;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;

public class FoliageColorReloadListener implements IResourceManagerReloadListener
{
    private static final /* synthetic */ ResourceLocation LOC_FOLIAGE_PNG;
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllIlIlIlIIIIlIlIIIlllIl) {
        try {
            ColorizerFoliage.setFoliageBiomeColorizer(TextureUtil.readImageData(lllllllllllIlIlIlIIIIlIlIIIlllIl, FoliageColorReloadListener.LOC_FOLIAGE_PNG));
        }
        catch (IOException ex) {}
    }
    
    static {
        LOC_FOLIAGE_PNG = new ResourceLocation("textures/colormap/foliage.png");
    }
}
