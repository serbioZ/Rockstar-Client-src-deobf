// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.CrashReport;
import shadersmod.client.SVertexBuilder;
import optifine.ReflectorForge;
import net.minecraft.client.Minecraft;
import optifine.BlockModelCustomizer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.Block;
import optifine.Reflector;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import optifine.ListQuadsOverlay;
import optifine.BetterSnow;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.util.math.Vec3i;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import optifine.Config;
import net.minecraft.util.math.Vec3d;
import java.util.BitSet;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.block.model.FaceBakery;
import optifine.CustomColors;
import optifine.RenderEnv;
import net.minecraft.client.renderer.block.model.BakedQuad;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.client.renderer.color.BlockColors;

public class BlockModelRenderer
{
    private static /* synthetic */ float aoLightValueOpaque;
    private final /* synthetic */ BlockColors blockColors;
    private static final /* synthetic */ BlockRenderLayer[] OVERLAY_LAYERS;
    
    private void renderQuadsFlat(final IBlockAccess lllllllllllIlIIllIlIlIllIIIlIIlI, final IBlockState lllllllllllIlIIllIlIlIllIIIlIIIl, final BlockPos lllllllllllIlIIllIlIlIllIIlIlIIl, int lllllllllllIlIIllIlIlIllIIIIllll, final boolean lllllllllllIlIIllIlIlIllIIlIIlll, final BufferBuilder lllllllllllIlIIllIlIlIllIIlIIllI, final List<BakedQuad> lllllllllllIlIIllIlIlIllIIlIIlIl, final RenderEnv lllllllllllIlIIllIlIlIllIIlIIlII) {
        final BitSet lllllllllllIlIIllIlIlIllIIlIIIll = lllllllllllIlIIllIlIlIllIIlIIlII.getBoundsFlags();
        final Vec3d lllllllllllIlIIllIlIlIllIIlIIIlI = lllllllllllIlIIllIlIlIllIIIlIIIl.func_191059_e(lllllllllllIlIIllIlIlIllIIIlIIlI, lllllllllllIlIIllIlIlIllIIlIlIIl);
        final double lllllllllllIlIIllIlIlIllIIlIIIIl = lllllllllllIlIIllIlIlIllIIlIlIIl.getX() + lllllllllllIlIIllIlIlIllIIlIIIlI.xCoord;
        final double lllllllllllIlIIllIlIlIllIIlIIIII = lllllllllllIlIIllIlIlIllIIlIlIIl.getY() + lllllllllllIlIIllIlIlIllIIlIIIlI.yCoord;
        final double lllllllllllIlIIllIlIlIllIIIlllll = lllllllllllIlIIllIlIlIllIIlIlIIl.getZ() + lllllllllllIlIIllIlIlIllIIlIIIlI.zCoord;
        for (int lllllllllllIlIIllIlIlIllIIIllllI = 0, lllllllllllIlIIllIlIlIllIIIlllIl = lllllllllllIlIIllIlIlIllIIlIIlIl.size(); lllllllllllIlIIllIlIlIllIIIllllI < lllllllllllIlIIllIlIlIllIIIlllIl; ++lllllllllllIlIIllIlIlIllIIIllllI) {
            final BakedQuad lllllllllllIlIIllIlIlIllIIIlllII = lllllllllllIlIIllIlIlIllIIlIIlIl.get(lllllllllllIlIIllIlIlIllIIIllllI);
            if (lllllllllllIlIIllIlIlIllIIlIIlll) {
                this.fillQuadBounds(lllllllllllIlIIllIlIlIllIIIlIIIl, lllllllllllIlIIllIlIlIllIIIlllII.getVertexData(), lllllllllllIlIIllIlIlIllIIIlllII.getFace(), null, lllllllllllIlIIllIlIlIllIIlIIIll);
                final BlockPos lllllllllllIlIIllIlIlIllIIIllIll = lllllllllllIlIIllIlIlIllIIlIIIll.get(0) ? lllllllllllIlIIllIlIlIllIIlIlIIl.offset(lllllllllllIlIIllIlIlIllIIIlllII.getFace()) : lllllllllllIlIIllIlIlIllIIlIlIIl;
                lllllllllllIlIIllIlIlIllIIIIllll = lllllllllllIlIIllIlIlIllIIIlIIIl.getPackedLightmapCoords(lllllllllllIlIIllIlIlIllIIIlIIlI, lllllllllllIlIIllIlIlIllIIIllIll);
            }
            if (lllllllllllIlIIllIlIlIllIIlIIllI.isMultiTexture()) {
                lllllllllllIlIIllIlIlIllIIlIIllI.addVertexData(lllllllllllIlIIllIlIlIllIIIlllII.getVertexDataSingle());
                lllllllllllIlIIllIlIlIllIIlIIllI.putSprite(lllllllllllIlIIllIlIlIllIIIlllII.getSprite());
            }
            else {
                lllllllllllIlIIllIlIlIllIIlIIllI.addVertexData(lllllllllllIlIIllIlIlIllIIIlllII.getVertexData());
            }
            lllllllllllIlIIllIlIlIllIIlIIllI.putBrightness4(lllllllllllIlIIllIlIlIllIIIIllll, lllllllllllIlIIllIlIlIllIIIIllll, lllllllllllIlIIllIlIlIllIIIIllll, lllllllllllIlIIllIlIlIllIIIIllll);
            final int lllllllllllIlIIllIlIlIllIIIllIlI = CustomColors.getColorMultiplier(lllllllllllIlIIllIlIlIllIIIlllII, lllllllllllIlIIllIlIlIllIIIlIIIl, lllllllllllIlIIllIlIlIllIIIlIIlI, lllllllllllIlIIllIlIlIllIIlIlIIl, lllllllllllIlIIllIlIlIllIIlIIlII);
            if (!lllllllllllIlIIllIlIlIllIIIlllII.hasTintIndex() && lllllllllllIlIIllIlIlIllIIIllIlI == -1) {
                if (lllllllllllIlIIllIlIlIllIIIlllII.shouldApplyDiffuseLighting()) {
                    final float lllllllllllIlIIllIlIlIllIIIllIIl = FaceBakery.getFaceBrightness(lllllllllllIlIIllIlIlIllIIIlllII.getFace());
                    lllllllllllIlIIllIlIlIllIIlIIllI.putColorMultiplier(lllllllllllIlIIllIlIlIllIIIllIIl, lllllllllllIlIIllIlIlIllIIIllIIl, lllllllllllIlIIllIlIlIllIIIllIIl, 4);
                    lllllllllllIlIIllIlIlIllIIlIIllI.putColorMultiplier(lllllllllllIlIIllIlIlIllIIIllIIl, lllllllllllIlIIllIlIlIllIIIllIIl, lllllllllllIlIIllIlIlIllIIIllIIl, 3);
                    lllllllllllIlIIllIlIlIllIIlIIllI.putColorMultiplier(lllllllllllIlIIllIlIlIllIIIllIIl, lllllllllllIlIIllIlIlIllIIIllIIl, lllllllllllIlIIllIlIlIllIIIllIIl, 2);
                    lllllllllllIlIIllIlIlIllIIlIIllI.putColorMultiplier(lllllllllllIlIIllIlIlIllIIIllIIl, lllllllllllIlIIllIlIlIllIIIllIIl, lllllllllllIlIIllIlIlIllIIIllIIl, 1);
                }
            }
            else {
                int lllllllllllIlIIllIlIlIllIIIllIII;
                if ((lllllllllllIlIIllIlIlIllIIIllIII = lllllllllllIlIIllIlIlIllIIIllIlI) == -1) {
                    lllllllllllIlIIllIlIlIllIIIllIII = this.blockColors.colorMultiplier(lllllllllllIlIIllIlIlIllIIIlIIIl, lllllllllllIlIIllIlIlIllIIIlIIlI, lllllllllllIlIIllIlIlIllIIlIlIIl, lllllllllllIlIIllIlIlIllIIIlllII.getTintIndex());
                }
                if (EntityRenderer.anaglyphEnable) {
                    lllllllllllIlIIllIlIlIllIIIllIII = TextureUtil.anaglyphColor(lllllllllllIlIIllIlIlIllIIIllIII);
                }
                float lllllllllllIlIIllIlIlIllIIIlIlll = (lllllllllllIlIIllIlIlIllIIIllIII >> 16 & 0xFF) / 255.0f;
                float lllllllllllIlIIllIlIlIllIIIlIllI = (lllllllllllIlIIllIlIlIllIIIllIII >> 8 & 0xFF) / 255.0f;
                float lllllllllllIlIIllIlIlIllIIIlIlIl = (lllllllllllIlIIllIlIlIllIIIllIII & 0xFF) / 255.0f;
                if (lllllllllllIlIIllIlIlIllIIIlllII.shouldApplyDiffuseLighting()) {
                    final float lllllllllllIlIIllIlIlIllIIIlIlII = FaceBakery.getFaceBrightness(lllllllllllIlIIllIlIlIllIIIlllII.getFace());
                    lllllllllllIlIIllIlIlIllIIIlIlll *= lllllllllllIlIIllIlIlIllIIIlIlII;
                    lllllllllllIlIIllIlIlIllIIIlIllI *= lllllllllllIlIIllIlIlIllIIIlIlII;
                    lllllllllllIlIIllIlIlIllIIIlIlIl *= lllllllllllIlIIllIlIlIllIIIlIlII;
                }
                lllllllllllIlIIllIlIlIllIIlIIllI.putColorMultiplier(lllllllllllIlIIllIlIlIllIIIlIlll, lllllllllllIlIIllIlIlIllIIIlIllI, lllllllllllIlIIllIlIlIllIIIlIlIl, 4);
                lllllllllllIlIIllIlIlIllIIlIIllI.putColorMultiplier(lllllllllllIlIIllIlIlIllIIIlIlll, lllllllllllIlIIllIlIlIllIIIlIllI, lllllllllllIlIIllIlIlIllIIIlIlIl, 3);
                lllllllllllIlIIllIlIlIllIIlIIllI.putColorMultiplier(lllllllllllIlIIllIlIlIllIIIlIlll, lllllllllllIlIIllIlIlIllIIIlIllI, lllllllllllIlIIllIlIlIllIIIlIlIl, 2);
                lllllllllllIlIIllIlIlIllIIlIIllI.putColorMultiplier(lllllllllllIlIIllIlIlIllIIIlIlll, lllllllllllIlIIllIlIlIllIIIlIllI, lllllllllllIlIIllIlIlIllIIIlIlIl, 1);
            }
            lllllllllllIlIIllIlIlIllIIlIIllI.putPosition(lllllllllllIlIIllIlIlIllIIlIIIIl, lllllllllllIlIIllIlIlIllIIlIIIII, lllllllllllIlIIllIlIlIllIIIlllll);
        }
    }
    
    public static void updateAoLightValue() {
        BlockModelRenderer.aoLightValueOpaque = 1.0f - Config.getAmbientOcclusionLevel() * 0.8f;
    }
    
    private void renderModelBrightnessColorQuads(final float lllllllllllIlIIllIlIlIlIlIlIIIlI, final float lllllllllllIlIIllIlIlIlIlIIlIllI, final float lllllllllllIlIIllIlIlIlIlIIlIlIl, final float lllllllllllIlIIllIlIlIlIlIIlIlII, final List<BakedQuad> lllllllllllIlIIllIlIlIlIlIIlIIll) {
        final Tessellator lllllllllllIlIIllIlIlIlIlIIlllIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIlIIllIlIlIlIlIIlllII = lllllllllllIlIIllIlIlIlIlIIlllIl.getBuffer();
        for (int lllllllllllIlIIllIlIlIlIlIIllIll = 0, lllllllllllIlIIllIlIlIlIlIIllIlI = lllllllllllIlIIllIlIlIlIlIIlIIll.size(); lllllllllllIlIIllIlIlIlIlIIllIll < lllllllllllIlIIllIlIlIlIlIIllIlI; ++lllllllllllIlIIllIlIlIlIlIIllIll) {
            final BakedQuad lllllllllllIlIIllIlIlIlIlIIllIIl = lllllllllllIlIIllIlIlIlIlIIlIIll.get(lllllllllllIlIIllIlIlIlIlIIllIll);
            lllllllllllIlIIllIlIlIlIlIIlllII.begin(7, DefaultVertexFormats.ITEM);
            lllllllllllIlIIllIlIlIlIlIIlllII.addVertexData(lllllllllllIlIIllIlIlIlIlIIllIIl.getVertexData());
            if (lllllllllllIlIIllIlIlIlIlIIllIIl.hasTintIndex()) {
                lllllllllllIlIIllIlIlIlIlIIlllII.putColorRGB_F4(lllllllllllIlIIllIlIlIlIlIIlIllI * lllllllllllIlIIllIlIlIlIlIlIIIlI, lllllllllllIlIIllIlIlIlIlIIlIlIl * lllllllllllIlIIllIlIlIlIlIlIIIlI, lllllllllllIlIIllIlIlIlIlIIlIlII * lllllllllllIlIIllIlIlIlIlIlIIIlI);
            }
            else {
                lllllllllllIlIIllIlIlIlIlIIlllII.putColorRGB_F4(lllllllllllIlIIllIlIlIlIlIlIIIlI, lllllllllllIlIIllIlIlIlIlIlIIIlI, lllllllllllIlIIllIlIlIlIlIlIIIlI);
            }
            final Vec3i lllllllllllIlIIllIlIlIlIlIIllIII = lllllllllllIlIIllIlIlIlIlIIllIIl.getFace().getDirectionVec();
            lllllllllllIlIIllIlIlIlIlIIlllII.putNormal((float)lllllllllllIlIIllIlIlIlIlIIllIII.getX(), (float)lllllllllllIlIIllIlIlIlIlIIllIII.getY(), (float)lllllllllllIlIIllIlIlIlIlIIllIII.getZ());
            lllllllllllIlIIllIlIlIlIlIIlllIl.draw();
        }
    }
    
    public static float fixAoLightValue(final float lllllllllllIlIIllIlIlIlIlIIIlIlI) {
        return (lllllllllllIlIIllIlIlIlIlIIIlIlI == 0.2f) ? BlockModelRenderer.aoLightValueOpaque : lllllllllllIlIIllIlIlIlIlIIIlIlI;
    }
    
    private void renderOverlayModels(final IBlockAccess lllllllllllIlIIllIlIlIlIIlllIlIl, final IBakedModel lllllllllllIlIIllIlIlIlIIlllIlII, final IBlockState lllllllllllIlIIllIlIlIlIIlllIIll, final BlockPos lllllllllllIlIIllIlIlIlIIlllIIlI, final BufferBuilder lllllllllllIlIIllIlIlIlIIlllIIIl, final boolean lllllllllllIlIIllIlIlIlIIlllIIII, final long lllllllllllIlIIllIlIlIlIIllIllll, final RenderEnv lllllllllllIlIIllIlIlIlIIlIllIIl, final boolean lllllllllllIlIIllIlIlIlIIllIllIl) {
        if (lllllllllllIlIIllIlIlIlIIlIllIIl.isOverlaysRendered()) {
            for (int lllllllllllIlIIllIlIlIlIIllIllII = 0; lllllllllllIlIIllIlIlIlIIllIllII < BlockModelRenderer.OVERLAY_LAYERS.length; ++lllllllllllIlIIllIlIlIlIIllIllII) {
                final BlockRenderLayer lllllllllllIlIIllIlIlIlIIllIlIll = BlockModelRenderer.OVERLAY_LAYERS[lllllllllllIlIIllIlIlIlIIllIllII];
                final ListQuadsOverlay lllllllllllIlIIllIlIlIlIIllIlIlI = lllllllllllIlIIllIlIlIlIIlIllIIl.getListQuadsOverlay(lllllllllllIlIIllIlIlIlIIllIlIll);
                if (lllllllllllIlIIllIlIlIlIIllIlIlI.size() > 0) {
                    final RegionRenderCacheBuilder lllllllllllIlIIllIlIlIlIIllIlIIl = lllllllllllIlIIllIlIlIlIIlIllIIl.getRegionRenderCacheBuilder();
                    if (lllllllllllIlIIllIlIlIlIIllIlIIl != null) {
                        final BufferBuilder lllllllllllIlIIllIlIlIlIIllIlIII = lllllllllllIlIIllIlIlIlIIllIlIIl.getWorldRendererByLayer(lllllllllllIlIIllIlIlIlIIllIlIll);
                        if (!lllllllllllIlIIllIlIlIlIIllIlIII.isDrawing()) {
                            lllllllllllIlIIllIlIlIlIIllIlIII.begin(7, DefaultVertexFormats.BLOCK);
                            lllllllllllIlIIllIlIlIlIIllIlIII.setTranslation(lllllllllllIlIIllIlIlIlIIlllIIIl.getXOffset(), lllllllllllIlIIllIlIlIlIIlllIIIl.getYOffset(), lllllllllllIlIIllIlIlIlIIlllIIIl.getZOffset());
                        }
                        for (int lllllllllllIlIIllIlIlIlIIllIIlll = 0; lllllllllllIlIIllIlIlIlIIllIIlll < lllllllllllIlIIllIlIlIlIIllIlIlI.size(); ++lllllllllllIlIIllIlIlIlIIllIIlll) {
                            final BakedQuad lllllllllllIlIIllIlIlIlIIllIIllI = lllllllllllIlIIllIlIlIlIIllIlIlI.getQuad(lllllllllllIlIIllIlIlIlIIllIIlll);
                            final List<BakedQuad> lllllllllllIlIIllIlIlIlIIllIIlIl = (List<BakedQuad>)lllllllllllIlIIllIlIlIlIIllIlIlI.getListQuadsSingle(lllllllllllIlIIllIlIlIlIIllIIllI);
                            final IBlockState lllllllllllIlIIllIlIlIlIIllIIlII = lllllllllllIlIIllIlIlIlIIllIlIlI.getBlockState(lllllllllllIlIIllIlIlIlIIllIIlll);
                            lllllllllllIlIIllIlIlIlIIlIllIIl.reset(lllllllllllIlIIllIlIlIlIIlllIlIl, lllllllllllIlIIllIlIlIlIIllIIlII, lllllllllllIlIIllIlIlIlIIlllIIlI);
                            if (lllllllllllIlIIllIlIlIlIIllIllIl) {
                                this.renderQuadsSmooth(lllllllllllIlIIllIlIlIlIIlllIlIl, lllllllllllIlIIllIlIlIlIIllIIlII, lllllllllllIlIIllIlIlIlIIlllIIlI, lllllllllllIlIIllIlIlIlIIllIlIII, lllllllllllIlIIllIlIlIlIIllIIlIl, lllllllllllIlIIllIlIlIlIIlIllIIl);
                            }
                            else {
                                final int lllllllllllIlIIllIlIlIlIIllIIIll = lllllllllllIlIIllIlIlIlIIllIIlII.getPackedLightmapCoords(lllllllllllIlIIllIlIlIlIIlllIlIl, lllllllllllIlIIllIlIlIlIIlllIIlI.offset(lllllllllllIlIIllIlIlIlIIllIIllI.getFace()));
                                this.renderQuadsFlat(lllllllllllIlIIllIlIlIlIIlllIlIl, lllllllllllIlIIllIlIlIlIIllIIlII, lllllllllllIlIIllIlIlIlIIlllIIlI, lllllllllllIlIIllIlIlIlIIllIIIll, false, lllllllllllIlIIllIlIlIlIIllIlIII, lllllllllllIlIIllIlIlIlIIllIIlIl, lllllllllllIlIIllIlIlIlIIlIllIIl);
                            }
                        }
                    }
                    lllllllllllIlIIllIlIlIlIIllIlIlI.clear();
                }
            }
        }
        if (Config.isBetterSnow() && !lllllllllllIlIIllIlIlIlIIlIllIIl.isBreakingAnimation() && BetterSnow.shouldRender(lllllllllllIlIIllIlIlIlIIlllIlIl, lllllllllllIlIIllIlIlIlIIlllIIll, lllllllllllIlIIllIlIlIlIIlllIIlI)) {
            final IBakedModel lllllllllllIlIIllIlIlIlIIllIIIlI = BetterSnow.getModelSnowLayer();
            final IBlockState lllllllllllIlIIllIlIlIlIIllIIIIl = BetterSnow.getStateSnowLayer();
            this.renderModel(lllllllllllIlIIllIlIlIlIIlllIlIl, lllllllllllIlIIllIlIlIlIIllIIIlI, lllllllllllIlIIllIlIlIlIIllIIIIl, lllllllllllIlIIllIlIlIlIIlllIIlI, lllllllllllIlIIllIlIlIlIIlllIIIl, lllllllllllIlIIllIlIlIlIIlllIIII, lllllllllllIlIIllIlIlIlIIllIllll);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockModelRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short lllllllllllIlIIllIlIlIlIIlIIllII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlIIllIlIlIlIIlIIllII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIllIlIlIlIIlIIllII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIllIlIlIlIIlIIllII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIllIlIlIlIIlIIllII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlIIllIlIlIlIIlIIllII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlIIllIlIlIlIIlIIllII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockModelRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlIIllIlIlIlIIlIIllII;
    }
    
    private void fillQuadBounds(final IBlockState lllllllllllIlIIllIlIlIllIllIIllI, final int[] lllllllllllIlIIllIlIlIllIllIIlIl, final EnumFacing lllllllllllIlIIllIlIlIllIlIlIIIl, @Nullable final float[] lllllllllllIlIIllIlIlIllIlIlIIII, final BitSet lllllllllllIlIIllIlIlIllIllIIIlI) {
        float lllllllllllIlIIllIlIlIllIllIIIIl = 32.0f;
        float lllllllllllIlIIllIlIlIllIllIIIII = 32.0f;
        float lllllllllllIlIIllIlIlIllIlIlllll = 32.0f;
        float lllllllllllIlIIllIlIlIllIlIllllI = -32.0f;
        float lllllllllllIlIIllIlIlIllIlIlllIl = -32.0f;
        float lllllllllllIlIIllIlIlIllIlIlllII = -32.0f;
        final int lllllllllllIlIIllIlIlIllIlIllIll = lllllllllllIlIIllIlIlIllIllIIlIl.length / 4;
        for (int lllllllllllIlIIllIlIlIllIlIllIlI = 0; lllllllllllIlIIllIlIlIllIlIllIlI < 4; ++lllllllllllIlIIllIlIlIllIlIllIlI) {
            final float lllllllllllIlIIllIlIlIllIlIllIIl = Float.intBitsToFloat(lllllllllllIlIIllIlIlIllIllIIlIl[lllllllllllIlIIllIlIlIllIlIllIlI * lllllllllllIlIIllIlIlIllIlIllIll]);
            final float lllllllllllIlIIllIlIlIllIlIllIII = Float.intBitsToFloat(lllllllllllIlIIllIlIlIllIllIIlIl[lllllllllllIlIIllIlIlIllIlIllIlI * lllllllllllIlIIllIlIlIllIlIllIll + 1]);
            final float lllllllllllIlIIllIlIlIllIlIlIlll = Float.intBitsToFloat(lllllllllllIlIIllIlIlIllIllIIlIl[lllllllllllIlIIllIlIlIllIlIllIlI * lllllllllllIlIIllIlIlIllIlIllIll + 2]);
            lllllllllllIlIIllIlIlIllIllIIIIl = Math.min(lllllllllllIlIIllIlIlIllIllIIIIl, lllllllllllIlIIllIlIlIllIlIllIIl);
            lllllllllllIlIIllIlIlIllIllIIIII = Math.min(lllllllllllIlIIllIlIlIllIllIIIII, lllllllllllIlIIllIlIlIllIlIllIII);
            lllllllllllIlIIllIlIlIllIlIlllll = Math.min(lllllllllllIlIIllIlIlIllIlIlllll, lllllllllllIlIIllIlIlIllIlIlIlll);
            lllllllllllIlIIllIlIlIllIlIllllI = Math.max(lllllllllllIlIIllIlIlIllIlIllllI, lllllllllllIlIIllIlIlIllIlIllIIl);
            lllllllllllIlIIllIlIlIllIlIlllIl = Math.max(lllllllllllIlIIllIlIlIllIlIlllIl, lllllllllllIlIIllIlIlIllIlIllIII);
            lllllllllllIlIIllIlIlIllIlIlllII = Math.max(lllllllllllIlIIllIlIlIllIlIlllII, lllllllllllIlIIllIlIlIllIlIlIlll);
        }
        if (lllllllllllIlIIllIlIlIllIlIlIIII != null) {
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.WEST.getIndex()] = lllllllllllIlIIllIlIlIllIllIIIIl;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.EAST.getIndex()] = lllllllllllIlIIllIlIlIllIlIllllI;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.DOWN.getIndex()] = lllllllllllIlIIllIlIlIllIllIIIII;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.UP.getIndex()] = lllllllllllIlIIllIlIlIllIlIlllIl;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.NORTH.getIndex()] = lllllllllllIlIIllIlIlIllIlIlllll;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.SOUTH.getIndex()] = lllllllllllIlIIllIlIlIllIlIlllII;
            final int lllllllllllIlIIllIlIlIllIlIlIllI = EnumFacing.VALUES.length;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.WEST.getIndex() + lllllllllllIlIIllIlIlIllIlIlIllI] = 1.0f - lllllllllllIlIIllIlIlIllIllIIIIl;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.EAST.getIndex() + lllllllllllIlIIllIlIlIllIlIlIllI] = 1.0f - lllllllllllIlIIllIlIlIllIlIllllI;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.DOWN.getIndex() + lllllllllllIlIIllIlIlIllIlIlIllI] = 1.0f - lllllllllllIlIIllIlIlIllIllIIIII;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.UP.getIndex() + lllllllllllIlIIllIlIlIllIlIlIllI] = 1.0f - lllllllllllIlIIllIlIlIllIlIlllIl;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.NORTH.getIndex() + lllllllllllIlIIllIlIlIllIlIlIllI] = 1.0f - lllllllllllIlIIllIlIlIllIlIlllll;
            lllllllllllIlIIllIlIlIllIlIlIIII[EnumFacing.SOUTH.getIndex() + lllllllllllIlIIllIlIlIllIlIlIllI] = 1.0f - lllllllllllIlIIllIlIlIllIlIlllII;
        }
        final float lllllllllllIlIIllIlIlIllIlIlIlIl = 1.0E-4f;
        final float lllllllllllIlIIllIlIlIllIlIlIlII = 0.9999f;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIIllIlIlIllIlIlIIIl.ordinal()]) {
            case 1: {
                lllllllllllIlIIllIlIlIllIllIIIlI.set(1, lllllllllllIlIIllIlIlIllIllIIIIl >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIlllll >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIllllI <= 0.9999f || lllllllllllIlIIllIlIlIllIlIlllII <= 0.9999f);
                lllllllllllIlIIllIlIlIllIllIIIlI.set(0, (lllllllllllIlIIllIlIlIllIllIIIII < 1.0E-4f || lllllllllllIlIIllIlIlIllIllIIllI.isFullCube()) && lllllllllllIlIIllIlIlIllIllIIIII == lllllllllllIlIIllIlIlIllIlIlllIl);
                break;
            }
            case 2: {
                lllllllllllIlIIllIlIlIllIllIIIlI.set(1, lllllllllllIlIIllIlIlIllIllIIIIl >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIlllll >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIllllI <= 0.9999f || lllllllllllIlIIllIlIlIllIlIlllII <= 0.9999f);
                lllllllllllIlIIllIlIlIllIllIIIlI.set(0, (lllllllllllIlIIllIlIlIllIlIlllIl > 0.9999f || lllllllllllIlIIllIlIlIllIllIIllI.isFullCube()) && lllllllllllIlIIllIlIlIllIllIIIII == lllllllllllIlIIllIlIlIllIlIlllIl);
                break;
            }
            case 3: {
                lllllllllllIlIIllIlIlIllIllIIIlI.set(1, lllllllllllIlIIllIlIlIllIllIIIIl >= 1.0E-4f || lllllllllllIlIIllIlIlIllIllIIIII >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIllllI <= 0.9999f || lllllllllllIlIIllIlIlIllIlIlllIl <= 0.9999f);
                lllllllllllIlIIllIlIlIllIllIIIlI.set(0, (lllllllllllIlIIllIlIlIllIlIlllll < 1.0E-4f || lllllllllllIlIIllIlIlIllIllIIllI.isFullCube()) && lllllllllllIlIIllIlIlIllIlIlllll == lllllllllllIlIIllIlIlIllIlIlllII);
                break;
            }
            case 4: {
                lllllllllllIlIIllIlIlIllIllIIIlI.set(1, lllllllllllIlIIllIlIlIllIllIIIIl >= 1.0E-4f || lllllllllllIlIIllIlIlIllIllIIIII >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIllllI <= 0.9999f || lllllllllllIlIIllIlIlIllIlIlllIl <= 0.9999f);
                lllllllllllIlIIllIlIlIllIllIIIlI.set(0, (lllllllllllIlIIllIlIlIllIlIlllII > 0.9999f || lllllllllllIlIIllIlIlIllIllIIllI.isFullCube()) && lllllllllllIlIIllIlIlIllIlIlllll == lllllllllllIlIIllIlIlIllIlIlllII);
                break;
            }
            case 5: {
                lllllllllllIlIIllIlIlIllIllIIIlI.set(1, lllllllllllIlIIllIlIlIllIllIIIII >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIlllll >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIlllIl <= 0.9999f || lllllllllllIlIIllIlIlIllIlIlllII <= 0.9999f);
                lllllllllllIlIIllIlIlIllIllIIIlI.set(0, (lllllllllllIlIIllIlIlIllIllIIIIl < 1.0E-4f || lllllllllllIlIIllIlIlIllIllIIllI.isFullCube()) && lllllllllllIlIIllIlIlIllIllIIIIl == lllllllllllIlIIllIlIlIllIlIllllI);
                break;
            }
            case 6: {
                lllllllllllIlIIllIlIlIllIllIIIlI.set(1, lllllllllllIlIIllIlIlIllIllIIIII >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIlllll >= 1.0E-4f || lllllllllllIlIIllIlIlIllIlIlllIl <= 0.9999f || lllllllllllIlIIllIlIlIllIlIlllII <= 0.9999f);
                lllllllllllIlIIllIlIlIllIllIIIlI.set(0, (lllllllllllIlIIllIlIlIllIlIllllI > 0.9999f || lllllllllllIlIIllIlIlIllIllIIllI.isFullCube()) && lllllllllllIlIIllIlIlIllIllIIIIl == lllllllllllIlIIllIlIlIllIlIllllI);
                break;
            }
        }
    }
    
    public BlockModelRenderer(final BlockColors lllllllllllIlIIllIlIllIIIlIlIIII) {
        this.blockColors = lllllllllllIlIIllIlIllIIIlIlIIII;
        if (Reflector.ForgeModContainer_forgeLightPipelineEnabled.exists()) {
            Reflector.setFieldValue(Reflector.ForgeModContainer_forgeLightPipelineEnabled, (Object)false);
        }
    }
    
    public void renderModelBrightness(final IBakedModel lllllllllllIlIIllIlIlIlIllIIIIIl, final IBlockState lllllllllllIlIIllIlIlIlIllIIIIII, final float lllllllllllIlIIllIlIlIlIlIllIlIl, final boolean lllllllllllIlIIllIlIlIlIlIllIlII) {
        final Block lllllllllllIlIIllIlIlIlIlIllllIl = lllllllllllIlIIllIlIlIlIllIIIIII.getBlock();
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        int lllllllllllIlIIllIlIlIlIlIllllII = this.blockColors.colorMultiplier(lllllllllllIlIIllIlIlIlIllIIIIII, null, null, 0);
        if (EntityRenderer.anaglyphEnable) {
            lllllllllllIlIIllIlIlIlIlIllllII = TextureUtil.anaglyphColor(lllllllllllIlIIllIlIlIlIlIllllII);
        }
        final float lllllllllllIlIIllIlIlIlIlIlllIll = (lllllllllllIlIIllIlIlIlIlIllllII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIlIIllIlIlIlIlIlllIlI = (lllllllllllIlIIllIlIlIlIlIllllII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIlIIllIlIlIlIlIlllIIl = (lllllllllllIlIIllIlIlIlIlIllllII & 0xFF) / 255.0f;
        if (!lllllllllllIlIIllIlIlIlIlIllIlII) {
            GlStateManager.color(lllllllllllIlIIllIlIlIlIlIllIlIl, lllllllllllIlIIllIlIlIlIlIllIlIl, lllllllllllIlIIllIlIlIlIlIllIlIl, 1.0f);
        }
        this.renderModelBrightnessColor(lllllllllllIlIIllIlIlIlIllIIIIII, lllllllllllIlIIllIlIlIlIllIIIIIl, lllllllllllIlIIllIlIlIlIlIllIlIl, lllllllllllIlIIllIlIlIlIlIlllIll, lllllllllllIlIIllIlIlIlIlIlllIlI, lllllllllllIlIIllIlIlIlIlIlllIIl);
    }
    
    public void renderModelBrightnessColor(final IBakedModel lllllllllllIlIIllIlIlIlIlllIllll, final float lllllllllllIlIIllIlIlIlIlllIlllI, final float lllllllllllIlIIllIlIlIlIllllIIll, final float lllllllllllIlIIllIlIlIlIlllIllII, final float lllllllllllIlIIllIlIlIlIlllIlIll) {
        this.renderModelBrightnessColor(null, lllllllllllIlIIllIlIlIlIlllIllll, lllllllllllIlIIllIlIlIlIlllIlllI, lllllllllllIlIIllIlIlIlIllllIIll, lllllllllllIlIIllIlIlIlIlllIllII, lllllllllllIlIIllIlIlIlIlllIlIll);
    }
    
    private void renderQuadsSmooth(final IBlockAccess lllllllllllIlIIllIlIlIlllIIIllII, final IBlockState lllllllllllIlIIllIlIlIlllIIIlIll, final BlockPos lllllllllllIlIIllIlIlIlllIlIIIlI, final BufferBuilder lllllllllllIlIIllIlIlIlllIlIIIIl, final List<BakedQuad> lllllllllllIlIIllIlIlIlllIIIlIII, final RenderEnv lllllllllllIlIIllIlIlIlllIIIIlll) {
        final float[] lllllllllllIlIIllIlIlIlllIIllllI = lllllllllllIlIIllIlIlIlllIIIIlll.getQuadBounds();
        final BitSet lllllllllllIlIIllIlIlIlllIIlllIl = lllllllllllIlIIllIlIlIlllIIIIlll.getBoundsFlags();
        final AmbientOcclusionFace lllllllllllIlIIllIlIlIlllIIlllII = lllllllllllIlIIllIlIlIlllIIIIlll.getAoFace();
        final Vec3d lllllllllllIlIIllIlIlIlllIIllIll = lllllllllllIlIIllIlIlIlllIIIlIll.func_191059_e(lllllllllllIlIIllIlIlIlllIIIllII, lllllllllllIlIIllIlIlIlllIlIIIlI);
        final double lllllllllllIlIIllIlIlIlllIIllIlI = lllllllllllIlIIllIlIlIlllIlIIIlI.getX() + lllllllllllIlIIllIlIlIlllIIllIll.xCoord;
        final double lllllllllllIlIIllIlIlIlllIIllIIl = lllllllllllIlIIllIlIlIlllIlIIIlI.getY() + lllllllllllIlIIllIlIlIlllIIllIll.yCoord;
        final double lllllllllllIlIIllIlIlIlllIIllIII = lllllllllllIlIIllIlIlIlllIlIIIlI.getZ() + lllllllllllIlIIllIlIlIlllIIllIll.zCoord;
        for (int lllllllllllIlIIllIlIlIlllIIlIlll = 0, lllllllllllIlIIllIlIlIlllIIlIllI = lllllllllllIlIIllIlIlIlllIIIlIII.size(); lllllllllllIlIIllIlIlIlllIIlIlll < lllllllllllIlIIllIlIlIlllIIlIllI; ++lllllllllllIlIIllIlIlIlllIIlIlll) {
            final BakedQuad lllllllllllIlIIllIlIlIlllIIlIlIl = lllllllllllIlIIllIlIlIlllIIIlIII.get(lllllllllllIlIIllIlIlIlllIIlIlll);
            this.fillQuadBounds(lllllllllllIlIIllIlIlIlllIIIlIll, lllllllllllIlIIllIlIlIlllIIlIlIl.getVertexData(), lllllllllllIlIIllIlIlIlllIIlIlIl.getFace(), lllllllllllIlIIllIlIlIlllIIllllI, lllllllllllIlIIllIlIlIlllIIlllIl);
            lllllllllllIlIIllIlIlIlllIIlllII.updateVertexBrightness(lllllllllllIlIIllIlIlIlllIIIllII, lllllllllllIlIIllIlIlIlllIIIlIll, lllllllllllIlIIllIlIlIlllIlIIIlI, lllllllllllIlIIllIlIlIlllIIlIlIl.getFace(), lllllllllllIlIIllIlIlIlllIIllllI, lllllllllllIlIIllIlIlIlllIIlllIl);
            if (lllllllllllIlIIllIlIlIlllIlIIIIl.isMultiTexture()) {
                lllllllllllIlIIllIlIlIlllIlIIIIl.addVertexData(lllllllllllIlIIllIlIlIlllIIlIlIl.getVertexDataSingle());
                lllllllllllIlIIllIlIlIlllIlIIIIl.putSprite(lllllllllllIlIIllIlIlIlllIIlIlIl.getSprite());
            }
            else {
                lllllllllllIlIIllIlIlIlllIlIIIIl.addVertexData(lllllllllllIlIIllIlIlIlllIIlIlIl.getVertexData());
            }
            lllllllllllIlIIllIlIlIlllIlIIIIl.putBrightness4(lllllllllllIlIIllIlIlIlllIIlllII.vertexBrightness[0], lllllllllllIlIIllIlIlIlllIIlllII.vertexBrightness[1], lllllllllllIlIIllIlIlIlllIIlllII.vertexBrightness[2], lllllllllllIlIIllIlIlIlllIIlllII.vertexBrightness[3]);
            if (lllllllllllIlIIllIlIlIlllIIlIlIl.shouldApplyDiffuseLighting()) {
                final float lllllllllllIlIIllIlIlIlllIIlIlII = FaceBakery.getFaceBrightness(lllllllllllIlIIllIlIlIlllIIlIlIl.getFace());
                final float[] access$1;
                float[] lllllllllllIlIIllIlIlIlllIIlIIll = access$1 = lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier;
                final int n = 0;
                access$1[n] *= lllllllllllIlIIllIlIlIlllIIlIlII;
                final float[] access$2;
                lllllllllllIlIIllIlIlIlllIIlIIll = (access$2 = lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier);
                final int n2 = 1;
                access$2[n2] *= lllllllllllIlIIllIlIlIlllIIlIlII;
                final float[] access$3;
                lllllllllllIlIIllIlIlIlllIIlIIll = (access$3 = lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier);
                final int n3 = 2;
                access$3[n3] *= lllllllllllIlIIllIlIlIlllIIlIlII;
                final float[] access$4;
                lllllllllllIlIIllIlIlIlllIIlIIll = (access$4 = lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier);
                final int n4 = 3;
                access$4[n4] *= lllllllllllIlIIllIlIlIlllIIlIlII;
            }
            final int lllllllllllIlIIllIlIlIlllIIlIIlI = CustomColors.getColorMultiplier(lllllllllllIlIIllIlIlIlllIIlIlIl, lllllllllllIlIIllIlIlIlllIIIlIll, lllllllllllIlIIllIlIlIlllIIIllII, lllllllllllIlIIllIlIlIlllIlIIIlI, lllllllllllIlIIllIlIlIlllIIIIlll);
            if (!lllllllllllIlIIllIlIlIlllIIlIlIl.hasTintIndex() && lllllllllllIlIIllIlIlIlllIIlIIlI == -1) {
                lllllllllllIlIIllIlIlIlllIlIIIIl.putColorMultiplier(lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[0], lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[0], lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[0], 4);
                lllllllllllIlIIllIlIlIlllIlIIIIl.putColorMultiplier(lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[1], lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[1], lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[1], 3);
                lllllllllllIlIIllIlIlIlllIlIIIIl.putColorMultiplier(lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[2], lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[2], lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[2], 2);
                lllllllllllIlIIllIlIlIlllIlIIIIl.putColorMultiplier(lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[3], lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[3], lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[3], 1);
            }
            else {
                int lllllllllllIlIIllIlIlIlllIIlIIIl;
                if ((lllllllllllIlIIllIlIlIlllIIlIIIl = lllllllllllIlIIllIlIlIlllIIlIIlI) == -1) {
                    lllllllllllIlIIllIlIlIlllIIlIIIl = this.blockColors.colorMultiplier(lllllllllllIlIIllIlIlIlllIIIlIll, lllllllllllIlIIllIlIlIlllIIIllII, lllllllllllIlIIllIlIlIlllIlIIIlI, lllllllllllIlIIllIlIlIlllIIlIlIl.getTintIndex());
                }
                if (EntityRenderer.anaglyphEnable) {
                    lllllllllllIlIIllIlIlIlllIIlIIIl = TextureUtil.anaglyphColor(lllllllllllIlIIllIlIlIlllIIlIIIl);
                }
                final float lllllllllllIlIIllIlIlIlllIIlIIII = (lllllllllllIlIIllIlIlIlllIIlIIIl >> 16 & 0xFF) / 255.0f;
                final float lllllllllllIlIIllIlIlIlllIIIllll = (lllllllllllIlIIllIlIlIlllIIlIIIl >> 8 & 0xFF) / 255.0f;
                final float lllllllllllIlIIllIlIlIlllIIIlllI = (lllllllllllIlIIllIlIlIlllIIlIIIl & 0xFF) / 255.0f;
                lllllllllllIlIIllIlIlIlllIlIIIIl.putColorMultiplier(lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[0] * lllllllllllIlIIllIlIlIlllIIlIIII, lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[0] * lllllllllllIlIIllIlIlIlllIIIllll, lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[0] * lllllllllllIlIIllIlIlIlllIIIlllI, 4);
                lllllllllllIlIIllIlIlIlllIlIIIIl.putColorMultiplier(lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[1] * lllllllllllIlIIllIlIlIlllIIlIIII, lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[1] * lllllllllllIlIIllIlIlIlllIIIllll, lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[1] * lllllllllllIlIIllIlIlIlllIIIlllI, 3);
                lllllllllllIlIIllIlIlIlllIlIIIIl.putColorMultiplier(lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[2] * lllllllllllIlIIllIlIlIlllIIlIIII, lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[2] * lllllllllllIlIIllIlIlIlllIIIllll, lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[2] * lllllllllllIlIIllIlIlIlllIIIlllI, 2);
                lllllllllllIlIIllIlIlIlllIlIIIIl.putColorMultiplier(lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[3] * lllllllllllIlIIllIlIlIlllIIlIIII, lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[3] * lllllllllllIlIIllIlIlIlllIIIllll, lllllllllllIlIIllIlIlIlllIIlllII.vertexColorMultiplier[3] * lllllllllllIlIIllIlIlIlllIIIlllI, 1);
            }
            lllllllllllIlIIllIlIlIlllIlIIIIl.putPosition(lllllllllllIlIIllIlIlIlllIIllIlI, lllllllllllIlIIllIlIlIlllIIllIIl, lllllllllllIlIIllIlIlIlllIIllIII);
        }
    }
    
    public boolean renderModel(final IBlockAccess lllllllllllIlIIllIlIllIIIlIIIlll, final IBakedModel lllllllllllIlIIllIlIllIIIlIIIllI, final IBlockState lllllllllllIlIIllIlIllIIIlIIIlIl, final BlockPos lllllllllllIlIIllIlIllIIIlIIIlII, final BufferBuilder lllllllllllIlIIllIlIllIIIIllllII, final boolean lllllllllllIlIIllIlIllIIIIlllIll) {
        return this.renderModel(lllllllllllIlIIllIlIllIIIlIIIlll, lllllllllllIlIIllIlIllIIIlIIIllI, lllllllllllIlIIllIlIllIIIlIIIlIl, lllllllllllIlIIllIlIllIIIlIIIlII, lllllllllllIlIIllIlIllIIIIllllII, lllllllllllIlIIllIlIllIIIIlllIll, MathHelper.getPositionRandom(lllllllllllIlIIllIlIllIIIlIIIlII));
    }
    
    static {
        BlockModelRenderer.aoLightValueOpaque = 0.2f;
        OVERLAY_LAYERS = new BlockRenderLayer[] { BlockRenderLayer.CUTOUT, BlockRenderLayer.CUTOUT_MIPPED, BlockRenderLayer.TRANSLUCENT };
    }
    
    public boolean renderModelSmooth(final IBlockAccess lllllllllllIlIIllIlIlIllllllIlll, final IBakedModel lllllllllllIlIIllIlIllIIIIIIIIll, final IBlockState lllllllllllIlIIllIlIlIllllllIlIl, final BlockPos lllllllllllIlIIllIlIllIIIIIIIIIl, final BufferBuilder lllllllllllIlIIllIlIlIllllllIIll, final boolean lllllllllllIlIIllIlIlIllllllIIlI, final long lllllllllllIlIIllIlIlIllllllIIIl) {
        boolean lllllllllllIlIIllIlIlIllllllllIl = false;
        final RenderEnv lllllllllllIlIIllIlIlIllllllllII = lllllllllllIlIIllIlIlIllllllIIll.getRenderEnv(lllllllllllIlIIllIlIlIllllllIlll, lllllllllllIlIIllIlIlIllllllIlIl, lllllllllllIlIIllIlIllIIIIIIIIIl);
        final Exception lllllllllllIlIIllIlIlIlllllIlIll;
        final byte lllllllllllIlIIllIlIlIlllllIllII = (byte)((EnumFacing[])(Object)(lllllllllllIlIIllIlIlIlllllIlIll = (Exception)(Object)EnumFacing.VALUES)).length;
        for (float lllllllllllIlIIllIlIlIlllllIllIl = 0; lllllllllllIlIIllIlIlIlllllIllIl < lllllllllllIlIIllIlIlIlllllIllII; ++lllllllllllIlIIllIlIlIlllllIllIl) {
            final EnumFacing lllllllllllIlIIllIlIlIlllllllIll = lllllllllllIlIIllIlIlIlllllIlIll[lllllllllllIlIIllIlIlIlllllIllIl];
            List<BakedQuad> lllllllllllIlIIllIlIlIlllllllIlI = lllllllllllIlIIllIlIllIIIIIIIIll.getQuads(lllllllllllIlIIllIlIlIllllllIlIl, lllllllllllIlIIllIlIlIlllllllIll, lllllllllllIlIIllIlIlIllllllIIIl);
            if (!lllllllllllIlIIllIlIlIlllllllIlI.isEmpty() && (!lllllllllllIlIIllIlIlIllllllIIlI || lllllllllllIlIIllIlIlIllllllIlIl.shouldSideBeRendered(lllllllllllIlIIllIlIlIllllllIlll, lllllllllllIlIIllIlIllIIIIIIIIIl, lllllllllllIlIIllIlIlIlllllllIll))) {
                lllllllllllIlIIllIlIlIlllllllIlI = (List<BakedQuad>)BlockModelCustomizer.getRenderQuads((List)lllllllllllIlIIllIlIlIlllllllIlI, lllllllllllIlIIllIlIlIllllllIlll, lllllllllllIlIIllIlIlIllllllIlIl, lllllllllllIlIIllIlIllIIIIIIIIIl, lllllllllllIlIIllIlIlIlllllllIll, lllllllllllIlIIllIlIlIllllllIIIl, lllllllllllIlIIllIlIlIllllllllII);
                this.renderQuadsSmooth(lllllllllllIlIIllIlIlIllllllIlll, lllllllllllIlIIllIlIlIllllllIlIl, lllllllllllIlIIllIlIllIIIIIIIIIl, lllllllllllIlIIllIlIlIllllllIIll, lllllllllllIlIIllIlIlIlllllllIlI, lllllllllllIlIIllIlIlIllllllllII);
                lllllllllllIlIIllIlIlIllllllllIl = true;
            }
        }
        List<BakedQuad> lllllllllllIlIIllIlIlIlllllllIIl = lllllllllllIlIIllIlIllIIIIIIIIll.getQuads(lllllllllllIlIIllIlIlIllllllIlIl, null, lllllllllllIlIIllIlIlIllllllIIIl);
        if (!lllllllllllIlIIllIlIlIlllllllIIl.isEmpty()) {
            lllllllllllIlIIllIlIlIlllllllIIl = (List<BakedQuad>)BlockModelCustomizer.getRenderQuads((List)lllllllllllIlIIllIlIlIlllllllIIl, lllllllllllIlIIllIlIlIllllllIlll, lllllllllllIlIIllIlIlIllllllIlIl, lllllllllllIlIIllIlIllIIIIIIIIIl, (EnumFacing)null, lllllllllllIlIIllIlIlIllllllIIIl, lllllllllllIlIIllIlIlIllllllllII);
            this.renderQuadsSmooth(lllllllllllIlIIllIlIlIllllllIlll, lllllllllllIlIIllIlIlIllllllIlIl, lllllllllllIlIIllIlIllIIIIIIIIIl, lllllllllllIlIIllIlIlIllllllIIll, lllllllllllIlIIllIlIlIlllllllIIl, lllllllllllIlIIllIlIlIllllllllII);
            lllllllllllIlIIllIlIlIllllllllIl = true;
        }
        return lllllllllllIlIIllIlIlIllllllllIl;
    }
    
    public void renderModelBrightnessColor(final IBlockState lllllllllllIlIIllIlIlIlIllIllllI, final IBakedModel lllllllllllIlIIllIlIlIlIllIlIlIl, final float lllllllllllIlIIllIlIlIlIllIlIlII, final float lllllllllllIlIIllIlIlIlIllIlIIll, final float lllllllllllIlIIllIlIlIlIllIlIIlI, final float lllllllllllIlIIllIlIlIlIllIlIIIl) {
        final boolean lllllllllllIlIIllIlIlIlIllIIllIl;
        final boolean lllllllllllIlIIllIlIlIlIllIIlllI = ((EnumFacing[])(Object)(lllllllllllIlIIllIlIlIlIllIIllIl = (boolean)(Object)EnumFacing.VALUES)).length != 0;
        for (char lllllllllllIlIIllIlIlIlIllIIllll = '\0'; lllllllllllIlIIllIlIlIlIllIIllll < (lllllllllllIlIIllIlIlIlIllIIlllI ? 1 : 0); ++lllllllllllIlIIllIlIlIlIllIIllll) {
            final EnumFacing lllllllllllIlIIllIlIlIlIllIllIII = lllllllllllIlIIllIlIlIlIllIIllIl[lllllllllllIlIIllIlIlIlIllIIllll];
            this.renderModelBrightnessColorQuads(lllllllllllIlIIllIlIlIlIllIlIlII, lllllllllllIlIIllIlIlIlIllIlIIll, lllllllllllIlIIllIlIlIlIllIlIIlI, lllllllllllIlIIllIlIlIlIllIlIIIl, lllllllllllIlIIllIlIlIlIllIlIlIl.getQuads(lllllllllllIlIIllIlIlIlIllIllllI, lllllllllllIlIIllIlIlIlIllIllIII, 0L));
        }
        this.renderModelBrightnessColorQuads(lllllllllllIlIIllIlIlIlIllIlIlII, lllllllllllIlIIllIlIlIlIllIlIIll, lllllllllllIlIIllIlIlIlIllIlIIlI, lllllllllllIlIIllIlIlIlIllIlIIIl, lllllllllllIlIIllIlIlIlIllIlIlIl.getQuads(lllllllllllIlIIllIlIlIlIllIllllI, null, 0L));
    }
    
    public boolean renderModelFlat(final IBlockAccess lllllllllllIlIIllIlIlIllllIllIII, final IBakedModel lllllllllllIlIIllIlIlIllllIIlIIl, final IBlockState lllllllllllIlIIllIlIlIllllIIlIII, final BlockPos lllllllllllIlIIllIlIlIllllIIIlll, final BufferBuilder lllllllllllIlIIllIlIlIllllIIIllI, final boolean lllllllllllIlIIllIlIlIllllIlIIll, final long lllllllllllIlIIllIlIlIllllIlIIlI) {
        boolean lllllllllllIlIIllIlIlIllllIlIIIl = false;
        final RenderEnv lllllllllllIlIIllIlIlIllllIlIIII = lllllllllllIlIIllIlIlIllllIIIllI.getRenderEnv(lllllllllllIlIIllIlIlIllllIllIII, lllllllllllIlIIllIlIlIllllIIlIII, lllllllllllIlIIllIlIlIllllIIIlll);
        final Exception lllllllllllIlIIllIlIlIlllIlllllI;
        final short lllllllllllIlIIllIlIlIlllIllllll = (short)((EnumFacing[])(Object)(lllllllllllIlIIllIlIlIlllIlllllI = (Exception)(Object)EnumFacing.VALUES)).length;
        for (long lllllllllllIlIIllIlIlIllllIIIIII = 0; lllllllllllIlIIllIlIlIllllIIIIII < lllllllllllIlIIllIlIlIlllIllllll; ++lllllllllllIlIIllIlIlIllllIIIIII) {
            final EnumFacing lllllllllllIlIIllIlIlIllllIIllll = lllllllllllIlIIllIlIlIlllIlllllI[lllllllllllIlIIllIlIlIllllIIIIII];
            List<BakedQuad> lllllllllllIlIIllIlIlIllllIIlllI = lllllllllllIlIIllIlIlIllllIIlIIl.getQuads(lllllllllllIlIIllIlIlIllllIIlIII, lllllllllllIlIIllIlIlIllllIIllll, lllllllllllIlIIllIlIlIllllIlIIlI);
            if (!lllllllllllIlIIllIlIlIllllIIlllI.isEmpty() && (!lllllllllllIlIIllIlIlIllllIlIIll || lllllllllllIlIIllIlIlIllllIIlIII.shouldSideBeRendered(lllllllllllIlIIllIlIlIllllIllIII, lllllllllllIlIIllIlIlIllllIIIlll, lllllllllllIlIIllIlIlIllllIIllll))) {
                final int lllllllllllIlIIllIlIlIllllIIllIl = lllllllllllIlIIllIlIlIllllIIlIII.getPackedLightmapCoords(lllllllllllIlIIllIlIlIllllIllIII, lllllllllllIlIIllIlIlIllllIIIlll.offset(lllllllllllIlIIllIlIlIllllIIllll));
                lllllllllllIlIIllIlIlIllllIIlllI = (List<BakedQuad>)BlockModelCustomizer.getRenderQuads((List)lllllllllllIlIIllIlIlIllllIIlllI, lllllllllllIlIIllIlIlIllllIllIII, lllllllllllIlIIllIlIlIllllIIlIII, lllllllllllIlIIllIlIlIllllIIIlll, lllllllllllIlIIllIlIlIllllIIllll, lllllllllllIlIIllIlIlIllllIlIIlI, lllllllllllIlIIllIlIlIllllIlIIII);
                this.renderQuadsFlat(lllllllllllIlIIllIlIlIllllIllIII, lllllllllllIlIIllIlIlIllllIIlIII, lllllllllllIlIIllIlIlIllllIIIlll, lllllllllllIlIIllIlIlIllllIIllIl, false, lllllllllllIlIIllIlIlIllllIIIllI, lllllllllllIlIIllIlIlIllllIIlllI, lllllllllllIlIIllIlIlIllllIlIIII);
                lllllllllllIlIIllIlIlIllllIlIIIl = true;
            }
        }
        List<BakedQuad> lllllllllllIlIIllIlIlIllllIIllII = lllllllllllIlIIllIlIlIllllIIlIIl.getQuads(lllllllllllIlIIllIlIlIllllIIlIII, null, lllllllllllIlIIllIlIlIllllIlIIlI);
        if (!lllllllllllIlIIllIlIlIllllIIllII.isEmpty()) {
            lllllllllllIlIIllIlIlIllllIIllII = (List<BakedQuad>)BlockModelCustomizer.getRenderQuads((List)lllllllllllIlIIllIlIlIllllIIllII, lllllllllllIlIIllIlIlIllllIllIII, lllllllllllIlIIllIlIlIllllIIlIII, lllllllllllIlIIllIlIlIllllIIIlll, (EnumFacing)null, lllllllllllIlIIllIlIlIllllIlIIlI, lllllllllllIlIIllIlIlIllllIlIIII);
            this.renderQuadsFlat(lllllllllllIlIIllIlIlIllllIllIII, lllllllllllIlIIllIlIlIllllIIlIII, lllllllllllIlIIllIlIlIllllIIIlll, -1, true, lllllllllllIlIIllIlIlIllllIIIllI, lllllllllllIlIIllIlIlIllllIIllII, lllllllllllIlIIllIlIlIllllIlIIII);
            lllllllllllIlIIllIlIlIllllIlIIIl = true;
        }
        return lllllllllllIlIIllIlIlIllllIlIIIl;
    }
    
    public boolean renderModel(final IBlockAccess lllllllllllIlIIllIlIllIIIIlIllIl, IBakedModel lllllllllllIlIIllIlIllIIIIIllllI, final IBlockState lllllllllllIlIIllIlIllIIIIIlllIl, final BlockPos lllllllllllIlIIllIlIllIIIIlIlIlI, final BufferBuilder lllllllllllIlIIllIlIllIIIIIllIll, final boolean lllllllllllIlIIllIlIllIIIIlIlIII, long lllllllllllIlIIllIlIllIIIIlIIlll) {
        final boolean lllllllllllIlIIllIlIllIIIIlIIllI = Minecraft.isAmbientOcclusionEnabled() && ReflectorForge.getLightValue(lllllllllllIlIIllIlIllIIIIIlllIl, lllllllllllIlIIllIlIllIIIIlIllIl, lllllllllllIlIIllIlIllIIIIlIlIlI) == 0 && lllllllllllIlIIllIlIllIIIIIllllI.isAmbientOcclusion();
        try {
            if (Config.isShaders()) {
                SVertexBuilder.pushEntity(lllllllllllIlIIllIlIllIIIIIlllIl, lllllllllllIlIIllIlIllIIIIlIlIlI, lllllllllllIlIIllIlIllIIIIlIllIl, lllllllllllIlIIllIlIllIIIIIllIll);
            }
            if (!Config.isAlternateBlocks()) {
                lllllllllllIlIIllIlIllIIIIlIIlll = 0L;
            }
            final RenderEnv lllllllllllIlIIllIlIllIIIIlIIlIl = lllllllllllIlIIllIlIllIIIIIllIll.getRenderEnv(lllllllllllIlIIllIlIllIIIIlIllIl, lllllllllllIlIIllIlIllIIIIIlllIl, lllllllllllIlIIllIlIllIIIIlIlIlI);
            lllllllllllIlIIllIlIllIIIIIllllI = BlockModelCustomizer.getRenderModel(lllllllllllIlIIllIlIllIIIIIllllI, lllllllllllIlIIllIlIllIIIIIlllIl, lllllllllllIlIIllIlIllIIIIlIIlIl);
            final boolean lllllllllllIlIIllIlIllIIIIlIIlII = lllllllllllIlIIllIlIllIIIIlIIllI ? this.renderModelSmooth(lllllllllllIlIIllIlIllIIIIlIllIl, lllllllllllIlIIllIlIllIIIIIllllI, lllllllllllIlIIllIlIllIIIIIlllIl, lllllllllllIlIIllIlIllIIIIlIlIlI, lllllllllllIlIIllIlIllIIIIIllIll, lllllllllllIlIIllIlIllIIIIlIlIII, lllllllllllIlIIllIlIllIIIIlIIlll) : this.renderModelFlat(lllllllllllIlIIllIlIllIIIIlIllIl, lllllllllllIlIIllIlIllIIIIIllllI, lllllllllllIlIIllIlIllIIIIIlllIl, lllllllllllIlIIllIlIllIIIIlIlIlI, lllllllllllIlIIllIlIllIIIIIllIll, lllllllllllIlIIllIlIllIIIIlIlIII, lllllllllllIlIIllIlIllIIIIlIIlll);
            if (lllllllllllIlIIllIlIllIIIIlIIlII) {
                this.renderOverlayModels(lllllllllllIlIIllIlIllIIIIlIllIl, lllllllllllIlIIllIlIllIIIIIllllI, lllllllllllIlIIllIlIllIIIIIlllIl, lllllllllllIlIIllIlIllIIIIlIlIlI, lllllllllllIlIIllIlIllIIIIIllIll, lllllllllllIlIIllIlIllIIIIlIlIII, lllllllllllIlIIllIlIllIIIIlIIlll, lllllllllllIlIIllIlIllIIIIlIIlIl, lllllllllllIlIIllIlIllIIIIlIIllI);
            }
            if (Config.isShaders()) {
                SVertexBuilder.popEntity(lllllllllllIlIIllIlIllIIIIIllIll);
            }
            return lllllllllllIlIIllIlIllIIIIlIIlII;
        }
        catch (Throwable lllllllllllIlIIllIlIllIIIIlIIIll) {
            final CrashReport lllllllllllIlIIllIlIllIIIIlIIIlI = CrashReport.makeCrashReport(lllllllllllIlIIllIlIllIIIIlIIIll, "Tesselating block model");
            final CrashReportCategory lllllllllllIlIIllIlIllIIIIlIIIIl = lllllllllllIlIIllIlIllIIIIlIIIlI.makeCategory("Block model being tesselated");
            CrashReportCategory.addBlockInfo(lllllllllllIlIIllIlIllIIIIlIIIIl, lllllllllllIlIIllIlIllIIIIlIlIlI, lllllllllllIlIIllIlIllIIIIIlllIl);
            lllllllllllIlIIllIlIllIIIIlIIIIl.addCrashSection("Using AO", lllllllllllIlIIllIlIllIIIIlIIllI);
            throw new ReportedException(lllllllllllIlIIllIlIllIIIIlIIIlI);
        }
    }
    
    public enum Orientation
    {
        FLIP_EAST("FLIP_EAST", 11, EnumFacing.EAST, true), 
        FLIP_NORTH("FLIP_NORTH", 8, EnumFacing.NORTH, true);
        
        private final /* synthetic */ int shape;
        
        EAST("EAST", 5, EnumFacing.EAST, false), 
        WEST("WEST", 4, EnumFacing.WEST, false), 
        FLIP_SOUTH("FLIP_SOUTH", 9, EnumFacing.SOUTH, true), 
        NORTH("NORTH", 2, EnumFacing.NORTH, false), 
        FLIP_UP("FLIP_UP", 7, EnumFacing.UP, true), 
        FLIP_WEST("FLIP_WEST", 10, EnumFacing.WEST, true), 
        SOUTH("SOUTH", 3, EnumFacing.SOUTH, false), 
        DOWN("DOWN", 0, EnumFacing.DOWN, false), 
        FLIP_DOWN("FLIP_DOWN", 6, EnumFacing.DOWN, true), 
        UP("UP", 1, EnumFacing.UP, false);
        
        private Orientation(final String llllllllllllIlllIIlllIlIllllllIl, final int llllllllllllIlllIIlllIlIllllllII, final EnumFacing llllllllllllIlllIIlllIlIlllllIll, final boolean llllllllllllIlllIIlllIlIllllllll) {
            this.shape = llllllllllllIlllIIlllIlIlllllIll.getIndex() + (llllllllllllIlllIIlllIlIllllllll ? EnumFacing.values().length : 0);
        }
    }
    
    public enum EnumNeighborInfo
    {
        private final /* synthetic */ Orientation[] vert1Weights;
        private final /* synthetic */ float shadeWeight;
        
        SOUTH("SOUTH", 3, new EnumFacing[] { EnumFacing.WEST, EnumFacing.EAST, EnumFacing.DOWN, EnumFacing.UP }, 0.8f, true, new Orientation[] { Orientation.UP, Orientation.FLIP_WEST, Orientation.FLIP_UP, Orientation.FLIP_WEST, Orientation.FLIP_UP, Orientation.WEST, Orientation.UP, Orientation.WEST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_WEST, Orientation.FLIP_DOWN, Orientation.FLIP_WEST, Orientation.FLIP_DOWN, Orientation.WEST, Orientation.DOWN, Orientation.WEST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_EAST, Orientation.FLIP_DOWN, Orientation.FLIP_EAST, Orientation.FLIP_DOWN, Orientation.EAST, Orientation.DOWN, Orientation.EAST }, new Orientation[] { Orientation.UP, Orientation.FLIP_EAST, Orientation.FLIP_UP, Orientation.FLIP_EAST, Orientation.FLIP_UP, Orientation.EAST, Orientation.UP, Orientation.EAST }), 
        EAST("EAST", 5, new EnumFacing[] { EnumFacing.DOWN, EnumFacing.UP, EnumFacing.NORTH, EnumFacing.SOUTH }, 0.6f, true, new Orientation[] { Orientation.FLIP_DOWN, Orientation.SOUTH, Orientation.FLIP_DOWN, Orientation.FLIP_SOUTH, Orientation.DOWN, Orientation.FLIP_SOUTH, Orientation.DOWN, Orientation.SOUTH }, new Orientation[] { Orientation.FLIP_DOWN, Orientation.NORTH, Orientation.FLIP_DOWN, Orientation.FLIP_NORTH, Orientation.DOWN, Orientation.FLIP_NORTH, Orientation.DOWN, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_UP, Orientation.NORTH, Orientation.FLIP_UP, Orientation.FLIP_NORTH, Orientation.UP, Orientation.FLIP_NORTH, Orientation.UP, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_UP, Orientation.SOUTH, Orientation.FLIP_UP, Orientation.FLIP_SOUTH, Orientation.UP, Orientation.FLIP_SOUTH, Orientation.UP, Orientation.SOUTH }), 
        WEST("WEST", 4, new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN, EnumFacing.NORTH, EnumFacing.SOUTH }, 0.6f, true, new Orientation[] { Orientation.UP, Orientation.SOUTH, Orientation.UP, Orientation.FLIP_SOUTH, Orientation.FLIP_UP, Orientation.FLIP_SOUTH, Orientation.FLIP_UP, Orientation.SOUTH }, new Orientation[] { Orientation.UP, Orientation.NORTH, Orientation.UP, Orientation.FLIP_NORTH, Orientation.FLIP_UP, Orientation.FLIP_NORTH, Orientation.FLIP_UP, Orientation.NORTH }, new Orientation[] { Orientation.DOWN, Orientation.NORTH, Orientation.DOWN, Orientation.FLIP_NORTH, Orientation.FLIP_DOWN, Orientation.FLIP_NORTH, Orientation.FLIP_DOWN, Orientation.NORTH }, new Orientation[] { Orientation.DOWN, Orientation.SOUTH, Orientation.DOWN, Orientation.FLIP_SOUTH, Orientation.FLIP_DOWN, Orientation.FLIP_SOUTH, Orientation.FLIP_DOWN, Orientation.SOUTH });
        
        private final /* synthetic */ Orientation[] vert3Weights;
        
        UP("UP", 1, new EnumFacing[] { EnumFacing.EAST, EnumFacing.WEST, EnumFacing.NORTH, EnumFacing.SOUTH }, 1.0f, true, new Orientation[] { Orientation.EAST, Orientation.SOUTH, Orientation.EAST, Orientation.FLIP_SOUTH, Orientation.FLIP_EAST, Orientation.FLIP_SOUTH, Orientation.FLIP_EAST, Orientation.SOUTH }, new Orientation[] { Orientation.EAST, Orientation.NORTH, Orientation.EAST, Orientation.FLIP_NORTH, Orientation.FLIP_EAST, Orientation.FLIP_NORTH, Orientation.FLIP_EAST, Orientation.NORTH }, new Orientation[] { Orientation.WEST, Orientation.NORTH, Orientation.WEST, Orientation.FLIP_NORTH, Orientation.FLIP_WEST, Orientation.FLIP_NORTH, Orientation.FLIP_WEST, Orientation.NORTH }, new Orientation[] { Orientation.WEST, Orientation.SOUTH, Orientation.WEST, Orientation.FLIP_SOUTH, Orientation.FLIP_WEST, Orientation.FLIP_SOUTH, Orientation.FLIP_WEST, Orientation.SOUTH });
        
        private final /* synthetic */ boolean doNonCubicWeight;
        
        DOWN("DOWN", 0, new EnumFacing[] { EnumFacing.WEST, EnumFacing.EAST, EnumFacing.NORTH, EnumFacing.SOUTH }, 0.5f, true, new Orientation[] { Orientation.FLIP_WEST, Orientation.SOUTH, Orientation.FLIP_WEST, Orientation.FLIP_SOUTH, Orientation.WEST, Orientation.FLIP_SOUTH, Orientation.WEST, Orientation.SOUTH }, new Orientation[] { Orientation.FLIP_WEST, Orientation.NORTH, Orientation.FLIP_WEST, Orientation.FLIP_NORTH, Orientation.WEST, Orientation.FLIP_NORTH, Orientation.WEST, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_EAST, Orientation.NORTH, Orientation.FLIP_EAST, Orientation.FLIP_NORTH, Orientation.EAST, Orientation.FLIP_NORTH, Orientation.EAST, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_EAST, Orientation.SOUTH, Orientation.FLIP_EAST, Orientation.FLIP_SOUTH, Orientation.EAST, Orientation.FLIP_SOUTH, Orientation.EAST, Orientation.SOUTH });
        
        private static final /* synthetic */ EnumNeighborInfo[] VALUES;
        private final /* synthetic */ EnumFacing[] corners;
        
        NORTH("NORTH", 2, new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN, EnumFacing.EAST, EnumFacing.WEST }, 0.8f, true, new Orientation[] { Orientation.UP, Orientation.FLIP_WEST, Orientation.UP, Orientation.WEST, Orientation.FLIP_UP, Orientation.WEST, Orientation.FLIP_UP, Orientation.FLIP_WEST }, new Orientation[] { Orientation.UP, Orientation.FLIP_EAST, Orientation.UP, Orientation.EAST, Orientation.FLIP_UP, Orientation.EAST, Orientation.FLIP_UP, Orientation.FLIP_EAST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_EAST, Orientation.DOWN, Orientation.EAST, Orientation.FLIP_DOWN, Orientation.EAST, Orientation.FLIP_DOWN, Orientation.FLIP_EAST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_WEST, Orientation.DOWN, Orientation.WEST, Orientation.FLIP_DOWN, Orientation.WEST, Orientation.FLIP_DOWN, Orientation.FLIP_WEST });
        
        private final /* synthetic */ Orientation[] vert2Weights;
        private final /* synthetic */ Orientation[] vert0Weights;
        
        private EnumNeighborInfo(final String lllllllllllIIIllIIIIIIIIlllllIII, final int lllllllllllIIIllIIIIIIIIllllIlll, final EnumFacing[] lllllllllllIIIllIIIIIIIlIIIIIIII, final float lllllllllllIIIllIIIIIIIIllllllll, final boolean lllllllllllIIIllIIIIIIIIllllIlII, final Orientation[] lllllllllllIIIllIIIIIIIIllllIIll, final Orientation[] lllllllllllIIIllIIIIIIIIllllllII, final Orientation[] lllllllllllIIIllIIIIIIIIlllllIll, final Orientation[] lllllllllllIIIllIIIIIIIIllllIIII) {
            this.corners = lllllllllllIIIllIIIIIIIlIIIIIIII;
            this.shadeWeight = lllllllllllIIIllIIIIIIIIllllllll;
            this.doNonCubicWeight = lllllllllllIIIllIIIIIIIIllllIlII;
            this.vert0Weights = lllllllllllIIIllIIIIIIIIllllIIll;
            this.vert1Weights = lllllllllllIIIllIIIIIIIIllllllII;
            this.vert2Weights = lllllllllllIIIllIIIIIIIIlllllIll;
            this.vert3Weights = lllllllllllIIIllIIIIIIIIllllIIII;
        }
        
        static {
            (VALUES = new EnumNeighborInfo[6])[EnumFacing.DOWN.getIndex()] = EnumNeighborInfo.DOWN;
            EnumNeighborInfo.VALUES[EnumFacing.UP.getIndex()] = EnumNeighborInfo.UP;
            EnumNeighborInfo.VALUES[EnumFacing.NORTH.getIndex()] = EnumNeighborInfo.NORTH;
            EnumNeighborInfo.VALUES[EnumFacing.SOUTH.getIndex()] = EnumNeighborInfo.SOUTH;
            EnumNeighborInfo.VALUES[EnumFacing.WEST.getIndex()] = EnumNeighborInfo.WEST;
            EnumNeighborInfo.VALUES[EnumFacing.EAST.getIndex()] = EnumNeighborInfo.EAST;
        }
        
        public static EnumNeighborInfo getNeighbourInfo(final EnumFacing lllllllllllIIIllIIIIIIIIlllIllIl) {
            return EnumNeighborInfo.VALUES[lllllllllllIIIllIIIIIIIIlllIllIl.getIndex()];
        }
    }
    
    enum VertexTranslations
    {
        NORTH("NORTH", 2, 3, 0, 1, 2);
        
        private final /* synthetic */ int vert2;
        
        SOUTH("SOUTH", 3, 0, 1, 2, 3), 
        EAST("EAST", 5, 1, 2, 3, 0), 
        UP("UP", 1, 2, 3, 0, 1), 
        DOWN("DOWN", 0, 0, 1, 2, 3);
        
        private static final /* synthetic */ VertexTranslations[] VALUES;
        private final /* synthetic */ int vert3;
        private final /* synthetic */ int vert1;
        private final /* synthetic */ int vert0;
        
        WEST("WEST", 4, 3, 0, 1, 2);
        
        private VertexTranslations(final String lllllllllllIlIIlllIIlIlIIIllIlII, final int lllllllllllIlIIlllIIlIlIIIllIIll, final int lllllllllllIlIIlllIIlIlIIIllIIlI, final int lllllllllllIlIIlllIIlIlIIIlllIII, final int lllllllllllIlIIlllIIlIlIIIllIIII, final int lllllllllllIlIIlllIIlIlIIIllIllI) {
            this.vert0 = lllllllllllIlIIlllIIlIlIIIllIIlI;
            this.vert1 = lllllllllllIlIIlllIIlIlIIIlllIII;
            this.vert2 = lllllllllllIlIIlllIIlIlIIIllIIII;
            this.vert3 = lllllllllllIlIIlllIIlIlIIIllIllI;
        }
        
        static {
            (VALUES = new VertexTranslations[6])[EnumFacing.DOWN.getIndex()] = VertexTranslations.DOWN;
            VertexTranslations.VALUES[EnumFacing.UP.getIndex()] = VertexTranslations.UP;
            VertexTranslations.VALUES[EnumFacing.NORTH.getIndex()] = VertexTranslations.NORTH;
            VertexTranslations.VALUES[EnumFacing.SOUTH.getIndex()] = VertexTranslations.SOUTH;
            VertexTranslations.VALUES[EnumFacing.WEST.getIndex()] = VertexTranslations.WEST;
            VertexTranslations.VALUES[EnumFacing.EAST.getIndex()] = VertexTranslations.EAST;
        }
        
        public static VertexTranslations getVertexTranslations(final EnumFacing lllllllllllIlIIlllIIlIlIIIlIllIl) {
            return VertexTranslations.VALUES[lllllllllllIlIIlllIIlIlIIIlIllIl.getIndex()];
        }
    }
    
    public static class AmbientOcclusionFace
    {
        private final /* synthetic */ int[] vertexBrightness;
        private final /* synthetic */ float[] vertexColorMultiplier;
        
        public void updateVertexBrightness(final IBlockAccess lllllllllllIIIIlIIllllIllllIllll, final IBlockState lllllllllllIIIIlIIllllIllllIlllI, final BlockPos lllllllllllIIIIlIIllllIllIlIIIII, final EnumFacing lllllllllllIIIIlIIllllIllllIllII, final float[] lllllllllllIIIIlIIllllIllllIlIll, final BitSet lllllllllllIIIIlIIllllIllllIlIlI) {
            final BlockPos lllllllllllIIIIlIIllllIllllIlIIl = lllllllllllIIIIlIIllllIllllIlIlI.get(0) ? lllllllllllIIIIlIIllllIllIlIIIII.offset(lllllllllllIIIIlIIllllIllllIllII) : lllllllllllIIIIlIIllllIllIlIIIII;
            final BlockPos.PooledMutableBlockPos lllllllllllIIIIlIIllllIllllIlIII = BlockPos.PooledMutableBlockPos.retain();
            final EnumNeighborInfo lllllllllllIIIIlIIllllIllllIIlll = EnumNeighborInfo.getNeighbourInfo(lllllllllllIIIIlIIllllIllllIllII);
            final BlockPos.PooledMutableBlockPos lllllllllllIIIIlIIllllIllllIIllI = BlockPos.PooledMutableBlockPos.retain(lllllllllllIIIIlIIllllIllllIlIIl).move(lllllllllllIIIIlIIllllIllllIIlll.corners[0]);
            final BlockPos.PooledMutableBlockPos lllllllllllIIIIlIIllllIllllIIlIl = BlockPos.PooledMutableBlockPos.retain(lllllllllllIIIIlIIllllIllllIlIIl).move(lllllllllllIIIIlIIllllIllllIIlll.corners[1]);
            final BlockPos.PooledMutableBlockPos lllllllllllIIIIlIIllllIllllIIlII = BlockPos.PooledMutableBlockPos.retain(lllllllllllIIIIlIIllllIllllIlIIl).move(lllllllllllIIIIlIIllllIllllIIlll.corners[2]);
            final BlockPos.PooledMutableBlockPos lllllllllllIIIIlIIllllIllllIIIll = BlockPos.PooledMutableBlockPos.retain(lllllllllllIIIIlIIllllIllllIlIIl).move(lllllllllllIIIIlIIllllIllllIIlll.corners[3]);
            final int lllllllllllIIIIlIIllllIllllIIIlI = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIllllIIllI);
            final int lllllllllllIIIIlIIllllIllllIIIIl = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIllllIIlIl);
            final int lllllllllllIIIIlIIllllIllllIIIII = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIllllIIlII);
            final int lllllllllllIIIIlIIllllIlllIlllll = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIllllIIIll);
            float lllllllllllIIIIlIIllllIlllIllllI = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllllIIllI).getAmbientOcclusionLightValue();
            float lllllllllllIIIIlIIllllIlllIlllIl = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllllIIlIl).getAmbientOcclusionLightValue();
            float lllllllllllIIIIlIIllllIlllIlllII = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllllIIlII).getAmbientOcclusionLightValue();
            float lllllllllllIIIIlIIllllIlllIllIll = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllllIIIll).getAmbientOcclusionLightValue();
            lllllllllllIIIIlIIllllIlllIllllI = BlockModelRenderer.fixAoLightValue(lllllllllllIIIIlIIllllIlllIllllI);
            lllllllllllIIIIlIIllllIlllIlllIl = BlockModelRenderer.fixAoLightValue(lllllllllllIIIIlIIllllIlllIlllIl);
            lllllllllllIIIIlIIllllIlllIlllII = BlockModelRenderer.fixAoLightValue(lllllllllllIIIIlIIllllIlllIlllII);
            lllllllllllIIIIlIIllllIlllIllIll = BlockModelRenderer.fixAoLightValue(lllllllllllIIIIlIIllllIlllIllIll);
            final boolean lllllllllllIIIIlIIllllIlllIllIlI = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllllIlIII.setPos(lllllllllllIIIIlIIllllIllllIIllI).move(lllllllllllIIIIlIIllllIllllIllII)).isTranslucent();
            final boolean lllllllllllIIIIlIIllllIlllIllIIl = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllllIlIII.setPos(lllllllllllIIIIlIIllllIllllIIlIl).move(lllllllllllIIIIlIIllllIllllIllII)).isTranslucent();
            final boolean lllllllllllIIIIlIIllllIlllIllIII = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllllIlIII.setPos(lllllllllllIIIIlIIllllIllllIIlII).move(lllllllllllIIIIlIIllllIllllIllII)).isTranslucent();
            final boolean lllllllllllIIIIlIIllllIlllIlIlll = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllllIlIII.setPos(lllllllllllIIIIlIIllllIllllIIIll).move(lllllllllllIIIIlIIllllIllllIllII)).isTranslucent();
            float lllllllllllIIIIlIIllllIlllIlIIll = 0.0f;
            int lllllllllllIIIIlIIllllIlllIlIlIl = 0;
            if (!lllllllllllIIIIlIIllllIlllIllIII && !lllllllllllIIIIlIIllllIlllIllIlI) {
                final float lllllllllllIIIIlIIllllIlllIlIlII = lllllllllllIIIIlIIllllIlllIllllI;
                final int lllllllllllIIIIlIIllllIlllIlIllI = lllllllllllIIIIlIIllllIllllIIIlI;
            }
            else {
                final BlockPos lllllllllllIIIIlIIllllIlllIlIIlI = lllllllllllIIIIlIIllllIllllIlIII.setPos(lllllllllllIIIIlIIllllIllllIIllI).move(lllllllllllIIIIlIIllllIllllIIlll.corners[2]);
                lllllllllllIIIIlIIllllIlllIlIIll = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIlllIlIIlI).getAmbientOcclusionLightValue();
                lllllllllllIIIIlIIllllIlllIlIIll = BlockModelRenderer.fixAoLightValue(lllllllllllIIIIlIIllllIlllIlIIll);
                lllllllllllIIIIlIIllllIlllIlIlIl = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIlllIlIIlI);
            }
            float lllllllllllIIIIlIIllllIlllIIlllI = 0.0f;
            int lllllllllllIIIIlIIllllIlllIlIIII = 0;
            if (!lllllllllllIIIIlIIllllIlllIlIlll && !lllllllllllIIIIlIIllllIlllIllIlI) {
                final float lllllllllllIIIIlIIllllIlllIIllll = lllllllllllIIIIlIIllllIlllIllllI;
                final int lllllllllllIIIIlIIllllIlllIlIIIl = lllllllllllIIIIlIIllllIllllIIIlI;
            }
            else {
                final BlockPos lllllllllllIIIIlIIllllIlllIIllIl = lllllllllllIIIIlIIllllIllllIlIII.setPos(lllllllllllIIIIlIIllllIllllIIllI).move(lllllllllllIIIIlIIllllIllllIIlll.corners[3]);
                lllllllllllIIIIlIIllllIlllIIlllI = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIlllIIllIl).getAmbientOcclusionLightValue();
                lllllllllllIIIIlIIllllIlllIIlllI = BlockModelRenderer.fixAoLightValue(lllllllllllIIIIlIIllllIlllIIlllI);
                lllllllllllIIIIlIIllllIlllIlIIII = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIlllIIllIl);
            }
            float lllllllllllIIIIlIIllllIlllIIlIIl = 0.0f;
            int lllllllllllIIIIlIIllllIlllIIlIll = 0;
            if (!lllllllllllIIIIlIIllllIlllIllIII && !lllllllllllIIIIlIIllllIlllIllIIl) {
                final float lllllllllllIIIIlIIllllIlllIIlIlI = lllllllllllIIIIlIIllllIlllIlllIl;
                final int lllllllllllIIIIlIIllllIlllIIllII = lllllllllllIIIIlIIllllIllllIIIIl;
            }
            else {
                final BlockPos lllllllllllIIIIlIIllllIlllIIlIII = lllllllllllIIIIlIIllllIllllIlIII.setPos(lllllllllllIIIIlIIllllIllllIIlIl).move(lllllllllllIIIIlIIllllIllllIIlll.corners[2]);
                lllllllllllIIIIlIIllllIlllIIlIIl = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIlllIIlIII).getAmbientOcclusionLightValue();
                lllllllllllIIIIlIIllllIlllIIlIIl = BlockModelRenderer.fixAoLightValue(lllllllllllIIIIlIIllllIlllIIlIIl);
                lllllllllllIIIIlIIllllIlllIIlIll = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIlllIIlIII);
            }
            float lllllllllllIIIIlIIllllIlllIIIlII = 0.0f;
            int lllllllllllIIIIlIIllllIlllIIIllI = 0;
            if (!lllllllllllIIIIlIIllllIlllIlIlll && !lllllllllllIIIIlIIllllIlllIllIIl) {
                final float lllllllllllIIIIlIIllllIlllIIIlIl = lllllllllllIIIIlIIllllIlllIlllIl;
                final int lllllllllllIIIIlIIllllIlllIIIlll = lllllllllllIIIIlIIllllIllllIIIIl;
            }
            else {
                final BlockPos lllllllllllIIIIlIIllllIlllIIIIll = lllllllllllIIIIlIIllllIllllIlIII.setPos(lllllllllllIIIIlIIllllIllllIIlIl).move(lllllllllllIIIIlIIllllIllllIIlll.corners[3]);
                lllllllllllIIIIlIIllllIlllIIIlII = lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIlllIIIIll).getAmbientOcclusionLightValue();
                lllllllllllIIIIlIIllllIlllIIIlII = BlockModelRenderer.fixAoLightValue(lllllllllllIIIIlIIllllIlllIIIlII);
                lllllllllllIIIIlIIllllIlllIIIllI = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIlllIIIIll);
            }
            int lllllllllllIIIIlIIllllIlllIIIIlI = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIllIlIIIII);
            if (lllllllllllIIIIlIIllllIllllIlIlI.get(0) || !lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllIlIIIII.offset(lllllllllllIIIIlIIllllIllllIllII)).isOpaqueCube()) {
                lllllllllllIIIIlIIllllIlllIIIIlI = lllllllllllIIIIlIIllllIllllIlllI.getPackedLightmapCoords(lllllllllllIIIIlIIllllIllllIllll, lllllllllllIIIIlIIllllIllIlIIIII.offset(lllllllllllIIIIlIIllllIllllIllII));
            }
            float lllllllllllIIIIlIIllllIlllIIIIIl = lllllllllllIIIIlIIllllIllllIlIlI.get(0) ? lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllllIlIIl).getAmbientOcclusionLightValue() : lllllllllllIIIIlIIllllIllllIllll.getBlockState(lllllllllllIIIIlIIllllIllIlIIIII).getAmbientOcclusionLightValue();
            lllllllllllIIIIlIIllllIlllIIIIIl = BlockModelRenderer.fixAoLightValue(lllllllllllIIIIlIIllllIlllIIIIIl);
            final VertexTranslations lllllllllllIIIIlIIllllIlllIIIIII = VertexTranslations.getVertexTranslations(lllllllllllIIIIlIIllllIllllIllII);
            lllllllllllIIIIlIIllllIllllIlIII.release();
            lllllllllllIIIIlIIllllIllllIIllI.release();
            lllllllllllIIIIlIIllllIllllIIlIl.release();
            lllllllllllIIIIlIIllllIllllIIlII.release();
            lllllllllllIIIIlIIllllIllllIIIll.release();
            if (lllllllllllIIIIlIIllllIllllIlIlI.get(1) && lllllllllllIIIIlIIllllIllllIIlll.doNonCubicWeight) {
                final float lllllllllllIIIIlIIllllIllIllllll = (lllllllllllIIIIlIIllllIlllIllIll + lllllllllllIIIIlIIllllIlllIllllI + lllllllllllIIIIlIIllllIlllIIlllI + lllllllllllIIIIlIIllllIlllIIIIIl) * 0.25f;
                final float lllllllllllIIIIlIIllllIllIlllllI = (lllllllllllIIIIlIIllllIlllIlllII + lllllllllllIIIIlIIllllIlllIllllI + lllllllllllIIIIlIIllllIlllIlIIll + lllllllllllIIIIlIIllllIlllIIIIIl) * 0.25f;
                final float lllllllllllIIIIlIIllllIllIllllIl = (lllllllllllIIIIlIIllllIlllIlllII + lllllllllllIIIIlIIllllIlllIlllIl + lllllllllllIIIIlIIllllIlllIIlIIl + lllllllllllIIIIlIIllllIlllIIIIIl) * 0.25f;
                final float lllllllllllIIIIlIIllllIllIllllII = (lllllllllllIIIIlIIllllIlllIllIll + lllllllllllIIIIlIIllllIlllIlllIl + lllllllllllIIIIlIIllllIlllIIIlII + lllllllllllIIIIlIIllllIlllIIIIIl) * 0.25f;
                final float lllllllllllIIIIlIIllllIllIlllIll = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert0Weights[0].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert0Weights[1].shape];
                final float lllllllllllIIIIlIIllllIllIlllIlI = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert0Weights[2].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert0Weights[3].shape];
                final float lllllllllllIIIIlIIllllIllIlllIIl = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert0Weights[4].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert0Weights[5].shape];
                final float lllllllllllIIIIlIIllllIllIlllIII = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert0Weights[6].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert0Weights[7].shape];
                final float lllllllllllIIIIlIIllllIllIllIlll = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert1Weights[0].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert1Weights[1].shape];
                final float lllllllllllIIIIlIIllllIllIllIllI = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert1Weights[2].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert1Weights[3].shape];
                final float lllllllllllIIIIlIIllllIllIllIlIl = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert1Weights[4].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert1Weights[5].shape];
                final float lllllllllllIIIIlIIllllIllIllIlII = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert1Weights[6].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert1Weights[7].shape];
                final float lllllllllllIIIIlIIllllIllIllIIll = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert2Weights[0].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert2Weights[1].shape];
                final float lllllllllllIIIIlIIllllIllIllIIlI = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert2Weights[2].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert2Weights[3].shape];
                final float lllllllllllIIIIlIIllllIllIllIIIl = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert2Weights[4].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert2Weights[5].shape];
                final float lllllllllllIIIIlIIllllIllIllIIII = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert2Weights[6].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert2Weights[7].shape];
                final float lllllllllllIIIIlIIllllIllIlIllll = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert3Weights[0].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert3Weights[1].shape];
                final float lllllllllllIIIIlIIllllIllIlIlllI = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert3Weights[2].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert3Weights[3].shape];
                final float lllllllllllIIIIlIIllllIllIlIllIl = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert3Weights[4].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert3Weights[5].shape];
                final float lllllllllllIIIIlIIllllIllIlIllII = lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert3Weights[6].shape] * lllllllllllIIIIlIIllllIllllIlIll[lllllllllllIIIIlIIllllIllllIIlll.vert3Weights[7].shape];
                this.vertexColorMultiplier[lllllllllllIIIIlIIllllIlllIIIIII.vert0] = lllllllllllIIIIlIIllllIllIllllll * lllllllllllIIIIlIIllllIllIlllIll + lllllllllllIIIIlIIllllIllIlllllI * lllllllllllIIIIlIIllllIllIlllIlI + lllllllllllIIIIlIIllllIllIllllIl * lllllllllllIIIIlIIllllIllIlllIIl + lllllllllllIIIIlIIllllIllIllllII * lllllllllllIIIIlIIllllIllIlllIII;
                this.vertexColorMultiplier[lllllllllllIIIIlIIllllIlllIIIIII.vert1] = lllllllllllIIIIlIIllllIllIllllll * lllllllllllIIIIlIIllllIllIllIlll + lllllllllllIIIIlIIllllIllIlllllI * lllllllllllIIIIlIIllllIllIllIllI + lllllllllllIIIIlIIllllIllIllllIl * lllllllllllIIIIlIIllllIllIllIlIl + lllllllllllIIIIlIIllllIllIllllII * lllllllllllIIIIlIIllllIllIllIlII;
                this.vertexColorMultiplier[lllllllllllIIIIlIIllllIlllIIIIII.vert2] = lllllllllllIIIIlIIllllIllIllllll * lllllllllllIIIIlIIllllIllIllIIll + lllllllllllIIIIlIIllllIllIlllllI * lllllllllllIIIIlIIllllIllIllIIlI + lllllllllllIIIIlIIllllIllIllllIl * lllllllllllIIIIlIIllllIllIllIIIl + lllllllllllIIIIlIIllllIllIllllII * lllllllllllIIIIlIIllllIllIllIIII;
                this.vertexColorMultiplier[lllllllllllIIIIlIIllllIlllIIIIII.vert3] = lllllllllllIIIIlIIllllIllIllllll * lllllllllllIIIIlIIllllIllIlIllll + lllllllllllIIIIlIIllllIllIlllllI * lllllllllllIIIIlIIllllIllIlIlllI + lllllllllllIIIIlIIllllIllIllllIl * lllllllllllIIIIlIIllllIllIlIllIl + lllllllllllIIIIlIIllllIllIllllII * lllllllllllIIIIlIIllllIllIlIllII;
                final int lllllllllllIIIIlIIllllIllIlIlIll = this.getAoBrightness(lllllllllllIIIIlIIllllIlllIlllll, lllllllllllIIIIlIIllllIllllIIIlI, lllllllllllIIIIlIIllllIlllIlIIII, lllllllllllIIIIlIIllllIlllIIIIlI);
                final int lllllllllllIIIIlIIllllIllIlIlIlI = this.getAoBrightness(lllllllllllIIIIlIIllllIllllIIIII, lllllllllllIIIIlIIllllIllllIIIlI, lllllllllllIIIIlIIllllIlllIlIlIl, lllllllllllIIIIlIIllllIlllIIIIlI);
                final int lllllllllllIIIIlIIllllIllIlIlIIl = this.getAoBrightness(lllllllllllIIIIlIIllllIllllIIIII, lllllllllllIIIIlIIllllIllllIIIIl, lllllllllllIIIIlIIllllIlllIIlIll, lllllllllllIIIIlIIllllIlllIIIIlI);
                final int lllllllllllIIIIlIIllllIllIlIlIII = this.getAoBrightness(lllllllllllIIIIlIIllllIlllIlllll, lllllllllllIIIIlIIllllIllllIIIIl, lllllllllllIIIIlIIllllIlllIIIllI, lllllllllllIIIIlIIllllIlllIIIIlI);
                this.vertexBrightness[lllllllllllIIIIlIIllllIlllIIIIII.vert0] = this.getVertexBrightness(lllllllllllIIIIlIIllllIllIlIlIll, lllllllllllIIIIlIIllllIllIlIlIlI, lllllllllllIIIIlIIllllIllIlIlIIl, lllllllllllIIIIlIIllllIllIlIlIII, lllllllllllIIIIlIIllllIllIlllIll, lllllllllllIIIIlIIllllIllIlllIlI, lllllllllllIIIIlIIllllIllIlllIIl, lllllllllllIIIIlIIllllIllIlllIII);
                this.vertexBrightness[lllllllllllIIIIlIIllllIlllIIIIII.vert1] = this.getVertexBrightness(lllllllllllIIIIlIIllllIllIlIlIll, lllllllllllIIIIlIIllllIllIlIlIlI, lllllllllllIIIIlIIllllIllIlIlIIl, lllllllllllIIIIlIIllllIllIlIlIII, lllllllllllIIIIlIIllllIllIllIlll, lllllllllllIIIIlIIllllIllIllIllI, lllllllllllIIIIlIIllllIllIllIlIl, lllllllllllIIIIlIIllllIllIllIlII);
                this.vertexBrightness[lllllllllllIIIIlIIllllIlllIIIIII.vert2] = this.getVertexBrightness(lllllllllllIIIIlIIllllIllIlIlIll, lllllllllllIIIIlIIllllIllIlIlIlI, lllllllllllIIIIlIIllllIllIlIlIIl, lllllllllllIIIIlIIllllIllIlIlIII, lllllllllllIIIIlIIllllIllIllIIll, lllllllllllIIIIlIIllllIllIllIIlI, lllllllllllIIIIlIIllllIllIllIIIl, lllllllllllIIIIlIIllllIllIllIIII);
                this.vertexBrightness[lllllllllllIIIIlIIllllIlllIIIIII.vert3] = this.getVertexBrightness(lllllllllllIIIIlIIllllIllIlIlIll, lllllllllllIIIIlIIllllIllIlIlIlI, lllllllllllIIIIlIIllllIllIlIlIIl, lllllllllllIIIIlIIllllIllIlIlIII, lllllllllllIIIIlIIllllIllIlIllll, lllllllllllIIIIlIIllllIllIlIlllI, lllllllllllIIIIlIIllllIllIlIllIl, lllllllllllIIIIlIIllllIllIlIllII);
            }
            else {
                final float lllllllllllIIIIlIIllllIllIlIIlll = (lllllllllllIIIIlIIllllIlllIllIll + lllllllllllIIIIlIIllllIlllIllllI + lllllllllllIIIIlIIllllIlllIIlllI + lllllllllllIIIIlIIllllIlllIIIIIl) * 0.25f;
                final float lllllllllllIIIIlIIllllIllIlIIllI = (lllllllllllIIIIlIIllllIlllIlllII + lllllllllllIIIIlIIllllIlllIllllI + lllllllllllIIIIlIIllllIlllIlIIll + lllllllllllIIIIlIIllllIlllIIIIIl) * 0.25f;
                final float lllllllllllIIIIlIIllllIllIlIIlIl = (lllllllllllIIIIlIIllllIlllIlllII + lllllllllllIIIIlIIllllIlllIlllIl + lllllllllllIIIIlIIllllIlllIIlIIl + lllllllllllIIIIlIIllllIlllIIIIIl) * 0.25f;
                final float lllllllllllIIIIlIIllllIllIlIIlII = (lllllllllllIIIIlIIllllIlllIllIll + lllllllllllIIIIlIIllllIlllIlllIl + lllllllllllIIIIlIIllllIlllIIIlII + lllllllllllIIIIlIIllllIlllIIIIIl) * 0.25f;
                this.vertexBrightness[lllllllllllIIIIlIIllllIlllIIIIII.vert0] = this.getAoBrightness(lllllllllllIIIIlIIllllIlllIlllll, lllllllllllIIIIlIIllllIllllIIIlI, lllllllllllIIIIlIIllllIlllIlIIII, lllllllllllIIIIlIIllllIlllIIIIlI);
                this.vertexBrightness[lllllllllllIIIIlIIllllIlllIIIIII.vert1] = this.getAoBrightness(lllllllllllIIIIlIIllllIllllIIIII, lllllllllllIIIIlIIllllIllllIIIlI, lllllllllllIIIIlIIllllIlllIlIlIl, lllllllllllIIIIlIIllllIlllIIIIlI);
                this.vertexBrightness[lllllllllllIIIIlIIllllIlllIIIIII.vert2] = this.getAoBrightness(lllllllllllIIIIlIIllllIllllIIIII, lllllllllllIIIIlIIllllIllllIIIIl, lllllllllllIIIIlIIllllIlllIIlIll, lllllllllllIIIIlIIllllIlllIIIIlI);
                this.vertexBrightness[lllllllllllIIIIlIIllllIlllIIIIII.vert3] = this.getAoBrightness(lllllllllllIIIIlIIllllIlllIlllll, lllllllllllIIIIlIIllllIllllIIIIl, lllllllllllIIIIlIIllllIlllIIIllI, lllllllllllIIIIlIIllllIlllIIIIlI);
                this.vertexColorMultiplier[lllllllllllIIIIlIIllllIlllIIIIII.vert0] = lllllllllllIIIIlIIllllIllIlIIlll;
                this.vertexColorMultiplier[lllllllllllIIIIlIIllllIlllIIIIII.vert1] = lllllllllllIIIIlIIllllIllIlIIllI;
                this.vertexColorMultiplier[lllllllllllIIIIlIIllllIlllIIIIII.vert2] = lllllllllllIIIIlIIllllIllIlIIlIl;
                this.vertexColorMultiplier[lllllllllllIIIIlIIllllIlllIIIIII.vert3] = lllllllllllIIIIlIIllllIllIlIIlII;
            }
        }
        
        private int getVertexBrightness(final int lllllllllllIIIIlIIllllIlIlIIlllI, final int lllllllllllIIIIlIIllllIlIlIIllIl, final int lllllllllllIIIIlIIllllIlIlIIllII, final int lllllllllllIIIIlIIllllIlIlIIIIIl, final float lllllllllllIIIIlIIllllIlIlIIIIII, final float lllllllllllIIIIlIIllllIlIlIIlIIl, final float lllllllllllIIIIlIIllllIlIIlllllI, final float lllllllllllIIIIlIIllllIlIIllllIl) {
            final int lllllllllllIIIIlIIllllIlIlIIIllI = (int)((lllllllllllIIIIlIIllllIlIlIIlllI >> 16 & 0xFF) * lllllllllllIIIIlIIllllIlIlIIIIII + (lllllllllllIIIIlIIllllIlIlIIllIl >> 16 & 0xFF) * lllllllllllIIIIlIIllllIlIlIIlIIl + (lllllllllllIIIIlIIllllIlIlIIllII >> 16 & 0xFF) * lllllllllllIIIIlIIllllIlIIlllllI + (lllllllllllIIIIlIIllllIlIlIIIIIl >> 16 & 0xFF) * lllllllllllIIIIlIIllllIlIIllllIl) & 0xFF;
            final int lllllllllllIIIIlIIllllIlIlIIIlIl = (int)((lllllllllllIIIIlIIllllIlIlIIlllI & 0xFF) * lllllllllllIIIIlIIllllIlIlIIIIII + (lllllllllllIIIIlIIllllIlIlIIllIl & 0xFF) * lllllllllllIIIIlIIllllIlIlIIlIIl + (lllllllllllIIIIlIIllllIlIlIIllII & 0xFF) * lllllllllllIIIIlIIllllIlIIlllllI + (lllllllllllIIIIlIIllllIlIlIIIIIl & 0xFF) * lllllllllllIIIIlIIllllIlIIllllIl) & 0xFF;
            return lllllllllllIIIIlIIllllIlIlIIIllI << 16 | lllllllllllIIIIlIIllllIlIlIIIlIl;
        }
        
        public AmbientOcclusionFace(final BlockModelRenderer lllllllllllIIIIlIIlllllIIIlIllll) {
            this.vertexColorMultiplier = new float[4];
            this.vertexBrightness = new int[4];
        }
        
        public AmbientOcclusionFace() {
            this.vertexColorMultiplier = new float[4];
            this.vertexBrightness = new int[4];
        }
        
        private int getAoBrightness(int lllllllllllIIIIlIIllllIlIlIlllIl, int lllllllllllIIIIlIIllllIlIlIlllII, int lllllllllllIIIIlIIllllIlIlIllIll, final int lllllllllllIIIIlIIllllIlIlIllllI) {
            if (lllllllllllIIIIlIIllllIlIlIlllIl == 0) {
                lllllllllllIIIIlIIllllIlIlIlllIl = lllllllllllIIIIlIIllllIlIlIllllI;
            }
            if (lllllllllllIIIIlIIllllIlIlIlllII == 0) {
                lllllllllllIIIIlIIllllIlIlIlllII = lllllllllllIIIIlIIllllIlIlIllllI;
            }
            if (lllllllllllIIIIlIIllllIlIlIllIll == 0) {
                lllllllllllIIIIlIIllllIlIlIllIll = lllllllllllIIIIlIIllllIlIlIllllI;
            }
            return (int)(lllllllllllIIIIlIIllllIlIlIlllIl + lllllllllllIIIIlIIllllIlIlIlllII + lllllllllllIIIIlIIllllIlIlIllIll + lllllllllllIIIIlIIllllIlIlIllllI >> 2 & 0xFF00FF);
        }
    }
}
