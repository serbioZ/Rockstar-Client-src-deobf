// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.item.ItemStack;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import optifine.CustomItems;
import optifine.Config;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.model.ModelElytra;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.EntityLivingBase;

public class LayerElytra implements LayerRenderer<EntityLivingBase>
{
    private static final /* synthetic */ ResourceLocation TEXTURE_ELYTRA;
    protected final /* synthetic */ RenderLivingBase<?> renderPlayer;
    private final /* synthetic */ ModelElytra modelElytra;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    static {
        TEXTURE_ELYTRA = new ResourceLocation("textures/entity/elytra.png");
    }
    
    public LayerElytra(final RenderLivingBase<?> lllllllllllIIlllIllIllIlIIIIllll) {
        this.modelElytra = new ModelElytra();
        this.renderPlayer = lllllllllllIIlllIllIllIlIIIIllll;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllIIlllIllIllIIllllIlII, final float lllllllllllIIlllIllIllIIllllIIll, final float lllllllllllIIlllIllIllIIllllllll, final float lllllllllllIIlllIllIllIIlllllllI, final float lllllllllllIIlllIllIllIIllllIIII, final float lllllllllllIIlllIllIllIIlllIllll, final float lllllllllllIIlllIllIllIIlllllIll, final float lllllllllllIIlllIllIllIIlllIllIl) {
        final ItemStack lllllllllllIIlllIllIllIIlllllIIl = lllllllllllIIlllIllIllIIllllIlII.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        if (lllllllllllIIlllIllIllIIlllllIIl.getItem() == Items.ELYTRA) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            if (lllllllllllIIlllIllIllIIllllIlII instanceof AbstractClientPlayer) {
                final AbstractClientPlayer lllllllllllIIlllIllIllIIlllllIII = (AbstractClientPlayer)lllllllllllIIlllIllIllIIllllIlII;
                if (lllllllllllIIlllIllIllIIlllllIII.isPlayerInfoSet() && lllllllllllIIlllIllIllIIlllllIII.getLocationElytra() != null) {
                    this.renderPlayer.bindTexture(lllllllllllIIlllIllIllIIlllllIII.getLocationElytra());
                }
                else if (lllllllllllIIlllIllIllIIlllllIII.hasElytraCape() && lllllllllllIIlllIllIllIIlllllIII.hasPlayerInfo() && lllllllllllIIlllIllIllIIlllllIII.getLocationCape() != null && lllllllllllIIlllIllIllIIlllllIII.isWearing(EnumPlayerModelParts.CAPE)) {
                    this.renderPlayer.bindTexture(lllllllllllIIlllIllIllIIlllllIII.getLocationCape());
                }
                else {
                    ResourceLocation lllllllllllIIlllIllIllIIllllIlll = LayerElytra.TEXTURE_ELYTRA;
                    if (Config.isCustomItems()) {
                        lllllllllllIIlllIllIllIIllllIlll = CustomItems.getCustomElytraTexture(lllllllllllIIlllIllIllIIlllllIIl, lllllllllllIIlllIllIllIIllllIlll);
                    }
                    this.renderPlayer.bindTexture(lllllllllllIIlllIllIllIIllllIlll);
                }
            }
            else {
                ResourceLocation lllllllllllIIlllIllIllIIllllIllI = LayerElytra.TEXTURE_ELYTRA;
                if (Config.isCustomItems()) {
                    lllllllllllIIlllIllIllIIllllIllI = CustomItems.getCustomElytraTexture(lllllllllllIIlllIllIllIIlllllIIl, lllllllllllIIlllIllIllIIllllIllI);
                }
                this.renderPlayer.bindTexture(lllllllllllIIlllIllIllIIllllIllI);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, 0.125f);
            this.modelElytra.setRotationAngles(lllllllllllIIlllIllIllIIllllIIll, lllllllllllIIlllIllIllIIllllllll, lllllllllllIIlllIllIllIIllllIIII, lllllllllllIIlllIllIllIIlllIllll, lllllllllllIIlllIllIllIIlllllIll, lllllllllllIIlllIllIllIIlllIllIl, lllllllllllIIlllIllIllIIllllIlII);
            this.modelElytra.render(lllllllllllIIlllIllIllIIllllIlII, lllllllllllIIlllIllIllIIllllIIll, lllllllllllIIlllIllIllIIllllllll, lllllllllllIIlllIllIllIIllllIIII, lllllllllllIIlllIllIllIIlllIllll, lllllllllllIIlllIllIllIIlllllIll, lllllllllllIIlllIllIllIIlllIllIl);
            if (lllllllllllIIlllIllIllIIlllllIIl.isItemEnchanted()) {
                LayerArmorBase.renderEnchantedGlint(this.renderPlayer, lllllllllllIIlllIllIllIIllllIlII, this.modelElytra, lllllllllllIIlllIllIllIIllllIIll, lllllllllllIIlllIllIllIIllllllll, lllllllllllIIlllIllIllIIlllllllI, lllllllllllIIlllIllIllIIllllIIII, lllllllllllIIlllIllIllIIlllIllll, lllllllllllIIlllIllIllIIlllllIll, lllllllllllIIlllIllIllIIlllIllIl);
            }
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
}
