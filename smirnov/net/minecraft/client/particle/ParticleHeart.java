// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;

public class ParticleHeart extends Particle
{
    /* synthetic */ float particleScaleOverTime;
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllIlllIIIlIIIIlIllIIlIIl, final Entity llllllllllIlllIIIlIIIIlIllIIlIII, final float llllllllllIlllIIIlIIIIlIllIIIlll, final float llllllllllIlllIIIlIIIIlIlIllllII, final float llllllllllIlllIIIlIIIIlIllIIIlIl, final float llllllllllIlllIIIlIIIIlIlIlllIlI, final float llllllllllIlllIIIlIIIIlIllIIIIll, final float llllllllllIlllIIIlIIIIlIlIlllIII) {
        float llllllllllIlllIIIlIIIIlIllIIIIIl = (this.particleAge + llllllllllIlllIIIlIIIIlIllIIIlll) / this.particleMaxAge * 32.0f;
        llllllllllIlllIIIlIIIIlIllIIIIIl = MathHelper.clamp(llllllllllIlllIIIlIIIIlIllIIIIIl, 0.0f, 1.0f);
        this.particleScale = this.particleScaleOverTime * llllllllllIlllIIIlIIIIlIllIIIIIl;
        super.renderParticle(llllllllllIlllIIIlIIIIlIllIIlIIl, llllllllllIlllIIIlIIIIlIllIIlIII, llllllllllIlllIIIlIIIIlIllIIIlll, llllllllllIlllIIIlIIIIlIlIllllII, llllllllllIlllIIIlIIIIlIllIIIlIl, llllllllllIlllIIIlIIIIlIlIlllIlI, llllllllllIlllIIIlIIIIlIllIIIIll, llllllllllIlllIIIlIIIIlIlIlllIII);
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
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.8600000143051147;
        this.motionY *= 0.8600000143051147;
        this.motionZ *= 0.8600000143051147;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected ParticleHeart(final World llllllllllIlllIIIlIIIIlIllIllIIl, final double llllllllllIlllIIIlIIIIlIlllIIIIl, final double llllllllllIlllIIIlIIIIlIlllIIIII, final double llllllllllIlllIIIlIIIIlIllIlIllI, final double llllllllllIlllIIIlIIIIlIllIllllI, final double llllllllllIlllIIIlIIIIlIllIlllIl, final double llllllllllIlllIIIlIIIIlIllIlllII, final float llllllllllIlllIIIlIIIIlIllIlIlIl) {
        super(llllllllllIlllIIIlIIIIlIllIllIIl, llllllllllIlllIIIlIIIIlIlllIIIIl, llllllllllIlllIIIlIIIIlIlllIIIII, llllllllllIlllIIIlIIIIlIllIlIllI, 0.0, 0.0, 0.0);
        this.motionX *= 0.009999999776482582;
        this.motionY *= 0.009999999776482582;
        this.motionZ *= 0.009999999776482582;
        this.motionY += 0.1;
        this.particleScale *= 0.75f;
        this.particleScale *= llllllllllIlllIIIlIIIIlIllIlIlIl;
        this.particleScaleOverTime = this.particleScale;
        this.particleMaxAge = 16;
        this.setParticleTextureIndex(80);
    }
    
    protected ParticleHeart(final World llllllllllIlllIIIlIIIIlIllllIIII, final double llllllllllIlllIIIlIIIIlIlllIllll, final double llllllllllIlllIIIlIIIIlIlllIlllI, final double llllllllllIlllIIIlIIIIlIlllIllIl, final double llllllllllIlllIIIlIIIIlIllllIlII, final double llllllllllIlllIIIlIIIIlIllllIIll, final double llllllllllIlllIIIlIIIIlIlllIlIlI) {
        this(llllllllllIlllIIIlIIIIlIllllIIII, llllllllllIlllIIIlIIIIlIlllIllll, llllllllllIlllIIIlIIIIlIlllIlllI, llllllllllIlllIIIlIIIIlIlllIllIl, llllllllllIlllIIIlIIIIlIllllIlII, llllllllllIlllIIIlIIIIlIllllIIll, llllllllllIlllIIIlIIIIlIlllIlIlI, 2.0f);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIIlllIIIlIlIlIIlIlII, final World llllllllllllIIlllIIIlIlIlIIlIIll, final double llllllllllllIIlllIIIlIlIlIIIlIlI, final double llllllllllllIIlllIIIlIlIlIIIlIIl, final double llllllllllllIIlllIIIlIlIlIIlIIII, final double llllllllllllIIlllIIIlIlIlIIIIlll, final double llllllllllllIIlllIIIlIlIlIIIlllI, final double llllllllllllIIlllIIIlIlIlIIIIlIl, final int... llllllllllllIIlllIIIlIlIlIIIllII) {
            return new ParticleHeart(llllllllllllIIlllIIIlIlIlIIlIIll, llllllllllllIIlllIIIlIlIlIIIlIlI, llllllllllllIIlllIIIlIlIlIIIlIIl, llllllllllllIIlllIIIlIlIlIIlIIII, llllllllllllIIlllIIIlIlIlIIIIlll, llllllllllllIIlllIIIlIlIlIIIlllI, llllllllllllIIlllIIIlIlIlIIIIlIl);
        }
    }
    
    public static class AngryVillagerFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlIlIllIIlIIIIllIllII, final World lllllllllllIlIlIllIIlIIIIllIIIIl, final double lllllllllllIlIlIllIIlIIIIllIlIlI, final double lllllllllllIlIlIllIIlIIIIllIlIIl, final double lllllllllllIlIlIllIIlIIIIllIlIII, final double lllllllllllIlIlIllIIlIIIIlIlllIl, final double lllllllllllIlIlIllIIlIIIIlIlllII, final double lllllllllllIlIlIllIIlIIIIllIIlIl, final int... lllllllllllIlIlIllIIlIIIIllIIlII) {
            final Particle lllllllllllIlIlIllIIlIIIIllIIIll = new ParticleHeart(lllllllllllIlIlIllIIlIIIIllIIIIl, lllllllllllIlIlIllIIlIIIIllIlIlI, lllllllllllIlIlIllIIlIIIIllIlIIl + 0.5, lllllllllllIlIlIllIIlIIIIllIlIII, lllllllllllIlIlIllIIlIIIIlIlllIl, lllllllllllIlIlIllIIlIIIIlIlllII, lllllllllllIlIlIllIIlIIIIllIIlIl);
            lllllllllllIlIlIllIIlIIIIllIIIll.setParticleTextureIndex(81);
            lllllllllllIlIlIllIIlIIIIllIIIll.setRBGColorF(1.0f, 1.0f, 1.0f);
            return lllllllllllIlIlIllIIlIIIIllIIIll;
        }
    }
}
