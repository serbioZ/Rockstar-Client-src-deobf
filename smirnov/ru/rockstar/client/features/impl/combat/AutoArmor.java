// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.EventTarget;
import java.util.Iterator;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import java.util.List;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class AutoArmor extends Feature
{
    private final /* synthetic */ NumberSetting delay;
    public static /* synthetic */ BooleanSetting openInventory;
    public /* synthetic */ TimerHelper timerUtils;
    
    private int getArmorValue(final ItemArmor lllllllllllIIllIlIlllllllIIllIIl, final ItemStack lllllllllllIIllIlIlllllllIlIIIIl) {
        final int lllllllllllIIllIlIlllllllIlIIIII = lllllllllllIIllIlIlllllllIIllIIl.damageReduceAmount;
        int lllllllllllIIllIlIlllllllIIlllll = 0;
        final int lllllllllllIIllIlIlllllllIIllllI = (int)lllllllllllIIllIlIlllllllIIllIIl.toughness;
        final int lllllllllllIIllIlIlllllllIIlllIl = lllllllllllIIllIlIlllllllIIllIIl.getArmorMaterial().getDamageReductionAmount(EntityEquipmentSlot.LEGS);
        final Enchantment lllllllllllIIllIlIlllllllIIlllII = Enchantments.PROTECTION;
        final int lllllllllllIIllIlIlllllllIIllIll = EnchantmentHelper.getEnchantmentLevel(lllllllllllIIllIlIlllllllIIlllII, lllllllllllIIllIlIlllllllIlIIIIl);
        final DamageSource lllllllllllIIllIlIlllllllIIllIlI = DamageSource.causePlayerDamage(AutoArmor.mc.player);
        lllllllllllIIllIlIlllllllIIlllll = lllllllllllIIllIlIlllllllIIlllII.calcModifierDamage(lllllllllllIIllIlIlllllllIIllIll, lllllllllllIIllIlIlllllllIIllIlI);
        return lllllllllllIIllIlIlllllllIlIIIII * 5 + lllllllllllIIllIlIlllllllIIlllll * 3 + lllllllllllIIllIlIlllllllIIllllI + lllllllllllIIllIlIlllllllIIlllIl;
    }
    
    public AutoArmor() {
        super("AutoArmor", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u043e\u0434\u0435\u0432\u0430\u0435\u0442 \u0431\u0440\u043e\u043d\u044e", 0, Category.COMBAT);
        this.timerUtils = new TimerHelper();
        this.delay = new NumberSetting("Delay", 1.0f, 0.0f, 10.0f, 1.0f, () -> true);
        AutoArmor.openInventory = new BooleanSetting("Only Inventory", "\u0422\u043e\u043b\u044c\u043a\u043e \u043f\u0440\u0438 \u043e\u0442\u043a\u0440\u044b\u0442\u043e\u043c \u0438\u043d\u0432\u0438\u043d\u0442\u0430\u0440\u0435 ", true, () -> true);
        this.addSettings(this.delay, AutoArmor.openInventory);
    }
    
    public static boolean isNullOrEmpty(final ItemStack lllllllllllIIllIlIllllllllIlIIII) {
        return lllllllllllIIllIlIllllllllIlIIII == null || lllllllllllIIllIlIllllllllIlIIII.isEmpty();
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIIllIlIllllllllIIIlIl) {
        this.setSuffix(new StringBuilder().append(this.delay.getNumberValue()).toString(), true);
        if (!(AutoArmor.mc.currentScreen instanceof GuiInventory) && AutoArmor.openInventory.getBoolValue()) {
            return;
        }
        if (AutoArmor.mc.currentScreen instanceof GuiContainer && !(AutoArmor.mc.currentScreen instanceof InventoryEffectRenderer)) {
            return;
        }
        final InventoryPlayer lllllllllllIIllIlIllllllllIIIlII = AutoArmor.mc.player.inventory;
        final int[] lllllllllllIIllIlIllllllllIIIIll = new int[4];
        final int[] lllllllllllIIllIlIllllllllIIIIlI = new int[4];
        for (int lllllllllllIIllIlIllllllllIIIIIl = 0; lllllllllllIIllIlIllllllllIIIIIl < 4; ++lllllllllllIIllIlIllllllllIIIIIl) {
            lllllllllllIIllIlIllllllllIIIIll[lllllllllllIIllIlIllllllllIIIIIl] = -1;
            final ItemStack lllllllllllIIllIlIllllllllIIIIII = lllllllllllIIllIlIllllllllIIIlII.armorItemInSlot(lllllllllllIIllIlIllllllllIIIIIl);
            if (!isNullOrEmpty(lllllllllllIIllIlIllllllllIIIIII) && lllllllllllIIllIlIllllllllIIIIII.getItem() instanceof ItemArmor) {
                final ItemArmor lllllllllllIIllIlIlllllllIllllll = (ItemArmor)lllllllllllIIllIlIllllllllIIIIII.getItem();
                lllllllllllIIllIlIllllllllIIIIlI[lllllllllllIIllIlIllllllllIIIIIl] = this.getArmorValue(lllllllllllIIllIlIlllllllIllllll, lllllllllllIIllIlIllllllllIIIIII);
            }
        }
        for (int lllllllllllIIllIlIlllllllIlllllI = 0; lllllllllllIIllIlIlllllllIlllllI < 36; ++lllllllllllIIllIlIlllllllIlllllI) {
            final ItemStack lllllllllllIIllIlIlllllllIllllIl = lllllllllllIIllIlIllllllllIIIlII.getStackInSlot(lllllllllllIIllIlIlllllllIlllllI);
            if (!isNullOrEmpty(lllllllllllIIllIlIlllllllIllllIl) && lllllllllllIIllIlIlllllllIllllIl.getItem() instanceof ItemArmor) {
                final ItemArmor lllllllllllIIllIlIlllllllIllllII = (ItemArmor)lllllllllllIIllIlIlllllllIllllIl.getItem();
                final int lllllllllllIIllIlIlllllllIlllIll = lllllllllllIIllIlIlllllllIllllII.armorType.getIndex();
                final int lllllllllllIIllIlIlllllllIlllIlI = this.getArmorValue(lllllllllllIIllIlIlllllllIllllII, lllllllllllIIllIlIlllllllIllllIl);
                if (lllllllllllIIllIlIlllllllIlllIlI > lllllllllllIIllIlIllllllllIIIIlI[lllllllllllIIllIlIlllllllIlllIll]) {
                    lllllllllllIIllIlIllllllllIIIIll[lllllllllllIIllIlIlllllllIlllIll] = lllllllllllIIllIlIlllllllIlllllI;
                    lllllllllllIIllIlIllllllllIIIIlI[lllllllllllIIllIlIlllllllIlllIll] = lllllllllllIIllIlIlllllllIlllIlI;
                }
            }
        }
        final ArrayList<Integer> lllllllllllIIllIlIlllllllIlllIIl = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3));
        Collections.shuffle(lllllllllllIIllIlIlllllllIlllIIl);
        for (final int lllllllllllIIllIlIlllllllIlllIII : lllllllllllIIllIlIlllllllIlllIIl) {
            int lllllllllllIIllIlIlllllllIllIlll = lllllllllllIIllIlIllllllllIIIIll[lllllllllllIIllIlIlllllllIlllIII];
            if (lllllllllllIIllIlIlllllllIllIlll == -1) {
                continue;
            }
            final ItemStack lllllllllllIIllIlIlllllllIllIllI = lllllllllllIIllIlIllllllllIIIlII.armorItemInSlot(lllllllllllIIllIlIlllllllIlllIII);
            if (!isNullOrEmpty(lllllllllllIIllIlIlllllllIllIllI) && lllllllllllIIllIlIllllllllIIIlII.getFirstEmptyStack() == -1) {
                continue;
            }
            if (lllllllllllIIllIlIlllllllIllIlll < 9) {
                lllllllllllIIllIlIlllllllIllIlll += 36;
            }
            if (this.timerUtils.hasReached(this.delay.getNumberValue() * 100.0f)) {
                if (!isNullOrEmpty(lllllllllllIIllIlIlllllllIllIllI)) {
                    AutoArmor.mc.playerController.windowClick(0, 8 - lllllllllllIIllIlIlllllllIlllIII, 0, ClickType.QUICK_MOVE, AutoArmor.mc.player);
                }
                AutoArmor.mc.playerController.windowClick(0, lllllllllllIIllIlIlllllllIllIlll, 0, ClickType.QUICK_MOVE, AutoArmor.mc.player);
                this.timerUtils.reset();
                break;
            }
            break;
        }
    }
}
