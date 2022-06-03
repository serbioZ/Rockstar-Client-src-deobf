// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import org.apache.logging.log4j.LogManager;
import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.base.Splitter;
import javax.annotation.Nullable;
import net.minecraft.client.resources.I18n;
import java.io.IOException;
import org.apache.logging.log4j.Logger;

public class GuiWorldSelection extends GuiScreen
{
    private /* synthetic */ GuiButton selectButton;
    private /* synthetic */ GuiButton renameButton;
    private /* synthetic */ GuiButton copyButton;
    protected /* synthetic */ GuiScreen prevScreen;
    private /* synthetic */ GuiListWorldSelection selectionList;
    private /* synthetic */ String worldVersTooltip;
    protected /* synthetic */ String title;
    private /* synthetic */ GuiButton deleteButton;
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.selectionList.handleMouseInput();
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllIlllIIlIlIllIIlIllIIll) throws IOException {
        if (llllllllllIlllIIlIlIllIIlIllIIll.enabled) {
            final GuiListWorldSelectionEntry llllllllllIlllIIlIlIllIIlIllIlIl = this.selectionList.getSelectedWorld();
            if (llllllllllIlllIIlIlIllIIlIllIIll.id == 2) {
                if (llllllllllIlllIIlIlIllIIlIllIlIl != null) {
                    llllllllllIlllIIlIlIllIIlIllIlIl.deleteWorld();
                }
            }
            else if (llllllllllIlllIIlIlIllIIlIllIIll.id == 1) {
                if (llllllllllIlllIIlIlIllIIlIllIlIl != null) {
                    llllllllllIlllIIlIlIllIIlIllIlIl.joinWorld();
                }
            }
            else if (llllllllllIlllIIlIlIllIIlIllIIll.id == 3) {
                this.mc.displayGuiScreen(new GuiCreateWorld(this));
            }
            else if (llllllllllIlllIIlIlIllIIlIllIIll.id == 4) {
                if (llllllllllIlllIIlIlIllIIlIllIlIl != null) {
                    llllllllllIlllIIlIlIllIIlIllIlIl.editWorld();
                }
            }
            else if (llllllllllIlllIIlIlIllIIlIllIIll.id == 0) {
                this.mc.displayGuiScreen(this.prevScreen);
            }
            else if (llllllllllIlllIIlIlIllIIlIllIIll.id == 5 && llllllllllIlllIIlIlIllIIlIllIlIl != null) {
                llllllllllIlllIIlIlIllIIlIllIlIl.recreateWorld();
            }
        }
    }
    
    public void postInit() {
        this.selectButton = this.addButton(new GuiButton(1, this.width / 2 - 154, this.height - 52, 150, 20, I18n.format("selectWorld.select", new Object[0])));
        this.addButton(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, I18n.format("selectWorld.create", new Object[0])));
        this.renameButton = this.addButton(new GuiButton(4, this.width / 2 - 154, this.height - 28, 72, 20, I18n.format("selectWorld.edit", new Object[0])));
        this.deleteButton = this.addButton(new GuiButton(2, this.width / 2 - 76, this.height - 28, 72, 20, I18n.format("selectWorld.delete", new Object[0])));
        this.copyButton = this.addButton(new GuiButton(5, this.width / 2 + 4, this.height - 28, 72, 20, I18n.format("selectWorld.recreate", new Object[0])));
        this.addButton(new GuiButton(0, this.width / 2 + 82, this.height - 28, 72, 20, I18n.format("gui.cancel", new Object[0])));
        this.selectButton.enabled = false;
        this.deleteButton.enabled = false;
        this.renameButton.enabled = false;
        this.copyButton.enabled = false;
    }
    
    @Override
    protected void mouseClicked(final int llllllllllIlllIIlIlIllIIlIIlllII, final int llllllllllIlllIIlIlIllIIlIIllIll, final int llllllllllIlllIIlIlIllIIlIIllIlI) throws IOException {
        super.mouseClicked(llllllllllIlllIIlIlIllIIlIIlllII, llllllllllIlllIIlIlIllIIlIIllIll, llllllllllIlllIIlIlIllIIlIIllIlI);
        this.selectionList.mouseClicked(llllllllllIlllIIlIlIllIIlIIlllII, llllllllllIlllIIlIlIllIIlIIllIll, llllllllllIlllIIlIlIllIIlIIllIlI);
    }
    
    @Override
    protected void mouseReleased(final int llllllllllIlllIIlIlIllIIlIIlIlII, final int llllllllllIlllIIlIlIllIIlIIIllll, final int llllllllllIlllIIlIlIllIIlIIlIIlI) {
        super.mouseReleased(llllllllllIlllIIlIlIllIIlIIlIlII, llllllllllIlllIIlIlIllIIlIIIllll, llllllllllIlllIIlIlIllIIlIIlIIlI);
        this.selectionList.mouseReleased(llllllllllIlllIIlIlIllIIlIIlIlII, llllllllllIlllIIlIlIllIIlIIIllll, llllllllllIlllIIlIlIllIIlIIlIIlI);
    }
    
    public void selectWorld(@Nullable final GuiListWorldSelectionEntry llllllllllIlllIIlIlIllIIlIIIIIll) {
        final boolean llllllllllIlllIIlIlIllIIlIIIIIlI = llllllllllIlllIIlIlIllIIlIIIIIll != null;
        this.selectButton.enabled = llllllllllIlllIIlIlIllIIlIIIIIlI;
        this.deleteButton.enabled = llllllllllIlllIIlIlIllIIlIIIIIlI;
        this.renameButton.enabled = llllllllllIlllIIlIlIllIIlIIIIIlI;
        this.copyButton.enabled = llllllllllIlllIIlIlIllIIlIIIIIlI;
    }
    
    @Override
    public void drawScreen(final int llllllllllIlllIIlIlIllIIlIlIllII, final int llllllllllIlllIIlIlIllIIlIlIIlll, final float llllllllllIlllIIlIlIllIIlIlIlIlI) {
        this.worldVersTooltip = null;
        this.selectionList.drawScreen(llllllllllIlllIIlIlIllIIlIlIllII, llllllllllIlllIIlIlIllIIlIlIIlll, llllllllllIlllIIlIlIllIIlIlIlIlI);
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 20, 16777215);
        super.drawScreen(llllllllllIlllIIlIlIllIIlIlIllII, llllllllllIlllIIlIlIllIIlIlIIlll, llllllllllIlllIIlIlIllIIlIlIlIlI);
        if (this.worldVersTooltip != null) {
            this.drawHoveringText(Lists.newArrayList(Splitter.on("\n").split((CharSequence)this.worldVersTooltip)), llllllllllIlllIIlIlIllIIlIlIllII, llllllllllIlllIIlIlIllIIlIlIIlll);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void setVersionTooltip(final String llllllllllIlllIIlIlIllIIlIIIlIlI) {
        this.worldVersTooltip = llllllllllIlllIIlIlIllIIlIIIlIlI;
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("selectWorld.title", new Object[0]);
        this.selectionList = new GuiListWorldSelection(this, this.mc, this.width, this.height, 32, this.height - 64, 36);
        this.postInit();
    }
    
    public GuiWorldSelection(final GuiScreen llllllllllIlllIIlIlIllIIllIIIlII) {
        this.title = "Select world";
        this.prevScreen = llllllllllIlllIIlIlIllIIllIIIlII;
    }
}
