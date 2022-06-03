// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.event.event.Event3D;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.Vec3d;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import java.util.List;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.features.Feature;

public class JumpCircle extends Feature
{
    public static /* synthetic */ ColorSetting jumpCircleColor;
    private /* synthetic */ ListSetting jumpcircleMode;
    static /* synthetic */ List<Circle> circles;
    
    public JumpCircle() {
        super("JumpCircles", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043a\u0440\u0443\u0433\u0438 \u043f\u043e\u0441\u043b\u0435 \u043f\u0440\u044b\u0436\u043a\u0430", 0, Category.VISUALS);
        this.jumpcircleMode = new ListSetting("JumpCircle Mode", "Default", () -> true, new String[] { "Default", "Rockstar", "Disc" });
        this.addSettings(this.jumpcircleMode, JumpCircle.jumpCircleColor);
    }
    
    @EventTarget
    public void onJump(final EventUpdate lllllllllllIlIlIlIlllIllIlllIlIl) {
        if (JumpCircle.mc.player.motionY == 0.33319999363422365 && !JumpCircle.mc.player.killaurachecks()) {
            handleEntityJump(JumpCircle.mc.player);
        }
        onLocalPlayerUpdate(JumpCircle.mc.player);
    }
    
    public static void handleEntityJump(final Entity lllllllllllIlIlIlIlllIllIIlIIIll) {
        final int lllllllllllIlIlIlIlllIllIIlIIlll = (int)((JumpCircle.jumpCircleColor.getColorValue() >> 16 & 0xFF) / 100.0f);
        final int lllllllllllIlIlIlIlllIllIIlIIllI = (int)((JumpCircle.jumpCircleColor.getColorValue() >> 8 & 0xFF) / 100.0f);
        final int lllllllllllIlIlIlIlllIllIIlIIlIl = (int)((JumpCircle.jumpCircleColor.getColorValue() & 0xFF) / 100.0f);
        final Vec3d lllllllllllIlIlIlIlllIllIIlIIlII = new Vec3d(lllllllllllIlIlIlIlllIllIIlIIlll, lllllllllllIlIlIlIlllIllIIlIIllI, lllllllllllIlIlIlIlllIllIIlIIlIl);
        JumpCircle.circles.add(new Circle(lllllllllllIlIlIlIlllIllIIlIIIll.getPositionVector(), lllllllllllIlIlIlIlllIllIIlIIlII));
    }
    
    public static void onLocalPlayerUpdate(final EntityPlayerSP lllllllllllIlIlIlIlllIllIIlIlllI) {
        JumpCircle.circles.removeIf(Circle::update);
    }
    
    @EventTarget
    public void onRender(final Event3D lllllllllllIlIlIlIlllIllIllIIIII) {
        final String lllllllllllIlIlIlIlllIllIlIlllll = this.jumpcircleMode.getOptions();
        final EntityPlayerSP lllllllllllIlIlIlIlllIllIlIllllI = Minecraft.getMinecraft().player;
        final Minecraft lllllllllllIlIlIlIlllIllIlIlllIl = Minecraft.getMinecraft();
        final double lllllllllllIlIlIlIlllIllIlIlllII = -(lllllllllllIlIlIlIlllIllIlIllllI.lastTickPosX + (lllllllllllIlIlIlIlllIllIlIllllI.posX - lllllllllllIlIlIlIlllIllIlIllllI.lastTickPosX) * lllllllllllIlIlIlIlllIllIlIlllIl.getRenderPartialTicks());
        final double lllllllllllIlIlIlIlllIllIlIllIll = -(lllllllllllIlIlIlIlllIllIlIllllI.lastTickPosY + (lllllllllllIlIlIlIlllIllIlIllllI.posY - lllllllllllIlIlIlIlllIllIlIllllI.lastTickPosY) * lllllllllllIlIlIlIlllIllIlIlllIl.getRenderPartialTicks());
        final double lllllllllllIlIlIlIlllIllIlIllIlI = -(lllllllllllIlIlIlIlllIllIlIllllI.lastTickPosZ + (lllllllllllIlIlIlIlllIllIlIllllI.posZ - lllllllllllIlIlIlIlllIllIlIllllI.lastTickPosZ) * lllllllllllIlIlIlIlllIllIlIlllIl.getRenderPartialTicks());
        if (lllllllllllIlIlIlIlllIllIlIlllll.equalsIgnoreCase("Disc")) {
            GL11.glPushMatrix();
            GL11.glTranslated(lllllllllllIlIlIlIlllIllIlIlllII, lllllllllllIlIlIlIlllIllIlIllIll, lllllllllllIlIlIlIlllIllIlIllIlI);
            GL11.glDisable(2884);
            GL11.glEnable(3042);
            GL11.glDisable(3553);
            GL11.glDisable(3008);
            GL11.glDisable(2929);
            GL11.glBlendFunc(770, 771);
            GL11.glShadeModel(7425);
            Collections.reverse(JumpCircle.circles);
            try {
                for (final Circle lllllllllllIlIlIlIlllIllIlIllIIl : JumpCircle.circles) {
                    final float lllllllllllIlIlIlIlllIllIlIllIII = lllllllllllIlIlIlIlllIllIlIllIIl.existed / 20.0f;
                    final double lllllllllllIlIlIlIlllIllIlIlIlll = lllllllllllIlIlIlIlllIllIlIllIIl.position().xCoord;
                    final double lllllllllllIlIlIlIlllIllIlIlIllI = lllllllllllIlIlIlIlllIllIlIllIIl.position().yCoord - lllllllllllIlIlIlIlllIllIlIllIII * 0.5;
                    final double lllllllllllIlIlIlIlllIllIlIlIlIl = lllllllllllIlIlIlIlllIllIlIllIIl.position().zCoord;
                    final float lllllllllllIlIlIlIlllIllIlIlIlII = lllllllllllIlIlIlIlllIllIlIllIII;
                    final float lllllllllllIlIlIlIlllIllIlIlIIll = lllllllllllIlIlIlIlllIllIlIlIlII + 1.0f - lllllllllllIlIlIlIlllIllIlIllIII;
                    GL11.glBegin(8);
                    for (int lllllllllllIlIlIlIlllIllIlIlIIlI = 0; lllllllllllIlIlIlIlllIllIlIlIIlI <= 360; lllllllllllIlIlIlIlllIllIlIlIIlI += 5) {
                        GL11.glColor4f((float)lllllllllllIlIlIlIlllIllIlIllIIl.color().xCoord, (float)lllllllllllIlIlIlIlllIllIlIllIIl.color().yCoord, (float)lllllllllllIlIlIlIlllIllIlIllIIl.color().zCoord, 0.2f * (1.0f - lllllllllllIlIlIlIlllIllIlIllIIl.existed / 20.0f));
                        GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIlIlll + Math.cos(Math.toRadians(lllllllllllIlIlIlIlllIllIlIlIIlI * 4)) * lllllllllllIlIlIlIlllIllIlIlIlII, lllllllllllIlIlIlIlllIllIlIlIllI, lllllllllllIlIlIlIlllIllIlIlIlIl + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIlIIlI * 4)) * lllllllllllIlIlIlIlllIllIlIlIlII);
                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.01f * (1.0f - lllllllllllIlIlIlIlllIllIlIllIIl.existed / 20.0f));
                        GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIlIlll + Math.cos(Math.toRadians(lllllllllllIlIlIlIlllIllIlIlIIlI)) * lllllllllllIlIlIlIlllIllIlIlIIll, lllllllllllIlIlIlIlllIllIlIlIllI + Math.sin(lllllllllllIlIlIlIlllIllIlIllIII * 8.0f) * 0.5, lllllllllllIlIlIlIlllIllIlIlIlIl + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIlIIlI) * lllllllllllIlIlIlIlllIllIlIlIIll));
                    }
                    GL11.glEnd();
                }
            }
            catch (Exception ex) {}
            Collections.reverse(JumpCircle.circles);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glEnable(2884);
            GL11.glEnable(2929);
            GL11.glEnable(3008);
            GL11.glPopMatrix();
        }
        else if (lllllllllllIlIlIlIlllIllIlIlllll.equalsIgnoreCase("Default")) {
            GL11.glPushMatrix();
            GL11.glTranslated(lllllllllllIlIlIlIlllIllIlIlllII, lllllllllllIlIlIlIlllIllIlIllIll, lllllllllllIlIlIlIlllIllIlIllIlI);
            GL11.glDisable(2884);
            GL11.glEnable(3042);
            GL11.glDisable(3553);
            GL11.glDisable(3008);
            GL11.glBlendFunc(770, 771);
            GL11.glShadeModel(7425);
            Collections.reverse(JumpCircle.circles);
            for (final Circle lllllllllllIlIlIlIlllIllIlIlIIIl : JumpCircle.circles) {
                final double lllllllllllIlIlIlIlllIllIlIlIIII = lllllllllllIlIlIlIlllIllIlIlIIIl.position().xCoord;
                final double lllllllllllIlIlIlIlllIllIlIIllll = lllllllllllIlIlIlIlllIllIlIlIIIl.position().yCoord;
                final double lllllllllllIlIlIlIlllIllIlIIlllI = lllllllllllIlIlIlIlllIllIlIlIIIl.position().zCoord;
                final float lllllllllllIlIlIlIlllIllIlIIllIl = lllllllllllIlIlIlIlllIllIlIlIIIl.existed / 20.0f;
                final float lllllllllllIlIlIlIlllIllIlIIllII = lllllllllllIlIlIlIlllIllIlIIllIl * 2.5f;
                final float lllllllllllIlIlIlIlllIllIlIIlIll = lllllllllllIlIlIlIlllIllIlIIllII + 1.0f - lllllllllllIlIlIlIlllIllIlIIllIl;
                GL11.glBegin(8);
                for (int lllllllllllIlIlIlIlllIllIlIIlIlI = 0; lllllllllllIlIlIlIlllIllIlIIlIlI <= 360; lllllllllllIlIlIlIlllIllIlIIlIlI += 5) {
                    GL11.glColor4f((float)lllllllllllIlIlIlIlllIllIlIlIIIl.color().xCoord, (float)lllllllllllIlIlIlIlllIllIlIlIIIl.color().yCoord, (float)lllllllllllIlIlIlIlllIllIlIlIIIl.color().zCoord, 0.7f * (1.0f - lllllllllllIlIlIlIlllIllIlIlIIIl.existed / 20.0f));
                    switch (false) {
                        case 0: {
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIlIIII + Math.cos(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIlIlI)) * lllllllllllIlIlIlIlllIllIlIIllII, lllllllllllIlIlIlIlllIllIlIIllll, lllllllllllIlIlIlIlllIllIlIIlllI + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIlIlI)) * lllllllllllIlIlIlIlllIllIlIIllII);
                            break;
                        }
                        case 1: {
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIlIIII + Math.cos(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIlIlI * 2)) * lllllllllllIlIlIlIlllIllIlIIllII, lllllllllllIlIlIlIlllIllIlIIllll, lllllllllllIlIlIlIlllIllIlIIlllI + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIlIlI * 2)) * lllllllllllIlIlIlIlllIllIlIIllII);
                            break;
                        }
                    }
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.01f * (1.0f - lllllllllllIlIlIlIlllIllIlIlIIIl.existed / 20.0f));
                    switch (false) {
                        case 0: {
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIlIIII + Math.cos(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIlIlI)) * lllllllllllIlIlIlIlllIllIlIIlIll, lllllllllllIlIlIlIlllIllIlIIllll, lllllllllllIlIlIlIlllIllIlIIlllI + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIlIlI)) * lllllllllllIlIlIlIlllIllIlIIlIll);
                            break;
                        }
                        case 1: {
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIlIIII + Math.cos(Math.toRadians(-lllllllllllIlIlIlIlllIllIlIIlIlI)) * lllllllllllIlIlIlIlllIllIlIIlIll, lllllllllllIlIlIlIlllIllIlIIllll, lllllllllllIlIlIlIlllIllIlIIlllI + Math.sin(Math.toRadians(-lllllllllllIlIlIlIlllIllIlIIlIlI)) * lllllllllllIlIlIlIlllIllIlIIlIll);
                            break;
                        }
                    }
                }
                GL11.glEnd();
            }
            Collections.reverse(JumpCircle.circles);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glEnable(2884);
            GL11.glEnable(3008);
            GL11.glPopMatrix();
        }
        else if (lllllllllllIlIlIlIlllIllIlIlllll.equalsIgnoreCase("Rockstar")) {
            GL11.glPushMatrix();
            GL11.glTranslated(lllllllllllIlIlIlIlllIllIlIlllII, lllllllllllIlIlIlIlllIllIlIllIll, lllllllllllIlIlIlIlllIllIlIllIlI);
            GL11.glDisable(2884);
            GL11.glEnable(3042);
            GL11.glDisable(3553);
            GL11.glDisable(3008);
            GL11.glBlendFunc(770, 771);
            GL11.glShadeModel(7425);
            Collections.reverse(JumpCircle.circles);
            for (final Circle lllllllllllIlIlIlIlllIllIlIIlIIl : JumpCircle.circles) {
                final double lllllllllllIlIlIlIlllIllIlIIlIII = lllllllllllIlIlIlIlllIllIlIIlIIl.position().xCoord;
                final double lllllllllllIlIlIlIlllIllIlIIIlll = lllllllllllIlIlIlIlllIllIlIIlIIl.position().yCoord;
                final double lllllllllllIlIlIlIlllIllIlIIIllI = lllllllllllIlIlIlIlllIllIlIIlIIl.position().zCoord;
                final float lllllllllllIlIlIlIlllIllIlIIIlIl = lllllllllllIlIlIlIlllIllIlIIlIIl.existed / 20.0f;
                final float lllllllllllIlIlIlIlllIllIlIIIlII = lllllllllllIlIlIlIlllIllIlIIIlIl * 2.5f;
                final float lllllllllllIlIlIlIlllIllIlIIIIll = lllllllllllIlIlIlIlllIllIlIIIlII + 1.0f - lllllllllllIlIlIlIlllIllIlIIIlIl;
                GL11.glBegin(8);
                for (int lllllllllllIlIlIlIlllIllIlIIIIlI = 0; lllllllllllIlIlIlIlllIllIlIIIIlI <= 360; lllllllllllIlIlIlIlllIllIlIIIIlI += 5) {
                    GL11.glColor4f((float)lllllllllllIlIlIlIlllIllIlIIlIIl.color().xCoord, (float)lllllllllllIlIlIlIlllIllIlIIlIIl.color().yCoord, (float)lllllllllllIlIlIlIlllIllIlIIlIIl.color().zCoord, 0.7f * (1.0f - lllllllllllIlIlIlIlllIllIlIIlIIl.existed / 20.0f));
                    switch (false) {
                        case 0: {
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIIlIII + Math.cos(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIlII, lllllllllllIlIlIlIlllIllIlIIIlll, lllllllllllIlIlIlIlllIllIlIIIllI + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIlII);
                            break;
                        }
                        case 1: {
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIIlIII + Math.cos(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIIIlI * 2)) * lllllllllllIlIlIlIlllIllIlIIIlII, lllllllllllIlIlIlIlllIllIlIIIlll, lllllllllllIlIlIlIlllIllIlIIIllI + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIIIlI * 2)) * lllllllllllIlIlIlIlllIllIlIIIlII);
                            break;
                        }
                    }
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.01f * (1.0f - lllllllllllIlIlIlIlllIllIlIIlIIl.existed / 20.0f));
                    switch (false) {
                        case 0: {
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIIlIII + Math.cos(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIIll, lllllllllllIlIlIlIlllIllIlIIIlll, lllllllllllIlIlIlIlllIllIlIIIllI + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIIll);
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIIlIII + Math.cos(Math.toRadians(-lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIIll, lllllllllllIlIlIlIlllIllIlIIIlll, lllllllllllIlIlIlIlllIllIlIIIllI + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIIll);
                            break;
                        }
                        case 1: {
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIIlIII + Math.cos(Math.toRadians(-lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIIll, lllllllllllIlIlIlIlllIllIlIIIlll, lllllllllllIlIlIlIlllIllIlIIIllI + Math.sin(Math.toRadians(-lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIIll);
                            GL11.glVertex3d(lllllllllllIlIlIlIlllIllIlIIlIII + Math.cos(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIIll, lllllllllllIlIlIlIlllIllIlIIIlll, lllllllllllIlIlIlIlllIllIlIIIllI + Math.sin(Math.toRadians(lllllllllllIlIlIlIlllIllIlIIIIlI)) * lllllllllllIlIlIlIlllIllIlIIIIll);
                            break;
                        }
                    }
                }
                GL11.glEnd();
            }
            Collections.reverse(JumpCircle.circles);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glEnable(2884);
            GL11.glEnable(3008);
            GL11.glPopMatrix();
        }
    }
    
    static {
        TYPE = 0;
        MAX_JC_TIME = 20;
        JumpCircle.circles = new ArrayList<Circle>();
        JumpCircle.jumpCircleColor = new ColorSetting("JumpCircle Color", new Color(16777215).getRGB(), () -> true);
    }
    
    static class Circle
    {
        /* synthetic */ byte existed;
        private final /* synthetic */ Vec3d vec;
        private final /* synthetic */ Vec3d color;
        
        Vec3d position() {
            return this.vec;
        }
        
        Vec3d color() {
            return this.color;
        }
        
        Circle(final Vec3d lllllllllllIlllllllIIlIlIlllIIIl, final Vec3d lllllllllllIlllllllIIlIlIllIllIl) {
            this.vec = lllllllllllIlllllllIIlIlIlllIIIl;
            this.color = lllllllllllIlllllllIIlIlIllIllIl;
        }
        
        boolean update() {
            final byte existed = (byte)(this.existed + 1);
            this.existed = existed;
            return existed > 20;
        }
    }
}
