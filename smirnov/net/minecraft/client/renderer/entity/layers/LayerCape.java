// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;

public class LayerCape implements LayerRenderer<AbstractClientPlayer>
{
    private final /* synthetic */ RenderPlayer playerRenderer;
    
    public LayerCape(final RenderPlayer lllllllllllIllIIlllIllIIIIIllIll) {
        this.playerRenderer = lllllllllllIllIIlllIllIIIIIllIll;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final AbstractClientPlayer lllllllllllIllIIlllIllIIIIIIlIIl, final float lllllllllllIllIIlllIllIIIIIIlIII, final float lllllllllllIllIIlllIllIIIIIIIlll, final float lllllllllllIllIIlllIlIllllllIlII, final float lllllllllllIllIIlllIllIIIIIIIlIl, final float lllllllllllIllIIlllIllIIIIIIIlII, final float lllllllllllIllIIlllIllIIIIIIIIll, final float lllllllllllIllIIlllIllIIIIIIIIlI) {
        if (lllllllllllIllIIlllIllIIIIIIlIIl.hasPlayerInfo() && !lllllllllllIllIIlllIllIIIIIIlIIl.isInvisible() && lllllllllllIllIIlllIllIIIIIIlIIl.isWearing(EnumPlayerModelParts.CAPE) && lllllllllllIllIIlllIllIIIIIIlIIl.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
            final ItemStack lllllllllllIllIIlllIllIIIIIIIIIl = lllllllllllIllIIlllIllIIIIIIlIIl.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            if (lllllllllllIllIIlllIllIIIIIIIIIl.getItem() != Items.ELYTRA) {
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.playerRenderer.bindTexture(new ResourceLocation("rockstar/pink.png"));
                GlStateManager.pushMatrix();
                GlStateManager.translate(0.0f, 0.0f, 0.125f);
                final double lllllllllllIllIIlllIllIIIIIIIIII = lllllllllllIllIIlllIllIIIIIIlIIl.prevChasingPosX + (lllllllllllIllIIlllIllIIIIIIlIIl.chasingPosX - lllllllllllIllIIlllIllIIIIIIlIIl.prevChasingPosX) * lllllllllllIllIIlllIlIllllllIlII - (lllllllllllIllIIlllIllIIIIIIlIIl.prevPosX + (lllllllllllIllIIlllIllIIIIIIlIIl.posX - lllllllllllIllIIlllIllIIIIIIlIIl.prevPosX) * lllllllllllIllIIlllIlIllllllIlII);
                final double lllllllllllIllIIlllIlIllllllllll = lllllllllllIllIIlllIllIIIIIIlIIl.prevChasingPosY + (lllllllllllIllIIlllIllIIIIIIlIIl.chasingPosY - lllllllllllIllIIlllIllIIIIIIlIIl.prevChasingPosY) * lllllllllllIllIIlllIlIllllllIlII - (lllllllllllIllIIlllIllIIIIIIlIIl.prevPosY + (lllllllllllIllIIlllIllIIIIIIlIIl.posY - lllllllllllIllIIlllIllIIIIIIlIIl.prevPosY) * lllllllllllIllIIlllIlIllllllIlII);
                final double lllllllllllIllIIlllIlIlllllllllI = lllllllllllIllIIlllIllIIIIIIlIIl.prevChasingPosZ + (lllllllllllIllIIlllIllIIIIIIlIIl.chasingPosZ - lllllllllllIllIIlllIllIIIIIIlIIl.prevChasingPosZ) * lllllllllllIllIIlllIlIllllllIlII - (lllllllllllIllIIlllIllIIIIIIlIIl.prevPosZ + (lllllllllllIllIIlllIllIIIIIIlIIl.posZ - lllllllllllIllIIlllIllIIIIIIlIIl.prevPosZ) * lllllllllllIllIIlllIlIllllllIlII);
                final float lllllllllllIllIIlllIlIllllllllIl = lllllllllllIllIIlllIllIIIIIIlIIl.prevRenderYawOffset + (lllllllllllIllIIlllIllIIIIIIlIIl.renderYawOffset - lllllllllllIllIIlllIllIIIIIIlIIl.prevRenderYawOffset) * lllllllllllIllIIlllIlIllllllIlII;
                final double lllllllllllIllIIlllIlIllllllllII = MathHelper.sin(lllllllllllIllIIlllIlIllllllllIl * 0.017453292f);
                final double lllllllllllIllIIlllIlIlllllllIll = -MathHelper.cos(lllllllllllIllIIlllIlIllllllllIl * 0.017453292f);
                float lllllllllllIllIIlllIlIlllllllIlI = (float)lllllllllllIllIIlllIlIllllllllll * 10.0f;
                lllllllllllIllIIlllIlIlllllllIlI = MathHelper.clamp(lllllllllllIllIIlllIlIlllllllIlI, -6.0f, 32.0f);
                float lllllllllllIllIIlllIlIlllllllIIl = (float)(lllllllllllIllIIlllIllIIIIIIIIII * lllllllllllIllIIlllIlIllllllllII + lllllllllllIllIIlllIlIlllllllllI * lllllllllllIllIIlllIlIlllllllIll) * 50.0f;
                final float lllllllllllIllIIlllIlIlllllllIII = (float)(lllllllllllIllIIlllIllIIIIIIIIII * lllllllllllIllIIlllIlIlllllllIll - lllllllllllIllIIlllIlIlllllllllI * lllllllllllIllIIlllIlIllllllllII) * 50.0f;
                if (lllllllllllIllIIlllIlIlllllllIIl < 0.0f) {
                    lllllllllllIllIIlllIlIlllllllIIl = 0.0f;
                }
                if (lllllllllllIllIIlllIlIlllllllIIl > 165.0f) {
                    lllllllllllIllIIlllIlIlllllllIIl = 165.0f;
                }
                final float lllllllllllIllIIlllIlIllllllIlll = lllllllllllIllIIlllIllIIIIIIlIIl.prevCameraYaw + (lllllllllllIllIIlllIllIIIIIIlIIl.cameraYaw - lllllllllllIllIIlllIllIIIIIIlIIl.prevCameraYaw) * lllllllllllIllIIlllIlIllllllIlII;
                lllllllllllIllIIlllIlIlllllllIlI += MathHelper.sin((lllllllllllIllIIlllIllIIIIIIlIIl.prevDistanceWalkedModified + (lllllllllllIllIIlllIllIIIIIIlIIl.distanceWalkedModified - lllllllllllIllIIlllIllIIIIIIlIIl.prevDistanceWalkedModified) * lllllllllllIllIIlllIlIllllllIlII) * 6.0f) * 32.0f * lllllllllllIllIIlllIlIllllllIlll;
                if (lllllllllllIllIIlllIllIIIIIIlIIl.isSneaking()) {
                    lllllllllllIllIIlllIlIlllllllIlI += 25.0f;
                    GlStateManager.translate(0.0f, 0.142f, -0.0178f);
                }
                GlStateManager.rotate(6.0f + lllllllllllIllIIlllIlIlllllllIIl / 2.0f + lllllllllllIllIIlllIlIlllllllIlI, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(lllllllllllIllIIlllIlIlllllllIII / 2.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(-lllllllllllIllIIlllIlIlllllllIII / 2.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.popMatrix();
            }
        }
    }
}
