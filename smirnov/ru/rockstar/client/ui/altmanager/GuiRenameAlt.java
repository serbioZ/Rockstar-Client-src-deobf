// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import java.io.IOException;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiScreen;

public class GuiRenameAlt extends GuiScreen
{
    private /* synthetic */ String status;
    private /* synthetic */ PasswordField pwField;
    private final /* synthetic */ GuiAltManager manager;
    private /* synthetic */ GuiTextField nameField;
    
    @Override
    protected void mouseClicked(final int lllllllllllIlIIllIIlIIlIIlllIlll, final int lllllllllllIlIIllIIlIIlIIlllIllI, final int lllllllllllIlIIllIIlIIlIIlllIlIl) {
        try {
            super.mouseClicked(lllllllllllIlIIllIIlIIlIIlllIlll, lllllllllllIlIIllIIlIIlIIlllIllI, lllllllllllIlIIllIIlIIlIIlllIlIl);
        }
        catch (IOException lllllllllllIlIIllIIlIIlIIllllIIl) {
            lllllllllllIlIIllIIlIIlIIllllIIl.printStackTrace();
        }
        this.nameField.mouseClicked(lllllllllllIlIIllIIlIIlIIlllIlll, lllllllllllIlIIllIIlIIlIIlllIllI, lllllllllllIlIIllIIlIIlIIlllIlIl);
        this.pwField.mouseClicked(lllllllllllIlIIllIIlIIlIIlllIlll, lllllllllllIlIIllIIlIIlIIlllIllI, lllllllllllIlIIllIIlIIlIIlllIlIl);
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIIllIIlIIlIlIIlIlIl, final int lllllllllllIlIIllIIlIIlIlIIlIlII, final float lllllllllllIlIIllIIlIIlIlIIIllll) {
        new ScaledResolution(this.mc);
        DrawHelper.drawBorderedRect(0.0, 0.0, this.width, this.height, 0.5, new Color(17, 17, 17, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
        this.nameField.drawTextBox();
        this.pwField.drawTextBox();
        if (this.nameField.getText().isEmpty() && !this.nameField.isFocused()) {
            this.drawString(Minecraft.fontRendererObj, "Name", this.width / 2 - 96, 66, -7829368);
        }
        if (this.pwField.getText().isEmpty() && !this.pwField.isFocused()) {
            this.drawString(Minecraft.fontRendererObj, "Password", this.width / 2 - 96, 106, -7829368);
        }
        super.drawScreen(lllllllllllIlIIllIIlIIlIlIIlIlIl, lllllllllllIlIIllIIlIIlIlIIlIlII, lllllllllllIlIIllIIlIIlIlIIIllll);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlIIllIIlIIlIlIIIIlll, final int lllllllllllIlIIllIIlIIlIlIIIIIll) {
        this.nameField.textboxKeyTyped(lllllllllllIlIIllIIlIIlIlIIIIlll, lllllllllllIlIIllIIlIIlIlIIIIIll);
        this.pwField.textboxKeyTyped(lllllllllllIlIIllIIlIIlIlIIIIlll, lllllllllllIlIIllIIlIIlIlIIIIIll);
        if (lllllllllllIlIIllIIlIIlIlIIIIlll == '\t' && (this.nameField.isFocused() || this.pwField.isFocused())) {
            this.nameField.setFocused(!this.nameField.isFocused());
            this.pwField.setFocused(!this.pwField.isFocused());
        }
        if (lllllllllllIlIIllIIlIIlIlIIIIlll == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiAltButton(0, this.width / 2 - 100, this.height / 4 + 92 + 12, "Edit"));
        this.buttonList.add(new GuiAltButton(1, this.width / 2 - 100, this.height / 4 + 116 + 12, "Cancel"));
        this.nameField = new GuiTextField(this.eventButton, Minecraft.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.pwField = new PasswordField(Minecraft.fontRendererObj, this.width / 2 - 100, 100, 200, 20);
    }
    
    public GuiRenameAlt(final GuiAltManager lllllllllllIlIIllIIlIIlIlIlIIIIl) {
        this.status = TextFormatting.GRAY + "Waiting...";
        this.manager = lllllllllllIlIIllIIlIIlIlIlIIIIl;
    }
    
    public void actionPerformed(final GuiButton lllllllllllIlIIllIIlIIlIlIIlllIl) {
        switch (lllllllllllIlIIllIIlIIlIlIIlllIl.id) {
            case 0: {
                this.manager.selectedAlt.setMask(this.nameField.getText());
                this.manager.selectedAlt.setPassword(this.pwField.getText());
                this.status = "Edited!";
                break;
            }
            case 1: {
                this.mc.displayGuiScreen(this.manager);
                break;
            }
        }
    }
}
