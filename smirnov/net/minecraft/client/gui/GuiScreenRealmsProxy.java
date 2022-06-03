// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.util.List;
import java.util.Collections;
import com.google.common.collect.Lists;
import net.minecraft.realms.RealmsButton;
import net.minecraft.item.ItemStack;
import java.io.IOException;
import net.minecraft.realms.RealmsScreen;

public class GuiScreenRealmsProxy extends GuiScreen
{
    private final /* synthetic */ RealmsScreen proxy;
    
    @Override
    public void handleKeyboardInput() throws IOException {
        this.proxy.keyboardEvent();
        super.handleKeyboardInput();
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIIIIlllllIIllIII, final int llllllllllllllllIIIIlllllIIlIlll, final float llllllllllllllllIIIIlllllIIlIllI) {
        this.proxy.render(llllllllllllllllIIIIlllllIIllIII, llllllllllllllllIIIIlllllIIlIlll, llllllllllllllllIIIIlllllIIlIllI);
    }
    
    public void drawString(final String llllllllllllllllIIIIlllllllIIIlI, final int llllllllllllllllIIIIllllllIllIll, final int llllllllllllllllIIIIllllllIllIlI, final int llllllllllllllllIIIIllllllIllIIl, final boolean llllllllllllllllIIIIllllllIllllI) {
        if (llllllllllllllllIIIIllllllIllllI) {
            super.drawString(this.fontRendererObj, llllllllllllllllIIIIlllllllIIIlI, llllllllllllllllIIIIllllllIllIll, llllllllllllllllIIIIllllllIllIlI, llllllllllllllllIIIIllllllIllIIl);
        }
        else {
            this.fontRendererObj.drawString(llllllllllllllllIIIIlllllllIIIlI, (float)llllllllllllllllIIIIllllllIllIll, (float)llllllllllllllllIIIIllllllIllIlI, llllllllllllllllIIIIllllllIllIIl);
        }
    }
    
    public void mouseClicked(final int llllllllllllllllIIIIllllIIlIIlII, final int llllllllllllllllIIIIllllIIlIIlll, final int llllllllllllllllIIIIllllIIlIIllI) throws IOException {
        this.proxy.mouseClicked(llllllllllllllllIIIIllllIIlIIlII, llllllllllllllllIIIIllllIIlIIlll, llllllllllllllllIIIIllllIIlIIllI);
        super.mouseClicked(llllllllllllllllIIIIllllIIlIIlII, llllllllllllllllIIIIllllIIlIIlll, llllllllllllllllIIIIllllIIlIIllI);
    }
    
    @Override
    public void drawTexturedModalRect(final int llllllllllllllllIIIIllllllIIlIII, final int llllllllllllllllIIIIllllllIIIlll, final int llllllllllllllllIIIIllllllIIllIl, final int llllllllllllllllIIIIllllllIIIlIl, final int llllllllllllllllIIIIllllllIIIlII, final int llllllllllllllllIIIIllllllIIlIlI) {
        this.proxy.blit(llllllllllllllllIIIIllllllIIlIII, llllllllllllllllIIIIllllllIIIlll, llllllllllllllllIIIIllllllIIllIl, llllllllllllllllIIIIllllllIIIlIl, llllllllllllllllIIIIllllllIIIlII, llllllllllllllllIIIIllllllIIlIlI);
        super.drawTexturedModalRect(llllllllllllllllIIIIllllllIIlIII, llllllllllllllllIIIIllllllIIIlll, llllllllllllllllIIIIllllllIIllIl, llllllllllllllllIIIIllllllIIIlIl, llllllllllllllllIIIIllllllIIIlII, llllllllllllllllIIIIllllllIIlIlI);
    }
    
    public void mouseClickMove(final int llllllllllllllllIIIIllllIIIIlIIl, final int llllllllllllllllIIIIllllIIIIIIll, final int llllllllllllllllIIIIllllIIIIIIlI, final long llllllllllllllllIIIIllllIIIIIllI) {
        this.proxy.mouseDragged(llllllllllllllllIIIIllllIIIIlIIl, llllllllllllllllIIIIllllIIIIIIll, llllllllllllllllIIIIllllIIIIIIlI, llllllllllllllllIIIIllllIIIIIllI);
    }
    
    public void fontDrawShadow(final String llllllllllllllllIIIIllllIlIlllll, final int llllllllllllllllIIIIllllIlIllllI, final int llllllllllllllllIIIIllllIlIlllIl, final int llllllllllllllllIIIIllllIlIlIlll) {
        this.fontRendererObj.drawStringWithShadow(llllllllllllllllIIIIllllIlIlllll, (float)llllllllllllllllIIIIllllIlIllllI, (float)llllllllllllllllIIIIllllIlIlllIl, llllllllllllllllIIIIllllIlIlIlll);
    }
    
    public void renderToolTip(final ItemStack llllllllllllllllIIIIlllllIIIllII, final int llllllllllllllllIIIIlllllIIIlIll, final int llllllllllllllllIIIIlllllIIIlIlI) {
        super.renderToolTip(llllllllllllllllIIIIlllllIIIllII, llllllllllllllllIIIIlllllIIIlIll, llllllllllllllllIIIIlllllIIIlIlI);
    }
    
    public void buttonsRemove(final RealmsButton llllllllllllllllIIIIllllIIllIIII) {
        this.buttonList.remove(llllllllllllllllIIIIllllIIllIIII.getProxy());
    }
    
    public GuiScreenRealmsProxy(final RealmsScreen llllllllllllllllIIIIllllllllllll) {
        this.proxy = llllllllllllllllIIIIllllllllllll;
        this.buttonList = Collections.synchronizedList((List<GuiButton>)Lists.newArrayList());
    }
    
    public RealmsScreen getProxy() {
        return this.proxy;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        this.proxy.mouseEvent();
        super.handleMouseInput();
    }
    
    public void buttonsAdd(final RealmsButton llllllllllllllllIIIIllllIIllllll) {
        this.buttonList.add(llllllllllllllllIIIIllllIIllllll.getProxy());
    }
    
    @Override
    public void drawHoveringText(final List<String> llllllllllllllllIIIIllllIllllIII, final int llllllllllllllllIIIIllllIlllIIll, final int llllllllllllllllIIIIllllIlllIllI) {
        super.drawHoveringText(llllllllllllllllIIIIllllIllllIII, llllllllllllllllIIIIllllIlllIIll, llllllllllllllllIIIIllllIlllIllI);
    }
    
    @Override
    public void updateScreen() {
        this.proxy.tick();
        super.updateScreen();
    }
    
    @Override
    public void drawCreativeTabHoveringText(final String llllllllllllllllIIIIlllllIIIIIII, final int llllllllllllllllIIIIlllllIIIIIll, final int llllllllllllllllIIIIlllllIIIIIlI) {
        super.drawCreativeTabHoveringText(llllllllllllllllIIIIlllllIIIIIII, llllllllllllllllIIIIlllllIIIIIll, llllllllllllllllIIIIlllllIIIIIlI);
    }
    
    @Override
    public void drawDefaultBackground() {
        super.drawDefaultBackground();
    }
    
    public List<RealmsButton> buttons() {
        final List<RealmsButton> llllllllllllllllIIIIllllIIlllIIl = (List<RealmsButton>)Lists.newArrayListWithExpectedSize(this.buttonList.size());
        for (final GuiButton llllllllllllllllIIIIllllIIlllIII : this.buttonList) {
            llllllllllllllllIIIIllllIIlllIIl.add(((GuiButtonRealmsProxy)llllllllllllllllIIIIllllIIlllIII).getRealmsButton());
        }
        return llllllllllllllllIIIIllllIIlllIIl;
    }
    
    public int getFontHeight() {
        return this.fontRendererObj.FONT_HEIGHT;
    }
    
    @Override
    public void drawWorldBackground(final int llllllllllllllllIIIIlllllIlIIIlI) {
        super.drawWorldBackground(llllllllllllllllIIIIlllllIlIIIlI);
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllllIIIIlllIllllIIII, final int llllllllllllllllIIIIlllIlllIllll) {
        this.proxy.confirmResult(llllllllllllllllIIIIlllIllllIIII, llllllllllllllllIIIIlllIlllIllll);
    }
    
    public final void actionPerformed(final GuiButton llllllllllllllllIIIIllllIlIIlIlI) throws IOException {
        this.proxy.buttonClicked(((GuiButtonRealmsProxy)llllllllllllllllIIIIllllIlIIlIlI).getRealmsButton());
    }
    
    public void buttonsClear() {
        this.buttonList.clear();
    }
    
    public void mouseReleased(final int llllllllllllllllIIIIllllIIIlIIlI, final int llllllllllllllllIIIIllllIIIlIlIl, final int llllllllllllllllIIIIllllIIIlIlII) {
        this.proxy.mouseReleased(llllllllllllllllIIIIllllIIIlIIlI, llllllllllllllllIIIIllllIIIlIlIl, llllllllllllllllIIIIllllIIIlIlII);
    }
    
    @Override
    public void onGuiClosed() {
        this.proxy.removed();
        super.onGuiClosed();
    }
    
    public void keyTyped(final char llllllllllllllllIIIIlllIllllllII, final int llllllllllllllllIIIIlllIlllllIII) throws IOException {
        this.proxy.keyPressed(llllllllllllllllIIIIlllIllllllII, llllllllllllllllIIIIlllIlllllIII);
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return super.doesGuiPauseGame();
    }
    
    public void drawCenteredString(final String llllllllllllllllIIIIllllllllIIlI, final int llllllllllllllllIIIIllllllllIIIl, final int llllllllllllllllIIIIllllllllIIII, final int llllllllllllllllIIIIlllllllIllll) {
        super.drawCenteredString(this.fontRendererObj, llllllllllllllllIIIIllllllllIIlI, llllllllllllllllIIIIllllllllIIIl, llllllllllllllllIIIIllllllllIIII, llllllllllllllllIIIIlllllllIllll);
    }
    
    @Override
    public void initGui() {
        this.proxy.init();
        super.initGui();
    }
    
    public int getStringWidth(final String llllllllllllllllIIIIllllIllIlIII) {
        return this.fontRendererObj.getStringWidth(llllllllllllllllIIIIllllIllIlIII);
    }
    
    public void drawGradientRect(final int llllllllllllllllIIIIlllllIlllIlI, final int llllllllllllllllIIIIlllllIlllIIl, final int llllllllllllllllIIIIlllllIlllIII, final int llllllllllllllllIIIIlllllIllIIII, final int llllllllllllllllIIIIlllllIlIllll, final int llllllllllllllllIIIIlllllIlIlllI) {
        super.drawGradientRect(llllllllllllllllIIIIlllllIlllIlI, llllllllllllllllIIIIlllllIlllIIl, llllllllllllllllIIIIlllllIlllIII, llllllllllllllllIIIIlllllIllIIII, llllllllllllllllIIIIlllllIlIllll, llllllllllllllllIIIIlllllIlIlllI);
    }
    
    public List<String> fontSplit(final String llllllllllllllllIIIIllllIlIIllll, final int llllllllllllllllIIIIllllIlIlIIIl) {
        return this.fontRendererObj.listFormattedStringToWidth(llllllllllllllllIIIIllllIlIIllll, llllllllllllllllIIIIllllIlIlIIIl);
    }
}
