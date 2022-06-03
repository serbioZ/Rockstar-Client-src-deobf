// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.friend.FriendManager;
import ru.rockstar.Main;
import net.minecraft.network.play.client.CPacketUseEntity;
import ru.rockstar.api.event.event.EventSendPacket;
import ru.rockstar.client.features.Feature;

public class NoFriendDamage extends Feature
{
    @EventTarget
    public void onSendPacket(final EventSendPacket lllllllllllllIIllIIllIIlllIIIIll) {
        if (lllllllllllllIIllIIllIIlllIIIIll.getPacket() instanceof CPacketUseEntity) {
            final CPacketUseEntity lllllllllllllIIllIIllIIlllIIIIlI = (CPacketUseEntity)lllllllllllllIIllIIllIIlllIIIIll.getPacket();
            if (lllllllllllllIIllIIllIIlllIIIIlI.getAction().equals(CPacketUseEntity.Action.ATTACK)) {
                final FriendManager friendManager = Main.instance.friendManager;
                if (FriendManager.isFriend(NoFriendDamage.mc.objectMouseOver.entityHit.getName())) {
                    lllllllllllllIIllIIllIIlllIIIIll.setCancelled(true);
                }
            }
        }
    }
    
    public NoFriendDamage() {
        super("NoFriendDamage", "\u041d\u0435 \u0434\u0430\u0451\u0442 \u0443\u0434\u0430\u0440\u0438\u0442\u044c \u0434\u0440\u0443\u0433\u0430", 0, Category.COMBAT);
    }
}
