// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui;

import java.io.IOException;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import ru.rockstar.security.CFontUser;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.client.features.impl.display.ClickGUI;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.csgui.component.ExpandableComponent;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.csgui.component.Component;
import ru.rockstar.api.utils.render.glsandbox.animbackground;
import ru.rockstar.client.ui.settings.button.ImageButton;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;

public class ClickGuiScreen extends GuiScreen
{
    public /* synthetic */ ScreenHelper screenHelper;
    public /* synthetic */ boolean exit;
    public /* synthetic */ List<Panel> components;
    public static /* synthetic */ boolean escapeKeyInUse;
    protected /* synthetic */ ArrayList<ImageButton> imageButtons;
    private /* synthetic */ animbackground backgroundShader;
    private /* synthetic */ Component selectedPanel;
    public /* synthetic */ Category type;
    
    @Override
    protected void mouseReleased(final int lllllllllllIIIIIIllIlllIllIIllIl, final int lllllllllllIIIIIIllIlllIllIIllII, final int lllllllllllIIIIIIllIlllIllIIlIIl) {
        this.selectedPanel.onMouseRelease(lllllllllllIIIIIIllIlllIllIIlIIl);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIIIIIIllIlllIllIllIIl, final int lllllllllllIIIIIIllIlllIllIllIII, final int lllllllllllIIIIIIllIlllIlllIIIII) {
        for (final Component lllllllllllIIIIIIllIlllIllIlllll : this.components) {
            final int lllllllllllIIIIIIllIlllIllIllllI = lllllllllllIIIIIIllIlllIllIlllll.getX();
            final int lllllllllllIIIIIIllIlllIllIlllIl = lllllllllllIIIIIIllIlllIllIlllll.getY();
            int lllllllllllIIIIIIllIlllIllIlllII = lllllllllllIIIIIIllIlllIllIlllll.getHeight();
            if (lllllllllllIIIIIIllIlllIllIlllll instanceof ExpandableComponent) {
                final ExpandableComponent lllllllllllIIIIIIllIlllIllIllIll = (ExpandableComponent)lllllllllllIIIIIIllIlllIllIlllll;
                if (lllllllllllIIIIIIllIlllIllIllIll.isExpanded()) {
                    lllllllllllIIIIIIllIlllIllIlllII = lllllllllllIIIIIIllIlllIllIllIll.getHeightWithExpand();
                }
            }
            if (lllllllllllIIIIIIllIlllIllIllIIl > lllllllllllIIIIIIllIlllIllIllllI && lllllllllllIIIIIIllIlllIllIllIII > lllllllllllIIIIIIllIlllIllIlllIl && lllllllllllIIIIIIllIlllIllIllIIl < lllllllllllIIIIIIllIlllIllIllllI + lllllllllllIIIIIIllIlllIllIlllll.getWidth() && lllllllllllIIIIIIllIlllIllIllIII < lllllllllllIIIIIIllIlllIllIlllIl + lllllllllllIIIIIIllIlllIllIlllII) {
                this.selectedPanel = lllllllllllIIIIIIllIlllIllIlllll;
                lllllllllllIIIIIIllIlllIllIlllll.onMouseClick(lllllllllllIIIIIIllIlllIllIllIIl, lllllllllllIIIIIIllIlllIllIllIII, lllllllllllIIIIIIllIlllIlllIIIII);
                break;
            }
        }
    }
    
    @Override
    public void onGuiClosed() {
        this.screenHelper = new ScreenHelper(0.0f, 0.0f);
        this.mc.entityRenderer.theShaderGroup = null;
        super.onGuiClosed();
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIIIIIllIllllIIIlIlIl, final int lllllllllllIIIIIIllIllllIIIIIIll, final float lllllllllllIIIIIIllIllllIIIlIIll) {
        final ScaledResolution lllllllllllIIIIIIllIllllIIIlIIlI = new ScaledResolution(this.mc);
        Color lllllllllllIIIIIIllIllllIIIlIIIl = Color.WHITE;
        final Color lllllllllllIIIIIIllIllllIIIlIIII = new Color(ClickGUI.color.getColorValue());
        final Color lllllllllllIIIIIIllIllllIIIIllll = new Color(ClickGUI.colorTwo.getColorValue());
        final double lllllllllllIIIIIIllIllllIIIIlllI = ClickGUI.speed.getNumberValue();
        final byte lllllllllllIIIIIIllIlllIllllllII;
        switch (((String)(lllllllllllIIIIIIllIlllIllllllII = (byte)ClickGUI.clickGuiColor.currentMode)).hashCode()) {
            case -1808614770: {
                if (!((String)lllllllllllIIIIIIllIlllIllllllII).equals("Static")) {
                    break;
                }
                lllllllllllIIIIIIllIllllIIIlIIIl = lllllllllllIIIIIIllIllllIIIlIIII;
                break;
            }
            case -1656737386: {
                if (!((String)lllllllllllIIIIIIllIlllIllllllII).equals("Rainbow")) {
                    break;
                }
                lllllllllllIIIIIIllIllllIIIlIIIl = DrawHelper.rainbow(300, 1.0f, 1.0f);
                break;
            }
            case -311641137: {
                if (!((String)lllllllllllIIIIIIllIlllIllllllII).equals("Color Two")) {
                    break;
                }
                lllllllllllIIIIIIllIllllIIIlIIIl = new Color(DrawHelper.fadeColor(lllllllllllIIIIIIllIllllIIIlIIII.getRGB(), lllllllllllIIIIIIllIllllIIIIllll.getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIIIIIllIllllIIIIlllI / lllllllllllIIIIIIllIllllIIIIlllI + this.height * 6L / 60L * 2L) % 2.0 - 1.0)));
                break;
            }
            case 2181788: {
                if (!((String)lllllllllllIIIIIIllIlllIllllllII).equals("Fade")) {
                    break;
                }
                lllllllllllIIIIIIllIllllIIIlIIIl = new Color(ClickGUI.color.getColorValue());
                break;
            }
            case 115155230: {
                if (!((String)lllllllllllIIIIIIllIlllIllllllII).equals("Category")) {
                    break;
                }
                lllllllllllIIIIIIllIllllIIIlIIIl = new Color(this.type.getColor());
                break;
            }
            case 961091784: {
                if (!((String)lllllllllllIIIIIIllIlllIllllllII).equals("Astolfo")) {
                    break;
                }
                lllllllllllIIIIIIllIllllIIIlIIIl = DrawHelper.astolfo(true, this.width);
                break;
            }
            case 2021122027: {
                if (!((String)lllllllllllIIIIIIllIlllIllllllII).equals("Client")) {
                    break;
                }
                lllllllllllIIIIIIllIllllIIIlIIIl = ClientHelper.getClientColor();
                break;
            }
        }
        final Color lllllllllllIIIIIIllIllllIIIIllIl = new Color(0, 0, 0, 0);
        final String lllllllllllIIIIIIllIllllIIIIllII = ClickGUI.backGroundMode.getOptions();
        if (ClickGUI.background.getBoolValue()) {
            if (lllllllllllIIIIIIllIllllIIIIllII.equalsIgnoreCase("Top")) {
                this.drawDefaultBackground();
                this.drawGradientRect(0, 0, lllllllllllIIIIIIllIllllIIIlIIlI.getScaledWidth(), lllllllllllIIIIIIllIllllIIIlIIlI.getScaledHeight(), lllllllllllIIIIIIllIllllIIIlIIIl.getRGB(), lllllllllllIIIIIIllIllllIIIIllIl.getRGB());
            }
            else if (lllllllllllIIIIIIllIllllIIIIllII.equalsIgnoreCase("Bottom")) {
                this.drawDefaultBackground();
                this.drawGradientRect(0, 0, lllllllllllIIIIIIllIllllIIIlIIlI.getScaledWidth(), lllllllllllIIIIIIllIllllIIIlIIlI.getScaledHeight(), lllllllllllIIIIIIllIllllIIIIllIl.getRGB(), lllllllllllIIIIIIllIllllIIIlIIIl.getRGB());
            }
            else if (lllllllllllIIIIIIllIllllIIIIllII.equalsIgnoreCase("Everywhere")) {
                this.drawDefaultBackground();
                this.drawGradientRect(0, 0, lllllllllllIIIIIIllIllllIIIlIIlI.getScaledWidth(), lllllllllllIIIIIIllIllllIIIlIIlI.getScaledHeight(), DrawHelper.setAlpha(lllllllllllIIIIIIllIllllIIIlIIIl, 100).getRGB(), DrawHelper.setAlpha(lllllllllllIIIIIIllIllllIIIlIIIl, 100).getRGB());
            }
            else if (lllllllllllIIIIIIllIllllIIIIllII.equalsIgnoreCase("Shader")) {
                GlStateManager.disableCull();
                final long lllllllllllIIIIIIllIllllIIIIlIll = System.currentTimeMillis();
                this.backgroundShader.useShader(lllllllllllIIIIIIllIllllIIIlIIlI.getScaledWidth() + 80000, lllllllllllIIIIIIllIllllIIIlIIlI.getScaledHeight(), (float)lllllllllllIIIIIIllIllllIIIlIlIl, (float)lllllllllllIIIIIIllIllllIIIIIIll, (System.currentTimeMillis() - lllllllllllIIIIIIllIllllIIIIlIll) / 5000.0f);
                GL11.glBegin(7);
                GL11.glVertex2f(-1.0f, -1.0f);
                GL11.glVertex2f(-1.0f, 1.0f);
                GL11.glVertex2f(1.0f, 1.0f);
                GL11.glVertex2f(1.0f, -1.0f);
                GL11.glEnd();
                GL20.glUseProgram(0);
                GlStateManager.disableCull();
            }
        }
        if (ClickGUI.image.getBoolValue()) {
            final int lllllllllllIIIIIIllIllllIIIIlIlI = (int)ClickGUI.imagex.getNumberValue();
            final int lllllllllllIIIIIIllIllllIIIIlIIl = (int)ClickGUI.imagey.getNumberValue();
            final String lllllllllllIIIIIIllIllllIIIIlIII = ClickGUI.imagemode.getOptions();
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("DeadInside")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 260.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("DeadInside2")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside2.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 260.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("DeadInside3")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside3.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 260.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("DeadInside4")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside4.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 400.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("DeadInside5")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside5.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 330.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("DeadInside6")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside6.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 260.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("DeadInside7")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside7.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 260.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("DeadInside8")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside8.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 280.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Allax")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/allax.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Cat")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/cat.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Floppa")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/floppa.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Minecraft")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/minecraft.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 450.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Putin")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/putin.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Slava Bebrow")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/slavabebrow.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 450.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Simple")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/simple.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 450.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan2")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan2.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan3")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan3.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 300.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan4")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan4.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 300.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan5")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan5.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan6")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan6.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan7")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan7.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan8")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan8.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan9")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan9.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 450.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan10")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan10.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan11")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan11.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan12")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan12.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan13")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan13.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 400.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan14")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan14.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan15")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan15.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 400.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan16")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan16.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan17")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan17.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan18")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan18.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 300.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan19")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan19.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan20")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan20.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan21")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan21.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 300.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan22")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan22.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan23")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan23.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 300.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan24")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan24.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Tyan25")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan25.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Brawl")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 400.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Brawl2")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl2.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Brawl3")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl3.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Brawl4")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl4.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Brawl5")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl5.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 450.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Floppa2")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/floppa2.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            if (lllllllllllIIIIIIllIllllIIIIlIII.equalsIgnoreCase("Selli324")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/cow.png"), (float)lllllllllllIIIIIIllIllllIIIIlIlI, (float)lllllllllllIIIIIIllIllllIIIIlIIl, 350.0f, 350.0f, new Color(-1));
            }
            DrawHelper.drawRectWithGlow(lllllllllllIIIIIIllIllllIIIlIIlI.getScaledWidth() - this.mc.mntsb_20.getStringWidth("Username: " + CFontUser.username) - 5, lllllllllllIIIIIIllIllllIIIlIIlI.getScaledHeight(), lllllllllllIIIIIIllIllllIIIlIIlI.getScaledWidth(), lllllllllllIIIIIIllIllllIIIlIIlI.getScaledHeight() - 15, 5.0, 13.0, new Color(0, 0, 0, 255));
            this.mc.mntsb_20.drawStringWithShadow("Username: " + CFontUser.username, lllllllllllIIIIIIllIllllIIIlIIlI.getScaledWidth() - this.mc.mntsb_20.getStringWidth("Username: " + CFontUser.username) - 3, lllllllllllIIIIIIllIllllIIIlIIlI.getScaledHeight() - 10, -1);
        }
        for (final Panel lllllllllllIIIIIIllIllllIIIIIlll : this.components) {
            lllllllllllIIIIIIllIllllIIIIIlll.drawComponent(lllllllllllIIIIIIllIllllIIIlIIlI, lllllllllllIIIIIIllIllllIIIlIlIl, lllllllllllIIIIIIllIllllIIIIIIll);
        }
        for (final ImageButton lllllllllllIIIIIIllIllllIIIIIllI : this.imageButtons) {
            lllllllllllIIIIIIllIllllIIIIIllI.draw(lllllllllllIIIIIIllIllllIIIlIlIl, lllllllllllIIIIIIllIllllIIIIIIll, Color.WHITE);
            if (Mouse.isButtonDown(0)) {
                lllllllllllIIIIIIllIllllIIIIIllI.onClick(lllllllllllIIIIIIllIllllIIIlIlIl, lllllllllllIIIIIIllIllllIIIIIIll);
            }
        }
        if (this.exit) {
            this.screenHelper.interpolate(0.0f, 0.0f, 2.0);
            if (this.screenHelper.getY() < 200.0f) {
                this.exit = false;
                this.mc.displayGuiScreen(null);
                if (this.mc.currentScreen == null) {
                    this.mc.setIngameFocus();
                }
            }
        }
        else {
            this.screenHelper.interpolate((float)this.width, (float)this.height, 3.0 * Minecraft.frameTime / 6.0);
        }
        super.drawScreen(lllllllllllIIIIIIllIllllIIIlIlIl, lllllllllllIIIIIIllIllllIIIIIIll, lllllllllllIIIIIIllIllllIIIlIIll);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIIIIIllIlllIllllIIlI, final int lllllllllllIIIIIIllIlllIlllIlllI) throws IOException {
        if (lllllllllllIIIIIIllIlllIlllIlllI == 1) {
            this.exit = true;
        }
        if (this.exit) {
            return;
        }
        this.selectedPanel.onKeyPress(lllllllllllIIIIIIllIlllIlllIlllI);
        if (!ClickGuiScreen.escapeKeyInUse) {
            super.keyTyped(lllllllllllIIIIIIllIlllIllllIIlI, lllllllllllIIIIIIllIlllIlllIlllI);
        }
        ClickGuiScreen.escapeKeyInUse = false;
    }
    
    public static void saveImage(final String lllllllllllIIIIIIllIllllIIllIlII, final String lllllllllllIIIIIIllIllllIIlIlIll) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* lllllllllllIIIIIIllIllllIIlIllII */
        //     5: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //     8: astore_2        /* lllllllllllIIIIIIllIllllIIllIIlI */
        //     9: aload_2         /* lllllllllllIIIIIIllIllllIIllIIlI */
        //    10: invokevirtual   java/net/URL.openStream:()Ljava/io/InputStream;
        //    13: astore_3        /* lllllllllllIIIIIIllIllllIIlIlIIl */
        //    14: new             Ljava/io/FileOutputStream;
        //    17: dup            
        //    18: aload_1         /* lllllllllllIIIIIIllIllllIIllIIll */
        //    19: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //    22: astore          lllllllllllIIIIIIllIllllIIllIIII
        //    24: sipush          2048
        //    27: newarray        B
        //    29: astore          lllllllllllIIIIIIllIllllIIlIllll
        //    31: goto            44
        //    34: aload           lllllllllllIIIIIIllIllllIIllIIII
        //    36: aload           lllllllllllIIIIIIllIllllIIlIllll
        //    38: iconst_0       
        //    39: iload           lllllllllllIIIIIIllIllllIIlIlllI
        //    41: invokevirtual   java/io/OutputStream.write:([BII)V
        //    44: aload_3         /* lllllllllllIIIIIIllIllllIIllIIIl */
        //    45: aload           lllllllllllIIIIIIllIllllIIlIllll
        //    47: invokevirtual   java/io/InputStream.read:([B)I
        //    50: dup            
        //    51: istore          lllllllllllIIIIIIllIllllIIlIllIl
        //    53: iconst_m1      
        //    54: if_icmpne       34
        //    57: aload_3         /* lllllllllllIIIIIIllIllllIIllIIIl */
        //    58: invokevirtual   java/io/InputStream.close:()V
        //    61: aload           lllllllllllIIIIIIllIllllIIllIIII
        //    63: invokevirtual   java/io/OutputStream.close:()V
        //    66: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 FF 00 22 00 07 07 00 BE 07 00 BE 07 02 CB 07 02 DB 07 02 D2 07 02 F7 01 00 00 FA 00 09
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void initGui() {
        final ScaledResolution lllllllllllIIIIIIllIllllIlIIIlIl = new ScaledResolution(this.mc);
        this.screenHelper = new ScreenHelper(0.0f, 0.0f);
        this.imageButtons.clear();
        this.imageButtons.add(new ImageButton(new ResourceLocation("rockstar/config.png"), 5, lllllllllllIIIIIIllIllllIlIIIlIl.getScaledHeight() - 25, 20, 20, "\u042f \u0433\u0435\u0439, \u043d\u043e \u043d\u0438\u043a\u0442\u043e \u043e\u0431 \u044d\u0442\u043e\u043c \u043d\u0435 \u0443\u0437\u043d\u0430\u0435\u0442", 22));
        if (ClickGUI.blur.getBoolValue()) {
            this.mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        }
        super.initGui();
    }
    
    public ClickGuiScreen() {
        this.components = new ArrayList<Panel>();
        this.exit = false;
        this.imageButtons = new ArrayList<ImageButton>();
        try {
            this.backgroundShader = new animbackground("/noise.fsh");
        }
        catch (IOException lllllllllllIIIIIIllIllllIlIlIlIl) {
            throw new IllegalStateException("Failed to load backgound shader", lllllllllllIIIIIIllIllllIlIlIlIl);
        }
        final int lllllllllllIIIIIIllIllllIlIlIlII = 20;
        int lllllllllllIIIIIIllIllllIlIlIIll = 30;
        final int lllllllllllIIIIIIllIllllIlIlIIlI = 20;
        final boolean lllllllllllIIIIIIllIllllIlIIlIIl;
        final int lllllllllllIIIIIIllIllllIlIIlIlI = ((Category[])(Object)(lllllllllllIIIIIIllIllllIlIIlIIl = (boolean)(Object)Category.values())).length;
        for (char lllllllllllIIIIIIllIllllIlIIlIll = '\0'; lllllllllllIIIIIIllIllllIlIIlIll < lllllllllllIIIIIIllIllllIlIIlIlI; ++lllllllllllIIIIIIllIllllIlIIlIll) {
            final Category lllllllllllIIIIIIllIllllIlIlIIIl = lllllllllllIIIIIIllIllllIlIIlIIl[lllllllllllIIIIIIllIllllIlIIlIll];
            this.type = lllllllllllIIIIIIllIllllIlIlIIIl;
            this.components.add(new Panel(lllllllllllIIIIIIllIllllIlIlIIIl, lllllllllllIIIIIIllIllllIlIlIIll, lllllllllllIIIIIIllIllllIlIlIIlI));
            this.selectedPanel = new Panel(lllllllllllIIIIIIllIllllIlIlIIIl, lllllllllllIIIIIIllIllllIlIlIIll, lllllllllllIIIIIIllIllllIlIlIIlI);
            lllllllllllIIIIIIllIllllIlIlIIll += lllllllllllIIIIIIllIllllIlIlIlII + 50;
        }
        this.screenHelper = new ScreenHelper(0.0f, 0.0f);
    }
    
    public static void main(final String[] lllllllllllIIIIIIllIllllIlIIIIII) throws Exception {
        final String lllllllllllIIIIIIllIllllIIllllll = "http://www.avajava.com/images/avajavalogo.jpg";
        final String lllllllllllIIIIIIllIllllIIlllllI = "image.jpg";
        saveImage(lllllllllllIIIIIIllIllllIIllllll, lllllllllllIIIIIIllIllllIIlllllI);
    }
}
