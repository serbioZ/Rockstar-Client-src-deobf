// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.resources.I18n;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.Minecraft;

public class GuiKeyBindingList extends GuiListExtended
{
    private final /* synthetic */ IGuiListEntry[] listEntries;
    private /* synthetic */ int maxListLabelWidth;
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ GuiControls controlsScreen;
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 15;
    }
    
    @Override
    public IGuiListEntry getListEntry(final int llllllllllllIlIIIIlIIllIIIIlIIlI) {
        return this.listEntries[llllllllllllIlIIIIlIIllIIIIlIIlI];
    }
    
    public GuiKeyBindingList(final GuiControls llllllllllllIlIIIIlIIllIIIlIllII, final Minecraft llllllllllllIlIIIIlIIllIIIlIIIlI) {
        super(llllllllllllIlIIIIlIIllIIIlIIIlI, llllllllllllIlIIIIlIIllIIIlIllII.width + 45, llllllllllllIlIIIIlIIllIIIlIllII.height, 63, llllllllllllIlIIIIlIIllIIIlIllII.height - 32, 20);
        this.controlsScreen = llllllllllllIlIIIIlIIllIIIlIllII;
        this.mc = llllllllllllIlIIIIlIIllIIIlIIIlI;
        final KeyBinding[] llllllllllllIlIIIIlIIllIIIlIlIlI = (KeyBinding[])ArrayUtils.clone((Object[])llllllllllllIlIIIIlIIllIIIlIIIlI.gameSettings.keyBindings);
        this.listEntries = new IGuiListEntry[llllllllllllIlIIIIlIIllIIIlIlIlI.length + KeyBinding.getKeybinds().size()];
        Arrays.sort(llllllllllllIlIIIIlIIllIIIlIlIlI);
        int llllllllllllIlIIIIlIIllIIIlIlIIl = 0;
        String llllllllllllIlIIIIlIIllIIIlIlIII = null;
        final String llllllllllllIlIIIIlIIllIIIIllIll;
        final byte llllllllllllIlIIIIlIIllIIIIlllII = (byte)((KeyBinding[])(Object)(llllllllllllIlIIIIlIIllIIIIllIll = (String)(Object)llllllllllllIlIIIIlIIllIIIlIlIlI)).length;
        for (float llllllllllllIlIIIIlIIllIIIIlllIl = 0; llllllllllllIlIIIIlIIllIIIIlllIl < llllllllllllIlIIIIlIIllIIIIlllII; ++llllllllllllIlIIIIlIIllIIIIlllIl) {
            final KeyBinding llllllllllllIlIIIIlIIllIIIlIIlll = llllllllllllIlIIIIlIIllIIIIllIll[llllllllllllIlIIIIlIIllIIIIlllIl];
            final String llllllllllllIlIIIIlIIllIIIlIIllI = llllllllllllIlIIIIlIIllIIIlIIlll.getKeyCategory();
            if (!llllllllllllIlIIIIlIIllIIIlIIllI.equals(llllllllllllIlIIIIlIIllIIIlIlIII)) {
                llllllllllllIlIIIIlIIllIIIlIlIII = llllllllllllIlIIIIlIIllIIIlIIllI;
                this.listEntries[llllllllllllIlIIIIlIIllIIIlIlIIl++] = new CategoryEntry(llllllllllllIlIIIIlIIllIIIlIIllI);
            }
            final int llllllllllllIlIIIIlIIllIIIlIIlIl = Minecraft.fontRendererObj.getStringWidth(I18n.format(llllllllllllIlIIIIlIIllIIIlIIlll.getKeyDescription(), new Object[0]));
            if (llllllllllllIlIIIIlIIllIIIlIIlIl > this.maxListLabelWidth) {
                this.maxListLabelWidth = llllllllllllIlIIIIlIIllIIIlIIlIl;
            }
            this.listEntries[llllllllllllIlIIIIlIIllIIIlIlIIl++] = new KeyEntry(llllllllllllIlIIIIlIIllIIIlIIlll, (KeyEntry)null);
        }
    }
    
    @Override
    public int getListWidth() {
        return super.getListWidth() + 32;
    }
    
    @Override
    protected int getSize() {
        return this.listEntries.length;
    }
    
    public class CategoryEntry implements IGuiListEntry
    {
        private final /* synthetic */ int labelWidth;
        private final /* synthetic */ String labelText;
        
        @Override
        public boolean mousePressed(final int lllllllllllIlIllIIIIlIlIllIIIlII, final int lllllllllllIlIllIIIIlIlIllIIIIll, final int lllllllllllIlIllIIIIlIlIllIIIIlI, final int lllllllllllIlIllIIIIlIlIllIIIIIl, final int lllllllllllIlIllIIIIlIlIllIIIIII, final int lllllllllllIlIllIIIIlIlIlIllllll) {
            return false;
        }
        
        @Override
        public void func_192633_a(final int lllllllllllIlIllIIIIlIlIlIllIllI, final int lllllllllllIlIllIIIIlIlIlIllIlIl, final int lllllllllllIlIllIIIIlIlIlIllIlII, final float lllllllllllIlIllIIIIlIlIlIllIIll) {
        }
        
        @Override
        public void func_192634_a(final int lllllllllllIlIllIIIIlIlIllIlIIIl, final int lllllllllllIlIllIIIIlIlIllIlIIII, final int lllllllllllIlIllIIIIlIlIllIIIlll, final int lllllllllllIlIllIIIIlIlIllIIlllI, final int lllllllllllIlIllIIIIlIlIllIIIllI, final int lllllllllllIlIllIIIIlIlIllIIllII, final int lllllllllllIlIllIIIIlIlIllIIlIll, final boolean lllllllllllIlIllIIIIlIlIllIIlIlI, final float lllllllllllIlIllIIIIlIlIllIIlIIl) {
            Minecraft.fontRendererObj.drawString(this.labelText, (float)(GuiKeyBindingList.this.mc.currentScreen.width / 2 - this.labelWidth / 2), (float)(lllllllllllIlIllIIIIlIlIllIIIlll + lllllllllllIlIllIIIIlIlIllIIIllI - Minecraft.fontRendererObj.FONT_HEIGHT - 1), 16777215);
        }
        
        @Override
        public void mouseReleased(final int lllllllllllIlIllIIIIlIlIlIllllIl, final int lllllllllllIlIllIIIIlIlIlIllllII, final int lllllllllllIlIllIIIIlIlIlIlllIll, final int lllllllllllIlIllIIIIlIlIlIlllIlI, final int lllllllllllIlIllIIIIlIlIlIlllIIl, final int lllllllllllIlIllIIIIlIlIlIlllIII) {
        }
        
        public CategoryEntry(final String lllllllllllIlIllIIIIlIlIllIlIllI) {
            this.labelText = I18n.format(lllllllllllIlIllIIIIlIlIllIlIllI, new Object[0]);
            this.labelWidth = Minecraft.fontRendererObj.getStringWidth(this.labelText);
        }
    }
    
    public class KeyEntry implements IGuiListEntry
    {
        private final /* synthetic */ GuiButton btnChangeKeyBinding;
        private final /* synthetic */ GuiButton btnReset;
        private final /* synthetic */ String keyDesc;
        private final /* synthetic */ KeyBinding keybinding;
        
        @Override
        public void func_192634_a(final int lllllllllllIllllIlIIllIlIlllIIII, final int lllllllllllIllllIlIIllIlIllIIIll, final int lllllllllllIllllIlIIllIlIllIlllI, final int lllllllllllIllllIlIIllIlIllIllIl, final int lllllllllllIllllIlIIllIlIllIIIIl, final int lllllllllllIllllIlIIllIlIllIIIII, final int lllllllllllIllllIlIIllIlIllIlIlI, final boolean lllllllllllIllllIlIIllIlIllIlIIl, final float lllllllllllIllllIlIIllIlIlIllllI) {
            final boolean lllllllllllIllllIlIIllIlIllIIlll = GuiKeyBindingList.this.controlsScreen.buttonId == this.keybinding;
            Minecraft.fontRendererObj.drawString(this.keyDesc, (float)(lllllllllllIllllIlIIllIlIllIIIll + 90 - GuiKeyBindingList.this.maxListLabelWidth), (float)(lllllllllllIllllIlIIllIlIllIlllI + lllllllllllIllllIlIIllIlIllIIIIl / 2 - Minecraft.fontRendererObj.FONT_HEIGHT / 2), 16777215);
            this.btnReset.xPosition = lllllllllllIllllIlIIllIlIllIIIll + 190;
            this.btnReset.yPosition = lllllllllllIllllIlIIllIlIllIlllI;
            this.btnReset.enabled = (this.keybinding.getKeyCode() != this.keybinding.getKeyCodeDefault());
            this.btnReset.drawButton(GuiKeyBindingList.this.mc, lllllllllllIllllIlIIllIlIllIIIII, lllllllllllIllllIlIIllIlIllIlIlI, lllllllllllIllllIlIIllIlIlIllllI);
            this.btnChangeKeyBinding.xPosition = lllllllllllIllllIlIIllIlIllIIIll + 105;
            this.btnChangeKeyBinding.yPosition = lllllllllllIllllIlIIllIlIllIlllI;
            this.btnChangeKeyBinding.displayString = GameSettings.getKeyDisplayString(this.keybinding.getKeyCode());
            boolean lllllllllllIllllIlIIllIlIllIIllI = false;
            if (this.keybinding.getKeyCode() != 0) {
                final char lllllllllllIllllIlIIllIlIlIllIII;
                final int lllllllllllIllllIlIIllIlIlIllIIl = ((KeyBinding[])(Object)(lllllllllllIllllIlIIllIlIlIllIII = (char)(Object)GuiKeyBindingList.this.mc.gameSettings.keyBindings)).length;
                for (boolean lllllllllllIllllIlIIllIlIlIllIlI = false; (lllllllllllIllllIlIIllIlIlIllIlI ? 1 : 0) < lllllllllllIllllIlIIllIlIlIllIIl; ++lllllllllllIllllIlIIllIlIlIllIlI) {
                    final KeyBinding lllllllllllIllllIlIIllIlIllIIlIl = lllllllllllIllllIlIIllIlIlIllIII[lllllllllllIllllIlIIllIlIlIllIlI];
                    if (lllllllllllIllllIlIIllIlIllIIlIl != this.keybinding && lllllllllllIllllIlIIllIlIllIIlIl.getKeyCode() == this.keybinding.getKeyCode()) {
                        lllllllllllIllllIlIIllIlIllIIllI = true;
                        break;
                    }
                }
            }
            if (lllllllllllIllllIlIIllIlIllIIlll) {
                this.btnChangeKeyBinding.displayString = TextFormatting.WHITE + "> " + TextFormatting.YELLOW + this.btnChangeKeyBinding.displayString + TextFormatting.WHITE + " <";
            }
            else if (lllllllllllIllllIlIIllIlIllIIllI) {
                this.btnChangeKeyBinding.displayString = TextFormatting.RED + this.btnChangeKeyBinding.displayString;
            }
            this.btnChangeKeyBinding.drawButton(GuiKeyBindingList.this.mc, lllllllllllIllllIlIIllIlIllIIIII, lllllllllllIllllIlIIllIlIllIlIlI, lllllllllllIllllIlIIllIlIlIllllI);
        }
        
        @Override
        public void mouseReleased(final int lllllllllllIllllIlIIllIlIlIIIllI, final int lllllllllllIllllIlIIllIlIIllllll, final int lllllllllllIllllIlIIllIlIIlllllI, final int lllllllllllIllllIlIIllIlIlIIIIll, final int lllllllllllIllllIlIIllIlIlIIIIlI, final int lllllllllllIllllIlIIllIlIlIIIIIl) {
            this.btnChangeKeyBinding.mouseReleased(lllllllllllIllllIlIIllIlIIllllll, lllllllllllIllllIlIIllIlIIlllllI);
            this.btnReset.mouseReleased(lllllllllllIllllIlIIllIlIIllllll, lllllllllllIllllIlIIllIlIIlllllI);
        }
        
        @Override
        public boolean mousePressed(final int lllllllllllIllllIlIIllIlIlIlIIll, final int lllllllllllIllllIlIIllIlIlIIllII, final int lllllllllllIllllIlIIllIlIlIlIIIl, final int lllllllllllIllllIlIIllIlIlIlIIII, final int lllllllllllIllllIlIIllIlIlIIllll, final int lllllllllllIllllIlIIllIlIlIIlllI) {
            if (this.btnChangeKeyBinding.mousePressed(GuiKeyBindingList.this.mc, lllllllllllIllllIlIIllIlIlIIllII, lllllllllllIllllIlIIllIlIlIlIIIl)) {
                GuiKeyBindingList.this.controlsScreen.buttonId = this.keybinding;
                return true;
            }
            if (this.btnReset.mousePressed(GuiKeyBindingList.this.mc, lllllllllllIllllIlIIllIlIlIIllII, lllllllllllIllllIlIIllIlIlIlIIIl)) {
                GuiKeyBindingList.this.mc.gameSettings.setOptionKeyBinding(this.keybinding, this.keybinding.getKeyCodeDefault());
                KeyBinding.resetKeyBindingArrayAndHash();
                return true;
            }
            return false;
        }
        
        private KeyEntry(final KeyBinding lllllllllllIllllIlIIllIlIlllllll) {
            this.keybinding = lllllllllllIllllIlIIllIlIlllllll;
            this.keyDesc = I18n.format(lllllllllllIllllIlIIllIlIlllllll.getKeyDescription(), new Object[0]);
            this.btnChangeKeyBinding = new GuiButton(0, 0, 0, 75, 20, I18n.format(lllllllllllIllllIlIIllIlIlllllll.getKeyDescription(), new Object[0]));
            this.btnReset = new GuiButton(0, 0, 0, 50, 20, I18n.format("controls.reset", new Object[0]));
        }
        
        @Override
        public void func_192633_a(final int lllllllllllIllllIlIIllIlIIllllII, final int lllllllllllIllllIlIIllIlIIlllIll, final int lllllllllllIllllIlIIllIlIIlllIlI, final float lllllllllllIllllIlIIllIlIIlllIIl) {
        }
    }
}
