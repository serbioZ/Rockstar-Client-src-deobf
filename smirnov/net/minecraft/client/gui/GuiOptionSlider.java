// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class GuiOptionSlider extends GuiButton
{
    private final /* synthetic */ float minValue;
    public /* synthetic */ boolean dragging;
    private final /* synthetic */ GameSettings.Options options;
    private /* synthetic */ float sliderValue;
    private final /* synthetic */ float maxValue;
    
    @Override
    public void mouseReleased(final int llllllllllllIlIllIllIIIIIIlIlIll, final int llllllllllllIlIllIllIIIIIIlIlIlI) {
        this.dragging = false;
    }
    
    @Override
    public boolean mousePressed(final Minecraft llllllllllllIlIllIllIIIIIIllIlII, final int llllllllllllIlIllIllIIIIIIllIIll, final int llllllllllllIlIllIllIIIIIIllIIlI) {
        if (super.mousePressed(llllllllllllIlIllIllIIIIIIllIlII, llllllllllllIlIllIllIIIIIIllIIll, llllllllllllIlIllIllIIIIIIllIIlI)) {
            this.sliderValue = (llllllllllllIlIllIllIIIIIIllIIll - (this.xPosition + 4)) / (float)(this.width - 8);
            this.sliderValue = MathHelper.clamp(this.sliderValue, 0.0f, 1.0f);
            llllllllllllIlIllIllIIIIIIllIlII.gameSettings.setOptionFloatValue(this.options, this.options.denormalizeValue(this.sliderValue));
            this.displayString = llllllllllllIlIllIllIIIIIIllIlII.gameSettings.getKeyBinding(this.options);
            this.dragging = true;
            return true;
        }
        return false;
    }
    
    @Override
    protected int getHoverState(final boolean llllllllllllIlIllIllIIIIIlIIIlll) {
        return 0;
    }
    
    public GuiOptionSlider(final int llllllllllllIlIllIllIIIIIllIIlII, final int llllllllllllIlIllIllIIIIIllIIIll, final int llllllllllllIlIllIllIIIIIllIIIlI, final GameSettings.Options llllllllllllIlIllIllIIIIIllIIllI) {
        this(llllllllllllIlIllIllIIIIIllIIlII, llllllllllllIlIllIllIIIIIllIIIll, llllllllllllIlIllIllIIIIIllIIIlI, llllllllllllIlIllIllIIIIIllIIllI, 0.0f, 1.0f);
    }
    
    public GuiOptionSlider(final int llllllllllllIlIllIllIIIIIlIIllll, final int llllllllllllIlIllIllIIIIIlIlIllI, final int llllllllllllIlIllIllIIIIIlIlIlIl, final GameSettings.Options llllllllllllIlIllIllIIIIIlIlIlII, final float llllllllllllIlIllIllIIIIIlIlIIll, final float llllllllllllIlIllIllIIIIIlIlIIlI) {
        super(llllllllllllIlIllIllIIIIIlIIllll, llllllllllllIlIllIllIIIIIlIlIllI, llllllllllllIlIllIllIIIIIlIlIlIl, 150, 20, "");
        this.sliderValue = 1.0f;
        this.options = llllllllllllIlIllIllIIIIIlIlIlII;
        this.minValue = llllllllllllIlIllIllIIIIIlIlIIll;
        this.maxValue = llllllllllllIlIllIllIIIIIlIlIIlI;
        final Minecraft llllllllllllIlIllIllIIIIIlIlIIIl = Minecraft.getMinecraft();
        this.sliderValue = llllllllllllIlIllIllIIIIIlIlIlII.normalizeValue(llllllllllllIlIllIllIIIIIlIlIIIl.gameSettings.getOptionFloatValue(llllllllllllIlIllIllIIIIIlIlIlII));
        this.displayString = llllllllllllIlIllIllIIIIIlIlIIIl.gameSettings.getKeyBinding(llllllllllllIlIllIllIIIIIlIlIlII);
    }
    
    @Override
    protected void mouseDragged(final Minecraft llllllllllllIlIllIllIIIIIlIIIIIl, final int llllllllllllIlIllIllIIIIIlIIIIII, final int llllllllllllIlIllIllIIIIIIllllll) {
        if (this.visible) {
            if (this.dragging) {
                this.sliderValue = (llllllllllllIlIllIllIIIIIlIIIIII - (this.xPosition + 4)) / (float)(this.width - 8);
                this.sliderValue = MathHelper.clamp(this.sliderValue, 0.0f, 1.0f);
                final float llllllllllllIlIllIllIIIIIIlllllI = this.options.denormalizeValue(this.sliderValue);
                llllllllllllIlIllIllIIIIIlIIIIIl.gameSettings.setOptionFloatValue(this.options, llllllllllllIlIllIllIIIIIIlllllI);
                this.sliderValue = this.options.normalizeValue(llllllllllllIlIllIllIIIIIIlllllI);
                this.displayString = llllllllllllIlIllIllIIIIIlIIIIIl.gameSettings.getKeyBinding(this.options);
            }
            llllllllllllIlIllIllIIIIIlIIIIIl.getTextureManager().bindTexture(GuiOptionSlider.BUTTON_TEXTURES);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }
}
