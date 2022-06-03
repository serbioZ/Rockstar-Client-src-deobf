// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import shadersmod.client.Shaders;
import optifine.Config;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;

public class ParticleItemPickup extends Particle
{
    private /* synthetic */ int age;
    private final /* synthetic */ float yOffset;
    private final /* synthetic */ Entity item;
    private final /* synthetic */ Entity target;
    private final /* synthetic */ RenderManager renderManager;
    private final /* synthetic */ int maxAge;
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    public ParticleItemPickup(final World lllllllllllllllIIIIIIlllllIllIII, final Entity lllllllllllllllIIIIIIlllllIlIIlI, final Entity lllllllllllllllIIIIIIlllllIlIllI, final float lllllllllllllllIIIIIIlllllIlIlIl) {
        super(lllllllllllllllIIIIIIlllllIllIII, lllllllllllllllIIIIIIlllllIlIIlI.posX, lllllllllllllllIIIIIIlllllIlIIlI.posY, lllllllllllllllIIIIIIlllllIlIIlI.posZ, lllllllllllllllIIIIIIlllllIlIIlI.motionX, lllllllllllllllIIIIIIlllllIlIIlI.motionY, lllllllllllllllIIIIIIlllllIlIIlI.motionZ);
        this.renderManager = Minecraft.getMinecraft().getRenderManager();
        this.item = lllllllllllllllIIIIIIlllllIlIIlI;
        this.target = lllllllllllllllIIIIIIlllllIlIllI;
        this.maxAge = 3;
        this.yOffset = lllllllllllllllIIIIIIlllllIlIlIl;
    }
    
    @Override
    public void onUpdate() {
        ++this.age;
        if (this.age == this.maxAge) {
            this.setExpired();
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllllIIIIIIllllIlllllI, final Entity lllllllllllllllIIIIIIllllIllllIl, final float lllllllllllllllIIIIIIllllIllllII, final float lllllllllllllllIIIIIIllllIlllIll, final float lllllllllllllllIIIIIIllllIlllIlI, final float lllllllllllllllIIIIIIllllIlllIIl, final float lllllllllllllllIIIIIIllllIlllIII, final float lllllllllllllllIIIIIIllllIllIlll) {
        int lllllllllllllllIIIIIIllllIllIllI = 0;
        if (Config.isShaders()) {
            lllllllllllllllIIIIIIllllIllIllI = Shaders.activeProgram;
            Shaders.nextEntity(this.item);
        }
        float lllllllllllllllIIIIIIllllIllIlIl = (this.age + lllllllllllllllIIIIIIllllIllllII) / this.maxAge;
        lllllllllllllllIIIIIIllllIllIlIl *= lllllllllllllllIIIIIIllllIllIlIl;
        final double lllllllllllllllIIIIIIllllIllIlII = this.item.posX;
        final double lllllllllllllllIIIIIIllllIllIIll = this.item.posY;
        final double lllllllllllllllIIIIIIllllIllIIlI = this.item.posZ;
        final double lllllllllllllllIIIIIIllllIllIIIl = this.target.lastTickPosX + (this.target.posX - this.target.lastTickPosX) * lllllllllllllllIIIIIIllllIllllII;
        final double lllllllllllllllIIIIIIllllIllIIII = this.target.lastTickPosY + (this.target.posY - this.target.lastTickPosY) * lllllllllllllllIIIIIIllllIllllII + this.yOffset;
        final double lllllllllllllllIIIIIIllllIlIllll = this.target.lastTickPosZ + (this.target.posZ - this.target.lastTickPosZ) * lllllllllllllllIIIIIIllllIllllII;
        double lllllllllllllllIIIIIIllllIlIlllI = lllllllllllllllIIIIIIllllIllIlII + (lllllllllllllllIIIIIIllllIllIIIl - lllllllllllllllIIIIIIllllIllIlII) * lllllllllllllllIIIIIIllllIllIlIl;
        double lllllllllllllllIIIIIIllllIlIllIl = lllllllllllllllIIIIIIllllIllIIll + (lllllllllllllllIIIIIIllllIllIIII - lllllllllllllllIIIIIIllllIllIIll) * lllllllllllllllIIIIIIllllIllIlIl;
        double lllllllllllllllIIIIIIllllIlIllII = lllllllllllllllIIIIIIllllIllIIlI + (lllllllllllllllIIIIIIllllIlIllll - lllllllllllllllIIIIIIllllIllIIlI) * lllllllllllllllIIIIIIllllIllIlIl;
        final int lllllllllllllllIIIIIIllllIlIlIll = this.getBrightnessForRender(lllllllllllllllIIIIIIllllIllllII);
        final int lllllllllllllllIIIIIIllllIlIlIlI = lllllllllllllllIIIIIIllllIlIlIll % 65536;
        final int lllllllllllllllIIIIIIllllIlIlIIl = lllllllllllllllIIIIIIllllIlIlIll / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllllIIIIIIllllIlIlIlI, (float)lllllllllllllllIIIIIIllllIlIlIIl);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        lllllllllllllllIIIIIIllllIlIlllI -= ParticleItemPickup.interpPosX;
        lllllllllllllllIIIIIIllllIlIllIl -= ParticleItemPickup.interpPosY;
        lllllllllllllllIIIIIIllllIlIllII -= ParticleItemPickup.interpPosZ;
        GlStateManager.enableLighting();
        this.renderManager.doRenderEntity(this.item, lllllllllllllllIIIIIIllllIlIlllI, lllllllllllllllIIIIIIllllIlIllIl, lllllllllllllllIIIIIIllllIlIllII, this.item.rotationYaw, lllllllllllllllIIIIIIllllIllllII, false);
        if (Config.isShaders()) {
            Shaders.useProgram(lllllllllllllllIIIIIIllllIllIllI);
        }
    }
}
