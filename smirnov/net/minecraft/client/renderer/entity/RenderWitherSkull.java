// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.entity.projectile.EntityWitherSkull;

public class RenderWitherSkull extends Render<EntityWitherSkull>
{
    private final /* synthetic */ ModelSkeletonHead skeletonHeadModel;
    private static final /* synthetic */ ResourceLocation INVULNERABLE_WITHER_TEXTURES;
    private static final /* synthetic */ ResourceLocation WITHER_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityWitherSkull lllllllllllIIlIlIlllIlIllIllIIll) {
        return lllllllllllIIlIlIlllIlIllIllIIll.isInvulnerable() ? RenderWitherSkull.INVULNERABLE_WITHER_TEXTURES : RenderWitherSkull.WITHER_TEXTURES;
    }
    
    static {
        INVULNERABLE_WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
        WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither.png");
    }
    
    public RenderWitherSkull(final RenderManager lllllllllllIIlIlIlllIlIllllIIlII) {
        super(lllllllllllIIlIlIlllIlIllllIIlII);
        this.skeletonHeadModel = new ModelSkeletonHead();
    }
    
    private float getRenderYaw(final float lllllllllllIIlIlIlllIlIlllIlllII, final float lllllllllllIIlIlIlllIlIlllIllIll, final float lllllllllllIIlIlIlllIlIlllIlIllI) {
        float lllllllllllIIlIlIlllIlIlllIllIIl;
        for (lllllllllllIIlIlIlllIlIlllIllIIl = lllllllllllIIlIlIlllIlIlllIllIll - lllllllllllIIlIlIlllIlIlllIlllII; lllllllllllIIlIlIlllIlIlllIllIIl < -180.0f; lllllllllllIIlIlIlllIlIlllIllIIl += 360.0f) {}
        while (lllllllllllIIlIlIlllIlIlllIllIIl >= 180.0f) {
            lllllllllllIIlIlIlllIlIlllIllIIl -= 360.0f;
        }
        return lllllllllllIIlIlIlllIlIlllIlllII + lllllllllllIIlIlIlllIlIlllIlIllI * lllllllllllIIlIlIlllIlIlllIllIIl;
    }
    
    @Override
    public void doRender(final EntityWitherSkull lllllllllllIIlIlIlllIlIlllIIlIIl, final double lllllllllllIIlIlIlllIlIllIlllllI, final double lllllllllllIIlIlIlllIlIlllIIIlll, final double lllllllllllIIlIlIlllIlIllIllllII, final float lllllllllllIIlIlIlllIlIllIlllIll, final float lllllllllllIIlIlIlllIlIllIlllIlI) {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        final float lllllllllllIIlIlIlllIlIlllIIIIll = this.getRenderYaw(lllllllllllIIlIlIlllIlIlllIIlIIl.prevRotationYaw, lllllllllllIIlIlIlllIlIlllIIlIIl.rotationYaw, lllllllllllIIlIlIlllIlIllIlllIlI);
        final float lllllllllllIIlIlIlllIlIlllIIIIlI = lllllllllllIIlIlIlllIlIlllIIlIIl.prevRotationPitch + (lllllllllllIIlIlIlllIlIlllIIlIIl.rotationPitch - lllllllllllIIlIlIlllIlIlllIIlIIl.prevRotationPitch) * lllllllllllIIlIlIlllIlIllIlllIlI;
        GlStateManager.translate((float)lllllllllllIIlIlIlllIlIllIlllllI, (float)lllllllllllIIlIlIlllIlIlllIIIlll, (float)lllllllllllIIlIlIlllIlIllIllllII);
        final float lllllllllllIIlIlIlllIlIlllIIIIIl = 0.0625f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        GlStateManager.enableAlpha();
        this.bindEntityTexture(lllllllllllIIlIlIlllIlIlllIIlIIl);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllIIlIlIlllIlIlllIIlIIl));
        }
        this.skeletonHeadModel.render(lllllllllllIIlIlIlllIlIlllIIlIIl, 0.0f, 0.0f, 0.0f, lllllllllllIIlIlIlllIlIlllIIIIll, lllllllllllIIlIlIlllIlIlllIIIIlI, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        super.doRender(lllllllllllIIlIlIlllIlIlllIIlIIl, lllllllllllIIlIlIlllIlIllIlllllI, lllllllllllIIlIlIlllIlIlllIIIlll, lllllllllllIIlIlIlllIlIllIllllII, lllllllllllIIlIlIlllIlIllIlllIll, lllllllllllIIlIlIlllIlIllIlllIlI);
    }
}
