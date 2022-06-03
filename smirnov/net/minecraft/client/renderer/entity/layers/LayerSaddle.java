// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.passive.EntityPig;

public class LayerSaddle implements LayerRenderer<EntityPig>
{
    private final /* synthetic */ RenderPig pigRenderer;
    private final /* synthetic */ ModelPig pigModel;
    private static final /* synthetic */ ResourceLocation TEXTURE;
    
    public LayerSaddle(final RenderPig lllllllllllIlIllllIIlIIIIlllllII) {
        this.pigModel = new ModelPig(0.5f);
        this.pigRenderer = lllllllllllIlIllllIIlIIIIlllllII;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final EntityPig lllllllllllIlIllllIIlIIIIlllIIII, final float lllllllllllIlIllllIIlIIIIllIllll, final float lllllllllllIlIllllIIlIIIIllIIlIl, final float lllllllllllIlIllllIIlIIIIllIllIl, final float lllllllllllIlIllllIIlIIIIllIIlII, final float lllllllllllIlIllllIIlIIIIllIIIll, final float lllllllllllIlIllllIIlIIIIllIIIlI, final float lllllllllllIlIllllIIlIIIIllIIIIl) {
        if (lllllllllllIlIllllIIlIIIIlllIIII.getSaddled()) {
            this.pigRenderer.bindTexture(LayerSaddle.TEXTURE);
            this.pigModel.setModelAttributes(this.pigRenderer.getMainModel());
            this.pigModel.render(lllllllllllIlIllllIIlIIIIlllIIII, lllllllllllIlIllllIIlIIIIllIllll, lllllllllllIlIllllIIlIIIIllIIlIl, lllllllllllIlIllllIIlIIIIllIIlII, lllllllllllIlIllllIIlIIIIllIIIll, lllllllllllIlIllllIIlIIIIllIIIlI, lllllllllllIlIllllIIlIIIIllIIIIl);
        }
    }
    
    static {
        TEXTURE = new ResourceLocation("textures/entity/pig/pig_saddle.png");
    }
}
