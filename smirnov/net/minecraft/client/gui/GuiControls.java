// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.Minecraft;
import java.io.IOException;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

public class GuiControls extends GuiScreen
{
    protected /* synthetic */ String screenTitle;
    public /* synthetic */ long time;
    public /* synthetic */ KeyBinding buttonId;
    private final /* synthetic */ GuiScreen parentScreen;
    private static final /* synthetic */ GameSettings.Options[] OPTIONS_ARR;
    private /* synthetic */ GuiKeyBindingList keyBindingList;
    private /* synthetic */ GuiButton buttonReset;
    private final /* synthetic */ GameSettings options;
    
    @Override
    public void drawScreen(final int lllllllllllIIlIIIIIIllIIlIlIIIll, final int lllllllllllIIlIIIIIIllIIlIlIIIlI, final float lllllllllllIIlIIIIIIllIIlIlIIIIl) {
        this.drawDefaultBackground();
        this.keyBindingList.drawScreen(lllllllllllIIlIIIIIIllIIlIlIIIll, lllllllllllIIlIIIIIIllIIlIlIIIlI, lllllllllllIIlIIIIIIllIIlIlIIIIl);
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 8, 16777215);
        boolean lllllllllllIIlIIIIIIllIIlIlIIllI = false;
        final double lllllllllllIIlIIIIIIllIIlIIlllII;
        final short lllllllllllIIlIIIIIIllIIlIIlllIl = (short)((KeyBinding[])(Object)(lllllllllllIIlIIIIIIllIIlIIlllII = (double)(Object)this.options.keyBindings)).length;
        for (byte lllllllllllIIlIIIIIIllIIlIIllllI = 0; lllllllllllIIlIIIIIIllIIlIIllllI < lllllllllllIIlIIIIIIllIIlIIlllIl; ++lllllllllllIIlIIIIIIllIIlIIllllI) {
            final KeyBinding lllllllllllIIlIIIIIIllIIlIlIIlIl = lllllllllllIIlIIIIIIllIIlIIlllII[lllllllllllIIlIIIIIIllIIlIIllllI];
            if (lllllllllllIIlIIIIIIllIIlIlIIlIl.getKeyCode() != lllllllllllIIlIIIIIIllIIlIlIIlIl.getKeyCodeDefault()) {
                lllllllllllIIlIIIIIIllIIlIlIIllI = true;
                break;
            }
        }
        this.buttonReset.enabled = lllllllllllIIlIIIIIIllIIlIlIIllI;
        super.drawScreen(lllllllllllIIlIIIIIIllIIlIlIIIll, lllllllllllIIlIIIIIIllIIlIlIIIlI, lllllllllllIIlIIIIIIllIIlIlIIIIl);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIIlIIIIIIllIIllIIlIll, final int lllllllllllIIlIIIIIIllIIllIIlIlI, final int lllllllllllIIlIIIIIIllIIllIIllIl) throws IOException {
        if (this.buttonId != null) {
            this.options.setOptionKeyBinding(this.buttonId, -100 + lllllllllllIIlIIIIIIllIIllIIllIl);
            this.buttonId = null;
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else if (lllllllllllIIlIIIIIIllIIllIIllIl != 0 || !this.keyBindingList.mouseClicked(lllllllllllIIlIIIIIIllIIllIIlIll, lllllllllllIIlIIIIIIllIIllIIlIlI, lllllllllllIIlIIIIIIllIIllIIllIl)) {
            super.mouseClicked(lllllllllllIIlIIIIIIllIIllIIlIll, lllllllllllIIlIIIIIIllIIllIIlIlI, lllllllllllIIlIIIIIIllIIllIIllIl);
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIlIIIIIIllIIlIllIlIl, final int lllllllllllIIlIIIIIIllIIlIllIlII) throws IOException {
        if (this.buttonId != null) {
            if (lllllllllllIIlIIIIIIllIIlIllIlII == 1) {
                this.options.setOptionKeyBinding(this.buttonId, 0);
            }
            else if (lllllllllllIIlIIIIIIllIIlIllIlII != 0) {
                this.options.setOptionKeyBinding(this.buttonId, lllllllllllIIlIIIIIIllIIlIllIlII);
            }
            else if (lllllllllllIIlIIIIIIllIIlIllIlIl > '\0') {
                this.options.setOptionKeyBinding(this.buttonId, lllllllllllIIlIIIIIIllIIlIllIlIl + '\u0100');
            }
            this.buttonId = null;
            this.time = Minecraft.getSystemTime();
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else {
            super.keyTyped(lllllllllllIIlIIIIIIllIIlIllIlIl, lllllllllllIIlIIIIIIllIIlIllIlII);
        }
    }
    
    static {
        OPTIONS_ARR = new GameSettings.Options[] { GameSettings.Options.INVERT_MOUSE, GameSettings.Options.SENSITIVITY, GameSettings.Options.TOUCHSCREEN, GameSettings.Options.AUTO_JUMP };
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.keyBindingList.handleMouseInput();
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIlIIIIIIllIIllIlllII) throws IOException {
        if (lllllllllllIIlIIIIIIllIIllIlllII.id == 200) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
        else if (lllllllllllIIlIIIIIIllIIllIlllII.id == 201) {
            int lllllllllllIIlIIIIIIllIIllIlIlIl;
            for (Exception lllllllllllIIlIIIIIIllIIllIlIllI = (Exception)((KeyBinding[])(Object)(lllllllllllIIlIIIIIIllIIllIlIlIl = (int)(Object)this.mc.gameSettings.keyBindings)).length, lllllllllllIIlIIIIIIllIIllIlIlll = (Exception)0; lllllllllllIIlIIIIIIllIIllIlIlll < lllllllllllIIlIIIIIIllIIllIlIllI; ++lllllllllllIIlIIIIIIllIIllIlIlll) {
                final KeyBinding lllllllllllIIlIIIIIIllIIllIllIll = lllllllllllIIlIIIIIIllIIllIlIlIl[lllllllllllIIlIIIIIIllIIllIlIlll];
                lllllllllllIIlIIIIIIllIIllIllIll.setKeyCode(lllllllllllIIlIIIIIIllIIllIllIll.getKeyCodeDefault());
            }
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else if (lllllllllllIIlIIIIIIllIIllIlllII.id < 100 && lllllllllllIIlIIIIIIllIIllIlllII instanceof GuiOptionButton) {
            this.options.setOptionValue(((GuiOptionButton)lllllllllllIIlIIIIIIllIIllIlllII).returnEnumOptions(), 1);
            lllllllllllIIlIIIIIIllIIllIlllII.displayString = this.options.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllIIlIIIIIIllIIllIlllII.id));
        }
    }
    
    @Override
    public void initGui() {
        this.keyBindingList = new GuiKeyBindingList(this, this.mc);
        this.buttonList.add(new GuiButton(200, this.width / 2 - 155 + 160, this.height - 29, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonReset = this.addButton(new GuiButton(201, this.width / 2 - 155, this.height - 29, 150, 20, I18n.format("controls.resetAll", new Object[0])));
        this.screenTitle = I18n.format("controls.title", new Object[0]);
        int lllllllllllIIlIIIIIIllIIlllIlllI = 0;
        final boolean lllllllllllIIlIIIIIIllIIlllIIlll;
        final int lllllllllllIIlIIIIIIllIIlllIlIII = ((GameSettings.Options[])(Object)(lllllllllllIIlIIIIIIllIIlllIIlll = (boolean)(Object)GuiControls.OPTIONS_ARR)).length;
        for (Exception lllllllllllIIlIIIIIIllIIlllIlIIl = (Exception)0; lllllllllllIIlIIIIIIllIIlllIlIIl < lllllllllllIIlIIIIIIllIIlllIlIII; ++lllllllllllIIlIIIIIIllIIlllIlIIl) {
            final GameSettings.Options lllllllllllIIlIIIIIIllIIlllIllIl = lllllllllllIIlIIIIIIllIIlllIIlll[lllllllllllIIlIIIIIIllIIlllIlIIl];
            if (lllllllllllIIlIIIIIIllIIlllIllIl.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(lllllllllllIIlIIIIIIllIIlllIllIl.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllIIlIIIIIIllIIlllIlllI % 2 * 160, 18 + 24 * (lllllllllllIIlIIIIIIllIIlllIlllI >> 1), lllllllllllIIlIIIIIIllIIlllIllIl));
            }
            else {
                this.buttonList.add(new GuiOptionButton(lllllllllllIIlIIIIIIllIIlllIllIl.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllIIlIIIIIIllIIlllIlllI % 2 * 160, 18 + 24 * (lllllllllllIIlIIIIIIllIIlllIlllI >> 1), lllllllllllIIlIIIIIIllIIlllIllIl, this.options.getKeyBinding(lllllllllllIIlIIIIIIllIIlllIllIl)));
            }
            ++lllllllllllIIlIIIIIIllIIlllIlllI;
        }
    }
    
    public GuiControls(final GuiScreen lllllllllllIIlIIIIIIllIIlllllIlI, final GameSettings lllllllllllIIlIIIIIIllIIllllIllI) {
        this.screenTitle = "Controls";
        this.parentScreen = lllllllllllIIlIIIIIIllIIlllllIlI;
        this.options = lllllllllllIIlIIIIIIllIIllllIllI;
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllIIlIIIIIIllIIllIIIIll, final int lllllllllllIIlIIIIIIllIIllIIIIlI, final int lllllllllllIIlIIIIIIllIIlIllllIl) {
        if (lllllllllllIIlIIIIIIllIIlIllllIl != 0 || !this.keyBindingList.mouseReleased(lllllllllllIIlIIIIIIllIIllIIIIll, lllllllllllIIlIIIIIIllIIllIIIIlI, lllllllllllIIlIIIIIIllIIlIllllIl)) {
            super.mouseReleased(lllllllllllIIlIIIIIIllIIllIIIIll, lllllllllllIIlIIIIIIllIIllIIIIlI, lllllllllllIIlIIIIIIllIIlIllllIl);
        }
    }
}
