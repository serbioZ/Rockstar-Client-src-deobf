// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.init.Items;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.entity.monster.EntityWitch;

public class LayerHeldItemWitch implements LayerRenderer<EntityWitch>
{
    private final /* synthetic */ RenderWitch witchRenderer;
    
    @Override
    public void doRenderLayer(final EntityWitch llllllllllllIllIllllllIIlIIllllI, final float llllllllllllIllIllllllIIlIlIlllI, final float llllllllllllIllIllllllIIlIlIllIl, final float llllllllllllIllIllllllIIlIlIllII, final float llllllllllllIllIllllllIIlIlIlIll, final float llllllllllllIllIllllllIIlIlIlIlI, final float llllllllllllIllIllllllIIlIlIlIIl, final float llllllllllllIllIllllllIIlIlIlIII) {
        final ItemStack llllllllllllIllIllllllIIlIlIIlll = llllllllllllIllIllllllIIlIIllllI.getHeldItemMainhand();
        if (!llllllllllllIllIllllllIIlIlIIlll.func_190926_b()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f);
            GlStateManager.pushMatrix();
            if (this.witchRenderer.getMainModel().isChild) {
                GlStateManager.translate(0.0f, 0.625f, 0.0f);
                GlStateManager.rotate(-20.0f, -1.0f, 0.0f, 0.0f);
                final float llllllllllllIllIllllllIIlIlIIllI = 0.5f;
                GlStateManager.scale(0.5f, 0.5f, 0.5f);
            }
            this.witchRenderer.getMainModel().villagerNose.postRender(0.0625f);
            GlStateManager.translate(-0.0625f, 0.53125f, 0.21875f);
            final Item llllllllllllIllIllllllIIlIlIIlIl = llllllllllllIllIllllllIIlIlIIlll.getItem();
            final Minecraft llllllllllllIllIllllllIIlIlIIlII = Minecraft.getMinecraft();
            if (Block.getBlockFromItem(llllllllllllIllIllllllIIlIlIIlIl).getDefaultState().getRenderType() == EnumBlockRenderType.ENTITYBLOCK_ANIMATED) {
                GlStateManager.translate(0.0f, 0.0625f, -0.25f);
                GlStateManager.rotate(30.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-5.0f, 0.0f, 1.0f, 0.0f);
                final float llllllllllllIllIllllllIIlIlIIIll = 0.375f;
                GlStateManager.scale(0.375f, -0.375f, 0.375f);
            }
            else if (llllllllllllIllIllllllIIlIlIIlIl == Items.BOW) {
                GlStateManager.translate(0.0f, 0.125f, -0.125f);
                GlStateManager.rotate(-45.0f, 0.0f, 1.0f, 0.0f);
                final float llllllllllllIllIllllllIIlIlIIIlI = 0.625f;
                GlStateManager.scale(0.625f, -0.625f, 0.625f);
                GlStateManager.rotate(-100.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-20.0f, 0.0f, 1.0f, 0.0f);
            }
            else if (llllllllllllIllIllllllIIlIlIIlIl.isFull3D()) {
                if (llllllllllllIllIllllllIIlIlIIlIl.shouldRotateAroundWhenRendering()) {
                    GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.translate(0.0f, -0.0625f, 0.0f);
                }
                this.witchRenderer.transformHeldFull3DItemLayer();
                GlStateManager.translate(0.0625f, -0.125f, 0.0f);
                final float llllllllllllIllIllllllIIlIlIIIIl = 0.625f;
                GlStateManager.scale(0.625f, -0.625f, 0.625f);
                GlStateManager.rotate(0.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(0.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                GlStateManager.translate(0.1875f, 0.1875f, 0.0f);
                final float llllllllllllIllIllllllIIlIlIIIII = 0.875f;
                GlStateManager.scale(0.875f, 0.875f, 0.875f);
                GlStateManager.rotate(-20.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(-60.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-30.0f, 0.0f, 0.0f, 1.0f);
            }
            GlStateManager.rotate(-15.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(40.0f, 0.0f, 0.0f, 1.0f);
            llllllllllllIllIllllllIIlIlIIlII.getItemRenderer().renderItem(llllllllllllIllIllllllIIlIIllllI, llllllllllllIllIllllllIIlIlIIlll, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND);
            GlStateManager.popMatrix();
        }
    }
    
    public LayerHeldItemWitch(final RenderWitch llllllllllllIllIllllllIIlIllIlll) {
        this.witchRenderer = llllllllllllIllIllllllIIlIllIlll;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
