// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.realms.RealmsButton;

public class GuiButtonRealmsProxy extends GuiButton
{
    private final /* synthetic */ RealmsButton realmsButton;
    
    public void setEnabled(final boolean lllllllllllllIIIIIIIIIIllllIIIll) {
        this.enabled = lllllllllllllIIIIIIIIIIllllIIIll;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public GuiButtonRealmsProxy(final RealmsButton lllllllllllllIIIIIIIIIIlllllIIll, final int lllllllllllllIIIIIIIIIIllllllIlI, final int lllllllllllllIIIIIIIIIIlllllIIIl, final int lllllllllllllIIIIIIIIIIlllllIIII, final String lllllllllllllIIIIIIIIIIlllllIlll, final int lllllllllllllIIIIIIIIIIlllllIllI, final int lllllllllllllIIIIIIIIIIlllllIlIl) {
        super(lllllllllllllIIIIIIIIIIllllllIlI, lllllllllllllIIIIIIIIIIlllllIIIl, lllllllllllllIIIIIIIIIIlllllIIII, lllllllllllllIIIIIIIIIIlllllIllI, lllllllllllllIIIIIIIIIIlllllIlIl, lllllllllllllIIIIIIIIIIlllllIlll);
        this.realmsButton = lllllllllllllIIIIIIIIIIlllllIIll;
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIIIIIIIIIIlllIIIlII, final int lllllllllllllIIIIIIIIIIlllIIIIll) {
        this.realmsButton.released(lllllllllllllIIIIIIIIIIlllIIIlII, lllllllllllllIIIIIIIIIIlllIIIIll);
    }
    
    public int getYImage(final boolean lllllllllllllIIIIIIIIIIllIlIlIIl) {
        return super.getHoverState(lllllllllllllIIIIIIIIIIllIlIlIIl);
    }
    
    public boolean getEnabled() {
        return this.enabled;
    }
    
    public void mouseDragged(final Minecraft lllllllllllllIIIIIIIIIIllIlllIll, final int lllllllllllllIIIIIIIIIIllIllIlll, final int lllllllllllllIIIIIIIIIIllIllIllI) {
        this.realmsButton.renderBg(lllllllllllllIIIIIIIIIIllIllIlll, lllllllllllllIIIIIIIIIIllIllIllI);
    }
    
    public GuiButtonRealmsProxy(final RealmsButton lllllllllllllIIIIIIIIIlIIIIIllll, final int lllllllllllllIIIIIIIIIlIIIIIlllI, final int lllllllllllllIIIIIIIIIlIIIIIllIl, final int lllllllllllllIIIIIIIIIlIIIIIIllI, final String lllllllllllllIIIIIIIIIlIIIIIIlIl) {
        super(lllllllllllllIIIIIIIIIlIIIIIlllI, lllllllllllllIIIIIIIIIlIIIIIllIl, lllllllllllllIIIIIIIIIlIIIIIIllI, lllllllllllllIIIIIIIIIlIIIIIIlIl);
        this.realmsButton = lllllllllllllIIIIIIIIIlIIIIIllll;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getHoverState(final boolean lllllllllllllIIIIIIIIIIllIlIllIl) {
        return this.realmsButton.getYImage(lllllllllllllIIIIIIIIIIllIlIllIl);
    }
    
    @Override
    public boolean mousePressed(final Minecraft lllllllllllllIIIIIIIIIIlllIIlIll, final int lllllllllllllIIIIIIIIIIlllIIlllI, final int lllllllllllllIIIIIIIIIIlllIIlIIl) {
        if (super.mousePressed(lllllllllllllIIIIIIIIIIlllIIlIll, lllllllllllllIIIIIIIIIIlllIIlllI, lllllllllllllIIIIIIIIIIlllIIlIIl)) {
            this.realmsButton.clicked(lllllllllllllIIIIIIIIIIlllIIlllI, lllllllllllllIIIIIIIIIIlllIIlIIl);
        }
        return super.mousePressed(lllllllllllllIIIIIIIIIIlllIIlIll, lllllllllllllIIIIIIIIIIlllIIlllI, lllllllllllllIIIIIIIIIIlllIIlIIl);
    }
    
    public RealmsButton getRealmsButton() {
        return this.realmsButton;
    }
    
    public int getPositionY() {
        return this.yPosition;
    }
    
    public void setText(final String lllllllllllllIIIIIIIIIIlllIllIll) {
        super.displayString = lllllllllllllIIIIIIIIIIlllIllIll;
    }
    
    @Override
    public int getButtonWidth() {
        return super.getButtonWidth();
    }
}
