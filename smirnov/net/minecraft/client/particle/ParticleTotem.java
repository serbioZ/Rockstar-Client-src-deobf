// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleTotem extends ParticleSimpleAnimated
{
    public ParticleTotem(final World llllllllllIllllIIIIllllIIIIIlIlI, final double llllllllllIllllIIIIllllIIIIIIIIl, final double llllllllllIllllIIIIllllIIIIIIIII, final double llllllllllIllllIIIIllllIIIIIIlll, final double llllllllllIllllIIIIlllIllllllllI, final double llllllllllIllllIIIIlllIlllllllIl, final double llllllllllIllllIIIIlllIlllllllII) {
        super(llllllllllIllllIIIIllllIIIIIlIlI, llllllllllIllllIIIIllllIIIIIIIIl, llllllllllIllllIIIIllllIIIIIIIII, llllllllllIllllIIIIllllIIIIIIlll, 176, 8, -0.05f);
        this.motionX = llllllllllIllllIIIIlllIllllllllI;
        this.motionY = llllllllllIllllIIIIlllIlllllllIl;
        this.motionZ = llllllllllIllllIIIIlllIlllllllII;
        this.particleScale *= 0.75f;
        this.particleMaxAge = 60 + this.rand.nextInt(12);
        if (this.rand.nextInt(4) == 0) {
            this.setRBGColorF(0.6f + this.rand.nextFloat() * 0.2f, 0.6f + this.rand.nextFloat() * 0.3f, this.rand.nextFloat() * 0.2f);
        }
        else {
            this.setRBGColorF(0.1f + this.rand.nextFloat() * 0.2f, 0.4f + this.rand.nextFloat() * 0.3f, this.rand.nextFloat() * 0.2f);
        }
        this.func_191238_f(0.6f);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllllllIlllIIIIIIlIII, final World llllllllllllllllllIlllIIIIIIIlll, final double llllllllllllllllllIlllIIIIIIIllI, final double llllllllllllllllllIllIllllllllIl, final double llllllllllllllllllIlllIIIIIIIlII, final double llllllllllllllllllIlllIIIIIIIIll, final double llllllllllllllllllIllIlllllllIlI, final double llllllllllllllllllIlllIIIIIIIIIl, final int... llllllllllllllllllIlllIIIIIIIIII) {
            return new ParticleTotem(llllllllllllllllllIlllIIIIIIIlll, llllllllllllllllllIlllIIIIIIIllI, llllllllllllllllllIllIllllllllIl, llllllllllllllllllIlllIIIIIIIlII, llllllllllllllllllIlllIIIIIIIIll, llllllllllllllllllIllIlllllllIlI, llllllllllllllllllIlllIIIIIIIIIl);
        }
    }
}
