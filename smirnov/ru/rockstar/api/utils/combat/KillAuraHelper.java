// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.combat;

import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.Comparator;
import java.util.ArrayList;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.combat.AntiBot;
import ru.rockstar.api.utils.friend.Friend;
import ru.rockstar.Main;
import net.minecraft.entity.item.EntityArmorStand;
import ru.rockstar.api.utils.world.InventoryHelper;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import ru.rockstar.api.utils.math.MathematicHelper;
import ru.rockstar.client.features.impl.combat.KillAura;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import ru.rockstar.api.utils.Helper;

public class KillAuraHelper implements Helper
{
    public static boolean isOnSameTeam(final Entity lllllllllllIIIllIllIIllllllIllll) {
        return KillAuraHelper.mc.player.getDisplayName().getUnformattedText().substring(0, 2).equals(lllllllllllIIIllIllIIllllllIllll.getDisplayName().getUnformattedText().substring(0, 2)) || KillAuraHelper.mc.player.isOnSameTeam(lllllllllllIIIllIllIIllllllIllll);
    }
    
    public static boolean canSeeEntityAtFov(final Entity lllllllllllIIIllIllIIllllllIIllI, final float lllllllllllIIIllIllIIlllllIllllI) {
        final double lllllllllllIIIllIllIIllllllIIlII = lllllllllllIIIllIllIIllllllIIllI.posX - KillAuraHelper.mc.player.posX;
        final double lllllllllllIIIllIllIIllllllIIIll = lllllllllllIIIllIllIIllllllIIllI.posZ - KillAuraHelper.mc.player.posZ;
        final float lllllllllllIIIllIllIIllllllIIIlI = (float)(Math.toDegrees(Math.atan2(lllllllllllIIIllIllIIllllllIIIll, lllllllllllIIIllIllIIllllllIIlII)) - 90.0);
        final double lllllllllllIIIllIllIIllllllIIIIl = lllllllllllIIIllIllIIllllllIIIlI;
        final double lllllllllllIIIllIllIIllllllIIIII = angleDifference(lllllllllllIIIllIllIIllllllIIIIl, KillAuraHelper.mc.player.rotationYaw);
        return lllllllllllIIIllIllIIllllllIIIII <= lllllllllllIIIllIllIIlllllIllllI;
    }
    
    public static boolean canApsAttack() {
        final int lllllllllllIIIllIllIIlllllIIlIll = (int)(14.0f / MathematicHelper.randomizeFloat((float)(int)KillAura.maxAps.getNumberValue(), (float)(int)KillAura.minAps.getNumberValue()));
        if (KillAuraHelper.timerHelper.hasReached(50 * lllllllllllIIIllIllIIlllllIIlIll)) {
            KillAuraHelper.timerHelper.reset();
            return true;
        }
        return false;
    }
    
    public static boolean canAttack(final EntityLivingBase lllllllllllIIIllIllIIllllllllIll) {
        if (lllllllllllIIIllIllIIllllllllIll instanceof EntityPlayer || lllllllllllIIIllIllIIllllllllIll instanceof EntityAnimal || lllllllllllIIIllIllIIllllllllIll instanceof EntityMob || lllllllllllIIIllIllIIllllllllIll instanceof EntityVillager) {
            if (lllllllllllIIIllIllIIllllllllIll instanceof EntityPlayer && !KillAura.auraplayers.getBoolValue()) {
                return false;
            }
            if (lllllllllllIIIllIllIIllllllllIll instanceof EntityAnimal && !KillAura.auramobs.getBoolValue()) {
                return false;
            }
            if (lllllllllllIIIllIllIIllllllllIll instanceof EntityMob && !KillAura.auramobs.getBoolValue()) {
                return false;
            }
            if (lllllllllllIIIllIllIIllllllllIll instanceof EntityVillager && !KillAura.auramobs.getBoolValue()) {
                return false;
            }
            if (KillAura.ignoreNakedPlayer.getBoolValue() && !InventoryHelper.isArmorPlayer(lllllllllllIIIllIllIIllllllllIll)) {
                return false;
            }
        }
        if (lllllllllllIIIllIllIIllllllllIll.isInvisible() && !KillAura.invisiblecheck.getBoolValue()) {
            return false;
        }
        if (lllllllllllIIIllIllIIllllllllIll instanceof EntityArmorStand) {
            return false;
        }
        for (final Friend lllllllllllIIIllIllIIllllllllIlI : Main.instance.friendManager.getFriends()) {
            if (!lllllllllllIIIllIllIIllllllllIll.getName().equals(lllllllllllIIIllIllIIllllllllIlI.getName())) {
                continue;
            }
            return false;
        }
        if (Main.featureDirector.getFeatureByClass(AntiBot.class).isToggled() && AntiBot.isBotPlayer.contains(lllllllllllIIIllIllIIllllllllIll)) {
            return false;
        }
        if (KillAura.teamCheck.getBoolValue() && isOnSameTeam(lllllllllllIIIllIllIIllllllllIll)) {
            return false;
        }
        if (!RotationHelper.canSeeEntityAtFov(lllllllllllIIIllIllIIllllllllIll, KillAura.fov.getNumberValue()) && !canSeeEntityAtFov(lllllllllllIIIllIllIIllllllllIll, KillAura.fov.getNumberValue())) {
            return false;
        }
        if (!range(lllllllllllIIIllIllIIllllllllIll, KillAura.range.getNumberValue())) {
            return false;
        }
        if (!lllllllllllIIIllIllIIllllllllIll.canEntityBeSeen(KillAuraHelper.mc.player)) {
            return KillAura.walls.getBoolValue();
        }
        return lllllllllllIIIllIllIIllllllllIll != KillAuraHelper.mc.player;
    }
    
    public static EntityLivingBase getSortEntities() {
        final List<EntityLivingBase> lllllllllllIIIllIllIIlllllIlIlII = new ArrayList<EntityLivingBase>();
        for (final Entity lllllllllllIIIllIllIIlllllIlIIll : KillAuraHelper.mc.world.loadedEntityList) {
            if (lllllllllllIIIllIllIIlllllIlIIll instanceof EntityLivingBase) {
                final EntityLivingBase lllllllllllIIIllIllIIlllllIlIIlI = (EntityLivingBase)lllllllllllIIIllIllIIlllllIlIIll;
                if (KillAuraHelper.mc.player.getDistanceToEntity(lllllllllllIIIllIllIIlllllIlIIlI) >= KillAura.range.getNumberValue() || !canAttack(lllllllllllIIIllIllIIlllllIlIIlI)) {
                    continue;
                }
                lllllllllllIIIllIllIIlllllIlIlII.add(lllllllllllIIIllIllIIlllllIlIIlI);
            }
        }
        final String lllllllllllIIIllIllIIlllllIlIIIl = KillAura.sortMode.getOptions();
        if (lllllllllllIIIllIllIIlllllIlIIIl.equalsIgnoreCase("Health")) {
            lllllllllllIIIllIllIIlllllIlIlII.sort((lllllllllllIIIllIllIIllllIlllllI, lllllllllllIIIllIllIIllllIlllIll) -> (int)(lllllllllllIIIllIllIIllllIlllllI.getHealth() - lllllllllllIIIllIllIIllllIlllIll.getHealth()));
        }
        else if (lllllllllllIIIllIllIIlllllIlIIIl.equalsIgnoreCase("Distance")) {
            lllllllllllIIIllIllIIlllllIlIlII.sort(Comparator.comparingDouble((ToDoubleFunction<? super EntityLivingBase>)KillAuraHelper.mc.player::getDistanceToEntity));
        }
        if (lllllllllllIIIllIllIIlllllIlIlII.isEmpty()) {
            return null;
        }
        return lllllllllllIIIllIllIIlllllIlIlII.get(0);
    }
    
    public static double angleDifference(final double lllllllllllIIIllIllIIlllllIIIllI, final double lllllllllllIIIllIllIIlllllIIIlIl) {
        float lllllllllllIIIllIllIIlllllIIIlII = (float)(Math.abs(lllllllllllIIIllIllIIlllllIIIllI - lllllllllllIIIllIllIIlllllIIIlIl) % 360.0);
        if (lllllllllllIIIllIllIIlllllIIIlII > 180.0f) {
            lllllllllllIIIllIllIIlllllIIIlII = 360.0f - lllllllllllIIIllIllIIlllllIIIlII;
        }
        return lllllllllllIIIllIllIIlllllIIIlII;
    }
    
    private static boolean range(final EntityLivingBase lllllllllllIIIllIllIIlllllllIlII, final double lllllllllllIIIllIllIIlllllllIIIl) {
        KillAuraHelper.mc.player.getDistanceToEntity(lllllllllllIIIllIllIIlllllllIlII);
        return KillAuraHelper.mc.player.getDistanceToEntity(lllllllllllIIIllIllIIlllllllIlII) <= lllllllllllIIIllIllIIlllllllIIIl;
    }
}
