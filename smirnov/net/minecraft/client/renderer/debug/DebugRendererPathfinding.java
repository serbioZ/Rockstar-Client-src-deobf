// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.debug;

import com.google.common.collect.Maps;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.pathfinding.Path;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Map;

public class DebugRendererPathfinding implements DebugRenderer.IDebugRenderer
{
    private /* synthetic */ double xo;
    private final /* synthetic */ Map<Integer, Float> pathMaxDistance;
    private /* synthetic */ EntityPlayer player;
    private /* synthetic */ double zo;
    private /* synthetic */ double yo;
    private final /* synthetic */ Map<Integer, Path> pathMap;
    private final /* synthetic */ Minecraft minecraft;
    private final /* synthetic */ Map<Integer, Long> creationMap;
    
    public void addPath(final int lllllllllllllIIlIIIlIIlIIIIIlIll, final Path lllllllllllllIIlIIIlIIlIIIIIlIlI, final float lllllllllllllIIlIIIlIIlIIIIIllIl) {
        this.pathMap.put(lllllllllllllIIlIIIlIIlIIIIIlIll, lllllllllllllIIlIIIlIIlIIIIIlIlI);
        this.creationMap.put(lllllllllllllIIlIIIlIIlIIIIIlIll, System.currentTimeMillis());
        this.pathMaxDistance.put(lllllllllllllIIlIIIlIIlIIIIIlIll, lllllllllllllIIlIIIlIIlIIIIIllIl);
    }
    
    public void renderPathLine(final float lllllllllllllIIlIIIlIIIlllIlIIIl, final Path lllllllllllllIIlIIIlIIIlllIIIlIl) {
        final Tessellator lllllllllllllIIlIIIlIIIlllIIllll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIIIlIIIlllIIlllI = lllllllllllllIIlIIIlIIIlllIIllll.getBuffer();
        lllllllllllllIIlIIIlIIIlllIIlllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        for (int lllllllllllllIIlIIIlIIIlllIIllIl = 0; lllllllllllllIIlIIIlIIIlllIIllIl < lllllllllllllIIlIIIlIIIlllIIIlIl.getCurrentPathLength(); ++lllllllllllllIIlIIIlIIIlllIIllIl) {
            final PathPoint lllllllllllllIIlIIIlIIIlllIIllII = lllllllllllllIIlIIIlIIIlllIIIlIl.getPathPointFromIndex(lllllllllllllIIlIIIlIIIlllIIllIl);
            if (this.addDistanceToPlayer(lllllllllllllIIlIIIlIIIlllIIllII) <= 40.0f) {
                final float lllllllllllllIIlIIIlIIIlllIIlIll = lllllllllllllIIlIIIlIIIlllIIllIl / (float)lllllllllllllIIlIIIlIIIlllIIIlIl.getCurrentPathLength() * 0.33f;
                final int lllllllllllllIIlIIIlIIIlllIIlIlI = (lllllllllllllIIlIIIlIIIlllIIllIl == 0) ? 0 : MathHelper.hsvToRGB(lllllllllllllIIlIIIlIIIlllIIlIll, 0.9f, 0.9f);
                final int lllllllllllllIIlIIIlIIIlllIIlIIl = lllllllllllllIIlIIIlIIIlllIIlIlI >> 16 & 0xFF;
                final int lllllllllllllIIlIIIlIIIlllIIlIII = lllllllllllllIIlIIIlIIIlllIIlIlI >> 8 & 0xFF;
                final int lllllllllllllIIlIIIlIIIlllIIIlll = lllllllllllllIIlIIIlIIIlllIIlIlI & 0xFF;
                lllllllllllllIIlIIIlIIIlllIIlllI.pos(lllllllllllllIIlIIIlIIIlllIIllII.xCoord - this.xo + 0.5, lllllllllllllIIlIIIlIIIlllIIllII.yCoord - this.yo + 0.5, lllllllllllllIIlIIIlIIIlllIIllII.zCoord - this.zo + 0.5).color(lllllllllllllIIlIIIlIIIlllIIlIIl, lllllllllllllIIlIIIlIIIlllIIlIII, lllllllllllllIIlIIIlIIIlllIIIlll, 255).endVertex();
            }
        }
        lllllllllllllIIlIIIlIIIlllIIllll.draw();
    }
    
    @Override
    public void render(final float lllllllllllllIIlIIIlIIIllllIlIII, final long lllllllllllllIIlIIIlIIIllllllIlI) {
        if (!this.pathMap.isEmpty()) {
            final long lllllllllllllIIlIIIlIIIllllllIIl = System.currentTimeMillis();
            this.player = this.minecraft.player;
            this.xo = this.player.lastTickPosX + (this.player.posX - this.player.lastTickPosX) * lllllllllllllIIlIIIlIIIllllIlIII;
            this.yo = this.player.lastTickPosY + (this.player.posY - this.player.lastTickPosY) * lllllllllllllIIlIIIlIIIllllIlIII;
            this.zo = this.player.lastTickPosZ + (this.player.posZ - this.player.lastTickPosZ) * lllllllllllllIIlIIIlIIIllllIlIII;
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.color(0.0f, 1.0f, 0.0f, 0.75f);
            GlStateManager.disableTexture2D();
            GlStateManager.glLineWidth(6.0f);
            for (final Integer lllllllllllllIIlIIIlIIIllllllIII : this.pathMap.keySet()) {
                final Path lllllllllllllIIlIIIlIIIlllllIlll = this.pathMap.get(lllllllllllllIIlIIIlIIIllllllIII);
                final float lllllllllllllIIlIIIlIIIlllllIllI = this.pathMaxDistance.get(lllllllllllllIIlIIIlIIIllllllIII);
                this.renderPathLine(lllllllllllllIIlIIIlIIIllllIlIII, lllllllllllllIIlIIIlIIIlllllIlll);
                final PathPoint lllllllllllllIIlIIIlIIIlllllIlIl = lllllllllllllIIlIIIlIIIlllllIlll.getTarget();
                if (this.addDistanceToPlayer(lllllllllllllIIlIIIlIIIlllllIlIl) <= 40.0f) {
                    RenderGlobal.renderFilledBox(new AxisAlignedBB(lllllllllllllIIlIIIlIIIlllllIlIl.xCoord + 0.25f, lllllllllllllIIlIIIlIIIlllllIlIl.yCoord + 0.25f, lllllllllllllIIlIIIlIIIlllllIlIl.zCoord + 0.25, lllllllllllllIIlIIIlIIIlllllIlIl.xCoord + 0.75f, lllllllllllllIIlIIIlIIIlllllIlIl.yCoord + 0.75f, lllllllllllllIIlIIIlIIIlllllIlIl.zCoord + 0.75f).offset(-this.xo, -this.yo, -this.zo), 0.0f, 1.0f, 0.0f, 0.5f);
                    for (int lllllllllllllIIlIIIlIIIlllllIlII = 0; lllllllllllllIIlIIIlIIIlllllIlII < lllllllllllllIIlIIIlIIIlllllIlll.getCurrentPathLength(); ++lllllllllllllIIlIIIlIIIlllllIlII) {
                        final PathPoint lllllllllllllIIlIIIlIIIlllllIIll = lllllllllllllIIlIIIlIIIlllllIlll.getPathPointFromIndex(lllllllllllllIIlIIIlIIIlllllIlII);
                        if (this.addDistanceToPlayer(lllllllllllllIIlIIIlIIIlllllIIll) <= 40.0f) {
                            final float lllllllllllllIIlIIIlIIIlllllIIlI = (lllllllllllllIIlIIIlIIIlllllIlII == lllllllllllllIIlIIIlIIIlllllIlll.getCurrentPathIndex()) ? 1.0f : 0.0f;
                            final float lllllllllllllIIlIIIlIIIlllllIIIl = (lllllllllllllIIlIIIlIIIlllllIlII == lllllllllllllIIlIIIlIIIlllllIlll.getCurrentPathIndex()) ? 0.0f : 1.0f;
                            RenderGlobal.renderFilledBox(new AxisAlignedBB(lllllllllllllIIlIIIlIIIlllllIIll.xCoord + 0.5f - lllllllllllllIIlIIIlIIIlllllIllI, lllllllllllllIIlIIIlIIIlllllIIll.yCoord + 0.01f * lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIlllllIIll.zCoord + 0.5f - lllllllllllllIIlIIIlIIIlllllIllI, lllllllllllllIIlIIIlIIIlllllIIll.xCoord + 0.5f + lllllllllllllIIlIIIlIIIlllllIllI, lllllllllllllIIlIIIlIIIlllllIIll.yCoord + 0.25f + 0.01f * lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIlllllIIll.zCoord + 0.5f + lllllllllllllIIlIIIlIIIlllllIllI).offset(-this.xo, -this.yo, -this.zo), lllllllllllllIIlIIIlIIIlllllIIlI, 0.0f, lllllllllllllIIlIIIlIIIlllllIIIl, 0.5f);
                        }
                    }
                }
            }
            for (final Integer lllllllllllllIIlIIIlIIIlllllIIII : this.pathMap.keySet()) {
                final Path lllllllllllllIIlIIIlIIIllllIllll = this.pathMap.get(lllllllllllllIIlIIIlIIIlllllIIII);
                char lllllllllllllIIlIIIlIIIllllIIIII;
                for (short lllllllllllllIIlIIIlIIIllllIIIIl = (short)((PathPoint[])(Object)(lllllllllllllIIlIIIlIIIllllIIIII = (char)(Object)lllllllllllllIIlIIIlIIIllllIllll.getClosedSet())).length, n = 0; n < lllllllllllllIIlIIIlIIIllllIIIIl; ++n) {
                    final PathPoint lllllllllllllIIlIIIlIIIllllIlllI = lllllllllllllIIlIIIlIIIllllIIIII[n];
                    if (this.addDistanceToPlayer(lllllllllllllIIlIIIlIIIllllIlllI) <= 40.0f) {
                        DebugRenderer.renderDebugText(String.format("%s", lllllllllllllIIlIIIlIIIllllIlllI.nodeType), lllllllllllllIIlIIIlIIIllllIlllI.xCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlllI.yCoord + 0.75, lllllllllllllIIlIIIlIIIllllIlllI.zCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlIII, -65536);
                        DebugRenderer.renderDebugText(String.format("%.2f", lllllllllllllIIlIIIlIIIllllIlllI.costMalus), lllllllllllllIIlIIIlIIIllllIlllI.xCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlllI.yCoord + 0.25, lllllllllllllIIlIIIlIIIllllIlllI.zCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlIII, -65536);
                    }
                }
                for (short lllllllllllllIIlIIIlIIIllllIIIIl = (short)((PathPoint[])(Object)(lllllllllllllIIlIIIlIIIllllIIIII = (char)(Object)lllllllllllllIIlIIIlIIIllllIllll.getOpenSet())).length, n2 = 0; n2 < lllllllllllllIIlIIIlIIIllllIIIIl; ++n2) {
                    final PathPoint lllllllllllllIIlIIIlIIIllllIllIl = lllllllllllllIIlIIIlIIIllllIIIII[n2];
                    if (this.addDistanceToPlayer(lllllllllllllIIlIIIlIIIllllIllIl) <= 40.0f) {
                        DebugRenderer.renderDebugText(String.format("%s", lllllllllllllIIlIIIlIIIllllIllIl.nodeType), lllllllllllllIIlIIIlIIIllllIllIl.xCoord + 0.5, lllllllllllllIIlIIIlIIIllllIllIl.yCoord + 0.75, lllllllllllllIIlIIIlIIIllllIllIl.zCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlIII, -16776961);
                        DebugRenderer.renderDebugText(String.format("%.2f", lllllllllllllIIlIIIlIIIllllIllIl.costMalus), lllllllllllllIIlIIIlIIIllllIllIl.xCoord + 0.5, lllllllllllllIIlIIIlIIIllllIllIl.yCoord + 0.25, lllllllllllllIIlIIIlIIIllllIllIl.zCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlIII, -16776961);
                    }
                }
                for (int lllllllllllllIIlIIIlIIIllllIllII = 0; lllllllllllllIIlIIIlIIIllllIllII < lllllllllllllIIlIIIlIIIllllIllll.getCurrentPathLength(); ++lllllllllllllIIlIIIlIIIllllIllII) {
                    final PathPoint lllllllllllllIIlIIIlIIIllllIlIll = lllllllllllllIIlIIIlIIIllllIllll.getPathPointFromIndex(lllllllllllllIIlIIIlIIIllllIllII);
                    if (this.addDistanceToPlayer(lllllllllllllIIlIIIlIIIllllIlIll) <= 40.0f) {
                        DebugRenderer.renderDebugText(String.format("%s", lllllllllllllIIlIIIlIIIllllIlIll.nodeType), lllllllllllllIIlIIIlIIIllllIlIll.xCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlIll.yCoord + 0.75, lllllllllllllIIlIIIlIIIllllIlIll.zCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlIII, -1);
                        DebugRenderer.renderDebugText(String.format("%.2f", lllllllllllllIIlIIIlIIIllllIlIll.costMalus), lllllllllllllIIlIIIlIIIllllIlIll.xCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlIll.yCoord + 0.25, lllllllllllllIIlIIIlIIIllllIlIll.zCoord + 0.5, lllllllllllllIIlIIIlIIIllllIlIII, -1);
                    }
                }
            }
            final Integer[] array;
            final int length = (array = this.creationMap.keySet().toArray(new Integer[0])).length;
            for (byte lllllllllllllIIlIIIlIIIllllIIlIl = 0; lllllllllllllIIlIIIlIIIllllIIlIl < length; ++lllllllllllllIIlIIIlIIIllllIIlIl) {
                final Integer lllllllllllllIIlIIIlIIIllllIlIlI = array[lllllllllllllIIlIIIlIIIllllIIlIl];
                if (lllllllllllllIIlIIIlIIIllllllIIl - this.creationMap.get(lllllllllllllIIlIIIlIIIllllIlIlI) > 20000L) {
                    this.pathMap.remove(lllllllllllllIIlIIIlIIIllllIlIlI);
                    this.creationMap.remove(lllllllllllllIIlIIIlIIIllllIlIlI);
                }
            }
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
    
    private float addDistanceToPlayer(final PathPoint lllllllllllllIIlIIIlIIIllIlllIII) {
        return (float)(Math.abs(lllllllllllllIIlIIIlIIIllIlllIII.xCoord - this.player.posX) + Math.abs(lllllllllllllIIlIIIlIIIllIlllIII.yCoord - this.player.posY) + Math.abs(lllllllllllllIIlIIIlIIIllIlllIII.zCoord - this.player.posZ));
    }
    
    public DebugRendererPathfinding(final Minecraft lllllllllllllIIlIIIlIIlIIIIlIlIl) {
        this.pathMap = (Map<Integer, Path>)Maps.newHashMap();
        this.pathMaxDistance = (Map<Integer, Float>)Maps.newHashMap();
        this.creationMap = (Map<Integer, Long>)Maps.newHashMap();
        this.minecraft = lllllllllllllIIlIIIlIIlIIIIlIlIl;
    }
}
