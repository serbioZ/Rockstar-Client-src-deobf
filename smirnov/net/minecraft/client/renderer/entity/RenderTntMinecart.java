// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.init.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityMinecartTNT;

public class RenderTntMinecart extends RenderMinecart<EntityMinecartTNT>
{
    @Override
    protected void renderCartContents(final EntityMinecartTNT llllllllllIlllllllIIllIIllllIlIl, final float llllllllllIlllllllIIllIIllllIlII, final IBlockState llllllllllIlllllllIIllIIlllIlIll) {
        final int llllllllllIlllllllIIllIIllllIIlI = llllllllllIlllllllIIllIIllllIlIl.getFuseTicks();
        if (llllllllllIlllllllIIllIIllllIIlI > -1 && llllllllllIlllllllIIllIIllllIIlI - llllllllllIlllllllIIllIIllllIlII + 1.0f < 10.0f) {
            float llllllllllIlllllllIIllIIllllIIIl = 1.0f - (llllllllllIlllllllIIllIIllllIIlI - llllllllllIlllllllIIllIIllllIlII + 1.0f) / 10.0f;
            llllllllllIlllllllIIllIIllllIIIl = MathHelper.clamp(llllllllllIlllllllIIllIIllllIIIl, 0.0f, 1.0f);
            llllllllllIlllllllIIllIIllllIIIl *= llllllllllIlllllllIIllIIllllIIIl;
            llllllllllIlllllllIIllIIllllIIIl *= llllllllllIlllllllIIllIIllllIIIl;
            final float llllllllllIlllllllIIllIIllllIIII = 1.0f + llllllllllIlllllllIIllIIllllIIIl * 0.3f;
            GlStateManager.scale(llllllllllIlllllllIIllIIllllIIII, llllllllllIlllllllIIllIIllllIIII, llllllllllIlllllllIIllIIllllIIII);
        }
        super.renderCartContents(llllllllllIlllllllIIllIIllllIlIl, llllllllllIlllllllIIllIIllllIlII, llllllllllIlllllllIIllIIlllIlIll);
        if (llllllllllIlllllllIIllIIllllIIlI > -1 && llllllllllIlllllllIIllIIllllIIlI / 5 % 2 == 0) {
            final BlockRendererDispatcher llllllllllIlllllllIIllIIlllIllll = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.DST_ALPHA);
            GlStateManager.color(1.0f, 1.0f, 1.0f, (1.0f - (llllllllllIlllllllIIllIIllllIIlI - llllllllllIlllllllIIllIIllllIlII + 1.0f) / 100.0f) * 0.8f);
            GlStateManager.pushMatrix();
            llllllllllIlllllllIIllIIlllIllll.renderBlockBrightness(Blocks.TNT.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
        }
    }
    
    public RenderTntMinecart(final RenderManager llllllllllIlllllllIIllIIlllllllI) {
        super(llllllllllIlllllllIIllIIlllllllI);
    }
}
