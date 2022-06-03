// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import optifine.GuiOptionButtonOF;
import optifine.GuiOptionSliderOF;
import net.minecraft.client.resources.I18n;
import shadersmod.client.GuiShaders;
import optifine.Lang;
import optifine.GuiOtherSettingsOF;
import optifine.GuiPerformanceSettingsOF;
import optifine.GuiAnimationSettingsOF;
import optifine.GuiQualitySettingsOF;
import optifine.GuiDetailSettingsOF;
import optifine.Config;
import java.io.IOException;
import optifine.TooltipManager;
import net.minecraft.client.settings.GameSettings;
import optifine.GuiScreenOF;

public class GuiVideoSettings extends GuiScreenOF
{
    private /* synthetic */ GameSettings guiGameSettings;
    private static /* synthetic */ GameSettings.Options[] videoOptions;
    private /* synthetic */ TooltipManager tooltipManager;
    private /* synthetic */ GuiScreen parentGuiScreen;
    protected /* synthetic */ String screenTitle;
    
    static {
        __OBFID = "CL_00000718";
        GuiVideoSettings.videoOptions = new GameSettings.Options[] { GameSettings.Options.GRAPHICS, GameSettings.Options.RENDER_DISTANCE, GameSettings.Options.AMBIENT_OCCLUSION, GameSettings.Options.FRAMERATE_LIMIT, GameSettings.Options.AO_LEVEL, GameSettings.Options.VIEW_BOBBING, GameSettings.Options.GUI_SCALE, GameSettings.Options.USE_VBO, GameSettings.Options.GAMMA, GameSettings.Options.ATTACK_INDICATOR, GameSettings.Options.DYNAMIC_LIGHTS, GameSettings.Options.DYNAMIC_FOV };
    }
    
    public static void drawGradientRect(final GuiScreen llllllllllIlllIlIIIIlllIlIllIlIl, final int llllllllllIlllIlIIIIlllIlIllIlII, final int llllllllllIlllIlIIIIlllIlIlIllII, final int llllllllllIlllIlIIIIlllIlIllIIlI, final int llllllllllIlllIlIIIIlllIlIlIlIlI, final int llllllllllIlllIlIIIIlllIlIllIIII, final int llllllllllIlllIlIIIIlllIlIlIlIII) {
        llllllllllIlllIlIIIIlllIlIllIlIl.drawGradientRect(llllllllllIlllIlIIIIlllIlIllIlII, llllllllllIlllIlIIIIlllIlIlIllII, llllllllllIlllIlIIIIlllIlIllIIlI, llllllllllIlllIlIIIIlllIlIlIlIlI, llllllllllIlllIlIIIIlllIlIllIIII, llllllllllIlllIlIIIIlllIlIlIlIII);
    }
    
    protected void actionPerformed(final GuiButton llllllllllIlllIlIIIIlllIllllllII) throws IOException {
        this.actionPerformed(llllllllllIlllIlIIIIlllIllllllII, 1);
    }
    
    public static int getButtonWidth(final GuiButton llllllllllIlllIlIIIIlllIllIIIIII) {
        return llllllllllIlllIlIIIIlllIllIIIIII.width;
    }
    
    public static int getButtonHeight(final GuiButton llllllllllIlllIlIIIIlllIlIllllIl) {
        return llllllllllIlllIlIIIIlllIlIllllIl.height;
    }
    
    public void drawScreen(final int llllllllllIlllIlIIIIlllIllIIlIIl, final int llllllllllIlllIlIIIIlllIllIlIIII, final float llllllllllIlllIlIIIIlllIllIIIlll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 15, 16777215);
        String llllllllllIlllIlIIIIlllIllIIlllI = Config.getVersion();
        final String llllllllllIlllIlIIIIlllIllIIllIl = "HD_U";
        if (llllllllllIlllIlIIIIlllIllIIllIl.equals("HD")) {
            llllllllllIlllIlIIIIlllIllIIlllI = "OptiFine HD C6";
        }
        if (llllllllllIlllIlIIIIlllIllIIllIl.equals("HD_U")) {
            llllllllllIlllIlIIIIlllIllIIlllI = "OptiFine HD C6 Ultra";
        }
        if (llllllllllIlllIlIIIIlllIllIIllIl.equals("L")) {
            llllllllllIlllIlIIIIlllIllIIlllI = "OptiFine C6 Light";
        }
        this.drawString(this.fontRendererObj, llllllllllIlllIlIIIIlllIllIIlllI, 2, this.height - 10, 8421504);
        final String llllllllllIlllIlIIIIlllIllIIllII = "Minecraft 1.12.2";
        final int llllllllllIlllIlIIIIlllIllIIlIll = this.fontRendererObj.getStringWidth(llllllllllIlllIlIIIIlllIllIIllII);
        this.drawString(this.fontRendererObj, llllllllllIlllIlIIIIlllIllIIllII, this.width - llllllllllIlllIlIIIIlllIllIIlIll - 2, this.height - 10, 8421504);
        super.drawScreen(llllllllllIlllIlIIIIlllIllIIlIIl, llllllllllIlllIlIIIIlllIllIlIIII, llllllllllIlllIlIIIIlllIllIIIlll);
        this.tooltipManager.drawTooltips(llllllllllIlllIlIIIIlllIllIIlIIl, llllllllllIlllIlIIIIlllIllIlIIII, this.buttonList);
    }
    
    private void actionPerformed(final GuiButton llllllllllIlllIlIIIIlllIlllIllIl, final int llllllllllIlllIlIIIIlllIlllIllII) {
        if (llllllllllIlllIlIIIIlllIlllIllIl.enabled) {
            final int llllllllllIlllIlIIIIlllIlllIlIll = this.guiGameSettings.guiScale;
            if (llllllllllIlllIlIIIIlllIlllIllIl.id < 200 && llllllllllIlllIlIIIIlllIlllIllIl instanceof GuiOptionButton) {
                this.guiGameSettings.setOptionValue(((GuiOptionButton)llllllllllIlllIlIIIIlllIlllIllIl).returnEnumOptions(), llllllllllIlllIlIIIIlllIlllIllII);
                llllllllllIlllIlIIIIlllIlllIllIl.displayString = this.guiGameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(llllllllllIlllIlIIIIlllIlllIllIl.id));
            }
            if (llllllllllIlllIlIIIIlllIlllIllIl.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentGuiScreen);
            }
            if (this.guiGameSettings.guiScale != llllllllllIlllIlIIIIlllIlllIlIll) {
                final ScaledResolution llllllllllIlllIlIIIIlllIlllIlIlI = new ScaledResolution(this.mc);
                final int llllllllllIlllIlIIIIlllIlllIlIIl = llllllllllIlllIlIIIIlllIlllIlIlI.getScaledWidth();
                final int llllllllllIlllIlIIIIlllIlllIlIII = llllllllllIlllIlIIIIlllIlllIlIlI.getScaledHeight();
                this.setWorldAndResolution(this.mc, llllllllllIlllIlIIIIlllIlllIlIIl, llllllllllIlllIlIIIIlllIlllIlIII);
            }
            if (llllllllllIlllIlIIIIlllIlllIllIl.id == 201) {
                this.mc.gameSettings.saveOptions();
                final GuiDetailSettingsOF llllllllllIlllIlIIIIlllIlllIIlll = new GuiDetailSettingsOF((GuiScreen)this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)llllllllllIlllIlIIIIlllIlllIIlll);
            }
            if (llllllllllIlllIlIIIIlllIlllIllIl.id == 202) {
                this.mc.gameSettings.saveOptions();
                final GuiQualitySettingsOF llllllllllIlllIlIIIIlllIlllIIllI = new GuiQualitySettingsOF((GuiScreen)this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)llllllllllIlllIlIIIIlllIlllIIllI);
            }
            if (llllllllllIlllIlIIIIlllIlllIllIl.id == 211) {
                this.mc.gameSettings.saveOptions();
                final GuiAnimationSettingsOF llllllllllIlllIlIIIIlllIlllIIlIl = new GuiAnimationSettingsOF((GuiScreen)this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)llllllllllIlllIlIIIIlllIlllIIlIl);
            }
            if (llllllllllIlllIlIIIIlllIlllIllIl.id == 212) {
                this.mc.gameSettings.saveOptions();
                final GuiPerformanceSettingsOF llllllllllIlllIlIIIIlllIlllIIlII = new GuiPerformanceSettingsOF((GuiScreen)this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)llllllllllIlllIlIIIIlllIlllIIlII);
            }
            if (llllllllllIlllIlIIIIlllIlllIllIl.id == 222) {
                this.mc.gameSettings.saveOptions();
                final GuiOtherSettingsOF llllllllllIlllIlIIIIlllIlllIIIll = new GuiOtherSettingsOF((GuiScreen)this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)llllllllllIlllIlIIIIlllIlllIIIll);
            }
            if (llllllllllIlllIlIIIIlllIlllIllIl.id == 231) {
                if (Config.isAntialiasing() || Config.isAntialiasingConfigured()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.aa1"), Lang.get("of.message.shaders.aa2"));
                    return;
                }
                if (Config.isAnisotropicFiltering()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.af1"), Lang.get("of.message.shaders.af2"));
                    return;
                }
                if (Config.isFastRender()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.fr1"), Lang.get("of.message.shaders.fr2"));
                    return;
                }
                if (Config.getGameSettings().anaglyph) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.an1"), Lang.get("of.message.shaders.an2"));
                    return;
                }
                this.mc.gameSettings.saveOptions();
                final GuiShaders llllllllllIlllIlIIIIlllIlllIIIlI = new GuiShaders((GuiScreen)this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)llllllllllIlllIlIIIIlllIlllIIIlI);
            }
        }
    }
    
    public GuiVideoSettings(final GuiScreen llllllllllIlllIlIIIIllllIIIlIlII, final GameSettings llllllllllIlllIlIIIIllllIIIlIllI) {
        this.screenTitle = "Video Settings";
        this.tooltipManager = new TooltipManager((GuiScreen)this);
        this.parentGuiScreen = llllllllllIlllIlIIIIllllIIIlIlII;
        this.guiGameSettings = llllllllllIlllIlIIIIllllIIIlIllI;
    }
    
    protected void actionPerformedRightClick(final GuiButton llllllllllIlllIlIIIIlllIllllIllI) {
        if (llllllllllIlllIlIIIIlllIllllIllI.id == GameSettings.Options.GUI_SCALE.ordinal()) {
            this.actionPerformed(llllllllllIlllIlIIIIlllIllllIllI, -1);
        }
    }
    
    public void initGui() {
        this.screenTitle = I18n.format("options.videoTitle", new Object[0]);
        this.buttonList.clear();
        for (int llllllllllIlllIlIIIIllllIIIIllII = 0; llllllllllIlllIlIIIIllllIIIIllII < GuiVideoSettings.videoOptions.length; ++llllllllllIlllIlIIIIllllIIIIllII) {
            final GameSettings.Options llllllllllIlllIlIIIIllllIIIIlIll = GuiVideoSettings.videoOptions[llllllllllIlllIlIIIIllllIIIIllII];
            if (llllllllllIlllIlIIIIllllIIIIlIll != null) {
                final int llllllllllIlllIlIIIIllllIIIIlIlI = this.width / 2 - 155 + llllllllllIlllIlIIIIllllIIIIllII % 2 * 160;
                final int llllllllllIlllIlIIIIllllIIIIlIIl = this.height / 6 + 21 * (llllllllllIlllIlIIIIllllIIIIllII / 2) - 12;
                if (llllllllllIlllIlIIIIllllIIIIlIll.getEnumFloat()) {
                    this.buttonList.add(new GuiOptionSliderOF(llllllllllIlllIlIIIIllllIIIIlIll.returnEnumOrdinal(), llllllllllIlllIlIIIIllllIIIIlIlI, llllllllllIlllIlIIIIllllIIIIlIIl, llllllllllIlllIlIIIIllllIIIIlIll));
                }
                else {
                    this.buttonList.add(new GuiOptionButtonOF(llllllllllIlllIlIIIIllllIIIIlIll.returnEnumOrdinal(), llllllllllIlllIlIIIIllllIIIIlIlI, llllllllllIlllIlIIIIllllIIIIlIIl, llllllllllIlllIlIIIIllllIIIIlIll, this.guiGameSettings.getKeyBinding(llllllllllIlllIlIIIIllllIIIIlIll)));
                }
            }
        }
        int llllllllllIlllIlIIIIllllIIIIlIII = this.height / 6 + 21 * (GuiVideoSettings.videoOptions.length / 2) - 12;
        int llllllllllIlllIlIIIIllllIIIIIlll = 0;
        llllllllllIlllIlIIIIllllIIIIIlll = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(231, llllllllllIlllIlIIIIllllIIIIIlll, llllllllllIlllIlIIIIllllIIIIlIII, Lang.get("of.options.shaders")));
        llllllllllIlllIlIIIIllllIIIIIlll = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(202, llllllllllIlllIlIIIIllllIIIIIlll, llllllllllIlllIlIIIIllllIIIIlIII, Lang.get("of.options.quality")));
        llllllllllIlllIlIIIIllllIIIIlIII += 21;
        llllllllllIlllIlIIIIllllIIIIIlll = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(201, llllllllllIlllIlIIIIllllIIIIIlll, llllllllllIlllIlIIIIllllIIIIlIII, Lang.get("of.options.details")));
        llllllllllIlllIlIIIIllllIIIIIlll = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(212, llllllllllIlllIlIIIIllllIIIIIlll, llllllllllIlllIlIIIIllllIIIIlIII, Lang.get("of.options.performance")));
        llllllllllIlllIlIIIIllllIIIIlIII += 21;
        llllllllllIlllIlIIIIllllIIIIIlll = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(211, llllllllllIlllIlIIIIllllIIIIIlll, llllllllllIlllIlIIIIllllIIIIlIII, Lang.get("of.options.animations")));
        llllllllllIlllIlIIIIllllIIIIIlll = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(222, llllllllllIlllIlIIIIllllIIIIIlll, llllllllllIlllIlIIIIllllIIIIlIII, Lang.get("of.options.other")));
        llllllllllIlllIlIIIIllllIIIIlIII += 21;
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
}
