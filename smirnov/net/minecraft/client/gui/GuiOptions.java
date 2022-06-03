// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import java.io.IOException;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.client.settings.GameSettings;

public class GuiOptions extends GuiScreen
{
    private /* synthetic */ GuiButton difficultyButton;
    private static final /* synthetic */ GameSettings.Options[] SCREEN_OPTIONS;
    private /* synthetic */ GuiLockIconButton lockButton;
    protected /* synthetic */ String title;
    private final /* synthetic */ GameSettings settings;
    private final /* synthetic */ GuiScreen lastScreen;
    
    public String getDifficultyText(final EnumDifficulty lllllllllllIIIlIIlllIlIIIlllIllI) {
        final ITextComponent lllllllllllIIIlIIlllIlIIIlllIlll = new TextComponentString("");
        lllllllllllIIIlIIlllIlIIIlllIlll.appendSibling(new TextComponentTranslation("options.difficulty", new Object[0]));
        lllllllllllIIIlIIlllIlIIIlllIlll.appendText(": ");
        lllllllllllIIIlIIlllIlIIIlllIlll.appendSibling(new TextComponentTranslation(lllllllllllIIIlIIlllIlIIIlllIllI.getDifficultyResourceKey(), new Object[0]));
        return lllllllllllIIIlIIlllIlIIIlllIlll.getFormattedText();
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIIlIIlllIlIIIllIIlll, final int lllllllllllIIIlIIlllIlIIIllIIllI) throws IOException {
        if (lllllllllllIIIlIIlllIlIIIllIIllI == 1) {
            this.mc.gameSettings.saveOptions();
        }
        super.keyTyped(lllllllllllIIIlIIlllIlIIIllIIlll, lllllllllllIIIlIIlllIlIIIllIIllI);
    }
    
    public GuiOptions(final GuiScreen lllllllllllIIIlIIlllIlIIlIIlIIll, final GameSettings lllllllllllIIIlIIlllIlIIlIIlIIlI) {
        this.title = "Options";
        this.lastScreen = lllllllllllIIIlIIlllIlIIlIIlIIll;
        this.settings = lllllllllllIIIlIIlllIlIIlIIlIIlI;
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIIlIIlllIlIIIlIlIlII, final int lllllllllllIIIlIIlllIlIIIlIIllll, final float lllllllllllIIIlIIlllIlIIIlIIlllI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(lllllllllllIIIlIIlllIlIIIlIlIlII, lllllllllllIIIlIIlllIlIIIlIIllll, lllllllllllIIIlIIlllIlIIIlIIlllI);
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("options.title", new Object[0]);
        int lllllllllllIIIlIIlllIlIIlIIIIllI = 0;
        boolean lllllllllllIIIlIIlllIlIIIlllllIl;
        for (String lllllllllllIIIlIIlllIlIIIllllllI = (String)((GameSettings.Options[])(Object)(lllllllllllIIIlIIlllIlIIIlllllIl = (boolean)(Object)GuiOptions.SCREEN_OPTIONS)).length, lllllllllllIIIlIIlllIlIIIlllllll = (String)0; lllllllllllIIIlIIlllIlIIIlllllll < lllllllllllIIIlIIlllIlIIIllllllI; ++lllllllllllIIIlIIlllIlIIIlllllll) {
            final GameSettings.Options lllllllllllIIIlIIlllIlIIlIIIIlIl = lllllllllllIIIlIIlllIlIIIlllllIl[lllllllllllIIIlIIlllIlIIIlllllll];
            if (lllllllllllIIIlIIlllIlIIlIIIIlIl.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(lllllllllllIIIlIIlllIlIIlIIIIlIl.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllIIIlIIlllIlIIlIIIIllI % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllIIIlIIlllIlIIlIIIIllI >> 1), lllllllllllIIIlIIlllIlIIlIIIIlIl));
            }
            else {
                final GuiOptionButton lllllllllllIIIlIIlllIlIIlIIIIlII = new GuiOptionButton(lllllllllllIIIlIIlllIlIIlIIIIlIl.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllIIIlIIlllIlIIlIIIIllI % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllIIIlIIlllIlIIlIIIIllI >> 1), lllllllllllIIIlIIlllIlIIlIIIIlIl, this.settings.getKeyBinding(lllllllllllIIIlIIlllIlIIlIIIIlIl));
                this.buttonList.add(lllllllllllIIIlIIlllIlIIlIIIIlII);
            }
            ++lllllllllllIIIlIIlllIlIIlIIIIllI;
        }
        if (this.mc.world != null) {
            final EnumDifficulty lllllllllllIIIlIIlllIlIIlIIIIIll = this.mc.world.getDifficulty();
            this.difficultyButton = new GuiButton(108, this.width / 2 - 155 + lllllllllllIIIlIIlllIlIIlIIIIllI % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllIIIlIIlllIlIIlIIIIllI >> 1), 150, 20, this.getDifficultyText(lllllllllllIIIlIIlllIlIIlIIIIIll));
            this.buttonList.add(this.difficultyButton);
            if (this.mc.isSingleplayer() && !this.mc.world.getWorldInfo().isHardcoreModeEnabled()) {
                this.difficultyButton.setWidth(this.difficultyButton.getButtonWidth() - 20);
                this.lockButton = new GuiLockIconButton(109, this.difficultyButton.xPosition + this.difficultyButton.getButtonWidth(), this.difficultyButton.yPosition);
                this.buttonList.add(this.lockButton);
                this.lockButton.setLocked(this.mc.world.getWorldInfo().isDifficultyLocked());
                this.lockButton.enabled = !this.lockButton.isLocked();
                this.difficultyButton.enabled = !this.lockButton.isLocked();
            }
            else {
                this.difficultyButton.enabled = false;
            }
        }
        else {
            this.buttonList.add(new GuiOptionButton(GameSettings.Options.REALMS_NOTIFICATIONS.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllIIIlIIlllIlIIlIIIIllI % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllIIIlIIlllIlIIlIIIIllI >> 1), GameSettings.Options.REALMS_NOTIFICATIONS, this.settings.getKeyBinding(GameSettings.Options.REALMS_NOTIFICATIONS)));
        }
        this.buttonList.add(new GuiButton(110, this.width / 2 - 155, this.height / 6 + 48 - 6, 150, 20, I18n.format("options.skinCustomisation", new Object[0])));
        this.buttonList.add(new GuiButton(106, this.width / 2 + 5, this.height / 6 + 48 - 6, 150, 20, I18n.format("options.sounds", new Object[0])));
        this.buttonList.add(new GuiButton(101, this.width / 2 - 155, this.height / 6 + 72 - 6, 150, 20, I18n.format("options.video", new Object[0])));
        this.buttonList.add(new GuiButton(100, this.width / 2 + 5, this.height / 6 + 72 - 6, 150, 20, I18n.format("options.controls", new Object[0])));
        this.buttonList.add(new GuiButton(102, this.width / 2 - 155, this.height / 6 + 96 - 6, 150, 20, I18n.format("options.language", new Object[0])));
        this.buttonList.add(new GuiButton(103, this.width / 2 + 5, this.height / 6 + 96 - 6, 150, 20, I18n.format("options.chat.title", new Object[0])));
        this.buttonList.add(new GuiButton(105, this.width / 2 - 155, this.height / 6 + 120 - 6, 150, 20, I18n.format("options.resourcepack", new Object[0])));
        this.buttonList.add(new GuiButton(104, this.width / 2 + 5, this.height / 6 + 120 - 6, 150, 20, I18n.format("options.snooper.view", new Object[0])));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIIlIIlllIlIIIlIllllI) throws IOException {
        if (lllllllllllIIIlIIlllIlIIIlIllllI.enabled) {
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id < 100 && lllllllllllIIIlIIlllIlIIIlIllllI instanceof GuiOptionButton) {
                final GameSettings.Options lllllllllllIIIlIIlllIlIIIlIlllIl = ((GuiOptionButton)lllllllllllIIIlIIlllIlIIIlIllllI).returnEnumOptions();
                this.settings.setOptionValue(lllllllllllIIIlIIlllIlIIIlIlllIl, 1);
                lllllllllllIIIlIIlllIlIIIlIllllI.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllIIIlIIlllIlIIIlIllllI.id));
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 108) {
                this.mc.world.getWorldInfo().setDifficulty(EnumDifficulty.getDifficultyEnum(this.mc.world.getDifficulty().getDifficultyId() + 1));
                this.difficultyButton.displayString = this.getDifficultyText(this.mc.world.getDifficulty());
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 109) {
                this.mc.displayGuiScreen(new GuiYesNo(this, new TextComponentTranslation("difficulty.lock.title", new Object[0]).getFormattedText(), new TextComponentTranslation("difficulty.lock.question", new Object[] { new TextComponentTranslation(this.mc.world.getWorldInfo().getDifficulty().getDifficultyResourceKey(), new Object[0]) }).getFormattedText(), 109));
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 110) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiCustomizeSkin(this));
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 101) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen((GuiScreen)new GuiVideoSettings(this, this.settings));
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 100) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiControls(this, this.settings));
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 102) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiLanguage(this, this.settings, this.mc.getLanguageManager()));
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 103) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new ScreenChatOptions(this, this.settings));
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 104) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiSnooper(this, this.settings));
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.lastScreen);
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 105) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiScreenResourcePacks(this));
            }
            if (lllllllllllIIIlIIlllIlIIIlIllllI.id == 106) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiScreenOptionsSounds(this, this.settings));
            }
        }
    }
    
    @Override
    public void confirmClicked(final boolean lllllllllllIIIlIIlllIlIIIlllIIII, final int lllllllllllIIIlIIlllIlIIIllIllII) {
        this.mc.displayGuiScreen(this);
        if (lllllllllllIIIlIIlllIlIIIllIllII == 109 && lllllllllllIIIlIIlllIlIIIlllIIII && this.mc.world != null) {
            this.mc.world.getWorldInfo().setDifficultyLocked(true);
            this.lockButton.setLocked(true);
            this.lockButton.enabled = false;
            this.difficultyButton.enabled = false;
        }
    }
    
    static {
        SCREEN_OPTIONS = new GameSettings.Options[] { GameSettings.Options.FOV };
    }
}
