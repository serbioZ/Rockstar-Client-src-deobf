// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.tileentity.TileEntity;
import java.util.Calendar;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntityChest;

public class TileEntityChestRenderer extends TileEntitySpecialRenderer<TileEntityChest>
{
    private static final /* synthetic */ ResourceLocation TEXTURE_NORMAL;
    private static final /* synthetic */ ResourceLocation TEXTURE_CHRISTMAS;
    private static final /* synthetic */ ResourceLocation TEXTURE_TRAPPED;
    private static final /* synthetic */ ResourceLocation TEXTURE_NORMAL_DOUBLE;
    private final /* synthetic */ ModelChest largeChest;
    private /* synthetic */ boolean isChristmas;
    private static final /* synthetic */ ResourceLocation TEXTURE_TRAPPED_DOUBLE;
    private final /* synthetic */ ModelChest simpleChest;
    private static final /* synthetic */ ResourceLocation TEXTURE_CHRISTMAS_DOUBLE;
    
    @Override
    public void func_192841_a(final TileEntityChest lIIlllIllllIIlI, final double lIIlllIlllIIIII, final double lIIlllIllllIIII, final double lIIlllIllIllllI, final float lIIlllIllIlllIl, final int lIIlllIllIlllII, final float lIIlllIlllIllII) {
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
        int lIIlllIlllIlIlI;
        if (lIIlllIllllIIlI.hasWorldObj()) {
            final Block lIIlllIlllIlIIl = lIIlllIllllIIlI.getBlockType();
            int lIIlllIlllIlIll = lIIlllIllllIIlI.getBlockMetadata();
            if (lIIlllIlllIlIIl instanceof BlockChest && lIIlllIlllIlIll == 0) {
                ((BlockChest)lIIlllIlllIlIIl).checkForSurroundingChests(lIIlllIllllIIlI.getWorld(), lIIlllIllllIIlI.getPos(), lIIlllIllllIIlI.getWorld().getBlockState(lIIlllIllllIIlI.getPos()));
                lIIlllIlllIlIll = lIIlllIllllIIlI.getBlockMetadata();
            }
            lIIlllIllllIIlI.checkForAdjacentChests();
        }
        else {
            lIIlllIlllIlIlI = 0;
        }
        if (lIIlllIllllIIlI.adjacentChestZNeg == null && lIIlllIllllIIlI.adjacentChestXNeg == null) {
            ModelChest lIIlllIlllIIlll = null;
            if (lIIlllIllllIIlI.adjacentChestXPos == null && lIIlllIllllIIlI.adjacentChestZPos == null) {
                final ModelChest lIIlllIlllIlIII = this.simpleChest;
                if (lIIlllIllIlllII >= 0) {
                    this.bindTexture(TileEntityChestRenderer.DESTROY_STAGES[lIIlllIllIlllII]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(4.0f, 4.0f, 1.0f);
                    GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
                    GlStateManager.matrixMode(5888);
                }
                else if (this.isChristmas) {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_CHRISTMAS);
                }
                else if (lIIlllIllllIIlI.getChestType() == BlockChest.Type.TRAP) {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_TRAPPED);
                }
                else {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_NORMAL);
                }
            }
            else {
                lIIlllIlllIIlll = this.largeChest;
                if (lIIlllIllIlllII >= 0) {
                    this.bindTexture(TileEntityChestRenderer.DESTROY_STAGES[lIIlllIllIlllII]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(8.0f, 4.0f, 1.0f);
                    GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
                    GlStateManager.matrixMode(5888);
                }
                else if (this.isChristmas) {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_CHRISTMAS_DOUBLE);
                }
                else if (lIIlllIllllIIlI.getChestType() == BlockChest.Type.TRAP) {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_TRAPPED_DOUBLE);
                }
                else {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_NORMAL_DOUBLE);
                }
            }
            GlStateManager.pushMatrix();
            GlStateManager.enableRescaleNormal();
            if (lIIlllIllIlllII < 0) {
                GlStateManager.color(1.0f, 1.0f, 1.0f, lIIlllIlllIllII);
            }
            GlStateManager.translate((float)lIIlllIlllIIIII, (float)lIIlllIllllIIII + 1.0f, (float)lIIlllIllIllllI + 1.0f);
            GlStateManager.scale(1.0f, -1.0f, -1.0f);
            GlStateManager.translate(0.5f, 0.5f, 0.5f);
            int lIIlllIlllIIllI = 0;
            if (lIIlllIlllIlIlI == 2) {
                lIIlllIlllIIllI = 180;
            }
            if (lIIlllIlllIlIlI == 3) {
                lIIlllIlllIIllI = 0;
            }
            if (lIIlllIlllIlIlI == 4) {
                lIIlllIlllIIllI = 90;
            }
            if (lIIlllIlllIlIlI == 5) {
                lIIlllIlllIIllI = -90;
            }
            if (lIIlllIlllIlIlI == 2 && lIIlllIllllIIlI.adjacentChestXPos != null) {
                GlStateManager.translate(1.0f, 0.0f, 0.0f);
            }
            if (lIIlllIlllIlIlI == 5 && lIIlllIllllIIlI.adjacentChestZPos != null) {
                GlStateManager.translate(0.0f, 0.0f, -1.0f);
            }
            GlStateManager.rotate((float)lIIlllIlllIIllI, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, -0.5f);
            float lIIlllIlllIIlIl = lIIlllIllllIIlI.prevLidAngle + (lIIlllIllllIIlI.lidAngle - lIIlllIllllIIlI.prevLidAngle) * lIIlllIllIlllIl;
            if (lIIlllIllllIIlI.adjacentChestZNeg != null) {
                final float lIIlllIlllIIlII = lIIlllIllllIIlI.adjacentChestZNeg.prevLidAngle + (lIIlllIllllIIlI.adjacentChestZNeg.lidAngle - lIIlllIllllIIlI.adjacentChestZNeg.prevLidAngle) * lIIlllIllIlllIl;
                if (lIIlllIlllIIlII > lIIlllIlllIIlIl) {
                    lIIlllIlllIIlIl = lIIlllIlllIIlII;
                }
            }
            if (lIIlllIllllIIlI.adjacentChestXNeg != null) {
                final float lIIlllIlllIIIll = lIIlllIllllIIlI.adjacentChestXNeg.prevLidAngle + (lIIlllIllllIIlI.adjacentChestXNeg.lidAngle - lIIlllIllllIIlI.adjacentChestXNeg.prevLidAngle) * lIIlllIllIlllIl;
                if (lIIlllIlllIIIll > lIIlllIlllIIlIl) {
                    lIIlllIlllIIlIl = lIIlllIlllIIIll;
                }
            }
            lIIlllIlllIIlIl = 1.0f - lIIlllIlllIIlIl;
            lIIlllIlllIIlIl = 1.0f - lIIlllIlllIIlIl * lIIlllIlllIIlIl * lIIlllIlllIIlIl;
            lIIlllIlllIIlll.chestLid.rotateAngleX = -(lIIlllIlllIIlIl * 1.5707964f);
            lIIlllIlllIIlll.renderAll();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (lIIlllIllIlllII >= 0) {
                GlStateManager.matrixMode(5890);
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5888);
            }
        }
    }
    
    public TileEntityChestRenderer() {
        this.simpleChest = new ModelChest();
        this.largeChest = new ModelLargeChest();
        final Calendar lIIllllIIIIIIll = Calendar.getInstance();
        if (lIIllllIIIIIIll.get(2) + 1 == 12 && lIIllllIIIIIIll.get(5) >= 24 && lIIllllIIIIIIll.get(5) <= 26) {
            this.isChristmas = true;
        }
    }
    
    static {
        TEXTURE_TRAPPED_DOUBLE = new ResourceLocation("textures/entity/chest/trapped_double.png");
        TEXTURE_CHRISTMAS_DOUBLE = new ResourceLocation("textures/entity/chest/christmas_double.png");
        TEXTURE_NORMAL_DOUBLE = new ResourceLocation("textures/entity/chest/normal_double.png");
        TEXTURE_TRAPPED = new ResourceLocation("textures/entity/chest/trapped.png");
        TEXTURE_CHRISTMAS = new ResourceLocation("textures/entity/chest/christmas.png");
        TEXTURE_NORMAL = new ResourceLocation("textures/entity/chest/normal.png");
    }
}
