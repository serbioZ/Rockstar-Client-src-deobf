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
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class ChinaHat extends Feature
{
    final /* synthetic */ NumberSetting saturation;
    final /* synthetic */ ListSetting colorMode;
    final /* synthetic */ ColorSetting twocolor;
    final /* synthetic */ ColorSetting onecolor;
    
    @EventTarget
    public void asf(final Event3D lllllllllllIIllIIIIIIIllIlIIllIl) {
        final ItemStack lllllllllllIIllIIIIIIIllIlIIllII = ChinaHat.mc.player.getEquipmentInSlot(4);
        final double lllllllllllIIllIIIIIIIllIlIIlIll = (lllllllllllIIllIIIIIIIllIlIIllII.getItem() instanceof ItemArmor) ? (ChinaHat.mc.player.isSneaking() ? -0.1 : 0.12) : (ChinaHat.mc.player.isSneaking() ? -0.22 : 0.0);
        if (ChinaHat.mc.gameSettings.thirdPersonView == 1 || ChinaHat.mc.gameSettings.thirdPersonView == 2) {
            GlStateManager.pushMatrix();
            GL11.glBlendFunc(770, 771);
            GlStateManager.disableDepth();
            GlStateManager.disableTexture2D();
            DrawHelper.enableSmoothLine(2.5f);
            GL11.glShadeModel(7425);
            GL11.glDisable(2884);
            GL11.glEnable(3042);
            GL11.glEnable(2929);
            GL11.glTranslatef(0.0f, (float)(ChinaHat.mc.player.height + lllllllllllIIllIIIIIIIllIlIIlIll), 0.0f);
            GL11.glRotatef(-ChinaHat.mc.player.rotationYaw, 0.0f, 1.0f, 0.0f);
            Color lllllllllllIIllIIIIIIIllIlIIlIlI = Color.WHITE;
            final Color lllllllllllIIllIIIIIIIllIlIIlIIl = new Color(this.onecolor.getColorValue());
            final String lllllllllllIIllIIIIIIIllIlIIlIII = this.colorMode.currentMode;
            byte lllllllllllIIllIIIIIIIllIlIIIlll = -1;
            switch (lllllllllllIIllIIIIIIIllIlIIlIII.hashCode()) {
                case -1808614770: {
                    if (lllllllllllIIllIIIIIIIllIlIIlIII.equals("Static")) {
                        lllllllllllIIllIIIIIIIllIlIIIlll = 4;
                        break;
                    }
                    break;
                }
                case 77474681: {
                    if (lllllllllllIIllIIIIIIIllIlIIlIII.equals("Pulse")) {
                        lllllllllllIIllIIIIIIIllIlIIIlll = 2;
                        break;
                    }
                    break;
                }
                case 961091784: {
                    if (lllllllllllIIllIIIIIIIllIlIIlIII.equals("Astolfo")) {
                        lllllllllllIIllIIIIIIIllIlIIIlll = 1;
                        break;
                    }
                    break;
                }
                case 2021122027: {
                    if (lllllllllllIIllIIIIIIIllIlIIlIII.equals("Client")) {
                        lllllllllllIIllIIIIIIIllIlIIIlll = 0;
                        break;
                    }
                    break;
                }
                case 2029746065: {
                    if (lllllllllllIIllIIIIIIIllIlIIlIII.equals("Custom")) {
                        lllllllllllIIllIIIIIIIllIlIIIlll = 3;
                        break;
                    }
                    break;
                }
            }
            switch (lllllllllllIIllIIIIIIIllIlIIIlll) {
                case 0: {
                    lllllllllllIIllIIIIIIIllIlIIlIlI = ClientHelper.getClientColor(5.0f, 1.0f, 5);
                    break;
                }
                case 1: {
                    lllllllllllIIllIIIIIIIllIlIIlIlI = DrawHelper.astolfoColors45(5.0f, 5.0f, this.saturation.getNumberValue(), 10.0f);
                    break;
                }
                case 2: {
                    lllllllllllIIllIIIIIIIllIlIIlIlI = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.0);
                    break;
                }
                case 3: {
                    lllllllllllIIllIIIIIIIllIlIIlIlI = DrawHelper.TwoColoreffect(new Color(this.onecolor.getColorValue()), new Color(this.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.0);
                    break;
                }
                case 4: {
                    lllllllllllIIllIIIIIIIllIlIIlIlI = lllllllllllIIllIIIIIIIllIlIIlIIl;
                    break;
                }
            }
            GL11.glBegin(6);
            DrawHelper.glColor(lllllllllllIIllIIIIIIIllIlIIlIlI, 255);
            GL11.glVertex3d(0.0, 0.3, 0.0);
            for (float lllllllllllIIllIIIIIIIllIlIIIIII = 0.0f; lllllllllllIIllIIIIIIIllIlIIIIII < 360.5; ++lllllllllllIIllIIIIIIIllIlIIIIII) {
                Color lllllllllllIIllIIIIIIIllIIllllll = Color.WHITE;
                final Color lllllllllllIIllIIIIIIIllIlIIIllI = new Color(this.onecolor.getColorValue());
                final String lllllllllllIIllIIIIIIIllIlIIIlII = this.colorMode.currentMode;
                byte lllllllllllIIllIIIIIIIllIlIIIIlI = -1;
                switch (lllllllllllIIllIIIIIIIllIlIIIlII.hashCode()) {
                    case -1808614770: {
                        if (lllllllllllIIllIIIIIIIllIlIIIlII.equals("Static")) {
                            lllllllllllIIllIIIIIIIllIlIIIIlI = 4;
                            break;
                        }
                        break;
                    }
                    case 77474681: {
                        if (lllllllllllIIllIIIIIIIllIlIIIlII.equals("Pulse")) {
                            lllllllllllIIllIIIIIIIllIlIIIIlI = 2;
                            break;
                        }
                        break;
                    }
                    case 961091784: {
                        if (lllllllllllIIllIIIIIIIllIlIIIlII.equals("Astolfo")) {
                            lllllllllllIIllIIIIIIIllIlIIIIlI = 1;
                            break;
                        }
                        break;
                    }
                    case 2021122027: {
                        if (lllllllllllIIllIIIIIIIllIlIIIlII.equals("Client")) {
                            lllllllllllIIllIIIIIIIllIlIIIIlI = 0;
                            break;
                        }
                        break;
                    }
                    case 2029746065: {
                        if (lllllllllllIIllIIIIIIIllIlIIIlII.equals("Custom")) {
                            lllllllllllIIllIIIIIIIllIlIIIIlI = 3;
                            break;
                        }
                        break;
                    }
                }
                switch (lllllllllllIIllIIIIIIIllIlIIIIlI) {
                    case 0: {
                        lllllllllllIIllIIIIIIIllIIllllll = ClientHelper.getClientColor(lllllllllllIIllIIIIIIIllIlIIIIII / 16.0f, lllllllllllIIllIIIIIIIllIlIIIIII, 5);
                        break;
                    }
                    case 1: {
                        lllllllllllIIllIIIIIIIllIIllllll = DrawHelper.astolfoColors45(lllllllllllIIllIIIIIIIllIlIIIIII - lllllllllllIIllIIIIIIIllIlIIIIII + 1.0f, lllllllllllIIllIIIIIIIllIlIIIIII, this.saturation.getNumberValue(), 10.0f);
                        break;
                    }
                    case 2: {
                        lllllllllllIIllIIIIIIIllIIllllll = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0f * (lllllllllllIIllIIIIIIIllIlIIIIII / 16.0f) / 60.0f);
                        break;
                    }
                    case 3: {
                        lllllllllllIIllIIIIIIIllIIllllll = DrawHelper.TwoColoreffect(new Color(this.onecolor.getColorValue()), new Color(this.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 3.0f * (lllllllllllIIllIIIIIIIllIlIIIIII / 16.0f) / 60.0f);
                        break;
                    }
                    case 4: {
                        lllllllllllIIllIIIIIIIllIIllllll = lllllllllllIIllIIIIIIIllIlIIIllI;
                        break;
                    }
                }
                DrawHelper.glColor(lllllllllllIIllIIIIIIIllIIllllll, 255);
                GL11.glVertex3d(Math.cos(lllllllllllIIllIIIIIIIllIlIIIIII * 3.141592653589793 / 180.0) * 0.66, 0.0, Math.sin(lllllllllllIIllIIIIIIIllIlIIIIII * 3.141592653589793 / 180.0) * 0.66);
            }
            GL11.glVertex3d(0.0, 0.3, 0.0);
            GL11.glEnd();
            GL11.glBegin(2);
            for (float lllllllllllIIllIIIIIIIllIlIIIIII = 0.0f; lllllllllllIIllIIIIIIIllIlIIIIII < 360.5; ++lllllllllllIIllIIIIIIIllIlIIIIII) {
                Color lllllllllllIIllIIIIIIIllIIlllllI = Color.WHITE;
                final Color lllllllllllIIllIIIIIIIllIlIIIlIl = new Color(this.onecolor.getColorValue());
                final String lllllllllllIIllIIIIIIIllIlIIIIll = this.colorMode.currentMode;
                byte lllllllllllIIllIIIIIIIllIlIIIIIl = -1;
                switch (lllllllllllIIllIIIIIIIllIlIIIIll.hashCode()) {
                    case -1808614770: {
                        if (lllllllllllIIllIIIIIIIllIlIIIIll.equals("Static")) {
                            lllllllllllIIllIIIIIIIllIlIIIIIl = 4;
                            break;
                        }
                        break;
                    }
                    case 77474681: {
                        if (lllllllllllIIllIIIIIIIllIlIIIIll.equals("Pulse")) {
                            lllllllllllIIllIIIIIIIllIlIIIIIl = 2;
                            break;
                        }
                        break;
                    }
                    case 961091784: {
                        if (lllllllllllIIllIIIIIIIllIlIIIIll.equals("Astolfo")) {
                            lllllllllllIIllIIIIIIIllIlIIIIIl = 1;
                            break;
                        }
                        break;
                    }
                    case 2021122027: {
                        if (lllllllllllIIllIIIIIIIllIlIIIIll.equals("Client")) {
                            lllllllllllIIllIIIIIIIllIlIIIIIl = 0;
                            break;
                        }
                        break;
                    }
                    case 2029746065: {
                        if (lllllllllllIIllIIIIIIIllIlIIIIll.equals("Custom")) {
                            lllllllllllIIllIIIIIIIllIlIIIIIl = 3;
                            break;
                        }
                        break;
                    }
                }
                switch (lllllllllllIIllIIIIIIIllIlIIIIIl) {
                    case 0: {
                        lllllllllllIIllIIIIIIIllIIlllllI = ClientHelper.getClientColor(5.0f, lllllllllllIIllIIIIIIIllIlIIIIII, 5);
                        break;
                    }
                    case 1: {
                        lllllllllllIIllIIIIIIIllIIlllllI = DrawHelper.astolfoColors45(lllllllllllIIllIIIIIIIllIlIIIIII - lllllllllllIIllIIIIIIIllIlIIIIII + 1.0f, lllllllllllIIllIIIIIIIllIlIIIIII, this.saturation.getNumberValue(), 10.0f);
                        break;
                    }
                    case 2: {
                        lllllllllllIIllIIIIIIIllIIlllllI = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0f * (lllllllllllIIllIIIIIIIllIlIIIIII / 16.0f) / 60.0f);
                        break;
                    }
                    case 3: {
                        lllllllllllIIllIIIIIIIllIIlllllI = DrawHelper.TwoColoreffect(new Color(this.onecolor.getColorValue()), new Color(this.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 3.0f * (lllllllllllIIllIIIIIIIllIlIIIIII / 16.0f) / 60.0f);
                        break;
                    }
                    case 4: {
                        lllllllllllIIllIIIIIIIllIIlllllI = lllllllllllIIllIIIIIIIllIlIIIlIl;
                        break;
                    }
                }
                DrawHelper.glColor(lllllllllllIIllIIIIIIIllIIlllllI, 255);
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
    
    public ChinaHat() {
        super("ChinaHat", "\u0421\u043e\u0437\u0434\u0430\u0451\u0442 \u043a\u0438\u0442\u0430\u0439\u0441\u043a\u0443\u044e \u0448\u043b\u044f\u043f\u0443", 0, Category.VISUALS);
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
