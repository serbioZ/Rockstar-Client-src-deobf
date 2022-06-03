// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.play.client.CPacketCloseWindow;
import ru.rockstar.api.event.event.EventSendPacket;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;

public class XCarry extends Feature
{
    public XCarry() {
        super("XCarry", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0445\u0440\u0430\u043d\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u044b \u0432 \u0441\u043b\u043e\u0442\u0430\u0445 \u0434\u043b\u044f \u043a\u0440\u0430\u0444\u0442\u0430", 0, Category.PLAYER);
    }
    
    @EventTarget
    public void onSendPacket(final EventSendPacket llllllllllllIIIlIlIIIllllllIIllI) {
        if (llllllllllllIIIlIlIIIllllllIIllI.getPacket() instanceof CPacketCloseWindow) {
            llllllllllllIIIlIlIIIllllllIIllI.setCancelled(true);
        }
    }
}
