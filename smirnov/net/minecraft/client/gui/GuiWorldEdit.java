// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.world.storage.WorldInfo;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;
import java.io.IOException;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.client.renderer.OpenGlHelper;
import org.apache.commons.io.FileUtils;

public class GuiWorldEdit extends GuiScreen
{
    private /* synthetic */ GuiTextField nameEdit;
    private final /* synthetic */ GuiScreen lastScreen;
    private final /* synthetic */ String worldId;
    
    @Override
    public void updateScreen() {
        this.nameEdit.updateCursorCounter();
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIlllIIIlllIlllIIIlIl) throws IOException {
        if (llllllllllllIlllIIIlllIlllIIIlIl.enabled) {
            if (llllllllllllIlllIIIlllIlllIIIlIl.id == 1) {
                this.mc.displayGuiScreen(this.lastScreen);
            }
            else if (llllllllllllIlllIIIlllIlllIIIlIl.id == 0) {
                final ISaveFormat llllllllllllIlllIIIlllIlllIIlIIl = this.mc.getSaveLoader();
                llllllllllllIlllIIIlllIlllIIlIIl.renameWorld(this.worldId, this.nameEdit.getText().trim());
                this.mc.displayGuiScreen(this.lastScreen);
            }
            else if (llllllllllllIlllIIIlllIlllIIIlIl.id == 3) {
                final ISaveFormat llllllllllllIlllIIIlllIlllIIlIII = this.mc.getSaveLoader();
                FileUtils.deleteQuietly(llllllllllllIlllIIIlllIlllIIlIII.getFile(this.worldId, "icon.png"));
                llllllllllllIlllIIIlllIlllIIIlIl.enabled = false;
            }
            else if (llllllllllllIlllIIIlllIlllIIIlIl.id == 4) {
                final ISaveFormat llllllllllllIlllIIIlllIlllIIIlll = this.mc.getSaveLoader();
                OpenGlHelper.openFile(llllllllllllIlllIIIlllIlllIIIlll.getFile(this.worldId, "icon.png").getParentFile());
            }
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void drawScreen(final int llllllllllllIlllIIIlllIllIlIlIIl, final int llllllllllllIlllIIIlllIllIlIIlII, final float llllllllllllIlllIIIlllIllIlIIlll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("selectWorld.edit.title", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterName", new Object[0]), this.width / 2 - 100, 47, 10526880);
        this.nameEdit.drawTextBox();
        super.drawScreen(llllllllllllIlllIIIlllIllIlIlIIl, llllllllllllIlllIIIlllIllIlIIlII, llllllllllllIlllIIIlllIllIlIIlll);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIlllIIIlllIllIllllII, final int llllllllllllIlllIIIlllIllIlllIll) throws IOException {
        this.nameEdit.textboxKeyTyped(llllllllllllIlllIIIlllIllIllllII, llllllllllllIlllIIIlllIllIlllIll);
        this.buttonList.get(2).enabled = !this.nameEdit.getText().trim().isEmpty();
        if (llllllllllllIlllIIIlllIllIlllIll == 28 || llllllllllllIlllIIIlllIllIlllIll == 156) {
            this.actionPerformed(this.buttonList.get(2));
        }
    }
    
    public GuiWorldEdit(final GuiScreen llllllllllllIlllIIIlllIllllIIIll, final String llllllllllllIlllIIIlllIllllIIIlI) {
        this.lastScreen = llllllllllllIlllIIIlllIllllIIIll;
        this.worldId = llllllllllllIlllIIIlllIllllIIIlI;
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        final GuiButton llllllllllllIlllIIIlllIlllIllIII = this.addButton(new GuiButton(3, this.width / 2 - 100, this.height / 4 + 24 + 12, I18n.format("selectWorld.edit.resetIcon", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 48 + 12, I18n.format("selectWorld.edit.openFolder", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, I18n.format("selectWorld.edit.save", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
        llllllllllllIlllIIIlllIlllIllIII.enabled = this.mc.getSaveLoader().getFile(this.worldId, "icon.png").isFile();
        final ISaveFormat llllllllllllIlllIIIlllIlllIlIlll = this.mc.getSaveLoader();
        final WorldInfo llllllllllllIlllIIIlllIlllIlIllI = llllllllllllIlllIIIlllIlllIlIlll.getWorldInfo(this.worldId);
        final String llllllllllllIlllIIIlllIlllIlIlIl = (llllllllllllIlllIIIlllIlllIlIllI == null) ? "" : llllllllllllIlllIIIlllIlllIlIllI.getWorldName();
        this.nameEdit = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.nameEdit.setFocused(true);
        this.nameEdit.setText(llllllllllllIlllIIIlllIlllIlIlIl);
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllIlllIIIlllIllIllIlIl, final int llllllllllllIlllIIIlllIllIllIlII, final int llllllllllllIlllIIIlllIllIlIllll) throws IOException {
        super.mouseClicked(llllllllllllIlllIIIlllIllIllIlIl, llllllllllllIlllIIIlllIllIllIlII, llllllllllllIlllIIIlllIllIlIllll);
        this.nameEdit.mouseClicked(llllllllllllIlllIIIlllIllIllIlIl, llllllllllllIlllIIIlllIllIllIlII, llllllllllllIlllIIIlllIllIlIllll);
    }
}
