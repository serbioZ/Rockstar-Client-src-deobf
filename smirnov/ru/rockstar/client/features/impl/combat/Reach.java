// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.math.MathematicHelper;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class Reach extends Feature
{
    public static /* synthetic */ NumberSetting reachValue;
    
    public Reach() {
        super("Reach", "\u0423\u0432\u0435\u043b\u0438\u0447\u0438\u0432\u0430\u0435\u0442 \u0434\u0438\u0441\u0442\u0430\u043d\u0446\u0438\u044e \u0443\u0434\u0430\u0440\u0430", 0, Category.COMBAT);
        Reach.reachValue = new NumberSetting("Expand", 3.2f, 3.0f, 5.0f, 0.1f, () -> true);
        this.addSettings(Reach.reachValue);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIIllllIIIIllIlIIIll) {
        this.setSuffix(new StringBuilder().append(MathematicHelper.round(Reach.reachValue.getNumberValue(), 1)).toString(), true);
    }
}
