// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.event.EventRender2D;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.api.utils.render.Translate;
import org.lwjgl.input.Keyboard;
import net.minecraft.util.text.TextFormatting;
import java.util.ArrayList;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.utils.render.DrawHelper;
import net.minecraft.potion.PotionEffect;
import java.util.Comparator;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.Main;
import net.minecraft.client.gui.ScaledResolution;
import java.awt.Color;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.features.Feature;

public class KeyBinds extends Feature
{
    public static /* synthetic */ ColorSetting twocolor;
    public static /* synthetic */ ListSetting arrayColor;
    public static /* synthetic */ NumberSetting fonty;
    public static /* synthetic */ NumberSetting time;
    public static /* synthetic */ BooleanSetting backGround;
    public static /* synthetic */ NumberSetting y;
    public static /* synthetic */ NumberSetting backGroundAlpha;
    public static /* synthetic */ NumberSetting x;
    public static /* synthetic */ ColorSetting onecolor;
    /* synthetic */ float listOffset;
    public static /* synthetic */ ColorSetting backGroundColor;
    
    static {
        KeyBinds.onecolor = new ColorSetting("One Color", new Color(16777215).getRGB(), () -> ArreyList.arrayColor.currentMode.equals("Custom"));
        KeyBinds.twocolor = new ColorSetting("Two Color", new Color(16711680).getRGB(), () -> ArreyList.arrayColor.currentMode.equals("Custom"));
    }
    
    public void renderKeyBinds(final ScaledResolution lllllllllllIIlllIllIIlIlIIlIlIlI) {
        final double lllllllllllIIlllIllIIlIlIlIIIlII = lllllllllllIIlllIllIIlIlIIlIlIlI.getScaledWidth() - (ArreyList.rectRight.getBoolValue() ? 1 : 0);
        float lllllllllllIIlllIllIIlIlIlIIIIll = 1.0f;
        int lllllllllllIIlllIllIIlIlIlIIIIlI = 0;
        for (int lllllllllllIIlllIllIIlIlIlIIIIIl = 0; lllllllllllIIlllIllIIlIlIlIIIIIl < Main.featureDirector.getFeatureList().size(); ++lllllllllllIIlllIllIIlIlIlIIIIIl) {
            lllllllllllIIlllIllIIlIlIlIIIIlI += ClientHelper.getFontRender().getFontHeight() + 3;
        }
        if (Main.featureDirector.getFeatureByClass(KeyBinds.class).isToggled()) {
            Main.featureDirector.getFeatureList().sort(Comparator.comparing(lllllllllllIIlllIllIIlIIlllllIlI -> ClientFont.minecraftfont.getBoolValue() ? (-Minecraft.fontRendererObj.getStringWidth(lllllllllllIIlllIllIIlIIlllllIlI.getModuleName())) : (-ClientHelper.getFontRender().getStringWidth(lllllllllllIIlllIllIIlIIlllllIlI.getModuleName()))));
            for (final Feature lllllllllllIIlllIllIIlIlIlIIIIII : Main.featureDirector.getFeatureList()) {
                if (!lllllllllllIIlllIllIIlIlIlIIIIII.getModuleName().equals("ClickGui") && lllllllllllIIlllIllIIlIlIlIIIIII.getKey() != 0) {
                    final Translate lllllllllllIIlllIllIIlIlIIllllll = lllllllllllIIlllIllIIlIlIlIIIIII.getTranslate();
                    final String lllllllllllIIlllIllIIlIlIIlllllI = lllllllllllIIlllIllIIlIlIlIIIIII.getModuleName();
                    final float lllllllllllIIlllIllIIlIlIIllllIl = (float)(ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(lllllllllllIIlllIllIIlIlIIlllllI) : ClientHelper.getFontRender().getStringWidth(lllllllllllIIlllIllIIlIlIIlllllI));
                    final float lllllllllllIIlllIllIIlIlIIllllII = (float)(lllllllllllIIlllIllIIlIlIlIIIlII - lllllllllllIIlllIllIIlIlIIllllIl);
                    final boolean lllllllllllIIlllIllIIlIlIIlllIll = lllllllllllIIlllIllIIlIlIlIIIIII.isToggled();
                    if (lllllllllllIIlllIllIIlIlIIlllIll) {
                        lllllllllllIIlllIllIIlIlIIllllll.arrayListAnim(lllllllllllIIlllIllIIlIlIIllllII, lllllllllllIIlllIllIIlIlIlIIIIll, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    else {
                        lllllllllllIIlllIllIIlIlIIllllll.arrayListAnim((float)lllllllllllIIlllIllIIlIlIlIIIlII, lllllllllllIIlllIllIIlIlIlIIIIll, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    final float lllllllllllIIlllIllIIlIlIIlllIlI = KeyBinds.x.getNumberValue();
                    final float lllllllllllIIlllIllIIlIlIIlllIIl = KeyBinds.y.getNumberValue();
                    final double lllllllllllIIlllIllIIlIlIIlllIII = lllllllllllIIlllIllIIlIlIIllllll.getY();
                    final float lllllllllllIIlllIllIIlIlIIllIlll = KeyBinds.fonty.getNumberValue();
                    int lllllllllllIIlllIllIIlIlIIllIllI = 0;
                    for (final PotionEffect lllllllllllIIlllIllIIlIlIIllIlIl : KeyBinds.mc.player.getActivePotionEffects()) {
                        if (lllllllllllIIlllIllIIlIlIIllIlIl.getPotion().isBeneficial()) {
                            lllllllllllIIlllIllIIlIlIIllIllI = 26;
                        }
                        if (lllllllllllIIlllIllIIlIlIIllIlIl.getPotion().isBadEffect()) {
                            lllllllllllIIlllIllIIlIlIIllIllI = 52;
                        }
                    }
                    final double lllllllllllIIlllIllIIlIlIIllIlII = lllllllllllIIlllIllIIlIlIIllllll.getX() + 1.5;
                    int lllllllllllIIlllIllIIlIlIIllIIll = 0;
                    final double lllllllllllIIlllIllIIlIlIIllIIlI = KeyBinds.time.getNumberValue();
                    final String lllllllllllIIlllIllIIlIlIIllIIIl = KeyBinds.arrayColor.getOptions();
                    final boolean lllllllllllIIlllIllIIlIlIIllIIII = lllllllllllIIlllIllIIlIlIIllllll.getX() < lllllllllllIIlllIllIIlIlIlIIIlII;
                    if (!lllllllllllIIlllIllIIlIlIIllIIII) {
                        continue;
                    }
                    final char lllllllllllIIlllIllIIlIlIIIlIlII;
                    switch (((String)(lllllllllllIIlllIllIIlIlIIIlIlII = (char)lllllllllllIIlllIllIIlIlIIllIIIl.toLowerCase())).hashCode()) {
                        case -1349088399: {
                            if (!((String)lllllllllllIIlllIllIIlIlIIIlIlII).equals("custom")) {
                                break;
                            }
                            lllllllllllIIlllIllIIlIlIIllIIll = DrawHelper.TwoColoreffect(new Color(ArreyList.onecolor.getColorValue()), new Color(ArreyList.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / (long)lllllllllllIIlllIllIIlIlIIllIIlI) / 100.0 + 3.0 * (lllllllllllIIlllIllIIlIlIlIIIIll * 2.55 / 60.0)).getRGB();
                            break;
                        }
                        case -703561496: {
                            if (!((String)lllllllllllIIlllIllIIlIlIIIlIlII).equals("astolfo")) {
                                break;
                            }
                            lllllllllllIIlllIllIIlIlIIllIIll = DrawHelper.astolfoColors45(lllllllllllIIlllIllIIlIlIlIIIIll, (float)lllllllllllIIlllIllIIlIlIlIIIIlI, 0.5f, 5.0f).getRGB();
                            break;
                        }
                        case 3387192: {
                            if (!((String)lllllllllllIIlllIllIIlIlIIIlIlII).equals("none")) {
                                break;
                            }
                            lllllllllllIIlllIllIIlIlIIllIIll = -1;
                            break;
                        }
                        case 107027353: {
                            if (!((String)lllllllllllIIlllIllIIlIlIIIlIlII).equals("pulse")) {
                                break;
                            }
                            lllllllllllIIlllIllIIlIlIIllIIll = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / lllllllllllIIlllIllIIlIlIIllIIlI) / 100.0 + 6.0 * (lllllllllllIIlllIllIIlIlIlIIIIll * 2.55) / 60.0).getRGB();
                            break;
                        }
                        case 973576630: {
                            if (!((String)lllllllllllIIlllIllIIlIlIIIlIlII).equals("rainbow")) {
                                break;
                            }
                            lllllllllllIIlllIllIIlIlIIllIIll = DrawHelper.rainbowNew((int)(lllllllllllIIlllIllIIlIlIlIIIIll * 200.0f * 0.1f), 0.8f, 1.0f);
                            break;
                        }
                    }
                    GlStateManager.pushMatrix();
                    DrawHelper.drawRect(lllllllllllIIlllIllIIlIlIIlIlIlI.getScaledHeight() - lllllllllllIIlllIllIIlIlIIlllIlI - 14.0f + 123.0f, lllllllllllIIlllIllIIlIlIIlllIIl - 1.0f, lllllllllllIIlllIllIIlIlIIlIlIlI.getScaledHeight() - lllllllllllIIlllIllIIlIlIIlllIlI + 14.0f + 197.0f, lllllllllllIIlllIllIIlIlIIlllIII + lllllllllllIIlllIllIIlIlIIlllIIl + 9.0, new Color(30, 30, 30, 255).getRGB());
                    DrawHelper.drawGradientRect1(lllllllllllIIlllIllIIlIlIIlIlIlI.getScaledHeight() - lllllllllllIIlllIllIIlIlIIlllIlI - 14.0f + 120.0f, lllllllllllIIlllIllIIlIlIIlllIIl - 15.0f, lllllllllllIIlllIllIIlIlIIlIlIlI.getScaledHeight() - lllllllllllIIlllIllIIlIlIIlllIlI + 14.0f + 200.0f, lllllllllllIIlllIllIIlIlIIlllIIl - 1.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                    KeyBinds.mc.mntsb_16.drawStringWithShadow("KeyBinds", lllllllllllIIlllIllIIlIlIIlIlIlI.getScaledHeight() - lllllllllllIIlllIllIIlIlIIlllIlI - 10.0f + 130.0f + KeyBinds.mc.mntsb.getStringWidth("KeyBinds") / 2, lllllllllllIIlllIllIIlIlIIlllIIl - 10.0f, -1);
                    GlStateManager.translate(-KeyBinds.x.getNumberValue(), KeyBinds.y.getNumberValue(), 1.0);
                    if (lllllllllllIIlllIllIIlIlIIlllllI == null) {
                        KeyBinds.mc.mntsb.drawStringWithShadow("None", lllllllllllIIlllIllIIlIlIIlIlIlI.getScaledHeight() - lllllllllllIIlllIllIIlIlIIlllIlI - KeyBinds.mc.mntsb.getStringWidth("None") / 2 + 384.0f, lllllllllllIIlllIllIIlIlIIlllIII + lllllllllllIIlllIllIIlIlIIllIlll - 1.0 + 1.0, lllllllllllIIlllIllIIlIlIIllIIll);
                    }
                    Feature lllllllllllIIlllIllIIlIlIIlIllll = null;
                    final int lllllllllllIIlllIllIIlIlIIlIlllI = Main.featureDirector.getFeatureList().indexOf(lllllllllllIIlllIllIIlIlIlIIIIII) + 1;
                    if (Main.featureDirector.getFeatureList().size() > lllllllllllIIlllIllIIlIlIIlIlllI) {
                        lllllllllllIIlllIllIIlIlIIlIllll = getNextEnabledModule((ArrayList)Main.featureDirector.getFeatureList(), lllllllllllIIlllIllIIlIlIIlIlllI);
                    }
                    final String lllllllllllIIlllIllIIlIlIIlIllIl = ClientFont.fontMode.getOptions();
                    if (lllllllllllIIlllIllIIlIlIIlllllI != null) {
                        KeyBinds.mc.mntsb.drawStringWithShadow(String.valueOf(lllllllllllIIlllIllIIlIlIIlllllI) + TextFormatting.DARK_GRAY + " [" + Keyboard.getKeyName(lllllllllllIIlllIllIIlIlIlIIIIII.getKey()) + "]", lllllllllllIIlllIllIIlIlIIlIlIlI.getScaledHeight() - 225 - KeyBinds.mc.mntsb.getStringWidth(String.valueOf(lllllllllllIIlllIllIIlIlIIlllllI) + " [" + Keyboard.getKeyName(lllllllllllIIlllIllIIlIlIlIIIIII.getKey()) + "]") / 2 + 384, lllllllllllIIlllIllIIlIlIIlllIII + lllllllllllIIlllIllIIlIlIIllIlll - 1.0 + 1.0, lllllllllllIIlllIllIIlIlIIllIIll);
                    }
                    else {
                        KeyBinds.mc.mntsb.drawStringWithShadow("None", lllllllllllIIlllIllIIlIlIIlIlIlI.getScaledHeight() - lllllllllllIIlllIllIIlIlIIlllIlI - KeyBinds.mc.mntsb.getStringWidth("None") / 2 + 384.0f, lllllllllllIIlllIllIIlIlIIlllIII + lllllllllllIIlllIllIIlIlIIllIlll - 1.0 + 1.0, lllllllllllIIlllIllIIlIlIIllIIll);
                    }
                    if (lllllllllllIIlllIllIIlIlIIlIllll != null) {
                        final double lllllllllllIIlllIllIIlIlIIlIllII = ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(lllllllllllIIlllIllIIlIlIIlIllll.getModuleName()) : ClientHelper.getFontRender().getStringWidth(lllllllllllIIlllIllIIlIlIIlIllll.getModuleName());
                        final double lllllllllllIIlllIllIIlIlIIIIllll = lllllllllllIIlllIllIIlIlIIllllIl - lllllllllllIIlllIllIIlIlIIlIllII;
                    }
                    lllllllllllIIlllIllIIlIlIlIIIIll += this.listOffset;
                    GlStateManager.popMatrix();
                }
            }
        }
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIIlllIllIIlIlIllIIlll) {
        final String lllllllllllIIlllIllIIlIlIllIIllI = KeyBinds.arrayColor.getOptions();
        this.setModuleName("KeyBinds §7" + lllllllllllIIlllIllIIlIlIllIIllI);
    }
    
    @EventTarget
    public void onRender2D(final EventRender2D lllllllllllIIlllIllIIlIIllllllll) {
        final HUD lllllllllllIIlllIllIIlIIlllllllI = new HUD();
        lllllllllllIIlllIllIIlIIlllllllI.renderKeyBinds(lllllllllllIIlllIllIIlIIllllllll.getResolution());
    }
    
    private static Feature getNextEnabledModule(final ArrayList<Feature> lllllllllllIIlllIllIIlIlIIIIlIlI, final int lllllllllllIIlllIllIIlIlIIIIIlIl) {
        for (int lllllllllllIIlllIllIIlIlIIIIlIII = lllllllllllIIlllIllIIlIlIIIIIlIl; lllllllllllIIlllIllIIlIlIIIIlIII < lllllllllllIIlllIllIIlIlIIIIlIlI.size(); ++lllllllllllIIlllIllIIlIlIIIIlIII) {
            final Feature lllllllllllIIlllIllIIlIlIIIIIlll = lllllllllllIIlllIllIIlIlIIIIlIlI.get(lllllllllllIIlllIllIIlIlIIIIlIII);
            if (lllllllllllIIlllIllIIlIlIIIIIlll.isToggled() && !lllllllllllIIlllIllIIlIlIIIIIlll.getModuleName().equals("ClickGui")) {
                return lllllllllllIIlllIllIIlIlIIIIIlll;
            }
        }
        return null;
    }
    
    public KeyBinds() {
        super("KeyBinds", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0441\u043f\u0438\u0441\u043e\u043a \u0432\u0441\u0435\u0445 \u0437\u0430\u0431\u0438\u043d\u0436\u0435\u043d\u043d\u044b\u0445 \u0438 \u0432\u043a\u043b\u044e\u0447\u0435\u043d\u043d\u044b\u0445 \u043c\u043e\u0434\u0443\u043b\u0435\u0439", 0, Category.DISPLAY);
        this.listOffset = 8.0f;
        KeyBinds.arrayColor = new ListSetting("KeyBinds Color", "Custom", () -> true, new String[] { "Custom", "Rainbow", "Pulse", "Astolfo", "None" });
        KeyBinds.backGround = new BooleanSetting("Background", true, () -> true);
        KeyBinds.backGroundColor = new ColorSetting("Background Color", new Color(0).getRGB(), () -> KeyBinds.backGround.getBoolValue());
        KeyBinds.backGroundAlpha = new NumberSetting("Background Alpha", 255.0f, 1.0f, 255.0f, 1.0f, () -> true);
        KeyBinds.time = new NumberSetting("Color Time", 10.0f, 1.0f, 100.0f, 1.0f, () -> true);
        KeyBinds.x = new NumberSetting("KeyBinds X", 0.0f, 0.0f, 600.0f, 1.0f, () -> true);
        KeyBinds.y = new NumberSetting("KeyBinds Y", 0.0f, 0.0f, 500.0f, 1.0f, () -> true);
        KeyBinds.fonty = new NumberSetting("Font Y", 1.0f, 0.0f, 10.0f, 1.0f, () -> true);
        this.addSettings(KeyBinds.arrayColor, KeyBinds.onecolor, KeyBinds.twocolor, KeyBinds.backGround, KeyBinds.backGroundColor, KeyBinds.backGroundAlpha, KeyBinds.time, KeyBinds.x, KeyBinds.y, KeyBinds.fonty);
    }
}
