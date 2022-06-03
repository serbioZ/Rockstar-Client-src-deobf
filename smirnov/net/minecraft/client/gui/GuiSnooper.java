// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import com.google.common.collect.Lists;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import java.util.List;

public class GuiSnooper extends GuiScreen
{
    private /* synthetic */ List list;
    private final /* synthetic */ GuiScreen lastScreen;
    private final /* synthetic */ java.util.List<String> keys;
    private /* synthetic */ GuiButton toggleButton;
    private final /* synthetic */ java.util.List<String> values;
    private /* synthetic */ String title;
    private /* synthetic */ String[] desc;
    private final /* synthetic */ GameSettings game_settings_2;
    
    @Override
    public void initGui() {
        this.title = I18n.format("options.snooper.title", new Object[0]);
        final String lllllllllllIIllIlllIIlIIlIIIIllI = I18n.format("options.snooper.desc", new Object[0]);
        final java.util.List<String> lllllllllllIIllIlllIIlIIlIIIIlIl = (java.util.List<String>)Lists.newArrayList();
        for (final String lllllllllllIIllIlllIIlIIlIIIIlII : this.fontRendererObj.listFormattedStringToWidth(lllllllllllIIllIlllIIlIIlIIIIllI, this.width - 30)) {
            lllllllllllIIllIlllIIlIIlIIIIlIl.add(lllllllllllIIllIlllIIlIIlIIIIlII);
        }
        this.desc = lllllllllllIIllIlllIIlIIlIIIIlIl.toArray(new String[lllllllllllIIllIlllIIlIIlIIIIlIl.size()]);
        this.keys.clear();
        this.values.clear();
        this.toggleButton = this.addButton(new GuiButton(1, this.width / 2 - 152, this.height - 30, 150, 20, this.game_settings_2.getKeyBinding(GameSettings.Options.SNOOPER_ENABLED)));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 2, this.height - 30, 150, 20, I18n.format("gui.done", new Object[0])));
        final boolean lllllllllllIIllIlllIIlIIlIIIIIll = this.mc.getIntegratedServer() != null && this.mc.getIntegratedServer().getPlayerUsageSnooper() != null;
        for (final Map.Entry<String, String> lllllllllllIIllIlllIIlIIlIIIIIlI : new TreeMap(this.mc.getPlayerUsageSnooper().getCurrentStats()).entrySet()) {
            this.keys.add(String.valueOf(lllllllllllIIllIlllIIlIIlIIIIIll ? "C " : "") + lllllllllllIIllIlllIIlIIlIIIIIlI.getKey());
            this.values.add(this.fontRendererObj.trimStringToWidth(lllllllllllIIllIlllIIlIIlIIIIIlI.getValue(), this.width - 220));
        }
        if (lllllllllllIIllIlllIIlIIlIIIIIll) {
            for (final Map.Entry<String, String> lllllllllllIIllIlllIIlIIlIIIIIIl : new TreeMap(this.mc.getIntegratedServer().getPlayerUsageSnooper().getCurrentStats()).entrySet()) {
                this.keys.add("S " + lllllllllllIIllIlllIIlIIlIIIIIIl.getKey());
                this.values.add(this.fontRendererObj.trimStringToWidth(lllllllllllIIllIlllIIlIIlIIIIIIl.getValue(), this.width - 220));
            }
        }
        this.list = new List();
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIllIlllIIlIIIlllIIlI) throws IOException {
        if (lllllllllllIIllIlllIIlIIIlllIIlI.enabled) {
            if (lllllllllllIIllIlllIIlIIIlllIIlI.id == 2) {
                this.game_settings_2.saveOptions();
                this.game_settings_2.saveOptions();
                this.mc.displayGuiScreen(this.lastScreen);
            }
            if (lllllllllllIIllIlllIIlIIIlllIIlI.id == 1) {
                this.game_settings_2.setOptionValue(GameSettings.Options.SNOOPER_ENABLED, 1);
                this.toggleButton.displayString = this.game_settings_2.getKeyBinding(GameSettings.Options.SNOOPER_ENABLED);
            }
        }
    }
    
    public GuiSnooper(final GuiScreen lllllllllllIIllIlllIIlIIlIIIllll, final GameSettings lllllllllllIIllIlllIIlIIlIIIlllI) {
        this.keys = (java.util.List<String>)Lists.newArrayList();
        this.values = (java.util.List<String>)Lists.newArrayList();
        this.lastScreen = lllllllllllIIllIlllIIlIIlIIIllll;
        this.game_settings_2 = lllllllllllIIllIlllIIlIIlIIIlllI;
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIllIlllIIlIIIllIIlll, final int lllllllllllIIllIlllIIlIIIllIIIII, final float lllllllllllIIllIlllIIlIIIllIIlIl) {
        this.drawDefaultBackground();
        this.list.drawScreen(lllllllllllIIllIlllIIlIIIllIIlll, lllllllllllIIllIlllIIlIIIllIIIII, lllllllllllIIllIlllIIlIIIllIIlIl);
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 8, 16777215);
        int lllllllllllIIllIlllIIlIIIllIIlII = 22;
        final short lllllllllllIIllIlllIIlIIIlIllIlI;
        final char lllllllllllIIllIlllIIlIIIlIllIll = (char)((String[])(Object)(lllllllllllIIllIlllIIlIIIlIllIlI = (short)(Object)this.desc)).length;
        for (final String lllllllllllIIllIlllIIlIIIllIIIll : lllllllllllIIllIlllIIlIIIlIllIlI) {
            this.drawCenteredString(this.fontRendererObj, lllllllllllIIllIlllIIlIIIllIIIll, this.width / 2, lllllllllllIIllIlllIIlIIIllIIlII, 8421504);
            lllllllllllIIllIlllIIlIIIllIIlII += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(lllllllllllIIllIlllIIlIIIllIIlll, lllllllllllIIllIlllIIlIIIllIIIII, lllllllllllIIllIlllIIlIIIllIIlIl);
    }
    
    class List extends GuiSlot
    {
        @Override
        protected boolean isSelected(final int lllllllllllIIlIIIIIlIllllIllIllI) {
            return false;
        }
        
        @Override
        protected void func_192637_a(final int lllllllllllIIlIIIIIlIllllIllIIII, final int lllllllllllIIlIIIIIlIllllIlIllll, final int lllllllllllIIlIIIIIlIllllIlIIlll, final int lllllllllllIIlIIIIIlIllllIlIllIl, final int lllllllllllIIlIIIIIlIllllIlIllII, final int lllllllllllIIlIIIIIlIllllIlIlIll, final float lllllllllllIIlIIIIIlIllllIlIlIlI) {
            GuiSnooper.this.fontRendererObj.drawString(GuiSnooper.this.keys.get(lllllllllllIIlIIIIIlIllllIllIIII), 10.0f, (float)lllllllllllIIlIIIIIlIllllIlIIlll, 16777215);
            GuiSnooper.this.fontRendererObj.drawString(GuiSnooper.this.values.get(lllllllllllIIlIIIIIlIllllIllIIII), 230.0f, (float)lllllllllllIIlIIIIIlIllllIlIIlll, 16777215);
        }
        
        @Override
        protected int getSize() {
            return GuiSnooper.this.keys.size();
        }
        
        @Override
        protected int getScrollBarX() {
            return this.width - 10;
        }
        
        @Override
        protected void elementClicked(final int lllllllllllIIlIIIIIlIllllIlllIll, final boolean lllllllllllIIlIIIIIlIllllIlllIlI, final int lllllllllllIIlIIIIIlIllllIlllIIl, final int lllllllllllIIlIIIIIlIllllIlllIII) {
        }
        
        public List() {
            super(GuiSnooper.this.mc, GuiSnooper.this.width, GuiSnooper.this.height, 80, GuiSnooper.this.height - 40, GuiSnooper.this.fontRendererObj.FONT_HEIGHT + 1);
        }
        
        @Override
        protected void drawBackground() {
        }
    }
}
