// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class ParticleFootStep extends Particle
{
    private /* synthetic */ int footstepAge;
    private final /* synthetic */ int footstepMaxAge;
    private static final /* synthetic */ ResourceLocation FOOTPRINT_TEXTURE;
    private final /* synthetic */ TextureManager currentFootSteps;
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    protected ParticleFootStep(final TextureManager llllllllllIlllIIllllIIlllIIIllll, final World llllllllllIlllIIllllIIlllIIlIlII, final double llllllllllIlllIIllllIIlllIIIllIl, final double llllllllllIlllIIllllIIlllIIIllII, final double llllllllllIlllIIllllIIlllIIIlIll) {
        super(llllllllllIlllIIllllIIlllIIlIlII, llllllllllIlllIIllllIIlllIIIllIl, llllllllllIlllIIllllIIlllIIIllII, llllllllllIlllIIllllIIlllIIIlIll, 0.0, 0.0, 0.0);
        this.currentFootSteps = llllllllllIlllIIllllIIlllIIIllll;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.footstepMaxAge = 200;
    }
    
    static {
        FOOTPRINT_TEXTURE = new ResourceLocation("textures/particle/footprint.png");
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllIlllIIllllIIllIlllllll, final Entity llllllllllIlllIIllllIIllIllllllI, final float llllllllllIlllIIllllIIllIllIlllI, final float llllllllllIlllIIllllIIllIlllllII, final float llllllllllIlllIIllllIIllIllllIll, final float llllllllllIlllIIllllIIllIllllIlI, final float llllllllllIlllIIllllIIllIllllIIl, final float llllllllllIlllIIllllIIllIllllIII) {
        float llllllllllIlllIIllllIIllIlllIlll = (this.footstepAge + llllllllllIlllIIllllIIllIllIlllI) / this.footstepMaxAge;
        llllllllllIlllIIllllIIllIlllIlll *= llllllllllIlllIIllllIIllIlllIlll;
        float llllllllllIlllIIllllIIllIlllIllI = 2.0f - llllllllllIlllIIllllIIllIlllIlll * 2.0f;
        if (llllllllllIlllIIllllIIllIlllIllI > 1.0f) {
            llllllllllIlllIIllllIIllIlllIllI = 1.0f;
        }
        llllllllllIlllIIllllIIllIlllIllI *= 0.2f;
        GlStateManager.disableLighting();
        final float llllllllllIlllIIllllIIllIlllIlIl = 0.125f;
        final float llllllllllIlllIIllllIIllIlllIlII = (float)(this.posX - ParticleFootStep.interpPosX);
        final float llllllllllIlllIIllllIIllIlllIIll = (float)(this.posY - ParticleFootStep.interpPosY);
        final float llllllllllIlllIIllllIIllIlllIIlI = (float)(this.posZ - ParticleFootStep.interpPosZ);
        final float llllllllllIlllIIllllIIllIlllIIIl = this.worldObj.getLightBrightness(new BlockPos(this.posX, this.posY, this.posZ));
        this.currentFootSteps.bindTexture(ParticleFootStep.FOOTPRINT_TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        llllllllllIlllIIllllIIllIlllllll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllIlllIIllllIIllIlllllll.pos(llllllllllIlllIIllllIIllIlllIlII - 0.125f, llllllllllIlllIIllllIIllIlllIIll, llllllllllIlllIIllllIIllIlllIIlI + 0.125f).tex(0.0, 1.0).color(llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIllI).endVertex();
        llllllllllIlllIIllllIIllIlllllll.pos(llllllllllIlllIIllllIIllIlllIlII + 0.125f, llllllllllIlllIIllllIIllIlllIIll, llllllllllIlllIIllllIIllIlllIIlI + 0.125f).tex(1.0, 1.0).color(llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIllI).endVertex();
        llllllllllIlllIIllllIIllIlllllll.pos(llllllllllIlllIIllllIIllIlllIlII + 0.125f, llllllllllIlllIIllllIIllIlllIIll, llllllllllIlllIIllllIIllIlllIIlI - 0.125f).tex(1.0, 0.0).color(llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIllI).endVertex();
        llllllllllIlllIIllllIIllIlllllll.pos(llllllllllIlllIIllllIIllIlllIlII - 0.125f, llllllllllIlllIIllllIIllIlllIIll, llllllllllIlllIIllllIIllIlllIIlI - 0.125f).tex(0.0, 0.0).color(llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIIIl, llllllllllIlllIIllllIIllIlllIllI).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
    }
    
    @Override
    public void onUpdate() {
        ++this.footstepAge;
        if (this.footstepAge == this.footstepMaxAge) {
            this.setExpired();
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIIIIlIIllIllllIIlllI, final World llllllllllllIIIIlIIllIllllIIIlIl, final double llllllllllllIIIIlIIllIllllIIIlII, final double llllllllllllIIIIlIIllIllllIIlIll, final double llllllllllllIIIIlIIllIllllIIIIlI, final double llllllllllllIIIIlIIllIllllIIlIIl, final double llllllllllllIIIIlIIllIllllIIlIII, final double llllllllllllIIIIlIIllIllllIIIlll, final int... llllllllllllIIIIlIIllIllllIIIllI) {
            return new ParticleFootStep(Minecraft.getMinecraft().getTextureManager(), llllllllllllIIIIlIIllIllllIIIlIl, llllllllllllIIIIlIIllIllllIIIlII, llllllllllllIIIIlIIllIllllIIlIll, llllllllllllIIIIlIIllIllllIIIIlI);
        }
    }
}
