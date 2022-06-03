// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;

public class ParticleLava extends Particle
{
    private final /* synthetic */ float lavaParticleScale;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        final float llllllllllllIllIIllIIllllllIIlIl = this.particleAge / (float)this.particleMaxAge;
        if (this.rand.nextFloat() > llllllllllllIllIIllIIllllllIIlIl) {
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ, new int[0]);
        }
        this.motionY -= 0.03;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9990000128746033;
        this.motionY *= 0.9990000128746033;
        this.motionZ *= 0.9990000128746033;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected ParticleLava(final World llllllllllllIllIIllIlIIIIIIllllI, final double llllllllllllIllIIllIlIIIIIIlllIl, final double llllllllllllIllIIllIlIIIIIIlllII, final double llllllllllllIllIIllIlIIIIIIllIll) {
        super(llllllllllllIllIIllIlIIIIIIllllI, llllllllllllIllIIllIlIIIIIIlllIl, llllllllllllIllIIllIlIIIIIIlllII, llllllllllllIllIIllIlIIIIIIllIll, 0.0, 0.0, 0.0);
        this.motionX *= 0.800000011920929;
        this.motionY *= 0.800000011920929;
        this.motionZ *= 0.800000011920929;
        this.motionY = this.rand.nextFloat() * 0.4f + 0.05f;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleScale *= this.rand.nextFloat() * 2.0f + 0.2f;
        this.lavaParticleScale = this.particleScale;
        this.particleMaxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.setParticleTextureIndex(49);
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllIllIIllIIllllllllIll, final Entity llllllllllllIllIIllIIllllllllIlI, final float llllllllllllIllIIllIIllllllllIIl, final float llllllllllllIllIIllIIllllllllIII, final float llllllllllllIllIIllIIlllllllIlll, final float llllllllllllIllIIllIIllllllIllII, final float llllllllllllIllIIllIIllllllIlIll, final float llllllllllllIllIIllIIlllllllIlII) {
        final float llllllllllllIllIIllIIlllllllIIll = (this.particleAge + llllllllllllIllIIllIIllllllllIIl) / this.particleMaxAge;
        this.particleScale = this.lavaParticleScale * (1.0f - llllllllllllIllIIllIIlllllllIIll * llllllllllllIllIIllIIlllllllIIll);
        super.renderParticle(llllllllllllIllIIllIIllllllllIll, llllllllllllIllIIllIIllllllllIlI, llllllllllllIllIIllIIllllllllIIl, llllllllllllIllIIllIIllllllllIII, llllllllllllIllIIllIIlllllllIlll, llllllllllllIllIIllIIllllllIllII, llllllllllllIllIIllIIllllllIlIll, llllllllllllIllIIllIIlllllllIlII);
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllIllIIllIlIIIIIIIllll) {
        final int llllllllllllIllIIllIlIIIIIIIlllI = super.getBrightnessForRender(llllllllllllIllIIllIlIIIIIIIllll);
        final int llllllllllllIllIIllIlIIIIIIIllIl = 240;
        final int llllllllllllIllIIllIlIIIIIIIllII = llllllllllllIllIIllIlIIIIIIIlllI >> 16 & 0xFF;
        return 0xF0 | llllllllllllIllIIllIlIIIIIIIllII << 16;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIIlIIIIlIIlIIIlIIl, final World llllllllllllllIIlIIIIlIIlIIIlIII, final double llllllllllllllIIlIIIIlIIlIIIIlll, final double llllllllllllllIIlIIIIlIIIllllllI, final double llllllllllllllIIlIIIIlIIIlllllIl, final double llllllllllllllIIlIIIIlIIlIIIIlII, final double llllllllllllllIIlIIIIlIIlIIIIIll, final double llllllllllllllIIlIIIIlIIlIIIIIlI, final int... llllllllllllllIIlIIIIlIIlIIIIIIl) {
            return new ParticleLava(llllllllllllllIIlIIIIlIIlIIIlIII, llllllllllllllIIlIIIIlIIlIIIIlll, llllllllllllllIIlIIIIlIIIllllllI, llllllllllllllIIlIIIIlIIIlllllIl);
        }
    }
}
