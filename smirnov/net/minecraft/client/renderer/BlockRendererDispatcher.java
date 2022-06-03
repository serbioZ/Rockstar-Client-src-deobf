// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.block.state.IBlockProperties;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.CrashReport;
import net.minecraft.world.WorldType;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.SimpleBakedModel;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class BlockRendererDispatcher implements IResourceManagerReloadListener
{
    private final /* synthetic */ BlockModelRenderer blockModelRenderer;
    private final /* synthetic */ BlockModelShapes blockModelShapes;
    private final /* synthetic */ BlockFluidRenderer fluidRenderer;
    private final /* synthetic */ ChestRenderer chestRenderer;
    
    public BlockModelShapes getBlockModelShapes() {
        return this.blockModelShapes;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType() {
        final int[] $switch_TABLE$net$minecraft$util$EnumBlockRenderType = BlockRendererDispatcher.$SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType;
        if ($switch_TABLE$net$minecraft$util$EnumBlockRenderType != null) {
            return $switch_TABLE$net$minecraft$util$EnumBlockRenderType;
        }
        final boolean llIIIlIIIIlIlll = (Object)new int[EnumBlockRenderType.values().length];
        try {
            llIIIlIIIIlIlll[EnumBlockRenderType.ENTITYBLOCK_ANIMATED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llIIIlIIIIlIlll[EnumBlockRenderType.INVISIBLE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llIIIlIIIIlIlll[EnumBlockRenderType.LIQUID.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llIIIlIIIIlIlll[EnumBlockRenderType.MODEL.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRendererDispatcher.$SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType = (int[])(Object)llIIIlIIIIlIlll;
    }
    
    public BlockModelRenderer getBlockModelRenderer() {
        return this.blockModelRenderer;
    }
    
    public BlockRendererDispatcher(final BlockModelShapes llIIIlIIllIIlll, final BlockColors llIIIlIIllIIllI) {
        this.chestRenderer = new ChestRenderer();
        this.blockModelShapes = llIIIlIIllIIlll;
        this.blockModelRenderer = new BlockModelRenderer(llIIIlIIllIIllI);
        this.fluidRenderer = new BlockFluidRenderer(llIIIlIIllIIllI);
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llIIIlIIIIllIlI) {
        this.fluidRenderer.initAtlasSprites();
    }
    
    public void renderBlockDamage(IBlockState llIIIlIIlIlIIll, final BlockPos llIIIlIIlIllIIl, final TextureAtlasSprite llIIIlIIlIllIII, final IBlockAccess llIIIlIIlIlIlll) {
        if (llIIIlIIlIlIIll.getRenderType() == EnumBlockRenderType.MODEL) {
            llIIIlIIlIlIIll = llIIIlIIlIlIIll.getActualState(llIIIlIIlIlIlll, llIIIlIIlIllIIl);
            final IBakedModel llIIIlIIlIlIllI = this.blockModelShapes.getModelForState(llIIIlIIlIlIIll);
            final IBakedModel llIIIlIIlIlIlIl = new SimpleBakedModel.Builder(llIIIlIIlIlIIll, llIIIlIIlIlIllI, llIIIlIIlIllIII, llIIIlIIlIllIIl).makeBakedModel();
            this.blockModelRenderer.renderModel(llIIIlIIlIlIlll, llIIIlIIlIlIlIl, llIIIlIIlIlIIll, llIIIlIIlIllIIl, Tessellator.getInstance().getBuffer(), true);
        }
    }
    
    public void renderBlockBrightness(final IBlockState llIIIlIIIlIIlIl, final float llIIIlIIIlIIlII) {
        final EnumBlockRenderType llIIIlIIIlIIIll = llIIIlIIIlIIlIl.getRenderType();
        if (llIIIlIIIlIIIll != EnumBlockRenderType.INVISIBLE) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType()[llIIIlIIIlIIIll.ordinal()]) {
                case 4: {
                    final IBakedModel llIIIlIIIlIIIlI = this.getModelForState(llIIIlIIIlIIlIl);
                    this.blockModelRenderer.renderModelBrightness(llIIIlIIIlIIIlI, llIIIlIIIlIIlIl, llIIIlIIIlIIlII, true);
                    break;
                }
                case 3: {
                    this.chestRenderer.renderChestBrightness(llIIIlIIIlIIlIl.getBlock(), llIIIlIIIlIIlII);
                    break;
                }
            }
        }
    }
    
    public IBakedModel getModelForState(final IBlockState llIIIlIIIlIllII) {
        return this.blockModelShapes.getModelForState(llIIIlIIIlIllII);
    }
    
    public boolean renderBlock(IBlockState llIIIlIIIlllIll, final BlockPos llIIIlIIlIIIIll, final IBlockAccess llIIIlIIlIIIIlI, final BufferBuilder llIIIlIIIlllIII) {
        try {
            final EnumBlockRenderType llIIIlIIlIIIIII = ((IBlockProperties)llIIIlIIIlllIll).getRenderType();
            if (llIIIlIIlIIIIII == EnumBlockRenderType.INVISIBLE) {
                return false;
            }
            if (llIIIlIIlIIIIlI.getWorldType() != WorldType.DEBUG_WORLD) {
                try {
                    llIIIlIIIlllIll = ((IBlockProperties)llIIIlIIIlllIll).getActualState(llIIIlIIlIIIIlI, llIIIlIIlIIIIll);
                }
                catch (Exception ex) {}
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType()[llIIIlIIlIIIIII.ordinal()]) {
                case 4: {
                    return this.blockModelRenderer.renderModel(llIIIlIIlIIIIlI, this.getModelForState((IBlockState)llIIIlIIIlllIll), (IBlockState)llIIIlIIIlllIll, llIIIlIIlIIIIll, llIIIlIIIlllIII, true);
                }
                case 3: {
                    return false;
                }
                case 2: {
                    return this.fluidRenderer.renderFluid(llIIIlIIlIIIIlI, (IBlockState)llIIIlIIIlllIll, llIIIlIIlIIIIll, llIIIlIIIlllIII);
                }
                default: {
                    return false;
                }
            }
        }
        catch (Throwable llIIIlIIIllllll) {
            final CrashReport llIIIlIIIlllllI = CrashReport.makeCrashReport(llIIIlIIIllllll, "Tesselating block in world");
            final CrashReportCategory llIIIlIIIllllIl = llIIIlIIIlllllI.makeCategory("Block being tesselated");
            CrashReportCategory.addBlockInfo(llIIIlIIIllllIl, llIIIlIIlIIIIll, ((IBlockState)llIIIlIIIlllIll).getBlock(), ((IBlockState)llIIIlIIIlllIll).getBlock().getMetaFromState((IBlockState)llIIIlIIIlllIll));
            throw new ReportedException(llIIIlIIIlllllI);
        }
    }
}
