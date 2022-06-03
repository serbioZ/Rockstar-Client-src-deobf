// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.api.event.event.EventPacket;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.item.ItemStack;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.Main;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import ru.rockstar.api.event.event.EventReceivePacket;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventUpdate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import ru.rockstar.api.utils.world.InventoryHelper;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class Flight extends Feature
{
    public static /* synthetic */ NumberSetting speed;
    /* synthetic */ double motion;
    private final /* synthetic */ BooleanSetting lagbackCheck;
    public static /* synthetic */ ListSetting flyMode;
    /* synthetic */ int tick;
    public /* synthetic */ TimerHelper timerUtils;
    /* synthetic */ boolean velocity;
    /* synthetic */ boolean hui;
    public static /* synthetic */ NumberSetting motionBoost;
    /* synthetic */ boolean isVelocity;
    
    @Override
    public void onDisable() {
        super.onDisable();
        if (this.hui && Flight.mc.player.onGround) {
            Flight.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, Flight.mc.player);
            this.hui = false;
        }
        Flight.mc.player.speedInAir = 0.02f;
        Flight.mc.player.capabilities.setFlySpeed(1.0f);
        Flight.mc.player.speedInAir = 0.02f;
        Flight.mc.timer.timerSpeed = 1.0f;
        Flight.mc.player.capabilities.isFlying = false;
        this.tick = 0;
        if (Flight.flyMode.getOptions().equalsIgnoreCase("WellMore")) {
            Flight.mc.player.motionY = 0.0;
            Flight.mc.player.motionX = 0.0;
            Flight.mc.player.motionZ = 0.0;
        }
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIIIIlIIlIIllIlIIlIII) {
        final String llllllllllllIIIIlIIlIIllIlIIIlll = Flight.flyMode.getCurrentMode();
        if (llllllllllllIIIIlIIlIIllIlIIIlll.equalsIgnoreCase("Matrix Glide")) {
            if (Flight.mc.player.onGround) {
                Flight.mc.player.jump();
                Flight.timerHelper.resetwatermark();
            }
            else if (!Flight.mc.player.onGround) {
                Flight.mc.player.motionX = 0.0;
                Flight.mc.player.motionZ = 0.0;
                Flight.mc.player.motionY = -0.01;
                Flight.mc.player.capabilities.isFlying = true;
                Flight.mc.player.capabilities.setFlySpeed(Flight.speed.getNumberValue());
                Flight.mc.player.speedInAir = 0.3f;
            }
        }
    }
    
    @EventTarget
    public void onLagbackSpeed(final EventReceivePacket llllllllllllIIIIlIIlIIllIlIIIIIl) {
        final String llllllllllllIIIIlIIlIIllIlIIIIII = Flight.flyMode.getCurrentMode();
        if (llllllllllllIIIIlIIlIIllIlIIIIII.equalsIgnoreCase("Matrix New")) {
            if (llllllllllllIIIIlIIlIIllIlIIIIIl.getPacket() instanceof SPacketPlayerPosLook && this.lagbackCheck.getBoolValue() && !Flight.mc.player.onGround) {
                Flight.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, Flight.mc.player);
                Flight.mc.playerController.windowClick(0, 6, 1, ClickType.PICKUP, Flight.mc.player);
                if (Flight.timerHelper.hasReached(200.0)) {
                    Flight.mc.getConnection().sendPacket(new CPacketEntityAction(Flight.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
                    this.hui = true;
                    Flight.timerHelper.reset();
                }
            }
        }
        else if (llllllllllllIIIIlIIlIIllIlIIIIIl.getPacket() instanceof SPacketPlayerPosLook && this.lagbackCheck.getBoolValue()) {
            this.toggle();
            Main.msg("Anti-cheat discovered flying", true);
        }
    }
    
    public Flight() {
        super("Flight", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0432\u0430\u043c \u043b\u0435\u0442\u0430\u0442\u044c \u0431\u0435\u0437 \u043a\u0440\u0435\u0430\u0442\u0438\u0432 \u0440\u0435\u0436\u0438\u043c\u0430", 0, Category.MOVEMENT);
        this.timerUtils = new TimerHelper();
        this.hui = false;
        this.lagbackCheck = new BooleanSetting("Lagback Check", "\u0412\u043e\u0437\u0432\u0440\u0430\u0449\u0430\u0435\u0442 \u043d\u0430\u0437\u0430\u0434 \u0435\u0441\u043b\u0438 \u0430\u043d\u0442\u0438\u0447\u0438\u0442 \u0441\u043f\u0430\u043c\u0438\u0442 \u0447\u0435\u043a\u0430\u043c\u0438", false, () -> true);
        Flight.flyMode = new ListSetting("Flight Mode", "Vanilla", () -> true, new String[] { "Vanilla", "Matrix Long", "Matrix New", "WellMore", "Matrix Glide", "Packet" });
        Flight.motionBoost = new NumberSetting("Motion Boost", 0.6f, 0.1f, 8.0f, 0.1f, () -> Flight.flyMode.currentMode.equals("Matrix Damage"));
        Flight.speed = new NumberSetting("Flight Speed", 5.0f, 0.01f, 10.0f, 0.01f, () -> Flight.flyMode.currentMode.equals("Matrix New") || Flight.flyMode.currentMode.equals("Vanilla") || Flight.flyMode.currentMode.equalsIgnoreCase("Matrix Glide") || Flight.flyMode.currentMode.equals("WellMore"));
        this.addSettings(Flight.flyMode, Flight.speed, this.lagbackCheck, Flight.motionBoost);
    }
    
    @EventTarget
    public void onPacketReceive(final EventReceivePacket llllllllllllIIIIlIIlIIllIIlIIIlI) {
        if (Flight.flyMode.currentMode.equals("Packet") && llllllllllllIIIIlIIlIIllIIlIIIlI.getPacket() instanceof SPacketPlayerPosLook) {
            final SPacketPlayerPosLook llllllllllllIIIIlIIlIIllIIlIIIll = (SPacketPlayerPosLook)llllllllllllIIIIlIIlIIllIIlIIIlI.getPacket();
            llllllllllllIIIIlIIlIIllIIlIIIll.yaw = Flight.mc.player.rotationYaw;
            llllllllllllIIIIlIIlIIllIIlIIIll.pitch = Flight.mc.player.rotationPitch;
        }
    }
    
    public static boolean isNullOrEmpty(final ItemStack llllllllllllIIIIlIIlIIllIlIIlIll) {
        return llllllllllllIIIIlIIlIIllIlIIlIll == null || llllllllllllIIIIlIIlIIllIlIIlIll.isEmpty();
    }
    
    @EventTarget
    public void onPacket(final EventReceivePacket llllllllllllIIIIlIIlIIllIlIllIIl) {
        final String llllllllllllIIIIlIIlIIllIlIllIII = Flight.flyMode.getOptions();
        if (llllllllllllIIIIlIIlIIllIlIllIII.equalsIgnoreCase("Matrix New") && llllllllllllIIIIlIIlIIllIlIllIIl.getPacket() instanceof SPacketEntityVelocity) {
            if (((SPacketEntityVelocity)llllllllllllIIIIlIIlIIllIlIllIIl.getPacket()).getMotionY() > 0) {
                this.isVelocity = true;
            }
            if (((SPacketEntityVelocity)llllllllllllIIIIlIIlIIllIlIllIIl.getPacket()).getMotionY() / 8000.0 > 0.2) {
                this.motion = ((SPacketEntityVelocity)llllllllllllIIIIlIIlIIllIlIllIIl.getPacket()).getMotionY() / 8000.0;
                this.velocity = true;
            }
        }
        final Packet<?> llllllllllllIIIIlIIlIIllIlIlIlll = (Packet<?>)llllllllllllIIIIlIIlIIllIlIllIIl.getPacket();
        if (llllllllllllIIIIlIIlIIllIlIllIII.equalsIgnoreCase("WellMore") && llllllllllllIIIIlIIlIIllIlIllIIl.isIncoming() && Flight.timerHelper.hasReached(1000.0) && llllllllllllIIIIlIIlIIllIlIlIlll instanceof SPacketPlayerPosLook && Flight.mc.player != null) {
            llllllllllllIIIIlIIlIIllIlIllIIl.setCancelled(true);
            Flight.timerHelper.reset();
        }
        if (Flight.flyMode.currentMode.equals("Packet")) {
            llllllllllllIIIIlIIlIIllIlIllIIl.setCancelled(true);
        }
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate llllllllllllIIIIlIIlIIllIIllIlIl) {
        final String llllllllllllIIIIlIIlIIllIIllIlII = Flight.flyMode.getCurrentMode();
        this.setSuffix(Flight.flyMode.getCurrentMode(), true);
        if (llllllllllllIIIIlIIlIIllIIllIlII.equalsIgnoreCase("Matrix Glide")) {
            llllllllllllIIIIlIIlIIllIIllIlIl.setGround(true);
        }
        else if (llllllllllllIIIIlIIlIIllIIllIlII.equalsIgnoreCase("Matrix New")) {
            final boolean llllllllllllIIIIlIIlIIllIIllIIll = false;
            Flight.mc.timer.timerSpeed = 1.0f;
            Flight.mc.player.speedInAir = 0.02f;
            if (this.hui && Flight.mc.player.onGround) {
                Flight.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, Flight.mc.player);
                Flight.mc.playerController.windowClick(0, 9, 1, ClickType.PICKUP, Flight.mc.player);
                this.hui = false;
            }
            if (!this.hui) {
                final short llllllllllllIIIIlIIlIIllIIllIIlI = Flight.mc.player.openContainer.getNextTransactionID(Flight.mc.player.inventory);
                Flight.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, Flight.mc.player);
                Flight.mc.playerController.windowClick(0, 6, 1, ClickType.PICKUP, Flight.mc.player);
                if (!Flight.mc.player.isElytraFlying() && !Flight.mc.player.onGround && Flight.timerHelper.hasReached(500.0)) {
                    Flight.mc.getConnection().sendPacket(new CPacketEntityAction(Flight.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
                    this.hui = true;
                    Flight.timerHelper.reset();
                }
            }
            if (Flight.mc.gameSettings.keyBindJump.isKeyDown() && !Flight.mc.player.onGround) {
                this.tick += (int)(1.0f / Flight.mc.timer.timerSpeed);
                Flight.mc.player.jump2();
                if (this.tick >= 29) {
                    this.tick = 0;
                    super.toggle();
                }
            }
            else {
                Flight.mc.playerController.windowClick(0, InventoryHelper.getElytraAtHotbar(), 1, ClickType.PICKUP, Flight.mc.player);
                Flight.mc.playerController.windowClick(0, 13, 1, ClickType.PICKUP, Flight.mc.player);
                this.hui = false;
            }
        }
        else if (llllllllllllIIIIlIIlIIllIIllIlII.equalsIgnoreCase("Wellmore")) {
            if (Flight.mc.player.onGround) {
                Flight.mc.player.jump();
            }
            else {
                Flight.mc.player.motionX = 0.0;
                Flight.mc.player.motionZ = 0.0;
                Flight.mc.player.motionY = -0.01;
                MovementHelper.setSpeed(Flight.speed.getNumberValue());
                Flight.mc.player.speedInAir = 0.3f;
                if (Flight.mc.gameSettings.keyBindSneak.isKeyDown()) {
                    final EntityPlayerSP player = Flight.mc.player;
                    player.motionY -= Flight.speed.getNumberValue();
                }
                else if (Flight.mc.gameSettings.keyBindJump.isKeyDown()) {
                    final EntityPlayerSP player2 = Flight.mc.player;
                    player2.motionY += Flight.speed.getNumberValue();
                }
            }
        }
        else if (llllllllllllIIIIlIIlIIllIIllIlII.equalsIgnoreCase("Vanilla")) {
            Flight.mc.player.capabilities.isFlying = true;
            MovementHelper.setSpeed(Flight.speed.getNumberValue());
            if (Flight.mc.gameSettings.keyBindSneak.isKeyDown()) {
                final EntityPlayerSP player3 = Flight.mc.player;
                player3.motionY -= Flight.speed.getNumberValue();
            }
            else if (Flight.mc.gameSettings.keyBindJump.isKeyDown()) {
                final EntityPlayerSP player4 = Flight.mc.player;
                player4.motionY += Flight.speed.getNumberValue();
            }
        }
        if (llllllllllllIIIIlIIlIIllIIllIlII.equalsIgnoreCase("Matrix Long") && Flight.timerHelper.hasReached(100.0) && Flight.mc.player.onGround) {
            llllllllllllIIIIlIIlIIllIIllIlIl.setGround(true);
            Flight.mc.player.onGround = true;
            Flight.mc.player.isCollidedVertically = true;
            Flight.mc.player.isCollidedHorizontally = true;
            Flight.mc.player.isAirBorne = true;
            Flight.mc.player.motionX = 0.0;
            Flight.mc.player.motionZ = 0.0;
            Flight.mc.player.motionY = 20.0;
            Flight.timerHelper.reset();
        }
        if (llllllllllllIIIIlIIlIIllIIllIlII.equalsIgnoreCase("Packet")) {
            double llllllllllllIIIIlIIlIIllIIllIIII = 0.0;
            if (Flight.mc.player.movementInput.jump && !MovementHelper.isMoving()) {
                final double llllllllllllIIIIlIIlIIllIIllIIIl = 0.062;
                Flight.mc.player.noClip = false;
            }
            else {
                llllllllllllIIIIlIIlIIllIIllIIII = (Flight.mc.player.movementInput.sneak ? -0.062 : 0.0);
            }
            Flight.mc.player.noClip = true;
            final double llllllllllllIIIIlIIlIIllIIlIllll = MovementHelper.getSpeed();
            for (int llllllllllllIIIIlIIlIIllIIlIlllI = 1; llllllllllllIIIIlIIlIIllIIlIlllI < 2; ++llllllllllllIIIIlIIlIIllIIlIlllI) {
                Flight.mc.player.motionX = llllllllllllIIIIlIIlIIllIIlIllll * llllllllllllIIIIlIIlIIllIIlIlllI * 1.0;
                Flight.mc.player.motionY = llllllllllllIIIIlIIlIIllIIllIIII * llllllllllllIIIIlIIlIIllIIlIlllI;
                Flight.mc.player.motionZ = llllllllllllIIIIlIIlIIllIIlIllll * llllllllllllIIIIlIIlIIllIIlIlllI * 1.0;
                Flight.mc.player.connection.sendPacket(new CPacketPlayer.PositionRotation(Flight.mc.player.motionX, Flight.mc.player.motionY, Flight.mc.player.motionZ, Flight.mc.player.rotationYaw, Flight.mc.player.rotationPitch, true));
            }
        }
    }
    
    @EventTarget
    public void EventSendPacket(final EventPacket llllllllllllIIIIlIIlIIllIlIIlllI) {
    }
}
