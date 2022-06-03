// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable;

import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Mouse;
import java.util.ArrayList;

public class DraggableComponent
{
    private /* synthetic */ int x;
    private /* synthetic */ boolean dragging;
    private final /* synthetic */ int width;
    private /* synthetic */ int lastY;
    private final /* synthetic */ int height;
    private /* synthetic */ int lastX;
    public static /* synthetic */ ArrayList<DraggableModule> draggableModules;
    private /* synthetic */ int y;
    private /* synthetic */ int color;
    private /* synthetic */ boolean canRender;
    
    static {
        DraggableComponent.draggableModules = new ArrayList<DraggableModule>();
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setXPosition(final int lllllllllllIlllIIIlIIllIllIlIlll) {
        this.x = lllllllllllIlllIIIlIIllIllIlIlll;
    }
    
    public boolean isDragging() {
        return this.dragging;
    }
    
    public int getXPosition() {
        return this.x;
    }
    
    public DraggableComponent(final int lllllllllllIlllIIIlIIllIlllIlllI, final int lllllllllllIlllIIIlIIllIllllIIll, final int lllllllllllIlllIIIlIIllIllllIIlI, final int lllllllllllIlllIIIlIIllIllllIIIl, final int lllllllllllIlllIIIlIIllIlllIlIlI) {
        this.canRender = true;
        this.width = lllllllllllIlllIIIlIIllIllllIIlI;
        this.height = lllllllllllIlllIIIlIIllIllllIIIl;
        this.x = lllllllllllIlllIIIlIIllIlllIlllI;
        this.y = lllllllllllIlllIIIlIIllIllllIIll;
        this.color = lllllllllllIlllIIIlIIllIlllIlIlI;
    }
    
    public void setYPosition(final int lllllllllllIlllIIIlIIllIllIIllII) {
        this.y = lllllllllllIlllIIIlIIllIllIIllII;
    }
    
    private void draggingFix(final int lllllllllllIlllIIIlIIllIlIlIIIII, final int lllllllllllIlllIIIlIIllIlIIlllll) {
        if (this.dragging) {
            this.x = lllllllllllIlllIIIlIIllIlIlIIIII + this.lastX;
            this.y = lllllllllllIlllIIIlIIllIlIIlllll + this.lastY;
            if (!Mouse.isButtonDown(0)) {
                this.dragging = false;
            }
        }
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public boolean isCanRender() {
        return this.canRender;
    }
    
    public void setColor(final int lllllllllllIlllIIIlIIllIlIllllll) {
        this.color = lllllllllllIlllIIIlIIllIlIllllll;
    }
    
    public boolean isHovered(final int lllllllllllIlllIIIlIIllIlIlllIII, final int lllllllllllIlllIIIlIIllIlIllIlII) {
        return lllllllllllIlllIIIlIIllIlIlllIII >= this.getXPosition() && lllllllllllIlllIIIlIIllIlIlllIII <= this.getXPosition() + this.getWidth() && lllllllllllIlllIIIlIIllIlIllIlII >= this.getYPosition() - this.getHeight() / 4 && lllllllllllIlllIIIlIIllIlIllIlII <= this.getYPosition() - this.getHeight() / 4 + this.getHeight();
    }
    
    public int getYPosition() {
        return this.y;
    }
    
    public void setCanRender(final boolean lllllllllllIlllIIIlIIllIllIllllI) {
        this.canRender = lllllllllllIlllIIIlIIllIllIllllI;
    }
    
    public void draw(final int lllllllllllIlllIIIlIIllIlIlIllIl, final int lllllllllllIlllIIIlIIllIlIlIllII) {
        if (this.canRender) {
            this.draggingFix(lllllllllllIlllIIIlIIllIlIlIllIl, lllllllllllIlllIIIlIIllIlIlIllII);
            Gui.drawRect(this.getXPosition(), this.getYPosition() - this.getHeight() / 4, this.getXPosition() + this.getWidth(), this.getYPosition() + this.getHeight(), this.getColor());
            final boolean lllllllllllIlllIIIlIIllIlIlIlIll = lllllllllllIlllIIIlIIllIlIlIllIl >= this.getXPosition() && lllllllllllIlllIIIlIIllIlIlIllIl <= this.getXPosition() + this.getWidth();
            final boolean lllllllllllIlllIIIlIIllIlIlIlIlI = lllllllllllIlllIIIlIIllIlIlIllII >= this.getYPosition() - this.getHeight() / 4 && lllllllllllIlllIIIlIIllIlIlIllII <= this.getYPosition() - this.getHeight() / 4 + this.getHeight();
            if (lllllllllllIlllIIIlIIllIlIlIlIll && lllllllllllIlllIIIlIIllIlIlIlIlI) {
                if (Mouse.isButtonDown(0)) {
                    if (!this.dragging && DraggableComponent.draggableModules.size() <= 1) {
                        this.lastX = this.x - lllllllllllIlllIIIlIIllIlIlIllIl;
                        this.lastY = this.y - lllllllllllIlllIIIlIIllIlIlIllII;
                        this.dragging = true;
                    }
                }
                else {
                    DraggableComponent.draggableModules.clear();
                }
            }
        }
    }
}
