// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.gui.GuiSlotRealmsProxy;

public class RealmsScrolledSelectionList
{
    private final /* synthetic */ GuiSlotRealmsProxy proxy;
    
    public int getItemCount() {
        return 0;
    }
    
    public RealmsScrolledSelectionList(final int llllllllllllIlllllIllllIIlIIIIII, final int llllllllllllIlllllIllllIIlIIIlIl, final int llllllllllllIlllllIllllIIIlllllI, final int llllllllllllIlllllIllllIIIllllIl, final int llllllllllllIlllllIllllIIIllllII) {
        this.proxy = new GuiSlotRealmsProxy(this, llllllllllllIlllllIllllIIlIIIIII, llllllllllllIlllllIllllIIlIIIlIl, llllllllllllIlllllIllllIIIlllllI, llllllllllllIlllllIllllIIIllllIl, llllllllllllIlllllIllllIIIllllII);
    }
    
    public int ym() {
        return this.proxy.getMouseY();
    }
    
    public void mouseEvent() {
        this.proxy.handleMouseInput();
    }
    
    public int width() {
        return this.proxy.getWidth();
    }
    
    public void renderItem(final int llllllllllllIlllllIllllIIIIIllll, final int llllllllllllIlllllIllllIIIIlIlIl, final int llllllllllllIlllllIllllIIIIIllIl, final int llllllllllllIlllllIllllIIIIlIIll, final int llllllllllllIlllllIllllIIIIIlIll, final int llllllllllllIlllllIllllIIIIlIIIl) {
        this.renderItem(llllllllllllIlllllIllllIIIIIllll, llllllllllllIlllllIllllIIIIlIlIl, llllllllllllIlllllIllllIIIIIllIl, llllllllllllIlllllIllllIIIIlIIll, Tezzelator.instance, llllllllllllIlllllIllllIIIIIlIll, llllllllllllIlllllIllllIIIIlIIIl);
    }
    
    public int getScrollbarPosition() {
        return this.proxy.getWidth() / 2 + 124;
    }
    
    public void selectItem(final int llllllllllllIlllllIllllIIIIIIlll, final boolean llllllllllllIlllllIllllIIIIIIllI, final int llllllllllllIlllllIllllIIIIIIlIl, final int llllllllllllIlllllIllllIIIIIIlII) {
    }
    
    public void render(final int llllllllllllIlllllIllllIIIllIllI, final int llllllllllllIlllllIllllIIIllIlIl, final float llllllllllllIlllllIllllIIIllIlII) {
        this.proxy.drawScreen(llllllllllllIlllllIllllIIIllIllI, llllllllllllIlllllIllllIIIllIlIl, llllllllllllIlllllIllllIIIllIlII);
    }
    
    public boolean isSelectedItem(final int llllllllllllIlllllIllllIIIIIIIlI) {
        return false;
    }
    
    public void scroll(final int llllllllllllIlllllIlllIlllllIllI) {
        this.proxy.scrollBy(llllllllllllIlllllIlllIlllllIllI);
    }
    
    protected void renderItem(final int llllllllllllIlllllIllllIIIlIIlIl, final int llllllllllllIlllllIllllIIIlIIlII, final int llllllllllllIlllllIllllIIIlIIIll, final int llllllllllllIlllllIllllIIIlIIIlI, final Tezzelator llllllllllllIlllllIllllIIIlIIIIl, final int llllllllllllIlllllIllllIIIlIIIII, final int llllllllllllIlllllIllllIIIIlllll) {
    }
    
    public int getMaxPosition() {
        return 0;
    }
    
    public void renderBackground() {
    }
    
    protected void renderList(final int llllllllllllIlllllIlllIllllIllll, final int llllllllllllIlllllIlllIllllIlllI, final int llllllllllllIlllllIlllIllllIllIl, final int llllllllllllIlllllIlllIllllIllII) {
    }
    
    public int getScroll() {
        return this.proxy.getAmountScrolled();
    }
    
    public int xm() {
        return this.proxy.getMouseX();
    }
}
