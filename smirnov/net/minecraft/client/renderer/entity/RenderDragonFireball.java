// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.projectile.EntityDragonFireball;

public class RenderDragonFireball extends Render<EntityDragonFireball>
{
    private static final /* synthetic */ ResourceLocation DRAGON_FIREBALL_TEXTURE;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityDragonFireball lIlIlllIllIlIl) {
        return RenderDragonFireball.DRAGON_FIREBALL_TEXTURE;
    }
    
    public RenderDragonFireball(final RenderManager lIlIllllIllIll) {
        super(lIlIllllIllIll);
    }
    
    static {
        DRAGON_FIREBALL_TEXTURE = new ResourceLocation("textures/entity/enderdragon/dragon_fireball.png");
    }
    
    @Override
    public void doRender(final EntityDragonFireball lIlIllllIIllIl, final double lIlIllllIIIIII, final double lIlIlllIllllll, final double lIlIllllIIlIlI, final float lIlIlllIllllIl, final float lIlIllllIIlIII) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(lIlIllllIIllIl);
        GlStateManager.translate((float)lIlIllllIIIIII, (float)lIlIlllIllllll, (float)lIlIllllIIlIlI);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        final Tessellator lIlIllllIIIlll = Tessellator.getInstance();
        final BufferBuilder lIlIllllIIIllI = lIlIllllIIIlll.getBuffer();
        final float lIlIllllIIIlIl = 1.0f;
        final float lIlIllllIIIlII = 0.5f;
        final float lIlIllllIIIIll = 0.25f;
        GlStateManager.rotate(180.0f - RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * -RenderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lIlIllllIIllIl));
        }
        lIlIllllIIIllI.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        lIlIllllIIIllI.pos(-0.5, -0.25, 0.0).tex(0.0, 1.0).normal(0.0f, 1.0f, 0.0f).endVertex();
        lIlIllllIIIllI.pos(0.5, -0.25, 0.0).tex(1.0, 1.0).normal(0.0f, 1.0f, 0.0f).endVertex();
        lIlIllllIIIllI.pos(0.5, 0.75, 0.0).tex(1.0, 0.0).normal(0.0f, 1.0f, 0.0f).endVertex();
        lIlIllllIIIllI.pos(-0.5, 0.75, 0.0).tex(0.0, 0.0).normal(0.0f, 1.0f, 0.0f).endVertex();
        lIlIllllIIIlll.draw();
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(lIlIllllIIllIl, lIlIllllIIIIII, lIlIlllIllllll, lIlIllllIIlIlI, lIlIlllIllllIl, lIlIllllIIlIII);
    }
}
