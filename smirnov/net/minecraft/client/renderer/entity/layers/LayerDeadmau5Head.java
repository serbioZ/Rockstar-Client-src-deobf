// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;

public class LayerDeadmau5Head implements LayerRenderer<AbstractClientPlayer>
{
    private final /* synthetic */ RenderPlayer playerRenderer;
    
    public LayerDeadmau5Head(final RenderPlayer lllllllllllllIIIlIlIIIllIIIIIIll) {
        this.playerRenderer = lllllllllllllIIIlIlIIIllIIIIIIll;
    }
    
    @Override
    public void doRenderLayer(final AbstractClientPlayer lllllllllllllIIIlIlIIIlIlllllIlI, final float lllllllllllllIIIlIlIIIlIlllllIIl, final float lllllllllllllIIIlIlIIIlIlllllIII, final float lllllllllllllIIIlIlIIIlIlllIllII, final float lllllllllllllIIIlIlIIIlIllllIllI, final float lllllllllllllIIIlIlIIIlIllllIlIl, final float lllllllllllllIIIlIlIIIlIllllIlII, final float lllllllllllllIIIlIlIIIlIllllIIll) {
        if ("deadmau5".equals(lllllllllllllIIIlIlIIIlIlllllIlI.getName()) && lllllllllllllIIIlIlIIIlIlllllIlI.hasSkin() && !lllllllllllllIIIlIlIIIlIlllllIlI.isInvisible()) {
            this.playerRenderer.bindTexture(lllllllllllllIIIlIlIIIlIlllllIlI.getLocationSkin());
            for (int lllllllllllllIIIlIlIIIlIllllIIlI = 0; lllllllllllllIIIlIlIIIlIllllIIlI < 2; ++lllllllllllllIIIlIlIIIlIllllIIlI) {
                final float lllllllllllllIIIlIlIIIlIllllIIIl = lllllllllllllIIIlIlIIIlIlllllIlI.prevRotationYaw + (lllllllllllllIIIlIlIIIlIlllllIlI.rotationYaw - lllllllllllllIIIlIlIIIlIlllllIlI.prevRotationYaw) * lllllllllllllIIIlIlIIIlIlllIllII - (lllllllllllllIIIlIlIIIlIlllllIlI.prevRenderYawOffset + (lllllllllllllIIIlIlIIIlIlllllIlI.renderYawOffset - lllllllllllllIIIlIlIIIlIlllllIlI.prevRenderYawOffset) * lllllllllllllIIIlIlIIIlIlllIllII);
                final float lllllllllllllIIIlIlIIIlIllllIIII = lllllllllllllIIIlIlIIIlIlllllIlI.prevRotationPitch + (lllllllllllllIIIlIlIIIlIlllllIlI.rotationPitch - lllllllllllllIIIlIlIIIlIlllllIlI.prevRotationPitch) * lllllllllllllIIIlIlIIIlIlllIllII;
                GlStateManager.pushMatrix();
                GlStateManager.rotate(lllllllllllllIIIlIlIIIlIllllIIIl, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(lllllllllllllIIIlIlIIIlIllllIIII, 1.0f, 0.0f, 0.0f);
                GlStateManager.translate(0.375f * (lllllllllllllIIIlIlIIIlIllllIIlI * 2 - 1), 0.0f, 0.0f);
                GlStateManager.translate(0.0f, -0.375f, 0.0f);
                GlStateManager.rotate(-lllllllllllllIIIlIlIIIlIllllIIII, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-lllllllllllllIIIlIlIIIlIllllIIIl, 0.0f, 1.0f, 0.0f);
                final float lllllllllllllIIIlIlIIIlIlllIllll = 1.3333334f;
                GlStateManager.scale(1.3333334f, 1.3333334f, 1.3333334f);
                this.playerRenderer.getMainModel().renderDeadmau5Head(0.0625f);
                GlStateManager.popMatrix();
            }
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
