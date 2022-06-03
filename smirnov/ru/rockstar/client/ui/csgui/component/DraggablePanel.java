// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui.component;

import net.minecraft.client.gui.ScaledResolution;

public abstract class DraggablePanel extends ExpandableComponent
{
    private /* synthetic */ int prevY;
    private /* synthetic */ int prevX;
    private /* synthetic */ boolean dragging;
    
    public DraggablePanel(final Component lllllllllllllllIllllllIllIlllllI, final String lllllllllllllllIllllllIllIllllIl, final int lllllllllllllllIllllllIllIllllII, final int lllllllllllllllIllllllIlllIIIIlI, final int lllllllllllllllIllllllIllIlllIlI, final int lllllllllllllllIllllllIlllIIIIII) {
        super(lllllllllllllllIllllllIllIlllllI, lllllllllllllllIllllllIllIllllIl, lllllllllllllllIllllllIllIllllII, lllllllllllllllIllllllIlllIIIIlI, lllllllllllllllIllllllIllIlllIlI, lllllllllllllllIllllllIlllIIIIII);
        this.prevX = lllllllllllllllIllllllIllIllllII;
        this.prevY = lllllllllllllllIllllllIlllIIIIlI;
    }
    
    @Override
    public void onMouseRelease(final int lllllllllllllllIllllllIllIIlllll) {
        super.onMouseRelease(lllllllllllllllIllllllIllIIlllll);
        this.dragging = false;
    }
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllllllIllllllIllIllIlII, final int lllllllllllllllIllllllIllIllIIII, final int lllllllllllllllIllllllIllIlIllll) {
        if (this.dragging) {
            this.setX(lllllllllllllllIllllllIllIllIIII - this.prevX);
            this.setY(lllllllllllllllIllllllIllIlIllll - this.prevY);
        }
    }
    
    @Override
    public void onPress(final int lllllllllllllllIllllllIllIlIIlIl, final int lllllllllllllllIllllllIllIlIlIII, final int lllllllllllllllIllllllIllIlIIIll) {
        if (lllllllllllllllIllllllIllIlIIIll == 0) {
            this.dragging = true;
            this.prevX = lllllllllllllllIllllllIllIlIIlIl - this.getX();
            this.prevY = lllllllllllllllIllllllIllIlIlIII - this.getY();
        }
    }
}
