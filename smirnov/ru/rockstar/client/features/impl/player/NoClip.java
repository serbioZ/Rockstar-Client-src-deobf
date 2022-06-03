// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import ru.rockstar.api.event.event.EventReceivePacket;
import ru.rockstar.api.event.event.EventPreMotion;
import ru.rockstar.Main;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventFullCube;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class NoClip extends Feature
{
    public static /* synthetic */ NumberSetting magicspeed;
    public static /* synthetic */ BooleanSetting customSpeed;
    public static /* synthetic */ ListSetting mode;
    public static /* synthetic */ BooleanSetting onlyInBlocks;
    public static /* synthetic */ NumberSetting speed;
    
    @EventTarget
    public void onFullCube(final EventFullCube lllllllllllIIIIlIlIllIlIlIIIlIII) {
        lllllllllllIIIIlIlIllIlIlIIIlIII.setCancelled(!NoClip.mode.currentMode.equals("Packet") && !NoClip.mode.currentMode.equals("New Lorent"));
    }
    
    public NoClip() {
        super("NoClip", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0445\u043e\u0434\u0438\u0442\u044c \u0441\u043a\u0432\u043e\u0437\u044c \u0441\u0442\u0435\u043d\u044b", 0, Category.PLAYER);
        NoClip.onlyInBlocks = new BooleanSetting("Only In Blocks", false, () -> true);
        NoClip.mode = new ListSetting("NoClip Mode", "Default", () -> true, new String[] { "Default", "MagicGrief", "Packet", "Really World" });
        NoClip.customSpeed = new BooleanSetting("Custom Speed", false, () -> true);
        NoClip.speed = new NumberSetting("Speed", 0.02f, 0.0f, 2.0f, 0.01f, () -> NoClip.customSpeed.getBoolValue());
        NoClip.magicspeed = new NumberSetting("TimerSpeed", 5.0f, 0.0f, 20.0f, 1.0f, () -> NoClip.mode.getOptions().equalsIgnoreCase("MagicGrief"));
        this.addSettings(NoClip.mode, NoClip.customSpeed, NoClip.speed, NoClip.magicspeed, NoClip.onlyInBlocks);
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIIIIlIlIllIlIlIIIIIII) {
        if (NoClip.mode.currentMode.equals("Packet")) {
            NoClip.mc.player.setVelocity(0.0, 0.0, 0.0);
            lllllllllllIIIIlIlIllIlIlIIIIIII.setCancelled(true);
            float lllllllllllIIIIlIlIllIlIIlllllll = 0.0f;
            if (NoClip.mc.player.movementInput.jump) {
                if (!NoClip.timerHelper.hasReached(3000.0)) {
                    lllllllllllIIIIlIlIllIlIIlllllll = ((NoClip.mc.player.ticksExisted % 20 == 0) ? -0.04f : 0.031f);
                }
                else {
                    NoClip.timerHelper.reset();
                    lllllllllllIIIIlIlIllIlIIlllllll = -0.08f;
                }
            }
            else if (NoClip.mc.player.movementInput.sneak) {
                lllllllllllIIIIlIlIllIlIIlllllll = -0.0031f;
            }
            final double[] lllllllllllIIIIlIlIllIlIIllllllI = MovementHelper.forward(NoClip.speed.getNumberValue());
            NoClip.mc.player.motionX = lllllllllllIIIIlIlIllIlIIllllllI[0];
            NoClip.mc.player.motionY = lllllllllllIIIIlIlIllIlIIlllllll;
            NoClip.mc.player.motionZ = lllllllllllIIIIlIlIllIlIIllllllI[1];
            NoClip.mc.player.connection.sendPacket(new CPacketPlayer.PositionRotation(NoClip.mc.player.posX + NoClip.mc.player.motionX, NoClip.mc.player.posY + NoClip.mc.player.motionY, NoClip.mc.player.posZ + NoClip.mc.player.motionZ, NoClip.mc.player.rotationYaw, NoClip.mc.player.rotationPitch, NoClip.mc.player.onGround));
            final double lllllllllllIIIIlIlIllIlIIlllllIl = NoClip.mc.player.posX + NoClip.mc.player.motionX;
            double lllllllllllIIIIlIlIllIlIIlllllII = NoClip.mc.player.posY + NoClip.mc.player.motionY;
            final double lllllllllllIIIIlIlIllIlIIllllIll = NoClip.mc.player.posZ + NoClip.mc.player.motionZ;
            lllllllllllIIIIlIlIllIlIIlllllII += 1337.0;
            NoClip.mc.player.connection.sendPacket(new CPacketPlayer.Position(lllllllllllIIIIlIlIllIlIIlllllIl, lllllllllllIIIIlIlIllIlIIlllllII, lllllllllllIIIIlIlIllIlIIllllIll, NoClip.mc.player.onGround));
        }
    }
    
    public static boolean isNoClip(final Entity lllllllllllIIIIlIlIllIlIIlIIllll) {
        return (Main.featureDirector.getFeatureByClass(NoClip.class).isToggled() && NoClip.mc.player != null && (NoClip.mc.player.ridingEntity == null || lllllllllllIIIIlIlIllIlIIlIIllll == NoClip.mc.player.ridingEntity)) || lllllllllllIIIIlIlIllIlIIlIIllll.noClip;
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotion lllllllllllIIIIlIlIllIlIIlIllIll) {
        if (NoClip.mode.currentMode.equals("Packet")) {
            NoClip.mc.player.setVelocity(0.0, 0.0, 0.0);
            float lllllllllllIIIIlIlIllIlIIlIllIlI = 0.0f;
            if (NoClip.mc.player.movementInput.jump) {
                if (!NoClip.timerHelper.hasReached(3000.0)) {
                    lllllllllllIIIIlIlIllIlIIlIllIlI = ((NoClip.mc.player.ticksExisted % 20 == 0) ? -0.04f : 0.031f);
                }
                else {
                    NoClip.timerHelper.reset();
                    lllllllllllIIIIlIlIllIlIIlIllIlI = -0.08f;
                }
            }
            else if (NoClip.mc.player.movementInput.sneak) {
                lllllllllllIIIIlIlIllIlIIlIllIlI = -0.0031f;
            }
            final double[] lllllllllllIIIIlIlIllIlIIlIllIIl = MovementHelper.forward(NoClip.speed.getNumberValue());
            NoClip.mc.player.motionX = lllllllllllIIIIlIlIllIlIIlIllIIl[0];
            NoClip.mc.player.motionY = lllllllllllIIIIlIlIllIlIIlIllIlI;
            NoClip.mc.player.motionZ = lllllllllllIIIIlIlIllIlIIlIllIIl[1];
            NoClip.mc.player.connection.sendPacket(new CPacketPlayer.PositionRotation(NoClip.mc.player.posX + NoClip.mc.player.motionX, NoClip.mc.player.posY + NoClip.mc.player.motionY, NoClip.mc.player.posZ + NoClip.mc.player.motionZ, NoClip.mc.player.rotationYaw, NoClip.mc.player.rotationPitch, NoClip.mc.player.onGround));
            final double lllllllllllIIIIlIlIllIlIIlIllIII = NoClip.mc.player.posX + NoClip.mc.player.motionX;
            double lllllllllllIIIIlIlIllIlIIlIlIlll = NoClip.mc.player.posY + NoClip.mc.player.motionY;
            final double lllllllllllIIIIlIlIllIlIIlIlIllI = NoClip.mc.player.posZ + NoClip.mc.player.motionZ;
            lllllllllllIIIIlIlIllIlIIlIlIlll += 1337.0;
            NoClip.mc.player.connection.sendPacket(new CPacketPlayer.Position(lllllllllllIIIIlIlIllIlIIlIllIII, lllllllllllIIIIlIlIllIlIIlIlIlll, lllllllllllIIIIlIlIllIlIIlIlIllI, NoClip.mc.player.onGround));
        }
    }
    
    @EventTarget
    public void onUpdate(final EventReceivePacket lllllllllllIIIIlIlIllIlIIllIllIl) {
        final String lllllllllllIIIIlIlIllIlIIllIllII = NoClip.mode.getOptions();
        if (lllllllllllIIIIlIlIllIlIIllIllII.equalsIgnoreCase("Default")) {
            if (NoClip.onlyInBlocks.getBoolValue()) {
                if (NoClip.mc.player.noClip && NoClip.mc.player.onGround) {
                    NoClip.mc.player.noClip = true;
                    NoClip.mc.player.motionY = 1.0E-5;
                    if (NoClip.customSpeed.getBoolValue()) {
                        MovementHelper.setSpeed((NoClip.speed.getNumberValue() == 0.0f) ? MovementHelper.getBaseMoveSpeed() : ((double)NoClip.speed.getNumberValue()));
                    }
                    if (NoClip.mc.gameSettings.keyBindJump.isKeyDown()) {
                        NoClip.mc.player.motionY = 0.4;
                    }
                    if (NoClip.mc.gameSettings.keyBindSneak.isKeyDown()) {
                        NoClip.mc.player.motionY = -0.4;
                    }
                }
            }
            else {
                NoClip.mc.player.noClip = true;
                NoClip.mc.player.motionY = 1.0E-5;
                if (NoClip.customSpeed.getBoolValue()) {
                    MovementHelper.setSpeed((NoClip.speed.getNumberValue() == 0.0f) ? MovementHelper.getBaseMoveSpeed() : ((double)NoClip.speed.getNumberValue()));
                }
                if (NoClip.mc.gameSettings.keyBindJump.isKeyDown()) {
                    NoClip.mc.player.motionY = 0.4;
                }
                if (NoClip.mc.gameSettings.keyBindSneak.isKeyDown()) {
                    NoClip.mc.player.motionY = -0.4;
                }
            }
        }
        else if (lllllllllllIIIIlIlIllIlIIllIllII.equalsIgnoreCase("MagicGrief")) {
            if (NoClip.onlyInBlocks.getBoolValue()) {
                if (NoClip.mc.player.noClip && NoClip.mc.player.onGround) {
                    NoClip.mc.timer.timerSpeed = NoClip.magicspeed.getNumberValue();
                    NoClip.mc.player.motionY = 1.0E-5;
                    NoClip.mc.player.noClip = true;
                    if (NoClip.customSpeed.getBoolValue()) {
                        MovementHelper.setSpeed((NoClip.speed.getNumberValue() == 0.0f) ? MovementHelper.getBaseMoveSpeed() : ((double)NoClip.speed.getNumberValue()));
                    }
                    if (NoClip.mc.gameSettings.keyBindJump.isKeyDown()) {
                        NoClip.mc.player.motionY = 0.4;
                    }
                    if (NoClip.mc.gameSettings.keyBindSneak.isKeyDown()) {
                        NoClip.mc.player.motionY = -0.4;
                    }
                }
            }
            else {
                NoClip.mc.timer.timerSpeed = NoClip.magicspeed.getNumberValue();
                NoClip.mc.player.motionY = 1.0E-5;
                NoClip.mc.player.noClip = true;
                if (NoClip.customSpeed.getBoolValue()) {
                    MovementHelper.setSpeed((NoClip.speed.getNumberValue() == 0.0f) ? MovementHelper.getBaseMoveSpeed() : ((double)NoClip.speed.getNumberValue()));
                }
                if (NoClip.mc.gameSettings.keyBindJump.isKeyDown()) {
                    NoClip.mc.player.motionY = 0.4;
                }
                if (NoClip.mc.gameSettings.keyBindSneak.isKeyDown()) {
                    NoClip.mc.player.motionY = -0.4;
                }
            }
        }
        else if (lllllllllllIIIIlIlIllIlIIllIllII.equalsIgnoreCase("Packet")) {
            final SPacketPlayerPosLook lllllllllllIIIIlIlIllIlIIllIlIll = (SPacketPlayerPosLook)lllllllllllIIIIlIlIllIlIIllIllIl.getPacket();
            NoClip.mc.player.connection.sendPacket(new CPacketConfirmTeleport(lllllllllllIIIIlIlIllIlIIllIlIll.getTeleportId()));
            NoClip.mc.player.connection.sendPacket(new CPacketPlayer.PositionRotation(lllllllllllIIIIlIlIllIlIIllIlIll.getX(), NoClip.mc.player.posY, lllllllllllIIIIlIlIllIlIIllIlIll.getZ(), lllllllllllIIIIlIlIllIlIIllIlIll.getYaw(), lllllllllllIIIIlIlIllIlIIllIlIll.getPitch(), false));
            NoClip.mc.player.setPosition(lllllllllllIIIIlIlIllIlIIllIlIll.getX(), NoClip.mc.player.posY, lllllllllllIIIIlIlIllIlIIllIlIll.getZ());
            lllllllllllIIIIlIlIllIlIIllIllIl.setCancelled(true);
        }
        else if (NoClip.mode.currentMode.equals("Really World")) {
            final int lllllllllllIIIIlIlIllIlIIllIlIlI = 35;
            if (NoClip.mc.player.ticksExisted % 35 == 0) {
                NoClip.mc.timer.timerSpeed = 1.0f;
                this.toggle();
                return;
            }
            NoClip.mc.player.motionY = 0.0;
            final EntityPlayerSP player;
            final EntityPlayerSP lllllllllllIIIIlIlIllIlIIllIlIIl = player = NoClip.mc.player;
            player.motionX *= NoClip.speed.getNumberValue();
            final EntityPlayerSP player2;
            final EntityPlayerSP lllllllllllIIIIlIlIllIlIIllIlIII = player2 = NoClip.mc.player;
            player2.motionZ *= NoClip.speed.getNumberValue();
            NoClip.mc.timer.timerSpeed = 500.0f;
        }
    }
    
    @Override
    public void onDisable() {
        NoClip.mc.timer.timerSpeed = 1.0f;
        NoClip.mc.player.noClip = false;
        super.onDisable();
    }
}
