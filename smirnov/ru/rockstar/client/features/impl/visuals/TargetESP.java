// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import java.awt.Color;
import ru.rockstar.api.utils.render.ClientHelper;
import org.lwjgl.util.glu.Cylinder;
import ru.rockstar.api.utils.render.DrawHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.Main;
import net.minecraft.entity.Entity;
import ru.rockstar.client.features.impl.combat.KillAura;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class TargetESP extends Feature
{
    /* synthetic */ boolean animat;
    public /* synthetic */ BooleanSetting depthTest;
    /* synthetic */ double height;
    public /* synthetic */ NumberSetting circlesize;
    public /* synthetic */ ListSetting bebraPonyxana;
    
    @EventTarget
    public void jija(final Event3D lllllllllllIlIllIIlIllIIllIllIIl) {
        final String lllllllllllIlIllIIlIllIIllIllIII = this.bebraPonyxana.getOptions();
        this.setModuleName("TargetESP " + ChatFormatting.GRAY + lllllllllllIlIllIIlIllIIllIllIII);
        if (KillAura.target != null && KillAura.target.getHealth() > 0.0 && TargetESP.mc.player.getDistanceToEntity(KillAura.target) <= KillAura.range.getNumberValue() && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled()) {
            if (lllllllllllIlIllIIlIllIIllIllIII.equalsIgnoreCase("Sims")) {
                final float lllllllllllIlIllIIlIllIIllIlIlll = 0.2f;
                final int lllllllllllIlIllIIlIllIIllIlIllI = 4;
                if (this.animat) {
                    this.height = MathHelper.lerp(this.height, 0.4, 2.0 * Feature.deltaTime());
                    if (this.height > 0.39) {
                        this.animat = false;
                    }
                }
                else {
                    this.height = MathHelper.lerp(this.height, 0.1, 4.0 * Feature.deltaTime());
                    if (this.height < 0.11) {
                        this.animat = true;
                    }
                }
                GL11.glPushMatrix();
                GL11.glTranslated(KillAura.target.lastTickPosX + (KillAura.target.posX - KillAura.target.lastTickPosX) * lllllllllllIlIllIIlIllIIllIllIIl.getPartialTicks() - TargetESP.mc.renderManager.viewerPosX, KillAura.target.lastTickPosY + (KillAura.target.posY - KillAura.target.lastTickPosY) * lllllllllllIlIllIIlIllIIllIllIIl.getPartialTicks() - TargetESP.mc.renderManager.viewerPosY + KillAura.target.height + this.height, KillAura.target.lastTickPosZ + (KillAura.target.posZ - KillAura.target.lastTickPosZ) * lllllllllllIlIllIIlIllIIllIllIIl.getPartialTicks() - TargetESP.mc.renderManager.viewerPosZ);
                GL11.glRotatef((TargetESP.mc.player.ticksExisted + TargetESP.mc.timer.renderPartialTicks) * 10.0f, 0.0f, 1.0f, 0.0f);
                DrawHelper.enableSmoothLine(0.5f);
                final Cylinder lllllllllllIlIllIIlIllIIllIlIlIl = new Cylinder();
                lllllllllllIlIllIIlIllIIllIlIlIl.setDrawStyle(100011);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                lllllllllllIlIllIIlIllIIllIlIlIl.draw(0.0f, lllllllllllIlIllIIlIllIIllIlIlll, 0.3f, lllllllllllIlIllIIlIllIIllIlIllI, 100);
                GL11.glTranslated(0.0, 0.0, 0.3);
                lllllllllllIlIllIIlIllIIllIlIlIl.draw(lllllllllllIlIllIIlIllIIllIlIlll, 0.0f, 0.3f, lllllllllllIlIllIIlIllIIllIlIllI, 100);
                DrawHelper.disableSmoothLine();
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glPopMatrix();
            }
            if (lllllllllllIlIllIIlIllIIllIllIII.equalsIgnoreCase("Jello")) {
                final double lllllllllllIlIllIIlIllIIllIlIlII = 1500.0;
                final double lllllllllllIlIllIIlIllIIllIlIIll = System.currentTimeMillis() % lllllllllllIlIllIIlIllIIllIlIlII;
                final boolean lllllllllllIlIllIIlIllIIllIlIIlI = lllllllllllIlIllIIlIllIIllIlIIll > lllllllllllIlIllIIlIllIIllIlIlII / 2.0;
                double lllllllllllIlIllIIlIllIIllIlIIIl = lllllllllllIlIllIIlIllIIllIlIIll / (lllllllllllIlIllIIlIllIIllIlIlII / 2.0);
                if (!lllllllllllIlIllIIlIllIIllIlIIlI) {
                    lllllllllllIlIllIIlIllIIllIlIIIl = 1.0 - lllllllllllIlIllIIlIllIIllIlIIIl;
                }
                else {
                    --lllllllllllIlIllIIlIllIIllIlIIIl;
                }
                lllllllllllIlIllIIlIllIIllIlIIIl = MathHelper.easeInOutQuad(lllllllllllIlIllIIlIllIIllIlIIIl, 2);
                TargetESP.mc.entityRenderer.disableLightmap();
                GL11.glPushMatrix();
                GL11.glDisable(3553);
                GL11.glBlendFunc(770, 771);
                GL11.glEnable(2848);
                GL11.glEnable(3042);
                if (this.depthTest.getBoolValue()) {
                    GL11.glDisable(2929);
                }
                GL11.glDisable(2884);
                GL11.glShadeModel(7425);
                TargetESP.mc.entityRenderer.disableLightmap();
                final double lllllllllllIlIllIIlIllIIllIlIIII = this.circlesize.getNumberValue();
                final double lllllllllllIlIllIIlIllIIllIIllll = KillAura.target.height + 0.1;
                final double lllllllllllIlIllIIlIllIIllIIlllI = KillAura.target.lastTickPosX + (KillAura.target.posX - KillAura.target.lastTickPosX) * lllllllllllIlIllIIlIllIIllIllIIl.getPartialTicks() - TargetESP.mc.renderManager.viewerPosX;
                final double lllllllllllIlIllIIlIllIIllIIllIl = KillAura.target.lastTickPosY + (KillAura.target.posY - KillAura.target.lastTickPosY) * lllllllllllIlIllIIlIllIIllIllIIl.getPartialTicks() - TargetESP.mc.renderManager.viewerPosY + lllllllllllIlIllIIlIllIIllIIllll * lllllllllllIlIllIIlIllIIllIlIIIl;
                final double lllllllllllIlIllIIlIllIIllIIllII = KillAura.target.lastTickPosZ + (KillAura.target.posZ - KillAura.target.lastTickPosZ) * lllllllllllIlIllIIlIllIIllIllIIl.getPartialTicks() - TargetESP.mc.renderManager.viewerPosZ;
                final double lllllllllllIlIllIIlIllIIllIIlIll = lllllllllllIlIllIIlIllIIllIIllll / 3.0 * ((lllllllllllIlIllIIlIllIIllIlIIIl > 0.5) ? (1.0 - lllllllllllIlIllIIlIllIIllIlIIIl) : lllllllllllIlIllIIlIllIIllIlIIIl) * (lllllllllllIlIllIIlIllIIllIlIIlI ? -1 : 1);
                for (int lllllllllllIlIllIIlIllIIllIIlIlI = 0; lllllllllllIlIllIIlIllIIllIIlIlI < 360; lllllllllllIlIllIIlIllIIllIIlIlI += 5) {
                    final Color lllllllllllIlIllIIlIllIIllIIlIIl = ClientHelper.getClientColor(5.0f, (float)lllllllllllIlIllIIlIllIIllIIlIlI, 5);
                    final double lllllllllllIlIllIIlIllIIllIIlIII = lllllllllllIlIllIIlIllIIllIIlllI - Math.sin(lllllllllllIlIllIIlIllIIllIIlIlI * 3.141592653589793 / 180.0) * lllllllllllIlIllIIlIllIIllIlIIII;
                    final double lllllllllllIlIllIIlIllIIllIIIlll = lllllllllllIlIllIIlIllIIllIIllII + Math.cos(lllllllllllIlIllIIlIllIIllIIlIlI * 3.141592653589793 / 180.0) * lllllllllllIlIllIIlIllIIllIlIIII;
                    final double lllllllllllIlIllIIlIllIIllIIIllI = lllllllllllIlIllIIlIllIIllIIlllI - Math.sin((lllllllllllIlIllIIlIllIIllIIlIlI - 5) * 3.141592653589793 / 180.0) * lllllllllllIlIllIIlIllIIllIlIIII;
                    final double lllllllllllIlIllIIlIllIIllIIIlIl = lllllllllllIlIllIIlIllIIllIIllII + Math.cos((lllllllllllIlIllIIlIllIIllIIlIlI - 5) * 3.141592653589793 / 180.0) * lllllllllllIlIllIIlIllIIllIlIIII;
                    GL11.glBegin(7);
                    DrawHelper.glColor(lllllllllllIlIllIIlIllIIllIIlIIl, 0.0f);
                    GL11.glVertex3d(lllllllllllIlIllIIlIllIIllIIlIII, lllllllllllIlIllIIlIllIIllIIllIl + lllllllllllIlIllIIlIllIIllIIlIll, lllllllllllIlIllIIlIllIIllIIIlll);
                    GL11.glVertex3d(lllllllllllIlIllIIlIllIIllIIIllI, lllllllllllIlIllIIlIllIIllIIllIl + lllllllllllIlIllIIlIllIIllIIlIll, lllllllllllIlIllIIlIllIIllIIIlIl);
                    DrawHelper.glColor(lllllllllllIlIllIIlIllIIllIIlIIl, 255);
                    GL11.glVertex3d(lllllllllllIlIllIIlIllIIllIIIllI, lllllllllllIlIllIIlIllIIllIIllIl, lllllllllllIlIllIIlIllIIllIIIlIl);
                    GL11.glVertex3d(lllllllllllIlIllIIlIllIIllIIlIII, lllllllllllIlIllIIlIllIIllIIllIl, lllllllllllIlIllIIlIllIIllIIIlll);
                    GL11.glEnd();
                    GL11.glBegin(2);
                    GL11.glVertex3d(lllllllllllIlIllIIlIllIIllIIIllI, lllllllllllIlIllIIlIllIIllIIllIl, lllllllllllIlIllIIlIllIIllIIIlIl);
                    GL11.glVertex3d(lllllllllllIlIllIIlIllIIllIIlIII, lllllllllllIlIllIIlIllIIllIIllIl, lllllllllllIlIllIIlIllIIllIIIlll);
                    GL11.glEnd();
                }
                GL11.glEnable(2884);
                GL11.glShadeModel(7424);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                if (this.depthTest.getBoolValue()) {
                    GL11.glEnable(2929);
                }
                GL11.glDisable(2848);
                GL11.glDisable(3042);
                GL11.glEnable(3553);
                GL11.glPopMatrix();
            }
        }
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
    }
    
    public TargetESP() {
        super("TargetESP", "\u0420\u0438\u0441\u0443\u0435\u0442 \u043a\u0440\u0430\u0441\u0438\u0432\u044b\u0439 \u043a\u0440\u0443\u0433 \u043d\u0430 \u044d\u043d\u0442\u0438\u0442\u0438", 0, Category.DISPLAY);
        this.bebraPonyxana = new ListSetting("TargetESP Mode", "Jello", () -> true, new String[] { "Jello", "Sims" });
        this.circlesize = new NumberSetting("Circle Size", "\u0420\u0430\u0437\u043c\u0435\u0440 \u043a\u0440\u0443\u0433\u0430", 0.4f, 0.1f, 1.0f, 0.1f, () -> this.bebraPonyxana.currentMode.equalsIgnoreCase("Jello"));
        this.depthTest = new BooleanSetting("DepthTest", "\u0413\u043b\u0443\u0431\u0438\u043d\u0430(test)", false, () -> this.bebraPonyxana.currentMode.equalsIgnoreCase("Jello"));
        this.addSettings(this.bebraPonyxana, this.circlesize, this.depthTest);
    }
}
