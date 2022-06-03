// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.util.Collection;
import java.io.IOException;
import net.minecraft.client.resources.I18n;
import com.google.common.collect.Lists;
import java.util.List;

public class GuiYesNo extends GuiScreen
{
    protected /* synthetic */ int parentButtonClickedId;
    private final /* synthetic */ String messageLine2;
    protected /* synthetic */ String confirmButtonText;
    protected /* synthetic */ String messageLine1;
    private final /* synthetic */ List<String> listLines;
    protected /* synthetic */ String cancelButtonText;
    private /* synthetic */ int ticksUntilEnable;
    protected /* synthetic */ GuiYesNoCallback parentScreen;
    
    public void setButtonDelay(final int lllllllllllIlIlIlIIllIlIIllllIlI) {
        this.ticksUntilEnable = lllllllllllIlIlIlIIllIlIIllllIlI;
        for (final GuiButton lllllllllllIlIlIlIIllIlIIlllllII : this.buttonList) {
            lllllllllllIlIlIlIIllIlIIlllllII.enabled = false;
        }
    }
    
    public GuiYesNo(final GuiYesNoCallback lllllllllllIlIlIlIIllIlIlIlIIlIl, final String lllllllllllIlIlIlIIllIlIlIlIlIll, final String lllllllllllIlIlIlIIllIlIlIlIIIll, final String lllllllllllIlIlIlIIllIlIlIlIIIlI, final String lllllllllllIlIlIlIIllIlIlIlIIIIl, final int lllllllllllIlIlIlIIllIlIlIlIIlll) {
        this.listLines = (List<String>)Lists.newArrayList();
        this.parentScreen = lllllllllllIlIlIlIIllIlIlIlIIlIl;
        this.messageLine1 = lllllllllllIlIlIlIIllIlIlIlIlIll;
        this.messageLine2 = lllllllllllIlIlIlIIllIlIlIlIIIll;
        this.confirmButtonText = lllllllllllIlIlIlIIllIlIlIlIIIlI;
        this.cancelButtonText = lllllllllllIlIlIlIIllIlIlIlIIIIl;
        this.parentButtonClickedId = lllllllllllIlIlIlIIllIlIlIlIIlll;
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIlIlIIllIlIlIIIlIII, final int lllllllllllIlIlIlIIllIlIlIIIIlll, final float lllllllllllIlIlIlIIllIlIlIIIIllI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.messageLine1, this.width / 2, 70, 16777215);
        int lllllllllllIlIlIlIIllIlIlIIIlIll = 90;
        for (final String lllllllllllIlIlIlIIllIlIlIIIlIlI : this.listLines) {
            this.drawCenteredString(this.fontRendererObj, lllllllllllIlIlIlIIllIlIlIIIlIlI, this.width / 2, lllllllllllIlIlIlIIllIlIlIIIlIll, 16777215);
            lllllllllllIlIlIlIIllIlIlIIIlIll += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(lllllllllllIlIlIlIIllIlIlIIIlIII, lllllllllllIlIlIlIIllIlIlIIIIlll, lllllllllllIlIlIlIIllIlIlIIIIllI);
    }
    
    public GuiYesNo(final GuiYesNoCallback lllllllllllIlIlIlIIllIlIlIllllIl, final String lllllllllllIlIlIlIIllIlIlIllllII, final String lllllllllllIlIlIlIIllIlIlIllIllI, final int lllllllllllIlIlIlIIllIlIlIlllIlI) {
        this.listLines = (List<String>)Lists.newArrayList();
        this.parentScreen = lllllllllllIlIlIlIIllIlIlIllllIl;
        this.messageLine1 = lllllllllllIlIlIlIIllIlIlIllllII;
        this.messageLine2 = lllllllllllIlIlIlIIllIlIlIllIllI;
        this.parentButtonClickedId = lllllllllllIlIlIlIIllIlIlIlllIlI;
        this.confirmButtonText = I18n.format("gui.yes", new Object[0]);
        this.cancelButtonText = I18n.format("gui.no", new Object[0]);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final int ticksUntilEnable = this.ticksUntilEnable - 1;
        this.ticksUntilEnable = ticksUntilEnable;
        if (ticksUntilEnable == 0) {
            for (final GuiButton lllllllllllIlIlIlIIllIlIIlllIIll : this.buttonList) {
                lllllllllllIlIlIlIIllIlIIlllIIll.enabled = true;
            }
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlIlIlIIllIlIlIIlIlll) throws IOException {
        this.parentScreen.confirmClicked(lllllllllllIlIlIlIIllIlIlIIlIlll.id == 0, this.parentButtonClickedId);
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(0, this.width / 2 - 155, this.height / 6 + 96, this.confirmButtonText));
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 - 155 + 160, this.height / 6 + 96, this.cancelButtonText));
        this.listLines.clear();
        this.listLines.addAll(this.fontRendererObj.listFormattedStringToWidth(this.messageLine2, this.width - 50));
    }
}
