// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;

public class RenderFallingBlock extends Render<EntityFallingBlock>
{
    @Override
    protected ResourceLocation getEntityTexture(final EntityFallingBlock lllllllllllIIlIIIIlIlllllIIIlIII) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
    
    public RenderFallingBlock(final RenderManager lllllllllllIIlIIIIlIlllllIllIIIl) {
        super(lllllllllllIIlIIIIlIlllllIllIIIl);
        this.shadowSize = 0.5f;
    }
    
    @Override
    public void doRender(final EntityFallingBlock lllllllllllIIlIIIIlIlllllIlIIIlI, final double lllllllllllIIlIIIIlIlllllIlIIIIl, final double lllllllllllIIlIIIIlIlllllIIlIIll, final double lllllllllllIIlIIIIlIlllllIIlllll, final float lllllllllllIIlIIIIlIlllllIIllllI, final float lllllllllllIIlIIIIlIlllllIIlIIII) {
        if (lllllllllllIIlIIIIlIlllllIlIIIlI.getBlock() != null) {
            final IBlockState lllllllllllIIlIIIIlIlllllIIlllII = lllllllllllIIlIIIIlIlllllIlIIIlI.getBlock();
            if (lllllllllllIIlIIIIlIlllllIIlllII.getRenderType() == EnumBlockRenderType.MODEL) {
                final World lllllllllllIIlIIIIlIlllllIIllIll = lllllllllllIIlIIIIlIlllllIlIIIlI.getWorldObj();
                if (lllllllllllIIlIIIIlIlllllIIlllII != lllllllllllIIlIIIIlIlllllIIllIll.getBlockState(new BlockPos(lllllllllllIIlIIIIlIlllllIlIIIlI)) && lllllllllllIIlIIIIlIlllllIIlllII.getRenderType() != EnumBlockRenderType.INVISIBLE) {
                    this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                    GlStateManager.pushMatrix();
                    GlStateManager.disableLighting();
                    final Tessellator lllllllllllIIlIIIIlIlllllIIllIlI = Tessellator.getInstance();
                    final BufferBuilder lllllllllllIIlIIIIlIlllllIIllIIl = lllllllllllIIlIIIIlIlllllIIllIlI.getBuffer();
                    if (this.renderOutlines) {
                        GlStateManager.enableColorMaterial();
                        GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllIIlIIIIlIlllllIlIIIlI));
                    }
                    lllllllllllIIlIIIIlIlllllIIllIIl.begin(7, DefaultVertexFormats.BLOCK);
                    final BlockPos lllllllllllIIlIIIIlIlllllIIllIII = new BlockPos(lllllllllllIIlIIIIlIlllllIlIIIlI.posX, lllllllllllIIlIIIIlIlllllIlIIIlI.getEntityBoundingBox().maxY, lllllllllllIIlIIIIlIlllllIlIIIlI.posZ);
                    GlStateManager.translate((float)(lllllllllllIIlIIIIlIlllllIlIIIIl - lllllllllllIIlIIIIlIlllllIIllIII.getX() - 0.5), (float)(lllllllllllIIlIIIIlIlllllIIlIIll - lllllllllllIIlIIIIlIlllllIIllIII.getY()), (float)(lllllllllllIIlIIIIlIlllllIIlllll - lllllllllllIIlIIIIlIlllllIIllIII.getZ() - 0.5));
                    final BlockRendererDispatcher lllllllllllIIlIIIIlIlllllIIlIlll = Minecraft.getMinecraft().getBlockRendererDispatcher();
                    lllllllllllIIlIIIIlIlllllIIlIlll.getBlockModelRenderer().renderModel(lllllllllllIIlIIIIlIlllllIIllIll, lllllllllllIIlIIIIlIlllllIIlIlll.getModelForState(lllllllllllIIlIIIIlIlllllIIlllII), lllllllllllIIlIIIIlIlllllIIlllII, lllllllllllIIlIIIIlIlllllIIllIII, lllllllllllIIlIIIIlIlllllIIllIIl, false, MathHelper.getPositionRandom(lllllllllllIIlIIIIlIlllllIlIIIlI.getOrigin()));
                    lllllllllllIIlIIIIlIlllllIIllIlI.draw();
                    if (this.renderOutlines) {
                        GlStateManager.disableOutlineMode();
                        GlStateManager.disableColorMaterial();
                    }
                    GlStateManager.enableLighting();
                    GlStateManager.popMatrix();
                    super.doRender(lllllllllllIIlIIIIlIlllllIlIIIlI, lllllllllllIIlIIIIlIlllllIlIIIIl, lllllllllllIIlIIIIlIlllllIIlIIll, lllllllllllIIlIIIIlIlllllIIlllll, lllllllllllIIlIIIIlIlllllIIllllI, lllllllllllIIlIIIIlIlllllIIlIIII);
                }
            }
        }
    }
}
