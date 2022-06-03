// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentDamage extends Enchantment
{
    private static final /* synthetic */ int[] LEVEL_ENCHANTABILITY;
    public final /* synthetic */ int damageType;
    private static final /* synthetic */ int[] BASE_ENCHANTABILITY;
    private static final /* synthetic */ int[] THRESHOLD_ENCHANTABILITY;
    private static final /* synthetic */ String[] PROTECTION_NAME;
    
    static {
        PROTECTION_NAME = new String[] { "all", "undead", "arthropods" };
        BASE_ENCHANTABILITY = new int[] { 1, 5, 5 };
        LEVEL_ENCHANTABILITY = new int[] { 11, 8, 8 };
        THRESHOLD_ENCHANTABILITY = new int[] { 20, 20, 20 };
    }
    
    public EnchantmentDamage(final Rarity llllllllllIllllIIIIIlllIIIllIIll, final int llllllllllIllllIIIIIlllIIIlIlllI, final EntityEquipmentSlot... llllllllllIllllIIIIIlllIIIlIllIl) {
        super(llllllllllIllllIIIIIlllIIIllIIll, EnumEnchantmentType.WEAPON, llllllllllIllllIIIIIlllIIIlIllIl);
        this.damageType = llllllllllIllllIIIIIlllIIIlIlllI;
    }
    
    @Override
    public void onEntityDamaged(final EntityLivingBase llllllllllIllllIIIIIllIlllllllII, final Entity llllllllllIllllIIIIIllIllllllIll, final int llllllllllIllllIIIIIllIllllllIlI) {
        if (llllllllllIllllIIIIIllIllllllIll instanceof EntityLivingBase) {
            final EntityLivingBase llllllllllIllllIIIIIllIlllllllll = (EntityLivingBase)llllllllllIllllIIIIIllIllllllIll;
            if (this.damageType == 2 && llllllllllIllllIIIIIllIlllllllll.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD) {
                final int llllllllllIllllIIIIIllIllllllllI = 20 + llllllllllIllllIIIIIllIlllllllII.getRNG().nextInt(10 * llllllllllIllllIIIIIllIllllllIlI);
                llllllllllIllllIIIIIllIlllllllll.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, llllllllllIllllIIIIIllIllllllllI, 3));
            }
        }
    }
    
    public boolean canApplyTogether(final Enchantment llllllllllIllllIIIIIlllIIIIlIIIl) {
        return !(llllllllllIllllIIIIIlllIIIIlIIIl instanceof EnchantmentDamage);
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllIllllIIIIIlllIIIlIlIIl) {
        return EnchantmentDamage.BASE_ENCHANTABILITY[this.damageType] + (llllllllllIllllIIIIIlllIIIlIlIIl - 1) * EnchantmentDamage.LEVEL_ENCHANTABILITY[this.damageType];
    }
    
    @Override
    public float calcDamageByCreature(final int llllllllllIllllIIIIIlllIIIIllIII, final EnumCreatureAttribute llllllllllIllllIIIIIlllIIIIllIlI) {
        if (this.damageType == 0) {
            return 1.0f + Math.max(0, llllllllllIllllIIIIIlllIIIIllIII - 1) * 0.5f;
        }
        if (this.damageType == 1 && llllllllllIllllIIIIIlllIIIIllIlI == EnumCreatureAttribute.UNDEAD) {
            return llllllllllIllllIIIIIlllIIIIllIII * 2.5f;
        }
        return (this.damageType == 2 && llllllllllIllllIIIIIlllIIIIllIlI == EnumCreatureAttribute.ARTHROPOD) ? (llllllllllIllllIIIIIlllIIIIllIII * 2.5f) : 0.0f;
    }
    
    @Override
    public String getName() {
        return "enchantment.damage." + EnchantmentDamage.PROTECTION_NAME[this.damageType];
    }
    
    @Override
    public boolean canApply(final ItemStack llllllllllIllllIIIIIlllIIIIIllII) {
        return llllllllllIllllIIIIIlllIIIIIllII.getItem() instanceof ItemAxe || super.canApply(llllllllllIllllIIIIIlllIIIIIllII);
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllIllllIIIIIlllIIIlIIIll) {
        return this.getMinEnchantability(llllllllllIllllIIIIIlllIIIlIIIll) + EnchantmentDamage.THRESHOLD_ENCHANTABILITY[this.damageType];
    }
}
