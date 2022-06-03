// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui.component.impl;

import ru.rockstar.api.utils.render.AnimationHelper;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClickGUI;
import ru.rockstar.api.utils.math.MathematicHelper;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.csgui.component.PropertyComponent;
import ru.rockstar.client.ui.csgui.component.Component;

public class NumberSettingComponent extends Component implements PropertyComponent
{
    private /* synthetic */ boolean sliding;
    public /* synthetic */ float currentValueAnimate;
    /* synthetic */ Minecraft mc;
    public /* synthetic */ NumberSetting numberSetting;
    
    public NumberSettingComponent(final Component llllllllllllIlIIlIllllllllIlIllI, final NumberSetting llllllllllllIlIIlIllllllllIlllII, final int llllllllllllIlIIlIllllllllIllIll, final int llllllllllllIlIIlIllllllllIllIlI, final int llllllllllllIlIIlIllllllllIllIIl, final int llllllllllllIlIIlIllllllllIlIIIl) {
        super(llllllllllllIlIIlIllllllllIlIllI, llllllllllllIlIIlIllllllllIlllII.getName(), llllllllllllIlIIlIllllllllIllIll, llllllllllllIlIIlIllllllllIllIlI, llllllllllllIlIIlIllllllllIllIIl, llllllllllllIlIIlIllllllllIlIIIl);
        this.currentValueAnimate = 0.0f;
        this.mc = Minecraft.getMinecraft();
        this.numberSetting = llllllllllllIlIIlIllllllllIlllII;
    }
    
    @Override
    public void onMouseClick(final int llllllllllllIlIIlIlllllllIIlIIII, final int llllllllllllIlIIlIlllllllIIIlIll, final int llllllllllllIlIIlIlllllllIIIlllI) {
        if (!this.sliding && llllllllllllIlIIlIlllllllIIIlllI == 0 && this.isHovered(llllllllllllIlIIlIlllllllIIlIIII, llllllllllllIlIIlIlllllllIIIlIll)) {
            this.sliding = true;
        }
    }
    
    @Override
    public void onMouseRelease(final int llllllllllllIlIIlIlllllllIIIIlll) {
        this.sliding = false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType() {
        final int[] $switch_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType = NumberSettingComponent.$SWITCH_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType;
        if ($switch_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType != null) {
            return $switch_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType;
        }
        final char llllllllllllIlIIlIlllllllIIIIIIl = (Object)new int[NumberSetting.NumberType.values().length];
        try {
            llllllllllllIlIIlIlllllllIIIIIIl[NumberSetting.NumberType.APS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIIlIlllllllIIIIIIl[NumberSetting.NumberType.DEFAULT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIlIIlIlllllllIIIIIIl[NumberSetting.NumberType.DISTANCE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIlIIlIlllllllIIIIIIl[NumberSetting.NumberType.MS.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIlIIlIlllllllIIIIIIl[NumberSetting.NumberType.PERCENTAGE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIlIIlIlllllllIIIIIIl[NumberSetting.NumberType.SIZE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return NumberSettingComponent.$SWITCH_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType = (int[])(Object)llllllllllllIlIIlIlllllllIIIIIIl;
    }
    
    @Override
    public Setting getSetting() {
        return this.numberSetting;
    }
    
    @Override
    public void drawComponent(final ScaledResolution llllllllllllIlIIlIlllllllIlllIll, final int llllllllllllIlIIlIlllllllIlIIlll, final int llllllllllllIlIIlIlllllllIlIIllI) {
        super.drawComponent(llllllllllllIlIIlIlllllllIlllIll, llllllllllllIlIIlIlllllllIlIIlll, llllllllllllIlIIlIlllllllIlIIllI);
        final int llllllllllllIlIIlIlllllllIlllIII = this.getX();
        final int llllllllllllIlIIlIlllllllIllIlll = this.getY();
        final int llllllllllllIlIIlIlllllllIllIllI = this.getWidth();
        final int llllllllllllIlIIlIlllllllIllIlIl = this.getHeight();
        final double llllllllllllIlIIlIlllllllIllIlII = this.numberSetting.getMinValue();
        final double llllllllllllIlIIlIlllllllIllIIll = this.numberSetting.getMaxValue();
        final boolean llllllllllllIlIIlIlllllllIllIIlI = this.isHovered(llllllllllllIlIIlIlllllllIlIIlll, llllllllllllIlIIlIlllllllIlIIllI);
        if (this.sliding) {
            this.numberSetting.setValueNumber((float)MathematicHelper.round((llllllllllllIlIIlIlllllllIlIIlll - llllllllllllIlIIlIlllllllIlllIII) * (llllllllllllIlIIlIlllllllIllIIll - llllllllllllIlIIlIlllllllIllIlII) / llllllllllllIlIIlIlllllllIllIllI + llllllllllllIlIIlIlllllllIllIlII, this.numberSetting.getIncrement()));
            if (this.numberSetting.getNumberValue() > llllllllllllIlIIlIlllllllIllIIll) {
                this.numberSetting.setValueNumber((float)llllllllllllIlIIlIlllllllIllIIll);
            }
            else if (this.numberSetting.getNumberValue() < llllllllllllIlIIlIlllllllIllIlII) {
                this.numberSetting.setValueNumber((float)llllllllllllIlIIlIlllllllIllIlII);
            }
        }
        final float llllllllllllIlIIlIlllllllIllIIIl = (float)((this.numberSetting.getNumberValue() - llllllllllllIlIIlIlllllllIllIlII) / (llllllllllllIlIIlIlllllllIllIIll - llllllllllllIlIIlIlllllllIllIlII));
        int llllllllllllIlIIlIlllllllIllIIII = 0;
        final Color llllllllllllIlIIlIlllllllIlIllll = new Color(ClickGUI.color.getColorValue());
        final Color llllllllllllIlIIlIlllllllIlIlllI = new Color(ClickGUI.colorTwo.getColorValue());
        final double llllllllllllIlIIlIlllllllIlIllIl = ClickGUI.speed.getNumberValue();
        final boolean llllllllllllIlIIlIlllllllIIllIIl;
        switch (((String)(llllllllllllIlIIlIlllllllIIllIIl = (boolean)ClickGUI.clickGuiColor.currentMode)).hashCode()) {
            case -1808614770: {
                if (!((String)llllllllllllIlIIlIlllllllIIllIIl).equals("Static")) {
                    break;
                }
                llllllllllllIlIIlIlllllllIllIIII = llllllllllllIlIIlIlllllllIlIllll.getRGB();
                break;
            }
            case -1656737386: {
                if (!((String)llllllllllllIlIIlIlllllllIIllIIl).equals("Rainbow")) {
                    break;
                }
                llllllllllllIlIIlIlllllllIllIIII = DrawHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                break;
            }
            case -311641137: {
                if (!((String)llllllllllllIlIIlIlllllllIIllIIl).equals("Color Two")) {
                    break;
                }
                llllllllllllIlIIlIlllllllIllIIII = DrawHelper.fadeColor(llllllllllllIlIIlIlllllllIlIllll.getRGB(), llllllllllllIlIIlIlllllllIlIlllI.getRGB(), (float)Math.abs((System.currentTimeMillis() / llllllllllllIlIIlIlllllllIlIllIl / llllllllllllIlIIlIlllllllIlIllIl + llllllllllllIlIIlIlllllllIllIlll * 6L / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
            case 2181788: {
                if (!((String)llllllllllllIlIIlIlllllllIIllIIl).equals("Fade")) {
                    break;
                }
                llllllllllllIlIIlIlllllllIllIIII = DrawHelper.fadeColor(llllllllllllIlIIlIlllllllIlIllll.getRGB(), llllllllllllIlIIlIlllllllIlIllll.darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / llllllllllllIlIIlIlllllllIlIllIl / llllllllllllIlIIlIlllllllIlIllIl + llllllllllllIlIIlIlllllllIllIlll * 6L / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
            case 961091784: {
                if (!((String)llllllllllllIlIIlIlllllllIIllIIl).equals("Astolfo")) {
                    break;
                }
                llllllllllllIlIIlIlllllllIllIIII = DrawHelper.astolfo(true, llllllllllllIlIIlIlllllllIllIlll).getRGB();
                break;
            }
            case 2021122027: {
                if (!((String)llllllllllllIlIIlIlllllllIIllIIl).equals("Client")) {
                    break;
                }
                llllllllllllIlIIlIlllllllIllIIII = DrawHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / llllllllllllIlIIlIlllllllIlIllIl / llllllllllllIlIIlIlllllllIlIllIl + llllllllllllIlIIlIlllllllIllIlll * 6L / 60L * 2L) % 2.0 - 1.0));
                break;
            }
        }
        this.currentValueAnimate = AnimationHelper.animation(this.currentValueAnimate, llllllllllllIlIIlIlllllllIllIIIl, 0.0f);
        final float llllllllllllIlIIlIlllllllIlIllII = (float)MathematicHelper.round(this.numberSetting.getNumberValue(), this.numberSetting.getIncrement());
        DrawHelper.drawRect(llllllllllllIlIIlIlllllllIlllIII + 3, llllllllllllIlIIlIlllllllIllIlll + llllllllllllIlIIlIlllllllIllIlIl - 5, llllllllllllIlIIlIlllllllIlllIII + (llllllllllllIlIIlIlllllllIllIllI - 3), llllllllllllIlIIlIlllllllIllIlll + 13, new Color(40, 39, 39).getRGB());
        DrawHelper.drawRect(llllllllllllIlIIlIlllllllIlllIII + 3, llllllllllllIlIIlIlllllllIllIlll + 13.5, llllllllllllIlIIlIlllllllIlllIII + 5 + this.currentValueAnimate * (llllllllllllIlIIlIlllllllIllIllI - 9), llllllllllllIlIIlIlllllllIllIlll + 15.0f, llllllllllllIlIIlIlllllllIllIIII);
        DrawHelper.drawFilledCircle((int)(llllllllllllIlIIlIlllllllIlllIII + 5 + this.currentValueAnimate * (llllllllllllIlIIlIlllllllIllIllI - 8)), (int)(llllllllllllIlIIlIlllllllIllIlll + 14.0f), 2.0f, new Color(255, 255, 255));
        String llllllllllllIlIIlIlllllllIlIlIll = "";
        final NumberSetting.NumberType llllllllllllIlIIlIlllllllIlIlIlI = this.numberSetting.getType();
        switch ($SWITCH_TABLE$ru$rockstar$client$ui$settings$impl$NumberSetting$NumberType()[llllllllllllIlIIlIlllllllIlIlIlI.ordinal()]) {
            case 4: {
                llllllllllllIlIIlIlllllllIlIlIll = String.valueOf(llllllllllllIlIIlIlllllllIlIlIll) + '%';
                break;
            }
            case 1: {
                llllllllllllIlIIlIlllllllIlIlIll = String.valueOf(llllllllllllIlIIlIlllllllIlIlIll) + "ms";
                break;
            }
            case 5: {
                llllllllllllIlIIlIlllllllIlIlIll = String.valueOf(llllllllllllIlIIlIlllllllIlIlIll) + 'm';
            }
            case 3: {
                llllllllllllIlIIlIlllllllIlIlIll = String.valueOf(llllllllllllIlIIlIlllllllIlIlIll) + "SIZE";
            }
            case 2: {
                llllllllllllIlIIlIlllllllIlIlIll = String.valueOf(llllllllllllIlIIlIlllllllIlIlIll) + "APS";
                break;
            }
            default: {
                llllllllllllIlIIlIlllllllIlIlIll = "";
                break;
            }
        }
        this.mc.neverlose500_13.drawString(this.numberSetting.getName(), llllllllllllIlIIlIlllllllIlllIII + 2.0f, llllllllllllIlIIlIlllllllIllIlll + llllllllllllIlIIlIlllllllIllIlIl / 2.5f - 4.0f, Color.lightGray.getRGB());
        this.mc.neverlose500_15.drawString(String.valueOf(llllllllllllIlIIlIlllllllIlIllII) + " " + llllllllllllIlIIlIlllllllIlIlIll, (float)(llllllllllllIlIIlIlllllllIlllIII + llllllllllllIlIIlIlllllllIllIllI - this.mc.neverlose500_16.getStringWidth(String.valueOf(llllllllllllIlIIlIlllllllIlIllII) + " " + llllllllllllIlIIlIlllllllIlIlIll) - 5), llllllllllllIlIIlIlllllllIllIlll + llllllllllllIlIIlIlllllllIllIlIl / 2.5f - 4.0f, Color.GRAY.getRGB());
        if (llllllllllllIlIIlIlllllllIllIIlI && this.numberSetting.getDesc() != null) {
            DrawHelper.drawNewRect(llllllllllllIlIIlIlllllllIlllIII + 120, llllllllllllIlIIlIlllllllIllIlll + llllllllllllIlIIlIlllllllIllIlIl / 1.5f + 3.5f, llllllllllllIlIIlIlllllllIlllIII + 138 + Minecraft.fontRendererObj.getStringWidth(this.numberSetting.getDesc()) - 10, llllllllllllIlIIlIlllllllIllIlll + 3.5f, new Color(30, 30, 30, 255).getRGB());
            Minecraft.fontRendererObj.drawStringWithShadow(this.numberSetting.getDesc(), (float)(llllllllllllIlIIlIlllllllIlllIII + 124), llllllllllllIlIIlIlllllllIllIlll + llllllllllllIlIIlIlllllllIllIlIl / 1.5f - 6.0f, -1);
        }
    }
}
