// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.item.ItemArmor;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.init.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import java.util.Random;

public class EnchantmentThorns extends Enchantment
{
    public static boolean shouldHit(final int lllllllllllIIIlIlllIllIIIllIIllI, final Random lllllllllllIIIlIlllIllIIIllIIIll) {
        return lllllllllllIIIlIlllIllIIIllIIllI > 0 && lllllllllllIIIlIlllIllIIIllIIIll.nextFloat() < 0.15f * lllllllllllIIIlIlllIllIIIllIIllI;
    }
    
    @Override
    public void onUserHurt(final EntityLivingBase lllllllllllIIIlIlllIllIIIlllIIlI, final Entity lllllllllllIIIlIlllIllIIIlllIIIl, final int lllllllllllIIIlIlllIllIIIlllIIII) {
        final Random lllllllllllIIIlIlllIllIIIllIllll = lllllllllllIIIlIlllIllIIIlllIIlI.getRNG();
        final ItemStack lllllllllllIIIlIlllIllIIIllIlllI = EnchantmentHelper.getEnchantedItem(Enchantments.THORNS, lllllllllllIIIlIlllIllIIIlllIIlI);
        if (shouldHit(lllllllllllIIIlIlllIllIIIlllIIII, lllllllllllIIIlIlllIllIIIllIllll)) {
            if (lllllllllllIIIlIlllIllIIIlllIIIl != null) {
                lllllllllllIIIlIlllIllIIIlllIIIl.attackEntityFrom(DamageSource.causeThornsDamage(lllllllllllIIIlIlllIllIIIlllIIlI), (float)getDamage(lllllllllllIIIlIlllIllIIIlllIIII, lllllllllllIIIlIlllIllIIIllIllll));
            }
            if (!lllllllllllIIIlIlllIllIIIllIlllI.func_190926_b()) {
                lllllllllllIIIlIlllIllIIIllIlllI.damageItem(3, lllllllllllIIIlIlllIllIIIlllIIlI);
            }
        }
        else if (!lllllllllllIIIlIlllIllIIIllIlllI.func_190926_b()) {
            lllllllllllIIIlIlllIllIIIllIlllI.damageItem(1, lllllllllllIIIlIlllIllIIIlllIIlI);
        }
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIIIlIlllIllIIlIIIIIII) {
        return super.getMinEnchantability(lllllllllllIIIlIlllIllIIlIIIIIII) + 50;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllIIIlIlllIllIIlIIIIlll) {
        return 10 + 20 * (lllllllllllIIIlIlllIllIIlIIIIlll - 1);
    }
    
    public EnchantmentThorns(final Rarity lllllllllllIIIlIlllIllIIlIIIlIll, final EntityEquipmentSlot... lllllllllllIIIlIlllIllIIlIIIlIlI) {
        super(lllllllllllIIIlIlllIllIIlIIIlIll, EnumEnchantmentType.ARMOR_CHEST, lllllllllllIIIlIlllIllIIlIIIlIlI);
        this.setName("thorns");
    }
    
    @Override
    public boolean canApply(final ItemStack lllllllllllIIIlIlllIllIIIllllIIl) {
        return lllllllllllIIIlIlllIllIIIllllIIl.getItem() instanceof ItemArmor || super.canApply(lllllllllllIIIlIlllIllIIIllllIIl);
    }
    
    public static int getDamage(final int lllllllllllIIIlIlllIllIIIllIIIII, final Random lllllllllllIIIlIlllIllIIIlIlllIl) {
        return (lllllllllllIIIlIlllIllIIIllIIIII > 10) ? (lllllllllllIIIlIlllIllIIIllIIIII - 10) : (1 + lllllllllllIIIlIlllIllIIIlIlllIl.nextInt(4));
    }
}
