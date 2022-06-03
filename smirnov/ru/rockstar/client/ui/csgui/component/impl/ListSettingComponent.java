// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui.component.impl;

import ru.rockstar.client.ui.csgui.component.Component;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.settings.Setting;
import java.awt.Color;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.csgui.component.PropertyComponent;
import ru.rockstar.client.ui.csgui.component.ExpandableComponent;

public class ListSettingComponent extends ExpandableComponent implements PropertyComponent
{
    /* synthetic */ Minecraft mc;
    private final /* synthetic */ ListSetting listSetting;
    
    private void handleRender(final int lllllllllllllIlIlIIlIlIIIllIlIII, int lllllllllllllIlIlIIlIlIIIllIllIl, final int lllllllllllllIlIlIIlIlIIIllIIllI, final int lllllllllllllIlIlIIlIlIIIllIIlIl) {
        for (final String lllllllllllllIlIlIIlIlIIIllIlIlI : this.listSetting.modes) {
            if (!lllllllllllllIlIlIIlIlIIIllIlIlI.equalsIgnoreCase(this.listSetting.currentMode)) {
                this.mc.neverlose500_13.drawCenteredString(lllllllllllllIlIlIIlIlIIIllIlIlI, (float)(lllllllllllllIlIlIIlIlIIIllIlIII + 1 + lllllllllllllIlIlIIlIlIIIllIIllI / 2), lllllllllllllIlIlIIlIlIIIllIllIl + 2.5f, this.listSetting.currentMode.equals(lllllllllllllIlIlIIlIlIIIllIlIlI) ? lllllllllllllIlIlIIlIlIIIllIIlIl : Color.GRAY.getRGB());
                lllllllllllllIlIlIIlIlIIIllIllIl += 12;
            }
        }
    }
    
    @Override
    public int getHeightWithExpand() {
        return this.getHeight() + (this.listSetting.modes.toArray().length - 1) * 12;
    }
    
    @Override
    public Setting getSetting() {
        return this.listSetting;
    }
    
    @Override
    public void onPress(final int lllllllllllllIlIlIIlIlIIIlIIIlll, final int lllllllllllllIlIlIIlIlIIIlIIIllI, final int lllllllllllllIlIlIIlIlIIIlIIIlIl) {
    }
    
    @Override
    public boolean canExpand() {
        return this.listSetting.modes.toArray().length > 0;
    }
    
    private void handleClick(final int lllllllllllllIlIlIIlIlIIIlIllIIl, final int lllllllllllllIlIlIIlIlIIIlIlIIIl, final int lllllllllllllIlIlIIlIlIIIlIlIlll, int lllllllllllllIlIlIIlIlIIIlIIllll, final int lllllllllllllIlIlIIlIlIIIlIlIlIl) {
        for (final String lllllllllllllIlIlIIlIlIIIlIlIlII : this.listSetting.modes) {
            if (!lllllllllllllIlIlIIlIlIIIlIlIlII.equalsIgnoreCase(this.listSetting.currentMode)) {
                if (lllllllllllllIlIlIIlIlIIIlIllIIl >= lllllllllllllIlIlIIlIlIIIlIlIlll && lllllllllllllIlIlIIlIlIIIlIlIIIl >= lllllllllllllIlIlIIlIlIIIlIIllll && lllllllllllllIlIlIIlIlIIIlIllIIl <= lllllllllllllIlIlIIlIlIIIlIlIlll + lllllllllllllIlIlIIlIlIIIlIlIlIl && lllllllllllllIlIlIIlIlIIIlIlIIIl <= lllllllllllllIlIlIIlIlIIIlIIllll + 15 - 3) {
                    this.listSetting.setListMode(lllllllllllllIlIlIIlIlIIIlIlIlII);
                }
                lllllllllllllIlIlIIlIlIIIlIIllll += 12;
            }
        }
    }
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllllIlIlIIlIlIIlIIIllII, final int lllllllllllllIlIlIIlIlIIlIIIlIll, final int lllllllllllllIlIlIIlIlIIlIIIlIlI) {
        super.drawComponent(lllllllllllllIlIlIIlIlIIlIIIllII, lllllllllllllIlIlIIlIlIIlIIIlIll, lllllllllllllIlIlIIlIlIIlIIIlIlI);
        final int lllllllllllllIlIlIIlIlIIlIIlIlII = this.getX();
        final int lllllllllllllIlIlIIlIlIIlIIlIIll = this.getY();
        final int lllllllllllllIlIlIIlIlIIlIIlIIlI = this.getWidth();
        final int lllllllllllllIlIlIIlIlIIlIIlIIIl = this.getHeight();
        final String lllllllllllllIlIlIIlIlIIlIIlIIII = this.listSetting.currentMode;
        final int lllllllllllllIlIlIIlIlIIlIIIllll = lllllllllllllIlIlIIlIlIIlIIlIIll + 10;
        final int lllllllllllllIlIlIIlIlIIlIIIlllI = new Color(180, 180, 180).getRGB();
        this.mc.neverlose500_13.drawCenteredString(this.getName(), (float)(lllllllllllllIlIlIIlIlIIlIIlIlII + lllllllllllllIlIlIIlIlIIlIIlIIlI - 46), lllllllllllllIlIlIIlIlIIlIIlIIll + 3.5f, new Color(200, 200, 200).getRGB());
        Gui.drawRect(lllllllllllllIlIlIIlIlIIlIIlIlII + 2, lllllllllllllIlIlIIlIlIIlIIIllll, lllllllllllllIlIlIIlIlIIlIIlIlII + this.getWidth() - 2, (int)(lllllllllllllIlIlIIlIlIIlIIIllll + 9.5), new Color(20, 20, 20, 100).getRGB());
        Gui.drawRect(lllllllllllllIlIlIIlIlIIlIIlIlII + 1.5, lllllllllllllIlIlIIlIlIIlIIIllll + 0.5, lllllllllllllIlIlIIlIlIIlIIlIlII + this.getWidth() - 1.5, lllllllllllllIlIlIIlIlIIlIIIllll + 9, new Color(20, 20, 20, 100).getRGB());
        this.mc.neverlose500_15.drawCenteredString(lllllllllllllIlIlIIlIlIIlIIlIIII, (float)(lllllllllllllIlIlIIlIlIIlIIlIlII + lllllllllllllIlIlIIlIlIIlIIlIIlI / 2 + 1), lllllllllllllIlIlIIlIlIIlIIIllll + 2.5f, new Color(200, 200, 200).getRGB());
        this.mc.neverlose500_18.drawString(this.isExpanded() ? "<" : ">", (float)(lllllllllllllIlIlIIlIlIIlIIlIlII + lllllllllllllIlIlIIlIlIIlIIlIIlI - 1 - 8), (float)(lllllllllllllIlIlIIlIlIIlIIlIIll + lllllllllllllIlIlIIlIlIIlIIlIIIl - 9), new Color(200, 200, 200).getRGB());
        if (this.isExpanded()) {
            Gui.drawRect(lllllllllllllIlIlIIlIlIIlIIlIlII + 1, lllllllllllllIlIlIIlIlIIlIIlIIll + lllllllllllllIlIlIIlIlIIlIIlIIIl, lllllllllllllIlIlIIlIlIIlIIlIlII + lllllllllllllIlIlIIlIlIIlIIlIIlI - 1, lllllllllllllIlIlIIlIlIIlIIlIIll + this.getHeightWithExpand(), new Color(50, 50, 50, 100).getRGB());
            this.handleRender(lllllllllllllIlIlIIlIlIIlIIlIlII, lllllllllllllIlIlIIlIlIIlIIlIIll + this.getHeight() + 2, lllllllllllllIlIlIIlIlIIlIIlIIlI, lllllllllllllIlIlIIlIlIIlIIIlllI);
        }
    }
    
    public ListSettingComponent(final Component lllllllllllllIlIlIIlIlIIlIlIlIIl, final ListSetting lllllllllllllIlIlIIlIlIIlIlIlIII, final int lllllllllllllIlIlIIlIlIIlIlIIlll, final int lllllllllllllIlIlIIlIlIIlIlIIllI, final int lllllllllllllIlIlIIlIlIIlIlIIlIl, final int lllllllllllllIlIlIIlIlIIlIlIIlII) {
        super(lllllllllllllIlIlIIlIlIIlIlIlIIl, lllllllllllllIlIlIIlIlIIlIlIlIII.getName(), lllllllllllllIlIlIIlIlIIlIlIIlll, lllllllllllllIlIlIIlIlIIlIlIIllI, lllllllllllllIlIlIIlIlIIlIlIIlIl, lllllllllllllIlIlIIlIlIIlIlIIlII);
        this.mc = Minecraft.getMinecraft();
        this.listSetting = lllllllllllllIlIlIIlIlIIlIlIlIII;
    }
    
    @Override
    public void onMouseClick(final int lllllllllllllIlIlIIlIlIIIllllIIl, final int lllllllllllllIlIlIIlIlIIIlllllII, final int lllllllllllllIlIlIIlIlIIIlllIlll) {
        super.onMouseClick(lllllllllllllIlIlIIlIlIIIllllIIl, lllllllllllllIlIlIIlIlIIIlllllII, lllllllllllllIlIlIIlIlIIIlllIlll);
        if (this.isExpanded()) {
            this.handleClick(lllllllllllllIlIlIIlIlIIIllllIIl, lllllllllllllIlIlIIlIlIIIlllllII, this.getX(), this.getY() + this.getHeight() + 2, this.getWidth());
        }
    }
}
