// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.item.ItemCompass;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.inventory.ContainerChest;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.features.Feature;

public class ChestStealer extends Feature
{
    public /* synthetic */ TimerHelper timer;
    private final /* synthetic */ NumberSetting delay;
    public static /* synthetic */ BooleanSetting autoDisable;
    
    @EventTarget
    public void onUpdate(final EventPreMotionUpdate lIlllIllIlIIllI) {
        this.setSuffix(new StringBuilder().append((int)this.delay.getNumberValue()).toString(), true);
        final float lIlllIllIlIIlIl = this.delay.getNumberValue() * 10.0f;
        if (ChestStealer.mc.player.openContainer instanceof ContainerChest) {
            final ContainerChest lIlllIllIlIIlII = (ContainerChest)ChestStealer.mc.player.openContainer;
            for (int lIlllIllIlIIIll = 0; lIlllIllIlIIIll < lIlllIllIlIIlII.inventorySlots.size(); ++lIlllIllIlIIIll) {
                if (lIlllIllIlIIlII.getLowerChestInventory().getStackInSlot(lIlllIllIlIIIll).getItem() != Item.getItemById(0) && this.timer.hasReached(lIlllIllIlIIlIl)) {
                    ChestStealer.mc.playerController.windowClick(lIlllIllIlIIlII.windowId, lIlllIllIlIIIll, 0, ClickType.QUICK_MOVE, ChestStealer.mc.player);
                    this.timer.reset();
                }
                else if (this.isEmpty(lIlllIllIlIIlII)) {
                    ChestStealer.mc.player.closeScreen();
                    if (ChestStealer.autoDisable.getBoolValue()) {
                        super.onDisable();
                    }
                }
            }
        }
    }
    
    private boolean isEmpty(final Container lIlllIllIIlIllI) {
        for (int lIlllIllIIlIlIl = 0; lIlllIllIIlIlIl < lIlllIllIIlIllI.inventorySlots.size(); ++lIlllIllIIlIlIl) {
            if (this.isWhiteItem(lIlllIllIIlIllI.getSlot(lIlllIllIIlIlIl).getStack())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isWhiteItem(final ItemStack lIlllIllIIllIll) {
        return lIlllIllIIllIll.getItem() instanceof ItemArmor || lIlllIllIIllIll.getItem() instanceof ItemEnderPearl || lIlllIllIIllIll.getItem() instanceof ItemSword || lIlllIllIIllIll.getItem() instanceof ItemTool || lIlllIllIIllIll.getItem() instanceof ItemFood || lIlllIllIIllIll.getItem() instanceof ItemPotion || lIlllIllIIllIll.getItem() instanceof ItemBlock || lIlllIllIIllIll.getItem() instanceof ItemArrow || lIlllIllIIllIll.getItem() instanceof ItemCompass;
    }
    
    public ChestStealer() {
        super("ChestStealer", "\u0417\u0430\u0431\u0438\u0440\u0430\u0435\u0442 \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u043c\u043e\u0435 \u0441\u0443\u043d\u0434\u0443\u043a\u0430 ", 0, Category.PLAYER);
        this.timer = new TimerHelper();
        this.delay = new NumberSetting("Stealer Speed", 10.0f, 0.0f, 100.0f, 1.0f, () -> true);
        ChestStealer.autoDisable = new BooleanSetting("AutoDisable", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0432\u044b\u043a\u043b\u044e\u0447\u0430\u0435\u0442 \u0444\u0443\u043d\u043a\u0446\u0438\u044e", true, () -> true);
        this.addSettings(this.delay, ChestStealer.autoDisable);
    }
}
