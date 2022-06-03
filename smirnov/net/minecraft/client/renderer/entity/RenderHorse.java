// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.entity.Entity;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import net.minecraft.entity.passive.EntityHorse;

public class RenderHorse extends RenderLiving<EntityHorse>
{
    private static final /* synthetic */ Map<String, ResourceLocation> LAYERED_LOCATION_CACHE;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityHorse lllllllllllllllIlIlIIIIIIlIIIlII) {
        final String lllllllllllllllIlIlIIIIIIlIIIllI = lllllllllllllllIlIlIIIIIIlIIIlII.getHorseTexture();
        ResourceLocation lllllllllllllllIlIlIIIIIIlIIIlIl = RenderHorse.LAYERED_LOCATION_CACHE.get(lllllllllllllllIlIlIIIIIIlIIIllI);
        if (lllllllllllllllIlIlIIIIIIlIIIlIl == null) {
            lllllllllllllllIlIlIIIIIIlIIIlIl = new ResourceLocation(lllllllllllllllIlIlIIIIIIlIIIllI);
            Minecraft.getMinecraft().getTextureManager().loadTexture(lllllllllllllllIlIlIIIIIIlIIIlIl, new LayeredTexture(lllllllllllllllIlIlIIIIIIlIIIlII.getVariantTexturePaths()));
            RenderHorse.LAYERED_LOCATION_CACHE.put(lllllllllllllllIlIlIIIIIIlIIIllI, lllllllllllllllIlIlIIIIIIlIIIlIl);
        }
        return lllllllllllllllIlIlIIIIIIlIIIlIl;
    }
    
    static {
        LAYERED_LOCATION_CACHE = Maps.newHashMap();
    }
    
    public RenderHorse(final RenderManager lllllllllllllllIlIlIIIIIIlIIlllI) {
        super(lllllllllllllllIlIlIIIIIIlIIlllI, new ModelHorse(), 0.75f);
    }
}
