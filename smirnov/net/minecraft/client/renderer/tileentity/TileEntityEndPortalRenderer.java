// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import shadersmod.client.ShadersRender;
import optifine.Config;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.tileentity.TileEntity;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import java.nio.FloatBuffer;
import net.minecraft.tileentity.TileEntityEndPortal;

public class TileEntityEndPortalRenderer extends TileEntitySpecialRenderer<TileEntityEndPortal>
{
    private final /* synthetic */ FloatBuffer buffer;
    private static final /* synthetic */ ResourceLocation END_SKY_TEXTURE;
    private static final /* synthetic */ Random RANDOM;
    private static final /* synthetic */ ResourceLocation END_PORTAL_TEXTURE;
    private static final /* synthetic */ FloatBuffer PROJECTION;
    private static final /* synthetic */ FloatBuffer MODELVIEW;
    
    static {
        END_SKY_TEXTURE = new ResourceLocation("textures/environment/end_sky.png");
        END_PORTAL_TEXTURE = new ResourceLocation("textures/entity/end_portal.png");
        RANDOM = new Random(31100L);
        MODELVIEW = GLAllocation.createDirectFloatBuffer(16);
        PROJECTION = GLAllocation.createDirectFloatBuffer(16);
    }
    
    protected int func_191286_a(final double lllllllllllllIllIlIllllIllIlIIII) {
        int lllllllllllllIllIlIllllIllIIIlll = 0;
        if (lllllllllllllIllIlIllllIllIlIIII > 36864.0) {
            final int lllllllllllllIllIlIllllIllIIllll = 1;
        }
        else if (lllllllllllllIllIlIllllIllIlIIII > 25600.0) {
            final int lllllllllllllIllIlIllllIllIIlllI = 3;
        }
        else if (lllllllllllllIllIlIllllIllIlIIII > 16384.0) {
            final int lllllllllllllIllIlIllllIllIIllIl = 5;
        }
        else if (lllllllllllllIllIlIllllIllIlIIII > 9216.0) {
            final int lllllllllllllIllIlIllllIllIIllII = 7;
        }
        else if (lllllllllllllIllIlIllllIllIlIIII > 4096.0) {
            final int lllllllllllllIllIlIllllIllIIlIll = 9;
        }
        else if (lllllllllllllIllIlIllllIllIlIIII > 1024.0) {
            final int lllllllllllllIllIlIllllIllIIlIlI = 11;
        }
        else if (lllllllllllllIllIlIllllIllIlIIII > 576.0) {
            final int lllllllllllllIllIlIllllIllIIlIIl = 13;
        }
        else if (lllllllllllllIllIlIllllIllIlIIII > 256.0) {
            final int lllllllllllllIllIlIllllIllIIlIII = 14;
        }
        else {
            lllllllllllllIllIlIllllIllIIIlll = 15;
        }
        return lllllllllllllIllIlIllllIllIIIlll;
    }
    
    @Override
    public void func_192841_a(final TileEntityEndPortal lllllllllllllIllIlIllllIlllllIIl, final double lllllllllllllIllIlIllllIlllllIII, final double lllllllllllllIllIlIllllIllllIlll, final double lllllllllllllIllIlIllllIlllIIIlI, final float lllllllllllllIllIlIllllIllllIlIl, final int lllllllllllllIllIlIllllIlllIIIII, final float lllllllllllllIllIlIllllIllllIIll) {
        if (!Config.isShaders() || !ShadersRender.renderEndPortal(lllllllllllllIllIlIllllIlllllIIl, lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI, lllllllllllllIllIlIllllIllllIlIl, lllllllllllllIllIlIllllIlllIIIII, this.func_191287_c())) {
            GlStateManager.disableLighting();
            TileEntityEndPortalRenderer.RANDOM.setSeed(31100L);
            GlStateManager.getFloat(2982, TileEntityEndPortalRenderer.MODELVIEW);
            GlStateManager.getFloat(2983, TileEntityEndPortalRenderer.PROJECTION);
            final double lllllllllllllIllIlIllllIllllIIlI = lllllllllllllIllIlIllllIlllllIII * lllllllllllllIllIlIllllIlllllIII + lllllllllllllIllIlIllllIllllIlll * lllllllllllllIllIlIllllIllllIlll + lllllllllllllIllIlIllllIlllIIIlI * lllllllllllllIllIlIllllIlllIIIlI;
            final int lllllllllllllIllIlIllllIllllIIIl = this.func_191286_a(lllllllllllllIllIlIllllIllllIIlI);
            final float lllllllllllllIllIlIllllIllllIIII = this.func_191287_c();
            boolean lllllllllllllIllIlIllllIlllIllll = false;
            for (int lllllllllllllIllIlIllllIlllIlllI = 0; lllllllllllllIllIlIllllIlllIlllI < lllllllllllllIllIlIllllIllllIIIl; ++lllllllllllllIllIlIllllIlllIlllI) {
                GlStateManager.pushMatrix();
                float lllllllllllllIllIlIllllIlllIllIl = 2.0f / (18 - lllllllllllllIllIlIllllIlllIlllI);
                if (lllllllllllllIllIlIllllIlllIlllI == 0) {
                    this.bindTexture(TileEntityEndPortalRenderer.END_SKY_TEXTURE);
                    lllllllllllllIllIlIllllIlllIllIl = 0.15f;
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
                }
                if (lllllllllllllIllIlIllllIlllIlllI >= 1) {
                    this.bindTexture(TileEntityEndPortalRenderer.END_PORTAL_TEXTURE);
                    lllllllllllllIllIlIllllIlllIllll = true;
                    Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
                }
                if (lllllllllllllIllIlIllllIlllIlllI == 1) {
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
                }
                GlStateManager.texGen(GlStateManager.TexGen.S, 9216);
                GlStateManager.texGen(GlStateManager.TexGen.T, 9216);
                GlStateManager.texGen(GlStateManager.TexGen.R, 9216);
                GlStateManager.texGen(GlStateManager.TexGen.S, 9474, this.getBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.texGen(GlStateManager.TexGen.T, 9474, this.getBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GlStateManager.texGen(GlStateManager.TexGen.R, 9474, this.getBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                GlStateManager.enableTexGenCoord(GlStateManager.TexGen.S);
                GlStateManager.enableTexGenCoord(GlStateManager.TexGen.T);
                GlStateManager.enableTexGenCoord(GlStateManager.TexGen.R);
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5890);
                GlStateManager.pushMatrix();
                GlStateManager.loadIdentity();
                GlStateManager.translate(0.5f, 0.5f, 0.0f);
                GlStateManager.scale(0.5f, 0.5f, 1.0f);
                final float lllllllllllllIllIlIllllIlllIllII = (float)(lllllllllllllIllIlIllllIlllIlllI + 1);
                GlStateManager.translate(17.0f / lllllllllllllIllIlIllllIlllIllII, (2.0f + lllllllllllllIllIlIllllIlllIllII / 1.5f) * (Minecraft.getSystemTime() % 800000.0f / 800000.0f), 0.0f);
                GlStateManager.rotate((lllllllllllllIllIlIllllIlllIllII * lllllllllllllIllIlIllllIlllIllII * 4321.0f + lllllllllllllIllIlIllllIlllIllII * 9.0f) * 2.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.scale(4.5f - lllllllllllllIllIlIllllIlllIllII / 4.0f, 4.5f - lllllllllllllIllIlIllllIlllIllII / 4.0f, 1.0f);
                GlStateManager.multMatrix(TileEntityEndPortalRenderer.PROJECTION);
                GlStateManager.multMatrix(TileEntityEndPortalRenderer.MODELVIEW);
                final Tessellator lllllllllllllIllIlIllllIlllIlIll = Tessellator.getInstance();
                final BufferBuilder lllllllllllllIllIlIllllIlllIlIlI = lllllllllllllIllIlIllllIlllIlIll.getBuffer();
                lllllllllllllIllIlIllllIlllIlIlI.begin(7, DefaultVertexFormats.POSITION_COLOR);
                final float lllllllllllllIllIlIllllIlllIlIIl = (TileEntityEndPortalRenderer.RANDOM.nextFloat() * 0.5f + 0.1f) * lllllllllllllIllIlIllllIlllIllIl;
                final float lllllllllllllIllIlIllllIlllIlIII = (TileEntityEndPortalRenderer.RANDOM.nextFloat() * 0.5f + 0.4f) * lllllllllllllIllIlIllllIlllIllIl;
                final float lllllllllllllIllIlIllllIlllIIlll = (TileEntityEndPortalRenderer.RANDOM.nextFloat() * 0.5f + 0.5f) * lllllllllllllIllIlIllllIlllIllIl;
                if (lllllllllllllIllIlIllllIlllllIIl.shouldRenderFace(EnumFacing.SOUTH)) {
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll + 1.0, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll + 1.0, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIllllIlllllIIl.shouldRenderFace(EnumFacing.NORTH)) {
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll + 1.0, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll + 1.0, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIllllIlllllIIl.shouldRenderFace(EnumFacing.EAST)) {
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll + 1.0, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll + 1.0, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIllllIlllllIIl.shouldRenderFace(EnumFacing.WEST)) {
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll + 1.0, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll + 1.0, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIllllIlllllIIl.shouldRenderFace(EnumFacing.DOWN)) {
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIllllIlllllIIl.shouldRenderFace(EnumFacing.UP)) {
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll + lllllllllllllIllIlIllllIllllIIII, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll + lllllllllllllIllIlIllllIllllIIII, lllllllllllllIllIlIllllIlllIIIlI + 1.0).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII + 1.0, lllllllllllllIllIlIllllIllllIlll + lllllllllllllIllIlIllllIllllIIII, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                    lllllllllllllIllIlIllllIlllIlIlI.pos(lllllllllllllIllIlIllllIlllllIII, lllllllllllllIllIlIllllIllllIlll + lllllllllllllIllIlIllllIllllIIII, lllllllllllllIllIlIllllIlllIIIlI).color(lllllllllllllIllIlIllllIlllIlIIl, lllllllllllllIllIlIllllIlllIlIII, lllllllllllllIllIlIllllIlllIIlll, 1.0f).endVertex();
                }
                lllllllllllllIllIlIllllIlllIlIll.draw();
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5888);
                this.bindTexture(TileEntityEndPortalRenderer.END_SKY_TEXTURE);
            }
            GlStateManager.disableBlend();
            GlStateManager.disableTexGenCoord(GlStateManager.TexGen.S);
            GlStateManager.disableTexGenCoord(GlStateManager.TexGen.T);
            GlStateManager.disableTexGenCoord(GlStateManager.TexGen.R);
            GlStateManager.enableLighting();
            if (lllllllllllllIllIlIllllIlllIllll) {
                Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
            }
        }
    }
    
    public TileEntityEndPortalRenderer() {
        this.buffer = GLAllocation.createDirectFloatBuffer(16);
    }
    
    private FloatBuffer getBuffer(final float lllllllllllllIllIlIllllIlIllllIl, final float lllllllllllllIllIlIllllIlIllIlll, final float lllllllllllllIllIlIllllIlIllIllI, final float lllllllllllllIllIlIllllIlIllIlIl) {
        this.buffer.clear();
        this.buffer.put(lllllllllllllIllIlIllllIlIllllIl).put(lllllllllllllIllIlIllllIlIllIlll).put(lllllllllllllIllIlIllllIlIllIllI).put(lllllllllllllIllIlIllllIlIllIlIl);
        this.buffer.flip();
        return this.buffer;
    }
    
    protected float func_191287_c() {
        return 0.75f;
    }
}
