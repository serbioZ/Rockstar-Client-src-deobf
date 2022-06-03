// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui.component.impl;

import org.lwjgl.input.Keyboard;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.client.ui.clickgui.Panel;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClickGUI;
import java.util.Comparator;
import ru.rockstar.client.ui.clickgui.SorterHelper;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.clickgui.ClickGuiScreen;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.ui.clickgui.component.Component;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.ui.clickgui.component.AnimationState;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.clickgui.component.ExpandableComponent;

public final class ModuleComponent extends ExpandableComponent
{
    /* synthetic */ Minecraft mc;
    private final /* synthetic */ AnimationState state;
    private final /* synthetic */ Feature module;
    private /* synthetic */ boolean binding;
    
    @Override
    public void onPress(final int llllllllllllllllllIIllIlIIIIIIII, final int llllllllllllllllllIIllIIllllllll, final int llllllllllllllllllIIllIIllllllII) {
        switch (llllllllllllllllllIIllIIllllllII) {
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
    
    public ModuleComponent(final Component llllllllllllllllllIIllIlIlIIIllI, final Feature llllllllllllllllllIIllIlIlIIlllI, final int llllllllllllllllllIIllIlIlIIIlII, final int llllllllllllllllllIIllIlIlIIllII, final int llllllllllllllllllIIllIlIlIIIIlI, final int llllllllllllllllllIIllIlIlIIlIlI) {
        super(llllllllllllllllllIIllIlIlIIIllI, llllllllllllllllllIIllIlIlIIlllI.getLabel(), llllllllllllllllllIIllIlIlIIIlII, llllllllllllllllllIIllIlIlIIllII, llllllllllllllllllIIllIlIlIIIIlI, llllllllllllllllllIIllIlIlIIlIlI);
        this.mc = Minecraft.getMinecraft();
        this.module = llllllllllllllllllIIllIlIlIIlllI;
        this.state = AnimationState.STATIC;
        final int llllllllllllllllllIIllIlIlIIlIIl = 1;
        for (final Setting llllllllllllllllllIIllIlIlIIlIII : llllllllllllllllllIIllIlIlIIlllI.getSettings()) {
            if (llllllllllllllllllIIllIlIlIIlIII instanceof BooleanSetting) {
                this.components.add(new BooleanSettingComponent(this, (BooleanSetting)llllllllllllllllllIIllIlIlIIlIII, llllllllllllllllllIIllIlIlIIlIIl, llllllllllllllllllIIllIlIlIIlIlI, llllllllllllllllllIIllIlIlIIIIlI - 2, 21));
            }
            else if (llllllllllllllllllIIllIlIlIIlIII instanceof ColorSetting) {
                this.components.add(new ColorPickerComponent(this, (ColorSetting)llllllllllllllllllIIllIlIlIIlIII, llllllllllllllllllIIllIlIlIIlIIl, llllllllllllllllllIIllIlIlIIlIlI, llllllllllllllllllIIllIlIlIIIIlI - 2, 15));
            }
            else if (llllllllllllllllllIIllIlIlIIlIII instanceof NumberSetting) {
                this.components.add(new NumberSettingComponent(this, (NumberSetting)llllllllllllllllllIIllIlIlIIlIII, llllllllllllllllllIIllIlIlIIlIIl, llllllllllllllllllIIllIlIlIIlIlI, llllllllllllllllllIIllIlIlIIIIlI - 2, 20));
            }
            else {
                if (!(llllllllllllllllllIIllIlIlIIlIII instanceof ListSetting)) {
                    continue;
                }
                this.components.add(new ListSettingComponent(this, (ListSetting)llllllllllllllllllIIllIlIlIIlIII, llllllllllllllllllIIllIlIlIIlIIl, llllllllllllllllllIIllIlIlIIlIlI, llllllllllllllllllIIllIlIlIIIIlI - 2, 22));
            }
        }
    }
    
    @Override
    public boolean canExpand() {
        return !this.components.isEmpty();
    }
    
    @Override
    public int getHeightWithExpand() {
        int llllllllllllllllllIIllIIlllIlllI = this.getHeight();
        if (this.isExpanded()) {
            for (final Component llllllllllllllllllIIllIIlllIllIl : this.components) {
                int llllllllllllllllllIIllIIlllIllII = llllllllllllllllllIIllIIlllIllIl.getHeight();
                if (llllllllllllllllllIIllIIlllIllIl instanceof BooleanSettingComponent) {
                    final BooleanSettingComponent llllllllllllllllllIIllIIlllIlIll = (BooleanSettingComponent)llllllllllllllllllIIllIIlllIllIl;
                    if (!llllllllllllllllllIIllIIlllIlIll.booleanSetting.isVisible()) {
                        continue;
                    }
                }
                if (llllllllllllllllllIIllIIlllIllIl instanceof NumberSettingComponent) {
                    final NumberSettingComponent llllllllllllllllllIIllIIlllIlIlI = (NumberSettingComponent)llllllllllllllllllIIllIIlllIllIl;
                    if (!llllllllllllllllllIIllIIlllIlIlI.numberSetting.isVisible()) {
                        continue;
                    }
                }
                if (llllllllllllllllllIIllIIlllIllIl instanceof ColorPickerComponent) {
                    final ColorPickerComponent llllllllllllllllllIIllIIlllIlIIl = (ColorPickerComponent)llllllllllllllllllIIllIIlllIllIl;
                    if (!llllllllllllllllllIIllIIlllIlIIl.getSetting().isVisible()) {
                        continue;
                    }
                }
                if (llllllllllllllllllIIllIIlllIllIl instanceof ListSettingComponent) {
                    final ListSettingComponent llllllllllllllllllIIllIIlllIlIII = (ListSettingComponent)llllllllllllllllllIIllIIlllIllIl;
                    if (!llllllllllllllllllIIllIIlllIlIII.getSetting().isVisible()) {
                        continue;
                    }
                }
                if (llllllllllllllllllIIllIIlllIllIl instanceof ExpandableComponent) {
                    final ExpandableComponent llllllllllllllllllIIllIIlllIIlll = (ExpandableComponent)llllllllllllllllllIIllIIlllIllIl;
                    if (llllllllllllllllllIIllIIlllIIlll.isExpanded()) {
                        llllllllllllllllllIIllIIlllIllII = llllllllllllllllllIIllIIlllIIlll.getHeightWithExpand();
                    }
                }
                llllllllllllllllllIIllIIlllIlllI += llllllllllllllllllIIllIIlllIllII;
            }
        }
        return llllllllllllllllllIIllIIlllIlllI;
    }
    
    @Override
    public void onKeyPress(final int llllllllllllllllllIIllIIlllllIII) {
        if (this.binding) {
            ClickGuiScreen.escapeKeyInUse = true;
            this.module.setKey((llllllllllllllllllIIllIIlllllIII == 1) ? 0 : llllllllllllllllllIIllIIlllllIII);
            this.binding = false;
        }
    }
    
    @Override
    public void drawComponent(final ScaledResolution llllllllllllllllllIIllIlIIIlIlIl, final int llllllllllllllllllIIllIlIIIlIlII, final int llllllllllllllllllIIllIlIIIlIIll) {
        this.components.sort(new SorterHelper());
        final float llllllllllllllllllIIllIlIIlIlIIl = (float)this.getX();
        final float llllllllllllllllllIIllIlIIlIlIII = (float)(this.getY() - 2);
        final int llllllllllllllllllIIllIlIIlIIlll = this.getWidth();
        final int llllllllllllllllllIIllIlIIlIIllI = this.getHeight();
        if (this.isExpanded()) {
            int llllllllllllllllllIIllIlIIlIIlIl = 15;
            for (final Component llllllllllllllllllIIllIlIIlIIlII : this.components) {
                int llllllllllllllllllIIllIlIIlIIIll = llllllllllllllllllIIllIlIIlIIlII.getHeight();
                if (llllllllllllllllllIIllIlIIlIIlII instanceof BooleanSettingComponent) {
                    final BooleanSettingComponent llllllllllllllllllIIllIlIIlIIIlI = (BooleanSettingComponent)llllllllllllllllllIIllIlIIlIIlII;
                    if (!llllllllllllllllllIIllIlIIlIIIlI.booleanSetting.isVisible()) {
                        continue;
                    }
                }
                if (llllllllllllllllllIIllIlIIlIIlII instanceof NumberSettingComponent) {
                    final NumberSettingComponent llllllllllllllllllIIllIlIIlIIIIl = (NumberSettingComponent)llllllllllllllllllIIllIlIIlIIlII;
                    if (!llllllllllllllllllIIllIlIIlIIIIl.numberSetting.isVisible()) {
                        continue;
                    }
                }
                if (llllllllllllllllllIIllIlIIlIIlII instanceof ColorPickerComponent) {
                    final ColorPickerComponent llllllllllllllllllIIllIlIIlIIIII = (ColorPickerComponent)llllllllllllllllllIIllIlIIlIIlII;
                    if (!llllllllllllllllllIIllIlIIlIIIII.getSetting().isVisible()) {
                        continue;
                    }
                }
                if (llllllllllllllllllIIllIlIIlIIlII instanceof ListSettingComponent) {
                    final ListSettingComponent llllllllllllllllllIIllIlIIIlllll = (ListSettingComponent)llllllllllllllllllIIllIlIIlIIlII;
                    if (!llllllllllllllllllIIllIlIIIlllll.getSetting().isVisible()) {
                        continue;
                    }
                }
                if (llllllllllllllllllIIllIlIIlIIlII instanceof ExpandableComponent) {
                    final ExpandableComponent llllllllllllllllllIIllIlIIIllllI = (ExpandableComponent)llllllllllllllllllIIllIlIIlIIlII;
                    if (llllllllllllllllllIIllIlIIIllllI.isExpanded()) {
                        llllllllllllllllllIIllIlIIlIIIll = llllllllllllllllllIIllIlIIIllllI.getHeightWithExpand();
                    }
                }
                llllllllllllllllllIIllIlIIlIIlII.setY(llllllllllllllllllIIllIlIIlIIlIl);
                llllllllllllllllllIIllIlIIlIIlII.drawComponent(llllllllllllllllllIIllIlIIIlIlIl, llllllllllllllllllIIllIlIIIlIlII, llllllllllllllllllIIllIlIIIlIIll);
                llllllllllllllllllIIllIlIIlIIlIl += llllllllllllllllllIIllIlIIlIIIll;
            }
        }
        int llllllllllllllllllIIllIlIIIlllIl = 0;
        final Color llllllllllllllllllIIllIlIIIlllII = new Color(ClickGUI.color.getColorValue());
        final Color llllllllllllllllllIIllIlIIIllIll = new Color(ClickGUI.colorTwo.getColorValue());
        final double llllllllllllllllllIIllIlIIIllIlI = ClickGUI.speed.getNumberValue();
        final long llllllllllllllllllIIllIlIIIIlIIl;
        switch (((String)(llllllllllllllllllIIllIlIIIIlIIl = (long)ClickGUI.clickGuiColor.currentMode)).hashCode()) {
            case -1656737386: {
                if (!((String)llllllllllllllllllIIllIlIIIIlIIl).equals("Rainbow")) {
                    break;
                }
                llllllllllllllllllIIllIlIIIlllIl = DrawHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                break;
            }
            case -311641137: {
                if (!((String)llllllllllllllllllIIllIlIIIIlIIl).equals("Color Two")) {
                    break;
                }
                llllllllllllllllllIIllIlIIIlllIl = DrawHelper.fadeColor(llllllllllllllllllIIllIlIIIlllII.getRGB(), llllllllllllllllllIIllIlIIIllIll.getRGB(), (float)Math.abs((System.currentTimeMillis() / llllllllllllllllllIIllIlIIIllIlI / llllllllllllllllllIIllIlIIIllIlI + llllllllllllllllllIIllIlIIlIlIII * 6.0f / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
            case 2181788: {
                if (!((String)llllllllllllllllllIIllIlIIIIlIIl).equals("Fade")) {
                    break;
                }
                llllllllllllllllllIIllIlIIIlllIl = DrawHelper.fadeColor(llllllllllllllllllIIllIlIIIlllII.getRGB(), llllllllllllllllllIIllIlIIIlllII.darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / llllllllllllllllllIIllIlIIIllIlI / llllllllllllllllllIIllIlIIIllIlI + llllllllllllllllllIIllIlIIlIlIII * 6.0f / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
            case 115155230: {
                if (!((String)llllllllllllllllllIIllIlIIIIlIIl).equals("Category")) {
                    break;
                }
                final Panel llllllllllllllllllIIllIlIIIllIIl = (Panel)this.parent;
                llllllllllllllllllIIllIlIIIlllIl = llllllllllllllllllIIllIlIIIllIIl.type.getColor();
                break;
            }
            case 961091784: {
                if (!((String)llllllllllllllllllIIllIlIIIIlIIl).equals("Astolfo")) {
                    break;
                }
                llllllllllllllllllIIllIlIIIlllIl = DrawHelper.astolfo(true, (int)llllllllllllllllllIIllIlIIlIlIII).getRGB();
                break;
            }
            case 2021122027: {
                if (!((String)llllllllllllllllllIIllIlIIIIlIIl).equals("Client")) {
                    break;
                }
                llllllllllllllllllIIllIlIIIlllIl = DrawHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / llllllllllllllllllIIllIlIIIllIlI / llllllllllllllllllIIllIlIIIllIlI + llllllllllllllllllIIllIlIIlIlIII * 6.0f / 60.0f * 2.0f) % 2.0 - 1.0));
                break;
            }
        }
        final boolean llllllllllllllllllIIllIlIIIllIII = this.isHovered(llllllllllllllllllIIllIlIIIlIlII, llllllllllllllllllIIllIlIIIlIIll);
        DrawHelper.drawNewRect(llllllllllllllllllIIllIlIIlIlIIl, llllllllllllllllllIIllIlIIlIlIII, llllllllllllllllllIIllIlIIlIlIIl, llllllllllllllllllIIllIlIIlIlIII, new Color(30, 30, 30, 255).getRGB());
        if (llllllllllllllllllIIllIlIIIllIII) {
            final ScaledResolution llllllllllllllllllIIllIlIIIlIlll = new ScaledResolution(this.mc);
            DrawHelper.drawNewRect(53.0, llllllllllllllllllIIllIlIIIlIlll.getScaledHeight() - 23, 45 + Minecraft.fontRendererObj.getStringWidth(this.module.getDesc()) + 16, llllllllllllllllllIIllIlIIIlIlll.getScaledHeight() - 7, new Color(30, 30, 30, 200).getRGB());
            DrawHelper.drawGradientRect(51.0, llllllllllllllllllIIllIlIIIlIlll.getScaledHeight() - 23, 53.0, llllllllllllllllllIIllIlIIIlIlll.getScaledHeight() - 7, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 70);
            DrawHelper.drawGradientRect(51 + Minecraft.fontRendererObj.getStringWidth(this.module.getDesc()) + 10, llllllllllllllllllIIllIlIIIlIlll.getScaledHeight() - 23, 53 + Minecraft.fontRendererObj.getStringWidth(this.module.getDesc()) + 10, llllllllllllllllllIIllIlIIIlIlll.getScaledHeight() - 7, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 70);
            Minecraft.fontRendererObj.drawStringWithShadow(this.module.getDesc(), 56.0f, (float)(llllllllllllllllllIIllIlIIIlIlll.getScaledHeight() - 20), -1);
        }
        if (this.components.size() > 0) {
            this.mc.neverlose500_15.drawStringWithShadow(this.isExpanded() ? "<" : ">", llllllllllllllllllIIllIlIIlIlIIl + llllllllllllllllllIIllIlIIlIIlll - 10.0f, llllllllllllllllllIIllIlIIlIlIII + llllllllllllllllllIIllIlIIlIIllI / 2.0f - 3.5, Color.GRAY.getRGB());
        }
        if (this.module.isToggled() && ClickGUI.glow.getBoolValue()) {
            DrawHelper.drawGlow(llllllllllllllllllIIllIlIIlIlIIl - ClientHelper.getFontRender().getStringWidth(this.getName()) / 2 + 50.0f + 2.0f, llllllllllllllllllIIllIlIIlIlIII + ClientHelper.getFontRender().getStringHeight(this.getName()) / 2.0f - 4.0f - ClickGUI.fontY.getNumberValue(), llllllllllllllllllIIllIlIIlIlIIl - ClientHelper.getFontRender().getStringWidth(this.getName()) / 2 + 50.0f + ClientHelper.getFontRender().getStringWidth(this.getName()) - 2.0f, llllllllllllllllllIIllIlIIlIlIII + ClientHelper.getFontRender().getStringHeight(this.getName()) / 2.0f + 11.0f - ClickGUI.fontY.getNumberValue(), llllllllllllllllllIIllIlIIIlllIl - new Color(0, 0, 0, 190).getRGB());
        }
        this.components.sort(new SorterHelper());
        ClientHelper.getFontRender().drawCenteredStringWithShadow(this.binding ? ("Press a key.. " + Keyboard.getKeyName(this.module.getKey())) : this.getName(), llllllllllllllllllIIllIlIIlIlIIl + 50.0f, llllllllllllllllllIIllIlIIlIlIII + llllllllllllllllllIIllIlIIlIIllI / 2.0f - 3.0f - ClickGUI.fontY.getNumberValue(), this.module.isToggled() ? llllllllllllllllllIIllIlIIIlllIl : Color.GRAY.getRGB());
    }
}
