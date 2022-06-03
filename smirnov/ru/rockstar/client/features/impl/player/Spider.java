// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class Spider extends Feature
{
    public static /* synthetic */ NumberSetting climbTicks;
    private final /* synthetic */ TimerHelper timerHelper;
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIllIllIlIIIllIIlllIIl) {
        this.setSuffix(new StringBuilder().append(Spider.climbTicks.getNumberValue()).toString(), true);
        if (MovementHelper.isMoving() && Spider.mc.player.isCollidedHorizontally && this.timerHelper.hasReached(Spider.climbTicks.getNumberValue() * 100.0f)) {
            lllllllllllIllIllIlIIIllIIlllIIl.setGround(true);
            Spider.mc.player.onGround = true;
            Spider.mc.player.isCollidedVertically = true;
            Spider.mc.player.isCollidedHorizontally = true;
            Spider.mc.player.isAirBorne = true;
            Spider.mc.player.jump();
            this.timerHelper.reset();
        }
    }
    
    public Spider() {
        super("Spider", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0432\u0437\u0431\u0435\u0440\u0430\u0435\u0442\u0441\u044f \u043d\u0430 \u0441\u0442\u0435\u043d\u044b", 0, Category.MOVEMENT);
        this.timerHelper = new TimerHelper();
        Spider.climbTicks = new NumberSetting("Climb Ticks", 1.0f, 0.0f, 5.0f, 0.1f, () -> true);
        this.addSettings(Spider.climbTicks);
    }
}
