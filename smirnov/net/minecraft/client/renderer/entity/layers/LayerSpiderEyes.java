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
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.monster.EntitySpider;

public class LayerSpiderEyes<T extends EntitySpider> implements LayerRenderer<T>
{
    private final /* synthetic */ RenderSpider<T> spiderRenderer;
    private static final /* synthetic */ ResourceLocation SPIDER_EYES;
    
    static {
        SPIDER_EYES = new ResourceLocation("textures/entity/spider_eyes.png");
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerSpiderEyes(final RenderSpider<T> lllllllllllIlllllllIIIIIIllIllIl) {
        this.spiderRenderer = lllllllllllIlllllllIIIIIIllIllIl;
    }
    
    @Override
    public void doRenderLayer(final T lllllllllllIlllllllIIIIIIllIIIII, final float lllllllllllIlllllllIIIIIIlIlIIll, final float lllllllllllIlllllllIIIIIIlIllllI, final float lllllllllllIlllllllIIIIIIlIlllIl, final float lllllllllllIlllllllIIIIIIlIlIIIl, final float lllllllllllIlllllllIIIIIIlIllIll, final float lllllllllllIlllllllIIIIIIlIIllll, final float lllllllllllIlllllllIIIIIIlIllIIl) {
        this.spiderRenderer.bindTexture(LayerSpiderEyes.SPIDER_EYES);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        if (lllllllllllIlllllllIIIIIIllIIIII.isInvisible()) {
            GlStateManager.depthMask(false);
        }
        else {
            GlStateManager.depthMask(true);
        }
        int lllllllllllIlllllllIIIIIIlIllIII = 61680;
        int lllllllllllIlllllllIIIIIIlIlIlll = lllllllllllIlllllllIIIIIIlIllIII % 65536;
        int lllllllllllIlllllllIIIIIIlIlIllI = lllllllllllIlllllllIIIIIIlIllIII / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllIlllllllIIIIIIlIlIlll, (float)lllllllllllIlllllllIIIIIIlIlIllI);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
        if (Config.isShaders()) {
            Shaders.beginSpiderEyes();
        }
        Config.getRenderGlobal().renderOverlayEyes = true;
        this.spiderRenderer.getMainModel().render(lllllllllllIlllllllIIIIIIllIIIII, lllllllllllIlllllllIIIIIIlIlIIll, lllllllllllIlllllllIIIIIIlIllllI, lllllllllllIlllllllIIIIIIlIlIIIl, lllllllllllIlllllllIIIIIIlIllIll, lllllllllllIlllllllIIIIIIlIIllll, lllllllllllIlllllllIIIIIIlIllIIl);
        Config.getRenderGlobal().renderOverlayEyes = false;
        if (Config.isShaders()) {
            Shaders.endSpiderEyes();
        }
        Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
        lllllllllllIlllllllIIIIIIlIllIII = lllllllllllIlllllllIIIIIIllIIIII.getBrightnessForRender();
        lllllllllllIlllllllIIIIIIlIlIlll = lllllllllllIlllllllIIIIIIlIllIII % 65536;
        lllllllllllIlllllllIIIIIIlIlIllI = lllllllllllIlllllllIIIIIIlIllIII / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllIlllllllIIIIIIlIlIlll, (float)lllllllllllIlllllllIIIIIIlIlIllI);
        this.spiderRenderer.setLightmap(lllllllllllIlllllllIIIIIIllIIIII);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }
}
