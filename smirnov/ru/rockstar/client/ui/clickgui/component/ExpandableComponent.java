// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui.component;

public abstract class ExpandableComponent extends Component
{
    private /* synthetic */ boolean expanded;
    
    public abstract boolean canExpand();
    
    public void setExpanded(final boolean llllllllllIllllllIlIIIIlllllllIl) {
        this.expanded = llllllllllIllllllIlIIIIlllllllIl;
    }
    
    public ExpandableComponent(final Component llllllllllIllllllIlIIIlIIIIlIIlI, final String llllllllllIllllllIlIIIlIIIIIlIlI, final int llllllllllIllllllIlIIIlIIIIlIIII, final int llllllllllIllllllIlIIIlIIIIIllll, final int llllllllllIllllllIlIIIlIIIIIIlll, final int llllllllllIllllllIlIIIlIIIIIIllI) {
        super(llllllllllIllllllIlIIIlIIIIlIIlI, llllllllllIllllllIlIIIlIIIIIlIlI, llllllllllIllllllIlIIIlIIIIlIIII, llllllllllIllllllIlIIIlIIIIIllll, llllllllllIllllllIlIIIlIIIIIIlll, llllllllllIllllllIlIIIlIIIIIIllI);
    }
    
    public abstract int getHeightWithExpand();
    
    @Override
    public void onMouseClick(final int llllllllllIllllllIlIIIIlllllIIll, final int llllllllllIllllllIlIIIIlllllIIlI, final int llllllllllIllllllIlIIIIlllllIIIl) {
        if (this.isHovered(llllllllllIllllllIlIIIIlllllIIll, llllllllllIllllllIlIIIIlllllIIlI)) {
            this.onPress(llllllllllIllllllIlIIIIlllllIIll, llllllllllIllllllIlIIIIlllllIIlI, llllllllllIllllllIlIIIIlllllIIIl);
            if (this.canExpand() && llllllllllIllllllIlIIIIlllllIIIl == 1) {
                this.expanded = !this.expanded;
            }
        }
        if (this.isExpanded()) {
            super.onMouseClick(llllllllllIllllllIlIIIIlllllIIll, llllllllllIllllllIlIIIIlllllIIlI, llllllllllIllllllIlIIIIlllllIIIl);
        }
    }
    
    public abstract void onPress(final int p0, final int p1, final int p2);
    
    public boolean isExpanded() {
        return this.expanded;
    }
}
