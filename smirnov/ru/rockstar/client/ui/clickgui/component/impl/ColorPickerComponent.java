// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui.component.impl;

import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.client.ui.clickgui.component.Component;
import java.awt.Color;
import net.minecraft.client.renderer.Tessellator;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.clickgui.component.PropertyComponent;
import ru.rockstar.client.ui.clickgui.component.ExpandableComponent;

public class ColorPickerComponent extends ExpandableComponent implements PropertyComponent
{
    private /* synthetic */ boolean alphaSelectorDragging;
    private /* synthetic */ float alpha;
    /* synthetic */ Minecraft mc;
    public static /* synthetic */ BufferBuilder buffer;
    private /* synthetic */ boolean hueSelectorDragging;
    private /* synthetic */ float saturation;
    private /* synthetic */ float hue;
    private final /* synthetic */ ColorSetting colorSetting;
    private /* synthetic */ boolean colorSelectorDragging;
    private /* synthetic */ float brightness;
    public static /* synthetic */ Tessellator tessellator;
    
    @Override
    public void onMouseClick(final int llllllllllllllIlIIIIlIlIlIlIlllI, final int llllllllllllllIlIIIIlIlIlIlIllIl, final int llllllllllllllIlIIIIlIlIlIlllllI) {
        super.onMouseClick(llllllllllllllIlIIIIlIlIlIlIlllI, llllllllllllllIlIIIIlIlIlIlIllIl, llllllllllllllIlIIIIlIlIlIlllllI);
        if (this.isExpanded() && llllllllllllllIlIIIIlIlIlIlllllI == 0) {
            final int llllllllllllllIlIIIIlIlIlIllllIl = this.getX();
            final int llllllllllllllIlIIIIlIlIlIllllII = this.getY();
            final float llllllllllllllIlIIIIlIlIlIlllIll = (float)(llllllllllllllIlIIIIlIlIlIllllIl + 2);
            final float llllllllllllllIlIIIIlIlIlIlllIlI = (float)(llllllllllllllIlIIIIlIlIlIllllII + this.getHeight() + 2);
            final float llllllllllllllIlIIIIlIlIlIlllIIl = (float)(llllllllllllllIlIIIIlIlIlIllllIl + 80 - 2);
            final float llllllllllllllIlIIIIlIlIlIlllIII = (float)(llllllllllllllIlIIIIlIlIlIllllII + this.getHeight() + 80 - 2);
            final float llllllllllllllIlIIIIlIlIlIllIlll = (float)(llllllllllllllIlIIIIlIlIlIllllIl + 80 - 1);
            final float llllllllllllllIlIIIIlIlIlIllIllI = (float)(llllllllllllllIlIIIIlIlIlIllllII + this.getHeight() + 2);
            final float llllllllllllllIlIIIIlIlIlIllIlIl = llllllllllllllIlIIIIlIlIlIllIlll + 5.0f;
            final float llllllllllllllIlIIIIlIlIlIllIlII = (float)(llllllllllllllIlIIIIlIlIlIllllII + this.getHeight() + 80 - 2);
            final float llllllllllllllIlIIIIlIlIlIllIIll = (float)(llllllllllllllIlIIIIlIlIlIllllIl + 80 + 6);
            final float llllllllllllllIlIIIIlIlIlIllIIlI = (float)(llllllllllllllIlIIIIlIlIlIllllII + this.getHeight() + 2);
            final float llllllllllllllIlIIIIlIlIlIllIIIl = llllllllllllllIlIIIIlIlIlIllIIll + 5.0f;
            final float llllllllllllllIlIIIIlIlIlIllIIII = (float)(llllllllllllllIlIIIIlIlIlIllllII + this.getHeight() + 80 - 2);
            this.colorSelectorDragging = (!this.colorSelectorDragging && llllllllllllllIlIIIIlIlIlIlIlllI > llllllllllllllIlIIIIlIlIlIlllIll && llllllllllllllIlIIIIlIlIlIlIllIl > llllllllllllllIlIIIIlIlIlIlllIlI && llllllllllllllIlIIIIlIlIlIlIlllI < llllllllllllllIlIIIIlIlIlIlllIIl && llllllllllllllIlIIIIlIlIlIlIllIl < llllllllllllllIlIIIIlIlIlIlllIII);
            this.hueSelectorDragging = (!this.hueSelectorDragging && llllllllllllllIlIIIIlIlIlIlIlllI > llllllllllllllIlIIIIlIlIlIllIlll && llllllllllllllIlIIIIlIlIlIlIllIl > llllllllllllllIlIIIIlIlIlIllIllI && llllllllllllllIlIIIIlIlIlIlIlllI < llllllllllllllIlIIIIlIlIlIllIlIl && llllllllllllllIlIIIIlIlIlIlIllIl < llllllllllllllIlIIIIlIlIlIllIlII);
            this.alphaSelectorDragging = (!this.alphaSelectorDragging && llllllllllllllIlIIIIlIlIlIlIlllI > llllllllllllllIlIIIIlIlIlIllIIll && llllllllllllllIlIIIIlIlIlIlIllIl > llllllllllllllIlIIIIlIlIlIllIIlI && llllllllllllllIlIIIIlIlIlIlIlllI < llllllllllllllIlIIIIlIlIlIllIIIl && llllllllllllllIlIIIIlIlIlIlIllIl < llllllllllllllIlIIIIlIlIlIllIIII);
        }
    }
    
    private float[] getHSBFromColor(final int llllllllllllllIlIIIIlIlIlIIlIlII) {
        final int llllllllllllllIlIIIIlIlIlIIlIIll = llllllllllllllIlIIIIlIlIlIIlIlII >> 16 & 0xFF;
        final int llllllllllllllIlIIIIlIlIlIIlIIlI = llllllllllllllIlIIIIlIlIlIIlIlII >> 8 & 0xFF;
        final int llllllllllllllIlIIIIlIlIlIIlIIIl = llllllllllllllIlIIIIlIlIlIIlIlII & 0xFF;
        return Color.RGBtoHSB(llllllllllllllIlIIIIlIlIlIIlIIll, llllllllllllllIlIIIIlIlIlIIlIIlI, llllllllllllllIlIIIIlIlIlIIlIIIl, null);
    }
    
    public ColorPickerComponent(final Component llllllllllllllIlIIIIlIllIllIlIll, final ColorSetting llllllllllllllIlIIIIlIllIllIlIlI, final int llllllllllllllIlIIIIlIllIlllIIlI, final int llllllllllllllIlIIIIlIllIllIlIII, final int llllllllllllllIlIIIIlIllIllIIlll, final int llllllllllllllIlIIIIlIllIllIIllI) {
        super(llllllllllllllIlIIIIlIllIllIlIll, llllllllllllllIlIIIIlIllIllIlIlI.getName(), llllllllllllllIlIIIIlIllIlllIIlI, llllllllllllllIlIIIIlIllIllIlIII, llllllllllllllIlIIIIlIllIllIIlll, llllllllllllllIlIIIIlIllIllIIllI);
        this.mc = Minecraft.getMinecraft();
        this.colorSetting = llllllllllllllIlIIIIlIllIllIlIlI;
        final int llllllllllllllIlIIIIlIllIllIlllI = llllllllllllllIlIIIIlIllIllIlIlI.getColorValue();
        final float[] llllllllllllllIlIIIIlIllIllIllIl = this.getHSBFromColor(llllllllllllllIlIIIIlIllIllIlllI);
        this.hue = llllllllllllllIlIIIIlIllIllIllIl[0];
        this.saturation = llllllllllllllIlIIIIlIllIllIllIl[1];
        this.brightness = llllllllllllllIlIIIIlIllIllIllIl[2];
        this.alpha = (llllllllllllllIlIIIIlIllIllIlllI >> 24 & 0xFF) / 255.0f;
    }
    
    @Override
    public boolean canExpand() {
        return true;
    }
    
    @Override
    public int getHeightWithExpand() {
        return this.getHeight() + 80;
    }
    
    @Override
    public void onMouseRelease(final int llllllllllllllIlIIIIlIlIlIIllIll) {
        if (this.hueSelectorDragging) {
            this.hueSelectorDragging = false;
        }
        else if (this.colorSelectorDragging) {
            this.colorSelectorDragging = false;
        }
        else if (this.alphaSelectorDragging) {
            this.alphaSelectorDragging = false;
        }
    }
    
    private void updateColor(final int llllllllllllllIlIIIIlIlIllIlIlIl, final boolean llllllllllllllIlIIIIlIlIllIlIlll) {
        if (llllllllllllllIlIIIIlIlIllIlIlll) {
            this.colorSetting.setColorValue(llllllllllllllIlIIIIlIlIllIlIlIl);
        }
        else {
            this.colorSetting.setColorValue(new Color(llllllllllllllIlIIIIlIlIllIlIlIl >> 16 & 0xFF, llllllllllllllIlIIIIlIlIllIlIlIl >> 8 & 0xFF, llllllllllllllIlIIIIlIlIllIlIlIl & 0xFF, (int)(this.alpha * 255.0f)).getRGB());
        }
    }
    
    static {
        COLOR_PICKER_HEIGHT = 80;
        ColorPickerComponent.tessellator = Tessellator.getInstance();
        ColorPickerComponent.buffer = ColorPickerComponent.tessellator.getBuffer();
    }
    
    private void drawCheckeredBackground(final float llllllllllllllIlIIIIlIlIlllIIIlI, float llllllllllllllIlIIIIlIlIlllIIIIl, final float llllllllllllllIlIIIIlIlIlllIIIII, final float llllllllllllllIlIIIIlIlIlllIIlIl) {
        DrawHelper.drawRect(llllllllllllllIlIIIIlIlIlllIIIlI, llllllllllllllIlIIIIlIlIlllIIIIl, llllllllllllllIlIIIIlIlIlllIIIII, llllllllllllllIlIIIIlIlIlllIIlIl, -1);
        boolean llllllllllllllIlIIIIlIlIlllIIlII = false;
        while (llllllllllllllIlIIIIlIlIlllIIIIl < llllllllllllllIlIIIIlIlIlllIIlIl) {
            for (float llllllllllllllIlIIIIlIlIlllIIIll = llllllllllllllIlIIIIlIlIlllIIIlI + ((llllllllllllllIlIIIIlIlIlllIIlII = !llllllllllllllIlIIIIlIlIlllIIlII) ? 1 : 0); llllllllllllllIlIIIIlIlIlllIIIll < llllllllllllllIlIIIIlIlIlllIIIII; llllllllllllllIlIIIIlIlIlllIIIll += 2.0f) {
                DrawHelper.drawRect(llllllllllllllIlIIIIlIlIlllIIIll, llllllllllllllIlIIIIlIlIlllIIIIl, llllllllllllllIlIIIIlIlIlllIIIll + 1.0f, llllllllllllllIlIIIIlIlIlllIIIIl + 1.0f, -8355712);
            }
            ++llllllllllllllIlIIIIlIlIlllIIIIl;
        }
    }
    
    @Override
    public void onPress(final int llllllllllllllIlIIIIlIlIIlllIlIl, final int llllllllllllllIlIIIIlIlIIlllIlII, final int llllllllllllllIlIIIIlIlIIlllIIll) {
    }
    
    @Override
    public Setting getSetting() {
        return this.colorSetting;
    }
    
    @Override
    public void drawComponent(final ScaledResolution llllllllllllllIlIIIIlIllIlIIlIII, final int llllllllllllllIlIIIIlIllIIIIIlll, final int llllllllllllllIlIIIIlIllIlIIIllI) {
        super.drawComponent(llllllllllllllIlIIIIlIllIlIIlIII, llllllllllllllIlIIIIlIllIIIIIlll, llllllllllllllIlIIIIlIllIlIIIllI);
        final int llllllllllllllIlIIIIlIllIlIIIlIl = this.getX();
        final int llllllllllllllIlIIIIlIllIlIIIlII = this.getY();
        final int llllllllllllllIlIIIIlIllIlIIIIll = this.getWidth();
        final int llllllllllllllIlIIIIlIllIlIIIIlI = this.getHeight();
        final int llllllllllllllIlIIIIlIllIlIIIIIl = 16777215;
        Gui.drawRect(llllllllllllllIlIIIIlIllIlIIIlIl, llllllllllllllIlIIIIlIllIlIIIlII, llllllllllllllIlIIIIlIllIlIIIlIl + llllllllllllllIlIIIIlIllIlIIIIll, llllllllllllllIlIIIIlIllIlIIIlII + llllllllllllllIlIIIIlIllIlIIIIlI, new Color(20, 20, 20, 160).getRGB());
        this.mc.sfui18.drawStringWithShadow(this.getName(), llllllllllllllIlIIIIlIllIlIIIlIl + 2, llllllllllllllIlIIIIlIllIlIIIlII + llllllllllllllIlIIIIlIllIlIIIIlI / 2.0f - 3.0f, llllllllllllllIlIIIIlIllIlIIIIIl);
        if (this.isExpanded()) {
            Gui.drawRect(llllllllllllllIlIIIIlIllIlIIIlIl + 1, llllllllllllllIlIIIIlIllIlIIIlII + llllllllllllllIlIIIIlIllIlIIIIlI, llllllllllllllIlIIIIlIllIlIIIlIl + llllllllllllllIlIIIIlIllIlIIIIll - 1, llllllllllllllIlIIIIlIllIlIIIlII + this.getHeightWithExpand(), new Color(20, 20, 20, 160).getRGB());
            final float llllllllllllllIlIIIIlIllIlIIIIII = (float)(llllllllllllllIlIIIIlIllIlIIIlIl + 2);
            final float llllllllllllllIlIIIIlIllIIllllll = (float)(llllllllllllllIlIIIIlIllIlIIIlII + llllllllllllllIlIIIIlIllIlIIIIlI + 2);
            final float llllllllllllllIlIIIIlIllIIlllllI = (float)(llllllllllllllIlIIIIlIllIlIIIlIl + 80 - 2);
            final float llllllllllllllIlIIIIlIllIIllllIl = (float)(llllllllllllllIlIIIIlIllIlIIIlII + llllllllllllllIlIIIIlIllIlIIIIlI + 80 - 2);
            if (llllllllllllllIlIIIIlIllIIIIIlll <= llllllllllllllIlIIIIlIllIlIIIIII || llllllllllllllIlIIIIlIllIlIIIllI <= llllllllllllllIlIIIIlIllIIllllll || llllllllllllllIlIIIIlIllIIIIIlll >= llllllllllllllIlIIIIlIllIIlllllI || llllllllllllllIlIIIIlIllIlIIIllI >= llllllllllllllIlIIIIlIllIIllllIl) {
                this.colorSelectorDragging = false;
            }
            float llllllllllllllIlIIIIlIllIIllllII = this.saturation * (llllllllllllllIlIIIIlIllIIlllllI - llllllllllllllIlIIIIlIllIlIIIIII);
            float llllllllllllllIlIIIIlIllIIlllIll = (1.0f - this.brightness) * (llllllllllllllIlIIIIlIllIIllllIl - llllllllllllllIlIIIIlIllIIllllll);
            if (this.colorSelectorDragging) {
                final float llllllllllllllIlIIIIlIllIIlllIlI = llllllllllllllIlIIIIlIllIIlllllI - llllllllllllllIlIIIIlIllIlIIIIII;
                final float llllllllllllllIlIIIIlIllIIlllIIl = llllllllllllllIlIIIIlIllIIIIIlll - llllllllllllllIlIIIIlIllIlIIIIII;
                this.saturation = llllllllllllllIlIIIIlIllIIlllIIl / llllllllllllllIlIIIIlIllIIlllIlI;
                llllllllllllllIlIIIIlIllIIllllII = llllllllllllllIlIIIIlIllIIlllIIl;
                final float llllllllllllllIlIIIIlIllIIlllIII = llllllllllllllIlIIIIlIllIIllllIl - llllllllllllllIlIIIIlIllIIllllll;
                final float llllllllllllllIlIIIIlIllIIllIlll = llllllllllllllIlIIIIlIllIlIIIllI - llllllllllllllIlIIIIlIllIIllllll;
                this.brightness = 1.0f - llllllllllllllIlIIIIlIllIIllIlll / llllllllllllllIlIIIIlIllIIlllIII;
                llllllllllllllIlIIIIlIllIIlllIll = llllllllllllllIlIIIIlIllIIllIlll;
                this.updateColor(Color.HSBtoRGB(this.hue, this.saturation, this.brightness), false);
            }
            Gui.drawRect(llllllllllllllIlIIIIlIllIlIIIIII, llllllllllllllIlIIIIlIllIIllllll, llllllllllllllIlIIIIlIllIIlllllI, llllllllllllllIlIIIIlIllIIllllIl, -16777216);
            this.drawColorPickerRect(llllllllllllllIlIIIIlIllIlIIIIII + 0.5f, llllllllllllllIlIIIIlIllIIllllll + 0.5f, llllllllllllllIlIIIIlIllIIlllllI - 0.5f, llllllllllllllIlIIIIlIllIIllllIl - 0.5f);
            final float llllllllllllllIlIIIIlIllIIllIllI = 2.0f;
            final float llllllllllllllIlIIIIlIllIIllIlIl = 0.5f;
            final float llllllllllllllIlIIIIlIllIIllIlII = llllllllllllllIlIIIIlIllIIllIllI / 2.0f;
            final float llllllllllllllIlIIIIlIllIIllIIll = llllllllllllllIlIIIIlIllIlIIIIII + llllllllllllllIlIIIIlIllIIllllII - llllllllllllllIlIIIIlIllIIllIlII;
            final float llllllllllllllIlIIIIlIllIIllIIlI = llllllllllllllIlIIIIlIllIIllllll + llllllllllllllIlIIIIlIllIIlllIll - llllllllllllllIlIIIIlIllIIllIlII;
            final float llllllllllllllIlIIIIlIllIIllIIIl = llllllllllllllIlIIIIlIllIlIIIIII + llllllllllllllIlIIIIlIllIIllllII + llllllllllllllIlIIIIlIllIIllIlII;
            final float llllllllllllllIlIIIIlIllIIllIIII = llllllllllllllIlIIIIlIllIIllllll + llllllllllllllIlIIIIlIllIIlllIll + llllllllllllllIlIIIIlIllIIllIlII;
            Gui.drawRect(llllllllllllllIlIIIIlIllIIllIIll - llllllllllllllIlIIIIlIllIIllIlIl, llllllllllllllIlIIIIlIllIIllIIlI - llllllllllllllIlIIIIlIllIIllIlIl, llllllllllllllIlIIIIlIllIIllIIIl + llllllllllllllIlIIIIlIllIIllIlIl, llllllllllllllIlIIIIlIllIIllIIII + llllllllllllllIlIIIIlIllIIllIlIl, -16777216);
            Gui.drawRect(llllllllllllllIlIIIIlIllIIllIIll, llllllllllllllIlIIIIlIllIIllIIlI, llllllllllllllIlIIIIlIllIIllIIIl, llllllllllllllIlIIIIlIllIIllIIII, Color.HSBtoRGB(this.hue, this.saturation, this.brightness));
            final float llllllllllllllIlIIIIlIllIIlIllll = (float)(llllllllllllllIlIIIIlIllIlIIIlIl + 80 - 1);
            final float llllllllllllllIlIIIIlIllIIlIlllI = (float)(llllllllllllllIlIIIIlIllIlIIIlII + llllllllllllllIlIIIIlIllIlIIIIlI + 2);
            final float llllllllllllllIlIIIIlIllIIlIllIl = llllllllllllllIlIIIIlIllIIlIllll + 5.0f;
            final float llllllllllllllIlIIIIlIllIIlIllII = (float)(llllllllllllllIlIIIIlIllIlIIIlII + llllllllllllllIlIIIIlIllIlIIIIlI + 80 - 2);
            if (llllllllllllllIlIIIIlIllIIIIIlll <= llllllllllllllIlIIIIlIllIIlIllll || llllllllllllllIlIIIIlIllIlIIIllI <= llllllllllllllIlIIIIlIllIIlIlllI || llllllllllllllIlIIIIlIllIIIIIlll >= llllllllllllllIlIIIIlIllIIlIllIl || llllllllllllllIlIIIIlIllIlIIIllI >= llllllllllllllIlIIIIlIllIIlIllII) {
                this.hueSelectorDragging = false;
            }
            float llllllllllllllIlIIIIlIllIIlIlIll = this.hue * (llllllllllllllIlIIIIlIllIIlIllII - llllllllllllllIlIIIIlIllIIlIlllI);
            if (this.hueSelectorDragging) {
                final float llllllllllllllIlIIIIlIllIIlIlIlI = llllllllllllllIlIIIIlIllIIlIllII - llllllllllllllIlIIIIlIllIIlIlllI;
                final float llllllllllllllIlIIIIlIllIIlIlIIl = llllllllllllllIlIIIIlIllIlIIIllI - llllllllllllllIlIIIIlIllIIlIlllI;
                this.hue = llllllllllllllIlIIIIlIllIIlIlIIl / llllllllllllllIlIIIIlIllIIlIlIlI;
                llllllllllllllIlIIIIlIllIIlIlIll = llllllllllllllIlIIIIlIllIIlIlIIl;
                this.updateColor(Color.HSBtoRGB(this.hue, this.saturation, this.brightness), false);
            }
            Gui.drawRect(llllllllllllllIlIIIIlIllIIlIllll, llllllllllllllIlIIIIlIllIIlIlllI, llllllllllllllIlIIIIlIllIIlIllIl, llllllllllllllIlIIIIlIllIIlIllII, -16777216);
            final float llllllllllllllIlIIIIlIllIIlIlIII = 0.2f;
            final float llllllllllllllIlIIIIlIllIIlIIlll = 1.0f / llllllllllllllIlIIIIlIllIIlIlIII;
            final float llllllllllllllIlIIIIlIllIIlIIllI = llllllllllllllIlIIIIlIllIIlIllII - llllllllllllllIlIIIIlIllIIlIlllI;
            float llllllllllllllIlIIIIlIllIIlIIlIl = llllllllllllllIlIIIIlIllIIlIlllI + 0.5f;
            float llllllllllllllIlIIIIlIllIIlIIlII = llllllllllllllIlIIIIlIllIIlIIllI / llllllllllllllIlIIIIlIllIIlIIlll;
            for (int llllllllllllllIlIIIIlIllIIlIIIll = 0; llllllllllllllIlIIIIlIllIIlIIIll < llllllllllllllIlIIIIlIllIIlIIlll; ++llllllllllllllIlIIIIlIllIIlIIIll) {
                final boolean llllllllllllllIlIIIIlIllIIlIIIlI = llllllllllllllIlIIIIlIllIIlIIIll == llllllllllllllIlIIIIlIllIIlIIlll - 1.0f;
                if (llllllllllllllIlIIIIlIllIIlIIIlI) {
                    --llllllllllllllIlIIIIlIllIIlIIlII;
                }
                DrawHelper.drawGradientRect(llllllllllllllIlIIIIlIllIIlIllll + 0.5f, llllllllllllllIlIIIIlIllIIlIIlIl, llllllllllllllIlIIIIlIllIIlIllIl - 0.5f, llllllllllllllIlIIIIlIllIIlIIlIl + llllllllllllllIlIIIIlIllIIlIIlII, Color.HSBtoRGB(llllllllllllllIlIIIIlIllIIlIlIII * llllllllllllllIlIIIIlIllIIlIIIll, 1.0f, 1.0f), Color.HSBtoRGB(llllllllllllllIlIIIIlIllIIlIlIII * (llllllllllllllIlIIIIlIllIIlIIIll + 1), 1.0f, 1.0f));
                if (!llllllllllllllIlIIIIlIllIIlIIIlI) {
                    llllllllllllllIlIIIIlIllIIlIIlIl += llllllllllllllIlIIIIlIllIIlIIlII;
                }
            }
            final float llllllllllllllIlIIIIlIllIIlIIIIl = 2.0f;
            final float llllllllllllllIlIIIIlIllIIlIIIII = 0.5f;
            final float llllllllllllllIlIIIIlIllIIIlllll = llllllllllllllIlIIIIlIllIIlIIIIl / 2.0f;
            final float llllllllllllllIlIIIIlIllIIIllllI = llllllllllllllIlIIIIlIllIIlIlllI + llllllllllllllIlIIIIlIllIIlIlIll - llllllllllllllIlIIIIlIllIIIlllll;
            final float llllllllllllllIlIIIIlIllIIIlllIl = llllllllllllllIlIIIIlIllIIlIlllI + llllllllllllllIlIIIIlIllIIlIlIll + llllllllllllllIlIIIIlIllIIIlllll;
            Gui.drawRect(llllllllllllllIlIIIIlIllIIlIllll - llllllllllllllIlIIIIlIllIIlIIIII, llllllllllllllIlIIIIlIllIIIllllI - llllllllllllllIlIIIIlIllIIlIIIII, llllllllllllllIlIIIIlIllIIlIllIl + llllllllllllllIlIIIIlIllIIlIIIII, llllllllllllllIlIIIIlIllIIIlllIl + llllllllllllllIlIIIIlIllIIlIIIII, -16777216);
            Gui.drawRect(llllllllllllllIlIIIIlIllIIlIllll, llllllllllllllIlIIIIlIllIIIllllI, llllllllllllllIlIIIIlIllIIlIllIl, llllllllllllllIlIIIIlIllIIIlllIl, Color.HSBtoRGB(this.hue, 1.0f, 1.0f));
            final float llllllllllllllIlIIIIlIllIIIlllII = (float)(llllllllllllllIlIIIIlIllIlIIIlIl + 80 + 6);
            final float llllllllllllllIlIIIIlIllIIIllIll = (float)(llllllllllllllIlIIIIlIllIlIIIlII + llllllllllllllIlIIIIlIllIlIIIIlI + 2);
            final float llllllllllllllIlIIIIlIllIIIllIlI = llllllllllllllIlIIIIlIllIIIlllII + 5.0f;
            final float llllllllllllllIlIIIIlIllIIIllIIl = (float)(llllllllllllllIlIIIIlIllIlIIIlII + llllllllllllllIlIIIIlIllIlIIIIlI + 80 - 2);
            if (llllllllllllllIlIIIIlIllIIIIIlll <= llllllllllllllIlIIIIlIllIIIlllII || llllllllllllllIlIIIIlIllIlIIIllI <= llllllllllllllIlIIIIlIllIIIllIll || llllllllllllllIlIIIIlIllIIIIIlll >= llllllllllllllIlIIIIlIllIIIllIlI || llllllllllllllIlIIIIlIllIlIIIllI >= llllllllllllllIlIIIIlIllIIIllIIl) {
                this.alphaSelectorDragging = false;
            }
            final int llllllllllllllIlIIIIlIllIIIllIII = Color.HSBtoRGB(this.hue, this.saturation, this.brightness);
            final int llllllllllllllIlIIIIlIllIIIlIlll = llllllllllllllIlIIIIlIllIIIllIII >> 16 & 0xFF;
            final int llllllllllllllIlIIIIlIllIIIlIllI = llllllllllllllIlIIIIlIllIIIllIII >> 8 & 0xFF;
            final int llllllllllllllIlIIIIlIllIIIlIlIl = llllllllllllllIlIIIIlIllIIIllIII & 0xFF;
            float llllllllllllllIlIIIIlIllIIIlIlII = this.alpha * (llllllllllllllIlIIIIlIllIIIllIIl - llllllllllllllIlIIIIlIllIIIllIll);
            if (this.alphaSelectorDragging) {
                final float llllllllllllllIlIIIIlIllIIIlIIll = llllllllllllllIlIIIIlIllIIIllIIl - llllllllllllllIlIIIIlIllIIIllIll;
                final float llllllllllllllIlIIIIlIllIIIlIIlI = llllllllllllllIlIIIIlIllIlIIIllI - llllllllllllllIlIIIIlIllIIIllIll;
                this.alpha = llllllllllllllIlIIIIlIllIIIlIIlI / llllllllllllllIlIIIIlIllIIIlIIll;
                llllllllllllllIlIIIIlIllIIIlIlII = llllllllllllllIlIIIIlIllIIIlIIlI;
                this.updateColor(new Color(llllllllllllllIlIIIIlIllIIIlIlll, llllllllllllllIlIIIIlIllIIIlIllI, llllllllllllllIlIIIIlIllIIIlIlIl, (int)(this.alpha * 255.0f)).getRGB(), true);
            }
            Gui.drawRect(llllllllllllllIlIIIIlIllIIIlllII, llllllllllllllIlIIIIlIllIIIllIll, llllllllllllllIlIIIIlIllIIIllIlI, llllllllllllllIlIIIIlIllIIIllIIl, -16777216);
            this.drawCheckeredBackground(llllllllllllllIlIIIIlIllIIIlllII + 0.5f, llllllllllllllIlIIIIlIllIIIllIll + 0.5f, llllllllllllllIlIIIIlIllIIIllIlI - 0.5f, llllllllllllllIlIIIIlIllIIIllIIl - 0.5f);
            DrawHelper.drawGradientRect(llllllllllllllIlIIIIlIllIIIlllII + 0.5f, llllllllllllllIlIIIIlIllIIIllIll + 0.5f, llllllllllllllIlIIIIlIllIIIllIlI - 0.5f, llllllllllllllIlIIIIlIllIIIllIIl - 0.5f, new Color(llllllllllllllIlIIIIlIllIIIlIlll, llllllllllllllIlIIIIlIllIIIlIllI, llllllllllllllIlIIIIlIllIIIlIlIl, 0).getRGB(), new Color(llllllllllllllIlIIIIlIllIIIlIlll, llllllllllllllIlIIIIlIllIIIlIllI, llllllllllllllIlIIIIlIllIIIlIlIl, 255).getRGB());
            final float llllllllllllllIlIIIIlIllIIIlIIIl = 2.0f;
            final float llllllllllllllIlIIIIlIllIIIlIIII = 0.5f;
            final float llllllllllllllIlIIIIlIllIIIIllll = llllllllllllllIlIIIIlIllIIIlIIIl / 2.0f;
            final float llllllllllllllIlIIIIlIllIIIIlllI = llllllllllllllIlIIIIlIllIIIllIll + llllllllllllllIlIIIIlIllIIIlIlII - llllllllllllllIlIIIIlIllIIIIllll;
            final float llllllllllllllIlIIIIlIllIIIIllIl = llllllllllllllIlIIIIlIllIIIllIll + llllllllllllllIlIIIIlIllIIIlIlII + llllllllllllllIlIIIIlIllIIIIllll;
            final float llllllllllllllIlIIIIlIllIIIIllII = llllllllllllllIlIIIIlIllIIIllIlI + llllllllllllllIlIIIIlIllIIIlIIII;
            final float llllllllllllllIlIIIIlIllIIIIlIll = llllllllllllllIlIIIIlIllIIIIlllI - llllllllllllllIlIIIIlIllIIIlIIII;
            final float llllllllllllllIlIIIIlIllIIIIlIlI = llllllllllllllIlIIIIlIllIIIIllIl + llllllllllllllIlIIIIlIllIIIlIIII;
            GL11.glDisable(3553);
            DrawHelper.setColor(-16777216);
            GL11.glBegin(2);
            GL11.glVertex2f(llllllllllllllIlIIIIlIllIIIlllII, llllllllllllllIlIIIIlIllIIIIlIll);
            GL11.glVertex2f(llllllllllllllIlIIIIlIllIIIlllII, llllllllllllllIlIIIIlIllIIIIlIlI);
            GL11.glVertex2f(llllllllllllllIlIIIIlIllIIIIllII, llllllllllllllIlIIIIlIllIIIIlIlI);
            GL11.glVertex2f(llllllllllllllIlIIIIlIllIIIIllII, llllllllllllllIlIIIIlIllIIIIlIll);
            GL11.glEnd();
            GL11.glEnable(3553);
        }
    }
    
    public void drawColorPickerRect(final float llllllllllllllIlIIIIlIlIlIIIIlIl, final float llllllllllllllIlIIIIlIlIlIIIIlII, final float llllllllllllllIlIIIIlIlIIlllllIl, final float llllllllllllllIlIIIIlIlIIlllllII) {
        final int llllllllllllllIlIIIIlIlIlIIIIIIl = Color.HSBtoRGB(this.hue, 1.0f, 1.0f);
        GL11.glDisable(3553);
        GlStateManager.enableBlend();
        GL11.glShadeModel(7425);
        ColorPickerComponent.buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        ColorPickerComponent.buffer.pos(llllllllllllllIlIIIIlIlIIlllllIl, llllllllllllllIlIIIIlIlIlIIIIlII, 0.0).color(llllllllllllllIlIIIIlIlIlIIIIIIl).endVertex();
        ColorPickerComponent.buffer.pos(llllllllllllllIlIIIIlIlIlIIIIlIl, llllllllllllllIlIIIIlIlIlIIIIlII, 0.0).color(-1).endVertex();
        ColorPickerComponent.buffer.pos(llllllllllllllIlIIIIlIlIlIIIIlIl, llllllllllllllIlIIIIlIlIIlllllII, 0.0).color(-1).endVertex();
        ColorPickerComponent.buffer.pos(llllllllllllllIlIIIIlIlIIlllllIl, llllllllllllllIlIIIIlIlIIlllllII, 0.0).color(llllllllllllllIlIIIIlIlIlIIIIIIl).endVertex();
        ColorPickerComponent.tessellator.draw();
        ColorPickerComponent.buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        ColorPickerComponent.buffer.pos(llllllllllllllIlIIIIlIlIIlllllIl, llllllllllllllIlIIIIlIlIlIIIIlII, 0.0).color(402653184).endVertex();
        ColorPickerComponent.buffer.pos(llllllllllllllIlIIIIlIlIlIIIIlIl, llllllllllllllIlIIIIlIlIlIIIIlII, 0.0).color(402653184).endVertex();
        ColorPickerComponent.buffer.pos(llllllllllllllIlIIIIlIlIlIIIIlIl, llllllllllllllIlIIIIlIlIIlllllII, 0.0).color(-16777216).endVertex();
        ColorPickerComponent.buffer.pos(llllllllllllllIlIIIIlIlIIlllllIl, llllllllllllllIlIIIIlIlIIlllllII, 0.0).color(-16777216).endVertex();
        ColorPickerComponent.tessellator.draw();
        GlStateManager.disableBlend();
        GL11.glShadeModel(7425);
        GL11.glEnable(3553);
    }
}
