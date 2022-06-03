// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager;

import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiAltButton extends GuiButton
{
    private /* synthetic */ int opacity;
    
    public GuiAltButton(final int lllllllllllllIIIIIlllIIIlllIIIll, final int lllllllllllllIIIIIlllIIIlllIIIlI, final int lllllllllllllIIIIIlllIIIllIlllII, final String lllllllllllllIIIIIlllIIIllIllIll) {
        this(lllllllllllllIIIIIlllIIIlllIIIll, lllllllllllllIIIIIlllIIIlllIIIlI, lllllllllllllIIIIIlllIIIllIlllII, 200, 20, lllllllllllllIIIIIlllIIIllIllIll);
    }
    
    public GuiAltButton(final int lllllllllllllIIIIIlllIIIllIIlIll, final int lllllllllllllIIIIIlllIIIllIlIIIl, final int lllllllllllllIIIIIlllIIIllIIlIIl, final int lllllllllllllIIIIIlllIIIllIIlIII, final int lllllllllllllIIIIIlllIIIllIIlllI, final String lllllllllllllIIIIIlllIIIllIIllIl) {
        super(lllllllllllllIIIIIlllIIIllIIlIll, lllllllllllllIIIIIlllIIIllIlIIIl, lllllllllllllIIIIIlllIIIllIIlIIl, lllllllllllllIIIIIlllIIIllIIlIII, lllllllllllllIIIIIlllIIIllIIlllI, lllllllllllllIIIIIlllIIIllIIllIl);
        this.opacity = 40;
    }
    
    @Override
    public void drawButton(final Minecraft lllllllllllllIIIIIlllIIIlIllIlll, final int lllllllllllllIIIIIlllIIIlIllIllI, final int lllllllllllllIIIIIlllIIIlIllIlIl, final float lllllllllllllIIIIIlllIIIlIlllIll) {
        if (this.visible) {
            lllllllllllllIIIIIlllIIIlIllIlll.getTextureManager().bindTexture(GuiAltButton.BUTTON_TEXTURES);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.hovered = (lllllllllllllIIIIIlllIIIlIllIllI >= this.xPosition && lllllllllllllIIIIIlllIIIlIllIlIl >= this.yPosition && lllllllllllllIIIIIlllIIIlIllIllI < this.xPosition + this.width && lllllllllllllIIIIIlllIIIlIllIlIl < this.yPosition + this.height);
            if (this.hovered) {
                if (this.opacity < 40) {
                    ++this.opacity;
                }
            }
            else if (this.opacity > 22) {
                --this.opacity;
            }
            final boolean lllllllllllllIIIIIlllIIIlIlllIlI = lllllllllllllIIIIIlllIIIlIllIllI >= this.xPosition && lllllllllllllIIIIIlllIIIlIllIlIl >= this.yPosition && lllllllllllllIIIIIlllIIIlIllIllI < this.xPosition + this.width && lllllllllllllIIIIIlllIIIlIllIlIl < this.yPosition + this.height;
            final Color lllllllllllllIIIIIlllIIIlIlllIIl = new Color(0, 0, 0, 73);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            if (lllllllllllllIIIIIlllIIIlIlllIlI) {
                DrawHelper.drawNewRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(this.opacity, this.opacity, this.opacity, 150).getRGB());
                lllllllllllllIIIIIlllIIIlIllIlll.sfui18.drawCenteredString(this.displayString, (float)(this.xPosition + this.width / 2), (float)(this.yPosition + (this.height - 2) / 3), -1);
            }
            else {
                DrawHelper.drawOutlineRect((float)this.xPosition, (float)this.yPosition, (float)this.width, (float)this.height, lllllllllllllIIIIIlllIIIlIlllIIl, new Color(255, 255, 255, 10));
                lllllllllllllIIIIIlllIIIlIllIlll.sfui18.drawCenteredString(this.displayString, (float)(this.xPosition + this.width / 2), (float)(this.yPosition + (this.height - 2) / 3), -1);
            }
            this.mouseDragged(lllllllllllllIIIIIlllIIIlIllIlll, lllllllllllllIIIIIlllIIIlIllIllI, lllllllllllllIIIIIlllIIIlIllIlIl);
        }
    }
}
