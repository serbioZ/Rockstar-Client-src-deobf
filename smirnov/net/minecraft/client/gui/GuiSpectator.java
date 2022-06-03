// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.gui.spectator.categories.SpectatorDetails;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.gui.spectator.ISpectatorMenuObject;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.spectator.SpectatorMenu;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.spectator.ISpectatorMenuRecipient;

public class GuiSpectator extends Gui implements ISpectatorMenuRecipient
{
    public static final /* synthetic */ ResourceLocation SPECTATOR_WIDGETS;
    private /* synthetic */ SpectatorMenu menu;
    private /* synthetic */ long lastSelectionTime;
    private final /* synthetic */ Minecraft mc;
    private static final /* synthetic */ ResourceLocation WIDGETS;
    
    static {
        WIDGETS = new ResourceLocation("textures/gui/widgets.png");
        SPECTATOR_WIDGETS = new ResourceLocation("textures/gui/spectator_widgets.png");
    }
    
    public GuiSpectator(final Minecraft llllllllllllllIIlIIlIllIIIlllIlI) {
        this.mc = llllllllllllllIIlIIlIllIIIlllIlI;
    }
    
    public void renderSelectedItem(final ScaledResolution llllllllllllllIIlIIlIlIlllIlllIl) {
        final int llllllllllllllIIlIIlIlIlllIlllII = (int)(this.getHotbarAlpha() * 255.0f);
        if (llllllllllllllIIlIIlIlIlllIlllII > 3 && this.menu != null) {
            final ISpectatorMenuObject llllllllllllllIIlIIlIlIlllIllIll = this.menu.getSelectedItem();
            final String llllllllllllllIIlIIlIlIlllIllIlI = (llllllllllllllIIlIIlIlIlllIllIll == SpectatorMenu.EMPTY_SLOT) ? this.menu.getSelectedCategory().getPrompt().getFormattedText() : llllllllllllllIIlIIlIlIlllIllIll.getSpectatorName().getFormattedText();
            if (llllllllllllllIIlIIlIlIlllIllIlI != null) {
                final int llllllllllllllIIlIIlIlIlllIllIIl = (llllllllllllllIIlIIlIlIlllIlllIl.getScaledWidth() - Minecraft.fontRendererObj.getStringWidth(llllllllllllllIIlIIlIlIlllIllIlI)) / 2;
                final int llllllllllllllIIlIIlIlIlllIllIII = llllllllllllllIIlIIlIlIlllIlllIl.getScaledHeight() - 35;
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                Minecraft.fontRendererObj.drawStringWithShadow(llllllllllllllIIlIIlIlIlllIllIlI, (float)llllllllllllllIIlIIlIlIlllIllIIl, (float)llllllllllllllIIlIIlIlIlllIllIII, 16777215 + (llllllllllllllIIlIIlIlIlllIlllII << 24));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
        }
    }
    
    public boolean isMenuActive() {
        return this.menu != null;
    }
    
    private void renderSlot(final int llllllllllllllIIlIIlIlIlllllIllI, final int llllllllllllllIIlIIlIlIlllllIlIl, final float llllllllllllllIIlIIlIlIlllllIlII, final float llllllllllllllIIlIIlIlIlllllIIll, final ISpectatorMenuObject llllllllllllllIIlIIlIlIlllllIIlI) {
        this.mc.getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
        if (llllllllllllllIIlIIlIlIlllllIIlI != SpectatorMenu.EMPTY_SLOT) {
            final int llllllllllllllIIlIIlIlIlllllIIIl = (int)(llllllllllllllIIlIIlIlIlllllIIll * 255.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)llllllllllllllIIlIIlIlIlllllIlIl, llllllllllllllIIlIIlIlIlllllIlII, 0.0f);
            final float llllllllllllllIIlIIlIlIlllllIIII = llllllllllllllIIlIIlIlIlllllIIlI.isEnabled() ? 1.0f : 0.25f;
            GlStateManager.color(llllllllllllllIIlIIlIlIlllllIIII, llllllllllllllIIlIIlIlIlllllIIII, llllllllllllllIIlIIlIlIlllllIIII, llllllllllllllIIlIIlIlIlllllIIll);
            llllllllllllllIIlIIlIlIlllllIIlI.renderIcon(llllllllllllllIIlIIlIlIlllllIIII, llllllllllllllIIlIIlIlIlllllIIIl);
            GlStateManager.popMatrix();
            final String llllllllllllllIIlIIlIlIllllIllll = String.valueOf(GameSettings.getKeyDisplayString(this.mc.gameSettings.keyBindsHotbar[llllllllllllllIIlIIlIlIlllllIllI].getKeyCode()));
            if (llllllllllllllIIlIIlIlIlllllIIIl > 3 && llllllllllllllIIlIIlIlIlllllIIlI.isEnabled()) {
                Minecraft.fontRendererObj.drawStringWithShadow(llllllllllllllIIlIIlIlIllllIllll, (float)(llllllllllllllIIlIIlIlIlllllIlIl + 19 - 2 - Minecraft.fontRendererObj.getStringWidth(llllllllllllllIIlIIlIlIllllIllll)), llllllllllllllIIlIIlIlIlllllIlII + 6.0f + 3.0f, 16777215 + (llllllllllllllIIlIIlIlIlllllIIIl << 24));
            }
        }
    }
    
    public void onHotbarSelected(final int llllllllllllllIIlIIlIllIIIllIlII) {
        this.lastSelectionTime = Minecraft.getSystemTime();
        if (this.menu != null) {
            this.menu.selectSlot(llllllllllllllIIlIIlIllIIIllIlII);
        }
        else {
            this.menu = new SpectatorMenu(this);
        }
    }
    
    public void onMiddleClick() {
        this.lastSelectionTime = Minecraft.getSystemTime();
        if (this.isMenuActive()) {
            final int llllllllllllllIIlIIlIlIllIllllIl = this.menu.getSelectedSlot();
            if (llllllllllllllIIlIIlIlIllIllllIl != -1) {
                this.menu.selectSlot(llllllllllllllIIlIIlIlIllIllllIl);
            }
        }
        else {
            this.menu = new SpectatorMenu(this);
        }
    }
    
    @Override
    public void onSpectatorMenuClosed(final SpectatorMenu llllllllllllllIIlIIlIlIlllIIlllI) {
        this.menu = null;
        this.lastSelectionTime = 0L;
    }
    
    public void onMouseScroll(final int llllllllllllllIIlIIlIlIlllIIIlIl) {
        int llllllllllllllIIlIIlIlIlllIIIlII;
        for (llllllllllllllIIlIIlIlIlllIIIlII = this.menu.getSelectedSlot() + llllllllllllllIIlIIlIlIlllIIIlIl; llllllllllllllIIlIIlIlIlllIIIlII >= 0 && llllllllllllllIIlIIlIlIlllIIIlII <= 8 && (this.menu.getItem(llllllllllllllIIlIIlIlIlllIIIlII) == SpectatorMenu.EMPTY_SLOT || !this.menu.getItem(llllllllllllllIIlIIlIlIlllIIIlII).isEnabled()); llllllllllllllIIlIIlIlIlllIIIlII += llllllllllllllIIlIIlIlIlllIIIlIl) {}
        if (llllllllllllllIIlIIlIlIlllIIIlII >= 0 && llllllllllllllIIlIIlIlIlllIIIlII <= 8) {
            this.menu.selectSlot(llllllllllllllIIlIIlIlIlllIIIlII);
            this.lastSelectionTime = Minecraft.getSystemTime();
        }
    }
    
    public void renderTooltip(final ScaledResolution llllllllllllllIIlIIlIllIIIlIIIll, final float llllllllllllllIIlIIlIllIIIlIIIlI) {
        if (this.menu != null) {
            final float llllllllllllllIIlIIlIllIIIlIIIIl = this.getHotbarAlpha();
            if (llllllllllllllIIlIIlIllIIIlIIIIl <= 0.0f) {
                this.menu.exit();
            }
            else {
                final int llllllllllllllIIlIIlIllIIIlIIIII = llllllllllllllIIlIIlIllIIIlIIIll.getScaledWidth() / 2;
                final float llllllllllllllIIlIIlIllIIIIlllll = this.zLevel;
                this.zLevel = -90.0f;
                final float llllllllllllllIIlIIlIllIIIIllllI = llllllllllllllIIlIIlIllIIIlIIIll.getScaledHeight() - 22.0f * llllllllllllllIIlIIlIllIIIlIIIIl;
                final SpectatorDetails llllllllllllllIIlIIlIllIIIIlllIl = this.menu.getCurrentPage();
                this.renderPage(llllllllllllllIIlIIlIllIIIlIIIll, llllllllllllllIIlIIlIllIIIlIIIIl, llllllllllllllIIlIIlIllIIIlIIIII, llllllllllllllIIlIIlIllIIIIllllI, llllllllllllllIIlIIlIllIIIIlllIl);
                this.zLevel = llllllllllllllIIlIIlIllIIIIlllll;
            }
        }
    }
    
    protected void renderPage(final ScaledResolution llllllllllllllIIlIIlIllIIIIIIllI, final float llllllllllllllIIlIIlIllIIIIIIlIl, final int llllllllllllllIIlIIlIllIIIIIIlII, final float llllllllllllllIIlIIlIllIIIIIlIlI, final SpectatorDetails llllllllllllllIIlIIlIllIIIIIlIIl) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllllIIlIIlIllIIIIIIlIl);
        this.mc.getTextureManager().bindTexture(GuiSpectator.WIDGETS);
        this.drawTexturedModalRect((float)(llllllllllllllIIlIIlIllIIIIIIlII - 91), llllllllllllllIIlIIlIllIIIIIlIlI, 0, 0, 182, 22);
        if (llllllllllllllIIlIIlIllIIIIIlIIl.getSelectedSlot() >= 0) {
            this.drawTexturedModalRect((float)(llllllllllllllIIlIIlIllIIIIIIlII - 91 - 1 + llllllllllllllIIlIIlIllIIIIIlIIl.getSelectedSlot() * 20), llllllllllllllIIlIIlIllIIIIIlIlI - 1.0f, 0, 22, 24, 22);
        }
        RenderHelper.enableGUIStandardItemLighting();
        for (int llllllllllllllIIlIIlIllIIIIIlIII = 0; llllllllllllllIIlIIlIllIIIIIlIII < 9; ++llllllllllllllIIlIIlIllIIIIIlIII) {
            this.renderSlot(llllllllllllllIIlIIlIllIIIIIlIII, llllllllllllllIIlIIlIllIIIIIIllI.getScaledWidth() / 2 - 90 + llllllllllllllIIlIIlIllIIIIIlIII * 20 + 2, llllllllllllllIIlIIlIllIIIIIlIlI + 3.0f, llllllllllllllIIlIIlIllIIIIIIlIl, llllllllllllllIIlIIlIllIIIIIlIIl.getObject(llllllllllllllIIlIIlIllIIIIIlIII));
        }
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
    }
    
    private float getHotbarAlpha() {
        final long llllllllllllllIIlIIlIllIIIlIlllI = this.lastSelectionTime - Minecraft.getSystemTime() + 5000L;
        return MathHelper.clamp(llllllllllllllIIlIIlIllIIIlIlllI / 2000.0f, 0.0f, 1.0f);
    }
}
