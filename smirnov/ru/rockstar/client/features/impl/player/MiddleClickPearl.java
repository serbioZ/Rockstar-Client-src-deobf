// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.init.Items;
import ru.rockstar.api.event.event.EventMouseKey;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import ru.rockstar.client.features.Feature;

public class MiddleClickPearl extends Feature
{
    @Override
    public void onDisable() {
        MiddleClickPearl.mc.player.connection.sendPacket(new CPacketHeldItemChange(MiddleClickPearl.mc.player.inventory.currentItem));
        super.onDisable();
    }
    
    @EventTarget
    public void onMouseEvent(final EventMouseKey llllllllllllIlllllIIIlIIIllllIll) {
        if (llllllllllllIlllllIIIlIIIllllIll.getKey() == 2) {
            for (int llllllllllllIlllllIIIlIIIllllIlI = 0; llllllllllllIlllllIIIlIIIllllIlI < 9; ++llllllllllllIlllllIIIlIIIllllIlI) {
                final ItemStack llllllllllllIlllllIIIlIIIllllIIl = MiddleClickPearl.mc.player.inventory.getStackInSlot(llllllllllllIlllllIIIlIIIllllIlI);
                if (llllllllllllIlllllIIIlIIIllllIIl.getItem() == Items.ENDER_PEARL) {
                    MiddleClickPearl.mc.player.connection.sendPacket(new CPacketHeldItemChange(llllllllllllIlllllIIIlIIIllllIlI));
                    MiddleClickPearl.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    MiddleClickPearl.mc.player.connection.sendPacket(new CPacketHeldItemChange(MiddleClickPearl.mc.player.inventory.currentItem));
                }
            }
        }
    }
    
    public MiddleClickPearl() {
        super("MiddleClickPearl", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u043a\u0438\u0434\u0430\u0435\u0442 \u044d\u043d\u0434\u0435\u0440-\u043f\u0435\u0440\u043b \u043f\u0440\u0438 \u043d\u0430\u0436\u0430\u0442\u0438\u0438 \u043d\u0430 \u043a\u043e\u043b\u0435\u0441\u043e \u043c\u044b\u0448\u0438", 0, Category.PLAYER);
    }
}
