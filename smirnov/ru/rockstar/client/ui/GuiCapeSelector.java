// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui;

import java.io.IOException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import java.awt.Color;
import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.api.utils.render.DrawHelper;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.client.ui.settings.button.ImageButton;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;

public class GuiCapeSelector extends GuiScreen
{
    protected /* synthetic */ ArrayList<ImageButton> imageButtons;
    private /* synthetic */ int height;
    private /* synthetic */ int width;
    private /* synthetic */ float spin;
    
    public GuiCapeSelector() {
        this.imageButtons = new ArrayList<ImageButton>();
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIIllIlIIIllllIIllIII, final int lllllllllllIIIllIlIIIllllIIlIlll, final float lllllllllllIIIllIlIIIllllIIlIllI) {
        this.drawWorldBackground(0);
        GlStateManager.pushMatrix();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        DrawHelper.drawSkeetRectWithoutBorder((float)(this.width - 70), (float)(this.height - 80), (float)(this.width + 80), (float)(this.height + 20));
        DrawHelper.drawSkeetButton((float)(this.width - 70), (float)(this.height - 78), (float)(this.width + 80), (float)(this.height + 80));
        this.mc.neverlose500_16.drawStringWithOutline("Cape Changer", this.width - 100, this.height - 133, -1);
        this.drawEntityOnScreen((float)(this.width + 7), (float)(this.height + 38), this.spin, this.mc.player);
        this.spin += (float)0.9;
        for (final ImageButton lllllllllllIIIllIlIIIllllIIlIlIl : this.imageButtons) {
            lllllllllllIIIllIlIIIllllIIlIlIl.draw(lllllllllllIIIllIlIIIllllIIllIII, lllllllllllIIIllIlIIIllllIIlIlll, Color.LIGHT_GRAY);
        }
        GlStateManager.popMatrix();
        super.drawScreen(lllllllllllIIIllIlIIIllllIIllIII, lllllllllllIIIllIlIIIllllIIlIlll, lllllllllllIIIllIlIIIllllIIlIllI);
    }
    
    private void drawEntityOnScreen(final float lllllllllllIIIllIlIIIlllIlllIIlI, final float lllllllllllIIIllIlIIIlllIllIIlll, final float lllllllllllIIIllIlIIIlllIllIIllI, final EntityLivingBase lllllllllllIIIllIlIIIlllIllIllll) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(lllllllllllIIIllIlIIIlllIlllIIlI, lllllllllllIIIllIlIIIlllIllIIlll, 50.0f);
        GlStateManager.scale(-80.0f, 80.0f, 80.0f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        final float lllllllllllIIIllIlIIIlllIllIlllI = lllllllllllIIIllIlIIIlllIllIllll.renderYawOffset;
        final float lllllllllllIIIllIlIIIlllIllIllIl = lllllllllllIIIllIlIIIlllIllIllll.rotationYaw;
        final float lllllllllllIIIllIlIIIlllIllIllII = lllllllllllIIIllIlIIIlllIllIllll.rotationPitchHead;
        final float lllllllllllIIIllIlIIIlllIllIlIll = lllllllllllIIIllIlIIIlllIllIllll.prevRotationYawHead;
        final float lllllllllllIIIllIlIIIlllIllIlIlI = lllllllllllIIIllIlIIIlllIllIllll.rotationYawHead;
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        lllllllllllIIIllIlIIIlllIllIllll.renderYawOffset = lllllllllllIIIllIlIIIlllIllIIllI;
        lllllllllllIIIllIlIIIlllIllIllll.rotationYaw = lllllllllllIIIllIlIIIlllIllIIllI;
        lllllllllllIIIllIlIIIlllIllIllll.rotationPitchHead = 0.0f;
        lllllllllllIIIllIlIIIlllIllIllll.rotationYawHead = lllllllllllIIIllIlIIIlllIllIllll.rotationYaw;
        lllllllllllIIIllIlIIIlllIllIllll.prevRotationYawHead = lllllllllllIIIllIlIIIlllIllIllll.rotationYaw;
        lllllllllllIIIllIlIIIlllIllIllll.prevRotationPitchHead = 0.0f;
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        final RenderManager lllllllllllIIIllIlIIIlllIllIlIIl = Minecraft.getMinecraft().getRenderManager();
        lllllllllllIIIllIlIIIlllIllIlIIl.setPlayerViewY(180.0f);
        lllllllllllIIIllIlIIIlllIllIlIIl.setRenderShadow(false);
        lllllllllllIIIllIlIIIlllIllIlIIl.doRenderEntity(lllllllllllIIIllIlIIIlllIllIllll, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        lllllllllllIIIllIlIIIlllIllIlIIl.setRenderShadow(true);
        lllllllllllIIIllIlIIIlllIllIllll.renderYawOffset = lllllllllllIIIllIlIIIlllIllIlllI;
        lllllllllllIIIllIlIIIlllIllIllll.rotationYaw = lllllllllllIIIllIlIIIlllIllIllIl;
        lllllllllllIIIllIlIIIlllIllIllll.rotationPitchHead = lllllllllllIIIllIlIIIlllIllIllII;
        lllllllllllIIIllIlIIIlllIllIllll.prevRotationPitchHead = lllllllllllIIIllIlIIIlllIllIllII;
        lllllllllllIIIllIlIIIlllIllIllll.prevRotationYawHead = lllllllllllIIIllIlIIIlllIllIlIll;
        lllllllllllIIIllIlIIIlllIllIllll.rotationYawHead = lllllllllllIIIllIlIIIlllIllIlIlI;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    @Override
    public void initGui() {
        final ScaledResolution lllllllllllIIIllIlIIIllllIlIIIlI = new ScaledResolution(this.mc);
        this.width = lllllllllllIIIllIlIIIllllIlIIIlI.getScaledWidth() / 2;
        this.height = lllllllllllIIIllIlIIIllllIlIIIlI.getScaledHeight() / 2;
        this.imageButtons.clear();
        this.imageButtons.add(new ImageButton(new ResourceLocation("rockstar/close-button.png"), this.width + 106, this.height - 135, 8, 8, "", 19));
        this.imageButtons.add(new ImageButton(new ResourceLocation("rockstar/arrow/arrow-right.png"), this.width + 30, this.height + 52, 32, 25, "", 56));
        this.imageButtons.add(new ImageButton(new ResourceLocation("rockstar/arrow/arrow-left.png"), this.width - 50, this.height + 52, 32, 25, "", 55));
        super.initGui();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIIIllIlIIIllllIIIIlll, final int lllllllllllIIIllIlIIIllllIIIIIIl, final int lllllllllllIIIllIlIIIllllIIIIIII) throws IOException {
        if (lllllllllllIIIllIlIIIllllIIIIIII == 0) {
            for (final ImageButton lllllllllllIIIllIlIIIllllIIIIlII : this.imageButtons) {
                lllllllllllIIIllIlIIIllllIIIIlII.onClick(lllllllllllIIIllIlIIIllllIIIIlll, lllllllllllIIIllIlIIIllllIIIIIIl);
            }
        }
        super.mouseClicked(lllllllllllIIIllIlIIIllllIIIIlll, lllllllllllIIIllIlIIIllllIIIIIIl, lllllllllllIIIllIlIIIllllIIIIIII);
    }
    
    public static class Selector
    {
        public static /* synthetic */ String capeName;
        
        public static String getCapeName() {
            return Selector.capeName;
        }
        
        public static void setCapeName(final String llllllllllllIllIllllIIIIIIIlIIlI) {
            Selector.capeName = llllllllllllIllIllllIIIIIIIlIIlI;
        }
    }
}
