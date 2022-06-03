// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityCreeper;

public class LayerCreeperCharge implements LayerRenderer<EntityCreeper>
{
    private static final /* synthetic */ ResourceLocation LIGHTNING_TEXTURE;
    private final /* synthetic */ RenderCreeper creeperRenderer;
    private final /* synthetic */ ModelCreeper creeperModel;
    
    @Override
    public void doRenderLayer(final EntityCreeper lllllllllllIlIIlIIIlllIlIllllIIl, final float lllllllllllIlIIlIIIlllIlIllIllII, final float lllllllllllIlIIlIIIlllIlIllIlIll, final float lllllllllllIlIIlIIIlllIlIllIlIlI, final float lllllllllllIlIIlIIIlllIlIlllIlIl, final float lllllllllllIlIIlIIIlllIlIlllIlII, final float lllllllllllIlIIlIIIlllIlIllIIlll, final float lllllllllllIlIIlIIIlllIlIllIIllI) {
        if (lllllllllllIlIIlIIIlllIlIllllIIl.getPowered()) {
            final boolean lllllllllllIlIIlIIIlllIlIlllIIIl = lllllllllllIlIIlIIIlllIlIllllIIl.isInvisible();
            GlStateManager.depthMask(!lllllllllllIlIIlIIIlllIlIlllIIIl);
            this.creeperRenderer.bindTexture(LayerCreeperCharge.LIGHTNING_TEXTURE);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            final float lllllllllllIlIIlIIIlllIlIlllIIII = lllllllllllIlIIlIIIlllIlIllllIIl.ticksExisted + lllllllllllIlIIlIIIlllIlIllIlIlI;
            GlStateManager.translate(lllllllllllIlIIlIIIlllIlIlllIIII * 0.01f, lllllllllllIlIIlIIIlllIlIlllIIII * 0.01f, 0.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            final float lllllllllllIlIIlIIIlllIlIllIllll = 0.5f;
            GlStateManager.color(0.5f, 0.5f, 0.5f, 1.0f);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            this.creeperModel.setModelAttributes(this.creeperRenderer.getMainModel());
            Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
            this.creeperModel.render(lllllllllllIlIIlIIIlllIlIllllIIl, lllllllllllIlIIlIIIlllIlIllIllII, lllllllllllIlIIlIIIlllIlIllIlIll, lllllllllllIlIIlIIIlllIlIlllIlIl, lllllllllllIlIIlIIIlllIlIlllIlII, lllllllllllIlIIlIIIlllIlIllIIlll, lllllllllllIlIIlIIIlllIlIllIIllI);
            Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(lllllllllllIlIIlIIIlllIlIlllIIIl);
        }
    }
    
    public LayerCreeperCharge(final RenderCreeper lllllllllllIlIIlIIIlllIllIIIIlll) {
        this.creeperModel = new ModelCreeper(2.0f);
        this.creeperRenderer = lllllllllllIlIIlIIIlllIllIIIIlll;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    static {
        LIGHTNING_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    }
}
