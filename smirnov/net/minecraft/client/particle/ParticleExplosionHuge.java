// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.EnumParticleTypes;

public class ParticleExplosionHuge extends Particle
{
    private /* synthetic */ int timeSinceStart;
    
    @Override
    public void onUpdate() {
        for (int lllllllllllIIlllllIlIIIlIlIlllIl = 0; lllllllllllIIlllllIlIIIlIlIlllIl < 6; ++lllllllllllIIlllllIlIIIlIlIlllIl) {
            final double lllllllllllIIlllllIlIIIlIlIlllII = this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0;
            final double lllllllllllIIlllllIlIIIlIlIllIll = this.posY + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0;
            final double lllllllllllIIlllllIlIIIlIlIllIlI = this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0;
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, lllllllllllIIlllllIlIIIlIlIlllII, lllllllllllIIlllllIlIIIlIlIllIll, lllllllllllIIlllllIlIIIlIlIllIlI, this.timeSinceStart / 8.0f, 0.0, 0.0, new int[0]);
        }
        ++this.timeSinceStart;
        if (this.timeSinceStart == 8) {
            this.setExpired();
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllIIlllllIlIIIlIllIlIll, final Entity lllllllllllIIlllllIlIIIlIllIlIlI, final float lllllllllllIIlllllIlIIIlIllIlIIl, final float lllllllllllIIlllllIlIIIlIllIlIII, final float lllllllllllIIlllllIlIIIlIllIIlll, final float lllllllllllIIlllllIlIIIlIllIIllI, final float lllllllllllIIlllllIlIIIlIllIIlIl, final float lllllllllllIIlllllIlIIIlIllIIlII) {
    }
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    protected ParticleExplosionHuge(final World lllllllllllIIlllllIlIIIlIlllIIII, final double lllllllllllIIlllllIlIIIlIllIllll, final double lllllllllllIIlllllIlIIIlIlllIllI, final double lllllllllllIIlllllIlIIIlIllIllIl, final double lllllllllllIIlllllIlIIIlIlllIlII, final double lllllllllllIIlllllIlIIIlIlllIIll, final double lllllllllllIIlllllIlIIIlIlllIIlI) {
        super(lllllllllllIIlllllIlIIIlIlllIIII, lllllllllllIIlllllIlIIIlIllIllll, lllllllllllIIlllllIlIIIlIlllIllI, lllllllllllIIlllllIlIIIlIllIllIl, 0.0, 0.0, 0.0);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIIlIlIIIIIIIlIlIIlllI, final World lllllllllllIIlIlIIIIIIIlIlIIIlIl, final double lllllllllllIIlIlIIIIIIIlIlIIllII, final double lllllllllllIIlIlIIIIIIIlIlIIIIll, final double lllllllllllIIlIlIIIIIIIlIlIIIIlI, final double lllllllllllIIlIlIIIIIIIlIlIIIIIl, final double lllllllllllIIlIlIIIIIIIlIlIIlIII, final double lllllllllllIIlIlIIIIIIIlIlIIIlll, final int... lllllllllllIIlIlIIIIIIIlIlIIIllI) {
            return new ParticleExplosionHuge(lllllllllllIIlIlIIIIIIIlIlIIIlIl, lllllllllllIIlIlIIIIIIIlIlIIllII, lllllllllllIIlIlIIIIIIIlIlIIIIll, lllllllllllIIlIlIIIIIIIlIlIIIIlI, lllllllllllIIlIlIIIIIIIlIlIIIIIl, lllllllllllIIlIlIIIIIIIlIlIIlIII, lllllllllllIIlIlIIIIIIIlIlIIIlll);
        }
    }
}
