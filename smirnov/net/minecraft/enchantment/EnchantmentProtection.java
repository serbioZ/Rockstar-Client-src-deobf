// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.entity.EntityLivingBase;

public class EnchantmentProtection extends Enchantment
{
    public final /* synthetic */ Type protectionType;
    
    @Override
    public int getMinEnchantability(final int lllllllllllllIlIIIIllIIIlIIllIll) {
        return this.protectionType.getMinimalEnchantability() + (lllllllllllllIlIIIIllIIIlIIllIll - 1) * this.protectionType.getEnchantIncreasePerLevel();
    }
    
    @Override
    public int getMaxLevel() {
        return 4;
    }
    
    public static int getFireTimeForEntity(final EntityLivingBase lllllllllllllIlIIIIllIIIIlllIllI, int lllllllllllllIlIIIIllIIIIlllIlIl) {
        final int lllllllllllllIlIIIIllIIIIlllIlll = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FIRE_PROTECTION, lllllllllllllIlIIIIllIIIIlllIllI);
        if (lllllllllllllIlIIIIllIIIIlllIlll > 0) {
            lllllllllllllIlIIIIllIIIIlllIlIl -= MathHelper.floor(lllllllllllllIlIIIIllIIIIlllIlIl * (float)lllllllllllllIlIIIIllIIIIlllIlll * 0.15f);
        }
        return lllllllllllllIlIIIIllIIIIlllIlIl;
    }
    
    public static double getBlastDamageReduction(final EntityLivingBase lllllllllllllIlIIIIllIIIIllIllIl, double lllllllllllllIlIIIIllIIIIllIllII) {
        final int lllllllllllllIlIIIIllIIIIllIlllI = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.BLAST_PROTECTION, lllllllllllllIlIIIIllIIIIllIllIl);
        if (lllllllllllllIlIIIIllIIIIllIlllI > 0) {
            lllllllllllllIlIIIIllIIIIllIllII -= MathHelper.floor(lllllllllllllIlIIIIllIIIIllIllII * (lllllllllllllIlIIIIllIIIIllIlllI * 0.15f));
        }
        return lllllllllllllIlIIIIllIIIIllIllII;
    }
    
    public boolean canApplyTogether(final Enchantment lllllllllllllIlIIIIllIIIlIIIIIIl) {
        if (lllllllllllllIlIIIIllIIIlIIIIIIl instanceof EnchantmentProtection) {
            final EnchantmentProtection lllllllllllllIlIIIIllIIIlIIIIIII = (EnchantmentProtection)lllllllllllllIlIIIIllIIIlIIIIIIl;
            return this.protectionType != lllllllllllllIlIIIIllIIIlIIIIIII.protectionType && (this.protectionType == Type.FALL || lllllllllllllIlIIIIllIIIlIIIIIII.protectionType == Type.FALL);
        }
        return super.canApplyTogether(lllllllllllllIlIIIIllIIIlIIIIIIl);
    }
    
    @Override
    public int calcModifierDamage(final int lllllllllllllIlIIIIllIIIlIIIllIl, final DamageSource lllllllllllllIlIIIIllIIIlIIIllII) {
        if (lllllllllllllIlIIIIllIIIlIIIllII.canHarmInCreative()) {
            return 0;
        }
        if (this.protectionType == Type.ALL) {
            return lllllllllllllIlIIIIllIIIlIIIllIl;
        }
        if (this.protectionType == Type.FIRE && lllllllllllllIlIIIIllIIIlIIIllII.isFireDamage()) {
            return lllllllllllllIlIIIIllIIIlIIIllIl * 2;
        }
        if (this.protectionType == Type.FALL && lllllllllllllIlIIIIllIIIlIIIllII == DamageSource.fall) {
            return lllllllllllllIlIIIIllIIIlIIIllIl * 3;
        }
        if (this.protectionType == Type.EXPLOSION && lllllllllllllIlIIIIllIIIlIIIllII.isExplosion()) {
            return lllllllllllllIlIIIIllIIIlIIIllIl * 2;
        }
        return (this.protectionType == Type.PROJECTILE && lllllllllllllIlIIIIllIIIlIIIllII.isProjectile()) ? (lllllllllllllIlIIIIllIIIlIIIllIl * 2) : 0;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIlIIIIllIIIlIIlIIll) {
        return this.getMinEnchantability(lllllllllllllIlIIIIllIIIlIIlIIll) + this.protectionType.getEnchantIncreasePerLevel();
    }
    
    public EnchantmentProtection(final Rarity lllllllllllllIlIIIIllIIIlIlIIIIl, final Type lllllllllllllIlIIIIllIIIlIlIIlII, final EntityEquipmentSlot... lllllllllllllIlIIIIllIIIlIIlllll) {
        super(lllllllllllllIlIIIIllIIIlIlIIIIl, EnumEnchantmentType.ARMOR, lllllllllllllIlIIIIllIIIlIIlllll);
        this.protectionType = lllllllllllllIlIIIIllIIIlIlIIlII;
        if (lllllllllllllIlIIIIllIIIlIlIIlII == Type.FALL) {
            this.type = EnumEnchantmentType.ARMOR_FEET;
        }
    }
    
    @Override
    public String getName() {
        return "enchantment.protect." + this.protectionType.getTypeName();
    }
    
    public enum Type
    {
        EXPLOSION("EXPLOSION", 3, "explosion", 5, 8, 12), 
        PROJECTILE("PROJECTILE", 4, "projectile", 3, 6, 15);
        
        private final /* synthetic */ String typeName;
        private final /* synthetic */ int levelCostSpan;
        
        FALL("FALL", 2, "fall", 5, 6, 10);
        
        private final /* synthetic */ int minEnchantability;
        
        FIRE("FIRE", 1, "fire", 10, 8, 12);
        
        private final /* synthetic */ int levelCost;
        
        ALL("ALL", 0, "all", 1, 11, 20);
        
        public int getEnchantIncreasePerLevel() {
            return this.levelCost;
        }
        
        public int getMinimalEnchantability() {
            return this.minEnchantability;
        }
        
        private Type(final String lllllllllllllIIlIIlIllIIIIIIIIIl, final int lllllllllllllIIlIIlIllIIIIIIIIII, final String lllllllllllllIIlIIlIlIllllllllll, final int lllllllllllllIIlIIlIllIIIIIIIlIl, final int lllllllllllllIIlIIlIllIIIIIIIlII, final int lllllllllllllIIlIIlIlIllllllllII) {
            this.typeName = lllllllllllllIIlIIlIlIllllllllll;
            this.minEnchantability = lllllllllllllIIlIIlIllIIIIIIIlIl;
            this.levelCost = lllllllllllllIIlIIlIllIIIIIIIlII;
            this.levelCostSpan = lllllllllllllIIlIIlIlIllllllllII;
        }
        
        public String getTypeName() {
            return this.typeName;
        }
    }
}
