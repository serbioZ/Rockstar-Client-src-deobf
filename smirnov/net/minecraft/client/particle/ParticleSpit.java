// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleSpit extends ParticleExplosion
{
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY -= 0.004 + 0.04 * this.particleGravity;
    }
    
    protected ParticleSpit(final World lllllllllllllllIlllIllIlIIIIIIIl, final double lllllllllllllllIlllIllIlIIIIIIII, final double lllllllllllllllIlllIllIIllllllll, final double lllllllllllllllIlllIllIIlllllllI, final double lllllllllllllllIlllIllIlIIIIIlIl, final double lllllllllllllllIlllIllIIllllllII, final double lllllllllllllllIlllIllIlIIIIIIll) {
        super(lllllllllllllllIlllIllIlIIIIIIIl, lllllllllllllllIlllIllIlIIIIIIII, lllllllllllllllIlllIllIIllllllll, lllllllllllllllIlllIllIIlllllllI, lllllllllllllllIlllIllIlIIIIIlIl, lllllllllllllllIlllIllIIllllllII, lllllllllllllllIlllIllIlIIIIIIll);
        this.particleGravity = 0.5f;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIIlIlllIIlIIllIIlllIl, final World lllllllllllIIlIlllIIlIIllIIlllII, final double lllllllllllIIlIlllIIlIIllIIlIIll, final double lllllllllllIIlIlllIIlIIllIIllIlI, final double lllllllllllIIlIlllIIlIIllIIlIIIl, final double lllllllllllIIlIlllIIlIIllIIlIIII, final double lllllllllllIIlIlllIIlIIllIIlIlll, final double lllllllllllIIlIlllIIlIIllIIlIllI, final int... lllllllllllIIlIlllIIlIIllIIlIlIl) {
            return new ParticleSpit(lllllllllllIIlIlllIIlIIllIIlllII, lllllllllllIIlIlllIIlIIllIIlIIll, lllllllllllIIlIlllIIlIIllIIllIlI, lllllllllllIIlIlllIIlIIllIIlIIIl, lllllllllllIIlIlllIIlIIllIIlIIII, lllllllllllIIlIlllIIlIIllIIlIlll, lllllllllllIIlIlllIIlIIllIIlIllI);
        }
    }
}
