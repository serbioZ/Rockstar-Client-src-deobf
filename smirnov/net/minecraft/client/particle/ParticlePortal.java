// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;

public class ParticlePortal extends Particle
{
    private final /* synthetic */ double portalPosX;
    private final /* synthetic */ double portalPosZ;
    private final /* synthetic */ float portalParticleScale;
    private final /* synthetic */ double portalPosY;
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllIllllllIlllllllIlIlIIl, final Entity llllllllllIllllllIlllllllIlIlIII, final float llllllllllIllllllIlllllllIIlllIl, final float llllllllllIllllllIlllllllIIlllII, final float llllllllllIllllllIlllllllIIllIll, final float llllllllllIllllllIlllllllIlIIlII, final float llllllllllIllllllIlllllllIIllIIl, final float llllllllllIllllllIlllllllIIllIII) {
        float llllllllllIllllllIlllllllIlIIIIl = (this.particleAge + llllllllllIllllllIlllllllIIlllIl) / this.particleMaxAge;
        llllllllllIllllllIlllllllIlIIIIl = 1.0f - llllllllllIllllllIlllllllIlIIIIl;
        llllllllllIllllllIlllllllIlIIIIl *= llllllllllIllllllIlllllllIlIIIIl;
        llllllllllIllllllIlllllllIlIIIIl = 1.0f - llllllllllIllllllIlllllllIlIIIIl;
        this.particleScale = this.portalParticleScale * llllllllllIllllllIlllllllIlIIIIl;
        super.renderParticle(llllllllllIllllllIlllllllIlIlIIl, llllllllllIllllllIlllllllIlIlIII, llllllllllIllllllIlllllllIIlllIl, llllllllllIllllllIlllllllIIlllII, llllllllllIllllllIlllllllIIllIll, llllllllllIllllllIlllllllIlIIlII, llllllllllIllllllIlllllllIIllIIl, llllllllllIllllllIlllllllIIllIII);
    }
    
    @Override
    public void moveEntity(final double llllllllllIllllllIlllllllIllIlll, final double llllllllllIllllllIlllllllIlllIlI, final double llllllllllIllllllIlllllllIlllIIl) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(llllllllllIllllllIlllllllIllIlll, llllllllllIllllllIlllllllIlllIlI, llllllllllIllllllIlllllllIlllIIl));
        this.resetPositionToBB();
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        final float llllllllllIllllllIllllllIlllllll = this.particleAge / (float)this.particleMaxAge;
        final float llllllllllIllllllIllllllIllllllI = -llllllllllIllllllIllllllIlllllll + llllllllllIllllllIllllllIlllllll * llllllllllIllllllIllllllIlllllll * 2.0f;
        final float llllllllllIllllllIllllllIlllllIl = 1.0f - llllllllllIllllllIllllllIllllllI;
        this.posX = this.portalPosX + this.motionX * llllllllllIllllllIllllllIlllllIl;
        this.posY = this.portalPosY + this.motionY * llllllllllIllllllIllllllIlllllIl + (1.0f - llllllllllIllllllIllllllIlllllll);
        this.posZ = this.portalPosZ + this.motionZ * llllllllllIllllllIllllllIlllllIl;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
    }
    
    protected ParticlePortal(final World llllllllllIllllllIllllllllIlIIIl, final double llllllllllIllllllIllllllllIIIlll, final double llllllllllIllllllIllllllllIIIllI, final double llllllllllIllllllIllllllllIIIlIl, final double llllllllllIllllllIllllllllIIllIl, final double llllllllllIllllllIllllllllIIllII, final double llllllllllIllllllIllllllllIIlIll) {
        super(llllllllllIllllllIllllllllIlIIIl, llllllllllIllllllIllllllllIIIlll, llllllllllIllllllIllllllllIIIllI, llllllllllIllllllIllllllllIIIlIl, llllllllllIllllllIllllllllIIllIl, llllllllllIllllllIllllllllIIllII, llllllllllIllllllIllllllllIIlIll);
        this.motionX = llllllllllIllllllIllllllllIIllIl;
        this.motionY = llllllllllIllllllIllllllllIIllII;
        this.motionZ = llllllllllIllllllIllllllllIIlIll;
        this.posX = llllllllllIllllllIllllllllIIIlll;
        this.posY = llllllllllIllllllIllllllllIIIllI;
        this.posZ = llllllllllIllllllIllllllllIIIlIl;
        this.portalPosX = this.posX;
        this.portalPosY = this.posY;
        this.portalPosZ = this.posZ;
        final float llllllllllIllllllIllllllllIIlIlI = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleScale = this.rand.nextFloat() * 0.2f + 0.5f;
        this.portalParticleScale = this.particleScale;
        this.particleRed = llllllllllIllllllIllllllllIIlIlI * 0.9f;
        this.particleGreen = llllllllllIllllllIllllllllIIlIlI * 0.3f;
        this.particleBlue = llllllllllIllllllIllllllllIIlIlI;
        this.particleMaxAge = (int)(Math.random() * 10.0) + 40;
        this.setParticleTextureIndex((int)(Math.random() * 8.0));
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllIllllllIlllllllIIIllll) {
        final int llllllllllIllllllIlllllllIIIlllI = super.getBrightnessForRender(llllllllllIllllllIlllllllIIIllll);
        float llllllllllIllllllIlllllllIIIllIl = this.particleAge / (float)this.particleMaxAge;
        llllllllllIllllllIlllllllIIIllIl *= llllllllllIllllllIlllllllIIIllIl;
        llllllllllIllllllIlllllllIIIllIl *= llllllllllIllllllIlllllllIIIllIl;
        final int llllllllllIllllllIlllllllIIIllII = llllllllllIllllllIlllllllIIIlllI & 0xFF;
        int llllllllllIllllllIlllllllIIIlIll = llllllllllIllllllIlllllllIIIlllI >> 16 & 0xFF;
        llllllllllIllllllIlllllllIIIlIll += (int)(llllllllllIllllllIlllllllIIIllIl * 15.0f * 16.0f);
        if (llllllllllIllllllIlllllllIIIlIll > 240) {
            llllllllllIllllllIlllllllIIIlIll = 240;
        }
        return llllllllllIllllllIlllllllIIIllII | llllllllllIllllllIlllllllIIIlIll << 16;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIlllllIIIIIlIllllIll, final World llllllllllllIlllllIIIIIlIlllIIlI, final double llllllllllllIlllllIIIIIlIllllIIl, final double llllllllllllIlllllIIIIIlIlllIIII, final double llllllllllllIlllllIIIIIlIlllIlll, final double llllllllllllIlllllIIIIIlIllIlllI, final double llllllllllllIlllllIIIIIlIlllIlIl, final double llllllllllllIlllllIIIIIlIlllIlII, final int... llllllllllllIlllllIIIIIlIlllIIll) {
            return new ParticlePortal(llllllllllllIlllllIIIIIlIlllIIlI, llllllllllllIlllllIIIIIlIllllIIl, llllllllllllIlllllIIIIIlIlllIIII, llllllllllllIlllllIIIIIlIlllIlll, llllllllllllIlllllIIIIIlIllIlllI, llllllllllllIlllllIIIIIlIlllIlIl, llllllllllllIlllllIIIIIlIlllIlII);
        }
    }
}
