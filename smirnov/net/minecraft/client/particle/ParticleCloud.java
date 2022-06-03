// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;

public class ParticleCloud extends Particle
{
    /* synthetic */ float oSize;
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllIIllIllllIlIlIlllllII, final Entity lllllllllllIIllIllllIlIlIllllIll, final float lllllllllllIIllIllllIlIllIIIIlII, final float lllllllllllIIllIllllIlIllIIIIIll, final float lllllllllllIIllIllllIlIlIllllIII, final float lllllllllllIIllIllllIlIlIlllIlll, final float lllllllllllIIllIllllIlIllIIIIIII, final float lllllllllllIIllIllllIlIlIlllIlIl) {
        float lllllllllllIIllIllllIlIlIllllllI = (this.particleAge + lllllllllllIIllIllllIlIllIIIIlII) / this.particleMaxAge * 32.0f;
        lllllllllllIIllIllllIlIlIllllllI = MathHelper.clamp(lllllllllllIIllIllllIlIlIllllllI, 0.0f, 1.0f);
        this.particleScale = this.oSize * lllllllllllIIllIllllIlIlIllllllI;
        super.renderParticle(lllllllllllIIllIllllIlIlIlllllII, lllllllllllIIllIllllIlIlIllllIll, lllllllllllIIllIllllIlIllIIIIlII, lllllllllllIIllIllllIlIllIIIIIll, lllllllllllIIllIllllIlIlIllllIII, lllllllllllIIllIllllIlIlIlllIlll, lllllllllllIIllIllllIlIllIIIIIII, lllllllllllIIllIllllIlIlIlllIlIl);
    }
    
    protected ParticleCloud(final World lllllllllllIIllIllllIlIllIlIIlII, final double lllllllllllIIllIllllIlIllIlIIIll, final double lllllllllllIIllIllllIlIllIlIIIlI, final double lllllllllllIIllIllllIlIllIIlIlll, final double lllllllllllIIllIllllIlIllIlIIIII, final double lllllllllllIIllIllllIlIllIIlIlIl, final double lllllllllllIIllIllllIlIllIIlIlII) {
        super(lllllllllllIIllIllllIlIllIlIIlII, lllllllllllIIllIllllIlIllIlIIIll, lllllllllllIIllIllllIlIllIlIIIlI, lllllllllllIIllIllllIlIllIIlIlll, 0.0, 0.0, 0.0);
        final float lllllllllllIIllIllllIlIllIIlllIl = 2.5f;
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += lllllllllllIIllIllllIlIllIlIIIII;
        this.motionY += lllllllllllIIllIllllIlIllIIlIlIl;
        this.motionZ += lllllllllllIIllIllllIlIllIIlIlII;
        final float lllllllllllIIllIllllIlIllIIlllII = 1.0f - (float)(Math.random() * 0.30000001192092896);
        this.particleRed = lllllllllllIIllIllllIlIllIIlllII;
        this.particleGreen = lllllllllllIIllIllllIlIllIIlllII;
        this.particleBlue = lllllllllllIIllIllllIlIllIIlllII;
        this.particleScale *= 0.75f;
        this.particleScale *= 2.5f;
        this.oSize = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.3));
        this.particleMaxAge *= (int)2.5f;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        final EntityPlayer lllllllllllIIllIllllIlIlIllIllll = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 2.0, false);
        if (lllllllllllIIllIllllIlIlIllIllll != null) {
            final AxisAlignedBB lllllllllllIIllIllllIlIlIllIlllI = lllllllllllIIllIllllIlIlIllIllll.getEntityBoundingBox();
            if (this.posY > lllllllllllIIllIllllIlIlIllIlllI.minY) {
                this.posY += (lllllllllllIIllIllllIlIlIllIlllI.minY - this.posY) * 0.2;
                this.motionY += (lllllllllllIIllIllllIlIlIllIllll.motionY - this.motionY) * 0.2;
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIIlIIIIlIIIlllIllIlIl, final World lllllllllllIIlIIIIlIIIlllIlIllII, final double lllllllllllIIlIIIIlIIIlllIlIlIll, final double lllllllllllIIlIIIIlIIIlllIlIlIlI, final double lllllllllllIIlIIIIlIIIlllIllIIIl, final double lllllllllllIIlIIIIlIIIlllIlIlIII, final double lllllllllllIIlIIIIlIIIlllIlIllll, final double lllllllllllIIlIIIIlIIIlllIlIIllI, final int... lllllllllllIIlIIIIlIIIlllIlIllIl) {
            return new ParticleCloud(lllllllllllIIlIIIIlIIIlllIlIllII, lllllllllllIIlIIIIlIIIlllIlIlIll, lllllllllllIIlIIIIlIIIlllIlIlIlI, lllllllllllIIlIIIIlIIIlllIllIIIl, lllllllllllIIlIIIIlIIIlllIlIlIII, lllllllllllIIlIIIIlIIIlllIlIllll, lllllllllllIIlIIIIlIIIlllIlIIllI);
        }
    }
}
