// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui;

import ru.rockstar.client.ui.settings.button.ConfigGuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import java.io.IOException;
import ru.rockstar.client.ui.settings.config.ConfigManager;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;
import ru.rockstar.Main;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.client.features.impl.display.ClickGUI;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.settings.config.Config;
import ru.rockstar.client.features.Category;
import net.minecraft.client.gui.GuiTextField;
import ru.rockstar.client.ui.clickgui.ScreenHelper;
import ru.rockstar.api.utils.other.ParticleEngine;
import ru.rockstar.client.ui.settings.button.ImageButton;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;

public class GuiConfig extends GuiScreen
{
    private /* synthetic */ float scrollOffset;
    protected /* synthetic */ ArrayList<ImageButton> imageButtons;
    private /* synthetic */ int width;
    /* synthetic */ ParticleEngine idinahyi;
    private /* synthetic */ int height;
    private /* synthetic */ int width2;
    public /* synthetic */ ScreenHelper screenHelper;
    public static /* synthetic */ GuiTextField search;
    public /* synthetic */ Category type;
    public static /* synthetic */ Config selectedConfig;
    
    @Override
    public void drawScreen(final int lllllllllllIIlIIIIIlIIlIlllIIIII, final int lllllllllllIIlIIIIIlIIlIllllIIII, final float lllllllllllIIlIIIIIlIIlIlllIllll) {
        final ScaledResolution lllllllllllIIlIIIIIlIIlIlllIlllI = new ScaledResolution(this.mc);
        Color lllllllllllIIlIIIIIlIIlIlllIllIl = Color.WHITE;
        final Color lllllllllllIIlIIIIIlIIlIlllIllII = new Color(ClickGUI.color.getColorValue());
        final Color lllllllllllIIlIIIIIlIIlIlllIlIll = new Color(ClickGUI.colorTwo.getColorValue());
        final double lllllllllllIIlIIIIIlIIlIlllIlIlI = ClickGUI.speed.getNumberValue();
        final long lllllllllllIIlIIIIIlIIlIllIllIII;
        switch (((String)(lllllllllllIIlIIIIIlIIlIllIllIII = (long)ClickGUI.clickGuiColor.currentMode)).hashCode()) {
            case -1808614770: {
                if (!((String)lllllllllllIIlIIIIIlIIlIllIllIII).equals("Static")) {
                    break;
                }
                lllllllllllIIlIIIIIlIIlIlllIllIl = lllllllllllIIlIIIIIlIIlIlllIllII;
                break;
            }
            case -1656737386: {
                if (!((String)lllllllllllIIlIIIIIlIIlIllIllIII).equals("Rainbow")) {
                    break;
                }
                lllllllllllIIlIIIIIlIIlIlllIllIl = DrawHelper.rainbow(300, 1.0f, 1.0f);
                break;
            }
            case -311641137: {
                if (!((String)lllllllllllIIlIIIIIlIIlIllIllIII).equals("Color Two")) {
                    break;
                }
                lllllllllllIIlIIIIIlIIlIlllIllIl = new Color(DrawHelper.fadeColor(lllllllllllIIlIIIIIlIIlIlllIllII.getRGB(), lllllllllllIIlIIIIIlIIlIlllIlIll.getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIlIIIIIlIIlIlllIlIlI / lllllllllllIIlIIIIIlIIlIlllIlIlI + this.height * 6L / 60L * 2L) % 2.0 - 1.0)));
                break;
            }
            case 2181788: {
                if (!((String)lllllllllllIIlIIIIIlIIlIllIllIII).equals("Fade")) {
                    break;
                }
                lllllllllllIIlIIIIIlIIlIlllIllIl = new Color(ClickGUI.color.getColorValue());
                break;
            }
            case 115155230: {
                if (!((String)lllllllllllIIlIIIIIlIIlIllIllIII).equals("Category")) {
                    break;
                }
                lllllllllllIIlIIIIIlIIlIlllIllIl = new Color(this.type.getColor());
                break;
            }
            case 961091784: {
                if (!((String)lllllllllllIIlIIIIIlIIlIllIllIII).equals("Astolfo")) {
                    break;
                }
                lllllllllllIIlIIIIIlIIlIlllIllIl = DrawHelper.astolfo(true, this.width);
                break;
            }
            case 2021122027: {
                if (!((String)lllllllllllIIlIIIIIlIIlIllIllIII).equals("Client")) {
                    break;
                }
                lllllllllllIIlIIIIIlIIlIlllIllIl = ClientHelper.getClientColor();
                break;
            }
        }
        final Color lllllllllllIIlIIIIIlIIlIlllIlIIl = new Color(0, 0, 0, 0);
        if (ClickGUI.background.getBoolValue()) {
            this.drawDefaultBackground();
            this.drawGradientRect(0, 0, lllllllllllIIlIIIIIlIIlIlllIlllI.getScaledWidth(), lllllllllllIIlIIIIIlIIlIlllIlllI.getScaledHeight(), lllllllllllIIlIIIIIlIIlIlllIlIIl.getRGB(), lllllllllllIIlIIIIIlIIlIlllIllIl.getRGB());
        }
        for (final Config lllllllllllIIlIIIIIlIIlIlllIlIII : Main.instance.configManager.getContents()) {
            if (lllllllllllIIlIIIIIlIIlIlllIlIII != null && Mouse.hasWheel() && this.isHoveredConfig(this.width - 100, this.height - 122, 151, this.height + 59, lllllllllllIIlIIIIIlIIlIlllIIIII, lllllllllllIIlIIIIIlIIlIllllIIII)) {
                final int lllllllllllIIlIIIIIlIIlIlllIIlll = Mouse.getDWheel();
                if (lllllllllllIIlIIIIIlIIlIlllIIlll < 0) {
                    this.scrollOffset += 13.0f;
                    if (this.scrollOffset >= 0.0f) {
                        continue;
                    }
                    this.scrollOffset = 0.0f;
                }
                else {
                    if (lllllllllllIIlIIIIIlIIlIlllIIlll <= 0) {
                        continue;
                    }
                    this.scrollOffset -= 13.0f;
                    if (this.scrollOffset >= 0.0f) {
                        continue;
                    }
                    this.scrollOffset = 0.0f;
                }
            }
        }
        GlStateManager.pushMatrix();
        DrawHelper.drawRectWithGlow(this.width - 132, this.height - 160, this.width + 132, this.height + 25, 10.0, 5.0, new Color(20, 20, 20, 230));
        DrawHelper.drawRectWithGlow(this.width - 25 + 155, this.height - 135, this.width - 25 + 95, this.height - 95 - 26, 5.0, 10.0, new Color(1, 1, 1, 130));
        this.mc.mntsb_30.drawCenteredStringWithShadow("Config Manager", (float)(this.width - 60), (float)(this.height - 155), -1);
        GuiConfig.search.drawTextBox();
        if (GuiConfig.search.getText().isEmpty() && !GuiConfig.search.isFocused()) {
            this.mc.mntsb.drawStringWithShadow("Config name...", this.width - 125, this.height - 130, DrawHelper.getColor(200));
        }
        for (final ImageButton lllllllllllIIlIIIIIlIIlIlllIIllI : this.imageButtons) {
            lllllllllllIIlIIIIIlIIlIlllIIllI.draw(lllllllllllIIlIIIIIlIIlIlllIIIII, lllllllllllIIlIIIIIlIIlIllllIIII, Color.WHITE);
            if (Mouse.isButtonDown(0)) {
                lllllllllllIIlIIIIIlIIlIlllIIllI.onClick(lllllllllllIIlIIIIIlIIlIlllIIIII, lllllllllllIIlIIIIIlIIlIllllIIII);
            }
        }
        int lllllllllllIIlIIIIIlIIlIlllIIlIl = 5;
        GL11.glEnable(3089);
        DrawHelper.scissorRect(0.0f, (float)(this.height - 119), (float)(this.width + 130), this.height + 20);
        for (final Config lllllllllllIIlIIIIIlIIlIlllIIIlI : Main.instance.configManager.getContents()) {
            if (lllllllllllIIlIIIIIlIIlIlllIIIlI != null) {
                int lllllllllllIIlIIIIIlIIlIlllIIIll = 0;
                if (this.isHoveredConfig(this.width - 150, (int)(this.height - 117 + lllllllllllIIlIIIIIlIIlIlllIIlIl - this.scrollOffset), this.width + 100, 14, lllllllllllIIlIIIIIlIIlIlllIIIII, lllllllllllIIlIIIIIlIIlIllllIIII)) {
                    final int lllllllllllIIlIIIIIlIIlIlllIIlII = -1;
                    if (Mouse.isButtonDown(0)) {
                        GuiConfig.selectedConfig = new Config(lllllllllllIIlIIIIIlIIlIlllIIIlI.getName());
                    }
                }
                else {
                    lllllllllllIIlIIIIIlIIlIlllIIIll = DrawHelper.getColor(200);
                }
                if (GuiConfig.selectedConfig != null && lllllllllllIIlIIIIIlIIlIlllIIIlI.getName().equals(GuiConfig.selectedConfig.getName())) {
                    DrawHelper.drawRectWithGlow(this.width - 125, this.height - 119 + lllllllllllIIlIIIIIlIIlIlllIIlIl - this.scrollOffset, this.width + 125, this.height - 107 + lllllllllllIIlIIIIIlIIlIlllIIlIl - this.scrollOffset, 6.0, 10.0, new Color(66, 66, 66, 255));
                }
                DrawHelper.drawRectWithGlow(this.width - 125, this.height - 119 + lllllllllllIIlIIIIIlIIlIlllIIlIl - this.scrollOffset, this.width + 125, this.height - 107 + lllllllllllIIlIIIIIlIIlIlllIIlIl - this.scrollOffset, 5.0, 10.0, new Color(1, 1, 1, 255));
                this.mc.neverlose500_16.drawCenteredString(lllllllllllIIlIIIIIlIIlIlllIIIlI.getName(), (float)(this.width + this.mc.neverlose500_16.getStringWidth(lllllllllllIIlIIIIIlIIlIlllIIIlI.getName()) / 2 - 120), this.height - 115 + lllllllllllIIlIIIIIlIIlIlllIIlIl - this.scrollOffset, lllllllllllIIlIIIIIlIIlIlllIIIll);
                lllllllllllIIlIIIIIlIIlIlllIIlIl += 20;
            }
        }
        GL11.glDisable(3089);
        GlStateManager.popMatrix();
        super.drawScreen(lllllllllllIIlIIIIIlIIlIlllIIIII, lllllllllllIIlIIIIIlIIlIllllIIII, lllllllllllIIlIIIIIlIIlIlllIllll);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIlIIIIIlIIllIIIlllIl) throws IOException {
        if (lllllllllllIIlIIIIIlIIllIIIlllIl.id == 1) {
            Main.instance.configManager.saveConfig(GuiConfig.search.getText());
            Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "created config: " + ChatFormatting.RED + "\"" + GuiConfig.search.getText() + "\"", true);
            NotificationPublisher.queue("Config", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "created config: " + ChatFormatting.RED + "\"" + GuiConfig.search.getText() + "\"", NotificationType.SUCCESS);
            ConfigManager.getLoadedConfigs().clear();
            Main.instance.configManager.load();
            GuiConfig.search.setFocused(false);
            GuiConfig.search.setText("");
        }
        if (GuiConfig.selectedConfig != null) {
            if (lllllllllllIIlIIIIIlIIllIIIlllIl.id == 2) {
                if (Main.instance.configManager.loadConfig(GuiConfig.selectedConfig.getName())) {
                    Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "loaded config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", true);
                    NotificationPublisher.queue("Config", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "loaded config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", NotificationType.SUCCESS);
                }
                else {
                    Main.msg(ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "load config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", true);
                    NotificationPublisher.queue("Config", ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "load config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", NotificationType.ERROR);
                }
            }
            else if (lllllllllllIIlIIIIIlIIllIIIlllIl.id == 3) {
                if (Main.instance.configManager.saveConfig(GuiConfig.selectedConfig.getName())) {
                    Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "saved config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", true);
                    NotificationPublisher.queue("Config", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "saved config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", NotificationType.SUCCESS);
                }
                else {
                    Main.msg(ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "to save config: " + ChatFormatting.RED + "\"" + GuiConfig.search.getText() + "\"", true);
                    NotificationPublisher.queue("Config", ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "to save config: " + ChatFormatting.RED + "\"" + GuiConfig.search.getText() + "\"", NotificationType.ERROR);
                }
            }
            else if (lllllllllllIIlIIIIIlIIllIIIlllIl.id == 4) {
                if (Main.instance.configManager.deleteConfig(GuiConfig.selectedConfig.getName())) {
                    Main.msg(ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "deleted config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", true);
                    NotificationPublisher.queue("Config", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + "deleted config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", NotificationType.SUCCESS);
                }
                else {
                    Main.msg(ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "to delete config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", true);
                    NotificationPublisher.queue("Config", ChatFormatting.RED + "Failed " + ChatFormatting.WHITE + "to delete config: " + ChatFormatting.RED + "\"" + GuiConfig.selectedConfig.getName() + "\"", NotificationType.ERROR);
                }
            }
        }
        super.actionPerformed(lllllllllllIIlIIIIIlIIllIIIlllIl);
    }
    
    public int getWidth() {
        return this.width;
    }
    
    private boolean isHoveredConfig(final int lllllllllllIIlIIIIIlIIllIIIlIIll, final int lllllllllllIIlIIIIIlIIllIIIIllII, final int lllllllllllIIlIIIIIlIIllIIIIlIll, final int lllllllllllIIlIIIIIlIIllIIIIlIlI, final int lllllllllllIIlIIIIIlIIllIIIIllll, final int lllllllllllIIlIIIIIlIIllIIIIlllI) {
        return MouseHelper.isHovered(lllllllllllIIlIIIIIlIIllIIIlIIll, lllllllllllIIlIIIIIlIIllIIIIllII, lllllllllllIIlIIIIIlIIllIIIlIIll + lllllllllllIIlIIIIIlIIllIIIIlIll, lllllllllllIIlIIIIIlIIllIIIIllII + lllllllllllIIlIIIIIlIIllIIIIlIlI, lllllllllllIIlIIIIIlIIllIIIIllll, lllllllllllIIlIIIIIlIIllIIIIlllI);
    }
    
    @Override
    public void onGuiClosed() {
        this.screenHelper.interpolate((float)this.width, (float)this.height, 2.0 * Minecraft.frameTime / 6.0);
        GuiConfig.selectedConfig = null;
        this.mc.entityRenderer.theShaderGroup = null;
        super.onGuiClosed();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIIlIIIIIlIIlIlIllllIl, final int lllllllllllIIlIIIIIlIIlIlIllllII, final int lllllllllllIIlIIIIIlIIlIlIllllll) throws IOException {
        GuiConfig.search.mouseClicked(lllllllllllIIlIIIIIlIIlIlIllllIl, lllllllllllIIlIIIIIlIIlIlIllllII, lllllllllllIIlIIIIIlIIlIlIllllll);
        if (this.scrollOffset < 0.0f) {
            this.scrollOffset = 0.0f;
        }
        super.mouseClicked(lllllllllllIIlIIIIIlIIlIlIllllIl, lllllllllllIIlIIIIIlIIlIlIllllII, lllllllllllIIlIIIIIlIIlIlIllllll);
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllIIlIIIIIlIIlIllIIlIIl, final int lllllllllllIIlIIIIIlIIlIllIIllII, final int lllllllllllIIlIIIIIlIIlIllIIlIll) {
        super.mouseReleased(lllllllllllIIlIIIIIlIIlIllIIlIIl, lllllllllllIIlIIIIIlIIlIllIIllII, lllllllllllIIlIIIIIlIIlIllIIlIll);
    }
    
    public int getHeight() {
        return this.height;
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIlIIIIIlIIlIlIlIllll, final int lllllllllllIIlIIIIIlIIlIlIllIIll) throws IOException {
        for (final Config lllllllllllIIlIIIIIlIIlIlIllIIlI : Main.instance.configManager.getContents()) {
            if (lllllllllllIIlIIIIIlIIlIlIllIIlI != null) {
                if (lllllllllllIIlIIIIIlIIlIlIllIIll == 200) {
                    this.scrollOffset += 13.0f;
                }
                else if (lllllllllllIIlIIIIIlIIlIlIllIIll == 208) {
                    this.scrollOffset -= 13.0f;
                }
                if (this.scrollOffset >= 0.0f) {
                    continue;
                }
                this.scrollOffset = 0.0f;
            }
        }
        GuiConfig.search.textboxKeyTyped(lllllllllllIIlIIIIIlIIlIlIlIllll, lllllllllllIIlIIIIIlIIlIlIllIIll);
        GuiConfig.search.setText(GuiConfig.search.getText().replace(" ", ""));
        if ((lllllllllllIIlIIIIIlIIlIlIlIllll == '\t' || lllllllllllIIlIIIIIlIIlIlIlIllll == '\r') && GuiConfig.search.isFocused()) {
            GuiConfig.search.setFocused(!GuiConfig.search.isFocused());
        }
        try {
            super.keyTyped(lllllllllllIIlIIIIIlIIlIlIlIllll, lllllllllllIIlIIIIIlIIlIlIllIIll);
        }
        catch (IOException lllllllllllIIlIIIIIlIIlIlIllIIIl) {
            lllllllllllIIlIIIIIlIIlIlIllIIIl.printStackTrace();
        }
        super.keyTyped(lllllllllllIIlIIIIIlIIlIlIlIllll, lllllllllllIIlIIIIIlIIlIlIllIIll);
    }
    
    public void setWidth(final int lllllllllllIIlIIIIIlIIlIlIlIIIII) {
        this.width = lllllllllllIIlIIIIIlIIlIlIlIIIII;
    }
    
    static {
        GuiConfig.selectedConfig = null;
    }
    
    @Override
    public void initGui() {
        if (ClickGUI.blur.getBoolValue()) {
            this.mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        }
        final ScaledResolution lllllllllllIIlIIIIIlIIllIIIIIlII = new ScaledResolution(this.mc);
        this.screenHelper = new ScreenHelper(0.0f, 0.0f);
        this.width = lllllllllllIIlIIIIIlIIllIIIIIlII.getScaledWidth() / 2;
        this.width2 = lllllllllllIIlIIIIIlIIllIIIIIlII.getScaledWidth();
        this.height = lllllllllllIIlIIIIIlIIllIIIIIlII.getScaledHeight() / 2 + 50;
        GuiConfig.search = new GuiTextField(228, Minecraft.fontRendererObj, this.width - 125, this.height - 133, 250, 13);
        this.buttonList.add(new ConfigGuiButton(1, this.width - 25, this.height - 95, "Create"));
        this.buttonList.add(new ConfigGuiButton(2, this.width - 91, this.height - 115, "Load"));
        this.buttonList.add(new ConfigGuiButton(3, this.width - 61, this.height - 115, "Save"));
        this.buttonList.add(new ConfigGuiButton(4, this.width - 25, this.height - 115, "Delete"));
        this.imageButtons.clear();
        super.initGui();
    }
    
    public void setHeight(final int lllllllllllIIlIIIIIlIIlIlIIlIlll) {
        this.height = lllllllllllIIlIIIIIlIIlIlIIlIlll;
    }
    
    public GuiConfig() {
        this.imageButtons = new ArrayList<ImageButton>();
        this.idinahyi = new ParticleEngine();
        this.screenHelper = new ScreenHelper(0.0f, 0.0f);
    }
}
