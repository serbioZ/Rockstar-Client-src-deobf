// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.potion;

import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import com.google.common.collect.Maps;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;

public class Potion
{
    public static final /* synthetic */ RegistryNamespaced<ResourceLocation, Potion> REGISTRY;
    private /* synthetic */ String name;
    private final /* synthetic */ Map<IAttribute, AttributeModifier> attributeModifierMap;
    private final /* synthetic */ boolean isBadEffect;
    private final /* synthetic */ int liquidColor;
    private /* synthetic */ double effectiveness;
    private /* synthetic */ int statusIconIndex;
    private /* synthetic */ boolean beneficial;
    
    public static void registerPotions() {
        Potion.REGISTRY.register(1, new ResourceLocation("speed"), new Potion(false, 8171462).setPotionName("effect.moveSpeed").setIconIndex(0, 0).registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224, 2).setBeneficial());
        Potion.REGISTRY.register(2, new ResourceLocation("slowness"), new Potion(true, 5926017).setPotionName("effect.moveSlowdown").setIconIndex(1, 0).registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448, 2));
        Potion.REGISTRY.register(3, new ResourceLocation("haste"), new Potion(false, 14270531).setPotionName("effect.digSpeed").setIconIndex(2, 0).setEffectiveness(1.5).setBeneficial().registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 0.10000000149011612, 2));
        Potion.REGISTRY.register(4, new ResourceLocation("mining_fatigue"), new Potion(true, 4866583).setPotionName("effect.digSlowDown").setIconIndex(3, 0).registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, "55FCED67-E92A-486E-9800-B47F202C4386", -0.10000000149011612, 2));
        Potion.REGISTRY.register(5, new ResourceLocation("strength"), new PotionAttackDamage(false, 9643043, 3.0).setPotionName("effect.damageBoost").setIconIndex(4, 0).registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 0.0, 0).setBeneficial());
        Potion.REGISTRY.register(6, new ResourceLocation("instant_health"), new PotionHealth(false, 16262179).setPotionName("effect.heal").setBeneficial());
        Potion.REGISTRY.register(7, new ResourceLocation("instant_damage"), new PotionHealth(true, 4393481).setPotionName("effect.harm").setBeneficial());
        Potion.REGISTRY.register(8, new ResourceLocation("jump_boost"), new Potion(false, 2293580).setPotionName("effect.jump").setIconIndex(2, 1).setBeneficial());
        Potion.REGISTRY.register(9, new ResourceLocation("nausea"), new Potion(true, 5578058).setPotionName("effect.confusion").setIconIndex(3, 1).setEffectiveness(0.25));
        Potion.REGISTRY.register(10, new ResourceLocation("regeneration"), new Potion(false, 13458603).setPotionName("effect.regeneration").setIconIndex(7, 0).setEffectiveness(0.25).setBeneficial());
        Potion.REGISTRY.register(11, new ResourceLocation("resistance"), new Potion(false, 10044730).setPotionName("effect.resistance").setIconIndex(6, 1).setBeneficial());
        Potion.REGISTRY.register(12, new ResourceLocation("fire_resistance"), new Potion(false, 14981690).setPotionName("effect.fireResistance").setIconIndex(7, 1).setBeneficial());
        Potion.REGISTRY.register(13, new ResourceLocation("water_breathing"), new Potion(false, 3035801).setPotionName("effect.waterBreathing").setIconIndex(0, 2).setBeneficial());
        Potion.REGISTRY.register(14, new ResourceLocation("invisibility"), new Potion(false, 8356754).setPotionName("effect.invisibility").setIconIndex(0, 1).setBeneficial());
        Potion.REGISTRY.register(15, new ResourceLocation("blindness"), new Potion(true, 2039587).setPotionName("effect.blindness").setIconIndex(5, 1).setEffectiveness(0.25));
        Potion.REGISTRY.register(16, new ResourceLocation("night_vision"), new Potion(false, 2039713).setPotionName("effect.nightVision").setIconIndex(4, 1).setBeneficial());
        Potion.REGISTRY.register(17, new ResourceLocation("hunger"), new Potion(true, 5797459).setPotionName("effect.hunger").setIconIndex(1, 1));
        Potion.REGISTRY.register(18, new ResourceLocation("weakness"), new PotionAttackDamage(true, 4738376, -4.0).setPotionName("effect.weakness").setIconIndex(5, 0).registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, "22653B89-116E-49DC-9B6B-9971489B5BE5", 0.0, 0));
        Potion.REGISTRY.register(19, new ResourceLocation("poison"), new Potion(true, 5149489).setPotionName("effect.poison").setIconIndex(6, 0).setEffectiveness(0.25));
        Potion.REGISTRY.register(20, new ResourceLocation("wither"), new Potion(true, 3484199).setPotionName("effect.wither").setIconIndex(1, 2).setEffectiveness(0.25));
        Potion.REGISTRY.register(21, new ResourceLocation("health_boost"), new PotionHealthBoost(false, 16284963).setPotionName("effect.healthBoost").setIconIndex(7, 2).registerPotionAttributeModifier(SharedMonsterAttributes.MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0, 0).setBeneficial());
        Potion.REGISTRY.register(22, new ResourceLocation("absorption"), new PotionAbsorption(false, 2445989).setPotionName("effect.absorption").setIconIndex(2, 2).setBeneficial());
        Potion.REGISTRY.register(23, new ResourceLocation("saturation"), new PotionHealth(false, 16262179).setPotionName("effect.saturation").setBeneficial());
        Potion.REGISTRY.register(24, new ResourceLocation("glowing"), new Potion(false, 9740385).setPotionName("effect.glowing").setIconIndex(4, 2));
        Potion.REGISTRY.register(25, new ResourceLocation("levitation"), new Potion(true, 13565951).setPotionName("effect.levitation").setIconIndex(3, 2));
        Potion.REGISTRY.register(26, new ResourceLocation("luck"), new Potion(false, 3381504).setPotionName("effect.luck").setIconIndex(5, 2).setBeneficial().registerPotionAttributeModifier(SharedMonsterAttributes.LUCK, "03C3C89D-7037-4B42-869F-B146BCB64D2E", 1.0, 0));
        Potion.REGISTRY.register(27, new ResourceLocation("unluck"), new Potion(true, 12624973).setPotionName("effect.unluck").setIconIndex(6, 2).registerPotionAttributeModifier(SharedMonsterAttributes.LUCK, "CC5AF142-2BD2-4215-B636-2605AED11727", -1.0, 0));
    }
    
    public boolean isReady(final int lllllllllllIIIlIllIIIIllIIIllIll, final int lllllllllllIIIlIllIIIIllIIIllIlI) {
        if (this == MobEffects.REGENERATION) {
            final int lllllllllllIIIlIllIIIIllIIIllIIl = 50 >> lllllllllllIIIlIllIIIIllIIIllIlI;
            return lllllllllllIIIlIllIIIIllIIIllIIl <= 0 || lllllllllllIIIlIllIIIIllIIIllIll % lllllllllllIIIlIllIIIIllIIIllIIl == 0;
        }
        if (this == MobEffects.POISON) {
            final int lllllllllllIIIlIllIIIIllIIIllIII = 25 >> lllllllllllIIIlIllIIIIllIIIllIlI;
            return lllllllllllIIIlIllIIIIllIIIllIII <= 0 || lllllllllllIIIlIllIIIIllIIIllIll % lllllllllllIIIlIllIIIIllIIIllIII == 0;
        }
        if (this == MobEffects.WITHER) {
            final int lllllllllllIIIlIllIIIIllIIIlIlll = 40 >> lllllllllllIIIlIllIIIIllIIIllIlI;
            return lllllllllllIIIlIllIIIIllIIIlIlll <= 0 || lllllllllllIIIlIllIIIIllIIIllIll % lllllllllllIIIlIllIIIIllIIIlIlll == 0;
        }
        return this == MobEffects.HUNGER;
    }
    
    public static String getPotionDurationString(final PotionEffect lllllllllllIIIlIllIIIIlIllllllII, final float lllllllllllIIIlIllIIIIlIlllllIll) {
        if (lllllllllllIIIlIllIIIIlIllllllII.getIsPotionDurationMax()) {
            return "**:**";
        }
        final int lllllllllllIIIlIllIIIIlIlllllIlI = MathHelper.floor(lllllllllllIIIlIllIIIIlIllllllII.getDuration() * lllllllllllIIIlIllIIIIlIlllllIll);
        return StringUtils.ticksToElapsedTime(lllllllllllIIIlIllIIIIlIlllllIlI);
    }
    
    static {
        REGISTRY = new RegistryNamespaced<ResourceLocation, Potion>();
    }
    
    protected Potion setIconIndex(final int lllllllllllIIIlIllIIIIllIlIIIIIl, final int lllllllllllIIIlIllIIIIllIlIIIIll) {
        this.statusIconIndex = lllllllllllIIIlIllIIIIllIlIIIIIl + lllllllllllIIIlIllIIIIllIlIIIIll * 8;
        return this;
    }
    
    public boolean hasStatusIcon() {
        return this.statusIconIndex >= 0;
    }
    
    public void removeAttributesModifiersFromEntity(final EntityLivingBase lllllllllllIIIlIllIIIIlIllIlIIlI, final AbstractAttributeMap lllllllllllIIIlIllIIIIlIllIlIIIl, final int lllllllllllIIIlIllIIIIlIllIlIIII) {
        for (final Map.Entry<IAttribute, AttributeModifier> lllllllllllIIIlIllIIIIlIllIIllll : this.attributeModifierMap.entrySet()) {
            final IAttributeInstance lllllllllllIIIlIllIIIIlIllIIlllI = lllllllllllIIIlIllIIIIlIllIlIIIl.getAttributeInstance(lllllllllllIIIlIllIIIIlIllIIllll.getKey());
            if (lllllllllllIIIlIllIIIIlIllIIlllI != null) {
                lllllllllllIIIlIllIIIIlIllIIlllI.removeModifier(lllllllllllIIIlIllIIIIlIllIIllll.getValue());
            }
        }
    }
    
    public Potion registerPotionAttributeModifier(final IAttribute lllllllllllIIIlIllIIIIlIlllIIIII, final String lllllllllllIIIlIllIIIIlIlllIIlIl, final double lllllllllllIIIlIllIIIIlIlllIIlII, final int lllllllllllIIIlIllIIIIlIllIlllIl) {
        final AttributeModifier lllllllllllIIIlIllIIIIlIlllIIIlI = new AttributeModifier(UUID.fromString(lllllllllllIIIlIllIIIIlIlllIIlIl), this.getName(), lllllllllllIIIlIllIIIIlIlllIIlII, lllllllllllIIIlIllIIIIlIllIlllIl);
        this.attributeModifierMap.put(lllllllllllIIIlIllIIIIlIlllIIIII, lllllllllllIIIlIllIIIIlIlllIIIlI);
        return this;
    }
    
    public boolean isInstant() {
        return false;
    }
    
    public void performEffect(final EntityLivingBase lllllllllllIIIlIllIIIIllIIlllIll, final int lllllllllllIIIlIllIIIIllIIlllIlI) {
        if (this == MobEffects.REGENERATION) {
            if (lllllllllllIIIlIllIIIIllIIlllIll.getHealth() < lllllllllllIIIlIllIIIIllIIlllIll.getMaxHealth()) {
                lllllllllllIIIlIllIIIIllIIlllIll.heal(1.0f);
            }
        }
        else if (this == MobEffects.POISON) {
            if (lllllllllllIIIlIllIIIIllIIlllIll.getHealth() > 1.0f) {
                lllllllllllIIIlIllIIIIllIIlllIll.attackEntityFrom(DamageSource.magic, 1.0f);
            }
        }
        else if (this == MobEffects.WITHER) {
            lllllllllllIIIlIllIIIIllIIlllIll.attackEntityFrom(DamageSource.wither, 1.0f);
        }
        else if (this == MobEffects.HUNGER && lllllllllllIIIlIllIIIIllIIlllIll instanceof EntityPlayer) {
            ((EntityPlayer)lllllllllllIIIlIllIIIIllIIlllIll).addExhaustion(0.005f * (lllllllllllIIIlIllIIIIllIIlllIlI + 1));
        }
        else if (this == MobEffects.SATURATION && lllllllllllIIIlIllIIIIllIIlllIll instanceof EntityPlayer) {
            if (!lllllllllllIIIlIllIIIIllIIlllIll.world.isRemote) {
                ((EntityPlayer)lllllllllllIIIlIllIIIIllIIlllIll).getFoodStats().addStats(lllllllllllIIIlIllIIIIllIIlllIlI + 1, 1.0f);
            }
        }
        else if ((this != MobEffects.INSTANT_HEALTH || lllllllllllIIIlIllIIIIllIIlllIll.isEntityUndead()) && (this != MobEffects.INSTANT_DAMAGE || !lllllllllllIIIlIllIIIIllIIlllIll.isEntityUndead())) {
            if ((this == MobEffects.INSTANT_DAMAGE && !lllllllllllIIIlIllIIIIllIIlllIll.isEntityUndead()) || (this == MobEffects.INSTANT_HEALTH && lllllllllllIIIlIllIIIIllIIlllIll.isEntityUndead())) {
                lllllllllllIIIlIllIIIIllIIlllIll.attackEntityFrom(DamageSource.magic, (float)(6 << lllllllllllIIIlIllIIIIllIIlllIlI));
            }
        }
        else {
            lllllllllllIIIlIllIIIIllIIlllIll.heal((float)Math.max(4 << lllllllllllIIIlIllIIIIllIIlllIlI, 0));
        }
    }
    
    public int getStatusIconIndex() {
        return this.statusIconIndex;
    }
    
    public static int getIdFromPotion(final Potion lllllllllllIIIlIllIIIIllIlIlllII) {
        return Potion.REGISTRY.getIDForObject(lllllllllllIIIlIllIIIIllIlIlllII);
    }
    
    public void applyAttributesModifiersToEntity(final EntityLivingBase lllllllllllIIIlIllIIIIlIllIIIIII, final AbstractAttributeMap lllllllllllIIIlIllIIIIlIlIlllIIl, final int lllllllllllIIIlIllIIIIlIlIlllllI) {
        for (final Map.Entry<IAttribute, AttributeModifier> lllllllllllIIIlIllIIIIlIlIllllIl : this.attributeModifierMap.entrySet()) {
            final IAttributeInstance lllllllllllIIIlIllIIIIlIlIllllII = lllllllllllIIIlIllIIIIlIlIlllIIl.getAttributeInstance(lllllllllllIIIlIllIIIIlIlIllllIl.getKey());
            if (lllllllllllIIIlIllIIIIlIlIllllII != null) {
                final AttributeModifier lllllllllllIIIlIllIIIIlIlIlllIll = lllllllllllIIIlIllIIIIlIlIllllIl.getValue();
                lllllllllllIIIlIllIIIIlIlIllllII.removeModifier(lllllllllllIIIlIllIIIIlIlIlllIll);
                lllllllllllIIIlIllIIIIlIlIllllII.applyModifier(new AttributeModifier(lllllllllllIIIlIllIIIIlIlIlllIll.getID(), String.valueOf(this.getName()) + " " + lllllllllllIIIlIllIIIIlIlIlllllI, this.getAttributeModifierAmount(lllllllllllIIIlIllIIIIlIlIlllllI, lllllllllllIIIlIllIIIIlIlIlllIll), lllllllllllIIIlIllIIIIlIlIlllIll.getOperation()));
            }
        }
    }
    
    public Potion setBeneficial() {
        this.beneficial = true;
        return this;
    }
    
    public boolean isBadEffect() {
        return this.isBadEffect;
    }
    
    public int getLiquidColor() {
        return this.liquidColor;
    }
    
    public boolean isBeneficial() {
        return this.beneficial;
    }
    
    public Map<IAttribute, AttributeModifier> getAttributeModifierMap() {
        return this.attributeModifierMap;
    }
    
    protected Potion setEffectiveness(final double lllllllllllIIIlIllIIIIlIllllIIIl) {
        this.effectiveness = lllllllllllIIIlIllIIIIlIllllIIIl;
        return this;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getAttributeModifierAmount(final int lllllllllllIIIlIllIIIIlIlIlIlllI, final AttributeModifier lllllllllllIIIlIllIIIIlIlIlIllIl) {
        return lllllllllllIIIlIllIIIIlIlIlIllIl.getAmount() * (lllllllllllIIIlIllIIIIlIlIlIlllI + 1);
    }
    
    public Potion setPotionName(final String lllllllllllIIIlIllIIIIllIIIIllII) {
        this.name = lllllllllllIIIlIllIIIIllIIIIllII;
        return this;
    }
    
    protected Potion(final boolean lllllllllllIIIlIllIIIIllIlIlIIII, final int lllllllllllIIIlIllIIIIllIlIlIIlI) {
        this.attributeModifierMap = (Map<IAttribute, AttributeModifier>)Maps.newHashMap();
        this.name = "";
        this.statusIconIndex = -1;
        this.isBadEffect = lllllllllllIIIlIllIIIIllIlIlIIII;
        if (lllllllllllIIIlIllIIIIllIlIlIIII) {
            this.effectiveness = 0.5;
        }
        else {
            this.effectiveness = 1.0;
        }
        this.liquidColor = lllllllllllIIIlIllIIIIllIlIlIIlI;
    }
    
    public void affectEntity(@Nullable final Entity lllllllllllIIIlIllIIIIllIIlIIllI, @Nullable final Entity lllllllllllIIIlIllIIIIllIIlIllIl, final EntityLivingBase lllllllllllIIIlIllIIIIllIIlIIlII, final int lllllllllllIIIlIllIIIIllIIlIlIll, final double lllllllllllIIIlIllIIIIllIIlIlIlI) {
        if ((this != MobEffects.INSTANT_HEALTH || lllllllllllIIIlIllIIIIllIIlIIlII.isEntityUndead()) && (this != MobEffects.INSTANT_DAMAGE || !lllllllllllIIIlIllIIIIllIIlIIlII.isEntityUndead())) {
            if ((this == MobEffects.INSTANT_DAMAGE && !lllllllllllIIIlIllIIIIllIIlIIlII.isEntityUndead()) || (this == MobEffects.INSTANT_HEALTH && lllllllllllIIIlIllIIIIllIIlIIlII.isEntityUndead())) {
                final int lllllllllllIIIlIllIIIIllIIlIlIIl = (int)(lllllllllllIIIlIllIIIIllIIlIlIlI * (6 << lllllllllllIIIlIllIIIIllIIlIlIll) + 0.5);
                if (lllllllllllIIIlIllIIIIllIIlIIllI == null) {
                    lllllllllllIIIlIllIIIIllIIlIIlII.attackEntityFrom(DamageSource.magic, (float)lllllllllllIIIlIllIIIIllIIlIlIIl);
                }
                else {
                    lllllllllllIIIlIllIIIIllIIlIIlII.attackEntityFrom(DamageSource.causeIndirectMagicDamage(lllllllllllIIIlIllIIIIllIIlIIllI, lllllllllllIIIlIllIIIIllIIlIllIl), (float)lllllllllllIIIlIllIIIIllIIlIlIIl);
                }
            }
        }
        else {
            final int lllllllllllIIIlIllIIIIllIIlIlIII = (int)(lllllllllllIIIlIllIIIIllIIlIlIlI * (4 << lllllllllllIIIlIllIIIIllIIlIlIll) + 0.5);
            lllllllllllIIIlIllIIIIllIIlIIlII.heal((float)lllllllllllIIIlIllIIIIllIIlIlIII);
        }
    }
    
    @Nullable
    public static Potion getPotionById(final int lllllllllllIIIlIllIIIIllIlIlllll) {
        return Potion.REGISTRY.getObjectById(lllllllllllIIIlIllIIIIllIlIlllll);
    }
    
    @Nullable
    public static Potion getPotionFromResourceLocation(final String lllllllllllIIIlIllIIIIllIlIllIIl) {
        return Potion.REGISTRY.getObject(new ResourceLocation(lllllllllllIIIlIllIIIIllIlIllIIl));
    }
    
    public static String getDurationString(final PotionEffect lllllllllllIIIlIllIIIIllIlIIllII) {
        if (lllllllllllIIIlIllIIIIllIlIIllII.getIsPotionDurationMax()) {
            return "**:**";
        }
        final int lllllllllllIIIlIllIIIIllIlIIlIll = lllllllllllIIIlIllIIIIllIlIIllII.getDuration();
        return StringUtils.ticksToElapsedTime(lllllllllllIIIlIllIIIIllIlIIlIll);
    }
}
