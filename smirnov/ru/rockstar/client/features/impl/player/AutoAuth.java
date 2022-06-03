// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import ru.rockstar.Main;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.api.event.event.EventReceiveMessage;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;

public class AutoAuth extends Feature
{
    public static /* synthetic */ String password;
    
    public AutoAuth() {
        super("AutoAuth", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0440\u0435\u0433\u0435\u0441\u0442\u0440\u0438\u0440\u0443\u0435\u0442\u0441\u044f \u0438 \u043b\u043e\u0433\u0438\u043d\u0438\u0442\u0441\u044f \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0430\u0445", 0, Category.MISC);
    }
    
    static {
        AutoAuth.password = "qwerty123";
    }
    
    @EventTarget
    public void onReceiveMessage(final EventReceiveMessage lllllllllllllllIIlIIIIIlIllIlIll) {
        if (lllllllllllllllIIlIIIIIlIllIlIll.getMessage().contains("/reg") || lllllllllllllllIIlIIIIIlIllIlIll.getMessage().contains("/register") || lllllllllllllllIIlIIIIIlIllIlIll.getMessage().contains("\u0417\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0443\u0439\u0442\u0435\u0441\u044c")) {
            AutoAuth.mc.player.sendChatMessage("/reg " + AutoAuth.password + " " + AutoAuth.password);
            Main.msg("Your password: " + ChatFormatting.RED + AutoAuth.password, true);
            NotificationPublisher.queue("AutoAuth", "You are successfully registered!", NotificationType.SUCCESS);
        }
        else if (lllllllllllllllIIlIIIIIlIllIlIll.getMessage().contains("\u0410\u0432\u0442\u043e\u0440\u0438\u0437\u0443\u0439\u0442\u0435\u0441\u044c") || lllllllllllllllIIlIIIIIlIllIlIll.getMessage().contains("/l")) {
            AutoAuth.mc.player.sendChatMessage("/login " + AutoAuth.password);
            NotificationPublisher.queue("AutoAuth", "You are successfully login!", NotificationType.SUCCESS);
        }
    }
}
