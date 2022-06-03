// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager;

import java.awt.datatransfer.DataFlavor;
import java.awt.Toolkit;
import ru.rockstar.client.ui.altmanager.alt.Alt;
import net.minecraft.client.gui.GuiButton;
import java.io.IOException;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.ui.altmanager.alt.AltLoginThread;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiScreen;

public final class GuiAltLogin extends GuiScreen
{
    private final /* synthetic */ GuiScreen previousScreen;
    private /* synthetic */ GuiTextField username;
    private /* synthetic */ AltLoginThread thread;
    private /* synthetic */ PasswordField password;
    
    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
        this.password.updateCursorCounter();
    }
    
    @Override
    public void drawScreen(final int llllllllllllIlIllIIlllllIIIIlIII, final int llllllllllllIlIllIIlllllIIIIIIll, final float llllllllllllIlIllIIlllllIIIIIllI) {
        DrawHelper.drawBorderedRect(0.0, 0.0, this.width, this.height, 0.5, new Color(22, 22, 22, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
        this.username.drawTextBox();
        this.password.drawTextBox();
        this.mc.neverlose500_18.drawStringWithShadow("Alt Login", this.width / 2.0f, 20.0, -1);
        this.mc.neverlose500_18.drawStringWithShadow((this.thread == null) ? (TextFormatting.GRAY + "Alts...") : this.thread.getStatus(), this.width / 2.0f, 29.0, -1);
        if (this.username.getText().isEmpty() && !this.username.isFocused()) {
            this.mc.neverlose500_18.drawStringWithShadow("Username / E-Mail", this.width / 2 - 96, 66.0, -7829368);
        }
        if (this.password.getText().isEmpty() && !this.password.isFocused()) {
            this.mc.neverlose500_18.drawStringWithShadow("Password", this.width / 2 - 96, 106.0, -7829368);
        }
        super.drawScreen(llllllllllllIlIllIIlllllIIIIlIII, llllllllllllIlIllIIlllllIIIIIIll, llllllllllllIlIllIIlllllIIIIIllI);
    }
    
    @Override
    public void initGui() {
        final int llllllllllllIlIllIIllllIlllllllI = this.height / 4 + 24;
        this.buttonList.add(new GuiAltButton(0, this.width / 2 - 100, llllllllllllIlIllIIllllIlllllllI + 72 + 12, "Login"));
        this.buttonList.add(new GuiAltButton(1, this.width / 2 - 100, llllllllllllIlIllIIllllIlllllllI + 72 + 12 + 24, "Back"));
        this.buttonList.add(new GuiAltButton(2, this.width / 2 - 100, llllllllllllIlIllIIllllIlllllllI + 72 + 12 - 24, "Import User:Pass"));
        this.username = new GuiTextField(llllllllllllIlIllIIllllIlllllllI, Minecraft.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.password = new PasswordField(Minecraft.fontRendererObj, this.width / 2 - 100, 100, 200, 20);
        this.username.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }
    
    public GuiAltLogin(final GuiScreen llllllllllllIlIllIIlllllIIIllIll) {
        this.previousScreen = llllllllllllIlIllIIlllllIIIllIll;
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIlIllIIllllIllllIIlI, final int llllllllllllIlIllIIllllIllllIlIl) {
        try {
            super.keyTyped(llllllllllllIlIllIIllllIllllIIlI, llllllllllllIlIllIIllllIllllIlIl);
        }
        catch (IOException llllllllllllIlIllIIllllIllllIlII) {
            llllllllllllIlIllIIllllIllllIlII.printStackTrace();
        }
        if (llllllllllllIlIllIIllllIllllIIlI == '\t') {
            if (!this.username.isFocused() && !this.password.isFocused()) {
                this.username.setFocused(true);
            }
            else {
                this.username.setFocused(this.password.isFocused());
                this.password.setFocused(!this.username.isFocused());
            }
        }
        if (llllllllllllIlIllIIllllIllllIIlI == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(llllllllllllIlIllIIllllIllllIIlI, llllllllllllIlIllIIllllIllllIlIl);
        this.password.textboxKeyTyped(llllllllllllIlIllIIllllIllllIIlI, llllllllllllIlIllIIllllIllllIlIl);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIlIllIIlllllIIIlIlIl) {
        try {
            switch (llllllllllllIlIllIIlllllIIIlIlIl.id) {
                case 0: {
                    final AltLoginThread thread = new AltLoginThread(new Alt(this.username.getText(), this.password.getText()));
                    this.thread = thread;
                    thread.start();
                    break;
                }
                case 1: {
                    this.mc.displayGuiScreen(this.previousScreen);
                    break;
                }
                case 2: {
                    final String llllllllllllIlIllIIlllllIIIlIlII = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                    if (llllllllllllIlIllIIlllllIIIlIlII.contains(":")) {
                        final String[] llllllllllllIlIllIIlllllIIIlIIll = llllllllllllIlIllIIlllllIIIlIlII.split(":");
                        this.username.setText(llllllllllllIlIllIIlllllIIIlIIll[0]);
                        this.password.setText(llllllllllllIlIllIIlllllIIIlIIll[1]);
                        break;
                    }
                    break;
                }
            }
        }
        catch (Throwable llllllllllllIlIllIIlllllIIIlIIlI) {
            throw new RuntimeException();
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllIlIllIIllllIlllIIlII, final int llllllllllllIlIllIIllllIlllIlIII, final int llllllllllllIlIllIIllllIlllIIIlI) {
        try {
            super.mouseClicked(llllllllllllIlIllIIllllIlllIIlII, llllllllllllIlIllIIllllIlllIlIII, llllllllllllIlIllIIllllIlllIIIlI);
        }
        catch (IOException llllllllllllIlIllIIllllIlllIIllI) {
            llllllllllllIlIllIIllllIlllIIllI.printStackTrace();
        }
        this.username.mouseClicked(llllllllllllIlIllIIllllIlllIIlII, llllllllllllIlIllIIllllIlllIlIII, llllllllllllIlIllIIllllIlllIIIlI);
        this.password.mouseClicked(llllllllllllIlIllIIllllIlllIIlII, llllllllllllIlIllIIllllIlllIlIII, llllllllllllIlIllIIllllIlllIIIlI);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
}
