// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import optifine.CustomColors;
import optifine.Config;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntitySheep;

public class LayerSheepWool implements LayerRenderer<EntitySheep>
{
    private static final /* synthetic */ ResourceLocation TEXTURE;
    private final /* synthetic */ RenderSheep sheepRenderer;
    public /* synthetic */ ModelSheep1 sheepModel;
    
    @Override
    public void doRenderLayer(final EntitySheep lllllllllllIllIIlllIIIlllIllllII, final float lllllllllllIllIIlllIIIlllIlIlIIl, final float lllllllllllIllIIlllIIIlllIlIlIII, final float lllllllllllIllIIlllIIIlllIlllIIl, final float lllllllllllIllIIlllIIIlllIlIIllI, final float lllllllllllIllIIlllIIIlllIllIlll, final float lllllllllllIllIIlllIIIlllIlIIlII, final float lllllllllllIllIIlllIIIlllIlIIIll) {
        if (!lllllllllllIllIIlllIIIlllIllllII.getSheared() && !lllllllllllIllIIlllIIIlllIllllII.isInvisible()) {
            this.sheepRenderer.bindTexture(LayerSheepWool.TEXTURE);
            if (lllllllllllIllIIlllIIIlllIllllII.hasCustomName() && "jeb_".equals(lllllllllllIllIIlllIIIlllIllllII.getCustomNameTag())) {
                final int lllllllllllIllIIlllIIIlllIllIlII = 25;
                final int lllllllllllIllIIlllIIIlllIllIIll = lllllllllllIllIIlllIIIlllIllllII.ticksExisted / 25 + lllllllllllIllIIlllIIIlllIllllII.getEntityId();
                final int lllllllllllIllIIlllIIIlllIllIIlI = EnumDyeColor.values().length;
                final int lllllllllllIllIIlllIIIlllIllIIIl = lllllllllllIllIIlllIIIlllIllIIll % lllllllllllIllIIlllIIIlllIllIIlI;
                final int lllllllllllIllIIlllIIIlllIllIIII = (lllllllllllIllIIlllIIIlllIllIIll + 1) % lllllllllllIllIIlllIIIlllIllIIlI;
                final float lllllllllllIllIIlllIIIlllIlIllll = (lllllllllllIllIIlllIIIlllIllllII.ticksExisted % 25 + lllllllllllIllIIlllIIIlllIlllIIl) / 25.0f;
                float[] lllllllllllIllIIlllIIIlllIlIlllI = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(lllllllllllIllIIlllIIIlllIllIIIl));
                float[] lllllllllllIllIIlllIIIlllIlIllIl = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(lllllllllllIllIIlllIIIlllIllIIII));
                if (Config.isCustomColors()) {
                    lllllllllllIllIIlllIIIlllIlIlllI = CustomColors.getSheepColors(EnumDyeColor.byMetadata(lllllllllllIllIIlllIIIlllIllIIIl), lllllllllllIllIIlllIIIlllIlIlllI);
                    lllllllllllIllIIlllIIIlllIlIllIl = CustomColors.getSheepColors(EnumDyeColor.byMetadata(lllllllllllIllIIlllIIIlllIllIIII), lllllllllllIllIIlllIIIlllIlIllIl);
                }
                GlStateManager.color(lllllllllllIllIIlllIIIlllIlIlllI[0] * (1.0f - lllllllllllIllIIlllIIIlllIlIllll) + lllllllllllIllIIlllIIIlllIlIllIl[0] * lllllllllllIllIIlllIIIlllIlIllll, lllllllllllIllIIlllIIIlllIlIlllI[1] * (1.0f - lllllllllllIllIIlllIIIlllIlIllll) + lllllllllllIllIIlllIIIlllIlIllIl[1] * lllllllllllIllIIlllIIIlllIlIllll, lllllllllllIllIIlllIIIlllIlIlllI[2] * (1.0f - lllllllllllIllIIlllIIIlllIlIllll) + lllllllllllIllIIlllIIIlllIlIllIl[2] * lllllllllllIllIIlllIIIlllIlIllll);
            }
            else {
                float[] lllllllllllIllIIlllIIIlllIlIllII = EntitySheep.getDyeRgb(lllllllllllIllIIlllIIIlllIllllII.getFleeceColor());
                if (Config.isCustomColors()) {
                    lllllllllllIllIIlllIIIlllIlIllII = CustomColors.getSheepColors(lllllllllllIllIIlllIIIlllIllllII.getFleeceColor(), lllllllllllIllIIlllIIIlllIlIllII);
                }
                GlStateManager.color(lllllllllllIllIIlllIIIlllIlIllII[0], lllllllllllIllIIlllIIIlllIlIllII[1], lllllllllllIllIIlllIIIlllIlIllII[2]);
            }
            this.sheepModel.setModelAttributes(this.sheepRenderer.getMainModel());
            this.sheepModel.setLivingAnimations(lllllllllllIllIIlllIIIlllIllllII, lllllllllllIllIIlllIIIlllIlIlIIl, lllllllllllIllIIlllIIIlllIlIlIII, lllllllllllIllIIlllIIIlllIlllIIl);
            this.sheepModel.render(lllllllllllIllIIlllIIIlllIllllII, lllllllllllIllIIlllIIIlllIlIlIIl, lllllllllllIllIIlllIIIlllIlIlIII, lllllllllllIllIIlllIIIlllIlIIllI, lllllllllllIllIIlllIIIlllIllIlll, lllllllllllIllIIlllIIIlllIlIIlII, lllllllllllIllIIlllIIIlllIlIIIll);
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    static {
        TEXTURE = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
    }
    
    public LayerSheepWool(final RenderSheep lllllllllllIllIIlllIIIllllIIllll) {
        this.sheepModel = new ModelSheep1();
        this.sheepRenderer = lllllllllllIllIIlllIIIllllIIllll;
    }
}
