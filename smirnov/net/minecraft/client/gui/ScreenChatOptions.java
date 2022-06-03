// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.resources.I18n;
import java.io.IOException;
import net.minecraft.client.settings.GameSettings;

public class ScreenChatOptions extends GuiScreen
{
    private final /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ GuiOptionButton field_193025_i;
    private static final /* synthetic */ GameSettings.Options[] CHAT_OPTIONS;
    private /* synthetic */ String chatTitle;
    private final /* synthetic */ GameSettings game_settings;
    
    @Override
    protected void keyTyped(final char lllllllllllIIIlIlIlIIlIIIIllIIIl, final int lllllllllllIIIlIlIlIIlIIIIllIIII) throws IOException {
        if (lllllllllllIIIlIlIlIIlIIIIllIIII == 1) {
            this.mc.gameSettings.saveOptions();
        }
        super.keyTyped(lllllllllllIIIlIlIlIIlIIIIllIIIl, lllllllllllIIIlIlIlIIlIIIIllIIII);
    }
    
    public void func_193024_a() {
        this.field_193025_i.displayString = this.game_settings.getKeyBinding(GameSettings.Options.getEnumOptions(this.field_193025_i.id));
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIIlIlIlIIlIIIIlIIIIl, final int lllllllllllIIIlIlIlIIlIIIIIlllII, final float lllllllllllIIIlIlIlIIlIIIIIlllll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.chatTitle, this.width / 2, 20, 16777215);
        super.drawScreen(lllllllllllIIIlIlIlIIlIIIIlIIIIl, lllllllllllIIIlIlIlIIlIIIIIlllII, lllllllllllIIIlIlIlIIlIIIIIlllll);
    }
    
    @Override
    public void initGui() {
        this.chatTitle = I18n.format("options.chat.title", new Object[0]);
        int lllllllllllIIIlIlIlIIlIIIIllllll = 0;
        final boolean lllllllllllIIIlIlIlIIlIIIIllIlll;
        final int lllllllllllIIIlIlIlIIlIIIIlllIII = ((GameSettings.Options[])(Object)(lllllllllllIIIlIlIlIIlIIIIllIlll = (boolean)(Object)ScreenChatOptions.CHAT_OPTIONS)).length;
        for (short lllllllllllIIIlIlIlIIlIIIIlllIIl = 0; lllllllllllIIIlIlIlIIlIIIIlllIIl < lllllllllllIIIlIlIlIIlIIIIlllIII; ++lllllllllllIIIlIlIlIIlIIIIlllIIl) {
            final GameSettings.Options lllllllllllIIIlIlIlIIlIIIIlllllI = lllllllllllIIIlIlIlIIlIIIIllIlll[lllllllllllIIIlIlIlIIlIIIIlllIIl];
            if (lllllllllllIIIlIlIlIIlIIIIlllllI.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(lllllllllllIIIlIlIlIIlIIIIlllllI.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllIIIlIlIlIIlIIIIllllll % 2 * 160, this.height / 6 + 24 * (lllllllllllIIIlIlIlIIlIIIIllllll >> 1), lllllllllllIIIlIlIlIIlIIIIlllllI));
            }
            else {
                final GuiOptionButton lllllllllllIIIlIlIlIIlIIIIllllIl = new GuiOptionButton(lllllllllllIIIlIlIlIIlIIIIlllllI.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllIIIlIlIlIIlIIIIllllll % 2 * 160, this.height / 6 + 24 * (lllllllllllIIIlIlIlIIlIIIIllllll >> 1), lllllllllllIIIlIlIlIIlIIIIlllllI, this.game_settings.getKeyBinding(lllllllllllIIIlIlIlIIlIIIIlllllI));
                this.buttonList.add(lllllllllllIIIlIlIlIIlIIIIllllIl);
                if (lllllllllllIIIlIlIlIIlIIIIlllllI == GameSettings.Options.NARRATOR) {
                    this.field_193025_i = lllllllllllIIIlIlIlIIlIIIIllllIl;
                    lllllllllllIIIlIlIlIIlIIIIllllIl.enabled = NarratorChatListener.field_193643_a.func_193640_a();
                }
            }
            ++lllllllllllIIIlIlIlIIlIIIIllllll;
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 144, I18n.format("gui.done", new Object[0])));
    }
    
    public ScreenChatOptions(final GuiScreen lllllllllllIIIlIlIlIIlIIIlIIlIIl, final GameSettings lllllllllllIIIlIlIlIIlIIIlIIlIII) {
        this.parentScreen = lllllllllllIIIlIlIlIIlIIIlIIlIIl;
        this.game_settings = lllllllllllIIIlIlIlIIlIIIlIIlIII;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIIlIlIlIIlIIIIlIlIIl) throws IOException {
        if (lllllllllllIIIlIlIlIIlIIIIlIlIIl.enabled) {
            if (lllllllllllIIIlIlIlIIlIIIIlIlIIl.id < 100 && lllllllllllIIIlIlIlIIlIIIIlIlIIl instanceof GuiOptionButton) {
                this.game_settings.setOptionValue(((GuiOptionButton)lllllllllllIIIlIlIlIIlIIIIlIlIIl).returnEnumOptions(), 1);
                lllllllllllIIIlIlIlIIlIIIIlIlIIl.displayString = this.game_settings.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllIIIlIlIlIIlIIIIlIlIIl.id));
            }
            if (lllllllllllIIIlIlIlIIlIIIIlIlIIl.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentScreen);
            }
        }
    }
    
    static {
        CHAT_OPTIONS = new GameSettings.Options[] { GameSettings.Options.CHAT_VISIBILITY, GameSettings.Options.CHAT_COLOR, GameSettings.Options.CHAT_LINKS, GameSettings.Options.CHAT_OPACITY, GameSettings.Options.CHAT_LINKS_PROMPT, GameSettings.Options.CHAT_SCALE, GameSettings.Options.CHAT_HEIGHT_FOCUSED, GameSettings.Options.CHAT_HEIGHT_UNFOCUSED, GameSettings.Options.CHAT_WIDTH, GameSettings.Options.REDUCED_DEBUG_INFO, GameSettings.Options.NARRATOR };
    }
}
