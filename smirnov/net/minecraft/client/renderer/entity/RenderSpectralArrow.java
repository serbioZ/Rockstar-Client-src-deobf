// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.projectile.EntitySpectralArrow;

public class RenderSpectralArrow extends RenderArrow<EntitySpectralArrow>
{
    public static final /* synthetic */ ResourceLocation RES_SPECTRAL_ARROW;
    
    public RenderSpectralArrow(final RenderManager lllllllllllIlIIIIllIllIIIlllIIll) {
        super(lllllllllllIlIIIIllIllIIIlllIIll);
    }
    
    static {
        RES_SPECTRAL_ARROW = new ResourceLocation("textures/entity/projectiles/spectral_arrow.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySpectralArrow lllllllllllIlIIIIllIllIIIllIllll) {
        return RenderSpectralArrow.RES_SPECTRAL_ARROW;
    }
}
