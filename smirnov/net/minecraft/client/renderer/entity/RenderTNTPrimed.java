// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;

public class RenderTNTPrimed extends Render<EntityTNTPrimed>
{
    @Override
    protected ResourceLocation getEntityTexture(final EntityTNTPrimed llllllllllllIllIlIIIlIlIlllIllll) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
    
    @Override
    public void doRender(final EntityTNTPrimed llllllllllllIllIlIIIlIllIIIIIlII, final double llllllllllllIllIlIIIlIllIIIIIIll, final double llllllllllllIllIlIIIlIlIllllIlll, final double llllllllllllIllIlIIIlIllIIIIIIIl, final float llllllllllllIllIlIIIlIllIIIIIIII, final float llllllllllllIllIlIIIlIlIllllIlII) {
        final BlockRendererDispatcher llllllllllllIllIlIIIlIlIlllllllI = Minecraft.getMinecraft().getBlockRendererDispatcher();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllIllIlIIIlIllIIIIIIll, (float)llllllllllllIllIlIIIlIlIllllIlll + 0.5f, (float)llllllllllllIllIlIIIlIllIIIIIIIl);
        if (llllllllllllIllIlIIIlIllIIIIIlII.getFuse() - llllllllllllIllIlIIIlIlIllllIlII + 1.0f < 10.0f) {
            float llllllllllllIllIlIIIlIlIllllllIl = 1.0f - (llllllllllllIllIlIIIlIllIIIIIlII.getFuse() - llllllllllllIllIlIIIlIlIllllIlII + 1.0f) / 10.0f;
            llllllllllllIllIlIIIlIlIllllllIl = MathHelper.clamp(llllllllllllIllIlIIIlIlIllllllIl, 0.0f, 1.0f);
            llllllllllllIllIlIIIlIlIllllllIl *= llllllllllllIllIlIIIlIlIllllllIl;
            llllllllllllIllIlIIIlIlIllllllIl *= llllllllllllIllIlIIIlIlIllllllIl;
            final float llllllllllllIllIlIIIlIlIllllllII = 1.0f + llllllllllllIllIlIIIlIlIllllllIl * 0.3f;
            GlStateManager.scale(llllllllllllIllIlIIIlIlIllllllII, llllllllllllIllIlIIIlIlIllllllII, llllllllllllIllIlIIIlIlIllllllII);
        }
        final float llllllllllllIllIlIIIlIlIlllllIll = (1.0f - (llllllllllllIllIlIIIlIllIIIIIlII.getFuse() - llllllllllllIllIlIIIlIlIllllIlII + 1.0f) / 100.0f) * 0.8f;
        this.bindEntityTexture(llllllllllllIllIlIIIlIllIIIIIlII);
        GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(-0.5f, -0.5f, 0.5f);
        llllllllllllIllIlIIIlIlIlllllllI.renderBlockBrightness(Blocks.TNT.getDefaultState(), llllllllllllIllIlIIIlIllIIIIIlII.getBrightness());
        GlStateManager.translate(0.0f, 0.0f, 1.0f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllIllIlIIIlIllIIIIIlII));
            llllllllllllIllIlIIIlIlIlllllllI.renderBlockBrightness(Blocks.TNT.getDefaultState(), 1.0f);
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        else if (llllllllllllIllIlIIIlIllIIIIIlII.getFuse() / 5 % 2 == 0) {
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.DST_ALPHA);
            GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllIllIlIIIlIlIlllllIll);
            GlStateManager.doPolygonOffset(-3.0f, -3.0f);
            GlStateManager.enablePolygonOffset();
            llllllllllllIllIlIIIlIlIlllllllI.renderBlockBrightness(Blocks.TNT.getDefaultState(), 1.0f);
            GlStateManager.doPolygonOffset(0.0f, 0.0f);
            GlStateManager.disablePolygonOffset();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
        }
        GlStateManager.popMatrix();
        super.doRender(llllllllllllIllIlIIIlIllIIIIIlII, llllllllllllIllIlIIIlIllIIIIIIll, llllllllllllIllIlIIIlIlIllllIlll, llllllllllllIllIlIIIlIllIIIIIIIl, llllllllllllIllIlIIIlIllIIIIIIII, llllllllllllIllIlIIIlIlIllllIlII);
    }
    
    public RenderTNTPrimed(final RenderManager llllllllllllIllIlIIIlIllIIIlIIlI) {
        super(llllllllllllIllIlIIIlIllIIIlIIlI);
        this.shadowSize = 0.5f;
    }
}
