// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import ru.rockstar.api.utils.world.InventoryHelper;
import net.minecraft.init.Items;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class AutoGapple extends Feature
{
    public static /* synthetic */ NumberSetting health;
    private /* synthetic */ boolean isActive;
    public /* synthetic */ BooleanSetting distanceCheck;
    public /* synthetic */ BooleanSetting shieldSwap;
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIIIIlllIllIlllllIll) {
        this.setSuffix(new StringBuilder().append((int)AutoGapple.health.getNumberValue()).toString(), true);
        if (this.distanceCheck.getBoolValue()) {
            if (KillAura.target.getDistanceToEntity(AutoGapple.mc.player) > 10.0f) {
                if (this.shieldSwap.getBoolValue()) {
                    if (this.isActive) {
                        if (AutoGapple.mc.player.getHeldItemOffhand().getItem() != Items.TOTEM_OF_UNDYING) {
                            if (AutoGapple.mc.player.getHeldItemOffhand().getItem() != Items.GOLDEN_APPLE && InventoryHelper.getItemAtHotbar() != -1) {
                                AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoGapple.mc.player);
                                AutoGapple.mc.playerController.windowClick(0, InventoryHelper.getItemAtHotbar(), 1, ClickType.PICKUP, AutoGapple.mc.player);
                                AutoGapple.mc.playerController.windowClick(0, InventoryHelper.getItemAtHotbar(), 1, ClickType.PICKUP_ALL, AutoGapple.mc.player);
                                AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP_ALL, AutoGapple.mc.player);
                                AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoGapple.mc.player);
                            }
                            else if (AutoGapple.mc.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE) {
                                KeyBinding.setKeyBindState(AutoGapple.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                            }
                        }
                    }
                    else if (AutoGapple.mc.player.getHeldItemOffhand().getItem() != Items.SHIELD && InventoryHelper.getShieldAtHotbar() != -1) {
                        AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP_ALL, AutoGapple.mc.player);
                        AutoGapple.mc.playerController.windowClick(0, InventoryHelper.getShieldAtHotbar(), 1, ClickType.PICKUP, AutoGapple.mc.player);
                        AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoGapple.mc.player);
                    }
                    else if (AutoGapple.mc.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE) {
                        KeyBinding.setKeyBindState(AutoGapple.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    if (AutoGapple.mc.player == null || AutoGapple.mc.world == null) {
                        return;
                    }
                    if (AutoGapple.mc.player.getHealth() <= AutoGapple.health.getNumberValue()) {
                        if (AutoGapple.mc.currentScreen != null) {
                            final GuiScreen lllllllllllllIIIIlllIllIlllllIlI = AutoGapple.mc.currentScreen;
                            lllllllllllllIIIIlllIllIlllllIlI.allowUserInput = true;
                        }
                        this.isActive = true;
                    }
                    else if (this.isActive) {
                        KeyBinding.setKeyBindState(AutoGapple.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                        this.isActive = false;
                    }
                }
                else {
                    if (AutoGapple.mc.player == null || AutoGapple.mc.world == null) {
                        return;
                    }
                    if (this.isGoldenApple(AutoGapple.mc.player.getHeldItemOffhand()) && AutoGapple.mc.player.getHealth() <= AutoGapple.health.getNumberValue()) {
                        this.isActive = true;
                        KeyBinding.setKeyBindState(AutoGapple.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    }
                    else if (this.isActive) {
                        KeyBinding.setKeyBindState(AutoGapple.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                        this.isActive = false;
                    }
                }
            }
        }
        else if (this.shieldSwap.getBoolValue()) {
            if (this.isActive) {
                if (AutoGapple.mc.player.getHeldItemOffhand().getItem() != Items.TOTEM_OF_UNDYING) {
                    if (AutoGapple.mc.player.getHeldItemOffhand().getItem() != Items.GOLDEN_APPLE && InventoryHelper.getItemAtHotbar() != -1) {
                        AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoGapple.mc.player);
                        AutoGapple.mc.playerController.windowClick(0, InventoryHelper.getItemAtHotbar(), 1, ClickType.PICKUP, AutoGapple.mc.player);
                        AutoGapple.mc.playerController.windowClick(0, InventoryHelper.getItemAtHotbar(), 1, ClickType.PICKUP_ALL, AutoGapple.mc.player);
                        AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP_ALL, AutoGapple.mc.player);
                        AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoGapple.mc.player);
                    }
                    else if (AutoGapple.mc.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE) {
                        AutoGapple.mc.gameSettings.keyBindUseItem.pressed = true;
                    }
                }
            }
            else if (AutoGapple.mc.player.getHeldItemOffhand().getItem() != Items.SHIELD && InventoryHelper.getShieldAtHotbar() != -1) {
                AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP_ALL, AutoGapple.mc.player);
                AutoGapple.mc.playerController.windowClick(0, InventoryHelper.getShieldAtHotbar(), 1, ClickType.PICKUP, AutoGapple.mc.player);
                AutoGapple.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoGapple.mc.player);
            }
            else if (AutoGapple.mc.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE) {
                AutoGapple.mc.gameSettings.keyBindUseItem.pressed = false;
            }
            if (AutoGapple.mc.player == null || AutoGapple.mc.world == null) {
                return;
            }
            if (AutoGapple.mc.player.getHealth() <= AutoGapple.health.getNumberValue()) {
                this.isActive = true;
            }
            else if (this.isActive) {
                this.isActive = false;
            }
        }
        else {
            if (AutoGapple.mc.player == null || AutoGapple.mc.world == null) {
                return;
            }
            if (this.isGoldenApple(AutoGapple.mc.player.getHeldItemOffhand()) && AutoGapple.mc.player.getHealth() <= AutoGapple.health.getNumberValue()) {
                this.isActive = true;
                AutoGapple.mc.gameSettings.keyBindUseItem.pressed = true;
            }
            else if (this.isActive) {
                AutoGapple.mc.gameSettings.keyBindUseItem.pressed = false;
                this.isActive = false;
            }
        }
    }
    
    public AutoGapple() {
        super("AutoGApple", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0435\u0441\u0442 \u044f\u0431\u043b\u043e\u043a\u043e \u043f\u0440\u0438 \u043e\u043f\u0440\u0435\u0434\u043b\u0435\u043d\u043d\u043e\u043c \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435", 0, Category.COMBAT);
        this.shieldSwap = new BooleanSetting("Shield Swap", false, () -> true);
        this.distanceCheck = new BooleanSetting("Distance Check", false, () -> true);
        AutoGapple.health = new NumberSetting("Health", 15.0f, 1.0f, 20.0f, 1.0f, () -> true);
        this.addSettings(AutoGapple.health, this.shieldSwap, this.distanceCheck);
    }
    
    private boolean isGoldenApple(final ItemStack lllllllllllllIIIIlllIllIllllIlII) {
        return lllllllllllllIIIIlllIllIllllIlII != null && !lllllllllllllIIIIlllIllIllllIlII.isEmpty() && lllllllllllllIIIIlllIllIllllIlII.getItem() instanceof ItemAppleGold;
    }
}
