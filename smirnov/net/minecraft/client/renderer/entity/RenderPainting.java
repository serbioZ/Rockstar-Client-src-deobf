// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.item.EntityPainting;

public class RenderPainting extends Render<EntityPainting>
{
    private static final /* synthetic */ ResourceLocation KRISTOFFER_PAINTING_TEXTURE;
    
    static {
        KRISTOFFER_PAINTING_TEXTURE = new ResourceLocation("textures/painting/paintings_kristoffer_zetterstrand.png");
    }
    
    public RenderPainting(final RenderManager llllllllllllIIlllIllIIIllIlllIll) {
        super(llllllllllllIIlllIllIIIllIlllIll);
    }
    
    private void setLightmap(final EntityPainting llllllllllllIIlllIllIIIlIIlIlllI, final float llllllllllllIIlllIllIIIlIIlIllIl, final float llllllllllllIIlllIllIIIlIIlIIIIl) {
        int llllllllllllIIlllIllIIIlIIlIlIll = MathHelper.floor(llllllllllllIIlllIllIIIlIIlIlllI.posX);
        final int llllllllllllIIlllIllIIIlIIlIlIlI = MathHelper.floor(llllllllllllIIlllIllIIIlIIlIlllI.posY + llllllllllllIIlllIllIIIlIIlIIIIl / 16.0f);
        int llllllllllllIIlllIllIIIlIIlIlIIl = MathHelper.floor(llllllllllllIIlllIllIIIlIIlIlllI.posZ);
        final EnumFacing llllllllllllIIlllIllIIIlIIlIlIII = llllllllllllIIlllIllIIIlIIlIlllI.facingDirection;
        if (llllllllllllIIlllIllIIIlIIlIlIII == EnumFacing.NORTH) {
            llllllllllllIIlllIllIIIlIIlIlIll = MathHelper.floor(llllllllllllIIlllIllIIIlIIlIlllI.posX + llllllllllllIIlllIllIIIlIIlIllIl / 16.0f);
        }
        if (llllllllllllIIlllIllIIIlIIlIlIII == EnumFacing.WEST) {
            llllllllllllIIlllIllIIIlIIlIlIIl = MathHelper.floor(llllllllllllIIlllIllIIIlIIlIlllI.posZ - llllllllllllIIlllIllIIIlIIlIllIl / 16.0f);
        }
        if (llllllllllllIIlllIllIIIlIIlIlIII == EnumFacing.SOUTH) {
            llllllllllllIIlllIllIIIlIIlIlIll = MathHelper.floor(llllllllllllIIlllIllIIIlIIlIlllI.posX - llllllllllllIIlllIllIIIlIIlIllIl / 16.0f);
        }
        if (llllllllllllIIlllIllIIIlIIlIlIII == EnumFacing.EAST) {
            llllllllllllIIlllIllIIIlIIlIlIIl = MathHelper.floor(llllllllllllIIlllIllIIIlIIlIlllI.posZ + llllllllllllIIlllIllIIIlIIlIllIl / 16.0f);
        }
        final int llllllllllllIIlllIllIIIlIIlIIlll = this.renderManager.worldObj.getCombinedLight(new BlockPos(llllllllllllIIlllIllIIIlIIlIlIll, llllllllllllIIlllIllIIIlIIlIlIlI, llllllllllllIIlllIllIIIlIIlIlIIl), 0);
        final int llllllllllllIIlllIllIIIlIIlIIllI = llllllllllllIIlllIllIIIlIIlIIlll % 65536;
        final int llllllllllllIIlllIllIIIlIIlIIlIl = llllllllllllIIlllIllIIIlIIlIIlll / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)llllllllllllIIlllIllIIIlIIlIIllI, (float)llllllllllllIIlllIllIIIlIIlIIlIl);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
    }
    
    private void renderPainting(final EntityPainting llllllllllllIIlllIllIIIlIlIllIlI, final int llllllllllllIIlllIllIIIlIlIllIIl, final int llllllllllllIIlllIllIIIlIllllIIl, final int llllllllllllIIlllIllIIIlIlIlIlll, final int llllllllllllIIlllIllIIIlIlllIlll) {
        final float llllllllllllIIlllIllIIIlIlllIllI = -llllllllllllIIlllIllIIIlIlIllIIl / 2.0f;
        final float llllllllllllIIlllIllIIIlIlllIlIl = -llllllllllllIIlllIllIIIlIllllIIl / 2.0f;
        final float llllllllllllIIlllIllIIIlIlllIlII = 0.5f;
        final float llllllllllllIIlllIllIIIlIlllIIll = 0.75f;
        final float llllllllllllIIlllIllIIIlIlllIIlI = 0.8125f;
        final float llllllllllllIIlllIllIIIlIlllIIIl = 0.0f;
        final float llllllllllllIIlllIllIIIlIlllIIII = 0.0625f;
        final float llllllllllllIIlllIllIIIlIllIllll = 0.75f;
        final float llllllllllllIIlllIllIIIlIllIlllI = 0.8125f;
        final float llllllllllllIIlllIllIIIlIllIllIl = 0.001953125f;
        final float llllllllllllIIlllIllIIIlIllIllII = 0.001953125f;
        final float llllllllllllIIlllIllIIIlIllIlIll = 0.7519531f;
        final float llllllllllllIIlllIllIIIlIllIlIlI = 0.7519531f;
        final float llllllllllllIIlllIllIIIlIllIlIIl = 0.0f;
        final float llllllllllllIIlllIllIIIlIllIlIII = 0.0625f;
        for (int llllllllllllIIlllIllIIIlIllIIlll = 0; llllllllllllIIlllIllIIIlIllIIlll < llllllllllllIIlllIllIIIlIlIllIIl / 16; ++llllllllllllIIlllIllIIIlIllIIlll) {
            for (int llllllllllllIIlllIllIIIlIllIIllI = 0; llllllllllllIIlllIllIIIlIllIIllI < llllllllllllIIlllIllIIIlIllllIIl / 16; ++llllllllllllIIlllIllIIIlIllIIllI) {
                final float llllllllllllIIlllIllIIIlIllIIlIl = llllllllllllIIlllIllIIIlIlllIllI + (llllllllllllIIlllIllIIIlIllIIlll + 1) * 16;
                final float llllllllllllIIlllIllIIIlIllIIlII = llllllllllllIIlllIllIIIlIlllIllI + llllllllllllIIlllIllIIIlIllIIlll * 16;
                final float llllllllllllIIlllIllIIIlIllIIIll = llllllllllllIIlllIllIIIlIlllIlIl + (llllllllllllIIlllIllIIIlIllIIllI + 1) * 16;
                final float llllllllllllIIlllIllIIIlIllIIIlI = llllllllllllIIlllIllIIIlIlllIlIl + llllllllllllIIlllIllIIIlIllIIllI * 16;
                this.setLightmap(llllllllllllIIlllIllIIIlIlIllIlI, (llllllllllllIIlllIllIIIlIllIIlIl + llllllllllllIIlllIllIIIlIllIIlII) / 2.0f, (llllllllllllIIlllIllIIIlIllIIIll + llllllllllllIIlllIllIIIlIllIIIlI) / 2.0f);
                final float llllllllllllIIlllIllIIIlIllIIIIl = (llllllllllllIIlllIllIIIlIlIlIlll + llllllllllllIIlllIllIIIlIlIllIIl - llllllllllllIIlllIllIIIlIllIIlll * 16) / 256.0f;
                final float llllllllllllIIlllIllIIIlIllIIIII = (llllllllllllIIlllIllIIIlIlIlIlll + llllllllllllIIlllIllIIIlIlIllIIl - (llllllllllllIIlllIllIIIlIllIIlll + 1) * 16) / 256.0f;
                final float llllllllllllIIlllIllIIIlIlIlllll = (llllllllllllIIlllIllIIIlIlllIlll + llllllllllllIIlllIllIIIlIllllIIl - llllllllllllIIlllIllIIIlIllIIllI * 16) / 256.0f;
                final float llllllllllllIIlllIllIIIlIlIllllI = (llllllllllllIIlllIllIIIlIlllIlll + llllllllllllIIlllIllIIIlIllllIIl - (llllllllllllIIlllIllIIIlIllIIllI + 1) * 16) / 256.0f;
                final Tessellator llllllllllllIIlllIllIIIlIlIlllIl = Tessellator.getInstance();
                final BufferBuilder llllllllllllIIlllIllIIIlIlIlllII = llllllllllllIIlllIllIIIlIlIlllIl.getBuffer();
                llllllllllllIIlllIllIIIlIlIlllII.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIlI, -0.5).tex(llllllllllllIIlllIllIIIlIllIIIII, llllllllllllIIlllIllIIIlIlIlllll).normal(0.0f, 0.0f, -1.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIlI, -0.5).tex(llllllllllllIIlllIllIIIlIllIIIIl, llllllllllllIIlllIllIIIlIlIlllll).normal(0.0f, 0.0f, -1.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIll, -0.5).tex(llllllllllllIIlllIllIIIlIllIIIIl, llllllllllllIIlllIllIIIlIlIllllI).normal(0.0f, 0.0f, -1.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIll, -0.5).tex(llllllllllllIIlllIllIIIlIllIIIII, llllllllllllIIlllIllIIIlIlIllllI).normal(0.0f, 0.0f, -1.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIll, 0.5).tex(0.75, 0.0).normal(0.0f, 0.0f, 1.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIll, 0.5).tex(0.8125, 0.0).normal(0.0f, 0.0f, 1.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIlI, 0.5).tex(0.8125, 0.0625).normal(0.0f, 0.0f, 1.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIlI, 0.5).tex(0.75, 0.0625).normal(0.0f, 0.0f, 1.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIll, -0.5).tex(0.75, 0.001953125).normal(0.0f, 1.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIll, -0.5).tex(0.8125, 0.001953125).normal(0.0f, 1.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIll, 0.5).tex(0.8125, 0.001953125).normal(0.0f, 1.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIll, 0.5).tex(0.75, 0.001953125).normal(0.0f, 1.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIlI, 0.5).tex(0.75, 0.001953125).normal(0.0f, -1.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIlI, 0.5).tex(0.8125, 0.001953125).normal(0.0f, -1.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIlI, -0.5).tex(0.8125, 0.001953125).normal(0.0f, -1.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIlI, -0.5).tex(0.75, 0.001953125).normal(0.0f, -1.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIll, 0.5).tex(0.751953125, 0.0).normal(-1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIlI, 0.5).tex(0.751953125, 0.0625).normal(-1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIlI, -0.5).tex(0.751953125, 0.0625).normal(-1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlIl, llllllllllllIIlllIllIIIlIllIIIll, -0.5).tex(0.751953125, 0.0).normal(-1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIll, -0.5).tex(0.751953125, 0.0).normal(1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIlI, -0.5).tex(0.751953125, 0.0625).normal(1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIlI, 0.5).tex(0.751953125, 0.0625).normal(1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllII.pos(llllllllllllIIlllIllIIIlIllIIlII, llllllllllllIIlllIllIIIlIllIIIll, 0.5).tex(0.751953125, 0.0).normal(1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllIIlllIllIIIlIlIlllIl.draw();
            }
        }
    }
    
    @Override
    public void doRender(final EntityPainting llllllllllllIIlllIllIIIllIlIIlll, final double llllllllllllIIlllIllIIIllIlIllll, final double llllllllllllIIlllIllIIIllIlIlllI, final double llllllllllllIIlllIllIIIllIlIIlII, final float llllllllllllIIlllIllIIIllIlIllII, final float llllllllllllIIlllIllIIIllIlIlIll) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(llllllllllllIIlllIllIIIllIlIllll, llllllllllllIIlllIllIIIllIlIlllI, llllllllllllIIlllIllIIIllIlIIlII);
        GlStateManager.rotate(180.0f - llllllllllllIIlllIllIIIllIlIllII, 0.0f, 1.0f, 0.0f);
        GlStateManager.enableRescaleNormal();
        this.bindEntityTexture(llllllllllllIIlllIllIIIllIlIIlll);
        final EntityPainting.EnumArt llllllllllllIIlllIllIIIllIlIlIlI = llllllllllllIIlllIllIIIllIlIIlll.art;
        final float llllllllllllIIlllIllIIIllIlIlIIl = 0.0625f;
        GlStateManager.scale(0.0625f, 0.0625f, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllIIlllIllIIIllIlIIlll));
        }
        this.renderPainting(llllllllllllIIlllIllIIIllIlIIlll, llllllllllllIIlllIllIIIllIlIlIlI.sizeX, llllllllllllIIlllIllIIIllIlIlIlI.sizeY, llllllllllllIIlllIllIIIllIlIlIlI.offsetX, llllllllllllIIlllIllIIIllIlIlIlI.offsetY);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(llllllllllllIIlllIllIIIllIlIIlll, llllllllllllIIlllIllIIIllIlIllll, llllllllllllIIlllIllIIIllIlIlllI, llllllllllllIIlllIllIIIllIlIIlII, llllllllllllIIlllIllIIIllIlIllII, llllllllllllIIlllIllIIIllIlIlIll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityPainting llllllllllllIIlllIllIIIllIIllllI) {
        return RenderPainting.KRISTOFFER_PAINTING_TEXTURE;
    }
}
