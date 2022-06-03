// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.client.features.impl.misc.TimerIndicator;
import net.minecraft.util.text.TextFormatting;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class Timer extends Feature
{
    public /* synthetic */ NumberSetting timer;
    public static /* synthetic */ BooleanSetting autoDisable;
    public static /* synthetic */ int tick;
    public static /* synthetic */ int ticks;
    private final /* synthetic */ NumberSetting Ticks;
    
    @Override
    public void onDisable() {
        super.onDisable();
        Timer.mc.timer.timerSpeed = 1.0f;
    }
    
    public Timer() {
        super("Timer", "\u0423\u0432\u0435\u043b\u0438\u0447\u0438\u0432\u0430\u0435\u0442 \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0438\u0433\u0440\u044b", 0, Category.PLAYER);
        this.timer = new NumberSetting("Timer", 2.0f, 0.1f, 10.0f, 0.1f, () -> true);
        this.Ticks = new NumberSetting("Ticks", 55.0f, 1.0f, 100.0f, 1.0f, () -> Timer.autoDisable.getBoolValue());
        Timer.autoDisable = new BooleanSetting("AutoDisable", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0432\u044b\u043a\u043b\u044e\u0447\u0430\u0435\u0442 \u0442\u0430\u0439\u043c\u0435\u0440", false, () -> true);
        this.addSettings(this.timer, Timer.autoDisable, this.Ticks);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIIIIIIIIllllIllIIIlI) {
        Timer.ticks = (int)this.Ticks.getNumberValue();
        if (this.isToggled()) {
            if (MovementHelper.isMoving() || Timer.mc.player.motionY > 0.0) {
                Timer.mc.timer.timerSpeed = this.timer.getNumberValue();
                ++Timer.tick;
            }
            this.setModuleName("Timer " + TextFormatting.GRAY + "[" + this.timer.getNumberValue() + "]");
        }
        if (Timer.tick >= this.Ticks.getNumberValue()) {
            Timer.tick = (int)TimerIndicator.indicatorTimer;
            if (Timer.autoDisable.getBoolValue()) {
                this.toggle();
            }
        }
    }
    
    @Override
    public void onEnable() {
        Timer.tick = (int)TimerIndicator.indicatorTimer;
        super.onEnable();
    }
    
    static {
        Timer.tick = 0;
    }
}
