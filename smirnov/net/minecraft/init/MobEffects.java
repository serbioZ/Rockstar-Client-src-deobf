// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.init;

import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Potion;

public class MobEffects
{
    static {
        if (!Bootstrap.isRegistered()) {
            throw new RuntimeException("Accessed MobEffects before Bootstrap!");
        }
        SPEED = getRegisteredMobEffect("speed");
        SLOWNESS = getRegisteredMobEffect("slowness");
        HASTE = getRegisteredMobEffect("haste");
        MINING_FATIGUE = getRegisteredMobEffect("mining_fatigue");
        STRENGTH = getRegisteredMobEffect("strength");
        INSTANT_HEALTH = getRegisteredMobEffect("instant_health");
        INSTANT_DAMAGE = getRegisteredMobEffect("instant_damage");
        JUMP_BOOST = getRegisteredMobEffect("jump_boost");
        NAUSEA = getRegisteredMobEffect("nausea");
        REGENERATION = getRegisteredMobEffect("regeneration");
        RESISTANCE = getRegisteredMobEffect("resistance");
        FIRE_RESISTANCE = getRegisteredMobEffect("fire_resistance");
        WATER_BREATHING = getRegisteredMobEffect("water_breathing");
        INVISIBILITY = getRegisteredMobEffect("invisibility");
        BLINDNESS = getRegisteredMobEffect("blindness");
        NIGHT_VISION = getRegisteredMobEffect("night_vision");
        HUNGER = getRegisteredMobEffect("hunger");
        WEAKNESS = getRegisteredMobEffect("weakness");
        POISON = getRegisteredMobEffect("poison");
        WITHER = getRegisteredMobEffect("wither");
        HEALTH_BOOST = getRegisteredMobEffect("health_boost");
        ABSORPTION = getRegisteredMobEffect("absorption");
        SATURATION = getRegisteredMobEffect("saturation");
        GLOWING = getRegisteredMobEffect("glowing");
        LEVITATION = getRegisteredMobEffect("levitation");
        LUCK = getRegisteredMobEffect("luck");
        UNLUCK = getRegisteredMobEffect("unluck");
    }
    
    @Nullable
    private static Potion getRegisteredMobEffect(final String llllllllllllllIIlIIIIIIIlIIllIIl) {
        final Potion llllllllllllllIIlIIIIIIIlIIllIII = Potion.REGISTRY.getObject(new ResourceLocation(llllllllllllllIIlIIIIIIIlIIllIIl));
        if (llllllllllllllIIlIIIIIIIlIIllIII == null) {
            throw new IllegalStateException("Invalid MobEffect requested: " + llllllllllllllIIlIIIIIIIlIIllIIl);
        }
        return llllllllllllllIIlIIIIIIIlIIllIII;
    }
}
