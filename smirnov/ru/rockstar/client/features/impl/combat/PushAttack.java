// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class PushAttack extends Feature
{
    private final /* synthetic */ NumberSetting clickCoolDown;
    
    public PushAttack() {
        super("PushAttack", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u0438\u0442\u044c \u043d\u0430 \u041b\u041a\u041c \u043d\u0435 \u0441\u043c\u043e\u0442\u0440\u044f \u043d\u0430 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432", 0, Category.COMBAT);
        this.clickCoolDown = new NumberSetting("Click CoolDown", 1.0f, 0.5f, 1.0f, 0.1f, () -> true);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIIlIIllllIIIIIIIlllll) {
        if (PushAttack.mc.player.getCooledAttackStrength(0.0f) == this.clickCoolDown.getNumberValue() && PushAttack.mc.gameSettings.keyBindAttack.pressed) {
            PushAttack.mc.clickMouse();
        }
    }
}
