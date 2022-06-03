// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class ParticleSweepAttack extends Particle
{
    private static final /* synthetic */ ResourceLocation SWEEP_TEXTURE;
    private /* synthetic */ int life;
    private final /* synthetic */ float size;
    private final /* synthetic */ TextureManager textureManager;
    private static final /* synthetic */ VertexFormat VERTEX_FORMAT;
    private final /* synthetic */ int lifeTime;
    
    static {
        SWEEP_TEXTURE = new ResourceLocation("textures/entity/sweep.png");
        VERTEX_FORMAT = new VertexFormat().addElement(DefaultVertexFormats.POSITION_3F).addElement(DefaultVertexFormats.TEX_2F).addElement(DefaultVertexFormats.COLOR_4UB).addElement(DefaultVertexFormats.TEX_2S).addElement(DefaultVertexFormats.NORMAL_3B).addElement(DefaultVertexFormats.PADDING_1B);
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.life;
        if (this.life == this.lifeTime) {
            this.setExpired();
        }
    }
    
    protected ParticleSweepAttack(final TextureManager llllllllllllIlllIllIIllIlIIIIIlI, final World llllllllllllIlllIllIIllIIlllIlll, final double llllllllllllIlllIllIIllIIlllIllI, final double llllllllllllIlllIllIIllIIlllllll, final double llllllllllllIlllIllIIllIIllllllI, final double llllllllllllIlllIllIIllIIlllIIll, final double llllllllllllIlllIllIIllIIlllllII, final double llllllllllllIlllIllIIllIIllllIll) {
        super(llllllllllllIlllIllIIllIIlllIlll, llllllllllllIlllIllIIllIIlllIllI, llllllllllllIlllIllIIllIIlllllll, llllllllllllIlllIllIIllIIllllllI, 0.0, 0.0, 0.0);
        this.textureManager = llllllllllllIlllIllIIllIlIIIIIlI;
        this.lifeTime = 4;
        final float llllllllllllIlllIllIIllIIllllIlI = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleRed = llllllllllllIlllIllIIllIIllllIlI;
        this.particleGreen = llllllllllllIlllIllIIllIIllllIlI;
        this.particleBlue = llllllllllllIlllIllIIllIIllllIlI;
        this.size = 1.0f - (float)llllllllllllIlllIllIIllIIlllIIll * 0.5f;
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllIlllIllIIllIIIllllII) {
        return 61680;
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllIlllIllIIllIIlIIllIl, final Entity llllllllllllIlllIllIIllIIlIllllI, final float llllllllllllIlllIllIIllIIlIlllIl, final float llllllllllllIlllIllIIllIIlIlllII, final float llllllllllllIlllIllIIllIIlIIlIlI, final float llllllllllllIlllIllIIllIIlIllIlI, final float llllllllllllIlllIllIIllIIlIllIIl, final float llllllllllllIlllIllIIllIIlIllIII) {
        final int llllllllllllIlllIllIIllIIlIlIlll = (int)((this.life + llllllllllllIlllIllIIllIIlIlllIl) * 3.0f / this.lifeTime);
        if (llllllllllllIlllIllIIllIIlIlIlll <= 7) {
            this.textureManager.bindTexture(ParticleSweepAttack.SWEEP_TEXTURE);
            final float llllllllllllIlllIllIIllIIlIlIllI = llllllllllllIlllIllIIllIIlIlIlll % 4 / 4.0f;
            final float llllllllllllIlllIllIIllIIlIlIlIl = llllllllllllIlllIllIIllIIlIlIllI + 0.24975f;
            final float llllllllllllIlllIllIIllIIlIlIlII = llllllllllllIlllIllIIllIIlIlIlll / 2 / 2.0f;
            final float llllllllllllIlllIllIIllIIlIlIIll = llllllllllllIlllIllIIllIIlIlIlII + 0.4995f;
            final float llllllllllllIlllIllIIllIIlIlIIlI = 1.0f * this.size;
            final float llllllllllllIlllIllIIllIIlIlIIIl = (float)(this.prevPosX + (this.posX - this.prevPosX) * llllllllllllIlllIllIIllIIlIlllIl - ParticleSweepAttack.interpPosX);
            final float llllllllllllIlllIllIIllIIlIlIIII = (float)(this.prevPosY + (this.posY - this.prevPosY) * llllllllllllIlllIllIIllIIlIlllIl - ParticleSweepAttack.interpPosY);
            final float llllllllllllIlllIllIIllIIlIIllll = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * llllllllllllIlllIllIIllIIlIlllIl - ParticleSweepAttack.interpPosZ);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            RenderHelper.disableStandardItemLighting();
            llllllllllllIlllIllIIllIIlIIllIl.begin(7, ParticleSweepAttack.VERTEX_FORMAT);
            llllllllllllIlllIllIIllIIlIIllIl.pos(llllllllllllIlllIllIIllIIlIlIIIl - llllllllllllIlllIllIIllIIlIlllII * llllllllllllIlllIllIIllIIlIlIIlI - llllllllllllIlllIllIIllIIlIllIIl * llllllllllllIlllIllIIllIIlIlIIlI, llllllllllllIlllIllIIllIIlIlIIII - llllllllllllIlllIllIIllIIlIIlIlI * llllllllllllIlllIllIIllIIlIlIIlI * 0.5f, llllllllllllIlllIllIIllIIlIIllll - llllllllllllIlllIllIIllIIlIllIlI * llllllllllllIlllIllIIllIIlIlIIlI - llllllllllllIlllIllIIllIIlIllIII * llllllllllllIlllIllIIllIIlIlIIlI).tex(llllllllllllIlllIllIIllIIlIlIlIl, llllllllllllIlllIllIIllIIlIlIIll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllIlllIllIIllIIlIIllIl.pos(llllllllllllIlllIllIIllIIlIlIIIl - llllllllllllIlllIllIIllIIlIlllII * llllllllllllIlllIllIIllIIlIlIIlI + llllllllllllIlllIllIIllIIlIllIIl * llllllllllllIlllIllIIllIIlIlIIlI, llllllllllllIlllIllIIllIIlIlIIII + llllllllllllIlllIllIIllIIlIIlIlI * llllllllllllIlllIllIIllIIlIlIIlI * 0.5f, llllllllllllIlllIllIIllIIlIIllll - llllllllllllIlllIllIIllIIlIllIlI * llllllllllllIlllIllIIllIIlIlIIlI + llllllllllllIlllIllIIllIIlIllIII * llllllllllllIlllIllIIllIIlIlIIlI).tex(llllllllllllIlllIllIIllIIlIlIlIl, llllllllllllIlllIllIIllIIlIlIlII).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllIlllIllIIllIIlIIllIl.pos(llllllllllllIlllIllIIllIIlIlIIIl + llllllllllllIlllIllIIllIIlIlllII * llllllllllllIlllIllIIllIIlIlIIlI + llllllllllllIlllIllIIllIIlIllIIl * llllllllllllIlllIllIIllIIlIlIIlI, llllllllllllIlllIllIIllIIlIlIIII + llllllllllllIlllIllIIllIIlIIlIlI * llllllllllllIlllIllIIllIIlIlIIlI * 0.5f, llllllllllllIlllIllIIllIIlIIllll + llllllllllllIlllIllIIllIIlIllIlI * llllllllllllIlllIllIIllIIlIlIIlI + llllllllllllIlllIllIIllIIlIllIII * llllllllllllIlllIllIIllIIlIlIIlI).tex(llllllllllllIlllIllIIllIIlIlIllI, llllllllllllIlllIllIIllIIlIlIlII).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllIlllIllIIllIIlIIllIl.pos(llllllllllllIlllIllIIllIIlIlIIIl + llllllllllllIlllIllIIllIIlIlllII * llllllllllllIlllIllIIllIIlIlIIlI - llllllllllllIlllIllIIllIIlIllIIl * llllllllllllIlllIllIIllIIlIlIIlI, llllllllllllIlllIllIIllIIlIlIIII - llllllllllllIlllIllIIllIIlIIlIlI * llllllllllllIlllIllIIllIIlIlIIlI * 0.5f, llllllllllllIlllIllIIllIIlIIllll + llllllllllllIlllIllIIllIIlIllIlI * llllllllllllIlllIllIIllIIlIlIIlI - llllllllllllIlllIllIIllIIlIllIII * llllllllllllIlllIllIIllIIlIlIIlI).tex(llllllllllllIlllIllIIllIIlIlIllI, llllllllllllIlllIllIIllIIlIlIIll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            Tessellator.getInstance().draw();
            GlStateManager.enableLighting();
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIlIlIlIlllllllIllIlIl, final World lllllllllllIlIlIlIlllllllIllIlII, final double lllllllllllIlIlIlIlllllllIllIIll, final double lllllllllllIlIlIlIlllllllIlIlIlI, final double lllllllllllIlIlIlIlllllllIlIlIIl, final double lllllllllllIlIlIlIlllllllIllIIII, final double lllllllllllIlIlIlIlllllllIlIllll, final double lllllllllllIlIlIlIlllllllIlIlllI, final int... lllllllllllIlIlIlIlllllllIlIllIl) {
            return new ParticleSweepAttack(Minecraft.getMinecraft().getTextureManager(), lllllllllllIlIlIlIlllllllIllIlII, lllllllllllIlIlIlIlllllllIllIIll, lllllllllllIlIlIlIlllllllIlIlIlI, lllllllllllIlIlIlIlllllllIlIlIIl, lllllllllllIlIlIlIlllllllIllIIII, lllllllllllIlIlIlIlllllllIlIllll, lllllllllllIlIlIlIlllllllIlIlllI);
        }
    }
}
