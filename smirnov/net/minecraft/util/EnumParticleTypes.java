// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import com.google.common.collect.Maps;
import java.util.Set;
import javax.annotation.Nullable;
import java.util.Map;

public enum EnumParticleTypes
{
    SPIT("SPIT", 48, "spit", 48, true), 
    SPELL_INSTANT("SPELL_INSTANT", 14, "instantSpell", 14, false), 
    MOB_APPEARANCE("MOB_APPEARANCE", 41, "mobappearance", 41, true), 
    BLOCK_CRACK("BLOCK_CRACK", 37, "blockcrack", 37, false, 1), 
    ITEM_CRACK("ITEM_CRACK", 36, "iconcrack", 36, false, 2), 
    SNOWBALL("SNOWBALL", 31, "snowballpoof", 31, false), 
    TOWN_AURA("TOWN_AURA", 22, "townaura", 22, false), 
    SUSPENDED("SUSPENDED", 7, "suspended", 7, false);
    
    private final /* synthetic */ int argumentCount;
    
    DRIP_WATER("DRIP_WATER", 18, "dripWater", 18, false), 
    ENCHANTMENT_TABLE("ENCHANTMENT_TABLE", 25, "enchantmenttable", 25, false), 
    ITEM_TAKE("ITEM_TAKE", 40, "take", 40, false), 
    LAVA("LAVA", 27, "lava", 27, false), 
    END_ROD("END_ROD", 43, "endRod", 43, false), 
    SNOW_SHOVEL("SNOW_SHOVEL", 32, "snowshovel", 32, false), 
    FOOTSTEP("FOOTSTEP", 28, "footstep", 28, false);
    
    private static final /* synthetic */ Map<String, EnumParticleTypes> BY_NAME;
    
    SLIME("SLIME", 33, "slime", 33, false);
    
    private final /* synthetic */ boolean shouldIgnoreRange;
    
    CRIT("CRIT", 9, "crit", 9, false), 
    NOTE("NOTE", 23, "note", 23, false);
    
    private final /* synthetic */ String particleName;
    
    TOTEM("TOTEM", 47, "totem", 47, false), 
    DRAGON_BREATH("DRAGON_BREATH", 42, "dragonbreath", 42, false), 
    SWEEP_ATTACK("SWEEP_ATTACK", 45, "sweepAttack", 45, true), 
    FALLING_DUST("FALLING_DUST", 46, "fallingdust", 46, false, 1), 
    VILLAGER_HAPPY("VILLAGER_HAPPY", 21, "happyVillager", 21, false), 
    VILLAGER_ANGRY("VILLAGER_ANGRY", 20, "angryVillager", 20, false), 
    PORTAL("PORTAL", 24, "portal", 24, false), 
    SPELL_MOB_AMBIENT("SPELL_MOB_AMBIENT", 16, "mobSpellAmbient", 16, false), 
    WATER_SPLASH("WATER_SPLASH", 5, "splash", 5, false), 
    FIREWORKS_SPARK("FIREWORKS_SPARK", 3, "fireworksSpark", 3, false), 
    CRIT_MAGIC("CRIT_MAGIC", 10, "magicCrit", 10, false), 
    BARRIER("BARRIER", 35, "barrier", 35, false);
    
    private static final /* synthetic */ Map<Integer, EnumParticleTypes> PARTICLES;
    
    DAMAGE_INDICATOR("DAMAGE_INDICATOR", 44, "damageIndicator", 44, true), 
    WATER_WAKE("WATER_WAKE", 6, "wake", 6, false), 
    SPELL_WITCH("SPELL_WITCH", 17, "witchMagic", 17, false), 
    EXPLOSION_NORMAL("EXPLOSION_NORMAL", 0, "explode", 0, true), 
    EXPLOSION_HUGE("EXPLOSION_HUGE", 2, "hugeexplosion", 2, true), 
    WATER_DROP("WATER_DROP", 39, "droplet", 39, false), 
    REDSTONE("REDSTONE", 30, "reddust", 30, false), 
    SMOKE_NORMAL("SMOKE_NORMAL", 11, "smoke", 11, false), 
    SPELL_MOB("SPELL_MOB", 15, "mobSpell", 15, false), 
    CLOUD("CLOUD", 29, "cloud", 29, false), 
    DRIP_LAVA("DRIP_LAVA", 19, "dripLava", 19, false), 
    BLOCK_DUST("BLOCK_DUST", 38, "blockdust", 38, false, 1), 
    WATER_BUBBLE("WATER_BUBBLE", 4, "bubble", 4, false), 
    EXPLOSION_LARGE("EXPLOSION_LARGE", 1, "largeexplode", 1, true), 
    SPELL("SPELL", 13, "spell", 13, false), 
    HEART("HEART", 34, "heart", 34, false);
    
    private final /* synthetic */ int particleID;
    
    SUSPENDED_DEPTH("SUSPENDED_DEPTH", 8, "depthsuspend", 8, false), 
    SMOKE_LARGE("SMOKE_LARGE", 12, "largesmoke", 12, false), 
    FLAME("FLAME", 26, "flame", 26, false);
    
    public boolean getShouldIgnoreRange() {
        return this.shouldIgnoreRange;
    }
    
    @Nullable
    public static EnumParticleTypes getParticleFromId(final int llllllllllIlllIIlIllIllIIIIIIIII) {
        return EnumParticleTypes.PARTICLES.get(llllllllllIlllIIlIllIllIIIIIIIII);
    }
    
    public int getParticleID() {
        return this.particleID;
    }
    
    public static Set<String> getParticleNames() {
        return EnumParticleTypes.BY_NAME.keySet();
    }
    
    public int getArgumentCount() {
        return this.argumentCount;
    }
    
    static {
        PARTICLES = Maps.newHashMap();
        BY_NAME = Maps.newHashMap();
        final int llllllllllIlllIIlIllIllIIIllIIlI;
        final byte llllllllllIlllIIlIllIllIIIllIIll = (byte)((EnumParticleTypes[])(Object)(llllllllllIlllIIlIllIllIIIllIIlI = (int)(Object)values())).length;
        for (short llllllllllIlllIIlIllIllIIIllIlII = 0; llllllllllIlllIIlIllIllIIIllIlII < llllllllllIlllIIlIllIllIIIllIIll; ++llllllllllIlllIIlIllIllIIIllIlII) {
            final EnumParticleTypes llllllllllIlllIIlIllIllIIIllIllI = llllllllllIlllIIlIllIllIIIllIIlI[llllllllllIlllIIlIllIllIIIllIlII];
            EnumParticleTypes.PARTICLES.put(llllllllllIlllIIlIllIllIIIllIllI.getParticleID(), llllllllllIlllIIlIllIllIIIllIllI);
            EnumParticleTypes.BY_NAME.put(llllllllllIlllIIlIllIllIIIllIllI.getParticleName(), llllllllllIlllIIlIllIllIIIllIllI);
        }
    }
    
    private EnumParticleTypes(final String llllllllllIlllIIlIllIllIIIlIIlII, final int llllllllllIlllIIlIllIllIIIlIIIll, final String llllllllllIlllIIlIllIllIIIlIIIlI, final int llllllllllIlllIIlIllIllIIIlIlIII, final boolean llllllllllIlllIIlIllIllIIIlIIlll, final int llllllllllIlllIIlIllIllIIIIlllll) {
        this.particleName = llllllllllIlllIIlIllIllIIIlIIIlI;
        this.particleID = llllllllllIlllIIlIllIllIIIlIlIII;
        this.shouldIgnoreRange = llllllllllIlllIIlIllIllIIIlIIlll;
        this.argumentCount = llllllllllIlllIIlIllIllIIIIlllll;
    }
    
    public String getParticleName() {
        return this.particleName;
    }
    
    private EnumParticleTypes(final String llllllllllIlllIIlIllIllIIIIlIIll, final int llllllllllIlllIIlIllIllIIIIlIIlI, final String llllllllllIlllIIlIllIllIIIIlIIIl, final int llllllllllIlllIIlIllIllIIIIlIllI, final boolean llllllllllIlllIIlIllIllIIIIIllll) {
        this(llllllllllIlllIIlIllIllIIIIlIIll, llllllllllIlllIIlIllIllIIIIlIIlI, llllllllllIlllIIlIllIllIIIIlIIIl, llllllllllIlllIIlIllIllIIIIlIllI, llllllllllIlllIIlIllIllIIIIIllll, 0);
    }
    
    @Nullable
    public static EnumParticleTypes getByName(final String llllllllllIlllIIlIllIlIllllllllI) {
        return EnumParticleTypes.BY_NAME.get(llllllllllIlllIIlIllIlIllllllllI);
    }
}
