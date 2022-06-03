// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.monster.EntityStray;

public class LayerStrayClothing implements LayerRenderer<EntityStray>
{
    private final /* synthetic */ RenderLivingBase<?> renderer;
    private static final /* synthetic */ ResourceLocation STRAY_CLOTHES_TEXTURES;
    private final /* synthetic */ ModelSkeleton layerModel;
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    public LayerStrayClothing(final RenderLivingBase<?> llllllllllllIllIlIllIIllIllIIlll) {
        this.layerModel = new ModelSkeleton(0.25f, true);
        this.renderer = llllllllllllIllIlIllIIllIllIIlll;
    }
    
    @Override
    public void doRenderLayer(final EntityStray llllllllllllIllIlIllIIllIlIlllII, final float llllllllllllIllIlIllIIllIlIllIll, final float llllllllllllIllIlIllIIllIlIlIIIl, final float llllllllllllIllIlIllIIllIlIlIIII, final float llllllllllllIllIlIllIIllIlIIllll, final float llllllllllllIllIlIllIIllIlIIlllI, final float llllllllllllIllIlIllIIllIlIIllIl, final float llllllllllllIllIlIllIIllIlIlIlIl) {
        this.layerModel.setModelAttributes(this.renderer.getMainModel());
        this.layerModel.setLivingAnimations(llllllllllllIllIlIllIIllIlIlllII, llllllllllllIllIlIllIIllIlIllIll, llllllllllllIllIlIllIIllIlIlIIIl, llllllllllllIllIlIllIIllIlIlIIII);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.renderer.bindTexture(LayerStrayClothing.STRAY_CLOTHES_TEXTURES);
        this.layerModel.render(llllllllllllIllIlIllIIllIlIlllII, llllllllllllIllIlIllIIllIlIllIll, llllllllllllIllIlIllIIllIlIlIIIl, llllllllllllIllIlIllIIllIlIIllll, llllllllllllIllIlIllIIllIlIIlllI, llllllllllllIllIlIllIIllIlIIllIl, llllllllllllIllIlIllIIllIlIlIlIl);
    }
    
    static {
        STRAY_CLOTHES_TEXTURES = new ResourceLocation("textures/entity/skeleton/stray_overlay.png");
    }
}
