// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleEnchantmentTable extends Particle
{
    private final /* synthetic */ double coordY;
    private final /* synthetic */ double coordX;
    private final /* synthetic */ double coordZ;
    private final /* synthetic */ float oSize;
    
    @Override
    public void moveEntity(final double lllllllllllIlllIlllIIlIlIlIlllIl, final double lllllllllllIlllIlllIIlIlIlIllIII, final double lllllllllllIlllIlllIIlIlIlIllIll) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllIlllIlllIIlIlIlIlllIl, lllllllllllIlllIlllIIlIlIlIllIII, lllllllllllIlllIlllIIlIlIlIllIll));
        this.resetPositionToBB();
    }
    
    protected ParticleEnchantmentTable(final World lllllllllllIlllIlllIIlIlIllIlIlI, final double lllllllllllIlllIlllIIlIlIllIlIIl, final double lllllllllllIlllIlllIIlIlIlllIIIl, final double lllllllllllIlllIlllIIlIlIlllIIII, final double lllllllllllIlllIlllIIlIlIllIIllI, final double lllllllllllIlllIlllIIlIlIllIIlIl, final double lllllllllllIlllIlllIIlIlIllIllIl) {
        super(lllllllllllIlllIlllIIlIlIllIlIlI, lllllllllllIlllIlllIIlIlIllIlIIl, lllllllllllIlllIlllIIlIlIlllIIIl, lllllllllllIlllIlllIIlIlIlllIIII, lllllllllllIlllIlllIIlIlIllIIllI, lllllllllllIlllIlllIIlIlIllIIlIl, lllllllllllIlllIlllIIlIlIllIllIl);
        this.motionX = lllllllllllIlllIlllIIlIlIllIIllI;
        this.motionY = lllllllllllIlllIlllIIlIlIllIIlIl;
        this.motionZ = lllllllllllIlllIlllIIlIlIllIllIl;
        this.coordX = lllllllllllIlllIlllIIlIlIllIlIIl;
        this.coordY = lllllllllllIlllIlllIIlIlIlllIIIl;
        this.coordZ = lllllllllllIlllIlllIIlIlIlllIIII;
        this.prevPosX = lllllllllllIlllIlllIIlIlIllIlIIl + lllllllllllIlllIlllIIlIlIllIIllI;
        this.prevPosY = lllllllllllIlllIlllIIlIlIlllIIIl + lllllllllllIlllIlllIIlIlIllIIlIl;
        this.prevPosZ = lllllllllllIlllIlllIIlIlIlllIIII + lllllllllllIlllIlllIIlIlIllIllIl;
        this.posX = this.prevPosX;
        this.posY = this.prevPosY;
        this.posZ = this.prevPosZ;
        final float lllllllllllIlllIlllIIlIlIllIllII = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleScale = this.rand.nextFloat() * 0.5f + 0.2f;
        this.oSize = this.particleScale;
        this.particleRed = 0.9f * lllllllllllIlllIlllIIlIlIllIllII;
        this.particleGreen = 0.9f * lllllllllllIlllIlllIIlIlIllIllII;
        this.particleBlue = lllllllllllIlllIlllIIlIlIllIllII;
        this.particleMaxAge = (int)(Math.random() * 10.0) + 30;
        this.setParticleTextureIndex((int)(Math.random() * 26.0 + 1.0 + 224.0));
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllIlllIlllIIlIlIlIIllll) {
        final int lllllllllllIlllIlllIIlIlIlIIlllI = super.getBrightnessForRender(lllllllllllIlllIlllIIlIlIlIIllll);
        float lllllllllllIlllIlllIIlIlIlIIllIl = this.particleAge / (float)this.particleMaxAge;
        lllllllllllIlllIlllIIlIlIlIIllIl *= lllllllllllIlllIlllIIlIlIlIIllIl;
        lllllllllllIlllIlllIIlIlIlIIllIl *= lllllllllllIlllIlllIIlIlIlIIllIl;
        final int lllllllllllIlllIlllIIlIlIlIIllII = lllllllllllIlllIlllIIlIlIlIIlllI & 0xFF;
        int lllllllllllIlllIlllIIlIlIlIIlIll = lllllllllllIlllIlllIIlIlIlIIlllI >> 16 & 0xFF;
        lllllllllllIlllIlllIIlIlIlIIlIll += (int)(lllllllllllIlllIlllIIlIlIlIIllIl * 15.0f * 16.0f);
        if (lllllllllllIlllIlllIIlIlIlIIlIll > 240) {
            lllllllllllIlllIlllIIlIlIlIIlIll = 240;
        }
        return lllllllllllIlllIlllIIlIlIlIIllII | lllllllllllIlllIlllIIlIlIlIIlIll << 16;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float lllllllllllIlllIlllIIlIlIlIIIIII = this.particleAge / (float)this.particleMaxAge;
        lllllllllllIlllIlllIIlIlIlIIIIII = 1.0f - lllllllllllIlllIlllIIlIlIlIIIIII;
        float lllllllllllIlllIlllIIlIlIIllllll = 1.0f - lllllllllllIlllIlllIIlIlIlIIIIII;
        lllllllllllIlllIlllIIlIlIIllllll *= lllllllllllIlllIlllIIlIlIIllllll;
        lllllllllllIlllIlllIIlIlIIllllll *= lllllllllllIlllIlllIIlIlIIllllll;
        this.posX = this.coordX + this.motionX * lllllllllllIlllIlllIIlIlIlIIIIII;
        this.posY = this.coordY + this.motionY * lllllllllllIlllIlllIIlIlIlIIIIII - lllllllllllIlllIlllIIlIlIIllllll * 1.2f;
        this.posZ = this.coordZ + this.motionZ * lllllllllllIlllIlllIIlIlIlIIIIII;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
    }
    
    public static class EnchantmentTable implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlllIlIllIlIlIIIllIlI, final World lllllllllllIlllIlIllIlIlIIIlIIIl, final double lllllllllllIlllIlIllIlIlIIIllIII, final double lllllllllllIlllIlIllIlIlIIIlIlll, final double lllllllllllIlllIlIllIlIlIIIlIllI, final double lllllllllllIlllIlIllIlIlIIIlIlIl, final double lllllllllllIlllIlIllIlIlIIIIllII, final double lllllllllllIlllIlIllIlIlIIIIlIll, final int... lllllllllllIlllIlIllIlIlIIIlIIlI) {
            return new ParticleEnchantmentTable(lllllllllllIlllIlIllIlIlIIIlIIIl, lllllllllllIlllIlIllIlIlIIIllIII, lllllllllllIlllIlIllIlIlIIIlIlll, lllllllllllIlllIlIllIlIlIIIlIllI, lllllllllllIlllIlIllIlIlIIIlIlIl, lllllllllllIlllIlIllIlIlIIIIllII, lllllllllllIlllIlIllIlIlIIIIlIll);
        }
    }
}
