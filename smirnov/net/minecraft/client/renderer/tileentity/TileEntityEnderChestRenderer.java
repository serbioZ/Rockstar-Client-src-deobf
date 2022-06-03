// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.model.ModelChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntityEnderChest;

public class TileEntityEnderChestRenderer extends TileEntitySpecialRenderer<TileEntityEnderChest>
{
    private static final /* synthetic */ ResourceLocation ENDER_CHEST_TEXTURE;
    private final /* synthetic */ ModelChest modelChest;
    
    public TileEntityEnderChestRenderer() {
        this.modelChest = new ModelChest();
    }
    
    @Override
    public void func_192841_a(final TileEntityEnderChest llllllllllllllIIllIlIIIIIlllIIlI, final double llllllllllllllIIllIlIIIIIlllIIIl, final double llllllllllllllIIllIlIIIIIlllIIII, final double llllllllllllllIIllIlIIIIIllllIlI, final float llllllllllllllIIllIlIIIIIllllIIl, final int llllllllllllllIIllIlIIIIIllllIII, final float llllllllllllllIIllIlIIIIIlllIlll) {
        int llllllllllllllIIllIlIIIIIlllIllI = 0;
        if (llllllllllllllIIllIlIIIIIlllIIlI.hasWorldObj()) {
            llllllllllllllIIllIlIIIIIlllIllI = llllllllllllllIIllIlIIIIIlllIIlI.getBlockMetadata();
        }
        if (llllllllllllllIIllIlIIIIIllllIII >= 0) {
            this.bindTexture(TileEntityEnderChestRenderer.DESTROY_STAGES[llllllllllllllIIllIlIIIIIllllIII]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 4.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            this.bindTexture(TileEntityEnderChestRenderer.ENDER_CHEST_TEXTURE);
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllllIIllIlIIIIIlllIlll);
        GlStateManager.translate((float)llllllllllllllIIllIlIIIIIlllIIIl, (float)llllllllllllllIIllIlIIIIIlllIIII + 1.0f, (float)llllllllllllllIIllIlIIIIIllllIlI + 1.0f);
        GlStateManager.scale(1.0f, -1.0f, -1.0f);
        GlStateManager.translate(0.5f, 0.5f, 0.5f);
        int llllllllllllllIIllIlIIIIIlllIlIl = 0;
        if (llllllllllllllIIllIlIIIIIlllIllI == 2) {
            llllllllllllllIIllIlIIIIIlllIlIl = 180;
        }
        if (llllllllllllllIIllIlIIIIIlllIllI == 3) {
            llllllllllllllIIllIlIIIIIlllIlIl = 0;
        }
        if (llllllllllllllIIllIlIIIIIlllIllI == 4) {
            llllllllllllllIIllIlIIIIIlllIlIl = 90;
        }
        if (llllllllllllllIIllIlIIIIIlllIllI == 5) {
            llllllllllllllIIllIlIIIIIlllIlIl = -90;
        }
        GlStateManager.rotate((float)llllllllllllllIIllIlIIIIIlllIlIl, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(-0.5f, -0.5f, -0.5f);
        float llllllllllllllIIllIlIIIIIlllIlII = llllllllllllllIIllIlIIIIIlllIIlI.prevLidAngle + (llllllllllllllIIllIlIIIIIlllIIlI.lidAngle - llllllllllllllIIllIlIIIIIlllIIlI.prevLidAngle) * llllllllllllllIIllIlIIIIIllllIIl;
        llllllllllllllIIllIlIIIIIlllIlII = 1.0f - llllllllllllllIIllIlIIIIIlllIlII;
        llllllllllllllIIllIlIIIIIlllIlII = 1.0f - llllllllllllllIIllIlIIIIIlllIlII * llllllllllllllIIllIlIIIIIlllIlII * llllllllllllllIIllIlIIIIIlllIlII;
        this.modelChest.chestLid.rotateAngleX = -(llllllllllllllIIllIlIIIIIlllIlII * 1.5707964f);
        this.modelChest.renderAll();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (llllllllllllllIIllIlIIIIIllllIII >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    static {
        ENDER_CHEST_TEXTURE = new ResourceLocation("textures/entity/chest/ender.png");
    }
}
