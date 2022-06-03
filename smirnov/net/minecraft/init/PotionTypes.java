// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.init;

import com.google.common.collect.Sets;
import net.minecraft.util.ResourceLocation;
import java.util.Set;
import net.minecraft.potion.PotionType;

public class PotionTypes
{
    private static final /* synthetic */ Set<PotionType> CACHE;
    
    private static PotionType getRegisteredPotionType(final String lllllllllllllllIllIllllllIllllll) {
        final PotionType lllllllllllllllIllIllllllIlllllI = PotionType.REGISTRY.getObject(new ResourceLocation(lllllllllllllllIllIllllllIllllll));
        if (!PotionTypes.CACHE.add(lllllllllllllllIllIllllllIlllllI)) {
            throw new IllegalStateException("Invalid Potion requested: " + lllllllllllllllIllIllllllIllllll);
        }
        return lllllllllllllllIllIllllllIlllllI;
    }
    
    static {
        if (!Bootstrap.isRegistered()) {
            throw new RuntimeException("Accessed Potions before Bootstrap!");
        }
        CACHE = Sets.newHashSet();
        EMPTY = getRegisteredPotionType("empty");
        WATER = getRegisteredPotionType("water");
        MUNDANE = getRegisteredPotionType("mundane");
        THICK = getRegisteredPotionType("thick");
        AWKWARD = getRegisteredPotionType("awkward");
        NIGHT_VISION = getRegisteredPotionType("night_vision");
        LONG_NIGHT_VISION = getRegisteredPotionType("long_night_vision");
        INVISIBILITY = getRegisteredPotionType("invisibility");
        LONG_INVISIBILITY = getRegisteredPotionType("long_invisibility");
        LEAPING = getRegisteredPotionType("leaping");
        LONG_LEAPING = getRegisteredPotionType("long_leaping");
        STRONG_LEAPING = getRegisteredPotionType("strong_leaping");
        FIRE_RESISTANCE = getRegisteredPotionType("fire_resistance");
        LONG_FIRE_RESISTANCE = getRegisteredPotionType("long_fire_resistance");
        SWIFTNESS = getRegisteredPotionType("swiftness");
        LONG_SWIFTNESS = getRegisteredPotionType("long_swiftness");
        STRONG_SWIFTNESS = getRegisteredPotionType("strong_swiftness");
        SLOWNESS = getRegisteredPotionType("slowness");
        LONG_SLOWNESS = getRegisteredPotionType("long_slowness");
        WATER_BREATHING = getRegisteredPotionType("water_breathing");
        LONG_WATER_BREATHING = getRegisteredPotionType("long_water_breathing");
        HEALING = getRegisteredPotionType("healing");
        STRONG_HEALING = getRegisteredPotionType("strong_healing");
        HARMING = getRegisteredPotionType("harming");
        STRONG_HARMING = getRegisteredPotionType("strong_harming");
        POISON = getRegisteredPotionType("poison");
        LONG_POISON = getRegisteredPotionType("long_poison");
        STRONG_POISON = getRegisteredPotionType("strong_poison");
        REGENERATION = getRegisteredPotionType("regeneration");
        LONG_REGENERATION = getRegisteredPotionType("long_regeneration");
        STRONG_REGENERATION = getRegisteredPotionType("strong_regeneration");
        STRENGTH = getRegisteredPotionType("strength");
        LONG_STRENGTH = getRegisteredPotionType("long_strength");
        STRONG_STRENGTH = getRegisteredPotionType("strong_strength");
        WEAKNESS = getRegisteredPotionType("weakness");
        LONG_WEAKNESS = getRegisteredPotionType("long_weakness");
        PotionTypes.CACHE.clear();
    }
}
