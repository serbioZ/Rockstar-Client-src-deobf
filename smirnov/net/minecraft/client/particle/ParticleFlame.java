// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ParticleFlame extends Particle
{
    private final /* synthetic */ float flameScale;
    
    protected ParticleFlame(final World lllllllllllllIIllIIlllIlIIIIIIIl, final double lllllllllllllIIllIIlllIIlllllIII, final double lllllllllllllIIllIIlllIIllllllll, final double lllllllllllllIIllIIlllIIllllIllI, final double lllllllllllllIIllIIlllIIllllllIl, final double lllllllllllllIIllIIlllIIllllllII, final double lllllllllllllIIllIIlllIIlllllIll) {
        super(lllllllllllllIIllIIlllIlIIIIIIIl, lllllllllllllIIllIIlllIIlllllIII, lllllllllllllIIllIIlllIIllllllll, lllllllllllllIIllIIlllIIllllIllI, lllllllllllllIIllIIlllIIllllllIl, lllllllllllllIIllIIlllIIllllllII, lllllllllllllIIllIIlllIIlllllIll);
        this.motionX = this.motionX * 0.009999999776482582 + lllllllllllllIIllIIlllIIllllllIl;
        this.motionY = this.motionY * 0.009999999776482582 + lllllllllllllIIllIIlllIIllllllII;
        this.motionZ = this.motionZ * 0.009999999776482582 + lllllllllllllIIllIIlllIIlllllIll;
        this.posX += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        this.posY += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        this.posZ += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        this.flameScale = this.particleScale;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.setParticleTextureIndex(48);
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllIIllIIlllIIllIIIIIl) {
        float lllllllllllllIIllIIlllIIllIIIIII = (this.particleAge + lllllllllllllIIllIIlllIIllIIIIIl) / this.particleMaxAge;
        lllllllllllllIIllIIlllIIllIIIIII = MathHelper.clamp(lllllllllllllIIllIIlllIIllIIIIII, 0.0f, 1.0f);
        final int lllllllllllllIIllIIlllIIlIllllll = super.getBrightnessForRender(lllllllllllllIIllIIlllIIllIIIIIl);
        int lllllllllllllIIllIIlllIIlIlllllI = lllllllllllllIIllIIlllIIlIllllll & 0xFF;
        final int lllllllllllllIIllIIlllIIlIllllIl = lllllllllllllIIllIIlllIIlIllllll >> 16 & 0xFF;
        lllllllllllllIIllIIlllIIlIlllllI += (int)(lllllllllllllIIllIIlllIIllIIIIII * 15.0f * 16.0f);
        if (lllllllllllllIIllIIlllIIlIlllllI > 240) {
            lllllllllllllIIllIIlllIIlIlllllI = 240;
        }
        return lllllllllllllIIllIIlllIIlIlllllI | lllllllllllllIIllIIlllIIlIllllIl << 16;
    }
    
    @Override
    public void moveEntity(final double lllllllllllllIIllIIlllIIlllIllIl, final double lllllllllllllIIllIIlllIIlllIlIII, final double lllllllllllllIIllIIlllIIlllIlIll) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllllIIllIIlllIIlllIllIl, lllllllllllllIIllIIlllIIlllIlIII, lllllllllllllIIllIIlllIIlllIlIll));
        this.resetPositionToBB();
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIIllIIlllIIllIlIIIl, final Entity lllllllllllllIIllIIlllIIllIllIlI, final float lllllllllllllIIllIIlllIIllIIllll, final float lllllllllllllIIllIIlllIIllIIlllI, final float lllllllllllllIIllIIlllIIllIIllIl, final float lllllllllllllIIllIIlllIIllIlIllI, final float lllllllllllllIIllIIlllIIllIlIlIl, final float lllllllllllllIIllIIlllIIllIIlIlI) {
        final float lllllllllllllIIllIIlllIIllIlIIll = (this.particleAge + lllllllllllllIIllIIlllIIllIIllll) / this.particleMaxAge;
        this.particleScale = this.flameScale * (1.0f - lllllllllllllIIllIIlllIIllIlIIll * lllllllllllllIIllIIlllIIllIlIIll * 0.5f);
        super.renderParticle(lllllllllllllIIllIIlllIIllIlIIIl, lllllllllllllIIllIIlllIIllIllIlI, lllllllllllllIIllIIlllIIllIIllll, lllllllllllllIIllIIlllIIllIIlllI, lllllllllllllIIllIIlllIIllIIllIl, lllllllllllllIIllIIlllIIllIlIllI, lllllllllllllIIllIIlllIIllIlIlIl, lllllllllllllIIllIIlllIIllIIlIlI);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIIIIlllIlllllIlIlIlI, final World llllllllllllIIIIlllIlllllIlIIIIl, final double llllllllllllIIIIlllIlllllIlIlIII, final double llllllllllllIIIIlllIlllllIIlllll, final double llllllllllllIIIIlllIlllllIIllllI, final double llllllllllllIIIIlllIlllllIlIIlIl, final double llllllllllllIIIIlllIlllllIlIIlII, final double llllllllllllIIIIlllIlllllIlIIIll, final int... llllllllllllIIIIlllIlllllIlIIIlI) {
            return new ParticleFlame(llllllllllllIIIIlllIlllllIlIIIIl, llllllllllllIIIIlllIlllllIlIlIII, llllllllllllIIIIlllIlllllIIlllll, llllllllllllIIIIlllIlllllIIllllI, llllllllllllIIIIlllIlllllIlIIlIl, llllllllllllIIIIlllIlllllIlIIlII, llllllllllllIIIIlllIlllllIlIIIll);
        }
    }
}
