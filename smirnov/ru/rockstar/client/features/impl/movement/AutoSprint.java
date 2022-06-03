// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.client.features.impl.combat.KillAura;
import ru.rockstar.client.features.impl.player.Scaffold;
import ru.rockstar.Main;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;

public class AutoSprint extends Feature
{
    public AutoSprint() {
        super("AutoSprint", "\u0417\u0430\u0436\u0438\u043c\u0430\u0435\u0442 CTRL \u0437\u0430 \u0432\u0430\u0441, \u0447\u0442\u043e \u0431\u044b \u0431\u044b\u0441\u0442\u0440\u043e \u0431\u0435\u0436\u0430\u0442\u044c", 0, Category.MOVEMENT);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIlllIIlIlIIIIIlllllll) {
        if ((!Main.featureDirector.getFeatureByClass(Scaffold.class).isToggled() || !Scaffold.sprintoff.getBoolValue()) && (!Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() || !KillAura.stopSprint.getBoolValue() || KillAura.target == null)) {
            AutoSprint.mc.player.setSprinting(MovementHelper.isMoving());
        }
    }
}
