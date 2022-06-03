// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ParticleDragonBreath extends Particle
{
    private final /* synthetic */ float oSize;
    private /* synthetic */ boolean hasHitGround;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        else {
            this.setParticleTextureIndex(3 * this.particleAge / this.particleMaxAge + 5);
            if (this.isCollided) {
                this.motionY = 0.0;
                this.hasHitGround = true;
            }
            if (this.hasHitGround) {
                this.motionY += 0.002;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (this.posY == this.prevPosY) {
                this.motionX *= 1.1;
                this.motionZ *= 1.1;
            }
            this.motionX *= 0.9599999785423279;
            this.motionZ *= 0.9599999785423279;
            if (this.hasHitGround) {
                this.motionY *= 0.9599999785423279;
            }
        }
    }
    
    protected ParticleDragonBreath(final World lllllllllllIIlIlIIllllllIlIIIllI, final double lllllllllllIIlIlIIllllllIIllllIl, final double lllllllllllIIlIlIIllllllIIllllII, final double lllllllllllIIlIlIIllllllIIlllIll, final double lllllllllllIIlIlIIllllllIlIIIIlI, final double lllllllllllIIlIlIIllllllIlIIIIIl, final double lllllllllllIIlIlIIllllllIlIIIIII) {
        super(lllllllllllIIlIlIIllllllIlIIIllI, lllllllllllIIlIlIIllllllIIllllIl, lllllllllllIIlIlIIllllllIIllllII, lllllllllllIIlIlIIllllllIIlllIll, lllllllllllIIlIlIIllllllIlIIIIlI, lllllllllllIIlIlIIllllllIlIIIIIl, lllllllllllIIlIlIIllllllIlIIIIII);
        this.motionX = lllllllllllIIlIlIIllllllIlIIIIlI;
        this.motionY = lllllllllllIIlIlIIllllllIlIIIIIl;
        this.motionZ = lllllllllllIIlIlIIllllllIlIIIIII;
        this.particleRed = MathHelper.nextFloat(this.rand, 0.7176471f, 0.8745098f);
        this.particleGreen = MathHelper.nextFloat(this.rand, 0.0f, 0.0f);
        this.particleBlue = MathHelper.nextFloat(this.rand, 0.8235294f, 0.9764706f);
        this.particleScale *= 0.75f;
        this.oSize = this.particleScale;
        this.particleMaxAge = (int)(20.0 / (this.rand.nextFloat() * 0.8 + 0.2));
        this.hasHitGround = false;
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllIIlIlIIllllllIIlIlIlI, final Entity lllllllllllIIlIlIIllllllIIlIIIII, final float lllllllllllIIlIlIIllllllIIlIlIII, final float lllllllllllIIlIlIIllllllIIIllllI, final float lllllllllllIIlIlIIllllllIIIlllIl, final float lllllllllllIIlIlIIllllllIIIlllII, final float lllllllllllIIlIlIIllllllIIIllIll, final float lllllllllllIIlIlIIllllllIIlIIIll) {
        this.particleScale = this.oSize * MathHelper.clamp((this.particleAge + lllllllllllIIlIlIIllllllIIlIlIII) / this.particleMaxAge * 32.0f, 0.0f, 1.0f);
        super.renderParticle(lllllllllllIIlIlIIllllllIIlIlIlI, lllllllllllIIlIlIIllllllIIlIIIII, lllllllllllIIlIlIIllllllIIlIlIII, lllllllllllIIlIlIIllllllIIIllllI, lllllllllllIIlIlIIllllllIIIlllIl, lllllllllllIIlIlIIllllllIIIlllII, lllllllllllIIlIlIIllllllIIIllIll, lllllllllllIIlIlIIllllllIIlIIIll);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllIllllIllIIlllIIlIIlIlI, final World llllllllllIllllIllIIlllIIlIIIIIl, final double llllllllllIllllIllIIlllIIlIIIIII, final double llllllllllIllllIllIIlllIIlIIIlll, final double llllllllllIllllIllIIlllIIlIIIllI, final double llllllllllIllllIllIIlllIIlIIIlIl, final double llllllllllIllllIllIIlllIIIllllII, final double llllllllllIllllIllIIlllIIIlllIll, final int... llllllllllIllllIllIIlllIIlIIIIlI) {
            return new ParticleDragonBreath(llllllllllIllllIllIIlllIIlIIIIIl, llllllllllIllllIllIIlllIIlIIIIII, llllllllllIllllIllIIlllIIlIIIlll, llllllllllIllllIllIIlllIIlIIIllI, llllllllllIllllIllIIlllIIlIIIlIl, llllllllllIllllIllIIlllIIIllllII, llllllllllIllllIllIIlllIIIlllIll);
        }
    }
}
