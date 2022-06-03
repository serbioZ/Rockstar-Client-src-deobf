// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class LongJump extends Feature
{
    public /* synthetic */ NumberSetting motionBoost;
    public /* synthetic */ NumberSetting boostMultiplier;
    public /* synthetic */ ListSetting mode;
    public /* synthetic */ BooleanSetting motionYBoost;
    
    public LongJump() {
        super("LongJump", "\u0414\u043b\u0438\u043d\u043d\u044b\u0439 \u043f\u0440\u044b\u0436\u043e\u043a", 0, Category.MOVEMENT);
        this.motionYBoost = new BooleanSetting("MotionY boost", false, () -> true);
        this.mode = new ListSetting("LongJump Mode", "Matrix Pearle", () -> true, new String[] { "Redesky", "Matrix Pearle" });
        this.boostMultiplier = new NumberSetting("Boost Speed", 0.3f, 0.1f, 1.0f, 0.1f, () -> this.mode.currentMode.equals("Matrix Pearle"));
        this.motionBoost = new NumberSetting("Motion Boost", 0.6f, 0.1f, 8.0f, 0.1f, () -> this.mode.currentMode.equals("Matrix Pearle") && this.motionYBoost.getBoolValue());
        this.addSettings(this.mode);
    }
    
    @EventTarget
    public void onPreUpdate(final EventPreMotionUpdate llllllllllllIlIllIIIIIIIllIllIII) {
        final String llllllllllllIlIllIIIIIIIllIlIlll = this.mode.getOptions();
        this.setSuffix(llllllllllllIlIllIIIIIIIllIlIlll, true);
        if (llllllllllllIlIllIIIIIIIllIlIlll.equalsIgnoreCase("Redesky")) {
            if (LongJump.mc.player.hurtTime > 0) {
                LongJump.mc.timer.timerSpeed = 1.0f;
                if (LongJump.mc.player.fallDistance != 0.0f) {
                    final EntityPlayerSP player = LongJump.mc.player;
                    player.motionY += 0.039;
                }
                if (LongJump.mc.player.onGround) {
                    LongJump.mc.player.jump();
                    LongJump.mc.player.jumpMovementFactor = 0.01f;
                }
                else {
                    LongJump.mc.timer.timerSpeed = 0.2f;
                    final EntityPlayerSP player2 = LongJump.mc.player;
                    player2.motionY += 0.075;
                    final EntityPlayerSP player3 = LongJump.mc.player;
                    player3.motionX *= 1.065000057220459;
                    final EntityPlayerSP player4 = LongJump.mc.player;
                    player4.motionZ *= 1.065000057220459;
                }
            }
        }
        else if (llllllllllllIlIllIIIIIIIllIlIlll.equalsIgnoreCase("Matrix Pearle") && LongJump.mc.player.hurtTime > 0) {
            final EntityPlayerSP player5 = LongJump.mc.player;
            player5.motionY += 0.13;
            if (LongJump.mc.gameSettings.keyBindForward.pressed && !LongJump.mc.player.onGround) {
                final EntityPlayerSP player6 = LongJump.mc.player;
                player6.motionX -= MathHelper.sin((float)Math.toRadians(LongJump.mc.player.rotationYaw));
                final EntityPlayerSP player7 = LongJump.mc.player;
                player7.motionZ += MathHelper.cos((float)Math.toRadians(LongJump.mc.player.rotationYaw));
                llllllllllllIlIllIIIIIIIllIllIII.setGround(true);
            }
        }
    }
    
    @Override
    public void onDisable() {
        LongJump.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }
}
