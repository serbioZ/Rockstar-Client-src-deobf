// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.Entity;
import shadersmod.client.Shaders;
import optifine.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.boss.EntityDragon;

public class LayerEnderDragonEyes implements LayerRenderer<EntityDragon>
{
    private static final /* synthetic */ ResourceLocation TEXTURE;
    private final /* synthetic */ RenderDragon dragonRenderer;
    
    static {
        TEXTURE = new ResourceLocation("textures/entity/enderdragon/dragon_eyes.png");
    }
    
    public LayerEnderDragonEyes(final RenderDragon llllllllllllIllIlllIIIIIIlIlIIlI) {
        this.dragonRenderer = llllllllllllIllIlllIIIIIIlIlIIlI;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final EntityDragon llllllllllllIllIlllIIIIIIIllIlll, final float llllllllllllIllIlllIIIIIIlIIIIlI, final float llllllllllllIllIlllIIIIIIIllIlIl, final float llllllllllllIllIlllIIIIIIlIIIIII, final float llllllllllllIllIlllIIIIIIIllllll, final float llllllllllllIllIlllIIIIIIIllIIll, final float llllllllllllIllIlllIIIIIIIllllIl, final float llllllllllllIllIlllIIIIIIIllllII) {
        this.dragonRenderer.bindTexture(LayerEnderDragonEyes.TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthFunc(514);
        final int llllllllllllIllIlllIIIIIIIlllIll = 61680;
        final int llllllllllllIllIlllIIIIIIIlllIlI = 61680;
        final int llllllllllllIllIlllIIIIIIIlllIIl = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0f, 0.0f);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
        if (Config.isShaders()) {
            Shaders.beginSpiderEyes();
        }
        Config.getRenderGlobal().renderOverlayEyes = true;
        this.dragonRenderer.getMainModel().render(llllllllllllIllIlllIIIIIIIllIlll, llllllllllllIllIlllIIIIIIlIIIIlI, llllllllllllIllIlllIIIIIIIllIlIl, llllllllllllIllIlllIIIIIIIllllll, llllllllllllIllIlllIIIIIIIllIIll, llllllllllllIllIlllIIIIIIIllllIl, llllllllllllIllIlllIIIIIIIllllII);
        Config.getRenderGlobal().renderOverlayEyes = false;
        if (Config.isShaders()) {
            Shaders.endSpiderEyes();
        }
        Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
        this.dragonRenderer.setLightmap(llllllllllllIllIlllIIIIIIIllIlll);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.depthFunc(515);
    }
}
