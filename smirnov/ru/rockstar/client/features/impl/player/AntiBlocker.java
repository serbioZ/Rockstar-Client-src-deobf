// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import ru.rockstar.api.event.event.EventMouse;
import ru.rockstar.client.features.Feature;

public class AntiBlocker extends Feature
{
    @EventTarget
    public void onMouse(final EventMouse lllllllllllllIIIIlllllIIIIIIIlII) {
        if (lllllllllllllIIIIlllllIIIIIIIlII.key == 1) {
            AntiBlocker.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
        }
    }
    
    public AntiBlocker() {
        super("AntiBlocker", "\u041f\u043e\u0437\u0432\u043b\u044f\u0435\u0442 \u043a\u0438\u0434\u0430\u0442\u044c \u043f\u0435\u0440\u043b\u044b \u0438 \u0442.\u0434. \u0432 \u0432\u0435\u0440\u0441\u0442\u0430\u043a\u0438, \u0441\u0443\u043d\u0434\u0443\u043a\u0438, \u043f\u0435\u0447\u043a\u0438, \u043d\u043e \u043f\u0440\u0438 \u044d\u0442\u043e\u043c \u043e\u0442\u043a\u0440\u044b\u0432\u0430\u0442\u044c \u0438\u0445", 0, Category.PLAYER);
    }
}
