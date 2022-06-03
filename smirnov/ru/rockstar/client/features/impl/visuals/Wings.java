// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.item.ItemStack;
import ru.rockstar.api.utils.render.ClientHelper;
import java.awt.Color;
import ru.rockstar.api.utils.render.DrawHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemArmor;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class Wings extends Feature
{
    final /* synthetic */ ListSetting colorMode;
    final /* synthetic */ ColorSetting onecolor;
    final /* synthetic */ ColorSetting twocolor;
    final /* synthetic */ NumberSetting saturation;
    
    @EventTarget
    public void onRender3D(final Event3D lllllllllllIIIIIIlIlllIIIlIIllII) {
        final ItemStack lllllllllllIIIIIIlIlllIIIlIIlIll = Wings.mc.player.getEquipmentInSlot(4);
        final double lllllllllllIIIIIIlIlllIIIlIIlIlI = (lllllllllllIIIIIIlIlllIIIlIIlIll.getItem() instanceof ItemArmor) ? (Wings.mc.player.isSneaking() ? -0.1 : 0.12) : (Wings.mc.player.isSneaking() ? -0.22 : 0.0);
        if (Wings.mc.gameSettings.thirdPersonView == 1 || Wings.mc.gameSettings.thirdPersonView == 2) {
            GlStateManager.pushMatrix();
            GL11.glBlendFunc(770, 771);
            GlStateManager.disableDepth();
            GlStateManager.disableTexture2D();
            DrawHelper.enableSmoothLine(2.5f);
            GL11.glShadeModel(7425);
            GL11.glDisable(2884);
            GL11.glEnable(3042);
            GL11.glEnable(2929);
            GL11.glRotatef(-Wings.mc.player.rotationYaw, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef((float)(Wings.mc.player.isSneaking() ? 12 : 0), 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.0f, (float)(Wings.mc.player.height + lllllllllllIIIIIIlIlllIIIlIIlIlI - 1.0), -0.3f);
            Color lllllllllllIIIIIIlIlllIIIlIIlIIl = Color.WHITE;
            final Color lllllllllllIIIIIIlIlllIIIlIIlIII = new Color(this.onecolor.getColorValue());
            final String lllllllllllIIIIIIlIlllIIIlIIIlll = this.colorMode.currentMode;
            byte lllllllllllIIIIIIlIlllIIIlIIIllI = -1;
            switch (lllllllllllIIIIIIlIlllIIIlIIIlll.hashCode()) {
                case -1808614770: {
                    if (lllllllllllIIIIIIlIlllIIIlIIIlll.equals("Static")) {
                        lllllllllllIIIIIIlIlllIIIlIIIllI = 4;
                        break;
                    }
                    break;
                }
                case 77474681: {
                    if (lllllllllllIIIIIIlIlllIIIlIIIlll.equals("Pulse")) {
                        lllllllllllIIIIIIlIlllIIIlIIIllI = 2;
                        break;
                    }
                    break;
                }
                case 961091784: {
                    if (lllllllllllIIIIIIlIlllIIIlIIIlll.equals("Astolfo")) {
                        lllllllllllIIIIIIlIlllIIIlIIIllI = 1;
                        break;
                    }
                    break;
                }
                case 2021122027: {
                    if (lllllllllllIIIIIIlIlllIIIlIIIlll.equals("Client")) {
                        lllllllllllIIIIIIlIlllIIIlIIIllI = 0;
                        break;
                    }
                    break;
                }
                case 2029746065: {
                    if (lllllllllllIIIIIIlIlllIIIlIIIlll.equals("Custom")) {
                        lllllllllllIIIIIIlIlllIIIlIIIllI = 3;
                        break;
                    }
                    break;
                }
            }
            switch (lllllllllllIIIIIIlIlllIIIlIIIllI) {
                case 0: {
                    lllllllllllIIIIIIlIlllIIIlIIlIIl = ClientHelper.getClientColor(5.0f, 1.0f, 5);
                    break;
                }
                case 1: {
                    lllllllllllIIIIIIlIlllIIIlIIlIIl = DrawHelper.astolfoColors45(5.0f, 5.0f, this.saturation.getNumberValue(), 10.0f);
                    break;
                }
                case 2: {
                    lllllllllllIIIIIIlIlllIIIlIIlIIl = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.0);
                    break;
                }
                case 3: {
                    lllllllllllIIIIIIlIlllIIIlIIlIIl = DrawHelper.TwoColoreffect(new Color(this.onecolor.getColorValue()), new Color(this.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.0);
                    break;
                }
                case 4: {
                    lllllllllllIIIIIIlIlllIIIlIIlIIl = lllllllllllIIIIIIlIlllIIIlIIlIII;
                    break;
                }
            }
            GL11.glBegin(6);
            DrawHelper.glColor(lllllllllllIIIIIIlIlllIIIlIIlIIl, 255);
            GL11.glVertex3d(0.0, 0.3, 0.0);
            GL11.glVertex3d(0.0, 0.3, 0.0);
            GL11.glEnd();
            GL11.glBegin(2);
            for (float lllllllllllIIIIIIlIlllIIIlIIIIlI = 0.0f; lllllllllllIIIIIIlIlllIIIlIIIIlI < 360.5; ++lllllllllllIIIIIIlIlllIIIlIIIIlI) {
                Color lllllllllllIIIIIIlIlllIIIlIIIIIl = Color.WHITE;
                final Color lllllllllllIIIIIIlIlllIIIlIIIlIl = new Color(this.onecolor.getColorValue());
                final String lllllllllllIIIIIIlIlllIIIlIIIlII = this.colorMode.currentMode;
                byte lllllllllllIIIIIIlIlllIIIlIIIIll = -1;
                switch (lllllllllllIIIIIIlIlllIIIlIIIlII.hashCode()) {
                    case -1808614770: {
                        if (lllllllllllIIIIIIlIlllIIIlIIIlII.equals("Static")) {
                            lllllllllllIIIIIIlIlllIIIlIIIIll = 4;
                            break;
                        }
                        break;
                    }
                    case 77474681: {
                        if (lllllllllllIIIIIIlIlllIIIlIIIlII.equals("Pulse")) {
                            lllllllllllIIIIIIlIlllIIIlIIIIll = 2;
                            break;
                        }
                        break;
                    }
                    case 961091784: {
                        if (lllllllllllIIIIIIlIlllIIIlIIIlII.equals("Astolfo")) {
                            lllllllllllIIIIIIlIlllIIIlIIIIll = 1;
                            break;
                        }
                        break;
                    }
                    case 2021122027: {
                        if (lllllllllllIIIIIIlIlllIIIlIIIlII.equals("Client")) {
                            lllllllllllIIIIIIlIlllIIIlIIIIll = 0;
                            break;
                        }
                        break;
                    }
                    case 2029746065: {
                        if (lllllllllllIIIIIIlIlllIIIlIIIlII.equals("Custom")) {
                            lllllllllllIIIIIIlIlllIIIlIIIIll = 3;
                            break;
                        }
                        break;
                    }
                }
                switch (lllllllllllIIIIIIlIlllIIIlIIIIll) {
                    case 0: {
                        lllllllllllIIIIIIlIlllIIIlIIIIIl = ClientHelper.getClientColor(5.0f, lllllllllllIIIIIIlIlllIIIlIIIIlI, 5);
                        break;
                    }
                    case 1: {
                        lllllllllllIIIIIIlIlllIIIlIIIIIl = DrawHelper.astolfoColors45(lllllllllllIIIIIIlIlllIIIlIIIIlI - lllllllllllIIIIIIlIlllIIIlIIIIlI + 1.0f, lllllllllllIIIIIIlIlllIIIlIIIIlI, this.saturation.getNumberValue(), 10.0f);
                        break;
                    }
                    case 2: {
                        lllllllllllIIIIIIlIlllIIIlIIIIIl = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0f * (lllllllllllIIIIIIlIlllIIIlIIIIlI / 16.0f) / 60.0f);
                        break;
                    }
                    case 3: {
                        lllllllllllIIIIIIlIlllIIIlIIIIIl = DrawHelper.TwoColoreffect(new Color(this.onecolor.getColorValue()), new Color(this.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 3.0f * (lllllllllllIIIIIIlIlllIIIlIIIIlI / 16.0f) / 60.0f);
                        break;
                    }
                    case 4: {
                        lllllllllllIIIIIIlIlllIIIlIIIIIl = lllllllllllIIIIIIlIlllIIIlIIIlIl;
                        break;
                    }
                }
                DrawHelper.glColor(lllllllllllIIIIIIlIlllIIIlIIIIIl, 255);
                GL11.glVertex3d(Math.cos(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 1.2, 0.6, Math.sin(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 0.01);
                GL11.glVertex3d(Math.cos(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 2.0, 0.5, Math.sin(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 0.01);
                GL11.glVertex3d(Math.cos(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 1.9, 0.3, Math.sin(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 0.01);
                GL11.glVertex3d(Math.cos(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 1.8, 0.2, Math.sin(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 0.01);
                GL11.glVertex3d(Math.cos(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 1.6, 0.1, Math.sin(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 0.01);
                GL11.glVertex3d(Math.cos(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 0.5, 0.0, Math.sin(lllllllllllIIIIIIlIlllIIIlIIIIlI * 2.0) * 0.01);
            }
            GL11.glEnd();
            GlStateManager.enableAlpha();
            DrawHelper.disableSmoothLine();
            GL11.glShadeModel(7424);
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            GlStateManager.resetColor();
            GlStateManager.popMatrix();
        }
    }
    
    public Wings() {
        super("Wings", "\u0422\u044b - \u0430\u043d\u0433\u0435\u043b", 0, Category.VISUALS);
        this.colorMode = new ListSetting("Trails Color", "Astolfo", () -> true, new String[] { "Astolfo", "Pulse", "Custom", "Client", "Static" });
        this.onecolor = new ColorSetting("One Color", new Color(255, 255, 255).getRGB(), () -> {
            if (!this.colorMode.currentMode.equalsIgnoreCase("Static") && !this.colorMode.currentMode.equalsIgnoreCase("Custom")) {
                return Boolean.valueOf(false);
            }
            else {
                return Boolean.valueOf(true);
            }
        });
        this.twocolor = new ColorSetting("Two Color", new Color(255, 255, 255).getRGB(), () -> this.colorMode.currentMode.equalsIgnoreCase("Custom"));
        this.saturation = new NumberSetting("Saturation", 0.7f, 0.1f, 1.0f, 0.1f, () -> this.colorMode.currentMode.equalsIgnoreCase("Astolfo"));
        this.addSettings(this.colorMode, this.onecolor, this.twocolor, this.saturation);
    }
}
