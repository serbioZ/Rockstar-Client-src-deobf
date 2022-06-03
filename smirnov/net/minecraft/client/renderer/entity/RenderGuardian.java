// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelGuardian;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityGuardian;

public class RenderGuardian extends RenderLiving<EntityGuardian>
{
    private static final /* synthetic */ ResourceLocation GUARDIAN_BEAM_TEXTURE;
    private static final /* synthetic */ ResourceLocation GUARDIAN_TEXTURE;
    
    static {
        GUARDIAN_TEXTURE = new ResourceLocation("textures/entity/guardian.png");
        GUARDIAN_BEAM_TEXTURE = new ResourceLocation("textures/entity/guardian_beam.png");
    }
    
    @Override
    public boolean shouldRender(final EntityGuardian llllllllllllIIllIIllIlIlIllIlIll, final ICamera llllllllllllIIllIIllIlIlIllIlIlI, final double llllllllllllIIllIIllIlIlIlllIIlI, final double llllllllllllIIllIIllIlIlIllIlIII, final double llllllllllllIIllIIllIlIlIllIIlll) {
        if (super.shouldRender(llllllllllllIIllIIllIlIlIllIlIll, llllllllllllIIllIIllIlIlIllIlIlI, llllllllllllIIllIIllIlIlIlllIIlI, llllllllllllIIllIIllIlIlIllIlIII, llllllllllllIIllIIllIlIlIllIIlll)) {
            return true;
        }
        if (llllllllllllIIllIIllIlIlIllIlIll.hasTargetedEntity()) {
            final EntityLivingBase llllllllllllIIllIIllIlIlIllIllll = llllllllllllIIllIIllIlIlIllIlIll.getTargetedEntity();
            if (llllllllllllIIllIIllIlIlIllIllll != null) {
                final Vec3d llllllllllllIIllIIllIlIlIllIlllI = this.getPosition(llllllllllllIIllIIllIlIlIllIllll, llllllllllllIIllIIllIlIlIllIllll.height * 0.5, 1.0f);
                final Vec3d llllllllllllIIllIIllIlIlIllIllIl = this.getPosition(llllllllllllIIllIIllIlIlIllIlIll, llllllllllllIIllIIllIlIlIllIlIll.getEyeHeight(), 1.0f);
                if (llllllllllllIIllIIllIlIlIllIlIlI.isBoundingBoxInFrustum(new AxisAlignedBB(llllllllllllIIllIIllIlIlIllIllIl.xCoord, llllllllllllIIllIIllIlIlIllIllIl.yCoord, llllllllllllIIllIIllIlIlIllIllIl.zCoord, llllllllllllIIllIIllIlIlIllIlllI.xCoord, llllllllllllIIllIIllIlIlIllIlllI.yCoord, llllllllllllIIllIIllIlIlIllIlllI.zCoord))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public void doRender(final EntityGuardian llllllllllllIIllIIllIlIIlllIlIll, final double llllllllllllIIllIIllIlIIlllIlIlI, final double llllllllllllIIllIIllIlIlIIIllIll, final double llllllllllllIIllIIllIlIlIIIllIlI, final float llllllllllllIIllIIllIlIlIIIllIIl, final float llllllllllllIIllIIllIlIlIIIllIII) {
        super.doRender(llllllllllllIIllIIllIlIIlllIlIll, llllllllllllIIllIIllIlIIlllIlIlI, llllllllllllIIllIIllIlIlIIIllIll, llllllllllllIIllIIllIlIlIIIllIlI, llllllllllllIIllIIllIlIlIIIllIIl, llllllllllllIIllIIllIlIlIIIllIII);
        final EntityLivingBase llllllllllllIIllIIllIlIlIIIlIlll = llllllllllllIIllIIllIlIIlllIlIll.getTargetedEntity();
        if (llllllllllllIIllIIllIlIlIIIlIlll != null) {
            final float llllllllllllIIllIIllIlIlIIIlIllI = llllllllllllIIllIIllIlIIlllIlIll.getAttackAnimationScale(llllllllllllIIllIIllIlIlIIIllIII);
            final Tessellator llllllllllllIIllIIllIlIlIIIlIlIl = Tessellator.getInstance();
            final BufferBuilder llllllllllllIIllIIllIlIlIIIlIlII = llllllllllllIIllIIllIlIlIIIlIlIl.getBuffer();
            this.bindTexture(RenderGuardian.GUARDIAN_BEAM_TEXTURE);
            GlStateManager.glTexParameteri(3553, 10242, 10497);
            GlStateManager.glTexParameteri(3553, 10243, 10497);
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
            final float llllllllllllIIllIIllIlIlIIIlIIll = 240.0f;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            final float llllllllllllIIllIIllIlIlIIIlIIlI = llllllllllllIIllIIllIlIIlllIlIll.world.getTotalWorldTime() + llllllllllllIIllIIllIlIlIIIllIII;
            final float llllllllllllIIllIIllIlIlIIIlIIIl = llllllllllllIIllIIllIlIlIIIlIIlI * 0.5f % 1.0f;
            final float llllllllllllIIllIIllIlIlIIIlIIII = llllllllllllIIllIIllIlIIlllIlIll.getEyeHeight();
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)llllllllllllIIllIIllIlIIlllIlIlI, (float)llllllllllllIIllIIllIlIlIIIllIll + llllllllllllIIllIIllIlIlIIIlIIII, (float)llllllllllllIIllIIllIlIlIIIllIlI);
            final Vec3d llllllllllllIIllIIllIlIlIIIIllll = this.getPosition(llllllllllllIIllIIllIlIlIIIlIlll, llllllllllllIIllIIllIlIlIIIlIlll.height * 0.5, llllllllllllIIllIIllIlIlIIIllIII);
            final Vec3d llllllllllllIIllIIllIlIlIIIIlllI = this.getPosition(llllllllllllIIllIIllIlIIlllIlIll, llllllllllllIIllIIllIlIlIIIlIIII, llllllllllllIIllIIllIlIlIIIllIII);
            Vec3d llllllllllllIIllIIllIlIlIIIIllIl = llllllllllllIIllIIllIlIlIIIIllll.subtract(llllllllllllIIllIIllIlIlIIIIlllI);
            final double llllllllllllIIllIIllIlIlIIIIllII = llllllllllllIIllIIllIlIlIIIIllIl.lengthVector() + 1.0;
            llllllllllllIIllIIllIlIlIIIIllIl = llllllllllllIIllIIllIlIlIIIIllIl.normalize();
            final float llllllllllllIIllIIllIlIlIIIIlIll = (float)Math.acos(llllllllllllIIllIIllIlIlIIIIllIl.yCoord);
            final float llllllllllllIIllIIllIlIlIIIIlIlI = (float)Math.atan2(llllllllllllIIllIIllIlIlIIIIllIl.zCoord, llllllllllllIIllIIllIlIlIIIIllIl.xCoord);
            GlStateManager.rotate((1.5707964f + -llllllllllllIIllIIllIlIlIIIIlIlI) * 57.295776f, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(llllllllllllIIllIIllIlIlIIIIlIll * 57.295776f, 1.0f, 0.0f, 0.0f);
            final int llllllllllllIIllIIllIlIlIIIIlIIl = 1;
            final double llllllllllllIIllIIllIlIlIIIIlIII = llllllllllllIIllIIllIlIlIIIlIIlI * 0.05 * -1.5;
            llllllllllllIIllIIllIlIlIIIlIlII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            final float llllllllllllIIllIIllIlIlIIIIIlll = llllllllllllIIllIIllIlIlIIIlIllI * llllllllllllIIllIIllIlIlIIIlIllI;
            final int llllllllllllIIllIIllIlIlIIIIIllI = 64 + (int)(llllllllllllIIllIIllIlIlIIIIIlll * 191.0f);
            final int llllllllllllIIllIIllIlIlIIIIIlIl = 32 + (int)(llllllllllllIIllIIllIlIlIIIIIlll * 191.0f);
            final int llllllllllllIIllIIllIlIlIIIIIlII = 128 - (int)(llllllllllllIIllIIllIlIlIIIIIlll * 64.0f);
            final double llllllllllllIIllIIllIlIlIIIIIIll = 0.2;
            final double llllllllllllIIllIIllIlIlIIIIIIlI = 0.282;
            final double llllllllllllIIllIIllIlIlIIIIIIIl = 0.0 + Math.cos(llllllllllllIIllIIllIlIlIIIIlIII + 2.356194490192345) * 0.282;
            final double llllllllllllIIllIIllIlIlIIIIIIII = 0.0 + Math.sin(llllllllllllIIllIIllIlIlIIIIlIII + 2.356194490192345) * 0.282;
            final double llllllllllllIIllIIllIlIIllllllll = 0.0 + Math.cos(llllllllllllIIllIIllIlIlIIIIlIII + 0.7853981633974483) * 0.282;
            final double llllllllllllIIllIIllIlIIlllllllI = 0.0 + Math.sin(llllllllllllIIllIIllIlIlIIIIlIII + 0.7853981633974483) * 0.282;
            final double llllllllllllIIllIIllIlIIllllllIl = 0.0 + Math.cos(llllllllllllIIllIIllIlIlIIIIlIII + 3.9269908169872414) * 0.282;
            final double llllllllllllIIllIIllIlIIllllllII = 0.0 + Math.sin(llllllllllllIIllIIllIlIlIIIIlIII + 3.9269908169872414) * 0.282;
            final double llllllllllllIIllIIllIlIIlllllIll = 0.0 + Math.cos(llllllllllllIIllIIllIlIlIIIIlIII + 5.497787143782138) * 0.282;
            final double llllllllllllIIllIIllIlIIlllllIlI = 0.0 + Math.sin(llllllllllllIIllIIllIlIlIIIIlIII + 5.497787143782138) * 0.282;
            final double llllllllllllIIllIIllIlIIlllllIIl = 0.0 + Math.cos(llllllllllllIIllIIllIlIlIIIIlIII + 3.141592653589793) * 0.2;
            final double llllllllllllIIllIIllIlIIlllllIII = 0.0 + Math.sin(llllllllllllIIllIIllIlIlIIIIlIII + 3.141592653589793) * 0.2;
            final double llllllllllllIIllIIllIlIIllllIlll = 0.0 + Math.cos(llllllllllllIIllIIllIlIlIIIIlIII + 0.0) * 0.2;
            final double llllllllllllIIllIIllIlIIllllIllI = 0.0 + Math.sin(llllllllllllIIllIIllIlIlIIIIlIII + 0.0) * 0.2;
            final double llllllllllllIIllIIllIlIIllllIlIl = 0.0 + Math.cos(llllllllllllIIllIIllIlIlIIIIlIII + 1.5707963267948966) * 0.2;
            final double llllllllllllIIllIIllIlIIllllIlII = 0.0 + Math.sin(llllllllllllIIllIIllIlIlIIIIlIII + 1.5707963267948966) * 0.2;
            final double llllllllllllIIllIIllIlIIllllIIll = 0.0 + Math.cos(llllllllllllIIllIIllIlIlIIIIlIII + 4.71238898038469) * 0.2;
            final double llllllllllllIIllIIllIlIIllllIIlI = 0.0 + Math.sin(llllllllllllIIllIIllIlIlIIIIlIII + 4.71238898038469) * 0.2;
            final double llllllllllllIIllIIllIlIIllllIIIl = 0.0;
            final double llllllllllllIIllIIllIlIIllllIIII = 0.4999;
            final double llllllllllllIIllIIllIlIIlllIllll = -1.0f + llllllllllllIIllIIllIlIlIIIlIIIl;
            final double llllllllllllIIllIIllIlIIlllIlllI = llllllllllllIIllIIllIlIlIIIIllII * 2.5 + llllllllllllIIllIIllIlIIlllIllll;
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIlllllIIl, llllllllllllIIllIIllIlIlIIIIllII, llllllllllllIIllIIllIlIIlllllIII).tex(0.4999, llllllllllllIIllIIllIlIIlllIlllI).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIlllllIIl, 0.0, llllllllllllIIllIIllIlIIlllllIII).tex(0.4999, llllllllllllIIllIIllIlIIlllIllll).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIllllIlll, 0.0, llllllllllllIIllIIllIlIIllllIllI).tex(0.0, llllllllllllIIllIIllIlIIlllIllll).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIllllIlll, llllllllllllIIllIIllIlIlIIIIllII, llllllllllllIIllIIllIlIIllllIllI).tex(0.0, llllllllllllIIllIIllIlIIlllIlllI).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIllllIlIl, llllllllllllIIllIIllIlIlIIIIllII, llllllllllllIIllIIllIlIIllllIlII).tex(0.4999, llllllllllllIIllIIllIlIIlllIlllI).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIllllIlIl, 0.0, llllllllllllIIllIIllIlIIllllIlII).tex(0.4999, llllllllllllIIllIIllIlIIlllIllll).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIllllIIll, 0.0, llllllllllllIIllIIllIlIIllllIIlI).tex(0.0, llllllllllllIIllIIllIlIIlllIllll).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIllllIIll, llllllllllllIIllIIllIlIlIIIIllII, llllllllllllIIllIIllIlIIllllIIlI).tex(0.0, llllllllllllIIllIIllIlIIlllIlllI).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            double llllllllllllIIllIIllIlIIlllIllIl = 0.0;
            if (llllllllllllIIllIIllIlIIlllIlIll.ticksExisted % 2 == 0) {
                llllllllllllIIllIIllIlIIlllIllIl = 0.5;
            }
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIlIIIIIIIl, llllllllllllIIllIIllIlIlIIIIllII, llllllllllllIIllIIllIlIlIIIIIIII).tex(0.5, llllllllllllIIllIIllIlIIlllIllIl + 0.5).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIllllllll, llllllllllllIIllIIllIlIlIIIIllII, llllllllllllIIllIIllIlIIlllllllI).tex(1.0, llllllllllllIIllIIllIlIIlllIllIl + 0.5).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIlllllIll, llllllllllllIIllIIllIlIlIIIIllII, llllllllllllIIllIIllIlIIlllllIlI).tex(1.0, llllllllllllIIllIIllIlIIlllIllIl).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlII.pos(llllllllllllIIllIIllIlIIllllllIl, llllllllllllIIllIIllIlIlIIIIllII, llllllllllllIIllIIllIlIIllllllII).tex(0.5, llllllllllllIIllIIllIlIIlllIllIl).color(llllllllllllIIllIIllIlIlIIIIIllI, llllllllllllIIllIIllIlIlIIIIIlIl, llllllllllllIIllIIllIlIlIIIIIlII, 255).endVertex();
            llllllllllllIIllIIllIlIlIIIlIlIl.draw();
            GlStateManager.popMatrix();
        }
    }
    
    public RenderGuardian(final RenderManager llllllllllllIIllIIllIlIlIlllllll) {
        super(llllllllllllIIllIIllIlIlIlllllll, new ModelGuardian(), 0.5f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityGuardian llllllllllllIIllIIllIlIIlIlllIIl) {
        return RenderGuardian.GUARDIAN_TEXTURE;
    }
    
    private Vec3d getPosition(final EntityLivingBase llllllllllllIIllIIllIlIlIlIlllII, final double llllllllllllIIllIIllIlIlIlIlIlIl, final float llllllllllllIIllIIllIlIlIlIlIlII) {
        final double llllllllllllIIllIIllIlIlIlIllIIl = llllllllllllIIllIIllIlIlIlIlllII.lastTickPosX + (llllllllllllIIllIIllIlIlIlIlllII.posX - llllllllllllIIllIIllIlIlIlIlllII.lastTickPosX) * llllllllllllIIllIIllIlIlIlIlIlII;
        final double llllllllllllIIllIIllIlIlIlIllIII = llllllllllllIIllIIllIlIlIlIlIlIl + llllllllllllIIllIIllIlIlIlIlllII.lastTickPosY + (llllllllllllIIllIIllIlIlIlIlllII.posY - llllllllllllIIllIIllIlIlIlIlllII.lastTickPosY) * llllllllllllIIllIIllIlIlIlIlIlII;
        final double llllllllllllIIllIIllIlIlIlIlIlll = llllllllllllIIllIIllIlIlIlIlllII.lastTickPosZ + (llllllllllllIIllIIllIlIlIlIlllII.posZ - llllllllllllIIllIIllIlIlIlIlllII.lastTickPosZ) * llllllllllllIIllIIllIlIlIlIlIlII;
        return new Vec3d(llllllllllllIIllIIllIlIlIlIllIIl, llllllllllllIIllIIllIlIlIlIllIII, llllllllllllIIllIIllIlIlIlIlIlll);
    }
}
