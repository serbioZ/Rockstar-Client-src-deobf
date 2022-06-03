// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.MathHelper;
import optifine.CustomColors;
import optifine.Config;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.item.EntityXPOrb;

public class RenderXPOrb extends Render<EntityXPOrb>
{
    private static final /* synthetic */ ResourceLocation EXPERIENCE_ORB_TEXTURES;
    
    public RenderXPOrb(final RenderManager lllllllllllllllIlIIllllIIIIIIIll) {
        super(lllllllllllllllIlIIllllIIIIIIIll);
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }
    
    @Override
    public void doRender(final EntityXPOrb lllllllllllllllIlIIlllIllllIIlII, final double lllllllllllllllIlIIlllIlllIIIllI, final double lllllllllllllllIlIIlllIlllIIIlIl, final double lllllllllllllllIlIIlllIllllIIIIl, final float lllllllllllllllIlIIlllIllllIIIII, final float lllllllllllllllIlIIlllIlllIlllll) {
        if (!this.renderOutlines) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)lllllllllllllllIlIIlllIlllIIIllI, (float)lllllllllllllllIlIIlllIlllIIIlIl, (float)lllllllllllllllIlIIlllIllllIIIIl);
            this.bindEntityTexture(lllllllllllllllIlIIlllIllllIIlII);
            RenderHelper.enableStandardItemLighting();
            final int lllllllllllllllIlIIlllIlllIllllI = lllllllllllllllIlIIlllIllllIIlII.getTextureByXP();
            final float lllllllllllllllIlIIlllIlllIlllIl = (lllllllllllllllIlIIlllIlllIllllI % 4 * 16 + 0) / 64.0f;
            final float lllllllllllllllIlIIlllIlllIlllII = (lllllllllllllllIlIIlllIlllIllllI % 4 * 16 + 16) / 64.0f;
            final float lllllllllllllllIlIIlllIlllIllIll = (lllllllllllllllIlIIlllIlllIllllI / 4 * 16 + 0) / 64.0f;
            final float lllllllllllllllIlIIlllIlllIllIlI = (lllllllllllllllIlIIlllIlllIllllI / 4 * 16 + 16) / 64.0f;
            final float lllllllllllllllIlIIlllIlllIllIIl = 1.0f;
            final float lllllllllllllllIlIIlllIlllIllIII = 0.5f;
            final float lllllllllllllllIlIIlllIlllIlIlll = 0.25f;
            final int lllllllllllllllIlIIlllIlllIlIllI = lllllllllllllllIlIIlllIllllIIlII.getBrightnessForRender();
            final int lllllllllllllllIlIIlllIlllIlIlIl = lllllllllllllllIlIIlllIlllIlIllI % 65536;
            int lllllllllllllllIlIIlllIlllIlIlII = lllllllllllllllIlIIlllIlllIlIllI / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllllIlIIlllIlllIlIlIl, (float)lllllllllllllllIlIIlllIlllIlIlII);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final float lllllllllllllllIlIIlllIlllIlIIll = 255.0f;
            float lllllllllllllllIlIIlllIlllIlIIlI = (lllllllllllllllIlIIlllIllllIIlII.xpColor + lllllllllllllllIlIIlllIlllIlllll) / 2.0f;
            if (Config.isCustomColors()) {
                lllllllllllllllIlIIlllIlllIlIIlI = CustomColors.getXpOrbTimer(lllllllllllllllIlIIlllIlllIlIIlI);
            }
            lllllllllllllllIlIIlllIlllIlIlII = (int)((MathHelper.sin(lllllllllllllllIlIIlllIlllIlIIlI + 0.0f) + 1.0f) * 0.5f * 255.0f);
            final int lllllllllllllllIlIIlllIlllIlIIIl = 255;
            final int lllllllllllllllIlIIlllIlllIlIIII = (int)((MathHelper.sin(lllllllllllllllIlIIlllIlllIlIIlI + 4.1887903f) + 1.0f) * 0.1f * 255.0f);
            GlStateManager.translate(0.0f, 0.1f, 0.0f);
            GlStateManager.rotate(180.0f - RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * -RenderManager.playerViewX, 1.0f, 0.0f, 0.0f);
            final float lllllllllllllllIlIIlllIlllIIllll = 0.3f;
            GlStateManager.scale(0.3f, 0.3f, 0.3f);
            final Tessellator lllllllllllllllIlIIlllIlllIIlllI = Tessellator.getInstance();
            final BufferBuilder lllllllllllllllIlIIlllIlllIIllIl = lllllllllllllllIlIIlllIlllIIlllI.getBuffer();
            lllllllllllllllIlIIlllIlllIIllIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
            int lllllllllllllllIlIIlllIlllIIllII = lllllllllllllllIlIIlllIlllIlIlII;
            int lllllllllllllllIlIIlllIlllIIlIll = 255;
            int lllllllllllllllIlIIlllIlllIIlIlI = lllllllllllllllIlIIlllIlllIlIIII;
            if (Config.isCustomColors()) {
                final int lllllllllllllllIlIIlllIlllIIlIIl = CustomColors.getXpOrbColor(lllllllllllllllIlIIlllIlllIlIIlI);
                if (lllllllllllllllIlIIlllIlllIIlIIl >= 0) {
                    lllllllllllllllIlIIlllIlllIIllII = (lllllllllllllllIlIIlllIlllIIlIIl >> 16 & 0xFF);
                    lllllllllllllllIlIIlllIlllIIlIll = (lllllllllllllllIlIIlllIlllIIlIIl >> 8 & 0xFF);
                    lllllllllllllllIlIIlllIlllIIlIlI = (lllllllllllllllIlIIlllIlllIIlIIl >> 0 & 0xFF);
                }
            }
            lllllllllllllllIlIIlllIlllIIllIl.pos(-0.5, -0.25, 0.0).tex(lllllllllllllllIlIIlllIlllIlllIl, lllllllllllllllIlIIlllIlllIllIlI).color(lllllllllllllllIlIIlllIlllIIllII, lllllllllllllllIlIIlllIlllIIlIll, lllllllllllllllIlIIlllIlllIIlIlI, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllllllIlIIlllIlllIIllIl.pos(0.5, -0.25, 0.0).tex(lllllllllllllllIlIIlllIlllIlllII, lllllllllllllllIlIIlllIlllIllIlI).color(lllllllllllllllIlIIlllIlllIIllII, lllllllllllllllIlIIlllIlllIIlIll, lllllllllllllllIlIIlllIlllIIlIlI, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllllllIlIIlllIlllIIllIl.pos(0.5, 0.75, 0.0).tex(lllllllllllllllIlIIlllIlllIlllII, lllllllllllllllIlIIlllIlllIllIll).color(lllllllllllllllIlIIlllIlllIIllII, lllllllllllllllIlIIlllIlllIIlIll, lllllllllllllllIlIIlllIlllIIlIlI, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllllllIlIIlllIlllIIllIl.pos(-0.5, 0.75, 0.0).tex(lllllllllllllllIlIIlllIlllIlllIl, lllllllllllllllIlIIlllIlllIllIll).color(lllllllllllllllIlIIlllIlllIIllII, lllllllllllllllIlIIlllIlllIIlIll, lllllllllllllllIlIIlllIlllIIlIlI, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllllllIlIIlllIlllIIlllI.draw();
            GlStateManager.disableBlend();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            super.doRender(lllllllllllllllIlIIlllIllllIIlII, lllllllllllllllIlIIlllIlllIIIllI, lllllllllllllllIlIIlllIlllIIIlIl, lllllllllllllllIlIIlllIllllIIIIl, lllllllllllllllIlIIlllIllllIIIII, lllllllllllllllIlIIlllIlllIlllll);
        }
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityXPOrb lllllllllllllllIlIIlllIllIlIlIlI) {
        return RenderXPOrb.EXPERIENCE_ORB_TEXTURES;
    }
    
    static {
        EXPERIENCE_ORB_TEXTURES = new ResourceLocation("textures/entity/experience_orb.png");
    }
}
