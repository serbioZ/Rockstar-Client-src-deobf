// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui.component;

import net.minecraft.client.gui.ScaledResolution;
import java.util.ArrayList;
import java.util.List;

public class Component
{
    private /* synthetic */ int x;
    private /* synthetic */ int width;
    private /* synthetic */ int height;
    private final /* synthetic */ String name;
    private /* synthetic */ int y;
    public final /* synthetic */ Component parent;
    protected final /* synthetic */ List<Component> components;
    
    public Component getParent() {
        return this.parent;
    }
    
    public void setWidth(final int llllllllllllllIIIlIIlIIIIIIlIIII) {
        this.width = llllllllllllllIIIlIIlIIIIIIlIIII;
    }
    
    public Component(final Component llllllllllllllIIIlIIlIIIlIIIIlll, final String llllllllllllllIIIlIIlIIIlIIIllIl, final int llllllllllllllIIIlIIlIIIlIIIIlIl, final int llllllllllllllIIIlIIlIIIlIIIlIll, final int llllllllllllllIIIlIIlIIIlIIIlIlI, final int llllllllllllllIIIlIIlIIIlIIIlIIl) {
        this.components = new ArrayList<Component>();
        this.parent = llllllllllllllIIIlIIlIIIlIIIIlll;
        this.name = llllllllllllllIIIlIIlIIIlIIIllIl;
        this.x = llllllllllllllIIIlIIlIIIlIIIIlIl;
        this.y = llllllllllllllIIIlIIlIIIlIIIlIll;
        this.width = llllllllllllllIIIlIIlIIIlIIIlIlI;
        this.height = llllllllllllllIIIlIIlIIIlIIIlIIl;
    }
    
    public void setY(final int llllllllllllllIIIlIIlIIIIIIlIlll) {
        this.y = llllllllllllllIIIlIIlIIIIIIlIlll;
    }
    
    public int getHeight() {
        return this.height - 5;
    }
    
    protected boolean isHovered(final int llllllllllllllIIIlIIlIIIIIlIlIIl, final int llllllllllllllIIIlIIlIIIIIlIlIII) {
        final int llllllllllllllIIIlIIlIIIIIlIllII;
        final int llllllllllllllIIIlIIlIIIIIlIlIll;
        return llllllllllllllIIIlIIlIIIIIlIlIIl >= (llllllllllllllIIIlIIlIIIIIlIllII = this.getX()) && llllllllllllllIIIlIIlIIIIIlIlIII >= (llllllllllllllIIIlIIlIIIIIlIlIll = this.getY()) && llllllllllllllIIIlIIlIIIIIlIlIIl < llllllllllllllIIIlIIlIIIIIlIllII + this.getWidth() && llllllllllllllIIIlIIlIIIIIlIlIII < llllllllllllllIIIlIIlIIIIIlIlIll + this.getHeight();
    }
    
    public void setX(final int llllllllllllllIIIlIIlIIIIIllIlll) {
        this.x = llllllllllllllIIIlIIlIIIIIllIlll;
    }
    
    public void setHeight(final int llllllllllllllIIIlIIlIIIIIIIIlIl) {
        this.height = llllllllllllllIIIlIIlIIIIIIIIlIl - 5;
    }
    
    public List<Component> getComponents() {
        return this.components;
    }
    
    public int getY() {
        Component llllllllllllllIIIlIIlIIIIIlIIIIl = this.parent;
        int llllllllllllllIIIlIIlIIIIIlIIIII = this.y;
        while (llllllllllllllIIIlIIlIIIIIlIIIIl != null) {
            llllllllllllllIIIlIIlIIIIIlIIIII += llllllllllllllIIIlIIlIIIIIlIIIIl.y;
            llllllllllllllIIIlIIlIIIIIlIIIIl = llllllllllllllIIIlIIlIIIIIlIIIIl.parent;
        }
        return llllllllllllllIIIlIIlIIIIIlIIIII;
    }
    
    public void onKeyPress(final int llllllllllllllIIIlIIlIIIIlIIlIIl) {
        for (final Component llllllllllllllIIIlIIlIIIIlIIlIll : this.components) {
            llllllllllllllIIIlIIlIIIIlIIlIll.onKeyPress(llllllllllllllIIIlIIlIIIIlIIlIIl);
        }
    }
    
    public void onMouseRelease(final int llllllllllllllIIIlIIlIIIIlIlIlII) {
        for (final Component llllllllllllllIIIlIIlIIIIlIlIllI : this.components) {
            llllllllllllllIIIlIIlIIIIlIlIllI.onMouseRelease(llllllllllllllIIIlIIlIIIIlIlIlII);
        }
    }
    
    public void drawComponent(final ScaledResolution llllllllllllllIIIlIIlIIIIlllIIlI, final int llllllllllllllIIIlIIlIIIIlllIllI, final int llllllllllllllIIIlIIlIIIIlllIlIl) {
        for (final Component llllllllllllllIIIlIIlIIIIlllIlII : this.components) {
            llllllllllllllIIIlIIlIIIIlllIlII.drawComponent(llllllllllllllIIIlIIlIIIIlllIIlI, llllllllllllllIIIlIIlIIIIlllIllI, llllllllllllllIIIlIIlIIIIlllIlIl);
        }
    }
    
    public int getX() {
        Component llllllllllllllIIIlIIlIIIIIllllll = this.parent;
        int llllllllllllllIIIlIIlIIIIIlllllI = this.x;
        while (llllllllllllllIIIlIIlIIIIIllllll != null) {
            llllllllllllllIIIlIIlIIIIIlllllI += llllllllllllllIIIlIIlIIIIIllllll.x;
            llllllllllllllIIIlIIlIIIIIllllll = llllllllllllllIIIlIIlIIIIIllllll.parent;
        }
        return llllllllllllllIIIlIIlIIIIIlllllI;
    }
    
    public int getWidth() {
        return this.width - 10;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void onMouseClick(final int llllllllllllllIIIlIIlIIIIllIIIIl, final int llllllllllllllIIIlIIlIIIIllIIIII, final int llllllllllllllIIIlIIlIIIIlIlllll) {
        for (final Component llllllllllllllIIIlIIlIIIIllIIIll : this.components) {
            llllllllllllllIIIlIIlIIIIllIIIll.onMouseClick(llllllllllllllIIIlIIlIIIIllIIIIl, llllllllllllllIIIlIIlIIIIllIIIII, llllllllllllllIIIlIIlIIIIlIlllll);
        }
    }
}
