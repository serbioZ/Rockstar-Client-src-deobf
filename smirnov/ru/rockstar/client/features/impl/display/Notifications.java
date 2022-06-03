// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class Notifications extends Feature
{
    public static /* synthetic */ ListSetting notifMode;
    public static /* synthetic */ BooleanSetting state;
    
    public Notifications() {
        super("Notifications", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u0443\u044e \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044e \u043e \u043c\u043e\u0434\u0443\u043b\u044f\u0445", 0, Category.DISPLAY);
        Notifications.state = new BooleanSetting("Module State", true, () -> true);
        Notifications.notifMode = new ListSetting("Notification Mode", "Rect", () -> true, new String[] { "Rect", "Chat" });
        this.addSettings(Notifications.notifMode, Notifications.state);
    }
}
