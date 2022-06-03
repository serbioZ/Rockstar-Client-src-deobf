// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui.component;

import net.minecraft.client.gui.ScaledResolution;
import java.util.ArrayList;
import java.util.List;

public class Component
{
    private /* synthetic */ int height;
    private /* synthetic */ int x;
    private /* synthetic */ int width;
    protected final /* synthetic */ List<Component> components;
    public final /* synthetic */ Component parent;
    private /* synthetic */ int y;
    private final /* synthetic */ String name;
    
    protected boolean isHovered(final int lllllllllllIIIlIIIlIIllIIIIlllll, final int lllllllllllIIIlIIIlIIllIIIIllllI) {
        final int lllllllllllIIIlIIIlIIllIIIlIIIlI;
        final int lllllllllllIIIlIIIlIIllIIIlIIIIl;
        return lllllllllllIIIlIIIlIIllIIIIlllll >= (lllllllllllIIIlIIIlIIllIIIlIIIlI = this.getX()) && lllllllllllIIIlIIIlIIllIIIIllllI >= (lllllllllllIIIlIIIlIIllIIIlIIIIl = this.getY()) && lllllllllllIIIlIIIlIIllIIIIlllll < lllllllllllIIIlIIIlIIllIIIlIIIlI + this.getWidth() && lllllllllllIIIlIIIlIIllIIIIllllI < lllllllllllIIIlIIIlIIllIIIlIIIIl + this.getHeight();
    }
    
    public Component getParent() {
        return this.parent;
    }
    
    public int getY() {
        Component lllllllllllIIIlIIIlIIllIIIIlIlll = this.parent;
        int lllllllllllIIIlIIIlIIllIIIIlIllI = this.y;
        while (lllllllllllIIIlIIIlIIllIIIIlIlll != null) {
            lllllllllllIIIlIIIlIIllIIIIlIllI += lllllllllllIIIlIIIlIIllIIIIlIlll.y;
            lllllllllllIIIlIIIlIIllIIIIlIlll = lllllllllllIIIlIIIlIIllIIIIlIlll.parent;
        }
        return lllllllllllIIIlIIIlIIllIIIIlIllI;
    }
    
    public Component(final Component lllllllllllIIIlIIIlIIllIlIIIIlII, final String lllllllllllIIIlIIIlIIllIIlllllII, final int lllllllllllIIIlIIIlIIllIIllllIll, final int lllllllllllIIIlIIIlIIllIIllllIlI, final int lllllllllllIIIlIIIlIIllIIllllIIl, final int lllllllllllIIIlIIIlIIllIIlllllll) {
        this.components = new ArrayList<Component>();
        this.parent = lllllllllllIIIlIIIlIIllIlIIIIlII;
        this.name = lllllllllllIIIlIIIlIIllIIlllllII;
        this.x = lllllllllllIIIlIIIlIIllIIllllIll;
        this.y = lllllllllllIIIlIIIlIIllIIllllIlI;
        this.width = lllllllllllIIIlIIIlIIllIIllllIIl;
        this.height = lllllllllllIIIlIIIlIIllIIlllllll;
    }
    
    public List<Component> getComponents() {
        return this.components;
    }
    
    public void setX(final int lllllllllllIIIlIIIlIIllIIIlIlIll) {
        this.x = lllllllllllIIIlIIIlIIllIIIlIlIll;
    }
    
    public int getHeight() {
        return this.height - 2;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void drawComponent(final ScaledResolution lllllllllllIIIlIIIlIIllIIllIllIl, final int lllllllllllIIIlIIIlIIllIIllIIlll, final int lllllllllllIIIlIIIlIIllIIllIIllI) {
        for (final Component lllllllllllIIIlIIIlIIllIIllIlIlI : this.components) {
            lllllllllllIIIlIIIlIIllIIllIlIlI.drawComponent(lllllllllllIIIlIIIlIIllIIllIllIl, lllllllllllIIIlIIIlIIllIIllIIlll, lllllllllllIIIlIIIlIIllIIllIIllI);
        }
    }
    
    public void setY(final int lllllllllllIIIlIIIlIIllIIIIIllll) {
        this.y = lllllllllllIIIlIIIlIIllIIIIIllll;
    }
    
    public int getX() {
        Component lllllllllllIIIlIIIlIIllIIIllIlIl = this.parent;
        int lllllllllllIIIlIIIlIIllIIIllIlII = this.x;
        while (lllllllllllIIIlIIIlIIllIIIllIlIl != null) {
            lllllllllllIIIlIIIlIIllIIIllIlII += lllllllllllIIIlIIIlIIllIIIllIlIl.x;
            lllllllllllIIIlIIIlIIllIIIllIlIl = lllllllllllIIIlIIIlIIllIIIllIlIl.parent;
        }
        return lllllllllllIIIlIIIlIIllIIIllIlII;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void onKeyPress(final int lllllllllllIIIlIIIlIIllIIIllllll) {
        for (final Component lllllllllllIIIlIIIlIIllIIlIIIIIl : this.components) {
            lllllllllllIIIlIIIlIIllIIlIIIIIl.onKeyPress(lllllllllllIIIlIIIlIIllIIIllllll);
        }
    }
    
    public void setWidth(final int lllllllllllIIIlIIIlIIllIIIIIIllI) {
        this.width = lllllllllllIIIlIIIlIIllIIIIIIllI;
    }
    
    public void onMouseRelease(final int lllllllllllIIIlIIIlIIllIIlIIllIl) {
        for (final Component lllllllllllIIIlIIIlIIllIIlIIllII : this.components) {
            lllllllllllIIIlIIIlIIllIIlIIllII.onMouseRelease(lllllllllllIIIlIIIlIIllIIlIIllIl);
        }
    }
    
    public void setHeight(final int lllllllllllIIIlIIIlIIlIlllllllIl) {
        this.height = lllllllllllIIIlIIIlIIlIlllllllIl - 2;
    }
    
    public void onMouseClick(final int lllllllllllIIIlIIIlIIllIIlIlIlll, final int lllllllllllIIIlIIIlIIllIIlIllIll, final int lllllllllllIIIlIIIlIIllIIlIllIlI) {
        for (final Component lllllllllllIIIlIIIlIIllIIlIllIIl : this.components) {
            lllllllllllIIIlIIIlIIllIIlIllIIl.onMouseClick(lllllllllllIIIlIIIlIIllIIlIlIlll, lllllllllllIIIlIIIlIIllIIlIllIll, lllllllllllIIIlIIIlIIllIIlIllIlI);
        }
    }
}
