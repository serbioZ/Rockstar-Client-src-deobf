// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.event.event.Event2D;
import net.minecraft.client.renderer.RenderItem;
import ru.rockstar.client.features.Feature;

public class ArmorHUD extends Feature
{
    private static final /* synthetic */ RenderItem itemRender;
    
    @EventTarget
    public void onRender2D(final Event2D lllllllllllllIlIlIllllIIIIllIIlI) {
        GlStateManager.enableTexture2D();
        final ScaledResolution lllllllllllllIlIlIllllIIIIllIIIl = new ScaledResolution(ArmorHUD.mc);
        final int lllllllllllllIlIlIllllIIIIllIIII = lllllllllllllIlIlIllllIIIIllIIIl.getScaledWidth() / 2;
        int lllllllllllllIlIlIllllIIIIlIllll = 0;
        final int lllllllllllllIlIlIllllIIIIlIlllI = lllllllllllllIlIlIllllIIIIllIIIl.getScaledHeight() - 65 - (ArmorHUD.mc.player.isInWater() ? 10 : 0);
        for (final ItemStack lllllllllllllIlIlIllllIIIIlIllIl : ArmorHUD.mc.player.inventory.armorInventory) {
            ++lllllllllllllIlIlIllllIIIIlIllll;
            if (lllllllllllllIlIlIllllIIIIlIllIl.func_190926_b()) {
                continue;
            }
            final int lllllllllllllIlIlIllllIIIIlIllII = lllllllllllllIlIlIllllIIIIllIIII - 90 + (9 - lllllllllllllIlIlIllllIIIIlIllll) * 20 + 2;
            GlStateManager.enableDepth();
            ArmorHUD.itemRender.zLevel = 200.0f;
            ArmorHUD.itemRender.renderItemAndEffectIntoGUI(lllllllllllllIlIlIllllIIIIlIllIl, lllllllllllllIlIlIllllIIIIlIllII, lllllllllllllIlIlIllllIIIIlIlllI);
            ArmorHUD.itemRender.renderItemOverlayIntoGUI(Minecraft.fontRendererObj, lllllllllllllIlIlIllllIIIIlIllIl, lllllllllllllIlIlIllllIIIIlIllII, lllllllllllllIlIlIllllIIIIlIlllI, "");
            ArmorHUD.itemRender.zLevel = 0.0f;
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            final String lllllllllllllIlIlIllllIIIIlIlIll = (lllllllllllllIlIlIllllIIIIlIllIl.func_190916_E() > 1) ? new StringBuilder(String.valueOf(lllllllllllllIlIlIllllIIIIlIllIl.func_190916_E())).toString() : "";
            ArmorHUD.mc.neverlose500_14.drawStringWithShadow(lllllllllllllIlIlIllllIIIIlIlIll, lllllllllllllIlIlIllllIIIIlIllII + 19 - 2 - ArmorHUD.mc.neverlose500_14.getStringWidth(lllllllllllllIlIlIllllIIIIlIlIll), lllllllllllllIlIlIllllIIIIlIlllI + 20, 16777215);
            final int lllllllllllllIlIlIllllIIIIlIlIlI = Math.abs(lllllllllllllIlIlIllllIIIIlIllIl.getMaxDamage() - lllllllllllllIlIlIllllIIIIlIllIl.getItemDamage());
            ArmorHUD.mc.neverlose500_14.drawStringWithShadow(new StringBuilder(String.valueOf(lllllllllllllIlIlIllllIIIIlIlIlI)).toString(), lllllllllllllIlIlIllllIIIIlIllII + 8 - ArmorHUD.mc.neverlose500_14.getStringWidth(new StringBuilder(String.valueOf(lllllllllllllIlIlIllllIIIIlIlIlI)).toString()) / 2, lllllllllllllIlIlIllllIIIIlIlllI + 18, -1);
        }
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
    }
    
    static {
        itemRender = Minecraft.getMinecraft().getRenderItem();
    }
    
    public ArmorHUD() {
        super("ArmorHUD", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043f\u0440\u043e\u0447\u043d\u043e\u0441\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432, \u043a\u043e\u0442\u043e\u0440\u044b\u0435 \u0432 \u0434\u0430\u043d\u043d\u044b\u0439 \u043c\u043e\u043c\u0435\u043d\u0442 \u043e\u0434\u0435\u0442\u044b", 0, Category.DISPLAY);
    }
}
