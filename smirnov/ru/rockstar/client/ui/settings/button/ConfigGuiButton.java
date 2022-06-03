// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.button;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.renderer.GlStateManager;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import net.minecraft.client.gui.GuiButton;

public class ConfigGuiButton extends GuiButton
{
    private /* synthetic */ int fade;
    
    @Override
    public void mouseReleased(final int lllllllllllllIIIllllIIIlllllIIII, final int lllllllllllllIIIllllIIIllllIllll) {
    }
    
    public static int getMouseX() {
        return Mouse.getX() * ConfigGuiButton.sr.getScaledWidth() / Minecraft.getMinecraft().displayWidth;
    }
    
    @Override
    public boolean isMouseOver() {
        return this.hovered;
    }
    
    @Override
    public void drawButton(final Minecraft lllllllllllllIIIllllIIlIIIIIIIIl, final int lllllllllllllIIIllllIIIllllllIIl, final int lllllllllllllIIIllllIIIllllllIII, final float lllllllllllllIIIllllIIIllllllllI) {
        if (this.visible) {
            final int lllllllllllllIIIllllIIIlllllllIl = this.height - 31;
            this.hovered = (lllllllllllllIIIllllIIIllllllIIl >= this.xPosition + 113 && lllllllllllllIIIllllIIIllllllIII >= this.yPosition - 41 && lllllllllllllIIIllllIIIllllllIIl < this.xPosition + this.width - 63 && lllllllllllllIIIllllIIIllllllIII < lllllllllllllIIIllllIIIlllllllIl + this.yPosition - 30);
            Color lllllllllllllIIIllllIIIlllllllII = new Color(155, 155, 155, 255);
            if (this.enabled) {
                if (this.hovered) {
                    if (this.fade < 100) {
                        this.fade += 8;
                    }
                    lllllllllllllIIIllllIIIlllllllII = Color.white;
                }
                else if (this.fade > 20) {
                    this.fade -= 8;
                }
            }
            lllllllllllllIIIllllIIlIIIIIIIIl.mntsb_17.drawCenteredString(this.displayString, this.xPosition + this.width / 2.0f + 25.0f, (float)(this.yPosition + (this.height - 70)), lllllllllllllIIIllllIIIlllllllII.getRGB());
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            this.mouseDragged(lllllllllllllIIIllllIIlIIIIIIIIl, lllllllllllllIIIllllIIIllllllIIl, lllllllllllllIIIllllIIIllllllIII);
        }
    }
    
    @Override
    public int getButtonWidth() {
        return this.width;
    }
    
    @Override
    protected void mouseDragged(final Minecraft lllllllllllllIIIllllIIIlllllIlII, final int lllllllllllllIIIllllIIIlllllIIll, final int lllllllllllllIIIllllIIIlllllIIlI) {
    }
    
    @Override
    public void setWidth(final int lllllllllllllIIIllllIIIlllIlIIIl) {
        this.width = lllllllllllllIIIllllIIIlllIlIIIl;
    }
    
    public ConfigGuiButton(final int lllllllllllllIIIllllIIlIIIlIIIIl, final int lllllllllllllIIIllllIIlIIIlIIlIl, final int lllllllllllllIIIllllIIlIIIIlllll, final String lllllllllllllIIIllllIIlIIIIllllI) {
        this(lllllllllllllIIIllllIIlIIIlIIIIl, lllllllllllllIIIllllIIlIIIlIIlIl, lllllllllllllIIIllllIIlIIIIlllll, 200, 35, lllllllllllllIIIllllIIlIIIIllllI);
    }
    
    @Override
    public boolean mousePressed(final Minecraft lllllllllllllIIIllllIIIllllIlIIl, final int lllllllllllllIIIllllIIIllllIlIII, final int lllllllllllllIIIllllIIIllllIIIll) {
        final int lllllllllllllIIIllllIIIllllIIllI = this.height - 31;
        return this.enabled && this.visible && lllllllllllllIIIllllIIIllllIlIII >= this.xPosition + 113 && lllllllllllllIIIllllIIIllllIIIll >= this.yPosition - 45 && lllllllllllllIIIllllIIIllllIlIII < this.xPosition + this.width - 63 && lllllllllllllIIIllllIIIllllIIIll < lllllllllllllIIIllllIIIllllIIllI + this.yPosition - 30;
    }
    
    @Override
    public void playPressSound(final SoundHandler lllllllllllllIIIllllIIIlllIllIIl) {
        lllllllllllllIIIllllIIIlllIllIIl.playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
    }
    
    @Override
    public void drawButtonForegroundLayer(final int lllllllllllllIIIllllIIIlllIlllIl, final int lllllllllllllIIIllllIIIlllIlllII) {
    }
    
    public ConfigGuiButton(final int lllllllllllllIIIllllIIlIIIIlIlIl, final int lllllllllllllIIIllllIIlIIIIlIlII, final int lllllllllllllIIIllllIIlIIIIlIIll, final int lllllllllllllIIIllllIIlIIIIIlIll, final int lllllllllllllIIIllllIIlIIIIIlIlI, final String lllllllllllllIIIllllIIlIIIIIlIIl) {
        super(lllllllllllllIIIllllIIlIIIIlIlIl, lllllllllllllIIIllllIIlIIIIlIlII, lllllllllllllIIIllllIIlIIIIlIIll, lllllllllllllIIIllllIIlIIIIIlIll, lllllllllllllIIIllllIIlIIIIIlIlI, lllllllllllllIIIllllIIlIIIIIlIIl);
        this.fade = 20;
    }
    
    public static int getMouseY() {
        return ConfigGuiButton.sr.getScaledHeight() - Mouse.getY() * ConfigGuiButton.sr.getScaledHeight() / Minecraft.getMinecraft().displayHeight - 1;
    }
}
