// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.api.event.EventTarget;
import org.lwjgl.util.glu.Sphere;
import org.lwjgl.util.glu.Cylinder;
import ru.rockstar.api.utils.render.DrawHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;

public class PenisESP extends Feature
{
    private /* synthetic */ float spin;
    private /* synthetic */ float cumSize;
    
    public PenisESP() {
        super("PenisESP", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0432\u0430\u0448 \u0447\u043b\u0435\u043d", 0, Category.VISUALS);
    }
    
    @EventTarget
    public void onRender3D(final Event3D lllllllllllllIIlIlIIlIllIIllIllI) {
        final double n = PenisESP.mc.player.lastTickPosX + (PenisESP.mc.player.posX - PenisESP.mc.player.lastTickPosX) * PenisESP.mc.timer.renderPartialTicks;
        PenisESP.mc.getRenderManager();
        final double lllllllllllllIIlIlIIlIllIIllIlIl = n - RenderManager.renderPosX;
        final double n2 = PenisESP.mc.player.lastTickPosY + (PenisESP.mc.player.posY - PenisESP.mc.player.lastTickPosY) * PenisESP.mc.timer.renderPartialTicks;
        PenisESP.mc.getRenderManager();
        final double lllllllllllllIIlIlIIlIllIIllIlII = n2 - RenderManager.renderPosY;
        final double n3 = PenisESP.mc.player.lastTickPosZ + (PenisESP.mc.player.posZ - PenisESP.mc.player.lastTickPosZ) * PenisESP.mc.timer.renderPartialTicks;
        PenisESP.mc.getRenderManager();
        final double lllllllllllllIIlIlIIlIllIIllIIll = n3 - RenderManager.renderPosZ;
        GlStateManager.pushMatrix();
        GL11.glBlendFunc(770, 771);
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        DrawHelper.enableSmoothLine(2.5f);
        GlStateManager.enableAlpha();
        GL11.glShadeModel(7425);
        GL11.glEnable(2884);
        GL11.glEnable(3042);
        GL11.glEnable(2929);
        GL11.glRotatef(-PenisESP.mc.player.rotationYaw, -0.015f, 1.0f, 0.0f);
        GL11.glTranslated(lllllllllllllIIlIlIIlIllIIllIlIl, lllllllllllllIIlIlIIlIllIIllIlII + PenisESP.mc.player.height / 2.0f - 0.22499999403953552, lllllllllllllIIlIlIIlIllIIllIIll + 0.20000000298023224);
        GL11.glColor4f(1.38f, 0.55f, 2.38f, 1.0f);
        GL11.glRotatef((PenisESP.mc.player.isSneaking() ? 35 : 0) + this.spin, 1.0f + this.spin, 0.0f, this.cumSize);
        final Cylinder lllllllllllllIIlIlIIlIllIIllIIlI = new Cylinder();
        lllllllllllllIIlIlIIlIllIIllIIlI.setDrawStyle(100013);
        lllllllllllllIIlIlIIlIllIIllIIlI.draw(0.1f, 0.11f, 0.4f, 25, 20);
        GL11.glColor4f(1.38f, 0.55f, 2.38f, 1.0f);
        GL11.glTranslated(0.0, 0.0, -0.12500000298023223);
        GL11.glTranslated(-0.09000000074505805, 0.0, 0.0);
        final Sphere lllllllllllllIIlIlIIlIllIIllIIIl = new Sphere();
        lllllllllllllIIlIlIIlIllIIllIIIl.setDrawStyle(100013);
        lllllllllllllIIlIlIIlIllIIllIIIl.draw(0.14f, 10, 20);
        GL11.glTranslated(0.16000000149011612, 0.0, 0.0);
        final Sphere lllllllllllllIIlIlIIlIllIIllIIII = new Sphere();
        lllllllllllllIIlIlIIlIllIIllIIII.setDrawStyle(100013);
        lllllllllllllIIlIlIIlIllIIllIIII.draw(0.14f, 10, 20);
        GL11.glColor4f(1.35f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslated(-0.07000000074505806, 0.0, 0.589999952316284);
        final Sphere lllllllllllllIIlIlIIlIllIIlIllll = new Sphere();
        lllllllllllllIIlIlIIlIllIIlIllll.setDrawStyle(100013);
        lllllllllllllIIlIlIIlIllIIlIllll.draw(0.13f, 15, 20);
        GlStateManager.disableAlpha();
        DrawHelper.disableSmoothLine();
        GL11.glShadeModel(7424);
        GL11.glDisable(2884);
        GL11.glDisable(3042);
        GL11.glDisable(2929);
        GlStateManager.popMatrix();
    }
}
