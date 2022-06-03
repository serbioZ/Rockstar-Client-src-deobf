// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;

public class ParticleSimpleAnimated extends Particle
{
    private /* synthetic */ float fadeTargetBlue;
    private /* synthetic */ float fadeTargetGreen;
    private /* synthetic */ float field_191239_M;
    private final /* synthetic */ int numAgingFrames;
    private /* synthetic */ boolean fadingColor;
    private final /* synthetic */ int textureIdx;
    private final /* synthetic */ float yAccel;
    private /* synthetic */ float fadeTargetRed;
    
    public ParticleSimpleAnimated(final World llllllllllllIIIIIIIllIllllIIlllI, final double llllllllllllIIIIIIIllIllllIIIlIl, final double llllllllllllIIIIIIIllIllllIIIlII, final double llllllllllllIIIIIIIllIllllIIIIll, final int llllllllllllIIIIIIIllIllllIIIIlI, final int llllllllllllIIIIIIIllIllllIIlIIl, final float llllllllllllIIIIIIIllIllllIIlIII) {
        super(llllllllllllIIIIIIIllIllllIIlllI, llllllllllllIIIIIIIllIllllIIIlIl, llllllllllllIIIIIIIllIllllIIIlII, llllllllllllIIIIIIIllIllllIIIIll);
        this.field_191239_M = 0.91f;
        this.textureIdx = llllllllllllIIIIIIIllIllllIIIIlI;
        this.numAgingFrames = llllllllllllIIIIIIIllIllllIIlIIl;
        this.yAccel = llllllllllllIIIIIIIllIllllIIlIII;
    }
    
    @Override
    public boolean isTransparent() {
        return true;
    }
    
    public void setColorFade(final int llllllllllllIIIIIIIllIlllIlIlIII) {
        this.fadeTargetRed = ((llllllllllllIIIIIIIllIlllIlIlIII & 0xFF0000) >> 16) / 255.0f;
        this.fadeTargetGreen = ((llllllllllllIIIIIIIllIlllIlIlIII & 0xFF00) >> 8) / 255.0f;
        this.fadeTargetBlue = ((llllllllllllIIIIIIIllIlllIlIlIII & 0xFF) >> 0) / 255.0f;
        this.fadingColor = true;
    }
    
    protected void func_191238_f(final float llllllllllllIIIIIIIllIlllIIllllI) {
        this.field_191239_M = llllllllllllIIIIIIIllIlllIIllllI;
    }
    
    public void setColor(final int llllllllllllIIIIIIIllIlllIlllIII) {
        final float llllllllllllIIIIIIIllIlllIllIlll = ((llllllllllllIIIIIIIllIlllIlllIII & 0xFF0000) >> 16) / 255.0f;
        final float llllllllllllIIIIIIIllIlllIllIllI = ((llllllllllllIIIIIIIllIlllIlllIII & 0xFF00) >> 8) / 255.0f;
        final float llllllllllllIIIIIIIllIlllIllIlIl = ((llllllllllllIIIIIIIllIlllIlllIII & 0xFF) >> 0) / 255.0f;
        final float llllllllllllIIIIIIIllIlllIllIlII = 1.0f;
        this.setRBGColorF(llllllllllllIIIIIIIllIlllIllIlll * 1.0f, llllllllllllIIIIIIIllIlllIllIllI * 1.0f, llllllllllllIIIIIIIllIlllIllIlIl * 1.0f);
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        if (this.particleAge > this.particleMaxAge / 2) {
            this.setAlphaF(1.0f - (this.particleAge - (float)(this.particleMaxAge / 2)) / this.particleMaxAge);
            if (this.fadingColor) {
                this.particleRed += (this.fadeTargetRed - this.particleRed) * 0.2f;
                this.particleGreen += (this.fadeTargetGreen - this.particleGreen) * 0.2f;
                this.particleBlue += (this.fadeTargetBlue - this.particleBlue) * 0.2f;
            }
        }
        this.setParticleTextureIndex(this.textureIdx + (this.numAgingFrames - 1 - this.particleAge * this.numAgingFrames / this.particleMaxAge));
        this.motionY += this.yAccel;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= this.field_191239_M;
        this.motionY *= this.field_191239_M;
        this.motionZ *= this.field_191239_M;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllIIIIIIIllIlllIlIIIlI) {
        return 15728880;
    }
}
