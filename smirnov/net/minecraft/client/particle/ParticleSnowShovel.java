// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;

public class ParticleSnowShovel extends Particle
{
    /* synthetic */ float snowDigParticleScale;
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllllllIIIlllIllIIIllll, final Entity llllllllllllllllIIIlllIllIIIIlII, final float llllllllllllllllIIIlllIllIIIIIll, final float llllllllllllllllIIIlllIllIIIllII, final float llllllllllllllllIIIlllIllIIIIIIl, final float llllllllllllllllIIIlllIllIIIIIII, final float llllllllllllllllIIIlllIllIIIlIIl, final float llllllllllllllllIIIlllIllIIIlIII) {
        float llllllllllllllllIIIlllIllIIIIlll = (this.particleAge + llllllllllllllllIIIlllIllIIIIIll) / this.particleMaxAge * 32.0f;
        llllllllllllllllIIIlllIllIIIIlll = MathHelper.clamp(llllllllllllllllIIIlllIllIIIIlll, 0.0f, 1.0f);
        this.particleScale = this.snowDigParticleScale * llllllllllllllllIIIlllIllIIIIlll;
        super.renderParticle(llllllllllllllllIIIlllIllIIIllll, llllllllllllllllIIIlllIllIIIIlII, llllllllllllllllIIIlllIllIIIIIll, llllllllllllllllIIIlllIllIIIllII, llllllllllllllllIIIlllIllIIIIIIl, llllllllllllllllIIIlllIllIIIIIII, llllllllllllllllIIIlllIllIIIlIIl, llllllllllllllllIIIlllIllIIIlIII);
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY -= 0.03;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9900000095367432;
        this.motionY *= 0.9900000095367432;
        this.motionZ *= 0.9900000095367432;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected ParticleSnowShovel(final World llllllllllllllllIIIlllIlllIIIlll, final double llllllllllllllllIIIlllIllIlllllI, final double llllllllllllllllIIIlllIlllIIIlIl, final double llllllllllllllllIIIlllIlllIIIlII, final double llllllllllllllllIIIlllIllIlllIll, final double llllllllllllllllIIIlllIlllIIIIlI, final double llllllllllllllllIIIlllIlllIIIIIl) {
        this(llllllllllllllllIIIlllIlllIIIlll, llllllllllllllllIIIlllIllIlllllI, llllllllllllllllIIIlllIlllIIIlIl, llllllllllllllllIIIlllIlllIIIlII, llllllllllllllllIIIlllIllIlllIll, llllllllllllllllIIIlllIlllIIIIlI, llllllllllllllllIIIlllIlllIIIIIl, 1.0f);
    }
    
    protected ParticleSnowShovel(final World llllllllllllllllIIIlllIllIlIllIl, final double llllllllllllllllIIIlllIllIlIllII, final double llllllllllllllllIIIlllIllIlIIIIl, final double llllllllllllllllIIIlllIllIlIIIII, final double llllllllllllllllIIIlllIllIlIlIIl, final double llllllllllllllllIIIlllIllIlIlIII, final double llllllllllllllllIIIlllIllIlIIlll, final float llllllllllllllllIIIlllIllIIlllII) {
        super(llllllllllllllllIIIlllIllIlIllIl, llllllllllllllllIIIlllIllIlIllII, llllllllllllllllIIIlllIllIlIIIIl, llllllllllllllllIIIlllIllIlIIIII, llllllllllllllllIIIlllIllIlIlIIl, llllllllllllllllIIIlllIllIlIlIII, llllllllllllllllIIIlllIllIlIIlll);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += llllllllllllllllIIIlllIllIlIlIIl;
        this.motionY += llllllllllllllllIIIlllIllIlIlIII;
        this.motionZ += llllllllllllllllIIIlllIllIlIIlll;
        final float llllllllllllllllIIIlllIllIlIIlIl = 1.0f - (float)(Math.random() * 0.30000001192092896);
        this.particleRed = llllllllllllllllIIIlllIllIlIIlIl;
        this.particleGreen = llllllllllllllllIIIlllIllIlIIlIl;
        this.particleBlue = llllllllllllllllIIIlllIllIlIIlIl;
        this.particleScale *= 0.75f;
        this.particleScale *= llllllllllllllllIIIlllIllIIlllII;
        this.snowDigParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)llllllllllllllllIIIlllIllIIlllII;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlIIlllIlIIIIIIIllI, final World lllllllllllllIlIIlllIlIIIIIIIlIl, final double lllllllllllllIlIIlllIIllllllllII, final double lllllllllllllIlIIlllIlIIIIIIIIll, final double lllllllllllllIlIIlllIlIIIIIIIIlI, final double lllllllllllllIlIIlllIIlllllllIIl, final double lllllllllllllIlIIlllIlIIIIIIIIII, final double lllllllllllllIlIIlllIIllllllllll, final int... lllllllllllllIlIIlllIIlllllllllI) {
            return new ParticleSnowShovel(lllllllllllllIlIIlllIlIIIIIIIlIl, lllllllllllllIlIIlllIIllllllllII, lllllllllllllIlIIlllIlIIIIIIIIll, lllllllllllllIlIIlllIlIIIIIIIIlI, lllllllllllllIlIIlllIIlllllllIIl, lllllllllllllIlIIlllIlIIIIIIIIII, lllllllllllllIlIIlllIIllllllllll);
        }
    }
}
