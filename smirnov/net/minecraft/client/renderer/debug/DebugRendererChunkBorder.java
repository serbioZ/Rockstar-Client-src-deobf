// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.debug;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.Minecraft;

public class DebugRendererChunkBorder implements DebugRenderer.IDebugRenderer
{
    private final /* synthetic */ Minecraft minecraft;
    
    @Override
    public void render(final float lllllllllllIIIllIIlIlIlIlIlIIIlI, final long lllllllllllIIIllIIlIlIlIlIlllIII) {
        final EntityPlayer lllllllllllIIIllIIlIlIlIlIllIlll = this.minecraft.player;
        final Tessellator lllllllllllIIIllIIlIlIlIlIllIllI = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIllIIlIlIlIlIllIlIl = lllllllllllIIIllIIlIlIlIlIllIllI.getBuffer();
        final double lllllllllllIIIllIIlIlIlIlIllIlII = lllllllllllIIIllIIlIlIlIlIllIlll.lastTickPosX + (lllllllllllIIIllIIlIlIlIlIllIlll.posX - lllllllllllIIIllIIlIlIlIlIllIlll.lastTickPosX) * lllllllllllIIIllIIlIlIlIlIlIIIlI;
        final double lllllllllllIIIllIIlIlIlIlIllIIll = lllllllllllIIIllIIlIlIlIlIllIlll.lastTickPosY + (lllllllllllIIIllIIlIlIlIlIllIlll.posY - lllllllllllIIIllIIlIlIlIlIllIlll.lastTickPosY) * lllllllllllIIIllIIlIlIlIlIlIIIlI;
        final double lllllllllllIIIllIIlIlIlIlIllIIlI = lllllllllllIIIllIIlIlIlIlIllIlll.lastTickPosZ + (lllllllllllIIIllIIlIlIlIlIllIlll.posZ - lllllllllllIIIllIIlIlIlIlIllIlll.lastTickPosZ) * lllllllllllIIIllIIlIlIlIlIlIIIlI;
        final double lllllllllllIIIllIIlIlIlIlIllIIIl = 0.0 - lllllllllllIIIllIIlIlIlIlIllIIll;
        final double lllllllllllIIIllIIlIlIlIlIllIIII = 256.0 - lllllllllllIIIllIIlIlIlIlIllIIll;
        GlStateManager.disableTexture2D();
        GlStateManager.disableBlend();
        final double lllllllllllIIIllIIlIlIlIlIlIllll = (lllllllllllIIIllIIlIlIlIlIllIlll.chunkCoordX << 4) - lllllllllllIIIllIIlIlIlIlIllIlII;
        final double lllllllllllIIIllIIlIlIlIlIlIlllI = (lllllllllllIIIllIIlIlIlIlIllIlll.chunkCoordZ << 4) - lllllllllllIIIllIIlIlIlIlIllIIlI;
        GlStateManager.glLineWidth(1.0f);
        lllllllllllIIIllIIlIlIlIlIllIlIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        for (int lllllllllllIIIllIIlIlIlIlIlIllIl = -16; lllllllllllIIIllIIlIlIlIlIlIllIl <= 32; lllllllllllIIIllIIlIlIlIlIlIllIl += 16) {
            for (int lllllllllllIIIllIIlIlIlIlIlIllII = -16; lllllllllllIIIllIIlIlIlIlIlIllII <= 32; lllllllllllIIIllIIlIlIlIlIlIllII += 16) {
                lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIllIl, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIllII).color(1.0f, 0.0f, 0.0f, 0.0f).endVertex();
                lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIllIl, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIllII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIllIl, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIllII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIllIl, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIllII).color(1.0f, 0.0f, 0.0f, 0.0f).endVertex();
            }
        }
        for (int lllllllllllIIIllIIlIlIlIlIlIlIll = 2; lllllllllllIIIllIIlIlIlIlIlIlIll < 16; lllllllllllIIIllIIlIlIlIlIlIlIll += 2) {
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIlIll, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIlIll, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIlIll, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIlIll, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIlIll, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + 16.0).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIlIll, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + 16.0).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIlIll, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + 16.0).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIlIll, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + 16.0).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
        }
        for (int lllllllllllIIIllIIlIlIlIlIlIlIlI = 2; lllllllllllIIIllIIlIlIlIlIlIlIlI < 16; lllllllllllIIIllIIlIlIlIlIlIlIlI += 2) {
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIlIlI).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIlIlI).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIlIlI).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIlIlI).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + 16.0, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIlIlI).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + 16.0, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIlIlI).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + 16.0, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIlIlI).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + 16.0, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIlIlI).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
        }
        for (int lllllllllllIIIllIIlIlIlIlIlIlIIl = 0; lllllllllllIIIllIIlIlIlIlIlIlIIl <= 256; lllllllllllIIIllIIlIlIlIlIlIlIIl += 2) {
            final double lllllllllllIIIllIIlIlIlIlIlIlIII = lllllllllllIIIllIIlIlIlIlIlIlIIl - lllllllllllIIIllIIlIlIlIlIllIIll;
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIlIII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIlIII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIlIII, lllllllllllIIIllIIlIlIlIlIlIlllI + 16.0).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + 16.0, lllllllllllIIIllIIlIlIlIlIlIlIII, lllllllllllIIIllIIlIlIlIlIlIlllI + 16.0).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + 16.0, lllllllllllIIIllIIlIlIlIlIlIlIII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIlIII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIlIII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
        }
        lllllllllllIIIllIIlIlIlIlIllIllI.draw();
        GlStateManager.glLineWidth(2.0f);
        lllllllllllIIIllIIlIlIlIlIllIlIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        for (int lllllllllllIIIllIIlIlIlIlIlIIlll = 0; lllllllllllIIIllIIlIlIlIlIlIIlll <= 16; lllllllllllIIIllIIlIlIlIlIlIIlll += 16) {
            for (int lllllllllllIIIllIIlIlIlIlIlIIllI = 0; lllllllllllIIIllIIlIlIlIlIlIIllI <= 16; lllllllllllIIIllIIlIlIlIlIlIIllI += 16) {
                lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIIlll, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIIllI).color(0.25f, 0.25f, 1.0f, 0.0f).endVertex();
                lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIIlll, lllllllllllIIIllIIlIlIlIlIllIIIl, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIIllI).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
                lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIIlll, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIIllI).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
                lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + lllllllllllIIIllIIlIlIlIlIlIIlll, lllllllllllIIIllIIlIlIlIlIllIIII, lllllllllllIIIllIIlIlIlIlIlIlllI + lllllllllllIIIllIIlIlIlIlIlIIllI).color(0.25f, 0.25f, 1.0f, 0.0f).endVertex();
            }
        }
        for (int lllllllllllIIIllIIlIlIlIlIlIIlIl = 0; lllllllllllIIIllIIlIlIlIlIlIIlIl <= 256; lllllllllllIIIllIIlIlIlIlIlIIlIl += 16) {
            final double lllllllllllIIIllIIlIlIlIlIlIIlII = lllllllllllIIIllIIlIlIlIlIlIIlIl - lllllllllllIIIllIIlIlIlIlIllIIll;
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIIlII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(0.25f, 0.25f, 1.0f, 0.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIIlII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIIlII, lllllllllllIIIllIIlIlIlIlIlIlllI + 16.0).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + 16.0, lllllllllllIIIllIIlIlIlIlIlIIlII, lllllllllllIIIllIIlIlIlIlIlIlllI + 16.0).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll + 16.0, lllllllllllIIIllIIlIlIlIlIlIIlII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIIlII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllIIIllIIlIlIlIlIllIlIl.pos(lllllllllllIIIllIIlIlIlIlIlIllll, lllllllllllIIIllIIlIlIlIlIlIIlII, lllllllllllIIIllIIlIlIlIlIlIlllI).color(0.25f, 0.25f, 1.0f, 0.0f).endVertex();
        }
        lllllllllllIIIllIIlIlIlIlIllIllI.draw();
        GlStateManager.glLineWidth(1.0f);
        GlStateManager.enableBlend();
        GlStateManager.enableTexture2D();
    }
    
    public DebugRendererChunkBorder(final Minecraft lllllllllllIIIllIIlIlIlIllIIlIIl) {
        this.minecraft = lllllllllllIIIllIIlIlIlIllIIlIIl;
    }
}
