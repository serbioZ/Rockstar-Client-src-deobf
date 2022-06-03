// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleEndRod extends ParticleSimpleAnimated
{
    @Override
    public void moveEntity(final double lllllllllllIIIIllIlIlllIlIlIlIll, final double lllllllllllIIIIllIlIlllIlIlIlIlI, final double lllllllllllIIIIllIlIlllIlIlIlIIl) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllIIIIllIlIlllIlIlIlIll, lllllllllllIIIIllIlIlllIlIlIlIlI, lllllllllllIIIIllIlIlllIlIlIlIIl));
        this.resetPositionToBB();
    }
    
    public ParticleEndRod(final World lllllllllllIIIIllIlIlllIlIlllIll, final double lllllllllllIIIIllIlIlllIlIlllIlI, final double lllllllllllIIIIllIlIlllIllIIIIIl, final double lllllllllllIIIIllIlIlllIllIIIIII, final double lllllllllllIIIIllIlIlllIlIllllll, final double lllllllllllIIIIllIlIlllIlIllIllI, final double lllllllllllIIIIllIlIlllIlIllllIl) {
        super(lllllllllllIIIIllIlIlllIlIlllIll, lllllllllllIIIIllIlIlllIlIlllIlI, lllllllllllIIIIllIlIlllIllIIIIIl, lllllllllllIIIIllIlIlllIllIIIIII, 176, 8, -5.0E-4f);
        this.motionX = lllllllllllIIIIllIlIlllIlIllllll;
        this.motionY = lllllllllllIIIIllIlIlllIlIllIllI;
        this.motionZ = lllllllllllIIIIllIlIlllIlIllllIl;
        this.particleScale *= 0.75f;
        this.particleMaxAge = 60 + this.rand.nextInt(12);
        this.setColorFade(15916745);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllllIIlIlllIIllIIlIlI, final World lllllllllllllllIIlIlllIIllIIIIIl, final double lllllllllllllllIIlIlllIIllIIIIII, final double lllllllllllllllIIlIlllIIllIIIlll, final double lllllllllllllllIIlIlllIIllIIIllI, final double lllllllllllllllIIlIlllIIlIllllIl, final double lllllllllllllllIIlIlllIIlIllllII, final double lllllllllllllllIIlIlllIIllIIIIll, final int... lllllllllllllllIIlIlllIIllIIIIlI) {
            return new ParticleEndRod(lllllllllllllllIIlIlllIIllIIIIIl, lllllllllllllllIIlIlllIIllIIIIII, lllllllllllllllIIlIlllIIllIIIlll, lllllllllllllllIIlIlllIIllIIIllI, lllllllllllllllIIlIlllIIlIllllIl, lllllllllllllllIIlIlllIIlIllllII, lllllllllllllllIIlIlllIIllIIIIll);
        }
    }
}
