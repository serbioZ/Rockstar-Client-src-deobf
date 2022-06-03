// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;

public class RenderWitherSkeleton extends RenderSkeleton
{
    private static final /* synthetic */ ResourceLocation WITHER_SKELETON_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final AbstractSkeleton lllllllllllIllIIIIlIlIlIIlIIIlII) {
        return RenderWitherSkeleton.WITHER_SKELETON_TEXTURES;
    }
    
    @Override
    protected void preRenderCallback(final AbstractSkeleton lllllllllllIllIIIIlIlIlIIlIIIIlI, final float lllllllllllIllIIIIlIlIlIIlIIIIIl) {
        GlStateManager.scale(1.2f, 1.2f, 1.2f);
    }
    
    public RenderWitherSkeleton(final RenderManager lllllllllllIllIIIIlIlIlIIlIIIllI) {
        super(lllllllllllIllIIIIlIlIlIIlIIIllI);
    }
    
    static {
        WITHER_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
    }
}
