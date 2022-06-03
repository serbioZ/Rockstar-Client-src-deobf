// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager;

import java.io.IOException;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.resources.I18n;
import ru.rockstar.client.ui.altmanager.alt.AltConfig;
import ru.rockstar.Main;
import net.minecraft.client.gui.GuiMainMenu;
import org.apache.commons.lang3.RandomStringUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.Minecraft;
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
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import java.util.Iterator;
import ru.rockstar.client.ui.altmanager.alt.AltManager;
import java.util.ArrayList;
import java.util.List;
import ru.rockstar.client.ui.altmanager.alt.Alt;
import ru.rockstar.client.ui.altmanager.althening.api.AltService;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import ru.rockstar.client.ui.altmanager.alt.AltLoginThread;
import net.minecraft.client.gui.GuiScreen;

public class GuiAltManager extends GuiScreen
{
    private /* synthetic */ AltLoginThread loginThread;
    public /* synthetic */ String status;
    private /* synthetic */ ResourceLocation resourceLocation;
    private /* synthetic */ GuiTextField searchField;
    private /* synthetic */ GuiAltButton remove;
    private /* synthetic */ GuiAltButton login;
    private /* synthetic */ float offset;
    private /* synthetic */ GuiAltButton rename;
    public /* synthetic */ Alt selectedAlt;
    
    private List<Alt> getAlts() {
        final List<Alt> lllllllllllIllllllIllIllIlIIIllI = new ArrayList<Alt>();
        for (final Alt lllllllllllIllllllIllIllIlIIIlII : AltManager.registry) {
            if (this.searchField.getText().isEmpty() || lllllllllllIllllllIllIllIlIIIlII.getMask().toLowerCase().contains(this.searchField.getText().toLowerCase()) || lllllllllllIllllllIllIllIlIIIlII.getUsername().toLowerCase().contains(this.searchField.getText().toLowerCase())) {
                lllllllllllIllllllIllIllIlIIIllI.add(lllllllllllIllllllIllIllIlIIIlII);
            }
        }
        return lllllllllllIllllllIllIllIlIIIllI;
    }
    
    @Override
    public void drawScreen(final int lllllllllllIllllllIllIlllIIllllI, final int lllllllllllIllllllIllIlllIIIllIl, final float lllllllllllIllllllIllIlllIIIllII) {
        final ScaledResolution lllllllllllIllllllIllIlllIIllIll = new ScaledResolution(this.mc);
        DrawHelper.drawBorderedRect(-5.0, 0.0, lllllllllllIllllllIllIlllIIllIll.getScaledWidth() + 6, lllllllllllIllllllIllIlllIIllIll.getScaledHeight(), 0.5, new Color(44, 44, 44, 255).getRGB(), new Color(33, 33, 33, 255).getRGB(), true);
        DrawHelper.drawBorderedRect(1.0, 1.399999976158142, lllllllllllIllllllIllIlllIIllIll.getScaledWidth() - 1, lllllllllllIllllllIllIlllIIllIll.getScaledHeight() - 1.7f, 0.5, new Color(17, 17, 17, 255).getRGB(), new Color(33, 33, 33, 255).getRGB(), true);
        if (Mouse.hasWheel()) {
            final int lllllllllllIllllllIllIlllIIllIlI = Mouse.getDWheel();
            if (lllllllllllIllllllIllIlllIIllIlI < 0) {
                this.offset += 26.0f;
                if (this.offset < 0.0f) {
                    this.offset = 0.0f;
                }
            }
            else if (lllllllllllIllllllIllIlllIIllIlI > 0) {
                this.offset -= 26.0f;
                if (this.offset < 0.0f) {
                    this.offset = 0.0f;
                }
            }
        }
        final String lllllllllllIllllllIllIlllIIllIIl = "Name: " + this.mc.session.getUsername();
        this.mc.neverlose500_18.drawStringWithShadow(lllllllllllIllllllIllIlllIIllIIl, 11.0, 10.0, 14540253);
        DrawHelper.drawRect(this.mc.neverlose500_18.getStringWidth(lllllllllllIllllllIllIlllIIllIIl) + 14, this.mc.neverlose500_18.getStringHeight(lllllllllllIllllllIllIlllIIllIIl), 9.0, this.mc.neverlose500_18.getStringHeight(lllllllllllIllllllIllIlllIIllIIl) + 12, DrawHelper.getColor(255, 30));
        GlStateManager.pushMatrix();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        this.mc.neverlose500_18.drawCenteredString("Account Manager", this.width / 2.0f, 10.0f, -1);
        this.mc.neverlose500_18.drawCenteredString((this.loginThread == null) ? this.status : this.loginThread.getStatus(), this.width / 2.0f, 21.0f, -1);
        GlStateManager.pushMatrix();
        DrawHelper.scissorRect(0.0f, 33.0f, (float)this.width, (float)(this.height - 50));
        GL11.glEnable(3089);
        int lllllllllllIllllllIllIlllIIllIII = 38;
        int lllllllllllIllllllIllIlllIIlIlll = 0;
        for (final Alt lllllllllllIllllllIllIlllIIlIlIl : this.getAlts()) {
            if (this.isAltInArea(lllllllllllIllllllIllIlllIIllIII)) {
                ++lllllllllllIllllllIllIlllIIlIlll;
                String lllllllllllIllllllIllIlllIIlIIll = null;
                if (lllllllllllIllllllIllIlllIIlIlIl.getMask().equals("")) {
                    final String lllllllllllIllllllIllIlllIIlIlII = lllllllllllIllllllIllIlllIIlIlIl.getUsername();
                }
                else {
                    lllllllllllIllllllIllIlllIIlIIll = lllllllllllIllllllIllIlllIIlIlIl.getMask();
                }
                String lllllllllllIllllllIllIlllIIlIIIl = null;
                if (lllllllllllIllllllIllIlllIIlIlIl.getPassword().equals("")) {
                    final String lllllllllllIllllllIllIlllIIlIIlI = "Not License";
                }
                else {
                    lllllllllllIllllllIllIlllIIlIIIl = lllllllllllIllllllIllIlllIIlIlIl.getPassword().replaceAll(".", "*");
                }
                if (lllllllllllIllllllIllIlllIIlIlIl != this.selectedAlt) {
                    if (this.isMouseOverAlt(lllllllllllIllllllIllIlllIIllllI, lllllllllllIllllllIllIlllIIIllIl, lllllllllllIllllllIllIlllIIllIII) && Mouse.isButtonDown(0)) {
                        DrawHelper.drawBorderedRect(this.width / 2.0f - 125.0f, lllllllllllIllllllIllIlllIIllIII - this.offset - 4.0f, this.width / 1.5f, lllllllllllIllllllIllIlllIIllIII - this.offset + 30.0f, 1.0, -DrawHelper.getColor(255, 50), DrawHelper.getColor(40, 50), false);
                    }
                    else if (this.isMouseOverAlt(lllllllllllIllllllIllIlllIIllllI, lllllllllllIllllllIllIlllIIIllIl, lllllllllllIllllllIllIlllIIllIII - this.offset)) {
                        DrawHelper.drawBorderedRect(this.width / 2.0f - 125.0f, lllllllllllIllllllIllIlllIIllIII - this.offset - 4.0f, this.width / 1.5f, lllllllllllIllllllIllIlllIIllIII - this.offset + 30.0f, 1.0, DrawHelper.getColor(255, 50), DrawHelper.getColor(40, 50), false);
                    }
                }
                else if (this.isMouseOverAlt(lllllllllllIllllllIllIlllIIllllI, lllllllllllIllllllIllIlllIIIllIl, lllllllllllIllllllIllIlllIIllIII) && Mouse.isButtonDown(0)) {
                    DrawHelper.drawBorderedRect(this.width / 2.0f - 125.0f, lllllllllllIllllllIllIlllIIllIII - this.offset - 4.0f, this.width / 1.5f, lllllllllllIllllllIllIlllIIllIII - this.offset + 30.0f, 1.0, DrawHelper.getColor(255, 50), DrawHelper.getColor(40, 50), false);
                }
                else if (this.isMouseOverAlt(lllllllllllIllllllIllIlllIIllllI, lllllllllllIllllllIllIlllIIIllIl, lllllllllllIllllllIllIlllIIllIII - this.offset)) {
                    DrawHelper.drawBorderedRect(this.width / 2.0f - 125.0f, lllllllllllIllllllIllIlllIIllIII - this.offset - 4.0f, this.width / 1.5f, lllllllllllIllllllIllIlllIIllIII - this.offset + 30.0f, 1.0, DrawHelper.getColor(255, 50), DrawHelper.getColor(40, 50), false);
                }
                else {
                    DrawHelper.drawBorderedRect(this.width / 2.0f - 125.0f, lllllllllllIllllllIllIlllIIllIII - this.offset - 4.0f, this.width / 1.5f, lllllllllllIllllllIllIlllIIllIII - this.offset + 30.0f, 1.0, DrawHelper.getColor(255, 50), DrawHelper.getColor(40, 50), false);
                }
                final String lllllllllllIllllllIllIlllIIlIIII = new StringBuilder().append(TextFormatting.GRAY).append(lllllllllllIllllllIllIlllIIlIlll).append(". ").append(TextFormatting.RESET).toString();
                GlStateManager.pushMatrix();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                if (this.resourceLocation == null) {
                    this.resourceLocation = AbstractClientPlayer.getLocationSkin(lllllllllllIllllllIllIlllIIlIIll);
                    this.getDownloadImageSkin(this.resourceLocation, lllllllllllIllllllIllIlllIIlIIll);
                }
                else {
                    this.mc.getTextureManager().bindTexture(this.resourceLocation);
                    GlStateManager.enableTexture2D();
                }
                GlStateManager.popMatrix();
                this.mc.sfui18.drawCenteredString(String.valueOf(lllllllllllIllllllIllIlllIIlIIII) + lllllllllllIllllllIllIlllIIlIIll, this.width / 2.0f, lllllllllllIllllllIllIlllIIllIII - this.offset + 5.0f, -1);
                this.mc.sfui18.drawCenteredString(lllllllllllIllllllIllIlllIIlIIIl, this.width / 2.0f, lllllllllllIllllllIllIlllIIllIII - this.offset + 17.0f, DrawHelper.getColor(110));
                lllllllllllIllllllIllIlllIIllIII += 40;
            }
        }
        GL11.glDisable(3089);
        GL11.glPopMatrix();
        super.drawScreen(lllllllllllIllllllIllIlllIIllllI, lllllllllllIllllllIllIlllIIIllIl, lllllllllllIllllllIllIlllIIIllII);
        if (this.selectedAlt == null) {
            this.login.enabled = false;
            this.remove.enabled = false;
            this.rename.enabled = false;
        }
        else {
            this.login.enabled = true;
            this.remove.enabled = true;
            this.rename.enabled = true;
        }
        if (Keyboard.isKeyDown(200)) {
            this.offset -= 26.0f;
        }
        else if (Keyboard.isKeyDown(208)) {
            this.offset += 26.0f;
        }
        if (this.offset < 0.0f) {
            this.offset = 0.0f;
        }
        this.searchField.drawTextBox();
        if (this.searchField.getText().isEmpty() && !this.searchField.isFocused()) {
            this.mc.neverlose500_18.drawStringWithShadow("Search Alt", this.width / 2 + 125, this.height - 18, DrawHelper.getColor(180));
        }
    }
    
    private boolean isAltInArea(final int lllllllllllIllllllIllIllIlllIIII) {
        return lllllllllllIllllllIllIllIlllIIII - this.offset <= this.height - 50;
    }
    
    private void getDownloadImageSkin(final ResourceLocation lllllllllllIllllllIllIllllIIIIIl, final String lllllllllllIllllllIllIlllIlllIll) {
        final TextureManager lllllllllllIllllllIllIlllIllllll = this.mc.getTextureManager();
        lllllllllllIllllllIllIlllIllllll.getTexture(lllllllllllIllllllIllIllllIIIIIl);
        final ThreadDownloadImageData lllllllllllIllllllIllIlllIlllllI = new ThreadDownloadImageData(null, String.format("https://minotar.net/avatar/%s/64.png", StringUtils.stripControlCodes(lllllllllllIllllllIllIlllIlllIll)), DefaultPlayerSkin.getDefaultSkin(EntityPlayer.getOfflineUUID(lllllllllllIllllllIllIlllIlllIll)), new ImageBufferDownload());
        lllllllllllIllllllIllIlllIllllll.loadTexture(lllllllllllIllllllIllIllllIIIIIl, lllllllllllIllllllIllIlllIlllllI);
    }
    
    @Override
    public void initGui() {
        this.searchField = new GuiTextField(this.eventButton, Minecraft.fontRendererObj, this.width / 2 + 116, this.height - 22, 72, 16);
        final List<GuiButton> buttonList = this.buttonList;
        final GuiAltButton login = new GuiAltButton(1, this.width / 2 - 122, this.height - 48, 100, 20, "Login");
        this.login = login;
        buttonList.add(login);
        final List<GuiButton> buttonList2 = this.buttonList;
        final GuiAltButton remove = new GuiAltButton(2, this.width / 2 - 40, this.height - 24, 70, 20, "Remove");
        this.remove = remove;
        buttonList2.add(remove);
        this.buttonList.add(new GuiAltButton(3, this.width / 2 + 4 + 86, this.height - 48, 100, 20, "Add"));
        this.buttonList.add(new GuiAltButton(4, this.width / 2 - 16, this.height - 48, 100, 20, "Direct Login"));
        this.buttonList.add(new GuiAltButton(5, this.width / 2 - 122, this.height - 24, 78, 20, "Random"));
        final List<GuiButton> buttonList3 = this.buttonList;
        final GuiAltButton rename = new GuiAltButton(6, this.width / 2 + 38, this.height - 24, 70, 20, "Edit");
        this.rename = rename;
        buttonList3.add(rename);
        this.buttonList.add(new GuiAltButton(7, this.width / 2 - 190, this.height - 24, 60, 20, "Back"));
        this.login.enabled = false;
        this.remove.enabled = false;
        this.rename.enabled = false;
    }
    
    private boolean isMouseOverAlt(final double lllllllllllIllllllIllIllIllIIlII, final double lllllllllllIllllllIllIllIllIIlll, final double lllllllllllIllllllIllIllIllIIllI) {
        return lllllllllllIllllllIllIllIllIIlII >= this.width / 2.0f - 125.0f && lllllllllllIllllllIllIllIllIIlll >= lllllllllllIllllllIllIllIllIIllI - 4.0 && lllllllllllIllllllIllIllIllIIlII <= this.width / 1.5 && lllllllllllIllllllIllIllIllIIlll <= lllllllllllIllllllIllIllIllIIllI + 20.0 && lllllllllllIllllllIllIllIllIIlII >= 0.0 && lllllllllllIllllllIllIllIllIIlll >= 33.0 && lllllllllllIllllllIllIllIllIIlII <= this.width && lllllllllllIllllllIllIllIllIIlll <= this.height - 50;
    }
    
    public GuiAltManager() {
        this.selectedAlt = null;
        this.status = TextFormatting.DARK_GRAY + "(" + TextFormatting.GRAY + AltManager.registry.size() + TextFormatting.DARK_GRAY + ")";
    }
    
    public void actionPerformed(final GuiButton lllllllllllIllllllIllIlllIllIIll) {
        switch (lllllllllllIllllllIllIlllIllIIll.id) {
            case 1: {
                final AltLoginThread loginThread = new AltLoginThread(this.selectedAlt);
                this.loginThread = loginThread;
                loginThread.start();
                break;
            }
            case 2: {
                if (this.loginThread != null) {
                    this.loginThread = null;
                }
                AltManager.registry.remove(this.selectedAlt);
                this.status = TextFormatting.GREEN + "Removed.";
                this.selectedAlt = null;
                break;
            }
            case 3: {
                this.mc.displayGuiScreen(new GuiAddAlt(this));
                break;
            }
            case 4: {
                this.mc.displayGuiScreen(new GuiAltLogin(this));
                break;
            }
            case 5: {
                final String lllllllllllIllllllIllIlllIllIIlI = "Rockstar" + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(2);
                final AltLoginThread loginThread2 = new AltLoginThread(new Alt(lllllllllllIllllllIllIlllIllIIlI, ""));
                this.loginThread = loginThread2;
                loginThread2.start();
                AltManager.registry.add(new Alt(lllllllllllIllllllIllIlllIllIIlI, ""));
                break;
            }
            case 6: {
                this.mc.displayGuiScreen(new GuiRenameAlt(this));
                break;
            }
            case 7: {
                this.mc.displayGuiScreen(new GuiMainMenu());
                break;
            }
            case 8: {
                this.status = TextFormatting.RED + "Refreshed!";
                try {
                    Main.instance.fileManager.getFile(AltConfig.class).loadFile();
                }
                catch (Exception lllllllllllIllllllIllIlllIllIIIl) {
                    lllllllllllIllllllIllIlllIllIIIl.printStackTrace();
                }
                break;
            }
            case 4545: {
                this.mc.displayGuiScreen(new GuiConnecting(this, this.mc, new ServerData(I18n.format("selectServer.defaultName", new Object[0]), "play.hypixel.net", false)));
                break;
            }
            case 8931: {
                this.mc.displayGuiScreen(new GuiMultiplayer(this));
                break;
            }
        }
    }
    
    static {
        altService = new AltService();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIllllllIllIllIlIllIIl, final int lllllllllllIllllllIllIllIlIllIII, final int lllllllllllIllllllIllIllIlIlIlll) {
        this.searchField.mouseClicked(lllllllllllIllllllIllIllIlIllIIl, lllllllllllIllllllIllIllIlIllIII, lllllllllllIllllllIllIllIlIlIlll);
        if (this.offset < 0.0f) {
            this.offset = 0.0f;
        }
        double lllllllllllIllllllIllIllIlIlIllI = 38.0f - this.offset;
        for (final Alt lllllllllllIllllllIllIllIlIlIlII : this.getAlts()) {
            if (this.isMouseOverAlt(lllllllllllIllllllIllIllIlIllIIl, lllllllllllIllllllIllIllIlIllIII, lllllllllllIllllllIllIllIlIlIllI)) {
                if (lllllllllllIllllllIllIllIlIlIlII == this.selectedAlt) {
                    this.actionPerformed(this.login);
                    return;
                }
                this.selectedAlt = lllllllllllIllllllIllIllIlIlIlII;
            }
            lllllllllllIllllllIllIllIlIlIllI += 40.0;
        }
        try {
            super.mouseClicked(lllllllllllIllllllIllIllIlIllIIl, lllllllllllIllllllIllIllIlIllIII, lllllllllllIllllllIllIllIlIlIlll);
        }
        catch (IOException lllllllllllIllllllIllIllIlIlIIll) {
            lllllllllllIllllllIllIllIlIlIIll.printStackTrace();
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIllllllIllIllIllllIlI, final int lllllllllllIllllllIllIllIllllIIl) {
        this.searchField.textboxKeyTyped(lllllllllllIllllllIllIllIllllIlI, lllllllllllIllllllIllIllIllllIIl);
        if ((lllllllllllIllllllIllIllIllllIlI == '\t' || lllllllllllIllllllIllIllIllllIlI == '\r') && this.searchField.isFocused()) {
            this.searchField.setFocused(!this.searchField.isFocused());
        }
        try {
            super.keyTyped(lllllllllllIllllllIllIllIllllIlI, lllllllllllIllllllIllIllIllllIIl);
        }
        catch (IOException lllllllllllIllllllIllIllIllllIII) {
            lllllllllllIllllllIllIllIllllIII.printStackTrace();
        }
    }
}
