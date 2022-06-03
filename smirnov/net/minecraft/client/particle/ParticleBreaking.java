// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ParticleBreaking extends Particle
{
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    protected ParticleBreaking(final World lllllllllllIIlIIIllIIlllIllllIll, final double lllllllllllIIlIIIllIIlllIlllIIII, final double lllllllllllIIlIIIllIIlllIllIllll, final double lllllllllllIIlIIIllIIlllIllllIII, final double lllllllllllIIlIIIllIIlllIllIllIl, final double lllllllllllIIlIIIllIIlllIllIllII, final double lllllllllllIIlIIIllIIlllIllIlIll, final Item lllllllllllIIlIIIllIIlllIlllIlII, final int lllllllllllIIlIIIllIIlllIlllIIll) {
        this(lllllllllllIIlIIIllIIlllIllllIll, lllllllllllIIlIIIllIIlllIlllIIII, lllllllllllIIlIIIllIIlllIllIllll, lllllllllllIIlIIIllIIlllIllllIII, lllllllllllIIlIIIllIIlllIlllIlII, lllllllllllIIlIIIllIIlllIlllIIll);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += lllllllllllIIlIIIllIIlllIllIllIl;
        this.motionY += lllllllllllIIlIIIllIIlllIllIllII;
        this.motionZ += lllllllllllIIlIIIllIIlllIllIlIll;
    }
    
    protected ParticleBreaking(final World lllllllllllIIlIIIllIIllllIIlIIIl, final double lllllllllllIIlIIIllIIllllIIlIIII, final double lllllllllllIIlIIIllIIllllIIIlIIl, final double lllllllllllIIlIIIllIIllllIIIlIII, final Item lllllllllllIIlIIIllIIllllIIIIlll) {
        this(lllllllllllIIlIIIllIIllllIIlIIIl, lllllllllllIIlIIIllIIllllIIlIIII, lllllllllllIIlIIIllIIllllIIIlIIl, lllllllllllIIlIIIllIIllllIIIlIII, lllllllllllIIlIIIllIIllllIIIIlll, 0);
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllIIlIIIllIIlllIIlIlIlI, final Entity lllllllllllIIlIIIllIIlllIIllllIl, final float lllllllllllIIlIIIllIIlllIIlIlIIl, final float lllllllllllIIlIIIllIIlllIIlllIll, final float lllllllllllIIlIIIllIIlllIIlIIlll, final float lllllllllllIIlIIIllIIlllIIlllIIl, final float lllllllllllIIlIIIllIIlllIIlllIII, final float lllllllllllIIlIIIllIIlllIIlIIlII) {
        float lllllllllllIIlIIIllIIlllIIllIllI = (this.particleTextureIndexX + this.particleTextureJitterX / 4.0f) / 16.0f;
        float lllllllllllIIlIIIllIIlllIIllIlIl = lllllllllllIIlIIIllIIlllIIllIllI + 0.015609375f;
        float lllllllllllIIlIIIllIIlllIIllIlII = (this.particleTextureIndexY + this.particleTextureJitterY / 4.0f) / 16.0f;
        float lllllllllllIIlIIIllIIlllIIllIIll = lllllllllllIIlIIIllIIlllIIllIlII + 0.015609375f;
        final float lllllllllllIIlIIIllIIlllIIllIIlI = 0.1f * this.particleScale;
        if (this.particleTexture != null) {
            lllllllllllIIlIIIllIIlllIIllIllI = this.particleTexture.getInterpolatedU(this.particleTextureJitterX / 4.0f * 16.0f);
            lllllllllllIIlIIIllIIlllIIllIlIl = this.particleTexture.getInterpolatedU((this.particleTextureJitterX + 1.0f) / 4.0f * 16.0f);
            lllllllllllIIlIIIllIIlllIIllIlII = this.particleTexture.getInterpolatedV(this.particleTextureJitterY / 4.0f * 16.0f);
            lllllllllllIIlIIIllIIlllIIllIIll = this.particleTexture.getInterpolatedV((this.particleTextureJitterY + 1.0f) / 4.0f * 16.0f);
        }
        final float lllllllllllIIlIIIllIIlllIIllIIIl = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllIIlIIIllIIlllIIlIlIIl - ParticleBreaking.interpPosX);
        final float lllllllllllIIlIIIllIIlllIIllIIII = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllIIlIIIllIIlllIIlIlIIl - ParticleBreaking.interpPosY);
        final float lllllllllllIIlIIIllIIlllIIlIllll = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllIIlIIIllIIlllIIlIlIIl - ParticleBreaking.interpPosZ);
        final int lllllllllllIIlIIIllIIlllIIlIlllI = this.getBrightnessForRender(lllllllllllIIlIIIllIIlllIIlIlIIl);
        final int lllllllllllIIlIIIllIIlllIIlIllIl = lllllllllllIIlIIIllIIlllIIlIlllI >> 16 & 0xFFFF;
        final int lllllllllllIIlIIIllIIlllIIlIllII = lllllllllllIIlIIIllIIlllIIlIlllI & 0xFFFF;
        lllllllllllIIlIIIllIIlllIIlIlIlI.pos(lllllllllllIIlIIIllIIlllIIllIIIl - lllllllllllIIlIIIllIIlllIIlllIll * lllllllllllIIlIIIllIIlllIIllIIlI - lllllllllllIIlIIIllIIlllIIlllIII * lllllllllllIIlIIIllIIlllIIllIIlI, lllllllllllIIlIIIllIIlllIIllIIII - lllllllllllIIlIIIllIIlllIIlIIlll * lllllllllllIIlIIIllIIlllIIllIIlI, lllllllllllIIlIIIllIIlllIIlIllll - lllllllllllIIlIIIllIIlllIIlllIIl * lllllllllllIIlIIIllIIlllIIllIIlI - lllllllllllIIlIIIllIIlllIIlIIlII * lllllllllllIIlIIIllIIlllIIllIIlI).tex(lllllllllllIIlIIIllIIlllIIllIllI, lllllllllllIIlIIIllIIlllIIllIIll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllIIlIIIllIIlllIIlIllIl, lllllllllllIIlIIIllIIlllIIlIllII).endVertex();
        lllllllllllIIlIIIllIIlllIIlIlIlI.pos(lllllllllllIIlIIIllIIlllIIllIIIl - lllllllllllIIlIIIllIIlllIIlllIll * lllllllllllIIlIIIllIIlllIIllIIlI + lllllllllllIIlIIIllIIlllIIlllIII * lllllllllllIIlIIIllIIlllIIllIIlI, lllllllllllIIlIIIllIIlllIIllIIII + lllllllllllIIlIIIllIIlllIIlIIlll * lllllllllllIIlIIIllIIlllIIllIIlI, lllllllllllIIlIIIllIIlllIIlIllll - lllllllllllIIlIIIllIIlllIIlllIIl * lllllllllllIIlIIIllIIlllIIllIIlI + lllllllllllIIlIIIllIIlllIIlIIlII * lllllllllllIIlIIIllIIlllIIllIIlI).tex(lllllllllllIIlIIIllIIlllIIllIllI, lllllllllllIIlIIIllIIlllIIllIlII).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllIIlIIIllIIlllIIlIllIl, lllllllllllIIlIIIllIIlllIIlIllII).endVertex();
        lllllllllllIIlIIIllIIlllIIlIlIlI.pos(lllllllllllIIlIIIllIIlllIIllIIIl + lllllllllllIIlIIIllIIlllIIlllIll * lllllllllllIIlIIIllIIlllIIllIIlI + lllllllllllIIlIIIllIIlllIIlllIII * lllllllllllIIlIIIllIIlllIIllIIlI, lllllllllllIIlIIIllIIlllIIllIIII + lllllllllllIIlIIIllIIlllIIlIIlll * lllllllllllIIlIIIllIIlllIIllIIlI, lllllllllllIIlIIIllIIlllIIlIllll + lllllllllllIIlIIIllIIlllIIlllIIl * lllllllllllIIlIIIllIIlllIIllIIlI + lllllllllllIIlIIIllIIlllIIlIIlII * lllllllllllIIlIIIllIIlllIIllIIlI).tex(lllllllllllIIlIIIllIIlllIIllIlIl, lllllllllllIIlIIIllIIlllIIllIlII).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllIIlIIIllIIlllIIlIllIl, lllllllllllIIlIIIllIIlllIIlIllII).endVertex();
        lllllllllllIIlIIIllIIlllIIlIlIlI.pos(lllllllllllIIlIIIllIIlllIIllIIIl + lllllllllllIIlIIIllIIlllIIlllIll * lllllllllllIIlIIIllIIlllIIllIIlI - lllllllllllIIlIIIllIIlllIIlllIII * lllllllllllIIlIIIllIIlllIIllIIlI, lllllllllllIIlIIIllIIlllIIllIIII - lllllllllllIIlIIIllIIlllIIlIIlll * lllllllllllIIlIIIllIIlllIIllIIlI, lllllllllllIIlIIIllIIlllIIlIllll + lllllllllllIIlIIIllIIlllIIlllIIl * lllllllllllIIlIIIllIIlllIIllIIlI - lllllllllllIIlIIIllIIlllIIlIIlII * lllllllllllIIlIIIllIIlllIIllIIlI).tex(lllllllllllIIlIIIllIIlllIIllIlIl, lllllllllllIIlIIIllIIlllIIllIIll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllIIlIIIllIIlllIIlIllIl, lllllllllllIIlIIIllIIlllIIlIllII).endVertex();
    }
    
    protected ParticleBreaking(final World lllllllllllIIlIIIllIIlllIlIllIIl, final double lllllllllllIIlIIIllIIlllIlIlllll, final double lllllllllllIIlIIIllIIlllIlIllllI, final double lllllllllllIIlIIIllIIlllIlIlIllI, final Item lllllllllllIIlIIIllIIlllIlIlllII, final int lllllllllllIIlIIIllIIlllIlIllIll) {
        super(lllllllllllIIlIIIllIIlllIlIllIIl, lllllllllllIIlIIIllIIlllIlIlllll, lllllllllllIIlIIIllIIlllIlIllllI, lllllllllllIIlIIIllIIlllIlIlIllI, 0.0, 0.0, 0.0);
        this.setParticleTexture(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(lllllllllllIIlIIIllIIlllIlIlllII, lllllllllllIIlIIIllIIlllIlIllIll));
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleGravity = Blocks.SNOW.blockParticleGravity;
        this.particleScale /= 2.0f;
    }
    
    public static class SlimeFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIllllIlIlIIIIIIIIlIl, final World llllllllllllIllllIlIIlllllllllII, final double llllllllllllIllllIlIIllllllllIll, final double llllllllllllIllllIlIIllllllllIlI, final double llllllllllllIllllIlIIllllllllIIl, final double llllllllllllIllllIlIlIIIIIIIIIII, final double llllllllllllIllllIlIIlllllllllll, final double llllllllllllIllllIlIIllllllllllI, final int... llllllllllllIllllIlIIlllllllllIl) {
            return new ParticleBreaking(llllllllllllIllllIlIIlllllllllII, llllllllllllIllllIlIIllllllllIll, llllllllllllIllllIlIIllllllllIlI, llllllllllllIllllIlIIllllllllIIl, Items.SLIME_BALL);
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllIlllIlllIIllIIIIIIllII, final World llllllllllIlllIlllIIllIIIIIIIIIl, final double llllllllllIlllIlllIIllIIIIIIIIII, final double llllllllllIlllIlllIIllIIIIIIlIIl, final double llllllllllIlllIlllIIllIIIIIIlIII, final double llllllllllIlllIlllIIlIllllllllIl, final double llllllllllIlllIlllIIlIllllllllII, final double llllllllllIlllIlllIIlIlllllllIll, final int... llllllllllIlllIlllIIllIIIIIIIlII) {
            final int llllllllllIlllIlllIIllIIIIIIIIll = (llllllllllIlllIlllIIllIIIIIIIlII.length > 1) ? llllllllllIlllIlllIIllIIIIIIIlII[1] : 0;
            return new ParticleBreaking(llllllllllIlllIlllIIllIIIIIIIIIl, llllllllllIlllIlllIIllIIIIIIIIII, llllllllllIlllIlllIIllIIIIIIlIIl, llllllllllIlllIlllIIllIIIIIIlIII, llllllllllIlllIlllIIlIllllllllIl, llllllllllIlllIlllIIlIllllllllII, llllllllllIlllIlllIIlIlllllllIll, Item.getItemById(llllllllllIlllIlllIIllIIIIIIIlII[0]), llllllllllIlllIlllIIllIIIIIIIIll);
        }
    }
    
    public static class SnowballFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIllIIllllIlIlIIIll, final World llllllllllllllIllIIllllIlIIllIlI, final double llllllllllllllIllIIllllIlIIllIIl, final double llllllllllllllIllIIllllIlIIllIII, final double llllllllllllllIllIIllllIlIIlIlll, final double llllllllllllllIllIIllllIlIIllllI, final double llllllllllllllIllIIllllIlIIlllIl, final double llllllllllllllIllIIllllIlIIlllII, final int... llllllllllllllIllIIllllIlIIllIll) {
            return new ParticleBreaking(llllllllllllllIllIIllllIlIIllIlI, llllllllllllllIllIIllllIlIIllIIl, llllllllllllllIllIIllllIlIIllIII, llllllllllllllIllIIllllIlIIlIlll, Items.SNOWBALL);
        }
    }
}
