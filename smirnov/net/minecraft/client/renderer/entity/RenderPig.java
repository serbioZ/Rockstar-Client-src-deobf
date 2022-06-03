// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.layers.LayerSaddle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityPig;

public class RenderPig extends RenderLiving<EntityPig>
{
    private static final /* synthetic */ ResourceLocation PIG_TEXTURES;
    
    public RenderPig(final RenderManager llllllllllllllIIllIIIIlIlIIIllll) {
        super(llllllllllllllIIllIIIIlIlIIIllll, new ModelPig(), 0.7f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerSaddle(this));
    }
    
    static {
        PIG_TEXTURES = new ResourceLocation("textures/entity/pig/pig.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityPig llllllllllllllIIllIIIIlIlIIIlIll) {
        return RenderPig.PIG_TEXTURES;
    }
}
