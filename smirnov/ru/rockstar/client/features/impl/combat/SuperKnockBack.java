// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketUseEntity;
import ru.rockstar.api.event.event.EventSendPacket;
import ru.rockstar.client.features.Feature;

public class SuperKnockBack extends Feature
{
    @EventTarget
    public void onSendPacket(final EventSendPacket lllllllllllIlIlIlIIIIIlIllIIIllI) {
        if (lllllllllllIlIlIlIIIIIlIllIIIllI.getPacket() instanceof CPacketUseEntity) {
            final CPacketUseEntity lllllllllllIlIlIlIIIIIlIllIIIlll = (CPacketUseEntity)lllllllllllIlIlIlIIIIIlIllIIIllI.getPacket();
            if (lllllllllllIlIlIlIIIIIlIllIIIlll.getAction() == CPacketUseEntity.Action.ATTACK) {
                SuperKnockBack.mc.player.setSprinting(false);
                SuperKnockBack.mc.player.connection.sendPacket(new CPacketEntityAction(SuperKnockBack.mc.player, CPacketEntityAction.Action.STOP_SPRINTING));
                SuperKnockBack.mc.player.setSprinting(true);
                SuperKnockBack.mc.player.connection.sendPacket(new CPacketEntityAction(SuperKnockBack.mc.player, CPacketEntityAction.Action.START_SPRINTING));
            }
        }
    }
    
    public SuperKnockBack() {
        super("ExtendedKnockBack", "\u0412\u044b \u043e\u0442\u043a\u0438\u0434\u044b\u0432\u0430\u0435\u0442\u0435 \u043f\u0440\u043e\u0442\u0438\u0432\u043d\u0438\u043a\u0430 \u0434\u0430\u043b\u044c\u0448\u0435", 0, Category.COMBAT);
    }
}
