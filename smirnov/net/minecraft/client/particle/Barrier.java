// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class Barrier extends Particle
{
    protected Barrier(final World llllllllllllIIIIIIIIIIIlIlllIIlI, final double llllllllllllIIIIIIIIIIIlIlllIlll, final double llllllllllllIIIIIIIIIIIlIlllIllI, final double llllllllllllIIIIIIIIIIIlIllIllll, final Item llllllllllllIIIIIIIIIIIlIlllIlII) {
        super(llllllllllllIIIIIIIIIIIlIlllIIlI, llllllllllllIIIIIIIIIIIlIlllIlll, llllllllllllIIIIIIIIIIIlIlllIllI, llllllllllllIIIIIIIIIIIlIllIllll, 0.0, 0.0, 0.0);
        this.setParticleTexture(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(llllllllllllIIIIIIIIIIIlIlllIlII));
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleGravity = 0.0f;
        this.particleMaxAge = 80;
    }
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllIIIIIIIIIIIlIlIllIII, final Entity llllllllllllIIIIIIIIIIIlIlIlIlll, final float llllllllllllIIIIIIIIIIIlIlIIIIll, final float llllllllllllIIIIIIIIIIIlIlIIIIlI, final float llllllllllllIIIIIIIIIIIlIlIlIlII, final float llllllllllllIIIIIIIIIIIlIlIlIIll, final float llllllllllllIIIIIIIIIIIlIlIlIIlI, final float llllllllllllIIIIIIIIIIIlIlIlIIIl) {
        final float llllllllllllIIIIIIIIIIIlIlIlIIII = this.particleTexture.getMinU();
        final float llllllllllllIIIIIIIIIIIlIlIIllll = this.particleTexture.getMaxU();
        final float llllllllllllIIIIIIIIIIIlIlIIlllI = this.particleTexture.getMinV();
        final float llllllllllllIIIIIIIIIIIlIlIIllIl = this.particleTexture.getMaxV();
        final float llllllllllllIIIIIIIIIIIlIlIIllII = 0.5f;
        final float llllllllllllIIIIIIIIIIIlIlIIlIll = (float)(this.prevPosX + (this.posX - this.prevPosX) * llllllllllllIIIIIIIIIIIlIlIIIIll - Barrier.interpPosX);
        final float llllllllllllIIIIIIIIIIIlIlIIlIlI = (float)(this.prevPosY + (this.posY - this.prevPosY) * llllllllllllIIIIIIIIIIIlIlIIIIll - Barrier.interpPosY);
        final float llllllllllllIIIIIIIIIIIlIlIIlIIl = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * llllllllllllIIIIIIIIIIIlIlIIIIll - Barrier.interpPosZ);
        final int llllllllllllIIIIIIIIIIIlIlIIlIII = this.getBrightnessForRender(llllllllllllIIIIIIIIIIIlIlIIIIll);
        final int llllllllllllIIIIIIIIIIIlIlIIIlll = llllllllllllIIIIIIIIIIIlIlIIlIII >> 16 & 0xFFFF;
        final int llllllllllllIIIIIIIIIIIlIlIIIllI = llllllllllllIIIIIIIIIIIlIlIIlIII & 0xFFFF;
        llllllllllllIIIIIIIIIIIlIlIllIII.pos(llllllllllllIIIIIIIIIIIlIlIIlIll - llllllllllllIIIIIIIIIIIlIlIIIIlI * 0.5f - llllllllllllIIIIIIIIIIIlIlIlIIlI * 0.5f, llllllllllllIIIIIIIIIIIlIlIIlIlI - llllllllllllIIIIIIIIIIIlIlIlIlII * 0.5f, llllllllllllIIIIIIIIIIIlIlIIlIIl - llllllllllllIIIIIIIIIIIlIlIlIIll * 0.5f - llllllllllllIIIIIIIIIIIlIlIlIIIl * 0.5f).tex(llllllllllllIIIIIIIIIIIlIlIIllll, llllllllllllIIIIIIIIIIIlIlIIllIl).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(llllllllllllIIIIIIIIIIIlIlIIIlll, llllllllllllIIIIIIIIIIIlIlIIIllI).endVertex();
        llllllllllllIIIIIIIIIIIlIlIllIII.pos(llllllllllllIIIIIIIIIIIlIlIIlIll - llllllllllllIIIIIIIIIIIlIlIIIIlI * 0.5f + llllllllllllIIIIIIIIIIIlIlIlIIlI * 0.5f, llllllllllllIIIIIIIIIIIlIlIIlIlI + llllllllllllIIIIIIIIIIIlIlIlIlII * 0.5f, llllllllllllIIIIIIIIIIIlIlIIlIIl - llllllllllllIIIIIIIIIIIlIlIlIIll * 0.5f + llllllllllllIIIIIIIIIIIlIlIlIIIl * 0.5f).tex(llllllllllllIIIIIIIIIIIlIlIIllll, llllllllllllIIIIIIIIIIIlIlIIlllI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(llllllllllllIIIIIIIIIIIlIlIIIlll, llllllllllllIIIIIIIIIIIlIlIIIllI).endVertex();
        llllllllllllIIIIIIIIIIIlIlIllIII.pos(llllllllllllIIIIIIIIIIIlIlIIlIll + llllllllllllIIIIIIIIIIIlIlIIIIlI * 0.5f + llllllllllllIIIIIIIIIIIlIlIlIIlI * 0.5f, llllllllllllIIIIIIIIIIIlIlIIlIlI + llllllllllllIIIIIIIIIIIlIlIlIlII * 0.5f, llllllllllllIIIIIIIIIIIlIlIIlIIl + llllllllllllIIIIIIIIIIIlIlIlIIll * 0.5f + llllllllllllIIIIIIIIIIIlIlIlIIIl * 0.5f).tex(llllllllllllIIIIIIIIIIIlIlIlIIII, llllllllllllIIIIIIIIIIIlIlIIlllI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(llllllllllllIIIIIIIIIIIlIlIIIlll, llllllllllllIIIIIIIIIIIlIlIIIllI).endVertex();
        llllllllllllIIIIIIIIIIIlIlIllIII.pos(llllllllllllIIIIIIIIIIIlIlIIlIll + llllllllllllIIIIIIIIIIIlIlIIIIlI * 0.5f - llllllllllllIIIIIIIIIIIlIlIlIIlI * 0.5f, llllllllllllIIIIIIIIIIIlIlIIlIlI - llllllllllllIIIIIIIIIIIlIlIlIlII * 0.5f, llllllllllllIIIIIIIIIIIlIlIIlIIl + llllllllllllIIIIIIIIIIIlIlIlIIll * 0.5f - llllllllllllIIIIIIIIIIIlIlIlIIIl * 0.5f).tex(llllllllllllIIIIIIIIIIIlIlIlIIII, llllllllllllIIIIIIIIIIIlIlIIllIl).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(llllllllllllIIIIIIIIIIIlIlIIIlll, llllllllllllIIIIIIIIIIIlIlIIIllI).endVertex();
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIIllllIllllIIllIlIIll, final World lllllllllllIIllllIllllIIllIlIIlI, final double lllllllllllIIllllIllllIIllIlIIIl, final double lllllllllllIIllllIllllIIllIIlIII, final double lllllllllllIIllllIllllIIllIIIlll, final double lllllllllllIIllllIllllIIllIIlllI, final double lllllllllllIIllllIllllIIllIIllIl, final double lllllllllllIIllllIllllIIllIIllII, final int... lllllllllllIIllllIllllIIllIIlIll) {
            return new Barrier(lllllllllllIIllllIllllIIllIlIIlI, lllllllllllIIllllIllllIIllIlIIIl, lllllllllllIIllllIllllIIllIIlIII, lllllllllllIIllllIllllIIllIIIlll, Item.getItemFromBlock(Blocks.BARRIER));
        }
    }
}
