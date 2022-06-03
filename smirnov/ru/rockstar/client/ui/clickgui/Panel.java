// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui;

import ru.rockstar.client.ui.clickgui.component.impl.ModuleComponent;
import ru.rockstar.Main;
import ru.rockstar.client.ui.clickgui.component.ExpandableComponent;
import ru.rockstar.client.ui.clickgui.component.Component;
import net.minecraft.util.ResourceLocation;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClickGUI;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.clickgui.component.AnimationState;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.features.Feature;
import java.util.List;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.clickgui.component.DraggablePanel;

public final class Panel extends DraggablePanel
{
    public /* synthetic */ Category type;
    private final /* synthetic */ List<Feature> features;
    /* synthetic */ Minecraft mc;
    public /* synthetic */ AnimationState state;
    private /* synthetic */ int prevX;
    private /* synthetic */ boolean dragging;
    private /* synthetic */ int prevY;
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllllIlIIllIlIlIllIlIIII, final int lllllllllllllIlIIllIlIlIlIlllIlI, final int lllllllllllllIlIIllIlIlIllIIlllI) {
        int lllllllllllllIlIIllIlIlIllIIllIl = 0;
        final int lllllllllllllIlIIllIlIlIllIIllII = this.getX();
        final int lllllllllllllIlIIllIlIlIllIIlIll = this.getY();
        final Color lllllllllllllIlIIllIlIlIllIIlIlI = new Color(ClickGUI.color.getColorValue());
        final Color lllllllllllllIlIIllIlIlIllIIlIIl = new Color(ClickGUI.colorTwo.getColorValue());
        final double lllllllllllllIlIIllIlIlIllIIlIII = ClickGUI.speed.getNumberValue();
        final Exception lllllllllllllIlIIllIlIlIlIllIIlI;
        switch (lllllllllllllIlIIllIlIlIlIllIIlI = (Exception)ClickGUI.clickGuiColor.currentMode) {
            case "Rainbow": {
                lllllllllllllIlIIllIlIlIllIIllIl = DrawHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                break;
            }
            case "Color Two": {
                lllllllllllllIlIIllIlIlIllIIllIl = DrawHelper.fadeColor(lllllllllllllIlIIllIlIlIllIIlIlI.getRGB(), lllllllllllllIlIIllIlIlIllIIlIIl.getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllllIlIIllIlIlIllIIlIII / lllllllllllllIlIIllIlIlIllIIlIII + lllllllllllllIlIIllIlIlIllIIlIll * 6L / 60L * 2L) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                lllllllllllllIlIIllIlIlIllIIllIl = DrawHelper.fadeColor(lllllllllllllIlIIllIlIlIllIIlIlI.getRGB(), lllllllllllllIlIIllIlIlIllIIlIlI.darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllllIlIIllIlIlIllIIlIII / lllllllllllllIlIIllIlIlIllIIlIII + lllllllllllllIlIIllIlIlIllIIlIll * 6L / 60L * 2L) % 2.0 - 1.0));
                break;
            }
            case "Category": {
                final Panel lllllllllllllIlIIllIlIlIllIIIlll = (Panel)this.parent;
                lllllllllllllIlIIllIlIlIllIIllIl = lllllllllllllIlIIllIlIlIllIIIlll.type.getColor();
                break;
            }
            case "Astolfo": {
                lllllllllllllIlIIllIlIlIllIIllIl = DrawHelper.astolfo(true, lllllllllllllIlIIllIlIlIllIIlIll).getRGB();
                break;
            }
            case "Client": {
                lllllllllllllIlIIllIlIlIllIIllIl = DrawHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllllIlIIllIlIlIllIIlIII / lllllllllllllIlIIllIlIlIllIIlIII + lllllllllllllIlIIllIlIlIllIIlIll * 6L / 60L * 2L) % 2.0 - 1.0));
                break;
            }
            default:
                break;
        }
        if (this.dragging) {
            this.setX(lllllllllllllIlIIllIlIlIlIlllIlI - this.prevX);
            this.setY(lllllllllllllIlIIllIlIlIllIIlllI - this.prevY);
        }
        final int lllllllllllllIlIIllIlIlIllIIIllI = this.getWidth();
        int lllllllllllllIlIIllIlIlIllIIIlIl = this.getHeight();
        final int lllllllllllllIlIIllIlIlIllIIIIll = this.getHeightWithExpand();
        final int lllllllllllllIlIIllIlIlIllIIIlII = this.isExpanded() ? lllllllllllllIlIIllIlIlIllIIIIll : lllllllllllllIlIIllIlIlIllIIIlIl;
        final float lllllllllllllIlIIllIlIlIllIIIIlI = 2.0f;
        final int lllllllllllllIlIIllIlIlIllIIIIIl = 0;
        final String lllllllllllllIlIIllIlIlIllIIIIII = ClickGUI.style.getOptions();
        if (lllllllllllllIlIIllIlIlIllIIIIII.equalsIgnoreCase("Rockstar")) {
            DrawHelper.drawSmoothRect((float)(lllllllllllllIlIIllIlIlIllIIllII + 3), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 13), (float)(lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 3), lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, new Color(20, 20, 20, 255).getRGB());
            DrawHelper.drawGradientRect1(lllllllllllllIlIIllIlIlIllIIllII + 2, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI + 1.3f - 4.0f, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 2, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, lllllllllllllIlIIllIlIlIllIIllIl, lllllllllllllIlIIllIlIlIllIIllIl - 70);
            DrawHelper.drawGradientRect1(lllllllllllllIlIIllIlIlIllIIllII - 1, lllllllllllllIlIIllIlIlIllIIlIll + 1, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI + 1, lllllllllllllIlIIllIlIlIllIIlIll + 18 - 4, lllllllllllllIlIIllIlIlIllIIllIl, lllllllllllllIlIIllIlIlIllIIllIl - 70);
            this.mc.mntsb_17.drawStringWithShadow(this.getName(), lllllllllllllIlIIllIlIlIllIIllII + 3, lllllllllllllIlIIllIlIlIllIIlIll + 8.5f - 3.5f, Color.WHITE.getRGB());
            DrawHelper.drawImage(new ResourceLocation("rockstar/icons/" + this.type.getName() + ".png"), (float)(lllllllllllllIlIIllIlIlIllIIllII + 88), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 3), 10.0f, 10.0f, Color.WHITE);
        }
        if (lllllllllllllIlIIllIlIlIllIIIIII.equalsIgnoreCase("Default Dark")) {
            DrawHelper.drawSmoothRect((float)(lllllllllllllIlIIllIlIlIllIIllII + 3), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 13), (float)(lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 3), lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, new Color(0, 0, 0, 185).getRGB());
            DrawHelper.drawGradientRect1(lllllllllllllIlIIllIlIlIllIIllII + 2, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI + 1.3f - 4.0f, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 2, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, lllllllllllllIlIIllIlIlIllIIllIl, lllllllllllllIlIIllIlIlIllIIllIl - 70);
            DrawHelper.drawGradientRect(lllllllllllllIlIIllIlIlIllIIllII - 1, lllllllllllllIlIIllIlIlIllIIlIll + 1, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI + 1, lllllllllllllIlIIllIlIlIllIIlIll + 18 - 4, new Color(25, 25, 25, 255).getRGB(), new Color(0, 0, 0, 255).getRGB());
            this.mc.mntsb_17.drawStringWithShadow(this.getName(), lllllllllllllIlIIllIlIlIllIIllII + 12, lllllllllllllIlIIllIlIlIllIIlIll + 8.5f - 3.5f, Color.LIGHT_GRAY.getRGB());
            DrawHelper.drawImage(new ResourceLocation("rockstar/icons/" + this.type.getName() + ".png"), (float)(lllllllllllllIlIIllIlIlIllIIllII + 1), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 3), 10.0f, 10.0f, Color.LIGHT_GRAY);
        }
        if (lllllllllllllIlIIllIlIlIllIIIIII.equalsIgnoreCase("Default Light")) {
            DrawHelper.drawSmoothRect((float)(lllllllllllllIlIIllIlIlIllIIllII + 3), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 13), (float)(lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 3), lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, new Color(255, 255, 255, 200).getRGB());
            DrawHelper.drawGradientRect1(lllllllllllllIlIIllIlIlIllIIllII + 2, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI + 1.3f - 4.0f, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 2, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, lllllllllllllIlIIllIlIlIllIIllIl, lllllllllllllIlIIllIlIlIllIIllIl - 70);
            DrawHelper.drawGradientRect(lllllllllllllIlIIllIlIlIllIIllII - 1, lllllllllllllIlIIllIlIlIllIIlIll + 1, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI + 1, lllllllllllllIlIIllIlIlIllIIlIll + 18 - 4, new Color(200, 200, 200, 255).getRGB(), new Color(255, 255, 255, 255).getRGB());
            this.mc.mntsb_17.drawStringWithShadow(this.getName(), lllllllllllllIlIIllIlIlIllIIllII + 12, lllllllllllllIlIIllIlIlIllIIlIll + 8.5f - 3.5f, Color.LIGHT_GRAY.getRGB());
            DrawHelper.drawImage(new ResourceLocation("rockstar/icons/" + this.type.getName() + ".png"), (float)(lllllllllllllIlIIllIlIlIllIIllII + 1), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 3), 10.0f, 10.0f, Color.LIGHT_GRAY);
        }
        if (lllllllllllllIlIIllIlIlIllIIIIII.equalsIgnoreCase("NeverLose")) {
            DrawHelper.drawSmoothRect((float)(lllllllllllllIlIIllIlIlIllIIllII + 3), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 14), (float)(lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 3), lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, new Color(0, 10, 20, 255).getRGB());
            DrawHelper.drawGradientRect(lllllllllllllIlIIllIlIlIllIIllII - 1, lllllllllllllIlIIllIlIlIllIIlIll + 1, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI + 1, lllllllllllllIlIIllIlIlIllIIlIll + 18 - 4, new Color(0, 60, 90, 200).getRGB(), new Color(0, 60, 90, 200).getRGB());
            this.mc.mntsb_17.drawStringWithShadow(this.getName(), lllllllllllllIlIIllIlIlIllIIllII + 12, lllllllllllllIlIIllIlIlIllIIlIll + 8.5f - 3.5f, Color.WHITE.getRGB());
            DrawHelper.drawImage(new ResourceLocation("rockstar/icons/" + this.type.getName() + ".png"), (float)(lllllllllllllIlIIllIlIlIllIIllII + 1), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 3), 10.0f, 10.0f, new Color(0, 200, 255, 255));
        }
        if (lllllllllllllIlIIllIlIlIllIIIIII.equalsIgnoreCase("Clear")) {
            DrawHelper.drawGradientRect1(lllllllllllllIlIIllIlIlIllIIllII + 1, lllllllllllllIlIIllIlIlIllIIlIll + 14, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 97, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, new Color(0, 0, 0, 0).getRGB(), new Color(0, 0, 0, 255).getRGB());
            DrawHelper.drawGradientRect1(lllllllllllllIlIIllIlIlIllIIllII + 98, lllllllllllllIlIIllIlIlIllIIlIll + 14, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, new Color(0, 0, 0, 255).getRGB(), new Color(0, 0, 0, 0).getRGB());
            DrawHelper.drawGradientRect(lllllllllllllIlIIllIlIlIllIIllII + 2, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 2, lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI + 2.0f, new Color(0, 0, 0, 255).getRGB(), new Color(0, 0, 0, 0).getRGB());
            DrawHelper.drawGradientRect(lllllllllllllIlIIllIlIlIllIIllII - 1, lllllllllllllIlIIllIlIlIllIIlIll + 1, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI + 1, lllllllllllllIlIIllIlIlIllIIlIll + 18 - 4, new Color(0, 0, 0, 255).getRGB(), new Color(60, 60, 60, 255).getRGB());
            this.mc.mntsb_17.drawStringWithShadow(this.getName(), lllllllllllllIlIIllIlIlIllIIllII + 12, lllllllllllllIlIIllIlIlIllIIlIll + 8.5f - 3.5f, Color.LIGHT_GRAY.getRGB());
            DrawHelper.drawImage(new ResourceLocation("rockstar/icons/" + this.type.getName() + ".png"), (float)(lllllllllllllIlIIllIlIlIllIIllII + 1), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 3), 10.0f, 10.0f, Color.LIGHT_GRAY);
        }
        if (lllllllllllllIlIIllIlIlIllIIIIII.equalsIgnoreCase("Dark")) {
            DrawHelper.drawSmoothRect((float)(lllllllllllllIlIIllIlIlIllIIllII + 3), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 14), (float)(lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 3), lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, new Color(20, 20, 20, 255).getRGB());
            DrawHelper.drawGradientRect(lllllllllllllIlIIllIlIlIllIIllII - 1, lllllllllllllIlIIllIlIlIllIIlIll + 1, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI + 1, lllllllllllllIlIIllIlIlIllIIlIll + 18 - 4, new Color(0, 0, 0, 200).getRGB(), new Color(20, 20, 20, 200).getRGB());
            this.mc.mntsb_17.drawStringWithShadow(this.getName(), lllllllllllllIlIIllIlIlIllIIllII + 12, lllllllllllllIlIIllIlIlIllIIlIll + 8.5f - 3.5f, Color.LIGHT_GRAY.getRGB());
            DrawHelper.drawImage(new ResourceLocation("rockstar/icons/" + this.type.getName() + ".png"), (float)(lllllllllllllIlIIllIlIlIllIIllII + 1), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 3), 10.0f, 10.0f, Color.LIGHT_GRAY);
        }
        if (lllllllllllllIlIIllIlIlIllIIIIII.equalsIgnoreCase("Light")) {
            DrawHelper.drawSmoothRect((float)(lllllllllllllIlIIllIlIlIllIIllII + 3), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 14), (float)(lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI - 3), lllllllllllllIlIIllIlIlIllIIlIll + lllllllllllllIlIIllIlIlIllIIIlII - lllllllllllllIlIIllIlIlIllIIIIlI, new Color(255, 255, 255, 255).getRGB());
            DrawHelper.drawGradientRect(lllllllllllllIlIIllIlIlIllIIllII - 1, lllllllllllllIlIIllIlIlIllIIlIll + 1, lllllllllllllIlIIllIlIlIllIIllII + lllllllllllllIlIIllIlIlIllIIIllI + 1, lllllllllllllIlIIllIlIlIllIIlIll + 18 - 4, new Color(245, 245, 245, 250).getRGB(), new Color(245, 245, 245, 250).getRGB());
            this.mc.mntsb_17.drawStringWithShadow(this.getName(), lllllllllllllIlIIllIlIlIllIIllII + 12, lllllllllllllIlIIllIlIlIllIIlIll + 8.5f - 3.5f, Color.LIGHT_GRAY.getRGB());
            DrawHelper.drawImage(new ResourceLocation("rockstar/icons/" + this.type.getName() + ".png"), (float)(lllllllllllllIlIIllIlIlIllIIllII + 1), (float)(lllllllllllllIlIIllIlIlIllIIlIll + 3), 10.0f, 10.0f, Color.LIGHT_GRAY);
        }
        super.drawComponent(lllllllllllllIlIIllIlIlIllIlIIII, lllllllllllllIlIIllIlIlIlIlllIlI, lllllllllllllIlIIllIlIlIllIIlllI);
        if (this.isExpanded()) {
            for (final Component lllllllllllllIlIIllIlIlIlIllllll : this.components) {
                lllllllllllllIlIIllIlIlIlIllllll.setY(lllllllllllllIlIIllIlIlIllIIIlIl);
                lllllllllllllIlIIllIlIlIlIllllll.drawComponent(lllllllllllllIlIIllIlIlIllIlIIII, lllllllllllllIlIIllIlIlIlIlllIlI, lllllllllllllIlIIllIlIlIllIIlllI);
                int lllllllllllllIlIIllIlIlIlIlllllI = lllllllllllllIlIIllIlIlIlIllllll.getHeight();
                if (lllllllllllllIlIIllIlIlIlIllllll instanceof ExpandableComponent) {
                    final ExpandableComponent lllllllllllllIlIIllIlIlIlIllllIl = (ExpandableComponent)lllllllllllllIlIIllIlIlIlIllllll;
                    if (lllllllllllllIlIIllIlIlIlIllllIl.isExpanded()) {
                        lllllllllllllIlIIllIlIlIlIlllllI = lllllllllllllIlIIllIlIlIlIllllIl.getHeightWithExpand() + 5;
                    }
                }
                lllllllllllllIlIIllIlIlIllIIIlIl += lllllllllllllIlIIllIlIlIlIlllllI;
            }
        }
    }
    
    @Override
    public boolean canExpand() {
        return !this.features.isEmpty();
    }
    
    public Panel(final Category lllllllllllllIlIIllIlIlIllllIIll, final int lllllllllllllIlIIllIlIlIlllIllII, final int lllllllllllllIlIIllIlIlIlllIlIll) {
        super(null, lllllllllllllIlIIllIlIlIllllIIll.name(), lllllllllllllIlIIllIlIlIlllIllII, lllllllllllllIlIIllIlIlIlllIlIll, 100, 17);
        this.mc = Minecraft.getMinecraft();
        int lllllllllllllIlIIllIlIlIllllIIII = 17;
        this.state = AnimationState.STATIC;
        this.features = Main.featureDirector.getFeaturesForCategory(lllllllllllllIlIIllIlIlIllllIIll);
        for (final Feature lllllllllllllIlIIllIlIlIlllIllll : this.features) {
            this.components.add(new ModuleComponent(this, lllllllllllllIlIIllIlIlIlllIllll, 1, lllllllllllllIlIIllIlIlIllllIIII, 98, 15));
            lllllllllllllIlIIllIlIlIllllIIII += 15;
        }
        this.type = lllllllllllllIlIIllIlIlIllllIIll;
    }
    
    @Override
    public void onMouseRelease(final int lllllllllllllIlIIllIlIlIlIIlIlll) {
        super.onMouseRelease(lllllllllllllIlIIllIlIlIlIIlIlll);
        this.dragging = false;
    }
    
    static {
        HEADER_HEIGHT = 17;
        ITEM_HEIGHT = 15;
        X_ITEM_OFFSET = 1;
        HEADER_WIDTH = 100;
    }
    
    @Override
    public int getHeightWithExpand() {
        int lllllllllllllIlIIllIlIlIlIIIlIlI = this.getHeight();
        if (this.isExpanded()) {
            for (final Component lllllllllllllIlIIllIlIlIlIIIlIIl : this.components) {
                int lllllllllllllIlIIllIlIlIlIIIlIII = lllllllllllllIlIIllIlIlIlIIIlIIl.getHeight();
                if (lllllllllllllIlIIllIlIlIlIIIlIIl instanceof ExpandableComponent) {
                    final ExpandableComponent lllllllllllllIlIIllIlIlIlIIIIlll = (ExpandableComponent)lllllllllllllIlIIllIlIlIlIIIlIIl;
                    if (lllllllllllllIlIIllIlIlIlIIIIlll.isExpanded()) {
                        lllllllllllllIlIIllIlIlIlIIIlIII = lllllllllllllIlIIllIlIlIlIIIIlll.getHeightWithExpand() + 5;
                    }
                }
                lllllllllllllIlIIllIlIlIlIIIlIlI += lllllllllllllIlIIllIlIlIlIIIlIII;
            }
        }
        return lllllllllllllIlIIllIlIlIlIIIlIlI;
    }
    
    @Override
    public void onPress(final int lllllllllllllIlIIllIlIlIlIIlllIl, final int lllllllllllllIlIIllIlIlIlIIlllII, final int lllllllllllllIlIIllIlIlIlIIlllll) {
        if (lllllllllllllIlIIllIlIlIlIIlllll == 0 && !this.dragging) {
            this.dragging = true;
            this.prevX = lllllllllllllIlIIllIlIlIlIIlllIl - this.getX();
            this.prevY = lllllllllllllIlIIllIlIlIlIIlllII - this.getY();
        }
    }
}
