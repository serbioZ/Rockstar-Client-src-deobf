// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;

public class RealmsEditBox
{
    private final /* synthetic */ GuiTextField editBox;
    
    public void render() {
        this.editBox.drawTextBox();
    }
    
    public String getValue() {
        return this.editBox.getText();
    }
    
    public RealmsEditBox(final int llllllllllIllllIIllIlIlllllIlIII, final int llllllllllIllllIIllIlIlllllIIIIl, final int llllllllllIllllIIllIlIlllllIIIII, final int llllllllllIllllIIllIlIlllllIIlIl, final int llllllllllIllllIIllIlIllllIllllI) {
        Minecraft.getMinecraft();
        this.editBox = new GuiTextField(llllllllllIllllIIllIlIlllllIlIII, Minecraft.fontRendererObj, llllllllllIllllIIllIlIlllllIIIIl, llllllllllIllllIIllIlIlllllIIIII, llllllllllIllllIIllIlIlllllIIlIl, llllllllllIllllIIllIlIllllIllllI);
    }
    
    public void setFocus(final boolean llllllllllIllllIIllIlIllllIlIIlI) {
        this.editBox.setFocused(llllllllllIllllIIllIlIllllIlIIlI);
    }
    
    public void setValue(final String llllllllllIllllIIllIlIllllIIlllI) {
        this.editBox.setText(llllllllllIllllIIllIlIllllIIlllI);
    }
    
    public void keyPressed(final char llllllllllIllllIIllIlIllllIIIlll, final int llllllllllIllllIIllIlIllllIIIIll) {
        this.editBox.textboxKeyTyped(llllllllllIllllIIllIlIllllIIIlll, llllllllllIllllIIllIlIllllIIIIll);
    }
    
    public void setIsEditable(final boolean llllllllllIllllIIllIlIlllIlIIlIl) {
        this.editBox.setEnabled(llllllllllIllllIIllIlIlllIlIIlIl);
    }
    
    public void mouseClicked(final int llllllllllIllllIIllIlIlllIlllIlI, final int llllllllllIllllIIllIlIlllIlllIIl, final int llllllllllIllllIIllIlIlllIlllIII) {
        this.editBox.mouseClicked(llllllllllIllllIIllIlIlllIlllIlI, llllllllllIllllIIllIlIlllIlllIIl, llllllllllIllllIIllIlIlllIlllIII);
    }
    
    public void setMaxLength(final int llllllllllIllllIIllIlIlllIlIllIl) {
        this.editBox.setMaxStringLength(llllllllllIllllIIllIlIlllIlIllIl);
    }
    
    public boolean isFocused() {
        return this.editBox.isFocused();
    }
    
    public void tick() {
        this.editBox.updateCursorCounter();
    }
}
