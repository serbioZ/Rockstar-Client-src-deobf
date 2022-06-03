// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui.component.impl;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.api.utils.render.AnimationHelper;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClickGUI;
import ru.rockstar.api.utils.math.MathematicHelper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.clickgui.component.PropertyComponent;
import ru.rockstar.client.ui.clickgui.component.Component;

public class NumberSettingComponent extends Component implements PropertyComponent
{
    private /* synthetic */ boolean sliding;
    public /* synthetic */ NumberSetting numberSetting;
    public /* synthetic */ float currentValueAnimate;
    /* synthetic */ Minecraft mc;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType;
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllIIIlIIIIllllIIlllIlII, final int lllllllllllIIIlIIIIllllIIlllIIll, final int lllllllllllIIIlIIIIllllIIlIlllll) {
        super.drawComponent(lllllllllllIIIlIIIIllllIIlllIlII, lllllllllllIIIlIIIIllllIIlllIIll, lllllllllllIIIlIIIIllllIIlIlllll);
        final int lllllllllllIIIlIIIIllllIIlllIIIl = this.getX();
        final int lllllllllllIIIlIIIIllllIIlllIIII = this.getY();
        final int lllllllllllIIIlIIIIllllIIllIllll = this.getWidth();
        final int lllllllllllIIIlIIIIllllIIllIlllI = this.getHeight();
        final double lllllllllllIIIlIIIIllllIIllIllIl = this.numberSetting.getMinValue();
        final double lllllllllllIIIlIIIIllllIIllIllII = this.numberSetting.getMaxValue();
        final boolean lllllllllllIIIlIIIIllllIIllIlIll = this.isHovered(lllllllllllIIIlIIIIllllIIlllIIll, lllllllllllIIIlIIIIllllIIlIlllll);
        if (this.sliding) {
            this.numberSetting.setValueNumber((float)MathematicHelper.round((lllllllllllIIIlIIIIllllIIlllIIll - lllllllllllIIIlIIIIllllIIlllIIIl) * (lllllllllllIIIlIIIIllllIIllIllII - lllllllllllIIIlIIIIllllIIllIllIl) / lllllllllllIIIlIIIIllllIIllIllll + lllllllllllIIIlIIIIllllIIllIllIl, this.numberSetting.getIncrement()));
            if (this.numberSetting.getNumberValue() > lllllllllllIIIlIIIIllllIIllIllII) {
                this.numberSetting.setValueNumber((float)lllllllllllIIIlIIIIllllIIllIllII);
            }
            else if (this.numberSetting.getNumberValue() < lllllllllllIIIlIIIIllllIIllIllIl) {
                this.numberSetting.setValueNumber((float)lllllllllllIIIlIIIIllllIIllIllIl);
            }
        }
        final float lllllllllllIIIlIIIIllllIIllIlIlI = (float)((this.numberSetting.getNumberValue() - lllllllllllIIIlIIIIllllIIllIllIl) / (lllllllllllIIIlIIIIllllIIllIllII - lllllllllllIIIlIIIIllllIIllIllIl));
        int lllllllllllIIIlIIIIllllIIllIlIIl = 0;
        final Color lllllllllllIIIlIIIIllllIIllIlIII = new Color(ClickGUI.color.getColorValue());
        final Color lllllllllllIIIlIIIIllllIIllIIlll = new Color(ClickGUI.colorTwo.getColorValue());
        final double lllllllllllIIIlIIIIllllIIllIIllI = ClickGUI.speed.getNumberValue();
        final long lllllllllllIIIlIIIIllllIIlIlIIlI;
        switch (((String)(lllllllllllIIIlIIIIllllIIlIlIIlI = (long)ClickGUI.clickGuiColor.currentMode)).hashCode()) {
            case -1808614770: {
                if (!((String)lllllllllllIIIlIIIIllllIIlIlIIlI).equals("Static")) {
                    break;
                }
                lllllllllllIIIlIIIIllllIIllIlIIl = lllllllllllIIIlIIIIllllIIllIlIII.getRGB();
                break;
            }
            case -1656737386: {
                if (!((String)lllllllllllIIIlIIIIllllIIlIlIIlI).equals("Rainbow")) {
                    break;
                }
                lllllllllllIIIlIIIIllllIIllIlIIl = DrawHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                break;
            }
            case -311641137: {
                if (!((String)lllllllllllIIIlIIIIllllIIlIlIIlI).equals("Color Two")) {
                    break;
                }
                lllllllllllIIIlIIIIllllIIllIlIIl = DrawHelper.fadeColor(lllllllllllIIIlIIIIllllIIllIlIII.getRGB(), lllllllllllIIIlIIIIllllIIllIIlll.getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIIlIIIIllllIIllIIllI / lllllllllllIIIlIIIIllllIIllIIllI + lllllllllllIIIlIIIIllllIIlllIIII * 6L / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
            case 2181788: {
                if (!((String)lllllllllllIIIlIIIIllllIIlIlIIlI).equals("Fade")) {
                    break;
                }
                lllllllllllIIIlIIIIllllIIllIlIIl = DrawHelper.fadeColor(lllllllllllIIIlIIIIllllIIllIlIII.getRGB(), lllllllllllIIIlIIIIllllIIllIlIII.darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIIlIIIIllllIIllIIllI / lllllllllllIIIlIIIIllllIIllIIllI + lllllllllllIIIlIIIIllllIIlllIIII * 6L / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
            case 961091784: {
                if (!((String)lllllllllllIIIlIIIIllllIIlIlIIlI).equals("Astolfo")) {
                    break;
                }
                lllllllllllIIIlIIIIllllIIllIlIIl = DrawHelper.astolfo(true, lllllllllllIIIlIIIIllllIIlllIIII).getRGB();
                break;
            }
            case 2021122027: {
                if (!((String)lllllllllllIIIlIIIIllllIIlIlIIlI).equals("Client")) {
                    break;
                }
                lllllllllllIIIlIIIIllllIIllIlIIl = DrawHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIIlIIIIllllIIllIIllI / lllllllllllIIIlIIIIllllIIllIIllI + lllllllllllIIIlIIIIllllIIlllIIII * 6L / 60L * 2L) % 2.0 - 1.0));
                break;
            }
        }
        this.currentValueAnimate = AnimationHelper.animation(this.currentValueAnimate, lllllllllllIIIlIIIIllllIIllIlIlI, 0.0f);
        final float lllllllllllIIIlIIIIllllIIllIIlIl = (float)MathematicHelper.round(this.numberSetting.getNumberValue(), this.numberSetting.getIncrement());
        DrawHelper.drawRect(lllllllllllIIIlIIIIllllIIlllIIIl + 3, lllllllllllIIIlIIIIllllIIlllIIII + lllllllllllIIIlIIIIllllIIllIlllI - 5, lllllllllllIIIlIIIIllllIIlllIIIl + (lllllllllllIIIlIIIIllllIIllIllll - 3), lllllllllllIIIlIIIIllllIIlllIIII + 13, new Color(40, 39, 39).getRGB());
        DrawHelper.drawRect(lllllllllllIIIlIIIIllllIIlllIIIl + 3, lllllllllllIIIlIIIIllllIIlllIIII + 13.5, lllllllllllIIIlIIIIllllIIlllIIIl + 5 + this.currentValueAnimate * (lllllllllllIIIlIIIIllllIIllIllll - 9), lllllllllllIIIlIIIIllllIIlllIIII + 15.0f, lllllllllllIIIlIIIIllllIIllIlIIl);
        DrawHelper.drawFilledCircle((int)(lllllllllllIIIlIIIIllllIIlllIIIl + 5 + this.currentValueAnimate * (lllllllllllIIIlIIIIllllIIllIllll - 8)), (int)(lllllllllllIIIlIIIIllllIIlllIIII + 14.0f), 2.0f, new Color(255, 255, 255));
        String lllllllllllIIIlIIIIllllIIllIIlII = "";
        final NumberSetting.NumberType lllllllllllIIIlIIIIllllIIllIIIll = this.numberSetting.getType();
        switch ($SWITCH_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType()[lllllllllllIIIlIIIIllllIIllIIIll.ordinal()]) {
            case 4: {
                lllllllllllIIIlIIIIllllIIllIIlII = String.valueOf(lllllllllllIIIlIIIIllllIIllIIlII) + '%';
                break;
            }
            case 1: {
                lllllllllllIIIlIIIIllllIIllIIlII = String.valueOf(lllllllllllIIIlIIIIllllIIllIIlII) + "ms";
                break;
            }
            case 5: {
                lllllllllllIIIlIIIIllllIIllIIlII = String.valueOf(lllllllllllIIIlIIIIllllIIllIIlII) + 'm';
            }
            case 3: {
                lllllllllllIIIlIIIIllllIIllIIlII = String.valueOf(lllllllllllIIIlIIIIllllIIllIIlII) + "SIZE";
            }
            case 2: {
                lllllllllllIIIlIIIIllllIIllIIlII = String.valueOf(lllllllllllIIIlIIIIllllIIllIIlII) + "APS";
                break;
            }
            default: {
                lllllllllllIIIlIIIIllllIIllIIlII = "";
                break;
            }
        }
        this.mc.neverlose500_13.drawString(this.numberSetting.getName(), lllllllllllIIIlIIIIllllIIlllIIIl + 2.0f, lllllllllllIIIlIIIIllllIIlllIIII + lllllllllllIIIlIIIIllllIIllIlllI / 2.5f - 4.0f, Color.lightGray.getRGB());
        this.mc.neverlose500_15.drawString(String.valueOf(lllllllllllIIIlIIIIllllIIllIIlIl) + " " + lllllllllllIIIlIIIIllllIIllIIlII, (float)(lllllllllllIIIlIIIIllllIIlllIIIl + lllllllllllIIIlIIIIllllIIllIllll - this.mc.neverlose500_16.getStringWidth(String.valueOf(lllllllllllIIIlIIIIllllIIllIIlIl) + " " + lllllllllllIIIlIIIIllllIIllIIlII) - 5), lllllllllllIIIlIIIIllllIIlllIIII + lllllllllllIIIlIIIIllllIIllIlllI / 2.5f - 4.0f, Color.GRAY.getRGB());
        if (lllllllllllIIIlIIIIllllIIllIlIll && this.numberSetting.getDesc() != null) {
            DrawHelper.drawNewRect(lllllllllllIIIlIIIIllllIIlllIIIl + 120, lllllllllllIIIlIIIIllllIIlllIIII + lllllllllllIIIlIIIIllllIIllIlllI / 1.5f + 3.5f, lllllllllllIIIlIIIIllllIIlllIIIl + 138 + Minecraft.fontRendererObj.getStringWidth(this.numberSetting.getDesc()) - 10, lllllllllllIIIlIIIIllllIIlllIIII + 3.5f, new Color(30, 30, 30, 255).getRGB());
            Minecraft.fontRendererObj.drawStringWithShadow(this.numberSetting.getDesc(), (float)(lllllllllllIIIlIIIIllllIIlllIIIl + 124), lllllllllllIIIlIIIIllllIIlllIIII + lllllllllllIIIlIIIIllllIIllIlllI / 1.5f - 6.0f, -1);
        }
    }
    
    @Override
    public Setting getSetting() {
        return this.numberSetting;
    }
    
    public NumberSettingComponent(final Component lllllllllllIIIlIIIIllllIlIIIllll, final NumberSetting lllllllllllIIIlIIIIllllIlIIIlllI, final int lllllllllllIIIlIIIIllllIlIIIllIl, final int lllllllllllIIIlIIIIllllIlIIlIIll, final int lllllllllllIIIlIIIIllllIlIIIlIll, final int lllllllllllIIIlIIIIllllIlIIIlIlI) {
        super(lllllllllllIIIlIIIIllllIlIIIllll, lllllllllllIIIlIIIIllllIlIIIlllI.getName(), lllllllllllIIIlIIIIllllIlIIIllIl, lllllllllllIIIlIIIIllllIlIIlIIll, lllllllllllIIIlIIIIllllIlIIIlIll, lllllllllllIIIlIIIIllllIlIIIlIlI);
        this.currentValueAnimate = 0.0f;
        this.mc = Minecraft.getMinecraft();
        this.numberSetting = lllllllllllIIIlIIIIllllIlIIIlllI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType() {
        final int[] $switch_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType = NumberSettingComponent.$SWITCH_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType;
        if ($switch_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType != null) {
            return $switch_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType;
        }
        final long lllllllllllIIIlIIIIllllIIIlllIlI = (Object)new int[NumberSetting.NumberType.values().length];
        try {
            lllllllllllIIIlIIIIllllIIIlllIlI[NumberSetting.NumberType.APS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIlIIIIllllIIIlllIlI[NumberSetting.NumberType.DEFAULT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIlIIIIllllIIIlllIlI[NumberSetting.NumberType.DISTANCE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIIlIIIIllllIIIlllIlI[NumberSetting.NumberType.MS.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIIlIIIIllllIIIlllIlI[NumberSetting.NumberType.PERCENTAGE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIIlIIIIllllIIIlllIlI[NumberSetting.NumberType.SIZE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return NumberSettingComponent.$SWITCH_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType = (int[])(Object)lllllllllllIIIlIIIIllllIIIlllIlI;
    }
    
    @Override
    public void onMouseRelease(final int lllllllllllIIIlIIIIllllIIlIIIIII) {
        this.sliding = false;
    }
    
    @Override
    public void onMouseClick(final int lllllllllllIIIlIIIIllllIIlIIIlIl, final int lllllllllllIIIlIIIIllllIIlIIlIII, final int lllllllllllIIIlIIIIllllIIlIIIIll) {
        if (!this.sliding && lllllllllllIIIlIIIIllllIIlIIIIll == 0 && this.isHovered(lllllllllllIIIlIIIIllllIIlIIIlIl, lllllllllllIIIlIIIIllllIIlIIlIII)) {
            this.sliding = true;
        }
    }
}
