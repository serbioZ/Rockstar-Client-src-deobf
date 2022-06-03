// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleSplash extends ParticleRain
{
    protected ParticleSplash(final World lllllllllllIIllIlllIllIlIIIIlllI, final double lllllllllllIIllIlllIllIlIIIlIlIl, final double lllllllllllIIllIlllIllIlIIIlIlII, final double lllllllllllIIllIlllIllIlIIIlIIll, final double lllllllllllIIllIlllIllIlIIIIlIlI, final double lllllllllllIIllIlllIllIlIIIlIIIl, final double lllllllllllIIllIlllIllIlIIIlIIII) {
        super(lllllllllllIIllIlllIllIlIIIIlllI, lllllllllllIIllIlllIllIlIIIlIlIl, lllllllllllIIllIlllIllIlIIIlIlII, lllllllllllIIllIlllIllIlIIIlIIll);
        this.particleGravity = 0.04f;
        this.nextTextureIndexX();
        if (lllllllllllIIllIlllIllIlIIIlIIIl == 0.0 && (lllllllllllIIllIlllIllIlIIIIlIlI != 0.0 || lllllllllllIIllIlllIllIlIIIlIIII != 0.0)) {
            this.motionX = lllllllllllIIllIlllIllIlIIIIlIlI;
            this.motionY = lllllllllllIIllIlllIllIlIIIlIIIl + 0.1;
            this.motionZ = lllllllllllIIllIlllIllIlIIIlIIII;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlIIIIIlIlIIllIIlllIl, final World lllllllllllIlIIIIIlIlIIllIIlllII, final double lllllllllllIlIIIIIlIlIIllIIllIll, final double lllllllllllIlIIIIIlIlIIllIIllIlI, final double lllllllllllIlIIIIIlIlIIllIIlIIIl, final double lllllllllllIlIIIIIlIlIIllIIlIIII, final double lllllllllllIlIIIIIlIlIIllIIlIlll, final double lllllllllllIlIIIIIlIlIIllIIIlllI, final int... lllllllllllIlIIIIIlIlIIllIIlIlIl) {
            return new ParticleSplash(lllllllllllIlIIIIIlIlIIllIIlllII, lllllllllllIlIIIIIlIlIIllIIllIll, lllllllllllIlIIIIIlIlIIllIIllIlI, lllllllllllIlIIIIIlIlIIllIIlIIIl, lllllllllllIlIIIIIlIlIIllIIlIIII, lllllllllllIlIIIIIlIlIIllIIlIlll, lllllllllllIlIIIIIlIlIIllIIIlllI);
        }
    }
}
