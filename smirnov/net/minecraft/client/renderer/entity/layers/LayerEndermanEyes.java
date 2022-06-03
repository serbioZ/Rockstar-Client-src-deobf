// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import shadersmod.client.Shaders;
import optifine.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderEnderman;
import net.minecraft.entity.monster.EntityEnderman;

public class LayerEndermanEyes implements LayerRenderer<EntityEnderman>
{
    private final /* synthetic */ RenderEnderman endermanRenderer;
    private static final /* synthetic */ ResourceLocation RES_ENDERMAN_EYES;
    
    static {
        RES_ENDERMAN_EYES = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
    }
    
    @Override
    public void doRenderLayer(final EntityEnderman llllllllllllIlllIlllIIIlIlIIllll, final float llllllllllllIlllIlllIIIlIlIllIlI, final float llllllllllllIlllIlllIIIlIlIllIIl, final float llllllllllllIlllIlllIIIlIlIllIII, final float llllllllllllIlllIlllIIIlIlIlIlll, final float llllllllllllIlllIlllIIIlIlIlIllI, final float llllllllllllIlllIlllIIIlIlIIlIlI, final float llllllllllllIlllIlllIIIlIlIlIlII) {
        this.endermanRenderer.bindTexture(LayerEndermanEyes.RES_ENDERMAN_EYES);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(!llllllllllllIlllIlllIIIlIlIIllll.isInvisible());
        final int llllllllllllIlllIlllIIIlIlIlIIll = 61680;
        final int llllllllllllIlllIlllIIIlIlIlIIlI = 61680;
        final int llllllllllllIlllIlllIIIlIlIlIIIl = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0f, 0.0f);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
        if (Config.isShaders()) {
            Shaders.beginSpiderEyes();
        }
        Config.getRenderGlobal().renderOverlayEyes = true;
        this.endermanRenderer.getMainModel().render(llllllllllllIlllIlllIIIlIlIIllll, llllllllllllIlllIlllIIIlIlIllIlI, llllllllllllIlllIlllIIIlIlIllIIl, llllllllllllIlllIlllIIIlIlIlIlll, llllllllllllIlllIlllIIIlIlIlIllI, llllllllllllIlllIlllIIIlIlIIlIlI, llllllllllllIlllIlllIIIlIlIlIlII);
        Config.getRenderGlobal().renderOverlayEyes = false;
        if (Config.isShaders()) {
            Shaders.endSpiderEyes();
        }
        Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
        this.endermanRenderer.setLightmap(llllllllllllIlllIlllIIIlIlIIllll);
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerEndermanEyes(final RenderEnderman llllllllllllIlllIlllIIIlIllIlIlI) {
        this.endermanRenderer = llllllllllllIlllIlllIIIlIllIlIlI;
    }
}
