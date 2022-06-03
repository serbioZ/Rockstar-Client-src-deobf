// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.EntityLivingBase;

public class ParticleMobAppearance extends Particle
{
    private /* synthetic */ EntityLivingBase entity;
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.entity == null) {
            final EntityElderGuardian llllllllllllllllIlllIIIlIIIIlIIl = new EntityElderGuardian(this.worldObj);
            llllllllllllllllIlllIIIlIIIIlIIl.func_190767_di();
            this.entity = llllllllllllllllIlllIIIlIIIIlIIl;
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllllllIlllIIIIllllllIl, final Entity llllllllllllllllIlllIIIIllllllII, final float llllllllllllllllIlllIIIIlllIlllI, final float llllllllllllllllIlllIIIIlllllIlI, final float llllllllllllllllIlllIIIIlllllIIl, final float llllllllllllllllIlllIIIIlllllIII, final float llllllllllllllllIlllIIIIllllIlll, final float llllllllllllllllIlllIIIIllllIllI) {
        if (this.entity != null) {
            final RenderManager llllllllllllllllIlllIIIIllllIlIl = Minecraft.getMinecraft().getRenderManager();
            llllllllllllllllIlllIIIIllllIlIl.setRenderPosition(Particle.interpPosX, Particle.interpPosY, Particle.interpPosZ);
            final float llllllllllllllllIlllIIIIllllIlII = 0.42553192f;
            final float llllllllllllllllIlllIIIIllllIIll = (this.particleAge + llllllllllllllllIlllIIIIlllIlllI) / this.particleMaxAge;
            GlStateManager.depthMask(true);
            GlStateManager.enableBlend();
            GlStateManager.enableDepth();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            final float llllllllllllllllIlllIIIIllllIIlI = 240.0f;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
            GlStateManager.pushMatrix();
            final float llllllllllllllllIlllIIIIllllIIIl = 0.05f + 0.5f * MathHelper.sin(llllllllllllllllIlllIIIIllllIIll * 3.1415927f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllllllIlllIIIIllllIIIl);
            GlStateManager.translate(0.0f, 1.8f, 0.0f);
            GlStateManager.rotate(180.0f - llllllllllllllllIlllIIIIllllllII.rotationYaw, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(60.0f - 150.0f * llllllllllllllllIlllIIIIllllIIll - llllllllllllllllIlllIIIIllllllII.rotationPitch, 1.0f, 0.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.4f, -1.5f);
            GlStateManager.scale(0.42553192f, 0.42553192f, 0.42553192f);
            this.entity.rotationYaw = 0.0f;
            this.entity.rotationYawHead = 0.0f;
            this.entity.prevRotationYaw = 0.0f;
            this.entity.prevRotationYawHead = 0.0f;
            llllllllllllllllIlllIIIIllllIlIl.doRenderEntity(this.entity, 0.0, 0.0, 0.0, 0.0f, llllllllllllllllIlllIIIIlllIlllI, false);
            GlStateManager.popMatrix();
            GlStateManager.enableDepth();
        }
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    protected ParticleMobAppearance(final World llllllllllllllllIlllIIIlIIIlIllI, final double llllllllllllllllIlllIIIlIIIlIlIl, final double llllllllllllllllIlllIIIlIIIIllll, final double llllllllllllllllIlllIIIlIIIIlllI) {
        super(llllllllllllllllIlllIIIlIIIlIllI, llllllllllllllllIlllIIIlIIIlIlIl, llllllllllllllllIlllIIIlIIIIllll, llllllllllllllllIlllIIIlIIIIlllI, 0.0, 0.0, 0.0);
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleGravity = 0.0f;
        this.particleMaxAge = 30;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIIIIIIIllllIIIllIIIII, final World lllllllllllIIIIIIIllllIIIlIlllll, final double lllllllllllIIIIIIIllllIIIlIllllI, final double lllllllllllIIIIIIIllllIIIlIlIlIl, final double lllllllllllIIIIIIIllllIIIlIlllII, final double lllllllllllIIIIIIIllllIIIlIllIll, final double lllllllllllIIIIIIIllllIIIlIllIlI, final double lllllllllllIIIIIIIllllIIIlIllIIl, final int... lllllllllllIIIIIIIllllIIIlIllIII) {
            return new ParticleMobAppearance(lllllllllllIIIIIIIllllIIIlIlllll, lllllllllllIIIIIIIllllIIIlIllllI, lllllllllllIIIIIIIllllIIIlIlIlIl, lllllllllllIIIIIIIllllIIIlIlllII);
        }
    }
}
