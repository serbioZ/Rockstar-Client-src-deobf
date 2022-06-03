// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;
import java.util.Random;

public class ParticleSpell extends Particle
{
    private static final /* synthetic */ Random RANDOM;
    private /* synthetic */ int baseSpellTextureIndex;
    
    @Override
    public boolean isTransparent() {
        return true;
    }
    
    protected ParticleSpell(final World lllllllllllIlllIIllIIIlllIIlllIl, final double lllllllllllIlllIIllIIIlllIlIIlII, final double lllllllllllIlllIIllIIIlllIIllIll, final double lllllllllllIlllIIllIIIlllIlIIIlI, final double lllllllllllIlllIIllIIIlllIIllIIl, final double lllllllllllIlllIIllIIIlllIIllIII, final double lllllllllllIlllIIllIIIlllIIlllll) {
        super(lllllllllllIlllIIllIIIlllIIlllIl, lllllllllllIlllIIllIIIlllIlIIlII, lllllllllllIlllIIllIIIlllIIllIll, lllllllllllIlllIIllIIIlllIlIIIlI, 0.5 - ParticleSpell.RANDOM.nextDouble(), lllllllllllIlllIIllIIIlllIIllIII, 0.5 - ParticleSpell.RANDOM.nextDouble());
        this.baseSpellTextureIndex = 128;
        this.motionY *= 0.20000000298023224;
        if (lllllllllllIlllIIllIIIlllIIllIIl == 0.0 && lllllllllllIlllIIllIIIlllIIlllll == 0.0) {
            this.motionX *= 0.10000000149011612;
            this.motionZ *= 0.10000000149011612;
        }
        this.particleScale *= 0.75f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.setParticleTextureIndex(this.baseSpellTextureIndex + (7 - this.particleAge * 8 / this.particleMaxAge));
        this.motionY += 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    public void setBaseSpellTextureIndex(final int lllllllllllIlllIIllIIIlllIIIllIl) {
        this.baseSpellTextureIndex = lllllllllllIlllIIllIIIlllIIIllIl;
    }
    
    static {
        RANDOM = new Random();
    }
    
    public static class MobFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlIlllIllIllIlIlIllIl, final World lllllllllllIlIlllIllIllIlIlIllII, final double lllllllllllIlIlllIllIllIlIlIlIll, final double lllllllllllIlIlllIllIllIlIlIIIII, final double lllllllllllIlIlllIllIllIlIlIlIIl, final double lllllllllllIlIlllIllIllIlIIllllI, final double lllllllllllIlIlllIllIllIlIIlllIl, final double lllllllllllIlIlllIllIllIlIIlllII, final int... lllllllllllIlIlllIllIllIlIlIIlIl) {
            final Particle lllllllllllIlIlllIllIllIlIlIIlII = new ParticleSpell(lllllllllllIlIlllIllIllIlIlIllII, lllllllllllIlIlllIllIllIlIlIlIll, lllllllllllIlIlllIllIllIlIlIIIII, lllllllllllIlIlllIllIllIlIlIlIIl, lllllllllllIlIlllIllIllIlIIllllI, lllllllllllIlIlllIllIllIlIIlllIl, lllllllllllIlIlllIllIllIlIIlllII);
            lllllllllllIlIlllIllIllIlIlIIlII.setRBGColorF((float)lllllllllllIlIlllIllIllIlIIllllI, (float)lllllllllllIlIlllIllIllIlIIlllIl, (float)lllllllllllIlIlllIllIllIlIIlllII);
            return lllllllllllIlIlllIllIllIlIlIIlII;
        }
    }
    
    public static class WitchFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIllIlIlllIIIllIllIll, final World llllllllllllIllIlIlllIIIllIIlllI, final double llllllllllllIllIlIlllIIIllIIllIl, final double llllllllllllIllIlIlllIIIllIIllII, final double llllllllllllIllIlIlllIIIllIlIlll, final double llllllllllllIllIlIlllIIIllIlIllI, final double llllllllllllIllIlIlllIIIllIlIlIl, final double llllllllllllIllIlIlllIIIllIIlIII, final int... llllllllllllIllIlIlllIIIllIlIIll) {
            final Particle llllllllllllIllIlIlllIIIllIlIIlI = new ParticleSpell(llllllllllllIllIlIlllIIIllIIlllI, llllllllllllIllIlIlllIIIllIIllIl, llllllllllllIllIlIlllIIIllIIllII, llllllllllllIllIlIlllIIIllIlIlll, llllllllllllIllIlIlllIIIllIlIllI, llllllllllllIllIlIlllIIIllIlIlIl, llllllllllllIllIlIlllIIIllIIlIII);
            ((ParticleSpell)llllllllllllIllIlIlllIIIllIlIIlI).setBaseSpellTextureIndex(144);
            final float llllllllllllIllIlIlllIIIllIlIIIl = llllllllllllIllIlIlllIIIllIIlllI.rand.nextFloat() * 0.5f + 0.35f;
            llllllllllllIllIlIlllIIIllIlIIlI.setRBGColorF(1.0f * llllllllllllIllIlIlllIIIllIlIIIl, 0.0f * llllllllllllIllIlIlllIIIllIlIIIl, 1.0f * llllllllllllIllIlIlllIIIllIlIIIl);
            return llllllllllllIllIlIlllIIIllIlIIlI;
        }
    }
    
    public static class InstantFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlIIIlllIIllIlIlIIlll, final World lllllllllllIlIIIlllIIllIlIlIIllI, final double lllllllllllIlIIIlllIIllIlIlIIlIl, final double lllllllllllIlIIIlllIIllIlIlIIlII, final double lllllllllllIlIIIlllIIllIlIIllIIl, final double lllllllllllIlIIIlllIIllIlIIllIII, final double lllllllllllIlIIIlllIIllIlIlIIIIl, final double lllllllllllIlIIIlllIIllIlIlIIIII, final int... lllllllllllIlIIIlllIIllIlIIlllll) {
            final Particle lllllllllllIlIIIlllIIllIlIIllllI = new ParticleSpell(lllllllllllIlIIIlllIIllIlIlIIllI, lllllllllllIlIIIlllIIllIlIlIIlIl, lllllllllllIlIIIlllIIllIlIlIIlII, lllllllllllIlIIIlllIIllIlIIllIIl, lllllllllllIlIIIlllIIllIlIIllIII, lllllllllllIlIIIlllIIllIlIlIIIIl, lllllllllllIlIIIlllIIllIlIlIIIII);
            ((ParticleSpell)lllllllllllIlIIIlllIIllIlIIllllI).setBaseSpellTextureIndex(144);
            return lllllllllllIlIIIlllIIllIlIIllllI;
        }
    }
    
    public static class AmbientMobFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllllIIllllllllIllIlI, final World llllllllllllllllIIllllllllIllIIl, final double llllllllllllllllIIllllllllIllIII, final double llllllllllllllllIIllllllllIlIlll, final double llllllllllllllllIIllllllllIlIllI, final double llllllllllllllllIIllllllllIIlIll, final double llllllllllllllllIIllllllllIIlIlI, final double llllllllllllllllIIllllllllIlIIll, final int... llllllllllllllllIIllllllllIlIIlI) {
            final Particle llllllllllllllllIIllllllllIlIIIl = new ParticleSpell(llllllllllllllllIIllllllllIllIIl, llllllllllllllllIIllllllllIllIII, llllllllllllllllIIllllllllIlIlll, llllllllllllllllIIllllllllIlIllI, llllllllllllllllIIllllllllIIlIll, llllllllllllllllIIllllllllIIlIlI, llllllllllllllllIIllllllllIlIIll);
            llllllllllllllllIIllllllllIlIIIl.setAlphaF(0.15f);
            llllllllllllllllIIllllllllIlIIIl.setRBGColorF((float)llllllllllllllllIIllllllllIIlIll, (float)llllllllllllllllIIllllllllIIlIlI, (float)llllllllllllllllIIllllllllIlIIll);
            return llllllllllllllllIIllllllllIlIIIl;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIllIlIIllIlIIIllll, final World llllllllllllllIllIlIIllIlIIIIllI, final double llllllllllllllIllIlIIllIlIIIIlIl, final double llllllllllllllIllIlIIllIlIIIIlII, final double llllllllllllllIllIlIIllIlIIIlIll, final double llllllllllllllIllIlIIllIlIIIIIlI, final double llllllllllllllIllIlIIllIlIIIIIIl, final double llllllllllllllIllIlIIllIlIIIlIII, final int... llllllllllllllIllIlIIllIlIIIIlll) {
            return new ParticleSpell(llllllllllllllIllIlIIllIlIIIIllI, llllllllllllllIllIlIIllIlIIIIlIl, llllllllllllllIllIlIIllIlIIIIlII, llllllllllllllIllIlIIllIlIIIlIll, llllllllllllllIllIlIIllIlIIIIIlI, llllllllllllllIllIlIIllIlIIIIIIl, llllllllllllllIllIlIIllIlIIIlIII);
        }
    }
}
