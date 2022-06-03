// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;

public class ParticleSmokeNormal extends Particle
{
    /* synthetic */ float smokeParticleScale;
    
    protected ParticleSmokeNormal(final World lllllllllllllIlllllllllIIIIlIllI, final double lllllllllllllIlllllllllIIIIIlIll, final double lllllllllllllIlllllllllIIIIIlIlI, final double lllllllllllllIlllllllllIIIIlIIll, final double lllllllllllllIlllllllllIIIIIlIII, final double lllllllllllllIlllllllllIIIIIIlll, final double lllllllllllllIlllllllllIIIIlIIII, final float lllllllllllllIlllllllllIIIIIIlIl) {
        super(lllllllllllllIlllllllllIIIIlIllI, lllllllllllllIlllllllllIIIIIlIll, lllllllllllllIlllllllllIIIIIlIlI, lllllllllllllIlllllllllIIIIlIIll, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += lllllllllllllIlllllllllIIIIIlIII;
        this.motionY += lllllllllllllIlllllllllIIIIIIlll;
        this.motionZ += lllllllllllllIlllllllllIIIIlIIII;
        final float lllllllllllllIlllllllllIIIIIlllI = (float)(Math.random() * 0.30000001192092896);
        this.particleRed = lllllllllllllIlllllllllIIIIIlllI;
        this.particleGreen = lllllllllllllIlllllllllIIIIIlllI;
        this.particleBlue = lllllllllllllIlllllllllIIIIIlllI;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllllIlllllllllIIIIIIlIl;
        this.smokeParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)lllllllllllllIlllllllllIIIIIIlIl;
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
        this.motionY += 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    private ParticleSmokeNormal(final World lllllllllllllIlllllllllIIIllIIII, final double lllllllllllllIlllllllllIIIlIllll, final double lllllllllllllIlllllllllIIIlIIllI, final double lllllllllllllIlllllllllIIIlIIlIl, final double lllllllllllllIlllllllllIIIlIIlII, final double lllllllllllllIlllllllllIIIlIlIll, final double lllllllllllllIlllllllllIIIlIIIlI) {
        this(lllllllllllllIlllllllllIIIllIIII, lllllllllllllIlllllllllIIIlIllll, lllllllllllllIlllllllllIIIlIIllI, lllllllllllllIlllllllllIIIlIIlIl, lllllllllllllIlllllllllIIIlIIlII, lllllllllllllIlllllllllIIIlIlIll, lllllllllllllIlllllllllIIIlIIIlI, 1.0f);
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIllllllllIllllIlllI, final Entity lllllllllllllIllllllllIllllIllIl, final float lllllllllllllIllllllllIlllllIllI, final float lllllllllllllIllllllllIllllIlIll, final float lllllllllllllIllllllllIlllllIlII, final float lllllllllllllIllllllllIllllIlIIl, final float lllllllllllllIllllllllIlllllIIlI, final float lllllllllllllIllllllllIllllIIlll) {
        float lllllllllllllIllllllllIlllllIIII = (this.particleAge + lllllllllllllIllllllllIlllllIllI) / this.particleMaxAge * 32.0f;
        lllllllllllllIllllllllIlllllIIII = MathHelper.clamp(lllllllllllllIllllllllIlllllIIII, 0.0f, 1.0f);
        this.particleScale = this.smokeParticleScale * lllllllllllllIllllllllIlllllIIII;
        super.renderParticle(lllllllllllllIllllllllIllllIlllI, lllllllllllllIllllllllIllllIllIl, lllllllllllllIllllllllIlllllIllI, lllllllllllllIllllllllIllllIlIll, lllllllllllllIllllllllIlllllIlII, lllllllllllllIllllllllIllllIlIIl, lllllllllllllIllllllllIlllllIIlI, lllllllllllllIllllllllIllllIIlll);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIlllllllllllIIlIII, final World lllllllllllllIIlllllllllllIIIlll, final double lllllllllllllIIlllllllllllIIIllI, final double lllllllllllllIIlllllllllllIIIlIl, final double lllllllllllllIIlllllllllllIIIlII, final double lllllllllllllIIlllllllllllIIIIll, final double lllllllllllllIIllllllllllIlllIlI, final double lllllllllllllIIlllllllllllIIIIIl, final int... lllllllllllllIIlllllllllllIIIIII) {
            return new ParticleSmokeNormal(lllllllllllllIIlllllllllllIIIlll, lllllllllllllIIlllllllllllIIIllI, lllllllllllllIIlllllllllllIIIlIl, lllllllllllllIIlllllllllllIIIlII, lllllllllllllIIlllllllllllIIIIll, lllllllllllllIIllllllllllIlllIlI, lllllllllllllIIlllllllllllIIIIIl, null);
        }
    }
}
