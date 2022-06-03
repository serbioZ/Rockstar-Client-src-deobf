// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHand;
import ru.rockstar.api.utils.movement.MovementHelper;
import net.minecraft.entity.item.EntityEnderCrystal;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import ru.rockstar.api.utils.friend.Friend;
import ru.rockstar.Main;
import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class TriggerBot extends Feature
{
    public static /* synthetic */ NumberSetting critFallDist;
    public static /* synthetic */ BooleanSetting onlyCrit;
    public static /* synthetic */ BooleanSetting mobs;
    public static /* synthetic */ BooleanSetting players;
    public static /* synthetic */ NumberSetting range;
    
    public static boolean canTrigger(final EntityLivingBase lllllllllllIllIlIlIIlIllllllIIll) {
        for (final Friend lllllllllllIllIlIlIIlIllllllIlII : Main.instance.friendManager.getFriends()) {
            if (!lllllllllllIllIlIlIIlIllllllIIll.getName().equals(lllllllllllIllIlIlIIlIllllllIlII.getName())) {
                continue;
            }
            return false;
        }
        if (lllllllllllIllIlIlIIlIllllllIIll instanceof EntityPlayer || lllllllllllIllIlIlIIlIllllllIIll instanceof EntityAnimal || lllllllllllIllIlIlIIlIllllllIIll instanceof EntityMob || lllllllllllIllIlIlIIlIllllllIIll instanceof EntityVillager) {
            if (lllllllllllIllIlIlIIlIllllllIIll instanceof EntityPlayer && !TriggerBot.players.getBoolValue()) {
                return false;
            }
            if (lllllllllllIllIlIlIIlIllllllIIll instanceof EntityAnimal && !TriggerBot.mobs.getBoolValue()) {
                return false;
            }
            if (lllllllllllIllIlIlIIlIllllllIIll instanceof EntityMob && !TriggerBot.mobs.getBoolValue()) {
                return false;
            }
            if (lllllllllllIllIlIlIIlIllllllIIll instanceof EntityVillager && !TriggerBot.mobs.getBoolValue()) {
                return false;
            }
        }
        return lllllllllllIllIlIlIIlIllllllIIll != TriggerBot.mc.player;
    }
    
    public TriggerBot() {
        super("TriggerBot", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u043d\u0430\u043d\u043e\u0441\u0438\u0442 \u0443\u0434\u0430\u0440 \u043f\u0440\u0438 \u043d\u0430\u0432\u043e\u0434\u043a\u0435 \u043d\u0430 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u044c", 0, Category.COMBAT);
        TriggerBot.players = new BooleanSetting("Players", true, () -> true);
        TriggerBot.mobs = new BooleanSetting("Mobs", false, () -> true);
        TriggerBot.range = new NumberSetting("Trigger Range", 4.0f, 1.0f, 6.0f, 0.1f, () -> true);
        this.addSettings(TriggerBot.range, TriggerBot.players, TriggerBot.mobs, TriggerBot.onlyCrit, TriggerBot.critFallDist);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIllIlIlIIlIlllllIlllI) {
        final Entity lllllllllllIllIlIlIIlIlllllIllIl = TriggerBot.mc.objectMouseOver.entityHit;
        if (lllllllllllIllIlIlIIlIlllllIllIl == null || TriggerBot.mc.player.getDistanceToEntity(lllllllllllIllIlIlIIlIlllllIllIl) > TriggerBot.range.getNumberValue() || lllllllllllIllIlIlIIlIlllllIllIl instanceof EntityEnderCrystal || lllllllllllIllIlIlIIlIlllllIllIl.isDead || ((EntityLivingBase)lllllllllllIllIlIlIIlIlllllIllIl).getHealth() <= 0.0f) {
            return;
        }
        if (MovementHelper.isBlockAboveHead()) {
            if (TriggerBot.mc.player.fallDistance < TriggerBot.critFallDist.getNumberValue() && TriggerBot.mc.player.getCooledAttackStrength(0.8f) == 1.0f && TriggerBot.onlyCrit.getBoolValue() && !TriggerBot.mc.player.isOnLadder() && !TriggerBot.mc.player.isInLiquid() && !TriggerBot.mc.player.isInWeb && TriggerBot.mc.player.getRidingEntity() == null) {
                return;
            }
        }
        else if (TriggerBot.mc.player.fallDistance != 0.0f && TriggerBot.onlyCrit.getBoolValue() && !TriggerBot.mc.player.isOnLadder() && !TriggerBot.mc.player.isInLiquid() && !TriggerBot.mc.player.isInWeb && TriggerBot.mc.player.getRidingEntity() == null) {
            return;
        }
        if (canTrigger((EntityLivingBase)lllllllllllIllIlIlIIlIlllllIllIl)) {
            if (TriggerBot.onlyCrit.getBoolValue()) {
                if (TriggerBot.mc.player.fallDistance > TriggerBot.critFallDist.getNumberValue() && TriggerBot.mc.player.getCooledAttackStrength(0.0f) == 1.0f) {
                    TriggerBot.mc.playerController.attackEntity(TriggerBot.mc.player, lllllllllllIllIlIlIIlIlllllIllIl);
                    TriggerBot.mc.player.swingArm(EnumHand.MAIN_HAND);
                }
            }
            else if (TriggerBot.mc.player.getCooledAttackStrength(0.0f) == 1.0f) {
                TriggerBot.mc.playerController.attackEntity(TriggerBot.mc.player, lllllllllllIllIlIlIIlIlllllIllIl);
                TriggerBot.mc.player.swingArm(EnumHand.MAIN_HAND);
            }
        }
    }
    
    static {
        TriggerBot.onlyCrit = new BooleanSetting("Only Crits", false, () -> true);
        TriggerBot.critFallDist = new NumberSetting("Fall Distance", 0.2f, 0.08f, 1.0f, 0.01f, () -> TriggerBot.onlyCrit.getBoolValue());
    }
}
