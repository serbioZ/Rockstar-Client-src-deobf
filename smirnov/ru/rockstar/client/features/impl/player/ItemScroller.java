// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class ItemScroller extends Feature
{
    public static /* synthetic */ NumberSetting scrollerDelay;
    
    public ItemScroller() {
        super("ItemScroller", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u044b\u0441\u0442\u0440\u043e \u043b\u0443\u0442\u0430\u0442\u044c \u0441\u0443\u043d\u0434\u0443\u043a\u0438 \u043f\u0440\u0438 \u043d\u0430\u0436\u0430\u0442\u0438\u0438 \u043d\u0430 \u0448\u0438\u0444\u0442 \u0438 \u041b\u041a\u041c", 0, Category.MISC);
        ItemScroller.scrollerDelay = new NumberSetting("Scroller Delay", 0.0f, 0.0f, 1000.0f, 50.0f, () -> true);
        this.addSettings(ItemScroller.scrollerDelay);
    }
}
