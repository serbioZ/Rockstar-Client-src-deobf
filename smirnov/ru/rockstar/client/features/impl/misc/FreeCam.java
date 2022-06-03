// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import ru.rockstar.api.event.event.EventReceivePacket;
import net.minecraft.world.World;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketEntityAction;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.Main;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class FreeCam extends Feature
{
    public /* synthetic */ NumberSetting speed;
    public /* synthetic */ BooleanSetting AntiAction;
    /* synthetic */ double y;
    /* synthetic */ double yaw;
    public /* synthetic */ BooleanSetting autoDamageDisable;
    /* synthetic */ double z;
    /* synthetic */ double x;
    public /* synthetic */ BooleanSetting clipOnDisable;
    
    @EventTarget
    public void ebatkopat(final Event2D lllllllllllIlllIIIlIllllllllIIll) {
        final ScaledResolution lllllllllllIlllIIIlIllllllllIIlI = new ScaledResolution(FreeCam.mc);
        Minecraft.getMinecraft().neverlose500_18.drawStringWithShadow("Y: " + (int)(FreeCam.mc.player.posY - this.y), lllllllllllIlllIIIlIllllllllIIlI.getScaledWidth() / 2 - 7, lllllllllllIlllIIIlIllllllllIIlI.getScaledHeight() / 2 + 7, -1);
    }
    
    @EventTarget
    public void onPreMotion(final EventUpdate lllllllllllIlllIIIlIlllllllIllII) {
        if (this.autoDamageDisable.getBoolValue() && FreeCam.mc.player.hurtTime > 0 && Main.featureDirector.getFeatureByClass(FreeCam.class).isToggled()) {
            Main.featureDirector.getFeatureByClass(FreeCam.class).toggle();
        }
        FreeCam.mc.player.motionY = 0.0;
        if (FreeCam.mc.gameSettings.keyBindJump.pressed) {
            FreeCam.mc.player.motionY = this.speed.getNumberValue();
        }
        if (FreeCam.mc.gameSettings.keyBindSneak.pressed) {
            FreeCam.mc.player.motionY = -this.speed.getNumberValue();
        }
        FreeCam.mc.player.noClip = true;
        MovementHelper.setSpeed(this.speed.getNumberValue());
        lllllllllllIlllIIIlIlllllllIllII.setCancelled(true);
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        if (this.clipOnDisable.getBoolValue()) {
            this.yaw = 0.0;
            FreeCam.mc.getConnection().sendPacket(new CPacketEntityAction(FreeCam.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
            FreeCam.mc.player.setPositionAndUpdate(FreeCam.mc.player.posX + Math.sin(this.yaw), FreeCam.mc.player.posY, FreeCam.mc.player.posZ - Math.cos(this.yaw));
        }
        else {
            FreeCam.mc.player.setPosition(this.x, this.y, this.z);
            FreeCam.mc.getConnection().sendPacket(new CPacketPlayer.Position(FreeCam.mc.player.posX, FreeCam.mc.player.posY + 0.01, FreeCam.mc.player.posZ, FreeCam.mc.player.onGround));
        }
        FreeCam.mc.player.capabilities.isFlying = false;
        FreeCam.mc.player.noClip = false;
        FreeCam.mc.world.removeEntityFromWorld(-1);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        this.x = FreeCam.mc.player.posX;
        this.y = FreeCam.mc.player.posY;
        this.z = FreeCam.mc.player.posZ;
        final EntityOtherPlayerMP lllllllllllIlllIIIlIlllllllllIIl = new EntityOtherPlayerMP(FreeCam.mc.world, FreeCam.mc.player.getGameProfile());
        lllllllllllIlllIIIlIlllllllllIIl.inventory = FreeCam.mc.player.inventory;
        lllllllllllIlllIIIlIlllllllllIIl.inventoryContainer = FreeCam.mc.player.inventoryContainer;
        lllllllllllIlllIIIlIlllllllllIIl.setHealth(FreeCam.mc.player.getHealth());
        lllllllllllIlllIIIlIlllllllllIIl.setPositionAndRotation(this.x, FreeCam.mc.player.getEntityBoundingBox().minY, this.z, FreeCam.mc.player.rotationYaw, FreeCam.mc.player.rotationPitch);
        lllllllllllIlllIIIlIlllllllllIIl.rotationYawHead = FreeCam.mc.player.rotationYawHead;
        FreeCam.mc.world.addEntityToWorld(-1, lllllllllllIlllIIIlIlllllllllIIl);
        this.yaw = lllllllllllIlllIIIlIlllllllllIIl.rotationYaw * 0.017453292;
    }
    
    @EventTarget
    public void onReceivePacket(final EventReceivePacket lllllllllllIlllIIIlIllllllllllIl) {
        if (this.AntiAction.getBoolValue() && lllllllllllIlllIIIlIllllllllllIl.getPacket() instanceof SPacketPlayerPosLook) {
            lllllllllllIlllIIIlIllllllllllIl.setCancelled(true);
        }
    }
    
    public FreeCam() {
        super("FreeCam", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043b\u0435\u0442\u0430\u0442\u044c \u0432 \u0441\u0432\u043e\u0431\u043e\u0434\u043d\u043e\u0439 \u043a\u0430\u043c\u0435\u0440\u0435", 0, Category.MISC);
        this.AntiAction = new BooleanSetting("ReallyWorld", false, () -> true);
        this.clipOnDisable = new BooleanSetting("Clip On Disable", false, () -> true);
        this.autoDamageDisable = new BooleanSetting("Auto Damage Disable", false, () -> true);
        this.speed = new NumberSetting("Flying Speed", 0.5f, 0.1f, 1.0f, 0.1f, () -> true);
        this.addSettings(this.speed, this.autoDamageDisable, this.AntiAction, this.clipOnDisable);
    }
}
