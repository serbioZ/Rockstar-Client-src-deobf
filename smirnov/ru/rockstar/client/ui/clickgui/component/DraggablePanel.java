// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui.component;

import net.minecraft.client.gui.ScaledResolution;

public abstract class DraggablePanel extends ExpandableComponent
{
    private /* synthetic */ int prevY;
    private /* synthetic */ int prevX;
    private /* synthetic */ boolean dragging;
    
    @Override
    public void drawComponent(final ScaledResolution llIIlIlIIllIllI, final int llIIlIlIIllIIlI, final int llIIlIlIIllIIIl) {
        if (this.dragging) {
            this.setX(llIIlIlIIllIIlI - this.prevX);
            this.setY(llIIlIlIIllIIIl - this.prevY);
        }
    }
    
    @Override
    public void onPress(final int llIIlIlIIlIlIll, final int llIIlIlIIlIIllI, final int llIIlIlIIlIIlIl) {
        if (llIIlIlIIlIIlIl == 0) {
            this.dragging = true;
            this.prevX = llIIlIlIIlIlIll - this.getX();
            this.prevY = llIIlIlIIlIIllI - this.getY();
        }
    }
    
    @Override
    public void onMouseRelease(final int llIIlIlIIIlllll) {
        super.onMouseRelease(llIIlIlIIIlllll);
        this.dragging = false;
    }
    
    public DraggablePanel(final Component llIIlIlIlIIIIII, final String llIIlIlIlIIIllI, final int llIIlIlIlIIIlIl, final int llIIlIlIlIIIlII, final int llIIlIlIlIIIIll, final int llIIlIlIlIIIIlI) {
        super(llIIlIlIlIIIIII, llIIlIlIlIIIllI, llIIlIlIlIIIlIl, llIIlIlIlIIIlII, llIIlIlIlIIIIll, llIIlIlIlIIIIlI);
        this.prevX = llIIlIlIlIIIlIl;
        this.prevY = llIIlIlIlIIIlII;
    }
}
