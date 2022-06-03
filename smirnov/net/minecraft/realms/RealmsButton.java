// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.GuiButtonRealmsProxy;

public class RealmsButton
{
    private final /* synthetic */ GuiButtonRealmsProxy proxy;
    
    public int getWidth() {
        return this.proxy.getButtonWidth();
    }
    
    public int getHeight() {
        return this.proxy.getHeight();
    }
    
    static {
        WIDGETS_LOCATION = new ResourceLocation("textures/gui/widgets.png");
    }
    
    public void clicked(final int llllllllllllllIIllllIlllllIlIlIl, final int llllllllllllllIIllllIlllllIlIlII) {
    }
    
    public int y() {
        return this.proxy.getPositionY();
    }
    
    public void renderBg(final int llllllllllllllIIllllIllllIlllIlI, final int llllllllllllllIIllllIllllIlllIIl) {
    }
    
    public void active(final boolean llllllllllllllIIllllIlllllllIIlI) {
        this.proxy.setEnabled(llllllllllllllIIllllIlllllllIIlI);
    }
    
    public GuiButton getProxy() {
        return this.proxy;
    }
    
    public int id() {
        return this.proxy.getId();
    }
    
    public RealmsButton(final int llllllllllllllIIlllllIIIIIIllIIl, final int llllllllllllllIIlllllIIIIIIlllIl, final int llllllllllllllIIlllllIIIIIIlIlll, final String llllllllllllllIIlllllIIIIIIllIll) {
        this.proxy = new GuiButtonRealmsProxy(this, llllllllllllllIIlllllIIIIIIllIIl, llllllllllllllIIlllllIIIIIIlllIl, llllllllllllllIIlllllIIIIIIlIlll, llllllllllllllIIlllllIIIIIIllIll);
    }
    
    public RealmsButton(final int llllllllllllllIIlllllIIIIIIIllIl, final int llllllllllllllIIlllllIIIIIIIllII, final int llllllllllllllIIlllllIIIIIIIIlII, final int llllllllllllllIIlllllIIIIIIIlIlI, final int llllllllllllllIIlllllIIIIIIIlIIl, final String llllllllllllllIIlllllIIIIIIIIIIl) {
        this.proxy = new GuiButtonRealmsProxy(this, llllllllllllllIIlllllIIIIIIIllIl, llllllllllllllIIlllllIIIIIIIllII, llllllllllllllIIlllllIIIIIIIIlII, llllllllllllllIIlllllIIIIIIIIIIl, llllllllllllllIIlllllIIIIIIIlIlI, llllllllllllllIIlllllIIIIIIIlIIl);
    }
    
    public void msg(final String llllllllllllllIIllllIllllllIllII) {
        this.proxy.setText(llllllllllllllIIllllIllllllIllII);
    }
    
    public boolean active() {
        return this.proxy.getEnabled();
    }
    
    public void render(final int llllllllllllllIIllllIlllllIllIIl, final int llllllllllllllIIllllIlllllIlllII, final float llllllllllllllIIllllIlllllIlIlll) {
        this.proxy.drawButton(Minecraft.getMinecraft(), llllllllllllllIIllllIlllllIllIIl, llllllllllllllIIllllIlllllIlllII, llllllllllllllIIllllIlllllIlIlll);
    }
    
    public void released(final int llllllllllllllIIllllIlllllIlIIlI, final int llllllllllllllIIllllIlllllIlIIIl) {
    }
    
    public void blit(final int llllllllllllllIIllllIlllllIIlIII, final int llllllllllllllIIllllIlllllIIIIII, final int llllllllllllllIIllllIlllllIIIllI, final int llllllllllllllIIllllIlllllIIIlIl, final int llllllllllllllIIllllIllllIllllIl, final int llllllllllllllIIllllIlllllIIIIll) {
        this.proxy.drawTexturedModalRect(llllllllllllllIIllllIlllllIIlIII, llllllllllllllIIllllIlllllIIIIII, llllllllllllllIIllllIlllllIIIllI, llllllllllllllIIllllIlllllIIIlIl, llllllllllllllIIllllIllllIllllIl, llllllllllllllIIllllIlllllIIIIll);
    }
    
    public int getYImage(final boolean llllllllllllllIIllllIllllIllIlIl) {
        return this.proxy.getYImage(llllllllllllllIIllllIllllIllIlIl);
    }
}
