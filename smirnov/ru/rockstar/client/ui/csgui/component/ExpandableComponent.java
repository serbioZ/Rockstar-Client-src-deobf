// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui.component;

public abstract class ExpandableComponent extends Component
{
    private /* synthetic */ boolean expanded;
    
    public abstract void onPress(final int p0, final int p1, final int p2);
    
    public ExpandableComponent(final Component lllllllllllIIllIllIIIIlIIIllIIII, final String lllllllllllIIllIllIIIIlIIIllIllI, final int lllllllllllIIllIllIIIIlIIIlIlllI, final int lllllllllllIIllIllIIIIlIIIlIllIl, final int lllllllllllIIllIllIIIIlIIIllIIll, final int lllllllllllIIllIllIIIIlIIIlIlIll) {
        super(lllllllllllIIllIllIIIIlIIIllIIII, lllllllllllIIllIllIIIIlIIIllIllI, lllllllllllIIllIllIIIIlIIIlIlllI, lllllllllllIIllIllIIIIlIIIlIllIl, lllllllllllIIllIllIIIIlIIIllIIll, lllllllllllIIllIllIIIIlIIIlIlIll);
    }
    
    @Override
    public void onMouseClick(final int lllllllllllIIllIllIIIIlIIIIllIII, final int lllllllllllIIllIllIIIIlIIIIllIll, final int lllllllllllIIllIllIIIIlIIIIlIllI) {
        if (this.isHovered(lllllllllllIIllIllIIIIlIIIIllIII, lllllllllllIIllIllIIIIlIIIIllIll)) {
            this.onPress(lllllllllllIIllIllIIIIlIIIIllIII, lllllllllllIIllIllIIIIlIIIIllIll, lllllllllllIIllIllIIIIlIIIIlIllI);
            if (this.canExpand() && lllllllllllIIllIllIIIIlIIIIlIllI == 1) {
                this.expanded = !this.expanded;
            }
        }
        if (this.isExpanded()) {
            super.onMouseClick(lllllllllllIIllIllIIIIlIIIIllIII, lllllllllllIIllIllIIIIlIIIIllIll, lllllllllllIIllIllIIIIlIIIIlIllI);
        }
    }
    
    public abstract boolean canExpand();
    
    public boolean isExpanded() {
        return this.expanded;
    }
    
    public void setExpanded(final boolean lllllllllllIIllIllIIIIlIIIlIIIlI) {
        this.expanded = lllllllllllIIllIllIIIIlIIIlIIIlI;
    }
    
    public abstract int getHeightWithExpand();
}
