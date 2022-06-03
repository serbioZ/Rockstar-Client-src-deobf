// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui.component.impl;

import java.util.Iterator;
import org.lwjgl.input.Keyboard;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.client.ui.csgui.Panel;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClickGUI;
import java.util.Comparator;
import ru.rockstar.client.ui.csgui.SorterHelper;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.csgui.ClickGuiScreen;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.ui.csgui.component.Component;
import ru.rockstar.client.ui.csgui.component.AnimationState;
import ru.rockstar.client.features.Feature;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.csgui.component.ExpandableComponent;

public final class ModuleComponent extends ExpandableComponent
{
    /* synthetic */ Minecraft mc;
    private /* synthetic */ boolean binding;
    private final /* synthetic */ Feature module;
    private final /* synthetic */ AnimationState state;
    
    public ModuleComponent(final Component lllllllllllIIllllIIlIIIIIlIIIlll, final Feature lllllllllllIIllllIIlIIIIIlIIIllI, final int lllllllllllIIllllIIlIIIIIlIIIlIl, final int lllllllllllIIllllIIlIIIIIIlllIll, final int lllllllllllIIllllIIlIIIIIlIIIIll, final int lllllllllllIIllllIIlIIIIIIlllIIl) {
        super(lllllllllllIIllllIIlIIIIIlIIIlll, lllllllllllIIllllIIlIIIIIlIIIllI.getLabel(), lllllllllllIIllllIIlIIIIIlIIIlIl, lllllllllllIIllllIIlIIIIIIlllIll, lllllllllllIIllllIIlIIIIIlIIIIll, lllllllllllIIllllIIlIIIIIIlllIIl);
        this.mc = Minecraft.getMinecraft();
        this.module = lllllllllllIIllllIIlIIIIIlIIIllI;
        this.state = AnimationState.STATIC;
        final int lllllllllllIIllllIIlIIIIIlIIIIIl = 1;
        for (final Setting lllllllllllIIllllIIlIIIIIlIIIIII : lllllllllllIIllllIIlIIIIIlIIIllI.getSettings()) {
            if (lllllllllllIIllllIIlIIIIIlIIIIII instanceof BooleanSetting) {
                this.components.add(new BooleanSettingComponent(this, (BooleanSetting)lllllllllllIIllllIIlIIIIIlIIIIII, lllllllllllIIllllIIlIIIIIlIIIIIl, lllllllllllIIllllIIlIIIIIIlllIIl, lllllllllllIIllllIIlIIIIIlIIIIll - 2, 21));
            }
            else if (lllllllllllIIllllIIlIIIIIlIIIIII instanceof ColorSetting) {
                this.components.add(new ColorPickerComponent(this, (ColorSetting)lllllllllllIIllllIIlIIIIIlIIIIII, lllllllllllIIllllIIlIIIIIlIIIIIl, lllllllllllIIllllIIlIIIIIIlllIIl, lllllllllllIIllllIIlIIIIIlIIIIll - 2, 15));
            }
            else if (lllllllllllIIllllIIlIIIIIlIIIIII instanceof NumberSetting) {
                this.components.add(new NumberSettingComponent(this, (NumberSetting)lllllllllllIIllllIIlIIIIIlIIIIII, lllllllllllIIllllIIlIIIIIlIIIIIl, lllllllllllIIllllIIlIIIIIIlllIIl, lllllllllllIIllllIIlIIIIIlIIIIll - 2, 20));
            }
            else {
                if (!(lllllllllllIIllllIIlIIIIIlIIIIII instanceof ListSetting)) {
                    continue;
                }
                this.components.add(new ListSettingComponent(this, (ListSetting)lllllllllllIIllllIIlIIIIIlIIIIII, lllllllllllIIllllIIlIIIIIlIIIIIl, lllllllllllIIllllIIlIIIIIIlllIIl, lllllllllllIIllllIIlIIIIIlIIIIll - 2, 22));
            }
        }
    }
    
    @Override
    public boolean canExpand() {
        return !this.components.isEmpty();
    }
    
    @Override
    public void onPress(final int lllllllllllIIllllIIIlllllllllIII, final int lllllllllllIIllllIIIllllllllIlll, final int lllllllllllIIllllIIIllllllllIlII) {
        switch (lllllllllllIIllllIIIllllllllIlII) {
            case 0: {
                this.module.toggle();
                break;
            }
            case 2: {
                this.binding = !this.binding;
                break;
            }
        }
    }
    
    @Override
    public int getHeightWithExpand() {
        int lllllllllllIIllllIIIlllllllIIllI = this.getHeight();
        if (this.isExpanded()) {
            for (final Component lllllllllllIIllllIIIlllllllIIlIl : this.components) {
                int lllllllllllIIllllIIIlllllllIIlII = lllllllllllIIllllIIIlllllllIIlIl.getHeight();
                if (lllllllllllIIllllIIIlllllllIIlIl instanceof BooleanSettingComponent) {
                    final BooleanSettingComponent lllllllllllIIllllIIIlllllllIIIll = (BooleanSettingComponent)lllllllllllIIllllIIIlllllllIIlIl;
                    if (!lllllllllllIIllllIIIlllllllIIIll.booleanSetting.isVisible()) {
                        continue;
                    }
                }
                if (lllllllllllIIllllIIIlllllllIIlIl instanceof NumberSettingComponent) {
                    final NumberSettingComponent lllllllllllIIllllIIIlllllllIIIlI = (NumberSettingComponent)lllllllllllIIllllIIIlllllllIIlIl;
                    if (!lllllllllllIIllllIIIlllllllIIIlI.numberSetting.isVisible()) {
                        continue;
                    }
                }
                if (lllllllllllIIllllIIIlllllllIIlIl instanceof ColorPickerComponent) {
                    final ColorPickerComponent lllllllllllIIllllIIIlllllllIIIIl = (ColorPickerComponent)lllllllllllIIllllIIIlllllllIIlIl;
                    if (!lllllllllllIIllllIIIlllllllIIIIl.getSetting().isVisible()) {
                        continue;
                    }
                }
                if (lllllllllllIIllllIIIlllllllIIlIl instanceof ListSettingComponent) {
                    final ListSettingComponent lllllllllllIIllllIIIlllllllIIIII = (ListSettingComponent)lllllllllllIIllllIIIlllllllIIlIl;
                    if (!lllllllllllIIllllIIIlllllllIIIII.getSetting().isVisible()) {
                        continue;
                    }
                }
                if (lllllllllllIIllllIIIlllllllIIlIl instanceof ExpandableComponent) {
                    final ExpandableComponent lllllllllllIIllllIIIllllllIlllll = (ExpandableComponent)lllllllllllIIllllIIIlllllllIIlIl;
                    if (lllllllllllIIllllIIIllllllIlllll.isExpanded()) {
                        lllllllllllIIllllIIIlllllllIIlII = lllllllllllIIllllIIIllllllIlllll.getHeightWithExpand();
                    }
                }
                lllllllllllIIllllIIIlllllllIIllI += lllllllllllIIllllIIIlllllllIIlII;
            }
        }
        return lllllllllllIIllllIIIlllllllIIllI;
    }
    
    @Override
    public void onKeyPress(final int lllllllllllIIllllIIIlllllllIlllI) {
        if (this.binding) {
            ClickGuiScreen.escapeKeyInUse = true;
            this.module.setKey((lllllllllllIIllllIIIlllllllIlllI == 1) ? 0 : lllllllllllIIllllIIIlllllllIlllI);
            this.binding = false;
        }
    }
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllIIllllIIlIIIIIIlIIlII, final int lllllllllllIIllllIIlIIIIIIlIIIll, final int lllllllllllIIllllIIlIIIIIIIIlIll) {
        this.components.sort(new SorterHelper());
        final float lllllllllllIIllllIIlIIIIIIlIIIIl = (float)this.getX();
        final float lllllllllllIIllllIIlIIIIIIlIIIII = (float)this.getY();
        final int lllllllllllIIllllIIlIIIIIIIlllll = this.getWidth();
        final int lllllllllllIIllllIIlIIIIIIIllllI = this.getHeight();
        if (this.isExpanded()) {
            int lllllllllllIIllllIIlIIIIIIIlllIl = 15;
            for (final Component lllllllllllIIllllIIlIIIIIIIlllII : this.components) {
                int lllllllllllIIllllIIlIIIIIIIllIll = lllllllllllIIllllIIlIIIIIIIlllII.getHeight();
                if (lllllllllllIIllllIIlIIIIIIIlllII instanceof BooleanSettingComponent) {
                    final BooleanSettingComponent lllllllllllIIllllIIlIIIIIIIllIlI = (BooleanSettingComponent)lllllllllllIIllllIIlIIIIIIIlllII;
                    if (!lllllllllllIIllllIIlIIIIIIIllIlI.booleanSetting.isVisible()) {
                        continue;
                    }
                }
                if (lllllllllllIIllllIIlIIIIIIIlllII instanceof NumberSettingComponent) {
                    final NumberSettingComponent lllllllllllIIllllIIlIIIIIIIllIIl = (NumberSettingComponent)lllllllllllIIllllIIlIIIIIIIlllII;
                    if (!lllllllllllIIllllIIlIIIIIIIllIIl.numberSetting.isVisible()) {
                        continue;
                    }
                }
                if (lllllllllllIIllllIIlIIIIIIIlllII instanceof ColorPickerComponent) {
                    final ColorPickerComponent lllllllllllIIllllIIlIIIIIIIllIII = (ColorPickerComponent)lllllllllllIIllllIIlIIIIIIIlllII;
                    if (!lllllllllllIIllllIIlIIIIIIIllIII.getSetting().isVisible()) {
                        continue;
                    }
                }
                if (lllllllllllIIllllIIlIIIIIIIlllII instanceof ListSettingComponent) {
                    final ListSettingComponent lllllllllllIIllllIIlIIIIIIIlIlll = (ListSettingComponent)lllllllllllIIllllIIlIIIIIIIlllII;
                    if (!lllllllllllIIllllIIlIIIIIIIlIlll.getSetting().isVisible()) {
                        continue;
                    }
                }
                if (lllllllllllIIllllIIlIIIIIIIlllII instanceof ExpandableComponent) {
                    final ExpandableComponent lllllllllllIIllllIIlIIIIIIIlIllI = (ExpandableComponent)lllllllllllIIllllIIlIIIIIIIlllII;
                    if (lllllllllllIIllllIIlIIIIIIIlIllI.isExpanded()) {
                        lllllllllllIIllllIIlIIIIIIIllIll = lllllllllllIIllllIIlIIIIIIIlIllI.getHeightWithExpand();
                    }
                }
                lllllllllllIIllllIIlIIIIIIIlllII.setY(lllllllllllIIllllIIlIIIIIIIlllIl);
                lllllllllllIIllllIIlIIIIIIIlllII.drawComponent(lllllllllllIIllllIIlIIIIIIlIIlII, lllllllllllIIllllIIlIIIIIIlIIIll, lllllllllllIIllllIIlIIIIIIIIlIll);
                lllllllllllIIllllIIlIIIIIIIlllIl += lllllllllllIIllllIIlIIIIIIIllIll;
            }
        }
        int lllllllllllIIllllIIlIIIIIIIlIlIl = 0;
        final Color lllllllllllIIllllIIlIIIIIIIlIlII = new Color(ClickGUI.color.getColorValue());
        final Color lllllllllllIIllllIIlIIIIIIIlIIll = new Color(ClickGUI.colorTwo.getColorValue());
        final double lllllllllllIIllllIIlIIIIIIIlIIlI = ClickGUI.speed.getNumberValue();
        final char lllllllllllIIllllIIlIIIIIIIIIIIl;
        switch (((String)(lllllllllllIIllllIIlIIIIIIIIIIIl = (char)ClickGUI.clickGuiColor.currentMode)).hashCode()) {
            case -1656737386: {
                if (!((String)lllllllllllIIllllIIlIIIIIIIIIIIl).equals("Rainbow")) {
                    break;
                }
                lllllllllllIIllllIIlIIIIIIIlIlIl = DrawHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                break;
            }
            case -311641137: {
                if (!((String)lllllllllllIIllllIIlIIIIIIIIIIIl).equals("Color Two")) {
                    break;
                }
                lllllllllllIIllllIIlIIIIIIIlIlIl = DrawHelper.fadeColor(lllllllllllIIllllIIlIIIIIIIlIlII.getRGB(), lllllllllllIIllllIIlIIIIIIIlIIll.getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIllllIIlIIIIIIIlIIlI / lllllllllllIIllllIIlIIIIIIIlIIlI + lllllllllllIIllllIIlIIIIIIlIIIII * 6.0f / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
            case 2181788: {
                if (!((String)lllllllllllIIllllIIlIIIIIIIIIIIl).equals("Fade")) {
                    break;
                }
                lllllllllllIIllllIIlIIIIIIIlIlIl = DrawHelper.fadeColor(lllllllllllIIllllIIlIIIIIIIlIlII.getRGB(), lllllllllllIIllllIIlIIIIIIIlIlII.darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIllllIIlIIIIIIIlIIlI / lllllllllllIIllllIIlIIIIIIIlIIlI + lllllllllllIIllllIIlIIIIIIlIIIII * 6.0f / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
            case 115155230: {
                if (!((String)lllllllllllIIllllIIlIIIIIIIIIIIl).equals("Category")) {
                    break;
                }
                final Panel lllllllllllIIllllIIlIIIIIIIlIIIl = (Panel)this.parent;
                lllllllllllIIllllIIlIIIIIIIlIlIl = lllllllllllIIllllIIlIIIIIIIlIIIl.type.getColor();
                break;
            }
            case 961091784: {
                if (!((String)lllllllllllIIllllIIlIIIIIIIIIIIl).equals("Astolfo")) {
                    break;
                }
                lllllllllllIIllllIIlIIIIIIIlIlIl = DrawHelper.astolfo(true, (int)lllllllllllIIllllIIlIIIIIIlIIIII).getRGB();
                break;
            }
            case 2021122027: {
                if (!((String)lllllllllllIIllllIIlIIIIIIIIIIIl).equals("Client")) {
                    break;
                }
                lllllllllllIIllllIIlIIIIIIIlIlIl = DrawHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIllllIIlIIIIIIIlIIlI / lllllllllllIIllllIIlIIIIIIIlIIlI + lllllllllllIIllllIIlIIIIIIlIIIII * 6.0f / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
        }
        final boolean lllllllllllIIllllIIlIIIIIIIlIIII = this.isHovered(lllllllllllIIllllIIlIIIIIIlIIIll, lllllllllllIIllllIIlIIIIIIIIlIll);
        DrawHelper.drawNewRect(lllllllllllIIllllIIlIIIIIIlIIIIl, lllllllllllIIllllIIlIIIIIIlIIIII, lllllllllllIIllllIIlIIIIIIlIIIIl, lllllllllllIIllllIIlIIIIIIlIIIII, new Color(30, 30, 30, 255).getRGB());
        if (lllllllllllIIllllIIlIIIIIIIlIIII) {
            final ScaledResolution lllllllllllIIllllIIlIIIIIIIIllll = new ScaledResolution(this.mc);
            DrawHelper.drawNewRect(33.0, lllllllllllIIllllIIlIIIIIIIIllll.getScaledHeight() - 23, 25 + Minecraft.fontRendererObj.getStringWidth(this.module.getDesc()) + 16, lllllllllllIIllllIIlIIIIIIIIllll.getScaledHeight() - 7, new Color(30, 30, 30, 200).getRGB());
            DrawHelper.drawGradientRect(31.0, lllllllllllIIllllIIlIIIIIIIIllll.getScaledHeight() - 23, 33.0, lllllllllllIIllllIIlIIIIIIIIllll.getScaledHeight() - 7, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 70);
            DrawHelper.drawGradientRect(31 + Minecraft.fontRendererObj.getStringWidth(this.module.getDesc()) + 10, lllllllllllIIllllIIlIIIIIIIIllll.getScaledHeight() - 23, 33 + Minecraft.fontRendererObj.getStringWidth(this.module.getDesc()) + 10, lllllllllllIIllllIIlIIIIIIIIllll.getScaledHeight() - 7, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 70);
            Minecraft.fontRendererObj.drawStringWithShadow(this.module.getDesc(), 36.0f, (float)(lllllllllllIIllllIIlIIIIIIIIllll.getScaledHeight() - 20), -1);
        }
        if (this.components.size() > 1) {
            this.mc.neverlose500_15.drawStringWithShadow(this.isExpanded() ? "<" : ">", lllllllllllIIllllIIlIIIIIIlIIIIl + lllllllllllIIllllIIlIIIIIIIlllll - 13.0f, lllllllllllIIllllIIlIIIIIIlIIIII + lllllllllllIIllllIIlIIIIIIIllllI / 2.0f - 3.5, Color.GRAY.getRGB());
        }
        if (this.module.isToggled() && ClickGUI.glow.getBoolValue()) {
            DrawHelper.drawGlow(lllllllllllIIllllIIlIIIIIIlIIIIl - this.mc.neverlose500_15.getStringWidth(this.getName()) / 2 + 50.0f + 2.0f, lllllllllllIIllllIIlIIIIIIlIIIII + lllllllllllIIllllIIlIIIIIIIllllI / 2.0f - 10.0f, lllllllllllIIllllIIlIIIIIIlIIIIl - this.mc.neverlose500_15.getStringWidth(this.getName()) / 2 + 40.0f + this.mc.neverlose500_15.getStringWidth(this.getName()) - 2.0f, lllllllllllIIllllIIlIIIIIIlIIIII + lllllllllllIIllllIIlIIIIIIIllllI / 2.0f + 7.0f, lllllllllllIIllllIIlIIIIIIIlIlIl - new Color(0, 0, 0, 150).getRGB());
        }
        this.components.sort(new SorterHelper());
        this.mc.neverlose500_13.drawCenteredStringWithShadow(this.binding ? ("Press a key.. " + Keyboard.getKeyName(this.module.getKey())) : this.getName(), lllllllllllIIllllIIlIIIIIIlIIIIl + 45.0f, lllllllllllIIllllIIlIIIIIIlIIIII + lllllllllllIIllllIIlIIIIIIIllllI / 2.0f - 3.0f - ClickGUI.fontY.getNumberValue(), this.module.isToggled() ? lllllllllllIIllllIIlIIIIIIIlIlIl : Color.GRAY.getRGB());
    }
}
