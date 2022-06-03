// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.debug;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;

public class DebugRendererSolidFace implements DebugRenderer.IDebugRenderer
{
    private final /* synthetic */ Minecraft field_193851_a;
    
    @Override
    public void render(final float lllllllllllIlIIllIlIlllIllIlIlII, final long lllllllllllIlIIllIlIlllIllllIllI) {
        final EntityPlayer lllllllllllIlIIllIlIlllIllllIlIl = this.field_193851_a.player;
        final double lllllllllllIlIIllIlIlllIllllIlII = lllllllllllIlIIllIlIlllIllllIlIl.lastTickPosX + (lllllllllllIlIIllIlIlllIllllIlIl.posX - lllllllllllIlIIllIlIlllIllllIlIl.lastTickPosX) * lllllllllllIlIIllIlIlllIllIlIlII;
        final double lllllllllllIlIIllIlIlllIllllIIll = lllllllllllIlIIllIlIlllIllllIlIl.lastTickPosY + (lllllllllllIlIIllIlIlllIllllIlIl.posY - lllllllllllIlIIllIlIlllIllllIlIl.lastTickPosY) * lllllllllllIlIIllIlIlllIllIlIlII;
        final double lllllllllllIlIIllIlIlllIllllIIlI = lllllllllllIlIIllIlIlllIllllIlIl.lastTickPosZ + (lllllllllllIlIIllIlIlllIllllIlIl.posZ - lllllllllllIlIIllIlIlllIllllIlIl.lastTickPosZ) * lllllllllllIlIIllIlIlllIllIlIlII;
        final World lllllllllllIlIIllIlIlllIllllIIIl = this.field_193851_a.player.world;
        final Iterable<BlockPos> lllllllllllIlIIllIlIlllIllllIIII = BlockPos.func_191532_a(MathHelper.floor(lllllllllllIlIIllIlIlllIllllIlIl.posX - 6.0), MathHelper.floor(lllllllllllIlIIllIlIlllIllllIlIl.posY - 6.0), MathHelper.floor(lllllllllllIlIIllIlIlllIllllIlIl.posZ - 6.0), MathHelper.floor(lllllllllllIlIIllIlIlllIllllIlIl.posX + 6.0), MathHelper.floor(lllllllllllIlIIllIlIlllIllllIlIl.posY + 6.0), MathHelper.floor(lllllllllllIlIIllIlIlllIllllIlIl.posZ + 6.0));
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth(2.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        for (final BlockPos lllllllllllIlIIllIlIlllIlllIllll : lllllllllllIlIIllIlIlllIllllIIII) {
            final IBlockState lllllllllllIlIIllIlIlllIlllIlllI = lllllllllllIlIIllIlIlllIllllIIIl.getBlockState(lllllllllllIlIIllIlIlllIlllIllll);
            if (lllllllllllIlIIllIlIlllIlllIlllI.getBlock() != Blocks.AIR) {
                final AxisAlignedBB lllllllllllIlIIllIlIlllIlllIllIl = lllllllllllIlIIllIlIlllIlllIlllI.getSelectedBoundingBox(lllllllllllIlIIllIlIlllIllllIIIl, lllllllllllIlIIllIlIlllIlllIllll).expandXyz(0.002).offset(-lllllllllllIlIIllIlIlllIllllIlII, -lllllllllllIlIIllIlIlllIllllIIll, -lllllllllllIlIIllIlIlllIllllIIlI);
                final double lllllllllllIlIIllIlIlllIlllIllII = lllllllllllIlIIllIlIlllIlllIllIl.minX;
                final double lllllllllllIlIIllIlIlllIlllIlIll = lllllllllllIlIIllIlIlllIlllIllIl.minY;
                final double lllllllllllIlIIllIlIlllIlllIlIlI = lllllllllllIlIIllIlIlllIlllIllIl.minZ;
                final double lllllllllllIlIIllIlIlllIlllIlIIl = lllllllllllIlIIllIlIlllIlllIllIl.maxX;
                final double lllllllllllIlIIllIlIlllIlllIlIII = lllllllllllIlIIllIlIlllIlllIllIl.maxY;
                final double lllllllllllIlIIllIlIlllIlllIIlll = lllllllllllIlIIllIlIlllIlllIllIl.maxZ;
                final float lllllllllllIlIIllIlIlllIlllIIllI = 1.0f;
                final float lllllllllllIlIIllIlIlllIlllIIlIl = 0.0f;
                final float lllllllllllIlIIllIlIlllIlllIIlII = 0.0f;
                final float lllllllllllIlIIllIlIlllIlllIIIll = 0.5f;
                if (lllllllllllIlIIllIlIlllIlllIlllI.func_193401_d(lllllllllllIlIIllIlIlllIllllIIIl, lllllllllllIlIIllIlIlllIlllIllll, EnumFacing.WEST) == BlockFaceShape.SOLID) {
                    final Tessellator lllllllllllIlIIllIlIlllIlllIIIlI = Tessellator.getInstance();
                    final BufferBuilder lllllllllllIlIIllIlIlllIlllIIIIl = lllllllllllIlIIllIlIlllIlllIIIlI.getBuffer();
                    lllllllllllIlIIllIlIlllIlllIIIIl.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    lllllllllllIlIIllIlIlllIlllIIIIl.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIlllIIIIl.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIlllIIIIl.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIlllIIIIl.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIlllIIIlI.draw();
                }
                if (lllllllllllIlIIllIlIlllIlllIlllI.func_193401_d(lllllllllllIlIIllIlIlllIllllIIIl, lllllllllllIlIIllIlIlllIlllIllll, EnumFacing.SOUTH) == BlockFaceShape.SOLID) {
                    final Tessellator lllllllllllIlIIllIlIlllIlllIIIII = Tessellator.getInstance();
                    final BufferBuilder lllllllllllIlIIllIlIlllIllIlllll = lllllllllllIlIIllIlIlllIlllIIIII.getBuffer();
                    lllllllllllIlIIllIlIlllIllIlllll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    lllllllllllIlIIllIlIlllIllIlllll.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIlllll.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIlllll.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIlllll.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIlllIIIII.draw();
                }
                if (lllllllllllIlIIllIlIlllIlllIlllI.func_193401_d(lllllllllllIlIIllIlIlllIllllIIIl, lllllllllllIlIIllIlIlllIlllIllll, EnumFacing.EAST) == BlockFaceShape.SOLID) {
                    final Tessellator lllllllllllIlIIllIlIlllIllIllllI = Tessellator.getInstance();
                    final BufferBuilder lllllllllllIlIIllIlIlllIllIlllIl = lllllllllllIlIIllIlIlllIllIllllI.getBuffer();
                    lllllllllllIlIIllIlIlllIllIlllIl.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    lllllllllllIlIIllIlIlllIllIlllIl.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIlllIl.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIlllIl.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIlllIl.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIllllI.draw();
                }
                if (lllllllllllIlIIllIlIlllIlllIlllI.func_193401_d(lllllllllllIlIIllIlIlllIllllIIIl, lllllllllllIlIIllIlIlllIlllIllll, EnumFacing.NORTH) == BlockFaceShape.SOLID) {
                    final Tessellator lllllllllllIlIIllIlIlllIllIlllII = Tessellator.getInstance();
                    final BufferBuilder lllllllllllIlIIllIlIlllIllIllIll = lllllllllllIlIIllIlIlllIllIlllII.getBuffer();
                    lllllllllllIlIIllIlIlllIllIllIll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    lllllllllllIlIIllIlIlllIllIllIll.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIllIll.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIllIll.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIllIll.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIlllII.draw();
                }
                if (lllllllllllIlIIllIlIlllIlllIlllI.func_193401_d(lllllllllllIlIIllIlIlllIllllIIIl, lllllllllllIlIIllIlIlllIlllIllll, EnumFacing.DOWN) == BlockFaceShape.SOLID) {
                    final Tessellator lllllllllllIlIIllIlIlllIllIllIlI = Tessellator.getInstance();
                    final BufferBuilder lllllllllllIlIIllIlIlllIllIllIIl = lllllllllllIlIIllIlIlllIllIllIlI.getBuffer();
                    lllllllllllIlIIllIlIlllIllIllIIl.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    lllllllllllIlIIllIlIlllIllIllIIl.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIllIIl.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIllIIl.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIllIIl.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIll, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    lllllllllllIlIIllIlIlllIllIllIlI.draw();
                }
                if (lllllllllllIlIIllIlIlllIlllIlllI.func_193401_d(lllllllllllIlIIllIlIlllIllllIIIl, lllllllllllIlIIllIlIlllIlllIllll, EnumFacing.UP) != BlockFaceShape.SOLID) {
                    continue;
                }
                final Tessellator lllllllllllIlIIllIlIlllIllIllIII = Tessellator.getInstance();
                final BufferBuilder lllllllllllIlIIllIlIlllIllIlIlll = lllllllllllIlIIllIlIlllIllIllIII.getBuffer();
                lllllllllllIlIIllIlIlllIllIlIlll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                lllllllllllIlIIllIlIlllIllIlIlll.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                lllllllllllIlIIllIlIlllIllIlIlll.pos(lllllllllllIlIIllIlIlllIlllIllII, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                lllllllllllIlIIllIlIlllIllIlIlll.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIlIlI).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                lllllllllllIlIIllIlIlllIllIlIlll.pos(lllllllllllIlIIllIlIlllIlllIlIIl, lllllllllllIlIIllIlIlllIlllIlIII, lllllllllllIlIIllIlIlllIlllIIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                lllllllllllIlIIllIlIlllIllIllIII.draw();
            }
        }
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public DebugRendererSolidFace(final Minecraft lllllllllllIlIIllIlIllllIIIlIIll) {
        this.field_193851_a = lllllllllllIlIIllIlIllllIIIlIIll;
    }
}
