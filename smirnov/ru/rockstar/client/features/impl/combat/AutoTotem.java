// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import ru.rockstar.api.utils.movement.MovementHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import ru.rockstar.api.event.event.EventUpdate;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.event.event.EventRender2D;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class AutoTotem extends Feature
{
    public static /* synthetic */ BooleanSetting checkTNT;
    public static /* synthetic */ BooleanSetting saveEnchTotems;
    public static /* synthetic */ BooleanSetting noMoving;
    public static /* synthetic */ NumberSetting radiusToTNT;
    public static /* synthetic */ NumberSetting fallDistance;
    public static /* synthetic */ NumberSetting radiusToCrystal;
    private /* synthetic */ int totemCount;
    public static /* synthetic */ BooleanSetting countTotem;
    public static /* synthetic */ BooleanSetting checkCrystal;
    public static /* synthetic */ BooleanSetting swapBack;
    public static /* synthetic */ BooleanSetting checkFall;
    public static /* synthetic */ NumberSetting health;
    private /* synthetic */ boolean returnOld;
    
    public AutoTotem() {
        super("AutoTotem", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0431\u0435\u0440\u0435\u0442 \u0432 \u0440\u0443\u043a\u0443 \u0442\u043e\u0442\u0435\u043c \u043f\u0440\u0438 \u043e\u043f\u0440\u0435\u0434\u043b\u0435\u043d\u043d\u043e\u043c \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435", 0, Category.COMBAT);
        AutoTotem.health = new NumberSetting("Health Amount", 20.0f, 1.0f, 20.0f, 0.5f, () -> true);
        AutoTotem.noMoving = new BooleanSetting("No Moving Swap", false, () -> true);
        AutoTotem.countTotem = new BooleanSetting("Count Totem", false, () -> true);
        AutoTotem.checkCrystal = new BooleanSetting("Check Crystal", false, () -> true);
        AutoTotem.radiusToCrystal = new NumberSetting("Distance to Crystal", 6.0f, 1.0f, 8.0f, 1.0f, () -> AutoTotem.checkCrystal.getBoolValue());
        AutoTotem.checkTNT = new BooleanSetting("Check TNT", false, () -> true);
        AutoTotem.radiusToTNT = new NumberSetting("Distance to TNT", 6.0f, 1.0f, 8.0f, 1.0f, () -> AutoTotem.checkTNT.getBoolValue());
        AutoTotem.checkFall = new BooleanSetting("Check Fall", false, () -> true);
        AutoTotem.fallDistance = new NumberSetting("Fall Distance", 15.0f, 5.0f, 125.0f, 5.0f, () -> AutoTotem.checkFall.getBoolValue());
        AutoTotem.swapBack = new BooleanSetting("Swap Back", true, () -> true);
        AutoTotem.saveEnchTotems = new BooleanSetting("Save Enchanted Totems", true, () -> true);
        this.addSettings(AutoTotem.health, AutoTotem.noMoving, AutoTotem.countTotem, AutoTotem.swapBack, AutoTotem.saveEnchTotems, AutoTotem.checkCrystal, AutoTotem.radiusToCrystal, AutoTotem.checkTNT, AutoTotem.radiusToTNT, AutoTotem.checkFall, AutoTotem.fallDistance);
    }
    
    private boolean checkFall(final float lllllllllllIllllIIIlIIlIllllIlII) {
        return AutoTotem.checkFall.getBoolValue() && AutoTotem.mc.player.fallDistance > lllllllllllIllllIIIlIIlIllllIlII;
    }
    
    @EventTarget
    public void onRender2D(final EventRender2D lllllllllllIllllIIIlIIlIlllIlllI) {
        if (this.fountTotemCount() > 0 && AutoTotem.countTotem.getBoolValue()) {
            AutoTotem.mc.mntsb.drawStringWithShadow(new StringBuilder(String.valueOf(this.fountTotemCount())).toString(), lllllllllllIllllIIIlIIlIlllIlllI.getResolution().getScaledWidth() / 2.0f + 19.0f, lllllllllllIllllIIIlIIlIlllIlllI.getResolution().getScaledHeight() / 2.0f, -1);
            for (int lllllllllllIllllIIIlIIlIlllIllIl = 0; lllllllllllIllllIIIlIIlIlllIllIl < AutoTotem.mc.player.inventory.getSizeInventory(); ++lllllllllllIllllIIIlIIlIlllIllIl) {
                final ItemStack lllllllllllIllllIIIlIIlIlllIllII = AutoTotem.mc.player.inventory.getStackInSlot(lllllllllllIllllIIIlIIlIlllIllIl);
                if (lllllllllllIllllIIIlIIlIlllIllII.getItem() == Items.TOTEM_OF_UNDYING) {
                    GlStateManager.pushMatrix();
                    GlStateManager.disableBlend();
                    AutoTotem.mc.getRenderItem().renderItemAndEffectIntoGUI(lllllllllllIllllIIIlIIlIlllIllII, lllllllllllIllllIIIlIIlIlllIlllI.getResolution().getScaledWidth() / 2 + 4, lllllllllllIllllIIIlIIlIlllIlllI.getResolution().getScaledHeight() / 2 - 7);
                    GlStateManager.popMatrix();
                }
            }
        }
    }
    
    @Override
    public void onDisable() {
        this.returnOld = false;
        super.onDisable();
    }
    
    private boolean checkCrystal() {
        if (!AutoTotem.checkCrystal.getBoolValue()) {
            return false;
        }
        for (final Entity lllllllllllIllllIIIlIIllIIIIIIII : AutoTotem.mc.world.loadedEntityList) {
            if (lllllllllllIllllIIIlIIllIIIIIIII instanceof EntityEnderCrystal && AutoTotem.mc.player.getDistanceToEntity(lllllllllllIllllIIIlIIllIIIIIIII) <= AutoTotem.radiusToCrystal.getNumberValue()) {
                return true;
            }
        }
        return false;
    }
    
    private int fountTotemCountNoDonat() {
        int lllllllllllIllllIIIlIIllIIIlIIll = 0;
        for (int lllllllllllIllllIIIlIIllIIIlIIlI = 0; lllllllllllIllllIIIlIIllIIIlIIlI < AutoTotem.mc.player.inventory.getSizeInventory(); ++lllllllllllIllllIIIlIIllIIIlIIlI) {
            final ItemStack lllllllllllIllllIIIlIIllIIIlIIIl = AutoTotem.mc.player.inventory.getStackInSlot(lllllllllllIllllIIIlIIllIIIlIIlI);
            if (lllllllllllIllllIIIlIIllIIIlIIIl.getItem() == Items.TOTEM_OF_UNDYING && !lllllllllllIllllIIIlIIllIIIlIIIl.isItemEnchanted()) {
                ++lllllllllllIllllIIIlIIllIIIlIIll;
            }
        }
        return lllllllllllIllllIIIlIIllIIIlIIll;
    }
    
    private boolean checkTNT() {
        if (!AutoTotem.checkTNT.getBoolValue()) {
            return false;
        }
        for (final Entity lllllllllllIllllIIIlIIlIlllllIlI : AutoTotem.mc.world.loadedEntityList) {
            if (lllllllllllIllllIIIlIIlIlllllIlI instanceof EntityTNTPrimed && AutoTotem.mc.player.getDistanceToEntity(lllllllllllIllllIIIlIIlIlllllIlI) <= AutoTotem.radiusToTNT.getNumberValue()) {
                return true;
            }
            if (lllllllllllIllllIIIlIIlIlllllIlI instanceof EntityMinecartTNT && AutoTotem.mc.player.getDistanceToEntity(lllllllllllIllllIIIlIIlIlllllIlI) <= AutoTotem.radiusToTNT.getNumberValue()) {
                return true;
            }
        }
        return false;
    }
    
    private int fountTotemCount() {
        int lllllllllllIllllIIIlIIllIIIIlIIl = 0;
        for (int lllllllllllIllllIIIlIIllIIIIlIII = 0; lllllllllllIllllIIIlIIllIIIIlIII < AutoTotem.mc.player.inventory.getSizeInventory(); ++lllllllllllIllllIIIlIIllIIIIlIII) {
            final ItemStack lllllllllllIllllIIIlIIllIIIIIlll = AutoTotem.mc.player.inventory.getStackInSlot(lllllllllllIllllIIIlIIllIIIIlIII);
            if (lllllllllllIllllIIIlIIllIIIIIlll.getItem() == Items.TOTEM_OF_UNDYING) {
                ++lllllllllllIllllIIIlIIllIIIIlIIl;
            }
        }
        return lllllllllllIllllIIIlIIllIIIIlIIl;
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIllllIIIlIIlIlllIIIll) {
        if (AutoTotem.mc.currentScreen instanceof GuiContainer) {
            return;
        }
        if (AutoTotem.noMoving.getBoolValue() && MovementHelper.isMoving()) {
            return;
        }
        if (this.returnOld && AutoTotem.mc.player.getHealth() > AutoTotem.health.getNumberValue() && !this.checkTNT() && !this.checkCrystal() && !this.checkFall(AutoTotem.fallDistance.getNumberValue())) {
            int lllllllllllIllllIIIlIIlIlllIIIlI = -1;
            for (int lllllllllllIllllIIIlIIlIlllIIIIl = 0; lllllllllllIllllIIIlIIlIlllIIIIl < 45; ++lllllllllllIllllIIIlIIlIlllIIIIl) {
                if (AutoTotem.mc.player.inventory.getStackInSlot(lllllllllllIllllIIIlIIlIlllIIIIl).isEmpty()) {
                    lllllllllllIllllIIIlIIlIlllIIIlI = lllllllllllIllllIIIlIIlIlllIIIIl;
                    break;
                }
            }
            if (lllllllllllIllllIIIlIIlIlllIIIlI == -1) {
                return;
            }
            if (AutoTotem.swapBack.getBoolValue()) {
                AutoTotem.mc.playerController.windowClick(0, (lllllllllllIllllIIIlIIlIlllIIIlI < 9) ? (lllllllllllIllllIIIlIIlIlllIIIlI + 36) : lllllllllllIllllIIIlIIlIlllIIIlI, 0, ClickType.QUICK_MOVE, AutoTotem.mc.player);
                AutoTotem.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, AutoTotem.mc.player);
            }
            AutoTotem.mc.playerController.windowClick(0, (lllllllllllIllllIIIlIIlIlllIIIlI < 9) ? (lllllllllllIllllIIIlIIlIlllIIIlI + 36) : lllllllllllIllllIIIlIIlIlllIIIlI, 0, ClickType.PICKUP, AutoTotem.mc.player);
            this.returnOld = false;
        }
        this.totemCount = AutoTotem.mc.player.inventory.mainInventory.stream().filter(lllllllllllIllllIIIlIIlIllIllIIl -> lllllllllllIllllIIIlIIlIllIllIIl.getItem() == Items.TOTEM_OF_UNDYING).mapToInt(ItemStack::getCount).sum();
        if (AutoTotem.mc.player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING) {
            ++this.totemCount;
        }
        else if (AutoTotem.mc.player.inventory.getItemStack().isEmpty()) {
            if (this.totemCount == 0) {
                return;
            }
            int lllllllllllIllllIIIlIIlIlllIIIII = -1;
            for (int lllllllllllIllllIIIlIIlIllIlllll = 0; lllllllllllIllllIIIlIIlIllIlllll < 45; ++lllllllllllIllllIIIlIIlIllIlllll) {
                if (AutoTotem.mc.player.inventory.getStackInSlot(lllllllllllIllllIIIlIIlIllIlllll).getItem() == Items.TOTEM_OF_UNDYING) {
                    if (!AutoTotem.mc.player.inventory.getStackInSlot(lllllllllllIllllIIIlIIlIllIlllll).isItemEnchanted() || this.fountTotemCountNoDonat() <= 0 || !AutoTotem.saveEnchTotems.getBoolValue()) {
                        lllllllllllIllllIIIlIIlIlllIIIII = lllllllllllIllllIIIlIIlIllIlllll;
                        break;
                    }
                    lllllllllllIllllIIIlIIlIlllIIIII = -1;
                }
            }
            if (lllllllllllIllllIIIlIIlIlllIIIII == -1) {
                return;
            }
            if (AutoTotem.mc.player.getHealth() <= AutoTotem.health.getNumberValue() || this.checkTNT() || this.checkCrystal() || this.checkFall(AutoTotem.fallDistance.getNumberValue())) {
                AutoTotem.mc.playerController.windowClick(0, (lllllllllllIllllIIIlIIlIlllIIIII < 9) ? (lllllllllllIllllIIIlIIlIlllIIIII + 36) : lllllllllllIllllIIIlIIlIlllIIIII, 1, ClickType.PICKUP, AutoTotem.mc.player);
                AutoTotem.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoTotem.mc.player);
                this.returnOld = true;
                NotificationPublisher.queue("AutoTotem", ChatFormatting.GREEN + "Successfully " + ChatFormatting.WHITE + " equipped totem!", NotificationType.SUCCESS);
            }
        }
    }
}
