// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.RenderHelper;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.display.InventoryPreview;
import ru.rockstar.Main;
import ru.rockstar.client.ui.draggable.DraggableModule;

public class InvPreviewComponent extends DraggableModule
{
    public /* synthetic */ int lastJ;
    public static /* synthetic */ int y;
    public /* synthetic */ int lastA;
    public /* synthetic */ int lastW;
    public /* synthetic */ int lastS2;
    public static /* synthetic */ int x;
    public /* synthetic */ int lastD;
    public /* synthetic */ int lastS;
    
    public InvPreviewComponent() {
        super("InvPreviewComponent", 400, 400);
        this.lastA = 0;
        this.lastW = 0;
        this.lastS = 0;
        this.lastD = 0;
        this.lastJ = 0;
        this.lastS2 = 0;
    }
    
    @Override
    public int getHeight() {
        return 100;
    }
    
    @Override
    public void draw() {
        if (this.mc.player == null || this.mc.world == null || !Main.featureDirector.getFeatureByClass(InventoryPreview.class).isToggled()) {
            return;
        }
        if (this.mc.gameSettings.showDebugInfo) {
            return;
        }
        InvPreviewComponent.x = this.getX();
        InvPreviewComponent.y = this.getY();
        final float lllllllllllIIIIIlllIIIIllIIIIIlI = (float)InvPreviewComponent.x;
        final float lllllllllllIIIIIlllIIIIllIIIIIIl = (float)InvPreviewComponent.y;
        final float lllllllllllIIIIIlllIIIIllIIIIIII = lllllllllllIIIIIlllIIIIllIIIIIlI + 145.0f;
        final float lllllllllllIIIIIlllIIIIlIlllllll = lllllllllllIIIIIlllIIIIllIIIIIIl + 45.0f;
        GlStateManager.pushMatrix();
        DrawHelper.drawRect(InvPreviewComponent.x - 2, InvPreviewComponent.y - 16.0f, InvPreviewComponent.x + 147.0f, InvPreviewComponent.y + 51.0f, new Color(30, 30, 30, 175).getRGB());
        DrawHelper.drawGradientRect1(InvPreviewComponent.x - 3, InvPreviewComponent.y - 16.0f, lllllllllllIIIIIlllIIIIllIIIIIII + 3.0f, InvPreviewComponent.y - 3, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        this.mc.mntsb_16.drawStringWithShadow("Inventory Preview", InvPreviewComponent.x + 32.0f, InvPreviewComponent.y - 12.0f, -1);
        GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        for (int lllllllllllIIIIIlllIIIIlIllllllI = 0; lllllllllllIIIIIlllIIIIlIllllllI < 27; ++lllllllllllIIIIIlllIIIIlIllllllI) {
            final ItemStack lllllllllllIIIIIlllIIIIlIlllllIl = this.mc.player.inventory.mainInventory.get(lllllllllllIIIIIlllIIIIlIllllllI + 9);
            final int lllllllllllIIIIIlllIIIIlIlllllII = InvPreviewComponent.x + lllllllllllIIIIIlllIIIIlIllllllI % 9 * 16;
            final int lllllllllllIIIIIlllIIIIlIllllIll = InvPreviewComponent.y + lllllllllllIIIIIlllIIIIlIllllllI / 9 * 16;
            this.mc.getRenderItem().renderItemAndEffectIntoGUI(lllllllllllIIIIIlllIIIIlIlllllIl, lllllllllllIIIIIlllIIIIlIlllllII, lllllllllllIIIIIlllIIIIlIllllIll);
            this.mc.getRenderItem().renderItemOverlayIntoGUI(Minecraft.fontRendererObj, lllllllllllIIIIIlllIIIIlIlllllIl, lllllllllllIIIIIlllIIIIlIlllllII, lllllllllllIIIIIlllIIIIlIllllIll, null);
        }
        GlStateManager.popMatrix();
        this.mc.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.popMatrix();
        super.draw();
    }
    
    @Override
    public int getWidth() {
        return 100;
    }
    
    @Override
    public void render(final int lllllllllllIIIIIlllIIIIllIIlIllI, final int lllllllllllIIIIIlllIIIIllIIlIlIl) {
        if (this.mc.player == null || this.mc.world == null || !Main.featureDirector.getFeatureByClass(InventoryPreview.class).isToggled()) {
            return;
        }
        if (this.mc.gameSettings.showDebugInfo) {
            return;
        }
        InvPreviewComponent.x = this.getX();
        InvPreviewComponent.y = this.getY();
        final float lllllllllllIIIIIlllIIIIllIIlllll = (float)InvPreviewComponent.x;
        final float lllllllllllIIIIIlllIIIIllIIllllI = (float)InvPreviewComponent.y;
        final float lllllllllllIIIIIlllIIIIllIIlllIl = lllllllllllIIIIIlllIIIIllIIlllll + 145.0f;
        final float lllllllllllIIIIIlllIIIIllIIlllII = lllllllllllIIIIIlllIIIIllIIllllI + 45.0f;
        GlStateManager.pushMatrix();
        DrawHelper.drawRect(InvPreviewComponent.x - 2, InvPreviewComponent.y - 16.0f, InvPreviewComponent.x + 147.0f, InvPreviewComponent.y + 51.0f, new Color(30, 30, 30, 175).getRGB());
        DrawHelper.drawGradientRect1(InvPreviewComponent.x - 3, InvPreviewComponent.y - 16.0f, lllllllllllIIIIIlllIIIIllIIlllIl + 3.0f, InvPreviewComponent.y - 3, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        this.mc.mntsb_16.drawStringWithShadow("Inventory Preview", InvPreviewComponent.x + 32.0f, InvPreviewComponent.y - 12.0f, -1);
        GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        for (int lllllllllllIIIIIlllIIIIllIIllIll = 0; lllllllllllIIIIIlllIIIIllIIllIll < 27; ++lllllllllllIIIIIlllIIIIllIIllIll) {
            final ItemStack lllllllllllIIIIIlllIIIIllIIllIlI = this.mc.player.inventory.mainInventory.get(lllllllllllIIIIIlllIIIIllIIllIll + 9);
            final int lllllllllllIIIIIlllIIIIllIIllIIl = InvPreviewComponent.x + lllllllllllIIIIIlllIIIIllIIllIll % 9 * 16;
            final int lllllllllllIIIIIlllIIIIllIIllIII = InvPreviewComponent.y + lllllllllllIIIIIlllIIIIllIIllIll / 9 * 16;
            this.mc.getRenderItem().renderItemAndEffectIntoGUI(lllllllllllIIIIIlllIIIIllIIllIlI, lllllllllllIIIIIlllIIIIllIIllIIl, lllllllllllIIIIIlllIIIIllIIllIII);
            this.mc.getRenderItem().renderItemOverlayIntoGUI(Minecraft.fontRendererObj, lllllllllllIIIIIlllIIIIllIIllIlI, lllllllllllIIIIIlllIIIIllIIllIIl, lllllllllllIIIIIlllIIIIllIIllIII, null);
        }
        GlStateManager.popMatrix();
        this.mc.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.popMatrix();
        super.render(lllllllllllIIIIIlllIIIIllIIlIllI, lllllllllllIIIIIlllIIIIllIIlIlIl);
    }
}
