// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import org.lwjgl.input.Mouse;
import net.minecraft.realms.Tezzelator;
import net.minecraft.client.Minecraft;
import net.minecraft.realms.RealmsClickableScrolledSelectionList;

public class GuiClickableScrolledSelectionListProxy extends GuiSlot
{
    private final /* synthetic */ RealmsClickableScrolledSelectionList proxy;
    
    public GuiClickableScrolledSelectionListProxy(final RealmsClickableScrolledSelectionList lIlIlIIIlIllIlI, final int lIlIlIIIlIlIIlI, final int lIlIlIIIlIlIIIl, final int lIlIlIIIlIlIIII, final int lIlIlIIIlIIllll, final int lIlIlIIIlIlIlIl) {
        super(Minecraft.getMinecraft(), lIlIlIIIlIlIIlI, lIlIlIIIlIlIIIl, lIlIlIIIlIlIIII, lIlIlIIIlIIllll, lIlIlIIIlIlIlIl);
        this.proxy = lIlIlIIIlIllIlI;
    }
    
    public void renderSelected(final int lIlIIllllllllll, final int lIlIIlllllllllI, final int lIlIIllllllllIl, final Tezzelator lIlIIllllllllII) {
        this.proxy.renderSelected(lIlIIllllllllll, lIlIIlllllllllI, lIlIIllllllllIl, lIlIIllllllllII);
    }
    
    @Override
    protected void func_192638_a(final int lIlIIlllllIIllI, final int lIlIIlllllIllll, final int lIlIIlllllIlllI, final int lIlIIlllllIIIll, final float lIlIIlllllIllII) {
        for (int lIlIIlllllIlIll = this.getSize(), lIlIIlllllIlIlI = 0; lIlIIlllllIlIlI < lIlIIlllllIlIll; ++lIlIIlllllIlIlI) {
            final int lIlIIlllllIlIIl = lIlIIlllllIllll + lIlIIlllllIlIlI * this.slotHeight + this.headerPadding;
            final int lIlIIlllllIlIII = this.slotHeight - 4;
            if (lIlIIlllllIlIIl > this.bottom || lIlIIlllllIlIIl + lIlIIlllllIlIII < this.top) {
                this.func_192639_a(lIlIIlllllIlIlI, lIlIIlllllIIllI, lIlIIlllllIlIIl, lIlIIlllllIllII);
            }
            if (this.showSelectionBox && this.isSelected(lIlIIlllllIlIlI)) {
                this.renderSelected(this.width, lIlIIlllllIlIIl, lIlIIlllllIlIII, Tezzelator.instance);
            }
            this.func_192637_a(lIlIIlllllIlIlI, lIlIIlllllIIllI, lIlIIlllllIlIIl, lIlIIlllllIlIII, lIlIIlllllIlllI, lIlIIlllllIIIll, lIlIIlllllIllII);
        }
    }
    
    @Override
    protected int getContentHeight() {
        return this.proxy.getMaxPosition();
    }
    
    @Override
    protected int getScrollBarX() {
        return this.proxy.getScrollbarPosition();
    }
    
    @Override
    protected void func_192637_a(final int lIlIlIIIIlIIIlI, final int lIlIlIIIIlIIIIl, final int lIlIlIIIIlIIIII, final int lIlIlIIIIlIIlll, final int lIlIlIIIIlIIllI, final int lIlIlIIIIlIIlIl, final float lIlIlIIIIlIIlII) {
        this.proxy.renderItem(lIlIlIIIIlIIIlI, lIlIlIIIIlIIIIl, lIlIlIIIIlIIIII, lIlIlIIIIlIIlll, lIlIlIIIIlIIllI, lIlIlIIIIlIIlIl);
    }
    
    public int mouseY() {
        return this.mouseY;
    }
    
    @Override
    protected void elementClicked(final int lIlIlIIIlIIIlII, final boolean lIlIlIIIIlllllI, final int lIlIlIIIIllllIl, final int lIlIlIIIIllllII) {
        this.proxy.selectItem(lIlIlIIIlIIIlII, lIlIlIIIIlllllI, lIlIlIIIIllllIl, lIlIlIIIIllllII);
    }
    
    @Override
    protected void drawBackground() {
        this.proxy.renderBackground();
    }
    
    @Override
    protected int getSize() {
        return this.proxy.getItemCount();
    }
    
    public int mouseX() {
        return this.mouseX;
    }
    
    public int width() {
        return this.width;
    }
    
    @Override
    protected boolean isSelected(final int lIlIlIIIIllIllI) {
        return this.proxy.isSelectedItem(lIlIlIIIIllIllI);
    }
    
    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        if (this.scrollMultiplier > 0.0f && Mouse.getEventButtonState()) {
            this.proxy.customMouseEvent(this.top, this.bottom, this.headerPadding, this.amountScrolled, this.slotHeight);
        }
    }
}
