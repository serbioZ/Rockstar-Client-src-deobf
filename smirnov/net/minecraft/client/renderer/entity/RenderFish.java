// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHandSide;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.projectile.EntityFishHook;

public class RenderFish extends Render<EntityFishHook>
{
    private static final /* synthetic */ ResourceLocation FISH_PARTICLES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityFishHook lllllllllllIllIlIIIlllIllIlIlllI) {
        return RenderFish.FISH_PARTICLES;
    }
    
    static {
        FISH_PARTICLES = new ResourceLocation("textures/particle/particles.png");
    }
    
    public RenderFish(final RenderManager lllllllllllIllIlIIIllllIIIllIlIl) {
        super(lllllllllllIllIlIIIllllIIIllIlIl);
    }
    
    @Override
    public void doRender(final EntityFishHook lllllllllllIllIlIIIllllIIIIIIlll, final double lllllllllllIllIlIIIlllIlllIlIlll, final double lllllllllllIllIlIIIllllIIIIIIlIl, final double lllllllllllIllIlIIIllllIIIIIIlII, final float lllllllllllIllIlIIIllllIIIIIIIll, final float lllllllllllIllIlIIIllllIIIIIIIlI) {
        final EntityPlayer lllllllllllIllIlIIIllllIIIIIIIIl = lllllllllllIllIlIIIllllIIIIIIlll.func_190619_l();
        if (lllllllllllIllIlIIIllllIIIIIIIIl != null && !this.renderOutlines) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)lllllllllllIllIlIIIlllIlllIlIlll, (float)lllllllllllIllIlIIIllllIIIIIIlIl, (float)lllllllllllIllIlIIIllllIIIIIIlII);
            GlStateManager.enableRescaleNormal();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            this.bindEntityTexture(lllllllllllIllIlIIIllllIIIIIIlll);
            final Tessellator lllllllllllIllIlIIIllllIIIIIIIII = Tessellator.getInstance();
            final BufferBuilder lllllllllllIllIlIIIlllIlllllllll = lllllllllllIllIlIIIllllIIIIIIIII.getBuffer();
            final int lllllllllllIllIlIIIlllIllllllllI = 1;
            final int lllllllllllIllIlIIIlllIlllllllIl = 2;
            final float lllllllllllIllIlIIIlllIlllllllII = 0.0625f;
            final float lllllllllllIllIlIIIlllIllllllIll = 0.125f;
            final float lllllllllllIllIlIIIlllIllllllIlI = 0.125f;
            final float lllllllllllIllIlIIIlllIllllllIIl = 0.1875f;
            final float lllllllllllIllIlIIIlllIllllllIII = 1.0f;
            final float lllllllllllIllIlIIIlllIlllllIlll = 0.5f;
            final float lllllllllllIllIlIIIlllIlllllIllI = 0.5f;
            GlStateManager.rotate(180.0f - RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * -RenderManager.playerViewX, 1.0f, 0.0f, 0.0f);
            if (this.renderOutlines) {
                GlStateManager.enableColorMaterial();
                GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllIllIlIIIllllIIIIIIlll));
            }
            lllllllllllIllIlIIIlllIlllllllll.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
            lllllllllllIllIlIIIlllIlllllllll.pos(-0.5, -0.5, 0.0).tex(0.0625, 0.1875).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllIllIlIIIlllIlllllllll.pos(0.5, -0.5, 0.0).tex(0.125, 0.1875).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllIllIlIIIlllIlllllllll.pos(0.5, 0.5, 0.0).tex(0.125, 0.125).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllIllIlIIIlllIlllllllll.pos(-0.5, 0.5, 0.0).tex(0.0625, 0.125).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllIllIlIIIllllIIIIIIIII.draw();
            if (this.renderOutlines) {
                GlStateManager.disableOutlineMode();
                GlStateManager.disableColorMaterial();
            }
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            int lllllllllllIllIlIIIlllIlllllIlIl = (lllllllllllIllIlIIIllllIIIIIIIIl.getPrimaryHand() == EnumHandSide.RIGHT) ? 1 : -1;
            final ItemStack lllllllllllIllIlIIIlllIlllllIlII = lllllllllllIllIlIIIllllIIIIIIIIl.getHeldItemMainhand();
            if (lllllllllllIllIlIIIlllIlllllIlII.getItem() != Items.FISHING_ROD) {
                lllllllllllIllIlIIIlllIlllllIlIl = -lllllllllllIllIlIIIlllIlllllIlIl;
            }
            final float lllllllllllIllIlIIIlllIlllllIIll = lllllllllllIllIlIIIllllIIIIIIIIl.getSwingProgress(lllllllllllIllIlIIIllllIIIIIIIlI);
            final float lllllllllllIllIlIIIlllIlllllIIlI = MathHelper.sin(MathHelper.sqrt(lllllllllllIllIlIIIlllIlllllIIll) * 3.1415927f);
            final float lllllllllllIllIlIIIlllIlllllIIIl = (lllllllllllIllIlIIIllllIIIIIIIIl.prevRenderYawOffset + (lllllllllllIllIlIIIllllIIIIIIIIl.renderYawOffset - lllllllllllIllIlIIIllllIIIIIIIIl.prevRenderYawOffset) * lllllllllllIllIlIIIllllIIIIIIIlI) * 0.017453292f;
            final double lllllllllllIllIlIIIlllIlllllIIII = MathHelper.sin(lllllllllllIllIlIIIlllIlllllIIIl);
            final double lllllllllllIllIlIIIlllIllllIllll = MathHelper.cos(lllllllllllIllIlIIIlllIlllllIIIl);
            final double lllllllllllIllIlIIIlllIllllIlllI = lllllllllllIllIlIIIlllIlllllIlIl * 0.35;
            final double lllllllllllIllIlIIIlllIllllIllIl = 0.8;
            double lllllllllllIllIlIIIlllIllllIlIll;
            double lllllllllllIllIlIIIlllIllllIlIIl;
            double lllllllllllIllIlIIIlllIllllIIlll;
            double lllllllllllIllIlIIIlllIllllIIlIl;
            if ((this.renderManager.options == null || this.renderManager.options.thirdPersonView <= 0) && lllllllllllIllIlIIIllllIIIIIIIIl == Minecraft.getMinecraft().player) {
                float lllllllllllIllIlIIIlllIllllIIlII = this.renderManager.options.fovSetting;
                lllllllllllIllIlIIIlllIllllIIlII /= 100.0f;
                Vec3d lllllllllllIllIlIIIlllIllllIIIll = new Vec3d(lllllllllllIllIlIIIlllIlllllIlIl * -0.36 * lllllllllllIllIlIIIlllIllllIIlII, -0.045 * lllllllllllIllIlIIIlllIllllIIlII, 0.4);
                lllllllllllIllIlIIIlllIllllIIIll = lllllllllllIllIlIIIlllIllllIIIll.rotatePitch(-(lllllllllllIllIlIIIllllIIIIIIIIl.prevRotationPitch + (lllllllllllIllIlIIIllllIIIIIIIIl.rotationPitch - lllllllllllIllIlIIIllllIIIIIIIIl.prevRotationPitch) * lllllllllllIllIlIIIllllIIIIIIIlI) * 0.017453292f);
                lllllllllllIllIlIIIlllIllllIIIll = lllllllllllIllIlIIIlllIllllIIIll.rotateYaw(-(lllllllllllIllIlIIIllllIIIIIIIIl.prevRotationYaw + (lllllllllllIllIlIIIllllIIIIIIIIl.rotationYaw - lllllllllllIllIlIIIllllIIIIIIIIl.prevRotationYaw) * lllllllllllIllIlIIIllllIIIIIIIlI) * 0.017453292f);
                lllllllllllIllIlIIIlllIllllIIIll = lllllllllllIllIlIIIlllIllllIIIll.rotateYaw(lllllllllllIllIlIIIlllIlllllIIlI * 0.5f);
                lllllllllllIllIlIIIlllIllllIIIll = lllllllllllIllIlIIIlllIllllIIIll.rotatePitch(-lllllllllllIllIlIIIlllIlllllIIlI * 0.7f);
                final double lllllllllllIllIlIIIlllIllllIllII = lllllllllllIllIlIIIllllIIIIIIIIl.prevPosX + (lllllllllllIllIlIIIllllIIIIIIIIl.posX - lllllllllllIllIlIIIllllIIIIIIIIl.prevPosX) * lllllllllllIllIlIIIllllIIIIIIIlI + lllllllllllIllIlIIIlllIllllIIIll.xCoord;
                final double lllllllllllIllIlIIIlllIllllIlIlI = lllllllllllIllIlIIIllllIIIIIIIIl.prevPosY + (lllllllllllIllIlIIIllllIIIIIIIIl.posY - lllllllllllIllIlIIIllllIIIIIIIIl.prevPosY) * lllllllllllIllIlIIIllllIIIIIIIlI + lllllllllllIllIlIIIlllIllllIIIll.yCoord;
                final double lllllllllllIllIlIIIlllIllllIlIII = lllllllllllIllIlIIIllllIIIIIIIIl.prevPosZ + (lllllllllllIllIlIIIllllIIIIIIIIl.posZ - lllllllllllIllIlIIIllllIIIIIIIIl.prevPosZ) * lllllllllllIllIlIIIllllIIIIIIIlI + lllllllllllIllIlIIIlllIllllIIIll.zCoord;
                final double lllllllllllIllIlIIIlllIllllIIllI = lllllllllllIllIlIIIllllIIIIIIIIl.getEyeHeight();
            }
            else {
                lllllllllllIllIlIIIlllIllllIlIll = lllllllllllIllIlIIIllllIIIIIIIIl.prevPosX + (lllllllllllIllIlIIIllllIIIIIIIIl.posX - lllllllllllIllIlIIIllllIIIIIIIIl.prevPosX) * lllllllllllIllIlIIIllllIIIIIIIlI - lllllllllllIllIlIIIlllIllllIllll * lllllllllllIllIlIIIlllIllllIlllI - lllllllllllIllIlIIIlllIlllllIIII * 0.8;
                lllllllllllIllIlIIIlllIllllIlIIl = lllllllllllIllIlIIIllllIIIIIIIIl.prevPosY + lllllllllllIllIlIIIllllIIIIIIIIl.getEyeHeight() + (lllllllllllIllIlIIIllllIIIIIIIIl.posY - lllllllllllIllIlIIIllllIIIIIIIIl.prevPosY) * lllllllllllIllIlIIIllllIIIIIIIlI - 0.45;
                lllllllllllIllIlIIIlllIllllIIlll = lllllllllllIllIlIIIllllIIIIIIIIl.prevPosZ + (lllllllllllIllIlIIIllllIIIIIIIIl.posZ - lllllllllllIllIlIIIllllIIIIIIIIl.prevPosZ) * lllllllllllIllIlIIIllllIIIIIIIlI - lllllllllllIllIlIIIlllIlllllIIII * lllllllllllIllIlIIIlllIllllIlllI + lllllllllllIllIlIIIlllIllllIllll * 0.8;
                lllllllllllIllIlIIIlllIllllIIlIl = (lllllllllllIllIlIIIllllIIIIIIIIl.isSneaking() ? -0.1875 : 0.0);
            }
            final double lllllllllllIllIlIIIlllIllllIIIlI = lllllllllllIllIlIIIllllIIIIIIlll.prevPosX + (lllllllllllIllIlIIIllllIIIIIIlll.posX - lllllllllllIllIlIIIllllIIIIIIlll.prevPosX) * lllllllllllIllIlIIIllllIIIIIIIlI;
            final double lllllllllllIllIlIIIlllIllllIIIIl = lllllllllllIllIlIIIllllIIIIIIlll.prevPosY + (lllllllllllIllIlIIIllllIIIIIIlll.posY - lllllllllllIllIlIIIllllIIIIIIlll.prevPosY) * lllllllllllIllIlIIIllllIIIIIIIlI + 0.25;
            final double lllllllllllIllIlIIIlllIllllIIIII = lllllllllllIllIlIIIllllIIIIIIlll.prevPosZ + (lllllllllllIllIlIIIllllIIIIIIlll.posZ - lllllllllllIllIlIIIllllIIIIIIlll.prevPosZ) * lllllllllllIllIlIIIllllIIIIIIIlI;
            final double lllllllllllIllIlIIIlllIlllIlllll = (float)(lllllllllllIllIlIIIlllIllllIlIll - lllllllllllIllIlIIIlllIllllIIIlI);
            final double lllllllllllIllIlIIIlllIlllIllllI = (float)(lllllllllllIllIlIIIlllIllllIlIIl - lllllllllllIllIlIIIlllIllllIIIIl) + lllllllllllIllIlIIIlllIllllIIlIl;
            final double lllllllllllIllIlIIIlllIlllIlllIl = (float)(lllllllllllIllIlIIIlllIllllIIlll - lllllllllllIllIlIIIlllIllllIIIII);
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            lllllllllllIllIlIIIlllIlllllllll.begin(3, DefaultVertexFormats.POSITION_COLOR);
            final int lllllllllllIllIlIIIlllIlllIlllII = 16;
            for (int lllllllllllIllIlIIIlllIlllIllIll = 0; lllllllllllIllIlIIIlllIlllIllIll <= 16; ++lllllllllllIllIlIIIlllIlllIllIll) {
                final float lllllllllllIllIlIIIlllIlllIllIlI = lllllllllllIllIlIIIlllIlllIllIll / 16.0f;
                lllllllllllIllIlIIIlllIlllllllll.pos(lllllllllllIllIlIIIlllIlllIlIlll + lllllllllllIllIlIIIlllIlllIlllll * lllllllllllIllIlIIIlllIlllIllIlI, lllllllllllIllIlIIIllllIIIIIIlIl + lllllllllllIllIlIIIlllIlllIllllI * (lllllllllllIllIlIIIlllIlllIllIlI * lllllllllllIllIlIIIlllIlllIllIlI + lllllllllllIllIlIIIlllIlllIllIlI) * 0.5 + 0.25, lllllllllllIllIlIIIllllIIIIIIlII + lllllllllllIllIlIIIlllIlllIlllIl * lllllllllllIllIlIIIlllIlllIllIlI).color(0, 0, 0, 255).endVertex();
            }
            lllllllllllIllIlIIIllllIIIIIIIII.draw();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            super.doRender(lllllllllllIllIlIIIllllIIIIIIlll, lllllllllllIllIlIIIlllIlllIlIlll, lllllllllllIllIlIIIllllIIIIIIlIl, lllllllllllIllIlIIIllllIIIIIIlII, lllllllllllIllIlIIIllllIIIIIIIll, lllllllllllIllIlIIIllllIIIIIIIlI);
        }
    }
}
