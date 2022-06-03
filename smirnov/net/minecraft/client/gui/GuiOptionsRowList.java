// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.Minecraft;
import java.util.List;

public class GuiOptionsRowList extends GuiListExtended
{
    private final /* synthetic */ List<Row> options;
    
    @Override
    public Row getListEntry(final int lllllllllllIlIlIIIIlIIIIIllIllIl) {
        return this.options.get(lllllllllllIlIlIIIIlIIIIIllIllIl);
    }
    
    public GuiOptionsRowList(final Minecraft lllllllllllIlIlIIIIlIIIIlIIllIIl, final int lllllllllllIlIlIIIIlIIIIlIIllIII, final int lllllllllllIlIlIIIIlIIIIlIIlIlll, final int lllllllllllIlIlIIIIlIIIIlIIIlIIl, final int lllllllllllIlIlIIIIlIIIIlIIlIlIl, final int lllllllllllIlIlIIIIlIIIIlIIlIlII, final GameSettings.Options... lllllllllllIlIlIIIIlIIIIlIIlIIll) {
        super(lllllllllllIlIlIIIIlIIIIlIIllIIl, lllllllllllIlIlIIIIlIIIIlIIllIII, lllllllllllIlIlIIIIlIIIIlIIlIlll, lllllllllllIlIlIIIIlIIIIlIIIlIIl, lllllllllllIlIlIIIIlIIIIlIIlIlIl, lllllllllllIlIlIIIIlIIIIlIIlIlII);
        this.options = (List<Row>)Lists.newArrayList();
        this.centerListVertically = false;
        for (int lllllllllllIlIlIIIIlIIIIlIIlIIlI = 0; lllllllllllIlIlIIIIlIIIIlIIlIIlI < lllllllllllIlIlIIIIlIIIIlIIlIIll.length; lllllllllllIlIlIIIIlIIIIlIIlIIlI += 2) {
            final GameSettings.Options lllllllllllIlIlIIIIlIIIIlIIlIIIl = lllllllllllIlIlIIIIlIIIIlIIlIIll[lllllllllllIlIlIIIIlIIIIlIIlIIlI];
            final GameSettings.Options lllllllllllIlIlIIIIlIIIIlIIlIIII = (lllllllllllIlIlIIIIlIIIIlIIlIIlI < lllllllllllIlIlIIIIlIIIIlIIlIIll.length - 1) ? lllllllllllIlIlIIIIlIIIIlIIlIIll[lllllllllllIlIlIIIIlIIIIlIIlIIlI + 1] : null;
            final GuiButton lllllllllllIlIlIIIIlIIIIlIIIllll = this.createButton(lllllllllllIlIlIIIIlIIIIlIIllIIl, lllllllllllIlIlIIIIlIIIIlIIllIII / 2 - 155, 0, lllllllllllIlIlIIIIlIIIIlIIlIIIl);
            final GuiButton lllllllllllIlIlIIIIlIIIIlIIIlllI = this.createButton(lllllllllllIlIlIIIIlIIIIlIIllIIl, lllllllllllIlIlIIIIlIIIIlIIllIII / 2 - 155 + 160, 0, lllllllllllIlIlIIIIlIIIIlIIlIIII);
            this.options.add(new Row(lllllllllllIlIlIIIIlIIIIlIIIllll, lllllllllllIlIlIIIIlIIIIlIIIlllI));
        }
    }
    
    @Override
    protected int getSize() {
        return this.options.size();
    }
    
    private GuiButton createButton(final Minecraft lllllllllllIlIlIIIIlIIIIIllllIlI, final int lllllllllllIlIlIIIIlIIIIIlllIlII, final int lllllllllllIlIlIIIIlIIIIIlllIIll, final GameSettings.Options lllllllllllIlIlIIIIlIIIIIlllIlll) {
        if (lllllllllllIlIlIIIIlIIIIIlllIlll == null) {
            return null;
        }
        final int lllllllllllIlIlIIIIlIIIIIlllIllI = lllllllllllIlIlIIIIlIIIIIlllIlll.returnEnumOrdinal();
        return lllllllllllIlIlIIIIlIIIIIlllIlll.getEnumFloat() ? new GuiOptionSlider(lllllllllllIlIlIIIIlIIIIIlllIllI, lllllllllllIlIlIIIIlIIIIIlllIlII, lllllllllllIlIlIIIIlIIIIIlllIIll, lllllllllllIlIlIIIIlIIIIIlllIlll) : new GuiOptionButton(lllllllllllIlIlIIIIlIIIIIlllIllI, lllllllllllIlIlIIIIlIIIIIlllIlII, lllllllllllIlIlIIIIlIIIIIlllIIll, lllllllllllIlIlIIIIlIIIIIlllIlll, lllllllllllIlIlIIIIlIIIIIllllIlI.gameSettings.getKeyBinding(lllllllllllIlIlIIIIlIIIIIlllIlll));
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 32;
    }
    
    @Override
    public int getListWidth() {
        return 400;
    }
    
    public static class Row implements IGuiListEntry
    {
        private final /* synthetic */ Minecraft client;
        private final /* synthetic */ GuiButton buttonA;
        private final /* synthetic */ GuiButton buttonB;
        
        public Row(final GuiButton lllllllllllIllIlIIlIllIlllIIlllI, final GuiButton lllllllllllIllIlIIlIllIlllIIllIl) {
            this.client = Minecraft.getMinecraft();
            this.buttonA = lllllllllllIllIlIIlIllIlllIIlllI;
            this.buttonB = lllllllllllIllIlIIlIllIlllIIllIl;
        }
        
        @Override
        public void func_192634_a(final int lllllllllllIllIlIIlIllIlllIIIllI, final int lllllllllllIllIlIIlIllIlllIIIlIl, final int lllllllllllIllIlIIlIllIlllIIIlII, final int lllllllllllIllIlIIlIllIlllIIIIll, final int lllllllllllIllIlIIlIllIlllIIIIlI, final int lllllllllllIllIlIIlIllIllIlllIll, final int lllllllllllIllIlIIlIllIlllIIIIII, final boolean lllllllllllIllIlIIlIllIllIllllll, final float lllllllllllIllIlIIlIllIllIlllllI) {
            if (this.buttonA != null) {
                this.buttonA.yPosition = lllllllllllIllIlIIlIllIlllIIIlII;
                this.buttonA.drawButton(this.client, lllllllllllIllIlIIlIllIllIlllIll, lllllllllllIllIlIIlIllIlllIIIIII, lllllllllllIllIlIIlIllIllIlllllI);
            }
            if (this.buttonB != null) {
                this.buttonB.yPosition = lllllllllllIllIlIIlIllIlllIIIlII;
                this.buttonB.drawButton(this.client, lllllllllllIllIlIIlIllIllIlllIll, lllllllllllIllIlIIlIllIlllIIIIII, lllllllllllIllIlIIlIllIllIlllllI);
            }
        }
        
        @Override
        public void func_192633_a(final int lllllllllllIllIlIIlIllIllIIlllIl, final int lllllllllllIllIlIIlIllIllIIlllII, final int lllllllllllIllIlIIlIllIllIIllIll, final float lllllllllllIllIlIIlIllIllIIllIlI) {
        }
        
        @Override
        public void mouseReleased(final int lllllllllllIllIlIIlIllIllIlIIlll, final int lllllllllllIllIlIIlIllIllIlIIllI, final int lllllllllllIllIlIIlIllIllIlIIlIl, final int lllllllllllIllIlIIlIllIllIlIIlII, final int lllllllllllIllIlIIlIllIllIlIIIll, final int lllllllllllIllIlIIlIllIllIlIIIlI) {
            if (this.buttonA != null) {
                this.buttonA.mouseReleased(lllllllllllIllIlIIlIllIllIlIIllI, lllllllllllIllIlIIlIllIllIlIIlIl);
            }
            if (this.buttonB != null) {
                this.buttonB.mouseReleased(lllllllllllIllIlIIlIllIllIlIIllI, lllllllllllIllIlIIlIllIllIlIIlIl);
            }
        }
        
        @Override
        public boolean mousePressed(final int lllllllllllIllIlIIlIllIllIllIlII, final int lllllllllllIllIlIIlIllIllIlIllIl, final int lllllllllllIllIlIIlIllIllIlIllII, final int lllllllllllIllIlIIlIllIllIllIIIl, final int lllllllllllIllIlIIlIllIllIllIIII, final int lllllllllllIllIlIIlIllIllIlIllll) {
            if (this.buttonA.mousePressed(this.client, lllllllllllIllIlIIlIllIllIlIllIl, lllllllllllIllIlIIlIllIllIlIllII)) {
                if (this.buttonA instanceof GuiOptionButton) {
                    this.client.gameSettings.setOptionValue(((GuiOptionButton)this.buttonA).returnEnumOptions(), 1);
                    this.buttonA.displayString = this.client.gameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(this.buttonA.id));
                }
                return true;
            }
            if (this.buttonB != null && this.buttonB.mousePressed(this.client, lllllllllllIllIlIIlIllIllIlIllIl, lllllllllllIllIlIIlIllIllIlIllII)) {
                if (this.buttonB instanceof GuiOptionButton) {
                    this.client.gameSettings.setOptionValue(((GuiOptionButton)this.buttonB).returnEnumOptions(), 1);
                    this.buttonB.displayString = this.client.gameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(this.buttonB.id));
                }
                return true;
            }
            return false;
        }
    }
}
