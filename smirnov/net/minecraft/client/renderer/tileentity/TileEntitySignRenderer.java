// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import java.util.List;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.block.Block;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import optifine.CustomColors;
import optifine.Config;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelSign;
import net.minecraft.tileentity.TileEntitySign;

public class TileEntitySignRenderer extends TileEntitySpecialRenderer<TileEntitySign>
{
    private final /* synthetic */ ModelSign model;
    private static final /* synthetic */ ResourceLocation SIGN_TEXTURE;
    
    static {
        SIGN_TEXTURE = new ResourceLocation("textures/entity/sign.png");
    }
    
    public TileEntitySignRenderer() {
        this.model = new ModelSign();
    }
    
    @Override
    public void func_192841_a(final TileEntitySign lllllllllllIIlllIIlIIIlIIIIllIIl, final double lllllllllllIIlllIIlIIIlIIIIllIII, final double lllllllllllIIlllIIlIIIlIIIIIIIll, final double lllllllllllIIlllIIlIIIlIIIIIIIlI, final float lllllllllllIIlllIIlIIIlIIIIlIlIl, final int lllllllllllIIlllIIlIIIlIIIIlIlII, final float lllllllllllIIlllIIlIIIlIIIIlIIll) {
        final Block lllllllllllIIlllIIlIIIlIIIIlIIlI = lllllllllllIIlllIIlIIIlIIIIllIIl.getBlockType();
        GlStateManager.pushMatrix();
        final float lllllllllllIIlllIIlIIIlIIIIlIIIl = 0.6666667f;
        if (lllllllllllIIlllIIlIIIlIIIIlIIlI == Blocks.STANDING_SIGN) {
            GlStateManager.translate((float)lllllllllllIIlllIIlIIIlIIIIllIII + 0.5f, (float)lllllllllllIIlllIIlIIIlIIIIIIIll + 0.5f, (float)lllllllllllIIlllIIlIIIlIIIIIIIlI + 0.5f);
            final float lllllllllllIIlllIIlIIIlIIIIlIIII = lllllllllllIIlllIIlIIIlIIIIllIIl.getBlockMetadata() * 360 / 16.0f;
            GlStateManager.rotate(-lllllllllllIIlllIIlIIIlIIIIlIIII, 0.0f, 1.0f, 0.0f);
            this.model.signStick.showModel = true;
        }
        else {
            final int lllllllllllIIlllIIlIIIlIIIIIllll = lllllllllllIIlllIIlIIIlIIIIllIIl.getBlockMetadata();
            float lllllllllllIIlllIIlIIIlIIIIIlllI = 0.0f;
            if (lllllllllllIIlllIIlIIIlIIIIIllll == 2) {
                lllllllllllIIlllIIlIIIlIIIIIlllI = 180.0f;
            }
            if (lllllllllllIIlllIIlIIIlIIIIIllll == 4) {
                lllllllllllIIlllIIlIIIlIIIIIlllI = 90.0f;
            }
            if (lllllllllllIIlllIIlIIIlIIIIIllll == 5) {
                lllllllllllIIlllIIlIIIlIIIIIlllI = -90.0f;
            }
            GlStateManager.translate((float)lllllllllllIIlllIIlIIIlIIIIllIII + 0.5f, (float)lllllllllllIIlllIIlIIIlIIIIIIIll + 0.5f, (float)lllllllllllIIlllIIlIIIlIIIIIIIlI + 0.5f);
            GlStateManager.rotate(-lllllllllllIIlllIIlIIIlIIIIIlllI, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.3125f, -0.4375f);
            this.model.signStick.showModel = false;
        }
        if (lllllllllllIIlllIIlIIIlIIIIlIlII >= 0) {
            this.bindTexture(TileEntitySignRenderer.DESTROY_STAGES[lllllllllllIIlllIIlIIIlIIIIlIlII]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 2.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            this.bindTexture(TileEntitySignRenderer.SIGN_TEXTURE);
        }
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.6666667f, -0.6666667f, -0.6666667f);
        this.model.renderSign();
        GlStateManager.popMatrix();
        final FontRenderer lllllllllllIIlllIIlIIIlIIIIIllIl = this.getFontRenderer();
        final float lllllllllllIIlllIIlIIIlIIIIIllII = 0.010416667f;
        GlStateManager.translate(0.0f, 0.33333334f, 0.046666667f);
        GlStateManager.scale(0.010416667f, -0.010416667f, 0.010416667f);
        GlStateManager.glNormal3f(0.0f, 0.0f, -0.010416667f);
        GlStateManager.depthMask(false);
        int lllllllllllIIlllIIlIIIlIIIIIlIll = 0;
        if (Config.isCustomColors()) {
            lllllllllllIIlllIIlIIIlIIIIIlIll = CustomColors.getSignTextColor(lllllllllllIIlllIIlIIIlIIIIIlIll);
        }
        if (lllllllllllIIlllIIlIIIlIIIIlIlII < 0) {
            for (int lllllllllllIIlllIIlIIIlIIIIIlIlI = 0; lllllllllllIIlllIIlIIIlIIIIIlIlI < lllllllllllIIlllIIlIIIlIIIIllIIl.signText.length; ++lllllllllllIIlllIIlIIIlIIIIIlIlI) {
                if (lllllllllllIIlllIIlIIIlIIIIllIIl.signText[lllllllllllIIlllIIlIIIlIIIIIlIlI] != null) {
                    final ITextComponent lllllllllllIIlllIIlIIIlIIIIIlIIl = lllllllllllIIlllIIlIIIlIIIIllIIl.signText[lllllllllllIIlllIIlIIIlIIIIIlIlI];
                    final List<ITextComponent> lllllllllllIIlllIIlIIIlIIIIIlIII = GuiUtilRenderComponents.splitText(lllllllllllIIlllIIlIIIlIIIIIlIIl, 90, lllllllllllIIlllIIlIIIlIIIIIllIl, false, true);
                    String lllllllllllIIlllIIlIIIlIIIIIIlll = (lllllllllllIIlllIIlIIIlIIIIIlIII != null && !lllllllllllIIlllIIlIIIlIIIIIlIII.isEmpty()) ? lllllllllllIIlllIIlIIIlIIIIIlIII.get(0).getFormattedText() : "";
                    if (lllllllllllIIlllIIlIIIlIIIIIlIlI == lllllllllllIIlllIIlIIIlIIIIllIIl.lineBeingEdited) {
                        lllllllllllIIlllIIlIIIlIIIIIIlll = "> " + lllllllllllIIlllIIlIIIlIIIIIIlll + " <";
                        lllllllllllIIlllIIlIIIlIIIIIllIl.drawString(lllllllllllIIlllIIlIIIlIIIIIIlll, (float)(-lllllllllllIIlllIIlIIIlIIIIIllIl.getStringWidth(lllllllllllIIlllIIlIIIlIIIIIIlll) / 2), (float)(lllllllllllIIlllIIlIIIlIIIIIlIlI * 10 - lllllllllllIIlllIIlIIIlIIIIllIIl.signText.length * 5), lllllllllllIIlllIIlIIIlIIIIIlIll);
                    }
                    else {
                        lllllllllllIIlllIIlIIIlIIIIIllIl.drawString(lllllllllllIIlllIIlIIIlIIIIIIlll, (float)(-lllllllllllIIlllIIlIIIlIIIIIllIl.getStringWidth(lllllllllllIIlllIIlIIIlIIIIIIlll) / 2), (float)(lllllllllllIIlllIIlIIIlIIIIIlIlI * 10 - lllllllllllIIlllIIlIIIlIIIIllIIl.signText.length * 5), lllllllllllIIlllIIlIIIlIIIIIlIll);
                    }
                }
            }
        }
        GlStateManager.depthMask(true);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
        if (lllllllllllIIlllIIlIIIlIIIIlIlII >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
}
