// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.monster.EntitySlime;

public class LayerSlimeGel implements LayerRenderer<EntitySlime>
{
    private final /* synthetic */ ModelBase slimeModel;
    private final /* synthetic */ RenderSlime slimeRenderer;
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    public LayerSlimeGel(final RenderSlime llllllllllIllllIIllIllIIIlIlIIll) {
        this.slimeModel = new ModelSlime(0);
        this.slimeRenderer = llllllllllIllllIIllIllIIIlIlIIll;
    }
    
    @Override
    public void doRenderLayer(final EntitySlime llllllllllIllllIIllIllIIIIlllllI, final float llllllllllIllllIIllIllIIIlIIIllI, final float llllllllllIllllIIllIllIIIIllllII, final float llllllllllIllllIIllIllIIIlIIIlII, final float llllllllllIllllIIllIllIIIIlllIll, final float llllllllllIllllIIllIllIIIlIIIIlI, final float llllllllllIllllIIllIllIIIlIIIIIl, final float llllllllllIllllIIllIllIIIIlllIII) {
        if (!llllllllllIllllIIllIllIIIIlllllI.isInvisible()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.slimeModel.setModelAttributes(this.slimeRenderer.getMainModel());
            this.slimeModel.render(llllllllllIllllIIllIllIIIIlllllI, llllllllllIllllIIllIllIIIlIIIllI, llllllllllIllllIIllIllIIIIllllII, llllllllllIllllIIllIllIIIIlllIll, llllllllllIllllIIllIllIIIlIIIIlI, llllllllllIllllIIllIllIIIlIIIIIl, llllllllllIllllIIllIllIIIIlllIII);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
    }
}
