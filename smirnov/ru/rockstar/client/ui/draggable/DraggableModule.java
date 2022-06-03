// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.Helper;

public class DraggableModule implements Helper
{
    protected /* synthetic */ Minecraft mc;
    public /* synthetic */ int y;
    public /* synthetic */ int x;
    public /* synthetic */ String name;
    public /* synthetic */ DraggableComponent drag;
    
    public int getY2() {
        return this.y;
    }
    
    public void setY2(final int llllllllllllIllIlIIIlllIllllIllI) {
        this.drag.setYPosition(llllllllllllIllIlIIIlllIllllIllI);
    }
    
    public int getX2() {
        return this.x;
    }
    
    public int getHeight() {
        return 50;
    }
    
    public void setName(final String llllllllllllIllIlIIIllllIIIlIIIl) {
        this.name = llllllllllllIllIlIIIllllIIIlIIIl;
    }
    
    public void render(final int llllllllllllIllIlIIIllllIIlIIIlI, final int llllllllllllIllIlIIIllllIIlIIIIl) {
        this.drag.draw(llllllllllllIllIlIIIllllIIlIIIlI, llllllllllllIllIlIIIllllIIlIIIIl);
    }
    
    public String getName() {
        return this.name;
    }
    
    public void draw() {
    }
    
    public int getWidth() {
        return 50;
    }
    
    public void setX(final int llllllllllllIllIlIIIllllIIIllIlI) {
        this.x = llllllllllllIllIlIIIllllIIIllIlI;
    }
    
    public void setX2(final int llllllllllllIllIlIIIlllIllllllIl) {
        this.drag.setXPosition(llllllllllllIllIlIIIlllIllllllIl);
    }
    
    public void setY(final int llllllllllllIllIlIIIllllIIIIIllI) {
        this.y = llllllllllllIllIlIIIllllIIIIIllI;
    }
    
    public int getX() {
        return this.drag.getXPosition();
    }
    
    public int getY() {
        return this.drag.getYPosition();
    }
    
    public DraggableModule(final String llllllllllllIllIlIIIllllIIlIllIl, final int llllllllllllIllIlIIIllllIIllIIII, final int llllllllllllIllIlIIIllllIIlIlIll) {
        this.mc = Minecraft.getMinecraft();
        this.name = llllllllllllIllIlIIIllllIIlIllIl;
        this.x = llllllllllllIllIlIIIllllIIllIIII;
        this.y = llllllllllllIllIlIIIllllIIlIlIll;
        this.drag = new DraggableComponent(this.x, this.y, this.getWidth(), this.getHeight(), new Color(255, 255, 255, 0).getRGB());
    }
}
