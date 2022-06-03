// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.entity.EntityPlayerSP;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class Strafe extends Feature
{
    private final /* synthetic */ BooleanSetting damageStrafe;
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIIllIIlIlIllIIIlIIIII) {
        Strafe.mc.player.speedInAir = 0.02f;
        if (this.damageStrafe.getBoolValue()) {
            if (Strafe.mc.player.hurtTime > 0) {
                Strafe.mc.player.speedInAir = 0.03f;
            }
            else {
                Strafe.mc.player.speedInAir = 0.02f;
            }
        }
        else if (!Strafe.mc.player.isInWater()) {
            if (Strafe.mc.player.onGround && !Strafe.mc.gameSettings.keyBindForward.pressed && Strafe.mc.player.ticksExisted % 1 == 0 && Strafe.mc.player.speedInAir < 0.03) {
                final EntityPlayerSP player = Strafe.mc.player;
                player.speedInAir *= 2.32412f;
            }
            if (!Strafe.mc.gameSettings.keyBindForward.pressed) {
                return;
            }
            if (!Strafe.mc.player.onGround) {
                Strafe.mc.player.speedInAir = 0.02f;
                MovementHelper.strafe(0.2f);
            }
        }
    }
    
    public Strafe() {
        super("Strafe", "\u0421\u0442\u0440\u0435\u0439\u0444\u0438\u0442\u044c\u0441\u044f", 0, Category.MOVEMENT);
        this.damageStrafe = new BooleanSetting("DamageStrafe", false, () -> true);
        this.addSettings(this.damageStrafe);
    }
}
