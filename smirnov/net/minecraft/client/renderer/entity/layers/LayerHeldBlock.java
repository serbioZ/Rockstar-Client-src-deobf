// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderEnderman;
import net.minecraft.entity.monster.EntityEnderman;

public class LayerHeldBlock implements LayerRenderer<EntityEnderman>
{
    private final /* synthetic */ RenderEnderman endermanRenderer;
    
    public LayerHeldBlock(final RenderEnderman llllllllllllIlIlIIllIIIlllllllll) {
        this.endermanRenderer = llllllllllllIlIlIIllIIIlllllllll;
    }
    
    @Override
    public void doRenderLayer(final EntityEnderman llllllllllllIlIlIIllIIIllllIIlII, final float llllllllllllIlIlIIllIIIlllllIIlI, final float llllllllllllIlIlIIllIIIlllllIIIl, final float llllllllllllIlIlIIllIIIlllllIIII, final float llllllllllllIlIlIIllIIIllllIllll, final float llllllllllllIlIlIIllIIIllllIlllI, final float llllllllllllIlIlIIllIIIllllIllIl, final float llllllllllllIlIlIIllIIIllllIllII) {
        final IBlockState llllllllllllIlIlIIllIIIllllIlIll = llllllllllllIlIlIIllIIIllllIIlII.getHeldBlockState();
        if (llllllllllllIlIlIIllIIIllllIlIll != null) {
            final BlockRendererDispatcher llllllllllllIlIlIIllIIIllllIlIlI = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.6875f, -0.75f);
            GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.25f, 0.1875f, 0.25f);
            final float llllllllllllIlIlIIllIIIllllIlIIl = 0.5f;
            GlStateManager.scale(-0.5f, -0.5f, 0.5f);
            final int llllllllllllIlIlIIllIIIllllIlIII = llllllllllllIlIlIIllIIIllllIIlII.getBrightnessForRender();
            final int llllllllllllIlIlIIllIIIllllIIlll = llllllllllllIlIlIIllIIIllllIlIII % 65536;
            final int llllllllllllIlIlIIllIIIllllIIllI = llllllllllllIlIlIIllIIIllllIlIII / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)llllllllllllIlIlIIllIIIllllIIlll, (float)llllllllllllIlIlIIllIIIllllIIllI);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.endermanRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            llllllllllllIlIlIIllIIIllllIlIlI.renderBlockBrightness(llllllllllllIlIlIIllIIIllllIlIll, 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
