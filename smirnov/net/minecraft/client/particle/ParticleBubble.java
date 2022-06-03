// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ParticleBubble extends Particle
{
    protected ParticleBubble(final World llllllllllllllIIIIIIllIlIlllllll, final double llllllllllllllIIIIIIllIllIIIIllI, final double llllllllllllllIIIIIIllIlIlllllIl, final double llllllllllllllIIIIIIllIllIIIIlII, final double llllllllllllllIIIIIIllIllIIIIIll, final double llllllllllllllIIIIIIllIllIIIIIlI, final double llllllllllllllIIIIIIllIlIllllIIl) {
        super(llllllllllllllIIIIIIllIlIlllllll, llllllllllllllIIIIIIllIllIIIIllI, llllllllllllllIIIIIIllIlIlllllIl, llllllllllllllIIIIIIllIllIIIIlII, llllllllllllllIIIIIIllIllIIIIIll, llllllllllllllIIIIIIllIllIIIIIlI, llllllllllllllIIIIIIllIlIllllIIl);
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(32);
        this.setSize(0.02f, 0.02f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.2f;
        this.motionX = llllllllllllllIIIIIIllIllIIIIIll * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.motionY = llllllllllllllIIIIIIllIllIIIIIlI * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.motionZ = llllllllllllllIIIIIIllIlIllllIIl * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY += 0.002;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.8500000238418579;
        this.motionY *= 0.8500000238418579;
        this.motionZ *= 0.8500000238418579;
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
        public Particle createParticle(final int llllllllllllllIllIllIIlllIlIIlIl, final World llllllllllllllIllIllIIlllIlIIlII, final double llllllllllllllIllIllIIlllIlIIIll, final double llllllllllllllIllIllIIlllIIllIlI, final double llllllllllllllIllIllIIlllIIllIIl, final double llllllllllllllIllIllIIlllIlIIIII, final double llllllllllllllIllIllIIlllIIlIlll, final double llllllllllllllIllIllIIlllIIllllI, final int... llllllllllllllIllIllIIlllIIlllIl) {
            return new ParticleBubble(llllllllllllllIllIllIIlllIlIIlII, llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIIllIlI, llllllllllllllIllIllIIlllIIllIIl, llllllllllllllIllIllIIlllIlIIIII, llllllllllllllIllIllIIlllIIlIlll, llllllllllllllIllIllIIlllIIllllI);
        }
    }
}
