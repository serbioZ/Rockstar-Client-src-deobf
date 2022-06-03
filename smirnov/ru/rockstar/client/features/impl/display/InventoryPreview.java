// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.RenderHelper;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.client.ui.draggable.impl.InvPreviewComponent;
import ru.rockstar.Main;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class InventoryPreview extends Feature
{
    public static /* synthetic */ NumberSetting y;
    public static /* synthetic */ NumberSetting x;
    
    @EventTarget
    public void ebatkopat(final Event2D llllllllllllllIlIIlIIIlIllIIIlIl) {
        if (InventoryPreview.mc.player == null || InventoryPreview.mc.world == null || !Main.featureDirector.getFeatureByClass(InventoryPreview.class).isToggled()) {
            return;
        }
        if (InventoryPreview.mc.gameSettings.showDebugInfo) {
            return;
        }
        final float llllllllllllllIlIIlIIIlIllIIIlII = (float)InvPreviewComponent.x;
        final float llllllllllllllIlIIlIIIlIllIIIIll = (float)InvPreviewComponent.y;
        final float llllllllllllllIlIIlIIIlIllIIIIlI = llllllllllllllIlIIlIIIlIllIIIlII;
        final float llllllllllllllIlIIlIIIlIllIIIIIl = llllllllllllllIlIIlIIIlIllIIIIll;
        final float llllllllllllllIlIIlIIIlIllIIIIII = llllllllllllllIlIIlIIIlIllIIIIlI + 145.0f;
        final float llllllllllllllIlIIlIIIlIlIllllll = llllllllllllllIlIIlIIIlIllIIIIIl + 45.0f;
        GlStateManager.pushMatrix();
        DrawHelper.drawRect(llllllllllllllIlIIlIIIlIllIIIlII - 2.0f, llllllllllllllIlIIlIIIlIllIIIIll - 16.0f, llllllllllllllIlIIlIIIlIllIIIlII + 147.0f, llllllllllllllIlIIlIIIlIllIIIIll + 51.0f, new Color(30, 30, 30, 175).getRGB());
        DrawHelper.drawGradientRect1(llllllllllllllIlIIlIIIlIllIIIlII - 3.0f, llllllllllllllIlIIlIIIlIllIIIIll - 16.0f, llllllllllllllIlIIlIIIlIllIIIIII + 3.0f, llllllllllllllIlIIlIIIlIllIIIIll - 3.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        InventoryPreview.mc.mntsb_16.drawStringWithShadow("Inventory Preview", llllllllllllllIlIIlIIIlIllIIIlII + 32.0f, llllllllllllllIlIIlIIIlIllIIIIll - 12.0f, -1);
        GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        for (int llllllllllllllIlIIlIIIlIlIlllllI = 0; llllllllllllllIlIIlIIIlIlIlllllI < 27; ++llllllllllllllIlIIlIIIlIlIlllllI) {
            final ItemStack llllllllllllllIlIIlIIIlIlIllllIl = InventoryPreview.mc.player.inventory.mainInventory.get(llllllllllllllIlIIlIIIlIlIlllllI + 9);
            final int llllllllllllllIlIIlIIIlIlIllllII = (int)(llllllllllllllIlIIlIIIlIllIIIlII + llllllllllllllIlIIlIIIlIlIlllllI % 9 * 16);
            final int llllllllllllllIlIIlIIIlIlIlllIll = (int)(llllllllllllllIlIIlIIIlIllIIIIll + llllllllllllllIlIIlIIIlIlIlllllI / 9 * 16);
            InventoryPreview.mc.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllIlIIlIIIlIlIllllIl, llllllllllllllIlIIlIIIlIlIllllII, llllllllllllllIlIIlIIIlIlIlllIll);
            InventoryPreview.mc.getRenderItem().renderItemOverlayIntoGUI(Minecraft.fontRendererObj, llllllllllllllIlIIlIIIlIlIllllIl, llllllllllllllIlIIlIIIlIlIllllII, llllllllllllllIlIIlIIIlIlIlllIll, null);
        }
        GlStateManager.popMatrix();
        InventoryPreview.mc.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    public InventoryPreview() {
        super("InventoryPreview", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043f\u0440\u0435\u0432\u044c\u044e \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044f", 0, Category.DISPLAY);
        InventoryPreview.x = new NumberSetting("Indicators X", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
        InventoryPreview.y = new NumberSetting("Indicators Y", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
    }
}
