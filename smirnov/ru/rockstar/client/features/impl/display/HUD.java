// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.utils.render.Translate;
import org.lwjgl.input.Keyboard;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.Main;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.gui.GuiChat;
import ru.rockstar.api.event.event.EventRender2D;
import java.util.List;
import ru.rockstar.api.utils.render.ClientHelper;
import java.awt.Color;
import net.minecraft.client.resources.I18n;
import java.util.Comparator;
import java.util.Objects;
import optifine.CustomColors;
import net.minecraft.potion.Potion;
import net.minecraft.client.Minecraft;
import java.util.Collection;
import net.minecraft.potion.PotionEffect;
import java.util.ArrayList;
import net.minecraft.client.gui.FontRenderer;
import ru.rockstar.api.utils.world.TimerHelper;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.features.Feature;

public class HUD extends Feature
{
    /* synthetic */ double width;
    /* synthetic */ ScaledResolution sr;
    /* synthetic */ int yTotal;
    /* synthetic */ Feature nextModule;
    /* synthetic */ int colorArray;
    /* synthetic */ float listOffset;
    public static /* synthetic */ double time;
    public static /* synthetic */ float globalOffset;
    public static /* synthetic */ float count;
    /* synthetic */ double potionCheck;
    /* synthetic */ float yDist;
    /* synthetic */ float xd;
    
    static {
        HUD.count = 0.0f;
        HUD.time = ArreyList.time.getNumberValue();
    }
    
    public static void renderPotionStatus(final ScaledResolution llllllllllllllllIlIIlIlllIIIlIlI) {
        final float llllllllllllllllIlIIlIlllIIlIIlI = HUD.globalOffset;
        float llllllllllllllllIlIIlIlllIIlIIIl = -2.0f;
        final List<PotionEffect> llllllllllllllllIlIIlIlllIIlIIII = new ArrayList<PotionEffect>(HUD.mc.player.getActivePotionEffects());
        llllllllllllllllIlIIlIlllIIlIIII.sort(Comparator.comparingDouble(llllllllllllllllIlIIlIlIllIIIIII -> Minecraft.fontRendererObj.getStringWidth(Objects.requireNonNull(Potion.getPotionById(CustomColors.getPotionId(llllllllllllllllIlIIlIlIllIIIIII.getEffectName()))).getName())));
        for (final PotionEffect llllllllllllllllIlIIlIlllIIIllll : llllllllllllllllIlIIlIlllIIlIIII) {
            final Potion llllllllllllllllIlIIlIlllIIIlllI = Potion.getPotionById(CustomColors.getPotionId(llllllllllllllllIlIIlIlllIIIllll.getEffectName()));
            assert llllllllllllllllIlIIlIlllIIIlllI != null;
            String llllllllllllllllIlIIlIlllIIIllIl = I18n.format(llllllllllllllllIlIIlIlllIIIlllI.getName(), new Object[0]);
            String llllllllllllllllIlIIlIlllIIIllII = "";
            if (llllllllllllllllIlIIlIlllIIIllll.getAmplifier() == 1) {
                llllllllllllllllIlIIlIlllIIIllIl = String.valueOf(llllllllllllllllIlIIlIlllIIIllIl) + " 2";
            }
            else if (llllllllllllllllIlIIlIlllIIIllll.getAmplifier() == 2) {
                llllllllllllllllIlIIlIlllIIIllIl = String.valueOf(llllllllllllllllIlIIlIlllIIIllIl) + " 3";
            }
            else if (llllllllllllllllIlIIlIlllIIIllll.getAmplifier() == 3) {
                llllllllllllllllIlIIlIlllIIIllIl = String.valueOf(llllllllllllllllIlIIlIlllIIIllIl) + " 4";
            }
            if (llllllllllllllllIlIIlIlllIIIllll.getDuration() < 600 && llllllllllllllllIlIIlIlllIIIllll.getDuration() > 300) {
                llllllllllllllllIlIIlIlllIIIllII = String.valueOf(llllllllllllllllIlIIlIlllIIIllII) + " " + Potion.getDurationString(llllllllllllllllIlIIlIlllIIIllll);
            }
            else if (llllllllllllllllIlIIlIlllIIIllll.getDuration() < 300) {
                llllllllllllllllIlIIlIlllIIIllII = String.valueOf(llllllllllllllllIlIIlIlllIIIllII) + " " + Potion.getDurationString(llllllllllllllllIlIIlIlllIIIllll);
            }
            else if (llllllllllllllllIlIIlIlllIIIllll.getDuration() > 600) {
                llllllllllllllllIlIIlIlllIIIllII = String.valueOf(llllllllllllllllIlIIlIlllIIIllII) + " " + Potion.getDurationString(llllllllllllllllIlIIlIlllIIIllll);
            }
            int llllllllllllllllIlIIlIlllIIIlIll = -1;
            if (llllllllllllllllIlIIlIlllIIIllll.getDuration() < 200) {
                llllllllllllllllIlIIlIlllIIIlIll = new Color(215, 59, 59).getRGB();
            }
            else if (llllllllllllllllIlIIlIlllIIIllll.getDuration() < 400) {
                llllllllllllllllIlIIlIlllIIIlIll = new Color(231, 143, 32).getRGB();
            }
            else if (llllllllllllllllIlIIlIlllIIIllll.getDuration() > 400) {
                llllllllllllllllIlIIlIlllIIIlIll = new Color(172, 171, 171).getRGB();
            }
            if (!ClientFont.minecraftfont.getBoolValue()) {
                Minecraft.fontRendererObj.drawStringWithShadow(llllllllllllllllIlIIlIlllIIIllIl, (float)(llllllllllllllllIlIIlIlllIIIlIlI.getScaledWidth() - Minecraft.fontRendererObj.getStringWidth(String.valueOf(llllllllllllllllIlIIlIlllIIIllIl) + llllllllllllllllIlIIlIlllIIIllII) - 3), llllllllllllllllIlIIlIlllIIIlIlI.getScaledHeight() - 28 + llllllllllllllllIlIIlIlllIIlIIIl - llllllllllllllllIlIIlIlllIIlIIlI, llllllllllllllllIlIIlIlllIIIlllI.getLiquidColor());
                Minecraft.fontRendererObj.drawStringWithShadow(llllllllllllllllIlIIlIlllIIIllII, (float)(llllllllllllllllIlIIlIlllIIIlIlI.getScaledWidth() - Minecraft.fontRendererObj.getStringWidth(llllllllllllllllIlIIlIlllIIIllII) - 2), llllllllllllllllIlIIlIlllIIIlIlI.getScaledHeight() - 28 + llllllllllllllllIlIIlIlllIIlIIIl - llllllllllllllllIlIIlIlllIIlIIlI, llllllllllllllllIlIIlIlllIIIlIll);
            }
            else {
                ClientHelper.getFontRender().drawStringWithShadow(llllllllllllllllIlIIlIlllIIIllIl, llllllllllllllllIlIIlIlllIIIlIlI.getScaledWidth() - ClientHelper.getFontRender().getStringWidth(String.valueOf(llllllllllllllllIlIIlIlllIIIllIl) + llllllllllllllllIlIIlIlllIIIllII) - 3, llllllllllllllllIlIIlIlllIIIlIlI.getScaledHeight() - 28 + llllllllllllllllIlIIlIlllIIlIIIl - llllllllllllllllIlIIlIlllIIlIIlI, llllllllllllllllIlIIlIlllIIIlllI.getLiquidColor());
                ClientHelper.getFontRender().drawStringWithShadow(llllllllllllllllIlIIlIlllIIIllII, llllllllllllllllIlIIlIlllIIIlIlI.getScaledWidth() - ClientHelper.getFontRender().getStringWidth(llllllllllllllllIlIIlIlllIIIllII) - 2, llllllllllllllllIlIIlIlllIIIlIlI.getScaledHeight() - 28 + llllllllllllllllIlIIlIlllIIlIIIl - llllllllllllllllIlIIlIlllIIlIIlI, llllllllllllllllIlIIlIlllIIIlIll);
            }
            llllllllllllllllIlIIlIlllIIlIIIl -= 11.0f;
        }
    }
    
    public static int rainbow(final int llllllllllllllllIlIIlIlIllIIlIII, final long llllllllllllllllIlIIlIlIllIIIlII) {
        double llllllllllllllllIlIIlIlIllIIIllI = Math.ceil((double)(System.currentTimeMillis() + llllllllllllllllIlIIlIlIllIIIlII + llllllllllllllllIlIIlIlIllIIlIII)) / 15.0;
        llllllllllllllllIlIIlIlIllIIIllI %= 360.0;
        return Color.getHSBColor((float)(llllllllllllllllIlIIlIlIllIIIllI / 360.0), 0.4f, 1.0f).getRGB();
    }
    
    @EventTarget
    public void onRender2D(final EventRender2D llllllllllllllllIlIIlIlllIlIIlll) {
        final float llllllllllllllllIlIIlIlllIlIIllI = (HUD.mc.currentScreen instanceof GuiChat) ? 15.0f : 0.0f;
        final float llllllllllllllllIlIIlIlllIlIIlIl = HUD.globalOffset - llllllllllllllllIlIIlIlllIlIIllI;
        HUD.globalOffset -= llllllllllllllllIlIIlIlllIlIIlIl / Math.max(1, Minecraft.getDebugFPS()) * 10.0f;
        if (!Double.isFinite(HUD.globalOffset)) {
            HUD.globalOffset = 0.0f;
        }
        if (HUD.globalOffset > 15.0f) {
            HUD.globalOffset = 15.0f;
        }
        if (HUD.globalOffset < 0.0f) {
            HUD.globalOffset = 0.0f;
        }
        this.hotBar();
        renderPotionStatus(llllllllllllllllIlIIlIlllIlIIlll.getResolution());
    }
    
    public void renderKeyBinds(final ScaledResolution llllllllllllllllIlIIlIllIIIIllll) {
        final double llllllllllllllllIlIIlIllIIIIlllI = llllllllllllllllIlIIlIllIIIIllll.getScaledWidth() - (ArreyList.rectRight.getBoolValue() ? 1 : 0);
        float llllllllllllllllIlIIlIllIIIIllIl = 1.0f;
        int llllllllllllllllIlIIlIllIIIIllII = 0;
        for (int llllllllllllllllIlIIlIllIIIIlIll = 0; llllllllllllllllIlIIlIllIIIIlIll < Main.featureDirector.getFeatureList().size(); ++llllllllllllllllIlIIlIllIIIIlIll) {
            llllllllllllllllIlIIlIllIIIIllII += ClientHelper.getFontRender().getFontHeight() + 3;
        }
        final float llllllllllllllllIlIIlIllIIIIlIlI = 8.0f;
        if (Main.featureDirector.getFeatureByClass(KeyBinds.class).isToggled()) {
            Main.featureDirector.getFeatureList().sort(Comparator.comparing(llllllllllllllllIlIIlIlIlIlllIlI -> ClientFont.minecraftfont.getBoolValue() ? (-Minecraft.fontRendererObj.getStringWidth(llllllllllllllllIlIIlIlIlIlllIlI.getModuleName())) : (-ClientHelper.getFontRender().getStringWidth(llllllllllllllllIlIIlIlIlIlllIlI.getModuleName()))));
            for (final Feature llllllllllllllllIlIIlIllIIIIlIIl : Main.featureDirector.getFeatureList()) {
                if (!llllllllllllllllIlIIlIllIIIIlIIl.getModuleName().equals("ClickGui") && llllllllllllllllIlIIlIllIIIIlIIl.getKey() != 0) {
                    final Translate llllllllllllllllIlIIlIllIIIIlIII = llllllllllllllllIlIIlIllIIIIlIIl.getTranslate();
                    final String llllllllllllllllIlIIlIllIIIIIlll = llllllllllllllllIlIIlIllIIIIlIIl.getModuleName();
                    final float llllllllllllllllIlIIlIllIIIIIllI = (float)(ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(llllllllllllllllIlIIlIllIIIIIlll) : ClientHelper.getFontRender().getStringWidth(llllllllllllllllIlIIlIllIIIIIlll));
                    final float llllllllllllllllIlIIlIllIIIIIlIl = (float)(llllllllllllllllIlIIlIllIIIIlllI - llllllllllllllllIlIIlIllIIIIIllI);
                    final boolean llllllllllllllllIlIIlIllIIIIIlII = llllllllllllllllIlIIlIllIIIIlIIl.isToggled();
                    if (llllllllllllllllIlIIlIllIIIIIlII) {
                        llllllllllllllllIlIIlIllIIIIlIII.arrayListAnim(llllllllllllllllIlIIlIllIIIIIlIl, llllllllllllllllIlIIlIllIIIIllIl, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    else {
                        llllllllllllllllIlIIlIllIIIIlIII.arrayListAnim((float)llllllllllllllllIlIIlIllIIIIlllI, llllllllllllllllIlIIlIllIIIIllIl, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    final float llllllllllllllllIlIIlIllIIIIIIll = KeyBinds.x.getNumberValue();
                    final float llllllllllllllllIlIIlIllIIIIIIlI = KeyBinds.y.getNumberValue();
                    final double llllllllllllllllIlIIlIllIIIIIIIl = llllllllllllllllIlIIlIllIIIIlIII.getY();
                    final float llllllllllllllllIlIIlIllIIIIIIII = KeyBinds.fonty.getNumberValue();
                    int llllllllllllllllIlIIlIlIllllllll = 0;
                    for (final PotionEffect llllllllllllllllIlIIlIlIlllllllI : HUD.mc.player.getActivePotionEffects()) {
                        if (llllllllllllllllIlIIlIlIlllllllI.getPotion().isBeneficial()) {
                            llllllllllllllllIlIIlIlIllllllll = 26;
                        }
                        if (llllllllllllllllIlIIlIlIlllllllI.getPotion().isBadEffect()) {
                            llllllllllllllllIlIIlIlIllllllll = 52;
                        }
                    }
                    final double llllllllllllllllIlIIlIlIllllllIl = llllllllllllllllIlIIlIllIIIIlIII.getX() + 1.5;
                    int llllllllllllllllIlIIlIlIllllllII = 0;
                    final double llllllllllllllllIlIIlIlIlllllIll = KeyBinds.time.getNumberValue();
                    final String llllllllllllllllIlIIlIlIlllllIlI = KeyBinds.arrayColor.getOptions();
                    final boolean llllllllllllllllIlIIlIlIlllllIIl = llllllllllllllllIlIIlIllIIIIlIII.getX() < llllllllllllllllIlIIlIllIIIIlllI;
                    if (!llllllllllllllllIlIIlIlIlllllIIl) {
                        continue;
                    }
                    final float llllllllllllllllIlIIlIlIllIlllIl;
                    switch (((String)(llllllllllllllllIlIIlIlIllIlllIl = (float)llllllllllllllllIlIIlIlIlllllIlI.toLowerCase())).hashCode()) {
                        case -1349088399: {
                            if (!((String)llllllllllllllllIlIIlIlIllIlllIl).equals("custom")) {
                                break;
                            }
                            llllllllllllllllIlIIlIlIllllllII = DrawHelper.TwoColoreffect(new Color(ArreyList.onecolor.getColorValue()), new Color(ArreyList.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / (long)llllllllllllllllIlIIlIlIlllllIll) / 100.0 + 3.0 * (llllllllllllllllIlIIlIllIIIIllIl * 2.55 / 60.0)).getRGB();
                            break;
                        }
                        case -703561496: {
                            if (!((String)llllllllllllllllIlIIlIlIllIlllIl).equals("astolfo")) {
                                break;
                            }
                            llllllllllllllllIlIIlIlIllllllII = DrawHelper.astolfoColors45(llllllllllllllllIlIIlIllIIIIllIl, (float)llllllllllllllllIlIIlIllIIIIllII, 0.5f, 5.0f).getRGB();
                            break;
                        }
                        case 3387192: {
                            if (!((String)llllllllllllllllIlIIlIlIllIlllIl).equals("none")) {
                                break;
                            }
                            llllllllllllllllIlIIlIlIllllllII = -1;
                            break;
                        }
                        case 107027353: {
                            if (!((String)llllllllllllllllIlIIlIlIllIlllIl).equals("pulse")) {
                                break;
                            }
                            llllllllllllllllIlIIlIlIllllllII = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / llllllllllllllllIlIIlIlIlllllIll) / 100.0 + 6.0 * (llllllllllllllllIlIIlIllIIIIllIl * 2.55) / 60.0).getRGB();
                            break;
                        }
                        case 973576630: {
                            if (!((String)llllllllllllllllIlIIlIlIllIlllIl).equals("rainbow")) {
                                break;
                            }
                            llllllllllllllllIlIIlIlIllllllII = DrawHelper.rainbowNew((int)(llllllllllllllllIlIIlIllIIIIllIl * 200.0f * 0.1f), 0.8f, 1.0f);
                            break;
                        }
                    }
                    GlStateManager.pushMatrix();
                    DrawHelper.drawRect(llllllllllllllllIlIIlIllIIIIllll.getScaledHeight() - llllllllllllllllIlIIlIllIIIIIIll - 14.0f + 123.0f, llllllllllllllllIlIIlIllIIIIIIlI - 1.0f, llllllllllllllllIlIIlIllIIIIllll.getScaledHeight() - llllllllllllllllIlIIlIllIIIIIIll + 14.0f + 197.0f, llllllllllllllllIlIIlIllIIIIIIIl + llllllllllllllllIlIIlIllIIIIIIlI + 9.0, new Color(30, 30, 30, 255).getRGB());
                    DrawHelper.drawGradientRect1(llllllllllllllllIlIIlIllIIIIllll.getScaledHeight() - llllllllllllllllIlIIlIllIIIIIIll - 14.0f + 120.0f, llllllllllllllllIlIIlIllIIIIIIlI - 15.0f, llllllllllllllllIlIIlIllIIIIllll.getScaledHeight() - llllllllllllllllIlIIlIllIIIIIIll + 14.0f + 200.0f, llllllllllllllllIlIIlIllIIIIIIlI - 1.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                    HUD.mc.mntsb_16.drawStringWithShadow("KeyBinds", llllllllllllllllIlIIlIllIIIIllll.getScaledHeight() - llllllllllllllllIlIIlIllIIIIIIll - 10.0f + 130.0f + HUD.mc.mntsb.getStringWidth("KeyBinds") / 2, llllllllllllllllIlIIlIllIIIIIIlI - 10.0f, -1);
                    GlStateManager.translate(-KeyBinds.x.getNumberValue(), KeyBinds.y.getNumberValue(), 1.0);
                    if (llllllllllllllllIlIIlIllIIIIIlll == null) {
                        HUD.mc.mntsb.drawStringWithShadow("None", llllllllllllllllIlIIlIllIIIIllll.getScaledHeight() - llllllllllllllllIlIIlIllIIIIIIll - HUD.mc.mntsb.getStringWidth("None") / 2 + 384.0f, llllllllllllllllIlIIlIllIIIIIIIl + llllllllllllllllIlIIlIllIIIIIIII - 1.0 + 1.0, llllllllllllllllIlIIlIlIllllllII);
                    }
                    Feature llllllllllllllllIlIIlIlIlllllIII = null;
                    final int llllllllllllllllIlIIlIlIllllIlll = Main.featureDirector.getFeatureList().indexOf(llllllllllllllllIlIIlIllIIIIlIIl) + 1;
                    if (Main.featureDirector.getFeatureList().size() > llllllllllllllllIlIIlIlIllllIlll) {
                        llllllllllllllllIlIIlIlIlllllIII = getNextEnabledModule((ArrayList)Main.featureDirector.getFeatureList(), llllllllllllllllIlIIlIlIllllIlll);
                    }
                    final String llllllllllllllllIlIIlIlIllllIllI = ClientFont.fontMode.getOptions();
                    if (llllllllllllllllIlIIlIllIIIIIlll != null) {
                        HUD.mc.mntsb.drawStringWithShadow(String.valueOf(llllllllllllllllIlIIlIllIIIIIlll) + TextFormatting.DARK_GRAY + " [" + Keyboard.getKeyName(llllllllllllllllIlIIlIllIIIIlIIl.getKey()) + "]", llllllllllllllllIlIIlIllIIIIllll.getScaledHeight() - 225 - HUD.mc.mntsb.getStringWidth(String.valueOf(llllllllllllllllIlIIlIllIIIIIlll) + " [" + Keyboard.getKeyName(llllllllllllllllIlIIlIllIIIIlIIl.getKey()) + "]") / 2 + 384, llllllllllllllllIlIIlIllIIIIIIIl + llllllllllllllllIlIIlIllIIIIIIII - 1.0 + 1.0, llllllllllllllllIlIIlIlIllllllII);
                    }
                    else {
                        HUD.mc.mntsb.drawStringWithShadow("None", llllllllllllllllIlIIlIllIIIIllll.getScaledHeight() - llllllllllllllllIlIIlIllIIIIIIll - HUD.mc.mntsb.getStringWidth("None") / 2 + 384.0f, llllllllllllllllIlIIlIllIIIIIIIl + llllllllllllllllIlIIlIllIIIIIIII - 1.0 + 1.0, llllllllllllllllIlIIlIlIllllllII);
                    }
                    if (llllllllllllllllIlIIlIlIlllllIII != null) {
                        final double llllllllllllllllIlIIlIlIllllIlIl = ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(llllllllllllllllIlIIlIlIlllllIII.getModuleName()) : ClientHelper.getFontRender().getStringWidth(llllllllllllllllIlIIlIlIlllllIII.getModuleName());
                        final byte llllllllllllllllIlIIlIlIllIllIII = (byte)(llllllllllllllllIlIIlIllIIIIIllI - llllllllllllllllIlIIlIlIllllIlIl);
                    }
                    llllllllllllllllIlIIlIllIIIIllIl += llllllllllllllllIlIIlIllIIIIlIlI;
                    GlStateManager.popMatrix();
                }
            }
        }
    }
    
    private static Feature getNextEnabledModule(final ArrayList<Feature> llllllllllllllllIlIIlIlIllIlIIll, final int llllllllllllllllIlIIlIlIllIlIIlI) {
        for (int llllllllllllllllIlIIlIlIllIlIIIl = llllllllllllllllIlIIlIlIllIlIIlI; llllllllllllllllIlIIlIlIllIlIIIl < llllllllllllllllIlIIlIlIllIlIIll.size(); ++llllllllllllllllIlIIlIlIllIlIIIl) {
            final Feature llllllllllllllllIlIIlIlIllIlIIII = llllllllllllllllIlIIlIlIllIlIIll.get(llllllllllllllllIlIIlIlIllIlIIIl);
            if (llllllllllllllllIlIIlIlIllIlIIII.isToggled() && !llllllllllllllllIlIIlIlIllIlIIII.getModuleName().equals("ClickGui")) {
                return llllllllllllllllIlIIlIlIllIlIIII;
            }
        }
        return null;
    }
    
    public void renderArrayList(final ScaledResolution llllllllllllllllIlIIlIllIlIIlIII) {
        final double llllllllllllllllIlIIlIllIllIIIll = llllllllllllllllIlIIlIllIlIIlIII.getScaledWidth() - (ArreyList.rectRight.getBoolValue() ? 1 : 0);
        float llllllllllllllllIlIIlIllIllIIIlI = 1.0f;
        int llllllllllllllllIlIIlIllIllIIIIl = 0;
        for (int llllllllllllllllIlIIlIllIllIIIII = 0; llllllllllllllllIlIIlIllIllIIIII < Main.featureDirector.getFeatureList().size(); ++llllllllllllllllIlIIlIllIllIIIII) {
            llllllllllllllllIlIIlIllIllIIIIl += ClientHelper.getFontRender().getFontHeight() + 3;
        }
        if (Main.featureDirector.getFeatureByClass(ArreyList.class).isToggled()) {
            Main.featureDirector.getFeatureList().sort(Comparator.comparing(llllllllllllllllIlIIlIlIlIlllllI -> ClientFont.minecraftfont.getBoolValue() ? (-Minecraft.fontRendererObj.getStringWidth(llllllllllllllllIlIIlIlIlIlllllI.getModuleName())) : (-ClientHelper.getFontRender().getStringWidth(llllllllllllllllIlIIlIlIlIlllllI.getModuleName()))));
            for (final Feature llllllllllllllllIlIIlIllIlIlllll : Main.featureDirector.getFeatureList()) {
                if (!llllllllllllllllIlIIlIllIlIlllll.getModuleName().equals("ClickGui")) {
                    final Translate llllllllllllllllIlIIlIllIlIllllI = llllllllllllllllIlIIlIllIlIlllll.getTranslate();
                    final String llllllllllllllllIlIIlIllIlIlllIl = llllllllllllllllIlIIlIllIlIlllll.getModuleName();
                    final float llllllllllllllllIlIIlIllIlIlllII = ArreyList.height.getNumberValue();
                    final float llllllllllllllllIlIIlIllIlIllIll = (float)(ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(llllllllllllllllIlIIlIllIlIlllIl) : ClientHelper.getFontRender().getStringWidth(llllllllllllllllIlIIlIllIlIlllIl));
                    final float llllllllllllllllIlIIlIllIlIllIlI = (float)(llllllllllllllllIlIIlIllIllIIIll - llllllllllllllllIlIIlIllIlIllIll);
                    final boolean llllllllllllllllIlIIlIllIlIllIIl = llllllllllllllllIlIIlIllIlIlllll.isToggled();
                    if (llllllllllllllllIlIIlIllIlIllIIl) {
                        llllllllllllllllIlIIlIllIlIllllI.arrayListAnim(llllllllllllllllIlIIlIllIlIllIlI, llllllllllllllllIlIIlIllIllIIIlI, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    else {
                        llllllllllllllllIlIIlIllIlIllllI.arrayListAnim((float)llllllllllllllllIlIIlIllIllIIIll, llllllllllllllllIlIIlIllIllIIIlI, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    int llllllllllllllllIlIIlIllIlIllIII = 0;
                    for (final PotionEffect llllllllllllllllIlIIlIllIlIlIlll : HUD.mc.player.getActivePotionEffects()) {
                        if (llllllllllllllllIlIIlIllIlIlIlll.getPotion().isBeneficial()) {
                            llllllllllllllllIlIIlIllIlIllIII = 26;
                        }
                        if (llllllllllllllllIlIIlIllIlIlIlll.getPotion().isBadEffect()) {
                            llllllllllllllllIlIIlIllIlIllIII = 52;
                        }
                    }
                    final double llllllllllllllllIlIIlIllIlIlIllI = llllllllllllllllIlIIlIllIlIllllI.getY();
                    final double llllllllllllllllIlIIlIllIlIlIlIl = llllllllllllllllIlIIlIllIlIllllI.getX() - (ArreyList.rectRight.getBoolValue() ? 2.5 : 1.5);
                    int llllllllllllllllIlIIlIllIlIlIlII = 0;
                    final double llllllllllllllllIlIIlIllIlIlIIll = ArreyList.time.getNumberValue();
                    final String llllllllllllllllIlIIlIllIlIlIIlI = ArreyList.arrayColor.getOptions();
                    final boolean llllllllllllllllIlIIlIllIlIlIIIl = llllllllllllllllIlIIlIllIlIllllI.getX() < llllllllllllllllIlIIlIllIllIIIll;
                    if (!llllllllllllllllIlIIlIllIlIlIIIl) {
                        continue;
                    }
                    final Exception llllllllllllllllIlIIlIllIIllIlII;
                    switch (llllllllllllllllIlIIlIllIIllIlII = (Exception)llllllllllllllllIlIIlIllIlIlIIlI.toLowerCase()) {
                        case "custom": {
                            llllllllllllllllIlIIlIllIlIlIlII = DrawHelper.TwoColoreffect(new Color(ArreyList.onecolor.getColorValue()), new Color(ArreyList.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / (long)llllllllllllllllIlIIlIllIlIlIIll) / 100.0 + 3.0 * (llllllllllllllllIlIIlIllIllIIIlI * 2.55 / 60.0)).getRGB();
                            break;
                        }
                        case "astolfo": {
                            llllllllllllllllIlIIlIllIlIlIlII = DrawHelper.astolfoColors45(llllllllllllllllIlIIlIllIllIIIlI, (float)llllllllllllllllIlIIlIllIllIIIIl, 0.5f, 5.0f).getRGB();
                            break;
                        }
                        case "none": {
                            llllllllllllllllIlIIlIllIlIlIlII = -1;
                            break;
                        }
                        case "pulse": {
                            llllllllllllllllIlIIlIllIlIlIlII = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / llllllllllllllllIlIIlIllIlIlIIll) / 100.0 + 6.0 * (llllllllllllllllIlIIlIllIllIIIlI * 2.55) / 60.0).getRGB();
                            break;
                        }
                        case "rainbow": {
                            llllllllllllllllIlIIlIllIlIlIlII = DrawHelper.rainbowNew((int)(llllllllllllllllIlIIlIllIllIIIlI * 200.0f * 0.1f), 0.8f, 1.0f);
                            break;
                        }
                        default:
                            break;
                    }
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(-ArreyList.x.getNumberValue(), ArreyList.y.getNumberValue(), 1.0);
                    if (ArreyList.backGround.getBoolValue()) {
                        DrawHelper.drawNewRect(llllllllllllllllIlIIlIllIlIlIlIl - 2.0, llllllllllllllllIlIIlIllIlIlIllI - 1.0, llllllllllllllllIlIIlIllIllIIIll, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII - 1.0, DrawHelper.setAlpha(new Color(ArreyList.backGroundColor.getColorValue()), (int)ArreyList.backGroundAlpha.getNumberValue()).getRGB());
                    }
                    if (ArreyList.border.getBoolValue()) {
                        DrawHelper.drawNewRect(llllllllllllllllIlIIlIllIlIlIlIl - 2.6, llllllllllllllllIlIIlIllIlIlIllI - 1.0, llllllllllllllllIlIIlIllIlIlIlIl - 2.0, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII - 1.0, llllllllllllllllIlIIlIllIlIlIlII);
                    }
                    if (ArreyList.shadow.getBoolValue()) {
                        DrawHelper.drawGlow(llllllllllllllllIlIIlIllIlIlIlIl + 2.0, llllllllllllllllIlIIlIllIlIlIllI - 6.0, llllllllllllllllIlIIlIllIllIIIll, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII + 5.0, ArreyList.shadowcolor.getColorValue());
                    }
                    Feature llllllllllllllllIlIIlIllIlIlIIII = null;
                    final int llllllllllllllllIlIIlIllIlIIllll = Main.featureDirector.getFeatureList().indexOf(llllllllllllllllIlIIlIllIlIlllll) + 1;
                    if (Main.featureDirector.getFeatureList().size() > llllllllllllllllIlIIlIllIlIIllll) {
                        llllllllllllllllIlIIlIllIlIlIIII = getNextEnabledModule((ArrayList)Main.featureDirector.getFeatureList(), llllllllllllllllIlIIlIllIlIIllll);
                    }
                    if (!ClientFont.minecraftfont.getBoolValue()) {
                        final String llllllllllllllllIlIIlIllIlIIlllI = ClientFont.fontMode.getOptions();
                        final float llllllllllllllllIlIIlIllIlIIllIl = ArreyList.fonty.getNumberValue();
                        if (!ClientFont.minecraftfont.getBoolValue()) {
                            ClientHelper.getFontRender().drawStringWithShadow(llllllllllllllllIlIIlIllIlIlllIl, llllllllllllllllIlIIlIllIlIlIlIl - 0.5, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIIllIl - 1.0, llllllllllllllllIlIIlIllIlIlIlII);
                        }
                    }
                    else {
                        Minecraft.fontRendererObj.drawStringWithShadow(llllllllllllllllIlIIlIllIlIlllIl, (float)llllllllllllllllIlIIlIllIlIlIlIl, (float)llllllllllllllllIlIIlIllIlIlIllI + 1.0f, llllllllllllllllIlIIlIllIlIlIlII);
                    }
                    if (ArreyList.rectRight.getBoolValue()) {
                        DrawHelper.drawNewRect(llllllllllllllllIlIIlIllIllIIIll, llllllllllllllllIlIIlIllIlIlIllI - 1.0, llllllllllllllllIlIIlIllIllIIIll + 1.0, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII - 1.0, llllllllllllllllIlIIlIllIlIlIlII);
                    }
                    if (llllllllllllllllIlIIlIllIlIlIIII != null) {
                        final double llllllllllllllllIlIIlIllIlIIllII = ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(llllllllllllllllIlIIlIllIlIlIIII.getModuleName()) : ClientHelper.getFontRender().getStringWidth(llllllllllllllllIlIIlIllIlIlIIII.getModuleName());
                        final double llllllllllllllllIlIIlIllIlIIlIll = llllllllllllllllIlIIlIllIlIllIll - llllllllllllllllIlIIlIllIlIIllII;
                        if (ArreyList.border.getBoolValue()) {
                            final String llllllllllllllllIlIIlIllIlIIlIlI = ArreyList.borderMode.getOptions();
                            if (llllllllllllllllIlIIlIllIlIIlIlI.equalsIgnoreCase("All")) {
                                DrawHelper.drawNewRect(llllllllllllllllIlIIlIllIlIlIlIl - 2.6, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII - 1.0, llllllllllllllllIlIIlIllIllIIIll, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII - 0.6, llllllllllllllllIlIIlIllIlIlIlII);
                            }
                            if (llllllllllllllllIlIIlIllIlIIlIlI.equalsIgnoreCase("Single")) {
                                DrawHelper.drawNewRect(llllllllllllllllIlIIlIllIlIlIlIl - 2.0, llllllllllllllllIlIIlIllIlIlIllI - 1.0, llllllllllllllllIlIIlIllIlIlIlIl - 1.0, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII - 1.0, llllllllllllllllIlIIlIllIlIlIlII);
                            }
                        }
                    }
                    else {
                        final String llllllllllllllllIlIIlIllIlIIlIIl = ArreyList.borderMode.getOptions();
                        if (ArreyList.border.getBoolValue()) {
                            if (llllllllllllllllIlIIlIllIlIIlIIl.equalsIgnoreCase("All")) {
                                DrawHelper.drawNewRect(llllllllllllllllIlIIlIllIlIlIlIl - 2.6, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII - 1.0, llllllllllllllllIlIIlIllIllIIIll, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII - 0.6, llllllllllllllllIlIIlIllIlIlIlII);
                            }
                            if (llllllllllllllllIlIIlIllIlIIlIIl.equalsIgnoreCase("Single")) {
                                DrawHelper.drawNewRect(llllllllllllllllIlIIlIllIlIlIlIl - 2.0, llllllllllllllllIlIIlIllIlIlIllI - 1.0, llllllllllllllllIlIIlIllIlIlIlIl - 1.0, llllllllllllllllIlIIlIllIlIlIllI + llllllllllllllllIlIIlIllIlIlllII - 1.0, llllllllllllllllIlIIlIllIlIlIlII);
                            }
                        }
                    }
                    llllllllllllllllIlIIlIllIllIIIlI += llllllllllllllllIlIIlIllIlIlllII;
                    GlStateManager.popMatrix();
                }
            }
        }
    }
    
    public void hotBar() {
        if (!Main.featureDirector.getFeatureByClass(Hotbar.class).isToggled()) {
            final String llllllllllllllllIlIIlIlllIIllllI = (String)new ScaledResolution(HUD.mc);
        }
    }
    
    public HUD() {
        super("HUD", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044e \u043d\u0430 \u044d\u043a\u0440\u0430\u043d\u0435", 0, Category.DISPLAY);
        this.xd = 0.0f;
        this.potionCheck = 0.0;
        this.sr = new ScaledResolution(HUD.mc);
        this.width = this.sr.getScaledWidth() - 2;
        this.listOffset = 8.0f;
        this.yDist = 4.0f;
        this.yTotal = 0;
        this.nextModule = null;
        this.colorArray = -1;
    }
}
