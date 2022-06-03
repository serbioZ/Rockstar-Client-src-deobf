// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerStrayClothing;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;

public class RenderStray extends RenderSkeleton
{
    private static final /* synthetic */ ResourceLocation STRAY_SKELETON_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final AbstractSkeleton lllllllllllIIlllIlIllllIlIIlIIll) {
        return RenderStray.STRAY_SKELETON_TEXTURES;
    }
    
    public RenderStray(final RenderManager lllllllllllIIlllIlIllllIlIIlIlll) {
        super(lllllllllllIIlllIlIllllIlIIlIlll);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerStrayClothing(this));
    }
    
    static {
        STRAY_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/stray.png");
    }
}
