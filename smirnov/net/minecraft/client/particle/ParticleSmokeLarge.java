// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleSmokeLarge extends ParticleSmokeNormal
{
    protected ParticleSmokeLarge(final World lllllllllllIIllIIIIIIIIIIllIIIIl, final double lllllllllllIIllIIIIIIIIIIllIIIII, final double lllllllllllIIllIIIIIIIIIIlIlllll, final double lllllllllllIIllIIIIIIIIIIlIllllI, final double lllllllllllIIllIIIIIIIIIIlIlllIl, final double lllllllllllIIllIIIIIIIIIIlIlllII, final double lllllllllllIIllIIIIIIIIIIlIllIll) {
        super(lllllllllllIIllIIIIIIIIIIllIIIIl, lllllllllllIIllIIIIIIIIIIllIIIII, lllllllllllIIllIIIIIIIIIIlIlllll, lllllllllllIIllIIIIIIIIIIlIllllI, lllllllllllIIllIIIIIIIIIIlIlllIl, lllllllllllIIllIIIIIIIIIIlIlllII, lllllllllllIIllIIIIIIIIIIlIllIll, 2.5f);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIlIllIllIIIIIIIIIl, final World llllllllllllllIlIllIllIIIIIIIIII, final double llllllllllllllIlIllIlIllllllllll, final double llllllllllllllIlIllIlIllllllIllI, final double llllllllllllllIlIllIlIllllllIlIl, final double llllllllllllllIlIllIlIllllllllII, final double llllllllllllllIlIllIlIlllllllIll, final double llllllllllllllIlIllIlIlllllllIlI, final int... llllllllllllllIlIllIlIlllllllIIl) {
            return new ParticleSmokeLarge(llllllllllllllIlIllIllIIIIIIIIII, llllllllllllllIlIllIlIllllllllll, llllllllllllllIlIllIlIllllllIllI, llllllllllllllIlIllIlIllllllIlIl, llllllllllllllIlIllIlIllllllllII, llllllllllllllIlIllIlIlllllllIll, llllllllllllllIlIllIlIlllllllIlI);
        }
    }
}
