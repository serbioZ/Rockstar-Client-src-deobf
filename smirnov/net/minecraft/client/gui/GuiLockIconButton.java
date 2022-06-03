// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;

public class GuiLockIconButton extends GuiButton
{
    private /* synthetic */ boolean locked;
    
    public void func_191745_a(final Minecraft llllllllllIlllllIllIlllIIIIllIII, final int llllllllllIlllllIllIlllIIIIlIlll, final int llllllllllIlllllIllIlllIIIIIlIlI, final float llllllllllIlllllIllIlllIIIIlIlIl) {
        if (this.visible) {
            llllllllllIlllllIllIlllIIIIllIII.getTextureManager().bindTexture(GuiButton.BUTTON_TEXTURES);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final boolean llllllllllIlllllIllIlllIIIIlIlII = llllllllllIlllllIllIlllIIIIlIlll >= this.xPosition && llllllllllIlllllIllIlllIIIIIlIlI >= this.yPosition && llllllllllIlllllIllIlllIIIIlIlll < this.xPosition + this.width && llllllllllIlllllIllIlllIIIIIlIlI < this.yPosition + this.height;
            Icon llllllllllIlllllIllIlllIIIIIlllI = null;
            if (this.locked) {
                if (!this.enabled) {
                    final Icon llllllllllIlllllIllIlllIIIIlIIll = Icon.LOCKED_DISABLED;
                }
                else if (llllllllllIlllllIllIlllIIIIlIlII) {
                    final Icon llllllllllIlllllIllIlllIIIIlIIlI = Icon.LOCKED_HOVER;
                }
                else {
                    final Icon llllllllllIlllllIllIlllIIIIlIIIl = Icon.LOCKED;
                }
            }
            else if (!this.enabled) {
                final Icon llllllllllIlllllIllIlllIIIIlIIII = Icon.UNLOCKED_DISABLED;
            }
            else if (llllllllllIlllllIllIlllIIIIlIlII) {
                final Icon llllllllllIlllllIllIlllIIIIIllll = Icon.UNLOCKED_HOVER;
            }
            else {
                llllllllllIlllllIllIlllIIIIIlllI = Icon.UNLOCKED;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllIlllllIllIlllIIIIIlllI.getX(), llllllllllIlllllIllIlllIIIIIlllI.getY(), this.width, this.height);
        }
    }
    
    public boolean isLocked() {
        return this.locked;
    }
    
    public void setLocked(final boolean llllllllllIlllllIllIlllIIIlIIIlI) {
        this.locked = llllllllllIlllllIllIlllIIIlIIIlI;
    }
    
    public GuiLockIconButton(final int llllllllllIlllllIllIlllIIIlIllll, final int llllllllllIlllllIllIlllIIIlIlllI, final int llllllllllIlllllIllIlllIIIlIlIIl) {
        super(llllllllllIlllllIllIlllIIIlIllll, llllllllllIlllllIllIlllIIIlIlllI, llllllllllIlllllIllIlllIIIlIlIIl, 20, 20, "");
    }
    
    enum Icon
    {
        private final /* synthetic */ int x;
        private final /* synthetic */ int y;
        
        UNLOCKED("UNLOCKED", 3, 20, 146), 
        LOCKED_HOVER("LOCKED_HOVER", 1, 0, 166), 
        UNLOCKED_HOVER("UNLOCKED_HOVER", 4, 20, 166), 
        UNLOCKED_DISABLED("UNLOCKED_DISABLED", 5, 20, 186), 
        LOCKED_DISABLED("LOCKED_DISABLED", 2, 0, 186), 
        LOCKED("LOCKED", 0, 0, 146);
        
        private Icon(final String llllllllllllIlllIlllIlIIlllIlIll, final int llllllllllllIlllIlllIlIIlllIlIlI, final int llllllllllllIlllIlllIlIIlllIlIIl, final int llllllllllllIlllIlllIlIIlllIllIl) {
            this.x = llllllllllllIlllIlllIlIIlllIlIIl;
            this.y = llllllllllllIlllIlllIlIIlllIllIl;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
}
