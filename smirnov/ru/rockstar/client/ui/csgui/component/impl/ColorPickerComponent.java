// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui.component.impl;

import ru.rockstar.client.ui.settings.Setting;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import java.awt.Color;
import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.client.ui.csgui.component.Component;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.csgui.component.PropertyComponent;
import ru.rockstar.client.ui.csgui.component.ExpandableComponent;

public class ColorPickerComponent extends ExpandableComponent implements PropertyComponent
{
    private final /* synthetic */ ColorSetting colorSetting;
    private /* synthetic */ float brightness;
    private /* synthetic */ boolean colorSelectorDragging;
    private /* synthetic */ float alpha;
    /* synthetic */ Minecraft mc;
    public static /* synthetic */ Tessellator tessellator;
    private /* synthetic */ boolean alphaSelectorDragging;
    private /* synthetic */ float saturation;
    private /* synthetic */ boolean hueSelectorDragging;
    private /* synthetic */ float hue;
    public static /* synthetic */ BufferBuilder buffer;
    
    @Override
    public boolean canExpand() {
        return true;
    }
    
    public ColorPickerComponent(final Component lllllllllllIIIIlIIlIlllIllIlllII, final ColorSetting lllllllllllIIIIlIIlIlllIllIllIll, final int lllllllllllIIIIlIIlIlllIlllIIIll, final int lllllllllllIIIIlIIlIlllIllIllIIl, final int lllllllllllIIIIlIIlIlllIlllIIIIl, final int lllllllllllIIIIlIIlIlllIllIlIlll) {
        super(lllllllllllIIIIlIIlIlllIllIlllII, lllllllllllIIIIlIIlIlllIllIllIll.getName(), lllllllllllIIIIlIIlIlllIlllIIIll, lllllllllllIIIIlIIlIlllIllIllIIl, lllllllllllIIIIlIIlIlllIlllIIIIl, lllllllllllIIIIlIIlIlllIllIlIlll);
        this.mc = Minecraft.getMinecraft();
        this.colorSetting = lllllllllllIIIIlIIlIlllIllIllIll;
        final int lllllllllllIIIIlIIlIlllIllIlllll = lllllllllllIIIIlIIlIlllIllIllIll.getColorValue();
        final float[] lllllllllllIIIIlIIlIlllIllIllllI = this.getHSBFromColor(lllllllllllIIIIlIIlIlllIllIlllll);
        this.hue = lllllllllllIIIIlIIlIlllIllIllllI[0];
        this.saturation = lllllllllllIIIIlIIlIlllIllIllllI[1];
        this.brightness = lllllllllllIIIIlIIlIlllIllIllllI[2];
        this.alpha = (lllllllllllIIIIlIIlIlllIllIlllll >> 24 & 0xFF) / 255.0f;
    }
    
    static {
        COLOR_PICKER_HEIGHT = 80;
        ColorPickerComponent.tessellator = Tessellator.getInstance();
        ColorPickerComponent.buffer = ColorPickerComponent.tessellator.getBuffer();
    }
    
    private void drawCheckeredBackground(final float lllllllllllIIIIlIIlIlllIIlIllIIl, float lllllllllllIIIIlIIlIlllIIlIlIIlI, final float lllllllllllIIIIlIIlIlllIIlIlIlll, final float lllllllllllIIIIlIIlIlllIIlIlIllI) {
        DrawHelper.drawRect(lllllllllllIIIIlIIlIlllIIlIllIIl, lllllllllllIIIIlIIlIlllIIlIlIIlI, lllllllllllIIIIlIIlIlllIIlIlIlll, lllllllllllIIIIlIIlIlllIIlIlIllI, -1);
        boolean lllllllllllIIIIlIIlIlllIIlIlIlIl = false;
        while (lllllllllllIIIIlIIlIlllIIlIlIIlI < lllllllllllIIIIlIIlIlllIIlIlIllI) {
            for (float lllllllllllIIIIlIIlIlllIIlIlIlII = lllllllllllIIIIlIIlIlllIIlIllIIl + ((lllllllllllIIIIlIIlIlllIIlIlIlIl = !lllllllllllIIIIlIIlIlllIIlIlIlIl) ? 1 : 0); lllllllllllIIIIlIIlIlllIIlIlIlII < lllllllllllIIIIlIIlIlllIIlIlIlll; lllllllllllIIIIlIIlIlllIIlIlIlII += 2.0f) {
                DrawHelper.drawRect(lllllllllllIIIIlIIlIlllIIlIlIlII, lllllllllllIIIIlIIlIlllIIlIlIIlI, lllllllllllIIIIlIIlIlllIIlIlIlII + 1.0f, lllllllllllIIIIlIIlIlllIIlIlIIlI + 1.0f, -8355712);
            }
            ++lllllllllllIIIIlIIlIlllIIlIlIIlI;
        }
    }
    
    @Override
    public int getHeightWithExpand() {
        return this.getHeight() + 80;
    }
    
    @Override
    public void onPress(final int lllllllllllIIIIlIIlIllIllllIIllI, final int lllllllllllIIIIlIIlIllIllllIIlIl, final int lllllllllllIIIIlIIlIllIllllIIlII) {
    }
    
    public void drawColorPickerRect(final float lllllllllllIIIIlIIlIllIlllllIllI, final float lllllllllllIIIIlIIlIllIlllllIlIl, final float lllllllllllIIIIlIIlIllIllllIlllI, final float lllllllllllIIIIlIIlIllIlllllIIll) {
        final int lllllllllllIIIIlIIlIllIlllllIIlI = Color.HSBtoRGB(this.hue, 1.0f, 1.0f);
        GL11.glDisable(3553);
        GlStateManager.enableBlend();
        GL11.glShadeModel(7425);
        ColorPickerComponent.buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        ColorPickerComponent.buffer.pos(lllllllllllIIIIlIIlIllIllllIlllI, lllllllllllIIIIlIIlIllIlllllIlIl, 0.0).color(lllllllllllIIIIlIIlIllIlllllIIlI).endVertex();
        ColorPickerComponent.buffer.pos(lllllllllllIIIIlIIlIllIlllllIllI, lllllllllllIIIIlIIlIllIlllllIlIl, 0.0).color(-1).endVertex();
        ColorPickerComponent.buffer.pos(lllllllllllIIIIlIIlIllIlllllIllI, lllllllllllIIIIlIIlIllIlllllIIll, 0.0).color(-1).endVertex();
        ColorPickerComponent.buffer.pos(lllllllllllIIIIlIIlIllIllllIlllI, lllllllllllIIIIlIIlIllIlllllIIll, 0.0).color(lllllllllllIIIIlIIlIllIlllllIIlI).endVertex();
        ColorPickerComponent.tessellator.draw();
        ColorPickerComponent.buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        ColorPickerComponent.buffer.pos(lllllllllllIIIIlIIlIllIllllIlllI, lllllllllllIIIIlIIlIllIlllllIlIl, 0.0).color(402653184).endVertex();
        ColorPickerComponent.buffer.pos(lllllllllllIIIIlIIlIllIlllllIllI, lllllllllllIIIIlIIlIllIlllllIlIl, 0.0).color(402653184).endVertex();
        ColorPickerComponent.buffer.pos(lllllllllllIIIIlIIlIllIlllllIllI, lllllllllllIIIIlIIlIllIlllllIIll, 0.0).color(-16777216).endVertex();
        ColorPickerComponent.buffer.pos(lllllllllllIIIIlIIlIllIllllIlllI, lllllllllllIIIIlIIlIllIlllllIIll, 0.0).color(-16777216).endVertex();
        ColorPickerComponent.tessellator.draw();
        GlStateManager.disableBlend();
        GL11.glShadeModel(7425);
        GL11.glEnable(3553);
    }
    
    private float[] getHSBFromColor(final int lllllllllllIIIIlIIlIlllIIIIIIIIl) {
        final int lllllllllllIIIIlIIlIlllIIIIIIlII = lllllllllllIIIIlIIlIlllIIIIIIIIl >> 16 & 0xFF;
        final int lllllllllllIIIIlIIlIlllIIIIIIIll = lllllllllllIIIIlIIlIlllIIIIIIIIl >> 8 & 0xFF;
        final int lllllllllllIIIIlIIlIlllIIIIIIIlI = lllllllllllIIIIlIIlIlllIIIIIIIIl & 0xFF;
        return Color.RGBtoHSB(lllllllllllIIIIlIIlIlllIIIIIIlII, lllllllllllIIIIlIIlIlllIIIIIIIll, lllllllllllIIIIlIIlIlllIIIIIIIlI, null);
    }
    
    @Override
    public void onMouseClick(final int lllllllllllIIIIlIIlIlllIIIIlllll, final int lllllllllllIIIIlIIlIlllIIIIllllI, final int lllllllllllIIIIlIIlIlllIIIIlllIl) {
        super.onMouseClick(lllllllllllIIIIlIIlIlllIIIIlllll, lllllllllllIIIIlIIlIlllIIIIllllI, lllllllllllIIIIlIIlIlllIIIIlllIl);
        if (this.isExpanded() && lllllllllllIIIIlIIlIlllIIIIlllIl == 0) {
            final int lllllllllllIIIIlIIlIlllIIIlIlllI = this.getX();
            final int lllllllllllIIIIlIIlIlllIIIlIllIl = this.getY();
            final float lllllllllllIIIIlIIlIlllIIIlIllII = (float)(lllllllllllIIIIlIIlIlllIIIlIlllI + 2);
            final float lllllllllllIIIIlIIlIlllIIIlIlIll = (float)(lllllllllllIIIIlIIlIlllIIIlIllIl + this.getHeight() + 2);
            final float lllllllllllIIIIlIIlIlllIIIlIlIlI = (float)(lllllllllllIIIIlIIlIlllIIIlIlllI + 80 - 2);
            final float lllllllllllIIIIlIIlIlllIIIlIlIIl = (float)(lllllllllllIIIIlIIlIlllIIIlIllIl + this.getHeight() + 80 - 2);
            final float lllllllllllIIIIlIIlIlllIIIlIlIII = (float)(lllllllllllIIIIlIIlIlllIIIlIlllI + 80 - 1);
            final float lllllllllllIIIIlIIlIlllIIIlIIlll = (float)(lllllllllllIIIIlIIlIlllIIIlIllIl + this.getHeight() + 2);
            final float lllllllllllIIIIlIIlIlllIIIlIIllI = lllllllllllIIIIlIIlIlllIIIlIlIII + 5.0f;
            final float lllllllllllIIIIlIIlIlllIIIlIIlIl = (float)(lllllllllllIIIIlIIlIlllIIIlIllIl + this.getHeight() + 80 - 2);
            final float lllllllllllIIIIlIIlIlllIIIlIIlII = (float)(lllllllllllIIIIlIIlIlllIIIlIlllI + 80 + 6);
            final float lllllllllllIIIIlIIlIlllIIIlIIIll = (float)(lllllllllllIIIIlIIlIlllIIIlIllIl + this.getHeight() + 2);
            final float lllllllllllIIIIlIIlIlllIIIlIIIlI = lllllllllllIIIIlIIlIlllIIIlIIlII + 5.0f;
            final float lllllllllllIIIIlIIlIlllIIIlIIIIl = (float)(lllllllllllIIIIlIIlIlllIIIlIllIl + this.getHeight() + 80 - 2);
            this.colorSelectorDragging = (!this.colorSelectorDragging && lllllllllllIIIIlIIlIlllIIIIlllll > lllllllllllIIIIlIIlIlllIIIlIllII && lllllllllllIIIIlIIlIlllIIIIllllI > lllllllllllIIIIlIIlIlllIIIlIlIll && lllllllllllIIIIlIIlIlllIIIIlllll < lllllllllllIIIIlIIlIlllIIIlIlIlI && lllllllllllIIIIlIIlIlllIIIIllllI < lllllllllllIIIIlIIlIlllIIIlIlIIl);
            this.hueSelectorDragging = (!this.hueSelectorDragging && lllllllllllIIIIlIIlIlllIIIIlllll > lllllllllllIIIIlIIlIlllIIIlIlIII && lllllllllllIIIIlIIlIlllIIIIllllI > lllllllllllIIIIlIIlIlllIIIlIIlll && lllllllllllIIIIlIIlIlllIIIIlllll < lllllllllllIIIIlIIlIlllIIIlIIllI && lllllllllllIIIIlIIlIlllIIIIllllI < lllllllllllIIIIlIIlIlllIIIlIIlIl);
            this.alphaSelectorDragging = (!this.alphaSelectorDragging && lllllllllllIIIIlIIlIlllIIIIlllll > lllllllllllIIIIlIIlIlllIIIlIIlII && lllllllllllIIIIlIIlIlllIIIIllllI > lllllllllllIIIIlIIlIlllIIIlIIIll && lllllllllllIIIIlIIlIlllIIIIlllll < lllllllllllIIIIlIIlIlllIIIlIIIlI && lllllllllllIIIIlIIlIlllIIIIllllI < lllllllllllIIIIlIIlIlllIIIlIIIIl);
        }
    }
    
    @Override
    public void onMouseRelease(final int lllllllllllIIIIlIIlIlllIIIIIllII) {
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
    
    private void updateColor(final int lllllllllllIIIIlIIlIlllIIlIIIllI, final boolean lllllllllllIIIIlIIlIlllIIlIIlIII) {
        if (lllllllllllIIIIlIIlIlllIIlIIlIII) {
            this.colorSetting.setColorValue(lllllllllllIIIIlIIlIlllIIlIIIllI);
        }
        else {
            this.colorSetting.setColorValue(new Color(lllllllllllIIIIlIIlIlllIIlIIIllI >> 16 & 0xFF, lllllllllllIIIIlIIlIlllIIlIIIllI >> 8 & 0xFF, lllllllllllIIIIlIIlIlllIIlIIIllI & 0xFF, (int)(this.alpha * 255.0f)).getRGB());
        }
    }
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllIIIIlIIlIlllIIllllIIl, final int lllllllllllIIIIlIIlIlllIlIlllIII, final int lllllllllllIIIIlIIlIlllIlIllIlll) {
        super.drawComponent(lllllllllllIIIIlIIlIlllIIllllIIl, lllllllllllIIIIlIIlIlllIlIlllIII, lllllllllllIIIIlIIlIlllIlIllIlll);
        final int lllllllllllIIIIlIIlIlllIlIllIllI = this.getX();
        final int lllllllllllIIIIlIIlIlllIlIllIlIl = this.getY();
        final int lllllllllllIIIIlIIlIlllIlIllIlII = this.getWidth();
        final int lllllllllllIIIIlIIlIlllIlIllIIll = this.getHeight();
        final int lllllllllllIIIIlIIlIlllIlIllIIlI = 16777215;
        Gui.drawRect(lllllllllllIIIIlIIlIlllIlIllIllI, lllllllllllIIIIlIIlIlllIlIllIlIl, lllllllllllIIIIlIIlIlllIlIllIllI + lllllllllllIIIIlIIlIlllIlIllIlII, lllllllllllIIIIlIIlIlllIlIllIlIl + lllllllllllIIIIlIIlIlllIlIllIIll, new Color(20, 20, 20, 160).getRGB());
        this.mc.sfui18.drawStringWithShadow(this.getName(), lllllllllllIIIIlIIlIlllIlIllIllI + 2, lllllllllllIIIIlIIlIlllIlIllIlIl + lllllllllllIIIIlIIlIlllIlIllIIll / 2.0f - 3.0f, lllllllllllIIIIlIIlIlllIlIllIIlI);
        if (this.isExpanded()) {
            Gui.drawRect(lllllllllllIIIIlIIlIlllIlIllIllI + 1, lllllllllllIIIIlIIlIlllIlIllIlIl + lllllllllllIIIIlIIlIlllIlIllIIll, lllllllllllIIIIlIIlIlllIlIllIllI + lllllllllllIIIIlIIlIlllIlIllIlII - 1, lllllllllllIIIIlIIlIlllIlIllIlIl + this.getHeightWithExpand(), new Color(20, 20, 20, 160).getRGB());
            final float lllllllllllIIIIlIIlIlllIlIllIIIl = (float)(lllllllllllIIIIlIIlIlllIlIllIllI + 2);
            final float lllllllllllIIIIlIIlIlllIlIllIIII = (float)(lllllllllllIIIIlIIlIlllIlIllIlIl + lllllllllllIIIIlIIlIlllIlIllIIll + 2);
            final float lllllllllllIIIIlIIlIlllIlIlIllll = (float)(lllllllllllIIIIlIIlIlllIlIllIllI + 80 - 2);
            final float lllllllllllIIIIlIIlIlllIlIlIlllI = (float)(lllllllllllIIIIlIIlIlllIlIllIlIl + lllllllllllIIIIlIIlIlllIlIllIIll + 80 - 2);
            if (lllllllllllIIIIlIIlIlllIlIlllIII <= lllllllllllIIIIlIIlIlllIlIllIIIl || lllllllllllIIIIlIIlIlllIlIllIlll <= lllllllllllIIIIlIIlIlllIlIllIIII || lllllllllllIIIIlIIlIlllIlIlllIII >= lllllllllllIIIIlIIlIlllIlIlIllll || lllllllllllIIIIlIIlIlllIlIllIlll >= lllllllllllIIIIlIIlIlllIlIlIlllI) {
                this.colorSelectorDragging = false;
            }
            float lllllllllllIIIIlIIlIlllIlIlIllIl = this.saturation * (lllllllllllIIIIlIIlIlllIlIlIllll - lllllllllllIIIIlIIlIlllIlIllIIIl);
            float lllllllllllIIIIlIIlIlllIlIlIllII = (1.0f - this.brightness) * (lllllllllllIIIIlIIlIlllIlIlIlllI - lllllllllllIIIIlIIlIlllIlIllIIII);
            if (this.colorSelectorDragging) {
                final float lllllllllllIIIIlIIlIlllIlIlIlIll = lllllllllllIIIIlIIlIlllIlIlIllll - lllllllllllIIIIlIIlIlllIlIllIIIl;
                final float lllllllllllIIIIlIIlIlllIlIlIlIlI = lllllllllllIIIIlIIlIlllIlIlllIII - lllllllllllIIIIlIIlIlllIlIllIIIl;
                this.saturation = lllllllllllIIIIlIIlIlllIlIlIlIlI / lllllllllllIIIIlIIlIlllIlIlIlIll;
                lllllllllllIIIIlIIlIlllIlIlIllIl = lllllllllllIIIIlIIlIlllIlIlIlIlI;
                final float lllllllllllIIIIlIIlIlllIlIlIlIIl = lllllllllllIIIIlIIlIlllIlIlIlllI - lllllllllllIIIIlIIlIlllIlIllIIII;
                final float lllllllllllIIIIlIIlIlllIlIlIlIII = lllllllllllIIIIlIIlIlllIlIllIlll - lllllllllllIIIIlIIlIlllIlIllIIII;
                this.brightness = 1.0f - lllllllllllIIIIlIIlIlllIlIlIlIII / lllllllllllIIIIlIIlIlllIlIlIlIIl;
                lllllllllllIIIIlIIlIlllIlIlIllII = lllllllllllIIIIlIIlIlllIlIlIlIII;
                this.updateColor(Color.HSBtoRGB(this.hue, this.saturation, this.brightness), false);
            }
            Gui.drawRect(lllllllllllIIIIlIIlIlllIlIllIIIl, lllllllllllIIIIlIIlIlllIlIllIIII, lllllllllllIIIIlIIlIlllIlIlIllll, lllllllllllIIIIlIIlIlllIlIlIlllI, -16777216);
            this.drawColorPickerRect(lllllllllllIIIIlIIlIlllIlIllIIIl + 0.5f, lllllllllllIIIIlIIlIlllIlIllIIII + 0.5f, lllllllllllIIIIlIIlIlllIlIlIllll - 0.5f, lllllllllllIIIIlIIlIlllIlIlIlllI - 0.5f);
            final float lllllllllllIIIIlIIlIlllIlIlIIlll = 2.0f;
            final float lllllllllllIIIIlIIlIlllIlIlIIllI = 0.5f;
            final float lllllllllllIIIIlIIlIlllIlIlIIlIl = lllllllllllIIIIlIIlIlllIlIlIIlll / 2.0f;
            final float lllllllllllIIIIlIIlIlllIlIlIIlII = lllllllllllIIIIlIIlIlllIlIllIIIl + lllllllllllIIIIlIIlIlllIlIlIllIl - lllllllllllIIIIlIIlIlllIlIlIIlIl;
            final float lllllllllllIIIIlIIlIlllIlIlIIIll = lllllllllllIIIIlIIlIlllIlIllIIII + lllllllllllIIIIlIIlIlllIlIlIllII - lllllllllllIIIIlIIlIlllIlIlIIlIl;
            final float lllllllllllIIIIlIIlIlllIlIlIIIlI = lllllllllllIIIIlIIlIlllIlIllIIIl + lllllllllllIIIIlIIlIlllIlIlIllIl + lllllllllllIIIIlIIlIlllIlIlIIlIl;
            final float lllllllllllIIIIlIIlIlllIlIlIIIIl = lllllllllllIIIIlIIlIlllIlIllIIII + lllllllllllIIIIlIIlIlllIlIlIllII + lllllllllllIIIIlIIlIlllIlIlIIlIl;
            Gui.drawRect(lllllllllllIIIIlIIlIlllIlIlIIlII - lllllllllllIIIIlIIlIlllIlIlIIllI, lllllllllllIIIIlIIlIlllIlIlIIIll - lllllllllllIIIIlIIlIlllIlIlIIllI, lllllllllllIIIIlIIlIlllIlIlIIIlI + lllllllllllIIIIlIIlIlllIlIlIIllI, lllllllllllIIIIlIIlIlllIlIlIIIIl + lllllllllllIIIIlIIlIlllIlIlIIllI, -16777216);
            Gui.drawRect(lllllllllllIIIIlIIlIlllIlIlIIlII, lllllllllllIIIIlIIlIlllIlIlIIIll, lllllllllllIIIIlIIlIlllIlIlIIIlI, lllllllllllIIIIlIIlIlllIlIlIIIIl, Color.HSBtoRGB(this.hue, this.saturation, this.brightness));
            final float lllllllllllIIIIlIIlIlllIlIlIIIII = (float)(lllllllllllIIIIlIIlIlllIlIllIllI + 80 - 1);
            final float lllllllllllIIIIlIIlIlllIlIIlllll = (float)(lllllllllllIIIIlIIlIlllIlIllIlIl + lllllllllllIIIIlIIlIlllIlIllIIll + 2);
            final float lllllllllllIIIIlIIlIlllIlIIllllI = lllllllllllIIIIlIIlIlllIlIlIIIII + 5.0f;
            final float lllllllllllIIIIlIIlIlllIlIIlllIl = (float)(lllllllllllIIIIlIIlIlllIlIllIlIl + lllllllllllIIIIlIIlIlllIlIllIIll + 80 - 2);
            if (lllllllllllIIIIlIIlIlllIlIlllIII <= lllllllllllIIIIlIIlIlllIlIlIIIII || lllllllllllIIIIlIIlIlllIlIllIlll <= lllllllllllIIIIlIIlIlllIlIIlllll || lllllllllllIIIIlIIlIlllIlIlllIII >= lllllllllllIIIIlIIlIlllIlIIllllI || lllllllllllIIIIlIIlIlllIlIllIlll >= lllllllllllIIIIlIIlIlllIlIIlllIl) {
                this.hueSelectorDragging = false;
            }
            float lllllllllllIIIIlIIlIlllIlIIlllII = this.hue * (lllllllllllIIIIlIIlIlllIlIIlllIl - lllllllllllIIIIlIIlIlllIlIIlllll);
            if (this.hueSelectorDragging) {
                final float lllllllllllIIIIlIIlIlllIlIIllIll = lllllllllllIIIIlIIlIlllIlIIlllIl - lllllllllllIIIIlIIlIlllIlIIlllll;
                final float lllllllllllIIIIlIIlIlllIlIIllIlI = lllllllllllIIIIlIIlIlllIlIllIlll - lllllllllllIIIIlIIlIlllIlIIlllll;
                this.hue = lllllllllllIIIIlIIlIlllIlIIllIlI / lllllllllllIIIIlIIlIlllIlIIllIll;
                lllllllllllIIIIlIIlIlllIlIIlllII = lllllllllllIIIIlIIlIlllIlIIllIlI;
                this.updateColor(Color.HSBtoRGB(this.hue, this.saturation, this.brightness), false);
            }
            Gui.drawRect(lllllllllllIIIIlIIlIlllIlIlIIIII, lllllllllllIIIIlIIlIlllIlIIlllll, lllllllllllIIIIlIIlIlllIlIIllllI, lllllllllllIIIIlIIlIlllIlIIlllIl, -16777216);
            final float lllllllllllIIIIlIIlIlllIlIIllIIl = 0.2f;
            final float lllllllllllIIIIlIIlIlllIlIIllIII = 1.0f / lllllllllllIIIIlIIlIlllIlIIllIIl;
            final float lllllllllllIIIIlIIlIlllIlIIlIlll = lllllllllllIIIIlIIlIlllIlIIlllIl - lllllllllllIIIIlIIlIlllIlIIlllll;
            float lllllllllllIIIIlIIlIlllIlIIlIllI = lllllllllllIIIIlIIlIlllIlIIlllll + 0.5f;
            float lllllllllllIIIIlIIlIlllIlIIlIlIl = lllllllllllIIIIlIIlIlllIlIIlIlll / lllllllllllIIIIlIIlIlllIlIIllIII;
            for (int lllllllllllIIIIlIIlIlllIlIIlIlII = 0; lllllllllllIIIIlIIlIlllIlIIlIlII < lllllllllllIIIIlIIlIlllIlIIllIII; ++lllllllllllIIIIlIIlIlllIlIIlIlII) {
                final boolean lllllllllllIIIIlIIlIlllIlIIlIIll = lllllllllllIIIIlIIlIlllIlIIlIlII == lllllllllllIIIIlIIlIlllIlIIllIII - 1.0f;
                if (lllllllllllIIIIlIIlIlllIlIIlIIll) {
                    --lllllllllllIIIIlIIlIlllIlIIlIlIl;
                }
                DrawHelper.drawGradientRect(lllllllllllIIIIlIIlIlllIlIlIIIII + 0.5f, lllllllllllIIIIlIIlIlllIlIIlIllI, lllllllllllIIIIlIIlIlllIlIIllllI - 0.5f, lllllllllllIIIIlIIlIlllIlIIlIllI + lllllllllllIIIIlIIlIlllIlIIlIlIl, Color.HSBtoRGB(lllllllllllIIIIlIIlIlllIlIIllIIl * lllllllllllIIIIlIIlIlllIlIIlIlII, 1.0f, 1.0f), Color.HSBtoRGB(lllllllllllIIIIlIIlIlllIlIIllIIl * (lllllllllllIIIIlIIlIlllIlIIlIlII + 1), 1.0f, 1.0f));
                if (!lllllllllllIIIIlIIlIlllIlIIlIIll) {
                    lllllllllllIIIIlIIlIlllIlIIlIllI += lllllllllllIIIIlIIlIlllIlIIlIlIl;
                }
            }
            final float lllllllllllIIIIlIIlIlllIlIIlIIlI = 2.0f;
            final float lllllllllllIIIIlIIlIlllIlIIlIIIl = 0.5f;
            final float lllllllllllIIIIlIIlIlllIlIIlIIII = lllllllllllIIIIlIIlIlllIlIIlIIlI / 2.0f;
            final float lllllllllllIIIIlIIlIlllIlIIIllll = lllllllllllIIIIlIIlIlllIlIIlllll + lllllllllllIIIIlIIlIlllIlIIlllII - lllllllllllIIIIlIIlIlllIlIIlIIII;
            final float lllllllllllIIIIlIIlIlllIlIIIlllI = lllllllllllIIIIlIIlIlllIlIIlllll + lllllllllllIIIIlIIlIlllIlIIlllII + lllllllllllIIIIlIIlIlllIlIIlIIII;
            Gui.drawRect(lllllllllllIIIIlIIlIlllIlIlIIIII - lllllllllllIIIIlIIlIlllIlIIlIIIl, lllllllllllIIIIlIIlIlllIlIIIllll - lllllllllllIIIIlIIlIlllIlIIlIIIl, lllllllllllIIIIlIIlIlllIlIIllllI + lllllllllllIIIIlIIlIlllIlIIlIIIl, lllllllllllIIIIlIIlIlllIlIIIlllI + lllllllllllIIIIlIIlIlllIlIIlIIIl, -16777216);
            Gui.drawRect(lllllllllllIIIIlIIlIlllIlIlIIIII, lllllllllllIIIIlIIlIlllIlIIIllll, lllllllllllIIIIlIIlIlllIlIIllllI, lllllllllllIIIIlIIlIlllIlIIIlllI, Color.HSBtoRGB(this.hue, 1.0f, 1.0f));
            final float lllllllllllIIIIlIIlIlllIlIIIllIl = (float)(lllllllllllIIIIlIIlIlllIlIllIllI + 80 + 6);
            final float lllllllllllIIIIlIIlIlllIlIIIllII = (float)(lllllllllllIIIIlIIlIlllIlIllIlIl + lllllllllllIIIIlIIlIlllIlIllIIll + 2);
            final float lllllllllllIIIIlIIlIlllIlIIIlIll = lllllllllllIIIIlIIlIlllIlIIIllIl + 5.0f;
            final float lllllllllllIIIIlIIlIlllIlIIIlIlI = (float)(lllllllllllIIIIlIIlIlllIlIllIlIl + lllllllllllIIIIlIIlIlllIlIllIIll + 80 - 2);
            if (lllllllllllIIIIlIIlIlllIlIlllIII <= lllllllllllIIIIlIIlIlllIlIIIllIl || lllllllllllIIIIlIIlIlllIlIllIlll <= lllllllllllIIIIlIIlIlllIlIIIllII || lllllllllllIIIIlIIlIlllIlIlllIII >= lllllllllllIIIIlIIlIlllIlIIIlIll || lllllllllllIIIIlIIlIlllIlIllIlll >= lllllllllllIIIIlIIlIlllIlIIIlIlI) {
                this.alphaSelectorDragging = false;
            }
            final int lllllllllllIIIIlIIlIlllIlIIIlIIl = Color.HSBtoRGB(this.hue, this.saturation, this.brightness);
            final int lllllllllllIIIIlIIlIlllIlIIIlIII = lllllllllllIIIIlIIlIlllIlIIIlIIl >> 16 & 0xFF;
            final int lllllllllllIIIIlIIlIlllIlIIIIlll = lllllllllllIIIIlIIlIlllIlIIIlIIl >> 8 & 0xFF;
            final int lllllllllllIIIIlIIlIlllIlIIIIllI = lllllllllllIIIIlIIlIlllIlIIIlIIl & 0xFF;
            float lllllllllllIIIIlIIlIlllIlIIIIlIl = this.alpha * (lllllllllllIIIIlIIlIlllIlIIIlIlI - lllllllllllIIIIlIIlIlllIlIIIllII);
            if (this.alphaSelectorDragging) {
                final float lllllllllllIIIIlIIlIlllIlIIIIlII = lllllllllllIIIIlIIlIlllIlIIIlIlI - lllllllllllIIIIlIIlIlllIlIIIllII;
                final float lllllllllllIIIIlIIlIlllIlIIIIIll = lllllllllllIIIIlIIlIlllIlIllIlll - lllllllllllIIIIlIIlIlllIlIIIllII;
                this.alpha = lllllllllllIIIIlIIlIlllIlIIIIIll / lllllllllllIIIIlIIlIlllIlIIIIlII;
                lllllllllllIIIIlIIlIlllIlIIIIlIl = lllllllllllIIIIlIIlIlllIlIIIIIll;
                this.updateColor(new Color(lllllllllllIIIIlIIlIlllIlIIIlIII, lllllllllllIIIIlIIlIlllIlIIIIlll, lllllllllllIIIIlIIlIlllIlIIIIllI, (int)(this.alpha * 255.0f)).getRGB(), true);
            }
            Gui.drawRect(lllllllllllIIIIlIIlIlllIlIIIllIl, lllllllllllIIIIlIIlIlllIlIIIllII, lllllllllllIIIIlIIlIlllIlIIIlIll, lllllllllllIIIIlIIlIlllIlIIIlIlI, -16777216);
            this.drawCheckeredBackground(lllllllllllIIIIlIIlIlllIlIIIllIl + 0.5f, lllllllllllIIIIlIIlIlllIlIIIllII + 0.5f, lllllllllllIIIIlIIlIlllIlIIIlIll - 0.5f, lllllllllllIIIIlIIlIlllIlIIIlIlI - 0.5f);
            DrawHelper.drawGradientRect(lllllllllllIIIIlIIlIlllIlIIIllIl + 0.5f, lllllllllllIIIIlIIlIlllIlIIIllII + 0.5f, lllllllllllIIIIlIIlIlllIlIIIlIll - 0.5f, lllllllllllIIIIlIIlIlllIlIIIlIlI - 0.5f, new Color(lllllllllllIIIIlIIlIlllIlIIIlIII, lllllllllllIIIIlIIlIlllIlIIIIlll, lllllllllllIIIIlIIlIlllIlIIIIllI, 0).getRGB(), new Color(lllllllllllIIIIlIIlIlllIlIIIlIII, lllllllllllIIIIlIIlIlllIlIIIIlll, lllllllllllIIIIlIIlIlllIlIIIIllI, 255).getRGB());
            final float lllllllllllIIIIlIIlIlllIlIIIIIlI = 2.0f;
            final float lllllllllllIIIIlIIlIlllIlIIIIIIl = 0.5f;
            final float lllllllllllIIIIlIIlIlllIlIIIIIII = lllllllllllIIIIlIIlIlllIlIIIIIlI / 2.0f;
            final float lllllllllllIIIIlIIlIlllIIlllllll = lllllllllllIIIIlIIlIlllIlIIIllII + lllllllllllIIIIlIIlIlllIlIIIIlIl - lllllllllllIIIIlIIlIlllIlIIIIIII;
            final float lllllllllllIIIIlIIlIlllIIllllllI = lllllllllllIIIIlIIlIlllIlIIIllII + lllllllllllIIIIlIIlIlllIlIIIIlIl + lllllllllllIIIIlIIlIlllIlIIIIIII;
            final float lllllllllllIIIIlIIlIlllIIlllllIl = lllllllllllIIIIlIIlIlllIlIIIlIll + lllllllllllIIIIlIIlIlllIlIIIIIIl;
            final float lllllllllllIIIIlIIlIlllIIlllllII = lllllllllllIIIIlIIlIlllIIlllllll - lllllllllllIIIIlIIlIlllIlIIIIIIl;
            final float lllllllllllIIIIlIIlIlllIIllllIll = lllllllllllIIIIlIIlIlllIIllllllI + lllllllllllIIIIlIIlIlllIlIIIIIIl;
            GL11.glDisable(3553);
            DrawHelper.setColor(-16777216);
            GL11.glBegin(2);
            GL11.glVertex2f(lllllllllllIIIIlIIlIlllIlIIIllIl, lllllllllllIIIIlIIlIlllIIlllllII);
            GL11.glVertex2f(lllllllllllIIIIlIIlIlllIlIIIllIl, lllllllllllIIIIlIIlIlllIIllllIll);
            GL11.glVertex2f(lllllllllllIIIIlIIlIlllIIlllllIl, lllllllllllIIIIlIIlIlllIIllllIll);
            GL11.glVertex2f(lllllllllllIIIIlIIlIlllIIlllllIl, lllllllllllIIIIlIIlIlllIIlllllII);
            GL11.glEnd();
            GL11.glEnable(3553);
        }
    }
    
    @Override
    public Setting getSetting() {
        return this.colorSetting;
    }
}
