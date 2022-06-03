// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.RenderMooshroom;
import net.minecraft.entity.passive.EntityMooshroom;

public class LayerMooshroomMushroom implements LayerRenderer<EntityMooshroom>
{
    private final /* synthetic */ RenderMooshroom mooshroomRenderer;
    
    public LayerMooshroomMushroom(final RenderMooshroom lllllllllllIIIIIIIllIlIIlIlIIlII) {
        this.mooshroomRenderer = lllllllllllIIIIIIIllIlIIlIlIIlII;
    }
    
    @Override
    public void doRenderLayer(final EntityMooshroom lllllllllllIIIIIIIllIlIIlIIlllll, final float lllllllllllIIIIIIIllIlIIlIIllllI, final float lllllllllllIIIIIIIllIlIIlIIlllIl, final float lllllllllllIIIIIIIllIlIIlIIlllII, final float lllllllllllIIIIIIIllIlIIlIIllIll, final float lllllllllllIIIIIIIllIlIIlIIllIlI, final float lllllllllllIIIIIIIllIlIIlIIllIIl, final float lllllllllllIIIIIIIllIlIIlIIllIII) {
        if (!lllllllllllIIIIIIIllIlIIlIIlllll.isChild() && !lllllllllllIIIIIIIllIlIIlIIlllll.isInvisible()) {
            final BlockRendererDispatcher lllllllllllIIIIIIIllIlIIlIIlIlll = Minecraft.getMinecraft().getBlockRendererDispatcher();
            this.mooshroomRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            GlStateManager.enableCull();
            GlStateManager.cullFace(GlStateManager.CullFace.FRONT);
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f, -1.0f, 1.0f);
            GlStateManager.translate(0.2f, 0.35f, 0.5f);
            GlStateManager.rotate(42.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.5f, -0.5f, 0.5f);
            lllllllllllIIIIIIIllIlIIlIIlIlll.renderBlockBrightness(Blocks.RED_MUSHROOM.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.1f, 0.0f, -0.6f);
            GlStateManager.rotate(42.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, 0.5f);
            lllllllllllIIIIIIIllIlIIlIIlIlll.renderBlockBrightness(Blocks.RED_MUSHROOM.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            this.mooshroomRenderer.getMainModel().head.postRender(0.0625f);
            GlStateManager.scale(1.0f, -1.0f, 1.0f);
            GlStateManager.translate(0.0f, 0.7f, -0.2f);
            GlStateManager.rotate(12.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, 0.5f);
            lllllllllllIIIIIIIllIlIIlIIlIlll.renderBlockBrightness(Blocks.RED_MUSHROOM.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.cullFace(GlStateManager.CullFace.BACK);
            GlStateManager.disableCull();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
