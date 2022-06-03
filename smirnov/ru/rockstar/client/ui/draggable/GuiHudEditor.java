// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable;

import ru.rockstar.Main;
import net.minecraft.client.gui.GuiScreen;

public class GuiHudEditor extends GuiScreen
{
    @Override
    public void drawScreen(final int llllllllllllllIIIlIIlIIIlIlIIlII, final int llllllllllllllIIIlIIlIIIlIlIIIll, final float llllllllllllllIIIlIIlIIIlIlIIIlI) {
        this.drawWorldBackground(0);
        for (final DraggableModule llllllllllllllIIIlIIlIIIlIlIIIIl : Main.instance.draggableManager.getMods()) {
            llllllllllllllIIIlIIlIIIlIlIIIIl.render(llllllllllllllIIIlIIlIIIlIlIIlII, llllllllllllllIIIlIIlIIIlIlIIIll);
            if (llllllllllllllIIIlIIlIIIlIlIIIIl.drag.isDragging()) {
                DraggableComponent.draggableModules.add(llllllllllllllIIIlIIlIIIlIlIIIIl);
            }
        }
        super.drawScreen(llllllllllllllIIIlIIlIIIlIlIIlII, llllllllllllllIIIlIIlIIIlIlIIIll, llllllllllllllIIIlIIlIIIlIlIIIlI);
    }
}
