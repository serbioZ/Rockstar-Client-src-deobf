// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.debug;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;

public class DebugRendererHeightMap implements DebugRenderer.IDebugRenderer
{
    private final /* synthetic */ Minecraft minecraft;
    
    @Override
    public void render(final float lllllllllllllIllIllIlIIlIlIIlIIl, final long lllllllllllllIllIllIlIIlIlIlIllI) {
        final EntityPlayer lllllllllllllIllIllIlIIlIlIlIlIl = this.minecraft.player;
        final World lllllllllllllIllIllIlIIlIlIlIlII = this.minecraft.world;
        final double lllllllllllllIllIllIlIIlIlIlIIll = lllllllllllllIllIllIlIIlIlIlIlIl.lastTickPosX + (lllllllllllllIllIllIlIIlIlIlIlIl.posX - lllllllllllllIllIllIlIIlIlIlIlIl.lastTickPosX) * lllllllllllllIllIllIlIIlIlIIlIIl;
        final double lllllllllllllIllIllIlIIlIlIlIIlI = lllllllllllllIllIllIlIIlIlIlIlIl.lastTickPosY + (lllllllllllllIllIllIlIIlIlIlIlIl.posY - lllllllllllllIllIllIlIIlIlIlIlIl.lastTickPosY) * lllllllllllllIllIllIlIIlIlIIlIIl;
        final double lllllllllllllIllIllIlIIlIlIlIIIl = lllllllllllllIllIllIlIIlIlIlIlIl.lastTickPosZ + (lllllllllllllIllIllIlIIlIlIlIlIl.posZ - lllllllllllllIllIllIlIIlIlIlIlIl.lastTickPosZ) * lllllllllllllIllIllIlIIlIlIIlIIl;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.disableTexture2D();
        final BlockPos lllllllllllllIllIllIlIIlIlIlIIII = new BlockPos(lllllllllllllIllIllIlIIlIlIlIlIl.posX, 0.0, lllllllllllllIllIllIlIIlIlIlIlIl.posZ);
        final Iterable<BlockPos> lllllllllllllIllIllIlIIlIlIIllll = BlockPos.getAllInBox(lllllllllllllIllIllIlIIlIlIlIIII.add(-40, 0, -40), lllllllllllllIllIllIlIIlIlIlIIII.add(40, 0, 40));
        final Tessellator lllllllllllllIllIllIlIIlIlIIlllI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIllIllIlIIlIlIIllIl = lllllllllllllIllIllIlIIlIlIIlllI.getBuffer();
        lllllllllllllIllIllIlIIlIlIIllIl.begin(5, DefaultVertexFormats.POSITION_COLOR);
        for (final BlockPos lllllllllllllIllIllIlIIlIlIIllII : lllllllllllllIllIllIlIIlIlIIllll) {
            final int lllllllllllllIllIllIlIIlIlIIlIll = lllllllllllllIllIllIlIIlIlIlIlII.getHeight(lllllllllllllIllIllIlIIlIlIIllII.getX(), lllllllllllllIllIllIlIIlIlIIllII.getZ());
            if (lllllllllllllIllIllIlIIlIlIlIlII.getBlockState(lllllllllllllIllIllIlIIlIlIIllII.add(0, lllllllllllllIllIllIlIIlIlIIlIll, 0).down()) == Blocks.AIR.getDefaultState()) {
                RenderGlobal.addChainedFilledBoxVertices(lllllllllllllIllIllIlIIlIlIIllIl, lllllllllllllIllIllIlIIlIlIIllII.getX() + 0.25f - lllllllllllllIllIllIlIIlIlIlIIll, lllllllllllllIllIllIlIIlIlIIlIll - lllllllllllllIllIllIlIIlIlIlIIlI, lllllllllllllIllIllIlIIlIlIIllII.getZ() + 0.25f - lllllllllllllIllIllIlIIlIlIlIIIl, lllllllllllllIllIllIlIIlIlIIllII.getX() + 0.75f - lllllllllllllIllIllIlIIlIlIlIIll, lllllllllllllIllIllIlIIlIlIIlIll + 0.09375 - lllllllllllllIllIllIlIIlIlIlIIlI, lllllllllllllIllIllIlIIlIlIIllII.getZ() + 0.75f - lllllllllllllIllIllIlIIlIlIlIIIl, 0.0f, 0.0f, 1.0f, 0.5f);
            }
            else {
                RenderGlobal.addChainedFilledBoxVertices(lllllllllllllIllIllIlIIlIlIIllIl, lllllllllllllIllIllIlIIlIlIIllII.getX() + 0.25f - lllllllllllllIllIllIlIIlIlIlIIll, lllllllllllllIllIllIlIIlIlIIlIll - lllllllllllllIllIllIlIIlIlIlIIlI, lllllllllllllIllIllIlIIlIlIIllII.getZ() + 0.25f - lllllllllllllIllIllIlIIlIlIlIIIl, lllllllllllllIllIllIlIIlIlIIllII.getX() + 0.75f - lllllllllllllIllIllIlIIlIlIlIIll, lllllllllllllIllIllIlIIlIlIIlIll + 0.09375 - lllllllllllllIllIllIlIIlIlIlIIlI, lllllllllllllIllIllIlIIlIlIIllII.getZ() + 0.75f - lllllllllllllIllIllIlIIlIlIlIIIl, 0.0f, 1.0f, 0.0f, 0.5f);
            }
        }
        lllllllllllllIllIllIlIIlIlIIlllI.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }
    
    public DebugRendererHeightMap(final Minecraft lllllllllllllIllIllIlIIlIllIIlll) {
        this.minecraft = lllllllllllllIllIllIlIIlIllIIlll;
    }
}
