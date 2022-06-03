// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.Main;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import ru.rockstar.api.event.event.EventReceivePacket;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.block.BlockAir;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class Speed extends Feature
{
    private final /* synthetic */ NumberSetting speed;
    private /* synthetic */ float ticks;
    private final /* synthetic */ ListSetting speedMode;
    private final /* synthetic */ BooleanSetting lagbackCheck;
    
    public Speed() {
        super("Speed", "\u0423\u0441\u043a\u043e\u0440\u0435\u043d\u0438\u0435 \u0431\u0435\u0433\u0430", 0, Category.MOVEMENT);
        this.ticks = 35.0f;
        this.speedMode = new ListSetting("Speed Mode", "Matrix", () -> true, new String[] { "Matrix", "MatrixGround", "Matrix New", "NCP", "NexusGrief", "SunriseDamage", "StormDisabler", "MagicGrief" });
        this.speed = new NumberSetting("Speed", 2.0f, 0.1f, 10.0f, 0.1f, () -> this.speedMode.currentMode.equalsIgnoreCase("StormDisabler"));
        this.lagbackCheck = new BooleanSetting("Lagback Check", "\u0412\u043e\u0437\u0432\u0440\u0430\u0449\u0430\u0435\u0442 \u043d\u0430\u0437\u0430\u0434 \u0435\u0441\u043b\u0438 \u0430\u043d\u0442\u0438\u0447\u0438\u0442 \u0441\u043f\u0430\u043c\u0438\u0442 \u0447\u0435\u043a\u0430\u043c\u0438", false, () -> true);
        this.addSettings(this.speedMode, this.speed, this.lagbackCheck);
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIIllIlIIIlIlIIlIlllII) {
        if (this.isToggled()) {
            final String lllllllllllIIllIlIIIlIlIIlIllIll = this.speedMode.getOptions();
            if (lllllllllllIIllIlIIIlIlIIlIllIll.equalsIgnoreCase("MatrixGround")) {
                lllllllllllIIllIlIIIlIlIIlIlllII.setGround(true);
                if (Speed.mc.player.onGround && Speed.mc.gameSettings.keyBindForward.pressed) {
                    Speed.mc.player.jump();
                }
                if (!Speed.mc.player.isInWater()) {
                    final EntityPlayerSP player = Speed.mc.player;
                    --player.motionY;
                }
            }
            if (lllllllllllIIllIlIIIlIlIIlIllIll.equalsIgnoreCase("Matrix")) {
                Speed.mc.gameSettings.keyBindJump.pressed = false;
                if (Speed.mc.player.isInWeb || Speed.mc.player.isOnLadder() || Speed.mc.player.isInLiquid()) {
                    return;
                }
                final EntityPlayerSP player2;
                final EntityPlayerSP lllllllllllIIllIlIIIlIlIIlIllIlI = player2 = Speed.mc.player;
                player2.jumpMovementFactor *= 1.04f;
                final double lllllllllllIIllIlIIIlIlIIlIllIIl = Speed.mc.player.posX;
                final double lllllllllllIIllIlIIIlIlIIlIllIII = Speed.mc.player.posY;
                final double lllllllllllIIllIlIIIlIlIIlIlIlll = Speed.mc.player.posZ;
                final double lllllllllllIIllIlIIIlIlIIlIlIllI = Speed.mc.player.rotationYaw * 0.017453292;
                if (Speed.mc.player.onGround) {
                    Speed.mc.timer.timerSpeed = 1.3f;
                    this.ticks = 11.0f;
                    MovementHelper.strafe();
                    Speed.mc.player.jump();
                }
                else if (this.ticks < 11.0f) {
                    ++this.ticks;
                }
                else {
                    if (Speed.timerHelper.hasReached(260.0)) {
                        Minecraft.getMinecraft().player.onGround = false;
                        final EntityPlayerSP player3;
                        final EntityPlayerSP lllllllllllIIllIlIIIlIlIIlIlIlIl = player3 = Minecraft.getMinecraft().player;
                        player3.motionX *= 1.7000000000000002;
                        final EntityPlayerSP player4;
                        final EntityPlayerSP lllllllllllIIllIlIIIlIlIIlIlIlII = player4 = Minecraft.getMinecraft().player;
                        player4.motionZ *= 1.7000000000000002;
                        Minecraft.getMinecraft().player.setPosition(lllllllllllIIllIlIIIlIlIIlIllIIl - Math.sin(lllllllllllIIllIlIIIlIlIIlIlIllI) * 0.003, lllllllllllIIllIlIIIlIlIIlIllIII, lllllllllllIIllIlIIIlIlIIlIlIlll + Math.cos(lllllllllllIIllIlIIIlIlIIlIlIllI) * 0.003);
                        Speed.timerHelper.reset();
                    }
                    this.ticks = 0.0f;
                }
            }
            else if (lllllllllllIIllIlIIIlIlIIlIllIll.equalsIgnoreCase("Matrix New")) {
                final BlockPos lllllllllllIIllIlIIIlIlIIlIlIIll = new BlockPos(Speed.mc.player.posX, Speed.mc.player.posY, Speed.mc.player.posZ);
                final BlockPos lllllllllllIIllIlIIIlIlIIlIlIIlI = new BlockPos(lllllllllllIIllIlIIIlIlIIlIlIIll.getX(), lllllllllllIIllIlIIIlIlIIlIlIIll.getY() - 1, lllllllllllIIllIlIIIlIlIIlIlIIll.getZ());
                if (Speed.mc.world.getBlockState(lllllllllllIIllIlIIIlIlIIlIlIIlI).getBlock() instanceof BlockAir) {
                    return;
                }
                if (Speed.mc.player.isInWeb || Speed.mc.player.isOnLadder() || Speed.mc.player.isInLiquid()) {
                    return;
                }
                final double lllllllllllIIllIlIIIlIlIIlIlIIIl = Speed.mc.player.posX;
                final double lllllllllllIIllIlIIIlIlIIlIlIIII = Speed.mc.player.posY;
                final double lllllllllllIIllIlIIIlIlIIlIIllll = Speed.mc.player.posZ;
                final double lllllllllllIIllIlIIIlIlIIlIIlllI = Speed.mc.player.rotationYaw * 0.017453292;
                if (Speed.mc.player.onGround) {
                    Speed.mc.player.jump();
                    Speed.mc.timer.timerSpeed = 0.95f;
                    this.ticks = 11.0f;
                }
                else if (this.ticks < 11.0f) {
                    ++this.ticks;
                }
                if (Speed.mc.player.motionY == -0.4448259643949201) {
                    final EntityPlayerSP player5;
                    final EntityPlayerSP lllllllllllIIllIlIIIlIlIIlIIllIl = player5 = Speed.mc.player;
                    player5.motionX *= 2.0;
                    final EntityPlayerSP player6;
                    final EntityPlayerSP lllllllllllIIllIlIIIlIlIIlIIllII = player6 = Speed.mc.player;
                    player6.motionZ *= 2.0;
                    Minecraft.getMinecraft().player.setPosition(lllllllllllIIllIlIIIlIlIIlIlIIIl - Math.sin(lllllllllllIIllIlIIIlIlIIlIIlllI) * 0.003, lllllllllllIIllIlIIIlIlIIlIlIIII, lllllllllllIIllIlIIIlIlIIlIIllll + Math.cos(lllllllllllIIllIlIIIlIlIIlIIlllI) * 0.003);
                }
                this.ticks = 0.0f;
            }
            else if (lllllllllllIIllIlIIIlIlIIlIllIll.equalsIgnoreCase("NCP")) {
                if (Speed.mc.player.onGround) {
                    Speed.mc.player.jump();
                }
                if (!Speed.mc.player.isInWater()) {
                    if (Speed.mc.player.onGround && !MovementHelper.isMoving() && Speed.mc.player.ticksExisted % 1 == 0 && Speed.mc.player.speedInAir < 0.03) {
                        final EntityPlayerSP player7 = Speed.mc.player;
                        player7.speedInAir *= 2.32412f;
                    }
                    if (!MovementHelper.isMoving()) {
                        Speed.mc.player.speedInAir = 0.02f;
                        return;
                    }
                    if (!Speed.mc.player.onGround) {
                        Speed.mc.player.speedInAir = 0.03f;
                        MovementHelper.strafe(0.3f);
                    }
                }
            }
            else if (lllllllllllIIllIlIIIlIlIIlIllIll.equalsIgnoreCase("NexusGrief")) {
                if (MovementHelper.isMoving() && Speed.mc.player.hurtTime > 0) {
                    MovementHelper.strafe();
                    if (Speed.mc.player.onGround) {
                        Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getDirection()) * 6.8 / 24.5, 0.0, Math.cos(MovementHelper.getDirection()) * 6.8 / 24.5);
                        MovementHelper.strafe();
                    }
                    else if (Speed.mc.player.isInWater()) {
                        Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getDirection()) * 7.5 / 24.5, 0.0, Math.cos(MovementHelper.getDirection()) * 7.5 / 24.5);
                        MovementHelper.strafe();
                    }
                    else if (!Speed.mc.player.onGround) {
                        Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getDirection2()) * 0.11 / 24.5, 0.0, Math.cos(MovementHelper.getDirection2()) * 0.11 / 24.5);
                        MovementHelper.strafe();
                    }
                    else {
                        Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getDirection()) * 0.005 * MovementHelper.getSpeed(), 0.0, Math.cos(MovementHelper.getDirection()) * 0.005 * MovementHelper.getSpeed());
                        MovementHelper.strafe();
                    }
                }
            }
            else if (lllllllllllIIllIlIIIlIlIIlIllIll.equalsIgnoreCase("SunriseDamage")) {
                if (MovementHelper.isMoving()) {
                    if (Speed.mc.player.onGround) {
                        Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getDirection()) * 9.8 / 24.5, 0.0, Math.cos(MovementHelper.getDirection()) * 9.8 / 24.5);
                        MovementHelper.strafe();
                    }
                    else if (Speed.mc.player.isInWater()) {
                        Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getDirection()) * 8.5 / 24.5, 0.0, Math.cos(MovementHelper.getDirection()) * 9.5 / 24.5);
                        MovementHelper.strafe();
                    }
                    else if (!Speed.mc.player.onGround) {
                        Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getDirection2()) * 0.11 / 24.5, 0.0, Math.cos(MovementHelper.getDirection2()) * 0.11 / 24.5);
                        MovementHelper.strafe();
                    }
                    else {
                        Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getDirection()) * 0.005 * MovementHelper.getSpeed(), 0.0, Math.cos(MovementHelper.getDirection()) * 0.005 * MovementHelper.getSpeed());
                        MovementHelper.strafe();
                    }
                }
            }
            else if (lllllllllllIIllIlIIIlIlIIlIllIll.equalsIgnoreCase("StormDisabler")) {
                if (Speed.mc.player.onGround) {
                    Speed.mc.player.jump();
                }
                else {
                    MovementHelper.setSpeed(this.speed.getNumberValue());
                }
            }
            else if (lllllllllllIIllIlIIIlIlIIlIllIll.equalsIgnoreCase("MagicGrief")) {
                final double lllllllllllIIllIlIIIlIlIIlIIlIll = Speed.mc.player.posX;
                final double lllllllllllIIllIlIIIlIlIIlIIlIlI = Speed.mc.player.posY;
                final double lllllllllllIIllIlIIIlIlIIlIIlIIl = Speed.mc.player.posZ;
                final double lllllllllllIIllIlIIIlIlIIlIIlIII = Speed.mc.player.rotationYaw * 0.017453292;
                if (Speed.mc.player.onGround) {
                    Speed.mc.player.jump();
                    Speed.mc.timer.timerSpeed = 0.5f;
                    this.ticks = 11.0f;
                }
                else if (this.ticks < 11.0f) {
                    ++this.ticks;
                }
                if (Speed.mc.player.motionY == -0.4448259643949201) {
                    final EntityPlayerSP lllllllllllIIllIlIIIlIlIIlIIIlll = Speed.mc.player;
                    Speed.mc.timer.timerSpeed = 2.0f;
                    final EntityPlayerSP entityPlayerSP = lllllllllllIIllIlIIIlIlIIlIIIlll;
                    entityPlayerSP.motionX *= 1.0;
                    final EntityPlayerSP player8;
                    final EntityPlayerSP lllllllllllIIllIlIIIlIlIIlIIIllI = player8 = Speed.mc.player;
                    player8.motionZ *= 1.0;
                    Minecraft.getMinecraft().player.setPosition(lllllllllllIIllIlIIIlIlIIlIIlIll - Math.sin(lllllllllllIIllIlIIIlIlIIlIIlIII) * 0.003, lllllllllllIIllIlIIIlIlIIlIIlIlI, lllllllllllIIllIlIIIlIlIIlIIlIIl + Math.cos(lllllllllllIIllIlIIIlIlIIlIIlIII) * 0.003);
                }
                else {
                    Speed.mc.timer.timerSpeed = 1.0f;
                }
            }
            this.setSuffix(lllllllllllIIllIlIIIlIlIIlIllIll, true);
        }
    }
    
    @Override
    public void onDisable() {
        Speed.mc.timer.timerSpeed = 1.0f;
        Speed.mc.player.speedInAir = 0.02f;
        super.onDisable();
    }
    
    @EventTarget
    public void onLagbackSpeed(final EventReceivePacket lllllllllllIIllIlIIIlIlIIllIllll) {
        if (lllllllllllIIllIlIIIlIlIIllIllll.getPacket() instanceof SPacketPlayerPosLook && this.lagbackCheck.getBoolValue()) {
            this.toggle();
            Main.msg("Anti-cheat discovered speedhack", true);
            NotificationPublisher.queue(ChatFormatting.RED + "Anti-Cheat", ChatFormatting.WHITE + "Anti-cheat discovered speedhack", NotificationType.WARNING);
        }
    }
}
