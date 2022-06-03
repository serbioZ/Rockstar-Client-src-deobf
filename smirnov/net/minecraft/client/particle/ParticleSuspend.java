// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ParticleSuspend extends Particle
{
    protected ParticleSuspend(final World lllllllllllIIlllIIlIlllllIIllllI, final double lllllllllllIIlllIIlIlllllIIlllIl, final double lllllllllllIIlllIIlIlllllIIlllII, final double lllllllllllIIlllIIlIlllllIIllIll, final double lllllllllllIIlllIIlIlllllIIllIlI, final double lllllllllllIIlllIIlIlllllIIllIIl, final double lllllllllllIIlllIIlIlllllIIllIII) {
        super(lllllllllllIIlllIIlIlllllIIllllI, lllllllllllIIlllIIlIlllllIIlllIl, lllllllllllIIlllIIlIlllllIIlllII - 0.125, lllllllllllIIlllIIlIlllllIIllIll, lllllllllllIIlllIIlIlllllIIllIlI, lllllllllllIIlllIIlIlllllIIllIIl, lllllllllllIIlllIIlIlllllIIllIII);
        this.particleRed = 0.4f;
        this.particleGreen = 0.4f;
        this.particleBlue = 0.7f;
        this.setParticleTextureIndex(0);
        this.setSize(0.01f, 0.01f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.2f;
        this.motionX = lllllllllllIIlllIIlIlllllIIllIlI * 0.0;
        this.motionY = lllllllllllIIlllIIlIlllllIIllIIl * 0.0;
        this.motionZ = lllllllllllIIlllIIlIlllllIIllIII * 0.0;
        this.particleMaxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.worldObj.getBlockState(new BlockPos(this.posX, this.posY, this.posZ)).getMaterial() != Material.WATER) {
            this.setExpired();
        }
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlllllllIIlllIIlllIlI, final World lllllllllllIlllllllIIlllIIlllIIl, final double lllllllllllIlllllllIIlllIIllIIII, final double lllllllllllIlllllllIIlllIIlIllll, final double lllllllllllIlllllllIIlllIIlIlllI, final double lllllllllllIlllllllIIlllIIlIllIl, final double lllllllllllIlllllllIIlllIIlIllII, final double lllllllllllIlllllllIIlllIIllIIll, final int... lllllllllllIlllllllIIlllIIllIIlI) {
            return new ParticleSuspend(lllllllllllIlllllllIIlllIIlllIIl, lllllllllllIlllllllIIlllIIllIIII, lllllllllllIlllllllIIlllIIlIllll, lllllllllllIlllllllIIlllIIlIlllI, lllllllllllIlllllllIIlllIIlIllIl, lllllllllllIlllllllIIlllIIlIllII, lllllllllllIlllllllIIlllIIllIIll);
        }
    }
}
