// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui;

import net.minecraft.util.ResourceLocation;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClickGUI;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.csgui.component.ExpandableComponent;
import ru.rockstar.client.ui.csgui.component.impl.ModuleComponent;
import ru.rockstar.Main;
import ru.rockstar.client.ui.csgui.component.Component;
import ru.rockstar.client.ui.csgui.component.AnimationState;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;
import java.util.List;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.csgui.component.DraggablePanel;

public final class Panel extends DraggablePanel
{
    private /* synthetic */ int prevY;
    private /* synthetic */ int prevX;
    /* synthetic */ Minecraft mc;
    private final /* synthetic */ List<Feature> features;
    public /* synthetic */ Category type;
    private /* synthetic */ boolean dragging;
    public /* synthetic */ AnimationState state;
    
    public Panel(final Category lllllllllllllIIllllIIlIllIIIllll, final int lllllllllllllIIllllIIlIllIIIlllI, final int lllllllllllllIIllllIIlIllIIIIlll) {
        super(null, lllllllllllllIIllllIIlIllIIIllll.name(), lllllllllllllIIllllIIlIllIIIlllI, lllllllllllllIIllllIIlIllIIIIlll, 100, 17);
        this.mc = Minecraft.getMinecraft();
        int lllllllllllllIIllllIIlIllIIIllII = 17;
        this.state = AnimationState.STATIC;
        this.features = Main.featureDirector.getFeaturesForCategory(lllllllllllllIIllllIIlIllIIIllll);
        for (final Feature lllllllllllllIIllllIIlIllIIIlIll : this.features) {
            this.components.add(new ModuleComponent(this, lllllllllllllIIllllIIlIllIIIlIll, 1, lllllllllllllIIllllIIlIllIIIllII, 98, 15));
            lllllllllllllIIllllIIlIllIIIllII += 15;
        }
        this.type = lllllllllllllIIllllIIlIllIIIllll;
    }
    
    @Override
    public void onPress(final int lllllllllllllIIllllIIlIlIIllllIl, final int lllllllllllllIIllllIIlIlIIlllIII, final int lllllllllllllIIllllIIlIlIIlllIll) {
        if (lllllllllllllIIllllIIlIlIIlllIll == 0 && !this.dragging) {
            this.dragging = true;
            this.prevX = lllllllllllllIIllllIIlIlIIllllIl - this.getX();
            this.prevY = lllllllllllllIIllllIIlIlIIlllIII - this.getY();
        }
    }
    
    @Override
    public boolean canExpand() {
        return !this.features.isEmpty();
    }
    
    static {
        HEADER_HEIGHT = 17;
        X_ITEM_OFFSET = 1;
        ITEM_HEIGHT = 15;
        HEADER_WIDTH = 100;
    }
    
    @Override
    public void onMouseRelease(final int lllllllllllllIIllllIIlIlIIllIIll) {
        super.onMouseRelease(lllllllllllllIIllllIIlIlIIllIIll);
        this.dragging = false;
    }
    
    @Override
    public int getHeightWithExpand() {
        int lllllllllllllIIllllIIlIlIIlIIllI = this.getHeight();
        if (this.isExpanded()) {
            for (final Component lllllllllllllIIllllIIlIlIIlIIlIl : this.components) {
                int lllllllllllllIIllllIIlIlIIlIIlII = lllllllllllllIIllllIIlIlIIlIIlIl.getHeight();
                if (lllllllllllllIIllllIIlIlIIlIIlIl instanceof ExpandableComponent) {
                    final ExpandableComponent lllllllllllllIIllllIIlIlIIlIIIll = (ExpandableComponent)lllllllllllllIIllllIIlIlIIlIIlIl;
                    if (lllllllllllllIIllllIIlIlIIlIIIll.isExpanded()) {
                        lllllllllllllIIllllIIlIlIIlIIlII = lllllllllllllIIllllIIlIlIIlIIIll.getHeightWithExpand() + 5;
                    }
                }
                lllllllllllllIIllllIIlIlIIlIIllI += lllllllllllllIIllllIIlIlIIlIIlII;
            }
        }
        return lllllllllllllIIllllIIlIlIIlIIllI;
    }
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllllIIllllIIlIlIlIlIlll, final int lllllllllllllIIllllIIlIlIlIlIllI, final int lllllllllllllIIllllIIlIlIllIlIlI) {
        int lllllllllllllIIllllIIlIlIllIlIIl = 0;
        final int lllllllllllllIIllllIIlIlIllIlIII = this.getX();
        final int lllllllllllllIIllllIIlIlIllIIlll = this.getY();
        final Color lllllllllllllIIllllIIlIlIllIIllI = new Color(ClickGUI.color.getColorValue());
        final Color lllllllllllllIIllllIIlIlIllIIlIl = new Color(ClickGUI.colorTwo.getColorValue());
        final double lllllllllllllIIllllIIlIlIllIIlII = ClickGUI.speed.getNumberValue();
        final Exception lllllllllllllIIllllIIlIlIlIIlllI;
        switch (lllllllllllllIIllllIIlIlIlIIlllI = (Exception)ClickGUI.clickGuiColor.currentMode) {
            case "Rainbow": {
                lllllllllllllIIllllIIlIlIllIlIIl = DrawHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                break;
            }
            case "Color Two": {
                lllllllllllllIIllllIIlIlIllIlIIl = DrawHelper.fadeColor(lllllllllllllIIllllIIlIlIllIIllI.getRGB(), lllllllllllllIIllllIIlIlIllIIlIl.getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllllIIllllIIlIlIllIIlII / lllllllllllllIIllllIIlIlIllIIlII + lllllllllllllIIllllIIlIlIllIIlll * 6L / 60L * 2L) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                lllllllllllllIIllllIIlIlIllIlIIl = DrawHelper.fadeColor(lllllllllllllIIllllIIlIlIllIIllI.getRGB(), lllllllllllllIIllllIIlIlIllIIllI.darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllllIIllllIIlIlIllIIlII / lllllllllllllIIllllIIlIlIllIIlII + lllllllllllllIIllllIIlIlIllIIlll * 6L / 60L * 2L) % 2.0 - 1.0));
                break;
            }
            case "Category": {
                final Panel lllllllllllllIIllllIIlIlIllIIIll = (Panel)this.parent;
                lllllllllllllIIllllIIlIlIllIlIIl = lllllllllllllIIllllIIlIlIllIIIll.type.getColor();
                break;
            }
            case "Astolfo": {
                lllllllllllllIIllllIIlIlIllIlIIl = DrawHelper.astolfo(true, lllllllllllllIIllllIIlIlIllIIlll).getRGB();
                break;
            }
            case "Client": {
                lllllllllllllIIllllIIlIlIllIlIIl = DrawHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllllIIllllIIlIlIllIIlII / lllllllllllllIIllllIIlIlIllIIlII + lllllllllllllIIllllIIlIlIllIIlll * 6L / 60L * 2L) % 2.0 - 1.0));
                break;
            }
            default:
                break;
        }
        if (this.dragging) {
            this.setX(lllllllllllllIIllllIIlIlIlIlIllI - this.prevX);
            this.setY(lllllllllllllIIllllIIlIlIllIlIlI - this.prevY);
        }
        final int lllllllllllllIIllllIIlIlIllIIIlI = this.getWidth();
        int lllllllllllllIIllllIIlIlIllIIIIl = this.getHeight();
        final int lllllllllllllIIllllIIlIlIlIlllll = this.getHeightWithExpand();
        final int lllllllllllllIIllllIIlIlIllIIIII = this.isExpanded() ? lllllllllllllIIllllIIlIlIlIlllll : lllllllllllllIIllllIIlIlIllIIIIl;
        final float lllllllllllllIIllllIIlIlIlIllllI = 2.0f;
        final int lllllllllllllIIllllIIlIlIlIlllIl = 0;
        final String lllllllllllllIIllllIIlIlIlIlllII = ClickGUI.style.getOptions();
        DrawHelper.drawSmoothRect((float)(lllllllllllllIIllllIIlIlIllIlIII + 7), (float)(lllllllllllllIIllllIIlIlIllIIlll + 13), (float)(lllllllllllllIIllllIIlIlIllIlIII + lllllllllllllIIllllIIlIlIllIIIlI - 7), lllllllllllllIIllllIIlIlIllIIlll + lllllllllllllIIllllIIlIlIllIIIII - lllllllllllllIIllllIIlIlIlIllllI + 3.0f, new Color(0, 0, 0, 185).getRGB());
        DrawHelper.drawGradientRect1(lllllllllllllIIllllIIlIlIllIlIII + 5, lllllllllllllIIllllIIlIlIllIIlll + lllllllllllllIIllllIIlIlIllIIIII - lllllllllllllIIllllIIlIlIlIllllI + 1.3f - 4.0f + 3.0f, lllllllllllllIIllllIIlIlIllIlIII + lllllllllllllIIllllIIlIlIllIIIlI - 5, lllllllllllllIIllllIIlIlIllIIlll + lllllllllllllIIllllIIlIlIllIIIII - lllllllllllllIIllllIIlIlIlIllllI + 3.0f, lllllllllllllIIllllIIlIlIllIlIIl, lllllllllllllIIllllIIlIlIllIlIIl - 70);
        DrawHelper.drawGradientRect(lllllllllllllIIllllIIlIlIllIlIII + 5, lllllllllllllIIllllIIlIlIllIIlll + 3, lllllllllllllIIllllIIlIlIllIlIII + lllllllllllllIIllllIIlIlIllIIIlI - 5, lllllllllllllIIllllIIlIlIllIIlll + 15 - 2, new Color(25, 25, 25, 255).getRGB(), new Color(0, 0, 0, 255).getRGB());
        this.mc.mntsb_16.drawStringWithShadow(this.getName(), lllllllllllllIIllllIIlIlIllIlIII + 15, lllllllllllllIIllllIIlIlIllIIlll + 8.5f - 2.5f, Color.LIGHT_GRAY.getRGB());
        DrawHelper.drawImage(new ResourceLocation("rockstar/icons/" + this.type.getName() + ".png"), (float)(lllllllllllllIIllllIIlIlIllIlIII + 5), (float)(lllllllllllllIIllllIIlIlIllIIlll + 3), 10.0f, 10.0f, Color.LIGHT_GRAY);
        super.drawComponent(lllllllllllllIIllllIIlIlIlIlIlll, lllllllllllllIIllllIIlIlIlIlIllI, lllllllllllllIIllllIIlIlIllIlIlI);
        if (this.isExpanded()) {
            for (final Component lllllllllllllIIllllIIlIlIlIllIll : this.components) {
                lllllllllllllIIllllIIlIlIlIllIll.setY(lllllllllllllIIllllIIlIlIllIIIIl);
                lllllllllllllIIllllIIlIlIlIllIll.drawComponent(lllllllllllllIIllllIIlIlIlIlIlll, lllllllllllllIIllllIIlIlIlIlIllI, lllllllllllllIIllllIIlIlIllIlIlI);
                int lllllllllllllIIllllIIlIlIlIllIlI = lllllllllllllIIllllIIlIlIlIllIll.getHeight();
                if (lllllllllllllIIllllIIlIlIlIllIll instanceof ExpandableComponent) {
                    final ExpandableComponent lllllllllllllIIllllIIlIlIlIllIIl = (ExpandableComponent)lllllllllllllIIllllIIlIlIlIllIll;
                    if (lllllllllllllIIllllIIlIlIlIllIIl.isExpanded()) {
                        lllllllllllllIIllllIIlIlIlIllIlI = lllllllllllllIIllllIIlIlIlIllIIl.getHeightWithExpand() + 5;
                    }
                }
                lllllllllllllIIllllIIlIlIllIIIIl += lllllllllllllIIllllIIlIlIlIllIlI;
            }
        }
    }
}
