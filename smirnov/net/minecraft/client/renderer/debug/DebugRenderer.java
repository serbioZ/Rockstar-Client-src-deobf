// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.debug;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;

public class DebugRenderer
{
    private /* synthetic */ boolean field_191558_l;
    private /* synthetic */ boolean waterEnabled;
    public final /* synthetic */ IDebugRenderer field_193852_g;
    private /* synthetic */ boolean pathfindingEnabled;
    public final /* synthetic */ IDebugRenderer debugRendererChunkBorder;
    private /* synthetic */ boolean chunkBordersEnabled;
    private /* synthetic */ boolean field_191326_j;
    public final /* synthetic */ IDebugRenderer debugRendererHeightMap;
    private /* synthetic */ boolean heightmapEnabled;
    public final /* synthetic */ IDebugRenderer field_191557_f;
    public final /* synthetic */ IDebugRenderer field_191325_e;
    public final /* synthetic */ IDebugRenderer debugRendererPathfinding;
    public final /* synthetic */ IDebugRenderer debugRendererWater;
    private /* synthetic */ boolean field_193853_n;
    
    public DebugRenderer(final Minecraft lllllllllllllIIIIllIlIIllIIIIllI) {
        this.debugRendererPathfinding = new DebugRendererPathfinding(lllllllllllllIIIIllIlIIllIIIIllI);
        this.debugRendererWater = new DebugRendererWater(lllllllllllllIIIIllIlIIllIIIIllI);
        this.debugRendererChunkBorder = new DebugRendererChunkBorder(lllllllllllllIIIIllIlIIllIIIIllI);
        this.debugRendererHeightMap = new DebugRendererHeightMap(lllllllllllllIIIIllIlIIllIIIIllI);
        this.field_191325_e = new DebugRendererCollisionBox(lllllllllllllIIIIllIlIIllIIIIllI);
        this.field_191557_f = new DebugRendererNeighborsUpdate(lllllllllllllIIIIllIlIIllIIIIllI);
        this.field_193852_g = new DebugRendererSolidFace(lllllllllllllIIIIllIlIIllIIIIllI);
    }
    
    public static void func_191556_a(final String lllllllllllllIIIIllIlIIlIllIlIlI, final int lllllllllllllIIIIllIlIIlIllIllll, final int lllllllllllllIIIIllIlIIlIllIlIII, final int lllllllllllllIIIIllIlIIlIllIIlll, final float lllllllllllllIIIIllIlIIlIllIIllI, final int lllllllllllllIIIIllIlIIlIllIlIll) {
        renderDebugText(lllllllllllllIIIIllIlIIlIllIlIlI, lllllllllllllIIIIllIlIIlIllIllll + 0.5, lllllllllllllIIIIllIlIIlIllIlIII + 0.5, lllllllllllllIIIIllIlIIlIllIIlll + 0.5, lllllllllllllIIIIllIlIIlIllIIllI, lllllllllllllIIIIllIlIIlIllIlIll);
    }
    
    public static void renderDebugText(final String lllllllllllllIIIIllIlIIlIlIIlIlI, final double lllllllllllllIIIIllIlIIlIlIIlIIl, final double lllllllllllllIIIIllIlIIlIlIIlIII, final double lllllllllllllIIIIllIlIIlIlIlIlII, final float lllllllllllllIIIIllIlIIlIlIlIIll, final int lllllllllllllIIIIllIlIIlIlIlIIlI) {
        final Minecraft lllllllllllllIIIIllIlIIlIlIlIIIl = Minecraft.getMinecraft();
        if (lllllllllllllIIIIllIlIIlIlIlIIIl.player != null && lllllllllllllIIIIllIlIIlIlIlIIIl.getRenderManager() != null && lllllllllllllIIIIllIlIIlIlIlIIIl.getRenderManager().options != null) {
            final FontRenderer lllllllllllllIIIIllIlIIlIlIlIIII = Minecraft.fontRendererObj;
            final EntityPlayer lllllllllllllIIIIllIlIIlIlIIllll = lllllllllllllIIIIllIlIIlIlIlIIIl.player;
            final double lllllllllllllIIIIllIlIIlIlIIlllI = lllllllllllllIIIIllIlIIlIlIIllll.lastTickPosX + (lllllllllllllIIIIllIlIIlIlIIllll.posX - lllllllllllllIIIIllIlIIlIlIIllll.lastTickPosX) * lllllllllllllIIIIllIlIIlIlIlIIll;
            final double lllllllllllllIIIIllIlIIlIlIIllIl = lllllllllllllIIIIllIlIIlIlIIllll.lastTickPosY + (lllllllllllllIIIIllIlIIlIlIIllll.posY - lllllllllllllIIIIllIlIIlIlIIllll.lastTickPosY) * lllllllllllllIIIIllIlIIlIlIlIIll;
            final double lllllllllllllIIIIllIlIIlIlIIllII = lllllllllllllIIIIllIlIIlIlIIllll.lastTickPosZ + (lllllllllllllIIIIllIlIIlIlIIllll.posZ - lllllllllllllIIIIllIlIIlIlIIllll.lastTickPosZ) * lllllllllllllIIIIllIlIIlIlIlIIll;
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)(lllllllllllllIIIIllIlIIlIlIIlIIl - lllllllllllllIIIIllIlIIlIlIIlllI), (float)(lllllllllllllIIIIllIlIIlIlIIlIII - lllllllllllllIIIIllIlIIlIlIIllIl) + 0.07f, (float)(lllllllllllllIIIIllIlIIlIlIlIlII - lllllllllllllIIIIllIlIIlIlIIllII));
            GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.scale(0.02f, -0.02f, 0.02f);
            final RenderManager lllllllllllllIIIIllIlIIlIlIIlIll = lllllllllllllIIIIllIlIIlIlIlIIIl.getRenderManager();
            GlStateManager.rotate(-RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(((lllllllllllllIIIIllIlIIlIlIIlIll.options.thirdPersonView == 2) ? 1 : -1) * RenderManager.playerViewX, 1.0f, 0.0f, 0.0f);
            GlStateManager.disableLighting();
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            GlStateManager.scale(-1.0f, 1.0f, 1.0f);
            lllllllllllllIIIIllIlIIlIlIlIIII.drawString(lllllllllllllIIIIllIlIIlIlIIlIlI, (float)(-lllllllllllllIIIIllIlIIlIlIlIIII.getStringWidth(lllllllllllllIIIIllIlIIlIlIIlIlI) / 2), 0.0f, lllllllllllllIIIIllIlIIlIlIlIIlI);
            GlStateManager.enableLighting();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
    }
    
    public void renderDebug(final float lllllllllllllIIIIllIlIIlIllllIII, final long lllllllllllllIIIIllIlIIlIllllIlI) {
        if (this.pathfindingEnabled) {
            this.debugRendererPathfinding.render(lllllllllllllIIIIllIlIIlIllllIII, lllllllllllllIIIIllIlIIlIllllIlI);
        }
        if (this.chunkBordersEnabled && !Minecraft.getMinecraft().isReducedDebug()) {
            this.debugRendererChunkBorder.render(lllllllllllllIIIIllIlIIlIllllIII, lllllllllllllIIIIllIlIIlIllllIlI);
        }
        if (this.waterEnabled) {
            this.debugRendererWater.render(lllllllllllllIIIIllIlIIlIllllIII, lllllllllllllIIIIllIlIIlIllllIlI);
        }
        if (this.heightmapEnabled) {
            this.debugRendererHeightMap.render(lllllllllllllIIIIllIlIIlIllllIII, lllllllllllllIIIIllIlIIlIllllIlI);
        }
        if (this.field_191326_j) {
            this.field_191325_e.render(lllllllllllllIIIIllIlIIlIllllIII, lllllllllllllIIIIllIlIIlIllllIlI);
        }
        if (this.field_191558_l) {
            this.field_191557_f.render(lllllllllllllIIIIllIlIIlIllllIII, lllllllllllllIIIIllIlIIlIllllIlI);
        }
        if (this.field_193853_n) {
            this.field_193852_g.render(lllllllllllllIIIIllIlIIlIllllIII, lllllllllllllIIIIllIlIIlIllllIlI);
        }
    }
    
    public boolean shouldRender() {
        return this.chunkBordersEnabled || this.pathfindingEnabled || this.waterEnabled || this.heightmapEnabled || this.field_191326_j || this.field_191558_l || this.field_193853_n;
    }
    
    public boolean toggleDebugScreen() {
        this.chunkBordersEnabled = !this.chunkBordersEnabled;
        return this.chunkBordersEnabled;
    }
    
    public interface IDebugRenderer
    {
        void render(final float p0, final long p1);
    }
}
