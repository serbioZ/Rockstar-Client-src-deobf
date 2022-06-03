// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.inventory.ClickType;
import ru.rockstar.client.features.impl.movement.Jesus;
import ru.rockstar.api.utils.world.InventoryHelper;
import net.minecraft.init.Items;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.item.ItemShield;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.network.Packet;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import ru.rockstar.Main;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class ShieldDesync extends Feature
{
    public static /* synthetic */ ListSetting desyncMode;
    
    @EventTarget
    public void onEventPreMotion(final EventPreMotionUpdate llllllllllIllllllIlllllIIlllIllI) {
        if (KillAura.target != null) {
            final String llllllllllIllllllIlllllIIlllIlIl = ShieldDesync.desyncMode.getOptions();
            if (llllllllllIllllllIlllllIIlllIlIl.equalsIgnoreCase("Default") && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && ShieldDesync.mc.player.isBlocking() && KillAura.target != null && ShieldDesync.mc.player.ticksExisted % 2 == 0) {
                ShieldDesync.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(900, 900, 900), EnumFacing.NORTH));
                ShieldDesync.mc.playerController.processRightClick(ShieldDesync.mc.player, ShieldDesync.mc.world, EnumHand.OFF_HAND);
            }
            if (llllllllllIllllllIlllllIIlllIlIl.equalsIgnoreCase("FastClick") && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && ShieldDesync.mc.player.getHeldItemOffhand().getItem() instanceof ItemShield) {
                if (ShieldDesync.mc.player.ticksExisted % 0.01f == 0.0f) {
                    ShieldDesync.mc.gameSettings.keyBindUseItem.pressed = false;
                }
                else {
                    ShieldDesync.mc.gameSettings.keyBindUseItem.pressed = true;
                }
            }
            if (llllllllllIllllllIlllllIIlllIlIl.equalsIgnoreCase("Packet") && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && ShieldDesync.mc.player.getHeldItemOffhand().getItem() instanceof ItemShield) {
                ShieldDesync.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            }
            if (llllllllllIllllllIlllllIIlllIlIl.equalsIgnoreCase("New") && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && ShieldDesync.mc.player.getHeldItemOffhand().getItem() instanceof ItemShield && ShieldDesync.mc.player.getHeldItemOffhand().getItem() != Items.TOTEM_OF_UNDYING && InventoryHelper.getTotemAtHotbar() != -1) {
                if (Jesus.mc.player.ticksExisted % 1.0f == 0.0f) {
                    ShieldDesync.mc.playerController.windowClick(0, InventoryHelper.getShieldAtHotbar(), 1, ClickType.QUICK_MOVE, ShieldDesync.mc.player);
                    ShieldDesync.mc.gameSettings.keyBindUseItem.pressed = true;
                }
                else {
                    ShieldDesync.mc.playerController.windowClick(0, InventoryHelper.getShieldAtHotbar(), 1, ClickType.QUICK_MOVE, ShieldDesync.mc.player);
                    ShieldDesync.mc.gameSettings.keyBindUseItem.pressed = true;
                }
            }
        }
    }
    
    public ShieldDesync() {
        super("ShieldDesync", "\u0414\u0435\u0441\u0438\u043d\u043a\u0430\u0435\u0442 \u0449\u0438\u0442\u044b \u0447\u0438\u0442\u043e\u0432", 0, Category.COMBAT);
        ShieldDesync.desyncMode = new ListSetting("Sorting Mode", "Default", () -> true, new String[] { "New", "FastClick", "Default", "Packet" });
        this.addSettings(ShieldDesync.desyncMode);
    }
}
