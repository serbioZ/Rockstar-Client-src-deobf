// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class GuiListButton extends GuiButton
{
    private final /* synthetic */ String localizationStr;
    private final /* synthetic */ GuiPageButtonList.GuiResponder guiResponder;
    private /* synthetic */ boolean value;
    
    private String buildDisplayString() {
        return String.valueOf(I18n.format(this.localizationStr, new Object[0])) + ": " + I18n.format(this.value ? "gui.yes" : "gui.no", new Object[0]);
    }
    
    public void setValue(final boolean lllllllllllIlIlIlIIlIlIlllIIllll) {
        this.value = lllllllllllIlIlIlIIlIlIlllIIllll;
        this.displayString = this.buildDisplayString();
        this.guiResponder.setEntryValue(this.id, lllllllllllIlIlIlIIlIlIlllIIllll);
    }
    
    @Override
    public boolean mousePressed(final Minecraft lllllllllllIlIlIlIIlIlIlllIIIlIl, final int lllllllllllIlIlIlIIlIlIlllIIlIII, final int lllllllllllIlIlIlIIlIlIlllIIIlll) {
        if (super.mousePressed(lllllllllllIlIlIlIIlIlIlllIIIlIl, lllllllllllIlIlIlIIlIlIlllIIlIII, lllllllllllIlIlIlIIlIlIlllIIIlll)) {
            this.value = !this.value;
            this.displayString = this.buildDisplayString();
            this.guiResponder.setEntryValue(this.id, this.value);
            return true;
        }
        return false;
    }
    
    public GuiListButton(final GuiPageButtonList.GuiResponder lllllllllllIlIlIlIIlIlIllllIIlII, final int lllllllllllIlIlIlIIlIlIllllIIIll, final int lllllllllllIlIlIlIIlIlIlllIllIll, final int lllllllllllIlIlIlIIlIlIllllIIIIl, final String lllllllllllIlIlIlIIlIlIllllIIIII, final boolean lllllllllllIlIlIlIIlIlIlllIllIII) {
        super(lllllllllllIlIlIlIIlIlIllllIIIll, lllllllllllIlIlIlIIlIlIlllIllIll, lllllllllllIlIlIlIIlIlIllllIIIIl, 150, 20, "");
        this.localizationStr = lllllllllllIlIlIlIIlIlIllllIIIII;
        this.value = lllllllllllIlIlIlIIlIlIlllIllIII;
        this.displayString = this.buildDisplayString();
        this.guiResponder = lllllllllllIlIlIlIIlIlIllllIIlII;
    }
}
