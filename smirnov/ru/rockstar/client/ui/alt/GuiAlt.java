// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.alt;

import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.IImageBuffer;
import java.io.File;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StringUtils;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.gui.ScaledResolution;
import java.io.IOException;
import java.security.SecureRandom;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.GuiTextField;
import ru.rockstar.api.utils.render.glsandbox.animbackground;
import net.minecraft.client.gui.GuiScreen;

public final class GuiAlt extends GuiScreen
{
    private /* synthetic */ PasswordField password;
    private /* synthetic */ AltLoginThread thread;
    private /* synthetic */ animbackground backgroundShader;
    private /* synthetic */ GuiTextField username;
    private static /* synthetic */ String alphabet;
    private /* synthetic */ ResourceLocation resourceLocation;
    private final /* synthetic */ long initTime;
    private final /* synthetic */ GuiScreen previousScreen;
    private static final /* synthetic */ SecureRandom secureRandom;
    
    public GuiAlt(final GuiScreen lllllllllllllIIIlIIIlllllllIIlll) {
        this.initTime = System.currentTimeMillis();
        try {
            this.backgroundShader = new animbackground("/noise.fsh");
        }
        catch (IOException lllllllllllllIIIlIIIlllllllIlIIl) {
            throw new IllegalStateException("Failed to load backgound shader", lllllllllllllIIIlIIIlllllllIlIIl);
        }
        this.previousScreen = lllllllllllllIIIlIIIlllllllIIlll;
    }
    
    static {
        GuiAlt.alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        secureRandom = new SecureRandom();
        GuiAlt.alphabet = String.valueOf(GuiAlt.alphabet) + GuiAlt.alphabet.toLowerCase();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIlIIIllllllIIIIII, final int lllllllllllllIIIlIIIlllllIllllll, final float lllllllllllllIIIlIIIlllllIlllllI) {
        final ScaledResolution lllllllllllllIIIlIIIlllllIllllIl = new ScaledResolution(this.mc);
        GlStateManager.disableCull();
        this.backgroundShader.useShader(lllllllllllllIIIlIIIlllllIllllIl.getScaledWidth() + 700, lllllllllllllIIIlIIIlllllIllllIl.getScaledHeight(), (float)lllllllllllllIIIlIIIllllllIIIIII, (float)lllllllllllllIIIlIIIlllllIllllll, (System.currentTimeMillis() - this.initTime) / 1000.0f);
        GL11.glBegin(7);
        GL11.glVertex2f(-1.0f, -1.0f);
        GL11.glVertex2f(-1.0f, 1.0f);
        GL11.glVertex2f(1.0f, 1.0f);
        GL11.glVertex2f(1.0f, -1.0f);
        GL11.glEnd();
        GL20.glUseProgram(0);
        GlStateManager.disableCull();
        final int lllllllllllllIIIlIIIlllllIllllII = this.height / 4 + 24;
        DrawHelper.drawRectWithGlow(this.width / 2 - 120, lllllllllllllIIIlIIIlllllIllllII - 10, this.width / 2 + 110, lllllllllllllIIIlIIIlllllIllllII + 110, 5.0, 3.0, new Color(0, 0, 0, 42));
        this.username.drawTextBoxalt();
        this.password.drawTextBox();
        Minecraft.getMinecraft().neverlose500_18.drawCenteredString("AltManager", (float)(this.width / 2 - 6), (float)lllllllllllllIIIlIIIlllllIllllII, -1);
        Minecraft.getMinecraft().neverlose500_15.drawCenteredString((this.thread == null) ? new StringBuilder().append(TextFormatting.GRAY).toString() : this.thread.getStatus(), (float)(this.width / 2 - 5), (float)(lllllllllllllIIIlIIIlllllIllllII + 98), -1);
        if (this.username.getText().isEmpty() && !this.username.isFocused()) {
            Minecraft.getMinecraft().neverlose500_16.drawStringWithShadow("Email", this.width / 2 - 52, lllllllllllllIIIlIIIlllllIllllII + 24, -7829368);
        }
        if (this.password.getText().isEmpty() && !this.password.isFocused()) {
            Minecraft.getMinecraft().neverlose500_16.drawStringWithShadow("Pass", this.width / 2 - 52, lllllllllllllIIIlIIIlllllIllllII + 44, -7829368);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.resourceLocation = AbstractClientPlayer.getLocationSkin(this.mc.session.getUsername());
        this.getDownloadImageSkin(this.resourceLocation, this.mc.session.getUsername());
        this.mc.getTextureManager().bindTexture(this.resourceLocation);
        Gui.drawScaledCustomSizeModalRect(this.width / 2 - 99, lllllllllllllIIIlIIIlllllIllllII + 22, 8.0f, 8.0f, 8, 8, 30, 30, 64.0f, 64.0f);
        super.drawScreen(lllllllllllllIIIlIIIllllllIIIIII, lllllllllllllIIIlIIIlllllIllllll, lllllllllllllIIIlIIIlllllIlllllI);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIIIlIIIlllllIlIIlll, final int lllllllllllllIIIlIIIlllllIlIIllI) {
        try {
            super.keyTyped(lllllllllllllIIIlIIIlllllIlIIlll, lllllllllllllIIIlIIIlllllIlIIllI);
        }
        catch (IOException ex) {}
        if (lllllllllllllIIIlIIIlllllIlIIlll == '\t') {
            if (!this.username.isFocused() && !this.password.isFocused()) {
                this.username.setFocused(true);
            }
            else {
                this.username.setFocused(this.password.isFocused());
                this.password.setFocused(!this.username.isFocused());
            }
        }
        if (lllllllllllllIIIlIIIlllllIlIIlll == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(lllllllllllllIIIlIIIlllllIlIIlll, lllllllllllllIIIlIIIlllllIlIIllI);
        this.password.textboxKeyTyped(lllllllllllllIIIlIIIlllllIlIIlll, lllllllllllllIIIlIIIlllllIlIIllI);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIlIIIllllllIllIIl) {
        switch (lllllllllllllIIIlIIIllllllIllIIl.id) {
            case 2: {
                this.thread = new AltLoginThread("Rockstar" + randomString(6), "");
                this.thread.start();
                break;
            }
            case 0: {
                this.thread = new AltLoginThread(this.username.getText(), this.password.getText());
                this.thread.start();
                break;
            }
        }
    }
    
    public static String randomString(final int lllllllllllllIIIlIIIlllllllIIIlI) {
        final StringBuilder lllllllllllllIIIlIIIlllllllIIIIl = new StringBuilder(lllllllllllllIIIlIIIlllllllIIIlI);
        for (int lllllllllllllIIIlIIIlllllllIIIII = 0; lllllllllllllIIIlIIIlllllllIIIII < lllllllllllllIIIlIIIlllllllIIIlI; ++lllllllllllllIIIlIIIlllllllIIIII) {
            lllllllllllllIIIlIIIlllllllIIIIl.append(GuiAlt.alphabet.charAt(GuiAlt.secureRandom.nextInt(GuiAlt.alphabet.length())));
        }
        return lllllllllllllIIIlIIIlllllllIIIIl.toString();
    }
    
    @Override
    public void initGui() {
        final int lllllllllllllIIIlIIIlllllIllIIlI = this.height / 4 + 24;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50, lllllllllllllIIIlIIIlllllIllIIlI + 60, 90, 13, "Login"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 50, lllllllllllllIIIlIIIlllllIllIIlI + 64 + 12, 90, 13, "Random name"));
        this.username = new GuiTextField(lllllllllllllIIIlIIIlllllIllIIlI, Minecraft.fontRendererObj, this.width / 2 - 55, lllllllllllllIIIlIIIlllllIllIIlI + 20, 100, 13);
        this.password = new PasswordField(Minecraft.fontRendererObj, this.width / 2 - 55, lllllllllllllIIIlIIIlllllIllIIlI + 40, 100, 13);
        this.username.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
        this.password.updateCursorCounter();
    }
    
    private void getDownloadImageSkin(final ResourceLocation lllllllllllllIIIlIIIllllllIlIIII, final String lllllllllllllIIIlIIIllllllIIlIlI) {
        final TextureManager lllllllllllllIIIlIIIllllllIIlllI = this.mc.getTextureManager();
        lllllllllllllIIIlIIIllllllIIlllI.getTexture(lllllllllllllIIIlIIIllllllIlIIII);
        final ThreadDownloadImageData lllllllllllllIIIlIIIllllllIIllIl = new ThreadDownloadImageData(null, String.format("https://minotar.net/avatar/%s/64.png", StringUtils.stripControlCodes(lllllllllllllIIIlIIIllllllIIlIlI)), DefaultPlayerSkin.getDefaultSkin(EntityPlayer.getOfflineUUID(lllllllllllllIIIlIIIllllllIIlIlI)), new ImageBufferDownload());
        lllllllllllllIIIlIIIllllllIIlllI.loadTexture(lllllllllllllIIIlIIIllllllIlIIII, lllllllllllllIIIlIIIllllllIIllIl);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIIIlIIIlllllIIllIIl, final int lllllllllllllIIIlIIIlllllIIlllIl, final int lllllllllllllIIIlIIIlllllIIlllII) {
        try {
            super.mouseClicked(lllllllllllllIIIlIIIlllllIIllIIl, lllllllllllllIIIlIIIlllllIIlllIl, lllllllllllllIIIlIIIlllllIIlllII);
        }
        catch (IOException lllllllllllllIIIlIIIlllllIIllIll) {
            lllllllllllllIIIlIIIlllllIIllIll.printStackTrace();
        }
        this.username.mouseClicked(lllllllllllllIIIlIIIlllllIIllIIl, lllllllllllllIIIlIIIlllllIIlllIl, lllllllllllllIIIlIIIlllllIIlllII);
        this.password.mouseClicked(lllllllllllllIIIlIIIlllllIIllIIl, lllllllllllllIIIlIIIlllllIIlllIl, lllllllllllllIIIlIIIlllllIIlllII);
    }
}
