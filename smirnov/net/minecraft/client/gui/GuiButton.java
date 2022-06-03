// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.api.utils.render.ClientHelper;
import java.awt.Color;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class GuiButton extends Gui
{
    public /* synthetic */ int yPosition;
    public /* synthetic */ boolean enabled;
    public /* synthetic */ String displayString;
    protected /* synthetic */ boolean hovered;
    private /* synthetic */ int fade;
    public /* synthetic */ int xPosition;
    protected /* synthetic */ int height;
    protected /* synthetic */ int width;
    public /* synthetic */ int id;
    public static /* synthetic */ ScaledResolution sr;
    public /* synthetic */ boolean visible;
    private /* synthetic */ int fadeOutline;
    
    static {
        BUTTON_TEXTURES = new ResourceLocation("textures/gui/widgets.png");
        GuiButton.sr = new ScaledResolution(Minecraft.getMinecraft());
    }
    
    public void mouseReleased(final int lllllllllllIlllllIIlIllllIIIIlII, final int lllllllllllIlllllIIlIllllIIIIIll) {
    }
    
    protected int getHoverState(final boolean lllllllllllIlllllIIlIllllIlIIIlI) {
        int lllllllllllIlllllIIlIllllIlIIIIl = 1;
        if (!this.enabled) {
            lllllllllllIlllllIIlIllllIlIIIIl = 0;
        }
        else if (lllllllllllIlllllIIlIllllIlIIIlI) {
            lllllllllllIlllllIIlIllllIlIIIIl = 2;
        }
        return lllllllllllIlllllIIlIllllIlIIIIl;
    }
    
    public GuiButton(final int lllllllllllIlllllIIlIlllllIIIlII, final int lllllllllllIlllllIIlIllllIlllllI, final int lllllllllllIlllllIIlIlllllIIIIlI, final String lllllllllllIlllllIIlIlllllIIIIIl) {
        this(lllllllllllIlllllIIlIlllllIIIlII, lllllllllllIlllllIIlIllllIlllllI, lllllllllllIlllllIIlIlllllIIIIlI, 200, 20, lllllllllllIlllllIIlIlllllIIIIIl);
    }
    
    protected void mouseDragged(final Minecraft lllllllllllIlllllIIlIllllIIIlIII, final int lllllllllllIlllllIIlIllllIIIIlll, final int lllllllllllIlllllIIlIllllIIIIllI) {
    }
    
    public int getButtonWidth() {
        return this.width;
    }
    
    public void drawButtonForegroundLayer(final int lllllllllllIlllllIIlIlllIlllIlII, final int lllllllllllIlllllIIlIlllIlllIIll) {
    }
    
    public boolean isMouseOver() {
        return this.hovered;
    }
    
    public boolean mousePressed(final Minecraft lllllllllllIlllllIIlIlllIllllllI, final int lllllllllllIlllllIIlIlllIlllllIl, final int lllllllllllIlllllIIlIlllIlllllII) {
        return this.enabled && this.visible && lllllllllllIlllllIIlIlllIlllllIl >= this.xPosition && lllllllllllIlllllIIlIlllIlllllII >= this.yPosition && lllllllllllIlllllIIlIlllIlllllIl < this.xPosition + this.width && lllllllllllIlllllIIlIlllIlllllII < this.yPosition + this.height;
    }
    
    public void setWidth(final int lllllllllllIlllllIIlIlllIllIIllI) {
        this.width = lllllllllllIlllllIIlIlllIllIIllI;
    }
    
    public GuiButton(final int lllllllllllIlllllIIlIllllIllIIll, final int lllllllllllIlllllIIlIllllIlIlIll, final int lllllllllllIlllllIIlIllllIlIlIlI, final int lllllllllllIlllllIIlIllllIlIlIIl, final int lllllllllllIlllllIIlIllllIlIlIII, final String lllllllllllIlllllIIlIllllIlIIlll) {
        this.fade = 20;
        this.fadeOutline = 20;
        this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = lllllllllllIlllllIIlIllllIllIIll;
        this.xPosition = lllllllllllIlllllIIlIllllIlIlIll;
        this.yPosition = lllllllllllIlllllIIlIllllIlIlIlI;
        this.width = lllllllllllIlllllIIlIllllIlIlIIl;
        this.height = lllllllllllIlllllIIlIllllIlIlIII;
        this.displayString = lllllllllllIlllllIIlIllllIlIIlll;
    }
    
    public void playPressSound(final SoundHandler lllllllllllIlllllIIlIlllIllIllll) {
        lllllllllllIlllllIIlIlllIllIllll.playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
    }
    
    public void drawButton(final Minecraft lllllllllllIlllllIIlIllllIIlIllI, final int lllllllllllIlllllIIlIllllIIIlllI, final int lllllllllllIlllllIIlIllllIIlIlII, final float lllllllllllIlllllIIlIllllIIlIIll) {
        if (this.visible) {
            this.hovered = (lllllllllllIlllllIIlIllllIIIlllI >= this.xPosition && lllllllllllIlllllIIlIllllIIlIlII >= this.yPosition && lllllllllllIlllllIIlIllllIIIlllI < this.xPosition + this.width && lllllllllllIlllllIIlIllllIIlIlII < this.yPosition + this.height);
            Color lllllllllllIlllllIIlIllllIIlIIlI = new Color(215, 215, 215, 255);
            final Color lllllllllllIlllllIIlIllllIIlIIIl = new Color(0, 0, 0, 73);
            if (this.hovered) {
                if (this.fade < 100) {
                    this.fade += 7;
                }
                lllllllllllIlllllIIlIllllIIlIIlI = Color.white;
            }
            else if (this.fade > 20) {
                this.fade -= 7;
            }
            final Color lllllllllllIlllllIIlIllllIIlIIII = new Color(this.fade + 60, this.fade, this.fade);
            if (this.hovered) {
                if (this.fadeOutline < 100) {
                    this.fadeOutline += 7;
                }
            }
            else if (this.fadeOutline > 20) {
                this.fadeOutline -= 7;
            }
            DrawHelper.drawOutlineRect((float)this.xPosition, (float)this.yPosition, (float)this.width, (float)(this.height - 18), ClientHelper.getClientColor(), new Color(255, 255, 255, 10));
            DrawHelper.drawOutlineRect((float)this.xPosition, (float)this.yPosition, (float)this.width, (float)this.height, lllllllllllIlllllIIlIllllIIlIIIl, new Color(255, 255, 255, 10));
            Minecraft.fontRendererObj.drawCenteredString(this.displayString, this.xPosition + this.width / 2.0f, this.yPosition + (this.height - 7.5f) / 2.0f, lllllllllllIlllllIIlIllllIIlIIlI.getRGB());
        }
    }
}
