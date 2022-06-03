// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.gui.GuiSimpleScrolledSelectionListProxy;

public class RealmsSimpleScrolledSelectionList
{
    private final /* synthetic */ GuiSimpleScrolledSelectionListProxy proxy;
    
    public int getScroll() {
        return this.proxy.getAmountScrolled();
    }
    
    public int getItemCount() {
        return 0;
    }
    
    public int ym() {
        return this.proxy.getMouseY();
    }
    
    protected void renderList(final int lllllllllllIlIIIllIlllllIllIIIIl, final int lllllllllllIlIIIllIlllllIllIIIII, final int lllllllllllIlIIIllIlllllIlIlllll, final int lllllllllllIlIIIllIlllllIlIllllI) {
    }
    
    public void renderItem(final int lllllllllllIlIIIllIllllllIIIlIII, final int lllllllllllIlIIIllIllllllIIIIlll, final int lllllllllllIlIIIllIlllllIlllllll, final int lllllllllllIlIIIllIllllllIIIIlIl, final int lllllllllllIlIIIllIllllllIIIIlII, final int lllllllllllIlIIIllIllllllIIIIIll) {
        this.renderItem(lllllllllllIlIIIllIllllllIIIlIII, lllllllllllIlIIIllIllllllIIIIlll, lllllllllllIlIIIllIlllllIlllllll, lllllllllllIlIIIllIllllllIIIIlIl, Tezzelator.instance, lllllllllllIlIIIllIllllllIIIIlII, lllllllllllIlIIIllIllllllIIIIIll);
    }
    
    public int xm() {
        return this.proxy.getMouseX();
    }
    
    public void renderBackground() {
    }
    
    public int getMaxPosition() {
        return 0;
    }
    
    public void selectItem(final int lllllllllllIlIIIllIlllllIllllIIl, final boolean lllllllllllIlIIIllIlllllIllllIII, final int lllllllllllIlIIIllIlllllIlllIlll, final int lllllllllllIlIIIllIlllllIlllIllI) {
    }
    
    public void render(final int lllllllllllIlIIIllIllllllIlIlIII, final int lllllllllllIlIIIllIllllllIlIIIll, final float lllllllllllIlIIIllIllllllIlIIllI) {
        this.proxy.drawScreen(lllllllllllIlIIIllIllllllIlIlIII, lllllllllllIlIIIllIllllllIlIIIll, lllllllllllIlIIIllIllllllIlIIllI);
    }
    
    public boolean isSelectedItem(final int lllllllllllIlIIIllIlllllIlllIlII) {
        return false;
    }
    
    public int getScrollbarPosition() {
        return this.proxy.getWidth() / 2 + 124;
    }
    
    protected void renderItem(final int lllllllllllIlIIIllIllllllIIlIlll, final int lllllllllllIlIIIllIllllllIIlIllI, final int lllllllllllIlIIIllIllllllIIlIlIl, final int lllllllllllIlIIIllIllllllIIlIlII, final Tezzelator lllllllllllIlIIIllIllllllIIlIIll, final int lllllllllllIlIIIllIllllllIIlIIlI, final int lllllllllllIlIIIllIllllllIIlIIIl) {
    }
    
    public void scroll(final int lllllllllllIlIIIllIlllllIllIlIII) {
        this.proxy.scrollBy(lllllllllllIlIIIllIlllllIllIlIII);
    }
    
    public RealmsSimpleScrolledSelectionList(final int lllllllllllIlIIIllIllllllIllIIlI, final int lllllllllllIlIIIllIllllllIllIIIl, final int lllllllllllIlIIIllIllllllIllIIII, final int lllllllllllIlIIIllIllllllIllIlIl, final int lllllllllllIlIIIllIllllllIllIlII) {
        this.proxy = new GuiSimpleScrolledSelectionListProxy(this, lllllllllllIlIIIllIllllllIllIIlI, lllllllllllIlIIIllIllllllIllIIIl, lllllllllllIlIIIllIllllllIllIIII, lllllllllllIlIIIllIllllllIllIlIl, lllllllllllIlIIIllIllllllIllIlII);
    }
    
    public int width() {
        return this.proxy.getWidth();
    }
    
    public void mouseEvent() {
        this.proxy.handleMouseInput();
    }
}
