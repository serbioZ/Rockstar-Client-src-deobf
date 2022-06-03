// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;

public abstract class RenderArrow<T extends EntityArrow> extends Render<T>
{
    public RenderArrow(final RenderManager lllllllllllllIIIIlIlIlIIIlIlllII) {
        super(lllllllllllllIIIIlIlIlIIIlIlllII);
    }
    
    @Override
    public void doRender(final T lllllllllllllIIIIlIlIlIIIlIIIIll, final double lllllllllllllIIIIlIlIlIIIlIIIIlI, final double lllllllllllllIIIIlIlIlIIIlIIIIIl, final double lllllllllllllIIIIlIlIlIIIIlIlIlI, final float lllllllllllllIIIIlIlIlIIIIlIlIIl, final float lllllllllllllIIIIlIlIlIIIIlIlIII) {
        this.bindEntityTexture(lllllllllllllIIIIlIlIlIIIlIIIIll);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.disableLighting();
        GlStateManager.translate((float)lllllllllllllIIIIlIlIlIIIlIIIIlI, (float)lllllllllllllIIIIlIlIlIIIlIIIIIl, (float)lllllllllllllIIIIlIlIlIIIIlIlIlI);
        GlStateManager.rotate(lllllllllllllIIIIlIlIlIIIlIIIIll.prevRotationYaw + (lllllllllllllIIIIlIlIlIIIlIIIIll.rotationYaw - lllllllllllllIIIIlIlIlIIIlIIIIll.prevRotationYaw) * lllllllllllllIIIIlIlIlIIIIlIlIII - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIlIlIlIIIlIIIIll.prevRotationPitch + (lllllllllllllIIIIlIlIlIIIlIIIIll.rotationPitch - lllllllllllllIIIIlIlIlIIIlIIIIll.prevRotationPitch) * lllllllllllllIIIIlIlIlIIIIlIlIII, 0.0f, 0.0f, 1.0f);
        final Tessellator lllllllllllllIIIIlIlIlIIIIllllIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIIIlIlIlIIIIllllII = lllllllllllllIIIIlIlIlIIIIllllIl.getBuffer();
        final int lllllllllllllIIIIlIlIlIIIIlllIll = 0;
        final float lllllllllllllIIIIlIlIlIIIIlllIlI = 0.0f;
        final float lllllllllllllIIIIlIlIlIIIIlllIIl = 0.5f;
        final float lllllllllllllIIIIlIlIlIIIIlllIII = 0.0f;
        final float lllllllllllllIIIIlIlIlIIIIllIlll = 0.15625f;
        final float lllllllllllllIIIIlIlIlIIIIllIllI = 0.0f;
        final float lllllllllllllIIIIlIlIlIIIIllIlIl = 0.15625f;
        final float lllllllllllllIIIIlIlIlIIIIllIlII = 0.15625f;
        final float lllllllllllllIIIIlIlIlIIIIllIIll = 0.3125f;
        final float lllllllllllllIIIIlIlIlIIIIllIIlI = 0.05625f;
        GlStateManager.enableRescaleNormal();
        final float lllllllllllllIIIIlIlIlIIIIllIIIl = lllllllllllllIIIIlIlIlIIIlIIIIll.arrowShake - lllllllllllllIIIIlIlIlIIIIlIlIII;
        if (lllllllllllllIIIIlIlIlIIIIllIIIl > 0.0f) {
            final float lllllllllllllIIIIlIlIlIIIIllIIII = -MathHelper.sin(lllllllllllllIIIIlIlIlIIIIllIIIl * 3.0f) * lllllllllllllIIIIlIlIlIIIIllIIIl;
            GlStateManager.rotate(lllllllllllllIIIIlIlIlIIIIllIIII, 0.0f, 0.0f, 1.0f);
        }
        GlStateManager.rotate(45.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(0.05625f, 0.05625f, 0.05625f);
        GlStateManager.translate(-4.0f, 0.0f, 0.0f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIIIIlIlIlIIIlIIIIll));
        }
        GlStateManager.glNormal3f(0.05625f, 0.0f, 0.0f);
        lllllllllllllIIIIlIlIlIIIIllllII.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIIIlIlIlIIIIllllII.pos(-7.0, -2.0, -2.0).tex(0.0, 0.15625).endVertex();
        lllllllllllllIIIIlIlIlIIIIllllII.pos(-7.0, -2.0, 2.0).tex(0.15625, 0.15625).endVertex();
        lllllllllllllIIIIlIlIlIIIIllllII.pos(-7.0, 2.0, 2.0).tex(0.15625, 0.3125).endVertex();
        lllllllllllllIIIIlIlIlIIIIllllII.pos(-7.0, 2.0, -2.0).tex(0.0, 0.3125).endVertex();
        lllllllllllllIIIIlIlIlIIIIllllIl.draw();
        GlStateManager.glNormal3f(-0.05625f, 0.0f, 0.0f);
        lllllllllllllIIIIlIlIlIIIIllllII.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIIIlIlIlIIIIllllII.pos(-7.0, 2.0, -2.0).tex(0.0, 0.15625).endVertex();
        lllllllllllllIIIIlIlIlIIIIllllII.pos(-7.0, 2.0, 2.0).tex(0.15625, 0.15625).endVertex();
        lllllllllllllIIIIlIlIlIIIIllllII.pos(-7.0, -2.0, 2.0).tex(0.15625, 0.3125).endVertex();
        lllllllllllllIIIIlIlIlIIIIllllII.pos(-7.0, -2.0, -2.0).tex(0.0, 0.3125).endVertex();
        lllllllllllllIIIIlIlIlIIIIllllIl.draw();
        for (int lllllllllllllIIIIlIlIlIIIIlIllll = 0; lllllllllllllIIIIlIlIlIIIIlIllll < 4; ++lllllllllllllIIIIlIlIlIIIIlIllll) {
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.glNormal3f(0.0f, 0.0f, 0.05625f);
            lllllllllllllIIIIlIlIlIIIIllllII.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllllIIIIlIlIlIIIIllllII.pos(-8.0, -2.0, 0.0).tex(0.0, 0.0).endVertex();
            lllllllllllllIIIIlIlIlIIIIllllII.pos(8.0, -2.0, 0.0).tex(0.5, 0.0).endVertex();
            lllllllllllllIIIIlIlIlIIIIllllII.pos(8.0, 2.0, 0.0).tex(0.5, 0.15625).endVertex();
            lllllllllllllIIIIlIlIlIIIIllllII.pos(-8.0, 2.0, 0.0).tex(0.0, 0.15625).endVertex();
            lllllllllllllIIIIlIlIlIIIIllllIl.draw();
        }
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllIIIIlIlIlIIIlIIIIll, lllllllllllllIIIIlIlIlIIIlIIIIlI, lllllllllllllIIIIlIlIlIIIlIIIIIl, lllllllllllllIIIIlIlIlIIIIlIlIlI, lllllllllllllIIIIlIlIlIIIIlIlIIl, lllllllllllllIIIIlIlIlIIIIlIlIII);
    }
}
