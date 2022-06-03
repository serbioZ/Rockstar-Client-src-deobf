// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.RenderItem;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;

public class RenderEntityItem extends Render<EntityItem>
{
    private final /* synthetic */ Random random;
    private final /* synthetic */ RenderItem itemRenderer;
    
    private int transformModelCount(final EntityItem lllllllllllIlIlIllIlIlIllIIllllI, final double lllllllllllIlIlIllIlIlIllIIlllIl, final double lllllllllllIlIlIllIlIlIllIlIlIll, final double lllllllllllIlIlIllIlIlIllIIllIll, final float lllllllllllIlIlIllIlIlIllIlIlIIl, final IBakedModel lllllllllllIlIlIllIlIlIllIIllIIl) {
        final ItemStack lllllllllllIlIlIllIlIlIllIlIIlll = lllllllllllIlIlIllIlIlIllIIllllI.getEntityItem();
        final Item lllllllllllIlIlIllIlIlIllIlIIllI = lllllllllllIlIlIllIlIlIllIlIIlll.getItem();
        if (lllllllllllIlIlIllIlIlIllIlIIllI == null) {
            return 0;
        }
        final boolean lllllllllllIlIlIllIlIlIllIlIIlIl = lllllllllllIlIlIllIlIlIllIIllIIl.isGui3d();
        final int lllllllllllIlIlIllIlIlIllIlIIlII = this.getModelCount(lllllllllllIlIlIllIlIlIllIlIIlll);
        final float lllllllllllIlIlIllIlIlIllIlIIIll = 0.25f;
        final float lllllllllllIlIlIllIlIlIllIlIIIlI = MathHelper.sin((lllllllllllIlIlIllIlIlIllIIllllI.getAge() + lllllllllllIlIlIllIlIlIllIlIlIIl) / 10.0f + lllllllllllIlIlIllIlIlIllIIllllI.hoverStart) * 0.1f + 0.1f;
        final float lllllllllllIlIlIllIlIlIllIlIIIIl = lllllllllllIlIlIllIlIlIllIIllIIl.getItemCameraTransforms().getTransform(ItemCameraTransforms.TransformType.GROUND).scale.y;
        GlStateManager.translate((float)lllllllllllIlIlIllIlIlIllIIlllIl, (float)lllllllllllIlIlIllIlIlIllIlIlIll + lllllllllllIlIlIllIlIlIllIlIIIlI + 0.25f * lllllllllllIlIlIllIlIlIllIlIIIIl, (float)lllllllllllIlIlIllIlIlIllIIllIll);
        if (lllllllllllIlIlIllIlIlIllIlIIlIl || this.renderManager.options != null) {
            final float lllllllllllIlIlIllIlIlIllIlIIIII = ((lllllllllllIlIlIllIlIlIllIIllllI.getAge() + lllllllllllIlIlIllIlIlIllIlIlIIl) / 20.0f + lllllllllllIlIlIllIlIlIllIIllllI.hoverStart) * 57.295776f;
            GlStateManager.rotate(lllllllllllIlIlIllIlIlIllIlIIIII, 0.0f, 1.0f, 0.0f);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        return lllllllllllIlIlIllIlIlIllIlIIlII;
    }
    
    @Override
    public void doRender(final EntityItem lllllllllllIlIlIllIlIlIlIlllIlII, final double lllllllllllIlIlIllIlIlIlIlllIIll, final double lllllllllllIlIlIllIlIlIlIlllIIlI, final double lllllllllllIlIlIllIlIlIlIlIllIII, final float lllllllllllIlIlIllIlIlIlIlllIIII, final float lllllllllllIlIlIllIlIlIlIllIllll) {
        final ItemStack lllllllllllIlIlIllIlIlIlIllIlllI = lllllllllllIlIlIllIlIlIlIlllIlII.getEntityItem();
        final int lllllllllllIlIlIllIlIlIlIllIllIl = lllllllllllIlIlIllIlIlIlIllIlllI.func_190926_b() ? 187 : (Item.getIdFromItem(lllllllllllIlIlIllIlIlIlIllIlllI.getItem()) + lllllllllllIlIlIllIlIlIlIllIlllI.getMetadata());
        this.random.setSeed(lllllllllllIlIlIllIlIlIlIllIllIl);
        boolean lllllllllllIlIlIllIlIlIlIllIllII = false;
        if (this.bindEntityTexture(lllllllllllIlIlIllIlIlIlIlllIlII)) {
            this.renderManager.renderEngine.getTexture(this.getEntityTexture(lllllllllllIlIlIllIlIlIlIlllIlII)).setBlurMipmap(false, false);
            lllllllllllIlIlIllIlIlIlIllIllII = true;
        }
        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.enableBlend();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.pushMatrix();
        final IBakedModel lllllllllllIlIlIllIlIlIlIllIlIll = this.itemRenderer.getItemModelWithOverrides(lllllllllllIlIlIllIlIlIlIllIlllI, lllllllllllIlIlIllIlIlIlIlllIlII.world, null);
        final int lllllllllllIlIlIllIlIlIlIllIlIlI = this.transformModelCount(lllllllllllIlIlIllIlIlIlIlllIlII, lllllllllllIlIlIllIlIlIlIlllIIll, lllllllllllIlIlIllIlIlIlIlllIIlI, lllllllllllIlIlIllIlIlIlIlIllIII, lllllllllllIlIlIllIlIlIlIllIllll, lllllllllllIlIlIllIlIlIlIllIlIll);
        final float lllllllllllIlIlIllIlIlIlIllIlIIl = lllllllllllIlIlIllIlIlIlIllIlIll.getItemCameraTransforms().ground.scale.x;
        final float lllllllllllIlIlIllIlIlIlIllIlIII = lllllllllllIlIlIllIlIlIlIllIlIll.getItemCameraTransforms().ground.scale.y;
        final float lllllllllllIlIlIllIlIlIlIllIIlll = lllllllllllIlIlIllIlIlIlIllIlIll.getItemCameraTransforms().ground.scale.z;
        final boolean lllllllllllIlIlIllIlIlIlIllIIllI = lllllllllllIlIlIllIlIlIlIllIlIll.isGui3d();
        if (!lllllllllllIlIlIllIlIlIlIllIIllI) {
            final float lllllllllllIlIlIllIlIlIlIllIIlIl = -0.0f * (lllllllllllIlIlIllIlIlIlIllIlIlI - 1) * 0.5f * lllllllllllIlIlIllIlIlIlIllIlIIl;
            final float lllllllllllIlIlIllIlIlIlIllIIlII = -0.0f * (lllllllllllIlIlIllIlIlIlIllIlIlI - 1) * 0.5f * lllllllllllIlIlIllIlIlIlIllIlIII;
            final float lllllllllllIlIlIllIlIlIlIllIIIll = -0.09375f * (lllllllllllIlIlIllIlIlIlIllIlIlI - 1) * 0.5f * lllllllllllIlIlIllIlIlIlIllIIlll;
            GlStateManager.translate(lllllllllllIlIlIllIlIlIlIllIIlIl, lllllllllllIlIlIllIlIlIlIllIIlII, lllllllllllIlIlIllIlIlIlIllIIIll);
        }
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllIlIlIllIlIlIlIlllIlII));
        }
        for (int lllllllllllIlIlIllIlIlIlIllIIIlI = 0; lllllllllllIlIlIllIlIlIlIllIIIlI < lllllllllllIlIlIllIlIlIlIllIlIlI; ++lllllllllllIlIlIllIlIlIlIllIIIlI) {
            if (lllllllllllIlIlIllIlIlIlIllIIllI) {
                GlStateManager.pushMatrix();
                if (lllllllllllIlIlIllIlIlIlIllIIIlI > 0) {
                    final float lllllllllllIlIlIllIlIlIlIllIIIIl = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    final float lllllllllllIlIlIllIlIlIlIllIIIII = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    final float lllllllllllIlIlIllIlIlIlIlIlllll = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    GlStateManager.translate(lllllllllllIlIlIllIlIlIlIllIIIIl, lllllllllllIlIlIllIlIlIlIllIIIII, lllllllllllIlIlIllIlIlIlIlIlllll);
                }
                lllllllllllIlIlIllIlIlIlIllIlIll.getItemCameraTransforms().applyTransform(ItemCameraTransforms.TransformType.GROUND);
                this.itemRenderer.renderItem(lllllllllllIlIlIllIlIlIlIllIlllI, lllllllllllIlIlIllIlIlIlIllIlIll);
                GlStateManager.popMatrix();
            }
            else {
                GlStateManager.pushMatrix();
                if (lllllllllllIlIlIllIlIlIlIllIIIlI > 0) {
                    final float lllllllllllIlIlIllIlIlIlIlIllllI = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f * 0.5f;
                    final float lllllllllllIlIlIllIlIlIlIlIlllIl = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f * 0.5f;
                    GlStateManager.translate(lllllllllllIlIlIllIlIlIlIlIllllI, lllllllllllIlIlIllIlIlIlIlIlllIl, 0.0f);
                }
                lllllllllllIlIlIllIlIlIlIllIlIll.getItemCameraTransforms().applyTransform(ItemCameraTransforms.TransformType.GROUND);
                this.itemRenderer.renderItem(lllllllllllIlIlIllIlIlIlIllIlllI, lllllllllllIlIlIllIlIlIlIllIlIll);
                GlStateManager.popMatrix();
                GlStateManager.translate(0.0f * lllllllllllIlIlIllIlIlIlIllIlIIl, 0.0f * lllllllllllIlIlIllIlIlIlIllIlIII, 0.09375f * lllllllllllIlIlIllIlIlIlIllIIlll);
            }
        }
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
        this.bindEntityTexture(lllllllllllIlIlIllIlIlIlIlllIlII);
        if (lllllllllllIlIlIllIlIlIlIllIllII) {
            this.renderManager.renderEngine.getTexture(this.getEntityTexture(lllllllllllIlIlIllIlIlIlIlllIlII)).restoreLastBlurMipmap();
        }
        super.doRender(lllllllllllIlIlIllIlIlIlIlllIlII, lllllllllllIlIlIllIlIlIlIlllIIll, lllllllllllIlIlIllIlIlIlIlllIIlI, lllllllllllIlIlIllIlIlIlIlIllIII, lllllllllllIlIlIllIlIlIlIlllIIII, lllllllllllIlIlIllIlIlIlIllIllll);
    }
    
    public RenderEntityItem(final RenderManager lllllllllllIlIlIllIlIlIllIllllll, final RenderItem lllllllllllIlIlIllIlIlIlllIIIIIl) {
        super(lllllllllllIlIlIllIlIlIllIllllll);
        this.random = new Random();
        this.itemRenderer = lllllllllllIlIlIllIlIlIlllIIIIIl;
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }
    
    private int getModelCount(final ItemStack lllllllllllIlIlIllIlIlIllIIIllIl) {
        int lllllllllllIlIlIllIlIlIllIIIllII = 1;
        if (lllllllllllIlIlIllIlIlIllIIIllIl.func_190916_E() > 48) {
            lllllllllllIlIlIllIlIlIllIIIllII = 5;
        }
        else if (lllllllllllIlIlIllIlIlIllIIIllIl.func_190916_E() > 32) {
            lllllllllllIlIlIllIlIlIllIIIllII = 4;
        }
        else if (lllllllllllIlIlIllIlIlIllIIIllIl.func_190916_E() > 16) {
            lllllllllllIlIlIllIlIlIllIIIllII = 3;
        }
        else if (lllllllllllIlIlIllIlIlIllIIIllIl.func_190916_E() > 1) {
            lllllllllllIlIlIllIlIlIllIIIllII = 2;
        }
        return lllllllllllIlIlIllIlIlIllIIIllII;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityItem lllllllllllIlIlIllIlIlIlIlIIIlll) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
