// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelShulkerBullet;
import net.minecraft.entity.projectile.EntityShulkerBullet;

public class RenderShulkerBullet extends Render<EntityShulkerBullet>
{
    private final /* synthetic */ ModelShulkerBullet model;
    private static final /* synthetic */ ResourceLocation SHULKER_SPARK_TEXTURE;
    
    static {
        SHULKER_SPARK_TEXTURE = new ResourceLocation("textures/entity/shulker/spark.png");
    }
    
    public RenderShulkerBullet(final RenderManager llllllllllIlllIlIlIIlIlIIlIlIlll) {
        super(llllllllllIlllIlIlIIlIlIIlIlIlll);
        this.model = new ModelShulkerBullet();
    }
    
    @Override
    public void doRender(final EntityShulkerBullet llllllllllIlllIlIlIIlIlIIIlllIll, final double llllllllllIlllIlIlIIlIlIIIlllIlI, final double llllllllllIlllIlIlIIlIlIIIlllIIl, final double llllllllllIlllIlIlIIlIlIIIlllIII, final float llllllllllIlllIlIlIIlIlIIIllIlll, final float llllllllllIlllIlIlIIlIlIIIlIlIll) {
        GlStateManager.pushMatrix();
        final float llllllllllIlllIlIlIIlIlIIIllIlIl = this.rotLerp(llllllllllIlllIlIlIIlIlIIIlllIll.prevRotationYaw, llllllllllIlllIlIlIIlIlIIIlllIll.rotationYaw, llllllllllIlllIlIlIIlIlIIIlIlIll);
        final float llllllllllIlllIlIlIIlIlIIIllIlII = llllllllllIlllIlIlIIlIlIIIlllIll.prevRotationPitch + (llllllllllIlllIlIlIIlIlIIIlllIll.rotationPitch - llllllllllIlllIlIlIIlIlIIIlllIll.prevRotationPitch) * llllllllllIlllIlIlIIlIlIIIlIlIll;
        final float llllllllllIlllIlIlIIlIlIIIllIIll = llllllllllIlllIlIlIIlIlIIIlllIll.ticksExisted + llllllllllIlllIlIlIIlIlIIIlIlIll;
        GlStateManager.translate((float)llllllllllIlllIlIlIIlIlIIIlllIlI, (float)llllllllllIlllIlIlIIlIlIIIlllIIl + 0.15f, (float)llllllllllIlllIlIlIIlIlIIIlllIII);
        GlStateManager.rotate(MathHelper.sin(llllllllllIlllIlIlIIlIlIIIllIIll * 0.1f) * 180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(MathHelper.cos(llllllllllIlllIlIlIIlIlIIIllIIll * 0.1f) * 180.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(MathHelper.sin(llllllllllIlllIlIlIIlIlIIIllIIll * 0.15f) * 360.0f, 0.0f, 0.0f, 1.0f);
        final float llllllllllIlllIlIlIIlIlIIIllIIlI = 0.03125f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        this.bindEntityTexture(llllllllllIlllIlIlIIlIlIIIlllIll);
        this.model.render(llllllllllIlllIlIlIIlIlIIIlllIll, 0.0f, 0.0f, 0.0f, llllllllllIlllIlIlIIlIlIIIllIlIl, llllllllllIlllIlIlIIlIlIIIllIlII, 0.03125f);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.5f);
        GlStateManager.scale(1.5f, 1.5f, 1.5f);
        this.model.render(llllllllllIlllIlIlIIlIlIIIlllIll, 0.0f, 0.0f, 0.0f, llllllllllIlllIlIlIIlIlIIIllIlIl, llllllllllIlllIlIlIIlIlIIIllIlII, 0.03125f);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        super.doRender(llllllllllIlllIlIlIIlIlIIIlllIll, llllllllllIlllIlIlIIlIlIIIlllIlI, llllllllllIlllIlIlIIlIlIIIlllIIl, llllllllllIlllIlIlIIlIlIIIlllIII, llllllllllIlllIlIlIIlIlIIIllIlll, llllllllllIlllIlIlIIlIlIIIlIlIll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityShulkerBullet llllllllllIlllIlIlIIlIlIIIlIIlIl) {
        return RenderShulkerBullet.SHULKER_SPARK_TEXTURE;
    }
    
    private float rotLerp(final float llllllllllIlllIlIlIIlIlIIlIIlIll, final float llllllllllIlllIlIlIIlIlIIlIIlIlI, final float llllllllllIlllIlIlIIlIlIIlIIllIl) {
        float llllllllllIlllIlIlIIlIlIIlIIllII;
        for (llllllllllIlllIlIlIIlIlIIlIIllII = llllllllllIlllIlIlIIlIlIIlIIlIlI - llllllllllIlllIlIlIIlIlIIlIIlIll; llllllllllIlllIlIlIIlIlIIlIIllII < -180.0f; llllllllllIlllIlIlIIlIlIIlIIllII += 360.0f) {}
        while (llllllllllIlllIlIlIIlIlIIlIIllII >= 180.0f) {
            llllllllllIlllIlIlIIlIlIIlIIllII -= 360.0f;
        }
        return llllllllllIlllIlIlIIlIlIIlIIlIll + llllllllllIlllIlIlIIlIlIIlIIllIl * llllllllllIlllIlIlIIlIlIIlIIllII;
    }
}
