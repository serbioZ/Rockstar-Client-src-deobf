// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.gui.GuiClickableScrolledSelectionListProxy;

public class RealmsClickableScrolledSelectionList
{
    private final /* synthetic */ GuiClickableScrolledSelectionListProxy proxy;
    
    public RealmsClickableScrolledSelectionList(final int lllllllllllIlllllllllIIIIIllllll, final int lllllllllllIlllllllllIIIIIlllIII, final int lllllllllllIlllllllllIIIIIllllIl, final int lllllllllllIlllllllllIIIIIllllII, final int lllllllllllIlllllllllIIIIIlllIll) {
        this.proxy = new GuiClickableScrolledSelectionListProxy(this, lllllllllllIlllllllllIIIIIllllll, lllllllllllIlllllllllIIIIIlllIII, lllllllllllIlllllllllIIIIIllllIl, lllllllllllIlllllllllIIIIIllllII, lllllllllllIlllllllllIIIIIlllIll);
    }
    
    public void scroll(final int lllllllllllIllllllllIllllllIIlll) {
        this.proxy.scrollBy(lllllllllllIllllllllIllllllIIlll);
    }
    
    public int getMaxPosition() {
        return 0;
    }
    
    public void setLeftPos(final int lllllllllllIllllllllIlllllIIlllI) {
        this.proxy.setSlotXBoundsFromLeft(lllllllllllIllllllllIlllllIIlllI);
    }
    
    public void renderItem(final int lllllllllllIlllllllllIIIIIIIlIII, final int lllllllllllIlllllllllIIIIIIIIlll, final int lllllllllllIlllllllllIIIIIIIIllI, final int lllllllllllIlllllllllIIIIIIIllII, final int lllllllllllIlllllllllIIIIIIIIlII, final int lllllllllllIlllllllllIIIIIIIlIlI) {
        this.renderItem(lllllllllllIlllllllllIIIIIIIlIII, lllllllllllIlllllllllIIIIIIIIlll, lllllllllllIlllllllllIIIIIIIIllI, lllllllllllIlllllllllIIIIIIIllII, Tezzelator.instance, lllllllllllIlllllllllIIIIIIIIlII, lllllllllllIlllllllllIIIIIIIlIlI);
    }
    
    public void selectItem(final int lllllllllllIlllllllllIIIIIIIIIII, final boolean lllllllllllIllllllllIlllllllllll, final int lllllllllllIllllllllIllllllllllI, final int lllllllllllIllllllllIlllllllllIl) {
    }
    
    public boolean isSelectedItem(final int lllllllllllIllllllllIllllllllIll) {
        return false;
    }
    
    public void mouseEvent() {
        this.proxy.handleMouseInput();
    }
    
    public int xm() {
        return this.proxy.mouseX();
    }
    
    public void itemClicked(final int lllllllllllIllllllllIlllllIlllIl, final int lllllllllllIllllllllIlllllIlllII, final int lllllllllllIllllllllIlllllIllIll, final int lllllllllllIllllllllIlllllIllIlI, final int lllllllllllIllllllllIlllllIllIIl) {
    }
    
    public int ym() {
        return this.proxy.mouseY();
    }
    
    public void customMouseEvent(final int lllllllllllIllllllllIlllllllIIIl, final int lllllllllllIllllllllIlllllllIIII, final int lllllllllllIllllllllIllllllIllll, final float lllllllllllIllllllllIllllllIlllI, final int lllllllllllIllllllllIllllllIllIl) {
    }
    
    public int getScrollbarPosition() {
        return this.proxy.width() / 2 + 124;
    }
    
    public void renderSelected(final int lllllllllllIllllllllIlllllIlIlll, final int lllllllllllIllllllllIlllllIlIllI, final int lllllllllllIllllllllIlllllIlIlIl, final Tezzelator lllllllllllIllllllllIlllllIlIlII) {
    }
    
    protected void renderItem(final int lllllllllllIlllllllllIIIIIIllllI, final int lllllllllllIlllllllllIIIIIIlllIl, final int lllllllllllIlllllllllIIIIIIlllII, final int lllllllllllIlllllllllIIIIIIllIll, final Tezzelator lllllllllllIlllllllllIIIIIIllIlI, final int lllllllllllIlllllllllIIIIIIllIIl, final int lllllllllllIlllllllllIIIIIIllIII) {
    }
    
    protected void renderList(final int lllllllllllIllllllllIllllllIIIlI, final int lllllllllllIllllllllIllllllIIIIl, final int lllllllllllIllllllllIllllllIIIII, final int lllllllllllIllllllllIlllllIlllll) {
    }
    
    public void render(final int lllllllllllIlllllllllIIIIIlIlIll, final int lllllllllllIlllllllllIIIIIlIlIlI, final float lllllllllllIlllllllllIIIIIlIllIl) {
        this.proxy.drawScreen(lllllllllllIlllllllllIIIIIlIlIll, lllllllllllIlllllllllIIIIIlIlIlI, lllllllllllIlllllllllIIIIIlIllIl);
    }
    
    public int getScroll() {
        return this.proxy.getAmountScrolled();
    }
    
    public int getItemCount() {
        return 0;
    }
    
    public void renderBackground() {
    }
    
    public int width() {
        return this.proxy.width();
    }
}
