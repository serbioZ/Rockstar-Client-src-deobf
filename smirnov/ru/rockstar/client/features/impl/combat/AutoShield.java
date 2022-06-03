// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import net.minecraft.item.ItemStack;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import ru.rockstar.api.utils.world.InventoryHelper;
import net.minecraft.init.Items;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class AutoShield extends Feature
{
    public static /* synthetic */ NumberSetting health;
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIllIlIIllllIllllllIll) {
        if (AutoShield.mc.player.getHealth() > AutoShield.health.getNumberValue()) {
            return;
        }
        if (AutoShield.mc.player.getHeldItemOffhand().getItem() != Items.TOTEM_OF_UNDYING && InventoryHelper.getTotemAtHotbar() != -1 && AutoShield.mc.player.getHeldItemOffhand().getItem() != Items.SHIELD && InventoryHelper.getShieldAtHotbar() != -1) {
            AutoShield.mc.playerController.windowClick(0, InventoryHelper.getShieldAtHotbar(), 1, ClickType.PICKUP, AutoShield.mc.player);
            AutoShield.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoShield.mc.player);
        }
    }
    
    public AutoShield() {
        super("AutoShield", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0431\u0435\u0440\u0435\u0442 \u0432 \u0440\u0443\u043a\u0443 \u0449\u0438\u0442 \u043f\u0440\u0438 \u043e\u043f\u0440\u0435\u0434\u043b\u0435\u043d\u043d\u043e\u043c \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435", 0, Category.COMBAT);
        AutoShield.health = new NumberSetting("Health", 10.0f, 1.0f, 20.0f, 0.5f, () -> true);
        this.addSettings(AutoShield.health);
    }
    
    private int fountTotemCount() {
        int lllllllllllIllIlIIlllllIIIIIIIlI = 0;
        for (int lllllllllllIllIlIIlllllIIIIIIIIl = 0; lllllllllllIllIlIIlllllIIIIIIIIl < AutoShield.mc.player.inventory.getSizeInventory(); ++lllllllllllIllIlIIlllllIIIIIIIIl) {
            final ItemStack lllllllllllIllIlIIlllllIIIIIIIII = AutoShield.mc.player.inventory.getStackInSlot(lllllllllllIllIlIIlllllIIIIIIIIl);
            if (lllllllllllIllIlIIlllllIIIIIIIII.getItem() == Items.TOTEM_OF_UNDYING) {
                ++lllllllllllIllIlIIlllllIIIIIIIlI;
            }
        }
        return lllllllllllIllIlIIlllllIIIIIIIlI;
    }
}
