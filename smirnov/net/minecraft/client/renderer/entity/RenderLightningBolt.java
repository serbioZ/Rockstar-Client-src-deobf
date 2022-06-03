// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import java.util.Random;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;

public class RenderLightningBolt extends Render<EntityLightningBolt>
{
    public RenderLightningBolt(final RenderManager llllllllllllIlllIIlIlIIIllllIllI) {
        super(llllllllllllIlllIIlIlIIIllllIllI);
    }
    
    @Override
    public void doRender(final EntityLightningBolt llllllllllllIlllIIlIlIIIllIlIIlI, final double llllllllllllIlllIIlIlIIIlIlIlllI, final double llllllllllllIlllIIlIlIIIlIlIllIl, final double llllllllllllIlllIIlIlIIIlIlIllII, final float llllllllllllIlllIIlIlIIIllIIlllI, final float llllllllllllIlllIIlIlIIIllIIllIl) {
        final Tessellator llllllllllllIlllIIlIlIIIllIIllII = Tessellator.getInstance();
        final BufferBuilder llllllllllllIlllIIlIlIIIllIIlIll = llllllllllllIlllIIlIlIIIllIIllII.getBuffer();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
        final double[] llllllllllllIlllIIlIlIIIllIIlIlI = new double[8];
        final double[] llllllllllllIlllIIlIlIIIllIIlIIl = new double[8];
        double llllllllllllIlllIIlIlIIIllIIlIII = 0.0;
        double llllllllllllIlllIIlIlIIIllIIIlll = 0.0;
        final Random llllllllllllIlllIIlIlIIIllIIIllI = new Random(llllllllllllIlllIIlIlIIIllIlIIlI.boltVertex);
        for (int llllllllllllIlllIIlIlIIIllIIIlIl = 7; llllllllllllIlllIIlIlIIIllIIIlIl >= 0; --llllllllllllIlllIIlIlIIIllIIIlIl) {
            llllllllllllIlllIIlIlIIIllIIlIlI[llllllllllllIlllIIlIlIIIllIIIlIl] = llllllllllllIlllIIlIlIIIllIIlIII;
            llllllllllllIlllIIlIlIIIllIIlIIl[llllllllllllIlllIIlIlIIIllIIIlIl] = llllllllllllIlllIIlIlIIIllIIIlll;
            llllllllllllIlllIIlIlIIIllIIlIII += llllllllllllIlllIIlIlIIIllIIIllI.nextInt(11) - 5;
            llllllllllllIlllIIlIlIIIllIIIlll += llllllllllllIlllIIlIlIIIllIIIllI.nextInt(11) - 5;
        }
        for (int llllllllllllIlllIIlIlIIIllIIIlII = 0; llllllllllllIlllIIlIlIIIllIIIlII < 4; ++llllllllllllIlllIIlIlIIIllIIIlII) {
            final Random llllllllllllIlllIIlIlIIIllIIIIll = new Random(llllllllllllIlllIIlIlIIIllIlIIlI.boltVertex);
            for (int llllllllllllIlllIIlIlIIIllIIIIlI = 0; llllllllllllIlllIIlIlIIIllIIIIlI < 3; ++llllllllllllIlllIIlIlIIIllIIIIlI) {
                int llllllllllllIlllIIlIlIIIllIIIIIl = 7;
                int llllllllllllIlllIIlIlIIIllIIIIII = 0;
                if (llllllllllllIlllIIlIlIIIllIIIIlI > 0) {
                    llllllllllllIlllIIlIlIIIllIIIIIl = 7 - llllllllllllIlllIIlIlIIIllIIIIlI;
                }
                if (llllllllllllIlllIIlIlIIIllIIIIlI > 0) {
                    llllllllllllIlllIIlIlIIIllIIIIII = llllllllllllIlllIIlIlIIIllIIIIIl - 2;
                }
                double llllllllllllIlllIIlIlIIIlIllllll = llllllllllllIlllIIlIlIIIllIIlIlI[llllllllllllIlllIIlIlIIIllIIIIIl] - llllllllllllIlllIIlIlIIIllIIlIII;
                double llllllllllllIlllIIlIlIIIlIlllllI = llllllllllllIlllIIlIlIIIllIIlIIl[llllllllllllIlllIIlIlIIIllIIIIIl] - llllllllllllIlllIIlIlIIIllIIIlll;
                for (int llllllllllllIlllIIlIlIIIlIllllIl = llllllllllllIlllIIlIlIIIllIIIIIl; llllllllllllIlllIIlIlIIIlIllllIl >= llllllllllllIlllIIlIlIIIllIIIIII; --llllllllllllIlllIIlIlIIIlIllllIl) {
                    final double llllllllllllIlllIIlIlIIIlIllllII = llllllllllllIlllIIlIlIIIlIllllll;
                    final double llllllllllllIlllIIlIlIIIlIlllIll = llllllllllllIlllIIlIlIIIlIlllllI;
                    if (llllllllllllIlllIIlIlIIIllIIIIlI == 0) {
                        llllllllllllIlllIIlIlIIIlIllllll += llllllllllllIlllIIlIlIIIllIIIIll.nextInt(11) - 5;
                        llllllllllllIlllIIlIlIIIlIlllllI += llllllllllllIlllIIlIlIIIllIIIIll.nextInt(11) - 5;
                    }
                    else {
                        llllllllllllIlllIIlIlIIIlIllllll += llllllllllllIlllIIlIlIIIllIIIIll.nextInt(31) - 15;
                        llllllllllllIlllIIlIlIIIlIlllllI += llllllllllllIlllIIlIlIIIllIIIIll.nextInt(31) - 15;
                    }
                    llllllllllllIlllIIlIlIIIllIIlIll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    final float llllllllllllIlllIIlIlIIIlIlllIlI = 0.5f;
                    final float llllllllllllIlllIIlIlIIIlIlllIIl = 0.45f;
                    final float llllllllllllIlllIIlIlIIIlIlllIII = 0.45f;
                    final float llllllllllllIlllIIlIlIIIlIllIlll = 0.5f;
                    double llllllllllllIlllIIlIlIIIlIllIllI = 0.1 + llllllllllllIlllIIlIlIIIllIIIlII * 0.2;
                    if (llllllllllllIlllIIlIlIIIllIIIIlI == 0) {
                        llllllllllllIlllIIlIlIIIlIllIllI *= llllllllllllIlllIIlIlIIIlIllllIl * 0.1 + 1.0;
                    }
                    double llllllllllllIlllIIlIlIIIlIllIlIl = 0.1 + llllllllllllIlllIIlIlIIIllIIIlII * 0.2;
                    if (llllllllllllIlllIIlIlIIIllIIIIlI == 0) {
                        llllllllllllIlllIIlIlIIIlIllIlIl *= (llllllllllllIlllIIlIlIIIlIllllIl - 1) * 0.1 + 1.0;
                    }
                    for (int llllllllllllIlllIIlIlIIIlIllIlII = 0; llllllllllllIlllIIlIlIIIlIllIlII < 5; ++llllllllllllIlllIIlIlIIIlIllIlII) {
                        double llllllllllllIlllIIlIlIIIlIllIIll = llllllllllllIlllIIlIlIIIlIlIlllI + 0.5 - llllllllllllIlllIIlIlIIIlIllIllI;
                        double llllllllllllIlllIIlIlIIIlIllIIlI = llllllllllllIlllIIlIlIIIlIlIllII + 0.5 - llllllllllllIlllIIlIlIIIlIllIllI;
                        if (llllllllllllIlllIIlIlIIIlIllIlII == 1 || llllllllllllIlllIIlIlIIIlIllIlII == 2) {
                            llllllllllllIlllIIlIlIIIlIllIIll += llllllllllllIlllIIlIlIIIlIllIllI * 2.0;
                        }
                        if (llllllllllllIlllIIlIlIIIlIllIlII == 2 || llllllllllllIlllIIlIlIIIlIllIlII == 3) {
                            llllllllllllIlllIIlIlIIIlIllIIlI += llllllllllllIlllIIlIlIIIlIllIllI * 2.0;
                        }
                        double llllllllllllIlllIIlIlIIIlIllIIIl = llllllllllllIlllIIlIlIIIlIlIlllI + 0.5 - llllllllllllIlllIIlIlIIIlIllIlIl;
                        double llllllllllllIlllIIlIlIIIlIllIIII = llllllllllllIlllIIlIlIIIlIlIllII + 0.5 - llllllllllllIlllIIlIlIIIlIllIlIl;
                        if (llllllllllllIlllIIlIlIIIlIllIlII == 1 || llllllllllllIlllIIlIlIIIlIllIlII == 2) {
                            llllllllllllIlllIIlIlIIIlIllIIIl += llllllllllllIlllIIlIlIIIlIllIlIl * 2.0;
                        }
                        if (llllllllllllIlllIIlIlIIIlIllIlII == 2 || llllllllllllIlllIIlIlIIIlIllIlII == 3) {
                            llllllllllllIlllIIlIlIIIlIllIIII += llllllllllllIlllIIlIlIIIlIllIlIl * 2.0;
                        }
                        llllllllllllIlllIIlIlIIIllIIlIll.pos(llllllllllllIlllIIlIlIIIlIllIIIl + llllllllllllIlllIIlIlIIIlIllllll, llllllllllllIlllIIlIlIIIlIlIllIl + llllllllllllIlllIIlIlIIIlIllllIl * 16, llllllllllllIlllIIlIlIIIlIllIIII + llllllllllllIlllIIlIlIIIlIlllllI).color(0.45f, 0.45f, 0.5f, 0.3f).endVertex();
                        llllllllllllIlllIIlIlIIIllIIlIll.pos(llllllllllllIlllIIlIlIIIlIllIIll + llllllllllllIlllIIlIlIIIlIllllII, llllllllllllIlllIIlIlIIIlIlIllIl + (llllllllllllIlllIIlIlIIIlIllllIl + 1) * 16, llllllllllllIlllIIlIlIIIlIllIIlI + llllllllllllIlllIIlIlIIIlIlllIll).color(0.45f, 0.45f, 0.5f, 0.3f).endVertex();
                    }
                    llllllllllllIlllIIlIlIIIllIIllII.draw();
                }
            }
        }
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
    }
    
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(final EntityLightningBolt llllllllllllIlllIIlIlIIIlIIIlllI) {
        return null;
    }
}
