// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.BannerTextures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.model.ModelBanner;
import net.minecraft.tileentity.TileEntityBanner;

public class TileEntityBannerRenderer extends TileEntitySpecialRenderer<TileEntityBanner>
{
    private final /* synthetic */ ModelBanner bannerModel;
    
    public TileEntityBannerRenderer() {
        this.bannerModel = new ModelBanner();
    }
    
    @Nullable
    private ResourceLocation getBannerResourceLocation(final TileEntityBanner lllllllllllIIIIIIIIlIIlIlIIlIIIl) {
        return BannerTextures.BANNER_DESIGNS.getResourceLocation(lllllllllllIIIIIIIIlIIlIlIIlIIIl.getPatternResourceLocation(), lllllllllllIIIIIIIIlIIlIlIIlIIIl.getPatternList(), lllllllllllIIIIIIIIlIIlIlIIlIIIl.getColorList());
    }
    
    @Override
    public void func_192841_a(final TileEntityBanner lllllllllllIIIIIIIIlIIlIlIlIIIlI, final double lllllllllllIIIIIIIIlIIlIlIllIIll, final double lllllllllllIIIIIIIIlIIlIlIlIIIII, final double lllllllllllIIIIIIIIlIIlIlIIlllll, final float lllllllllllIIIIIIIIlIIlIlIllIIII, final int lllllllllllIIIIIIIIlIIlIlIlIllll, final float lllllllllllIIIIIIIIlIIlIlIIlllIl) {
        final boolean lllllllllllIIIIIIIIlIIlIlIlIllIl = lllllllllllIIIIIIIIlIIlIlIlIIIlI.getWorld() != null;
        final boolean lllllllllllIIIIIIIIlIIlIlIlIllII = !lllllllllllIIIIIIIIlIIlIlIlIllIl || lllllllllllIIIIIIIIlIIlIlIlIIIlI.getBlockType() == Blocks.STANDING_BANNER;
        final int lllllllllllIIIIIIIIlIIlIlIlIlIll = lllllllllllIIIIIIIIlIIlIlIlIllIl ? lllllllllllIIIIIIIIlIIlIlIlIIIlI.getBlockMetadata() : 0;
        final long lllllllllllIIIIIIIIlIIlIlIlIlIlI = lllllllllllIIIIIIIIlIIlIlIlIllIl ? lllllllllllIIIIIIIIlIIlIlIlIIIlI.getWorld().getTotalWorldTime() : 0L;
        GlStateManager.pushMatrix();
        final float lllllllllllIIIIIIIIlIIlIlIlIlIIl = 0.6666667f;
        if (lllllllllllIIIIIIIIlIIlIlIlIllII) {
            GlStateManager.translate((float)lllllllllllIIIIIIIIlIIlIlIllIIll + 0.5f, (float)lllllllllllIIIIIIIIlIIlIlIlIIIII + 0.5f, (float)lllllllllllIIIIIIIIlIIlIlIIlllll + 0.5f);
            final float lllllllllllIIIIIIIIlIIlIlIlIlIII = lllllllllllIIIIIIIIlIIlIlIlIlIll * 360 / 16.0f;
            GlStateManager.rotate(-lllllllllllIIIIIIIIlIIlIlIlIlIII, 0.0f, 1.0f, 0.0f);
            this.bannerModel.bannerStand.showModel = true;
        }
        else {
            float lllllllllllIIIIIIIIlIIlIlIlIIlll = 0.0f;
            if (lllllllllllIIIIIIIIlIIlIlIlIlIll == 2) {
                lllllllllllIIIIIIIIlIIlIlIlIIlll = 180.0f;
            }
            if (lllllllllllIIIIIIIIlIIlIlIlIlIll == 4) {
                lllllllllllIIIIIIIIlIIlIlIlIIlll = 90.0f;
            }
            if (lllllllllllIIIIIIIIlIIlIlIlIlIll == 5) {
                lllllllllllIIIIIIIIlIIlIlIlIIlll = -90.0f;
            }
            GlStateManager.translate((float)lllllllllllIIIIIIIIlIIlIlIllIIll + 0.5f, (float)lllllllllllIIIIIIIIlIIlIlIlIIIII - 0.16666667f, (float)lllllllllllIIIIIIIIlIIlIlIIlllll + 0.5f);
            GlStateManager.rotate(-lllllllllllIIIIIIIIlIIlIlIlIIlll, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.3125f, -0.4375f);
            this.bannerModel.bannerStand.showModel = false;
        }
        final BlockPos lllllllllllIIIIIIIIlIIlIlIlIIllI = lllllllllllIIIIIIIIlIIlIlIlIIIlI.getPos();
        final float lllllllllllIIIIIIIIlIIlIlIlIIlIl = lllllllllllIIIIIIIIlIIlIlIlIIllI.getX() * 7 + lllllllllllIIIIIIIIlIIlIlIlIIllI.getY() * 9 + lllllllllllIIIIIIIIlIIlIlIlIIllI.getZ() * 13 + (float)lllllllllllIIIIIIIIlIIlIlIlIlIlI + lllllllllllIIIIIIIIlIIlIlIllIIII;
        this.bannerModel.bannerSlate.rotateAngleX = (-0.0125f + 0.01f * MathHelper.cos(lllllllllllIIIIIIIIlIIlIlIlIIlIl * 3.1415927f * 0.02f)) * 3.1415927f;
        GlStateManager.enableRescaleNormal();
        final ResourceLocation lllllllllllIIIIIIIIlIIlIlIlIIlII = this.getBannerResourceLocation(lllllllllllIIIIIIIIlIIlIlIlIIIlI);
        if (lllllllllllIIIIIIIIlIIlIlIlIIlII != null) {
            this.bindTexture(lllllllllllIIIIIIIIlIIlIlIlIIlII);
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.6666667f, -0.6666667f, -0.6666667f);
            this.bannerModel.renderBanner();
            GlStateManager.popMatrix();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllIIIIIIIIlIIlIlIIlllIl);
        GlStateManager.popMatrix();
    }
}
