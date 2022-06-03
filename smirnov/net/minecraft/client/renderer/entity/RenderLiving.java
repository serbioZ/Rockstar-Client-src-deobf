// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityHanging;
import net.minecraft.client.renderer.Tessellator;
import shadersmod.client.Shaders;
import optifine.Config;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public abstract class RenderLiving<T extends EntityLiving> extends RenderLivingBase<T>
{
    private double interpolateValue(final double lllllllllllIIllIIIIlllIlllIIlllI, final double lllllllllllIIllIIIIlllIlllIIllIl, final double lllllllllllIIllIIIIlllIlllIIllll) {
        return lllllllllllIIllIIIIlllIlllIIlllI + (lllllllllllIIllIIIIlllIlllIIllIl - lllllllllllIIllIIIIlllIlllIIlllI) * lllllllllllIIllIIIIlllIlllIIllll;
    }
    
    @Override
    public boolean shouldRender(final T lllllllllllIIllIIIIlllIlllllllIl, final ICamera lllllllllllIIllIIIIlllIlllllllII, final double lllllllllllIIllIIIIlllIllllllIll, final double lllllllllllIIllIIIIlllIllllllIlI, final double lllllllllllIIllIIIIllllIIIIIIIII) {
        if (super.shouldRender(lllllllllllIIllIIIIlllIlllllllIl, lllllllllllIIllIIIIlllIlllllllII, lllllllllllIIllIIIIlllIllllllIll, lllllllllllIIllIIIIlllIllllllIlI, lllllllllllIIllIIIIllllIIIIIIIII)) {
            return true;
        }
        if (lllllllllllIIllIIIIlllIlllllllIl.getLeashed() && lllllllllllIIllIIIIlllIlllllllIl.getLeashedToEntity() != null) {
            final Entity lllllllllllIIllIIIIlllIlllllllll = lllllllllllIIllIIIIlllIlllllllIl.getLeashedToEntity();
            return lllllllllllIIllIIIIlllIlllllllII.isBoundingBoxInFrustum(lllllllllllIIllIIIIlllIlllllllll.getRenderBoundingBox());
        }
        return false;
    }
    
    protected void renderLeash(final T lllllllllllIIllIIIIlllIllIlIlIlI, double lllllllllllIIllIIIIlllIllIIIIIll, double lllllllllllIIllIIIIlllIllIIIIIlI, double lllllllllllIIllIIIIlllIllIIIIIIl, final float lllllllllllIIllIIIIlllIllIlIIllI, final float lllllllllllIIllIIIIlllIllIlIIlIl) {
        if (!Config.isShaders() || !Shaders.isShadowPass) {
            final Entity lllllllllllIIllIIIIlllIllIlIIlII = lllllllllllIIllIIIIlllIllIlIlIlI.getLeashedToEntity();
            if (lllllllllllIIllIIIIlllIllIlIIlII != null) {
                lllllllllllIIllIIIIlllIllIIIIIlI -= (short)((1.6 - lllllllllllIIllIIIIlllIllIlIlIlI.height) * 0.5);
                final Tessellator lllllllllllIIllIIIIlllIllIlIIIll = Tessellator.getInstance();
                final BufferBuilder lllllllllllIIllIIIIlllIllIlIIIlI = lllllllllllIIllIIIIlllIllIlIIIll.getBuffer();
                final double lllllllllllIIllIIIIlllIllIlIIIIl = this.interpolateValue(lllllllllllIIllIIIIlllIllIlIIlII.prevRotationYaw, lllllllllllIIllIIIIlllIllIlIIlII.rotationYaw, lllllllllllIIllIIIIlllIllIlIIlIl * 0.5f) * 0.01745329238474369;
                final double lllllllllllIIllIIIIlllIllIlIIIII = this.interpolateValue(lllllllllllIIllIIIIlllIllIlIIlII.prevRotationPitch, lllllllllllIIllIIIIlllIllIlIIlII.rotationPitch, lllllllllllIIllIIIIlllIllIlIIlIl * 0.5f) * 0.01745329238474369;
                double lllllllllllIIllIIIIlllIllIIlllll = Math.cos(lllllllllllIIllIIIIlllIllIlIIIIl);
                double lllllllllllIIllIIIIlllIllIIllllI = Math.sin(lllllllllllIIllIIIIlllIllIlIIIIl);
                double lllllllllllIIllIIIIlllIllIIlllIl = Math.sin(lllllllllllIIllIIIIlllIllIlIIIII);
                if (lllllllllllIIllIIIIlllIllIlIIlII instanceof EntityHanging) {
                    lllllllllllIIllIIIIlllIllIIlllll = 0.0;
                    lllllllllllIIllIIIIlllIllIIllllI = 0.0;
                    lllllllllllIIllIIIIlllIllIIlllIl = -1.0;
                }
                final double lllllllllllIIllIIIIlllIllIIlllII = Math.cos(lllllllllllIIllIIIIlllIllIlIIIII);
                final double lllllllllllIIllIIIIlllIllIIllIll = this.interpolateValue(lllllllllllIIllIIIIlllIllIlIIlII.prevPosX, lllllllllllIIllIIIIlllIllIlIIlII.posX, lllllllllllIIllIIIIlllIllIlIIlIl) - lllllllllllIIllIIIIlllIllIIlllll * 0.7 - lllllllllllIIllIIIIlllIllIIllllI * 0.5 * lllllllllllIIllIIIIlllIllIIlllII;
                final double lllllllllllIIllIIIIlllIllIIllIlI = this.interpolateValue(lllllllllllIIllIIIIlllIllIlIIlII.prevPosY + lllllllllllIIllIIIIlllIllIlIIlII.getEyeHeight() * 0.7, lllllllllllIIllIIIIlllIllIlIIlII.posY + lllllllllllIIllIIIIlllIllIlIIlII.getEyeHeight() * 0.7, lllllllllllIIllIIIIlllIllIlIIlIl) - lllllllllllIIllIIIIlllIllIIlllIl * 0.5 - 0.25;
                final double lllllllllllIIllIIIIlllIllIIllIIl = this.interpolateValue(lllllllllllIIllIIIIlllIllIlIIlII.prevPosZ, lllllllllllIIllIIIIlllIllIlIIlII.posZ, lllllllllllIIllIIIIlllIllIlIIlIl) - lllllllllllIIllIIIIlllIllIIllllI * 0.7 + lllllllllllIIllIIIIlllIllIIlllll * 0.5 * lllllllllllIIllIIIIlllIllIIlllII;
                final double lllllllllllIIllIIIIlllIllIIllIII = this.interpolateValue(lllllllllllIIllIIIIlllIllIlIlIlI.prevRenderYawOffset, lllllllllllIIllIIIIlllIllIlIlIlI.renderYawOffset, lllllllllllIIllIIIIlllIllIlIIlIl) * 0.01745329238474369 + 1.5707963267948966;
                lllllllllllIIllIIIIlllIllIIlllll = Math.cos(lllllllllllIIllIIIIlllIllIIllIII) * lllllllllllIIllIIIIlllIllIlIlIlI.width * 0.4;
                lllllllllllIIllIIIIlllIllIIllllI = Math.sin(lllllllllllIIllIIIIlllIllIIllIII) * lllllllllllIIllIIIIlllIllIlIlIlI.width * 0.4;
                final double lllllllllllIIllIIIIlllIllIIlIlll = this.interpolateValue(lllllllllllIIllIIIIlllIllIlIlIlI.prevPosX, lllllllllllIIllIIIIlllIllIlIlIlI.posX, lllllllllllIIllIIIIlllIllIlIIlIl) + lllllllllllIIllIIIIlllIllIIlllll;
                final double lllllllllllIIllIIIIlllIllIIlIllI = this.interpolateValue(lllllllllllIIllIIIIlllIllIlIlIlI.prevPosY, lllllllllllIIllIIIIlllIllIlIlIlI.posY, lllllllllllIIllIIIIlllIllIlIIlIl);
                final double lllllllllllIIllIIIIlllIllIIlIlIl = this.interpolateValue(lllllllllllIIllIIIIlllIllIlIlIlI.prevPosZ, lllllllllllIIllIIIIlllIllIlIlIlI.posZ, lllllllllllIIllIIIIlllIllIlIIlIl) + lllllllllllIIllIIIIlllIllIIllllI;
                lllllllllllIIllIIIIlllIllIIIIIll += (int)lllllllllllIIllIIIIlllIllIIlllll;
                lllllllllllIIllIIIIlllIllIIIIIIl += (String)lllllllllllIIllIIIIlllIllIIllllI;
                final double lllllllllllIIllIIIIlllIllIIlIlII = (float)(lllllllllllIIllIIIIlllIllIIllIll - lllllllllllIIllIIIIlllIllIIlIlll);
                final double lllllllllllIIllIIIIlllIllIIlIIll = (float)(lllllllllllIIllIIIIlllIllIIllIlI - lllllllllllIIllIIIIlllIllIIlIllI);
                final double lllllllllllIIllIIIIlllIllIIlIIlI = (float)(lllllllllllIIllIIIIlllIllIIllIIl - lllllllllllIIllIIIIlllIllIIlIlIl);
                GlStateManager.disableTexture2D();
                GlStateManager.disableLighting();
                GlStateManager.disableCull();
                if (Config.isShaders()) {
                    Shaders.beginLeash();
                }
                final int lllllllllllIIllIIIIlllIllIIlIIIl = 24;
                final double lllllllllllIIllIIIIlllIllIIlIIII = 0.025;
                lllllllllllIIllIIIIlllIllIlIIIlI.begin(5, DefaultVertexFormats.POSITION_COLOR);
                for (int lllllllllllIIllIIIIlllIllIIIllll = 0; lllllllllllIIllIIIIlllIllIIIllll <= 24; ++lllllllllllIIllIIIIlllIllIIIllll) {
                    float lllllllllllIIllIIIIlllIllIIIlllI = 0.5f;
                    float lllllllllllIIllIIIIlllIllIIIllIl = 0.4f;
                    float lllllllllllIIllIIIIlllIllIIIllII = 0.3f;
                    if (lllllllllllIIllIIIIlllIllIIIllll % 2 == 0) {
                        lllllllllllIIllIIIIlllIllIIIlllI *= 0.7f;
                        lllllllllllIIllIIIIlllIllIIIllIl *= 0.7f;
                        lllllllllllIIllIIIIlllIllIIIllII *= 0.7f;
                    }
                    final float lllllllllllIIllIIIIlllIllIIIlIll = lllllllllllIIllIIIIlllIllIIIllll / 24.0f;
                    lllllllllllIIllIIIIlllIllIlIIIlI.pos(lllllllllllIIllIIIIlllIllIIIIIll + lllllllllllIIllIIIIlllIllIIlIlII * lllllllllllIIllIIIIlllIllIIIlIll + 0.0, lllllllllllIIllIIIIlllIllIIIIIlI + lllllllllllIIllIIIIlllIllIIlIIll * (lllllllllllIIllIIIIlllIllIIIlIll * lllllllllllIIllIIIIlllIllIIIlIll + lllllllllllIIllIIIIlllIllIIIlIll) * 0.5 + ((24.0f - lllllllllllIIllIIIIlllIllIIIllll) / 18.0f + 0.125f), (double)(lllllllllllIIllIIIIlllIllIIIIIIl + lllllllllllIIllIIIIlllIllIIlIIlI * lllllllllllIIllIIIIlllIllIIIlIll)).color(lllllllllllIIllIIIIlllIllIIIlllI, lllllllllllIIllIIIIlllIllIIIllIl, lllllllllllIIllIIIIlllIllIIIllII, 1.0f).endVertex();
                    lllllllllllIIllIIIIlllIllIlIIIlI.pos(lllllllllllIIllIIIIlllIllIIIIIll + lllllllllllIIllIIIIlllIllIIlIlII * lllllllllllIIllIIIIlllIllIIIlIll + 0.025, lllllllllllIIllIIIIlllIllIIIIIlI + lllllllllllIIllIIIIlllIllIIlIIll * (lllllllllllIIllIIIIlllIllIIIlIll * lllllllllllIIllIIIIlllIllIIIlIll + lllllllllllIIllIIIIlllIllIIIlIll) * 0.5 + ((24.0f - lllllllllllIIllIIIIlllIllIIIllll) / 18.0f + 0.125f) + 0.025, (double)(lllllllllllIIllIIIIlllIllIIIIIIl + lllllllllllIIllIIIIlllIllIIlIIlI * lllllllllllIIllIIIIlllIllIIIlIll)).color(lllllllllllIIllIIIIlllIllIIIlllI, lllllllllllIIllIIIIlllIllIIIllIl, lllllllllllIIllIIIIlllIllIIIllII, 1.0f).endVertex();
                }
                lllllllllllIIllIIIIlllIllIlIIIll.draw();
                lllllllllllIIllIIIIlllIllIlIIIlI.begin(5, DefaultVertexFormats.POSITION_COLOR);
                for (int lllllllllllIIllIIIIlllIllIIIlIlI = 0; lllllllllllIIllIIIIlllIllIIIlIlI <= 24; ++lllllllllllIIllIIIIlllIllIIIlIlI) {
                    float lllllllllllIIllIIIIlllIllIIIlIIl = 0.5f;
                    float lllllllllllIIllIIIIlllIllIIIlIII = 0.4f;
                    float lllllllllllIIllIIIIlllIllIIIIlll = 0.3f;
                    if (lllllllllllIIllIIIIlllIllIIIlIlI % 2 == 0) {
                        lllllllllllIIllIIIIlllIllIIIlIIl *= 0.7f;
                        lllllllllllIIllIIIIlllIllIIIlIII *= 0.7f;
                        lllllllllllIIllIIIIlllIllIIIIlll *= 0.7f;
                    }
                    final float lllllllllllIIllIIIIlllIllIIIIllI = lllllllllllIIllIIIIlllIllIIIlIlI / 24.0f;
                    lllllllllllIIllIIIIlllIllIlIIIlI.pos(lllllllllllIIllIIIIlllIllIIIIIll + lllllllllllIIllIIIIlllIllIIlIlII * lllllllllllIIllIIIIlllIllIIIIllI + 0.0, lllllllllllIIllIIIIlllIllIIIIIlI + lllllllllllIIllIIIIlllIllIIlIIll * (lllllllllllIIllIIIIlllIllIIIIllI * lllllllllllIIllIIIIlllIllIIIIllI + lllllllllllIIllIIIIlllIllIIIIllI) * 0.5 + ((24.0f - lllllllllllIIllIIIIlllIllIIIlIlI) / 18.0f + 0.125f) + 0.025, (double)(lllllllllllIIllIIIIlllIllIIIIIIl + lllllllllllIIllIIIIlllIllIIlIIlI * lllllllllllIIllIIIIlllIllIIIIllI)).color(lllllllllllIIllIIIIlllIllIIIlIIl, lllllllllllIIllIIIIlllIllIIIlIII, lllllllllllIIllIIIIlllIllIIIIlll, 1.0f).endVertex();
                    lllllllllllIIllIIIIlllIllIlIIIlI.pos(lllllllllllIIllIIIIlllIllIIIIIll + lllllllllllIIllIIIIlllIllIIlIlII * lllllllllllIIllIIIIlllIllIIIIllI + 0.025, lllllllllllIIllIIIIlllIllIIIIIlI + lllllllllllIIllIIIIlllIllIIlIIll * (lllllllllllIIllIIIIlllIllIIIIllI * lllllllllllIIllIIIIlllIllIIIIllI + lllllllllllIIllIIIIlllIllIIIIllI) * 0.5 + ((24.0f - lllllllllllIIllIIIIlllIllIIIlIlI) / 18.0f + 0.125f), (double)(lllllllllllIIllIIIIlllIllIIIIIIl + lllllllllllIIllIIIIlllIllIIlIIlI * lllllllllllIIllIIIIlllIllIIIIllI + 0.025)).color(lllllllllllIIllIIIIlllIllIIIlIIl, lllllllllllIIllIIIIlllIllIIIlIII, lllllllllllIIllIIIIlllIllIIIIlll, 1.0f).endVertex();
                }
                lllllllllllIIllIIIIlllIllIlIIIll.draw();
                if (Config.isShaders()) {
                    Shaders.endLeash();
                }
                GlStateManager.enableLighting();
                GlStateManager.enableTexture2D();
                GlStateManager.enableCull();
            }
        }
    }
    
    @Override
    protected boolean canRenderName(final T lllllllllllIIllIIIIllllIIIIIllll) {
        return super.canRenderName(lllllllllllIIllIIIIllllIIIIIllll) && (lllllllllllIIllIIIIllllIIIIIllll.getAlwaysRenderNameTagForRender() || (lllllllllllIIllIIIIllllIIIIIllll.hasCustomName() && lllllllllllIIllIIIIllllIIIIIllll == this.renderManager.pointedEntity));
    }
    
    public RenderLiving(final RenderManager lllllllllllIIllIIIIllllIIIIllIIl, final ModelBase lllllllllllIIllIIIIllllIIIIlIlII, final float lllllllllllIIllIIIIllllIIIIlIlll) {
        super(lllllllllllIIllIIIIllllIIIIllIIl, lllllllllllIIllIIIIllllIIIIlIlII, lllllllllllIIllIIIIllllIIIIlIlll);
    }
    
    @Override
    public void doRender(final T lllllllllllIIllIIIIlllIllllIlIII, final double lllllllllllIIllIIIIlllIllllIIlll, final double lllllllllllIIllIIIIlllIllllIllIl, final double lllllllllllIIllIIIIlllIllllIllII, final float lllllllllllIIllIIIIlllIllllIlIll, final float lllllllllllIIllIIIIlllIllllIIIll) {
        super.doRender(lllllllllllIIllIIIIlllIllllIlIII, lllllllllllIIllIIIIlllIllllIIlll, lllllllllllIIllIIIIlllIllllIllIl, lllllllllllIIllIIIIlllIllllIllII, lllllllllllIIllIIIIlllIllllIlIll, lllllllllllIIllIIIIlllIllllIIIll);
        if (!this.renderOutlines) {
            this.renderLeash(lllllllllllIIllIIIIlllIllllIlIII, lllllllllllIIllIIIIlllIllllIIlll, lllllllllllIIllIIIIlllIllllIllIl, lllllllllllIIllIIIIlllIllllIllII, lllllllllllIIllIIIIlllIllllIlIll, lllllllllllIIllIIIIlllIllllIIIll);
        }
    }
    
    public void setLightmap(final T lllllllllllIIllIIIIlllIlllIllIIl) {
        final int lllllllllllIIllIIIIlllIlllIlllII = lllllllllllIIllIIIIlllIlllIllIIl.getBrightnessForRender();
        final int lllllllllllIIllIIIIlllIlllIllIll = lllllllllllIIllIIIIlllIlllIlllII % 65536;
        final int lllllllllllIIllIIIIlllIlllIllIlI = lllllllllllIIllIIIIlllIlllIlllII / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllIIllIIIIlllIlllIllIll, (float)lllllllllllIIllIIIIlllIlllIllIlI);
    }
}
