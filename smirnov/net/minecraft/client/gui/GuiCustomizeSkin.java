// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EnumPlayerModelParts;

public class GuiCustomizeSkin extends GuiScreen
{
    private /* synthetic */ String title;
    private final /* synthetic */ GuiScreen parentScreen;
    
    private String getMessage(final EnumPlayerModelParts llllllllllllIIIlllIIIIlIIllIIIlI) {
        String llllllllllllIIIlllIIIIlIIllIIIII = null;
        if (this.mc.gameSettings.getModelParts().contains(llllllllllllIIIlllIIIIlIIllIIIlI)) {
            final String llllllllllllIIIlllIIIIlIIllIIIIl = I18n.format("options.on", new Object[0]);
        }
        else {
            llllllllllllIIIlllIIIIlIIllIIIII = I18n.format("options.off", new Object[0]);
        }
        return String.valueOf(llllllllllllIIIlllIIIIlIIllIIIlI.getName().getFormattedText()) + ": " + llllllllllllIIIlllIIIIlIIllIIIII;
    }
    
    @Override
    public void initGui() {
        int llllllllllllIIIlllIIIIlIlIIIllII = 0;
        this.title = I18n.format("options.skinCustomisation.title", new Object[0]);
        final float llllllllllllIIIlllIIIIlIlIIIIlIl;
        final short llllllllllllIIIlllIIIIlIlIIIIllI = (short)((EnumPlayerModelParts[])(Object)(llllllllllllIIIlllIIIIlIlIIIIlIl = (float)(Object)EnumPlayerModelParts.values())).length;
        for (boolean llllllllllllIIIlllIIIIlIlIIIIlll = false; (llllllllllllIIIlllIIIIlIlIIIIlll ? 1 : 0) < llllllllllllIIIlllIIIIlIlIIIIllI; ++llllllllllllIIIlllIIIIlIlIIIIlll) {
            final EnumPlayerModelParts llllllllllllIIIlllIIIIlIlIIIlIll = llllllllllllIIIlllIIIIlIlIIIIlIl[llllllllllllIIIlllIIIIlIlIIIIlll];
            this.buttonList.add(new ButtonPart(llllllllllllIIIlllIIIIlIlIIIlIll.getPartId(), this.width / 2 - 155 + llllllllllllIIIlllIIIIlIlIIIllII % 2 * 160, this.height / 6 + 24 * (llllllllllllIIIlllIIIIlIlIIIllII >> 1), 150, 20, llllllllllllIIIlllIIIIlIlIIIlIll, (ButtonPart)null));
            ++llllllllllllIIIlllIIIIlIlIIIllII;
        }
        this.buttonList.add(new GuiOptionButton(199, this.width / 2 - 155 + llllllllllllIIIlllIIIIlIlIIIllII % 2 * 160, this.height / 6 + 24 * (llllllllllllIIIlllIIIIlIlIIIllII >> 1), GameSettings.Options.MAIN_HAND, this.mc.gameSettings.getKeyBinding(GameSettings.Options.MAIN_HAND)));
        if (++llllllllllllIIIlllIIIIlIlIIIllII % 2 == 1) {
            ++llllllllllllIIIlllIIIIlIlIIIllII;
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 24 * (llllllllllllIIIlllIIIIlIlIIIllII >> 1), I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIIIlllIIIIlIIlllIlll) throws IOException {
        if (llllllllllllIIIlllIIIIlIIlllIlll.enabled) {
            if (llllllllllllIIIlllIIIIlIIlllIlll.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentScreen);
            }
            else if (llllllllllllIIIlllIIIIlIIlllIlll.id == 199) {
                this.mc.gameSettings.setOptionValue(GameSettings.Options.MAIN_HAND, 1);
                llllllllllllIIIlllIIIIlIIlllIlll.displayString = this.mc.gameSettings.getKeyBinding(GameSettings.Options.MAIN_HAND);
                this.mc.gameSettings.sendSettingsToServer();
            }
            else if (llllllllllllIIIlllIIIIlIIlllIlll instanceof ButtonPart) {
                final EnumPlayerModelParts llllllllllllIIIlllIIIIlIIlllIllI = ((ButtonPart)llllllllllllIIIlllIIIIlIIlllIlll).playerModelParts;
                this.mc.gameSettings.switchModelPartEnabled(llllllllllllIIIlllIIIIlIIlllIllI);
                llllllllllllIIIlllIIIIlIIlllIlll.displayString = this.getMessage(llllllllllllIIIlllIIIIlIIlllIllI);
            }
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllIIIlllIIIIlIIllIllIl, final int llllllllllllIIIlllIIIIlIIllIlIII, final float llllllllllllIIIlllIIIIlIIllIlIll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 20, 16777215);
        super.drawScreen(llllllllllllIIIlllIIIIlIIllIllIl, llllllllllllIIIlllIIIIlIIllIlIII, llllllllllllIIIlllIIIIlIIllIlIll);
    }
    
    public GuiCustomizeSkin(final GuiScreen llllllllllllIIIlllIIIIlIlIIlIlII) {
        this.parentScreen = llllllllllllIIIlllIIIIlIlIIlIlII;
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIIIlllIIIIlIIlllllIl, final int llllllllllllIIIlllIIIIlIIlllllll) throws IOException {
        if (llllllllllllIIIlllIIIIlIIlllllll == 1) {
            this.mc.gameSettings.saveOptions();
        }
        super.keyTyped(llllllllllllIIIlllIIIIlIIlllllIl, llllllllllllIIIlllIIIIlIIlllllll);
    }
    
    class ButtonPart extends GuiButton
    {
        private final /* synthetic */ EnumPlayerModelParts playerModelParts;
        
        private ButtonPart(final int lllllllllllllllIIlIIIllIlIIlIIll, final int lllllllllllllllIIlIIIllIlIIllIlI, final int lllllllllllllllIIlIIIllIlIIlIIIl, final int lllllllllllllllIIlIIIllIlIIlIIII, final int lllllllllllllllIIlIIIllIlIIIllll, final EnumPlayerModelParts lllllllllllllllIIlIIIllIlIIlIllI) {
            super(lllllllllllllllIIlIIIllIlIIlIIll, lllllllllllllllIIlIIIllIlIIllIlI, lllllllllllllllIIlIIIllIlIIlIIIl, lllllllllllllllIIlIIIllIlIIlIIII, lllllllllllllllIIlIIIllIlIIIllll, GuiCustomizeSkin.this.getMessage(lllllllllllllllIIlIIIllIlIIlIllI));
            this.playerModelParts = lllllllllllllllIIlIIIllIlIIlIllI;
        }
    }
}
