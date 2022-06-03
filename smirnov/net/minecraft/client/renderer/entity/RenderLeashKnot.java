// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelLeashKnot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.EntityLeashKnot;

public class RenderLeashKnot extends Render<EntityLeashKnot>
{
    private static final /* synthetic */ ResourceLocation LEASH_KNOT_TEXTURES;
    private final /* synthetic */ ModelLeashKnot leashKnotModel;
    
    @Override
    public void doRender(final EntityLeashKnot lIIllllIllllIIl, final double lIIllllIlllIIII, final double lIIllllIllIllll, final double lIIllllIlllIllI, final float lIIllllIllIllIl, final float lIIllllIlllIlII) {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        GlStateManager.translate((float)lIIllllIlllIIII, (float)lIIllllIllIllll, (float)lIIllllIlllIllI);
        final float lIIllllIlllIIll = 0.0625f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        GlStateManager.enableAlpha();
        this.bindEntityTexture(lIIllllIllllIIl);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lIIllllIllllIIl));
        }
        this.leashKnotModel.render(lIIllllIllllIIl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        super.doRender(lIIllllIllllIIl, lIIllllIlllIIII, lIIllllIllIllll, lIIllllIlllIllI, lIIllllIllIllIl, lIIllllIlllIlII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityLeashKnot lIIllllIllIlIIl) {
        return RenderLeashKnot.LEASH_KNOT_TEXTURES;
    }
    
    static {
        LEASH_KNOT_TEXTURES = new ResourceLocation("textures/entity/lead_knot.png");
    }
    
    public RenderLeashKnot(final RenderManager lIIlllllIIIIIll) {
        super(lIIlllllIIIIIll);
        this.leashKnotModel = new ModelLeashKnot();
    }
}
