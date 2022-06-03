// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable.impl;

import ru.rockstar.api.utils.render.Translate;
import java.util.ArrayList;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.potion.PotionEffect;
import java.util.Comparator;
import ru.rockstar.client.features.impl.display.KeyBinds;
import ru.rockstar.Main;
import ru.rockstar.client.features.impl.display.ArreyList;
import ru.rockstar.api.utils.render.ClientHelper;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.features.impl.display.ClientFont;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.ui.draggable.DraggableModule;

public class KeyBindsComponent extends DraggableModule
{
    public /* synthetic */ int lastA;
    public /* synthetic */ int lastJ;
    public /* synthetic */ int lastS2;
    public /* synthetic */ int lastW;
    public /* synthetic */ int lastS;
    public static /* synthetic */ int x;
    public /* synthetic */ int lastD;
    /* synthetic */ float listOffset;
    public static /* synthetic */ int y;
    
    public KeyBindsComponent() {
        super("KeyBindsComponent", 500, 500);
        this.lastA = 0;
        this.lastW = 0;
        this.lastS = 0;
        this.lastD = 0;
        this.lastJ = 0;
        this.lastS2 = 0;
        this.listOffset = 8.0f;
    }
    
    @Override
    public int getHeight() {
        return 100;
    }
    
    @Override
    public int getWidth() {
        return 100;
    }
    
    @Override
    public void draw() {
        final double lllllllllllllllIIlIllIIIIIIIIlIl = KeyBindsComponent.sr.getScaledWidth() - (ArreyList.rectRight.getBoolValue() ? 1 : 0);
        float lllllllllllllllIIlIllIIIIIIIIlII = 1.0f;
        int lllllllllllllllIIlIllIIIIIIIIIll = 0;
        for (int lllllllllllllllIIlIllIIIIIIIIIlI = 0; lllllllllllllllIIlIllIIIIIIIIIlI < Main.featureDirector.getFeatureList().size(); ++lllllllllllllllIIlIllIIIIIIIIIlI) {
            lllllllllllllllIIlIllIIIIIIIIIll += ClientHelper.getFontRender().getFontHeight() + 3;
        }
        if (Main.featureDirector.getFeatureByClass(KeyBinds.class).isToggled()) {
            Main.featureDirector.getFeatureList().sort(Comparator.comparing(lllllllllllllllIIlIlIlllllIIlllI -> ClientFont.minecraftfont.getBoolValue() ? (-Minecraft.fontRendererObj.getStringWidth(lllllllllllllllIIlIlIlllllIIlllI.getModuleName())) : (-ClientHelper.getFontRender().getStringWidth(lllllllllllllllIIlIlIlllllIIlllI.getModuleName()))));
            for (final Feature lllllllllllllllIIlIllIIIIIIIIIIl : Main.featureDirector.getFeatureList()) {
                if (!lllllllllllllllIIlIllIIIIIIIIIIl.getModuleName().equals("ClickGui") && lllllllllllllllIIlIllIIIIIIIIIIl.getKey() != 0) {
                    final Translate lllllllllllllllIIlIllIIIIIIIIIII = lllllllllllllllIIlIllIIIIIIIIIIl.getTranslate();
                    final String lllllllllllllllIIlIlIlllllllllll = lllllllllllllllIIlIllIIIIIIIIIIl.getModuleName();
                    final float lllllllllllllllIIlIlIllllllllllI = (float)(ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(lllllllllllllllIIlIlIlllllllllll) : ClientHelper.getFontRender().getStringWidth(lllllllllllllllIIlIlIlllllllllll));
                    final float lllllllllllllllIIlIlIlllllllllIl = (float)(lllllllllllllllIIlIllIIIIIIIIlIl - lllllllllllllllIIlIlIllllllllllI);
                    final boolean lllllllllllllllIIlIlIlllllllllII = lllllllllllllllIIlIllIIIIIIIIIIl.isToggled();
                    if (lllllllllllllllIIlIlIlllllllllII) {
                        lllllllllllllllIIlIllIIIIIIIIIII.arrayListAnim(lllllllllllllllIIlIlIlllllllllIl, lllllllllllllllIIlIllIIIIIIIIlII, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    else {
                        lllllllllllllllIIlIllIIIIIIIIIII.arrayListAnim((float)lllllllllllllllIIlIllIIIIIIIIlIl, lllllllllllllllIIlIllIIIIIIIIlII, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    KeyBindsComponent.x = this.getX();
                    KeyBindsComponent.y = this.getY();
                    final double lllllllllllllllIIlIlIllllllllIll = lllllllllllllllIIlIllIIIIIIIIIII.getY();
                    final float lllllllllllllllIIlIlIllllllllIlI = KeyBinds.fonty.getNumberValue();
                    int lllllllllllllllIIlIlIllllllllIIl = 0;
                    for (final PotionEffect lllllllllllllllIIlIlIllllllllIII : this.mc.player.getActivePotionEffects()) {
                        if (lllllllllllllllIIlIlIllllllllIII.getPotion().isBeneficial()) {
                            lllllllllllllllIIlIlIllllllllIIl = 26;
                        }
                        if (lllllllllllllllIIlIlIllllllllIII.getPotion().isBadEffect()) {
                            lllllllllllllllIIlIlIllllllllIIl = 52;
                        }
                    }
                    final double lllllllllllllllIIlIlIlllllllIlll = lllllllllllllllIIlIllIIIIIIIIIII.getX() + 1.5;
                    int lllllllllllllllIIlIlIlllllllIllI = 0;
                    final double lllllllllllllllIIlIlIlllllllIlIl = KeyBinds.time.getNumberValue();
                    final String lllllllllllllllIIlIlIlllllllIlII = KeyBinds.arrayColor.getOptions();
                    final boolean lllllllllllllllIIlIlIlllllllIIll = lllllllllllllllIIlIllIIIIIIIIIII.getX() < lllllllllllllllIIlIllIIIIIIIIlIl;
                    if (!lllllllllllllllIIlIlIlllllllIIll) {
                        continue;
                    }
                    final char lllllllllllllllIIlIlIlllllIllIlI;
                    switch (((String)(lllllllllllllllIIlIlIlllllIllIlI = (char)lllllllllllllllIIlIlIlllllllIlII.toLowerCase())).hashCode()) {
                        case -1349088399: {
                            if (!((String)lllllllllllllllIIlIlIlllllIllIlI).equals("custom")) {
                                break;
                            }
                            lllllllllllllllIIlIlIlllllllIllI = DrawHelper.TwoColoreffect(new Color(ArreyList.onecolor.getColorValue()), new Color(ArreyList.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / (long)lllllllllllllllIIlIlIlllllllIlIl) / 100.0 + 3.0 * (lllllllllllllllIIlIllIIIIIIIIlII * 2.55 / 60.0)).getRGB();
                            break;
                        }
                        case -703561496: {
                            if (!((String)lllllllllllllllIIlIlIlllllIllIlI).equals("astolfo")) {
                                break;
                            }
                            lllllllllllllllIIlIlIlllllllIllI = DrawHelper.astolfoColors45(lllllllllllllllIIlIllIIIIIIIIlII, (float)lllllllllllllllIIlIllIIIIIIIIIll, 0.5f, 5.0f).getRGB();
                            break;
                        }
                        case 3387192: {
                            if (!((String)lllllllllllllllIIlIlIlllllIllIlI).equals("none")) {
                                break;
                            }
                            lllllllllllllllIIlIlIlllllllIllI = -1;
                            break;
                        }
                        case 107027353: {
                            if (!((String)lllllllllllllllIIlIlIlllllIllIlI).equals("pulse")) {
                                break;
                            }
                            lllllllllllllllIIlIlIlllllllIllI = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / lllllllllllllllIIlIlIlllllllIlIl) / 100.0 + 6.0 * (lllllllllllllllIIlIllIIIIIIIIlII * 2.55) / 60.0).getRGB();
                            break;
                        }
                        case 973576630: {
                            if (!((String)lllllllllllllllIIlIlIlllllIllIlI).equals("rainbow")) {
                                break;
                            }
                            lllllllllllllllIIlIlIlllllllIllI = DrawHelper.rainbowNew((int)(lllllllllllllllIIlIllIIIIIIIIlII * 200.0f * 0.1f), 0.8f, 1.0f);
                            break;
                        }
                    }
                    GlStateManager.pushMatrix();
                    DrawHelper.drawRect(KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x - 14 + 123, lllllllllllllllIIlIlIllllllllIlI - 1.0f, KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x + 14 + 197, lllllllllllllllIIlIlIllllllllIlI + 9.0f, new Color(30, 30, 30, 255).getRGB());
                    DrawHelper.drawGradientRect1(KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x - 14 + 120, lllllllllllllllIIlIlIllllllllIlI - 15.0f, KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x + 14 + 200, lllllllllllllllIIlIlIllllllllIlI - 1.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                    this.mc.mntsb_16.drawStringWithShadow("KeyBinds", KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x - 10 + 130 + this.mc.mntsb.getStringWidth("KeyBinds") / 2, lllllllllllllllIIlIlIllllllllIlI - 10.0f, -1);
                    GlStateManager.translate(-KeyBinds.x.getNumberValue(), KeyBinds.y.getNumberValue(), 1.0);
                    Feature lllllllllllllllIIlIlIlllllllIIlI = null;
                    final int lllllllllllllllIIlIlIlllllllIIIl = Main.featureDirector.getFeatureList().indexOf(lllllllllllllllIIlIllIIIIIIIIIIl) + 1;
                    if (Main.featureDirector.getFeatureList().size() > lllllllllllllllIIlIlIlllllllIIIl) {
                        lllllllllllllllIIlIlIlllllllIIlI = getNextEnabledModule((ArrayList)Main.featureDirector.getFeatureList(), lllllllllllllllIIlIlIlllllllIIIl);
                    }
                    final String lllllllllllllllIIlIlIlllllllIIII = ClientFont.fontMode.getOptions();
                    if (lllllllllllllllIIlIlIlllllllIIlI != null) {
                        final double lllllllllllllllIIlIlIllllllIllll = ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(lllllllllllllllIIlIlIlllllllIIlI.getModuleName()) : ClientHelper.getFontRender().getStringWidth(lllllllllllllllIIlIlIlllllllIIlI.getModuleName());
                        final Exception lllllllllllllllIIlIlIlllllIlIlIl = (Exception)(lllllllllllllllIIlIlIllllllllllI - lllllllllllllllIIlIlIllllllIllll);
                    }
                    lllllllllllllllIIlIllIIIIIIIIlII += this.listOffset;
                    GlStateManager.popMatrix();
                }
            }
        }
        super.draw();
    }
    
    private static Feature getNextEnabledModule(final ArrayList<Feature> lllllllllllllllIIlIllIIIIIlIlIII, final int lllllllllllllllIIlIllIIIIIlIIlll) {
        for (int lllllllllllllllIIlIllIIIIIlIIllI = lllllllllllllllIIlIllIIIIIlIIlll; lllllllllllllllIIlIllIIIIIlIIllI < lllllllllllllllIIlIllIIIIIlIlIII.size(); ++lllllllllllllllIIlIllIIIIIlIIllI) {
            final Feature lllllllllllllllIIlIllIIIIIlIIlIl = lllllllllllllllIIlIllIIIIIlIlIII.get(lllllllllllllllIIlIllIIIIIlIIllI);
            if (lllllllllllllllIIlIllIIIIIlIIlIl.isToggled() && !lllllllllllllllIIlIllIIIIIlIIlIl.getModuleName().equals("ClickGui")) {
                return lllllllllllllllIIlIllIIIIIlIIlIl;
            }
        }
        return null;
    }
    
    @Override
    public void render(final int lllllllllllllllIIlIllIIIIllIIIIl, final int lllllllllllllllIIlIllIIIIllIIIII) {
        final double lllllllllllllllIIlIllIIIIlIlllll = KeyBindsComponent.sr.getScaledWidth() - (ArreyList.rectRight.getBoolValue() ? 1 : 0);
        float lllllllllllllllIIlIllIIIIlIllllI = 1.0f;
        int lllllllllllllllIIlIllIIIIlIlllIl = 0;
        for (int lllllllllllllllIIlIllIIIIlIlllII = 0; lllllllllllllllIIlIllIIIIlIlllII < Main.featureDirector.getFeatureList().size(); ++lllllllllllllllIIlIllIIIIlIlllII) {
            lllllllllllllllIIlIllIIIIlIlllIl += ClientHelper.getFontRender().getFontHeight() + 3;
        }
        if (Main.featureDirector.getFeatureByClass(KeyBinds.class).isToggled()) {
            Main.featureDirector.getFeatureList().sort(Comparator.comparing(lllllllllllllllIIlIlIlllllIlIIlI -> ClientFont.minecraftfont.getBoolValue() ? (-Minecraft.fontRendererObj.getStringWidth(lllllllllllllllIIlIlIlllllIlIIlI.getModuleName())) : (-ClientHelper.getFontRender().getStringWidth(lllllllllllllllIIlIlIlllllIlIIlI.getModuleName()))));
            for (final Feature lllllllllllllllIIlIllIIIIlIllIll : Main.featureDirector.getFeatureList()) {
                if (!lllllllllllllllIIlIllIIIIlIllIll.getModuleName().equals("ClickGui") && lllllllllllllllIIlIllIIIIlIllIll.getKey() != 0) {
                    final Translate lllllllllllllllIIlIllIIIIlIllIlI = lllllllllllllllIIlIllIIIIlIllIll.getTranslate();
                    final String lllllllllllllllIIlIllIIIIlIllIIl = lllllllllllllllIIlIllIIIIlIllIll.getModuleName();
                    final float lllllllllllllllIIlIllIIIIlIllIII = (float)(ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(lllllllllllllllIIlIllIIIIlIllIIl) : ClientHelper.getFontRender().getStringWidth(lllllllllllllllIIlIllIIIIlIllIIl));
                    final float lllllllllllllllIIlIllIIIIlIlIlll = (float)(lllllllllllllllIIlIllIIIIlIlllll - lllllllllllllllIIlIllIIIIlIllIII);
                    final boolean lllllllllllllllIIlIllIIIIlIlIllI = lllllllllllllllIIlIllIIIIlIllIll.isToggled();
                    if (lllllllllllllllIIlIllIIIIlIlIllI) {
                        lllllllllllllllIIlIllIIIIlIllIlI.arrayListAnim(lllllllllllllllIIlIllIIIIlIlIlll, lllllllllllllllIIlIllIIIIlIllllI, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    else {
                        lllllllllllllllIIlIllIIIIlIllIlI.arrayListAnim((float)lllllllllllllllIIlIllIIIIlIlllll, lllllllllllllllIIlIllIIIIlIllllI, (float)(0.10000000149011612 * Minecraft.frameTime) / 6.0f, (float)(0.30000001192092896 * Minecraft.frameTime) / 6.0f);
                    }
                    KeyBindsComponent.x = this.getX();
                    KeyBindsComponent.y = this.getY();
                    final double lllllllllllllllIIlIllIIIIlIlIlIl = lllllllllllllllIIlIllIIIIlIllIlI.getY();
                    final float lllllllllllllllIIlIllIIIIlIlIlII = KeyBinds.fonty.getNumberValue();
                    int lllllllllllllllIIlIllIIIIlIlIIll = 0;
                    for (final PotionEffect lllllllllllllllIIlIllIIIIlIlIIlI : this.mc.player.getActivePotionEffects()) {
                        if (lllllllllllllllIIlIllIIIIlIlIIlI.getPotion().isBeneficial()) {
                            lllllllllllllllIIlIllIIIIlIlIIll = 26;
                        }
                        if (lllllllllllllllIIlIllIIIIlIlIIlI.getPotion().isBadEffect()) {
                            lllllllllllllllIIlIllIIIIlIlIIll = 52;
                        }
                    }
                    final double lllllllllllllllIIlIllIIIIlIlIIIl = lllllllllllllllIIlIllIIIIlIllIlI.getX() + 1.5;
                    int lllllllllllllllIIlIllIIIIlIlIIII = 0;
                    final double lllllllllllllllIIlIllIIIIlIIllll = KeyBinds.time.getNumberValue();
                    final String lllllllllllllllIIlIllIIIIlIIlllI = KeyBinds.arrayColor.getOptions();
                    final boolean lllllllllllllllIIlIllIIIIlIIllIl = lllllllllllllllIIlIllIIIIlIllIlI.getX() < lllllllllllllllIIlIllIIIIlIlllll;
                    if (!lllllllllllllllIIlIllIIIIlIIllIl) {
                        continue;
                    }
                    final String lllllllllllllllIIlIllIIIIIllIIlI;
                    switch (lllllllllllllllIIlIllIIIIIllIIlI = lllllllllllllllIIlIllIIIIlIIlllI.toLowerCase()) {
                        case "custom": {
                            lllllllllllllllIIlIllIIIIlIlIIII = DrawHelper.TwoColoreffect(new Color(ArreyList.onecolor.getColorValue()), new Color(ArreyList.twocolor.getColorValue()), Math.abs(System.currentTimeMillis() / (long)lllllllllllllllIIlIllIIIIlIIllll) / 100.0 + 3.0 * (lllllllllllllllIIlIllIIIIlIllllI * 2.55 / 60.0)).getRGB();
                            break;
                        }
                        case "astolfo": {
                            lllllllllllllllIIlIllIIIIlIlIIII = DrawHelper.astolfoColors45(lllllllllllllllIIlIllIIIIlIllllI, (float)lllllllllllllllIIlIllIIIIlIlllIl, 0.5f, 5.0f).getRGB();
                            break;
                        }
                        case "none": {
                            lllllllllllllllIIlIllIIIIlIlIIII = -1;
                            break;
                        }
                        case "pulse": {
                            lllllllllllllllIIlIllIIIIlIlIIII = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / lllllllllllllllIIlIllIIIIlIIllll) / 100.0 + 6.0 * (lllllllllllllllIIlIllIIIIlIllllI * 2.55) / 60.0).getRGB();
                            break;
                        }
                        case "rainbow": {
                            lllllllllllllllIIlIllIIIIlIlIIII = DrawHelper.rainbowNew((int)(lllllllllllllllIIlIllIIIIlIllllI * 200.0f * 0.1f), 0.8f, 1.0f);
                            break;
                        }
                        default:
                            break;
                    }
                    GlStateManager.pushMatrix();
                    DrawHelper.drawRect(KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x - 14 + 123, lllllllllllllllIIlIllIIIIlIlIlII - 1.0f, KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x + 14 + 197, lllllllllllllllIIlIllIIIIlIlIlII + 9.0f, new Color(30, 30, 30, 255).getRGB());
                    DrawHelper.drawGradientRect1(KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x - 14 + 120, lllllllllllllllIIlIllIIIIlIlIlII - 15.0f, KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x + 14 + 200, lllllllllllllllIIlIllIIIIlIlIlII - 1.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                    this.mc.mntsb_16.drawStringWithShadow("KeyBinds", KeyBindsComponent.sr.getScaledHeight() - KeyBindsComponent.x - 10 + 130 + this.mc.mntsb.getStringWidth("KeyBinds") / 2, lllllllllllllllIIlIllIIIIlIlIlII - 10.0f, -1);
                    GlStateManager.translate(-KeyBinds.x.getNumberValue(), KeyBinds.y.getNumberValue(), 1.0);
                    Feature lllllllllllllllIIlIllIIIIlIIllII = null;
                    final int lllllllllllllllIIlIllIIIIlIIlIll = Main.featureDirector.getFeatureList().indexOf(lllllllllllllllIIlIllIIIIlIllIll) + 1;
                    if (Main.featureDirector.getFeatureList().size() > lllllllllllllllIIlIllIIIIlIIlIll) {
                        lllllllllllllllIIlIllIIIIlIIllII = getNextEnabledModule((ArrayList)Main.featureDirector.getFeatureList(), lllllllllllllllIIlIllIIIIlIIlIll);
                    }
                    final String lllllllllllllllIIlIllIIIIlIIlIlI = ClientFont.fontMode.getOptions();
                    if (lllllllllllllllIIlIllIIIIlIIllII != null) {
                        final double lllllllllllllllIIlIllIIIIlIIlIIl = ClientFont.minecraftfont.getBoolValue() ? Minecraft.fontRendererObj.getStringWidth(lllllllllllllllIIlIllIIIIlIIllII.getModuleName()) : ClientHelper.getFontRender().getStringWidth(lllllllllllllllIIlIllIIIIlIIllII.getModuleName());
                        final Exception lllllllllllllllIIlIllIIIIIlIllIl = (Exception)(lllllllllllllllIIlIllIIIIlIllIII - lllllllllllllllIIlIllIIIIlIIlIIl);
                    }
                    lllllllllllllllIIlIllIIIIlIllllI += this.listOffset;
                    GlStateManager.popMatrix();
                }
            }
        }
        super.render(lllllllllllllllIIlIllIIIIllIIIIl, lllllllllllllllIIlIllIIIIllIIIII);
    }
}
