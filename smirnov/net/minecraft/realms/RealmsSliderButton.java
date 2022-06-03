// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;

public class RealmsSliderButton extends RealmsButton
{
    public /* synthetic */ float value;
    public /* synthetic */ boolean sliding;
    private final /* synthetic */ float minValue;
    private final /* synthetic */ float maxValue;
    private /* synthetic */ int steps;
    
    public float toPct(final float lllllllllllllllllIllIlIlIIlIIIIl) {
        return MathHelper.clamp((this.clamp(lllllllllllllllllIllIlIlIIlIIIIl) - this.minValue) / (this.maxValue - this.minValue), 0.0f, 1.0f);
    }
    
    public String getMessage() {
        return "";
    }
    
    @Override
    public void clicked(final int lllllllllllllllllIllIlIIlllllIlI, final int lllllllllllllllllIllIlIIllllllII) {
        this.value = (lllllllllllllllllIllIlIIlllllIlI - (this.getProxy().xPosition + 4)) / (float)(this.getProxy().getButtonWidth() - 8);
        this.value = MathHelper.clamp(this.value, 0.0f, 1.0f);
        this.clicked(this.toValue(this.value));
        this.getProxy().displayString = this.getMessage();
        this.sliding = true;
    }
    
    protected float clampSteps(float lllllllllllllllllIllIlIlIIIIllIl) {
        if (this.steps > 0) {
            lllllllllllllllllIllIlIlIIIIllIl = (float)(this.steps * Math.round(lllllllllllllllllIllIlIlIIIIllIl / this.steps));
        }
        return lllllllllllllllllIllIlIlIIIIllIl;
    }
    
    public RealmsSliderButton(final int lllllllllllllllllIllIlIlIlIIlIll, final int lllllllllllllllllIllIlIlIlIIlIlI, final int lllllllllllllllllIllIlIlIlIIlIIl, final int lllllllllllllllllIllIlIlIlIIIIIl, final int lllllllllllllllllIllIlIlIlIIIIII, final int lllllllllllllllllIllIlIlIlIIIllI) {
        this(lllllllllllllllllIllIlIlIlIIlIll, lllllllllllllllllIllIlIlIlIIlIlI, lllllllllllllllllIllIlIlIlIIlIIl, lllllllllllllllllIllIlIlIlIIIIIl, lllllllllllllllllIllIlIlIlIIIllI, 0, 1.0f, (float)lllllllllllllllllIllIlIlIlIIIIII);
    }
    
    public float clamp(float lllllllllllllllllIllIlIlIIIlIIll) {
        lllllllllllllllllIllIlIlIIIlIIll = (char)this.clampSteps(lllllllllllllllllIllIlIlIIIlIIll);
        return MathHelper.clamp(lllllllllllllllllIllIlIlIIIlIIll, this.minValue, this.maxValue);
    }
    
    @Override
    public void released(final int lllllllllllllllllIllIlIIllllIlIl, final int lllllllllllllllllIllIlIIllllIlII) {
        this.sliding = false;
    }
    
    public RealmsSliderButton(final int lllllllllllllllllIllIlIlIIlIllII, final int lllllllllllllllllIllIlIlIIlIlIll, final int lllllllllllllllllIllIlIlIIlIlIlI, final int lllllllllllllllllIllIlIlIIlIlIIl, final int lllllllllllllllllIllIlIlIIllIIIl, final int lllllllllllllllllIllIlIlIIlIlIII, final float lllllllllllllllllIllIlIlIIlIIlll, final float lllllllllllllllllIllIlIlIIlIIllI) {
        super(lllllllllllllllllIllIlIlIIlIllII, lllllllllllllllllIllIlIlIIlIlIll, lllllllllllllllllIllIlIlIIlIlIlI, lllllllllllllllllIllIlIlIIlIlIIl, 20, "");
        this.value = 1.0f;
        this.minValue = lllllllllllllllllIllIlIlIIlIIlll;
        this.maxValue = lllllllllllllllllIllIlIlIIlIIllI;
        this.value = this.toPct((float)lllllllllllllllllIllIlIlIIlIlIII);
        this.getProxy().displayString = this.getMessage();
    }
    
    public void clicked(final float lllllllllllllllllIllIlIIlllllIII) {
    }
    
    @Override
    public int getYImage(final boolean lllllllllllllllllIllIlIlIIIIlIll) {
        return 0;
    }
    
    public float toValue(final float lllllllllllllllllIllIlIlIIIllIll) {
        return this.clamp(this.minValue + (this.maxValue - this.minValue) * MathHelper.clamp(lllllllllllllllllIllIlIlIIIllIll, 0.0f, 1.0f));
    }
    
    @Override
    public void renderBg(final int lllllllllllllllllIllIlIlIIIIIllI, final int lllllllllllllllllIllIlIlIIIIIlIl) {
        if (this.getProxy().visible) {
            if (this.sliding) {
                this.value = (lllllllllllllllllIllIlIlIIIIIllI - (this.getProxy().xPosition + 4)) / (float)(this.getProxy().getButtonWidth() - 8);
                this.value = MathHelper.clamp(this.value, 0.0f, 1.0f);
                final float lllllllllllllllllIllIlIlIIIIIlII = this.toValue(this.value);
                this.clicked(lllllllllllllllllIllIlIlIIIIIlII);
                this.value = this.toPct(lllllllllllllllllIllIlIlIIIIIlII);
                this.getProxy().displayString = this.getMessage();
            }
            Minecraft.getMinecraft().getTextureManager().bindTexture(RealmsSliderButton.WIDGETS_LOCATION);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.blit(this.getProxy().xPosition + (int)(this.value * (this.getProxy().getButtonWidth() - 8)), this.getProxy().yPosition, 0, 66, 4, 20);
            this.blit(this.getProxy().xPosition + (int)(this.value * (this.getProxy().getButtonWidth() - 8)) + 4, this.getProxy().yPosition, 196, 66, 4, 20);
        }
    }
}
