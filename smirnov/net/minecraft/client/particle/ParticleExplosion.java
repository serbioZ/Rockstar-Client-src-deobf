// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleExplosion extends Particle
{
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY += 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.8999999761581421;
        this.motionY *= 0.8999999761581421;
        this.motionZ *= 0.8999999761581421;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected ParticleExplosion(final World lllllllllllIIllllllIlIIIIllllllI, final double lllllllllllIIllllllIlIIIIlllllIl, final double lllllllllllIIllllllIlIIIIlllIIll, final double lllllllllllIIllllllIlIIIIlllIIlI, final double lllllllllllIIllllllIlIIIIlllIIIl, final double lllllllllllIIllllllIlIIIIllllIIl, final double lllllllllllIIllllllIlIIIIllIllll) {
        super(lllllllllllIIllllllIlIIIIllllllI, lllllllllllIIllllllIlIIIIlllllIl, lllllllllllIIllllllIlIIIIlllIIll, lllllllllllIIllllllIlIIIIlllIIlI, lllllllllllIIllllllIlIIIIlllIIIl, lllllllllllIIllllllIlIIIIllllIIl, lllllllllllIIllllllIlIIIIllIllll);
        this.motionX = lllllllllllIIllllllIlIIIIlllIIIl + (Math.random() * 2.0 - 1.0) * 0.05000000074505806;
        this.motionY = lllllllllllIIllllllIlIIIIllllIIl + (Math.random() * 2.0 - 1.0) * 0.05000000074505806;
        this.motionZ = lllllllllllIIllllllIlIIIIllIllll + (Math.random() * 2.0 - 1.0) * 0.05000000074505806;
        final float lllllllllllIIllllllIlIIIIlllIlll = this.rand.nextFloat() * 0.3f + 0.7f;
        this.particleRed = lllllllllllIIllllllIlIIIIlllIlll;
        this.particleGreen = lllllllllllIIllllllIlIIIIlllIlll;
        this.particleBlue = lllllllllllIIllllllIlIIIIlllIlll;
        this.particleScale = this.rand.nextFloat() * this.rand.nextFloat() * 6.0f + 1.0f;
        this.particleMaxAge = (int)(16.0 / (this.rand.nextFloat() * 0.8 + 0.2)) + 2;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIIlIIllIllIlIIlIII, final World llllllllllllllIIlIIllIllIIllllll, final double llllllllllllllIIlIIllIllIlIIIllI, final double llllllllllllllIIlIIllIllIIllllIl, final double llllllllllllllIIlIIllIllIlIIIlII, final double llllllllllllllIIlIIllIllIlIIIIll, final double llllllllllllllIIlIIllIllIlIIIIlI, final double llllllllllllllIIlIIllIllIlIIIIIl, final int... llllllllllllllIIlIIllIllIlIIIIII) {
            return new ParticleExplosion(llllllllllllllIIlIIllIllIIllllll, llllllllllllllIIlIIllIllIlIIIllI, llllllllllllllIIlIIllIllIIllllIl, llllllllllllllIIlIIllIllIlIIIlII, llllllllllllllIIlIIllIllIlIIIIll, llllllllllllllIIlIIllIllIlIIIIlI, llllllllllllllIIlIIllIllIlIIIIIl);
        }
    }
}
