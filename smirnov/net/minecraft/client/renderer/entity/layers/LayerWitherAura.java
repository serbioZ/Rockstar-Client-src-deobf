// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelWither;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderWither;
import net.minecraft.entity.boss.EntityWither;

public class LayerWitherAura implements LayerRenderer<EntityWither>
{
    private final /* synthetic */ RenderWither witherRenderer;
    private static final /* synthetic */ ResourceLocation WITHER_ARMOR;
    private final /* synthetic */ ModelWither witherModel;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerWitherAura(final RenderWither lllllllllllllIlIllIIIIIIllIlIlll) {
        this.witherModel = new ModelWither(0.5f);
        this.witherRenderer = lllllllllllllIlIllIIIIIIllIlIlll;
    }
    
    @Override
    public void doRenderLayer(final EntityWither lllllllllllllIlIllIIIIIIllIIIllI, final float lllllllllllllIlIllIIIIIIlIlllIII, final float lllllllllllllIlIllIIIIIIllIIIlII, final float lllllllllllllIlIllIIIIIIllIIIIll, final float lllllllllllllIlIllIIIIIIlIllIlIl, final float lllllllllllllIlIllIIIIIIllIIIIIl, final float lllllllllllllIlIllIIIIIIllIIIIII, final float lllllllllllllIlIllIIIIIIlIllIIlI) {
        if (lllllllllllllIlIllIIIIIIllIIIllI.isArmored()) {
            GlStateManager.depthMask(!lllllllllllllIlIllIIIIIIllIIIllI.isInvisible());
            this.witherRenderer.bindTexture(LayerWitherAura.WITHER_ARMOR);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            final float lllllllllllllIlIllIIIIIIlIlllllI = lllllllllllllIlIllIIIIIIllIIIllI.ticksExisted + lllllllllllllIlIllIIIIIIllIIIIll;
            final float lllllllllllllIlIllIIIIIIlIllllIl = MathHelper.cos(lllllllllllllIlIllIIIIIIlIlllllI * 0.02f) * 3.0f;
            final float lllllllllllllIlIllIIIIIIlIllllII = lllllllllllllIlIllIIIIIIlIlllllI * 0.01f;
            GlStateManager.translate(lllllllllllllIlIllIIIIIIlIllllIl, lllllllllllllIlIllIIIIIIlIllllII, 0.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            final float lllllllllllllIlIllIIIIIIlIlllIll = 0.5f;
            GlStateManager.color(0.5f, 0.5f, 0.5f, 1.0f);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            this.witherModel.setLivingAnimations(lllllllllllllIlIllIIIIIIllIIIllI, lllllllllllllIlIllIIIIIIlIlllIII, lllllllllllllIlIllIIIIIIllIIIlII, lllllllllllllIlIllIIIIIIllIIIIll);
            this.witherModel.setModelAttributes(this.witherRenderer.getMainModel());
            Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
            this.witherModel.render(lllllllllllllIlIllIIIIIIllIIIllI, lllllllllllllIlIllIIIIIIlIlllIII, lllllllllllllIlIllIIIIIIllIIIlII, lllllllllllllIlIllIIIIIIlIllIlIl, lllllllllllllIlIllIIIIIIllIIIIIl, lllllllllllllIlIllIIIIIIllIIIIII, lllllllllllllIlIllIIIIIIlIllIIlI);
            Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
        }
    }
    
    static {
        WITHER_ARMOR = new ResourceLocation("textures/entity/wither/wither_armor.png");
    }
}
