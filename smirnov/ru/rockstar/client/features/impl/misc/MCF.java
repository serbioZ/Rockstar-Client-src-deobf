// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.friend.Friend;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import ru.rockstar.Main;
import ru.rockstar.api.event.event.EventMouseKey;
import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.client.features.Feature;

public class MCF extends Feature
{
    @EventTarget
    public void onMouseEvent(final EventMouseKey lllllllllllIlIIlIllIlIIIlllIlllI) {
        if (lllllllllllIlIIlIllIlIIIlllIlllI.getKey() == 2 && MCF.mc.pointedEntity instanceof EntityLivingBase) {
            if (Main.instance.friendManager.getFriends().stream().anyMatch(lllllllllllIlIIlIllIlIIIlllIlIlI -> lllllllllllIlIIlIllIlIIIlllIlIlI.getName().equals(MCF.mc.pointedEntity.getName()))) {
                Main.instance.friendManager.getFriends().remove(Main.instance.friendManager.getFriend(MCF.mc.pointedEntity.getName()));
                NotificationPublisher.queue("MCF", "Removed '" + MCF.mc.pointedEntity.getName() + "'" + " as Friend!", NotificationType.INFO);
            }
            else {
                Main.instance.friendManager.addFriend(new Friend(MCF.mc.pointedEntity.getName()));
                NotificationPublisher.queue("MCF", "Added " + MCF.mc.pointedEntity.getName() + " as Friend!", NotificationType.SUCCESS);
            }
        }
    }
    
    public MCF() {
        super("MiddleClickFriend", "\u0414\u043e\u0431\u0430\u0432\u043b\u044f\u0435\u0442 \u0438\u0433\u0440\u043e\u043a\u0430 \u0432 \u0444\u0440\u0435\u043d\u0434 \u043b\u0438\u0441\u0442 \u043f\u0440\u0438 \u043d\u0430\u0436\u0430\u0442\u0438\u0438 \u043d\u0430 \u043a\u043d\u043e\u043f\u043a\u0443 \u043c\u044b\u0448\u0438", 0, Category.MISC);
    }
}
