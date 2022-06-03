// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleSuspendedTown extends Particle
{
    protected ParticleSuspendedTown(final World lllllllllllIIlIIIllllllIIllIIIll, final double lllllllllllIIlIIIllllllIIllIlIll, final double lllllllllllIIlIIIllllllIIllIlIlI, final double lllllllllllIIlIIIllllllIIllIIIII, final double lllllllllllIIlIIIllllllIIllIlIII, final double lllllllllllIIlIIIllllllIIllIIlll, final double lllllllllllIIlIIIllllllIIlIlllIl) {
        super(lllllllllllIIlIIIllllllIIllIIIll, lllllllllllIIlIIIllllllIIllIlIll, lllllllllllIIlIIIllllllIIllIlIlI, lllllllllllIIlIIIllllllIIllIIIII, lllllllllllIIlIIIllllllIIllIlIII, lllllllllllIIlIIIllllllIIllIIlll, lllllllllllIIlIIIllllllIIlIlllIl);
        final float lllllllllllIIlIIIllllllIIllIIlIl = this.rand.nextFloat() * 0.1f + 0.2f;
        this.particleRed = lllllllllllIIlIIIllllllIIllIIlIl;
        this.particleGreen = lllllllllllIIlIIIllllllIIllIIlIl;
        this.particleBlue = lllllllllllIIlIIIllllllIIllIIlIl;
        this.setParticleTextureIndex(0);
        this.setSize(0.02f, 0.02f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.5f;
        this.motionX *= 0.019999999552965164;
        this.motionY *= 0.019999999552965164;
        this.motionZ *= 0.019999999552965164;
        this.particleMaxAge = (int)(20.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.99;
        this.motionY *= 0.99;
        this.motionZ *= 0.99;
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
    }
    
    @Override
    public void moveEntity(final double lllllllllllIIlIIIllllllIIlIlIllI, final double lllllllllllIIlIIIllllllIIlIlIIIl, final double lllllllllllIIlIIIllllllIIlIlIIII) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllIIlIIIllllllIIlIlIllI, lllllllllllIIlIIIllllllIIlIlIIIl, lllllllllllIIlIIIllllllIIlIlIIII));
        this.resetPositionToBB();
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlllIllIIIIlIIlIlII, final World lllllllllllllIlllIllIIIIlIIlIIll, final double lllllllllllllIlllIllIIIIlIIIlIlI, final double lllllllllllllIlllIllIIIIlIIlIIIl, final double lllllllllllllIlllIllIIIIlIIlIIII, final double lllllllllllllIlllIllIIIIlIIIIlll, final double lllllllllllllIlllIllIIIIlIIIIllI, final double lllllllllllllIlllIllIIIIlIIIllIl, final int... lllllllllllllIlllIllIIIIlIIIllII) {
            return new ParticleSuspendedTown(lllllllllllllIlllIllIIIIlIIlIIll, lllllllllllllIlllIllIIIIlIIIlIlI, lllllllllllllIlllIllIIIIlIIlIIIl, lllllllllllllIlllIllIIIIlIIlIIII, lllllllllllllIlllIllIIIIlIIIIlll, lllllllllllllIlllIllIIIIlIIIIllI, lllllllllllllIlllIllIIIIlIIIllIl);
        }
    }
    
    public static class HappyVillagerFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlIllIllIIlIlIlIlIIll, final World lllllllllllIlIllIllIIlIlIlIlIIlI, final double lllllllllllIlIllIllIIlIlIlIIIlll, final double lllllllllllIlIllIllIIlIlIlIIIllI, final double lllllllllllIlIllIllIIlIlIlIIIlIl, final double lllllllllllIlIllIllIIlIlIlIIlllI, final double lllllllllllIlIllIllIIlIlIlIIIIll, final double lllllllllllIlIllIllIIlIlIlIIllII, final int... lllllllllllIlIllIllIIlIlIlIIlIll) {
            final Particle lllllllllllIlIllIllIIlIlIlIIlIlI = new ParticleSuspendedTown(lllllllllllIlIllIllIIlIlIlIlIIlI, lllllllllllIlIllIllIIlIlIlIIIlll, lllllllllllIlIllIllIIlIlIlIIIllI, lllllllllllIlIllIllIIlIlIlIIIlIl, lllllllllllIlIllIllIIlIlIlIIlllI, lllllllllllIlIllIllIIlIlIlIIIIll, lllllllllllIlIllIllIIlIlIlIIllII);
            lllllllllllIlIllIllIIlIlIlIIlIlI.setParticleTextureIndex(82);
            lllllllllllIlIllIllIIlIlIlIIlIlI.setRBGColorF(1.0f, 1.0f, 1.0f);
            return lllllllllllIlIllIllIIlIlIlIIlIlI;
        }
    }
}
