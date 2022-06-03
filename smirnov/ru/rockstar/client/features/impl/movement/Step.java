// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.impl.player.NoClip;
import ru.rockstar.Main;
import ru.rockstar.api.event.event.EventStep;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class Step extends Feature
{
    public /* synthetic */ boolean jump;
    public static /* synthetic */ ListSetting stepMode;
    public /* synthetic */ BooleanSetting reverseStep;
    /* synthetic */ boolean resetTimer;
    public static /* synthetic */ NumberSetting delay;
    public static /* synthetic */ TimerHelper time;
    public static /* synthetic */ NumberSetting heightStep;
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIIlIlllIIIlIIllIIllll) {
        final String lllllllllllIIlIlllIIIlIIllIIlllI = Step.stepMode.getOptions();
        this.setSuffix(lllllllllllIIlIlllIIIlIIllIIlllI, true);
        if (Step.mc.player.motionY > 0.0) {
            this.jump = true;
        }
        else if (Step.mc.player.onGround) {
            this.jump = false;
        }
        if (this.reverseStep.getBoolValue() && !Step.mc.gameSettings.keyBindJump.isKeyDown() && !Step.mc.player.onGround && Step.mc.player.motionY < 0.0 && Step.mc.player.fallDistance < 1.0f && !this.jump) {
            Step.mc.player.motionY = -1.0;
        }
    }
    
    static {
        Step.time = new TimerHelper();
    }
    
    @EventTarget
    public void onStep(final EventStep lllllllllllIIlIlllIIIlIIlllllIll) {
        final String lllllllllllIIlIlllIIIlIlIIIIIIIl = Step.stepMode.getOptions();
        final float lllllllllllIIlIlllIIIlIlIIIIIIII = Step.delay.getNumberValue() * 1000.0f;
        final float lllllllllllIIlIlllIIIlIIllllllll = Step.heightStep.getNumberValue();
        if (Main.featureDirector.getFeatureByClass(NoClip.class).isToggled()) {
            return;
        }
        final double lllllllllllIIlIlllIIIlIIlllllllI = Step.mc.player.getEntityBoundingBox().minY - Step.mc.player.posY;
        final boolean lllllllllllIIlIlllIIIlIIllllllIl = lllllllllllIIlIlllIIIlIIlllllllI >= 0.625;
        if (lllllllllllIIlIlllIIIlIIllllllIl) {
            Step.time.reset();
        }
        if (this.resetTimer) {
            this.resetTimer = false;
            Step.mc.timer.timerSpeed = 1.0f;
        }
        if (lllllllllllIIlIlllIIIlIlIIIIIIIl.equalsIgnoreCase("Motion")) {
            if (Step.mc.player.isCollidedVertically && !Step.mc.gameSettings.keyBindJump.isPressed() && Step.time.hasReached(lllllllllllIIlIlllIIIlIlIIIIIIII)) {
                lllllllllllIIlIlllIIIlIIlllllIll.setStepHeight(lllllllllllIIlIlllIIIlIIllllllll);
            }
            if (lllllllllllIIlIlllIIIlIIllllllIl) {
                Step.mc.timer.timerSpeed = ((lllllllllllIIlIlllIIIlIIlllllllI > 1.0) ? 0.12f : 0.4f);
                this.resetTimer = true;
                this.ncpStep(lllllllllllIIlIlllIIIlIIlllllllI);
            }
        }
        else if (lllllllllllIIlIlllIIIlIlIIIIIIIl.equalsIgnoreCase("Vanilla")) {
            Step.mc.player.stepHeight = Step.heightStep.getNumberValue();
        }
    }
    
    @Override
    public void onDisable() {
        Step.mc.player.stepHeight = 0.625f;
        Step.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }
    
    public Step() {
        super("Step", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0432\u0437\u0431\u0438\u0440\u0430\u0435\u0442\u0441\u044f \u043d\u0430 \u0431\u043b\u043e\u043a\u0438", 0, Category.MOVEMENT);
        Step.stepMode = new ListSetting("Step Mode", "Motion", () -> true, new String[] { "Motion", "Vanilla" });
        Step.delay = new NumberSetting("Step Delay", 0.0f, 0.0f, 1.0f, 0.1f, () -> true);
        Step.heightStep = new NumberSetting("Height", 1.0f, 1.0f, 10.0f, 0.5f, () -> true);
        this.reverseStep = new BooleanSetting("Reverse Step", false, () -> true);
        this.addSettings(Step.stepMode, Step.heightStep, Step.delay, this.reverseStep);
    }
    
    private void ncpStep(final double lllllllllllIIlIlllIIIlIIllIlllIl) {
        final double[] lllllllllllIIlIlllIIIlIIlllIlIII = { 0.42, 0.333, 0.248, 0.083, -0.078 };
        final double lllllllllllIIlIlllIIIlIIlllIIlll = Step.mc.player.posX;
        final double lllllllllllIIlIlllIIIlIIlllIIllI = Step.mc.player.posZ;
        double lllllllllllIIlIlllIIIlIIlllIIlIl = Step.mc.player.posY;
        if (lllllllllllIIlIlllIIIlIIllIlllIl < 1.1) {
            final double lllllllllllIIlIlllIIIlIIlllIIlII = 0.42;
            final double lllllllllllIIlIlllIIIlIIlllIIIll = 0.75;
            Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(lllllllllllIIlIlllIIIlIIlllIIlll, lllllllllllIIlIlllIIIlIIlllIIlIl + lllllllllllIIlIlllIIIlIIlllIIlII, lllllllllllIIlIlllIIIlIIlllIIllI, false));
            if (lllllllllllIIlIlllIIIlIIlllIIlIl + lllllllllllIIlIlllIIIlIIlllIIIll < lllllllllllIIlIlllIIIlIIlllIIlIl + lllllllllllIIlIlllIIIlIIllIlllIl) {
                Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(lllllllllllIIlIlllIIIlIIlllIIlll, lllllllllllIIlIlllIIIlIIlllIIlIl + lllllllllllIIlIlllIIIlIIlllIIIll, lllllllllllIIlIlllIIIlIIlllIIllI, true));
            }
        }
        else if (lllllllllllIIlIlllIIIlIIllIlllIl < 1.6) {
            short lllllllllllIIlIlllIIIlIIllIlIlII;
            for (byte lllllllllllIIlIlllIIIlIIllIlIlIl = (byte)((double[])(Object)(lllllllllllIIlIlllIIIlIIllIlIlII = (short)(Object)lllllllllllIIlIlllIIIlIIlllIlIII)).length, b = 0; b < lllllllllllIIlIlllIIIlIIllIlIlIl; ++b) {
                final double lllllllllllIIlIlllIIIlIIlllIIIlI = lllllllllllIIlIlllIIIlIIllIlIlII[b];
                lllllllllllIIlIlllIIIlIIlllIIlIl += lllllllllllIIlIlllIIIlIIlllIIIlI;
                Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(lllllllllllIIlIlllIIIlIIlllIIlll, lllllllllllIIlIlllIIIlIIlllIIlIl, lllllllllllIIlIlllIIIlIIlllIIllI, true));
            }
        }
        else if (lllllllllllIIlIlllIIIlIIllIlllIl < 2.1) {
            final double[] lllllllllllIIlIlllIIIlIIlllIIIIl = { 0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869 };
            final int lllllllllllIIlIlllIIIlIIllIlIIll;
            final short lllllllllllIIlIlllIIIlIIllIlIlII = (short)((double[])(Object)(lllllllllllIIlIlllIIIlIIllIlIIll = (int)(Object)lllllllllllIIlIlllIIIlIIlllIIIIl)).length;
            for (byte lllllllllllIIlIlllIIIlIIllIlIlIl = 0; lllllllllllIIlIlllIIIlIIllIlIlIl < lllllllllllIIlIlllIIIlIIllIlIlII; ++lllllllllllIIlIlllIIIlIIllIlIlIl) {
                final double lllllllllllIIlIlllIIIlIIlllIIIII = lllllllllllIIlIlllIIIlIIllIlIIll[lllllllllllIIlIlllIIIlIIllIlIlIl];
                Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(lllllllllllIIlIlllIIIlIIlllIIlll, lllllllllllIIlIlllIIIlIIlllIIlIl + lllllllllllIIlIlllIIIlIIlllIIIII, lllllllllllIIlIlllIIIlIIlllIIllI, true));
            }
        }
        else {
            final double[] lllllllllllIIlIlllIIIlIIllIlllll = { 0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869, 2.019, 1.907 };
            final int lllllllllllIIlIlllIIIlIIllIlIIll;
            final short lllllllllllIIlIlllIIIlIIllIlIlII = (short)((double[])(Object)(lllllllllllIIlIlllIIIlIIllIlIIll = (int)(Object)lllllllllllIIlIlllIIIlIIllIlllll)).length;
            for (byte lllllllllllIIlIlllIIIlIIllIlIlIl = 0; lllllllllllIIlIlllIIIlIIllIlIlIl < lllllllllllIIlIlllIIIlIIllIlIlII; ++lllllllllllIIlIlllIIIlIIllIlIlIl) {
                final double lllllllllllIIlIlllIIIlIIllIllllI = lllllllllllIIlIlllIIIlIIllIlIIll[lllllllllllIIlIlllIIIlIIllIlIlIl];
                Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(lllllllllllIIlIlllIIIlIIlllIIlll, lllllllllllIIlIlllIIIlIIlllIIlIl + lllllllllllIIlIlllIIIlIIllIllllI, lllllllllllIIlIlllIIIlIIlllIIllI, true));
            }
        }
    }
}
