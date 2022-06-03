// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import optifine.CustomColors;
import optifine.Config;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntityWolf;

public class LayerWolfCollar implements LayerRenderer<EntityWolf>
{
    private final /* synthetic */ RenderWolf wolfRenderer;
    private static final /* synthetic */ ResourceLocation WOLF_COLLAR;
    
    static {
        WOLF_COLLAR = new ResourceLocation("textures/entity/wolf/wolf_collar.png");
    }
    
    @Override
    public void doRenderLayer(final EntityWolf lllllllllllllIlllllIIllIIllIlllI, final float lllllllllllllIlllllIIllIIllIllIl, final float lllllllllllllIlllllIIllIIlllIllI, final float lllllllllllllIlllllIIllIIlllIlIl, final float lllllllllllllIlllllIIllIIllIlIll, final float lllllllllllllIlllllIIllIIllIlIlI, final float lllllllllllllIlllllIIllIIllIlIIl, final float lllllllllllllIlllllIIllIIllIlIII) {
        if (lllllllllllllIlllllIIllIIllIlllI.isTamed() && !lllllllllllllIlllllIIllIIllIlllI.isInvisible()) {
            this.wolfRenderer.bindTexture(LayerWolfCollar.WOLF_COLLAR);
            float[] lllllllllllllIlllllIIllIIlllIIII = lllllllllllllIlllllIIllIIllIlllI.getCollarColor().func_193349_f();
            if (Config.isCustomColors()) {
                lllllllllllllIlllllIIllIIlllIIII = CustomColors.getWolfCollarColors(lllllllllllllIlllllIIllIIllIlllI.getCollarColor(), lllllllllllllIlllllIIllIIlllIIII);
            }
            GlStateManager.color(lllllllllllllIlllllIIllIIlllIIII[0], lllllllllllllIlllllIIllIIlllIIII[1], lllllllllllllIlllllIIllIIlllIIII[2]);
            this.wolfRenderer.getMainModel().render(lllllllllllllIlllllIIllIIllIlllI, lllllllllllllIlllllIIllIIllIllIl, lllllllllllllIlllllIIllIIlllIllI, lllllllllllllIlllllIIllIIllIlIll, lllllllllllllIlllllIIllIIllIlIlI, lllllllllllllIlllllIIllIIllIlIIl, lllllllllllllIlllllIIllIIllIlIII);
        }
    }
    
    public LayerWolfCollar(final RenderWolf lllllllllllllIlllllIIllIlIIIIlIl) {
        this.wolfRenderer = lllllllllllllIlllllIIllIlIIIIlIl;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
