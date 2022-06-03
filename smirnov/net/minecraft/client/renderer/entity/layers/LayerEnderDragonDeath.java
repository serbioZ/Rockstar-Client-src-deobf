// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import java.util.Random;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.boss.EntityDragon;

public class LayerEnderDragonDeath implements LayerRenderer<EntityDragon>
{
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final EntityDragon llllllllllllllllIIlllIIIIllllIll, final float llllllllllllllllIIlllIIIIllllIlI, final float llllllllllllllllIIlllIIIIllllIIl, final float llllllllllllllllIIlllIIIIllllIII, final float llllllllllllllllIIlllIIIIlllIlll, final float llllllllllllllllIIlllIIIIlllIllI, final float llllllllllllllllIIlllIIIIlllIlIl, final float llllllllllllllllIIlllIIIIlllIlII) {
        if (llllllllllllllllIIlllIIIIllllIll.deathTicks > 0) {
            final Tessellator llllllllllllllllIIlllIIIIlllIIll = Tessellator.getInstance();
            final BufferBuilder llllllllllllllllIIlllIIIIlllIIlI = llllllllllllllllIIlllIIIIlllIIll.getBuffer();
            RenderHelper.disableStandardItemLighting();
            final float llllllllllllllllIIlllIIIIlllIIIl = (llllllllllllllllIIlllIIIIllllIll.deathTicks + llllllllllllllllIIlllIIIIllllIII) / 200.0f;
            float llllllllllllllllIIlllIIIIlllIIII = 0.0f;
            if (llllllllllllllllIIlllIIIIlllIIIl > 0.8f) {
                llllllllllllllllIIlllIIIIlllIIII = (llllllllllllllllIIlllIIIIlllIIIl - 0.8f) / 0.2f;
            }
            final Random llllllllllllllllIIlllIIIIllIllll = new Random(432L);
            GlStateManager.disableTexture2D();
            GlStateManager.shadeModel(7425);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
            GlStateManager.disableAlpha();
            GlStateManager.enableCull();
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -1.0f, -2.0f);
            for (int llllllllllllllllIIlllIIIIllIlllI = 0; llllllllllllllllIIlllIIIIllIlllI < (llllllllllllllllIIlllIIIIlllIIIl + llllllllllllllllIIlllIIIIlllIIIl * llllllllllllllllIIlllIIIIlllIIIl) / 2.0f * 60.0f; ++llllllllllllllllIIlllIIIIllIlllI) {
                GlStateManager.rotate(llllllllllllllllIIlllIIIIllIllll.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllllIIlllIIIIllIllll.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllllIIlllIIIIllIllll.nextFloat() * 360.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(llllllllllllllllIIlllIIIIllIllll.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllllIIlllIIIIllIllll.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllllIIlllIIIIllIllll.nextFloat() * 360.0f + llllllllllllllllIIlllIIIIlllIIIl * 90.0f, 0.0f, 0.0f, 1.0f);
                final float llllllllllllllllIIlllIIIIllIllIl = llllllllllllllllIIlllIIIIllIllll.nextFloat() * 20.0f + 5.0f + llllllllllllllllIIlllIIIIlllIIII * 10.0f;
                final float llllllllllllllllIIlllIIIIllIllII = llllllllllllllllIIlllIIIIllIllll.nextFloat() * 2.0f + 1.0f + llllllllllllllllIIlllIIIIlllIIII * 2.0f;
                llllllllllllllllIIlllIIIIlllIIlI.begin(6, DefaultVertexFormats.POSITION_COLOR);
                llllllllllllllllIIlllIIIIlllIIlI.pos(0.0, 0.0, 0.0).color(255, 255, 255, (int)(255.0f * (1.0f - llllllllllllllllIIlllIIIIlllIIII))).endVertex();
                llllllllllllllllIIlllIIIIlllIIlI.pos(-0.866 * llllllllllllllllIIlllIIIIllIllII, llllllllllllllllIIlllIIIIllIllIl, -0.5f * llllllllllllllllIIlllIIIIllIllII).color(255, 0, 255, 0).endVertex();
                llllllllllllllllIIlllIIIIlllIIlI.pos(0.866 * llllllllllllllllIIlllIIIIllIllII, llllllllllllllllIIlllIIIIllIllIl, -0.5f * llllllllllllllllIIlllIIIIllIllII).color(255, 0, 255, 0).endVertex();
                llllllllllllllllIIlllIIIIlllIIlI.pos(0.0, llllllllllllllllIIlllIIIIllIllIl, 1.0f * llllllllllllllllIIlllIIIIllIllII).color(255, 0, 255, 0).endVertex();
                llllllllllllllllIIlllIIIIlllIIlI.pos(-0.866 * llllllllllllllllIIlllIIIIllIllII, llllllllllllllllIIlllIIIIllIllIl, -0.5f * llllllllllllllllIIlllIIIIllIllII).color(255, 0, 255, 0).endVertex();
                llllllllllllllllIIlllIIIIlllIIll.draw();
            }
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            GlStateManager.shadeModel(7424);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableTexture2D();
            GlStateManager.enableAlpha();
            RenderHelper.enableStandardItemLighting();
        }
    }
}
