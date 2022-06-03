// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import org.apache.logging.log4j.LogManager;
import net.minecraft.client.settings.GameSettings;
import java.io.IOException;
import java.net.URI;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.renderer.GlStateManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.ResourceLocation;

public class GuiScreenDemo extends GuiScreen
{
    private static final /* synthetic */ ResourceLocation DEMO_BACKGROUND_LOCATION;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public void drawDefaultBackground() {
        super.drawDefaultBackground();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiScreenDemo.DEMO_BACKGROUND_LOCATION);
        final int lllllllllllIIlIlIlIIIlIlllIlIIII = (this.width - 248) / 2;
        final int lllllllllllIIlIlIlIIIlIlllIIllll = (this.height - 166) / 2;
        this.drawTexturedModalRect(lllllllllllIIlIlIlIIIlIlllIlIIII, lllllllllllIIlIlIlIIIlIlllIIllll, 0, 0, 248, 166);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        final int lllllllllllIIlIlIlIIIlIllllIIlII = -16;
        this.buttonList.add(new GuiButton(1, this.width / 2 - 116, this.height / 2 + 62 - 16, 114, 20, I18n.format("demo.help.buy", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 2, this.height / 2 + 62 - 16, 114, 20, I18n.format("demo.help.later", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIlIlIlIIIlIlllIlllII) throws IOException {
        switch (lllllllllllIIlIlIlIIIlIlllIlllII.id) {
            case 1: {
                lllllllllllIIlIlIlIIIlIlllIlllII.enabled = false;
                try {
                    final Class<?> lllllllllllIIlIlIlIIIlIlllIllIll = Class.forName("java.awt.Desktop");
                    final Object lllllllllllIIlIlIlIIIlIlllIllIlI = lllllllllllIIlIlIlIIIlIlllIllIll.getMethod("getDesktop", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
                    lllllllllllIIlIlIlIIIlIlllIllIll.getMethod("browse", URI.class).invoke(lllllllllllIIlIlIlIIIlIlllIllIlI, new URI("http://www.minecraft.net/store?source=demo"));
                }
                catch (Throwable lllllllllllIIlIlIlIIIlIlllIllIIl) {
                    GuiScreenDemo.LOGGER.error("Couldn't open link", lllllllllllIIlIlIlIIIlIlllIllIIl);
                }
                break;
            }
            case 2: {
                this.mc.displayGuiScreen(null);
                this.mc.setIngameFocus();
                break;
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIlIlIlIIIlIlllIIIIll, final int lllllllllllIIlIlIlIIIlIlllIIIIlI, final float lllllllllllIIlIlIlIIIlIllIlllIlI) {
        this.drawDefaultBackground();
        final int lllllllllllIIlIlIlIIIlIlllIIIIII = (this.width - 248) / 2 + 10;
        int lllllllllllIIlIlIlIIIlIllIllllll = (this.height - 166) / 2 + 8;
        this.fontRendererObj.drawString(I18n.format("demo.help.title", new Object[0]), (float)lllllllllllIIlIlIlIIIlIlllIIIIII, (float)lllllllllllIIlIlIlIIIlIllIllllll, 2039583);
        lllllllllllIIlIlIlIIIlIllIllllll += 12;
        final GameSettings lllllllllllIIlIlIlIIIlIllIlllllI = this.mc.gameSettings;
        this.fontRendererObj.drawString(I18n.format("demo.help.movementShort", GameSettings.getKeyDisplayString(lllllllllllIIlIlIlIIIlIllIlllllI.keyBindForward.getKeyCode()), GameSettings.getKeyDisplayString(lllllllllllIIlIlIlIIIlIllIlllllI.keyBindLeft.getKeyCode()), GameSettings.getKeyDisplayString(lllllllllllIIlIlIlIIIlIllIlllllI.keyBindBack.getKeyCode()), GameSettings.getKeyDisplayString(lllllllllllIIlIlIlIIIlIllIlllllI.keyBindRight.getKeyCode())), (float)lllllllllllIIlIlIlIIIlIlllIIIIII, (float)lllllllllllIIlIlIlIIIlIllIllllll, 5197647);
        this.fontRendererObj.drawString(I18n.format("demo.help.movementMouse", new Object[0]), (float)lllllllllllIIlIlIlIIIlIlllIIIIII, (float)(lllllllllllIIlIlIlIIIlIllIllllll + 12), 5197647);
        this.fontRendererObj.drawString(I18n.format("demo.help.jump", GameSettings.getKeyDisplayString(lllllllllllIIlIlIlIIIlIllIlllllI.keyBindJump.getKeyCode())), (float)lllllllllllIIlIlIlIIIlIlllIIIIII, (float)(lllllllllllIIlIlIlIIIlIllIllllll + 24), 5197647);
        this.fontRendererObj.drawString(I18n.format("demo.help.inventory", GameSettings.getKeyDisplayString(lllllllllllIIlIlIlIIIlIllIlllllI.keyBindInventory.getKeyCode())), (float)lllllllllllIIlIlIlIIIlIlllIIIIII, (float)(lllllllllllIIlIlIlIIIlIllIllllll + 36), 5197647);
        this.fontRendererObj.drawSplitString(I18n.format("demo.help.fullWrapped", new Object[0]), lllllllllllIIlIlIlIIIlIlllIIIIII, lllllllllllIIlIlIlIIIlIllIllllll + 68, 218, 2039583);
        super.drawScreen(lllllllllllIIlIlIlIIIlIlllIIIIll, lllllllllllIIlIlIlIIIlIlllIIIIlI, lllllllllllIIlIlIlIIIlIllIlllIlI);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DEMO_BACKGROUND_LOCATION = new ResourceLocation("textures/gui/demo_background.png");
    }
}
