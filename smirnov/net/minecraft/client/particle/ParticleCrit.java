// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;

public class ParticleCrit extends Particle
{
    /* synthetic */ float oSize;
    
    protected ParticleCrit(final World lllllllllllllIlllIIlIIlIlIIlllIl, final double lllllllllllllIlllIIlIIlIlIIlIlII, final double lllllllllllllIlllIIlIIlIlIIllIll, final double lllllllllllllIlllIIlIIlIlIIlIIlI, final double lllllllllllllIlllIIlIIlIlIIllIIl, final double lllllllllllllIlllIIlIIlIlIIllIII, final double lllllllllllllIlllIIlIIlIlIIIllll) {
        this(lllllllllllllIlllIIlIIlIlIIlllIl, lllllllllllllIlllIIlIIlIlIIlIlII, lllllllllllllIlllIIlIIlIlIIllIll, lllllllllllllIlllIIlIIlIlIIlIIlI, lllllllllllllIlllIIlIIlIlIIllIIl, lllllllllllllIlllIIlIIlIlIIllIII, lllllllllllllIlllIIlIIlIlIIIllll, 1.0f);
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
        this.particleGreen *= (float)0.96;
        this.particleBlue *= (float)0.9;
        this.motionX *= 0.699999988079071;
        this.motionY *= 0.699999988079071;
        this.motionZ *= 0.699999988079071;
        this.motionY -= 0.019999999552965164;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected ParticleCrit(final World lllllllllllllIlllIIlIIlIIllllIIl, final double lllllllllllllIlllIIlIIlIIllllIII, final double lllllllllllllIlllIIlIIlIIlllIlll, final double lllllllllllllIlllIIlIIlIIlllIllI, final double lllllllllllllIlllIIlIIlIIlllllll, final double lllllllllllllIlllIIlIIlIIlllIlII, final double lllllllllllllIlllIIlIIlIIlllIIll, final float lllllllllllllIlllIIlIIlIIlllIIlI) {
        super(lllllllllllllIlllIIlIIlIIllllIIl, lllllllllllllIlllIIlIIlIIllllIII, lllllllllllllIlllIIlIIlIIlllIlll, lllllllllllllIlllIIlIIlIIlllIllI, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += lllllllllllllIlllIIlIIlIIlllllll * 0.4;
        this.motionY += lllllllllllllIlllIIlIIlIIlllIlII * 0.4;
        this.motionZ += lllllllllllllIlllIIlIIlIIlllIIll * 0.4;
        final float lllllllllllllIlllIIlIIlIIllllIll = (float)(Math.random() * 0.30000001192092896 + 0.6000000238418579);
        this.particleRed = lllllllllllllIlllIIlIIlIIllllIll;
        this.particleGreen = lllllllllllllIlllIIlIIlIIllllIll;
        this.particleBlue = lllllllllllllIlllIIlIIlIIllllIll;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllllIlllIIlIIlIIlllIIlI;
        this.oSize = this.particleScale;
        this.particleMaxAge = (int)(6.0 / (Math.random() * 0.8 + 0.6));
        this.particleMaxAge *= (int)lllllllllllllIlllIIlIIlIIlllIIlI;
        this.setParticleTextureIndex(65);
        this.onUpdate();
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIlllIIlIIlIIllIIlIl, final Entity lllllllllllllIlllIIlIIlIIlIllIlI, final float lllllllllllllIlllIIlIIlIIlIllIIl, final float lllllllllllllIlllIIlIIlIIlIllIII, final float lllllllllllllIlllIIlIIlIIllIIIIl, final float lllllllllllllIlllIIlIIlIIlIlIllI, final float lllllllllllllIlllIIlIIlIIlIlllll, final float lllllllllllllIlllIIlIIlIIlIllllI) {
        float lllllllllllllIlllIIlIIlIIlIlllIl = (this.particleAge + lllllllllllllIlllIIlIIlIIlIllIIl) / this.particleMaxAge * 32.0f;
        lllllllllllllIlllIIlIIlIIlIlllIl = MathHelper.clamp(lllllllllllllIlllIIlIIlIIlIlllIl, 0.0f, 1.0f);
        this.particleScale = this.oSize * lllllllllllllIlllIIlIIlIIlIlllIl;
        super.renderParticle(lllllllllllllIlllIIlIIlIIllIIlIl, lllllllllllllIlllIIlIIlIIlIllIlI, lllllllllllllIlllIIlIIlIIlIllIIl, lllllllllllllIlllIIlIIlIIlIllIII, lllllllllllllIlllIIlIIlIIllIIIIl, lllllllllllllIlllIIlIIlIIlIlIllI, lllllllllllllIlllIIlIIlIIlIlllll, lllllllllllllIlllIIlIIlIIlIllllI);
    }
    
    public static class DamageIndicatorFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIlIIIlIIlIlllIllll, final World lllllllllllllIIlIIIlIIlIlllIlllI, final double lllllllllllllIIlIIIlIIlIlllIIIll, final double lllllllllllllIIlIIIlIIlIlllIIIlI, final double lllllllllllllIIlIIIlIIlIlllIIIIl, final double lllllllllllllIIlIIIlIIlIlllIlIlI, final double lllllllllllllIIlIIIlIIlIlllIlIIl, final double lllllllllllllIIlIIIlIIlIllIllllI, final int... lllllllllllllIIlIIIlIIlIlllIIlll) {
            final Particle lllllllllllllIIlIIIlIIlIlllIIllI = new ParticleCrit(lllllllllllllIIlIIIlIIlIlllIlllI, lllllllllllllIIlIIIlIIlIlllIIIll, lllllllllllllIIlIIIlIIlIlllIIIlI, lllllllllllllIIlIIIlIIlIlllIIIIl, lllllllllllllIIlIIIlIIlIlllIlIlI, lllllllllllllIIlIIIlIIlIlllIlIIl + 1.0, lllllllllllllIIlIIIlIIlIllIllllI, 1.0f);
            lllllllllllllIIlIIIlIIlIlllIIllI.setMaxAge(20);
            lllllllllllllIIlIIIlIIlIlllIIllI.setParticleTextureIndex(67);
            return lllllllllllllIIlIIIlIIlIlllIIllI;
        }
    }
    
    public static class MagicFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIlIlIIllIlIIIllIIl, final World lllllllllllllIIlIlIIllIlIIIIlllI, final double lllllllllllllIIlIlIIllIlIIIlIlll, final double lllllllllllllIIlIlIIllIlIIIlIllI, final double lllllllllllllIIlIlIIllIlIIIlIlIl, final double lllllllllllllIIlIlIIllIlIIIIlIlI, final double lllllllllllllIIlIlIIllIlIIIIlIIl, final double lllllllllllllIIlIlIIllIlIIIIlIII, final int... lllllllllllllIIlIlIIllIlIIIlIIIl) {
            final Particle lllllllllllllIIlIlIIllIlIIIlIIII = new ParticleCrit(lllllllllllllIIlIlIIllIlIIIIlllI, lllllllllllllIIlIlIIllIlIIIlIlll, lllllllllllllIIlIlIIllIlIIIlIllI, lllllllllllllIIlIlIIllIlIIIlIlIl, lllllllllllllIIlIlIIllIlIIIIlIlI, lllllllllllllIIlIlIIllIlIIIIlIIl, lllllllllllllIIlIlIIllIlIIIIlIII);
            lllllllllllllIIlIlIIllIlIIIlIIII.setRBGColorF(lllllllllllllIIlIlIIllIlIIIlIIII.getRedColorF() * 0.3f, lllllllllllllIIlIlIIllIlIIIlIIII.getGreenColorF() * 0.8f, lllllllllllllIIlIlIIllIlIIIlIIII.getBlueColorF());
            lllllllllllllIIlIlIIllIlIIIlIIII.nextTextureIndexX();
            return lllllllllllllIIlIlIIllIlIIIlIIII;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIllIIIllIIIIlIIIllIl, final World llllllllllllIllIIIllIIIIlIIIIlII, final double llllllllllllIllIIIllIIIIlIIIlIll, final double llllllllllllIllIIIllIIIIlIIIIIlI, final double llllllllllllIllIIIllIIIIlIIIlIIl, final double llllllllllllIllIIIllIIIIlIIIlIII, final double llllllllllllIllIIIllIIIIIlllllll, final double llllllllllllIllIIIllIIIIlIIIIllI, final int... llllllllllllIllIIIllIIIIlIIIIlIl) {
            return new ParticleCrit(llllllllllllIllIIIllIIIIlIIIIlII, llllllllllllIllIIIllIIIIlIIIlIll, llllllllllllIllIIIllIIIIlIIIIIlI, llllllllllllIllIIIllIIIIlIIIlIIl, llllllllllllIllIIIllIIIIlIIIlIII, llllllllllllIllIIIllIIIIIlllllll, llllllllllllIllIIIllIIIIlIIIIllI);
        }
    }
}
