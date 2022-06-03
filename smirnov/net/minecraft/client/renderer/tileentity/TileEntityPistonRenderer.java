// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.tileentity.TileEntityPiston;

public class TileEntityPistonRenderer extends TileEntitySpecialRenderer<TileEntityPiston>
{
    private final /* synthetic */ BlockRendererDispatcher blockRenderer;
    
    public TileEntityPistonRenderer() {
        this.blockRenderer = Minecraft.getMinecraft().getBlockRendererDispatcher();
    }
    
    private boolean renderStateModel(final BlockPos lllllllllllIlIlIlllIlIIIIIIIIIlI, final IBlockState lllllllllllIlIlIlllIIllllllllIll, final BufferBuilder lllllllllllIlIlIlllIlIIIIIIIIIII, final World lllllllllllIlIlIlllIIllllllllIIl, final boolean lllllllllllIlIlIlllIIllllllllIII) {
        return this.blockRenderer.getBlockModelRenderer().renderModel(lllllllllllIlIlIlllIIllllllllIIl, this.blockRenderer.getModelForState(lllllllllllIlIlIlllIIllllllllIll), lllllllllllIlIlIlllIIllllllllIll, lllllllllllIlIlIlllIlIIIIIIIIIlI, lllllllllllIlIlIlllIlIIIIIIIIIII, lllllllllllIlIlIlllIIllllllllIII);
    }
    
    @Override
    public void func_192841_a(final TileEntityPiston lllllllllllIlIlIlllIlIIIIIIlIllI, final double lllllllllllIlIlIlllIlIIIIIlIIlIl, final double lllllllllllIlIlIlllIlIIIIIIlIlII, final double lllllllllllIlIlIlllIlIIIIIlIIIll, final float lllllllllllIlIlIlllIlIIIIIIlIIlI, final int lllllllllllIlIlIlllIlIIIIIlIIIIl, final float lllllllllllIlIlIlllIlIIIIIlIIIII) {
        final BlockPos lllllllllllIlIlIlllIlIIIIIIlllll = lllllllllllIlIlIlllIlIIIIIIlIllI.getPos();
        IBlockState lllllllllllIlIlIlllIlIIIIIIllllI = lllllllllllIlIlIlllIlIIIIIIlIllI.getPistonState();
        final Block lllllllllllIlIlIlllIlIIIIIIlllIl = lllllllllllIlIlIlllIlIIIIIIllllI.getBlock();
        if (lllllllllllIlIlIlllIlIIIIIIllllI.getMaterial() != Material.AIR && lllllllllllIlIlIlllIlIIIIIIlIllI.getProgress(lllllllllllIlIlIlllIlIIIIIIlIIlI) < 1.0f) {
            final Tessellator lllllllllllIlIlIlllIlIIIIIIlllII = Tessellator.getInstance();
            final BufferBuilder lllllllllllIlIlIlllIlIIIIIIllIll = lllllllllllIlIlIlllIlIIIIIIlllII.getBuffer();
            this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.enableBlend();
            GlStateManager.disableCull();
            if (Minecraft.isAmbientOcclusionEnabled()) {
                GlStateManager.shadeModel(7425);
            }
            else {
                GlStateManager.shadeModel(7424);
            }
            lllllllllllIlIlIlllIlIIIIIIllIll.begin(7, DefaultVertexFormats.BLOCK);
            lllllllllllIlIlIlllIlIIIIIIllIll.setTranslation(lllllllllllIlIlIlllIlIIIIIlIIlIl - lllllllllllIlIlIlllIlIIIIIIlllll.getX() + lllllllllllIlIlIlllIlIIIIIIlIllI.getOffsetX(lllllllllllIlIlIlllIlIIIIIIlIIlI), lllllllllllIlIlIlllIlIIIIIIlIlII - lllllllllllIlIlIlllIlIIIIIIlllll.getY() + lllllllllllIlIlIlllIlIIIIIIlIllI.getOffsetY(lllllllllllIlIlIlllIlIIIIIIlIIlI), lllllllllllIlIlIlllIlIIIIIlIIIll - lllllllllllIlIlIlllIlIIIIIIlllll.getZ() + lllllllllllIlIlIlllIlIIIIIIlIllI.getOffsetZ(lllllllllllIlIlIlllIlIIIIIIlIIlI));
            final World lllllllllllIlIlIlllIlIIIIIIllIlI = this.getWorld();
            if (lllllllllllIlIlIlllIlIIIIIIlllIl == Blocks.PISTON_HEAD && lllllllllllIlIlIlllIlIIIIIIlIllI.getProgress(lllllllllllIlIlIlllIlIIIIIIlIIlI) <= 0.25f) {
                lllllllllllIlIlIlllIlIIIIIIllllI = lllllllllllIlIlIlllIlIIIIIIllllI.withProperty((IProperty<Comparable>)BlockPistonExtension.SHORT, true);
                this.renderStateModel(lllllllllllIlIlIlllIlIIIIIIlllll, lllllllllllIlIlIlllIlIIIIIIllllI, lllllllllllIlIlIlllIlIIIIIIllIll, lllllllllllIlIlIlllIlIIIIIIllIlI, true);
            }
            else if (lllllllllllIlIlIlllIlIIIIIIlIllI.shouldPistonHeadBeRendered() && !lllllllllllIlIlIlllIlIIIIIIlIllI.isExtending()) {
                final BlockPistonExtension.EnumPistonType lllllllllllIlIlIlllIlIIIIIIllIIl = (lllllllllllIlIlIlllIlIIIIIIlllIl == Blocks.STICKY_PISTON) ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT;
                IBlockState lllllllllllIlIlIlllIlIIIIIIllIII = Blocks.PISTON_HEAD.getDefaultState().withProperty(BlockPistonExtension.TYPE, lllllllllllIlIlIlllIlIIIIIIllIIl).withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, (EnumFacing)lllllllllllIlIlIlllIlIIIIIIllllI.getValue((IProperty<V>)BlockPistonBase.FACING));
                lllllllllllIlIlIlllIlIIIIIIllIII = lllllllllllIlIlIlllIlIIIIIIllIII.withProperty((IProperty<Comparable>)BlockPistonExtension.SHORT, lllllllllllIlIlIlllIlIIIIIIlIllI.getProgress(lllllllllllIlIlIlllIlIIIIIIlIIlI) >= 0.5f);
                this.renderStateModel(lllllllllllIlIlIlllIlIIIIIIlllll, lllllllllllIlIlIlllIlIIIIIIllIII, lllllllllllIlIlIlllIlIIIIIIllIll, lllllllllllIlIlIlllIlIIIIIIllIlI, true);
                lllllllllllIlIlIlllIlIIIIIIllIll.setTranslation(lllllllllllIlIlIlllIlIIIIIlIIlIl - lllllllllllIlIlIlllIlIIIIIIlllll.getX(), lllllllllllIlIlIlllIlIIIIIIlIlII - lllllllllllIlIlIlllIlIIIIIIlllll.getY(), lllllllllllIlIlIlllIlIIIIIlIIIll - lllllllllllIlIlIlllIlIIIIIIlllll.getZ());
                lllllllllllIlIlIlllIlIIIIIIllllI = lllllllllllIlIlIlllIlIIIIIIllllI.withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, true);
                this.renderStateModel(lllllllllllIlIlIlllIlIIIIIIlllll, lllllllllllIlIlIlllIlIIIIIIllllI, lllllllllllIlIlIlllIlIIIIIIllIll, lllllllllllIlIlIlllIlIIIIIIllIlI, true);
            }
            else {
                this.renderStateModel(lllllllllllIlIlIlllIlIIIIIIlllll, lllllllllllIlIlIlllIlIIIIIIllllI, lllllllllllIlIlIlllIlIIIIIIllIll, lllllllllllIlIlIlllIlIIIIIIllIlI, false);
            }
            lllllllllllIlIlIlllIlIIIIIIllIll.setTranslation(0.0, 0.0, 0.0);
            lllllllllllIlIlIlllIlIIIIIIlllII.draw();
            RenderHelper.enableStandardItemLighting();
        }
    }
}
