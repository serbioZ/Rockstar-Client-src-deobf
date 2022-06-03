// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import java.util.Random;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;

public class LayerArrow implements LayerRenderer<EntityLivingBase>
{
    private final /* synthetic */ RenderLivingBase<?> renderer;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIlIIIlIIlllllllIlI, final float llllllllllllllIlIIIlIlIIIIIlIIlI, final float llllllllllllllIlIIIlIlIIIIIlIIIl, final float llllllllllllllIlIIIlIlIIIIIlIIII, final float llllllllllllllIlIIIlIlIIIIIIllll, final float llllllllllllllIlIIIlIlIIIIIIlllI, final float llllllllllllllIlIIIlIlIIIIIIllIl, final float llllllllllllllIlIIIlIlIIIIIIllII) {
        final int llllllllllllllIlIIIlIlIIIIIIlIll = llllllllllllllIlIIIlIIlllllllIlI.getArrowCountInEntity();
        if (llllllllllllllIlIIIlIlIIIIIIlIll > 0) {
            final Entity llllllllllllllIlIIIlIlIIIIIIlIlI = new EntityTippedArrow(llllllllllllllIlIIIlIIlllllllIlI.world, llllllllllllllIlIIIlIIlllllllIlI.posX, llllllllllllllIlIIIlIIlllllllIlI.posY, llllllllllllllIlIIIlIIlllllllIlI.posZ);
            final Random llllllllllllllIlIIIlIlIIIIIIlIIl = new Random(llllllllllllllIlIIIlIIlllllllIlI.getEntityId());
            RenderHelper.disableStandardItemLighting();
            for (int llllllllllllllIlIIIlIlIIIIIIlIII = 0; llllllllllllllIlIIIlIlIIIIIIlIII < llllllllllllllIlIIIlIlIIIIIIlIll; ++llllllllllllllIlIIIlIlIIIIIIlIII) {
                GlStateManager.pushMatrix();
                final ModelRenderer llllllllllllllIlIIIlIlIIIIIIIlll = this.renderer.getMainModel().getRandomModelBox(llllllllllllllIlIIIlIlIIIIIIlIIl);
                final ModelBox llllllllllllllIlIIIlIlIIIIIIIllI = llllllllllllllIlIIIlIlIIIIIIIlll.cubeList.get(llllllllllllllIlIIIlIlIIIIIIlIIl.nextInt(llllllllllllllIlIIIlIlIIIIIIIlll.cubeList.size()));
                llllllllllllllIlIIIlIlIIIIIIIlll.postRender(0.0625f);
                float llllllllllllllIlIIIlIlIIIIIIIlIl = llllllllllllllIlIIIlIlIIIIIIlIIl.nextFloat();
                float llllllllllllllIlIIIlIlIIIIIIIlII = llllllllllllllIlIIIlIlIIIIIIlIIl.nextFloat();
                float llllllllllllllIlIIIlIlIIIIIIIIll = llllllllllllllIlIIIlIlIIIIIIlIIl.nextFloat();
                final float llllllllllllllIlIIIlIlIIIIIIIIlI = (llllllllllllllIlIIIlIlIIIIIIIllI.posX1 + (llllllllllllllIlIIIlIlIIIIIIIllI.posX2 - llllllllllllllIlIIIlIlIIIIIIIllI.posX1) * llllllllllllllIlIIIlIlIIIIIIIlIl) / 16.0f;
                final float llllllllllllllIlIIIlIlIIIIIIIIIl = (llllllllllllllIlIIIlIlIIIIIIIllI.posY1 + (llllllllllllllIlIIIlIlIIIIIIIllI.posY2 - llllllllllllllIlIIIlIlIIIIIIIllI.posY1) * llllllllllllllIlIIIlIlIIIIIIIlII) / 16.0f;
                final float llllllllllllllIlIIIlIlIIIIIIIIII = (llllllllllllllIlIIIlIlIIIIIIIllI.posZ1 + (llllllllllllllIlIIIlIlIIIIIIIllI.posZ2 - llllllllllllllIlIIIlIlIIIIIIIllI.posZ1) * llllllllllllllIlIIIlIlIIIIIIIIll) / 16.0f;
                GlStateManager.translate(llllllllllllllIlIIIlIlIIIIIIIIlI, llllllllllllllIlIIIlIlIIIIIIIIIl, llllllllllllllIlIIIlIlIIIIIIIIII);
                llllllllllllllIlIIIlIlIIIIIIIlIl = llllllllllllllIlIIIlIlIIIIIIIlIl * 2.0f - 1.0f;
                llllllllllllllIlIIIlIlIIIIIIIlII = llllllllllllllIlIIIlIlIIIIIIIlII * 2.0f - 1.0f;
                llllllllllllllIlIIIlIlIIIIIIIIll = llllllllllllllIlIIIlIlIIIIIIIIll * 2.0f - 1.0f;
                llllllllllllllIlIIIlIlIIIIIIIlIl *= -1.0f;
                llllllllllllllIlIIIlIlIIIIIIIlII *= -1.0f;
                llllllllllllllIlIIIlIlIIIIIIIIll *= -1.0f;
                final float llllllllllllllIlIIIlIIllllllllll = MathHelper.sqrt(llllllllllllllIlIIIlIlIIIIIIIlIl * llllllllllllllIlIIIlIlIIIIIIIlIl + llllllllllllllIlIIIlIlIIIIIIIIll * llllllllllllllIlIIIlIlIIIIIIIIll);
                llllllllllllllIlIIIlIlIIIIIIlIlI.rotationYaw = (float)(Math.atan2(llllllllllllllIlIIIlIlIIIIIIIlIl, llllllllllllllIlIIIlIlIIIIIIIIll) * 57.29577951308232);
                llllllllllllllIlIIIlIlIIIIIIlIlI.rotationPitch = (float)(Math.atan2(llllllllllllllIlIIIlIlIIIIIIIlII, llllllllllllllIlIIIlIIllllllllll) * 57.29577951308232);
                llllllllllllllIlIIIlIlIIIIIIlIlI.prevRotationYaw = llllllllllllllIlIIIlIlIIIIIIlIlI.rotationYaw;
                llllllllllllllIlIIIlIlIIIIIIlIlI.prevRotationPitch = llllllllllllllIlIIIlIlIIIIIIlIlI.rotationPitch;
                final double llllllllllllllIlIIIlIIlllllllllI = 0.0;
                final double llllllllllllllIlIIIlIIllllllllIl = 0.0;
                final double llllllllllllllIlIIIlIIllllllllII = 0.0;
                this.renderer.getRenderManager().doRenderEntity(llllllllllllllIlIIIlIlIIIIIIlIlI, 0.0, 0.0, 0.0, 0.0f, llllllllllllllIlIIIlIlIIIIIlIIII, false);
                GlStateManager.popMatrix();
            }
            RenderHelper.enableStandardItemLighting();
        }
    }
    
    public LayerArrow(final RenderLivingBase<?> llllllllllllllIlIIIlIlIIIIlIlIII) {
        this.renderer = llllllllllllllIlIIIlIlIIIIlIlIII;
    }
}
