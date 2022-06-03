// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleWaterWake extends Particle
{
    protected ParticleWaterWake(final World llllllllllIlllIlIlIlIIIlIIlIlllI, final double llllllllllIlllIlIlIlIIIlIIlIIlIl, final double llllllllllIlllIlIlIlIIIlIIlIIlII, final double llllllllllIlllIlIlIlIIIlIIlIIIll, final double llllllllllIlllIlIlIlIIIlIIlIIIlI, final double llllllllllIlllIlIlIlIIIlIIlIlIIl, final double llllllllllIlllIlIlIlIIIlIIlIIIII) {
        super(llllllllllIlllIlIlIlIIIlIIlIlllI, llllllllllIlllIlIlIlIIIlIIlIIlIl, llllllllllIlllIlIlIlIIIlIIlIIlII, llllllllllIlllIlIlIlIIIlIIlIIIll, 0.0, 0.0, 0.0);
        this.motionX *= 0.30000001192092896;
        this.motionY = Math.random() * 0.20000000298023224 + 0.10000000149011612;
        this.motionZ *= 0.30000001192092896;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(19);
        this.setSize(0.01f, 0.01f);
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleGravity = 0.0f;
        this.motionX = llllllllllIlllIlIlIlIIIlIIlIIIlI;
        this.motionY = llllllllllIlllIlIlIlIIIlIIlIlIIl;
        this.motionZ = llllllllllIlllIlIlIlIIIlIIlIIIII;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        final int llllllllllIlllIlIlIlIIIlIIIllIll = 60 - this.particleMaxAge;
        final float llllllllllIlllIlIlIlIIIlIIIllIlI = llllllllllIlllIlIlIlIIIlIIIllIll * 0.001f;
        this.setSize(llllllllllIlllIlIlIlIIIlIIIllIlI, llllllllllIlllIlIlIlIIIlIIIllIlI);
        this.setParticleTextureIndex(19 + llllllllllIlllIlIlIlIIIlIIIllIll % 4);
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlIlIlIlIIIIIllllIIlI, final World lllllllllllIlIlIlIlIIIIIlllIlIIl, final double lllllllllllIlIlIlIlIIIIIllllIIII, final double lllllllllllIlIlIlIlIIIIIlllIIlll, final double lllllllllllIlIlIlIlIIIIIlllIIllI, final double lllllllllllIlIlIlIlIIIIIlllIIlIl, final double lllllllllllIlIlIlIlIIIIIlllIIlII, final double lllllllllllIlIlIlIlIIIIIlllIIIll, final int... lllllllllllIlIlIlIlIIIIIlllIlIlI) {
            return new ParticleWaterWake(lllllllllllIlIlIlIlIIIIIlllIlIIl, lllllllllllIlIlIlIlIIIIIllllIIII, lllllllllllIlIlIlIlIIIIIlllIIlll, lllllllllllIlIlIlIlIIIIIlllIIllI, lllllllllllIlIlIlIlIIIIIlllIIlIl, lllllllllllIlIlIlIlIIIIIlllIIlII, lllllllllllIlIlIlIlIIIIIlllIIIll);
        }
    }
}
