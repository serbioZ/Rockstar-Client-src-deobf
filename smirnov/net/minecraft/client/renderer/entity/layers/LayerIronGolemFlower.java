// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.entity.monster.EntityIronGolem;

public class LayerIronGolemFlower implements LayerRenderer<EntityIronGolem>
{
    private final /* synthetic */ RenderIronGolem ironGolemRenderer;
    
    @Override
    public void doRenderLayer(final EntityIronGolem llllllllllllIlIllIIlIlllIllIIlll, final float llllllllllllIlIllIIlIlllIllIIllI, final float llllllllllllIlIllIIlIlllIllIIlIl, final float llllllllllllIlIllIIlIlllIllIIlII, final float llllllllllllIlIllIIlIlllIllIIIll, final float llllllllllllIlIllIIlIlllIllIIIlI, final float llllllllllllIlIllIIlIlllIllIIIIl, final float llllllllllllIlIllIIlIlllIllIIIII) {
        if (llllllllllllIlIllIIlIlllIllIIlll.getHoldRoseTick() != 0) {
            final BlockRendererDispatcher llllllllllllIlIllIIlIlllIlIlllll = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.rotate(5.0f + 180.0f * ((ModelIronGolem)this.ironGolemRenderer.getMainModel()).ironGolemRightArm.rotateAngleX / 3.1415927f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.translate(-0.9375f, -0.625f, -0.9375f);
            final float llllllllllllIlIllIIlIlllIlIllllI = 0.5f;
            GlStateManager.scale(0.5f, -0.5f, 0.5f);
            final int llllllllllllIlIllIIlIlllIlIlllIl = llllllllllllIlIllIIlIlllIllIIlll.getBrightnessForRender();
            final int llllllllllllIlIllIIlIlllIlIlllII = llllllllllllIlIllIIlIlllIlIlllIl % 65536;
            final int llllllllllllIlIllIIlIlllIlIllIll = llllllllllllIlIllIIlIlllIlIlllIl / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)llllllllllllIlIllIIlIlllIlIlllII, (float)llllllllllllIlIllIIlIlllIlIllIll);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.ironGolemRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            llllllllllllIlIllIIlIlllIlIlllll.renderBlockBrightness(Blocks.RED_FLOWER.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerIronGolemFlower(final RenderIronGolem llllllllllllIlIllIIlIlllIlllIIII) {
        this.ironGolemRenderer = llllllllllllIlIllIIlIlllIlllIIII;
    }
}
