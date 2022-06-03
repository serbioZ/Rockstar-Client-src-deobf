// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import net.minecraft.client.gui.GuiGameOver;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.Main;
import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.api.utils.movement.MovementHelper;
import net.minecraft.entity.Entity;
import ru.rockstar.api.utils.combat.RotationHelper;
import ru.rockstar.client.features.impl.combat.KillAura;
import ru.rockstar.api.event.event.MoveEvent;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class TargetStrafe extends Feature
{
    public /* synthetic */ NumberSetting spd;
    private /* synthetic */ double circleAnim;
    public /* synthetic */ BooleanSetting autoJump;
    public /* synthetic */ NumberSetting tstrafeRange;
    public /* synthetic */ BooleanSetting render;
    public /* synthetic */ NumberSetting points;
    public /* synthetic */ BooleanSetting targetlockCheck;
    public /* synthetic */ BooleanSetting damageBoost;
    public /* synthetic */ NumberSetting damageBoostValue;
    public static /* synthetic */ int direction;
    public /* synthetic */ BooleanSetting autoShift;
    
    public boolean onMotionUpdate(final MoveEvent lllllllllllIIllIIIIIlIlIIIlIIlll) {
        final EntityLivingBase lllllllllllIIllIIIIIlIlIIIlIIllI = KillAura.target;
        final float[] lllllllllllIIllIIIIIlIlIIIlIIlIl = RotationHelper.getNewFaceRotating(lllllllllllIIllIIIIIlIlIIIlIIllI);
        if (TargetStrafe.mc.player.getDistanceToEntity(lllllllllllIIllIIIIIlIlIIIlIIllI) <= (double)this.tstrafeRange.getNumberValue()) {
            if (TargetStrafe.mc.player.hurtTime > 0 && this.damageBoost.getBoolValue()) {
                MovementHelper.setMotion(lllllllllllIIllIIIIIlIlIIIlIIlll, this.spd.getNumberValue() + this.damageBoostValue.getNumberValue(), lllllllllllIIllIIIIIlIlIIIlIIlIl[0], TargetStrafe.direction, 0.0);
            }
            else {
                MovementHelper.setMotion(lllllllllllIIllIIIIIlIlIIIlIIlll, this.spd.getNumberValue(), lllllllllllIIllIIIIIlIlIIIlIIlIl[0], TargetStrafe.direction, 0.0);
            }
        }
        else if (TargetStrafe.mc.player.hurtTime > 0 && this.damageBoost.getBoolValue()) {
            MovementHelper.setMotion(lllllllllllIIllIIIIIlIlIIIlIIlll, this.spd.getNumberValue() + this.damageBoostValue.getNumberValue(), lllllllllllIIllIIIIIlIlIIIlIIlIl[0], TargetStrafe.direction, 1.0);
        }
        else {
            MovementHelper.setMotion(lllllllllllIIllIIIIIlIlIIIlIIlll, this.spd.getNumberValue(), lllllllllllIIllIIIIIlIlIIIlIIlIl[0], TargetStrafe.direction, 1.0);
        }
        return true;
    }
    
    @EventTarget
    public void onMove(final MoveEvent lllllllllllIIllIIIIIlIlIIIIIIlIl) {
        if (Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && KillAura.target != null) {
            if (TargetStrafe.mc.player.isCollidedHorizontally) {
                this.switchDirection();
            }
            if (KillAura.target.getHealth() > 0.0f) {
                this.onMotionUpdate(lllllllllllIIllIIIIIlIlIIIIIIlIl);
            }
        }
    }
    
    static {
        TargetStrafe.direction = -1;
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotionUpdate lllllllllllIIllIIIIIlIlIIIIllllI) {
        if (TargetStrafe.mc.player.isCollidedHorizontally) {
            this.switchDirection();
        }
        if (TargetStrafe.mc.gameSettings.keyBindLeft.isPressed()) {
            TargetStrafe.direction = 1;
        }
        if (TargetStrafe.mc.gameSettings.keyBindRight.isPressed()) {
            TargetStrafe.direction = -1;
        }
        if (KillAura.target != null && KillAura.target.getHealth() > 0.0f && this.autoJump.getBoolValue() && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && Main.featureDirector.getFeatureByClass(TargetStrafe.class).isToggled() && TargetStrafe.mc.player.onGround) {
            TargetStrafe.mc.player.jump();
        }
    }
    
    @EventTarget
    public void onSwitchDir(final EventUpdate lllllllllllIIllIIIIIlIlIIIIlIllI) {
        if (TargetStrafe.mc.currentScreen instanceof GuiGameOver) {
            this.toggle();
            NotificationPublisher.queue(this.getLabel(), "was Toggled Off", NotificationType.INFO);
            return;
        }
        if (TargetStrafe.mc.player.ticksExisted <= 1) {
            this.toggle();
            NotificationPublisher.queue(this.getLabel(), "was Toggled Off", NotificationType.INFO);
            return;
        }
        if (TargetStrafe.mc.player.getDistanceToEntity(KillAura.target) <= KillAura.range.getNumberValue()) {
            if (KillAura.target == null) {
                return;
            }
            if (TargetStrafe.mc.player.isCollidedHorizontally) {
                this.switchDirection();
            }
            if (this.targetlockCheck.getBoolValue() && KillAura.target != null && RotationHelper.isAimAtMe(KillAura.target, 25.0f)) {
                this.switchDirection();
            }
            if (TargetStrafe.mc.gameSettings.keyBindLeft.isKeyDown()) {
                TargetStrafe.direction = 1;
            }
            if (TargetStrafe.mc.gameSettings.keyBindRight.isKeyDown()) {
                TargetStrafe.direction = -1;
            }
        }
    }
    
    private void switchDirection() {
        if (TargetStrafe.direction == 1) {
            TargetStrafe.direction = -1;
        }
        else {
            TargetStrafe.direction = 1;
        }
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIIllIIIIIlIlIIIIllIlI) {
        if (KillAura.target == null) {
            return;
        }
        if (TargetStrafe.mc.player.getDistanceToEntity(KillAura.target) <= KillAura.range.getNumberValue() && this.autoShift.getBoolValue()) {
            TargetStrafe.mc.gameSettings.keyBindSneak.setPressed(this.isToggled() && KillAura.target != null && TargetStrafe.mc.player.fallDistance > KillAura.critFallDistance.getNumberValue() + 0.1);
        }
    }
    
    @EventTarget
    public void onRender3D(final Event3D lllllllllllIIllIIIIIlIlIIIIIllII) {
        if (this.isToggled() && KillAura.target != null && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && Minecraft.getMinecraft().player.getDistanceToEntity(KillAura.target) <= KillAura.range.getNumberValue() && KillAura.target.getHealth() > 0.0f) {
            if (this.render.getBoolValue()) {
                this.circleAnim += 0.014999999664723873 * Minecraft.frameTime / 10.0;
                DrawHelper.drawCircle3D(KillAura.target, this.circleAnim + 0.001, lllllllllllIIllIIIIIlIlIIIIIllII.getPartialTicks(), (int)this.points.getNumberValue(), 4.0f, Color.black.getRGB());
                DrawHelper.drawCircle3D(KillAura.target, this.circleAnim - 0.001, lllllllllllIIllIIIIIlIlIIIIIllII.getPartialTicks(), (int)this.points.getNumberValue(), 4.0f, Color.black.getRGB());
                for (float lllllllllllIIllIIIIIlIlIIIIIlllI = 0.0f; lllllllllllIIllIIIIIlIlIIIIIlllI < 360.5; ++lllllllllllIIllIIIIIlIlIIIIIlllI) {
                    DrawHelper.drawCircle3D(KillAura.target, this.circleAnim, lllllllllllIIllIIIIIlIlIIIIIllII.getPartialTicks(), (int)this.points.getNumberValue(), 2.0f, ClientHelper.getClientColor(lllllllllllIIllIIIIIlIlIIIIIlllI / 16.0f, lllllllllllIIllIIIIIlIlIIIIIlllI, 5).getRGB());
                }
                this.circleAnim = MathHelper.clamp(this.circleAnim, 0.0, 1.0);
            }
            else {
                this.circleAnim = 0.0;
            }
        }
    }
    
    public TargetStrafe() {
        super("TargetStrafe", "\u041a\u0440\u0443\u0442\u0438\u0442\u0441\u044f \u0432\u043e\u043a\u0440\u0443\u0433 \u044d\u043d\u0442\u0438\u0442\u0438", 0, Category.MOVEMENT);
        this.tstrafeRange = new NumberSetting("Strafe Distance", 2.4f, 0.1f, 6.0f, 0.1f, () -> true);
        this.spd = new NumberSetting("Strafe Speed", 0.23f, 0.1f, 2.0f, 0.01f, () -> true);
        this.damageBoost = new BooleanSetting("Hurt Boost", "\u0423\u0441\u043a\u043e\u0440\u044f\u0435\u0442 \u0432\u0430\u0441 \u043f\u043e\u0441\u043b\u0435 \u0442\u043e\u0433\u043e \u043a\u0430\u043a \u0432\u0430\u043c \u043d\u0430\u043d\u0435\u0441\u043b\u0438 \u0443\u0440\u043e\u043d", false, () -> true);
        this.damageBoostValue = new NumberSetting("HurtBoost Value", 0.5f, 0.1f, 4.0f, 0.1f, () -> this.damageBoost.getBoolValue());
        this.targetlockCheck = new BooleanSetting("Look Check", "\u041c\u0435\u043d\u044f\u0435\u0442 \u0434\u0435\u0440\u0435\u043a\u0442\u043e\u0440\u0438\u044e \u043f\u043e\u0441\u043b\u0435 \u0442\u043e\u0433\u043e \u043a\u0430\u043a \u043d\u0430 \u0432\u0430\u0441 \u043f\u043e\u0441\u043c\u043e\u0442\u0440\u0435\u043b\u043e \u044d\u043d\u0442\u0438\u0442\u0438", false, () -> true);
        this.render = new BooleanSetting("Render", false, () -> true);
        this.points = new NumberSetting("Points", "\u041a\u043e\u043b-\u0432\u043e \u043f\u043e\u0438\u043d\u0442\u043e\u0432 \u0432 \u043a\u0440\u0443\u0433\u0435", 3.0f, 1.0f, 30.0f, 1.0f, () -> this.render.getBoolValue());
        this.autoJump = new BooleanSetting("AutoJump", true, () -> true);
        this.autoShift = new BooleanSetting("AutoShift", false, () -> true);
        this.addSettings(this.tstrafeRange, this.spd, this.targetlockCheck, this.damageBoost, this.damageBoostValue, this.render, this.points, this.autoShift, this.autoJump);
    }
}
