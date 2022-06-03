// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntityStructure;

public class TileEntityStructureRenderer extends TileEntitySpecialRenderer<TileEntityStructure>
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    
    private void renderBox(final Tessellator llllllllllIlllIIIlllIlIlIIlllllI, final BufferBuilder llllllllllIlllIIIlllIlIlIIllIIII, final double llllllllllIlllIIIlllIlIlIIlIllll, final double llllllllllIlllIIIlllIlIlIIlIlllI, final double llllllllllIlllIIIlllIlIlIIlIllIl, final double llllllllllIlllIIIlllIlIlIIlllIIl, final double llllllllllIlllIIIlllIlIlIIlIlIll, final double llllllllllIlllIIIlllIlIlIIlIlIlI, final int llllllllllIlllIIIlllIlIlIIlIlIIl, final int llllllllllIlllIIIlllIlIlIIllIIll, final int llllllllllIlllIIIlllIlIlIIllIIlI) {
        GlStateManager.glLineWidth(2.0f);
        llllllllllIlllIIIlllIlIlIIllIIII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlIllll, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIllIl).color((float)llllllllllIlllIIIlllIlIlIIllIIll, (float)llllllllllIlllIIIlllIlIlIIllIIll, (float)llllllllllIlllIIIlllIlIlIIllIIll, 0.0f).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlIllll, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIllIl).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlllIIl, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIllIl).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIlI, llllllllllIlllIIIlllIlIlIIllIIlI, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlllIIl, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIlIlI).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlIllll, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIlIlI).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlIllll, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIllIl).color(llllllllllIlllIIIlllIlIlIIllIIlI, llllllllllIlllIIIlllIlIlIIllIIlI, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlIllll, llllllllllIlllIIIlllIlIlIIlIlIll, llllllllllIlllIIIlllIlIlIIlIllIl).color(llllllllllIlllIIIlllIlIlIIllIIlI, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIlI, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlllIIl, llllllllllIlllIIIlllIlIlIIlIlIll, llllllllllIlllIIIlllIlIlIIlIllIl).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlllIIl, llllllllllIlllIIIlllIlIlIIlIlIll, llllllllllIlllIIIlllIlIlIIlIlIlI).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlIllll, llllllllllIlllIIIlllIlIlIIlIlIll, llllllllllIlllIIIlllIlIlIIlIlIlI).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlIllll, llllllllllIlllIIIlllIlIlIIlIlIll, llllllllllIlllIIIlllIlIlIIlIllIl).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlIllll, llllllllllIlllIIIlllIlIlIIlIlIll, llllllllllIlllIIIlllIlIlIIlIlIlI).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlIllll, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIlIlI).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlllIIl, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIlIlI).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlllIIl, llllllllllIlllIIIlllIlIlIIlIlIll, llllllllllIlllIIIlllIlIlIIlIlIlI).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlllIIl, llllllllllIlllIIIlllIlIlIIlIlIll, llllllllllIlllIIIlllIlIlIIlIllIl).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlllIIl, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIllIl).color(llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIllIIll, llllllllllIlllIIIlllIlIlIIlIlIIl).endVertex();
        llllllllllIlllIIIlllIlIlIIllIIII.pos(llllllllllIlllIIIlllIlIlIIlllIIl, llllllllllIlllIIIlllIlIlIIlIlllI, llllllllllIlllIIIlllIlIlIIlIllIl).color((float)llllllllllIlllIIIlllIlIlIIllIIll, (float)llllllllllIlllIIIlllIlIlIIllIIll, (float)llllllllllIlllIIIlllIlIlIIllIIll, 0.0f).endVertex();
        llllllllllIlllIIIlllIlIlIIlllllI.draw();
        GlStateManager.glLineWidth(1.0f);
    }
    
    private void renderInvisibleBlocks(final TileEntityStructure llllllllllIlllIIIlllIlIlIllIIIIl, final double llllllllllIlllIIIlllIlIlIllIIIII, final double llllllllllIlllIIIlllIlIlIlllIlIl, final double llllllllllIlllIIIlllIlIlIlIllllI, final BlockPos llllllllllIlllIIIlllIlIlIlIlllIl, final Tessellator llllllllllIlllIIIlllIlIlIlllIIlI, final BufferBuilder llllllllllIlllIIIlllIlIlIlIllIll, final boolean llllllllllIlllIIIlllIlIlIlIllIlI) {
        GlStateManager.glLineWidth(llllllllllIlllIIIlllIlIlIlIllIlI ? 3.0f : 1.0f);
        llllllllllIlllIIIlllIlIlIlIllIll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        final World llllllllllIlllIIIlllIlIlIllIllll = llllllllllIlllIIIlllIlIlIllIIIIl.getWorld();
        final BlockPos llllllllllIlllIIIlllIlIlIllIlllI = llllllllllIlllIIIlllIlIlIllIIIIl.getPos();
        final BlockPos llllllllllIlllIIIlllIlIlIllIllIl = llllllllllIlllIIIlllIlIlIllIlllI.add(llllllllllIlllIIIlllIlIlIlIlllIl);
        for (final BlockPos llllllllllIlllIIIlllIlIlIllIllII : BlockPos.getAllInBox(llllllllllIlllIIIlllIlIlIllIllIl, llllllllllIlllIIIlllIlIlIllIllIl.add(llllllllllIlllIIIlllIlIlIllIIIIl.getStructureSize()).add(-1, -1, -1))) {
            final IBlockState llllllllllIlllIIIlllIlIlIllIlIll = llllllllllIlllIIIlllIlIlIllIllll.getBlockState(llllllllllIlllIIIlllIlIlIllIllII);
            final boolean llllllllllIlllIIIlllIlIlIllIlIlI = llllllllllIlllIIIlllIlIlIllIlIll == Blocks.AIR.getDefaultState();
            final boolean llllllllllIlllIIIlllIlIlIllIlIIl = llllllllllIlllIIIlllIlIlIllIlIll == Blocks.STRUCTURE_VOID.getDefaultState();
            if (llllllllllIlllIIIlllIlIlIllIlIlI || llllllllllIlllIIIlllIlIlIllIlIIl) {
                final float llllllllllIlllIIIlllIlIlIllIlIII = llllllllllIlllIIIlllIlIlIllIlIlI ? 0.05f : 0.0f;
                final double llllllllllIlllIIIlllIlIlIllIIlll = llllllllllIlllIIIlllIlIlIllIllII.getX() - llllllllllIlllIIIlllIlIlIllIlllI.getX() + 0.45f + llllllllllIlllIIIlllIlIlIllIIIII - llllllllllIlllIIIlllIlIlIllIlIII;
                final double llllllllllIlllIIIlllIlIlIllIIllI = llllllllllIlllIIIlllIlIlIllIllII.getY() - llllllllllIlllIIIlllIlIlIllIlllI.getY() + 0.45f + llllllllllIlllIIIlllIlIlIlllIlIl - llllllllllIlllIIIlllIlIlIllIlIII;
                final double llllllllllIlllIIIlllIlIlIllIIlIl = llllllllllIlllIIIlllIlIlIllIllII.getZ() - llllllllllIlllIIIlllIlIlIllIlllI.getZ() + 0.45f + llllllllllIlllIIIlllIlIlIlIllllI - llllllllllIlllIIIlllIlIlIllIlIII;
                final double llllllllllIlllIIIlllIlIlIllIIlII = llllllllllIlllIIIlllIlIlIllIllII.getX() - llllllllllIlllIIIlllIlIlIllIlllI.getX() + 0.55f + llllllllllIlllIIIlllIlIlIllIIIII + llllllllllIlllIIIlllIlIlIllIlIII;
                final double llllllllllIlllIIIlllIlIlIllIIIll = llllllllllIlllIIIlllIlIlIllIllII.getY() - llllllllllIlllIIIlllIlIlIllIlllI.getY() + 0.55f + llllllllllIlllIIIlllIlIlIlllIlIl + llllllllllIlllIIIlllIlIlIllIlIII;
                final double llllllllllIlllIIIlllIlIlIllIIIlI = llllllllllIlllIIIlllIlIlIllIllII.getZ() - llllllllllIlllIIIlllIlIlIllIlllI.getZ() + 0.55f + llllllllllIlllIIIlllIlIlIlIllllI + llllllllllIlllIIIlllIlIlIllIlIII;
                if (llllllllllIlllIIIlllIlIlIlIllIlI) {
                    RenderGlobal.drawBoundingBox(llllllllllIlllIIIlllIlIlIlIllIll, llllllllllIlllIIIlllIlIlIllIIlll, llllllllllIlllIIIlllIlIlIllIIllI, llllllllllIlllIIIlllIlIlIllIIlIl, llllllllllIlllIIIlllIlIlIllIIlII, llllllllllIlllIIIlllIlIlIllIIIll, llllllllllIlllIIIlllIlIlIllIIIlI, 0.0f, 0.0f, 0.0f, 1.0f);
                }
                else if (llllllllllIlllIIIlllIlIlIllIlIlI) {
                    RenderGlobal.drawBoundingBox(llllllllllIlllIIIlllIlIlIlIllIll, llllllllllIlllIIIlllIlIlIllIIlll, llllllllllIlllIIIlllIlIlIllIIllI, llllllllllIlllIIIlllIlIlIllIIlIl, llllllllllIlllIIIlllIlIlIllIIlII, llllllllllIlllIIIlllIlIlIllIIIll, llllllllllIlllIIIlllIlIlIllIIIlI, 0.5f, 0.5f, 1.0f, 1.0f);
                }
                else {
                    RenderGlobal.drawBoundingBox(llllllllllIlllIIIlllIlIlIlIllIll, llllllllllIlllIIIlllIlIlIllIIlll, llllllllllIlllIIIlllIlIlIllIIllI, llllllllllIlllIIIlllIlIlIllIIlIl, llllllllllIlllIIIlllIlIlIllIIlII, llllllllllIlllIIIlllIlIlIllIIIll, llllllllllIlllIIIlllIlIlIllIIIlI, 1.0f, 0.25f, 0.25f, 1.0f);
                }
            }
        }
        llllllllllIlllIIIlllIlIlIlllIIlI.draw();
    }
    
    @Override
    public void func_192841_a(final TileEntityStructure llllllllllIlllIIIlllIlIlllIlIIlI, final double llllllllllIlllIIIlllIlIlllIlIIIl, final double llllllllllIlllIIIlllIlIlllIlIIII, final double llllllllllIlllIIIlllIlIlllIIllll, final float llllllllllIlllIIIlllIlIlllIIlllI, final int llllllllllIlllIIIlllIlIllIlIIIll, final float llllllllllIlllIIIlllIlIllIlIIIlI) {
        if (Minecraft.getMinecraft().player.canUseCommandBlock() || Minecraft.getMinecraft().player.isSpectator()) {
            super.func_192841_a(llllllllllIlllIIIlllIlIlllIlIIlI, llllllllllIlllIIIlllIlIlllIlIIIl, llllllllllIlllIIIlllIlIlllIlIIII, llllllllllIlllIIIlllIlIlllIIllll, llllllllllIlllIIIlllIlIlllIIlllI, llllllllllIlllIIIlllIlIllIlIIIll, llllllllllIlllIIIlllIlIllIlIIIlI);
            final BlockPos llllllllllIlllIIIlllIlIlllIIlIll = llllllllllIlllIIIlllIlIlllIlIIlI.getPosition();
            final BlockPos llllllllllIlllIIIlllIlIlllIIlIlI = llllllllllIlllIIIlllIlIlllIlIIlI.getStructureSize();
            if (llllllllllIlllIIIlllIlIlllIIlIlI.getX() >= 1 && llllllllllIlllIIIlllIlIlllIIlIlI.getY() >= 1 && llllllllllIlllIIIlllIlIlllIIlIlI.getZ() >= 1 && (llllllllllIlllIIIlllIlIlllIlIIlI.getMode() == TileEntityStructure.Mode.SAVE || llllllllllIlllIIIlllIlIlllIlIIlI.getMode() == TileEntityStructure.Mode.LOAD)) {
                final double llllllllllIlllIIIlllIlIlllIIlIIl = 0.01;
                final double llllllllllIlllIIIlllIlIlllIIlIII = llllllllllIlllIIIlllIlIlllIIlIll.getX();
                final double llllllllllIlllIIIlllIlIlllIIIlll = llllllllllIlllIIIlllIlIlllIIlIll.getZ();
                final double llllllllllIlllIIIlllIlIlllIIIllI = llllllllllIlllIIIlllIlIlllIlIIII + llllllllllIlllIIIlllIlIlllIIlIll.getY() - 0.01;
                final double llllllllllIlllIIIlllIlIlllIIIlIl = llllllllllIlllIIIlllIlIlllIIIllI + llllllllllIlllIIIlllIlIlllIIlIlI.getY() + 0.02;
                final double llllllllllIlllIIIlllIlIlllIIIIlI;
                final double llllllllllIlllIIIlllIlIllIllllll;
                switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllIlllIIIlllIlIlllIlIIlI.getMirror().ordinal()]) {
                    case 2: {
                        final double llllllllllIlllIIIlllIlIlllIIIlII = llllllllllIlllIIIlllIlIlllIIlIlI.getX() + 0.02;
                        final double llllllllllIlllIIIlllIlIlllIIIIIl = -(llllllllllIlllIIIlllIlIlllIIlIlI.getZ() + 0.02);
                        break;
                    }
                    case 3: {
                        final double llllllllllIlllIIIlllIlIlllIIIIll = -(llllllllllIlllIIIlllIlIlllIIlIlI.getX() + 0.02);
                        final double llllllllllIlllIIIlllIlIlllIIIIII = llllllllllIlllIIIlllIlIlllIIlIlI.getZ() + 0.02;
                        break;
                    }
                    default: {
                        llllllllllIlllIIIlllIlIlllIIIIlI = llllllllllIlllIIIlllIlIlllIIlIlI.getX() + 0.02;
                        llllllllllIlllIIIlllIlIllIllllll = llllllllllIlllIIIlllIlIlllIIlIlI.getZ() + 0.02;
                        break;
                    }
                }
                final double llllllllllIlllIIIlllIlIllIlllIll;
                final double llllllllllIlllIIIlllIlIllIllIlll;
                final double llllllllllIlllIIIlllIlIllIllIIll;
                final double llllllllllIlllIIIlllIlIllIlIllll;
                switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllIlllIIIlllIlIlllIlIIlI.getRotation().ordinal()]) {
                    case 2: {
                        final double llllllllllIlllIIIlllIlIllIlllllI = llllllllllIlllIIIlllIlIlllIlIIIl + ((llllllllllIlllIIIlllIlIllIllllll < 0.0) ? (llllllllllIlllIIIlllIlIlllIIlIII - 0.01) : (llllllllllIlllIIIlllIlIlllIIlIII + 1.0 + 0.01));
                        final double llllllllllIlllIIIlllIlIllIlllIlI = llllllllllIlllIIIlllIlIlllIIllll + ((llllllllllIlllIIIlllIlIlllIIIIlI < 0.0) ? (llllllllllIlllIIIlllIlIlllIIIlll + 1.0 + 0.01) : (llllllllllIlllIIIlllIlIlllIIIlll - 0.01));
                        final double llllllllllIlllIIIlllIlIllIllIllI = llllllllllIlllIIIlllIlIllIlllllI - llllllllllIlllIIIlllIlIllIllllll;
                        final double llllllllllIlllIIIlllIlIllIllIIlI = llllllllllIlllIIIlllIlIllIlllIlI + llllllllllIlllIIIlllIlIlllIIIIlI;
                        break;
                    }
                    case 3: {
                        final double llllllllllIlllIIIlllIlIllIllllIl = llllllllllIlllIIIlllIlIlllIlIIIl + ((llllllllllIlllIIIlllIlIlllIIIIlI < 0.0) ? (llllllllllIlllIIIlllIlIlllIIlIII - 0.01) : (llllllllllIlllIIIlllIlIlllIIlIII + 1.0 + 0.01));
                        final double llllllllllIlllIIIlllIlIllIlllIIl = llllllllllIlllIIIlllIlIlllIIllll + ((llllllllllIlllIIIlllIlIllIllllll < 0.0) ? (llllllllllIlllIIIlllIlIlllIIIlll - 0.01) : (llllllllllIlllIIIlllIlIlllIIIlll + 1.0 + 0.01));
                        final double llllllllllIlllIIIlllIlIllIllIlIl = llllllllllIlllIIIlllIlIllIllllIl - llllllllllIlllIIIlllIlIlllIIIIlI;
                        final double llllllllllIlllIIIlllIlIllIllIIIl = llllllllllIlllIIIlllIlIllIlllIIl - llllllllllIlllIIIlllIlIllIllllll;
                        break;
                    }
                    case 4: {
                        final double llllllllllIlllIIIlllIlIllIllllII = llllllllllIlllIIIlllIlIlllIlIIIl + ((llllllllllIlllIIIlllIlIllIllllll < 0.0) ? (llllllllllIlllIIIlllIlIlllIIlIII + 1.0 + 0.01) : (llllllllllIlllIIIlllIlIlllIIlIII - 0.01));
                        final double llllllllllIlllIIIlllIlIllIlllIII = llllllllllIlllIIIlllIlIlllIIllll + ((llllllllllIlllIIIlllIlIlllIIIIlI < 0.0) ? (llllllllllIlllIIIlllIlIlllIIIlll - 0.01) : (llllllllllIlllIIIlllIlIlllIIIlll + 1.0 + 0.01));
                        final double llllllllllIlllIIIlllIlIllIllIlII = llllllllllIlllIIIlllIlIllIllllII + llllllllllIlllIIIlllIlIllIllllll;
                        final double llllllllllIlllIIIlllIlIllIllIIII = llllllllllIlllIIIlllIlIllIlllIII - llllllllllIlllIIIlllIlIlllIIIIlI;
                        break;
                    }
                    default: {
                        llllllllllIlllIIIlllIlIllIlllIll = llllllllllIlllIIIlllIlIlllIlIIIl + ((llllllllllIlllIIIlllIlIlllIIIIlI < 0.0) ? (llllllllllIlllIIIlllIlIlllIIlIII + 1.0 + 0.01) : (llllllllllIlllIIIlllIlIlllIIlIII - 0.01));
                        llllllllllIlllIIIlllIlIllIllIlll = llllllllllIlllIIIlllIlIlllIIllll + ((llllllllllIlllIIIlllIlIllIllllll < 0.0) ? (llllllllllIlllIIIlllIlIlllIIIlll + 1.0 + 0.01) : (llllllllllIlllIIIlllIlIlllIIIlll - 0.01));
                        llllllllllIlllIIIlllIlIllIllIIll = llllllllllIlllIIIlllIlIllIlllIll + llllllllllIlllIIIlllIlIlllIIIIlI;
                        llllllllllIlllIIIlllIlIllIlIllll = llllllllllIlllIIIlllIlIllIllIlll + llllllllllIlllIIIlllIlIllIllllll;
                        break;
                    }
                }
                final int llllllllllIlllIIIlllIlIllIlIlllI = 255;
                final int llllllllllIlllIIIlllIlIllIlIllIl = 223;
                final int llllllllllIlllIIIlllIlIllIlIllII = 127;
                final Tessellator llllllllllIlllIIIlllIlIllIlIlIll = Tessellator.getInstance();
                final BufferBuilder llllllllllIlllIIIlllIlIllIlIlIlI = llllllllllIlllIIIlllIlIllIlIlIll.getBuffer();
                GlStateManager.disableFog();
                GlStateManager.disableLighting();
                GlStateManager.disableTexture2D();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                this.setLightmapDisabled(true);
                if (llllllllllIlllIIIlllIlIlllIlIIlI.getMode() == TileEntityStructure.Mode.SAVE || llllllllllIlllIIIlllIlIlllIlIIlI.showsBoundingBox()) {
                    this.renderBox(llllllllllIlllIIIlllIlIllIlIlIll, llllllllllIlllIIIlllIlIllIlIlIlI, llllllllllIlllIIIlllIlIllIlllIll, llllllllllIlllIIIlllIlIlllIIIllI, llllllllllIlllIIIlllIlIllIllIlll, llllllllllIlllIIIlllIlIllIllIIll, llllllllllIlllIIIlllIlIlllIIIlIl, llllllllllIlllIIIlllIlIllIlIllll, 255, 223, 127);
                }
                if (llllllllllIlllIIIlllIlIlllIlIIlI.getMode() == TileEntityStructure.Mode.SAVE && llllllllllIlllIIIlllIlIlllIlIIlI.showsAir()) {
                    this.renderInvisibleBlocks(llllllllllIlllIIIlllIlIlllIlIIlI, llllllllllIlllIIIlllIlIlllIlIIIl, llllllllllIlllIIIlllIlIlllIlIIII, llllllllllIlllIIIlllIlIlllIIllll, llllllllllIlllIIIlllIlIlllIIlIll, llllllllllIlllIIIlllIlIllIlIlIll, llllllllllIlllIIIlllIlIllIlIlIlI, true);
                    this.renderInvisibleBlocks(llllllllllIlllIIIlllIlIlllIlIIlI, llllllllllIlllIIIlllIlIlllIlIIIl, llllllllllIlllIIIlllIlIlllIlIIII, llllllllllIlllIIIlllIlIlllIIllll, llllllllllIlllIIIlllIlIlllIIlIll, llllllllllIlllIIIlllIlIllIlIlIll, llllllllllIlllIIIlllIlIllIlIlIlI, false);
                }
                this.setLightmapDisabled(false);
                GlStateManager.glLineWidth(1.0f);
                GlStateManager.enableLighting();
                GlStateManager.enableTexture2D();
                GlStateManager.enableDepth();
                GlStateManager.depthMask(true);
                GlStateManager.enableFog();
            }
        }
    }
    
    @Override
    public boolean isGlobalRenderer(final TileEntityStructure llllllllllIlllIIIlllIlIlIIlIIlll) {
        return true;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = TileEntityStructureRenderer.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final byte llllllllllIlllIIIlllIlIlIIIlIIIl = (Object)new int[Mirror.values().length];
        try {
            llllllllllIlllIIIlllIlIlIIIlIIIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIIIlllIlIlIIIlIIIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIIIlllIlIlIIIlIIIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return TileEntityStructureRenderer.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllIlllIIIlllIlIlIIIlIIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = TileEntityStructureRenderer.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final String llllllllllIlllIIIlllIlIlIIIIllll = (Object)new int[Rotation.values().length];
        try {
            llllllllllIlllIIIlllIlIlIIIIllll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIIIlllIlIlIIIIllll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIIIlllIlIlIIIIllll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllIlllIIIlllIlIlIIIIllll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return TileEntityStructureRenderer.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllIlllIIIlllIlIlIIIIllll;
    }
}
