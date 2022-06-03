// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.movement.MovementHelper;
import net.minecraft.init.MobEffects;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class WaterSpeed extends Feature
{
    public static /* synthetic */ NumberSetting speed;
    private final /* synthetic */ BooleanSetting speedCheck;
    
    public WaterSpeed() {
        super("WaterSpeed", "\u0414\u0435\u043b\u0430\u0435\u0442 \u0432\u0430\u0441 \u0431\u044b\u0441\u0442\u0440\u0435\u0435 \u0432 \u0432\u043e\u0434\u0435", 0, Category.PLAYER);
        WaterSpeed.speed = new NumberSetting("Speed Amount", 1.0f, 0.1f, 4.0f, 0.01f, () -> true);
        this.speedCheck = new BooleanSetting("Speed Potion Check", false, () -> true);
        this.addSettings(this.speedCheck, WaterSpeed.speed);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIllllIlIlIIlIIIIlllI) {
        if (!WaterSpeed.mc.player.isPotionActive(MobEffects.SPEED) && this.speedCheck.getBoolValue()) {
            return;
        }
        if (WaterSpeed.mc.player.isInLiquid()) {
            MovementHelper.setSpeed(WaterSpeed.speed.getNumberValue());
        }
    }
}
