// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.function.Function;
import java.util.Comparator;
import java.util.ArrayList;
import ru.rockstar.api.utils.combat.EntityHelper;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import ru.rockstar.api.utils.friend.Friend;
import ru.rockstar.Main;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventPreMotion;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.api.utils.combat.RotationHelper;
import net.minecraft.entity.Entity;
import ru.rockstar.api.utils.math.GCDCalcHelper;
import ru.rockstar.api.utils.math.MathematicHelper;
import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class AimBot extends Feature
{
    public static /* synthetic */ BooleanSetting invis;
    public static /* synthetic */ BooleanSetting team;
    public static /* synthetic */ NumberSetting fov;
    public static /* synthetic */ NumberSetting rotYawRandom;
    public static /* synthetic */ NumberSetting range;
    public static /* synthetic */ ListSetting part;
    public static /* synthetic */ NumberSetting rotYawSpeed;
    public static /* synthetic */ BooleanSetting walls;
    public static /* synthetic */ NumberSetting rotPitchSpeed;
    public static /* synthetic */ BooleanSetting players;
    public static /* synthetic */ BooleanSetting click;
    public static /* synthetic */ NumberSetting rotPitchRandom;
    public static /* synthetic */ BooleanSetting mobs;
    public static /* synthetic */ ListSetting sort;
    public static /* synthetic */ BooleanSetting ignoreNakedPlayers;
    public static /* synthetic */ NumberSetting predict;
    
    private float[] getRotationsForAssist(final EntityLivingBase llllllllllllIIIlIllIlllIIIIIllIl) {
        final float llllllllllllIIIlIllIlllIIIIlIIII = RotationHelper.updateRotation(GCDCalcHelper.getFixedRotation(AimBot.mc.player.rotationYaw + MathematicHelper.randomizeFloat(-AimBot.rotYawRandom.getNumberValue(), AimBot.rotYawRandom.getNumberValue())), this.getRotation(llllllllllllIIIlIllIlllIIIIIllIl, AimBot.predict.getNumberValue())[0], AimBot.rotYawSpeed.getNumberValue() * 10.0f);
        final float llllllllllllIIIlIllIlllIIIIIllll = RotationHelper.updateRotation(GCDCalcHelper.getFixedRotation(AimBot.mc.player.rotationPitch + MathematicHelper.randomizeFloat(-AimBot.rotPitchRandom.getNumberValue(), AimBot.rotPitchRandom.getNumberValue())), this.getRotation(llllllllllllIIIlIllIlllIIIIIllIl, AimBot.predict.getNumberValue())[1], AimBot.rotPitchSpeed.getNumberValue() * 10.0f);
        return new float[] { llllllllllllIIIlIllIlllIIIIlIIII, llllllllllllIIIlIllIlllIIIIIllll };
    }
    
    private float[] getRotation(final Entity llllllllllllIIIlIllIllIlllllIlIl, final float llllllllllllIIIlIllIllIllllllllI) {
        final String llllllllllllIIIlIllIllIlllllllIl = AimBot.part.getOptions();
        float llllllllllllIIIlIllIllIlllllllII = 0.0f;
        if (llllllllllllIIIlIllIllIlllllllIl.equalsIgnoreCase("Head")) {
            llllllllllllIIIlIllIllIlllllllII = 0.0f;
        }
        else if (llllllllllllIIIlIllIllIlllllllIl.equalsIgnoreCase("Chest")) {
            llllllllllllIIIlIllIllIlllllllII = 0.5f;
        }
        else if (llllllllllllIIIlIllIllIlllllllIl.equalsIgnoreCase("Leggings")) {
            llllllllllllIIIlIllIllIlllllllII = 0.9f;
        }
        else if (llllllllllllIIIlIllIllIlllllllIl.equalsIgnoreCase("Boots")) {
            llllllllllllIIIlIllIllIlllllllII = 1.3f;
        }
        final double llllllllllllIIIlIllIllIllllllIll = llllllllllllIIIlIllIllIlllllIlIl.posX + (llllllllllllIIIlIllIllIlllllIlIl.posX - llllllllllllIIIlIllIllIlllllIlIl.prevPosX) * llllllllllllIIIlIllIllIllllllllI - AimBot.mc.player.posX - AimBot.mc.player.motionX * llllllllllllIIIlIllIllIllllllllI;
        final double llllllllllllIIIlIllIllIllllllIlI = llllllllllllIIIlIllIllIlllllIlIl.posZ + (llllllllllllIIIlIllIllIlllllIlIl.posZ - llllllllllllIIIlIllIllIlllllIlIl.prevPosZ) * llllllllllllIIIlIllIllIllllllllI - AimBot.mc.player.posZ - AimBot.mc.player.motionZ * llllllllllllIIIlIllIllIllllllllI;
        final double llllllllllllIIIlIllIllIllllllIIl = llllllllllllIIIlIllIllIlllllIlIl.posY + llllllllllllIIIlIllIllIlllllIlIl.getEyeHeight() - (AimBot.mc.player.posY + AimBot.mc.player.getEyeHeight() + llllllllllllIIIlIllIllIlllllllII);
        final double llllllllllllIIIlIllIllIllllllIII = MathHelper.sqrt(llllllllllllIIIlIllIllIllllllIll * llllllllllllIIIlIllIllIllllllIll + llllllllllllIIIlIllIllIllllllIlI * llllllllllllIIIlIllIllIllllllIlI);
        float llllllllllllIIIlIllIllIlllllIlll = (float)(MathHelper.atan2(llllllllllllIIIlIllIllIllllllIlI, llllllllllllIIIlIllIllIllllllIll) * 180.0 / 3.141592653589793 - 90.0) + MathematicHelper.randomizeFloat(-AimBot.rotYawRandom.getNumberValue(), AimBot.rotYawRandom.getNumberValue());
        float llllllllllllIIIlIllIllIlllllIllI = (float)(-(MathHelper.atan2(llllllllllllIIIlIllIllIllllllIIl, llllllllllllIIIlIllIllIllllllIII) * 180.0 / 3.141592653589793)) + MathematicHelper.randomizeFloat(-AimBot.rotPitchRandom.getNumberValue(), AimBot.rotPitchRandom.getNumberValue());
        llllllllllllIIIlIllIllIlllllIlll = AimBot.mc.player.rotationYaw + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees(llllllllllllIIIlIllIllIlllllIlll - AimBot.mc.player.rotationYaw));
        llllllllllllIIIlIllIllIlllllIllI = AimBot.mc.player.rotationPitch + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees(llllllllllllIIIlIllIllIlllllIllI - AimBot.mc.player.rotationPitch));
        llllllllllllIIIlIllIllIlllllIllI = MathHelper.clamp(llllllllllllIIIlIllIllIlllllIllI, -90.0f, 90.0f);
        return new float[] { llllllllllllIIIlIllIllIlllllIlll, llllllllllllIIIlIllIllIlllllIllI };
    }
    
    public AimBot() {
        super("AimBot", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438\u0439 \u0430\u0438\u043c \u043d\u0430 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439 \u0432\u043e\u043a\u0440\u0443\u0433 \u0442\u0435\u0431\u044f", 0, Category.COMBAT);
        AimBot.sort = new ListSetting("Assist Sort Mode", "Distance", () -> true, new String[] { "Distance", "Higher Armor", "Lowest Armor", "Health", "Angle", "HurtTime" });
        AimBot.part = new ListSetting("Aim-Part Mode", "Chest", () -> true, new String[] { "Chest", "Head", "Leggings", "Boots" });
        AimBot.range = new NumberSetting("Range", 4.0f, 1.0f, 6.0f, 0.01f, () -> true);
        AimBot.players = new BooleanSetting("Players", true, () -> true);
        AimBot.mobs = new BooleanSetting("Mobs", false, () -> true);
        AimBot.team = new BooleanSetting("Team Check", false, () -> true);
        AimBot.walls = new BooleanSetting("Walls", false, () -> true);
        AimBot.invis = new BooleanSetting("Invisible", false, () -> true);
        AimBot.click = new BooleanSetting("Click Only", false, () -> true);
        AimBot.predict = new NumberSetting("Aim Predict", 0.5f, 0.0f, 5.0f, 0.1f, () -> true);
        AimBot.fov = new NumberSetting("Assist FOV", 180.0f, 5.0f, 180.0f, 5.0f, () -> true);
        AimBot.rotYawSpeed = new NumberSetting("Rotation Yaw Speed", 1.0f, 0.1f, 5.0f, 0.1f, () -> true);
        AimBot.rotPitchSpeed = new NumberSetting("Rotation Pitch Speed", 1.0f, 0.1f, 5.0f, 0.1f, () -> true);
        AimBot.rotYawRandom = new NumberSetting("Yaw Randomize", 1.0f, 0.0f, 3.0f, 0.1f, () -> true);
        AimBot.rotPitchRandom = new NumberSetting("Pitch Randomize", 1.0f, 0.0f, 3.0f, 0.1f, () -> true);
        AimBot.ignoreNakedPlayers = new BooleanSetting("Ignore Naked Players", false, () -> true);
        this.addSettings(AimBot.players, AimBot.mobs, AimBot.walls, AimBot.invis, AimBot.team, AimBot.click, AimBot.range, AimBot.predict, AimBot.fov, AimBot.rotYawSpeed, AimBot.rotPitchSpeed, AimBot.rotPitchRandom, AimBot.rotYawRandom, AimBot.sort, AimBot.part, AimBot.ignoreNakedPlayers);
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotion llllllllllllIIIlIllIlllIIIIlllII) {
        final EntityLivingBase llllllllllllIIIlIllIlllIIIIllIll = getSortEntities();
        if (llllllllllllIIIlIllIlllIIIIllIll != null && AimBot.mc.player.getDistanceToEntity(llllllllllllIIIlIllIlllIIIIllIll) <= AimBot.range.getNumberValue() && llllllllllllIIIlIllIlllIIIIllIll != AimBot.mc.player) {
            final float[] llllllllllllIIIlIllIlllIIIIllIlI = this.getRotationsForAssist(llllllllllllIIIlIllIlllIIIIllIll);
            if (AimBot.click.getBoolValue() && !AimBot.mc.gameSettings.keyBindAttack.isKeyDown()) {
                return;
            }
            if (canAssist(llllllllllllIIIlIllIlllIIIIllIll) && llllllllllllIIIlIllIlllIIIIllIll.getHealth() > 0.0f) {
                AimBot.mc.player.rotationYaw = llllllllllllIIIlIllIlllIIIIllIlI[0];
                AimBot.mc.player.rotationPitch = llllllllllllIIIlIllIlllIIIIllIlI[1];
            }
        }
    }
    
    public static boolean canAssist(final EntityLivingBase llllllllllllIIIlIllIlllIIIlIIIll) {
        for (final Friend llllllllllllIIIlIllIlllIIIlIIlII : Main.instance.friendManager.getFriends()) {
            if (!llllllllllllIIIlIllIlllIIIlIIIll.getName().equals(llllllllllllIIIlIllIlllIIIlIIlII.getName())) {
                continue;
            }
            return false;
        }
        if (llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityPlayer || llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityAnimal || llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityMob || llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityWaterMob || llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityVillager) {
            if (llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityPlayer && !AimBot.players.getBoolValue()) {
                return false;
            }
            if (llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityAnimal && !AimBot.mobs.getBoolValue()) {
                return false;
            }
            if (llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityWaterMob && !AimBot.mobs.getBoolValue()) {
                return false;
            }
            if (llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityMob && !AimBot.mobs.getBoolValue()) {
                return false;
            }
            if (llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityVillager && !AimBot.mobs.getBoolValue()) {
                return false;
            }
        }
        if (AimBot.ignoreNakedPlayers.getBoolValue() && llllllllllllIIIlIllIlllIIIlIIIll instanceof EntityPlayer && EntityHelper.checkArmor(llllllllllllIIIlIllIlllIIIlIIIll)) {
            return false;
        }
        if (llllllllllllIIIlIllIlllIIIlIIIll.isInvisible() && !AimBot.invis.getBoolValue()) {
            return false;
        }
        if (AimBot.ignoreNakedPlayers.getBoolValue() && EntityHelper.checkArmor(llllllllllllIIIlIllIlllIIIlIIIll)) {
            return false;
        }
        if (!canSeeEntityAtFov(llllllllllllIIIlIllIlllIIIlIIIll, AimBot.fov.getNumberValue() * 2.0f)) {
            return false;
        }
        if (AimBot.team.getBoolValue() && EntityHelper.isTeamWithYou(llllllllllllIIIlIllIlllIIIlIIIll)) {
            return false;
        }
        if (!llllllllllllIIIlIllIlllIIIlIIIll.canEntityBeSeen(AimBot.mc.player)) {
            return AimBot.walls.getBoolValue();
        }
        return llllllllllllIIIlIllIlllIIIlIIIll != AimBot.mc.player;
    }
    
    public static double angleDifference(final double llllllllllllIIIlIllIlllIIIllIlll, final double llllllllllllIIIlIllIlllIIIlllIIl) {
        float llllllllllllIIIlIllIlllIIIlllIII = (float)(Math.abs(llllllllllllIIIlIllIlllIIIllIlll - llllllllllllIIIlIllIlllIIIlllIIl) % 360.0);
        if (llllllllllllIIIlIllIlllIIIlllIII > 180.0f) {
            llllllllllllIIIlIllIlllIIIlllIII = 360.0f - llllllllllllIIIlIllIlllIIIlllIII;
        }
        return llllllllllllIIIlIllIlllIIIlllIII;
    }
    
    public static EntityLivingBase getSortEntities() {
        final List<EntityLivingBase> llllllllllllIIIlIllIlllIIIllIIII = new ArrayList<EntityLivingBase>();
        for (final Entity llllllllllllIIIlIllIlllIIIlIllll : AimBot.mc.world.loadedEntityList) {
            if (llllllllllllIIIlIllIlllIIIlIllll instanceof EntityLivingBase) {
                final EntityLivingBase llllllllllllIIIlIllIlllIIIlIlllI = (EntityLivingBase)llllllllllllIIIlIllIlllIIIlIllll;
                if (AimBot.mc.player.getDistanceToEntity(llllllllllllIIIlIllIlllIIIlIlllI) >= AimBot.range.getNumberValue()) {
                    continue;
                }
                if (!canAssist(llllllllllllIIIlIllIlllIIIlIlllI)) {
                    continue;
                }
                if (llllllllllllIIIlIllIlllIIIlIlllI.getHealth() > 0.0f) {
                    llllllllllllIIIlIllIlllIIIllIIII.add(llllllllllllIIIlIllIlllIIIlIlllI);
                }
                else {
                    llllllllllllIIIlIllIlllIIIllIIII.remove(llllllllllllIIIlIllIlllIIIlIlllI);
                }
            }
        }
        final String llllllllllllIIIlIllIlllIIIlIllIl = AimBot.sort.getOptions();
        if (llllllllllllIIIlIllIlllIIIlIllIl.equalsIgnoreCase("Angle")) {
            llllllllllllIIIlIllIlllIIIllIIII.sort((llllllllllllIIIlIllIllIllllIlIIl, llllllllllllIIIlIllIllIllllIlIII) -> (int)(Math.abs(RotationHelper.getAngleEntity(llllllllllllIIIlIllIllIllllIlIIl) - AimBot.mc.player.rotationYaw) - Math.abs(RotationHelper.getAngleEntity(llllllllllllIIIlIllIllIllllIlIII) - AimBot.mc.player.rotationYaw)));
        }
        else if (llllllllllllIIIlIllIlllIIIlIllIl.equalsIgnoreCase("Lowest Armor")) {
            llllllllllllIIIlIllIlllIIIllIIII.sort(Comparator.comparing((Function<? super EntityLivingBase, ? extends Comparable>)EntityLivingBase::getTotalArmorValue));
        }
        else if (llllllllllllIIIlIllIlllIIIlIllIl.equalsIgnoreCase("Health")) {
            llllllllllllIIIlIllIlllIIIllIIII.sort((llllllllllllIIIlIllIllIllllIIIll, llllllllllllIIIlIllIllIllllIIIlI) -> (int)(llllllllllllIIIlIllIllIllllIIIll.getHealth() - llllllllllllIIIlIllIllIllllIIIlI.getHealth()));
        }
        else if (llllllllllllIIIlIllIlllIIIlIllIl.equalsIgnoreCase("Distance")) {
            llllllllllllIIIlIllIlllIIIllIIII.sort(Comparator.comparingDouble((ToDoubleFunction<? super EntityLivingBase>)AimBot.mc.player::getDistanceToEntity));
        }
        if (llllllllllllIIIlIllIlllIIIllIIII.isEmpty()) {
            return null;
        }
        return llllllllllllIIIlIllIlllIIIllIIII.get(0);
    }
    
    public static boolean canSeeEntityAtFov(final Entity llllllllllllIIIlIllIlllIIlIIIIll, final float llllllllllllIIIlIllIlllIIlIIIIlI) {
        final double llllllllllllIIIlIllIlllIIlIIIlll = llllllllllllIIIlIllIlllIIlIIIIll.posX - AimBot.mc.player.posX;
        final double llllllllllllIIIlIllIlllIIlIIIllI = llllllllllllIIIlIllIlllIIlIIIIll.posZ - AimBot.mc.player.posZ;
        final float llllllllllllIIIlIllIlllIIlIIIlIl = (float)(Math.toDegrees(Math.atan2(llllllllllllIIIlIllIlllIIlIIIllI, llllllllllllIIIlIllIlllIIlIIIlll)) - 90.0);
        final double llllllllllllIIIlIllIlllIIlIIIlII = angleDifference(llllllllllllIIIlIllIlllIIlIIIlIl, AimBot.mc.player.rotationYaw);
        return llllllllllllIIIlIllIlllIIlIIIlII <= llllllllllllIIIlIllIlllIIlIIIIlI;
    }
}
