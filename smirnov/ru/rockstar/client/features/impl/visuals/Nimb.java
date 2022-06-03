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
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class Nimb extends Feature
{
    final /* synthetic */ ListSetting colorMode;
    final /* synthetic */ NumberSetting saturation;
    final /* synthetic */ ColorSetting twocolor;
    final /* synthetic */ ColorSetting onecolor;
    
    @EventTarget
    public void asf(final Event3D lllllllllllllllIlIllllIlIlllIllI) {
        final ItemStack lllllllllllllllIlIllllIlIlllIlIl = Nimb.mc.player.getEquipmentInSlot(4);
        final double lllllllllllllllIlIllllIlIlllIlII = (lllllllllllllllIlIllllIlIlllIlIl.getItem() instanceof ItemArmor) ? (Nimb.mc.player.isSneaking() ? -0.1 : 0.12) : (Nimb.mc.player.isSneaking() ? -0.22 : 0.0);
        if (Nimb.mc.gameSettings.thirdPersonView == 1 || Nimb.mc.gameSettings.thirdPersonView == 2) {
            GlStateManager.pushMatrix();
            GL11.glBlendFunc(770, 771);
            GlStateManager.disableDepth();
            GlStateManager.disableTexture2D();
            DrawHelper.enableSmoothLine(2.5f);
            GL11.glShadeModel(7425);
            GL11.glDisable(2884);
            GL11.glEnable(3042);
            GL11.glEnable(2929);
            GL11.glTranslatef(0.0f, (float)(Nimb.mc.player.height + lllllllllllllllIlIllllIlIlllIlII), 0.0f);
            GL11.glRotatef(-Nimb.mc.player.rotationYaw, 0.0f, 1.0f, 0.0f);
            Color lllllllllllllllIlIllllIlIlllIIll = Color.WHITE;
            final Color lllllllllllllllIlIllllIlIlllIIlI = new Color(this.onecolor.getColorValue());
            final String lllllllllllllllIlIllllIlIlllIIIl = this.colorMode.currentMode;
            byte lllllllllllllllIlIllllIlIlllIIII = -1;
            switch (lllllllllllllllIlIllllIlIlllIIIl.hashCode()) {
                case -1808614770: {
                    if (lllllllllllllllIlIllllIlIlllIIIl.equals("Static")) {
                        lllllllllllllllIlIllllIlIlllIIII = 4;
                        break;
                    }
                    break;
                }
                case 77474681: {
                    if (lllllllllllllllIlIllllIlIlllIIIl.equals("Pulse")) {
                        lllllllllllllllIlIllllIlIlllIIII = 2;
                        break;
                    }
                    break;
                }
                case 961091784: {
                    if (lllllllllllllllIlIllllIlIlllIIIl.equals("Astolfo")) {
                        lllllllllllllllIlIllllIlIlllIIII = 1;
                        break;
                    }
                    break;
                }
                case 2021122027: {
                    if (lllllllllllllllIlIllllIlIlllIIIl.equals("Client")) {
                        lllllllllllllllIlIllllIlIlllIIII = 0;
                        break;
                    }
                    break;
                }
                case 2029746065: {
                    if (lllllllllllllllIlIllllIlIlllIIIl.equals("Custom")) {
                        lllllllllllllllIlIllllIlIlllIIII = 3;
                        break;
                    }
                    break;
                }
            }
            switch (lllllllllllllllIlIllllIlIlllIIII) {
                case 0: {
                    lllllllllllllllIlIllllIlIlllIIll = ClientHelper.getClientColor(5.0f, 1.0f, 5);
                    break;
                }
                case 1: {
                    lllllllllllllllIlIllllIlIlllIIll = DrawHelper.astolfoColors45(5.0f, 5.0f, this.saturation.getNumberValue(), 10.0f);
                    break;
                }
                case 2: {
                    lllllllllllllllIlIllllIlIlllIIll = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.0);
                    break;
                }
                case 3: {
                    lllllllllllllllIlIllllIlIlllIIll = DrawHelper.TwoColoreffect(new Color(this.onecolor.getColorValue()), new Color(this.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.0);
                    break;
                }
                case 4: {
                    lllllllllllllllIlIllllIlIlllIIll = lllllllllllllllIlIllllIlIlllIIlI;
                    break;
                }
            }
            GL11.glBegin(6);
            DrawHelper.glColor(lllllllllllllllIlIllllIlIlllIIll, 255);
            GL11.glVertex3d(0.0, 0.3, 0.0);
            for (float lllllllllllllllIlIllllIlIllIlIIl = 0.0f; lllllllllllllllIlIllllIlIllIlIIl < 360.5; ++lllllllllllllllIlIllllIlIllIlIIl) {
                Color lllllllllllllllIlIllllIlIllIlIII = Color.WHITE;
                final Color lllllllllllllllIlIllllIlIllIllll = new Color(this.onecolor.getColorValue());
                final String lllllllllllllllIlIllllIlIllIllIl = this.colorMode.currentMode;
                byte lllllllllllllllIlIllllIlIllIlIll = -1;
                switch (lllllllllllllllIlIllllIlIllIllIl.hashCode()) {
                    case -1808614770: {
                        if (lllllllllllllllIlIllllIlIllIllIl.equals("Static")) {
                            lllllllllllllllIlIllllIlIllIlIll = 4;
                            break;
                        }
                        break;
                    }
                    case 77474681: {
                        if (lllllllllllllllIlIllllIlIllIllIl.equals("Pulse")) {
                            lllllllllllllllIlIllllIlIllIlIll = 2;
                            break;
                        }
                        break;
                    }
                    case 961091784: {
                        if (lllllllllllllllIlIllllIlIllIllIl.equals("Astolfo")) {
                            lllllllllllllllIlIllllIlIllIlIll = 1;
                            break;
                        }
                        break;
                    }
                    case 2021122027: {
                        if (lllllllllllllllIlIllllIlIllIllIl.equals("Client")) {
                            lllllllllllllllIlIllllIlIllIlIll = 0;
                            break;
                        }
                        break;
                    }
                    case 2029746065: {
                        if (lllllllllllllllIlIllllIlIllIllIl.equals("Custom")) {
                            lllllllllllllllIlIllllIlIllIlIll = 3;
                            break;
                        }
                        break;
                    }
                }
                switch (lllllllllllllllIlIllllIlIllIlIll) {
                    case 0: {
                        lllllllllllllllIlIllllIlIllIlIII = ClientHelper.getClientColor(lllllllllllllllIlIllllIlIllIlIIl / 16.0f, lllllllllllllllIlIllllIlIllIlIIl, 5);
                        break;
                    }
                    case 1: {
                        lllllllllllllllIlIllllIlIllIlIII = DrawHelper.astolfoColors45(lllllllllllllllIlIllllIlIllIlIIl - lllllllllllllllIlIllllIlIllIlIIl + 1.0f, lllllllllllllllIlIllllIlIllIlIIl, this.saturation.getNumberValue(), 10.0f);
                        break;
                    }
                    case 2: {
                        lllllllllllllllIlIllllIlIllIlIII = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0f * (lllllllllllllllIlIllllIlIllIlIIl / 16.0f) / 60.0f);
                        break;
                    }
                    case 3: {
                        lllllllllllllllIlIllllIlIllIlIII = DrawHelper.TwoColoreffect(new Color(this.onecolor.getColorValue()), new Color(this.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 3.0f * (lllllllllllllllIlIllllIlIllIlIIl / 16.0f) / 60.0f);
                        break;
                    }
                    case 4: {
                        lllllllllllllllIlIllllIlIllIlIII = lllllllllllllllIlIllllIlIllIllll;
                        break;
                    }
                }
                DrawHelper.glColor(lllllllllllllllIlIllllIlIllIlIII, 255);
            }
            GL11.glVertex3d(0.0, 0.3, 0.0);
            GL11.glEnd();
            GL11.glBegin(2);
            for (float lllllllllllllllIlIllllIlIllIlIIl = 0.0f; lllllllllllllllIlIllllIlIllIlIIl < 360.5; ++lllllllllllllllIlIllllIlIllIlIIl) {
                Color lllllllllllllllIlIllllIlIllIIlll = Color.WHITE;
                final Color lllllllllllllllIlIllllIlIllIlllI = new Color(this.onecolor.getColorValue());
                final String lllllllllllllllIlIllllIlIllIllII = this.colorMode.currentMode;
                byte lllllllllllllllIlIllllIlIllIlIlI = -1;
                switch (lllllllllllllllIlIllllIlIllIllII.hashCode()) {
                    case -1808614770: {
                        if (lllllllllllllllIlIllllIlIllIllII.equals("Static")) {
                            lllllllllllllllIlIllllIlIllIlIlI = 4;
                            break;
                        }
                        break;
                    }
                    case 77474681: {
                        if (lllllllllllllllIlIllllIlIllIllII.equals("Pulse")) {
                            lllllllllllllllIlIllllIlIllIlIlI = 2;
                            break;
                        }
                        break;
                    }
                    case 961091784: {
                        if (lllllllllllllllIlIllllIlIllIllII.equals("Astolfo")) {
                            lllllllllllllllIlIllllIlIllIlIlI = 1;
                            break;
                        }
                        break;
                    }
                    case 2021122027: {
                        if (lllllllllllllllIlIllllIlIllIllII.equals("Client")) {
                            lllllllllllllllIlIllllIlIllIlIlI = 0;
                            break;
                        }
                        break;
                    }
                    case 2029746065: {
                        if (lllllllllllllllIlIllllIlIllIllII.equals("Custom")) {
                            lllllllllllllllIlIllllIlIllIlIlI = 3;
                            break;
                        }
                        break;
                    }
                }
                switch (lllllllllllllllIlIllllIlIllIlIlI) {
                    case 0: {
                        lllllllllllllllIlIllllIlIllIIlll = ClientHelper.getClientColor(5.0f, lllllllllllllllIlIllllIlIllIlIIl, 5);
                        break;
                    }
                    case 1: {
                        lllllllllllllllIlIllllIlIllIIlll = DrawHelper.astolfoColors45(lllllllllllllllIlIllllIlIllIlIIl - lllllllllllllllIlIllllIlIllIlIIl + 1.0f, lllllllllllllllIlIllllIlIllIlIIl, this.saturation.getNumberValue(), 10.0f);
                        break;
                    }
                    case 2: {
                        lllllllllllllllIlIllllIlIllIIlll = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0f * (lllllllllllllllIlIllllIlIllIlIIl / 16.0f) / 60.0f);
                        break;
                    }
                    case 3: {
                        lllllllllllllllIlIllllIlIllIIlll = DrawHelper.TwoColoreffect(new Color(this.onecolor.getColorValue()), new Color(this.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 3.0f * (lllllllllllllllIlIllllIlIllIlIIl / 16.0f) / 60.0f);
                        break;
                    }
                    case 4: {
                        lllllllllllllllIlIllllIlIllIIlll = lllllllllllllllIlIllllIlIllIlllI;
                        break;
                    }
                }
                DrawHelper.glColor(lllllllllllllllIlIllllIlIllIIlll, 255);
                GL11.glVertex3d(Math.cos(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.45, 0.15, Math.sin(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.45);
                GL11.glVertex3d(Math.cos(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.45, 0.13, Math.sin(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.45);
                GL11.glVertex3d(Math.cos(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.45, 0.11, Math.sin(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.45);
                GL11.glVertex3d(Math.cos(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.47, 0.15, Math.sin(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.47);
                GL11.glVertex3d(Math.cos(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.47, 0.13, Math.sin(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.47);
                GL11.glVertex3d(Math.cos(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.47, 0.11, Math.sin(lllllllllllllllIlIllllIlIllIlIIl * 3.141592653589793 / 180.0) * 0.47);
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
    
    public Nimb() {
        super("Nimb", "\u0421\u043e\u0437\u0434\u0430\u0451\u0442 \u043d\u0438\u043c\u0431, \u0442\u044b \u0431\u043e\u0433 \u0431\u0440\u043e)", 0, Category.VISUALS);
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
