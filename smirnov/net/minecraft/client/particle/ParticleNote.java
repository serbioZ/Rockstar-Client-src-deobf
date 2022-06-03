// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;

public class ParticleNote extends Particle
{
    /* synthetic */ float noteParticleScale;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.6600000262260437;
        this.motionY *= 0.6600000262260437;
        this.motionZ *= 0.6600000262260437;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllIIlIIIlIIlIlllIllllIl, final Entity lllllllllllIIlIIIlIIlIlllIllllII, final float lllllllllllIIlIIIlIIlIlllIllIIIl, final float lllllllllllIIlIIIlIIlIlllIlllIlI, final float lllllllllllIIlIIIlIIlIlllIlIllll, final float lllllllllllIIlIIIlIIlIlllIlllIII, final float lllllllllllIIlIIIlIIlIlllIlIllIl, final float lllllllllllIIlIIIlIIlIlllIlIllII) {
        float lllllllllllIIlIIIlIIlIlllIllIlIl = (this.particleAge + lllllllllllIIlIIIlIIlIlllIllIIIl) / this.particleMaxAge * 32.0f;
        lllllllllllIIlIIIlIIlIlllIllIlIl = MathHelper.clamp(lllllllllllIIlIIIlIIlIlllIllIlIl, 0.0f, 1.0f);
        this.particleScale = this.noteParticleScale * lllllllllllIIlIIIlIIlIlllIllIlIl;
        super.renderParticle(lllllllllllIIlIIIlIIlIlllIllllIl, lllllllllllIIlIIIlIIlIlllIllllII, lllllllllllIIlIIIlIIlIlllIllIIIl, lllllllllllIIlIIIlIIlIlllIlllIlI, lllllllllllIIlIIIlIIlIlllIlIllll, lllllllllllIIlIIIlIIlIlllIlllIII, lllllllllllIIlIIIlIIlIlllIlIllIl, lllllllllllIIlIIIlIIlIlllIlIllII);
    }
    
    protected ParticleNote(final World lllllllllllIIlIIIlIIlIllllIIlllI, final double lllllllllllIIlIIIlIIlIllllIlIllI, final double lllllllllllIIlIIIlIIlIllllIlIlIl, final double lllllllllllIIlIIIlIIlIllllIlIlII, final double lllllllllllIIlIIIlIIlIllllIlIIll, final double lllllllllllIIlIIIlIIlIllllIlIIlI, final double lllllllllllIIlIIIlIIlIllllIlIIIl, final float lllllllllllIIlIIIlIIlIllllIIlIIl) {
        super(lllllllllllIIlIIIlIIlIllllIIlllI, lllllllllllIIlIIIlIIlIllllIlIllI, lllllllllllIIlIIIlIIlIllllIlIlIl, lllllllllllIIlIIIlIIlIllllIlIlII, 0.0, 0.0, 0.0);
        this.motionX *= 0.009999999776482582;
        this.motionY *= 0.009999999776482582;
        this.motionZ *= 0.009999999776482582;
        this.motionY += 0.2;
        this.particleRed = MathHelper.sin(((float)lllllllllllIIlIIIlIIlIllllIlIIll + 0.0f) * 6.2831855f) * 0.65f + 0.35f;
        this.particleGreen = MathHelper.sin(((float)lllllllllllIIlIIIlIIlIllllIlIIll + 0.33333334f) * 6.2831855f) * 0.65f + 0.35f;
        this.particleBlue = MathHelper.sin(((float)lllllllllllIIlIIIlIIlIllllIlIIll + 0.6666667f) * 6.2831855f) * 0.65f + 0.35f;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllIIlIIIlIIlIllllIIlIIl;
        this.noteParticleScale = this.particleScale;
        this.particleMaxAge = 6;
        this.setParticleTextureIndex(64);
    }
    
    protected ParticleNote(final World lllllllllllIIlIIIlIIlIlllllIlllI, final double lllllllllllIIlIIIlIIlIlllllIllIl, final double lllllllllllIIlIIIlIIlIlllllIIlII, final double lllllllllllIIlIIIlIIlIlllllIIIll, final double lllllllllllIIlIIIlIIlIlllllIlIlI, final double lllllllllllIIlIIIlIIlIlllllIlIIl, final double lllllllllllIIlIIIlIIlIlllllIlIII) {
        this(lllllllllllIIlIIIlIIlIlllllIlllI, lllllllllllIIlIIIlIIlIlllllIllIl, lllllllllllIIlIIIlIIlIlllllIIlII, lllllllllllIIlIIIlIIlIlllllIIIll, lllllllllllIIlIIIlIIlIlllllIlIlI, lllllllllllIIlIIIlIIlIlllllIlIIl, lllllllllllIIlIIIlIIlIlllllIlIII, 2.0f);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllIlllIlIIlllIlllIIIIIII, final World llllllllllIlllIlIIlllIllIlllIlll, final double llllllllllIlllIlIIlllIllIllllllI, final double llllllllllIlllIlIIlllIllIlllIlIl, final double llllllllllIlllIlIIlllIllIlllIlII, final double llllllllllIlllIlIIlllIllIlllIIll, final double llllllllllIlllIlIIlllIllIlllIIlI, final double llllllllllIlllIlIIlllIllIlllIIIl, final int... llllllllllIlllIlIIlllIllIllllIII) {
            return new ParticleNote(llllllllllIlllIlIIlllIllIlllIlll, llllllllllIlllIlIIlllIllIllllllI, llllllllllIlllIlIIlllIllIlllIlIl, llllllllllIlllIlIIlllIllIlllIlII, llllllllllIlllIlIIlllIllIlllIIll, llllllllllIlllIlIIlllIllIlllIIlI, llllllllllIlllIlIIlllIllIlllIIIl);
        }
    }
}
