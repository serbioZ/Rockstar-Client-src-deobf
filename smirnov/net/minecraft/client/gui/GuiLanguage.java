// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import java.util.List;
import net.minecraft.client.resources.Language;
import java.util.Map;
import java.io.IOException;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.settings.GameSettings;

public class GuiLanguage extends GuiScreen
{
    private /* synthetic */ GuiOptionButton confirmSettingsBtn;
    private /* synthetic */ GuiOptionButton forceUnicodeFontBtn;
    private final /* synthetic */ GameSettings game_settings_3;
    private final /* synthetic */ LanguageManager languageManager;
    private /* synthetic */ List list;
    protected /* synthetic */ GuiScreen parentScreen;
    
    @Override
    public void initGui() {
        this.forceUnicodeFontBtn = this.addButton(new GuiOptionButton(100, this.width / 2 - 155, this.height - 38, GameSettings.Options.FORCE_UNICODE_FONT, this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT)));
        this.confirmSettingsBtn = this.addButton(new GuiOptionButton(6, this.width / 2 - 155 + 160, this.height - 38, I18n.format("gui.done", new Object[0])));
        this.list = new List(this.mc);
        this.list.registerScrollButtons(7, 8);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllIllllIIlllllllllIlllll) throws IOException {
        if (llllllllllIllllIIlllllllllIlllll.enabled) {
            switch (llllllllllIllllIIlllllllllIlllll.id) {
                case 5: {
                    break;
                }
                case 6: {
                    this.mc.displayGuiScreen(this.parentScreen);
                    break;
                }
                case 100: {
                    if (llllllllllIllllIIlllllllllIlllll instanceof GuiOptionButton) {
                        this.game_settings_3.setOptionValue(((GuiOptionButton)llllllllllIllllIIlllllllllIlllll).returnEnumOptions(), 1);
                        llllllllllIllllIIlllllllllIlllll.displayString = this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
                        final ScaledResolution llllllllllIllllIIllllllllllIIIll = new ScaledResolution(this.mc);
                        final int llllllllllIllllIIllllllllllIIIlI = llllllllllIllllIIllllllllllIIIll.getScaledWidth();
                        final int llllllllllIllllIIllllllllllIIIIl = llllllllllIllllIIllllllllllIIIll.getScaledHeight();
                        this.setWorldAndResolution(this.mc, llllllllllIllllIIllllllllllIIIlI, llllllllllIllllIIllllllllllIIIIl);
                        break;
                    }
                    break;
                }
                default: {
                    this.list.actionPerformed(llllllllllIllllIIlllllllllIlllll);
                    break;
                }
            }
        }
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    public GuiLanguage(final GuiScreen llllllllllIllllIIlllllllllllIlll, final GameSettings llllllllllIllllIIlllllllllllIIlI, final LanguageManager llllllllllIllllIIlllllllllllIlIl) {
        this.parentScreen = llllllllllIllllIIlllllllllllIlll;
        this.game_settings_3 = llllllllllIllllIIlllllllllllIIlI;
        this.languageManager = llllllllllIllllIIlllllllllllIlIl;
    }
    
    @Override
    public void drawScreen(final int llllllllllIllllIIlllllllllIlIllI, final int llllllllllIllllIIlllllllllIlIIIl, final float llllllllllIllllIIlllllllllIlIIII) {
        this.list.drawScreen(llllllllllIllllIIlllllllllIlIllI, llllllllllIllllIIlllllllllIlIIIl, llllllllllIllllIIlllllllllIlIIII);
        this.drawCenteredString(this.fontRendererObj, I18n.format("options.language", new Object[0]), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRendererObj, "(" + I18n.format("options.languageWarning", new Object[0]) + ")", this.width / 2, this.height - 56, 8421504);
        super.drawScreen(llllllllllIllllIIlllllllllIlIllI, llllllllllIllllIIlllllllllIlIIIl, llllllllllIllllIIlllllllllIlIIII);
    }
    
    class List extends GuiSlot
    {
        private final /* synthetic */ Map<String, Language> languageMap;
        private final /* synthetic */ java.util.List<String> langCodeList;
        
        @Override
        protected void elementClicked(final int lllllllllllIlllIlIIIlIIIllllllll, final boolean lllllllllllIlllIlIIIlIIlIIIIIlII, final int lllllllllllIlllIlIIIlIIlIIIIIIll, final int lllllllllllIlllIlIIIlIIlIIIIIIlI) {
            final Language lllllllllllIlllIlIIIlIIlIIIIIIIl = this.languageMap.get(this.langCodeList.get(lllllllllllIlllIlIIIlIIIllllllll));
            GuiLanguage.this.languageManager.setCurrentLanguage(lllllllllllIlllIlIIIlIIlIIIIIIIl);
            GuiLanguage.this.game_settings_3.language = lllllllllllIlllIlIIIlIIlIIIIIIIl.getLanguageCode();
            this.mc.refreshResources();
            GuiLanguage.this.fontRendererObj.setUnicodeFlag(GuiLanguage.this.languageManager.isCurrentLocaleUnicode() || GuiLanguage.this.game_settings_3.forceUnicodeFont);
            GuiLanguage.this.fontRendererObj.setBidiFlag(GuiLanguage.this.languageManager.isCurrentLanguageBidirectional());
            GuiLanguage.this.confirmSettingsBtn.displayString = I18n.format("gui.done", new Object[0]);
            GuiLanguage.this.forceUnicodeFontBtn.displayString = GuiLanguage.this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
            GuiLanguage.this.game_settings_3.saveOptions();
        }
        
        @Override
        protected int getSize() {
            return this.langCodeList.size();
        }
        
        @Override
        protected void drawBackground() {
            GuiLanguage.this.drawDefaultBackground();
        }
        
        @Override
        protected boolean isSelected(final int lllllllllllIlllIlIIIlIIIlllllIII) {
            return this.langCodeList.get(lllllllllllIlllIlIIIlIIIlllllIII).equals(GuiLanguage.this.languageManager.getCurrentLanguage().getLanguageCode());
        }
        
        public List(final Minecraft lllllllllllIlllIlIIIlIIlIIIIllll) {
            super(lllllllllllIlllIlIIIlIIlIIIIllll, GuiLanguage.this.width, GuiLanguage.this.height, 32, GuiLanguage.this.height - 65 + 4, 18);
            this.langCodeList = (java.util.List<String>)Lists.newArrayList();
            this.languageMap = (Map<String, Language>)Maps.newHashMap();
            for (final Language lllllllllllIlllIlIIIlIIlIIIlIIlI : GuiLanguage.this.languageManager.getLanguages()) {
                this.languageMap.put(lllllllllllIlllIlIIIlIIlIIIlIIlI.getLanguageCode(), lllllllllllIlllIlIIIlIIlIIIlIIlI);
                this.langCodeList.add(lllllllllllIlllIlIIIlIIlIIIlIIlI.getLanguageCode());
            }
        }
        
        @Override
        protected void func_192637_a(final int lllllllllllIlllIlIIIlIIIlllIllIl, final int lllllllllllIlllIlIIIlIIIlllIllII, final int lllllllllllIlllIlIIIlIIIlllIlIll, final int lllllllllllIlllIlIIIlIIIlllIlIlI, final int lllllllllllIlllIlIIIlIIIlllIlIIl, final int lllllllllllIlllIlIIIlIIIlllIlIII, final float lllllllllllIlllIlIIIlIIIlllIIlll) {
            GuiLanguage.this.fontRendererObj.setBidiFlag(true);
            GuiLanguage.this.drawCenteredString(GuiLanguage.this.fontRendererObj, this.languageMap.get(this.langCodeList.get(lllllllllllIlllIlIIIlIIIlllIllIl)).toString(), this.width / 2, lllllllllllIlllIlIIIlIIIlllIlIll + 1, 16777215);
            GuiLanguage.this.fontRendererObj.setBidiFlag(GuiLanguage.this.languageManager.getCurrentLanguage().isBidirectional());
        }
        
        @Override
        protected int getContentHeight() {
            return this.getSize() * 18;
        }
    }
}
