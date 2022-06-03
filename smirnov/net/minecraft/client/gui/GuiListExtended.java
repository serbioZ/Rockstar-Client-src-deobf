// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;

public abstract class GuiListExtended extends GuiSlot
{
    public GuiListExtended(final Minecraft llllllllllllIIllIIIIlIlllIllIIII, final int llllllllllllIIllIIIIlIlllIlIllll, final int llllllllllllIIllIIIIlIlllIllIlIl, final int llllllllllllIIllIIIIlIlllIllIlII, final int llllllllllllIIllIIIIlIlllIllIIll, final int llllllllllllIIllIIIIlIlllIlIlIll) {
        super(llllllllllllIIllIIIIlIlllIllIIII, llllllllllllIIllIIIIlIlllIlIllll, llllllllllllIIllIIIIlIlllIllIlIl, llllllllllllIIllIIIIlIlllIllIlII, llllllllllllIIllIIIIlIlllIllIIll, llllllllllllIIllIIIIlIlllIlIlIll);
    }
    
    public abstract IGuiListEntry getListEntry(final int p0);
    
    public boolean mouseClicked(final int llllllllllllIIllIIIIlIllIllIlIII, final int llllllllllllIIllIIIIlIllIllIIlll, final int llllllllllllIIllIIIIlIllIllIIllI) {
        if (this.isMouseYWithinSlotBounds(llllllllllllIIllIIIIlIllIllIIlll)) {
            final int llllllllllllIIllIIIIlIllIllIlllI = this.getSlotIndexFromScreenCoords(llllllllllllIIllIIIIlIllIllIlIII, llllllllllllIIllIIIIlIllIllIIlll);
            if (llllllllllllIIllIIIIlIllIllIlllI >= 0) {
                final int llllllllllllIIllIIIIlIllIllIllIl = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
                final int llllllllllllIIllIIIIlIllIllIllII = this.top + 4 - this.getAmountScrolled() + llllllllllllIIllIIIIlIllIllIlllI * this.slotHeight + this.headerPadding;
                final int llllllllllllIIllIIIIlIllIllIlIll = llllllllllllIIllIIIIlIllIllIlIII - llllllllllllIIllIIIIlIllIllIllIl;
                final int llllllllllllIIllIIIIlIllIllIlIlI = llllllllllllIIllIIIIlIllIllIIlll - llllllllllllIIllIIIIlIllIllIllII;
                if (this.getListEntry(llllllllllllIIllIIIIlIllIllIlllI).mousePressed(llllllllllllIIllIIIIlIllIllIlllI, llllllllllllIIllIIIIlIllIllIlIII, llllllllllllIIllIIIIlIllIllIIlll, llllllllllllIIllIIIIlIllIllIIllI, llllllllllllIIllIIIIlIllIllIlIll, llllllllllllIIllIIIIlIllIllIlIlI)) {
                    this.setEnabled(false);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    protected void func_192639_a(final int llllllllllllIIllIIIIlIlllIIIIlII, final int llllllllllllIIllIIIIlIlllIIIIIll, final int llllllllllllIIllIIIIlIlllIIIIIlI, final float llllllllllllIIllIIIIlIllIlllllII) {
        this.getListEntry(llllllllllllIIllIIIIlIlllIIIIlII).func_192633_a(llllllllllllIIllIIIIlIlllIIIIlII, llllllllllllIIllIIIIlIlllIIIIIll, llllllllllllIIllIIIIlIlllIIIIIlI, llllllllllllIIllIIIIlIllIlllllII);
    }
    
    @Override
    protected boolean isSelected(final int llllllllllllIIllIIIIlIlllIlIIlII) {
        return false;
    }
    
    @Override
    protected void drawBackground() {
    }
    
    public boolean mouseReleased(final int llllllllllllIIllIIIIlIllIlIIllIl, final int llllllllllllIIllIIIIlIllIlIlIlIl, final int llllllllllllIIllIIIIlIllIlIlIlII) {
        for (int llllllllllllIIllIIIIlIllIlIlIIll = 0; llllllllllllIIllIIIIlIllIlIlIIll < this.getSize(); ++llllllllllllIIllIIIIlIllIlIlIIll) {
            final int llllllllllllIIllIIIIlIllIlIlIIlI = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            final int llllllllllllIIllIIIIlIllIlIlIIIl = this.top + 4 - this.getAmountScrolled() + llllllllllllIIllIIIIlIllIlIlIIll * this.slotHeight + this.headerPadding;
            final int llllllllllllIIllIIIIlIllIlIlIIII = llllllllllllIIllIIIIlIllIlIIllIl - llllllllllllIIllIIIIlIllIlIlIIlI;
            final int llllllllllllIIllIIIIlIllIlIIllll = llllllllllllIIllIIIIlIllIlIlIlIl - llllllllllllIIllIIIIlIllIlIlIIIl;
            this.getListEntry(llllllllllllIIllIIIIlIllIlIlIIll).mouseReleased(llllllllllllIIllIIIIlIllIlIlIIll, llllllllllllIIllIIIIlIllIlIIllIl, llllllllllllIIllIIIIlIllIlIlIlIl, llllllllllllIIllIIIIlIllIlIlIlII, llllllllllllIIllIIIIlIllIlIlIIII, llllllllllllIIllIIIIlIllIlIIllll);
        }
        this.setEnabled(true);
        return false;
    }
    
    @Override
    protected void elementClicked(final int llllllllllllIIllIIIIlIlllIlIlIIl, final boolean llllllllllllIIllIIIIlIlllIlIlIII, final int llllllllllllIIllIIIIlIlllIlIIlll, final int llllllllllllIIllIIIIlIlllIlIIllI) {
    }
    
    @Override
    protected void func_192637_a(final int llllllllllllIIllIIIIlIlllIIllIIl, final int llllllllllllIIllIIIIlIlllIIllIII, final int llllllllllllIIllIIIIlIlllIIlIlll, final int llllllllllllIIllIIIIlIlllIIlIllI, final int llllllllllllIIllIIIIlIlllIIIllIl, final int llllllllllllIIllIIIIlIlllIIlIlII, final float llllllllllllIIllIIIIlIlllIIIlIll) {
        this.getListEntry(llllllllllllIIllIIIIlIlllIIllIIl).func_192634_a(llllllllllllIIllIIIIlIlllIIllIIl, llllllllllllIIllIIIIlIlllIIllIII, llllllllllllIIllIIIIlIlllIIlIlll, this.getListWidth(), llllllllllllIIllIIIIlIlllIIlIllI, llllllllllllIIllIIIIlIlllIIIllIl, llllllllllllIIllIIIIlIlllIIlIlII, this.isMouseYWithinSlotBounds(llllllllllllIIllIIIIlIlllIIlIlII) && this.getSlotIndexFromScreenCoords(llllllllllllIIllIIIIlIlllIIIllIl, llllllllllllIIllIIIIlIlllIIlIlII) == llllllllllllIIllIIIIlIlllIIllIIl, llllllllllllIIllIIIIlIlllIIIlIll);
    }
    
    public interface IGuiListEntry
    {
        void func_192634_a(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final boolean p7, final float p8);
        
        void func_192633_a(final int p0, final int p1, final int p2, final float p3);
        
        void mouseReleased(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
        
        boolean mousePressed(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
    }
}
