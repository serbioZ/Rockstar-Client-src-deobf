// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import java.awt.Color;
import net.minecraft.util.math.Vec3d;
import ru.rockstar.api.utils.render.DrawHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class PearlESP extends Feature
{
    public /* synthetic */ BooleanSetting tracers;
    public /* synthetic */ BooleanSetting esp;
    
    @EventTarget
    public void onRender3D(final Event3D lllllllllllIIlllIIlllIlllIlIlIll) {
        GlStateManager.pushMatrix();
        for (final Entity lllllllllllIIlllIIlllIlllIllIIlI : PearlESP.mc.world.loadedEntityList) {
            if (lllllllllllIIlllIIlllIlllIllIIlI instanceof EntityEnderPearl) {
                final boolean lllllllllllIIlllIIlllIlllIllIIIl = PearlESP.mc.gameSettings.viewBobbing;
                PearlESP.mc.gameSettings.viewBobbing = false;
                PearlESP.mc.entityRenderer.setupCameraTransform(lllllllllllIIlllIIlllIlllIlIlIll.getPartialTicks(), 0);
                PearlESP.mc.gameSettings.viewBobbing = lllllllllllIIlllIIlllIlllIllIIIl;
                if (this.tracers.getBoolValue()) {
                    GL11.glPushMatrix();
                    GL11.glEnable(2848);
                    GL11.glDisable(2929);
                    GL11.glDisable(3553);
                    GL11.glDisable(2896);
                    GL11.glDepthMask(false);
                    GL11.glBlendFunc(770, 771);
                    GL11.glEnable(3042);
                    GL11.glLineWidth(1.0f);
                    final double n = lllllllllllIIlllIIlllIlllIllIIlI.lastTickPosX + (lllllllllllIIlllIIlllIlllIllIIlI.posX - lllllllllllIIlllIIlllIlllIllIIlI.lastTickPosX) * lllllllllllIIlllIIlllIlllIlIlIll.getPartialTicks();
                    PearlESP.mc.getRenderManager();
                    final double lllllllllllIIlllIIlllIlllIllIIII = n - RenderManager.renderPosX;
                    final double n2 = lllllllllllIIlllIIlllIlllIllIIlI.lastTickPosY + (lllllllllllIIlllIIlllIlllIllIIlI.posY - lllllllllllIIlllIIlllIlllIllIIlI.lastTickPosY) * lllllllllllIIlllIIlllIlllIlIlIll.getPartialTicks();
                    PearlESP.mc.getRenderManager();
                    final double lllllllllllIIlllIIlllIlllIlIllll = n2 - RenderManager.renderPosY - 1.0;
                    final double n3 = lllllllllllIIlllIIlllIlllIllIIlI.lastTickPosZ + (lllllllllllIIlllIIlllIlllIllIIlI.posZ - lllllllllllIIlllIIlllIlllIllIIlI.lastTickPosZ) * lllllllllllIIlllIIlllIlllIlIlIll.getPartialTicks();
                    PearlESP.mc.getRenderManager();
                    final double lllllllllllIIlllIIlllIlllIlIlllI = n3 - RenderManager.renderPosZ;
                    DrawHelper.setColor(-1);
                    final Vec3d lllllllllllIIlllIIlllIlllIlIllIl = new Vec3d(0.0, 0.0, 1.0).rotatePitch((float)(-Math.toRadians(PearlESP.mc.player.rotationPitch))).rotateYaw((float)(-Math.toRadians(PearlESP.mc.player.rotationYaw)));
                    GL11.glBegin(2);
                    GL11.glVertex3d(lllllllllllIIlllIIlllIlllIlIllIl.xCoord, PearlESP.mc.player.getEyeHeight() + lllllllllllIIlllIIlllIlllIlIllIl.yCoord, lllllllllllIIlllIIlllIlllIlIllIl.zCoord);
                    GL11.glVertex3d(lllllllllllIIlllIIlllIlllIllIIII, lllllllllllIIlllIIlllIlllIlIllll + 1.1, lllllllllllIIlllIIlllIlllIlIlllI);
                    GL11.glEnd();
                    GL11.glDisable(3042);
                    GL11.glDepthMask(true);
                    GL11.glEnable(3553);
                    GL11.glEnable(2929);
                    GL11.glDisable(2848);
                    GL11.glPopMatrix();
                }
                if (!this.esp.getBoolValue()) {
                    continue;
                }
                DrawHelper.drawEntityBox(lllllllllllIIlllIIlllIlllIllIIlI, Color.WHITE, true, 0.2f);
            }
        }
        GlStateManager.popMatrix();
    }
    
    public PearlESP() {
        super("PearlESP", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0435\u0441\u043f \u043f\u0435\u0440\u043b\u0430", 0, Category.VISUALS);
        this.tracers = new BooleanSetting("Tracers", true, () -> true);
        this.esp = new BooleanSetting("ESP", true, () -> true);
        this.addSettings(this.esp, this.tracers);
    }
}
