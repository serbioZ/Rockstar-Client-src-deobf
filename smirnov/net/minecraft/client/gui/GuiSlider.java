// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;

public class GuiSlider extends GuiButton
{
    private final /* synthetic */ float max;
    private /* synthetic */ FormatHelper formatHelper;
    private final /* synthetic */ String name;
    public /* synthetic */ boolean isMouseDown;
    private /* synthetic */ float sliderPosition;
    private final /* synthetic */ float min;
    private final /* synthetic */ GuiPageButtonList.GuiResponder responder;
    
    @Override
    public void mouseReleased(final int lllllllllllIIIIIIIllIlIIllIllllI, final int lllllllllllIIIIIIIllIlIIllIlllIl) {
        this.isMouseDown = false;
    }
    
    public float getSliderValue() {
        return this.min + (this.max - this.min) * this.sliderPosition;
    }
    
    public void setSliderPosition(final float lllllllllllIIIIIIIllIlIIlllIllIl) {
        this.sliderPosition = lllllllllllIIIIIIIllIlIIlllIllIl;
        this.displayString = this.getDisplayString();
        this.responder.setEntryValue(this.id, this.getSliderValue());
    }
    
    public float getSliderPosition() {
        return this.sliderPosition;
    }
    
    @Override
    protected void mouseDragged(final Minecraft lllllllllllIIIIIIIllIlIIllllIlll, final int lllllllllllIIIIIIIllIlIIllllIllI, final int lllllllllllIIIIIIIllIlIIllllIlIl) {
        if (this.visible) {
            if (this.isMouseDown) {
                this.sliderPosition = (lllllllllllIIIIIIIllIlIIllllIllI - (this.xPosition + 4)) / (float)(this.width - 8);
                if (this.sliderPosition < 0.0f) {
                    this.sliderPosition = 0.0f;
                }
                if (this.sliderPosition > 1.0f) {
                    this.sliderPosition = 1.0f;
                }
                this.displayString = this.getDisplayString();
                this.responder.setEntryValue(this.id, this.getSliderValue());
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderPosition * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderPosition * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }
    
    private String getDisplayString() {
        return (this.formatHelper == null) ? (String.valueOf(I18n.format(this.name, new Object[0])) + ": " + this.getSliderValue()) : this.formatHelper.getText(this.id, I18n.format(this.name, new Object[0]), this.getSliderValue());
    }
    
    public void setSliderValue(final float lllllllllllIIIIIIIllIlIlIIIIIlII, final boolean lllllllllllIIIIIIIllIlIlIIIIIIll) {
        this.sliderPosition = (lllllllllllIIIIIIIllIlIlIIIIIlII - this.min) / (this.max - this.min);
        this.displayString = this.getDisplayString();
        if (lllllllllllIIIIIIIllIlIlIIIIIIll) {
            this.responder.setEntryValue(this.id, this.getSliderValue());
        }
    }
    
    @Override
    protected int getHoverState(final boolean lllllllllllIIIIIIIllIlIIlllllIll) {
        return 0;
    }
    
    @Override
    public boolean mousePressed(final Minecraft lllllllllllIIIIIIIllIlIIlllIIlll, final int lllllllllllIIIIIIIllIlIIlllIIIlI, final int lllllllllllIIIIIIIllIlIIlllIIlIl) {
        if (super.mousePressed(lllllllllllIIIIIIIllIlIIlllIIlll, lllllllllllIIIIIIIllIlIIlllIIIlI, lllllllllllIIIIIIIllIlIIlllIIlIl)) {
            this.sliderPosition = (lllllllllllIIIIIIIllIlIIlllIIIlI - (this.xPosition + 4)) / (float)(this.width - 8);
            if (this.sliderPosition < 0.0f) {
                this.sliderPosition = 0.0f;
            }
            if (this.sliderPosition > 1.0f) {
                this.sliderPosition = 1.0f;
            }
            this.displayString = this.getDisplayString();
            this.responder.setEntryValue(this.id, this.getSliderValue());
            this.isMouseDown = true;
            return true;
        }
        return false;
    }
    
    public GuiSlider(final GuiPageButtonList.GuiResponder lllllllllllIIIIIIIllIlIlIIlIIIIl, final int lllllllllllIIIIIIIllIlIlIIlIIIII, final int lllllllllllIIIIIIIllIlIlIIIlllll, final int lllllllllllIIIIIIIllIlIlIIIlIlII, final String lllllllllllIIIIIIIllIlIlIIIlIIll, final float lllllllllllIIIIIIIllIlIlIIIlIIlI, final float lllllllllllIIIIIIIllIlIlIIIlIIIl, final float lllllllllllIIIIIIIllIlIlIIIllIlI, final FormatHelper lllllllllllIIIIIIIllIlIlIIIllIIl) {
        super(lllllllllllIIIIIIIllIlIlIIlIIIII, lllllllllllIIIIIIIllIlIlIIIlllll, lllllllllllIIIIIIIllIlIlIIIlIlII, 150, 20, "");
        this.sliderPosition = 1.0f;
        this.name = lllllllllllIIIIIIIllIlIlIIIlIIll;
        this.min = lllllllllllIIIIIIIllIlIlIIIlIIlI;
        this.max = lllllllllllIIIIIIIllIlIlIIIlIIIl;
        this.sliderPosition = (lllllllllllIIIIIIIllIlIlIIIllIlI - lllllllllllIIIIIIIllIlIlIIIlIIlI) / (lllllllllllIIIIIIIllIlIlIIIlIIIl - lllllllllllIIIIIIIllIlIlIIIlIIlI);
        this.formatHelper = lllllllllllIIIIIIIllIlIlIIIllIIl;
        this.responder = lllllllllllIIIIIIIllIlIlIIlIIIIl;
        this.displayString = this.getDisplayString();
    }
    
    public interface FormatHelper
    {
        String getText(final int p0, final String p1, final float p2);
    }
}
