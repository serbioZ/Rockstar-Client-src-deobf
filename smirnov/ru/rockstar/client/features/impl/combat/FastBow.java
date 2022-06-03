// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.network.Packet;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.item.ItemBow;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class FastBow extends Feature
{
    private final /* synthetic */ NumberSetting ticks;
    
    public FastBow() {
        super("FastBow", "\u041f\u0440\u0438 \u0437\u0430\u0436\u0430\u0442\u0438\u0438 \u043d\u0430 \u041f\u041a\u041c \u0438\u0433\u0440\u043e\u043a \u0431\u044b\u0441\u0442\u0440\u043e \u0441\u0442\u0440\u0435\u043b\u044f\u0435\u0442 \u0438\u0437 \u043b\u0443\u043a\u0430", 0, Category.COMBAT);
        this.ticks = new NumberSetting("Bow Ticks", 1.5f, 1.5f, 10.0f, 0.5f, () -> true);
        this.addSettings(this.ticks);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllllIlIlIllIllIlllIII) {
        if (FastBow.mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow && FastBow.mc.player.isBowing() && FastBow.mc.player.getItemInUseMaxCount() >= this.ticks.getNumberValue()) {
            FastBow.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, FastBow.mc.player.getHorizontalFacing()));
            FastBow.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            FastBow.mc.player.stopActiveHand();
        }
    }
}
