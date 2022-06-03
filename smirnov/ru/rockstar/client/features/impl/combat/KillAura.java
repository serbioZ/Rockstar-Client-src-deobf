// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.event.EventNameTags;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.play.client.CPacketEntityAction;
import ru.rockstar.api.utils.combat.EntityHelper;
import net.minecraft.item.ItemSword;
import ru.rockstar.api.utils.combat.GCDFix;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import ru.rockstar.api.event.event.EventAttackSilent;
import net.minecraft.client.entity.EntityPlayerSP;
import ru.rockstar.api.event.event.EventStrafe;
import java.util.Iterator;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.gui.inventory.GuiInventory;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.client.features.impl.visuals.NameProtect;
import ru.rockstar.Main;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.EnumHand;
import net.minecraft.client.gui.Gui;
import ru.rockstar.api.utils.render.ClientHelper;
import java.util.Objects;
import net.minecraft.client.network.NetHandlerPlayClient;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.api.utils.render.AnimationHelper;
import ru.rockstar.client.ui.draggable.impl.TargetHudComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.api.utils.other.Util;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.utils.combat.KillAuraHelper;
import net.minecraft.client.Minecraft;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.network.play.client.CPacketUseEntity;
import ru.rockstar.api.event.event.EventSendPacket;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import ru.rockstar.api.utils.combat.RotationHelper;
import net.minecraft.entity.Entity;
import ru.rockstar.api.utils.world.InventoryHelper;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.ui.settings.Setting;
import java.util.ArrayList;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import org.lwjgl.input.Mouse;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemShield;
import ru.rockstar.api.event.event.EventUpdate;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class KillAura extends Feature
{
    public static /* synthetic */ BooleanSetting shieldFix;
    public static /* synthetic */ NumberSetting range;
    public static /* synthetic */ BooleanSetting walls;
    /* synthetic */ float yaw2;
    public static /* synthetic */ NumberSetting thudX;
    public static /* synthetic */ BooleanSetting auraplayers;
    public static /* synthetic */ ListSetting sortMode;
    /* synthetic */ float pitch2;
    public static /* synthetic */ BooleanSetting weaponOnly;
    public static /* synthetic */ BooleanSetting onlyCrits;
    public static /* synthetic */ BooleanSetting teamCheck;
    public static /* synthetic */ BooleanSetting rayTrace;
    public static /* synthetic */ BooleanSetting shieldBypass;
    public static /* synthetic */ ListSetting rotationStrafeMode;
    public static /* synthetic */ NumberSetting breakerAps;
    public static /* synthetic */ ListSetting strafeMode;
    public static /* synthetic */ BooleanSetting targetHud;
    public static /* synthetic */ ListSetting clickMode;
    public static /* synthetic */ BooleanSetting autoShieldUnPress;
    public static /* synthetic */ BooleanSetting autoJump;
    public static /* synthetic */ BooleanSetting shieldDesync;
    public static /* synthetic */ double hurttimeBarWidth;
    private /* synthetic */ boolean isBlocking;
    /* synthetic */ float pitch;
    public static /* synthetic */ NumberSetting thudY;
    public static /* synthetic */ EntityLivingBase target;
    public static /* synthetic */ NumberSetting minAps;
    public static /* synthetic */ BooleanSetting auramobs;
    public static /* synthetic */ NumberSetting attackCoolDown;
    public static /* synthetic */ NumberSetting breakerDelay;
    public static /* synthetic */ BooleanSetting ignoreNakedPlayer;
    public static /* synthetic */ BooleanSetting BetterCrits;
    public static /* synthetic */ NumberSetting critFallDistance;
    public static /* synthetic */ BooleanSetting invisiblecheck;
    /* synthetic */ float yaw;
    public static /* synthetic */ double healthBarWidth;
    public static /* synthetic */ BooleanSetting doubleTap;
    /* synthetic */ List<EntityLivingBase> targets;
    public static /* synthetic */ NumberSetting maxAps;
    public static /* synthetic */ NumberSetting fov;
    public static /* synthetic */ double hudHeight;
    public static /* synthetic */ BooleanSetting stopSprint;
    public static /* synthetic */ BooleanSetting shieldBreak;
    public static /* synthetic */ ListSetting targetHudMode;
    public static /* synthetic */ ListSetting rotationMode;
    public static /* synthetic */ NumberSetting rotPredict;
    public static /* synthetic */ BooleanSetting autoBlock;
    
    static {
        KillAura.rotPredict = new NumberSetting("Rotation Predict", 0.05f, 0.0f, 10.0f, 0.001f, () -> true);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllllIlIlIIlIIIlIlllII) {
        if (KillAura.autoJump.getBoolValue() && KillAura.mc.player.onGround && KillAura.target != null) {
            KillAura.mc.player.jump();
        }
        if (KillAura.autoShieldUnPress.getBoolValue() && KillAura.mc.player.getHeldItemMainhand().getItem() instanceof ItemShield && KillAura.mc.player.isBlocking()) {
            if (KillAura.target.getHeldItemMainhand().getItem() instanceof ItemAxe) {
                if (KillAura.mc.gameSettings.keyBindUseItem.isKeyDown()) {
                    KillAura.mc.gameSettings.keyBindUseItem.pressed = false;
                }
            }
            else {
                KillAura.mc.gameSettings.keyBindUseItem.pressed = Mouse.isButtonDown(1);
            }
        }
    }
    
    public KillAura() {
        super("KillAura", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0430\u0442\u0442\u0430\u043a\u0443\u0435\u0442 \u044d\u043d\u0442\u0438\u0442\u0438.", 0, Category.COMBAT);
        this.pitch2 = 0.0f;
        this.yaw2 = 0.0f;
        this.targets = new ArrayList<EntityLivingBase>();
        KillAura.sortMode = new ListSetting("Sorting Mode", "Distance", () -> true, new String[] { "Distance", "Health" });
        KillAura.rotationStrafeMode = new ListSetting("Rotation Strafe Mode", "Default", () -> !KillAura.strafeMode.currentMode.equals("None"), new String[] { "Default", "Silent" });
        KillAura.strafeMode = new ListSetting("Strafe Mode", "None", () -> true, new String[] { "None", "Always-F" });
        KillAura.targetHudMode = new ListSetting("TargetHud Mode", "Rockstar", () -> KillAura.targetHud.getBoolValue(), new String[] { "Astolfo", "Beach", "Celestial Premium", "Nursultan", "Rockstar", "Red-Blue" });
        KillAura.clickMode = new ListSetting("Click Mode", "1.9", () -> true, new String[] { "1.9", "1.8" });
        KillAura.rotationMode = new ListSetting("Rotation Mode", "Matrix", () -> true, new String[] { "Matrix", "Snap", "Client", "AAC", "ReallyWorld", "Legit", "SunRise", "MagicGrief", "StormHVH" });
        KillAura.fov = new NumberSetting("FOV", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0440\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0440\u0430\u0434\u0438\u0443\u0441 \u0432 \u043a\u043e\u0442\u043e\u0440\u043e\u043c \u0432\u044b \u043c\u043e\u0436\u0435\u0442\u0435 \u0443\u0434\u0430\u0440\u0438\u0442\u044c \u0438\u0433\u0440\u043e\u043a\u0430", 180.0f, 0.0f, 180.0f, 1.0f, () -> true);
        KillAura.range = new NumberSetting("AttackRange", "\u0414\u0438\u0441\u0442\u0430\u043d\u0446\u0438\u044f \u0432 \u043a\u043e\u0442\u043e\u0440\u043e\u0439 \u0432\u044b \u043c\u043e\u0436\u0435\u0442\u0435 \u0443\u0434\u0430\u0440\u0438\u0442\u044c \u0438\u0433\u0440\u043e\u043a\u0430", 3.6f, 3.0f, 6.0f, 0.05f, () -> true);
        KillAura.attackCoolDown = new NumberSetting("Cooldown", "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u0443\u0435\u0442 \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0443\u0434\u0430\u0440\u0430", 0.85f, 0.1f, 1.0f, 0.01f, () -> KillAura.clickMode.currentMode.equals("1.9"));
        KillAura.minAps = new NumberSetting("Min CPS", "\u041c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043a\u043b\u0438\u043a\u043e\u0432 \u0432 \u0441\u0435\u043a\u0443\u043d\u0434\u0443", 12.0f, 1.0f, 20.0f, 1.0f, () -> KillAura.clickMode.currentMode.equals("1.8"), NumberSetting.NumberType.APS);
        KillAura.maxAps = new NumberSetting("Max CPS", "\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043a\u043b\u0438\u043a\u043e\u0432 \u0432 \u0441\u0435\u043a\u0443\u043d\u0434\u0443", 13.0f, 1.0f, 20.0f, 1.0f, () -> KillAura.clickMode.currentMode.equals("1.8"), NumberSetting.NumberType.APS);
        KillAura.auraplayers = new BooleanSetting("Players", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u0438\u0442\u044c \u0438\u0433\u0440\u043e\u043a\u043e\u0432", true, () -> true);
        KillAura.auramobs = new BooleanSetting("Mobs", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u0438\u0442\u044c \u043c\u043e\u0431\u043e\u0432", true, () -> true);
        KillAura.invisiblecheck = new BooleanSetting("Invisible", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u0438\u0442\u044c \u043d\u0435\u0432\u0438\u0434\u0435\u043c\u044b\u0445 \u0441\u0443\u0449\u0435\u0441\u0442\u0432", true, () -> true);
        KillAura.walls = new BooleanSetting("Walls", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u0438\u0442\u044c \u0441\u043a\u0432\u043e\u0437\u044c \u0441\u0442\u0435\u043d\u044b", true, () -> true);
        KillAura.rayTrace = new BooleanSetting("RayTrace", "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u0442 \u0441\u043c\u043e\u0442\u0440\u0438\u0442 \u043b\u0438 \u0440\u043e\u0442\u0430\u0446\u0438\u044f \u043d\u0430 \u0445\u0438\u0442\u0431\u043e\u043a\u0441", true, () -> true);
        KillAura.weaponOnly = new BooleanSetting("Weapon Only", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u0438\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0441 \u043e\u0440\u0443\u0436\u0438\u0435\u043c \u0432 \u0440\u0443\u043a\u0430\u0445", false, () -> true);
        KillAura.ignoreNakedPlayer = new BooleanSetting("Ignore Naked Players", "\u041d\u0435 \u0431\u044c\u0435\u0442 \u0433\u043e\u043b\u044b\u0445 \u0438\u0433\u0440\u043e\u043a\u043e\u0432", false, () -> true);
        KillAura.stopSprint = new BooleanSetting("Stop Sprinting", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0432\u044b\u043a\u043b\u044e\u0447\u0430\u0435\u0442 \u0441\u043f\u0440\u0438\u043d\u0442", false, () -> true);
        KillAura.doubleTap = new BooleanSetting("DoubleTap", "\u0422\u0430\u043f\u0430\u0435\u0442 2 \u0440\u0430\u0437\u0430, \u0432\u043c\u0435\u0441\u0442\u043e \u043e\u0434\u043d\u043e\u0433\u043e", false, () -> true);
        KillAura.onlyCrits = new BooleanSetting("OnlyCrits", "\u0411\u044c\u0435\u0442 \u0432 \u043d\u0443\u0436\u043d\u044b\u0439 \u043c\u043e\u043c\u0435\u043d\u0442 \u0434\u043b\u044f \u043a\u0440\u0438\u0442\u0430", false, () -> !KillAura.clickMode.currentMode.equalsIgnoreCase("1.8"));
        KillAura.BetterCrits = new BooleanSetting("BetterCrits", "\u0423\u043b\u0443\u0447\u0448\u0430\u0435\u0442 \u043f\u0440\u043e\u0445\u043e\u0434\u0438\u043c\u043e\u0441\u0442\u044c \u0445\u0438\u0442\u043e\u0432", false, () -> KillAura.onlyCrits.getBoolValue() && !KillAura.clickMode.currentMode.equalsIgnoreCase("1.8"));
        KillAura.critFallDistance = new NumberSetting("Criticals Fall Distance", "\u0420\u0435\u0433\u0443\u043b\u0438\u0440\u043e\u0432\u043a\u0430 \u0434\u0438\u0441\u0442\u0430\u043d\u0446\u0438\u0438 \u0434\u043e \u0437\u0435\u043c\u043b\u0438 \u0434\u043b\u044f \u043a\u0440\u0438\u0442\u0430", 0.2f, 0.1f, 1.0f, 0.01f, () -> KillAura.onlyCrits.getBoolValue());
        KillAura.teamCheck = new BooleanSetting("Team Check", false, () -> true);
        KillAura.shieldBreak = new BooleanSetting("Break Shield", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u043b\u043e\u043c\u0430\u0435\u0442 \u0449\u0438\u0442 \u0441\u043e\u043f\u0435\u0440\u043d\u0438\u043a\u0443", false, () -> !KillAura.clickMode.currentMode.equalsIgnoreCase("1.8"));
        KillAura.breakerDelay = new NumberSetting("Breaker Delay", "\u0420\u0435\u0433\u0443\u043b\u0438\u0440\u043e\u0432\u043a\u0430 \u043b\u043e\u043c\u0430\u043d\u0438\u044f \u0449\u0438\u0442\u0430", 50.0f, 0.0f, 50.0f, 1.0f, () -> KillAura.shieldBreak.getBoolValue());
        KillAura.breakerAps = new NumberSetting("Breaker APS", "\u0420\u0435\u0433\u0443\u043b\u0438\u0440\u043e\u0432\u043a\u0430 \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u0438 \u043b\u043e\u043c\u0430\u043d\u0438\u044f \u0449\u0438\u0442\u0430", 1.0f, 0.0f, 10.0f, 1.0f, () -> KillAura.shieldBreak.getBoolValue());
        KillAura.shieldFix = new BooleanSetting("Shield Fix", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0437\u0430\u0436\u0438\u043c\u0430\u0435\u0442 \u0449\u0438\u0442(\u043e\u0431\u0445\u043e\u0434)", false, () -> !KillAura.clickMode.currentMode.equalsIgnoreCase("1.8"));
        KillAura.shieldBypass = new BooleanSetting("Shield Bypass", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u0438\u0442\u044c \u0447\u0435\u0440\u0435\u0437 \u0449\u0438\u0442", false, () -> !KillAura.clickMode.currentMode.equalsIgnoreCase("1.8"));
        KillAura.autoShieldUnPress = new BooleanSetting("Auto Shield UnPress", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u043e\u0442\u0436\u0438\u043c\u0430\u0435\u0442 \u0449\u0438\u0442 \u0435\u0441\u043b\u0438 \u0443 \u0441\u043e\u043f\u0435\u0440\u043d\u0438\u043a\u0430 \u0442\u043e\u043f\u043e\u0440 \u0432 \u0440\u0443\u043a\u0430\u0445", false, () -> !KillAura.clickMode.currentMode.equalsIgnoreCase("1.8"));
        KillAura.autoBlock = new BooleanSetting("Auto Block", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0436\u043c\u0435\u0442 \u043f\u043a\u043c \u043f\u0440\u0438 \u0443\u0434\u0430\u0440\u0435 (\u043d\u0443\u0436\u043d\u043e \u0434\u043b\u044f 1.8 \u0441\u0435\u0440\u0432\u0435\u0440\u043e\u0432)", false, () -> KillAura.clickMode.currentMode.equalsIgnoreCase("1.8"));
        KillAura.targetHud = new BooleanSetting("TargetHud", "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u0442 \u0445\u043f, \u0435\u0434\u0443, \u0431\u0440\u043e\u043d\u044e \u0441\u043e\u043f\u0435\u0440\u043d\u0438\u043a\u0430 \u043d\u0430 \u044d\u043a\u0440\u0430\u043d\u0435", true, () -> true);
        KillAura.autoJump = new BooleanSetting("AutoJump", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u043f\u0440\u044b\u0433\u0430\u0435\u0442", false, () -> true);
        KillAura.thudX = new NumberSetting("TargetHud X", 360.0f, -500.0f, 500.0f, 1.0f, () -> KillAura.targetHud.getBoolValue());
        KillAura.thudY = new NumberSetting("TargetHud Y", 150.0f, -300.0f, 300.0f, 1.0f, () -> KillAura.targetHud.getBoolValue());
        this.addSettings(KillAura.sortMode, KillAura.clickMode, KillAura.rotationMode, KillAura.fov, KillAura.range, KillAura.attackCoolDown, KillAura.minAps, KillAura.maxAps, KillAura.rotPredict, KillAura.auraplayers, KillAura.auramobs, KillAura.invisiblecheck, KillAura.walls, KillAura.rayTrace, KillAura.weaponOnly, KillAura.ignoreNakedPlayer, KillAura.stopSprint, KillAura.onlyCrits, KillAura.BetterCrits, KillAura.critFallDistance, KillAura.strafeMode, KillAura.rotationStrafeMode, KillAura.teamCheck, KillAura.doubleTap, KillAura.shieldBreak, KillAura.breakerDelay, KillAura.autoShieldUnPress, KillAura.shieldFix, KillAura.shieldBypass, KillAura.shieldDesync, KillAura.autoJump, KillAura.autoBlock, KillAura.targetHud, KillAura.targetHudMode, KillAura.thudX, KillAura.thudY);
    }
    
    @EventTarget
    public void onShieldBreaker(final EventPreMotionUpdate lllllllllllllllIlIlIIlIIIIlIIIII) {
        final boolean lllllllllllllllIlIlIIlIIIIIlllll = false;
        final int lllllllllllllllIlIlIIlIIIIIllllI = InventoryHelper.getAxe();
        if (KillAura.target == null) {
            return;
        }
        if (InventoryHelper.doesHotbarHaveAxe() && KillAura.shieldBreak.getBoolValue() && (KillAura.target.getHeldItemOffhand().getItem() instanceof ItemShield || KillAura.target.getHeldItemMainhand().getItem() instanceof ItemShield) && KillAura.target.isBlocking() && KillAura.mc.player.getDistanceToEntity(KillAura.target) < KillAura.range.getNumberValue() && KillAura.timerHelper.hasReached(KillAura.breakerDelay.getNumberValue() * 10.0f) && RotationHelper.isAimAtMe(KillAura.target, 65.0f)) {
            KillAura.mc.player.connection.sendPacket(new CPacketHeldItemChange(lllllllllllllllIlIlIIlIIIIIllllI));
            this.attackEntitySuccess(KillAura.target);
            KillAura.mc.player.connection.sendPacket(new CPacketHeldItemChange(KillAura.mc.player.inventory.currentItem));
            KillAura.timerHelper.reset();
        }
    }
    
    @EventTarget
    public void onSendPacket(final EventSendPacket lllllllllllllllIlIlIIlIIIllIIIIl) {
        if (lllllllllllllllIlIlIIlIIIllIIIIl.getPacket() instanceof CPacketUseEntity) {
            final CPacketUseEntity lllllllllllllllIlIlIIlIIIllIIIII = (CPacketUseEntity)lllllllllllllllIlIlIIlIIIllIIIIl.getPacket();
            if (lllllllllllllllIlIlIIlIIIllIIIII.getAction() == CPacketUseEntity.Action.INTERACT) {
                lllllllllllllllIlIlIIlIIIllIIIIl.setCancelled(true);
            }
            if (lllllllllllllllIlIlIIlIIIllIIIII.getAction() == CPacketUseEntity.Action.INTERACT_AT) {
                lllllllllllllllIlIlIIlIIIllIIIIl.setCancelled(true);
            }
        }
    }
    
    @EventTarget
    public void onEventPreMotion(final EventPreMotionUpdate lllllllllllllllIlIlIIlIIIlIllIIl) {
        if (this.isToggled()) {
            this.setModuleName("KillAura " + ChatFormatting.GRAY + KillAura.rotationMode.getOptions());
            if (Minecraft.getMinecraft().player.isEntityAlive()) {
                KillAura.target = KillAuraHelper.getSortEntities();
                if (KillAura.target == null) {
                    return;
                }
                if (KillAura.target.getHealth() > 0.0f) {
                    if (!MovementHelper.isBlockAboveHead()) {
                        if (Minecraft.getMinecraft().player.fallDistance < KillAura.critFallDistance.getNumberValue() && !Util.checkcrit() && KillAura.onlyCrits.getBoolValue()) {
                            return;
                        }
                    }
                    else if (Minecraft.getMinecraft().player.fallDistance != 0.0f && !Util.checkcrit() && KillAura.onlyCrits.getBoolValue()) {
                        return;
                    }
                    if (!RotationHelper.isLookingAtEntity(this.yaw, this.pitch, 0.14f, 0.14f, 0.14f, KillAura.target, KillAura.range.getNumberValue()) && KillAura.rayTrace.getBoolValue()) {
                        return;
                    }
                    this.attackEntitySuccess(KillAura.target);
                }
            }
        }
    }
    
    @EventTarget
    public void e(final Event2D lllllllllllllllIlIlIIIlllllIIIIl) {
        if (this.isToggled()) {
            final ScaledResolution lllllllllllllllIlIlIIIlllllIIIII = new ScaledResolution(KillAura.mc);
            final String lllllllllllllllIlIlIIIllllIlllll = KillAura.targetHudMode.getOptions();
            if (KillAura.target != null && lllllllllllllllIlIlIIIllllIlllll.equalsIgnoreCase("Beach")) {
                if (KillAura.targetHud.getBoolValue() && KillAura.target instanceof EntityPlayer) {
                    final float lllllllllllllllIlIlIIIllllIllllI = (float)TargetHudComponent.x;
                    final float lllllllllllllllIlIlIIIllllIlllIl = (float)TargetHudComponent.y;
                    final int lllllllllllllllIlIlIIIllllIlllII = 15;
                    final double lllllllllllllllIlIlIIIllllIllIll = KillAura.target.getHealth() / KillAura.target.getMaxHealth() * 78.0f;
                    KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllllllIlIlIIIllllIllIll, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                    DrawHelper.drawNewRect(lllllllllllllllIlIlIIIllllIllllI + 122.0f, lllllllllllllllIlIlIIIllllIlllIl - 14.0f, lllllllllllllllIlIlIIIllllIllllI + 250.0f, lllllllllllllllIlIlIIIllllIlllIl + 25.0f, new Color(lllllllllllllllIlIlIIIllllIlllII, lllllllllllllllIlIlIIIllllIlllII, lllllllllllllllIlIlIIIllllIlllII, 0).getRGB());
                    DrawHelper.drawGlowRoundedRect(lllllllllllllllIlIlIIIllllIllllI + 122.0f, lllllllllllllllIlIlIIIllllIlllIl - 14.0f, lllllllllllllllIlIlIIIllllIllllI + 250.0f, lllllllllllllllIlIlIIIllllIlllIl + 25.0f, new Color(lllllllllllllllIlIlIIIllllIlllII, lllllllllllllllIlIlIIIllllIlllII, lllllllllllllllIlIlIIIllllIlllII, 150).getRGB(), 8.0f, 10.0f);
                    Util.drawHead1(Objects.requireNonNull(KillAura.mc.getConnection()).getPlayerInfo(KillAura.target.getUniqueID()).getLocationSkin(), (int)lllllllllllllllIlIlIIIllllIllllI + 129, (int)(lllllllllllllllIlIlIIIllllIlllIl - 4.0f));
                    Gui.drawRect(lllllllllllllllIlIlIIIllllIllllI + 160.0f, lllllllllllllllIlIlIIIllllIlllIl + 13.0f, lllllllllllllllIlIlIIIllllIllllI + 160.0f + KillAura.healthBarWidth, lllllllllllllllIlIlIIIllllIlllIl + 18.0f, ClientHelper.getClientColor().getRGB());
                    KillAura.mc.neverlose500_13.drawStringWithShadow("Hp: " + (int)KillAura.target.getHealth() / 2.0f + " | Ground: " + (KillAura.target.onGround ? "true" : "false"), lllllllllllllllIlIlIIIllllIllllI + 121.0f + 46.0f - KillAura.mc.neverlose500_16.getStringWidth(String.valueOf((int)KillAura.target.getHealth() / 2.0f)) / 2.0f, lllllllllllllllIlIlIIIllllIlllIl + 6.0f, -1);
                    KillAura.mc.neverlose500_18.drawStringWithShadow(KillAura.target.getName(), lllllllllllllllIlIlIIIllllIllllI + 158.0f, lllllllllllllllIlIlIIIllllIlllIl - 5.0f, -1);
                    KillAura.mc.getRenderItem().renderItemOverlays(KillAura.mc.neverlose500_18, KillAura.target.getHeldItem(EnumHand.OFF_HAND), (int)lllllllllllllllIlIlIIIllllIllllI + 228, (int)lllllllllllllllIlIlIIIllllIlllIl - 35);
                    KillAura.mc.getRenderItem().renderItemIntoGUI(KillAura.target.getHeldItem(EnumHand.OFF_HAND), (float)((int)lllllllllllllllIlIlIIIllllIllllI + 228), (float)((int)lllllllllllllllIlIlIIIllllIlllIl - 35));
                }
                else {
                    KillAura.healthBarWidth = 92.0;
                    KillAura.hudHeight = 0.0;
                    KillAura.target = null;
                }
            }
            if (KillAura.target != null && lllllllllllllllIlIlIIIllllIlllll.equalsIgnoreCase("Akrien")) {
                if (KillAura.targetHud.getBoolValue() && KillAura.target instanceof EntityPlayer) {
                    final float lllllllllllllllIlIlIIIllllIllIlI = (float)TargetHudComponent.x;
                    final float lllllllllllllllIlIlIIIllllIllIIl = (float)TargetHudComponent.y;
                    final int lllllllllllllllIlIlIIIllllIllIII = 15;
                    final double lllllllllllllllIlIlIIIllllIlIlll = KillAura.target.getHealth() / KillAura.target.getMaxHealth() * 78.0f;
                    KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllllllIlIlIIIllllIlIlll, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                    DrawHelper.drawGlowRoundedRect(lllllllllllllllIlIlIIIllllIllIlI + 122.0f, lllllllllllllllIlIlIIIllllIllIIl - 14.0f, lllllllllllllllIlIlIIIllllIllIlI + 250.0f, lllllllllllllllIlIlIIIllllIllIIl + 25.0f, new Color(lllllllllllllllIlIlIIIllllIllIII, lllllllllllllllIlIlIIIllllIllIII, lllllllllllllllIlIlIIIllllIllIII, 150).getRGB(), 8.0f, 10.0f);
                    Util.drawHead1(Objects.requireNonNull(KillAura.mc.getConnection()).getPlayerInfo(KillAura.target.getUniqueID()).getLocationSkin(), (int)lllllllllllllllIlIlIIIllllIllIlI + 129, (int)(lllllllllllllllIlIlIIIllllIllIIl - 4.0f));
                    Gui.drawRect(lllllllllllllllIlIlIIIllllIllIlI + 160.0f, lllllllllllllllIlIlIIIllllIllIIl + 13.0f, lllllllllllllllIlIlIIIllllIllIlI + 160.0f + KillAura.healthBarWidth, lllllllllllllllIlIlIIIllllIllIIl + 18.0f, ClientHelper.getClientColor().getRGB());
                    KillAura.mc.neverlose500_13.drawStringWithShadow("Hp: " + (int)KillAura.target.getHealth() / 2.0f + " | Ground: " + (KillAura.target.onGround ? "true" : "false"), lllllllllllllllIlIlIIIllllIllIlI + 121.0f + 46.0f - KillAura.mc.neverlose500_16.getStringWidth(String.valueOf((int)KillAura.target.getHealth() / 2.0f)) / 2.0f, lllllllllllllllIlIlIIIllllIllIIl + 6.0f, -1);
                    KillAura.mc.neverlose500_18.drawStringWithShadow(KillAura.target.getName(), lllllllllllllllIlIlIIIllllIllIlI + 158.0f, lllllllllllllllIlIlIIIllllIllIIl - 5.0f, -1);
                    KillAura.mc.getRenderItem().renderItemOverlays(KillAura.mc.neverlose500_18, KillAura.target.getHeldItem(EnumHand.OFF_HAND), (int)lllllllllllllllIlIlIIIllllIllIlI + 228, (int)lllllllllllllllIlIlIIIllllIllIIl - 35);
                    KillAura.mc.getRenderItem().renderItemIntoGUI(KillAura.target.getHeldItem(EnumHand.OFF_HAND), (float)((int)lllllllllllllllIlIlIIIllllIllIlI + 228), (float)((int)lllllllllllllllIlIlIIIllllIllIIl - 35));
                }
                else {
                    KillAura.healthBarWidth = 92.0;
                    KillAura.hudHeight = 0.0;
                    KillAura.target = null;
                }
            }
            if (KillAura.target != null && lllllllllllllllIlIlIIIllllIlllll.equalsIgnoreCase("Rockstar")) {
                if (KillAura.targetHud.getBoolValue() && KillAura.target instanceof EntityPlayer) {
                    final float lllllllllllllllIlIlIIIllllIlIllI = (float)TargetHudComponent.x;
                    final float lllllllllllllllIlIlIIIllllIlIlIl = (float)TargetHudComponent.y;
                    final int lllllllllllllllIlIlIIIllllIlIlII = 15;
                    final double lllllllllllllllIlIlIIIllllIlIIll = KillAura.target.getHealth() / KillAura.target.getMaxHealth() * 78.0f;
                    KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllllllIlIlIIIllllIlIIll, KillAura.healthBarWidth, 3.0 * Feature.deltaTime());
                    DrawHelper.drawNewRect(lllllllllllllllIlIlIIIllllIlIllI + 122.0f, lllllllllllllllIlIlIIIllllIlIlIl - 14.0f, lllllllllllllllIlIlIIIllllIlIllI + 250.0f, lllllllllllllllIlIlIIIllllIlIlIl + 25.0f, new Color(lllllllllllllllIlIlIIIllllIlIlII, lllllllllllllllIlIlIIIllllIlIlII, lllllllllllllllIlIlIIIllllIlIlII, 0).getRGB());
                    DrawHelper.drawNewRect(lllllllllllllllIlIlIIIllllIlIllI + 122.0f, lllllllllllllllIlIlIIIllllIlIlIl - 13.5f, lllllllllllllllIlIlIIIllllIlIllI + 250.0f, lllllllllllllllIlIlIIIllllIlIlIl + 24.5f, new Color(0, 0, 0, 150).getRGB());
                    DrawHelper.drawGradientRect(lllllllllllllllIlIlIIIllllIlIllI + 120.0f, lllllllllllllllIlIlIIIllllIlIlIl - 14.0f, lllllllllllllllIlIlIIIllllIlIllI + 122.0f, lllllllllllllllIlIlIIIllllIlIlIl + 25.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                    DrawHelper.drawGradientRect(lllllllllllllllIlIlIIIllllIlIllI + 250.0f, lllllllllllllllIlIlIIIllllIlIlIl - 14.0f, lllllllllllllllIlIlIIIllllIlIllI + 252.0f, lllllllllllllllIlIlIIIllllIlIlIl + 25.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                    Util.drawHead2(Objects.requireNonNull(KillAura.mc.getConnection()).getPlayerInfo(KillAura.target.getUniqueID()).getLocationSkin(), (int)lllllllllllllllIlIlIIIllllIlIllI + 216, (int)(lllllllllllllllIlIlIIIllllIlIlIl - 9.0f));
                    KillAura.mc.mntsb.drawStringWithShadow("Hp: " + (int)KillAura.target.getHealth() + " | Distance: " + (int)KillAura.mc.player.getDistanceToEntity(KillAura.target), lllllllllllllllIlIlIIIllllIlIllI + 101.0f + 35.0f - KillAura.mc.neverlose500_16.getStringWidth(String.valueOf((int)KillAura.target.getHealth() / 2.0f)) / 2.0f, lllllllllllllllIlIlIIIllllIlIlIl + 4.0f, -1);
                    KillAura.mc.mntsb.drawStringWithShadow(KillAura.target.getName(), lllllllllllllllIlIlIIIllllIlIllI + 128.0f, lllllllllllllllIlIlIIIllllIlIlIl - 7.0f, -1);
                    KillAura.mc.getRenderItem().renderItemOverlays(KillAura.mc.neverlose500_18, KillAura.target.getHeldItem(EnumHand.OFF_HAND), (int)lllllllllllllllIlIlIIIllllIlIllI + 228, (int)lllllllllllllllIlIlIIIllllIlIlIl - 35);
                    KillAura.mc.getRenderItem().renderItemIntoGUI(KillAura.target.getHeldItem(EnumHand.OFF_HAND), (float)((int)lllllllllllllllIlIlIIIllllIlIllI + 228), (float)((int)lllllllllllllllIlIlIIIllllIlIlIl - 35));
                    DrawHelper.drawGradientRect1(lllllllllllllllIlIlIIIllllIlIllI + 160.0f - 32.0f, lllllllllllllllIlIlIIIllllIlIlIl + 13.0f, lllllllllllllllIlIlIIIllllIlIllI + 160.0f + KillAura.healthBarWidth - 32.0, lllllllllllllllIlIlIIIllllIlIlIl + 20.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                }
                else {
                    KillAura.healthBarWidth = 92.0;
                    KillAura.hudHeight = 0.0;
                    KillAura.target = null;
                }
            }
            if (KillAura.target != null && lllllllllllllllIlIlIIIllllIlllll.equalsIgnoreCase("Nursultan")) {
                if (KillAura.targetHud.getBoolValue() && KillAura.target instanceof EntityPlayer) {
                    final float lllllllllllllllIlIlIIIllllIlIIlI = (float)TargetHudComponent.x;
                    final float lllllllllllllllIlIlIIIllllIlIIIl = (float)TargetHudComponent.y;
                    final int lllllllllllllllIlIlIIIllllIlIIII = 15;
                    final double lllllllllllllllIlIlIIIllllIIllll = KillAura.target.getHealth() / KillAura.target.getMaxHealth() * 78.0f;
                    KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllllllIlIlIIIllllIIllll, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                    DrawHelper.drawNewRect(lllllllllllllllIlIlIIIllllIlIIlI + 122.0f, lllllllllllllllIlIlIIIllllIlIIIl - 14.0f, lllllllllllllllIlIlIIIllllIlIIlI + 250.0f, lllllllllllllllIlIlIIIllllIlIIIl + 25.0f, new Color(lllllllllllllllIlIlIIIllllIlIIII, lllllllllllllllIlIlIIIllllIlIIII, lllllllllllllllIlIlIIIllllIlIIII, 0).getRGB());
                    DrawHelper.drawGlowRoundedRect(lllllllllllllllIlIlIIIllllIlIIlI + 122.0f, lllllllllllllllIlIlIIIllllIlIIIl - 14.0f, lllllllllllllllIlIlIIIllllIlIIlI + 260.0f, lllllllllllllllIlIlIIIllllIlIIIl + 40.0f, new Color(lllllllllllllllIlIlIIIllllIlIIII, lllllllllllllllIlIlIIIllllIlIIII, lllllllllllllllIlIlIIIllllIlIIII, 150).getRGB(), 8.0f, 10.0f);
                    Util.drawHead2(Objects.requireNonNull(KillAura.mc.getConnection()).getPlayerInfo(KillAura.target.getUniqueID()).getLocationSkin(), (int)lllllllllllllllIlIlIIIllllIlIIlI + 128, (int)(lllllllllllllllIlIlIIIllllIlIIIl - 8.0f));
                    DrawHelper.drawGradientRect1(lllllllllllllllIlIlIIIllllIlIIlI + 160.0f - 32.0f, lllllllllllllllIlIlIIIllllIlIIIl + 13.0f + 12.0f, (float)(lllllllllllllllIlIlIIIllllIlIIlI + 160.0f - 32.0f + KillAura.healthBarWidth * 1.4299999475479126), lllllllllllllllIlIlIIIllllIlIIIl + 18.0f + 14.5f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                    KillAura.mc.neverlose500_14.drawStringWithShadow(new StringBuilder().append((int)KillAura.target.getHealth() / 2.0f).toString(), lllllllllllllllIlIlIIIllllIlIIlI + 160.0f - 32.0f + KillAura.healthBarWidth * 1.4299999475479126 + 1.0, lllllllllllllllIlIlIIIllllIlIIIl + 27.5f, -1);
                    KillAura.mc.neverlose500_18.drawStringWithShadow(KillAura.target.getName(), lllllllllllllllIlIlIIIllllIlIIlI + 160.0f, lllllllllllllllIlIlIIIllllIlIIIl + 0.0f, -1);
                    KillAura.mc.neverlose500_18.drawStringWithShadow("Distance:" + (int)KillAura.mc.player.getDistanceToEntity(KillAura.target), lllllllllllllllIlIlIIIllllIlIIlI + 160.0f, lllllllllllllllIlIlIIIllllIlIIIl + 9.0f, -1);
                    KillAura.mc.getRenderItem().renderItemOverlays(KillAura.mc.neverlose500_18, KillAura.target.getHeldItem(EnumHand.OFF_HAND), (int)lllllllllllllllIlIlIIIllllIlIIlI + 228, (int)lllllllllllllllIlIlIIIllllIlIIIl - 35);
                    KillAura.mc.getRenderItem().renderItemIntoGUI(KillAura.target.getHeldItem(EnumHand.OFF_HAND), (float)((int)lllllllllllllllIlIlIIIllllIlIIlI + 228), (float)((int)lllllllllllllllIlIlIIIllllIlIIIl - 35));
                }
                else {
                    KillAura.healthBarWidth = 92.0;
                    KillAura.hudHeight = 0.0;
                    KillAura.target = null;
                }
            }
            if (lllllllllllllllIlIlIIIllllIlllll.equalsIgnoreCase("Astolfo") && this.isToggled() && KillAura.target != null && KillAura.target instanceof EntityPlayer && KillAura.targetHud.getBoolValue()) {
                final float lllllllllllllllIlIlIIIllllIIlllI = (float)lllllllllllllllIlIlIIIlllllIIIII.getScaledWidth();
                final float lllllllllllllllIlIlIIIllllIIllIl = (float)lllllllllllllllIlIlIIIlllllIIIII.getScaledHeight();
                final float lllllllllllllllIlIlIIIllllIIllII = (float)TargetHudComponent.x;
                final float lllllllllllllllIlIlIIIllllIIlIll = (float)TargetHudComponent.y;
                double lllllllllllllllIlIlIIIllllIIlIlI = KillAura.target.getHealth() / KillAura.target.getMaxHealth() * 120.0f;
                lllllllllllllllIlIlIIIllllIIlIlI = MathHelper.clamp(lllllllllllllllIlIlIIIllllIIlIlI, 0.0, 120.0);
                final double lllllllllllllllIlIlIIIllllIIlIIl = (KillAura.target != null && KillAura.target.getHealth() < ((KillAura.target instanceof EntityPlayer) ? 18 : 10) && KillAura.target.getHealth() > 1.0f) ? 8 : 0;
                KillAura.healthBarWidth = MathHelper.lerp((float)lllllllllllllllIlIlIIIllllIIlIlI, (float)KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                DrawHelper.drawGlowRoundedRect(lllllllllllllllIlIlIIIllllIIllII, lllllllllllllllIlIlIIIllllIIlIll, lllllllllllllllIlIlIIIllllIIllII + 155.0f, lllllllllllllllIlIlIIIllllIIlIll + 62.0f, new Color(20, 20, 20, 255).getRGB(), 6.0f, 5.0f);
                if (!KillAura.target.getName().isEmpty()) {
                    Minecraft.fontRendererObj.drawStringWithShadow(Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() ? "Protected" : KillAura.target.getName(), lllllllllllllllIlIlIIIllllIIllII + 31.0f, lllllllllllllllIlIlIIIllllIIlIll + 5.0f, -1);
                }
                GlStateManager.pushMatrix();
                GlStateManager.translate(lllllllllllllllIlIlIIIllllIIllII, lllllllllllllllIlIlIIIllllIIlIll, 1.0f);
                GL11.glScalef(2.5f, 2.5f, 2.5f);
                GlStateManager.translate(-lllllllllllllllIlIlIIIllllIIllII - 3.0f, -lllllllllllllllIlIlIIIllllIIlIll - 2.0f, 1.0f);
                Minecraft.fontRendererObj.drawStringWithShadow(ru.rockstar.api.utils.math.MathHelper.round(KillAura.target.getHealth() / 2.0f, 1) + " \u2764", lllllllllllllllIlIlIIIllllIIllII + 16.0f, lllllllllllllllIlIlIIIllllIIlIll + 10.0f, new Color(ClientHelper.getClientColor().getRGB()).getRGB());
                GlStateManager.popMatrix();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                KillAura.mc.getRenderItem().renderItemOverlays(Minecraft.fontRendererObj, KillAura.target.getHeldItem(EnumHand.OFF_HAND), (int)lllllllllllllllIlIlIIIllllIIllII + 137, (int)lllllllllllllllIlIlIIIllllIIlIll + 7);
                KillAura.mc.getRenderItem().renderItemIntoGUI(KillAura.target.getHeldItem(EnumHand.OFF_HAND), (float)((int)lllllllllllllllIlIlIIIllllIIllII + 137), (float)((int)lllllllllllllllIlIlIIIllllIIlIll + 1));
                GuiInventory.drawEntityOnScreen((int)lllllllllllllllIlIlIIIllllIIllII + 16, (int)lllllllllllllllIlIlIIIllllIIlIll + 55, 25, KillAura.target.rotationYaw, -KillAura.target.rotationPitch, KillAura.target);
                DrawHelper.drawRect2(lllllllllllllllIlIlIIIllllIIllII + 30.0f, lllllllllllllllIlIlIIIllllIIlIll + 48.0f, 120.0, 8.0, new Color(ClientHelper.getClientColor().getRGB()).darker().darker().darker().getRGB());
                DrawHelper.drawRect2(lllllllllllllllIlIlIIIllllIIllII + 30.0f, lllllllllllllllIlIlIIIllllIIlIll + 48.0f, KillAura.healthBarWidth + lllllllllllllllIlIlIIIllllIIlIIl, 8.0, new Color(ClientHelper.getClientColor().getRGB()).darker().darker().getRGB());
                DrawHelper.drawRect2(lllllllllllllllIlIlIIIllllIIllII + 30.0f, lllllllllllllllIlIlIIIllllIIlIll + 48.0f, lllllllllllllllIlIlIIIllllIIlIlI, 8.0, new Color(ClientHelper.getClientColor().getRGB()).getRGB());
            }
            if (lllllllllllllllIlIlIIIllllIlllll.equalsIgnoreCase("Celestial Premium") && KillAura.target != null) {
                if (KillAura.targetHud.getBoolValue() && KillAura.target instanceof EntityPlayer) {
                    final ScaledResolution lllllllllllllllIlIlIIIllllIIlIII = new ScaledResolution(KillAura.mc);
                    final float lllllllllllllllIlIlIIIllllIIIlll = (float)lllllllllllllllIlIlIIIllllIIlIII.getScaledWidth();
                    final float lllllllllllllllIlIlIIIllllIIIllI = (float)lllllllllllllllIlIlIIIllllIIlIII.getScaledHeight();
                    final float lllllllllllllllIlIlIIIllllIIIlIl = (float)TargetHudComponent.x;
                    final float lllllllllllllllIlIlIIIllllIIIlII = (float)TargetHudComponent.y;
                    final float lllllllllllllllIlIlIIIllllIIIIll = KillAura.target.getHealth();
                    double lllllllllllllllIlIlIIIllllIIIIlI = lllllllllllllllIlIlIIIllllIIIIll / KillAura.target.getMaxHealth();
                    lllllllllllllllIlIlIIIllllIIIIlI = MathHelper.clamp(lllllllllllllllIlIlIIIllllIIIIlI, 0.0, 1.0);
                    final double lllllllllllllllIlIlIIIllllIIIIIl = 110.0 * lllllllllllllllIlIlIIIllllIIIIlI;
                    final String lllllllllllllllIlIlIIIllllIIIIII = String.valueOf((int)KillAura.target.getHealth() / 2.0f);
                    KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllllllIlIlIIIllllIIIIIl, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                    KillAura.hudHeight = AnimationHelper.animate(40.0, KillAura.hudHeight, 5.0 * Feature.deltaTime());
                    DrawHelper.drawNewRect(lllllllllllllllIlIlIIIllllIIIlIl + 125.0f, lllllllllllllllIlIlIIIllllIIIlII - 19.0f, lllllllllllllllIlIlIIIllllIIIlIl + 275.0f, lllllllllllllllIlIlIIIllllIIIlII + 29.0f, new Color(32, 31, 32, 150).getRGB());
                    DrawHelper.drawGlowRoundedRect(lllllllllllllllIlIlIIIllllIIIlIl + 120.0f, lllllllllllllllIlIlIIIllllIIIlII - 26.0f, lllllllllllllllIlIlIIIllllIIIlIl + 280.0f, lllllllllllllllIlIlIIIllllIIIlII + 35.0f, new Color(32, 31, 32, 150).getRGB(), 15.0f, 10.0f);
                    DrawHelper.drawGlowRoundedRect((float)(lllllllllllllllIlIlIIIllllIIIlIl + 127.5), (float)(lllllllllllllllIlIlIIIllllIIIlII - 11.5), lllllllllllllllIlIlIIIllllIIIlIl + 273.0f, lllllllllllllllIlIlIIIllllIIIlII - 11.0f, new Color(140, 140, 140).getRGB(), 6.0f, 10.0f);
                    DrawHelper.drawGlowRoundedRect(lllllllllllllllIlIlIIIllllIIIlIl + 162.0f, lllllllllllllllIlIlIIIllllIIIlII + 18.0f, (float)(lllllllllllllllIlIlIIIllllIIIlIl + 162.0f + KillAura.healthBarWidth), lllllllllllllllIlIlIIIllllIIIlII + 20.0f, new Color(ClientHelper.getClientColor().getRed() / 255.0f, ClientHelper.getClientColor().getGreen() / 255.0f, ClientHelper.getClientColor().getBlue() / 255.0f, 0.4509804f).getRGB(), 6.0f, 25.0f);
                    DrawHelper.drawGlowRoundedRect(lllllllllllllllIlIlIIIllllIIIlIl + 162.0f, lllllllllllllllIlIlIIIllllIIIlII + 18.0f, (float)(lllllllllllllllIlIlIIIllllIIIlIl + 162.0f + lllllllllllllllIlIlIIIllllIIIIIl), lllllllllllllllIlIlIIIllllIIIlII + 20.0f, ClientHelper.getClientColor().getRGB(), 6.0f, 25.0f);
                    KillAura.mc.sfui16.drawStringWithShadow("Ground: " + (KillAura.target.onGround ? "true;" : "false;"), lllllllllllllllIlIlIIIllllIIIlIl + 162.0f, lllllllllllllllIlIlIIIllllIIIlII - 3.0f, -1);
                    KillAura.mc.sfui16.drawStringWithShadow("HurtTime", lllllllllllllllIlIlIIIllllIIIlIl + 162.5f, lllllllllllllllIlIlIIIllllIIIlII + 7.0f, -1);
                    KillAura.mc.neverlose500_13.drawCenteredString(KillAura.target.getName(), (float)(lllllllllllllllIlIlIIIllllIIIlIl + 199.2753623188406), (float)(lllllllllllllllIlIlIIIllllIIIlII - 16.7), -1);
                    final double lllllllllllllllIlIlIIIlllIllllll = MathHelper.clamp(KillAura.target.hurtTime, 1.0, 0.3);
                    final double lllllllllllllllIlIlIIIlllIlllllI = 71.0 * lllllllllllllllIlIlIIIlllIllllll;
                    KillAura.hurttimeBarWidth = AnimationHelper.animate(lllllllllllllllIlIlIIIlllIlllllI, KillAura.hurttimeBarWidth, 0.0529999852180481);
                    DrawHelper.drawGlowRoundedRect(lllllllllllllllIlIlIIIllllIIIlIl + 201.0f, lllllllllllllllIlIlIIIllllIIIlII + 9.0f, lllllllllllllllIlIlIIIllllIIIlIl + 272.0f, lllllllllllllllIlIlIIIllllIIIlII + 11.0f, new Color(40, 40, 40).getRGB(), 2.0f, 10.0f);
                    DrawHelper.drawGlowRoundedRect(lllllllllllllllIlIlIIIllllIIIlIl + 201.0f, lllllllllllllllIlIlIIIllllIIIlII + 9.0f, (float)(lllllllllllllllIlIlIIIllllIIIlIl + 201.0f + KillAura.hurttimeBarWidth), lllllllllllllllIlIlIIIllllIIIlII + 11.0f, ClientHelper.getClientColor().getRGB(), 2.0f, 4.0f);
                    KillAura.mc.getRenderItem().renderItemOverlays(Minecraft.fontRendererObj, KillAura.target.getHeldItem(EnumHand.OFF_HAND), (int)lllllllllllllllIlIlIIIllllIIIlIl + 255, (int)lllllllllllllllIlIlIIIllllIIIlII - 5);
                    KillAura.mc.getRenderItem().renderItemIntoGUI(KillAura.target.getHeldItem(EnumHand.OFF_HAND), (float)((int)lllllllllllllllIlIlIIIllllIIIlIl + 259), (float)((int)lllllllllllllllIlIlIIIllllIIIlII - 10));
                    DrawHelper.drawGlowRoundedRect((float)(lllllllllllllllIlIlIIIllllIIIlIl + 125.5), lllllllllllllllIlIlIIIllllIIIlII - 20.5f, lllllllllllllllIlIlIIIllllIIIlIl + 275.0f, lllllllllllllllIlIlIIIllllIIIlII - 18.0f, ClientHelper.getClientColor().getRGB(), 4.0f, 6.0f);
                    Util.drawHead3(Objects.requireNonNull(KillAura.mc.getConnection()).getPlayerInfo(KillAura.target.getUniqueID()).getLocationSkin(), (int)lllllllllllllllIlIlIIIllllIIIlIl + 127 + KillAura.target.hurtTime / 2, (int)(lllllllllllllllIlIlIIIllllIIIlII - 8.0f) + KillAura.target.hurtTime / 2, 32 - KillAura.target.hurtTime, 32 - KillAura.target.hurtTime);
                }
                else {
                    KillAura.healthBarWidth = 92.0;
                    KillAura.hudHeight = 0.0;
                }
            }
            if (lllllllllllllllIlIlIIIllllIlllll.equalsIgnoreCase("Red-Blue")) {
                if (KillAura.mc.gameSettings.ofFastRender) {
                    KillAura.mc.gameSettings.ofFastRender = false;
                }
                final ScaledResolution lllllllllllllllIlIlIIIlllIllllIl = new ScaledResolution(KillAura.mc);
                final float lllllllllllllllIlIlIIIlllIllllII = (float)lllllllllllllllIlIlIIIlllIllllIl.getScaledWidth();
                final float lllllllllllllllIlIlIIIlllIlllIll = (float)lllllllllllllllIlIlIIIlllIllllIl.getScaledHeight();
                final float lllllllllllllllIlIlIIIlllIlllIlI = (float)TargetHudComponent.x;
                final float lllllllllllllllIlIlIIIlllIlllIIl = (float)TargetHudComponent.y;
                final double lllllllllllllllIlIlIIIlllIlllIII = KillAura.target.getTotalArmorValue() * 4.8f;
                double lllllllllllllllIlIlIIIlllIllIlll = KillAura.target.getHealth() / KillAura.target.getMaxHealth() * 96.0f;
                lllllllllllllllIlIlIIIlllIllIlll = MathHelper.clamp(lllllllllllllllIlIlIIIlllIllIlll, 0.0, 96.0);
                KillAura.healthBarWidth = MathHelper.clamp(KillAura.healthBarWidth, 0.0, 104.0);
                final float lllllllllllllllIlIlIIIlllIllIllI = lllllllllllllllIlIlIIIlllIlllIlI;
                final float lllllllllllllllIlIlIIIlllIllIlIl = lllllllllllllllIlIlIIIlllIlllIIl;
                final float lllllllllllllllIlIlIIIlllIllIlII = lllllllllllllllIlIlIIIlllIllIllI + 48.0f + 120.0f;
                GlStateManager.pushMatrix();
                GlStateManager.disableBlend();
                DrawHelper.blurAreaBoarder((float)(int)lllllllllllllllIlIlIIIlllIlllIlI, (float)(int)lllllllllllllllIlIlIIIlllIlllIIl, 148.0f, 45.0f, 120.0f, 0.0f, 1.0f);
                DrawHelper.drawRect(lllllllllllllllIlIlIIIlllIlllIlI - 1.0f, lllllllllllllllIlIlIIIlllIlllIIl - 0.5f, lllllllllllllllIlIlIIIlllIllIlII - 168.0f, lllllllllllllllIlIlIIIlllIlllIIl + 45.0f, new Color(205, 205, 205).getRGB());
                if (KillAura.target instanceof EntityPlayer) {
                    KillAura.mc.robotoRegular.drawStringWithShadow(KillAura.target.getName(), lllllllllllllllIlIlIIIlllIlllIlI + 8.0f, lllllllllllllllIlIlIIIlllIlllIIl + 5.0f, -1);
                }
                DrawHelper.renderItem(KillAura.target.getHeldItem(EnumHand.OFF_HAND), (int)lllllllllllllllIlIlIIIlllIlllIlI + 133, (int)lllllllllllllllIlIlIIIlllIlllIIl - 20);
                if (Minecraft.getDebugFPS() > 5) {
                    DrawHelper.drawSmoothRectBetter(lllllllllllllllIlIlIIIlllIlllIlI + 4.0f, lllllllllllllllIlIlIIIlllIlllIIl + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : KillAura.target.getName()) + 19.0f, 96.0f, 5.0f, new Color(35, 35, 35, 255).getRGB());
                    DrawHelper.drawSmoothRectBetter(lllllllllllllllIlIlIIIlllIlllIlI + 4.0f, lllllllllllllllIlIlIIIlllIlllIIl + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : KillAura.target.getName()) + 19.0f, (float)KillAura.healthBarWidth, 5.0f, Color.RED.getRGB());
                    DrawHelper.drawSmoothRectBetter(lllllllllllllllIlIlIIIlllIlllIlI + 4.0f, lllllllllllllllIlIlIIIlllIlllIIl + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : KillAura.target.getName()) + 28.0f, 96.0f, 5.0f, new Color(35, 35, 35, 255).getRGB());
                    if (KillAura.target.getTotalArmorValue() > 0) {
                        DrawHelper.drawSmoothRectBetter(lllllllllllllllIlIlIIIlllIlllIlI + 4.0f, lllllllllllllllIlIlIIIlllIlllIIl + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : KillAura.target.getName()) + 28.0f, (float)lllllllllllllllIlIlIIIlllIlllIII, 5.0f, new Color(55, 175, 255).getRGB());
                    }
                    KillAura.target.getTotalArmorValue();
                }
                GlStateManager.pushMatrix();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                for (final NetworkPlayerInfo lllllllllllllllIlIlIIIlllIllIIll : KillAura.mc.player.connection.getPlayerInfoMap()) {
                    if (lllllllllllllllIlIlIIIlllIllIIll == null) {
                        continue;
                    }
                    if (!(KillAura.target instanceof EntityPlayer)) {
                        continue;
                    }
                    if (KillAura.mc.world.getPlayerEntityByUUID(lllllllllllllllIlIlIIIlllIllIIll.getGameProfile().getId()) == KillAura.target) {
                        final float lllllllllllllllIlIlIIIlllIllIIlI = (KillAura.target.hurtTime - KillAura.mc.timer.renderPartialTicks) / 8.0f;
                        GlStateManager.color(1.0f, 1.0f - lllllllllllllllIlIlIIIlllIllIIlI, 1.0f - lllllllllllllllIlIlIIIlllIllIIlI, 1.0f);
                        KillAura.mc.getTextureManager().bindTexture(lllllllllllllllIlIlIIIlllIllIIll.getLocationSkin());
                        Gui.drawScaledCustomSizeModalRect((int)lllllllllllllllIlIlIIIlllIlllIlI + 104, (int)lllllllllllllllIlIlIIIlllIlllIIl, 8.0f, 8.0f, 8, 8, 44, 44, 64.0f, 64.0f);
                        GlStateManager.bindTexture(0);
                    }
                    GL11.glDisable(3089);
                }
                GlStateManager.popMatrix();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.popMatrix();
            }
        }
    }
    
    @EventTarget
    public void onStrafe(final EventStrafe lllllllllllllllIlIlIIlIIIIIIIIll) {
        if (KillAura.target != null) {
            final String lllllllllllllllIlIlIIlIIIIIIllIl = KillAura.strafeMode.getOptions();
            final String lllllllllllllllIlIlIIlIIIIIIllII = KillAura.rotationStrafeMode.getOptions();
            float lllllllllllllllIlIlIIlIIIIIIlIll = lllllllllllllllIlIlIIlIIIIIIIIll.getStrafe();
            float lllllllllllllllIlIlIIlIIIIIIlIlI = lllllllllllllllIlIlIIlIIIIIIIIll.getForward();
            final float lllllllllllllllIlIlIIlIIIIIIlIIl = lllllllllllllllIlIlIIlIIIIIIIIll.getFriction();
            if (KillAura.target.getHealth() > 0.0f && lllllllllllllllIlIlIIlIIIIIIllIl.equalsIgnoreCase("Always-F")) {
                if (lllllllllllllllIlIlIIlIIIIIIllII.equalsIgnoreCase("Silent")) {
                    lllllllllllllllIlIlIIlIIIIIIIIll.setCancelled(true);
                    MovementHelper.calculateSilentMove(lllllllllllllllIlIlIIlIIIIIIIIll, RotationHelper.Rotation.packetYaw);
                }
                else if (lllllllllllllllIlIlIIlIIIIIIllII.equalsIgnoreCase("Default")) {
                    lllllllllllllllIlIlIIlIIIIIIIIll.setCancelled(true);
                    float lllllllllllllllIlIlIIlIIIIIIlIII = lllllllllllllllIlIlIIlIIIIIIlIll * lllllllllllllllIlIlIIlIIIIIIlIll + lllllllllllllllIlIlIIlIIIIIIlIlI * lllllllllllllllIlIlIIlIIIIIIlIlI;
                    if (lllllllllllllllIlIlIIlIIIIIIlIII >= 1.0E-4f) {
                        lllllllllllllllIlIlIIlIIIIIIlIII = (float)(lllllllllllllllIlIlIIlIIIIIIlIIl / Math.max(1.0, Math.sqrt(lllllllllllllllIlIlIIlIIIIIIlIII)));
                        lllllllllllllllIlIlIIlIIIIIIlIll *= lllllllllllllllIlIlIIlIIIIIIlIII;
                        lllllllllllllllIlIlIIlIIIIIIlIlI *= lllllllllllllllIlIlIIlIIIIIIlIII;
                        final float lllllllllllllllIlIlIIlIIIIIIIlll = MathHelper.sin(RotationHelper.Rotation.packetYaw * 3.1415927f / 180.0f);
                        final float lllllllllllllllIlIlIIlIIIIIIIllI = MathHelper.cos(RotationHelper.Rotation.packetYaw * 3.1415927f / 180.0f);
                        final EntityPlayerSP player;
                        final EntityPlayerSP lllllllllllllllIlIlIIlIIIIIIIlIl = player = KillAura.mc.player;
                        player.motionX += lllllllllllllllIlIlIIlIIIIIIlIll * lllllllllllllllIlIlIIlIIIIIIIllI - lllllllllllllllIlIlIIlIIIIIIlIlI * lllllllllllllllIlIlIIlIIIIIIIlll;
                        final EntityPlayerSP player2;
                        final EntityPlayerSP lllllllllllllllIlIlIIlIIIIIIIlII = player2 = KillAura.mc.player;
                        player2.motionZ += lllllllllllllllIlIlIIlIIIIIIlIlI * lllllllllllllllIlIlIIlIIIIIIIllI + lllllllllllllllIlIlIIlIIIIIIlIll * lllllllllllllllIlIlIIlIIIIIIIlll;
                    }
                }
            }
        }
    }
    
    @EventTarget
    public void onAttackSilent(final EventAttackSilent lllllllllllllllIlIlIIlIIIlIIIIll) {
        if (KillAura.mc.player.isBlocking() && KillAura.mc.player.getHeldItemOffhand().getItem() instanceof ItemShield && KillAura.shieldFix.getBoolValue()) {
            KillAura.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(-0.8, -0.8, -0.8), EnumFacing.DOWN));
            KillAura.mc.playerController.processRightClick(KillAura.mc.player, KillAura.mc.world, EnumHand.OFF_HAND);
        }
    }
    
    @EventTarget
    public void onRotations(final EventPreMotionUpdate lllllllllllllllIlIlIIlIIIIlIllII) {
        if (this.isToggled()) {
            if (KillAura.target != null) {
                if (KillAura.target.getHealth() > 0.0f) {
                    final String lllllllllllllllIlIlIIlIIIIllIlll = KillAura.rotationMode.getOptions();
                    final float[] lllllllllllllllIlIlIIlIIIIllIllI = RotationHelper.getRatations(KillAura.target);
                    final float[] lllllllllllllllIlIlIIlIIIIllIlIl = RotationHelper.getMatrixRotations(KillAura.target, false, 2.0f, 2.0f);
                    final float[] lllllllllllllllIlIlIIlIIIIllIlII = RotationHelper.getMatrixRotations(KillAura.target, false, 2.0f, 2.0f);
                    final float[] lllllllllllllllIlIlIIlIIIIllIIll = RotationHelper.getSunriseRotations(KillAura.target, true, 360.0f, 360.0f, 2.0f, 2.0f);
                    final float[] lllllllllllllllIlIlIIlIIIIllIIlI = RotationHelper.getAACRotation(KillAura.target, false, 360.0f, 360.0f, 3.0f, 3.0f);
                    if (lllllllllllllllIlIlIIlIIIIllIlll.equalsIgnoreCase("Matrix")) {
                        this.yaw2 = GCDFix.getFixedRotation(MathHelper.Rotate(this.yaw2, lllllllllllllllIlIlIIlIIIIllIllI[0], 0.1f, 35.0f));
                        this.pitch2 = GCDFix.getFixedRotation(MathHelper.Rotate(this.pitch2, lllllllllllllllIlIlIIlIIIIllIllI[1], 0.1f, 2.2f));
                        lllllllllllllllIlIlIIlIIIIlIllII.setYaw(this.yaw2);
                        lllllllllllllllIlIlIIlIIIIlIllII.setPitch(this.pitch2);
                        this.yaw = this.yaw2;
                        this.pitch = this.pitch2;
                        KillAura.mc.player.renderYawOffset = this.yaw2;
                        KillAura.mc.player.rotationYawHead = this.yaw2;
                        KillAura.mc.player.rotationPitchHead = this.pitch2;
                    }
                    else if (lllllllllllllllIlIlIIlIIIIllIlll.equalsIgnoreCase("Snap")) {
                        final float[] lllllllllllllllIlIlIIlIIIIllIIIl = RotationHelper.getRatations(KillAura.target);
                        lllllllllllllllIlIlIIlIIIIlIllII.setYaw(lllllllllllllllIlIlIIlIIIIllIIIl[0]);
                        this.pitch2 = GCDFix.getFixedRotation(MathHelper.lerp(this.pitch2, lllllllllllllllIlIlIIlIIIIllIIIl[1], 0.069f));
                        this.yaw = lllllllllllllllIlIlIIlIIIIllIIIl[0];
                        this.pitch = this.pitch2;
                        KillAura.mc.player.renderYawOffset = lllllllllllllllIlIlIIlIIIIllIIIl[0];
                        KillAura.mc.player.rotationYawHead = lllllllllllllllIlIlIIlIIIIllIIIl[0];
                        KillAura.mc.player.rotationPitchHead = this.pitch2;
                        lllllllllllllllIlIlIIlIIIIlIllII.setPitch(this.pitch2);
                    }
                    else if (lllllllllllllllIlIlIIlIIIIllIlll.equalsIgnoreCase("Client")) {
                        KillAura.mc.player.rotationYaw = lllllllllllllllIlIlIIlIIIIllIlII[0];
                        this.yaw = lllllllllllllllIlIlIIlIIIIllIlII[0];
                        this.pitch = lllllllllllllllIlIlIIlIIIIllIlII[1];
                        KillAura.mc.player.rotationPitch = lllllllllllllllIlIlIIlIIIIllIlII[1];
                    }
                    else if (lllllllllllllllIlIlIIlIIIIllIlll.equalsIgnoreCase("AAC")) {
                        if (KillAura.mc.player.getCooledAttackStrength(1.0f) == 1.0f) {
                            lllllllllllllllIlIlIIlIIIIlIllII.setYaw(lllllllllllllllIlIlIIlIIIIllIIlI[0]);
                            lllllllllllllllIlIlIIlIIIIlIllII.setPitch(lllllllllllllllIlIlIIlIIIIllIIlI[1]);
                            this.yaw = lllllllllllllllIlIlIIlIIIIllIIlI[0];
                            this.pitch = lllllllllllllllIlIlIIlIIIIllIIlI[1];
                            KillAura.mc.player.renderYawOffset = lllllllllllllllIlIlIIlIIIIllIIlI[0];
                            KillAura.mc.player.rotationYawHead = lllllllllllllllIlIlIIlIIIIllIIlI[0];
                            KillAura.mc.player.rotationPitchHead = lllllllllllllllIlIlIIlIIIIllIIlI[1];
                        }
                    }
                    else if (lllllllllllllllIlIlIIlIIIIllIlll.equalsIgnoreCase("MagicGrief")) {
                        lllllllllllllllIlIlIIlIIIIlIllII.setYaw(lllllllllllllllIlIlIIlIIIIllIIll[0]);
                        lllllllllllllllIlIlIIlIIIIlIllII.setPitch(lllllllllllllllIlIlIIlIIIIllIIll[1]);
                        this.yaw = lllllllllllllllIlIlIIlIIIIllIIll[0];
                        this.pitch = lllllllllllllllIlIlIIlIIIIllIIll[1];
                        KillAura.mc.player.renderYawOffset = lllllllllllllllIlIlIIlIIIIllIIll[0];
                        KillAura.mc.player.rotationYawHead = lllllllllllllllIlIlIIlIIIIllIIll[0];
                        KillAura.mc.player.rotationPitchHead = lllllllllllllllIlIlIIlIIIIllIIll[1];
                    }
                    else if (lllllllllllllllIlIlIIlIIIIllIlll.equalsIgnoreCase("ReallyWorld")) {
                        final float[] lllllllllllllllIlIlIIlIIIIllIIII = RotationHelper.getRatations(KillAura.target);
                        lllllllllllllllIlIlIIlIIIIlIllII.setYaw(lllllllllllllllIlIlIIlIIIIllIIII[0]);
                        this.pitch2 = GCDFix.getFixedRotation(MathHelper.lerp(this.pitch2, lllllllllllllllIlIlIIlIIIIllIIII[1], 0.069f));
                        this.yaw = lllllllllllllllIlIlIIlIIIIllIIII[0];
                        this.pitch = this.pitch2;
                        KillAura.mc.player.renderYawOffset = lllllllllllllllIlIlIIlIIIIllIIII[0];
                        KillAura.mc.player.rotationYawHead = lllllllllllllllIlIlIIlIIIIllIIII[0];
                        KillAura.mc.player.rotationPitchHead = this.pitch2;
                        lllllllllllllllIlIlIIlIIIIlIllII.setPitch(this.pitch2);
                    }
                    else if (lllllllllllllllIlIlIIlIIIIllIlll.equalsIgnoreCase("Legit")) {
                        if (!RotationHelper.isLookingAtEntity(this.yaw, this.pitch, 0.14f, 0.14f, 0.14f, KillAura.target, KillAura.range.getNumberValue())) {
                            KillAura.mc.player.rotationYaw = lllllllllllllllIlIlIIlIIIIllIlIl[0];
                            this.yaw = lllllllllllllllIlIlIIlIIIIllIlIl[0];
                            this.pitch = lllllllllllllllIlIlIIlIIIIllIlIl[1];
                            KillAura.mc.player.rotationPitch = lllllllllllllllIlIlIIlIIIIllIlIl[1];
                        }
                    }
                    else if (lllllllllllllllIlIlIIlIIIIllIlll.equalsIgnoreCase("SunRise")) {
                        final float[] lllllllllllllllIlIlIIlIIIIlIllll = RotationHelper.getRatations(KillAura.target);
                        lllllllllllllllIlIlIIlIIIIlIllII.setYaw(lllllllllllllllIlIlIIlIIIIlIllll[0]);
                        this.pitch2 = GCDFix.getFixedRotation(MathHelper.lerp(this.pitch2, lllllllllllllllIlIlIIlIIIIlIllll[1], 0.069f));
                        this.yaw = lllllllllllllllIlIlIIlIIIIlIllll[0];
                        this.pitch = this.pitch2;
                        KillAura.mc.player.renderYawOffset = lllllllllllllllIlIlIIlIIIIlIllll[0];
                        KillAura.mc.player.rotationYawHead = lllllllllllllllIlIlIIlIIIIlIllll[0];
                        KillAura.mc.player.rotationPitchHead = this.pitch2;
                        lllllllllllllllIlIlIIlIIIIlIllII.setPitch(this.pitch2);
                    }
                    else if (lllllllllllllllIlIlIIlIIIIllIlll.equalsIgnoreCase("StormHVH")) {
                        final float[] lllllllllllllllIlIlIIlIIIIlIlllI = RotationHelper.getRatations(KillAura.target);
                        lllllllllllllllIlIlIIlIIIIlIllII.setYaw(lllllllllllllllIlIlIIlIIIIlIlllI[0]);
                        this.pitch2 = GCDFix.getFixedRotation(MathHelper.lerp(this.pitch2, lllllllllllllllIlIlIIlIIIIlIlllI[1], 0.069f));
                        this.yaw = lllllllllllllllIlIlIIlIIIIlIlllI[0];
                        this.pitch = this.pitch2;
                        KillAura.mc.player.renderYawOffset = lllllllllllllllIlIlIIlIIIIlIlllI[0];
                        KillAura.mc.player.rotationYawHead = lllllllllllllllIlIlIIlIIIIlIlllI[0];
                        KillAura.mc.player.rotationPitchHead = this.pitch2;
                        lllllllllllllllIlIlIIlIIIIlIllII.setPitch(this.pitch2);
                        this.yaw2 = GCDFix.getFixedRotation(MathHelper.Rotate(this.yaw2, lllllllllllllllIlIlIIlIIIIllIllI[0], 0.1f, 35.0f));
                        this.pitch2 = GCDFix.getFixedRotation(MathHelper.Rotate(this.pitch2, lllllllllllllllIlIlIIlIIIIllIllI[1], 0.1f, 2.2f));
                        lllllllllllllllIlIlIIlIIIIlIllII.setYaw(this.yaw2);
                        lllllllllllllllIlIlIIlIIIIlIllII.setPitch(this.pitch2);
                        this.yaw = this.yaw2;
                        this.pitch = this.pitch2;
                        KillAura.mc.player.renderYawOffset = this.yaw2;
                        KillAura.mc.player.rotationYawHead = this.yaw2;
                        KillAura.mc.player.rotationPitchHead = this.pitch2;
                        KillAura.mc.player.rotationYaw = lllllllllllllllIlIlIIlIIIIllIlII[0];
                        this.yaw = lllllllllllllllIlIlIIlIIIIllIlII[0];
                        this.pitch = lllllllllllllllIlIlIIlIIIIllIlII[1];
                        KillAura.mc.player.rotationPitch = lllllllllllllllIlIlIIlIIIIllIlII[1];
                        KillAura.mc.player.rotationYaw = lllllllllllllllIlIlIIlIIIIllIlIl[0];
                        this.yaw = lllllllllllllllIlIlIIlIIIIllIlIl[0];
                        this.pitch = lllllllllllllllIlIlIIlIIIIllIlIl[1];
                        KillAura.mc.player.rotationPitch = lllllllllllllllIlIlIIlIIIIllIlIl[1];
                    }
                }
                else {
                    this.yaw2 = KillAura.mc.player.rotationYaw;
                    this.pitch2 = KillAura.mc.player.rotationPitch;
                }
            }
            else {
                this.yaw2 = KillAura.mc.player.rotationYaw;
                this.pitch2 = KillAura.mc.player.rotationPitch;
            }
        }
    }
    
    private void attackEntitySuccess(final EntityLivingBase lllllllllllllllIlIlIIlIIIlIlIIII) {
        if (lllllllllllllllIlIlIIlIIIlIlIIII.getHealth() > 0.0f) {
            final Exception lllllllllllllllIlIlIIlIIIlIIlIII;
            switch (lllllllllllllllIlIlIIlIIIlIIlIII = (Exception)KillAura.clickMode.getOptions()) {
                case "1.8": {
                    if (KillAuraHelper.canApsAttack()) {
                        if (this.isBlocking && KillAura.autoBlock.getBoolValue() && KillAura.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword && KillAura.timerHelper.hasReached(100.0)) {
                            KillAura.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(-1, -1, -1), EnumFacing.DOWN));
                            this.isBlocking = false;
                            KillAura.timerHelper.reset();
                        }
                        KillAura.mc.playerController.attackEntity(KillAura.mc.player, EntityHelper.rayCast(lllllllllllllllIlIlIIlIIIlIlIIII, KillAura.range.getNumberValue()));
                        KillAura.mc.player.swingArm(EnumHand.MAIN_HAND);
                        break;
                    }
                    break;
                }
                case "1.9": {
                    final float lllllllllllllllIlIlIIlIIIlIIllll = 0.5f;
                    if (KillAura.mc.player.getCooledAttackStrength(lllllllllllllllIlIlIIlIIIlIIllll) < KillAura.attackCoolDown.getNumberValue()) {
                        break;
                    }
                    final String lllllllllllllllIlIlIIlIIIlIIlllI = KillAura.rotationMode.getOptions();
                    if (lllllllllllllllIlIlIIlIIIlIIlllI.equalsIgnoreCase("Snap")) {
                        final float[] lllllllllllllllIlIlIIlIIIlIIllIl = RotationHelper.getMatrixRotations(lllllllllllllllIlIlIIlIIIlIlIIII, false, 2.0f, 2.0f);
                        KillAura.mc.player.rotationYaw = lllllllllllllllIlIlIIlIIIlIIllIl[0];
                        this.yaw = lllllllllllllllIlIlIIlIIIlIIllIl[0];
                        this.pitch = lllllllllllllllIlIlIIlIIIlIIllIl[1];
                        KillAura.mc.player.rotationPitch = lllllllllllllllIlIlIIlIIIlIIllIl[1];
                    }
                    if (KillAura.BetterCrits.getBoolValue()) {
                        KillAura.mc.gameSettings.keyBindSneak.pressed = true;
                    }
                    if (KillAura.shieldBypass.getBoolValue()) {
                        final int lllllllllllllllIlIlIIlIIIlIIllII = InventoryHelper.getAxe();
                        KillAura.mc.player.connection.sendPacket(new CPacketHeldItemChange(lllllllllllllllIlIlIIlIIIlIIllII));
                        KillAura.mc.player.connection.sendPacket(new CPacketHeldItemChange(KillAura.mc.player.inventory.currentItem));
                    }
                    if (KillAura.shieldBypass.getBoolValue()) {
                        final int lllllllllllllllIlIlIIlIIIlIIlIll = InventoryHelper.getAxe();
                        final NetHandlerPlayClient connection = KillAura.mc.player.connection;
                        final InventoryPlayer inventory = KillAura.mc.player.inventory;
                        final int n = lllllllllllllllIlIlIIlIIIlIIlIll;
                        inventory.currentItem = n;
                        connection.sendPacket(new CPacketHeldItemChange(n));
                        final NetHandlerPlayClient connection2 = KillAura.mc.player.connection;
                        final InventoryPlayer inventory2 = KillAura.mc.player.inventory;
                        final int swordAtHotbar = InventoryHelper.getSwordAtHotbar();
                        inventory2.currentItem = swordAtHotbar;
                        connection2.sendPacket(new CPacketHeldItemChange(swordAtHotbar));
                    }
                    KillAura.mc.player.connection.sendPacket(new CPacketEntityAction(KillAura.mc.player, CPacketEntityAction.Action.STOP_SPRINTING));
                    KillAura.mc.playerController.attackEntity(KillAura.mc.player, EntityHelper.rayCast(lllllllllllllllIlIlIIlIIIlIlIIII, KillAura.range.getNumberValue()));
                    KillAura.mc.player.swingArm(EnumHand.MAIN_HAND);
                    if (KillAura.doubleTap.getBoolValue() && KillAura.timerHelper.hasReached(10.0)) {
                        KillAura.mc.playerController.attackEntity(KillAura.mc.player, EntityHelper.rayCast(lllllllllllllllIlIlIIlIIIlIlIIII, KillAura.range.getNumberValue()));
                        KillAura.mc.player.swingArm(EnumHand.MAIN_HAND);
                        KillAura.timerHelper.reset();
                    }
                    KillAura.mc.player.connection.sendPacket(new CPacketEntityAction(KillAura.mc.player, CPacketEntityAction.Action.START_SPRINTING));
                    if (KillAura.BetterCrits.getBoolValue()) {
                        KillAura.mc.gameSettings.keyBindSneak.pressed = false;
                        break;
                    }
                    break;
                }
                default:
                    break;
            }
        }
    }
    
    @EventTarget
    public void onNickRemove(final EventNameTags lllllllllllllllIlIlIIIllllllIllI) {
        if (KillAura.targetHudMode.currentMode.equalsIgnoreCase("Astolfo")) {
            lllllllllllllllIlIlIIIllllllIllI.setCancelled(true);
        }
    }
}
