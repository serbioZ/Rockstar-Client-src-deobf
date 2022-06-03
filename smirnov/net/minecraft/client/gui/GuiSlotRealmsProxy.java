// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.realms.RealmsScrolledSelectionList;

public class GuiSlotRealmsProxy extends GuiSlot
{
    private final /* synthetic */ RealmsScrolledSelectionList selectionList;
    
    @Override
    protected boolean isSelected(final int lllllllllllllIllIllIlIlIlIIIIIll) {
        return this.selectionList.isSelectedItem(lllllllllllllIllIllIlIlIlIIIIIll);
    }
    
    @Override
    protected int getScrollBarX() {
        return this.selectionList.getScrollbarPosition();
    }
    
    @Override
    protected int getSize() {
        return this.selectionList.getItemCount();
    }
    
    @Override
    protected void drawBackground() {
        this.selectionList.renderBackground();
    }
    
    public int getWidth() {
        return this.width;
    }
    
    @Override
    protected int getContentHeight() {
        return this.selectionList.getMaxPosition();
    }
    
    public int getMouseY() {
        return this.mouseY;
    }
    
    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
    }
    
    @Override
    protected void func_192637_a(final int lllllllllllllIllIllIlIlIIllIllIl, final int lllllllllllllIllIllIlIlIIllIllII, final int lllllllllllllIllIllIlIlIIlllIIll, final int lllllllllllllIllIllIlIlIIllIlIlI, final int lllllllllllllIllIllIlIlIIllIlIIl, final int lllllllllllllIllIllIlIlIIllIlIII, final float lllllllllllllIllIllIlIlIIllIllll) {
        this.selectionList.renderItem(lllllllllllllIllIllIlIlIIllIllIl, lllllllllllllIllIllIlIlIIllIllII, lllllllllllllIllIllIlIlIIlllIIll, lllllllllllllIllIllIlIlIIllIlIlI, lllllllllllllIllIllIlIlIIllIlIIl, lllllllllllllIllIllIlIlIIllIlIII);
    }
    
    public GuiSlotRealmsProxy(final RealmsScrolledSelectionList lllllllllllllIllIllIlIlIlIIllllI, final int lllllllllllllIllIllIlIlIlIIlllIl, final int lllllllllllllIllIllIlIlIlIlIIIll, final int lllllllllllllIllIllIlIlIlIIllIll, final int lllllllllllllIllIllIlIlIlIlIIIIl, final int lllllllllllllIllIllIlIlIlIlIIIII) {
        super(Minecraft.getMinecraft(), lllllllllllllIllIllIlIlIlIIlllIl, lllllllllllllIllIllIlIlIlIlIIIll, lllllllllllllIllIllIlIlIlIIllIll, lllllllllllllIllIllIlIlIlIlIIIIl, lllllllllllllIllIllIlIlIlIlIIIII);
        this.selectionList = lllllllllllllIllIllIlIlIlIIllllI;
    }
    
    @Override
    protected void elementClicked(final int lllllllllllllIllIllIlIlIlIIIlIlI, final boolean lllllllllllllIllIllIlIlIlIIIlllI, final int lllllllllllllIllIllIlIlIlIIIllIl, final int lllllllllllllIllIllIlIlIlIIIllII) {
        this.selectionList.selectItem(lllllllllllllIllIllIlIlIlIIIlIlI, lllllllllllllIllIllIlIlIlIIIlllI, lllllllllllllIllIllIlIlIlIIIllIl, lllllllllllllIllIllIlIlIlIIIllII);
    }
    
    public int getMouseX() {
        return this.mouseX;
    }
}
