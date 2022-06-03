// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.resources.DefaultPlayerSkin;
import com.mojang.util.UUIDTypeAdapter;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenRealmsProxy;

public class RealmsScreen
{
    private final /* synthetic */ GuiScreenRealmsProxy proxy;
    
    public static void bind(final String lllllllllllllIIIlllIIIIIlIIlIlll) {
        final ResourceLocation lllllllllllllIIIlllIIIIIlIIlIllI = new ResourceLocation(lllllllllllllIIIlllIIIIIlIIlIlll);
        Minecraft.getMinecraft().getTextureManager().bindTexture(lllllllllllllIIIlllIIIIIlIIlIllI);
    }
    
    public void renderBackground(final int lllllllllllllIIIlllIIIIIllIlIllI) {
        this.proxy.drawWorldBackground(lllllllllllllIIIlllIIIIIllIlIllI);
    }
    
    public void fillGradient(final int lllllllllllllIIIlllIIIIIlllIIlll, final int lllllllllllllIIIlllIIIIIlllIllIl, final int lllllllllllllIIIlllIIIIIlllIllII, final int lllllllllllllIIIlllIIIIIlllIlIll, final int lllllllllllllIIIlllIIIIIlllIlIlI, final int lllllllllllllIIIlllIIIIIlllIIIlI) {
        this.proxy.drawGradientRect(lllllllllllllIIIlllIIIIIlllIIlll, lllllllllllllIIIlllIIIIIlllIllIl, lllllllllllllIIIlllIIIIIlllIllII, lllllllllllllIIIlllIIIIIlllIlIll, lllllllllllllIIIlllIIIIIlllIlIlI, lllllllllllllIIIlllIIIIIlllIIIlI);
    }
    
    public void mouseClicked(final int lllllllllllllIIIlllIIIIIIIlIlIII, final int lllllllllllllIIIlllIIIIIIIlIIlll, final int lllllllllllllIIIlllIIIIIIIlIIllI) {
    }
    
    public void tick() {
    }
    
    public void buttonClicked(final RealmsButton lllllllllllllIIIlllIIIIIIllIlIlI) {
    }
    
    public List<String> fontSplit(final String lllllllllllllIIIlllIIIIIIllIllIl, final int lllllllllllllIIIlllIIIIIIllIllll) {
        return this.proxy.fontSplit(lllllllllllllIIIlllIIIIIIllIllIl, lllllllllllllIIIlllIIIIIIllIllll);
    }
    
    public RealmsAnvilLevelStorageSource getLevelStorageSource() {
        return new RealmsAnvilLevelStorageSource(Minecraft.getMinecraft().getSaveLoader());
    }
    
    public int fontLineHeight() {
        return this.proxy.getFontHeight();
    }
    
    public void blit(final int lllllllllllllIIIlllIIIIlIIllIIlI, final int lllllllllllllIIIlllIIIIlIIllIIIl, final int lllllllllllllIIIlllIIIIlIIllIlll, final int lllllllllllllIIIlllIIIIlIIlIllll, final int lllllllllllllIIIlllIIIIlIIllIlIl, final int lllllllllllllIIIlllIIIIlIIlIllIl) {
        this.proxy.drawTexturedModalRect(lllllllllllllIIIlllIIIIlIIllIIlI, lllllllllllllIIIlllIIIIlIIllIIIl, lllllllllllllIIIlllIIIIlIIllIlll, lllllllllllllIIIlllIIIIlIIlIllll, lllllllllllllIIIlllIIIIlIIllIlIl, lllllllllllllIIIlllIIIIlIIlIllIl);
    }
    
    public static String getLocalizedString(final String lllllllllllllIIIlllIIIIIIIIIllIl, final Object... lllllllllllllIIIlllIIIIIIIIIlllI) {
        return I18n.format(lllllllllllllIIIlllIIIIIIIIIllIl, lllllllllllllIIIlllIIIIIIIIIlllI);
    }
    
    public void render(final int lllllllllllllIIIlllIIIIIllIIllll, final int lllllllllllllIIIlllIIIIIllIIlllI, final float lllllllllllllIIIlllIIIIIllIIlIII) {
        for (int lllllllllllllIIIlllIIIIIllIIllII = 0; lllllllllllllIIIlllIIIIIllIIllII < this.proxy.buttons().size(); ++lllllllllllllIIIlllIIIIIllIIllII) {
            this.proxy.buttons().get(lllllllllllllIIIlllIIIIIllIIllII).render(lllllllllllllIIIlllIIIIIllIIllll, lllllllllllllIIIlllIIIIIllIIlllI, lllllllllllllIIIlllIIIIIllIIlIII);
        }
    }
    
    public RealmsEditBox newEditBox(final int lllllllllllllIIIlllIIIIIIIllIIll, final int lllllllllllllIIIlllIIIIIIIllIIlI, final int lllllllllllllIIIlllIIIIIIIllIIIl, final int lllllllllllllIIIlllIIIIIIIlIlIll, final int lllllllllllllIIIlllIIIIIIIlIlIlI) {
        return new RealmsEditBox(lllllllllllllIIIlllIIIIIIIllIIll, lllllllllllllIIIlllIIIIIIIllIIlI, lllllllllllllIIIlllIIIIIIIllIIIl, lllllllllllllIIIlllIIIIIIIlIlIll, lllllllllllllIIIlllIIIIIIIlIlIlI);
    }
    
    public void mouseReleased(final int lllllllllllllIIIlllIIIIIIIlIIIlI, final int lllllllllllllIIIlllIIIIIIIlIIIIl, final int lllllllllllllIIIlllIIIIIIIlIIIII) {
    }
    
    public static RealmsButton newButton(final int lllllllllllllIIIlllIIIIIIlIlIIIl, final int lllllllllllllIIIlllIIIIIIlIlIllI, final int lllllllllllllIIIlllIIIIIIlIlIlIl, final int lllllllllllllIIIlllIIIIIIlIlIlII, final int lllllllllllllIIIlllIIIIIIlIIllIl, final String lllllllllllllIIIlllIIIIIIlIlIIlI) {
        return new RealmsButton(lllllllllllllIIIlllIIIIIIlIlIIIl, lllllllllllllIIIlllIIIIIIlIlIllI, lllllllllllllIIIlllIIIIIIlIlIlIl, lllllllllllllIIIlllIIIIIIlIlIlII, lllllllllllllIIIlllIIIIIIlIIllIl, lllllllllllllIIIlllIIIIIIlIlIIlI);
    }
    
    public void renderTooltip(final String lllllllllllllIIIlllIIIIIlIllIlIl, final int lllllllllllllIIIlllIIIIIlIllIIII, final int lllllllllllllIIIlllIIIIIlIllIIll) {
        this.proxy.drawCreativeTabHoveringText(lllllllllllllIIIlllIIIIIlIllIlIl, lllllllllllllIIIlllIIIIIlIllIIII, lllllllllllllIIIlllIIIIIlIllIIll);
    }
    
    public void buttonsAdd(final RealmsButton lllllllllllllIIIlllIIIIIIlIIIIll) {
        this.proxy.buttonsAdd(lllllllllllllIIIlllIIIIIIlIIIIll);
    }
    
    public boolean isPauseScreen() {
        return this.proxy.doesGuiPauseGame();
    }
    
    public static void blit(final int lllllllllllllIIIlllIIIIlIIIllIII, final int lllllllllllllIIIlllIIIIlIIlIIIIl, final float lllllllllllllIIIlllIIIIlIIlIIIII, final float lllllllllllllIIIlllIIIIlIIIlIlIl, final int lllllllllllllIIIlllIIIIlIIIlIlII, final int lllllllllllllIIIlllIIIIlIIIlIIll, final int lllllllllllllIIIlllIIIIlIIIlIIlI, final int lllllllllllllIIIlllIIIIlIIIlIIIl, final float lllllllllllllIIIlllIIIIlIIIllIlI, final float lllllllllllllIIIlllIIIIlIIIllIIl) {
        Gui.drawScaledCustomSizeModalRect(lllllllllllllIIIlllIIIIlIIIllIII, lllllllllllllIIIlllIIIIlIIlIIIIl, lllllllllllllIIIlllIIIIlIIlIIIII, lllllllllllllIIIlllIIIIlIIIlIlIl, lllllllllllllIIIlllIIIIlIIIlIlII, lllllllllllllIIIlllIIIIlIIIlIIll, lllllllllllllIIIlllIIIIlIIIlIIlI, lllllllllllllIIIlllIIIIlIIIlIIIl, lllllllllllllIIIlllIIIIlIIIllIlI, lllllllllllllIIIlllIIIIlIIIllIIl);
    }
    
    public void init(final Minecraft lllllllllllllIIIlllIIIIlIlllIIlI, final int lllllllllllllIIIlllIIIIlIlllIIIl, final int lllllllllllllIIIlllIIIIlIlllIIII) {
    }
    
    public static RealmsButton newButton(final int lllllllllllllIIIlllIIIIIIllIIIIl, final int lllllllllllllIIIlllIIIIIIllIIlII, final int lllllllllllllIIIlllIIIIIIlIlllll, final String lllllllllllllIIIlllIIIIIIllIIIlI) {
        return new RealmsButton(lllllllllllllIIIlllIIIIIIllIIIIl, lllllllllllllIIIlllIIIIIIllIIlII, lllllllllllllIIIlllIIIIIIlIlllll, lllllllllllllIIIlllIIIIIIllIIIlI);
    }
    
    public int fontWidth(final String lllllllllllllIIIlllIIIIIlIIIIllI) {
        return this.proxy.getStringWidth(lllllllllllllIIIlllIIIIIlIIIIllI);
    }
    
    public void removed() {
    }
    
    public void renderTooltip(final ItemStack lllllllllllllIIIlllIIIIIlIllllIl, final int lllllllllllllIIIlllIIIIIllIIIIII, final int lllllllllllllIIIlllIIIIIlIllllll) {
        this.proxy.renderToolTip(lllllllllllllIIIlllIIIIIlIllllIl, lllllllllllllIIIlllIIIIIllIIIIII, lllllllllllllIIIlllIIIIIlIllllll);
    }
    
    public int height() {
        return this.proxy.height;
    }
    
    public void drawString(final String lllllllllllllIIIlllIIIIlIlIIIlIl, final int lllllllllllllIIIlllIIIIlIlIIlIlI, final int lllllllllllllIIIlllIIIIlIlIIIIll, final int lllllllllllllIIIlllIIIIlIlIIIIlI, final boolean lllllllllllllIIIlllIIIIlIlIIIlll) {
        this.proxy.drawString(lllllllllllllIIIlllIIIIlIlIIIlIl, lllllllllllllIIIlllIIIIlIlIIlIlI, lllllllllllllIIIlllIIIIlIlIIIIll, lllllllllllllIIIlllIIIIlIlIIIIlI, false);
    }
    
    public GuiScreenRealmsProxy getProxy() {
        return this.proxy;
    }
    
    public List<RealmsButton> buttons() {
        return this.proxy.buttons();
    }
    
    public RealmsScreen() {
        this.proxy = new GuiScreenRealmsProxy(this);
    }
    
    public void confirmResult(final boolean lllllllllllllIIIlllIIIIIIIIlIllI, final int lllllllllllllIIIlllIIIIIIIIlIlIl) {
    }
    
    public static void bindFace(final String lllllllllllllIIIlllIIIIIlIIlllII, final String lllllllllllllIIIlllIIIIIlIIllllI) {
        ResourceLocation lllllllllllllIIIlllIIIIIlIIlllIl = AbstractClientPlayer.getLocationSkin(lllllllllllllIIIlllIIIIIlIIllllI);
        if (lllllllllllllIIIlllIIIIIlIIlllIl == null) {
            lllllllllllllIIIlllIIIIIlIIlllIl = DefaultPlayerSkin.getDefaultSkin(UUIDTypeAdapter.fromString(lllllllllllllIIIlllIIIIIlIIlllII));
        }
        AbstractClientPlayer.getDownloadImageSkin(lllllllllllllIIIlllIIIIIlIIlllIl, lllllllllllllIIIlllIIIIIlIIllllI);
        Minecraft.getMinecraft().getTextureManager().bindTexture(lllllllllllllIIIlllIIIIIlIIlllIl);
    }
    
    public void buttonsClear() {
        this.proxy.buttonsClear();
    }
    
    public void mouseEvent() {
    }
    
    public static String getLocalizedString(final String lllllllllllllIIIlllIIIIIIIIlIIll) {
        return I18n.format(lllllllllllllIIIlllIIIIIIIIlIIll, new Object[0]);
    }
    
    public void mouseDragged(final int lllllllllllllIIIlllIIIIIIIIllllI, final int lllllllllllllIIIlllIIIIIIIIlllIl, final int lllllllllllllIIIlllIIIIIIIIlllII, final long lllllllllllllIIIlllIIIIIIIIllIll) {
    }
    
    public static void blit(final int lllllllllllllIIIlllIIIIIlllllllI, final int lllllllllllllIIIlllIIIIlIIIIIlIl, final float lllllllllllllIIIlllIIIIIllllllII, final float lllllllllllllIIIlllIIIIlIIIIIIll, final int lllllllllllllIIIlllIIIIIlllllIlI, final int lllllllllllllIIIlllIIIIlIIIIIIIl, final float lllllllllllllIIIlllIIIIIlllllIII, final float lllllllllllllIIIlllIIIIIllllIlll) {
        Gui.drawModalRectWithCustomSizedTexture((float)lllllllllllllIIIlllIIIIIlllllllI, (float)lllllllllllllIIIlllIIIIlIIIIIlIl, lllllllllllllIIIlllIIIIIllllllII, lllllllllllllIIIlllIIIIlIIIIIIll, (float)lllllllllllllIIIlllIIIIIlllllIlI, (float)lllllllllllllIIIlllIIIIlIIIIIIIl, lllllllllllllIIIlllIIIIIlllllIII, lllllllllllllIIIlllIIIIIllllIlll);
    }
    
    static {
        SKIN_HEAD_WIDTH = 8;
        SKIN_TEX_HEIGHT = 64;
        SKIN_TEX_WIDTH = 64;
        SKIN_HAT_WIDTH = 8;
        SKIN_HEAD_V = 8;
        SKIN_HEAD_HEIGHT = 8;
        SKIN_HAT_V = 8;
        SKIN_HEAD_U = 8;
        SKIN_HAT_U = 40;
        SKIN_HAT_HEIGHT = 8;
    }
    
    public void renderBackground() {
        this.proxy.drawDefaultBackground();
    }
    
    public void drawCenteredString(final String lllllllllllllIIIlllIIIIlIllIlIIl, final int lllllllllllllIIIlllIIIIlIllIIIll, final int lllllllllllllIIIlllIIIIlIllIIlll, final int lllllllllllllIIIlllIIIIlIllIIllI) {
        this.proxy.drawCenteredString(lllllllllllllIIIlllIIIIlIllIlIIl, lllllllllllllIIIlllIIIIlIllIIIll, lllllllllllllIIIlllIIIIlIllIIlll, lllllllllllllIIIlllIIIIlIllIIllI);
    }
    
    public void renderTooltip(final List<String> lllllllllllllIIIlllIIIIIlIlIIlIl, final int lllllllllllllIIIlllIIIIIlIlIIlII, final int lllllllllllllIIIlllIIIIIlIlIIIll) {
        this.proxy.drawHoveringText(lllllllllllllIIIlllIIIIIlIlIIlIl, lllllllllllllIIIlllIIIIIlIlIIlII, lllllllllllllIIIlllIIIIIlIlIIIll);
    }
    
    public void init() {
    }
    
    public void drawString(final String lllllllllllllIIIlllIIIIlIlIllIlI, final int lllllllllllllIIIlllIIIIlIlIlIlII, final int lllllllllllllIIIlllIIIIlIlIlIIll, final int lllllllllllllIIIlllIIIIlIlIlIlll) {
        this.drawString(lllllllllllllIIIlllIIIIlIlIllIlI, lllllllllllllIIIlllIIIIlIlIlIlII, lllllllllllllIIIlllIIIIlIlIlIIll, lllllllllllllIIIlllIIIIlIlIlIlll, true);
    }
    
    public void buttonsRemove(final RealmsButton lllllllllllllIIIlllIIIIIIIllllII) {
        this.proxy.buttonsRemove(lllllllllllllIIIlllIIIIIIIllllII);
    }
    
    public void keyboardEvent() {
    }
    
    public void keyPressed(final char lllllllllllllIIIlllIIIIIIIIllIIl, final int lllllllllllllIIIlllIIIIIIIIllIII) {
    }
    
    public int width() {
        return this.proxy.width;
    }
    
    public void fontDrawShadow(final String lllllllllllllIIIlllIIIIIIllllIII, final int lllllllllllllIIIlllIIIIIIlllllII, final int lllllllllllllIIIlllIIIIIIllllIll, final int lllllllllllllIIIlllIIIIIIllllIlI) {
        this.proxy.fontDrawShadow(lllllllllllllIIIlllIIIIIIllllIII, lllllllllllllIIIlllIIIIIIlllllII, lllllllllllllIIIlllIIIIIIllllIll, lllllllllllllIIIlllIIIIIIllllIlI);
    }
}
