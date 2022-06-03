// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerLlamaDecor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelLlama;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityLlama;

public class RenderLlama extends RenderLiving<EntityLlama>
{
    private static final /* synthetic */ ResourceLocation[] field_191350_a;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityLlama lllllllllllIIlIIIIIIllIIIIlIllII) {
        return RenderLlama.field_191350_a[lllllllllllIIlIIIIIIllIIIIlIllII.func_190719_dM()];
    }
    
    static {
        field_191350_a = new ResourceLocation[] { new ResourceLocation("textures/entity/llama/llama_creamy.png"), new ResourceLocation("textures/entity/llama/llama_white.png"), new ResourceLocation("textures/entity/llama/llama_brown.png"), new ResourceLocation("textures/entity/llama/llama_gray.png") };
    }
    
    public RenderLlama(final RenderManager lllllllllllIIlIIIIIIllIIIIllIIlI) {
        super(lllllllllllIIlIIIIIIllIIIIllIIlI, new ModelLlama(0.0f), 0.7f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerLlamaDecor(this));
    }
}
