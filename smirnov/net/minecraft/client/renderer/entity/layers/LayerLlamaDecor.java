// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLlama;
import net.minecraft.client.model.ModelLlama;
import net.minecraft.entity.passive.EntityLlama;

public class LayerLlamaDecor implements LayerRenderer<EntityLlama>
{
    private final /* synthetic */ ModelLlama field_191366_c;
    private final /* synthetic */ RenderLlama field_191365_b;
    private static final /* synthetic */ ResourceLocation[] field_191364_a;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerLlamaDecor(final RenderLlama llllllllllllllIIIlIIIllllllIIllI) {
        this.field_191366_c = new ModelLlama(0.5f);
        this.field_191365_b = llllllllllllllIIIlIIIllllllIIllI;
    }
    
    @Override
    public void doRenderLayer(final EntityLlama llllllllllllllIIIlIIIlllllIlIIIl, final float llllllllllllllIIIlIIIlllllIlIIII, final float llllllllllllllIIIlIIIlllllIllIII, final float llllllllllllllIIIlIIIlllllIlIlll, final float llllllllllllllIIIlIIIlllllIlIllI, final float llllllllllllllIIIlIIIlllllIlIlIl, final float llllllllllllllIIIlIIIlllllIlIlII, final float llllllllllllllIIIlIIIlllllIlIIll) {
        if (llllllllllllllIIIlIIIlllllIlIIIl.func_190717_dN()) {
            this.field_191365_b.bindTexture(LayerLlamaDecor.field_191364_a[llllllllllllllIIIlIIIlllllIlIIIl.func_190704_dO().getMetadata()]);
            this.field_191366_c.setModelAttributes(this.field_191365_b.getMainModel());
            this.field_191366_c.render(llllllllllllllIIIlIIIlllllIlIIIl, llllllllllllllIIIlIIIlllllIlIIII, llllllllllllllIIIlIIIlllllIllIII, llllllllllllllIIIlIIIlllllIlIllI, llllllllllllllIIIlIIIlllllIlIlIl, llllllllllllllIIIlIIIlllllIlIlII, llllllllllllllIIIlIIIlllllIlIIll);
        }
    }
    
    static {
        field_191364_a = new ResourceLocation[] { new ResourceLocation("textures/entity/llama/decor/decor_white.png"), new ResourceLocation("textures/entity/llama/decor/decor_orange.png"), new ResourceLocation("textures/entity/llama/decor/decor_magenta.png"), new ResourceLocation("textures/entity/llama/decor/decor_light_blue.png"), new ResourceLocation("textures/entity/llama/decor/decor_yellow.png"), new ResourceLocation("textures/entity/llama/decor/decor_lime.png"), new ResourceLocation("textures/entity/llama/decor/decor_pink.png"), new ResourceLocation("textures/entity/llama/decor/decor_gray.png"), new ResourceLocation("textures/entity/llama/decor/decor_silver.png"), new ResourceLocation("textures/entity/llama/decor/decor_cyan.png"), new ResourceLocation("textures/entity/llama/decor/decor_purple.png"), new ResourceLocation("textures/entity/llama/decor/decor_blue.png"), new ResourceLocation("textures/entity/llama/decor/decor_brown.png"), new ResourceLocation("textures/entity/llama/decor/decor_green.png"), new ResourceLocation("textures/entity/llama/decor/decor_red.png"), new ResourceLocation("textures/entity/llama/decor/decor_black.png") };
    }
}
