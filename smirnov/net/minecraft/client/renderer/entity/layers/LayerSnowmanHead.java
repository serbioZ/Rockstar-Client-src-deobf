// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.entity.monster.EntitySnowman;

public class LayerSnowmanHead implements LayerRenderer<EntitySnowman>
{
    private final /* synthetic */ RenderSnowMan snowManRenderer;
    
    public LayerSnowmanHead(final RenderSnowMan lllllllllllIlIIllIllllllllIlIllI) {
        this.snowManRenderer = lllllllllllIlIIllIllllllllIlIllI;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    @Override
    public void doRenderLayer(final EntitySnowman lllllllllllIlIIllIllllllllIIIlll, final float lllllllllllIlIIllIllllllllIlIIII, final float lllllllllllIlIIllIllllllllIIllll, final float lllllllllllIlIIllIllllllllIIlllI, final float lllllllllllIlIIllIllllllllIIllIl, final float lllllllllllIlIIllIllllllllIIllII, final float lllllllllllIlIIllIllllllllIIlIll, final float lllllllllllIlIIllIllllllllIIlIlI) {
        if (!lllllllllllIlIIllIllllllllIIIlll.isInvisible() && lllllllllllIlIIllIllllllllIIIlll.isPumpkinEquipped()) {
            GlStateManager.pushMatrix();
            this.snowManRenderer.getMainModel().head.postRender(0.0625f);
            final float lllllllllllIlIIllIllllllllIIlIIl = 0.625f;
            GlStateManager.translate(0.0f, -0.34375f, 0.0f);
            GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.scale(0.625f, -0.625f, -0.625f);
            Minecraft.getMinecraft().getItemRenderer().renderItem(lllllllllllIlIIllIllllllllIIIlll, new ItemStack(Blocks.PUMPKIN, 1), ItemCameraTransforms.TransformType.HEAD);
            GlStateManager.popMatrix();
        }
    }
}
