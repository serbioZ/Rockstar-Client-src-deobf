// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.AbstractSkeleton;

public class RenderSkeleton extends RenderBiped<AbstractSkeleton>
{
    private static final /* synthetic */ ResourceLocation SKELETON_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final AbstractSkeleton lllllllllllllIIIllIIIIllIlllllII) {
        return RenderSkeleton.SKELETON_TEXTURES;
    }
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.09375f, 0.1875f, 0.0f);
    }
    
    static {
        SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    }
    
    public RenderSkeleton(final RenderManager lllllllllllllIIIllIIIIlllIIIIIIl) {
        super(lllllllllllllIIIllIIIIlllIIIIIIl, new ModelSkeleton(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelSkeleton(0.5f, true);
                this.modelArmor = (T)new ModelSkeleton(1.0f, true);
            }
        });
    }
}
