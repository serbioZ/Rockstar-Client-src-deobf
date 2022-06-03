// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.texture.TextureManager;

public class ParticleExplosionLarge extends Particle
{
    private /* synthetic */ int life;
    private final /* synthetic */ TextureManager theRenderEngine;
    private static final /* synthetic */ VertexFormat VERTEX_FORMAT;
    private final /* synthetic */ float size;
    private final /* synthetic */ int lifeTime;
    private static final /* synthetic */ ResourceLocation EXPLOSION_TEXTURE;
    
    @Override
    public int getFXLayer() {
        return 3;
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
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllIlllIIlllIIllllllIIIl, final Entity lllllllllllIlllIIlllIlIIIIIIIIlI, final float lllllllllllIlllIIlllIlIIIIIIIIIl, final float lllllllllllIlllIIlllIIlllllIllll, final float lllllllllllIlllIIlllIIllllllllll, final float lllllllllllIlllIIlllIIlllllIllIl, final float lllllllllllIlllIIlllIIllllllllIl, final float lllllllllllIlllIIlllIIllllllllII) {
        final int lllllllllllIlllIIlllIIlllllllIll = (int)((this.life + lllllllllllIlllIIlllIlIIIIIIIIIl) * 15.0f / this.lifeTime);
        if (lllllllllllIlllIIlllIIlllllllIll <= 15) {
            this.theRenderEngine.bindTexture(ParticleExplosionLarge.EXPLOSION_TEXTURE);
            final float lllllllllllIlllIIlllIIlllllllIlI = lllllllllllIlllIIlllIIlllllllIll % 4 / 4.0f;
            final float lllllllllllIlllIIlllIIlllllllIIl = lllllllllllIlllIIlllIIlllllllIlI + 0.24975f;
            final float lllllllllllIlllIIlllIIlllllllIII = lllllllllllIlllIIlllIIlllllllIll / 4 / 4.0f;
            final float lllllllllllIlllIIlllIIllllllIlll = lllllllllllIlllIIlllIIlllllllIII + 0.24975f;
            final float lllllllllllIlllIIlllIIllllllIllI = 2.0f * this.size;
            final float lllllllllllIlllIIlllIIllllllIlIl = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllIlllIIlllIlIIIIIIIIIl - ParticleExplosionLarge.interpPosX);
            final float lllllllllllIlllIIlllIIllllllIlII = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllIlllIIlllIlIIIIIIIIIl - ParticleExplosionLarge.interpPosY);
            final float lllllllllllIlllIIlllIIllllllIIll = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllIlllIIlllIlIIIIIIIIIl - ParticleExplosionLarge.interpPosZ);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            RenderHelper.disableStandardItemLighting();
            lllllllllllIlllIIlllIIllllllIIIl.begin(7, ParticleExplosionLarge.VERTEX_FORMAT);
            lllllllllllIlllIIlllIIllllllIIIl.pos(lllllllllllIlllIIlllIIllllllIlIl - lllllllllllIlllIIlllIIlllllIllll * lllllllllllIlllIIlllIIllllllIllI - lllllllllllIlllIIlllIIllllllllIl * lllllllllllIlllIIlllIIllllllIllI, lllllllllllIlllIIlllIIllllllIlII - lllllllllllIlllIIlllIIllllllllll * lllllllllllIlllIIlllIIllllllIllI, lllllllllllIlllIIlllIIllllllIIll - lllllllllllIlllIIlllIIlllllIllIl * lllllllllllIlllIIlllIIllllllIllI - lllllllllllIlllIIlllIIllllllllII * lllllllllllIlllIIlllIIllllllIllI).tex(lllllllllllIlllIIlllIIlllllllIIl, lllllllllllIlllIIlllIIllllllIlll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllIlllIIlllIIllllllIIIl.pos(lllllllllllIlllIIlllIIllllllIlIl - lllllllllllIlllIIlllIIlllllIllll * lllllllllllIlllIIlllIIllllllIllI + lllllllllllIlllIIlllIIllllllllIl * lllllllllllIlllIIlllIIllllllIllI, lllllllllllIlllIIlllIIllllllIlII + lllllllllllIlllIIlllIIllllllllll * lllllllllllIlllIIlllIIllllllIllI, lllllllllllIlllIIlllIIllllllIIll - lllllllllllIlllIIlllIIlllllIllIl * lllllllllllIlllIIlllIIllllllIllI + lllllllllllIlllIIlllIIllllllllII * lllllllllllIlllIIlllIIllllllIllI).tex(lllllllllllIlllIIlllIIlllllllIIl, lllllllllllIlllIIlllIIlllllllIII).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllIlllIIlllIIllllllIIIl.pos(lllllllllllIlllIIlllIIllllllIlIl + lllllllllllIlllIIlllIIlllllIllll * lllllllllllIlllIIlllIIllllllIllI + lllllllllllIlllIIlllIIllllllllIl * lllllllllllIlllIIlllIIllllllIllI, lllllllllllIlllIIlllIIllllllIlII + lllllllllllIlllIIlllIIllllllllll * lllllllllllIlllIIlllIIllllllIllI, lllllllllllIlllIIlllIIllllllIIll + lllllllllllIlllIIlllIIlllllIllIl * lllllllllllIlllIIlllIIllllllIllI + lllllllllllIlllIIlllIIllllllllII * lllllllllllIlllIIlllIIllllllIllI).tex(lllllllllllIlllIIlllIIlllllllIlI, lllllllllllIlllIIlllIIlllllllIII).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllIlllIIlllIIllllllIIIl.pos(lllllllllllIlllIIlllIIllllllIlIl + lllllllllllIlllIIlllIIlllllIllll * lllllllllllIlllIIlllIIllllllIllI - lllllllllllIlllIIlllIIllllllllIl * lllllllllllIlllIIlllIIllllllIllI, lllllllllllIlllIIlllIIllllllIlII - lllllllllllIlllIIlllIIllllllllll * lllllllllllIlllIIlllIIllllllIllI, lllllllllllIlllIIlllIIllllllIIll + lllllllllllIlllIIlllIIlllllIllIl * lllllllllllIlllIIlllIIllllllIllI - lllllllllllIlllIIlllIIllllllllII * lllllllllllIlllIIlllIIllllllIllI).tex(lllllllllllIlllIIlllIIlllllllIlI, lllllllllllIlllIIlllIIllllllIlll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            Tessellator.getInstance().draw();
            GlStateManager.enableLighting();
        }
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllIlllIIlllIIlllllIIIII) {
        return 61680;
    }
    
    static {
        EXPLOSION_TEXTURE = new ResourceLocation("textures/entity/explosion.png");
        VERTEX_FORMAT = new VertexFormat().addElement(DefaultVertexFormats.POSITION_3F).addElement(DefaultVertexFormats.TEX_2F).addElement(DefaultVertexFormats.COLOR_4UB).addElement(DefaultVertexFormats.TEX_2S).addElement(DefaultVertexFormats.NORMAL_3B).addElement(DefaultVertexFormats.PADDING_1B);
    }
    
    protected ParticleExplosionLarge(final TextureManager lllllllllllIlllIIlllIlIIIIIlllII, final World lllllllllllIlllIIlllIlIIIIIllIll, final double lllllllllllIlllIIlllIlIIIIIllIlI, final double lllllllllllIlllIIlllIlIIIIlIIIll, final double lllllllllllIlllIIlllIlIIIIIllIII, final double lllllllllllIlllIIlllIlIIIIIlIlll, final double lllllllllllIlllIIlllIlIIIIlIIIII, final double lllllllllllIlllIIlllIlIIIIIlllll) {
        super(lllllllllllIlllIIlllIlIIIIIllIll, lllllllllllIlllIIlllIlIIIIIllIlI, lllllllllllIlllIIlllIlIIIIlIIIll, lllllllllllIlllIIlllIlIIIIIllIII, 0.0, 0.0, 0.0);
        this.theRenderEngine = lllllllllllIlllIIlllIlIIIIIlllII;
        this.lifeTime = 6 + this.rand.nextInt(4);
        final float lllllllllllIlllIIlllIlIIIIIllllI = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleRed = lllllllllllIlllIIlllIlIIIIIllllI;
        this.particleGreen = lllllllllllIlllIIlllIlIIIIIllllI;
        this.particleBlue = lllllllllllIlllIIlllIlIIIIIllllI;
        this.size = 1.0f - (float)lllllllllllIlllIIlllIlIIIIIlIlll * 0.5f;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIlIllIllIllllIllIIlI, final World llllllllllllIlIllIllIllllIllIIIl, final double llllllllllllIlIllIllIllllIlIlIII, final double llllllllllllIlIllIllIllllIlIllll, final double llllllllllllIlIllIllIllllIlIIllI, final double llllllllllllIlIllIllIllllIlIIlIl, final double llllllllllllIlIllIllIllllIlIllII, final double llllllllllllIlIllIllIllllIlIIIll, final int... llllllllllllIlIllIllIllllIlIlIlI) {
            return new ParticleExplosionLarge(Minecraft.getMinecraft().getTextureManager(), llllllllllllIlIllIllIllllIllIIIl, llllllllllllIlIllIllIllllIlIlIII, llllllllllllIlIllIllIllllIlIllll, llllllllllllIlIllIllIllllIlIIllI, llllllllllllIlIllIllIllllIlIIlIl, llllllllllllIlIllIllIllllIlIllII, llllllllllllIlIllIllIllllIlIIIll);
        }
    }
}
