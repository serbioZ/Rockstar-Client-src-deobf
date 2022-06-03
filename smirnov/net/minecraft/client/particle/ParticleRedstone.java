// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;

public class ParticleRedstone extends Particle
{
    /* synthetic */ float reddustParticleScale;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
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
    
    protected ParticleRedstone(final World lllllllllllllllIIllIIIIIIlllllII, final double lllllllllllllllIIllIIIIIIllllIll, final double lllllllllllllllIIllIIIIIIllllIlI, final double lllllllllllllllIIllIIIIIlIIIIIIl, final float lllllllllllllllIIllIIIIIIllllIII, final float lllllllllllllllIIllIIIIIIlllIlll, final float lllllllllllllllIIllIIIIIIlllIllI) {
        this(lllllllllllllllIIllIIIIIIlllllII, lllllllllllllllIIllIIIIIIllllIll, lllllllllllllllIIllIIIIIIllllIlI, lllllllllllllllIIllIIIIIlIIIIIIl, 1.0f, lllllllllllllllIIllIIIIIIllllIII, lllllllllllllllIIllIIIIIIlllIlll, lllllllllllllllIIllIIIIIIlllIllI);
    }
    
    protected ParticleRedstone(final World lllllllllllllllIIllIIIIIIllIIIII, final double lllllllllllllllIIllIIIIIIlIlllll, final double lllllllllllllllIIllIIIIIIlIllllI, final double lllllllllllllllIIllIIIIIIllIIlll, final float lllllllllllllllIIllIIIIIIlIlllII, float lllllllllllllllIIllIIIIIIlIllIll, final float lllllllllllllllIIllIIIIIIlIllIlI, final float lllllllllllllllIIllIIIIIIlIllIIl) {
        super(lllllllllllllllIIllIIIIIIllIIIII, lllllllllllllllIIllIIIIIIlIlllll, lllllllllllllllIIllIIIIIIlIllllI, lllllllllllllllIIllIIIIIIllIIlll, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        if (lllllllllllllllIIllIIIIIIlIllIll == 0.0f) {
            lllllllllllllllIIllIIIIIIlIllIll = 1.0f;
        }
        final float lllllllllllllllIIllIIIIIIllIIIlI = (float)Math.random() * 0.4f + 0.6f;
        this.particleRed = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * lllllllllllllllIIllIIIIIIlIllIll * lllllllllllllllIIllIIIIIIllIIIlI;
        this.particleGreen = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * lllllllllllllllIIllIIIIIIlIllIlI * lllllllllllllllIIllIIIIIIllIIIlI;
        this.particleBlue = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * lllllllllllllllIIllIIIIIIlIllIIl * lllllllllllllllIIllIIIIIIllIIIlI;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllllllIIllIIIIIIlIlllII;
        this.reddustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)lllllllllllllllIIllIIIIIIlIlllII;
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllllIIllIIIIIIlIIIIlI, final Entity lllllllllllllllIIllIIIIIIlIIlIll, final float lllllllllllllllIIllIIIIIIlIIIIII, final float lllllllllllllllIIllIIIIIIlIIlIIl, final float lllllllllllllllIIllIIIIIIlIIlIII, final float lllllllllllllllIIllIIIIIIIllllIl, final float lllllllllllllllIIllIIIIIIlIIIllI, final float lllllllllllllllIIllIIIIIIlIIIlIl) {
        float lllllllllllllllIIllIIIIIIlIIIlII = (this.particleAge + lllllllllllllllIIllIIIIIIlIIIIII) / this.particleMaxAge * 32.0f;
        lllllllllllllllIIllIIIIIIlIIIlII = MathHelper.clamp(lllllllllllllllIIllIIIIIIlIIIlII, 0.0f, 1.0f);
        this.particleScale = this.reddustParticleScale * lllllllllllllllIIllIIIIIIlIIIlII;
        super.renderParticle(lllllllllllllllIIllIIIIIIlIIIIlI, lllllllllllllllIIllIIIIIIlIIlIll, lllllllllllllllIIllIIIIIIlIIIIII, lllllllllllllllIIllIIIIIIlIIlIIl, lllllllllllllllIIllIIIIIIlIIlIII, lllllllllllllllIIllIIIIIIIllllIl, lllllllllllllllIIllIIIIIIlIIIllI, lllllllllllllllIIllIIIIIIlIIIlIl);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlIllllIIIIlllIIIlIII, final World lllllllllllIlIllllIIIIlllIIIIlll, final double lllllllllllIlIllllIIIIlllIIIIllI, final double lllllllllllIlIllllIIIIlllIIIIlIl, final double lllllllllllIlIllllIIIIlllIIIIlII, final double lllllllllllIlIllllIIIIllIllllIll, final double lllllllllllIlIllllIIIIlllIIIIIlI, final double lllllllllllIlIllllIIIIlllIIIIIIl, final int... lllllllllllIlIllllIIIIlllIIIIIII) {
            return new ParticleRedstone(lllllllllllIlIllllIIIIlllIIIIlll, lllllllllllIlIllllIIIIlllIIIIllI, lllllllllllIlIllllIIIIlllIIIIlIl, lllllllllllIlIllllIIIIlllIIIIlII, (float)lllllllllllIlIllllIIIIllIllllIll, (float)lllllllllllIlIllllIIIIlllIIIIIlI, (float)lllllllllllIlIllllIIIIlllIIIIIIl);
        }
    }
}
