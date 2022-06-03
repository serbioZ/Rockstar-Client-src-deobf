// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.potion;

import javax.annotation.Nullable;
import com.google.common.collect.UnmodifiableIterator;
import java.util.List;
import net.minecraft.init.MobEffects;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;
import net.minecraft.util.ResourceLocation;
import com.google.common.collect.ImmutableList;

public class PotionType
{
    private final /* synthetic */ ImmutableList<PotionEffect> effects;
    private static final /* synthetic */ ResourceLocation WATER;
    private final /* synthetic */ String baseName;
    private static /* synthetic */ int nextPotionTypeId;
    public static final /* synthetic */ RegistryNamespacedDefaultedByKey<ResourceLocation, PotionType> REGISTRY;
    
    public static void registerPotionTypes() {
        registerPotionType("empty", new PotionType(new PotionEffect[0]));
        registerPotionType("water", new PotionType(new PotionEffect[0]));
        registerPotionType("mundane", new PotionType(new PotionEffect[0]));
        registerPotionType("thick", new PotionType(new PotionEffect[0]));
        registerPotionType("awkward", new PotionType(new PotionEffect[0]));
        registerPotionType("night_vision", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.NIGHT_VISION, 3600) }));
        registerPotionType("long_night_vision", new PotionType("night_vision", new PotionEffect[] { new PotionEffect(MobEffects.NIGHT_VISION, 9600) }));
        registerPotionType("invisibility", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.INVISIBILITY, 3600) }));
        registerPotionType("long_invisibility", new PotionType("invisibility", new PotionEffect[] { new PotionEffect(MobEffects.INVISIBILITY, 9600) }));
        registerPotionType("leaping", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.JUMP_BOOST, 3600) }));
        registerPotionType("long_leaping", new PotionType("leaping", new PotionEffect[] { new PotionEffect(MobEffects.JUMP_BOOST, 9600) }));
        registerPotionType("strong_leaping", new PotionType("leaping", new PotionEffect[] { new PotionEffect(MobEffects.JUMP_BOOST, 1800, 1) }));
        registerPotionType("fire_resistance", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 3600) }));
        registerPotionType("long_fire_resistance", new PotionType("fire_resistance", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 9600) }));
        registerPotionType("swiftness", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.SPEED, 3600) }));
        registerPotionType("long_swiftness", new PotionType("swiftness", new PotionEffect[] { new PotionEffect(MobEffects.SPEED, 9600) }));
        registerPotionType("strong_swiftness", new PotionType("swiftness", new PotionEffect[] { new PotionEffect(MobEffects.SPEED, 1800, 1) }));
        registerPotionType("slowness", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.SLOWNESS, 1800) }));
        registerPotionType("long_slowness", new PotionType("slowness", new PotionEffect[] { new PotionEffect(MobEffects.SLOWNESS, 4800) }));
        registerPotionType("water_breathing", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.WATER_BREATHING, 3600) }));
        registerPotionType("long_water_breathing", new PotionType("water_breathing", new PotionEffect[] { new PotionEffect(MobEffects.WATER_BREATHING, 9600) }));
        registerPotionType("healing", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.INSTANT_HEALTH, 1) }));
        registerPotionType("strong_healing", new PotionType("healing", new PotionEffect[] { new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 1) }));
        registerPotionType("harming", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.INSTANT_DAMAGE, 1) }));
        registerPotionType("strong_harming", new PotionType("harming", new PotionEffect[] { new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 1) }));
        registerPotionType("poison", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.POISON, 900) }));
        registerPotionType("long_poison", new PotionType("poison", new PotionEffect[] { new PotionEffect(MobEffects.POISON, 1800) }));
        registerPotionType("strong_poison", new PotionType("poison", new PotionEffect[] { new PotionEffect(MobEffects.POISON, 432, 1) }));
        registerPotionType("regeneration", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.REGENERATION, 900) }));
        registerPotionType("long_regeneration", new PotionType("regeneration", new PotionEffect[] { new PotionEffect(MobEffects.REGENERATION, 1800) }));
        registerPotionType("strong_regeneration", new PotionType("regeneration", new PotionEffect[] { new PotionEffect(MobEffects.REGENERATION, 450, 1) }));
        registerPotionType("strength", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.STRENGTH, 3600) }));
        registerPotionType("long_strength", new PotionType("strength", new PotionEffect[] { new PotionEffect(MobEffects.STRENGTH, 9600) }));
        registerPotionType("strong_strength", new PotionType("strength", new PotionEffect[] { new PotionEffect(MobEffects.STRENGTH, 1800, 1) }));
        registerPotionType("weakness", new PotionType(new PotionEffect[] { new PotionEffect(MobEffects.WEAKNESS, 1800) }));
        registerPotionType("long_weakness", new PotionType("weakness", new PotionEffect[] { new PotionEffect(MobEffects.WEAKNESS, 4800) }));
        registerPotionType("luck", new PotionType("luck", new PotionEffect[] { new PotionEffect(MobEffects.LUCK, 6000) }));
        PotionType.REGISTRY.validateKey();
    }
    
    public List<PotionEffect> getEffects() {
        return (List<PotionEffect>)this.effects;
    }
    
    public PotionType(final PotionEffect... lllllllllllIIlIlIIlllIlIlIIIllII) {
        this((String)null, lllllllllllIIlIlIIlllIlIlIIIllII);
    }
    
    public String getNamePrefixed(final String lllllllllllIIlIlIIlllIlIIlllllll) {
        return (this.baseName == null) ? (String.valueOf(lllllllllllIIlIlIIlllIlIIlllllll) + PotionType.REGISTRY.getNameForObject(this).getResourcePath()) : (String.valueOf(lllllllllllIIlIlIIlllIlIIlllllll) + this.baseName);
    }
    
    protected static void registerPotionType(final String lllllllllllIIlIlIIlllIlIIlllIlll, final PotionType lllllllllllIIlIlIIlllIlIIlllIllI) {
        PotionType.REGISTRY.register(PotionType.nextPotionTypeId++, new ResourceLocation(lllllllllllIIlIlIIlllIlIIlllIlll), lllllllllllIIlIlIIlllIlIIlllIllI);
    }
    
    public boolean hasInstantEffect() {
        if (!this.effects.isEmpty()) {
            for (final PotionEffect lllllllllllIIlIlIIlllIlIIllIlllI : this.effects) {
                if (lllllllllllIIlIlIIlllIlIIllIlllI.getPotion().isInstant()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public PotionType(@Nullable final String lllllllllllIIlIlIIlllIlIlIIIIlll, final PotionEffect... lllllllllllIIlIlIIlllIlIlIIIIllI) {
        this.baseName = lllllllllllIIlIlIIlllIlIlIIIIlll;
        this.effects = (ImmutableList<PotionEffect>)ImmutableList.copyOf((Object[])lllllllllllIIlIlIIlllIlIlIIIIllI);
    }
    
    static {
        WATER = new ResourceLocation("empty");
        REGISTRY = new RegistryNamespacedDefaultedByKey<ResourceLocation, PotionType>(PotionType.WATER);
    }
    
    @Nullable
    public static PotionType getPotionTypeForName(final String lllllllllllIIlIlIIlllIlIlIIlIIlI) {
        return PotionType.REGISTRY.getObject(new ResourceLocation(lllllllllllIIlIlIIlllIlIlIIlIIlI));
    }
}
