// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.Main;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import net.minecraft.client.gui.GuiGameOver;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.features.Feature;

public class DeathCoordinates extends Feature
{
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIIlIlIlIlllllllIIllll) {
        if (DeathCoordinates.mc.player.getHealth() < 1.0f && DeathCoordinates.mc.currentScreen instanceof GuiGameOver) {
            final int lllllllllllIIlIlIlIlllllllIIlllI = DeathCoordinates.mc.player.getPosition().getX();
            final int lllllllllllIIlIlIlIlllllllIIllIl = DeathCoordinates.mc.player.getPosition().getY();
            final int lllllllllllIIlIlIlIlllllllIIllII = DeathCoordinates.mc.player.getPosition().getZ();
            if (DeathCoordinates.mc.player.ticksExisted % 20 == 0) {
                NotificationPublisher.queue("Death Coordinates", "X: " + lllllllllllIIlIlIlIlllllllIIlllI + " Y: " + lllllllllllIIlIlIlIlllllllIIllIl + " Z: " + lllllllllllIIlIlIlIlllllllIIllII, NotificationType.INFO);
                Main.msg("Death Coordinates: X: " + lllllllllllIIlIlIlIlllllllIIlllI + " Y: " + lllllllllllIIlIlIlIlllllllIIllIl + " Z: " + lllllllllllIIlIlIlIlllllllIIllII, true);
            }
        }
    }
    
    public DeathCoordinates() {
        super("DeathCoordinates", "\u041f\u043e\u0441\u043b\u0435 \u0441\u043c\u0435\u0440\u0442\u0438 \u043f\u0438\u0448\u0438\u0442 \u0432\u0430\u0448\u0438 \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b \u0432 \u0447\u0430\u0442", 0, Category.PLAYER);
    }
}
