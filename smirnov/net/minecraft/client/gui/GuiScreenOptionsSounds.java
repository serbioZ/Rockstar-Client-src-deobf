// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.SoundCategory;
import java.io.IOException;
import net.minecraft.client.settings.GameSettings;

public class GuiScreenOptionsSounds extends GuiScreen
{
    private /* synthetic */ String offDisplayString;
    private final /* synthetic */ GameSettings game_settings_4;
    protected /* synthetic */ String title;
    private final /* synthetic */ GuiScreen parent;
    
    @Override
    public void drawScreen(final int lllllllllllIIllIIIlIIIllIIIllIlI, final int lllllllllllIIllIIIlIIIllIIIlIlIl, final float lllllllllllIIllIIIlIIIllIIIlIlII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(lllllllllllIIllIIIlIIIllIIIllIlI, lllllllllllIIllIIIlIIIllIIIlIlIl, lllllllllllIIllIIIlIIIllIIIlIlII);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIllIIIlIIIllIIlIlIlI, final int lllllllllllIIllIIIlIIIllIIlIlIIl) throws IOException {
        if (lllllllllllIIllIIIlIIIllIIlIlIIl == 1) {
            this.mc.gameSettings.saveOptions();
        }
        super.keyTyped(lllllllllllIIllIIIlIIIllIIlIlIlI, lllllllllllIIllIIIlIIIllIIlIlIIl);
    }
    
    protected String getDisplayString(final SoundCategory lllllllllllIIllIIIlIIIllIIIIllII) {
        final float lllllllllllIIllIIIlIIIllIIIIlllI = this.game_settings_4.getSoundLevel(lllllllllllIIllIIIlIIIllIIIIllII);
        return (lllllllllllIIllIIIlIIIllIIIIlllI == 0.0f) ? this.offDisplayString : (String.valueOf((int)(lllllllllllIIllIIIlIIIllIIIIlllI * 100.0f)) + "%");
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIllIIIlIIIllIIlIIIII) throws IOException {
        if (lllllllllllIIllIIIlIIIllIIlIIIII.enabled) {
            if (lllllllllllIIllIIIlIIIllIIlIIIII.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parent);
            }
            else if (lllllllllllIIllIIIlIIIllIIlIIIII.id == 201) {
                this.mc.gameSettings.setOptionValue(GameSettings.Options.SHOW_SUBTITLES, 1);
                lllllllllllIIllIIIlIIIllIIlIIIII.displayString = this.mc.gameSettings.getKeyBinding(GameSettings.Options.SHOW_SUBTITLES);
                this.mc.gameSettings.saveOptions();
            }
        }
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("options.sounds.title", new Object[0]);
        this.offDisplayString = I18n.format("options.off", new Object[0]);
        int lllllllllllIIllIIIlIIIllIIlllIII = 0;
        this.buttonList.add(new Button(SoundCategory.MASTER.ordinal(), this.width / 2 - 155 + lllllllllllIIllIIIlIIIllIIlllIII % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllIIllIIIlIIIllIIlllIII >> 1), SoundCategory.MASTER, true));
        lllllllllllIIllIIIlIIIllIIlllIII += 2;
        final int lllllllllllIIllIIIlIIIllIIlIllll;
        final short lllllllllllIIllIIIlIIIllIIllIIII = (short)((SoundCategory[])(Object)(lllllllllllIIllIIIlIIIllIIlIllll = (int)(Object)SoundCategory.values())).length;
        for (float lllllllllllIIllIIIlIIIllIIllIIIl = 0; lllllllllllIIllIIIlIIIllIIllIIIl < lllllllllllIIllIIIlIIIllIIllIIII; ++lllllllllllIIllIIIlIIIllIIllIIIl) {
            final SoundCategory lllllllllllIIllIIIlIIIllIIllIlll = lllllllllllIIllIIIlIIIllIIlIllll[lllllllllllIIllIIIlIIIllIIllIIIl];
            if (lllllllllllIIllIIIlIIIllIIllIlll != SoundCategory.MASTER) {
                this.buttonList.add(new Button(lllllllllllIIllIIIlIIIllIIllIlll.ordinal(), this.width / 2 - 155 + lllllllllllIIllIIIlIIIllIIlllIII % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllIIllIIIlIIIllIIlllIII >> 1), lllllllllllIIllIIIlIIIllIIllIlll, false));
                ++lllllllllllIIllIIIlIIIllIIlllIII;
            }
        }
        final int lllllllllllIIllIIIlIIIllIIllIllI = this.width / 2 - 75;
        final int lllllllllllIIllIIIlIIIllIIllIlIl = this.height / 6 - 12;
        ++lllllllllllIIllIIIlIIIllIIlllIII;
        this.buttonList.add(new GuiOptionButton(201, lllllllllllIIllIIIlIIIllIIllIllI, lllllllllllIIllIIIlIIIllIIllIlIl + 24 * (lllllllllllIIllIIIlIIIllIIlllIII >> 1), GameSettings.Options.SHOW_SUBTITLES, this.game_settings_4.getKeyBinding(GameSettings.Options.SHOW_SUBTITLES)));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
    }
    
    public GuiScreenOptionsSounds(final GuiScreen lllllllllllIIllIIIlIIIllIlIIIIIl, final GameSettings lllllllllllIIllIIIlIIIllIlIIIIll) {
        this.title = "Options";
        this.parent = lllllllllllIIllIIIlIIIllIlIIIIIl;
        this.game_settings_4 = lllllllllllIIllIIIlIIIllIlIIIIll;
    }
    
    class Button extends GuiButton
    {
        private final /* synthetic */ String categoryName;
        public /* synthetic */ boolean pressed;
        public /* synthetic */ float volume;
        private final /* synthetic */ SoundCategory category;
        
        @Override
        protected void mouseDragged(final Minecraft lllllllllllllIlIllIlllIIllIlIlll, final int lllllllllllllIlIllIlllIIllIlIllI, final int lllllllllllllIlIllIlllIIllIlIlIl) {
            if (this.visible) {
                if (this.pressed) {
                    this.volume = (lllllllllllllIlIllIlllIIllIlIllI - (this.xPosition + 4)) / (float)(this.width - 8);
                    this.volume = MathHelper.clamp(this.volume, 0.0f, 1.0f);
                    lllllllllllllIlIllIlllIIllIlIlll.gameSettings.setSoundLevel(this.category, this.volume);
                    lllllllllllllIlIllIlllIIllIlIlll.gameSettings.saveOptions();
                    this.displayString = String.valueOf(this.categoryName) + ": " + GuiScreenOptionsSounds.this.getDisplayString(this.category);
                }
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.drawTexturedModalRect(this.xPosition + (int)(this.volume * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
                this.drawTexturedModalRect(this.xPosition + (int)(this.volume * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
            }
        }
        
        @Override
        public void mouseReleased(final int lllllllllllllIlIllIlllIIllIIIIIl, final int lllllllllllllIlIllIlllIIllIIIIII) {
            if (this.pressed) {
                GuiScreenOptionsSounds.this.mc.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            }
            this.pressed = false;
        }
        
        public Button(final int lllllllllllllIlIllIlllIIlllIIIlI, final int lllllllllllllIlIllIlllIIlllIIIIl, final int lllllllllllllIlIllIlllIIlllIIlll, final SoundCategory lllllllllllllIlIllIlllIIllIlllll, final boolean lllllllllllllIlIllIlllIIllIllllI) {
            super(lllllllllllllIlIllIlllIIlllIIIlI, lllllllllllllIlIllIlllIIlllIIIIl, lllllllllllllIlIllIlllIIlllIIlll, lllllllllllllIlIllIlllIIllIllllI ? 310 : 150, 20, "");
            this.volume = 1.0f;
            this.category = lllllllllllllIlIllIlllIIllIlllll;
            this.categoryName = I18n.format("soundCategory." + lllllllllllllIlIllIlllIIllIlllll.getName(), new Object[0]);
            this.displayString = String.valueOf(this.categoryName) + ": " + GuiScreenOptionsSounds.this.getDisplayString(lllllllllllllIlIllIlllIIllIlllll);
            this.volume = GuiScreenOptionsSounds.this.game_settings_4.getSoundLevel(lllllllllllllIlIllIlllIIllIlllll);
        }
        
        @Override
        protected int getHoverState(final boolean lllllllllllllIlIllIlllIIllIlllII) {
            return 0;
        }
        
        @Override
        public void playPressSound(final SoundHandler lllllllllllllIlIllIlllIIllIIIlII) {
        }
        
        @Override
        public boolean mousePressed(final Minecraft lllllllllllllIlIllIlllIIllIIlIII, final int lllllllllllllIlIllIlllIIllIIlIll, final int lllllllllllllIlIllIlllIIllIIIllI) {
            if (super.mousePressed(lllllllllllllIlIllIlllIIllIIlIII, lllllllllllllIlIllIlllIIllIIlIll, lllllllllllllIlIllIlllIIllIIIllI)) {
                this.volume = (lllllllllllllIlIllIlllIIllIIlIll - (this.xPosition + 4)) / (float)(this.width - 8);
                this.volume = MathHelper.clamp(this.volume, 0.0f, 1.0f);
                lllllllllllllIlIllIlllIIllIIlIII.gameSettings.setSoundLevel(this.category, this.volume);
                lllllllllllllIlIllIlllIIllIIlIII.gameSettings.saveOptions();
                this.displayString = String.valueOf(this.categoryName) + ": " + GuiScreenOptionsSounds.this.getDisplayString(this.category);
                this.pressed = true;
                return true;
            }
            return false;
        }
    }
}
