// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui.component.impl;

import net.minecraft.client.gui.Gui;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.ui.clickgui.component.Component;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.clickgui.component.PropertyComponent;
import ru.rockstar.client.ui.clickgui.component.ExpandableComponent;

public class ListSettingComponent extends ExpandableComponent implements PropertyComponent
{
    private final /* synthetic */ ListSetting listSetting;
    /* synthetic */ Minecraft mc;
    
    public ListSettingComponent(final Component lllllllllllIllIIllllllIllIlllIII, final ListSetting lllllllllllIllIIllllllIllIllIlll, final int lllllllllllIllIIllllllIllIlIllll, final int lllllllllllIllIIllllllIllIlIlllI, final int lllllllllllIllIIllllllIllIlIllIl, final int lllllllllllIllIIllllllIllIllIIll) {
        super(lllllllllllIllIIllllllIllIlllIII, lllllllllllIllIIllllllIllIllIlll.getName(), lllllllllllIllIIllllllIllIlIllll, lllllllllllIllIIllllllIllIlIlllI, lllllllllllIllIIllllllIllIlIllIl, lllllllllllIllIIllllllIllIllIIll);
        this.mc = Minecraft.getMinecraft();
        this.listSetting = lllllllllllIllIIllllllIllIllIlll;
    }
    
    @Override
    public Setting getSetting() {
        return this.listSetting;
    }
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllIllIIllllllIllIIlIlII, final int lllllllllllIllIIllllllIllIIllllI, final int lllllllllllIllIIllllllIllIIlllIl) {
        super.drawComponent(lllllllllllIllIIllllllIllIIlIlII, lllllllllllIllIIllllllIllIIllllI, lllllllllllIllIIllllllIllIIlllIl);
        final int lllllllllllIllIIllllllIllIIlllII = this.getX();
        final int lllllllllllIllIIllllllIllIIllIll = this.getY();
        final int lllllllllllIllIIllllllIllIIllIlI = this.getWidth();
        final int lllllllllllIllIIllllllIllIIllIIl = this.getHeight();
        final String lllllllllllIllIIllllllIllIIllIII = this.listSetting.currentMode;
        final int lllllllllllIllIIllllllIllIIlIlll = lllllllllllIllIIllllllIllIIllIll + 10;
        final int lllllllllllIllIIllllllIllIIlIllI = new Color(180, 180, 180).getRGB();
        this.mc.neverlose500_13.drawCenteredString(this.getName(), (float)(lllllllllllIllIIllllllIllIIlllII + lllllllllllIllIIllllllIllIIllIlI - 46), lllllllllllIllIIllllllIllIIllIll + 3.5f, new Color(200, 200, 200).getRGB());
        Gui.drawRect(lllllllllllIllIIllllllIllIIlllII + 2, lllllllllllIllIIllllllIllIIlIlll, lllllllllllIllIIllllllIllIIlllII + this.getWidth() - 2, (int)(lllllllllllIllIIllllllIllIIlIlll + 9.5), new Color(20, 20, 20, 100).getRGB());
        Gui.drawRect(lllllllllllIllIIllllllIllIIlllII + 1.5, lllllllllllIllIIllllllIllIIlIlll + 0.5, lllllllllllIllIIllllllIllIIlllII + this.getWidth() - 1.5, lllllllllllIllIIllllllIllIIlIlll + 9, new Color(20, 20, 20, 100).getRGB());
        this.mc.neverlose500_15.drawCenteredString(lllllllllllIllIIllllllIllIIllIII, (float)(lllllllllllIllIIllllllIllIIlllII + lllllllllllIllIIllllllIllIIllIlI / 2 + 1), lllllllllllIllIIllllllIllIIlIlll + 2.5f, new Color(200, 200, 200).getRGB());
        this.mc.neverlose500_18.drawString(this.isExpanded() ? "<" : ">", (float)(lllllllllllIllIIllllllIllIIlllII + lllllllllllIllIIllllllIllIIllIlI - 1 - 8), (float)(lllllllllllIllIIllllllIllIIllIll + lllllllllllIllIIllllllIllIIllIIl - 9), new Color(200, 200, 200).getRGB());
        if (this.isExpanded()) {
            Gui.drawRect(lllllllllllIllIIllllllIllIIlllII + 1, lllllllllllIllIIllllllIllIIllIll + lllllllllllIllIIllllllIllIIllIIl, lllllllllllIllIIllllllIllIIlllII + lllllllllllIllIIllllllIllIIllIlI - 1, lllllllllllIllIIllllllIllIIllIll + this.getHeightWithExpand(), new Color(50, 50, 50, 100).getRGB());
            this.handleRender(lllllllllllIllIIllllllIllIIlllII, lllllllllllIllIIllllllIllIIllIll + this.getHeight() + 2, lllllllllllIllIIllllllIllIIllIlI, lllllllllllIllIIllllllIllIIlIllI);
        }
    }
    
    private void handleRender(final int lllllllllllIllIIllllllIlIlllIllI, int lllllllllllIllIIllllllIlIlllIlIl, final int lllllllllllIllIIllllllIlIlllIlII, final int lllllllllllIllIIllllllIlIlllIIll) {
        for (final String lllllllllllIllIIllllllIlIlllIIlI : this.listSetting.modes) {
            if (!lllllllllllIllIIllllllIlIlllIIlI.equalsIgnoreCase(this.listSetting.currentMode)) {
                this.mc.neverlose500_13.drawCenteredString(lllllllllllIllIIllllllIlIlllIIlI, (float)(lllllllllllIllIIllllllIlIlllIllI + 1 + lllllllllllIllIIllllllIlIlllIlII / 2), lllllllllllIllIIllllllIlIlllIlIl + 2.5f, this.listSetting.currentMode.equals(lllllllllllIllIIllllllIlIlllIIlI) ? lllllllllllIllIIllllllIlIlllIIll : Color.GRAY.getRGB());
                lllllllllllIllIIllllllIlIlllIlIl += 12;
            }
        }
    }
    
    @Override
    public int getHeightWithExpand() {
        return this.getHeight() + (this.listSetting.modes.toArray().length - 1) * 12;
    }
    
    private void handleClick(final int lllllllllllIllIIllllllIlIllIIIIl, final int lllllllllllIllIIllllllIlIllIIIII, final int lllllllllllIllIIllllllIlIlIllIII, int lllllllllllIllIIllllllIlIlIlIlll, final int lllllllllllIllIIllllllIlIlIlIllI) {
        for (final String lllllllllllIllIIllllllIlIlIlllII : this.listSetting.modes) {
            if (!lllllllllllIllIIllllllIlIlIlllII.equalsIgnoreCase(this.listSetting.currentMode)) {
                if (lllllllllllIllIIllllllIlIllIIIIl >= lllllllllllIllIIllllllIlIlIllIII && lllllllllllIllIIllllllIlIllIIIII >= lllllllllllIllIIllllllIlIlIlIlll && lllllllllllIllIIllllllIlIllIIIIl <= lllllllllllIllIIllllllIlIlIllIII + lllllllllllIllIIllllllIlIlIlIllI && lllllllllllIllIIllllllIlIllIIIII <= lllllllllllIllIIllllllIlIlIlIlll + 15 - 3) {
                    this.listSetting.setListMode(lllllllllllIllIIllllllIlIlIlllII);
                }
                lllllllllllIllIIllllllIlIlIlIlll += 12;
            }
        }
    }
    
    @Override
    public void onMouseClick(final int lllllllllllIllIIllllllIllIIIIIIl, final int lllllllllllIllIIllllllIllIIIIlII, final int lllllllllllIllIIllllllIlIlllllll) {
        super.onMouseClick(lllllllllllIllIIllllllIllIIIIIIl, lllllllllllIllIIllllllIllIIIIlII, lllllllllllIllIIllllllIlIlllllll);
        if (this.isExpanded()) {
            this.handleClick(lllllllllllIllIIllllllIllIIIIIIl, lllllllllllIllIIllllllIllIIIIlII, this.getX(), this.getY() + this.getHeight() + 2, this.getWidth());
        }
    }
    
    @Override
    public void onPress(final int lllllllllllIllIIllllllIlIlIIllll, final int lllllllllllIllIIllllllIlIlIIlllI, final int lllllllllllIllIIllllllIlIlIIllIl) {
    }
    
    @Override
    public boolean canExpand() {
        return this.listSetting.modes.toArray().length > 0;
    }
}
